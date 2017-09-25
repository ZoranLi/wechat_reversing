package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class BakchatPcUsbService extends Service implements e {
    private boolean jGO = false;
    private boolean jGP = false;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        w.i("MicroMsg.BakchatPcUsbService", "onCreate()");
        super.onCreate();
        ap.vd().a(595, this);
        b.a(1, this);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        int i3 = 1;
        w.i("MicroMsg.BakchatPcUsbService", "onStartCommand()");
        if (intent == null) {
            w.w("MicroMsg.BakchatPcUsbService", "onStartCommand intent is null");
        } else {
            String stringExtra = intent.getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL);
            if (bg.mA(stringExtra)) {
                w.e("MicroMsg.BakchatPcUsbService", "onStartCommand url is null");
                stopSelf();
            } else {
                this.jGO = intent.getBooleanExtra("isFromWifi", false);
                this.jGP = intent.getBooleanExtra("isMove", false);
                w.i("MicroMsg.BakchatPcUsbService", "Broadcast url:%s, isFromWifi:%b, isMove:%b", new Object[]{stringExtra, Boolean.valueOf(this.jGO), Boolean.valueOf(this.jGP)});
                if (this.jGP) {
                    ap.vd().a(new com.tencent.mm.plugin.backup.bakoldlogic.c.e(stringExtra), 0);
                    b.b(1, this);
                } else {
                    a.acg().aci().zO();
                    c aci = a.acg().aci();
                    if (this.jGO) {
                        i3 = 2;
                    }
                    aci.jLz = i3;
                    if (this.jGP || ap.za()) {
                        ap.vd().a(new com.tencent.mm.plugin.backup.bakoldlogic.c.e(stringExtra), 0);
                    } else {
                        w.e("MicroMsg.BakchatPcUsbService", "onStartCommand not in Login state");
                        Intent className = new Intent().setClassName(this, "com.tencent.mm.ui.LauncherUI");
                        className.addFlags(335544320);
                        className.putExtra("nofification_type", "back_to_pcmgr_notification");
                        startActivity(className);
                    }
                }
            }
        }
        return 2;
    }

    public void onDestroy() {
        ap.vd().b(595, this);
        b.b(1, this);
        super.onDestroy();
        w.i("MicroMsg.BakchatPcUsbService", "onDestroy" + Thread.currentThread().getName());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r11, int r12, java.lang.String r13, com.tencent.mm.y.k r14) {
        /*
        r10 = this;
        r0 = r14 instanceof com.tencent.mm.plugin.backup.f.b;
        if (r0 == 0) goto L_0x0030;
    L_0x0004:
        r0 = r14.getType();
        r1 = 1;
        if (r0 != r1) goto L_0x002c;
    L_0x000b:
        if (r11 != 0) goto L_0x002c;
    L_0x000d:
        if (r12 != 0) goto L_0x002c;
    L_0x000f:
        r0 = new android.content.Intent;
        r0.<init>();
        r1 = "com.tencent.mm.ui.LauncherUI";
        r0 = r0.setClassName(r10, r1);
        r1 = 335544320; // 0x14000000 float:6.4623485E-27 double:1.65780921E-315;
        r0.addFlags(r1);
        r1 = "nofification_type";
        r2 = "back_to_pcmgr_notification";
        r0.putExtra(r1, r2);
        r10.startActivity(r0);
    L_0x002c:
        r10.stopSelf();
    L_0x002f:
        return;
    L_0x0030:
        r0 = r14 instanceof com.tencent.mm.plugin.backup.bakoldlogic.c.e;
        if (r0 == 0) goto L_0x002f;
    L_0x0034:
        if (r11 != 0) goto L_0x01c7;
    L_0x0036:
        if (r12 != 0) goto L_0x01c7;
    L_0x0038:
        r14 = (com.tencent.mm.plugin.backup.bakoldlogic.c.e) r14;
        r2 = r14.acy();
        r0 = r10.jGP;
        if (r0 == 0) goto L_0x0146;
    L_0x0042:
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR();
        r1 = r2.ID;
        r0.jBm = r1;
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR();
        r1 = r2.tib;
        r0.jBn = r1;
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR();
        r1 = r2.tic;
        r0.jBo = r1;
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR();
        r0 = r0.abU();
        com.tencent.mm.plugin.backup.f.b.a(r0);
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR();
        r0 = r0.aaE();
        com.tencent.mm.plugin.backup.f.b.a(r0);
        r0 = 2;
        com.tencent.mm.plugin.backup.f.b.jg(r0);
        r1 = 0;
        r0 = 0;
        r3 = r2.thR;
        if (r3 <= 0) goto L_0x011c;
    L_0x007a:
        r0 = r2.thS;
        r0 = r0.getFirst();
        r0 = (com.tencent.mm.protocal.c.me) r0;
        r1 = r0.tsr;
        r0 = r0.tss;
        r0 = r0.getFirst();
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
    L_0x0090:
        r3 = com.tencent.mm.u.m.xL();
        r4 = r2.thU;
        r3 = r3.equals(r4);
        if (r3 != 0) goto L_0x00b5;
    L_0x009c:
        r1 = "MicroMsg.BakchatPcUsbService";
        r3 = "convName not equal:self:%s, resp.acc:%s";
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = com.tencent.mm.u.m.xL();
        r4[r5] = r6;
        r5 = 1;
        r6 = r2.thU;
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.w.e(r1, r3, r4);
        r1 = 0;
    L_0x00b5:
        r3 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r3 != 0) goto L_0x0127;
    L_0x00bb:
        r3 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR();
        r3 = r3.aaE();
        r3.connect(r1, r0);
        r3 = new android.content.Intent;
        r4 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r5 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmoveui.BakMoveNewUI.class;
        r3.<init>(r4, r5);
        r4 = "WifiName";
        r5 = r2.thV;
        r3.putExtra(r4, r5);
        r4 = "DataSize";
        r6 = r2.jNx;
        r3.putExtra(r4, r6);
        r4 = "ip";
        r3.putExtra(r4, r1);
        r4 = "MicroMsg.BakchatPcUsbService";
        r5 = "WifiName %s, DataSize:%d, ip:%s, port:%d";
        r6 = 4;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r8 = r2.thV;
        r6[r7] = r8;
        r7 = 1;
        r8 = r2.jNx;
        r2 = java.lang.Long.valueOf(r8);
        r6[r7] = r2;
        r2 = 2;
        r6[r2] = r1;
        r1 = 3;
        r0 = java.lang.Integer.valueOf(r0);
        r6[r1] = r0;
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r6);
        r0 = 335544320; // 0x14000000 float:6.4623485E-27 double:1.65780921E-315;
        r3.addFlags(r0);
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r0.startActivity(r3);
    L_0x0117:
        r10.stopSelf();
        goto L_0x002f;
    L_0x011c:
        r3 = "MicroMsg.BakchatPcUsbService";
        r4 = "addr convMsgCount is empty";
        com.tencent.mm.sdk.platformtools.w.e(r3, r4);
        goto L_0x0090;
    L_0x0127:
        r0 = new android.content.Intent;
        r1 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r2 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmoveui.BakMoveErrUI.class;
        r0.<init>(r1, r2);
        r1 = "getConnectInfoErr";
        r2 = 1;
        r0.putExtra(r1, r2);
        r1 = 335544320; // 0x14000000 float:6.4623485E-27 double:1.65780921E-315;
        r0.addFlags(r1);
        r1 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r1.startActivity(r0);
        goto L_0x0117;
    L_0x0146:
        r0 = r10.jGO;
        if (r0 == 0) goto L_0x015e;
    L_0x014a:
        r0 = "MicroMsg.BakchatPcUsbService";
        r1 = "from wifi, reconnect";
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg();
        r0 = r0.acj();
        r0.ack();
    L_0x015e:
        r0 = r10.jGO;
        if (r0 != 0) goto L_0x0175;
    L_0x0162:
        r0 = r2.jOc;
        r1 = 1;
        if (r0 != r1) goto L_0x0175;
    L_0x0167:
        r0 = "MicroMsg.BakchatPcUsbService";
        r1 = "broast from usb but type is wifi, url may be fake!!!!";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        r10.stopSelf();
        goto L_0x002f;
    L_0x0175:
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg();
        r1 = r2.ID;
        r0.jBm = r1;
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg();
        r1 = r2.tib;
        r0.jBn = r1;
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg();
        r1 = r2.tic;
        r0.jBo = r1;
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg();
        r0 = r0.ach();
        r1 = r2.thT;
        r3 = r2.thU;
        r0.bn(r1, r3);
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg();
        r0 = r0.ach();
        com.tencent.mm.plugin.backup.f.b.a(r0);
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg();
        r0 = r0.acj();
        com.tencent.mm.plugin.backup.f.b.a(r0);
        r0 = 1;
        com.tencent.mm.plugin.backup.f.b.jg(r0);
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg();
        r0 = r0.acj();
        r1 = r2.jOc;
        r2 = r2.thS;
        r0.b(r1, r2);
        goto L_0x002f;
    L_0x01c7:
        r0 = r10.jGP;
        if (r0 == 0) goto L_0x01ee;
    L_0x01cb:
        r0 = new android.content.Intent;
        r1 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r2 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmoveui.BakMoveErrUI.class;
        r0.<init>(r1, r2);
        r1 = "getConnectInfoErr";
        r2 = 1;
        r0.putExtra(r1, r2);
        r1 = 335544320; // 0x14000000 float:6.4623485E-27 double:1.65780921E-315;
        r0.addFlags(r1);
        r1 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r1.startActivity(r0);
        r10.stopSelf();
        goto L_0x002f;
    L_0x01ee:
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg();
        r0 = r0.aci();
        r1 = 2;
        r0.jLA = r1;
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg();
        r0 = r0.aci();
        r0.zO();
        r0 = 4;
        if (r11 != r0) goto L_0x0227;
    L_0x0207:
        r0 = -2011; // 0xfffffffffffff825 float:NaN double:NaN;
        if (r12 != r0) goto L_0x0227;
    L_0x020b:
        r0 = "MicroMsg.BakchatPcUsbService";
        r1 = "getConnect info: INVALID URL";
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
        r0 = r10.jGO;
        if (r0 == 0) goto L_0x0218;
    L_0x0218:
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg();
        r0.ach();
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.acp();
        r10.stopSelf();
        goto L_0x002f;
    L_0x0227:
        r0 = "MicroMsg.BakchatPcUsbService";
        r1 = "getConnect info other error";
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
        goto L_0x0218;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.BakchatPcUsbService.a(int, int, java.lang.String, com.tencent.mm.y.k):void");
    }
}
