package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.af;
import com.tencent.mm.protocal.c.xj;
import com.tencent.mm.protocal.c.xk;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class i extends k implements j {
    private final b gUA;
    private e gWW;
    private String kNe;

    public i(String str) {
        a aVar = new a();
        aVar.hsm = new xj();
        aVar.hsn = new xk();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetdesignersimpleinfo";
        aVar.hsl = af.CTRL_BYTE;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.kNe = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.emoji.NetSceneGetDesignerSimpleInfo", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            com.tencent.mm.storage.a.j jVar = h.amc().kLg;
            String str2 = this.kNe;
            xk amo = amo();
            if (bg.mA(str2) || amo == null) {
                w.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID or response is null.");
            } else {
                try {
                    com.tencent.mm.storage.a.i iVar = new com.tencent.mm.storage.a.i();
                    iVar.field_designerIDAndType = str2 + com.tencent.mm.storage.a.j.a.DesignerSimpleInfo.value;
                    iVar.field_content = amo.toByteArray();
                    ContentValues pv = iVar.pv();
                    new String[1][0] = str2 + com.tencent.mm.storage.a.j.a.DesignerSimpleInfo.value;
                    if (jVar.gUz.replace("EmotionDesignerInfo", "designerIDAndType", pv) > 0) {
                        w.i("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID success. designerID:%s", new Object[]{str2});
                    } else {
                        w.i("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID:%s", new Object[]{str2});
                    }
                } catch (Throwable e) {
                    w.e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", new Object[]{bg.g(e)});
                }
            }
        }
        this.gWW.a(i2, i3, str, this);
    }

    public final xk amo() {
        return this.gUA == null ? null : (xk) this.gUA.hsk.hsr;
    }

    public final int getType() {
        return af.CTRL_BYTE;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gWW = eVar2;
        ((xj) this.gUA.hsj.hsr).tuq = this.kNe;
        return a(eVar, this.gUA, this);
    }
}
