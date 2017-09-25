package com.tencent.mm.ui.chatting.gallery;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.b.b.a;
import com.tencent.mm.ui.chatting.b.b.b;
import com.tencent.mm.ui.chatting.c.c;

public class AppBrandHistoryListUI extends MMActivity implements b {
    private RecyclerView aak;
    private String kwJ;
    private TextView kwL;
    private a vPR;
    private ProgressDialog vPS;

    public final /* bridge */ /* synthetic */ void a(c cVar) {
        this.vPR = (a) cVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kwJ = getIntent().getStringExtra("Chat_User");
        new com.tencent.mm.ui.chatting.c.a(this).a(this);
        KC();
        this.vPR.bWD();
        if (o.dH(this.kwJ)) {
            g.oUh.i(14562, new Object[]{this.kwJ, Integer.valueOf(0)});
            return;
        }
        g.oUh.i(14562, new Object[]{this.kwJ, Integer.valueOf(1)});
    }

    protected final void KC() {
        qP(getString(R.l.dSw));
        this.kwL = (TextView) findViewById(R.h.cAT);
        this.aak = (RecyclerView) findViewById(R.h.bWn);
        this.aak.setBackgroundColor(-1);
        this.aak.a(this.vPR.eW(this));
        this.aak.a(this.vPR.TI(this.kwJ));
        this.aak.Zl = true;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AppBrandHistoryListUI vPT;

            {
                this.vPT = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vPT.finish();
                return true;
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.cUL;
    }

    public final void bWH() {
        da(true);
    }

    public final void s(boolean z, int i) {
        da(false);
        w.i("MicroMsg.AppBrandHistoryListUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[]{Boolean.valueOf(z), Integer.valueOf(i)});
        if (i <= 0) {
            this.kwL.setVisibility(0);
            this.aak.setVisibility(8);
            this.kwL.setText(getString(R.l.dVi));
            return;
        }
        this.kwL.setVisibility(8);
        this.aak.setVisibility(0);
        this.aak.fn().aab.notifyChanged();
    }

    public final void onFinish() {
        w.i("MicroMsg.AppBrandHistoryListUI", "[onFinish]");
        finish();
    }

    public final void aY(String str, boolean z) {
    }

    private void da(boolean z) {
        w.i("MicroMsg.AppBrandHistoryListUI", "[setProgress] isVisible:%s", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.vPS = p.b(this, getString(R.l.cbS), true, 0, null);
        } else if (this.vPS != null && this.vPS.isShowing()) {
            this.vPS.dismiss();
            this.vPS = null;
        }
    }
}
