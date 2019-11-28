package com.example.tutorial6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText editTextFileName,editTextData;
    Button saveButton,readButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextFileName=findViewById(R.id.editText1);
        editTextData=findViewById(R.id.editText2);
        saveButton=findViewById(R.id.button1);
        readButton=findViewById(R.id.button2);
        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
/* Melakukan inisialisasi nilai variabel filename dan data ketika user
menyentuh tombol */
                String filename=editTextFileName.getText().toString();
                String data=editTextData.getText().toString();
// Membuat variabel bernama fos bertipe FileOutputStream
                FileOutputStream fos;
                try {
// Melakukan Inisialisasi nilai fos yang merupakan variabel objek
                    fos = openFileOutput(filename, Context.MODE_PRIVATE);
//default mode is PRIVATE, can be APPEND etc.
// Menuliskan data ke Internal Storage
                    fos.write(data.getBytes());
                    fos.close();
                    Toast.makeText(getApplicationContext(),filename + " saved",
                            Toast.LENGTH_LONG).show();
                } catch (FileNotFoundException e) {e.printStackTrace();}
                catch (IOException e) {e.printStackTrace();}
            }
        });
// Ketika tombol Read disentuh
        readButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                String filename=editTextFileName.getText().toString();
                StringBuffer stringBuffer = new StringBuffer();
                try {
/* Menambhakan BufferedReader untuk FileInputString dengan bantuan
InputStreamReader untuk membaca nilai */
                    BufferedReader inputReader = new BufferedReader(new
                            InputStreamReader(
                            openFileInput(filename)));
                    String inputString;
// Membaca data per-baris dan mengirimkannya ke stringBuffer
                    while ((inputString = inputReader.readLine()) != null)
                    {
                        stringBuffer.append(inputString + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
// Menampilkan data ke Toast
                Toast.makeText(getApplicationContext(),stringBuffer.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}