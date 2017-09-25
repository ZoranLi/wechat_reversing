package com.tencent.mm.plugin.aa.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.t;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.aa.a.b.c;
import com.tencent.mm.plugin.aa.b;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.protocal.c.y;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public final class h {
    private static synchronized void as(String str, String str2) {
        boolean z = true;
        synchronized (h.class) {
            if (!bg.mA(str)) {
                a ek = a.ek(str);
                if (!(ek == null || bg.mA(ek.hje))) {
                    long j;
                    c mJ = b.NJ().mJ(ek.hje);
                    String str3 = "MicroMsg.AAUtil";
                    String str4 = "insertAAMsg, billNo: %s, chatroom: %s, oldRecord: %s, insertMsg: %s, localMsgId: %s";
                    Object[] objArr = new Object[5];
                    objArr[0] = ek.hje;
                    objArr[1] = str2;
                    objArr[2] = mJ;
                    if (mJ == null || !mJ.field_insertmsg) {
                        z = false;
                    }
                    objArr[3] = Boolean.valueOf(z);
                    if (mJ != null) {
                        j = mJ.field_localMsgId;
                    } else {
                        j = 0;
                    }
                    objArr[4] = Long.valueOf(j);
                    w.i(str3, str4, objArr);
                    if (mJ == null) {
                        w.e("MicroMsg.AAUtil", "insertAAMsg, record is null!!");
                    } else if (!mJ.field_insertmsg || mJ.field_localMsgId <= 0) {
                        ce auVar = new au();
                        auVar.z(ay.gk(str2));
                        auVar.setType(436207665);
                        auVar.setContent(m.xL() + ":\n" + str);
                        String n = g.n((bg.Nz()).getBytes());
                        String js = n.GS().js(n);
                        n.GS();
                        n = f.jt(n);
                        com.tencent.mm.ah.a.a GW = n.GW();
                        String str5 = ek.hiO;
                        com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
                        aVar.hIN = js;
                        aVar.hIL = true;
                        GW.a(str5, null, aVar.Hg());
                        auVar.cI(n);
                        auVar.dw(1);
                        auVar.cH(str2);
                        auVar.dv(3);
                        auVar.x(ay.i(auVar));
                        w.i("MicroMsg.AAUtil", "finish insert aa msg");
                        a(ek.hje, true, auVar.field_msgId);
                        com.tencent.mm.sdk.b.b tVar = new t();
                        tVar.fCY.fCZ = auVar;
                        tVar.fCY.fDa = ek;
                        com.tencent.mm.sdk.b.a.urY.m(tVar);
                        com.tencent.mm.sdk.e.c fVar = new com.tencent.mm.t.f();
                        ek.a(fVar);
                        fVar.field_msgId = auVar.field_msgId;
                        an.bDk().b(fVar);
                    }
                }
            }
        }
    }

    public static synchronized void a(String str, boolean z, long j) {
        synchronized (h.class) {
            if (!bg.mA(str)) {
                w.i("MicroMsg.AAUtil", "insertOrUpdateAARecord, billNo: %s, insertMsg: %s", new Object[]{str, Boolean.valueOf(z)});
                c cVar = new c();
                cVar.field_billNo = str;
                cVar.field_insertmsg = z;
                cVar.field_localMsgId = j;
                b.NJ().b(cVar);
            }
        }
    }

    public static synchronized void at(String str, String str2) {
        boolean z = true;
        synchronized (h.class) {
            if (!bg.mA(str)) {
                a ek = a.ek(str);
                String str3 = "MicroMsg.AAUtil";
                String str4 = "checkIfInsertAAMsg, billNo: %s, appMsgContent: %s";
                Object[] objArr = new Object[2];
                objArr[0] = ek != null ? ek.hje : "";
                objArr[1] = str.trim().replace(" ", "");
                w.d(str3, str4, objArr);
                if (!(ek == null || bg.mA(ek.hje))) {
                    boolean z2;
                    long j;
                    String str5 = ek.hje;
                    c mJ = b.NJ().mJ(str5);
                    str4 = "MicroMsg.AAUtil";
                    String str6 = "checkIfInsertAAMsg, record==null: %s, billNo: %s, insertMsg: %s, chatroom: %s, localMsgId: %s";
                    Object[] objArr2 = new Object[5];
                    if (mJ == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objArr2[0] = Boolean.valueOf(z2);
                    objArr2[1] = str5;
                    if (mJ == null || !mJ.field_insertmsg) {
                        z = false;
                    }
                    objArr2[2] = Boolean.valueOf(z);
                    objArr2[3] = str2;
                    if (mJ != null) {
                        j = mJ.field_localMsgId;
                    } else {
                        j = 0;
                    }
                    objArr2[4] = Long.valueOf(j);
                    w.i(str4, str6, objArr2);
                    if (mJ != null && mJ.field_insertmsg && mJ.field_localMsgId > 0) {
                        ap.yY();
                        if (com.tencent.mm.u.c.wT().cA(mJ.field_localMsgId).field_msgId <= 0) {
                            w.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, the oldMsgInfo has deleted, ignore this");
                            b.NJ().a(mJ, new String[0]);
                        }
                    } else if (mJ == null || !mJ.field_insertmsg || mJ.field_localMsgId <= 0) {
                        w.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, insert new aa msg");
                        as(str, str2);
                    } else {
                        w.i("MicroMsg.AAUtil", "checkIfInsertAAMsg, update aa msg");
                        f(mJ.field_localMsgId, str);
                    }
                }
            }
        }
    }

    public static synchronized void q(String str, String str2, String str3) {
        synchronized (h.class) {
            w.i("MicroMsg.AAUtil", "setAARecordAfterLaunchAA, billNo: %s, chatroom: %s, msgContent==null:%s, oldRecord: %s", new Object[]{str, str2, Boolean.valueOf(bg.mA(str3)), b.NJ().mJ(str)});
            if (b.NJ().mJ(str) == null) {
                a(str, false, 0);
            }
            at(str3, str2);
        }
    }

    public static synchronized void b(String str, String str2, String str3, String str4, String str5) {
        boolean z = true;
        synchronized (h.class) {
            w.d("MicroMsg.AAUtil", "insertPayMsgAfterPaySucc, launcherUsername: %s, billNo: %s, payMsgId: %s", new Object[]{str, str3, str4});
            if (!(bg.mA(str) || bg.mA(str3) || bg.mA(str4))) {
                com.tencent.mm.plugin.aa.a.b.a mI = b.NK().mI(str4);
                String str6 = "MicroMsg.AAUtil";
                String str7 = "insertPayMsgAfterPaySucc, launcherUsername: %s, chatroom: %s, payMsgId: %s, record: %s, insertmsg: %s";
                Object[] objArr = new Object[5];
                objArr[0] = str;
                objArr[1] = str2;
                objArr[2] = str4;
                objArr[3] = mI;
                if (mI == null || !mI.field_insertmsg) {
                    z = false;
                }
                objArr[4] = Boolean.valueOf(z);
                w.i(str6, str7, objArr);
                if (mI == null || !mI.field_insertmsg) {
                    String str8 = "weixin://weixinnewaa/opendetail?billno=" + str3 + "&launcherusername=" + str;
                    if (bg.mA(str5)) {
                        w.i("MicroMsg.AAUtil", "empty msgxml, insert local msgcontent");
                        if (str.equals(m.xL())) {
                            str5 = ab.getContext().getString(R.l.eFp, new Object[]{str8});
                        } else {
                            String E = com.tencent.mm.u.n.E(str, str2);
                            str5 = ab.getContext().getString(R.l.eFq, new Object[]{E, str8});
                        }
                    } else {
                        w.d("MicroMsg.AAUtil", "insert msgxml: %s", new Object[]{str5});
                    }
                    a(str5, str2, mI, str4);
                }
            }
        }
    }

    public static synchronized void r(String str, String str2, String str3) {
        synchronized (h.class) {
            try {
                if (!(bg.mA(str) || bg.mA(str2) || bg.mA(str3))) {
                    w.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, chatroom: %s, payMsgId: %s", new Object[]{str2, str3});
                    com.tencent.mm.plugin.aa.a.b.a mI = b.NK().mI(str3);
                    if (mI == null || !mI.field_insertmsg) {
                        w.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, insert new msg");
                        a(str, str2, mI, str3);
                    } else {
                        ap.yY();
                        ce cA = com.tencent.mm.u.c.wT().cA(mI.field_msgId);
                        w.i("MicroMsg.AAUtil", "checkIfInsertPaySysMsg, update old one, msgId: %s, dbMsginfo.id: %s", new Object[]{Long.valueOf(mI.field_msgId), Long.valueOf(cA.field_msgId)});
                        cA.setContent(str);
                        ap.yY();
                        com.tencent.mm.u.c.wT().a(mI.field_msgId, cA);
                    }
                }
            } catch (Exception e) {
                w.e("MicroMsg.AAUtil", "checkIfInsertPaySysMsg error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    private static synchronized void a(String str, String str2, com.tencent.mm.plugin.aa.a.b.a aVar, String str3) {
        synchronized (h.class) {
            au auVar = new au();
            auVar.dw(0);
            auVar.cH(str2);
            auVar.dv(3);
            auVar.setContent(str);
            auVar.z(ay.i(str2, System.currentTimeMillis() / 1000));
            auVar.setType(10000);
            ap.yY();
            long L = com.tencent.mm.u.c.wT().L(auVar);
            w.i("MicroMsg.AAUtil", "insertPaySysMsg, inserted msgId: %s", new Object[]{Long.valueOf(L)});
            if (aVar == null) {
                aVar = new com.tencent.mm.plugin.aa.a.b.a();
            }
            if (L > 0) {
                aVar.field_payMsgId = str3;
                aVar.field_chatroom = str2;
                aVar.field_insertmsg = true;
                aVar.field_msgId = L;
                b.NK().a(aVar);
            }
        }
    }

    public static synchronized void f(long j, String str) {
        synchronized (h.class) {
            if (j > 0) {
                if (!bg.mA(str)) {
                    a ek = a.ek(str);
                    if (ek == null || bg.mA(ek.hje)) {
                        w.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, parse app msg failed, msgId: %s", new Object[]{Long.valueOf(j)});
                    } else {
                        w.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, msgId: %s, billNo: %s", new Object[]{Long.valueOf(j), ek.hje});
                        c mJ = b.NJ().mJ(ek.hje);
                        if (mJ != null) {
                            long j2 = mJ.field_localMsgId;
                            ap.yY();
                            ce cA = com.tencent.mm.u.c.wT().cA(j2);
                            if (cA.field_msgId > 0) {
                                cA.setContent(ay.gi(cA.field_content) + ":\n" + str);
                                ap.yY();
                                com.tencent.mm.u.c.wT().a(j2, cA);
                                w.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, update success, oldMsgId: %s, billNo: %s", new Object[]{Long.valueOf(j2), mJ.field_billNo});
                            } else {
                                w.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, cannot find old msg, insert new one, billNo: %s, oldMsgId: %s, newMsgId: %s, needUpdateInfo.msgId: %s", new Object[]{mJ.field_billNo, Long.valueOf(mJ.field_localMsgId), Long.valueOf(j), Long.valueOf(cA.field_msgId)});
                            }
                        } else {
                            mJ = new c();
                            mJ.field_localMsgId = j;
                            mJ.field_billNo = ek.hje;
                            mJ.field_insertmsg = true;
                            b.NJ().a(mJ);
                            w.i("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, insert new aa record, msgId: %s, billNo: %s", new Object[]{Long.valueOf(j), ek.hje});
                        }
                    }
                }
            }
            w.e("MicroMsg.AAUtil", "updateAARecordMsgAfterReceive, msgContent is null or msgId invalid, msgId: %s, %s", new Object[]{Long.valueOf(j), Boolean.valueOf(bg.mA(str))});
        }
    }

    public static void g(long j, String str) {
        w.i("MicroMsg.AAUtil", "do update sys msg, %s, %s", new Object[]{Long.valueOf(j), str});
        ap.yY();
        au cA = com.tencent.mm.u.c.wT().cA(j);
        String mF = mF(str);
        if (!bg.mA(mF)) {
            cA.setContent(mF);
        }
        ap.yY();
        com.tencent.mm.u.c.wT().a(j, cA);
    }

    public static boolean a(Activity activity, y yVar) {
        if (yVar.tca == 1) {
            w.i("MicroMsg.AAUtil", "need realname verify");
            Bundle bundle = new Bundle();
            bundle.putString("realname_verify_process_jump_activity", ".ui.LaunchAAUI");
            bundle.putString("realname_verify_process_jump_plugin", "aa");
            String str = yVar.nnO;
            str = yVar.nnP;
            str = yVar.nnQ;
            return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, bundle, 0);
        } else if (yVar.tca == 2) {
            w.i("MicroMsg.AAUtil", "need upload credit");
            return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, yVar.nnO, yVar.nnR, yVar.nnP, yVar.nnQ, false, null);
        } else {
            w.i("MicroMsg.AAUtil", "realnameGuideFlag =  " + yVar.tca);
            return false;
        }
    }

    private static String mF(String str) {
        UnsupportedEncodingException e;
        String str2 = (String) bh.q(str, "sysmsg").get(".sysmsg.paymsg.appmsgcontent");
        if (bg.mA(str2)) {
            w.e("MicroMsg.AAUtil", "empty appmsgcontent!");
            return "";
        }
        String str3 = "";
        try {
            str2 = URLDecoder.decode(str2, "UTF-8");
            try {
                w.d("MicroMsg.AAUtil", "msgContent: %s", new Object[]{str2});
                return str2;
            } catch (UnsupportedEncodingException e2) {
                e = e2;
                w.e("MicroMsg.AAUtil", e.getMessage());
                return str2;
            }
        } catch (UnsupportedEncodingException e3) {
            UnsupportedEncodingException unsupportedEncodingException = e3;
            str2 = str3;
            e = unsupportedEncodingException;
            w.e("MicroMsg.AAUtil", e.getMessage());
            return str2;
        }
    }

    public static double b(String str, String str2, int i, int i2) {
        try {
            return new BigDecimal(bg.getDouble(str.trim(), 0.0d) == 0.0d ? "0" : str.trim()).divide(new BigDecimal(str2.trim()), i, i2).doubleValue();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.AAUtil", e, "", new Object[0]);
            return 0.0d;
        }
    }

    public static long au(String str, String str2) {
        try {
            double d = bg.getDouble(str, 0.0d);
            double d2 = bg.getDouble(str2, 0.0d);
            if (d == 0.0d) {
                str = "0";
            }
            BigDecimal bigDecimal = new BigDecimal(str);
            if (d2 == 0.0d) {
                str2 = "0";
            }
            return bigDecimal.multiply(new BigDecimal(str2)).longValue();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.AAUtil", e, "", new Object[0]);
            return 0;
        }
    }

    public static List<String> mG(String str) {
        if (bg.mA(str)) {
            w.i("MicroMsg.AAUtil", "illegal chatroomName");
            return new ArrayList();
        } else if (o.dH(str)) {
            try {
                ap.yY();
                r0 = com.tencent.mm.u.c.xa().fZ(str);
                if (r0 == null) {
                    return new ArrayList();
                }
                return r0;
            } catch (Exception e) {
                w.e("MicroMsg.AAUtil", "getChatroomMemberList error! %s", new Object[]{e.getMessage()});
                return new ArrayList();
            }
        } else {
            r0 = new ArrayList();
            r0.add(m.xL());
            r0.add(str);
            return r0;
        }
    }

    public static String NT() {
        ap.yY();
        return bg.mz((String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uIa, null));
    }

    public static void mH(String str) {
        String NT = NT();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(",");
        if (!bg.mA(NT)) {
            String[] split = NT.split(",");
            int i = 1;
            for (String str2 : split) {
                if (!str2.equals(str) && i < 5) {
                    stringBuilder.append(str2);
                    stringBuilder.append(",");
                    i++;
                }
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        w.d("MicroMsg.AAUtil", "recent group: %s", new Object[]{stringBuilder.toString()});
        ap.yY();
        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uIa, stringBuilder.toString());
    }
}
