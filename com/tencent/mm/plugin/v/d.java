package com.tencent.mm.plugin.v;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.protocal.c.axm;
import com.tencent.mm.protocal.c.axn;
import com.tencent.mm.protocal.c.cu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.t.f;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class d extends k implements j {
    private String aeskey;
    private String fOx;
    private String gKJ;
    private b gUA;
    private e gUD;
    private int nOx;

    public d(String str, String str2, int i, String str3) {
        this.fOx = str;
        this.aeskey = str2;
        this.nOx = i;
        this.gKJ = str3;
        a aVar = new a();
        aVar.hsm = new axm();
        aVar.hsn = new axn();
        aVar.uri = "/cgi-bin/micromsg-bin/sendappmsg";
        aVar.hsl = 222;
        aVar.hso = MMGIFException.D_GIF_ERR_WRONG_RECORD;
        aVar.hsp = 1000000107;
        this.gUA = aVar.BE();
        w.i("MicroMsg.MsgSynchronizeSendAppMsgNetScene", "MsgSynchronizeSendAppMsgNetScene fileId[%s], fileLen[%d], selfName[%s], stack[%s]", new Object[]{str, Integer.valueOf(i), str3, bg.bJZ()});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        f.a aVar = new f.a();
        aVar.title = "PCSYNC";
        aVar.description = "ANDROID_PCSYNC";
        aVar.type = 35;
        aVar.url = this.fOx;
        aVar.hhE = this.aeskey;
        aVar.hhq = this.nOx;
        aVar.hhF = this.aeskey;
        aVar.showType = 0;
        axm com_tencent_mm_protocal_c_axm = (axm) this.gUA.hsj.hsr;
        cu cuVar = new cu();
        cuVar.mvV = this.gKJ;
        cuVar.tfT = aVar.sdkVer;
        cuVar.jOc = 35;
        cuVar.mvU = this.gKJ;
        cuVar.opI = f.a.a(aVar, null, null, 0, 0);
        cuVar.ogM = (int) bg.Ny();
        com_tencent_mm_protocal_c_axm.uae = cuVar;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.MsgSynchronizeSendAppMsgNetScene", "msgSynchronize sendAppMsg onGYNetEnd. [%d,%d,%s]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 222;
    }

    protected final int a(p pVar) {
        return k.b.hsT;
    }
}
