package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.bakoldlogic.a.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMWizardActivity;

public class BakConnErrorUI extends MMWizardActivity {
    private int jMv;

    protected final int getLayoutId() {
        return R.i.cVp;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            this.jMv = getIntent().getIntExtra("cmd", -1);
            w.i("MicroMsg.BakFinishUI", "BakConnErrorUI onCreate nowCmd:%d", new Object[]{Integer.valueOf(this.jMv)});
            KC();
            a.acg().ach().jLS = c.jJh;
        }
    }

    protected final void KC() {
        zi(R.l.dMk);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BakConnErrorUI jMw;

            {
                this.jMw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jMw.zu(1);
                return true;
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        a.acg().ach().jLL = null;
        w.i("MicroMsg.BakFinishUI", "BakConnErrorUI onDestroy nowCmd:%d", new Object[]{Integer.valueOf(this.jMv)});
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        zu(1);
        return true;
    }
}
