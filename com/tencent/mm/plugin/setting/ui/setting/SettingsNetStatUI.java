package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.modelstat.j;
import com.tencent.mm.modelstat.l;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SettingsNetStatUI extends MMPreference {
    private f isJ;
    private long period;

    public final int ON() {
        return R.o.fun;
    }

    protected final boolean OM() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    public void onResume() {
        super.onResume();
        baj();
    }

    protected final void KC() {
        zi(R.l.eUu);
        l Kh = p.Kh();
        int bJT = (int) (bg.bJT() / 86400000);
        if (Kh.gE(bJT) == null) {
            j jVar = new j();
            jVar.hWl = bJT;
            jVar.id = -1;
            Kh.b(jVar);
        }
        this.isJ = this.vrv;
        this.period = p.Kh().Kb();
        Preference Td = this.isJ.Td("settings_netstat_info");
        String format = new SimpleDateFormat(getString(R.l.elz), Locale.US).format(new Date(this.period));
        Td.setTitle(getString(R.l.eUt, new Object[]{format}));
        w.i("MicroMsg.SettingsNetStatUI", "title datatime = " + format);
        w.d("MicroMsg.SettingsNetStatUI", "title datatime = " + format);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsNetStatUI plx;

            {
                this.plx = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.plx.aHf();
                this.plx.finish();
                return true;
            }
        });
        a(0, getString(R.l.eUv), new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsNetStatUI plx;

            {
                this.plx = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                g.a(this.plx.uSU.uTo, R.l.eUw, R.l.eUx, new OnClickListener(this.plx) {
                    final /* synthetic */ SettingsNetStatUI plx;

                    {
                        this.plx = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        l Kh = p.Kh();
                        int bJT = (int) (bg.bJT() / 86400000);
                        at atVar = Kh.hWZ;
                        synchronized (atVar) {
                            atVar.mSt.trimToSize(-1);
                            atVar.uuZ.clear();
                            atVar.fyI.KH();
                            atVar.uvb.KH();
                            atVar.fyL = true;
                        }
                        Kh.hnH.delete("netstat", null, null);
                        j jVar = new j();
                        jVar.hWl = bJT;
                        jVar.id = -1;
                        Kh.b(jVar);
                        this.plx.baj();
                    }
                }, new OnClickListener(this.plx) {
                    final /* synthetic */ SettingsNetStatUI plx;

                    {
                        this.plx = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            }
        });
    }

    private void baj() {
        j gF = p.Kh().gF((int) (this.period / 86400000));
        if (gF == null) {
            gF = new j();
        }
        this.period = p.Kh().Kb();
        Preference Td = this.isJ.Td("settings_netstat_info");
        String charSequence = DateFormat.format(getString(R.l.elz, new Object[]{""}), this.period).toString();
        Td.setTitle(getString(R.l.eUt, new Object[]{charSequence}));
        Td = this.isJ.Td("settings_netstat_mobile");
        w.i("MicroMsg.SettingsNetStatUI", "dknetflow updateFlowStatistic mobile out:%d in:%d", new Object[]{Integer.valueOf(gF.hWG), Integer.valueOf(gF.hWu)});
        Td.setSummary(i(this, ((long) gF.hWG) + ((long) gF.hWu)));
        Td = this.isJ.Td("settings_netstat_wifi");
        w.i("MicroMsg.SettingsNetStatUI", "dknetflow updateFlowStatistic wifi out:%d in:%d", new Object[]{Integer.valueOf(gF.hWH), Integer.valueOf(gF.hWv)});
        Td.setSummary(i(this, ((long) gF.hWH) + ((long) gF.hWv)));
        ((NetStatPreference) this.isJ.Td("settings_netstat_mobile_detail")).piE = false;
        ((NetStatPreference) this.isJ.Td("settings_netstat_wifi_detail")).piE = true;
        this.isJ.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }

    private static String i(Context context, long j) {
        return context.getString(R.l.eUs, new Object[]{bg.ay(j)});
    }
}
