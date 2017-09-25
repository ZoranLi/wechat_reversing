package com.tencent.mm.ui.bindqq;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMWizardActivity;

public class SuccUnbindQQ extends MMWizardActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        KC();
    }

    protected final int getLayoutId() {
        return R.i.doW;
    }

    protected final void KC() {
        zi(R.l.eYG);
        a(0, getString(R.l.dHp), new OnMenuItemClickListener(this) {
            final /* synthetic */ SuccUnbindQQ vuT;

            {
                this.vuT = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vuT.zu(1);
                return true;
            }
        });
    }
}
