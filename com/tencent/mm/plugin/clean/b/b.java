package com.tencent.mm.plugin.clean.b;

import java.util.ArrayList;
import java.util.Iterator;

public final class b implements Comparable<b> {
    public long fLh;
    public ArrayList<a> kyt;
    public String username;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        b bVar = (b) obj;
        if (this.fLh < bVar.fLh) {
            return -1;
        }
        return this.fLh > bVar.fLh ? 1 : 0;
    }

    public final boolean ajF() {
        this.fLh = 0;
        Iterator it = this.kyt.iterator();
        while (it.hasNext()) {
            this.fLh += ((a) it.next()).size;
        }
        if (this.kyt.size() == 0) {
            return false;
        }
        return true;
    }
}
