package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aqu;
import com.tencent.mm.protocal.c.awf;
import com.tencent.mm.protocal.c.awg;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.Map;

public final class z extends k implements j {
    public int errCode;
    public int errType;
    public long fGM = -1;
    public com.tencent.mm.y.b gUA;
    private e gUD;
    private final long hSU = 60000;
    private Runnable hSV;

    public static final class a {
        public String desc = "";
        public String hSW = "";
        public String hSX = "";
        public int type = 5;
    }

    public static final class b {
        public String desc;
        public LinkedList<a> hSY;
        public String title;

        public static LinkedList<a> e(Map<String, String> map, String str) {
            LinkedList<a> linkedList = new LinkedList();
            int i = 0;
            while (i < 1000) {
                String str2 = str + ".action" + (i > 0 ? Integer.valueOf(i) : "");
                try {
                    int intValue = Integer.valueOf((String) map.get(str2 + ".$type")).intValue();
                    a aVar = new a();
                    if (intValue != 5) {
                        return linkedList;
                    }
                    aVar.hSW = bg.mz((String) map.get(str2 + ".iconurl"));
                    aVar.desc = bg.mz((String) map.get(str2 + ".desc"));
                    aVar.hSX = bg.mz((String) map.get(str2 + ".link"));
                    if (bg.mA(aVar.hSW) && bg.mA(aVar.desc) && bg.mA(aVar.hSX)) {
                        return linkedList;
                    }
                    linkedList.add(aVar);
                    i++;
                } catch (Exception e) {
                    w.w("MicroMsg.NetSceneScanStreetView", "parseVendorsFromXml() " + e.getMessage());
                    return linkedList;
                }
            }
            return linkedList;
        }
    }

    public z(float f, float f2, long j) {
        aqu com_tencent_mm_protocal_c_aqu = new aqu();
        com_tencent_mm_protocal_c_aqu.tmZ = f;
        com_tencent_mm_protocal_c_aqu.tna = f2;
        com_tencent_mm_protocal_c_aqu.twT = 1;
        com_tencent_mm_protocal_c_aqu.twQ = 0;
        a(com_tencent_mm_protocal_c_aqu, 1, -10000.0f, -10000.0f);
        this.fGM = j;
    }

    public z(awf com_tencent_mm_protocal_c_awf) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = com_tencent_mm_protocal_c_awf;
        aVar.hsn = new awg();
        aVar.uri = "/cgi-bin/micromsg-bin/scanstreetview";
        aVar.hsl = 424;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
    }

    public z(aqu com_tencent_mm_protocal_c_aqu, float f, float f2) {
        a(com_tencent_mm_protocal_c_aqu, 0, f, f2);
    }

    private void a(aqu com_tencent_mm_protocal_c_aqu, int i, float f, float f2) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new awf();
        aVar.hsn = new awg();
        aVar.uri = "/cgi-bin/micromsg-bin/scanstreetview";
        aVar.hsl = 424;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        awf com_tencent_mm_protocal_c_awf = (awf) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_awf.tZx = com_tencent_mm_protocal_c_aqu;
        com_tencent_mm_protocal_c_awf.tdM = i;
        com_tencent_mm_protocal_c_awf.tZy = f;
        com_tencent_mm_protocal_c_awf.tZz = f2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    protected final int a(p pVar) {
        if (((awf) ((com.tencent.mm.y.b) pVar).hsj.hsr).tZx != null) {
            return com.tencent.mm.y.k.b.hsT;
        }
        w.e("MicroMsg.NetSceneScanStreetView", "req.rImpl.UserPos == null");
        return com.tencent.mm.y.k.b.hsU;
    }

    public final awg Jw() {
        if (this.gUA == null || this.gUA.hsk.hsr == null) {
            return null;
        }
        return (awg) this.gUA.hsk.hsr;
    }

    protected final int ub() {
        return 10;
    }

    protected final void a(com.tencent.mm.y.k.a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneScanStreetView", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.errType = i2;
        this.errCode = i3;
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        } else {
            w.e("MicroMsg.NetSceneScanStreetView", "callback null");
        }
        w.d("MicroMsg.NetSceneScanStreetView", "xml is %s", new Object[]{Jw().tlo});
        if (this.hSV != null) {
            this.hSV.run();
        }
    }

    public final int getType() {
        return 424;
    }

    public static String kD(String str) {
        Map q = bh.q(str, "streetview");
        if (q == null) {
            return null;
        }
        return (String) q.get(".streetview.link");
    }
}
