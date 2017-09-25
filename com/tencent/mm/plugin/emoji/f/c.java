package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.dz;
import com.tencent.mm.protocal.c.ea;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;

public final class c extends k implements j {
    public final b gUA;
    private e gUD;
    public int hEc;
    private List<String> kMK;

    public c(int i, List<String> list) {
        a aVar = new a();
        aVar.hsm = new dz();
        aVar.hsn = new ea();
        aVar.uri = "/cgi-bin/micromsg-bin/mmbackupemojioperate";
        aVar.hsl = 698;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.hEc = i;
        this.kMK = list;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i3 == -434) {
            w.w("MicroMsg.emoji.NetSceneBackupEmojiOperate", "[cpan] batch backup emoji failed. over size.");
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzD, Boolean.valueOf(true));
            g.oUh.a(164, 7, 1, false);
        }
        if (i2 == 0 && i3 == 0) {
            ap.yY();
            com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzD, Boolean.valueOf(false));
            if (this.hEc == 1) {
                g.oUh.a(164, 5, 1, false);
            } else {
                g.oUh.a(164, 8, 1, false);
            }
        } else if (this.hEc == 1) {
            g.oUh.a(164, 6, 1, false);
        } else {
            g.oUh.a(164, 9, 1, false);
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 698;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        dz dzVar = (dz) this.gUA.hsj.hsr;
        dzVar.thO = this.hEc;
        dzVar.thN = new LinkedList(this.kMK);
        if (dzVar.thN == null || dzVar.thN.size() <= 0) {
            w.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "empty md5 list.");
        } else {
            w.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5 list size:%s", new Object[]{Integer.valueOf(dzVar.thN.size())});
            for (int i = 0; i < dzVar.thN.size(); i++) {
                w.i("MicroMsg.emoji.NetSceneBackupEmojiOperate", "do scene delte md5:%s", new Object[]{dzVar.thN.get(i)});
            }
        }
        return a(eVar, this.gUA, this);
    }
}
