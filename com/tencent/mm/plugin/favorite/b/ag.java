package com.tencent.mm.plugin.favorite.b;

import android.util.SparseArray;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.azx;
import com.tencent.mm.protocal.c.azy;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;

public final class ag extends k implements j {
    private final b gUA;
    private e gUD = null;
    private List<Integer> lFK;
    private a lFL = null;
    private SparseArray<String> lFM = new SparseArray();
    private int scene;
    private String toUser;

    public interface a {
        void a(SparseArray<String> sparseArray);
    }

    public ag(String str, List<Integer> list, a aVar) {
        com.tencent.mm.y.b.a aVar2 = new com.tencent.mm.y.b.a();
        aVar2.hsm = new azx();
        aVar2.hsn = new azy();
        aVar2.uri = "/cgi-bin/micromsg-bin/sharefav";
        aVar2.hsl = 608;
        aVar2.hso = 246;
        aVar2.hsp = 1000000246;
        this.gUA = aVar2.BE();
        this.toUser = str;
        this.scene = 2;
        this.lFK = list;
        this.lFL = aVar;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneShareFavItem", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.lFM.clear();
        if (i2 == 0 && i3 == 0) {
            azy com_tencent_mm_protocal_c_azy = (azy) ((b) pVar).hsk.hsr;
            if (com_tencent_mm_protocal_c_azy.tHD != this.lFK.size()) {
                w.w("MicroMsg.NetSceneShareFavItem", "get url error, request count %d, response count %d", new Object[]{Integer.valueOf(this.lFK.size()), Integer.valueOf(com_tencent_mm_protocal_c_azy.tHD)});
            }
            int i4 = 0;
            while (i4 < com_tencent_mm_protocal_c_azy.ubi.size() && i4 < this.lFK.size()) {
                w.d("MicroMsg.NetSceneShareFavItem", "id[%d] url=%s", new Object[]{this.lFK.get(i4), com_tencent_mm_protocal_c_azy.ubi.get(i4)});
                this.lFM.put(((Integer) this.lFK.get(i4)).intValue(), ((avx) com_tencent_mm_protocal_c_azy.ubi.get(i4)).tZr);
                i4++;
            }
        }
        this.gUD.a(i2, i3, str, this);
        if (this.lFL != null) {
            this.lFL.a(this.lFM);
        }
    }

    public final int getType() {
        return 608;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        azx com_tencent_mm_protocal_c_azx = (azx) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_azx.ubh = this.toUser;
        com_tencent_mm_protocal_c_azx.tdM = this.scene;
        com_tencent_mm_protocal_c_azx.tiH = new LinkedList(this.lFK);
        com_tencent_mm_protocal_c_azx.jNd = com_tencent_mm_protocal_c_azx.tiH.size();
        w.d("MicroMsg.NetSceneShareFavItem", "do scene %s %d %s %d", new Object[]{com_tencent_mm_protocal_c_azx.ubh, Integer.valueOf(com_tencent_mm_protocal_c_azx.tdM), com_tencent_mm_protocal_c_azx.tiH, Integer.valueOf(com_tencent_mm_protocal_c_azx.jNd)});
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
