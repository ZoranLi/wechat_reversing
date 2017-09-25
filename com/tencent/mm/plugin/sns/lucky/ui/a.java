package com.tencent.mm.plugin.sns.lucky.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;

public final class a {
    public static Dialog e(Context context, final View view) {
        View inflate = LayoutInflater.from(context).inflate(g.pGJ, null);
        String str = v.bIK() ? "font_1.otf" : v.bIL() ? "font_2.otf" : null;
        TextView textView = (TextView) inflate.findViewById(f.pDl);
        if (!bg.mA(str)) {
            textView.setTypeface(Typeface.createFromAsset(context.getAssets(), str));
        }
        if (!v.bIJ()) {
            textView.setTextSize(1, 10.0f);
        }
        final Dialog dialog = new Dialog(context, k.foK);
        dialog.setContentView(inflate);
        dialog.setTitle(null);
        dialog.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                w.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog onCancel");
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        });
        ((TextView) inflate.findViewById(f.pCE)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                w.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog onClick");
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
                View view2 = view;
                if (view2 != null) {
                    view2.performClick();
                }
            }
        });
        View findViewById = inflate.findViewById(f.pGh);
        int a = b.a(context, 10.0f);
        bg.j(findViewById, a, a, a, a);
        findViewById.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                w.i("MicroMsg.SnsLuckyCommentAlertUI", "showTipsDialog OnClick: close");
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
        return dialog;
    }
}
