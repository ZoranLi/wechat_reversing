package com.tencent.mm.plugin.scanner.util;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class j {
    public static boolean aZh() {
        c dX = com.tencent.mm.u.c.c.Az().dX("100027");
        if (dX.isValid()) {
            Map bKK = dX.bKK();
            if (bKK == null) {
                w.e("MicroMsg.ScanHistoryUtil", "shouldShowHistoryList args == null");
                return false;
            } else if (bKK.containsKey("showEntrance") && "1".equals(bKK.get("showEntrance"))) {
                return true;
            } else {
                w.e("MicroMsg.ScanHistoryUtil", "not contain the showEntrance key or the value is not 1");
                return false;
            }
        }
        w.e("MicroMsg.ScanHistoryUtil", "shouldShowHistoryList item.isValid is false");
        return false;
    }
}
