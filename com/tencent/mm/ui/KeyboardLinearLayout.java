package com.tencent.mm.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;

public class KeyboardLinearLayout extends OnLayoutChangedLinearLayout {
    private int RQ;
    public String TAG;
    private boolean mHasInit;
    private boolean uRH;
    public a uRI;

    public interface a {
        void nx(int i);
    }

    public KeyboardLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "MicroMsg.KeyboardLinearLayout";
        this.mHasInit = false;
        this.mHasInit = false;
        this.RQ = 0;
        this.uRH = false;
        this.TAG += getId();
    }

    public KeyboardLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "MicroMsg.KeyboardLinearLayout";
        this.mHasInit = false;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        wl(i4);
    }

    public void wl(int i) {
        if (this.mHasInit) {
            this.RQ = this.RQ < i ? i : this.RQ;
        } else {
            this.mHasInit = true;
            this.RQ = i;
            w.i(this.TAG, "init height:%d", Integer.valueOf(this.RQ));
            if (this.uRI != null) {
                this.uRI.nx(-1);
            }
        }
        if (this.mHasInit && !this.uRH && this.RQ - i > 100) {
            this.uRH = true;
            nx(-3);
            w.w(this.TAG, "show keyboard!! mHeight: " + this.RQ + " b: " + i);
        }
        if (this.mHasInit && this.uRH && this.RQ - i <= 100) {
            this.uRH = false;
            nx(-2);
            w.w(this.TAG, "hide keyboard!! mHeight: " + this.RQ + " b: " + i);
        }
    }

    public void nx(int i) {
        if (this.uRI != null) {
            this.uRI.nx(i);
        }
    }
}
