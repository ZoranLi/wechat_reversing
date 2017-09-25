package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.ao.n;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.k;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class j implements a, b {
    public static boolean jWp = false;
    public Context context;
    private f isJ;
    private x jiL;

    static class AnonymousClass4 extends ae {
        final /* synthetic */ boolean jWT;
        final /* synthetic */ k jWU = null;
        final /* synthetic */ Context val$context;

        AnonymousClass4(boolean z, Context context, k kVar) {
            this.jWT = z;
            this.val$context = context;
        }

        public final void handleMessage(Message message) {
            int i;
            if (this.jWT) {
                j.gl(true);
            }
            int xW = m.xW();
            if (this.jWT) {
                i = xW & -17;
            } else {
                i = xW | 16;
            }
            ap.yY();
            c.vr().set(34, Integer.valueOf(i));
            ap.yY();
            c.wQ().b(new n("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.jWT) {
                j.cI(this.val$context);
            }
            if (this.jWU != null) {
                this.jWU.a(null, null);
            }
        }
    }

    public j(Context context) {
        this.context = context;
    }

    public final boolean sa(String str) {
        w.d("MicroMsg.ContactWidgetMediaNote", "handleEvent : key = " + str);
        if (bg.mz(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_medianote_view")) {
            Intent intent = new Intent();
            intent.putExtra("Chat_User", "medianote");
            com.tencent.mm.plugin.profile.a.imv.e(intent, this.context);
            com.tencent.mm.plugin.profile.a.imw.ou();
            return true;
        } else if (str.equals("contact_info_medianote_sync_to_qqmail")) {
            if (m.ys()) {
                gl(((CheckBoxPreference) this.isJ.Td(str)).isChecked());
            } else {
                g.a(this.context, R.l.dYL, R.l.dYK, new OnClickListener(this) {
                    final /* synthetic */ j ouw;

                    {
                        this.ouw = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.plugin.profile.a.imv.h(new Intent(), this.ouw.context);
                    }
                }, null);
                adH();
            }
            return true;
        } else if (str.equals("contact_info_medianote_clear_data")) {
            g.a(this.context, this.context.getString(R.l.dXP), "", this.context.getString(R.l.dGt), this.context.getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ j ouw;

                {
                    this.ouw = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    j.cI(this.ouw.context);
                }
            }, null);
            return true;
        } else if (str.equals("contact_info_medianote_install")) {
            g(this.context, true);
            return true;
        } else if (str.equals("contact_info_medianote_uninstall")) {
            g.a(this.context, this.context.getString(R.l.eTH), "", this.context.getString(R.l.dGt), this.context.getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ j ouw;

                {
                    this.ouw = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    j.g(this.ouw.context, false);
                }
            }, null);
            return true;
        } else {
            w.e("MicroMsg.ContactWidgetMediaNote", "handleEvent : unExpected key = " + str);
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
        Assert.assertTrue(o.fk(xVar.field_username));
        ap.yY();
        c.vr().a(this);
        this.jiL = xVar;
        this.isJ = fVar;
        fVar.addPreferencesFromResource(R.o.ftv);
        adH();
        return true;
    }

    private void adH() {
        boolean z;
        int i;
        boolean z2;
        boolean z3 = true;
        boolean z4 = (m.xW() & 16) == 0;
        int xP = m.xP();
        if (m.ys()) {
            z = (xP & 16384) != 0;
        } else {
            if ((xP & 16384) != 0) {
                xP &= -16385;
                ap.yY();
                c.vr().set(7, Integer.valueOf(xP));
            }
            z = false;
        }
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.isJ.Td("contact_info_header_helper");
        helperHeaderPreference.Y(this.jiL.field_username, this.jiL.tL(), this.context.getString(R.l.dYM));
        if (z4) {
            i = 1;
        } else {
            i = 0;
        }
        helperHeaderPreference.kg(i);
        this.isJ.aV("contact_info_medianote_install", z4);
        f fVar = this.isJ;
        String str = "contact_info_medianote_view";
        if (z4) {
            z2 = false;
        } else {
            z2 = true;
        }
        fVar.aV(str, z2);
        if (!z4 || m.ys()) {
            z2 = z4;
        } else {
            if (bg.getInt(com.tencent.mm.i.g.sV().getValue("BindQQSwitch"), 1) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            w.i("MicroMsg.ContactWidgetMediaNote", "summerqq BindQQSwitch off");
        }
        fVar = this.isJ;
        str = "contact_info_medianote_sync_to_qqmail";
        if (z2) {
            z2 = false;
        } else {
            z2 = true;
        }
        fVar.aV(str, z2);
        fVar = this.isJ;
        str = "contact_info_medianote_clear_data";
        if (z4) {
            z2 = false;
        } else {
            z2 = true;
        }
        fVar.aV(str, z2);
        f fVar2 = this.isJ;
        String str2 = "contact_info_medianote_uninstall";
        if (z4) {
            z3 = false;
        }
        fVar2.aV(str2, z3);
        ((CheckBoxPreference) this.isJ.Td("contact_info_medianote_sync_to_qqmail")).vqm = z;
    }

    public static void g(Context context, boolean z) {
        String string = z ? context.getString(R.l.eTE) : context.getString(R.l.eTL);
        context.getString(R.l.dIO);
        final p a = g.a(context, string, true, null);
        final ae anonymousClass4 = new AnonymousClass4(z, context, null);
        new Timer().schedule(new TimerTask() {
            public final void run() {
                if (a != null) {
                    a.dismiss();
                    anonymousClass4.sendEmptyMessage(0);
                }
            }
        }, 1500);
    }

    public static void cI(Context context) {
        jWp = false;
        context.getString(R.l.dIO);
        final p a = g.a(context, context.getString(R.l.dJd), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                j.jWp = true;
            }
        });
        ay.a("medianote", new ay.a() {
            public final boolean zs() {
                return j.jWp;
            }

            public final void zr() {
                if (a != null) {
                    a.dismiss();
                }
            }
        });
        ap.yY();
        c.wW().Rl("medianote");
    }

    public final boolean adI() {
        ap.yY();
        c.vr().b(this);
        com.tencent.mm.plugin.profile.a.imw.ou();
        return true;
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        int n = bg.n(obj, 0);
        w.d("MicroMsg.ContactWidgetMediaNote", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(n), mVar});
        ap.yY();
        if (mVar != c.vr() || n <= 0) {
            w.e("MicroMsg.ContactWidgetMediaNote", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(n), mVar});
        } else if (n == 40 || n == 34 || n == 7) {
            adH();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    static void gl(boolean z) {
        int xP = m.xP();
        if (z) {
            xP |= 16384;
        } else {
            xP &= -16385;
        }
        ap.yY();
        c.vr().set(7, Integer.valueOf(xP));
        xP = z ? 1 : 2;
        ap.yY();
        c.wQ().b(new com.tencent.mm.ao.g(13, xP));
    }
}
