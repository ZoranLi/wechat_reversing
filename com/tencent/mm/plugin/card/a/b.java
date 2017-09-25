package com.tencent.mm.plugin.card.a;

import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.aj;
import com.tencent.mm.plugin.card.model.ak;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.model.s;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b implements e {
    public byte[] hAl = new byte[0];
    public List<aj> kcF = al.agb().afX();
    public List<aj> kcG = new ArrayList();
    private s kcH;
    public List<WeakReference<d>> kcI = new ArrayList();

    public b() {
        w.i("MicroMsg.BatchGetCardMgr", "<init>, init pending list size = %d", new Object[]{Integer.valueOf(this.kcF.size())});
        ap.vd().a(559, this);
    }

    public final void detach() {
        this.kcF.clear();
        this.kcG.clear();
        if (this.kcH != null) {
            ap.vd().c(this.kcH);
        }
        ap.vd().b(559, this);
    }

    public final void afv() {
        if (this.kcF.size() == 0) {
            w.i("MicroMsg.BatchGetCardMgr", "getNow, no pending cardinfo ,no need to get");
        } else if (this.kcH != null) {
            w.i("MicroMsg.BatchGetCardMgr", "getNow, already doing scene, not trigger now");
        } else {
            LinkedList linkedList = new LinkedList();
            if (this.kcF.size() <= 10) {
                linkedList.addAll(this.kcF);
            } else {
                linkedList.addAll(this.kcF.subList(0, 10));
            }
            this.kcH = new s(linkedList);
            ap.vd().a(this.kcH, 0);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 0;
        w.i("MicroMsg.BatchGetCardMgr", "onSceneEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.kcH = null;
        List<aj> list = ((s) kVar).kfM;
        ak agb;
        if (i == 0 && i2 == 0) {
            String str2 = "MicroMsg.BatchGetCardMgr";
            String str3 = "onSceneEnd, batch get succ, remove succ id list, size = %d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
            w.i(str2, str3, objArr);
            if (list != null) {
                synchronized (this.hAl) {
                    this.kcF.removeAll(list);
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            ap.yY();
            long cs = c.wO().cs(Thread.currentThread().getId());
            agb = al.agb();
            if (list == null || list.size() == 0) {
                w.e("MicroMsg.PendingCardIdInfoStorage", "deleteList fail, list is empty");
            } else {
                for (aj ajVar : list) {
                    if (ajVar != null) {
                        agb.a(ajVar, new String[0]);
                    }
                }
            }
            ap.yY();
            c.wO().aD(cs);
            w.i("MicroMsg.BatchGetCardMgr", "onSceneEnd do transaction use time %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            afv();
            if (this.kcI != null) {
                while (i3 < this.kcI.size()) {
                    WeakReference weakReference = (WeakReference) this.kcI.get(i3);
                    if (weakReference != null) {
                        d dVar = (d) weakReference.get();
                        if (dVar != null) {
                            dVar.aft();
                        }
                    }
                    i3++;
                }
                return;
            }
            return;
        }
        w.e("MicroMsg.BatchGetCardMgr", "onSceneEnd fail, stop batch get, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        synchronized (this.hAl) {
            if (list != null) {
                if (list.size() > 0) {
                    this.kcF.removeAll(list);
                    this.kcG.addAll(list);
                }
            }
        }
        agb = al.agb();
        if (list == null || list.size() == 0) {
            w.e("MicroMsg.PendingCardIdInfoStorage", "increaseRetryCount fail, list is empty");
            return;
        }
        for (aj ajVar2 : list) {
            if (ajVar2 != null) {
                ajVar2.field_retryCount++;
                agb.c(ajVar2, new String[0]);
            }
        }
    }

    public static void kn(int i) {
        ap.vd().a(new com.tencent.mm.plugin.card.model.w(i), 0);
    }
}
