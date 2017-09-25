package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.mm.a.e;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.s;
import java.io.FileInputStream;
import java.io.InputStream;

public final class de implements j {
    private Context context;
    private x jiL;
    private String vBF;
    private boolean vHy = true;
    private boolean vHz = true;

    public de(Context context, x xVar, String str) {
        this.context = context;
        this.jiL = xVar;
        this.vBF = str;
        if (x.eO(this.vBF)) {
            this.vHz = false;
        }
        if (x.QO(this.vBF)) {
            this.vHy = false;
        }
        if (x.QM(this.vBF)) {
            this.vHy = false;
        }
        String str2 = (this.jiL == null || !x.eO(this.jiL.field_username)) ? this.jiL == null ? null : this.jiL.field_username : this.vBF;
        if (o.eQ(str2)) {
            this.vHz = false;
        }
    }

    public final void n(c cVar) {
        ap.yY();
        if (!com.tencent.mm.u.c.isSDCardAvailable()) {
            s.eP(this.context);
        } else if (cVar != null) {
            int i;
            if (this.jiL.field_username.equals("medianote") && (m.xP() & 16384) == 0) {
                i = 1;
            } else {
                boolean z = false;
            }
            if (i != 0) {
                cVar.field_start = 0;
                cVar.field_state = c.uLg;
                ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().d(cVar);
                ce auVar = new au();
                auVar.setType(47);
                auVar.cH("medianote");
                auVar.dw(1);
                if (cVar.bCU()) {
                    auVar.setContent(aj.a(m.xL(), 0, false, cVar.EP(), false, ""));
                }
                auVar.cI(cVar.EP());
                auVar.z(ay.gk(auVar.field_talker));
                auVar.dv(2);
                ap.yY();
                com.tencent.mm.u.c.wT().L(auVar);
                return;
            }
            ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(bg.mA(this.vBF) ? this.jiL.field_username : this.vBF, cVar, null);
        }
    }

    public final void o(c cVar) {
        ap.yY();
        if (com.tencent.mm.u.c.isSDCardAvailable()) {
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            StringBuilder stringBuilder = new StringBuilder();
            ap.yY();
            String stringBuilder2 = stringBuilder.append(com.tencent.mm.u.c.xi()).append(cVar.EP()).toString();
            if (e.aO(stringBuilder2 + "_thumb")) {
                wXMediaMessage.thumbData = e.c(stringBuilder2 + "_thumb", 0, e.aN(stringBuilder2 + "_thumb"));
            } else {
                try {
                    InputStream fileInputStream = new FileInputStream(stringBuilder2);
                    wXMediaMessage.setThumbImage(b.a(fileInputStream, 1.0f));
                    fileInputStream.close();
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.ChattingSmileyPanelImpl", e, "", new Object[0]);
                    w.e("MicroMsg.ChattingSmileyPanelImpl", "sendAppMsgEmoji Fail cause there is no thumb");
                }
            }
            wXMediaMessage.mediaObject = new WXEmojiObject(stringBuilder2);
            l.a(wXMediaMessage, cVar.field_app_id, null, this.vBF, 1, cVar.EP());
            return;
        }
        s.eP(this.context);
    }

    public final boolean aJS() {
        return this.vHz;
    }

    public final boolean aJT() {
        return this.vHy;
    }

    public final void aJU() {
    }
}
