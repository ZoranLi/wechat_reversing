package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.protocal.c.bqh;
import com.tencent.mm.protocal.c.bqj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.y.a;
import com.tencent.mm.y.b;

final class j extends a<bqj> {
    final b gUA;

    j(String str, String str2) {
        com.tencent.mm.bd.b bVar;
        b.a aVar = new b.a();
        com.tencent.mm.bd.a com_tencent_mm_protocal_c_bqh = new bqh();
        com_tencent_mm_protocal_c_bqh.uoB = str;
        if (bg.mA(str)) {
            WxaAttributes e = c.PR().e(str2, "syncVersion");
            bVar = new com.tencent.mm.bd.b((e == null ? "" : bg.mz(e.field_syncVersion)).getBytes());
        } else {
            bVar = q.ou(str);
        }
        com_tencent_mm_protocal_c_bqh.tkC = bVar;
        com_tencent_mm_protocal_c_bqh.uoC = str2;
        aVar.hsm = com_tencent_mm_protocal_c_bqh;
        aVar.hsn = new bqj();
        aVar.hsl = 1151;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaattr/wxaattrsync";
        b BE = aVar.BE();
        this.gUA = BE;
        this.gUA = BE;
    }
}
