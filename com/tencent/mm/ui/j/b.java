package com.tencent.mm.ui.j;

import android.annotation.SuppressLint;
import android.app.Dialog;
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
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

@SuppressLint({"SetJavaScriptEnabled"})
@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
public final class b extends Dialog {
    static final float[] wgl = new float[]{20.0f, 60.0f};
    static final float[] wgm = new float[]{40.0f, 60.0f};
    static final LayoutParams wgn = new LayoutParams(-1, -1);
    private String mUrl;
    private MMWebView qjb;
    private ProgressDialog wgp;
    private ImageView wgq;
    private FrameLayout wgr;
    private a wrG;

    public interface a {
        void can();

        void m(Bundle bundle);

        void onCancel();
    }

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
    private class b extends WebViewClient {
        public boolean wgt = true;
        final /* synthetic */ b wrH;

        public b(b bVar) {
            this.wrH = bVar;
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            w.d("Twitter-WebView", "Redirect URL: " + str);
            if (str.startsWith("wechatapp://sign-in-twitter.wechatapp.com/")) {
                Bundle Ua = Ua(str);
                if (Ua.getString("denied") == null) {
                    this.wrH.wrG.m(Ua);
                } else {
                    this.wrH.wrG.onCancel();
                }
                this.wrH.dismiss();
            } else {
                this.wrH.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            }
            return true;
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            this.wgt = false;
            a a = this.wrH.wrG;
            com.tencent.mm.ui.g.a.b bVar = new com.tencent.mm.ui.g.a.b(str, i, str2);
            a.can();
            try {
                this.wrH.dismiss();
                this.wrH.wgp.dismiss();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.TwitterDialog", e, "", new Object[0]);
            }
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            w.d("Twitter-WebView", "Webview loading URL: " + str);
            super.onPageStarted(webView, str, bitmap);
            try {
                this.wrH.wgp.show();
                this.wrH.wgp.setOnDismissListener(new OnDismissListener(this) {
                    final /* synthetic */ b wrI;

                    {
                        this.wrI = r1;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        if (this.wrI.wgt && this.wrI.wrH != null) {
                            this.wrI.wrH.wrG.onCancel();
                            this.wrI.wrH.dismiss();
                        }
                    }
                });
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.TwitterDialog", e, "", new Object[0]);
            }
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            this.wgt = false;
            try {
                this.wrH.wgp.dismiss();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.TwitterDialog", e, "", new Object[0]);
            }
            this.wrH.wgr.setBackgroundColor(0);
            this.wrH.qjb.setVisibility(0);
            this.wrH.wgq.setVisibility(0);
        }

        private static Bundle TZ(String str) {
            Bundle bundle = new Bundle();
            if (str != null) {
                for (String split : str.split("&")) {
                    String[] split2 = split.split("=");
                    bundle.putString(URLDecoder.decode(split2[0]), URLDecoder.decode(split2[1]));
                }
            }
            return bundle;
        }

        private static Bundle Ua(String str) {
            try {
                URL url = new URL(str.replace("wechatapp", "http"));
                Bundle TZ = TZ(url.getQuery());
                TZ.putAll(TZ(url.getRef()));
                return TZ;
            } catch (MalformedURLException e) {
                return new Bundle();
            }
        }
    }

    public b(Context context, String str, a aVar) {
        super(context, 16973840);
        this.mUrl = str;
        this.wrG = aVar;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.wgp = new ProgressDialog(getContext());
        this.wgp.requestWindowFeature(1);
        this.wgp.setMessage(getContext().getString(g.eYA));
        requestWindowFeature(1);
        this.wgr = new FrameLayout(getContext());
        this.wgq = new ImageView(getContext());
        this.wgq.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b wrH;

            {
                this.wrH = r1;
            }

            public final void onClick(View view) {
                this.wrH.wrG.onCancel();
                this.wrH.dismiss();
            }
        });
        this.wgq.setImageDrawable(getContext().getResources().getDrawable(c.kDB));
        this.wgq.setVisibility(4);
        int intrinsicWidth = this.wgq.getDrawable().getIntrinsicWidth() / 2;
        View linearLayout = new LinearLayout(getContext());
        this.qjb = com.tencent.mm.ui.widget.MMWebView.a.fi(getContext());
        this.qjb.setVerticalScrollBarEnabled(false);
        this.qjb.setHorizontalScrollBarEnabled(false);
        this.qjb.setWebViewClient(new b(this));
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
        this.wrG.onCancel();
        dismiss();
        return true;
    }
}
