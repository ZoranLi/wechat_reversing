package com.tencent.mm.plugin.v;

import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.backup.a.h;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.io.File;

public final class f {
    private static int nOL = 0;
    private static int nOM = 0;

    public static String aMs() {
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        return stringBuilder.append(c.xu()).append("msgsynchronize/syncFile/").toString();
    }

    public static String aMt() {
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        return stringBuilder.append(c.xu()).append("msgsynchronize/").toString();
    }

    public static String aMu() {
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        return stringBuilder.append(c.xu()).append("msgsynchronize.zip").toString();
    }

    public static void aMv() {
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        e.d(new File(stringBuilder.append(c.xv()).append("msgsynchronize/").toString()));
        stringBuilder = new StringBuilder();
        ap.yY();
        e.d(new File(stringBuilder.append(c.xv()).append("msgsynchronize.zip").toString()));
    }

    public static void d(String str, String str2, byte[] bArr) {
        if (TextUtils.isEmpty(str) || bArr == null) {
            w.e("MicroMsg.MsgSynchronizeUtil", "appendFile dir:%s fileName:%s ", new Object[]{str, str2});
            return;
        }
        int i = 3;
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                long ry = h.ry(str + str2);
                File file = new File(str + str2);
                if (file.exists()) {
                    file.length();
                }
                i = e.a(str, str2, bArr);
                long ry2 = h.ry(str + str2);
                if (i != 0 || ry2 < ((long) bArr.length)) {
                    w.e("MicroMsg.MsgSynchronizeUtil", "appendFile retry:%d append:%d  old:%d  new:%d  data:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(ry), Long.valueOf(ry2), Integer.valueOf(bArr.length)});
                    i = i2;
                } else {
                    w.d("MicroMsg.MsgSynchronizeUtil", "appendFile retry:%d append:%d  old:%d  new:%d  data:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(ry), Long.valueOf(ry2), Integer.valueOf(bArr.length)});
                    return;
                }
            }
            return;
        }
    }
}
