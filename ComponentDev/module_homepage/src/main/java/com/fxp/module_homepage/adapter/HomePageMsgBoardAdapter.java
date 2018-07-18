package com.fxp.module_homepage.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
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
            holder.commentPhotoImageView = (ImageView) convertView.findViewById(R.id.img_comment_photo);
            holder.commentAccountTextView = (TextView) convertView.findViewById(R.id.txt_comment_account);
            holder.likeNumTextView = (TextView) convertView.findViewById(R.id.txt_like_num);
            holder.commentNumTextView = (TextView) convertView.findViewById(R.id.txt_comment_num);
            holder.commentTimeTextView = (TextView) convertView.findViewById(R.id.txt_comment_time);
            holder.commentAddressTextView = (TextView) convertView.findViewById(R.id.txt_comment_address);
            holder.commentContentTextView = (TextView) convertView.findViewById(R.id.txt_comment_content);
            convertView.setTag(holder);
        } else {
            holder = (GroupViewHolder) convertView.getTag();
        }

        holder.commentPhotoImageView.setImageResource(R.mipmap.photo_default_man);
        holder.commentAccountTextView.setText(msgBoardList.get(groupPosition).getMsgUser().getUserName());
        holder.commentNumTextView.setText(msgBoardList.get(groupPosition).getMsgCommentNum() + "");
        holder.likeNumTextView.setText(msgBoardList.get(groupPosition).getMsgThumbNum() + "");
        holder.commentTimeTextView.setText(msgBoardList.get(groupPosition).getMsgCreateTime());
        holder.commentAddressTextView.setText(msgBoardList.get(groupPosition).getMsgCreateAddress());
        holder.commentContentTextView.setText(msgBoardList.get(groupPosition).getMsgContent());

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
        textViewHolder.commentDetailTextView = (TextView) convertView.findViewById(R.id.txt_comment_detail);

        MsgBoardInfoBean.MsgInfo.CommentInfo commentInfo = msgBoardList.get(groupPosition).getCommentInfos().get(childPosition);

        String str = "<font color='#576b95'>" + commentInfo.getCommentUser().getUserName() + "</font>" + " 回复 " + "<font color='#576b95'>" + commentInfo.getTargetUser().getUserName() + "</font>" + "：" + commentInfo.getCommentContent();
        textViewHolder.commentDetailTextView.setText(Html.fromHtml(str));

        return convertView;
    }

    class GroupViewHolder {
        private ImageView commentPhotoImageView;
        private TextView commentAccountTextView;
        private TextView commentNumTextView;
        private TextView likeNumTextView;
        private TextView commentTimeTextView;
        private TextView commentAddressTextView;
        private TextView commentContentTextView;
    }

    class TextViewHolder {
        private TextView commentDetailTextView;
    }
}
