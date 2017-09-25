package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.support.a.a;
import com.tencent.mm.bb.d;
import com.tencent.wcdb.database.SQLiteDatabase;

final class AppBrandLaunchErrorActionStartActivity extends AppBrandLaunchErrorAction {
    final String iZi;
    final String iZj;
    final Intent iZk;

    AppBrandLaunchErrorActionStartActivity(String str, int i, String str2, String str3, Intent intent) {
        super(str, i);
        this.iZi = str2;
        this.iZj = str3;
        this.iZk = intent;
    }

    @a
    AppBrandLaunchErrorActionStartActivity(Parcel parcel) {
        super(parcel);
        this.iZi = parcel.readString();
        this.iZj = parcel.readString();
        this.iZk = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.iZi);
        parcel.writeString(this.iZj);
        parcel.writeParcelable(this.iZk, 0);
    }

    final void by(Context context) {
        Intent intent = this.iZk;
        if (context instanceof Activity) {
            intent.setFlags(intent.getFlags() & -268435457);
        } else {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        d.b(context, this.iZi, this.iZj, intent);
    }
}
