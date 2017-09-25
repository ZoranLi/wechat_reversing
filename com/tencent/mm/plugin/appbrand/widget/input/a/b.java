package com.tencent.mm.plugin.appbrand.widget.input.a;

public enum b {
    DONE(6),
    SEARCH(3),
    NEXT(5),
    GO(2),
    SEND(4);
    
    public final int jwN;

    private b(int i) {
        this.jwN = i;
    }

    public static b Zy() {
        return DONE;
    }

    public static b rq(String str) {
        return (b) d.f(str, b.class);
    }
}
