package com.tencent.mm.plugin.v;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class b {
    public static int nOk = 0;
    public static int nOl = 1644429312;
    public static int nOm = 302122240;
    public static int nOn = 50;
    public static int nOo = 20;
    public static int nOp = 100;
    public static int nOq = 3;

    public static void aMq() {
        c dX = com.tencent.mm.u.c.c.Az().dX("100224");
        if (dX.isValid()) {
            Map bKK = dX.bKK();
            nOk = bg.getInt((String) bKK.get("SyncOpen"), 0);
            nOl = bg.getInt((String) bKK.get("WindowsVersion"), 1644429312);
            nOm = bg.getInt((String) bKK.get("MacVersion"), 302122240);
            nOn = bg.getInt((String) bKK.get("MsgSyncSessionCount"), 50);
            nOo = bg.getInt((String) bKK.get("MsgSyncMsgCount"), 20);
            nOp = bg.getInt((String) bKK.get("MsgSyncSessionListCount"), 100);
            nOq = bg.getInt((String) bKK.get("MsgSyncTimeLimit"), 3);
        }
        w.i("MicroMsg.MsgSynchronizeConstants", "initMsgSynchronizeAbtest, SYNC_CLOSE:%d, WINDOWS_VERSION:%d, MAC_VERSION:%d, SESSION_COUNT:%d, MSG_COUNT%d, MSG_LIST_COUNT:%d, TIME_LIMIT:%d", new Object[]{Integer.valueOf(nOk), Integer.valueOf(nOl), Integer.valueOf(nOm), Integer.valueOf(nOn), Integer.valueOf(nOo), Integer.valueOf(nOp), Integer.valueOf(nOq)});
    }
}
