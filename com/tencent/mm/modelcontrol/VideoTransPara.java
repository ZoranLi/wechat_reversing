package com.tencent.mm.modelcontrol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class VideoTransPara implements Parcelable {
    public static final Creator<VideoTransPara> CREATOR = new Creator<VideoTransPara>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new VideoTransPara(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new VideoTransPara[i];
        }
    };
    public int audioSampleRate;
    public int duration;
    public int gPE;
    public int height;
    public int hzL;
    public int hzM;
    public int hzN;
    public int hzO;
    public int hzY;
    public int hzZ = 0;
    public boolean isDefault;
    public int width;

    protected VideoTransPara(Parcel parcel) {
        boolean z = false;
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.gPE = parcel.readInt();
        this.hzY = parcel.readInt();
        this.duration = parcel.readInt();
        this.hzM = parcel.readInt();
        this.hzL = parcel.readInt();
        this.audioSampleRate = parcel.readInt();
        this.hzN = parcel.readInt();
        this.hzO = parcel.readInt();
        if (parcel.readInt() > 0) {
            z = true;
        }
        this.isDefault = z;
        this.hzZ = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.gPE);
        parcel.writeInt(this.hzY);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.hzM);
        parcel.writeInt(this.hzL);
        parcel.writeInt(this.audioSampleRate);
        parcel.writeInt(this.hzN);
        parcel.writeInt(this.hzO);
        parcel.writeInt(this.isDefault ? 1 : 0);
        parcel.writeInt(this.hzZ);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "[isDefault " + this.isDefault + "width " + this.width + " height " + this.height + " fps " + this.gPE + " video bitrate " + this.hzY + " iFrame " + this.hzM + " audio bitrate " + this.hzL + " audioSampleRate " + this.audioSampleRate + " duration " + this.duration + " profile index " + this.hzN + " preset index " + this.hzO + " thumbSize " + this.hzZ + "]";
    }
}
