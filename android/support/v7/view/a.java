package android.support.v7.view;

import android.content.Context;
import android.support.v7.a.a.b;

public final class a {
    public Context mContext;

    public static a n(Context context) {
        return new a(context);
    }

    private a(Context context) {
        this.mContext = context;
    }

    public final boolean de() {
        if (this.mContext.getApplicationInfo().targetSdkVersion >= 16) {
            return this.mContext.getResources().getBoolean(b.IL);
        }
        return this.mContext.getResources().getBoolean(b.IM);
    }

    public final boolean df() {
        return this.mContext.getApplicationInfo().targetSdkVersion < 14;
    }
}
