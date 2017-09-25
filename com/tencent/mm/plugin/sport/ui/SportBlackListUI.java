package com.tencent.mm.plugin.sport.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.contact.s;
import java.util.ArrayList;
import java.util.List;

public class SportBlackListUI extends MMPreference {
    private ContactListExpandPreference ktf;
    private List<String> qRN;
    private a qRO = new a(this) {
        final /* synthetic */ SportBlackListUI qRP;

        {
            this.qRP = r1;
        }

        public final void kK(int i) {
            String xu = this.qRP.ktf.xu(i);
            this.qRP.qRN.remove(xu);
            this.qRP.ktf.k(null, this.qRP.qRN);
            this.qRP.ktf.refresh();
            ap.yY();
            o.g(c.wR().Rc(xu));
            d.mN(40);
        }

        public final void kM(int i) {
            SportBlackListUI.c(this.qRP);
        }

        public final void kL(int i) {
            String xu = this.qRP.ktf.xu(i);
            Intent intent = new Intent();
            intent.putExtra("Contact_User", xu);
            com.tencent.mm.bb.d.b(this.qRP, "profile", ".ui.ContactInfoUI", intent);
        }

        public final void ajs() {
            this.qRP.ktf.bFb();
        }
    };

    static /* synthetic */ void c(SportBlackListUI sportBlackListUI) {
        String c = bg.c(sportBlackListUI.qRN, ",");
        Intent intent = new Intent();
        intent.putExtra("titile", sportBlackListUI.getString(R.l.dCT));
        intent.putExtra("list_type", 1);
        intent.putExtra("list_attr", s.q(new int[]{s.vYO, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT}));
        intent.putExtra("always_select_contact", c);
        com.tencent.mm.bb.d.a(sportBlackListUI, ".ui.contact.SelectContactUI", intent, 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.mN(39);
        if (this.qRN == null) {
            this.qRN = new ArrayList();
        }
        ap.yY();
        Cursor d = c.wR().d("@werun.black.android", "", null);
        while (d.moveToNext()) {
            this.qRN.add(d.getString(0));
        }
        d.close();
        this.ktf = (ContactListExpandPreference) this.vrv.Td("black_contact_list_pref");
        this.ktf.a(this.vrv, this.ktf.igL);
        this.ktf.ju(true).jv(true);
        this.ktf.k(null, this.qRN);
        this.ktf.a(this.qRO);
        this.ktf.setSummary(R.l.egK);
        qP(getString(R.l.egn));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SportBlackListUI qRP;

            {
                this.qRP = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qRP.finish();
                return false;
            }
        });
    }

    public final int ON() {
        return R.o.fuz;
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0 && intent != null) {
            String stringExtra = intent.getStringExtra("Select_Contact");
            if (!bg.mA(stringExtra)) {
                Object<String> f = bg.f(stringExtra.split(","));
                if (f != null) {
                    this.qRN.addAll(f);
                    this.ktf.k(null, this.qRN);
                    this.ktf.refresh();
                    for (String stringExtra2 : f) {
                        ap.yY();
                        o.f(c.wR().Rc(stringExtra2));
                    }
                }
            }
        }
    }
}
