package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.ComponentName;
import android.net.Uri;
import android.os.IBinder;
import com.tencent.mm.plugin.webview.model.z;
import com.tencent.mm.plugin.webview.ui.tools.widget.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.widget.MMWebView;

public class b extends c {

    private class a extends c.c {
        final /* synthetic */ b siz;

        public a(b bVar) {
            this.siz = bVar;
            super(bVar);
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            w.i("MicroMsg.GameFloatWebViewClient", "onServiceConnected");
            if (this.siz.qjb == null) {
                w.e("MicroMsg.GameFloatWebViewClient", "onServiceConnected, activity destroyed");
                return;
            }
            try {
                this.siz.sir = com.tencent.mm.plugin.webview.stub.d.a.V(iBinder);
                this.siz.sir.a(this.siz.snr, this.siz.qjb.hashCode());
                this.siz.bzV();
                this.siz.a(this.siz.sir, this.siz.sjT);
                this.siz.bzf();
            } catch (Exception e) {
                w.e("MicroMsg.GameFloatWebViewClient", "addCallback fail, ex = %s", new Object[]{e.getMessage()});
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            super.onServiceDisconnected(componentName);
        }
    }

    public b(MMWebView mMWebView) {
        super(mMWebView, false);
        this.snq = new a(this);
    }

    protected boolean JX(String str) {
        return super.JX(str);
    }

    protected final void bzf() {
        try {
            this.sir.a(this.snj, true, null);
        } catch (Exception e) {
            w.w("MicroMsg.GameFloatWebViewClient", "postBinded, jumpToActivity, ex = " + e.getMessage());
        }
        if (!Kl(this.snj)) {
            Uri parse = Uri.parse(this.snj);
            if (parse.getScheme() == null) {
                this.snj += "http://";
                parse = Uri.parse(this.snj);
            }
            if (parse.getScheme().startsWith("http")) {
                w.i("MicroMsg.GameFloatWebViewClient", "uri scheme not startwith http, scheme = " + parse.getScheme());
                this.sni = new com.tencent.mm.plugin.webview.ui.tools.widget.c.a(this.snn ? "" : this.snj);
                this.snn = false;
                if (!this.mmV && !this.sjT.has(this.snj)) {
                    if (JO(this.snj)) {
                        xG(this.snj);
                        this.mmO = this.snj;
                    }
                    aB(this.snj, false);
                } else if (!z.IN(this.snj)) {
                    w.f("MicroMsg.GameFloatWebViewClient", "loadInitialUrl, canLoadUrl fail, url = " + this.snj);
                    JY(this.snj);
                } else if (JO(this.snj)) {
                    xG(this.snj);
                } else {
                    this.qjb.loadUrl(this.snj);
                }
            } else if (z.IN(this.snj)) {
                this.qjb.loadUrl(this.snj);
            } else {
                JY(this.snj);
            }
        }
    }
}
