package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bhx;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.List;

public final class s extends k implements j {
    private final b gUA;
    private e gUD;
    private int hEc;
    private List<String> kNw = new ArrayList();

    public s(List<String> list, int i) {
        a aVar = new a();
        aVar.hsm = new bhx();
        aVar.hsn = new bhy();
        aVar.uri = "/cgi-bin/micromsg-bin/mmuploadmypanellist";
        aVar.hsl = 717;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.kNw = list;
        this.hEc = i;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.emoji.NetSceneUploadMyPanelList", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.uzE, Long.valueOf(System.currentTimeMillis()));
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.uzH, Boolean.valueOf(true));
            g.oUh.a(165, 0, 1, false);
        } else {
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.uzE, Long.valueOf((System.currentTimeMillis() - 86400000) + 3600000));
            g.oUh.a(165, 1, 1, false);
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 717;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        bhx com_tencent_mm_protocal_c_bhx = (bhx) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bhx.tce = this.hEc;
        if (this.kNw != null) {
            for (Object obj : this.kNw) {
                Object obj2;
                if (!bg.mA(obj2) && obj2.equals(String.valueOf(com.tencent.mm.storage.a.a.uKQ))) {
                    obj2 = "com.tencent.xin.emoticon.tusiji";
                }
                com_tencent_mm_protocal_c_bhx.uhu.add(obj2);
                w.d("MicroMsg.emoji.NetSceneUploadMyPanelList", "product id is:%s", new Object[]{obj2});
            }
            w.i("MicroMsg.emoji.NetSceneUploadMyPanelList", "opcode is:%d mProductIdList size:%s", new Object[]{Integer.valueOf(this.hEc), Integer.valueOf(this.kNw.size())});
        }
        return a(eVar, this.gUA, this);
    }
}
