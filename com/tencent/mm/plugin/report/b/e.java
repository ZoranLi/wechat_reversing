package com.tencent.mm.plugin.report.b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.a.a.g;
import com.tencent.mm.protocal.a.a.i;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.aey;
import com.tencent.mm.protocal.c.ll;
import com.tencent.mm.protocal.c.lm;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.k;
import com.tencent.smtt.utils.TbsLog;

public final class e extends k implements j {
    private boolean fCk = false;
    public int fRr = 0;
    private b gUA;
    private com.tencent.mm.y.e gUD;
    private ll oTr = null;
    private a oTs = new a();

    public e(byte[] bArr, int i) {
        if (bArr == null) {
            throw new NullPointerException("data must not be null");
        }
        this.fRr = i;
        h.vG();
        this.fCk = a.uU();
        if (i == 1) {
            try {
                i iVar = new i();
                iVar.aD(bArr);
                this.oTr = SmcProtoBufUtil.toMMReportKvReq(iVar);
            } catch (Exception e) {
                w.e("MicroMsg.NetSceneCliReportKV", "parse data error");
                h.vJ();
                h.vL().D(new Runnable(this) {
                    final /* synthetic */ e oTt;

                    {
                        this.oTt = r1;
                    }

                    public final void run() {
                        SmcLogic.OnReportResp(3, -1, null, this.oTt.fRr);
                    }
                });
            }
        } else if (i == 2) {
            try {
                g gVar = new g();
                gVar.aD(bArr);
                this.oTr = SmcProtoBufUtil.toMMReportIdkeyReq(gVar);
            } catch (Exception e2) {
                w.e("MicroMsg.NetSceneCliReportKV", "parse data error");
                h.vJ();
                h.vL().D(new Runnable(this) {
                    final /* synthetic */ e oTt;

                    {
                        this.oTt = r1;
                    }

                    public final void run() {
                        SmcLogic.OnReportResp(3, -1, null, this.oTt.fRr);
                    }
                });
            }
        }
        if (this.oTr != null) {
            this.oTr.trJ = new aey();
            this.oTr.trJ.tKh = this.oTs.rW(this.fRr);
            return;
        }
        w.i("MicroMsg.NetSceneCliReportKV", "NetSceneCliReportKV parse req is null, stack[%s]", bg.bJZ());
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (h.vH().gXC == null || h.vH().gXC.hsZ == null) {
            w.f("MicroMsg.NetSceneCliReportKV", "null == MMCore.getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
            this.gUD.a(i2, i3, str, this);
        } else if (i2 != 0) {
            w.e("MicroMsg.NetSceneCliReportKV", "get cli_report_kv strategy err, errType:" + i2 + ", errCode:" + i3);
            SmcLogic.OnReportResp(i2, i3, null, this.fRr);
            this.gUD.a(i2, i3, str, this);
        } else {
            w.d("MicroMsg.NetSceneCliReportKV", "get cli_report_kv strategy ok, channel:" + this.fRr);
            lm lmVar = (lm) this.gUA.hsk.hsr;
            this.oTs.a(lmVar.trT, this.fRr);
            try {
                if (this.fRr == 1) {
                    SmcLogic.OnReportResp(0, 0, SmcProtoBufUtil.toSmcReportKvResp(lmVar).toByteArray(), this.fRr);
                } else if (this.fRr == 2) {
                    SmcLogic.OnReportResp(0, 0, SmcProtoBufUtil.toSmcReportIdkeyResp(lmVar).toByteArray(), this.fRr);
                }
            } catch (Throwable e) {
                w.e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), bg.g(e));
            }
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return !this.fCk ? 1 == this.fRr ? TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR : 987 : 1 == this.fRr ? TbsLog.TBSLOG_CODE_SDK_SELF_MODE : 986;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.y.e eVar2) {
        this.gUD = eVar2;
        if (this.oTr == null) {
            w.e("MicroMsg.NetSceneCliReportKV", "do scene but req is null!");
            return -2;
        }
        if (!this.fCk) {
            this.oTr.trI = com.tencent.mm.bd.b.aU(bg.bJQ());
        }
        b.a aVar = new b.a();
        aVar.hsq = false;
        aVar.hsm = this.oTr;
        aVar.hsn = new lm();
        String str = 1 == this.fRr ? "/cgi-bin/micromsg-bin/newreportkvcomm" : "/cgi-bin/micromsg-bin/newreportidkey";
        String str2 = 1 == this.fRr ? "/cgi-bin/micromsg-bin/newreportkvcommrsa" : "/cgi-bin/micromsg-bin/newreportidkeyrsa";
        if (!this.fCk) {
            str = str2;
        }
        aVar.uri = str;
        aVar.hsl = getType();
        this.gUA = aVar.BE();
        if (!this.fCk) {
            this.gUA.a(ac.bHt());
            this.gUA.fYs = 1;
        }
        int a = a(eVar, this.gUA, this);
        if (a >= 0) {
            return a;
        }
        w.i("MicroMsg.NetSceneCliReportKV", "mark all failed. do scene %d", Integer.valueOf(a));
        try {
            SmcLogic.OnReportResp(3, -1, null, this.fRr);
            return a;
        } catch (Throwable e) {
            w.e("MicroMsg.NetSceneCliReportKV", "updateReportStrategy failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), bg.g(e));
            return a;
        }
    }
}
