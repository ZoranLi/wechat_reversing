package com.tencent.mm.pluginsdk.model;

import com.tencent.mm.R;
import com.tencent.mm.av.l;
import com.tencent.mm.e.a.ig;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.a;

public final class b implements d {
    public final com.tencent.mm.y.d.b b(a aVar) {
        bu buVar = aVar.hst;
        if (buVar == null || buVar.mtd != 47) {
            w.f("MicroMsg.EmojiExtension", "parseEmojiMsg failed, invalid cmdAM");
        } else {
            String a = n.a(buVar.tfd);
            String a2 = n.a(buVar.tfe);
            ap.yY();
            if (!((String) c.vr().get(2, null)).equals(a)) {
                a2 = a;
            }
            ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(a2, n.a(buVar.tff), buVar.tfk, buVar.tfi, aVar);
            com.tencent.mm.u.ay.b gm = ay.gm(buVar.tfi);
            if (gm != null) {
                w.i("MicroMsg.EmojiExtension", "bizClientMsgId = %s", gm.hmP);
                if (gm.hmR != null && gm.scene == 1) {
                    int i;
                    a2 = n.a(buVar.tfd);
                    ap.yY();
                    c.vr().set(73729, Integer.valueOf(1));
                    com.tencent.mm.av.h hVar = new com.tencent.mm.av.h();
                    hVar.field_content = ab.getContext().getString(R.l.eDi);
                    hVar.field_createtime = bg.Ny();
                    hVar.field_imgpath = "";
                    hVar.field_sayhicontent = hVar.field_content;
                    hVar.field_sayhiuser = a2;
                    hVar.field_scene = 18;
                    if (buVar.jNB > 3) {
                        i = buVar.jNB;
                    } else {
                        i = 3;
                    }
                    hVar.field_status = i;
                    hVar.field_svrid = buVar.tfk;
                    hVar.field_talker = a2;
                    hVar.field_type = buVar.mtd;
                    hVar.field_isSend = 0;
                    hVar.field_sayhiencryptuser = a2;
                    hVar.field_ticket = gm.hmR;
                    l.Kz().a(hVar);
                    com.tencent.mm.sdk.b.b igVar = new ig();
                    igVar.fNP.fNQ = a2;
                    com.tencent.mm.sdk.b.a.urY.m(igVar);
                }
            }
        }
        return null;
    }

    public final void h(au auVar) {
    }
}
