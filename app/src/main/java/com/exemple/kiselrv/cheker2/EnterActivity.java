package com.exemple.kiselrv.cheker2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EnterActivity extends AppCompatActivity {

    TextView fio_enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        fio_enter = (TextView) findViewById(R.id.fio_enter);

        Intent intent_enter = getIntent();

        String fio = intent_enter.getStringExtra("fio");

        fio_enter.setText(fio);
    }
}
