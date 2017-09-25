package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.protocal.c.awe;
import com.tencent.mm.protocal.c.ck;
import com.tencent.mm.protocal.c.hm;
import com.tencent.mm.protocal.c.hn;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import java.util.LinkedList;

public final class k extends c {
    protected final void awJ() {
        a aVar = new a();
        aVar.hsm = new hm();
        aVar.hsn = new hn();
        aVar.uri = "/cgi-bin/mmo2o-bin/bizwificonnect";
        aVar.hsl = 1705;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
    }

    public final int getType() {
        return 1705;
    }

    public k(String str, awe com_tencent_mm_protocal_c_awe, int i, String str2) {
        awJ();
        if (!(8 == i && 9 == i)) {
            w.e("MicroMsg.FreeWifi.NetSceneScanAndReportNearFieldFreeWifi", "invalid channel, channel is :%d", new Object[]{Integer.valueOf(i)});
        }
        hm hmVar = (hm) this.gUA.hsj.hsr;
        hmVar.tkB = str;
        hmVar.tlG = com_tencent_mm_protocal_c_awe;
        hmVar.tcg = i;
        hmVar.tch = str2;
    }

    public final String awX() {
        LinkedList linkedList = ((hn) this.gUA.hsk.hsr).tlH;
        if (linkedList == null || linkedList.size() != 1) {
            return null;
        }
        return ((ck) linkedList.get(0)).tfC;
    }
}
