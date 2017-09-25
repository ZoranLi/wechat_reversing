package com.tencent.mm.plugin.appbrand.widget.input;

import android.app.Activity;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.support.v4.view.z;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class g implements x<w> {
    private static final Map<String, Integer> jtd;
    public WeakReference<m> iNd;
    public volatile b jsJ;
    public volatile c jsK;
    public volatile a jsL;
    public final OnFocusChangeListener jsM = new OnFocusChangeListener(this) {
        final /* synthetic */ g jte;

        {
            this.jte = r1;
        }

        public final void onFocusChange(View view, boolean z) {
            boolean z2 = false;
            g gVar = this.jte;
            if (z) {
                gVar.Yz();
            }
            if (gVar.jsT == null) {
                gVar.jsT = gVar.YC();
            }
            if (gVar.jsL != null) {
                gVar.jsL.bM(z);
            }
            if (gVar.jsS != null && z && gVar.jsQ.jxr.booleanValue()) {
                af.f(gVar.jsV, 100);
            }
            if (!(gVar.jsS == null || z || gVar.jsQ.jwU)) {
                if (gVar.jsP == 0) {
                    gVar.ct(false);
                }
                gVar.jsS.setFocusable(false);
                gVar.jsS.setFocusableInTouchMode(false);
                if (gVar.jsT.juK == gVar.jsS) {
                    gVar.jsT.hide();
                    gVar.jsT.b(gVar.jsS);
                }
            }
            if (!(gVar.jsT == null || gVar.jsS == null || z || !gVar.jsQ.jwU)) {
                gVar.ct(false);
                if (gVar.jsQ.jwU) {
                    gVar.a(gVar.jsS);
                    gVar.onDestroy();
                }
            }
            if (z && (!this.jte.jsQ.jwU || com.tencent.mm.plugin.appbrand.ui.g.bF(this.jte.jsS))) {
                z2 = true;
            }
            if (z2 && this.jte.jsS != null && this.jte.jsT != null) {
                this.jte.jsS.requestFocus();
                this.jte.jsT.show();
            }
        }
    };
    private int jsN = -1;
    private int jsO = -1;
    public int jsP = 0;
    public com.tencent.mm.plugin.appbrand.widget.input.a.e jsQ;
    public String jsR;
    public w jsS;
    public v jsT;
    public t jsU;
    final Runnable jsV = new Runnable(this) {
        final /* synthetic */ g jte;

        {
            this.jte = r1;
        }

        public final void run() {
            this.jte.Yy();
        }
    };
    final ae jsW = new ae(Looper.getMainLooper());
    final e jsX = new e(this);
    boolean jsY = false;
    final Runnable jsZ = new Runnable(this) {
        final /* synthetic */ g jte;

        {
            this.jte = r1;
        }

        public final void run() {
            this.jte.jsY = false;
        }
    };
    private final com.tencent.mm.ui.tools.a.c.a jsr = new a(this) {
        final /* synthetic */ g jte;

        {
            this.jte = r1;
        }

        public final void Yp() {
            if (this.jte.jsS != null && this.jte.jsJ != null) {
                try {
                    this.jte.jsJ.af(this.jte.jsS.getText().toString(), this.jte.jsS.getSelectionEnd());
                } catch (Exception e) {
                }
            }
        }
    };
    private final com.tencent.mm.plugin.appbrand.widget.input.v.c jta = new com.tencent.mm.plugin.appbrand.widget.input.v.c(this) {
        final /* synthetic */ g jte;

        {
            this.jte = r1;
        }

        public final boolean rl(String str) {
            if (this.jte.jsS != null) {
                w wVar;
                if ("[DELETE_EMOTION]".equalsIgnoreCase(str)) {
                    wVar = this.jte.jsS;
                    if (wVar.juR == null) {
                        wVar.dispatchKeyEvent(new KeyEvent(0, 67));
                        wVar.dispatchKeyEvent(new KeyEvent(1, 67));
                    } else if (!bg.J(wVar.getEditableText())) {
                        wVar.juR.deleteSurroundingText(wVar.getEditableText().length(), wVar.getEditableText().length() - 1);
                    }
                } else {
                    wVar = this.jte.jsS;
                    if (wVar.getEditableText() == null) {
                        wVar.setText(str, BufferType.EDITABLE);
                    } else {
                        wVar.getEditableText().append(str);
                    }
                    wVar.setSelection(wVar.getEditableText().length());
                }
            }
            return true;
        }
    };
    private final com.tencent.mm.plugin.appbrand.widget.input.v.b jtb = new com.tencent.mm.plugin.appbrand.widget.input.v.b(this) {
        final /* synthetic */ g jte;

        {
            this.jte = r1;
        }

        public final void cu(boolean z) {
            if (z) {
                this.jte.jsP = d.jti;
            }
            this.jte.YB();
            this.jte.jsP = 0;
        }
    };
    private final com.tencent.mm.plugin.appbrand.widget.input.v.d jtc = new com.tencent.mm.plugin.appbrand.widget.input.v.d(this) {
        final /* synthetic */ g jte;

        {
            this.jte = r1;
        }

        public final void iM(int i) {
            w.d("MicroMsg.AppBrandInputInvokeHandler", "[appInput], onSmileyPanelVisibilityChanged = %d", new Object[]{Integer.valueOf(i)});
            if (i != 2) {
                if (i == 0 && this.jte.jsS != null) {
                    this.jte.jsS.requestFocus();
                }
                this.jte.YE();
                if (this.jte.iNd != null && this.jte.iNd.get() != null) {
                    m.a((m) this.jte.iNd.get(), this.jte.jsS);
                    return;
                }
                return;
            }
            this.jte.jsP = d.jth;
            this.jte.YB();
            this.jte.jsP = 0;
        }
    };

    class AnonymousClass4 implements OnEditorActionListener {
        final /* synthetic */ g jte;
        final /* synthetic */ int jtf;

        public AnonymousClass4(g gVar, int i) {
            this.jte = gVar;
            this.jtf = i;
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != this.jtf) {
                return false;
            }
            this.jte.jsP = d.jti;
            this.jte.YB();
            this.jte.jsP = 0;
            return true;
        }
    }

    public interface a {
        void bM(boolean z);
    }

    public interface b {
        void af(String str, int i);
    }

    public interface c {
        void bo(int i, int i2);
    }

    private enum d {
        ;

        static {
            jth = 1;
            jti = 2;
            jtj = new int[]{jth, jti};
        }
    }

    private final class e implements Runnable {
        final /* synthetic */ g jte;
        Editable jtk = null;

        public e(g gVar) {
            this.jte = gVar;
        }

        public final void run() {
            if (this.jte.jsJ != null && this.jtk != null) {
                this.jte.jsJ.af(this.jtk.toString(), Selection.getSelectionEnd(this.jtk));
            }
        }
    }

    public abstract void TJ();

    public abstract void TK();

    public abstract void b(String str, int i, boolean z, boolean z2);

    public final /* bridge */ /* synthetic */ EditText Ym() {
        return this.jsS;
    }

    public final boolean f(m mVar) {
        return (mVar == null || this.iNd == null || mVar != this.iNd.get()) ? false : true;
    }

    public final boolean iK(int i) {
        if (!(this.jsS == null || this.iNd == null || this.iNd.get() == null)) {
            this.jsS.performClick();
        }
        iL(i);
        return true;
    }

    public final boolean Ys() {
        boolean z = this.jsS != null && (this.jsS.isFocused() || (YC() != null && YC().juK == this.jsS));
        if (z) {
            v YC = YC();
            t Yt = Yt();
            if (YC != null) {
                YC.setVisibility(8);
            }
            if (Yt != null) {
                Yt.setVisibility(8);
            }
        } else {
            w.d("MicroMsg.AppBrandInputInvokeHandler", "doHideKeyboard, not focused, return");
        }
        return true;
    }

    public final void b(String str, Integer num) {
        if (this.jsS != null) {
            this.jsS.r(str);
            iL(num == null ? -1 : num.intValue());
            Yx();
        }
    }

    public final boolean Yl() {
        Object obj;
        if (this.jsS == null || this.iNd == null || this.iNd.get() == null) {
            obj = null;
        } else {
            this.jsS.destroy();
            e eVar = ((m) this.iNd.get()).jdd;
            if (eVar == null) {
                obj = null;
            } else {
                if (this.jsS.hasFocus()) {
                    if (this.jsU != null) {
                        this.jsU.setVisibility(8);
                    }
                    YC();
                    if (this.jsT != null) {
                        this.jsT.setVisibility(8);
                    }
                }
                eVar.bM(this.jsS);
                int i = 1;
            }
        }
        if (obj == null) {
            return false;
        }
        onDestroy();
        return true;
    }

    public final View Yq() {
        return this.jsT;
    }

    public final int Yr() {
        if (this.jsQ != null && this.jsQ.jxv != null) {
            return this.jsQ.jxv.intValue();
        }
        if (this.jsS == null || !this.jsS.YP()) {
            return 0;
        }
        return 5;
    }

    final void onDestroy() {
        this.jsS = null;
        com.tencent.mm.plugin.appbrand.m.d.aO(this);
    }

    private void Yw() {
        if (this.jsS != null && ad.b(this.jsQ.jxt) && ad.b(this.jsQ.jxr)) {
            ((o) this.jsS).cw(true);
            int lineHeight = this.jsS.getLineHeight();
            int Zj = this.jsS.Zj();
            int intValue = (this.jsQ.jxc == null || this.jsQ.jxc.intValue() <= 0) ? lineHeight : this.jsQ.jxc.intValue();
            int max = (this.jsQ.jxd == null || this.jsQ.jxd.intValue() <= 0) ? Integer.MAX_VALUE : Math.max(this.jsQ.jxd.intValue(), lineHeight);
            this.jsS.setMinHeight(intValue);
            this.jsS.setMaxHeight(max);
            a(this.jsS, this.jsQ.jwY.intValue(), Math.max(intValue, Math.min(Zj, max)), this.jsQ.jxb.intValue(), this.jsQ.jxa.intValue());
        }
    }

    public final void cs(boolean z) {
        if (this.jsS == null || !(z || z.al(this.jsS))) {
            w.e("MicroMsg.AppBrandInputInvokeHandler", "updateInputImpl, input is null or detached, skip");
            return;
        }
        if (ad.b(this.jsQ.jxt)) {
            Yw();
        } else {
            a(this.jsS, this.jsQ.jwY.intValue(), this.jsQ.jwZ.intValue(), this.jsQ.jxb.intValue(), this.jsQ.jxa.intValue());
        }
        if (this.jsQ.jxh != null) {
            this.jsS.setTextSize(0, (float) this.jsQ.jxh.intValue());
        }
        if (this.jsQ.jxg != null) {
            this.jsS.setTextColor(this.jsQ.jxg.intValue());
        }
        if (this.jsQ.jxf != null) {
            this.jsS.setBackgroundDrawable(new ColorDrawable(this.jsQ.jxf.intValue()));
        } else {
            this.jsS.setBackgroundDrawable(null);
        }
        if (!bg.mA(this.jsQ.jxl)) {
            w wVar = this.jsS;
            CharSequence spannableStringBuilder = new SpannableStringBuilder(this.jsQ.jxl);
            int length = this.jsQ.jxl.length();
            spannableStringBuilder.setSpan(new StyleSpan(com.tencent.mm.plugin.appbrand.widget.input.a.c.rr(this.jsQ.jxm).style), 0, length, 18);
            if (this.jsQ.jxo != null) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.jsQ.jxo.intValue()), 0, length, 18);
            }
            if (this.jsQ.jxn != null) {
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(this.jsQ.jxn.intValue(), false), 0, length, 18);
            }
            wVar.setHint(spannableStringBuilder);
        }
        if (this.jsQ.jxj != null) {
            Typeface create = Typeface.create("sans-serif", com.tencent.mm.plugin.appbrand.widget.input.a.c.rr(this.jsQ.jxj).style);
            if (create != null) {
                this.jsS.setTypeface(create);
            }
        }
        if (this.jsQ.jwX != null) {
            this.jsS.r(bg.mz(this.jsQ.jwX));
            if (ad.b(this.jsQ.jxt) && this.jsS != null) {
                Yx();
            }
        }
        if (this.jsQ.jxk == null) {
            this.jsQ.jxk = Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.map.c.CTRL_INDEX);
        } else if (this.jsQ.jxk.intValue() <= 0) {
            this.jsQ.jxk = Integer.valueOf(Integer.MAX_VALUE);
        }
        com.tencent.mm.ui.tools.a.c Ch = n.a(this.jsS).Ch(this.jsQ.jxk.intValue());
        Ch.wpp = false;
        Ch.jtV = com.tencent.mm.ui.tools.h.a.wmF;
        Ch.a(this.jsr);
        this.jsS.cx(this.jsQ.jwT);
        if (this.jsQ.jxp == null || !this.jsQ.jxp.booleanValue()) {
            this.jsS.setEnabled(true);
            this.jsS.setClickable(true);
        } else {
            this.jsS.setEnabled(false);
            this.jsS.setFocusable(false);
            this.jsS.setFocusableInTouchMode(false);
            this.jsS.setClickable(false);
        }
        com.tencent.mm.plugin.appbrand.widget.input.a.g.rs(this.jsQ.jxe).a(this.jsS);
        if (ad.b(this.jsQ.jxq)) {
            this.jsS.setVisibility(8);
        } else {
            this.jsS.setVisibility(0);
        }
        if (this.jsQ.jxu != null) {
            this.jsS.jvd = this.jsQ.jxu.booleanValue();
        }
        if (this.jsS != null && (this.jsS instanceof o)) {
            o oVar;
            if (this.jsQ.jxy != null) {
                oVar = (o) this.jsS;
                oVar.setLineSpacing((float) this.jsQ.jxy.intValue(), oVar.jub);
            }
            if (this.jsQ.jxz != null) {
                oVar = (o) this.jsS;
                float intValue = (float) this.jsQ.jxz.intValue();
                if (intValue > 0.0f) {
                    oVar.a(intValue, true);
                }
            }
        }
    }

    private void iL(int i) {
        if (this.jsS != null && this.jsS.getEditableText() != null && i > -2) {
            if (-1 == i) {
                i = this.jsS.getEditableText().length();
            }
            this.jsS.setSelection(i);
            Yy();
        }
    }

    public final void Yx() {
        if (this.jsS != null) {
            if (this.jsS.getLineCount() != this.jsN || this.jsS.Zj() != this.jsO) {
                Object obj = this.jsN == -1 ? 1 : null;
                this.jsN = this.jsS.getLineCount();
                this.jsO = this.jsS.Zj();
                if (this.jsK != null) {
                    this.jsK.bo(this.jsN, this.jsO);
                }
                if (this.jsQ.jxr.booleanValue() && obj == null) {
                    Yw();
                    Yy();
                }
            }
        }
    }

    public final void Yy() {
        if (this.jsQ.jxr.booleanValue() && this.jsT != null && this.jsT.isShown() && this.jsS != null && this.jsS == this.jsT.juK) {
            i.a(this.iNd).YG();
        }
    }

    public final void Yz() {
        if (this.jsQ.jxr.booleanValue()) {
            YC();
        }
        if (this.jsT != null && this.jsS != null) {
            this.jsT.juK = this.jsS;
            v vVar = this.jsT;
            boolean z = (this.jsQ.jxs != null && this.jsQ.jxs.booleanValue()) || (this.jsQ.jxr != null && this.jsQ.jxr.booleanValue());
            vVar.cz(z);
            YA();
            if (com.tencent.mm.plugin.appbrand.ui.g.bF(this.jsS) && this.jsS.hasFocus()) {
                this.jsT.show();
            }
        }
    }

    private boolean a(w wVar, int i, int i2, int i3, int i4) {
        if (wVar == null || this.iNd == null || this.iNd.get() == null) {
            return false;
        }
        w.d("MicroMsg.AppBrandInputInvokeHandler", "[TextAreaHeight] %d", new Object[]{Integer.valueOf(i2)});
        e eVar = ((m) this.iNd.get()).jdd;
        return eVar != null && eVar.b(((m) this.iNd.get()).jde, wVar, i, i2, i3, i4);
    }

    final void a(w wVar) {
        if (wVar != null) {
            wVar.b(this.jsM);
            m mVar = this.iNd == null ? null : (m) this.iNd.get();
            if (mVar != null) {
                e eVar = mVar.jdd;
                if (eVar != null) {
                    eVar.bM(wVar);
                }
            }
        }
    }

    public final void YA() {
        if (this.jsT != null) {
            this.jsT.juA = this.jta;
            this.jsT.juB = this.jtb;
            this.jsT.juD = this.jtc;
        }
    }

    final void ct(boolean z) {
        if (this.jsS != null) {
            b(this.jsS.getText().toString(), this.jsS.getSelectionEnd(), this.jsP == d.jti, z);
        }
    }

    public final void YB() {
        boolean z = this.jsP == d.jti && ad.b(this.jsQ.jxx);
        if (!z) {
            YD();
        }
        if (this.iNd != null && this.iNd.get() != null && this.jsS != null) {
            if (this.jsS.hasFocus()) {
                ct(z);
            }
            if (!z) {
                i.a(this.iNd).YH();
                if (!(this.jsT == null || this.jsS == null)) {
                    this.jsT.b(this.jsS);
                }
            }
            if (this.jsQ.jwU) {
                if (!z) {
                    a(this.jsS);
                    onDestroy();
                }
            } else if (this.jsS != null) {
                this.jsS.setFocusable(false);
                this.jsS.setFocusableInTouchMode(false);
            }
        }
    }

    final v YC() {
        if (this.jsT != null) {
            return this.jsT;
        }
        if (this.iNd != null) {
            m mVar = (m) this.iNd.get();
            if (mVar != null) {
                v bT = v.bT(mVar.jbY);
                this.jsT = bT;
                return bT;
            }
        }
        return null;
    }

    public final void YD() {
        if (YC() != null) {
            this.jsT.hide();
        } else if (this.iNd != null) {
            Activity bB = com.tencent.mm.plugin.appbrand.ui.g.bB(((m) this.iNd.get()).mContext);
            if (!MMActivity.class.isInstance(bB) || !((MMActivity) bB).uSU.are()) {
            }
        }
    }

    private t Yt() {
        if (this.jsU != null) {
            return this.jsU;
        }
        if (this.iNd != null) {
            m mVar = (m) this.iNd.get();
            if (mVar != null) {
                t bR = t.bR(mVar.jbY);
                this.jsU = bR;
                return bR;
            }
        }
        return null;
    }

    public final void YE() {
        if (Yt() != null) {
            this.jsU.setVisibility(8);
        }
    }

    static {
        Map hashMap = new HashMap(3);
        hashMap.put("digit", Integer.valueOf(2));
        hashMap.put("number", Integer.valueOf(0));
        hashMap.put("idcard", Integer.valueOf(1));
        jtd = Collections.unmodifiableMap(hashMap);
    }
}
