package com.tencent.mm.storage;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class aj {
    public String fFW = "-1";
    public String iah;
    public boolean iai;
    public long time;
    public boolean uJp;
    public String uJq = "";

    public static String a(String str, long j, boolean z, String str2, boolean z2, String str3) {
        int i = 1;
        StringBuilder append = new StringBuilder().append(str).append(":").append(j).append(":").append(z ? 1 : 0).append(":").append(str2).append(":").append(str3.replace(":", "*#*")).append(":");
        if (!z2) {
            i = 0;
        }
        return append.append(i).append("\n").toString();
    }

    public final String bLQ() {
        int i = 1;
        StringBuilder append = new StringBuilder().append(this.iah).append(":").append(this.time).append(":").append(this.iai ? 1 : 0).append(":").append(this.fFW).append(":").append(this.uJq).append(":");
        if (!this.uJp) {
            i = 0;
        }
        return append.append(i).append("\n").toString();
    }

    public aj(String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.emoji.EmojiContent", "EmojiContent parse failed. content is null.");
            return;
        }
        try {
            String substring;
            int i;
            if (str.endsWith("\n")) {
                substring = str.substring(0, str.length() - 1);
            } else {
                this.uJq = str.replace(":", "*#*");
                substring = str;
            }
            String[] split = substring.split(":", 6);
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
            if (split.length > i + 3) {
                this.fFW = split[i + 3];
            }
            if (split.length > i + 4) {
                this.uJq = split[i + 4].replace("*#*", ":");
            }
            if (split.length > i + 5) {
                this.uJp = split[i + 5].equals("1");
            }
        } catch (Throwable e) {
            this.time = 0;
            w.e("MicroMsg.emoji.EmojiContent", "EmojiContent parse failed. Content:%s Excpetion:%s", str, bg.g(e));
        }
    }

    public static aj RD(String str) {
        return new aj(str);
    }
}
