package com.tencent.mm.plugin.music.a.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ks;
import com.tencent.mm.protocal.c.kt;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a extends k implements j {
    private e gUD;
    private b hKp;
    public ks nTL;

    public a(int i, com.tencent.mm.am.a aVar) {
        com.tencent.mm.y.b.a aVar2 = new com.tencent.mm.y.b.a();
        aVar2.hsl = 940;
        aVar2.uri = "/cgi-bin/micromsg-bin/checkmusic";
        aVar2.hsm = new ks();
        aVar2.hsn = new kt();
        this.hKp = aVar2.BE();
        this.nTL = (ks) this.hKp.hsj.hsr;
        this.nTL.tdM = i;
        this.nTL.mtb = aVar.field_appId;
        this.nTL.tqZ = aVar.field_songAlbumUrl;
        this.nTL.tra = aVar.field_songHAlbumUrl;
        this.nTL.trc = aVar.field_songWifiUrl;
        this.nTL.trd = aVar.field_songWapLinkUrl;
        this.nTL.trb = aVar.field_songWebUrl;
        this.nTL.fDC = aVar.field_songName;
        this.nTL.tqY = aVar.field_musicId;
    }

    public final int getType() {
        return 940;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.hKp, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.Music.NetSceneCheckMusic", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gUD.a(i2, i3, str, this);
    }
}
