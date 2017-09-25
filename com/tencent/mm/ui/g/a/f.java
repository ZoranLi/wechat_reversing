package com.tencent.mm.ui.g.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.plugin.comm.a.c;
import com.tencent.mm.plugin.comm.a.g;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
public final class f extends i {
    static final float[] wgl = new float[]{20.0f, 60.0f};
    static final float[] wgm = new float[]{40.0f, 60.0f};
    static final LayoutParams wgn = new LayoutParams(-1, -1);
    private String mUrl;
    private MMWebView qjb;
    private com.tencent.mm.ui.g.a.c.a wgo;
    private ProgressDialog wgp;
    private ImageView wgq;
    private FrameLayout wgr;

    private class a extends WebViewClient {
        final /* synthetic */ f wgs;
        public boolean wgt = true;

        public a(f fVar) {
            this.wgs = fVar;
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            w.d("Facebook-WebView", "Redirect URL: " + str);
            if (str.startsWith("fbconnect://success")) {
                Bundle Ua = e.Ua(str);
                String string = Ua.getString("error");
                if (string == null) {
                    string = Ua.getString("error_type");
                }
                if (string == null) {
                    this.wgs.wgo.m(Ua);
                } else if (string.equals("access_denied") || string.equals("OAuthAccessDeniedException")) {
                    this.wgs.wgo.onCancel();
                } else {
                    this.wgs.wgo.a(new d(string));
                }
                this.wgs.dismiss();
                return true;
            } else if (str.startsWith("fbconnect://cancel")) {
                this.wgs.wgo.onCancel();
                try {
                    this.wgs.dismiss();
                    return true;
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.FbDialog", e, "", new Object[0]);
                    return true;
                }
            } else if (str.contains("touch")) {
                return false;
            } else {
                this.wgs.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            }
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            this.wgt = false;
            this.wgs.wgo.a(new b(str, i, str2));
            try {
                this.wgs.dismiss();
                this.wgs.wgp.dismiss();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.FbDialog", e, "", new Object[0]);
            }
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            w.d("Facebook-WebView", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
            try {
                this.wgs.wgp.show();
                this.wgs.wgp.setOnDismissListener(new OnDismissListener(this) {
                    final /* synthetic */ a wgu;

                    {
                        this.wgu = r1;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        if (this.wgu.wgt && this.wgu.wgs != null) {
                            this.wgu.wgs.wgo.onCancel();
                            this.wgu.wgs.dismiss();
                        }
                    }
                });
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.FbDialog", e, "", new Object[0]);
            }
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            this.wgt = false;
            try {
                this.wgs.wgp.dismiss();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.FbDialog", e, "", new Object[0]);
            }
            this.wgs.wgr.setBackgroundColor(0);
            this.wgs.qjb.setVisibility(0);
            this.wgs.wgq.setVisibility(0);
        }
    }

    public f(Context context, String str, com.tencent.mm.ui.g.a.c.a aVar) {
        super(context, 16973840);
        this.mUrl = str;
        this.wgo = aVar;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.wgp = new ProgressDialog(getContext());
        this.wgp.requestWindowFeature(1);
        this.wgp.setMessage(getContext().getString(g.kEh));
        requestWindowFeature(1);
        this.wgr = new FrameLayout(getContext());
        this.wgq = new ImageView(getContext());
        this.wgq.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ f wgs;

            {
                this.wgs = r1;
            }

            public final void onClick(View view) {
                this.wgs.wgo.onCancel();
                this.wgs.dismiss();
            }
        });
        this.wgq.setImageDrawable(getContext().getResources().getDrawable(c.kDB));
        this.wgq.setVisibility(4);
        int intrinsicWidth = this.wgq.getDrawable().getIntrinsicWidth() / 2;
        View linearLayout = new LinearLayout(getContext());
        this.qjb = com.tencent.mm.ui.widget.MMWebView.a.fi(getContext());
        this.qjb.setVerticalScrollBarEnabled(false);
        this.qjb.setHorizontalScrollBarEnabled(false);
        this.qjb.setWebViewClient(new a(this));
        this.qjb.getSettings().setJavaScriptEnabled(true);
        this.qjb.loadUrl(this.mUrl);
        this.qjb.setLayoutParams(wgn);
        this.qjb.setVisibility(4);
        linearLayout.setPadding(intrinsicWidth, intrinsicWidth, intrinsicWidth, intrinsicWidth);
        linearLayout.addView(this.qjb);
        this.wgr.addView(linearLayout);
        this.wgr.addView(this.wgq, new ViewGroup.LayoutParams(-2, -2));
        addContentView(this.wgr, new ViewGroup.LayoutParams(-1, -1));
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        this.wgo.onCancel();
        dismiss();
        return true;
    }
}
