package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class SettingDeleteAccountInputPassUI extends MMActivity {
    protected final int getLayoutId() {
        return R.i.dnW;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.eRr);
        KC();
    }

    protected final void KC() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingDeleteAccountInputPassUI pjs;

            {
                this.pjs = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pjs.aHf();
                this.pjs.finish();
                return true;
            }
        });
        a(0, getString(R.l.dHp), new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingDeleteAccountInputPassUI pjs;

            {
                this.pjs = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pjs.aHf();
                this.pjs.startActivity(new Intent(this.pjs, SettingDeleteAccountUI.class));
                return true;
            }
        });
    }
}
