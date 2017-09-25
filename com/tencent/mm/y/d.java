package com.tencent.mm.y;

import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.storage.au;
import java.util.HashMap;

public interface d {

    public static class a {
        public bu hst;
        public boolean hsu = false;
        public boolean hsv = false;
        public boolean hsw = false;

        public a(bu buVar, boolean z, boolean z2, boolean z3) {
            this.hst = buVar;
            this.hsu = z;
            this.hsv = z2;
            this.hsw = z3;
        }

        public final String toString() {
            return String.format("AddMsgInfo(%d), get[%b], fault[%b], up[%b]", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(this.hsu), Boolean.valueOf(this.hsv), Boolean.valueOf(this.hsw)});
        }
    }

    public static class b {
        public au fCZ;
        public boolean hsx;

        public b(au auVar, boolean z) {
            this.fCZ = auVar;
            this.hsx = z;
        }
    }

    public static class c {
        private static HashMap<Object, d> hsy = new HashMap();

        public static void a(Object obj, d dVar) {
            hsy.put(obj, dVar);
        }

        public static void aA(Object obj) {
            hsy.remove(obj);
        }

        public static d aB(Object obj) {
            return (d) hsy.get(obj);
        }
    }

    b b(a aVar);

    void h(au auVar);
}
