package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.c.am;
import com.tencent.mm.plugin.game.c.ax;
import com.tencent.mm.plugin.game.c.ba;
import com.tencent.mm.plugin.game.c.bc;
import com.tencent.mm.plugin.game.c.bq;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class ac extends aa {
    public am mqZ;
    private boolean mra;
    public c mrb;
    public ad mrc;

    public static class a {
        public String desc;
        public String title;
        public String url;
    }

    public static class b {
        public String desc;
        public String fSl;
        public String title;
        public String url;
    }

    public ac(com.tencent.mm.bd.a aVar) {
        if (aVar == null) {
            this.mqZ = new am();
            return;
        }
        this.mqZ = (am) aVar;
        this.mra = false;
        Oe();
    }

    public ac(byte[] bArr) {
        this.mqZ = new am();
        if (bArr != null && bArr.length != 0) {
            try {
                this.mqZ.aD(bArr);
            } catch (IOException e) {
                w.e("MicroMsg.GamePBDataDetail", "Parsing Failed: %s", new Object[]{e.getMessage()});
            }
            this.mra = true;
            Oe();
        }
    }

    private void Oe() {
        c a = aa.a(this.mqZ.msc);
        a.scene = 12;
        a.fTL = 1201;
        this.mrb = a;
        if (this.mra) {
            this.mrc = new ad(this.mrb.field_appId);
        } else {
            this.mrc = new ad(this.mrb.field_appId, this.mqZ.mtZ != null ? this.mqZ.mtZ.mvz : null);
        }
        if (!this.mra) {
            d.a(this.mrb);
            SubCoreGameCenter.aBF().a(this.mrb.field_appId, this.mqZ);
        }
    }

    public final String aBa() {
        if (this.mqZ.mud != null) {
            return this.mqZ.mud.title;
        }
        if (this.mqZ.mtY != null) {
            return this.mqZ.mtY.fDC;
        }
        return null;
    }

    public final LinkedList<b> aBb() {
        LinkedList<b> linkedList;
        Iterator it;
        b bVar;
        if (this.mqZ.mud != null && this.mqZ.mud.khj != null) {
            linkedList = new LinkedList();
            it = this.mqZ.mud.khj.iterator();
            while (it.hasNext()) {
                bc bcVar = (bc) it.next();
                bVar = new b();
                bVar.fSl = bcVar.fSl;
                bVar.desc = bcVar.desc;
                linkedList.add(bVar);
            }
            return linkedList;
        } else if (this.mqZ.mtY == null || this.mqZ.mtY.muJ == null) {
            return null;
        } else {
            linkedList = new LinkedList();
            it = this.mqZ.mtY.muJ.iterator();
            while (it.hasNext()) {
                ax axVar = (ax) it.next();
                bVar = new b();
                bVar.fSl = axVar.muM;
                bVar.title = axVar.fDC;
                bVar.desc = axVar.mtg;
                bVar.url = axVar.mse;
                linkedList.add(bVar);
            }
            return linkedList;
        }
    }

    public final int aBc() {
        if (this.mqZ.mud != null) {
            return 2;
        }
        return 1;
    }

    public final LinkedList<com.tencent.mm.plugin.game.ui.GameMediaList.a> aBd() {
        LinkedList<com.tencent.mm.plugin.game.ui.GameMediaList.a> linkedList = new LinkedList();
        if (this.mqZ.mtW == null || this.mqZ.mtW.mvh == null) {
            return linkedList;
        }
        Iterator it = this.mqZ.mtW.mvh.iterator();
        while (it.hasNext()) {
            bq bqVar = (bq) it.next();
            com.tencent.mm.plugin.game.ui.GameMediaList.a aVar = new com.tencent.mm.plugin.game.ui.GameMediaList.a();
            aVar.type = bqVar.mvo;
            aVar.mCG = bqVar.mvp;
            aVar.url = bqVar.mvq;
            linkedList.add(aVar);
        }
        return linkedList;
    }

    public final String aBe() {
        if (this.mqZ.mtW == null || this.mqZ.mtW.fDC == null) {
            return null;
        }
        return this.mqZ.mtW.fDC;
    }

    public final String aBf() {
        if (this.mqZ.mtW == null || this.mqZ.mtW.mtg == null) {
            return null;
        }
        return this.mqZ.mtW.mtg;
    }

    public final String aBg() {
        if (this.mqZ.mtX == null) {
            return null;
        }
        return this.mqZ.mtX.fDC;
    }

    public final LinkedList<ba> aBh() {
        if (this.mqZ.mtX == null) {
            return null;
        }
        return this.mqZ.mtX.muP;
    }
}
