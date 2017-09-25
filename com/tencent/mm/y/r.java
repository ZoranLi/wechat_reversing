package com.tencent.mm.y;

import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.zero.a.e;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.aku;
import com.tencent.mm.protocal.c.dw;
import com.tencent.mm.protocal.g.a;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.i.c;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayOutputStream;

public final class r extends a {
    private static e htE;
    private d hsz;
    private byte[] htF;
    private int type;

    public static void a(e eVar) {
        htE = eVar;
    }

    public r(d dVar, int i) {
        this.hsz = dVar;
        this.type = i;
    }

    public static boolean a(byte[] bArr, byte[] bArr2, byte[] bArr3, d dVar, ByteArrayOutputStream byteArrayOutputStream, boolean z) {
        if (bg.bm(bArr)) {
            String str = "MicroMsg.RemoteReq";
            String str2 = "reqToBufNoRSA session is null :%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            w.e(str, str2, objArr);
            return false;
        }
        PByteArray pByteArray = new PByteArray();
        try {
            b bVar = (b) dVar;
            byte[] zh = bVar.zh();
            if (zh == null) {
                return false;
            }
            if (bVar.bHp()) {
                byteArrayOutputStream.write(zh);
                return true;
            }
            ac bHs = ac.bHs();
            int i = 6;
            if (z) {
                i = 7;
            }
            if (!MMProtocalJni.pack(zh, pByteArray, bArr, bArr2, dVar.sZv, dVar.sZs, bVar.zi(), bHs.ver, bHs.tal.getBytes(), bHs.tam.getBytes(), bArr3, i)) {
                return false;
            }
            w.d("MicroMsg.RemoteReq", "reqToBuf using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i));
            byteArrayOutputStream.write(pByteArray.value);
            return true;
        } catch (Throwable e) {
            w.e("MicroMsg.RemoteReq", "protobuf build exception, check now! :" + e.getMessage());
            w.printErrStackTrace("MicroMsg.RemoteReq", e, "", new Object[0]);
            return false;
        }
    }

    public final boolean a(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, int i2, boolean z) {
        PByteArray pByteArray = new PByteArray();
        w.d("MicroMsg.RemoteReq", "reqToBuf jType: %d, stack: %s", Integer.valueOf(i), bg.bJZ());
        switch (i) {
            case 268369922:
                try {
                    this.htF = ((b) this.hsz).zh();
                    this.hsz.sZB = (long) this.htF.length;
                    return true;
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.RemoteReq", e, "", new Object[0]);
                    return false;
                }
            default:
                if (this.hsz instanceof b) {
                    try {
                        b bVar = (b) this.hsz;
                        byte[] zh = bVar.zh();
                        if (zh == null) {
                            return false;
                        }
                        if (bVar.bHp()) {
                            this.htF = zh;
                            this.hsz.sZB = (long) this.htF.length;
                            return true;
                        }
                        long j;
                        int i3;
                        int i4;
                        Object obj;
                        long j2 = (long) this.hsz.sZs;
                        if (com.tencent.mm.sdk.a.b.bIu() && j2 == 0) {
                            j = com.tencent.mm.protocal.d.sYM;
                        } else {
                            j = j2;
                        }
                        ac acVar = this.hsz.sZA;
                        if (!acVar.bHv()) {
                            bArr = new byte[0];
                        }
                        byte[][] bArr4 = null;
                        int i5;
                        switch (i) {
                            case 701:
                                aku com_tencent_mm_protocal_c_aku = ((i.d) this.hsz).sZj;
                                bArr4 = a(j, com_tencent_mm_protocal_c_aku.tOB, com_tencent_mm_protocal_c_aku.tOC);
                                i5 = 1;
                                break;
                            case 702:
                                w.d("MicroMsg.RemoteReq", "summerauth reqToBuf rsaReqData uin[%d]", Long.valueOf(j));
                                if (j == 0) {
                                    if (c.a.sZi == null) {
                                        i3 = -1;
                                    } else {
                                        i3 = c.a.sZi.zd();
                                    }
                                    h.vJ();
                                    h.vG();
                                    w.w("MicroMsg.RemoteReq", "summerauth autoauth uin[%d] is invalid! uinForProtocal[%d] accountUin[%d]", Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(com.tencent.mm.kernel.a.uH()));
                                    com.tencent.mm.plugin.report.c.oTb.a(148, 54, 1, true);
                                    if (i3 != 0) {
                                        com.tencent.mm.plugin.report.c.oTb.a(148, 55, 1, true);
                                    }
                                    if (i4 != 0) {
                                        com.tencent.mm.plugin.report.c.oTb.a(148, 56, 1, true);
                                    }
                                }
                                dw dwVar = ((i.a) this.hsz).sZh;
                                bArr4 = a(j, dwVar.thG, dwVar.thH);
                                i5 = 1;
                                break;
                            default:
                                obj = null;
                                break;
                        }
                        i3 = 6;
                        if (z) {
                            i3 = 7;
                        }
                        if (obj != null) {
                            if (acVar.bHv() && bg.bm(bArr)) {
                                w.e("MicroMsg.RemoteReq", "dksession jType %d session should not null", Integer.valueOf(i));
                                return false;
                            } else if (bArr4 == null) {
                                return false;
                            } else {
                                byte[] bArr5 = bArr4[0];
                                byte[] bArr6 = bArr4[1];
                                switch (i) {
                                    case 702:
                                        if (MMProtocalJni.packDoubleHybrid(pByteArray, bArr2, this.hsz.sZv, (int) j, bVar.zi(), acVar.ver, bArr5, bArr6, acVar.tal.getBytes(), acVar.tam.getBytes(), Cj(), i3)) {
                                            w.d("MicroMsg.RemoteReq", "summer reqToBuf packDoubleHybrid AutoAuth using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i3));
                                            this.htF = pByteArray.value;
                                            break;
                                        }
                                        break;
                                    default:
                                        if (MMProtocalJni.packHybrid(pByteArray, bArr2, this.hsz.sZv, (int) j, bVar.zi(), acVar.ver, bArr5, bArr6, acVar.tal.getBytes(), acVar.tam.getBytes(), Cj(), i3)) {
                                            w.d("MicroMsg.RemoteReq", "MMEncryptCheckResUpdate reqToBuf packHybrid EncryptCheckResUpdate using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i3));
                                            this.htF = pByteArray.value;
                                            break;
                                        }
                                        break;
                                }
                                this.hsz.sZB = (long) this.htF.length;
                            }
                        } else if (this.hsz.sZy != null) {
                            int i6 = 6;
                            if (z) {
                                i6 = 7;
                            }
                            if (this.hsz.sZy.a(pByteArray, i, bArr2, bArr3, i6)) {
                                this.htF = pByteArray.value;
                                this.hsz.sZB = (long) this.htF.length;
                                w.d("MicroMsg.RemoteReq", "reqToBuf using req.getReqPackControl() ok, len:%d", Integer.valueOf(pByteArray.value.length));
                            }
                            return true;
                        } else if (i != 775 && acVar.bHv() && bg.bm(bArr)) {
                            w.e("MicroMsg.RemoteReq", "dksession jType %d session should not null", Integer.valueOf(i));
                            return false;
                        } else {
                            if (i == 775) {
                                i4 = (i3 & -3) & -5;
                            } else {
                                i4 = i3;
                            }
                            w.d("MicroMsg.RemoteReq", "dkrsa use session :%s  type:%d, flag:%d, ecdh:[%s]", bArr, Integer.valueOf(i), Integer.valueOf(i4), bg.bl(bArr3));
                            if (MMProtocalJni.pack(zh, pByteArray, bArr, bArr2, this.hsz.sZv, (int) j, bVar.zi(), acVar.ver, acVar.tal.getBytes(), acVar.tam.getBytes(), bArr3, i4)) {
                                w.d("MicroMsg.RemoteReq", "reqToBuf using protobuf ok, len:%d, flag:%d", Integer.valueOf(pByteArray.value.length), Integer.valueOf(i4));
                                this.htF = pByteArray.value;
                            }
                            this.hsz.sZB = (long) this.htF.length;
                        }
                        return true;
                    } catch (Throwable e2) {
                        w.e("MicroMsg.RemoteReq", "protobuf build exception, check now! :" + e2.getMessage());
                        w.printErrStackTrace("MicroMsg.RemoteReq", e2, "", new Object[0]);
                        return false;
                    }
                }
                w.f("MicroMsg.RemoteReq", "all protocal should implemented with protobuf");
                return false;
        }
    }

    public static byte[][] a(long j, com.tencent.mm.bd.a aVar, com.tencent.mm.bd.a aVar2) {
        byte[] toByteArray;
        if (j == 0) {
            w.w("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray autoauth uin is invalid!");
        }
        try {
            toByteArray = aVar.toByteArray();
        } catch (Throwable e) {
            w.e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf rsaReqData toProtoBuf exception:%s", bg.g(e));
            toByteArray = null;
        }
        if (bg.bm(toByteArray)) {
            w.e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf rsaReqDataBuf is null and ret false");
            return null;
        }
        byte[] toByteArray2;
        try {
            toByteArray2 = aVar2.toByteArray();
        } catch (Throwable e2) {
            w.e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf aesReqData toProtoBuf exception:%s", bg.g(e2));
            toByteArray2 = null;
        }
        if (bg.bm(toByteArray2)) {
            w.e("MicroMsg.RemoteReq", "summerauth toRsaAesByteArray reqToBuf aesReqDataBuf is null and ret false");
            return null;
        }
        return new byte[][]{toByteArray, toByteArray2};
    }

    public final byte[] Cf() {
        return this.htF;
    }

    public final void B(byte[] bArr) {
        d dVar = this.hsz;
        if (bArr == null) {
            bArr = new byte[0];
        }
        dVar.aMt = bArr;
    }

    public final byte[] vc() {
        return this.hsz.aMt;
    }

    public final void dj(int i) {
        this.hsz.dj(i);
    }

    public final int uH() {
        return this.hsz.sZs;
    }

    public final void fr(int i) {
        this.hsz.sZt = i;
    }

    public final int getClientVersion() {
        return this.hsz.sZt;
    }

    public final void hx(String str) {
        this.hsz.sZu = str;
    }

    public final String Cg() {
        return this.hsz.sZu;
    }

    public final String Ch() {
        return this.hsz.sZv;
    }

    public final void hy(String str) {
        this.hsz.sZv = str;
    }

    public final void fs(int i) {
        this.hsz.sZw = i;
    }

    public final int Ci() {
        return this.hsz.sZw;
    }

    public final byte[] Cj() {
        w.d("MicroMsg.RemoteReq", "dkrsa getpass type:%d", Integer.valueOf(this.type));
        switch (this.type) {
            case 126:
                return ((y.a) this.hsz).tae.tjF.tZp.toByteArray();
            case 381:
                return ((com.tencent.mm.protocal.r.a) this.hsz).sZU.tjF.tZp.toByteArray();
            case 701:
                return ((i.d) this.hsz).sZj.tOB.tjF.tZp.toByteArray();
            case 702:
                return ((i.a) this.hsz).sZh.thG.thI.tZp.toByteArray();
            default:
                if (htE != null) {
                    byte[] a = htE.a(this.hsz, this.type);
                    if (a != null) {
                        return a;
                    }
                }
                if (this.hsz.sZz != null) {
                    return this.hsz.sZz;
                }
                return vc();
        }
    }

    public final String getPassword() {
        switch (this.type) {
            case 126:
                return ((y.a) this.hsz).tae.tjK;
            case 701:
                return ((i.d) this.hsz).sZj.tOB.tjK;
            default:
                return "";
        }
    }

    public final String Ck() {
        switch (this.type) {
            case 701:
                return ((i.d) this.hsz).sZj.tOB.tjU;
            default:
                return "";
        }
    }

    public final String getUserName() {
        switch (this.type) {
            case 126:
                return ((y.a) this.hsz).tae.jNj;
            case 701:
                return ((i.d) this.hsz).sZj.tOB.jNj;
            case 702:
                return ((i.a) this.hsz).username;
            default:
                return "";
        }
    }

    public final int getCmdId() {
        return this.hsz.getCmdId();
    }

    public final boolean Cl() {
        return this.hsz.Cl();
    }
}
