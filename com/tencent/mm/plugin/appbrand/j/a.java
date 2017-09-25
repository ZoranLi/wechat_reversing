package com.tencent.mm.plugin.appbrand.j;

import android.database.Cursor;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.as.b;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import java.util.Map;

public final class a implements com.tencent.mm.storage.as.a {
    public final void a(ae aeVar, as asVar) {
        if (aeVar != null && !bg.mA(aeVar.field_username)) {
            String str = aeVar.field_username;
            ap.yY();
            com.tencent.mm.j.a Rc = c.wR().Rc(str);
            if (Rc == null || ((int) Rc.gTQ) == 0) {
                w.e("MicroMsg.AppBrandConversionExtension", "contact is null or contactId is 0 for %s", new Object[]{str});
            } else if (x.em(str) && !o.fh(str)) {
                w.i("MicroMsg.AppBrandConversionExtension", "this conversation is a app brand contact!");
                aeVar.cw("appbrandcustomerservicemsg");
                ap.yY();
                ae Rm = c.wW().Rm("appbrandcustomerservicemsg");
                if (Rm == null) {
                    w.i("MicroMsg.AppBrandConversionExtension", "create parentConv");
                    Rm = new ae("appbrandcustomerservicemsg");
                    Rm.bLB();
                    a(aeVar, Rm);
                    ap.yY();
                    c.wW().d(Rm);
                    return;
                }
                w.i("MicroMsg.AppBrandConversionExtension", "appBrandSuperConv is created");
                Rm.cw(null);
                a(aeVar, Rm);
                ap.yY();
                c.wW().a(Rm, "appbrandcustomerservicemsg");
            } else if (o.fD(str)) {
                w.i("MicroMsg.AppBrandConversionExtension", "appBrandSuperConv is created");
                aeVar.cw(null);
            }
        }
    }

    private static void a(ae aeVar, ae aeVar2) {
        aj ajVar;
        ce Ai;
        String str = null;
        ap.yY();
        Cursor c = c.wW().c(o.hlw, null, "appbrandcustomerservicemsg");
        if (c != null) {
            if (c.getCount() <= 0 || !c.moveToFirst()) {
                ajVar = null;
            } else {
                ajVar = new ae();
                ajVar.b(c);
            }
            c.close();
        } else {
            ajVar = null;
        }
        if (ajVar != null) {
            w.e("MicroMsg.AppBrandConversionExtension", "The lastest app brand conversation username is %s", new Object[]{ajVar.field_username});
            ap.yY();
            Ai = c.wT().Ai(ajVar.field_username);
        } else {
            w.e("MicroMsg.AppBrandConversionExtension", "The lastest app brand conversation is null");
            ap.yY();
            Ai = c.wT().Ai(aeVar.field_username);
        }
        if (Ai == null || Ai.field_msgId <= 0) {
            w.e("MicroMsg.AppBrandConversionExtension", "the last of msg is null'");
            aeVar2.bLB();
            return;
        }
        aeVar2.W(Ai);
        aeVar2.setContent(Ai.field_talker + ":" + Ai.field_content);
        aeVar2.ct(Integer.toString(Ai.field_type));
        ap.yY();
        b oG = c.wW().oG();
        if (oG != null) {
            PString pString = new PString();
            PString pString2 = new PString();
            PInt pInt = new PInt();
            Ai.cH(aeVar.field_parentRef);
            Ai.setContent(aeVar2.field_content);
            oG.a(Ai, pString, pString2, pInt, true);
            int i = Ai.field_type;
            String str2 = Ai.field_content;
            if (!bg.mA(str2)) {
                switch (i) {
                    case 49:
                        Map q = bh.q(str2, "msg");
                        if (q != null) {
                            w.d("MicroMsg.AppBrandConversionExtension", "[oneliang][parseConversationMsgContentTitle] title:%s", new Object[]{(String) q.get(".msg.appmsg.title")});
                            str = r0;
                            break;
                        }
                        break;
                }
            }
            aeVar2.cu(bg.mz(pString.value).concat(bg.mA(str) ? "" : " " + bg.mz(str)));
            aeVar2.cv(pString2.value);
            aeVar2.dx(pInt.value);
        }
    }
}
