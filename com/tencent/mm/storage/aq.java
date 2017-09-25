package com.tencent.mm.storage;

public class aq {
    public final boolean fFU;
    private final String fSe;
    private final String kwE;
    private final String name;
    private final String type;
    private boolean uJP;

    public aq() {
        this.type = "";
        this.name = "";
        this.fSe = "";
        this.kwE = "";
        this.fFU = true;
    }

    public aq(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        this.type = str;
        this.name = str2;
        this.fSe = str3;
        this.kwE = str4;
        this.fFU = z;
        this.uJP = z2;
    }

    public final String getType() {
        return this.type == null ? "" : this.type;
    }

    public final String tK() {
        return this.fSe == null ? "" : this.fSe;
    }

    public final String bLW() {
        return this.kwE == null ? "" : this.kwE;
    }
}
