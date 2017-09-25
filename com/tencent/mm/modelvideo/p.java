package com.tencent.mm.modelvideo;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class p {
    public String iah;
    private boolean iai;
    private long time;

    public static String b(String str, long j, boolean z) {
        return str + ":" + j + ":" + (z ? 1 : 0) + "\n";
    }

    public p(String str) {
        if (str.endsWith("\n")) {
            str = str.substring(0, str.length() - 1);
        }
        String[] split = str.split(":");
        try {
            if (split.length > 0) {
                this.iah = split[0];
            }
            if (split.length > 1) {
                this.time = bg.getLong(split[1], 0);
            }
            if (split.length > 2) {
                this.iai = split[2].equals("1");
            }
        } catch (Exception e) {
            if (this.iah == null) {
                this.iah = "";
            }
            this.iai = false;
            this.time = 0;
            w.e("MicroMsg.VideoContent", "VoiceContent parse failed.");
        }
    }
}
