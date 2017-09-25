package com.tencent.mm.ag;

import android.text.TextUtils;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.f;
import com.tencent.mm.modelfriend.o;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aec;
import com.tencent.mm.protocal.c.aed;
import com.tencent.mm.protocal.c.ajk;
import com.tencent.mm.protocal.c.ajl;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.g;
import com.tencent.mm.u.ap;
import com.tencent.mm.x.h;
import com.tencent.mm.x.n;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class c extends k implements j {
    private final b gUA;
    private e gUD;
    private ArrayList<o> hEl;
    private int hEm;
    private int hEn;
    private int hEo;
    private int hEp;
    private HashMap<String, o> hEq = new HashMap();
    private String hEr;

    public c(ArrayList<o> arrayList, int i, HashMap<String, o> hashMap, String str) {
        a aVar = new a();
        aVar.hsm = new ajk();
        aVar.hsn = new ajl();
        aVar.uri = "/cgi-bin/micromsg-bin/listgooglecontact";
        aVar.hsl = 488;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.hEl = arrayList;
        this.hEm = i;
        this.hEn = 0;
        this.hEp = 1;
        this.hEq = hashMap;
        this.hEr = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene");
        this.gUD = eVar2;
        ajk com_tencent_mm_protocal_c_ajk = (ajk) this.gUA.hsj.hsr;
        if (this.hEl != null) {
            LinkedList linkedList = new LinkedList();
            this.hEo = this.hEl.size();
            int i = this.hEn;
            while (i < this.hEo && i < this.hEn + 500) {
                aed com_tencent_mm_protocal_c_aed = new aed();
                com_tencent_mm_protocal_c_aed.tjl = ((o) this.hEl.get(i)).field_googlegmail;
                linkedList.add(com_tencent_mm_protocal_c_aed);
                i++;
            }
            com_tencent_mm_protocal_c_ajk.jNe = linkedList;
            com_tencent_mm_protocal_c_ajk.jNd = linkedList.size();
            if (this.hEn + 500 > this.hEo) {
                this.hEp = 0;
            } else {
                this.hEp = 1;
            }
            com_tencent_mm_protocal_c_ajk.tlZ = this.hEp;
            com_tencent_mm_protocal_c_ajk.tNj = this.hEm;
            w.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doscene mTotalSize:%d, mStarIndex:%d, mContinueFlag:%d", new Object[]{Integer.valueOf(this.hEo), Integer.valueOf(this.hEn), Integer.valueOf(this.hEp)});
        }
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            a(Gv());
            if (this.hEp == 1) {
                this.hEn += 500;
                if (a(this.hsD, this.gUD) < 0) {
                    w.e("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene again failed");
                    this.gUD.a(3, -1, "", this);
                }
            }
            this.gUD.a(i2, i3, str, this);
            return;
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final ajl Gv() {
        return (ajl) this.gUA.hsk.hsr;
    }

    private synchronized void a(ajl com_tencent_mm_protocal_c_ajl) {
        w.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "handleListGoogleContactCGIResponse Count:%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_ajl.jNd)});
        if (com_tencent_mm_protocal_c_ajl.jNe != null && com_tencent_mm_protocal_c_ajl.jNe.size() > 0) {
            int size = com_tencent_mm_protocal_c_ajl.jNe.size();
            ArrayList arrayList = new ArrayList();
            List linkedList = new LinkedList();
            for (int i = 0; i < size; i++) {
                int i2;
                aec com_tencent_mm_protocal_c_aec = (aec) com_tencent_mm_protocal_c_ajl.jNe.get(i);
                if (TextUtils.isEmpty(com_tencent_mm_protocal_c_aec.jNj)) {
                    i2 = 1;
                } else {
                    ap.yY();
                    af Rc = com.tencent.mm.u.c.wR().Rc(com_tencent_mm_protocal_c_aec.jNj);
                    i2 = (Rc == null || !com.tencent.mm.j.a.ez(Rc.field_type)) ? 0 : 2;
                }
                if (this.hEq != null && this.hEq.containsKey(com_tencent_mm_protocal_c_aec.tjl)) {
                    o oVar = (o) this.hEq.get(com_tencent_mm_protocal_c_aec.tjl);
                    oVar.field_username = com_tencent_mm_protocal_c_aec.jNj;
                    oVar.field_nickname = com_tencent_mm_protocal_c_aec.jOp;
                    oVar.field_usernamepy = com.tencent.mm.platformtools.c.mq(com_tencent_mm_protocal_c_aec.jOp);
                    oVar.field_nicknameqp = com.tencent.mm.platformtools.c.mp(com_tencent_mm_protocal_c_aec.jOp);
                    oVar.field_ret = com_tencent_mm_protocal_c_aec.thX;
                    oVar.field_small_url = com_tencent_mm_protocal_c_aec.tJz;
                    oVar.field_big_url = com_tencent_mm_protocal_c_aec.tJy;
                    oVar.field_status = i2;
                    oVar.field_googlecgistatus = 2;
                    if (i2 == 2 || i2 == 0) {
                        oVar.field_contecttype = "weixin" + i;
                    } else {
                        oVar.field_contecttype = "google";
                    }
                    oVar.field_googlenamepy = com.tencent.mm.platformtools.c.mq(oVar.field_googlename);
                    arrayList.add(oVar);
                    Object obj = oVar.field_googleid;
                    String str = oVar.field_googlephotourl;
                    String str2 = this.hEr;
                    if (!(TextUtils.isEmpty(obj) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
                        String str3 = obj + "@google";
                        h hs = n.Bm().hs(str3);
                        if (hs == null) {
                            hs = new h();
                        }
                        hs.username = str3;
                        hs.gkq = 3;
                        hs.hrB = com.tencent.mm.x.b.Q(str, str2);
                        hs.hrA = com.tencent.mm.x.b.Q(str, str2);
                        hs.aV(true);
                        hs.fRW = 31;
                        n.Bm().a(hs);
                    }
                    f aVar = new g.a();
                    aVar.field_userName = com_tencent_mm_protocal_c_aec.jNj;
                    aVar.field_scene = 58;
                    aVar.field_ticket = com_tencent_mm_protocal_c_aec.tBM;
                    linkedList.add(aVar);
                }
            }
            com.tencent.mm.modelfriend.af.Gg().f(arrayList);
            ap.yY();
            com.tencent.mm.u.c.xB().bW(linkedList);
        }
    }

    public final int getType() {
        return 488;
    }

    protected final int ub() {
        return 20;
    }

    protected final int a(p pVar) {
        return k.b.hsT;
    }
}
