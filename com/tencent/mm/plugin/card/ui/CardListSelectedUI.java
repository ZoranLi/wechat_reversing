package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage.Resp;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.model.ai;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONObject;

public class CardListSelectedUI extends MMActivity implements com.tencent.mm.plugin.card.a.i.a, e {
    private ListView Fg;
    private p iLz = null;
    private View jAA;
    private int jZM = 0;
    private String kdE;
    private String kdK;
    com.tencent.mm.bd.b kge = null;
    boolean kgf = true;
    private boolean kiP = false;
    private BaseAdapter kjh;
    private String kkc = "";
    private String kkd;
    private TextView knC;
    private RelativeLayout knD;
    private TextView knE;
    private TextView knF;
    boolean knG = false;
    LinkedList<com.tencent.mm.plugin.card.model.a> knH = new LinkedList();
    HashMap<Integer, Boolean> knI = new HashMap();
    private boolean knJ;
    private boolean knK;
    private boolean knL;
    private int knM;
    private String knN;
    private String knO;
    private String knP;
    private String knQ;
    private int knR;
    public String knS;
    private boolean knT = false;
    private com.tencent.mm.plugin.card.model.a knU;
    private int time_stamp;

    class a extends BaseAdapter {
        final /* synthetic */ CardListSelectedUI knV;

        a(CardListSelectedUI cardListSelectedUI) {
            this.knV = cardListSelectedUI;
        }

        public final /* synthetic */ Object getItem(int i) {
            return kC(i);
        }

        public final int getCount() {
            return this.knV.knH.size();
        }

        private com.tencent.mm.plugin.card.model.a kC(int i) {
            return (com.tencent.mm.plugin.card.model.a) this.knV.knH.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            d dVar;
            com.tencent.mm.plugin.card.model.a kC = kC(i);
            if (view == null) {
                view = View.inflate(this.knV, R.i.cWV, null);
                dVar = new d(this.knV);
                dVar.koc = (ImageView) view.findViewById(R.h.logo);
                dVar.iUO = (TextView) view.findViewById(R.h.title);
                dVar.knY = (TextView) view.findViewById(R.h.cGG);
                dVar.kod = (TextView) view.findViewById(R.h.bqE);
                dVar.jZy = (TextView) view.findViewById(R.h.byO);
                dVar.koe = view.findViewById(R.h.btP);
                dVar.kof = (ImageView) view.findViewById(R.h.byp);
                view.setTag(dVar);
            } else {
                dVar = (d) view.getTag();
            }
            if (l.ko(kC.kdF)) {
                int i2;
                dVar.iUO.setText(kC.kdH);
                if (TextUtils.isEmpty(kC.title)) {
                    dVar.knY.setVisibility(8);
                } else {
                    dVar.knY.setVisibility(0);
                    dVar.knY.setText(kC.title);
                }
                if (TextUtils.isEmpty(kC.kdI)) {
                    dVar.kod.setVisibility(8);
                } else {
                    dVar.kod.setVisibility(0);
                    dVar.kod.setText(kC.kdI);
                }
                TextView textView = dVar.jZy;
                if (bg.mA(kC.jZG)) {
                    i2 = 8;
                } else {
                    i2 = 0;
                }
                textView.setVisibility(i2);
                dVar.jZy.setText(kC.jZG);
                m.a(dVar.koc, kC.kdG, this.knV.getBaseContext().getResources().getDimensionPixelSize(R.f.aYV), R.g.bhq, true);
                Boolean bool = (Boolean) this.knV.knI.get(Integer.valueOf(i));
                if (bool == null || !bool.booleanValue()) {
                    dVar.kof.setImageResource(R.g.bdm);
                } else {
                    dVar.kof.setImageResource(R.g.bdl);
                }
            } else {
                w.i("MicroMsg.CardListSelectedUI", "not support type");
            }
            return view;
        }
    }

    class b extends BaseAdapter {
        final /* synthetic */ CardListSelectedUI knV;

        b(CardListSelectedUI cardListSelectedUI) {
            this.knV = cardListSelectedUI;
        }

        public final /* synthetic */ Object getItem(int i) {
            return kC(i);
        }

        public final int getCount() {
            return this.knV.knH.size();
        }

        private com.tencent.mm.plugin.card.model.a kC(int i) {
            return (com.tencent.mm.plugin.card.model.a) this.knV.knH.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            com.tencent.mm.plugin.card.model.a kC = kC(i);
            if (view == null) {
                view = View.inflate(this.knV, R.i.cWU, null);
                cVar = new c(this.knV);
                cVar.knW = (ImageView) view.findViewById(R.h.byp);
                cVar.knX = (TextView) view.findViewById(R.h.bYH);
                cVar.iUO = (TextView) view.findViewById(R.h.title);
                cVar.knY = (TextView) view.findViewById(R.h.cGG);
                cVar.knZ = view.findViewById(R.h.cLn);
                cVar.koa = (TextView) view.findViewById(R.h.bYL);
                cVar.kob = (TextView) view.findViewById(R.h.bYz);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            if (l.ko(kC.kdF)) {
                if (TextUtils.isEmpty(kC.title)) {
                    cVar.iUO.setVisibility(8);
                } else {
                    cVar.iUO.setVisibility(0);
                    cVar.iUO.setText(kC.title);
                }
                if (TextUtils.isEmpty(kC.kdH)) {
                    cVar.knY.setVisibility(8);
                } else {
                    cVar.knY.setVisibility(0);
                    cVar.knY.setText(kC.kdH);
                }
                if (kC.kdN == 0) {
                    view.setAlpha(1.0f);
                    cVar.knW.setVisibility(0);
                    cVar.knX.setVisibility(8);
                    Boolean bool = (Boolean) this.knV.knI.get(Integer.valueOf(i));
                    if (bool == null || !bool.booleanValue()) {
                        cVar.knW.setImageResource(R.g.bdm);
                    } else {
                        cVar.knW.setImageResource(R.g.bdl);
                    }
                } else if (kC.kdN == 1) {
                    view.setAlpha(0.2f);
                    cVar.knW.setVisibility(8);
                    if (bg.mA(kC.kdQ)) {
                        cVar.knX.setVisibility(8);
                    } else {
                        cVar.knX.setVisibility(0);
                        cVar.knX.setText(kC.kdQ);
                    }
                } else {
                    cVar.knW.setVisibility(8);
                    cVar.knX.setVisibility(8);
                }
                if (bg.mA(kC.kdO)) {
                    cVar.koa.setVisibility(8);
                } else {
                    cVar.koa.setVisibility(0);
                    cVar.koa.setText(kC.kdO);
                }
                if (bg.mA(kC.kdP)) {
                    cVar.kob.setVisibility(8);
                } else {
                    cVar.kob.setVisibility(0);
                    cVar.kob.setText(kC.kdP);
                }
                if (bg.mA(kC.kdO) && bg.mA(kC.kdP)) {
                    cVar.knZ.setVisibility(8);
                } else {
                    cVar.knZ.setVisibility(0);
                }
            } else {
                w.i("MicroMsg.CardListSelectedUI", "not support type");
            }
            return view;
        }
    }

    class c {
        public TextView iUO;
        final /* synthetic */ CardListSelectedUI knV;
        public ImageView knW;
        public TextView knX;
        public TextView knY;
        public View knZ;
        public TextView koa;
        public TextView kob;

        c(CardListSelectedUI cardListSelectedUI) {
            this.knV = cardListSelectedUI;
        }
    }

    class d {
        public TextView iUO;
        public TextView jZy;
        final /* synthetic */ CardListSelectedUI knV;
        public TextView knY;
        public ImageView koc;
        public TextView kod;
        public View koe;
        public ImageView kof;

        d(CardListSelectedUI cardListSelectedUI) {
            this.knV = cardListSelectedUI;
        }
    }

    static /* synthetic */ void d(CardListSelectedUI cardListSelectedUI) {
        for (int i = 0; i < cardListSelectedUI.knH.size(); i++) {
            Boolean bool = (Boolean) cardListSelectedUI.knI.get(Integer.valueOf(i));
            if (bool != null && bool.booleanValue()) {
                cardListSelectedUI.kr(true);
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.cWK;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        al.agm().a(this);
        Intent intent = getIntent();
        w.i("MicroMsg.CardListSelectedUI", "initData()");
        if (intent == null) {
            w.e("MicroMsg.CardListSelectedUI", "doGetCardList()  intent == null");
            setResult(1);
            I(1, "");
            finish();
        } else {
            this.jZM = intent.getIntExtra("key_from_scene", 0);
            w.i("MicroMsg.CardListSelectedUI", "mFromScene:" + this.jZM);
            this.kdK = intent.getStringExtra("app_id");
            this.knM = intent.getIntExtra("shop_id", 0);
            this.knN = intent.getStringExtra("sign_type");
            this.knO = intent.getStringExtra("card_sign");
            this.time_stamp = intent.getIntExtra("time_stamp", 0);
            this.knP = intent.getStringExtra("nonce_str");
            this.kdE = intent.getStringExtra("card_tp_id");
            this.knQ = intent.getStringExtra("card_type");
            this.knR = intent.getIntExtra("can_multi_select", 0);
            this.kkc = intent.getStringExtra("key_package_name");
            this.kkd = intent.getStringExtra("key_transaction");
            w.i("MicroMsg.CardListSelectedUI", "app_id:" + this.kdK + " shop_id:" + this.knM + " sign_type:" + this.knN + " time_stamp:" + this.time_stamp);
            w.i("MicroMsg.CardListSelectedUI", "nonce_str:" + this.knP + " card_tp_id:" + this.kdE + " card_type:" + this.knQ + " canMultiSelect:" + this.knR + " packateName:" + this.kkc);
            if ("INVOICE".equalsIgnoreCase(this.knQ)) {
                this.knT = true;
            }
            if (TextUtils.isEmpty(this.kdK) || TextUtils.isEmpty(this.knO)) {
                w.e("MicroMsg.CardListSelectedUI", "doGetCardList()  app_id is nulls");
                setResult(1);
                I(1, "app_id  or card_sign is empty!");
                finish();
            }
        }
        ahF();
        KC();
    }

    private void ahF() {
        if (this.kiP) {
            w.e("MicroMsg.CardListSelectedUI", "doNetSceneGetShareCardsLayout, isDoingGetData is true");
            return;
        }
        if (this.kge == null) {
            this.knJ = false;
            this.knK = false;
            this.knL = false;
        }
        ap.vd().a(664, this);
        ap.vd().a(new ai(this.kdK, this.knM, this.knN, this.knO, this.time_stamp, this.knP, this.kdE, this.knQ, this.kge), 0);
        da(true);
        this.kiP = true;
        if (this.knR == 1) {
            this.knG = true;
        }
    }

    protected final void KC() {
        if (this.knT) {
            zi(R.l.dRf);
        } else {
            zi(R.l.dRe);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CardListSelectedUI knV;

            {
                this.knV = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.knV.setResult(0);
                this.knV.I(0, "");
                this.knV.finish();
                return true;
            }
        });
        if (!this.knT) {
            a(0, getString(R.l.dHp), new OnMenuItemClickListener(this) {
                final /* synthetic */ CardListSelectedUI knV;

                {
                    this.knV = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    if (this.knV.knG || !this.knV.knU.kdR) {
                        this.knV.ahg();
                    } else {
                        this.knV.da(true);
                        al.agm().x(this.knV.knU.kdM, l.th(this.knV.knU.userName), 3);
                    }
                    return true;
                }
            });
            kr(false);
        }
        this.Fg = (ListView) findViewById(R.h.bxA);
        if (this.knT) {
            this.kjh = new b(this);
        } else {
            this.kjh = new a(this);
        }
        this.Fg.setAdapter(this.kjh);
        this.Fg.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ CardListSelectedUI knV;

            {
                this.knV = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (view.getAlpha() != 1.0f) {
                    w.d("MicroMsg.CardListSelectedUI", "item view is gray, cannot click, do nothing return！");
                    return;
                }
                if (this.knV.knG) {
                    this.knV.knI.put(Integer.valueOf(i), Boolean.valueOf(!((Boolean) this.knV.knI.get(Integer.valueOf(i))).booleanValue()));
                } else {
                    for (int i2 = 0; i2 < this.knV.knH.size(); i2++) {
                        this.knV.knI.put(Integer.valueOf(i2), Boolean.valueOf(false));
                    }
                    this.knV.knI.put(Integer.valueOf(i), Boolean.valueOf(true));
                    this.knV.knU = (com.tencent.mm.plugin.card.model.a) this.knV.knH.get(i);
                }
                this.knV.kjh.notifyDataSetChanged();
                CardListSelectedUI.d(this.knV);
            }
        });
        this.Fg.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ CardListSelectedUI knV;

            {
                this.knV = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (absListView.getLastVisiblePosition() == absListView.getCount() - 1 && !this.knV.kgf) {
                    w.d("MicroMsg.CardListSelectedUI", "onScroll() >> doGetCardList()");
                    this.knV.ahF();
                }
            }
        });
        this.jAA = findViewById(R.h.bGB);
        this.knC = (TextView) findViewById(R.h.coj);
        if (this.knT) {
            this.knC.setText(getString(R.l.dRD));
        }
        this.knD = (RelativeLayout) findViewById(R.h.bYw);
        this.knE = (TextView) findViewById(R.h.bYN);
        this.knF = (TextView) findViewById(R.h.bYI);
        if (this.knT) {
            this.knD.setVisibility(0);
            this.knE.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ CardListSelectedUI knV;

                {
                    this.knV = r1;
                }

                public final void onClick(View view) {
                    if (!bg.mA(this.knV.knS)) {
                        com.tencent.mm.plugin.card.b.b.a(this.knV, this.knV.knS, this.knV.getString(R.l.dRa));
                    }
                }
            });
            this.knF.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ CardListSelectedUI knV;

                {
                    this.knV = r1;
                }

                public final void onClick(View view) {
                    this.knV.ahg();
                }
            });
            return;
        }
        this.knD.setVisibility(8);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof ai) {
            ap.vd().b(664, this);
            da(false);
            if (i == 0 && i2 == 0) {
                int size;
                String str2 = ((ai) kVar).kfG;
                w.d("MicroMsg.CardListSelectedUI", str2);
                Collection sp = com.tencent.mm.plugin.card.model.a.sp(str2);
                Collection sq = com.tencent.mm.plugin.card.model.a.sq(str2);
                this.knS = sP(str2);
                if (this.kge == null && !(sp == null && sq == null)) {
                    this.knI.clear();
                    this.knH.clear();
                }
                if (sp != null) {
                    if (sp.size() > 0 && !this.knJ) {
                        this.knJ = true;
                        if (this.knT) {
                            ((com.tencent.mm.plugin.card.model.a) sp.get(0)).jZG = getString(R.l.dRJ);
                        } else {
                            ((com.tencent.mm.plugin.card.model.a) sp.get(0)).jZG = getString(R.l.dRI);
                        }
                    }
                    this.knH.addAll(sp);
                    for (size = this.knH.size(); size < this.knH.size(); size++) {
                        this.knI.put(Integer.valueOf(size), Boolean.valueOf(false));
                    }
                }
                if (sq != null) {
                    if (sq.size() > 0 && !this.knK) {
                        this.knK = true;
                        ((com.tencent.mm.plugin.card.model.a) sq.get(0)).jZG = getString(R.l.cWr);
                    }
                    this.knH.addAll(sq);
                    for (size = this.knH.size(); size < this.knH.size(); size++) {
                        this.knI.put(Integer.valueOf(size), Boolean.valueOf(false));
                    }
                }
                this.kgf = ((ai) kVar).kgf;
                this.kge = ((ai) kVar).kge;
                this.kjh.notifyDataSetChanged();
            } else {
                com.tencent.mm.plugin.card.b.d.b(this, str, i2);
            }
            if (this.knH.size() != 0) {
                this.jAA.setVisibility(8);
                this.Fg.setVisibility(0);
            } else {
                this.jAA.setVisibility(0);
                this.Fg.setVisibility(8);
            }
            this.kiP = false;
        }
    }

    private static String sP(String str) {
        String str2 = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                str2 = new JSONObject(str).optString("rule_url");
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.CardListSelectedUI", e, "", new Object[0]);
            }
        }
        return str2;
    }

    public final void b(String str, com.tencent.mm.plugin.card.a.i.b bVar) {
        da(false);
        if (TextUtils.isEmpty(str) || str.equals(this.knU.kdM)) {
            w.i("MicroMsg.CardListSelectedUI", "onMarkSuccess()");
            w.i("MicroMsg.CardListSelectedUI", "markSucc:" + bVar.kds + " markCardId: " + bVar.kdt);
            if (bVar.kds == 1) {
                if (TextUtils.isEmpty(bVar.kdt) || str.equals(bVar.kdt)) {
                    w.i("MicroMsg.CardListSelectedUI", "markCardId is same as now id!");
                } else {
                    w.i("MicroMsg.CardListSelectedUI", "markCardId is diff as now id!");
                    int i = 0;
                    while (i < this.knH.size()) {
                        if (((com.tencent.mm.plugin.card.model.a) this.knH.get(i)).kdM == bVar.kdt) {
                            for (int i2 = 0; i2 < this.knH.size(); i2++) {
                                this.knI.put(Integer.valueOf(i2), Boolean.valueOf(false));
                            }
                            this.knI.put(Integer.valueOf(i), Boolean.valueOf(true));
                        } else {
                            i++;
                        }
                    }
                }
                ahg();
                return;
            }
            com.tencent.mm.plugin.card.b.d.b(this, getString(R.l.dRj));
            return;
        }
        w.e("MicroMsg.CardListSelectedUI", "onMarkSuccess(), the mark card id is diff from current id!");
    }

    public final void bu(String str, String str2) {
        da(false);
        if (TextUtils.isEmpty(str) || str.equals(this.knU.kdM)) {
            w.i("MicroMsg.CardListSelectedUI", "onMarkFail()");
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(R.l.dRi);
            }
            com.tencent.mm.plugin.card.b.d.b(this, str2);
            return;
        }
        w.e("MicroMsg.CardListSelectedUI", "onMarkFail(), the mark card id is diff from current id!");
    }

    public final void sm(String str) {
    }

    protected void onDestroy() {
        al.agm().b(this);
        super.onDestroy();
    }

    protected final void da(boolean z) {
        if (z) {
            this.iLz = p.b(this, getString(R.l.cbS), false, 0, null);
        } else if (this.iLz != null && this.iLz.isShowing()) {
            this.iLz.dismiss();
            this.iLz = null;
        }
    }

    private void ahg() {
        Intent intent = new Intent();
        String ahG = ahG();
        if (this.knT) {
            intent.putExtra("choose_invoice_info", ahG);
        } else {
            intent.putExtra("choose_card_info", ahG);
        }
        setResult(-1, intent);
        I(-1, ahG);
        finish();
    }

    private String ahG() {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.knH.size(); i2++) {
            Boolean bool = (Boolean) this.knI.get(Integer.valueOf(i2));
            if (bool != null && bool.booleanValue()) {
                arrayList.add(this.knH.get(i2));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        while (i < arrayList.size()) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            com.tencent.mm.plugin.card.model.a aVar = (com.tencent.mm.plugin.card.model.a) arrayList.get(i);
            stringBuilder.append("{");
            stringBuilder.append("\"card_id\":");
            stringBuilder.append("\"" + aVar.kdE + "\"");
            stringBuilder.append(",");
            stringBuilder.append("\"encrypt_code\":");
            stringBuilder.append("\"" + aVar.kdJ + "\"");
            if (this.knT) {
                stringBuilder.append(",");
                stringBuilder.append("\"app_id\":");
                stringBuilder.append("\"" + aVar.kdK + "\"");
            }
            stringBuilder.append("}");
            i++;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            setResult(0);
            I(0, "");
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void I(int i, String str) {
        if (this.jZM != 8) {
            w.e("MicroMsg.CardListSelectedUI", "setResultToSDK need MM_CARD_ITEM_FROM_SCENE_OPENAPI scene, the fromscene is " + this.jZM);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_wxapi_choose_card_from_wx_card_list", str);
        f aJ = g.aJ(this.kdK, true);
        Resp resp = new Resp(bundle);
        if (aJ != null) {
            resp.openId = aJ.field_openId;
        }
        resp.transaction = this.kkd;
        String str2 = "MicroMsg.CardListSelectedUI";
        String str3 = "setResultToSDK, appid : %s, appname : %s, openid : %s, transcation : %s";
        Object[] objArr = new Object[4];
        objArr[0] = this.kdK;
        objArr[1] = aJ == null ? "null appinfo" : aJ.field_appName;
        objArr[2] = aJ == null ? "null appinfo" : aJ.field_openId;
        objArr[3] = this.kkd;
        w.i(str2, str3, objArr);
        resp.toBundle(bundle);
        w.i("MicroMsg.CardListSelectedUI", "setResultToSDK result:" + i);
        w.d("MicroMsg.CardListSelectedUI", "setResultToSDK card_list:" + str);
        if (i == -1) {
            resp.errCode = 0;
        } else {
            resp.errCode = -2;
        }
        Args args = new Args();
        args.targetPkgName = this.kkc;
        args.bundle = bundle;
        com.tencent.mm.pluginsdk.model.app.p.aa(bundle);
        com.tencent.mm.pluginsdk.model.app.p.ab(bundle);
        MMessageActV2.send(ab.getContext(), args);
    }
}
