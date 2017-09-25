package com.tencent.mm.p;

import android.os.Looper;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.yh;
import com.tencent.mm.protocal.c.yi;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class g extends k implements j {
    private b gUA;
    private yh gUB;
    yi gUC;
    public e gUD = null;
    d gUE;
    private String gUF = null;
    private ae handler = new ae(Looper.getMainLooper());
    private int retryCount = 0;

    public g(d dVar) {
        if (dVar != null) {
            this.gUE = dVar;
            w.d("MicroMsg.NetSceneGetFuncMsg", "new NetSceneGetFuncMsg, cgi: %s, cmdId: %s, functionMsgId: %s", dVar.field_cgi, Integer.valueOf(dVar.field_cmdid), dVar.field_functionmsgid);
            a aVar = new a();
            aVar.hsm = new yh();
            aVar.hsn = new yi();
            aVar.hsl = 825;
            aVar.uri = dVar.field_cgi;
            aVar.hso = dVar.field_cmdid;
            aVar.hsp = 0;
            this.gUA = aVar.BE();
            this.gUB = (yh) this.gUA.hsj.hsr;
            this.gUB.tEK = dVar.field_functionmsgid;
            if (dVar.field_custombuff != null) {
                this.gUB.tEL = dVar.field_custombuff;
            }
        }
    }

    public final int getType() {
        return 825;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (this.gUE != null) {
            w.i("MicroMsg.NetSceneGetFuncMsg", "doScene, functionMsgId: %s", this.gUE.field_functionmsgid);
            this.gUE.field_status = 1;
        }
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    protected final int ub() {
        return 6;
    }

    protected final int a(p pVar) {
        return b.hsT;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.gUC = (yi) ((b) pVar).hsk.hsr;
        this.gUF = this.gUC.tEL;
        w.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s, opCode: %s, responseCustomBuff==null: %s, response.version: %s", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(this.gUC.tce), Boolean.valueOf(bg.mA(this.gUF)), Long.valueOf(this.gUC.tEM));
        if (!bg.mA(this.gUF)) {
            this.gUB = (yh) this.gUA.hsj.hsr;
            this.gUB.tEL = this.gUF;
        }
        if (i2 == 0 || i3 == 0) {
            com.tencent.mm.plugin.report.service.g.oUh.a((long) this.gUE.field_reportid, (long) this.gUE.field_successkey, 1, false);
            this.gUD.a(i2, i3, str, this);
        } else if (i2 == 4) {
            w.i("MicroMsg.NetSceneGetFuncMsg", "server error");
            if (this.gUC.tce != 1) {
                uc();
                return;
            }
            w.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, stop retry, directly return");
            this.gUD.a(i2, i3, str, this);
        } else {
            w.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, local error");
            com.tencent.mm.plugin.report.service.g.oUh.a((long) this.gUE.field_reportid, (long) this.gUE.field_failkey, 1, false);
            if (this.retryCount < 2) {
                w.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, retry, retryCount: %s", Integer.valueOf(this.retryCount));
                this.retryCount++;
                uc();
                return;
            }
            w.i("MicroMsg.NetSceneGetFuncMsg", "onGYNetEnd, reach retry limit, directly return");
            com.tencent.mm.plugin.report.service.g.oUh.a((long) this.gUE.field_reportid, (long) this.gUE.field_finalfailkey, 1, false);
            this.gUD.a(i2, i3, str, this);
        }
    }

    private void uc() {
        this.handler.postDelayed(new Runnable(this) {
            final /* synthetic */ g gUG;

            {
                this.gUG = r1;
            }

            public final void run() {
                w.i("MicroMsg.NetSceneGetFuncMsg", "do retry");
                if (this.gUG.a(this.gUG.hsD, this.gUG.gUD) == -1) {
                    this.gUG.gUD.a(3, -1, "doScene failed", this.gUG);
                }
            }
        }, (long) (this.gUE.field_retryinterval * 1000));
    }
}
