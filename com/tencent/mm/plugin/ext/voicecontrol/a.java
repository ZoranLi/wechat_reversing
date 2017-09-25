package com.tencent.mm.plugin.ext.voicecontrol;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.da;
import com.tencent.mm.protocal.c.db;
import com.tencent.mm.protocal.c.dc;
import com.tencent.mm.protocal.c.dg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public final class a extends k implements j {
    public String appId;
    public int fJA = 1;
    b gUA;
    private e gUD;
    public int hrs;
    public int hrt;
    public int lrE;
    public com.tencent.mm.bd.b lrF;
    public String lrG;
    public dg lrH;
    public da lrI;
    int lrJ = Downloads.MIN_RETYR_AFTER;
    long lrK = 0;
    public int vb;

    public a(int i, String str, int i2, String str2, dg dgVar) {
        boolean z = true;
        this.appId = str;
        this.lrE = i;
        this.vb = 1;
        this.hrs = i2;
        this.lrH = dgVar;
        this.lrI = null;
        this.lrG = str2;
        String str3 = "MicroMsg.ext.NetSceneAppVoiceControl";
        String str4 = "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, totalLen=%s, controlType=%s, %s, %s";
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(1);
        objArr[1] = str;
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(1);
        if (dgVar == null) {
            z = false;
        }
        objArr[5] = Boolean.valueOf(z);
        objArr[6] = Boolean.valueOf(false);
        w.i(str3, str4, objArr);
    }

    public a(int i, String str, da daVar, long j) {
        this.appId = str;
        this.lrE = i;
        this.vb = 1;
        this.lrH = null;
        this.lrI = daVar;
        this.lrK = j;
        w.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, controlType=%s, %s, %s", Integer.valueOf(2), str, Integer.valueOf(i), Integer.valueOf(1), Boolean.valueOf(false), Boolean.valueOf(true));
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0 && pVar != null) {
            w.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] onGYNetEnd netId %d , errType %d, errCode %d, %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        } else {
            w.e("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] onGYNetEnd netId %d , errType %d, errCode %d, %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        }
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        } else {
            w.e("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] callback null");
        }
    }

    public final int getType() {
        return 985;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsl = 985;
        aVar.uri = "/cgi-bin/micromsg-bin/appvoicecontrol";
        aVar.hsm = new db();
        aVar.hsn = new dc();
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        db dbVar = (db) this.gUA.hsj.hsr;
        dbVar.tce = this.fJA;
        dbVar.mtb = this.appId;
        dbVar.tgv = this.lrE;
        dbVar.tgw = this.vb;
        dbVar.tgx = this.lrH;
        dbVar.tgy = this.lrI;
        return a(eVar, this.gUA, this);
    }
}
