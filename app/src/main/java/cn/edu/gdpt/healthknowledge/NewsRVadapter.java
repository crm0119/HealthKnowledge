package cn.edu.gdpt.healthknowledge;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsRVadapter extends RecyclerView.Adapter {

    private ArrayList<String> tags = new ArrayList<>();
    private List<data> mData;

    private Context mContext;
    private boolean isLoading;
    private static final int VIEW_ITEM = 0;
    private static final int VIEW_PROG = 1;
    private LayoutInflater inflater;
    private LoadImages mImageLoader;

    Context context;
    RecyclerView recyclerView;

    public NewsRVadapter(Context context, List<HomeBean.ResultBean.ListBean> DataBean) {
        this.context = context;
        this.recyclerView = recyclerView;
        this.DataBean= DataBean;
    }
    private List<HomeBean.ResultBean.ListBean>DataBean;

    public void setLoaded() {
        isLoading = false;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        if (viewType == VIEW_ITEM) {
            holder = new MyViewHolder(inflater.inflate(R.layout.fragment_news_rv_item, parent, false));
        } else {
            holder = new MyProgressViewHolder(inflater.inflate(R.layout.fragment_news_rv_footer, parent, false));
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof MyViewHolder) {
            if (((MyViewHolder) holder).title != null) {

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                String date = sdf.format(new Date(Long.valueOf(mData.get(position).time)));

                ((MyViewHolder) holder).time.setText(date);
                ((MyViewHolder) holder).title.setText(mData.get(position).title);
                ((MyViewHolder) holder).description.setText(mData.get(position).description);
                ((MyViewHolder) holder).visit.setText(mData.get(position).count + "访问");
                ((MyViewHolder) holder).keyworld.setText(mData.get(position).keywords);

                ((MyViewHolder) holder).view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mOnitemClickListener.onClick(v, position);
                    }
                });

                ((MyViewHolder) holder).image.setTag(mData.get(position).img);

                /** 图片加载-----------------------------*/
                try {
                    //加载图片
                    // TODO PostExecuteBitmap回调
                    Bitmap bitmap = mImageLoader.loadSingleImage(position);
                    if (bitmap != null)
                        ((MyViewHolder) holder).image.setImageBitmap(bitmap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                /** 图片加载-----------------------------*/

                ((MyViewHolder) holder).collection.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        new AnimUtils().startGeneralBtAnim(v);

                        Toast.makeText(mContext, "click " + position + "collection", Toast.LENGTH_SHORT).show();
                    }
                });
                ((MyViewHolder) holder).share.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        new AnimUtils().startGeneralBtAnim(v);

                        Toast.makeText(mContext, "click " + position + "share", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        } else if (holder instanceof MyProgressViewHolder) {
            if (((MyProgressViewHolder) holder).pb != null)
                ((MyProgressViewHolder) holder).pb.setIndeterminate(true);
        }

    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public class MyProgressViewHolder extends RecyclerView.ViewHolder {

        private final ProgressBar pb;

        public MyProgressViewHolder(View itemView) {
            super(itemView);
            pb = (ProgressBar) itemView.findViewById(R.id.pb);
        }

    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView time;
        TextView mark;
        TextView title;
        TextView description;
        TextView visit;
        TextView keyworld;
        ImageView image;
        ImageButton collection;
        ImageButton share;

        View view;

        public MyViewHolder(View view) {
            super(view);
            this.view = view;
            this.time = (TextView) view.findViewById(R.id.health_rv_time);
            this.mark = (TextView) view.findViewById(R.id.health_rv_mark);
            this.title = (TextView) view.findViewById(R.id.health_rv_title);
            this.description = (TextView) view.findViewById(R.id.health_rv_description);
            this.visit = (TextView) view.findViewById(R.id.health_rv_visit);
            this.keyworld = (TextView) view.findViewById(R.id.health_rv_key_world);
            this.image = (ImageView) view.findViewById(R.id.health_rv_image);
            this.collection = (ImageButton) view.findViewById(R.id.health_rv_collection);
            this.share = (ImageButton) view.findViewById(R.id.health_rv_share);
        }
    }

    private LoadMoreDataListener mMoreDataListener;

    public void tagsChange() {
        tags.clear();
        for (int i = 0; i < mData.size(); i++) {
            tags.add(mData.get(i).img);
        }
    }



    //加载更多监听方法
    public void setOnMoreDataLoadListener(LoadMoreDataListener onMoreDataLoadListener) {
        mMoreDataListener = onMoreDataLoadListener;
    }

    private RecyclerOnItemClickListener mOnitemClickListener;

    //点击事件监听方法
    public void setOnItemClickListener(RecyclerOnItemClickListener onItemClickListener) {
        mOnitemClickListener = onItemClickListener;
    }
}
