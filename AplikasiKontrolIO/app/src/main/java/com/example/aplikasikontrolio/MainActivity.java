package com.example.aplikasikontrolio;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView header;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        header = (TextView) findViewById(R.id.txtHeader);
    }
    public void launchSecondActivity(View view) {
// Membuat objek Intent
        Intent intent = new Intent(this, SecondActivity.class);
// Menjalankan Activity dengan parameter Intent
        startActivity(intent);
    }
}
