package com.tencent.mm.plugin.chatroom.ui;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewGroup;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
@Deprecated
public class RoomAnnouncementUI extends MMActivity {
    private String ktm;
    private WebView kuN;
    private boolean kuO;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kuO = getIntent().getBooleanExtra("need_bind_mobile", false);
        this.ktm = getIntent().getStringExtra("RoomInfo_Id");
        KC();
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        if (this.kuN != null) {
            this.kuN.setVisibility(8);
            ((ViewGroup) this.kuN.getParent()).removeView(this.kuN);
            this.kuN.removeAllViews();
            this.kuN.destroy();
            this.kuN = null;
            System.gc();
        }
        super.onDestroy();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    protected final void KC() {
        zi(R.l.eNz);
        this.kuN = a.i(this, R.h.cSk);
        this.kuN.getSettings().setJavaScriptEnabled(true);
        this.kuN.getSettings().setDomStorageEnabled(true);
        this.kuN.getSettings().setBuiltInZoomControls(true);
        this.kuN.getSettings().setUseWideViewPort(true);
        this.kuN.getSettings().setLoadWithOverviewMode(true);
        this.kuN.getSettings().setSavePassword(false);
        this.kuN.getSettings().setSaveFormData(false);
        this.kuN.getSettings().setGeolocationEnabled(false);
        this.kuN.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
        this.kuN.setWebChromeClient(new WebChromeClient(this) {
            final /* synthetic */ RoomAnnouncementUI kuP;

            {
                this.kuP = r1;
            }

            public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                g.a(this.kuP, str2, null, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass1 kuQ;

                    {
                        this.kuQ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.kuQ.kuP.kuN.requestFocus();
                    }
                });
                jsResult.cancel();
                return true;
            }
        });
        this.kuN.setWebViewClient(new WebViewClient(this) {
            final /* synthetic */ RoomAnnouncementUI kuP;

            {
                this.kuP = r1;
            }

            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (!str.equals("weixin://chatroom/upgradeagree")) {
                    return false;
                }
                a.a(this.kuP, this.kuP.ktm, this.kuP.kuO);
                return true;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RoomAnnouncementUI kuP;

            {
                this.kuP = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kuP.setResult(0);
                this.kuP.finish();
                return true;
            }
        });
        this.kuN.loadUrl(getString(R.l.dSZ, new Object[]{v.bIN()}));
    }

    public final int getLayoutId() {
        return R.i.cXj;
    }
}
