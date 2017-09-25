package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelableVolumeInfo implements Parcelable {
    public static final Creator<ParcelableVolumeInfo> CREATOR = new Creator<ParcelableVolumeInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ParcelableVolumeInfo[i];
        }
    };
    public int uZ;
    public int va;
    public int vb;
    public int vc;
    public int vd;

    public ParcelableVolumeInfo(Parcel parcel) {
        this.uZ = parcel.readInt();
        this.vb = parcel.readInt();
        this.vc = parcel.readInt();
        this.vd = parcel.readInt();
        this.va = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.uZ);
        parcel.writeInt(this.vb);
        parcel.writeInt(this.vc);
        parcel.writeInt(this.vd);
        parcel.writeInt(this.va);
    }
}
