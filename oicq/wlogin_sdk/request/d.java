package oicq.wlogin_sdk.request;

import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import java.lang.reflect.Array;
import oicq.wlogin_sdk.a.a;
import oicq.wlogin_sdk.a.ab;
import oicq.wlogin_sdk.a.ac;
import oicq.wlogin_sdk.a.ad;
import oicq.wlogin_sdk.a.af;
import oicq.wlogin_sdk.a.ah;
import oicq.wlogin_sdk.a.ai;
import oicq.wlogin_sdk.a.ak;
import oicq.wlogin_sdk.a.al;
import oicq.wlogin_sdk.a.am;
import oicq.wlogin_sdk.a.ap;
import oicq.wlogin_sdk.a.e;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.g;
import oicq.wlogin_sdk.a.h;
import oicq.wlogin_sdk.a.j;
import oicq.wlogin_sdk.a.l;
import oicq.wlogin_sdk.a.m;
import oicq.wlogin_sdk.a.n;
import oicq.wlogin_sdk.a.o;
import oicq.wlogin_sdk.a.p;
import oicq.wlogin_sdk.a.q;
import oicq.wlogin_sdk.a.s;
import oicq.wlogin_sdk.a.t;
import oicq.wlogin_sdk.a.u;
import oicq.wlogin_sdk.a.v;
import oicq.wlogin_sdk.a.w;
import oicq.wlogin_sdk.a.x;
import oicq.wlogin_sdk.a.z;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

public class d {
    protected static int xnj = 0;
    int xnb = Downloads.RECV_BUFFER_SIZE;
    int xnc = 0;
    int xnd = 27;
    int xne = 0;
    public int xnf = 15;
    protected int xng = 0;
    protected byte[] xnh = new byte[this.xnb];
    protected int xni = 8001;
    protected int xnk = 0;
    protected int xnl = 0;
    protected int xnm = 0;
    protected int xnn = 0;
    protected int xno = 0;
    byte xnp;
    protected i xnq;

    public final void a(int i, int i2, int i3, long j, int i4, int i5, int i6, int i7, byte[] bArr) {
        int length = bArr.length;
        int i8 = xnj + 1;
        xnj = i8;
        this.xnc = 0;
        util.o(this.xnh, this.xnc, 2);
        this.xnc++;
        util.p(this.xnh, this.xnc, (this.xnd + 2) + length);
        this.xnc += 2;
        util.p(this.xnh, this.xnc, i);
        this.xnc += 2;
        util.p(this.xnh, this.xnc, i2);
        this.xnc += 2;
        util.p(this.xnh, this.xnc, i8);
        this.xnc += 2;
        util.q(this.xnh, this.xnc, (int) j);
        this.xnc += 4;
        util.o(this.xnh, this.xnc, 3);
        this.xnc++;
        util.o(this.xnh, this.xnc, 0);
        this.xnc++;
        util.o(this.xnh, this.xnc, i4);
        this.xnc++;
        util.q(this.xnh, this.xnc, i5);
        this.xnc += 4;
        util.q(this.xnh, this.xnc, i6);
        this.xnc += 4;
        util.q(this.xnh, this.xnc, i7);
        this.xnc += 4;
        if ((this.xnc + length) + 1 > this.xnb) {
            this.xnb = ((this.xnc + length) + 1) + FileUtils.S_IWUSR;
            Object obj = new byte[this.xnb];
            System.arraycopy(this.xnh, 0, obj, 0, this.xnc);
            this.xnh = obj;
        }
        System.arraycopy(bArr, 0, this.xnh, this.xnc, length);
        this.xnc = length + this.xnc;
        util.o(this.xnh, this.xnc, 3);
        this.xnc++;
    }

    public final int F(byte[] bArr, int i) {
        int i2 = 0;
        if (i <= this.xnf + 2) {
            return -1009;
        }
        this.xng = (i - this.xnf) - 2;
        if (i > this.xnb) {
            this.xnb = i + FileUtils.S_IWUSR;
            this.xnh = new byte[this.xnb];
        }
        this.xnc = i;
        System.arraycopy(bArr, 0, this.xnh, 0, i);
        int i3 = this.xnf + 1;
        Object decrypt = oicq.wlogin_sdk.tools.d.decrypt(this.xnh, i3, this.xng, this.xnq.xnu);
        if (decrypt == null) {
            i2 = -1002;
        } else {
            this.xng = decrypt.length;
            if ((decrypt.length + this.xnf) + 2 > this.xnb) {
                this.xnb = (decrypt.length + this.xnf) + 2;
                Object obj = new byte[this.xnb];
                System.arraycopy(this.xnh, 0, obj, 0, this.xnc);
                this.xnh = obj;
            }
            this.xnc = 0;
            System.arraycopy(decrypt, 0, this.xnh, i3, decrypt.length);
            this.xnc = (decrypt.length + (this.xnf + 2)) + this.xnc;
        }
        if (i2 >= 0) {
            return l(this.xnh, this.xnf + 1, this.xng);
        }
        return -1002;
    }

    public final byte[] cil() {
        Object obj = new byte[this.xnc];
        System.arraycopy(this.xnh, 0, obj, 0, this.xnc);
        return obj;
    }

    final byte[] j(byte[] bArr, int i, int i2) {
        Object obj = new byte[(bArr.length + 4)];
        util.p(obj, 0, i);
        util.p(obj, 2, i2);
        System.arraycopy(bArr, 0, obj, 4, bArr.length);
        obj = oicq.wlogin_sdk.tools.d.b(obj, obj.length, this.xnq.xnu);
        Object obj2 = new byte[(obj.length + this.xnq.xnu.length)];
        System.arraycopy(this.xnq.xnu, 0, obj2, 0, this.xnq.xnu.length);
        System.arraycopy(obj, 0, obj2, this.xnq.xnu.length, obj.length);
        return obj2;
    }

    public final int G(byte[] bArr, int i) {
        this.xnp = bArr[i];
        return bArr[i] & 255;
    }

    public final void k(byte[] bArr, int i, int i2) {
        a aiVar = new ai();
        if (aiVar.n(bArr, i, i2) >= 0) {
            ErrMsg errMsg = this.xnq.xnQ;
            Object obj = new byte[aiVar.xoF];
            System.arraycopy(aiVar.xnh, aiVar.xnW + 6, obj, 0, aiVar.xoF);
            errMsg.title = new String(obj);
            errMsg = this.xnq.xnQ;
            obj = new byte[aiVar.xoG];
            System.arraycopy(aiVar.xnh, (aiVar.xnW + 8) + aiVar.xoF, obj, 0, aiVar.xoG);
            errMsg.message = new String(obj);
            errMsg = this.xnq.xnQ;
            obj = new byte[aiVar.xoH];
            System.arraycopy(aiVar.xnh, ((aiVar.xnW + 12) + aiVar.xoF) + aiVar.xoG, obj, 0, aiVar.xoH);
            errMsg.xoO = new String(obj);
            return;
        }
        this.xnq.xnQ.cis();
    }

    public final void cim() {
        this.xnq.xnQ.cis();
    }

    public final byte[] bJ(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[(bArr.length + this.xnq.xns.length)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(this.xnq.xns, 0, bArr2, bArr.length, this.xnq.xns.length);
        return bArr2;
    }

    public final byte[] bK(byte[] bArr) {
        if (bArr == null || bArr.length < 16) {
            return null;
        }
        byte[] bArr2 = (byte[]) bArr.clone();
        int length = bArr2.length - 16;
        Object obj = new byte[length];
        System.arraycopy(bArr2, 0, obj, 0, length);
        this.xnq.xns = new byte[16];
        System.arraycopy(bArr2, length, this.xnq.xns, 0, 16);
        return obj;
    }

    private int a(s sVar) {
        long j = 4294967295L;
        a oVar = new o();
        a pVar = new p();
        a lVar = new l();
        a qVar = new q();
        a eVar = new e();
        a tVar = new t();
        a dVar = new oicq.wlogin_sdk.a.d();
        a mVar = new m();
        a uVar = new u();
        a wVar = new w();
        a xVar = new x();
        a jVar = new j();
        a hVar = new h();
        a nVar = new n();
        a zVar = new z();
        a vVar = new v();
        a adVar = new ad();
        a abVar = new ab();
        a afVar = new af();
        a apVar = new ap();
        a akVar = new ak();
        a alVar = new al();
        a amVar = new am();
        byte[] bArr = null;
        byte[] bArr2 = null;
        byte[] bArr3 = null;
        byte[] bArr4 = null;
        byte[] bArr5 = null;
        byte[] bArr6 = null;
        byte[] bArr7 = null;
        byte[] bArr8 = null;
        a acVar = new ac();
        byte[] cio = sVar.cio();
        int length = cio.length;
        oVar.n(cio, 2, length);
        pVar.n(cio, 2, length);
        lVar.n(cio, 2, length);
        qVar.n(cio, 2, length);
        int n = tVar.n(cio, 2, length);
        if (n < 0) {
            return n;
        }
        Object obj;
        long L;
        long j2;
        long j3;
        if (eVar.n(cio, 2, length) >= 0) {
            bArr6 = eVar.cio();
        }
        if (jVar.n(cio, 2, length) >= 0) {
            util.a(this.xnq.xmZ, jVar.cio());
        }
        if (dVar.n(cio, 2, length) >= 0) {
            bArr = dVar.cio();
        }
        if (mVar.n(cio, 2, length) >= 0) {
            bArr2 = mVar.cio();
        }
        if (uVar.n(cio, 2, length) >= 0) {
            bArr3 = uVar.cio();
        }
        if (wVar.n(cio, 2, length) >= 0) {
            bArr4 = wVar.cio();
        }
        if (xVar.n(cio, 2, length) >= 0) {
            bArr5 = xVar.cio();
        }
        if (zVar.n(cio, 2, length) >= 0) {
            bArr7 = new byte[zVar.xov];
            System.arraycopy(zVar.xnh, zVar.xnW + 2, bArr7, 0, bArr7.length);
            bArr8 = new byte[zVar.xow];
            System.arraycopy(zVar.xnh, ((zVar.xnW + 2) + zVar.xov) + 2, bArr8, 0, bArr8.length);
        }
        if (alVar.n(cio, 2, length) >= 0) {
            a hVar2 = new h();
            eVar = new n();
            dVar = new am();
            ah ahVar = new ah();
            byte[] cio2 = alVar.cio();
            int length2 = cio2.length;
            if (hVar2.n(cio2, 2, length2) < 0) {
                obj = null;
            } else if (eVar.n(cio2, 2, length2) < 0) {
                obj = null;
            } else if (dVar.n(cio2, 2, length2) < 0) {
                obj = null;
            } else {
                Object cil = hVar2.cil();
                obj = eVar.cil();
                Object cil2 = dVar.cil();
                Object bQ = ahVar.bQ(this.xnq.xnB);
                Object obj2 = new byte[((((cil.length + 3) + obj.length) + cil2.length) + bQ.length)];
                obj2[0] = (byte) 64;
                util.p(obj2, 1, 4);
                System.arraycopy(cil, 0, obj2, 3, cil.length);
                int length3 = cil.length + 3;
                System.arraycopy(obj, 0, obj2, length3, obj.length);
                int length4 = obj.length + length3;
                System.arraycopy(cil2, 0, obj2, length4, cil2.length);
                System.arraycopy(bQ, 0, obj2, length4 + cil2.length, bQ.length);
                obj = obj2;
            }
            if (obj == null || obj.length <= 0) {
                this.xnq.xnT = new byte[0];
            } else {
                this.xnq.xnT = (byte[]) obj.clone();
                util.fp("fast data:", util.bU(obj));
            }
        }
        byte[][] bArr9 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{7, 0});
        if (acVar.n(cio, 2, length) >= 0) {
            bArr9[0] = acVar.cio();
        }
        n = nVar.n(cio, 2, length);
        if (hVar.n(cio, 2, length) >= 0 && n >= 0) {
            this.xnq.xns = nVar.cio();
            this.xnq.xnR = bJ(hVar.cio());
            bArr9[1] = (byte[]) this.xnq.xnR.clone();
        }
        if (abVar.n(cio, 2, length) >= 0) {
            obj = new byte[abVar.xoy];
            System.arraycopy(abVar.xnh, abVar.xnW + 2, obj, 0, obj.length);
            bArr9[2] = obj;
        }
        if (afVar.n(cio, 2, length) >= 0) {
            bArr9[3] = afVar.cio();
        }
        if (apVar.n(cio, 2, length) >= 0) {
            bArr9[4] = apVar.cio();
        }
        if (akVar.n(cio, 2, length) >= 0) {
            bArr9[5] = akVar.cio();
        }
        if (amVar.n(cio, 2, length) >= 0) {
            bArr9[6] = amVar.cio();
        }
        if (vVar.n(cio, 2, length) >= 0) {
            if (this.xnq.xnz == -1) {
                L = (long) util.L(vVar.xnh, vVar.xnW);
            } else {
                L = this.xnq.xnz;
            }
            j = 4294967295L & ((long) util.L(vVar.xnh, vVar.xnW + 4));
            j2 = L;
        } else {
            j2 = 3600;
        }
        if (adVar.n(cio, 2, length) < 0 || adVar.cir() == 0) {
            L = 2160000;
        } else {
            L = (long) adVar.cir();
        }
        if (L < j2) {
            j3 = j2;
        } else {
            j3 = L;
        }
        i iVar = this.xnq;
        long j4 = this.xnq._uin;
        long j5 = this.xnq.xnx;
        long cin = i.cin();
        j2 += i.cin();
        j3 += i.cin();
        Object obj3 = new byte[2];
        System.arraycopy(tVar.xnh, tVar.xnW, obj3, 0, 2);
        Object obj4 = new byte[1];
        System.arraycopy(tVar.xnh, tVar.xnW + 2, obj4, 0, 1);
        Object obj5 = new byte[1];
        System.arraycopy(tVar.xnh, (tVar.xnW + 2) + 1, obj5, 0, 1);
        Object obj6 = new byte[tVar.xot];
        System.arraycopy(tVar.xnh, (((tVar.xnW + 2) + 1) + 1) + 1, obj6, 0, tVar.xot);
        iVar.a(j4, j5, j, cin, j2, j3, obj3, obj4, obj5, obj6, lVar.cio(), oVar.cio(), qVar.cio(), pVar.cio(), bArr6, bArr2, bArr, bArr3, bArr4, bArr5, bArr7, bArr8, bArr9);
        return 0;
    }

    public int l(byte[] bArr, int i, int i2) {
        a fVar = new f();
        a gVar = new g();
        a sVar = new s();
        if (this.xnn == 2064 && this.xno == 9) {
            Object obj = null;
        } else if (this.xnn == 2064 && this.xno == 10) {
            r2 = 1;
        } else if (this.xnn == 2064 && this.xno == 2) {
            r2 = 2;
        } else if (this.xnn != 2064 || this.xno != 13) {
            return -1012;
        } else {
            r2 = 4;
        }
        if (i2 < 5) {
            return -1009;
        }
        int G = G(bArr, i + 2);
        cim();
        int i3 = i + 5;
        switch (G) {
            case 0:
                if (obj != 1) {
                    G = sVar.b(bArr, i3, (this.xnc - i3) - 1, this.xnq.xns);
                } else if (this.xnq.xnt == null) {
                    return -1006;
                } else {
                    G = sVar.b(bArr, i3, (this.xnc - i3) - 1, this.xnq.xnt);
                }
                if (G < 0) {
                    util.Wt("119 can not decrypt, ret=" + G);
                    return G;
                }
                G = a(sVar);
                if (G >= 0) {
                    return 0;
                }
                util.Wt("parse 119 failed, ret=" + G);
                return G;
            case 1:
                k(bArr, i3, (this.xnc - i3) - 1);
                return G;
            case 2:
                int n = fVar.n(bArr, i3, (this.xnc - i3) - 1);
                if (n >= 0) {
                    this.xnq.xnv = fVar;
                    n = gVar.n(bArr, i3, (this.xnc - i3) - 1);
                    if (n >= 0) {
                        this.xnq.xnw = gVar;
                        return G;
                    }
                }
                return n;
            default:
                k(bArr, i3, (this.xnc - i3) - 1);
                return G;
        }
    }
}
