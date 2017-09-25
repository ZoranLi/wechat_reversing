package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bii;
import com.tencent.mm.protocal.c.bij;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import junit.framework.Assert;

public final class b extends k implements j {
    private int endFlag = 0;
    public int fEX = 0;
    public String fyF;
    private com.tencent.mm.y.b gUA;
    public e gUD;
    aj hqQ = new aj(new a(this) {
        final /* synthetic */ b qSU;

        {
            this.qSU = r1;
        }

        public final boolean oQ() {
            g Hl = h.Hl(this.qSU.fyF);
            if (Hl == null || !Hl.LC()) {
                w.e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + this.qSU.fyF);
                this.qSU.fEX = g.sb() + 10000;
                this.qSU.gUD.a(3, -1, "doScene failed", this.qSU);
                return false;
            }
            if (!(3 == Hl.field_status || 8 == Hl.field_status)) {
                long currentTimeMillis = System.currentTimeMillis();
                if ((currentTimeMillis / 1000) - Hl.field_lastmodifytime > 30) {
                    w.e("MicroMsg.NetSceneUploadVoiceRemind", "Error ModifyTime in Read file:" + this.qSU.fyF);
                    this.qSU.fEX = g.sb() + 10000;
                    this.qSU.gUD.a(3, -1, "doScene failed", this.qSU);
                    return false;
                } else if (currentTimeMillis - this.qSU.ibm < 2000) {
                    w.d("MicroMsg.NetSceneUploadVoiceRemind", "TimerExpired :" + this.qSU.fyF + " but last send time:" + (currentTimeMillis - this.qSU.ibm));
                    return true;
                } else {
                    c.a uv = h.Hm(this.qSU.fyF).uv(Hl.field_offset);
                    w.d("MicroMsg.NetSceneUploadVoiceRemind", "pusher doscene:" + this.qSU.fyF + " readByte:" + uv.fAK + " stat:" + Hl.field_status);
                    if (uv.fAK < MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                        return true;
                    }
                }
            }
            if (this.qSU.a(this.qSU.hsD, this.qSU.gUD) != -1) {
                return false;
            }
            this.qSU.fEX = g.sb() + 10000;
            this.qSU.gUD.a(3, -1, "doScene failed", this.qSU);
            return false;
        }
    }, true);
    private int iaP = 0;
    private boolean ibh = false;
    public long ibm;

    public b(String str) {
        boolean z = true;
        if (str == null) {
            z = false;
        }
        Assert.assertTrue(z);
        w.d("MicroMsg.NetSceneUploadVoiceRemind", "NetSceneUploadVoice:  file:" + str);
        this.fyF = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        this.ibh = false;
        if (this.fyF == null) {
            w.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  filename null!");
            this.fEX = g.sb() + 10000;
            return -1;
        }
        g Hl = h.Hl(this.fyF);
        if (Hl == null || !Hl.LC()) {
            w.e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + this.fyF);
            this.fEX = g.sb() + 10000;
            return -1;
        }
        boolean z;
        w.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene file:" + this.fyF + " netTimes:" + Hl.field_nettimes);
        String str = this.fyF;
        if (str == null) {
            z = false;
        } else {
            g Hl2 = h.Hl(str);
            if (Hl2 == null) {
                z = false;
            } else if (Hl2.field_nettimes >= 80) {
                z = false;
            } else {
                Hl2.field_nettimes++;
                Hl2.fRW = 16384;
                z = h.a(Hl2);
            }
        }
        if (z) {
            c.a aVar;
            int i;
            int i2;
            c.a aVar2 = new c.a();
            if (Hl.field_status == 8) {
                w.v("MicroMsg.NetSceneUploadVoiceRemind", this.fyF + " cancelFlag = 1");
                this.endFlag = 1;
                h.ma(Hl.field_filename);
                aVar = aVar2;
                i = 1;
            } else {
                if (Hl.field_status == 3) {
                    this.ibh = true;
                }
                c Hm = h.Hm(this.fyF);
                if (Hm == null) {
                    this.fEX = g.sb() + 10000;
                    return -1;
                }
                aVar2 = Hm.uv(Hl.field_offset);
                w.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene READ file[" + this.fyF + "] read ret:" + aVar2.ret + " readlen:" + aVar2.fAK + " newOff:" + aVar2.iaP + " netOff:" + Hl.field_offset + " line:" + g.sb());
                if (aVar2.ret < 0) {
                    w.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fyF + "] read ret:" + aVar2.ret + " readlen:" + aVar2.fAK + " newOff:" + aVar2.iaP + " netOff:" + Hl.field_offset);
                    h.lA(this.fyF);
                    this.fEX = g.sb() + 10000;
                    return -1;
                }
                this.iaP = aVar2.iaP;
                if (this.iaP < Hl.field_offset || this.iaP >= 469000) {
                    w.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fyF + "] newOff:" + this.iaP + " OldtOff:" + Hl.field_offset);
                    h.lA(this.fyF);
                    this.fEX = g.sb() + 10000;
                    return -1;
                }
                this.endFlag = 0;
                if (aVar2.fAK != 0 || this.ibh) {
                    if (this.ibh) {
                        if (Hl.field_totallen <= 0) {
                            w.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fyF + "] read totalLen:" + Hl.field_totallen);
                            h.lA(this.fyF);
                            this.fEX = g.sb() + 10000;
                            return -1;
                        } else if (Hl.field_totallen > this.iaP && aVar2.fAK < 6000) {
                            w.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fyF + "] readlen:" + aVar2.fAK + " newOff:" + aVar2.iaP + " netOff:" + Hl.field_offset + " totalLen:" + Hl.field_totallen);
                            h.lA(this.fyF);
                            this.fEX = g.sb() + 10000;
                            return -1;
                        } else if (Hl.field_totallen <= this.iaP) {
                            this.endFlag = 1;
                        }
                    }
                    aVar = aVar2;
                    i = 0;
                } else {
                    w.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  file:" + this.fyF + " No Data temperature , will be retry");
                    h.lA(this.fyF);
                    this.fEX = g.sb() + 10000;
                    return -1;
                }
            }
            int i3 = Hl.field_voicelenght;
            if (i3 == 0) {
                i2 = ((this.iaP - 6) / 32) * 20;
            } else {
                i2 = i3;
            }
            w.d("MicroMsg.NetSceneUploadVoiceRemind", "info.getMsgSvrId() " + Hl.field_msgid);
            com.tencent.mm.y.b.a aVar3 = new com.tencent.mm.y.b.a();
            aVar3.hsm = new bii();
            aVar3.hsn = new bij();
            aVar3.uri = "/cgi-bin/micromsg-bin/uploadvoicerecognize";
            aVar3.hsl = 329;
            aVar3.hso = 157;
            aVar3.hsp = 1000000157;
            this.gUA = aVar3.BE();
            bii com_tencent_mm_protocal_c_bii = (bii) this.gUA.hsj.hsr;
            com_tencent_mm_protocal_c_bii.mvV = m.xL();
            com_tencent_mm_protocal_c_bii.mvU = Hl.field_user;
            com_tencent_mm_protocal_c_bii.tll = Hl.field_offset;
            com_tencent_mm_protocal_c_bii.tfU = Hl.field_clientid;
            com_tencent_mm_protocal_c_bii.tue = i2;
            com_tencent_mm_protocal_c_bii.tiL = this.endFlag;
            com_tencent_mm_protocal_c_bii.tfk = Hl.field_msgid;
            com_tencent_mm_protocal_c_bii.tuf = i;
            com_tencent_mm_protocal_c_bii.uhR = (int) (Hl.field_createtime / 1000);
            com_tencent_mm_protocal_c_bii.tOZ = 1;
            if (i != 1) {
                com_tencent_mm_protocal_c_bii.tsk = new avw().z(aVar.buf, aVar.fAK);
                com_tencent_mm_protocal_c_bii.tuc = aVar.fAK;
            } else {
                com_tencent_mm_protocal_c_bii.tsk = new avw().b(com.tencent.mm.bd.b.aU(new byte[1]));
                com_tencent_mm_protocal_c_bii.tuc = 1;
            }
            w.v("MicroMsg.NetSceneUploadVoiceRemind", "cancelFlag:" + i + " endFlag:" + this.endFlag + " svrId:" + Hl.field_msgid);
            w.v("MicroMsg.NetSceneUploadVoiceRemind", "doscene msgId:" + com_tencent_mm_protocal_c_bii.tfk + " user:" + com_tencent_mm_protocal_c_bii.mvU + " offset:" + com_tencent_mm_protocal_c_bii.tll + " dataLen:" + com_tencent_mm_protocal_c_bii.tsk.tZn + " endFlag:" + com_tencent_mm_protocal_c_bii.tiL);
            w.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene MsgId:" + Hl.field_msgid + " file:" + this.fyF + " readBytes:" + aVar.fAK + " neTTTOff:" + Hl.field_offset + " neWWWOff:" + this.iaP + " endFlag:" + this.endFlag + " cancelFlag:" + i + " status:" + Hl.field_status);
            w.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log " + com_tencent_mm_protocal_c_bii.toString());
            this.ibm = System.currentTimeMillis();
            return a(eVar, this.gUA, this);
        }
        w.e("MicroMsg.NetSceneUploadVoiceRemind", "checkVoiceNetTimes Failed file:" + this.fyF);
        h.lA(this.fyF);
        this.fEX = g.sb() + 10000;
        return -1;
    }

    protected final int a(p pVar) {
        bii com_tencent_mm_protocal_c_bii = (bii) ((com.tencent.mm.y.b) pVar).hsj.hsr;
        w.v("MicroMsg.NetSceneUploadVoiceRemind", "check : offset:" + com_tencent_mm_protocal_c_bii.tll + " dataLen:" + com_tencent_mm_protocal_c_bii.tsk.tZn + " endFlag:" + com_tencent_mm_protocal_c_bii.tiL);
        return b.hsT;
    }

    protected final int ub() {
        return 240;
    }

    protected final void a(a aVar) {
        h.lA(this.fyF);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fyF + " errtype:" + i2 + " errCode:" + i3);
        bii com_tencent_mm_protocal_c_bii = (bii) ((com.tencent.mm.y.b) pVar).hsj.hsr;
        bij com_tencent_mm_protocal_c_bij = (bij) ((com.tencent.mm.y.b) pVar).hsk.hsr;
        w.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log resp " + com_tencent_mm_protocal_c_bij.toString());
        if (i2 == 4 && i3 == -22) {
            g Hl = h.Hl(this.fyF);
            if (Hl != null) {
                if (Hl.field_status == 3) {
                    ap.yY();
                    au cA = c.wT().cA((long) Hl.field_msglocalid);
                    cA.setContent(f.b(Hl.field_human, (long) Hl.field_voicelenght, false));
                    cA.dv(2);
                    ap.yY();
                    c.wT().a((long) Hl.field_msglocalid, cA);
                }
                Hl.field_status = 97;
                Hl.field_lastmodifytime = System.currentTimeMillis() / 1000;
                Hl.fRW = 320;
                h.a(Hl);
            }
            this.gUD.a(i2, i3, str, this);
        } else if (i2 == 4 && i3 != 0) {
            h.lA(this.fyF);
            this.gUD.a(i2, i3, str, this);
        } else if (i2 == 0 && i3 == 0) {
            int i4;
            w.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd msgId:" + com_tencent_mm_protocal_c_bij.tfk + " toUser:" + com_tencent_mm_protocal_c_bii.mvU);
            String str2 = this.fyF;
            int i5 = this.iaP;
            long j = com_tencent_mm_protocal_c_bij.tfk;
            String str3 = com_tencent_mm_protocal_c_bij.tfU;
            int i6 = this.endFlag;
            if (str2 == null) {
                i4 = -1;
            } else {
                w.d("MicroMsg.VoiceRemindLogic", "UpdateAfterSend file:[" + str2 + "] newOff:" + i5 + " SvrID:" + j + " clientID:" + str3 + " hasSendEndFlag " + i6);
                g Hl2 = h.Hl(str2);
                if (Hl2 == null) {
                    i4 = -1;
                } else {
                    Hl2.field_offset = i5;
                    Hl2.field_lastmodifytime = System.currentTimeMillis() / 1000;
                    Hl2.fRW = 264;
                    if (bg.mA(Hl2.field_clientid) && str3 != null) {
                        Hl2.field_clientid = str3;
                        Hl2.fRW |= 512;
                    }
                    if (Hl2.field_msgid == 0 && j != 0) {
                        Hl2.field_msgid = j;
                        Hl2.fRW |= 4;
                    }
                    i4 = 0;
                    w.d("MicroMsg.VoiceRemindLogic", "info.getTotalLen() " + Hl2.field_totallen + "  newOffset " + i5 + "  " + Hl2.field_status);
                    if (Hl2.field_totallen <= i5 && Hl2.field_status == 3 && i6 == 1) {
                        Hl2.field_status = 99;
                        Hl2.fRW |= 64;
                        ap.yY();
                        au cA2 = c.wT().cA((long) Hl2.field_msglocalid);
                        cA2.cH(Hl2.field_user);
                        cA2.y(Hl2.field_msgid);
                        cA2.dv(2);
                        cA2.setContent(f.b(Hl2.field_human, (long) Hl2.field_voicelenght, false));
                        ap.yY();
                        c.wT().a((long) Hl2.field_msglocalid, cA2);
                        w.d("MicroMsg.VoiceRemindLogic", "END!!! updateSend  file:" + str2 + " total:" + Hl2.field_totallen + " status:" + Hl2.field_status + " netTimes:" + Hl2.field_nettimes);
                        i4 = 1;
                        h.lW(str2);
                    }
                    if (!h.a(Hl2)) {
                        i4 = -4;
                    }
                }
            }
            w.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd updateAfterSend:" + i4 + " file:" + this.fyF + " MsgSvrId:" + com_tencent_mm_protocal_c_bij.tfk + " clientId:" + com_tencent_mm_protocal_c_bij.tfU + " neWWOff:" + this.iaP + " neTTTT:" + com_tencent_mm_protocal_c_bij.tuc);
            if (i4 < 0) {
                h.lA(this.fyF);
                w.e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fyF + "UpdateAfterSend Ret:" + i4);
                this.gUD.a(i2, i3, str, this);
            } else if (i4 == 1) {
                w.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd finish file:" + this.fyF);
                this.gUD.a(i2, i3, str, this);
            } else {
                long j2 = this.ibh ? 0 : 500;
                w.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fyF + " delay:" + j2);
                this.hqQ.v(j2, j2);
            }
        } else {
            w.e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fyF + " errType:" + i2 + " errCode:" + i3);
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 329;
    }
}
