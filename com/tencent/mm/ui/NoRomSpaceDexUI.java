package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Process;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h.a;

public class NoRomSpaceDexUI extends MMActivity {
    protected final int getLayoutId() {
        return R.i.dkl;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a aVar = new a(this);
        aVar.zW(R.l.dVX);
        aVar.SX(getString(R.l.dVW));
        aVar.kK(false);
        aVar.zZ(R.l.dVU).a(new OnClickListener(this) {
            final /* synthetic */ NoRomSpaceDexUI uVI;

            {
                this.uVI = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                Process.killProcess(Process.myPid());
            }
        });
        aVar.WJ().show();
    }
}
