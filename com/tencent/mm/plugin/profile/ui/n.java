package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ae;
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
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class n implements a, b {
    public Context context;
    private f isJ;
    private x jiL;

    static class AnonymousClass2 extends ae {
        final /* synthetic */ boolean jWT;
        final /* synthetic */ k jWU = null;

        AnonymousClass2(boolean z, k kVar) {
            this.jWT = z;
        }

        public final void handleMessage(Message message) {
            int xW = m.xW();
            if (this.jWT) {
                xW &= -33554433;
            } else {
                xW |= 33554432;
            }
            ap.yY();
            c.vr().set(34, Integer.valueOf(xW));
            com.tencent.mm.bd.a com_tencent_mm_protocal_c_aqr = new aqr();
            com_tencent_mm_protocal_c_aqr.tdB = 33554432;
            com_tencent_mm_protocal_c_aqr.tVo = this.jWT ? 0 : 1;
            ap.yY();
            c.wQ().b(new e.a(39, com_tencent_mm_protocal_c_aqr));
            if (this.jWU != null) {
                this.jWU.a(null, null);
            }
        }
    }

    public n(Context context) {
        this.context = context;
    }

    public final boolean sa(String str) {
        w.d("MicroMsg.ContactWidgetVoiceInput", "handleEvent : key = " + str);
        if (bg.mz(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_voiceinput_install")) {
            g(this.context, true);
            return true;
        } else if (str.equals("contact_info_voiceinput_uninstall")) {
            g.a(this.context, this.context.getString(R.l.eTH), "", this.context.getString(R.l.dGt), this.context.getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ n ouV;

                {
                    this.ouV = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    n.g(this.ouV.context, false);
                }
            }, null);
            return true;
        } else {
            w.e("MicroMsg.ContactWidgetVoiceInput", "handleEvent : unExpected key = " + str);
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
        Assert.assertTrue(o.fo(xVar.field_username));
        ap.yY();
        c.vr().a(this);
        this.jiL = xVar;
        this.isJ = fVar;
        fVar.addPreferencesFromResource(R.o.ftE);
        adH();
        return true;
    }

    private void adH() {
        int i;
        boolean z = true;
        boolean z2 = (m.xW() & 33554432) == 0;
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.isJ.Td("contact_info_header_helper");
        helperHeaderPreference.Y(this.jiL.field_username, this.jiL.tL(), this.context.getString(R.l.eaq));
        if (z2) {
            i = 1;
        } else {
            i = 0;
        }
        helperHeaderPreference.kg(i);
        this.isJ.aV("contact_info_voiceinput_install", z2);
        f fVar = this.isJ;
        String str = "contact_info_voiceinput_uninstall";
        if (z2) {
            z = false;
        }
        fVar.aV(str, z);
    }

    public static void g(Context context, boolean z) {
        String string = z ? context.getString(R.l.eTE) : context.getString(R.l.eTL);
        context.getString(R.l.dIO);
        final ProgressDialog a = g.a(context, string, true, null);
        final ae anonymousClass2 = new AnonymousClass2(z, null);
        new Timer().schedule(new TimerTask() {
            public final void run() {
                if (a != null) {
                    a.dismiss();
                    anonymousClass2.sendEmptyMessage(0);
                }
            }
        }, 1500);
    }

    public final boolean adI() {
        ap.yY();
        c.vr().b(this);
        com.tencent.mm.plugin.profile.a.imw.ou();
        return true;
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        int n = bg.n(obj, 0);
        w.d("MicroMsg.ContactWidgetVoiceInput", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(n), mVar});
        ap.yY();
        if (mVar != c.vr() || n <= 0) {
            w.e("MicroMsg.ContactWidgetVoiceInput", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(n), mVar});
        } else if (n == 40 || n == 34 || n == 7) {
            adH();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
