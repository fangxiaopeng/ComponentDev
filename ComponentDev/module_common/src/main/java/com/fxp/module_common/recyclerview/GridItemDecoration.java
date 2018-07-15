package com.fxp.module_common.recyclerview;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Title:       GridItemDecoration
 * <p>
 * Package:     com.fxp.module_common.recyclerview
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2018/7/15 下午5:20
 * <p>
 * Description: GridLayoutManager（网格布局）设置item的间隔
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
public class GridItemDecoration extends RecyclerView.ItemDecoration {

    // 列数
    private int spanCount;

    // 间隔
    private int spacing;

    // 是否包含边缘
    private boolean includeEdge;

    public GridItemDecoration(int spanCount, int spacing, boolean includeEdge) {
        this.spanCount = spanCount;
        this.spacing = spacing;
        this.includeEdge = includeEdge;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        // item position
        int position = parent.getChildAdapterPosition(view);
        // item column
        int column = position % spanCount;
        if (includeEdge) {
            outRect.left = spacing - column * spacing / spanCount;  // spacing - column * ((1f / spanCount) * spacing)
            outRect.right = (column + 1) * spacing / spanCount;     // (column + 1) * ((1f / spanCount) * spacing)

            if (position < spanCount) {  // top edge
                outRect.top = spacing;
            }
            outRect.bottom = spacing;    // item bottom
        } else {
            outRect.left = column * spacing / spanCount;    // column * ((1f / spanCount) * spacing)
            outRect.right = spacing - (column + 1) * spacing / spanCount;    // spacing - (column + 1) * ((1f /    spanCount) * spacing)
            if (position >= spanCount) {
                outRect.top = spacing;  // item top
            }
        }
    }
}
