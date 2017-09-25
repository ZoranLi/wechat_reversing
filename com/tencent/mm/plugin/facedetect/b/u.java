package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.va;
import com.tencent.mm.protocal.c.vb;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;

public final class u extends k implements j, b {
    private b gUA;
    private e gUD;
    private long lvl = -1;
    private byte[] lvm = null;

    public final long ark() {
        return this.lvl;
    }

    public final byte[] arl() {
        return this.lvm;
    }

    public u(int i) {
        a aVar = new a();
        aVar.hsm = new va();
        aVar.hsn = new vb();
        aVar.uri = "/cgi-bin/micromsg-bin/getbioconfig";
        aVar.hsl = TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        va vaVar = (va) this.gUA.hsj.hsr;
        vaVar.jOc = 1;
        vaVar.tdM = i;
    }

    public final int getType() {
        return TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        vb vbVar = (vb) ((b) pVar).hsk.hsr;
        if (i2 == 0 && i3 == 0) {
            this.lvl = vbVar.tCF;
            this.lvm = vbVar.tCG.sYA;
            String str2 = "MicroMsg.NetSceneGetBioConfig";
            String str3 = "hy: get bio config: bioId: %s, bioConfigSize: %d";
            Object[] objArr = new Object[2];
            objArr[0] = Long.valueOf(this.lvl);
            objArr[1] = Integer.valueOf(this.lvm == null ? 0 : this.lvm.length);
            w.i(str2, str3, objArr);
        }
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
