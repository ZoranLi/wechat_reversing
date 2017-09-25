package com.tencent.mm.plugin.emoji.g;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.b;
import com.tencent.mm.u.bp.a;
import com.tencent.mm.y.d;
import java.util.List;
import java.util.Map;

public final class e implements a {
    public final void a(d.a aVar) {
        bu buVar = aVar.hst;
        if (buVar.mtd == CdnLogic.MediaType_FAVORITE_VIDEO) {
            String a = n.a(buVar.tff);
            if (bg.mA(a)) {
                w.w("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "msg content is null");
                return;
            }
            Map q = bh.q(a, "sysmsg");
            if (q != null && q.size() > 0) {
                String str = (String) q.get(".sysmsg.$type");
                if (bg.mA(str) || !str.equalsIgnoreCase("NewRecommendEmotion")) {
                    w.e("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "not emoji message type :" + str);
                    return;
                }
                List uz = d.uz(a);
                String[] strArr = new String[]{"1", com.tencent.mm.storage.a.a.uKN, "7"};
                h.amc().kLb.gUz.delete("EmojiGroupInfo", "recommand=? and type!=? and status!=?", strArr);
                b bVar = h.amc().kLb;
                w.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[insertRecommendEmojiGroupInfo]");
                bVar.cn(uz);
                return;
            }
            return;
        }
        w.i("MicroMsg.emoji.EmojiRecommnedSysCmdMsgListener", "not new xml type:%d ", new Object[]{Integer.valueOf(buVar.mtd)});
    }
}
