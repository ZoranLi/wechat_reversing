package com.tencent.mm.ab;

import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as.b;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ab;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;

public final class e extends ab {
    public final boolean eX(int i) {
        return i != 0 && i < 604372991;
    }

    public final void transfer(int i) {
        w.d("MicroMsg.ConversationDataTransfer", "the previous version is %d", Integer.valueOf(i));
        if (i != 0 && i < 604372991) {
            ap.yY();
            g wO = c.wO();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select rconversation.username").append(" from rconversation, rcontact").append(", bizinfo where rconversation").append(".username = rcontact").append(".username and rconversation").append(".username = bizinfo").append(".username and ( rcontact").append(".verifyFlag & 8").append(" ) != 0 ");
            w.d("MicroMsg.ConversationDataTransfer", "select sql %s", stringBuilder.toString());
            Cursor a = wO.a(r1, null, 2);
            if (a != null && a.moveToFirst()) {
                ae aeVar;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Update rconversation set parentRef").append(" = 'officialaccounts' where 1 !=1 ");
                do {
                    String string = a.getString(0);
                    if (!o.fC(string)) {
                        stringBuilder.append(" or username = '").append(string).append("'");
                    }
                } while (a.moveToNext());
                a.close();
                w.d("MicroMsg.ConversationDataTransfer", "changed[%B] exec sql[%s]", Boolean.valueOf(true), stringBuilder.toString());
                wO.eE("rconversation", r1);
                ap.yY();
                aj Rm = c.wW().Rm("officialaccounts");
                if (Rm == null) {
                    Rm = new ae("officialaccounts");
                    Rm.bLB();
                    ap.yY();
                    c.wW().d(Rm);
                    aeVar = Rm;
                } else {
                    aj ajVar = Rm;
                }
                ap.yY();
                String bLL = c.wW().bLL();
                if (bg.mA(bLL)) {
                    w.w("MicroMsg.ConversationDataTransfer", "last convBiz is null");
                    return;
                }
                ap.yY();
                au Ai = c.wT().Ai(bLL);
                if (Ai == null || Ai.field_msgId == 0) {
                    w.w("MicroMsg.ConversationDataTransfer", "last biz msg is error");
                    return;
                }
                aeVar.W(Ai);
                aeVar.setContent(Ai.field_talker + ":" + Ai.field_content);
                aeVar.ct(Integer.toString(Ai.field_type));
                ap.yY();
                b oG = c.wW().oG();
                if (oG != null) {
                    PString pString = new PString();
                    PString pString2 = new PString();
                    PInt pInt = new PInt();
                    Ai.cH("officialaccounts");
                    Ai.setContent(aeVar.field_content);
                    oG.a(Ai, pString, pString2, pInt, false);
                    aeVar.cu(pString.value);
                    aeVar.cv(pString2.value);
                    aeVar.dx(pInt.value);
                }
                ap.yY();
                c.wW().a(aeVar, aeVar.field_username);
            }
            if (a != null && !a.isClosed()) {
                a.close();
            }
        }
    }

    public final String getTag() {
        return "MicroMsg.ConversationDataTransfer";
    }
}
