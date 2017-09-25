package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.fp;
import com.tencent.mm.e.a.fs;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.a.n;
import com.tencent.mm.plugin.wenote.model.a.p;
import com.tencent.mm.pluginsdk.model.c;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import java.util.HashMap;

public final class f extends b implements e {
    public static HashMap<d, i> stS = new HashMap();
    public long fQF = -1;
    public boolean fQy = true;
    public String stQ = "";
    public d stR;

    public f() {
        this.stC.clear();
        this.stB = null;
        stF = "";
        this.soD = false;
        c.bCC();
        ap.vd().a(426, this);
    }

    public final void di(Context context) {
        Intent intent = new Intent();
        intent.putExtra("from_session", false);
        intent.putExtra("edit_status", this.soD);
        intent.putExtra("show_share", this.fQy);
        intent.putExtra("key_detail_info_id", this.fQF);
        d.b(context, "wenote", ".ui.nativenote.NoteEditorUI", intent);
    }

    public final void jg(boolean z) {
        d dVar;
        long j = this.fQF;
        b fsVar = new fs();
        fsVar.fKM.fFx = j;
        a.urY.m(fsVar);
        if (fsVar.fKN.ret == 0) {
            w.w("MicroMsg.WNNoteFavLogic", "can not fetch FavItem");
            dVar = null;
        } else {
            w.d("MicroMsg.WNNoteFavLogic", "fetch favitem localId %s, itemStatus %d", new Object[]{Long.valueOf(fsVar.fKM.fFx), Integer.valueOf(fsVar.fKN.field_itemStatus)});
            dVar = new d();
            dVar.field_localId = fsVar.fKM.fFx;
            dVar.field_id = fsVar.fKN.field_id;
            dVar.field_fromUser = fsVar.fKN.field_fromUser;
            dVar.field_toUser = fsVar.fKN.field_toUser;
            dVar.field_favProto = fsVar.fKN.field_favProto;
            dVar.field_realChatName = fsVar.fKN.field_realChatName;
            dVar.field_type = fsVar.fKN.field_type;
            dVar.field_itemStatus = fsVar.fKN.field_itemStatus;
        }
        this.stR = dVar;
        if (this.stR != null) {
            this.stH = this.stR.field_favProto;
            if (!z) {
                e.bBd();
            }
            this.stB = this.stR;
        }
    }

    public final void bBe() {
        this.stA = new i();
        this.stA.suF = this.stR;
        this.stA.fQF = this.fQF;
        this.stA.aMw = 1;
        if (this.stR != null && this.stR.field_favProto != null) {
            this.stA.oOQ = this.stR.field_favProto.tzn;
            stS.put(this.stR, this.stA);
        }
    }

    public final String g(rm rmVar) {
        return e.o(rmVar);
    }

    public final String h(rm rmVar) {
        return e.h(rmVar);
    }

    public final void n(rm rmVar) {
        i iVar = this.stA;
        b fpVar = new fp();
        fpVar.fKp.type = 28;
        fpVar.fKp.fFx = iVar.suF.field_localId;
        fpVar.fKp.fKr = rmVar;
        fpVar.fKp.path = "";
        a.urY.m(fpVar);
    }

    public final void a(rm rmVar, String str) {
        i iVar = this.stA;
        b fpVar = new fp();
        fpVar.fKp.type = 28;
        fpVar.fKp.fFx = iVar.suF.field_localId;
        fpVar.fKp.fKr = rmVar;
        fpVar.fKp.path = str;
        a.urY.m(fpVar);
    }

    public final boolean bBc() {
        return false;
    }

    public final void t(Context context, Intent intent) {
        if (!this.soD) {
            intent.putExtra("key_detail_info_id", this.fQF);
        }
        intent.putExtra("show_share", this.fQy);
        StringBuilder stringBuilder = new StringBuilder("file://");
        ap.yY();
        intent.putExtra("note_sdcard_recources_dir", stringBuilder.append(com.tencent.mm.u.c.xh()).toString());
        d.b(context, "wenote", ".ui.h5note.WNNoteFavWebViewUI", intent);
    }

    public final void Le(String str) {
        p pVar = (p) this.stD.get(str);
        Intent intent = new Intent();
        intent.putExtra("fav_open_from_wnnote", true);
        intent.putExtra("fav_note_xml", this.stQ);
        if (pVar != null) {
            intent.putExtra("key_detail_data_id", pVar.lKv);
        }
        intent.putExtra("key_detail_can_delete", false);
        intent.putExtra("key_detail_info_id", this.fQF);
        d.b(ab.getContext(), "favorite", ".ui.detail.FavoriteFileDetailUI", intent);
    }

    public final void Lg(String str) {
        Intent intent = new Intent();
        intent.putExtra("fav_open_from_wnnote", true);
        intent.putExtra("fav_note_xml", this.stQ);
        if (this.stD.get(str) != null) {
            intent.putExtra("key_detail_data_id", ((k) this.stD.get(str)).lKv);
        }
        intent.putExtra("key_detail_info_id", this.fQF);
        d.b(ab.getContext(), "favorite", ".ui.FavImgGalleryUI", intent);
    }

    public final void Lf(String str) {
        String str2 = "";
        n nVar = (n) this.stD.get(str);
        if (nVar == null) {
            g.bl(ab.getContext(), ab.getContext().getString(R.l.ejf));
            return;
        }
        Intent intent = new Intent();
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
        intent.putExtra("map_view_type", 2);
        intent.putExtra("kFavInfoLocalId", this.fQF);
        intent.putExtra("kFavCanDel", false);
        intent.putExtra("kFavCanRemark", false);
        d.b(ab.getContext(), "location", ".ui.RedirectUI", intent);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        if (kVar.getType() == 426) {
            b fpVar = new fp();
            fpVar.fKp.fGg = kVar;
            fpVar.fKp.type = 31;
            a.urY.m(fpVar);
            if (!bg.mA(fpVar.fKq.path) && i2 == -435) {
                w.e("MicroMsg.WNNoteFavProcess", "wenote conflict when commit");
            }
            ap.vd().b(426, this);
        }
    }

    public final void Lh(String str) {
        this.stQ = str;
    }
}
