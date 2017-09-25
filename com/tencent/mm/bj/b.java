package com.tencent.mm.bj;

import android.database.Cursor;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

final class b {
    private static int index = 0;
    private static boolean on = false;
    private static a uLD = null;
    private static long uLE = 0;
    private static int uLF = 0;

    public static void i(Exception exception) {
        if (on) {
            w.e("MicroMsg.DKTest", "exception:%s", bg.g((Throwable) exception));
        }
    }

    static void begin() {
        if (on) {
            uLD = new a();
            index++;
        }
    }

    private static void i(Cursor cursor) {
        if (on && cursor != null) {
            uLF = cursor.getCount();
            a aVar = new a();
            for (int i = 0; i < uLF; i++) {
                cursor.moveToPosition(i);
            }
            cursor.moveToPosition(-1);
            uLE = aVar.se();
        }
    }

    static void a(String str, Cursor cursor, long j) {
        if (on) {
            String str2 = ("Thread:[" + Thread.currentThread().getId() + "," + Thread.currentThread().getName() + "]") + "[" + index + "][" + uLD.se() + "]";
            if (j != 0) {
                str2 = str2 + "[INTRANS]";
            }
            if (cursor != null) {
                i(cursor);
                str2 = str2 + "[cuCnt:" + uLF + ",cuTime:" + uLE + "]";
            }
            str2 = str2 + "[" + str + "]--";
            w.v("MicroMsg.dbtest", str2 + bg.bJZ());
        }
    }
}
