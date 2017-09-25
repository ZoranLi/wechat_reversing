package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.as.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.a;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.b;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.p;
import java.util.ArrayList;
import java.util.List;

public abstract class MMBaseSelectContactUI extends MMActivity implements OnItemClickListener, a, b, c, VerticalScrollBar.a, l, p.b {
    public p kww;
    public MultiSelectContactView nyd;
    public ListView oCR;
    private View pwq;
    public int scene;
    private AlphabetScrollBar vYi;
    private o vYj;
    public m vYk;
    private o vYl;
    private View vYm;
    private View vYn;
    private TextView vYo;
    private LabelContainerView vYp;
    private TextView vYq;
    private MMTagPanel vYr;
    private boolean vYs = true;
    private List<String> vYt = new ArrayList();

    public abstract boolean Of();

    public abstract boolean Og();

    public abstract String Oh();

    public abstract o Oi();

    public abstract m Oj();

    static /* synthetic */ void b(MMBaseSelectContactUI mMBaseSelectContactUI) {
        mMBaseSelectContactUI.bYg();
        mMBaseSelectContactUI.vYn.setVisibility(0);
        if (!bg.mA(mMBaseSelectContactUI.bYd()) && mMBaseSelectContactUI.vYo != null) {
            mMBaseSelectContactUI.vYo.setText(f.a(mMBaseSelectContactUI.getString(R.l.ePC), mMBaseSelectContactUI.getString(R.l.ePB), com.tencent.mm.plugin.fts.d.b.a.d(mMBaseSelectContactUI.bYd(), mMBaseSelectContactUI.bYd())).mdL);
        }
    }

    static /* synthetic */ void c(MMBaseSelectContactUI mMBaseSelectContactUI) {
        w.i("MicroMsg.MMBaseSelectContactUI", "setSearchStatus");
        mMBaseSelectContactUI.a(mMBaseSelectContactUI.oCR, 8);
        mMBaseSelectContactUI.oCR.setAdapter(mMBaseSelectContactUI.vYk);
        mMBaseSelectContactUI.vYk.notifyDataSetChanged();
        if (mMBaseSelectContactUI.Og() && mMBaseSelectContactUI.vYi != null) {
            mMBaseSelectContactUI.vYi.setVisibility(8);
        }
        mMBaseSelectContactUI.vYn.setVisibility(8);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.i("MicroMsg.MMBaseSelectContactUI", "onCreate!");
        if (ap.zb()) {
            Oe();
            w.i("MicroMsg.MMBaseSelectContactUI", "initData done!");
            KC();
            w.i("MicroMsg.MMBaseSelectContactUI", "initView done!");
            return;
        }
        w.e("MicroMsg.MMBaseSelectContactUI", "onCreate acc not ready finish");
        w.bIQ();
        finish();
    }

    public final n bYb() {
        if (this.oCR.getHeaderViewsCount() > 0) {
            return (n) ((HeaderViewListAdapter) this.oCR.getAdapter()).getWrappedAdapter();
        }
        return (n) this.oCR.getAdapter();
    }

    public final ListView bcW() {
        return this.oCR;
    }

    public o bYc() {
        return this.vYj;
    }

    public void Oe() {
        this.scene = getIntent().getIntExtra("scene", 0);
    }

    public void KC() {
        qP(Oh());
        this.oCR = (ListView) findViewById(R.h.cBN);
        this.vYj = Oi();
        this.vYk = Oj();
        this.pwq = findViewById(R.h.cDy);
        if (bYj()) {
            this.vYn = findViewById(R.h.coq);
            this.vYo = (TextView) findViewById(R.h.cop);
            this.vYn.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ MMBaseSelectContactUI vYu;

                {
                    this.vYu = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    this.vYu.bYg();
                    this.vYu.bYh();
                    this.vYu.bYi();
                    return false;
                }
            });
            if (Of()) {
                this.kww = new p(true, true);
                this.kww.woe = this;
                a(this.kww);
            } else {
                this.nyd = (MultiSelectContactView) findViewById(R.h.bFV);
                this.nyd.measure(MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().widthPixels, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels, Integer.MIN_VALUE));
                this.nyd.sJy = this;
                this.nyd.sJz = this;
                this.nyd.sJx = this;
                this.nyd.setVisibility(0);
                this.vYm = new View(this.uSU.uTo);
                this.vYm.setLayoutParams(new LayoutParams(-1, this.nyd.getMeasuredHeight()));
                this.vYm.setVisibility(4);
                this.oCR.addHeaderView(this.vYm);
                findViewById(R.h.cqD).setVisibility(0);
            }
        }
        a(this.oCR, 0);
        this.oCR.setAdapter(this.vYj);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MMBaseSelectContactUI vYu;

            {
                this.vYu = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vYu.aIP();
                return true;
            }
        });
        if (this.vYk != null) {
            this.vYk.a(new m.a(this) {
                final /* synthetic */ MMBaseSelectContactUI vYu;

                {
                    this.vYu = r1;
                }

                public final void r(String str, int i, boolean z) {
                    w.i("MicroMsg.MMBaseSelectContactUI", "Callback SearchEnd Count=%d", Integer.valueOf(i));
                    if (!z || i != 0) {
                        MMBaseSelectContactUI.c(this.vYu);
                    } else if (bg.mA(str)) {
                        this.vYu.bYg();
                    } else {
                        MMBaseSelectContactUI.b(this.vYu);
                    }
                }
            });
        }
        this.oCR.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ MMBaseSelectContactUI vYu;

            {
                this.vYu = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0) {
                    this.vYu.aHf();
                    this.vYu.bYi();
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!(this.vYu.Of() || this.vYu.nyd == null)) {
                    View childAt = this.vYu.oCR.getChildAt(this.vYu.oCR.getFirstVisiblePosition());
                    if (childAt == null || childAt.getTop() != 0) {
                        this.vYu.pwq.setVisibility(0);
                    } else {
                        this.vYu.pwq.setVisibility(8);
                    }
                }
                if (i >= 2) {
                    ap.yY();
                    if (!bg.f((Boolean) com.tencent.mm.u.c.vr().get(12296, null))) {
                        ap.yY();
                        com.tencent.mm.u.c.vr().set(12296, Boolean.valueOf(true));
                        if (this.vYu.vYl != null) {
                            this.vYu.vYl.dismiss();
                        }
                        this.vYu.vYl = s.a(this.vYu, this.vYu.getString(R.l.ezp), 4000);
                    }
                }
            }
        });
        this.oCR.setOnItemClickListener(this);
        if (Og()) {
            this.vYi = (AlphabetScrollBar) findViewById(R.h.cBP);
            this.vYi.setVisibility(0);
            this.vYi.vpW = this;
        }
        if (aJR()) {
            this.vYp = (LabelContainerView) findViewById(R.h.cBM);
            this.vYq = (TextView) this.vYp.findViewById(16908310);
            this.vYq.setText(R.l.evG);
            this.vYr = (MMTagPanel) this.vYp.findViewById(R.h.bFU);
            this.vYr.mUH = R.g.bks;
            this.vYr.mUI = R.e.aVo;
            this.vYp.vYd = new LabelContainerView.a(this) {
                final /* synthetic */ MMBaseSelectContactUI vYu;

                {
                    this.vYu = r1;
                }

                public final void aoG() {
                    if (this.vYu.nyd != null) {
                        this.vYu.nyd.clearFocus();
                    }
                    if (this.vYu.kww != null) {
                        this.vYu.kww.clearFocus();
                        this.vYu.kww.bZQ();
                    }
                    this.vYu.vYp.requestFocus();
                    this.vYu.vYp.setVisibility(8);
                }

                public final void aoH() {
                    this.vYu.aHf();
                }
            };
            this.vYr.vmJ = new MMTagPanel.a(this) {
                final /* synthetic */ MMBaseSelectContactUI vYu;

                {
                    this.vYu = r1;
                }

                public final void uM(String str) {
                }

                public final void uN(String str) {
                    this.vYu.Ac(str);
                }

                public final void uO(String str) {
                }

                public final void h(boolean z, int i) {
                }

                public final void aoI() {
                }

                public final void uP(String str) {
                }

                public final void uQ(String str) {
                }
            };
        }
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = i - this.oCR.getHeaderViewsCount();
        if (headerViewsCount >= 0) {
            com.tencent.mm.ui.contact.a.a BL = bYb().BL(headerViewsCount);
            BL.Ob().Od();
            if (BL.wal) {
                int f = g.f(BL.mdk, BL.mdl, BL.ayg());
                switch (BL.mdk) {
                    case 65536:
                        headerViewsCount = 5;
                        break;
                    case WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT /*131072*/:
                        headerViewsCount = 2;
                        break;
                    case 131075:
                        headerViewsCount = 3;
                        break;
                    case 131076:
                        headerViewsCount = 4;
                        break;
                    default:
                        headerViewsCount = 0;
                        break;
                }
                if (BL.wak) {
                    headerViewsCount = 1;
                }
                if (BL.knu == 5) {
                    headerViewsCount = 7;
                }
                w.v("MicroMsg.SelectContactReportLogic", "reportClick: %s", String.format("%s,%d,%d,%d,%d", new Object[]{BL.fRM, Integer.valueOf(BL.scene), Integer.valueOf(headerViewsCount), Integer.valueOf(BL.mdf), Integer.valueOf(f)}));
                com.tencent.mm.plugin.report.service.g.oUh.A(13234, r0);
            }
        }
        if (!bYb().BM(i)) {
            hf(i);
        }
    }

    public void hf(int i) {
    }

    private String bYd() {
        if (this.kww != null) {
            return this.kww.bzZ();
        }
        if (this.nyd != null) {
            return this.nyd.bzZ();
        }
        return "";
    }

    private void bYe() {
        boolean bZu = this.kww != null ? this.kww.bZu() : this.nyd != null ? this.nyd.hasFocus() : false;
        if (bZu && bg.mA(bYd())) {
            if (this.vYt == null || this.vYt.size() <= 0) {
                this.vYp.setVisibility(8);
                return;
            }
            this.vYp.setVisibility(0);
            this.vYr.a(null, this.vYt);
        } else if (this.vYp != null) {
            this.vYp.setVisibility(8);
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.vYl != null) {
            this.vYl.dismiss();
        }
    }

    protected void onResume() {
        super.onResume();
        if (aJR() && this.vYs) {
            this.vYs = false;
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ MMBaseSelectContactUI vYu;

                {
                    this.vYu = r1;
                }

                public final void run() {
                    this.vYu.vYt = com.tencent.mm.plugin.label.a.a.aFG().aFB();
                    this.vYu.vYs = true;
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass7 vYv;

                        {
                            this.vYv = r1;
                        }

                        public final void run() {
                            this.vYv.vYu.bYe();
                        }
                    });
                }

                public final String toString() {
                    return super.toString() + "|updateLabelList";
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.vYi != null) {
            this.vYi.vpW = null;
        }
        if (this.vYj != null) {
            this.vYj.finish();
        }
        if (this.vYk != null) {
            this.vYk.finish();
        }
        if (this.vYl != null) {
            this.vYl.dismiss();
        }
    }

    public int getLayoutId() {
        return R.i.djr;
    }

    public final void zE(String str) {
        w.i("MicroMsg.MMBaseSelectContactUI", "onSearchTextChange: text=%s", str);
        if (aJR()) {
            bYe();
        }
        if (this.vYk == null) {
            return;
        }
        if (bg.mA(str)) {
            this.vYk.QZ();
            this.vYk.notifyDataSetChanged();
            bYg();
            return;
        }
        this.vYk.a(str, aIO(), bYf());
    }

    public final void bEr() {
        if (aJR()) {
            bYe();
        }
    }

    public int[] aIO() {
        return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075};
    }

    public void a(ListView listView, int i) {
    }

    public void aIP() {
        aHf();
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            aIP();
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void sd(String str) {
        if (this.vYj != null) {
            int TM = this.vYj.TM(str);
            if (TM == 0) {
                this.oCR.setSelection(0);
            } else if (TM <= 0) {
                w.i("MicroMsg.MMBaseSelectContactUI", "Select unkown head selectPosition=%d | header=%s", Integer.valueOf(TM), str);
            } else if (Of()) {
                this.oCR.setSelection(TM);
            } else if (this.nyd != null) {
                this.oCR.setSelectionFromTop(TM, this.nyd.getMeasuredHeight());
            }
        }
    }

    public final boolean mQ(String str) {
        return false;
    }

    public final void mR(String str) {
        w.i("MicroMsg.MMBaseSelectContactUI", "onSearchChange: searchText=%s", str);
        if (aJR()) {
            if (this.kww != null) {
                this.kww.bZv();
            }
            bYe();
        }
        if (bg.mA(str)) {
            this.vYk.QZ();
            this.vYk.notifyDataSetChanged();
            bYg();
            return;
        }
        this.vYk.a(str, aIO(), bYf());
    }

    public boolean bYf() {
        return false;
    }

    public final void OD() {
        bYg();
        if (aJR()) {
            bYe();
        }
    }

    public final void OE() {
    }

    private void bYg() {
        w.i("MicroMsg.MMBaseSelectContactUI", "setInitStatus");
        a(this.oCR, 0);
        this.oCR.setAdapter(this.vYj);
        this.vYj.notifyDataSetChanged();
        if (Og() && this.vYi != null) {
            this.vYi.setVisibility(0);
        }
        this.vYn.setVisibility(8);
    }

    public void mK(String str) {
    }

    public boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        return false;
    }

    public boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        return false;
    }

    public final Activity getActivity() {
        return this;
    }

    public boolean aJR() {
        return false;
    }

    public void Ac(String str) {
        w.i("MicroMsg.MMBaseSelectContactUI", "select label=%s", str);
    }

    public final void bYh() {
        if (this.kww != null) {
            if (!bg.mA(this.kww.bzZ())) {
                p pVar = this.kww;
                if (pVar.wod != null) {
                    pVar.wod.lH(true);
                }
            }
        } else if (this.nyd != null && !bg.mA(this.nyd.bzZ())) {
            this.nyd.sJt.setText("");
        }
    }

    public final void bYi() {
        if (this.kww != null) {
            if (this.kww.bZu()) {
                this.kww.clearFocus();
            }
        } else if (this.nyd != null && this.nyd.hasFocus()) {
            this.nyd.clearFocus();
        }
    }

    public final void OF() {
    }

    public final void OG() {
    }

    public boolean bYj() {
        return this.vYk != null;
    }
}
