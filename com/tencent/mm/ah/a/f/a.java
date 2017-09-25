package com.tencent.mm.ah.a.f;

import com.tencent.mm.ah.a.a.c;
import com.tencent.mm.ah.a.c.b;
import com.tencent.mm.sdk.platformtools.d;

public final class a implements Runnable {
    private final com.tencent.mm.ah.a.c.a hIA;
    private final b hIB;
    private final com.tencent.mm.ah.a.a.b hIg = this.hJr.hIg;
    private final c hIy;
    private final com.tencent.mm.ah.a.b hJr;
    private final com.tencent.mm.ah.a.c.c hJs;
    private final String url;

    public a(String str, c cVar, com.tencent.mm.ah.a.b bVar, com.tencent.mm.ah.a.c.c cVar2) {
        this.url = str;
        this.hJr = bVar;
        if (cVar == null) {
            this.hIy = this.hIg.hIy;
        } else {
            this.hIy = cVar;
        }
        this.hJs = cVar2;
        if (this.hIy.hIB != null) {
            this.hIB = this.hIy.hIB;
        } else {
            this.hIB = this.hIg.hIB;
        }
        this.hIA = this.hIg.hIA;
    }

    public final void run() {
        com.tencent.mm.ah.a.d.b bVar = new com.tencent.mm.ah.a.d.b();
        bVar = this.hIB.jI(this.url);
        if (bVar == null) {
            this.hJs.a(false, this.hIy.hJm);
        } else if (!(d.decodeByteArray(bVar.data, 10, 10) == null && this.hIy.hJl) && this.hIA.a(this.url, bVar.data, this.hIy)) {
            if (this.hJs != null) {
                this.hJs.a(true, this.hIy.hJm);
            }
        } else if (this.hJs != null) {
            this.hJs.a(false, this.hIy.hJm);
        }
    }
}
