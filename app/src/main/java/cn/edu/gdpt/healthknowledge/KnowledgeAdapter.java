package cn.edu.gdpt.healthknowledge;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class KnowledgeAdapter extends RecyclerView.Adapter<KnowledgeAdapter.viewholder>{
    private Context context;
    @NonNull
    @Override
    public KnowledgeAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull KnowledgeAdapter.viewholder knowledgeviewholder, int i) {
        knowledgeviewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ShowActivity.class);
                //intent.putExtra("bean",KnowledgeBean);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }class viewholder extends RecyclerView.ViewHolder{
        private WebView webView;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            webView=itemView.findViewById(R.id.webview);

        }
    }

}
