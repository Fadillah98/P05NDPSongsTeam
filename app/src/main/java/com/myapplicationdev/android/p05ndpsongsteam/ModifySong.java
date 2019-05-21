package com.myapplicationdev.android.p05ndpsongsteam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ModifySong extends AppCompatActivity {

    EditText etID, etSongTitle, etYear, etSingers;
    Button btnUpdate, btnDelete, btnCancel;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_song);
        etID = findViewById(R.id.etID);
        etSongTitle = findViewById(R.id.etTitle);
        etYear = findViewById(R.id.etYear);
        etSingers = findViewById(R.id.etSinger);
        btnCancel = findViewById(R.id.btnCancel);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);
        rg = findViewById(R.id.radioGroupStars);

        etID.setEnabled(false);
        etID.setText("");
        etSingers.setText("");
        etSongTitle.setText("");
        etYear.setText("");
        rg.check(0);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedButtonID = rg.getCheckedRadioButtonId();
                RadioButton rb = findViewById(selectedButtonID);
                int stars = Integer.parseInt(rb.getText().toString());
                String songTitle = etSongTitle.getText().toString();
                String year = etYear.getText().toString();
                String singers = etSingers.getText().toString();
                if (songTitle.length() == 0 || year.length() == 0 || singers.length() == 0) {
                    Toast.makeText(getBaseContext(), "All fields cannot be empty", Toast.LENGTH_SHORT).show();
                } else {
                    
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
