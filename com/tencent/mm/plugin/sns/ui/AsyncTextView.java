package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.ui.d.m;
import com.tencent.mm.pluginsdk.ui.d.m.a;

public class AsyncTextView extends TextView implements Runnable {
    private Context context;
    public int knu;
    public String qpK;
    public boolean qpL;
    public String qpM;
    public a qpN;
    public boolean qpO;
    public String userName;

    public AsyncTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
    }

    public AsyncTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public void run() {
        if (getTag() instanceof String) {
            String str = (String) getTag();
            if (str != null && str.equals(this.userName)) {
                return;
            }
        }
        int i = this.knu == 11 ? 3 : 2;
        m mVar = new m(new com.tencent.mm.plugin.sns.data.a(this.qpL, this.userName, this.qpM, 1), this.qpN, i);
        Context context = getContext();
        CharSequence charSequence = this.qpK;
        getTextSize();
        CharSequence iVar = new i(h.d(context, charSequence, i));
        iVar.f(mVar, this.qpK);
        setText(iVar, BufferType.SPANNABLE);
        setTag(this.userName);
    }

    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (Throwable th) {
        }
    }

    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Throwable th) {
        }
    }

    public int getBaseline() {
        try {
            return super.getBaseline();
        } catch (Throwable th) {
            return -1;
        }
    }

    public boolean onPreDraw() {
        try {
            return super.onPreDraw();
        } catch (Throwable th) {
            return true;
        }
    }
}
