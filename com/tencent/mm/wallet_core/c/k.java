package com.tencent.mm.wallet_core.c;

import android.os.Bundle;
import com.tencent.mm.network.e;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;

public abstract class k extends com.tencent.mm.y.k implements j {
    public String gWO = "";
    public int hPi = 0;
    private int lau = 0;
    public long lwh = 0;
    private long rPO;
    public Bundle uT;

    public abstract void d(int i, int i2, String str, p pVar);

    public int aHY() {
        return -1;
    }

    public void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        long currentTimeMillis = System.currentTimeMillis() - this.rPO;
        String str2 = "";
        String str3 = "";
        this.lau = aHY();
        long currentTimeMillis2 = System.currentTimeMillis();
        if (this.uT != null) {
            str2 = this.uT.getString("key_TransId");
            str3 = this.uT.getString("key_reqKey");
            if (this.lwh == 0) {
                this.lwh = this.uT.getLong("key_SessionId", 0);
            }
            if (this.hPi == 0) {
                this.hPi = this.uT.getInt("key_scene");
            }
        }
        g.oUh.i(11170, new Object[]{Integer.valueOf(getType()), Integer.valueOf(this.lau), Long.valueOf(currentTimeMillis), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(am.getNetType(ab.getContext())), this.gWO, str2, str3, Long.valueOf(this.lwh), Long.valueOf(currentTimeMillis2)});
        o.a(getType(), aHY(), i2, i3, currentTimeMillis, this.hPi, this.gWO);
        d(i2, i3, str, pVar);
    }

    public final int a(e eVar, p pVar, j jVar) {
        this.rPO = System.currentTimeMillis();
        return super.a(eVar, pVar, jVar);
    }
}
