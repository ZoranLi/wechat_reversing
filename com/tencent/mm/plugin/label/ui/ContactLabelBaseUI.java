package com.tencent.mm.plugin.label.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;

public class ContactLabelBaseUI extends MMActivity {
    private ProgressDialog kIa;

    protected int getLayoutId() {
        return 0;
    }

    public final void zi(String str) {
        getString(R.l.dIO);
        this.kIa = g.a(this, str, true, new OnCancelListener(this) {
            final /* synthetic */ ContactLabelBaseUI mYY;

            {
                this.mYY = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().cancel(636);
            }
        });
    }

    public final void aFI() {
        if (this.kIa != null && this.kIa.isShowing()) {
            this.kIa.dismiss();
        }
    }

    public final void uC(String str) {
        g.a(this, str, "", new OnClickListener(this) {
            final /* synthetic */ ContactLabelBaseUI mYY;

            {
                this.mYY = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }
}
