package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet.pwd.a.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.o;
import com.tencent.mm.wallet_core.c.e;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.c.q;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.d;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.Vector;

public class WalletDigitalCertUI extends WalletBaseUI {
    private ImageView jla;
    private Button kzq;
    private TextView rAS;
    private Button rAT;
    private LinearLayout rAU;
    private TextView rAV;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        hn(1654);
        hn(1568);
        q(new b());
        KC();
        g.oUh.i(13731, new Object[]{Integer.valueOf(1)});
    }

    public final void KC() {
        zi(R.l.fhH);
        this.jla = (ImageView) findViewById(R.h.byR);
        this.rAS = (TextView) findViewById(R.h.byU);
        this.rAT = (Button) findViewById(R.h.bXP);
        this.kzq = (Button) findViewById(R.h.bHR);
        this.rAU = (LinearLayout) findViewById(R.h.bXR);
        this.rAV = (TextView) findViewById(R.h.bXS);
        this.rAT.setOnClickListener(new d(this) {
            final /* synthetic */ WalletDigitalCertUI rAW;

            {
                this.rAW = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(this.rAW, WalletIdCardCheckUI.class);
                this.rAW.startActivityForResult(intent, 1);
            }
        });
        this.kzq.setOnClickListener(new d(this) {
            final /* synthetic */ WalletDigitalCertUI rAW;

            {
                this.rAW = r1;
            }

            public final void onClick(View view) {
                q.ccj();
                this.rAW.k(new e(q.cci()));
                g.oUh.i(13731, new Object[]{Integer.valueOf(10)});
            }
        });
        b(new o(this) {
            final /* synthetic */ WalletDigitalCertUI rAW;

            {
                this.rAW = r1;
            }

            public final void bsU() {
                this.rAW.finish();
            }
        });
        btl();
    }

    private void btl() {
        w.i("MicroMsg.WalletDigitalCertUI", "updateCrtState");
        this.rAU.removeAllViews();
        if (q.ccj().cck()) {
            this.rAT.setVisibility(8);
            this.kzq.setVisibility(0);
            this.rAS.setText(R.l.fhQ);
            this.jla.setImageResource(R.g.blR);
        } else {
            this.rAT.setVisibility(0);
            this.kzq.setVisibility(8);
            this.rAS.setText(R.l.fhJ);
            this.jla.setImageResource(R.g.blS);
        }
        Vector vector = q.ccj().wEr;
        if (vector.size() == 0) {
            this.rAU.setVisibility(8);
            this.rAV.setVisibility(8);
            return;
        }
        this.rAU.setVisibility(0);
        this.rAV.setVisibility(0);
        Iterator it = vector.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            if (pVar.wEp <= 0) {
                View inflate = View.inflate(this, R.i.dqq, null);
                TextView textView = (TextView) inflate.findViewById(R.h.byS);
                TextView textView2 = (TextView) inflate.findViewById(R.h.bHS);
                ((TextView) inflate.findViewById(R.h.byV)).setText(pVar.wEn);
                textView.setText(pVar.wEo);
                textView2.setTag(pVar);
                textView2.setOnClickListener(new d(this) {
                    final /* synthetic */ WalletDigitalCertUI rAW;

                    {
                        this.rAW = r1;
                    }

                    public final void onClick(View view) {
                        if (view.getTag() instanceof p) {
                            final p pVar = (p) view.getTag();
                            com.tencent.mm.ui.base.g.a(this.rAW, this.rAW.getString(R.l.fhI, new Object[]{pVar.wEn}), "", this.rAW.getString(R.l.bHU), this.rAW.getString(R.l.cancel), true, new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass4 rAY;

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    w.i("MicroMsg.WalletDigitalCertUI", "del crt %s", new Object[]{pVar.ufv});
                                    this.rAY.rAW.k(new e(pVar.ufv));
                                }
                            }, null);
                        }
                    }
                });
                this.rAU.addView(inflate);
            }
        }
        if (this.rAU.getChildCount() == 0) {
            this.rAV.setVisibility(8);
        } else {
            this.rAV.setVisibility(0);
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
        ho(1654);
        ho(1568);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof b)) {
            if (kVar instanceof e) {
                if (i2 == 0) {
                    g.oUh.i(13731, new Object[]{Integer.valueOf(11)});
                    q.ccj().UF(((e) kVar).wDV);
                } else {
                    g.oUh.i(13731, new Object[]{Integer.valueOf(12)});
                }
            }
            return false;
        }
        btl();
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (1 == i && i2 == -1) {
            q(new b());
        }
    }

    protected final int getLayoutId() {
        return R.i.dqy;
    }
}
