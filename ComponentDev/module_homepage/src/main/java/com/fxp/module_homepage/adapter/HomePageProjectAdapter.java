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
import com.fxp.module_homepage.model.ProjectInfoBean;

import java.util.List;

/**
 * Title:       HomePageProjectAdapter
 * <p>
 * Package:     com.fxp.module_homepage.adapter
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/15 上午11:53
 * <p>
 * Description: 个人主页-开源项目适配器
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
public class HomePageProjectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private final static String TAG = HomePageProjectAdapter.class.getSimpleName();

    private Context context;

    private LayoutInflater layoutInflater;

    private List<ProjectInfoBean.ProjectBean> projectBeanList;

    private OnItemClickListener itemClickListener;

    public HomePageProjectAdapter(Context context, List<ProjectInfoBean.ProjectBean> projectBeanList){
        this.context = context;
        this.projectBeanList = projectBeanList;

        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProjectHolder(layoutInflater.inflate(R.layout.item_homepage_project_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ProjectHolder){
            ((ProjectHolder)holder).titleTextView.setText(projectBeanList.get(position).getTitle());
            ((ProjectHolder)holder).descTextView.setText(projectBeanList.get(position).getDesc());
        }
    }

    @Override
    public int getItemCount() {
        return projectBeanList.size();
    }

    public void setItemClickListener(OnItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    class ProjectHolder extends RecyclerView.ViewHolder{

        TextView titleTextView;

        TextView descTextView;

        public ProjectHolder(View itemView){
            super(itemView);

            titleTextView = itemView.findViewById(R.id.txt_project_title);

            descTextView = itemView.findViewById(R.id.txt_project_desc);
        }

    }
}
