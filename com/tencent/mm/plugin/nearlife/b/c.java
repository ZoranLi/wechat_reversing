package com.tencent.mm.plugin.nearlife.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aix;
import com.tencent.mm.protocal.c.aiy;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.zf;
import com.tencent.mm.protocal.c.zg;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public final class c extends k implements j {
    public static Vector<String> nXk = new Vector();
    public int fJA = 0;
    private final b gUA;
    private e gUD;
    public String iGy = "";
    public String nXl = "";
    public String nXm = "";
    public List<a> nXn;
    public boolean nXo;
    public int nbg;

    public static boolean qq(int i) {
        String valueOf = String.valueOf(i);
        if (nXk.contains(valueOf)) {
            return false;
        }
        nXk.add(valueOf);
        return true;
    }

    public static boolean qr(int i) {
        nXk.remove(String.valueOf(i));
        return true;
    }

    public static void clear() {
        nXk.clear();
    }

    public c(int i, int i2, float f, float f2, int i3, int i4, String str, String str2, avw com_tencent_mm_protocal_c_avw, String str3, int i5, boolean z) {
        this.nXl = str3;
        if (!(i == 0 || i == 1)) {
            w.e("MicroMsg.NetSceneGetLbsLifeList", "OpCode Error :" + i);
        }
        this.fJA = i;
        a aVar = new a();
        aVar.hsm = new zf();
        aVar.hsn = new zg();
        aVar.uri = "/cgi-bin/micromsg-bin/getlbslifelist";
        aVar.hsl = 603;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        zf zfVar = (zf) this.gUA.hsj.hsr;
        aiy com_tencent_mm_protocal_c_aiy = new aiy();
        com_tencent_mm_protocal_c_aiy.twS = str2;
        com_tencent_mm_protocal_c_aiy.twT = i4;
        com_tencent_mm_protocal_c_aiy.tna = f2;
        com_tencent_mm_protocal_c_aiy.tmZ = f;
        com_tencent_mm_protocal_c_aiy.twR = str;
        com_tencent_mm_protocal_c_aiy.twQ = i3;
        zfVar.ttj = com_tencent_mm_protocal_c_aiy;
        zfVar.tAN = str3;
        zfVar.tdM = i2;
        zfVar.tFv = i5;
        if (com_tencent_mm_protocal_c_avw == null) {
            zfVar.tFu = new avw().bb(new byte[0]);
        } else {
            zfVar.tFu = com_tencent_mm_protocal_c_avw;
        }
        zfVar.thO = i;
        zfVar.tFw = 1;
        this.nXo = z;
        w.d("MicroMsg.NetSceneGetLbsLifeList", "Req: opcode:" + i + " lon:" + f + " lat:" + f2 + " pre:" + i3 + " gpsSource:" + i4 + " mac" + str + " cell:" + str2 + " scene: " + i2 + " entryTime: " + i5);
        w.d("MicroMsg.NetSceneGetLbsLifeList", "isLoadMore: %s, buf: %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(zfVar.tFu.tZn)});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 603;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGetLbsLifeList", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        zg zgVar = (zg) ((b) pVar).hsk.hsr;
        this.iGy = zgVar.tmb;
        this.nbg = zgVar.tFE;
        w.d("MicroMsg.NetSceneGetLbsLifeList", "resp " + zgVar.tFB + "searchId " + this.iGy);
        int i4 = (i3 == 0 || i3 == 101) ? 1 : 0;
        if (i2 == 0 || i4 != 0) {
            w.d("MicroMsg.NetSceneGetLbsLifeList", "continueFlag %d lifeCount %d linkCount %d %s", new Object[]{Integer.valueOf(zgVar.tlZ), Integer.valueOf(zgVar.tFB), Integer.valueOf(zgVar.tFz), zgVar.tFD});
            this.nXm = bg.ap(zgVar.tFD, "");
            this.nXn = new ArrayList();
            Iterator it = zgVar.tFC.iterator();
            while (it.hasNext()) {
                this.nXn.add(new a(zgVar.tmb, (aix) it.next()));
            }
            if (zgVar.tFB > 0) {
                aix com_tencent_mm_protocal_c_aix = (aix) zgVar.tFC.get(0);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(" Bid " + com_tencent_mm_protocal_c_aix.nWY);
                stringBuffer.append(" title " + com_tencent_mm_protocal_c_aix.fDC);
                stringBuffer.append(" link " + com_tencent_mm_protocal_c_aix.nXf);
                stringBuffer.append(" price " + com_tencent_mm_protocal_c_aix.nWZ);
                stringBuffer.append(" rate " + com_tencent_mm_protocal_c_aix.nXe);
                stringBuffer.append(" type " + com_tencent_mm_protocal_c_aix.jOc);
                stringBuffer.append(" desc : ");
                it = com_tencent_mm_protocal_c_aix.nXd.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(((avx) it.next()).tZr + "-");
                }
                w.d("MicroMsg.NetSceneGetLbsLifeList", "resp one %s ", new Object[]{stringBuffer.toString()});
            }
            this.gUD.a(i2, i3, str, this);
            return;
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final avw aOL() {
        avw com_tencent_mm_protocal_c_avw = ((zg) this.gUA.hsk.hsr).tFu;
        return com_tencent_mm_protocal_c_avw == null ? new avw().bb(new byte[0]) : com_tencent_mm_protocal_c_avw;
    }

    public final int aOM() {
        return ((zg) this.gUA.hsk.hsr).tlZ;
    }
}
