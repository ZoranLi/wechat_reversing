package com.tencent.mm.plugin.mmsight;

import com.tencent.mm.sdk.platformtools.w;
import java.util.concurrent.ConcurrentSkipListSet;

public final class c {
    private static ConcurrentSkipListSet<Integer> nAl = new ConcurrentSkipListSet();

    public static synchronized void pw(int i) {
        synchronized (c.class) {
            try {
                w.i("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxing: %s", Integer.valueOf(i));
                nAl.add(Integer.valueOf(i));
            } catch (Exception e) {
                w.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxing error: %s", e.getMessage());
            }
        }
    }

    public static synchronized void py(int i) {
        synchronized (c.class) {
            try {
                w.i("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxingFinish: %s", Integer.valueOf(i));
                nAl.remove(Integer.valueOf(i));
            } catch (Exception e) {
                w.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxingFinish error: %s", e.getMessage());
            }
        }
    }

    public static synchronized boolean pz(int i) {
        boolean contains;
        synchronized (c.class) {
            try {
                contains = nAl.contains(Integer.valueOf(i));
                w.d("MicroMsg.MMSightCaptureVideoRemuxStatus", "isMsgRemuxing: %s, %s", Integer.valueOf(i), Boolean.valueOf(contains));
            } catch (Exception e) {
                w.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "isMsgRemuxing error: %s", e.getMessage());
                contains = false;
            }
        }
        return contains;
    }
}
