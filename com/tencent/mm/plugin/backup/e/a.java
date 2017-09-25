package com.tencent.mm.plugin.backup.e;

import android.util.Pair;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.backup.a.h;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.eh;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.au;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class a {

    public static class a {
        public static eh a(au auVar, boolean z, String str, PLong pLong, LinkedList<u> linkedList, HashMap<Long, c> hashMap, boolean z2, boolean z3, long j) {
            if (auVar.field_msgSvrId == 0) {
                w.e("MicroMsg.BackupMsgLogic.BackupPackMsgLogic", "msg svr Id == 0" + auVar.field_talker + " " + auVar.field_type);
                return null;
            }
            int i;
            String str2;
            String str3;
            eh ehVar;
            eh ehVar2 = new eh();
            ehVar2.tfk = auVar.field_msgSvrId;
            ehVar2.tfi = "";
            if (auVar.field_isSend == 1) {
                i = 2;
                str2 = auVar.field_talker;
                str3 = str;
                ehVar = ehVar2;
            } else {
                String str4 = auVar.field_talker;
                if (z2) {
                    i = 3;
                    str2 = str;
                    str3 = str4;
                    ehVar = ehVar2;
                } else {
                    i = 4;
                    str2 = str;
                    str3 = str4;
                    ehVar = ehVar2;
                }
            }
            ehVar.tie = i;
            ehVar2.tij = new avw();
            ehVar2.tik = 0;
            ehVar2.til = 0;
            ehVar2.tfi = "";
            ehVar2.tfd = new avx().OV(str3);
            ehVar2.tfe = new avx().OV(str2);
            ehVar2.jOc = l.xb(auVar.field_type);
            ehVar2.tif = (int) (auVar.field_createTime / 1000);
            ehVar2.tim = (int) auVar.field_msgSeq;
            ehVar2.tin = auVar.field_createTime;
            ehVar2.tio = auVar.field_flag;
            avx com_tencent_mm_protocal_c_avx = new avx();
            com_tencent_mm_protocal_c_avx.OV(bg.ap(auVar.field_content, ""));
            ehVar2.tff = com_tencent_mm_protocal_c_avx;
            e jj = h.abc().jj(l.xb(auVar.field_type));
            if (jj == null) {
                w.d("MicroMsg.BackupMsgLogic.BackupPackMsgLogic", "unknow type ");
                return null;
            }
            i = jj.a(ehVar2, z, auVar, str, linkedList, hashMap, z3, j);
            if (i < 0) {
                return null;
            }
            pLong.value += (long) i;
            pLong.value += 60;
            return ehVar2;
        }
    }

    public static class b {
        public static au a(eh ehVar, HashMap<String, Integer> hashMap, HashSet<String> hashSet, HashMap<String, Pair<Long, Long>> hashMap2) {
            String str = (String) com.tencent.mm.plugin.backup.g.a.abC().abD().vr().get(2, null);
            com.tencent.mm.plugin.messenger.foundation.a.a.c wT = com.tencent.mm.plugin.backup.g.a.abC().abD().wT();
            String str2 = ehVar.tfd.tZr;
            Object obj = ehVar.tfe.tZr;
            w.i("MicroMsg.BackupMsgLogic.BackupRecoverMsgLogic", "recoverMsg, type:%d, from:%s, to:%s", new Object[]{Integer.valueOf(ehVar.jOc), str2, obj});
            com.tencent.mm.plugin.backup.g.c abD = com.tencent.mm.plugin.backup.g.a.abC().abD();
            if (abD.uin == 0) {
                throw new com.tencent.mm.u.b();
            }
            Object obj2;
            f fVar = abD.jIA;
            ar wR = com.tencent.mm.plugin.backup.g.a.abC().abD().wR();
            Object obj3 = (fVar.has(str2) || str.equals(str2)) ? 1 : null;
            if (obj3 != null) {
                obj2 = obj;
            } else {
                String str3 = str2;
            }
            long j;
            if (ehVar.tin != 0) {
                j = ehVar.tin;
            } else {
                j = ((long) ehVar.tif) * 1000;
            }
            Pair pair = (Pair) hashMap2.get(obj2);
            if (pair != null && (r8 < ((Long) pair.first).longValue() || r8 > ((Long) pair.second).longValue())) {
                return null;
            }
            if (hashSet != null) {
                hashSet.add(obj2);
            }
            List aap = h.aap();
            if (aap.contains(str2) || aap.contains(obj)) {
                w.w("MicroMsg.BackupMsgLogic.BackupRecoverMsgLogic", "hit the blockList: " + str2 + " " + obj);
                return null;
            } else if (bg.mA(str2) || bg.mA(obj)) {
                w.w("MicroMsg.BackupMsgLogic.BackupRecoverMsgLogic", "form or to convName is null");
                return null;
            } else {
                if (ehVar.tfk == 0 && ehVar.tfc != 0) {
                    ehVar.tfk = (long) ehVar.tfc;
                }
                if (ehVar.tfk != 0) {
                    ce x = wT.x(str.equals(str2) ? obj : str2, ehVar.tfk);
                    if (x.field_msgId != 0) {
                        w.i("MicroMsg.BackupMsgLogic.BackupRecoverMsgLogic", "msg exist");
                        return null;
                    }
                    if (ehVar.tfk != 0) {
                        x.y(ehVar.tfk);
                    }
                    x.B((long) ehVar.tim);
                    if (ehVar.tin != 0) {
                        x.z(ehVar.tin);
                    } else {
                        x.z(((long) ehVar.tif) * 1000);
                    }
                    x.dF(ehVar.tio);
                    x.setType(ehVar.jOc);
                    af Rc;
                    if (obj3 != null) {
                        Rc = wR.Rc(obj);
                        if (Rc == null || bg.mA(Rc.field_username) || !Rc.bLe()) {
                            x.dw(1);
                            x.cH(obj);
                            x.dv(ehVar.tie);
                        } else {
                            w.w("MicroMsg.BackupMsgLogic.BackupRecoverMsgLogic", "hit the blockList: " + obj);
                            return null;
                        }
                    }
                    Rc = wR.Rc(str2);
                    if (Rc == null || bg.mA(Rc.field_username) || !Rc.bLe()) {
                        x.dw(0);
                        x.cH(str2);
                        x.dv(4);
                        if (ehVar.tie == 3) {
                            hashMap.put(str2, Integer.valueOf(bg.a((Integer) hashMap.get(str2), 0) + 1));
                        }
                    } else {
                        w.w("MicroMsg.BackupMsgLogic.BackupRecoverMsgLogic", "hit the blockList: " + str2);
                        return null;
                    }
                    if (obj3 == null) {
                        String str4 = str2;
                    }
                    hashMap.put(obj, Integer.valueOf(bg.a((Integer) hashMap.get(str2), 0)));
                    e jj = h.abc().jj(ehVar.jOc);
                    if (jj == null) {
                        w.i("MicroMsg.BackupMsgLogic.BackupRecoverMsgLogic", "unknow type ");
                        return null;
                    }
                    jj.a(str, ehVar, x);
                    return x;
                }
                w.w("MicroMsg.BackupMsgLogic.BackupRecoverMsgLogic", "drop the item server id < 0");
                return null;
            }
        }
    }

    public static class c {
        public String fFW;
        public u jFG;
        public long jFH;
        public String jFI;
    }
}
