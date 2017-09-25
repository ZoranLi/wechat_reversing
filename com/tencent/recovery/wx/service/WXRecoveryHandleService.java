package com.tencent.recovery.wx.service;

import android.content.Context;
import android.os.PowerManager;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryData;
import com.tencent.recovery.model.RecoveryHandleItem;
import com.tencent.recovery.model.RecoveryHandleResult;
import com.tencent.recovery.service.RecoveryHandleService;
import com.tencent.recovery.util.Util;
import com.tencent.recovery.wx.RecoveryTinkerManager;
import com.tencent.recovery.wx.util.NetUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import org.json.JSONObject;

public class WXRecoveryHandleService extends RecoveryHandleService {
    private PowerManager rTI;

    public void onCreate() {
        super.onCreate();
        RecoveryLog.i("Recovery.WXRecoveryHandleService", "onCreate", new Object[0]);
        this.rTI = (PowerManager) getSystemService("power");
    }

    public void onDestroy() {
        RecoveryLog.i("Recovery.WXRecoveryHandleService", "onDestroy", new Object[0]);
        super.onDestroy();
    }

    protected final void a(RecoveryData recoveryData, ArrayList<RecoveryHandleItem> arrayList, boolean z) {
        arrayList.add(a(recoveryData, String.format("%s[%b]", new Object[]{"KeyTotalCount", Boolean.valueOf(z)})));
        arrayList.add(a(recoveryData, String.format("%s[%b]", new Object[]{"KeyAlreadyRunning", Boolean.valueOf(z)})));
    }

    protected final RecoveryHandleResult a(Context context, RecoveryData recoveryData, ArrayList<RecoveryHandleItem> arrayList, boolean z) {
        int bs;
        Throwable th;
        RecoveryHandleResult recoveryHandleResult = new RecoveryHandleResult();
        arrayList.add(a(recoveryData, String.format("%s[%b]", new Object[]{"KeyTotalCount", Boolean.valueOf(z)})));
        RecoveryHandleItem a = a(recoveryData, "");
        if (NetUtil.isConnected(this)) {
            RecoveryLog.i("Recovery.WXRecoveryHandleService", "recoveryConfigUrl %s", recoveryData.wQq);
            String a2 = a(r0, a);
            if (a2 != null) {
                JSONObject jSONObject;
                RecoveryLog.i("Recovery.WXRecoveryHandleService", "recoveryConfigStr is %s", a2);
                try {
                    jSONObject = new JSONObject(a2);
                } catch (Exception e) {
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    int optInt = jSONObject.optInt("abTestBaseNumber", -1);
                    int optInt2 = jSONObject.optInt("abTestReminder", -1);
                    String optString = jSONObject.optString("patchPackageUrl", "");
                    String optString2 = jSONObject.optString("patchPackageMd5", "");
                    if ((Util.fs(this) % optInt == optInt2 ? 1 : null) != null) {
                        RecoveryLog.i("Recovery.WXRecoveryHandleService", "patchPackageUrl=%s", optString);
                        byte[] a3 = a(optString, optString2, a);
                        if (a3 != null) {
                            optString = context.getCacheDir() + "/recovery.patch";
                            File file = new File(optString);
                            if (file.exists()) {
                                file.delete();
                            }
                            FileOutputStream fileOutputStream = null;
                            FileOutputStream fileOutputStream2;
                            try {
                                fileOutputStream2 = new FileOutputStream(file);
                                try {
                                    fileOutputStream2.write(a3);
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException e2) {
                                    }
                                } catch (Exception e3) {
                                    if (fileOutputStream2 != null) {
                                        try {
                                            fileOutputStream2.close();
                                        } catch (IOException e4) {
                                        }
                                    }
                                    if (file.exists()) {
                                        bs = RecoveryTinkerManager.bs(context, optString);
                                        if (bs != 0) {
                                            a.arH = "KeyPatchStartFailCount[" + bs + "]";
                                            RecoveryLog.i("Recovery.WXRecoveryHandleService", "patch fail tinkerPatchCode=%d", Integer.valueOf(bs));
                                        } else {
                                            a.arH = "KeyPatchStartSuccessCount";
                                            RecoveryLog.i("Recovery.WXRecoveryHandleService", "start patch file", new Object[0]);
                                        }
                                        recoveryHandleResult.fDU = true;
                                    } else {
                                        a.arH = "KeyCheckPatchMd5FailCount";
                                        RecoveryLog.i("Recovery.WXRecoveryHandleService", "patch file save fail", new Object[0]);
                                    }
                                    arrayList.add(a);
                                    return recoveryHandleResult;
                                } catch (Throwable th2) {
                                    Throwable th3 = th2;
                                    fileOutputStream = fileOutputStream2;
                                    th = th3;
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e5) {
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Exception e6) {
                                fileOutputStream2 = null;
                                if (fileOutputStream2 != null) {
                                    fileOutputStream2.close();
                                }
                                if (file.exists()) {
                                    a.arH = "KeyCheckPatchMd5FailCount";
                                    RecoveryLog.i("Recovery.WXRecoveryHandleService", "patch file save fail", new Object[0]);
                                } else {
                                    bs = RecoveryTinkerManager.bs(context, optString);
                                    if (bs != 0) {
                                        a.arH = "KeyPatchStartSuccessCount";
                                        RecoveryLog.i("Recovery.WXRecoveryHandleService", "start patch file", new Object[0]);
                                    } else {
                                        a.arH = "KeyPatchStartFailCount[" + bs + "]";
                                        RecoveryLog.i("Recovery.WXRecoveryHandleService", "patch fail tinkerPatchCode=%d", Integer.valueOf(bs));
                                    }
                                    recoveryHandleResult.fDU = true;
                                }
                                arrayList.add(a);
                                return recoveryHandleResult;
                            } catch (Throwable th4) {
                                th = th4;
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                throw th;
                            }
                            if (file.exists()) {
                                bs = RecoveryTinkerManager.bs(context, optString);
                                if (bs != 0) {
                                    a.arH = "KeyPatchStartFailCount[" + bs + "]";
                                    RecoveryLog.i("Recovery.WXRecoveryHandleService", "patch fail tinkerPatchCode=%d", Integer.valueOf(bs));
                                } else {
                                    a.arH = "KeyPatchStartSuccessCount";
                                    RecoveryLog.i("Recovery.WXRecoveryHandleService", "start patch file", new Object[0]);
                                }
                                recoveryHandleResult.fDU = true;
                            } else {
                                a.arH = "KeyCheckPatchMd5FailCount";
                                RecoveryLog.i("Recovery.WXRecoveryHandleService", "patch file save fail", new Object[0]);
                            }
                        } else {
                            RecoveryLog.i("Recovery.WXRecoveryHandleService", "get patch data fail", new Object[0]);
                        }
                    } else {
                        RecoveryLog.i("Recovery.WXRecoveryHandleService", "no need recovery", new Object[0]);
                        a.arH = "KeyPatchNoNeedCount";
                    }
                } else {
                    RecoveryLog.i("Recovery.WXRecoveryHandleService", "parse config fail", new Object[0]);
                    a.arH = "KeyConfigParseFailCount";
                }
            } else {
                RecoveryLog.i("Recovery.WXRecoveryHandleService", "recoveryConfigStr is null", new Object[0]);
                if (Util.mA(a.arH)) {
                    a.arH = "RecoveryConfigStrIsNull";
                }
            }
        } else {
            RecoveryLog.i("Recovery.WXRecoveryHandleService", "no network", new Object[0]);
            if (!z) {
                recoveryHandleResult.wQt = true;
            }
            a.arH = String.format("%s[%b]", new Object[]{"KeyNoNetWork", Boolean.valueOf(z)});
        }
        arrayList.add(a);
        return recoveryHandleResult;
    }

    private RecoveryHandleItem a(RecoveryData recoveryData, String str) {
        RecoveryHandleItem recoveryHandleItem = new RecoveryHandleItem();
        recoveryHandleItem.mry = recoveryData.mry;
        recoveryHandleItem.clientVersion = recoveryData.clientVersion;
        recoveryHandleItem.timestamp = System.currentTimeMillis();
        recoveryHandleItem.arH = str;
        recoveryHandleItem.processName = recoveryData.processName;
        String fv = NetUtil.fv(this);
        boolean isScreenOn = this.rTI.isScreenOn();
        boolean UZ = UZ("dldir1.qq.com");
        recoveryHandleItem.wQs = fv + "|" + isScreenOn + "|" + UZ + "|" + UZ("www.qq.com");
        return recoveryHandleItem;
    }

    private static java.lang.String a(java.lang.String r10, com.tencent.recovery.model.RecoveryHandleItem r11) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.recovery.wx.service.WXRecoveryHandleService.a(java.lang.String, com.tencent.recovery.model.RecoveryHandleItem):java.lang.String. bs: [B:47:0x00b8, B:52:0x00c5]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r8 = 0;
        r1 = 0;
        r0 = "file://";
        r0 = r10.startsWith(r0);
        if (r0 == 0) goto L_0x0074;
    L_0x000b:
        r0 = "file://";
        r2 = "";
        r0 = r10.replace(r0, r2);
        r2 = new java.io.File;
        r2.<init>(r0);
        r0 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x005f, all -> 0x006b }
        r0.<init>(r2);	 Catch:{ Exception -> 0x005f, all -> 0x006b }
        r4 = com.tencent.recovery.wx.util.FileUtil.c(r0);	 Catch:{ Exception -> 0x0196, all -> 0x0190 }
        r0.close();	 Catch:{ IOException -> 0x0164 }
    L_0x0026:
        if (r4 == 0) goto L_0x0161;
    L_0x0028:
        r0 = com.tencent.recovery.wx.util.EncryptUtil.n(r4);	 Catch:{ Exception -> 0x0138 }
        r2 = "Recovery.WXRecoveryHandleService";	 Catch:{ Exception -> 0x0138 }
        r3 = "config data md5=%s";	 Catch:{ Exception -> 0x0138 }
        r5 = 1;	 Catch:{ Exception -> 0x0138 }
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0138 }
        r6 = 0;	 Catch:{ Exception -> 0x0138 }
        r5[r6] = r0;	 Catch:{ Exception -> 0x0138 }
        com.tencent.recovery.log.RecoveryLog.i(r2, r3, r5);	 Catch:{ Exception -> 0x0138 }
        r2 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC0oMW80k4h7zmBbHGhzQzs5Jv1uy5j0JVUG//dWHeu0q6PF/xCU97h/e6h2Q9SXLu0M4TTd89QMXbab9MMUXrxqIqVjzm92A4WyNbAElAwhE9AGO16ryYn+tNzDfmwyjVz6dwLzZbNjjH7akYZRopJYqo17kKn+xrnqM+GRKMOJQIDAQAB";	 Catch:{ Exception -> 0x0138 }
        r2 = com.tencent.recovery.wx.util.EncryptUtil.i(r4, r2);	 Catch:{ Exception -> 0x0138 }
        if (r2 != 0) goto L_0x011e;	 Catch:{ Exception -> 0x0138 }
    L_0x0044:
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0138 }
        r3 = "KeyConfigDecryptFail[";	 Catch:{ Exception -> 0x0138 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0138 }
        r0 = r2.append(r0);	 Catch:{ Exception -> 0x0138 }
        r2 = "]";	 Catch:{ Exception -> 0x0138 }
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x0138 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0138 }
        r11.arH = r0;	 Catch:{ Exception -> 0x0138 }
        r0 = r1;
    L_0x005e:
        return r0;
    L_0x005f:
        r0 = move-exception;
        r0 = r1;
    L_0x0061:
        if (r0 == 0) goto L_0x0072;
    L_0x0063:
        r0.close();	 Catch:{ IOException -> 0x0068 }
        r4 = r1;
        goto L_0x0026;
    L_0x0068:
        r0 = move-exception;
        r4 = r1;
        goto L_0x0026;
    L_0x006b:
        r0 = move-exception;
    L_0x006c:
        if (r1 == 0) goto L_0x0071;
    L_0x006e:
        r1.close();	 Catch:{ IOException -> 0x0167 }
    L_0x0071:
        throw r0;
    L_0x0072:
        r4 = r1;
        goto L_0x0026;
    L_0x0074:
        r0 = com.tencent.recovery.wx.util.WXUtil.Va(r10);
        r2 = new java.net.URL;	 Catch:{ Exception -> 0x017b, all -> 0x0171 }
        r2.<init>(r0);	 Catch:{ Exception -> 0x017b, all -> 0x0171 }
        r0 = r2.openConnection();	 Catch:{ Exception -> 0x017b, all -> 0x0171 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x017b, all -> 0x0171 }
        r2 = "GET";	 Catch:{ Exception -> 0x0181, all -> 0x0174 }
        r0.setRequestMethod(r2);	 Catch:{ Exception -> 0x0181, all -> 0x0174 }
        r2 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;	 Catch:{ Exception -> 0x0181, all -> 0x0174 }
        r0.setConnectTimeout(r2);	 Catch:{ Exception -> 0x0181, all -> 0x0174 }
        r2 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;	 Catch:{ Exception -> 0x0181, all -> 0x0174 }
        r0.setReadTimeout(r2);	 Catch:{ Exception -> 0x0181, all -> 0x0174 }
        r0.connect();	 Catch:{ Exception -> 0x0181, all -> 0x0174 }
        r2 = r0.getResponseCode();	 Catch:{ Exception -> 0x0181, all -> 0x0174 }
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ Exception -> 0x0181, all -> 0x0174 }
        if (r2 == r3) goto L_0x00b2;	 Catch:{ Exception -> 0x0181, all -> 0x0174 }
    L_0x009e:
        r2 = com.tencent.recovery.wx.util.WXUtil.CR(r2);	 Catch:{ Exception -> 0x0181, all -> 0x0174 }
        r11.arH = r2;	 Catch:{ Exception -> 0x0181, all -> 0x0174 }
        r3 = r1;
        r4 = r1;
    L_0x00a6:
        if (r3 == 0) goto L_0x00ab;
    L_0x00a8:
        r3.close();	 Catch:{ IOException -> 0x016a }
    L_0x00ab:
        if (r0 == 0) goto L_0x0026;
    L_0x00ad:
        r0.disconnect();
        goto L_0x0026;
    L_0x00b2:
        r3 = r0.getInputStream();	 Catch:{ Exception -> 0x0181, all -> 0x0174 }
        if (r3 != 0) goto L_0x00bf;
    L_0x00b8:
        r2 = "KeyConfigHttpInputStreamIsNull";	 Catch:{ Exception -> 0x0188, all -> 0x010e }
        r11.arH = r2;	 Catch:{ Exception -> 0x0188, all -> 0x010e }
        r4 = r1;	 Catch:{ Exception -> 0x0188, all -> 0x010e }
        goto L_0x00a6;	 Catch:{ Exception -> 0x0188, all -> 0x010e }
    L_0x00bf:
        r4 = c(r3);	 Catch:{ Exception -> 0x0188, all -> 0x010e }
        if (r4 != 0) goto L_0x0105;
    L_0x00c5:
        r2 = "KeyConfigHttpInputStreamReadDataIsNull";	 Catch:{ Exception -> 0x00cb, all -> 0x010e }
        r11.arH = r2;	 Catch:{ Exception -> 0x00cb, all -> 0x010e }
        goto L_0x00a6;
    L_0x00cb:
        r2 = move-exception;
        r9 = r2;
        r2 = r3;
        r3 = r0;
        r0 = r9;
    L_0x00d0:
        r5 = "Recovery.WXRecoveryHandleService";	 Catch:{ all -> 0x0178 }
        r6 = "getConfigData";	 Catch:{ all -> 0x0178 }
        r7 = 0;	 Catch:{ all -> 0x0178 }
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0178 }
        com.tencent.recovery.log.RecoveryLog.printErrStackTrace(r5, r0, r6, r7);	 Catch:{ all -> 0x0178 }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0178 }
        r6 = "Config HttpInputStream Exception: [";	 Catch:{ all -> 0x0178 }
        r5.<init>(r6);	 Catch:{ all -> 0x0178 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x0178 }
        r0 = r5.append(r0);	 Catch:{ all -> 0x0178 }
        r5 = "]";	 Catch:{ all -> 0x0178 }
        r0 = r0.append(r5);	 Catch:{ all -> 0x0178 }
        r0 = r0.toString();	 Catch:{ all -> 0x0178 }
        r11.arH = r0;	 Catch:{ all -> 0x0178 }
        if (r2 == 0) goto L_0x00fe;
    L_0x00fb:
        r2.close();	 Catch:{ IOException -> 0x016d }
    L_0x00fe:
        if (r3 == 0) goto L_0x0026;
    L_0x0100:
        r3.disconnect();
        goto L_0x0026;
    L_0x0105:
        r2 = r4.length;	 Catch:{ Exception -> 0x00cb, all -> 0x010e }
        if (r2 != 0) goto L_0x00a6;	 Catch:{ Exception -> 0x00cb, all -> 0x010e }
    L_0x0108:
        r2 = "KeyConfigHttpInputStreamReadDataLengthZero";	 Catch:{ Exception -> 0x00cb, all -> 0x010e }
        r11.arH = r2;	 Catch:{ Exception -> 0x00cb, all -> 0x010e }
        goto L_0x00a6;
    L_0x010e:
        r1 = move-exception;
        r9 = r1;
        r1 = r3;
        r3 = r0;
        r0 = r9;
    L_0x0113:
        if (r1 == 0) goto L_0x0118;
    L_0x0115:
        r1.close();	 Catch:{ IOException -> 0x016f }
    L_0x0118:
        if (r3 == 0) goto L_0x011d;
    L_0x011a:
        r3.disconnect();
    L_0x011d:
        throw r0;
    L_0x011e:
        r0 = "Recovery.WXRecoveryHandleService";	 Catch:{ Exception -> 0x0138 }
        r3 = "config data decrypt md5=%s";	 Catch:{ Exception -> 0x0138 }
        r4 = 1;	 Catch:{ Exception -> 0x0138 }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0138 }
        r5 = 0;	 Catch:{ Exception -> 0x0138 }
        r6 = com.tencent.recovery.wx.util.EncryptUtil.n(r2);	 Catch:{ Exception -> 0x0138 }
        r4[r5] = r6;	 Catch:{ Exception -> 0x0138 }
        com.tencent.recovery.log.RecoveryLog.i(r0, r3, r4);	 Catch:{ Exception -> 0x0138 }
        r0 = new java.lang.String;	 Catch:{ Exception -> 0x0138 }
        r0.<init>(r2);	 Catch:{ Exception -> 0x0138 }
        goto L_0x005e;
    L_0x0138:
        r0 = move-exception;
        r2 = "Recovery.WXRecoveryHandleService";
        r3 = "getConfigData";
        r4 = new java.lang.Object[r8];
        com.tencent.recovery.log.RecoveryLog.printErrStackTrace(r2, r0, r3, r4);
        r2 = new java.lang.StringBuilder;
        r3 = "Config Decrypt Exception: [";
        r2.<init>(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r2 = "]";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r11.arH = r0;
    L_0x0161:
        r0 = r1;
        goto L_0x005e;
    L_0x0164:
        r0 = move-exception;
        goto L_0x0026;
    L_0x0167:
        r1 = move-exception;
        goto L_0x0071;
    L_0x016a:
        r2 = move-exception;
        goto L_0x00ab;
    L_0x016d:
        r0 = move-exception;
        goto L_0x00fe;
    L_0x016f:
        r1 = move-exception;
        goto L_0x0118;
    L_0x0171:
        r0 = move-exception;
        r3 = r1;
        goto L_0x0113;
    L_0x0174:
        r2 = move-exception;
        r3 = r0;
        r0 = r2;
        goto L_0x0113;
    L_0x0178:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0113;
    L_0x017b:
        r0 = move-exception;
        r2 = r1;
        r3 = r1;
        r4 = r1;
        goto L_0x00d0;
    L_0x0181:
        r2 = move-exception;
        r3 = r0;
        r4 = r1;
        r0 = r2;
        r2 = r1;
        goto L_0x00d0;
    L_0x0188:
        r2 = move-exception;
        r4 = r1;
        r9 = r3;
        r3 = r0;
        r0 = r2;
        r2 = r9;
        goto L_0x00d0;
    L_0x0190:
        r1 = move-exception;
        r9 = r1;
        r1 = r0;
        r0 = r9;
        goto L_0x006c;
    L_0x0196:
        r2 = move-exception;
        goto L_0x0061;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.recovery.wx.service.WXRecoveryHandleService.a(java.lang.String, com.tencent.recovery.model.RecoveryHandleItem):java.lang.String");
    }

    private static byte[] a(java.lang.String r8, java.lang.String r9, com.tencent.recovery.model.RecoveryHandleItem r10) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.recovery.wx.service.WXRecoveryHandleService.a(java.lang.String, java.lang.String, com.tencent.recovery.model.RecoveryHandleItem):byte[]. bs: [B:41:0x007e, B:57:0x00c5]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r1 = 0;
        r0 = "file://";
        r0 = r8.startsWith(r0);
        if (r0 == 0) goto L_0x003b;
    L_0x000a:
        r0 = "file://";
        r2 = "";
        r0 = r8.replace(r0, r2);
        r3 = new java.io.File;
        r3.<init>(r0);
        r2 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0026, all -> 0x0032 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0026, all -> 0x0032 }
        r0 = c(r2);	 Catch:{ Exception -> 0x0127, all -> 0x0123 }
        r2.close();	 Catch:{ IOException -> 0x00f9 }
    L_0x0025:
        return r0;
    L_0x0026:
        r0 = move-exception;
        r0 = r1;
    L_0x0028:
        if (r0 == 0) goto L_0x0039;
    L_0x002a:
        r0.close();	 Catch:{ IOException -> 0x002f }
        r0 = r1;
        goto L_0x0025;
    L_0x002f:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0025;
    L_0x0032:
        r0 = move-exception;
    L_0x0033:
        if (r1 == 0) goto L_0x0038;
    L_0x0035:
        r1.close();	 Catch:{ IOException -> 0x00fc }
    L_0x0038:
        throw r0;
    L_0x0039:
        r0 = r1;
        goto L_0x0025;
    L_0x003b:
        r0 = com.tencent.recovery.wx.util.WXUtil.Va(r8);
        r2 = new java.net.URL;	 Catch:{ Exception -> 0x0113, all -> 0x00ec }
        r2.<init>(r0);	 Catch:{ Exception -> 0x0113, all -> 0x00ec }
        r0 = r2.openConnection();	 Catch:{ Exception -> 0x0113, all -> 0x00ec }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x0113, all -> 0x00ec }
        r2 = "GET";	 Catch:{ Exception -> 0x011b, all -> 0x0106 }
        r0.setRequestMethod(r2);	 Catch:{ Exception -> 0x011b, all -> 0x0106 }
        r2 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;	 Catch:{ Exception -> 0x011b, all -> 0x0106 }
        r0.setConnectTimeout(r2);	 Catch:{ Exception -> 0x011b, all -> 0x0106 }
        r2 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;	 Catch:{ Exception -> 0x011b, all -> 0x0106 }
        r0.setReadTimeout(r2);	 Catch:{ Exception -> 0x011b, all -> 0x0106 }
        r0.connect();	 Catch:{ Exception -> 0x011b, all -> 0x0106 }
        r2 = r0.getResponseCode();	 Catch:{ Exception -> 0x011b, all -> 0x0106 }
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ Exception -> 0x011b, all -> 0x0106 }
        if (r2 == r3) goto L_0x0078;	 Catch:{ Exception -> 0x011b, all -> 0x0106 }
    L_0x0065:
        r2 = com.tencent.recovery.wx.util.WXUtil.CS(r2);	 Catch:{ Exception -> 0x011b, all -> 0x0106 }
        r10.arH = r2;	 Catch:{ Exception -> 0x011b, all -> 0x0106 }
        r3 = r1;
    L_0x006c:
        if (r3 == 0) goto L_0x0071;
    L_0x006e:
        r3.close();	 Catch:{ IOException -> 0x00ff }
    L_0x0071:
        if (r0 == 0) goto L_0x012b;
    L_0x0073:
        r0.disconnect();
        r0 = r1;
        goto L_0x0025;
    L_0x0078:
        r3 = r0.getInputStream();	 Catch:{ Exception -> 0x011b, all -> 0x0106 }
        if (r3 != 0) goto L_0x00bf;
    L_0x007e:
        r2 = "KeyPatchHttpInputStreamIsNull";	 Catch:{ Exception -> 0x0084, all -> 0x010a }
        r10.arH = r2;	 Catch:{ Exception -> 0x0084, all -> 0x010a }
        goto L_0x006c;
    L_0x0084:
        r2 = move-exception;
        r7 = r2;
        r2 = r3;
        r3 = r0;
        r0 = r1;
        r1 = r7;
    L_0x008a:
        r4 = "Recovery.WXRecoveryHandleService";	 Catch:{ all -> 0x0110 }
        r5 = "getPatchDataFromHttp";	 Catch:{ all -> 0x0110 }
        r6 = 0;	 Catch:{ all -> 0x0110 }
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x0110 }
        com.tencent.recovery.log.RecoveryLog.printErrStackTrace(r4, r1, r5, r6);	 Catch:{ all -> 0x0110 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0110 }
        r5 = "Patch HttpInputStream Exception: [";	 Catch:{ all -> 0x0110 }
        r4.<init>(r5);	 Catch:{ all -> 0x0110 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x0110 }
        r1 = r4.append(r1);	 Catch:{ all -> 0x0110 }
        r4 = "]";	 Catch:{ all -> 0x0110 }
        r1 = r1.append(r4);	 Catch:{ all -> 0x0110 }
        r1 = r1.toString();	 Catch:{ all -> 0x0110 }
        r10.arH = r1;	 Catch:{ all -> 0x0110 }
        if (r2 == 0) goto L_0x00b8;
    L_0x00b5:
        r2.close();	 Catch:{ IOException -> 0x0102 }
    L_0x00b8:
        if (r3 == 0) goto L_0x0025;
    L_0x00ba:
        r3.disconnect();
        goto L_0x0025;
    L_0x00bf:
        r2 = com.tencent.recovery.wx.util.FileUtil.c(r3);	 Catch:{ Exception -> 0x0084, all -> 0x010a }
        if (r2 != 0) goto L_0x00cc;
    L_0x00c5:
        r1 = "KeyPatchHttpInputStreamReadDataIsNull";	 Catch:{ Exception -> 0x00e6, all -> 0x010a }
        r10.arH = r1;	 Catch:{ Exception -> 0x00e6, all -> 0x010a }
        r1 = r2;	 Catch:{ Exception -> 0x00e6, all -> 0x010a }
        goto L_0x006c;	 Catch:{ Exception -> 0x00e6, all -> 0x010a }
    L_0x00cc:
        r4 = r2.length;	 Catch:{ Exception -> 0x00e6, all -> 0x010a }
        if (r4 != 0) goto L_0x00d6;	 Catch:{ Exception -> 0x00e6, all -> 0x010a }
    L_0x00cf:
        r1 = "KeyPatchHttpInputStreamReadDataLengthZero";	 Catch:{ Exception -> 0x00e6, all -> 0x010a }
        r10.arH = r1;	 Catch:{ Exception -> 0x00e6, all -> 0x010a }
        r1 = r2;	 Catch:{ Exception -> 0x00e6, all -> 0x010a }
        goto L_0x006c;	 Catch:{ Exception -> 0x00e6, all -> 0x010a }
    L_0x00d6:
        r4 = com.tencent.recovery.wx.util.EncryptUtil.n(r2);	 Catch:{ Exception -> 0x00e6, all -> 0x010a }
        r4 = r4.equals(r9);	 Catch:{ Exception -> 0x00e6, all -> 0x010a }
        if (r4 != 0) goto L_0x012e;	 Catch:{ Exception -> 0x00e6, all -> 0x010a }
    L_0x00e0:
        r4 = "KeyPatchCheckMd5Fail";	 Catch:{ Exception -> 0x00e6, all -> 0x010a }
        r10.arH = r4;	 Catch:{ Exception -> 0x00e6, all -> 0x010a }
        goto L_0x006c;
    L_0x00e6:
        r1 = move-exception;
        r7 = r3;
        r3 = r0;
        r0 = r2;
        r2 = r7;
        goto L_0x008a;
    L_0x00ec:
        r0 = move-exception;
        r3 = r1;
    L_0x00ee:
        if (r1 == 0) goto L_0x00f3;
    L_0x00f0:
        r1.close();	 Catch:{ IOException -> 0x0104 }
    L_0x00f3:
        if (r3 == 0) goto L_0x00f8;
    L_0x00f5:
        r3.disconnect();
    L_0x00f8:
        throw r0;
    L_0x00f9:
        r1 = move-exception;
        goto L_0x0025;
    L_0x00fc:
        r1 = move-exception;
        goto L_0x0038;
    L_0x00ff:
        r2 = move-exception;
        goto L_0x0071;
    L_0x0102:
        r1 = move-exception;
        goto L_0x00b8;
    L_0x0104:
        r1 = move-exception;
        goto L_0x00f3;
    L_0x0106:
        r2 = move-exception;
        r3 = r0;
        r0 = r2;
        goto L_0x00ee;
    L_0x010a:
        r1 = move-exception;
        r7 = r1;
        r1 = r3;
        r3 = r0;
        r0 = r7;
        goto L_0x00ee;
    L_0x0110:
        r0 = move-exception;
        r1 = r2;
        goto L_0x00ee;
    L_0x0113:
        r0 = move-exception;
        r2 = r1;
        r3 = r1;
        r7 = r0;
        r0 = r1;
        r1 = r7;
        goto L_0x008a;
    L_0x011b:
        r2 = move-exception;
        r3 = r0;
        r0 = r1;
        r7 = r2;
        r2 = r1;
        r1 = r7;
        goto L_0x008a;
    L_0x0123:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0033;
    L_0x0127:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0028;
    L_0x012b:
        r0 = r1;
        goto L_0x0025;
    L_0x012e:
        r1 = r2;
        goto L_0x006c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.recovery.wx.service.WXRecoveryHandleService.a(java.lang.String, java.lang.String, com.tencent.recovery.model.RecoveryHandleItem):byte[]");
    }

    private static byte[] c(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        while (true) {
            int read = inputStream.read(bArr, 0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            if (read <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private static boolean UZ(String str) {
        try {
            InetAddress byName = InetAddress.getByName(str);
            if (byName == null || byName.getHostAddress() == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
