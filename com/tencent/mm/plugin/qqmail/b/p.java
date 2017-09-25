package com.tencent.mm.plugin.qqmail.b;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public final class p {
    private static SparseArray<String> oAk = null;
    public j oAf;
    public c oAg;
    public e oAh;
    public Map<Long, d> oAi = new HashMap();
    public Map<Long, b> oAj = new HashMap();
    Map<String, String> ozF = new HashMap();

    public static abstract class a {
        public abstract void onError(int i, String str);

        public abstract void onSuccess(String str, Map<String, String> map);

        public boolean onReady() {
            return true;
        }

        public void onProgress(int i) {
        }

        public void onComplete() {
        }
    }

    public static class c {
        public boolean oAq = false;
        public boolean oAr = true;
        public boolean oAs = true;

        public final void toBundle(Bundle bundle) {
            bundle.putBoolean("qqmail_httpoptions_expired", this.oAq);
            bundle.putBoolean("qqmail_httpoptions_needcache", this.oAr);
            bundle.putBoolean("qqmail_httpoptions_needparse", this.oAs);
        }

        public final void fromBundle(Bundle bundle) {
            this.oAq = bundle.getBoolean("qqmail_httpoptions_expired");
            this.oAr = bundle.getBoolean("qqmail_httpoptions_needcache");
            this.oAs = bundle.getBoolean("qqmail_httpoptions_needparse");
        }
    }

    private class d {
        long id = System.currentTimeMillis();
        final /* synthetic */ p oAm;
        c oAt;
        com.tencent.mm.plugin.qqmail.b.h.b oAu;
        com.tencent.mm.plugin.qqmail.b.h.c oAv;
        Map<String, String> oAw;
        a oAx;
        String uri;

        public d(p pVar, String str, com.tencent.mm.plugin.qqmail.b.h.b bVar, a aVar) {
            this.oAm = pVar;
            this.uri = str;
            this.oAu = bVar;
            this.oAx = aVar;
        }
    }

    private class b extends AsyncTask<d, Integer, d> implements com.tencent.mm.plugin.qqmail.b.h.a {
        final /* synthetic */ p oAm;
        private h oAn;
        d oAo;

        private b(p pVar) {
            this.oAm = pVar;
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            d dVar = ((d[]) objArr)[0];
            if (!bg.mA((String) dVar.oAu.ozF.get("skey"))) {
                if (!dVar.oAt.oAq && dVar.oAt.oAr) {
                    byte[] i = this.oAm.oAh.i(dVar.uri, dVar.oAu.ozE);
                    String str = i == null ? null : new String(i);
                    if (str != null) {
                        dVar.oAv = new com.tencent.mm.plugin.qqmail.b.h.c(304, null, str);
                        if (dVar.oAt.oAs || !(dVar.oAv.status == 304 || dVar.oAv.status == m.CTRL_INDEX)) {
                            w.e("MicroMsg.NormalMailAppService", "http error, %d", new Object[]{Integer.valueOf(dVar.oAv.status)});
                        } else {
                            dVar.oAw = bh.q(dVar.oAv.content, "Response");
                        }
                    }
                }
                if (dVar.oAu.ozG != null) {
                    this.oAn = new f();
                } else {
                    this.oAn = new g();
                }
                dVar.oAv = this.oAn.a("https://", dVar.uri, dVar.oAu, this);
                if (dVar.oAv == null) {
                    return null;
                }
                if (dVar.oAt.oAs) {
                }
                w.e("MicroMsg.NormalMailAppService", "http error, %d", new Object[]{Integer.valueOf(dVar.oAv.status)});
            }
            return dVar;
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            d dVar = (d) obj;
            if (dVar != null) {
                if (bg.mA((String) dVar.oAu.ozF.get("skey"))) {
                    dVar.oAx.onError(-5, "");
                } else if (dVar.oAv.status == 304) {
                    p.a(dVar);
                } else if (dVar.oAv.status == m.CTRL_INDEX) {
                    p pVar = this.oAm;
                    Map map = dVar.oAv.ozF;
                    if (!(pVar.ozF == null || map == null)) {
                        for (String str : map.keySet()) {
                            pVar.ozF.put(str, map.get(str));
                        }
                    }
                    if (p.a(dVar) == 0 && dVar.oAt.oAr) {
                        this.oAm.oAh.a(dVar.uri, dVar.oAu.ozE, dVar.oAv.content.getBytes());
                    }
                } else {
                    dVar.oAx.onError(dVar.oAv.status, p.rB(dVar.oAv.status));
                }
                dVar.oAx.onComplete();
                this.oAm.oAi.remove(Long.valueOf(dVar.id));
                this.oAm.oAj.remove(Long.valueOf(dVar.id));
            }
        }

        protected final /* synthetic */ void onProgressUpdate(Object[] objArr) {
            this.oAo.oAx.onProgress(((Integer[]) objArr)[0].intValue());
        }

        public final boolean b(d dVar) {
            if (!dVar.oAx.onReady()) {
                return false;
            }
            this.oAo = dVar;
            super.execute(new d[]{dVar});
            return true;
        }

        public final void aUn() {
            publishProgress(new Integer[]{Integer.valueOf(0)});
        }

        protected final void onCancelled() {
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ b oAp;

                {
                    this.oAp = r1;
                }

                public final void run() {
                    if (this.oAp.oAn != null) {
                        this.oAp.oAn.cancel();
                    }
                }

                public final String toString() {
                    return super.toString() + "|onCancelled";
                }
            });
            super.onCancelled();
        }
    }

    public p(int i, String str) {
        h.setHost("qqmail.weixin.qq.com:443");
        h.setUserAgent("weixin/" + str + "/0x" + Integer.toHexString(i));
        reset();
    }

    public final long a(String str, Map<String, String> map, c cVar, a aVar) {
        return a(str, 1, map, null, cVar, aVar);
    }

    public final long b(String str, Map<String, String> map, c cVar, a aVar) {
        return a(str, 0, map, null, cVar, aVar);
    }

    public static String aUt() {
        return "https://qqmail.weixin.qq.com:443";
    }

    public final long a(String str, int i, Map<String, String> map, com.tencent.mm.plugin.qqmail.b.h.d dVar, c cVar, a aVar) {
        if (map == null) {
            map = new HashMap();
        }
        map.put("appname", "qqmail_weixin");
        map.put("f", "xml");
        map.put("charset", ProtocolPackage.ServerEncoding);
        map.put("clientip", getLocalIp());
        final d dVar2 = new d(this, str, new com.tencent.mm.plugin.qqmail.b.h.b(i, map, getCookie(), dVar), aVar);
        dVar2.oAt = cVar;
        af.v(new Runnable(this) {
            final /* synthetic */ p oAm;

            public final void run() {
                b bVar = new b();
                this.oAm.oAi.put(Long.valueOf(dVar2.id), dVar2);
                this.oAm.oAj.put(Long.valueOf(dVar2.id), bVar);
                bVar.b(dVar2);
            }
        });
        return dVar2.id;
    }

    public final void cancel(long j) {
        b bVar = (b) this.oAj.get(Long.valueOf(j));
        if (bVar != null) {
            bVar.onCancelled();
            bVar.cancel(true);
        }
        this.oAj.remove(Long.valueOf(j));
        this.oAi.remove(Long.valueOf(j));
    }

    public final void reset() {
        h.CN(aUu());
        for (b cancel : this.oAj.values()) {
            cancel.cancel(true);
        }
        this.oAj.clear();
        this.oAi.clear();
        this.ozF.clear();
        ap.yY();
        String xj = com.tencent.mm.u.c.xj();
        this.oAf = new j(xj + "addr/");
        this.oAg = new c(xj + "draft/");
        this.oAh = new e(xj + "http/", 0);
    }

    public static String aUu() {
        String str = e.gSx;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdir();
        }
        return str;
    }

    private static String getLocalIp() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
        } catch (Exception e2) {
        }
        return null;
    }

    public final Map<String, String> getCookie() {
        Object obj;
        ap.yY();
        String str = (String) com.tencent.mm.u.c.vr().get(-1535680990, null);
        Map map = this.ozF;
        String str2 = "skey";
        if (str == null) {
            obj = "";
        } else {
            String str3 = str;
        }
        map.put(str2, obj);
        ap.yY();
        this.ozF.put(OpenSDKTool4Assistant.EXTRA_UIN, "o" + new o(bg.n(com.tencent.mm.u.c.vr().get(9, null), 0)));
        w.d("MicroMsg.NormalMailAppService", "sKey:%b, uin:%d", new Object[]{Boolean.valueOf(bg.mA(str)), Integer.valueOf(r1)});
        return this.ozF;
    }

    public static int a(d dVar) {
        if (dVar.oAt.oAs) {
            com.tencent.mm.plugin.qqmail.b.h.c cVar = dVar.oAv;
            if (dVar.oAw == null) {
                dVar.oAx.onError(-1002, "format error");
                return -1002;
            }
            int i = bg.getInt((String) dVar.oAw.get(".Response.error.code"), 0);
            if (i == 0) {
                dVar.oAx.onSuccess(cVar.content, dVar.oAw);
                return 0;
            }
            dVar.oAx.onError(i, ai(i, (String) dVar.oAw.get(".Response.error.message")));
            return i;
        }
        dVar.oAx.onSuccess(dVar.oAv.content, null);
        return 0;
    }

    public static String rB(int i) {
        if (oAk == null) {
            oAk = new SparseArray();
            for (Field field : HttpURLConnection.class.getDeclaredFields()) {
                int modifiers = field.getModifiers();
                String name = field.getName();
                if (name != null && name.startsWith("HTTP_") && Modifier.isPublic(modifiers) && Modifier.isFinal(modifiers) && Modifier.isStatic(modifiers)) {
                    try {
                        modifiers = field.getInt(Integer.valueOf(0));
                        StringBuilder stringBuilder = new StringBuilder();
                        String[] split = name.split("_");
                        if (split != null) {
                            for (int i2 = 1; i2 < split.length; i2++) {
                                stringBuilder.append(split[i2]).append(' ');
                            }
                            stringBuilder.append("error");
                        }
                        oAk.put(modifiers, stringBuilder.toString().toLowerCase());
                    } catch (Exception e) {
                    }
                }
            }
        }
        String str = (String) oAk.get(i);
        return str == null ? ai(i, "request error") : str;
    }

    private static String ai(int i, String str) {
        int i2 = 0;
        switch (i) {
            case -105:
            case -6:
                i2 = R.l.eGI;
                break;
            case -104:
                i2 = R.l.eGG;
                break;
            case -103:
                i2 = R.l.eGF;
                break;
            case -102:
                i2 = R.l.eGE;
                break;
            case -7:
                i2 = R.l.eGJ;
                break;
            case -4:
            case -3:
                i2 = R.l.eGH;
                break;
            case -1:
                i2 = R.l.eGC;
                break;
        }
        if (i2 == 0) {
            return str;
        }
        return com.tencent.mm.bg.a.V(ab.getContext(), i2);
    }
}
