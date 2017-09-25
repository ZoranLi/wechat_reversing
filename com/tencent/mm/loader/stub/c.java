package com.tencent.mm.loader.stub;

import android.content.SharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;

public class c {
    public static c hgw = new c(null);
    public final SharedPreferences hgx;

    public c(SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            this.hgx = ab.getContext().getSharedPreferences(ab.bIX(), 0);
        } else {
            this.hgx = sharedPreferences;
        }
    }

    public final String A(String str, String str2) {
        return this.hgx.getString(str, str2);
    }
}
