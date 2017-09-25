package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.es;
import com.tencent.mm.protocal.c.et;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class d extends k implements j {
    private final b gUA;
    private e gUD;
    private ArrayList<String> kML;

    public d(ArrayList<String> arrayList) {
        a aVar = new a();
        aVar.hsm = new es();
        aVar.hsn = new et();
        aVar.uri = "/cgi-bin/micromsg-bin/mmbatchemojibackup";
        aVar.hsl = 696;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.kML = arrayList;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "netId:%d, errType:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i3 == -434) {
            w.w("MicroMsg.emoji.NetSceneBatchEmojiBackup", "[cpan] batch backup emoji failed. over size.");
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.uzD, Boolean.valueOf(true));
            g.oUh.a(164, 4, 1, false);
        }
        if (i2 == 0 && i3 == 0) {
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.uzD, Boolean.valueOf(false));
            f fVar = h.amc().kLa;
            List list = this.kML;
            if (list == null || list.size() <= 0) {
                w.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] LocalCustomEmoji failed. list is null");
            } else {
                w.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] LocalCustomEmoji list size :%d.", new Object[]{Integer.valueOf(list.size())});
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("UPDATE");
                stringBuilder.append(" EmojiInfo ");
                stringBuilder.append(" SET ");
                stringBuilder.append("source");
                stringBuilder.append("=");
                stringBuilder.append(com.tencent.mm.storage.a.c.uLk);
                stringBuilder.append(" where ");
                stringBuilder.append("md5");
                stringBuilder.append(" IN (");
                for (int i4 = 0; i4 < list.size(); i4++) {
                    stringBuilder.append("'" + ((String) list.get(i4)) + "'");
                    if (i4 < list.size() - 1) {
                        stringBuilder.append(",");
                    }
                }
                stringBuilder.append(")");
                w.d("MicroMsg.emoji.EmojiInfoStorage", stringBuilder.toString());
                fVar.gUz.eE("EmojiInfo", stringBuilder.toString());
            }
            g.oUh.a(164, 2, 1, false);
        } else {
            g.oUh.a(164, 3, 1, false);
        }
        et etVar = (et) this.gUA.hsk.hsr;
        if (etVar.thP != null && etVar.thP.size() > 0) {
            w.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "[cpan] there are some emoji need to upload.");
            h.amc().kLa.ax(etVar.thP);
            ap.yY();
            c.vr().set(348165, Boolean.valueOf(true));
            com.tencent.mm.plugin.emoji.c.a.dr(true);
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 696;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        ((es) this.gUA.hsj.hsr).thN = new LinkedList(this.kML);
        if (this.kML != null && this.kML.size() > 0) {
            return a(eVar, this.gUA, this);
        }
        w.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "need no backup custom emoji, list is null.");
        ap.yY();
        c.vr().set(348162, Boolean.valueOf(false));
        return -1;
    }
}
