package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.a.f;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Map;

public final class e {
    private static final f<Integer, e> hkd = new f(100);
    public String fCW;
    public int hhq;
    public String hhr;
    public int qTd;
    public int qTe;
    public String qTf;
    public int qTg;
    public int qTh;
    public int qTi;
    public int qTj;

    public static e Hk(String str) {
        if (bg.mA(str)) {
            return null;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        int hashCode = str.hashCode();
        e eVar = (e) hkd.get(Integer.valueOf(hashCode));
        if (eVar != null) {
            return eVar;
        }
        Map q = bh.q(str, "msg");
        if (q == null) {
            w.e("MicroMsg.VoiceRemindAppMsgExInfo", "parse msg failed");
            return null;
        }
        try {
            e eVar2 = new e();
            eVar2.hhq = bg.getInt((String) q.get(".msg.appmsg.appattach.totallen"), 0);
            eVar2.fCW = (String) q.get(".msg.appmsg.appattach.attachid");
            eVar2.hhr = (String) q.get(".msg.appmsg.appattach.fileext");
            eVar2.qTd = bg.getInt((String) q.get(".msg.appmsg.voicecmd.reminder.$remindtime"), 0);
            eVar2.qTe = bg.getInt((String) q.get(".msg.appmsg.voicecmd.reminder.$remindid"), 0);
            eVar2.qTf = (String) q.get(".msg.appmsg.voicecmd.reminder.$remindattachid");
            eVar2.qTg = bg.getInt((String) q.get(".msg.appmsg.voicecmd.reminder.$remindattachtotallen"), 0);
            eVar2.qTh = bg.getInt((String) q.get(".msg.appmsg.voicecmd.reminder.$remindformat"), 0);
            eVar2.qTi = bg.getInt((String) q.get(".msg.appmsg.voicecmd.reminder.$originformat"), 0);
            eVar2.qTj = bg.getInt((String) q.get(".msg.appmsg.voicecmd.reminder.$msgsvrid"), 0);
            hkd.k(Integer.valueOf(hashCode), eVar2);
            return eVar2;
        } catch (Throwable e) {
            w.e("MicroMsg.VoiceRemindAppMsgExInfo", "parse amessage xml failed");
            w.printErrStackTrace("MicroMsg.VoiceRemindAppMsgExInfo", e, "", new Object[0]);
            return null;
        }
    }
}
