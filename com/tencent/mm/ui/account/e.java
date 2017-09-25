package com.tencent.mm.ui.account;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.account.mobile.MobileInputUI;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;

public final class e {

    static class AnonymousClass1 implements c {
        final /* synthetic */ int uXU;
        final /* synthetic */ Context val$context;

        AnonymousClass1(int i, Context context) {
            this.uXU = i;
            this.val$context = context;
        }

        public final void a(l lVar) {
            if ((this.uXU & 1) != 0) {
                lVar.e(1, this.val$context.getString(R.l.eIX));
            }
            if ((this.uXU & 2) != 0) {
                lVar.e(2, this.val$context.getString(R.l.eIY));
            }
            if ((this.uXU & 4) != 0) {
                lVar.e(4, this.val$context.getString(R.l.eIW));
            }
            if ((this.uXU & 8) > 0) {
                lVar.e(8, this.val$context.getString(R.l.ewP));
            }
        }
    }

    static class AnonymousClass2 implements d {
        final /* synthetic */ String uXV = null;
        final /* synthetic */ String uXW = null;
        final /* synthetic */ String uXX = null;
        final /* synthetic */ Context val$context;

        AnonymousClass2(Context context, String str, String str2, String str3) {
            this.val$context = context;
        }

        public final void c(MenuItem menuItem, int i) {
            String str;
            switch (menuItem.getItemId()) {
                case 1:
                    b.mN("F100_100_QQ");
                    b.b(true, ap.uY() + "," + this.val$context.getClass().getName() + ",F100_100_QQ," + ap.ec("F100_100_QQ") + ",1");
                    e.i(this.val$context, this.val$context.getString(R.l.eZr), false);
                    return;
                case 2:
                    b.mN("F100_100_Email");
                    b.b(true, ap.uY() + "," + this.val$context.getClass().getName() + ",F100_100_Email," + ap.ec("F100_100_Email") + ",1");
                    e.i(this.val$context, this.val$context.getString(R.l.eZq), false);
                    return;
                case 4:
                    Context context = this.val$context;
                    String str2 = this.uXV;
                    str = this.uXW;
                    String str3 = this.uXX;
                    b.mN("F100_100_phone");
                    b.b(true, ap.uY() + "," + context.getClass().getName() + ",F100_100_phone," + ap.ec("F100_100_phone") + ",1");
                    if (com.tencent.mm.protocal.d.sYQ) {
                        Toast.makeText(context, context.getString(R.l.dDe), 0).show();
                        return;
                    }
                    Intent intent = new Intent(context, MobileInputUI.class);
                    if (str != null) {
                        int indexOf = str.indexOf("+");
                        if (indexOf != -1 && str.length() > 0) {
                            str = str.substring(indexOf + 1);
                        }
                        intent.putExtra("couttry_code", str);
                    }
                    if (str2 != null) {
                        intent.putExtra("country_name", str2);
                    }
                    if (str3 != null) {
                        intent.putExtra("bindmcontact_shortmobile", str3);
                    }
                    intent.putExtra("mobile_input_purpose", 1);
                    context.startActivity(intent);
                    return;
                case 8:
                    str = this.val$context.getString(R.l.fnd);
                    if (v.bIN().equals("zh_CN")) {
                        str = str + "zh_CN";
                    } else {
                        str = "https://help.wechat.com/cgi-bin/newreadtemplate?t=help_center/w_index&Channel=Client&lang=";
                    }
                    e.i(this.val$context, str, false);
                    return;
                default:
                    return;
            }
        }
    }

    public static void i(Context context, String str, boolean z) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sYW);
        intent.putExtra("KFromLoginHistory", false);
        com.tencent.mm.bb.d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }
}
