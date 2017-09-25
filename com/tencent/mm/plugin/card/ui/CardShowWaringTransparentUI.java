package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;

@a(7)
public class CardShowWaringTransparentUI extends MMActivity {
    protected final int getLayoutId() {
        return R.i.cXd;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("KEY_BRAND_NAME");
        g.a(this, getString(R.l.dSo, new Object[]{stringExtra}), getString(R.l.dSp), getString(R.l.dAN), new OnClickListener(this) {
            final /* synthetic */ CardShowWaringTransparentUI kpf;

            {
                this.kpf = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                this.kpf.finish();
            }
        });
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            finish();
        }
        return true;
    }
}
