package com.tencent.mm.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.q;

public final class g extends q {
    private View Ih = null;
    private ProgressBar jqh;
    private Context mContext;
    private TextView vhU;

    private g(Context context, int i) {
        super(context, i);
        this.mContext = context;
        if (this.Ih == null) {
            this.Ih = View.inflate(this.mContext, R.i.drj, null);
            this.vhU = (TextView) this.Ih.findViewById(R.h.ckl);
            this.jqh = (ProgressBar) this.Ih.findViewById(R.h.ckk);
            setCanceledOnTouchOutside(true);
        }
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.Ih, new LayoutParams(-1, -1));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        getWindow().addFlags(2);
        attributes.dimAmount = 0.65f;
        onWindowAttributesChanged(attributes);
    }

    public final void setCancelable(boolean z) {
        super.setCancelable(z);
        setCanceledOnTouchOutside(z);
    }

    public final void setMessage(CharSequence charSequence) {
        this.vhU.setText(charSequence);
    }

    public static Dialog a(Context context, CharSequence charSequence, boolean z, OnCancelListener onCancelListener) {
        Dialog gVar = new g(context, R.m.foK);
        gVar.setMessage(charSequence);
        gVar.setCancelable(z);
        gVar.setOnCancelListener(onCancelListener);
        gVar.setCanceledOnTouchOutside(false);
        gVar.show();
        return gVar;
    }

    public static Dialog a(Context context, boolean z, OnCancelListener onCancelListener) {
        View inflate = View.inflate(context, R.i.drk, null);
        Dialog iVar = new i(context, R.m.foH);
        iVar.setCancelable(z);
        iVar.setContentView(inflate);
        iVar.setOnCancelListener(onCancelListener);
        iVar.show();
        return iVar;
    }

    public static Dialog e(Context context, OnCancelListener onCancelListener) {
        View inflate = View.inflate(context, R.i.drk, null);
        Dialog iVar = new i(context, R.m.foH);
        iVar.setCancelable(true);
        iVar.setContentView(inflate);
        iVar.setCanceledOnTouchOutside(false);
        iVar.setOnCancelListener(onCancelListener);
        iVar.show();
        return iVar;
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            w.e("MicroMsg.WalletProgressDialog", "dismiss exception, e = " + e.getMessage());
        }
    }
}
