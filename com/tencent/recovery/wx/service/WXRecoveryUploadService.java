package com.tencent.recovery.wx.service;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryHandleItem;
import com.tencent.recovery.report.RecoveryReporter;
import com.tencent.recovery.service.RecoveryUploadService;
import com.tencent.recovery.util.Util;
import com.tencent.recovery.wx.util.EncryptUtil;
import com.tencent.recovery.wx.util.PByteArray;
import com.tencent.recovery.wx.util.WXUtil;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class WXRecoveryUploadService extends RecoveryUploadService {
    private static final String TAG = "Recovery.WXRecoveryUploadService";
    private static final String UNIT_REPORT_TAG = "RecoveryHandle";

    protected boolean tryToUploadData() {
        Intent intent = new Intent();
        intent.setPackage(getPackageName());
        intent.setAction("com.tecent.mm.intent.action.RECOVERY_STATUS_UPLOAD");
        sendBroadcast(intent);
        List a = RecoveryReporter.a((Context) this, "HandleStatus", RecoveryHandleItem.class);
        boolean uploadData = uploadData(a);
        if (a.size() == 0 || uploadData) {
            RecoveryReporter.br(this, "HandleStatus");
        }
        return uploadData;
    }

    protected boolean uploadData(List<RecoveryHandleItem> list) {
        int fs = Util.fs(this);
        JSONArray jSONArray = new JSONArray();
        String str = "0x26050D40";
        for (RecoveryHandleItem recoveryHandleItem : list) {
            try {
                String str2;
                jSONArray.put(new JSONObject().put("tag", UNIT_REPORT_TAG).put("info", recoveryHandleItem.arH).put(OpenSDKTool4Assistant.EXTRA_UIN, recoveryHandleItem.mry).put("deviceUUID", fs).put("time", Util.eY(recoveryHandleItem.timestamp)).put("cver", recoveryHandleItem.clientVersion).put("processName", recoveryHandleItem.processName).put("phoneStatus", recoveryHandleItem.wQs));
                if (compareVersion(recoveryHandleItem.clientVersion, str) > 0) {
                    str2 = recoveryHandleItem.clientVersion;
                } else {
                    str2 = str;
                }
                str = str2;
            } catch (Exception e) {
            }
        }
        RecoveryLog.i(TAG, "upload result %b %d", Boolean.valueOf(pushData(jSONArray, str)), Integer.valueOf(list.size()));
        return pushData(jSONArray, str);
    }

    private boolean pushData(JSONArray jSONArray, String str) {
        try {
            String fx = WXUtil.fx(this);
            String str2 = "android-" + VERSION.SDK_INT;
            byte[] bytes = new JSONObject().put("head", new JSONObject().put("protocol_ver", 1).put("phone", Build.MANUFACTURER + "-" + Build.MODEL).put("os_ver", str2).put("report_time", System.currentTimeMillis())).put("items", jSONArray).toString().getBytes();
            String toLowerCase = EncryptUtil.n(String.format("weixin#$()%d%d", new Object[]{Integer.decode(str), Integer.valueOf(bytes.length)}).getBytes()).toLowerCase();
            bytes = EncryptUtil.l(bytes);
            PByteArray pByteArray = new PByteArray();
            EncryptUtil.a(pByteArray, bytes, toLowerCase.getBytes());
            StringBuilder append = new StringBuilder(256).append("http://support.weixin.qq.com/cgi-bin/mmsupport-bin/stackreport?version=").append(str).append("&devicetype=").append(str2).append("&filelength=").append(r5).append("&sum=").append(toLowerCase).append("&reporttype=1&NewReportType=110");
            if (!(fx == null || fx.length() == 0)) {
                append.append("&username=").append(fx);
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(append.toString()).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setReadTimeout(20000);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setRequestProperty("content-type", "binary/octet-stream");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(pByteArray.value);
            outputStream.flush();
            outputStream.close();
            if (httpURLConnection.getResponseCode() != m.CTRL_INDEX) {
                String convertStreamToString = convertStreamToString(httpURLConnection.getErrorStream());
                str2 = convertStreamToString(httpURLConnection.getInputStream());
                RecoveryLog.i(TAG, "POST returned: %d %s %s %s", Integer.valueOf(httpURLConnection.getResponseCode()), str, convertStreamToString, str2);
                return false;
            }
            RecoveryLog.i(TAG, "POST returned success %s", str);
            return true;
        } catch (Throwable e) {
            RecoveryLog.printErrStackTrace(TAG, e, "pushData", new Object[0]);
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String convertStreamToString(java.io.InputStream r6) {
        /*
        r5 = 0;
        if (r6 != 0) goto L_0x0007;
    L_0x0003:
        r0 = "";
    L_0x0006:
        return r0;
    L_0x0007:
        r0 = new java.io.BufferedReader;
        r1 = new java.io.InputStreamReader;
        r1.<init>(r6);
        r0.<init>(r1);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
    L_0x0016:
        r2 = r0.readLine();	 Catch:{ IOException -> 0x0034 }
        if (r2 == 0) goto L_0x0049;
    L_0x001c:
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0034 }
        r3.<init>();	 Catch:{ IOException -> 0x0034 }
        r2 = r3.append(r2);	 Catch:{ IOException -> 0x0034 }
        r3 = "\n";
        r2 = r2.append(r3);	 Catch:{ IOException -> 0x0034 }
        r2 = r2.toString();	 Catch:{ IOException -> 0x0034 }
        r1.append(r2);	 Catch:{ IOException -> 0x0034 }
        goto L_0x0016;
    L_0x0034:
        r0 = move-exception;
        r2 = "Recovery.WXRecoveryUploadService";
        r3 = "";
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0067 }
        com.tencent.recovery.log.RecoveryLog.printErrStackTrace(r2, r0, r3, r4);	 Catch:{ all -> 0x0067 }
        r6.close();	 Catch:{ IOException -> 0x005a }
    L_0x0044:
        r0 = r1.toString();
        goto L_0x0006;
    L_0x0049:
        r6.close();	 Catch:{ IOException -> 0x004d }
        goto L_0x0044;
    L_0x004d:
        r0 = move-exception;
        r2 = "Recovery.WXRecoveryUploadService";
        r3 = "";
        r4 = new java.lang.Object[r5];
        com.tencent.recovery.log.RecoveryLog.printErrStackTrace(r2, r0, r3, r4);
        goto L_0x0044;
    L_0x005a:
        r0 = move-exception;
        r2 = "Recovery.WXRecoveryUploadService";
        r3 = "";
        r4 = new java.lang.Object[r5];
        com.tencent.recovery.log.RecoveryLog.printErrStackTrace(r2, r0, r3, r4);
        goto L_0x0044;
    L_0x0067:
        r0 = move-exception;
        r6.close();	 Catch:{ IOException -> 0x006c }
    L_0x006b:
        throw r0;
    L_0x006c:
        r1 = move-exception;
        r2 = "Recovery.WXRecoveryUploadService";
        r3 = "";
        r4 = new java.lang.Object[r5];
        com.tencent.recovery.log.RecoveryLog.printErrStackTrace(r2, r1, r3, r4);
        goto L_0x006b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.recovery.wx.service.WXRecoveryUploadService.convertStreamToString(java.io.InputStream):java.lang.String");
    }

    private static int compareVersion(String str, String str2) {
        try {
            int intValue = Integer.decode(str).intValue();
            int intValue2 = Integer.decode(str2).intValue();
            if (intValue > intValue2) {
                return 1;
            }
            if (intValue2 > intValue) {
                return -1;
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }
}
