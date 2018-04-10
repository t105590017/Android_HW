package com.example.gging.hw42;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView _TxtComPlay, _TxtResual;
    private Button _BtnScissors, _BtnStone, _BtnPaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _TxtComPlay = (TextView)findViewById(R.id.txtComPlay);
        _TxtResual = (TextView)findViewById(R.id.txtRwsult);
        _BtnScissors = (Button)findViewById(R.id.btnScisorss);
        _BtnStone = (Button)findViewById(R.id.btnStone);
        _BtnPaper = (Button)findViewById(R.id.btnPaper);

        _BtnScissors.setOnClickListener(BtnScissorOnClick);
        _BtnStone.setOnClickListener(BtnStoneOnClick);
        _BtnPaper.setOnClickListener(BtnPaperOnclick);
    }

    private View.OnClickListener BtnScissorOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int Com = (int)(Math.random()*3+1);
            WINorLOSE Judge = new WINorLOSE();
            String ComS = "";

            switch (Com){
                case 1:
                    ComS = "剪刀";
                    break;
                case 2:
                    ComS = "石頭";
                    break;
                case 3:
                    ComS = "布";
                    break;
            }
            _TxtComPlay.setText(ComS);
            _TxtResual.setText(Judge.getWINorLOSE(ComS,"剪刀"));
        }
    };

    private View.OnClickListener BtnStoneOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int Com = (int)(Math.random()*3+1);
            WINorLOSE Judge = new WINorLOSE();
            String ComS = "";

            switch (Com){
                case 1:
                    ComS = "剪刀";
                    break;
                case 2:
                    ComS = "石頭";
                    break;
                case 3:
                    ComS = "布";
                    break;
            }
            _TxtComPlay.setText(ComS);
            _TxtResual.setText(Judge.getWINorLOSE(ComS,"石頭"));
        }
    };

    private View.OnClickListener BtnPaperOnclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int Com = (int)(Math.random()*3+1);
            WINorLOSE Judge = new WINorLOSE();
            String ComS = "";

            switch (Com){
                case 1:
                    ComS = "剪刀";
                    break;
                case 2:
                    ComS = "石頭";
                    break;
                case 3:
                    ComS = "布";
                    break;
            }
            _TxtComPlay.setText(ComS);
            _TxtResual.setText(Judge.getWINorLOSE(ComS,"布"));
        }
    };
}
