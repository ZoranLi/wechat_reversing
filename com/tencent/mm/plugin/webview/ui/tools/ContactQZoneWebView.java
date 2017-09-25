package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.a.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public class ContactQZoneWebView extends WebViewUI {
    private String opD = "";
    private String saA = "";
    private boolean saz = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        qP(getString(R.l.dZa));
        this.oET.setWebViewClient(new WebViewClient(this) {
            final /* synthetic */ ContactQZoneWebView saB;

            {
                this.saB = r1;
            }

            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str.startsWith("weixin://viewimage/")) {
                    this.saB.JC(str);
                    webView.stopLoading();
                } else if (!(str.startsWith("weixinping://iframe") || str.startsWith("weixinpreinject://iframe"))) {
                    webView.loadUrl(str);
                }
                return true;
            }

            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                if (str.startsWith("weixin://viewimage/")) {
                    this.saB.JC(str);
                    webView.stopLoading();
                } else if (str.equals(this.saB.opD)) {
                    bg.F(this.saB, str);
                    webView.stopLoading();
                } else {
                    super.onPageStarted(webView, str, bitmap);
                }
            }
        });
        this.oET.loadUrl(this.fWY);
        w.d("MicroMsg.ContactQZoneWebView", "loadUrl:loadUrl, url = " + this.fWY);
    }

    protected void onResume() {
        super.onResume();
        this.saz = false;
    }

    final void JC(String str) {
        if (!this.saz) {
            this.saz = true;
            String substring = str.substring(19);
            w.d("MicroMsg.ContactQZoneWebView", "get url :" + substring);
            Intent intent = new Intent();
            intent.putExtra("nowUrl", substring);
            intent.putExtra("tweetid", bg.mz(getIntent().getStringExtra("tweetid")));
            intent.putExtra("htmlData", this.saA);
            intent.putExtra(Columns.TYPE, getIntent().getIntExtra(Columns.TYPE, 0));
            Bundle bundle = new Bundle();
            bundle.putInt("stat_scene", 4);
            bundle.putString("stat_url", azN());
            intent.putExtra("_stat_obj", bundle);
            startActivity(intent);
            a.imv.u(intent, this);
        }
    }
}
