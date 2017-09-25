package com.tencent.mm.modelsns;

public final class d {
    StringBuffer hTH = new StringBuffer();
    StringBuffer hTI = new StringBuffer();
    private int index = 0;

    public final void m(String str, Object obj) {
        this.hTH.append(this.index + " " + str + "->" + obj + "\n");
        this.hTI.append(obj);
        this.index++;
    }

    public final void n(String str, Object obj) {
        this.hTH.append(str + "->" + obj + "\n");
        this.hTI.append(obj);
    }

    public final String toString() {
        return this.hTI.toString();
    }

    public final String JG() {
        this.index = 0;
        this.hTH.append("--end--\n\n");
        return this.hTH.toString();
    }
}
