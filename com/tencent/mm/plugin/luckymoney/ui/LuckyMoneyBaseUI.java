package com.tencent.mm.plugin.luckymoney.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.b.i;
import com.tencent.mm.plugin.luckymoney.ui.j.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.d.c;
import com.tencent.mm.y.k;

public abstract class LuckyMoneyBaseUI extends MMActivity implements c {
    public i nqY = null;
    private j nqZ = null;

    public abstract boolean d(int i, int i2, String str, k kVar);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nqY = new i(this, this);
        this.nqY.hn(1554);
        this.nqY.hn(1575);
        this.nqY.hn(1668);
        this.nqY.hn(1581);
        this.nqY.hn(1685);
        this.nqY.hn(1585);
        this.nqY.hn(1514);
        this.nqY.hn(1682);
        this.nqY.hn(1612);
        this.nqY.hn(1643);
        this.nqY.hn(1558);
        this.nqZ = new j(this);
        this.nqZ.nuH = 1;
        j jVar = this.nqZ;
        a A = j.A(jVar.iwk, jVar.nuH);
        if (jVar.iwk.cO().cP() != null) {
            if (A.nuJ != null) {
                jVar.iwk.cO().cP().setBackgroundDrawable(A.nuJ);
            }
            View customView = jVar.iwk.cO().cP().getCustomView();
            if (customView != null) {
                View findViewById = customView.findViewById(R.h.divider);
                if (!(findViewById == null || A.jza == 0)) {
                    findViewById.setBackgroundColor(A.jza);
                }
                TextView textView = (TextView) customView.findViewById(16908308);
                if (!(textView == null || A.nuK == 0)) {
                    textView.setTextColor(A.nuK);
                }
                textView = (TextView) customView.findViewById(16908309);
                if (!(textView == null || A.nuL == 0)) {
                    textView.setTextColor(A.nuL);
                }
                ImageView imageView = (ImageView) customView.findViewById(R.h.bng);
                if (!(imageView == null || A.nuM == 0)) {
                    imageView.setImageResource(A.nuM);
                }
            }
            if (A.nuN != 0) {
                jVar.pd(A.nuN);
            }
        }
        getLayoutId();
    }

    public final void r(Drawable drawable) {
        j jVar = this.nqZ;
        if (jVar.iwk.cO().cP() != null) {
            jVar.iwk.cO().cP().setBackgroundDrawable(drawable);
        }
    }

    public final void aIr() {
        j jVar = this.nqZ;
        if (jVar.iwk.cO().cP() != null) {
            jVar.iwk.cO().cP().show();
        }
        jVar = this.nqZ;
        a A = j.A(jVar.iwk, jVar.nuH);
        if (A.nuN != 0) {
            jVar.pd(A.nuN);
        }
    }

    public final void aIs() {
        j jVar = this.nqZ;
        if (jVar.iwk.cO().cP() != null) {
            jVar.iwk.cO().cP().hide();
        }
        jVar = this.nqZ;
        jVar.pd(jVar.nuI);
    }

    public void onDestroy() {
        this.nqY.ho(1554);
        this.nqY.ho(1575);
        this.nqY.ho(1668);
        this.nqY.ho(1581);
        this.nqY.ho(1685);
        this.nqY.ho(1585);
        this.nqY.ho(1514);
        this.nqY.ho(1682);
        this.nqY.ho(1612);
        this.nqY.ho(1643);
        this.nqY.ho(1558);
        this.nqZ = null;
        super.onDestroy();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.nqY.aHU()) {
                this.nqY.aHT();
            }
            if (this.uSU.ipu.getVisibility() == 8 || this.uSU.ipu.getVisibility() == 4) {
                finish();
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    public final void b(int i, int i2, String str, k kVar, boolean z) {
        if (!d(i, i2, str, kVar)) {
            if (i != 0 || i2 != 0) {
                g.bl(this, str);
                finish();
            }
        }
    }

    public final void hn(int i) {
        this.nqY.hn(i);
    }

    public final void ho(int i) {
        this.nqY.ho(i);
    }

    public final void b(k kVar, boolean z) {
        this.nqY.b(kVar, z);
    }

    public final void k(k kVar) {
        this.nqY.b(kVar, true);
    }
}
