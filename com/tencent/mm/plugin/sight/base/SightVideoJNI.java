package com.tencent.mm.plugin.sight.base;

import android.graphics.Bitmap;
import android.view.Surface;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class SightVideoJNI {
    public static final int MMSIGHT_YUV420P = 2;
    public static final int MMSIGHT_YUV420SP = 1;
    private static final String TAG = "MicroMsg.SightVideoJNI";
    public static final int TYPE_BITMAP = 1;
    public static final int TYPE_SURFACE = 0;

    public static native void NV21ToYUV420P(byte[] bArr, byte[] bArr2, int i, int i2);

    public static native void NV21ToYUV420PAndRotate(byte[] bArr, byte[] bArr2, int i, int i2, int i3);

    public static native void NV21ToYUV420PAndScaleRotate(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5, boolean z, int i6);

    public static native void NV21ToYUV420SP(byte[] bArr, byte[] bArr2, int i, int i2);

    public static native void NV21ToYUV420SPAndRotate(byte[] bArr, byte[] bArr2, int i, int i2, int i3);

    public static native void NV21ToYUV420SPAndScaleRotate(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5, boolean z, int i6);

    public static native void NV21ToYUV420XXAndScaleRotate(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, boolean z2);

    public static native void YUV420SPScale(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4);

    public static native void YUV420SPScaleCtxRelease();

    public static native void cropCameraData(byte[] bArr, byte[] bArr2, int i, int i2, int i3);

    public static native int drawFrame(int i, Bitmap bitmap, int i2, Bitmap bitmap2, boolean z, boolean z2);

    public static native int drawScaledFrame(int i, Bitmap bitmap, int i2, int i3);

    public static native int drawSurfaceColor(Surface surface, int i);

    public static native int drawSurfaceFrame(int i, Surface surface, int i2, Bitmap bitmap, boolean z);

    public static native int drawSurfaceThumb(Surface surface, Bitmap bitmap, Bitmap bitmap2);

    public static native int freeAll();

    public static native int freeObj(int i);

    public static native int[] getBlurThumbData(int i);

    public static native int[] getBlurThumbDataFromBmp(Bitmap bitmap);

    public static native int getHeight(int i);

    private static native byte[] getMP4RecordInfo(String str);

    public static native int getMp4Rotate(String str);

    public static native String getSimpleMp4Info(String str);

    public static native byte[] getThumbData(int i);

    public static native double getVideoDuration(int i);

    public static native int getVideoHeight(int i);

    public static native String getVideoInfo(int i);

    public static native double getVideoPlayTime(int i);

    public static native double getVideoRate(int i);

    public static native double getVideoStartTime(int i);

    public static native int getVideoWidth(int i);

    public static native int getWidth(int i);

    public static native int handleThumb(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3);

    public static native int initBlurBuffer(int i, int i2, int i3);

    public static native int initDataBuffer(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f, int i8, int i9, int i10, int i11, float f2, int i12);

    public static native int initDataBufferForMMSight(int i, int i2, int i3, int i4, int i5, float f, int i6, int i7, int i8, int i9, float f2, boolean z, boolean z2, int i10, boolean z3);

    public static native void initScaleAndRoateBuffer(int i);

    public static native int isSightOk(String str, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int i);

    public static native byte[] loadAACData(int i);

    public static native void mirrorCameraData(byte[] bArr, int i, int i2, boolean z);

    public static native int muxing(int i, String str, int i2, int i3, int i4, int i5, long j, String str2, float f, int i6, int i7, int i8, int i9, int i10, float f2, byte[] bArr, int i11, boolean z);

    public static native int openFile(String str, int i, int i2, boolean z);

    public static native void optimizeMP4(String str);

    public static native void paddingYuvData16(byte[] bArr, byte[] bArr2, int i, int i2, int i3);

    public static native void registerALL();

    public static native void releaseBigSightDataBuffer(int i);

    public static native void releaseDataBuffer(int i);

    public static native int releaseRecorderBuffer();

    public static native void releaseScaleAndRoateBuffer(int i);

    public static native int remuxing(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2, byte[] bArr, int i7, boolean z);

    public static native int seekStream(double d, int i);

    public static native int seekStreamWithFlag(double d, int i, int i2);

    public static native void setRotateForBufId(int i, int i2);

    public static native int shouldRemuxing(String str, int i, int i2, int i3, double d, int i4);

    private static native void tagMP4Dscp(String str, byte[] bArr, int i);

    private static native void tagMP4RecordInfo(String str, byte[] bArr, int i);

    public static native void tagRotateVideo(String str, String str2, int i);

    public static native int triggerEncode(int i, int i2, boolean z);

    public static native int triggerEncodeForBigSight(int i, int i2, int i3);

    public static native void writeAACData(int i, ByteBuffer byteBuffer, int i2);

    public static native void writeBlurData(int i, byte[] bArr, int i2, int i3, int i4);

    public static native void writeH264Data(int i, ByteBuffer byteBuffer, int i2);

    public static native void writeThumbData(int i, byte[] bArr, int i2, int i3, int i4);

    public static native void writeYuvData(int i, byte[] bArr, int i2, int i3, int i4);

    public static native void writeYuvDataForMMSight(int i, byte[] bArr, int i2, int i3, int i4, boolean z, boolean z2, int i5, int i6);

    public static int initDataBufferRef(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f, int i8, int i9, int i10, int i11, float f2, int i12) {
        w.d(TAG, "ashutest::call initDataBuffer, ret %d", Integer.valueOf(initDataBuffer(i, i2, i3, i4, i5, i6, i7, f, i8, i9, i10, i11, f2, i12)));
        return initDataBuffer(i, i2, i3, i4, i5, i6, i7, f, i8, i9, i10, i11, f2, i12);
    }

    public static void releaseRecorderBufferRef(String str) {
        w.d(TAG, "ashutest::call release recorder buffer, %s", str);
        releaseRecorderBuffer();
    }

    public static void releaseDataBufferRef(int i) {
        w.d(TAG, "ashutest::call release dataBufferRef %d", Integer.valueOf(i));
        releaseDataBuffer(i);
    }

    public static void tagMp4RecordInfo(String str, String str2) {
        if (!bg.mA(str) && !bg.mA(str2)) {
            long NA = bg.NA();
            byte[] bArr = new byte[]{(byte) 85, (byte) -60};
            byte[] bytes = str2.getBytes();
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bytes.length + 2);
            allocateDirect.order(ByteOrder.nativeOrder());
            allocateDirect.put(bArr);
            allocateDirect.put(bytes);
            bArr = allocateDirect.array();
            tagMP4RecordInfo(str, bArr, bArr.length);
            w.i(TAG, "tagMP4RecordInfo used %sms", Long.valueOf(bg.aB(NA)));
        }
    }

    public static String getMp4RecordInfo(String str) {
        if (bg.mA(str)) {
            return null;
        }
        Object mP4RecordInfo = getMP4RecordInfo(str);
        if (mP4RecordInfo != null && mP4RecordInfo.length > 0) {
            int i = 0;
            while (i < mP4RecordInfo.length) {
                if (mP4RecordInfo[i] == (byte) -60) {
                    break;
                }
                i++;
            }
            i = 0;
            w.i(TAG, "getMp4RecordInfo, index: %s", Integer.valueOf(i));
            if (i + 1 < mP4RecordInfo.length) {
                try {
                    Object obj = new byte[(mP4RecordInfo.length - (i + 1))];
                    System.arraycopy(mP4RecordInfo, i + 1, obj, 0, obj.length);
                    return new String(obj);
                } catch (Exception e) {
                }
            }
        }
        return null;
    }

    public static void tagMP4Dscp(String str, byte[] bArr) {
        if (!bg.mA(str) && bArr != null) {
            long NA = bg.NA();
            byte[] bArr2 = new byte[]{(byte) 85, (byte) -60};
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length + 2);
            allocateDirect.order(ByteOrder.nativeOrder());
            allocateDirect.put(bArr2);
            allocateDirect.put(bArr);
            bArr2 = allocateDirect.array();
            tagMP4Dscp(str, bArr2, bArr2.length);
            w.i(TAG, "tagMP4Dscp used %sms", Long.valueOf(bg.aB(NA)));
        }
    }
}
