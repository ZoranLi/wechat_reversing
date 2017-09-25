package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.xh;
import com.tencent.mm.protocal.c.xi;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.i;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class h extends k implements j {
    private final b gUA;
    private e gWW;
    public int hEc;
    private int kMZ;
    public byte[] kNa;
    private int kNb;
    private String kNc;
    private int kNd;

    public h(int i, int i2, int i3, String str, int i4, byte[] bArr) {
        a aVar = new a();
        aVar.hsm = new xh();
        aVar.hsn = new xi();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetdesigneremojilist";
        aVar.hsl = 821;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.hEc = i;
        this.kMZ = i2;
        this.kNb = i3;
        this.kNc = str;
        this.kNa = bArr;
        this.kNd = i4;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (((i2 == 0 && i3 == 0) || (i2 == 4 && (i3 == 2 || i3 == 3))) && ((this.kNa == null || this.kNa.length <= 0) && this.hEc != 3)) {
            com.tencent.mm.storage.a.j jVar = com.tencent.mm.plugin.emoji.model.h.amc().kLg;
            String str2 = this.kMZ;
            xi amn = amn();
            if (bg.mA(str2) || amn == null) {
                w.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerEmojiListResponseByUIN failed. designerID or response is null.");
            } else {
                try {
                    i iVar = new i();
                    iVar.field_designerIDAndType = str2 + com.tencent.mm.storage.a.j.a.DesignerEmojiList.value;
                    iVar.field_content = amn.toByteArray();
                    ContentValues pv = iVar.pv();
                    new String[1][0] = str2 + com.tencent.mm.storage.a.j.a.DesignerEmojiList.value;
                    if (jVar.gUz.replace("EmotionDesignerInfo", "designerIDAndType", pv) > 0) {
                        w.i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN success. designerID:%s", new Object[]{str2});
                    } else {
                        w.i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN failed. designerID:%s", new Object[]{str2});
                    }
                } catch (Throwable e) {
                    w.e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", new Object[]{bg.g(e)});
                }
            }
        }
        xi xiVar = (xi) ((b) pVar).hsk.hsr;
        if (xiVar.tDW != null) {
            this.kNa = n.a(xiVar.tDW);
        }
        this.gWW.a(i2, i3, str, this);
    }

    public final int getType() {
        return 821;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gWW = eVar2;
        xh xhVar = (xh) this.gUA.hsj.hsr;
        if (this.kNa != null) {
            xhVar.tDW = n.G(this.kNa);
        } else {
            xhVar.tDW = new avw();
        }
        w.d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", xhVar.tDW == null ? "Buf is NULL" : xhVar.tDW.toString());
        xhVar.tDV = this.kMZ;
        xhVar.tce = this.hEc;
        xhVar.tuw = this.kNb;
        xhVar.tDX = this.kNc;
        xhVar.tDY = this.kNd;
        return a(eVar, this.gUA, this);
    }

    public final xi amn() {
        return this.gUA == null ? null : (xi) this.gUA.hsk.hsr;
    }
}
