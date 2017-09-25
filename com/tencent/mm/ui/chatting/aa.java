package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.n;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.t.k;
import com.tencent.mm.t.l;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.u.q;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class aa {
    public static boolean ac(au auVar) {
        if (auVar == null) {
            w.w("MicroMsg.ChattingEditModeLogic", "check is store emoji error, msg is null");
            return true;
        }
        c ub;
        if (auVar.bMo()) {
            a aVar;
            aj ajVar = new aj(auVar.field_content);
            a B = a.B(auVar.field_content, auVar.field_reserved);
            if (B == null) {
                B = new a();
                B.hhs = ajVar.fFW;
                aVar = B;
            } else {
                aVar = B;
            }
            ub = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(aVar.hhs);
        } else {
            ub = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(auVar.field_imgPath);
        }
        if (ub != null && (ub.field_catalog == c.uKY || (!bg.mA(ub.field_groupId) && ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().uf(ub.field_groupId)))) {
            return false;
        }
        if (ub == null || !ub.bNv()) {
            return false;
        }
        return true;
    }

    public static boolean ad(au auVar) {
        if (auVar.bMo()) {
            a aVar;
            aj ajVar = new aj(auVar.field_content);
            a B = a.B(auVar.field_content, auVar.field_reserved);
            if (B == null) {
                B = new a();
                B.hhs = ajVar.fFW;
                aVar = B;
            } else {
                aVar = B;
            }
            if (((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(aVar.hhs) == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean ae(au auVar) {
        if (auVar == null) {
            w.w("MicroMsg.ChattingEditModeLogic", "check is game msg error, msg is null");
            return true;
        }
        String gj;
        if (auVar.field_isSend == 0) {
            gj = ay.gj(auVar.field_content);
        } else {
            gj = auVar.field_content;
        }
        a ek = a.ek(gj);
        if (ek == null) {
            w.w("MicroMsg.ChattingEditModeLogic", "parse app message content fail");
            return false;
        }
        f aJ = g.aJ(ek.appId, false);
        return aJ != null && aJ.bCU();
    }

    public static boolean af(au auVar) {
        return auVar.field_type == 419430449;
    }

    public static boolean ag(au auVar) {
        return auVar.field_type == 436207665 || auVar.field_type == 469762097;
    }

    public static boolean ah(au auVar) {
        if (auVar == null) {
            w.w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, check msg error, msg is null");
            return true;
        }
        String gj;
        if (auVar.field_isSend == 0) {
            gj = ay.gj(auVar.field_content);
        } else {
            gj = auVar.field_content;
        }
        a ek = a.ek(gj);
        if (ek != null) {
            return ek.type == 33 && ek.hjO == 3;
        } else {
            w.w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, parse app message content fail");
            return false;
        }
    }

    public static boolean cu(List<au> list) {
        if (list == null || list.isEmpty()) {
            w.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to brand msg error, selected item empty");
            return true;
        }
        for (au auVar : list) {
            if (auVar.bLZ() || ac(auVar) || auVar.bMi() || ae(auVar) || af(auVar) || auVar.field_type == -1879048186 || ak(auVar) || ag(auVar) || aj(auVar) || ah(auVar)) {
                return true;
            }
            if (an(auVar)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(List<au> list, dz dzVar) {
        if (list == null || list.isEmpty()) {
            w.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
            return false;
        } else if (list.size() == 1) {
            r0 = (au) list.get(0);
            if (al(r0) || r0.bLZ() || ac(r0) || ae(r0) || af(r0) || r0.field_type == -1879048186 || r0.field_type == 318767153 || ak(r0) || ag(r0) || am(r0) || aj(r0) || ah(r0)) {
                return false;
            }
            return true;
        } else {
            Iterator it = list.iterator();
            boolean z = true;
            while (it.hasNext()) {
                boolean z2;
                r0 = (au) it.next();
                if (!(r0.bLZ() || ac(r0) || ae(r0) || af(r0) || r0.field_type == -1879048186 || ak(r0) || ag(r0))) {
                    a ek;
                    boolean z3;
                    if (r0 != null) {
                        ek = a.ek(r0.field_content);
                        if (ek != null && ek.type == 19) {
                            z3 = ek.hhQ != null && ek.hhQ.contains("<recordxml>");
                            if (!z3 || (dzVar != null && dzVar.bUF())) {
                                if (r0 != null) {
                                    ek = a.ek(r0.field_content);
                                    if (ek != null && ek.type == 24) {
                                        z3 = true;
                                        if (!((z3 && (dzVar == null || !dzVar.bUF())) || r0.field_type == 318767153 || al(r0) || am(r0) || aj(r0) || ah(r0))) {
                                            z2 = z;
                                            z = z2;
                                        }
                                    }
                                }
                                z3 = false;
                                z2 = z;
                                z = z2;
                            }
                        }
                    }
                    z3 = false;
                    if (r0 != null) {
                        ek = a.ek(r0.field_content);
                        z3 = true;
                        z2 = z;
                        z = z2;
                    }
                    z3 = false;
                    z2 = z;
                    z = z2;
                }
                it.remove();
                z2 = false;
                z = z2;
            }
            return z;
        }
    }

    public static boolean ai(au auVar) {
        if (auVar == null) {
            return false;
        }
        a ek = a.ek(auVar.field_content);
        if (ek == null) {
            return false;
        }
        if (ek.type == 6 || ek.type == 5 || ek.type == 19) {
            return true;
        }
        return false;
    }

    public static boolean aj(au auVar) {
        if (auVar == null || (!auVar.bLX() && !auVar.bLY())) {
            return false;
        }
        k rV = ((com.tencent.mm.plugin.biz.a.a) h.h(com.tencent.mm.plugin.biz.a.a.class)).rV(auVar.field_content);
        if (rV == null) {
            w.w("MicroMsg.ChattingEditModeLogic", "isBizMsgForbidForward reader is null");
            return false;
        } else if (rV.hkn == 1) {
            return true;
        } else {
            return false;
        }
    }

    static boolean ak(au auVar) {
        if (auVar != null) {
            a ek = a.ek(auVar.field_content);
            if (ek != null && ek.type == 16) {
                return true;
            }
            if (ek != null && ek.type == 34) {
                return true;
            }
        }
        return false;
    }

    static boolean al(au auVar) {
        if (!auVar.bMi()) {
            return false;
        }
        ap.yY();
        au.a Av = com.tencent.mm.u.c.wT().Av(auVar.field_content);
        if (Av == null || bg.mA(Av.rUK)) {
            return true;
        }
        if (o.eV(Av.rUK)) {
            return false;
        }
        return true;
    }

    private static boolean am(au auVar) {
        if (auVar != null && auVar.axO()) {
            a ek = a.ek(auVar.field_content);
            if (ek != null && ek.type == 6 && (ek.hhu != 0 || ek.hhq > 26214400)) {
                return true;
            }
        }
        return false;
    }

    public static boolean an(au auVar) {
        if (auVar != null && auVar.axO()) {
            a ek = a.ek(auVar.field_content);
            if (ek != null && ek.type == 6) {
                return true;
            }
        }
        return false;
    }

    public static int cv(List<au> list) {
        if (list == null) {
            w.w("MicroMsg.ChattingEditModeLogic", "get invalid send to friend msg num error, select item empty");
            return 0;
        }
        int i = 0;
        for (au auVar : list) {
            int i2;
            if (auVar.bLZ() || ac(auVar) || auVar.bMj() || ae(auVar) || af(auVar) || ag(auVar)) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        return i;
    }

    public static boolean cw(List<au> list) {
        if (list == null) {
            w.w("MicroMsg.ChattingEditModeLogic", "check contain undownload file, select item empty");
            return false;
        }
        for (au auVar : list) {
            if (auVar.bMh() || auVar.bMp()) {
                d ai;
                d dVar = null;
                if (auVar.field_msgId > 0) {
                    dVar = n.GS().aj(auVar.field_msgId);
                }
                if ((dVar == null || dVar.hEY <= 0) && auVar.field_msgSvrId > 0) {
                    ai = n.GS().ai(auVar.field_msgSvrId);
                } else {
                    ai = dVar;
                }
                if (ai != null && (ai.offset < ai.hrs || ai.hrs == 0)) {
                    return true;
                }
            } else if (auVar.bMl()) {
                r0 = com.tencent.mm.modelvideo.o.KV().ls(auVar.field_imgPath);
                if (!(r0 == null || r0.status == 199 || r0.status == 199)) {
                    return true;
                }
            } else if (auVar.bMo()) {
                if (!ad(auVar)) {
                    return true;
                }
            } else if (auVar.axO()) {
                a B = a.B(auVar.field_content, auVar.field_content);
                if (B != null) {
                    switch (B.type) {
                        case 6:
                            b LW = an.abL().LW(B.fCW);
                            if (LW != null) {
                                if (new File(LW.field_fileFullPath).exists()) {
                                    break;
                                }
                                return true;
                            }
                            return true;
                        default:
                            break;
                    }
                }
                return true;
            } else if (auVar.bMm()) {
                r0 = t.lH(auVar.field_imgPath);
                if (!(r0 == null || r0.status == 199 || r0.status == 199)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public static boolean cx(List<au> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (au auVar : list) {
            if (auVar.bMl() && j.LS(auVar.field_imgPath)) {
                return true;
            }
        }
        return false;
    }

    public static boolean cy(List<au> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (au bMm : list) {
            if (bMm.bMm()) {
                return true;
            }
        }
        return false;
    }

    public static String q(String str, int i, boolean z) {
        if (z && str != null && i == 0) {
            return ay.gj(str);
        }
        return str;
    }

    public static List<String> bTZ() {
        List<String> fw = com.tencent.mm.modelbiz.w.DH().fw(25);
        com.tencent.mm.modelbiz.d DH = com.tencent.mm.modelbiz.w.DH();
        List<String> arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.modelbiz.d.a(stringBuilder);
        com.tencent.mm.modelbiz.d.c(stringBuilder);
        com.tencent.mm.modelbiz.d.d(stringBuilder);
        com.tencent.mm.modelbiz.d.a(stringBuilder, true);
        stringBuilder.append(" order by ");
        stringBuilder.append(com.tencent.mm.modelbiz.d.Dk());
        w.i("MicroMsg.BizInfoStorage", "getEnterpriseBizChatLst sql %s", stringBuilder.toString());
        Cursor rawQuery = DH.rawQuery(r3, new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    arrayList.add(rawQuery.getString(0));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        HashMap hashMap = new HashMap();
        for (String str : arrayList) {
            String str2;
            String CO = e.hW(str2).CO();
            if (!bg.mA(CO)) {
                hashMap.put(CO, str2);
            }
        }
        List<String> linkedList = new LinkedList();
        Collection linkedList2 = new LinkedList();
        for (String str22 : fw) {
            if (!e.hZ(str22)) {
                linkedList.add(str22);
            } else if (e.ie(str22)) {
                str22 = e.hW(str22).field_enterpriseFather;
                if (!linkedList2.contains(str22) && e.ib(str22)) {
                    linkedList2.add(str22);
                    str22 = (String) hashMap.get(str22);
                    if (!bg.mA(str22)) {
                        linkedList2.add(str22);
                    }
                }
            }
        }
        for (String str222 : hashMap.values()) {
            if (!(bg.mA(str222) || linkedList2.contains(str222))) {
                linkedList2.add(str222);
            }
        }
        linkedList.addAll(linkedList2);
        w.d("MicroMsg.ChattingEditModeLogic", "get selected accept list, size %d", Integer.valueOf(linkedList.size()));
        return linkedList;
    }

    public static List<String> bUa() {
        List<String> fw = com.tencent.mm.modelbiz.w.DH().fw(25);
        List<String> linkedList = new LinkedList();
        for (String str : fw) {
            if (!e.hZ(str)) {
                linkedList.add(str);
            }
        }
        w.d("MicroMsg.ChattingEditModeLogic", "get selected accept list without enterprise, size %d", Integer.valueOf(linkedList.size()));
        return linkedList;
    }

    static boolean a(Context context, String str, au auVar, String str2) {
        if (context == null) {
            w.w("MicroMsg.ChattingEditModeLogic", "send %s fail, context is null", str2);
            return false;
        } else if (bg.mA(str)) {
            w.w("MicroMsg.ChattingEditModeLogic", "send %s fail, username is null", str2);
            return false;
        } else if (auVar != null) {
            return true;
        } else {
            w.w("MicroMsg.ChattingEditModeLogic", "send %s fail, msg is null", str2);
            return false;
        }
    }

    public static void a(Context context, String str, au auVar) {
        if (a(context, str, auVar, "emoji")) {
            String str2;
            String str3 = aj.RD(auVar.field_content).fFW;
            if (str3 == null || str3.endsWith("-1")) {
                str2 = auVar.field_imgPath;
            } else {
                str2 = str3;
            }
            if (str2 == null) {
                w.w("MicroMsg.ChattingEditModeLogic", "showAcceptEmojiConnector: filePath is null");
            } else {
                ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().l(context, str, str2);
            }
        }
    }

    public static void b(Context context, String str, au auVar) {
        if (a(context, str, auVar, SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
            d ai;
            d dVar = null;
            if (auVar.field_msgId > 0) {
                dVar = n.GS().aj(auVar.field_msgId);
            }
            if ((dVar == null || dVar.hEY <= 0) && auVar.field_msgSvrId > 0) {
                ai = n.GS().ai(auVar.field_msgSvrId);
            } else {
                ai = dVar;
            }
            if (ai != null) {
                int i = 0;
                if (ai.GB() && !com.tencent.mm.ah.e.a(ai).hEZ.startsWith("SERVERID://")) {
                    i = 1;
                }
                String m = n.GS().m(com.tencent.mm.ah.e.c(ai), "", "");
                String m2 = n.GS().m(ai.hFb, "th_", "");
                if (!bg.mA(m)) {
                    com.tencent.mm.plugin.messenger.a.d.aJW().b(context, str, m, i, ai.hFj, m2);
                }
            }
        }
    }

    public static void c(Context context, String str, au auVar) {
        if (a(context, str, auVar, SlookAirButtonRecentMediaAdapter.VIDEO_TYPE) && auVar != null) {
            if (auVar == null || !auVar.bMm() || !t.lJ(auVar.field_imgPath)) {
                r lH = t.lH(auVar.field_imgPath);
                String str2 = auVar.field_imgPath;
                int i = lH.iat;
                int i2 = lH.iap;
                String Lh = lH.Lh();
                int i3 = auVar.field_type;
                w.d("MicroMsg.ChattingEditModeLogic", "copy video fileName %s userName %s export %d videoLength %d", str2, str, Integer.valueOf(i), Integer.valueOf(i2));
                String lu = s.lu(m.xL());
                com.tencent.mm.modelvideo.o.KV();
                w.d("MicroMsg.ChattingEditModeLogic", "copy video: srcFullPath[%s] destFullPath[%s] srcThumbPath[%s] destThumbPath[%s]", s.lv(str2), s.lv(lu), s.lw(str2), s.lw(lu));
                com.tencent.mm.sdk.platformtools.j.p(r3, r7, false);
                com.tencent.mm.sdk.platformtools.j.p(str2, r8, false);
                t.a(lu, i2, str, null, i, Lh, i3);
                t.lC(lu);
            }
        }
    }

    public static void a(Context context, String str, au auVar, boolean z) {
        if (a(context, str, auVar, "text")) {
            String q = q(auVar.field_content, auVar.field_isSend, z);
            if (auVar.bMw()) {
                q = q + "\n\n" + q(auVar.field_transContent, auVar.field_isSend, z);
            }
            if (q == null || q.equals("")) {
                w.e("MicroMsg.ChattingEditModeLogic", "Transfer text erro: content null");
            } else {
                com.tencent.mm.plugin.messenger.a.d.aJW().A(str, q, o.fG(str));
            }
        }
    }

    public static void b(Context context, String str, au auVar, boolean z) {
        if (!a(context, str, auVar, "appmsg")) {
            return;
        }
        if (context == null) {
            w.w("MicroMsg.ChattingEditModeLogic", "getReaderAppMsgContent: context is null");
        } else if (auVar == null) {
            w.w("MicroMsg.ChattingEditModeLogic", "getReaderAppMsgContent: msg is null");
        } else {
            ap.yY();
            if (com.tencent.mm.u.c.isSDCardAvailable()) {
                String str2;
                String b = n.GS().b(auVar.field_imgPath, false, false);
                if (u.mA(b) || b.endsWith("hd") || !FileOp.aO(b + "hd")) {
                    str2 = b;
                } else {
                    str2 = b + "hd";
                }
                try {
                    k rV = ((com.tencent.mm.plugin.biz.a.a) h.h(com.tencent.mm.plugin.biz.a.a.class)).rV(auVar.field_content);
                    List<l> list = rV.hkm;
                    if (list == null || list.size() <= 0) {
                        if (auVar == null || !(auVar.axO() || auVar.bLX() || auVar.bLY())) {
                            b = null;
                        } else {
                            String fQ = q.fQ(auVar.field_msgSvrId);
                            q.b n = q.yC().n(fQ, true);
                            n.l("prePublishId", "msg_" + auVar.field_msgSvrId);
                            n.l("preUsername", ah.a(auVar, z, false));
                            n.l("preChatName", auVar.field_talker);
                            n.l("preMsgIndex", Integer.valueOf(0));
                            n.l("sendAppMsgScene", Integer.valueOf(1));
                            ((com.tencent.mm.plugin.sns.b.h) h.h(com.tencent.mm.plugin.sns.b.h.class)).a("adExtStr", n, auVar);
                            b = fQ;
                        }
                        com.tencent.mm.plugin.messenger.a.d.aJW().a(str, bg.readFromFile(str2), bg.PX(auVar.field_content), b);
                        return;
                    }
                    for (l lVar : list) {
                        a aVar = new a();
                        if (com.tencent.mm.t.h.em(lVar.hkx)) {
                            ac.b(str, ac.a(str, lVar), lVar.hkC);
                        } else {
                            aVar.title = lVar.title;
                            aVar.description = lVar.hku;
                            aVar.action = "view";
                            aVar.type = 5;
                            aVar.url = lVar.url;
                            aVar.fUR = rV.fUR;
                            aVar.fUS = rV.fUS;
                            aVar.gxD = rV.gxD;
                            aVar.thumburl = lVar.hks;
                            if (bg.mA(aVar.thumburl) && !bg.mA(aVar.fUR)) {
                                com.tencent.mm.x.h hs = com.tencent.mm.x.n.Bm().hs(aVar.fUR);
                                if (hs != null) {
                                    aVar.thumburl = hs.Bs();
                                }
                            }
                            com.tencent.mm.plugin.messenger.a.d.aJW().a(str, bg.readFromFile(str2), bg.PX(a.a(aVar, null, null)), null);
                        }
                    }
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.ChattingEditModeLogic", e, "", new Object[0]);
                    w.e("MicroMsg.ChattingEditModeLogic", "send app msg error : %s", e.getLocalizedMessage());
                }
            }
        }
    }

    public static void c(Context context, String str, au auVar, boolean z) {
        if (a(context, str, auVar, "location")) {
            com.tencent.mm.plugin.messenger.a.d.aJW().A(str, q(auVar.field_content, auVar.field_isSend, z), 48);
        }
    }

    public static void a(Context context, String str, String str2, int i, boolean z) {
        try {
            au auVar = new au();
            auVar.setContent(str2);
            auVar.dw(i);
            int indexOf = str2.indexOf("<msg>");
            if (indexOf > 0 && indexOf < str2.length()) {
                str2 = str2.substring(indexOf).trim();
            }
            Map q = bh.q(str2, "msg");
            if (q != null && q.size() > 0) {
                auVar.cJ(aw.ae(q));
            }
            b(context, str, auVar, z);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.ChattingEditModeLogic", e, "", new Object[0]);
            w.e("MicroMsg.ChattingEditModeLogic", "retransmit sigle app msg error : %s", e.getLocalizedMessage());
        }
    }

    public static void b(c cVar, String str) {
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        String stringBuilder2 = stringBuilder.append(com.tencent.mm.u.c.xi()).append(cVar.EP()).toString();
        if (com.tencent.mm.a.e.aN(stringBuilder2 + "_thumb") > 0) {
            wXMediaMessage.thumbData = com.tencent.mm.a.e.c(stringBuilder2 + "_thumb", 0, com.tencent.mm.a.e.aN(stringBuilder2 + "_thumb"));
        } else {
            try {
                InputStream fileInputStream = new FileInputStream(stringBuilder2);
                wXMediaMessage.setThumbImage(BackwardSupportUtil.b.a(fileInputStream, 1.0f));
                fileInputStream.close();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.ChattingEditModeLogic", e, "", new Object[0]);
                w.e("MicroMsg.ChattingEditModeLogic", "sendAppMsgEmoji Fail cause there is no thumb");
            }
        }
        wXMediaMessage.mediaObject = new WXEmojiObject(stringBuilder2);
        com.tencent.mm.pluginsdk.model.app.l.a(wXMediaMessage, cVar.field_app_id, null, str, 1, cVar.EP());
    }
}
