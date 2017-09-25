package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Creator<MediaDescriptionCompat> CREATOR = new Creator<MediaDescriptionCompat>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return VERSION.SDK_INT < 21 ? new MediaDescriptionCompat(parcel) : MediaDescriptionCompat.f(MediaDescription.CREATOR.createFromParcel(parcel));
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    };
    private final Bundle mExtras;
    private final String uH;
    private final CharSequence uI;
    private final CharSequence uJ;
    private final CharSequence uK;
    private final Bitmap uL;
    private final Uri uM;
    private final Uri uN;
    private Object uO;

    public static final class a {
        Bundle mExtras;
        String uH;
        CharSequence uI;
        CharSequence uJ;
        CharSequence uK;
        Bitmap uL;
        Uri uM;
        Uri uN;
    }

    private MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.uH = str;
        this.uI = charSequence;
        this.uJ = charSequence2;
        this.uK = charSequence3;
        this.uL = bitmap;
        this.uM = uri;
        this.mExtras = bundle;
        this.uN = uri2;
    }

    public MediaDescriptionCompat(Parcel parcel) {
        this.uH = parcel.readString();
        this.uI = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.uJ = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.uK = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.uL = (Bitmap) parcel.readParcelable(null);
        this.uM = (Uri) parcel.readParcelable(null);
        this.mExtras = parcel.readBundle();
        this.uN = (Uri) parcel.readParcelable(null);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (VERSION.SDK_INT < 21) {
            parcel.writeString(this.uH);
            TextUtils.writeToParcel(this.uI, parcel, i);
            TextUtils.writeToParcel(this.uJ, parcel, i);
            TextUtils.writeToParcel(this.uK, parcel, i);
            parcel.writeParcelable(this.uL, i);
            parcel.writeParcelable(this.uM, i);
            parcel.writeBundle(this.mExtras);
            parcel.writeParcelable(this.uN, i);
            return;
        }
        Object obj;
        if (this.uO != null || VERSION.SDK_INT < 21) {
            obj = this.uO;
        } else {
            Bundle bundle;
            Builder builder = new Builder();
            builder.setMediaId(this.uH);
            builder.setTitle(this.uI);
            builder.setSubtitle(this.uJ);
            builder.setDescription(this.uK);
            builder.setIconBitmap(this.uL);
            builder.setIconUri(this.uM);
            Bundle bundle2 = this.mExtras;
            if (VERSION.SDK_INT >= 23 || this.uN == null) {
                bundle = bundle2;
            } else {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                    bundle2.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
                }
                bundle2.putParcelable("android.support.v4.media.description.MEDIA_URI", this.uN);
                bundle = bundle2;
            }
            builder.setExtras(bundle);
            if (VERSION.SDK_INT >= 23) {
                builder.setMediaUri(this.uN);
            }
            this.uO = builder.build();
            obj = this.uO;
        }
        ((MediaDescription) obj).writeToParcel(parcel, i);
    }

    public final String toString() {
        return this.uI + ", " + this.uJ + ", " + this.uK;
    }

    public static MediaDescriptionCompat f(Object obj) {
        if (obj == null || VERSION.SDK_INT < 21) {
            return null;
        }
        Uri uri;
        Bundle bundle;
        MediaDescriptionCompat mediaDescriptionCompat;
        a aVar = new a();
        aVar.uH = ((MediaDescription) obj).getMediaId();
        aVar.uI = ((MediaDescription) obj).getTitle();
        aVar.uJ = ((MediaDescription) obj).getSubtitle();
        aVar.uK = ((MediaDescription) obj).getDescription();
        aVar.uL = ((MediaDescription) obj).getIconBitmap();
        aVar.uM = ((MediaDescription) obj).getIconUri();
        Bundle extras = ((MediaDescription) obj).getExtras();
        if (extras == null) {
            uri = null;
        } else {
            uri = (Uri) extras.getParcelable("android.support.v4.media.description.MEDIA_URI");
        }
        if (uri != null) {
            if (extras.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && extras.size() == 2) {
                bundle = null;
                aVar.mExtras = bundle;
                if (uri != null) {
                    aVar.uN = uri;
                } else if (VERSION.SDK_INT >= 23) {
                    aVar.uN = ((MediaDescription) obj).getMediaUri();
                }
                mediaDescriptionCompat = new MediaDescriptionCompat(aVar.uH, aVar.uI, aVar.uJ, aVar.uK, aVar.uL, aVar.uM, aVar.mExtras, aVar.uN);
                mediaDescriptionCompat.uO = obj;
                return mediaDescriptionCompat;
            }
            extras.remove("android.support.v4.media.description.MEDIA_URI");
            extras.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
        }
        bundle = extras;
        aVar.mExtras = bundle;
        if (uri != null) {
            aVar.uN = uri;
        } else if (VERSION.SDK_INT >= 23) {
            aVar.uN = ((MediaDescription) obj).getMediaUri();
        }
        mediaDescriptionCompat = new MediaDescriptionCompat(aVar.uH, aVar.uI, aVar.uJ, aVar.uK, aVar.uL, aVar.uM, aVar.mExtras, aVar.uN);
        mediaDescriptionCompat.uO = obj;
        return mediaDescriptionCompat;
    }
}
