package com.tencent.mm.sandbox.monitor;

import android.os.Build;
import com.tencent.mm.protocal.d;

public final class b {

    static class a {
        public String fEr;
        public final String platform = (d.DEVICE_TYPE + "_" + d.sYN + "_" + Build.CPU_ABI);
        public String tag;
        public long timestamp;
        public boolean upM;
        public String username;

        public a(String str, String str2, long j, String str3, boolean z) {
            this.username = str;
            this.tag = str2;
            this.timestamp = j;
            this.fEr = str3;
            this.upM = false;
            this.upM = z;
        }

        public final String toString() {
            return this.username + "," + this.platform + "," + this.tag + ",time_" + this.timestamp + ",error_" + this.fEr;
        }
    }
}
