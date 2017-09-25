package com.tencent.mm.plugin.favorite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.fp;
import com.tencent.mm.plugin.favorite.b.af;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.favorite.c.a.AnonymousClass1;
import com.tencent.mm.plugin.favorite.ui.FavTipsUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.amj;
import com.tencent.mm.protocal.c.amm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.LinkedList;

public final class a extends c<cb> {
    public a() {
        this.usg = cb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = -2;
        cb cbVar = (cb) bVar;
        if (-2 == cbVar.fFA.type) {
            long j = bg.getLong(cbVar.fFA.fFs, -1);
            if (0 >= j) {
                w.w("MicroMsg.AddFavoriteItemListener", "error fav info local id");
            } else {
                j bT = h.ata().bT(j);
                if (bg.mA(bT.field_favProto.iBi)) {
                    g.oUh.i(10873, new Object[]{Integer.valueOf(6)});
                } else {
                    g.oUh.i(10874, new Object[]{Integer.valueOf(6)});
                }
                bT.field_favProto.OA(cbVar.fFA.desc);
                h.ata().a(bT, "rowid");
                String str = cbVar.fFA.desc;
                if (bT == null) {
                    w.w("MicroMsg.ModFavItemLogic", "modRemark, item info is null");
                } else if (bT.field_id <= 0) {
                    w.w("MicroMsg.ModFavItemLogic", "modRemark favid:%d", new Object[]{Integer.valueOf(bT.field_id)});
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    LinkedList linkedList = new LinkedList();
                    amj com_tencent_mm_protocal_c_amj = new amj();
                    com_tencent_mm_protocal_c_amj.tRc = 4;
                    com_tencent_mm_protocal_c_amj.tRd = 0;
                    linkedList.add(com_tencent_mm_protocal_c_amj);
                    LinkedList linkedList2 = new LinkedList();
                    amm com_tencent_mm_protocal_c_amm = new amm();
                    com_tencent_mm_protocal_c_amm.muQ = "favitem.remark";
                    com_tencent_mm_protocal_c_amm.oTN = str;
                    linkedList2.add(com_tencent_mm_protocal_c_amm);
                    amm com_tencent_mm_protocal_c_amm2 = new amm();
                    com_tencent_mm_protocal_c_amm2.muQ = "favitem.remark";
                    com_tencent_mm_protocal_c_amm2.tRi = "time";
                    com_tencent_mm_protocal_c_amm2.oTN = String.valueOf(currentTimeMillis);
                    linkedList2.add(com_tencent_mm_protocal_c_amm2);
                    ap.vd().a(new af(bT.field_id, linkedList, linkedList2), 0);
                }
            }
        } else {
            cb.b bVar2 = cbVar.fFB;
            if (cbVar == null || cbVar.fFA == null) {
                i = -1;
            } else {
                int i2;
                if (cbVar.fFA.fFC == null) {
                    w.w("MicroMsg.AddFavService", "handleEvent error, event is null");
                    if (cbVar.fFA.fFG == 0) {
                        cbVar.fFA.fFG = R.l.eib;
                    }
                    i2 = cbVar.fFA.fFG;
                } else {
                    i2 = 0;
                }
                if (cbVar.fFA.activity == null && cbVar.fFA.ov == null) {
                    w.i("MicroMsg.AddFavService", "handleEvent context = null && frament = null");
                }
                if (cbVar.fFA.fFG > 0) {
                    i = cbVar.fFA.fFG;
                } else if (x.mv(cbVar.fFA.type)) {
                    b fpVar = new fp();
                    fpVar.fKp.type = 36;
                    com.tencent.mm.sdk.b.a.urY.m(fpVar);
                    if (fpVar.fKq.ret != 1) {
                        i = cbVar.fFA.fFG;
                        cbVar.fFA.fFI = new AnonymousClass1(cbVar);
                    }
                } else {
                    i = i2;
                }
                ap.yY();
                if (((Integer) com.tencent.mm.u.c.vr().get(225281, Integer.valueOf(0))).intValue() != 1) {
                    w.d("MicroMsg.AddFavService", "try show intro ui");
                    Context context = cbVar.fFA.activity;
                    if (context instanceof Activity) {
                        Intent intent = new Intent(context, FavTipsUI.class);
                        if (!(context instanceof Activity)) {
                            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        }
                        context.startActivity(intent);
                    }
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(225281, Integer.valueOf(1));
                }
                com.tencent.mm.pluginsdk.model.c.a(cbVar.fFA.type, i, cbVar.fFA.fFH, cbVar.fFA.activity, cbVar.fFA.ov, cbVar.fFA.fFJ, cbVar.fFA.fFI, null);
                w.i("MicroMsg.AddFavService", "err Type = %d", new Object[]{Integer.valueOf(i)});
                if (i == -9 || i == 0) {
                    i = com.tencent.mm.plugin.favorite.c.a.a(cbVar);
                }
            }
            bVar2.ret = i;
        }
        return false;
    }
}
