package com.tencent.mm.plugin.appbrand.widget.b;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.r;

public class a extends h {
    private View ipu;
    public OnShowListener jrV;
    private OnDismissListener jrW;
    private OnCancelListener jrX;
    boolean jrY;
    public b jrZ;

    public a(Context context) {
        super(context);
    }

    public a(Context context, byte b) {
        super(context);
    }

    public final View getContentView() {
        if (this.ipu != null) {
            return this.ipu;
        }
        return super.getContentView();
    }

    public void setContentView(int i) {
        setContentView(r.eC(getContext()).inflate(i, null));
    }

    public void setContentView(View view) {
        this.ipu = view;
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        if (layoutParams != null) {
            view.setLayoutParams(layoutParams);
        }
        setContentView(view);
    }

    public void show() {
    }

    public void setOnShowListener(OnShowListener onShowListener) {
        super.setOnShowListener(onShowListener);
        this.jrV = onShowListener;
    }

    public final void onCancel() {
        if (this.jrX != null) {
            this.jrX.onCancel(this);
        }
    }

    public void dismiss() {
        if (this.jrZ != null) {
            this.jrZ.b(this);
            if (this.jrW != null) {
                this.jrW.onDismiss(this);
            }
        }
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        super.setOnDismissListener(onDismissListener);
        this.jrW = onDismissListener;
    }

    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        this.jrY = z;
    }

    public void setOnCancelListener(OnCancelListener onCancelListener) {
        super.setOnCancelListener(onCancelListener);
        this.jrX = onCancelListener;
    }
}
