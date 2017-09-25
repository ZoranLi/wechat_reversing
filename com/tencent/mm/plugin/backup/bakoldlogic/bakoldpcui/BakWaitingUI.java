package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMWizardActivity;

public class BakWaitingUI extends MMWizardActivity implements c {
    private ae handler = new ae(Looper.getMainLooper());
    private boolean jMN;
    private int ou;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            a.acg().ach().jLJ = this;
            this.ou = a.acg().ach().jLP;
            this.jMN = getIntent().getBooleanExtra("from_back_finish", false);
            w.i("MicroMsg.BakWaitingUI", "BakWaitingUI onCreate nowCmd:%d isFromFinish:%b", new Object[]{Integer.valueOf(this.ou), Boolean.valueOf(this.jMN)});
            KC();
            acB();
        }
    }

    protected final void KC() {
        zi(R.l.dMk);
        if (this.jMN) {
            findViewById(R.h.brx).setVisibility(8);
        } else {
            findViewById(R.h.brx).setVisibility(0);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BakWaitingUI jMO;

            {
                this.jMO = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jMO.zu(1);
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.cVs;
    }

    public final void jz(int i) {
        this.ou = i;
        this.handler.post(new Runnable(this) {
            final /* synthetic */ BakWaitingUI jMO;

            {
                this.jMO = r1;
            }

            public final void run() {
                this.jMO.acB();
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        a.acg().ach().jLJ = null;
        w.i("MicroMsg.BakWaitingUI", "BakWaitingUI onDestroy nowCmd:%d isFromFinish:%b", new Object[]{Integer.valueOf(this.ou), Boolean.valueOf(this.jMN)});
    }

    public final void jA(final int i) {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ BakWaitingUI jMO;

            public final void run() {
                w.d("MicroMsg.BakWaitingUI", "BakWaitingUI onCloseSocket errType: %d", new Object[]{Integer.valueOf(i)});
                if (i == -1) {
                    w.d("MicroMsg.BakWaitingUI", "BakToPcUI jump tips");
                    Intent intent = new Intent();
                    intent.putExtra("title", this.jMO.getString(R.l.dLe));
                    intent.putExtra("rawUrl", this.jMO.getString(R.l.dKB, new Object[]{v.bIN()}));
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    d.b(this.jMO, "webview", ".ui.tools.WebViewUI", intent);
                }
            }
        });
    }

    final void acB() {
        if (6 == this.ou || 1 == this.ou) {
            Intent intent = new Intent(this, BakOperatingUI.class);
            intent.putExtra("cmd", this.ou);
            MMWizardActivity.z(this, intent);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        zu(1);
        return true;
    }

    public final void onError(final int i) {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ BakWaitingUI jMO;

            public final void run() {
                w.d("MicroMsg.BakWaitingUI", "BakWaitingUI onCloseSocket errType: %d", new Object[]{Integer.valueOf(i)});
                if (i == -1) {
                    w.d("MicroMsg.BakWaitingUI", "BakToPcUI jump tips");
                    Intent intent = new Intent();
                    intent.putExtra("title", this.jMO.getString(R.l.dLe));
                    intent.putExtra("rawUrl", this.jMO.getString(R.l.dKB, new Object[]{v.bIN()}));
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    d.b(this.jMO, "webview", ".ui.tools.WebViewUI", intent);
                    return;
                }
                MMWizardActivity.z(this.jMO, new Intent(this.jMO, BakConnErrorUI.class));
            }
        });
    }
}
