package com.tencent.mm.plugin.readerapp.b;

import com.tencent.mm.R;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.lp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.bd;
import java.util.List;

public final class d extends c<lp> {
    public d() {
        this.usg = lp.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        lp lpVar = (lp) bVar;
        switch (lpVar.fSH.opType) {
            case 3:
                boolean a;
                lp.b bVar2 = lpVar.fSI;
                cb cbVar = lpVar.fSH.fSJ;
                int i = lpVar.fSH.fSK;
                w.i("MicroMsg.Sns.GetFavDataSource", "fav info, newsSvrid is %d, tweetId is %s", new Object[]{Integer.valueOf(i), lpVar.fSH.fSL});
                List b = g.aWb().b((long) i, 20);
                if (!b.isEmpty()) {
                    w.i("MicroMsg.Sns.GetFavDataSource", "fav news msgs");
                    String ap = bg.ap(r1, "");
                    for (int i2 = 0; i2 < b.size(); i2++) {
                        if (ap.equals(((bd) b.get(i2)).zD())) {
                            a = b.a(cbVar, (bd) b.get(i2), i2);
                            bVar2.fFj = a;
                            break;
                        }
                    }
                }
                cbVar.fFA.fFG = R.l.eib;
                a = false;
                bVar2.fFj = a;
            case 4:
                g.aWb().fg(lpVar.fSH.fSM);
                break;
        }
        return false;
    }
}
