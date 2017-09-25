package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import java.util.Arrays;

public final class WebImage implements SafeParcelable {
    public static final Creator<WebImage> CREATOR = new b();
    final Uri apl;
    final int apm;
    final int apn;
    final int mVersionCode;

    WebImage(int i, Uri uri, int i2, int i3) {
        this.mVersionCode = i;
        this.apl = uri;
        this.apm = i2;
        this.apn = i3;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof WebImage)) {
            return false;
        }
        WebImage webImage = (WebImage) obj;
        return v.d(this.apl, webImage.apl) && this.apm == webImage.apm && this.apn == webImage.apn;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.apl, Integer.valueOf(this.apm), Integer.valueOf(this.apn)});
    }

    public final String toString() {
        return String.format("Image %dx%d %s", new Object[]{Integer.valueOf(this.apm), Integer.valueOf(this.apn), this.apl.toString()});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel, i);
    }
}
