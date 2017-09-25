package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.jv;
import com.tencent.mm.protocal.c.jw;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a extends k implements j {
    private b gUA;
    private e gUD;

    public a(String str, String str2) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new jv();
        aVar.hsn = new jw();
        aVar.uri = "/cgi-bin/mmoc-bin/adplayinfo/channelpkginfo";
        aVar.hsl = 1210;
        this.gUA = aVar.BE();
        jv jvVar = (jv) this.gUA.hsj.hsr;
        jvVar.tpT = str2;
        jvVar.tpQ = str;
        jvVar.tpU = bg.bKe();
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return this.gUA.hsl;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
