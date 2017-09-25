package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;

@a(7)
public class WalletIbgAdapterUI extends WalletBaseUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        re(4);
        this.wFr.hn(1564);
        q(new com.tencent.mm.plugin.wallet_core.b.a.a());
    }

    public void onResume() {
        super.onResume();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0 && (kVar instanceof com.tencent.mm.plugin.wallet_core.b.a.a)) {
            int i3 = ((com.tencent.mm.plugin.wallet_core.b.a.a) kVar).rCo;
            String str2 = ((com.tencent.mm.plugin.wallet_core.b.a.a) kVar).jumpUrl;
            w.i("MicroMsg.WalletH5AdapterUI", "hy: get success! url is: %s, download x5 = %b", new Object[]{str2, Integer.valueOf(i3)});
            if (i3 == 1) {
                boolean z;
                w.i("MicroMsg.WalletH5AdapterUI", "now status = %d", new Object[]{Integer.valueOf(com.tencent.mm.pluginsdk.model.w.a.bCP())});
                switch (com.tencent.mm.pluginsdk.model.w.a.bCP()) {
                    case 1:
                    case 4:
                        z = true;
                        break;
                    case 2:
                    case 3:
                        ap.yY();
                        if (((Boolean) c.vr().get(com.tencent.mm.storage.w.a.uDC, Boolean.valueOf(false))).booleanValue()) {
                            Toast.makeText(this, getString(R.l.fmC), 1).show();
                            com.tencent.mm.pluginsdk.model.w.a.dx(this);
                            finish();
                        } else {
                            bvs();
                        }
                        z = false;
                        break;
                    default:
                        bvs();
                        z = false;
                        break;
                }
                if (z) {
                    Iu(str2);
                    finish();
                }
            } else {
                Iu(str2);
                finish();
            }
        } else {
            com.tencent.mm.wallet_core.a.c(this, null, 0);
        }
        return false;
    }

    public void onDestroy() {
        this.wFr.ho(1564);
        super.onDestroy();
    }

    private void Iu(String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        d.b(this, "webview", ".ui.tools.WebViewUI", intent);
    }

    private void bvs() {
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uDC, Boolean.valueOf(true));
        g.a(this, false, getString(R.l.fmF), "", getString(R.l.fmA), getString(R.l.fmz), new OnClickListener(this) {
            final /* synthetic */ WalletIbgAdapterUI rOF;

            {
                this.rOF = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                com.tencent.mm.pluginsdk.model.w.a.dx(this.rOF);
                Toast.makeText(this.rOF, this.rOF.getString(R.l.fmB), 1).show();
                this.rOF.finish();
            }
        }, new OnClickListener(this) {
            final /* synthetic */ WalletIbgAdapterUI rOF;

            {
                this.rOF = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.rOF.finish();
            }
        });
    }

    protected final int getLayoutId() {
        return -1;
    }
}
