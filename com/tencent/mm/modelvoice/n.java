package com.tencent.mm.modelvoice;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;

public final class n {
    public String iah;
    public boolean iai;
    public long time;

    public static String b(String str, long j, boolean z) {
        return str + ":" + j + ":" + (z ? 1 : 0) + "\n";
    }

    public n(String str) {
        try {
            int i;
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            String[] split = str.split(":");
            if (split.length == 4 && x.eO(split[0])) {
                i = 1;
            } else {
                i = 0;
            }
            if (split.length > i) {
                this.iah = split[i];
            }
            if (split.length > i + 1) {
                this.time = bg.getLong(split[i + 1], 0);
            }
            if (split.length > i + 2) {
                this.iai = split[i + 2].equals("1");
            }
        } catch (Exception e) {
            if (this.iah == null) {
                this.iah = "";
            }
            this.iai = false;
            this.time = 0;
            w.e("MicroMsg.VoiceContent", "VoiceContent parse failed.");
        }
    }
}
