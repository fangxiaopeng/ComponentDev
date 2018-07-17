package com.fxp.module_homepage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fxp.module_homepage.R;
import com.fxp.module_homepage.model.MsgBoardInfoBean;
import com.fxp.module_homepage.view.HomePageMsgBoardView;

import java.util.List;

/**
 * Title:       HomePageMsgBoardAdapter
 * <p>
 * Package:     com.fxp.module_homepage.adapter
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/16 下午3:52
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2018/7/16    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class HomePageMsgBoardAdapter extends BaseExpandableListAdapter{

    private final static String TAG = HomePageMsgBoardView.class.getSimpleName();

    private Context context;

    private LayoutInflater layoutInflater;

    private List<MsgBoardInfoBean.MsgInfo> msgBoardList;

    public HomePageMsgBoardAdapter(Context context, List<MsgBoardInfoBean.MsgInfo> msgBoardList){
        this.context = context;
        this.msgBoardList = msgBoardList;

        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return msgBoardList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return msgBoardList.get(groupPosition).getCommentInfos().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return msgBoardList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return msgBoardList.get(groupPosition).getCommentInfos().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public int getChildTypeCount() {
        return 1;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder holder;
        if (convertView == null) {
            holder = new GroupViewHolder();
            convertView = layoutInflater.inflate(R.layout.item_homepage_msg_list_outer, null);
            holder.lable = (TextView) convertView.findViewById(R.id.lable);
            convertView.setTag(holder);
        } else {
            holder = (GroupViewHolder) convertView.getTag();
        }

        holder.lable.setText(msgBoardList.get(groupPosition).getMsgContent());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        TextViewHolder textViewHolder = null;

        if (null != convertView) {
            ((LinearLayout) convertView).removeAllViews();
        }

        convertView = layoutInflater.inflate(R.layout.item_homepage_msg_list_inner, null);
        textViewHolder = new TextViewHolder();
        textViewHolder.lable = (TextView) convertView.findViewById(R.id.lable);

        textViewHolder.lable.setText(msgBoardList.get(groupPosition).getCommentInfos().get(childPosition).getCommentContent());

        return convertView;
    }

    class GroupViewHolder {
        private TextView lable;
    }

    class TextViewHolder {
        private TextView lable;
    }
}
