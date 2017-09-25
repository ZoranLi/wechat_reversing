package com.tencent.mm.plugin.wallet_core.model.mall;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.HashMap;
import java.util.Map;

public final class d {
    private static d rIV = null;
    public Map<String, MallNews> rIU = new HashMap();

    public static d buG() {
        if (rIV == null) {
            rIV = new d();
        }
        return rIV;
    }

    private d() {
        Oe();
    }

    public final void Oe() {
        this.rIU.clear();
        ap.yY();
        String str = (String) c.vr().get(270341, "");
        w.d("MicroMsg.MallNewsManagerNewVersion", "data : " + str);
        for (String str2 : bg.f(str2.split(";"))) {
            MallNews Ic = Ic(str2);
            if (Ic != null) {
                this.rIU.put(Ic.rIK, Ic);
            }
        }
    }

    public final boolean aTl() {
        w.d("MicroMsg.MallNewsManagerNewVersion", "notifyNewsMap.size : " + this.rIU.size());
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.rIU.keySet()) {
            if (!bg.mA(str)) {
                MallNews mallNews = (MallNews) this.rIU.get(str);
                stringBuffer.append(mallNews.rIR.replace("</mallactivitynew></sysmsg>;", "").replaceAll("<activityid>([^<]*)</activityid>", "").replaceAll("<type>([^<]*)</type>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<activityid>" + mallNews.qSx + "</activityid><type>" + mallNews.type + "</type><showflag>" + mallNews.rII + "</showflag><newsTipFlag>" + mallNews.rIJ + "</newsTipFlag></mallactivitynew></sysmsg>;");
            }
        }
        w.d("MicroMsg.MallNewsManagerNewVersion", "save data  : " + stringBuffer.toString());
        ap.yY();
        c.vr().set(270341, stringBuffer.toString());
        return true;
    }

    public final MallNews Id(String str) {
        return (MallNews) this.rIU.get(str);
    }

    public final MallNews Ib(String str) {
        w.d("MicroMsg.MallNewsManagerNewVersion", "removeNewsInIndexUI : " + str);
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

    private static MallNews Ic(String str) {
        if (bg.mA(str)) {
            return null;
        }
        Map q = bh.q(str, "sysmsg");
        if (q == null) {
            return null;
        }
        try {
            MallNews mallNews = new MallNews((String) q.get(".sysmsg.mallactivitynew.functionid"));
            mallNews.qSx = (String) q.get(".sysmsg.mallactivitynew.activityid");
            mallNews.type = (String) q.get(".sysmsg.mallactivitynew.type");
            mallNews.showType = bg.getInt((String) q.get(".sysmsg.mallactivitynew.showtype"), 0);
            if (q.containsKey(".sysmsg.mallactivitynew.showflag")) {
                mallNews.rII = (String) q.get(".sysmsg.mallactivitynew.showflag");
            } else {
                mallNews.rII = "0";
            }
            if (q.containsKey(".sysmsg.mallactivitynew.newsTipFlag")) {
                mallNews.rIJ = (String) q.get(".sysmsg.mallactivitynew.newsTipFlag");
            } else {
                mallNews.rIJ = "0";
            }
            mallNews.rIR = str;
            if (bg.mA(mallNews.rIK)) {
                return null;
            }
            return mallNews;
        } catch (Exception e) {
            w.e("MicroMsg.MallNewsManagerNewVersion", "cmdid error");
            return null;
        }
    }
}
