package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.internal.a;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.c.ae;
import com.google.android.gms.c.ag;
import com.google.android.gms.c.h;

public class c extends ag<c> {
    public final q ajB;
    public boolean akJ;

    public c(q qVar) {
        super(qVar.ih(), qVar.ahZ);
        this.ajB = qVar;
    }

    protected final void a(ae aeVar) {
        h hVar = (h) aeVar.b(h.class);
        if (TextUtils.isEmpty(hVar.aiI)) {
            hVar.aiI = this.ajB.il().iF();
        }
        if (this.akJ && TextUtils.isEmpty(hVar.ayP)) {
            q qVar = this.ajB;
            q.a(qVar.aiB);
            a aVar = qVar.aiB;
            hVar.ayP = aVar.hw();
            hVar.ayQ = aVar.hv();
        }
    }

    public final ae iZ() {
        ae lb = lc().lb();
        q qVar = this.ajB;
        q.a(qVar.aiC);
        lb.b(qVar.aiC.iv());
        lb.b(this.ajB.aiD.iW());
        le();
        return lb;
    }
}
