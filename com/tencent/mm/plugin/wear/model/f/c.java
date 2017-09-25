package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.e.a.sk;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.w;

public abstract class c extends d {
    public abstract void send();

    protected final void execute() {
        if (a.bvG().rTo.bvL()) {
            b skVar = new sk();
            skVar.gac.fEG = 11;
            com.tencent.mm.sdk.b.a.urY.m(skVar);
            send();
            return;
        }
        w.i("MicroMsg.WearBaseSendTask", "can not send message to wear");
    }
}
