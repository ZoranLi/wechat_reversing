package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.ao.n;
import com.tencent.mm.bb.d;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.pluginsdk.d.a;
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
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.k;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class f implements a, b {
    public Context context;
    private com.tencent.mm.ui.base.preference.f isJ;
    private Map<String, Preference> jWR = new HashMap();
    private x jiL;
    private HelperHeaderPreference.a oun;

    static class AnonymousClass2 extends ae {
        final /* synthetic */ boolean jWT;
        final /* synthetic */ k jWU = null;

        AnonymousClass2(boolean z, k kVar) {
            this.jWT = z;
        }

        public final void handleMessage(Message message) {
            int i;
            int xW = m.xW();
            if (this.jWT) {
                i = xW & -8193;
            } else {
                i = xW | 8192;
            }
            ap.yY();
            c.vr().set(34, Integer.valueOf(i));
            ap.yY();
            c.wQ().b(new n("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.jWT) {
                af.FZ().Fe();
                ap.yY();
                c.vr().set(65828, "");
                ap.yY();
                c.wW().Rl("facebookapp");
                ap.yY();
                c.wT().Ao("facebookapp");
            }
            if (this.jWU != null) {
                this.jWU.a(null, null);
            }
        }
    }

    public f(Context context) {
        this.context = context;
        this.oun = new p(context);
        ap.yY();
        c.wW().Ro("facebookapp");
    }

    public final boolean sa(String str) {
        w.d("MicroMsg.ContactWidgetFacebookapp", "handleEvent : key = " + str);
        if (bg.mz(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_facebookapp_install")) {
            g(this.context, true);
            return true;
        } else if (str.equals("contact_info_facebookapp_uninstall")) {
            g.a(this.context, this.context.getString(R.l.eTH), "", this.context.getString(R.l.dGt), this.context.getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ f ouo;

                {
                    this.ouo = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    f.g(this.ouo.context, false);
                }
            }, null);
            return true;
        } else if (str.equals("contact_info_facebookapp_listfriend")) {
            d.b(this.context, "", "com.tencent.mm.ui.account.FacebookFriendUI", new Intent());
            return true;
        } else if (str.equals("contact_info_facebookapp_connect")) {
            d.a(this.context, ".ui.account.FacebookAuthUI", new Intent());
            return true;
        } else if (str.equals("contact_info_facebookapp_addr")) {
            d.a(this.context, ".ui.account.FacebookAuthUI", new Intent());
            return true;
        } else if (str.equals("contact_info_facebookapp_showqrcode")) {
            Intent intent = new Intent();
            intent.putExtra("show_to", 4);
            com.tencent.mm.plugin.profile.a.imv.p(intent, this.context);
            return true;
        } else {
            w.e("MicroMsg.ContactWidgetFacebookapp", "handleEvent : unExpected key = " + str);
            return false;
        }
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, x xVar, boolean z, int i) {
        boolean z2 = false;
        Assert.assertTrue(fVar != null);
        if (xVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(o.fd(xVar.field_username));
        ap.yY();
        c.vr().a(this);
        this.jiL = xVar;
        this.isJ = fVar;
        fVar.addPreferencesFromResource(R.o.fto);
        Preference Td = fVar.Td("contact_info_header_helper");
        if (Td != null) {
            this.jWR.put("contact_info_header_helper", Td);
        }
        Td = fVar.Td("contact_info_facebookapp_listfriend");
        if (Td != null) {
            this.jWR.put("contact_info_facebookapp_listfriend", Td);
        }
        Td = fVar.Td("contact_info_facebookapp_connect");
        if (Td != null) {
            this.jWR.put("contact_info_facebookapp_connect", Td);
        }
        PreferenceCategory preferenceCategory = (PreferenceCategory) fVar.Td("contact_info_facebookapp_cat");
        if (preferenceCategory != null) {
            this.jWR.put("contact_info_facebookapp_cat", preferenceCategory);
        }
        Td = fVar.Td("contact_info_facebookapp_addr");
        if (Td != null) {
            this.jWR.put("contact_info_facebookapp_addr", Td);
        }
        Td = fVar.Td("contact_info_facebookapp_showqrcode");
        if (Td != null) {
            this.jWR.put("contact_info_facebookapp_showqrcode", Td);
        }
        preferenceCategory = (PreferenceCategory) fVar.Td("contact_info_facebookapp_cat2");
        if (preferenceCategory != null) {
            this.jWR.put("contact_info_facebookapp_cat2", preferenceCategory);
        }
        Td = fVar.Td("contact_info_facebookapp_install");
        if (Td != null) {
            this.jWR.put("contact_info_facebookapp_install", Td);
        }
        Td = fVar.Td("contact_info_facebookapp_uninstall");
        if (Td != null) {
            this.jWR.put("contact_info_facebookapp_uninstall", Td);
        }
        adH();
        return true;
    }

    private void adH() {
        this.isJ.removeAll();
        if (this.jWR.containsKey("contact_info_header_helper")) {
            HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.jWR.get("contact_info_header_helper");
            helperHeaderPreference.a(this.jiL, this.oun);
            this.isJ.a(helperHeaderPreference);
        }
        if (this.jWR.containsKey("contact_info_facebookapp_cat")) {
            this.isJ.a((Preference) this.jWR.get("contact_info_facebookapp_cat"));
        }
        if (((m.xW() & 8192) == 0 ? 1 : null) != null) {
            if (m.ym()) {
                if (this.jWR.containsKey("contact_info_facebookapp_addr")) {
                    this.isJ.a((Preference) this.jWR.get("contact_info_facebookapp_addr"));
                    Preference preference = (Preference) this.jWR.get("contact_info_facebookapp_addr");
                    ap.yY();
                    preference.setSummary((String) c.vr().get(65826, null));
                }
                if (this.jWR.containsKey("contact_info_facebookapp_showqrcode")) {
                    this.isJ.a((Preference) this.jWR.get("contact_info_facebookapp_showqrcode"));
                }
            } else if (this.jWR.containsKey("contact_info_facebookapp_connect")) {
                this.isJ.a((Preference) this.jWR.get("contact_info_facebookapp_connect"));
            }
            if (this.jWR.containsKey("contact_info_facebookapp_cat2")) {
                this.isJ.a((Preference) this.jWR.get("contact_info_facebookapp_cat2"));
            }
            if (this.jWR.containsKey("contact_info_facebookapp_uninstall")) {
                this.isJ.a((Preference) this.jWR.get("contact_info_facebookapp_uninstall"));
            }
        } else if (this.jWR.containsKey("contact_info_facebookapp_install")) {
            this.isJ.a((Preference) this.jWR.get("contact_info_facebookapp_install"));
        }
    }

    public static void g(Context context, boolean z) {
        String string = z ? context.getString(R.l.eTE) : context.getString(R.l.eTL);
        context.getString(R.l.dIO);
        final p a = g.a(context, string, true, null);
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
        this.jWR.get("contact_info_header_helper");
        com.tencent.mm.plugin.profile.a.imw.ou();
        return true;
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        int n = bg.n(obj, 0);
        w.d("MicroMsg.ContactWidgetFacebookapp", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(n), mVar});
        ap.yY();
        if (mVar != c.vr() || n <= 0) {
            w.e("MicroMsg.ContactWidgetFacebookapp", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(n), mVar});
        } else if (n == 40 || n == 34 || n == 65825) {
            adH();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
