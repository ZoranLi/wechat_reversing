package com.tencent.mm.plugin.card.ui.view;

import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.pb.common.c.i;

public final class j extends g {
    public final boolean h(b bVar) {
        if (this.kcX == null) {
            w.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
            return true;
        } else if (bVar == null) {
            w.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
            return false;
        } else {
            String str = this.kcX.afj().code;
            String str2 = bVar.afj().code;
            if (i.wx(str) || i.wx(str2) || str.equals(str2)) {
                return false;
            }
            w.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain   code  is diffrent！");
            return true;
        }
    }

    public final String e(c cVar) {
        return this.kcX.afj().code;
    }

    public final aa aiE() {
        return new v(this, this.kdb);
    }

    public final aa aiF() {
        return new f(this, this.kdb);
    }

    public final aa aiG() {
        return new t(this, this.kdb);
    }
}
