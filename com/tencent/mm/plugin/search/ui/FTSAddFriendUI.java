package com.tencent.mm.plugin.search.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.as.d;
import com.tencent.mm.as.i;
import com.tencent.mm.as.j;
import com.tencent.mm.e.a.ag;
import com.tencent.mm.e.a.kh;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.ui.tools.c;
import com.tencent.mm.protocal.c.awr;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.fts.widget.FTSEditTextView;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.List;
import java.util.Map;

public class FTSAddFriendUI extends FTSBaseUI {
    private String lJr = "";
    private Dialog leb;
    private awr lqj;
    private View peM;
    private View peN;
    private View peO;
    private View peP;
    private View peQ;
    private View peR;
    private ImageView peS;
    private TextView peT;
    private TextView peU;
    private TextView peV;
    private TextView peW;
    private TextView peX;
    private boolean peY;
    protected boolean peZ;
    private int pfa = 1;
    private a pfb;
    private int pfc;
    private int pfd;
    int pfe = -1;
    private long pff;

    static /* synthetic */ void a(FTSAddFriendUI fTSAddFriendUI) {
        String str = fTSAddFriendUI.fRM;
        if (str != null && !bg.mA(str.trim()) && System.currentTimeMillis() - fTSAddFriendUI.pff > 1000) {
            fTSAddFriendUI.pff = System.currentTimeMillis();
            if (d.Ii()) {
                if (!bg.mA(fTSAddFriendUI.fRM)) {
                    fTSAddFriendUI.peZ = true;
                    i.c(fTSAddFriendUI.fRM, 2, 2, 16);
                }
                Intent Il = d.Il();
                Il.putExtra("ftsbizscene", 16);
                Il.putExtra("ftsQuery", fTSAddFriendUI.fRM);
                Map a = d.a(16, true, 0);
                a.put("query", fTSAddFriendUI.fRM);
                Il.putExtra("rawUrl", d.m(a));
                b khVar = new kh();
                khVar.fQJ.scene = 0;
                a.urY.m(khVar);
                com.tencent.mm.bb.d.b(fTSAddFriendUI.uSU.uTo, "webview", ".ui.tools.fts.FTSWebViewUI", Il);
                i.gr(16);
                return;
            }
            w.e("MicroMsg.FTS.FTSAddFriendUI", "fts h5 template not avail");
        }
    }

    static /* synthetic */ void f(FTSAddFriendUI fTSAddFriendUI) {
        final b agVar = new ag();
        agVar.fDq.context = fTSAddFriendUI;
        agVar.fDq.fromScene = 16;
        agVar.fDq.fDs = fTSAddFriendUI.fRM;
        agVar.fDq.fDu = false;
        agVar.fDq.title = fTSAddFriendUI.getString(R.l.cZL);
        agVar.fDq.fDt = 1;
        Runnable anonymousClass6 = new Runnable(fTSAddFriendUI) {
            final /* synthetic */ FTSAddFriendUI pfg;

            public final void run() {
                this.pfg.aZr();
                if (agVar.fDr.fDw) {
                    this.pfg.pfd = 1;
                } else {
                    this.pfg.pfd = -1;
                }
                FTSAddFriendUI.g(this.pfg);
            }
        };
        agVar.fDq.fDv = anonymousClass6;
        agVar.fDq.action = 1;
        if (!a.urY.m(agVar)) {
            agVar.fDr.fDw = false;
            anonymousClass6.run();
        }
    }

    static /* synthetic */ void g(FTSAddFriendUI fTSAddFriendUI) {
        if (fTSAddFriendUI.pfc != 0 && fTSAddFriendUI.pfd != 0) {
            fTSAddFriendUI.aZr();
            if (fTSAddFriendUI.pfc <= 0 || fTSAddFriendUI.pfd >= 0) {
                if (fTSAddFriendUI.pfc > 0) {
                    awr com_tencent_mm_protocal_c_awr = fTSAddFriendUI.lqj;
                    String a = n.a(com_tencent_mm_protocal_c_awr.ttp);
                    CharSequence a2 = n.a(com_tencent_mm_protocal_c_awr.tLj);
                    CharSequence charSequence = com_tencent_mm_protocal_c_awr.hAG;
                    fTSAddFriendUI.pfn.setVisibility(8);
                    fTSAddFriendUI.peM.setVisibility(0);
                    fTSAddFriendUI.peN.setVisibility(0);
                    fTSAddFriendUI.peR.setOnClickListener(new OnClickListener(fTSAddFriendUI) {
                        final /* synthetic */ FTSAddFriendUI pfg;

                        {
                            this.pfg = r1;
                        }

                        public final void onClick(View view) {
                            if (!bg.mA(this.pfg.fRM)) {
                                this.pfg.peZ = true;
                                i.c(this.pfg.fRM, this.pfg.pfa, 1, 16);
                            }
                            this.pfg.aZq();
                        }
                    });
                    fTSAddFriendUI.peT.setText(a2);
                    fTSAddFriendUI.peU.setText(charSequence);
                    com.tencent.mm.pluginsdk.ui.a.b.a(fTSAddFriendUI.peS, a);
                    fTSAddFriendUI.peO.setVisibility(8);
                    fTSAddFriendUI.peP.setVisibility(8);
                    fTSAddFriendUI.peQ.setVisibility(8);
                } else {
                    fTSAddFriendUI.pfn.setVisibility(8);
                    fTSAddFriendUI.peM.setVisibility(0);
                    fTSAddFriendUI.peN.setVisibility(8);
                    fTSAddFriendUI.peO.setVisibility(0);
                    fTSAddFriendUI.peP.setVisibility(8);
                    fTSAddFriendUI.peQ.setVisibility(8);
                }
                if (fTSAddFriendUI.pfd > 0) {
                    fTSAddFriendUI.peP.setVisibility(0);
                    fTSAddFriendUI.peQ.setVisibility(0);
                    fTSAddFriendUI.peV.setText(f.a(fTSAddFriendUI.getString(R.l.enp), "", com.tencent.mm.plugin.fts.d.b.a.d(fTSAddFriendUI.fRM, fTSAddFriendUI.fRM)).mdL);
                    fTSAddFriendUI.pfa = 2;
                    fTSAddFriendUI.peQ.setOnClickListener(new OnClickListener(fTSAddFriendUI) {
                        final /* synthetic */ FTSAddFriendUI pfg;

                        {
                            this.pfg = r1;
                        }

                        public final void onClick(View view) {
                            FTSAddFriendUI.a(this.pfg);
                        }
                    });
                    return;
                }
                fTSAddFriendUI.peP.setVisibility(8);
                fTSAddFriendUI.peQ.setVisibility(8);
                return;
            }
            fTSAddFriendUI.peZ = true;
            fTSAddFriendUI.aZq();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.peM = findViewById(R.h.bEP);
        this.peN = findViewById(R.h.bVN);
        this.peR = findViewById(R.h.bEQ);
        this.peO = findViewById(R.h.col);
        this.peP = findViewById(R.h.cjN);
        this.peQ = findViewById(R.h.cAC);
        this.peS = (ImageView) findViewById(R.h.bEO);
        this.peT = (TextView) findViewById(R.h.bGf);
        this.peU = (TextView) findViewById(R.h.bET);
        this.peV = (TextView) findViewById(R.h.cBd);
        this.peW = (TextView) findViewById(R.h.bEU);
        this.peX = (TextView) findViewById(R.h.cAD);
        try {
            w.i("MicroMsg.FTS.FTSAddFriendUI", "set searchNetworkTips %s", new Object[]{j.kb("webSearchBar").optString("wording")});
            this.peX.setText(r0);
        } catch (Exception e) {
        }
        this.uSU.ipu.postDelayed(new Runnable(this) {
            final /* synthetic */ FTSAddFriendUI pfg;

            {
                this.pfg = r1;
            }

            public final void run() {
                this.pfg.pfq.wiF.bYZ();
                this.pfg.pfq.wiF.bYY();
            }
        }, 128);
    }

    protected final b a(c cVar) {
        if (this.pfb == null) {
            this.pfb = new a(cVar);
        }
        return this.pfb;
    }

    public final void b(com.tencent.mm.plugin.fts.d.a.a aVar) {
        if (aVar instanceof com.tencent.mm.plugin.search.ui.a.a) {
            this.lJr = aVar.fRM;
            DW(aVar.fRM);
        }
    }

    public final void a(String str, String str2, List<com.tencent.mm.ui.fts.widget.a.b> list, FTSEditTextView.b bVar) {
        super.a(str, str2, list, bVar);
        this.peY = false;
    }

    public final boolean WV() {
        DW(this.fRM);
        aHf();
        return true;
    }

    protected final int getLayoutId() {
        return R.i.ddD;
    }

    protected final void aZp() {
        super.aZp();
        this.peM.setVisibility(8);
    }

    protected final void stopSearch() {
        super.stopSearch();
        this.peM.setVisibility(8);
    }

    private void aZq() {
        if (bg.mz(n.a(this.lqj.ttp)).length() > 0) {
            if (2 == this.lqj.tZI) {
                this.pfe = 15;
            } else if (1 == this.lqj.tZI) {
                this.pfe = 1;
            }
            Intent intent = new Intent();
            c.a(intent, this.lqj, this.pfe);
            if (this.pfe == 15 && 2 == this.lqj.tZI) {
                intent.putExtra("Contact_Search_Mobile", this.lJr.trim());
            }
            intent.putExtra("add_more_friend_search_scene", 2);
            com.tencent.mm.plugin.search.a.imv.d(intent, this);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.peY && !this.peZ) {
            i.c(this.fRM, this.pfa, 3, 16);
        }
    }

    private void DW(String str) {
        this.peY = true;
        this.peZ = false;
        this.pfa = 1;
        if (str != null && str.length() != 0 && str.trim().length() != 0) {
            this.pfe = Character.isDigit(str.charAt(0)) ? 15 : 3;
            final e anonymousClass4 = new e(this) {
                final /* synthetic */ FTSAddFriendUI pfg;

                {
                    this.pfg = r1;
                }

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void a(int r6, int r7, java.lang.String r8, com.tencent.mm.y.k r9) {
                    /*
                    r5 = this;
                    r3 = 0;
                    r4 = 1;
                    r0 = com.tencent.mm.u.ap.vd();
                    r1 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
                    r0.b(r1, r5);
                    if (r6 != 0) goto L_0x000f;
                L_0x000d:
                    if (r7 == 0) goto L_0x0061;
                L_0x000f:
                    switch(r7) {
                        case -24: goto L_0x0043;
                        case -4: goto L_0x002e;
                        default: goto L_0x0012;
                    };
                L_0x0012:
                    r0 = r5.pfg;
                    r0 = r0.peW;
                    r1 = com.tencent.mm.R.l.eDJ;
                    r0.setText(r1);
                L_0x001d:
                    r0 = r5.pfg;
                    r1 = -1;
                    r0.pfc = r1;
                    r0 = r5.pfg;
                    r0.pfd = r4;
                L_0x0028:
                    r0 = r5.pfg;
                    com.tencent.mm.plugin.search.ui.FTSAddFriendUI.g(r0);
                L_0x002d:
                    return;
                L_0x002e:
                    r0 = 4;
                    if (r6 == r0) goto L_0x0012;
                L_0x0031:
                    r0 = r5.pfg;
                    r0 = r0.peW;
                    r1 = r5.pfg;
                    r2 = com.tencent.mm.R.l.elR;
                    r1 = r1.getString(r2);
                    r0.setText(r1);
                    goto L_0x001d;
                L_0x0043:
                    r0 = com.tencent.mm.f.a.dn(r8);
                    if (r0 == 0) goto L_0x0055;
                L_0x0049:
                    r1 = r5.pfg;
                    r1 = r1.peW;
                    r0 = r0.desc;
                    r1.setText(r0);
                    goto L_0x001d;
                L_0x0055:
                    r0 = r5.pfg;
                    r0 = r0.peW;
                    r1 = com.tencent.mm.R.l.eDJ;
                    r0.setText(r1);
                    goto L_0x001d;
                L_0x0061:
                    r0 = r5.pfg;
                    r9 = (com.tencent.mm.modelsimple.aa) r9;
                    r1 = r9.Jx();
                    r0.lqj = r1;
                    r0 = r5.pfg;
                    r0 = r0.lqj;
                    r0 = r0.tDR;
                    if (r0 <= 0) goto L_0x00c2;
                L_0x0076:
                    r0 = r5.pfg;
                    r0 = r0.lqj;
                    r0 = r0.tDS;
                    r0 = r0.isEmpty();
                    if (r0 == 0) goto L_0x008d;
                L_0x0084:
                    r0 = r5.pfg;
                    r1 = com.tencent.mm.R.l.dCI;
                    r2 = 0;
                    com.tencent.mm.ui.base.g.a(r0, r1, r3, r4, r2);
                    goto L_0x002d;
                L_0x008d:
                    r1 = new android.content.Intent;
                    r1.<init>();
                    r0 = "add_more_friend_search_scene";
                    r2 = 3;
                    r1.putExtra(r0, r2);
                    r0 = r5.pfg;
                    r0 = r0.lqj;
                    r0 = r0.tDS;
                    r0 = r0.size();
                    if (r0 <= r4) goto L_0x00db;
                L_0x00a7:
                    r0 = "result";
                    r2 = r5.pfg;	 Catch:{ IOException -> 0x00ce }
                    r2 = r2.lqj;	 Catch:{ IOException -> 0x00ce }
                    r2 = r2.toByteArray();	 Catch:{ IOException -> 0x00ce }
                    r1.putExtra(r0, r2);	 Catch:{ IOException -> 0x00ce }
                    r0 = com.tencent.mm.plugin.search.a.imv;	 Catch:{ IOException -> 0x00ce }
                    r2 = r5.pfg;	 Catch:{ IOException -> 0x00ce }
                    r2 = r2.uSU;	 Catch:{ IOException -> 0x00ce }
                    r2 = r2.uTo;	 Catch:{ IOException -> 0x00ce }
                    r0.x(r1, r2);	 Catch:{ IOException -> 0x00ce }
                L_0x00c2:
                    r0 = r5.pfg;
                    r0.pfc = r4;
                    r0 = r5.pfg;
                    com.tencent.mm.plugin.search.ui.FTSAddFriendUI.f(r0);
                    goto L_0x0028;
                L_0x00ce:
                    r0 = move-exception;
                    r1 = "MicroMsg.FTS.FTSAddFriendUI";
                    r2 = "";
                    r3 = new java.lang.Object[r3];
                    com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r1, r0, r2, r3);
                    goto L_0x00c2;
                L_0x00db:
                    r0 = r5.pfg;
                    r0 = r0.lqj;
                    r0 = r0.tDS;
                    r0 = r0.getFirst();
                    r0 = (com.tencent.mm.protocal.c.awp) r0;
                    r2 = r5.pfg;
                    r2 = r2.pfe;
                    com.tencent.mm.pluginsdk.ui.tools.c.a(r1, r0, r2);
                    goto L_0x00c2;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.search.ui.FTSAddFriendUI.4.a(int, int, java.lang.String, com.tencent.mm.y.k):void");
                }
            };
            this.pfc = 0;
            this.pfd = 0;
            ap.vd().a(MMGIFException.D_GIF_ERR_NO_COLOR_MAP, anonymousClass4);
            final k aaVar = new aa(str, 3);
            ap.vd().a(aaVar, 0);
            getString(R.l.dIO);
            this.leb = g.a(this, getString(R.l.dCL), true, new OnCancelListener(this) {
                final /* synthetic */ FTSAddFriendUI pfg;

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(aaVar);
                    ap.vd().b(MMGIFException.D_GIF_ERR_NO_COLOR_MAP, anonymousClass4);
                    this.pfg.leb = null;
                }
            });
        }
    }

    private void aZr() {
        af.v(new Runnable(this) {
            final /* synthetic */ FTSAddFriendUI pfg;

            {
                this.pfg = r1;
            }

            public final void run() {
                if (this.pfg.leb != null) {
                    this.pfg.leb.dismiss();
                    this.pfg.leb = null;
                }
            }
        });
    }

    public void onClickBg(View view) {
    }

    public final void aZs() {
        if (!this.pfq.wiF.vqz.hasFocus()) {
            this.pfq.wiF.bYZ();
            aHj();
        }
    }
}
