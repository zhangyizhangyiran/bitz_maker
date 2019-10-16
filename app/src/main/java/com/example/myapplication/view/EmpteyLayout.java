package com.example.myapplication.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.myapplication.R;

public class EmpteyLayout extends LinearLayout {
    public EmpteyLayout(Context context) {
        this(context, null);
    }

    public EmpteyLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EmpteyLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {

        LayoutInflater lif = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View inflate = lif.inflate(R.layout.positions_item, null, true);
        View inflate = lif.inflate(R.layout.emptey_item, EmpteyLayout.this, false);
        EmpteyLayout.this.addView(inflate);

    }
}
