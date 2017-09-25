package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ao.l;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsPluginsNotifyUI extends MMPreference {
    private f isJ;
    private int state;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    public void onResume() {
        super.onResume();
        ban();
    }

    public final int ON() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        if (str.equals("settings_plugings_disturb_on")) {
            ss(0);
        }
        if (str.equals("settings_plugings_disturb_on_night")) {
            ss(1);
        }
        if (str.equals("settings_plugings_disturb_off")) {
            ss(2);
        }
        return false;
    }

    private void ban() {
        this.isJ.removeAll();
        Preference preference = new Preference(this);
        preference.setTitle(R.l.eTs);
        preference.setKey("settings_plugings_disturb_on");
        preference.setLayoutResource(R.i.diC);
        if (this.state == 0) {
            preference.setWidgetLayoutResource(R.i.dji);
        } else {
            preference.setWidgetLayoutResource(R.i.djj);
        }
        this.isJ.a(preference);
        preference = new Preference(this);
        preference.setTitle(R.l.eTt);
        preference.setKey("settings_plugings_disturb_on_night");
        preference.setLayoutResource(R.i.diC);
        if (this.state == 1) {
            preference.setWidgetLayoutResource(R.i.dji);
        } else {
            preference.setWidgetLayoutResource(R.i.djj);
        }
        this.isJ.a(preference);
        preference = new Preference(this);
        preference.setTitle(R.l.eTr);
        preference.setKey("settings_plugings_disturb_off");
        preference.setLayoutResource(R.i.diC);
        if (this.state == 2) {
            preference.setWidgetLayoutResource(R.i.dji);
        } else {
            preference.setWidgetLayoutResource(R.i.djj);
        }
        this.isJ.a(preference);
        preference = new Preference(this);
        preference.setTitle(R.l.eTu);
        preference.setLayoutResource(R.i.djf);
        this.isJ.a(preference);
        this.isJ.notifyDataSetChanged();
    }

    private void ss(int i) {
        this.state = i;
        if (this.state == 1 || this.state == 0) {
            ap.yY();
            c.vr().set(8200, Boolean.valueOf(true));
            if (this.state == 1) {
                ap.yY();
                c.vr().set(8201, Integer.valueOf(22));
                ap.yY();
                c.vr().set(8208, Integer.valueOf(8));
                ap.yY();
                c.wQ().b(new l(true, 22, 8));
            } else {
                ap.yY();
                c.vr().set(8201, Integer.valueOf(0));
                ap.yY();
                c.vr().set(8208, Integer.valueOf(0));
                ap.yY();
                c.wQ().b(new l(true, 0, 0));
            }
        } else {
            ap.yY();
            c.vr().set(8200, Boolean.valueOf(false));
            ap.yY();
            c.wQ().b(new l());
        }
        ban();
    }

    protected final void KC() {
        Boolean valueOf = Boolean.valueOf(m.yh());
        int yp = m.yp();
        int yq = m.yq();
        if (valueOf.booleanValue()) {
            this.state = yp == yq ? 0 : 1;
        } else {
            this.state = 2;
        }
        w.d("ui.settings.SettingsPlugingsNotify", valueOf + "st " + yp + " ed " + yq + "  state " + this.state);
        this.state = this.state;
        this.isJ = this.vrv;
        zi(R.l.eTv);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsPluginsNotifyUI plC;

            {
                this.plC = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.plC.aHf();
                this.plC.finish();
                return true;
            }
        });
    }
}
