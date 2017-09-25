package com.tencent.mm.plugin.search.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(19)
public abstract class FTSBaseVoiceSearchUI extends MMActivity implements b.a, c, p.a {
    String fRM;
    private p kaB;
    TextView mFc;
    private ae peL = new ae(this) {
        final /* synthetic */ FTSBaseVoiceSearchUI pfu;

        {
            this.pfu = r1;
        }

        public final void handleMessage(Message message) {
            if (message.what == 1 && !bg.mA(this.pfu.fRM)) {
                this.pfu.aZp();
            }
        }
    };
    ListView pfn;
    private b pfo;
    private boolean pfp = false;
    private VoiceSearchLayout pfs;
    private RelativeLayout pft;

    protected abstract b a(c cVar);

    protected abstract boolean aZB();

    public final /* bridge */ /* synthetic */ Context getContext() {
        return this.uSU.uTo;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bPY();
        qP("");
        aZu();
        this.kaB = new p();
        this.kaB.lK(true);
        this.kaB.a(this);
        this.kaB.sXA = aZB();
        this.pfn = (ListView) findViewById(R.h.cBb);
        if (agV() != null) {
            w.i("MicroMsg.FTS.FTSBaseMainUI", "searchResultLV addFooterView");
            this.pfn.addFooterView(agV());
        }
        this.pfo = a((c) this);
        this.pfo.pfm = this;
        this.pfn.setAdapter(this.pfo);
        this.pfn.setOnScrollListener(this.pfo);
        this.pfn.setOnItemClickListener(this.pfo);
        this.pfn.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ FTSBaseVoiceSearchUI pfu;

            {
                this.pfu = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.pfu.kaB.clearFocus();
                this.pfu.aHf();
                return false;
            }
        });
        if (aZB()) {
            this.pfs = new VoiceSearchLayout(this);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(14);
            this.pfs.setLayoutParams(layoutParams);
            this.pfs.xo(b.a(this, 100.0f));
            this.pfs.lmQ.findViewById(R.h.cNy).setBackgroundResource(0);
            this.pfs.setVisibility(8);
            this.kaB.o(this.pfs);
            this.pft = (RelativeLayout) findViewById(R.h.cND);
            this.pft.addView(this.pfs);
        }
        this.mFc = (TextView) findViewById(R.h.coq);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FTSBaseVoiceSearchUI pfu;

            {
                this.pfu = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pfu.finish();
                return true;
            }
        });
    }

    protected void aZu() {
    }

    protected View agV() {
        return null;
    }

    public final void aej() {
        w.d("MicroMsg.FTS.FTSBaseMainUI", "onVoiceSearchStart");
        aZC();
    }

    public final void aek() {
        w.d("MicroMsg.FTS.FTSBaseMainUI", "onVoiceSearchCancel");
        aZD();
    }

    public void a(boolean z, String[] strArr, long j, int i) {
        w.d("MicroMsg.FTS.FTSBaseMainUI", "onVoiceReturn");
        aZD();
    }

    public final void OE() {
        w.d("MicroMsg.FTS.FTSBaseMainUI", "onEnterSearch");
    }

    public final void OD() {
        w.d("MicroMsg.FTS.FTSBaseMainUI", "onQuitSearch");
        finish();
    }

    public final void mR(String str) {
        w.d("MicroMsg.FTS.FTSBaseMainUI", "onSearchChange %s", new Object[]{str});
        if (bg.mA(str)) {
            if (!this.kaB.bZu()) {
                this.kaB.bZv();
                aHj();
            }
            aZA();
        }
        String wY = d.wY(str);
        if (bg.mA(this.fRM) || !this.fRM.equals(wY)) {
            this.fRM = wY;
            if (bg.mA(this.fRM)) {
                this.peL.removeMessages(1);
                this.pfp = false;
                this.pfo.stopSearch();
                aZA();
                return;
            }
            this.peL.removeMessages(1);
            this.peL.sendEmptyMessageDelayed(1, 300);
            return;
        }
        w.i("MicroMsg.FTS.FTSBaseMainUI", "Same query %s %s", new Object[]{this.fRM, wY});
    }

    public final void OF() {
    }

    public boolean mQ(String str) {
        w.d("MicroMsg.FTS.FTSBaseMainUI", "onSearchKeyDown %s", new Object[]{str});
        aHf();
        if (this.kaB != null) {
            this.kaB.clearFocus();
        }
        return false;
    }

    protected void aZp() {
        this.pfp = true;
        this.pfo.DX(this.fRM);
        aZx();
    }

    protected void aZC() {
        this.mFc.setVisibility(8);
        if (this.pft != null) {
            this.pft.setVisibility(0);
        }
        this.pfn.setVisibility(8);
    }

    protected void aZD() {
        this.mFc.setVisibility(8);
        if (this.pft != null) {
            this.pft.setVisibility(8);
        }
        this.pfn.setVisibility(8);
    }

    protected void aZx() {
        this.mFc.setVisibility(8);
        if (this.pft != null) {
            this.pft.setVisibility(8);
        }
        this.pfn.setVisibility(8);
    }

    protected void aZy() {
        this.mFc.setVisibility(0);
        this.mFc.setText(f.a(getString(R.l.ePC), getString(R.l.ePB), com.tencent.mm.plugin.fts.d.b.a.d(this.fRM, this.fRM)).mdL);
        if (this.pft != null) {
            this.pft.setVisibility(8);
        }
        this.pfn.setVisibility(8);
    }

    protected void aZz() {
        this.mFc.setVisibility(8);
        if (this.pft != null) {
            this.pft.setVisibility(8);
        }
        this.pfn.setVisibility(0);
    }

    protected void aZA() {
        this.mFc.setVisibility(8);
        if (this.pft != null) {
            this.pft.setVisibility(8);
        }
        this.pfn.setVisibility(8);
    }

    protected void onPause() {
        super.onPause();
        this.kaB.cancel();
        this.kaB.clearFocus();
    }

    protected void onDestroy() {
        this.peL.removeMessages(1);
        this.pfo.finish();
        super.onDestroy();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.kaB.a(this, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.kaB.a(this, menu);
        return true;
    }

    public void M(int i, boolean z) {
        w.i("MicroMsg.FTS.FTSBaseMainUI", "onEnd resultCount=%d | isFinished=%b", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
        if (z) {
            aZF();
            if (i > 0) {
                aZz();
            } else {
                aZy();
            }
        } else if (i > 0) {
            aZz();
            aZE();
        } else {
            aZx();
            aZF();
        }
        if (this.pfp) {
            this.pfp = false;
            this.pfn.setSelection(0);
        }
    }

    protected void aZE() {
    }

    protected void aZF() {
    }

    public final void OG() {
    }
}
