package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CredentialPickerConfig implements SafeParcelable {
    public static final Creator<CredentialPickerConfig> CREATOR = new b();
    final boolean ali;
    final boolean alj;
    final int mVersionCode;

    public static class a {
        public boolean ali = false;
        public boolean alj = true;

        public final CredentialPickerConfig jb() {
            return new CredentialPickerConfig(this);
        }
    }

    CredentialPickerConfig(int i, boolean z, boolean z2) {
        this.mVersionCode = i;
        this.ali = z;
        this.alj = z2;
    }

    public CredentialPickerConfig(a aVar) {
        this(1, aVar.ali, aVar.alj);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel);
    }
}
