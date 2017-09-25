package com.tencent.mm.plugin.fps_lighter.c;

import java.util.ArrayList;
import java.util.List;

public final class c {
    public int hKa;
    public int hXR;
    public List<String> lQC = new ArrayList();
    public List<String> lQD = new ArrayList();
    public long lQE;
    public long lQx;
    public long lQy;

    public c(b bVar) {
        this.lQx = bVar.lQx;
        this.lQy = bVar.lQy;
        this.lQC.add(bVar.jgm);
        this.lQE = bVar.jgm;
        this.lQD.add(bVar.beginTime);
        this.hKa = bVar.hKa;
        this.hXR = 1;
    }

    public final String getKey() {
        return this.lQy + ">" + this.hKa;
    }

    public final String avL() {
        return this.lQx + ">" + (this.hKa - 1);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.lQy);
        stringBuilder.append(" ");
        stringBuilder.append(this.lQE);
        stringBuilder.append(" ");
        stringBuilder.append(this.hKa);
        stringBuilder.append(" ");
        stringBuilder.append(this.hXR);
        stringBuilder.append(" ");
        stringBuilder.append(this.lQx);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
