package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.k;
import junit.framework.Assert;

public final class i implements a, b {
    public Context context;
    private f isJ;
    private x jiL;
    private HelperHeaderPreference.a ouu;

    static class AnonymousClass2 implements aj.a {
        final /* synthetic */ boolean jWT;
        final /* synthetic */ k jWU = null;
        final /* synthetic */ ProgressDialog kEW;

        AnonymousClass2(ProgressDialog progressDialog, boolean z, k kVar) {
            this.kEW = progressDialog;
            this.jWT = z;
        }

        public final boolean oQ() {
            if (this.kEW != null) {
                this.kEW.dismiss();
            }
            int xW = m.xW();
            if (this.jWT) {
                xW &= -16777217;
            } else {
                xW |= 16777216;
                ap.yY();
                c.vr().set(286722, "");
                ap.yY();
                c.vr().set(286721, "");
                ap.yY();
                c.vr().set(286723, "");
            }
            ap.yY();
            c.vr().set(34, Integer.valueOf(xW));
            com.tencent.mm.bd.a com_tencent_mm_protocal_c_aqr = new aqr();
            com_tencent_mm_protocal_c_aqr.tdB = 16777216;
            com_tencent_mm_protocal_c_aqr.tVo = this.jWT ? 0 : 1;
            ap.yY();
            c.wQ().b(new e.a(39, com_tencent_mm_protocal_c_aqr));
            if (this.jWU != null) {
                this.jWU.a(null, null);
            }
            return false;
        }
    }

    public i(Context context) {
        this.context = context;
        this.ouu = new r(context);
    }

    public final boolean sa(String str) {
        w.d("MicroMsg.ContactWidgetLinkedIn", "handleEvent : key = " + str);
        if (bg.mz(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_linkedin_install")) {
            g(this.context, true);
            return true;
        } else if (str.equals("contact_info_linkedin_uninstall")) {
            g.a(this.context, this.context.getString(R.l.eTH), "", this.context.getString(R.l.dGt), this.context.getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ i ouv;

                {
                    this.ouv = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    i.g(this.ouv.context, false);
                }
            }, null);
            return true;
        } else {
            if (str.equals("contact_info_linkedin_account")) {
                d.b(this.context, "accountsync", "com.tencent.mm.ui.bindlinkedin.BindLinkedInUI", 1);
            }
            w.e("MicroMsg.ContactWidgetLinkedIn", "handleEvent : unExpected key = " + str);
            return false;
        }
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        boolean z2 = false;
        Assert.assertTrue(fVar != null);
        if (xVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(o.fp(xVar.field_username));
        ap.yY();
        c.vr().a(this);
        this.jiL = xVar;
        this.isJ = fVar;
        adH();
        return true;
    }

    private void adH() {
        boolean z = (m.xW() & 16777216) == 0;
        this.isJ.removeAll();
        this.isJ.addPreferencesFromResource(R.o.ftt);
        ((HelperHeaderPreference) this.isJ.Td("contact_info_header_helper")).a(this.jiL, this.ouu);
        if (z) {
            this.isJ.aV("contact_info_linkedin_account", false);
            this.isJ.Te("contact_info_linkedin_install");
            return;
        }
        this.isJ.aV("contact_info_linkedin_account", true);
        this.isJ.Te("contact_info_linkedin_uninstall");
    }

    public static void g(Context context, boolean z) {
        String string = z ? context.getString(R.l.eTE) : context.getString(R.l.eTL);
        context.getString(R.l.dIO);
        new aj(new AnonymousClass2(g.a(context, string, true, null), z, null), false).v(1500, 1500);
    }

    public final boolean adI() {
        ap.yY();
        c.vr().b(this);
        this.isJ.Td("contact_info_header_helper");
        com.tencent.mm.plugin.profile.a.imw.ou();
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            adH();
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            if (intValue == 40 || intValue == 34) {
                adH();
            }
        }
    }
}
