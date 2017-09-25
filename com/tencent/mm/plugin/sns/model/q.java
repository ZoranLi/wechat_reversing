package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bam;
import com.tencent.mm.protocal.c.bap;
import com.tencent.mm.protocal.c.bat;
import com.tencent.mm.protocal.c.bba;
import com.tencent.mm.protocal.c.bbj;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.bbn;
import com.tencent.mm.protocal.c.bbo;
import com.tencent.mm.protocal.c.bbp;
import com.tencent.mm.protocal.c.bbq;
import com.tencent.mm.protocal.c.bbr;
import com.tencent.mm.protocal.c.bbx;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.LinkedList;

public final class q extends k implements j {
    private b gUA;
    public e gUD;
    private ae handler;
    public int pRa;
    private long pTZ;
    private bba pUa;
    private Object pUb;
    private int pUc;
    public int type;

    public q(long j, int i) {
        this(j, i, null, null);
    }

    public q(long j, Object obj) {
        this(j, 12, null, obj);
    }

    public q(long j, int i, bba com_tencent_mm_protocal_c_bba) {
        this(j, i, com_tencent_mm_protocal_c_bba, null);
    }

    private q(long j, int i, bba com_tencent_mm_protocal_c_bba, Object obj) {
        this.type = -1;
        this.pTZ = 0;
        this.pRa = -1;
        this.pUc = 0;
        this.handler = new ae(Looper.getMainLooper());
        this.pUa = com_tencent_mm_protocal_c_bba;
        this.type = i;
        this.pTZ = j;
        this.pUb = obj;
        w.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + j + "  op : " + i);
        if (com_tencent_mm_protocal_c_bba != null) {
            w.i("MicroMsg.NetSceneSnsObjectOp", com_tencent_mm_protocal_c_bba.ubK + " " + com_tencent_mm_protocal_c_bba.ubN);
        }
        a aVar = new a();
        aVar.hsm = new bbq();
        aVar.hsn = new bbr();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
        aVar.hsl = 218;
        aVar.hso = 104;
        aVar.hsp = 1000000104;
        this.gUA = aVar.BE();
        bbq com_tencent_mm_protocal_c_bbq = (bbq) this.gUA.hsj.hsr;
        m dG = ae.beL().dG(j);
        if (dG != null) {
            this.pRa = dG.qnk;
        }
        bbn a = a(j, i, this.pUa, obj);
        LinkedList linkedList = new LinkedList();
        linkedList.add(a);
        com_tencent_mm_protocal_c_bbq.ucJ = linkedList;
        com_tencent_mm_protocal_c_bbq.ucI = linkedList.size();
    }

    public q(long j, int i, int i2, String str) {
        this.type = -1;
        this.pTZ = 0;
        this.pRa = -1;
        this.pUc = 0;
        this.handler = new ae(Looper.getMainLooper());
        this.pUa = null;
        this.type = 9;
        this.pTZ = j;
        w.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + j + "  op : " + this.type);
        a aVar = new a();
        aVar.hsm = new bbq();
        aVar.hsn = new bbr();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
        aVar.hsl = 218;
        aVar.hso = 104;
        aVar.hsp = 1000000104;
        this.gUA = aVar.BE();
        bbq com_tencent_mm_protocal_c_bbq = (bbq) this.gUA.hsj.hsr;
        m dG = ae.beL().dG(j);
        if (dG != null) {
            this.pRa = dG.qnk;
        }
        bbn v = v(j, this.type);
        bbp com_tencent_mm_protocal_c_bbp = new bbp();
        com_tencent_mm_protocal_c_bbp.tdM = i;
        com_tencent_mm_protocal_c_bbp.ucG = i2;
        com_tencent_mm_protocal_c_bbp.ucH = n.mw(str);
        try {
            v.tUb = new avw().bb(com_tencent_mm_protocal_c_bbp.toByteArray());
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e, "", new Object[0]);
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(v);
        com_tencent_mm_protocal_c_bbq.ucJ = linkedList;
        com_tencent_mm_protocal_c_bbq.ucI = linkedList.size();
    }

    private static bbn a(long j, int i, bba com_tencent_mm_protocal_c_bba, Object obj) {
        bbn v = v(j, i);
        w.i("MicroMsg.NetSceneSnsObjectOp", "getSnsObjectOp " + i + " " + (obj == null ? "" : obj.toString()));
        m mVar = null;
        String str = "";
        if (i == 8 || i == 10 || i == 7 || i == 8 || i == 6) {
            com.tencent.mm.plugin.sns.storage.e dz = ae.beN().dz(j);
            if (dz != null) {
                mVar = dz.bhf();
            }
            if (mVar != null && mVar.tE(32)) {
                com.tencent.mm.plugin.sns.storage.a bhc = mVar.bhc();
                str = bhc == null ? "" : bhc.pZI;
                w.i("MicroMsg.NetSceneSnsObjectOp", "aduxinfo " + str);
            }
        }
        if (i == 6) {
            if (com_tencent_mm_protocal_c_bba == null || (com_tencent_mm_protocal_c_bba.ubK == 0 && com_tencent_mm_protocal_c_bba.ubN == 0)) {
                return v;
            }
            bat com_tencent_mm_protocal_c_bat = new bat();
            com_tencent_mm_protocal_c_bat.ubG = com_tencent_mm_protocal_c_bba.ubN;
            com_tencent_mm_protocal_c_bat.ubz = n.mw(bg.ap(str, ""));
            try {
                v.tUb = new avw().bb(com_tencent_mm_protocal_c_bat.toByteArray());
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e, "", new Object[0]);
            }
        } else if (i == 7) {
            bam com_tencent_mm_protocal_c_bam = new bam();
            com_tencent_mm_protocal_c_bam.ubz = n.mw(bg.ap(str, ""));
            try {
                v.tUb = new avw().bb(com_tencent_mm_protocal_c_bam.toByteArray());
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e2, "", new Object[0]);
            }
        } else if (i == 8) {
            ae.beN().delete(j);
            ae.beP().dB(j);
            bap com_tencent_mm_protocal_c_bap = new bap();
            com_tencent_mm_protocal_c_bap.ubz = n.mw(bg.ap(str, ""));
            try {
                v.tUb = new avw().bb(com_tencent_mm_protocal_c_bap.toByteArray());
            } catch (Throwable e22) {
                w.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e22, "", new Object[0]);
            }
        } else if (i == 4) {
            if (com_tencent_mm_protocal_c_bba == null || (com_tencent_mm_protocal_c_bba.ubK == 0 && com_tencent_mm_protocal_c_bba.ubN == 0)) {
                return v;
            }
            bbo com_tencent_mm_protocal_c_bbo = new bbo();
            com_tencent_mm_protocal_c_bbo.ubK = com_tencent_mm_protocal_c_bba.ubK;
            try {
                v.tUb = new avw().bb(com_tencent_mm_protocal_c_bbo.toByteArray());
            } catch (Throwable e222) {
                w.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e222, "", new Object[0]);
            }
        } else if (i == 10) {
            bbx com_tencent_mm_protocal_c_bbx = new bbx();
            if (obj instanceof com.tencent.mm.bd.b) {
                com.tencent.mm.bd.b bVar = (com.tencent.mm.bd.b) obj;
                com_tencent_mm_protocal_c_bbx.udb = n.G(bVar.sYA);
                w.i("MicroMsg.NetSceneSnsObjectOp", "NetSceneSnsObjectOpticket " + bVar.sYA.length);
            } else {
                w.e("MicroMsg.NetSceneSnsObjectOp", "error ticket");
            }
            try {
                byte[] toByteArray = com_tencent_mm_protocal_c_bbx.toByteArray();
                v.tUb = new avw().bb(toByteArray);
                w.i("MicroMsg.NetSceneSnsObjectOp", "opFree " + toByteArray.length);
            } catch (Throwable e2222) {
                w.e("MicroMsg.NetSceneSnsObjectOp", "error ticket " + e2222.getMessage());
                w.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e2222, "", new Object[0]);
            }
        } else if (i == 12) {
            if (obj instanceof bbj) {
                bbj com_tencent_mm_protocal_c_bbj = (bbj) obj;
                try {
                    v.tUb = n.G(com_tencent_mm_protocal_c_bbj.toByteArray());
                    w.i("MicroMsg.NetSceneSnsObjectOp", "snsMetionBlockOp, switch:%d " + com_tencent_mm_protocal_c_bbj.uci);
                } catch (Exception e3) {
                    w.e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp " + e3.getMessage());
                }
            } else {
                w.e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp");
            }
        }
        return v;
    }

    private static bbn v(long j, int i) {
        bbn com_tencent_mm_protocal_c_bbn = new bbn();
        com_tencent_mm_protocal_c_bbn.tUb = new avw();
        com_tencent_mm_protocal_c_bbn.tmx = j;
        com_tencent_mm_protocal_c_bbn.mtF = i;
        return com_tencent_mm_protocal_c_bbn;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 218;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneSnsObjectOp", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            m dG;
            bbk com_tencent_mm_protocal_c_bbk;
            Iterator it;
            Object obj;
            switch (this.type) {
                case 1:
                    ae.beK().dt(this.pTZ);
                    ae.beL().delete(this.pTZ);
                    break;
                case 2:
                    dG = ae.beL().dG(this.pTZ);
                    if (dG != null) {
                        dG.field_pravited = 1;
                        dG.bhs();
                        ae.beL().b(this.pTZ, dG);
                        break;
                    }
                    break;
                case 3:
                    dG = ae.beL().dG(this.pTZ);
                    if (dG != null) {
                        dG.field_pravited = 0;
                        dG.field_localPrivate = 0;
                        dG.bhv();
                        ae.beL().b(this.pTZ, dG);
                        break;
                    }
                    break;
                case 4:
                    m dG2 = ae.beL().dG(this.pTZ);
                    if (dG2 != null) {
                        try {
                            com_tencent_mm_protocal_c_bbk = (bbk) new bbk().aD(dG2.field_attrBuf);
                            it = com_tencent_mm_protocal_c_bbk.ucq.iterator();
                            while (it.hasNext()) {
                                obj = (bba) it.next();
                                if (this.pUa != null && obj.ubK == this.pUa.ubK) {
                                    if (obj != null) {
                                        com_tencent_mm_protocal_c_bbk.ucq.remove(obj);
                                    }
                                    dG2.aF(com_tencent_mm_protocal_c_bbk.toByteArray());
                                    ae.beL().z(dG2);
                                    ae.beP().e(dG2.field_snsId, (long) this.pUa.ubK, this.pUa.jOc);
                                    break;
                                }
                            }
                            obj = null;
                            if (obj != null) {
                                com_tencent_mm_protocal_c_bbk.ucq.remove(obj);
                            }
                            dG2.aF(com_tencent_mm_protocal_c_bbk.toByteArray());
                            ae.beL().z(dG2);
                            ae.beP().e(dG2.field_snsId, (long) this.pUa.ubK, this.pUa.jOc);
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e, "", new Object[0]);
                            break;
                        }
                    }
                    break;
                case 5:
                    ae.beK().dv(this.pTZ);
                    break;
                case 6:
                    c dz = ae.beN().dz(this.pTZ);
                    if (dz != null) {
                        try {
                            com_tencent_mm_protocal_c_bbk = (bbk) new bbk().aD(dz.field_attrBuf);
                            it = com_tencent_mm_protocal_c_bbk.ucq.iterator();
                            while (it.hasNext()) {
                                obj = (bba) it.next();
                                if (this.pUa != null && obj.ubN == this.pUa.ubN) {
                                    if (obj != null) {
                                        com_tencent_mm_protocal_c_bbk.ucq.remove(obj);
                                    }
                                    dz.aF(com_tencent_mm_protocal_c_bbk.toByteArray());
                                    ae.beN().a(dz);
                                    ae.beP().e(dz.field_snsId, this.pUa.ubN, this.pUa.jOc);
                                    break;
                                }
                            }
                            obj = null;
                            if (obj != null) {
                                com_tencent_mm_protocal_c_bbk.ucq.remove(obj);
                            }
                            dz.aF(com_tencent_mm_protocal_c_bbk.toByteArray());
                            ae.beN().a(dz);
                            ae.beP().e(dz.field_snsId, this.pUa.ubN, this.pUa.jOc);
                        } catch (Throwable e2) {
                            w.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e2, "", new Object[0]);
                            break;
                        }
                    }
                    break;
                case 7:
                    ae.beK().dv(this.pTZ);
                    break;
                case 8:
                    ae.beN().delete(this.pTZ);
                    ae.beP().dB(this.pTZ);
                    break;
                case 9:
                    dG = ae.beL().dG(this.pTZ);
                    if (dG != null) {
                        dG.tF(2);
                        ae.beL().b(this.pTZ, dG);
                        break;
                    }
                    break;
                case 11:
                    w.i("MicroMsg.NetSceneSnsObjectOp", "scene end switch " + this.pUc);
                    if (this.pUc == 0) {
                        h.vJ();
                        h.vI().vr().a(com.tencent.mm.storage.w.a.uDd, Boolean.valueOf(true));
                    } else if (this.pUc == 1) {
                        h.vJ();
                        h.vI().vr().a(com.tencent.mm.storage.w.a.uDd, Boolean.valueOf(false));
                    }
                    h.vJ();
                    int intValue = ((Integer) h.vI().vr().get(com.tencent.mm.storage.w.a.uDf, Integer.valueOf(0))).intValue();
                    h.vJ();
                    h.vI().vr().a(com.tencent.mm.storage.w.a.uDf, Integer.valueOf(intValue + 1));
                    h.vJ();
                    intValue = ((Integer) h.vI().vr().get(com.tencent.mm.storage.w.a.uDg, Integer.valueOf(0))).intValue();
                    int i4;
                    if (this.pUc == 0) {
                        intValue++;
                        i4 = (intValue * 2) + 198;
                        if (i4 >= com.tencent.mm.plugin.appbrand.jsapi.e.c.CTRL_INDEX) {
                            i4 = com.tencent.mm.plugin.appbrand.jsapi.e.c.CTRL_INDEX;
                        }
                        if (i4 >= com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX) {
                            com.tencent.mm.plugin.sns.lucky.a.b.mN(i4);
                        }
                        w.i("MicroMsg.NetSceneSnsObjectOp", "opcount open " + i4 + " " + intValue);
                    } else if (this.pUc == 1) {
                        intValue++;
                        i4 = ((intValue * 2) + 198) + 1;
                        if (i4 >= com.tencent.mm.plugin.appbrand.jsapi.e.b.CTRL_INDEX) {
                            i4 = com.tencent.mm.plugin.appbrand.jsapi.e.b.CTRL_INDEX;
                        }
                        if (i4 >= bh.CTRL_INDEX) {
                            com.tencent.mm.plugin.sns.lucky.a.b.mN(i4);
                        }
                        w.i("MicroMsg.NetSceneSnsObjectOp", "opcount close " + i4 + " " + intValue);
                    }
                    h.vJ();
                    h.vI().vr().a(com.tencent.mm.storage.w.a.uDg, Integer.valueOf(intValue));
                    break;
                case 12:
                    if (this.pUb != null && (this.pUb instanceof bbj)) {
                        ae.beP().m(this.pTZ, ((bbj) this.pUb).uci == 1);
                        w.i("MicroMsg.NetSceneSnsObjectOp", "remind  update [snsId:%d] ->isSilence: %b", new Object[]{Long.valueOf(this.pTZ), Boolean.valueOf(r0)});
                        break;
                    }
            }
            ae.beK().bem();
            this.gUD.a(i2, i3, str, this);
            return;
        }
        if (i2 == 4 && this.type == 1) {
            switch (this.type) {
                case 1:
                    ae.beK().dt(this.pTZ);
                    break;
                case 5:
                case 7:
                    ae.beK().dv(this.pTZ);
                    break;
            }
        }
        this.gUD.a(i2, i3, str, this);
    }
}
