package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.plugin.wallet.balance.a.a.g;
import com.tencent.mm.plugin.wallet.balance.a.a.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.asq;
import com.tencent.mm.protocal.c.ls;
import com.tencent.mm.protocal.c.og;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Iterator;

public class WalletLqtDetailUI extends WalletLqtBasePresenterUI {
    private ae handler = new ae(Looper.getMainLooper());
    private Dialog ipg;
    private g rve = ((g) p(g.class));
    private h rvf = ((h) m(h.class));
    private asq rvg;
    private ViewGroup rvh;
    private TextView rvi;
    private WalletTextView rvj;
    private TextView rvk;
    private TextView rvl;
    private TextView rvm;
    private WalletTextView rvn;
    private Button rvo;
    private Button rvp;
    private LinearLayout rvq;
    private TextView rvr;
    private View rvs;
    private TextView rvt;
    private View rvu;
    private View rvv;
    private CdnImageView rvw;
    private TextView rvx;
    private TextView rvy;
    private boolean rvz = true;

    static /* synthetic */ void b(WalletLqtDetailUI walletLqtDetailUI) {
        if (walletLqtDetailUI.rvg != null) {
            walletLqtDetailUI.rvj.setText(e.n(((double) walletLqtDetailUI.rvg.brD) / 100.0d));
            walletLqtDetailUI.rvk.setText(walletLqtDetailUI.rvg.tWX);
            walletLqtDetailUI.rvl.setText(walletLqtDetailUI.rvg.tWY);
            walletLqtDetailUI.rvm.setText(walletLqtDetailUI.rvg.tWZ);
            walletLqtDetailUI.rvn.setText(e.n(((double) walletLqtDetailUI.rvg.tXa) / 100.0d));
            walletLqtDetailUI.rvq.removeAllViews();
            if (walletLqtDetailUI.rvg.tXb != null && walletLqtDetailUI.rvg.tXb.size() > 0) {
                Iterator it = walletLqtDetailUI.rvg.tXb.iterator();
                while (it.hasNext()) {
                    og ogVar = (og) it.next();
                    final LinearLayout linearLayout = (LinearLayout) walletLqtDetailUI.getLayoutInflater().inflate(R.i.ccU, walletLqtDetailUI.rvq, false);
                    TextView textView = (TextView) linearLayout.findViewById(R.h.ccT);
                    ((TextView) linearLayout.findViewById(R.h.ccV)).setText(ogVar.title);
                    textView.setText(ogVar.desc);
                    if (!bg.mA(ogVar.ttR)) {
                        linearLayout.setTag(ogVar.ttR);
                        linearLayout.setOnClickListener(new OnClickListener(walletLqtDetailUI) {
                            final /* synthetic */ WalletLqtDetailUI rvA;

                            public final void onClick(View view) {
                                e.m(this.rvA, (String) linearLayout.getTag(), false);
                            }
                        });
                    }
                    walletLqtDetailUI.rvq.addView(linearLayout, new LayoutParams(-1, -2, -1.0f));
                }
            }
            walletLqtDetailUI.rvh.setVisibility(0);
            if (walletLqtDetailUI.rvg.brD <= 0) {
                walletLqtDetailUI.rvp.setEnabled(false);
            } else {
                walletLqtDetailUI.rvp.setEnabled(true);
            }
            if (walletLqtDetailUI.rvg.tXe != null) {
                walletLqtDetailUI.rvr.setText(walletLqtDetailUI.rvg.tXe.title);
                walletLqtDetailUI.rvr.setOnClickListener(new OnClickListener(walletLqtDetailUI) {
                    final /* synthetic */ WalletLqtDetailUI rvA;

                    {
                        this.rvA = r1;
                    }

                    public final void onClick(View view) {
                        e.m(this.rvA, this.rvA.rvg.tXe.ttR, false);
                    }
                });
            }
            walletLqtDetailUI.rvs.setVisibility(8);
            if (!(walletLqtDetailUI.rvg.tXg == null || bg.mA(walletLqtDetailUI.rvg.tXg.title))) {
                walletLqtDetailUI.rvs.setVisibility(0);
                walletLqtDetailUI.rvt.setText(walletLqtDetailUI.rvg.tXg.title);
                if (!bg.mA(walletLqtDetailUI.rvg.tXg.ttR)) {
                    walletLqtDetailUI.rvs.setOnClickListener(new OnClickListener(walletLqtDetailUI) {
                        final /* synthetic */ WalletLqtDetailUI rvA;

                        {
                            this.rvA = r1;
                        }

                        public final void onClick(View view) {
                            e.m(this.rvA, this.rvA.rvg.tXg.ttR, false);
                        }
                    });
                }
            }
            walletLqtDetailUI.rvv.setVisibility(8);
            walletLqtDetailUI.rvu.setVisibility(8);
            if (!(walletLqtDetailUI.rvg.tXh == null || bg.mA(walletLqtDetailUI.rvg.tXh.username))) {
                walletLqtDetailUI.rvw.L(walletLqtDetailUI.rvg.tXh.kdG, 0, 0);
                walletLqtDetailUI.rvx.setText(walletLqtDetailUI.rvg.tXh.title);
                walletLqtDetailUI.rvy.setText(walletLqtDetailUI.rvg.tXh.desc);
                walletLqtDetailUI.rvv.setOnClickListener(new OnClickListener(walletLqtDetailUI) {
                    final /* synthetic */ WalletLqtDetailUI rvA;

                    {
                        this.rvA = r1;
                    }

                    public final void onClick(View view) {
                        b prVar = new pr();
                        prVar.fWB.userName = this.rvA.rvg.tXh.username;
                        prVar.fWB.fWD = bg.ap(this.rvA.rvg.tXh.path, "");
                        prVar.fWB.scene = 1061;
                        prVar.fWB.fWE = 0;
                        a.urY.m(prVar);
                    }
                });
                walletLqtDetailUI.rvu.setVisibility(0);
                walletLqtDetailUI.rvv.setVisibility(0);
            }
            walletLqtDetailUI.rvr.setVisibility(4);
            walletLqtDetailUI.rvr.post(new Runnable(walletLqtDetailUI) {
                final /* synthetic */ WalletLqtDetailUI rvA;

                {
                    this.rvA = r1;
                }

                public final void run() {
                    LayoutParams layoutParams = (LayoutParams) this.rvA.rvr.getLayoutParams();
                    layoutParams.topMargin = Math.max(((this.rvA.findViewById(R.h.cdb).getHeight() - this.rvA.findViewById(R.h.cda).getBottom()) - com.tencent.mm.bg.a.fromDPToPix(this.rvA, 20)) - com.tencent.mm.bg.a.fromDPToPix(this.rvA, 20), com.tencent.mm.bg.a.fromDPToPix(this.rvA, 20));
                    layoutParams.bottomMargin = com.tencent.mm.bg.a.fromDPToPix(this.rvA, 20);
                    this.rvA.rvr.setLayoutParams(layoutParams);
                    this.rvA.rvr.setVisibility(0);
                }
            });
            walletLqtDetailUI.rvo.setOnClickListener(new OnClickListener(walletLqtDetailUI) {
                final /* synthetic */ WalletLqtDetailUI rvA;

                {
                    this.rvA = r1;
                }

                public final void onClick(View view) {
                    boolean z = true;
                    if (bg.mA(this.rvA.rvg.tWE)) {
                        boolean z2;
                        Intent intent = new Intent(this.rvA, WalletLqtSaveFetchUI.class);
                        intent.putExtra("lqt_save_fund_code", this.rvA.rvg != null ? this.rvA.rvg.tWB : null);
                        intent.putExtra("lqt_save_fetch_mode", 1);
                        String str = "lqt_is_show_protocol";
                        if (this.rvA.rvg.fZh == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        intent.putExtra(str, z2);
                        String str2 = "lqt_is_agree_protocol";
                        if (this.rvA.rvg.tXc != 1) {
                            z = false;
                        }
                        intent.putExtra(str2, z);
                        intent.putStringArrayListExtra("lqt_protocol_list", WalletLqtDetailUI.e(this.rvA));
                        intent.putExtra("lqt_profile_wording", this.rvA.rvg.tWW);
                        this.rvA.startActivity(intent);
                        return;
                    }
                    w.i("MicroMsg.WalletLqtDetailUI", "click save button, go to block url: %s", new Object[]{this.rvA.rvg.tWE});
                    e.m(this.rvA, this.rvA.rvg.tWE, false);
                }
            });
            walletLqtDetailUI.rvp.setOnClickListener(new OnClickListener(walletLqtDetailUI) {
                final /* synthetic */ WalletLqtDetailUI rvA;

                {
                    this.rvA = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent(this.rvA, WalletLqtSaveFetchUI.class);
                    intent.putExtra("lqt_save_fetch_mode", 2);
                    intent.putExtra("lqt_balance", this.rvA.rvg.brD);
                    intent.putExtra("lqt_max_redeem_amount", this.rvA.rvg.tXi);
                    intent.putExtra("lqt_redeem_invalid_amount_hint", this.rvA.rvg.tXj);
                    this.rvA.startActivity(intent);
                }
            });
        }
        walletLqtDetailUI.uSU.bQf();
        if (walletLqtDetailUI.rvg != null) {
            walletLqtDetailUI.a(0, R.g.bhb, new OnMenuItemClickListener(walletLqtDetailUI) {
                final /* synthetic */ WalletLqtDetailUI rvA;

                {
                    this.rvA = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(this.rvA, com.tencent.mm.ui.widget.e.wuP, false);
                    eVar.qJf = new c(this) {
                        final /* synthetic */ AnonymousClass2 rvB;

                        {
                            this.rvB = r1;
                        }

                        public final void a(l lVar) {
                            if (this.rvB.rvA.rvg.tXf != null && this.rvB.rvA.rvg.tXf.size() > 0) {
                                Iterator it = this.rvB.rvA.rvg.tXf.iterator();
                                int i = 0;
                                while (it.hasNext()) {
                                    og ogVar = (og) it.next();
                                    if (!(bg.mA(ogVar.title) || bg.mA(ogVar.ttR))) {
                                        lVar.add(0, i, 0, ogVar.title);
                                    }
                                    i++;
                                }
                            }
                            lVar.add(0, -1, 0, R.l.fgp);
                        }
                    };
                    eVar.qJg = new d(this) {
                        final /* synthetic */ AnonymousClass2 rvB;

                        {
                            this.rvB = r1;
                        }

                        public final void c(MenuItem menuItem, int i) {
                            if (menuItem.getItemId() == -1) {
                                com.tencent.mm.ui.base.g.a(this.rvB.rvA, this.rvB.rvA.getString(R.l.fgr), "", this.rvB.rvA.getString(R.l.bCA), new DialogInterface.OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass2 rvC;

                                    {
                                        this.rvC = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        this.rvC.rvB.rvA.rvz = false;
                                        this.rvC.rvB.rvA.startActivityForResult(new Intent(this.rvC.rvB.rvA, WalletLqtSimpleCheckPwdUI.class), 123);
                                    }
                                });
                            } else if (this.rvB.rvA.rvg.tXf != null && this.rvB.rvA.rvg.tXf.size() > 0 && menuItem.getItemId() < this.rvB.rvA.rvg.tXf.size()) {
                                e.m(this.rvB.rvA, ((og) this.rvB.rvA.rvg.tXf.get(menuItem.getItemId())).ttR, false);
                            }
                        }
                    };
                    eVar.bzh();
                    return false;
                }
            });
        }
    }

    static /* synthetic */ ArrayList e(WalletLqtDetailUI walletLqtDetailUI) {
        ArrayList arrayList = new ArrayList();
        if (walletLqtDetailUI.rvg.tXd != null && walletLqtDetailUI.rvg.tXd.size() > 0) {
            Iterator it = walletLqtDetailUI.rvg.tXd.iterator();
            while (it.hasNext()) {
                og ogVar = (og) it.next();
                if (!(bg.mA(ogVar.title) || bg.mA(ogVar.ttR))) {
                    arrayList.add(String.format("%s||%s", new Object[]{ogVar.title, ogVar.ttR}));
                }
            }
        }
        return arrayList;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (cO().cP() != null) {
            cO().cP().setBackgroundDrawable(getResources().getDrawable(R.e.aWk));
        }
        if (com.tencent.mm.compatible.util.d.eo(21)) {
            getWindow().setStatusBarColor(getResources().getColor(R.e.aWk));
        }
        qP(getString(R.l.fgJ));
        this.rvh = (ViewGroup) findViewById(R.h.bIx);
        this.rvi = (TextView) findViewById(R.h.cdf);
        this.rvj = (WalletTextView) findViewById(R.h.ccO);
        this.rvk = (TextView) findViewById(R.h.ccP);
        this.rvl = (TextView) findViewById(R.h.ccQ);
        this.rvm = (TextView) findViewById(R.h.ccY);
        this.rvn = (WalletTextView) findViewById(R.h.ccZ);
        this.rvo = (Button) findViewById(R.h.cdc);
        this.rvp = (Button) findViewById(R.h.ccX);
        this.rvq = (LinearLayout) findViewById(R.h.ccU);
        this.rvr = (TextView) findViewById(R.h.ccW);
        this.rvs = findViewById(R.h.ccR);
        this.rvt = (TextView) findViewById(R.h.ccS);
        this.rvv = findViewById(R.h.cde);
        this.rvw = (CdnImageView) findViewById(R.h.cIq);
        this.rvx = (TextView) findViewById(R.h.cIr);
        this.rvy = (TextView) findViewById(R.h.cIp);
        this.rvu = findViewById(R.h.cdd);
        this.rvr.setVisibility(4);
    }

    public void onResume() {
        super.onResume();
        if (this.rvz) {
            this.rvh.setVisibility(8);
            this.ipg = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
            com.tencent.mm.vending.g.g.cbJ().a(this.rvf.rtG).d(new com.tencent.mm.vending.c.a<Void, asq>(this) {
                final /* synthetic */ WalletLqtDetailUI rvA;

                {
                    this.rvA = r1;
                }

                public final /* synthetic */ Object call(Object obj) {
                    asq com_tencent_mm_protocal_c_asq = (asq) obj;
                    if (com_tencent_mm_protocal_c_asq != null) {
                        w.i("MicroMsg.WalletLqtDetailUI", "fetch detail success");
                        this.rvA.rvg = com_tencent_mm_protocal_c_asq;
                        WalletLqtDetailUI.b(this.rvA);
                    } else {
                        w.i("MicroMsg.WalletLqtDetailUI", "fetch detail failed");
                    }
                    if (this.rvA.ipg != null) {
                        this.rvA.ipg.dismiss();
                    }
                    return wCE;
                }
            }).a(new com.tencent.mm.vending.g.d.a(this) {
                final /* synthetic */ WalletLqtDetailUI rvA;

                {
                    this.rvA = r1;
                }

                public final void aD(Object obj) {
                    if (this.rvA.ipg != null) {
                        this.rvA.ipg.dismiss();
                    }
                    w.i("MicroMsg.WalletLqtDetailUI", "fetch detail failed: %s", new Object[]{obj});
                    if (obj != null) {
                        CharSequence obj2;
                        if (obj instanceof String) {
                            obj2 = obj.toString();
                        } else {
                            obj2 = this.rvA.getString(R.l.fgB);
                        }
                        Toast.makeText(this.rvA, obj2, 1).show();
                    }
                }
            });
        }
        this.rvz = true;
    }

    protected final int getLayoutId() {
        return R.i.dqJ;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 123 && i2 == -1) {
            this.rvz = false;
            String stringExtra = intent.getStringExtra("lqt_enc_pwd");
            if (this.ipg == null) {
                this.ipg = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
            } else {
                this.ipg.show();
            }
            com.tencent.mm.vending.g.g.bN(stringExtra).a(this.rvf.rtH).d(new com.tencent.mm.vending.c.a<Void, ls>(this) {
                final /* synthetic */ WalletLqtDetailUI rvA;

                {
                    this.rvA = r1;
                }

                public final /* synthetic */ Object call(Object obj) {
                    this.rvA.handler.postDelayed(new Runnable(this) {
                        final /* synthetic */ AnonymousClass4 rvD;

                        {
                            this.rvD = r1;
                        }

                        public final void run() {
                            if (this.rvD.rvA.ipg != null) {
                                this.rvD.rvA.ipg.dismiss();
                            }
                            Toast.makeText(this.rvD.rvA, this.rvD.rvA.getString(R.l.fgq), 1).show();
                            this.rvD.rvA.finish();
                        }
                    }, 1000);
                    return wCE;
                }
            }).a(new com.tencent.mm.vending.g.d.a(this) {
                final /* synthetic */ WalletLqtDetailUI rvA;

                {
                    this.rvA = r1;
                }

                public final void aD(Object obj) {
                    if (this.rvA.ipg != null) {
                        this.rvA.ipg.dismiss();
                    }
                    w.i("MicroMsg.WalletLqtDetailUI", "close account failed: %s", new Object[]{obj});
                    if (obj != null) {
                        CharSequence obj2;
                        if (obj instanceof String) {
                            obj2 = obj.toString();
                        } else {
                            obj2 = this.rvA.getString(R.l.fgB);
                        }
                        Toast.makeText(this.rvA, obj2, 1).show();
                    }
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.rve = null;
        this.rvf = null;
    }
}
