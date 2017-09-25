package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ayq;
import com.tencent.mm.protocal.c.ayr;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;

public final class aj extends w {
    public int cmdId;
    private String sEb;

    public aj(String str, int i, String str2) {
        a aVar = new a();
        aVar.hsm = new ayq();
        aVar.hsn = new ayr();
        aVar.uri = "/cgi-bin/micromsg-bin/setappsetting";
        this.ldw = aVar.BE();
        ayq com_tencent_mm_protocal_c_ayq = (ayq) this.ldw.hsj.hsr;
        com_tencent_mm_protocal_c_ayq.msh = str;
        com_tencent_mm_protocal_c_ayq.uaz = i;
        com_tencent_mm_protocal_c_ayq.uaA = str2;
        this.cmdId = i;
        this.sEb = str2;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneSetAppSetting", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i2 == 0) {
            ayr com_tencent_mm_protocal_c_ayr = (ayr) this.ldw.hsk.hsr;
            if (com_tencent_mm_protocal_c_ayr != null) {
                i aRt = com.tencent.mm.plugin.w.a.a.a.aRv().aRt();
                f aJ = g.aJ(com_tencent_mm_protocal_c_ayr.msh, false);
                if (aJ != null) {
                    aJ.field_authFlag = com_tencent_mm_protocal_c_ayr.tgt;
                    w.d("MicroMsg.NetSceneSetAppSetting", "onGYNetEnd, update ret = " + aRt.a(aJ, new String[0]) + ", appId = " + com_tencent_mm_protocal_c_ayr.msh);
                }
            }
        }
    }

    public final byte[] aBv() {
        try {
            return ((b) this.ldw.BG()).zh();
        } catch (Exception e) {
            w.e("MicroMsg.NetSceneSetAppSetting", "toProtBuf failed: " + e.getMessage());
            return null;
        }
    }

    public final void ar(byte[] bArr) {
        if (bArr == null) {
            w.e("MicroMsg.NetSceneSetAppSetting", "buf is null");
            return;
        }
        try {
            this.ldw.hsk.y(bArr);
        } catch (Throwable e) {
            w.e("MicroMsg.NetSceneSetAppSetting", "parse error: " + e.getMessage());
            w.printErrStackTrace("MicroMsg.NetSceneSetAppSetting", e, "", new Object[0]);
        }
    }

    public final int getType() {
        return 2;
    }
}
