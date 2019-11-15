package com.example.aplikasikontrolio;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ActivityRadioGroup extends Activity {
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    private Button btnDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.control_radiogroup);
        radioSexGroup=(RadioGroup)findViewById(R.id.radioGroup);
        btnDisplay=(Button)findViewById(R.id.button);
        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId=radioSexGroup.getCheckedRadioButtonId();
                radioSexButton=(RadioButton)findViewById(selectedId);
                Toast.makeText(ActivityRadioGroup.this,radioSexButton.getText(),Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
