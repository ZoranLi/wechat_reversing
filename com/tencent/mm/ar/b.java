package com.tencent.mm.ar;

import com.tencent.mm.e.b.af;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bhd;
import com.tencent.mm.protocal.c.bhe;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.File;

public final class b extends k implements j {
    private String clientId;
    private String fOa;
    private com.tencent.mm.y.b gUA;
    private e gUD;
    public String hPa;
    private int hrs;
    private int hrt;
    private String username;

    public b(String str, String str2) {
        this(str);
        this.fOa = str2;
    }

    private b(String str) {
        this.username = str;
        this.hrs = 0;
        this.hrt = 0;
        StringBuilder stringBuilder = new StringBuilder();
        h.vG();
        this.clientId = stringBuilder.append(a.uH()).append(System.currentTimeMillis()).toString();
    }

    public final int getType() {
        return 575;
    }

    protected final int a(p pVar) {
        if (this.fOa == null || this.fOa.length() == 0) {
            return b.hsU;
        }
        return b.hsT;
    }

    protected final int ub() {
        return 100;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        if (this.fOa == null || this.fOa.length() == 0) {
            w.e("MicroMsg.NetSceneUploadCardImg", "imgPath is null or length = 0");
            return -1;
        } else if (com.tencent.mm.a.e.aO(this.fOa)) {
            if (this.hrs == 0) {
                this.hrs = (int) new File(this.fOa).length();
            }
            com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
            aVar.hsm = new bhd();
            aVar.hsn = new bhe();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadcardimg";
            aVar.hsl = 575;
            aVar.hso = 0;
            aVar.hsp = 0;
            this.gUA = aVar.BE();
            byte[] c = com.tencent.mm.a.e.c(this.fOa, this.hrt, Math.min(this.hrs - this.hrt, WXMediaMessage.THUMB_LENGTH_LIMIT));
            if (c == null) {
                w.e("MicroMsg.NetSceneUploadCardImg", "readFromFile error");
                return -1;
            }
            w.i("MicroMsg.NetSceneUploadCardImg", "doScene uploadLen:%d, total: %d", Integer.valueOf(c.length), Integer.valueOf(this.hrs));
            bhd com_tencent_mm_protocal_c_bhd = (bhd) this.gUA.hsj.hsr;
            com_tencent_mm_protocal_c_bhd.ttD = this.username;
            com_tencent_mm_protocal_c_bhd.tgJ = this.hrs;
            com_tencent_mm_protocal_c_bhd.tgK = this.hrt;
            com_tencent_mm_protocal_c_bhd.tsk = new avw().bb(c);
            com_tencent_mm_protocal_c_bhd.tgL = com_tencent_mm_protocal_c_bhd.tsk.tZn;
            com_tencent_mm_protocal_c_bhd.teW = this.clientId;
            return a(eVar, this.gUA, this);
        } else {
            w.e("MicroMsg.NetSceneUploadCardImg", "The img does not exist, imgPath = " + this.fOa);
            return -1;
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneUploadCardImg", "onGYNetEnd:%s, %s", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            bhe com_tencent_mm_protocal_c_bhe = (bhe) ((com.tencent.mm.y.b) pVar).hsk.hsr;
            this.hPa = com_tencent_mm_protocal_c_bhe.tQV;
            this.hrt = com_tencent_mm_protocal_c_bhe.tgK;
            if (this.hrt < this.hrs) {
                if (a(this.hsD, this.gUD) < 0) {
                    w.e("MicroMsg.NetSceneUploadCardImg", "doScene again failed");
                    this.gUD.a(3, -1, "", this);
                }
                w.d("MicroMsg.NetSceneUploadCardImg", "doScene again");
                return;
            }
            if (!bg.mA(this.hPa)) {
                af Rc = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(this.username);
                if (Rc != null && ((int) Rc.gTQ) > 0 && com.tencent.mm.j.a.ez(Rc.field_type)) {
                    Rc.cm(this.hPa);
                    ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().a(this.username, Rc);
                }
            }
            this.gUD.a(i2, i3, str, this);
            return;
        }
        w.e("MicroMsg.NetSceneUploadCardImg", "upload card img error");
        this.gUD.a(i2, i3, str, this);
    }
}
