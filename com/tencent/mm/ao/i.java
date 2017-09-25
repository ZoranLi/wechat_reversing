package com.tencent.mm.ao;

import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.aih;
import com.tencent.mm.protocal.c.aii;
import java.util.LinkedList;
import java.util.List;

@Deprecated
public final class i extends b {
    private aii hNB;

    public static class a {
        aih hNC;
        private int key;
        private String value;

        public a() {
            this.key = 0;
            this.value = "";
            this.hNC = new aih();
            this.hNC.oTD = 0;
            this.hNC.oTN = "";
        }

        public a(int i, String str) {
            this.key = i;
            this.value = str;
            this.hNC = new aih();
            this.hNC.oTD = i;
            this.hNC.oTN = str;
        }
    }

    public i(List<a> list) {
        super(36);
        LinkedList linkedList = new LinkedList();
        for (a aVar : list) {
            linkedList.add(aVar.hNC);
        }
        this.hNB = new aii();
        this.hNB.jNd = list.size();
        this.hNB.jNe = linkedList;
        this.nyY = this.hNB;
    }
}
