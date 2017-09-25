package com.tencent.mm.plugin.music.a;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.LinkedList;

public final class a {
    public String album;
    public long hHx;
    public String iMN;
    private int lzi = 0;
    public ArrayList<a> nSl = new ArrayList();
    public LinkedList<Long> nSm = new LinkedList();
    public String nSn;
    public String nSo;
    public String nSp;
    private boolean nSq = false;
    public String title;

    public static final class a {
        public String content;
        public boolean nSr;
        public long timestamp;

        public final String toString() {
            return String.format("[%d %s]", new Object[]{Long.valueOf(this.timestamp), this.content});
        }
    }

    public static String cW(String str, String str2) {
        if (bg.mA(str) || bg.mA(str2)) {
            return str;
        }
        if (str2.length() >= str.length() - 1) {
            return "";
        }
        w.d("MicroMsg.Music.LyricObj", "str[%s] prefix[%s] attr[%s]", new Object[]{str, str2, str.substring(str2.length(), str.length() - 1)});
        return str.substring(str2.length(), str.length() - 1);
    }

    public static long Bp(String str) {
        int i = 0;
        try {
            int i2;
            String[] split = str.split(":");
            int i3 = bg.getInt(split[0], 0);
            if (split.length > 1) {
                String[] split2 = split[1].split("\\.");
                i2 = bg.getInt(split2[0], 0);
                if (split2.length > 1) {
                    i = bg.getInt(split2[1], 0);
                }
            } else {
                i2 = 0;
            }
            return (long) ((i * 10) + ((i2 * 1000) + ((i3 * 60) * 1000)));
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Music.LyricObj", e, "", new Object[0]);
            w.w("MicroMsg.Music.LyricObj", "strToLong error: %s", new Object[]{e.getLocalizedMessage()});
            return 0;
        }
    }

    public final a pY(int i) {
        if (i < 0 || i >= this.nSl.size()) {
            return null;
        }
        return (a) this.nSl.get(i);
    }
}
