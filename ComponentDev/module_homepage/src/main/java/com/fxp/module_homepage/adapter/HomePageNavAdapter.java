package com.fxp.module_homepage.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fxp.module_common.utils.DensityUtils;
import com.fxp.module_homepage.R;
import com.fxp.module_common.inter.OnItemClickListener;
import com.fxp.module_homepage.model.UserInfoBean;

import java.util.List;

/**
 * Title:       HomePageNavAdapter
 * <p>
 * Package:     com.fxp.module_homepage.adapter
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/12 下午8:30
 * <p>
 * Description: 个人主页-顶部视图-导航栏适配器
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/7/12    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class HomePageNavAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{

    private final static String TAG = HomePageNavAdapter.class.getSimpleName();

    private Context context;

    private List<UserInfoBean.NavBean> datas;

    private LayoutInflater layoutInflater;

    private OnItemClickListener itemClickListener;

    public HomePageNavAdapter(Context context, List<UserInfoBean.NavBean> datas){
        this.context = context;
        this.datas = datas;

        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new NavHolder(layoutInflater.inflate(R.layout.item_homepage_nav_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof NavHolder){
            ((NavHolder)holder).lable.setText(datas.get(position).getName());
            // 动态调整item项宽度,（屏幕宽度 - 左右margin值）/ item项数目
            ((NavHolder)holder).lable.setWidth((DensityUtils.getScreenWidth(context) - DensityUtils.dp2px(context, 10))/datas.size());
            ((NavHolder)holder).lable.setTag(position);
            ((NavHolder)holder).lable.setOnClickListener(this);
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
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

    class NavHolder extends RecyclerView.ViewHolder{

        TextView lable;

        public NavHolder(View itemView){
            super(itemView);

            lable = itemView.findViewById(R.id.nav_lable);
        }
    }

}
