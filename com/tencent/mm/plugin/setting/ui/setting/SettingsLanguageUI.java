package com.tencent.mm.plugin.setting.ui.setting;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.ui.account.LanguagePreference;
import com.tencent.mm.ui.account.LanguagePreference.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.d.g;
import com.tencent.mm.ui.l.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SettingsLanguageUI extends MMPreference {
    private static final String[] plf = u.plf;
    private f isJ;
    private List<a> plg;
    private String plh;
    private boolean pli = false;

    static /* synthetic */ void a(SettingsLanguageUI settingsLanguageUI, String str, boolean z) {
        Locale Po = v.Po(str);
        if ("language_default".equalsIgnoreCase(str)) {
            if (VERSION.SDK_INT >= 24) {
                Po = v.usH;
                Locale.setDefault(Po);
            } else {
                Po = Locale.getDefault();
            }
        }
        v.a(settingsLanguageUI.getSharedPreferences(ab.bIX(), 0), str);
        v.a(settingsLanguageUI, Po);
        bc.setProperty("system_property_key_locale", str);
        ab.a(com.tencent.mm.bh.a.a(settingsLanguageUI.getApplication().getResources(), settingsLanguageUI.getApplication()));
        if (z) {
            com.tencent.mm.plugin.setting.a.imv.t(new Intent(), settingsLanguageUI);
            return;
        }
        ap.vd().a(new bb(new bb.a(settingsLanguageUI) {
            final /* synthetic */ SettingsLanguageUI plj;

            {
                this.plj = r1;
            }

            public final void a(e eVar) {
                if (eVar != null) {
                    c Cc = eVar.Cc();
                    byte[] bArr = new byte[0];
                    ap.yY();
                    Cc.i(bArr, com.tencent.mm.u.c.uH());
                }
            }
        }), 0);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(g.uOD, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
        ab.getContext().sendBroadcast(intent);
        FontSelectorView.baB();
        com.tencent.mm.i.g.sW().gTh.clear();
        intent = new Intent();
        intent.putExtra("Intro_Need_Clear_Top ", true);
        com.tencent.mm.plugin.setting.a.imv.t(intent, settingsLanguageUI);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.isJ = this.vrv;
        KC();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final int ON() {
        return -1;
    }

    protected final void KC() {
        int i = 0;
        zi(R.l.eSH);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsLanguageUI plj;

            {
                this.plj = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.plj.aHf();
                this.plj.finish();
                return true;
            }
        });
        a(0, getString(R.l.eSG), new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsLanguageUI plj;

            {
                this.plj = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.plj.finish();
                SettingsLanguageUI.a(this.plj, this.plj.plh, this.plj.pli);
                return true;
            }
        }, b.uTY);
        this.pli = getIntent().getBooleanExtra("not_auth_setting", false);
        this.isJ.removeAll();
        String[] stringArray = getResources().getStringArray(R.c.aSd);
        this.plh = v.e(getSharedPreferences(ab.bIX(), 0));
        this.plg = new ArrayList();
        while (i < plf.length) {
            String str = plf[i];
            this.plg.add(new a(stringArray[i], "", str, this.plh.equalsIgnoreCase(str)));
            i++;
        }
        for (a aVar : this.plg) {
            Preference languagePreference = new LanguagePreference(this);
            languagePreference.a(aVar);
            this.isJ.a(languagePreference);
        }
        this.isJ.a(new PreferenceCategory(this));
        this.isJ.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        if (!(preference instanceof LanguagePreference)) {
            return false;
        }
        a aVar = ((LanguagePreference) preference).uXY;
        if (aVar == null) {
            return false;
        }
        this.plh = aVar.uYb;
        for (a aVar2 : this.plg) {
            aVar2.mEj = false;
        }
        aVar.mEj = true;
        fVar.notifyDataSetChanged();
        return true;
    }
}
