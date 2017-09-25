package com.tencent.mm.plugin.base.stub;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.sdk.platformtools.w;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class MMPluginProvider extends ContentProvider {
    private static final UriMatcher jPb;
    private c jPa = new c();

    protected static abstract class a {
        private Context context = null;

        protected a() {
        }

        public boolean bI(Context context) {
            this.context = context;
            return true;
        }
    }

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        jPb = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.sdk.plugin.provider", "sharedpref", 2);
    }

    public String getType(Uri uri) {
        switch (jPb.match(uri)) {
        }
        return null;
    }

    public boolean onCreate() {
        this.jPa.bI(getContext());
        return true;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        w.v("MicroMsg.MMPluginProvider", "plugin insert" + uri);
        switch (jPb.match(uri)) {
            case 2:
                return c.acE();
            default:
                w.e("MicroMsg.MMPluginProvider", "Unknown URI " + uri);
                return null;
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        w.v("MicroMsg.MMPluginProvider", "plugin delete" + uri);
        switch (jPb.match(uri)) {
            case 2:
                return c.acF();
            default:
                w.e("MicroMsg.MMPluginProvider", "Unknown URI " + uri);
                return 0;
        }
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        w.i("MicroMsg.MMPluginProvider", "plugin query" + uri);
        switch (jPb.match(uri)) {
            case 2:
                return c.a(strArr, strArr2);
            default:
                w.e("MicroMsg.MMPluginProvider", "Unknown URI " + uri);
                return null;
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        w.d("MicroMsg.MMPluginProvider", "plugin update" + uri);
        switch (jPb.match(uri)) {
            case 2:
                return c.acG();
            default:
                w.e("MicroMsg.MMPluginProvider", "Unknown URI " + uri);
                return 0;
        }
    }
}
