package com.filipkesteli.explicitcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Kljuc koji definiramo za putExtra:
    public static final String PARAMETER_NAME = "parameter_plus";

    private EditText etFirst;
    private EditText etSecond;
    private Button btnPlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setupListeners();

        registerContextMenus();
    }

    private void registerContextMenus() {
        registerForContextMenu(etFirst);
        registerForContextMenu(etSecond);
    }

    private void initWidgets() {
        etFirst = (EditText) findViewById(R.id.etFirst);
        etSecond = (EditText) findViewById(R.id.etSecond);
        btnPlus = (Button) findViewById(R.id.btnPlus);
    }

    private void setupListeners() {
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumAndSend();
            }
        });
    }

    private void sumAndSend() {
        int first = Integer.parseInt(etFirst.getText().toString());
        int second = Integer.parseInt(etSecond.getText().toString());
        int result = first + second;

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(PARAMETER_NAME, result);
        startActivity(intent); //saljemo activity
    }

    private EditText etSelected;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        etSelected = (EditText) v; //trajno smo zapamtili

        menu.setHeaderTitle(R.string.source);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.miDelete:
                etSelected.setText("");
                return true;
            case R.id.miCancel:
                return true;
        }

        return super.onContextItemSelected(item);
    }
}
