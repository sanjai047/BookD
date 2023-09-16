package com.example.bookd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import com.example.bookd.MainActivity;

public class detailsActivity extends AppCompatActivity  {

    TextView titledet;
    TextView authordet;
    TextView pubdet;
    TextView descdet;
    ImageView imageView;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        titledet = (TextView) findViewById(R.id.titledet);
        authordet = (TextView) findViewById(R.id.authordet);
        pubdet = (TextView) findViewById(R.id.pubdet);
        descdet = (TextView) findViewById(R.id.descdet);


        String[] array = getIntent().getStringArrayExtra("ko");
        List<String> booksdet = new ArrayList<>(Arrays.asList(array));



        titledet.setText(booksdet.get(0));
        authordet.setText(booksdet.get(1));
        pubdet.setText(booksdet.get(2));
        //String Link = "\""+booksdet.get(3)+"\"";
        String Link = booksdet.get(3);
        descdet.setText(booksdet.get(4));
        //descdet.setMovementMethod(new ScrollingMovementMethod());

        webView = findViewById(R.id.webView);
        StringBuilder stringBuilder = new StringBuilder(Link);
        stringBuilder.insert(4,"s");
        String modifiedString = stringBuilder.toString();
        //Log.i("messs",modifiedString);


        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        webView.loadUrl(modifiedString);






    }
}