package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public abstract class AppBrandLaunchErrorAction implements Parcelable {
    public static final a CREATOR = new a();
    public final String appId;
    public final int iPk;

    static final class a implements Creator<AppBrandLaunchErrorAction> {
        a() {
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return i(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandLaunchErrorAction[i];
        }

        private static AppBrandLaunchErrorAction i(Parcel parcel) {
            String readString = parcel.readString();
            if (readString == null) {
                return null;
            }
            try {
                return (AppBrandLaunchErrorAction) Class.forName(readString).getDeclaredConstructor(new Class[]{Parcel.class}).newInstance(new Object[]{parcel});
            } catch (Exception e) {
                return null;
            }
        }

        static AppBrandLaunchErrorAction a(String str, int i, h hVar) {
            if (hVar == null || hVar.field_launchAction == null) {
                return null;
            }
            switch (hVar.field_launchAction.tcm) {
                case 2:
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", hVar.field_launchAction.tMy);
                    intent.putExtra("forceHideShare", true);
                    return new AppBrandLaunchErrorActionStartActivity(str, i, "webview", ".ui.tools.WebViewUI", intent);
                case 3:
                    return new AppBrandLaunchErrorActionAlert(str, i, hVar.field_launchAction.tID, hVar.field_launchAction.tMA);
                default:
                    return null;
            }
        }
    }

    public abstract void by(Context context);

    AppBrandLaunchErrorAction(Parcel parcel) {
        this.appId = parcel.readString();
        this.iPk = parcel.readInt();
    }

    AppBrandLaunchErrorAction(String str, int i) {
        this.appId = str;
        this.iPk = i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getClass().getName());
        parcel.writeString(this.appId);
        parcel.writeInt(this.iPk);
    }

    public final int describeContents() {
        return 0;
    }
}
