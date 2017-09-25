package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;

public final class CredentialRequest implements SafeParcelable {
    public static final Creator<CredentialRequest> CREATOR = new c();
    final boolean alk;
    final String[] all;
    final CredentialPickerConfig alm;
    final CredentialPickerConfig aln;
    final int mVersionCode;

    CredentialRequest(int i, boolean z, String[] strArr, CredentialPickerConfig credentialPickerConfig, CredentialPickerConfig credentialPickerConfig2) {
        this.mVersionCode = i;
        this.alk = z;
        this.all = (String[]) w.Z(strArr);
        if (credentialPickerConfig == null) {
            credentialPickerConfig = new a().jb();
        }
        this.alm = credentialPickerConfig;
        if (credentialPickerConfig2 == null) {
            credentialPickerConfig2 = new a().jb();
        }
        this.aln = credentialPickerConfig2;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        c.a(this, parcel, i);
    }
}
