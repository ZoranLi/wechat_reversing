package com.tencent.mm.plugin.ipcall;

import com.tencent.mm.e.a.hg;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Iterator;

public final class a implements e {
    private static a mMk = null;
    boolean hpL = false;
    public long mMg = -1;
    private long mMh = -1;
    long mMi = -1;
    long mMj = -1;

    private a() {
    }

    public static a aDw() {
        if (mMk == null) {
            mMk = new a();
        }
        return mMk;
    }

    public final void Ni() {
        if (!com.tencent.mm.plugin.ipcall.b.a.Fo()) {
            w.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, can't sync addr book");
        }
        if (this.hpL) {
            w.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, updating");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ap.yY();
        if (Math.abs(currentTimeMillis - ((Long) c.vr().get(com.tencent.mm.storage.w.a.uBB, Long.valueOf(0))).longValue()) >= 86400000) {
            this.hpL = true;
            this.mMg = -1;
            this.mMh = -1;
            this.mMi = -1;
            this.mMj = -1;
            ap.vd().a(32, this);
            com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                final /* synthetic */ a mMl;

                {
                    this.mMl = r1;
                }

                public final void run() {
                    w.d("MicroMsg.IPCallAddressBookUsernameUpdater", "start GetMFriend");
                    b hgVar = new hg();
                    hgVar.fMH.scene = 2;
                    com.tencent.mm.sdk.b.a.urY.m(hgVar);
                    this.mMl.mMg = System.currentTimeMillis();
                }
            }, "IPCallAddressBookUpdater_updateUsername");
            return;
        }
        w.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, not reach time limit");
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.IPCallAddressBookUsernameUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.hpL)});
        if (this.hpL) {
            ap.vd().b(32, this);
            this.mMh = System.currentTimeMillis();
            w.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend used %dms", new Object[]{Long.valueOf(this.mMh - this.mMg)});
            if (i == 0 && i2 == 0) {
                com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                    final /* synthetic */ a mMl;

                    {
                        this.mMl = r1;
                    }

                    public final void run() {
                        a aVar = this.mMl;
                        w.d("MicroMsg.IPCallAddressBookUsernameUpdater", "updateUsernameAfterGetMFriend");
                        aVar.mMi = System.currentTimeMillis();
                        ArrayList aEP = i.aEn().aEP();
                        if (aEP != null && aEP.size() > 0) {
                            w.d("MicroMsg.IPCallAddressBookUsernameUpdater", "addressitemList.size: %d", new Object[]{Integer.valueOf(aEP.size())});
                            long cs = i.aEn().cs(Thread.currentThread().getId());
                            Iterator it = aEP.iterator();
                            while (it.hasNext()) {
                                com.tencent.mm.plugin.ipcall.a.g.c cVar = (com.tencent.mm.plugin.ipcall.a.g.c) it.next();
                                String yQ = com.tencent.mm.plugin.ipcall.b.a.yQ(cVar.field_contactId);
                                if (cVar.uxb > 0 && !bg.mA(yQ)) {
                                    w.d("MicroMsg.IPCallAddressBookUsernameUpdater", "update username for contactId: %s, newUsername: %s, oldUsername: %s", new Object[]{cVar.field_contactId, yQ, cVar.field_wechatUsername});
                                    if ((!bg.mA(cVar.field_wechatUsername) && !cVar.field_wechatUsername.equals(yQ)) || bg.mA(cVar.field_wechatUsername)) {
                                        cVar.field_wechatUsername = yQ;
                                        i.aEn().a(cVar.uxb, cVar);
                                    }
                                }
                            }
                            i.aEn().ct(cs);
                        }
                        aVar.mMj = System.currentTimeMillis();
                        w.d("MicroMsg.IPCallAddressBookUsernameUpdater", "update username use %dms", new Object[]{Long.valueOf(aVar.mMj - aVar.mMi)});
                        aVar.hpL = false;
                        a.aDx();
                    }
                }, "IPCallAddressBookUsernameUpdater_updateUsernameAfterGetMFriend");
                return;
            }
            w.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend failed");
            this.hpL = false;
            aDx();
        }
    }

    static void aDx() {
        long currentTimeMillis = System.currentTimeMillis();
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uBB, Long.valueOf(currentTimeMillis));
    }
}
