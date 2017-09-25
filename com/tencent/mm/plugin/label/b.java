package com.tencent.mm.plugin.label;

import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.label.b.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bio;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.z;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class b implements com.tencent.mm.plugin.label.a.b {
    public ArrayList<String> mYN;
    public ArrayList<String> mYO;
    private e mYP = new e(this) {
        final /* synthetic */ b mYQ;

        {
            this.mYQ = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            w.e("MicroMsg.Label.ContactLabelManagerImpl", "onSceneEnd");
            switch (kVar.getType()) {
                case 635:
                    if (i == 0 && i2 == 0) {
                        b.e(this.mYQ.username, this.mYQ.mYN);
                        return;
                    }
                    this.mYQ.aFC();
                    w.e("MicroMsg.Label.ContactLabelManagerImpl", "add contact lable faild");
                    return;
                case 638:
                    if (i == 0 && i2 == 0) {
                        int i3;
                        int i4;
                        if (this.mYQ.mYO == null || this.mYQ.mYO.isEmpty()) {
                            i3 = 0;
                        } else {
                            i3 = this.mYQ.mYO.size();
                        }
                        if (this.mYQ.mYN == null || this.mYQ.mYN.isEmpty()) {
                            i4 = 0;
                        } else {
                            i4 = this.mYQ.mYN.size() - i3;
                        }
                        if (i3 > 0 || i4 > 0) {
                            w.d("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
                            g.oUh.i(11220, new Object[]{m.xL(), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(0)});
                        }
                    }
                    this.mYQ.aFC();
                    return;
                default:
                    return;
            }
        }
    };
    public String username;

    public final /* synthetic */ List aFD() {
        return e.aFF().bLl();
    }

    public final /* synthetic */ List zg(String str) {
        if (bg.mA(str)) {
            w.d("MicroMsg.Label.ContactLabelManagerImpl", "cpan[getLabelStrList]");
            return null;
        }
        if (str.endsWith("\u0000")) {
            str = str.replace("\u0000", "");
        }
        return e.aFF().E(str.split(","));
    }

    public final /* synthetic */ List zh(String str) {
        return e.aFF().QS(str);
    }

    public final void aFA() {
        e.aFF().aFA();
    }

    public final String zd(String str) {
        return e.aFF().zd(str);
    }

    public final String ze(String str) {
        return e.aFF().ze(str);
    }

    public final void a(a aVar) {
        e.aFF().c(aVar);
    }

    public final void b(a aVar) {
        e.aFF().f(aVar);
    }

    public final List<String> aFB() {
        ac aFF = e.aFF();
        long Nz = bg.Nz();
        ArrayList bLm = aFF.bLm();
        if (bLm == null) {
            return null;
        }
        aFF.bLn();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < bLm.size(); i++) {
            ArrayList arrayList2 = (ArrayList) aFF.uII.get(Integer.valueOf(((z) bLm.get(i)).field_labelID));
            if (arrayList2 != null && arrayList2.size() > 0) {
                arrayList.add(((z) bLm.get(i)).field_labelName);
            }
        }
        w.i("MicroMsg.Label.ContactLabelStorage", "getAllLabelHasContact time:%s all:%s hascontact:%s stack:%s", new Object[]{Long.valueOf(bg.aA(Nz)), Integer.valueOf(bLm.size()), Integer.valueOf(arrayList.size()), bg.bJZ()});
        return arrayList;
    }

    public final List<String> zf(String str) {
        if (bg.mA(str)) {
            w.w("MicroMsg.Label.ContactLabelManagerImpl", "labels is null.");
            return null;
        }
        String[] split = str.split(",");
        if (split == null || split.length <= 0) {
            return null;
        }
        List<String> arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(split));
        return arrayList;
    }

    public final String aI(List<String> list) {
        if (list == null || list.isEmpty()) {
            w.w("MicroMsg.Label.ContactLabelManagerImpl", "labelList is empty");
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append((String) list.get(i));
            if (i < size - 1) {
                stringBuilder.append(",");
            }
        }
        return stringBuilder.toString();
    }

    public final synchronized void cE(String str, String str2) {
        w.i("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] user:%s labels:%s", new Object[]{str, str2});
        if (bg.mA(str2)) {
            w.w("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] labels is null.");
        } else {
            ArrayList arrayList = (ArrayList) zf(str2);
            if (arrayList == null || arrayList.isEmpty()) {
                w.w("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] labelList is null.");
            } else {
                this.username = str;
                this.mYN = arrayList;
                int size = arrayList.size();
                this.mYO = new ArrayList();
                for (int i = 0; i < size; i++) {
                    z QT = e.aFF().QT((String) arrayList.get(i));
                    if (QT != null && QT.field_isTemporary) {
                        this.mYO.add(arrayList.get(i));
                    }
                }
                ap.vd().a(635, this.mYP);
                ap.vd().a(638, this.mYP);
                if (this.mYO == null || this.mYO.isEmpty()) {
                    e(str, arrayList);
                    aFC();
                } else {
                    w.i("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel]addList:%s", new Object[]{this.mYO.toString()});
                    ap.vd().a(new com.tencent.mm.plugin.label.b.a(this.mYO), 0);
                }
            }
        }
    }

    public final void aFC() {
        this.username = null;
        this.mYN = null;
        this.mYO = null;
        ap.vd().b(635, this.mYP);
        ap.vd().b(638, this.mYP);
    }

    public static void e(String str, ArrayList<String> arrayList) {
        String str2 = "MicroMsg.Label.ContactLabelManagerImpl";
        String str3 = "cpan[saveContact] username:%s,list:%s";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = arrayList == null ? "" : arrayList.toString();
        w.d(str2, str3, objArr);
        if (bg.mA(str) || arrayList == null || arrayList.size() <= 0) {
            w.e("MicroMsg.Label.ContactLabelManagerImpl", "add contact label faild.");
            return;
        }
        String str4 = "";
        if (arrayList != null && arrayList.size() > 0) {
            str4 = c.aK(e.aFF().af(arrayList));
        }
        LinkedList linkedList = new LinkedList();
        bio com_tencent_mm_protocal_c_bio = new bio();
        com_tencent_mm_protocal_c_bio.tts = str4;
        com_tencent_mm_protocal_c_bio.jNj = str;
        linkedList.add(com_tencent_mm_protocal_c_bio);
        ap.vd().a(new d(linkedList), 0);
    }

    public final void aJ(List<String> list) {
        ap.vd().a(new com.tencent.mm.plugin.label.b.a((List) list), 0);
    }

    public final void h(List<String> list, List<String> list2) {
        String str;
        String str2;
        Map hashMap = new HashMap();
        LinkedList linkedList = new LinkedList();
        if (list.size() > 0) {
            Iterator it = list2.iterator();
            for (String str22 : list) {
                List<String> f = bg.f(((String) it.next()).split(","));
                if (f != null && f.size() > 0) {
                    for (String str3 : f) {
                        String str4;
                        String cF;
                        if (hashMap.containsKey(str3)) {
                            str4 = (String) hashMap.get(str3);
                            cF = c.cF(str4, str22);
                            if (!cF.equalsIgnoreCase(str4)) {
                                hashMap.put(str3, cF);
                            }
                        } else {
                            ap.yY();
                            af Rc = c.wR().Rc(str3);
                            if (Rc != null) {
                                str4 = Rc.field_contactLabelIds;
                                cF = c.cF(str4, str22);
                                if (!cF.equalsIgnoreCase(str4)) {
                                    hashMap.put(str3, cF);
                                }
                            }
                        }
                    }
                }
            }
        }
        for (Entry entry : hashMap.entrySet()) {
            str3 = (String) entry.getKey();
            str22 = (String) entry.getValue();
            bio com_tencent_mm_protocal_c_bio = new bio();
            com_tencent_mm_protocal_c_bio.jNj = str3;
            com_tencent_mm_protocal_c_bio.tts = str22;
            linkedList.add(com_tencent_mm_protocal_c_bio);
        }
        if (linkedList.size() > 0) {
            ap.vd().a(new d(linkedList), 0);
        }
    }
}
