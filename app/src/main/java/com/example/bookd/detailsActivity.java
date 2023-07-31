package com.example.bookd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class detailsActivity extends AppCompatActivity {

    TextView titledet;
    TextView authordet;
    //TextView pubdet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        titledet = (TextView) findViewById(R.id.titledet);
        authordet = (TextView) findViewById(R.id.authordet);
        //pubdet = (TextView) findViewById(R.id.pubdet);

        Intent intent = getIntent();
        ArrayList<String> booksdet = intent.getStringArrayListExtra("ko");


        titledet.setText(booksdet.get(0));
        authordet.setText(booksdet.get(1));
        //pubdet.setText(booksdet.get(2));

    }
}