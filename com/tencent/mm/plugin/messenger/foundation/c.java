package com.tencent.mm.plugin.messenger.foundation;

import android.database.Cursor;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.protocal.c.lu;
import com.tencent.mm.protocal.c.nh;
import com.tencent.mm.protocal.c.nn;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.b;
import java.util.List;

public final class c implements p {
    public final void a(lu luVar, byte[] bArr, boolean z, r rVar) {
        int i;
        switch (luVar.tsa) {
            case 5:
                bu buVar = (bu) new bu().aD(bArr);
                if (buVar != null) {
                    a(new a(buVar, false, false, false), rVar);
                    return;
                }
                return;
            case 8:
                nh nhVar = (nh) new nh().aD(bArr);
                String a = n.a(nhVar.ttp);
                i = nhVar.ttt;
                Cursor bi = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().bi(a, i);
                if (bi.moveToFirst()) {
                    while (!bi.isAfterLast()) {
                        au auVar = new au();
                        auVar.b(bi);
                        ay.j(auVar);
                        bi.moveToNext();
                    }
                }
                bi.close();
                ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().bh(a, i);
                return;
            case 9:
                nn nnVar = (nn) new nn().aD(bArr);
                List list = nnVar.ttw;
                for (i = 0; i < list.size(); i++) {
                    ay.j(n.a(nnVar.ttp), (long) ((Integer) list.get(i)).intValue());
                }
                return;
            default:
                return;
        }
    }

    public static void a(a aVar, r rVar) {
        com.tencent.mm.bd.a aVar2 = aVar.hst;
        if (10008 == com.tencent.mm.platformtools.r.iiW && com.tencent.mm.platformtools.r.iiX != 0) {
            w.i("MicroMsg.MessageSyncExtension", "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(aVar2.tfk), Integer.valueOf(com.tencent.mm.platformtools.r.iiX));
            aVar2.tfk = Long.valueOf((long) com.tencent.mm.platformtools.r.iiX).longValue();
            com.tencent.mm.platformtools.r.iiX = 0;
        }
        if (((h) com.tencent.mm.kernel.h.h(h.class)).aJX().cC(aVar2.tfk)) {
            w.i("MicroMsg.MessageSyncExtension", "ignore, because reSync the deleted msg perhaps the IDC has change has swtiched");
            return;
        }
        String a = n.a(aVar2.tfd);
        String a2 = n.a(aVar2.tfe);
        if (a.equals(m.xL()) && a2.equals("newsapp") && aVar2.mtd != 51) {
            w.w("MicroMsg.MessageSyncExtension", "msgid:%d type:%d this fucking msg from mac weixin ,someone send msg to newsapp at mac weixin ,givp up.", Long.valueOf(aVar2.tfk), Integer.valueOf(aVar2.mtd));
            return;
        }
        int i;
        String str = "MicroMsg.MessageSyncExtension";
        String str2 = "dkAddMsg from:%s to:%s id:[%d,%d] status:%d type:%d time:[%d %s] diff:%d imgstatus:%d imgbuf:%d src:%d push:%d content:%s";
        Object[] objArr = new Object[14];
        objArr[0] = a;
        objArr[1] = a2;
        objArr[2] = Long.valueOf(aVar2.tfk);
        objArr[3] = Integer.valueOf(aVar2.tfc);
        objArr[4] = Integer.valueOf(aVar2.jNB);
        objArr[5] = Integer.valueOf(aVar2.mtd);
        objArr[6] = Integer.valueOf(aVar2.ogM);
        objArr[7] = bg.ev((long) aVar2.ogM);
        objArr[8] = Long.valueOf(bg.Ny() - ((long) aVar2.ogM));
        objArr[9] = Integer.valueOf(aVar2.tfg);
        objArr[10] = Integer.valueOf(n.a(aVar2.tfh, new byte[0]).length);
        objArr[11] = Integer.valueOf(bg.mz(aVar2.tfi).length());
        objArr[12] = Integer.valueOf(bg.mz(aVar2.tfj).length());
        avx com_tencent_mm_protocal_c_avx = aVar2.tff;
        a2 = "";
        if (com_tencent_mm_protocal_c_avx != null) {
            a2 = com_tencent_mm_protocal_c_avx.tZr;
        }
        objArr[13] = bg.Qj(a2);
        w.i(str, str2, objArr);
        w.i("MicroMsg.MessageSyncExtension", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", aVar2.tfi, "");
        s.d(aVar2);
        if (a.equals("readerapp")) {
            aVar2.tfd = n.mw("newsapp");
            aVar2.mtd = 12399999;
        }
        if ((a.equals("blogapp") || a.equals("newsapp")) && aVar2.mtd != CdnLogic.MediaType_FAVORITE_VIDEO) {
            aVar2.mtd = 12399999;
        }
        if (aVar2.mtd == 52) {
            aVar2.mtd = 1000052;
        }
        if (aVar2.mtd == 53) {
            aVar2.mtd = 1000053;
        }
        if (!(aVar == null || aVar.hst == null)) {
            bu buVar = aVar.hst;
            au x = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().x(n.a(buVar.tfd), buVar.tfk);
            if (x.field_msgId != 0 && (x.field_isSend == 0 || buVar.tfl != 0)) {
                i = x.field_flag;
                i = aVar.hsu ? i | 2 : i & -3;
                i = aVar.hsv ? i | 1 : i & -2;
                i = aVar.hsw ? i | 4 : i & -5;
                if (i != x.field_flag) {
                    w.i("MicroMsg.MsgInfoStorageLogic", "summerbadcr updateMsgFlagByAddMsgInfo msgType[%d], flag new[%d], old[%d]", Integer.valueOf(buVar.mtd), Integer.valueOf(i), Integer.valueOf(x.field_flag));
                    x.dF(i);
                    ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().b(x.field_msgSvrId, x);
                }
            }
        }
        Object obj = null;
        d aB = com.tencent.mm.y.d.c.aB(Integer.valueOf(aVar2.mtd));
        if (aB == null) {
            aB = com.tencent.mm.y.d.c.aB(a);
        }
        if (aB != null) {
            b b = aB.b(aVar);
            ce ceVar = b == null ? null : b.fCZ;
            if (ceVar == null) {
                w.w("MicroMsg.MessageSyncExtension", "summerbadcr extension declared but skipped msg, type=%d, svrId=%d, MsgSeq=%d, createTime=%d, addMsgInfo=%s", Integer.valueOf(aVar2.mtd), Long.valueOf(aVar2.tfk), Integer.valueOf(aVar2.tfl), Integer.valueOf(aVar2.ogM), aVar);
                if (aVar.hsu && aVar.hsv) {
                    au I = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().I(a, (long) aVar2.tfl);
                    if (I == null || I.field_msgId == 0) {
                        a = "MicroMsg.MessageSyncExtension";
                        str2 = "summerbadcr extension declared but skipped msg and must revised fault id failed[%d]";
                        objArr = new Object[1];
                        objArr[0] = Long.valueOf(I != null ? I.field_msgId : -1);
                        w.i(a, str2, objArr);
                    } else {
                        i = I.field_flag;
                        w.i("MicroMsg.MessageSyncExtension", "summerbadcr extension declared but skipped msg and must revised fault id[%d], flag[%d], svrId[%d], msgseq[%d], createtime[%d], type[%d]", Long.valueOf(I.field_msgId), Integer.valueOf(I.field_flag), Long.valueOf(I.field_msgSvrId), Long.valueOf(I.field_msgSeq), Long.valueOf(I.field_createTime), Integer.valueOf(I.field_type));
                        I.dF((i | 2) | 1);
                        ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().a(I.field_msgId, I);
                    }
                }
                obj = 1;
            } else {
                obj = (!o.eZ(a) || com.tencent.mm.ai.b.Hp()) ? null : 1;
                if (obj == null) {
                    w.d("MicroMsg.MessageSyncExtension", " msg , id =" + ceVar.field_msgId + "  " + rVar);
                    if (ceVar.field_msgId > 0 && rVar != null && b.hsx) {
                        rVar.a(ceVar, aVar2);
                    }
                }
                obj = 1;
            }
        }
        s.a(5, aVar2);
        if (obj == null) {
            w.f("MicroMsg.MessageSyncExtension", "unknown add msg request, type=%d. drop now !!!", Integer.valueOf(aVar2.mtd));
        }
    }
}
