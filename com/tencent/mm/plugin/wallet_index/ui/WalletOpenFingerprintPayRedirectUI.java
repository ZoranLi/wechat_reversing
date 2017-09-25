package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet.b.a;
import com.tencent.mm.plugin.wallet_core.b.m;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.wallet_core.ui.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class WalletOpenFingerprintPayRedirectUI extends AutoLoginActivity implements e {
    private boolean Hu = false;
    private Dialog ita = null;

    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] jPl = new int[b.values().length];

        static {
            try {
                jPl[b.sIe.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                jPl[b.sIg.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                jPl[b.sIf.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(385, this);
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected final boolean u(Intent intent) {
        return true;
    }

    protected void onDestroy() {
        super.onDestroy();
        ap.vd().b(385, this);
    }

    protected final void a(b bVar, Intent intent) {
        w.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin, loginResult = " + bVar);
        switch (AnonymousClass3.jPl[bVar.ordinal()]) {
            case 1:
                w.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: login ok.");
                ap.vd().a(new m(null, 1), 0);
                if (this.ita != null) {
                    this.ita.dismiss();
                    this.ita = null;
                }
                this.ita = g.e(this, new OnCancelListener(this) {
                    final /* synthetic */ WalletOpenFingerprintPayRedirectUI rQy;

                    {
                        this.rQy = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        this.rQy.Hu = true;
                        this.rQy.b(4, false, "");
                    }
                });
                return;
            case 2:
            case 3:
                w.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin fail, loginResult = " + bVar);
                b(1, false, "");
                break;
            default:
                w.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "postLogin, unknown login result = " + bVar);
                break;
        }
        b(2, true, getString(R.l.dGU));
    }

    private void b(int i, boolean z, String str) {
        w.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: redirect to open fingerprint failed. errCode: %d", new Object[]{Integer.valueOf(i)});
        if (this.ita != null && this.ita.isShowing()) {
            this.ita.dismiss();
            this.ita = null;
        }
        if (z) {
            com.tencent.mm.ui.base.g.a(this, str, "", false, new OnClickListener(this) {
                final /* synthetic */ WalletOpenFingerprintPayRedirectUI rQy;

                {
                    this.rQy = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.rQy.finish();
                }
            });
        } else {
            finish();
        }
    }

    protected void onStop() {
        super.onStop();
        if (this.ita != null && this.ita.isShowing()) {
            this.ita.dismiss();
            this.ita = null;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof m)) {
            return;
        }
        if (this.Hu) {
            w.w("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: is already handled");
            return;
        }
        this.Hu = true;
        if (i == 0 && i2 == 0) {
            w.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: bind query ok. start judge.");
            o.bsC();
            af bsD = o.bsD();
            if (bsD == null || !bsD.bum()) {
                w.i("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: not open wechat payment. hint bind bankcard");
                b(5, true, getString(R.l.ekS));
                return;
            } else if (a.bts() && p.gRg.gRp == 1) {
                Intent intent = new Intent();
                intent.putExtra("key_is_from_system", true);
                d.b(this, "wallet", ".pwd.ui.WalletPasswordSettingUI", intent);
                finish();
                return;
            } else {
                w.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: not support wechat fp pay or not allow");
                b(6, true, getString(R.l.ekT));
                return;
            }
        }
        w.e("MicroMsg.WalletOpenFingerprintPayRedirectUI", "hy: bind query failed. inform fail.");
        b(3, true, getString(R.l.dGU));
    }
}
