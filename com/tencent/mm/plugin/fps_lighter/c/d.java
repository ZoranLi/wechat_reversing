package com.tencent.mm.plugin.fps_lighter.c;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public final class d {
    public int hKa;
    public int hXR;
    public List<String> lQC;
    public List<String> lQD;
    public long lQE;
    public a lQF;
    public Stack<Long> lQG = new Stack();
    public long lQv;
    public boolean lQw;
    public long lQx;
    public long lQy;

    public d(a aVar, c cVar) {
        this.lQC = cVar.lQC;
        this.lQD = cVar.lQD;
        this.lQx = cVar.lQx;
        this.lQy = cVar.lQy;
        this.lQE = cVar.lQE;
        this.hKa = cVar.hKa;
        this.hXR = cVar.hXR;
        this.lQF = aVar;
        this.lQv = aVar.lQv;
        this.lQw = aVar.lQw;
    }

    public final void cl(long j) {
        this.lQG.push(Long.valueOf(j));
    }

    public final void a(Stack<Long> stack) {
        this.lQG.clear();
        Iterator it = stack.iterator();
        while (it.hasNext()) {
            this.lQG.push(Long.valueOf(((Long) it.next()).longValue()));
        }
    }

    public final String avM() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.lQy);
        stringBuilder.append(" > ");
        ListIterator listIterator = this.lQG.listIterator(this.lQG.size());
        while (listIterator.hasPrevious()) {
            stringBuilder.append(listIterator.previous());
            stringBuilder.append(" > ");
        }
        stringBuilder.delete(stringBuilder.length() - 3, stringBuilder.length());
        return stringBuilder.toString();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(36);
        stringBuilder.append("\t");
        stringBuilder.append("scene:");
        stringBuilder.append(this.lQF.scene);
        stringBuilder.append(" ");
        stringBuilder.append("preMs:");
        stringBuilder.append(this.lQF.lQq);
        stringBuilder.append(" ");
        stringBuilder.append("dropCount:");
        stringBuilder.append(this.lQF.lQs);
        stringBuilder.append(" ");
        stringBuilder.append("dropTime:");
        stringBuilder.append(this.lQF.avK());
        stringBuilder.append(" ");
        stringBuilder.append("cpu:");
        stringBuilder.append(this.lQF.lQt + "%");
        stringBuilder.append(" ");
        stringBuilder.append("isOnCreate:");
        stringBuilder.append(this.lQF.lQr);
        stringBuilder.append(" ");
        stringBuilder.append("methodId:");
        stringBuilder.append(this.lQy);
        stringBuilder.append(" ");
        stringBuilder.append("costTime:");
        stringBuilder.append(this.lQE);
        stringBuilder.append(" ");
        stringBuilder.append("percent:");
        stringBuilder.append(Math.round(((((double) this.lQE) * 1.0d) / ((double) this.lQF.avK())) * 100.0d) + "%");
        stringBuilder.append(" ");
        stringBuilder.append("exec num:");
        stringBuilder.append(this.hXR);
        stringBuilder.append(" ");
        stringBuilder.append("inputHandlingTime:");
        stringBuilder.append(this.lQv);
        stringBuilder.append(" ");
        stringBuilder.append("isInputHandling:");
        stringBuilder.append(this.lQw);
        stringBuilder.append(" ");
        stringBuilder.append("stack:");
        stringBuilder.append(avM());
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (dVar.lQy == this.lQy && this.lQG.size() == dVar.lQG.size()) {
                int i = 0;
                while (i < this.lQG.size() && this.lQG.elementAt(i) == dVar.lQG.elementAt(i)) {
                    i++;
                }
            }
        }
        return false;
    }
}
