package com.tencent.mm.ui.chatting.gallery;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.b.b.b;
import com.tencent.mm.ui.chatting.c.d;
import com.tencent.mm.ui.chatting.c.f;
import com.tencent.mm.ui.chatting.c.g;

public class MediaHistoryListUI extends MMActivity implements b {
    private RecyclerView aak;
    private String kwJ;
    private TextView kwL;
    private com.tencent.mm.ui.chatting.b.b.a vPR;
    private ProgressDialog vPS;
    private p vTQ;

    private static class a {
        public static com.tencent.mm.ui.chatting.b.b.a af(Context context, int i) {
            switch (i) {
                case 3:
                    return new f(context);
                case 5:
                    return new g(context);
                case 6:
                    return new d(context);
                default:
                    return null;
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kwJ = getIntent().getStringExtra("kintent_talker");
        com.tencent.mm.ui.chatting.b.b.a aVar = null;
        switch (getIntent().getIntExtra("key_media_type", -1)) {
            case 2:
                aVar = a.af(this, 6);
                break;
            case 3:
                aVar = a.af(this, 5);
                break;
            case 4:
                aVar = a.af(this, 3);
                break;
        }
        aVar.a(this);
        KC();
        this.vPR.bWD();
    }

    protected final void KC() {
        this.vTQ = new p();
        this.vTQ.lK(false);
        this.vTQ.a(this.vPR.bWF());
        this.vTQ.sXA = false;
        this.kwL = (TextView) findViewById(R.h.cAT);
        this.aak = (RecyclerView) findViewById(R.h.bWn);
        findViewById(R.h.bGy).setBackgroundColor(-1);
        this.aak.setBackgroundColor(-1);
        this.aak.a(this.vPR.eW(this));
        this.aak.a(this.vPR.bWC());
        this.aak.a(this.vPR.TI(this.kwJ));
        this.aak.Zl = true;
        qP(this.vPR.Oh());
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MediaHistoryListUI vTR;

            {
                this.vTR = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vTR.finish();
                return true;
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        this.vPR.onDetach();
    }

    public final void bit() {
        super.bit();
        if (this.uSU.uTG == 2) {
            this.vTQ.clearFocus();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.vTQ.a(this, menu);
        com.tencent.mm.ui.tools.p pVar = this.vTQ;
        String bWG = this.vPR.bWG();
        if (!(pVar.wod == null || bg.mA(bWG))) {
            pVar.wod.Uh(bWG);
        }
        this.uSU.ipu.postDelayed(new Runnable(this) {
            final /* synthetic */ MediaHistoryListUI vTR;

            {
                this.vTR = r1;
            }

            public final void run() {
                this.vTR.vTQ.clearFocus();
            }
        }, 200);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.vTQ.a(this, menu);
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    protected final int getLayoutId() {
        return R.i.diq;
    }

    public final void bWH() {
        da(true);
    }

    public final void s(boolean z, int i) {
        da(false);
        w.i("MicroMsg.MediaHistoryListUI", "[onDataLoaded] isFirst:%s addCount:%s", new Object[]{Boolean.valueOf(z), Integer.valueOf(i)});
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
        w.i("MicroMsg.MediaHistoryListUI", "[onFinish]");
        finish();
    }

    public final void aY(String str, boolean z) {
        if (z) {
            CharSequence string = getString(R.l.dVk, new Object[]{str});
            this.kwL.setVisibility(0);
            this.aak.setVisibility(8);
            TextView textView = this.kwL;
            this.kwL.getContext();
            textView.setText(com.tencent.mm.as.d.a(string, str));
            return;
        }
        this.kwL.setVisibility(8);
        this.aak.setVisibility(0);
    }

    private void da(boolean z) {
        w.i("MicroMsg.MediaHistoryListUI", "[setProgress] isVisible:%s", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.vPS = com.tencent.mm.ui.base.p.b(this, getString(R.l.cbS), true, 0, null);
        } else if (this.vPS != null && this.vPS.isShowing()) {
            this.vPS.dismiss();
            this.vPS = null;
        }
    }
}
