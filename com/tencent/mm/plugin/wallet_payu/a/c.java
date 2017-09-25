package com.tencent.mm.plugin.wallet_payu.a;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.wallet_core.ui.f;
import com.tencent.mm.plugin.wallet_core.ui.f.a;
import com.tencent.mm.sdk.platformtools.w;
import junit.framework.Assert;

public final class c {
    public static void a(final Context context, TextView textView) {
        boolean z = (context == null || textView == null) ? false : true;
        Assert.assertTrue(z);
        f fVar = new f(context);
        fVar.rKS = new a() {
            public final void onClick(View view) {
                w.i("MicroMsg.PayUUtil", "hy: user clicked the span");
                Intent intent = new Intent();
                intent.putExtra("rawUrl", "https://www.payu.co.za/wechat/terms-and-conditions/");
                intent.putExtra("showShare", false);
                d.b(context, "webview", ".ui.tools.WebViewUI", intent);
            }
        };
        f fVar2 = new f(context);
        fVar2.rKS = new a() {
            public final void onClick(View view) {
                w.i("MicroMsg.PayUUtil", "hy: user clicked the tos span");
                Intent intent = new Intent();
                intent.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/readtemplate?lang=en_US&check=false&t=weixin_agreement&s=terms");
                intent.putExtra("showShare", false);
                d.b(context, "webview", ".ui.tools.WebViewUI", intent);
            }
        };
        String charSequence = context.getText(R.l.fiX).toString();
        CharSequence spannableString = new SpannableString(charSequence);
        spannableString.setSpan(fVar, 94, 115, 33);
        spannableString.setSpan(fVar2, charSequence.length() - 3, charSequence.length(), 33);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
