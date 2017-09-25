package com.tencent.mm.plugin.location.model;

import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.e;
import com.tencent.mm.u.m;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.b;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class n extends e {
    public final b b(a aVar) {
        bu buVar = aVar.hst;
        if (buVar == null) {
            w.e("MicroMsg.TrackMsgExtension", "onPreAddMessage cmdAM is null");
        } else {
            Object linkedList = new LinkedList();
            String a = com.tencent.mm.platformtools.n.a(buVar.tfd);
            String a2 = com.tencent.mm.platformtools.n.a(buVar.tfe);
            ap.yY();
            String str = ((String) c.vr().get(2, null)).equals(a) ? a2 : a;
            String a3 = com.tencent.mm.platformtools.n.a(buVar.tff);
            w.d("MicroMsg.TrackMsgExtension", "cmd " + a3);
            Map q = bh.q(a3, "sysmsg");
            if (q != null) {
                try {
                    String aL;
                    String aM;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("talk  " + str + "\r\n");
                    stringBuffer.append("from fromUser " + a + "\r\n");
                    stringBuffer.append("from toUser " + a2 + "\r\n");
                    String str2 = (String) q.get(".sysmsg.trackmsg.trackroominfo.trackroompoi.addr");
                    double zp = zp((String) q.get(".sysmsg.trackmsg.trackroominfo.trackroompoi.latitude"));
                    stringBuffer.append("lat " + zp + "\r\n");
                    double zp2 = zp((String) q.get(".sysmsg.trackmsg.trackroominfo.trackroompoi.longitude"));
                    stringBuffer.append("lng " + zp2 + "\r\n");
                    stringBuffer.append("times " + bg.getInt((String) q.get(".sysmsg.trackmsg.trackroominfo.timestamp"), 0) + "\r\n");
                    int i = 0;
                    while (true) {
                        a3 = (String) q.get((".sysmsg.trackmsg.trackroominfo.trackmemberlist.member" + (i == 0 ? "" : Integer.valueOf(i))) + ".username");
                        if (bg.mA(a3)) {
                            break;
                        }
                        i++;
                        linkedList.add(a3);
                    }
                    stringBuffer.append("userNameList size " + linkedList.size() + "\r\n");
                    w.i("MicroMsg.TrackMsgExtension", "xml : " + stringBuffer.toString());
                    if (str.equals(l.aGe().nci)) {
                        aL = aL(linkedList);
                        aM = bg.mA(aL) ? aM(linkedList) : null;
                    } else {
                        aM = null;
                        aL = null;
                    }
                    l.aGf().a(str, linkedList, zp, zp2, str2, aL, aM);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.TrackMsgExtension", e, "", new Object[0]);
                }
            }
        }
        return null;
    }

    private static double zp(String str) {
        if (str == null) {
            return 0.0d;
        }
        return bg.getDouble(str, 0.0d);
    }

    private static String aL(List<String> list) {
        List<String> aGm = l.aGe().aGm();
        List linkedList = new LinkedList();
        for (String str : list) {
            Object obj;
            for (String equals : aGm) {
                String str2;
                if (equals.equals(str2)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                linkedList.add(str2);
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            str2 = (String) linkedList.get(i);
            if (!str2.equals(m.xL())) {
                return str2;
            }
        }
        return null;
    }

    private static String aM(List<String> list) {
        List<String> aGm = l.aGe().aGm();
        List linkedList = new LinkedList();
        for (String str : aGm) {
            Object obj;
            for (String equals : list) {
                String str2;
                if (equals.equals(str2)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                linkedList.add(str2);
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            str2 = (String) linkedList.get(i);
            if (!str2.equals(m.xL())) {
                return str2;
            }
        }
        return null;
    }
}
