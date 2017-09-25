package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

abstract class l implements a, b {
    protected Context context;
    protected f isJ;
    protected x jiL;
    protected HelperHeaderPreference.a ouR;

    protected abstract int ON();

    protected abstract boolean aTD();

    protected abstract void clear();

    protected abstract void gk(boolean z);

    public l(Context context, HelperHeaderPreference.a aVar) {
        this.context = context;
        this.ouR = aVar;
    }

    public void a(int i, m mVar, Object obj) {
        int n = bg.n(obj, 0);
        w.d("MicroMsg.ContactWidgetPlugin", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(n), mVar});
        ap.yY();
        if (mVar != c.vr() || n <= 0) {
            w.e("MicroMsg.ContactWidgetPlugin", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(n), mVar});
        } else if (n == 40 || n == 34 || n == 7) {
            adH();
        }
    }

    public boolean a(f fVar, x xVar, boolean z, int i) {
        boolean z2;
        boolean z3 = false;
        Assert.assertTrue(xVar != null);
        if (bg.mz(xVar.field_username).length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        if (fVar != null) {
            z3 = true;
        }
        Assert.assertTrue(z3);
        ap.yY();
        c.vr().a(this);
        this.jiL = xVar;
        this.isJ = fVar;
        adH();
        return true;
    }

    public boolean adI() {
        ap.yY();
        c.vr().b(this);
        this.isJ.Td("contact_info_header_helper");
        return true;
    }

    public boolean sa(String str) {
        if ("contact_info_plugin_clear_data".equals(str)) {
            g.a(this.context, this.context.getString(R.l.dXP), "", this.context.getString(R.l.dGt), this.context.getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ l ouS;

                {
                    this.ouS = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.ouS.clear();
                }
            }, null);
            return true;
        } else if (str.equals("contact_info_plugin_install")) {
            gk(true);
            return true;
        } else if (str.equals("contact_info_plugin_uninstall")) {
            g.a(this.context, this.context.getString(R.l.eTH), "", this.context.getString(R.l.dGt), this.context.getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ l ouS;

                {
                    this.ouS = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.ouS.gk(false);
                }
            }, null);
            return true;
        } else {
            w.e("MicroMsg.ContactWidgetPlugin", "handleEvent : unexpected key = " + str);
            return false;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    private void adH() {
        this.isJ.removeAll();
        this.isJ.addPreferencesFromResource(ON());
        boolean aTD = aTD();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.isJ.Td("contact_info_header_helper");
        if (helperHeaderPreference != null) {
            helperHeaderPreference.a(this.jiL, this.ouR);
        }
        if (aTD) {
            this.isJ.Te("contact_info_plugin_install");
            return;
        }
        this.isJ.Te("contact_info_plugin_view");
        this.isJ.Te("contact_info_plugin_clear_data");
        this.isJ.Te("contact_info_plugin_uninstall");
    }
}
