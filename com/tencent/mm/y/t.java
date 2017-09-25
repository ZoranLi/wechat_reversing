package com.tencent.mm.y;

import android.os.Looper;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.e.a.gx;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.protocal.c.axk;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class t extends com.tencent.mm.protocal.h.a {
    private static a htO;
    private e htM;
    private byte[] htN;
    private int type;

    public interface a {
        void bq(String str);
    }

    public static void a(a aVar) {
        htO = aVar;
    }

    public t(e eVar, int i) {
        this.htM = eVar;
        this.type = i;
    }

    public final boolean a(int i, byte[] bArr, byte[] bArr2) {
        PByteArray pByteArray = new PByteArray();
        if (this.htM instanceof c) {
            PByteArray pByteArray2 = new PByteArray();
            PInt pInt = new PInt(0);
            c cVar = (c) this.htM;
            PInt pInt2 = new PInt(0);
            PInt pInt3 = new PInt(0);
            try {
                if (cVar.bHp()) {
                    int y = cVar.y(bArr);
                    w.d("MicroMsg.RemoteResp", "rawData using protobuf ok");
                    this.htM.sZC = y;
                    if (!bg.mA(r.iiZ)) {
                        this.htM.sZD = r.iiZ;
                    }
                    return true;
                }
                w.i("MicroMsg.RemoteResp", "bufToResp unpack ret[%b], jType[%d], noticeid[%d]", Boolean.valueOf(MMProtocalJni.unpack(pByteArray2, bArr, bArr2, pByteArray, pInt, pInt2, pInt3)), Integer.valueOf(i), Integer.valueOf(pInt3.value));
                b gxVar;
                boolean m;
                if (MMProtocalJni.unpack(pByteArray2, bArr, bArr2, pByteArray, pInt, pInt2, pInt3)) {
                    if (i != 701 && i != 702 && CdnLogic.MediaType_FAVORITE_FILE == r.iiW && r.iiX > 0) {
                        if (r.iiX == 2) {
                            ac.G("", "", 0);
                        }
                        r.iiX = 0;
                        pInt.value = -13;
                        w.w("MicroMsg.RemoteResp", "dkcert dktest set session timeout once !");
                    }
                    if (pInt.value == -13 || pInt.value == -102 || pInt.value == -3001 || pInt.value == -3002 || pInt.value == -3003) {
                        this.htM.sZC = pInt.value;
                        if (pInt.value == -3002) {
                            try {
                                this.htM.sZD = new String(pByteArray2.value);
                            } catch (Exception e) {
                                w.e("MicroMsg.RemoteResp", "parse string err while MM_ERR_IDCDISASTER");
                            }
                            w.i("MicroMsg.RemoteResp", "jType [%d], ret value[%d], noticeId[%s], msg[%s]", Integer.valueOf(i), Integer.valueOf(pInt.value), pInt3, this.htM.sZD);
                        }
                    } else {
                        w.i("MicroMsg.RemoteResp", "bufToResp using protobuf ok jType:%d, enType:%d errCode:%d, len:%d", Integer.valueOf(i), Integer.valueOf(pInt2.value), Integer.valueOf(cVar.y(pByteArray2.value)), Integer.valueOf(pByteArray2.value.length));
                        this.htM.sZC = r1;
                    }
                    this.htM.sZB = (long) bArr.length;
                    this.htN = pByteArray.value;
                    if (!bg.mA(r.iiZ)) {
                        this.htM.sZD = r.iiZ;
                    }
                    if (pInt3.value != 0) {
                        gxVar = new gx();
                        gxVar.fMk.fMl = pInt3.value;
                        if (i == 701 && this.htM.sZC == 0) {
                            w.i("MicroMsg.RemoteResp", "summerdiz publish GetDisasterInfoEvent MMFunc_ManualAuth ok [%d]", Integer.valueOf(pInt3.value));
                            gxVar.fMk.fMm = true;
                        }
                        m = com.tencent.mm.sdk.b.a.urY.m(gxVar);
                        w.i("MicroMsg.RemoteResp", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m));
                        pInt3.value = 0;
                    }
                    return true;
                }
                w.e("MicroMsg.RemoteResp", "unpack return false jType[%d]", Integer.valueOf(i));
                if (pInt3.value != 0) {
                    gxVar = new gx();
                    gxVar.fMk.fMl = pInt3.value;
                    m = com.tencent.mm.sdk.b.a.urY.m(gxVar);
                    w.i("MicroMsg.RemoteResp", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m));
                    pInt3.value = 0;
                }
                return false;
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.RemoteResp", e2, "from Protobuf unbuild exception, check now!", new Object[0]);
                w.e("MicroMsg.RemoteResp", "exception:%s", bg.g(e2));
            }
        } else {
            w.f("MicroMsg.RemoteResp", "all protocal should implemented with protobuf");
            return false;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, PInt pInt, avp com_tencent_mm_protocal_c_avp) {
        PByteArray pByteArray = new PByteArray();
        pInt.value = -1;
        PByteArray pByteArray2 = new PByteArray();
        PInt pInt2 = new PInt(0);
        PInt pInt3 = new PInt(0);
        try {
            w.i("MicroMsg.RemoteResp", "bufToRespNoRSA unpack ret[%b], noticeid[%d]", Boolean.valueOf(MMProtocalJni.unpack(pByteArray2, bArr, bArr2, pByteArray, pInt, pInt2, pInt3)), Integer.valueOf(pInt3.value));
            if (pInt3.value != 0) {
                b gxVar = new gx();
                gxVar.fMk.fMl = pInt3.value;
                boolean m = com.tencent.mm.sdk.b.a.urY.m(gxVar);
                w.i("MicroMsg.RemoteResp", "summerdiz bufToRespNoRSA publish GetDisasterInfoEvent noticeid[%d] publish[%b]", Integer.valueOf(pInt3.value), Boolean.valueOf(m));
            }
            if (!r1) {
                w.e("MicroMsg.RemoteResp", "unpack failed.");
                return null;
            } else if (pInt.value == -13 || pInt.value == -102 || pInt.value == -3001) {
                w.e("MicroMsg.RemoteResp", "unpack failed. error:%d", Integer.valueOf(pInt.value));
                return null;
            } else if (pInt.value == -3002) {
                try {
                    final String str = new String(pByteArray2.value);
                    w.i("MicroMsg.RemoteResp", "bufToRespNoRSA -3002 ERR_IDCDISASTER, errStr:%s", str);
                    new ae(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            if (!bg.mA(str) && t.htO != null) {
                                t.htO.bq(str);
                            }
                        }
                    });
                    return null;
                } catch (Exception e) {
                    w.e("MicroMsg.RemoteResp", "parse string err while MM_ERR_IDCDISASTER");
                }
            } else {
                w.i("MicroMsg.RemoteResp", "fuckwifi bufToRespNoRSA using protobuf ok jtype:%d enType:%d ", Integer.valueOf(MMGIFException.D_GIF_ERR_CLOSE_FAILED), Integer.valueOf(pInt2.value));
                com_tencent_mm_protocal_c_avp.aD(pByteArray2.value);
                return pByteArray2.value;
            }
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.RemoteResp", e2, "parseFrom unbuild exception, check now!", new Object[0]);
            w.e("MicroMsg.RemoteResp", "exception:%s", bg.g(e2));
        }
    }

    public final byte[] BX() {
        return this.htN;
    }

    public final String Cp() {
        return this.htM.sZD;
    }

    public final void hA(String str) {
        this.htM.sZD = str;
    }

    public final int Cq() {
        return this.htM.sZC;
    }

    public final void ft(int i) {
        this.htM.sZC = i;
    }

    public final byte[] vc() {
        byte[] bArr = new byte[0];
        switch (this.type) {
            case 126:
                return ((y.b) this.htM).idY;
            case 701:
            case 702:
                return ((g) this.htM).idY;
            default:
                return bArr;
        }
    }

    public final byte[] Cr() {
        byte[] bArr = new byte[0];
        switch (this.type) {
            case 126:
                axk com_tencent_mm_protocal_c_axk = ((y.b) this.htM).taf.tSL;
                if (com_tencent_mm_protocal_c_axk == null || com_tencent_mm_protocal_c_axk.thf == null) {
                    w.d("MicroMsg.RemoteResp", "summerauth MMFunc_NewReg SecAuthRegKeySect is null");
                    break;
                }
                return com_tencent_mm_protocal_c_axk.thf.tZp.toByteArray();
            case 701:
            case 702:
                if (((g) this.htM).sZm.ugy.thf != null) {
                    return ((g) this.htM).sZm.ugy.thf.tZp.toByteArray();
                }
                break;
        }
        return bArr;
    }

    public final byte[] BZ() {
        byte[] bArr = new byte[0];
        switch (this.type) {
            case 126:
                return ((y.b) this.htM).sZn;
            case 701:
            case 702:
                return ((g) this.htM).sZn;
            default:
                return bArr;
        }
    }

    public final String Cs() {
        if (this.type == 381) {
            ate com_tencent_mm_protocal_c_ate = ((com.tencent.mm.protocal.r.b) this.htM).sZV.tDg;
            if (com_tencent_mm_protocal_c_ate != null) {
                return bg.mz(com_tencent_mm_protocal_c_ate.tXn);
            }
        }
        return "";
    }

    public final String Ct() {
        if (this.type == 381) {
            ate com_tencent_mm_protocal_c_ate = ((com.tencent.mm.protocal.r.b) this.htM).sZV.tDg;
            if (com_tencent_mm_protocal_c_ate != null) {
                return bg.mz(com_tencent_mm_protocal_c_ate.tXm);
            }
        }
        return "";
    }

    public final int Cu() {
        if (this.type == 381) {
            return ((com.tencent.mm.protocal.r.b) this.htM).sZV.tCs;
        }
        return 0;
    }

    public final int uH() {
        switch (this.type) {
            case 126:
                return ((y.b) this.htM).taf.leD;
            case 701:
            case 702:
                return ((g) this.htM).sZm.ugy.leD;
            default:
                return 0;
        }
    }

    public final String Cv() {
        switch (this.type) {
            case 126:
                return ((y.b) this.htM).taf.jNj;
            case 701:
            case 702:
                return ((g) this.htM).ieb;
            default:
                return "";
        }
    }

    public final int getCmdId() {
        return this.htM.getCmdId();
    }
}
