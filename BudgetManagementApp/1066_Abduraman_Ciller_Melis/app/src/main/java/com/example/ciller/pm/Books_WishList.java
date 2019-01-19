package com.example.ciller.pm;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Books_WishList extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        getJSON firDeExecutie = new getJSON();
        firDeExecutie.execute();
    }

    class getJSON extends AsyncTask<Void, Void, List<String>> {

        @Override
        protected List<String> doInBackground(Void... params) {
            List<String> listaBooks = new ArrayList<String>();

            try {
                URL url = new URL ("https://api.myjson.com/bins/1ecvmv");
                HttpURLConnection http = (HttpURLConnection) url.openConnection();

                InputStream input = http.getInputStream();
                InputStreamReader reader = new InputStreamReader(input);

                BufferedReader br = new BufferedReader(reader);
                String linie = "";
                StringBuilder fisier = new StringBuilder();
                while ((linie = br.readLine()) != null) {
                    fisier.append(linie);
                }

                JSONObject json = new JSONObject(fisier.toString());
                JSONObject jsonObject1 = json.getJSONObject("bookstore");
                JSONArray books = jsonObject1.getJSONArray("book");
                for (int i = 0; i < books.length(); i++) {
                    JSONObject temp = books.getJSONObject(i);
                    //JSONObject title = temp.getJSONObject("title");
                    //String lang = title.getString("-lang");
                   // String text = title.getString("#text");
                    String title = temp.getString("title");
                    String author = temp.getString("author");
                    String year = temp.getString("year");
                    String price = temp.getString("price");


                    StringBuilder sb = new StringBuilder();
                    sb.append("\n");
                    sb.append(title);
                    sb.append("\n");
                    sb.append(author);
                    sb.append("\n");
                    sb.append(year);
                    sb.append("\n");
                    sb.append(price);
                    sb.append("\n");

                    listaBooks.add(sb.toString());
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return listaBooks;
        }

        @Override
        protected void onPostExecute(List<String> strings) {
            super.onPostExecute(strings);
          /*  ArrayAdapter adaptor = new ArrayAdapter(getApplicationContext(), android.R.layout.activity_list_item, strings);
            ListView listViewBooks = (ListView)findViewById(R.id.listViewBooks);
            listViewBooks.setAdapter(adaptor);*/

            TextView tv=(TextView)findViewById(R.id.tvid);
            StringBuilder sb=new StringBuilder();
            for (String s:strings)
                {sb.append(s);
                 sb.append("\n");
                 tv.append(s);
            }
           // tv.append(sb);
        }
    }

    }


