package com.tencent.mm.plugin.collect.ui;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.collect.b.j;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;

public class CollectHKMainUI extends CollectMainUI {
    private boolean kCc = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kCl.setVisibility(8);
        findViewById(R.h.bDJ).setVisibility(0);
        findViewById(R.h.bEa).setVisibility(8);
        ccJ().hn(1335);
        a(0, R.g.blV, new OnMenuItemClickListener(this) {
            final /* synthetic */ CollectHKMainUI kCd;

            {
                this.kCd = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                e.m(this.kCd.uSU.uTo, "https://hkwallet.moneydata.hk/hybrid/www/weixin/f2f/zh_hk/faq.shtml", true);
                return false;
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        ccJ().ho(1335);
    }

    protected final void akq() {
        ap.yY();
        this.kCD = (String) c.vr().get(a.uHG, "");
        k jVar = new j(m.xS());
        if (bg.mA(this.kCD)) {
            w.i("MicroMsg.CollectHKMainUI", "force load payurl");
            this.kCc = true;
            ccJ().a(jVar, true, true);
            return;
        }
        ccJ().a(jVar, false, true);
    }

    protected final String akr() {
        return this.kCE;
    }

    protected final String aks() {
        if (bg.mA(this.kCF)) {
            this.kCF = s.ccn();
        }
        return this.kCF;
    }

    public final boolean f(int i, int i2, String str, k kVar) {
        if (kVar instanceof j) {
            final j jVar = (j) kVar;
            if (i != 0 || i2 != 0) {
                w.e("MicroMsg.CollectHKMainUI", "net error: %s", new Object[]{kVar});
            } else if (jVar.kAC == 0) {
                this.kCD = jVar.kAE;
                this.kCE = jVar.kAQ;
                this.kCF = jVar.kAN;
                aiQ();
                if (bg.mA(jVar.kAK)) {
                    this.kCl.setVisibility(8);
                } else {
                    this.kCl.setClickable(true);
                    this.kCl.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.k(this));
                    CharSequence spannableStringBuilder = new SpannableStringBuilder(getString(R.l.dWG));
                    spannableStringBuilder.setSpan(new com.tencent.mm.plugin.wallet_core.ui.k(5, new com.tencent.mm.plugin.wallet_core.ui.k.a(this) {
                        final /* synthetic */ CollectHKMainUI kCd;

                        public final void akv() {
                            e.m(this.kCd.uSU.uTo, jVar.kAL, false);
                        }
                    }), 0, spannableStringBuilder.length(), 18);
                    this.kCl.setText(spannableStringBuilder);
                    this.kCl.setVisibility(0);
                }
                if (bg.mA(jVar.kAO)) {
                    this.kCA.setVisibility(8);
                } else {
                    this.kCA.setText(jVar.kAO);
                    this.kCA.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ CollectHKMainUI kCd;

                        public final void onClick(View view) {
                            if (!bg.mA(jVar.kAP)) {
                                e.m(this.kCd.uSU.uTo, jVar.kAP, true);
                            }
                        }
                    });
                    this.kCA.setVisibility(0);
                }
                return true;
            }
            if (!this.kCc) {
                return true;
            }
        }
        return false;
    }

    protected final void akt() {
        ImageView imageView = (ImageView) this.kCt.findViewById(R.h.bDO);
        ((ImageView) this.kCt.findViewById(R.h.bDX)).setImageResource(R.k.dvV);
        imageView.setImageResource(R.k.dvS);
    }

    protected final void aku() {
        super.aku();
        if (this.kCL) {
            findViewById(R.h.bDJ).setVisibility(8);
        } else {
            findViewById(R.h.bDJ).setVisibility(0);
        }
    }
}
