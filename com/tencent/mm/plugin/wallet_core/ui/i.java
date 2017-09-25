package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.rv.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import java.util.Iterator;

public final class i {
    public static Dialog a(final Context context, final b bVar) {
        View inflate = LayoutInflater.from(context).inflate(R.i.dqE, null);
        ImageView imageView = (ImageView) inflate.findViewById(R.h.bCB);
        int a = BackwardSupportUtil.b.a(context, 15.0f);
        bg.j(imageView, a, a, a, a);
        TextView textView = (TextView) inflate.findViewById(R.h.cgU);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.h.cgV);
        Button button = (Button) inflate.findViewById(R.h.cKW);
        TextView textView2 = (TextView) inflate.findViewById(R.h.cgR);
        ((TextView) inflate.findViewById(R.h.cgW)).setText(bVar.title);
        textView.setText(bVar.fZm);
        linearLayout.removeAllViews();
        Iterator it = bVar.fZn.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            View inflate2 = LayoutInflater.from(context).inflate(R.i.dqF, null);
            ((TextView) inflate2.findViewById(R.h.cTj)).setText(str);
            linearLayout.addView(inflate2);
        }
        button.setText(bVar.fZg);
        if (bVar.fZh > 0) {
            a = bVar.fZi.length();
            int length = (bVar.fZi + bVar.fZl).length();
            CharSequence spannableString = new SpannableString(bVar.fZi + bVar.fZl);
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.e.aWn)), a, length, 33);
            textView2.setText(spannableString);
        } else {
            textView2.setText("");
        }
        textView2.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                w.i("MicroMsg.WalletIdCardTip", "go to url %s", new Object[]{bVar.fZk});
                intent.putExtra("rawUrl", r1);
                intent.putExtra("geta8key_username", m.xL());
                intent.putExtra("pay_channel", 1);
                d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            }
        });
        final Dialog dialog = new Dialog(context, R.m.foK);
        dialog.setContentView(inflate);
        dialog.setTitle(null);
        dialog.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                w.i("MicroMsg.WalletIdCardTip", "SnsLuckyMoneyNewYearTipsUI onCancel");
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        });
        imageView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        });
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                w.i("MicroMsg.WalletIdCardTip", "go to url %s", new Object[]{bVar.fZj});
                intent.putExtra("rawUrl", r1);
                intent.putExtra("geta8key_username", m.xL());
                intent.putExtra("pay_channel", 1);
                d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
        return dialog;
    }
}
