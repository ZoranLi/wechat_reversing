package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.sn;
import com.tencent.mm.protocal.c.so;
import com.tencent.mm.protocal.c.sp;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import java.util.LinkedList;

public final class e extends c {
    protected final void awJ() {
        a aVar = new a();
        aVar.hsm = new so();
        aVar.hsn = new sp();
        aVar.uri = "/cgi-bin/mmo2o-bin/freewifireport";
        aVar.hsl = 1781;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
    }

    public final int getType() {
        return 1781;
    }

    public e(LinkedList<sn> linkedList) {
        awJ();
        if (linkedList != null && linkedList.size() > 0) {
            ((so) this.gUA.hsj.hsr).tAz = linkedList;
        }
    }

    protected final void b(int i, int i2, int i3, String str) {
        w.i("MicroMsg.FreeWifi.NetSceneFreeWifiReport", "doBeforeCallback. netId=%d, errType=%d, errCode=%d, errMsg=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (m.bZ(i2, i3)) {
            j.awG().awp().post(new Runnable(this) {
                final /* synthetic */ e lTW;

                {
                    this.lTW = r1;
                }

                public final void run() {
                    sp spVar = (sp) this.lTW.gUA.hsk.hsr;
                    if (spVar != null) {
                        LinkedList linkedList = spVar.tAz;
                    }
                }
            });
        }
    }

    public final LinkedList<sn> awS() {
        sp spVar = (sp) this.gUA.hsk.hsr;
        if (spVar == null) {
            return null;
        }
        return spVar.tAz;
    }
}
