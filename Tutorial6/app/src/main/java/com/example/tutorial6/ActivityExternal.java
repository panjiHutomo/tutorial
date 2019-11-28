package com.example.tutorial6;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ActivityExternal extends AppCompatActivity {
    EditText inputText;
    TextView response;
    Button saveButton,readButton;
    // Membuat nama file
    private String filename = "SampleFile.txt";
    // Membuat nama folder penyimpanan
    private String filepath = "MyFileStorage";
    // Membuat objek kelas File
    File myExternalFile;
    // Menginisialisasi nilai awal variabel myData
    String myData = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eksternal);
        inputText = (EditText) findViewById(R.id.myInputText);
        response = (TextView) findViewById(R.id.response);
        saveButton = (Button) findViewById(R.id.saveExternalStorage);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
// Membuat objek FileOutputStream untuk proses penyimpanan output file
                    FileOutputStream fos = new FileOutputStream(myExternalFile);
// Menuliskan isi file berdasarkan inputan user
                    fos.write(inputText.getText().toString().getBytes());
// Menutup proses tulis
 fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
// Mengatur nilai kosong jika user menyentuh tombol tanpa mengisi text
inputText.setText("");
// Memberikan respon setelah user menyentuh tombol simpan
response.setText("SampleFile.txt saved to External Storage...");
        }
    });
    readButton = (Button) findViewById(R.id.getExternalStorage);
readButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                FileInputStream fis = new FileInputStream(myExternalFile);
// Membuat objek DataInputStream untuk mengambil objek file
                DataInputStream in = new DataInputStream(fis);
// Membuat objek BufferedReader untuk membaca isi file
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
// Membuat variabel penampung nilai text di file
                String strLine;
// Melakukan pengecekan text file kosong atau tidak
                while ((strLine = br.readLine()) != null) {
/* Jika file tidak kosong, variabel myData sebelumnya yang kosong akan
diisi dengan nilai text di strLine */
                    myData = myData + strLine;
                }
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            inputText.setText(myData);
            response.setText("SampleFile.txt data retrieved from Internal Storage...");
        }
    });
// Mengecek status Eksternal Storage apakah available
// Jika tidak maka tombol simpan akan disable
if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
        saveButton.setEnabled(false);
    }
else {
        myExternalFile = new File(getExternalFilesDir(filepath),
                filename);
    }
}
    // Proses pengecekan Eksternal Storage read only atau tidak
    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }
    // Proses pengecekan Eksternal Storage available atau tidak
    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }
}