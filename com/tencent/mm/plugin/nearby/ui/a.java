package com.tencent.mm.plugin.nearby.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mm.R;
import com.tencent.mm.ao.n;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.mm.plugin.nearby.a.c;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.k;
import com.tencent.mm.y.e;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class a implements com.tencent.mm.pluginsdk.d.a, b, e {
    private static boolean nVX = true;
    public Context context;
    public p irJ;
    private f isJ;
    private x jiL;
    public c nVU;
    private View nVV;
    public CheckBox nVW;
    private h nVY = null;

    static class AnonymousClass6 extends ae {
        final /* synthetic */ boolean jWT;
        final /* synthetic */ k jWU = null;

        AnonymousClass6(boolean z, k kVar) {
            this.jWT = z;
        }

        public final void handleMessage(Message message) {
            int i;
            int xW = m.xW();
            if (this.jWT) {
                i = xW & -513;
            } else {
                i = xW | 512;
            }
            ap.yY();
            com.tencent.mm.u.c.vr().set(34, Integer.valueOf(i));
            ap.yY();
            com.tencent.mm.u.c.wQ().b(new n("", "", "", "", "", "", "", "", i, "", ""));
            if (!this.jWT) {
                com.tencent.mm.plugin.nearby.a.f.aOG();
            }
            if (this.jWU != null) {
                this.jWU.a(null, null);
            }
        }
    }

    public a(Context context) {
        this.context = context;
        this.nVV = View.inflate(context, R.i.dgJ, null);
        this.nVW = (CheckBox) this.nVV.findViewById(R.h.caW);
        this.nVW.setChecked(false);
        ap.vd().a(JsApiScanCode.CTRL_INDEX, this);
    }

    public final boolean sa(String str) {
        w.d("MicroMsg.ContactWidgetLBS", "handleEvent : key = " + str);
        if (bg.mz(str).length() <= 0) {
            return false;
        }
        if (str.equals("contact_info_lbs_go_lbs")) {
            ap.yY();
            Boolean bool = (Boolean) com.tencent.mm.u.c.vr().get(4103, null);
            if (bool == null || !bool.booleanValue()) {
                d.w(this.context, "nearby", ".ui.NearbyFriendsIntroUI");
            } else {
                com.tencent.mm.u.bg zM = com.tencent.mm.u.bg.zM();
                if (zM == null) {
                    d.w(this.context, "nearby", ".ui.NearbyPersonalInfoUI");
                } else {
                    String mz = bg.mz(zM.getProvince());
                    String mz2 = bg.mz(zM.getCity());
                    int i = zM.gkr;
                    if (mz.equals("") || mz2.equals("") || i == 0) {
                        d.w(this.context, "nearby", ".ui.NearbyPersonalInfoUI");
                    } else {
                        ap.yY();
                        bool = (Boolean) com.tencent.mm.u.c.vr().get(4104, null);
                        if (bool == null || !bool.booleanValue()) {
                            com.tencent.mm.az.a.dl(this.context);
                            ((Activity) this.context).finish();
                        } else if (this.nVY == null) {
                            this.nVY = g.a(this.context, this.context.getString(R.l.dIO), this.nVV, new OnClickListener(this) {
                                final /* synthetic */ a nVZ;

                                {
                                    this.nVZ = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    ap.yY();
                                    com.tencent.mm.u.c.vr().set(4104, Boolean.valueOf(!this.nVZ.nVW.isChecked()));
                                    com.tencent.mm.az.a.dl(this.nVZ.context);
                                    ((Activity) this.nVZ.context).finish();
                                }
                            }, new OnClickListener(this) {
                                final /* synthetic */ a nVZ;

                                {
                                    this.nVZ = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                        } else {
                            this.nVY.show();
                        }
                    }
                }
            }
            return true;
        } else if (str.equals("contact_info_lbs_install")) {
            g(this.context, true);
            return true;
        } else if (str.equals("contact_info_lbs_clear_info")) {
            g.a(this.context, R.l.eCK, R.l.eCJ, new OnClickListener(this) {
                final /* synthetic */ a nVZ;

                {
                    this.nVZ = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.nVZ.nVU = new c(2, 0.0f, 0.0f, 0, 0, "", "");
                    ap.vd().a(this.nVZ.nVU, 0);
                    a aVar = this.nVZ;
                    Context context = this.nVZ.context;
                    this.nVZ.context.getString(R.l.dIO);
                    aVar.irJ = g.a(context, this.nVZ.context.getString(R.l.eCN), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass4 nWa;

                        {
                            this.nWa = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            ap.vd().c(this.nWa.nVZ.nVU);
                        }
                    });
                }
            }, new OnClickListener(this) {
                final /* synthetic */ a nVZ;

                {
                    this.nVZ = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            return true;
        } else if (str.equals("contact_info_lbs_uninstall")) {
            g.a(this.context, this.context.getString(R.l.eTH), "", this.context.getString(R.l.dGt), this.context.getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ a nVZ;

                {
                    this.nVZ = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    a.g(this.nVZ.context, false);
                }
            }, null);
            return true;
        } else {
            w.e("MicroMsg.ContactWidgetLBS", "handleEvent : unExpected key = " + str);
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
        Assert.assertTrue(o.fi(xVar.field_username));
        ap.yY();
        com.tencent.mm.u.c.vr().a(this);
        w.v("MicroMsg.ContactWidgetLBS", "listener added");
        this.jiL = xVar;
        this.isJ = fVar;
        nVX = true;
        fVar.addPreferencesFromResource(R.o.fts);
        adH();
        return true;
    }

    private void adH() {
        int i;
        boolean z;
        boolean z2 = true;
        boolean z3 = (m.xW() & 512) == 0;
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.isJ.Td("contact_info_header_helper");
        helperHeaderPreference.Y(this.jiL.field_username, this.jiL.tL(), this.context.getString(R.l.dYt));
        if (z3) {
            i = 1;
        } else {
            i = 0;
        }
        helperHeaderPreference.kg(i);
        this.isJ.aV("contact_info_lbs_install", z3);
        f fVar = this.isJ;
        String str = "contact_info_lbs_go_lbs";
        if (z3) {
            z = false;
        } else {
            z = true;
        }
        fVar.aV(str, z);
        fVar = this.isJ;
        str = "contact_info_lbs_clear_info";
        if (z3) {
            z = false;
        } else {
            z = true;
        }
        fVar.aV(str, z);
        f fVar2 = this.isJ;
        String str2 = "contact_info_lbs_uninstall";
        if (z3) {
            z2 = false;
        }
        fVar2.aV(str2, z2);
    }

    public static void g(Context context, boolean z) {
        String string = z ? context.getString(R.l.eTE) : context.getString(R.l.eTL);
        nVX = z;
        context.getString(R.l.dIO);
        final p a = g.a(context, string, true, null);
        final ae anonymousClass6 = new AnonymousClass6(z, null);
        new Timer().schedule(new TimerTask() {
            public final void run() {
                if (a != null) {
                    a.dismiss();
                    anonymousClass6.sendEmptyMessage(0);
                }
            }
        }, 1500);
    }

    public final boolean adI() {
        ap.yY();
        com.tencent.mm.u.c.vr().b(this);
        ap.vd().b(JsApiScanCode.CTRL_INDEX, this);
        com.tencent.mm.plugin.nearby.a.imw.ou();
        return true;
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        int n = bg.n(obj, 0);
        w.d("MicroMsg.ContactWidgetLBS", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(n), mVar});
        ap.yY();
        if (mVar != com.tencent.mm.u.c.vr() || n <= 0) {
            w.e("MicroMsg.ContactWidgetLBS", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(n), mVar});
        } else if (n == 40 || n == 34 || n == 7) {
            adH();
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        if (this.nVU != null || ((c) kVar).AJ() != 2) {
            w.i("MicroMsg.ContactWidgetLBS", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
            if (kVar.getType() == JsApiScanCode.CTRL_INDEX) {
                int i3;
                if (this.irJ != null) {
                    this.irJ.dismiss();
                    this.irJ = null;
                }
                if (i == 0 && i2 == 0) {
                    i3 = R.l.eCM;
                } else {
                    i3 = R.l.eCL;
                }
                if (((c) kVar).AJ() == 2 && nVX) {
                    g.a(this.context, i3, R.l.dIO, new OnClickListener(this) {
                        final /* synthetic */ a nVZ;

                        {
                            this.nVZ = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    this.nVU = null;
                }
            }
        }
    }
}
