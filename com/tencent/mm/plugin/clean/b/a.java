package com.tencent.mm.plugin.clean.b;

import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Calendar;

public final class a {
    public long fEU;
    public String fKz;
    public String filePath;
    public long ian;
    public long size;
    public int type;
    private String userName;

    public a(String str, String str2, int i, String str3, long j, long j2) {
        this.size = (long) e.aN(str2);
        w.v("MicroMsg.AnalyseItem", "add mst %d %d %s %s %d", new Object[]{Long.valueOf(this.size), Integer.valueOf(i), bg.ew(this.size), str3, Long.valueOf(j)});
        this.fKz = str;
        this.type = i;
        this.filePath = str2;
        this.userName = str3;
        this.fEU = j;
        this.ian = j2;
    }

    public final String toString() {
        switch (this.type) {
            case 1:
                return String.format("%-8s    %-10s  %s\r\n", new Object[]{"IMG", bg.ew(this.size), this.filePath});
            case 2:
                return String.format("%-8s    %-10s  %s\r\n", new Object[]{"VOICE", bg.ew(this.size), this.filePath});
            case 3:
                return String.format("%-8s    %-10s  %s\r\n", new Object[]{"VIDEO", bg.ew(this.size), this.filePath});
            case 4:
                return String.format("%-8s    %-10s  %s\r\n", new Object[]{"ATTACH", bg.ew(this.size), this.filePath});
            default:
                return "";
        }
    }

    public final long ajE() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(this.ian);
        return (long) (instance.get(2) + (instance.get(1) * 100));
    }
}
