package com.tencent.mm.plugin.search.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.plugin.search.ui.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.fts.widget.FTSEditTextView;
import com.tencent.mm.ui.fts.widget.a.b;
import java.util.List;

public abstract class FTSBaseUI extends MMActivity implements a, c, FTSEditTextView.a, com.tencent.mm.ui.fts.widget.a.a {
    String fRM;
    private TextView mFc;
    private ae peL = new ae(this) {
        final /* synthetic */ FTSBaseUI pfr;

        {
            this.pfr = r1;
        }

        public final void handleMessage(Message message) {
            if (message.what == 1 && !bg.mA(this.pfr.fRM)) {
                this.pfr.aZp();
            }
        }
    };
    ListView pfn;
    private b pfo;
    private boolean pfp = false;
    com.tencent.mm.ui.fts.widget.a pfq;

    protected abstract b a(c cVar);

    public final /* bridge */ /* synthetic */ Context getContext() {
        return this.uSU.uTo;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bPY();
        qP("");
        aZu();
        this.pfq = new com.tencent.mm.ui.fts.widget.a(this);
        this.pfq.wiG = this;
        this.pfq.wiF.GR(getHint());
        this.pfq.wiF.wih = this;
        this.pfq.wiF.wif = false;
        cO().cP().setCustomView(this.pfq);
        this.pfn = (ListView) findViewById(R.h.cBb);
        this.pfo = a((c) this);
        this.pfo.pfm = this;
        this.pfn.setAdapter(this.pfo);
        this.pfn.setOnScrollListener(this.pfo);
        this.pfn.setOnItemClickListener(this.pfo);
        this.pfn.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ FTSBaseUI pfr;

            {
                this.pfr = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.pfr.pfq.wiF.vqz.clearFocus();
                this.pfr.aHf();
                return false;
            }
        });
        this.mFc = (TextView) findViewById(R.h.coq);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FTSBaseUI pfr;

            {
                this.pfr = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pfr.finish();
                return true;
            }
        });
    }

    protected void aZu() {
    }

    public String getHint() {
        return getString(R.l.dIz);
    }

    public void b(com.tencent.mm.plugin.fts.d.a.a aVar) {
    }

    public final void aZv() {
        finish();
    }

    public final void aZw() {
    }

    public void a(String str, String str2, List<b> list, FTSEditTextView.b bVar) {
        if (bVar == FTSEditTextView.b.UserInput) {
            String wY = d.wY(str);
            if (!bg.mA(this.fRM) && this.fRM.equals(wY)) {
                w.i("MicroMsg.FTS.FTSBaseUI", "Same query %s %s", new Object[]{this.fRM, wY});
            } else if (bg.mA(wY)) {
                stopSearch();
            } else {
                this.fRM = wY;
                this.peL.removeMessages(1);
                this.peL.sendEmptyMessageDelayed(1, 300);
            }
        }
    }

    protected void stopSearch() {
        this.fRM = "";
        this.peL.removeMessages(1);
        this.pfp = false;
        this.pfo.stopSearch();
        this.pfq.wiF.GR(getHint());
        aZA();
    }

    public final void gM(boolean z) {
    }

    public void aZs() {
        stopSearch();
        this.pfq.wiF.bYZ();
        aHj();
    }

    public boolean WV() {
        aHf();
        this.pfq.wiF.vqz.clearFocus();
        return false;
    }

    protected void onDestroy() {
        this.peL.removeMessages(1);
        this.pfo.finish();
        super.onDestroy();
    }

    protected void aZp() {
        this.pfp = true;
        this.pfo.DX(this.fRM);
        aZx();
    }

    protected void aZx() {
        this.mFc.setVisibility(8);
        this.pfn.setVisibility(8);
    }

    protected void aZy() {
        this.mFc.setVisibility(0);
        this.mFc.setText(f.a(getString(R.l.ePC), getString(R.l.ePB), com.tencent.mm.plugin.fts.d.b.a.d(this.fRM, this.fRM)).mdL);
        this.pfn.setVisibility(8);
    }

    protected void aZz() {
        this.mFc.setVisibility(8);
        this.pfn.setVisibility(0);
    }

    protected void aZA() {
        this.mFc.setVisibility(8);
        this.pfn.setVisibility(8);
    }

    public final void M(int i, boolean z) {
        w.i("MicroMsg.FTS.FTSBaseUI", "onEnd resultCount=%d | isFinished=%b", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
        if (z) {
            if (i > 0) {
                aZz();
            } else {
                aZy();
            }
        } else if (i > 0) {
            aZz();
        } else {
            aZx();
        }
        if (this.pfp) {
            this.pfp = false;
            this.pfn.setSelection(0);
        }
    }
}
