package com.tencent.mm.plugin.qmessage.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.ao.n;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.k;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class b implements a, com.tencent.mm.sdk.e.m.b {
    public Context context;
    private f isJ;
    private x jiL;
    private boolean osM;

    static class AnonymousClass7 extends ae {
        final /* synthetic */ boolean jWT;
        final /* synthetic */ k jWU = null;

        AnonymousClass7(boolean z, k kVar) {
            this.jWT = z;
        }

        public final void handleMessage(Message message) {
            int i;
            b.c(64, this.jWT, 5);
            b.c(8192, this.jWT, 12);
            int xW = m.xW();
            if (this.jWT) {
                i = xW & -33;
            } else {
                i = xW | 32;
            }
            ap.yY();
            c.vr().set(34, Integer.valueOf(i));
            ap.yY();
            c.wQ().b(new n("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.jWT) {
                g.aUg();
            }
            if (this.jWU != null) {
                this.jWU.a(null, null);
            }
        }
    }

    public b(Context context) {
        this.context = context;
    }

    public final boolean sa(String str) {
        w.d("MicroMsg.ContactWidgetQMessage", "handleEvent : key = " + str);
        if (bg.mz(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_view_message")) {
            Intent intent = new Intent(this.context, QConversationUI.class);
            if (this.osM) {
                ((Activity) this.context).setResult(-1, intent);
            } else {
                this.context.startActivity(intent);
            }
            ((Activity) this.context).finish();
            return true;
        } else if (str.equals("contact_info_qmessage_recv_offline_msg")) {
            final CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.isJ.Td(str);
            if (checkBoxPreference.isChecked()) {
                c(64, true, 5);
            } else if (rz(8192)) {
                com.tencent.mm.ui.base.g.a(this.context, R.l.dYY, R.l.dIO, new OnClickListener(this) {
                    final /* synthetic */ b oyR;

                    {
                        this.oyR = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        b.c(8192, false, 12);
                        b.c(64, false, 5);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ b oyR;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        checkBoxPreference.vqm = true;
                        this.oyR.adH();
                    }
                });
            } else {
                c(64, false, 5);
                return true;
            }
            return true;
        } else if (str.equals("contact_info_qmessage_display_weixin_online")) {
            c(8192, ((CheckBoxPreference) this.isJ.Td(str)).isChecked(), 12);
            return true;
        } else if (str.equals("contact_info_qmessage_clear_data")) {
            com.tencent.mm.ui.base.g.a(this.context, this.context.getString(R.l.dXP), "", this.context.getString(R.l.dGt), this.context.getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ b oyR;

                {
                    this.oyR = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    g.aUg();
                }
            }, null);
            return true;
        } else if (str.equals("contact_info_qmessage_install")) {
            ap.yY();
            if (bg.f((Integer) c.vr().get(9, null)) == 0) {
                com.tencent.mm.ui.base.g.b(this.context, R.l.eUS, R.l.dIO, new OnClickListener(this) {
                    final /* synthetic */ b oyR;

                    {
                        this.oyR = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        d.a(this.oyR.context, "accountsync", "com.tencent.mm.ui.bindqq.BindQQUI", null);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ b oyR;

                    {
                        this.oyR = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            }
            g(this.context, true);
            return true;
        } else if (str.equals("contact_info_qmessage_uninstall")) {
            com.tencent.mm.ui.base.g.a(this.context, this.context.getString(R.l.eTH), "", this.context.getString(R.l.dGt), this.context.getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ b oyR;

                {
                    this.oyR = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    b.g(this.oyR.context, false);
                }
            }, null);
            return true;
        } else {
            w.e("MicroMsg.ContactWidgetQMessage", "handleEvent : unExpected key = " + str);
            return false;
        }
    }

    public static void g(Context context, boolean z) {
        String string = z ? context.getString(R.l.eTE) : context.getString(R.l.eTL);
        context.getString(R.l.dIO);
        final ProgressDialog a = com.tencent.mm.ui.base.g.a(context, string, true, null);
        final ae anonymousClass7 = new AnonymousClass7(z, null);
        new Timer().schedule(new TimerTask() {
            public final void run() {
                if (a != null) {
                    a.dismiss();
                    anonymousClass7.sendEmptyMessage(0);
                }
            }
        }, 5000);
    }

    private static boolean rz(int i) {
        return (m.xP() & i) != 0;
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        boolean z2 = false;
        Assert.assertTrue(xVar != null);
        Assert.assertTrue(o.fc(xVar.field_username));
        if (fVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        ap.yY();
        c.vr().a(this);
        this.jiL = xVar;
        this.osM = z;
        this.isJ = fVar;
        adH();
        return true;
    }

    public final void adH() {
        int i = 1;
        int i2 = (m.xW() & 32) == 0 ? 1 : 0;
        boolean rz = rz(64);
        rz(8192);
        this.isJ.removeAll();
        this.isJ.addPreferencesFromResource(R.o.fty);
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.isJ.Td("contact_info_header_helper");
        helperHeaderPreference.Y(this.jiL.field_username, this.jiL.tL(), this.context.getString(R.l.dYZ));
        if (i2 == 0) {
            i = 0;
        }
        helperHeaderPreference.kg(i);
        if (i2 == 0) {
            this.isJ.Te("contact_info_view_message");
            this.isJ.Te("contact_info_qmessage_recv_offline_msg");
            this.isJ.Te("contact_info_qmessage_uninstall");
            this.isJ.Te("contact_info_qmessage_clear_data");
            return;
        }
        this.isJ.Te("contact_info_qmessage_install");
        ((CheckBoxPreference) this.isJ.Td("contact_info_qmessage_recv_offline_msg")).vqm = rz;
    }

    public static void c(int i, boolean z, int i2) {
        int xP = m.xP();
        if (z) {
            xP |= i;
        } else {
            xP &= i ^ -1;
        }
        ap.yY();
        c.vr().set(7, Integer.valueOf(xP));
        xP = z ? 1 : 2;
        ap.yY();
        c.wQ().b(new com.tencent.mm.ao.g(i2, xP));
    }

    public final boolean adI() {
        ap.yY();
        c.vr().b(this);
        com.tencent.mm.plugin.qmessage.a.oyy.ou();
        return true;
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        ap.yY();
        if (mVar == c.vr()) {
            adH();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
