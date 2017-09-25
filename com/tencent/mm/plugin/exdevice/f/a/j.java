package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.a.d;
import com.tencent.mm.plugin.exdevice.f.b.a.e;
import com.tencent.mm.plugin.exdevice.f.b.f;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.c.acj;
import com.tencent.mm.protocal.c.ack;
import com.tencent.mm.protocal.c.bra;
import com.tencent.mm.protocal.c.brb;
import com.tencent.mm.protocal.c.sk;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class j extends com.tencent.mm.plugin.exdevice.a.a<acj, ack> {
    public String appName;
    public boolean lfH;
    public boolean lfI;
    public String lfJ;
    public String lfK;
    public com.tencent.mm.plugin.exdevice.f.b.a.a lfL;
    public ArrayList<d> lfM;
    public ArrayList<c> lfN;
    public ArrayList<e> lfO;
    public ArrayList<String> lfP;
    public String lfQ;
    public String lfR;
    public boolean lfS;
    public boolean lfT;
    public String lfU;
    private final WeakReference<b<j>> lfV;
    public a lfW;
    public String lfx;
    public String lfy;

    public interface a {
        void a(j jVar);
    }

    protected final /* synthetic */ com.tencent.mm.bd.a aoL() {
        return new acj();
    }

    protected final /* synthetic */ com.tencent.mm.bd.a aoM() {
        return new ack();
    }

    protected final /* bridge */ /* synthetic */ void c(com.tencent.mm.bd.a aVar) {
        acj com_tencent_mm_protocal_c_acj = (acj) aVar;
        com_tencent_mm_protocal_c_acj.lmI = this.appName;
        com_tencent_mm_protocal_c_acj.hhW = this.lfJ;
        com_tencent_mm_protocal_c_acj.tHZ = this.lfI;
        com_tencent_mm_protocal_c_acj.tIa = this.lfK;
    }

    public j(String str, String str2, String str3, boolean z, b<j> bVar) {
        this.lfV = new WeakReference(bVar);
        this.lfQ = str;
        this.lfJ = str;
        this.appName = bg.mz(str2);
        this.lfI = z;
        this.lfK = str3;
    }

    public final int getType() {
        return 1042;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGetRankInfo", "hy: get rank info end. errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            Iterator it;
            String str2;
            String str3;
            Object obj;
            String str4;
            com.tencent.mm.plugin.exdevice.f.b.a.a aVar;
            ack com_tencent_mm_protocal_c_ack = (ack) abn();
            String str5 = "";
            this.lfN = new ArrayList();
            if (com_tencent_mm_protocal_c_ack.tfb != null) {
                it = com_tencent_mm_protocal_c_ack.tfb.iterator();
                while (it.hasNext()) {
                    sk skVar = (sk) it.next();
                    ap.yY();
                    if (com.tencent.mm.u.c.wR().QY(skVar.username)) {
                        str2 = com_tencent_mm_protocal_c_ack.hhW;
                        str3 = this.appName;
                        if (bg.mA(str2) || skVar == null) {
                            w.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                            obj = null;
                        } else {
                            c cVar = new c();
                            cVar.field_rankID = str2;
                            cVar.field_username = skVar.username;
                            cVar.field_step = skVar.kzY;
                            cVar.field_appusername = str3;
                            c cVar2 = cVar;
                        }
                        if (obj != null) {
                            this.lfN.add(obj);
                        }
                    } else {
                        ap.vd().a(new h(skVar.username, null), 0);
                    }
                }
            }
            this.lfM = new ArrayList();
            if (com_tencent_mm_protocal_c_ack.tIb != null) {
                it = com_tencent_mm_protocal_c_ack.tIb.iterator();
                while (it.hasNext()) {
                    d dVar;
                    bra com_tencent_mm_protocal_c_bra = (bra) it.next();
                    str2 = com_tencent_mm_protocal_c_ack.hhW;
                    str3 = this.appName;
                    if (bg.mA(str2) || com_tencent_mm_protocal_c_bra == null) {
                        w.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                        dVar = null;
                    } else {
                        dVar = new d();
                        dVar.field_appusername = str3;
                        dVar.field_rankID = str2;
                        dVar.field_likecount = com_tencent_mm_protocal_c_bra.uoZ;
                        dVar.field_ranknum = com_tencent_mm_protocal_c_bra.uoY;
                        dVar.field_score = com_tencent_mm_protocal_c_bra.score;
                        dVar.field_selfLikeState = com_tencent_mm_protocal_c_bra.upa;
                        dVar.field_username = com_tencent_mm_protocal_c_bra.username;
                    }
                    if (dVar != null) {
                        if (dVar.field_ranknum == 1) {
                            str4 = dVar.field_username;
                        } else {
                            str4 = str5;
                        }
                        this.lfM.add(dVar);
                        str5 = str4;
                    }
                }
            }
            this.lfO = new ArrayList();
            if (com_tencent_mm_protocal_c_ack.tIc != null) {
                it = com_tencent_mm_protocal_c_ack.tIc.iterator();
                while (it.hasNext()) {
                    brb com_tencent_mm_protocal_c_brb = (brb) it.next();
                    str2 = com_tencent_mm_protocal_c_ack.hhW;
                    str3 = this.appName;
                    if (bg.mA(str2) || com_tencent_mm_protocal_c_brb == null) {
                        w.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                        obj = null;
                    } else {
                        e eVar = new e();
                        eVar.field_appusername = str3;
                        eVar.field_rankID = str2;
                        eVar.field_timestamp = com_tencent_mm_protocal_c_brb.kBd;
                        eVar.field_username = com_tencent_mm_protocal_c_brb.username;
                        e eVar2 = eVar;
                    }
                    if (obj != null) {
                        this.lfO.add(obj);
                    }
                }
            }
            this.lfP = new ArrayList();
            if (com_tencent_mm_protocal_c_ack.tHU != null) {
                Iterator it2 = com_tencent_mm_protocal_c_ack.tHU.iterator();
                while (it2.hasNext()) {
                    this.lfP.add((String) it2.next());
                }
            }
            if (!bg.mA(this.lfK)) {
                str5 = this.lfK;
            }
            String str6 = com_tencent_mm_protocal_c_ack.tId;
            String str7 = com_tencent_mm_protocal_c_ack.tIe;
            if (bg.mA(str5)) {
                w.w("MicroMsg.ExdeviceRankConverter", "hy: param error");
                aVar = null;
            } else {
                aVar = new com.tencent.mm.plugin.exdevice.f.b.a.a();
                aVar.field_username = str5;
                aVar.field_championUrl = str6;
                aVar.field_championMotto = str7;
            }
            this.lfL = aVar;
            this.lfQ = com_tencent_mm_protocal_c_ack.hhW;
            this.lfy = com_tencent_mm_protocal_c_ack.tHW;
            this.lfx = com_tencent_mm_protocal_c_ack.tHV;
            this.lfR = com_tencent_mm_protocal_c_ack.tIf;
            this.lfS = com_tencent_mm_protocal_c_ack.lfS;
            this.lfT = com_tencent_mm_protocal_c_ack.tIi == 1;
            this.lfU = com_tencent_mm_protocal_c_ack.tIj;
            this.lfH = com_tencent_mm_protocal_c_ack.tHY;
            w.d("MicroMsg.NetSceneGetRankInfo", "hy: get score info ok.");
            if (this.lfJ == null || !this.lfJ.equals(this.lfQ)) {
                f fVar = ad.apB().lgd;
                if (fVar != null) {
                    fVar.vc(this.lfQ);
                }
            }
            if (this.lfW != null && this.lfI) {
                this.lfW.a(this);
            }
            if (this.lfI) {
                ad.apv().aq(this.lfN);
            }
            com.tencent.mm.plugin.exdevice.f.b.b.d apu = ad.apu();
            if (bg.mA(this.lfQ)) {
                w.w("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId failed, rankId is null or nil.");
            } else {
                int delete = apu.gUz.delete("HardDeviceRankInfo", "rankID = ? ", new String[]{this.lfQ});
                w.i("MicroMsg.ExdeviceRankInfoStg", "delete rankInfo by rankId (%s).(r : %d)", new Object[]{str4, Integer.valueOf(delete)});
            }
            ad.apu().c(this.lfQ, this.lfM);
            str4 = "MicroMsg.NetSceneGetRankInfo";
            str5 = "isCacheExist(%s), RankFollowInfo size(%s), RankInfo size(%d), LikeInfo size(%d).";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(this.lfS);
            objArr[1] = Integer.valueOf(this.lfN != null ? this.lfN.size() : 0);
            objArr[2] = Integer.valueOf(this.lfM != null ? this.lfM.size() : 0);
            objArr[3] = Integer.valueOf(this.lfO != null ? this.lfO.size() : 0);
            w.i(str4, str5, objArr);
            ad.apy().a(this.lfQ, this.appName, this.lfO);
            if (this.lfL != null) {
                ad.apx().a(this.lfL, true);
            }
        }
        super.a(i, i2, i3, str, pVar, bArr);
        b bVar = (b) this.lfV.get();
        if (bVar != null) {
            bVar.b(i2, i3, str, this);
        }
    }

    protected final String getUri() {
        return "/cgi-bin/mmbiz-bin/rank/getuserranklike";
    }
}
