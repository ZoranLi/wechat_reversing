package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TimePicker;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.sql.Time;
import java.text.DateFormat;

public class SettingsActiveTimeUI extends MMPreference {
    private boolean fCF = false;
    private f isJ;
    private Preference jIS;
    private Preference jIT;
    private boolean pkA = false;
    private final OnTimeSetListener pkB = new OnTimeSetListener(this) {
        final /* synthetic */ SettingsActiveTimeUI pkC;

        {
            this.pkC = r1;
        }

        public final void onTimeSet(TimePicker timePicker, int i, int i2) {
            if (this.pkC.pkA) {
                this.pkC.pkw = i;
                this.pkC.pkx = i2;
                com.tencent.mm.i.f.aB(this.pkC.pkw, this.pkC.pkx);
            } else {
                this.pkC.pky = i;
                this.pkC.pkz = i2;
                com.tencent.mm.i.f.aA(this.pkC.pky, this.pkC.pkz);
            }
            this.pkC.KC();
        }
    };
    private int pkw;
    private int pkx;
    private int pky;
    private int pkz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.eSa);
        this.isJ = this.vrv;
        KC();
    }

    protected final void KC() {
        this.isJ.removeAll();
        this.isJ.addPreferencesFromResource(R.o.fuk);
        this.jIT = this.isJ.Td("settings_active_begin_time");
        this.pkw = com.tencent.mm.i.f.st();
        this.pkx = com.tencent.mm.i.f.sv();
        this.jIT.setSummary(e(this, this.pkw, this.pkx));
        this.jIS = this.isJ.Td("settings_active_end_time");
        this.pky = com.tencent.mm.i.f.ss();
        this.pkz = com.tencent.mm.i.f.su();
        this.jIS.setSummary(e(this, this.pky, this.pkz));
        this.fCF = !com.tencent.mm.i.f.sr();
        ((CheckBoxPreference) this.isJ.Td("settings_active_silence_time")).vqm = this.fCF;
        if (this.fCF) {
            this.jIT.setEnabled(true);
            this.jIS.setEnabled(true);
        } else {
            this.jIT.setEnabled(false);
            this.jIS.setEnabled(false);
        }
        if (!this.fCF) {
            this.isJ.c(this.jIT);
            this.isJ.c(this.jIS);
        }
        this.isJ.aV("settings_active_time_full", true);
        this.isJ.notifyDataSetChanged();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsActiveTimeUI pkC;

            {
                this.pkC = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pkC.aHf();
                this.pkC.finish();
                return true;
            }
        });
    }

    public final int ON() {
        return R.o.fuk;
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.igL.equals("settings_active_begin_time")) {
            this.pkA = true;
            showDialog(1);
            return true;
        } else if (preference.igL.equals("settings_active_end_time")) {
            this.pkA = false;
            showDialog(1);
            return true;
        } else if (!preference.igL.equals("settings_active_silence_time")) {
            return false;
        } else {
            boolean z;
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.isJ.Td("settings_active_silence_time");
            if (checkBoxPreference.isChecked()) {
                z = false;
            } else {
                z = true;
            }
            com.tencent.mm.i.f.aL(z);
            g gVar = g.oUh;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(0);
            objArr[1] = Integer.valueOf(checkBoxPreference.isChecked() ? 1 : 2);
            gVar.i(11351, objArr);
            KC();
            return true;
        }
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                if (this.pkA) {
                    return new TimePickerDialog(this.uSU.uTo, this.pkB, this.pkw, this.pkx, false);
                }
                return new TimePickerDialog(this.uSU.uTo, this.pkB, this.pky, this.pkz, false);
            default:
                return null;
        }
    }

    protected void onPrepareDialog(int i, Dialog dialog) {
        switch (i) {
            case 1:
                if (this.pkA) {
                    ((TimePickerDialog) dialog).updateTime(this.pkw, this.pkx);
                    return;
                } else {
                    ((TimePickerDialog) dialog).updateTime(this.pky, this.pkz);
                    return;
                }
            default:
                return;
        }
    }

    private static String e(Context context, int i, int i2) {
        String e = v.e(context.getSharedPreferences(ab.bIX(), 0));
        String bIN = v.bIN();
        if (!e.equalsIgnoreCase("zh_CN") && (!e.equalsIgnoreCase("language_default") || !"zh_CN".equalsIgnoreCase(bIN))) {
            return DateFormat.getTimeInstance(3, v.Po(e)).format(new Time(i, i2, 0));
        }
        int i3;
        if (i > 12) {
            i3 = i - 12;
        } else {
            i3 = i;
        }
        return o.p(context, (((long) i) * 3600000) + (((long) i2) * 60000)) + String.format("%02d:%02d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
    }
}
