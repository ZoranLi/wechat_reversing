package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.sq;
import com.tencent.mm.plugin.remittance.c.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.x.d;
import com.tencent.mm.x.n;
import com.tencent.mm.y.k;

@a(19)
public class RemittanceOSUI extends RemittanceBaseUI implements d.a {
    private int oSA;
    private String oSB;
    private String oSC;
    private String oSD;
    private String oSE;
    private boolean oSF = false;
    private c oSG = new c<sq>(this) {
        final /* synthetic */ RemittanceOSUI oSH;

        {
            this.oSH = r2;
            this.usg = sq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (this.oSH.oSF) {
                this.oSH.finish();
            }
            return false;
        }
    };

    public final void aXg() {
    }

    public final void aXi() {
        g.oUh.i(13337, new Object[]{Integer.valueOf(2)});
    }

    public final void aXj() {
        s.makeText(this.uSU.uTo, getString(R.l.eLo, new Object[]{this.oSB}), 0).show();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.sdk.b.a.urY.a(this.oSG);
        this.wFr.hn(1622);
        this.wFr.hn(1574);
        KC();
        this.kBW.tC("");
        n.Bl().a(this);
        this.oSA = getIntent().getIntExtra("os_currency", 0);
        this.oSB = getIntent().getStringExtra("os_currencyuint");
        this.oSC = getIntent().getStringExtra("os_currencywording");
        this.oSD = getIntent().getStringExtra("os_notice");
        this.oSE = getIntent().getStringExtra("os_notice_url");
        this.kBW.tC(this.oSB);
        aXm();
    }

    public final void dj(String str, String str2) {
        String xN = m.xN();
        if (bg.mA(xN)) {
            xN = m.xL();
        }
        ap.yY();
        com.tencent.mm.j.a Rc = com.tencent.mm.u.c.wR().Rc(this.gLD);
        String str3 = this.gLD;
        if (((int) Rc.gTQ) != 0) {
            str3 = Rc.tL();
        }
        k lVar = new l(this.oRf, xN, this.gLD, str3, str, this.oSA);
        lVar.gWO = "RemittanceProcess";
        k(lVar);
        g.oUh.i(13337, new Object[]{Integer.valueOf(1), Double.valueOf(this.oRf)});
    }

    protected final void Dx(String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        com.tencent.mm.bb.d.b(this, "webview", ".ui.tools.WebViewUI", intent, 3);
        this.oSF = true;
    }

    protected final void Dy(String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        com.tencent.mm.bb.d.b(this, "webview", ".ui.tools.WebViewUI", intent, 3);
        this.oSF = true;
    }

    public final void aXm() {
        if (bg.mA(this.oSD)) {
            w.i("MicroMsg.RemittanceOSUI", "no bulletin data");
        } else {
            e.a((TextView) findViewById(R.h.bsx), "", this.oSD, this.oSE);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.urY.c(this.oSG);
        n.Bl().b(this);
        this.wFr.ho(1622);
        this.wFr.ho(1574);
    }

    public final void ho(String str) {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.d("MicroMsg.RemittanceOSUI", "reqcode=" + i + ", resultCode=" + i2 + ", username=" + this.gLD);
        this.oSF = false;
        if (i == 3 && i2 == -1) {
            finish();
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final int getLayoutId() {
        return R.i.dmF;
    }

    public final void b(int i, int i2, String str, k kVar, boolean z) {
        super.b(i, i2, str, kVar, z);
        if (i == 0 && i2 == 0 && (kVar instanceof l)) {
            int i3;
            final l lVar = (l) kVar;
            boolean z2;
            if (lVar.oQp <= 0) {
                z2 = false;
            } else if (lVar.oQW == 0) {
                com.tencent.mm.ui.base.g.a(this, getString(R.l.eLs, new Object[]{Integer.valueOf(lVar.oQp)}), getString(R.l.dIs), getString(R.l.eKy), getString(R.l.eLn), new OnClickListener(this) {
                    final /* synthetic */ RemittanceOSUI oSH;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.oSH.Dx(lVar.oQk);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ RemittanceOSUI oSH;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.oSH.Dy(lVar.oQV);
                    }
                });
                i3 = 1;
            } else if (lVar.oQW == 1) {
                com.tencent.mm.ui.base.g.a(this, getString(R.l.eLs, new Object[]{Integer.valueOf(lVar.oQp)}), getString(R.l.dIs), getString(R.l.eKy), getString(R.l.eLn), new OnClickListener(this) {
                    final /* synthetic */ RemittanceOSUI oSH;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.oSH.Dx(lVar.oQk);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ RemittanceOSUI oSH;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.oSH.Dy(lVar.oQV);
                    }
                });
                i3 = 1;
            } else {
                z2 = false;
            }
            if (i3 == 0) {
                String str2 = ((l) kVar).oQk;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                intent.putExtra("showShare", false);
                com.tencent.mm.bb.d.b(this, "webview", ".ui.tools.WebViewUI", intent, 3);
            }
        }
    }
}
