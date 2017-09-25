package com.tencent.mm.plugin.notification.c;

import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;

public final class b {
    int currentIndex;
    public ArrayList<Long> oao;

    public b() {
        this.currentIndex = 0;
        this.oao = new ArrayList();
        this.currentIndex = 0;
    }

    public final void cN(long j) {
        w.d("MicroMsg.FailMsglist", "addMsgId:%d, currentIndex:%d, size:%d", new Object[]{Long.valueOf(j), Integer.valueOf(this.currentIndex), Integer.valueOf(this.oao.size())});
        this.oao.add(Long.valueOf(j));
    }

    public final long aPH() {
        long j = -1;
        if (this.oao.size() > 0 && this.currentIndex < this.oao.size()) {
            j = ((Long) this.oao.get(this.currentIndex)).longValue();
        }
        w.d("MicroMsg.FailMsglist", "getNextSendMsgId:%d, currentIndex:%d, msgIdList.size:%d", new Object[]{Long.valueOf(j), Integer.valueOf(this.currentIndex), Integer.valueOf(this.oao.size())});
        this.currentIndex++;
        return j;
    }

    public final boolean cO(long j) {
        return this.oao.contains(Long.valueOf(j));
    }

    public final void clear() {
        this.oao.clear();
        this.currentIndex = 0;
    }

    public final long get(int i) {
        return ((Long) this.oao.get(i)).longValue();
    }

    public final void remove(long j) {
        this.oao.remove(Long.valueOf(j));
    }
}
