package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.e.a.ga;
import com.tencent.mm.e.b.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.l;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.HashMap;

public class SnsNotInterestUI extends MMPreference implements e {
    private static final String[] qDX = new String[]{"sns_expose_reason_not_fav", "sns_expose_reason_too_freq", "sns_expose_reason_too_many_same_content", "sns_expose_reason_marketing", "sns_expose_reason_content_sexy", "sns_expose_reason_rumour", "sns_expose_reason_other"};
    private static final int[] qDY = new int[]{1, 2, 4, 8, 16, 32, 64};
    private static final int[] qEc = new int[]{j.pKP, j.pKT, j.pKU, j.pKO, j.pKN, j.pKR, j.pKQ};
    private p iLz = null;
    private f jid;
    private String oyO = null;
    private HashMap<String, Boolean> qDZ = new HashMap(qDX.length);
    private HashMap<Integer, Boolean> qEa = new HashMap(qDY.length);
    private HashMap<String, Integer> qEb = new HashMap(qDY.length);
    private TextView qEd;
    private EditText qEe;
    private ListView qEf;
    private LinearLayout qEg;
    private int qEh;
    private int qEi;
    private long qEj;
    private boolean qEk = false;
    private boolean qEl = false;
    q qEm = null;

    static /* synthetic */ void b(SnsNotInterestUI snsNotInterestUI) {
        snsNotInterestUI.qEi = 0;
        for (Integer intValue : snsNotInterestUI.qEa.keySet()) {
            int intValue2 = intValue.intValue();
            if (((Boolean) snsNotInterestUI.qEa.get(Integer.valueOf(intValue2))).booleanValue()) {
                if (snsNotInterestUI.qEi == 0) {
                    snsNotInterestUI.qEi = intValue2;
                } else {
                    snsNotInterestUI.qEi |= intValue2;
                }
            }
        }
        if (snsNotInterestUI.qEj != 0 && snsNotInterestUI.qEh != 0) {
            Context context = snsNotInterestUI.uSU.uTo;
            snsNotInterestUI.getString(j.dIO);
            snsNotInterestUI.iLz = g.a(context, snsNotInterestUI.getString(j.dJd), true, new OnCancelListener(snsNotInterestUI) {
                final /* synthetic */ SnsNotInterestUI qEn;

                {
                    this.qEn = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    h.vJ();
                    h.vH().gXC.c(this.qEn.qEm);
                }
            });
            w.d("MicroMsg.SnsNotInterestUI", "start send not inteset, snsId:%d, scene:%d, type:%d, isNeedSupplement:%b", new Object[]{Long.valueOf(snsNotInterestUI.qEj), Integer.valueOf(snsNotInterestUI.qEh), Integer.valueOf(snsNotInterestUI.qEi), Boolean.valueOf(snsNotInterestUI.qEl)});
            snsNotInterestUI.qEm = new q(snsNotInterestUI.qEj, snsNotInterestUI.qEh, snsNotInterestUI.qEi, snsNotInterestUI.qEl ? snsNotInterestUI.qEe.getText().toString() : null);
            h.vJ();
            h.vH().gXC.a(snsNotInterestUI.qEm, 0);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.qEh = getIntent().getIntExtra("sns_info_not_interest_scene", 0);
        this.qEj = getIntent().getLongExtra("sns_info_svr_id", 0);
        if (this.qEj != 0) {
            String str = ae.beL().dG(this.qEj).field_userName;
            if (str != null) {
                h.vJ();
                af Rb = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb(str);
                if (Rb.gkr == 2) {
                    qEc[1] = j.pKS;
                } else if (Rb.gkr == 1) {
                    qEc[1] = j.pKT;
                }
            }
        }
        h.vJ();
        h.vH().gXC.a(218, this);
        bkE();
        KC();
    }

    private void bkE() {
        int i = 0;
        for (Object put : qDX) {
            this.qDZ.put(put, Boolean.valueOf(false));
        }
        for (int valueOf : qDY) {
            this.qEa.put(Integer.valueOf(valueOf), Boolean.valueOf(false));
        }
        while (i < qDY.length) {
            this.qEb.put(qDX[i], Integer.valueOf(qDY[i]));
            i++;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        bkE();
        h.vJ();
        h.vH().gXC.b(218, this);
        b gaVar = new ga();
        gaVar.fLm.fLn = this.qEk;
        gaVar.fLm.fLo = this.qEj;
        a.urY.m(gaVar);
    }

    protected final void KC() {
        super.KC();
        zi(j.pKX);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsNotInterestUI qEn;

            {
                this.qEn = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qEn.finish();
                return true;
            }
        });
        this.qEd = (TextView) findViewById(i.f.pEN);
        this.qEe = (EditText) findViewById(i.f.pEO);
        this.qEf = (ListView) findViewById(16908298);
        this.qEg = (LinearLayout) findViewById(i.f.pCx);
        this.qEg.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsNotInterestUI qEn;

            {
                this.qEn = r1;
            }

            public final void onClick(View view) {
                this.qEn.qEg.requestFocus();
                this.qEn.aHf();
            }
        });
        this.qEe.setVisibility(8);
        this.qEd.setVisibility(8);
        this.jid = this.vrv;
        if (this.jid == null) {
            w.e("MicroMsg.SnsNotInterestUI", "initPref error, PreferenceScreen is null!");
        } else {
            if (this.jid.Td("sns_expose_desc") == null) {
                Preference preferenceTitleCategory = new PreferenceTitleCategory(this);
                preferenceTitleCategory.setTitle(j.pKL);
                preferenceTitleCategory.setKey("sns_expose_desc");
                this.jid.a(preferenceTitleCategory);
            }
            for (int i = 0; i < qDX.length; i++) {
                String str = qDX[i];
                int i2 = qEc[i];
                if (this.jid.Td(str) == null) {
                    Preference preference = new Preference(this);
                    preference.setTitle(i2);
                    preference.setKey(str);
                    preference.setLayoutResource(i.g.diC);
                    preference.setWidgetLayoutResource(i.g.pGN);
                    this.jid.a(preference);
                }
            }
        }
        a(0, getString(j.pJG), new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsNotInterestUI qEn;

            {
                this.qEn = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                SnsNotInterestUI.b(this.qEn);
                return true;
            }
        }, l.b.uTY);
        ae(0, false);
    }

    protected final int getLayoutId() {
        return i.g.pHx;
    }

    public final int ON() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference == null) {
            return false;
        }
        String str = preference.igL;
        if (!this.qDZ.containsKey(str)) {
            return false;
        }
        boolean z;
        boolean booleanValue = ((Boolean) this.qDZ.get(str)).booleanValue();
        if (booleanValue) {
            preference.setWidgetLayoutResource(i.g.pGN);
        } else {
            preference.setWidgetLayoutResource(i.g.pGM);
        }
        fVar.notifyDataSetChanged();
        if (booleanValue) {
            z = false;
        } else {
            z = true;
        }
        this.qDZ.put(str, Boolean.valueOf(z));
        this.qEa.put(Integer.valueOf(((Integer) this.qEb.get(str)).intValue()), Boolean.valueOf(z));
        w.d("MicroMsg.SnsNotInterestUI", "click: %s, notInterestType: %d, isCheck: %b", new Object[]{str, Integer.valueOf(r0), Boolean.valueOf(z)});
        for (Boolean booleanValue2 : this.qDZ.values()) {
            if (booleanValue2.booleanValue()) {
                booleanValue = true;
                break;
            }
        }
        booleanValue = false;
        if (booleanValue) {
            ae(0, true);
        } else {
            ae(0, false);
        }
        if (z && str.equals("sns_expose_reason_other")) {
            this.qEe.setVisibility(0);
            this.qEd.setVisibility(0);
            this.qEe.requestFocus();
            this.qEl = true;
            aHj();
        } else if (((Boolean) this.qDZ.get("sns_expose_reason_other")).booleanValue()) {
            this.qEf.requestFocus();
            aHf();
        } else {
            this.qEe.setVisibility(8);
            this.qEd.setVisibility(8);
            this.qEf.requestFocus();
            this.qEl = false;
            aHf();
        }
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.SnsNotInterestUI", "onSceneEnd, errType:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (kVar.getType() == 218) {
            this.iLz.dismiss();
            this.iLz = null;
            if (((q) kVar).type != 9) {
                return;
            }
            if (i == 0 && i2 == 0) {
                this.qEk = true;
                Toast.makeText(this, j.pKW, 1).show();
                finish();
                return;
            }
            this.qEk = false;
            Toast.makeText(this, j.pKM, 1).show();
        }
    }
}
