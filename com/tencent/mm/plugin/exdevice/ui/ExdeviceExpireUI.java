package com.tencent.mm.plugin.exdevice.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class ExdeviceExpireUI extends MMActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.egB);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ExdeviceExpireUI lkW;

            {
                this.lkW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lkW.finish();
                return false;
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.dbz;
    }
}
