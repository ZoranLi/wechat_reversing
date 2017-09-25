package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.bakoldlogic.a.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMWizardActivity;

public class BakFinishUI extends MMWizardActivity implements e {
    private ae handler = new ae(Looper.getMainLooper());
    private int jMv;
    private TextView jMx;

    protected final int getLayoutId() {
        return R.i.cVq;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            this.jMv = getIntent().getIntExtra("cmd", -1);
            w.i("MicroMsg.BakFinishUI", "BakFinishUI onCreate nowCmd:%d", new Object[]{Integer.valueOf(this.jMv)});
            KC();
            a.acg().ach().jLL = this;
        }
    }

    protected final void KC() {
        zi(R.l.dMk);
        this.jMx = (TextView) findViewById(R.h.brt);
        if (6 == this.jMv) {
            this.jMx.setText(getString(R.l.dMj));
        } else if (1 == this.jMv) {
            this.jMx.setText(getString(R.l.dMc));
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BakFinishUI jMy;

            {
                this.jMy = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                a.acg().ach().jLS = c.jJh;
                this.jMy.zu(1);
                return true;
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        a.acg().ach().jLL = null;
        w.i("MicroMsg.BakFinishUI", "BakFinishUI onDestroy nowCmd:%d", new Object[]{Integer.valueOf(this.jMv)});
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        a.acg().ach().jLS = c.jJh;
        zu(1);
        return true;
    }

    public final void acu() {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ BakFinishUI jMy;

            {
                this.jMy = r1;
            }

            public final void run() {
                a.acg().ach().jLS = c.jJh;
                this.jMy.zu(1);
            }
        });
    }

    public final void onError(int i) {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ BakFinishUI jMy;

            {
                this.jMy = r1;
            }

            public final void run() {
                w.d("MicroMsg.BakFinishUI", "BakFinishUI onCloseSocket");
                MMWizardActivity.z(this.jMy, new Intent(this.jMy, BakConnErrorUI.class));
            }
        });
    }
}
