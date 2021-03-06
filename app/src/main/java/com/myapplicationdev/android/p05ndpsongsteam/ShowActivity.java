package com.myapplicationdev.android.p05ndpsongsteam;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<Song> al;
    ArrayAdapter aa;
    Button btnShow5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        setTitle("P005-NDPSongs ~ Show Song");

        lv = findViewById(R.id.lvSongs);
        btnShow5 = findViewById(R.id.btnShow5);
        DBHelper db = new DBHelper(ShowActivity.this);

        al = new ArrayList<Song>();
        al = db.getAllSongs();

        aa = new SongAdapter(this, R.layout.row, al);

        lv.setAdapter(aa);

        btnShow5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ShowActivity.this);
                al.clear();
                al.addAll(dbh.getFilteredSong(5));
                aa = new SongAdapter(getBaseContext(), R.layout.row, al);
                lv.setAdapter(aa);
                dbh.close();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(), ModifySong.class);
                Song currentSong = al.get(position);
                intent.putExtra("song", currentSong);
                startActivityForResult(intent, 9);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 9){
            DBHelper db = new DBHelper(ShowActivity.this);
            al.clear();
            al.addAll(db.getAllSongs());
            aa = new SongAdapter(this, R.layout.row, al);
            lv.setAdapter(aa);
        }
    }
}
