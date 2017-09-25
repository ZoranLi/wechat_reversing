package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;

class FaceDetectReportInfo implements Parcelable {
    public static final Creator<FaceDetectReportInfo> CREATOR = new Creator<FaceDetectReportInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FaceDetectReportInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FaceDetectReportInfo[i];
        }
    };
    protected int luI = 0;
    protected HashMap<Integer, Long> lwA = new HashMap();
    protected HashMap<Integer, Long> lwB = new HashMap();
    protected long lwh = 0;
    protected int lwi = 0;
    protected int lwj = 0;
    protected int lwk = 0;
    protected int lwl = 0;
    protected int lwm = 0;
    protected int lwn = 0;
    protected int lwo = 0;
    protected int lwp = 0;
    protected int lwq = 0;
    protected int lwr = 0;
    protected int lws = 0;
    protected int lwt = 0;
    protected int lwu = 0;
    protected int lwv = 0;
    protected int lww = 0;
    protected int lwx = 0;
    protected int lwy = 0;
    protected int lwz = 0;

    protected FaceDetectReportInfo(Parcel parcel) {
        this.lwh = parcel.readLong();
        this.lwi = parcel.readInt();
        this.lwj = parcel.readInt();
        this.lwk = parcel.readInt();
        this.lwl = parcel.readInt();
        this.lwm = parcel.readInt();
        this.lwn = parcel.readInt();
        this.lwo = parcel.readInt();
        this.lwp = parcel.readInt();
        this.lwq = parcel.readInt();
        this.lwr = parcel.readInt();
        this.lws = parcel.readInt();
        this.lwt = parcel.readInt();
        this.lwu = parcel.readInt();
        this.lwv = parcel.readInt();
        this.lww = parcel.readInt();
        this.lwx = parcel.readInt();
        this.luI = parcel.readInt();
        this.lwy = parcel.readInt();
        this.lwz = parcel.readInt();
        try {
            this.lwA = parcel.readHashMap(HashMap.class.getClassLoader());
            this.lwB = parcel.readHashMap(HashMap.class.getClassLoader());
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.FaceDetectReportInfo", e, "", new Object[0]);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.lwh);
        parcel.writeInt(this.lwi);
        parcel.writeInt(this.lwj);
        parcel.writeInt(this.lwk);
        parcel.writeInt(this.lwl);
        parcel.writeInt(this.lwm);
        parcel.writeInt(this.lwn);
        parcel.writeInt(this.lwo);
        parcel.writeInt(this.lwp);
        parcel.writeInt(this.lwq);
        parcel.writeInt(this.lwr);
        parcel.writeInt(this.lws);
        parcel.writeInt(this.lwt);
        parcel.writeInt(this.lwu);
        parcel.writeInt(this.lwv);
        parcel.writeInt(this.lww);
        parcel.writeInt(this.lwx);
        parcel.writeInt(this.luI);
        parcel.writeInt(this.lwy);
        parcel.writeInt(this.lwz);
        parcel.writeMap(this.lwA);
        parcel.writeMap(this.lwB);
    }

    public int describeContents() {
        return 0;
    }

    public final void mi(int i) {
        if (i > 0) {
            if (i == 1) {
                this.lwj++;
            } else if (i == 2) {
                this.lwk++;
            } else {
                this.lwj++;
            }
        } else if (i == 0) {
            this.lwl++;
        } else if (i == -11) {
            this.lwn++;
        } else if (i == -12) {
            this.lwo++;
        } else if (i == -13) {
            this.lwp++;
        } else if (i == -101) {
            this.lwt++;
        } else if (i == -102) {
            this.lwq++;
        } else if (i == -103) {
            this.lwr++;
        } else if (i == -105) {
            this.lws++;
        } else if (i == -106) {
            this.lwm++;
        } else if (i == -107) {
            this.lwu++;
        } else if (i == -108) {
            this.lwv++;
        } else if (i == -109) {
            this.lww++;
        } else {
            this.lwi++;
        }
    }

    public final void reset() {
        this.lwh = 0;
        this.lwj = 0;
        this.lwk = 0;
        this.lwl = 0;
        this.lwi = 0;
        this.lwm = 0;
        this.lwn = 0;
        this.lwo = 0;
        this.lwp = 0;
        this.lwq = 0;
        this.lwr = 0;
        this.lws = 0;
        this.lwt = 0;
        this.lwu = 0;
        this.lwx = 0;
        this.luI = 0;
        this.lwy = 0;
        this.lwz = 0;
        this.lwA.clear();
        this.lwB.clear();
    }

    public String toString() {
        return "detectOk: " + this.lwj + ", motionOk: " + this.lwk + ", noFace: " + this.lwl + ", systemErr: " + this.lwi + ", noLiveFace: " + this.lwm + ", tooDark: " + this.lwn + ", tooLight: " + this.lwo + ", backLight: " + this.lwp + ", tooSmall: " + this.lwq + ", tooBig: " + this.lwr + ", tooActive: " + this.lws + ", poseNotValid: " + this.lwt + ", timeOut: " + this.lwu + ", totalFrame: " + this.lwx + ", verifyTime: " + this.luI + ", processTimePerFrame: " + this.lwz;
    }
}
