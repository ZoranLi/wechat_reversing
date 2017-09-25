package com.tencent.mm.plugin.hardwareopt.c;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.compatible.d.m;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.c.aew;
import com.tencent.mm.protocal.c.aln;
import com.tencent.mm.protocal.c.als;
import com.tencent.mm.protocal.c.awi;
import com.tencent.mm.protocal.c.bdr;
import com.tencent.mm.protocal.c.el;
import com.tencent.mm.protocal.c.ij;
import com.tencent.mm.protocal.c.lw;
import com.tencent.mm.protocal.c.sg;
import com.tencent.mm.protocal.c.sv;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a implements com.tencent.mm.vending.c.a<aew, Context> {
    private Context mContext = null;

    static class a extends Exception {
        a() {
            super("hy: positively stop in " + g.sb());
        }
    }

    private static java.lang.String ym(java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r1 = 0;
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0019, all -> 0x002f }
        r2 = 18;	 Catch:{ Exception -> 0x0019, all -> 0x002f }
        if (r0 < r2) goto L_0x0015;	 Catch:{ Exception -> 0x0019, all -> 0x002f }
    L_0x0007:
        r1 = android.media.MediaCodec.createEncoderByType(r5);	 Catch:{ Exception -> 0x0019, all -> 0x002f }
        r0 = r1.getName();	 Catch:{ Exception -> 0x0019, all -> 0x002f }
        if (r1 == 0) goto L_0x0014;
    L_0x0011:
        r1.release();
    L_0x0014:
        return r0;
    L_0x0015:
        r0 = "too low version";
        goto L_0x0014;
    L_0x0019:
        r0 = move-exception;
        r2 = "MicroMsg.TaskFindHardwareInfo";	 Catch:{ Exception -> 0x0019, all -> 0x002f }
        r3 = "hy: error in handle media codec";	 Catch:{ Exception -> 0x0019, all -> 0x002f }
        r4 = 0;	 Catch:{ Exception -> 0x0019, all -> 0x002f }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0019, all -> 0x002f }
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r2, r0, r3, r4);	 Catch:{ Exception -> 0x0019, all -> 0x002f }
        r0 = "undefined";	 Catch:{ Exception -> 0x0019, all -> 0x002f }
        if (r1 == 0) goto L_0x0014;
    L_0x002b:
        r1.release();
        goto L_0x0014;
    L_0x002f:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0035;
    L_0x0032:
        r1.release();
    L_0x0035:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.hardwareopt.c.a.ym(java.lang.String):java.lang.String");
    }

    public final /* synthetic */ Object call(Object obj) {
        return cp((Context) obj);
    }

    private aew cp(Context context) {
        RandomAccessFile randomAccessFile;
        Throwable e;
        sg sgVar;
        this.mContext = context;
        long nanoTime = System.nanoTime();
        try {
            el elVar = new el();
            elVar.imei = bg.em(this.mContext);
            if (bg.mA(elVar.imei)) {
                w.w("MicroMsg.TaskFindHardwareInfo", "hy: not got imei. maybe no permission");
                throw new a();
            }
            ActivityManager activityManager;
            MemoryInfo memoryInfo;
            aln com_tencent_mm_protocal_c_aln;
            StatFs statFs;
            bdr com_tencent_mm_protocal_c_bdr;
            ConfigurationInfo deviceConfigurationInfo;
            sv svVar;
            boolean z;
            Display defaultDisplay;
            Point point;
            int i;
            int i2;
            awi com_tencent_mm_protocal_c_awi;
            lw lwVar;
            String str;
            String str2;
            Object[] objArr;
            elVar.tix = Build.MANUFACTURER;
            elVar.tiy = Build.MODEL;
            elVar.tiz = VERSION.INCREMENTAL;
            com.tencent.mm.plugin.hardwareopt.b.a.aCX().aCY().tJY = elVar;
            w.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: imei: %s, manufacrtureName: %s, modelName: %s, incremental: %s", new Object[]{elVar.imei, elVar.tix, elVar.tiy, elVar.tiz});
            ij ijVar = new ij();
            ijVar.tnn = Build.CPU_ABI;
            Map rp = m.rp();
            ijVar.tnl = bg.ap((String) rp.get("Processor"), "");
            ijVar.tiy = (String) rp.get("model name");
            ijVar.tno = (String) rp.get("Hardware");
            try {
                randomAccessFile = new RandomAccessFile("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq", "r");
                try {
                    ijVar.tnm = bg.getInt(randomAccessFile.readLine(), -1) / 1000;
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e2) {
                        w.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e2, "hy: error when close read cpu files", new Object[0]);
                    }
                } catch (IOException e3) {
                    e2 = e3;
                    try {
                        w.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e2, "hy: error when reading cpu frequency", new Object[0]);
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Throwable e22) {
                                w.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e22, "hy: error when close read cpu files", new Object[0]);
                            }
                        }
                        com.tencent.mm.plugin.hardwareopt.b.a.aCX().aCY().tJZ = ijVar;
                        w.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: abi: %s, cpuModel: %s, cpuClockSpeedInHz: %d, modelName: %s, platform: %s", new Object[]{ijVar.tnn, ijVar.tnl, Integer.valueOf(ijVar.tnm), ijVar.tiy, ijVar.tno});
                        activityManager = (ActivityManager) this.mContext.getSystemService("activity");
                        memoryInfo = new MemoryInfo();
                        activityManager.getMemoryInfo(memoryInfo);
                        com_tencent_mm_protocal_c_aln = new aln();
                        com_tencent_mm_protocal_c_aln.tQo = (int) ((memoryInfo.totalMem / AppSupportContentFlag.MMAPP_SUPPORT_XLS) / AppSupportContentFlag.MMAPP_SUPPORT_XLS);
                        com_tencent_mm_protocal_c_aln.tQp = (int) ((memoryInfo.threshold / AppSupportContentFlag.MMAPP_SUPPORT_XLS) / AppSupportContentFlag.MMAPP_SUPPORT_XLS);
                        com_tencent_mm_protocal_c_aln.tQq = ((ActivityManager) this.mContext.getSystemService("activity")).getLargeMemoryClass();
                        com_tencent_mm_protocal_c_aln.tQr = ((ActivityManager) this.mContext.getSystemService("activity")).getMemoryClass();
                        com.tencent.mm.plugin.hardwareopt.b.a.aCX().aCY().tKa = com_tencent_mm_protocal_c_aln;
                        w.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalMemInMB: %d, thresholdInMB: %d, large memory class; %d, memory class: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aln.tQo), Integer.valueOf(com_tencent_mm_protocal_c_aln.tQp), Integer.valueOf(com_tencent_mm_protocal_c_aln.tQq), Integer.valueOf(com_tencent_mm_protocal_c_aln.tQr)});
                        statFs = new StatFs(e.hgs);
                        com_tencent_mm_protocal_c_bdr = new bdr();
                        if (VERSION.SDK_INT >= 18) {
                            com_tencent_mm_protocal_c_bdr.ueW = (int) (((((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / AppSupportContentFlag.MMAPP_SUPPORT_XLS) / AppSupportContentFlag.MMAPP_SUPPORT_XLS);
                        } else {
                            com_tencent_mm_protocal_c_bdr.ueW = (int) ((statFs.getTotalBytes() / AppSupportContentFlag.MMAPP_SUPPORT_XLS) / AppSupportContentFlag.MMAPP_SUPPORT_XLS);
                        }
                        com_tencent_mm_protocal_c_bdr.ueX = Environment.getExternalStorageState().equals("mounted");
                        com.tencent.mm.plugin.hardwareopt.b.a.aCX().aCY().tKb = com_tencent_mm_protocal_c_bdr;
                        w.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalStorageInMB: %d, hasExternalStorage: %b", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bdr.ueW), Boolean.valueOf(com_tencent_mm_protocal_c_bdr.ueX)});
                        deviceConfigurationInfo = ((ActivityManager) this.mContext.getSystemService("activity")).getDeviceConfigurationInfo();
                        svVar = new sv();
                        if (deviceConfigurationInfo.reqGlEsVersion >= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                            z = false;
                        } else {
                            z = true;
                        }
                        svVar.tAI = z;
                        svVar.tAJ = deviceConfigurationInfo.reqGlEsVersion < 196608;
                        com.tencent.mm.plugin.hardwareopt.b.a.aCX().aCY().tKf = svVar;
                        w.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: hasOpenGL20: %b, hasOpenGL30: %b, esversion: %s", new Object[]{Boolean.valueOf(svVar.tAI), Boolean.valueOf(svVar.tAJ), Integer.valueOf(deviceConfigurationInfo.reqGlEsVersion)});
                        defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
                        point = new Point();
                        defaultDisplay.getSize(point);
                        i = point.x;
                        i2 = point.y;
                        com_tencent_mm_protocal_c_awi = new awi();
                        com_tencent_mm_protocal_c_awi.tZB = String.valueOf(i) + "x" + i2;
                        com_tencent_mm_protocal_c_awi.density = (int) this.mContext.getResources().getDisplayMetrics().density;
                        com.tencent.mm.plugin.hardwareopt.b.a.aCX().aCY().tKc = com_tencent_mm_protocal_c_awi;
                        w.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: resolution: %s, ppi: %d", new Object[]{com_tencent_mm_protocal_c_awi.tZB, Integer.valueOf(com_tencent_mm_protocal_c_awi.density)});
                        lwVar = new lw();
                        lwVar.tsc = ym("video/avc");
                        lwVar.tsd = ym("video/hevc");
                        lwVar.tse = aCZ();
                        com.tencent.mm.plugin.hardwareopt.b.a.aCX().aCY().tKd = lwVar;
                        str = "MicroMsg.TaskFindHardwareInfo";
                        str2 = "hy: hardwareinfo: default codec name avc: %s, default hevc names: %s, codec number: %d";
                        objArr = new Object[3];
                        objArr[0] = lwVar.tsc;
                        objArr[1] = lwVar.tsd;
                        if (lwVar.tse != null) {
                            i = 0;
                        } else {
                            i = lwVar.tse.size();
                        }
                        objArr[2] = Integer.valueOf(i);
                        w.d(str, str2, objArr);
                        sgVar = new sg();
                        sgVar.tzS = this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth");
                        if (VERSION.SDK_INT >= 18) {
                            sgVar.tzT = false;
                        } else {
                            sgVar.tzT = this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
                        }
                        sgVar.tzU = this.mContext.getPackageManager().hasSystemFeature("android.hardware.location.gps");
                        sgVar.tzV = this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
                        sgVar.tzW = this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.front");
                        sgVar.tzX = this.mContext.getPackageManager().hasSystemFeature("android.hardware.microphone");
                        sgVar.tzY = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc");
                        if (VERSION.SDK_INT >= 19) {
                            sgVar.tAj = false;
                        } else {
                            sgVar.tAj = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc.hce");
                        }
                        sgVar.tzZ = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc");
                        if (VERSION.SDK_INT < 23) {
                            sgVar.tAa = this.mContext.getPackageManager().hasSystemFeature("android.hardware.fingerprint");
                        } else if (p.gRg.gRo == 1) {
                            sgVar.tAa = false;
                        } else {
                            sgVar.tAa = true;
                        }
                        sgVar.tAb = this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.cdma");
                        sgVar.tAc = this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.gsm");
                        sgVar.tAd = this.mContext.getPackageManager().hasSystemFeature("android.software.sip");
                        sgVar.tAe = this.mContext.getPackageManager().hasSystemFeature("android.software.sip.voip");
                        if (VERSION.SDK_INT >= 19) {
                            sgVar.tAf = false;
                        } else {
                            sgVar.tAf = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.stepdetector");
                        }
                        if (VERSION.SDK_INT >= 19) {
                            sgVar.tAg = false;
                        } else {
                            sgVar.tAg = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter");
                        }
                        sgVar.tAh = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.accelerometer");
                        sgVar.tAi = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.light");
                        com.tencent.mm.plugin.hardwareopt.b.a.aCX().aCY().tKe = sgVar;
                        w.d("MicroMsg.TaskFindHardwareInfo", "hy: hy: hardwareinfo: hasBluetooth: %b, hasBluetoothLE: %b, hasGPS: %b, hasCameraFlash: %b, hasCameraFront: %b, hasMic: %b, hasNFC: %b, hasNfcHce: %b, hasHifiSensor: %b, hasFingerprintSensor: %b, hasCDMA: %b, hasGSM: %b, hasSIP: %b, hasSIPBasedVoIP: %b, hasStepDitector: %b , hasStepCounter: %b, hasAcceloratorSensor: %b, hasLightSensor: %b", new Object[]{Boolean.valueOf(sgVar.tzS), Boolean.valueOf(sgVar.tzT), Boolean.valueOf(sgVar.tzU), Boolean.valueOf(sgVar.tzV), Boolean.valueOf(sgVar.tzW), Boolean.valueOf(sgVar.tzX), Boolean.valueOf(sgVar.tzY), Boolean.valueOf(sgVar.tAj), Boolean.valueOf(sgVar.tzZ), Boolean.valueOf(sgVar.tAa), Boolean.valueOf(sgVar.tAb), Boolean.valueOf(sgVar.tAc), Boolean.valueOf(sgVar.tAd), Boolean.valueOf(sgVar.tAe), Boolean.valueOf(sgVar.tAf), Boolean.valueOf(sgVar.tAg), Boolean.valueOf(sgVar.tAh), Boolean.valueOf(sgVar.tAi)});
                        w.i("MicroMsg.TaskFindHardwareInfo", "hy: calc hardware using: %d ms", new Object[]{Long.valueOf(((System.nanoTime() - nanoTime) / 1000) / 1000)});
                        return com.tencent.mm.plugin.hardwareopt.b.a.aCX().aCY();
                    } catch (Throwable th) {
                        e22 = th;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Throwable e4) {
                                w.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e4, "hy: error when close read cpu files", new Object[0]);
                            }
                        }
                        throw e22;
                    }
                }
            } catch (IOException e5) {
                e22 = e5;
                randomAccessFile = null;
                w.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e22, "hy: error when reading cpu frequency", new Object[0]);
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                com.tencent.mm.plugin.hardwareopt.b.a.aCX().aCY().tJZ = ijVar;
                w.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: abi: %s, cpuModel: %s, cpuClockSpeedInHz: %d, modelName: %s, platform: %s", new Object[]{ijVar.tnn, ijVar.tnl, Integer.valueOf(ijVar.tnm), ijVar.tiy, ijVar.tno});
                activityManager = (ActivityManager) this.mContext.getSystemService("activity");
                memoryInfo = new MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                com_tencent_mm_protocal_c_aln = new aln();
                com_tencent_mm_protocal_c_aln.tQo = (int) ((memoryInfo.totalMem / AppSupportContentFlag.MMAPP_SUPPORT_XLS) / AppSupportContentFlag.MMAPP_SUPPORT_XLS);
                com_tencent_mm_protocal_c_aln.tQp = (int) ((memoryInfo.threshold / AppSupportContentFlag.MMAPP_SUPPORT_XLS) / AppSupportContentFlag.MMAPP_SUPPORT_XLS);
                com_tencent_mm_protocal_c_aln.tQq = ((ActivityManager) this.mContext.getSystemService("activity")).getLargeMemoryClass();
                com_tencent_mm_protocal_c_aln.tQr = ((ActivityManager) this.mContext.getSystemService("activity")).getMemoryClass();
                com.tencent.mm.plugin.hardwareopt.b.a.aCX().aCY().tKa = com_tencent_mm_protocal_c_aln;
                w.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalMemInMB: %d, thresholdInMB: %d, large memory class; %d, memory class: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aln.tQo), Integer.valueOf(com_tencent_mm_protocal_c_aln.tQp), Integer.valueOf(com_tencent_mm_protocal_c_aln.tQq), Integer.valueOf(com_tencent_mm_protocal_c_aln.tQr)});
                statFs = new StatFs(e.hgs);
                com_tencent_mm_protocal_c_bdr = new bdr();
                if (VERSION.SDK_INT >= 18) {
                    com_tencent_mm_protocal_c_bdr.ueW = (int) ((statFs.getTotalBytes() / AppSupportContentFlag.MMAPP_SUPPORT_XLS) / AppSupportContentFlag.MMAPP_SUPPORT_XLS);
                } else {
                    com_tencent_mm_protocal_c_bdr.ueW = (int) (((((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / AppSupportContentFlag.MMAPP_SUPPORT_XLS) / AppSupportContentFlag.MMAPP_SUPPORT_XLS);
                }
                com_tencent_mm_protocal_c_bdr.ueX = Environment.getExternalStorageState().equals("mounted");
                com.tencent.mm.plugin.hardwareopt.b.a.aCX().aCY().tKb = com_tencent_mm_protocal_c_bdr;
                w.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalStorageInMB: %d, hasExternalStorage: %b", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bdr.ueW), Boolean.valueOf(com_tencent_mm_protocal_c_bdr.ueX)});
                deviceConfigurationInfo = ((ActivityManager) this.mContext.getSystemService("activity")).getDeviceConfigurationInfo();
                svVar = new sv();
                if (deviceConfigurationInfo.reqGlEsVersion >= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                    z = true;
                } else {
                    z = false;
                }
                svVar.tAI = z;
                if (deviceConfigurationInfo.reqGlEsVersion < 196608) {
                }
                svVar.tAJ = deviceConfigurationInfo.reqGlEsVersion < 196608;
                com.tencent.mm.plugin.hardwareopt.b.a.aCX().aCY().tKf = svVar;
                w.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: hasOpenGL20: %b, hasOpenGL30: %b, esversion: %s", new Object[]{Boolean.valueOf(svVar.tAI), Boolean.valueOf(svVar.tAJ), Integer.valueOf(deviceConfigurationInfo.reqGlEsVersion)});
                defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
                point = new Point();
                defaultDisplay.getSize(point);
                i = point.x;
                i2 = point.y;
                com_tencent_mm_protocal_c_awi = new awi();
                com_tencent_mm_protocal_c_awi.tZB = String.valueOf(i) + "x" + i2;
                com_tencent_mm_protocal_c_awi.density = (int) this.mContext.getResources().getDisplayMetrics().density;
                com.tencent.mm.plugin.hardwareopt.b.a.aCX().aCY().tKc = com_tencent_mm_protocal_c_awi;
                w.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: resolution: %s, ppi: %d", new Object[]{com_tencent_mm_protocal_c_awi.tZB, Integer.valueOf(com_tencent_mm_protocal_c_awi.density)});
                lwVar = new lw();
                lwVar.tsc = ym("video/avc");
                lwVar.tsd = ym("video/hevc");
                lwVar.tse = aCZ();
                com.tencent.mm.plugin.hardwareopt.b.a.aCX().aCY().tKd = lwVar;
                str = "MicroMsg.TaskFindHardwareInfo";
                str2 = "hy: hardwareinfo: default codec name avc: %s, default hevc names: %s, codec number: %d";
                objArr = new Object[3];
                objArr[0] = lwVar.tsc;
                objArr[1] = lwVar.tsd;
                if (lwVar.tse != null) {
                    i = lwVar.tse.size();
                } else {
                    i = 0;
                }
                objArr[2] = Integer.valueOf(i);
                w.d(str, str2, objArr);
                sgVar = new sg();
                sgVar.tzS = this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth");
                if (VERSION.SDK_INT >= 18) {
                    sgVar.tzT = this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
                } else {
                    sgVar.tzT = false;
                }
                sgVar.tzU = this.mContext.getPackageManager().hasSystemFeature("android.hardware.location.gps");
                sgVar.tzV = this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
                sgVar.tzW = this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.front");
                sgVar.tzX = this.mContext.getPackageManager().hasSystemFeature("android.hardware.microphone");
                sgVar.tzY = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc");
                if (VERSION.SDK_INT >= 19) {
                    sgVar.tAj = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc.hce");
                } else {
                    sgVar.tAj = false;
                }
                sgVar.tzZ = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc");
                if (VERSION.SDK_INT < 23) {
                    sgVar.tAa = this.mContext.getPackageManager().hasSystemFeature("android.hardware.fingerprint");
                } else if (p.gRg.gRo == 1) {
                    sgVar.tAa = true;
                } else {
                    sgVar.tAa = false;
                }
                sgVar.tAb = this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.cdma");
                sgVar.tAc = this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.gsm");
                sgVar.tAd = this.mContext.getPackageManager().hasSystemFeature("android.software.sip");
                sgVar.tAe = this.mContext.getPackageManager().hasSystemFeature("android.software.sip.voip");
                if (VERSION.SDK_INT >= 19) {
                    sgVar.tAf = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.stepdetector");
                } else {
                    sgVar.tAf = false;
                }
                if (VERSION.SDK_INT >= 19) {
                    sgVar.tAg = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter");
                } else {
                    sgVar.tAg = false;
                }
                sgVar.tAh = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.accelerometer");
                sgVar.tAi = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.light");
                com.tencent.mm.plugin.hardwareopt.b.a.aCX().aCY().tKe = sgVar;
                w.d("MicroMsg.TaskFindHardwareInfo", "hy: hy: hardwareinfo: hasBluetooth: %b, hasBluetoothLE: %b, hasGPS: %b, hasCameraFlash: %b, hasCameraFront: %b, hasMic: %b, hasNFC: %b, hasNfcHce: %b, hasHifiSensor: %b, hasFingerprintSensor: %b, hasCDMA: %b, hasGSM: %b, hasSIP: %b, hasSIPBasedVoIP: %b, hasStepDitector: %b , hasStepCounter: %b, hasAcceloratorSensor: %b, hasLightSensor: %b", new Object[]{Boolean.valueOf(sgVar.tzS), Boolean.valueOf(sgVar.tzT), Boolean.valueOf(sgVar.tzU), Boolean.valueOf(sgVar.tzV), Boolean.valueOf(sgVar.tzW), Boolean.valueOf(sgVar.tzX), Boolean.valueOf(sgVar.tzY), Boolean.valueOf(sgVar.tAj), Boolean.valueOf(sgVar.tzZ), Boolean.valueOf(sgVar.tAa), Boolean.valueOf(sgVar.tAb), Boolean.valueOf(sgVar.tAc), Boolean.valueOf(sgVar.tAd), Boolean.valueOf(sgVar.tAe), Boolean.valueOf(sgVar.tAf), Boolean.valueOf(sgVar.tAg), Boolean.valueOf(sgVar.tAh), Boolean.valueOf(sgVar.tAi)});
                w.i("MicroMsg.TaskFindHardwareInfo", "hy: calc hardware using: %d ms", new Object[]{Long.valueOf(((System.nanoTime() - nanoTime) / 1000) / 1000)});
                return com.tencent.mm.plugin.hardwareopt.b.a.aCX().aCY();
            } catch (Throwable th2) {
                e22 = th2;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw e22;
            }
            com.tencent.mm.plugin.hardwareopt.b.a.aCX().aCY().tJZ = ijVar;
            w.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: abi: %s, cpuModel: %s, cpuClockSpeedInHz: %d, modelName: %s, platform: %s", new Object[]{ijVar.tnn, ijVar.tnl, Integer.valueOf(ijVar.tnm), ijVar.tiy, ijVar.tno});
            activityManager = (ActivityManager) this.mContext.getSystemService("activity");
            memoryInfo = new MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            com_tencent_mm_protocal_c_aln = new aln();
            com_tencent_mm_protocal_c_aln.tQo = (int) ((memoryInfo.totalMem / AppSupportContentFlag.MMAPP_SUPPORT_XLS) / AppSupportContentFlag.MMAPP_SUPPORT_XLS);
            com_tencent_mm_protocal_c_aln.tQp = (int) ((memoryInfo.threshold / AppSupportContentFlag.MMAPP_SUPPORT_XLS) / AppSupportContentFlag.MMAPP_SUPPORT_XLS);
            com_tencent_mm_protocal_c_aln.tQq = ((ActivityManager) this.mContext.getSystemService("activity")).getLargeMemoryClass();
            com_tencent_mm_protocal_c_aln.tQr = ((ActivityManager) this.mContext.getSystemService("activity")).getMemoryClass();
            com.tencent.mm.plugin.hardwareopt.b.a.aCX().aCY().tKa = com_tencent_mm_protocal_c_aln;
            w.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalMemInMB: %d, thresholdInMB: %d, large memory class; %d, memory class: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aln.tQo), Integer.valueOf(com_tencent_mm_protocal_c_aln.tQp), Integer.valueOf(com_tencent_mm_protocal_c_aln.tQq), Integer.valueOf(com_tencent_mm_protocal_c_aln.tQr)});
            statFs = new StatFs(e.hgs);
            com_tencent_mm_protocal_c_bdr = new bdr();
            if (VERSION.SDK_INT >= 18) {
                com_tencent_mm_protocal_c_bdr.ueW = (int) ((statFs.getTotalBytes() / AppSupportContentFlag.MMAPP_SUPPORT_XLS) / AppSupportContentFlag.MMAPP_SUPPORT_XLS);
            } else {
                com_tencent_mm_protocal_c_bdr.ueW = (int) (((((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / AppSupportContentFlag.MMAPP_SUPPORT_XLS) / AppSupportContentFlag.MMAPP_SUPPORT_XLS);
            }
            com_tencent_mm_protocal_c_bdr.ueX = Environment.getExternalStorageState().equals("mounted");
            com.tencent.mm.plugin.hardwareopt.b.a.aCX().aCY().tKb = com_tencent_mm_protocal_c_bdr;
            w.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalStorageInMB: %d, hasExternalStorage: %b", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bdr.ueW), Boolean.valueOf(com_tencent_mm_protocal_c_bdr.ueX)});
            deviceConfigurationInfo = ((ActivityManager) this.mContext.getSystemService("activity")).getDeviceConfigurationInfo();
            svVar = new sv();
            if (deviceConfigurationInfo.reqGlEsVersion >= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                z = true;
            } else {
                z = false;
            }
            svVar.tAI = z;
            if (deviceConfigurationInfo.reqGlEsVersion < 196608) {
            }
            svVar.tAJ = deviceConfigurationInfo.reqGlEsVersion < 196608;
            com.tencent.mm.plugin.hardwareopt.b.a.aCX().aCY().tKf = svVar;
            w.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: hasOpenGL20: %b, hasOpenGL30: %b, esversion: %s", new Object[]{Boolean.valueOf(svVar.tAI), Boolean.valueOf(svVar.tAJ), Integer.valueOf(deviceConfigurationInfo.reqGlEsVersion)});
            defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
            point = new Point();
            defaultDisplay.getSize(point);
            i = point.x;
            i2 = point.y;
            com_tencent_mm_protocal_c_awi = new awi();
            com_tencent_mm_protocal_c_awi.tZB = String.valueOf(i) + "x" + i2;
            com_tencent_mm_protocal_c_awi.density = (int) this.mContext.getResources().getDisplayMetrics().density;
            com.tencent.mm.plugin.hardwareopt.b.a.aCX().aCY().tKc = com_tencent_mm_protocal_c_awi;
            w.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: resolution: %s, ppi: %d", new Object[]{com_tencent_mm_protocal_c_awi.tZB, Integer.valueOf(com_tencent_mm_protocal_c_awi.density)});
            lwVar = new lw();
            lwVar.tsc = ym("video/avc");
            lwVar.tsd = ym("video/hevc");
            lwVar.tse = aCZ();
            com.tencent.mm.plugin.hardwareopt.b.a.aCX().aCY().tKd = lwVar;
            str = "MicroMsg.TaskFindHardwareInfo";
            str2 = "hy: hardwareinfo: default codec name avc: %s, default hevc names: %s, codec number: %d";
            objArr = new Object[3];
            objArr[0] = lwVar.tsc;
            objArr[1] = lwVar.tsd;
            if (lwVar.tse != null) {
                i = lwVar.tse.size();
            } else {
                i = 0;
            }
            objArr[2] = Integer.valueOf(i);
            w.d(str, str2, objArr);
            sgVar = new sg();
            sgVar.tzS = this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth");
            if (VERSION.SDK_INT >= 18) {
                sgVar.tzT = this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
            } else {
                sgVar.tzT = false;
            }
            sgVar.tzU = this.mContext.getPackageManager().hasSystemFeature("android.hardware.location.gps");
            sgVar.tzV = this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
            sgVar.tzW = this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.front");
            sgVar.tzX = this.mContext.getPackageManager().hasSystemFeature("android.hardware.microphone");
            sgVar.tzY = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc");
            if (VERSION.SDK_INT >= 19) {
                sgVar.tAj = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc.hce");
            } else {
                sgVar.tAj = false;
            }
            sgVar.tzZ = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc");
            if (VERSION.SDK_INT < 23) {
                sgVar.tAa = this.mContext.getPackageManager().hasSystemFeature("android.hardware.fingerprint");
            } else if (p.gRg.gRo == 1) {
                sgVar.tAa = true;
            } else {
                sgVar.tAa = false;
            }
            sgVar.tAb = this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.cdma");
            sgVar.tAc = this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.gsm");
            sgVar.tAd = this.mContext.getPackageManager().hasSystemFeature("android.software.sip");
            sgVar.tAe = this.mContext.getPackageManager().hasSystemFeature("android.software.sip.voip");
            if (VERSION.SDK_INT >= 19) {
                sgVar.tAf = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.stepdetector");
            } else {
                sgVar.tAf = false;
            }
            if (VERSION.SDK_INT >= 19) {
                sgVar.tAg = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter");
            } else {
                sgVar.tAg = false;
            }
            sgVar.tAh = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.accelerometer");
            sgVar.tAi = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.light");
            com.tencent.mm.plugin.hardwareopt.b.a.aCX().aCY().tKe = sgVar;
            w.d("MicroMsg.TaskFindHardwareInfo", "hy: hy: hardwareinfo: hasBluetooth: %b, hasBluetoothLE: %b, hasGPS: %b, hasCameraFlash: %b, hasCameraFront: %b, hasMic: %b, hasNFC: %b, hasNfcHce: %b, hasHifiSensor: %b, hasFingerprintSensor: %b, hasCDMA: %b, hasGSM: %b, hasSIP: %b, hasSIPBasedVoIP: %b, hasStepDitector: %b , hasStepCounter: %b, hasAcceloratorSensor: %b, hasLightSensor: %b", new Object[]{Boolean.valueOf(sgVar.tzS), Boolean.valueOf(sgVar.tzT), Boolean.valueOf(sgVar.tzU), Boolean.valueOf(sgVar.tzV), Boolean.valueOf(sgVar.tzW), Boolean.valueOf(sgVar.tzX), Boolean.valueOf(sgVar.tzY), Boolean.valueOf(sgVar.tAj), Boolean.valueOf(sgVar.tzZ), Boolean.valueOf(sgVar.tAa), Boolean.valueOf(sgVar.tAb), Boolean.valueOf(sgVar.tAc), Boolean.valueOf(sgVar.tAd), Boolean.valueOf(sgVar.tAe), Boolean.valueOf(sgVar.tAf), Boolean.valueOf(sgVar.tAg), Boolean.valueOf(sgVar.tAh), Boolean.valueOf(sgVar.tAi)});
            w.i("MicroMsg.TaskFindHardwareInfo", "hy: calc hardware using: %d ms", new Object[]{Long.valueOf(((System.nanoTime() - nanoTime) / 1000) / 1000)});
            return com.tencent.mm.plugin.hardwareopt.b.a.aCX().aCY();
        } catch (Throwable e222) {
            w.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e222, "hy: exception when find hardware info", new Object[0]);
            com.tencent.mm.vending.g.g.cbK().bJ(null);
            return null;
        }
    }

    private static LinkedList<als> aCZ() {
        int codecCount = MediaCodecList.getCodecCount();
        LinkedList<als> linkedList = new LinkedList();
        Map hashMap = new HashMap();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                for (String str : codecInfoAt.getSupportedTypes()) {
                    Set set = (Set) hashMap.get(str.toLowerCase());
                    if (set == null) {
                        set = new HashSet();
                    }
                    set.add(codecInfoAt.getName());
                    hashMap.put(str.toLowerCase(), set);
                }
            }
        }
        w.i("MicroMsg.TaskFindHardwareInfo", "hy: allCodecNames: %s", new Object[]{hashMap});
        for (Entry entry : hashMap.entrySet()) {
            als com_tencent_mm_protocal_c_als = new als();
            com_tencent_mm_protocal_c_als.nzA = (String) entry.getKey();
            LinkedList linkedList2 = new LinkedList();
            if (entry.getValue() != null) {
                linkedList2.addAll((Collection) entry.getValue());
            }
            com_tencent_mm_protocal_c_als.tQy = linkedList2;
            linkedList.add(com_tencent_mm_protocal_c_als);
        }
        return linkedList;
    }
}
