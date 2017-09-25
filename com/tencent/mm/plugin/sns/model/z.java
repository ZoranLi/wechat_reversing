package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.bcp;
import com.tencent.mm.protocal.c.bcq;
import com.tencent.mm.protocal.c.bcr;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Vector;

public final class z extends k implements j, d {
    private static Vector<String> pUS = new Vector();
    private final int fFq;
    private boolean fJm;
    private b gUA;
    public e gUD;
    private boolean pTN;
    private long pTO = 0;
    long pTP = 0;
    public int pTR = 0;
    private long pUG = 0;
    private boolean pUH = false;
    private boolean pUI = false;
    private int pUT = 0;
    private boolean pUU = false;
    private boolean pUV = false;
    public long pUW;
    private String pUp = "";
    String userName;

    public static synchronized boolean Fe(String str) {
        boolean z;
        synchronized (z.class) {
            if (pUS.contains(str)) {
                z = false;
            } else {
                pUS.add(str);
                z = true;
            }
        }
        return z;
    }

    public static synchronized boolean Ff(String str) {
        synchronized (z.class) {
            pUS.remove(str);
        }
        return true;
    }

    public z(String str, long j, boolean z, int i) {
        long j2 = 0;
        boolean z2 = false;
        this.userName = str;
        this.pTO = j;
        this.fJm = z;
        if (j == 0) {
            w.i("MicroMsg.NetSceneSnsUserPage", "fp userName " + str);
        } else {
            w.i("MicroMsg.NetSceneSnsUserPage", "np userName " + str);
        }
        this.fFq = z ? 4 : 8;
        a aVar = new a();
        aVar.hsm = new bcq();
        aVar.hsn = new bcr();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsuserpage";
        aVar.hsl = com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX;
        aVar.hso = 99;
        aVar.hsp = 1000000099;
        this.gUA = aVar.BE();
        bcq com_tencent_mm_protocal_c_bcq = (bcq) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bcq.tgG = str;
        com_tencent_mm_protocal_c_bcq.ubY = j;
        if (j == 0) {
            z2 = true;
        }
        this.pTN = z2;
        int Fo = ae.beB().Fo(str);
        n beL = ae.beL();
        if (!this.pTN) {
            j2 = j;
        }
        this.pTP = beL.a(j2, Fo, str, z);
        com_tencent_mm_protocal_c_bcq.udt = this.pTP;
        int a = c.a(this.pTP, j, str);
        com_tencent_mm_protocal_c_bcq.udu = a;
        com_tencent_mm_protocal_c_bcq.tfW = i;
        if (this.pTN) {
            this.pUp = ae.beO().Gk(str).field_md5;
            if (this.pUp == null) {
                this.pUp = "";
            }
            com_tencent_mm_protocal_c_bcq.ubX = this.pUp;
        }
        this.pUG = j;
        w.i("MicroMsg.NetSceneSnsUserPage", "nextCount: " + Fo + " maxId:" + i.df(j) + " minId:" + i.df(this.pTP) + " lastReqTime:" + a + " snsSource " + i);
    }

    private void beh() {
        n beL = ae.beL();
        String str = this.userName;
        boolean z = this.fJm;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select snsId from SnsInfo ").append(n.aq(str, z)).append(" AND type in ( 1,2 , 3 , 4 , 18 , 5 , 12 , 9 , 14 , 15 , 13 , 21 , 25) and  (snsId != 0  )  limit ").append(4);
        Cursor rawQuery = beL.gUz.rawQuery(stringBuilder.toString(), null);
        int count = rawQuery.getCount();
        rawQuery.close();
        if (count <= 3 && count > 0) {
            this.pUI = true;
        } else if (count == 0) {
            this.pUH = true;
        }
    }

    private void a(bcr com_tencent_mm_protocal_c_bcr, String str) {
        ai.a(this.userName, this.fFq, com_tencent_mm_protocal_c_bcr.tiQ, str);
        if (this.pTO == 0) {
            this.pTO = ((bbk) com_tencent_mm_protocal_c_bcr.tiQ.getFirst()).tmx;
        } else {
            this.pTO = c.dj(this.pTO);
        }
        this.pTP = ((bbk) com_tencent_mm_protocal_c_bcr.tiQ.getLast()).tmx;
        w.i("MicroMsg.NetSceneSnsUserPage", "insertListAndUpdateFaultInfo userName %s maxId %s minId %s NewRequestTime %s", new Object[]{this.userName, Long.valueOf(this.pTO), Long.valueOf(this.pTP), Integer.valueOf(com_tencent_mm_protocal_c_bcr.udx)});
        c.b(this.userName, this.pTO, this.pTP, com_tencent_mm_protocal_c_bcr.udx);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneSnsUserPage", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        bcr com_tencent_mm_protocal_c_bcr = (bcr) ((b) pVar).hsk.hsr;
        if (pVar.zg().sZC == 207 || pVar.zg().sZC == aq.CTRL_INDEX || pVar.zg().sZC == 0 || pVar.zg().sZC == MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN || pVar.zg().sZC == 2004 || pVar.zg().sZC == MMBitmapFactory.ERROR_ILLEGAL_IDATA_CHUNK) {
            String str2;
            if (pVar.zg().sZC == MMBitmapFactory.ERROR_ILLEGAL_IDATA_CHUNK) {
                n beL = ae.beL();
                str2 = this.userName;
                boolean eE = beL.gUz.eE("SnsInfo", "DELETE FROM SnsInfo" + " where SnsInfo.userName=\"" + bg.my(str2) + "\"");
                w.d("MicroMsg.SnsInfoStorage", "del snsinfo " + str2 + " res " + eE);
                Boolean.valueOf(eE);
            }
            this.pTR = com_tencent_mm_protocal_c_bcr.ucb;
            w.i("MicroMsg.NetSceneSnsUserPage", "for same md5 count: " + com_tencent_mm_protocal_c_bcr.ucb + " , objCount:  " + com_tencent_mm_protocal_c_bcr.tRg);
            this.pUW = com_tencent_mm_protocal_c_bcr.udH;
            str2 = i.dg(this.pTO);
            if (!this.pTN) {
                w.d("MicroMsg.NetSceneSnsUserPage", "np  " + com_tencent_mm_protocal_c_bcr.tiQ.size());
                if (com_tencent_mm_protocal_c_bcr.tiQ.isEmpty()) {
                    this.pUV = pVar.zg().sZC == aq.CTRL_INDEX;
                    ae.beL().a(this.userName, this.fJm, str2);
                    this.pUH = true;
                    this.pTP = this.pTO;
                } else {
                    a(com_tencent_mm_protocal_c_bcr, str2);
                }
                Ff(this.userName);
                this.gUD.a(i2, i3, str, this);
                return;
            } else if (this.pUp.equals(com_tencent_mm_protocal_c_bcr.ubX)) {
                this.pTP = ae.beL().a(this.pTN ? 0 : this.pUG, this.pTR, this.userName, this.fJm);
                w.i("MicroMsg.NetSceneSnsUserPage", "md5 is nochange the new minid %s", new Object[]{Long.valueOf(this.pTP)});
                beh();
                Ff(this.userName);
                com.tencent.mm.plugin.sns.storage.k Gk = ae.beO().Gk(this.userName);
                this.gUD.a(Gk.field_lastFirstPageRequestErrType, Gk.field_lastFirstPageRequestErrCode, str, this);
                return;
            } else {
                String df;
                String str3;
                w.i("MicroMsg.NetSceneSnsUserPage", "fp  " + com_tencent_mm_protocal_c_bcr.tiQ.size());
                if (this.pTN && !this.pUp.equals(com_tencent_mm_protocal_c_bcr.ubX)) {
                    this.pUT = com_tencent_mm_protocal_c_bcr.udG;
                    com.tencent.mm.plugin.sns.storage.k Gk2 = ae.beO().Gk(this.userName);
                    Gk2.field_icount = this.pUT;
                    bcp com_tencent_mm_protocal_c_bcp = com_tencent_mm_protocal_c_bcr.tMV;
                    if (com_tencent_mm_protocal_c_bcp != null) {
                        df = i.df(com_tencent_mm_protocal_c_bcp.hAQ);
                        String accSnsPath = ae.getAccSnsPath();
                        str3 = this.userName + "bg_";
                        String str4 = this.userName + "tbg_";
                        if (Gk2.field_bgUrl == null || !Gk2.field_bgId.equals(df)) {
                            Gk2.field_older_bgId = Gk2.field_bgId;
                            if (FileOp.aO(am.du(accSnsPath, this.userName) + str3)) {
                                FileOp.deleteFile(am.du(accSnsPath, this.userName) + str4);
                                FileOp.h(am.du(accSnsPath, this.userName), str3, str4);
                            }
                            this.pUU = true;
                            Gk2.bhm();
                            w.d("MicroMsg.NetSceneSnsUserPage", "get new  bgid " + com_tencent_mm_protocal_c_bcp.hAP);
                        }
                        Gk2.field_bgId = df;
                        Gk2.field_bgUrl = com_tencent_mm_protocal_c_bcp.hAP;
                        Gk2.field_snsBgId = com_tencent_mm_protocal_c_bcp.hAQ;
                    }
                    ae.beO().a(Gk2);
                }
                ae.beO().k(this.userName, com_tencent_mm_protocal_c_bcr.ubX, i2, i3);
                if (pVar.zg().sZC == 207 || pVar.zg().sZC == MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN || pVar.zg().sZC == 2004) {
                    ae.beO().dD(this.userName, "");
                    String str5;
                    if (com_tencent_mm_protocal_c_bcr.tiQ.isEmpty()) {
                        n beL2 = ae.beL();
                        str5 = this.userName;
                        boolean z = this.fJm;
                        beL2.g(z, n.aq(str5, z) + " AND  (snsId != 0  ) ");
                        this.pTP = this.pTO;
                    } else {
                        n beL3 = ae.beL();
                        df = this.userName;
                        boolean z2 = this.fJm;
                        str3 = i.dg(((bbk) com_tencent_mm_protocal_c_bcr.tiQ.getFirst()).tmx);
                        str5 = n.aq(df, z2) + " AND  (snsId != 0  ) ";
                        if (n.Go(str3)) {
                            str5 = str5 + " AND " + beL3.Gr(str3);
                        }
                        beL3.g(z2, str5);
                        ae.beL().a(this.userName, this.fJm, i.dg(((bbk) com_tencent_mm_protocal_c_bcr.tiQ.getLast()).tmx));
                        a(com_tencent_mm_protocal_c_bcr, str2);
                    }
                    beh();
                    Ff(this.userName);
                    this.gUD.a(i2, i3, str, this);
                    return;
                } else if (com_tencent_mm_protocal_c_bcr.tiQ.size() == 0) {
                    w.d("MicroMsg.NetSceneSnsUserPage", "error: server give size zero");
                    this.gUD.a(i2, i3, str, this);
                    return;
                } else {
                    a(com_tencent_mm_protocal_c_bcr, str2);
                    Ff(this.userName);
                    this.gUD.a(i2, i3, str, this);
                    return;
                }
            }
        }
        Ff(this.userName);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final long bdW() {
        return this.pTP;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final boolean bdS() {
        return this.pTN;
    }

    public final boolean bdT() {
        return this.pUH;
    }

    public final boolean bdX() {
        return this.pUU;
    }

    public final boolean bdV() {
        return this.pUV;
    }

    public final boolean bdU() {
        return this.pUI;
    }

    public final long bdY() {
        return this.pUW;
    }
}
