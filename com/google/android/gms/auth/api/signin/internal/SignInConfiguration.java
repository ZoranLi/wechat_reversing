package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.EmailSignInConfig;
import com.google.android.gms.auth.api.signin.FacebookSignInConfig;
import com.google.android.gms.auth.api.signin.GoogleSignInConfig;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;

public final class SignInConfiguration implements SafeParcelable {
    public static final Creator<SignInConfiguration> CREATOR = new a();
    final String alS;
    String alT;
    EmailSignInConfig alU;
    GoogleSignInConfig alV;
    FacebookSignInConfig alW;
    String alX;
    final int versionCode;

    SignInConfiguration(int i, String str, String str2, EmailSignInConfig emailSignInConfig, GoogleSignInConfig googleSignInConfig, FacebookSignInConfig facebookSignInConfig, String str3) {
        this.versionCode = i;
        this.alS = w.U(str);
        this.alT = str2;
        this.alU = emailSignInConfig;
        this.alV = googleSignInConfig;
        this.alW = facebookSignInConfig;
        this.alX = str3;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel, i);
    }
}
