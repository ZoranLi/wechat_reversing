package com.tencent.mm.plugin.wallet_core.model.mall;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class c {
    private static c rIT = null;
    public Map<String, MallNews> rIU = new HashMap();

    public static c buC() {
        if (rIT == null) {
            rIT = new c();
        }
        return rIT;
    }

    private c() {
        Oe();
    }

    public final void Oe() {
        this.rIU.clear();
        ap.yY();
        String str = (String) com.tencent.mm.u.c.vr().get(270339, "");
        w.d("MicroMsg.MallNewsManager", "data : " + str);
        for (String str2 : bg.f(str2.split(";"))) {
            MallNews Ic = Ic(str2);
            if (Ic != null) {
                this.rIU.put(Ic.rIK, Ic);
            }
        }
    }

    public final List<String> buD() {
        List<String> arrayList = new ArrayList();
        for (MallNews mallNews : this.rIU.values()) {
            if (!bg.mA(mallNews.fGV)) {
                arrayList.add(mallNews.fGV);
            }
        }
        w.d("MicroMsg.MallNewsManager", "tickets.size : " + arrayList.size());
        return arrayList;
    }

    public static boolean a(MallNews mallNews) {
        ap.yY();
        List f = bg.f(((String) com.tencent.mm.u.c.vr().get(a.uGc, "")).split(","));
        w.i("MicroMsg.MallNewsManager", "tryCheckOutOfDateRedDot markedString %s", new Object[]{r0});
        if (mallNews == null) {
            return false;
        }
        if (bg.mA(mallNews.qSx)) {
            return false;
        }
        if (f.contains(mallNews.qSx)) {
            return true;
        }
        return false;
    }

    public static void c(MallFunction mallFunction) {
        try {
            if (!bg.mA(mallFunction.rID.qSx)) {
                ap.yY();
                List f = bg.f(((String) com.tencent.mm.u.c.vr().get(a.uGc, "")).split(","));
                while (f.size() > 20) {
                    f.remove(0);
                }
                if (!f.contains(mallFunction.rID.qSx)) {
                    f.add(mallFunction.rID.qSx);
                    w.i("MicroMsg.MallNewsManager", "doSelectFunction %s, markedString %s", new Object[]{mallFunction.rID.qSx, bg.c(f, ",")});
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(a.uGc, r0);
                }
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MallNewsManager", e, "error in markedFunction", new Object[0]);
        }
    }

    public static void HZ(String str) {
        if (!bg.mA(str)) {
            Map q = bh.q(str, "sysmsg");
            if (q != null && bg.getInt((String) q.get(".sysmsg.paymsg.PayMsgType"), -1) == 31) {
                String str2 = (String) q.get(".sysmsg.paymsg.WalletRedDotWording");
                int i = bg.getInt((String) q.get(".sysmsg.paymsg.WalletRedDot"), -1);
                w.i("MicroMsg.MallNewsManager", "walletEntryWording: %s, balanceRedDot: %s, lqtRedDot: %s", new Object[]{str2, Integer.valueOf(bg.getInt((String) q.get(".sysmsg.paymsg.BalanceRedDot"), -1)), Integer.valueOf(bg.getInt((String) q.get(".sysmsg.paymsg.LQTRedDot"), -1))});
                ap.yY();
                com.tencent.mm.u.c.vr().a(a.uId, str2);
                ap.yY();
                com.tencent.mm.u.c.vr().a(a.uIe, Integer.valueOf(i));
                ap.yY();
                com.tencent.mm.u.c.vr().a(a.uIf, Integer.valueOf(r4));
                ap.yY();
                com.tencent.mm.u.c.vr().a(a.uIg, Integer.valueOf(r1));
                buF();
            }
        }
    }

    public static void buE() {
        ap.yY();
        com.tencent.mm.u.c.vr().a(a.uId, "");
        ap.yY();
        com.tencent.mm.u.c.vr().a(a.uIe, Integer.valueOf(-1));
    }

    public static void buF() {
        w.d("MicroMsg.MallNewsManager", "clearMallNew ");
        com.tencent.mm.q.c.uk().aE(262156, 266248);
    }

    public final boolean aTl() {
        w.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.rIU.size());
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.rIU.keySet()) {
            if (!bg.mA(str)) {
                MallNews mallNews = (MallNews) this.rIU.get(str);
                stringBuffer.append(mallNews.rIR.replace("</mallactivity></sysmsg>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<showflag>" + mallNews.rII + "</showflag><newsTipFlag>" + mallNews.rIJ + "</newsTipFlag></mallactivity></sysmsg>;");
            }
        }
        w.d("MicroMsg.MallNewsManager", "save data  : " + stringBuffer.toString());
        ap.yY();
        com.tencent.mm.u.c.vr().set(270339, stringBuffer.toString());
        return true;
    }

    public final String Ia(String str) {
        MallNews mallNews = (MallNews) this.rIU.get(str);
        if (mallNews == null || bg.mA(mallNews.fGV)) {
            return null;
        }
        return mallNews.fGV;
    }

    public final MallNews Ib(String str) {
        w.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : " + str);
        if (bg.mA(str) || !this.rIU.containsKey(str)) {
            return null;
        }
        MallNews mallNews = (MallNews) this.rIU.get(str);
        if (!"0".equals(mallNews.rII)) {
            return mallNews;
        }
        mallNews.rII = "1";
        aTl();
        return mallNews;
    }

    public static MallNews Ic(String str) {
        if (bg.mA(str)) {
            return null;
        }
        Map q = bh.q(str, "sysmsg");
        if (q == null) {
            return null;
        }
        try {
            MallNews mallNews = new MallNews((String) q.get(".sysmsg.mallactivity.functionid"));
            mallNews.qSx = (String) q.get(".sysmsg.mallactivity.activityid");
            mallNews.fGV = (String) q.get(".sysmsg.mallactivity.ticket");
            mallNews.type = (String) q.get(".sysmsg.mallactivity.type");
            mallNews.showType = bg.getInt((String) q.get(".sysmsg.mallactivity.showtype"), 0);
            if (q.containsKey(".sysmsg.mallactivity.showflag")) {
                mallNews.rII = (String) q.get(".sysmsg.mallactivity.showflag");
            } else {
                mallNews.rII = "0";
            }
            if (q.containsKey(".sysmsg.mallactivity.newsTipFlag")) {
                mallNews.rIJ = (String) q.get(".sysmsg.mallactivity.newsTipFlag");
            } else {
                mallNews.rIJ = "0";
            }
            mallNews.rIR = str;
            if (bg.mA(mallNews.rIK)) {
                return null;
            }
            return mallNews;
        } catch (Exception e) {
            w.e("MicroMsg.MallNewsManager", "cmdid error");
            return null;
        }
    }

    public final void U(ArrayList<MallFunction> arrayList) {
        if (arrayList != null) {
            Set<String> hashSet = new HashSet(this.rIU.keySet());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                hashSet.remove(((MallFunction) it.next()).oKW);
            }
            for (String remove : hashSet) {
                this.rIU.remove(remove);
            }
            aTl();
        }
    }
}
