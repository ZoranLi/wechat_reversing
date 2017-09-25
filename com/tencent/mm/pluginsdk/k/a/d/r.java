package com.tencent.mm.pluginsdk.k.a.d;

import android.annotation.SuppressLint;
import com.tencent.mm.a.g;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.w;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

public final class r extends i<q> {
    public static final String[] gUx = new String[]{i.a(q.gTP, "ResDownloaderRecordTable")};
    private static final String sGT = (w.hgq + g.n(String.format("mm%d", new Object[]{Integer.valueOf(Integer.MIN_VALUE)}).getBytes()) + "/");
    @SuppressLint({"UseSparseArrays"})
    private static final HashMap<Integer, c> sGU;
    public final com.tencent.mm.bj.g hnH;
    private final HashMap<String, Object> sGV = new HashMap();

    public final /* synthetic */ boolean b(com.tencent.mm.sdk.e.c cVar) {
        return g((q) cVar);
    }

    static {
        HashMap hashMap = new HashMap();
        sGU = hashMap;
        hashMap.put(Integer.valueOf("RES_DOWNLOADER_RECORD_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return r.gUx;
            }
        });
        Iterator it = p.bDH().iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private r(com.tencent.mm.bj.g gVar) {
        super(gVar, q.gTP, "ResDownloaderRecordTable", null);
        this.hnH = gVar;
        Iterator it = p.bDH().iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    static r bDI() {
        try {
            new File(sGT).mkdirs();
            com.tencent.mm.bj.g gVar = new com.tencent.mm.bj.g();
            if (gVar.a(sGT + "ResDown.db", sGT + "EnResDown.db", -2147483648L, p.rA(), sGU)) {
                return new r(gVar);
            }
            com.tencent.mm.sdk.platformtools.w.f("MicroMsg.ResDownloaderStorage", "res downloader db init failed");
            return null;
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ResDownloaderStorage", "new storage failed, exception = %s", e);
            return null;
        }
    }

    public final boolean gR(String str) {
        if (bg.mA(str)) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ResDownloaderStorage", "delete with null or nil urlKey, return false");
            return false;
        }
        com.tencent.mm.sdk.e.c qVar = new q();
        qVar.field_urlKey_hashcode = str.hashCode();
        return super.a(qVar, "urlKey_hashcode");
    }

    public final boolean f(q qVar) {
        if (bg.mA(qVar.field_urlKey)) {
            return false;
        }
        qVar.field_urlKey_hashcode = qVar.field_urlKey.hashCode();
        return super.c(qVar, "urlKey_hashcode");
    }

    public final boolean g(q qVar) {
        if (bg.mA(qVar.field_urlKey)) {
            return false;
        }
        qVar.field_urlKey_hashcode = qVar.field_urlKey.hashCode();
        return super.b((com.tencent.mm.sdk.e.c) qVar);
    }

    public final q Mu(String str) {
        if (bg.mA(str)) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ResDownloaderStorage", "query with null or nil urlKey, return null");
            return null;
        }
        com.tencent.mm.sdk.e.c qVar = new q();
        qVar.field_urlKey_hashcode = str.hashCode();
        if (super.b(qVar, "urlKey_hashcode")) {
            return qVar;
        }
        return null;
    }
}
