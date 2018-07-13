package com.tvt.readrssvnexpress.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.tvt.readrssvnexpress.R;
import com.tvt.readrssvnexpress.adapter.CategoryAdapter;
import com.tvt.readrssvnexpress.model.Category;
import com.tvt.readrssvnexpress.parse.CategoryParser;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Category> arrCategory;
    private CategoryAdapter adapter;
    private ListView lv;
    private CategoryParser parser;
    private String link="https://vnexpress.net/rss";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        parser=new CategoryParser();
        lv=findViewById(R.id.list_category);


        addArrayList();
        adapter=new CategoryAdapter(this,arrCategory);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =new Intent(MainActivity.this,Main2Activity.class);
                String link=arrCategory.get(position).getLink();
                intent.putExtra("link",link);

                startActivity(intent);
            }
        });


//        new GetCategory().execute(link);
    }

    private void addArrayList() {
        arrCategory=new ArrayList<>();
        arrCategory.add(new Category("Trang chủ","https://vnexpress.net/rss/tin-moi-nhat.rss"));
        arrCategory.add(new Category("Thời sự","https://vnexpress.net/rss/thoi-su.rss"));
        arrCategory.add(new Category("Thế giới","https://vnexpress.net/rss/the-gioi.rss"));
        arrCategory.add(new Category("kinh doanh","https://vnexpress.net/rss/kinh-doanh.rss"));
        arrCategory.add(new Category("Startup","https://vnexpress.net/rss/startup.rss"));
        arrCategory.add(new Category("Giải trí","https://vnexpress.net/rss/giai-tri.rss"));
        arrCategory.add(new Category("Thể thao","https://vnexpress.net/rss/the-thao.rss"));
        arrCategory.add(new Category("Pháp luật","https://vnexpress.net/rss/phap-luat.rss"));
        arrCategory.add(new Category("Giáo dục","https://vnexpress.net/rss/giao-duc.rss"));
        arrCategory.add(new Category("Sức khỏe","https://vnexpress.net/rss/suc-khoe.rss"));
        arrCategory.add(new Category("Gia đình","https://vnexpress.net/rss/gia-dinh.rss"));
        arrCategory.add(new Category("Du lịch","https://vnexpress.net/rss/du-lich.rss"));
        arrCategory.add(new Category("Khoa học","https://vnexpress.net/rss/khoa-hoc.rss"));
        arrCategory.add(new Category("Số hóa","https://vnexpress.net/rss/so-hoa.rss"));
        arrCategory.add(new Category("Xe","https://vnexpress.net/rss/oto-xe-may.rss"));
        arrCategory.add(new Category("Cộng đồng","https://vnexpress.net/rss/cong-dong.rss"));
        arrCategory.add(new Category("Tâm sự","https://vnexpress.net/rss/tam-su.rss"));
        arrCategory.add(new Category("Cười","https://vnexpress.net/rss/cuoi.rss"));

    }

//    private class GetCategory extends AsyncTask<String,Void,List<Category>>{
//        ProgressDialog dialog;
//        @Override
//        protected List<Category> doInBackground(String... strings) {
//            arrCategory=new ArrayList<>();
//
//            return arrCategory=parser.parserCategory(strings[0]);
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
////            dialog =new ProgressDialog(MainActivity.this);
////            dialog.setMessage("Đang tải");
////            dialog.show();
//        }
//
//        @Override
//        protected void onPostExecute(List<Category> categories) {
//            super.onPostExecute(categories);
////            if(dialog.isShowing()){
////                dialog.dismiss();
////            }
//            adapter=new CategoryAdapter(MainActivity.this,categories);
//            lv.setAdapter(adapter);
//            adapter.notifyDataSetChanged();
//            Toast.makeText(MainActivity.this, "Complete :"+categories.size(), Toast.LENGTH_SHORT).show();
//
//
//        }
//
//        @Override
//        protected void onProgressUpdate(Void... values) {
//            super.onProgressUpdate(values);
//        }
//    }
}
