package com.tencent.mm.plugin.ipcall.a;

import android.database.Cursor;
import com.tencent.mm.e.a.hx;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class b {
    private static c mMC = new c<hx>() {
        {
            this.usg = hx.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (((hx) bVar) instanceof hx) {
                e.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 mMD;

                    {
                        this.mMD = r1;
                    }

                    public final void run() {
                        b.aDS();
                    }
                }, "IPCall_SyncAddressBook");
            }
            return false;
        }
    };

    public static void init() {
        a.urY.b(mMC);
    }

    public static void release() {
        a.urY.c(mMC);
    }

    public static void aDS() {
        try {
            if (ap.zb()) {
                w.d("MicroMsg.IPCallAddressUpdater", "start updateAddressStorage");
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.mm.plugin.ipcall.a.g.b bVar = new com.tencent.mm.plugin.ipcall.a.g.b();
                ArrayList aEP = i.aEn().aEP();
                if (aEP != null && aEP.size() > 0) {
                    HashMap aEO = com.tencent.mm.plugin.ipcall.a.g.b.aEO();
                    if (aEO != null && aEO.size() >= 0) {
                        com.tencent.mm.plugin.ipcall.a.g.c cVar;
                        long cs = i.aEn().cs(Thread.currentThread().getId());
                        w.d("MicroMsg.IPCallAddressUpdater", "start delete not exist address");
                        w.d("MicroMsg.IPCallAddressUpdater", "oldItemList.size: %d", new Object[]{Integer.valueOf(aEP.size())});
                        Iterator it = aEP.iterator();
                        while (it.hasNext()) {
                            cVar = (com.tencent.mm.plugin.ipcall.a.g.c) it.next();
                            if (!aEO.containsKey(cVar.field_contactId)) {
                                long j = cVar.uxb;
                                i.aEn().delete(j);
                                w.d("MicroMsg.IPCallAddressUpdater", "updateDeleteAddressRecord, id: %d", new Object[]{Long.valueOf(j)});
                                Cursor cu = i.aEo().cu(j);
                                if (cu != null) {
                                    try {
                                        if (cu.moveToFirst()) {
                                            while (!cu.isAfterLast()) {
                                                k kVar = new k();
                                                kVar.b(cu);
                                                kVar.field_addressId = -1;
                                                kVar.field_phoneType = -1;
                                                i.aEo().a(kVar);
                                                cu.moveToNext();
                                            }
                                        }
                                    } catch (Exception e) {
                                        w.e("MicroMsg.IPCallAddressUpdater", "updateDeleteAddressRecord error: %s", new Object[]{e.getMessage()});
                                        if (cu != null) {
                                            cu.close();
                                        } else {
                                            continue;
                                        }
                                    } catch (Throwable th) {
                                        if (cu != null) {
                                            cu.close();
                                        }
                                    }
                                }
                                if (cu != null) {
                                    cu.close();
                                } else {
                                    continue;
                                }
                            }
                        }
                        w.d("MicroMsg.IPCallAddressUpdater", "start update or insert address");
                        for (com.tencent.mm.plugin.ipcall.a.g.c cVar2 : aEO.values()) {
                            com.tencent.mm.plugin.ipcall.a.g.c yt = i.aEn().yt(cVar2.field_contactId);
                            if (yt == null || yt.uxb == -1) {
                                i.aEn().b(cVar2);
                            } else {
                                Object obj = (cVar2 != null && com.tencent.mm.plugin.ipcall.a.g.c.cx(yt.field_contactId, cVar2.field_contactId) && com.tencent.mm.plugin.ipcall.a.g.c.cx(yt.field_systemAddressBookUsername, cVar2.field_systemAddressBookUsername) && com.tencent.mm.plugin.ipcall.a.g.c.cx(yt.field_wechatUsername, cVar2.field_wechatUsername)) ? 1 : null;
                                if (obj == null) {
                                    i.aEn().a(yt.uxb, cVar2);
                                }
                            }
                        }
                        i.aEn().ct(cs);
                        w.d("MicroMsg.IPCallAddressUpdater", "updateAddressStorage, used %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        return;
                    }
                    return;
                }
                return;
            }
            w.e("MicroMsg.IPCallAddressUpdater", "updateAddressStorage, acc not ready");
        } catch (Exception e2) {
            w.e("MicroMsg.IPCallAddressUpdater", "updateAddressStorage error:" + e2.getMessage());
        }
    }
}
