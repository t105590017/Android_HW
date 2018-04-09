package com.example.gging.hw41;

import android.app.assist.AssistStructure;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox _chkMusic,_chkSing,_chkDance,_chkTravel
            ,_chkReading,_chkWriting,_chkClimbing,_chkSwim
            ,_chkEating,_chkDrawing;
    private Button _btnOK;
    private TextView _textSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _chkMusic = (CheckBox) findViewById(R.id.chkMusic);
        _chkSing = (CheckBox) findViewById(R.id.chkSing);
        _chkDance = (CheckBox) findViewById(R.id.chkDance);
        _chkTravel = (CheckBox) findViewById(R.id.chkTravel);
        _chkReading = (CheckBox) findViewById(R.id.chkReading);
        _chkWriting = (CheckBox)findViewById(R.id.chkWriting);
        _chkClimbing = (CheckBox) findViewById(R.id.chkClimbing);
        _chkSwim = (CheckBox) findViewById(R.id.chkSwim);
        _chkEating = (CheckBox) findViewById(R.id.chkEating);
        _chkDrawing = (CheckBox) findViewById(R.id.chkDrawing);

        _btnOK = (Button) findViewById(R.id.btnOK);
        _textSelect = (TextView) findViewById(R.id.txtSelect);

        _btnOK.setOnClickListener(btnOKOnclick);
    }

    private View.OnClickListener btnOKOnclick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            String s = getString(R.string.select);

            if (_chkMusic.isChecked())
                s += _chkMusic.getText().toString();
            if (_chkSing.isChecked())
                s += _chkSing.getText().toString();
            if (_chkDance.isChecked())
                s += _chkDance.getText().toString();
            if (_chkTravel.isChecked())
                s += _chkTravel.getText().toString();
            if (_chkReading.isChecked())
                s += _chkReading.getText().toString();
            if (_chkWriting.isChecked())
                s += _chkWriting.getText().toString();
            if (_chkClimbing.isChecked())
                s += _chkClimbing.getText().toString();
            if (_chkSwim.isChecked())
                s += _chkSwim.getText().toString();
            if (_chkEating.isChecked())
                s += _chkEating.getText().toString();
            if (_chkDrawing.isChecked())
                s += _chkDrawing.getText().toString();

            _textSelect.setText(s);
        }
    };
}
