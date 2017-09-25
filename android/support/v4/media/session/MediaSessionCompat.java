package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;

public final class MediaSessionCompat {

    public static final class QueueItem implements Parcelable {
        public static final Creator<QueueItem> CREATOR = new Creator<QueueItem>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new QueueItem[i];
            }
        };
        private final long uW;
        private final MediaDescriptionCompat ug;

        public QueueItem(Parcel parcel) {
            this.ug = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.uW = parcel.readLong();
        }

        public final void writeToParcel(Parcel parcel, int i) {
            this.ug.writeToParcel(parcel, i);
            parcel.writeLong(this.uW);
        }

        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "MediaSession.QueueItem {Description=" + this.ug + ", Id=" + this.uW + " }";
        }
    }

    static final class ResultReceiverWrapper implements Parcelable {
        public static final Creator<ResultReceiverWrapper> CREATOR = new Creator<ResultReceiverWrapper>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ResultReceiverWrapper[i];
            }
        };
        public ResultReceiver uX;

        ResultReceiverWrapper(Parcel parcel) {
            this.uX = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            this.uX.writeToParcel(parcel, i);
        }
    }

    public static final class Token implements Parcelable {
        public static final Creator<Token> CREATOR = new Creator<Token>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new Token(VERSION.SDK_INT >= 21 ? parcel.readParcelable(null) : parcel.readStrongBinder());
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new Token[i];
            }
        };
        private final Object uY;

        Token(Object obj) {
            this.uY = obj;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            if (VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.uY, i);
            } else {
                parcel.writeStrongBinder((IBinder) this.uY);
            }
        }
    }
}
