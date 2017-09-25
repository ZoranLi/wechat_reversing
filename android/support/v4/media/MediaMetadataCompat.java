package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.e.a;

public final class MediaMetadataCompat implements Parcelable {
    public static final Creator<MediaMetadataCompat> CREATOR = new Creator<MediaMetadataCompat>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MediaMetadataCompat(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MediaMetadataCompat[i];
        }
    };
    public static final a<String, Integer> uP;
    private static final String[] uQ = new String[]{"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};
    private static final String[] uR = new String[]{"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};
    private static final String[] uS = new String[]{"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"};
    public final Bundle uT;

    static {
        a aVar = new a();
        uP = aVar;
        aVar.put("android.media.metadata.TITLE", Integer.valueOf(1));
        uP.put("android.media.metadata.ARTIST", Integer.valueOf(1));
        uP.put("android.media.metadata.DURATION", Integer.valueOf(0));
        uP.put("android.media.metadata.ALBUM", Integer.valueOf(1));
        uP.put("android.media.metadata.AUTHOR", Integer.valueOf(1));
        uP.put("android.media.metadata.WRITER", Integer.valueOf(1));
        uP.put("android.media.metadata.COMPOSER", Integer.valueOf(1));
        uP.put("android.media.metadata.COMPILATION", Integer.valueOf(1));
        uP.put("android.media.metadata.DATE", Integer.valueOf(1));
        uP.put("android.media.metadata.YEAR", Integer.valueOf(0));
        uP.put("android.media.metadata.GENRE", Integer.valueOf(1));
        uP.put("android.media.metadata.TRACK_NUMBER", Integer.valueOf(0));
        uP.put("android.media.metadata.NUM_TRACKS", Integer.valueOf(0));
        uP.put("android.media.metadata.DISC_NUMBER", Integer.valueOf(0));
        uP.put("android.media.metadata.ALBUM_ARTIST", Integer.valueOf(1));
        uP.put("android.media.metadata.ART", Integer.valueOf(2));
        uP.put("android.media.metadata.ART_URI", Integer.valueOf(1));
        uP.put("android.media.metadata.ALBUM_ART", Integer.valueOf(2));
        uP.put("android.media.metadata.ALBUM_ART_URI", Integer.valueOf(1));
        uP.put("android.media.metadata.USER_RATING", Integer.valueOf(3));
        uP.put("android.media.metadata.RATING", Integer.valueOf(3));
        uP.put("android.media.metadata.DISPLAY_TITLE", Integer.valueOf(1));
        uP.put("android.media.metadata.DISPLAY_SUBTITLE", Integer.valueOf(1));
        uP.put("android.media.metadata.DISPLAY_DESCRIPTION", Integer.valueOf(1));
        uP.put("android.media.metadata.DISPLAY_ICON", Integer.valueOf(2));
        uP.put("android.media.metadata.DISPLAY_ICON_URI", Integer.valueOf(1));
        uP.put("android.media.metadata.MEDIA_ID", Integer.valueOf(1));
    }

    public MediaMetadataCompat(Parcel parcel) {
        this.uT = parcel.readBundle();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.uT);
    }
}
