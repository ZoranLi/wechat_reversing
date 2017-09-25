package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.cp;
import com.tencent.mm.plugin.appbrand.jsapi.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.smtt.sdk.r.a;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.u;
import dalvik.system.DexClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class p {
    private static p wVb = null;
    static final Lock wVg = new ReentrantLock();
    static final Lock wVh = new ReentrantLock();
    public static ThreadLocal<Integer> wVj = new ThreadLocal<Integer>() {
        public final /* synthetic */ Object initialValue() {
            return Integer.valueOf(0);
        }
    };
    private static Handler wVk = null;
    private static final Long[][] wVl;
    static boolean wVm = false;
    private static boolean wVn = false;
    private int wVc = 0;
    private FileLock wVd;
    private FileOutputStream wVe;
    private boolean wVf = false;
    boolean wVi = false;

    static {
        r0 = new Long[7][];
        r0[0] = new Long[]{Long.valueOf(25413), Long.valueOf(11460320)};
        r0[1] = new Long[]{Long.valueOf(25436), Long.valueOf(12009376)};
        r0[2] = new Long[]{Long.valueOf(25437), Long.valueOf(11489180)};
        r0[3] = new Long[]{Long.valueOf(25438), Long.valueOf(11489180)};
        r0[4] = new Long[]{Long.valueOf(25439), Long.valueOf(12013472)};
        r0[5] = new Long[]{Long.valueOf(25440), Long.valueOf(11489180)};
        r0[6] = new Long[]{Long.valueOf(25442), Long.valueOf(11489180)};
        wVl = r0;
    }

    private p() {
        if (wVk == null) {
            wVk = new Handler(this, n.cez().getLooper()) {
                final /* synthetic */ p wVo;

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void handleMessage(android.os.Message r15) {
                    /*
                    r14 = this;
                    r0 = 1;
                    com.tencent.smtt.sdk.QbSdk.setTBSInstallingStatus(r0);
                    r0 = r15.what;
                    switch(r0) {
                        case 1: goto L_0x0011;
                        case 2: goto L_0x0039;
                        case 3: goto L_0x0623;
                        default: goto L_0x0009;
                    };
                L_0x0009:
                    r0 = 0;
                    com.tencent.smtt.sdk.QbSdk.setTBSInstallingStatus(r0);
                    super.handleMessage(r15);
                    return;
                L_0x0011:
                    r0 = "TbsInstaller";
                    r1 = "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE";
                    com.tencent.smtt.utils.TbsLog.i(r0, r1);
                    r0 = r15.obj;
                    r0 = (java.lang.Object[]) r0;
                    r0 = (java.lang.Object[]) r0;
                    r3 = r14.wVo;
                    r1 = 0;
                    r1 = r0[r1];
                    r1 = (android.content.Context) r1;
                    r2 = 1;
                    r2 = r0[r2];
                    r2 = (java.lang.String) r2;
                    r4 = 2;
                    r0 = r0[r4];
                    r0 = (java.lang.Integer) r0;
                    r0 = r0.intValue();
                    r3.p(r1, r2, r0);
                    goto L_0x0009;
                L_0x0039:
                    r0 = "TbsInstaller";
                    r1 = "TbsInstaller--handleMessage--MSG_COPY_TBS_CORE";
                    com.tencent.smtt.utils.TbsLog.i(r0, r1);
                    r0 = r15.obj;
                    r0 = (java.lang.Object[]) r0;
                    r0 = (java.lang.Object[]) r0;
                    r8 = r14.wVo;
                    r1 = 0;
                    r1 = r0[r1];
                    r1 = (android.content.Context) r1;
                    r2 = 1;
                    r2 = r0[r2];
                    r2 = (android.content.Context) r2;
                    r3 = 2;
                    r0 = r0[r3];
                    r0 = (java.lang.Integer) r0;
                    r9 = r0.intValue();
                    r0 = com.tencent.smtt.sdk.k.fM(r1);
                    r3 = -524; // 0xfffffffffffffdf4 float:NaN double:NaN;
                    r0.CZ(r3);
                    r0 = r8.fT(r2);
                    if (r0 != 0) goto L_0x0009;
                L_0x006c:
                    r0 = "TbsInstaller";
                    r3 = new java.lang.StringBuilder;
                    r4 = "TbsInstaller-copyTbsCoreInThread start!  tbsCoreTargetVer is ";
                    r3.<init>(r4);
                    r3 = r3.append(r9);
                    r3 = r3.toString();
                    com.tencent.smtt.utils.TbsLog.i(r0, r3);
                    r0 = android.os.Build.VERSION.SDK_INT;
                    r3 = 11;
                    if (r0 < r3) goto L_0x00c2;
                L_0x0088:
                    r0 = "tbs_preloadx5_check_cfg_file";
                    r3 = 4;
                    r0 = r2.getSharedPreferences(r0, r3);
                L_0x0090:
                    r3 = "tbs_precheck_disable_version";
                    r4 = -1;
                    r0 = r0.getInt(r3, r4);
                    if (r0 != r9) goto L_0x00cb;
                L_0x009a:
                    r0 = "TbsInstaller";
                    r2 = new java.lang.StringBuilder;
                    r3 = "TbsInstaller-copyTbsCoreInThread -- version:";
                    r2.<init>(r3);
                    r2 = r2.append(r9);
                    r3 = " is disabled by preload_x5_check!";
                    r2 = r2.append(r3);
                    r2 = r2.toString();
                    com.tencent.smtt.utils.TbsLog.e(r0, r2);
                    r0 = com.tencent.smtt.sdk.k.fM(r1);
                    r1 = -525; // 0xfffffffffffffdf3 float:NaN double:NaN;
                    r0.CZ(r1);
                    goto L_0x0009;
                L_0x00c2:
                    r0 = "tbs_preloadx5_check_cfg_file";
                    r3 = 0;
                    r0 = r2.getSharedPreferences(r0, r3);
                    goto L_0x0090;
                L_0x00cb:
                    r0 = r8.gq(r2);
                    if (r0 != 0) goto L_0x00dc;
                L_0x00d1:
                    r0 = com.tencent.smtt.sdk.k.fM(r1);
                    r1 = -526; // 0xfffffffffffffdf2 float:NaN double:NaN;
                    r0.CZ(r1);
                    goto L_0x0009;
                L_0x00dc:
                    r0 = com.tencent.smtt.sdk.p.wVh;
                    r0 = r0.tryLock();
                    r3 = "TbsInstaller";
                    r4 = new java.lang.StringBuilder;
                    r5 = "TbsInstaller-copyTbsCoreInThread #1 locked is ";
                    r4.<init>(r5);
                    r4 = r4.append(r0);
                    r4 = r4.toString();
                    com.tencent.smtt.utils.TbsLog.i(r3, r4);
                    if (r0 == 0) goto L_0x0601;
                L_0x00fa:
                    r0 = com.tencent.smtt.sdk.p.wVg;
                    r0.lock();
                    r0 = com.tencent.smtt.sdk.j.fL(r2);	 Catch:{ Exception -> 0x0432 }
                    r3 = "copy_core_ver";
                    r3 = r0.Vq(r3);	 Catch:{ Exception -> 0x0432 }
                    r0 = com.tencent.smtt.sdk.j.fL(r2);	 Catch:{ Exception -> 0x0432 }
                    r4 = "copy_status";
                    r0 = r0.Vp(r4);	 Catch:{ Exception -> 0x0432 }
                    if (r3 != r9) goto L_0x0136;
                L_0x0117:
                    r0 = com.tencent.smtt.sdk.QbSdk.wTz;	 Catch:{ Exception -> 0x0432 }
                    r3 = 220; // 0xdc float:3.08E-43 double:1.087E-321;
                    r0.iv(r3);	 Catch:{ Exception -> 0x0432 }
                    r0 = com.tencent.smtt.sdk.k.fM(r1);	 Catch:{ Exception -> 0x0432 }
                    r3 = -528; // 0xfffffffffffffdf0 float:NaN double:NaN;
                    r0.CZ(r3);	 Catch:{ Exception -> 0x0432 }
                    r0 = com.tencent.smtt.sdk.p.wVg;
                    r0.unlock();
                    r0 = com.tencent.smtt.sdk.p.wVh;
                    r0.unlock();
                    r8.ceC();
                    goto L_0x0009;
                L_0x0136:
                    r4 = r8.gc(r2);	 Catch:{ Exception -> 0x0432 }
                    r5 = "TbsInstaller";
                    r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0432 }
                    r7 = "TbsInstaller-copyTbsCoreInThread tbsCoreInstalledVer=";
                    r6.<init>(r7);	 Catch:{ Exception -> 0x0432 }
                    r6 = r6.append(r4);	 Catch:{ Exception -> 0x0432 }
                    r6 = r6.toString();	 Catch:{ Exception -> 0x0432 }
                    com.tencent.smtt.utils.TbsLog.i(r5, r6);	 Catch:{ Exception -> 0x0432 }
                    if (r4 != r9) goto L_0x0187;
                L_0x0152:
                    r0 = com.tencent.smtt.sdk.QbSdk.wTz;	 Catch:{ Exception -> 0x0432 }
                    r3 = 220; // 0xdc float:3.08E-43 double:1.087E-321;
                    r0.iv(r3);	 Catch:{ Exception -> 0x0432 }
                    r0 = com.tencent.smtt.sdk.k.fM(r1);	 Catch:{ Exception -> 0x0432 }
                    r3 = -528; // 0xfffffffffffffdf0 float:NaN double:NaN;
                    r0.CZ(r3);	 Catch:{ Exception -> 0x0432 }
                    r0 = "TbsInstaller";
                    r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0432 }
                    r5 = "TbsInstaller-copyTbsCoreInThread return have same version is ";
                    r3.<init>(r5);	 Catch:{ Exception -> 0x0432 }
                    r3 = r3.append(r4);	 Catch:{ Exception -> 0x0432 }
                    r3 = r3.toString();	 Catch:{ Exception -> 0x0432 }
                    com.tencent.smtt.utils.TbsLog.i(r0, r3);	 Catch:{ Exception -> 0x0432 }
                    r0 = com.tencent.smtt.sdk.p.wVg;
                    r0.unlock();
                    r0 = com.tencent.smtt.sdk.p.wVh;
                    r0.unlock();
                    r8.ceC();
                    goto L_0x0009;
                L_0x0187:
                    r5 = com.tencent.smtt.sdk.j.fL(r2);	 Catch:{ Exception -> 0x0432 }
                    r6 = "install_core_ver";
                    r5 = r5.Vq(r6);	 Catch:{ Exception -> 0x0432 }
                    if (r5 <= 0) goto L_0x0196;
                L_0x0194:
                    if (r9 > r5) goto L_0x019a;
                L_0x0196:
                    if (r3 <= 0) goto L_0x019d;
                L_0x0198:
                    if (r9 <= r3) goto L_0x019d;
                L_0x019a:
                    com.tencent.smtt.sdk.p.gi(r2);	 Catch:{ Exception -> 0x0432 }
                L_0x019d:
                    r3 = 3;
                    if (r0 != r3) goto L_0x01b7;
                L_0x01a0:
                    if (r4 <= 0) goto L_0x01b7;
                L_0x01a2:
                    if (r9 > r4) goto L_0x01a9;
                L_0x01a4:
                    r3 = 88888888; // 0x54c5638 float:9.60787E-36 double:4.3916946E-316;
                    if (r9 != r3) goto L_0x01b7;
                L_0x01a9:
                    r0 = -1;
                    com.tencent.smtt.sdk.p.gi(r2);	 Catch:{ Exception -> 0x0432 }
                    r3 = "TbsInstaller";
                    r4 = "TbsInstaller-copyTbsCoreInThread -- update TBS.....";
                    r5 = 1;
                    com.tencent.smtt.utils.TbsLog.i(r3, r4, r5);	 Catch:{ Exception -> 0x0432 }
                L_0x01b7:
                    r3 = com.tencent.smtt.utils.f.gU(r2);	 Catch:{ Exception -> 0x0432 }
                    if (r3 != 0) goto L_0x0205;
                L_0x01bd:
                    r4 = com.tencent.smtt.utils.u.cfA();	 Catch:{ Exception -> 0x0432 }
                    r0 = com.tencent.smtt.sdk.k.fM(r2);	 Catch:{ Exception -> 0x0432 }
                    r6 = r0.cei();	 Catch:{ Exception -> 0x0432 }
                    r0 = com.tencent.smtt.sdk.k.fM(r1);	 Catch:{ Exception -> 0x0432 }
                    r3 = -529; // 0xfffffffffffffdef float:NaN double:NaN;
                    r0.CZ(r3);	 Catch:{ Exception -> 0x0432 }
                    r0 = com.tencent.smtt.sdk.r.gr(r2);	 Catch:{ Exception -> 0x0432 }
                    r3 = 210; // 0xd2 float:2.94E-43 double:1.04E-321;
                    r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0432 }
                    r10 = "rom is not enough when copying tbs core! curAvailROM=";
                    r9.<init>(r10);	 Catch:{ Exception -> 0x0432 }
                    r4 = r9.append(r4);	 Catch:{ Exception -> 0x0432 }
                    r5 = ",minReqRom=";
                    r4 = r4.append(r5);	 Catch:{ Exception -> 0x0432 }
                    r4 = r4.append(r6);	 Catch:{ Exception -> 0x0432 }
                    r4 = r4.toString();	 Catch:{ Exception -> 0x0432 }
                    r0.aM(r3, r4);	 Catch:{ Exception -> 0x0432 }
                    r0 = com.tencent.smtt.sdk.p.wVg;
                    r0.unlock();
                    r0 = com.tencent.smtt.sdk.p.wVh;
                    r0.unlock();
                    r8.ceC();
                    goto L_0x0009;
                L_0x0205:
                    if (r0 <= 0) goto L_0x024d;
                L_0x0207:
                    r3 = com.tencent.smtt.sdk.t.gu(r2);	 Catch:{ Exception -> 0x0432 }
                    if (r3 != 0) goto L_0x0224;
                L_0x020d:
                    r3 = com.tencent.smtt.sdk.k.fM(r2);	 Catch:{ Exception -> 0x0432 }
                    r3 = r3.wUG;	 Catch:{ Exception -> 0x0432 }
                    r4 = "tbs_downloaddecouplecore";
                    r5 = 0;
                    r3 = r3.getInt(r4, r5);	 Catch:{ Exception -> 0x0432 }
                    r4 = 1;
                    if (r3 != r4) goto L_0x0224;
                L_0x021e:
                    r3 = com.tencent.smtt.sdk.p.gb(r2);	 Catch:{ Exception -> 0x0432 }
                    if (r9 != r3) goto L_0x024d;
                L_0x0224:
                    r0 = "TbsInstaller";
                    r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0432 }
                    r4 = "TbsInstaller-copyTbsCoreInThread return have copied is ";
                    r3.<init>(r4);	 Catch:{ Exception -> 0x0432 }
                    r4 = com.tencent.smtt.sdk.p.gb(r2);	 Catch:{ Exception -> 0x0432 }
                    r3 = r3.append(r4);	 Catch:{ Exception -> 0x0432 }
                    r3 = r3.toString();	 Catch:{ Exception -> 0x0432 }
                    com.tencent.smtt.utils.TbsLog.i(r0, r3);	 Catch:{ Exception -> 0x0432 }
                    r0 = com.tencent.smtt.sdk.p.wVg;
                    r0.unlock();
                    r0 = com.tencent.smtt.sdk.p.wVh;
                    r0.unlock();
                    r8.ceC();
                    goto L_0x0009;
                L_0x024d:
                    if (r0 != 0) goto L_0x028e;
                L_0x024f:
                    r0 = com.tencent.smtt.sdk.j.fL(r2);	 Catch:{ Exception -> 0x0432 }
                    r3 = "copy_retry_num";
                    r0 = r0.Vq(r3);	 Catch:{ Exception -> 0x0432 }
                    r3 = 10;
                    if (r0 <= r3) goto L_0x0282;
                L_0x025e:
                    r0 = com.tencent.smtt.sdk.r.gr(r2);	 Catch:{ Exception -> 0x0432 }
                    r3 = 211; // 0xd3 float:2.96E-43 double:1.042E-321;
                    r4 = "exceed copy retry num!";
                    r0.aM(r3, r4);	 Catch:{ Exception -> 0x0432 }
                    r0 = com.tencent.smtt.sdk.k.fM(r1);	 Catch:{ Exception -> 0x0432 }
                    r3 = -530; // 0xfffffffffffffdee float:NaN double:NaN;
                    r0.CZ(r3);	 Catch:{ Exception -> 0x0432 }
                    r0 = com.tencent.smtt.sdk.p.wVg;
                    r0.unlock();
                    r0 = com.tencent.smtt.sdk.p.wVh;
                    r0.unlock();
                    r8.ceC();
                    goto L_0x0009;
                L_0x0282:
                    r3 = com.tencent.smtt.sdk.j.fL(r2);	 Catch:{ Exception -> 0x0432 }
                    r4 = "copy_retry_num";
                    r0 = r0 + 1;
                    r3.dj(r4, r0);	 Catch:{ Exception -> 0x0432 }
                L_0x028e:
                    r3 = com.tencent.smtt.sdk.p.gk(r1);	 Catch:{ Exception -> 0x0432 }
                    r0 = com.tencent.smtt.sdk.t.gu(r2);	 Catch:{ Exception -> 0x0432 }
                    if (r0 != 0) goto L_0x0353;
                L_0x0298:
                    r0 = com.tencent.smtt.sdk.k.fM(r2);	 Catch:{ Exception -> 0x0432 }
                    r0 = r0.wUG;	 Catch:{ Exception -> 0x0432 }
                    r4 = "tbs_downloaddecouplecore";
                    r5 = 0;
                    r0 = r0.getInt(r4, r5);	 Catch:{ Exception -> 0x0432 }
                    r4 = 1;
                    if (r0 != r4) goto L_0x034c;
                L_0x02a9:
                    r0 = com.tencent.smtt.sdk.p.gj(r2);	 Catch:{ Exception -> 0x0432 }
                    r7 = r0;
                L_0x02ae:
                    if (r3 == 0) goto L_0x05d1;
                L_0x02b0:
                    if (r7 == 0) goto L_0x05d1;
                L_0x02b2:
                    r0 = com.tencent.smtt.sdk.j.fL(r2);	 Catch:{ Exception -> 0x0432 }
                    r4 = 0;
                    r0.eA(r9, r4);	 Catch:{ Exception -> 0x0432 }
                    r0 = new com.tencent.smtt.utils.s;	 Catch:{ Exception -> 0x0432 }
                    r0.<init>();	 Catch:{ Exception -> 0x0432 }
                    r4 = new com.tencent.smtt.utils.s$b;	 Catch:{ Exception -> 0x0432 }
                    r4.<init>(r0, r3);	 Catch:{ Exception -> 0x0432 }
                    r0.wYG = r4;	 Catch:{ Exception -> 0x0432 }
                    r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0432 }
                    r6 = com.tencent.smtt.sdk.k.fM(r1);	 Catch:{ Exception -> 0x0432 }
                    r10 = -551; // 0xfffffffffffffdd9 float:NaN double:NaN;
                    r6.CZ(r10);	 Catch:{ Exception -> 0x0432 }
                    r6 = com.tencent.smtt.utils.f.h(r3, r7);	 Catch:{ Exception -> 0x0432 }
                    r10 = com.tencent.smtt.sdk.k.fM(r2);	 Catch:{ Exception -> 0x0432 }
                    r10 = r10.wUG;	 Catch:{ Exception -> 0x0432 }
                    r11 = "tbs_downloaddecouplecore";
                    r12 = 0;
                    r10 = r10.getInt(r11, r12);	 Catch:{ Exception -> 0x0432 }
                    r11 = 1;
                    if (r10 != r11) goto L_0x02eb;
                L_0x02e8:
                    com.tencent.smtt.sdk.t.gt(r2);	 Catch:{ Exception -> 0x0432 }
                L_0x02eb:
                    r10 = "TbsInstaller";
                    r11 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0432 }
                    r12 = "TbsInstaller-copyTbsCoreInThread time=";
                    r11.<init>(r12);	 Catch:{ Exception -> 0x0432 }
                    r12 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0432 }
                    r4 = r12 - r4;
                    r4 = r11.append(r4);	 Catch:{ Exception -> 0x0432 }
                    r4 = r4.toString();	 Catch:{ Exception -> 0x0432 }
                    com.tencent.smtt.utils.TbsLog.i(r10, r4);	 Catch:{ Exception -> 0x0432 }
                    if (r6 == 0) goto L_0x05a6;
                L_0x0309:
                    r4 = new com.tencent.smtt.utils.s$b;	 Catch:{ Exception -> 0x0432 }
                    r4.<init>(r0, r3);	 Catch:{ Exception -> 0x0432 }
                    r0.wYH = r4;	 Catch:{ Exception -> 0x0432 }
                    r3 = r0.wYH;	 Catch:{ Exception -> 0x0432 }
                    if (r3 == 0) goto L_0x0318;
                L_0x0314:
                    r3 = r0.wYG;	 Catch:{ Exception -> 0x0432 }
                    if (r3 != 0) goto L_0x035a;
                L_0x0318:
                    r0 = 0;
                L_0x0319:
                    if (r0 != 0) goto L_0x037a;
                L_0x031b:
                    r0 = "TbsInstaller";
                    r3 = "TbsInstaller-copyTbsCoreInThread copy-verify fail!";
                    com.tencent.smtt.utils.TbsLog.i(r0, r3);	 Catch:{ Exception -> 0x0432 }
                    r0 = 1;
                    com.tencent.smtt.utils.f.c(r7, r0);	 Catch:{ Exception -> 0x0432 }
                    r0 = com.tencent.smtt.sdk.r.gr(r2);	 Catch:{ Exception -> 0x0432 }
                    r3 = 213; // 0xd5 float:2.98E-43 double:1.05E-321;
                    r4 = "TbsCopy-Verify fail after copying tbs core!";
                    r0.aM(r3, r4);	 Catch:{ Exception -> 0x0432 }
                    r0 = com.tencent.smtt.sdk.k.fM(r1);	 Catch:{ Exception -> 0x0432 }
                    r3 = -531; // 0xfffffffffffffded float:NaN double:NaN;
                    r0.CZ(r3);	 Catch:{ Exception -> 0x0432 }
                    r0 = com.tencent.smtt.sdk.p.wVg;
                    r0.unlock();
                    r0 = com.tencent.smtt.sdk.p.wVh;
                    r0.unlock();
                    r8.ceC();
                    goto L_0x0009;
                L_0x034c:
                    r0 = com.tencent.smtt.sdk.p.gp(r2);	 Catch:{ Exception -> 0x0432 }
                    r7 = r0;
                    goto L_0x02ae;
                L_0x0353:
                    r0 = com.tencent.smtt.sdk.p.gp(r2);	 Catch:{ Exception -> 0x0432 }
                    r7 = r0;
                    goto L_0x02ae;
                L_0x035a:
                    r3 = r0.wYH;	 Catch:{ Exception -> 0x0432 }
                    r3 = r3.iyO;	 Catch:{ Exception -> 0x0432 }
                    r3 = r3.size();	 Catch:{ Exception -> 0x0432 }
                    r4 = r0.wYG;	 Catch:{ Exception -> 0x0432 }
                    r4 = r4.iyO;	 Catch:{ Exception -> 0x0432 }
                    r4 = r4.size();	 Catch:{ Exception -> 0x0432 }
                    if (r3 != r4) goto L_0x0378;
                L_0x036c:
                    r3 = r0.wYG;	 Catch:{ Exception -> 0x0432 }
                    r0 = r0.wYH;	 Catch:{ Exception -> 0x0432 }
                    r0 = com.tencent.smtt.utils.s.a(r3, r0);	 Catch:{ Exception -> 0x0432 }
                    if (r0 == 0) goto L_0x0378;
                L_0x0376:
                    r0 = 1;
                    goto L_0x0319;
                L_0x0378:
                    r0 = 0;
                    goto L_0x0319;
                L_0x037a:
                    r6 = 1;
                    r5 = 1;
                    r4 = 0;
                    r3 = 0;
                    r10 = new java.io.File;	 Catch:{ Exception -> 0x0614, all -> 0x042b }
                    r0 = "1";
                    r10.<init>(r7, r0);	 Catch:{ Exception -> 0x0614, all -> 0x042b }
                    r0 = new java.util.Properties;	 Catch:{ Exception -> 0x0614, all -> 0x042b }
                    r0.<init>();	 Catch:{ Exception -> 0x0614, all -> 0x042b }
                    r3 = r10.exists();	 Catch:{ Exception -> 0x064a, all -> 0x042b }
                    if (r3 == 0) goto L_0x0428;
                L_0x0391:
                    r11 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x064a, all -> 0x042b }
                    r11.<init>(r10);	 Catch:{ Exception -> 0x064a, all -> 0x042b }
                    r3 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x064a, all -> 0x042b }
                    r3.<init>(r11);	 Catch:{ Exception -> 0x064a, all -> 0x042b }
                    r0.load(r3);	 Catch:{ Exception -> 0x064d, all -> 0x0646 }
                    r4 = r3;
                    r3 = r6;
                L_0x03a0:
                    if (r4 == 0) goto L_0x0610;
                L_0x03a2:
                    r4.close();	 Catch:{ IOException -> 0x060f }
                    r4 = r0;
                    r6 = r3;
                L_0x03a7:
                    if (r6 == 0) goto L_0x064f;
                L_0x03a9:
                    r10 = r7.listFiles();	 Catch:{ Exception -> 0x0432 }
                    r0 = com.tencent.smtt.sdk.k.fM(r1);	 Catch:{ Exception -> 0x0432 }
                    r3 = -552; // 0xfffffffffffffdd8 float:NaN double:NaN;
                    r0.CZ(r3);	 Catch:{ Exception -> 0x0432 }
                    r0 = 0;
                    r3 = r0;
                    r0 = r5;
                L_0x03b9:
                    r5 = r10.length;	 Catch:{ Exception -> 0x0432 }
                    if (r3 >= r5) goto L_0x047a;
                L_0x03bc:
                    r5 = r10[r3];	 Catch:{ Exception -> 0x0432 }
                    r11 = "1";
                    r12 = r5.getName();	 Catch:{ Exception -> 0x0432 }
                    r11 = r11.equals(r12);	 Catch:{ Exception -> 0x0432 }
                    if (r11 != 0) goto L_0x0425;
                L_0x03cb:
                    r11 = r5.getName();	 Catch:{ Exception -> 0x0432 }
                    r12 = ".dex";
                    r11 = r11.endsWith(r12);	 Catch:{ Exception -> 0x0432 }
                    if (r11 != 0) goto L_0x0425;
                L_0x03d8:
                    r11 = "tbs.conf";
                    r12 = r5.getName();	 Catch:{ Exception -> 0x0432 }
                    r11 = r11.equals(r12);	 Catch:{ Exception -> 0x0432 }
                    if (r11 != 0) goto L_0x0425;
                L_0x03e5:
                    r0 = com.tencent.smtt.utils.a.G(r5);	 Catch:{ Exception -> 0x0432 }
                    r11 = r5.getName();	 Catch:{ Exception -> 0x0432 }
                    r12 = "";
                    r11 = r4.getProperty(r11, r12);	 Catch:{ Exception -> 0x0432 }
                    r12 = "";
                    r12 = r11.equals(r12);	 Catch:{ Exception -> 0x0432 }
                    if (r12 != 0) goto L_0x0458;
                L_0x03fd:
                    r0 = r0.equals(r11);	 Catch:{ Exception -> 0x0432 }
                    if (r0 == 0) goto L_0x0458;
                L_0x0403:
                    r0 = "TbsInstaller";
                    r11 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0432 }
                    r12 = "md5_check_success for (";
                    r11.<init>(r12);	 Catch:{ Exception -> 0x0432 }
                    r5 = r5.getName();	 Catch:{ Exception -> 0x0432 }
                    r5 = r11.append(r5);	 Catch:{ Exception -> 0x0432 }
                    r11 = ")";
                    r5 = r5.append(r11);	 Catch:{ Exception -> 0x0432 }
                    r5 = r5.toString();	 Catch:{ Exception -> 0x0432 }
                    com.tencent.smtt.utils.TbsLog.i(r0, r5);	 Catch:{ Exception -> 0x0432 }
                    r0 = 1;
                L_0x0425:
                    r3 = r3 + 1;
                    goto L_0x03b9;
                L_0x0428:
                    r3 = 0;
                    goto L_0x03a0;
                L_0x042b:
                    r0 = move-exception;
                L_0x042c:
                    if (r4 == 0) goto L_0x0431;
                L_0x042e:
                    r4.close();	 Catch:{ IOException -> 0x0643 }
                L_0x0431:
                    throw r0;	 Catch:{ Exception -> 0x0432 }
                L_0x0432:
                    r0 = move-exception;
                    r2 = com.tencent.smtt.sdk.r.gr(r2);	 Catch:{ all -> 0x0572 }
                    r3 = 215; // 0xd7 float:3.01E-43 double:1.06E-321;
                    r0 = r0.toString();	 Catch:{ all -> 0x0572 }
                    r2.aM(r3, r0);	 Catch:{ all -> 0x0572 }
                    r0 = com.tencent.smtt.sdk.k.fM(r1);	 Catch:{ all -> 0x0572 }
                    r1 = -537; // 0xfffffffffffffde7 float:NaN double:NaN;
                    r0.CZ(r1);	 Catch:{ all -> 0x0572 }
                    r0 = com.tencent.smtt.sdk.p.wVg;
                    r0.unlock();
                    r0 = com.tencent.smtt.sdk.p.wVh;
                    r0.unlock();
                    r8.ceC();
                    goto L_0x0009;
                L_0x0458:
                    r0 = 0;
                    r3 = "TbsInstaller";
                    r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0432 }
                    r10 = "md5_check_failure for (";
                    r4.<init>(r10);	 Catch:{ Exception -> 0x0432 }
                    r5 = r5.getName();	 Catch:{ Exception -> 0x0432 }
                    r4 = r4.append(r5);	 Catch:{ Exception -> 0x0432 }
                    r5 = ")";
                    r4 = r4.append(r5);	 Catch:{ Exception -> 0x0432 }
                    r4 = r4.toString();	 Catch:{ Exception -> 0x0432 }
                    com.tencent.smtt.utils.TbsLog.e(r3, r4);	 Catch:{ Exception -> 0x0432 }
                L_0x047a:
                    r3 = "TbsInstaller";
                    r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0432 }
                    r5 = "copyTbsCoreInThread - md5_check_success:";
                    r4.<init>(r5);	 Catch:{ Exception -> 0x0432 }
                    r4 = r4.append(r0);	 Catch:{ Exception -> 0x0432 }
                    r4 = r4.toString();	 Catch:{ Exception -> 0x0432 }
                    com.tencent.smtt.utils.TbsLog.i(r3, r4);	 Catch:{ Exception -> 0x0432 }
                    if (r6 == 0) goto L_0x04c5;
                L_0x0492:
                    if (r0 != 0) goto L_0x04c5;
                L_0x0494:
                    r0 = "TbsInstaller";
                    r3 = "copyTbsCoreInThread - md5 incorrect -> delete destTmpDir!";
                    com.tencent.smtt.utils.TbsLog.e(r0, r3);	 Catch:{ Exception -> 0x0432 }
                    r0 = 1;
                    com.tencent.smtt.utils.f.c(r7, r0);	 Catch:{ Exception -> 0x0432 }
                    r0 = com.tencent.smtt.sdk.r.gr(r2);	 Catch:{ Exception -> 0x0432 }
                    r3 = 213; // 0xd5 float:2.98E-43 double:1.05E-321;
                    r4 = "TbsCopy-Verify md5 fail after copying tbs core!";
                    r0.aM(r3, r4);	 Catch:{ Exception -> 0x0432 }
                    r0 = com.tencent.smtt.sdk.k.fM(r1);	 Catch:{ Exception -> 0x0432 }
                    r3 = -532; // 0xfffffffffffffdec float:NaN double:NaN;
                    r0.CZ(r3);	 Catch:{ Exception -> 0x0432 }
                    r0 = com.tencent.smtt.sdk.p.wVg;
                    r0.unlock();
                    r0 = com.tencent.smtt.sdk.p.wVh;
                    r0.unlock();
                    r8.ceC();
                    goto L_0x0009;
                L_0x04c5:
                    r0 = "TbsInstaller";
                    r3 = "TbsInstaller-copyTbsCoreInThread success!";
                    com.tencent.smtt.utils.TbsLog.i(r0, r3);	 Catch:{ Exception -> 0x0432 }
                    r0 = 1;
                    com.tencent.smtt.sdk.p.w(r2, r0);	 Catch:{ Exception -> 0x0432 }
                    r3 = com.tencent.smtt.sdk.h.fJ(r1);	 Catch:{ Exception -> 0x0432 }
                    if (r3 == 0) goto L_0x04ef;
                L_0x04d8:
                    r0 = r3.exists();	 Catch:{ Exception -> 0x0432 }
                    if (r0 == 0) goto L_0x04ef;
                L_0x04de:
                    r4 = new java.io.File;	 Catch:{ Exception -> 0x0432 }
                    r0 = com.tencent.smtt.sdk.l.fP(r2);	 Catch:{ Exception -> 0x0432 }
                    if (r0 == 0) goto L_0x0561;
                L_0x04e6:
                    r0 = "x5.oversea.tbs.org";
                L_0x04e9:
                    r4.<init>(r3, r0);	 Catch:{ Exception -> 0x0432 }
                    com.tencent.smtt.sdk.h.a(r4, r2);	 Catch:{ Exception -> 0x0432 }
                L_0x04ef:
                    r0 = com.tencent.smtt.sdk.j.fL(r2);	 Catch:{ Exception -> 0x0432 }
                    r3 = 1;
                    r0.eA(r9, r3);	 Catch:{ Exception -> 0x0432 }
                    r0 = r8.wVi;	 Catch:{ Exception -> 0x0432 }
                    if (r0 == 0) goto L_0x0565;
                L_0x04fb:
                    r0 = com.tencent.smtt.sdk.r.gr(r2);	 Catch:{ Exception -> 0x0432 }
                    r3 = 220; // 0xdc float:3.08E-43 double:1.087E-321;
                    r4 = "continueInstallWithout core success";
                    r0.aM(r3, r4);	 Catch:{ Exception -> 0x0432 }
                L_0x0507:
                    r0 = com.tencent.smtt.sdk.k.fM(r1);	 Catch:{ Exception -> 0x0432 }
                    r3 = -533; // 0xfffffffffffffdeb float:NaN double:NaN;
                    r0.CZ(r3);	 Catch:{ Exception -> 0x0432 }
                    r0 = "TbsInstaller";
                    r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0432 }
                    r4 = "TbsInstaller-copyTbsCoreInThread success -- version:";
                    r3.<init>(r4);	 Catch:{ Exception -> 0x0432 }
                    r3 = r3.append(r9);	 Catch:{ Exception -> 0x0432 }
                    r3 = r3.toString();	 Catch:{ Exception -> 0x0432 }
                    com.tencent.smtt.utils.TbsLog.i(r0, r3);	 Catch:{ Exception -> 0x0432 }
                    r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0432 }
                    r3 = 11;
                    if (r0 < r3) goto L_0x0581;
                L_0x052c:
                    r0 = "tbs_preloadx5_check_cfg_file";
                    r3 = 4;
                    r0 = r2.getSharedPreferences(r0, r3);	 Catch:{ Exception -> 0x0432 }
                L_0x0534:
                    r0 = r0.edit();	 Catch:{ Throwable -> 0x058a }
                    r3 = "tbs_preload_x5_counter";
                    r4 = 0;
                    r0.putInt(r3, r4);	 Catch:{ Throwable -> 0x058a }
                    r3 = "tbs_preload_x5_recorder";
                    r4 = 0;
                    r0.putInt(r3, r4);	 Catch:{ Throwable -> 0x058a }
                    r3 = "tbs_preload_x5_version";
                    r0.putInt(r3, r9);	 Catch:{ Throwable -> 0x058a }
                    r0.commit();	 Catch:{ Throwable -> 0x058a }
                L_0x054f:
                    com.tencent.smtt.utils.u.hb(r2);	 Catch:{ Exception -> 0x0432 }
                L_0x0552:
                    r0 = com.tencent.smtt.sdk.p.wVg;
                    r0.unlock();
                    r0 = com.tencent.smtt.sdk.p.wVh;
                    r0.unlock();
                    r8.ceC();
                    goto L_0x0009;
                L_0x0561:
                    r0 = "x5.tbs.org";
                    goto L_0x04e9;
                L_0x0565:
                    r0 = com.tencent.smtt.sdk.r.gr(r2);	 Catch:{ Exception -> 0x0432 }
                    r3 = 220; // 0xdc float:3.08E-43 double:1.087E-321;
                    r4 = "success";
                    r0.aM(r3, r4);	 Catch:{ Exception -> 0x0432 }
                    goto L_0x0507;
                L_0x0572:
                    r0 = move-exception;
                    r1 = com.tencent.smtt.sdk.p.wVg;
                    r1.unlock();
                    r1 = com.tencent.smtt.sdk.p.wVh;
                    r1.unlock();
                    r8.ceC();
                    throw r0;
                L_0x0581:
                    r0 = "tbs_preloadx5_check_cfg_file";
                    r3 = 0;
                    r0 = r2.getSharedPreferences(r0, r3);	 Catch:{ Exception -> 0x0432 }
                    goto L_0x0534;
                L_0x058a:
                    r0 = move-exception;
                    r3 = "TbsInstaller";
                    r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0432 }
                    r5 = "Init tbs_preload_x5_counter#2 exception:";
                    r4.<init>(r5);	 Catch:{ Exception -> 0x0432 }
                    r0 = android.util.Log.getStackTraceString(r0);	 Catch:{ Exception -> 0x0432 }
                    r0 = r4.append(r0);	 Catch:{ Exception -> 0x0432 }
                    r0 = r0.toString();	 Catch:{ Exception -> 0x0432 }
                    com.tencent.smtt.utils.TbsLog.e(r3, r0);	 Catch:{ Exception -> 0x0432 }
                    goto L_0x054f;
                L_0x05a6:
                    r0 = "TbsInstaller";
                    r3 = "TbsInstaller-copyTbsCoreInThread fail!";
                    com.tencent.smtt.utils.TbsLog.i(r0, r3);	 Catch:{ Exception -> 0x0432 }
                    r0 = com.tencent.smtt.sdk.j.fL(r2);	 Catch:{ Exception -> 0x0432 }
                    r3 = 2;
                    r0.eA(r9, r3);	 Catch:{ Exception -> 0x0432 }
                    r0 = 0;
                    com.tencent.smtt.utils.f.c(r7, r0);	 Catch:{ Exception -> 0x0432 }
                    r0 = com.tencent.smtt.sdk.k.fM(r1);	 Catch:{ Exception -> 0x0432 }
                    r3 = -534; // 0xfffffffffffffdea float:NaN double:NaN;
                    r0.CZ(r3);	 Catch:{ Exception -> 0x0432 }
                    r0 = com.tencent.smtt.sdk.r.gr(r2);	 Catch:{ Exception -> 0x0432 }
                    r3 = 212; // 0xd4 float:2.97E-43 double:1.047E-321;
                    r4 = "copy fail!";
                    r0.aM(r3, r4);	 Catch:{ Exception -> 0x0432 }
                    goto L_0x0552;
                L_0x05d1:
                    if (r3 != 0) goto L_0x05e8;
                L_0x05d3:
                    r0 = com.tencent.smtt.sdk.r.gr(r2);	 Catch:{ Exception -> 0x0432 }
                    r3 = 213; // 0xd5 float:2.98E-43 double:1.05E-321;
                    r4 = "src-dir is null when copying tbs core!";
                    r0.aM(r3, r4);	 Catch:{ Exception -> 0x0432 }
                    r0 = com.tencent.smtt.sdk.k.fM(r1);	 Catch:{ Exception -> 0x0432 }
                    r3 = -535; // 0xfffffffffffffde9 float:NaN double:NaN;
                    r0.CZ(r3);	 Catch:{ Exception -> 0x0432 }
                L_0x05e8:
                    if (r7 != 0) goto L_0x0552;
                L_0x05ea:
                    r0 = com.tencent.smtt.sdk.r.gr(r2);	 Catch:{ Exception -> 0x0432 }
                    r3 = 214; // 0xd6 float:3.0E-43 double:1.057E-321;
                    r4 = "dst-dir is null when copying tbs core!";
                    r0.aM(r3, r4);	 Catch:{ Exception -> 0x0432 }
                    r0 = com.tencent.smtt.sdk.k.fM(r1);	 Catch:{ Exception -> 0x0432 }
                    r3 = -536; // 0xfffffffffffffde8 float:NaN double:NaN;
                    r0.CZ(r3);	 Catch:{ Exception -> 0x0432 }
                    goto L_0x0552;
                L_0x0601:
                    r8.ceC();
                    r0 = com.tencent.smtt.sdk.k.fM(r1);
                    r1 = -538; // 0xfffffffffffffde6 float:NaN double:NaN;
                    r0.CZ(r1);
                    goto L_0x0009;
                L_0x060f:
                    r4 = move-exception;
                L_0x0610:
                    r4 = r0;
                    r6 = r3;
                    goto L_0x03a7;
                L_0x0614:
                    r0 = move-exception;
                    r0 = r3;
                    r3 = r4;
                L_0x0617:
                    if (r3 == 0) goto L_0x0620;
                L_0x0619:
                    r3.close();	 Catch:{ IOException -> 0x061f }
                    r4 = r0;
                    goto L_0x03a7;
                L_0x061f:
                    r3 = move-exception;
                L_0x0620:
                    r4 = r0;
                    goto L_0x03a7;
                L_0x0623:
                    r0 = "TbsInstaller";
                    r1 = "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE_EX";
                    com.tencent.smtt.utils.TbsLog.i(r0, r1);
                    r0 = r15.obj;
                    r0 = (java.lang.Object[]) r0;
                    r0 = (java.lang.Object[]) r0;
                    r2 = r14.wVo;
                    r1 = 0;
                    r1 = r0[r1];
                    r1 = (android.content.Context) r1;
                    r3 = 1;
                    r0 = r0[r3];
                    r0 = (android.os.Bundle) r0;
                    r2.f(r1, r0);
                    goto L_0x0009;
                L_0x0643:
                    r3 = move-exception;
                    goto L_0x0431;
                L_0x0646:
                    r0 = move-exception;
                    r4 = r3;
                    goto L_0x042c;
                L_0x064a:
                    r3 = move-exception;
                    r3 = r4;
                    goto L_0x0617;
                L_0x064d:
                    r4 = move-exception;
                    goto L_0x0617;
                L_0x064f:
                    r0 = r5;
                    goto L_0x047a;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.p.2.handleMessage(android.os.Message):void");
                }
            };
        }
    }

    static int Vt(String str) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        int i = 0;
        if (str != null) {
            BufferedInputStream bufferedInputStream2 = null;
            try {
                File file = new File(new File(str), "tbs.conf");
                if (file.exists()) {
                    Properties properties = new Properties();
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    try {
                        properties.load(bufferedInputStream);
                        bufferedInputStream.close();
                        String property = properties.getProperty("tbs_core_version");
                        if (property == null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e) {
                            }
                        } else {
                            i = Integer.parseInt(property);
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                    } catch (Exception e3) {
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e4) {
                            }
                        }
                        return i;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream2 = bufferedInputStream;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e5) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e6) {
                bufferedInputStream = null;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                return i;
            } catch (Throwable th3) {
                th = th3;
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                throw th;
            }
        }
        return i;
    }

    private synchronized boolean a(final Context context, Context context2) {
        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp");
        if (!wVn) {
            wVn = true;
            new Thread(this, null) {
                final /* synthetic */ p wVo;

                public final void run() {
                    TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread start");
                    try {
                        File file = null == null ? new File(t.ceK()) : p.gk(null);
                        File gk = p.gk(context);
                        if (VERSION.SDK_INT < 21) {
                            f.a(file, gk, new FileFilter(this) {
                                final /* synthetic */ AnonymousClass3 wVr;

                                {
                                    this.wVr = r1;
                                }

                                public final boolean accept(File file) {
                                    return file.getName().endsWith(".dex");
                                }
                            });
                        }
                        f.a(file, gk, new FileFilter(this) {
                            final /* synthetic */ AnonymousClass3 wVr;

                            {
                                this.wVr = r1;
                            }

                            public final boolean accept(File file) {
                                return file.getName().endsWith("tbs.conf");
                            }
                        });
                        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread done");
                    } catch (Exception e) {
                    }
                }
            }.start();
        }
        return true;
    }

    private boolean a(Context context, File file) {
        try {
            File[] listFiles = file.listFiles(new FileFilter(this) {
                final /* synthetic */ p wVo;

                {
                    this.wVo = r1;
                }

                public final boolean accept(File file) {
                    return file.getName().endsWith(".jar");
                }
            });
            int length = listFiles.length;
            if (VERSION.SDK_INT < 16 && context.getPackageName() != null && context.getPackageName().equalsIgnoreCase("com.tencent.tbs")) {
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                }
            }
            ClassLoader classLoader = context.getClassLoader();
            for (int i = 0; i < length; i++) {
                TbsLog.i("TbsInstaller", "jarFile: " + listFiles[i].getAbsolutePath());
                DexClassLoader dexClassLoader = new DexClassLoader(listFiles[i].getAbsolutePath(), file.getAbsolutePath(), null, classLoader);
            }
            return true;
        } catch (Exception e2) {
            r.gr(context).aM(ag.CTRL_INDEX, e2.toString());
            TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(android.content.Context r9, java.io.File r10, boolean r11) {
        /*
        r0 = 1;
        r1 = 0;
        r2 = "TbsInstaller";
        r3 = "TbsInstaller-unzipTbs start";
        com.tencent.smtt.utils.TbsLog.i(r2, r3);
        r2 = com.tencent.smtt.utils.f.K(r10);
        if (r2 != 0) goto L_0x0027;
    L_0x0011:
        r0 = com.tencent.smtt.sdk.r.gr(r9);
        r2 = 204; // 0xcc float:2.86E-43 double:1.01E-321;
        r3 = "apk is invalid!";
        r0.aM(r2, r3);
        r0 = com.tencent.smtt.sdk.k.fM(r9);
        r2 = -520; // 0xfffffffffffffdf8 float:NaN double:NaN;
        r0.CZ(r2);
    L_0x0026:
        return r1;
    L_0x0027:
        r2 = "tbs";
        r3 = 0;
        r3 = r9.getDir(r2, r3);	 Catch:{ Throwable -> 0x007a }
        if (r11 == 0) goto L_0x0071;
    L_0x0031:
        r2 = new java.io.File;	 Catch:{ Throwable -> 0x007a }
        r4 = "core_share_decouple";
        r2.<init>(r3, r4);	 Catch:{ Throwable -> 0x007a }
    L_0x0039:
        r3 = r2.exists();	 Catch:{ Throwable -> 0x007a }
        if (r3 == 0) goto L_0x0052;
    L_0x003f:
        r3 = com.tencent.smtt.sdk.k.fM(r9);	 Catch:{ Throwable -> 0x007a }
        r3 = r3.wUG;	 Catch:{ Throwable -> 0x007a }
        r4 = "tbs_downloaddecouplecore";
        r5 = 0;
        r3 = r3.getInt(r4, r5);	 Catch:{ Throwable -> 0x007a }
        if (r3 == r0) goto L_0x0052;
    L_0x004f:
        com.tencent.smtt.utils.f.J(r2);	 Catch:{ Throwable -> 0x007a }
    L_0x0052:
        if (r11 == 0) goto L_0x0096;
    L_0x0054:
        r2 = go(r9);
        r4 = r2;
    L_0x0059:
        if (r4 != 0) goto L_0x009c;
    L_0x005b:
        r0 = com.tencent.smtt.sdk.r.gr(r9);
        r2 = 205; // 0xcd float:2.87E-43 double:1.013E-321;
        r3 = "tmp unzip dir is null!";
        r0.aM(r2, r3);
        r0 = com.tencent.smtt.sdk.k.fM(r9);
        r2 = -521; // 0xfffffffffffffdf7 float:NaN double:NaN;
        r0.CZ(r2);
        goto L_0x0026;
    L_0x0071:
        r2 = new java.io.File;	 Catch:{ Throwable -> 0x007a }
        r4 = "core_unzip_tmp";
        r2.<init>(r3, r4);	 Catch:{ Throwable -> 0x007a }
        goto L_0x0039;
    L_0x007a:
        r2 = move-exception;
        r3 = "TbsInstaller";
        r4 = new java.lang.StringBuilder;
        r5 = "TbsInstaller-unzipTbs -- delete unzip folder if exists exception";
        r4.<init>(r5);
        r2 = android.util.Log.getStackTraceString(r2);
        r2 = r4.append(r2);
        r2 = r2.toString();
        com.tencent.smtt.utils.TbsLog.e(r3, r2);
        goto L_0x0052;
    L_0x0096:
        r2 = gn(r9);
        r4 = r2;
        goto L_0x0059;
    L_0x009c:
        com.tencent.smtt.utils.f.I(r4);	 Catch:{ IOException -> 0x0125, Exception -> 0x016c }
        if (r11 == 0) goto L_0x00a5;
    L_0x00a1:
        r2 = 1;
        com.tencent.smtt.utils.f.c(r4, r2);	 Catch:{ IOException -> 0x0125, Exception -> 0x016c }
    L_0x00a5:
        r2 = com.tencent.smtt.utils.f.g(r10, r4);	 Catch:{ IOException -> 0x0125, Exception -> 0x016c }
        if (r11 == 0) goto L_0x00dc;
    L_0x00ab:
        r5 = r4.list();	 Catch:{ IOException -> 0x0125, Exception -> 0x016c }
        r3 = r1;
    L_0x00b0:
        r6 = r5.length;	 Catch:{ IOException -> 0x0125, Exception -> 0x016c }
        if (r3 >= r6) goto L_0x00cd;
    L_0x00b3:
        r6 = new java.io.File;	 Catch:{ IOException -> 0x0125, Exception -> 0x016c }
        r7 = r5[r3];	 Catch:{ IOException -> 0x0125, Exception -> 0x016c }
        r6.<init>(r4, r7);	 Catch:{ IOException -> 0x0125, Exception -> 0x016c }
        r7 = r6.getName();	 Catch:{ IOException -> 0x0125, Exception -> 0x016c }
        r8 = ".dex";
        r7 = r7.endsWith(r8);	 Catch:{ IOException -> 0x0125, Exception -> 0x016c }
        if (r7 == 0) goto L_0x00ca;
    L_0x00c7:
        r6.delete();	 Catch:{ IOException -> 0x0125, Exception -> 0x016c }
    L_0x00ca:
        r3 = r3 + 1;
        goto L_0x00b0;
    L_0x00cd:
        r3 = gm(r9);	 Catch:{ Exception -> 0x01f6, IOException -> 0x0125 }
        r5 = new java.io.File;	 Catch:{ Exception -> 0x01f6, IOException -> 0x0125 }
        r6 = "x5.tbs";
        r5.<init>(r3, r6);	 Catch:{ Exception -> 0x01f6, IOException -> 0x0125 }
        r5.delete();	 Catch:{ Exception -> 0x01f6, IOException -> 0x0125 }
    L_0x00dc:
        if (r2 != 0) goto L_0x0110;
    L_0x00de:
        com.tencent.smtt.utils.f.J(r4);	 Catch:{ IOException -> 0x0125, Exception -> 0x016c }
        r3 = com.tencent.smtt.sdk.k.fM(r9);	 Catch:{ IOException -> 0x0125, Exception -> 0x016c }
        r5 = -522; // 0xfffffffffffffdf6 float:NaN double:NaN;
        r3.CZ(r5);	 Catch:{ IOException -> 0x0125, Exception -> 0x016c }
        r3 = "TbsInstaller";
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0125, Exception -> 0x016c }
        r6 = "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#1! exist:";
        r5.<init>(r6);	 Catch:{ IOException -> 0x0125, Exception -> 0x016c }
        r6 = r4.exists();	 Catch:{ IOException -> 0x0125, Exception -> 0x016c }
        r5 = r5.append(r6);	 Catch:{ IOException -> 0x0125, Exception -> 0x016c }
        r5 = r5.toString();	 Catch:{ IOException -> 0x0125, Exception -> 0x016c }
        com.tencent.smtt.utils.TbsLog.e(r3, r5);	 Catch:{ IOException -> 0x0125, Exception -> 0x016c }
    L_0x0104:
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-unzipTbs done";
        com.tencent.smtt.utils.TbsLog.i(r0, r1);
        r1 = r2;
        goto L_0x0026;
    L_0x0110:
        r3 = 1;
        w(r9, r3);	 Catch:{ IOException -> 0x0125, Exception -> 0x016c }
        if (r11 == 0) goto L_0x0104;
    L_0x0116:
        r3 = gj(r9);	 Catch:{ IOException -> 0x0125, Exception -> 0x016c }
        r5 = 1;
        com.tencent.smtt.utils.f.c(r3, r5);	 Catch:{ IOException -> 0x0125, Exception -> 0x016c }
        r4.renameTo(r3);	 Catch:{ IOException -> 0x0125, Exception -> 0x016c }
        com.tencent.smtt.sdk.t.gt(r9);	 Catch:{ IOException -> 0x0125, Exception -> 0x016c }
        goto L_0x0104;
    L_0x0125:
        r2 = move-exception;
        r3 = com.tencent.smtt.sdk.k.fM(r9);	 Catch:{ all -> 0x01b3 }
        r5 = -523; // 0xfffffffffffffdf5 float:NaN double:NaN;
        r3.CZ(r5);	 Catch:{ all -> 0x01b3 }
        r3 = com.tencent.smtt.sdk.r.gr(r9);	 Catch:{ all -> 0x01b3 }
        r5 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        r3.c(r5, r2);	 Catch:{ all -> 0x01b3 }
        if (r4 == 0) goto L_0x01fb;
    L_0x013a:
        r2 = r4.exists();	 Catch:{ all -> 0x01b3 }
        if (r2 == 0) goto L_0x01fb;
    L_0x0140:
        if (r0 == 0) goto L_0x0161;
    L_0x0142:
        if (r4 == 0) goto L_0x0161;
    L_0x0144:
        com.tencent.smtt.utils.f.J(r4);	 Catch:{ Throwable -> 0x01be }
        r0 = "TbsInstaller";
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01be }
        r3 = "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x01be }
        r3 = r4.exists();	 Catch:{ Throwable -> 0x01be }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x01be }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x01be }
        com.tencent.smtt.utils.TbsLog.e(r0, r2);	 Catch:{ Throwable -> 0x01be }
    L_0x0161:
        r0 = "TbsInstaller";
        r2 = "TbsInstaller-unzipTbs done";
        com.tencent.smtt.utils.TbsLog.i(r0, r2);
        goto L_0x0026;
    L_0x016c:
        r2 = move-exception;
        r3 = com.tencent.smtt.sdk.k.fM(r9);	 Catch:{ all -> 0x01b3 }
        r5 = -523; // 0xfffffffffffffdf5 float:NaN double:NaN;
        r3.CZ(r5);	 Catch:{ all -> 0x01b3 }
        r3 = com.tencent.smtt.sdk.r.gr(r9);	 Catch:{ all -> 0x01b3 }
        r5 = 207; // 0xcf float:2.9E-43 double:1.023E-321;
        r3.c(r5, r2);	 Catch:{ all -> 0x01b3 }
        if (r4 == 0) goto L_0x01f9;
    L_0x0181:
        r2 = r4.exists();	 Catch:{ all -> 0x01b3 }
        if (r2 == 0) goto L_0x01f9;
    L_0x0187:
        if (r0 == 0) goto L_0x01a8;
    L_0x0189:
        if (r4 == 0) goto L_0x01a8;
    L_0x018b:
        com.tencent.smtt.utils.f.J(r4);	 Catch:{ Throwable -> 0x01da }
        r0 = "TbsInstaller";
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01da }
        r3 = "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x01da }
        r3 = r4.exists();	 Catch:{ Throwable -> 0x01da }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x01da }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x01da }
        com.tencent.smtt.utils.TbsLog.e(r0, r2);	 Catch:{ Throwable -> 0x01da }
    L_0x01a8:
        r0 = "TbsInstaller";
        r2 = "TbsInstaller-unzipTbs done";
        com.tencent.smtt.utils.TbsLog.i(r0, r2);
        goto L_0x0026;
    L_0x01b3:
        r0 = move-exception;
        r1 = "TbsInstaller";
        r2 = "TbsInstaller-unzipTbs done";
        com.tencent.smtt.utils.TbsLog.i(r1, r2);
        throw r0;
    L_0x01be:
        r0 = move-exception;
        r2 = "TbsInstaller";
        r3 = new java.lang.StringBuilder;
        r4 = "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exception:";
        r3.<init>(r4);
        r0 = android.util.Log.getStackTraceString(r0);
        r0 = r3.append(r0);
        r0 = r0.toString();
        com.tencent.smtt.utils.TbsLog.e(r2, r0);
        goto L_0x0161;
    L_0x01da:
        r0 = move-exception;
        r2 = "TbsInstaller";
        r3 = new java.lang.StringBuilder;
        r4 = "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exception:";
        r3.<init>(r4);
        r0 = android.util.Log.getStackTraceString(r0);
        r0 = r3.append(r0);
        r0 = r0.toString();
        com.tencent.smtt.utils.TbsLog.e(r2, r0);
        goto L_0x01a8;
    L_0x01f6:
        r3 = move-exception;
        goto L_0x00dc;
    L_0x01f9:
        r0 = r1;
        goto L_0x0187;
    L_0x01fb:
        r0 = r1;
        goto L_0x0140;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.p.a(android.content.Context, java.io.File, boolean):boolean");
    }

    private Context ak(Context context, int i) {
        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreHostContext tbsCoreTargetVer=" + i);
        if (i <= 0) {
            return null;
        }
        String[] ceL = t.ceL();
        int i2 = 0;
        while (i2 < 4) {
            if (!context.getPackageName().equalsIgnoreCase(ceL[i2]) && by(context, ceL[i2])) {
                Context bz = bz(context, ceL[i2]);
                if (bz == null) {
                    continue;
                } else if (fX(bz)) {
                    int gc = gc(bz);
                    TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext hostTbsCoreVer=" + gc);
                    if (gc != 0 && gc == i) {
                        TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext targetApp=" + ceL[i2]);
                        return bz;
                    }
                } else {
                    TbsLog.e("TbsInstaller", "TbsInstaller--getTbsCoreHostContext " + ceL[i2] + " illegal signature go on next");
                }
            }
            i2++;
        }
        return null;
    }

    private boolean b(Context context, File file) {
        try {
            File file2 = new File(file, "tbs_sdk_extension_dex.jar");
            File file3 = new File(file, "tbs_sdk_extension_dex.dex");
            DexClassLoader dexClassLoader = new DexClassLoader(file2.getAbsolutePath(), file.getAbsolutePath(), null, context.getClassLoader());
            Object Vm = c.Vm(file3.getAbsolutePath());
            if (TextUtils.isEmpty(Vm)) {
                r.gr(context).aM(n.CTRL_INDEX, "can not find oat command");
                return false;
            }
            for (File file4 : file.listFiles(new FileFilter(this) {
                final /* synthetic */ p wVo;

                {
                    this.wVo = r1;
                }

                public final boolean accept(File file) {
                    return file.getName().endsWith(".jar");
                }
            })) {
                String substring = file4.getName().substring(0, file4.getName().length() - 4);
                StringBuilder append = new StringBuilder("/system/bin/dex2oat ").append(Vm.replaceAll("tbs_sdk_extension_dex", substring)).append(" --dex-location=");
                ceA();
                Runtime.getRuntime().exec(append.append(gk(context)).append(File.separator).append(substring).append(".jar").toString()).waitFor();
            }
            return true;
        } catch (Throwable e) {
            r.gr(context).c(n.CTRL_INDEX, e);
            return false;
        }
    }

    private static boolean bx(Context context, String str) {
        File file = new File(context.getDir("tbs", 0), str);
        return file.exists() && new File(file, "tbs.conf").exists();
    }

    private static boolean by(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    private static Context bz(Context context, String str) {
        try {
            return context.createPackageContext(str, 2);
        } catch (Exception e) {
            return null;
        }
    }

    static synchronized p ceA() {
        p pVar;
        synchronized (p.class) {
            if (wVb == null) {
                synchronized (p.class) {
                    if (wVb == null) {
                        wVb = new p();
                    }
                }
            }
            pVar = wVb;
        }
        return pVar;
    }

    private synchronized boolean ceB() {
        return false;
    }

    public static void fS(Context context) {
        if (!fU(context)) {
            if (bx(context, "core_unzip_tmp")) {
                i.cec().a(context, 417, new Throwable("TMP_TBS_UNZIP_FOLDER_NAME"));
                TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_UNZIP_FOLDER_NAME");
            } else if (bx(context, "core_share_backup_tmp")) {
                i.cec().a(context, 417, new Throwable("TMP_BACKUP_TBSCORE_FOLDER_NAME"));
                TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_BACKUP_TBSCORE_FOLDER_NAME");
            } else if (bx(context, "core_copy_tmp")) {
                i.cec().a(context, 417, new Throwable("TMP_TBS_COPY_FOLDER_NAME"));
                TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_COPY_FOLDER_NAME");
            }
        }
    }

    private static boolean fU(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return new File(context.getDir("tbs", 0), "tmp_folder_core_to_read.conf").exists();
        } catch (Exception e) {
            return true;
        }
    }

    public static boolean fV(Context context) {
        try {
            File file = new File(f.al(context, 4), "x5.tbs.decouple");
            ceA();
            File go = go(context);
            f.I(go);
            f.c(go, true);
            f.g(file, go);
            String[] list = go.list();
            for (String file2 : list) {
                File file3 = new File(go, file2);
                if (file3.getName().endsWith(".dex")) {
                    file3.delete();
                }
            }
            ceA();
            w(context, true);
            file = gj(context);
            f.c(file, true);
            go.renameTo(file);
            t.gt(context);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean fW(Context context) {
        boolean z = false;
        TbsLog.i("TbsInstaller", new StringBuilder("TbsInstaller-doTbsDexOpt start - dirMode: 0").toString());
        try {
            if (k.fM(context).wUG.getInt("tbs_downloaddecouplecore", 0) == 1) {
                return true;
            }
            boolean z2;
            boolean z3;
            File gn = gn(context);
            try {
                String property = System.getProperty("java.vm.version");
                z2 = property != null && property.startsWith("2");
                z3 = z2;
            } catch (Throwable th) {
                r.gr(context).c(n.CTRL_INDEX, th);
                z3 = false;
            }
            z2 = VERSION.SDK_INT == 23;
            boolean z4 = k.fM(context).wUG.getBoolean("tbs_stop_preoat", false);
            if (z3 && z2 && !z4) {
                z = true;
            }
            return (z && b(context, gn)) ? true : a(context, gn);
        } catch (Exception e) {
            r.gr(context).aM(ag.CTRL_INDEX, e.toString());
            TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
            return true;
        }
    }

    static boolean fX(Context context) {
        if (t.ceK() != null) {
            return true;
        }
        try {
            Signature signature = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0];
            return context.getPackageName().equals("com.tencent.mtt") ? signature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a") : context.getPackageName().equals("com.tencent.mm") ? signature.toCharsString().equals("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499") : context.getPackageName().equals("com.tencent.mobileqq") ? signature.toCharsString().equals("30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049") : context.getPackageName().equals("com.tencent.tbs") ? signature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a") : context.getPackageName().equals("com.qzone") ? signature.toCharsString().equals("308202ad30820216a00302010202044c26cea2300d06092a864886f70d010105050030819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d301e170d3130303632373034303830325a170d3335303632313034303830325a30819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d30819f300d06092a864886f70d010101050003818d003081890281810082d6aca037a9843fbbe88b6dd19f36e9c24ce174c1b398f3a529e2a7fe02de99c27539602c026edf96ad8d43df32a85458bca1e6fbf11958658a7d6751a1d9b782bf43a8c19bd1c06bdbfd94c0516326ae3cf638ac42bb470580e340c46e6f306a772c1ef98f10a559edf867f3f31fe492808776b7bd953b2cba2d2b2d66a44f0203010001300d06092a864886f70d0101050500038181006003b04a8a8c5be9650f350cda6896e57dd13e6e83e7f891fc70f6a3c2eaf75cfa4fc998365deabbd1b9092159edf4b90df5702a0d101f8840b5d4586eb92a1c3cd19d95fbc1c2ac956309eda8eef3944baf08c4a49d3b9b3ffb06bc13dab94ecb5b8eb74e8789aa0ba21cb567f538bbc59c2a11e6919924a24272eb79251677") : !context.getPackageName().equals("com.tencent.qqpimsecure") || signature.toCharsString().equals("30820239308201a2a00302010202044c96f48f300d06092a864886f70d01010505003060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e57753020170d3130303932303035343334335a180f32303635303632333035343334335a3060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e577530819f300d06092a864886f70d010101050003818d0030818902818100b56e79dbb1185a79e52d792bb3d0bb3da8010d9b87da92ec69f7dc5ad66ab6bfdff2a6a1ed285dd2358f28b72a468be7c10a2ce30c4c27323ed4edcc936080e5bedc2cbbca0b7e879c08a631182793f44bb3ea284179b263410c298e5f6831032c9702ba4a74e2ccfc9ef857f12201451602fc8e774ac59d6398511586c83d1d0203010001300d06092a864886f70d0101050500038181002475615bb65b8d8786b890535802948840387d06b1692ff3ea47ef4c435719ba1865b81e6bfa6293ce31747c3cd6b34595b485cc1563fd90107ba5845c28b95c79138f0dec288940395bc10f92f2b69d8dc410999deb38900974ce9984b678030edfba8816582f56160d87e38641288d8588d2a31e20b89f223d788dd35cc9c8");
        } catch (Exception e) {
            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore getPackageInfo fail");
            return false;
        }
    }

    private void fY(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip");
        ac.cfb();
        if (ac.cfa() == null && ac.cfb().gF(context) == null) {
            TbsLog.e("TbsInstaller", "generateNewTbsCoreFromUnzip -- failed to get rename fileLock#2!");
            return;
        }
        try {
            gf(context);
            TbsLog.i("TbsInstaller", "TbsInstaller--renameShareDir");
            File gn = gn(context);
            File gk = gk(context);
            if (!(gn == null || gk == null)) {
                gn.renameTo(gk);
                w(context, false);
            }
            if (!t.gu(context)) {
                t.gs(context);
            }
            j.fL(context).dj("dexopt_retry_num", 0);
            j.fL(context).dj("unzip_retry_num", 0);
            j.fL(context).dj("unlzma_status", 0);
            j.fL(context).dj("incrupdate_retry_num", 0);
            j.fL(context).eB(0, 3);
            j.fL(context).fe("install_apk_path", "");
            j.fL(context).dj("incrupdate_status", -1);
            if (!t.gu(context)) {
                int i = k.fM(context).wUG.getInt("tbs_decouplecoreversion", 0);
                if (i > 0) {
                    ceA();
                    if (i != gb(context) && i == ceA().gc(context)) {
                        gg(context);
                    }
                }
                StringBuilder append = new StringBuilder("TbsInstaller--generateNewTbsCoreFromUnzip #1 deCoupleCoreVersion is ").append(i).append(" getTbsCoreShareDecoupleCoreVersion is ");
                ceA();
                TbsLog.i("TbsInstaller", append.append(gb(context)).append(" getTbsCoreInstalledVerInNolock is ").append(ceA().gc(context)).toString());
            }
            if (t.gu(context)) {
                t.c(context, ge(context), true);
            }
            wVj.set(Integer.valueOf(0));
        } catch (Throwable th) {
            r.gr(context).aM(219, "exception when renameing from unzip:" + th.toString());
            TbsLog.e("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip Exception", true);
        }
    }

    private void fZ(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy");
        ac.cfb();
        if (ac.cfa() == null && ac.cfb().gF(context) == null) {
            TbsLog.e("TbsInstaller", "generateNewTbsCoreFromCopy -- failed to get rename fileLock#2!");
            return;
        }
        try {
            gf(context);
            TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsCoreCopyDir");
            File gp = gp(context);
            File gk = gk(context);
            if (!(gp == null || gk == null)) {
                gp.renameTo(gk);
                w(context, false);
            }
            t.gs(context);
            j.fL(context).eA(0, 3);
            if (!t.gu(context)) {
                int i = k.fM(context).wUG.getInt("tbs_decouplecoreversion", 0);
                if (i > 0) {
                    ceA();
                    if (i != gb(context) && i == ceA().gc(context)) {
                        gg(context);
                    }
                }
                StringBuilder append = new StringBuilder("TbsInstaller--generateNewTbsCoreFromCopy #1 deCoupleCoreVersion is ").append(i).append(" getTbsCoreShareDecoupleCoreVersion is ");
                ceA();
                TbsLog.i("TbsInstaller", append.append(gb(context)).append(" getTbsCoreInstalledVerInNolock is ").append(ceA().gc(context)).toString());
            }
            wVj.set(Integer.valueOf(0));
        } catch (Exception e) {
            r.gr(context).aM(219, "exception when renameing from copy:" + e.toString());
        }
    }

    static int ga(Context context) {
        int i = 0;
        BufferedInputStream bufferedInputStream = null;
        BufferedInputStream bufferedInputStream2;
        try {
            File gn = gn(context);
            TbsLog.i("TbsInstaller", "TbsInstaller--getTmpTbsCoreVersionUnzipDir  tbsShareDir is " + gn);
            File file = new File(gn, "tbs.conf");
            if (file.exists()) {
                Properties properties = new Properties();
                bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream2);
                    bufferedInputStream2.close();
                    String property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e) {
                        }
                    } else {
                        i = Integer.parseInt(property);
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e2) {
                        }
                    }
                } catch (Exception e3) {
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e4) {
                        }
                    }
                    return i;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Exception e6) {
            bufferedInputStream2 = null;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            return i;
        } catch (Throwable th3) {
            th2 = th3;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th2;
        }
        return i;
    }

    static int gb(Context context) {
        int i = 0;
        BufferedInputStream bufferedInputStream = null;
        BufferedInputStream bufferedInputStream2;
        try {
            File file = new File(gj(context), "tbs.conf");
            if (file.exists()) {
                Properties properties = new Properties();
                bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream2);
                    bufferedInputStream2.close();
                    String property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e) {
                        }
                    } else {
                        i = Integer.parseInt(property);
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e2) {
                        }
                    }
                } catch (Exception e3) {
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e4) {
                        }
                    }
                    return i;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Exception e6) {
            bufferedInputStream2 = null;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            return i;
        } catch (Throwable th3) {
            th2 = th3;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th2;
        }
        return i;
    }

    private void gf(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--deleteOldCore");
        f.c(gk(context), false);
    }

    private static void gh(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--clearNewTbsCore");
        File gn = gn(context);
        if (gn != null) {
            f.c(gn, false);
        }
        j.fL(context).eB(0, 5);
        j.fL(context).dj("incrupdate_status", -1);
        QbSdk.bv(context, "TbsInstaller::clearNewTbsCore forceSysWebViewInner!");
    }

    static void gi(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--cleanStatusAndTmpDir");
        j.fL(context).dj("dexopt_retry_num", 0);
        j.fL(context).dj("unzip_retry_num", 0);
        j.fL(context).dj("unlzma_status", 0);
        j.fL(context).dj("incrupdate_retry_num", 0);
        if (k.fM(context).wUG.getInt("tbs_downloaddecouplecore", 0) != 1) {
            j.fL(context).eB(0, -1);
            j.fL(context).fe("install_apk_path", "");
            j.fL(context).dj("copy_retry_num", 0);
            j.fL(context).dj("incrupdate_status", -1);
            j.fL(context).eA(0, -1);
            f.c(gn(context), true);
            f.c(gp(context), true);
        }
    }

    static File gj(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_share_decouple");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    static File gk(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_share");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    static File gl(Context context) {
        File file = new File(context.getDir("tbs", 0), "share");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    static File gm(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_private");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    static File gn(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_unzip_tmp");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    private static File go(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_unzip_tmp_decouple");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    static File gp(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_copy_tmp");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    static void o(Context context, String str, int i) {
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsApkPath=" + str);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsCoreTargetVer=" + i);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentThreadName=" + Thread.currentThread().getName());
        Object obj = new Object[]{context, str, Integer.valueOf(i)};
        Message message = new Message();
        message.what = 1;
        message.obj = obj;
        wVk.sendMessage(message);
    }

    private synchronized boolean s(Context context, boolean z) {
        Throwable th;
        boolean z2 = false;
        boolean z3 = true;
        synchronized (this) {
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy");
            try {
                if (gq(context)) {
                    boolean tryLock = wVg.tryLock();
                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy Locked =" + tryLock);
                    if (tryLock) {
                        int Vp = j.fL(context).Vp("copy_status");
                        int a = a(false, context);
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy copyStatus =" + Vp);
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer =" + a);
                        if (Vp == 1) {
                            if (a == 0) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer = 0", true);
                                fZ(context);
                            } else if (z) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer != 0", true);
                                fZ(context);
                            }
                            wVg.unlock();
                            z2 = z3;
                        }
                        z3 = false;
                        try {
                            wVg.unlock();
                            z2 = z3;
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            z2 = z3;
                            th = th3;
                            r.gr(context).aM(cp.CTRL_INDEX, th.toString());
                            QbSdk.bv(context, "TbsInstaller::enableTbsCoreFromCopy exception:" + Log.getStackTraceString(th));
                            return z2;
                        }
                    }
                    ceC();
                }
            } catch (Throwable th4) {
                th = th4;
                r.gr(context).aM(cp.CTRL_INDEX, th.toString());
                QbSdk.bv(context, "TbsInstaller::enableTbsCoreFromCopy exception:" + Log.getStackTraceString(th));
                return z2;
            }
        }
        return z2;
    }

    private synchronized boolean t(Context context, boolean z) {
        Object obj;
        boolean z2 = true;
        boolean z3 = false;
        synchronized (this) {
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip canRenameTmpDir =" + z);
            try {
                if (gq(context)) {
                    boolean tryLock = wVg.tryLock();
                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip locked=" + tryLock);
                    if (tryLock) {
                        int Vp = j.fL(context).Vp("install_status");
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip installStatus=" + Vp);
                        int a = a(false, context);
                        if (Vp == 2) {
                            if (a == 0) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer = 0", false);
                                fY(context);
                            } else if (z) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer != 0", false);
                                fY(context);
                            }
                            wVg.unlock();
                            z3 = z2;
                        }
                        z2 = false;
                        try {
                            wVg.unlock();
                            z3 = z2;
                        } catch (Exception e) {
                            Exception exception = e;
                            z3 = z2;
                            Exception exception2 = exception;
                            QbSdk.bv(context, "TbsInstaller::enableTbsCoreFromUnzip Exception: " + obj);
                            return z3;
                        }
                    }
                    ceC();
                }
            } catch (Exception e2) {
                obj = e2;
                QbSdk.bv(context, "TbsInstaller::enableTbsCoreFromUnzip Exception: " + obj);
                return z3;
            } catch (Throwable th) {
                wVg.unlock();
            }
        }
        return z3;
    }

    static void w(Context context, boolean z) {
        if (context == null) {
            r.gr(context).aM(225, "setTmpFolderCoreToRead context is null");
            return;
        }
        try {
            File file = new File(context.getDir("tbs", 0), "tmp_folder_core_to_read.conf");
            if (!z) {
                f.J(file);
            } else if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            r.gr(context).aM(225, "setTmpFolderCoreToRead Exception message is " + e.getMessage() + " Exception cause is " + e.getCause());
        }
    }

    public final int a(boolean z, Context context) {
        if (z || ((Integer) wVj.get()).intValue() <= 0) {
            wVj.set(Integer.valueOf(gc(context)));
        }
        return ((Integer) wVj.get()).intValue();
    }

    final boolean aj(Context context, int i) {
        if (l.fP(context)) {
            return false;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore targetTbsCoreVer=" + i);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentThreadName=" + Thread.currentThread().getName());
        if (ak(context, i) != null) {
            Object obj = new Object[]{ak(context, i), context, Integer.valueOf(i)};
            Message message = new Message();
            message.what = 2;
            message.obj = obj;
            wVk.sendMessage(message);
            return true;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller--installLocalTbsCore copy from null");
        return false;
    }

    public final String bA(Context context, String str) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        String str2 = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                File file = new File(gk(context), "tbs.conf");
                if (file.exists()) {
                    Properties properties = new Properties();
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    try {
                        properties.load(bufferedInputStream);
                        bufferedInputStream.close();
                        str2 = properties.getProperty(str);
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e) {
                        }
                    } catch (Exception e2) {
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e3) {
                            }
                        }
                        return str2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e4) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e5) {
                bufferedInputStream = str2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                return str2;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                bufferedInputStream = str2;
                th = th4;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                throw th;
            }
        }
        return str2;
    }

    final synchronized void ceC() {
        int i = this.wVc;
        this.wVc = i - 1;
        if (i > 1 || !this.wVf) {
            TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock with skip");
        } else {
            TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock without skip");
            f.a(this.wVd, this.wVe);
            this.wVf = false;
        }
    }

    final void f(Context context, Bundle bundle) {
        Throwable e;
        Bundle bundle2;
        String string;
        if (fT(context)) {
            k.fM(context).CZ(-539);
            return;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread");
        if (bundle != null && context != null) {
            if (!f.gU(context)) {
                r.gr(context).aM(h.CTRL_INDEX, "rom is not enough when patching tbs core! curAvailROM=" + u.cfA() + ",minReqRom=" + k.fM(context).cei());
                k.fM(context).CZ(-540);
            } else if (gq(context)) {
                boolean tryLock = wVh.tryLock();
                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread locked=" + tryLock);
                if (tryLock) {
                    int Vq;
                    Bundle e2;
                    try {
                        QbSdk.setTBSInstallingStatus(true);
                        if (gc(context) <= 0 || j.fL(context).Vp("incrupdate_status") == 1) {
                            QbSdk.setTBSInstallingStatus(false);
                            wVh.unlock();
                            ceC();
                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                            QbSdk.setTBSInstallingStatus(false);
                            return;
                        }
                        int i;
                        String string2;
                        int i2 = k.fM(context).wUG.getInt("tbs_responsecode", 0);
                        boolean z = i2 == 1 || i2 == 2 || i2 == 4;
                        if (!(z || i2 == 0)) {
                            Vq = j.fL(context).Vq("incrupdate_retry_num");
                            if (Vq > 5) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread exceed incrupdate num");
                                Object string3 = bundle.getString("old_apk_location");
                                Object string4 = bundle.getString("new_apk_location");
                                Object string5 = bundle.getString("diff_file_location");
                                if (!TextUtils.isEmpty(string3)) {
                                    f.J(new File(string3));
                                }
                                if (!TextUtils.isEmpty(string4)) {
                                    f.J(new File(string4));
                                }
                                if (!TextUtils.isEmpty(string5)) {
                                    f.J(new File(string5));
                                }
                                k.fM(context).wUF.put("tbs_needdownload", Boolean.valueOf(true));
                                k.fM(context).commit();
                                r.gr(context).aM(224, "incrUpdate exceed retry max num");
                                wVh.unlock();
                                ceC();
                                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                QbSdk.setTBSInstallingStatus(false);
                                return;
                            }
                            j.fL(context).dj("incrupdate_retry_num", Vq + 1);
                            File gm = gm(context);
                            if (gm != null && new File(gm, "x5.tbs").exists()) {
                                k.fM(context).CZ(-550);
                                e2 = QbSdk.e(context, bundle);
                                if (e2 == null) {
                                    i = 1;
                                } else {
                                    try {
                                        i = e2.getInt("patch_result");
                                    } catch (Exception e3) {
                                        e = e3;
                                        try {
                                            TbsLog.i("TbsInstaller", "installLocalTbsCoreExInThread exception:" + Log.getStackTraceString(e));
                                            try {
                                                k.fM(context).CZ(-543);
                                                r.gr(context).aM(218, e.toString());
                                                wVh.unlock();
                                                ceC();
                                                k.fM(context).CZ(-546);
                                                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                                                k.fM(context).wUF.put("tbs_needdownload", Boolean.valueOf(true));
                                                k.fM(context).commit();
                                                r.gr(context).aM(b.CTRL_INDEX, new StringBuilder("incrUpdate fail! patch ret=1").toString());
                                                QbSdk.setTBSInstallingStatus(false);
                                                return;
                                            } catch (Throwable th) {
                                                e = th;
                                                bundle2 = e2;
                                                Vq = 1;
                                                wVh.unlock();
                                                ceC();
                                                if (Vq != 0) {
                                                    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                                                    j.fL(context).dj("incrupdate_retry_num", 0);
                                                    k.fM(context).CZ(-544);
                                                    j.fL(context).eB(0, -1);
                                                    j.fL(context).dj("incrupdate_status", 1);
                                                    string = bundle2.getString("apk_path");
                                                    h.a(new File(string), context);
                                                    p(context, string, bundle2.getInt("tbs_core_ver"));
                                                } else if (Vq == 2) {
                                                    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                                } else {
                                                    k.fM(context).CZ(-546);
                                                    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                                                    k.fM(context).wUF.put("tbs_needdownload", Boolean.valueOf(true));
                                                    k.fM(context).commit();
                                                    r.gr(context).aM(b.CTRL_INDEX, "incrUpdate fail! patch ret=" + Vq);
                                                }
                                                QbSdk.setTBSInstallingStatus(false);
                                                throw e;
                                            }
                                        } catch (Throwable th2) {
                                            e = th2;
                                            bundle2 = e2;
                                            Vq = 2;
                                            wVh.unlock();
                                            ceC();
                                            if (Vq != 0) {
                                                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                                                j.fL(context).dj("incrupdate_retry_num", 0);
                                                k.fM(context).CZ(-544);
                                                j.fL(context).eB(0, -1);
                                                j.fL(context).dj("incrupdate_status", 1);
                                                string = bundle2.getString("apk_path");
                                                h.a(new File(string), context);
                                                p(context, string, bundle2.getInt("tbs_core_ver"));
                                            } else if (Vq == 2) {
                                                k.fM(context).CZ(-546);
                                                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                                                k.fM(context).wUF.put("tbs_needdownload", Boolean.valueOf(true));
                                                k.fM(context).commit();
                                                r.gr(context).aM(b.CTRL_INDEX, "incrUpdate fail! patch ret=" + Vq);
                                            } else {
                                                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                            }
                                            QbSdk.setTBSInstallingStatus(false);
                                            throw e;
                                        }
                                    }
                                }
                                wVh.unlock();
                                ceC();
                                if (i == 0) {
                                    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                                    j.fL(context).dj("incrupdate_retry_num", 0);
                                    k.fM(context).CZ(-544);
                                    j.fL(context).eB(0, -1);
                                    j.fL(context).dj("incrupdate_status", 1);
                                    string2 = e2.getString("apk_path");
                                    h.a(new File(string2), context);
                                    p(context, string2, e2.getInt("tbs_core_ver"));
                                } else if (i != 2) {
                                    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                } else {
                                    k.fM(context).CZ(-546);
                                    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                                    k.fM(context).wUF.put("tbs_needdownload", Boolean.valueOf(true));
                                    k.fM(context).commit();
                                    r.gr(context).aM(b.CTRL_INDEX, "incrUpdate fail! patch ret=" + i);
                                }
                                QbSdk.setTBSInstallingStatus(false);
                                return;
                            }
                        }
                        e2 = null;
                        i = 2;
                        wVh.unlock();
                        ceC();
                        if (i == 0) {
                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                            j.fL(context).dj("incrupdate_retry_num", 0);
                            k.fM(context).CZ(-544);
                            j.fL(context).eB(0, -1);
                            j.fL(context).dj("incrupdate_status", 1);
                            string2 = e2.getString("apk_path");
                            h.a(new File(string2), context);
                            p(context, string2, e2.getInt("tbs_core_ver"));
                        } else if (i != 2) {
                            k.fM(context).CZ(-546);
                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                            k.fM(context).wUF.put("tbs_needdownload", Boolean.valueOf(true));
                            k.fM(context).commit();
                            r.gr(context).aM(b.CTRL_INDEX, "incrUpdate fail! patch ret=" + i);
                        } else {
                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                        }
                        QbSdk.setTBSInstallingStatus(false);
                        return;
                    } catch (Throwable e4) {
                        Throwable th3 = e4;
                        e2 = null;
                        e = th3;
                        TbsLog.i("TbsInstaller", "installLocalTbsCoreExInThread exception:" + Log.getStackTraceString(e));
                        k.fM(context).CZ(-543);
                        r.gr(context).aM(218, e.toString());
                        wVh.unlock();
                        ceC();
                        k.fM(context).CZ(-546);
                        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                        k.fM(context).wUF.put("tbs_needdownload", Boolean.valueOf(true));
                        k.fM(context).commit();
                        r.gr(context).aM(b.CTRL_INDEX, new StringBuilder("incrUpdate fail! patch ret=1").toString());
                        QbSdk.setTBSInstallingStatus(false);
                        return;
                    } catch (Throwable e42) {
                        bundle2 = null;
                        e = e42;
                        Vq = 2;
                        wVh.unlock();
                        ceC();
                        if (Vq != 0) {
                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                            j.fL(context).dj("incrupdate_retry_num", 0);
                            k.fM(context).CZ(-544);
                            j.fL(context).eB(0, -1);
                            j.fL(context).dj("incrupdate_status", 1);
                            string = bundle2.getString("apk_path");
                            h.a(new File(string), context);
                            p(context, string, bundle2.getInt("tbs_core_ver"));
                        } else if (Vq == 2) {
                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                        } else {
                            k.fM(context).CZ(-546);
                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                            k.fM(context).wUF.put("tbs_needdownload", Boolean.valueOf(true));
                            k.fM(context).commit();
                            r.gr(context).aM(b.CTRL_INDEX, "incrUpdate fail! patch ret=" + Vq);
                        }
                        QbSdk.setTBSInstallingStatus(false);
                        throw e;
                    }
                }
                k.fM(context).CZ(-547);
                ceC();
            } else {
                k.fM(context).CZ(-541);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final boolean fT(android.content.Context r11) {
        /*
        r10 = this;
        r1 = 1;
        r2 = 0;
        r0 = gk(r11);
        r5 = new java.io.File;
        r3 = "tbs.conf";
        r5.<init>(r0, r3);
        r0 = r5.exists();
        if (r0 != 0) goto L_0x0015;
    L_0x0014:
        return r2;
    L_0x0015:
        r4 = new java.util.Properties;
        r4.<init>();
        r0 = 0;
        r6 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x007b, all -> 0x0086 }
        r6.<init>(r5);	 Catch:{ Throwable -> 0x007b, all -> 0x0086 }
        r3 = new java.io.BufferedInputStream;	 Catch:{ Throwable -> 0x007b, all -> 0x0086 }
        r3.<init>(r6);	 Catch:{ Throwable -> 0x007b, all -> 0x0086 }
        r4.load(r3);	 Catch:{ Throwable -> 0x0095, all -> 0x0093 }
        r0 = "tbs_local_installation";
        r6 = "false";
        r0 = r4.getProperty(r0, r6);	 Catch:{ Throwable -> 0x0095, all -> 0x0093 }
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Throwable -> 0x0095, all -> 0x0093 }
        r4 = r0.booleanValue();	 Catch:{ Throwable -> 0x0095, all -> 0x0093 }
        if (r4 == 0) goto L_0x009d;
    L_0x003c:
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0099, all -> 0x0093 }
        r8 = r5.lastModified();	 Catch:{ Throwable -> 0x0099, all -> 0x0093 }
        r6 = r6 - r8;
        r8 = 259200000; // 0xf731400 float:1.1984677E-29 double:1.280618154E-315;
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r0 <= 0) goto L_0x0077;
    L_0x004c:
        r0 = r1;
    L_0x004d:
        r5 = "TbsInstaller";
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0099, all -> 0x0093 }
        r7 = "TBS_LOCAL_INSTALLATION is:";
        r6.<init>(r7);	 Catch:{ Throwable -> 0x0099, all -> 0x0093 }
        r6 = r6.append(r4);	 Catch:{ Throwable -> 0x0099, all -> 0x0093 }
        r7 = " expired=";
        r6 = r6.append(r7);	 Catch:{ Throwable -> 0x0099, all -> 0x0093 }
        r6 = r6.append(r0);	 Catch:{ Throwable -> 0x0099, all -> 0x0093 }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x0099, all -> 0x0093 }
        com.tencent.smtt.utils.TbsLog.i(r5, r6);	 Catch:{ Throwable -> 0x0099, all -> 0x0093 }
        if (r0 != 0) goto L_0x0079;
    L_0x0070:
        r0 = r4 & r1;
        r3.close();	 Catch:{ IOException -> 0x008f }
    L_0x0075:
        r2 = r0;
        goto L_0x0014;
    L_0x0077:
        r0 = r2;
        goto L_0x004d;
    L_0x0079:
        r1 = r2;
        goto L_0x0070;
    L_0x007b:
        r1 = move-exception;
        r1 = r0;
        r0 = r2;
    L_0x007e:
        if (r1 == 0) goto L_0x0075;
    L_0x0080:
        r1.close();	 Catch:{ IOException -> 0x0084 }
        goto L_0x0075;
    L_0x0084:
        r1 = move-exception;
        goto L_0x0075;
    L_0x0086:
        r1 = move-exception;
        r3 = r0;
        r0 = r1;
    L_0x0089:
        if (r3 == 0) goto L_0x008e;
    L_0x008b:
        r3.close();	 Catch:{ IOException -> 0x0091 }
    L_0x008e:
        throw r0;
    L_0x008f:
        r1 = move-exception;
        goto L_0x0075;
    L_0x0091:
        r1 = move-exception;
        goto L_0x008e;
    L_0x0093:
        r0 = move-exception;
        goto L_0x0089;
    L_0x0095:
        r0 = move-exception;
        r1 = r3;
        r0 = r2;
        goto L_0x007e;
    L_0x0099:
        r0 = move-exception;
        r1 = r3;
        r0 = r4;
        goto L_0x007e;
    L_0x009d:
        r0 = r2;
        goto L_0x004d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.p.fT(android.content.Context):boolean");
    }

    final int gc(Context context) {
        BufferedInputStream bufferedInputStream;
        Exception e;
        int i = 0;
        try {
            File file = new File(gk(context), "tbs.conf");
            if (file.exists()) {
                Properties properties = new Properties();
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream);
                    bufferedInputStream.close();
                    String property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e2) {
                            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e2.toString());
                        }
                    } else {
                        i = Integer.parseInt(property);
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e22) {
                            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e22.toString());
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock Exception=" + e.toString());
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e222) {
                                TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e222.toString());
                            }
                        }
                        return i;
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e2222) {
                                TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e2222.toString());
                            }
                        }
                        throw th2;
                    }
                }
            }
        } catch (Exception e4) {
            e = e4;
            bufferedInputStream = null;
            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock Exception=" + e.toString());
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            return i;
        } catch (Throwable th3) {
            th2 = th3;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th2;
        }
        return i;
    }

    final boolean gd(Context context) {
        return new File(gk(context), "tbs.conf").exists();
    }

    final int ge(Context context) {
        Exception e;
        Throwable th;
        if (!gq(context)) {
            return -1;
        }
        boolean tryLock = wVg.tryLock();
        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer locked=" + tryLock);
        if (tryLock) {
            BufferedInputStream bufferedInputStream;
            try {
                File file = new File(gk(context), "tbs.conf");
                if (file.exists()) {
                    Properties properties = new Properties();
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    try {
                        properties.load(bufferedInputStream);
                        bufferedInputStream.close();
                        String property = properties.getProperty("tbs_core_version");
                        if (property == null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e2) {
                                TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e2.toString());
                            }
                            wVg.unlock();
                            ceC();
                            return 0;
                        }
                        wVj.set(Integer.valueOf(Integer.parseInt(property)));
                        int intValue = ((Integer) wVj.get()).intValue();
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e3) {
                            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e3.toString());
                        }
                        wVg.unlock();
                        ceC();
                        return intValue;
                    } catch (Exception e4) {
                        e = e4;
                        try {
                            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer Exception=" + e.toString());
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e22) {
                                    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e22.toString());
                                }
                            }
                            wVg.unlock();
                            ceC();
                            return 0;
                        } catch (Throwable th2) {
                            th = th2;
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e32) {
                                    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e32.toString());
                                }
                            }
                            wVg.unlock();
                            ceC();
                            throw th;
                        }
                    }
                }
                wVg.unlock();
                ceC();
                return 0;
            } catch (Exception e5) {
                e = e5;
                bufferedInputStream = null;
                TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer Exception=" + e.toString());
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                wVg.unlock();
                ceC();
                return 0;
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                wVg.unlock();
                ceC();
                throw th;
            }
        }
        ceC();
        return 0;
    }

    public final boolean gg(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple #0");
        File gk = gk(context);
        File gj = gj(context);
        try {
            f.c(gj, true);
            f.a(gk, gj, new FileFilter(this) {
                final /* synthetic */ p wVo;

                {
                    this.wVo = r1;
                }

                public final boolean accept(File file) {
                    return !file.getName().endsWith(".dex");
                }
            });
            t.gt(context);
            TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple success!!!");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    final synchronized boolean gq(Context context) {
        boolean z = true;
        synchronized (this) {
            this.wVc++;
            if (this.wVf) {
                TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= true");
            } else {
                this.wVe = f.b(context, true, "tbslock.txt");
                if (this.wVe != null) {
                    this.wVd = f.a(this.wVe);
                    if (this.wVd == null) {
                        z = false;
                    } else {
                        TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= false");
                        this.wVf = true;
                    }
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    @TargetApi(11)
    public final void p(Context context, String str, int i) {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream2;
        Throwable th;
        Throwable th2;
        k.fM(context).CZ(-501);
        if (fT(context)) {
            TbsLog.i("TbsInstaller", "isTbsLocalInstalled --> no installation!", true);
            k.fM(context).CZ(-502);
            return;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsApkPath=" + str);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer=" + i);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentThreadName=" + Thread.currentThread().getName());
        if ((VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).getInt("tbs_precheck_disable_version", -1) == i) {
            TbsLog.e("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- version:" + i + " is disabled by preload_x5_check!");
            k.fM(context).CZ(-503);
        } else if (!f.gU(context)) {
            long cfA = u.cfA();
            long cei = k.fM(context).cei();
            k.fM(context).CZ(-504);
            r.gr(context).aM(h.CTRL_INDEX, "rom is not enough when installing tbs core! curAvailROM=" + cfA + ",minReqRom=" + cei);
        } else if (gq(context)) {
            boolean tryLock = wVh.tryLock();
            TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread locked =" + tryLock);
            if (tryLock) {
                k.fM(context).CZ(-507);
                wVg.lock();
                try {
                    int i2;
                    Object obj;
                    int Vq = j.fL(context).Vq("copy_core_ver");
                    int Vq2 = j.fL(context).Vq("install_core_ver");
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreCopyVer =" + Vq);
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstallVer =" + Vq2);
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer =" + i);
                    if ((Vq2 > 0 && i > Vq2) || (Vq > 0 && i > Vq)) {
                        gi(context);
                    }
                    Vq = j.fL(context).Vp("install_status");
                    int gc = gc(context);
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus1=" + Vq);
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstalledVer=" + gc);
                    if (Vq < 0 || Vq >= 2) {
                        if (Vq == 3 && gc > 0 && (i > gc || i == 88888888)) {
                            Vq = -1;
                            gi(context);
                            TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- update TBS.....", true);
                        }
                        i2 = Vq;
                        obj = null;
                    } else {
                        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- retry.....", true);
                        i2 = Vq;
                        obj = 1;
                    }
                    k.fM(context).CZ(-508);
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus2=" + i2);
                    Vq = 0;
                    if (i2 <= 0) {
                        String Vr;
                        TbsLog.i("TbsInstaller", "STEP 2/2 begin installation.....", true);
                        k.fM(context).CZ(-509);
                        if (obj != null) {
                            Vq = j.fL(context).Vq("unzip_retry_num");
                            if (Vq > 10) {
                                r.gr(context).aM(bh.CTRL_INDEX, "exceed unzip retry num!");
                                gh(context);
                                k.fM(context).CZ(-510);
                                wVg.unlock();
                                wVh.unlock();
                                ceC();
                                return;
                            }
                            j.fL(context).dj("unzip_retry_num", Vq + 1);
                        }
                        if (str == null) {
                            Vr = j.fL(context).Vr("install_apk_path");
                            if (Vr == null) {
                                r.gr(context).aM(com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX, "apk path is null!");
                                k.fM(context).CZ(-511);
                                wVg.unlock();
                                wVh.unlock();
                                ceC();
                                return;
                            }
                        }
                        Vr = str;
                        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread apkPath =" + Vr);
                        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(Vr, 0);
                        gc = packageArchiveInfo != null ? packageArchiveInfo.versionCode : 0;
                        if (gc == 0) {
                            k.fM(context).CZ(-512);
                            r.gr(context).aM(aq.CTRL_INDEX, "apk version is 0!");
                            wVg.unlock();
                            wVh.unlock();
                            ceC();
                            return;
                        }
                        j.fL(context).fe("install_apk_path", Vr);
                        j.fL(context).eB(gc, 0);
                        k.fM(context).CZ(-548);
                        if (k.fM(context).wUG.getInt("tbs_downloaddecouplecore", 0) == 1) {
                            if (!a(context, new File(Vr), true)) {
                                r.gr(context).a(207, "unzipTbsApk failed", a.TYPE_INSTALL_DECOUPLE);
                                wVg.unlock();
                                wVh.unlock();
                                ceC();
                                return;
                            }
                        } else if (!a(context, new File(Vr), false)) {
                            r.gr(context).aM(207, "unzipTbsApk failed");
                            wVg.unlock();
                            wVh.unlock();
                            ceC();
                            return;
                        }
                        if (obj != null) {
                            Vq = j.fL(context).Vp("unlzma_status");
                            if (Vq > 5) {
                                r.gr(context).aM(223, "exceed unlzma retry num!");
                                k.fM(context).CZ(-553);
                                gh(context);
                                h.fK(context);
                                k.fM(context).wUF.put("tbs_needdownload", Boolean.valueOf(true));
                                k.fM(context).wUF.put("request_full_package", Boolean.valueOf(true));
                                k.fM(context).commit();
                                wVg.unlock();
                                wVh.unlock();
                                ceC();
                                return;
                            }
                            j.fL(context).dj("unlzma_status", Vq + 1);
                        }
                        TbsLog.i("TbsInstaller", "unlzma begin");
                        int i3 = k.cef().wUG.getInt("tbs_responsecode", 0);
                        if (gc(context) != 0) {
                            Object c = QbSdk.c(context, "can_unlzma", null);
                            tryLock = (c == null || !(c instanceof Boolean)) ? false : ((Boolean) c).booleanValue();
                            if (tryLock) {
                                Bundle bundle = new Bundle();
                                bundle.putInt("responseCode", i3);
                                if (k.fM(context).wUG.getInt("tbs_downloaddecouplecore", 0) == 1) {
                                    bundle.putString("unzip_temp_path", gj(context).getAbsolutePath());
                                } else {
                                    bundle.putString("unzip_temp_path", gn(context).getAbsolutePath());
                                }
                                c = QbSdk.c(context, "unlzma", bundle);
                                if (c == null) {
                                    TbsLog.i("TbsInstaller", "unlzma return null");
                                    r.gr(context).aM(222, "unlzma is null");
                                    c = null;
                                } else if (c instanceof Boolean) {
                                    if (((Boolean) c).booleanValue()) {
                                        c = 1;
                                        TbsLog.i("TbsInstaller", "unlzma success");
                                    } else {
                                        TbsLog.i("TbsInstaller", "unlzma return false");
                                        r.gr(context).aM(222, "unlzma return false");
                                        c = null;
                                    }
                                } else if (c instanceof Bundle) {
                                    c = 1;
                                } else {
                                    if (c instanceof Throwable) {
                                        TbsLog.i("TbsInstaller", "unlzma failure because Throwable" + Log.getStackTraceString((Throwable) c));
                                        r.gr(context).c(222, (Throwable) c);
                                    }
                                    c = null;
                                }
                                if (c == null) {
                                    wVg.unlock();
                                    wVh.unlock();
                                    ceC();
                                    return;
                                }
                            }
                        }
                        TbsLog.i("TbsInstaller", "unlzma finished");
                        j.fL(context).eB(gc, 1);
                        Vq = gc;
                    } else if (k.fM(context).wUG.getInt("tbs_downloaddecouplecore", 0) == 1) {
                        String Vr2;
                        if (str == null) {
                            Vr2 = j.fL(context).Vr("install_apk_path");
                            if (Vr2 == null) {
                                r.gr(context).aM(com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX, "apk path is null!");
                                k.fM(context).CZ(-511);
                                wVg.unlock();
                                wVh.unlock();
                                ceC();
                                return;
                            }
                        }
                        Vr2 = str;
                        a(context, new File(Vr2), true);
                    }
                    if (i2 < 2) {
                        if (obj != null) {
                            Vq2 = j.fL(context).Vq("dexopt_retry_num");
                            if (Vq2 > 10) {
                                r.gr(context).aM(bv.CTRL_INDEX, "exceed dexopt retry num!");
                                k.fM(context).CZ(-514);
                                gh(context);
                                wVg.unlock();
                                wVh.unlock();
                                ceC();
                                return;
                            }
                            j.fL(context).dj("dexopt_retry_num", Vq2 + 1);
                        }
                        k.fM(context).CZ(-549);
                        if (fW(context)) {
                            j.fL(context).eB(Vq, 2);
                            TbsLog.i("TbsInstaller", "STEP 2/2 installation completed! you can restart!", true);
                            TbsLog.i("TbsInstaller", "STEP 2/2 installation completed! you can restart! version:" + i);
                            k.fM(context).CZ(-516);
                            Editor edit = (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit();
                            edit.putInt("tbs_preload_x5_counter", 0);
                            edit.putInt("tbs_preload_x5_recorder", 0);
                            edit.putInt("tbs_preload_x5_version", i);
                            edit.commit();
                            k.fM(context).CZ(-517);
                            if (i == 88888888) {
                                new File(str).delete();
                                TbsLog.i("TbsInstaller", "Local tbs apk(" + str + ") is deleted!", true);
                                File file = new File(context.getDir("tbs", 0), "core_unzip_tmp");
                                if (file.canRead()) {
                                    File file2 = new File(file, "tbs.conf");
                                    Properties properties = new Properties();
                                    BufferedOutputStream bufferedOutputStream2 = null;
                                    try {
                                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file2));
                                        try {
                                            properties.load(bufferedInputStream);
                                            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                                        } catch (Throwable th3) {
                                            th = th3;
                                            if (bufferedOutputStream2 != null) {
                                                try {
                                                    bufferedOutputStream2.close();
                                                } catch (IOException e) {
                                                }
                                            }
                                            if (bufferedInputStream != null) {
                                                try {
                                                    bufferedInputStream.close();
                                                } catch (IOException e2) {
                                                }
                                            }
                                            throw th;
                                        }
                                        try {
                                            properties.setProperty("tbs_local_installation", "true");
                                            properties.store(bufferedOutputStream, null);
                                            TbsLog.i("TbsInstaller", "TBS_LOCAL_INSTALLATION is set!", true);
                                            try {
                                                bufferedOutputStream.close();
                                            } catch (IOException e3) {
                                            }
                                            try {
                                                bufferedInputStream.close();
                                            } catch (IOException e4) {
                                            }
                                        } catch (Throwable th4) {
                                            th2 = th4;
                                            bufferedOutputStream2 = bufferedOutputStream;
                                            th = th2;
                                            if (bufferedOutputStream2 != null) {
                                                bufferedOutputStream2.close();
                                            }
                                            if (bufferedInputStream != null) {
                                                bufferedInputStream.close();
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th5) {
                                        th2 = th5;
                                        bufferedInputStream = null;
                                        th = th2;
                                        if (bufferedOutputStream2 != null) {
                                            bufferedOutputStream2.close();
                                        }
                                        if (bufferedInputStream != null) {
                                            bufferedInputStream.close();
                                        }
                                        throw th;
                                    }
                                }
                            }
                            if (this.wVi) {
                                if (j.fL(context).Vp("incrupdate_status") != 1) {
                                }
                                r.gr(context).aM(j.fL(context).Vp("incrupdate_status") != 1 ? 221 : m.CTRL_INDEX, "continueInstallWithout core success");
                            } else {
                                if (j.fL(context).Vp("incrupdate_status") != 1) {
                                }
                                r.gr(context).aM(j.fL(context).Vp("incrupdate_status") != 1 ? 221 : m.CTRL_INDEX, "success");
                            }
                        } else {
                            k.fM(context).CZ(-515);
                            wVg.unlock();
                            wVh.unlock();
                            ceC();
                            return;
                        }
                    } else if (i2 == 2) {
                        QbSdk.wTz.iv(m.CTRL_INDEX);
                    }
                } catch (Throwable th6) {
                    wVg.unlock();
                    wVh.unlock();
                    ceC();
                }
                wVg.unlock();
                wVh.unlock();
                ceC();
                return;
            }
            k.fM(context).CZ(-519);
            ceC();
        } else {
            k.fM(context).CZ(-505);
        }
    }

    final void u(Context context, boolean z) {
        boolean z2 = false;
        if (z) {
            this.wVi = true;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessId=" + Process.myPid());
        StringBuilder stringBuilder = new StringBuilder("TbsInstaller-continueInstallTbsCore currentThreadName=");
        int name = Thread.currentThread().getName();
        String stringBuilder2 = stringBuilder.append(name).toString();
        TbsLog.i("TbsInstaller", stringBuilder2);
        if (gq(context)) {
            int Vp;
            int Vq;
            int tryLock = wVg.tryLock();
            if (tryLock != 0) {
                try {
                    Vp = j.fL(context).Vp("install_status");
                    name = j.fL(context).Vq("install_core_ver");
                    stringBuilder2 = j.fL(context).Vr("install_apk_path");
                    Vq = j.fL(context).Vq("copy_core_ver");
                    tryLock = j.fL(context).Vp("copy_status");
                } finally {
                    z2 = wVg;
                    z2.unlock();
                }
            } else {
                tryLock = -1;
                stringBuilder2 = null;
                name = 0;
                Vp = -1;
                Vq = 0;
            }
            ceC();
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore installStatus=" + Vp);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreInstallVer=" + name);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsApkPath=" + stringBuilder2);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreCopyVer=" + Vq);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore copyStatus=" + tryLock);
            if (t.gu(context)) {
                Vq = t.ceQ();
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreForThirdPartyApp");
                if (Vq > 0) {
                    int gc = gc(context);
                    if (gc == Vq) {
                        return;
                    }
                    if (t.ceK() != null) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp hostContext != null");
                        a(context, null);
                        return;
                    } else if (gc <= 0) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--installTbsCoreForThirdPartyApp hostContext == null");
                        QbSdk.bv(context, "TbsInstaller::installTbsCoreForThirdPartyApp forceSysWebViewInner #2");
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            int i = k.fM(context).wUG.getInt("tbs_responsecode", z2);
            boolean z3 = (i == 1 || i == 2 || i == 4) ? true : z2;
            if (!(z3 || i == 0)) {
                new Bundle().putInt("operation", CdnLogic.MediaType_FAVORITE_FILE);
                if (context != null) {
                    Object obj = new Object[]{context, r4};
                    Message message = new Message();
                    message.what = 3;
                    message.obj = obj;
                    wVk.sendMessage(message);
                }
            }
            if (Vp >= 0 && Vp < 2) {
                o(context, stringBuilder2, name);
            }
            if (tryLock == 0) {
                aj(context, Vq);
            }
        }
    }

    final void v(Context context, boolean z) {
        if (!QbSdk.wTg) {
            if (VERSION.SDK_INT < 8) {
                TbsLog.e("TbsInstaller", "android version < 2.1 no need install X5 core", true);
                return;
            }
            try {
                if (!t.gu(context)) {
                    File go = go(context);
                    if (go != null && go.exists()) {
                        f.c(go, false);
                        new File(gm(context), "x5.tbs").delete();
                    }
                }
            } catch (Throwable th) {
            }
            if (!fU(context)) {
                return;
            }
            if (bx(context, "core_unzip_tmp") && t(context, z)) {
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromUnzip!!", true);
                return;
            }
            if (bx(context, "core_share_backup_tmp")) {
                ceB();
            }
            if (bx(context, "core_copy_tmp") && s(context, z)) {
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromCopy!!", true);
            } else {
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, error !!", true);
            }
        }
    }
}
