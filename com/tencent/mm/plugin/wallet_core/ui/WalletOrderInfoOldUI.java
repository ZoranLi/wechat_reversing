package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.e.a.al;
import com.tencent.mm.e.a.am;
import com.tencent.mm.e.a.ib;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.e.a.rw;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.b.f;
import com.tencent.mm.plugin.wallet_core.b.n;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.wallet_core.c.h;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class WalletOrderInfoOldUI extends WalletOrderInfoUI {
    protected boolean fDR = true;
    protected boolean fDS = false;
    protected boolean fDT = false;
    protected String ivH = "";
    protected String jia = null;
    private String oSc;
    protected String ocu;
    private com.tencent.mm.sdk.b.c oeu = new com.tencent.mm.sdk.b.c<rw>(this) {
        final /* synthetic */ WalletOrderInfoOldUI rMu;

        {
            this.rMu = r2;
            this.usg = rw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            rw rwVar = (rw) bVar;
            if (!(rwVar instanceof rw)) {
                return false;
            }
            if (!rwVar.fZo.fZp.ods) {
                w.i("MicroMsg.WalletOrderInfoOldUI", "block pass");
                return true;
            } else if (!"1".equals(rwVar.fZo.fZp.fZb) && !"2".equals(rwVar.fZo.fZp.fZb)) {
                return false;
            } else {
                Parcelable realnameGuideHelper = new RealnameGuideHelper();
                realnameGuideHelper.a(rwVar.fZo.fZp.fZb, rwVar.fZo.fZp.fZc, rwVar.fZo.fZp.fZd, rwVar.fZo.fZp.fZe, rwVar.fZo.fZp.fZf, this.rMu.rze == null ? 0 : this.rMu.rze.fRv);
                w.i("MicroMsg.WalletOrderInfoOldUI", "receive guide");
                this.rMu.uT.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                return false;
            }
        }
    };
    protected String ohs = null;
    protected boolean rLp = false;
    public Set<String> rLq = null;
    public List<Commodity> rLr = null;
    private HashMap<String, b> rLx = new HashMap();
    protected String rLy;
    private com.tencent.mm.sdk.b.c rMb = new com.tencent.mm.sdk.b.c<am>(this) {
        final /* synthetic */ WalletOrderInfoOldUI rMu;

        {
            this.rMu = r2;
            this.usg = am.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            am amVar = (am) bVar;
            if (amVar instanceof am) {
                this.rMu.rMm = amVar.fDO.fDQ;
                this.rMu.fDR = amVar.fDO.fDR;
                this.rMu.fDS = amVar.fDO.fDS;
                this.rMu.fDT = amVar.fDO.fDT;
                if (this.rMu.fDT && !bg.mA(this.rMu.rLy)) {
                    for (int i = 0; i < this.rMu.rLr.size(); i++) {
                        Commodity commodity = (Commodity) this.rMu.rLr.get(i);
                        int i2 = -1;
                        for (int i3 = 0; i3 < commodity.rGz.size(); i3++) {
                            com.tencent.mm.plugin.wallet_core.model.Orders.b bVar2 = (com.tencent.mm.plugin.wallet_core.model.Orders.b) commodity.rGz.get(i3);
                            if (bVar2.type == Orders.rGr && !bg.mA(bVar2.url) && bVar2.url.equals(this.rMu.rLy)) {
                                i2 = i3;
                            }
                        }
                        if (i2 >= 0) {
                            commodity.rGz.remove(i2);
                        }
                    }
                }
                this.rMu.rMl.notifyDataSetChanged();
                if (!bg.mA(this.rMu.rLy)) {
                    TextView textView = (TextView) this.rMu.rMn.get(this.rMu.rLy);
                    if (textView != null) {
                        textView.setClickable(this.rMu.fDR);
                        textView.setEnabled(this.rMu.fDR);
                        textView.setOnClickListener(null);
                        if (this.rMu.fDS) {
                            textView.setVisibility(8);
                        }
                    }
                }
                amVar.fDP.fDU = true;
            }
            return false;
        }
    };
    protected LinearLayout rMi = null;
    protected TextView rMj = null;
    protected TextView rMk = null;
    public a rMl = null;
    protected String rMm = null;
    protected HashMap<String, TextView> rMn = new HashMap();
    protected c rMo;
    protected Map<Long, String> rMp = new HashMap();
    private d rMq;
    private boolean rMr = false;
    public com.tencent.mm.u.ag.b.a rMs = new com.tencent.mm.u.ag.b.a(this) {
        final /* synthetic */ WalletOrderInfoOldUI rMu;

        {
            this.rMu = r1;
        }

        public final void p(String str, boolean z) {
            ap.yY();
            x Rc = com.tencent.mm.u.c.wR().Rc(str);
            w.d("MicroMsg.WalletOrderInfoOldUI", "call back from contactServer " + str + " succ: " + z);
            this.rMu.K(Rc);
        }
    };
    private OnLongClickListener rMt = new OnLongClickListener(this) {
        final /* synthetic */ WalletOrderInfoOldUI rMu;

        {
            this.rMu = r1;
        }

        public final boolean onLongClick(View view) {
            if (view.getId() == R.h.cQP || view.getId() == R.h.cRn) {
                try {
                    String str = (String) view.getTag();
                    Toast.makeText(this.rMu, R.l.fgU, 0).show();
                    com.tencent.mm.pluginsdk.j.d.a(this.rMu.uSU.uTo, str, str);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.WalletOrderInfoOldUI", e, "", new Object[0]);
                }
            }
            return true;
        }
    };
    public Orders ryM;
    protected PayInfo rze;

    public class a extends BaseAdapter {
        final /* synthetic */ WalletOrderInfoOldUI rMu;

        class a {
            TextView ipx;
            CdnImageView rLK;
            TextView rLL;
            TextView rLM;
            TextView rMA;
            TextView rMB;
            TextView rMC;
            TextView rMD;
            View rME;
            MaxListView rMF;
            View rMG;
            TextView rMH;
            TextView rMI;
            TextView rMJ;
            TextView rMK;
            View rML;
            ViewGroup rMM;
            final /* synthetic */ a rMv;
            TextView rMx;
            TextView rMy;
            TextView rMz;

            a(a aVar) {
                this.rMv = aVar;
            }
        }

        public a(WalletOrderInfoOldUI walletOrderInfoOldUI) {
            this.rMu = walletOrderInfoOldUI;
        }

        public final /* synthetic */ Object getItem(int i) {
            return vD(i);
        }

        public final int getCount() {
            return this.rMu.rLr != null ? this.rMu.rLr.size() : 0;
        }

        private Commodity vD(int i) {
            return (Commodity) this.rMu.rLr.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = View.inflate(this.rMu, R.i.dqY, null);
                a aVar2 = new a(this);
                aVar2.rMx = (TextView) view.findViewById(R.h.cQL);
                aVar2.ipx = (TextView) view.findViewById(R.h.cQP);
                aVar2.rMA = (TextView) view.findViewById(R.h.cRh);
                aVar2.rMy = (TextView) view.findViewById(R.h.cRm);
                aVar2.rMz = (TextView) view.findViewById(R.h.cRa);
                aVar2.rMz.getPaint().setFlags(16);
                aVar2.rMB = (TextView) view.findViewById(R.h.cRn);
                aVar2.rMC = (TextView) view.findViewById(R.h.cQO);
                aVar2.rMD = (TextView) view.findViewById(R.h.cQK);
                aVar2.rMF = (MaxListView) view.findViewById(R.h.cRc);
                aVar2.rMG = view.findViewById(R.h.cQS);
                aVar2.rME = view.findViewById(R.h.cRf);
                aVar2.rMI = (TextView) view.findViewById(R.h.cRo);
                aVar2.rMH = (TextView) view.findViewById(R.h.cRp);
                aVar2.rMJ = (TextView) view.findViewById(R.h.cRq);
                aVar2.rMK = (TextView) view.findViewById(R.h.cRr);
                aVar2.rMM = (ViewGroup) view.findViewById(R.h.cRj);
                aVar2.rLK = (CdnImageView) view.findViewById(R.h.cIx);
                aVar2.rLL = (TextView) view.findViewById(R.h.cIt);
                aVar2.rLM = (TextView) view.findViewById(R.h.cIy);
                aVar2.rML = view.findViewById(R.h.cRg);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            final Commodity vD = vD(i);
            if (!(vD == null || aVar == null)) {
                CharSequence string;
                this.rMu.oSc = vD.fTA;
                aVar.rMy.setText(e.d(vD.kBc, vD.oga));
                if (vD.rGs < 0.0d || vD.kBc >= vD.rGs) {
                    aVar.rMz.setVisibility(8);
                } else {
                    aVar.rMz.setText(e.d(vD.rGs, vD.oga));
                    aVar.rMz.setVisibility(0);
                }
                LinearLayout linearLayout = (LinearLayout) aVar.rMG;
                List list = vD.rGv;
                linearLayout.removeAllViews();
                if (list != null && list.size() > 0) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        DiscountInfo discountInfo = (DiscountInfo) list.get(i2);
                        View textView = new TextView(this.rMu.uSU.uTo);
                        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.bottomMargin = this.rMu.uSU.uTo.getResources().getDimensionPixelOffset(R.f.aWA);
                        textView.setLayoutParams(layoutParams);
                        textView.setTextAppearance(this.rMu.uSU.uTo, R.m.foA);
                        textView.setText(discountInfo.rxH + e.d(discountInfo.rGF / 100.0d, this.rMu.ryM.oga));
                        linearLayout.addView(textView);
                        textView.setTextColor(this.rMu.getResources().getColor(R.e.aWh));
                    }
                }
                if (linearLayout.getChildCount() > 0) {
                    linearLayout.setVisibility(0);
                } else {
                    linearLayout.setVisibility(8);
                }
                TextView textView2 = aVar.rMx;
                Context context = this.rMu;
                if (m.xY()) {
                    string = context.getString(R.l.fhj);
                } else {
                    string = context.getString(R.l.fhi);
                }
                textView2.setText(string);
                aVar.rMA.setText(vD.ofP);
                aVar.ipx.setText(vD.desc);
                aVar.ipx.setTag(vD.desc);
                aVar.ipx.setOnLongClickListener(this.rMu.rMt);
                aVar.ipx.setBackgroundResource(R.g.blU);
                aVar.rMB.setText(vD.fTA);
                aVar.rMB.setTag(vD.fTA);
                aVar.rMB.setOnLongClickListener(this.rMu.rMt);
                aVar.rMB.setBackgroundResource(R.g.blU);
                aVar.rMC.setText(e.CK(vD.ofW));
                aVar.rMD.setText(vD.ofY);
                string = vD.rGw;
                if (aVar.rMJ != null) {
                    if (bg.mA(string)) {
                        aVar.rMK.setVisibility(8);
                        aVar.rMJ.setVisibility(8);
                    } else {
                        aVar.rMJ.setText(string);
                        aVar.rMJ.setVisibility(0);
                        aVar.rMK.setVisibility(0);
                    }
                }
                string = vD.rGx;
                if (aVar.rMI != null) {
                    if (bg.mA(string)) {
                        aVar.rMH.setVisibility(8);
                        aVar.rMI.setVisibility(8);
                    } else {
                        aVar.rMI.setText(string);
                        aVar.rMI.setVisibility(0);
                        aVar.rMH.setVisibility(0);
                    }
                }
                if (vD.rGz.size() > 0) {
                    com.tencent.mm.plugin.wallet_core.model.Orders.b bVar = (com.tencent.mm.plugin.wallet_core.model.Orders.b) vD.rGz.get(0);
                    g.oUh.i(13033, new Object[]{Integer.valueOf(1), bVar.ogb, bVar.url, bVar.name, this.rMu.oSc});
                    this.rMu.rMo = new c(this.rMu, vD.rGz);
                    aVar.rMF.setAdapter(this.rMu.rMo);
                    aVar.rMF.setOnItemClickListener(new OnItemClickListener(this) {
                        final /* synthetic */ a rMv;

                        {
                            this.rMv = r1;
                        }

                        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                            com.tencent.mm.plugin.wallet_core.model.Orders.b vE = this.rMv.rMu.rMo.vE(i);
                            if (bg.mA(vE.ogb)) {
                                String dU = this.rMv.rMu.dU(vE.rGI);
                                if ("-1".equals(dU) || TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(dU)) {
                                    g.oUh.i(13472, new Object[]{this.rMv.rMu.oSc, Integer.valueOf(vE.rGJ), Integer.valueOf(1), Long.valueOf(vE.rGI), Long.valueOf(vE.rGQ)});
                                    g.oUh.i(13033, new Object[]{Integer.valueOf(2), "", vE.url, vE.name, ""});
                                    if (!bg.mA(vE.rGO) && !bg.mA(vE.rGP)) {
                                        w.i("MicroMsg.WalletOrderInfoOldUI", "promotion jump tiny app, username: %s, path: %s", new Object[]{vE.rGO, vE.rGP});
                                        com.tencent.mm.sdk.b.b prVar = new pr();
                                        prVar.fWB.userName = vE.rGO;
                                        prVar.fWB.fWD = bg.ap(vE.rGP, "");
                                        prVar.fWB.scene = 1060;
                                        prVar.fWB.fCN = this.rMv.rMu.ocu;
                                        prVar.fWB.fWE = 0;
                                        com.tencent.mm.sdk.b.a.urY.m(prVar);
                                        g.oUh.i(14118, new Object[]{this.rMv.rMu.ocu, this.rMv.rMu.bsF(), Integer.valueOf(2)});
                                        this.rMv.rMu.rMq = new d(this.rMv.rMu, vE.rGI, vE.rGK, vE.rGL, vE.rGM, this.rMv.rMu.bsF(), this.rMv.rMu.oSc, vE.rGQ);
                                        this.rMv.rMu.rMr = true;
                                        return;
                                    } else if (vE.rGJ == 1) {
                                        this.rMv.rMu.a(vE);
                                        return;
                                    } else if (vE.rGJ != 2 || bg.mA(vE.url)) {
                                        w.e("MicroMsg.WalletOrderInfoOldUI", "promotion's activityActionType != ACTION_TYPE_NORMAL and url is null,unknow option");
                                        return;
                                    } else if (this.rMv.rMu.rLx.containsKey(vE.rGI)) {
                                        w.i("MicroMsg.WalletOrderInfoOldUI", "go to new url %s", new Object[]{((b) this.rMv.rMu.rLx.get(vE.rGI)).url});
                                        this.rMv.rMu.In(r0.url);
                                        return;
                                    } else {
                                        this.rMv.rMu.rLy = vE.url;
                                        this.rMv.rMu.a(vE.url, new d(this.rMv.rMu, vE.rGI, vE.rGK, vE.rGL, vE.rGM, this.rMv.rMu.bsF(), this.rMv.rMu.oSc, vE.rGQ));
                                        return;
                                    }
                                }
                                return;
                            }
                            if (this.rMv.rMu.rLq.contains(vE.ogb)) {
                                this.rMv.rMu.rLq.remove(vE.ogb);
                            } else {
                                this.rMv.rMu.rLq.add(vE.ogb);
                            }
                            this.rMv.rMu.rMl.notifyDataSetChanged();
                        }
                    });
                    this.rMu.rMo.notifyDataSetChanged();
                    aVar.rMF.setVisibility(0);
                    aVar.rME.setVisibility(0);
                } else {
                    aVar.rMF.setVisibility(8);
                    aVar.rMM.setVisibility(8);
                    aVar.rME.setVisibility(8);
                }
                if (vD.rGy == null || bg.mA(vD.rGy.rGU)) {
                    aVar.rMM.setVisibility(8);
                    aVar.rML.setVisibility(8);
                } else {
                    aVar.rLK.L(vD.rGy.rGS, 0, 0);
                    aVar.rLL.setText(vD.rGy.rGT);
                    aVar.rLM.setText(vD.rGy.rGR);
                    aVar.rMM.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ a rMv;

                        public final void onClick(View view) {
                            com.tencent.mm.sdk.b.b prVar = new pr();
                            prVar.fWB.userName = vD.rGy.rGU;
                            prVar.fWB.fWD = bg.ap(vD.rGy.rGV, "");
                            prVar.fWB.scene = 1034;
                            prVar.fWB.fWE = 0;
                            com.tencent.mm.sdk.b.a.urY.m(prVar);
                            g.oUh.i(14118, new Object[]{this.rMv.rMu.ocu, this.rMv.rMu.bsF(), Integer.valueOf(1)});
                        }
                    });
                    aVar.rML.setVisibility(0);
                }
            }
            return view;
        }
    }

    class b {
        public String fNG;
        public String fSl;
        public String rMe;
        final /* synthetic */ WalletOrderInfoOldUI rMu;
        public String title;
        public String url;

        public b(WalletOrderInfoOldUI walletOrderInfoOldUI, JSONObject jSONObject) {
            this.rMu = walletOrderInfoOldUI;
            if (jSONObject != null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("activity_change_info");
                if (optJSONObject != null) {
                    this.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    this.fNG = optJSONObject.optString("wording");
                    this.fSl = optJSONObject.optString("icon");
                    this.rMe = optJSONObject.optString("btn_text");
                    this.title = optJSONObject.optString("title");
                }
            }
        }

        public final String toString() {
            return this.url + " , " + this.fNG + " , " + this.fSl + " , " + this.rMe + " , " + this.title;
        }
    }

    class c extends BaseAdapter {
        protected List<com.tencent.mm.plugin.wallet_core.model.Orders.b> rGz;
        final /* synthetic */ WalletOrderInfoOldUI rMu;

        class a {
            TextView ioX;
            TextView iuF;
            int rGH;
            CdnImageView rMN;
            TextView rMO;
            CheckBox rMP;
            final /* synthetic */ c rMQ;
            int type;

            a(c cVar) {
                this.rMQ = cVar;
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return vE(i);
        }

        public c(WalletOrderInfoOldUI walletOrderInfoOldUI, List<com.tencent.mm.plugin.wallet_core.model.Orders.b> list) {
            this.rMu = walletOrderInfoOldUI;
            this.rGz = null;
            this.rGz = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                com.tencent.mm.plugin.wallet_core.model.Orders.b bVar = (com.tencent.mm.plugin.wallet_core.model.Orders.b) list.get(i);
                if (bVar != null && (!bg.mA(bVar.ogb) || bVar.rGJ == 2 || bVar.rGJ == 1)) {
                    this.rGz.add(list.get(i));
                }
            }
        }

        public final int getCount() {
            return this.rGz != null ? this.rGz.size() : 0;
        }

        public final com.tencent.mm.plugin.wallet_core.model.Orders.b vE(int i) {
            return (com.tencent.mm.plugin.wallet_core.model.Orders.b) this.rGz.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            String dU;
            a aVar;
            com.tencent.mm.plugin.wallet_core.model.Orders.b vE = vE(i);
            if (bg.mA(vE.ogb) && vE.rGI > 0) {
                dU = this.rMu.dU(vE.rGI);
                g gVar = g.oUh;
                Object[] objArr = new Object[6];
                objArr[0] = this.rMu.oSc;
                objArr[1] = Integer.valueOf(1);
                objArr[2] = Integer.valueOf(vE.rGJ);
                if ("-1".equals(dU)) {
                    dU = Integer.valueOf(5);
                }
                objArr[3] = dU;
                objArr[4] = Long.valueOf(vE.rGI);
                objArr[5] = Long.valueOf(vE.rGQ);
                gVar.i(13471, objArr);
            }
            a aVar2;
            View inflate;
            View view2;
            if (view == null) {
                aVar2 = new a(this);
                aVar2.type = vE.type;
                if (vE.type == Orders.rGr) {
                    if (vE.rGH == 1) {
                        inflate = View.inflate(this.rMu, R.i.dqZ, null);
                        aVar2.rMN = (CdnImageView) inflate.findViewById(R.h.cQX);
                        aVar2.ioX = (TextView) inflate.findViewById(R.h.cRk);
                        aVar2.rMO = (TextView) inflate.findViewById(R.h.cQN);
                        aVar2.iuF = (TextView) inflate.findViewById(R.h.cQZ);
                        if (!TextUtils.isEmpty(vE.url)) {
                            this.rMu.rMn.put(vE.url, aVar2.rMO);
                        }
                        inflate.setTag(aVar2);
                        view2 = inflate;
                    } else {
                        inflate = View.inflate(this.rMu, R.i.dra, null);
                        aVar2.rMN = (CdnImageView) inflate.findViewById(R.h.cQX);
                        aVar2.rMO = (TextView) inflate.findViewById(R.h.cQN);
                        aVar2.iuF = (TextView) inflate.findViewById(R.h.cQZ);
                        aVar2.ioX = (TextView) inflate.findViewById(R.h.cRk);
                        if (!TextUtils.isEmpty(vE.url)) {
                            this.rMu.rMn.put(vE.url, aVar2.rMO);
                        }
                        inflate.setTag(aVar2);
                        view2 = inflate;
                    }
                    aVar2.rGH = vE.rGH;
                    view = view2;
                    aVar = aVar2;
                } else {
                    view = View.inflate(this.rMu, R.i.drb, null);
                    aVar2.rMN = (CdnImageView) view.findViewById(R.h.cQX);
                    aVar2.rMO = (TextView) view.findViewById(R.h.cQN);
                    aVar2.iuF = (TextView) view.findViewById(R.h.cQZ);
                    aVar2.rMP = (CheckBox) view.findViewById(R.h.bob);
                    if (!TextUtils.isEmpty(vE.url)) {
                        this.rMu.rMn.put(vE.url, aVar2.rMO);
                    }
                    view.setTag(aVar2);
                    aVar = aVar2;
                }
            } else {
                a aVar3 = (a) view.getTag();
                Object obj = null;
                if (vE.type == aVar3.type && (vE.type != Orders.rGr || vE.rGH == aVar3.rGH)) {
                    obj = 1;
                }
                if (obj == null) {
                    aVar2 = new a(this);
                    aVar2.type = vE.type;
                    if (vE.type == Orders.rGr) {
                        if (vE.rGH == 1) {
                            inflate = View.inflate(this.rMu, R.i.dqZ, null);
                            aVar2.rMN = (CdnImageView) inflate.findViewById(R.h.cQX);
                            aVar2.ioX = (TextView) inflate.findViewById(R.h.cRk);
                            aVar2.rMO = (TextView) inflate.findViewById(R.h.cQN);
                            aVar2.iuF = (TextView) inflate.findViewById(R.h.cQZ);
                            if (!TextUtils.isEmpty(vE.url)) {
                                this.rMu.rMn.put(vE.url, aVar2.rMO);
                            }
                            inflate.setTag(aVar2);
                            view2 = inflate;
                        } else {
                            inflate = View.inflate(this.rMu, R.i.dra, null);
                            aVar2.rMN = (CdnImageView) inflate.findViewById(R.h.cQX);
                            aVar2.rMO = (TextView) inflate.findViewById(R.h.cQN);
                            aVar2.iuF = (TextView) inflate.findViewById(R.h.cQZ);
                            aVar2.ioX = (TextView) inflate.findViewById(R.h.cRk);
                            if (!TextUtils.isEmpty(vE.url)) {
                                this.rMu.rMn.put(vE.url, aVar2.rMO);
                            }
                            inflate.setTag(aVar2);
                            view2 = inflate;
                        }
                        aVar2.rGH = vE.rGH;
                        view = view2;
                        aVar = aVar2;
                    } else {
                        view = View.inflate(this.rMu, R.i.drb, null);
                        aVar2.rMN = (CdnImageView) view.findViewById(R.h.cQX);
                        aVar2.rMO = (TextView) view.findViewById(R.h.cQN);
                        aVar2.iuF = (TextView) view.findViewById(R.h.cQZ);
                        aVar2.rMP = (CheckBox) view.findViewById(R.h.bob);
                        if (!TextUtils.isEmpty(vE.url)) {
                            this.rMu.rMn.put(vE.url, aVar2.rMO);
                        }
                        view.setTag(aVar2);
                        aVar = aVar2;
                    }
                } else {
                    aVar = aVar3;
                }
            }
            if (vE != null) {
                b bVar = (b) this.rMu.rLx.get(vE.rGI);
                w.i("MicroMsg.WalletOrderInfoOldUI", "try get result " + bVar);
                if (bVar != null) {
                    aVar.rMN.L(bVar.fSl, 0, 0);
                    aVar.iuF.setText(bVar.fNG);
                    aVar.rMO.setText(bVar.rMe);
                } else {
                    aVar.rMN.L(vE.oqk, 0, 0);
                    aVar.iuF.setText(vE.name);
                    aVar.rMO.setText(vE.rGG);
                }
                if (bg.mA(vE.ogb)) {
                    aVar.rMO.setVisibility(0);
                    if (aVar.rMP != null) {
                        aVar.rMP.setVisibility(8);
                    }
                } else {
                    aVar.rMO.setVisibility(8);
                    if (aVar.rMP != null) {
                        aVar.rMP.setVisibility(0);
                        if (this.rMu.rLq.contains(vE.ogb)) {
                            aVar.rMP.setChecked(true);
                        } else {
                            aVar.rMP.setChecked(false);
                        }
                    }
                }
                if (aVar.ioX != null && bVar != null && !bg.mA(bVar.title)) {
                    aVar.ioX.setText(bVar.title);
                } else if (aVar.ioX != null && !bg.mA(vE.title)) {
                    aVar.ioX.setText(vE.title);
                } else if (aVar.ioX != null) {
                    aVar.ioX.setVisibility(8);
                }
                if (!(bg.mA(this.rMu.rLy) || aVar.rMO == null)) {
                    aVar.rMO.setClickable(this.rMu.fDR);
                    aVar.rMO.setEnabled(this.rMu.fDR);
                    aVar.rMO.setOnClickListener(null);
                    if (this.rMu.fDS) {
                        aVar.rMO.setVisibility(8);
                    }
                }
                dU = this.rMu.dU(vE.rGI);
                if (dU.equals("0")) {
                    aVar.rMO.setBackgroundColor(this.rMu.getResources().getColor(R.e.transparent));
                    aVar.rMO.setTextColor(this.rMu.getResources().getColor(R.e.aWu));
                } else if (dU.equals("-1") || dU.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                    aVar.rMO.setBackgroundDrawable(this.rMu.getResources().getDrawable(R.g.bdf));
                    aVar.rMO.setTextColor(this.rMu.getResources().getColor(R.e.aWu));
                } else if (dU.equals("4") || dU.equals("2") || dU.equals("1")) {
                    aVar.rMO.setBackgroundColor(this.rMu.getResources().getColor(R.e.transparent));
                    aVar.rMO.setTextColor(this.rMu.getResources().getColor(R.e.aUo));
                } else {
                    w.e("MicroMsg.WalletOrderInfoOldUI", "PromotionsAdapter unknow award state");
                }
            }
            if (aVar.rMO != null) {
                int a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.rMu.uSU.uTo, 15.0f);
                int a2 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.rMu.uSU.uTo, 5.0f);
                aVar.rMO.setPadding(a, a2, a, a2);
            }
            return view;
        }
    }

    class d {
        public String fLT;
        public String oQK;
        public String rCd;
        public long rHc;
        public String rMf;
        public String rMg;
        public String rMh;
        final /* synthetic */ WalletOrderInfoOldUI rMu;

        public d(WalletOrderInfoOldUI walletOrderInfoOldUI, String str, String str2, String str3, String str4, String str5, String str6, long j) {
            this.rMu = walletOrderInfoOldUI;
            this.rCd = str;
            this.rMf = str2;
            this.rMg = str3;
            this.rMh = str4;
            this.fLT = str5;
            this.oQK = str6;
            this.rHc = j;
        }
    }

    protected final int getLayoutId() {
        return R.i.cQJ;
    }

    public void Oe() {
        int i = 1;
        com.tencent.mm.wallet_core.b ai = com.tencent.mm.wallet_core.a.ai(this);
        this.rze = (PayInfo) this.uT.getParcelable("key_pay_info");
        this.ocu = this.uT.getString("key_trans_id");
        this.uT.getInt("key_pay_type", -1);
        w.i("MicroMsg.WalletOrderInfoOldUI", "mTransId %s", new Object[]{this.ocu});
        this.ryM = buY();
        if (this.ryM != null) {
            re(0);
            this.ryM = (Orders) this.uT.getParcelable("key_orders");
            c(this.ryM);
            if (!(ai == null || this.ryM == null || this.rze == null)) {
                boolean z;
                this.ivH = this.rze.appId;
                boolean cbS = ai.cbS();
                com.tencent.mm.plugin.wallet_core.d.c.b(this, this.uT, 7);
                int i2 = this.uT.getInt("key_support_bankcard", 1) == 2 ? 2 : 1;
                g gVar = g.oUh;
                Object[] objArr = new Object[7];
                objArr[0] = Integer.valueOf(this.rze.fRv);
                if (this.rze.fRv == 3) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[1] = Boolean.valueOf(z);
                if (!cbS) {
                    i = 2;
                }
                objArr[2] = Integer.valueOf(i);
                objArr[3] = Integer.valueOf(o.cch());
                objArr[4] = Integer.valueOf((int) (this.ryM.rFM * 100.0d));
                objArr[5] = this.ryM.oga;
                objArr[6] = Integer.valueOf(i2);
                gVar.i(10691, objArr);
            }
            if (!((com.tencent.mm.plugin.wallet_core.model.m.btS().bum() || ai == null || !ai.cbS()) && m.xU())) {
                m.xV();
            }
            if (this.ryM == null || this.ryM.rGe == null || this.ryM.rGe.size() <= 0) {
                w.j("MicroMsg.WalletOrderInfoOldUI", "mOrders info is Illegal!", new Object[0]);
                com.tencent.mm.ui.base.g.a(this.uSU.uTo, R.l.fgY, 0, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ WalletOrderInfoOldUI rMu;

                    {
                        this.rMu = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.rMu.done();
                    }
                });
            } else {
                this.rLr = this.ryM.rGe;
                this.ocu = ((Commodity) this.rLr.get(0)).fTA;
                if (!(this.rze == null || ai == null || (!ai.cbR() && !ai.cbS()))) {
                    buZ();
                }
            }
            if (this.ocu == null) {
                boolean booleanValue;
                ap.yY();
                Object obj = com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uBh, Boolean.valueOf(false));
                if (obj != null) {
                    booleanValue = ((Boolean) obj).booleanValue();
                } else {
                    booleanValue = false;
                }
                if (booleanValue) {
                    w.i("MicroMsg.WalletOrderInfoOldUI", "has show the finger print auth guide!");
                    return;
                }
                com.tencent.mm.wallet_core.b ai2 = com.tencent.mm.wallet_core.a.ai(this);
                Bundle bundle = new Bundle();
                if (ai2 != null) {
                    bundle = ai2.lHw;
                }
                if (TextUtils.isEmpty(bundle.getString("key_pwd1"))) {
                    w.i("MicroMsg.WalletOrderInfoOldUI", "pwd is empty, not show the finger print auth guide!");
                    return;
                }
                this.rMr = false;
                ai2.a((Activity) this, "fingerprint", ".ui.FingerPrintAuthTransparentUI", bundle);
                return;
            }
            return;
        }
        w.j("MicroMsg.WalletOrderInfoOldUI", "mOrders info is Illegal!", new Object[0]);
        com.tencent.mm.ui.base.g.a(this.uSU.uTo, R.l.fgY, 0, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ WalletOrderInfoOldUI rMu;

            {
                this.rMu = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.rMu.finish();
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        re(4);
        this.rLq = new HashSet();
        Oe();
        KC();
        hn(1979);
        com.tencent.mm.sdk.b.a.urY.b(this.rMb);
        com.tencent.mm.sdk.b.a.urY.b(this.oeu);
        this.rMr = false;
    }

    protected final boolean aXw() {
        return false;
    }

    protected final Orders buY() {
        return (Orders) this.uT.getParcelable("key_orders");
    }

    public void buZ() {
        k(new com.tencent.mm.plugin.wallet_core.b.m(bsF()));
    }

    public void Io(String str) {
        k(new n(str));
    }

    protected final void bX(String str, int i) {
        k(new n(str, i));
    }

    protected final void a(com.tencent.mm.plugin.wallet_core.model.Orders.b bVar) {
        q(new f(bVar, bsF(), this.ocu, bVar.rGQ));
    }

    public final void c(Orders orders) {
        this.rLq.clear();
        if (orders == null || orders.rGe == null) {
            w.w("MicroMsg.WalletOrderInfoOldUI", "hy: orders is null");
            return;
        }
        for (Commodity commodity : orders.rGe) {
            if (commodity.rFV == 2 && !bg.mA(commodity.rGt)) {
                w.d("MicroMsg.WalletOrderInfoOldUI", "hy: has username and is force recommend");
                this.rLq.add(commodity.rGt);
            }
        }
    }

    protected final void KC() {
        zi(R.l.fhy);
        bPS();
        kq(false);
        String string = getString(R.l.dHp);
        if (this.rze == null || this.rze.fRv != 2) {
            if (!(this.ryM == null || bg.mA(this.ryM.rGp))) {
                string = this.ryM.rGp;
            }
        } else if (!bg.mA(this.rze.rPJ)) {
            string = getString(R.l.dDn) + this.rze.rPJ;
        } else if (!(bg.mA(this.rze.appId) || bg.mA(com.tencent.mm.pluginsdk.model.app.g.m(this, this.rze.appId)))) {
            string = getString(R.l.dDn) + com.tencent.mm.pluginsdk.model.app.g.m(this, this.rze.appId);
        }
        a(0, string, new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletOrderInfoOldUI rMu;

            {
                this.rMu = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.rMu.done();
                return true;
            }
        });
        this.rMi = (LinearLayout) findViewById(R.h.cRe);
        this.rMj = (TextView) findViewById(R.h.cRd);
        this.rMk = (TextView) findViewById(R.h.cQW);
        MaxListView maxListView = (MaxListView) findViewById(R.h.cQJ);
        this.rMl = new a(this);
        maxListView.setAdapter(this.rMl);
        bva();
        bvb();
        ((ScrollView) findViewById(R.h.cRI)).pageScroll(33);
    }

    public final void bva() {
        if (this.ryM != null) {
            int i;
            this.rLr = this.ryM.rGe;
            for (Commodity commodity : this.rLr) {
                if ("1".equals(commodity.ofT)) {
                    i = 0;
                    break;
                }
            }
            i = 1;
            this.rMi.setVisibility(0);
            this.rMj.setVisibility(0);
            if (i == 0) {
                this.rMj.setText(R.l.fho);
            } else if (!bg.mA(this.ryM.rFX) && !bg.mA(this.ryM.rFX.trim())) {
                this.rMj.setText(this.ryM.rFX);
            } else if (this.ryM.rBY != 1) {
                this.rMj.setText(R.l.fhn);
            } else {
                this.rMj.setText(R.l.fhm);
            }
        }
    }

    protected final void a(String str, d dVar) {
        buX();
        this.rMq = dVar;
        e.n(this, str, 1);
        this.rMr = false;
    }

    protected final void In(String str) {
        buX();
        e.m(this, str, false);
        this.rMr = false;
    }

    public final void buX() {
        int i = 0;
        if (!this.rLp) {
            com.tencent.mm.sdk.b.b ibVar = new ib();
            ibVar.fNE.fFR = 4;
            com.tencent.mm.e.a.ib.a aVar = ibVar.fNE;
            if (this.uT.getBoolean("intent_pay_end", false)) {
                i = -1;
            }
            aVar.aMA = i;
            com.tencent.mm.sdk.b.a.urY.m(ibVar);
            this.rLp = true;
        }
    }

    public final void K(x xVar) {
        if (xVar != null && ((int) xVar.gTQ) != 0) {
            String tK = xVar.tK();
            w.d("MicroMsg.WalletOrderInfoOldUI", "call back from contactServer nickName " + tK + " username: " + xVar.field_username);
            if (this.rLr != null && this.rLr.size() > 0) {
                for (Commodity commodity : this.rLr) {
                    commodity.ogb = tK;
                }
                this.rMl.notifyDataSetChanged();
            }
            this.jia = xVar.field_username;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.urY.c(this.rMb);
        com.tencent.mm.sdk.b.a.urY.c(this.oeu);
        ho(1979);
    }

    public void done() {
        com.tencent.mm.plugin.wallet_core.model.x.a(this.rze, this.ryM);
        if (this.uT.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) this.uT.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.WalletOrderInfoOldUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet_core");
                boolean a = realnameGuideHelper.a(this, bundle, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ WalletOrderInfoOldUI rMu;

                    {
                        this.rMu = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.rMu.buW();
                    }
                });
                this.uT.remove("key_realname_guide_helper");
                if (!a) {
                    buW();
                    return;
                }
                return;
            }
            return;
        }
        buW();
    }

    public final void buW() {
        buX();
        this.rMr = false;
        com.tencent.mm.sdk.b.b alVar = new al();
        alVar.fDM.fDN = true;
        com.tencent.mm.sdk.b.a.urY.m(alVar);
        Bundle bundle = new Bundle();
        bundle.putInt("intent_pay_end_errcode", this.uT.getInt("intent_pay_end_errcode"));
        bundle.putString("intent_pay_app_url", this.uT.getString("intent_pay_app_url"));
        bundle.putBoolean("intent_pay_end", this.uT.getBoolean("intent_pay_end"));
        w.i("MicroMsg.WalletOrderInfoOldUI", "pay done...feedbackData errCode:" + this.uT.getInt("intent_pay_end_errcode"));
        for (String str : this.rLq) {
            if (!bg.mA(str)) {
                w.i("MicroMsg.WalletOrderInfoOldUI", "hy: doing netscene subscribe...appName: %s", new Object[]{str});
                if (this.ryM == null || this.rze == null) {
                    ap.vd().a(new h(str), 0);
                } else {
                    ap.vd().a(new h(str, this.ryM.fJH, this.ryM.rGe.size() > 0 ? ((Commodity) this.ryM.rGe.get(0)).fTA : "", this.rze.fRv, this.rze.fRr, this.ryM.rFV), 0);
                }
            }
            g.oUh.i(13033, new Object[]{Integer.valueOf(2), str, "", "", ""});
        }
        com.tencent.mm.wallet_core.a.k(this, bundle);
        if (this.ryM != null && !bg.mA(this.ryM.lfx)) {
            String d = WalletOrderInfoUI.d(this.ryM.lfx, this.ryM.fJH, this.ryM.rGe.size() > 0 ? ((Commodity) this.ryM.rGe.get(0)).fTA : "", this.rze.kdW, this.rze.iBi);
            w.d("MicroMsg.WalletOrderInfoOldUI", "url = " + d);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", d);
            intent.putExtra("showShare", false);
            intent.putExtra("geta8key_username", m.xL());
            intent.putExtra("stastic_scene", 8);
            com.tencent.mm.bb.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        done();
        return true;
    }

    @Deprecated
    protected Dialog onCreateDialog(int i) {
        return com.tencent.mm.ui.base.g.a(this.uSU.uTo, getString(R.l.fhk), getResources().getStringArray(R.c.aSt), "", new com.tencent.mm.ui.base.g.c(this) {
            final /* synthetic */ WalletOrderInfoOldUI rMu;

            {
                this.rMu = r1;
            }

            public final void hq(int i) {
                switch (i) {
                    case 0:
                        this.rMu.rMr = false;
                        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(this.rMu.ohs).toString()));
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        this.rMu.startActivity(intent);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    public void onResume() {
        super.onResume();
        w.i("MicroMsg.WalletOrderInfoOldUI", "onResume, isClickActivityTinyApp: %s", new Object[]{Boolean.valueOf(this.rMr)});
        if (this.rMr) {
            k(new com.tencent.mm.plugin.wallet_core.b.o(this.rMq.rCd, this.rMq.rMf, this.rMq.rMg, this.rMq.rMh, this.rMq.fLT, this.rMq.oQK, this.rMq.rHc));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        w.i("MicroMsg.WalletOrderInfoOldUI", "onActivityResult %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 1) {
            k(new com.tencent.mm.plugin.wallet_core.b.o(this.rMq.rCd, this.rMq.rMf, this.rMq.rMg, this.rMq.rMh, this.rMq.fLT, this.rMq.oQK, this.rMq.rHc));
        }
    }

    private void bvb() {
        if (this.ryM == null || this.ryM.rGe == null || this.ryM.rGe.size() <= 0 || ((Commodity) this.ryM.rGe.get(0)).rGB == null || bg.mA(((Commodity) this.ryM.rGe.get(0)).rGB.text) || bg.mA(((Commodity) this.ryM.rGe.get(0)).rGB.url)) {
            w.i("MicroMsg.WalletOrderInfoOldUI", "hy: no commodity or no link act or link act is illegal!");
            this.rMk.setVisibility(8);
            return;
        }
        this.rMk.setVisibility(0);
        this.rMk.setText(((Commodity) this.ryM.rGe.get(0)).rGB.text);
        this.rMk.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletOrderInfoOldUI rMu;

            {
                this.rMu = r1;
            }

            public final void onClick(View view) {
                e.m(this.rMu, ((Commodity) this.rMu.ryM.rGe.get(0)).rGB.url, false);
            }
        });
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if ((kVar instanceof com.tencent.mm.plugin.wallet_core.b.o) && i == 0 && i2 == 0) {
            com.tencent.mm.plugin.wallet_core.b.o oVar = (com.tencent.mm.plugin.wallet_core.b.o) kVar;
            b bVar = new b(this, oVar.nBw);
            boolean z = (bg.mA(bVar.url) || bg.mA(bVar.fNG)) ? false : true;
            if (z) {
                this.rLx.put(oVar.rCd, bVar);
            }
            this.rMl.notifyDataSetChanged();
        }
        if (kVar instanceof n) {
            if (i == 0 && i2 == 0) {
                re(0);
                this.ryM = ((n) kVar).rCc;
                if (this.ryM != null) {
                    this.rLr = this.ryM.rGe;
                }
                c(this.ryM);
                w.d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + this.rLr);
                if (!(this.rLr == null || this.rLr.size() == 0)) {
                    Commodity commodity = (Commodity) this.rLr.get(0);
                    this.ocu = commodity.fTA;
                    w.d("MicroMsg.WalletOrderInfoOldUI", "Coomdity:" + commodity.toString());
                    ap.yY();
                    com.tencent.mm.j.a Rc = com.tencent.mm.u.c.wR().Rc(commodity.ogb);
                    if (Rc == null || ((int) Rc.gTQ) == 0) {
                        com.tencent.mm.u.ag.a.hlS.a(commodity.ogb, "", this.rMs);
                    } else {
                        K(Rc);
                    }
                    this.rMl.notifyDataSetChanged();
                    bva();
                }
            }
            if (this.rMl != null) {
                this.rMl.notifyDataSetChanged();
            }
            bvb();
            return true;
        }
        if (kVar instanceof f) {
            if (i == 0 && i2 == 0) {
                f fVar = (f) kVar;
                String str2 = fVar.rBO;
                this.rMp.put(Long.valueOf(fVar.rBN.rGI), str2);
                fVar.rBN.rGG = fVar.ksO;
                if (!"-1".equals(str2) && !"0".equals(str2) && !bg.mA(fVar.rBP)) {
                    com.tencent.mm.ui.base.g.b(this, fVar.rBP, "", true);
                } else if ("0".equals(str2)) {
                    CharSequence string;
                    if (bg.mA(fVar.rBP)) {
                        string = getString(R.l.fid);
                    } else {
                        string = fVar.rBP;
                    }
                    Toast.makeText(this, string, 0).show();
                }
                this.rMl.notifyDataSetChanged();
                return true;
            } else if (kVar instanceof f) {
                if (bg.mA(str)) {
                    str = getString(R.l.fkA);
                }
                com.tencent.mm.ui.base.g.a(this, str, null, false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ WalletOrderInfoOldUI rMu;

                    {
                        this.rMu = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            }
        }
        return false;
    }

    public final String dU(long j) {
        if (this.rMp.containsKey(Long.valueOf(j))) {
            return (String) this.rMp.get(Long.valueOf(j));
        }
        return "-1";
    }
}
