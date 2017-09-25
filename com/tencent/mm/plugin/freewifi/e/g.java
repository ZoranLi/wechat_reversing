package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.b;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.protocal.c.dy;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.net.HttpURLConnection;
import java.net.URL;

public final class g extends e implements a {
    private a lUk;
    private int lUl = 5;

    class AnonymousClass4 implements Runnable {
        final /* synthetic */ g lUm;
        final /* synthetic */ String lUn;
        final /* synthetic */ dy lUo;

        AnonymousClass4(g gVar, String str, dy dyVar) {
            this.lUm = gVar;
            this.lUn = str;
            this.lUo = dyVar;
        }

        public final void run() {
            String wK = g.wK(this.lUn);
            w.i("MicroMsg.FreeWifi.ProtocolOne", "get redirect location from loginurl : %s, %s", new Object[]{wK, this.lUn});
            if (!bg.mA(wK)) {
                String cf = g.cf(wK, "res=");
                w.i("MicroMsg.FreeWifi.ProtocolOne", "get connect result from location : %s, %s", new Object[]{cf, wK});
                if (!bg.mA(cf) && (cf.startsWith("success") || cf.startsWith("already"))) {
                    FreeWifiFrontPageUI freeWifiFrontPageUI = this.lUm.lUd;
                    d dVar = d.SUCCESS;
                    b bVar = new b();
                    bVar.lWF = this.lUo;
                    freeWifiFrontPageUI.a(dVar, bVar);
                    return;
                }
            }
            this.lUm.axa();
        }
    }

    public g(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
    }

    public final void connect() {
        j.awF().awp().post(new Runnable(this) {
            final /* synthetic */ g lUm;

            {
                this.lUm = r1;
            }

            public final void run() {
                this.lUm.awZ();
            }
        });
    }

    public final void awZ() {
        this.lUk = new a(this.ssid, this.lUd);
        this.lUk.a(new a.a(this) {
            final /* synthetic */ g lUm;

            {
                this.lUm = r1;
            }

            public final void onSuccess() {
                w.i("MicroMsg.FreeWifi.ProtocolOne", "sessionKey=%s, step=%d, desc=Network. ", new Object[]{m.y(this.lUm.intent), Integer.valueOf(m.z(this.lUm.intent))});
                this.lUm.axb();
            }

            public final void mF(int i) {
                this.lUm.axa();
            }
        });
    }

    public final void axa() {
        this.lUd.a(d.FAIL, FreeWifiFrontPageUI.a.lWE);
    }

    public final void axb() {
        String wK;
        int i = this.lUl;
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                w.i("MicroMsg.FreeWifi.ProtocolOne", "now retry count = %d", new Object[]{Integer.valueOf(i2)});
                String sH = com.tencent.mm.i.g.sW().sH();
                w.i("MicroMsg.FreeWifi.ProtocolOne", "get check url from cinfig : %s", new Object[]{sH});
                if (bg.mA(sH)) {
                    w.i("MicroMsg.FreeWifi.ProtocolOne", "get check url from config failed, use the default url : %s", new Object[]{"http://10.1.0.6/redirect"});
                    sH = "http://10.1.0.6/redirect";
                }
                wK = wK(sH);
                w.i("MicroMsg.FreeWifi.ProtocolOne", "get location from url : %s, %s", new Object[]{sH, wK});
                if (!bg.mA(wK)) {
                    break;
                }
                w.e("MicroMsg.FreeWifi.ProtocolOne", "get location from url failed : %s, %s", new Object[]{sH, wK});
                try {
                    Thread.sleep(500);
                    i = i2;
                } catch (Exception e) {
                    i = i2;
                }
            } else {
                axa();
                return;
            }
        }
        String cf = cf(wK, "auth=");
        w.i("MicroMsg.FreeWifi.ProtocolOne", "get apauthmessage from location : %s, %s", new Object[]{cf, wK});
        if (bg.mA(cf)) {
            w.e("MicroMsg.FreeWifi.ProtocolOne", "get apauth message from location failed : %s", new Object[]{wK});
            axa();
            return;
        }
        w.i("MicroMsg.FreeWifi.ProtocolOne", "get ap auth data : %s, url : %s, mac : %s", new Object[]{cf, this.lUe, com.tencent.mm.plugin.freewifi.model.d.awr()});
        if (bg.mA(cf)) {
            axa();
        } else {
            new com.tencent.mm.plugin.freewifi.d.a(this.lUe, this.ssid, r3, "", cf, "", this.fuV, m.y(this.intent)).b(new e(this) {
                final /* synthetic */ g lUm;

                {
                    this.lUm = r1;
                }

                public final void a(int i, int i2, String str, k kVar) {
                    w.i("MicroMsg.FreeWifi.ProtocolOne", "errType : %d, errCode : %d, errMsg : %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    if (i == 0 && i2 == 0) {
                        com.tencent.mm.plugin.freewifi.d.a aVar = (com.tencent.mm.plugin.freewifi.d.a) kVar;
                        w.i("MicroMsg.FreeWifi.ProtocolOne", "authUrl : %s", new Object[]{aVar.awK()});
                        dy awQ = aVar.awQ();
                        if (awQ != null) {
                            w.i("MicroMsg.FreeWifi.ProtocolOne", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[]{awQ.teQ, awQ.jOp, awQ.jNj, Integer.valueOf(awQ.thK), awQ.thL, awQ.hAG});
                            j.awF().awp().post(new AnonymousClass4(this.lUm, r0, awQ));
                            return;
                        }
                        this.lUm.axa();
                        return;
                    }
                    this.lUm.axa();
                }
            });
        }
    }

    public static String cf(String str, String str2) {
        if (bg.mA(str)) {
            w.e("MicroMsg.FreeWifi.ProtocolOne", "null or nil header");
            return null;
        }
        String[] split;
        String[] split2 = str.split("\\?");
        if (str2.length() > 0) {
            split = split2[1].split("&");
        } else {
            split = split2;
        }
        if (split == null || split.length <= 0) {
            return null;
        }
        for (String str3 : split) {
            if (str3.startsWith(str2)) {
                return str3.substring(str2.length());
            }
        }
        return null;
    }

    public static String wK(String str) {
        HttpURLConnection httpURLConnection;
        Exception exception;
        Throwable th;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection2 != null) {
                try {
                    httpURLConnection2.setConnectTimeout(30000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    int responseCode = httpURLConnection2.getResponseCode();
                    w.i("MicroMsg.FreeWifi.ProtocolOne", "code : %d, location : %s", new Object[]{Integer.valueOf(responseCode), httpURLConnection2.getHeaderField("Location")});
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return r1;
                } catch (Exception e) {
                    Exception exception2 = e;
                    httpURLConnection = httpURLConnection2;
                    exception = exception2;
                    try {
                        w.e("MicroMsg.FreeWifi.ProtocolOne", "get recirect location failed : %s", new Object[]{exception.getMessage()});
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return null;
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
            return null;
        } catch (Exception e2) {
            exception = e2;
            httpURLConnection = null;
            w.e("MicroMsg.FreeWifi.ProtocolOne", "get recirect location failed : %s", new Object[]{exception.getMessage()});
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return null;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }
}
