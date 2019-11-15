package com.example.aplikasikontrolio;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class ActivityCheckBox extends Activity {
    CheckBox ch1,ch2;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.control_checkbox);

        ch1=(CheckBox)findViewById(R.id.checkBox1);
        ch2=(CheckBox)findViewById(R.id.checkBox2);

        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Membuat objek String yang bisa diubah nilainya
                StringBuffer result = new StringBuffer();
                result.append("CheckBox 1 : ").append(ch1.isChecked());
                result.append("\nCheckBox 2: ").append(ch2.isChecked());
                Toast.makeText(ActivityCheckBox.this, result.toString(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
