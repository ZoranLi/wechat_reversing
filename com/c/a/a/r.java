package com.c.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import org.json.JSONObject;

final class r extends d {
    private static final DecimalFormat aMc = new DecimalFormat("0000000000");
    private static final DecimalFormat aMd = new DecimalFormat("0000000000000000");
    private static r aMe;
    private String aMf;
    private String aMg;
    private final b aMh = new b();
    int aMi;
    z aMj;
    private SharedPreferences aMk;
    public f aMl;
    private final Object aMm = new Object();
    private final d aMn = new d(this);
    private int aMo;
    q aMp;
    String aMq;

    private static abstract class a implements Runnable {
        private final WeakReference<r> aMr;

        public a(r rVar) {
            this.aMr = new WeakReference(rVar);
        }

        final r nw() {
            r rVar = (r) this.aMr.get();
            if (rVar != null) {
                return rVar;
            }
            throw new Exception("OnlineModule.AbstractOnlineModuleRunnable: online module not available");
        }
    }

    private static class b {
        public final byte[] aMs = new byte[27];
        private final byte[] aMt = new byte[8];
        public int code = -1;
    }

    private static class c extends a {
        private final String aMu;
        private final long aMv;
        private final int aMw;

        public c(r rVar, String str, long j, int i) {
            super(rVar);
            this.aMu = str;
            this.aMv = j;
            this.aMw = i;
        }

        public final void run() {
            try {
                switch (this.aMw) {
                    case 0:
                        nw().e(this.aMu, this.aMv);
                        return;
                    case 1:
                        nw().aA(this.aMu);
                        return;
                    default:
                        return;
                }
            } catch (Exception e) {
            }
        }
    }

    private static class d extends a {
        boolean aMx;

        public d(r rVar) {
            super(rVar);
        }

        public final void run() {
            try {
                r nw = nw();
                try {
                    nw.nv();
                    if (nw.nr()) {
                        nw.aMi = 0;
                    }
                } catch (Exception e) {
                }
                f fVar = nw().aMl;
                try {
                    fVar.aJw = Build.MODEL;
                    fVar.aJx = VERSION.RELEASE;
                    fVar.versionName = fVar.aJu.versionName;
                    CharSequence loadLabel = fVar.mContext.getApplicationInfo().loadLabel(fVar.aJt);
                    fVar.aJv = loadLabel != null ? loadLabel.toString() : "unknown";
                    if (fVar.aJs != null) {
                        Sensor defaultSensor = fVar.aJs.getDefaultSensor(1);
                        Sensor defaultSensor2 = fVar.aJs.getDefaultSensor(4);
                        Sensor defaultSensor3 = fVar.aJs.getDefaultSensor(2);
                        Sensor defaultSensor4 = fVar.aJs.getDefaultSensor(11);
                        if (defaultSensor != null) {
                            fVar.aJA = 1;
                        }
                        if (defaultSensor2 != null) {
                            fVar.aJB = 1;
                        }
                        if (defaultSensor3 != null) {
                            fVar.aJC = 1;
                        }
                        if (defaultSensor4 != null) {
                            fVar.aJD = 1;
                        }
                    }
                } catch (Exception e2) {
                } catch (Error e3) {
                }
            } catch (Exception e4) {
            }
            this.aMx = false;
        }
    }

    private static class e extends a {
        private final int aLJ;
        private final String aMu;
        private final long aMv;
        private final long aMy;
        private final boolean aMz = true;

        public e(r rVar, String str, long j, long j2, int i, boolean z) {
            super(rVar);
            this.aMu = str;
            this.aMv = j;
            this.aMy = j2;
            this.aLJ = i;
        }

        public final void run() {
            try {
                nw().a(this.aMu, this.aMv, this.aMy, this.aLJ, this.aMz);
            } catch (Exception e) {
            }
        }
    }

    static class f extends p {
        final int aMA;
        final x aMB;
        final boolean aMC;
        final String message;

        public f(int i, x xVar, String str) {
            super(com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX);
            this.aMA = i;
            this.aMB = xVar;
            this.message = str;
            boolean z = (this.aMA < 0 || this.aMA == 4 || this.aMA == 2) ? false : true;
            this.aMC = z;
        }
    }

    private r() {
    }

    static r np() {
        if (aMe == null) {
            aMe = new r();
        }
        return aMe;
    }

    final void O(Context context) {
        try {
            String str = this.aMq;
            if (TextUtils.isEmpty(str)) {
                str = "0000000000";
            }
            this.aMf = aB(str);
            this.aMg = a(Long.valueOf(System.currentTimeMillis() / 1000));
            this.aMl = new f(context);
        } catch (Exception e) {
        }
        this.aMk = context.getSharedPreferences("0-474-85242", 0);
    }

    final void a(Context context, Handler handler, a aVar) {
        this.aMj = z.b(handler);
        nq();
    }

    final void P(Context context) {
    }

    final void ne() {
        this.aMp = null;
    }

    final void nq() {
        if (this.aMj != null) {
            try {
                z zVar = this.aMj;
                Runnable runnable = this.aMn;
                if (runnable.aMx) {
                    throw new Exception("OnlineModule: new-session runnable occupied");
                }
                runnable.aMx = true;
                zVar.execute(runnable);
            } catch (Exception e) {
            }
        }
    }

    final void az(String str) {
        if (this.aMj != null) {
            this.aMj.execute(new c(this, str, 0, 1));
        }
    }

    final boolean nr() {
        return this.aMh.code == 1;
    }

    public final void a(String str, long j, long j2, int i, boolean z) {
        if (this.aJi) {
            synchronized (this.aMm) {
                String stringBuilder;
                String ns = ns();
                if (str != null) {
                    stringBuilder = new StringBuilder(String.valueOf(str)).append(ns).toString();
                } else {
                    stringBuilder = ns;
                }
                if (stringBuilder.length() > 0) {
                    try {
                        long p = aa.p(j);
                        int i2 = this.aMi + 1;
                        this.aMi = i2;
                        String str2 = y.aPj;
                        String str3 = y.aPo;
                        boolean z2 = y.aPq;
                        int i3 = y.aPk;
                        int i4 = y.aPl;
                        if (str2 == null || str3 == null) {
                            throw new Exception("StringBuilding: null mode or user name");
                        }
                        ns = new StringBuilder(String.valueOf("ST=" + String.valueOf(p) + ',' + i2 + ',' + str2 + ',' + str3 + ',' + (z2 ? '1' : '0') + ',' + i3 + ',' + i4 + ',' + i)).append(stringBuilder).toString();
                        if (y.aPp) {
                            o.m("data_transaction_log_" + y.aPw, ns);
                        }
                        Object encode = Base64.encode(g.l(ns.getBytes("UTF-8")), 0);
                        Object obj = new byte[(this.aMh.aMs.length + encode.length)];
                        System.arraycopy(this.aMh.aMs, 0, obj, 0, this.aMh.aMs.length);
                        System.arraycopy(encode, 0, obj, this.aMh.aMs.length, encode.length);
                        this.aMl.imei = this.aMq;
                        stringBuilder = new String(this.aMp.m(this.aMl.k(obj).getBytes("UTF-8")));
                        if (y.aPp) {
                            o.m("data_transaction_log_" + y.aPw, stringBuilder);
                        }
                        p b = b(stringBuilder, j, j2);
                        if (b.aMC) {
                            nt();
                            this.aMo = 0;
                        } else {
                            this.aMo++;
                            int length = nu().getString("1-115-10127", "").length();
                            if (this.aMo > 20 || (length > 10240 && this.aMo > 3)) {
                                nt();
                            }
                        }
                        if (b.aMA == 4) {
                            this.aMh.code = -1;
                        }
                        c(b);
                        if (b.aMC) {
                            return;
                        }
                    } catch (Exception e) {
                        c(new f(0, null, "connection failure"));
                        if (z) {
                            e(str, aa.p(j));
                        }
                    }
                }
            }
        }
        if (z) {
            e(str, aa.p(j));
        }
    }

    private static f b(String str, long j, long j2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("errorcode", -5);
            if (optInt != 0) {
                return new f(optInt, null, null);
            }
            long optLong = jSONObject.optLong("hitarea", 0);
            String str2 = new String(Base64.decode(jSONObject.optString("swdata", null), 0), "UTF-8");
            if (y.aPp) {
                o.m("data_transaction_log_" + y.aPw, str2);
            }
            if (str2.length() <= h.aJI || !str2.startsWith("$UP,")) {
                throw new Exception("OnlineModule: parse data upload reply and generate msg: invalid arg");
            }
            switch (str2.charAt(h.aJI)) {
                case '0':
                    return new f(0, null, str2.length() > h.aJJ ? str2.substring(h.aJJ) : null);
                case '1':
                    if (str2.length() > h.aJJ) {
                        x d = d(str2.substring(h.aJJ), optLong);
                        d.aPc = j;
                        d.aMy = j2;
                        return new f(1, d, null);
                    }
                    break;
                case '2':
                    return new f(2, null, str2.length() > h.aJJ ? str2.substring(h.aJJ) : null);
                case '3':
                    return new f(3, null, str2.length() > h.aJJ ? str2.substring(h.aJJ) : null);
                case '4':
                    return new f(4, null, str2.length() > h.aJJ ? str2.substring(h.aJJ) : null);
                case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                    return new f(5, null, str2.length() > h.aJJ ? str2.substring(h.aJJ) : null);
                case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
                    return new f(6, null, str2.length() > h.aJJ ? str2.substring(h.aJJ) : null);
            }
            throw new Exception("OnlineModule: unable to parse data upload reply");
        } catch (Exception e) {
            if (y.aPp) {
                o.m("data_transaction_log_" + y.aPw, "parse json data error");
            }
            throw new Exception("parse json data error");
        }
    }

    private static x d(String str, long j) {
        int i = 0;
        if (str != null) {
            String[] split = str.split(",", -1);
            if (split.length == 10) {
                try {
                    int parseInt;
                    int parseInt2;
                    int parseInt3;
                    double parseDouble = Double.parseDouble(split[0]);
                    double parseDouble2 = Double.parseDouble(split[1]);
                    float parseFloat = Float.parseFloat(split[8]);
                    try {
                        parseInt = Integer.parseInt(split[3]);
                    } catch (NumberFormatException e) {
                        parseInt = i;
                    }
                    try {
                        parseInt2 = Integer.parseInt(split[4]);
                    } catch (NumberFormatException e2) {
                        parseInt2 = i;
                    }
                    try {
                        parseInt3 = Integer.parseInt(split[5]);
                    } catch (NumberFormatException e3) {
                        parseInt3 = i;
                    }
                    try {
                        i = Integer.parseInt(split[7]);
                    } catch (NumberFormatException e4) {
                    }
                    float f = 0.0f;
                    try {
                        f = Float.parseFloat(split[9]);
                    } catch (NumberFormatException e5) {
                    }
                    x xVar = new x();
                    xVar.latitude = parseDouble;
                    xVar.longitude = parseDouble2;
                    xVar.aOZ = split[2];
                    xVar.level = parseInt;
                    xVar.aPb = (long) parseInt2;
                    xVar.aPe = parseInt3;
                    xVar.aPa = split[6];
                    xVar.aPf = i;
                    xVar.aLh = parseFloat;
                    if (xVar.aPd == null) {
                        xVar.aPd = new a();
                    }
                    xVar.aPd.aPg = f;
                    xVar.aLN = j;
                    return xVar;
                } catch (NumberFormatException e6) {
                }
            }
        }
        throw new Exception("OnlineModule: unable to get location from data upload reply");
    }

    public final void e(String str, long j) {
        String str2 = null;
        String str3 = "1";
        if (!(str == null || str.startsWith("&OD[]="))) {
            String aE = v.aE(v.aF(str));
            aE = aE == null ? null : aE.replace("&MD=", "|MD,");
            if (aE != null) {
                str2 = aE.replace("&WD[]=", "|WD,");
            }
            str = v.a(str2, j, str3);
        }
        aA(str);
    }

    @SuppressLint({"NewApi"})
    public final void aA(String str) {
        if (str != null) {
            synchronized (this.aMm) {
                try {
                    String stringBuilder = new StringBuilder(String.valueOf(nu().getString("1-115-10127", ""))).append(str).toString();
                    int length = stringBuilder.length() - 307200;
                    if (length > 0) {
                        int indexOf = stringBuilder.indexOf("&OD[]=", length);
                        stringBuilder = indexOf >= length ? stringBuilder.substring(indexOf) : "";
                    }
                    if (VERSION.SDK_INT >= 9) {
                        nu().edit().putString("1-115-10127", stringBuilder).apply();
                    } else {
                        nu().edit().putString("1-115-10127", stringBuilder).commit();
                    }
                } catch (Exception e) {
                } catch (Error e2) {
                    try {
                        if (VERSION.SDK_INT >= 9) {
                            nu().edit().putString("1-115-10127", "").apply();
                        } else {
                            nu().edit().putString("1-115-10127", "").commit();
                        }
                    } catch (Exception e3) {
                    }
                }
            }
        }
    }

    private String ns() {
        try {
            return nu().getString("1-115-10127", "");
        } catch (Exception e) {
            return "";
        }
    }

    @SuppressLint({"NewApi"})
    private void nt() {
        try {
            if (VERSION.SDK_INT >= 9) {
                nu().edit().remove("1-115-10127").apply();
            } else {
                nu().edit().remove("1-115-10127").commit();
            }
        } catch (Exception e) {
        }
    }

    private SharedPreferences nu() {
        if (this.aMk != null) {
            return this.aMk;
        }
        throw new Exception("OnlineModule: data buffer unavailable");
    }

    final synchronized void nv() {
        String str = this.aMf;
        String str2 = this.aMg;
        b bVar = this.aMh;
        if (str == null || str2 == null || bVar == null) {
            throw new Exception("OnlineModule: authenticate: null arg");
        }
        System.arraycopy(new StringBuilder(String.valueOf(str)).append(str2).toString().getBytes(), 0, bVar.aMs, 0, 27);
        bVar.code = 1;
    }

    private static String aB(String str) {
        try {
            return "T" + aMd.format(Long.parseLong(str) + System.currentTimeMillis());
        } catch (NumberFormatException e) {
            throw new Exception("OnlineModule: invalid device id, type: 0");
        }
    }

    private static String a(Long l) {
        if (l == null) {
            throw new Exception("OnlineModule: null source id");
        }
        try {
            return aMc.format(l);
        } catch (NumberFormatException e) {
            throw new Exception("OnlineModule: invalid source id");
        }
    }
}
