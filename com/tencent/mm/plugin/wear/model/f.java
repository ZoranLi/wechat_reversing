package com.tencent.mm.plugin.wear.model;

public final class f {
    public String fFW = "";
    public String fJL = "";
    public int id = 0;
    public int rTW = 0;
    a rTX;

    public enum a {
        rTY,
        SHOWING,
        IGNORE,
        REPLY
    }

    protected final Object clone() {
        f fVar = new f();
        fVar.id = this.id;
        fVar.fJL = this.fJL;
        fVar.fFW = this.fFW;
        fVar.rTW = this.rTW;
        fVar.rTX = this.rTX;
        return fVar;
    }

    public final String toString() {
        return "WearNotification [talker=" + this.fJL + ", id=" + this.id + ", md5=" + this.fFW + ", ignoreInWatch=" + this.rTW + ", status=" + this.rTX + "]";
    }
}
