package com.tencent.mm.plugin.collect.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.collect.b.j;
import com.tencent.mm.plugin.collect.b.p;
import com.tencent.mm.plugin.wallet_core.ui.f;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.b;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;
import com.tencent.mm.y.k;

public class CollectCreateQRCodeUI extends WalletBaseUI {
    private String gMv = "";
    private WalletFormView kBW;
    private TextView kBX;

    static /* synthetic */ void d(CollectCreateQRCodeUI collectCreateQRCodeUI) {
        if (bg.mA(collectCreateQRCodeUI.gMv)) {
            collectCreateQRCodeUI.kBX.setTextColor(collectCreateQRCodeUI.getResources().getColor(R.e.aUA));
            collectCreateQRCodeUI.kBX.setText(R.l.dWD);
            return;
        }
        f fVar = new f(collectCreateQRCodeUI.uSU.uTo);
        String string = collectCreateQRCodeUI.getString(R.l.dWF);
        CharSequence a = h.a(collectCreateQRCodeUI, collectCreateQRCodeUI.getString(R.l.dWE, new Object[]{collectCreateQRCodeUI.gMv, string}));
        CharSequence spannableString = new SpannableString(a);
        spannableString.setSpan(fVar, a.length() - string.length(), a.length(), 33);
        collectCreateQRCodeUI.kBX.setTextColor(collectCreateQRCodeUI.getResources().getColor(R.e.aUo));
        collectCreateQRCodeUI.kBX.setText(spannableString);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        hn(1335);
        KC();
    }

    public void onDestroy() {
        super.onDestroy();
        ho(1335);
    }

    protected final void KC() {
        zi(R.l.dWC);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CollectCreateQRCodeUI kBY;

            {
                this.kBY = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kBY.setResult(0);
                this.kBY.finish();
                return true;
            }
        });
        this.kBW = (WalletFormView) findViewById(R.h.cla);
        a.e(this.kBW);
        CharSequence stringExtra = getIntent().getStringExtra("key_currency_unit");
        if (bg.mA(stringExtra)) {
            this.kBW.jhl.setText(s.ccn());
        } else {
            this.kBW.jhl.setText(stringExtra);
        }
        this.kBW.a(new TextWatcher(this) {
            final /* synthetic */ CollectCreateQRCodeUI kBY;

            {
                this.kBY = r1;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, "0");
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 2) {
                    editable.delete(indexOf + 3, length);
                }
            }
        });
        d(this.kBW, 2, false);
        ((Button) findViewById(R.h.cnY)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CollectCreateQRCodeUI kBY;

            {
                this.kBY = r1;
            }

            public final void onClick(View view) {
                double d = bg.getDouble(this.kBY.kBW.getText(), 0.0d);
                ap.yY();
                w.i("MicroMsg.CollectCreateQRCodeUI", "wallet region: %s", new Object[]{Integer.valueOf(((Integer) c.vr().get(com.tencent.mm.storage.w.a.uDY, Integer.valueOf(0))).intValue())});
                if (!this.kBY.kBW.Pb()) {
                    com.tencent.mm.ui.base.s.makeText(this.kBY.uSU.uTo, R.l.fdK, 0).show();
                } else if (d < 0.01d) {
                    com.tencent.mm.ui.base.s.makeText(this.kBY.uSU.uTo, R.l.eKt, 0).show();
                } else if (r0 == 8) {
                    this.kBY.q(new j(Math.round(d * 100.0d), this.kBY.gMv, m.xS()));
                } else {
                    this.kBY.k(new p(d, "1", this.kBY.gMv));
                }
            }
        });
        this.kBX = (TextView) findViewById(R.h.bDz);
        this.kBX.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CollectCreateQRCodeUI kBY;

            {
                this.kBY = r1;
            }

            public final void onClick(View view) {
                this.kBY.Om();
                com.tencent.mm.plugin.wallet_core.ui.view.a.a(this.kBY, this.kBY.getString(R.l.dWD), this.kBY.gMv, "", 32, new b(this) {
                    final /* synthetic */ AnonymousClass4 kBZ;

                    {
                        this.kBZ = r1;
                    }

                    public final boolean u(CharSequence charSequence) {
                        if (bg.mA(charSequence.toString())) {
                            this.kBZ.kBY.gMv = "";
                            CollectCreateQRCodeUI.d(this.kBZ.kBY);
                        } else {
                            this.kBZ.kBY.gMv = charSequence.toString();
                            CollectCreateQRCodeUI.d(this.kBZ.kBY);
                        }
                        return true;
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass4 kBZ;

                    {
                        this.kBZ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        af.f(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 kCa;

                            {
                                this.kCa = r1;
                            }

                            public final void run() {
                                this.kCa.kBZ.kBY.aHf();
                            }
                        }, 500);
                    }
                });
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.cZf;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        Intent intent;
        if (kVar instanceof p) {
            if (i != 0 || i2 != 0) {
                return false;
            }
            p pVar = (p) kVar;
            intent = new Intent();
            intent.putExtra("ftf_pay_url", pVar.kBb);
            intent.putExtra("ftf_fixed_fee", pVar.kBc);
            intent.putExtra("ftf_fixed_fee_type", pVar.fFd);
            intent.putExtra("ftf_fixed_desc", pVar.desc);
            setResult(-1, intent);
            finish();
            return true;
        } else if (!(kVar instanceof j)) {
            return false;
        } else {
            final j jVar = (j) kVar;
            if (i != 0 || i2 != 0) {
                w.e("MicroMsg.CollectCreateQRCodeUI", "net error: %s", new Object[]{jVar});
                return false;
            } else if (jVar.kAC == 0) {
                intent = new Intent();
                intent.putExtra("ftf_pay_url", jVar.kAE);
                intent.putExtra("ftf_fixed_fee", ((double) jVar.fZT) / 100.0d);
                intent.putExtra("ftf_fixed_desc", jVar.desc);
                intent.putExtra("key_currency_unit", jVar.kAN);
                setResult(-1, intent);
                finish();
                return true;
            } else if (jVar.kAF == 0) {
                g.b(this.uSU.uTo, jVar.kAD, jVar.kAG, false);
                return true;
            } else if (jVar.kAF != 1) {
                return false;
            } else {
                if (!(bg.mA(jVar.kAH) || bg.mA(jVar.kAI))) {
                    g.a(this.uSU.uTo, jVar.kAD, jVar.kAG, jVar.kAI, jVar.kAH, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ CollectCreateQRCodeUI kBY;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (!bg.mA(jVar.kAJ)) {
                                w.i("MicroMsg.CollectCreateQRCodeUI", "goto h5: %s", new Object[]{jVar.kAJ});
                                e.m(this.kBY.uSU.uTo, jVar.kAJ, true);
                            }
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ CollectCreateQRCodeUI kBY;

                        {
                            this.kBY = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
                return true;
            }
        }
    }
}
