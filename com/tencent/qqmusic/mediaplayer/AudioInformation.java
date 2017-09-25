package com.tencent.qqmusic.mediaplayer;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;

public class AudioInformation implements Parcelable {
    public static final int CBR = 1;
    public static final int CORRECT = 1;
    public static final Creator<AudioInformation> CREATOR = new Creator<AudioInformation>() {
        public final AudioInformation createFromParcel(Parcel parcel) {
            return new AudioInformation(parcel);
        }

        public final AudioInformation[] newArray(int i) {
            return new AudioInformation[i];
        }
    };
    public static final int INCORRECT = 2;
    public static final int VBR_VBRI = 3;
    public static final int VBR_XING = 2;
    private int bitDept = 0;
    private int bitrate;
    private int channels;
    private long duration = 0;
    private int durationIsCorrect = 2;
    private int isCbr = 0;
    private int mAudioTypeValue;
    private long mPlaySample = 0;
    private long sampleRate;

    public AudioInformation(Parcel parcel) {
        readFromParcel(parcel);
    }

    public long getPlaySample() {
        if (this.mPlaySample == 0) {
            this.mPlaySample = this.sampleRate;
        }
        return this.mPlaySample;
    }

    public void setPlaySample(long j) {
        this.mPlaySample = j;
    }

    public boolean durationIsCorrect() {
        return this.durationIsCorrect == 1;
    }

    public boolean isCbr() {
        return this.isCbr == 1;
    }

    public void setCbr(int i) {
        this.isCbr = i;
    }

    public boolean isVbr() {
        return this.isCbr == 2 || this.isCbr == 3;
    }

    public int getVbrType() {
        return this.isCbr;
    }

    public AudioType getAudioType() {
        return AudioFormat.getAudioType(this.mAudioTypeValue);
    }

    public void setAudioType(AudioType audioType) {
        this.mAudioTypeValue = audioType.getValue();
    }

    public int getBitDept() {
        return this.bitDept;
    }

    public void setBitDept(int i) {
        this.bitDept = i;
        if (i >= 3) {
            this.bitDept = 3;
        }
    }

    public long getSampleRate() {
        return this.sampleRate;
    }

    public void setSampleRate(long j) {
        this.sampleRate = j;
    }

    public int getChannels() {
        return this.channels;
    }

    public void setChannels(int i) {
        this.channels = i;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public int getBitrate() {
        return this.bitrate;
    }

    public void setBitrate(int i) {
        this.bitrate = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.sampleRate);
        parcel.writeInt(this.channels);
        parcel.writeLong(this.duration);
        parcel.writeInt(this.bitrate);
        parcel.writeInt(this.bitDept);
        parcel.writeInt(this.mAudioTypeValue);
        parcel.writeLong(this.mPlaySample);
        parcel.writeInt(this.isCbr);
        parcel.writeInt(this.durationIsCorrect);
    }

    public void readFromParcel(Parcel parcel) {
        this.sampleRate = parcel.readLong();
        this.channels = parcel.readInt();
        this.duration = parcel.readLong();
        this.bitrate = parcel.readInt();
        this.bitDept = parcel.readInt();
        this.mAudioTypeValue = parcel.readInt();
        this.mPlaySample = parcel.readLong();
        this.isCbr = parcel.readInt();
        this.durationIsCorrect = parcel.readInt();
    }

    public String toString() {
        return "[ sampleRate = " + this.sampleRate + ",channels = " + this.channels + ",bitrate = " + this.bitrate + ",bitDept = " + this.bitDept + ",isCbr = " + this.isCbr + ",durationIsCorrect = " + this.durationIsCorrect + ",duration = " + this.duration + "]";
    }
}
