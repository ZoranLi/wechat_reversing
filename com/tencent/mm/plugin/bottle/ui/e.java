package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.ao.g;
import com.tencent.mm.ao.n;
import com.tencent.mm.plugin.bottle.a.i;
import com.tencent.mm.pluginsdk.d.a;
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
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.k;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class e implements a, b {
    public final Context context;
    private boolean fFU;
    private f isJ;
    private final Map<String, Preference> jWR = new HashMap();
    private x jiL;
    private int status;

    static class AnonymousClass3 extends ae {
        final /* synthetic */ boolean jWT;
        final /* synthetic */ k jWU = null;

        AnonymousClass3(boolean z, k kVar) {
            this.jWT = z;
        }

        public final void handleMessage(Message message) {
            int i;
            int i2;
            boolean z = this.jWT;
            int xP = m.xP();
            int xW = m.xW();
            if (z) {
                i = xP | Downloads.RECV_BUFFER_SIZE;
                i2 = xW & -65;
                ap.yY();
                c.wQ().b(new g(11, 1));
            } else {
                i = xP & -4097;
                i2 = xW | 64;
                ap.yY();
                c.wQ().b(new g(11, 2));
            }
            ap.yY();
            c.vr().set(7, Integer.valueOf(i));
            ap.yY();
            c.vr().set(34, Integer.valueOf(i2));
            ap.yY();
            c.wQ().b(new n("", "", "", "", "", "", "", "", i2, "", ""));
            if (!this.jWT) {
                i.adx();
            }
            if (this.jWU != null) {
                this.jWU.a(null, null);
            }
        }
    }

    public e(Context context) {
        this.context = context;
    }

    public final boolean sa(String str) {
        w.d("MicroMsg.ContactWidgetFloatBottle", "handleEvent : key = " + str);
        if (bg.mz(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_goto_floatbottle")) {
            com.tencent.mm.u.bg zL = com.tencent.mm.u.bg.zL();
            if (bg.a(Integer.valueOf(zL.gkr), 0) <= 0 || bg.mA(zL.getProvince())) {
                this.context.startActivity(new Intent(this.context, BottleWizardStep1.class));
            } else {
                this.context.startActivity(new Intent(this.context, BottleBeachUI.class));
            }
            return true;
        } else if (str.equals("contact_info_floatbottle_clear_data")) {
            com.tencent.mm.ui.base.g.a(this.context, this.context.getString(R.l.dXP), "", this.context.getString(R.l.dGt), this.context.getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ e jWS;

                {
                    this.jWS = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    i.adx();
                }
            }, null);
            return true;
        } else if (str.equals("contact_info_floatbottle_install")) {
            g(this.context, true);
            return true;
        } else if (str.equals("contact_info_floatbottle_uninstall")) {
            com.tencent.mm.ui.base.g.a(this.context, this.context.getString(R.l.eTH), "", this.context.getString(R.l.dGt), this.context.getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ e jWS;

                {
                    this.jWS = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    e.g(this.jWS.context, false);
                }
            }, null);
            return true;
        } else {
            w.e("MicroMsg.ContactWidgetFloatBottle", "handleEvent : unExpected key = " + str);
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
        Assert.assertTrue(o.fb(xVar.field_username));
        ap.yY();
        c.vr().a(this);
        this.jiL = xVar;
        this.isJ = fVar;
        fVar.addPreferencesFromResource(R.o.ftq);
        Preference Td = fVar.Td("contact_info_header_helper");
        if (Td != null) {
            this.jWR.put("contact_info_header_helper", Td);
        }
        Td = fVar.Td("contact_info_goto_floatbottle");
        if (Td != null) {
            this.jWR.put("contact_info_goto_floatbottle", Td);
        }
        PreferenceCategory preferenceCategory = (PreferenceCategory) fVar.Td("contact_info_floatbottle_hide_cat");
        if (preferenceCategory != null) {
            this.jWR.put("contact_info_floatbottle_hide_cat", preferenceCategory);
        }
        Td = fVar.Td("contact_info_floatbottle_clear_data");
        if (Td != null) {
            this.jWR.put("contact_info_floatbottle_clear_data", Td);
        }
        preferenceCategory = (PreferenceCategory) fVar.Td("contact_info_floatbottle_hide_cat2");
        if (preferenceCategory != null) {
            this.jWR.put("contact_info_floatbottle_hide_cat2", preferenceCategory);
        }
        preferenceCategory = (PreferenceCategory) fVar.Td("contact_info_floatbottle_hide_cat3");
        if (preferenceCategory != null) {
            this.jWR.put("contact_info_floatbottle_hide_cat3", preferenceCategory);
        }
        Td = fVar.Td("contact_info_floatbottle_install");
        if (Td != null) {
            this.jWR.put("contact_info_floatbottle_install", Td);
        }
        Td = fVar.Td("contact_info_floatbottle_uninstall");
        if (Td != null) {
            this.jWR.put("contact_info_floatbottle_uninstall", Td);
        }
        adH();
        return true;
    }

    private void adH() {
        int i = 1;
        this.status = m.xP();
        this.fFU = (m.xW() & 64) == 0;
        this.isJ.removeAll();
        if (this.jWR.containsKey("contact_info_header_helper")) {
            this.isJ.a((HelperHeaderPreference) this.jWR.get("contact_info_header_helper"));
            HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.isJ.Td("contact_info_header_helper");
            helperHeaderPreference.Y(this.jiL.field_username, this.jiL.tL(), this.context.getString(R.l.dYn));
            if (!this.fFU) {
                i = 0;
            }
            helperHeaderPreference.kg(i);
        }
        if (this.jWR.containsKey("contact_info_floatbottle_hide_cat")) {
            this.isJ.a((Preference) this.jWR.get("contact_info_floatbottle_hide_cat"));
        }
        if (this.fFU) {
            if (this.jWR.containsKey("contact_info_goto_floatbottle")) {
                this.isJ.a((Preference) this.jWR.get("contact_info_goto_floatbottle"));
            }
            if (this.jWR.containsKey("contact_info_floatbottle_clear_data")) {
                this.isJ.a((Preference) this.jWR.get("contact_info_floatbottle_clear_data"));
            }
            if (this.jWR.containsKey("contact_info_floatbottle_hide_cat2")) {
                this.isJ.a((Preference) this.jWR.get("contact_info_floatbottle_hide_cat2"));
            }
            if (this.jWR.containsKey("contact_info_floatbottle_uninstall")) {
                this.isJ.a((Preference) this.jWR.get("contact_info_floatbottle_uninstall"));
            }
        } else if (this.jWR.containsKey("contact_info_floatbottle_install")) {
            this.isJ.a((Preference) this.jWR.get("contact_info_floatbottle_install"));
        }
    }

    public static void g(Context context, boolean z) {
        String string = z ? context.getString(R.l.eTE) : context.getString(R.l.eTL);
        context.getString(R.l.dIO);
        final p a = com.tencent.mm.ui.base.g.a(context, string, true, null);
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

    public final boolean adI() {
        ap.yY();
        c.vr().b(this);
        com.tencent.mm.plugin.bottle.a.imw.ou();
        return true;
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        int n = bg.n(obj, 0);
        w.d("MicroMsg.ContactWidgetFloatBottle", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(n), mVar});
        ap.yY();
        if (mVar != c.vr() || n <= 0) {
            w.e("MicroMsg.ContactWidgetFloatBottle", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(n), mVar});
        } else if (n == 40 || n == 34 || n == 7) {
            adH();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
