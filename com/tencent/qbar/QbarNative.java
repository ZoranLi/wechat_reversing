package com.tencent.qbar;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.sdk.platformtools.w;

public class QbarNative {
    public static QbarPossibleInfo wPu = new QbarPossibleInfo();
    public byte[] data = new byte[3000];
    public byte[] type = new byte[100];
    public byte[] wPv = new byte[100];
    public int[] wPw = new int[4];
    public byte[] wPx = new byte[e.CTRL_INDEX];
    public int[] wPy = new int[2];
    public int wPz = -1;

    private static class QbarPossibleInfo {
        public int hasQrcode;
        public float qrcodeAreaRatio;
    }

    private static class a {
    }

    private native int DetectCode(byte[] bArr, int i, int i2, int i3, int i4);

    private static native int Encode(byte[] bArr, int[] iArr, String str, int i, int i2, String str2, int i3);

    private static native int EncodeBitmap(String str, Bitmap bitmap, int i, int i2, int i3, int i4, String str2, int i5);

    public static native int FocusInit(int i, int i2, boolean z, int i3, int i4);

    public static native boolean FocusPro(byte[] bArr, boolean z, boolean[] zArr);

    public static native int FocusRelease();

    private native int GetOneResult(byte[] bArr, byte[] bArr2, byte[] bArr3, int[] iArr, int i);

    private native int GetOneResultReport(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int[] iArr, int[] iArr2, int i);

    private native int GetResults(byte[] bArr, byte[] bArr2, byte[] bArr3, Point[] pointArr, int[] iArr, a aVar, int i);

    private static native String GetVersion();

    public static native int QIPUtilYUVCrop(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5, int i6);

    private native int Release(int i);

    private native int ScanImage(byte[] bArr, int i, int i2, int i3, int i4);

    public static native int focusedEngineForBankcardInit(int i, int i2, int i3, boolean z);

    public static native int focusedEngineGetVersion();

    public static native int focusedEngineProcess(byte[] bArr);

    public static native int focusedEngineRelease();

    private static native int nativeArrayConvert(int i, int i2, byte[] bArr, int[] iArr);

    private static native int nativeCropGray2(byte[] bArr, byte[] bArr2, int i, int i2, int i3);

    private static native int nativeGrayRotateCropSub(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr2, int[] iArr, int i7, int i8);

    public static native int nativeRelease();

    private static native int nativeTransBytes(int[] iArr, byte[] bArr, int i, int i2);

    private static native int nativeTransPixels(int[] iArr, byte[] bArr, int i, int i2);

    private static native int nativeYUVrotate(byte[] bArr, byte[] bArr2, int i, int i2);

    private static native int nativeYUVrotateLess(byte[] bArr, int i, int i2);

    private static native int nativeYuvToCropIntArray(byte[] bArr, int[] iArr, int i, int i2, int i3, int i4, int i5, int i6);

    public native int GetPossibleInfo(QbarPossibleInfo qbarPossibleInfo, int i);

    public native int Init(int i, int i2, int i3, String str, String str2);

    public native int SetReaders(int[] iArr, int i, int i2);

    static {
        k.b("wechatQrMod", QbarNative.class.getClassLoader());
    }

    public static String getVersion() {
        return GetVersion();
    }

    public static int a(byte[] bArr, int[] iArr, String str, int i, int i2, String str2) {
        return Encode(bArr, iArr, str, i, i2, str2, -1);
    }

    public final int i(byte[] bArr, int i, int i2) {
        return ScanImage(bArr, i, i2, 0, this.wPz);
    }

    public final int a(StringBuilder stringBuilder, StringBuilder stringBuilder2, StringBuilder stringBuilder3, StringBuilder stringBuilder4, int[] iArr) {
        int GetOneResultReport = GetOneResultReport(this.type, this.data, this.wPv, this.wPx, this.wPy, this.wPw, this.wPz);
        try {
            iArr[0] = this.wPy[0];
            iArr[1] = this.wPy[1];
            String str = new String(this.wPv, 0, this.wPw[2], "UTF-8");
            stringBuilder3.append(str);
            if (str.equals("ANY")) {
                stringBuilder.append(new String(this.type, 0, this.wPw[0], "UTF-8"));
                stringBuilder2.append(new String(this.data, 0, this.wPw[1], "UTF-8"));
                stringBuilder4.append(new String(this.wPx, 0, this.wPw[3], "UTF-8"));
                if (stringBuilder2.length() == 0) {
                    stringBuilder.append(new String(this.type, 0, this.wPw[0], "ASCII"));
                    stringBuilder2.append(new String(this.data, 0, this.wPw[1], "ASCII"));
                    stringBuilder4.append(new String(this.wPx, 0, this.wPw[3], "ASCII"));
                }
            } else {
                stringBuilder.append(new String(this.type, 0, this.wPw[0], str));
                stringBuilder2.append(new String(this.data, 0, this.wPw[1], str));
                stringBuilder4.append(new String(this.wPx, 0, this.wPw[3], str));
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.QbarNative", e, "", new Object[0]);
        }
        return GetOneResultReport;
    }

    public static int a(byte[] bArr, int[] iArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (bArr == null || bArr2 == null) {
            return -1;
        }
        return nativeGrayRotateCropSub(bArr2, i, i2, i3, i4, i5, i6, bArr, iArr, i7, 0);
    }

    public static int a(byte[] bArr, byte[] bArr2, int i, int i2) {
        if (bArr2 == null) {
            return -1;
        }
        return nativeYUVrotate(bArr, bArr2, i, i2);
    }

    public static int a(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        if (bArr == null || bArr2 == null) {
            return -1;
        }
        return nativeCropGray2(bArr, bArr2, i, i2, i3);
    }

    public static int a(byte[] bArr, int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
        if (bArr == null) {
            return -1;
        }
        return nativeYuvToCropIntArray(bArr, iArr, i, i2, i3, i4, i5, i6);
    }
}
