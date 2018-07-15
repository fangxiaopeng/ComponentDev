package com.fxp.module_common.recyclerview;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Title:       LinearItemDecoration
 * <p>
 * Package:     com.fxp.module_common.recyclerview
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/15 下午7:26
 * <p>
 * Description: LinearLayoutManager 设置item的间隔
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
public class LinearItemDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public LinearItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;

        // Add top margin only for the first item to avoid double space between items
        if (parent.getChildPosition(view) == 0)
            outRect.top = space;
    }
}
