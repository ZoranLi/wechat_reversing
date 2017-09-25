package oicq.wlogin_sdk.request;

import com.tencent.wcdb.FileUtils;
import oicq.wlogin_sdk.a.a;
import oicq.wlogin_sdk.a.aa;
import oicq.wlogin_sdk.a.ae;
import oicq.wlogin_sdk.a.ag;
import oicq.wlogin_sdk.a.ah;
import oicq.wlogin_sdk.a.aj;
import oicq.wlogin_sdk.a.an;
import oicq.wlogin_sdk.a.b;
import oicq.wlogin_sdk.a.c;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.h;
import oicq.wlogin_sdk.a.i;
import oicq.wlogin_sdk.a.k;
import oicq.wlogin_sdk.a.r;
import oicq.wlogin_sdk.a.y;
import oicq.wlogin_sdk.tools.util;

public final class j extends d {
    public j(i iVar) {
        this.xnn = 2064;
        this.xno = 9;
        this.xnq = iVar;
    }

    public final byte[] a(long j, long j2, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3, byte[] bArr4) {
        Object bM;
        int i4 = this.xnq.xnA;
        this.xnq._uin = j2;
        util.fp("IMEI", util.bU(this.xnq.xnB));
        byte[] bArr5 = this.xnq.xns;
        byte[] bArr6 = this.xnq.xnB;
        byte[] cio = this.xnq.xnv.cio();
        byte[] bArr7 = this.xnq.xnF;
        an anVar = new an();
        b bVar = new b();
        a hVar = new h();
        r rVar = new r();
        c cVar = new c();
        i iVar = new i();
        oicq.wlogin_sdk.a.j jVar = new oicq.wlogin_sdk.a.j();
        k kVar = new k();
        f fVar = new f();
        y yVar = new y();
        aa aaVar = new aa();
        ae aeVar = new ae();
        ag agVar = new ag();
        ah ahVar = new ah();
        aj ajVar = new aj();
        Object a = anVar.a(522017402, i4, j2, 0);
        Object g = bVar.g(j2, bArr);
        Object a2 = hVar.a(522017402, i4, j2, bArr2, bArr, bArr3, bArr5, this.xnq.xnN, this.xnq.xnB);
        this.xnq.xnR = super.bJ(hVar.cio());
        Object a3 = cVar.a(522017402, 1, i4, 8256);
        Object x = iVar.x(0, 1, 102400, 1);
        Object a4 = rVar.a(i, i2, null);
        Object bQ = ahVar.bQ(this.xnq.xnB);
        int i5 = 7;
        Object obj = new byte[0];
        byte[] bArr8 = new byte[0];
        Object obj2 = new byte[0];
        Object obj3 = new byte[0];
        if (bArr4.length > 0) {
            obj = jVar.bN(bArr4);
            i5 = 8;
        }
        if (bArr6.length > 0) {
            bArr8 = kVar.bO(bArr6);
        }
        Object a5 = agVar.a(bArr8, yVar.a(util.cit(), util.ciu(), this.xnq.xnE, this.xnq.xnD, new byte[0], this.xnq.xnG), aaVar.a(this.xnq.xnM, this.xnq.xnN, this.xnq.xnO, this.xnq.xnK, this.xnq.xnB), ajVar.a(522017402, this.xnq.xnI, this.xnq.xnJ), this.xnq.xns);
        i5++;
        Object bP = aeVar.bP(bArr7);
        int i6 = i5 + 1;
        if (cio.length > 0) {
            bM = fVar.bM(cio);
            i6++;
        } else {
            bM = obj2;
        }
        Object obj4 = new byte[(((((((((((a.length + g.length) + a2.length) + a4.length) + a3.length) + x.length) + obj.length) + a5.length) + bM.length) + bP.length) + 0) + bQ.length)];
        System.arraycopy(a, 0, obj4, 0, a.length);
        int length = a.length + 0;
        System.arraycopy(g, 0, obj4, length, g.length);
        length += g.length;
        System.arraycopy(a2, 0, obj4, length, a2.length);
        length += a2.length;
        System.arraycopy(a4, 0, obj4, length, a4.length);
        length += a4.length;
        System.arraycopy(a3, 0, obj4, length, a3.length);
        length += a3.length;
        System.arraycopy(x, 0, obj4, length, x.length);
        length += x.length;
        System.arraycopy(obj, 0, obj4, length, obj.length);
        int length2 = obj.length + length;
        System.arraycopy(a5, 0, obj4, length2, a5.length);
        length2 += a5.length;
        System.arraycopy(bP, 0, obj4, length2, bP.length);
        length2 += bP.length;
        System.arraycopy(obj3, 0, obj4, length2, 0);
        length2 += 0;
        System.arraycopy(bM, 0, obj4, length2, bM.length);
        System.arraycopy(bQ, 0, obj4, bM.length + length2, bQ.length);
        long j3 = j2;
        int i7 = i4;
        a(this.xni, this.xnn, xnj, j3, this.xnk, this.xnl, i7, this.xnm, super.j(obj4, this.xno, i6));
        return super.cil();
    }

    public final byte[] a(long j, long j2, byte[] bArr, byte[] bArr2, int i, int i2, int i3, byte[] bArr3) {
        int i4 = this.xnq.xnA;
        this.xnq._uin = j2;
        Object bK = super.bK(bArr2);
        if (bK == null) {
            return null;
        }
        Object obj;
        byte[] bArr4 = this.xnq.xnB;
        byte[] cio = this.xnq.xnv.cio();
        byte[] bArr5 = this.xnq.xnF;
        an anVar = new an();
        b bVar = new b();
        a hVar = new h();
        r rVar = new r();
        c cVar = new c();
        i iVar = new i();
        oicq.wlogin_sdk.a.j jVar = new oicq.wlogin_sdk.a.j();
        k kVar = new k();
        f fVar = new f();
        y yVar = new y();
        aa aaVar = new aa();
        ae aeVar = new ae();
        ag agVar = new ag();
        ah ahVar = new ah();
        aj ajVar = new aj();
        Object a = anVar.a(522017402, i4, j2, 0);
        Object g = bVar.g(j2, bArr);
        this.xnq.xnR = super.bJ(bK);
        int length = bK.length;
        if (hVar.xnW + length > hVar.xnb) {
            hVar.xnb = (hVar.xnW + length) + FileUtils.S_IWUSR;
            obj = new byte[hVar.xnb];
            System.arraycopy(hVar.xnh, 0, obj, 0, hVar.xnW);
            hVar.xnh = obj;
        }
        hVar.xnc = hVar.xnW + length;
        System.arraycopy(bK, 0, hVar.xnh, hVar.xnW, length);
        hVar.xnX = length;
        util.p(hVar.xnh, 0, hVar.xnn);
        util.p(hVar.xnh, 2, hVar.xnX);
        Object cil = hVar.cil();
        util.fp("req2 a1:", util.bU(cil));
        Object a2 = cVar.a(522017402, 1, i4, 8256);
        Object x = iVar.x(0, 1, 102400, 1);
        Object a3 = rVar.a(i, i2, null);
        Object bQ = ahVar.bQ(this.xnq.xnB);
        int i5 = 7;
        Object obj2 = new byte[0];
        byte[] bArr6 = new byte[0];
        Object obj3 = new byte[0];
        Object obj4 = new byte[0];
        if (bArr3.length > 0) {
            obj2 = jVar.bN(bArr3);
            i5 = 8;
        }
        if (bArr4.length > 0) {
            bArr6 = kVar.bO(bArr4);
        }
        Object a4 = agVar.a(bArr6, yVar.a(util.cit(), util.ciu(), this.xnq.xnE, this.xnq.xnD, new byte[0], this.xnq.xnG), aaVar.a(this.xnq.xnM, this.xnq.xnN, this.xnq.xnO, this.xnq.xnK, this.xnq.xnB), ajVar.a(522017402, this.xnq.xnI, this.xnq.xnJ), this.xnq.xns);
        i5++;
        Object bP = aeVar.bP(bArr5);
        int i6 = i5 + 1;
        if (cio.length > 0) {
            obj = fVar.bM(cio);
            i6++;
        } else {
            obj = obj3;
        }
        Object obj5 = new byte[(((((((((((a.length + g.length) + cil.length) + a3.length) + a2.length) + x.length) + obj2.length) + a4.length) + obj.length) + bP.length) + 0) + bQ.length)];
        System.arraycopy(a, 0, obj5, 0, a.length);
        int length2 = a.length + 0;
        System.arraycopy(g, 0, obj5, length2, g.length);
        length2 += g.length;
        System.arraycopy(cil, 0, obj5, length2, cil.length);
        length2 += cil.length;
        System.arraycopy(a3, 0, obj5, length2, a3.length);
        length2 += a3.length;
        System.arraycopy(a2, 0, obj5, length2, a2.length);
        length2 += a2.length;
        System.arraycopy(x, 0, obj5, length2, x.length);
        length2 += x.length;
        System.arraycopy(obj2, 0, obj5, length2, obj2.length);
        length = obj2.length + length2;
        System.arraycopy(a4, 0, obj5, length, a4.length);
        length += a4.length;
        System.arraycopy(bP, 0, obj5, length, bP.length);
        length += bP.length;
        System.arraycopy(obj4, 0, obj5, length, 0);
        length += 0;
        System.arraycopy(obj, 0, obj5, length, obj.length);
        System.arraycopy(bQ, 0, obj5, length + obj.length, bQ.length);
        long j3 = j2;
        int i7 = i4;
        a(this.xni, this.xnn, xnj, j3, this.xnk, this.xnl, i7, this.xnm, super.j(obj5, this.xno, i6));
        return super.cil();
    }
}
