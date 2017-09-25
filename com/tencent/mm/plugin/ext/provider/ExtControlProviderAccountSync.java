package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.e.a.ex;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtControlProviderAccountSync extends ExtContentProviderBase {
    private static final UriMatcher lqF;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        lqF = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.AccountSync", "accountSync", 1);
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        w.d("MicroMsg.ExtControlAccountSyncProvider", "query()");
        a(uri, getContext(), lqF);
        if (uri == null) {
            md(3);
            return null;
        } else if (bg.mA(this.lqz) || bg.mA(aqX())) {
            md(3);
            return null;
        } else if (!acK()) {
            md(1);
            return this.jPp;
        } else if (bW(getContext())) {
            switch (lqF.match(uri)) {
                case 1:
                    w.i("MicroMsg.ExtControlAccountSyncProvider", "startContactSync()");
                    if (a.urY.m(new ex())) {
                        md(0);
                        return null;
                    }
                    w.e("MicroMsg.ExtControlAccountSyncProvider", "AccountHelper == null");
                    md(4);
                    return null;
                default:
                    md(3);
                    return null;
            }
        } else {
            w.w("MicroMsg.ExtControlAccountSyncProvider", "invalid appid ! return null");
            md(2);
            return null;
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
