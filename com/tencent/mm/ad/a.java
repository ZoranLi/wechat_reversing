package com.tencent.mm.ad;

import android.os.Message;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import junit.framework.Assert;

public final class a extends k implements j {
    private au fCZ = new au();
    private e gUD;
    private ae handler = new ae(this) {
        final /* synthetic */ a hAb;

        {
            this.hAb = r1;
        }

        public final void handleMessage(Message message) {
            this.hAb.a(999, 0, 0, "", null, null);
        }
    };

    public a(String str, String str2) {
        boolean z = true;
        this.fCZ.dv(1);
        this.fCZ.cH(str);
        this.fCZ.z(ay.gk(str));
        this.fCZ.dw(1);
        this.fCZ.setContent(str2);
        this.fCZ.setType(o.fG(str));
        ap.yY();
        long L = c.wT().L(this.fCZ);
        if (L == -1) {
            z = false;
        }
        Assert.assertTrue(z);
        w.i("MicroMsg.NetSceneSendMsgFake", "new msg inserted to db , local id = " + L);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        w.i("MicroMsg.NetSceneSendMsgFake", "send local msg, msgId = " + this.fCZ.field_msgId);
        this.handler.sendEmptyMessageDelayed(0, 500);
        return 999;
    }

    public final int getType() {
        return 522;
    }

    protected final int a(p pVar) {
        return b.hsT;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneSendMsgFake", "recv local msg, msgId = " + this.fCZ.field_msgId);
        this.fCZ.dv(2);
        this.fCZ.z(ay.i(this.fCZ.field_talker, System.currentTimeMillis() / 1000));
        ap.yY();
        c.wT().a(this.fCZ.field_msgId, this.fCZ);
        this.gUD.a(0, 0, str, this);
    }
}
