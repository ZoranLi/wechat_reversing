package com.tencent.mm.plugin.emoji.sync;

import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.emoji.sync.b.b;
import com.tencent.mm.plugin.emoji.sync.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public final class a<T extends d> {
    public BKGLoaderManager kNA;

    public enum a {
        Default,
        Syncing,
        PauseSync,
        PauseSyncOffline,
        PauseSyncSDCardFull,
        FinishSync
    }

    public a() {
        com.tencent.mm.plugin.emoji.sync.b.a aVar = new com.tencent.mm.plugin.emoji.sync.b.a();
        aVar.kNK = new b(aVar.kNI, aVar.kNI, TimeUnit.MILLISECONDS, new com.tencent.mm.ah.a.e.a(), new c(aVar.hIq, "bkg_loader_"));
        a(new b(aVar));
    }

    private synchronized void a(b bVar) {
        if (this.kNA == null) {
            this.kNA = new BKGLoaderManager(bVar);
        } else {
            w.i("MicroMsg.BKGLoader.BKGLoader", "[cpan] BKGLoader had init.");
        }
    }

    public final void v(ArrayList<d> arrayList) {
        BKGLoaderManager bKGLoaderManager = this.kNA;
        bKGLoaderManager.kNN = false;
        if (bKGLoaderManager.kNX == null) {
            bKGLoaderManager.kNX = new Vector();
        }
        if (arrayList.size() > 0) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                d dVar = (d) arrayList.get(i);
                if (dVar == null || bKGLoaderManager.kNX.contains(dVar)) {
                    w.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist.:%s", new Object[]{dVar.getKey()});
                } else {
                    bKGLoaderManager.kNX.add(dVar);
                }
            }
        }
    }

    public final void w(ArrayList<d> arrayList) {
        BKGLoaderManager bKGLoaderManager = this.kNA;
        if (bKGLoaderManager.kNZ == null) {
            bKGLoaderManager.kNZ = new Vector();
        }
        if (arrayList.size() > 0) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                d dVar = (d) arrayList.get(i);
                String str;
                String str2;
                Object[] objArr;
                if (bKGLoaderManager.kNV != null && bKGLoaderManager.kNV.equals(dVar)) {
                    str = "MicroMsg.BKGLoader.BKGLoaderManager";
                    str2 = "[cpan] currentTask equals task is has exist:%s";
                    objArr = new Object[1];
                    objArr[0] = dVar == null ? "task is null" : dVar.getKey();
                    w.i(str, str2, objArr);
                } else if (dVar == null || bKGLoaderManager.kNZ.contains(dVar)) {
                    str = "MicroMsg.BKGLoader.BKGLoaderManager";
                    str2 = "[cpan] task is has exist:%s";
                    objArr = new Object[1];
                    objArr[0] = dVar == null ? "task is null" : dVar.getKey();
                    w.i(str, str2, objArr);
                } else {
                    bKGLoaderManager.kNZ.add(dVar);
                }
            }
        }
    }

    public final a amw() {
        BKGLoaderManager bKGLoaderManager = this.kNA;
        if (bKGLoaderManager.kNO && bKGLoaderManager.kNT) {
            return a.PauseSyncSDCardFull;
        }
        if (BKGLoaderManager.alx() && !bKGLoaderManager.kNO && h.amc().kLa.bNC() > 0) {
            return a.PauseSync;
        }
        if (!am.isConnected(ab.getContext()) && !bKGLoaderManager.kNO && h.amc().kLa.bNC() > 0) {
            return a.PauseSyncOffline;
        }
        if (am.isConnected(ab.getContext())) {
            if (bKGLoaderManager.kNO && bKGLoaderManager.kNU) {
                return a.Syncing;
            }
            if (bKGLoaderManager.kNR) {
                return a.FinishSync;
            }
        }
        return a.Default;
    }

    public final void ds(boolean z) {
        this.kNA.kNU = z;
    }
}
