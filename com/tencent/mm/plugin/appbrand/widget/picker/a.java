package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mm.R;

public final class a extends g {
    private static final int jtC = R.h.bpm;

    public static a bZ(View view) {
        return (a) view.getRootView().findViewById(jtC);
    }

    public a(Context context) {
        super(context);
        super.setId(jtC);
        setBackgroundResource(R.e.aUk);
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a jyf;

            {
                this.jyf = r1;
            }

            public final void onClick(View view) {
                this.jyf.hide();
            }
        });
    }

    protected final void onMeasure(int i, int i2) {
        if (isShown()) {
            int i3;
            if (getParent() == null || !(getParent() instanceof ViewGroup)) {
                i3 = 0;
            } else {
                i3 = ((ViewGroup) getParent()).getMeasuredHeight();
            }
            if (i3 > 0) {
                bB(i, MeasureSpec.makeMeasureSpec(i3, 1073741824));
                return;
            }
        }
        super.onMeasure(i, i2);
    }

    public final void setId(int i) {
    }

    public final void show() {
        super.show();
    }

    public final void hide() {
        super.hide();
    }
}
