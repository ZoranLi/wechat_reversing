package com.tencent.mm.plugin.emoji.a.a;

import android.text.TextUtils;
import com.tencent.mm.protocal.c.pe;
import com.tencent.mm.protocal.c.pn;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.ak;

public final class f {
    public int kJa;
    public pn kJb;
    public pe kJc;
    public int kJd;
    public String kJe;
    public boolean kJf;
    public boolean kJg = true;
    public boolean kJh = false;
    public int mStatus;
    public int sd;

    public enum a {
        ;

        static {
            kJi = 1;
            kJj = 2;
            kJk = new int[]{kJi, kJj};
        }
    }

    public f(pn pnVar) {
        this.kJb = pnVar;
        this.kJa = a.kJi;
    }

    public f(pe peVar) {
        this.kJc = peVar;
        this.kJa = a.kJj;
    }

    public final void dv(int i) {
        if (i == 7 && this.mStatus == 6 && this.kJg) {
            this.kJf = true;
        }
        this.mStatus = i;
    }

    public final void a(boolean z, ak akVar, boolean z2) {
        pn pnVar = this.kJb;
        if (pnVar != null) {
            if (z2) {
                dv(7);
                return;
            }
            boolean a = e.a(pnVar);
            boolean b = e.b(pnVar);
            boolean bO = pnVar == null ? false : e.bO(pnVar.tva, 8);
            boolean isEmpty = TextUtils.isEmpty(pnVar.tuY);
            if (!bO || !b) {
                if (!a) {
                    if (!b && (z || !isEmpty)) {
                        this.kJd = 1;
                        if (z && akVar != null) {
                            switch (akVar.uJt) {
                                case 11:
                                    dv(11);
                                    break;
                                case 12:
                                    dv(4);
                                    break;
                                default:
                                    if (!(akVar.uJr == 7 || akVar.uJr == 6 || akVar.uJr == 3)) {
                                        dv(10);
                                        break;
                                    }
                            }
                        } else if (z) {
                            dv(11);
                        } else {
                            dv(4);
                        }
                    } else {
                        dv(3);
                        this.kJd = 0;
                    }
                } else {
                    dv(3);
                    if (b || (!z && isEmpty)) {
                        this.kJd = 0;
                    } else {
                        this.kJd = 1;
                    }
                }
            } else {
                dv(8);
            }
            if (z && akVar != null && !bg.mA(akVar.uJv)) {
                this.kJb.tuY = akVar.uJv;
            }
        }
    }
}
