package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.exdevice.a.a;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.c.ach;
import com.tencent.mm.protocal.c.aci;
import com.tencent.mm.protocal.c.bdq;
import com.tencent.mm.protocal.c.brc;
import com.tencent.mm.protocal.c.brd;
import com.tencent.mm.protocal.c.id;
import com.tencent.mm.protocal.c.sk;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i extends a<ach, aci> {
    public String aJE;
    public String appName;
    private final WeakReference<b<i>> laR;
    public List<brd> lfA;
    public brc lfB;
    public ArrayList<String> lfC;
    public List<sk> lfD;
    public List<id> lfE;
    public boolean lfF;
    public int lfG;
    public boolean lfH;
    public String lfu;
    public String lfv;
    public String lfw;
    public String lfx;
    public String lfy;
    public List<bdq> lfz;
    public String username;

    protected final /* synthetic */ com.tencent.mm.bd.a aoL() {
        return new ach();
    }

    protected final /* synthetic */ com.tencent.mm.bd.a aoM() {
        return new aci();
    }

    protected final /* bridge */ /* synthetic */ void c(com.tencent.mm.bd.a aVar) {
        ach com_tencent_mm_protocal_c_ach = (ach) aVar;
        com_tencent_mm_protocal_c_ach.lmI = this.appName;
        com_tencent_mm_protocal_c_ach.username = this.username;
    }

    public i(String str, String str2, b<i> bVar) {
        w.d("MicroMsg.NetSceneGetProfileDetail", "appusername: %s, username: %s", new Object[]{str2, str});
        this.username = str;
        this.appName = str2;
        this.laR = new WeakReference(bVar);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        super.a(i, i2, i3, str, pVar, bArr);
        w.d("MicroMsg.NetSceneGetProfileDetail", "hy: getdetail scene gy end. errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            aci com_tencent_mm_protocal_c_aci = (aci) abn();
            this.lfv = com_tencent_mm_protocal_c_aci.tHQ;
            this.lfw = com_tencent_mm_protocal_c_aci.lfw;
            this.lfA = com_tencent_mm_protocal_c_aci.tHT;
            this.lfB = com_tencent_mm_protocal_c_aci.tHR;
            this.lfx = com_tencent_mm_protocal_c_aci.tHV;
            this.aJE = com_tencent_mm_protocal_c_aci.aJE;
            this.lfy = com_tencent_mm_protocal_c_aci.tHW;
            this.lfz = com_tencent_mm_protocal_c_aci.tfx;
            this.lfF = com_tencent_mm_protocal_c_aci.lfF;
            this.lfD = com_tencent_mm_protocal_c_aci.tfb;
            this.lfE = com_tencent_mm_protocal_c_aci.tHX;
            this.lfC = new ArrayList();
            this.lfG = com_tencent_mm_protocal_c_aci.lmk;
            this.lfH = com_tencent_mm_protocal_c_aci.tHY;
            this.lfu = com_tencent_mm_protocal_c_aci.lfu;
            if (com_tencent_mm_protocal_c_aci.tHU != null) {
                this.lfC.addAll(com_tencent_mm_protocal_c_aci.tHU);
            }
            this.lfz = new LinkedList();
            if (com_tencent_mm_protocal_c_aci.tfx != null) {
                this.lfz.addAll(com_tencent_mm_protocal_c_aci.tfx);
            }
            if (!(this.username == null || this.username.equalsIgnoreCase(m.xL()))) {
                if (this.lfF) {
                    com.tencent.mm.plugin.exdevice.f.b.b.a apv = ad.apv();
                    String str2 = this.username;
                    if (apv.a(new com.tencent.mm.plugin.exdevice.f.b.b("hardcode_rank_id", "hardcode_app_name", str2)) == null) {
                        c cVar = new com.tencent.mm.plugin.exdevice.f.b.a.c();
                        cVar.field_rankID = "hardcode_rank_id";
                        cVar.field_appusername = "hardcode_app_name";
                        cVar.field_username = str2;
                        cVar.field_step = 0;
                        apv.b(cVar);
                    }
                } else {
                    ad.apv().ve(this.username);
                }
            }
            if (com_tencent_mm_protocal_c_aci.tfb != null) {
                List arrayList = new ArrayList();
                Iterator it = com_tencent_mm_protocal_c_aci.tfb.iterator();
                while (it.hasNext()) {
                    sk skVar = (sk) it.next();
                    ap.yY();
                    if (com.tencent.mm.u.c.wR().QY(skVar.username)) {
                        com.tencent.mm.plugin.exdevice.f.b.a.c cVar2 = new com.tencent.mm.plugin.exdevice.f.b.a.c();
                        cVar2.field_username = skVar.username;
                        cVar2.field_step = skVar.kzY;
                        arrayList.add(cVar2);
                    } else {
                        ap.vd().a(new h(skVar.username, null), 0);
                    }
                }
                w.d("MicroMsg.NetSceneGetProfileDetail", "follows %d %s", new Object[]{Integer.valueOf(arrayList.size()), arrayList.toString()});
                if (m.xL().equalsIgnoreCase(this.username)) {
                    ad.apv().aq(arrayList);
                }
            }
            this.lfE = new ArrayList();
            if (com_tencent_mm_protocal_c_aci.tHX != null) {
                this.lfE.addAll(com_tencent_mm_protocal_c_aci.tHX);
            }
            this.lfF = com_tencent_mm_protocal_c_aci.lfF;
            com.tencent.mm.plugin.exdevice.f.b.a.a aVar = new com.tencent.mm.plugin.exdevice.f.b.a.a();
            aVar.field_championMotto = this.lfw;
            aVar.field_championUrl = this.lfv;
            aVar.field_username = this.username;
            LinkedList linkedList = com_tencent_mm_protocal_c_aci.tfx;
            ad.apx().a(aVar, true);
        }
        b bVar = (b) this.laR.get();
        if (bVar != null) {
            bVar.b(i2, i3, str, this);
        }
    }

    protected final String getUri() {
        return "/cgi-bin/mmbiz-bin/rank/getuserrankdetail";
    }

    public final int getType() {
        return 1043;
    }
}
