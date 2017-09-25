package com.tencent.mm.u;

import android.database.Cursor;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.ame;
import com.tencent.mm.protocal.c.amt;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class o {
    public static final String hlr = c("rconversation.username", new String[]{"@chatroom", "@micromsg.qq.com"});
    public static final String hls = c("rconversation.username", new String[]{"@t.qq.com"});
    public static final String hlt = c("rconversation.username", new String[]{"@qqim"});
    public static final String hlu = c("rconversation.username", new String[]{"@chatroom_exclusive"});
    public static final String hlv = c("rconversation.username", new String[]{"@micromsg.qq.com"});
    public static final String hlw = c("rconversation.username", new String[]{"@app"});
    public static final String hlx = c("rconversation.username", new String[]{"@chatroom"});
    public static final String[] hly = new String[]{"qqmail", "fmessage", "tmessage", "qmessage", "qqsync", "floatbottle", "lbsapp", "shakeapp", "medianote", "qqfriend", "newsapp", "blogapp", "facebookapp", "masssendapp", "feedsapp", "voipapp", "cardpackage", "voicevoipapp", "voiceinputapp", "officialaccounts", "linkedinplugin", "notifymessage", "appbrandcustomerservicemsg"};

    public static boolean eN(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        if (!str.contains("@") || str.endsWith("@micromsg.qq.com")) {
            return true;
        }
        return false;
    }

    public static boolean dH(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@chatroom");
    }

    public static boolean eO(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@bottle");
    }

    public static boolean eP(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@qqim");
    }

    public static boolean eQ(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@lbsroom");
    }

    public static boolean d(x xVar) {
        if (xVar != null && bg.mz(xVar.field_username).endsWith("@chatroom") && a.ez(xVar.field_type)) {
            return true;
        }
        return false;
    }

    public static boolean eR(String str) {
        return "gh_43f2581f6fd6".equals(str);
    }

    public static boolean eS(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        if (!str.endsWith("@chatroom")) {
            return false;
        }
        af Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(str);
        if (Rc == null || !a.ez(Rc.field_type)) {
            return false;
        }
        return true;
    }

    public static boolean eT(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@stranger");
    }

    public static List<String> yu() {
        return ((h) com.tencent.mm.kernel.h.h(h.class)).wR().bLq();
    }

    public static List<x> yv() {
        List<x> arrayList = new ArrayList();
        Cursor bLr = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().bLr();
        if (bLr.moveToFirst()) {
            do {
                x xVar = new x();
                xVar.b(bLr);
                arrayList.add(xVar);
            } while (bLr.moveToNext());
        }
        bLr.close();
        return arrayList;
    }

    public static String a(x xVar, String str) {
        if (xVar == null) {
            return str;
        }
        if (str.toLowerCase().endsWith("@chatroom") && bg.mA(xVar.field_nickname)) {
            String eK = ((com.tencent.mm.plugin.chatroom.b.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa().eK(str);
            if (!bg.mA(eK)) {
                return eK;
            }
        }
        if (xVar.tL() == null || xVar.tL().length() <= 0) {
            return str;
        }
        return xVar.tL();
    }

    public static boolean eU(String str) {
        if (str == null || str.length() <= 0) {
            return true;
        }
        return a.ez(((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(str).field_type);
    }

    public static boolean eV(String str) {
        if (bg.mA(str)) {
            return false;
        }
        af Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(str);
        if (Rc == null) {
            return false;
        }
        return x.yC(Rc.field_verifyFlag);
    }

    public static boolean eW(int i) {
        return x.yC(i);
    }

    public static void e(x xVar) {
        Assert.assertTrue(xVar != null);
        af Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(xVar.field_username);
        if (!(Rc == null || bg.mA(Rc.field_username))) {
            af afVar = Rc;
        }
        xVar.ti();
        t(xVar);
    }

    public static void k(String str, boolean z) {
        af Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(str);
        if (Rc != null && !bg.mA(Rc.field_username)) {
            if (z) {
                Rc.tr();
            } else {
                Rc.ts();
            }
            s(Rc);
        }
    }

    public static void f(x xVar) {
        Assert.assertTrue(xVar != null);
        af Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(xVar.field_username);
        if (!(Rc == null || bg.mA(Rc.field_username))) {
            af afVar = Rc;
        }
        xVar.tg();
        t(xVar);
    }

    public static void g(x xVar) {
        Assert.assertTrue(xVar != null);
        af Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(xVar.field_username);
        if (!(Rc == null || bg.mA(Rc.field_username))) {
            af afVar = Rc;
        }
        xVar.th();
        t(xVar);
    }

    public static void h(x xVar) {
        Assert.assertTrue(xVar != null);
        af Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(xVar.field_username);
        if (!(Rc == null || bg.mA(Rc.field_username))) {
            af afVar = Rc;
        }
        xVar.te();
        t(xVar);
    }

    public static void i(x xVar) {
        Assert.assertTrue(xVar != null);
        x Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(xVar.field_username);
        if (Rc == null || bg.mA(Rc.field_username)) {
            Rc = xVar;
        }
        Rc.tf();
        t(Rc);
        aj Rm = ((h) com.tencent.mm.kernel.h.h(h.class)).wW().Rm(xVar.field_username);
        if (Rm != null && "@blacklist".equals(Rm.field_parentRef)) {
            ((h) com.tencent.mm.kernel.h.h(h.class)).wW().e(new String[]{Rm.field_username}, "");
        }
    }

    public static void j(x xVar) {
        Assert.assertTrue(xVar != null);
        x Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(xVar.field_username);
        if (Rc == null || bg.mA(Rc.field_username)) {
            Rc = xVar;
        }
        Rc.tr();
        Rc.dc(xVar.sZ());
        s(Rc);
    }

    public static void k(x xVar) {
        Assert.assertTrue(xVar != null);
        x Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(xVar.field_username);
        if (Rc == null || bg.mA(Rc.field_username)) {
            Rc = xVar;
        }
        Rc.ts();
        Rc.dc(xVar.sZ());
        s(Rc);
    }

    public static void l(x xVar) {
        Assert.assertTrue(xVar != null);
        x Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(xVar.field_username);
        if (Rc == null || bg.mA(Rc.field_username)) {
            Rc = xVar;
        }
        Rc.tn();
        Rc.dc(xVar.sZ());
        t(Rc);
    }

    public static void m(x xVar) {
        Assert.assertTrue(xVar != null);
        x Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(xVar.field_username);
        if (Rc == null || bg.mA(Rc.field_username)) {
            Rc = xVar;
        }
        Rc.to();
        Rc.dc(xVar.sZ());
        t(Rc);
    }

    public static void l(String str, boolean z) {
        Assert.assertTrue(!bg.mA(str));
        x Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(str);
        if (Rc != null && !bg.mA(Rc.field_username)) {
            Rc.setType(Rc.field_type | 2048);
            t(Rc);
            if (z) {
                ((h) com.tencent.mm.kernel.h.h(h.class)).wW().Rr(str);
            }
        }
    }

    public static void eW(String str) {
        ae Rm = ((h) com.tencent.mm.kernel.h.h(h.class)).wW().Rm(str);
        Object obj = null;
        if (Rm == null) {
            Rm = new ae();
            Rm.bLB();
            obj = 1;
            Rm.setUsername(str);
        }
        Rm.s(System.currentTimeMillis());
        if (obj != null) {
            ((h) com.tencent.mm.kernel.h.h(h.class)).wW().d(Rm);
        } else {
            ((h) com.tencent.mm.kernel.h.h(h.class)).wW().a(Rm, str);
        }
    }

    public static void m(String str, boolean z) {
        Assert.assertTrue(!bg.mA(str));
        x Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(str);
        if (Rc != null && !bg.mA(Rc.field_username)) {
            Rc.setType(Rc.field_type & -2049);
            t(Rc);
            if (z) {
                ((h) com.tencent.mm.kernel.h.h(h.class)).wW().Rs(str);
            }
        }
    }

    public static void n(x xVar) {
        Assert.assertTrue(xVar != null);
        af Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(xVar.field_username);
        if (!(Rc == null || bg.mA(Rc.field_username))) {
            af afVar = Rc;
        }
        xVar.tp();
        t(xVar);
    }

    public static void o(x xVar) {
        Assert.assertTrue(xVar != null);
        af Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(xVar.field_username);
        if (!(Rc == null || bg.mA(Rc.field_username))) {
            af afVar = Rc;
        }
        xVar.tq();
        t(xVar);
    }

    public static void p(x xVar) {
        boolean z;
        boolean z2 = true;
        Assert.assertTrue("MicroMsg.ContactStorageLogic: user is null", xVar != null);
        String str = "MicroMsg.ContactStorageLogic: contactId == 0";
        if (((int) xVar.gTQ) != 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(str, z);
        String str2 = "MicroMsg.ContactStorageLogic: username length <= 0";
        if (xVar.field_username.length() <= 0) {
            z2 = false;
        }
        Assert.assertTrue(str2, z2);
        xVar.tc();
        ((h) com.tencent.mm.kernel.h.h(h.class)).wR().a(xVar.field_username, xVar);
    }

    public static void q(x xVar) {
        boolean z;
        boolean z2 = true;
        Assert.assertTrue(xVar != null);
        if (((int) xVar.gTQ) != 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (xVar.field_username.length() <= 0) {
            z2 = false;
        }
        Assert.assertTrue(z2);
        xVar.tc();
        ((h) com.tencent.mm.kernel.h.h(h.class)).wR().a(xVar.field_username, xVar);
        t(xVar);
    }

    public static void b(x xVar, String str) {
        x Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(xVar.field_username);
        boolean z = (Rc == null || str == null) ? false : true;
        Assert.assertTrue(z);
        Rc.bP(str);
        t(Rc);
    }

    public static void r(x xVar) {
        boolean z;
        boolean z2 = true;
        Assert.assertTrue(xVar != null);
        if (((int) xVar.gTQ) != 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (xVar.field_username.length() <= 0) {
            z2 = false;
        }
        Assert.assertTrue(z2);
        xVar.tI();
        t(xVar);
    }

    private static void s(x xVar) {
        Assert.assertTrue(xVar != null);
        if (((int) xVar.gTQ) == 0) {
            ((h) com.tencent.mm.kernel.h.h(h.class)).wR().S(xVar);
            ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(xVar.field_username);
        }
        ((h) com.tencent.mm.kernel.h.h(h.class)).wR().a(xVar.field_username, xVar);
        com.tencent.mm.bd.a com_tencent_mm_protocal_c_amt = new amt();
        com_tencent_mm_protocal_c_amt.tRa = xVar.field_username;
        if (xVar.tF()) {
            com_tencent_mm_protocal_c_amt.tRm = 1;
        } else {
            com_tencent_mm_protocal_c_amt.tRm = 2;
        }
        ((h) com.tencent.mm.kernel.h.h(h.class)).wQ().b(new e.a(52, com_tencent_mm_protocal_c_amt));
    }

    public static void t(x xVar) {
        Assert.assertTrue(xVar != null);
        if (((int) xVar.gTQ) == 0) {
            ((h) com.tencent.mm.kernel.h.h(h.class)).wR().S(xVar);
            ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(xVar.field_username);
        }
        ((h) com.tencent.mm.kernel.h.h(h.class)).wR().a(xVar.field_username, xVar);
        u(xVar);
    }

    public static void u(x xVar) {
        w.i("MicroMsg.ContactStorageLogic", "oplog modContact user:%s remark:%s type:%d ", xVar.field_username, xVar.field_conRemark, Integer.valueOf(xVar.field_type));
        com.tencent.mm.bd.a com_tencent_mm_protocal_c_ame = new ame();
        com_tencent_mm_protocal_c_ame.ttp = new avx().OV(bg.mz(xVar.field_username));
        com_tencent_mm_protocal_c_ame.tLj = new avx().OV(bg.mz(xVar.field_nickname));
        com_tencent_mm_protocal_c_ame.ttf = new avx().OV(bg.mz(xVar.pB()));
        com_tencent_mm_protocal_c_ame.ttg = new avx().OV(bg.mz(xVar.pC()));
        com_tencent_mm_protocal_c_ame.hAD = xVar.gkr;
        com_tencent_mm_protocal_c_ame.tsx = 561023;
        com_tencent_mm_protocal_c_ame.tsy = xVar.field_type;
        com_tencent_mm_protocal_c_ame.tQl = new avx().OV(bg.mz(xVar.field_conRemark));
        com_tencent_mm_protocal_c_ame.tQm = new avx().OV(bg.mz(xVar.field_conRemarkPYShort));
        com_tencent_mm_protocal_c_ame.tQn = new avx().OV(bg.mz(xVar.field_conRemarkPYFull));
        com_tencent_mm_protocal_c_ame.tsD = xVar.gkw;
        com_tencent_mm_protocal_c_ame.tQF = new avx().OV(bg.mz(xVar.field_domainList));
        com_tencent_mm_protocal_c_ame.tsH = xVar.gkz;
        com_tencent_mm_protocal_c_ame.hAH = xVar.gkA;
        com_tencent_mm_protocal_c_ame.hAG = bg.mz(xVar.signature);
        com_tencent_mm_protocal_c_ame.hAF = bg.mz(xVar.getCityCode());
        com_tencent_mm_protocal_c_ame.hAE = bg.mz(xVar.bLi());
        com_tencent_mm_protocal_c_ame.tMR = bg.mz(xVar.gkF);
        com_tencent_mm_protocal_c_ame.tMT = xVar.field_weiboFlag;
        com_tencent_mm_protocal_c_ame.tQB = 0;
        com_tencent_mm_protocal_c_ame.tfh = new avw();
        com_tencent_mm_protocal_c_ame.hAM = bg.mz(xVar.getCountryCode());
        ((h) com.tencent.mm.kernel.h.h(h.class)).wQ().b(new e.a(2, com_tencent_mm_protocal_c_ame));
    }

    public static void eX(String str) {
        if (!bg.mA(str)) {
            x Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(str);
            if (Rc != null) {
                Rc.ta();
                ((h) com.tencent.mm.kernel.h.h(h.class)).wR().a(str, Rc);
            }
        }
    }

    public static int[] a(String str, String str2, List<String> list, String str3) {
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis();
        int[] b = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().b(str, str2, str3, (List) list);
        w.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - currentTimeMillis));
        if (b.length <= 0) {
            return null;
        }
        currentTimeMillis = System.currentTimeMillis();
        int[] c = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().c(str, str2, str3, (List) list);
        w.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (c == null) {
            return null;
        }
        Assert.assertTrue(b.length == c.length);
        int[] iArr = new int[c.length];
        int i2 = 0;
        int i3 = 0;
        while (i < b.length) {
            int i4 = i3 + 1;
            iArr[i3] = i2;
            i2 += c[i];
            i++;
            i3 = i4;
        }
        return iArr;
    }

    public static int[] t(List<String> list) {
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis();
        int[] cl = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().cl(list);
        w.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - currentTimeMillis));
        if (cl.length <= 0) {
            return null;
        }
        currentTimeMillis = System.currentTimeMillis();
        int[] cm = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().cm(list);
        w.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (cm == null) {
            return null;
        }
        Assert.assertTrue(cl.length == cm.length);
        int[] iArr = new int[cm.length];
        int i2 = 0;
        int i3 = 0;
        while (i < cl.length) {
            int i4 = i3 + 1;
            iArr[i3] = i2;
            i2 += cm[i];
            i++;
            i3 = i4;
        }
        return iArr;
    }

    public static int[] a(String str, String str2, List<String> list, String[] strArr) {
        int i = 0;
        int[] b = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().b(str, str2, strArr, (List) list);
        if (b.length <= 0) {
            return null;
        }
        int[] c = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().c(str, str2, strArr, (List) list);
        if (c == null) {
            return null;
        }
        Assert.assertTrue(b.length == c.length);
        int[] iArr = new int[c.length];
        int i2 = 0;
        int i3 = 0;
        while (i < b.length) {
            int i4 = i3 + 1;
            iArr[i3] = i2;
            i2 += c[i];
            i++;
            i3 = i4;
        }
        return iArr;
    }

    public static String[] a(String str, String str2, String[] strArr, List<String> list) {
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis();
        int[] b = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().b(str, str2, strArr, (List) list);
        w.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (b.length <= 0) {
            return null;
        }
        String[] strArr2 = new String[b.length];
        int i2 = 0;
        while (i < b.length) {
            int i3;
            char c = (char) b[i];
            if (c == '{') {
                i3 = i2 + 1;
                strArr2[i2] = "#";
            } else if (c == ' ') {
                i3 = i2 + 1;
                strArr2[i2] = "$";
            } else {
                i3 = i2 + 1;
                strArr2[i2] = String.valueOf(c);
            }
            i++;
            i2 = i3;
        }
        return strArr2;
    }

    public static String[] a(String str, String str2, String str3, List<String> list) {
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis();
        int[] b = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().b(str, str2, str3, (List) list);
        w.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (b.length <= 0) {
            return null;
        }
        String[] strArr = new String[b.length];
        int i2 = 0;
        while (i < b.length) {
            int i3;
            char c = (char) b[i];
            if (c == '{') {
                i3 = i2 + 1;
                strArr[i2] = "#";
            } else if (c == ' ') {
                i3 = i2 + 1;
                strArr[i2] = "$";
            } else {
                i3 = i2 + 1;
                strArr[i2] = String.valueOf(c);
            }
            i++;
            i2 = i3;
        }
        return strArr;
    }

    public static String[] u(List<String> list) {
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis();
        int[] cl = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().cl(list);
        w.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (cl.length <= 0) {
            return null;
        }
        String[] strArr = new String[cl.length];
        for (int i2 : cl) {
            int i22;
            char c = (char) i22;
            if (c == '{') {
                i22 = i + 1;
                strArr[i] = "#";
                i = i22;
            } else if (c == ' ') {
                i22 = i + 1;
                strArr[i] = "$";
                i = i22;
            } else {
                i22 = i + 1;
                strArr[i] = String.valueOf(c);
                i = i22;
            }
        }
        return strArr;
    }

    public static boolean eY(String str) {
        return str != null ? str.equalsIgnoreCase("qqmail") : false;
    }

    public static boolean eZ(String str) {
        return str != null ? str.equalsIgnoreCase("fmessage") : false;
    }

    public static boolean fa(String str) {
        return str != null ? str.equalsIgnoreCase("tmessage") : false;
    }

    public static boolean fb(String str) {
        return str != null ? str.equalsIgnoreCase("floatbottle") : false;
    }

    public static boolean fc(String str) {
        return str != null ? str.equalsIgnoreCase("qmessage") : false;
    }

    public static boolean fd(String str) {
        return str != null ? str.equalsIgnoreCase("facebookapp") : false;
    }

    public static boolean fe(String str) {
        return str != null ? str.equalsIgnoreCase("masssendapp") : false;
    }

    public static boolean yw() {
        return false;
    }

    public static boolean ff(String str) {
        return str != null ? str.equalsIgnoreCase("feedsapp") : false;
    }

    public static boolean fg(String str) {
        return "qqsync".equalsIgnoreCase(str);
    }

    public static boolean fh(String str) {
        if (str != null) {
            return str.equalsIgnoreCase("weixin") || str.equalsIgnoreCase("gh_9639b5a92773");
        } else {
            return false;
        }
    }

    public static boolean fi(String str) {
        return str != null ? str.equalsIgnoreCase("lbsapp") : false;
    }

    public static boolean fj(String str) {
        return str != null ? str.equalsIgnoreCase("shakeapp") : false;
    }

    public static boolean fk(String str) {
        return str != null ? str.equalsIgnoreCase("medianote") : false;
    }

    public static boolean fl(String str) {
        return str != null ? str.equalsIgnoreCase("newsapp") : false;
    }

    public static boolean fm(String str) {
        return str != null ? str.equalsIgnoreCase("voipapp") : false;
    }

    public static boolean fn(String str) {
        return str != null ? str.equalsIgnoreCase("voicevoipapp") : false;
    }

    public static boolean fo(String str) {
        return str != null ? str.equalsIgnoreCase("voiceinputapp") : false;
    }

    public static boolean fp(String str) {
        return str != null ? str.equalsIgnoreCase("linkedinplugin") : false;
    }

    public static boolean fq(String str) {
        return fs(str);
    }

    public static boolean fr(String str) {
        return str != null ? str.equalsIgnoreCase("gh_43f2581f6fd6") : false;
    }

    public static boolean fs(String str) {
        return str != null ? str.equalsIgnoreCase("gh_22b87fa7cb3c") : false;
    }

    public static boolean ft(String str) {
        return str != null ? str.equalsIgnoreCase("blogapp") : false;
    }

    public static boolean fu(String str) {
        return str != null ? str.equalsIgnoreCase("officialaccounts") : false;
    }

    public static boolean fv(String str) {
        return str != null ? str.equalsIgnoreCase("helper_entry") : false;
    }

    public static boolean fw(String str) {
        return str != null ? str.equalsIgnoreCase("qqfriend") : false;
    }

    public static boolean fx(String str) {
        return "filehelper".equalsIgnoreCase(str);
    }

    public static boolean fy(String str) {
        return str != null ? str.equalsIgnoreCase("pc_share") : false;
    }

    public static boolean fz(String str) {
        return str != null ? str.equalsIgnoreCase("notifymessage") : false;
    }

    public static boolean fA(String str) {
        return str != null ? str.equalsIgnoreCase("notification_messages") : false;
    }

    public static boolean fB(String str) {
        if (fC(str) || fE(str) || fu(str) || fv(str)) {
            return true;
        }
        return false;
    }

    public static boolean fC(String str) {
        com.tencent.mm.kernel.h.vJ();
        String str2 = (String) com.tencent.mm.kernel.h.vI().vr().get(21, null);
        if ((str2 == null || !str2.equalsIgnoreCase(str)) && !str.equalsIgnoreCase("weixin")) {
            return false;
        }
        return true;
    }

    public static boolean fD(String str) {
        return str != null ? str.equalsIgnoreCase("appbrandcustomerservicemsg") : false;
    }

    public static boolean fE(String str) {
        for (String equalsIgnoreCase : hly) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean fF(String str) {
        if (fE(str) || x.QO(str) || x.QM(str) || x.eO(str)) {
            return true;
        }
        return false;
    }

    public static int fG(String str) {
        Assert.assertTrue(bg.mz(str).length() > 0);
        String toLowerCase = str.trim().toLowerCase();
        if (toLowerCase.endsWith("@chatroom")) {
            return 1;
        }
        if (x.QM(toLowerCase)) {
            return 11;
        }
        if (x.QO(toLowerCase)) {
            return 36;
        }
        return x.eO(toLowerCase) ? 1 : 1;
    }

    public static int fH(String str) {
        Assert.assertTrue(bg.mz(str).length() > 0);
        String toLowerCase = str.trim().toLowerCase();
        if (toLowerCase.endsWith("@chatroom")) {
            return 3;
        }
        if (x.QM(toLowerCase)) {
            return 13;
        }
        if (x.QO(toLowerCase)) {
            return 39;
        }
        if (x.eO(toLowerCase)) {
            return 3;
        }
        if (toLowerCase.contains("@")) {
            return 3;
        }
        return 3;
    }

    public static boolean fI(String str) {
        if (((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(str).gkz != 1) {
            return false;
        }
        return true;
    }

    public static boolean fJ(String str) {
        x Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(str);
        if (Rc == null || !Rc.tD()) {
            return false;
        }
        return true;
    }

    public static boolean fK(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        if (str.startsWith("t.qq.com/") || str.startsWith("http://t.qq.com/")) {
            return true;
        }
        return false;
    }

    public static String fL(String str) {
        if (fK(str)) {
            return str.replace("http://t.qq.com/", "").replace("t.qq.com/", "");
        }
        return "";
    }

    public static boolean v(x xVar) {
        return (xVar.field_weiboFlag & 1) != 0;
    }

    public static boolean yx() {
        if (!m.ys()) {
            return false;
        }
        ay AH = ((h) com.tencent.mm.kernel.h.h(h.class)).wZ().AH("@t.qq.com");
        if (AH == null || bg.mA(AH.name)) {
            return false;
        }
        return true;
    }

    public static boolean yy() {
        if (!m.ys()) {
            return false;
        }
        ay AH = ((h) com.tencent.mm.kernel.h.h(h.class)).wZ().AH("@t.qq.com");
        if (AH == null || bg.mz(AH.name).length() == 0) {
            return false;
        }
        return true;
    }

    public static List<x> yz() {
        List<x> linkedList = new LinkedList();
        Cursor bLu = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().bLu();
        if (bLu.getCount() == 0) {
            bLu.close();
            return linkedList;
        }
        bLu.moveToFirst();
        do {
            x xVar = new x();
            xVar.b(bLu);
            linkedList.add(xVar);
        } while (bLu.moveToNext());
        bLu.close();
        w.d("MicroMsg.ContactStorageLogic", "getFavourList size:  " + linkedList.size());
        return linkedList;
    }

    public static List<String> yA() {
        List<String> linkedList = new LinkedList();
        Cursor bLs = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().bLs();
        if (bLs.getCount() == 0) {
            bLs.close();
            return linkedList;
        }
        bLs.moveToFirst();
        do {
            af xVar = new x();
            xVar.b(bLs);
            linkedList.add(xVar.field_username);
        } while (bLs.moveToNext());
        bLs.close();
        w.d("MicroMsg.ContactStorageLogic", "getSnsBlackContactList size:  " + linkedList.size());
        return linkedList;
    }

    public static boolean a(ae aeVar) {
        String str = aeVar.field_username;
        if (fE(str) || fC(str) || fu(str) || fv(str) || aeVar.field_conversationTime == -1) {
            return false;
        }
        if (eV(str)) {
            return true;
        }
        return true;
    }

    public static boolean b(ae aeVar) {
        String str = aeVar.field_username;
        if (fu(str) || fD(str)) {
            return false;
        }
        return true;
    }

    public static int yB() {
        return ((h) com.tencent.mm.kernel.h.h(h.class)).wR().b(hly, m.xL(), "weixin", "helper_entry", "filehelper");
    }

    private static String c(String str, String[] strArr) {
        String str2 = " and ( 1 != 1 ";
        for (Object obj : strArr) {
            if ("@all.android".equals(obj)) {
                str2 = str2 + " or 1 = 1";
            } else if ("@micromsg.qq.com".equals(obj)) {
                str2 = str2 + " or " + str + " not like '%@%'";
            } else if ("@chatroom".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@chatroom'";
            } else if ("@talkroom".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@talkroom'";
            } else if ("@t.qq.com".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@t.qq.com'";
            } else if ("@qqim".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@qqim'";
            } else if ("@chatroom_exclusive".equals(obj)) {
                str2 = str2 + " or " + str + "not like %@chatroom";
            } else if ("@app".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@app'";
            }
        }
        return str2 + " ) ";
    }
}
