package com.example.bookd;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.List;

public class fetchBook extends AsyncTask<String,Void,String> {
    private TextView text1;
    private TextView text2;
    private List<String[]> books;
    private ListView bookList;
    private ArrayAdapter<String[]> arrayAdapter;


    public fetchBook(TextView text1,TextView text2,List<String[]> books,ListView bookList,ArrayAdapter arrayAdapter){
        this.text1 = text1;
        this.text2 = text2;
        this.books = books;
        this.bookList = bookList;
        this.arrayAdapter = arrayAdapter;
    }

    @Override
    protected String doInBackground(String... strings) {
        return NetworkUtils.getBookInfo(strings[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {

            JSONObject jsonObject = new JSONObject(s);
            JSONArray itemsArray = jsonObject.getJSONArray("items");

            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject book = itemsArray.getJSONObject(i);
                String title = null;
                String authors = null;
                //String pub = null;



                JSONObject volumeInfo = book.getJSONObject("volumeInfo");
                try {
                    title = volumeInfo.getString("title");
                    authors = volumeInfo.getString("authors");
                    //pub = volumeInfo.getString("publisher");


                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (title != null && authors != null ) {
                    //text1.setText(title);
                    //text2.setText(authors);



                    books.add(new String[] {title,authors});



                    bookList.setAdapter(arrayAdapter);



                }else{
                text1.setText("No results found!");
                text2.setText("");
                }
            }



        }catch (Exception e){
            text1.setText("No results found!");
            text2.setText("");
            e.printStackTrace();
        }
    }

}
