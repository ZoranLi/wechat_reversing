package com.tencent.mm.plugin.favorite.b;

import android.database.Cursor;
import com.tencent.mm.plugin.favorite.c.d;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.amj;
import com.tencent.mm.protocal.c.amm;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rq;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.LinkedList;
import java.util.List;

public final class y {
    public static void a(j jVar, int i) {
        if (jVar == null) {
            w.w("MicroMsg.ModFavItemLogic", "modeTag, item info is null");
            return;
        }
        int i2;
        LinkedList linkedList = new LinkedList();
        amj com_tencent_mm_protocal_c_amj = new amj();
        com_tencent_mm_protocal_c_amj.tRc = 4;
        com_tencent_mm_protocal_c_amj.tRd = 0;
        linkedList.add(com_tencent_mm_protocal_c_amj);
        LinkedList linkedList2 = new LinkedList();
        amm com_tencent_mm_protocal_c_amm = new amm();
        com_tencent_mm_protocal_c_amm.muQ = "favitem.taglist";
        com_tencent_mm_protocal_c_amm.jOc = 1;
        StringBuffer stringBuffer = new StringBuffer();
        int size = jVar.field_tagProto.tzx.size();
        for (i2 = 0; i2 < size; i2++) {
            stringBuffer.append("<tag>").append(bg.PW((String) jVar.field_tagProto.tzx.get(i2))).append("</tag>");
        }
        com_tencent_mm_protocal_c_amm.oTN = stringBuffer.toString();
        w.v("MicroMsg.ModFavItemLogic", "do net scene mod tag, id=%d, tag=%s", new Object[]{Integer.valueOf(jVar.field_id), com_tencent_mm_protocal_c_amm.oTN});
        linkedList2.add(com_tencent_mm_protocal_c_amm);
        if (jVar.field_id > 0) {
            ap.vd().a(new af(jVar.field_id, linkedList, linkedList2), 0);
            g.oUh.i(11122, new Object[]{Integer.valueOf(jVar.field_id), Integer.valueOf(size), Integer.valueOf(h.asT().atr()), Integer.valueOf(i)});
            return;
        }
        c cVar;
        d asY = h.asY();
        long j = jVar.field_localId;
        h asW = h.asW();
        w.d("MicroMsg.FavModInfoStorage", "get mod info sql %s, {%d, %d}", new Object[]{"select * from FavEditInfo where localId =  ? and type =  ?", Long.valueOf(j), Integer.valueOf(0)});
        e eVar = asW.gUz;
        Cursor a = eVar.a("select * from FavEditInfo where localId =  ? and type =  ?", new String[]{String.valueOf(j), "0"}, 2);
        if (a == null) {
            cVar = null;
        } else {
            cVar = null;
            if (a.moveToFirst()) {
                cVar = new g();
                cVar.b(a);
            }
            a.close();
        }
        if (cVar == null) {
            cVar = new g();
            i2 = 1;
        } else {
            i2 = 0;
        }
        cVar.field_localId = j;
        rq rqVar = new rq();
        rqVar.lFI = linkedList;
        rqVar.tza = linkedList2;
        cVar.field_modItem = rqVar;
        cVar.field_time = bg.Nz();
        cVar.field_type = 0;
        cVar.field_scene = i;
        if (i2 != 0) {
            h.asW().b(cVar);
        } else {
            h.asW().c(cVar, new String[]{"localId"});
        }
        asY.run();
    }

    public static void a(long j, LinkedList<amj> linkedList, LinkedList<amm> linkedList2) {
        amj com_tencent_mm_protocal_c_amj = new amj();
        com_tencent_mm_protocal_c_amj.tRc = 4;
        com_tencent_mm_protocal_c_amj.tRd = 0;
        linkedList.add(com_tencent_mm_protocal_c_amj);
        b asV = h.asV();
        List<a> linkedList3 = new LinkedList();
        Cursor a = asV.gUz.a("select * from FavCdnInfo where favLocalId = " + j + " and type = 0" + " and status = 3", null, 2);
        boolean wa;
        if (a == null || !a.moveToFirst()) {
            if (a != null) {
                a.close();
            }
            w.v("MicroMsg.FavCdnStorage", "getUploadedInfos size:%d", new Object[]{Integer.valueOf(linkedList3.size())});
            for (a aVar : linkedList3) {
                wa = x.wa(aVar.field_dataId);
                if (!bg.mA(aVar.field_cdnUrl) || wa) {
                    w.e("MicroMsg.ModFavItemLogic", "setModAfterClientUpload cdnUrl:%s, isThumb:%b,  favLocalId:%d", new Object[]{aVar.field_cdnUrl, Boolean.valueOf(wa), Long.valueOf(j)});
                } else {
                    amm com_tencent_mm_protocal_c_amm = new amm();
                    com_tencent_mm_protocal_c_amm.muQ = "dataitem." + aVar.field_dataId + ".cdn_dataurl";
                    com_tencent_mm_protocal_c_amm.oTN = aVar.field_cdnUrl;
                    linkedList2.add(com_tencent_mm_protocal_c_amm);
                    com_tencent_mm_protocal_c_amm = new amm();
                    com_tencent_mm_protocal_c_amm.muQ = "dataitem." + aVar.field_dataId + ".cdn_datakey";
                    com_tencent_mm_protocal_c_amm.oTN = aVar.field_cdnKey;
                    linkedList2.add(com_tencent_mm_protocal_c_amm);
                    com_tencent_mm_protocal_c_amm = new amm();
                    com_tencent_mm_protocal_c_amm.muQ = "dataitem." + aVar.field_dataId;
                    com_tencent_mm_protocal_c_amm.tRi = "datastatus";
                    com_tencent_mm_protocal_c_amm.oTN = "0";
                    linkedList2.add(com_tencent_mm_protocal_c_amm);
                    j bT = h.ata().bT(aVar.field_favLocalId);
                    if (bT != null) {
                        if ((bT.field_type == 4 ? 1 : 0) != 0) {
                            rm a2 = x.a(bT, aVar.field_dataId);
                            amm com_tencent_mm_protocal_c_amm2 = new amm();
                            com_tencent_mm_protocal_c_amm2.muQ = "dataitem." + aVar.field_dataId + ".stream_videoid";
                            com_tencent_mm_protocal_c_amm2.oTN = a2.txS;
                            linkedList2.add(com_tencent_mm_protocal_c_amm2);
                        }
                    }
                }
            }
        }
        do {
            a aVar2 = new a();
            aVar2.b(a);
            linkedList3.add(aVar2);
        } while (a.moveToNext());
        if (a != null) {
            a.close();
        }
        w.v("MicroMsg.FavCdnStorage", "getUploadedInfos size:%d", new Object[]{Integer.valueOf(linkedList3.size())});
        for (a aVar3 : linkedList3) {
            wa = x.wa(aVar3.field_dataId);
            if (bg.mA(aVar3.field_cdnUrl)) {
            }
            w.e("MicroMsg.ModFavItemLogic", "setModAfterClientUpload cdnUrl:%s, isThumb:%b,  favLocalId:%d", new Object[]{aVar3.field_cdnUrl, Boolean.valueOf(wa), Long.valueOf(j)});
        }
    }
}
