package com.tencent.mm.plugin.v;

import android.database.Cursor;
import com.tencent.mm.a.p;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import com.tencent.mm.plugin.backup.h.k;
import com.tencent.mm.plugin.backup.h.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.c.ei;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

public final class c {
    public boolean nOr = false;
    public com.tencent.mm.plugin.v.a.a nOs;

    public static class a {
        public String jBy;

        public a(String str) {
            this.jBy = str;
        }
    }

    public final void b(final LinkedList<a> linkedList, final long j) {
        e.d(new Runnable(this) {
            final /* synthetic */ c nOv;

            public final void run() {
                long Nz = bg.Nz();
                if (linkedList == null) {
                    w.e("MicroMsg.MsgSynchronizePack", "MsgSynchronizeSessionList is null.");
                    if (this.nOv.nOs != null) {
                        this.nOv.nOs.aaa();
                        return;
                    }
                    return;
                }
                com.tencent.mm.a.e.d(new File(f.aMt()));
                com.tencent.mm.a.e.d(new File(f.aMu()));
                f.aMv();
                LinkedList linkedList = new LinkedList();
                String str = (String) com.tencent.mm.plugin.backup.g.a.abC().abD().vr().get(2, null);
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                PLong pLong = new PLong();
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    aj Rm = com.tencent.mm.plugin.backup.g.a.abC().abD().wW().Rm(aVar.jBy);
                    int i = Rm != null ? Rm.field_unReadCount : 0;
                    if (pInt2.value >= b.nOp) {
                        break;
                    }
                    k kVar = new k();
                    kVar.jNj = aVar.jBy;
                    kVar.jNh = (int) (com.tencent.mm.plugin.backup.g.a.abC().abD().wT().AD(aVar.jBy) / 1000);
                    kVar.jNi = i;
                    linkedList.add(kVar);
                    pInt2.value++;
                    if (pInt.value < b.nOn) {
                        this.nOv.a(aVar, str, i, pInt, pLong, j);
                    }
                    if (this.nOv.nOr) {
                        break;
                    }
                }
                if (this.nOv.nOr) {
                    w.e("MicroMsg.MsgSynchronizePack", "MsgSynchronizePack canceled!");
                    return;
                }
                String str2;
                l lVar = new l();
                lVar.jNk = linkedList;
                lVar.jNl = com.tencent.mm.av.l.Ky().Km();
                try {
                    f.d(f.aMs(), "sessionlist", lVar.toByteArray());
                    w.i("MicroMsg.MsgSynchronizePack", "BackupSessionInfoList pack finish.");
                } catch (Exception e) {
                    w.e("MicroMsg.MsgSynchronizePack", "ERROR: BackupSessionInfoList to Buffer, list:%d :%s", new Object[]{Integer.valueOf(lVar.jNk.size()), e.getMessage()});
                }
                p.a(new File(f.aMt()), false, f.aMu());
                Boolean bool = com.tencent.mm.plugin.backup.g.a.abC().abD().jIK;
                String str3 = "MicroMsg.MsgSynchronizePack";
                String str4 = "synchronize finish, backupCostTime:%d, isTempDb[%s]";
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(bg.aA(Nz));
                if (bool == null) {
                    str2 = "null";
                } else {
                    Object obj = bool;
                }
                objArr[1] = str2;
                w.i(str3, str4, objArr);
                if (bool != null) {
                    com.tencent.mm.plugin.backup.g.a.abC().o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 nOw;

                        {
                            this.nOw = r1;
                        }

                        public final void run() {
                            w.i("MicroMsg.MsgSynchronizePack", "closeTempDB end");
                            w.bIP();
                        }
                    });
                }
                long aN = (long) com.tencent.mm.a.e.aN(f.aMu());
                if (this.nOv.nOs != null) {
                    this.nOv.nOs.a(f.aMu(), linkedList.size(), str, pInt.value, pLong.value, aN / AppSupportContentFlag.MMAPP_SUPPORT_XLS);
                }
            }
        }, "msgSynchronizePackThread", 10).start();
    }

    public final boolean a(a aVar, String str, int i, PInt pInt, PLong pLong, long j) {
        ap.yY();
        if (x.yC(com.tencent.mm.u.c.wR().Rc(aVar.jBy).field_verifyFlag)) {
            return true;
        }
        w.i("MicroMsg.MsgSynchronizePack", "summerbak backupChatMsg convName:%s, unReadCount:%d", new Object[]{aVar.jBy, Integer.valueOf(i)});
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        Cursor bj = com.tencent.mm.plugin.backup.g.a.abC().abD().wT().bj(aVar.jBy, b.nOo);
        while (bj.moveToNext()) {
            if (this.nOr) {
                bj.close();
                return false;
            }
            ce auVar = new au();
            auVar.b(bj);
            if ((j >= 0 && auVar.field_createTime >= j) || j < 0) {
                linkedList2.add(auVar);
            }
        }
        bj.close();
        int i2 = 0;
        int i3 = i;
        while (i2 < linkedList2.size()) {
            Object a;
            int i4;
            try {
                a = com.tencent.mm.plugin.backup.e.a.a.a((au) linkedList2.get(i2), false, str, new PLong(), new LinkedList(), null, i3 > 0, true, 0);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.MsgSynchronizePack", e, "backupChatMsg", new Object[0]);
                a = null;
            }
            if (a != null) {
                linkedList.add(a);
                pLong.value++;
                i4 = i3 - 1;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        ei eiVar = new ei();
        eiVar.jNe = linkedList;
        eiVar.jNd = linkedList.size();
        try {
            f.d(f.aMs(), "MSG_" + linkedList.size() + "_" + aVar.jBy + "_" + bg.Nz(), eiVar.toByteArray());
            w.i("MicroMsg.MsgSynchronizePack", "add MsgSynchronize, tagTextClientId:%s", new Object[]{r4});
        } catch (Exception e2) {
            w.e("MicroMsg.MsgSynchronizePack", "ERROR: BakChatMsgList to Buffer list:%d :%s", new Object[]{Integer.valueOf(eiVar.jNd), e2.getMessage()});
        }
        pInt.value++;
        return true;
    }
}
