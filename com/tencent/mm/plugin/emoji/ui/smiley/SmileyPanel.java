package com.tencent.mm.plugin.emoji.ui.smiley;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.qb;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.emoji.ui.smiley.e.AnonymousClass3;
import com.tencent.mm.plugin.emoji.ui.smiley.e.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.chat.f;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.protocal.c.baj;
import com.tencent.mm.protocal.c.bak;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.HorizontalListViewV2;
import java.util.Iterator;

public class SmileyPanel extends ChatFooterPanel implements a {
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanel";
    private boolean juQ = false;
    private e kTD;
    private f kTE;

    public SmileyPanel(Context context) {
        super(context, null);
        init();
    }

    public SmileyPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.kTE = new f();
        this.kTD = new e(getContext(), this.kTE, this);
    }

    public final void onResume() {
        w.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onResume");
        f fVar = this.kTE;
        fVar.kVi = true;
        fVar.aor();
        fVar.aoi();
        e eVar = this.kTD;
        eVar.anZ();
        eVar.aob();
    }

    public final void onPause() {
        w.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onPause");
        this.kTE.onPause();
    }

    public final void destroy() {
        w.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "onDestroy");
        this.sIy = null;
        if (this.kTD != null) {
            w.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "ui clear");
            e eVar = this.kTD;
            eVar.anY();
            eVar.kLX = null;
            if (eVar.kTR != null) {
                eVar.kTR.a(null);
            }
            w.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager destroy remove listener.");
            h.amc().kLb.f(eVar.kUh);
            h.amc().kLa.f(eVar.kLt);
            com.tencent.mm.sdk.b.a.urY.c(eVar.kLu);
            this.kTD = null;
        }
        if (this.kTE != null) {
            w.i("MicroMsg.emoji.SmileyPanel.SmileyPanel", "stg clear");
            this.kTE.onPause();
            f fVar = this.kTE;
            fVar.aoh();
            long currentTimeMillis = System.currentTimeMillis();
            baj com_tencent_mm_protocal_c_baj = new baj();
            if (!(fVar.kVq == null || fVar.kVq.isEmpty())) {
                for (String str : fVar.kVq.keySet()) {
                    bak com_tencent_mm_protocal_c_bak = new bak();
                    com_tencent_mm_protocal_c_bak.tgW = str;
                    com_tencent_mm_protocal_c_bak.tiI = ((Integer) fVar.kVq.get(str)).intValue();
                    com_tencent_mm_protocal_c_baj.ubu.add(com_tencent_mm_protocal_c_bak);
                }
                h.amc().kLd.a(com_tencent_mm_protocal_c_baj);
            }
            w.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "save Smiley TabMap use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            Iterator it = fVar.kVp.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar != null) {
                    dVar.kTE = null;
                    dVar.kTF = null;
                }
            }
            fVar.aoq();
        }
    }

    public final void a(f fVar) {
        super.a(fVar);
    }

    public final void dz(boolean z) {
        e eVar = this.kTD;
        if (eVar.kUb != null) {
            eVar.kUb.setEnabled(z);
        }
    }

    public final void anM() {
        w.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "dealOrientationChange");
        this.kTD.kTE.Xd = 0;
    }

    public final void anN() {
        this.sIy = null;
    }

    public final void refresh() {
        w.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "reflesh");
        try {
            if (this.kTE != null && this.kTD != null) {
                this.kTD.aoc();
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.emoji.SmileyPanel.SmileyPanel", e, "", new Object[0]);
        }
    }

    public final void anO() {
        w.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideCustomBtn");
        this.kTE.kVd = true;
    }

    public final void anP() {
        w.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "[hideDefaultBtn]");
        this.kTE.kVe = true;
    }

    public final void k(boolean z, boolean z2) {
        w.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideSmiley: %B, hideEmojiSmiley: %B", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        this.kTE.kVf = z;
        this.kTE.kVg = z2;
    }

    public final void dA(boolean z) {
        w.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "hideSendButton:B", new Object[]{Boolean.valueOf(z)});
        this.kTD.dB(z);
        this.kTE.kVj = true;
    }

    public final ChatFooterPanel.a anQ() {
        return this.sIy;
    }

    public final j anR() {
        return (j) this.sIz;
    }

    public final void lv(int i) {
        w.d("MicroMsg.emoji.SmileyPanel.SmileyPanel", "setPortHeightPx: %d", new Object[]{Integer.valueOf(i)});
        this.kTE.Xd = 0;
        f fVar = this.kTE;
        if (fVar.kUV != i) {
            fVar.kVo = false;
            fVar.kVn = false;
        }
        fVar.kUV = i;
        this.kTE.aoh();
        fVar = this.kTE;
        int i2 = i - this.kTE.kUK;
        f fVar2 = this.kTE;
        fVar.lB(i2 - (fVar2.kUt - fVar2.kUS));
        this.kTE.kUX = 0;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void setVisibility(int i) {
        int i2 = 0;
        super.setVisibility(i);
        if (i == 0) {
            this.juQ = false;
            if (this.kTD != null) {
                e eVar = this.kTD;
                w.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initView begin");
                if (this == null) {
                    return;
                }
                if (eVar.mView != null && getChildCount() > 0) {
                    w.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "already load view --- pass");
                    eVar.anX();
                    return;
                } else if (eVar.kTE == null) {
                    w.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "mPanelStg is null");
                    return;
                } else {
                    eVar.kTE.kVs = false;
                    if (eVar.mView == null) {
                        eVar.mView = View.inflate(eVar.ty, R.i.doJ, null);
                    } else if (eVar.mView.getParent() != null) {
                        ((ViewGroup) eVar.mView.getParent()).removeView(eVar.mView);
                    }
                    eVar.kTR = (SmileyPanelViewPager) eVar.findViewById(R.h.cFN);
                    eVar.kTR.kTE = eVar.kTE;
                    eVar.kTR.kVy = eVar;
                    eVar.kTR.b(eVar);
                    eVar.kTR.Cb(3);
                    eVar.kTE.kUX = eVar.kTR.getWidth();
                    eVar.kTT = (SmileyPanelScrollView) eVar.findViewById(R.h.cFK);
                    eVar.kTT.kUk = eVar;
                    eVar.kTT.kTj = eVar.kTE;
                    eVar.kTU = (HorizontalListViewV2) eVar.findViewById(R.h.cFI);
                    eVar.kTV = new h(eVar.kLX, eVar.kTE);
                    eVar.kTU.setAdapter(eVar.kTV);
                    eVar.kTU.setOnItemClickListener(eVar.kUi);
                    eVar.kUb = (TextView) eVar.findViewById(R.h.cCv);
                    eVar.kTX = (ImageView) eVar.findViewById(R.h.cyY);
                    eVar.kTX.setOnClickListener(eVar);
                    eVar.kTW = eVar.findViewById(R.h.cyX);
                    eVar.kTY = (ImageView) eVar.findViewById(R.h.cyZ);
                    eVar.kUb.setOnClickListener(eVar);
                    eVar.kUb.setVisibility(eVar.kTE.aol() ? 0 : 8);
                    addView(eVar.mView, new LayoutParams(-1, -1));
                    eVar.kTE.kVs = true;
                    View view = eVar.kTW;
                    int i3 = (eVar.kTE.kVd || eVar.kTE.kVe) ? 8 : 0;
                    view.setVisibility(i3);
                    eVar.kUa = (ImageButton) eVar.findViewById(R.h.bWj);
                    eVar.kUa.setOnClickListener(eVar);
                    ImageButton imageButton = eVar.kUa;
                    if (!(eVar.kTE.kVe && eVar.kTE.hPi == ChatFooterPanel.sID)) {
                        i2 = 8;
                    }
                    imageButton.setVisibility(i2);
                    return;
                }
            }
            w.w("MicroMsg.emoji.SmileyPanel.SmileyPanel", "Smiley Panel Manager is null.");
        } else if (this.kTE != null) {
            this.kTE.aoq();
        } else {
            w.w("MicroMsg.emoji.SmileyPanel.SmileyPanel", "Smiley PanelStg Manager is null.");
        }
    }

    public final void uF(String str) {
        this.kTE.kVa = str;
    }

    public final void uG(String str) {
        f fVar = this.kTE;
        fVar.uI(str);
        fVar.aoh();
        if (fVar.kVr == null) {
            fVar.kVr = new c<qb>(fVar) {
                final /* synthetic */ f kVt;

                {
                    this.kVt = r2;
                    this.usg = qb.class.getName().hashCode();
                }

                public final /* synthetic */ boolean a(b bVar) {
                    qb qbVar = (qb) bVar;
                    w.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "kv stat update click cell item");
                    g.oUh.A(11076, "1," + qbVar.fXf.fGa);
                    this.kVt.aoq();
                    return true;
                }
            };
        }
        w.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "add succeed send listener");
        com.tencent.mm.sdk.b.a.urY.b(fVar.kVr);
    }

    protected void onMeasure(int i, int i2) {
        if (this.juQ) {
            setVisibility(8);
            i = MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public final void anS() {
        this.kTE.kVl = true;
    }

    public final void anT() {
        if (this.kTD != null) {
            e eVar = this.kTD;
            String str = "TAG_DEFAULT_TAB";
            if (!(eVar.kTR == null || eVar.kTE == null)) {
                if (eVar.kUf) {
                    eVar.kUg = null;
                    eVar.kTR.post(new AnonymousClass3(eVar, str));
                } else {
                    eVar.kUg = str;
                }
            }
        }
        if (this.kTE != null) {
            ap.yY();
            com.tencent.mm.u.c.vr().set(-29414086, "TAG_DEFAULT_TAB");
        }
    }

    public final void lw(int i) {
        if (this.kTE != null) {
            this.kTE.hPi = i;
        }
    }
}
