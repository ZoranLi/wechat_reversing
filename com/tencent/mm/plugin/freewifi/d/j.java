package com.tencent.mm.plugin.freewifi.d;

import android.os.Build;
import com.tencent.mm.protocal.c.akw;
import com.tencent.mm.protocal.c.akx;
import com.tencent.mm.protocal.c.aky;
import com.tencent.mm.y.b.a;
import java.util.LinkedList;

public final class j extends c {
    protected final void awJ() {
        a aVar = new a();
        aVar.hsm = new akw();
        aVar.hsn = new akx();
        aVar.uri = "/cgi-bin/mmo2o-bin/manufacturerapinfo";
        aVar.hsl = 1707;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
    }

    public final int getType() {
        return 1707;
    }

    public j(LinkedList<aky> linkedList, int i) {
        awJ();
        akw com_tencent_mm_protocal_c_akw = (akw) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_akw.tOF = Build.BRAND;
        com_tencent_mm_protocal_c_akw.tOE = i;
        com_tencent_mm_protocal_c_akw.tOD = linkedList;
    }

    public final akx awW() {
        return (akx) this.gUA.hsk.hsr;
    }
}
