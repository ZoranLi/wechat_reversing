package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.remittance.c.b;
import com.tencent.mm.plugin.remittance.c.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;

public class RemittanceHKUI extends RemittanceBaseUI {
    private int oSu;
    private String oSv;
    private String oSw;
    private String oSx;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        hn(1529);
        hn(1257);
        this.oSu = getIntent().getIntExtra("hk_currency", 0);
        this.oSv = getIntent().getStringExtra("hk_currencyuint");
        this.oSw = getIntent().getStringExtra("hk_notice");
        this.oSx = getIntent().getStringExtra("hk_notice_url");
        this.kBW.tC(this.oSv);
        this.oRr.setText(this.oSv);
    }

    public void onDestroy() {
        super.onDestroy();
        ho(1529);
        ho(1257);
    }

    public final void aXg() {
    }

    public final void dj(String str, String str2) {
        w.d("MicroMsg.RemittanceHKUI", "do scene gen pay");
        int i = 0;
        if (this.oRh == 33) {
            i = 1;
        }
        b(new c(Math.round(this.oRf * 100.0d), this.gLD, this.oRg, this.oRv, this.gMv, this.oRi, this.oSu, i), true);
    }

    public final void aXj() {
        s.makeText(this.uSU.uTo, getString(R.l.eLo, new Object[]{this.oSv}), 0).show();
    }

    public final void aXm() {
        if (!bg.mA(this.oSw)) {
            TextView textView = (TextView) findViewById(R.h.bsx);
            textView.setText(this.oSw);
            textView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ RemittanceHKUI oSy;

                {
                    this.oSy = r1;
                }

                public final void onClick(View view) {
                    w.i("MicroMsg.RemittanceHKUI", "hy: on click banner");
                    if (!bg.mA(this.oSy.oSx)) {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", this.oSy.oSx);
                        intent.putExtra("showShare", false);
                        d.b(this.oSy.uSU.uTo, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                    }
                }
            });
        }
    }

    public final void aXh() {
        int i;
        w.d("MicroMsg.RemittanceHKUI", "do scene cancel");
        if (this.oRh == 33) {
            i = 1;
        } else {
            i = 0;
        }
        b(new b(this.gLD, this.oRi, this.oSu, ((long) this.oRf) * 100, i), false);
    }

    public final void b(int i, int i2, String str, k kVar, boolean z) {
        if (kVar instanceof c) {
            c cVar = (c) kVar;
            if (i != 0 || i2 != 0) {
                g.b(this.uSU.uTo, str, "", false);
                return;
            } else if (bg.mA(cVar.oQk)) {
                w.e("MicroMsg.RemittanceHKUI", "empty payurl");
                return;
            } else {
                e.n(this.uSU.uTo, cVar.oQk, 4);
                return;
            }
        }
        super.b(i, i2, str, kVar, z);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 4 && i2 == -1) {
            finish();
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final void aXq() {
    }
}
