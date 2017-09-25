package com.tencent.mm.plugin.record.a;

import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.util.SparseIntArray;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.qy;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.g;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rn;
import com.tencent.mm.protocal.c.ro;
import com.tencent.mm.protocal.c.rs;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.protocal.c.rz;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.j;
import com.tencent.mm.u.o;
import com.tencent.mm.x.b;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class m {
    private static final f<Integer, c> hkd = new f(32);

    public static String b(String str, String str2, List<rm> list, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<recordinfo>");
        stringBuilder.append("<title>").append(bg.PW(str)).append("</title>");
        stringBuilder.append("<desc>").append(bg.PW(str2)).append("</desc>");
        stringBuilder.append(n.ar(list));
        stringBuilder.append("<favusername>").append(bg.PW(str3)).append("</favusername>");
        stringBuilder.append("</recordinfo>");
        a aVar = new a();
        aVar.title = str;
        aVar.description = str2;
        if (bg.mA(((rm) list.get(0)).txx) || !((rm) list.get(0)).txx.equals(".htm")) {
            aVar.type = 19;
            aVar.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0";
        } else {
            aVar.type = 24;
            aVar.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";
        }
        aVar.action = "view";
        aVar.hhQ = stringBuilder.toString();
        return a.a(aVar, null, null);
    }

    public static a a(String str, String str2, List<rm> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<recordinfo>");
        stringBuilder.append("<title>").append(bg.PW(str)).append("</title>");
        stringBuilder.append("<desc>").append(bg.PW(str2)).append("</desc>");
        stringBuilder.append(n.ar(list));
        stringBuilder.append("<favusername>").append(bg.PW(com.tencent.mm.u.m.xL())).append("</favusername>");
        stringBuilder.append("</recordinfo>");
        a aVar = new a();
        aVar.title = str;
        if (str2 != null && str2.length() > com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX) {
            str2 = str2.substring(0, com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX);
        }
        aVar.description = str2;
        if (bg.bV(list) || bg.mA(((rm) list.get(0)).txx) || !((rm) list.get(0)).txx.equals(".htm")) {
            aVar.type = 19;
            aVar.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/favorite_record__w_unsupport&from=singlemessage&isappinstalled=0";
        } else {
            aVar.type = 24;
            aVar.url = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/common_page__upgrade&btn_text=btn_text_0&text=text008";
        }
        aVar.action = "view";
        aVar.hhQ = stringBuilder.toString();
        return aVar;
    }

    public static int a(Context context, String str, String str2, List<au> list, cb cbVar, d dVar) {
        if (bg.mA(str)) {
            w.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
            return -1;
        } else if (list == null || list.isEmpty()) {
            w.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
            return -1;
        } else {
            if (cbVar == null || dVar == null) {
                cbVar = new cb();
                if (!g.a(context, cbVar, str2, list, true)) {
                    return -1;
                }
                dVar = a(context, cbVar, str2);
            }
            a a = a(dVar.title, dVar.desc, cbVar.fFA.fFC.tzn);
            ce auVar = new au();
            byte[] bArr = null;
            if (!bg.mA(dVar.fKz)) {
                bArr = bg.readFromFile(dVar.fKz);
            } else if (dVar.fTj == 0 && !bg.mA(dVar.lEv)) {
                bArr = com.tencent.mm.sdk.platformtools.d.K(b.a(dVar.lEv, false, -1));
            }
            if (bArr != null) {
                String a2;
                if (bArr.length > WXMediaMessage.THUMB_LENGTH_LIMIT) {
                    a2 = n.GS().a(bArr, false, CompressFormat.JPEG);
                } else {
                    a2 = n.GS().f(8, bArr);
                }
                w.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.sd() + " thumbData MsgInfo path:" + a2);
                if (!bg.mA(a2)) {
                    auVar.cI(a2);
                }
            }
            auVar.setContent(a.a(a, null, null));
            auVar.dv(1);
            auVar.cH(str);
            auVar.z(ay.gk(str));
            auVar.dw(1);
            auVar.setType(49);
            if (e.dr(str)) {
                auVar.cN(com.tencent.mm.modelbiz.a.e.zz());
            }
            ap.yY();
            long L = com.tencent.mm.u.c.wT().L(auVar);
            w.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.sd() + " msginfo insert id: " + L);
            if (L < 0) {
                w.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.sd() + "insert msg failed :" + L);
                return 0 - com.tencent.mm.compatible.util.g.sb();
            }
            w.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.sb() + " new msg inserted to db , local id = " + L);
            auVar.x(L);
            com.tencent.mm.sdk.e.c fVar = new com.tencent.mm.t.f();
            fVar.field_xml = auVar.field_content;
            fVar.field_title = a.title;
            fVar.field_type = a.type;
            fVar.field_description = a.description;
            fVar.field_msgId = L;
            an.bDk().b(fVar);
            Iterator it = cbVar.fFA.fFC.tzn.iterator();
            boolean z = false;
            while (it.hasNext()) {
                rm rmVar = (rm) it.next();
                String obj = rmVar.toString();
                rmVar.NY(com.tencent.mm.a.g.n((obj + rmVar.aMw + System.currentTimeMillis()).getBytes()));
                if (z || com.tencent.mm.a.e.aO(rmVar.txG) || com.tencent.mm.a.e.aO(rmVar.txI) || !bg.mA(rmVar.txi) || !bg.mA(rmVar.hhy)) {
                    z = true;
                }
            }
            w.d("MicroMsg.RecordMsgLogic", "summerrecord needNetScene:%b", Boolean.valueOf(z));
            if (z) {
                fVar = new k();
                fVar.field_msgId = L;
                fVar.field_title = a.title;
                fVar.field_desc = a.description;
                fVar.field_toUser = str;
                fVar.field_dataProto = cbVar.fFA.fFC;
                fVar.field_type = 3;
                fVar.field_localId = new Random().nextInt(2147483645) + 1;
                w.i("MicroMsg.RecordMsgLogic", "summerrecord needNetScene insert ret:%b, id:%d, localid:%d", Boolean.valueOf(s.aWE().b(fVar)), Long.valueOf(L), Integer.valueOf(fVar.field_localId));
                s.aWG().a(fVar);
            } else {
                w.d("MicroMsg.RecordMsgLogic", "summerrecord do not trans cdn, directly send msg id:%d", Long.valueOf(L));
                an.bDm();
                am.a.eg(L);
            }
            return 0;
        }
    }

    public static d a(Context context, cb cbVar, String str) {
        String str2;
        int i = 0;
        d dVar = new d();
        SparseIntArray sparseIntArray = new SparseIntArray();
        if (e.dr(str)) {
            dVar.title = cbVar.fFA.fFC.title;
        } else if (o.dH(str)) {
            dVar.title = context.getString(R.l.eIF);
        } else {
            if (com.tencent.mm.u.m.xN().equals(com.tencent.mm.u.n.eJ(str))) {
                dVar.title = context.getString(R.l.ejc, new Object[]{com.tencent.mm.u.m.xN()});
            } else {
                dVar.title = context.getString(R.l.ejb, new Object[]{com.tencent.mm.u.m.xN(), com.tencent.mm.u.n.eJ(str)});
            }
        }
        w.d("MicroMsg.RecordMsgLogic", "msgInfo title %s", dVar.title);
        List<String> linkedList = new LinkedList();
        List list;
        if (cbVar.fFA.fFC != null) {
            list = cbVar.fFA.fFC.tzn;
        } else {
            list = new LinkedList();
        }
        for (rm rmVar : r0) {
            sparseIntArray.put(rmVar.aMw, sparseIntArray.get(rmVar.aMw) + 1);
            switch (rmVar.aMw) {
                case 1:
                    if (linkedList.size() >= 5) {
                        break;
                    }
                    linkedList.add(rmVar.tye + ":" + rmVar.desc + "\n");
                    break;
                case 2:
                    if (linkedList.size() < 5) {
                        linkedList.add(rmVar.tye + ":" + context.getString(R.l.dIi) + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, rmVar, R.g.bbY);
                    i = 1;
                    break;
                case 3:
                    if (linkedList.size() >= 5) {
                        break;
                    }
                    linkedList.add(rmVar.tye + ":" + context.getString(R.l.dIY) + "\n");
                    break;
                case 4:
                    if (linkedList.size() < 5) {
                        linkedList.add(rmVar.tye + ":" + context.getString(R.l.dIX) + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, rmVar, R.k.dtr);
                    i = 1;
                    break;
                case 5:
                    if (linkedList.size() < 5) {
                        linkedList.add(rmVar.tye + ":" + context.getString(R.l.dIU) + rmVar.title + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, rmVar, R.k.dtu);
                    i = 1;
                    break;
                case 6:
                    if (linkedList.size() < 5) {
                        rs rsVar = rmVar.tyc.tyw;
                        StringBuilder append = new StringBuilder().append(rmVar.tye).append(":").append(context.getString(R.l.dHB));
                        str2 = (bg.mA(rsVar.fRX) || rsVar.fRX.equals(context.getString(R.l.ewy))) ? rsVar.label : rsVar.fRX;
                        linkedList.add(append.append(str2).append("\n").toString());
                    }
                    if (i != 0) {
                        break;
                    }
                    dVar.fTj = R.k.dtf;
                    i = 1;
                    break;
                    break;
                case 7:
                    if (linkedList.size() < 5) {
                        linkedList.add(rmVar.tye + ":" + context.getString(R.l.dHI) + rmVar.title + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, rmVar, R.k.dtg);
                    i = 1;
                    break;
                case 8:
                    if (linkedList.size() < 5) {
                        linkedList.add(rmVar.tye + ":" + context.getString(R.l.dHn) + rmVar.title + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, rmVar, R.k.dto);
                    i = 1;
                    break;
                case 10:
                case 11:
                    if (linkedList.size() < 5) {
                        linkedList.add(rmVar.tye + ":" + context.getString(R.l.dIk) + rmVar.tyc.tyA.title + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, rmVar, R.k.dto);
                    i = 1;
                    break;
                case 14:
                    if (linkedList.size() < 5) {
                        linkedList.add(rmVar.tye + ":" + context.getString(R.l.dDm) + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, rmVar, R.k.dto);
                    i = 1;
                    break;
                case 15:
                    if (linkedList.size() < 5) {
                        linkedList.add(rmVar.tye + ":" + context.getString(R.l.dIX) + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    a(dVar, rmVar, R.k.dtr);
                    i = 1;
                    break;
                case 16:
                    if (linkedList.size() < 5) {
                        linkedList.add(rmVar.tye + ":" + context.getString(R.l.dHr) + "\n");
                    }
                    if (i != 0) {
                        break;
                    }
                    ap.yY();
                    dVar.lEv = com.tencent.mm.u.c.wT().Av(rmVar.desc).rUK;
                    i = 1;
                    break;
                case 17:
                    if (linkedList.size() >= 5) {
                        break;
                    }
                    linkedList.add(rmVar.tye + ":" + context.getString(R.l.dIr) + "\n");
                    break;
                default:
                    break;
            }
        }
        dVar.desc = "";
        String str3 = "";
        for (String str22 : linkedList) {
            str3 = str3 + str22;
        }
        str22 = str3.trim();
        if (linkedList.size() >= 5) {
            str22 = str22 + "...";
        }
        dVar.desc = str22;
        return dVar;
    }

    private static void a(d dVar, rm rmVar, int i) {
        String str = rmVar.txI;
        if (com.tencent.mm.a.e.aO(str)) {
            dVar.fKz = str;
        } else {
            dVar.fTj = i;
        }
    }

    public static int a(String str, String str2, au auVar) {
        if (bg.mA(str)) {
            w.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
            return -1;
        } else if (auVar == null || bg.mA(auVar.field_content)) {
            w.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo error");
            return -1;
        } else if (1 == auVar.field_status) {
            w.w("MicroMsg.RecordMsgLogic", "send record msg error, msginfo is sending");
            return -1;
        } else {
            for (String str3 : bg.f(str.split(","))) {
                w.i("MicroMsg.RecordMsgLogic", "send recordMsg, toUser[%s] msgId[%d], msgType[%d]", str3, Long.valueOf(auVar.field_msgId), Integer.valueOf(auVar.field_status));
                String gj = ay.gj(auVar.field_content);
                a ek = a.ek(gj);
                if (ek == null) {
                    w.w("MicroMsg.RecordMsgLogic", "send record msg error, parse appmsg error");
                    return -1;
                }
                c Dp = Dp(ek.hhQ);
                if (Dp == null) {
                    w.w("MicroMsg.RecordMsgLogic", "send record msg error, parse record data error");
                    return -1;
                }
                ce auVar2 = new au();
                if (!bg.mA(auVar.field_imgPath)) {
                    String f = n.GS().f(8, bg.readFromFile(n.GS().v(auVar.field_imgPath, true)));
                    w.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.sd() + " thumbData from msg MsgInfo path:" + f);
                    if (!bg.mA(f)) {
                        auVar2.cI(f);
                    }
                }
                auVar2.setContent(gj);
                auVar2.dv(1);
                auVar2.cH(str3);
                auVar2.z(ay.gk(str3));
                auVar2.dw(1);
                auVar2.setType(49);
                ap.yY();
                long L = com.tencent.mm.u.c.wT().L(auVar2);
                w.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.sd() + " msginfo insert id: " + L);
                if (L < 0) {
                    w.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.sd() + "insert msg failed :" + L);
                    return 0 - com.tencent.mm.compatible.util.g.sb();
                }
                Object obj;
                w.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.sb() + " new msg inserted to db , local id = " + L);
                auVar2.x(L);
                com.tencent.mm.sdk.b.b qyVar = new qy();
                qyVar.fXV.fXW = auVar.field_msgId;
                qyVar.fXV.fXX = L;
                com.tencent.mm.sdk.b.a.urY.m(qyVar);
                com.tencent.mm.sdk.e.c fVar = new com.tencent.mm.t.f();
                fVar.field_xml = auVar2.field_content;
                fVar.field_title = ek.title;
                fVar.field_type = ek.type;
                fVar.field_description = ek.description;
                fVar.field_msgId = L;
                an.bDk().b(fVar);
                Iterator it = Dp.hkm.iterator();
                while (it.hasNext()) {
                    rm rmVar = (rm) it.next();
                    if (bg.mA(rmVar.txi)) {
                        if (!bg.mA(rmVar.hhy)) {
                        }
                    }
                    obj = 1;
                }
                obj = null;
                if (obj != null) {
                    fVar = new k();
                    rv rvVar = new rv();
                    rvVar.tzn.addAll(Dp.hkm);
                    fVar.field_msgId = L;
                    fVar.field_oriMsgId = auVar.field_msgId;
                    fVar.field_toUser = str3;
                    fVar.field_title = ek.title;
                    fVar.field_desc = ek.description;
                    fVar.field_dataProto = rvVar;
                    fVar.field_type = 0;
                    fVar.field_favFrom = Dp.tbg;
                    fVar.field_localId = new Random().nextInt(2147483645) + 1;
                    s.aWE().b(fVar);
                    s.aWG().a(fVar);
                } else {
                    w.d("MicroMsg.RecordMsgLogic", "do not check upload, directly send msg");
                    an.bDm();
                    am.a.eg(L);
                }
                if (!bg.mA(str2)) {
                    com.tencent.mm.plugin.messenger.a.d.aJW().A(str3, str2, o.fG(str3));
                }
            }
            return 0;
        }
    }

    public static int a(String str, rv rvVar, String str2, String str3, String str4, int i, String str5) {
        if (bg.mA(str)) {
            w.w("MicroMsg.RecordMsgLogic", "send record msg error, touser is null");
            return -1;
        } else if (rvVar == null || rvVar.tzn.isEmpty()) {
            w.w("MicroMsg.RecordMsgLogic", "send record msg error, favprotoitem error");
            return -1;
        } else {
            a a = a(str2, str3, rvVar.tzn);
            ce auVar = new au();
            byte[] bArr = null;
            if (!bg.mA(str4)) {
                bArr = bg.readFromFile(str4);
            } else if (i != 0) {
                bArr = com.tencent.mm.sdk.platformtools.d.K(com.tencent.mm.sdk.platformtools.d.yp(i));
            } else if (!bg.mA(str5)) {
                bArr = com.tencent.mm.sdk.platformtools.d.K(b.a(str5, false, -1));
            }
            if (bArr != null) {
                String a2;
                if (bArr.length > WXMediaMessage.THUMB_LENGTH_LIMIT) {
                    a2 = n.GS().a(bArr, false, CompressFormat.JPEG);
                } else {
                    a2 = n.GS().f(8, bArr);
                }
                w.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.sd() + " thumbData MsgInfo path:" + a2);
                if (!bg.mA(a2)) {
                    auVar.cI(a2);
                }
            }
            auVar.setContent(a.a(a, null, null));
            auVar.dv(1);
            auVar.cH(str);
            auVar.z(ay.gk(str));
            auVar.dw(1);
            auVar.setType(49);
            if (e.dr(str)) {
                auVar.cN(com.tencent.mm.modelbiz.a.e.zz());
            }
            ap.yY();
            long L = com.tencent.mm.u.c.wT().L(auVar);
            w.d("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.sd() + " msginfo insert id: " + L);
            if (L < 0) {
                w.e("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.sd() + "insert msg failed :" + L);
                return 0 - com.tencent.mm.compatible.util.g.sb();
            }
            Object obj;
            w.i("MicroMsg.RecordMsgLogic", com.tencent.mm.compatible.util.g.sb() + " new msg inserted to db , local id = " + L);
            auVar.x(L);
            com.tencent.mm.sdk.e.c fVar = new com.tencent.mm.t.f();
            fVar.field_xml = auVar.field_content;
            fVar.field_title = a.title;
            fVar.field_type = a.type;
            fVar.field_description = a.description;
            fVar.field_msgId = L;
            an.bDk().b(fVar);
            Iterator it = rvVar.tzn.iterator();
            while (it.hasNext()) {
                rm rmVar = (rm) it.next();
                if (bg.mA(rmVar.txi)) {
                    if (!bg.mA(rmVar.hhy)) {
                    }
                }
                obj = 1;
            }
            obj = null;
            if (obj != null || com.tencent.mm.pluginsdk.model.c.sCd) {
                fVar = new k();
                fVar.field_msgId = L;
                fVar.field_title = a.title;
                fVar.field_desc = a.description;
                fVar.field_toUser = str;
                fVar.field_dataProto = rvVar;
                fVar.field_type = 1;
                fVar.field_localId = new Random().nextInt(2147483645) + 1;
                s.aWE().b(fVar);
                s.aWG().a(fVar);
            } else {
                w.d("MicroMsg.RecordMsgLogic", "do not trans cdn, directly send msg");
                an.bDm();
                am.a.eg(L);
            }
            return 0;
        }
    }

    private static File cS(long j) {
        r2 = new Object[2];
        ap.yY();
        r2[0] = com.tencent.mm.u.c.xp();
        r2[1] = Long.valueOf(j);
        File file = new File(String.format("%s/%d/", r2));
        if (!(file.exists() && file.isDirectory())) {
            file.mkdirs();
        }
        return file;
    }

    public static void cT(long j) {
        boolean d = com.tencent.mm.a.e.d(cS(j));
        w.i("MicroMsg.RecordMsgLogic", "do clear resource, path %s, result %B", r0.getAbsolutePath(), Boolean.valueOf(d));
    }

    public static String c(rm rmVar, long j) {
        int i = 1;
        if (rmVar == null) {
            return "";
        }
        String str = rmVar.lKv;
        if (bg.mA(str) || !ap.zb()) {
            return "";
        }
        File file;
        String str2;
        File cS = cS(j);
        if (rmVar.aMw != 8 || bg.mA(rmVar.title)) {
            i = 0;
            file = cS;
            str2 = str;
        } else {
            str = rmVar.title;
            int hashCode = rmVar.lKv.hashCode() & 255;
            r6 = new Object[3];
            ap.yY();
            r6[0] = com.tencent.mm.u.c.xp();
            r6[1] = Long.valueOf(j);
            r6[2] = Integer.valueOf(hashCode);
            cS = new File(String.format("%s/%d/%d/", r6));
            if (!(cS.exists() && cS.isDirectory())) {
                cS.mkdirs();
            }
            file = cS;
            str2 = str;
        }
        if (rmVar.txx != null && rmVar.txx.trim().length() > 0 && r0 == 0) {
            str2 = str2 + "." + rmVar.txx;
        }
        return new File(file, str2).getAbsolutePath();
    }

    public static boolean d(rm rmVar, long j) {
        return new File(c(rmVar, j)).exists();
    }

    public static boolean e(rm rmVar, long j) {
        return new File(f(rmVar, j)).exists();
    }

    public static String f(rm rmVar, long j) {
        if (rmVar == null || bg.mA(rmVar.lKv)) {
            return "";
        }
        return new File(cS(j), vZ(rmVar.lKv)).getAbsolutePath();
    }

    public static String vZ(String str) {
        return str + "_t";
    }

    public static String d(String str, long j, boolean z) {
        if (z) {
            return str + "@record_download@" + j;
        }
        return str + "@record_upload@" + j;
    }

    public static c Dp(String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.RecordMsgLogic", "xml is null");
            return null;
        }
        int hashCode = str.hashCode();
        c cVar = (c) hkd.get(Integer.valueOf(hashCode));
        if (cVar != null) {
            w.d("MicroMsg.RecordMsgLogic", "get record msg data from cache");
            return cVar;
        }
        Map q;
        if (str.trim().startsWith("<recordinfo>")) {
            q = bh.q(str, "recordinfo");
        } else {
            q = bh.q("<recordinfo>" + str + "</recordinfo>", "recordinfo");
        }
        if (q == null) {
            w.e("MicroMsg.RecordMsgLogic", "values is null: %s", str);
            return null;
        }
        c cVar2 = new c();
        cVar2.title = (String) q.get(".recordinfo.title");
        cVar2.desc = (String) q.get(".recordinfo.desc");
        cVar2.tbg = (String) q.get(".recordinfo.favusername");
        a(str, cVar2);
        hkd.put(Integer.valueOf(hashCode), cVar2);
        return cVar2;
    }

    private static void a(String str, c cVar) {
        cVar.hkm.clear();
        try {
            Document parse = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(str.getBytes())));
            parse.normalize();
            NodeList elementsByTagName = parse.getDocumentElement().getElementsByTagName("datalist");
            if (elementsByTagName != null) {
                NodeList childNodes = elementsByTagName.item(0).getChildNodes();
                if (childNodes != null && childNodes.getLength() > 0) {
                    int length = childNodes.getLength();
                    for (int i = 0; i < length; i++) {
                        String str2;
                        Map q;
                        Node item = childNodes.item(i);
                        String b = bh.b(item);
                        NodeList elementsByTagName2 = ((Element) item).getElementsByTagName("recordxml");
                        if (elementsByTagName2 == null || elementsByTagName2.getLength() <= 0) {
                            str2 = null;
                        } else {
                            str2 = bh.b(elementsByTagName2.item(0).getFirstChild());
                        }
                        if (b.trim().startsWith("<dataitem")) {
                            q = bh.q(b, "dataitem");
                        } else {
                            q = null;
                        }
                        try {
                            rm rmVar = new rm();
                            String str3 = ".dataitem";
                            rmVar.yb(bg.getInt((String) q.get(str3 + ".$datatype"), 0));
                            rmVar.Od((String) q.get(str3 + ".$datasourceid"));
                            rmVar.yc(bg.getInt((String) q.get(str3 + ".$datastatus"), 0));
                            rmVar.NV((String) q.get(str3 + ".datafmt"));
                            rmVar.NL((String) q.get(str3 + ".datatitle"));
                            rmVar.NM((String) q.get(str3 + ".datadesc"));
                            rmVar.NN((String) q.get(str3 + ".cdnthumburl"));
                            rmVar.NO((String) q.get(str3 + ".cdnthumbkey"));
                            rmVar.xY(bg.getInt((String) q.get(str3 + ".thumbwidth"), 0));
                            rmVar.xZ(bg.getInt((String) q.get(str3 + ".thumbheight"), 0));
                            rmVar.NP((String) q.get(str3 + ".cdndataurl"));
                            rmVar.NQ((String) q.get(str3 + ".cdndatakey"));
                            String str4 = (String) q.get(str3 + ".duration");
                            if (str4 != null && str4.length() > 0) {
                                rmVar.ya(bg.getInt(str4, 0));
                            }
                            rmVar.NS((String) q.get(str3 + ".streamdataurl"));
                            rmVar.NT((String) q.get(str3 + ".streamlowbandurl"));
                            rmVar.NR((String) q.get(str3 + ".streamweburl"));
                            rmVar.NW((String) q.get(str3 + ".fullmd5"));
                            rmVar.NX((String) q.get(str3 + ".head256md5"));
                            str4 = (String) q.get(str3 + ".datasize");
                            if (!bg.mA(str4)) {
                                rmVar.ej((long) bg.getInt(str4, 0));
                            }
                            rmVar.NU((String) q.get(str3 + ".dataext"));
                            rmVar.Ob((String) q.get(str3 + ".thumbfullmd5"));
                            rmVar.Oc((String) q.get(str3 + ".thumbhead256md5"));
                            str4 = (String) q.get(str3 + ".thumbsize");
                            if (!bg.mA(str4)) {
                                rmVar.ek((long) bg.getInt(str4, 0));
                            }
                            rmVar.Oe((String) q.get(str3 + ".streamvideoid"));
                            str4 = (String) q.get(str3 + ".$dataid");
                            if (bg.mA(str4)) {
                                str4 = String.valueOf(i);
                            }
                            rmVar.NY(str4);
                            str4 = (String) q.get(str3 + ".$htmlid");
                            if (!bg.mA(str4)) {
                                rmVar.Oi(str4);
                            }
                            rmVar.yd(bg.getInt((String) q.get(str3 + ".$dataillegaltype"), 0));
                            rmVar.Of((String) q.get(str3 + ".sourcetitle"));
                            rmVar.Og((String) q.get(str3 + ".sourcename"));
                            rmVar.Oh((String) q.get(str3 + ".sourcetime"));
                            rmVar.Oj((String) q.get(str3 + ".statextstr"));
                            if (str2 != null) {
                                rmVar.Ol(str2);
                            }
                            rn rnVar = new rn();
                            ro roVar = new ro();
                            roVar.ye(bg.getInt((String) q.get(str3 + ".$sourcetype"), 0));
                            str4 = (String) q.get(str3 + ".dataitemsource.fromusr");
                            if (!bg.mA(str4)) {
                                roVar.Om(str4);
                                w.d("MicroMsg.RecordMsgParser", "fromusr %s", roVar.fOu);
                            }
                            str4 = (String) q.get(str3 + ".dataitemsource.realchatname");
                            if (!bg.mA(str4)) {
                                roVar.Op(str4);
                                w.d("MicroMsg.RecordMsgParser", "realChatname %s", roVar.tyQ);
                            }
                            roVar.Or((String) q.get(str3 + ".appid"));
                            roVar.Os((String) q.get(str3 + ".link"));
                            roVar.Ot((String) q.get(str3 + ".brandid"));
                            rnVar.c(roVar);
                            String str5 = str3 + ".locitem";
                            if (q.containsKey(str5)) {
                                rs rsVar = new rs();
                                if (!bg.mA((String) q.get(str5 + ".label"))) {
                                    rsVar.Ou((String) q.get(str5 + ".label"));
                                }
                                if (!bg.mA((String) q.get(str5 + ".poiname"))) {
                                    rsVar.Ov((String) q.get(str5 + ".poiname"));
                                }
                                str4 = (String) q.get(str5 + ".lng");
                                if (!bg.mA(str4)) {
                                    rsVar.l(bg.getDouble(str4, 0.0d));
                                }
                                str4 = (String) q.get(str5 + ".lat");
                                if (!bg.mA(str4)) {
                                    rsVar.m(bg.getDouble(str4, 0.0d));
                                }
                                str4 = (String) q.get(str5 + ".scale");
                                if (!bg.mA(str4)) {
                                    if (str4.indexOf(46) != -1) {
                                        rsVar.yf(bg.getInt(str4.substring(0, str4.indexOf(46)), -1));
                                    } else {
                                        rsVar.yf(bg.getInt(str4, -1));
                                    }
                                }
                                rnVar.a(rsVar);
                            } else {
                                w.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", str5);
                            }
                            str5 = str3 + ".weburlitem";
                            if (q.containsKey(str5)) {
                                sf sfVar = new sf();
                                sfVar.OQ((String) q.get(str5 + ".title"));
                                sfVar.OR((String) q.get(str5 + ".desc"));
                                sfVar.OT((String) q.get(str5 + ".thumburl"));
                                sfVar.OS((String) q.get(str5 + ".link"));
                                sfVar.yk(bg.getInt((String) q.get(str5 + ".opencache"), 0));
                                rnVar.a(sfVar);
                            } else {
                                w.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", str5);
                            }
                            str5 = str3 + ".productitem";
                            if (q.containsKey(str5)) {
                                ru ruVar = new ru();
                                ruVar.Ow((String) q.get(str5 + ".title"));
                                ruVar.Ox((String) q.get(str5 + ".desc"));
                                ruVar.Oy((String) q.get(str5 + ".thumburl"));
                                ruVar.Oz((String) q.get(str5 + ".productinfo"));
                                ruVar.yg(bg.getInt((String) q.get(str5 + ".$type"), 0));
                                rnVar.a(ruVar);
                            } else {
                                w.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", str5);
                            }
                            str3 = str3 + ".tvitem";
                            if (q.containsKey(str3)) {
                                rz rzVar = new rz();
                                rzVar.OM((String) q.get(str3 + ".title"));
                                rzVar.ON((String) q.get(str3 + ".desc"));
                                rzVar.OO((String) q.get(str3 + ".thumburl"));
                                rzVar.OP((String) q.get(str3 + ".tvinfo"));
                                rnVar.a(rzVar);
                            } else {
                                w.w("MicroMsg.RecordMsgParser", "cur fav not contains %s", str3);
                            }
                            rmVar.a(rnVar);
                            cVar.hkm.add(rmVar);
                        } catch (Throwable e) {
                            w.e("MicroMsg.RecordMsgLogic", "get record msg data from xml error: %s", e.getMessage());
                            w.printErrStackTrace("MicroMsg.RecordMsgLogic", e, "", new Object[0]);
                            cVar.hkm.clear();
                        }
                    }
                }
            }
        } catch (Exception e2) {
            w.e("MicroMsg.RecordMsgLogic", "[parser] parseXML exception:%s", e2.toString());
        }
    }

    public static int rS(int i) {
        if (2 == i) {
            return com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE;
        }
        if (4 == i) {
            return com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
        }
        return com.tencent.mm.modelcdntran.b.MediaType_FILE;
    }

    public static boolean a(rm rmVar, long j, boolean z) {
        if (rmVar == null) {
            w.w("MicroMsg.RecordMsgLogic", "try download data fail, dataitem is null");
            return false;
        }
        String d = d(rmVar.lKv, j, true);
        g Do = s.aWF().Do(d);
        if (Do == null) {
            Do = new g();
            Do.field_cdnKey = rmVar.txk;
            Do.field_cdnUrl = rmVar.txi;
            Do.field_dataId = rmVar.lKv;
            Do.field_mediaId = d;
            Do.field_totalLen = (int) rmVar.txD;
            Do.field_localId = new Random().nextInt(2147483645) + 1;
            Do.field_path = c(rmVar, j);
            Do.field_type = 1;
            Do.field_fileType = rS(rmVar.aMw);
            Do.field_isThumb = false;
            boolean a = s.aWF().a(Do);
            w.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", Integer.valueOf(Do.field_localId), Boolean.valueOf(a));
            if (!bg.mA(rmVar.tyk) && rmVar.tyk.equals("WeNoteHtmlFile")) {
                s.aWH().a(Do, true);
            }
        }
        w.d("MicroMsg.RecordMsgLogic", "try download data, dump record cdninfo: %s", Do);
        if (4 == Do.field_status) {
            w.w("MicroMsg.RecordMsgLogic", "try download, but cdn info out of date, code[%d]", Integer.valueOf(Do.field_errCode));
            return false;
        }
        if (3 == Do.field_status) {
            w.i("MicroMsg.RecordMsgLogic", "try download, but cdn info error, code[%d], can retry[%B]", Integer.valueOf(Do.field_errCode), Boolean.valueOf(z));
            if (!z) {
                return false;
            }
            Do.field_status = 1;
            s.aWF().b(Do, "localId");
        }
        s.aWH().run();
        return true;
    }

    public static boolean g(rm rmVar, long j) {
        if (rmVar == null) {
            w.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate fail, dataitem is null");
            return true;
        }
        g Do = s.aWF().Do(d(rmVar.lKv, j, true));
        if (Do == null) {
            w.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, not find cdn info");
            return false;
        } else if (4 == Do.field_status) {
            w.w("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, status err, code %d", Integer.valueOf(Do.field_errCode));
            return true;
        } else {
            w.d("MicroMsg.RecordMsgLogic", "checkDataOutOfDate ok, find cdn info, status %d", Integer.valueOf(Do.field_status));
            return false;
        }
    }

    public static boolean b(rm rmVar, long j, boolean z) {
        if (rmVar == null) {
            w.w("MicroMsg.RecordMsgLogic", "try download thumb error, dataitem is null");
            return false;
        }
        String vZ = vZ(rmVar.lKv);
        String d = d(vZ, j, true);
        g Do = s.aWF().Do(d);
        if (Do == null) {
            Do = new g();
            Do.field_cdnKey = rmVar.txe;
            Do.field_cdnUrl = rmVar.hhy;
            Do.field_dataId = vZ;
            Do.field_mediaId = d;
            Do.field_totalLen = (int) rmVar.txO;
            Do.field_localId = new Random().nextInt(2147483645) + 1;
            Do.field_path = f(rmVar, j);
            Do.field_type = 1;
            Do.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE;
            Do.field_isThumb = true;
            boolean a = s.aWF().a(Do);
            w.d("MicroMsg.RecordMsgLogic", "insert localId[%d] result[%B]", Integer.valueOf(Do.field_localId), Boolean.valueOf(a));
        }
        w.v("MicroMsg.RecordMsgLogic", "try download thumb, dump record cdninfo: %s", Do);
        if (4 == Do.field_status) {
            w.w("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info out of date, code[%d]", Integer.valueOf(Do.field_errCode));
            return false;
        }
        if (3 == Do.field_status) {
            w.i("MicroMsg.RecordMsgLogic", "try download thumb, but cdn info error, code[%d], can retry[%B]", Integer.valueOf(Do.field_errCode), Boolean.valueOf(z));
            if (!z) {
                return false;
            }
            Do.field_status = 1;
            s.aWF().b(Do, "localId");
        }
        s.aWH().run();
        return true;
    }

    public static String eL(String str) {
        ap.yY();
        x Rc = com.tencent.mm.u.c.wR().Rc(str);
        if (Rc == null) {
            w.w("MicroMsg.RecordMsgLogic", "wtf get contact null, username %s", str);
            return "";
        }
        String tL = Rc.tL();
        if (!o.dH(tL)) {
            return tL;
        }
        List eA = j.eA(str);
        String xL = com.tencent.mm.u.m.xL();
        if (eA == null || eA.isEmpty()) {
            w.w("MicroMsg.RecordMsgLogic", "get members from username error, content empty");
            return tL;
        }
        eA.remove(xL);
        eA.add(0, xL);
        return j.b(eA, 3);
    }

    public static boolean h(rm rmVar, long j) {
        return com.tencent.mm.sdk.platformtools.o.Pj(c(rmVar, j));
    }
}
