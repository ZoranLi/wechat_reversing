package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.order.c.a;
import com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.b;
import com.tencent.mm.plugin.wallet_payu.remittance.a.c;
import com.tencent.mm.plugin.wallet_payu.remittance.a.f;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;

public class PayURemittanceDetailUI extends RemittanceDetailUI {
    private String oSK;
    private int oSi;
    private int ogs;
    private int ogt;
    private String rSO;
    private String rSP;
    private int rSQ;
    private int rSR;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.oSi = getIntent().getIntExtra("total_fee", 0);
        this.rSO = getIntent().getStringExtra("fee_type");
        if (getIntent().getBooleanExtra("is_sender", false)) {
            this.rSP = m.xL();
            this.oSK = this.oSd;
            return;
        }
        this.rSP = this.oSd;
        this.oSK = m.xL();
    }

    protected final void rU(int i) {
        b(new f(this.oSe, this.oSd, this.oSa), true);
    }

    protected final void rV(int i) {
        b(new f(this.oSe, this.oSd, this.oSa, 1, i), true);
    }

    protected final void O(Intent intent) {
        d.b(this, "wallet_payu", ".remittance.ui.PayURemittanceResendMsgUI", intent);
    }

    protected final void aXr() {
        k(new c(this.oSe, this.oSi, this.rSO, this.oSd));
    }

    protected final void aXs() {
        k(new b(this.oSe, this.oSi, this.rSO, this.oSd));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof f) {
            f fVar = (f) kVar;
            String string;
            CharSequence spannableString;
            a aVar;
            if (fVar.fJA != 0) {
                boolean equals;
                boolean z = false;
                if (i == 0 && i2 == 0) {
                    this.rSQ = fVar.status;
                    this.rSR = fVar.oQL;
                    this.ogt = fVar.rSK;
                    this.ogs = fVar.rSL;
                    this.oSi = (int) (fVar.kBc * 100.0d);
                    this.rSO = fVar.oga;
                    z = true;
                    equals = this.oSK.equals(m.xL());
                    this.oRX.setVisibility(8);
                    this.oRW.setText(e.d(((double) this.oSi) / 100.0d, this.rSO));
                    int i3 = this.rSQ;
                    String string2;
                    CharSequence spannableString2;
                    a aVar2;
                    switch (i3) {
                        case MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN /*2000*/:
                            if (equals) {
                                this.oRU.setImageResource(R.g.blW);
                                this.oRX.setVisibility(0);
                                this.oRX.setOnClickListener(new OnClickListener(this) {
                                    final /* synthetic */ PayURemittanceDetailUI rSS;

                                    {
                                        this.rSS = r1;
                                    }

                                    public final void onClick(View view) {
                                        this.rSS.aXr();
                                    }
                                });
                                string = getString(R.l.eKZ, new Object[]{Integer.valueOf(this.oSg)});
                                string2 = getString(R.l.eKN);
                                spannableString2 = new SpannableString(string + string2);
                                aVar2 = new a(this);
                                aVar2.oiL = new a.a(this) {
                                    final /* synthetic */ PayURemittanceDetailUI rSS;

                                    {
                                        this.rSS = r1;
                                    }

                                    public final void onClick(View view) {
                                        g.a(this.rSS, this.rSS.getString(R.l.eKJ, new Object[]{RemittanceDetailUI.ah(this.rSS.rSP, false)}), this.rSS.getString(R.l.dIs), this.rSS.getString(R.l.eKO), this.rSS.getString(R.l.dGs), new DialogInterface.OnClickListener(this) {
                                            final /* synthetic */ AnonymousClass3 rSU;

                                            {
                                                this.rSU = r1;
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                this.rSU.rSS.aXs();
                                            }
                                        }, new DialogInterface.OnClickListener(this) {
                                            final /* synthetic */ AnonymousClass3 rSU;

                                            {
                                                this.rSU = r1;
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                            }
                                        });
                                    }
                                };
                                spannableString2.setSpan(aVar2, string.length(), string.length() + string2.length(), 33);
                                this.nrA.setMovementMethod(LinkMovementMethod.getInstance());
                                this.nrA.setText(spannableString2);
                            } else {
                                this.oRV.setText(h.b(this, getString(R.l.eKW, new Object[]{RemittanceDetailUI.ah(this.oSK, true)}), this.oRV.getTextSize()));
                                string = getString(R.l.eLd, new Object[]{Integer.valueOf(this.oSg)});
                                string2 = getString(R.l.eLu);
                                spannableString2 = new SpannableString(string + string2);
                                aVar2 = new a(this);
                                aVar2.oiL = new a.a(this) {
                                    final /* synthetic */ PayURemittanceDetailUI rSS;

                                    {
                                        this.rSS = r1;
                                    }

                                    public final void onClick(View view) {
                                        g.a(this.rSS, this.rSS.getString(R.l.eKx), this.rSS.getString(R.l.dIs), this.rSS.getString(R.l.eLt), this.rSS.getString(R.l.dGs), new DialogInterface.OnClickListener(this) {
                                            final /* synthetic */ AnonymousClass1 rST;

                                            {
                                                this.rST = r1;
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                Intent intent = new Intent();
                                                intent.putExtra("transaction_id", this.rST.rSS.oSc);
                                                intent.putExtra("receiver_name", this.rST.rSS.oSK);
                                                intent.putExtra("total_fee", this.rST.rSS.oSi);
                                                intent.putExtra("fee_type", this.rST.rSS.rSO);
                                                this.rST.rSS.O(intent);
                                            }
                                        }, new DialogInterface.OnClickListener(this) {
                                            final /* synthetic */ AnonymousClass1 rST;

                                            {
                                                this.rST = r1;
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                            }
                                        });
                                    }
                                };
                                spannableString2.setSpan(aVar2, string.length(), string.length() + string2.length(), 33);
                                this.nrA.setMovementMethod(LinkMovementMethod.getInstance());
                                this.nrA.setText(spannableString2);
                            }
                            this.oRU.setImageResource(R.g.blW);
                            this.oRY.setText(getString(R.l.eLe, new Object[]{e.CK(this.ogt)}));
                            this.oRY.setVisibility(0);
                            this.oRZ.setVisibility(8);
                            equals = true;
                            break;
                        case MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN /*2001*/:
                            this.oRU.setImageResource(R.k.dzj);
                            if (equals) {
                                this.oRV.setText(R.l.eKQ);
                                Object string3 = getString(R.l.eKB);
                                spannableString = new SpannableString(string3);
                                aVar = new a(this);
                                aVar.oiL = new a.a(this) {
                                    final /* synthetic */ PayURemittanceDetailUI rSS;

                                    {
                                        this.rSS = r1;
                                    }

                                    public final void onClick(View view) {
                                        com.tencent.mm.pluginsdk.wallet.e.R(this.rSS, 0);
                                    }
                                };
                                spannableString.setSpan(aVar, 0, string3.length(), 33);
                                this.nrA.setMovementMethod(LinkMovementMethod.getInstance());
                                this.nrA.setText(spannableString);
                                this.nrA.setVisibility(0);
                            } else {
                                this.oRV.setText(h.b(this, RemittanceDetailUI.ah(this.oSK, true) + " " + getString(R.l.eKQ), this.oRV.getTextSize()));
                                this.nrA.setVisibility(8);
                            }
                            this.oRY.setText(getString(R.l.eLe, new Object[]{e.CK(this.rSR)}));
                            this.oRY.setVisibility(0);
                            this.oRZ.setText(getString(R.l.eKF, new Object[]{e.CK(this.ogs)}));
                            this.oRZ.setVisibility(0);
                            equals = true;
                            break;
                        case MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK /*2002*/:
                        case MMBitmapFactory.ERROR_ILLEGAL_IDATA_CHUNK /*2003*/:
                            if (i3 != MMBitmapFactory.ERROR_ILLEGAL_IDATA_CHUNK || equals) {
                                this.oRU.setImageResource(R.k.dzk);
                                if (equals) {
                                    this.oRV.setText(R.l.eKS);
                                } else {
                                    this.oRV.setText(h.b(this, RemittanceDetailUI.ah(this.oSK, true) + getString(R.l.eKS), this.oRV.getTextSize()));
                                }
                            } else {
                                this.oRU.setImageResource(R.k.dzl);
                                this.oRV.setText(R.l.eKU);
                            }
                            if (equals) {
                                this.nrA.setText("");
                            } else {
                                string = getString(R.l.eKK);
                                string2 = getString(R.l.eKB);
                                spannableString2 = new SpannableString(string + string2);
                                aVar2 = new a(this);
                                aVar2.oiL = new a.a(this) {
                                    final /* synthetic */ PayURemittanceDetailUI rSS;

                                    {
                                        this.rSS = r1;
                                    }

                                    public final void onClick(View view) {
                                        com.tencent.mm.pluginsdk.wallet.e.R(this.rSS, 0);
                                    }
                                };
                                spannableString2.setSpan(aVar2, string.length(), string.length() + string2.length(), 33);
                                this.nrA.setMovementMethod(LinkMovementMethod.getInstance());
                                this.nrA.setText(spannableString2);
                            }
                            this.nrA.setVisibility(0);
                            this.oRY.setText(getString(R.l.eLe, new Object[]{e.CK(this.rSR)}));
                            this.oRY.setVisibility(0);
                            this.oRZ.setText(getString(R.l.eKI, new Object[]{e.CK(this.ogt)}));
                            this.oRZ.setVisibility(0);
                            equals = true;
                            break;
                        default:
                            finish();
                            break;
                    }
                }
                equals = z;
                if (fVar.fRW != 1) {
                    return equals;
                }
                ap.yY();
                if (((String) com.tencent.mm.u.c.vr().get(327729, "0")).equals("0")) {
                    g.a(this.uSU.uTo, R.l.dTT, R.l.dTU, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ PayURemittanceDetailUI rSS;

                        {
                            this.rSS = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            g.bl(this.rSS.uSU.uTo, this.rSS.getString(R.l.eKD));
                        }
                    });
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(327729, "1");
                    return equals;
                }
                g.bl(this.uSU.uTo, getString(R.l.eKD));
                return equals;
            } else if (i == 0 && i2 == 0) {
                if (this.oSb == 1 && !getIntent().getBooleanExtra("is_sender", false)) {
                    this.oRU.setImageResource(R.g.blW);
                    this.oRV.setText(R.l.eKV);
                    this.oRW.setText(e.d(fVar.kBc, fVar.oga));
                    this.oRX.setVisibility(0);
                    this.oRX.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ PayURemittanceDetailUI rSS;

                        {
                            this.rSS = r1;
                        }

                        public final void onClick(View view) {
                            this.rSS.aXr();
                        }
                    });
                    String string4 = getString(R.l.eKZ, new Object[]{Integer.valueOf(this.oSg)});
                    string = getString(R.l.eKN);
                    spannableString = new SpannableString(string4 + string);
                    aVar = new a(this);
                    aVar.oiL = new a.a(this) {
                        final /* synthetic */ PayURemittanceDetailUI rSS;

                        {
                            this.rSS = r1;
                        }

                        public final void onClick(View view) {
                            g.a(this.rSS, this.rSS.getString(R.l.eKJ, new Object[]{RemittanceDetailUI.ah(this.rSS.oSd, false)}), this.rSS.getString(R.l.dIs), this.rSS.getString(R.l.eKO), this.rSS.getString(R.l.dGs), new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ AnonymousClass7 rSV;

                                {
                                    this.rSV = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.rSV.rSS.aXs();
                                }
                            }, new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ AnonymousClass7 rSV;

                                {
                                    this.rSV = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                        }
                    };
                    spannableString.setSpan(aVar, string4.length(), string4.length() + string.length(), 33);
                    this.nrA.setMovementMethod(LinkMovementMethod.getInstance());
                    this.nrA.setText(spannableString);
                    this.oRY.setText(getString(R.l.eLe, new Object[]{e.CK(fVar.oQL)}));
                    this.oRY.setVisibility(0);
                    this.oRZ.setVisibility(8);
                }
                return true;
            } else {
                rV(0);
                return true;
            }
        } else if (!(kVar instanceof c) && !(kVar instanceof b)) {
            return false;
        } else {
            if (i == 0 && i2 == 0) {
                if (kVar instanceof c) {
                    rV(1);
                } else {
                    aj(0, getString(R.l.eKE));
                }
                return true;
            }
            aj(i2, str);
            return true;
        }
    }
}
