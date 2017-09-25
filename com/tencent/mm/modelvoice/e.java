package com.tencent.mm.modelvoice;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.on;
import com.tencent.mm.protocal.c.oo;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ai;
import com.tencent.mm.u.o;
import com.tencent.mm.y.b;
import com.tencent.mm.y.k;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class e extends k implements j {
    private static ai ibf = null;
    private static List<c> ibg = new ArrayList();
    public int fEX = 0;
    private String fSf;
    public String fyF;
    private b gUA;
    public com.tencent.mm.y.e gUD;
    private aj hqQ = new aj(new a(this) {
        final /* synthetic */ e ibk;

        {
            this.ibk = r1;
        }

        public final boolean oQ() {
            if (this.ibk.a(this.ibk.hsD, this.ibk.gUD) == -1) {
                this.ibk.gUD.a(3, -1, "doScene failed", this.ibk);
            }
            return false;
        }
    }, false);
    private String ibe;
    private boolean ibh = false;
    private boolean ibi = false;

    public static void a(ai aiVar) {
        if (ibf == null) {
            ibf = aiVar;
        }
    }

    public static void a(c cVar) {
        if (!ibg.contains(cVar)) {
            ibg.add(cVar);
        }
    }

    public static void b(c cVar) {
        ibg.remove(cVar);
    }

    private void doNotify() {
        final au mc = q.mc(this.fyF);
        if (mc != null) {
            if (ibf != null) {
                ibf.a(mc);
            }
            for (final c cVar : ibg) {
                af.v(new Runnable(this) {
                    final /* synthetic */ e ibk;

                    public final void run() {
                        cVar.A(mc);
                    }
                });
            }
        }
    }

    public e(p pVar) {
        boolean z;
        Assert.assertTrue(pVar != null);
        this.fyF = pVar.fyF;
        if (this.fyF != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        this.ibe = pVar.ibe;
        this.fSf = pVar.fSf;
        w.i("MicroMsg.NetSceneDownloadVoice", "NetSceneDownloadVoice:  file[%s] voiceFormat[%s] user[%s]", this.fyF, this.ibe, this.fSf);
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.y.e eVar2) {
        this.gUD = eVar2;
        if (this.fyF == null) {
            w.e("MicroMsg.NetSceneDownloadVoice", "doScene:  filename null!");
            this.fEX = g.sb() + 10000;
            return -1;
        }
        p md = q.md(this.fyF);
        if (md == null || !md.LB()) {
            w.e("MicroMsg.NetSceneDownloadVoice", "Get info Failed file:" + this.fyF);
            this.fEX = g.sb() + 10000;
            return -1;
        }
        w.i("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fyF + " netTimes:" + md.iar);
        if (q.lU(this.fyF)) {
            int i = md.hYV - md.iaj;
            if (i > 0) {
                if (md.hrs == md.hYV) {
                    this.ibh = true;
                }
                b.a aVar = new b.a();
                aVar.hsm = new on();
                aVar.hsn = new oo();
                aVar.uri = "/cgi-bin/micromsg-bin/downloadvoice";
                aVar.hsl = FileUtils.S_IWUSR;
                aVar.hso = 20;
                aVar.hsp = 1000000020;
                this.gUA = aVar.BE();
                on onVar = (on) this.gUA.hsj.hsr;
                onVar.tfU = md.clientId;
                onVar.tfk = md.fTQ;
                onVar.tuc = i;
                onVar.tll = md.iaj;
                if (o.dH(this.fSf)) {
                    onVar.ttq = this.fSf;
                    onVar.tud = md.icn;
                }
                w.i("MicroMsg.NetSceneDownloadVoice", "doScene req.ClientMsgId:%s req.MsgId:%d req.NewMsgId:%d, req.Length:%d req.Offset:%d req.ChatRoomName:%s req.MasterBufId %d", onVar.tfU, Integer.valueOf(onVar.tfc), Long.valueOf(onVar.tfk), Integer.valueOf(onVar.tuc), Integer.valueOf(onVar.tll), onVar.ttq, Long.valueOf(onVar.tud));
                return a(eVar, this.gUA, this);
            } else if (md.status == 5) {
                this.ibi = true;
                w.e("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fyF + " Net:" + md.hYV + " Local:" + md.iaj);
                this.fEX = g.sb() + 10000;
                return -1;
            } else {
                q.a(this.fyF, md.iaj, null);
                this.fEX = g.sb() + 10000;
                return -1;
            }
        }
        w.e("MicroMsg.NetSceneDownloadVoice", "checkVoiceNetTimes Failed file:" + this.fyF);
        q.lA(this.fyF);
        this.fEX = g.sb() + 10000;
        return -1;
    }

    protected final int a(p pVar) {
        on onVar = (on) ((b) pVar).hsj.hsr;
        if (onVar.tfk != 0 && onVar.tfU != null && onVar.tfU.length() != 0 && onVar.tuc > 0 && onVar.tll >= 0) {
            return b.hsT;
        }
        q.lA(this.fyF);
        return b.hsU;
    }

    protected final int ub() {
        return 100;
    }

    protected final void a(a aVar) {
        com.tencent.mm.plugin.report.service.g.oUh.a(111, 233, 1, false);
        q.lA(this.fyF);
    }

    public final boolean BJ() {
        boolean BJ = super.BJ();
        if (BJ) {
            com.tencent.mm.plugin.report.service.g.oUh.a(111, 232, 1, false);
        }
        return BJ;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fyF + " + id:" + i + " errtype:" + i2 + " errCode:" + i3);
        oo ooVar = (oo) ((b) pVar).hsk.hsr;
        if (ooVar.tuf == 1) {
            w.v("MicroMsg.NetSceneDownloadVoice", this.fyF + " cancelFlag = 1");
            q.lZ(this.fyF);
        } else if (i3 == -22) {
            q.lA(this.fyF);
            this.gUD.a(i2, i3, str, this);
        } else if (i2 == 4 && i3 != 0) {
            com.tencent.mm.plugin.report.service.g.oUh.a(111, 231, 1, false);
            q.lA(this.fyF);
            this.gUD.a(i2, i3, str, this);
        } else if (i2 == 0 && i3 == 0) {
            w.d("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fyF + " Recv:" + ooVar.tsk.tZn + " fileOff:" + ooVar.tll);
            if (ooVar.tsk.tZp == null) {
                w.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd get recv Buffer null");
                q.lA(this.fyF);
                this.gUD.a(i2, i3, str, this);
                return;
            }
            byte[] toByteArray = ooVar.tsk.tZp.toByteArray();
            if (toByteArray.length == 0) {
                w.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Recv Buf ZERO length ");
                q.lA(this.fyF);
                this.gUD.a(i2, i3, str, this);
                return;
            }
            int write = q.an(this.ibe, this.fyF).write(toByteArray, toByteArray.length, ooVar.tll);
            if (write < 0) {
                w.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Write Failed File:" + this.fyF + " ret:" + write);
                q.lA(this.fyF);
                this.gUD.a(i2, i3, str, this);
                return;
            }
            w.i("MicroMsg.NetSceneDownloadVoice", "OnRecvEnd : file:" + this.fyF + " filesize:" + write + " voiceFormat:" + this.ibe);
            write = q.a(this.fyF, write, null);
            if (write < 0) {
                com.tencent.mm.plugin.report.service.g.oUh.a(111, 229, 1, false);
                w.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fyF + "updateAfterRecv Ret:" + write);
                this.gUD.a(i2, i3, str, this);
            } else if (write == 1) {
                doNotify();
                this.gUD.a(i2, i3, str, this);
            } else {
                long j = 1000;
                if (this.ibh) {
                    j = 0;
                }
                this.hqQ.v(j, j);
            }
        } else {
            com.tencent.mm.plugin.report.service.g.oUh.a(111, 230, 1, false);
            w.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " resp:" + pVar.zg().sZC);
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return FileUtils.S_IWUSR;
    }
}
