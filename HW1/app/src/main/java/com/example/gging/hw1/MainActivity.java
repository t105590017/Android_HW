package com.example.gging.hw1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner vSpnSex;
    private RadioGroup vRadGrp;
    private RadioButton vRadBAge1;
    private RadioButton vRadBAge2;
    private RadioButton vRadBAge3;
    private TextView vTxtNFamily;
    private NumberPicker vNumPFamily;
    private Button vBtnOK;
    private TextView vTxtSug;

    private String selectedSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vSpnSex = (Spinner) findViewById(R.id.spnSex);
        vRadGrp = (RadioGroup) findViewById(R.id.radGAge);
        vRadBAge1 = (RadioButton) findViewById(R.id.radBAge1);
        vRadBAge2 = (RadioButton) findViewById(R.id.radBAge2);
        vRadBAge3 = (RadioButton) findViewById(R.id.radBAge3);
        vTxtNFamily = (TextView) findViewById(R.id.txtNFamily);
        vNumPFamily = (NumberPicker) findViewById(R.id.numPFamily);
        vNumPFamily.setMinValue(0);
        vNumPFamily.setMaxValue(20);
        vNumPFamily.setValue(3);
        vBtnOK = (Button) findViewById(R.id.btnOK);
        vTxtSug = (TextView) findViewById(R.id.txtSug);

        vSpnSex.setOnItemSelectedListener(spnOselect);
        vNumPFamily.setOnValueChangedListener(NumPFamilyChange);
        vBtnOK.setOnClickListener(BtnOKClick);
    }

    private AdapterView.OnItemSelectedListener spnOselect =new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            switch (parent.getSelectedItem().toString()) {
                case "male":
                    vRadBAge1.setText(getString(R.string.maleAgeRange1));
                    vRadBAge2.setText(getString(R.string.maleAgeRange2));
                    vRadBAge3.setText(getString(R.string.maleAgeRange3));
                    break;
                case "female":
                    vRadBAge1.setText(getString(R.string.femaleAgeRange1));
                    vRadBAge2.setText(getString(R.string.femaleAgeRange2));
                    vRadBAge3.setText(getString(R.string.femaleAgeRange3));
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private NumberPicker.OnValueChangeListener NumPFamilyChange = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            vTxtNFamily.setText(String.valueOf((newVal)));
        }
    };

    private View.OnClickListener BtnOKClick =new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            MarriageSuggestion Sug = new MarriageSuggestion();

            String strSex = vSpnSex.getSelectedItem().toString();
            int AgeR = 0;

            switch (vRadGrp.getCheckedRadioButtonId()){
                case R.id.radBAge1:
                    AgeR = 1;
                    break;
                case R.id.radBAge2:
                    AgeR = 2;
                    break;
                case R.id.radBAge3:
                    AgeR = 3;
                    break;
            }

            vTxtSug.setText(Sug.getSuggestion(strSex, AgeR, vNumPFamily.getValue()));
        }
    };
}
