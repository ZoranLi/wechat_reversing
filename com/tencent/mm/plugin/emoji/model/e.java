package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.protocal.c.pc;
import com.tencent.mm.protocal.c.pe;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.a.a;
import java.util.ArrayList;
import java.util.List;

public final class e {
    public int kLL;
    public List<f> kLM;
    public pc kLN;
    public List<pc> kLO;
    public List<pe> kLP;
    public List<pe> kLQ;

    public final void lp(int i) {
        this.kLL += i;
    }

    public final void alS() {
        if (this.kLQ != null && this.kLQ != null && !this.kLQ.isEmpty()) {
            List arrayList = new ArrayList();
            arrayList.addAll(this.kLQ);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                this.kLM.add(0, new f((pe) arrayList.get(size)));
                this.kLL++;
                this.kLQ.remove(arrayList.get(size));
            }
        }
    }

    public final void al(List<f> list) {
        if (this.kLM == null) {
            this.kLM = new ArrayList();
        } else {
            int size = this.kLM.size() - 1;
            if (size >= 0 && size < this.kLM.size()) {
                f fVar = (f) this.kLM.get(size);
                if (!(fVar == null || fVar.kJb == null || bg.mA(fVar.kJb.tgW) || !fVar.kJb.tgW.equals(a.uKQ))) {
                    this.kLM.remove(fVar);
                }
            }
        }
        this.kLM.addAll(list);
    }
}
