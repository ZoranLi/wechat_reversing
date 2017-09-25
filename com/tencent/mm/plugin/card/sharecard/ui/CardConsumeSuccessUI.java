package com.tencent.mm.plugin.card.sharecard.ui;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.ah.n;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.bu;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.r;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.g;
import com.tencent.mm.plugin.card.sharecard.model.j;
import com.tencent.mm.plugin.card.sharecard.model.q;
import com.tencent.mm.protocal.c.azt;
import com.tencent.mm.protocal.c.bab;
import com.tencent.mm.protocal.c.jb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CardConsumeSuccessUI extends MMActivity implements e {
    private View Ih;
    private final String TAG = "MicroMsg.CardConsumeSuccessUI";
    private p iLz = null;
    private OnClickListener iuW = new OnClickListener(this) {
        final /* synthetic */ CardConsumeSuccessUI kis;

        {
            this.kis = r1;
        }

        public final void onClick(View view) {
            if (view.getId() == R.h.bmz) {
                CardConsumeSuccessUI.a(this.kis);
            } else if (view.getId() == R.h.cGL) {
                Intent intent = new Intent();
                intent.putExtra("KLabel_range_index", this.kis.kim);
                intent.putExtra("Klabel_name_list", this.kis.kin);
                intent.putExtra("Kother_user_name_list", this.kis.kio);
                intent.putExtra("k_sns_label_ui_title", this.kis.getString(R.l.dRQ));
                intent.putExtra("k_sns_label_ui_style", 0);
                intent.putExtra("Ktag_rangeFilterprivate", true);
                d.b(this.kis, "sns", ".ui.SnsLabelUI", intent, 1);
            }
        }
    };
    private String kcJ = "";
    private String kdA = "";
    private TextView khO;
    private TextView khP;
    private TextView kia;
    private TextView kib;
    private TextView kic;
    private TextView kid;
    private ImageView kie;
    private Button kif;
    private CheckBox kig;
    private j kih;
    private String kii = "";
    private String kij = "";
    int kik = 0;
    int kil = 0;
    public int kim = 0;
    private String kin = "";
    private String kio = "";
    public ArrayList<String> kip = new ArrayList();
    public ArrayList<String> kiq = new ArrayList();
    ae kir = new ae(Looper.getMainLooper());
    private long mStartTime = 0;

    static /* synthetic */ void a(CardConsumeSuccessUI cardConsumeSuccessUI) {
        if (cardConsumeSuccessUI.kih == null || cardConsumeSuccessUI.kih.kha == null || cardConsumeSuccessUI.kih.kha.isEmpty()) {
            w.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.list == null || mConsumedInfo.list.isEmpty()!");
            return;
        }
        cardConsumeSuccessUI.da(true);
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < cardConsumeSuccessUI.kih.kha.size(); i++) {
            jb jbVar = ((q) cardConsumeSuccessUI.kih.kha.get(i)).keL;
            azt com_tencent_mm_protocal_c_azt = new azt();
            if (jbVar != null) {
                com_tencent_mm_protocal_c_azt.kdE = jbVar.kdE;
                cardConsumeSuccessUI.kdA = jbVar.kdE;
            }
            com_tencent_mm_protocal_c_azt.fVm = ((q) cardConsumeSuccessUI.kih.kha.get(i)).fVm;
            com_tencent_mm_protocal_c_azt.tcP = "";
            com_tencent_mm_protocal_c_azt.tcO = "";
            com_tencent_mm_protocal_c_azt.tcQ = cardConsumeSuccessUI.kil;
            linkedList.add(com_tencent_mm_protocal_c_azt);
        }
        String str = cardConsumeSuccessUI.kik == 1 ? cardConsumeSuccessUI.kih.khb : cardConsumeSuccessUI.kcJ;
        bab a = l.a(cardConsumeSuccessUI.kim, cardConsumeSuccessUI.kip, cardConsumeSuccessUI.kiq);
        k gVar = cardConsumeSuccessUI.kig.isChecked() ? new g(0, linkedList, cardConsumeSuccessUI.kih.khd, str, a, 20, null) : new g(0, linkedList, "", str, a, 20, null);
        if (cardConsumeSuccessUI.kig != null && cardConsumeSuccessUI.kig.getVisibility() == 0) {
            if (cardConsumeSuccessUI.kig.isChecked()) {
                com.tencent.mm.plugin.report.service.g.oUh.i(11324, new Object[]{"CardConsumeSuccessFollowServices", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), ""});
            } else {
                com.tencent.mm.plugin.report.service.g.oUh.i(11324, new Object[]{"CardConsumeSuccessView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), ""});
            }
        }
        ap.vd().a(gVar, 0);
    }

    private void da(boolean z) {
        if (z) {
            this.iLz = p.b(this, getString(R.l.cbS), true, 0, null);
        } else if (this.iLz != null && this.iLz.isShowing()) {
            this.iLz.dismiss();
            this.iLz = null;
        }
    }

    protected final int getLayoutId() {
        return R.i.cWq;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.i("MicroMsg.CardConsumeSuccessUI", "onCreate()");
        this.mStartTime = System.currentTimeMillis();
        qP("");
        setResult(0);
        ap.vd().a(902, this);
        ap.vd().a(910, this);
        String str = "";
        this.kik = getIntent().getIntExtra("key_from_scene", 0);
        if (this.kik == 1) {
            w.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_JS");
            this.kii = getIntent().getStringExtra("key_consumed_card_id");
            this.kij = getIntent().getStringExtra("key_consumed_Code");
            if (TextUtils.isEmpty(this.kii)) {
                w.e("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCardId is empty!");
                kw(0);
                finish();
                return;
            }
            w.i("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCode is " + this.kij);
            da(true);
            ap.vd().a(new com.tencent.mm.plugin.card.sharecard.model.d("", this.kii, this.kij), 0);
            agC();
            this.kil = 7;
        } else if (this.kik == 2) {
            w.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_MSG_UI");
            this.kcJ = getIntent().getStringExtra("key_card_id");
            if (TextUtils.isEmpty(this.kcJ)) {
                w.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
                kw(0);
                finish();
                return;
            }
            w.i("MicroMsg.CardConsumeSuccessUI", "the mCardId is " + this.kcJ);
            da(true);
            ap.vd().a(new com.tencent.mm.plugin.card.sharecard.model.d(this.kcJ, "", ""), 0);
            agC();
            this.kil = 4;
        } else {
            w.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_CONSUMED_CODE");
            this.kcJ = getIntent().getStringExtra("KEY_CARD_ID");
            if (sI(getIntent().getStringExtra("KEY_CARD_CONSUMED_JSON"))) {
                String str2;
                if (!(this.kih == null || bg.bV(this.kih.kha))) {
                    jb jbVar = ((q) this.kih.kha.get(0)).keL;
                    if (jbVar != null) {
                        str2 = jbVar.hib;
                        if (bg.mA(str2)) {
                            str2 = getIntent().getStringExtra("KEY_CARD_COLOR");
                        }
                        this.kil = getIntent().getIntExtra("key_stastic_scene", 0);
                        str = str2;
                    }
                }
                str2 = str;
                if (bg.mA(str2)) {
                    str2 = getIntent().getStringExtra("KEY_CARD_COLOR");
                }
                this.kil = getIntent().getIntExtra("key_stastic_scene", 0);
                str = str2;
            } else {
                w.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
                kw(0);
                finish();
                return;
            }
        }
        com.tencent.mm.plugin.report.service.g.oUh.i(11324, new Object[]{"CardConsumeSuccessUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.kil), "", Integer.valueOf(0), ""});
        KC();
        if (!TextUtils.isEmpty(r1)) {
            sJ(r1);
        }
    }

    private boolean sI(String str) {
        if (TextUtils.isEmpty(str)) {
            w.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the consumed json is empty!");
            return false;
        }
        this.kih = r.tj(str);
        if (this.kih != null) {
            return true;
        }
        w.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the mConsumedInfo is null! json is " + str);
        return false;
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        ap.vd().b(902, this);
        ap.vd().b(910, this);
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (TextUtils.isEmpty(this.kcJ)) {
            com.tencent.mm.plugin.report.service.g.oUh.i(13219, new Object[]{"CardConsumeSuccessUI", Integer.valueOf(this.kik), this.kdA, this.kii, Long.valueOf(currentTimeMillis)});
        } else {
            com.tencent.mm.plugin.report.service.g.oUh.i(13219, new Object[]{"CardConsumeSuccessUI", Integer.valueOf(this.kik), this.kdA, this.kcJ, Long.valueOf(currentTimeMillis)});
        }
        super.onDestroy();
    }

    protected final void KC() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CardConsumeSuccessUI kis;

            {
                this.kis = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kis.finish();
                CardConsumeSuccessUI.kw(0);
                return true;
            }
        });
        this.Ih = this.uSU.ipu;
        this.khO = (TextView) findViewById(R.h.bwl);
        this.khP = (TextView) findViewById(R.h.bxN);
        this.kia = (TextView) findViewById(R.h.bwG);
        this.kib = (TextView) findViewById(R.h.cGM);
        this.kic = (TextView) findViewById(R.h.cGL);
        this.kid = (TextView) findViewById(R.h.cGK);
        this.kie = (ImageView) findViewById(R.h.bxt);
        this.kif = (Button) findViewById(R.h.bmz);
        this.kig = (CheckBox) findViewById(R.h.bqx);
        this.kif.setOnClickListener(this.iuW);
        this.kig.setOnClickListener(this.iuW);
        this.kic.setOnClickListener(this.iuW);
        if (this.kih != null) {
            ar();
        }
    }

    private void ar() {
        if (this.kih == null) {
            w.e("MicroMsg.CardConsumeSuccessUI", "don't updateView() , mConsumedInfo is null");
            return;
        }
        findViewById(R.h.czo).setVisibility(0);
        if (TextUtils.isEmpty(this.kih.khc) || TextUtils.isEmpty(this.kih.khd)) {
            this.kig.setVisibility(8);
            w.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.subscribe_wording is empty or subscribe_app_username is empty!");
        } else {
            this.kig.setText(this.kih.khc);
            this.kig.setVisibility(0);
        }
        if (this.kih.kha == null || this.kih.kha.size() <= 0) {
            this.kif.setEnabled(false);
            w.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.list is null!");
            return;
        }
        this.kib.setText(getString(R.l.dQD, new Object[]{Integer.valueOf(this.kih.kha.size())}));
        jb jbVar = ((q) this.kih.kha.get(0)).keL;
        if (jbVar != null) {
            sJ(jbVar.hib);
            this.khO.setText(jbVar.keT);
            this.khP.setText(jbVar.title);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.aYK);
            if (TextUtils.isEmpty(jbVar.kdG)) {
                w.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo.logo_url is empty!");
                this.kie.setImageResource(R.g.bhq);
            } else {
                a aVar = new a();
                aVar.hIO = com.tencent.mm.compatible.util.e.hgu;
                n.GX();
                aVar.hJg = null;
                aVar.hIN = m.sw(jbVar.kdG);
                aVar.hIL = true;
                aVar.hJi = true;
                aVar.hIJ = true;
                aVar.hIS = dimensionPixelSize;
                aVar.hIR = dimensionPixelSize;
                aVar.hJa = R.g.bhq;
                n.GW().a(jbVar.kdG, this.kie, aVar.Hg());
            }
            if (TextUtils.isEmpty(jbVar.tot)) {
                this.kif.setText(R.l.dQB);
                return;
            }
            w.e("MicroMsg.CardConsumeSuccessUI", "accept_wording is empty!");
            this.kif.setText(jbVar.tot);
            return;
        }
        w.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo is null!");
    }

    private void agC() {
        this.uSU.ipu.setBackgroundColor(getResources().getColor(R.e.aVj));
        findViewById(R.h.czo).setVisibility(4);
    }

    @TargetApi(16)
    private void sJ(String str) {
        int ta = l.ta(str);
        this.Ih.setBackgroundColor(ta);
        com.tencent.mm.plugin.card.b.m.a((MMActivity) this, ta);
        if (com.tencent.mm.compatible.util.d.eo(16)) {
            this.kif.setBackground(l.bJ(ta, getResources().getDimensionPixelSize(R.f.aYv) / 2));
        } else {
            this.kif.setBackgroundDrawable(l.bJ(ta, getResources().getDimensionPixelSize(R.f.aYv) / 2));
        }
        this.Ih.invalidate();
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.CardConsumeSuccessUI", "onSceneEnd, errType = " + i + " errCode = " + i2 + " scene cmd is " + kVar.getType());
        da(false);
        if (i == 0 && i2 == 0) {
            if (kVar instanceof g) {
                g gVar = (g) kVar;
                if (gVar.kfH == 0) {
                    com.tencent.mm.ui.base.g.bl(this, getString(R.l.dQh));
                    setResult(-1);
                    this.kif.setEnabled(false);
                    l.aiK();
                    w.i("MicroMsg.CardConsumeSuccessUI", "finish UI!");
                    kw(-1);
                    String str2 = ((g) kVar).kfG;
                    ShareCardInfo shareCardInfo = new ShareCardInfo();
                    f.a(shareCardInfo, str2);
                    l.a(shareCardInfo);
                    al.agh().adZ();
                    finish();
                    return;
                }
                w.e("MicroMsg.CardConsumeSuccessUI", "shareNetscene.getRetCode() is " + gVar.kfH);
                com.tencent.mm.plugin.card.b.d.b(this, gVar.kfI);
                com.tencent.mm.ui.base.g.bl(this, getString(R.l.dQe));
            } else if (kVar instanceof com.tencent.mm.plugin.card.sharecard.model.d) {
                com.tencent.mm.plugin.card.sharecard.model.d dVar = (com.tencent.mm.plugin.card.sharecard.model.d) kVar;
                if (dVar.kfH == 0) {
                    if (TextUtils.isEmpty(dVar.kfG) || !sI(dVar.kfG)) {
                        w.e("MicroMsg.CardConsumeSuccessUI", "consumed return json is empty, finish ui!");
                        if (this.kik == 1) {
                            kw(0);
                            finish();
                            return;
                        }
                        agC();
                        sK(dVar.kfI);
                        if (bg.mA(dVar.kfI)) {
                            com.tencent.mm.ui.base.g.bl(this, getString(R.l.dQg));
                            return;
                        } else {
                            com.tencent.mm.ui.base.g.bl(this, dVar.kfI);
                            return;
                        }
                    }
                    w.i("MicroMsg.CardConsumeSuccessUI", "consumed return json is valid, update ui");
                    this.kir.post(new Runnable(this) {
                        final /* synthetic */ CardConsumeSuccessUI kis;

                        {
                            this.kis = r1;
                        }

                        public final void run() {
                            this.kis.ar();
                        }
                    });
                } else if (this.kik == 1) {
                    kw(0);
                    finish();
                } else {
                    w.e("MicroMsg.CardConsumeSuccessUI", "succScene.getRetCode() is " + dVar.kfH);
                    agC();
                    sK(dVar.kfI);
                }
            }
        } else if ((kVar instanceof com.tencent.mm.plugin.card.sharecard.model.d) && this.kik == 1) {
            kw(0);
            finish();
        } else {
            com.tencent.mm.plugin.card.b.d.b(this, str);
        }
    }

    private void sK(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getString(R.l.dQg);
        }
        com.tencent.mm.ui.base.g.a(this, str, "", false, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ CardConsumeSuccessUI kis;

            {
                this.kis = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                CardConsumeSuccessUI.kw(0);
                this.kis.finish();
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            w.e("MicroMsg.CardConsumeSuccessUI", "onKeyDown finishUI");
            kw(0);
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private static void kw(int i) {
        w.i("MicroMsg.CardConsumeSuccessUI", "pushConsumedEvent resultCode is " + i);
        b buVar = new bu();
        buVar.fFl.aMA = i;
        com.tencent.mm.sdk.b.a.urY.m(buVar);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1) {
                    this.kim = intent.getIntExtra("Ktag_range_index", 0);
                    w.i("MicroMsg.CardConsumeSuccessUI", "mPrivateSelelct : %d", new Object[]{Integer.valueOf(this.kim)});
                    if (this.kim >= 2) {
                        this.kin = intent.getStringExtra("Klabel_name_list");
                        this.kio = intent.getStringExtra("Kother_user_name_list");
                        w.d("MicroMsg.CardConsumeSuccessUI", "mPrivateSelect : %d, names : %s", new Object[]{Integer.valueOf(this.kim), this.kin});
                        if (TextUtils.isEmpty(this.kin) && TextUtils.isEmpty(this.kio)) {
                            w.e("MicroMsg.CardConsumeSuccessUI", "mLabelNameList and mPrivateTmpUsers by getIntent is empty");
                            return;
                        }
                        List asList = Arrays.asList(this.kin.split(","));
                        this.kiq = l.ab(asList);
                        this.kip = l.aa(asList);
                        if (this.kio != null && this.kio.length() > 0) {
                            this.kip.addAll(Arrays.asList(this.kio.split(",")));
                        }
                        if (this.kiq != null) {
                            w.i("MicroMsg.CardConsumeSuccessUI", "mPrivateIdsList size is " + this.kiq.size());
                        }
                        if (this.kip != null) {
                            w.i("MicroMsg.CardConsumeSuccessUI", "mPrivateNamesList size is " + this.kip.size());
                            Iterator it = this.kip.iterator();
                            while (it.hasNext()) {
                                w.d("MicroMsg.CardConsumeSuccessUI", "username : %s", new Object[]{(String) it.next()});
                            }
                        }
                        if (this.kim == 2) {
                            this.kid.setVisibility(0);
                            this.kid.setText(getString(R.l.dRP, new Object[]{agD()}));
                            return;
                        } else if (this.kim == 3) {
                            this.kid.setVisibility(0);
                            this.kid.setText(getString(R.l.dRO, new Object[]{agD()}));
                            return;
                        } else {
                            this.kid.setVisibility(8);
                            return;
                        }
                    }
                    this.kid.setVisibility(8);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private String agD() {
        if (!TextUtils.isEmpty(this.kin) && !TextUtils.isEmpty(this.kio)) {
            return this.kin + "," + l.te(this.kio);
        }
        if (!TextUtils.isEmpty(this.kin)) {
            return this.kin;
        }
        if (TextUtils.isEmpty(this.kio)) {
            return "";
        }
        return l.te(this.kio);
    }
}
