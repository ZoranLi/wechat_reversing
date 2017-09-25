package com.tencent.mm.plugin.game.gamewebview.a;

import android.content.Context;
import com.tencent.mm.plugin.game.model.ah.a;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.protocal.c.tg;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;

public final class c {
    public static void y(Context context, int i) {
        a h = a.h(12909, Integer.valueOf(5), Integer.valueOf(5), Integer.valueOf(1), Integer.valueOf(6), Integer.valueOf(0), null, Integer.valueOf(i), Integer.valueOf(0), null, Integer.valueOf(bg.getInt(null, 0)), Integer.valueOf(ai.ck(context)), null);
        b.a aVar = new b.a();
        aVar.uri = "/cgi-bin/micromsg-bin/gamereportkv";
        aVar.hsl = 427;
        aVar.hso = 0;
        aVar.hsp = 0;
        com.tencent.mm.bd.a tgVar = new tg();
        tgVar.tlu = d.sYH;
        tgVar.tlv = d.sYG;
        tgVar.tlw = d.sYJ;
        tgVar.tlx = d.sYK;
        tgVar.tly = v.bIN();
        tgVar.oTM = h.hVl;
        tgVar.tlz = h.mrx;
        aVar.hsm = tgVar;
    }
}
