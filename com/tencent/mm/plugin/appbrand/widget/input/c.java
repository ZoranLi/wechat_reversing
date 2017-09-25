package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Rect;
import android.view.View;
import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.base.f;
import com.tencent.mm.plugin.appbrand.widget.input.a.h;
import com.tencent.mm.plugin.appbrand.widget.input.t.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

final class c extends b<q> {
    boolean jsA;
    final String jsu;
    int jsv = 0;
    q jsw;
    t jsx;
    h jsy;
    boolean jsz;

    final /* bridge */ /* synthetic */ EditText Yj() {
        return this.jsw;
    }

    c(String str, m mVar) {
        super(str, mVar);
        this.jsw = new q(mVar.mContext);
        b.setNoSystemInputOnEditText(this.jsw);
        this.jsu = String.valueOf(f.a(mVar, this.jsw));
        this.jsv = bg.a((Integer) m.jtd.get(str), 0);
    }

    final String Yi() {
        return this.jsu;
    }

    public final View Yq() {
        Yt();
        return this.jsx;
    }

    public final int Yr() {
        return (this.jsy == null || this.jsy.jxv == null) ? 0 : this.jsy.jxv.intValue();
    }

    final Rect Yk() {
        return new Rect(this.jsy.jxb.intValue(), this.jsy.jxa.intValue(), this.jsy.jxb.intValue() + this.jsy.jwY.intValue(), this.jsy.jxa.intValue() + this.jsy.jwZ.intValue());
    }

    public final h b(h hVar) {
        if (this.jsy == null) {
            this.jsy = hVar;
            if (ad.b(hVar.jxF) && this.jsw != null) {
                this.jsw.cx(true);
            }
        } else {
            this.jsy.a(hVar);
        }
        if (this.jsw == null) {
            return null;
        }
        a.a(this.jsw, this.jsy);
        return this.jsy;
    }

    public final boolean rk(String str) {
        if (this.jsw == null) {
            return false;
        }
        this.jsw.r(str);
        return true;
    }

    public final boolean iK(int i) {
        if (this.jsw == null) {
            return false;
        }
        this.jsx = t.bS(((m) this.jsp.get()).jbY);
        if (this.jsx == null) {
            return false;
        }
        this.jsA = true;
        m mVar = (m) this.jsp.get();
        if (!(mVar == null || mVar.jde == null)) {
            f.Yv().n(mVar.jde);
        }
        t tVar = this.jsx;
        tVar.juq.setXMode(this.jsv);
        tVar = this.jsx;
        EditText editText = this.jsw;
        if (editText != null) {
            if (tVar.kM != editText) {
                tVar.YU();
            }
            tVar.setInputEditText(editText);
            b.c(tVar.kM);
            tVar.kM.requestFocus();
            tVar.setVisibility(0);
        }
        this.jsx.jup = new b(this) {
            final /* synthetic */ c jsB;

            {
                this.jsB = r1;
            }

            public final void onDone() {
                this.jsB.a(this.jsB.Yo());
                this.jsB.cr(false);
            }
        };
        iL(i);
        i.a(this.jsp).YG();
        this.jsA = false;
        return true;
    }

    public final boolean Ys() {
        if (Yt() == null || !isFocused()) {
            return false;
        }
        t tVar = this.jsx;
        tVar.setVisibility(8);
        tVar.YU();
        w.d("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] disableInputFocus %s", new Object[]{this.jsw});
        if (this.jsw != null) {
            this.jsw.setFocusable(false);
            this.jsw.setFocusableInTouchMode(false);
            this.jsw.setEnabled(false);
        }
        m mVar = (m) this.jsp.get();
        if (!(mVar == null || mVar.jde == null)) {
            f.Yv().o(mVar.jde);
        }
        i.a(this.jsp).YH();
        return true;
    }

    private boolean isFocused() {
        if (this.jsw == null) {
            return false;
        }
        if (this.jsw.isFocused()) {
            return true;
        }
        if (Yt() != null && Yt().isShown() && this.jsx.kM == this.jsw) {
            return true;
        }
        return false;
    }

    protected final boolean cr(boolean z) {
        w.d("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] onFocusChanged hasFocus %b, isFocused %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(isFocused())});
        if (z) {
            if (!(this.jsA || isFocused())) {
                this.jsA = true;
                iK(-2);
                this.jsA = false;
            }
        } else if (!this.jsz && isFocused()) {
            this.jsz = true;
            a(Yo());
            Ys();
            Yn();
            this.jsz = false;
            this.jsw = null;
        }
        return true;
    }

    private t Yt() {
        if (this.jsx != null) {
            return this.jsx;
        }
        t bR = t.bR(this.jsw);
        this.jsx = bR;
        return bR;
    }
}
