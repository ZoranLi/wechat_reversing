package com.tencent.mm.plugin.appbrand.b;

import com.tencent.mm.protocal.c.ads;
import com.tencent.mm.protocal.c.adt;
import com.tencent.mm.y.a;
import com.tencent.mm.y.b;

class l extends a<adt> {
    l(int i, int i2, int i3, int i4) {
        b.a aVar = new b.a();
        com.tencent.mm.bd.a com_tencent_mm_protocal_c_ads = new ads();
        com_tencent_mm_protocal_c_ads.fOl = i;
        com_tencent_mm_protocal_c_ads.condition = i2;
        com_tencent_mm_protocal_c_ads.tJk = i3;
        com_tencent_mm_protocal_c_ads.tJl = i4;
        aVar.hsm = com_tencent_mm_protocal_c_ads;
        aVar.hsn = new adt();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxausagerecord";
        aVar.hsl = 1148;
        this.gUA = aVar.BE();
    }
}
