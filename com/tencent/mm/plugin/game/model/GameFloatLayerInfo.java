package com.tencent.mm.plugin.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GameFloatLayerInfo implements Parcelable {
    public static final Creator<GameFloatLayerInfo> CREATOR = new Creator<GameFloatLayerInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GameFloatLayerInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GameFloatLayerInfo[i];
        }
    };
    public boolean mpB;
    public int orientation;
    public String url;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.url);
        parcel.writeInt(this.mpB ? 1 : 0);
        parcel.writeInt(this.orientation);
    }

    public GameFloatLayerInfo(Parcel parcel) {
        boolean z = true;
        this.url = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.mpB = z;
        this.orientation = parcel.readInt();
    }
}
