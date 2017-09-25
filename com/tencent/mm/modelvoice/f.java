package com.tencent.mm.modelvoice;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bii;
import com.tencent.mm.protocal.c.bij;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ba;
import com.tencent.mm.u.m;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import junit.framework.Assert;

public final class f extends k implements j {
    private int endFlag;
    public int fEX;
    public String fyF;
    private b gUA;
    public e gUD;
    aj hqQ;
    private int iaP;
    private boolean ibh;
    private int ibl;
    public long ibm;

    public f(String str) {
        this(str, 0);
    }

    public f(String str, int i) {
        boolean z = true;
        this.fEX = 0;
        this.iaP = 0;
        this.ibh = false;
        this.endFlag = 0;
        this.hqQ = new aj(new a(this) {
            final /* synthetic */ f ibn;

            {
                this.ibn = r1;
            }

            public final boolean oQ() {
                p md = q.md(this.ibn.fyF);
                if (md == null || !md.LC()) {
                    w.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + this.ibn.fyF);
                    this.ibn.fEX = g.sb() + 10000;
                    this.ibn.gUD.a(3, -1, "doScene failed", this.ibn);
                    return false;
                }
                if (!(3 == md.status || 8 == md.status)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if ((currentTimeMillis / 1000) - md.ian > 30) {
                        w.e("MicroMsg.NetSceneUploadVoice", "Error ModifyTime in Read file:" + this.ibn.fyF);
                        this.ibn.fEX = g.sb() + 10000;
                        this.ibn.gUD.a(3, -1, "doScene failed", this.ibn);
                        return false;
                    } else if (currentTimeMillis - this.ibn.ibm < 2000) {
                        w.d("MicroMsg.NetSceneUploadVoice", "TimerExpired :" + this.ibn.fyF + " but last send time:" + (currentTimeMillis - this.ibn.ibm));
                        return true;
                    } else {
                        g bd = q.lV(this.ibn.fyF).bd(md.hYV, 6000);
                        w.d("MicroMsg.NetSceneUploadVoice", "pusher doscene:" + this.ibn.fyF + " readByte:" + bd.fAK + " stat:" + md.status);
                        if (bd.fAK < MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                            return true;
                        }
                    }
                }
                if (this.ibn.a(this.ibn.hsD, this.ibn.gUD) != -1) {
                    return false;
                }
                this.ibn.fEX = g.sb() + 10000;
                this.ibn.gUD.a(3, -1, "doScene failed", this.ibn);
                return false;
            }
        }, true);
        if (str == null) {
            z = false;
        }
        Assert.assertTrue(z);
        w.d("MicroMsg.NetSceneUploadVoice", "NetSceneUploadVoice:  file:" + str);
        this.fyF = str;
        this.ibl = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        this.ibh = false;
        if (this.fyF == null) {
            w.e("MicroMsg.NetSceneUploadVoice", "doScene:  filename null!");
            this.fEX = g.sb() + 10000;
            return -1;
        }
        p md = q.md(this.fyF);
        if (md == null || !md.LC()) {
            w.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + this.fyF);
            this.fEX = g.sb() + 10000;
            return -1;
        }
        w.d("MicroMsg.NetSceneUploadVoice", "doScene file:" + this.fyF + " netTimes:" + md.iar);
        if (q.lU(this.fyF)) {
            int i;
            int i2;
            g gVar;
            int format;
            g gVar2 = new g();
            if (md.status == 8) {
                w.v("MicroMsg.NetSceneUploadVoice", this.fyF + " cancelFlag = 1");
                this.endFlag = 0;
                q.ma(md.fyF);
                i = 0;
                i2 = 1;
                gVar = gVar2;
            } else {
                if (md.status == 3) {
                    this.ibh = true;
                }
                b lV = q.lV(this.fyF);
                if (lV == null) {
                    this.fEX = g.sb() + 10000;
                    w.e("MicroMsg.NetSceneUploadVoice", "doScene: fileOp is null, fileName:%s", this.fyF);
                    return -1;
                }
                format = lV.getFormat();
                w.d("MicroMsg.NetSceneUploadVoice", "format " + format);
                g bd = lV.bd(md.hYV, 6000);
                w.d("MicroMsg.NetSceneUploadVoice", "doScene READ file[" + this.fyF + "] read ret:" + bd.ret + " readlen:" + bd.fAK + " newOff:" + bd.iaP + " netOff:" + md.hYV + " line:" + g.sb());
                if (bd.ret < 0) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(111, 241, 1, false);
                    w.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fyF + "] read ret:" + bd.ret + " readlen:" + bd.fAK + " newOff:" + bd.iaP + " netOff:" + md.hYV);
                    q.lA(this.fyF);
                    this.fEX = g.sb() + 10000;
                    return -1;
                }
                this.iaP = bd.iaP;
                if (this.iaP < md.hYV || this.iaP >= 469000) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(111, 240, 1, false);
                    w.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fyF + "] newOff:" + this.iaP + " OldtOff:" + md.hYV);
                    q.lA(this.fyF);
                    this.fEX = g.sb() + 10000;
                    return -1;
                }
                this.endFlag = 0;
                if (bd.fAK != 0 || this.ibh) {
                    if (this.ibh) {
                        if (md.hrs <= 0) {
                            w.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fyF + "] read totalLen:" + md.hrs);
                            q.lA(this.fyF);
                            this.fEX = g.sb() + 10000;
                            return -1;
                        } else if (md.hrs > this.iaP && bd.fAK < 6000) {
                            w.e("MicroMsg.NetSceneUploadVoice", "Err doScene READ file[" + this.fyF + "] readlen:" + bd.fAK + " newOff:" + bd.iaP + " netOff:" + md.hYV + " totalLen:" + md.hrs);
                            q.lA(this.fyF);
                            this.fEX = g.sb() + 10000;
                            return -1;
                        } else if (md.hrs <= this.iaP) {
                            this.endFlag = 1;
                        }
                    }
                    i = format;
                    i2 = 0;
                    gVar = bd;
                } else {
                    w.e("MicroMsg.NetSceneUploadVoice", "doScene:  file:" + this.fyF + " No Data temperature , will be retry");
                    this.fEX = g.sb() + 10000;
                    return -1;
                }
            }
            format = md.icm;
            w.i("MicroMsg.NetSceneUploadVoice", "info.getVoiceLength: %s", Integer.valueOf(format));
            if (format == 0) {
                format = q.me(this.fyF);
                w.i("MicroMsg.NetSceneUploadVoice", "getCurrentRecordFileLen: %s", Integer.valueOf(format));
                if (format < 0) {
                    format = q.gP(this.iaP);
                    w.i("MicroMsg.NetSceneUploadVoice", "fuck getMinTimeByOffset: %s", Integer.valueOf(format));
                }
            }
            int i3 = format;
            b.a aVar = new b.a();
            aVar.hsm = new bii();
            aVar.hsn = new bij();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadvoice";
            aVar.hsl = 127;
            aVar.hso = 19;
            aVar.hsp = 1000000019;
            this.gUA = aVar.BE();
            bii com_tencent_mm_protocal_c_bii = (bii) this.gUA.hsj.hsr;
            com_tencent_mm_protocal_c_bii.mvV = m.xL();
            com_tencent_mm_protocal_c_bii.mvU = md.fSf;
            com_tencent_mm_protocal_c_bii.tll = md.hYV;
            com_tencent_mm_protocal_c_bii.tfU = md.clientId;
            com_tencent_mm_protocal_c_bii.tue = i3;
            com_tencent_mm_protocal_c_bii.tiL = this.endFlag;
            com_tencent_mm_protocal_c_bii.tfk = md.fTQ;
            com_tencent_mm_protocal_c_bii.tuf = i2;
            com_tencent_mm_protocal_c_bii.uhS = this.ibl;
            com_tencent_mm_protocal_c_bii.tfi = ba.zA();
            com_tencent_mm_protocal_c_bii.tfi = com.tencent.mm.h.a.a.qB().p(md.fSf, md.iaq);
            com_tencent_mm_protocal_c_bii.tOZ = i;
            if (i2 != 1) {
                com_tencent_mm_protocal_c_bii.tsk = new avw().z(gVar.buf, gVar.fAK);
                com_tencent_mm_protocal_c_bii.tuc = gVar.fAK;
            } else {
                com_tencent_mm_protocal_c_bii.tsk = new avw().b(com.tencent.mm.bd.b.aU(new byte[1]));
                com_tencent_mm_protocal_c_bii.tuc = 1;
            }
            w.d("MicroMsg.NetSceneUploadVoice", "cancelFlag:" + i2 + " endFlag:" + this.endFlag + " svrId:" + md.fTQ);
            w.v("MicroMsg.NetSceneUploadVoice", "doscene msgId:" + com_tencent_mm_protocal_c_bii.tfk + " user:" + com_tencent_mm_protocal_c_bii.mvU + " offset:" + com_tencent_mm_protocal_c_bii.tll + " dataLen:" + com_tencent_mm_protocal_c_bii.tsk.tZn + " endFlag:" + com_tencent_mm_protocal_c_bii.tiL);
            w.i("MicroMsg.NetSceneUploadVoice", "doScene MsgId:" + md.fTQ + " voiceFormat:" + i + " file:" + this.fyF + " readBytes:" + gVar.fAK + " neTTTOff:" + md.hYV + " neWWWOff:" + this.iaP + " endFlag:" + this.endFlag + " cancelFlag:" + i2 + " status:" + md.status + " voiceLen:" + i3);
            this.ibm = System.currentTimeMillis();
            return a(eVar, this.gUA, this);
        }
        w.e("MicroMsg.NetSceneUploadVoice", "checkVoiceNetTimes Failed file:" + this.fyF);
        q.lA(this.fyF);
        this.fEX = g.sb() + 10000;
        return -1;
    }

    protected final int a(p pVar) {
        bii com_tencent_mm_protocal_c_bii = (bii) ((b) pVar).hsj.hsr;
        w.v("MicroMsg.NetSceneUploadVoice", "check msgId:" + com_tencent_mm_protocal_c_bii.tfk + " offset:" + com_tencent_mm_protocal_c_bii.tll + " dataLen:" + com_tencent_mm_protocal_c_bii.tsk.tZn + " endFlag:" + com_tencent_mm_protocal_c_bii.tiL);
        if ((com_tencent_mm_protocal_c_bii.tfk != 0 || com_tencent_mm_protocal_c_bii.tll == 0) && ((com_tencent_mm_protocal_c_bii.tsk != null && com_tencent_mm_protocal_c_bii.tsk.tZn != 0) || com_tencent_mm_protocal_c_bii.tiL == 1 || com_tencent_mm_protocal_c_bii.tuf == 1)) {
            return b.hsT;
        }
        return b.hsU;
    }

    protected final int ub() {
        return 60;
    }

    public final boolean BJ() {
        boolean BJ = super.BJ();
        if (BJ) {
            com.tencent.mm.plugin.report.service.g.oUh.a(111, 239, 1, false);
        }
        return BJ;
    }

    protected final void a(a aVar) {
        com.tencent.mm.plugin.report.service.g.oUh.a(111, 238, 1, false);
        q.lA(this.fyF);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fyF + " errtype:" + i2 + " errCode:" + i3);
        bii com_tencent_mm_protocal_c_bii = (bii) ((b) pVar).hsj.hsr;
        bij com_tencent_mm_protocal_c_bij = (bij) ((b) pVar).hsk.hsr;
        if (i2 == 4 && i3 == -22) {
            q.lB(this.fyF);
            this.gUD.a(i2, i3, str, this);
        } else if (i2 == 4 && i3 != 0) {
            q.lA(this.fyF);
            com.tencent.mm.plugin.report.service.g.oUh.a(111, 237, 1, false);
            this.gUD.a(i2, i3, str, this);
        } else if (i2 == 0 && i3 == 0) {
            w.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd msgId:" + com_tencent_mm_protocal_c_bij.tfk + " toUser:" + com_tencent_mm_protocal_c_bii.mvU);
            if (com_tencent_mm_protocal_c_bij.tfk > 0 || x.eO(com_tencent_mm_protocal_c_bii.mvU)) {
                w.d("MicroMsg.NetSceneUploadVoice", "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(com_tencent_mm_protocal_c_bij.tfk), Integer.valueOf(r.iiX));
                if (10007 == r.iiW && r.iiX != 0) {
                    com_tencent_mm_protocal_c_bij.tfk = (long) r.iiX;
                    r.iiX = 0;
                }
                int a = q.a(this.fyF, this.iaP, com_tencent_mm_protocal_c_bij.tfk, com_tencent_mm_protocal_c_bij.tfU, this.endFlag, this.ibl);
                w.d("MicroMsg.NetSceneUploadVoice", "dkmsgid onGYNetEnd updateAfterSend:" + a + " file:" + this.fyF + " MsgSvrId:" + com_tencent_mm_protocal_c_bij.tfk + " clientId:" + com_tencent_mm_protocal_c_bij.tfU + " neWWOff:" + this.iaP + " neTTTT:" + com_tencent_mm_protocal_c_bij.tuc + " forwardflag:" + this.ibl);
                if (a < 0) {
                    q.lA(this.fyF);
                    w.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fyF + "UpdateAfterSend Ret:" + a);
                    this.gUD.a(i2, i3, str, this);
                    return;
                } else if (a == 1) {
                    w.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd finish file:" + this.fyF);
                    com.tencent.mm.modelstat.b.hUp.f(((h) com.tencent.mm.kernel.h.h(h.class)).aJX().cA((long) q.md(this.fyF).iaq));
                    this.gUD.a(i2, i3, str, this);
                    return;
                } else {
                    long j = this.ibh ? 0 : 500;
                    w.d("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fyF + " delay:" + j);
                    this.hqQ.v(j, j);
                    return;
                }
            }
            com.tencent.mm.plugin.report.service.g.oUh.a(111, 235, 1, false);
            w.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fyF + " getMsgId:" + com_tencent_mm_protocal_c_bij.tfk + " netoff:" + com_tencent_mm_protocal_c_bij.tll);
            q.lA(this.fyF);
            this.gUD.a(i2, i3, str, this);
        } else {
            com.tencent.mm.plugin.report.service.g.oUh.a(111, 236, 1, false);
            w.e("MicroMsg.NetSceneUploadVoice", "onGYNetEnd file:" + this.fyF + " errType:" + i2 + " errCode:" + i3);
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 127;
    }
}
