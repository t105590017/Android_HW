package com.example.gging.hw6;


import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class game_main extends Fragment {

    public enum GameResultType{
        TYPE_1,TYPE_2,HIDE
    }

    public interface CallbackInterface {
        public void updateGameResult(int iCountTSet,
                                     int iCountPWin,
                                     int iCountCWin,
                                     int iCountDraw);
        public void enableGameResult(GameResultType type);
    }

    private  CallbackInterface mCallback;

    private ImageView mImgRollingDice;
    private TextView mTxtDiceResult;
    private Button mBtnRollDice,
                    mBtnShowResult,
                    mBtnShowResult2,
                    mBtnHideResult;

    private int miCountTSet = 0,
                miCountPWin = 0,
                miCountCWin = 0,
                miCountDraw = 0;

    public game_main() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (CallbackInterface) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + "must implement GameFragment.CallbackInterface.");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mImgRollingDice = (ImageView) getView().findViewById(R.id.imgRollingDice);
        mTxtDiceResult = (TextView) getView().findViewById(R.id.txtDiceResult);
        mBtnRollDice = (Button) getView().findViewById(R.id.btnRollDice);
        mBtnShowResult = (Button) getView().findViewById(R.id.btnShowResult);
        mBtnShowResult2 = (Button) getView().findViewById(R.id.btnShowResult2);
        mBtnHideResult = (Button) getView().findViewById(R.id.btnHiddenResult);

        mBtnRollDice.setOnClickListener(BtnRollDiceOnClick);
        mBtnHideResult.setOnClickListener(BtnHideResultOnChick);
        mBtnShowResult.setOnClickListener(BtnShowResultOnChick);
        mBtnShowResult2.setOnClickListener(BtnShowResult2OnChick);
    }

    private View.OnClickListener BtnShowResultOnChick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mCallback.enableGameResult(GameResultType.TYPE_1);
        }
    };

    private View.OnClickListener BtnShowResult2OnChick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mCallback.enableGameResult(GameResultType.TYPE_2);
        }
    };

    private View.OnClickListener BtnHideResultOnChick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mCallback.enableGameResult(GameResultType.HIDE);
        }
    };

    private View.OnClickListener BtnRollDiceOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mTxtDiceResult.setText(getString(R.string.dice_result));

            miCountTSet++;
            Resources res = getResources();
            final AnimationDrawable animDraw = (AnimationDrawable) res.getDrawable(R.drawable.anim_roll_dice);
            mImgRollingDice.setImageDrawable(animDraw);
            animDraw.start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);

                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    animDraw.stop();
                    mHandler.sendMessage(mHandler.obtainMessage());
                    //mCallback.updateGameResult(miCountTSet,miCountCWin,miCountPWin,miCountDraw);
                }
            }).start();

        }
    };

    private static class StaticHandler extends Handler {
        private final WeakReference<game_main> mActivity;

        public StaticHandler(game_main activity) {
            mActivity = new WeakReference<game_main>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            game_main activity = mActivity.get();
            if (activity == null) return;

            int iRand = (int)(Math.random()*6+1);

            String s =activity.getString(R.string.dice_result);
            activity.mTxtDiceResult.setText(s + iRand);
            if(iRand > 4) {
                activity.miCountCWin++;
            }else if(iRand <3) {
                activity.miCountPWin++;
            }else {
                activity.miCountDraw++;
            }
            switch (iRand) {
                case 1:
                    activity.mImgRollingDice.setImageResource(R.drawable.dice01);
                    break;
                case 2:
                    activity.mImgRollingDice.setImageResource(R.drawable.dice02);
                    break;
                case 3:
                    activity.mImgRollingDice.setImageResource(R.drawable.dice03);
                    break;
                case 4:
                    activity.mImgRollingDice.setImageResource(R.drawable.dice04);
                    break;
                case 5:
                    activity.mImgRollingDice.setImageResource(R.drawable.dice05);
                    break;
                case 6:
                    activity.mImgRollingDice.setImageResource(R.drawable.dice06);
                    break;
            }
            activity.mCallback.updateGameResult(activity.miCountTSet,
                                                activity.miCountPWin,
                                                activity.miCountCWin,
                                                activity.miCountDraw);
        }
    }

    public final StaticHandler mHandler = new StaticHandler(this);
}
