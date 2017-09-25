package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.backup.h.aa;
import com.tencent.mm.plugin.backup.h.z;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import java.util.LinkedList;

public final class d extends b {
    private e htR;
    private z jHG = new z();
    public aa jHH = new aa();

    public d(String str, long j, long j2, String str2, String str3, LinkedList<String> linkedList, e eVar) {
        w.i("MicroMsg.BackupDataTagScene", "init DataTag, BakChatName:%s, startTime:%d, endTime:%d, mediaIdList size:%d", new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(linkedList.size())});
        this.jHG.jNb = str;
        this.jHG.jOm = j;
        this.jHG.jOn = j2;
        this.jHG.jOo = str2;
        this.jHG.jOp = str3;
        this.jHG.jNT = linkedList;
        this.htR = eVar;
    }

    public final boolean abt() {
        boolean abu = super.abu();
        if (!abu) {
            this.htR.a(1, -2, "doScene failed", this);
        }
        return abu;
    }

    public final int getType() {
        return 15;
    }

    public final a abn() {
        return this.jHH;
    }

    public final a abo() {
        return this.jHG;
    }

    public final void abp() {
        w.i("MicroMsg.BackupDataTagScene", "onSceneEnd");
        e(0, 0, "success");
        this.htR.a(0, 0, "", this);
    }
}
