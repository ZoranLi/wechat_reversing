package com.tencent.mm.plugin.fts;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashSet;
import java.util.Iterator;

public final class a extends CursorWrapper {
    private static HashSet<Cursor> lYd = new HashSet();

    public a(Cursor cursor) {
        super(cursor);
        lYd.add(cursor);
        w.d("MicroMsg.FTS.FTSCursor", "add cursor %d", new Object[]{Integer.valueOf(cursor.hashCode())});
    }

    public final void close() {
        super.close();
        lYd.remove(getWrappedCursor());
        w.d("MicroMsg.FTS.FTSCursor", "remove cursor %d", new Object[]{Integer.valueOf(r0.hashCode())});
    }

    public static final void axA() {
        Iterator it = lYd.iterator();
        while (it.hasNext()) {
            Cursor cursor = (Cursor) it.next();
            if (!cursor.isClosed()) {
                try {
                    cursor.close();
                } catch (Exception e) {
                }
                w.e("MicroMsg.FTS.FTSCursor", "not close cursor!!! %d", new Object[]{Integer.valueOf(cursor.hashCode())});
            }
        }
        lYd.clear();
    }
}
