package cn.edu.gdpt.healthknowledge;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class HealthRVadapter extends RecyclerView.Adapter<HealthRVadapter.viewholder> {
    private Context context;

    public HealthRVadapter(Context context, List<HomeBean.ResultBean.ListBean> listBeans) {
        this.context = context;
        this.listBeans = listBeans;
    }

    private List<HomeBean.ResultBean.ListBean> listBeans;
    @NonNull
    @Override
    public HealthRVadapter.viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_health,null);

        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HealthRVadapter.viewholder viewholder, final int i) {

            viewholder.tv_title.setText(listBeans.get(i).getTitle());
            viewholder.tv_content.setText(listBeans.get(i).getContent());
            viewholder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   Intent intent=new Intent(context, ContextActivity.class);
                   intent.putExtra("bean",listBeans.get(i).getTitle());
                    intent.putExtra("context",listBeans.get(i).getContent());
                    context.startActivity(intent);
                    //Toast.makeText(context, listBeans.get(i).getContent(), Toast.LENGTH_SHORT).show();
                    //Intent intent=new Intent(context, ContextActivity.class);
                    //context.startActivity(intent);


                }
            });

    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }
    class viewholder extends RecyclerView.ViewHolder{
        private TextView tv_title,tv_content;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            tv_title=itemView.findViewById(R.id.item_tv_title);
            tv_content=itemView.findViewById(R.id.item_tv_content);

        }
    }
}
