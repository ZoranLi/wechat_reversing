package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.http.SslCertificate;
import android.net.http.SslCertificate.DName;
import android.util.Base64;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.WebView;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20141210", reviewer = 20, vComment = {EType.HTTPSCHECK})
public final class b {
    Context context;
    public WebView saV;
    public Map<String, List<SslErrorHandler>> saW;
    public Map<String, Boolean> saX;
    private final SimpleDateFormat saY = new SimpleDateFormat("yyyy-MM-dd HH:mmZ", Locale.getDefault());

    public b(Context context, WebView webView) {
        this.context = context;
        this.saV = webView;
        this.saW = new HashMap();
        this.saX = new HashMap();
    }

    public final void a(final String str, SslErrorHandler sslErrorHandler, SslError sslError) {
        w.e("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError, currentUrl = %s", new Object[]{str});
        if (this.saV == null) {
            w.e("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError fail, has been detached");
        } else if (bg.mA(str)) {
            sslErrorHandler.cancel();
        } else {
            try {
                URL url = new URL(str);
                if (url.getHost().endsWith(".qq.com") || url.getHost().endsWith(".linkedin.com")) {
                    Boolean bool = (Boolean) this.saX.get(str);
                    if (bool != null) {
                        w.v("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError, already selected = %b", new Object[]{bool});
                        if (bool.booleanValue()) {
                            sslErrorHandler.proceed();
                            return;
                        } else {
                            sslErrorHandler.cancel();
                            return;
                        }
                    }
                    List list = (List) this.saW.get(str);
                    if (list == null || list.size() == 0) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("1");
                        stringBuilder.append(",");
                        stringBuilder.append(a(str, sslError));
                        w.i("MicroMsg.WebView.MMSslErrorHandler", "reportWebViewSslError, value = %s", new Object[]{stringBuilder.toString()});
                        g.oUh.A(11098, r0);
                        list = new ArrayList();
                        list.add(sslErrorHandler);
                        this.saW.put(str, list);
                        com.tencent.mm.ui.base.g.a(this.context, false, this.context.getString(R.l.fnk, new Object[]{url.getHost()}), this.context.getString(R.l.fnl), this.context.getString(R.l.dGw), this.context.getString(R.l.dDn), new OnClickListener(this) {
                            final /* synthetic */ b sba;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                List<SslErrorHandler> list = (List) this.sba.saW.get(str);
                                if (list == null) {
                                    w.e("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, continue selected, list should not be null");
                                    return;
                                }
                                this.sba.saX.put(str, Boolean.valueOf(true));
                                w.i("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, continue selected, list size = %d", new Object[]{Integer.valueOf(list.size())});
                                for (SslErrorHandler proceed : list) {
                                    proceed.proceed();
                                }
                                list.clear();
                            }
                        }, new OnClickListener(this) {
                            final /* synthetic */ b sba;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                List<SslErrorHandler> list = (List) this.sba.saW.get(str);
                                if (list == null) {
                                    w.e("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, cancel selected, list should not be null");
                                    return;
                                }
                                this.sba.saX.put(str, Boolean.valueOf(false));
                                w.i("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, cancel selected, list size = %d", new Object[]{Integer.valueOf(list.size())});
                                for (SslErrorHandler cancel : list) {
                                    cancel.cancel();
                                }
                                list.clear();
                                this.sba.saV.clearSslPreferences();
                            }
                        });
                        return;
                    }
                    list.add(sslErrorHandler);
                    return;
                }
                w.d("MicroMsg.WebView.MMSslErrorHandler", "host = " + url.getHost() + ", but it not end with '.qq.com' or '.linkedin.com'");
                sslErrorHandler.cancel();
            } catch (Exception e) {
                w.e("MicroMsg.WebView.MMSslErrorHandler", "create url fail : " + e.getLocalizedMessage());
            }
        }
    }

    @TargetApi(14)
    private String a(String str, SslError sslError) {
        try {
            Object obj;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<sslerror>");
            stringBuilder.append("<primaryerror>");
            if (sslError == null) {
                obj = "-1";
            } else {
                obj = Integer.valueOf(sslError.getPrimaryError());
            }
            stringBuilder.append(obj);
            stringBuilder.append("</primaryerror>");
            stringBuilder.append("<clienttime>");
            stringBuilder.append(Base64.encodeToString(this.saY.format(new Date()).getBytes(), 0));
            stringBuilder.append("</clienttime>");
            stringBuilder.append("<currenturl>");
            if (!bg.mA(str)) {
                stringBuilder.append(bg.PW(str));
            }
            stringBuilder.append("</currenturl>");
            SslCertificate certificate = sslError == null ? null : sslError.getCertificate();
            if (certificate != null) {
                DName issuedBy = certificate.getIssuedBy();
                if (issuedBy != null) {
                    stringBuilder.append("<issuedby>");
                    if (issuedBy.getDName() != null) {
                        stringBuilder.append(Base64.encodeToString(issuedBy.getDName().getBytes(), 0));
                    }
                    stringBuilder.append("</issuedby>");
                }
                issuedBy = certificate.getIssuedTo();
                if (issuedBy != null) {
                    stringBuilder.append("<issuedto>");
                    if (issuedBy.getDName() != null) {
                        stringBuilder.append(Base64.encodeToString(issuedBy.getDName().getBytes(), 0));
                    }
                    stringBuilder.append("</issuedto>");
                }
                String validNotAfter = certificate.getValidNotAfter();
                if (validNotAfter != null) {
                    stringBuilder.append("<getvalidnotafter>");
                    stringBuilder.append(Base64.encodeToString(validNotAfter.getBytes(), 0));
                    stringBuilder.append("</getvalidnotafter>");
                }
                String validNotBefore = certificate.getValidNotBefore();
                if (validNotBefore != null) {
                    stringBuilder.append("<getvalidnotbefore>");
                    stringBuilder.append(Base64.encodeToString(validNotBefore.getBytes(), 0));
                    stringBuilder.append("</getvalidnotbefore>");
                }
            }
            stringBuilder.append("</sslerror>");
            return stringBuilder.toString();
        } catch (Exception e) {
            w.w("MicroMsg.WebView.MMSslErrorHandler", "buildXml ex = %s", new Object[]{e.getMessage()});
            return "";
        }
    }
}
