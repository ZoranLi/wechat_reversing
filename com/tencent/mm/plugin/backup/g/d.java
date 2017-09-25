package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.j.a;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.b;
import java.io.File;
import java.util.HashMap;

public final class d {
    public static void d(HashMap<String, Integer> hashMap) {
        for (String str : hashMap.keySet()) {
            ce cN = a.abC().abD().wT().cN(str, " and not ( type = 10000 and isSend != 2 ) ");
            int intValue = ((Integer) hashMap.get(str)).intValue();
            String str2 = cN.field_talker;
            w.i("MicroMsg.TempStorageLogic", "talker:%s, addUnreadCount:%d", new Object[]{str2, Integer.valueOf(intValue)});
            aj Rm = a.abC().abD().wW().Rm(str2);
            if (Rm == null || Rm.field_conversationTime <= cN.field_createTime || Rm.field_conversationTime == Long.MAX_VALUE) {
                int i;
                if (Rm == null) {
                    w.i("MicroMsg.TempStorageLogic", "updateConvFromLastMsg conversation is null.");
                    w.d("MicroMsg.TempStorageLogic", "updateConvFromLastMsg cvs:%s", new Object[]{str2});
                    Rm = new ae(str2);
                    i = 1;
                } else {
                    i = 0;
                }
                Rm.dw(cN.field_isSend);
                Rm.dt(intValue + Rm.field_unReadCount);
                Rm.W(cN);
                Rm.ct(Integer.toString(cN.field_type));
                Rm.t((Rm.field_flag & 4611686018427387904L) | (cN.field_createTime & 72057594037927935L));
                Rm.ds(0);
                if (i != 0) {
                    w.d("MicroMsg.TempStorageLogic", "updateConvFromLastMsg cvs:%s, cvs.flag:%d", new Object[]{str2, Long.valueOf(Rm.field_flag)});
                    a.abC().abD().wW().d(Rm);
                } else {
                    a.abC().abD().wW().a(Rm, str2);
                }
            } else {
                w.i("MicroMsg.TempStorageLogic", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
            }
        }
        a.abC().abD().wW().bLF();
    }

    public static boolean dH(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@chatroom");
    }

    public static long i(au auVar) {
        a Rc = a.abC().abD().wR().Rc(auVar.field_talker);
        if (Rc == null || ((int) Rc.gTQ) == 0) {
            if (!bg.mA(auVar.field_talker)) {
                a.abC().abE().c(2, auVar.field_talker);
                a.abC().abD().wR().R(new x(auVar.field_talker));
            } else if (auVar.field_talker.endsWith("@chatroom")) {
                c abD = a.abC().abD();
                if (abD.uin == 0) {
                    throw new b();
                } else if (abD.jIB.fZ(auVar.field_talker) == null) {
                    a.abC().abE().c(2, auVar.field_talker);
                }
            }
        }
        long L = a.abC().abD().wT().L(auVar);
        if (L < 0) {
            w.e("MicroMsg.TempStorageLogic", "insertMsgWithContact faile: type:%d, talker:%s", new Object[]{Integer.valueOf(auVar.field_type), auVar.field_talker});
        }
        return L;
    }

    public static int gh(String str) {
        if (str == null || str.length() <= 0) {
            return -1;
        }
        int indexOf = str.indexOf(58);
        if (indexOf == -1 || !str.substring(0, indexOf).contains("<")) {
            return indexOf;
        }
        return -1;
    }

    public static r rL(String str) {
        if (bg.mA(str)) {
            return null;
        }
        return a.abC().abD().KV().ls(str);
    }

    public static String rM(String str) {
        c abD = a.abC().abD();
        if (abD.uin == 0) {
            throw new b();
        }
        String a = h.a(abD.gYf + "voice2/", "msg_", str, ".amr", 2);
        if (bg.mA(a)) {
            return null;
        }
        if (new File(a).exists()) {
            return a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        c abD2 = a.abC().abD();
        if (abD2.uin == 0) {
            throw new b();
        }
        String stringBuilder2 = stringBuilder.append(abD2.gYf + "voice/").append(str).toString();
        if (new File(stringBuilder2 + ".amr").exists()) {
            j.p(stringBuilder2 + ".amr", a, true);
            return a;
        } else if (!new File(stringBuilder2).exists()) {
            return a;
        } else {
            j.p(stringBuilder2, a, true);
            return a;
        }
    }
}
