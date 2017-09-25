package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.card.b.t;
import com.tencent.mm.protocal.c.iw;
import com.tencent.mm.protocal.c.ix;
import com.tencent.mm.protocal.c.iy;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;

public final class v extends k implements j {
    private final b gUA;
    private e gUD;
    public String kfO;
    public ArrayList<iw> kfP;

    public v(String str, float f, float f2, String str2) {
        this.kfO = str;
        a aVar = new a();
        aVar.hsm = new ix();
        aVar.hsn = new iy();
        aVar.uri = "/cgi-bin/micromsg-bin/cardshoplbs";
        aVar.hsl = 563;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ix ixVar = (ix) this.gUA.hsj.hsr;
        ixVar.kdE = str;
        ixVar.fPF = f;
        ixVar.fOb = f2;
        ixVar.fVl = str2;
        w.d("MicroMsg.NetSceneCardShopLBS", "<init>, cardId = %s, longtitude = %f, latitude = %f, card_id = %s", new Object[]{str, Float.valueOf(f), Float.valueOf(f2), str2});
    }

    public final int getType() {
        return 563;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (bg.mA(((ix) this.gUA.hsj.hsr).kdE)) {
            w.e("MicroMsg.NetSceneCardShopLBS", "doScene fail, cardId is null");
            return -1;
        }
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            Object obj = ((iy) this.gUA.hsk.hsr).kfG;
            if (TextUtils.isEmpty(obj)) {
                w.e("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd fail, json_ret is empty");
            }
            this.kfP = t.tn(obj);
            if (this.kfP != null) {
                w.d("MicroMsg.NetSceneCardShopLBS", "onGYNetEnd, respList size = %d", new Object[]{Integer.valueOf(this.kfP.size())});
            }
        }
        this.gUD.a(i2, i3, str, this);
    }
}
