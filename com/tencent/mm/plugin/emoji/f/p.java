package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.network.j;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.protocal.c.aac;
import com.tencent.mm.protocal.c.aad;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.pn;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class p extends k implements j {
    private final b gUA;
    private e gUD;
    private int hPi;
    public byte[] kNk;
    private int kNv;

    public p(int i, byte[] bArr) {
        this(i, bArr, (byte) 0);
    }

    private p(int i, byte[] bArr, byte b) {
        this.kNk = null;
        a aVar = new a();
        aVar.hsm = new aac();
        aVar.hsn = new aad();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetpersonaldesigner";
        aVar.hsl = 720;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.kNv = i;
        this.kNk = bArr;
        this.hPi = 0;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.p pVar, byte[] bArr) {
        w.i("MicroMsg.emoji.NetSceneGetPersonalDesigner", "NetSceneGetPersonalDesigner errType:%d,errcode:%d,errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        aad com_tencent_mm_protocal_c_aad = (aad) ((b) pVar).hsk.hsr;
        if (com_tencent_mm_protocal_c_aad.tfG != null) {
            this.kNk = n.a(com_tencent_mm_protocal_c_aad.tfG);
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 720;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        aac com_tencent_mm_protocal_c_aac = (aac) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_aac.tDV = this.kNv;
        if (this.kNk != null) {
            com_tencent_mm_protocal_c_aac.tfG = n.G(this.kNk);
        } else {
            com_tencent_mm_protocal_c_aac.tfG = new avw();
        }
        com_tencent_mm_protocal_c_aac.tdM = this.hPi;
        w.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", com_tencent_mm_protocal_c_aac.tfG == null ? "Buf is NULL" : com_tencent_mm_protocal_c_aac.tfG.toString());
        return a(eVar, this.gUA, this);
    }

    public final aad amv() {
        return this.gUA == null ? null : (aad) this.gUA.hsk.hsr;
    }

    public static com.tencent.mm.plugin.emoji.model.e a(aad com_tencent_mm_protocal_c_aad) {
        w.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", "getEmotionListModel");
        if (com_tencent_mm_protocal_c_aad == null) {
            return null;
        }
        com.tencent.mm.plugin.emoji.model.e eVar = new com.tencent.mm.plugin.emoji.model.e();
        if (!(com_tencent_mm_protocal_c_aad == null || com_tencent_mm_protocal_c_aad.tEp == null)) {
            eVar.kLL = com_tencent_mm_protocal_c_aad.tEp.size();
            List arrayList = new ArrayList();
            Iterator it = com_tencent_mm_protocal_c_aad.tEp.iterator();
            while (it.hasNext()) {
                pn pnVar = (pn) it.next();
                if (pnVar.tgW != null) {
                    arrayList.add(new f(pnVar));
                }
            }
            eVar.kLM = arrayList;
        }
        return eVar;
    }

    protected final int a(com.tencent.mm.network.p pVar) {
        return k.b.hsT;
    }

    protected final int ub() {
        return 100;
    }
}
