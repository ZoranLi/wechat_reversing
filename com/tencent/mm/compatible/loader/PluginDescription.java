package com.tencent.mm.compatible.loader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.compatible.util.m;
import java.io.Serializable;

public class PluginDescription implements Parcelable, Serializable {
    public static final Creator<PluginDescription> CREATOR = new Creator<PluginDescription>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PluginDescription(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PluginDescription[i];
        }
    };
    public final String fFW;
    public final int gRW;
    public final String name;
    public final int size;
    public final String url;
    public final String version;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.url);
        parcel.writeString(this.fFW);
        parcel.writeString(this.version);
        parcel.writeInt(this.size);
        parcel.writeInt(this.gRW);
    }

    protected PluginDescription(Parcel parcel) {
        this.name = (String) m.aj(parcel.readString());
        this.url = (String) m.aj(parcel.readString());
        this.fFW = (String) m.aj(parcel.readString());
        this.version = (String) m.aj(parcel.readString());
        this.size = parcel.readInt();
        this.gRW = parcel.readInt();
    }

    public String toString() {
        return String.format("PluginDescription = [name=%s, url=%s, md5=%s, version=%s, size=%d, downloadType=%d]", new Object[]{this.name, this.url, this.fFW, this.version, Integer.valueOf(this.size), Integer.valueOf(this.gRW)});
    }
}
