package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.s.a.l;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.r;

public final class p extends q {
    private View Ih;
    public ProgressBar jqh;
    private Context mContext;
    private int style;
    private TextView vhU;

    private p(Context context, int i, int i2) {
        int i3;
        super(context, i);
        this.mContext = context;
        this.style = i2;
        switch (this.style) {
            case 0:
                i3 = h.heD;
                break;
            case 1:
                i3 = h.heE;
                break;
            case 2:
                i3 = h.heD;
                break;
            default:
                i3 = h.heD;
                break;
        }
        this.Ih = r.eC(this.mContext).inflate(i3, null);
        this.vhU = (TextView) this.Ih.findViewById(g.ckl);
        this.jqh = (ProgressBar) this.Ih.findViewById(g.ckk);
        setCanceledOnTouchOutside(true);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.Ih, new LayoutParams(-1, -1));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        if (this.style == 2) {
            getWindow().addFlags(2);
            attributes.dimAmount = 0.65f;
        }
        onWindowAttributesChanged(attributes);
    }

    public final void setCancelable(boolean z) {
        super.setCancelable(z);
        setCanceledOnTouchOutside(z);
    }

    public final void setMessage(CharSequence charSequence) {
        this.vhU.setText(charSequence);
    }

    public static p a(Context context, CharSequence charSequence, boolean z, int i, OnCancelListener onCancelListener) {
        int i2;
        switch (i) {
            case 0:
                i2 = l.foK;
                break;
            case 1:
                i2 = l.foK;
                break;
            case 2:
                i2 = l.foK;
                break;
            default:
                i2 = l.hfx;
                break;
        }
        p pVar = new p(context, i2, i);
        pVar.setMessage(charSequence);
        pVar.setCancelable(z);
        pVar.setOnCancelListener(onCancelListener);
        pVar.setCanceledOnTouchOutside(false);
        return pVar;
    }

    public static p b(Context context, CharSequence charSequence, boolean z, int i, OnCancelListener onCancelListener) {
        p a = a(context, charSequence, z, i, onCancelListener);
        a.show();
        return a;
    }

    public final void show() {
        try {
            super.show();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MMProgressDialog", e, "", new Object[0]);
        }
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            w.e("MicroMsg.MMProgressDialog", "dismiss exception, e = " + e.getMessage());
        }
    }
}
