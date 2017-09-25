package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.base.preference.DialogPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.a;
import com.tencent.mm.ui.base.preference.f;

public class SettingsPersonalMoreUI extends MMPreference implements b {
    private int gkr = -1;
    private f isJ;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    public final int ON() {
        return R.o.fup;
    }

    protected final void KC() {
        zi(R.l.eTo);
        this.isJ = this.vrv;
        ((DialogPreference) this.isJ.Td("settings_sex")).vqt = new a(this) {
            final /* synthetic */ SettingsPersonalMoreUI plB;

            {
                this.plB = r1;
            }

            public final boolean a(Preference preference, Object obj) {
                String str = (String) obj;
                if ("male".equalsIgnoreCase(str)) {
                    this.plB.gkr = 1;
                } else if ("female".equalsIgnoreCase(str)) {
                    this.plB.gkr = 2;
                }
                return false;
            }
        };
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsPersonalMoreUI plB;

            {
                this.plB = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.plB.aHf();
                this.plB.finish();
                return true;
            }
        });
    }

    protected void onResume() {
        boolean z;
        boolean z2 = true;
        super.onResume();
        ap.yY();
        DialogPreference dialogPreference = (DialogPreference) this.isJ.Td("settings_sex");
        switch (bg.a((Integer) c.vr().get(12290, null), 0)) {
            case 1:
                dialogPreference.setValue("male");
                break;
            case 2:
                dialogPreference.setValue("female");
                break;
            default:
                dialogPreference.setValue("unknown");
                break;
        }
        com.tencent.mm.u.bg zL = com.tencent.mm.u.bg.zL();
        this.isJ.Td("settings_district").setSummary(n.eM(bg.mz(zL.getProvince())) + " " + bg.mz(zL.getCity()));
        bam();
        if ((m.xW() & 16777216) == 0) {
            z = true;
        } else {
            z = false;
        }
        String value = g.sV().getValue("LinkedinPluginClose");
        int i = (bg.mA(value) || Integer.valueOf(value).intValue() == 0) ? true : 0;
        if (!z || i == 0) {
            this.isJ.aV("settings_linkedin", true);
            return;
        }
        Preference Td = this.isJ.Td("settings_linkedin");
        ap.yY();
        if (bg.mA((String) c.vr().get(286721, null))) {
            z2 = false;
        }
        if (!z2) {
            Td.setSummary(getString(R.l.eSI));
        } else if ((m.xP() & 4194304) == 0) {
            Td.setSummary(getString(R.l.eSJ));
        } else {
            Td.setSummary(getString(R.l.eSK));
        }
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.u.bg zL = com.tencent.mm.u.bg.zL();
        if (this.gkr != -1) {
            zL.gkr = this.gkr;
        }
        ap.yY();
        c.wQ().b(new e.a(1, com.tencent.mm.u.bg.a(zL)));
    }

    private void bam() {
        Preference Td = this.isJ.Td("settings_signature");
        ap.yY();
        CharSequence mz = bg.mz((String) c.vr().get(12291, null));
        if (mz.length() <= 0) {
            mz = getString(R.l.eUe);
        }
        Td.setSummary(h.a(this, mz));
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        if (str.equals("settings_district")) {
            w.i("SettingsPersonalMoreUI", "settings district,checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null))});
            if (!com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                return false;
            }
            com.tencent.mm.plugin.setting.a.imv.b(new Intent(), this.uSU.uTo);
            return true;
        } else if (str.equals("settings_signature")) {
            startActivity(new Intent(this, EditSignatureUI.class));
            return true;
        } else if (!str.equals("settings_linkedin")) {
            return false;
        } else {
            Intent intent = new Intent();
            intent.putExtra("oversea_entry", true);
            d.b(this, "accountsync", "com.tencent.mm.ui.bindlinkedin.BindLinkedInUI", intent);
            return true;
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        int n = bg.n(obj, 0);
        w.d("SettingsPersonalMoreUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(n), mVar});
        ap.yY();
        if (mVar != c.vr() || n <= 0) {
            w.e("SettingsPersonalMoreUI", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(n), mVar});
        } else if (12291 == n) {
            bam();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("SettingsPersonalMoreUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 64:
                if (iArr[0] == 0) {
                    com.tencent.mm.plugin.setting.a.imv.b(new Intent(), this.uSU.uTo);
                    return;
                } else {
                    com.tencent.mm.ui.base.g.a(this, getString(R.l.eFI), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                        final /* synthetic */ SettingsPersonalMoreUI plB;

                        {
                            this.plB = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.plB.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ SettingsPersonalMoreUI plB;

                        {
                            this.plB = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }
}
