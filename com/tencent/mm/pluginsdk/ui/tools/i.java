package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.a.o;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public final class i {

    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ a sWA;

        AnonymousClass2(a aVar) {
            this.sWA = aVar;
        }

        public final void run() {
            this.sWA.aUE();
        }
    }

    static class AnonymousClass3 implements Runnable {
        final /* synthetic */ a sWA;

        AnonymousClass3(a aVar) {
            this.sWA = aVar;
        }

        public final void run() {
            this.sWA.aUE();
        }
    }

    static class AnonymousClass4 implements Runnable {
        final /* synthetic */ a sWA;

        AnonymousClass4(a aVar) {
            this.sWA = aVar;
        }

        public final void run() {
            this.sWA.aUE();
        }
    }

    static class AnonymousClass5 implements Runnable {
        final /* synthetic */ a sWA;
        final /* synthetic */ int sWB;

        AnonymousClass5(a aVar, int i) {
            this.sWA = aVar;
            this.sWB = i;
        }

        public final void run() {
            this.sWA.rD(this.sWB);
        }
    }

    public interface a {
        void aUE();

        void rD(int i);
    }

    public static void a(final a aVar) {
        ap.vL().D(new Runnable() {
            public final void run() {
                try {
                    a aVar = aVar;
                    w.i("MicroMsg.QQMailUnreadHelper", "dz[getUnreadCount]");
                    ap.yY();
                    String str = (String) c.vr().get(-1535680990, (Object) "");
                    ap.yY();
                    long longValue = new o(bg.f((Integer) c.vr().get(9, null))).longValue();
                    if (bg.mA(str) || longValue == 0) {
                        ap.yY();
                        c.vr().a(com.tencent.mm.storage.w.a.USERINFO_QQMAIL_UNREAD_COUNT_INT, Integer.valueOf(-1));
                        w.w("MicroMsg.QQMailUnreadHelper", "dz[getUnreadEmailCountAndSet: authkey or uin is null]");
                        af.v(new AnonymousClass2(aVar));
                        return;
                    }
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://qqmail.weixin.qq.com/cgi-bin/getunreadmailcount?f=xml&appname=qqmail_weixin&charset=utf-8&clientip=0").openConnection();
                    httpURLConnection.setConnectTimeout(15000);
                    httpURLConnection.setReadTimeout(20000);
                    httpURLConnection.setRequestProperty("Cookie", String.format("skey=%s;uin=o%d;", new Object[]{str, Long.valueOf(longValue)}));
                    if (httpURLConnection.getResponseCode() >= e.CTRL_INDEX) {
                        httpURLConnection.disconnect();
                        w.w("MicroMsg.QQMailUnreadHelper", "dz[getUnreadCount http 300]");
                        af.v(new AnonymousClass3(aVar));
                        return;
                    }
                    Map q = bh.q(bg.convertStreamToString(httpURLConnection.getInputStream()), "Response");
                    int i = (q == null || bg.getInt((String) q.get(".Response.error.code"), -1) != 0) ? -1 : bg.getInt((String) q.get(".Response.result.UnreadCount"), -1);
                    if (i < 0) {
                        af.v(new AnonymousClass4(aVar));
                        return;
                    }
                    ap.yY();
                    c.vr().a(com.tencent.mm.storage.w.a.USERINFO_QQMAIL_UNREAD_COUNT_INT, Integer.valueOf(i));
                    af.v(new AnonymousClass5(aVar, i));
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.QQMailUnreadHelper", e, "", new Object[0]);
                    w.e("MicroMsg.QQMailUnreadHelper", "getUnreadCountAsync exception");
                }
            }
        });
    }
}
