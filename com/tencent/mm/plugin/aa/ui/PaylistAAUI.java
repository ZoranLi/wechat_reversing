package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.aa.a.c.f;
import com.tencent.mm.plugin.aa.a.c.g;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.o;
import com.tencent.mm.protocal.c.t;
import com.tencent.mm.protocal.c.v;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PaylistAAUI extends BaseAAPresenterActivity {
    private String fFe;
    private View ipN;
    private Dialog ipg = null;
    private g irf = ((g) m(g.class));
    private f irg = ((f) p(f.class));
    private LinearLayout irh;
    private LinearLayout iri;
    private LinearLayout irj;
    private TextView irk;
    private Button irl;
    private TextView irm;
    private TextView irn;
    private TextView iro;
    private String irp;
    private String irq;
    private String irr;
    private String irs;
    private int irt;
    private String iru;
    private long irv;
    private String title;

    static /* synthetic */ void a(PaylistAAUI paylistAAUI, long j) {
        paylistAAUI.ipg = com.tencent.mm.wallet_core.ui.g.a(paylistAAUI, false, null);
        double d = bg.getDouble(paylistAAUI.irk.getText().toString(), 0.0d);
        com.tencent.mm.vending.g.g.bN(Long.valueOf(j)).a(paylistAAUI.irf.ioL).d(new a<Void, o>(paylistAAUI) {
            final /* synthetic */ PaylistAAUI irw;

            {
                this.irw = r1;
            }

            public final /* synthetic */ Object call(Object obj) {
                final o oVar = (o) obj;
                if (this.irw.ipg != null) {
                    this.irw.ipg.dismiss();
                }
                String str = "MicroMsg.PaylistAAUI";
                String str2 = "aapay return, alertItem: %s, alertItem.flag: %s";
                Object[] objArr = new Object[2];
                objArr[0] = oVar.tbB;
                objArr[1] = Integer.valueOf(oVar.tbB != null ? oVar.tbB.fRW : 0);
                w.i(str, str2, objArr);
                if (oVar.tbB == null || oVar.tbB.fRW != 1) {
                    w.d("MicroMsg.PaylistAAUI", "aapay return, reqKey: %s", new Object[]{oVar.nnL});
                    PaylistAAUI.a(this.irw, oVar);
                } else {
                    String str3 = oVar.tbB.fNG;
                    String str4 = oVar.tbB.nnP;
                    str = oVar.tbB.nnQ;
                    h.a aVar = new h.a(this.irw);
                    aVar.SX(str3);
                    aVar.SZ(str).a(new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass2 iry;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            PaylistAAUI.a(this.iry.irw, oVar);
                        }
                    });
                    aVar.Ta(str4);
                    aVar.WJ().show();
                }
                return wCE;
            }
        }).a(new d.a(paylistAAUI) {
            final /* synthetic */ PaylistAAUI irw;

            {
                this.irw = r1;
            }

            public final void aD(Object obj) {
                w.i("MicroMsg.PaylistAAUI", "aapay failed: %s", new Object[]{obj});
                if (this.irw.ipg != null) {
                    this.irw.ipg.dismiss();
                }
                if (obj == null) {
                    Toast.makeText(this.irw, this.irw.getString(R.l.dBt), 1).show();
                } else if (obj instanceof com.tencent.mm.protocal.c.a) {
                    final com.tencent.mm.protocal.c.a aVar = (com.tencent.mm.protocal.c.a) obj;
                    String str = aVar.fNG;
                    String str2 = aVar.nnP;
                    String str3 = aVar.nnQ;
                    h.a aVar2 = new h.a(this.irw);
                    aVar2.SX(str);
                    aVar2.SZ(str3).a(new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass15 irE;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            e.m(this.irE.irw.uSU.uTo, aVar.kAJ, false);
                        }
                    });
                    aVar2.Ta(str2);
                    aVar2.WJ().show();
                } else if ((obj instanceof String) && !obj.toString().equalsIgnoreCase("ok")) {
                    Toast.makeText(this.irw, obj.toString(), 1).show();
                }
            }
        });
        com.tencent.mm.plugin.report.service.g.oUh.i(13721, new Object[]{Integer.valueOf(4), Integer.valueOf(9)});
        com.tencent.mm.plugin.report.service.g.oUh.i(13723, new Object[]{Integer.valueOf(3), Integer.valueOf(com.tencent.mm.plugin.aa.a.h.mG(paylistAAUI.irr).size()), Integer.valueOf(paylistAAUI.irt), Double.valueOf(d * 100.0d), paylistAAUI.title});
    }

    static /* synthetic */ void a(PaylistAAUI paylistAAUI, o oVar) {
        boolean z = paylistAAUI.getIntent().getIntExtra("enter_scene", 0) == 1;
        paylistAAUI.irp = oVar.nnL;
        paylistAAUI.irq = oVar.fSQ;
        paylistAAUI.iru = oVar.tbj;
        paylistAAUI.fFe = oVar.tbC;
        String str = paylistAAUI.irp;
        String str2 = oVar.oQA;
        String str3 = paylistAAUI.irs;
        w.d("MicroMsg.AAUtil", "startAAPay, reqKey: %s, isFromChatting: %s", new Object[]{str, Boolean.valueOf(z)});
        PayInfo payInfo = new PayInfo();
        payInfo.fJH = str;
        payInfo.fRv = 42;
        if (z) {
            payInfo.fRr = 14;
        } else {
            payInfo.fRr = 1;
        }
        Bundle bundle = new Bundle();
        bundle.putString("extinfo_key_1", str3);
        payInfo.sYe = bundle;
        com.tencent.mm.pluginsdk.wallet.e.a(paylistAAUI, false, "", payInfo, str2, new Intent(), 233);
    }

    static /* synthetic */ void a(PaylistAAUI paylistAAUI, v vVar) {
        String str = vVar.tbG;
        String str2 = vVar.title;
        double d = ((double) vVar.tbH) / 100.0d;
        b.m((ImageView) paylistAAUI.findViewById(R.h.cqU), str);
        TextView textView = (TextView) paylistAAUI.findViewById(R.h.crd);
        w.i("MicroMsg.PaylistAAUI", "tftest: cs: %s", new Object[]{paylistAAUI.getString(R.l.eFz, new Object[]{str2, Double.valueOf(d)})});
        try {
            textView.setText(com.tencent.mm.pluginsdk.ui.d.h.a(paylistAAUI.uSU.uTo, paylistAAUI.getString(R.l.eFz, new Object[]{str2, Double.valueOf(d)})));
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.PaylistAAUI", e, "", new Object[0]);
        }
    }

    static /* synthetic */ void a(PaylistAAUI paylistAAUI, String str) {
        if (paylistAAUI.ipg != null) {
            paylistAAUI.ipg.dismiss();
            paylistAAUI.ipg = null;
        }
        if (bg.mA(str)) {
            Toast.makeText(paylistAAUI, R.l.dAZ, 1).show();
        } else {
            Toast.makeText(paylistAAUI, str, 1).show();
        }
    }

    static /* synthetic */ void b(PaylistAAUI paylistAAUI) {
        if (paylistAAUI.ipg != null) {
            paylistAAUI.ipg.dismiss();
        }
        paylistAAUI.ipg = com.tencent.mm.wallet_core.ui.g.a(paylistAAUI, false, null);
        com.tencent.mm.vending.g.g.cbJ().a(paylistAAUI.irf.ioP).d(new a<Void, Boolean>(paylistAAUI) {
            final /* synthetic */ PaylistAAUI irw;

            {
                this.irw = r1;
            }

            public final /* synthetic */ Object call(Object obj) {
                Boolean bool = (Boolean) obj;
                if (this.irw.ipg != null) {
                    this.irw.ipg.dismiss();
                }
                if (bool.booleanValue()) {
                    w.i("MicroMsg.PaylistAAUI", "urgeAAPay success");
                    Toast.makeText(this.irw, R.l.eZo, 1).show();
                } else {
                    w.i("MicroMsg.PaylistAAUI", "urgeAAPay fail");
                    Toast.makeText(this.irw, R.l.eZn, 1).show();
                }
                return wCE;
            }
        }).a(new d.a(paylistAAUI) {
            final /* synthetic */ PaylistAAUI irw;

            {
                this.irw = r1;
            }

            public final void aD(Object obj) {
                if (this.irw.ipg != null) {
                    this.irw.ipg.dismiss();
                }
                if (!(obj instanceof String) || obj.toString().equalsIgnoreCase("ok")) {
                    Toast.makeText(this.irw, R.l.eZn, 1).show();
                } else {
                    Toast.makeText(this.irw, obj.toString(), 1).show();
                }
                w.e("MicroMsg.PaylistAAUI", "urgeAAPay fail");
            }
        });
        com.tencent.mm.plugin.report.service.g.oUh.i(13721, new Object[]{Integer.valueOf(4), Integer.valueOf(8)});
    }

    static /* synthetic */ void b(PaylistAAUI paylistAAUI, v vVar) {
        if (vVar.state == com.tencent.mm.plugin.aa.a.a.imR) {
            paylistAAUI.irm.setText(R.l.eFy);
            paylistAAUI.irm.setTextColor(paylistAAUI.getResources().getColor(R.e.aVD));
        } else if (vVar.state == com.tencent.mm.plugin.aa.a.a.imS) {
            paylistAAUI.irm.setText(R.l.eFw);
            paylistAAUI.irm.setTextColor(paylistAAUI.getResources().getColor(R.e.aVD));
        } else if (vVar.tbs == com.tencent.mm.plugin.aa.a.a.imV) {
            paylistAAUI.iri.setVisibility(8);
            paylistAAUI.irh.setVisibility(0);
            paylistAAUI.irm.setText(paylistAAUI.getString(R.l.eFA));
            paylistAAUI.irm.setTextColor(paylistAAUI.getResources().getColor(R.e.aVp));
        } else if (vVar.tbs == com.tencent.mm.plugin.aa.a.a.imU) {
            paylistAAUI.iri.setVisibility(8);
            paylistAAUI.irh.setVisibility(0);
            if (vVar.tbN == com.tencent.mm.plugin.aa.a.a.imY) {
                paylistAAUI.irm.setText(paylistAAUI.getString(R.l.eFx));
                paylistAAUI.irm.setTextColor(paylistAAUI.getResources().getColor(R.e.aVp));
            } else if (vVar.tbN == com.tencent.mm.plugin.aa.a.a.imX) {
                paylistAAUI.irm.setText(paylistAAUI.getString(R.l.eFC, new Object[]{Double.valueOf(((double) vVar.tbJ) / 100.0d)}));
            } else if (vVar.tbN == com.tencent.mm.plugin.aa.a.a.imW) {
                paylistAAUI.irm.setText(R.l.eFD);
            } else {
                w.e("MicroMsg.PaylistAAUI", "unhandled state, state: %s, type: %s, role: %s", new Object[]{Integer.valueOf(vVar.state), Integer.valueOf(vVar.type), Integer.valueOf(vVar.tbs)});
                paylistAAUI.irm.setVisibility(8);
            }
        } else if (vVar.tbs == com.tencent.mm.plugin.aa.a.a.imT) {
            for (t tVar : vVar.tbm) {
                if (tVar.tbD.equals(m.xL())) {
                    break;
                }
            }
            w.i("MicroMsg.AAUtil", "not contains self");
            t tVar2 = null;
            if (vVar.tbN == com.tencent.mm.plugin.aa.a.a.ina || (r0 != null && r0.tbF == com.tencent.mm.plugin.aa.a.a.ina)) {
                CharSequence format = String.format("%.2f", new Object[]{Double.valueOf(((double) vVar.tbO) / 100.0d)});
                CharSequence string = paylistAAUI.getString(R.l.eFv);
                paylistAAUI.irv = vVar.tbO;
                int i = vVar.state;
                paylistAAUI.iri.setVisibility(0);
                paylistAAUI.irh.setVisibility(8);
                paylistAAUI.irl = (Button) paylistAAUI.iri.findViewById(R.h.cra);
                if (i == com.tencent.mm.plugin.aa.a.a.imR || i == com.tencent.mm.plugin.aa.a.a.imS) {
                    paylistAAUI.irl.setVisibility(8);
                }
                paylistAAUI.irl.setOnClickListener(new View.OnClickListener(paylistAAUI) {
                    final /* synthetic */ PaylistAAUI irw;

                    {
                        this.irw = r1;
                    }

                    public final void onClick(View view) {
                        PaylistAAUI.a(this.irw, this.irw.irv);
                    }
                });
                paylistAAUI.irk = (TextView) paylistAAUI.findViewById(R.h.cmY);
                TextView textView = (TextView) paylistAAUI.iri.findViewById(R.h.crc);
                paylistAAUI.irk.setText(format);
                textView.setText(string);
            } else if (vVar.tbN == com.tencent.mm.plugin.aa.a.a.inb || (r0 != null && r0.tbF == com.tencent.mm.plugin.aa.a.a.inb)) {
                paylistAAUI.iri.setVisibility(8);
                paylistAAUI.irh.setVisibility(0);
                paylistAAUI.irm.setText(paylistAAUI.getString(R.l.eFB, new Object[]{Double.valueOf(((double) vVar.tbO) / 100.0d)}));
                paylistAAUI.irm.setTextColor(paylistAAUI.getResources().getColor(R.e.aVp));
            } else {
                w.e("MicroMsg.PaylistAAUI", "unhandled state, state: %s, type: %s, role: %s", new Object[]{Integer.valueOf(vVar.state), Integer.valueOf(vVar.type), Integer.valueOf(vVar.tbs)});
                paylistAAUI.iri.setVisibility(8);
                paylistAAUI.irm.setVisibility(8);
            }
        }
    }

    static /* synthetic */ void c(PaylistAAUI paylistAAUI, v vVar) {
        View findViewById = paylistAAUI.findViewById(R.h.divider);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        Iterator it = vVar.tbm.iterator();
        while (it.hasNext()) {
            t tVar = (t) it.next();
            if (tVar.tbF == com.tencent.mm.plugin.aa.a.a.ina) {
                arrayList2.add(tVar);
            } else {
                arrayList.add(tVar);
            }
        }
        if (arrayList2.isEmpty()) {
            paylistAAUI.a(arrayList, paylistAAUI.getString(R.l.eFs, new Object[]{Integer.valueOf(arrayList.size())}), v(vVar.tbs, vVar.tbN, vVar.state));
            paylistAAUI.irj.setVisibility(8);
            findViewById.setVisibility(4);
            return;
        }
        paylistAAUI.a(arrayList2, paylistAAUI.getString(R.l.eFr, new Object[]{Integer.valueOf(arrayList2.size())}), v(vVar.tbs, vVar.tbN, vVar.state));
        if (arrayList.isEmpty()) {
            paylistAAUI.irj.setVisibility(8);
            findViewById.setVisibility(4);
            return;
        }
        String string = paylistAAUI.getString(R.l.eFs, new Object[]{Integer.valueOf(arrayList.size())});
        int i = vVar.tbs;
        i = vVar.tbN;
        i = vVar.state;
        paylistAAUI.d(arrayList, string);
    }

    static /* synthetic */ void e(PaylistAAUI paylistAAUI, v vVar) {
        if (vVar.tbs == com.tencent.mm.plugin.aa.a.a.imU && vVar.tbG.equals(m.xL())) {
            paylistAAUI.iro.setVisibility(0);
        } else {
            paylistAAUI.iro.setVisibility(8);
        }
        if (paylistAAUI.iro.getVisibility() != 0) {
            w.i("MicroMsg.PaylistAAUI", "no need to show bottom tv");
        } else if (bg.mA(vVar.tbS)) {
            w.i("MicroMsg.PaylistAAUI", "wording is null");
        } else {
            CharSequence spannableStringBuilder = new SpannableStringBuilder(vVar.tbS);
            if (vVar.tbT == 1) {
                paylistAAUI.iro.setClickable(true);
                paylistAAUI.iro.setOnTouchListener(new k(paylistAAUI));
                spannableStringBuilder.setSpan(new a(new a.a(paylistAAUI) {
                    final /* synthetic */ PaylistAAUI irw;

                    {
                        this.irw = r1;
                    }

                    public final void NZ() {
                        Intent intent = new Intent();
                        intent.putExtra("key_scene_balance_manager", 0);
                        com.tencent.mm.bb.d.b(this.irw, "wallet", ".balance.ui.WalletBalanceManagerUI", intent);
                        com.tencent.mm.plugin.report.service.g.oUh.i(13721, new Object[]{Integer.valueOf(4), Integer.valueOf(4)});
                    }
                }), 0, spannableStringBuilder.length(), 18);
            }
            paylistAAUI.iro.setText(spannableStringBuilder);
            paylistAAUI.getWindow().getDecorView().post(new Runnable(paylistAAUI) {
                final /* synthetic */ PaylistAAUI irw;

                {
                    this.irw = r1;
                }

                public final void run() {
                    int height = this.irw.getWindow().getDecorView().getHeight();
                    int[] iArr = new int[2];
                    View findViewById = this.irw.findViewById(R.h.cre);
                    findViewById.getLocationInWindow(iArr);
                    int height2 = iArr[1] + findViewById.getHeight();
                    int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(this.irw.uSU.uTo, 20);
                    int fromDPToPix2 = ((height - height2) - com.tencent.mm.bg.a.fromDPToPix(this.irw.uSU.uTo, 24)) - com.tencent.mm.bg.a.fromDPToPix(this.irw.uSU.uTo, 12);
                    if (fromDPToPix2 < fromDPToPix) {
                        fromDPToPix2 = fromDPToPix;
                    }
                    w.d("MicroMsg.PaylistAAUI", "height: %s, h1: %s, topMargin: %s", new Object[]{Integer.valueOf(height), Integer.valueOf(height2), Integer.valueOf(fromDPToPix2)});
                    LayoutParams layoutParams = (LayoutParams) this.irw.iro.getLayoutParams();
                    layoutParams.topMargin = fromDPToPix2;
                    this.irw.iro.setLayoutParams(layoutParams);
                }
            });
        }
    }

    static /* synthetic */ void h(PaylistAAUI paylistAAUI) {
        if (paylistAAUI.ipg != null) {
            paylistAAUI.ipg.dismiss();
        }
        paylistAAUI.ipg = com.tencent.mm.wallet_core.ui.g.a(paylistAAUI, false, null);
        com.tencent.mm.vending.g.g.cbJ().a(paylistAAUI.irf.ioO).d(new a<Void, Boolean>(paylistAAUI) {
            final /* synthetic */ PaylistAAUI irw;

            {
                this.irw = r1;
            }

            public final /* synthetic */ Object call(Object obj) {
                w.i("MicroMsg.PaylistAAUI", "close pay list success: %s", new Object[]{(Boolean) obj});
                if (this.irw.ipg != null) {
                    this.irw.ipg.dismiss();
                }
                this.irw.irs = null;
                this.irw.Ow();
                this.irw.uSU.bQf();
                PaylistAAUI.k(this.irw);
                return wCE;
            }
        }).a(new d.a(paylistAAUI) {
            final /* synthetic */ PaylistAAUI irw;

            {
                this.irw = r1;
            }

            public final void aD(Object obj) {
                w.i("MicroMsg.PaylistAAUI", "close pay list failed: %s", new Object[]{obj});
                if (this.irw.ipg != null) {
                    this.irw.ipg.dismiss();
                }
                if (obj instanceof String) {
                    Toast.makeText(this.irw, obj.toString(), 1).show();
                } else {
                    Toast.makeText(this.irw, R.l.dWn, 1).show();
                }
            }
        });
        com.tencent.mm.plugin.report.service.g.oUh.i(13721, new Object[]{Integer.valueOf(4), Integer.valueOf(6)});
    }

    static /* synthetic */ void k(PaylistAAUI paylistAAUI) {
        Intent intent = new Intent();
        intent.putExtra("close_aa", true);
        intent.putExtra("item_position", paylistAAUI.getIntent().getIntExtra("item_position", 0));
        intent.putExtra("item_offset", paylistAAUI.getIntent().getIntExtra("item_offset", 0));
        paylistAAUI.setResult(-1, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ PaylistAAUI irw;

            {
                this.irw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.irw.finish();
                return false;
            }
        });
        zi(R.l.ewd);
        this.irr = getIntent().getStringExtra("chatroom");
        this.irh = (LinearLayout) findViewById(R.h.cri);
        this.iri = (LinearLayout) findViewById(R.h.crb);
        this.irj = (LinearLayout) findViewById(R.h.cqV);
        this.irm = (TextView) findViewById(R.h.crj);
        this.ipN = findViewById(R.h.czp);
        this.irn = (TextView) findViewById(R.h.crk);
        this.irn.setClickable(true);
        this.irn.setOnTouchListener(new k(this));
        CharSequence spannableStringBuilder = new SpannableStringBuilder(getString(R.l.eFE));
        spannableStringBuilder.setSpan(new a(new a.a(this) {
            final /* synthetic */ PaylistAAUI irw;

            {
                this.irw = r1;
            }

            public final void NZ() {
                int i = R.l.eZl;
                if (!com.tencent.mm.u.o.dH(this.irw.irr)) {
                    i = R.l.eZm;
                }
                com.tencent.mm.ui.base.g.a(this.irw, i, -1, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass8 irz;

                    {
                        this.irz = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        PaylistAAUI.b(this.irz.irw);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass8 irz;

                    {
                        this.irz = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                com.tencent.mm.plugin.report.service.g.oUh.i(13721, new Object[]{Integer.valueOf(4), Integer.valueOf(7)});
            }
        }), 0, spannableStringBuilder.length(), 18);
        this.irn.setText(spannableStringBuilder);
        ((TextView) findViewById(R.h.cqZ)).setText(s.ccn());
        this.iro = (TextView) findViewById(R.h.cqY);
        Ow();
    }

    private void Ow() {
        this.ipg = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
        this.ipN.setVisibility(4);
        com.tencent.mm.vending.g.g.cbJ().a(this.irf.ioK).d(new a<Void, v>(this) {
            final /* synthetic */ PaylistAAUI irw;

            {
                this.irw = r1;
            }

            public final /* synthetic */ Object call(Object obj) {
                v vVar = (v) obj;
                if (vVar == null) {
                    w.e("MicroMsg.PaylistAAUI", "queryDetailRes is null!!!");
                    PaylistAAUI.a(this.irw, null);
                } else {
                    w.i("MicroMsg.PaylistAAUI", "get queryDetailRes: %s, billNo: %s, type: %s, state: %s, is_launcher: %s, role: %s, role_state: %s, payer_list.size: %s", new Object[]{vVar, vVar.tbh, Integer.valueOf(vVar.type), Integer.valueOf(vVar.state), Integer.valueOf(vVar.tbM), Integer.valueOf(vVar.tbs), Integer.valueOf(vVar.tbN), Integer.valueOf(vVar.tbm.size())});
                    w.i("MicroMsg.PaylistAAUI", "paid_num: %s, plan_num: %s", new Object[]{Integer.valueOf(vVar.tbK), Integer.valueOf(vVar.tbI)});
                    this.irw.ipN.setVisibility(0);
                    this.irw.irs = vVar.tbG;
                    this.irw.irt = vVar.tbm.size() + 1;
                    this.irw.title = vVar.title;
                    PaylistAAUI.a(this.irw, vVar);
                    PaylistAAUI.b(this.irw, vVar);
                    PaylistAAUI.c(this.irw, vVar);
                    this.irw.a(0, R.g.bhb, new OnMenuItemClickListener(this.irw, vVar) {
                        final /* synthetic */ PaylistAAUI irw;

                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(this.irw, com.tencent.mm.ui.widget.e.wuP, false);
                            eVar.qJf = new c(this) {
                                final /* synthetic */ AnonymousClass13 irB;

                                {
                                    this.irB = r1;
                                }

                                public final void a(l lVar) {
                                    lVar.add(0, 1, 1, R.l.eFF);
                                    if (!bg.mA(this.irB.irw.irs) && this.irB.irw.irs.equals(m.xL()) && r4.state == com.tencent.mm.plugin.aa.a.a.imQ && r4.tbJ < r4.tbH) {
                                        lVar.add(0, 2, 1, R.l.dAT);
                                    }
                                }
                            };
                            eVar.qJg = new n.d(this) {
                                final /* synthetic */ AnonymousClass13 irB;

                                {
                                    this.irB = r1;
                                }

                                public final void c(MenuItem menuItem, int i) {
                                    int i2 = 3;
                                    switch (menuItem.getItemId()) {
                                        case 1:
                                            Intent intent = new Intent();
                                            intent.putExtra("key_from_scene", 1);
                                            intent.putExtra("Select_Conv_Type", 3);
                                            intent.putExtra("select_is_ret", false);
                                            intent.putExtra("mutil_select_is_ret", false);
                                            intent.putExtra("Select_block_List", m.xL());
                                            intent.putExtra("recent_remittance_contact_list", com.tencent.mm.plugin.aa.a.h.NT());
                                            com.tencent.mm.bb.d.b(this.irB.irw.uSU.uTo, "remittance", ".ui.SelectRemittanceContactUI", intent, 222);
                                            if (r4.tbs == com.tencent.mm.plugin.aa.a.a.imU) {
                                                i2 = 1;
                                            } else if (r4.tbs == com.tencent.mm.plugin.aa.a.a.imT) {
                                                i2 = 2;
                                            }
                                            w.d("MicroMsg.PaylistAAUI", "test");
                                            com.tencent.mm.plugin.report.service.g.oUh.i(13721, new Object[]{Integer.valueOf(7), Integer.valueOf(i2)});
                                            return;
                                        case 2:
                                            com.tencent.mm.plugin.report.service.g.oUh.i(13721, new Object[]{Integer.valueOf(4), Integer.valueOf(5)});
                                            com.tencent.mm.ui.base.g.a(this.irB.irw, R.l.dAS, -1, R.l.dAW, R.l.cancel, new OnClickListener(this) {
                                                final /* synthetic */ AnonymousClass2 irC;

                                                {
                                                    this.irC = r1;
                                                }

                                                public final void onClick(DialogInterface dialogInterface, int i) {
                                                    PaylistAAUI.h(this.irC.irB.irw);
                                                }
                                            }, null);
                                            return;
                                        default:
                                            return;
                                    }
                                }
                            };
                            eVar.bzh();
                            return true;
                        }
                    });
                    PaylistAAUI.e(this.irw, vVar);
                    if (this.irw.ipg != null) {
                        this.irw.ipg.dismiss();
                        this.irw.ipg = null;
                    }
                }
                return wCE;
            }
        }).a(new d.a(this) {
            final /* synthetic */ PaylistAAUI irw;

            {
                this.irw = r1;
            }

            public final void aD(Object obj) {
                w.i("MicroMsg.PaylistAAUI", "onInterrupt: %s", new Object[]{obj});
                PaylistAAUI.a(this.irw, obj == null ? "" : obj.toString());
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
    }

    private static boolean v(int i, int i2, int i3) {
        return i == com.tencent.mm.plugin.aa.a.a.imU && i2 != com.tencent.mm.plugin.aa.a.a.imY && i3 == com.tencent.mm.plugin.aa.a.a.imQ;
    }

    private void a(List<t> list, String str, boolean z) {
        ((TextView) findViewById(R.h.crl)).setText(str);
        this.irn.setVisibility(z ? 0 : 8);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.h.crm);
        linearLayout.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            boolean z2;
            t tVar = (t) list.get(i);
            if (i >= list.size() - 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            a(linearLayout, tVar, z2);
        }
    }

    private void d(List<t> list, String str) {
        ((TextView) findViewById(R.h.cqW)).setText(str);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.h.cqX);
        linearLayout.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            boolean z;
            t tVar = (t) list.get(i);
            if (i >= list.size() - 1) {
                z = true;
            } else {
                z = false;
            }
            a(linearLayout, tVar, z);
        }
    }

    private void a(LinearLayout linearLayout, t tVar, boolean z) {
        LinearLayout linearLayout2 = (LinearLayout) getLayoutInflater().inflate(R.i.dks, linearLayout, false);
        ImageView imageView = (ImageView) linearLayout2.findViewById(R.h.crf);
        TextView textView = (TextView) linearLayout2.findViewById(R.h.crg);
        TextView textView2 = (TextView) linearLayout2.findViewById(R.h.crh);
        View findViewById = linearLayout2.findViewById(R.h.divider);
        if (z) {
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
        }
        b.a(imageView, tVar.tbD);
        textView.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.uSU.uTo, com.tencent.mm.u.n.E(tVar.tbD, this.irg.wBK.getStringExtra("chatroom")), textView.getTextSize()));
        if (tVar.tbF == com.tencent.mm.plugin.aa.a.a.inb) {
            textView2.setText(getString(R.l.eFB, new Object[]{Double.valueOf(((double) tVar.tbq) / 100.0d)}));
            textView2.setTextColor(getResources().getColor(R.e.aVp));
            textView2.setVisibility(0);
            linearLayout.addView(linearLayout2);
        } else if (tVar.tbF == com.tencent.mm.plugin.aa.a.a.ina) {
            textView2.setText(getString(R.l.eFu, new Object[]{Double.valueOf(((double) tVar.tbq) / 100.0d)}));
            textView2.setTextColor(getResources().getColor(R.e.aVq));
            textView2.setVisibility(0);
            linearLayout.addView(linearLayout2);
        } else {
            textView2.setVisibility(8);
            linearLayout.addView(linearLayout2);
        }
    }

    protected final int getLayoutId() {
        return R.i.dkt;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        Intent intent2;
        String stringExtra;
        if (i == 233) {
            if (i2 == -1) {
                w.i("MicroMsg.PaylistAAUI", "pay success, payMsgId: %s", new Object[]{this.irq});
                RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) intent.getParcelableExtra("key_realname_guide_helper");
                if (realnameGuideHelper != null) {
                    w.i("MicroMsg.PaylistAAUI", "do realname guide");
                    intent2 = new Intent();
                    intent2.putExtra("key_realname_guide_helper", realnameGuideHelper);
                    com.tencent.mm.bb.d.b(this, "wallet_core", ".id_verify.RealnameDialogActivity", intent2);
                }
                com.tencent.mm.plugin.aa.a.h.mH(this.irr);
                finish();
                com.tencent.mm.vending.g.g.a(this.irq, this.irs, this.iru).a(this.irf.ioM).d(new a<Void, Void>(this) {
                    final /* synthetic */ PaylistAAUI irw;

                    {
                        this.irw = r1;
                    }

                    public final /* synthetic */ Object call(Object obj) {
                        w.i("MicroMsg.PaylistAAUI", "insert msg finish");
                        return wCE;
                    }
                });
                stringExtra = intent.getStringExtra("key_trans_id");
                a aVar = this.irf.ioN;
                long j = this.irv;
                com.tencent.mm.vending.g.g.a(Long.valueOf(j), this.fFe, stringExtra).a(aVar);
                com.tencent.mm.plugin.report.service.g.oUh.a(407, 12, 1, false);
            }
        } else if (i == 222 && i2 == -1) {
            stringExtra = intent.getStringExtra("Select_Conv_User");
            w.i("MicroMsg.PaylistAAUI", "select chatroom：%s", new Object[]{stringExtra});
            if (!bg.mA(stringExtra)) {
                intent2 = new Intent(this.uSU.uTo, LaunchAAUI.class);
                intent2.putExtra("enter_scene", 3);
                intent2.putExtra("chatroom_name", stringExtra);
                startActivity(intent2);
            }
        }
    }
}
