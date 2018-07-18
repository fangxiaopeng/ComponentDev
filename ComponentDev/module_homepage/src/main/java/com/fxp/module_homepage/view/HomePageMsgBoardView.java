package com.fxp.module_homepage.view;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.fxp.module_common.inter.RefreshListener;
import com.fxp.module_common.utils.Constants;
import com.fxp.module_common.utils.DensityUtils;
import com.fxp.module_homepage.R;
import com.fxp.module_homepage.adapter.HomePageMsgBoardAdapter;
import com.fxp.module_homepage.inter.RequestListener;
import com.fxp.module_homepage.model.MsgBoardInfoBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;

/**
 * Title:       HomePageMsgBoardView
 * <p>
 * Package:     com.fxp.module_homepage.view
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/16 上午11:24
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
public class HomePageMsgBoardView extends BaseView implements RefreshListener{

    private final static String TAG = HomePageMsgBoardView.class.getSimpleName();

    private TextView joinNumTextView, commentNumTextView;

    private EditText msgInputEditText;

    private TextView msgPublishBtn;

    private ExpandableListView msgBoardExpandableListView;

    private List<MsgBoardInfoBean.MsgInfo> msgBoardList;

    private HomePageMsgBoardAdapter msgBoardAdapter;

    public HomePageMsgBoardView(Context context, ScrollView mainView){
        super(context, mainView);

    }

    @Override
    protected void findViews() {
        joinNumTextView = mainView.findViewById(R.id.txt_join_num);
        commentNumTextView = mainView.findViewById(R.id.txt_msg_num);
        msgBoardExpandableListView = mainView.findViewById(R.id.exp_msg_board_list);
        msgInputEditText = mainView.findViewById(R.id.edit_msg_input);
        msgPublishBtn = mainView.findViewById(R.id.txt_msg_publish);
    }

    @Override
    protected void initViews() {

        initMsgBoardList();

        refreshViews();
    }

    @Override
    protected void initDatas() {
        msgBoardList = new ArrayList<MsgBoardInfoBean.MsgInfo>();
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void refresh() {

    }

    /**
     * @Description:  刷新视图
     *
     * @Author:  fxp
     * @Date:    2018/7/16   下午4:07
     * @param
     * @return   void
     * @exception/throws
     */
    private void refreshViews(){
        requestData(Constants.PATH_HOMEPAGE_MSGBOARDINFO, MsgBoardInfoBean.class, new RequestListener() {
            @Override
            public void onSuccess(Object object) {
                MsgBoardInfoBean msgBoardInfo = (MsgBoardInfoBean)object;
                if (msgBoardInfo != null){
                    updateUI(msgBoardInfo);
                }
            }

            @Override
            public void onFailed(String error) {
                Toast.makeText(context, "RequestData Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * @Description: 更新UI
     *
     * @Author:  fxp
     * @Date:    2018/7/16   下午4:17
     * @param    msgBoardInfo
     * @return   void
     * @exception/throws
     */
    private void updateUI(@NonNull MsgBoardInfoBean msgBoardInfo){
        Log.i(TAG, "updateUI");

        joinNumTextView.setText(msgBoardInfo.getJoinNum() + "");

        commentNumTextView.setText(msgBoardInfo.getMsgNum() + "");

        adjustExpandableListHeight(msgBoardInfo);

        updateMsgBoardList(msgBoardInfo);
    }

    private void initMsgBoardList(){
        msgBoardAdapter = new HomePageMsgBoardAdapter(context, msgBoardList);
        msgBoardExpandableListView.setAdapter(msgBoardAdapter);
        msgBoardExpandableListView.setGroupIndicator(null);
    }

    /**
     * @Description: 动态调整ExpandableList高度
     * 解决ScrollView嵌套导致列表显示不全问题
     *
     * @Author:  fxp
     * @Date:    2018/7/16   下午5:11
     * @param    msgBoardInfo
     * @return   void
     * @exception/throws
     */
    private void adjustExpandableListHeight(@NonNull MsgBoardInfoBean msgBoardInfo){
        // fixme: 当前固定320dp，待完善

        int listHeight = DensityUtils.dip2px(context, 320);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) msgBoardExpandableListView.getLayoutParams();
        layoutParams.height = listHeight;
        msgBoardExpandableListView.setLayoutParams(layoutParams);
    }

    /**
     * @Description: 更新留言板
     *
     * @Author:  fxp
     * @Date:    2018/7/16   下午4:18
     * @param    msgBoardInfo
     * @return   void
     * @exception/throws
     */
    private void updateMsgBoardList(@NonNull MsgBoardInfoBean msgBoardInfo){
        msgBoardList.clear();
        msgBoardList.addAll(msgBoardInfo.getMsgInfos());
        if (msgBoardAdapter == null){
            msgBoardAdapter = new HomePageMsgBoardAdapter(context, msgBoardList);
            msgBoardExpandableListView.setAdapter(msgBoardAdapter);
        }else {
            msgBoardAdapter.notifyDataSetChanged();
            //设置为展开状态
            for (int i = 0; i < msgBoardAdapter.getGroupCount(); i++) {
                msgBoardExpandableListView.expandGroup(i);
            }
        }
    }
}
