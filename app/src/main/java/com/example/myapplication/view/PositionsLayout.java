package com.example.myapplication.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.myapplication.R;

public class PositionsLayout extends LinearLayout {
    public PositionsLayout(Context context) {
        this(context, null);
    }

    public PositionsLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PositionsLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {

        LayoutInflater lif = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View inflate = lif.inflate(R.layout.positions_item, null, true);
        View inflate = lif.inflate(R.layout.positions_item, PositionsLayout.this, false);
        PositionsLayout.this.addView(inflate);

    }
}
