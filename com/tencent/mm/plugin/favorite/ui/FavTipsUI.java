package com.tencent.mm.plugin.favorite.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h.a;

public class FavTipsUI extends MMBaseActivity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a aVar = new a(this);
        aVar.SW(getString(R.l.eiz));
        aVar.SX(getString(R.l.eix) + "\n\n" + getString(R.l.eiy));
        aVar.zZ(R.l.eiw).a(new OnClickListener(this) {
            final /* synthetic */ FavTipsUI lIx;

            {
                this.lIx = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.lIx.finish();
            }
        });
        aVar.d(new OnCancelListener(this) {
            final /* synthetic */ FavTipsUI lIx;

            {
                this.lIx = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.lIx.finish();
            }
        });
        aVar.WJ().show();
    }
}
