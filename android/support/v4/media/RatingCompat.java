package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class RatingCompat implements Parcelable {
    public static final Creator<RatingCompat> CREATOR = new Creator<RatingCompat>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RatingCompat[i];
        }
    };
    private final int uU;
    private final float uV;

    public RatingCompat(int i, float f) {
        this.uU = i;
        this.uV = f;
    }

    public final String toString() {
        return "Rating:style=" + this.uU + " rating=" + (this.uV < 0.0f ? "unrated" : String.valueOf(this.uV));
    }

    public final int describeContents() {
        return this.uU;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.uU);
        parcel.writeFloat(this.uV);
    }
}
