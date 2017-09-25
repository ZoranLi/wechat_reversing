package com.tencent.mm.ui.account;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;

public final class a extends BaseAdapter {
    private LayoutInflater myo;
    private String[] uWZ;
    private Drawable uXa = null;
    private OnTouchListener uXb = new OnTouchListener(this) {
        final /* synthetic */ a uXc;

        {
            this.uXc = r1;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                ((TextView) view.findViewById(R.h.bot)).setTextColor(-10395295);
            } else if (motionEvent.getAction() == 1) {
                ((TextView) view.findViewById(R.h.bot)).setTextColor(-1);
            }
            return false;
        }
    };

    public a(Context context, String[] strArr) {
        this.uWZ = strArr;
        this.myo = LayoutInflater.from(context);
        this.uXa = context.getResources().getDrawable(R.g.bka);
        this.uXa.setBounds(0, 0, this.uXa.getIntrinsicWidth(), this.uXa.getIntrinsicHeight());
    }

    public final int getCount() {
        return this.uWZ.length;
    }

    public final Object getItem(int i) {
        return this.uWZ[i];
    }

    private boolean zz(int i) {
        if (i == this.uWZ.length - 1) {
            return true;
        }
        return false;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int i2 = 1;
        if (view == null) {
            view = this.myo.inflate(R.i.cTJ, null);
        }
        TextView textView = (TextView) view.findViewById(R.h.bot);
        view.setOnTouchListener(this.uXb);
        if ((i == 0 ? 1 : 0) == 0 || !zz(i)) {
            if (i != 0) {
                i2 = 0;
            }
            if (i2 != 0) {
                textView.setPadding(25, 0, 10, 10);
                textView.setCompoundDrawablePadding(10);
                textView.setCompoundDrawables(null, null, this.uXa, null);
            } else if (zz(i)) {
                textView.setPadding(0, 0, 25, 10);
                textView.setCompoundDrawablePadding(0);
                textView.setCompoundDrawables(null, null, null, null);
            } else {
                textView.setPadding(0, 0, 10, 10);
                textView.setCompoundDrawablePadding(10);
                textView.setCompoundDrawables(null, null, this.uXa, null);
            }
        } else {
            textView.setPadding(25, 0, 25, 10);
            textView.setCompoundDrawablePadding(0);
            textView.setCompoundDrawables(null, null, null, null);
        }
        textView.setText(this.uWZ[i]);
        return view;
    }
}
