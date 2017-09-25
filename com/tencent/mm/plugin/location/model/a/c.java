package com.tencent.mm.plugin.location.model.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.auj;
import com.tencent.mm.protocal.c.auk;
import com.tencent.mm.protocal.c.bfj;
import com.tencent.mm.protocal.c.biq;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c extends k implements j {
    public final b gUA;
    private e gUD;
    private Runnable hSV;
    public String kAZ;
    public int ncA;
    private String ncB;
    public int ncw;
    public bfj ncx = null;
    public List<biq> ncy = null;
    public auk ncz;

    public c(String str, int i, biq com_tencent_mm_protocal_c_biq, int i2, bfj com_tencent_mm_protocal_c_bfj) {
        a aVar = new a();
        aVar.hsm = new auj();
        aVar.hsn = new auk();
        aVar.uri = "/cgi-bin/micromsg-bin/refreshtrackroom";
        aVar.hsl = 492;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        auj com_tencent_mm_protocal_c_auj = (auj) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_auj.tvV = str;
        com_tencent_mm_protocal_c_auj.jOc = i;
        com_tencent_mm_protocal_c_auj.tYa = com_tencent_mm_protocal_c_biq;
        com_tencent_mm_protocal_c_auj.mtE = i2;
        com_tencent_mm_protocal_c_auj.tYb = com_tencent_mm_protocal_c_bfj;
        this.ncB = str;
        this.ncA = com_tencent_mm_protocal_c_auj.jOc;
        w.d("MicroMsg.NetSceneRefreshTrackRoom", "userPosiItem " + com_tencent_mm_protocal_c_biq.tgG + " " + com_tencent_mm_protocal_c_biq.uiu.tle + " " + com_tencent_mm_protocal_c_biq.uiu.tld + " heading:" + com_tencent_mm_protocal_c_biq.uiu.tVp);
        w.d("MicroMsg.NetSceneRefreshTrackRoom", "userPoi " + com_tencent_mm_protocal_c_bfj.tle + " " + com_tencent_mm_protocal_c_bfj.tld + " " + com_tencent_mm_protocal_c_bfj.msj);
        w.d("MicroMsg.NetSceneRefreshTrackRoom", "trackRoomId:" + str + " uploadStatus:" + i);
    }

    public final int getType() {
        return 492;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.ncz = (auk) ((b) pVar).hsk.hsr;
        if (this.ncz != null) {
            this.kAZ = this.ncz.tns;
        }
        if (i2 == 0 && i3 == 0) {
            this.ncw = this.ncz.tMk;
            this.ncx = this.ncz.tYd;
            this.ncy = this.ncz.tYc;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(String.format("[ resp count %d ] ", new Object[]{Integer.valueOf(this.ncz.jNd)}));
            if (this.ncx != null) {
                stringBuffer.append(String.format("[ roomPoi  %f %f %s] ", new Object[]{Double.valueOf(this.ncx.tle), Double.valueOf(this.ncx.tld), this.ncx.msj}));
            }
            w.d("MicroMsg.NetSceneRefreshTrackRoom", "onGynetEnd " + stringBuffer.toString());
            List linkedList = new LinkedList();
            Iterator it = this.ncz.tYc.iterator();
            while (it.hasNext()) {
                biq com_tencent_mm_protocal_c_biq = (biq) it.next();
                if (com_tencent_mm_protocal_c_biq == null) {
                    linkedList.add(com_tencent_mm_protocal_c_biq);
                } else {
                    if (com_tencent_mm_protocal_c_biq.uiu == null) {
                        linkedList.add(com_tencent_mm_protocal_c_biq);
                    }
                    if (Math.abs(com_tencent_mm_protocal_c_biq.uiu.tld) > 180.0d || Math.abs(com_tencent_mm_protocal_c_biq.uiu.tle) > 90.0d) {
                        w.w("MicroMsg.NetSceneRefreshTrackRoom", "server lat lng invalid %s %f %f %f", new Object[]{com_tencent_mm_protocal_c_biq.tgG, Double.valueOf(com_tencent_mm_protocal_c_biq.uiu.tle), Double.valueOf(com_tencent_mm_protocal_c_biq.uiu.tld), Double.valueOf(com_tencent_mm_protocal_c_biq.uiu.tVp)});
                        linkedList.add(com_tencent_mm_protocal_c_biq);
                    }
                }
            }
            this.ncz.jNd = this.ncz.tYc.size();
        }
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
        if (this.hSV != null) {
            this.hSV.run();
        }
    }
}
