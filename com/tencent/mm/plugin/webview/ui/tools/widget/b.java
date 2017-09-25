package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

public class b extends WebChromeClient {
    public Activity fPi;
    private int mne = 0;

    public b(MMWebViewWithJsApi mMWebViewWithJsApi) {
        this.fPi = (Activity) mMWebViewWithJsApi.getContext();
    }

    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
    }

    public void onGeolocationPermissionsShowPrompt(final String str, final GeolocationPermissionsCallback geolocationPermissionsCallback) {
        g.a(this.fPi, false, this.fPi.getString(R.l.fnE, new Object[]{str}), this.fPi.getString(R.l.fnF), this.fPi.getString(R.l.dHT), this.fPi.getString(R.l.dGs), new OnClickListener(this) {
            final /* synthetic */ b sng;

            public final void onClick(DialogInterface dialogInterface, int i) {
                geolocationPermissionsCallback.invoke(str, true, true);
            }
        }, new OnClickListener(this) {
            final /* synthetic */ b sng;

            public final void onClick(DialogInterface dialogInterface, int i) {
                geolocationPermissionsCallback.invoke(str, false, false);
            }
        });
    }

    public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
        h a;
        this.mne++;
        if (this.mne > 2) {
            a = g.a(this.fPi, str2, "", this.fPi.getString(R.l.fnz), this.fPi.getString(R.l.dHT), new OnClickListener(this) {
                final /* synthetic */ b sng;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.cancel();
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    this.sng.fPi.finish();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ b sng;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            }, R.e.aUA);
        } else {
            a = g.a(this.fPi, str2, "", this.fPi.getString(R.l.dHT), new OnClickListener(this) {
                final /* synthetic */ b sng;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            });
        }
        if (a == null) {
            return super.onJsAlert(webView, str, str2, jsResult);
        }
        a.setCanceledOnTouchOutside(false);
        a.kI(false);
        return true;
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, final JsResult jsResult) {
        h a;
        this.mne++;
        if (this.mne > 2) {
            a = g.a(this.fPi, str2, "", this.fPi.getString(R.l.fnz), this.fPi.getString(R.l.dHT), new OnClickListener(this) {
                final /* synthetic */ b sng;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.cancel();
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    this.sng.fPi.finish();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ b sng;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            }, R.e.aTa);
        } else {
            a = g.a(this.fPi, false, str2, "", this.fPi.getString(R.l.dHT), this.fPi.getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ b sng;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ b sng;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.cancel();
                }
            });
        }
        if (a == null) {
            return super.onJsConfirm(webView, str, str2, jsResult);
        }
        a.setCancelable(false);
        a.setCanceledOnTouchOutside(false);
        return true;
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }
}
