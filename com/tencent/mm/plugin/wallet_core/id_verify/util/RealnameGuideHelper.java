package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.MMActivity;

public class RealnameGuideHelper implements Parcelable {
    public static final Creator<RealnameGuideHelper> CREATOR = new Creator<RealnameGuideHelper>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new RealnameGuideHelper(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RealnameGuideHelper[i];
        }
    };
    private int hEm;
    private String nnN;
    private String nnO;
    private String nnP = "";
    private String nnQ = "";
    private String nnR = "";
    private boolean rDr = false;

    public RealnameGuideHelper(Parcel parcel) {
        this.nnN = parcel.readString();
        this.nnO = parcel.readString();
        this.nnP = parcel.readString();
        this.nnQ = parcel.readString();
        this.nnR = parcel.readString();
        this.hEm = parcel.readInt();
    }

    public final void a(String str, String str2, String str3, String str4, String str5, int i) {
        this.nnN = str;
        this.nnO = str2;
        this.nnP = str3;
        this.nnQ = str4;
        this.nnR = str5;
        this.hEm = i;
    }

    public final boolean a(MMActivity mMActivity, Bundle bundle, OnClickListener onClickListener) {
        return a(mMActivity, bundle, onClickListener, false);
    }

    public final boolean a(MMActivity mMActivity, Bundle bundle, OnClickListener onClickListener, boolean z) {
        if (!this.rDr) {
            this.rDr = true;
            if ("1".equals(this.nnN)) {
                return a.a(mMActivity, bundle, this.hEm);
            }
            if ("2".equals(this.nnN) && !bg.mA(this.nnR)) {
                return a.a((Activity) mMActivity, this.nnO, this.nnR, this.nnP, this.nnQ, z, onClickListener);
            }
        }
        return false;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.nnN);
        parcel.writeString(this.nnO);
        parcel.writeString(this.nnP);
        parcel.writeString(this.nnQ);
        parcel.writeString(this.nnR);
        parcel.writeInt(this.hEm);
    }
}
