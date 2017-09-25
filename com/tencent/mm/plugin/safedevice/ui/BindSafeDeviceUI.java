package com.tencent.mm.plugin.safedevice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.safedevice.a;
import com.tencent.mm.ui.MMWizardActivity;

public class BindSafeDeviceUI extends MMWizardActivity {
    protected final int getLayoutId() {
        return R.i.dnq;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    protected final void KC() {
        zi(R.l.eNG);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BindSafeDeviceUI oUH;

            {
                this.oUH = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oUH.finish();
                return true;
            }
        });
        ((ImageView) findViewById(R.h.cBs)).setImageResource(R.k.dsH);
        ((TextView) findViewById(R.h.cBt)).setText(R.l.eNM);
        ((TextView) findViewById(R.h.cII)).setText(R.l.eNN);
        findViewById(R.h.cII).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BindSafeDeviceUI oUH;

            {
                this.oUH = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("is_bind_for_safe_device", true);
                a.imv.b(this.oUH, intent);
            }
        });
    }
}
