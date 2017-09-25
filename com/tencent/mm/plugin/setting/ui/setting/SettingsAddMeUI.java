package com.tencent.mm.plugin.setting.ui.setting;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.protocal.c.su;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.a;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.HashMap;
import java.util.Map.Entry;

public class SettingsAddMeUI extends MMPreference {
    private f isJ;
    private HashMap<Integer, Integer> jWK = new HashMap();
    private long kBQ;
    private int pkD;
    private int status;

    public final h a(SharedPreferences sharedPreferences) {
        return new a(this, sharedPreferences);
    }

    public final int ON() {
        return R.o.fue;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.isJ = this.vrv;
        this.pkD = m.xR();
        this.status = m.xP();
        this.kBQ = m.xQ();
        KC();
    }

    public void onPause() {
        super.onPause();
        w.d("MicroMsg.SettingsAddMeUI", "plug:" + this.pkD + ",status:" + this.status + ",extstatus:" + this.kBQ);
        ap.yY();
        c.vr().set(7, Integer.valueOf(this.status));
        ap.yY();
        c.vr().set(40, Integer.valueOf(this.pkD));
        ap.yY();
        c.vr().set(147457, Long.valueOf(this.kBQ));
        for (Entry entry : this.jWK.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            com.tencent.mm.bd.a suVar = new su();
            suVar.tAG = intValue;
            suVar.tAH = intValue2;
            ap.yY();
            c.wQ().b(new e.a(23, suVar));
            w.d("MicroMsg.SettingsAddMeUI", "switch  " + intValue + " " + intValue2);
        }
        this.jWK.clear();
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = false;
        String str = preference.igL;
        w.i("MicroMsg.SettingsAddMeUI", str + " item has been clicked!");
        if (str.equals("settings_find_me_by_QQ")) {
            boolean z2 = !((CheckBoxPreference) fVar.Td("settings_find_me_by_QQ")).isChecked();
            a(z2, 8, 2);
            a(z2, 16, 3);
            return true;
        } else if (str.equals("settings_find_me_by_weixin")) {
            if (!((CheckBoxPreference) fVar.Td("settings_find_me_by_weixin")).isChecked()) {
                z = true;
            }
            w.d("MicroMsg.SettingsAddMeUI", "switch plug change : open = " + z + " item value = 512 functionId = 25");
            if (z) {
                this.pkD |= 512;
            } else {
                this.pkD &= -513;
            }
            this.jWK.put(Integer.valueOf(25), Integer.valueOf(z ? 1 : 2));
            return true;
        } else if (str.equals("settings_find_me_by_mobile")) {
            if (!((CheckBoxPreference) fVar.Td("settings_find_me_by_mobile")).isChecked()) {
                z = true;
            }
            a(z, 512, 8);
            return true;
        } else if (str.equals("settings_find_me_by_google")) {
            if (!((CheckBoxPreference) fVar.Td("settings_find_me_by_google")).isChecked()) {
                z = true;
            }
            a(z, SQLiteGlobal.journalSizeLimit, 30);
            return true;
        } else if (str.equals("settings_add_me_by_chatroom")) {
            if (!((CheckBoxPreference) fVar.Td("settings_add_me_by_chatroom")).isChecked()) {
                z = true;
            }
            b(z, 1, 38);
            return true;
        } else if (str.equals("settings_add_me_by_qrcode")) {
            if (!((CheckBoxPreference) fVar.Td("settings_add_me_by_qrcode")).isChecked()) {
                z = true;
            }
            b(z, 2, 39);
            return true;
        } else if (!str.equals("settings_add_me_by_namecard")) {
            return false;
        } else {
            if (!((CheckBoxPreference) fVar.Td("settings_add_me_by_namecard")).isChecked()) {
                z = true;
            }
            b(z, 4, 40);
            return true;
        }
    }

    private void a(boolean z, int i, int i2) {
        w.d("MicroMsg.SettingsAddMeUI", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.status |= i;
        } else {
            this.status &= i ^ -1;
        }
        this.jWK.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
    }

    private void b(boolean z, int i, int i2) {
        w.d("MicroMsg.SettingsAddMeUI", "switch ext change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.kBQ |= (long) i;
        } else {
            this.kBQ &= (long) (i ^ -1);
        }
        this.jWK.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
    }

    protected final void KC() {
        boolean z;
        zi(R.l.eSc);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsAddMeUI pkE;

            {
                this.pkE = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pkE.aHf();
                this.pkE.finish();
                return true;
            }
        });
        w.d("MicroMsg.SettingsAddMeUI", "plug:" + this.pkD + ",status:" + this.status + ",extstatus:" + this.kBQ);
        ap.yY();
        Integer num = (Integer) c.vr().get(9, null);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.isJ.Td("settings_find_me_by_QQ");
        checkBoxPreference.vrZ = false;
        if (num == null || num.intValue() == 0) {
            this.isJ.c(checkBoxPreference);
        } else {
            boolean z2 = (rt(8) && rt(16)) ? false : true;
            checkBoxPreference.vqm = z2;
        }
        ap.yY();
        String str = (String) c.vr().get(6, null);
        checkBoxPreference = (CheckBoxPreference) this.isJ.Td("settings_find_me_by_mobile");
        checkBoxPreference.vrZ = false;
        if (str == null || str.length() <= 0) {
            this.isJ.c(checkBoxPreference);
        } else {
            if (rt(512)) {
                z2 = false;
            } else {
                z2 = true;
            }
            checkBoxPreference.vqm = z2;
        }
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.isJ.Td("settings_find_me_by_weixin");
        checkBoxPreference2.vrZ = false;
        if ((this.pkD & 512) != 0) {
            checkBoxPreference2.vqm = false;
        } else {
            checkBoxPreference2.vqm = true;
        }
        checkBoxPreference2 = (CheckBoxPreference) this.isJ.Td("settings_find_me_by_google");
        if (rt(SQLiteGlobal.journalSizeLimit)) {
            z = false;
        } else {
            z = true;
        }
        checkBoxPreference2.vqm = z;
        checkBoxPreference2.vrZ = false;
        ap.yY();
        String str2 = (String) c.vr().get(208903, null);
        if (!bg.Hp() || TextUtils.isEmpty(str2)) {
            this.isJ.c(checkBoxPreference2);
        }
        checkBoxPreference2 = (CheckBoxPreference) this.isJ.Td("settings_add_me_by_chatroom");
        checkBoxPreference2.vrZ = false;
        if ((this.kBQ & 1) != 0) {
            checkBoxPreference2.vqm = false;
        } else {
            checkBoxPreference2.vqm = true;
        }
        checkBoxPreference2 = (CheckBoxPreference) this.isJ.Td("settings_add_me_by_qrcode");
        checkBoxPreference2.vrZ = false;
        if ((this.kBQ & 2) != 0) {
            checkBoxPreference2.vqm = false;
        } else {
            checkBoxPreference2.vqm = true;
        }
        checkBoxPreference2 = (CheckBoxPreference) this.isJ.Td("settings_add_me_by_namecard");
        checkBoxPreference2.vrZ = false;
        if ((this.kBQ & 4) != 0) {
            checkBoxPreference2.vqm = false;
        } else {
            checkBoxPreference2.vqm = true;
        }
        this.isJ.notifyDataSetChanged();
    }

    private boolean rt(int i) {
        return (this.status & i) != 0;
    }
}
