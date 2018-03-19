package com.example.rtc40.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
    }

    String word;
    public void fn_find(View v){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                word = Crawler.getWord(editText.getText().toString());
            }
        });
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            thread.interrupt();
            e.printStackTrace();
        }finally {
            Toast.makeText(this,word,Toast.LENGTH_LONG).show();
        }

    }



}
