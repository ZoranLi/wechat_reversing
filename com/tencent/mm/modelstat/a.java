package com.tencent.mm.modelstat;

import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;

public final class a {

    public enum a {
        Expose(1),
        Click(2);
        
        public int value;

        private a(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public static void a(au auVar, a aVar) {
        if (!bg.mA(auVar.gxO)) {
            int i;
            d dVar = new d();
            dVar.n("20ExpIdStr", auVar.gxO + ",");
            dVar.n("21OpType", aVar.value + ",");
            dVar.n("22msgId", auVar.field_msgSvrId + ",");
            dVar.n("23MessageType", auVar.field_type + ",");
            if (auVar.axO()) {
                com.tencent.mm.t.f.a B = com.tencent.mm.t.f.a.B(auVar.field_content, auVar.field_reserved);
                i = B == null ? 0 : B.type;
            } else {
                i = 0;
            }
            String str = auVar.field_talker;
            dVar.n("24AppMsgInnerType", i + ",");
            dVar.n("25curUsername", str + ",");
            String str2 = "";
            if (auVar.field_isSend == 1) {
                str2 = m.xL();
            } else if (str == null || !str.endsWith("@chatroom")) {
                str2 = str;
            } else if (auVar.field_content != null) {
                int gh = ay.gh(auVar.field_content);
                if (gh != -1) {
                    str2 = auVar.field_content.substring(0, gh).trim();
                }
            }
            dVar.n("26msgPostUserName", str2 + ",");
            dVar.n("27MediaState", auVar.gxP + ",");
            w.v("MicroMsg.ChattingExpUtil", "report logbuffer(13564): [chatting_exp]" + dVar.JG());
            g.oUh.i(13564, dVar);
        }
    }
}
