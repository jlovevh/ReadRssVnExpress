package com.tvt.readrssvnexpress.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tvt.readrssvnexpress.R;
import com.tvt.readrssvnexpress.model.Category;

import java.util.List;

public class CategoryAdapter extends BaseAdapter{
    private Context context;
    private List<Category> arrCategory;

    public CategoryAdapter(Context context, List<Category> arrCategory) {
        this.context = context;
        this.arrCategory = arrCategory;
    }

    @Override
    public int getCount() {
        return arrCategory.size();
    }

    @Override
    public Object getItem(int position) {
        return arrCategory.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        TextView tvTitle;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=new ViewHolder();

        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_cate,parent,false);
            holder.tvTitle=convertView.findViewById(R.id.tvTitle);

            convertView.setTag(holder);

        }else {
            holder= (ViewHolder) convertView.getTag();
        }

        holder.tvTitle.setText(arrCategory.get(position).getTitle());

        return convertView;
    }
}
