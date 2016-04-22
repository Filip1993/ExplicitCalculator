package com.filipkesteli.explicitcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class ResultActivity extends AppCompatActivity {

    private EditText etResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        initWidgets();
        handleIntent();
    }

    private void initWidgets() {
        etResult = (EditText) findViewById(R.id.etResult);
    }

    private void handleIntent() {
        Intent intent = getIntent();
        if (intent.hasExtra(MainActivity.PARAMETER_NAME)) {
            int number = intent.getIntExtra(MainActivity.PARAMETER_NAME, 0);
            etResult.setText(number+"");
        }
    }
}
