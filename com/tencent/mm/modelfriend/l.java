package com.tencent.mm.modelfriend;

import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.List;

public final class l extends j {
    public static final String[] gUx = new String[]{"CREATE TABLE IF NOT EXISTS friend_ext ( username text  PRIMARY KEY , sex int  , personalcard int  , province text  , city text  , signature text  , reserved1 text  , reserved2 text  , reserved3 text  , reserved4 text  , reserved5 int  , reserved6 int  , reserved7 int  , reserved8 int  ) "};
    private g hnH;

    public l(g gVar) {
        this.hnH = gVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.tencent.mm.modelfriend.k r9) {
        /*
        r8 = this;
        r6 = -1;
        r0 = 1;
        r1 = 0;
        r2 = r9.getUsername();
        r3 = new java.lang.StringBuilder;
        r4 = "select friend_ext.username,friend_ext.sex,friend_ext.personalcard,friend_ext.province,friend_ext.city,friend_ext.signature from friend_ext   where friend_ext.username = \"";
        r3.<init>(r4);
        r2 = com.tencent.mm.sdk.platformtools.bg.my(r2);
        r2 = r3.append(r2);
        r3 = "\"";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r3 = r8.hnH;
        r4 = 0;
        r5 = 2;
        r2 = r3.a(r2, r4, r5);
        r3 = r2.moveToFirst();
        r2.close();
        if (r3 == 0) goto L_0x005a;
    L_0x0033:
        if (r9 == 0) goto L_0x0058;
    L_0x0035:
        r2 = r9.pv();
        r3 = r2.size();
        if (r3 <= 0) goto L_0x0073;
    L_0x003f:
        r3 = r8.hnH;
        r4 = "friend_ext";
        r5 = "username=?";
        r6 = new java.lang.String[r0];
        r7 = "username";
        r6[r1] = r7;
        r2 = r3.update(r4, r2, r5, r6);
    L_0x0052:
        if (r2 <= 0) goto L_0x0058;
    L_0x0054:
        r8.doNotify();
        return r0;
    L_0x0058:
        r0 = r1;
        goto L_0x0054;
    L_0x005a:
        if (r9 == 0) goto L_0x0071;
    L_0x005c:
        r9.fRW = r6;
        r2 = r9.pv();
        r3 = r8.hnH;
        r4 = "friend_ext";
        r5 = "username";
        r2 = r3.insert(r4, r5, r2);
        r2 = (int) r2;
        if (r2 != r6) goto L_0x0054;
    L_0x0071:
        r0 = r1;
        goto L_0x0054;
    L_0x0073:
        r2 = r1;
        goto L_0x0052;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelfriend.l.a(com.tencent.mm.modelfriend.k):boolean");
    }

    public final boolean z(List<k> list) {
        if (list.size() <= 0) {
            return false;
        }
        boolean z;
        be beVar = new be("MicroMsg.FriendExtStorage", "batchSetFriendExt transaction");
        beVar.addSplit("transation begin");
        long cs = this.hnH.cs(Thread.currentThread().getId());
        int i = 0;
        while (i < list.size()) {
            try {
                k kVar = (k) list.get(i);
                if (kVar != null) {
                    a(kVar);
                }
                i++;
            } catch (Exception e) {
                w.e("MicroMsg.FriendExtStorage", e.getMessage());
                z = false;
            }
        }
        z = true;
        this.hnH.aD(cs);
        beVar.addSplit("transation end");
        beVar.dumpToLog();
        doNotify();
        return z;
    }

    public final k jg(String str) {
        k kVar = null;
        Cursor a = this.hnH.a("select friend_ext.username,friend_ext.sex,friend_ext.personalcard,friend_ext.province,friend_ext.city,friend_ext.signature from friend_ext   where friend_ext.username = \"" + bg.my(str) + "\"", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                kVar = new k();
                kVar.username = a.getString(0);
                kVar.gkr = a.getInt(1);
                kVar.gkA = a.getInt(2);
                kVar.gkB = a.getString(3);
                kVar.gkC = a.getString(4);
                kVar.signature = a.getString(5);
            }
            a.close();
        }
        return kVar;
    }
}
