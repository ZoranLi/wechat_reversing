package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.protocal.c.bcp;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsAboutTimelineUI extends MMPreference {
    private String gKJ = "";
    private f isJ;
    private boolean pjY = false;
    private boolean pjZ = false;

    public final int ON() {
        return R.o.fud;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    public void onResume() {
        super.onResume();
        bcp com_tencent_mm_protocal_c_bcp = new bcp();
        if (m.pQB != null) {
            com_tencent_mm_protocal_c_bcp = m.pQB.Ey(this.gKJ);
        }
        if (com_tencent_mm_protocal_c_bcp == null) {
            w.e("MicroMsg.SettingsAboutTimelineUI", "userinfo is null");
        } else {
            int i = com_tencent_mm_protocal_c_bcp.udF;
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.isJ.Td("timeline_stranger_show");
            if (checkBoxPreference != null) {
                this.pjZ = (i & 1) > 0;
                SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + "_preferences", 0);
                if (this.pjZ) {
                    checkBoxPreference.vqm = false;
                    sharedPreferences.edit().putBoolean("timeline_stranger_show", false).commit();
                } else {
                    checkBoxPreference.vqm = true;
                    sharedPreferences.edit().putBoolean("timeline_stranger_show", true).commit();
                }
            }
        }
        this.isJ.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        if (str.equals("timline_outside_permiss")) {
            Intent intent = new Intent();
            intent.putExtra("k_sns_tag_id", 4);
            intent.putExtra("k_sns_from_settings_about_sns", 1);
            d.b(this, "sns", ".ui.SnsBlackDetailUI", intent);
        }
        if (str.equals("timeline_black_permiss")) {
            intent = new Intent();
            intent.putExtra("k_sns_tag_id", 5);
            intent.putExtra("k_sns_from_settings_about_sns", 2);
            d.b(this, "sns", ".ui.SnsTagDetailUI", intent);
        }
        if (str.equals("timeline_stranger_show")) {
            this.pjZ = !this.pjZ;
            if (m.pQB != null) {
                m.pQB.am(this.gKJ, this.pjZ);
            }
            this.pjY = true;
        }
        return false;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.pjY && m.pQB != null) {
            a an = m.pQB.an(this.gKJ, this.pjZ);
            if (an != null) {
                w.d("MicroMsg.SettingsAboutTimelineUI", "userinfo " + an.toString());
                ap.yY();
                c.wQ().b(new e.a(51, an));
            }
        }
    }

    protected final void KC() {
        this.isJ = this.vrv;
        zi(R.l.eTq);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsAboutTimelineUI pka;

            {
                this.pka = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pka.aHf();
                this.pka.finish();
                return true;
            }
        });
        this.gKJ = com.tencent.mm.u.m.xL();
    }
}
