package com.tencent.mm.plugin.bottle.a;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.R;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.bottle.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.h;
import com.tencent.mm.u.m;

public final class c {
    private static int jVc = 1;
    private static int jVd = 1;

    public static int ado() {
        return jVc;
    }

    public static int adp() {
        return jVd;
    }

    public static void jO(int i) {
        jVc = i;
    }

    public static void jP(int i) {
        jVd = i;
    }

    public static int adq() {
        return h.xI();
    }

    public static int jQ(int i) {
        switch (i) {
            case 1:
                return 1;
            case 2:
                return 3;
            case 3:
                return 34;
            case 4:
                return 43;
            default:
                return -1;
        }
    }

    public static String rX(String str) {
        if (bg.mA(str)) {
            return null;
        }
        String[] split = str.split("@bottle:");
        if (split == null || split.length < 2) {
            return null;
        }
        return split[1];
    }

    public static void rY(String str) {
        String[] strArr = null;
        a.imw.ou();
        ap.yY();
        if (com.tencent.mm.u.c.wT().Ax(str) == 1) {
            ap.yY();
            ce Ai = com.tencent.mm.u.c.wT().Ai(str);
            if (Ai != null && Ai.field_talker.equals(str)) {
                String rX = rX(str);
                if (!bg.mA(rX)) {
                    a aVar;
                    Cursor a = i.adw().hnH.a("select bottleinfo1.parentclientid,bottleinfo1.childcount,bottleinfo1.bottleid,bottleinfo1.bottletype,bottleinfo1.msgtype,bottleinfo1.voicelen,bottleinfo1.content,bottleinfo1.createtime,bottleinfo1.reserved1,bottleinfo1.reserved2,bottleinfo1.reserved3,bottleinfo1.reserved4 from bottleinfo1   where bottleinfo1.bottleid = \"" + bg.my(rX) + "\"", null, 0);
                    if (a == null) {
                        aVar = null;
                    } else {
                        if (a.moveToFirst()) {
                            strArr = new a();
                            strArr.jUW = a.getString(0);
                            strArr.jUX = a.getInt(1);
                            strArr.jUY = a.getString(2);
                            strArr.jUZ = a.getInt(3);
                            strArr.msgType = a.getInt(4);
                            strArr.jVa = a.getInt(5);
                            strArr.content = a.getString(6);
                            strArr.jVb = a.getLong(7);
                            strArr.hnD = a.getInt(8);
                            strArr.hBy = a.getInt(9);
                            strArr.hnF = a.getString(10);
                            strArr.hnG = a.getString(11);
                        }
                        a.close();
                        aVar = strArr;
                    }
                    if (aVar != null && aVar.adn().equals(rX) && aVar.jUZ == 1) {
                        ce auVar = new au();
                        auVar.cH(str);
                        auVar.z(Ai.field_createTime <= aVar.jVb ? Ai.field_createTime - 1 : aVar.jVb);
                        auVar.setType(jQ(aVar.msgType));
                        auVar.dv(2);
                        auVar.dw(1);
                        if (auVar.field_type == 34) {
                            auVar.setContent(n.b(m.xL(), (long) aVar.jVa, false));
                            String str2 = aVar.pM() + bg.Nz();
                            if (j.ex(q.js(aVar.pM()), q.js(str2))) {
                                auVar.cI(str2);
                            } else {
                                w.e("MicroMsg.BottleLogic", "Copy Bottle Voice File Failed :" + aVar.pM());
                                return;
                            }
                        }
                        auVar.setContent(aVar.pM());
                        ap.yY();
                        com.tencent.mm.u.c.wT().L(auVar);
                    }
                }
            }
        }
    }

    public static void adr() {
        String[] strArr;
        b adw = i.adw();
        Cursor a = adw.hnH.a("select distinct content , msgtype from bottleinfo1 where bottleinfo1.createtime < " + (bg.Nz() - 7776000000L), null, 0);
        int count = a.getCount();
        if (count > 0) {
            strArr = new String[count];
            for (int i = 0; i < count; i++) {
                a.moveToPosition(i);
                if (a.getInt(1) == 3) {
                    strArr[i] = a.getString(0);
                } else {
                    strArr[i] = null;
                }
            }
        } else {
            strArr = null;
        }
        a.close();
        if (count > 0) {
            adw.hnH.delete("bottleinfo1", "createtime< ?", new String[]{String.valueOf(r6)});
        }
        if (strArr != null) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                w.d("MicroMsg.BottleLogic", "delete path:" + q.js(strArr[i2]));
                if (!bg.mA(q.js(strArr[i2]))) {
                    b.deleteFile(q.js(strArr[i2]));
                }
            }
        }
    }

    public static String a(Context context, x xVar) {
        if (xVar == null) {
            return context.getString(R.l.dPF);
        }
        if (!RegionCodeDecoder.RR(xVar.getCountryCode())) {
            return context.getString(R.l.dPF);
        }
        String city = xVar.getCity();
        if (!bg.mA(city)) {
            return city;
        }
        city = com.tencent.mm.u.n.eM(xVar.getProvince());
        if (!bg.mA(city)) {
            return city;
        }
        RegionCodeDecoder.bMP();
        return RegionCodeDecoder.getLocName(xVar.getCountryCode());
    }

    public static String b(Context context, x xVar) {
        if (xVar == null) {
            return context.getString(R.l.dPF);
        }
        String eM = com.tencent.mm.u.n.eM(xVar.getProvince());
        if (RegionCodeDecoder.RR(xVar.getCountryCode())) {
            if (bg.mA(xVar.getCity())) {
                StringBuilder stringBuilder = new StringBuilder();
                RegionCodeDecoder.bMP();
                eM = stringBuilder.append(RegionCodeDecoder.getLocName(xVar.getCountryCode())).append(eM).toString();
            } else {
                eM = eM + xVar.getCity();
            }
        }
        return bg.mA(eM) ? context.getString(R.l.dPF) : eM;
    }
}
