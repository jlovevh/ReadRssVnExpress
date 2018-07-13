package com.tvt.readrssvnexpress.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.tvt.readrssvnexpress.R;
import com.tvt.readrssvnexpress.adapter.NewsRecyclerAdapter;
import com.tvt.readrssvnexpress.model.News;
import com.tvt.readrssvnexpress.parse.JsoupParser;
import com.tvt.readrssvnexpress.parse.XMLDOMParser;

import org.jsoup.Jsoup;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NewsRecyclerAdapter adapter;
    private JsoupParser jsoupParser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView = findViewById(R.id.recycler);

        jsoupParser=new JsoupParser();

        Intent intent = getIntent();
        final String link = intent.getStringExtra("link");

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new GetUrl().execute(link);
            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);


    }

    private class GetUrl extends AsyncTask<String,Void,List<News>> {
        ProgressDialog dialog;
        @Override
        protected List<News> doInBackground(String... strings) {
            List<News> list;
            list =jsoupParser.getAllXml(strings[0]);
            return list;
        }

        @Override
        protected void onPostExecute(List<News> news) {
            super.onPostExecute(news);
            dialog.dismiss();
            adapter=new NewsRecyclerAdapter(Main2Activity.this,news);
            recyclerView.setAdapter(adapter);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog=new ProgressDialog(Main2Activity.this);
            dialog.setTitle("Thông báo");
            dialog.setMessage("Loading....");
            dialog.show();
        }
    }
}
