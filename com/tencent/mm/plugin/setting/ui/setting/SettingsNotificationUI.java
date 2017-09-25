package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ao.l;
import com.tencent.mm.bd.a;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.su;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class SettingsNotificationUI extends MMPreference {
    private f isJ;
    private HashMap<Integer, Integer> jWK = new HashMap();
    private int status;

    static /* synthetic */ void sr(int i) {
        if (i == 1 || i == 0) {
            ap.yY();
            c.vr().set(8200, Boolean.valueOf(true));
            if (i == 1) {
                ap.yY();
                c.vr().set(8201, Integer.valueOf(22));
                ap.yY();
                c.vr().set(8208, Integer.valueOf(8));
                ap.yY();
                c.wQ().b(new l(true, 22, 8));
                return;
            }
            ap.yY();
            c.vr().set(8201, Integer.valueOf(0));
            ap.yY();
            c.vr().set(8208, Integer.valueOf(0));
            ap.yY();
            c.wQ().b(new l(true, 0, 0));
            return;
        }
        ap.yY();
        c.vr().set(8200, Boolean.valueOf(false));
        ap.yY();
        c.wQ().b(new l());
    }

    public final int ON() {
        return R.o.fuo;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.status = m.xP();
        KC();
    }

    protected final void KC() {
        zi(R.l.eTi);
        this.isJ = this.vrv;
        this.isJ.removeAll();
        this.isJ.addPreferencesFromResource(R.o.fuo);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.isJ.Td("settings_new_msg_notification");
        if (com.tencent.mm.i.f.sl()) {
            checkBoxPreference.vqm = true;
        }
        gQ(checkBoxPreference.isChecked());
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.isJ.Td("settings_new_voip_msg_notification");
        if (com.tencent.mm.i.f.sm()) {
            checkBoxPreference2.vqm = true;
        }
        ((CheckBoxPreference) this.isJ.Td("settings_voip_notification_sound")).vqm = bal();
        if (checkBoxPreference.isChecked()) {
            checkBoxPreference = (CheckBoxPreference) this.isJ.Td("settings_sound");
            if (com.tencent.mm.i.f.so()) {
                checkBoxPreference.vqm = true;
                bak();
            } else {
                this.isJ.Te("settings_notification_ringtone");
            }
            checkBoxPreference = (CheckBoxPreference) this.isJ.Td("settings_shake");
            if (com.tencent.mm.i.f.sq()) {
                checkBoxPreference.vqm = true;
            }
            checkBoxPreference = (CheckBoxPreference) this.isJ.Td("settings_show_detail");
            if (com.tencent.mm.i.f.sn()) {
                checkBoxPreference.vqm = true;
            }
        } else {
            this.isJ.Te("settings_show_detail");
            this.isJ.Te("settings_sound");
            this.isJ.Te("settings_notification_ringtone");
            this.isJ.Te("settings_shake");
            this.isJ.Te("settings_active_time");
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsNotificationUI ply;

            {
                this.ply = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ply.aHf();
                this.ply.finish();
                return true;
            }
        });
    }

    protected void onPause() {
        super.onPause();
        ap.yY();
        c.vr().set(7, Integer.valueOf(this.status));
        for (Entry entry : this.jWK.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            a suVar = new su();
            suVar.tAG = intValue;
            suVar.tAH = intValue2;
            ap.yY();
            c.wQ().b(new e.a(23, suVar));
            w.d("MicroMsg.SettingsNotificationUI", "switch  " + intValue + " " + intValue2);
        }
        this.jWK.clear();
    }

    public void onResume() {
        super.onResume();
        bak();
    }

    private void bak() {
        Preference Td = this.isJ.Td("settings_notification_ringtone");
        if (Td != null) {
            Td.setSummary(this.hgx.getString("settings.ringtone.name", getString(R.l.eTj)));
        }
        this.isJ.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        if (str.equals("settings_new_msg_notification")) {
            com.tencent.mm.i.f.aF(((CheckBoxPreference) preference).isChecked());
            KC();
            if (((CheckBoxPreference) preference).isChecked()) {
                g.oUh.a(500, 0, 1, false);
            } else {
                g.oUh.a(500, 1, 1, false);
            }
            return gQ(((CheckBoxPreference) preference).isChecked());
        } else if (str.equals("settings_new_voip_msg_notification")) {
            if (((CheckBoxPreference) preference).isChecked()) {
                com.tencent.mm.i.f.aG(true);
                g.oUh.a(500, 2, 1, false);
            } else {
                com.tencent.mm.ui.base.g.a(this.uSU.uTo, false, this.uSU.uTo.getString(R.l.eTg), "", this.uSU.uTo.getString(R.l.eTf), this.uSU.uTo.getString(R.l.eSN), new OnClickListener(this) {
                    final /* synthetic */ SettingsNotificationUI ply;

                    {
                        this.ply = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.i.f.aG(false);
                        au auVar = new au();
                        auVar.dw(2);
                        auVar.z(System.currentTimeMillis());
                        auVar.setType(1);
                        auVar.cH("weixin");
                        auVar.setContent(this.ply.uSU.uTo.getString(R.l.eTh, new Object[]{Build.MODEL}));
                        ay.i(auVar);
                        ap.yY();
                        aj Rm = c.wW().Rm("weixin");
                        if (Rm != null) {
                            Rm.setContent(this.ply.uSU.uTo.getString(R.l.eTh, new Object[]{Build.MODEL}));
                            Rm.dt(Rm.field_unReadCount + 1);
                            ap.yY();
                            c.wW().a(Rm, "weixin");
                        } else {
                            ae aeVar = new ae();
                            aeVar.setContent(this.ply.uSU.uTo.getString(R.l.eTh, new Object[]{Build.MODEL}));
                            aeVar.setUsername("weixin");
                            aeVar.dt(1);
                            ap.yY();
                            c.wW().d(aeVar);
                        }
                        g.oUh.a(500, 3, 1, false);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ SettingsNotificationUI ply;

                    {
                        this.ply = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.i.f.aG(true);
                        ((CheckBoxPreference) this.ply.isJ.Td("settings_new_voip_msg_notification")).vqm = true;
                        this.ply.KC();
                    }
                }, R.e.aSJ);
            }
            KC();
            return true;
        } else if (str.equals("settings_voip_notification_sound")) {
            r0 = ((CheckBoxPreference) preference).isChecked();
            ap.yY();
            c.vr().set(73217, Boolean.valueOf(r0));
            ap.yY();
            c.vr().set(73218, Boolean.valueOf(r0));
            g.oUh.a(500, r0 ? 8 : 9, 1, false);
            w.i("MicroMsg.SettingsNotificationUI", "void sound checkbox %b", new Object[]{Boolean.valueOf(r0)});
            return true;
        } else if (str.equals("settings_sound")) {
            com.tencent.mm.i.f.aJ(((CheckBoxPreference) preference).isChecked());
            KC();
            return true;
        } else if (str.equals("settings_shake")) {
            com.tencent.mm.i.f.aK(((CheckBoxPreference) preference).isChecked());
            bg.k(this, ((CheckBoxPreference) preference).isChecked());
            return true;
        } else if (str.equals("settings_show_detail")) {
            r0 = ((CheckBoxPreference) preference).isChecked();
            com.tencent.mm.i.f.aH(r0);
            r0 = !r0;
            w.d("MicroMsg.SettingsNotificationUI", "switch change : open = " + r0 + " item value = 2048 functionId = 10");
            if (r0) {
                this.status |= 2048;
            } else {
                this.status &= -2049;
            }
            this.jWK.put(Integer.valueOf(10), Integer.valueOf(r0 ? 1 : 2));
            return true;
        } else if (str.equals("settings_notification_ringtone")) {
            startActivity(new Intent(this.uSU.uTo, SettingsRingtoneUI.class));
            return true;
        } else if (str.equals("settings_active_time")) {
            startActivity(new Intent(this, SettingsActiveTimeUI.class));
            return true;
        } else {
            if (str.equals("settings_plugings_notify")) {
                List linkedList = new LinkedList();
                linkedList.add(getString(R.l.eTs));
                linkedList.add(getString(R.l.eTt));
                linkedList.add(getString(R.l.eTr));
                Boolean valueOf = Boolean.valueOf(m.yh());
                int yp = m.yp();
                int yq = m.yq();
                int i = valueOf.booleanValue() ? yp == yq ? 0 : 1 : 2;
                w.d("MicroMsg.SettingsNotificationUI", valueOf + "st " + yp + " ed " + yq + "  state " + i);
                Context context = this.uSU.uTo;
                String string = getString(R.l.eTv);
                getString(R.l.eTu);
                com.tencent.mm.ui.base.g.a(context, string, linkedList, i, new com.tencent.mm.ui.base.g.a(this) {
                    final /* synthetic */ SettingsNotificationUI ply;

                    public final void rO(int i) {
                        if (i != i) {
                            SettingsNotificationUI.sr(i);
                        }
                    }
                });
            }
            return false;
        }
    }

    private boolean gQ(boolean z) {
        Preference Td = this.isJ.Td("settings_sound");
        Preference Td2 = this.isJ.Td("settings_shake");
        Preference Td3 = this.isJ.Td("settings_show_detail");
        if (Td != null) {
            Td.setEnabled(z);
        }
        if (Td2 != null) {
            Td2.setEnabled(z);
        }
        if (Td3 != null) {
            Td3.setEnabled(z);
        }
        return true;
    }

    private static boolean bal() {
        try {
            ap.yY();
            boolean booleanValue = ((Boolean) c.vr().get(73217, Boolean.valueOf(true))).booleanValue();
            if (booleanValue) {
                return booleanValue;
            }
            try {
                ap.yY();
                c.vr().set(73218, Boolean.valueOf(false));
                return booleanValue;
            } catch (Exception e) {
                return booleanValue;
            }
        } catch (Exception e2) {
            return true;
        }
    }
}
