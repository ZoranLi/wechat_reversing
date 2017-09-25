package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.v4.e.i;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

public final class e {
    private final long asB;
    private final int asC;
    private final i<String, Long> asD;

    public e() {
        this.asB = 60000;
        this.asC = 10;
        this.asD = new i(10);
    }

    public e(long j) {
        this.asB = j;
        this.asC = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        this.asD = new i();
    }

    public final Long Y(String str) {
        Long l;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.asB;
        synchronized (this) {
            long j2 = j;
            while (this.asD.size() >= this.asC) {
                for (int size = this.asD.size() - 1; size >= 0; size--) {
                    if (elapsedRealtime - ((Long) this.asD.valueAt(size)).longValue() > j2) {
                        this.asD.removeAt(size);
                    }
                }
                j = j2 / 2;
                new StringBuilder("The max capacity ").append(this.asC).append(" is not enough. Current durationThreshold is: ").append(j);
                j2 = j;
            }
            l = (Long) this.asD.put(str, Long.valueOf(elapsedRealtime));
        }
        return l;
    }

    public final boolean Z(String str) {
        boolean z;
        synchronized (this) {
            z = this.asD.remove(str) != null;
        }
        return z;
    }
}
