package com.example.aplikasikontrolio;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ActivityToogle extends Activity {
    ToggleButton tg1,tg2;
    Button b1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.control_toogle);

        tg1=(ToggleButton)findViewById(R.id.toggleButton);
        tg2=(ToggleButton)findViewById(R.id.toggleButton2);

        b1=(Button)findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer result = new StringBuffer();
                result.append("You have clicked first ON Button-:) ").append(tg1.getText());
                result.append("You have clicked Second ON Button -:) ").append(tg2.getText());
                Toast.makeText(ActivityToogle.this, result.toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }

}
