package com.dream.rxjavademo.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * 需求实现一个侧边快速导航栏
 * Created by Administrator on 2018/3/26.
 */

public class IndexBarView extends View {

    private List<String> dataList;
    private Paint textPaint;
    private int letterHeight;
    private OnIndexListenr onIndexListenr;

    public void setOnIndexListenr(OnIndexListenr onIndexListenr) {
        this.onIndexListenr = onIndexListenr;
    }

    public IndexBarView(Context context) {
        this(context, null);
    }

    public IndexBarView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IndexBarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        dataList = new ArrayList<>();
        dataList.add("A");
        dataList.add("B");
        dataList.add("C");
        dataList.add("D");
        dataList.add("E");
        dataList.add("F");
        dataList.add("G");
        dataList.add("H");
        dataList.add("I");
        dataList.add("J");
        dataList.add("K");
        textPaint = new Paint();
        textPaint.setColor(Color.RED);
        textPaint.setTextSize(50);
        textPaint.setAntiAlias(true);

        letterHeight = (int) (textPaint.descent() - textPaint.ascent());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < dataList.size(); i++) {
            if(!isUp){
                if(index == i){
                    textPaint.setColor(Color.BLACK);
                }else {
                    textPaint.setColor(Color.RED);
                }
            }else {
                textPaint.setColor(Color.RED);
            }

            canvas.drawText(dataList.get(i), getWidth() / 2 - textPaint.measureText(dataList.get(i)) / 2, letterHeight * (i + 1), textPaint);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureSpec(widthMeasureSpec, 0), measureSpec(heightMeasureSpec, 1));

    }

    private int measureSpec(int measureSpec, int type) {
        int mode = MeasureSpec.getMode(measureSpec);
        int maxSize = MeasureSpec.getSize(measureSpec);

        switch (mode) {
            case MeasureSpec.EXACTLY:
                return maxSize;
            case MeasureSpec.AT_MOST:
                switch (type) {
                    case 0:
                        return (int) (textPaint.measureText(dataList.get(0)) + getPaddingLeft() + getPaddingRight());
                    case 1:
                        return letterHeight * dataList.size() + getPaddingTop() + getPaddingBottom();
                }
                break;
        }

        return 0;
    }

    public void setDatas(List<String> datas){
        this.dataList = datas;
        invalidate();
    }

    int index = -1;
    private boolean isUp;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                downAndMoveEvent(event);
                break;
            case MotionEvent.ACTION_UP:
                isUp = true;
                index = -1;
                if(onIndexListenr != null){
                    onIndexListenr.onUpListener();
                }
                break;
        }
        invalidate();
        return true;
    }

    private void downAndMoveEvent(MotionEvent event) {
        int y = (int) event.getY();

        int in = y/letterHeight;

        if(in < 0){
            in = 0;
        }

        if(in > dataList.size() - 1){
            in = dataList.size() -1;
        }

        if(index != in){
            index = in;
        }else {
            return;
        }

        if(onIndexListenr != null){
            onIndexListenr.onDownAndMoveListener(in,dataList.get(in));
        }



        Log.d("print", "--->下标" + index);
        isUp = false;
    }

    public interface OnIndexListenr{
        void onDownAndMoveListener(int position, String text);
        void onUpListener();
    }
}
