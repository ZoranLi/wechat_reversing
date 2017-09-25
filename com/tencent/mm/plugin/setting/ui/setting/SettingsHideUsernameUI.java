package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bd.a;
import com.tencent.mm.kernel.h;
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
import com.tencent.mm.ui.base.preference.f;

public class SettingsHideUsernameUI extends MMPreference {
    private f isJ;
    private boolean jax;
    private long kBQ;
    private int pkD;
    private CheckBoxPreference pld;
    private String username;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.username = m.xM();
        if (bg.mA(this.username)) {
            this.username = m.xL();
        }
        this.isJ = this.vrv;
        this.kBQ = m.xQ();
        this.pkD = m.xR();
        KC();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsHideUsernameUI ple;

            {
                this.ple = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ple.finish();
                return true;
            }
        });
    }

    protected final void KC() {
        boolean z = true;
        zi(R.l.eUN);
        this.isJ.Td("settings_my_username").setSummary(this.username);
        boolean z2 = (this.kBQ & 16384) != 0;
        this.jax = z2;
        w.d("MicroMsg.SettingsHideUsernameUI", "is hide: %s", new Object[]{Boolean.valueOf(z2)});
        this.pld = (CheckBoxPreference) this.isJ.Td("settings_show_username");
        this.pld.vrZ = false;
        CheckBoxPreference checkBoxPreference = this.pld;
        if (z2) {
            z = false;
        }
        checkBoxPreference.vqm = z;
        if (bg.mA(m.xN())) {
            this.pld.setEnabled(false);
        }
        this.isJ.notifyDataSetChanged();
    }

    public final int ON() {
        return R.o.fug;
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = false;
        if (!preference.igL.equals("settings_show_username")) {
            return false;
        }
        if (!((CheckBoxPreference) preference).isChecked()) {
            z = true;
        }
        this.jax = z;
        bah();
        return true;
    }

    private void bah() {
        if (this.jax) {
            this.pld.setSummary(getString(R.l.eUb));
        } else if (this.pld.isEnabled()) {
            this.pld.setSummary(getString(R.l.eTZ));
        } else {
            this.pld.setSummary(getString(R.l.eUa));
        }
    }

    protected void onResume() {
        super.onResume();
        bah();
    }

    protected void onPause() {
        boolean z = false;
        int i = 1;
        super.onPause();
        w.d("MicroMsg.SettingsHideUsernameUI", "hide: %s", new Object[]{Boolean.valueOf(this.jax)});
        if ((this.kBQ & 16384) != 0) {
            z = true;
        }
        if (z != this.jax) {
            if (this.jax) {
                this.kBQ |= 16384;
                this.pkD |= 512;
            } else {
                this.kBQ &= -16385;
                this.pkD &= -513;
            }
            h.vJ();
            h.vI().vr().set(147457, Long.valueOf(this.kBQ));
            h.vJ();
            h.vI().vr().set(40, Integer.valueOf(this.pkD));
            a suVar = new su();
            suVar.tAG = 46;
            if (this.jax) {
                i = 2;
            }
            suVar.tAH = i;
            ap.yY();
            c.wQ().b(new e.a(23, suVar));
        }
    }
}
