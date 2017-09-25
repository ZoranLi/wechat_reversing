package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class SettingDeleteAccountUI extends MMActivity {
    protected final int getLayoutId() {
        return R.i.dnU;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.eRr);
        KC();
    }

    protected final void KC() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingDeleteAccountUI pjt;

            {
                this.pjt = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pjt.aHf();
                this.pjt.finish();
                return true;
            }
        });
        ((TextView) findViewById(R.h.bHW)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SettingDeleteAccountUI pjt;

            {
                this.pjt = r1;
            }

            public final void onClick(View view) {
            }
        });
    }
}
