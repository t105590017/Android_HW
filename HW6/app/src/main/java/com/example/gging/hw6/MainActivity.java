package com.example.gging.hw6;

//import android.app.Fragment;
import android.support.v4.app.Fragment;
//import android.app.FragmentManager;
import android.support.v4.app.FragmentManager;
//import android.app.FragmentTransaction;
import android.support.v4.app.FragmentTransaction;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements game_main.CallbackInterface{

    private  final static String TAG = "Result";
    private int mTagCount = 0;
    public game_main.GameResultType mGameResultType;
    public Fragment fragResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void updateGameResult(int iCountTSet, int iCountPWin, int iCountCWin, int iCountDraw) {
        if(findViewById(R.id.frameLay).isShown()) {
            switch (mGameResultType){
                case TYPE_1:
                    ((game_result) fragResult).updateGameResult(iCountTSet,iCountPWin,iCountCWin,iCountDraw);
                    break;
                case TYPE_2:
                    ((game_result2) fragResult).updateGameResult(iCountTSet,iCountPWin,iCountCWin,iCountDraw);
                    break;
            }
        }
    }

    @Override
    public void enableGameResult(game_main.GameResultType type) {
        FragmentTransaction fragTran;
        String sFragTran;

        switch (type) {
            case TYPE_1:
                game_result frag = new game_result();
                fragTran = getSupportFragmentManager().beginTransaction();
                mTagCount++;
                sFragTran = TAG + new Integer(mTagCount).toString();
                fragTran.replace(R.id.frameLay,frag,sFragTran);
                fragTran.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragTran.addToBackStack(null);
                fragTran.commit();
                break;
            case TYPE_2:
                game_result2 frag2 = new game_result2();
                fragTran = getSupportFragmentManager().beginTransaction();
                mTagCount++;
                sFragTran = TAG + new Integer(mTagCount).toString();
                fragTran.replace(R.id.frameLay,frag2,sFragTran);
                fragTran.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragTran.addToBackStack(null);
                fragTran.commit();
                break;
            case HIDE:
                FragmentManager fragMgr = getSupportFragmentManager();
                sFragTran = TAG + new Integer(mTagCount).toString();
                Fragment fragGameResult = fragMgr.findFragmentByTag(sFragTran);
                fragTran = fragMgr.beginTransaction();
                fragTran.remove(fragGameResult);
                fragTran.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragTran.addToBackStack(null);
                fragTran.commit();
                break;
        }
    }
}
