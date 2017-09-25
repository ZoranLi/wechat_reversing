package com.google.android.gms.common.internal;

import android.content.Intent;
import android.net.Uri;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.wcdb.database.SQLiteGlobal;

public final class o {
    private static final Uri arh;
    private static final Uri ari;

    static {
        Uri parse = Uri.parse("http://plus.google.com/");
        arh = parse;
        ari = parse.buildUpon().appendPath("circles").appendPath("find").build();
    }

    public static Intent S(String str) {
        Uri fromParts = Uri.fromParts("package", str, null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(fromParts);
        return intent;
    }

    public static Intent T(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details").buildUpon().appendQueryParameter(SlookAirButtonFrequentContactAdapter.ID, str).build());
        intent.setPackage("com.android.vending");
        intent.addFlags(SQLiteGlobal.journalSizeLimit);
        return intent;
    }

    public static Intent kf() {
        Intent intent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
        intent.setPackage("com.google.android.wearable.app");
        return intent;
    }
}
