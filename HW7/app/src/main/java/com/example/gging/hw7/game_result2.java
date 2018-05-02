package com.example.gging.hw7;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class game_result2 extends Fragment {

    private EditText mEdtCountTSet,
                        mEdtCountPWin,
                        mEdtCountCWin,
                        mEdtCountDraw;
    public game_result2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_result2, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        mEdtCountTSet = (EditText) getActivity().findViewById(R.id.edtCountTSet);
        mEdtCountPWin = (EditText) getActivity().findViewById(R.id.edtCountPWin);
        mEdtCountCWin = (EditText) getActivity().findViewById(R.id.edtCountCWin);
        mEdtCountDraw = (EditText) getActivity().findViewById(R.id.edtCountDraw);

        ((MainActivity) getActivity()).mGameResultType = game_main.GameResultType.TYPE_2;
        ((MainActivity) getActivity()).fragResult = this;

        getActivity().findViewById(R.id.frameLay).setVisibility(View.VISIBLE);
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().findViewById(R.id.frameLay).setVisibility(View.GONE);
    }

    public void updateGameResult(int iCountTSet,
                                 int iCountPWin,
                                 int iCountCWin,
                                 int iCountDraw) {
        mEdtCountDraw.setText(String.valueOf(iCountDraw));
        mEdtCountPWin.setText(String.valueOf(iCountPWin));
        mEdtCountCWin.setText(String.valueOf(iCountCWin));
        mEdtCountTSet.setText(String.valueOf(iCountTSet));
    }
}
