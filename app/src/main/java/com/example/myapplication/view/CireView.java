package com.example.myapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.myapplication.R;

public class CireView extends View {
    public CireView(Context context) {
        super(context);
    }

    public CireView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CireView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paints = new Paint();
        paints.setAntiAlias(true);
        paints.setStrokeWidth(10);
        paints.setStyle(Paint.Style.STROKE);
        paints.setStrokeCap(Paint.Cap.ROUND);

        Paint paints1 = new Paint();
        paints1.setAntiAlias(true);
        paints1.setStrokeWidth(10);
        paints1.setStyle(Paint.Style.STROKE);
        paints1.setStrokeCap(Paint.Cap.ROUND);


        Paint paints2 = new Paint();
        paints2.setAntiAlias(true);
        paints2.setStrokeWidth(10);
        paints2.setStyle(Paint.Style.STROKE);
        paints2.setStrokeCap(Paint.Cap.ROUND);


        paints.setColor(getResources().getColor(R.color.colorAccent));
        paints1.setColor(getResources().getColor(R.color.colorPrimary));
        paints2.setColor(getResources().getColor(R.color.colorAccente));

//        canvas.drawCircle(100, 100, 100, paints);
        RectF reactf = new RectF(10, 10, 120, 120);

        canvas.drawArc(reactf, 0, 150, false, paints);
        canvas.drawArc(reactf, 150, 100, false, paints1);
        canvas.drawArc(reactf, 250, 110, false, paints2);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(180, 180);
    }
}
