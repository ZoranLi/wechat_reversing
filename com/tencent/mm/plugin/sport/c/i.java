package com.tencent.mm.plugin.sport.c;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.booter.MMReceivers.a;
import com.tencent.mm.plugin.appbrand.jsapi.cf;
import com.tencent.mm.sdk.platformtools.w;

public final class i implements a {
    public final void onReceive(Context context, Intent intent) {
        w.i("MicroMsg.Sport.SportRebootReceiverImpl", "onReceive, save rebootTime = %d %s", new Object[]{Long.valueOf(r0), k.aq(System.currentTimeMillis())});
        h.H(cf.CTRL_INDEX, r0);
    }
}
