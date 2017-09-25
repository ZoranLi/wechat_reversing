package com.tencent.mm.plugin.qmessage.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.yt;
import com.tencent.mm.protocal.c.yu;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class c extends k implements j {
    public final b hWk;
    private e oyA;

    public c() {
        a aVar = new a();
        aVar.hsm = new yt();
        aVar.hsn = new yu();
        aVar.uri = "/cgi-bin/micromsg-bin/getimunreadmsgcount";
        aVar.hsl = 630;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.hWk = aVar.BE();
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGetImUnreadMsgCount", "end get im unread msg count, errType: %d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.oyA.a(i2, i3, str, this);
    }

    public final int getType() {
        return 630;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.d("MicroMsg.NetSceneGetImUnreadMsgCount", "get im unread msg count");
        this.oyA = eVar2;
        return a(eVar, this.hWk, this);
    }
}
