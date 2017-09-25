package com.tencent.mm.plugin.card.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.aiv;
import com.tencent.mm.protocal.c.iz;
import com.tencent.mm.protocal.c.ja;
import com.tencent.mm.protocal.c.jd;
import com.tencent.mm.protocal.c.lu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.List;

public final class w extends k implements j {
    private final b gUA;
    private e gUD;
    private byte[] hKD;
    private int kfQ = 0;

    public w(int i) {
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.NetSceneCardSync", "<init>, selector = %d", new Object[]{Integer.valueOf(1)});
        a aVar = new a();
        aVar.hsm = new iz();
        aVar.hsn = new ja();
        aVar.uri = "/cgi-bin/micromsg-bin/cardsync";
        aVar.hsl = 558;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        aiv com_tencent_mm_protocal_c_aiv = new aiv();
        ap.yY();
        com_tencent_mm_protocal_c_aiv.kgX = (String) c.vr().get(com.tencent.mm.storage.w.a.uAE, null);
        com_tencent_mm_protocal_c_aiv.latitude = (double) al.agg().gKj;
        com_tencent_mm_protocal_c_aiv.longitude = (double) al.agg().gKk;
        iz izVar = (iz) this.gUA.hsj.hsr;
        izVar.toa = 1;
        izVar.toc = com_tencent_mm_protocal_c_aiv;
        izVar.tod = i;
        this.kfQ = i;
    }

    public final int getType() {
        return 558;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        iz izVar = (iz) this.gUA.hsj.hsr;
        ap.yY();
        this.hKD = bg.PT(bg.mz((String) c.vr().get(282880, null)));
        if (this.hKD == null || this.hKD.length == 0) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.NetSceneCardSync", "doScene, keyBuf is null, init card sync~~~");
        }
        izVar.tob = n.G(this.hKD);
        String str = "MicroMsg.NetSceneCardSync";
        String str2 = "doScene, keyBuf.length = %d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(this.hKD == null ? 0 : this.hKD.length);
        com.tencent.mm.sdk.platformtools.w.i(str, str2, objArr);
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.NetSceneCardSync", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            ja jaVar = (ja) this.gUA.hsk.hsr;
            if (jaVar.tof == 1) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.NetSceneCardSync", "need do getCardsLayoutScene");
            }
            this.hKD = n.a(jaVar.tob, new byte[0]);
            List<lu> list = jaVar.toe == null ? null : jaVar.toe.jNe;
            String str2 = "MicroMsg.NetSceneCardSync";
            String str3 = "onGYNetEnd, cmd list size = %d, synckey length = %d, continueFlag = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
            objArr[1] = Integer.valueOf(this.hKD == null ? 0 : this.hKD.length);
            objArr[2] = Integer.valueOf(jaVar.tlZ);
            com.tencent.mm.sdk.platformtools.w.i(str2, str3, objArr);
            if (list == null || list.size() <= 0) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.NetSceneCardSync", "cmdList == null or size is 0");
                com.tencent.mm.plugin.card.a.b afZ = al.afZ();
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BatchGetCardMgr", "retryAll, getNow = %b", new Object[]{Boolean.valueOf(true)});
                synchronized (afZ.hAl) {
                    afZ.kcF.addAll(afZ.kcG);
                    afZ.kcG.clear();
                }
                afZ.afv();
            } else {
                int i4 = 0;
                for (lu a : list) {
                    int i5;
                    if (a(a)) {
                        i5 = i4;
                    } else {
                        i5 = i4 + 1;
                    }
                    i4 = i5;
                }
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.NetSceneCardSync", "onGYNetEnd, %d fail cmds", new Object[]{Integer.valueOf(i4)});
                al.afZ().afv();
            }
            ap.yY();
            c.vr().set(282880, bg.bo(this.hKD));
            if (jaVar.tlZ > 0) {
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.NetSceneCardSync", "onGYNetEnd, should continue, continueFlag = %d", new Object[]{Integer.valueOf(jaVar.tlZ)});
                if (a(this.hsD, this.gUD) <= 0) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.NetSceneCardSync", "onGYNetEnd, doScene again fail, ret = %d", new Object[]{Integer.valueOf(a(this.hsD, this.gUD))});
                    this.gUD.a(3, -1, str, this);
                    return;
                }
                return;
            }
            this.gUD.a(0, 0, str, this);
            return;
        }
        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.NetSceneCardSync", "onGYNetEnd, card sync fail, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.gUD.a(i2, i3, str, this);
    }

    private static boolean a(lu luVar) {
        if (luVar == null) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null cmd");
            return false;
        }
        byte[] a = n.a(luVar.tsb);
        if (a == null || a.length == 0) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null buf");
            return false;
        }
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.NetSceneCardSync", "processCmdItem, buf length = %d, cmdId = %d", new Object[]{Integer.valueOf(a.length), Integer.valueOf(luVar.tsa)});
        try {
            switch (luVar.tsa) {
                case 1:
                    jd jdVar = (jd) new jd().aD(a);
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, Status = %d", new Object[]{Integer.valueOf(jdVar.jNB)});
                    switch (jdVar.jNB) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 7:
                            com.tencent.mm.plugin.card.a.b afZ = al.afZ();
                            if (jdVar != null) {
                                long j;
                                CardInfo sr = al.aga().sr(jdVar.toT);
                                String str = "MicroMsg.BatchGetCardMgr";
                                String str2 = "pushCardUserItem, cardUserId = %s, localSeq = %d, svrSeq = %d";
                                Object[] objArr = new Object[3];
                                objArr[0] = jdVar.toT;
                                if (sr == null) {
                                    j = 0;
                                } else {
                                    j = sr.field_updateSeq;
                                }
                                objArr[1] = Long.valueOf(j);
                                objArr[2] = Long.valueOf(jdVar.toU);
                                com.tencent.mm.sdk.platformtools.w.i(str, str2, objArr);
                                if (sr != null && sr.field_updateSeq == jdVar.toU) {
                                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.BatchGetCardMgr", "push CardUserItem fail, card.field_updateSeq == item.UpdateSequence");
                                    break;
                                }
                                com.tencent.mm.sdk.e.c a2 = aj.a(jdVar);
                                synchronized (afZ.hAl) {
                                    if (!afZ.kcF.contains(a2)) {
                                        if (!afZ.kcG.contains(a2)) {
                                            afZ.kcF.add(a2);
                                            boolean b = al.agb().b(a2);
                                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BatchGetCardMgr", "pushCardUserItem, insertRet = %b", new Object[]{Boolean.valueOf(b)});
                                            break;
                                        }
                                        break;
                                    }
                                    break;
                                }
                            }
                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.BatchGetCardMgr", "push fail, CardUserItem is null");
                            break;
                            break;
                        case 6:
                            break;
                        default:
                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, unknown StateFlag = %d", new Object[]{Integer.valueOf(jdVar.toV)});
                            return false;
                    }
                    return true;
                default:
                    com.tencent.mm.sdk.platformtools.w.w("MicroMsg.NetSceneCardSync", "processCmdItem, unknown cmdId = %d", new Object[]{Integer.valueOf(luVar.tsa)});
                    return false;
            }
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, ex = %s", new Object[]{e.getMessage()});
            return false;
        }
        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.NetSceneCardSync", "processCmdItem fail, ex = %s", new Object[]{e.getMessage()});
        return false;
    }
}
