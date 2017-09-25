package com.tencent.mm.plugin.freewifi.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.bf;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public final class a extends b {
    public static Date lVH = null;
    private boolean hasInit = false;
    private Runnable lVI = new Runnable(this) {
        final /* synthetic */ a lVJ;

        {
            this.lVJ = r1;
        }

        public final void run() {
            final View findViewById = this.lVJ.view.findViewById(R.h.bRS);
            if (am.getNetType(ab.getContext()) != 0) {
                findViewById.setVisibility(8);
            } else {
                ap.vL().D(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 lVL;

                    public final void run() {
                        final com.tencent.mm.sdk.b.b bfVar = new bf();
                        long currentTimeMillis = System.currentTimeMillis();
                        com.tencent.mm.sdk.b.a.urY.m(bfVar);
                        w.i("MicroMsg.FreeWifi.FreeWifiBanner", "summeranrt CheckWechatFreeWifiEvent take[%d]ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 lVN;

                            public final void run() {
                                if (bg.mA(bfVar.fEK.fEP)) {
                                    findViewById.setVisibility(8);
                                    return;
                                }
                                ((TextView) this.lVN.lVL.lVJ.view.findViewById(R.h.bRi)).setText(bfVar.fEK.fEP);
                                final String str = bfVar.fEK.fEM;
                                Object obj = "0".equalsIgnoreCase(bfVar.fEK.fEL) ? "0" : "1";
                                final String str2 = bfVar.fEK.fEN;
                                final String str3 = bfVar.fEK.ssid;
                                final String str4 = bfVar.fEK.bssid;
                                final String str5 = bfVar.fEK.fEO;
                                w.i("MicroMsg.FreeWifi.FreeWifiBanner", "desc=it tries to show bar. pingEnabled = %s,  pingUrl= %s", new Object[]{obj, str});
                                if ("1".equals(obj)) {
                                    ap.vL().D(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass1 lVQ;

                                        public final void run() {
                                            Exception exception;
                                            Writer stringWriter;
                                            String stringWriter2;
                                            g gVar;
                                            Object[] objArr;
                                            Throwable th;
                                            w.i("MicroMsg.FreeWifi.FreeWifiBanner", "desc=it tries to ping. pingUrl= %s", new Object[]{str});
                                            HttpURLConnection httpURLConnection = null;
                                            try {
                                                URL url = new URL(str);
                                                long currentTimeMillis = System.currentTimeMillis();
                                                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                                                if (httpURLConnection2 != null) {
                                                    try {
                                                        httpURLConnection2.setConnectTimeout(Downloads.MIN_RETYR_AFTER);
                                                        httpURLConnection2.setReadTimeout(Downloads.MIN_RETYR_AFTER);
                                                        httpURLConnection2.setInstanceFollowRedirects(false);
                                                        httpURLConnection2.setUseCaches(false);
                                                        httpURLConnection2.setRequestProperty("Pragma", "no-cache");
                                                        httpURLConnection2.setRequestProperty("Cache-Control", "no-cache");
                                                        int responseCode = httpURLConnection2.getResponseCode();
                                                        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                                                        g.oUh.i(12907, new Object[]{str3, str4, str5, str2, "", Long.valueOf(currentTimeMillis), Integer.valueOf(responseCode), "", "", ""});
                                                        w.i("MicroMsg.FreeWifi.FreeWifiBanner", "desc=ping ended. http response code = %d, cost=%d ms", new Object[]{Integer.valueOf(responseCode), Long.valueOf(currentTimeMillis)});
                                                        if (m.CTRL_INDEX == responseCode) {
                                                            af.v(new Runnable(this) {
                                                                final /* synthetic */ AnonymousClass1 lVR;

                                                                {
                                                                    this.lVR = r1;
                                                                }

                                                                public final void run() {
                                                                    findViewById.setVisibility(0);
                                                                }
                                                            });
                                                        } else if (302 == responseCode) {
                                                            w.i("MicroMsg.FreeWifi.FreeWifiBanner", "desc=http response 302 location = %s", new Object[]{httpURLConnection2.getHeaderField("Location")});
                                                        }
                                                    } catch (Exception e) {
                                                        Exception exception2 = e;
                                                        httpURLConnection = httpURLConnection2;
                                                        exception = exception2;
                                                        try {
                                                            stringWriter = new StringWriter();
                                                            exception.printStackTrace(new PrintWriter(stringWriter));
                                                            stringWriter2 = stringWriter.toString();
                                                            w.i("MicroMsg.FreeWifi.FreeWifiBanner", "ping encounter exception. " + stringWriter2);
                                                            if (stringWriter2 == null) {
                                                                stringWriter2 = "";
                                                            }
                                                            gVar = g.oUh;
                                                            objArr = new Object[10];
                                                            objArr[0] = str3;
                                                            objArr[1] = str4;
                                                            objArr[2] = str5;
                                                            objArr[3] = str2;
                                                            objArr[4] = "";
                                                            objArr[5] = Integer.valueOf(0);
                                                            objArr[6] = Integer.valueOf(0);
                                                            objArr[7] = "";
                                                            objArr[8] = "";
                                                            if (stringWriter2.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                                                                stringWriter2 = stringWriter2.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                                                            }
                                                            objArr[9] = stringWriter2;
                                                            gVar.i(12907, objArr);
                                                            if (httpURLConnection != null) {
                                                                httpURLConnection.disconnect();
                                                            }
                                                        } catch (Throwable th2) {
                                                            th = th2;
                                                            if (httpURLConnection != null) {
                                                                httpURLConnection.disconnect();
                                                            }
                                                            throw th;
                                                        }
                                                    } catch (Throwable th3) {
                                                        Throwable th4 = th3;
                                                        httpURLConnection = httpURLConnection2;
                                                        th = th4;
                                                        if (httpURLConnection != null) {
                                                            httpURLConnection.disconnect();
                                                        }
                                                        throw th;
                                                    }
                                                }
                                                if (httpURLConnection2 != null) {
                                                    httpURLConnection2.disconnect();
                                                }
                                            } catch (Exception e2) {
                                                exception = e2;
                                                stringWriter = new StringWriter();
                                                exception.printStackTrace(new PrintWriter(stringWriter));
                                                stringWriter2 = stringWriter.toString();
                                                w.i("MicroMsg.FreeWifi.FreeWifiBanner", "ping encounter exception. " + stringWriter2);
                                                if (stringWriter2 == null) {
                                                    stringWriter2 = "";
                                                }
                                                gVar = g.oUh;
                                                objArr = new Object[10];
                                                objArr[0] = str3;
                                                objArr[1] = str4;
                                                objArr[2] = str5;
                                                objArr[3] = str2;
                                                objArr[4] = "";
                                                objArr[5] = Integer.valueOf(0);
                                                objArr[6] = Integer.valueOf(0);
                                                objArr[7] = "";
                                                objArr[8] = "";
                                                if (stringWriter2.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                                                    stringWriter2 = stringWriter2.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                                                }
                                                objArr[9] = stringWriter2;
                                                gVar.i(12907, objArr);
                                                if (httpURLConnection != null) {
                                                    httpURLConnection.disconnect();
                                                }
                                            }
                                        }
                                    });
                                } else {
                                    findViewById.setVisibility(0);
                                }
                            }
                        });
                    }
                });
            }
        }
    };

    public a(Context context) {
        super(context);
        initialize();
    }

    public final int getLayoutId() {
        return R.i.ddB;
    }

    private void initialize() {
        if (this.view != null) {
            View findViewById = this.view.findViewById(R.h.bRS);
            if (!this.hasInit) {
                this.hasInit = true;
                findViewById.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ a lVJ;

                    {
                        this.lVJ = r1;
                    }

                    public final void onClick(View view) {
                        Date date = new Date();
                        if (a.lVH == null || date.getTime() - a.lVH.getTime() >= 1000) {
                            a.lVH = date;
                            Intent intent = new Intent();
                            intent.putExtra("free_wifi_source", 2);
                            intent.addFlags(67108864);
                            d.b((Context) this.lVJ.sNB.get(), "freewifi", ".ui.FreeWifiEntryUI", intent);
                        }
                    }
                });
                findViewById.setVisibility(8);
            }
        }
    }

    public final void destroy() {
    }

    public final boolean Xj() {
        if (this.hasInit) {
            af.I(this.lVI);
            af.f(this.lVI, 500);
            return true;
        }
        initialize();
        return false;
    }
}
