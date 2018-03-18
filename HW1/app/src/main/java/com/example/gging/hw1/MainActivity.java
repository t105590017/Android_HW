package com.example.gging.hw1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mEdtSex, mEdtAge;
    private Button mBtnSen;
    private TextView mSuggest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtSex = (EditText) findViewById(R.id.value_of_sex);
        mEdtAge = (EditText) findViewById(R.id.value_of_age);
        mBtnSen = (Button) findViewById(R.id.Btn_Send_Out);
        mSuggest = (TextView) findViewById(R.id.txt_suggest);

        mBtnSen.setOnClickListener(Btn_Send_OutOnClick);
    }

    private View.OnClickListener Btn_Send_OutOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String Sex = mEdtSex.getText().toString();
            int Age = Integer.parseInt((mEdtAge.getText().toString()));
            String Sug = getString(R.string.Suggest_Text);

            if(Sex.equals(getString(R.string.male)))
                if(Age < 30)
                    Sug += getString(R.string.not_hurry);
                else if(Age > 35)
                    Sug += getString(R.string.get_marry);
                else
                    Sug += getString(R.string.find_couple);
            else
            if(Age < 28)
                Sug += getString(R.string.not_hurry);
            else if(Age > 32)
                Sug += getString(R.string.get_marry);
            else
                Sug += getString(R.string.find_couple);

            mSuggest.setText(Sug);
        }
    };
}
