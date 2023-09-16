package com.example.bookd;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    private EditText editText1;
    private Button button;

    private TextView title,author;
    TextView text1;
    TextView text2;

    List<String[]> books;
    ListView bookList;
    ArrayAdapter<String[]> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText1);
        button = (Button) findViewById(R.id.button);

        title=(TextView) findViewById(R.id.textView11);
        author=(TextView) findViewById(R.id.textView22);



        bookList = (ListView) findViewById(R.id.bookList);

        books = new LinkedList<String[]>();







        arrayAdapter = new ArrayAdapter<String[]>(this, android.R.layout.simple_list_item_2,android.R.id.text1,books){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                String[] entry = books.get(position);
                text1 = (TextView) view.findViewById(android.R.id.text1);
                text2 = (TextView) view.findViewById(android.R.id.text2);

                text1.setText(entry[0]);
                text2.setText(entry[1]);
                return view;
            }

        };
        bookList.setAdapter(arrayAdapter);
        bookList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("tag2", String.valueOf(i));
                String[] element = books.get(i);
                List<String> ele = new ArrayList<>(Arrays.asList(element));
                Intent intent = new Intent(getApplicationContext(),detailsActivity.class);

                intent.putExtra("ko",  ele.toArray(new String[0]));
                startActivity(intent);
            }
         });






    }
    public void gobutton(View view){
        String queryString = editText1.getText().toString();
        Log.i("Searched",queryString);
        books.clear();

        new fetchBook(title,author,books,bookList,arrayAdapter).execute(queryString);




    }



}