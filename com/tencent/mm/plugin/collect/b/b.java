package com.tencent.mm.plugin.collect.b;

import java.util.LinkedList;
import java.util.List;

public enum b {
    ;
    
    public List<a> kcI;

    public interface a {
        void b(q qVar);
    }

    private b(String str) {
        this.kcI = new LinkedList();
    }

    public final void a(q qVar) {
        for (a aVar : this.kcI) {
            if (aVar != null) {
                aVar.b(qVar);
            }
        }
    }
}
