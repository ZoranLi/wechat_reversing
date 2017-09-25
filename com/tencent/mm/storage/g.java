package com.tencent.mm.storage;

import android.util.SparseArray;
import com.tencent.mm.e.b.f;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.List;

public final class g extends i<f> {
    public static final String[] gUx = new String[]{i.a(f.pw(), "AddContactAntispamTicket")};
    private com.tencent.mm.bj.g hnH;
    SparseArray<String> uyT = new SparseArray();

    public static class a extends f {
        protected final com.tencent.mm.sdk.e.c.a sY() {
            return f.pw();
        }
    }

    public g(e eVar) {
        super(eVar, f.pw(), "AddContactAntispamTicket", null);
        this.hnH = (com.tencent.mm.bj.g) eVar;
    }

    public final void o(String str, int i, String str2) {
        if (!bg.mA(str)) {
            c aVar = new a();
            aVar.field_userName = str;
            aVar.field_scene = i;
            aVar.field_ticket = str2;
            a(aVar);
            eI(str, str2);
        }
    }

    public final void bW(List<f> list) {
        if (list.size() != 0) {
            long cs = this.hnH.cs(Thread.currentThread().getId());
            for (f a : list) {
                a(a);
            }
            this.hnH.aD(cs);
        }
    }

    public final void eI(String str, String str2) {
        if (!bg.mA(str)) {
            this.uyT.put(str.hashCode(), str2);
        }
    }

    public final String QF(String str) {
        if (bg.mA(str)) {
            return null;
        }
        String str2 = (String) this.uyT.get(str.hashCode());
        if (!bg.mA(str2)) {
            return str2;
        }
        c aVar = new a();
        aVar.field_userName = str;
        if (!b(aVar, "userName")) {
            return null;
        }
        String str3 = aVar.field_userName;
        int i = aVar.field_scene;
        eI(str3, aVar.field_ticket);
        return aVar.field_ticket;
    }
}
