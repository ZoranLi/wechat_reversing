package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.lz;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.ro;
import com.tencent.mm.protocal.c.rs;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.base.g;
import java.util.HashMap;

public final class i extends b {
    private static HashMap<String, com.tencent.mm.plugin.wenote.model.a.i> suj = new HashMap();
    public boolean fQy;
    public String fRj;
    private c oPp = null;
    public Long sui;

    public i() {
        this.stC.clear();
        com.tencent.mm.pluginsdk.model.c.bCC();
    }

    public final void bBe() {
        String str = this.fRj;
        b lzVar = new lz();
        lzVar.fTf.type = 0;
        lzVar.fTf.fTh = str;
        a.urY.m(lzVar);
        this.oPp = lzVar.fTg.fTp;
        if (suj.containsKey(this.fRj)) {
            this.stA = (com.tencent.mm.plugin.wenote.model.a.i) suj.get(this.fRj);
            return;
        }
        this.stA = new com.tencent.mm.plugin.wenote.model.a.i();
        this.stA.fGM = this.sui.longValue();
        this.stA.suG = this.fRj;
        if (this.oPp != null && this.oPp.hkm != null) {
            this.stA.oOQ = this.oPp.hkm;
            this.stA.aMw = 0;
            suj.put(this.fRj, this.stA);
        }
    }

    public final String g(rm rmVar) {
        b lzVar = new lz();
        lzVar.fTf.type = 1;
        lzVar.fTf.fKe = rmVar;
        lzVar.fTf.fGM = this.sui.longValue();
        a.urY.m(lzVar);
        return lzVar.fTg.fTq;
    }

    public final String h(rm rmVar) {
        b lzVar = new lz();
        lzVar.fTf.type = 1;
        lzVar.fTf.fKe = rmVar;
        lzVar.fTf.fGM = this.sui.longValue();
        a.urY.m(lzVar);
        return lzVar.fTg.fKz;
    }

    public final void n(rm rmVar) {
        b lzVar = new lz();
        lzVar.fTf.type = 8;
        lzVar.fTf.fKe = rmVar;
        lzVar.fTf.fGM = this.sui.longValue();
        lzVar.fTf.fKz = "";
        a.urY.m(lzVar);
    }

    public final void a(rm rmVar, String str) {
        b lzVar = new lz();
        lzVar.fTf.type = 8;
        lzVar.fTf.fKe = rmVar;
        lzVar.fTf.fGM = this.sui.longValue();
        lzVar.fTf.fKz = str;
        a.urY.m(lzVar);
    }

    public final boolean bBc() {
        return true;
    }

    public final void t(Context context, Intent intent) {
        intent.putExtra("message_id", this.sui);
        intent.putExtra("record_show_share", this.fQy);
        StringBuilder stringBuilder = new StringBuilder("file://");
        ap.yY();
        intent.putExtra("note_sdcard_recources_dir", stringBuilder.append(com.tencent.mm.u.c.xp()).toString());
        d.b(context, "wenote", ".ui.h5note.WNNoteMsgWebViewUI", intent);
    }

    public final void Le(String str) {
        Intent intent = new Intent();
        intent.putExtra("message_id", this.sui);
        intent.putExtra("record_xml", this.fRj);
        intent.putExtra("record_data_id", ((k) this.stD.get(str)).lKv);
        d.b(ab.getContext(), "record", ".ui.RecordMsgFileUI", intent);
    }

    public final void Lg(String str) {
        Intent intent = new Intent();
        intent.putExtra("message_id", this.sui);
        intent.putExtra("record_data_id", ((k) this.stD.get(str)).lKv);
        intent.putExtra("record_xml", this.fRj);
        d.b(ab.getContext(), "record", ".ui.RecordMsgImageUI", intent);
    }

    public final void Lf(String str) {
        ro roVar;
        String str2 = null;
        rm rmVar = ((k) this.stD.get(str)).suH;
        if (rmVar.tyc != null) {
            rs rsVar = rmVar.tyc.tyw;
            roVar = rmVar.tyc.tyu;
        } else {
            roVar = null;
        }
        if (roVar != null) {
            if (bg.mA(roVar.tyQ)) {
                str2 = n.eK(roVar.fOu);
            } else {
                str2 = n.eK(roVar.tyQ);
            }
        }
        com.tencent.mm.plugin.wenote.model.a.n nVar = (com.tencent.mm.plugin.wenote.model.a.n) this.stD.get(str);
        if (nVar == null) {
            g.bl(ab.getContext(), ab.getContext().getString(R.l.ejf));
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 2);
        intent.putExtra("kwebmap_slat", nVar.lat);
        intent.putExtra("kwebmap_lng", nVar.lng);
        intent.putExtra("kPoiName", nVar.ndv);
        intent.putExtra("Kwebmap_locaion", nVar.hCE);
        if (nVar.suO >= 0.0d) {
            intent.putExtra("kwebmap_scale", nVar.suO);
        }
        intent.putExtra("kisUsername", str2);
        intent.putExtra("kwebmap_from_to", true);
        intent.putExtra("KFavLocSigleView", true);
        intent.putExtra("kFavCanDel", false);
        intent.putExtra("kFavCanRemark", false);
        d.b(ab.getContext(), "location", ".ui.RedirectUI", intent);
    }
}
