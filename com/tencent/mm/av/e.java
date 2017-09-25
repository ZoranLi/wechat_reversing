package com.tencent.mm.av;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class e {
    public static long i(String str, long j) {
        long j2 = 0;
        if (str != null) {
            f la = l.Kx().la(str);
            if (la != null) {
                j2 = la.field_createTime + 1;
            }
        }
        return j2 > j * 1000 ? j2 : j * 1000;
    }

    public static void d(long j, String str) {
        boolean z = false;
        w.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, rowId: %d, talker: %s", Long.valueOf(j), str);
        w.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, delete fconversation, ret = " + l.Ky().c(j, str));
        g Kx = l.Kx();
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.FMessageMsgInfoStorage", "deleteByTalker fail, talker is null");
        } else {
            z = Kx.gUz.eE("fmessage_msginfo", "delete from fmessage_msginfo where talker = '" + bg.my(str) + "'");
        }
        w.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, delete fmsginfo, ret = " + z);
    }
}
