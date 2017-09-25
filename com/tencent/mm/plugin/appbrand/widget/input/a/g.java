package com.tencent.mm.plugin.appbrand.widget.input.a;

import com.tencent.mm.plugin.appbrand.widget.input.y;

public enum g {
    LEFT,
    RIGHT,
    CENTER;

    public static g rs(String str) {
        Enum f = d.f(str, g.class);
        g gVar = LEFT;
        if (f != null) {
            Enum enumR = f;
        }
        return gVar;
    }

    public final void a(y yVar) {
        if (yVar != null) {
            switch (this) {
                case LEFT:
                    yVar.Zk();
                    return;
                case RIGHT:
                    yVar.Zl();
                    return;
                case CENTER:
                    yVar.Zm();
                    return;
                default:
                    return;
            }
        }
    }
}
