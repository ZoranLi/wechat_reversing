package com.tencent.mm.plugin.product.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.product.c.a;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.l;
import com.tencent.mm.plugin.product.c.m;
import com.tencent.mm.plugin.product.ui.e;
import com.tencent.mm.protocal.c.aie;
import com.tencent.mm.protocal.c.ar;
import com.tencent.mm.protocal.c.ari;
import com.tencent.mm.protocal.c.aue;
import com.tencent.mm.protocal.c.awb;
import com.tencent.mm.protocal.c.bal;
import com.tencent.mm.protocal.c.bz;
import com.tencent.mm.protocal.c.od;
import com.tencent.mm.protocal.c.qe;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.t.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class c {
    public int mCount = 1;
    private d ooU = null;
    public m ooV;
    public List<n> ooW;
    public String ooX;
    public String ooY;
    public String ooZ;
    public qe opa;
    public bz opb;
    public aue opc;
    public String opd;
    public String ope;
    public int opf;
    public Map<String, e> opg;
    public Map<String, String> oph = new HashMap();
    public LinkedList<qe> opi;
    public LinkedList<ar> opj;
    public e opk;
    private e opl;
    public Map<String, LinkedList<od>> opm = null;

    public final void clear() {
        this.ooV = null;
        if (this.ooW != null) {
            this.ooW.clear();
            this.ooW = null;
        }
        this.ooX = null;
        this.ooY = null;
        this.mCount = 1;
        this.ooZ = null;
        this.opa = null;
        this.opc = null;
        this.opd = null;
        this.opf = 0;
        this.opk = null;
        if (this.opg != null) {
            this.opg.clear();
            this.opg = null;
        }
        if (this.oph != null) {
            this.oph.clear();
        }
        if (this.opi != null) {
            this.opi.clear();
            this.opi = null;
        }
        if (this.opm != null) {
            this.opm.clear();
            this.opm = null;
        }
    }

    public final void a(m mVar, List<n> list) {
        int i;
        int i2 = 0;
        clear();
        this.ooV = mVar;
        this.ooW = list;
        if (bg.mA(this.ooV.opD)) {
            this.ooV.opD = this.ooY;
        }
        LinkedList linkedList = this.ooV.opB;
        this.opg = new HashMap();
        if (linkedList != null && linkedList.size() > 0) {
            int size = linkedList.size();
            for (int i3 = 0; i3 < size; i3++) {
                l lVar = (l) linkedList.get(i3);
                a(lVar.oqe.split(";"), lVar);
            }
            aTi();
        }
        if (!(this.ooV.opz == null || this.ooV.opz.opV == null)) {
            this.opf = this.ooV.opz.opV.size();
        }
        if (!(this.ooV.opz == null || this.ooV.opz.opO == null || this.ooV.opz.opO.size() <= 0)) {
            this.opd = (String) this.ooV.opz.opO.get(0);
        }
        if (!bg.mA(this.ooV.aTm())) {
            j.a(new com.tencent.mm.plugin.product.ui.c(this.ooV.aTm()));
            w.d("MicroMsg.MallProductManager", "product img path : " + aTa());
        }
        if (this.ooV.opC == null || this.ooV.opC.opZ == null) {
            i = 0;
        } else {
            i = this.ooV.opC.opZ.fRW;
        }
        if (this.ooV.opA != null) {
            i2 = this.ooV.opA.fRW;
        }
        this.opl = new e(i, i2);
    }

    public final e aST() {
        if (this.opl == null) {
            this.opl = new e(0, 0);
        }
        return this.opl;
    }

    public final String aSU() {
        if (this.opk == null || bg.mA(this.opk.url)) {
            return this.opd;
        }
        return this.opk.url;
    }

    public final String aSV() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = this.ooV.opz.opV.iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            String str = (String) this.oph.get(mVar.oqh);
            if (str != null) {
                Iterator it2 = mVar.oqj.iterator();
                while (it2.hasNext()) {
                    h hVar = (h) it2.next();
                    if (str.equals(hVar.id)) {
                        stringBuilder.append(hVar.name).append(" ");
                        break;
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

    public final void N(Intent intent) {
        bz bzVar = new bz();
        bzVar.jNj = bg.ap(intent.getStringExtra("userName"), "");
        bzVar.tfs = bg.ap(intent.getStringExtra("telNumber"), "");
        bzVar.tft = bg.ap(intent.getStringExtra("addressPostalCode"), "");
        bzVar.hAE = bg.ap(intent.getStringExtra("proviceFirstStageName"), "");
        bzVar.hAF = bg.ap(intent.getStringExtra("addressCitySecondStageName"), "");
        bzVar.hAM = bg.ap(intent.getStringExtra("addressCountiesThirdStageName"), "");
        bzVar.mtg = bg.ap(intent.getStringExtra("addressDetailInfo"), "");
        if (!bg.mA(bzVar.jNj) && !bg.mA(bzVar.tfs)) {
            this.opb = bzVar;
        }
    }

    public final LinkedList<a> N(Activity activity) {
        LinkedList<a> linkedList = new LinkedList();
        if (this.opj != null) {
            Iterator it = this.opj.iterator();
            while (it.hasNext()) {
                ar arVar = (ar) it.next();
                a aVar = new a();
                aVar.msj = arVar.msj;
                aVar.opH = arVar.opH;
                aVar.opI = arVar.opI;
                aVar.jOc = arVar.jOc;
                aVar.muU = arVar.muU;
                if (aVar.jOc == 1 && Cy(aVar.opI) > 0) {
                    aVar.opH = activity.getString(R.l.eAb, new Object[]{b.c((double) r0, this.ooV.opz.oga)});
                }
                linkedList.add(aVar);
            }
        }
        return linkedList;
    }

    public final void rd(int i) {
        if (this.opi != null && i < this.opi.size() && i >= 0) {
            this.opa = (qe) this.opi.get(i);
        }
    }

    public final int aSW() {
        int i = 0;
        if (!(aST().aTp() || this.opa == null)) {
            i = this.opa.tmm + 0;
        }
        if (this.opk != null) {
            i += this.opk.opo * this.mCount;
        } else {
            i += this.ooV.opz.opM * this.mCount;
        }
        return i - aSX();
    }

    public final int aSX() {
        if (this.opm == null || this.opm.size() <= 0) {
            return 0;
        }
        int i = 0;
        for (LinkedList linkedList : this.opm.values()) {
            if (linkedList != null && linkedList.size() > 0) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    i += ((od) it.next()).tmm;
                }
            }
            i = i;
        }
        return i;
    }

    private int Cy(String str) {
        int i = 0;
        if (this.opm != null && this.opm.size() > 0) {
            LinkedList linkedList = (LinkedList) this.opm.get(str);
            if (linkedList != null && linkedList.size() > 0) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    i = ((od) it.next()).tmm + i;
                }
            }
        }
        return i;
    }

    public final aue aSY() {
        if (this.opc != null) {
            return this.opc;
        }
        if (this.ooU == null) {
            this.ooU = com.tencent.mm.plugin.product.a.a.aSQ().aSS();
        }
        d dVar = this.ooU;
        String str = (dVar.opn == null || dVar.opn.size() <= 0) ? null : (String) dVar.opn.get(0);
        if (bg.mA(str)) {
            bz bzVar = this.opb;
            if (bzVar == null || bg.mA(bzVar.jNj)) {
                return null;
            }
            this.opc = new aue();
            this.opc.mtg = bzVar.jNj;
            this.opc.tXV = 1;
            return this.opc;
        }
        this.opc = new aue();
        this.opc.mtg = str;
        this.opc.tXV = 1;
        return this.opc;
    }

    public final String getAppId() {
        if (this.ooV.opA != null) {
            return this.ooV.opA.fTO;
        }
        return null;
    }

    public final String aSZ() {
        if (this.ooV.opA != null) {
            return this.ooV.opA.username;
        }
        return null;
    }

    public final String aTa() {
        if (bg.mA(this.ooV.aTm())) {
            return null;
        }
        return com.tencent.mm.plugin.product.ui.c.CA(this.ooV.aTm());
    }

    public final String aTb() {
        if (this.ooV.opz != null && this.ooV.opz.opX != null) {
            return this.ooV.opz.opX.url;
        }
        if (bg.mA(this.ooV.opD)) {
            return this.ooY;
        }
        return this.ooV.opD;
    }

    public final int aTc() {
        int i = this.ooV.opx;
        if (this.opk == null || i <= this.opk.opx) {
            return i;
        }
        return this.opk.opx;
    }

    public final boolean aTd() {
        return (this.mCount <= 0 || this.ooV == null || this.mCount > aTc() || this.ooV.opz == null || this.ooV.opz.opV == null) ? false : true;
    }

    public final boolean aTe() {
        if (!aTd() || this.oph == null || this.oph.size() != this.opf) {
            return false;
        }
        if (this.opf > 0) {
            if (this.opk == null || this.mCount <= 0 || this.mCount > aTc()) {
                return false;
            }
            return true;
        } else if (this.opf == 0) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean aTf() {
        if (!aTe() || this.opb == null) {
            return false;
        }
        if (aST().aTp() || this.opa != null) {
            return true;
        }
        return false;
    }

    public final LinkedList<awb> aTg() {
        LinkedList<awb> linkedList = new LinkedList();
        awb com_tencent_mm_protocal_c_awb = new awb();
        com_tencent_mm_protocal_c_awb.jNd = this.mCount;
        com_tencent_mm_protocal_c_awb.tGj = this.ooV.opv;
        com_tencent_mm_protocal_c_awb.tVO = this.ooV.opD;
        com_tencent_mm_protocal_c_awb.tVP = this.ooZ;
        linkedList.add(com_tencent_mm_protocal_c_awb);
        return linkedList;
    }

    public final bal aTh() {
        bal com_tencent_mm_protocal_c_bal = new bal();
        com_tencent_mm_protocal_c_bal.tnq = this.ooX;
        com_tencent_mm_protocal_c_bal.ogX = 1;
        com_tencent_mm_protocal_c_bal.ubv = new LinkedList();
        ari com_tencent_mm_protocal_c_ari = new ari();
        com_tencent_mm_protocal_c_ari.jNd = this.mCount;
        com_tencent_mm_protocal_c_ari.tGj = this.ooV.opv;
        com_tencent_mm_protocal_c_ari.msj = this.ooV.opz.name;
        if (this.opk != null) {
            com_tencent_mm_protocal_c_ari.tVN = this.opk.opo;
        } else {
            com_tencent_mm_protocal_c_ari.tVN = this.ooV.opz.opM;
        }
        com_tencent_mm_protocal_c_ari.tVO = this.ooV.opD;
        com_tencent_mm_protocal_c_ari.tVP = this.ooZ;
        com_tencent_mm_protocal_c_ari.jOc = this.ooV.opw;
        com_tencent_mm_protocal_c_ari.tVL = this.opf;
        com_tencent_mm_protocal_c_ari.tVM = new LinkedList();
        for (String str : this.oph.keySet()) {
            String str2 = (String) this.oph.get(str);
            aie com_tencent_mm_protocal_c_aie = new aie();
            com_tencent_mm_protocal_c_aie.tkE = str;
            com_tencent_mm_protocal_c_aie.oTN = str2;
            com_tencent_mm_protocal_c_ari.tVM.add(com_tencent_mm_protocal_c_aie);
        }
        com_tencent_mm_protocal_c_ari.tVT = new LinkedList();
        com_tencent_mm_protocal_c_ari.tVS = 0;
        if (this.opm != null && this.opm.size() > 0) {
            for (LinkedList linkedList : this.opm.values()) {
                com_tencent_mm_protocal_c_ari.tVT.addAll(linkedList);
                com_tencent_mm_protocal_c_ari.tVS = linkedList.size() + com_tencent_mm_protocal_c_ari.tVS;
            }
        }
        com_tencent_mm_protocal_c_bal.ubv.add(com_tencent_mm_protocal_c_ari);
        com_tencent_mm_protocal_c_bal.ubx = new LinkedList();
        com_tencent_mm_protocal_c_bal.uby = 1;
        this.opc = aSY();
        if (this.opc != null) {
            com_tencent_mm_protocal_c_bal.ubx.add(this.opc);
        } else {
            this.opc = new aue();
            this.opc.tXV = 0;
            com_tencent_mm_protocal_c_bal.ubx.add(this.opc);
        }
        com_tencent_mm_protocal_c_bal.tFg = this.opb;
        com_tencent_mm_protocal_c_bal.ubw = this.opa;
        return com_tencent_mm_protocal_c_bal;
    }

    public final void aTi() {
        if (this.oph != null) {
            Iterator it = this.ooV.opz.opV.iterator();
            while (it.hasNext()) {
                m mVar = (m) it.next();
                Iterator it2 = mVar.oqj.iterator();
                while (it2.hasNext()) {
                    boolean z;
                    h hVar = (h) it2.next();
                    String str = mVar.oqh;
                    String str2 = hVar.id;
                    if (this.oph == null || this.opg == null) {
                        z = false;
                    } else if (this.oph.containsKey(str)) {
                        r2 = (String) this.oph.get(str);
                        this.oph.put(str, str2);
                        str2 = F(this.oph);
                        this.oph.put(str, r2);
                        r2 = (e) this.opg.get(str2);
                        z = r2 != null ? r2.opx > 0 : false;
                    } else {
                        this.oph.put(str, str2);
                        r2 = F(this.oph);
                        this.oph.remove(str);
                        r2 = (e) this.opg.get(r2);
                        z = r2 != null ? r2.opx > 0 : false;
                    }
                    hVar.oqb = z;
                    w.d("MicroMsg.MallProductManager", "(" + mVar.oqh + " , " + hVar.id + ") hasStock--> " + hVar.oqb);
                }
            }
        }
    }

    public static String F(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Object arrayList = new ArrayList(map.entrySet());
        Collections.sort(arrayList, new Comparator<Entry<String, String>>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                return ((String) ((Entry) obj).getKey()).compareTo((String) ((Entry) obj2).getKey());
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            stringBuilder.append((String) entry.getKey()).append(":").append((String) entry.getValue()).append(";");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(";"));
        return stringBuilder.toString();
    }

    private void a(String[] strArr, l lVar) {
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            int i = -1 >>> (32 - length);
            for (int i2 = 1; i2 <= i; i2++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i3 = 0; i3 < length; i3++) {
                    if (((i2 << (31 - i3)) >> 31) == -1) {
                        stringBuilder.append(strArr[i3]).append(";");
                    }
                }
                stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(";"));
                e eVar = (e) this.opg.get(stringBuilder.toString());
                if (eVar != null) {
                    if (eVar.opo < lVar.oqf) {
                        eVar.opo = lVar.oqf;
                    }
                    if (eVar.opp > lVar.oqf) {
                        eVar.opp = lVar.oqf;
                    }
                    eVar.opx += lVar.opx;
                } else {
                    eVar = new e();
                    eVar.opo = lVar.oqf;
                    eVar.opp = lVar.oqf;
                    eVar.opx = lVar.opx;
                    eVar.oqg = lVar.oqg;
                    eVar.url = lVar.url;
                    this.opg.put(stringBuilder.toString(), eVar);
                }
            }
        }
    }

    public final String aTj() {
        f.a aVar = new f.a();
        aVar.title = this.ooV.opz.name;
        aVar.description = aTk();
        aVar.type = 13;
        aVar.url = aTb();
        aVar.thumburl = this.ooV.aTm();
        aVar.hhR = this.ooV.opw;
        aVar.hhS = a(this.ooV);
        return f.a.a(aVar, null, null);
    }

    public final String aTk() {
        return b.c((double) this.ooV.opz.opN, this.ooV.opz.oga);
    }

    public final String a(m mVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<mallProductInfo>");
        stringBuilder.append("<type>").append(mVar.opw).append("</type>");
        stringBuilder.append("<id>").append(mVar.opv).append("</id>");
        stringBuilder.append("<version>").append(mVar.opz.version).append("</version>");
        stringBuilder.append("<name>").append(bg.PW(mVar.opz.name)).append("</name>");
        stringBuilder.append("<highPrice>").append(mVar.opz.opM).append("</highPrice>");
        stringBuilder.append("<lowPrice>").append(mVar.opz.opN).append("</lowPrice>");
        stringBuilder.append("<originPrice>").append(mVar.opz.opL).append("</originPrice>");
        stringBuilder.append("<sourceUrl>").append(bg.PW(this.ooV.opD)).append("</sourceUrl>");
        if (mVar.opz.opO != null) {
            stringBuilder.append("<imgCount>").append(mVar.opz.opO.size()).append("</imgCount>");
            stringBuilder.append("<imgList>");
            Iterator it = mVar.opz.opO.iterator();
            while (it.hasNext()) {
                stringBuilder.append("<imgUrl>").append(bg.PW((String) it.next())).append("</imgUrl>");
            }
            stringBuilder.append("</imgList>");
        }
        stringBuilder.append("<shareInfo>");
        stringBuilder.append("<shareUrl>").append(bg.PW(aTb())).append("</shareUrl>");
        stringBuilder.append("<shareThumbUrl>").append(bg.PW(mVar.aTm())).append("</shareThumbUrl>");
        stringBuilder.append("</shareInfo>");
        if (this.ooV.opA != null) {
            stringBuilder.append("<sellerInfo>");
            stringBuilder.append("<appID>").append(mVar.opA.fTO).append("</appID>");
            stringBuilder.append("<appName>").append(mVar.opA.name).append("</appName>");
            stringBuilder.append("<usrName>").append(mVar.opA.username).append("</usrName>");
            stringBuilder.append("</sellerInfo>");
        }
        stringBuilder.append("</mallProductInfo>");
        return stringBuilder.toString();
    }
}
