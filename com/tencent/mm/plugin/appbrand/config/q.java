package com.tencent.mm.plugin.appbrand.config;

import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.protocal.c.bqi;
import com.tencent.mm.protocal.c.bqj;
import com.tencent.mm.protocal.c.bql;
import com.tencent.mm.protocal.c.fs;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.t.h;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.List;

public final class q {

    interface a<T> {
        String aH(T t);

        String getUsername();

        j ow(String str);

        T ox(String str);
    }

    public interface b<T> {
        void aG(T t);
    }

    static class AnonymousClass2 implements a<AppBrandSysConfig> {
        final /* synthetic */ String fxR;

        public AnonymousClass2(String str) {
            this.fxR = str;
        }

        public final /* bridge */ /* synthetic */ String aH(Object obj) {
            return ((AppBrandSysConfig) obj).iFp;
        }

        public final /* synthetic */ Object ox(String str) {
            return p.ok(str);
        }

        public final String getUsername() {
            return p.op(this.fxR);
        }

        public final j ow(String str) {
            return new j(null, str);
        }
    }

    static boolean os(String str) {
        long Ny = bg.Ny();
        WxaAttributes d = c.PR().d(str, "syncTimeSecond");
        w.i("MicroMsg.WxaAttrSyncHelper", "needUpdateAttr, username(%s), currentMS(%d), lastUpdateTime(%d), freq(%d).", new Object[]{str, Long.valueOf(Ny), Long.valueOf(d == null ? 0 : d.field_syncTimeSecond), Integer.valueOf(g.sV().getInt("MMBizAttrSyncFreq", 3600))});
        if (Ny - (d == null ? 0 : d.field_syncTimeSecond) >= ((long) g.sV().getInt("MMBizAttrSyncFreq", 3600))) {
            return true;
        }
        return false;
    }

    private static boolean ot(String str) {
        if (bg.mA(str) || h.em(str)) {
            return false;
        }
        w.e("MicroMsg.WxaAttrSyncHelper", "checkLogIfInvalidUsername %s, %s", new Object[]{str, ah.g(new Throwable())});
        com.tencent.mm.plugin.report.c.oTb.a(648, 1, 1, false);
        return true;
    }

    static com.tencent.mm.bd.b ou(String str) {
        WxaAttributes d = c.PR().d(str, "syncVersion");
        return new com.tencent.mm.bd.b(d == null ? new byte[0] : bg.PT(bg.mz(d.field_syncVersion)));
    }

    public static void G(final String str, final boolean z) {
        if (!ot(str)) {
            e.post(new Runnable() {
                public final void run() {
                    if (z) {
                        q.H(str, true);
                    } else {
                        q.ov(str);
                    }
                }
            }, "WxaAttrSync");
        }
    }

    public static <T> Pair<T, com.tencent.mm.y.a.a> a(String str, boolean z, a<T> aVar) {
        int i = -1;
        Object obj = null;
        if (bg.mA(str)) {
            return Pair.create(null, null);
        }
        Object obj2;
        if (z) {
            obj2 = null;
        } else {
            obj2 = aVar.ox(str);
            if (!(obj2 == null || bg.mA(aVar.aH(obj2)))) {
                w.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, no need cgi sync, query record %s", new Object[]{Boolean.valueOf(z), obj2});
                return Pair.create(obj2, obj);
            }
        }
        com.tencent.mm.y.a.a b = com.tencent.mm.plugin.appbrand.e.c.b(aVar.ow(str).gUA);
        if (b == null || (b instanceof com.tencent.mm.plugin.appbrand.e.c.a) || b.errType != 0 || b.errCode != 0) {
            String str2 = "MicroMsg.WxaAttrSyncHelper";
            String str3 = "loadOrSync, ignoreLocal %b, errType = %d, errCode = %d, errMsg = %s";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Integer.valueOf(b == null ? -1 : b.errType);
            if (b != null) {
                i = b.errCode;
            }
            objArr[2] = Integer.valueOf(i);
            objArr[3] = b == null ? "null resp" : b.fPf;
            w.e(str2, str3, objArr);
            if (obj2 == null) {
                obj2 = aVar.ox(str);
                if (obj2 == null) {
                    return Pair.create(null, b);
                }
            }
            return Pair.create(obj2, b);
        }
        String str4;
        String str5;
        Iterator it = ((bqj) b.fYb).tkD.iterator();
        while (it.hasNext()) {
            bqi com_tencent_mm_protocal_c_bqi = (bqi) it.next();
            if ("UserName".equalsIgnoreCase(com_tencent_mm_protocal_c_bqi.tkE)) {
                str4 = com_tencent_mm_protocal_c_bqi.oTN;
                if (!str4.endsWith("@app")) {
                    str4 = str4 + "@app";
                }
                if (bg.mA(str4)) {
                    str4 = aVar.getUsername();
                    if (bg.mA(str4)) {
                        w.e("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, key %s, cgi sync fail username invalid", new Object[]{Boolean.valueOf(z), str});
                        return Pair.create(null, null);
                    }
                }
                str5 = str4;
                if (c.PR().a(str5, ((bqj) b.fYb).tkC, ((bqj) b.fYb).tkD)) {
                    p.RG().a("single", 3, str5);
                }
                obj2 = aVar.ox(str);
                w.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, cgi sync result %s", new Object[]{Boolean.valueOf(z), obj2});
                obj = b;
                return Pair.create(obj2, obj);
            }
        }
        str4 = null;
        if (bg.mA(str4)) {
            str4 = aVar.getUsername();
            if (bg.mA(str4)) {
                w.e("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, key %s, cgi sync fail username invalid", new Object[]{Boolean.valueOf(z), str});
                return Pair.create(null, null);
            }
        }
        str5 = str4;
        if (c.PR().a(str5, ((bqj) b.fYb).tkC, ((bqj) b.fYb).tkD)) {
            p.RG().a("single", 3, str5);
        }
        obj2 = aVar.ox(str);
        w.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, cgi sync result %s", new Object[]{Boolean.valueOf(z), obj2});
        obj = b;
        return Pair.create(obj2, obj);
    }

    public static Pair<AppBrandSysConfig, com.tencent.mm.y.a.a> H(final String str, boolean z) {
        if (ot(str)) {
            return new Pair(null, null);
        }
        return a(str, z, new a<AppBrandSysConfig>() {
            public final /* bridge */ /* synthetic */ String aH(Object obj) {
                return ((AppBrandSysConfig) obj).iFp;
            }

            public final /* synthetic */ Object ox(String str) {
                return p.ol(str);
            }

            public final String getUsername() {
                return str;
            }

            public final j ow(String str) {
                return new j(str, null);
            }
        });
    }

    static void a(final String str, final b<WxaAttributes> bVar) {
        if (!ot(str)) {
            Looper looper;
            boolean z;
            if (af.isMainThread() || Looper.myLooper() == null) {
                looper = new af().nJF.getLooper();
                z = true;
            } else {
                looper = Looper.myLooper();
                z = false;
            }
            new ae(looper).post(new Runnable() {
                public final void run() {
                    Pair a = q.a(str, false, new a<WxaAttributes>(this) {
                        final /* synthetic */ AnonymousClass4 iFI;

                        {
                            this.iFI = r1;
                        }

                        public final /* bridge */ /* synthetic */ String aH(Object obj) {
                            return ((WxaAttributes) obj).field_syncVersion;
                        }

                        public final /* synthetic */ Object ox(String str) {
                            return c.PR().d(str, new String[0]);
                        }

                        public final String getUsername() {
                            return str;
                        }

                        public final j ow(String str) {
                            return new j(str, null);
                        }
                    });
                    if (bVar != null) {
                        bVar.aG(a.first);
                    }
                    if (z) {
                        try {
                            ((HandlerThread) Looper.myLooper().getThread()).quit();
                        } catch (Exception e) {
                        }
                    }
                }
            });
        }
    }

    public static AppBrandSysConfig ov(String str) {
        if (ot(str) || !os(str)) {
            return null;
        }
        Pair H = H(str, true);
        if (H.first == null || H.second == null) {
            return null;
        }
        return (AppBrandSysConfig) H.first;
    }

    public static void R(List<String> list) {
        int i = 0;
        if (!bg.bV(list)) {
            w.i("MicroMsg.WxaAttrSyncHelper", "batchSync, list size %d", new Object[]{Integer.valueOf(list.size())});
            int i2 = 0;
            while (i < list.size() / 20) {
                int i3 = i * 20;
                i2 = i3 + 20;
                S(list.subList(i3, i2));
                i++;
            }
            if (i2 < list.size()) {
                S(list.subList(i2, list.size()));
            }
        }
    }

    private static void S(List<String> list) {
        if (!bg.bV(list)) {
            d.vL().D(new Runnable(new i(list) {
                protected final /* synthetic */ void a(int i, int i2, String str, avp com_tencent_mm_protocal_c_avp, k kVar) {
                    fs fsVar = (fs) com_tencent_mm_protocal_c_avp;
                    if (i != 0 || i2 != 0) {
                        w.e("MicroMsg.WxaAttrSyncHelper", "BatchBizAttrSync, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    } else if (fsVar != null) {
                        long RF = c.PR().RF();
                        Iterator it = fsVar.tjg.iterator();
                        int i3 = 0;
                        while (it.hasNext()) {
                            bql com_tencent_mm_protocal_c_bql = (bql) it.next();
                            i3 = c.PR().a(com_tencent_mm_protocal_c_bql.uoB, com_tencent_mm_protocal_c_bql.tkC, com_tencent_mm_protocal_c_bql.tkD) | i3;
                        }
                        c.PR().aD(RF);
                        if (i3 != 0) {
                            p.RG().a("batch", 3, null);
                        }
                    }
                }
            }) {
                final /* synthetic */ i iFs;

                {
                    this.iFs = r1;
                }

                public final void run() {
                    super.BC();
                }
            });
        }
    }
}
