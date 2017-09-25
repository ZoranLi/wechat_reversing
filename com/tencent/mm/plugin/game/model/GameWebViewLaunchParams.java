package com.tencent.mm.plugin.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GameWebViewLaunchParams implements Parcelable {
    public static final Creator<GameWebViewLaunchParams> CREATOR = new Creator<GameWebViewLaunchParams>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GameWebViewLaunchParams(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GameWebViewLaunchParams[i];
        }
    };
    public GameFloatLayerInfo mrA;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mrA, i);
    }

    public GameWebViewLaunchParams(Parcel parcel) {
        this.mrA = (GameFloatLayerInfo) parcel.readParcelable(GameFloatLayerInfo.class.getClassLoader());
    }
}
