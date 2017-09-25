package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.Intent;
import android.text.Html;
import com.tencent.mm.R;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bg;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.ChoicePreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.a;
import com.tencent.mm.ui.base.preference.f;

public final class c {
    private MMActivity fCi;
    private f isJ;

    public c(MMActivity mMActivity, f fVar) {
        this.fCi = mMActivity;
        this.isJ = fVar;
        ChoicePreference choicePreference = (ChoicePreference) this.isJ.Td("settings_sex");
        choicePreference.vqt = new a(this) {
            final /* synthetic */ c jWM;

            {
                this.jWM = r1;
            }

            public final boolean a(Preference preference, Object obj) {
                String str = (String) obj;
                int i = -1;
                if ("male".equalsIgnoreCase(str)) {
                    i = 1;
                } else if ("female".equalsIgnoreCase(str)) {
                    i = 2;
                }
                if (i > 0) {
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(12290, Integer.valueOf(i));
                }
                return false;
            }
        };
        choicePreference.setTitle(Html.fromHtml(this.fCi.getString(R.l.eTY) + "<font color='red'>*</font>"));
        ((KeyValuePreference) this.isJ.Td("settings_district")).setTitle(Html.fromHtml(this.fCi.getString(R.l.eSq) + "<font color='red'>*</font>"));
    }

    public static void adC() {
        bg zL = bg.zL();
        ap.yY();
        com.tencent.mm.u.c.wQ().b(new e.a(1, bg.a(zL)));
        com.tencent.mm.plugin.bottle.a.imw.ou();
    }

    public final void update() {
        ap.yY();
        ChoicePreference choicePreference = (ChoicePreference) this.isJ.Td("settings_sex");
        switch (com.tencent.mm.sdk.platformtools.bg.a((Integer) com.tencent.mm.u.c.vr().get(12290, null), 0)) {
            case 1:
                choicePreference.setValue("male");
                break;
            case 2:
                choicePreference.setValue("female");
                break;
            default:
                choicePreference.setValue("unknown");
                break;
        }
        bg zL = bg.zL();
        String province = zL.getProvince();
        this.isJ.Td("settings_district").setSummary(n.eM(province) + " " + zL.getCity());
        KeyValuePreference keyValuePreference = (KeyValuePreference) this.isJ.Td("settings_signature");
        keyValuePreference.vrl = false;
        ap.yY();
        CharSequence mz = com.tencent.mm.sdk.platformtools.bg.mz((String) com.tencent.mm.u.c.vr().get(12291, null));
        Context context = this.fCi;
        if (mz.length() <= 0) {
            mz = this.fCi.getString(R.l.eUe);
        }
        keyValuePreference.setSummary(h.a(context, mz));
        this.isJ.notifyDataSetChanged();
    }

    public final boolean adD() {
        Intent intent = new Intent();
        intent.putExtra("persist_signature", false);
        com.tencent.mm.plugin.bottle.a.imv.c(intent, this.fCi);
        return true;
    }

    public final boolean adE() {
        com.tencent.mm.plugin.bottle.a.imv.b(new Intent(), this.fCi);
        return true;
    }
}
