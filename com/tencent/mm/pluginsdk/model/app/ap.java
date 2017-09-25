package com.tencent.mm.pluginsdk.model.app;

import android.net.Uri;

public final class ap {
    public static ap sEE = null;
    public static long sEF = -1;
    public int code = -1;
    public String[] projection = null;
    public String sEC = "";
    public String[] sED = null;
    public String selection = "";
    public String[] selectionArgs = null;
    public Uri uri = null;

    public ap(Uri uri, String[] strArr, String str, String[] strArr2, String str2, int i, String[] strArr3) {
        this.uri = uri;
        this.projection = strArr;
        this.selection = str;
        this.selectionArgs = strArr2;
        this.sEC = str2;
        this.code = i;
        this.sED = strArr3;
    }
}
