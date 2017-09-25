package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.bd.b;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.wallet.a.f;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class a {
    public f rJd = null;
    Map<String, p> rJe = null;
    Map<String, h> rJf = null;

    public static final class a {
        public String ofY;
        public h rJg;
        public double rJh;
        public String rJi;
    }

    public a(f fVar) {
        Assert.assertNotNull(fVar);
        this.rJd = fVar;
        Oe();
    }

    private void Oe() {
        int i = 0;
        this.rJe = new HashMap();
        List list = this.rJd.rxQ;
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                p pVar = (p) list.get(i2);
                this.rJe.put(pVar.rxJ, pVar);
            }
        } else {
            w.w("MicroMsg.FavorLogicHelper", "func[initData] favorList null");
        }
        this.rJf = new HashMap();
        if (this.rJd.rxR == null || this.rJd.rxR.ryb == null) {
            w.w("MicroMsg.FavorLogicHelper", "func[initData] favorComposeList null");
            return;
        }
        List list2 = this.rJd.rxR.ryb;
        while (i < list2.size()) {
            h hVar = (h) list2.get(i);
            this.rJf.put(hVar.ryd, hVar);
            i++;
        }
    }

    public final Map<String, a> Ig(String str) {
        return au(str, false);
    }

    public final Map<String, a> au(String str, boolean z) {
        Map<String, a> hashMap = new HashMap();
        if (this.rJd.rxR == null || this.rJd.rxR.ryb == null) {
            w.w("MicroMsg.FavorLogicHelper", "favorComposeList null or favorComposeList.favorComposeInfo null");
        } else {
            double d;
            List list = this.rJd.rxR.ryb;
            if (this.rJf.containsKey(str)) {
                d = ((h) this.rJf.get(str)).rye;
            } else {
                d = 0.0d;
            }
            for (int i = 0; i < list.size(); i++) {
                h hVar = (h) list.get(i);
                String str2 = null;
                if (str.equals("0") && !hVar.equals("0")) {
                    str2 = hVar.ryd;
                } else if (hVar.ryd.startsWith(str) && !str.equals(hVar.ryd)) {
                    str2 = hVar.ryd.replace(str + "-", "");
                }
                String[] Ij = Ij(str2);
                if (Ij != null && Ij.length > 0) {
                    p pVar = (p) this.rJe.get(Ij[0]);
                    if (pVar != null) {
                        if ((pVar.ryA != 0 ? 1 : null) != null && !bg.mA(pVar.ryB) && pVar.ryD.size() <= 0 && (z || !pVar.ryB.equalsIgnoreCase("CFT"))) {
                            a aVar = (a) hashMap.get(pVar.ryB);
                            if (aVar == null || hVar.rye > aVar.rJg.rye) {
                                aVar = new a();
                                aVar.rJg = hVar;
                                aVar.ofY = pVar.ofY;
                                aVar.rJh = hVar.rye - d;
                                aVar.rJi = pVar.ryB;
                                hashMap.put(pVar.ryB, aVar);
                            }
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    public final List<p> Ih(String str) {
        List<p> linkedList = new LinkedList();
        if (this.rJd.rxQ != null) {
            Map Ig = Ig(str);
            for (int i = 0; i < this.rJd.rxQ.size(); i++) {
                p pVar = (p) this.rJd.rxQ.get(i);
                if (pVar != null) {
                    Object obj;
                    if (pVar.ryA != 0) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null && Ig.containsKey(pVar.ryB)) {
                        linkedList.add(pVar);
                    }
                }
            }
        } else {
            w.w("MicroMsg.FavorLogicHelper", "fucn[getBankFavorListWithSelectedCompId] mFavorInfo.tradeFavList null");
        }
        return linkedList;
    }

    public final h Ii(String str) {
        return (h) this.rJf.get(str);
    }

    public static String[] Ij(String str) {
        if (bg.mA(str)) {
            return null;
        }
        return str.split("-");
    }

    public final String Ik(String str) {
        return av(str, false);
    }

    public final String av(String str, boolean z) {
        String[] Ij = Ij(str);
        if (Ij == null) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Ij.length; i++) {
            p pVar = (p) this.rJe.get(Ij[i]);
            if (pVar != null) {
                Object obj;
                if (pVar.ryA != 0) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null || (bg.mA(pVar.ryB) && !z)) {
                    stringBuilder.append(Ij[i]);
                    stringBuilder.append("-");
                }
            }
        }
        if (stringBuilder.length() == 0) {
            return "0";
        }
        return stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length()).toString();
    }

    public final FavorPayInfo Il(String str) {
        FavorPayInfo favorPayInfo = new FavorPayInfo();
        if (this.rJf.get(str) == null) {
            favorPayInfo.rFm = "0";
            if (this.rJd != null) {
                favorPayInfo.rFp = this.rJd.rxP;
            }
            favorPayInfo.rFn = 0;
            return favorPayInfo;
        }
        favorPayInfo.rFm = str;
        if (this.rJd != null) {
            favorPayInfo.rFp = this.rJd.rxP;
        }
        favorPayInfo.rFn = 0;
        String[] Ij = Ij(str);
        if (Ij == null) {
            return favorPayInfo;
        }
        for (int length = Ij.length - 1; length >= 0; length--) {
            p pVar = (p) this.rJe.get(Ij[length]);
            if (pVar != null) {
                if ((pVar.ryA != 0 ? 1 : 0) == 0) {
                    break;
                }
                favorPayInfo.rFn = 1;
                if (pVar.ryD != null && pVar.ryD.size() > 0) {
                    favorPayInfo.rFr = new LinkedList();
                    Iterator it = pVar.ryD.iterator();
                    while (it.hasNext()) {
                        favorPayInfo.rFr.add(n.a((b) it.next()));
                    }
                }
                if (!bg.mA(pVar.ryB)) {
                    favorPayInfo.rFo = pVar.ryB;
                    break;
                }
            }
        }
        return favorPayInfo;
    }

    public static boolean a(FavorPayInfo favorPayInfo, Bankcard bankcard) {
        if (bankcard == null) {
            w.w("MicroMsg.FavorLogicHelper", "curBankcard null");
            return true;
        }
        if (!(favorPayInfo == null || bg.mA(favorPayInfo.rFm))) {
            boolean z;
            if (favorPayInfo.rFn != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z && !bg.mA(favorPayInfo.rFo) && favorPayInfo.rFr != null && favorPayInfo.rFr.contains(bankcard.field_bindSerial)) {
                return false;
            }
        }
        if (favorPayInfo.rFn != 0) {
            if (!bg.mA(favorPayInfo.rFo) && bankcard.field_bankcardType != null && !bankcard.field_bankcardType.equals(favorPayInfo.rFo)) {
                return true;
            }
            if (bg.mA(favorPayInfo.rFo) && bankcard.field_bankcardType.equals("CFT")) {
                return true;
            }
        }
        return false;
    }

    private static String bK(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(((String) list.get(i)));
            if (i < list.size() - 1) {
                stringBuilder.append("-");
            }
        }
        return stringBuilder.toString();
    }

    public final String Im(String str) {
        ArrayList it = m.btS().it(true);
        Map hashMap = new HashMap();
        List arrayList = new ArrayList();
        for (int i = 0; i < it.size(); i++) {
            hashMap.put(((Bankcard) it.get(i)).field_bankcardType, Integer.valueOf(0));
        }
        String[] Ij = Ij(str);
        if (Ij != null) {
            for (Object obj : Ij) {
                p pVar = (p) this.rJe.get(obj);
                if (pVar != null) {
                    boolean z;
                    if (pVar.ryA != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (hashMap.containsKey(pVar.ryB) || bg.mA(pVar.ryB)) {
                            arrayList.add(obj);
                        } else {
                        }
                    }
                }
                arrayList.add(obj);
            }
        }
        if (arrayList.size() == 0) {
            return "0";
        }
        return bK(arrayList);
    }

    public final List<p> buM() {
        int i;
        ArrayList it = m.btS().it(true);
        Map hashMap = new HashMap();
        for (i = 0; i < it.size(); i++) {
            hashMap.put(((Bankcard) it.get(i)).field_bankcardType, Integer.valueOf(0));
        }
        List<p> linkedList = new LinkedList();
        List list = this.rJd.rxQ;
        if (list != null) {
            for (i = 0; i < list.size(); i++) {
                p pVar = (p) list.get(i);
                if (pVar != null) {
                    boolean z;
                    if (pVar.ryA != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (hashMap.containsKey(pVar.ryB) || bg.mA(pVar.ryB)) {
                            linkedList.add(pVar);
                        } else {
                        }
                    }
                }
                linkedList.add(pVar);
            }
        }
        return linkedList;
    }
}
