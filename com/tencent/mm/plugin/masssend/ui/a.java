package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.ao.n;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
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
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.k;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class a implements com.tencent.mm.pluginsdk.d.a, b {
    public Context context;
    private f isJ;
    private Map<String, Preference> jWR = new HashMap();
    private x jiL;

    static class AnonymousClass3 extends ae {
        final /* synthetic */ boolean jWT;
        final /* synthetic */ k jWU = null;

        AnonymousClass3(boolean z, k kVar) {
            this.jWT = z;
        }

        public final void handleMessage(Message message) {
            int i;
            int xW = m.xW();
            if (this.jWT) {
                i = xW & -65537;
            } else {
                i = xW | 65536;
            }
            ap.yY();
            c.vr().set(34, Integer.valueOf(i));
            ap.yY();
            c.wQ().b(new n("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.jWT) {
                a.QZ();
            }
            if (this.jWU != null) {
                this.jWU.a(null, null);
            }
        }
    }

    public a(Context context) {
        this.context = context;
    }

    public final boolean sa(String str) {
        w.d("MicroMsg.ContactWidgetMassSend", "handleEvent : key = " + str);
        if (bg.mz(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_masssend_view")) {
            this.context.startActivity(new Intent(this.context, MassSendHistoryUI.class));
            return true;
        } else if (str.equals("contact_info_masssend_clear_data")) {
            g.a(this.context, this.context.getString(R.l.dXP), "", this.context.getString(R.l.dGt), this.context.getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ a nxf;

                {
                    this.nxf = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    a.QZ();
                }
            }, null);
            return true;
        } else if (str.equals("contact_info_masssend_install")) {
            g(this.context, true);
            return true;
        } else if (str.equals("contact_info_masssend_uninstall")) {
            g.a(this.context, this.context.getString(R.l.eTH), "", this.context.getString(R.l.dGt), this.context.getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ a nxf;

                {
                    this.nxf = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    a.g(this.nxf.context, false);
                }
            }, null);
            return true;
        } else {
            w.e("MicroMsg.ContactWidgetMassSend", "handleEvent : unExpected key = " + str);
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
        Assert.assertTrue(o.fe(xVar.field_username));
        ap.yY();
        c.vr().a(this);
        this.jiL = xVar;
        this.isJ = fVar;
        fVar.addPreferencesFromResource(R.o.ftu);
        adH();
        return true;
    }

    private void adH() {
        int i;
        boolean z;
        boolean z2 = true;
        boolean z3 = (m.xW() & 65536) == 0;
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.isJ.Td("contact_info_masssend_header_helper");
        helperHeaderPreference.Y(this.jiL.field_username, this.jiL.tL(), this.context.getString(R.l.dYJ));
        if (z3) {
            i = 1;
        } else {
            i = 0;
        }
        helperHeaderPreference.kg(i);
        this.isJ.aV("contact_info_masssend_install", z3);
        f fVar = this.isJ;
        String str = "contact_info_masssend_view";
        if (z3) {
            z = false;
        } else {
            z = true;
        }
        fVar.aV(str, z);
        fVar = this.isJ;
        str = "contact_info_masssend_clear_data";
        if (z3) {
            z = false;
        } else {
            z = true;
        }
        fVar.aV(str, z);
        f fVar2 = this.isJ;
        String str2 = "contact_info_masssend_uninstall";
        if (z3) {
            z2 = false;
        }
        fVar2.aV(str2, z2);
    }

    public static void g(Context context, boolean z) {
        String string = z ? context.getString(R.l.eTE) : context.getString(R.l.eTL);
        context.getString(R.l.dIO);
        final p a = g.a(context, string, true, null);
        final ae anonymousClass3 = new AnonymousClass3(z, null);
        new Timer().schedule(new TimerTask() {
            public final void run() {
                if (a != null) {
                    a.dismiss();
                    anonymousClass3.sendEmptyMessage(0);
                }
            }
        }, 1500);
    }

    public static void QZ() {
        com.tencent.mm.plugin.masssend.a.b aJt = h.aJt();
        if (aJt.hnH.eE("massendinfo", "delete from massendinfo")) {
            aJt.doNotify();
        }
        ap.yY();
        c.wW().Rl("masssendapp");
    }

    public final boolean adI() {
        ap.yY();
        c.vr().b(this);
        com.tencent.mm.plugin.masssend.a.imw.ou();
        return true;
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        int n = bg.n(obj, 0);
        w.d("MicroMsg.ContactWidgetMassSend", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(n), mVar});
        ap.yY();
        if (mVar != c.vr() || n <= 0) {
            w.e("MicroMsg.ContactWidgetMassSend", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(n), mVar});
        } else if (n == 40 || n == 34 || n == 7) {
            adH();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
