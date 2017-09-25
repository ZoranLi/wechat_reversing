package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class FaceDetectReporter implements Parcelable {
    public static final Creator<FaceDetectReporter> CREATOR = new Creator<FaceDetectReporter>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FaceDetectReporter(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FaceDetectReporter[i];
        }
    };
    public static FaceDetectReporter lwE = new FaceDetectReporter();
    String appId = "";
    public boolean lwC = false;
    private FaceDetectReportInfo lwD = null;
    long lwF = 0;
    long lwG = -1;
    public long lwH = -1;
    public int lwI = 0;
    public boolean lwJ = false;
    public long lwh = 0;

    protected FaceDetectReporter(Parcel parcel) {
        boolean z = true;
        this.lwh = parcel.readLong();
        this.lwC = parcel.readByte() != (byte) 0;
        this.lwD = (FaceDetectReportInfo) parcel.readParcelable(FaceDetectReportInfo.class.getClassLoader());
        this.appId = parcel.readString();
        this.lwF = parcel.readLong();
        this.lwG = parcel.readLong();
        this.lwH = parcel.readLong();
        this.lwI = parcel.readInt();
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.lwJ = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeLong(this.lwh);
        parcel.writeByte((byte) (this.lwC ? 1 : 0));
        parcel.writeParcelable(this.lwD, i);
        parcel.writeString(this.appId);
        parcel.writeLong(this.lwF);
        parcel.writeLong(this.lwG);
        parcel.writeLong(this.lwH);
        parcel.writeInt(this.lwI);
        if (!this.lwJ) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
    }

    public int describeContents() {
        return 0;
    }

    public static FaceDetectReporter arN() {
        if (lwE != null) {
            return lwE;
        }
        FaceDetectReporter faceDetectReporter;
        synchronized (FaceDetectReporter.class) {
            if (lwE == null) {
                lwE = new FaceDetectReporter();
            }
            faceDetectReporter = lwE;
        }
        return faceDetectReporter;
    }

    public static void d(long j, int i, int i2) {
        w.i("MicroMsg.FaceDetectReporter", "hy: report video: bioId: %d, errType: %d, errCode: %d", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)});
        g.oUh.i(14121, new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2)});
    }

    private FaceDetectReporter() {
    }

    public final long arO() {
        w.v("MicroMsg.FaceDetectReporter", "create report session");
        if (this.lwD == null) {
            this.lwD = new FaceDetectReportInfo();
        }
        this.lwD.reset();
        this.lwC = false;
        this.lwh = System.currentTimeMillis();
        this.lwD.lwh = this.lwh;
        return this.lwh;
    }

    public final void a(FaceDetectReporter faceDetectReporter) {
        w.v("MicroMsg.FaceDetectReporter", "alvinluo setReporter, stack: %s", new Object[]{bg.bJZ().toString()});
        this.lwD = faceDetectReporter.lwD;
        this.lwC = faceDetectReporter.lwC;
        this.lwh = faceDetectReporter.lwh;
        String str = "MicroMsg.FaceDetectReporter";
        String str2 = "alvinluo sessionId: %d, info: %s";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(this.lwh);
        objArr[1] = this.lwD != null ? this.lwD.toString() : "null";
        w.v(str, str2, objArr);
    }

    public final void F(int i, boolean z) {
        int i2 = 1;
        w.v("MicroMsg.FaceDetectReporter", "reportStartFaceDetect businessType: %d, isRetry: %b", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
        g gVar = g.oUh;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Long.valueOf(this.lwh);
        if (!z) {
            i2 = 0;
        }
        objArr[2] = Integer.valueOf(i2);
        gVar.i(14005, objArr);
    }

    public static int mj(int i) {
        switch (i) {
            case 0:
            case 3:
                return 2;
            case 1:
            case 4:
                return 3;
            case 2:
                return 1;
            case 5:
                return 4;
            default:
                return -1;
        }
    }

    public final void a(int i, boolean z, int i2, int i3, int i4) {
        a(i, z, i2, i3, i4, 0);
    }

    public final void a(int i, boolean z, int i2, int i3, int i4, int i5) {
        w.v("MicroMsg.FaceDetectReporter", "reportFaceDetectVerifyResult sessionId: %d, hasReported: %b, businessType: %d, isRetry: %b, result: %d, errType: %d, errCode: %d", new Object[]{Long.valueOf(this.lwh), Boolean.valueOf(this.lwC), Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        if (this.lwD != null && !this.lwC) {
            int longValue;
            int longValue2;
            w.v("MicroMsg.FaceDetectReporter", "info: %s", new Object[]{this.lwD.toString()});
            this.lwC = true;
            this.lwD.luI = i5;
            if (this.lwD.lwx != 0) {
                this.lwD.lwz = this.lwD.lwy / this.lwD.lwx;
            }
            if (this.lwD.lwA.containsKey(Integer.valueOf(0)) && this.lwD.lwB.containsKey(Integer.valueOf(0))) {
                longValue = (int) (((Long) this.lwD.lwB.get(Integer.valueOf(0))).longValue() - ((Long) this.lwD.lwA.get(Integer.valueOf(0))).longValue());
            } else {
                longValue = 0;
            }
            if (this.lwD.lwA.containsKey(Integer.valueOf(4)) && this.lwD.lwB.containsKey(Integer.valueOf(4))) {
                longValue2 = (int) (((Long) this.lwD.lwB.get(Integer.valueOf(4))).longValue() - ((Long) this.lwD.lwA.get(Integer.valueOf(4))).longValue());
            } else {
                longValue2 = 0;
            }
            w.v("MicroMsg.FaceDetectReporter", "alvinluo normal motion time: %d ms, read number motion time: %d ms", new Object[]{Integer.valueOf(longValue), Integer.valueOf(longValue2)});
            g gVar = g.oUh;
            Object[] objArr = new Object[26];
            objArr[0] = Long.valueOf(this.lwh);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(z ? 1 : 0);
            objArr[3] = Integer.valueOf(i2);
            objArr[4] = Integer.valueOf(i3);
            objArr[5] = Integer.valueOf(i4);
            objArr[6] = Integer.valueOf(this.lwD.lwj);
            objArr[7] = Integer.valueOf(this.lwD.lwk);
            objArr[8] = Integer.valueOf(this.lwD.lwl);
            objArr[9] = Integer.valueOf(this.lwD.lwi);
            objArr[10] = Integer.valueOf(this.lwD.lwm);
            objArr[11] = Integer.valueOf(this.lwD.lwn);
            objArr[12] = Integer.valueOf(this.lwD.lwo);
            objArr[13] = Integer.valueOf(this.lwD.lwp);
            objArr[14] = Integer.valueOf(this.lwD.lwq);
            objArr[15] = Integer.valueOf(this.lwD.lwr);
            objArr[16] = Integer.valueOf(this.lwD.lws);
            objArr[17] = Integer.valueOf(this.lwD.lwt);
            objArr[18] = Integer.valueOf(this.lwD.lwu);
            objArr[19] = Integer.valueOf(this.lwD.luI);
            objArr[20] = Integer.valueOf(this.lwD.lwv);
            objArr[21] = Integer.valueOf(this.lwD.lww);
            objArr[22] = Integer.valueOf(this.lwD.lwz);
            objArr[23] = Integer.valueOf(longValue);
            objArr[24] = Integer.valueOf(longValue2);
            objArr[25] = this.appId;
            gVar.i(14006, objArr);
        }
    }

    public final void aP(String str, int i) {
        long j = -1;
        int i2 = 1;
        if (this.lwG == -1 || this.lwH == -1 || this.lwH < this.lwG) {
            w.e("MicroMsg.FaceDetectReporter", "alvinluo not set calledStartTime:%d or calledEndTime: %d, total time is not valid", new Object[]{Long.valueOf(this.lwG), Long.valueOf(this.lwH)});
        } else {
            j = this.lwH - this.lwG;
        }
        w.i("MicroMsg.FaceDetectReporter", "alvinluo report face detect interface called result, sessionId: %d, functionName: %s, interfaceType: %d, businessType: %d, totalTime: %d, isSuccess: %b, appId: %s, faceDetectCount: %d", new Object[]{Long.valueOf(this.lwF), str, Integer.valueOf(-1), Integer.valueOf(i), Long.valueOf(j), Boolean.valueOf(this.lwJ), this.appId, Integer.valueOf(this.lwI)});
        g gVar = g.oUh;
        Object[] objArr = new Object[8];
        objArr[0] = Long.valueOf(this.lwF);
        objArr[1] = str;
        objArr[2] = Integer.valueOf(-1);
        objArr[3] = Integer.valueOf(i);
        objArr[4] = this.appId;
        if (!this.lwJ) {
            i2 = 0;
        }
        objArr[5] = Integer.valueOf(i2);
        objArr[6] = Long.valueOf(j);
        objArr[7] = Integer.valueOf(this.lwI);
        gVar.i(14560, objArr);
    }

    public final void o(int i, long j) {
        if (this.lwD != null) {
            FaceDetectReportInfo faceDetectReportInfo = this.lwD;
            faceDetectReportInfo.lwx++;
            faceDetectReportInfo = this.lwD;
            faceDetectReportInfo.lwy = (int) (((long) faceDetectReportInfo.lwy) + j);
            this.lwD.mi(i);
        }
    }

    public final void p(int i, long j) {
        if (this.lwD != null) {
            this.lwD.lwA.put(Integer.valueOf(i), Long.valueOf(j));
        }
    }

    public final void q(int i, long j) {
        if (this.lwD != null) {
            this.lwD.lwB.put(Integer.valueOf(i), Long.valueOf(j));
        }
    }
}
