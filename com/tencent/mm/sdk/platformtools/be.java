package com.tencent.mm.sdk.platformtools;

import android.os.SystemClock;
import java.util.ArrayList;

public final class be {
    private boolean jdz = false;
    private String mTag;
    private String uvQ;
    ArrayList<Long> uvR;
    ArrayList<String> uvS;

    public be(String str, String str2) {
        this.mTag = str;
        this.uvQ = str2;
        if (!this.jdz) {
            if (this.uvR == null) {
                this.uvR = new ArrayList();
                this.uvS = new ArrayList();
            } else {
                this.uvR.clear();
                this.uvS.clear();
            }
            addSplit(null);
        }
    }

    public final void addSplit(String str) {
        if (!this.jdz) {
            this.uvR.add(Long.valueOf(SystemClock.elapsedRealtime()));
            this.uvS.add(str);
        }
    }

    public final void dumpToLog() {
        if (!this.jdz) {
            w.d(this.mTag, this.uvQ + ": begin");
            long longValue = ((Long) this.uvR.get(0)).longValue();
            int i = 1;
            long j = longValue;
            while (i < this.uvR.size()) {
                long longValue2 = ((Long) this.uvR.get(i)).longValue();
                w.d(this.mTag, this.uvQ + ":      " + (longValue2 - ((Long) this.uvR.get(i - 1)).longValue()) + " ms, " + ((String) this.uvS.get(i)));
                i++;
                j = longValue2;
            }
            w.d(this.mTag, this.uvQ + ": end, " + (j - longValue) + " ms");
        }
    }
}
