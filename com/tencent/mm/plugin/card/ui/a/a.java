package com.tencent.mm.plugin.card.ui.a;

import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;

public class a implements g {
    protected b kcX;
    protected MMActivity kdb;
    protected com.tencent.mm.plugin.card.ui.e.a kkZ;
    boolean kpB = false;
    private boolean kpC = false;
    private boolean kpD = false;
    private boolean kpE = false;
    private boolean kpF = false;
    private boolean kpG = false;
    private boolean kpH = false;
    private boolean kpI = false;
    private boolean kpJ = false;
    private boolean kpK = false;

    public a(MMActivity mMActivity) {
        this.kdb = mMActivity;
    }

    public final void a(b bVar, com.tencent.mm.plugin.card.ui.e.a aVar) {
        this.kcX = bVar;
        this.kkZ = aVar;
        ahX();
    }

    public final void release() {
        this.kcX = null;
        this.kkZ = null;
        this.kdb = null;
    }

    public final String ahR() {
        String str = "";
        if (!TextUtils.isEmpty(this.kcX.afi().toI)) {
            return this.kcX.afi().toI;
        }
        if (this.kcX.afj().tnI == 0) {
            return getString(R.l.dRw);
        }
        if (this.kcX.afj().tnJ != 0) {
            return str;
        }
        if (TextUtils.isEmpty(this.kcX.afi().too)) {
            return getString(R.l.dQg);
        }
        return this.kcX.afi().too;
    }

    private String getString(int i) {
        return this.kdb.getString(i);
    }

    public final boolean ahS() {
        if (this.kcX.afj().status == 0 || this.kcX.afj().status == 1 || this.kcX.afj().status == 2) {
            return true;
        }
        return false;
    }

    public final boolean ahT() {
        return this.kkZ.jZM == 3 || ((this.kkZ.jZM == 6 && this.kcX.afj().tnF == 0) || this.kkZ.jZM == 4 || this.kkZ.jZM == 5 || this.kkZ.jZM == 15);
    }

    private boolean ahU() {
        return !TextUtils.isEmpty(this.kcX.afj().code);
    }

    protected final boolean ahV() {
        return !this.kcX.isAcceptable() && (l.kF(this.kkZ.jZM) || l.kG(this.kkZ.jZM) || this.kkZ.jZM == 23);
    }

    protected final boolean ahW() {
        return !this.kcX.aff() && this.kkZ.jZM == 6;
    }

    protected void ahX() {
        w.i("MicroMsg.CardBaseShowLogic", "updateAcceptState()");
        if (l.kF(this.kkZ.jZM) || l.kG(this.kkZ.jZM)) {
            if (this.kcX.isAcceptable()) {
                this.kpC = true;
                this.kpD = true;
                this.kpI = true;
                this.kpG = true;
                this.kpH = true;
            } else if (this.kcX.isAcceptable()) {
                this.kpC = false;
                this.kpD = false;
                this.kpG = false;
            } else {
                this.kpC = true;
                this.kpD = false;
                if (this.kcX.afd()) {
                    this.kpJ = true;
                    this.kpG = true;
                    this.kpF = true;
                } else {
                    this.kpG = false;
                }
                this.kpH = true;
            }
        } else if (this.kkZ.jZM == 6) {
            if (this.kcX.aff()) {
                this.kpC = true;
                this.kpD = true;
                this.kpG = false;
            } else if (this.kcX.afe()) {
                this.kpJ = true;
                this.kpG = true;
                this.kpE = true;
                this.kpF = true;
            } else {
                this.kpC = false;
                this.kpD = false;
                this.kpG = false;
                this.kpE = true;
            }
        } else if (l.kH(this.kkZ.jZM)) {
            this.kpC = false;
            this.kpD = false;
            this.kpE = true;
            if (this.kcX.afe()) {
                this.kpJ = true;
                this.kpG = true;
                this.kpF = true;
            } else {
                this.kpK = true;
            }
        } else if (this.kkZ.jZM == 23) {
            if (this.kcX.isAcceptable()) {
                this.kpC = true;
                this.kpD = true;
                this.kpG = false;
                this.kpH = true;
            } else {
                this.kpC = true;
                this.kpD = false;
                this.kpG = false;
                this.kpH = true;
            }
            if (!(TextUtils.isEmpty(this.kkZ.kkj) || this.kkZ.kkj.equals(m.xL()) || this.kcX.afh())) {
                w.i("MicroMsg.CardBaseShowLogic", " detail page");
                this.kpC = false;
                this.kpD = false;
                this.kpE = true;
                if (this.kcX.afe()) {
                    this.kpJ = true;
                    this.kpG = true;
                    this.kpF = true;
                }
            }
        }
        if (this.kcX.afd()) {
            this.kpC = false;
            this.kpD = false;
            w.i("MicroMsg.CardBaseShowLogic", "need direct jump!");
        } else {
            w.i("MicroMsg.CardBaseShowLogic", "not need direct jump!");
        }
        if (this.kpB) {
            this.kpC = false;
            this.kpD = false;
            w.i("MicroMsg.CardBaseShowLogic", "updateAcceptView to gone!");
        } else if (this.kpC) {
            this.kpB = false;
            w.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is false!");
        } else {
            this.kpB = true;
            w.i("MicroMsg.CardBaseShowLogic", "set mIsAcceptedCard is true");
        }
        w.i("MicroMsg.CardBaseShowLogic", "mIsAcceptedCard:" + this.kpB);
    }

    public final boolean ahx() {
        return this.kpB;
    }

    public boolean ahY() {
        return this.kpC;
    }

    public final boolean ahZ() {
        return this.kpD;
    }

    public final boolean aia() {
        return this.kpE;
    }

    public final boolean aib() {
        return this.kpF;
    }

    public final boolean aic() {
        return this.kpG;
    }

    public final boolean aid() {
        return this.kpI;
    }

    public final boolean aie() {
        return this.kpJ;
    }

    public final boolean aif() {
        return this.kpK;
    }

    public boolean aig() {
        return true;
    }

    public boolean aih() {
        return false;
    }

    public boolean aii() {
        return false;
    }

    public boolean aij() {
        return (this.kkZ.jZM == 6 && (!this.kcX.afe() || this.kcX.aff())) || this.kkZ.jZM == 5 || (this.kkZ.jZM == 23 && this.kcX.afh());
    }

    public boolean aik() {
        return false;
    }

    public boolean ail() {
        return true;
    }

    public boolean aim() {
        return (ahU() && ahS() && ahT()) || this.kpB;
    }

    public boolean ain() {
        return false;
    }

    public boolean aio() {
        return !this.kcX.afe();
    }

    public boolean aip() {
        return (this.kcX.afi().toC == null || this.kcX.afi().toC.ttG == null || this.kcX.afi().toC.ttG.size() <= 0 || TextUtils.isEmpty((CharSequence) this.kcX.afi().toC.ttG.get(0))) ? false : true;
    }

    public boolean aiq() {
        if (this.kcX.afj().tnH == null || this.kcX.afj().tnH.size() <= 0 || ((!ahS() || !ahT()) && !this.kpB)) {
            return false;
        }
        return true;
    }

    public boolean air() {
        return false;
    }

    public final boolean ais() {
        return (this.kcX.afj().tnL == null || TextUtils.isEmpty(this.kcX.afj().tnL.title)) ? false : true;
    }

    public boolean ait() {
        return (this.kcX.afj().tnO == null || TextUtils.isEmpty(this.kcX.afj().tnO.title)) ? false : true;
    }

    public boolean aiu() {
        return this.kcX.afi().toy != null;
    }

    public boolean aiv() {
        if (TextUtils.isEmpty(this.kcX.afi().tov)) {
            return false;
        }
        return true;
    }

    public boolean aiw() {
        return false;
    }

    public boolean aix() {
        return false;
    }

    public final void aiy() {
        int i;
        int i2 = 1;
        String str = "MicroMsg.CardBaseShowLogic";
        String str2 = "printStatus, isValidCode:%d, getUnacceptWording:%s, isAcceptedCard:%d, acceptViewVisible:%d, acceptViewEnabled:%d, isShowConsumedBtn:%d, isConsumedBtnEnabled:%d, enableOptionMenu:%d, isShareLogoVisible:%d, addShareMenu:%d, addMenu:%d, addInvalidCardMenu:%d ";
        Object[] objArr = new Object[12];
        if (ahU()) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[0] = Integer.valueOf(i);
        objArr[1] = ahR();
        objArr[2] = Integer.valueOf(this.kpB ? 1 : 0);
        objArr[3] = Integer.valueOf(ahY() ? 1 : 0);
        objArr[4] = Integer.valueOf(this.kpD ? 1 : 0);
        objArr[5] = Integer.valueOf(this.kpE ? 1 : 0);
        objArr[6] = Integer.valueOf(this.kpF ? 1 : 0);
        objArr[7] = Integer.valueOf(this.kpG ? 1 : 0);
        objArr[8] = Integer.valueOf(this.kpH ? 1 : 0);
        objArr[9] = Integer.valueOf(this.kpI ? 1 : 0);
        objArr[10] = Integer.valueOf(this.kpJ ? 1 : 0);
        if (!this.kpK) {
            i2 = 0;
        }
        objArr[11] = Integer.valueOf(i2);
        w.i(str, str2, objArr);
    }
}
