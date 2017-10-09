package com.lq.ren.keepfit.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lq.ren.keepfit.R;

public class IndicatorView extends LinearLayout {

    private static final int SIZE = 4;

    private static final int[] iconIds = {R.drawable.ic_menu_about, R.drawable.ic_menu_favor,
            R.drawable.ic_menu_history, R.drawable.ic_menu_profile};
    private static final int[] pageNames = {R.string.page0, R.string.page1, R.string.page2, R.string.page3};

    private int indicatorIconSize;
    private int gapSize;
    private int indicatorTextSize;
    private ImageView lastClickView;
    private IndicatorClickListener listener;

    public IndicatorView(Context context) {
        super(context);
    }

    public IndicatorView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public IndicatorView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setIndicatorView() {
        if (getChildCount() != SIZE) {
            if (getChildCount() != 0) {
                removeAllViews();
            }
            indicatorIconSize = getResources().getDimensionPixelSize(R.dimen.indicator_selected_current_icons_size);
            gapSize = getResources().getDimensionPixelSize(R.dimen.indicator_icons_gap);
            indicatorTextSize = getResources().getDimensionPixelSize(R.dimen.indicator_text_size);
            init(SIZE);
        }
        lastClickView = (ImageView) getChildAt(0);
        lastClickView.setColorFilter(getResources().getColor(R.color.indicator_selected_color));

        for (int i = 0; i < getChildCount(); i++) {
            ImageView view = (ImageView) getChildAt(i);
            LayoutParams params = new LayoutParams(indicatorIconSize, indicatorIconSize);
            params.gravity = Gravity.CENTER_VERTICAL;
            params.leftMargin = gapSize;
            params.rightMargin = gapSize;

            view.setLayoutParams(params);
            view.setImageResource(iconIds[i]);
            view.setId(i);

            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    int index = view.getId();
                    if (lastClickView.equals(view) || lastClickView.getId() == index) {
                        return;
                    }
                    ((ImageView) view).setColorFilter(getResources().getColor(R.color.indicator_selected_color));
                    lastClickView.setColorFilter(getResources().getColor(R.color.indicator_unselected_color));

                    listener.onIndicatorClick(index);
                    lastClickView = (ImageView) view;
                }
            });
        }
    }

    @SuppressLint("InflateParams")
    private void init(int size) {
        this.setOrientation(HORIZONTAL);
        this.setGravity(Gravity.CENTER_HORIZONTAL);
        removeAllViews();

        for (int i = 0; i < size; i++) {
            LayoutParams params = new LayoutParams(indicatorIconSize, indicatorIconSize);
            params.setMargins(gapSize, 0, 0, 0);
            addView(new ImageView(getContext()), params);
        }
    }

    public void setOnIndicatorClick(IndicatorClickListener listener) {
        this.listener = listener;
    }

    public interface IndicatorClickListener {
        void onIndicatorClick(int pageIndex);
    }
}
