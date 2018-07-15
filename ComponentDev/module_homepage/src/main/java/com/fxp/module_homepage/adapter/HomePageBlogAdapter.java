package com.fxp.module_homepage.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fxp.module_common.inter.OnItemClickListener;
import com.fxp.module_homepage.R;
import com.fxp.module_homepage.model.BlogInfoBean;

import java.util.List;

/**
 * Title:       HomePageBlogAdapter
 * <p>
 * Package:     com.fxp.module_homepage.adapter
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/15 下午6:11
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/7/15    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class HomePageBlogAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{

    private final static String TAG = HomePageBlogAdapter.class.getSimpleName();

    private Context context;

    private LayoutInflater layoutInflater;

    private List<BlogInfoBean.BlogBean> blogBeanList;

    private OnItemClickListener itemClickListener;

    public HomePageBlogAdapter(Context context, List<BlogInfoBean.BlogBean> blogBeanList){
        this.context = context;
        this.blogBeanList = blogBeanList;

        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BlogHolder(layoutInflater.inflate(R.layout.item_homepage_blog_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BlogHolder){
            ((BlogHolder)holder).titleTextView.setText(blogBeanList.get(position).getTitle());
            ((BlogHolder)holder).descTextView.setText(blogBeanList.get(position).getDesc());
            ((BlogHolder)holder).itemView.setTag(position);
            ((BlogHolder)holder).itemView.setOnClickListener(this);
        }
    }

    @Override
    public int getItemCount() {
        return blogBeanList.size();
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        if (itemClickListener != null){
            itemClickListener.onItemClick((Integer)v.getTag());
        }
    }

    class BlogHolder extends RecyclerView.ViewHolder{

        TextView titleTextView;

        TextView descTextView;

        public BlogHolder(View itemView){
            super(itemView);

            titleTextView = itemView.findViewById(R.id.txt_blog_title);

            descTextView = itemView.findViewById(R.id.txt_blog_desc);
        }
    }

}
