package com.anynew.mine;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by dell on 2016/7/17.
 */
public class CustomView extends View {
    private String mTitleText;
    private int mTitlecolor;
    private int mTitleTextSize;

    private Rect mBound;
    private Paint mPaint;

    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTitleView, defStyleAttr, 0);
        for (int x = 0; x < ta.getIndexCount(); x++) {
            int attr = ta.getIndex(x);
            switch (attr) {
                case R.styleable.CustomTitleView_titleText:
                    mTitleText = ta.getString(attr);
                    break;
                case R.styleable.CustomTitleView_titleColor:
                    mTitlecolor = ta.getColor(attr, Color.BLUE);
                    break;
                case R.styleable.CustomTitleView_titleTextSize:
                    mTitleTextSize = ta.getDimensionPixelSize(attr, (int) TypedValue
                            .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, getResources().getDisplayMetrics()));
                    break;
            }
        }
        ta.recycle();

        mPaint = new Paint();
        mPaint.setTextSize(mTitleTextSize);
        mPaint.setColor(mTitlecolor);

        mBound = new Rect();
        mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint);
        mPaint.setColor(mTitlecolor);
        canvas.drawText(mTitleText, getWidth() / 2 - mBound.width() / 2, getHeight() / 2 + mBound.height() / 2, mPaint);

    }
}
