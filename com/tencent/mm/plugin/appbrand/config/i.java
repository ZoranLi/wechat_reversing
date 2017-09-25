package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.protocal.c.bqk;
import com.tencent.mm.protocal.c.fr;
import com.tencent.mm.protocal.c.fs;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.y.a;
import com.tencent.mm.y.b;
import java.util.List;

class i extends a<fs> {
    i(List<String> list) {
        com.tencent.mm.bd.a frVar = new fr();
        for (String str : list) {
            if (!bg.mA(str)) {
                bqk com_tencent_mm_protocal_c_bqk = new bqk();
                com_tencent_mm_protocal_c_bqk.uoB = str;
                com_tencent_mm_protocal_c_bqk.tkC = q.ou(str);
                frVar.tjf.add(com_tencent_mm_protocal_c_bqk);
            }
        }
        b.a aVar = new b.a();
        aVar.hsm = frVar;
        aVar.hsn = new fs();
        aVar.hsl = 1192;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync";
        this.gUA = aVar.BE();
    }
}
