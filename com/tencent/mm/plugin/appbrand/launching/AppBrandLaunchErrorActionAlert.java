package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.support.a.a;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.g;

final class AppBrandLaunchErrorActionAlert extends AppBrandLaunchErrorAction {
    final String iZg;
    final String iZh;

    AppBrandLaunchErrorActionAlert(String str, int i, String str2, String str3) {
        super(str, i);
        this.iZg = str2;
        this.iZh = str3;
    }

    @a
    AppBrandLaunchErrorActionAlert(Parcel parcel) {
        super(parcel);
        this.iZg = parcel.readString();
        this.iZh = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.iZg);
        parcel.writeString(this.iZh);
    }

    final void by(Context context) {
        String str = this.iZh;
        String str2 = this.iZg;
        if (context instanceof Activity) {
            g.a(context, str, str2, false, null);
        } else {
            com.tencent.mm.plugin.appbrand.ipc.a.a(null, str, str2, ab.getResources().getString(R.l.dHT), "");
        }
    }
}
