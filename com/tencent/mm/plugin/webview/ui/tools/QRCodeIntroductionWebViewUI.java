package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.c;

public class QRCodeIntroductionWebViewUI extends WebViewUI {
    static /* synthetic */ void a(QRCodeIntroductionWebViewUI qRCodeIntroductionWebViewUI) {
        Context context = qRCodeIntroductionWebViewUI;
        g.a(context, "", new String[]{qRCodeIntroductionWebViewUI.getString(R.l.eWV), qRCodeIntroductionWebViewUI.getString(R.l.eHo)}, "", false, new c(qRCodeIntroductionWebViewUI) {
            final /* synthetic */ QRCodeIntroductionWebViewUI sby;

            {
                this.sby = r1;
            }

            public final void hq(int i) {
                switch (i) {
                    case 0:
                        this.sby.rVm.bzo();
                        return;
                    case 1:
                        this.sby.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.sby.bym())));
                        return;
                    default:
                        return;
                }
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(0, R.g.bhb, new OnMenuItemClickListener(this) {
            final /* synthetic */ QRCodeIntroductionWebViewUI sby;

            {
                this.sby = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                QRCodeIntroductionWebViewUI.a(this.sby);
                return true;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ QRCodeIntroductionWebViewUI sby;

            {
                this.sby = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.sby.finish();
                return true;
            }
        });
    }
}
