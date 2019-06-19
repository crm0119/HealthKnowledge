package cn.edu.gdpt.healthknowledge;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyRvadapter extends RecyclerView.Adapter<MyRvadapter.MydapterHolder> {
    private List<NewsBean> new_list;
    private Context context;

    public MyRvadapter(Context context, List<NewsBean> new_list) {
        this.new_list = new_list;
        this.context = context;
    }

    @NonNull
    @Override
    public MydapterHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.news_item,null);
        MydapterHolder holder=new MydapterHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MydapterHolder mydapterHolder, int i) {
        final NewsBean newsBean = new_list.get(i);
        mydapterHolder.title.setText(newsBean.title);
        mydapterHolder.name.setText(newsBean.name);
        Glide
                .with(context)
                .load(newsBean.image)
                .error(R.mipmap.ic_launcher)
                .into(mydapterHolder.imageView);
        mydapterHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, NewsviewActivity.class);
                intent.putExtra("bean",newsBean);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return new_list.size();
    }

     class MydapterHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView name,title;

         public MydapterHolder(@NonNull View itemView) {
             super(itemView);
             imageView=itemView.findViewById(R.id.item_iv);
             name=itemView.findViewById(R.id.item_tv_name);
             title=itemView.findViewById(R.id.item_tv_title);
         }
     }
}
