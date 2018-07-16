package com.fxp.module_homepage.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fxp.module_common.inter.OnItemClickListener;
import com.fxp.module_homepage.R;
import com.fxp.module_homepage.model.FooterInfoBean;

import java.util.List;

/**
 * Title:       HomePageFriendLinkAdapter
 * <p>
 * Package:     com.fxp.module_homepage.adapter
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/15 下午8:11
 * <p>
 * Description: 个人主页-友情链接适配器
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
public class HomePageFriendLinkAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{

    private final static String TAG = HomePageFriendLinkAdapter.class.getSimpleName();

    private Context context;

    private LayoutInflater layoutInflater;

    private List<FooterInfoBean.FriendLink> friendLinkList;

    public OnItemClickListener itemClickListener;

    public HomePageFriendLinkAdapter(Context context, List<FooterInfoBean.FriendLink> friendLinks){
        this.context = context;
        this.friendLinkList = friendLinks;

        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FriendLinkHolder(layoutInflater.inflate(R.layout.item_homepage_friend_link_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FriendLinkHolder){
            ((FriendLinkHolder)holder).nameTextView.setText(friendLinkList.get(position).getName());
            ((FriendLinkHolder)holder).nameTextView.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG );
            ((FriendLinkHolder)holder).itemView.setTag(position);
            ((FriendLinkHolder)holder).itemView.setOnClickListener(this);
        }
    }

    @Override
    public int getItemCount() {
        return friendLinkList.size();
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

    class FriendLinkHolder extends RecyclerView.ViewHolder{

        TextView nameTextView;

        public FriendLinkHolder(View itemView){
            super(itemView);

            nameTextView = itemView.findViewById(R.id.friend_link_lable);

        }

    }
}
