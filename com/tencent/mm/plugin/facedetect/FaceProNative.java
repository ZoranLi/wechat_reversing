package com.tencent.mm.plugin.facedetect;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.a.a;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import org.json.JSONArray;

public class FaceProNative {
    public static final int ROTFLIPHOR = 3;
    public static final int ROTFLIPLEFT = 4;
    public static final int ROTFLIPRIGHT = 5;
    public static final int ROTLEFT = 1;
    public static final int ROTRIGHT = 2;
    public static final int ROTSTABLE = 0;
    private static final String TAG = "MicroMsg.FaceProNative";
    private static final long TIMEOUT_CHECKER = 3600000;
    private static String[] cachedStr = null;
    private static long lastCheckTime = -1;
    private long nativePtr;

    public static class FaceResult implements Parcelable {
        public static final Creator<FaceResult> CREATOR = new Creator<FaceResult>() {
            public final FaceResult createFromParcel(Parcel parcel) {
                return new FaceResult(parcel);
            }

            public final FaceResult[] newArray(int i) {
                return new FaceResult[i];
            }
        };
        public byte[] data;
        public int result;
        public byte[] sidedata;

        protected FaceResult(Parcel parcel) {
            this.result = parcel.readInt();
            this.data = parcel.createByteArray();
            this.sidedata = parcel.createByteArray();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.result);
            parcel.writeByteArray(this.data);
            parcel.writeByteArray(this.sidedata);
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            int i = 0;
            StringBuilder append = new StringBuilder("FaceResult{result=").append(this.result).append(", sidedataLen=").append(this.sidedata == null ? 0 : this.sidedata.length).append(", dataLen=");
            if (this.data != null) {
                i = this.data.length;
            }
            return append.append(i).append('}').toString();
        }
    }

    public static class FaceStatus implements Parcelable {
        public static final Creator<FaceStatus> CREATOR = new Creator<FaceStatus>() {
            public final FaceStatus createFromParcel(Parcel parcel) {
                return new FaceStatus(parcel);
            }

            public final FaceStatus[] newArray(int i) {
                return new FaceStatus[i];
            }
        };
        public Rect facerect;
        public float pitch;
        public int result;
        public float roll;
        public float[] xys;
        public float yaw;

        protected FaceStatus(Parcel parcel) {
            this.result = parcel.readInt();
            this.facerect = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
            this.xys = parcel.createFloatArray();
            this.pitch = parcel.readFloat();
            this.yaw = parcel.readFloat();
            this.roll = parcel.readFloat();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.result);
            parcel.writeParcelable(this.facerect, i);
            parcel.writeFloatArray(this.xys);
            parcel.writeFloat(this.pitch);
            parcel.writeFloat(this.yaw);
            parcel.writeFloat(this.roll);
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "FaceStatus{result=" + this.result + ", facerect=" + this.facerect + ", pitch=" + this.pitch + ", yaw=" + this.yaw + ", roll=" + this.roll + '}';
        }
    }

    private native void NativeConstructor();

    private native void NativeDestructor();

    public static native int engineVersion();

    public static native boolean nativeInit();

    public native FaceStatus engineFaceProcess(byte[] bArr, int i, int i2, int i3, int i4, int i5);

    public native int[] engineGetAllMotions();

    public native int engineGetCurrMotion();

    public native String engineGetCurrMotionData();

    public native int engineGroupChange();

    public native int engineInit(String str, byte[] bArr, String str2, String str3);

    public native int engineNextMotion();

    public native int engineRelease();

    public native int engineReleaseCurrMotion();

    public native FaceResult engineReleaseOut();

    public native int engineSetVoiceData(byte[] bArr);

    public native int engineStartRecord();

    public FaceProNative() {
        NativeConstructor();
    }

    public void destroy() {
        NativeDestructor();
    }

    protected void finalize() {
        super.finalize();
        NativeDestructor();
    }

    static {
        k.b("FacePro", FaceProNative.class.getClassLoader());
        k.b("wechatvoicereco", FaceProNative.class.getClassLoader());
        k.b("wechatxlog", FaceProNative.class.getClassLoader());
        nativeInit();
    }

    @a
    public static String[] getDynamicValue(String str) {
        if (System.currentTimeMillis() - lastCheckTime >= TIMEOUT_CHECKER) {
            lastCheckTime = System.currentTimeMillis();
            try {
                JSONArray jSONArray = new JSONArray(((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue(str));
                ArrayList arrayList = new ArrayList(5);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                cachedStr = new String[length];
                arrayList.toArray(cachedStr);
            } catch (Throwable e) {
                w.printErrStackTrace(TAG, e, "hy: array resolve failed", new Object[0]);
            }
        }
        return cachedStr;
    }
}
