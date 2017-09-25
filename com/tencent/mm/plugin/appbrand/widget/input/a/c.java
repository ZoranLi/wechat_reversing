package com.tencent.mm.plugin.appbrand.widget.input.a;

public enum c {
    NORMAL(0),
    BOLD(1);
    
    public final int style;

    private c(int i) {
        this.style = i;
    }

    public static c rr(String str) {
        Enum f = d.f(str, c.class);
        c cVar = NORMAL;
        if (f != null) {
            Enum enumR = f;
        }
        return cVar;
    }
}
