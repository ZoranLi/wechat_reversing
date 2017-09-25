package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsAboutCamera extends MMPreference {
    private f isJ;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    public final int ON() {
        return R.o.ful;
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = true;
        String str = preference.igL;
        if (str.equals("settings_take_photo_auto_save_photo")) {
            ap.yY();
            boolean booleanValue = ((Boolean) c.vr().get(a.uFN, Boolean.valueOf(true))).booleanValue();
            ap.yY();
            c.vr().a(a.uFN, Boolean.valueOf(!booleanValue));
        }
        if (str.equals("settings_take_photo_auto_save_video")) {
            ap.yY();
            booleanValue = ((Boolean) c.vr().get(a.uFO, Boolean.valueOf(true))).booleanValue();
            ap.yY();
            t vr = c.vr();
            a aVar = a.uFO;
            if (booleanValue) {
                z = false;
            }
            vr.a(aVar, Boolean.valueOf(z));
        }
        return false;
    }

    protected final void KC() {
        this.isJ = this.vrv;
        zi(R.l.eTp);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsAboutCamera pju;

            {
                this.pju = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pju.aHf();
                this.pju.finish();
                return true;
            }
        });
        ap.yY();
        boolean booleanValue = ((Boolean) c.vr().get(a.uFN, Boolean.valueOf(true))).booleanValue();
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.isJ.Td("settings_take_photo_auto_save_photo");
        checkBoxPreference.vrZ = false;
        checkBoxPreference.vqm = booleanValue;
        ap.yY();
        checkBoxPreference = (CheckBoxPreference) this.isJ.Td("settings_take_photo_auto_save_video");
        checkBoxPreference.vqm = ((Boolean) c.vr().get(a.uFO, Boolean.valueOf(true))).booleanValue();
        checkBoxPreference.vrZ = false;
        this.isJ.notifyDataSetChanged();
    }
}
