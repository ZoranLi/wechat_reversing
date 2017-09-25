package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.plugin.backup.e.a.c;
import com.tencent.mm.plugin.backup.h.af;
import com.tencent.mm.plugin.backup.h.ag;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.LinkedList;

public final class h extends b {
    private af jHM = new af();
    private ag jHN = new ag();
    private a jHO;

    public interface a {
        void v(LinkedList<Long> linkedList);
    }

    public h(String str, HashMap<Long, c> hashMap, a aVar) {
        this.jHO = aVar;
        this.jHM.jNb = str;
        w.i("MicroMsg.BackupSvrIdScene", "init sessionName:%s", new Object[]{str});
        this.jHM.jOx = new LinkedList();
        this.jHM.jOy = new LinkedList();
        this.jHM.jOz = new LinkedList();
        for (Long l : hashMap.keySet()) {
            c cVar = (c) hashMap.get(l);
            this.jHM.jOx.add(Long.valueOf(cVar.jFH));
            this.jHM.jOy.add(cVar.jFI);
            this.jHM.jOz.add(cVar.fFW);
        }
    }

    public final int getType() {
        return 13;
    }

    public final com.tencent.mm.bd.a abn() {
        return this.jHN;
    }

    public final com.tencent.mm.bd.a abo() {
        return this.jHM;
    }

    public final void abp() {
        w.i("MicroMsg.BackupSvrIdScene", "onSceneEnd");
        e(0, 0, "success");
        this.jHO.v(this.jHN.jOx);
    }
}
