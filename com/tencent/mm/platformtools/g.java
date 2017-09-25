package com.tencent.mm.platformtools;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.b;
import java.util.HashMap;
import junit.framework.Assert;

public final class g {
    public static SparseArray<a> ihE = new SparseArray();

    public static final class a extends com.tencent.mm.bj.g {
        public final boolean ihF;
        SparseBooleanArray ihG = new SparseBooleanArray();
        private final String path;

        public a(String str, boolean z) {
            w.d("MicroMsg.GeneralDBHelper", "create db %s", str);
            this.ihF = z;
            this.path = str;
        }

        public final void ha(int i) {
            w.d("MicroMsg.GeneralDBHelper", "try close db %d", Integer.valueOf(i));
            this.ihG.delete(i);
            if (this.ihG.size() <= 0) {
                w.d("MicroMsg.GeneralDBHelper", "close db %d succ", Integer.valueOf(i));
                super.wL();
                g.ihE.remove(this.path.hashCode());
            }
        }

        @Deprecated
        public final void wL() {
            w.e("MicroMsg.GeneralDBHelper", "forbid to use this method %s", bg.bJZ());
            if (this.ihG.size() <= 1) {
                super.wL();
            }
        }

        @Deprecated
        public final void cQ(String str) {
            w.e("MicroMsg.GeneralDBHelper", "forbid to use this method");
            if (this.ihG.size() <= 1) {
                super.cQ(str);
            }
        }
    }

    public static final a a(int i, String str, HashMap<Integer, c> hashMap, boolean z) {
        boolean z2 = (bg.mA(str) || hashMap == null) ? false : true;
        Assert.assertTrue(z2);
        int hashCode = str.hashCode();
        a aVar = (a) ihE.get(hashCode);
        if (aVar == null) {
            aVar = new a(str, z);
            if (z) {
                h.vG();
                if (!aVar.a("", str, "", (long) com.tencent.mm.kernel.a.uH(), p.rA(), hashMap, true)) {
                    throw new b((byte) 0);
                }
            } else if (!aVar.b(str, hashMap, true, false)) {
                throw new b((byte) 0);
            }
            ihE.put(hashCode, aVar);
        } else {
            Assert.assertTrue(z == aVar.ihF);
            long cs = aVar.cs(-1);
            for (c pP : hashMap.values()) {
                for (String str2 : pP.pP()) {
                    w.d("MicroMsg.GeneralDBHelper", "init sql:" + str2);
                    try {
                        aVar.eE(null, str2);
                    } catch (Exception e) {
                        Assert.assertTrue("CreateTable failed:[" + str2 + "][" + e.getMessage() + "]", false);
                    }
                }
            }
            aVar.aD(cs);
        }
        w.d("MicroMsg.GeneralDBHelper", "addRef %d", Integer.valueOf(i));
        aVar.ihG.put(i, true);
        return aVar;
    }
}
