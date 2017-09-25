package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.fe;
import com.tencent.mm.plugin.remittance.c.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.b.q;
import com.tencent.mm.plugin.wallet_core.b.r;
import com.tencent.mm.plugin.wallet_core.ui.f;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.x.i;
import com.tencent.mm.x.n;
import com.tencent.mm.y.k;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

@com.tencent.mm.ui.base.a(19)
public abstract class RemittanceBaseUI extends WalletBaseUI implements com.tencent.mm.x.d.a {
    public String gLD;
    protected String gMv;
    public int hPi;
    private final int ipO = com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), 270);
    protected WalletFormView kBW;
    protected Button liz;
    private int npX;
    private double oQw;
    protected String oRA = null;
    protected int oRB;
    private int oRC;
    private Map<String, a> oRD = new HashMap();
    private boolean oRE = false;
    private boolean oRF = false;
    private boolean oRG = false;
    private boolean oRH = false;
    private c<fe> oRI = new c<fe>(this) {
        final /* synthetic */ RemittanceBaseUI oRJ;

        {
            this.oRJ = r2;
            this.usg = fe.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            a aVar = (a) this.oRJ.oRD.get(((fe) bVar).fJG.fJH);
            w.d("MicroMsg.RemittanceBaseUI", "match reqKey: %s, %d", new Object[]{((fe) bVar).fJG.fJH, Integer.valueOf(this.oRJ.oRD.size())});
            if (aVar == null) {
                w.i("MicroMsg.RemittanceBaseUI", "no data for: %s", new Object[]{r1});
            } else {
                ap.vd().a(new com.tencent.mm.plugin.remittance.c.a(aVar.oQB, aVar.kAj, aVar.oQC, aVar.oQD, aVar.boy), 0);
            }
            this.oRJ.oRD.clear();
            return false;
        }
    };
    protected com.tencent.mm.plugin.wallet.a oRe = null;
    public double oRf;
    protected String oRg;
    public int oRh;
    public String oRi;
    protected ImageView oRj;
    protected TextView oRk;
    protected TextView oRl;
    protected TextView oRm;
    protected TextView oRn;
    protected TextView oRo;
    private TextView oRp;
    private TextView oRq;
    protected TextView oRr;
    protected ScrollView oRs;
    private LinearLayout oRt;
    private LinearLayout oRu;
    protected String oRv;
    private String oRw;
    private String oRx;
    private String oRy;
    protected String oRz = null;

    private static class a {
        int boy;
        String kAj;
        String oQB;
        String oQC;
        String oQD;

        a(String str, String str2, String str3, String str4, int i) {
            this.oQB = str;
            this.kAj = str2;
            this.oQC = str3;
            this.oQD = str4;
            this.boy = i;
        }
    }

    public abstract void aXg();

    public abstract void aXj();

    public abstract void aXm();

    public abstract void dj(String str, String str2);

    static /* synthetic */ void c(RemittanceBaseUI remittanceBaseUI) {
        if (bg.mA(remittanceBaseUI.gMv)) {
            remittanceBaseUI.oRn.setVisibility(8);
            if (remittanceBaseUI.hPi == 1) {
                remittanceBaseUI.oRo.setText(R.l.eKs);
            } else {
                remittanceBaseUI.oRo.setText(R.l.eKr);
            }
            remittanceBaseUI.oRo.setVisibility(0);
            return;
        }
        f fVar = new f(remittanceBaseUI.uSU.uTo);
        String string = remittanceBaseUI.getString(R.l.eLf);
        CharSequence a = h.a(remittanceBaseUI, remittanceBaseUI.getString(R.l.dWE, new Object[]{remittanceBaseUI.gMv, string}));
        CharSequence spannableStringBuilder = new SpannableStringBuilder(a);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(R.e.aUA), a.length() - string.length(), a.length(), 34);
        remittanceBaseUI.oRn.setText(spannableStringBuilder);
        remittanceBaseUI.oRo.setVisibility(8);
        remittanceBaseUI.oRn.setVisibility(0);
    }

    static /* synthetic */ void f(RemittanceBaseUI remittanceBaseUI) {
        if (remittanceBaseUI.oRs != null) {
            final int i;
            int[] iArr = new int[2];
            remittanceBaseUI.liz.getLocationInWindow(iArr);
            int dP = (com.tencent.mm.bg.a.dP(remittanceBaseUI) - i) - com.tencent.mm.bg.a.fromDPToPix(remittanceBaseUI, 30);
            w.d("MicroMsg.RemittanceBaseUI", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", new Object[]{Integer.valueOf(iArr[1] + remittanceBaseUI.liz.getHeight()), Integer.valueOf(com.tencent.mm.bg.a.dP(remittanceBaseUI)), Integer.valueOf(dP), Integer.valueOf(remittanceBaseUI.ipO)});
            if (dP > 0 && dP < remittanceBaseUI.ipO) {
                i = remittanceBaseUI.ipO - dP;
                w.d("MicroMsg.RemittanceBaseUI", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", new Object[]{Integer.valueOf(i)});
                remittanceBaseUI.oRs.post(new Runnable(remittanceBaseUI) {
                    final /* synthetic */ RemittanceBaseUI oRJ;

                    public final void run() {
                        this.oRJ.oRs.scrollBy(0, i);
                    }
                });
            }
        }
    }

    protected int getLayoutId() {
        return R.i.dmF;
    }

    public void onCreate(Bundle bundle) {
        this.hPi = getIntent().getIntExtra("scene", 0);
        super.onCreate(bundle);
        this.oRe = com.tencent.mm.plugin.wallet.a.S(getIntent());
        this.oRh = getIntent().getIntExtra("pay_scene", 31);
        this.oRi = getIntent().getStringExtra("scan_remittance_id");
        this.oRf = getIntent().getDoubleExtra("fee", 0.0d);
        this.gLD = getIntent().getStringExtra("receiver_name");
        this.oRg = getIntent().getStringExtra("receiver_nick_name");
        this.oRy = getIntent().getStringExtra("receiver_true_name");
        this.npX = getIntent().getIntExtra("pay_channel", 0);
        if (bg.mA(this.gLD)) {
            aXq();
        }
        ap.yY();
        long longValue = ((Long) com.tencent.mm.u.c.vr().get(147457, Long.valueOf(0))).longValue();
        if ((16 & longValue) != 0) {
            this.oRC = 1;
        } else if ((longValue & 32) != 0) {
            this.oRC = 2;
        } else {
            this.oRC = 0;
        }
        aXg();
        n.Bl().a(this);
        KC();
        this.oRI.bIy();
    }

    public void onDestroy() {
        super.onDestroy();
        n.Bl().b(this);
        this.oRI.dead();
    }

    public void aXh() {
        k eVar = new e(this.gLD, this.oRi);
        eVar.gWO = "RemittanceProcess";
        k(eVar);
    }

    public void aXi() {
    }

    protected final void KC() {
        if (this.hPi == 1) {
            zi(R.l.eKw);
        } else {
            zi(R.l.eLB);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RemittanceBaseUI oRJ;

            {
                this.oRJ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.oRJ.hPi == 1 || this.oRJ.hPi == 6) {
                    this.oRJ.aXh();
                    this.oRJ.finish();
                } else if (this.oRJ.hPi == 2 || this.oRJ.hPi == 5) {
                    this.oRJ.finish();
                } else {
                    this.oRJ.aXq();
                }
                this.oRJ.aXi();
                return true;
            }
        });
        this.mKeyboard = (MyKeyboardWindow) findViewById(R.h.cHC);
        this.npM = findViewById(R.h.cHB);
        this.oRs = (ScrollView) findViewById(R.h.czu);
        this.oRj = (ImageView) findViewById(R.h.cyg);
        this.oRk = (TextView) findViewById(R.h.cyh);
        this.oRl = (TextView) findViewById(R.h.cyi);
        this.oRl.setVisibility(8);
        this.oRu = (LinearLayout) findViewById(R.h.cxZ);
        this.oRt = (LinearLayout) findViewById(R.h.cye);
        this.oRq = (TextView) findViewById(R.h.cyc);
        this.oRr = (TextView) findViewById(R.h.cyd);
        this.oRp = (TextView) findViewById(R.h.cyb);
        aXn();
        this.kBW = (WalletFormView) findViewById(R.h.cla);
        if (this.oRh == 33) {
            this.oRq.setText(com.tencent.mm.wallet_core.ui.e.n(this.oRf));
            this.oRr.setText(s.ccn());
            this.oRv = getIntent().getStringExtra("desc");
            if (bg.mA(this.oRv)) {
                this.oRp.setVisibility(8);
            } else {
                this.oRp.setText(h.b(this.uSU.uTo, this.oRv, this.oRp.getTextSize()));
                this.oRp.setVisibility(0);
            }
            this.oRt.setVisibility(0);
            this.oRu.setVisibility(8);
        } else {
            this.kBW.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ RemittanceBaseUI oRJ;

                {
                    this.oRJ = r1;
                }

                public final void onClick(View view) {
                    this.oRJ.Om();
                }
            });
            this.kBW.jhl.setText(String.format(getString(R.l.eLh), new Object[]{"¥"}));
            this.kBW.a(new TextWatcher(this) {
                final /* synthetic */ RemittanceBaseUI oRJ;

                {
                    this.oRJ = r1;
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
            findViewById(R.h.crJ);
            findViewById(R.h.cyf).setVisibility(0);
            this.oRt.setVisibility(8);
            this.oRu.setVisibility(0);
            this.npY = new com.tencent.mm.wallet_core.ui.a(this) {
                final /* synthetic */ RemittanceBaseUI oRJ;

                {
                    this.oRJ = r1;
                }

                public final void gC(boolean z) {
                    if (z) {
                        RemittanceBaseUI.f(this.oRJ);
                    } else {
                        this.oRJ.oRs.scrollTo(0, 0);
                    }
                }
            };
        }
        this.liz = (Button) findViewById(R.h.cnY);
        if (this.hPi == 1) {
            this.liz.setText(R.l.eKw);
        }
        this.liz.setOnClickListener(new com.tencent.mm.ui.n(this) {
            final /* synthetic */ RemittanceBaseUI oRJ;

            {
                this.oRJ = r1;
            }

            public final void aII() {
                if (this.oRJ.oRh == 33) {
                    this.oRJ.dj(this.oRJ.gMv, this.oRJ.oRv);
                } else {
                    this.oRJ.oRf = bg.getDouble(this.oRJ.kBW.getText(), 0.0d);
                    if (!this.oRJ.kBW.Pb()) {
                        com.tencent.mm.ui.base.s.makeText(this.oRJ.uSU.uTo, R.l.fdK, 0).show();
                    } else if (this.oRJ.oRf < 0.01d) {
                        this.oRJ.aXj();
                    } else {
                        this.oRJ.dj(this.oRJ.gMv, null);
                    }
                }
                if (this.oRJ.oQw == 0.0d) {
                    if (this.oRJ.hPi == 1) {
                        g.oUh.i(12689, new Object[]{Integer.valueOf(15), Integer.valueOf(1)});
                    } else {
                        g.oUh.i(12689, new Object[]{Integer.valueOf(6), Integer.valueOf(1)});
                    }
                }
                if (this.oRJ.hPi == 1 && !bg.mA(this.oRJ.gMv)) {
                    g.oUh.i(14074, new Object[]{Integer.valueOf(2)});
                }
            }
        });
        this.oRn = (TextView) findViewById(R.h.cxQ);
        this.oRo = (TextView) findViewById(R.h.bnu);
        if (this.hPi == 1 || this.hPi == 6) {
            this.oRo.setText(R.l.eKs);
        } else {
            this.oRo.setText(R.l.eKr);
        }
        if (!m.xY()) {
            findViewById(R.h.cxR).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ RemittanceBaseUI oRJ;

                {
                    this.oRJ = r1;
                }

                public final void onClick(View view) {
                    String string;
                    this.oRJ.Om();
                    g.oUh.i(12689, new Object[]{Integer.valueOf(9), Integer.valueOf(1)});
                    if (this.oRJ.hPi == 1 || this.oRJ.hPi == 6) {
                        string = this.oRJ.getString(R.l.eKs);
                        g.oUh.i(14074, new Object[]{Integer.valueOf(1)});
                    } else {
                        string = this.oRJ.getString(R.l.eKr);
                    }
                    com.tencent.mm.plugin.wallet_core.ui.view.a.a(this.oRJ, string, this.oRJ.gMv, this.oRJ.getString(R.l.eKz), 20, new com.tencent.mm.ui.base.g.b(this) {
                        final /* synthetic */ AnonymousClass14 oRM;

                        {
                            this.oRM = r1;
                        }

                        public final boolean u(CharSequence charSequence) {
                            if (bg.mA(charSequence.toString())) {
                                this.oRM.oRJ.gMv = null;
                                RemittanceBaseUI.c(this.oRM.oRJ);
                            } else {
                                this.oRM.oRJ.gMv = charSequence.toString();
                                RemittanceBaseUI.c(this.oRM.oRJ);
                            }
                            return true;
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass14 oRM;

                        {
                            this.oRM = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            af.f(new Runnable(this) {
                                final /* synthetic */ AnonymousClass2 oRN;

                                {
                                    this.oRN = r1;
                                }

                                public final void run() {
                                    this.oRN.oRM.oRJ.aHf();
                                }
                            }, 500);
                        }
                    });
                }
            });
        }
        if (this.hPi == 1) {
            ap.yY();
            if (((String) com.tencent.mm.u.c.vr().get(327732, "0")).equals("0")) {
                com.tencent.mm.ui.base.g.a(this.uSU.uTo, R.l.eLi, R.l.eLj, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ RemittanceBaseUI oRJ;

                    {
                        this.oRJ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                ap.yY();
                com.tencent.mm.u.c.vr().set(327732, "1");
                ap.yY();
                com.tencent.mm.u.c.vr().jY(true);
            }
        }
        this.oRm = (TextView) findViewById(R.h.crJ);
        aXl();
        aXm();
        aXk();
    }

    private void aXk() {
        if (!aXp() || bg.mA(this.oRA) || this.oRC == 0 || this.oRB != 1) {
            this.uSU.bQf();
        } else {
            a(0, R.g.blV, new OnMenuItemClickListener(this) {
                final /* synthetic */ RemittanceBaseUI oRJ;

                {
                    this.oRJ = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.wallet_core.ui.e.m(this.oRJ.uSU.uTo, this.oRJ.oRA, false);
                    return false;
                }
            });
        }
    }

    private void aXl() {
        if (bg.mA(this.oRz) || this.oRC == 0) {
            this.oRm.setText("");
            this.oRm.setVisibility(8);
            return;
        }
        int i;
        if (this.oRC == 1) {
            i = 2;
        } else {
            i = 24;
        }
        try {
            this.oRm.setText(String.format(this.oRz, new Object[]{Integer.valueOf(i)}));
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.RemittanceBaseUI", e, "", new Object[0]);
            this.oRm.setText(getString(R.l.eLm, new Object[]{Integer.valueOf(i)}));
        }
        this.oRm.setVisibility(0);
    }

    private void aXn() {
        if (!bg.mA(this.gLD)) {
            int i;
            CharSequence de = com.tencent.mm.wallet_core.ui.e.de(com.tencent.mm.wallet_core.ui.e.eK(this.gLD), 6);
            if (!bg.mA(this.oRy)) {
                de = getString(R.l.eKu, new Object[]{de, this.oRy});
            }
            if (this.hPi == 1 || this.hPi == 6) {
                de = getIntent().getStringExtra("receiver_tips");
                this.oRk.setTextColor(getResources().getColor(R.e.black));
                this.oRl.setVisibility(0);
                this.oRl.setText(getString(R.l.eKv, new Object[]{com.tencent.mm.wallet_core.ui.e.de(com.tencent.mm.wallet_core.ui.e.eK(this.gLD), 6), this.oRy}));
            }
            this.oRk.setText(h.b(this, de, this.oRk.getTextSize()));
            this.oRj.setImageResource(R.g.bes);
            if (ap.zb()) {
                i Bm = n.Bm();
                if (Bm != null) {
                    com.tencent.mm.x.h hs = Bm.hs(this.gLD);
                    if (hs == null || bg.mA(hs.Bt())) {
                        final long Nz = bg.Nz();
                        com.tencent.mm.u.ag.a.hlS.a(this.gLD, "", new com.tencent.mm.u.ag.b.a(this) {
                            final /* synthetic */ RemittanceBaseUI oRJ;

                            public final void p(String str, boolean z) {
                                if (z) {
                                    w.v("MicroMsg.RemittanceBaseUI", "getContact suc; cost=" + (bg.Nz() - Nz) + " ms");
                                    com.tencent.mm.x.b.u(str, 3);
                                } else {
                                    w.w("MicroMsg.RemittanceBaseUI", "getContact failed");
                                }
                                this.oRJ.aXo();
                            }
                        });
                        i = 1;
                        if (i == 0) {
                            aXo();
                        }
                    }
                }
            }
            i = 0;
            if (i == 0) {
                aXo();
            }
        }
    }

    private void aXo() {
        af.v(new Runnable(this) {
            final /* synthetic */ RemittanceBaseUI oRJ;

            {
                this.oRJ = r1;
            }

            public final void run() {
                Bitmap a = com.tencent.mm.x.b.a(this.oRJ.gLD, false, -1);
                if (a == null) {
                    this.oRJ.oRj.setImageResource(R.g.bes);
                } else {
                    this.oRJ.oRj.setImageBitmap(a);
                }
            }
        });
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.remittance.c.g) {
                com.tencent.mm.plugin.remittance.c.g gVar = (com.tencent.mm.plugin.remittance.c.g) kVar;
                this.oRx = gVar.oQr;
                this.oRy = gVar.oQA;
                if (this.oRe != null) {
                    this.oRe.j(10000, new Object[]{Integer.valueOf(this.oRh), this.gLD, Double.valueOf(gVar.oQE)});
                }
                if (!a(gVar)) {
                    L(gVar.fLT, this.gLD, this.oRy);
                }
                this.oRD.put(gVar.fLT, new a(gVar.oQB, gVar.kAj, gVar.oQC, gVar.oQD, gVar.boy));
            } else if (kVar instanceof q) {
                q qVar = (q) kVar;
                if (!bg.mA(qVar.rCf)) {
                    ((TextView) findViewById(R.h.cyt)).setText(qVar.rCf);
                    View findViewById = findViewById(R.h.cIC);
                    findViewById.setVisibility(0);
                    findViewById.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ RemittanceBaseUI oRJ;

                        {
                            this.oRJ = r1;
                        }

                        public final void onClick(View view) {
                            a.a(this.oRJ, this.oRJ.hPi, this.oRJ.oRw, this.oRJ.oQw);
                            if (this.oRJ.hPi == 1) {
                                g.oUh.i(12689, new Object[]{Integer.valueOf(13), Integer.valueOf(1)});
                                return;
                            }
                            g.oUh.i(12689, new Object[]{Integer.valueOf(4), Integer.valueOf(1)});
                        }
                    });
                }
                this.oRw = qVar.oRw;
                this.oQw = qVar.oQw;
                if (this.oQw == 0.0d) {
                    if (this.hPi == 1) {
                        g.oUh.i(12689, new Object[]{Integer.valueOf(14), Integer.valueOf(1)});
                    } else {
                        g.oUh.i(12689, new Object[]{Integer.valueOf(5), Integer.valueOf(1)});
                    }
                }
            } else if (kVar instanceof r) {
                this.oRz = ((r) kVar).rCh;
                this.oRA = ((r) kVar).rCl;
                this.oRB = ((r) kVar).rCm;
                aXl();
                aXk();
            }
            return true;
        }
        if (kVar instanceof r) {
            w.i("MicroMsg.RemittanceBaseUI", "net error, use hardcode wording");
            this.oRm.setText("");
            this.oRm.setVisibility(8);
        } else if ((kVar instanceof com.tencent.mm.plugin.remittance.c.g) && b((com.tencent.mm.plugin.remittance.c.g) kVar)) {
            return true;
        }
        return false;
    }

    private boolean a(final com.tencent.mm.plugin.remittance.c.g gVar) {
        boolean z;
        boolean z2 = true;
        if (this.oRE) {
            z = false;
        } else if (bg.mA(gVar.oQq)) {
            z = false;
        } else {
            this.oRE = true;
            com.tencent.mm.ui.base.g.a(this, gVar.oQq, getString(R.l.dIs), getString(R.l.eKy), getString(R.l.dGs), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ RemittanceBaseUI oRJ;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (!this.oRJ.a(gVar)) {
                        this.oRJ.L(gVar.fLT, this.oRJ.gLD, this.oRJ.oRy);
                    }
                }
            }, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ RemittanceBaseUI oRJ;

                {
                    this.oRJ = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            z = true;
        }
        if (!(z || this.oRF)) {
            if (gVar.oQp > 0) {
                this.oRF = true;
                com.tencent.mm.ui.base.g.a(this, getString(R.l.eLr, new Object[]{Integer.valueOf(gVar.oQp)}), getString(R.l.dIs), getString(R.l.eKy), getString(R.l.eLn), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ RemittanceBaseUI oRJ;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (!this.oRJ.a(gVar)) {
                            this.oRJ.L(gVar.fLT, this.oRJ.gLD, this.oRJ.oRy);
                        }
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ RemittanceBaseUI oRJ;

                    {
                        this.oRJ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.wallet_core.a.b(this.oRJ, "ShowOrdersInfoProcess", null);
                    }
                });
                z = true;
            } else {
                z = false;
            }
        }
        if (!(z || this.oRG)) {
            if (gVar.oQv) {
                this.oRG = true;
                int i = this.hPi;
                double d = gVar.oQz / 100.0d;
                String str = gVar.oQx;
                a.a(this, i, d, gVar.oQy / 100.0d, gVar.oQs / 100.0d, gVar.oQu, new OnClickListener(this) {
                    final /* synthetic */ RemittanceBaseUI oRJ;

                    public final void onClick(View view) {
                        this.oRJ.L(gVar.fLT, this.oRJ.gLD, this.oRJ.oRy);
                        if (this.oRJ.hPi == 1) {
                            g.oUh.i(12689, new Object[]{Integer.valueOf(12), Integer.valueOf(1)});
                            return;
                        }
                        g.oUh.i(12689, new Object[]{Integer.valueOf(3), Integer.valueOf(1)});
                    }
                });
            } else {
                z2 = false;
            }
            z = z2;
        }
        if (z || this.oRH) {
            return z;
        }
        return b(gVar);
    }

    private boolean b(final com.tencent.mm.plugin.remittance.c.g gVar) {
        if (gVar.fVx == null || !gVar.fVx.bty()) {
            return false;
        }
        this.oRH = true;
        com.tencent.mm.ui.base.g.a(this, gVar.fVx.fNG, "", gVar.fVx.nnQ, gVar.fVx.nnP, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ RemittanceBaseUI oRJ;

            public final void onClick(DialogInterface dialogInterface, int i) {
                w.i("MicroMsg.RemittanceBaseUI", "goto h5: %s", new Object[]{gVar.fVx.kAJ});
                com.tencent.mm.wallet_core.ui.e.m(this.oRJ.uSU.uTo, gVar.fVx.kAJ, false);
            }
        }, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ RemittanceBaseUI oRJ;

            {
                this.oRJ = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        return true;
    }

    protected final boolean aXp() {
        return this.hPi == 0 || this.hPi == 2;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.d("MicroMsg.RemittanceBaseUI", "reqcode=" + i + ", resultCode=" + i2 + ", username=" + this.gLD);
        switch (i) {
            case 1:
                if (i2 != -1) {
                    if (this.hPi != 1) {
                        g.oUh.i(12689, new Object[]{Integer.valueOf(7), Integer.valueOf(1)});
                        break;
                    }
                    g.oUh.i(12689, new Object[]{Integer.valueOf(16), Integer.valueOf(1)});
                    break;
                }
                if (!(this.oRh == 33 || this.oRh == 32)) {
                    com.tencent.mm.plugin.remittance.c.n.Dw(this.gLD);
                }
                if (this.oQw == 0.0d) {
                    if (this.hPi == 1) {
                        g.oUh.i(12689, new Object[]{Integer.valueOf(17), Integer.valueOf(1)});
                    } else {
                        g.oUh.i(12689, new Object[]{Integer.valueOf(8), Integer.valueOf(1)});
                    }
                }
                finish();
                break;
            case 2:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!bg.mA(stringExtra)) {
                        this.gLD = stringExtra;
                        aXn();
                        break;
                    }
                    finish();
                    break;
                }
                finish();
                break;
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final void L(String str, String str2, String str3) {
        boolean z;
        if (this.oRh == 31) {
            Object obj = this.oRx;
            if (TextUtils.isEmpty(obj)) {
                w.e("MicroMsg.RemittanceBaseUI", "msgxml is null");
            } else {
                String decode = URLDecoder.decode(obj);
                w.i("MicroMsg.RemittanceBaseUI", "helios:" + decode);
                String str4 = (String) bh.q(decode, "msg").get(".msg.appmsg.wcpayinfo.transcationid");
                if (TextUtils.isEmpty(str4)) {
                    w.e("MicroMsg.RemittanceBaseUI", "paymsgid count't be null in appmsg");
                } else {
                    com.tencent.mm.plugin.remittance.c.m aXc = com.tencent.mm.plugin.remittance.a.b.aWZ().aXc();
                    if (bg.mA(str4) || bg.mA(decode)) {
                        w.e(com.tencent.mm.plugin.remittance.c.m.TAG, "saveMsgContent param error");
                    } else {
                        aXc.oQY.put(str4, decode);
                    }
                }
            }
        }
        PayInfo payInfo = new PayInfo();
        payInfo.fJH = str;
        payInfo.fRv = this.oRh;
        if (this.npX > 0) {
            payInfo.fRr = this.npX;
        }
        if (this.hPi == 2 || this.hPi == 5) {
            z = true;
        } else {
            z = false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("extinfo_key_1", str2);
        bundle.putString("extinfo_key_2", getIntent().getStringExtra("receiver_true_name"));
        bundle.putString("extinfo_key_3", this.oRv);
        bundle.putBoolean("extinfo_key_4", z);
        bundle.putString("extinfo_key_5", getIntent().getStringExtra("receiver_tips"));
        bundle.putString("extinfo_key_6", getIntent().getStringExtra("payer_desc"));
        bundle.putString("extinfo_key_7", this.gMv);
        bundle.putString("extinfo_key_8", getIntent().getStringExtra("rcvr_new_desc"));
        payInfo.sYe = bundle;
        Intent intent = new Intent();
        com.tencent.mm.plugin.wallet.a.a(this.oRe, intent);
        com.tencent.mm.pluginsdk.wallet.e.a(this, false, "", payInfo, str3, intent, 1);
    }

    protected final int Ol() {
        return 1;
    }

    protected void aXq() {
        Intent intent = new Intent();
        intent.putExtra("recent_remittance_contact_list", com.tencent.mm.plugin.remittance.c.n.aXe());
        intent.setClass(this.uSU.uTo, SelectRemittanceContactUI.class);
        startActivityForResult(intent, 2);
    }

    public void ho(String str) {
        w.i("MicroMsg.RemittanceBaseUI", "onGet");
        if (bg.mz(str).length() <= 0) {
            w.e("MicroMsg.RemittanceBaseUI", "notifyChanged: user = " + str);
        } else if (str.equals(this.gLD)) {
            aXo();
        }
    }
}
