package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.backup.h.i;
import com.tencent.mm.plugin.backup.h.j;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;
import java.util.LinkedList;

public final class f extends b {
    private i jHI = new i();
    public j jHJ = new j();

    public f(LinkedList<String> linkedList, long j, long j2) {
        w.i("MicroMsg.BackupRequestSessionScene", "init sessionName[%d], startTime[%d], endTime[%d]", new Object[]{Integer.valueOf(linkedList.size()), Long.valueOf(j), Long.valueOf(j2)});
        this.jHI.jNf = linkedList;
        this.jHI.jNg = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            it.next();
            this.jHI.jNg.add(Long.valueOf(j));
            this.jHI.jNg.add(Long.valueOf(j2));
        }
    }

    public final int getType() {
        return 11;
    }

    public final a abn() {
        return this.jHJ;
    }

    public final a abo() {
        return this.jHI;
    }

    public final void abp() {
        if (this.jHJ.jNf == null || this.jHJ.jNg == null || this.jHJ.jNf.isEmpty() || this.jHJ.jNf.size() * 2 != this.jHJ.jNg.size()) {
            if (!(this.jHJ.jNf == null || this.jHJ.jNg == null)) {
                w.e("MicroMsg.BackupRequestSessionScene", "onSceneEnd sessionName and TimeInterval size error. sessionName size[%d], timeInterval size[%d]", new Object[]{Integer.valueOf(this.jHJ.jNf.size()), Integer.valueOf(this.jHJ.jNg.size())});
            }
            e(4, -1, "BackupRequestSession failed");
            return;
        }
        w.i("MicroMsg.BackupRequestSessionScene", "onSceneEnd sessionName size[%d], name:%s", new Object[]{Integer.valueOf(this.jHJ.jNf.size()), this.jHJ.jNf.toString()});
        w.i("MicroMsg.BackupRequestSessionScene", "onSceneEnd requestsession resp, TimeInterval:%s", new Object[]{this.jHJ.jNg.toString()});
        e(0, 0, "BackupRequestSession success");
    }
}
