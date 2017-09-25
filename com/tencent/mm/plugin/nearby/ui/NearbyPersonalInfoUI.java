package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.a;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bg;
import com.tencent.mm.u.c;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.ChoicePreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class NearbyPersonalInfoUI extends MMPreference {
    private int gkr = -1;
    private f isJ;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void KC() {
        zi(R.l.eDg);
        this.isJ = this.vrv;
        ((KeyValuePreference) this.isJ.Td("settings_signature")).vrl = false;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ NearbyPersonalInfoUI nWL;

            {
                this.nWL = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nWL.finish();
                return true;
            }
        });
        a(0, getString(R.l.dHP), new OnMenuItemClickListener(this) {
            final /* synthetic */ NearbyPersonalInfoUI nWL;

            {
                this.nWL = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                bg zL;
                if (this.nWL.gkr != -1) {
                    zL = bg.zL();
                    zL.gkr = this.nWL.gkr;
                    bg.a(zL);
                }
                zL = bg.zM();
                if (zL == null) {
                    g.a(this.nWL.uSU.uTo, R.l.eDh, R.l.dIO, new OnClickListener(this.nWL) {
                        final /* synthetic */ NearbyPersonalInfoUI nWL;

                        {
                            this.nWL = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else {
                    String mz = com.tencent.mm.sdk.platformtools.bg.mz(zL.getProvince());
                    com.tencent.mm.sdk.platformtools.bg.mz(zL.getCity());
                    int i = zL.gkr;
                    if (com.tencent.mm.sdk.platformtools.bg.mA(mz) || i == 0) {
                        g.a(this.nWL.uSU.uTo, R.l.eDh, R.l.dIO, /* anonymous class already generated */);
                    } else {
                        this.nWL.startActivity(new Intent(this.nWL, NearbyFriendsUI.class));
                        bg zL2 = bg.zL();
                        if (i != -1) {
                            zL2.gkr = i;
                        }
                        ap.yY();
                        c.wQ().b(new a(1, bg.a(zL2)));
                        this.nWL.finish();
                    }
                }
                return true;
            }
        });
        ((ChoicePreference) this.isJ.Td("settings_sex")).vqt = new Preference.a(this) {
            final /* synthetic */ NearbyPersonalInfoUI nWL;

            {
                this.nWL = r1;
            }

            public final boolean a(Preference preference, Object obj) {
                String str = (String) obj;
                if ("male".equalsIgnoreCase(str)) {
                    this.nWL.gkr = 1;
                } else if ("female".equalsIgnoreCase(str)) {
                    this.nWL.gkr = 2;
                }
                return false;
            }
        };
        ap.yY();
        int a = com.tencent.mm.sdk.platformtools.bg.a((Integer) c.vr().get(12290, null), 0);
        ChoicePreference choicePreference = (ChoicePreference) this.isJ.Td("settings_sex");
        choicePreference.setTitle(Html.fromHtml(getString(R.l.eTY) + "<font color='red'>*</font>"));
        switch (a) {
            case 1:
                choicePreference.setValue("male");
                return;
            case 2:
                choicePreference.setValue("female");
                return;
            default:
                choicePreference.setValue("unknown");
                return;
        }
    }

    public void onResume() {
        bg zL = bg.zL();
        String province = zL.getProvince();
        String city = zL.getCity();
        Preference Td = this.isJ.Td("settings_district");
        Td.setSummary(n.eM(province) + " " + city);
        Td.setTitle(Html.fromHtml(getString(R.l.eSq) + "<font color='red'>*</font>"));
        Preference Td2 = this.isJ.Td("settings_signature");
        ap.yY();
        CharSequence mz = com.tencent.mm.sdk.platformtools.bg.mz((String) c.vr().get(12291, null));
        if (mz.length() <= 0) {
            mz = getString(R.l.eUe);
        }
        Td2.setSummary(h.a(this, mz));
        super.onResume();
    }

    public final int ON() {
        return R.o.eDg;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        if ("settings_district".equals(str)) {
            com.tencent.mm.plugin.nearby.a.imv.b(null, this);
            return true;
        } else if (!"settings_signature".equals(str)) {
            return false;
        } else {
            com.tencent.mm.plugin.nearby.a.imv.c(null, this);
            overridePendingTransition(R.a.aRq, R.a.aRp);
            return true;
        }
    }
}
