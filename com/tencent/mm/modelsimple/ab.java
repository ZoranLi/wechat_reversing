package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.axo;
import com.tencent.mm.protocal.z.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.wcdb.FileUtils;
import junit.framework.Assert;

public final class ab extends k implements j {
    private e gUD;
    private final p htt;

    public ab(int i, String str) {
        this(i, str, "");
    }

    public ab(int i, String str, String str2) {
        this.htt = new e();
        a aVar = (a) this.htt.BG();
        aVar.tah.jNj = m.xL();
        axo com_tencent_mm_protocal_c_axo = aVar.tah;
        StringBuilder stringBuilder = new StringBuilder();
        if (i == 0) {
            i = 64;
        }
        stringBuilder = stringBuilder.append(i).append(";");
        if (str == null) {
            str = "";
        }
        com_tencent_mm_protocal_c_axo.opI = stringBuilder.append(str).toString();
        w.d("MicroMsg.NetSceneSendCard", "content:" + aVar.tah.opI);
        Assert.assertTrue("empty sendcard", true);
        aVar.tah.tSE = 64;
        if (str2 != null && str2.length() > 0) {
            aVar.tah.uai = str2;
        }
    }

    public ab(String str) {
        this.htt = new e();
        a aVar = (a) this.htt.BG();
        aVar.tah.jNj = m.xL();
        aVar.tah.opI = str;
        w.d("MicroMsg.NetSceneSendCard", "content:" + str);
        axo com_tencent_mm_protocal_c_axo = aVar.tah;
        ap.yY();
        com_tencent_mm_protocal_c_axo.tGA = bg.f((Integer) c.vr().get(66561, null));
        Assert.assertTrue("empty sendcard", true);
        aVar.tah.tSE = FileUtils.S_IWUSR;
    }

    public ab(String str, boolean z, boolean z2) {
        int i;
        this.htt = new e();
        a aVar = (a) this.htt.BG();
        aVar.tah.jNj = m.xL();
        aVar.tah.opI = str;
        w.d("MicroMsg.NetSceneSendCard", "content:" + str);
        axo com_tencent_mm_protocal_c_axo = aVar.tah;
        ap.yY();
        com_tencent_mm_protocal_c_axo.tGA = bg.f((Integer) c.vr().get(66561, null));
        int i2 = ((z ? 1 : 0) | 0) | 0;
        if (z2) {
            i = 4;
        } else {
            i = 0;
        }
        i = (i | i2) | 8;
        Assert.assertTrue("empty sendcard", true);
        aVar.tah.tSE = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.htt, this);
    }

    public final int getType() {
        return 26;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.gUD.a(i2, i3, pVar.zg().sZD, this);
    }
}
