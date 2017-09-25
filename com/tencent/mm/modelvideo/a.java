package com.tencent.mm.modelvideo;

import com.tencent.mm.plugin.a.b;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class a {
    public static void a(r rVar, int i) {
        if (rVar == null) {
            w.w("MicroMsg.AtomStatUtil", "report moov location, but video info is null.");
            return;
        }
        int i2;
        long NA = bg.NA();
        o.KV();
        String lv = s.lv(rVar.getFileName());
        long j = 0;
        long j2 = 0;
        if (c.mD(lv)) {
            i2 = 1;
            b bVar = new b();
            j = bVar.mC(lv);
            j2 = bVar.ilH != null ? bVar.ilH.ilD : 0;
        } else {
            w.i("MicroMsg.AtomStatUtil", "download video finish, but it is not mp4 file.");
            i2 = 0;
        }
        long j3 = rVar.fTQ;
        lv = r.lr(rVar.Lh());
        long j4 = (long) rVar.hrs;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j3).append(";").append(lv).append(";");
        stringBuilder.append(j4).append(";");
        stringBuilder.append(i2).append(";").append(j).append(";");
        stringBuilder.append(j2).append(";").append(i);
        w.d("MicroMsg.AtomStatUtil", "report moov content : " + stringBuilder.toString() + " cost time: " + bg.aB(NA));
        g.oUh.i(11098, Integer.valueOf(8000), r0);
    }
}
