package com.tencent.mm.plugin.product.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.g;

public abstract class MallBaseUI extends MMActivity {
    protected String laI;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MallBaseUI oqs;

            {
                this.oqs = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oqs.finish();
                return true;
            }
        });
    }

    protected final void Cz(String str) {
        this.laI = str;
        showDialog(-10001);
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case -10002:
                return g.a(this.uSU.uTo, false, new OnCancelListener(this) {
                    final /* synthetic */ MallBaseUI oqs;

                    {
                        this.oqs = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
            case -10001:
                if (bg.mA(this.laI)) {
                    this.laI = getString(R.l.ezO);
                }
                return com.tencent.mm.ui.base.g.a(this, this.laI, null, false, new OnClickListener(this) {
                    final /* synthetic */ MallBaseUI oqs;

                    {
                        this.oqs = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.oqs.finish();
                    }
                });
            default:
                return super.onCreateDialog(i);
        }
    }

    public final void re(int i) {
        this.uSU.ipu.setVisibility(i);
        if (i == 0) {
            bPW();
        } else {
            this.uSU.bQg();
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            this.uSU.bQc();
        }
        return super.onKeyUp(i, keyEvent);
    }
}
