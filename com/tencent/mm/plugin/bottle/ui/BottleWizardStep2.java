package com.tencent.mm.plugin.bottle.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.u.bg;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class BottleWizardStep2 extends MMPreference {
    private c jWP;

    public final int ON() {
        return R.o.ftj;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void KC() {
        zi(R.l.eTn);
        this.jWP = new c(this, this.vrv);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BottleWizardStep2 jWQ;

            {
                this.jWQ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jWQ.goBack();
                return true;
            }
        });
        a(0, getString(R.l.dHP), new OnMenuItemClickListener(this) {
            final /* synthetic */ BottleWizardStep2 jWQ;

            {
                this.jWQ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                c.adC();
                bg zL = bg.zL();
                if (com.tencent.mm.sdk.platformtools.bg.a(Integer.valueOf(zL.gkr), 0) <= 0) {
                    g.b(this.jWQ.uSU.uTo, this.jWQ.getString(R.l.dPx), this.jWQ.getString(R.l.dIO), true);
                } else if (com.tencent.mm.sdk.platformtools.bg.mA(zL.getProvince())) {
                    g.b(this.jWQ.uSU.uTo, this.jWQ.getString(R.l.dPw), this.jWQ.getString(R.l.dIO), true);
                } else {
                    Intent intent = new Intent().setClass(this.jWQ, BottleBeachUI.class);
                    intent.addFlags(67108864);
                    this.jWQ.startActivity(intent);
                    this.jWQ.finish();
                }
                return true;
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        Intent intent = new Intent().setClass(this, BottleWizardStep1.class);
        intent.addFlags(67108864);
        startActivity(intent);
        aHf();
        finish();
    }

    public void onResume() {
        super.onResume();
        this.jWP.update();
    }

    public void onPause() {
        super.onPause();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        if (str.equals("settings_district")) {
            return this.jWP.adE();
        }
        if (str.equals("settings_signature")) {
            return this.jWP.adD();
        }
        return false;
    }
}
