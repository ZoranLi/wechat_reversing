package com.tencent.mm.plugin.fts.a.a;

import com.tencent.mm.sdk.platformtools.bg;
import java.util.ArrayList;
import java.util.List;

public abstract class a implements Comparable<a> {
    public boolean il = false;
    private List<a> lZJ;
    public Object lZK;
    public int mPriority = Integer.MAX_VALUE;

    public class a {
        public String lZL;
        final /* synthetic */ a lZM;
        public long timestamp;

        public a(a aVar) {
            this.lZM = aVar;
        }
    }

    public abstract boolean execute();

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.mPriority - ((a) obj).mPriority;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public boolean isCancelled() {
        return this.il;
    }

    public int getId() {
        return -1;
    }

    public final void xa(String str) {
        if (this.lZJ == null) {
            this.lZJ = new ArrayList();
        }
        a aVar = new a(this);
        aVar.lZL = str;
        aVar.timestamp = System.currentTimeMillis();
        this.lZJ.add(aVar);
    }

    public String toString() {
        String name = getName();
        if (bg.mA(name)) {
            Object simpleName = getClass().getSimpleName();
        } else {
            String str = name;
        }
        if (this.lZJ == null || this.lZJ.size() <= 1) {
            return String.format("%s", new Object[]{simpleName});
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i < this.lZJ.size(); i++) {
            a aVar = (a) this.lZJ.get(i - 1);
            a aVar2 = (a) this.lZJ.get(i);
            stringBuffer.append(" ");
            stringBuffer.append(aVar2.lZL);
            stringBuffer.append(" : ");
            stringBuffer.append(aVar2.timestamp - aVar.timestamp);
        }
        return String.format("%s ##### %s", new Object[]{simpleName, stringBuffer.toString()});
    }

    public String getName() {
        return "";
    }
}
