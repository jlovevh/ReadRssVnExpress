package com.tvt.readrssvnexpress.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tvt.readrssvnexpress.R;
import com.tvt.readrssvnexpress.activity.Main3Activity;
import com.tvt.readrssvnexpress.model.News;

import java.util.List;

public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<News> arrList;

    public NewsRecyclerAdapter(Context context, List<News> arrList) {
        this.context = context;
        this.arrList = arrList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.item_news,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.title.setText(arrList.get(position).getTitle());
        holder.time.setText(arrList.get(position).getTime());
        holder.description.setText(arrList.get(position).getDescripton());
        Picasso.with(context).load(arrList.get(position).getImg()).error(R.mipmap.ic_launcher).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return arrList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView title,link,time,description;

        private ViewHolder(View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            description=itemView.findViewById(R.id.description);
            title=itemView.findViewById(R.id.title);
            time=itemView.findViewById(R.id.time);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(context, Main3Activity.class);
                    String link=arrList.get(getAdapterPosition()).getLink();
                    intent.putExtra("linkNews",link);
                    context.startActivity(intent);
                }
            });
        }
    }
}
