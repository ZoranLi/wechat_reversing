package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.w;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Credential implements SafeParcelable {
    public static final Creator<Credential> CREATOR = new a();
    public final String ahk;
    public final String ala;
    public final String alb;
    public final Uri alc;
    public final List<IdToken> ald;
    public final String ale;
    public final String alf;
    public final String alg;
    public final String alh;
    public final String mName;
    final int mVersionCode;

    Credential(int i, String str, String str2, String str3, String str4, Uri uri, List<IdToken> list, String str5, String str6, String str7, String str8) {
        this.mVersionCode = i;
        this.ala = str;
        this.alb = str2;
        this.ahk = (String) w.Z(str3);
        this.mName = str4;
        this.alc = uri;
        this.ald = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.ale = str5;
        this.alf = str6;
        this.alg = str7;
        this.alh = str8;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        return TextUtils.equals(this.ahk, credential.ahk) && TextUtils.equals(this.mName, credential.mName) && v.d(this.alc, credential.alc) && TextUtils.equals(this.ale, credential.ale) && TextUtils.equals(this.alf, credential.alf) && TextUtils.equals(this.alg, credential.alg);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.ahk, this.mName, this.alc, this.ale, this.alf, this.alg});
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel, i);
    }
}
