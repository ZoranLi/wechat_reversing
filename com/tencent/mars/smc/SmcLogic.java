package com.tencent.mars.smc;

import com.tencent.mars.Mars;
import com.tencent.mm.plugin.report.service.g;
import java.util.ArrayList;

public class SmcLogic {
    private static final String TAG = "mars.SmcLogic";
    private static ICallBack callBack = null;

    public static class BaseInfo {
        public String deviceBrand;
        public String deviceModel;
        public String languageVer;
        public String osName;
        public String osVersion;
    }

    public interface ICallBack {
        boolean OnSelfMonitorOpLogReady(byte[] bArr);

        String getKVCommPath();

        BaseInfo getKVCommReqBaseInfo();

        int getSingleReportBufSizeB();

        void onReportDataReady(byte[] bArr, byte[] bArr2, int i);

        boolean onRequestGetStrategy(byte[] bArr, int i);
    }

    public static class IPCSmcLogic {
        private static void reportKV(long j, String str, boolean z, boolean z2) {
            g.oUh.a((int) j, str, z2, z);
        }

        private static void reportIDKey(long j, long j2, long j3, boolean z) {
            g.oUh.a(j, j2, j3, z);
        }

        private static void reportGroupIDKey(int[] iArr, int[] iArr2, int[] iArr3, int i, boolean z) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(new IDKey(iArr[i2], iArr2[i2], iArr3[i2]));
            }
            g.oUh.b(arrayList, z);
        }
    }

    public static native void OnPluginMsg(long j, long j2, long j3, long j4, long j5, long j6);

    public static native void OnReportResp(int i, int i2, byte[] bArr, int i3);

    public static native void OnStrategyResp(int i, int i2, byte[] bArr, int i3);

    public static native void SetDebugFlag(boolean z);

    public static native void SetMonitorId(boolean z, int i, int i2, int i3, int i4, int i5, int i6);

    private static native ArrayList<String> getLoadLibraries();

    public static native ArrayList<Integer> getStrategyVersions();

    public static native void reportIDKey(long j, long j2, long j3, boolean z);

    public static native void reportListIDKey(IDKey[] iDKeyArr, boolean z);

    public static native void setUin(long j);

    public static native void writeImportKvData(long j, String str, boolean z);

    public static native void writeImportKvPbData(long j, byte[] bArr, boolean z);

    public static native void writeKvData(long j, String str, boolean z);

    public static native void writeKvPbData(long j, byte[] bArr, boolean z);

    static {
        ArrayList loadLibraries;
        try {
            loadLibraries = getLoadLibraries();
        } catch (UnsatisfiedLinkError e) {
            loadLibraries = null;
            Mars.loadDefaultMarsLibrary();
        }
        Mars.checkLoadedModules(loadLibraries, TAG);
    }

    public static void setCallBack(ICallBack iCallBack) {
        callBack = iCallBack;
    }

    private static void onReportDataReady(byte[] bArr, byte[] bArr2, int i) {
        if (callBack != null) {
            callBack.onReportDataReady(bArr, bArr2, i);
        }
    }

    private static boolean onRequestGetStrategy(byte[] bArr, int i) {
        if (callBack == null) {
            return false;
        }
        return callBack.onRequestGetStrategy(bArr, i);
    }

    private static boolean OnSelfMonitorOpLogReady(byte[] bArr) {
        if (callBack == null) {
            return false;
        }
        return callBack.OnSelfMonitorOpLogReady(bArr);
    }

    private static int getSingleReportBufSizeB() {
        if (callBack == null) {
            return 0;
        }
        return callBack.getSingleReportBufSizeB();
    }

    private static BaseInfo getKVCommReqBaseInfo() {
        if (callBack == null) {
            return new BaseInfo();
        }
        return callBack.getKVCommReqBaseInfo();
    }

    private static String getKVCommPath() {
        if (callBack == null) {
            return "";
        }
        return callBack.getKVCommPath();
    }
}
