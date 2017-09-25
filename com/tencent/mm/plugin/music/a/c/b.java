package com.tencent.mm.plugin.music.a.c;

import com.tencent.mm.am.a;
import com.tencent.mm.am.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.aao;
import com.tencent.mm.protocal.c.aap;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class b extends k implements j {
    public a fPd;
    private e gUD;
    private com.tencent.mm.y.b hKp;
    public aap nTM;
    public boolean nTN;

    public b(a aVar, boolean z) {
        int i;
        this.fPd = aVar;
        this.nTN = z;
        com.tencent.mm.y.b.a aVar2 = new com.tencent.mm.y.b.a();
        aVar2.hsm = new aao();
        aVar2.hsn = new aap();
        aVar2.uri = "/cgi-bin/micromsg-bin/getqqmusiclyric";
        aVar2.hsl = 520;
        this.hKp = aVar2.BE();
        aao com_tencent_mm_protocal_c_aao = (aao) this.hKp.hsj.hsr;
        com_tencent_mm_protocal_c_aao.tGt = aVar.field_songId;
        if (aVar.field_songWebUrl != null) {
            com_tencent_mm_protocal_c_aao.tGu = n.G(aVar.field_songWebUrl.getBytes());
        }
        if (c.HS()) {
            i = 0;
        } else {
            i = 1;
        }
        com_tencent_mm_protocal_c_aao.tGv = i;
        if (c.HR()) {
            i = 1;
        } else {
            i = 0;
        }
        com_tencent_mm_protocal_c_aao.tGw = i;
        w.i("MicroMsg.Music.NetSceneGetQQMusicLyric", "songId=%d, url=%s IsOutsideGFW=%d ShakeMusicGlobalSwitch=%d", new Object[]{Integer.valueOf(aVar.field_songId), aVar.field_songWebUrl, Integer.valueOf(com_tencent_mm_protocal_c_aao.tGv), Integer.valueOf(com_tencent_mm_protocal_c_aao.tGw)});
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.Music.NetSceneGetQQMusicLyric", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.nTM = (aap) this.hKp.hsk.hsr;
            this.gUD.a(i2, i3, str, this);
            return;
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 520;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.hKp, this);
    }
}
