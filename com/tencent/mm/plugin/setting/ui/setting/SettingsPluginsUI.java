package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ai.b;
import com.tencent.mm.bb.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.jsapi.map.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ag.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.PluginTextPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SettingsPluginsUI extends MMPreference {
    private static int plD = 1;
    private static HashMap<String, Integer> plE = new HashMap<String, Integer>() {
        {
            put("qqmail", Integer.valueOf(3));
            put("lbsapp", Integer.valueOf(6));
            put("shakeapp", Integer.valueOf(7));
            put("newsapp", Integer.valueOf(8));
            put("masssendapp", Integer.valueOf(9));
            put("feedsapp", Integer.valueOf(10));
            put("voiceinputapp", Integer.valueOf(12));
            put("linkedinplugin", Integer.valueOf(13));
            put("floatbottle", Integer.valueOf(14));
            put("facebookapp", Integer.valueOf(16));
            put("gh_43f2581f6fd6", Integer.valueOf(18));
        }
    };
    private f isJ;
    private boolean plF;

    public final int ON() {
        return R.o.fur;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.isJ = this.vrv;
        KC();
        g.oUh.i(14098, new Object[]{Integer.valueOf(5)});
        g.oUh.i(12846, new Object[]{Integer.valueOf(plD)});
        a.hlS.J("gh_43f2581f6fd6", "");
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void KC() {
        zi(R.l.eTw);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsPluginsUI plG;

            {
                this.plG = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.plG.aHf();
                this.plG.finish();
                return true;
            }
        });
    }

    public void onResume() {
        PluginPreference pluginPreference;
        boolean z = false;
        super.onResume();
        this.isJ.removeAll();
        this.isJ.a(new PreferenceSmallCategory(this));
        List<Preference> arrayList = new ArrayList();
        List<Preference> arrayList2 = new ArrayList();
        boolean ys = m.ys();
        if (!ys) {
            ys = bg.getInt(com.tencent.mm.i.g.sV().getValue("BindQQSwitch"), 1) == 1;
        }
        if (!ys) {
            w.i("MicroMsg.SettingsPluginsUI", "summerqq BindQQSwitch off");
        }
        if (ys && d.Jt("qqmail")) {
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.Eb("qqmail")) {
                pluginPreference.setTitle(pluginPreference.piM);
                if ((m.xW() & 1) == 0) {
                    arrayList.add(pluginPreference);
                } else if (b.Hn()) {
                    arrayList2.add(pluginPreference);
                }
            }
        }
        if (d.Jt("bottle")) {
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.Eb("floatbottle")) {
                pluginPreference.setTitle(pluginPreference.piM);
                if ((m.xW() & 64) == 0) {
                    arrayList.add(pluginPreference);
                } else {
                    arrayList2.add(pluginPreference);
                }
            }
        }
        if (d.Jt("nearby")) {
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.Eb("lbsapp")) {
                pluginPreference.setTitle(pluginPreference.piM);
                if ((m.xW() & 512) == 0) {
                    arrayList.add(pluginPreference);
                } else {
                    arrayList2.add(pluginPreference);
                }
            }
        }
        if (d.Jt("shake")) {
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.Eb("shakeapp")) {
                pluginPreference.setTitle(pluginPreference.piM);
                if ((m.xW() & 256) == 0) {
                    arrayList.add(pluginPreference);
                } else {
                    arrayList2.add(pluginPreference);
                }
            }
        }
        if (d.Jt("readerapp")) {
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.Eb("newsapp")) {
                pluginPreference.setTitle(pluginPreference.piM);
                if ((m.xW() & SQLiteGlobal.journalSizeLimit) == 0) {
                    arrayList.add(pluginPreference);
                } else if (b.Hn()) {
                    arrayList2.add(pluginPreference);
                }
            }
        }
        pluginPreference = new PluginPreference(this);
        if (pluginPreference.Eb("facebookapp")) {
            pluginPreference.setTitle(pluginPreference.piM);
            if ((m.xW() & 8192) == 0) {
                arrayList.add(pluginPreference);
            } else if (b.Hm()) {
                arrayList2.add(pluginPreference);
            }
        }
        if (d.Jt("masssend")) {
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.Eb("masssendapp")) {
                pluginPreference.setTitle(pluginPreference.piM);
                if ((m.xW() & 65536) == 0) {
                    arrayList.add(pluginPreference);
                } else {
                    arrayList2.add(pluginPreference);
                }
            }
        }
        d.bGP();
        if (!b.Hl()) {
            pluginPreference = new PluginPreference(this);
            if (pluginPreference.Eb("voiceinputapp")) {
                pluginPreference.setTitle(pluginPreference.piM);
                if ((m.xW() & 33554432) == 0) {
                    arrayList.add(pluginPreference);
                } else {
                    arrayList2.add(pluginPreference);
                }
            }
        }
        pluginPreference = new PluginPreference(this);
        String string = getString(R.l.egL);
        pluginPreference.piL = "gh_43f2581f6fd6";
        pluginPreference.piM = string;
        pluginPreference.setKey("settings_plugins_list_#" + pluginPreference.piL);
        pluginPreference.setTitle(pluginPreference.piM);
        if (((com.tencent.mm.plugin.sport.b.b) h.h(com.tencent.mm.plugin.sport.b.b.class)).bmm()) {
            arrayList.add(pluginPreference);
        } else {
            arrayList2.add(pluginPreference);
        }
        String value = com.tencent.mm.i.g.sV().getValue("LinkedinPluginClose");
        if (bg.mA(value) || Integer.valueOf(value).intValue() == 0) {
            PluginPreference pluginPreference2 = new PluginPreference(this);
            if (pluginPreference2.Eb("linkedinplugin")) {
                pluginPreference2.setTitle(pluginPreference2.piM);
                boolean z2 = (m.xW() & 16777216) == 0;
                ap.yY();
                if (!bg.mA((String) c.vr().get(286721, null))) {
                    z = true;
                }
                if (z2 && r1) {
                    arrayList.add(pluginPreference2);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            Preference pluginTextPreference = new PluginTextPreference(this);
            pluginTextPreference.vrR = R.k.dzt;
            pluginTextPreference.AC(R.l.eTD);
            this.isJ.a(pluginTextPreference);
        }
        ap.yY();
        value = (String) c.vr().get(com.tencent.mm.storage.w.a.uHw, "");
        Preference preference = null;
        for (Preference preference2 : arrayList) {
            preference2.lAi = 255;
            if (value.contains(preference2.piL)) {
                preference2.piQ = true;
                if (preference == null) {
                    preference = preference2;
                }
            }
            this.isJ.a(preference2);
        }
        this.isJ.a(new PreferenceSmallCategory(this));
        Preference preference22 = new PluginTextPreference(this);
        preference22.vrR = R.k.dzu;
        preference22.AC(R.l.eTK);
        this.isJ.a(preference22);
        if (arrayList2.isEmpty()) {
            this.isJ.a(new PluginEmptyTextPreference(this, R.l.eTx));
        }
        for (Preference preference222 : arrayList2) {
            preference222.lAi = i.CTRL_INDEX;
            if (value.contains(preference222.piL)) {
                preference222.piQ = true;
                if (preference == null) {
                    preference = preference222;
                }
            }
            this.isJ.a(preference222);
        }
        this.isJ.a(new PreferenceSmallCategory(this));
        if (preference != null) {
            setSelection(this.isJ.Tf(preference.igL));
        }
    }

    public void onPause() {
        super.onPause();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        if (str != null && str.equals("display_in_addr_book")) {
            boolean isChecked = ((CheckBoxPreference) fVar.Td(str)).isChecked();
            ap.yY();
            c.vr().set(35, Boolean.valueOf(isChecked));
            return true;
        } else if (!(preference instanceof PluginPreference)) {
            return false;
        } else {
            str = ((PluginPreference) preference).piL;
            if ("feedsapp".equals(str) && this.plF) {
                ap.yY();
                c.vr().set(-2046825369, Boolean.valueOf(false));
            }
            d.b(this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
            g.oUh.i(12846, new Object[]{plE.get(str)});
            w.i("MicroMsg.SettingsPluginsUI", "click id:%s, kvID:%d", new Object[]{str, plE.get(str)});
            return true;
        }
    }
}
