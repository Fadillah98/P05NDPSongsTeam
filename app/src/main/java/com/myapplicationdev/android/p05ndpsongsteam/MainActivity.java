package com.myapplicationdev.android.p05ndpsongsteam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnInsert, btnShow;
    EditText etTitle, etSingers, etYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.buttonInsertNote);
        etTitle = findViewById(R.id.etTitle);
        etSingers = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);
        btnShow = findViewById(R.id.buttonShowList);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rg = findViewById(R.id.radioGroupStars);
                RadioButton rb1 = findViewById(R.id.radio1);
                int selectedButtonId = rg.getCheckedRadioButtonId();
                RadioButton rb = findViewById(selectedButtonId);


                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                if (etTitle.getText().toString().isEmpty() || etSingers.getText().toString().isEmpty() || etYear.getText().toString().isEmpty()) {
                    // Insert a task
                    Toast.makeText(MainActivity.this, "Please Enter A Note Title",
                            Toast.LENGTH_LONG).show();

                } else {

                    db.insertSongs(etTitle.getText().toString(), etSingers.getText().toString(), Integer.parseInt(etYear.getText().toString()), Integer.parseInt(rb.getText().toString()));
                    db.close();
                    Toast.makeText(MainActivity.this, "Inserted",
                            Toast.LENGTH_LONG).show();
                    etTitle.setText("");
                    etSingers.setText("");
                    etYear.setText("");
                    rg.clearCheck();
                    rb1.setChecked(true);
                }
            }
        });


        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), ShowActivity.class);
                startActivity(i);
            }
        });
    }
}

