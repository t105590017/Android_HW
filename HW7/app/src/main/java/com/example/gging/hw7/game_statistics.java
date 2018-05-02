package com.example.gging.hw7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class game_statistics extends AppCompatActivity {

    TextView mTxtTSet,
            mTxtPWin,
            mTxtCWin,
            mTxtDraw;
    Button mBtnPlayGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_statistics);

        Bundle bundle = getIntent().getExtras();
        String sTSet = bundle.getString("TSet");
        String sPWin = bundle.getString("PWin");
        String sCWin = bundle.getString("CWin");
        String sDraw = bundle.getString("Draw");

        mBtnPlayGame = (Button) findViewById(R.id.btnPlayGame);
        mTxtTSet = (TextView) findViewById(R.id.txtTotalSet);
        mTxtPWin = (TextView) findViewById(R.id.txtPWinSet);
        mTxtCWin = (TextView) findViewById(R.id.txtCWinSet);
        mTxtDraw = (TextView) findViewById(R.id.txtDrawSet);

        mBtnPlayGame.setOnClickListener(BtnPlayGameOnClick);

        mTxtTSet.setText(mTxtTSet.getText() + sTSet);
        mTxtPWin.setText(mTxtPWin.getText() + sPWin);
        mTxtCWin.setText(mTxtCWin.getText() + sCWin);
        mTxtDraw.setText(mTxtDraw.getText() + sDraw);
    }

    private View.OnClickListener BtnPlayGameOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(game_statistics.this,MainActivity.class);

            startActivity(intent);
        }
    };
}
