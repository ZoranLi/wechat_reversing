package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.b.i;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.y.k;

@a(1)
public class WalletLqtSimpleCheckPwdUI extends WalletBaseUI {
    private EditHintPasswdView rwi;
    private i rwj;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        qP(s.fl(this));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletLqtSimpleCheckPwdUI rwk;

            {
                this.rwk = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.rwk.finish();
                return false;
            }
        });
        ((TextView) findViewById(R.h.bXM)).setText(R.l.ffb);
        this.rwi = (EditHintPasswdView) findViewById(R.h.bXJ);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.rwi);
        this.rwi.wFT = new EditHintPasswdView.a(this) {
            final /* synthetic */ WalletLqtSimpleCheckPwdUI rwk;

            {
                this.rwk = r1;
            }

            public final void gA(boolean z) {
                if (z) {
                    this.rwk.rwj = new i(this.rwk.rwi.getText(), 7, this.rwk.bsF());
                    this.rwk.q(this.rwk.rwj);
                }
            }
        };
        d(this.rwi, 0, false);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.WalletLqtSimpleCheckPwdUI", "scene end. errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar instanceof i) {
            if (i == 0 && i2 == 0) {
                String text = this.rwi.getText();
                Intent intent = new Intent();
                intent.putExtra("lqt_enc_pwd", text);
                setResult(-1, intent);
                finish();
                return true;
            } else if (this.rwi != null) {
                this.rwi.aWw();
            }
        }
        return false;
    }

    public final void qU(int i) {
        super.qU(i);
        if (this.rwi != null) {
            this.rwi.aWw();
        }
    }

    protected final int getLayoutId() {
        return R.i.dqM;
    }

    protected final int Ol() {
        return 1;
    }
}
