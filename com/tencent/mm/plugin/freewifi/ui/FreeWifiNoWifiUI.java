package com.tencent.mm.plugin.freewifi.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class FreeWifiNoWifiUI extends MMActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FreeWifiNoWifiUI lXm;

            {
                this.lXm = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lXm.finish();
                return true;
            }
        });
    }

    protected final int Ol() {
        return 1;
    }

    protected final int getLayoutId() {
        return R.i.ddv;
    }
}
