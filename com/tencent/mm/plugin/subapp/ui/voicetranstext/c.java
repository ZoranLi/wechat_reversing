package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.modelvoice.q;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bif;
import com.tencent.mm.protocal.c.big;
import com.tencent.mm.protocal.c.bih;
import com.tencent.mm.protocal.c.bjo;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import junit.framework.Assert;

public final class c extends k implements j {
    private final String TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    private b hse;
    private String mFileName;
    private e nXi;
    private String qVE;
    private bjo qVG;
    public bif qVM;

    public c(c cVar) {
        this.qVE = cVar.qVE;
        this.qVG = cVar.qVG;
        this.qVM = cVar.qVM;
        this.mFileName = cVar.mFileName;
        bnk();
    }

    public c(String str, bif com_tencent_mm_protocal_c_bif, int i, String str2) {
        Assert.assertTrue(str2 != null);
        this.qVE = str;
        this.qVM = com_tencent_mm_protocal_c_bif;
        this.qVG = d.ar(i, str2);
        this.mFileName = str2;
        bnk();
    }

    public final int getType() {
        return 547;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.nXi = eVar2;
        Object obj = (bg.mA(this.mFileName) || bg.mA(this.qVE) || this.qVM == null || this.qVG == null) ? null : 1;
        if (obj == null) {
            w.e("MicroMsg.NetSceneUploadVoiceForTrans", "doScene: Value not Valid, so, do nothing.");
            return -1;
        }
        big com_tencent_mm_protocal_c_big = (big) this.hse.hsj.hsr;
        com_tencent_mm_protocal_c_big.trv = this.qVE;
        com_tencent_mm_protocal_c_big.trw = this.qVG;
        com_tencent_mm_protocal_c_big.try = this.qVM;
        String str = this.mFileName;
        int i = this.qVM.tgK;
        int i2 = this.qVM.tgL;
        avw com_tencent_mm_protocal_c_avw = new avw();
        com.tencent.mm.modelvoice.b lV = q.lV(str);
        if (lV != null) {
            com_tencent_mm_protocal_c_avw = n.G(lV.bd(i, i2).buf);
        }
        com_tencent_mm_protocal_c_big.tsk = com_tencent_mm_protocal_c_avw;
        return a(eVar, this.hse, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        bnl();
        if (i2 == 0 && i3 == 0) {
            this.qVM = ((bih) this.hse.hsk.hsr).try;
        } else {
            w.d("MicroMsg.NetSceneUploadVoiceForTrans", "error upload: errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        this.nXi.a(i2, i3, str, this);
        if (bnl()) {
            boolean z;
            String str2 = "MicroMsg.NetSceneUploadVoiceForTrans";
            String str3 = "succeeed finish: %B";
            Object[] objArr = new Object[1];
            if (this.qVM != null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            w.i(str2, str3, objArr);
        }
    }

    private void bnk() {
        a aVar = new a();
        aVar.hsm = new big();
        aVar.hsn = new bih();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadvoicefortrans";
        aVar.hsl = 547;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.hse = aVar.BE();
    }

    public final boolean bnl() {
        if (this.qVM == null || this.qVM.tgL <= 0) {
            return true;
        }
        return false;
    }
}
