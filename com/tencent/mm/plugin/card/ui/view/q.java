package com.tencent.mm.plugin.card.ui.view;

import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.c.lz;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.pb.common.c.i;

public final class q extends g {
    public String koQ = "";

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
                lz lzVar = this.kcX.afi().toO;
                lz lzVar2 = bVar.afi().toO;
                if ((lzVar == null && lzVar2 != null) || (lzVar != null && lzVar2 == null)) {
                    w.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field  is diffrent！");
                    return true;
                } else if (lzVar != null && lzVar2 != null && lzVar.title != null && lzVar2.title != null && !lzVar.title.equals(lzVar2.title)) {
                    w.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field title is diffrent！");
                    return true;
                } else if (lzVar != null && lzVar2 != null && lzVar.kdI != null && lzVar2.kdI != null && !lzVar.kdI.equals(lzVar2.kdI)) {
                    w.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field aux_title  is diffrent！");
                    return true;
                } else if (!this.kcX.afc() || i.isNullOrEmpty(this.koQ)) {
                    return false;
                } else {
                    w.i("MicroMsg.CardCodeView", "dynamicCode updated！");
                    return true;
                }
            }
            w.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain   code  is diffrent！");
            return true;
        }
    }

    public final String e(c cVar) {
        if (!i.isNullOrEmpty(this.kcX.afj().tnT)) {
            return this.kcX.afj().tnT;
        }
        if (!this.kcX.afc() || i.isNullOrEmpty(this.koQ)) {
            return this.kcX.afj().code;
        }
        return this.koQ;
    }

    public final aa aiE() {
        return new s(this, this.kdb);
    }

    public final aa aiF() {
        return new p(this, this.kdb);
    }

    public final aa aiG() {
        return new r(this, this.kdb);
    }
}
