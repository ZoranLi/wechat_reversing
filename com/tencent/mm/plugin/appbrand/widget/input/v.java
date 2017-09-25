package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.v4.view.z;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.ui.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;

public final class v extends LinearLayout implements a {
    private static final int jtC = R.h.bpb;
    private static final a juM = new e();
    private MMActivity fCi;
    c juA;
    b juB;
    private boolean juC = false;
    d juD;
    private AppBrandSmileyPanel juE;
    private f juF;
    private ImageButton juG;
    private boolean juH;
    private View juI;
    private boolean juJ;
    public EditText juK;
    private int juL = 0;
    private final Runnable juz = new Runnable(this) {
        final /* synthetic */ v juN;

        {
            this.juN = r1;
        }

        public final void run() {
            if (this.juN.juE != null && z.al(this.juN.juE)) {
                if (this.juN.juE.YW()) {
                    w.d("MicroMsg.AppBrandSmileyPanelWrapper", "postMeasure inLayout, skip");
                    this.juN.post(this);
                    return;
                }
                v.b(this.juN);
            }
        }
    };
    private int state = 2;

    interface a {
        void c(v vVar, int i);

        void l(v vVar);

        void m(v vVar);

        void n(v vVar);

        void o(v vVar);
    }

    public interface b {
        void cu(boolean z);
    }

    public interface c {
        boolean rl(String str);
    }

    public interface d {
        void iM(int i);
    }

    private static final class f extends FrameLayout {
        boolean juQ = false;

        public f(Context context) {
            super(context);
            LayoutInflater.from(context).inflate(R.i.cUN, this);
        }

        protected final void onMeasure(int i, int i2) {
            if (this.juQ || !isShown()) {
                i = MeasureSpec.makeMeasureSpec(0, 1073741824);
                i2 = MeasureSpec.makeMeasureSpec(0, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }

    private static final class e implements a {
        public final void l(v vVar) {
            if (vVar.isShown()) {
                vVar.juE.setVisibility(0);
            }
            vVar.juE.bAi();
        }

        public final void m(v vVar) {
            if (g.bF(vVar)) {
                vVar.iU(8);
                vVar.Zc();
                return;
            }
            if (vVar.isShown()) {
                vVar.juE.setVisibility(0);
            }
            if (vVar.juH) {
                vVar.juE.bAh();
            } else {
                vVar.juE.bAi();
            }
        }

        public final void c(v vVar, int i) {
            if (g.bF(vVar)) {
                vVar.iU(8);
            } else if (vVar.juE != null && i > 0) {
                vVar.iS(i);
            }
        }

        public final void n(v vVar) {
            vVar.fCi.aHj();
            vVar.YD();
        }

        public final void o(v vVar) {
            vVar.fCi.aHf();
            vVar.Zd();
            vVar.iO(j.aD(vVar.fCi));
        }
    }

    static /* synthetic */ void b(v vVar) {
        w.v("MicroMsg.AppBrandSmileyPanelWrapper", "[scrollUp] forceMeasurePanel enter");
        vVar.juE.requestLayout();
    }

    public static v bT(View view) {
        return (v) view.getRootView().findViewById(jtC);
    }

    public static v bU(View view) {
        l bN = l.bN(view);
        if (bN.jtH == null || !(bN.jtH instanceof s)) {
            bN.jtH = new s();
        }
        v bT = bT(view);
        if (bT != null) {
            return bT;
        }
        View vVar = new v(view.getContext());
        bN.bO(vVar);
        return vVar;
    }

    public final void iO(int i) {
        juM.c(this, i);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        w.v("MicroMsg.AppBrandSmileyPanelWrapper", "[scrollUp] SoftKeyboardPanel onLayout measuredHeight = %d", new Object[]{Integer.valueOf(getMeasuredHeight())});
    }

    public final void cy(boolean z) {
        w.d("MicroMsg.AppBrandSmileyPanelWrapper", "onKeyboardStateChanged, kbShown = %b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            iU(0);
            YD();
        } else if (!isShown()) {
        } else {
            if (this.juH && 1 == this.state) {
                Zd();
            } else {
                hide();
            }
        }
    }

    private void iS(int i) {
        Object obj;
        AppBrandSmileyPanel appBrandSmileyPanel = this.juE;
        if (i <= 0 || appBrandSmileyPanel.jut == i) {
            obj = null;
        } else {
            appBrandSmileyPanel.jut = i;
            obj = 1;
        }
        if (obj != null) {
            this.juz.run();
        }
    }

    public final int getMinimumHeight() {
        return getVisibility() == 0 ? com.tencent.mm.bg.a.fromDPToPix(getContext(), 48) : 0;
    }

    private void cu(boolean z) {
        if (!this.juC && this.juB != null) {
            this.juC = true;
            this.juB.cu(z);
            this.juC = false;
        }
    }

    private v(Context context) {
        super(context);
        this.fCi = (MMActivity) context;
        super.setId(jtC);
        setOrientation(1);
        this.juF = new f(getContext());
        f fVar = this.juF;
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842913}, ab.getResources().getDrawable(R.k.dzV));
        stateListDrawable.addState(new int[0], ab.getResources().getDrawable(R.k.dzU));
        this.juG = (ImageButton) fVar.findViewById(R.h.cFQ);
        this.juG.setSelected(false);
        this.juG.setImageDrawable(stateListDrawable);
        this.juG.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ v juN;

            {
                this.juN = r1;
            }

            public final void onClick(View view) {
                if (view.isSelected()) {
                    v.juM.n(this.juN);
                    view.setSelected(false);
                    return;
                }
                v.juM.o(this.juN);
                view.setSelected(true);
            }
        });
        this.juI = fVar.findViewById(R.h.cFP);
        this.juI.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ v juN;

            {
                this.juN = r1;
            }

            public final void onClick(View view) {
                this.juN.cu(true);
            }
        });
        addView(this.juF);
        this.juE = new AppBrandSmileyPanel(getContext());
        this.juE.setVisibility(8);
        this.juE.setBackgroundColor(0);
        this.juE.a(new com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel.a(this) {
            final /* synthetic */ v juN;

            {
                this.juN = r1;
            }

            public final void append(String str) {
                if (this.juN.juA != null) {
                    this.juN.juA.rl(str);
                }
            }

            public final void Zh() {
                if (this.juN.juA != null) {
                    this.juN.juA.rl("[DELETE_EMOTION]");
                }
            }
        });
        addView(this.juE);
        Ze();
    }

    public final void setId(int i) {
    }

    private void Za() {
        ((s) l.bN(this).jtH).jun = this;
    }

    private void Zb() {
        ((s) l.bN(this).jtH).jun = null;
    }

    private void iT(final int i) {
        final boolean z = this.juC;
        post(new Runnable(this) {
            final /* synthetic */ v juN;

            public final void run() {
                int e = this.juN.state;
                if (this.juN.isShown()) {
                    this.juN.state = i;
                } else {
                    this.juN.state = 2;
                }
                if (this.juN.juD != null && e != this.juN.state && !z) {
                    this.juN.juD.iM(this.juN.state);
                }
            }
        });
    }

    private void Zc() {
        YD();
        if (this.juK != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.juK.getContext().getSystemService("input_method");
            if (!inputMethodManager.showSoftInput(this.juK, 1)) {
                inputMethodManager.showSoftInput(this.juK, 2);
                return;
            }
            return;
        }
        this.fCi.aHj();
    }

    private void Zd() {
        juM.m(this);
        this.juG.setSelected(true);
        iT(1);
    }

    private void YD() {
        juM.l(this);
        this.juG.setSelected(false);
        iT(0);
    }

    private void Ze() {
        Object obj = 1;
        if (this.juF != null) {
            f fVar = this.juF;
            boolean z = ((!this.juH ? 1 : 0) & (!this.juJ ? 1 : 0)) != 0 || g.bF(this);
            if (z == fVar.juQ) {
                obj = null;
            }
            fVar.juQ = z;
            if (obj == null) {
                return;
            }
            if (VERSION.SDK_INT < 18 || !fVar.isInLayout()) {
                fVar.requestLayout();
            }
        }
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        w.d("MicroMsg.AppBrandSmileyPanelWrapper", "smileyPanelWrapper, onMeasure");
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Za();
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        iU(8);
        if (this.fCi != null) {
            if (this.juK != null) {
                this.fCi.cY(this.juK);
            } else {
                this.fCi.aHf();
            }
        }
        this.juE.onDestroy();
        this.juG.setOnClickListener(null);
        this.juA = null;
        removeAllViews();
        this.fCi = null;
        Zb();
    }

    public final void setVisibility(int i) {
        if (i == 8) {
            if (getVisibility() != i) {
                cu(false);
            }
            hide();
        } else if (i == 0) {
            show();
        } else {
            iU(i);
        }
    }

    final void iU(int i) {
        if (i == 0 && g.bF(this)) {
            i = 8;
        }
        if (getVisibility() != i) {
            super.setVisibility(i);
            if (i == 0) {
                Za();
            } else {
                Zb();
            }
        }
    }

    public final void Zf() {
        int i = 0;
        this.juH = false;
        if (this.juG != null) {
            ImageButton imageButton = this.juG;
            if (!this.juH) {
                i = 4;
            }
            imageButton.setVisibility(i);
        }
        Ze();
    }

    public final void cz(boolean z) {
        this.juJ = z;
        if (this.juI != null) {
            this.juI.setVisibility(this.juJ ? 0 : 4);
        }
        Ze();
    }

    public final void b(EditText editText) {
        if (editText == this.juK) {
            this.juK = null;
        }
    }

    public final void show() {
        Zc();
        Zf();
        cz(this.juJ);
        Ze();
        if (!isShown()) {
            iU(0);
        }
        iS(j.aD(getContext()));
    }

    public final void hide() {
        if (isShown()) {
            iU(8);
            if (!(this.fCi == null || this.fCi.uSU.are())) {
                ad.bY(this).hideSoftInputFromWindow(getWindowToken(), 0);
            }
            YD();
        }
    }
}
