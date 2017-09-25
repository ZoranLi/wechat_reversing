package com.tencent.mm.plugin.game.model;

import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.game.c.aq;
import com.tencent.mm.plugin.game.c.bw;
import com.tencent.mm.plugin.game.c.cd;
import com.tencent.mm.plugin.game.c.j;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.plugin.game.ui.GameLibraryCategoriesView;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class af extends aa {
    private int mqY;
    public aq mrr;
    public LinkedList<c> mrs;
    public LinkedList<c> mrt;

    public af(a aVar, boolean z, int i) {
        this.mqY = 0;
        if (aVar == null) {
            this.mrr = new aq();
            return;
        }
        this.mrr = (aq) aVar;
        this.mqY = i;
        this.mrs = aBp();
        this.mrt = aBq();
        if (z) {
            SubCoreGameCenter.aBF().a("pb_library", aVar);
        }
        d.U(this.mrs);
        d.U(this.mrt);
    }

    public af(byte[] bArr) {
        this.mqY = 0;
        this.mrr = new aq();
        if (bArr != null && bArr.length != 0) {
            try {
                this.mrr.aD(bArr);
            } catch (IOException e) {
                w.e("MicroMsg.GamePBDataLibrary", "Parsing Failed: %s", new Object[]{e.getMessage()});
            }
            this.mrs = aBp();
            this.mrt = aBq();
            d.U(this.mrs);
            d.U(this.mrt);
        }
    }

    private LinkedList<c> aBp() {
        LinkedList<c> linkedList = new LinkedList();
        if (this.mrr.muA == null || this.mrr.muA.mvk == null || this.mrr.muA.mvk.mvx == null) {
            return linkedList;
        }
        Iterator it = this.mrr.muA.mvk.mvx.iterator();
        int i = 1;
        while (it.hasNext()) {
            bw bwVar = (bw) it.next();
            c a = aa.a(bwVar.msc);
            if (a != null) {
                a.moJ = bwVar.msc.msr;
                a.scene = 11;
                a.fTL = 1110;
                int i2 = i + 1;
                a.position = i;
                linkedList.add(a);
                i = i2;
            }
        }
        return linkedList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.LinkedList<com.tencent.mm.plugin.game.model.c> aBq() {
        /*
        r7 = this;
        r3 = new java.util.LinkedList;
        r3.<init>();
        r0 = r7.mrr;
        r0 = r0.muB;
        if (r0 != 0) goto L_0x000d;
    L_0x000b:
        r0 = r3;
    L_0x000c:
        return r0;
    L_0x000d:
        r0 = r7.mqY;
        r1 = r0 + 1;
        r0 = r7.mqY;
        r0 = r0 / 15;
        r0 = r0 + 901;
        r2 = r7.mrr;
        r2 = r2.muB;
        r5 = r2.iterator();
        r2 = r1;
        r1 = r0;
    L_0x0021:
        r0 = r5.hasNext();
        if (r0 == 0) goto L_0x0076;
    L_0x0027:
        r0 = r5.next();
        r0 = (com.tencent.mm.plugin.game.c.b) r0;
        r4 = 0;
        r6 = r0.jOc;
        switch(r6) {
            case 1: goto L_0x0046;
            case 2: goto L_0x0054;
            default: goto L_0x0033;
        };
    L_0x0033:
        r0 = r1;
        r1 = r2;
        r2 = r4;
    L_0x0036:
        if (r2 == 0) goto L_0x0078;
    L_0x0038:
        r4 = 11;
        r2.scene = r4;
        r4 = 1111; // 0x457 float:1.557E-42 double:5.49E-321;
        r2.fTL = r4;
        r3.add(r2);
        r2 = r1;
        r1 = r0;
        goto L_0x0021;
    L_0x0046:
        r0 = r0.msc;
        r0 = com.tencent.mm.plugin.game.model.aa.a(r0);
        r4 = r2 + 1;
        r0.position = r2;
        r2 = r0;
        r0 = r1;
        r1 = r4;
        goto L_0x0036;
    L_0x0054:
        r6 = r0.msf;
        if (r6 == 0) goto L_0x0033;
    L_0x0058:
        r4 = r0.msf;
        r4 = r4.msc;
        r4 = com.tencent.mm.plugin.game.model.aa.a(r4);
        r6 = 1;
        r4.type = r6;
        r6 = r0.msf;
        r6 = r6.mse;
        r4.moB = r6;
        r0 = r0.msf;
        r0 = r0.msd;
        r4.moC = r0;
        r0 = r1 + 1;
        r4.position = r1;
        r1 = r2;
        r2 = r4;
        goto L_0x0036;
    L_0x0076:
        r0 = r3;
        goto L_0x000c;
    L_0x0078:
        r2 = r1;
        r1 = r0;
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.model.af.aBq():java.util.LinkedList<com.tencent.mm.plugin.game.model.c>");
    }

    public final HashMap<Integer, String> aBr() {
        HashMap<Integer, String> linkedHashMap = new LinkedHashMap();
        if (this.mrr.muA == null || this.mrr.muA.mvn == null) {
            return linkedHashMap;
        }
        Iterator it = this.mrr.muA.mvn.iterator();
        while (it.hasNext()) {
            cd cdVar = (cd) it.next();
            int i = cdVar.muy;
            linkedHashMap.put(Integer.valueOf(i), cdVar.msj);
        }
        return linkedHashMap;
    }

    public final LinkedList<GameLibraryCategoriesView.a> aBs() {
        if (this.mrr.muA == null || this.mrr.muA.mvl == null) {
            return null;
        }
        LinkedList<GameLibraryCategoriesView.a> linkedList = new LinkedList();
        Iterator it = this.mrr.muA.mvl.iterator();
        int i = 0;
        while (it.hasNext()) {
            j jVar = (j) it.next();
            GameLibraryCategoriesView.a aVar = new GameLibraryCategoriesView.a();
            aVar.mBO = jVar.msO;
            aVar.mBP = jVar.msj;
            aVar.mBQ = jVar.mse;
            aVar.jhe = jVar.msi;
            int i2 = i + 1;
            aVar.position = i2;
            linkedList.add(aVar);
            i = i2;
        }
        return linkedList;
    }
}
