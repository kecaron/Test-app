package com.example.caron.test_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by CARON on 16/05/2017.
 */
//
public class Display_Activity_Add extends Activity {

    String to_theme;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajout_list);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.theme_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        Button start = (Button) findViewById(R.id.smain);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                to_theme = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText x = (EditText) findViewById(R.id.eddit_x);
                EditText y = (EditText) findViewById(R.id.eddit_y);
                int to_x = Integer.parseInt(x.getText().toString());
                int to_y = Integer.parseInt(y.getText().toString());
                Intent intent = new Intent();
                intent.putExtra("to_theme",to_theme);
                intent.putExtra("to_x",to_x);
                intent.putExtra("to_y",to_y);
                setResult(2,intent);
                finish();
            }
        });
    }
}
