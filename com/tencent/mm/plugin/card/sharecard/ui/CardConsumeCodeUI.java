package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.a.c.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.i;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.lz;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;

public class CardConsumeCodeUI extends MMActivity implements OnClickListener, a, d.a {
    private final String TAG = "MicroMsg.CardConsumeCodeUI";
    private Vibrator jYD;
    private int jZM = 3;
    private b kcX;
    private String khK;
    private int khL = 3;
    private int khM = 0;
    private a khN;
    private TextView khO;
    private TextView khP;
    private LinearLayout khQ;
    private ImageView khR;
    private View khS;
    private LinearLayout khT;
    private View khU;
    private TextView khV;
    private TextView khW;
    private TextView khX;
    private boolean khY = false;

    protected final int getLayoutId() {
        return R.i.cWp;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.i("MicroMsg.CardConsumeCodeUI", "onCreate()");
        setResult(0);
        this.kcX = (b) getIntent().getParcelableExtra("key_card_info_data");
        this.jZM = getIntent().getIntExtra("key_from_scene", 3);
        this.khL = getIntent().getIntExtra("key_previous_scene", 3);
        this.khK = getIntent().getStringExtra("key_mark_user");
        this.khM = getIntent().getIntExtra("key_from_appbrand_type", 0);
        if (this.kcX == null || this.kcX.afi() == null || this.kcX.afj() == null) {
            w.e("MicroMsg.CardConsumeCodeUI", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
            finish();
            return;
        }
        KC();
        al.agg().m("", "", 3);
    }

    protected final void KC() {
        if (this.kcX.aeP()) {
            if (TextUtils.isEmpty(this.kcX.afi().keS)) {
                qP(getString(R.l.dQC, new Object[]{getString(R.l.cWL)}));
            } else {
                qP(getString(R.l.dQC, new Object[]{this.kcX.afi().keS}));
            }
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CardConsumeCodeUI khZ;

            {
                this.khZ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.khZ.setResult(-1);
                this.khZ.finish();
                return true;
            }
        });
        if (this.khN == null) {
            this.khN = new a(this, this.uSU.ipu);
            a aVar = this.khN;
            aVar.khH = aVar.kdb.getWindow().getAttributes().screenBrightness;
            a aVar2 = this.khN;
            aVar2.khA = (TextView) aVar2.khv.findViewById(R.h.bxQ);
            aVar2.khB = (TextView) aVar2.khv.findViewById(R.h.bxX);
            aVar2.khC = (CheckBox) aVar2.khv.findViewById(R.h.coS);
            aVar2.khC.setChecked(true);
            aVar2.khC.setOnClickListener(aVar2.iuW);
            if (aVar2.khH < 0.8f) {
                aVar2.R(0.8f);
            }
            this.khN.khG = new a.a(this) {
                final /* synthetic */ CardConsumeCodeUI khZ;

                {
                    this.khZ = r1;
                }

                public final void kv(int i) {
                    al.agm().x(this.khZ.kcX.afm(), i, 1);
                }
            };
        }
        this.khN.kcX = this.kcX;
        this.khN.khF = true;
        if (this.kcX.aeO()) {
            aVar = this.khN;
            String str = this.khK;
            aVar.khE = 1;
            aVar.khD = str;
        }
        this.jYD = (Vibrator) getSystemService("vibrator");
        this.khO = (TextView) findViewById(R.h.buP);
        this.khP = (TextView) findViewById(R.h.title);
        this.khQ = (LinearLayout) findViewById(R.h.bpH);
        this.khR = (ImageView) findViewById(R.h.bpG);
        this.khS = findViewById(R.h.bHE);
        this.khT = (LinearLayout) findViewById(R.h.bCP);
        if (this.kcX.aeP()) {
            findViewById(R.h.bwE).setBackgroundColor(getResources().getColor(R.e.aVj));
            m.b((MMActivity) this, true);
        } else {
            findViewById(R.h.bwE).setBackgroundColor(l.ta(this.kcX.afi().hib));
            m.a((MMActivity) this, this.kcX);
        }
        if (!this.kcX.aeP() || TextUtils.isEmpty(this.kcX.afi().kdG)) {
            this.khO.setText(this.kcX.afi().keT);
            this.khP.setText(this.kcX.afi().title);
        } else {
            this.khQ.setVisibility(0);
            this.khO.setVisibility(8);
            this.khP.setVisibility(8);
            this.khS.setVisibility(8);
            m.a(this.khR, this.kcX.afi().kdG, getResources().getDimensionPixelSize(R.f.aYB), R.g.bhq, true);
        }
        if (this.kcX.afi().toO != null) {
            lz lzVar = this.kcX.afi().toO;
            if (!TextUtils.isEmpty(lzVar.title)) {
                if (this.khU == null) {
                    this.khU = ((ViewStub) findViewById(R.h.bxY)).inflate();
                }
                this.khU.setOnClickListener(this);
                this.khV = (TextView) this.khU.findViewById(R.h.bya);
                this.khW = (TextView) this.khU.findViewById(R.h.bxZ);
                this.khX = (TextView) this.khU.findViewById(R.h.bxW);
                this.khV.setVisibility(0);
                this.khV.setText(lzVar.title);
                Drawable drawable = getResources().getDrawable(R.g.bdn);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                drawable.setColorFilter(l.ta(this.kcX.afi().hib), Mode.SRC_IN);
                this.khV.setCompoundDrawables(null, null, drawable, null);
                this.khV.setTextColor(l.ta(this.kcX.afi().hib));
                this.khV.setOnClickListener(this);
                if (TextUtils.isEmpty(lzVar.kdH)) {
                    this.khW.setVisibility(0);
                    this.khW.setText(getString(R.l.dRm));
                } else {
                    this.khW.setVisibility(0);
                    this.khW.setText(lzVar.kdH);
                }
                if (!TextUtils.isEmpty(lzVar.kdI)) {
                    this.khX.setVisibility(0);
                    this.khX.setText(lzVar.kdI);
                }
                LayoutParams layoutParams = this.khR.getLayoutParams();
                layoutParams.height = getResources().getDimensionPixelSize(R.f.aYC);
                layoutParams.width = getResources().getDimensionPixelSize(R.f.aYC);
                this.khR.setLayoutParams(layoutParams);
                layoutParams = this.khQ.getLayoutParams();
                layoutParams.height = com.tencent.mm.bg.a.fromDPToPix(this, 54);
                layoutParams.width = com.tencent.mm.bg.a.fromDPToPix(this, 54);
                this.khQ.setLayoutParams(layoutParams);
                m.a(this.khR, this.kcX.afi().kdG, getResources().getDimensionPixelSize(R.f.aYC), R.g.bhq, true);
                this.khT.setPadding(0, com.tencent.mm.bg.a.fromDPToPix(this, 10), 0, com.tencent.mm.bg.a.fromDPToPix(this, 30));
            }
        }
        al.agl().a((d.a) this);
        if (this.kcX.afc()) {
            al.agn().a(this);
            if (al.agn().isEmpty()) {
                w.i("MicroMsg.CardConsumeCodeUI", "registerListener doGetCardCodes");
                al.agn().sh(this.kcX.afm());
                return;
            }
            al.agn().afy();
        }
    }

    protected void onResume() {
        this.khN.agB();
        al.agl().a(this, true);
        super.onResume();
    }

    protected void onPause() {
        al.agl().a(this, false);
        super.onPause();
    }

    protected void onDestroy() {
        a aVar = this.khN;
        aVar.R(aVar.khH);
        l.p(aVar.iuR);
        l.p(aVar.khz);
        aVar.khG = null;
        aVar.kdb = null;
        al.agl().c(this);
        al.agl().b(this);
        if (this.kcX.afc()) {
            al.agn().b(this);
            al.agn().afz();
        }
        this.jYD.cancel();
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            w.e("MicroMsg.CardConsumeCodeUI", "onKeyDown finishUI");
            setResult(-1);
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void f(b bVar) {
        w.i("MicroMsg.CardConsumeCodeUI", "onDataChange");
        if (bVar != null && bVar.afm() != null && bVar.afm().equals(this.kcX.afm())) {
            this.kcX = bVar;
            this.khN.kcX = this.kcX;
            this.khN.agB();
        }
    }

    public final void afF() {
        this.jYD.vibrate(300);
    }

    public final void afG() {
        w.i("MicroMsg.CardConsumeCodeUI", "onFinishUI");
        finish();
    }

    public final void sj(String str) {
        w.i("MicroMsg.CardConsumeCodeUI", "onStartConsumedSuccUI");
        if (this.khY) {
            w.e("MicroMsg.CardConsumeCodeUI", "has start CardConsumeSuccessUI!");
            return;
        }
        w.i("MicroMsg.CardConsumeCodeUI", "startConsumedSuccUI() ");
        this.khY = true;
        Intent intent = new Intent(this, CardConsumeSuccessUI.class);
        intent.putExtra("KEY_CARD_ID", this.kcX.afm());
        intent.putExtra("KEY_CARD_CONSUMED_JSON", str);
        intent.putExtra("KEY_CARD_COLOR", this.kcX.afi().hib);
        intent.putExtra("key_stastic_scene", this.jZM);
        intent.putExtra("key_from_scene", 0);
        startActivity(intent);
    }

    public final void afA() {
        this.khN.agB();
    }

    public final void sg(String str) {
        com.tencent.mm.plugin.card.b.d.a(this, str, true);
    }

    public final void onSuccess() {
        this.khN.agB();
    }

    public void onClick(View view) {
        if (view.getId() == R.h.bya || view.getId() == R.h.bxV) {
            if (this.kcX.afb()) {
                i.b bVar = new i.b();
                com.tencent.mm.plugin.card.b.b.a(this, bVar.kdu, bVar.kdv, false, this.kcX);
            } else {
                lz lzVar = this.kcX.afi().toO;
                if (!(com.tencent.mm.plugin.card.b.b.a(this.kcX.afm(), lzVar, this.khL, this.khM) || lzVar == null || TextUtils.isEmpty(lzVar.url))) {
                    com.tencent.mm.plugin.card.b.b.a((MMActivity) this, l.o(lzVar.url, lzVar.tpl), 1);
                    g.oUh.i(11941, new Object[]{Integer.valueOf(9), this.kcX.afm(), this.kcX.afn(), "", lzVar.title});
                    if (l.a(lzVar, this.kcX.afm())) {
                        String afm = this.kcX.afm();
                        String str = lzVar.title;
                        l.tg(afm);
                        com.tencent.mm.plugin.card.b.b.a((MMActivity) this, this.kcX.afi().keT);
                    }
                }
            }
            finish();
        }
    }
}
