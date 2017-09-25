package com.tencent.mm.plugin.qmessage.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.map.c;
import com.tencent.mm.plugin.qmessage.a.b;
import com.tencent.mm.plugin.qmessage.a.d;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.e;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class a implements com.tencent.mm.pluginsdk.d.a, e {
    public Context context;
    private f isJ;
    private ProgressDialog isv;
    private x jiL;

    public final class a {
        String country = "";
        String gkB = "";
        String gkC = "";
        String hCE = "";
        final /* synthetic */ a oyN;
        String oyO = "";
        String oyP = "";
        String oyQ = "";

        public a(a aVar) {
            this.oyN = aVar;
        }
    }

    public a(Context context) {
        this.context = context;
    }

    public final boolean sa(String str) {
        return true;
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        boolean z2;
        boolean z3 = false;
        Assert.assertTrue(fVar != null);
        if (xVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(x.QO(xVar.field_username));
        ap.vd().a(c.CTRL_INDEX, this);
        this.jiL = xVar;
        this.isJ = fVar;
        fVar.addPreferencesFromResource(R.o.ftx);
        NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) fVar.Td("contact_info_header_normal");
        if (normalUserHeaderPreference != null) {
            normalUserHeaderPreference.sSR = "ContactWidgetQContact";
            normalUserHeaderPreference.a(xVar, 0, null);
        }
        adH();
        d CJ = g.aUe().CJ(this.jiL.field_username);
        if (CJ == null || bg.mz(CJ.getUsername()).length() <= 0) {
            w.e("MicroMsg.ContactWidgetQContact", "getProfileOrNot: QContact is null, should not in this way");
            CJ = new d();
            CJ.username = this.jiL.field_username;
            CJ.fRW = -1;
            g.aUe().a(CJ);
        }
        if (CJ.oyB == 1) {
            String str = this.jiL.field_username;
            z2 = bg.mz(CJ.aUc()).length() <= 0;
            if (bg.mz(str).length() > 0) {
                z3 = true;
            }
            Assert.assertTrue(z3);
            Set hashSet = new HashSet();
            hashSet.add(str);
            final b bVar = new b(hashSet);
            new ae().post(new Runnable(this) {
                final /* synthetic */ a oyN;

                public final void run() {
                    ap.vd().a(bVar, 0);
                }
            });
            if (z2) {
                Context context = this.context;
                this.context.getString(R.l.dIO);
                this.isv = com.tencent.mm.ui.base.g.a(context, this.context.getString(R.l.dHA), true, new OnCancelListener(this) {
                    final /* synthetic */ a oyN;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(bVar);
                    }
                });
            }
        }
        return true;
    }

    private void adH() {
        d CJ = g.aUe().CJ(this.jiL.field_username);
        if (CJ == null || bg.mz(CJ.getUsername()).length() <= 0) {
            w.e("MicroMsg.ContactWidgetQContact", "updateProfile : Qcontact is null");
            return;
        }
        if (bg.mz(CJ.aUc()).length() <= 0) {
            w.e("MicroMsg.ContactWidgetQContact", "updateProfile: QContact extInfo is null");
        }
        Preference Td = this.isJ.Td("contact_info_qcontact_sex");
        Preference Td2 = this.isJ.Td("contact_info_qcontact_age");
        Preference Td3 = this.isJ.Td("contact_info_qcontact_birthday");
        Preference Td4 = this.isJ.Td("contact_info_qcontact_address");
        a aVar = new a(this);
        String aUc = CJ.aUc();
        if (bg.mz(aUc).length() <= 0) {
            w.e("MicroMsg.ContactWidgetQContact", "QExtInfoContent : parse xml, but xml is null");
        } else {
            Map q = bh.q(aUc, "extinfo");
            if (q != null) {
                aVar.oyO = (String) q.get(".extinfo.sex");
                aVar.oyP = (String) q.get(".extinfo.age");
                aVar.oyQ = (String) q.get(".extinfo.bd");
                aVar.country = (String) q.get(".extinfo.country");
                aVar.gkB = (String) q.get(".extinfo.province");
                aVar.gkC = (String) q.get(".extinfo.city");
            }
            if (aVar.oyO == null || !aVar.oyO.equals("1")) {
                aVar.oyO = aVar.oyN.context.getString(R.l.eUU);
            } else {
                aVar.oyO = aVar.oyN.context.getString(R.l.eUV);
            }
            if (aVar.country != null) {
                aVar.hCE += aVar.country + " ";
            }
            if (aVar.gkB != null) {
                aVar.hCE += aVar.gkB + " ";
            }
            if (aVar.gkC != null) {
                aVar.hCE += aVar.gkC;
            }
        }
        if (Td != null) {
            Td.setSummary(aVar.oyO == null ? "" : aVar.oyO);
        }
        if (Td2 != null) {
            Td2.setSummary(aVar.oyP == null ? "" : aVar.oyP);
        }
        if (Td3 != null) {
            Td3.setSummary(aVar.oyQ == null ? "" : aVar.oyQ);
        }
        if (Td4 != null) {
            Td4.setSummary(aVar.hCE == null ? "" : aVar.hCE);
        }
        this.isJ.notifyDataSetChanged();
    }

    public final boolean adI() {
        ap.vd().b(c.CTRL_INDEX, this);
        NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) this.isJ.Td("contact_info_header_normal");
        if (normalUserHeaderPreference != null) {
            normalUserHeaderPreference.onDetach();
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r9, int r10, java.lang.String r11, com.tencent.mm.y.k r12) {
        /*
        r8 = this;
        r7 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        r6 = 2;
        r1 = 0;
        r0 = 1;
        r2 = r12.getType();
        r3 = 140; // 0x8c float:1.96E-43 double:6.9E-322;
        if (r2 == r3) goto L_0x000e;
    L_0x000d:
        return;
    L_0x000e:
        r2 = r8.isv;
        if (r2 == 0) goto L_0x0020;
    L_0x0012:
        r2 = r8.isv;
        r2.dismiss();
        r2 = 0;
        r8.isv = r2;
        switch(r9) {
            case 1: goto L_0x005e;
            case 2: goto L_0x0082;
            default: goto L_0x001d;
        };
    L_0x001d:
        r0 = r1;
    L_0x001e:
        if (r0 != 0) goto L_0x000d;
    L_0x0020:
        if (r9 != 0) goto L_0x000d;
    L_0x0022:
        if (r10 != 0) goto L_0x000d;
    L_0x0024:
        r0 = com.tencent.mm.plugin.qmessage.a.g.aUe();
        r2 = r8.jiL;
        r2 = r2.field_username;
        r0 = r0.CJ(r2);
        if (r0 == 0) goto L_0x0040;
    L_0x0032:
        r2 = r0.getUsername();
        r2 = com.tencent.mm.sdk.platformtools.bg.mz(r2);
        r2 = r2.length();
        if (r2 > 0) goto L_0x00a7;
    L_0x0040:
        r0 = "MicroMsg.ContactWidgetQContact";
        r1 = new java.lang.StringBuilder;
        r2 = "resetUpdateStatus: did not find this QContact, username = ";
        r1.<init>(r2);
        r2 = r8.jiL;
        r2 = r2.field_username;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
    L_0x005a:
        r8.adH();
        goto L_0x000d;
    L_0x005e:
        r2 = com.tencent.mm.platformtools.r.iik;
        if (r2 == 0) goto L_0x001d;
    L_0x0062:
        r2 = r8.context;
        r3 = r8.context;
        r4 = com.tencent.mm.R.l.elu;
        r5 = new java.lang.Object[r6];
        r6 = java.lang.Integer.valueOf(r0);
        r5[r1] = r6;
        r6 = java.lang.Integer.valueOf(r10);
        r5[r0] = r6;
        r3 = r3.getString(r4, r5);
        r2 = android.widget.Toast.makeText(r2, r3, r7);
        r2.show();
        goto L_0x001e;
    L_0x0082:
        r2 = com.tencent.mm.platformtools.r.iik;
        if (r2 == 0) goto L_0x001d;
    L_0x0086:
        r2 = r8.context;
        r3 = r8.context;
        r4 = com.tencent.mm.R.l.elv;
        r5 = new java.lang.Object[r6];
        r6 = java.lang.Integer.valueOf(r6);
        r5[r1] = r6;
        r6 = java.lang.Integer.valueOf(r10);
        r5[r0] = r6;
        r3 = r3.getString(r4, r5);
        r2 = android.widget.Toast.makeText(r2, r3, r7);
        r2.show();
        goto L_0x001e;
    L_0x00a7:
        r2 = 8;
        r0.fRW = r2;
        r0.oyB = r1;
        r1 = com.tencent.mm.plugin.qmessage.a.g.aUe();
        r2 = r8.jiL;
        r2 = r2.field_username;
        r0 = r1.a(r2, r0);
        if (r0 != 0) goto L_0x005a;
    L_0x00bb:
        r0 = "MicroMsg.ContactWidgetQContact";
        r1 = new java.lang.StringBuilder;
        r2 = "resetUpdateStatus: update Qcontact failed, username = ";
        r1.<init>(r2);
        r2 = r8.jiL;
        r2 = r2.field_username;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        goto L_0x005a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.qmessage.ui.a.a(int, int, java.lang.String, com.tencent.mm.y.k):void");
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
