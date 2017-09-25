package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.widget.CardTextPreference;
import com.tencent.mm.protocal.c.lz;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CardDetailPreference extends MMPreference {
    private final String TAG = "MicroMsg.CardDetailPreference";
    f jid;
    private b kcX;
    private List<com.tencent.mm.plugin.card.model.b> kdc = new ArrayList();
    private TextView kkg;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    protected final void KC() {
        this.kcX = (b) getIntent().getParcelableExtra("key_card_info_data");
        if (this.kcX == null || this.kcX.afi() == null || this.kcX.afj() == null) {
            w.e("MicroMsg.CardDetailPreference", "mCardInfo == null or mCardInfo.getCardTpInfo() == null or mCardInfo.getDataInfo() == null");
            finish();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(this.kcX.afi().keS)) {
            stringBuilder.append(this.kcX.afi().keS);
        }
        stringBuilder.append(getString(R.l.dQH));
        qP(stringBuilder.toString());
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CardDetailPreference kkh;

            {
                this.kkh = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kkh.finish();
                return true;
            }
        });
        this.jid = this.vrv;
        this.kdc.clear();
        if (this.kcX.afj().tnC != null && this.kcX.afj().tnC.size() > 0) {
            this.kdc.addAll(l.Z(this.kcX.afj().tnC));
        }
        if (this.kcX.afj().tnD != null && this.kcX.afj().tnD.size() > 0) {
            Collection Z = l.Z(this.kcX.afj().tnD);
            ((com.tencent.mm.plugin.card.model.b) Z.get(0)).kdT = true;
            this.kdc.addAll(Z);
        }
        agU();
        agT();
        agS();
        if (!TextUtils.isEmpty(this.kcX.afi().tol)) {
            Preference cardTextPreference = new CardTextPreference(this);
            cardTextPreference.setLayoutResource(R.i.diC);
            cardTextPreference.setTitle(getString(R.l.dRy));
            cardTextPreference.setKey("key_pic_detail");
            cardTextPreference.aiO();
            agU();
            this.jid.a(cardTextPreference);
        }
        if (!TextUtils.isEmpty(this.kcX.afi().toi)) {
            agU();
            cardTextPreference = new CardTextPreference(this);
            cardTextPreference.setLayoutResource(R.i.diC);
            cardTextPreference.setKey("card_phone");
            cardTextPreference.setTitle(R.l.ezW);
            cardTextPreference.setSummary(this.kcX.afi().toi);
            cardTextPreference.krt = getResources().getColor(R.e.aUA);
            cardTextPreference.aiN();
            this.jid.a(cardTextPreference);
            sL("");
        }
        if (this.kcX.afi() != null && !TextUtils.isEmpty(this.kcX.afi().aJE) && this.kkg != null) {
            this.kkg.setText(this.kcX.afi().aJE);
            this.kkg.setVisibility(0);
        }
    }

    private void agS() {
        for (int i = 0; i < this.kdc.size(); i++) {
            com.tencent.mm.plugin.card.model.b bVar = (com.tencent.mm.plugin.card.model.b) this.kdc.get(i);
            Preference preference = new Preference(this);
            preference.setLayoutResource(R.i.diC);
            preference.setKey(bVar.title);
            preference.setTitle(bVar.title);
            if (!TextUtils.isEmpty(bVar.kdH)) {
                preference.setSummary(bVar.kdH);
            }
            if (bVar.kdT) {
                agU();
            }
            this.jid.a(preference);
        }
    }

    private void agT() {
        if (this.kcX.afi().tok != null && this.kcX.afi().tok != null) {
            for (int i = 0; i < this.kcX.afi().tok.size(); i++) {
                lz lzVar = (lz) this.kcX.afi().tok.get(i);
                if (!TextUtils.isEmpty(lzVar.kdH)) {
                    Preference cardTextPreference = new CardTextPreference(this);
                    cardTextPreference.setLayoutResource(R.i.diC);
                    cardTextPreference.setTitle(lzVar.kdH);
                    cardTextPreference.aiO();
                    sL(lzVar.title);
                    this.jid.a(cardTextPreference);
                }
            }
            agU();
        }
    }

    private void agU() {
        this.jid.a(new PreferenceSmallCategory(this));
    }

    private void sL(String str) {
        Preference preferenceTitleCategory = new PreferenceTitleCategory(this);
        if (TextUtils.isEmpty(str)) {
            preferenceTitleCategory.setTitle(" ");
        } else {
            preferenceTitleCategory.setTitle(str);
        }
        this.jid.a(preferenceTitleCategory);
    }

    public final int ON() {
        return R.o.ftk;
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.igL.equals("card_phone")) {
            String str = this.kcX.afi().toi;
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str).toString()));
            startActivity(intent);
        }
        if (preference.igL.equals("key_pic_detail")) {
            com.tencent.mm.plugin.card.b.b.a((MMActivity) this, this.kcX.afi().tol, 0);
        } else {
            for (int i = 0; i < this.kdc.size(); i++) {
                com.tencent.mm.plugin.card.model.b bVar = (com.tencent.mm.plugin.card.model.b) this.kdc.get(i);
                if (!(bVar.title == null || !bVar.title.equals(preference.igL) || TextUtils.isEmpty(bVar.url))) {
                    if (com.tencent.mm.plugin.card.b.b.d(this.kcX.afm(), bVar.tnY, bVar.tnZ, 1028, 0)) {
                        break;
                    }
                    com.tencent.mm.plugin.card.b.b.a((MMActivity) this, bVar.url, 1);
                }
            }
        }
        return false;
    }

    public final View agV() {
        View inflate = getLayoutInflater().inflate(R.i.doT, null);
        this.kkg = (TextView) inflate.findViewById(R.h.cGa);
        this.kkg.setVisibility(8);
        return inflate;
    }
}
