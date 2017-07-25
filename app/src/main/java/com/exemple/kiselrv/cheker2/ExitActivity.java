package com.exemple.kiselrv.cheker2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ExitActivity extends AppCompatActivity {

    TextView fio_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);

        fio_exit = (TextView) findViewById(R.id.fio_exit);

        Intent intent_exit = getIntent();

        String fio = intent_exit.getStringExtra("fio");
        fio_exit.setText(fio);

    }
}
