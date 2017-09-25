package com.tencent.mm.plugin.emoji.g;

import android.text.TextUtils;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.emoji.f.k;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.Map;

public final class c implements com.tencent.mm.u.bp.a {

    public class a {
        private String fEl;
        public int kNx;
        public int kNy;
        final /* synthetic */ c kNz;
        public String thumburl;

        public a(c cVar, int i, int i2, String str, String str2) {
            this.kNz = cVar;
            this.kNx = i;
            this.kNy = i2;
            this.thumburl = str;
            this.fEl = str2;
        }
    }

    public final void a(com.tencent.mm.y.d.a aVar) {
        bu buVar = aVar.hst;
        if (buVar.mtd == CdnLogic.MediaType_FAVORITE_VIDEO) {
            String a = n.a(buVar.tff);
            if (bg.mA(a)) {
                w.w("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "msg content is null");
                return;
            }
            Map q = bh.q(a, "sysmsg");
            if (q != null && q.size() > 0) {
                a = (String) q.get(".sysmsg.$type");
                if (bg.mA(a) || !a.equalsIgnoreCase("emotionstore")) {
                    w.e("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "not emoji message type :" + a);
                    return;
                }
                try {
                    int i;
                    int i2;
                    String str = (String) q.get(".sysmsg.emotionstore.productid");
                    a = (String) q.get(".sysmsg.emotionstore.newcount");
                    String str2 = (String) q.get(".sysmsg.emotionstore.freecount");
                    String str3 = (String) q.get(".sysmsg.emotionstore.thumburl");
                    if (bg.mA(a)) {
                        i = 0;
                    } else {
                        i = Integer.valueOf(a).intValue();
                    }
                    if (TextUtils.isEmpty(str2)) {
                        i2 = 0;
                    } else {
                        i2 = Integer.valueOf(str2).intValue();
                    }
                    a aVar2 = new a(this, i, i2, str3, str);
                    if (bg.mA(str)) {
                        a(aVar2);
                    } else {
                        w.i("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "new xml productid is %s. now try to get download flag", new Object[]{str});
                        ap.vd().a(new k(str, aVar2), 0);
                    }
                    a = (String) q.get(".sysmsg.personalemotion.newcount");
                    if (!bg.mA(a) && Integer.valueOf(a).intValue() > 0) {
                        ap.yY();
                        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzK, Boolean.valueOf(true));
                    }
                    a = (String) q.get(".sysmsg.personalemoji.emojicount");
                    if (!bg.mA(a) && Integer.valueOf(a).intValue() > 0) {
                        ap.yY();
                        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uzN, Boolean.valueOf(true));
                        return;
                    }
                    return;
                } catch (Throwable e) {
                    w.e("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "onRecieveMsg:%s", new Object[]{bg.g(e)});
                    return;
                }
            }
            return;
        }
        w.i("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "not new xml type:%d ", new Object[]{Integer.valueOf(buVar.mtd)});
    }

    public static void a(a aVar) {
        if (aVar == null) {
            w.w("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "xml is null.");
            return;
        }
        if (aVar.kNx > 0) {
            ap.yY();
            com.tencent.mm.u.c.vr().set(208899, Boolean.valueOf(true));
            com.tencent.mm.q.c.uk().s(262147, true);
        }
        if (aVar.kNy > 0) {
            ap.yY();
            com.tencent.mm.u.c.vr().set(208913, Boolean.valueOf(true));
            com.tencent.mm.q.c.uk().s(262149, true);
        }
        if (bg.mA(aVar.thumburl)) {
            ap.yY();
            com.tencent.mm.u.c.vr().set(229633, "");
            ap.yY();
            com.tencent.mm.u.c.vr().set(229634, "");
            return;
        }
        w.d("MicroMsg.emoji.EmojiNewFreeSysCmdMsgListener", "Thumb URL %s", new Object[]{aVar.thumburl});
        ap.yY();
        com.tencent.mm.u.c.vr().set(229633, aVar.thumburl);
        ap.yY();
        com.tencent.mm.u.c.vr().set(229634, System.currentTimeMillis());
    }
}
