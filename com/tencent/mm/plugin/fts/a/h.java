package com.tencent.mm.plugin.fts.a;

import android.database.Cursor;
import com.tencent.mm.storage.x;

public interface h {
    Cursor g(String str, String[] strArr);

    Cursor rawQuery(String str, String[] strArr);

    x wU(String str);

    boolean wV(String str);

    long wW(String str);
}
