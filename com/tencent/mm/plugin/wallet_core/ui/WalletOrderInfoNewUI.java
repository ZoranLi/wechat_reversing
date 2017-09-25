package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.e.a.al;
import com.tencent.mm.e.a.am;
import com.tencent.mm.e.a.ib;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.e.a.rw;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.b.f;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DiscountInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.wallet_core.c.h;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class WalletOrderInfoNewUI extends WalletOrderInfoUI {
    private String ivH = "";
    private String jia = null;
    private TextView oSM;
    private String oSc;
    private String ocu;
    private c oeu = new c<rw>(this) {
        final /* synthetic */ WalletOrderInfoNewUI rMc;

        {
            this.rMc = r2;
            this.usg = rw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            rw rwVar = (rw) bVar;
            if (!(rwVar instanceof rw)) {
                return false;
            }
            if (!rwVar.fZo.fZp.ods) {
                w.i("MicroMsg.WalletOrderInfoNewUI", "block pass");
                return true;
            } else if (!"1".equals(rwVar.fZo.fZp.fZb) && !"2".equals(rwVar.fZo.fZp.fZb)) {
                return false;
            } else {
                Parcelable realnameGuideHelper = new RealnameGuideHelper();
                realnameGuideHelper.a(rwVar.fZo.fZp.fZb, rwVar.fZo.fZp.fZc, rwVar.fZo.fZp.fZd, rwVar.fZo.fZp.fZe, rwVar.fZo.fZp.fZf, this.rMc.rze == null ? 0 : this.rMc.rze.fRv);
                w.i("MicroMsg.WalletOrderInfoNewUI", "receive guide");
                this.rMc.uT.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                return false;
            }
        }
    };
    private String ohs = null;
    private String rLA = "-1";
    private TextView rLB;
    private TextView rLC;
    private WalletTextView rLD;
    private TextView rLE;
    private Button rLF;
    private ImageView rLG;
    private ViewGroup rLH;
    private ViewGroup rLI;
    private ViewGroup rLJ;
    private CdnImageView rLK;
    private TextView rLL;
    private TextView rLM;
    private View rLN;
    private Button rLO;
    private ViewGroup rLP;
    private TextView rLQ;
    private CheckBox rLR;
    private ViewGroup rLS;
    private CdnImageView rLT;
    private TextView rLU;
    private TextView rLV;
    private Button rLW;
    private ViewGroup rLX;
    private boolean rLY = false;
    private boolean rLZ = false;
    private boolean rLp = false;
    private Set<String> rLq = null;
    private List<Commodity> rLr = null;
    private String rLs;
    private String rLt;
    private RecommendTinyAppInfo rLu;
    private String rLv;
    private b rLw;
    private HashMap<String, a> rLx = new HashMap();
    private String rLy;
    private com.tencent.mm.plugin.wallet_core.model.Orders.b rLz = null;
    private boolean rMa = false;
    private c rMb = new c<am>(this) {
        final /* synthetic */ WalletOrderInfoNewUI rMc;

        {
            this.rMc = r2;
            this.usg = am.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            am amVar = (am) bVar;
            String str = amVar.fDO.fDQ;
            boolean z = amVar.fDO.fDR;
            w.i("MicroMsg.WalletOrderInfoNewUI", "ChangePayActivityViewEvent callback, mActivityBtnTitle: %s, isButtonEnable: %s, isButtonHidden: %s, isActivityViewHidden: %s", new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(amVar.fDO.fDS), Boolean.valueOf(amVar.fDO.fDT)});
            if (amVar.fDO.fDT && !bg.mA(this.rMc.rLy)) {
                this.rMc.rLS.setVisibility(8);
            }
            if (!bg.mA(this.rMc.rLy)) {
                this.rMc.rLW.setClickable(z);
                this.rMc.rLW.setEnabled(z);
                this.rMc.rLW.setOnClickListener(null);
                if (r2) {
                    this.rMc.rLW.setVisibility(8);
                }
            }
            amVar.fDP.fDU = true;
            return false;
        }
    };
    private Orders ryM;
    private PayInfo rze;

    class a {
        public String fNG;
        public String fSl;
        public String rGR;
        public String rGS;
        public String rGT;
        public String rGU;
        public String rGV;
        public String rGW;
        final /* synthetic */ WalletOrderInfoNewUI rMc;
        public String rMe;
        public String title;
        public String url;

        public a(WalletOrderInfoNewUI walletOrderInfoNewUI, JSONObject jSONObject) {
            this.rMc = walletOrderInfoNewUI;
            if (jSONObject != null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("activity_change_info");
                if (optJSONObject != null) {
                    this.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    this.fNG = optJSONObject.optString("wording");
                    this.fSl = optJSONObject.optString("icon");
                    this.rMe = optJSONObject.optString("btn_text");
                    this.title = optJSONObject.optString("title");
                    this.rGR = optJSONObject.optString("tinyapp_name");
                    this.rGS = optJSONObject.optString("tinyapp_logo");
                    this.rGT = optJSONObject.optString("tinyapp_desc");
                    this.rGU = optJSONObject.optString("tinyapp_username");
                    this.rGV = optJSONObject.optString("tinyapp_path");
                    this.rGW = optJSONObject.optString("activity_tinyapp_btn_text");
                }
            }
        }

        public final String toString() {
            return this.url + " , " + this.fNG + " , " + this.fSl + " , " + this.rMe + " , " + this.title;
        }
    }

    class b {
        public String fLT;
        public String oQK;
        public String rCd;
        public long rHc;
        final /* synthetic */ WalletOrderInfoNewUI rMc;
        public String rMf;
        public String rMg;
        public String rMh;

        public b(WalletOrderInfoNewUI walletOrderInfoNewUI, String str, String str2, String str3, String str4, String str5, String str6, long j) {
            this.rMc = walletOrderInfoNewUI;
            this.rCd = str;
            this.rMf = str2;
            this.rMg = str3;
            this.rMh = str4;
            this.fLT = str5;
            this.oQK = str6;
            this.rHc = j;
        }
    }

    static /* synthetic */ void p(WalletOrderInfoNewUI walletOrderInfoNewUI) {
        String str = "MicroMsg.WalletOrderInfoNewUI";
        String str2 = "onClickActivity, activityId: %s";
        Object[] objArr = new Object[1];
        objArr[0] = Long.valueOf(walletOrderInfoNewUI.rLz != null ? walletOrderInfoNewUI.rLz.rGI : 0);
        w.i(str, str2, objArr);
        if (walletOrderInfoNewUI.rLz != null && walletOrderInfoNewUI.rLz.rGI > 0) {
            walletOrderInfoNewUI.rLZ = true;
            if (walletOrderInfoNewUI.rLA.equals("-1") || walletOrderInfoNewUI.rLA.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                g.oUh.i(13472, new Object[]{walletOrderInfoNewUI.oSc, Integer.valueOf(walletOrderInfoNewUI.rLz.rGJ), Integer.valueOf(1), Long.valueOf(walletOrderInfoNewUI.rLz.rGI), Long.valueOf(walletOrderInfoNewUI.rLz.rGQ)});
                g.oUh.i(13033, new Object[]{Integer.valueOf(2), "", walletOrderInfoNewUI.rLz.url, walletOrderInfoNewUI.rLz.name, ""});
                if (!bg.mA(walletOrderInfoNewUI.rLz.rGO) && !bg.mA(walletOrderInfoNewUI.rLz.rGP)) {
                    w.i("MicroMsg.WalletOrderInfoNewUI", "promotion jump tiny app, username: %s, path: %s", new Object[]{walletOrderInfoNewUI.rLz.rGO, walletOrderInfoNewUI.rLz.rGP});
                    com.tencent.mm.sdk.b.b prVar = new pr();
                    prVar.fWB.userName = walletOrderInfoNewUI.rLz.rGO;
                    prVar.fWB.fWD = bg.ap(walletOrderInfoNewUI.rLz.rGP, "");
                    prVar.fWB.scene = 1060;
                    prVar.fWB.fCN = walletOrderInfoNewUI.ocu;
                    prVar.fWB.fWE = 0;
                    com.tencent.mm.sdk.b.a.urY.m(prVar);
                    g.oUh.i(14118, new Object[]{walletOrderInfoNewUI.ocu, walletOrderInfoNewUI.bsF(), Integer.valueOf(2)});
                } else if (walletOrderInfoNewUI.rLz.rGJ == 1) {
                    com.tencent.mm.plugin.wallet_core.model.Orders.b bVar = walletOrderInfoNewUI.rLz;
                    walletOrderInfoNewUI.q(new f(bVar, walletOrderInfoNewUI.bsF(), walletOrderInfoNewUI.ocu, bVar.rGQ));
                } else if (walletOrderInfoNewUI.rLz.rGJ != 2 || bg.mA(walletOrderInfoNewUI.rLz.url)) {
                    w.e("MicroMsg.WalletOrderInfoNewUI", "promotion's activityActionType != ACTION_TYPE_NORMAL and url is null,unknow option");
                } else if (walletOrderInfoNewUI.rLx.containsKey(walletOrderInfoNewUI.rLz.rGI)) {
                    a aVar = (a) walletOrderInfoNewUI.rLx.get(walletOrderInfoNewUI.rLz.rGI);
                    w.i("MicroMsg.WalletOrderInfoNewUI", "go to new url %s", new Object[]{aVar.url});
                    if (bg.mA(aVar.url)) {
                        walletOrderInfoNewUI.In(walletOrderInfoNewUI.rLz.url);
                    } else {
                        walletOrderInfoNewUI.In(aVar.url);
                    }
                } else {
                    walletOrderInfoNewUI.rLy = walletOrderInfoNewUI.rLz.url;
                    String str3 = walletOrderInfoNewUI.rLz.url;
                    b bVar2 = new b(walletOrderInfoNewUI, walletOrderInfoNewUI.rLz.rGI, walletOrderInfoNewUI.rLz.rGK, walletOrderInfoNewUI.rLz.rGL, walletOrderInfoNewUI.rLz.rGM, walletOrderInfoNewUI.bsF(), walletOrderInfoNewUI.oSc, walletOrderInfoNewUI.rLz.rGQ);
                    walletOrderInfoNewUI.buX();
                    walletOrderInfoNewUI.rLw = bVar2;
                    e.n(walletOrderInfoNewUI, str3, 1);
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        if (d.eo(21)) {
            if (d.eo(23)) {
                getWindow().setStatusBarColor(-1);
                getWindow().getDecorView().setSystemUiVisibility(8192);
            } else {
                getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
            }
        }
        re(4);
        this.rLq = new HashSet();
        com.tencent.mm.wallet_core.b ai = com.tencent.mm.wallet_core.a.ai(this);
        this.rze = (PayInfo) this.uT.getParcelable("key_pay_info");
        this.ocu = this.uT.getString("key_trans_id");
        this.uT.getInt("key_pay_type", -1);
        w.i("MicroMsg.WalletOrderInfoNewUI", "mTransId %s", new Object[]{this.ocu});
        this.ryM = buY();
        if (this.ryM != null) {
            re(0);
            this.ryM = (Orders) this.uT.getParcelable("key_orders");
            b(this.ryM);
            if (!(ai == null || this.ryM == null || this.rze == null)) {
                int i;
                this.ivH = this.rze.appId;
                boolean cbS = ai.cbS();
                com.tencent.mm.plugin.wallet_core.d.c.b(this, this.uT, 7);
                if (this.uT.getInt("key_support_bankcard", 1) == 2) {
                    i = 2;
                } else {
                    i = 1;
                }
                g gVar = g.oUh;
                Object[] objArr = new Object[7];
                objArr[0] = Integer.valueOf(this.rze.fRv);
                objArr[1] = Boolean.valueOf(this.rze.fRv == 3);
                objArr[2] = Integer.valueOf(cbS ? 1 : 2);
                objArr[3] = Integer.valueOf(o.cch());
                objArr[4] = Integer.valueOf((int) (this.ryM.rFM * 100.0d));
                objArr[5] = this.ryM.oga;
                objArr[6] = Integer.valueOf(i);
                gVar.i(10691, objArr);
            }
            if (!((m.btS().bum() || ai == null || !ai.cbS()) && com.tencent.mm.u.m.xU())) {
                com.tencent.mm.u.m.xV();
            }
            if (this.ryM == null || this.ryM.rGe == null || this.ryM.rGe.size() <= 0) {
                w.j("MicroMsg.WalletOrderInfoNewUI", "mOrders info is Illegal!", new Object[0]);
                com.tencent.mm.ui.base.g.a(this.uSU.uTo, R.l.fgY, 0, new OnClickListener(this) {
                    final /* synthetic */ WalletOrderInfoNewUI rMc;

                    {
                        this.rMc = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.rMc.done();
                    }
                });
            } else {
                this.rLr = this.ryM.rGe;
                w.i("MicroMsg.WalletOrderInfoNewUI", "init data commoditys size: %s", new Object[]{Integer.valueOf(this.rLr.size())});
                this.ocu = ((Commodity) this.rLr.get(0)).fTA;
                this.oSc = ((Commodity) this.rLr.get(0)).fTA;
                if (!(this.rze == null || ai == null || (!ai.cbR() && !ai.cbS()))) {
                    k(new com.tencent.mm.plugin.wallet_core.b.m(bsF()));
                }
            }
            if (this.ocu == null) {
                ap.yY();
                Object obj = com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uBh, Boolean.valueOf(false));
                if (obj != null) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (z) {
                    w.i("MicroMsg.WalletOrderInfoNewUI", "has show the finger print auth guide!");
                } else {
                    com.tencent.mm.wallet_core.b ai2 = com.tencent.mm.wallet_core.a.ai(this);
                    Bundle bundle2 = new Bundle();
                    if (ai2 != null) {
                        bundle2 = ai2.lHw;
                    }
                    if (TextUtils.isEmpty(bundle2.getString("key_pwd1"))) {
                        w.i("MicroMsg.WalletOrderInfoNewUI", "pwd is empty, not show the finger print auth guide!");
                    } else {
                        ai2.a((Activity) this, "fingerprint", ".ui.FingerPrintAuthTransparentUI", bundle2);
                    }
                }
            }
        } else {
            w.j("MicroMsg.WalletOrderInfoNewUI", "mOrders info is Illegal!", new Object[0]);
            com.tencent.mm.ui.base.g.a(this.uSU.uTo, R.l.fgY, 0, new OnClickListener(this) {
                final /* synthetic */ WalletOrderInfoNewUI rMc;

                {
                    this.rMc = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.rMc.finish();
                }
            });
        }
        KC();
        buT();
        hn(1979);
        com.tencent.mm.sdk.b.a.urY.b(this.rMb);
        com.tencent.mm.sdk.b.a.urY.b(this.oeu);
        this.rMa = true;
    }

    public void onResume() {
        super.onResume();
        w.i("MicroMsg.WalletOrderInfoNewUI", "onResume, isFirstInit: %s activityPromotions: %s, isClickTinyappActivity: %s, isClickActivity: %s, recommendTinyAppInfo: %s", new Object[]{Boolean.valueOf(this.rMa), this.rLz, Boolean.valueOf(this.rLY), Boolean.valueOf(this.rLZ), this.rLu});
        if (this.rMa) {
            this.rMa = false;
        } else if (this.rLz != null && this.rLZ) {
            k(new com.tencent.mm.plugin.wallet_core.b.o(this.rLz.rGI, this.rLz.rGK, this.rLz.rGL, this.rLz.rGM, bsF(), this.oSc, this.rLz.rGQ));
        } else if (this.rLY && this.rLu != null) {
            k(new com.tencent.mm.plugin.wallet_core.b.o(this.rLu.rGX, this.rLu.rGZ, this.rLu.rHa, this.rLu.rHb, bsF(), this.oSc, this.rLu.rHc));
        }
    }

    protected final void KC() {
        if (cO().cP() != null) {
            cO().cP().hide();
        }
        this.rLG = (ImageView) findViewById(R.h.cTn);
        this.oSM = (TextView) findViewById(R.h.cqO);
        this.rLB = (TextView) findViewById(R.h.buR);
        this.rLC = (TextView) findViewById(R.h.bPq);
        this.rLD = (WalletTextView) findViewById(R.h.cJv);
        this.rLE = (TextView) findViewById(R.h.cqo);
        this.rLF = (Button) findViewById(R.h.cqL);
        bPS();
        kq(false);
        CharSequence string = getString(R.l.dHp);
        if (this.rze == null || this.rze.fRv != 2) {
            if (!(this.ryM == null || bg.mA(this.ryM.rGp))) {
                string = this.ryM.rGp;
            }
        } else if (!bg.mA(this.rze.rPJ)) {
            string = getString(R.l.dDn) + this.rze.rPJ;
        } else if (!(bg.mA(this.rze.appId) || bg.mA(com.tencent.mm.pluginsdk.model.app.g.m(this, this.rze.appId)))) {
            string = getString(R.l.dDn) + com.tencent.mm.pluginsdk.model.app.g.m(this, this.rze.appId);
        }
        this.rLF.setText(string);
        this.rLF.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ WalletOrderInfoNewUI rMc;

            {
                this.rMc = r1;
            }

            public final void onClick(View view) {
                this.rMc.done();
            }
        });
        this.rLH = (ViewGroup) findViewById(R.h.bJz);
        this.rLI = (ViewGroup) findViewById(R.h.bJy);
        this.rLX = (ViewGroup) findViewById(R.h.cQM);
        this.rLJ = (ViewGroup) findViewById(R.h.cIv);
        this.rLK = (CdnImageView) findViewById(R.h.cIx);
        this.rLL = (TextView) findViewById(R.h.cIu);
        this.rLM = (TextView) findViewById(R.h.cIz);
        this.rLO = (Button) findViewById(R.h.cIs);
        this.rLN = findViewById(R.h.cIw);
        this.rLP = (ViewGroup) findViewById(R.h.cGI);
        this.rLQ = (TextView) findViewById(R.h.btL);
        this.rLR = (CheckBox) findViewById(R.h.cGH);
        this.rLS = (ViewGroup) findViewById(R.h.bnk);
        this.rLT = (CdnImageView) findViewById(R.h.bnl);
        this.rLV = (TextView) findViewById(R.h.bnm);
        this.rLU = (TextView) findViewById(R.h.bnj);
        this.rLW = (Button) findViewById(R.h.bni);
        this.rLX.setVisibility(4);
        buT();
        if (!(this.ryM == null || this.rLr == null || this.rLr.size() <= 0)) {
            Commodity commodity = (Commodity) this.rLr.get(0);
            this.rLB.setText(commodity.ofP);
            this.rLC.setText(e.UG(commodity.oga));
            this.rLD.setText(String.format("%.2f", new Object[]{Double.valueOf(commodity.kBc)}));
        }
        buU();
        buV();
        iF(true);
        buS();
    }

    private void buS() {
        int i;
        int i2 = 0;
        if (this.rLJ.getVisibility() == 0) {
            i2 = 1;
        }
        if (this.rLH.getVisibility() == 0) {
            i2++;
        }
        if (this.rLP.getVisibility() == 0) {
            i2++;
        }
        if (this.rLS.getVisibility() == 0) {
            i = i2 + 1;
        } else {
            i = i2;
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.rLG.getLayoutParams();
        MarginLayoutParams marginLayoutParams2 = (MarginLayoutParams) this.rLB.getLayoutParams();
        if (i >= 3) {
            i = com.tencent.mm.bg.a.fromDPToPix(this, 40);
            marginLayoutParams.topMargin = i;
            marginLayoutParams2.topMargin = i;
        } else {
            i = com.tencent.mm.bg.a.fromDPToPix(this, 70);
            marginLayoutParams.topMargin = i;
            marginLayoutParams2.topMargin = i;
        }
        this.rLG.setLayoutParams(marginLayoutParams);
        this.rLB.setLayoutParams(marginLayoutParams2);
        this.rLX.post(new Runnable(this) {
            final /* synthetic */ WalletOrderInfoNewUI rMc;

            {
                this.rMc = r1;
            }

            public final void run() {
                int i;
                int height = this.rMc.rLX.getHeight();
                int height2 = this.rMc.findViewById(R.h.czr).getHeight();
                int i2 = this.rMc.rLJ.getVisibility() == 0 ? 1 : 0;
                if (this.rMc.rLH.getVisibility() == 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i2 != 0 && i != 0) {
                    i2 = this.rMc.rLJ.getBottom();
                } else if (i != 0) {
                    i2 = this.rMc.rLH.getBottom();
                } else if (i2 != 0) {
                    i2 = this.rMc.rLJ.getBottom();
                } else {
                    i2 = this.rMc.findViewById(R.h.cqN).getBottom();
                }
                if (!(this.rMc.rLP.getVisibility() == 0 || this.rMc.rLS.getVisibility() == 0)) {
                    height += com.tencent.mm.bg.a.fromDPToPix(this.rMc, 70);
                }
                i = (height2 - i2) - height;
                int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(this.rMc, 50);
                w.i("MicroMsg.WalletOrderInfoNewUI", "autoAdjustLayout inner, height: %s, topViewPos: %s, contentHeight: %s, topMargin: %s, 50dp: %s", new Object[]{Integer.valueOf(height), Integer.valueOf(i2), Integer.valueOf(height2), Integer.valueOf(i), Integer.valueOf(fromDPToPix)});
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.rMc.rLX.getLayoutParams();
                if (i > fromDPToPix) {
                    marginLayoutParams.topMargin = i;
                } else {
                    marginLayoutParams.topMargin = fromDPToPix;
                }
                this.rMc.rLX.setLayoutParams(marginLayoutParams);
                this.rMc.rLX.setVisibility(0);
            }
        });
    }

    private void buT() {
        if (this.ryM != null && this.rLr != null && this.rLr.size() > 0) {
            int i;
            for (Commodity commodity : this.rLr) {
                if ("1".equals(commodity.ofT)) {
                    i = 0;
                    break;
                }
            }
            i = 1;
            this.oSM.setVisibility(0);
            if (i == 0) {
                this.oSM.setText(R.l.fho);
            } else if (!bg.mA(this.ryM.rFX) && !bg.mA(this.ryM.rFX.trim())) {
                this.oSM.setText(this.ryM.rFX);
            } else if (this.ryM.rBY != 1) {
                this.oSM.setText(R.l.fhn);
            } else {
                this.oSM.setText(R.l.fhm);
            }
        }
    }

    private void buU() {
        this.rLH.setVisibility(8);
        if (this.ryM != null && this.rLr != null && this.rLr.size() > 0) {
            int size;
            Commodity commodity = (Commodity) this.rLr.get(0);
            List list = commodity.rGv;
            String str = "MicroMsg.WalletOrderInfoNewUI";
            String str2 = "discountInfoList: %s, size: %s";
            Object[] objArr = new Object[2];
            objArr[0] = list;
            if (list != null) {
                size = list.size();
            } else {
                size = 0;
            }
            objArr[1] = Integer.valueOf(size);
            w.i(str, str2, objArr);
            if (list != null && list.size() > 0) {
                this.rLI.removeAllViews();
                for (int i = 0; i < list.size(); i++) {
                    DiscountInfo discountInfo = (DiscountInfo) list.get(i);
                    View textView = new TextView(this.uSU.uTo);
                    textView.setLayoutParams(new LayoutParams(-2, -2));
                    textView.setTextSize(1, 12.0f);
                    textView.setTextColor(Color.parseColor("#FA962A"));
                    textView.setText(discountInfo.rxH + e.d(discountInfo.rGF / 100.0d, this.ryM.oga));
                    this.rLI.addView(textView);
                }
                this.rLH.setVisibility(0);
            }
            if (commodity.rGs >= 0.0d && commodity.kBc < commodity.rGs) {
                this.rLE.setText(e.d(commodity.rGs, commodity.oga));
                this.rLE.getPaint().setFlags(16);
                this.rLH.setVisibility(0);
            }
        }
    }

    private void buV() {
        this.rLP.setVisibility(8);
        if (this.ryM != null) {
            b(this.ryM);
            if (this.rLr != null && this.rLr.size() > 0) {
                Commodity commodity = (Commodity) this.rLr.get(0);
                w.i("MicroMsg.WalletOrderInfoNewUI", "setSubscribeBizInfo, hasSubscribeBiz: %s", new Object[]{Boolean.valueOf(commodity.rGA)});
                if (commodity.rGA && commodity.rGz != null && commodity.rGz.size() > 0) {
                    for (com.tencent.mm.plugin.wallet_core.model.Orders.b bVar : commodity.rGz) {
                        if (bVar.type == Orders.rGq) {
                            break;
                        }
                    }
                    com.tencent.mm.plugin.wallet_core.model.Orders.b bVar2 = null;
                    w.i("MicroMsg.WalletOrderInfoNewUI", "subscribePromotions: %s", new Object[]{bVar2});
                    if (bVar2 != null && !bg.mA(bVar2.ogb)) {
                        this.oSc = commodity.fTA;
                        g.oUh.i(13033, new Object[]{Integer.valueOf(1), bVar2.ogb, bVar2.url, bVar2.name, this.oSc});
                        this.rLQ.setText(bVar2.name);
                        this.rLv = bVar2.ogb;
                        this.rLR.setVisibility(0);
                        if (this.rLq.contains(bVar2.ogb)) {
                            this.rLR.setChecked(true);
                        } else {
                            this.rLR.setChecked(false);
                        }
                        this.rLP.setOnClickListener(new View.OnClickListener(this) {
                            final /* synthetic */ WalletOrderInfoNewUI rMc;

                            {
                                this.rMc = r1;
                            }

                            public final void onClick(View view) {
                                if (!bg.mA(this.rMc.rLv)) {
                                    if (this.rMc.rLq.contains(this.rMc.rLv)) {
                                        this.rMc.rLq.remove(this.rMc.rLv);
                                        this.rMc.rLR.setChecked(false);
                                        return;
                                    }
                                    this.rMc.rLq.add(this.rMc.rLv);
                                    this.rMc.rLR.setChecked(true);
                                }
                            }
                        });
                        this.rLP.setVisibility(0);
                    }
                }
            }
        }
    }

    private void iF(boolean z) {
        this.rLJ.setVisibility(8);
        this.rLZ = false;
        this.rLY = false;
        if (this.ryM != null) {
            if (this.rLr != null && this.rLr.size() > 0) {
                final Commodity commodity = (Commodity) this.rLr.get(0);
                if (commodity != null) {
                    com.tencent.mm.plugin.wallet_core.model.Orders.b bVar;
                    w.i("MicroMsg.WalletOrderInfoNewUI", "setTinyAppActivityInfo, hasSubscribeBiz: %s", new Object[]{Boolean.valueOf(commodity.rGA)});
                    if (commodity.rGz != null && commodity.rGz.size() > 0) {
                        for (com.tencent.mm.plugin.wallet_core.model.Orders.b bVar2 : commodity.rGz) {
                            if (bVar2.type == Orders.rGr) {
                                bVar = bVar2;
                                break;
                            }
                        }
                    }
                    bVar = null;
                    w.i("MicroMsg.WalletOrderInfoNewUI", "activityPromotions: %s", new Object[]{bVar});
                    a aVar;
                    CharSequence text;
                    MarginLayoutParams marginLayoutParams;
                    List list;
                    if (bVar != null && bVar.rGI > 0 && !bg.mA(bVar.rGG)) {
                        this.rLz = bVar;
                        this.rLN.setVisibility(8);
                        this.rLK.sMf = true;
                        this.rLO.setEnabled(true);
                        this.rLO.setBackgroundResource(R.g.bda);
                        this.rLM.setCompoundDrawables(null, null, null, null);
                        aVar = (a) this.rLx.get(bVar.rGI);
                        if (aVar != null) {
                            if (!bg.mA(aVar.fSl)) {
                                this.rLK.L(aVar.fSl, 0, 0);
                            }
                            if (!bg.mA(aVar.fNG)) {
                                this.rLL.setText(aVar.fNG);
                            }
                            if (!bg.mA(aVar.rMe)) {
                                this.rLO.setText(aVar.rMe);
                                this.rLO.setBackgroundResource(R.g.blT);
                            }
                        } else {
                            this.rLK.L(bVar.oqk, 0, 0);
                            this.rLL.setText(bVar.name);
                            this.rLO.setText(bVar.rGG);
                        }
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.rLM.getLayoutParams();
                        if (aVar != null && !bg.mA(aVar.title)) {
                            this.rLM.setText(bVar.title);
                            layoutParams.addRule(15, 0);
                        } else if (bg.mA(bVar.title)) {
                            this.rLM.setVisibility(8);
                            layoutParams.addRule(15, -1);
                        } else {
                            this.rLM.setText(bVar.title);
                            layoutParams.addRule(15, 0);
                        }
                        this.rLM.setLayoutParams(layoutParams);
                        this.rLO.setVisibility(0);
                        this.rLO.setOnClickListener(new View.OnClickListener(this) {
                            final /* synthetic */ WalletOrderInfoNewUI rMc;

                            {
                                this.rMc = r1;
                            }

                            public final void onClick(View view) {
                                w.i("MicroMsg.WalletOrderInfoNewUI", "click activity button");
                                WalletOrderInfoNewUI.p(this.rMc);
                            }
                        });
                        if (bVar.rGJ != 1) {
                            this.rLJ.setOnClickListener(new View.OnClickListener(this) {
                                final /* synthetic */ WalletOrderInfoNewUI rMc;

                                {
                                    this.rMc = r1;
                                }

                                public final void onClick(View view) {
                                    w.i("MicroMsg.WalletOrderInfoNewUI", "click activity layout");
                                    WalletOrderInfoNewUI.p(this.rMc);
                                }
                            });
                        }
                        String str = this.rLA;
                        boolean z2 = true;
                        switch (str.hashCode()) {
                            case 48:
                                if (str.equals("0")) {
                                    z2 = false;
                                    break;
                                }
                                break;
                            case 49:
                                if (str.equals("1")) {
                                    z2 = true;
                                    break;
                                }
                                break;
                            case 50:
                                if (str.equals("2")) {
                                    z2 = true;
                                    break;
                                }
                                break;
                            case 51:
                                if (str.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                                    z2 = true;
                                    break;
                                }
                                break;
                            case 52:
                                if (str.equals("4")) {
                                    z2 = true;
                                    break;
                                }
                                break;
                            case 1444:
                                if (str.equals("-1")) {
                                    z2 = true;
                                    break;
                                }
                                break;
                        }
                        switch (z2) {
                            case false:
                                this.rLO.setEnabled(false);
                                break;
                        }
                        text = this.rLL.getText();
                        if (!bg.J(text) && text.length() > 9) {
                            this.rLL.setText(text.subSequence(0, 9));
                            this.rLL.append("...");
                        }
                        marginLayoutParams = (MarginLayoutParams) this.rLJ.getLayoutParams();
                        list = commodity.rGv;
                        if ((commodity.rGs < 0.0d || commodity.kBc >= commodity.rGs) && (list == null || list.size() <= 0)) {
                            marginLayoutParams.topMargin = com.tencent.mm.bg.a.fromDPToPix(this, 50);
                        } else {
                            marginLayoutParams.topMargin = 0;
                        }
                        this.rLJ.setLayoutParams(marginLayoutParams);
                        this.rLJ.setVisibility(0);
                        if (z) {
                            g gVar = g.oUh;
                            Object[] objArr = new Object[6];
                            objArr[0] = this.oSc;
                            objArr[1] = Integer.valueOf(1);
                            objArr[2] = Integer.valueOf(bVar.rGJ);
                            objArr[3] = this.rLA.equals("-1") ? Integer.valueOf(5) : this.rLA;
                            objArr[4] = Long.valueOf(bVar.rGI);
                            objArr[5] = Long.valueOf(bVar.rGQ);
                            gVar.i(13471, objArr);
                        }
                    } else if (!(commodity.rGy == null || bg.mA(commodity.rGy.rGU))) {
                        this.rLs = commodity.rGy.rGU;
                        this.rLt = commodity.rGy.rGV;
                        this.rLu = commodity.rGy;
                        this.rLK.L(commodity.rGy.rGS, 0, 0);
                        this.rLL.setText(commodity.rGy.rGT);
                        this.rLM.setText(getString(R.l.dDY));
                        this.rLM.setVisibility(0);
                        this.rLK.sMf = true;
                        this.rLO.setEnabled(true);
                        this.rLO.setBackgroundResource(R.g.bda);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.rLM.getLayoutParams();
                        layoutParams2.addRule(15, 0);
                        this.rLM.setLayoutParams(layoutParams2);
                        if (commodity.rGy.rGX > 0) {
                            if (!bg.mA(commodity.rGy.rGW)) {
                                this.rLO.setVisibility(0);
                                this.rLO.setText(commodity.rGy.rGW);
                                this.rLN.setVisibility(8);
                            }
                            aVar = (a) this.rLx.get(commodity.rGy.rGX);
                            if (aVar != null) {
                                if (!bg.mA(aVar.rGS)) {
                                    this.rLK.L(aVar.rGS, 0, 0);
                                }
                                if (!bg.mA(aVar.rGT)) {
                                    this.rLL.setText(aVar.rGT);
                                }
                                if (!bg.mA(aVar.rGW)) {
                                    this.rLO.setText(aVar.rGW);
                                    this.rLO.setBackgroundResource(R.g.blT);
                                }
                                if (!bg.mA(aVar.rGU)) {
                                    this.rLs = aVar.rGU;
                                }
                                if (!bg.mA(aVar.rGV)) {
                                    this.rLt = aVar.rGV;
                                }
                            }
                        } else {
                            this.rLO.setVisibility(8);
                            this.rLN.setVisibility(8);
                        }
                        View.OnClickListener anonymousClass4 = new View.OnClickListener(this) {
                            final /* synthetic */ WalletOrderInfoNewUI rMc;

                            public final void onClick(View view) {
                                w.i("MicroMsg.WalletOrderInfoNewUI", "click tiny app");
                                com.tencent.mm.sdk.b.b prVar = new pr();
                                prVar.fWB.userName = this.rMc.rLs;
                                prVar.fWB.fWD = bg.ap(this.rMc.rLt, "");
                                prVar.fWB.scene = 1034;
                                prVar.fWB.fWE = 0;
                                com.tencent.mm.sdk.b.a.urY.m(prVar);
                                if (bg.mA(commodity.rGy.rGW) || commodity.rGy.rGX <= 0) {
                                    this.rMc.rLY = false;
                                } else {
                                    this.rMc.rLY = true;
                                }
                                if (this.rMc.rLY) {
                                    g.oUh.i(14118, new Object[]{this.rMc.ocu, this.rMc.bsF(), Integer.valueOf(3)});
                                    return;
                                }
                                g.oUh.i(14118, new Object[]{this.rMc.ocu, this.rMc.bsF(), Integer.valueOf(1)});
                            }
                        };
                        this.rLJ.setOnClickListener(anonymousClass4);
                        this.rLO.setOnClickListener(anonymousClass4);
                        text = this.rLL.getText();
                        if (!bg.J(text) && text.length() > 9) {
                            this.rLL.setText(text.subSequence(0, 9));
                            this.rLL.append("...");
                        }
                        marginLayoutParams = (MarginLayoutParams) this.rLJ.getLayoutParams();
                        list = commodity.rGv;
                        if ((commodity.rGs < 0.0d || commodity.kBc >= commodity.rGs) && (list == null || list.size() <= 0)) {
                            marginLayoutParams.topMargin = com.tencent.mm.bg.a.fromDPToPix(this, 50);
                        } else {
                            marginLayoutParams.topMargin = 0;
                        }
                        this.rLJ.setLayoutParams(marginLayoutParams);
                        this.rLJ.setVisibility(0);
                    }
                }
            }
            if (this.rLL.getVisibility() == 0) {
                this.rLL.post(new Runnable(this) {
                    final /* synthetic */ WalletOrderInfoNewUI rMc;

                    {
                        this.rMc = r1;
                    }

                    public final void run() {
                        if (this.rMc.rLO.getVisibility() == 0 && this.rMc.rLL.getRight() >= this.rMc.rLO.getLeft() && !bg.J(this.rMc.rLL.getText())) {
                            float textSize = this.rMc.rLL.getTextSize();
                            w.i("MicroMsg.WalletOrderInfoNewUI", "tinyAppDescTv size exceed, tinyAppDescTv.getRight(): %s, tinyAppButton.getLeft(): %s", new Object[]{Integer.valueOf(this.rMc.rLL.getRight()), Integer.valueOf(this.rMc.rLO.getLeft())});
                            Paint paint = new Paint();
                            paint.setTextSize(textSize);
                            String charSequence = this.rMc.rLL.getText().toString();
                            float measureText = paint.measureText(charSequence) - ((float) (this.rMc.rLL.getRight() - this.rMc.rLO.getLeft()));
                            int i = 1;
                            while (paint.measureText(charSequence.substring(0, (charSequence.length() - i) - 1)) > measureText && i <= charSequence.length() - 1) {
                                i++;
                            }
                            w.i("MicroMsg.WalletOrderInfoNewUI", "tinyAppDescTv, exceed len, final search count: %s, text.length: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(charSequence.length())});
                            this.rMc.rLL.setText(charSequence.substring(0, (charSequence.length() - i) - 1));
                            this.rMc.rLL.append("...");
                        }
                    }
                });
            }
        }
    }

    private void In(String str) {
        buX();
        e.m(this, str, false);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        w.i("MicroMsg.WalletOrderInfoNewUI", "onActivityResult %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 1) {
            w.i("MicroMsg.WalletOrderInfoNewUI", "do query pay arawrd");
            k(new com.tencent.mm.plugin.wallet_core.b.o(this.rLw.rCd, this.rLw.rMf, this.rLw.rMg, this.rLw.rMh, this.rLw.fLT, this.rLw.oQK, this.rLw.rHc));
        }
    }

    @Deprecated
    protected Dialog onCreateDialog(int i) {
        return com.tencent.mm.ui.base.g.a(this.uSU.uTo, getString(R.l.fhk), getResources().getStringArray(R.c.aSt), "", new com.tencent.mm.ui.base.g.c(this) {
            final /* synthetic */ WalletOrderInfoNewUI rMc;

            {
                this.rMc = r1;
            }

            public final void hq(int i) {
                switch (i) {
                    case 0:
                        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(this.rMc.ohs).toString()));
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        this.rMc.startActivity(intent);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    protected final boolean aXw() {
        return false;
    }

    protected final int getLayoutId() {
        return R.i.drc;
    }

    private void b(Orders orders) {
        this.rLq.clear();
        if (orders == null || orders.rGe == null) {
            w.w("MicroMsg.WalletOrderInfoNewUI", "hy: orders is null");
            return;
        }
        for (Commodity commodity : orders.rGe) {
            if (commodity.rFV == 2 && !bg.mA(commodity.rGt)) {
                w.d("MicroMsg.WalletOrderInfoNewUI", "hy: has username and is force recommend");
                this.rLq.add(commodity.rGt);
            }
        }
    }

    public final void done() {
        x.a(this.rze, this.ryM);
        if (this.uT.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) this.uT.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.WalletOrderInfoNewUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet_core");
                boolean a = realnameGuideHelper.a(this, bundle, new OnClickListener(this) {
                    final /* synthetic */ WalletOrderInfoNewUI rMc;

                    {
                        this.rMc = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.rMc.buW();
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
        com.tencent.mm.sdk.b.b alVar = new al();
        alVar.fDM.fDN = true;
        com.tencent.mm.sdk.b.a.urY.m(alVar);
        Bundle bundle = new Bundle();
        bundle.putInt("intent_pay_end_errcode", this.uT.getInt("intent_pay_end_errcode"));
        bundle.putString("intent_pay_app_url", this.uT.getString("intent_pay_app_url"));
        bundle.putBoolean("intent_pay_end", this.uT.getBoolean("intent_pay_end"));
        w.i("MicroMsg.WalletOrderInfoNewUI", "pay done...feedbackData errCode:" + this.uT.getInt("intent_pay_end_errcode"));
        for (String str : this.rLq) {
            if (!bg.mA(str)) {
                w.i("MicroMsg.WalletOrderInfoNewUI", "hy: doing netscene subscribe...appName: %s", new Object[]{str});
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
            w.d("MicroMsg.WalletOrderInfoNewUI", "url = " + d);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", d);
            intent.putExtra("showShare", false);
            intent.putExtra("geta8key_username", com.tencent.mm.u.m.xL());
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

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.urY.c(this.rMb);
        com.tencent.mm.sdk.b.a.urY.c(this.oeu);
        ho(1979);
    }

    private void buX() {
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

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.o) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.wallet_core.b.o oVar = (com.tencent.mm.plugin.wallet_core.b.o) kVar;
                a aVar = new a(this, oVar.nBw);
                if (this.rLw != null) {
                    this.rLx.put(oVar.rCd, aVar);
                    iF(false);
                    buS();
                } else if (this.rLY) {
                    this.rLx.put(oVar.rCd, aVar);
                    iF(false);
                    buS();
                }
            }
        } else if (kVar instanceof f) {
            if (i == 0 && i2 == 0) {
                f fVar = (f) kVar;
                String str2 = fVar.rBO;
                if (this.rLz != null && this.rLz.rGI == fVar.rBN.rGI) {
                    w.i("MicroMsg.WalletOrderInfoNewUI", "activityAwardState: %s", new Object[]{this.rLz});
                    this.rLA = str2;
                    w.d("MicroMsg.WalletOrderInfoNewUI", "btnName: %s", new Object[]{fVar.rBN.rGG});
                    iF(false);
                    buS();
                    if (!(bg.mA(fVar.ksO) || TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(str2))) {
                        this.rLO.setText(fVar.ksO);
                    }
                }
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
                return true;
            }
            if (bg.mA(str)) {
                str = getString(R.l.fkA);
            }
            com.tencent.mm.ui.base.g.a(this, str, null, false, new OnClickListener(this) {
                final /* synthetic */ WalletOrderInfoNewUI rMc;

                {
                    this.rMc = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            return true;
        }
        return false;
    }

    public final void re(int i) {
        this.uSU.ipu.setVisibility(i);
    }
}
