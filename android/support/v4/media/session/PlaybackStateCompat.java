package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    public static final Creator<PlaybackStateCompat> CREATOR = new Creator<PlaybackStateCompat>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }
    };
    public final Bundle mExtras;
    public final int mState;
    public final long ve;
    public final long vf;
    public final float vg;
    public final long vh;
    public final CharSequence vi;
    public final long vj;
    public List<CustomAction> vk;
    public final long vl;

    public static final class CustomAction implements Parcelable {
        public static final Creator<CustomAction> CREATOR = new Creator<CustomAction>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new CustomAction[i];
            }
        };
        private final Bundle mExtras;
        private final String vm;
        private final CharSequence vn;
        private final int vo;

        public CustomAction(Parcel parcel) {
            this.vm = parcel.readString();
            this.vn = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.vo = parcel.readInt();
            this.mExtras = parcel.readBundle();
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.vm);
            TextUtils.writeToParcel(this.vn, parcel, i);
            parcel.writeInt(this.vo);
            parcel.writeBundle(this.mExtras);
        }

        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "Action:mName='" + this.vn + ", mIcon=" + this.vo + ", mExtras=" + this.mExtras;
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.mState = parcel.readInt();
        this.ve = parcel.readLong();
        this.vg = parcel.readFloat();
        this.vj = parcel.readLong();
        this.vf = parcel.readLong();
        this.vh = parcel.readLong();
        this.vi = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.vk = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.vl = parcel.readLong();
        this.mExtras = parcel.readBundle();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("PlaybackState {");
        stringBuilder.append("state=").append(this.mState);
        stringBuilder.append(", position=").append(this.ve);
        stringBuilder.append(", buffered position=").append(this.vf);
        stringBuilder.append(", speed=").append(this.vg);
        stringBuilder.append(", updated=").append(this.vj);
        stringBuilder.append(", actions=").append(this.vh);
        stringBuilder.append(", error=").append(this.vi);
        stringBuilder.append(", custom actions=").append(this.vk);
        stringBuilder.append(", active item id=").append(this.vl);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mState);
        parcel.writeLong(this.ve);
        parcel.writeFloat(this.vg);
        parcel.writeLong(this.vj);
        parcel.writeLong(this.vf);
        parcel.writeLong(this.vh);
        TextUtils.writeToParcel(this.vi, parcel, i);
        parcel.writeTypedList(this.vk);
        parcel.writeLong(this.vl);
        parcel.writeBundle(this.mExtras);
    }
}
