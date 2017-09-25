package com.tencent.mm.pluginsdk.k.a.b;

import com.tencent.mm.pluginsdk.k.a.d.k;
import com.tencent.mm.pluginsdk.k.a.d.q;
import com.tencent.mm.sdk.platformtools.bg;

final class c extends k {
    private final boolean fEH;
    final String fFW;
    final long fileSize;
    volatile boolean rWc;
    volatile byte[] sFF;
    final long sFf;

    private c(String str, int i, String str2, boolean z, long j, String str3, int i2, long j2, int i3, int i4) {
        super(str, i.Mp(str), String.valueOf(i), "CheckResUpdate", str3, "GET", i2, i3, i4);
        this.fFW = str2;
        this.sFf = j;
        this.fEH = z;
        this.fileSize = j2;
    }

    public final boolean bDs() {
        return true;
    }

    public final String getFilePath() {
        return i.Mp(this.sEX);
    }

    public final String Qo() {
        return "CheckResUpdate";
    }

    static c b(q qVar) {
        return new c(qVar.field_urlKey, bg.getInt(qVar.field_fileVersion, 0), qVar.field_md5, bg.mz(qVar.field_groupId2).equals("NewXml"), qVar.field_reportId, qVar.field_url, qVar.field_maxRetryTimes, qVar.field_fileSize, qVar.field_networkType, qVar.field_priority);
    }
}
