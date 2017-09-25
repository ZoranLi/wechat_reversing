package com.tencent.mm.plugin.search.ui;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.as.d;
import com.tencent.mm.as.i;
import com.tencent.mm.as.j;
import com.tencent.mm.e.a.gh;
import com.tencent.mm.e.a.kh;
import com.tencent.mm.e.a.re;
import com.tencent.mm.e.a.sn;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.fts.d.f;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.protocal.c.awp;
import com.tencent.mm.protocal.c.awr;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.fts.widget.FTSMainUIEducationLayout;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.Map;
import org.json.JSONObject;

public class FTSMainUI extends FTSBaseVoiceSearchUI implements a {
    private Dialog leb;
    private int mcx;
    private View nww;
    private FTSMainUIEducationLayout pfZ;
    int pfe = -1;
    long pff;
    private LinearLayout pga;
    private LinearLayout pgb;
    private View pgc;
    private View pgd;
    private TextView pge;
    private TextView pgf;
    private View pgg;
    private View pgh;
    private TextView pgi;
    private f pgj;
    private OnClickListener pgk = new OnClickListener(this) {
        final /* synthetic */ FTSMainUI pgm;

        {
            this.pgm = r1;
        }

        public final void onClick(View view) {
            int optInt;
            String charSequence;
            FTSMainUI fTSMainUI;
            try {
                if (view.getTag() != null) {
                    optInt = ((JSONObject) view.getTag()).optInt("businessType");
                    if (optInt == 0) {
                        charSequence = ((TextView) view).getText().toString();
                        if (charSequence.equals(this.pgm.getString(R.l.ePP))) {
                            optInt = 2;
                        } else if (charSequence.equals(this.pgm.getString(R.l.ePS))) {
                            optInt = 8;
                        } else if (charSequence.equals(this.pgm.getString(R.l.ePQ))) {
                            optInt = 1;
                        }
                    }
                    if (optInt != 0) {
                        fTSMainUI = this.pgm;
                        if (System.currentTimeMillis() - fTSMainUI.pff > 1000) {
                            fTSMainUI.pff = System.currentTimeMillis();
                            if (d.Ii()) {
                                w.e("MicroMsg.FTS.FTSMainUI", "fts h5 template not avail");
                            }
                            i.aW(optInt, 14);
                            fTSMainUI.aHf();
                            Intent Il = d.Il();
                            Il.putExtra("ftsneedkeyboard", true);
                            Il.putExtra("ftsbizscene", 14);
                            Il.putExtra("ftsType", optInt);
                            Il.putExtra("rawUrl", d.m(d.a(14, true, optInt)));
                            Il.putExtra("key_load_js_without_delay", true);
                            com.tencent.mm.bb.d.b(ab.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", Il);
                            return;
                        }
                    }
                }
            } catch (Exception e) {
            }
            optInt = 0;
            if (optInt == 0) {
                charSequence = ((TextView) view).getText().toString();
                if (charSequence.equals(this.pgm.getString(R.l.ePP))) {
                    optInt = 2;
                } else if (charSequence.equals(this.pgm.getString(R.l.ePS))) {
                    optInt = 8;
                } else if (charSequence.equals(this.pgm.getString(R.l.ePQ))) {
                    optInt = 1;
                }
            }
            if (optInt != 0) {
                fTSMainUI = this.pgm;
                if (System.currentTimeMillis() - fTSMainUI.pff > 1000) {
                    fTSMainUI.pff = System.currentTimeMillis();
                    if (d.Ii()) {
                        i.aW(optInt, 14);
                        fTSMainUI.aHf();
                        Intent Il2 = d.Il();
                        Il2.putExtra("ftsneedkeyboard", true);
                        Il2.putExtra("ftsbizscene", 14);
                        Il2.putExtra("ftsType", optInt);
                        Il2.putExtra("rawUrl", d.m(d.a(14, true, optInt)));
                        Il2.putExtra("key_load_js_without_delay", true);
                        com.tencent.mm.bb.d.b(ab.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", Il2);
                        return;
                    }
                    w.e("MicroMsg.FTS.FTSMainUI", "fts h5 template not avail");
                }
            }
        }
    };
    private c<sn> pgl = new c<sn>(this) {
        final /* synthetic */ FTSMainUI pgm;

        {
            this.pgm = r2;
            this.usg = sn.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.pgm.pfZ.ar();
            return false;
        }
    };

    static /* synthetic */ void a(FTSMainUI fTSMainUI, final String str) {
        b bVar = fTSMainUI.pgj;
        bVar.pfK = true;
        if (!bg.mA(bVar.fRM)) {
            i.c(bVar.fRM, bVar.pfa, 1, 3);
        }
        if (str != null && str.length() != 0 && str.trim().length() != 0) {
            fTSMainUI.pfe = Character.isDigit(str.charAt(0)) ? 15 : 3;
            final e anonymousClass7 = new e(fTSMainUI) {
                final /* synthetic */ FTSMainUI pgm;

                public final void a(int i, int i2, String str, k kVar) {
                    ap.vd().b(MMGIFException.D_GIF_ERR_NO_COLOR_MAP, this);
                    if (i == 4 && i2 == -4) {
                        af.v(new Runnable(this.pgm) {
                            final /* synthetic */ FTSMainUI pgm;

                            {
                                this.pgm = r1;
                            }

                            public final void run() {
                                if (this.pgm.leb != null) {
                                    this.pgm.leb.dismiss();
                                    this.pgm.leb = null;
                                }
                            }
                        });
                        g.a(this.pgm, R.l.dCI, 0, true, null);
                        return;
                    }
                    af.v(/* anonymous class already generated */);
                    if (i == 0 && i2 == 0) {
                        awr Jx = ((aa) kVar).Jx();
                        Intent intent;
                        if (Jx.tDR > 0) {
                            if (Jx.tDS.isEmpty()) {
                                g.a(this.pgm, R.l.dCI, 0, true, null);
                                return;
                            }
                            intent = new Intent();
                            com.tencent.mm.pluginsdk.ui.tools.c.a(intent, (awp) Jx.tDS.getFirst(), this.pgm.pfe);
                            com.tencent.mm.plugin.search.a.imv.d(intent, this.pgm);
                            return;
                        } else if (bg.mz(n.a(Jx.ttp)).length() > 0) {
                            if (2 == Jx.tZI) {
                                this.pgm.pfe = 15;
                            } else if (1 == Jx.tZI) {
                                this.pgm.pfe = 1;
                            }
                            intent = new Intent();
                            com.tencent.mm.pluginsdk.ui.tools.c.a(intent, Jx, this.pgm.pfe);
                            if (this.pgm.pfe == 15) {
                                intent.putExtra("Contact_Search_Mobile", str.trim());
                            }
                            intent.putExtra("add_more_friend_search_scene", 2);
                            com.tencent.mm.plugin.search.a.imv.d(intent, this.pgm);
                            return;
                        } else {
                            return;
                        }
                    }
                    switch (i2) {
                        case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                            com.tencent.mm.f.a dn = com.tencent.mm.f.a.dn(str);
                            if (dn != null) {
                                g.a(this.pgm, dn.desc, dn.fDC, true, null);
                                break;
                            }
                            break;
                        case -4:
                            Toast.makeText(this.pgm, this.pgm.getString(R.l.elR), 0).show();
                            break;
                    }
                    w.w("MicroMsg.FTS.FTSMainUI", String.format("Search contact failed: %d, %d.", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
                }
            };
            ap.vd().a(MMGIFException.D_GIF_ERR_NO_COLOR_MAP, anonymousClass7);
            final k aaVar = new aa(str, 3);
            ap.vd().a(aaVar, 0);
            fTSMainUI.getString(R.l.dIO);
            fTSMainUI.leb = g.a(fTSMainUI, fTSMainUI.getString(R.l.dCL), true, new OnCancelListener(fTSMainUI) {
                final /* synthetic */ FTSMainUI pgm;

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(aaVar);
                    ap.vd().b(MMGIFException.D_GIF_ERR_NO_COLOR_MAP, anonymousClass7);
                    this.pgm.leb = null;
                }
            });
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        r1 = new Object[2];
        h.vG();
        r1[0] = Integer.valueOf(com.tencent.mm.kernel.a.uH());
        r1[1] = Long.valueOf(System.currentTimeMillis());
        com.tencent.mm.as.g.hPK = String.format("#%d_#%d", r1);
        this.pfZ = (FTSMainUIEducationLayout) findViewById(R.h.cAF);
        this.pgb = (LinearLayout) findViewById(R.h.cAP);
        this.pfZ.i(this.pgk);
        this.pfZ.wiw = new OnClickListener(this) {
            final /* synthetic */ FTSMainUI pgm;

            {
                this.pgm = r1;
            }

            public final void onClick(View view) {
                this.pgm.onClickSnsHotArticle((String) view.getTag());
            }
        };
        this.pfZ.bZd();
        if (aZJ()) {
            this.pfZ.wiv = true;
            this.pfZ.wix = new OnClickListener(this) {
                final /* synthetic */ FTSMainUI pgm;

                {
                    this.pgm = r1;
                }

                public final void onClick(View view) {
                    Context context = this.pgm;
                    if (view.getTag().equals("more-click")) {
                        ((com.tencent.mm.plugin.appbrand.i.e) h.h(com.tencent.mm.plugin.appbrand.i.e.class)).a(context, com.tencent.mm.as.g.hPK, com.tencent.mm.plugin.appbrand.i.e.a.CLICK);
                    } else if (view.getTag().equals("more-swipe")) {
                        ((com.tencent.mm.plugin.appbrand.i.e) h.h(com.tencent.mm.plugin.appbrand.i.e.class)).a(context, com.tencent.mm.as.g.hPK, com.tencent.mm.plugin.appbrand.i.e.a.SWIPE);
                    } else {
                        ((com.tencent.mm.plugin.appbrand.i.e) h.h(com.tencent.mm.plugin.appbrand.i.e.class)).a(context, (com.tencent.mm.plugin.appbrand.i.e.c) view.getTag(), com.tencent.mm.as.g.hPK);
                    }
                }
            };
        }
        com.tencent.mm.plugin.search.a.c.aZm();
        com.tencent.mm.modelgeo.c.Gk().a(this, true);
        if (com.tencent.mm.plugin.search.a.c.aZl() == null) {
            finish();
            return;
        }
        com.tencent.mm.plugin.search.a.c.aZl().aya();
        j.gt(3);
        com.tencent.mm.sdk.b.a.urY.a(this.pgl);
    }

    protected final void aZu() {
        switch (getIntent().getIntExtra("from_tab_index", -1)) {
            case 0:
                this.mcx = 1;
                return;
            case 1:
                this.mcx = 2;
                return;
            case 2:
                this.mcx = 3;
                return;
            case 3:
                this.mcx = 4;
                return;
            default:
                this.mcx = 0;
                return;
        }
    }

    protected final boolean aZB() {
        return v.bIK();
    }

    protected final b a(c cVar) {
        this.pgj = new f(cVar, this.mcx);
        return this.pgj;
    }

    protected final int getLayoutId() {
        return R.i.ddO;
    }

    public final void b(com.tencent.mm.plugin.fts.d.a.a aVar) {
    }

    protected void onDestroy() {
        af.v(new Runnable(this) {
            final /* synthetic */ FTSMainUI pgm;

            {
                this.pgm = r1;
            }

            public final void run() {
                b ghVar = new gh();
                ghVar.fLB.context = ab.getContext();
                ghVar.fLB.actionCode = 3;
                com.tencent.mm.sdk.b.a.urY.m(ghVar);
            }
        });
        com.tencent.mm.modelgeo.c.Gk().c(this);
        if (com.tencent.mm.plugin.fts.d.h.aye() != null) {
            com.tencent.mm.plugin.fts.d.h.aye().ayb();
        }
        com.tencent.mm.sdk.b.a.urY.c(this.pgl);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        b reVar = new re();
        reVar.fYh.fYi = 0;
        com.tencent.mm.sdk.b.a.urY.m(reVar);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(com.tencent.mm.ui.d.g.uOD, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        sendBroadcast(intent);
        if (this.pgc != null) {
            this.pgc.setEnabled(true);
        }
    }

    public void finish() {
        aHf();
        super.finish();
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        w.i("MicroMsg.FTS.FTSMainUI", "onGetLocation %b %f|%f", new Object[]{Boolean.valueOf(z), Float.valueOf(f), Float.valueOf(f2)});
        com.tencent.mm.modelgeo.c.Gk().c(this);
        return false;
    }

    private void aZG() {
        this.pfZ.setVisibility(0);
        this.pfZ.ar();
    }

    private void aZH() {
        this.pfZ.setVisibility(8);
    }

    protected final void aZC() {
        super.aZC();
        aZH();
        this.pgb.setVisibility(8);
    }

    protected final void aZD() {
        super.aZD();
        aZG();
        this.pgb.setVisibility(8);
    }

    protected final void aZA() {
        super.aZA();
        aZG();
        this.pgb.setVisibility(8);
    }

    protected final void aZz() {
        super.aZz();
        aZH();
        this.pgb.setVisibility(8);
    }

    protected final void aZy() {
        super.aZy();
        aZH();
        this.pgb.setVisibility(8);
        this.pfn.setVisibility(0);
        this.mFc.setVisibility(8);
    }

    protected final void aZx() {
        super.aZx();
        aZH();
        this.pgb.setVisibility(8);
    }

    public final View agV() {
        if (this.nww == null) {
            this.nww = getLayoutInflater().inflate(R.i.ddM, null);
            this.pge = (TextView) this.nww.findViewById(R.h.cAS);
            this.pgf = (TextView) this.nww.findViewById(R.h.bSi);
            try {
                w.i("MicroMsg.FTS.FTSMainUI", "set searchNetworkTips %s", new Object[]{j.kb("webSearchBar").optString("wording")});
                this.pgf.setText(r0);
            } catch (Exception e) {
            }
            this.pgd = this.nww.findViewById(R.h.cAQ);
            this.pgc = this.nww.findViewById(R.h.cAR);
            this.pgc.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FTSMainUI pgm;

                {
                    this.pgm = r1;
                }

                public final void onClick(View view) {
                    this.pgm.aZI();
                }
            });
            this.pgi = (TextView) this.nww.findViewById(R.h.cAz);
            this.pgh = this.nww.findViewById(R.h.cAx);
            this.pgg = this.nww.findViewById(R.h.cAy);
            this.pgg.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FTSMainUI pgm;

                {
                    this.pgm = r1;
                }

                public final void onClick(View view) {
                    FTSMainUI.a(this.pgm, this.pgm.fRM);
                }
            });
            this.pga = (LinearLayout) this.nww.findViewById(R.h.bQU);
        }
        return this.nww;
    }

    private void aZI() {
        this.pgj.pfK = true;
        String str = this.fRM;
        if (str != null && !bg.mA(str.trim()) && System.currentTimeMillis() - this.pff > 1000) {
            this.pff = System.currentTimeMillis();
            if (d.Ii()) {
                Intent Il = d.Il();
                Il.putExtra("ftsbizscene", 3);
                Il.putExtra("ftsQuery", this.fRM);
                Map a = d.a(3, true, 0);
                a.put("query", this.fRM);
                a.put("sessionId", d.gm(bg.PY((String) a.get("scene"))));
                Il.putExtra("rawUrl", d.m(a));
                b khVar = new kh();
                khVar.fQJ.scene = 0;
                com.tencent.mm.sdk.b.a.urY.m(khVar);
                com.tencent.mm.bb.d.b(this.uSU.uTo, "webview", ".ui.tools.fts.FTSWebViewUI", Il);
                i.gr(3);
                if (!bg.mA(this.fRM)) {
                    i.c(this.fRM, 2, 2, 3);
                }
                this.pgc.setEnabled(false);
                return;
            }
            w.e("MicroMsg.FTS.FTSMainUI", "fts h5 template not avail");
        }
    }

    public final boolean mQ(String str) {
        if (this.pgj.getCount() == 0) {
            aZI();
        }
        return super.mQ(str);
    }

    protected final void aZE() {
        if (this.pga != null) {
            this.pga.setVisibility(0);
        }
    }

    protected final void aZF() {
        if (this.pga != null) {
            this.pga.setVisibility(8);
        }
    }

    public final void a(boolean z, String[] strArr, long j, int i) {
        super.a(z, strArr, j, i);
        if (z) {
            com.tencent.mm.bb.d.a(this, ".ui.voicesearch.VoiceSearchResultUI", new Intent().putExtra("VoiceSearchResultUI_Resultlist", strArr).putExtra("VoiceSearchResultUI_VoiceId", j).putExtra("VoiceSearchResultUI_ShowType", i));
            return;
        }
        com.tencent.mm.bb.d.a(this, ".ui.voicesearch.VoiceSearchResultUI", new Intent().putExtra("VoiceSearchResultUI_Resultlist", new String[0]).putExtra("VoiceSearchResultUI_Error", this.uSU.uTo.getString(R.l.elv)).putExtra("VoiceSearchResultUI_VoiceId", j).putExtra("VoiceSearchResultUI_ShowType", i));
    }

    public final void M(int i, boolean z) {
        super.M(i, z);
        if (!z && i == 0 && this.pgj.pfV) {
            this.pgb.setVisibility(0);
        } else {
            this.pgb.setVisibility(8);
        }
        if (z) {
            boolean DU = com.tencent.mm.plugin.search.a.b.DU(this.fRM);
            boolean DV = com.tencent.mm.plugin.search.a.b.DV(this.fRM);
            if (i > 0) {
                if (DU || DV) {
                    this.pgh.setVisibility(0);
                }
                this.pgd.setVisibility(0);
            } else {
                this.pgh.setVisibility(8);
                if (DU || DV) {
                    this.pgd.setVisibility(0);
                } else {
                    this.pgd.setVisibility(8);
                }
            }
            if (DU || DV) {
                this.pgg.setVisibility(0);
            }
            this.pgc.setVisibility(0);
            return;
        }
        this.pgc.setVisibility(8);
        this.pgg.setVisibility(8);
    }

    protected final void aZp() {
        super.aZp();
        this.pge.setText(com.tencent.mm.pluginsdk.ui.d.h.c(this, f.a(getString(R.l.enp), "", com.tencent.mm.plugin.fts.d.b.a.d(this.fRM, this.fRM)).mdL, com.tencent.mm.bg.a.T(this, R.f.aXI)));
        CharSequence charSequence = null;
        if (com.tencent.mm.plugin.search.a.b.DU(this.fRM)) {
            charSequence = f.a(getString(R.l.ena), "", com.tencent.mm.plugin.fts.d.b.a.d(this.fRM, this.fRM)).mdL;
        } else if (com.tencent.mm.plugin.search.a.b.DV(this.fRM)) {
            charSequence = f.a(getString(R.l.enb), "", com.tencent.mm.plugin.fts.d.b.a.d(this.fRM, this.fRM)).mdL;
        }
        this.pgi.setText(com.tencent.mm.pluginsdk.ui.d.h.c(this, charSequence, com.tencent.mm.bg.a.T(this, R.f.aXI)));
    }

    public void onClickSnsHotArticle(String str) {
        if (System.currentTimeMillis() - this.pff > 1000) {
            this.pff = System.currentTimeMillis();
            if (d.Ii()) {
                Intent Il = d.Il();
                Il.putExtra("ftsbizscene", 15);
                Il.putExtra("ftsQuery", str);
                Il.putExtra("title", str);
                Il.putExtra("isWebwx", str);
                Il.putExtra("ftscaneditable", false);
                Map a = d.a(15, false, 2);
                a.put("query", str);
                a.put("sceneActionType", "2");
                Il.putExtra("rawUrl", d.m(a));
                b khVar = new kh();
                khVar.fQJ.scene = 0;
                com.tencent.mm.sdk.b.a.urY.m(khVar);
                com.tencent.mm.bb.d.b(this.uSU.uTo, "webview", ".ui.tools.fts.FTSWebViewUI", Il);
                i.q(15, str);
                return;
            }
            w.e("MicroMsg.FTS.FTSMainUI", "fts h5 template not avail");
        }
    }

    private static boolean aZJ() {
        try {
            if (Integer.valueOf((String) com.tencent.mm.u.c.c.Az().dX("100285").bKK().get("isOpen")).intValue() == 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
