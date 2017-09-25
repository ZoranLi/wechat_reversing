package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.cp;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.bp;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.l;
import com.tencent.mm.plugin.exdevice.model.m;
import com.tencent.mm.plugin.exdevice.model.x;
import com.tencent.mm.plugin.exdevice.model.y;
import com.tencent.mm.protocal.c.aen;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.b;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class ExdeviceDeviceProfileUI extends MMPreference implements e {
    private String aQl;
    private p iLz;
    private String lcq;
    private String lcr;
    private long ldB;
    private String lhH;
    private String lhZ;
    private String liG;
    private String liH;
    private int ljF;
    private p ljN = null;
    private String lkK;
    private String lkL;
    private boolean lkM;
    private String lkN;
    private boolean lkO;
    private String lkP;
    private b lkQ;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r11) {
        /*
        r10 = this;
        r6 = 2;
        r3 = 1;
        r2 = 0;
        super.onCreate(r11);
        r0 = new com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI$1;
        r0.<init>(r10);
        r10.b(r0);
        r0 = com.tencent.mm.R.l.eft;
        r10.zi(r0);
        r0 = new com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI$7;
        r0.<init>(r10);
        r10.lkQ = r0;
        r0 = r10.getIntent();
        r1 = "device_mac";
        r1 = r0.getStringExtra(r1);
        r10.aQl = r1;
        r1 = "device_ble_simple_proto";
        r4 = 0;
        r4 = r0.getLongExtra(r1, r4);
        r10.ldB = r4;
        r1 = "device_jump_url";
        r1 = r0.getStringExtra(r1);
        r10.lkK = r1;
        r1 = "device_brand_name";
        r1 = r0.getStringExtra(r1);
        r10.lcq = r1;
        r1 = "device_id";
        r1 = r0.getStringExtra(r1);
        r10.lcr = r1;
        r1 = "device_type";
        r1 = r0.getStringExtra(r1);
        r10.lhH = r1;
        r1 = "bind_ticket";
        r1 = r0.getStringExtra(r1);
        r10.liH = r1;
        r1 = "subscribe_flag";
        r1 = r0.getIntExtra(r1, r2);
        r10.ljF = r1;
        r1 = "device_has_bound";
        r1 = r0.getBooleanExtra(r1, r2);
        r10.lkM = r1;
        r1 = "device_title";
        r1 = r0.getStringExtra(r1);
        r10.liG = r1;
        r1 = "device_alias";
        r1 = r0.getStringExtra(r1);
        r10.lkL = r1;
        r1 = "device_desc";
        r1 = r0.getStringExtra(r1);
        r10.lhZ = r1;
        r1 = "device_icon_url";
        r0 = r0.getStringExtra(r1);
        r10.lkN = r0;
        r0 = r10.lcr;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x00a5;
    L_0x009d:
        r0 = r10.lhH;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 == 0) goto L_0x00cb;
    L_0x00a5:
        r0 = "MicroMsg.ExdeviceDeviceProfileUI";
        r1 = "deviceId or deviceType is null.";
        r4 = new java.lang.Object[r6];
        r5 = r10.lcr;
        r4[r2] = r5;
        r5 = r10.lhH;
        r4[r3] = r5;
        com.tencent.mm.sdk.platformtools.w.e(r0, r1, r4);
    L_0x00b8:
        if (r2 != 0) goto L_0x01b4;
    L_0x00ba:
        r0 = r10.uSU;
        r0 = r0.uTo;
        r1 = com.tencent.mm.R.l.ega;
        r0 = android.widget.Toast.makeText(r0, r1, r3);
        r0.show();
        r10.finish();
    L_0x00ca:
        return;
    L_0x00cb:
        r0 = com.tencent.mm.plugin.exdevice.model.ad.apt();
        r1 = r10.lcr;
        r4 = r10.lhH;
        r0 = r0.bT(r1, r4);
        if (r0 == 0) goto L_0x01a9;
    L_0x00d9:
        r10.lkM = r3;
        r1 = r10.lkL;
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r1 == 0) goto L_0x00eb;
    L_0x00e3:
        r1 = r0.gtR;
        r1 = com.tencent.mm.sdk.platformtools.bg.mz(r1);
        r10.lkL = r1;
    L_0x00eb:
        r1 = r10.liG;
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r1 == 0) goto L_0x00fb;
    L_0x00f3:
        r1 = r0.gtS;
        r1 = com.tencent.mm.sdk.platformtools.bg.mz(r1);
        r10.liG = r1;
    L_0x00fb:
        r1 = r10.lcq;
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r1 == 0) goto L_0x010b;
    L_0x0103:
        r1 = r0.field_brandName;
        r1 = com.tencent.mm.sdk.platformtools.bg.mz(r1);
        r10.lcq = r1;
    L_0x010b:
        r1 = r10.lhZ;
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r1 == 0) goto L_0x011b;
    L_0x0113:
        r1 = r0.gtT;
        r1 = com.tencent.mm.sdk.platformtools.bg.mz(r1);
        r10.lhZ = r1;
    L_0x011b:
        r1 = r10.lkN;
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r1 == 0) goto L_0x012b;
    L_0x0123:
        r1 = r0.iconUrl;
        r1 = com.tencent.mm.sdk.platformtools.bg.mz(r1);
        r10.lkN = r1;
    L_0x012b:
        r1 = r10.lkK;
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r1 == 0) goto L_0x013b;
    L_0x0133:
        r1 = r0.jumpUrl;
        r1 = com.tencent.mm.sdk.platformtools.bg.mz(r1);
        r10.lkK = r1;
    L_0x013b:
        r0 = r0.gtV;
        if (r0 != r6) goto L_0x01b1;
    L_0x013f:
        r10.lkO = r3;
        r0 = r10.liG;
        r10.lkP = r0;
        r0 = com.tencent.mm.plugin.exdevice.model.ad.apt();
        r0 = r0.apY();
        r4 = r0.iterator();
    L_0x0151:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x01b1;
    L_0x0157:
        r0 = r4.next();
        r0 = (com.tencent.mm.plugin.exdevice.h.b) r0;
        r1 = r0.field_deviceType;
        r5 = r10.lhH;
        r1 = r1.equals(r5);
        if (r1 == 0) goto L_0x0151;
    L_0x0167:
        r1 = r0.gua;
        if (r1 == 0) goto L_0x0151;
    L_0x016b:
        r5 = r1.length();
        if (r5 <= 0) goto L_0x0151;
    L_0x0171:
        r5 = ",";
        r5 = r1.split(r5);
        r1 = r2;
    L_0x0179:
        r6 = r5.length;
        if (r1 >= r6) goto L_0x0151;
    L_0x017c:
        r6 = r5[r1];
        r7 = r10.lcr;
        r6 = r6.equals(r7);
        if (r6 == 0) goto L_0x01a1;
    L_0x0186:
        r6 = r0.gtR;
        r6 = com.tencent.mm.sdk.platformtools.bg.mA(r6);
        if (r6 == 0) goto L_0x01a4;
    L_0x018e:
        r6 = r0.gtS;
        r10.lkP = r6;
    L_0x0192:
        r6 = "MicroMsg.ExdeviceDeviceProfileUI";
        r7 = "mGateWayTitle %s";
        r8 = new java.lang.Object[r3];
        r9 = r10.lkP;
        r8[r2] = r9;
        com.tencent.mm.sdk.platformtools.w.i(r6, r7, r8);
    L_0x01a1:
        r1 = r1 + 1;
        goto L_0x0179;
    L_0x01a4:
        r6 = r0.gtR;
        r10.lkP = r6;
        goto L_0x0192;
    L_0x01a9:
        r0 = r10.liH;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x00b8;
    L_0x01b1:
        r2 = r3;
        goto L_0x00b8;
    L_0x01b4:
        r10.aqg();
        goto L_0x00ca;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.ui.ExdeviceDeviceProfileUI.onCreate(android.os.Bundle):void");
    }

    private void aqg() {
        String str;
        f fVar;
        boolean z;
        f fVar2 = this.vrv;
        DeviceProfileHeaderPreference deviceProfileHeaderPreference = (DeviceProfileHeaderPreference) fVar2.Td("device_profile_header");
        deviceProfileHeaderPreference.a(1, new OnClickListener(this) {
            final /* synthetic */ ExdeviceDeviceProfileUI lkR;

            {
                this.lkR = r1;
            }

            public final void onClick(View view) {
                g.a(this.lkR, this.lkR.getString(R.l.efY), "", "", 50, this.lkR.lkQ);
            }
        });
        deviceProfileHeaderPreference.a(4, new OnClickListener(this) {
            final /* synthetic */ ExdeviceDeviceProfileUI lkR;

            {
                this.lkR = r1;
            }

            public final void onClick(View view) {
                g.a(this.lkR, this.lkR.getString(R.l.efY), this.lkR.lkL, "", 50, this.lkR.lkQ);
            }
        });
        a(deviceProfileHeaderPreference);
        deviceProfileHeaderPreference.cy(this.lkN);
        KeyValuePreference keyValuePreference = (KeyValuePreference) fVar2.Td("connect_setting");
        KeyValuePreference keyValuePreference2 = (KeyValuePreference) fVar2.Td("user_list");
        ((KeyValuePreference) fVar2.Td("message_manage")).kZ(true);
        keyValuePreference.kZ(true);
        keyValuePreference2.kZ(true);
        fVar2.aV("message_manage", true);
        fVar2.aV("connect_setting", true);
        fVar2.aV("user_list", true);
        if (this.lkO) {
            fVar2.aV("sub_device_desc", false);
            fVar2.Td("sub_device_desc").setTitle(getResources().getString(R.l.egH, new Object[]{this.lkP}));
            fVar2.aV("bind_device", true);
            str = "unbind_device";
            fVar = fVar2;
            z = true;
        } else {
            fVar2.aV("sub_device_desc", true);
            fVar2.aV("bind_device", this.lkM);
            String str2 = "unbind_device";
            if (this.lkM) {
                str = str2;
                fVar = fVar2;
                z = false;
            } else {
                str = str2;
                fVar = fVar2;
                z = true;
            }
        }
        fVar.aV(str, z);
        if (bg.mA(this.lkK)) {
            fVar2.aV("open_device_panel", true);
        }
    }

    private void a(DeviceProfileHeaderPreference deviceProfileHeaderPreference) {
        CharSequence charSequence = bg.mA(this.liG) ? this.lcq : this.liG;
        if (bg.mA(this.lkL)) {
            deviceProfileHeaderPreference.setName(charSequence);
            deviceProfileHeaderPreference.vm("");
            deviceProfileHeaderPreference.E(3, false);
            deviceProfileHeaderPreference.E(4, false);
            deviceProfileHeaderPreference.E(1, this.lkM);
        } else {
            deviceProfileHeaderPreference.setName(this.lkL);
            deviceProfileHeaderPreference.vm(getString(R.l.efT, new Object[]{charSequence}));
            deviceProfileHeaderPreference.E(3, true);
            deviceProfileHeaderPreference.E(4, true);
            deviceProfileHeaderPreference.E(1, false);
        }
        charSequence = this.lhZ;
        deviceProfileHeaderPreference.lhZ = charSequence;
        if (deviceProfileHeaderPreference.lhW != null) {
            deviceProfileHeaderPreference.lhW.setText(charSequence);
        }
    }

    public final int ON() {
        return R.o.ftH;
    }

    public final boolean a(f fVar, Preference preference) {
        w.d("MicroMsg.ExdeviceDeviceProfileUI", "onPreferenceTreeClcik.(key : %s)", new Object[]{preference.igL});
        String str;
        final k kVar;
        if ("bind_device".equals(preference.igL)) {
            if (bg.mA(this.liH)) {
                w.i("MicroMsg.ExdeviceDeviceProfileUI", "Do unauth bind device.");
                k mVar = new m(com.tencent.mm.plugin.exdevice.j.b.vx(this.aQl), this.lcq, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, this.ldB);
                i(mVar);
                ap.vd().a(1262, this);
                ap.vd().a(mVar, 0);
            } else {
                w.i("MicroMsg.ExdeviceDeviceProfileUI", "Do normal bind device.");
                str = this.liH;
                int i = this.ljF;
                ap.vd().a(536, this);
                com.tencent.mm.sdk.b.b cpVar = new cp();
                cpVar.fGc.fGe = str;
                cpVar.fGc.opType = 1;
                cpVar.fGc.fGf = i;
                a.urY.m(cpVar);
                kVar = cpVar.fGd.fGg;
                getString(R.l.dIO);
                this.ljN = g.a(this, getString(R.l.efv), true, new OnCancelListener(this) {
                    final /* synthetic */ ExdeviceDeviceProfileUI lkR;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().b(536, this.lkR);
                        com.tencent.mm.sdk.b.b cpVar = new cp();
                        cpVar.fGc.opType = 2;
                        cpVar.fGc.fGg = kVar;
                        a.urY.m(cpVar);
                    }
                });
            }
        } else if ("unbind_device".equals(preference.igL)) {
            aen com_tencent_mm_protocal_c_aen = new aen();
            com_tencent_mm_protocal_c_aen.jNm = this.lcr;
            com_tencent_mm_protocal_c_aen.thD = this.lhH;
            bp bT = ad.apt().bT(this.lcr, this.lhH);
            if (bT != null) {
                str = bT.gua;
                if (str != null && str.length() > 0) {
                    String[] split = str.split(",");
                    for (String bV : split) {
                        ad.apt().bV(bV, this.lhH);
                    }
                }
            }
            kVar = new x(com_tencent_mm_protocal_c_aen, 2);
            i(kVar);
            ap.vd().a(537, this);
            ap.vd().a(kVar, 0);
        } else if ("open_device_panel".equals(preference.igL)) {
            com.tencent.mm.plugin.exdevice.model.f.S(this.uSU.uTo, this.lkK);
        } else if ("contact_info_biz_go_chatting".equals(preference.igL)) {
            ap.yY();
            af Rc = c.wR().Rc(this.lcq);
            Intent intent = new Intent();
            intent.putExtra("device_id", this.lcr);
            intent.putExtra("device_type", this.lhH);
            intent.putExtra("KIsHardDevice", true);
            intent.putExtra("KHardDeviceBindTicket", this.liH);
            if (Rc != null) {
                if (com.tencent.mm.j.a.ez(Rc.field_type) && Rc.bLe()) {
                    com.tencent.mm.modelbiz.w.DH().hO(Rc.field_username);
                    intent.putExtra("Chat_User", this.lcq);
                    intent.putExtra("finish_direct", true);
                    com.tencent.mm.plugin.exdevice.a.lao.e(intent, this.uSU.uTo);
                } else {
                    intent.putExtra("Contact_User", this.lcq);
                    intent.putExtra("force_get_contact", true);
                    d.b(this.uSU.uTo, "profile", ".ui.ContactInfoUI", intent);
                }
            }
        } else if (!("message_manage".equals(preference.igL) || "connect_setting".equals(preference.igL) || "user_list".equals(preference.igL))) {
            return false;
        }
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar == null) {
            w.e("MicroMsg.ExdeviceDeviceProfileUI", "scene is null.");
            return;
        }
        w.d("MicroMsg.ExdeviceDeviceProfileUI", "type = %s", new Object[]{Integer.valueOf(kVar.getType())});
        if (kVar instanceof l) {
            aqa();
            ap.vd().b(kVar.getType(), this);
            if (i == 0 && i2 == 0) {
                aqi();
                f(ad.apt().bT(this.lcr, this.lhH));
                runOnUiThread(new Runnable(this) {
                    final /* synthetic */ ExdeviceDeviceProfileUI lkR;

                    {
                        this.lkR = r1;
                    }

                    public final void run() {
                        this.lkR.lkM = true;
                        this.lkR.aqg();
                        this.lkR.vrv.notifyDataSetChanged();
                    }
                });
                return;
            }
            w.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(kVar.getType())});
            aqh();
        } else if (kVar instanceof m) {
            aqa();
            ap.vd().b(kVar.getType(), this);
            com.tencent.mm.plugin.exdevice.h.b bF = ad.apt().bF(com.tencent.mm.plugin.exdevice.j.b.vx(this.aQl));
            if (i == 0 && i2 == 0 && bF != null) {
                f(bF);
                runOnUiThread(new Runnable(this) {
                    final /* synthetic */ ExdeviceDeviceProfileUI lkR;

                    {
                        this.lkR = r1;
                    }

                    public final void run() {
                        this.lkR.lkM = true;
                        this.lkR.aqg();
                        this.lkR.vrv.notifyDataSetChanged();
                    }
                });
                aqi();
                return;
            }
            w.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(kVar.getType())});
            aqh();
        } else if (kVar instanceof y) {
            aqa();
            ap.vd().b(1263, this);
            if (i == 0 && i2 == 0) {
                this.lkL = ((y) kVar).gtR;
                runOnUiThread(new Runnable(this) {
                    final /* synthetic */ ExdeviceDeviceProfileUI lkR;

                    {
                        this.lkR = r1;
                    }

                    public final void run() {
                        this.lkR.a((DeviceProfileHeaderPreference) this.lkR.vrv.Td("device_profile_header"));
                    }
                });
                com.tencent.mm.sdk.e.c bT = ad.apt().bT(this.lcr, this.lhH);
                if (bT == null) {
                    w.i("MicroMsg.ExdeviceDeviceProfileUI", "hard device info is null.(deviceId:%s, deviceType:%s)", new Object[]{this.lcr, this.lhH});
                    return;
                }
                bT.bO(this.lkL);
                ad.apt().c(bT, new String[0]);
                return;
            }
            w.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd error(%d, %d, %s).(type : %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(kVar.getType())});
            Toast.makeText(this.uSU.uTo, getString(R.l.efX), 1).show();
        } else if (kVar instanceof x) {
            aqa();
            if (i == 0 && i2 == 0) {
                runOnUiThread(new Runnable(this) {
                    final /* synthetic */ ExdeviceDeviceProfileUI lkR;

                    {
                        this.lkR = r1;
                    }

                    public final void run() {
                        this.lkR.lkL = null;
                        this.lkR.lkM = false;
                        this.lkR.aqg();
                        this.lkR.vrv.notifyDataSetChanged();
                    }
                });
                finish();
                return;
            }
            w.e("MicroMsg.ExdeviceDeviceProfileUI", "onSceneEnd, unbind failed (%d, %d, %s).(type : %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(kVar.getType())});
            runOnUiThread(new Runnable(this) {
                final /* synthetic */ ExdeviceDeviceProfileUI lkR;

                {
                    this.lkR = r1;
                }

                public final void run() {
                    Toast.makeText(this.lkR.uSU.uTo, R.l.egI, 1).show();
                }
            });
        }
    }

    private void f(com.tencent.mm.plugin.exdevice.h.b bVar) {
        if (bVar != null) {
            this.lcr = bVar.field_deviceID;
            this.lhH = bVar.field_deviceType;
            this.lkL = bg.mz(bVar.gtR);
            this.liG = bg.mz(bVar.gtS);
            this.lcq = bg.mz(bVar.field_brandName);
            this.lhZ = bg.mz(bVar.gtT);
            this.lkN = bg.mz(bVar.iconUrl);
            this.lkK = bg.mz(bVar.jumpUrl);
        }
    }

    private void aqa() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ ExdeviceDeviceProfileUI lkR;

            {
                this.lkR = r1;
            }

            public final void run() {
                if (this.lkR.iLz != null && this.lkR.iLz.isShowing()) {
                    this.lkR.iLz.dismiss();
                }
                if (this.lkR.ljN != null && this.lkR.ljN.isShowing()) {
                    this.lkR.ljN.dismiss();
                }
            }
        });
    }

    private void aqh() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ ExdeviceDeviceProfileUI lkR;

            {
                this.lkR = r1;
            }

            public final void run() {
                g.b(this.lkR, this.lkR.getString(R.l.efo), this.lkR.getString(R.l.dIO), true);
            }
        });
    }

    private void aqi() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ ExdeviceDeviceProfileUI lkR;

            {
                this.lkR = r1;
            }

            public final void run() {
                Context context = this.lkR;
                this.lkR.getString(R.l.dIO);
                final p a = g.a(context, this.lkR.getString(R.l.efx), false, null);
                new aj(new aj.a(this) {
                    final /* synthetic */ AnonymousClass4 lkS;

                    public final boolean oQ() {
                        this.lkS.lkR.runOnUiThread(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 lkT;

                            {
                                this.lkT = r1;
                            }

                            public final void run() {
                                a.dismiss();
                            }
                        });
                        return true;
                    }
                }, false).v(1000, 1000);
            }
        });
    }

    private void i(final k kVar) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ ExdeviceDeviceProfileUI lkR;

            public final void run() {
                this.lkR.iLz = g.a(this.lkR.uSU.uTo, this.lkR.getString(R.l.dJd), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass5 lkU;

                    {
                        this.lkU = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(kVar);
                    }
                });
            }
        });
    }
}
