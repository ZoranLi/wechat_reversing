package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.sdk.platformtools.af;
import java.util.HashMap;

public final class v {
    private static v lgQ = null;
    public af laX = new af();
    final HashMap<Long, Integer> lgR = new HashMap();

    private v() {
    }

    public static v apW() {
        if (lgQ == null) {
            lgQ = new v();
        }
        return lgQ;
    }
}
