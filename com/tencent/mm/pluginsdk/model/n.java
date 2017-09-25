package com.tencent.mm.pluginsdk.model;

import android.text.TextUtils;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bjd;
import com.tencent.mm.protocal.c.bje;
import com.tencent.mm.protocal.c.bjf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.g;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class n extends k implements j {
    public int fJK;
    public final b gUA;
    private e gUD;
    public String hEk;
    public List<String> sCv;
    public String sCw;
    private List<String> sCx;

    private n(int i, String str, String str2, int i2) {
        this.sCv = null;
        this.fJK = 0;
        this.sCx = null;
        Assert.assertTrue("This NetSceneVerifyUser init MUST use opcode == MM_VERIFYUSER_VERIFYOK", true);
        this.sCv = new LinkedList();
        this.sCv.add(str);
        this.fJK = 3;
        a aVar = new a();
        aVar.hsm = new bje();
        aVar.hsn = new bjf();
        aVar.uri = "/cgi-bin/micromsg-bin/verifyuser";
        aVar.hsl = 137;
        aVar.hso = 44;
        aVar.hsp = 1000000044;
        this.gUA = aVar.BE();
        bje com_tencent_mm_protocal_c_bje = (bje) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bje.thO = 3;
        com_tencent_mm_protocal_c_bje.tHj = "";
        LinkedList linkedList = new LinkedList();
        bjd com_tencent_mm_protocal_c_bjd = new bjd();
        com_tencent_mm_protocal_c_bjd.oTN = str;
        com_tencent_mm_protocal_c_bjd.uiJ = str2;
        com_tencent_mm_protocal_c_bjd.tBM = com.tencent.mm.plugin.d.a.Pj().xB().QF(str);
        com_tencent_mm_protocal_c_bjd.tZg = null;
        linkedList.add(com_tencent_mm_protocal_c_bjd);
        com_tencent_mm_protocal_c_bje.uiQ = linkedList;
        com_tencent_mm_protocal_c_bje.uiP = linkedList.size();
        linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(i2));
        com_tencent_mm_protocal_c_bje.uiS = linkedList;
        com_tencent_mm_protocal_c_bje.uiR = linkedList.size();
        com_tencent_mm_protocal_c_bje.tNc = new avw().bb(d.nZC.aPl());
        w.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify scene:%d user:%d ticket:%s anti:%s", Integer.valueOf(com_tencent_mm_protocal_c_bje.uiQ.size()), Integer.valueOf(com_tencent_mm_protocal_c_bje.uiS.size()), str2, com_tencent_mm_protocal_c_bjd.tBM);
    }

    public n(int i, List<String> list, List<Integer> list2, List<String> list3, String str, String str2, Map<String, Integer> map, String str3, String str4) {
        int i2;
        this.sCv = null;
        this.fJK = 0;
        this.sCx = null;
        Assert.assertTrue("This NetSceneVerifyUser init NEVER use opcode == MM_VERIFYUSER_VERIFYOK", i != 3);
        this.fJK = i;
        this.sCv = list;
        if (list3 == null || list3.size() == 0) {
            list3 = new LinkedList();
        }
        a aVar = new a();
        aVar.hsm = new bje();
        aVar.hsn = new bjf();
        aVar.uri = "/cgi-bin/micromsg-bin/verifyuser";
        aVar.hsl = 137;
        aVar.hso = 44;
        aVar.hsp = 1000000044;
        this.gUA = aVar.BE();
        if (list3 != null && list3.size() > 0) {
            Assert.assertTrue("only when opcode == 1 , antispamticket not null", i == 1);
            if (list3.size() != list.size()) {
                w.e("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify Error lstAntispamTicket:%d lstVerifyUser:%d", Integer.valueOf(list3.size()), Integer.valueOf(list.size()));
            } else {
                for (i2 = 0; i2 < list3.size(); i2++) {
                    com.tencent.mm.plugin.d.a.Pj().xB().o((String) list.get(i2), 2147483633, (String) list3.get(i2));
                }
            }
        }
        if (i == 2) {
            Assert.assertTrue("only when opcode == 2, antispamticket should null", list3.isEmpty());
            for (int i3 = 0; i3 < list.size(); i3++) {
                list3.add(bg.ap(com.tencent.mm.plugin.d.a.Pj().xB().QF((String) list.get(i3)), ""));
            }
        }
        bje com_tencent_mm_protocal_c_bje = (bje) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bje.thO = i;
        com_tencent_mm_protocal_c_bje.tHj = str;
        this.sCw = str;
        LinkedList linkedList = new LinkedList();
        i2 = 0;
        while (i2 < list.size()) {
            String str5;
            bjd com_tencent_mm_protocal_c_bjd = new bjd();
            com_tencent_mm_protocal_c_bjd.oTN = (String) list.get(i2);
            if (str2 == null) {
                str5 = "";
            } else {
                str5 = str2;
            }
            com_tencent_mm_protocal_c_bjd.uiJ = str5;
            g xB = com.tencent.mm.plugin.d.a.Pj().xB();
            String str6 = com_tencent_mm_protocal_c_bjd.oTN;
            ((Integer) list2.get(i2)).intValue();
            com_tencent_mm_protocal_c_bjd.tBM = bg.ap(xB.QF(str6), "");
            if (TextUtils.isEmpty(com_tencent_mm_protocal_c_bjd.tBM) && list3 != null && list3.size() > i2) {
                com_tencent_mm_protocal_c_bjd.tBM = (String) list3.get(i2);
            }
            com_tencent_mm_protocal_c_bjd.tZg = str3;
            if (map != null) {
                if (map.containsKey(com_tencent_mm_protocal_c_bjd.oTN)) {
                    com_tencent_mm_protocal_c_bjd.uiK = ((Integer) map.get(com_tencent_mm_protocal_c_bjd.oTN)).intValue();
                }
            }
            com_tencent_mm_protocal_c_bjd.uiO = str4;
            w.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%s idx:%s user:%s anti:%s chatroom:%s, reportInfo:%s", Integer.valueOf(this.fJK), Integer.valueOf(i2), com_tencent_mm_protocal_c_bjd.oTN, com_tencent_mm_protocal_c_bjd.tBM, str3, str4);
            linkedList.add(com_tencent_mm_protocal_c_bjd);
            i2++;
        }
        com_tencent_mm_protocal_c_bje.uiQ = linkedList;
        com_tencent_mm_protocal_c_bje.uiP = linkedList.size();
        LinkedList linkedList2 = new LinkedList();
        linkedList2.addAll(list2);
        com_tencent_mm_protocal_c_bje.uiS = linkedList2;
        com_tencent_mm_protocal_c_bje.uiR = linkedList2.size();
        com_tencent_mm_protocal_c_bje.tNc = new avw().bb(d.nZC.aPl());
        w.i("MicroMsg.NetSceneVerifyUser.dkverify", "dkverify op:%d scene:%d user:%d antitickets:%s chatroom:%s stack:%s", Integer.valueOf(this.fJK), Integer.valueOf(com_tencent_mm_protocal_c_bje.uiQ.size()), Integer.valueOf(com_tencent_mm_protocal_c_bje.uiS.size()), bg.c(list3, ","), str3, bg.bJZ());
    }

    public n(List<String> list, List<Integer> list2, String str, String str2, Map<String, Integer> map, String str3) {
        this(2, list, list2, null, str, str2, map, str3, "");
    }

    public n(String str, String str2, int i) {
        this(3, str, str2, i);
    }

    public n(int i, List<String> list, List<Integer> list2, String str, String str2) {
        this(i, list, list2, null, str, str2, null, null, "");
    }

    public final void ei(String str, String str2) {
        Iterator it = ((bje) this.gUA.hsj.hsr).uiQ.iterator();
        while (it.hasNext()) {
            bjd com_tencent_mm_protocal_c_bjd = (bjd) it.next();
            com_tencent_mm_protocal_c_bjd.uiL = str;
            com_tencent_mm_protocal_c_bjd.uiM = str2;
        }
    }

    public final String bCI() {
        if (this.gUA == null || this.gUA.hsk == null) {
            return "";
        }
        return ((bjf) this.gUA.hsk.hsr).jNj;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 30;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (!(i2 == 0 && i3 == 0)) {
            w.e("MicroMsg.NetSceneVerifyUser.dkverify", "errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        this.gUD.a(i2, i3, str, this);
    }
}
