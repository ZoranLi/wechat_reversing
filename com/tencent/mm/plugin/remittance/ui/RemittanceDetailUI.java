package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.mh;
import com.tencent.mm.plugin.order.model.h;
import com.tencent.mm.plugin.remittance.c.f;
import com.tencent.mm.plugin.remittance.c.i;
import com.tencent.mm.plugin.wallet_core.b.r;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;

public class RemittanceDetailUI extends WalletBaseUI {
    public TextView nrA = null;
    private String oRA = null;
    private int oRB;
    public ImageView oRU = null;
    public TextView oRV = null;
    public TextView oRW = null;
    public Button oRX = null;
    public TextView oRY = null;
    public TextView oRZ = null;
    public int oSa;
    public int oSb;
    public String oSc = null;
    public String oSd = null;
    public String oSe = null;
    protected String oSf = null;
    public int oSg = 3;
    protected boolean oSh = false;
    protected int oSi;
    private int oSj;
    private f oSk;
    private c<mh> oSl = new c<mh>(this) {
        final /* synthetic */ RemittanceDetailUI oSm;

        {
            this.oSm = r2;
            this.usg = mh.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final mh mhVar = (mh) bVar;
            if (!(bg.mA(mhVar.fTz.fTA) || bg.mA(mhVar.fTz.fST))) {
                g.a(this.oSm, this.oSm.getString(R.l.eKJ, new Object[]{RemittanceDetailUI.ah(this.oSm.ogw, false)}), this.oSm.getString(R.l.dIs), this.oSm.getString(R.l.eKO), this.oSm.getString(R.l.dGs), new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass1 oSo;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        k fVar = new f(mhVar.fTz.fTA, mhVar.fTz.fST, mhVar.fTz.fTB, "refuse", mhVar.fTz.fTC, mhVar.fTz.fTD);
                        fVar.gWO = "RemittanceProcess";
                        this.oSo.oSm.k(fVar);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass1 oSo;

                    {
                        this.oSo = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
            return false;
        }
    };
    private String ogw;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.oSa = getIntent().getIntExtra("invalid_time", 0);
        this.oSb = getIntent().getIntExtra("appmsg_type", 0);
        this.oSc = getIntent().getStringExtra("transaction_id");
        this.oSf = getIntent().getStringExtra("bill_id");
        this.oSe = getIntent().getStringExtra("transfer_id");
        this.oSd = getIntent().getStringExtra("sender_name");
        this.oSg = getIntent().getIntExtra("effective_date", 3);
        this.oSh = getIntent().getBooleanExtra("is_sender", false);
        this.oSi = getIntent().getIntExtra("total_fee", 0);
        KC();
        rU(0);
        a.urY.b(this.oSl);
    }

    public void onDestroy() {
        a.urY.c(this.oSl);
        super.onDestroy();
    }

    public void rU(int i) {
        b(new i(i, this.oSc, this.oSe, this.oSa), true);
    }

    protected final void KC() {
        zi(R.l.eLz);
        this.oRU = (ImageView) findViewById(R.h.cxT);
        this.oRV = (TextView) findViewById(R.h.cxW);
        this.oRW = (TextView) findViewById(R.h.cxU);
        this.oRX = (Button) findViewById(R.h.cxS);
        this.nrA = (TextView) findViewById(R.h.cxV);
        this.oRY = (TextView) findViewById(R.h.cxX);
        this.oRZ = (TextView) findViewById(R.h.cxY);
    }

    public void rV(int i) {
        k hVar;
        if (getIntent().getBooleanExtra("is_sender", false)) {
            hVar = new h(this.oSc, this.oSf, i);
        } else {
            hVar = new h(this.oSe, this.oSf, i);
        }
        hVar.gWO = "RemittanceProcess";
        k(hVar);
    }

    public void O(Intent intent) {
        d.b(this, "remittance", ".ui.RemittanceResendMsgUI", intent);
    }

    public void aXr() {
        k fVar = new f(this.oSc, this.oSe, this.oSi, "confirm", this.oSd, this.oSa);
        fVar.gWO = "RemittanceProcess";
        k(fVar);
    }

    public void aXs() {
        k fVar = new f(this.oSc, this.oSe, this.oSi, "refuse", this.oSd, this.oSa);
        fVar.gWO = "RemittanceProcess";
        k(fVar);
    }

    private void aXk() {
        if (this.oSj == 0 || this.oRB != 1 || bg.mA(this.oRA)) {
            w.i("MicroMsg.RemittanceDetailUI", "flag: %d, descUrl empty: %B", new Object[]{Integer.valueOf(this.oSj), Boolean.valueOf(bg.mA(this.oRA))});
            this.uSU.bQf();
            return;
        }
        a(0, R.g.blV, new OnMenuItemClickListener(this) {
            final /* synthetic */ RemittanceDetailUI oSm;

            {
                this.oSm = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                e.m(this.oSm.uSU.uTo, this.oSm.oRA, false);
                return false;
            }
        });
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof i) {
            final i iVar = (i) kVar;
            if (i == 0 && i2 == 0) {
                if (iVar != null) {
                    boolean equals = iVar.oQM.equals(m.xL());
                    this.oRX.setVisibility(8);
                    this.oRW.setText(e.d(iVar.kBc, iVar.oga));
                    CharSequence charSequence = iVar.oQQ;
                    if (!bg.mA(charSequence) && charSequence.contains("%s")) {
                        charSequence = charSequence.trim().replace("%s", ah(iVar.oQM, true));
                    }
                    CharSequence charSequence2 = iVar.oQR;
                    Bundle bundle = new Bundle();
                    bundle.putString("transaction_id", this.oSc);
                    bundle.putString("receiver_name", iVar.oQM);
                    bundle.putString("transfer_id", this.oSe);
                    bundle.putInt("total_fee", this.oSi);
                    bundle.putString("sender_name", this.oSd);
                    bundle.putInt("invalid_time", this.oSa);
                    this.nrA.setClickable(true);
                    this.oRV.setClickable(true);
                    this.ogw = iVar.oQO;
                    int i3 = iVar.status;
                    w.d("MicroMsg.RemittanceDetailUI", "status: %d", new Object[]{Integer.valueOf(i3)});
                    String string;
                    String string2;
                    CharSequence spannableString;
                    switch (i3) {
                        case MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN /*2000*/:
                            com.tencent.mm.plugin.order.c.a aVar;
                            if (equals) {
                                this.oRU.setImageResource(R.k.dzm);
                                this.oRX.setVisibility(0);
                                this.oRX.setOnClickListener(new View.OnClickListener(this) {
                                    final /* synthetic */ RemittanceDetailUI oSm;

                                    {
                                        this.oSm = r1;
                                    }

                                    public final void onClick(View view) {
                                        com.tencent.mm.plugin.wallet_core.model.m.btN();
                                        if (!com.tencent.mm.plugin.wallet_core.model.m.a(this.oSm, this.oSm.wFr, new com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this) {
                                            final /* synthetic */ AnonymousClass3 oSr;

                                            {
                                                this.oSr = r1;
                                            }

                                            public final boolean a(int i, int i2, String str, boolean z) {
                                                if (i == 2) {
                                                    this.oSr.oSm.aXr();
                                                } else if (i == 0 && z) {
                                                    this.oSr.oSm.aXr();
                                                }
                                                return true;
                                            }
                                        })) {
                                            this.oSm.aXr();
                                        }
                                    }
                                });
                                if (bg.mA(charSequence) || bg.mA(charSequence2)) {
                                    this.oRV.setText(R.l.eKV);
                                    if (iVar.oQS == 0) {
                                        string = getString(R.l.eKY, new Object[]{Integer.valueOf(this.oSg)});
                                    } else if (bg.mA(iVar.oQR)) {
                                        w.i("MicroMsg.RemittanceDetailUI", "use hardcode wording");
                                        string = iVar.oQS == 1 ? "24" : "2";
                                        string = getString(R.l.eKX, new Object[]{string}) + getString(R.l.eKY, new Object[]{Integer.valueOf(this.oSg)});
                                    } else {
                                        string = iVar.oQR;
                                    }
                                    string2 = getString(R.l.eKN);
                                    charSequence2 = new SpannableString(string + string2);
                                    aVar = new com.tencent.mm.plugin.order.c.a(this);
                                    aVar.oiL = new com.tencent.mm.plugin.order.c.a.a(this) {
                                        final /* synthetic */ RemittanceDetailUI oSm;

                                        public final void onClick(View view) {
                                            g.a(this.oSm, this.oSm.getString(R.l.eKJ, new Object[]{RemittanceDetailUI.ah(iVar.oQO, false)}), this.oSm.getString(R.l.dIs), this.oSm.getString(R.l.eKO), this.oSm.getString(R.l.dGs), new OnClickListener(this) {
                                                final /* synthetic */ AnonymousClass4 oSs;

                                                {
                                                    this.oSs = r1;
                                                }

                                                public final void onClick(DialogInterface dialogInterface, int i) {
                                                    this.oSs.oSm.aXs();
                                                }
                                            }, new OnClickListener(this) {
                                                final /* synthetic */ AnonymousClass4 oSs;

                                                {
                                                    this.oSs = r1;
                                                }

                                                public final void onClick(DialogInterface dialogInterface, int i) {
                                                }
                                            });
                                        }
                                    };
                                    charSequence2.setSpan(aVar, string.length(), string.length() + string2.length(), 33);
                                    this.nrA.setMovementMethod(LinkMovementMethod.getInstance());
                                    this.nrA.setText(charSequence2);
                                } else {
                                    this.oRV.setText(com.tencent.mm.pluginsdk.ui.d.h.a(this, charSequence, (int) this.oRV.getTextSize(), bundle));
                                    this.nrA.setText(com.tencent.mm.pluginsdk.ui.d.h.a(this, charSequence2, (int) this.nrA.getTextSize(), bundle));
                                    this.oRV.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.k());
                                    this.nrA.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.k());
                                }
                            } else if (bg.mA(charSequence) || bg.mA(charSequence2)) {
                                this.oRV.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, getString(R.l.eKW, new Object[]{ah(iVar.oQM, true)}), this.oRV.getTextSize()));
                                string = getString(R.l.eLc, new Object[]{Integer.valueOf(this.oSg)});
                                string2 = getString(R.l.eLu);
                                charSequence2 = new SpannableString(string + string2);
                                aVar = new com.tencent.mm.plugin.order.c.a(this);
                                aVar.oiL = new com.tencent.mm.plugin.order.c.a.a(this) {
                                    final /* synthetic */ RemittanceDetailUI oSm;

                                    public final void onClick(View view) {
                                        g.a(this.oSm, this.oSm.getString(R.l.eKx), this.oSm.getString(R.l.dIs), this.oSm.getString(R.l.eLt), this.oSm.getString(R.l.dGs), new OnClickListener(this) {
                                            final /* synthetic */ AnonymousClass2 oSq;

                                            {
                                                this.oSq = r1;
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                Intent intent = new Intent();
                                                intent.putExtra("transaction_id", this.oSq.oSm.oSc);
                                                intent.putExtra("receiver_name", iVar.oQM);
                                                this.oSq.oSm.O(intent);
                                            }
                                        }, new OnClickListener(this) {
                                            final /* synthetic */ AnonymousClass2 oSq;

                                            {
                                                this.oSq = r1;
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                            }
                                        });
                                    }
                                };
                                charSequence2.setSpan(aVar, string.length(), string.length() + string2.length(), 33);
                                this.nrA.setMovementMethod(LinkMovementMethod.getInstance());
                                this.nrA.setText(charSequence2);
                            } else {
                                this.oRV.setText(com.tencent.mm.pluginsdk.ui.d.h.a(this, charSequence, (int) this.oRV.getTextSize(), bundle));
                                this.nrA.setText(com.tencent.mm.pluginsdk.ui.d.h.a(this, charSequence2, (int) this.nrA.getTextSize(), bundle));
                                this.oRV.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.k());
                                this.nrA.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.k());
                            }
                            this.oRU.setImageResource(R.k.dzm);
                            this.oRY.setText(getString(R.l.eLe, new Object[]{e.CK(iVar.oQL)}));
                            this.oRY.setVisibility(0);
                            this.oRZ.setVisibility(8);
                            break;
                        case MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN /*2001*/:
                            this.oRU.setImageResource(R.k.dzj);
                            if (!bg.mA(charSequence) && !bg.mA(charSequence2)) {
                                this.oRV.setText(com.tencent.mm.pluginsdk.ui.d.h.a(this, charSequence, (int) this.oRV.getTextSize(), bundle));
                                this.nrA.setText(com.tencent.mm.pluginsdk.ui.d.h.a(this, charSequence2, (int) this.nrA.getTextSize(), bundle));
                                this.oRV.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.k());
                                this.nrA.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.k());
                            } else if (equals) {
                                this.oRV.setText(R.l.eKQ);
                                charSequence = new SpannableStringBuilder(getString(R.l.eKB));
                                com.tencent.mm.plugin.order.c.a aVar2 = new com.tencent.mm.plugin.order.c.a(this);
                                aVar2.oiL = new com.tencent.mm.plugin.order.c.a.a(this) {
                                    final /* synthetic */ RemittanceDetailUI oSm;

                                    {
                                        this.oSm = r1;
                                    }

                                    public final void onClick(View view) {
                                        com.tencent.mm.pluginsdk.wallet.e.R(this.oSm, 0);
                                    }
                                };
                                charSequence.setSpan(aVar2, 0, charSequence.length(), 18);
                                this.nrA.setMovementMethod(LinkMovementMethod.getInstance());
                                this.nrA.setText(charSequence);
                                this.nrA.setVisibility(0);
                            } else {
                                this.oRV.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, ah(iVar.oQM, true) + getString(R.l.eKQ), this.oRV.getTextSize()));
                                this.nrA.setText(R.l.eLb);
                                this.nrA.setVisibility(0);
                            }
                            this.oRY.setText(getString(R.l.eLe, new Object[]{e.CK(iVar.oQL)}));
                            this.oRY.setVisibility(0);
                            this.oRZ.setText(getString(R.l.eKF, new Object[]{e.CK(iVar.oQP)}));
                            this.oRZ.setVisibility(0);
                            break;
                        case MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK /*2002*/:
                        case MMBitmapFactory.ERROR_ILLEGAL_IDATA_CHUNK /*2003*/:
                            if (i3 != MMBitmapFactory.ERROR_ILLEGAL_IDATA_CHUNK || equals) {
                                this.oRU.setImageResource(R.k.dzk);
                                if (!bg.mA(charSequence)) {
                                    this.oRV.setText(com.tencent.mm.pluginsdk.ui.d.h.a(this, charSequence, (int) this.oRV.getTextSize(), bundle));
                                    this.oRV.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.k());
                                } else if (equals) {
                                    this.oRV.setText(R.l.eKS);
                                } else {
                                    this.oRV.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, ah(iVar.oQM, true) + getString(R.l.eKS), this.oRV.getTextSize()));
                                }
                            } else {
                                this.oRU.setImageResource(R.k.dzl);
                                if (bg.mA(charSequence)) {
                                    this.oRV.setText(R.l.eKU);
                                } else {
                                    this.oRV.setText(com.tencent.mm.pluginsdk.ui.d.h.a(this, charSequence, (int) this.oRV.getTextSize(), bundle));
                                    this.oRV.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.k());
                                }
                            }
                            if (equals) {
                                this.nrA.setVisibility(8);
                            } else {
                                if (!bg.mA(charSequence2)) {
                                    this.nrA.setText(com.tencent.mm.pluginsdk.ui.d.h.a(this, charSequence2, (int) this.nrA.getTextSize(), bundle));
                                    this.nrA.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.k());
                                } else if ("CFT".equals(iVar.ogy) || "LQT".equals(iVar.ogy)) {
                                    final boolean equals2 = "LQT".equals(iVar.ogy);
                                    string2 = equals2 ? getString(R.l.eKM) : getString(R.l.eKK);
                                    string = equals2 ? getString(R.l.eKC) : getString(R.l.eKB);
                                    spannableString = new SpannableString(string2 + string);
                                    com.tencent.mm.plugin.order.c.a aVar3 = new com.tencent.mm.plugin.order.c.a(this);
                                    aVar3.oiL = new com.tencent.mm.plugin.order.c.a.a(this) {
                                        final /* synthetic */ RemittanceDetailUI oSm;

                                        public final void onClick(View view) {
                                            if (equals2) {
                                                d.w(this.oSm, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                                            } else {
                                                com.tencent.mm.pluginsdk.wallet.e.R(this.oSm, 0);
                                            }
                                        }
                                    };
                                    spannableString.setSpan(aVar3, string2.length(), string.length() + string2.length(), 33);
                                    this.nrA.setMovementMethod(LinkMovementMethod.getInstance());
                                    this.nrA.setText(spannableString);
                                } else {
                                    this.nrA.setText(R.l.eKL);
                                }
                                this.nrA.setVisibility(0);
                            }
                            this.oRY.setText(getString(R.l.eLe, new Object[]{e.CK(iVar.oQL)}));
                            this.oRY.setVisibility(0);
                            this.oRZ.setText(getString(R.l.eKI, new Object[]{e.CK(iVar.oQP)}));
                            this.oRZ.setVisibility(0);
                            break;
                        case 2004:
                            if (equals) {
                                this.oRU.setImageResource(R.k.dzm);
                                if (bg.mA(charSequence) || bg.mA(charSequence2)) {
                                    if (bg.mA(iVar.oQQ)) {
                                        this.oRV.setText(R.l.eKR);
                                    } else {
                                        this.oRV.setText(iVar.oQQ);
                                    }
                                    if (bg.mA(iVar.oQR)) {
                                        this.nrA.setText(R.l.eKH);
                                    } else {
                                        this.nrA.setText(iVar.oQR);
                                    }
                                } else {
                                    this.oRV.setText(com.tencent.mm.pluginsdk.ui.d.h.a(this, charSequence, (int) this.oRV.getTextSize(), bundle));
                                    this.nrA.setText(com.tencent.mm.pluginsdk.ui.d.h.a(this, charSequence2, (int) this.nrA.getTextSize(), bundle));
                                    this.oRV.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.k());
                                    this.nrA.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.k());
                                }
                            } else {
                                this.oRU.setImageResource(R.k.dzm);
                                if (bg.mA(charSequence) || bg.mA(charSequence2)) {
                                    if (!bg.mA(iVar.oQQ)) {
                                        try {
                                            this.oRV.setText(String.format(iVar.oQQ, new Object[]{ah(iVar.oQM, true)}));
                                        } catch (Throwable e) {
                                            w.printErrStackTrace("MicroMsg.RemittanceDetailUI", e, "", new Object[0]);
                                        }
                                        if (bg.mA(iVar.oQR)) {
                                            this.nrA.setText(iVar.oQR);
                                        } else {
                                            this.nrA.setText("");
                                        }
                                    }
                                    this.oRV.setText(getString(R.l.eKT, new Object[]{ah(iVar.oQM, true)}));
                                    if (bg.mA(iVar.oQR)) {
                                        this.nrA.setText("");
                                    } else {
                                        this.nrA.setText(iVar.oQR);
                                    }
                                } else {
                                    this.oRV.setText(com.tencent.mm.pluginsdk.ui.d.h.a(this, charSequence, (int) this.oRV.getTextSize(), bundle));
                                    this.nrA.setText(com.tencent.mm.pluginsdk.ui.d.h.a(this, charSequence2, (int) this.nrA.getTextSize(), bundle));
                                    this.oRV.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.k());
                                    this.nrA.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.k());
                                }
                            }
                            this.oRY.setText(getString(R.l.eLe, new Object[]{e.CK(iVar.oQL)}));
                            this.oRY.setVisibility(0);
                            this.oRZ.setText(getString(R.l.eKF, new Object[]{e.CK(iVar.oQP)}));
                            this.oRZ.setVisibility(0);
                            break;
                        case 2005:
                            this.oRU.setImageResource(R.k.dzi);
                            if (bg.mA(charSequence) || bg.mA(charSequence2)) {
                                if (bg.mA(iVar.oQQ)) {
                                    this.oRV.setText(R.l.eKP);
                                } else {
                                    this.oRV.setText(iVar.oQQ);
                                }
                                if (bg.mA(iVar.oQR)) {
                                    if (equals) {
                                        this.nrA.setText(R.l.eKG);
                                    } else {
                                        this.nrA.setText(R.l.eLa);
                                    }
                                } else if ("CFT".equals(iVar.ogy) || "LQT".equals(iVar.ogy)) {
                                    equals = "LQT".equals(iVar.ogy);
                                    Object obj = iVar.oQR;
                                    charSequence = equals ? getString(R.l.eKC) : getString(R.l.eKB);
                                    spannableString = new SpannableStringBuilder();
                                    spannableString.append(obj);
                                    spannableString.append(charSequence);
                                    com.tencent.mm.plugin.order.c.a aVar4 = new com.tencent.mm.plugin.order.c.a(this);
                                    aVar4.oiL = new com.tencent.mm.plugin.order.c.a.a(this) {
                                        final /* synthetic */ RemittanceDetailUI oSm;

                                        public final void onClick(View view) {
                                            if (equals) {
                                                d.w(this.oSm, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                                            } else {
                                                com.tencent.mm.pluginsdk.wallet.e.R(this.oSm, 0);
                                            }
                                        }
                                    };
                                    spannableString.setSpan(aVar4, obj.length(), spannableString.length(), 18);
                                    this.nrA.setMovementMethod(LinkMovementMethod.getInstance());
                                    this.nrA.setText(spannableString);
                                } else {
                                    this.nrA.setText(iVar.oQR);
                                }
                            } else {
                                this.oRV.setText(com.tencent.mm.pluginsdk.ui.d.h.a(this, charSequence, (int) this.oRV.getTextSize(), bundle));
                                this.nrA.setText(com.tencent.mm.pluginsdk.ui.d.h.a(this, charSequence2, (int) this.nrA.getTextSize(), bundle));
                                this.oRV.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.k());
                                this.nrA.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.k());
                            }
                            this.oRY.setText(getString(R.l.eLe, new Object[]{e.CK(iVar.oQL)}));
                            this.oRY.setVisibility(0);
                            if (iVar.oQP <= 0) {
                                this.oRZ.setVisibility(8);
                                break;
                            }
                            this.oRZ.setText(getString(R.l.eKA, new Object[]{e.CK(iVar.oQP)}));
                            this.oRZ.setVisibility(0);
                            break;
                            break;
                        default:
                            finish();
                            break;
                    }
                    this.oSj = iVar.oQS;
                }
                ap.yY();
                this.oRA = (String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uFJ, "");
                ap.yY();
                this.oRB = ((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uFK, Integer.valueOf(0))).intValue();
                if (bg.mA(this.oRA)) {
                    r.a(true, this.wFr);
                } else {
                    r.a(false, this.wFr);
                }
                aXk();
                if (iVar.ogI == 1) {
                    ap.yY();
                    if (((String) com.tencent.mm.u.c.vr().get(327729, "0")).equals("0")) {
                        g.a(this.uSU.uTo, m.xY() ? R.l.dTT : R.l.dTS, R.l.dTU, new OnClickListener(this) {
                            final /* synthetic */ RemittanceDetailUI oSm;

                            {
                                this.oSm = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                g.bl(this.oSm.uSU.uTo, this.oSm.getString(R.l.eKD));
                            }
                        });
                        ap.yY();
                        com.tencent.mm.u.c.vr().set(327729, "1");
                    } else if (this.oSj == 0) {
                        g.bl(this.uSU.uTo, getString(R.l.eKD));
                    }
                }
                return true;
            }
        } else if (kVar instanceof f) {
            if (i == 0 && i2 == 0) {
                this.oSk = (f) kVar;
                if ("confirm".equals(this.oSk.oQo)) {
                    rU(1);
                } else {
                    aj(0, getString(R.l.eKE));
                }
                return true;
            } else if (i2 == 416) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("realname_verify_process_jump_plugin", "remittance");
                bundle2.putString("realname_verify_process_jump_activity", ".ui.RemittanceDetailUI");
                return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, i2, kVar, bundle2, MMBitmapFactory.ERROR_ILLEGAL_IMAGE_SIZE);
            } else {
                aj(i2, str);
                return true;
            }
        } else if (kVar instanceof r) {
            if (i == 0 && i2 == 0) {
                this.oRA = ((r) kVar).rCl;
                this.oRB = ((r) kVar).rCm;
                aXk();
            } else {
                w.i("MicroMsg.RemittanceDetailUI", "net error");
            }
            return true;
        }
        if (kVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.e) {
            return true;
        }
        return false;
    }

    protected final int getLayoutId() {
        return R.i.dmD;
    }

    public final void aj(int i, String str) {
        Intent intent = new Intent();
        intent.putExtra("result_msg", str);
        setResult(i, intent);
        finish();
    }

    public void finish() {
        Bundle bundle = new Bundle();
        bundle.putString("realname_verify_process_jump_plugin", "remittance");
        bundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceDetailUI");
        if (this.oSk == null || !com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, this.oSk, bundle, true, null, MMBitmapFactory.ERROR_ILLEGAL_IMAGE_SIZE, 1)) {
            super.finish();
        } else {
            this.oSk = null;
        }
    }

    public static String ah(String str, boolean z) {
        String eK = e.eK(str);
        if (eK == null) {
            return "";
        }
        if (eK.length() <= 10 || !z) {
            return eK;
        }
        return eK.substring(0, 8) + "...";
    }
}
