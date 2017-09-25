package com.tencent.mm.plugin.fts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.mm.e.a.bv;
import com.tencent.mm.e.a.e;
import com.tencent.mm.e.a.ra;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.e.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.fts.a.g;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.LinkedList;

public class PluginFTS extends d implements c, l {
    public static boolean lYE;
    public boolean lYA = false;
    public boolean lYB = false;
    private Runnable lYC = new Runnable(this) {
        final /* synthetic */ PluginFTS lYO;

        {
            this.lYO = r1;
        }

        public final void run() {
            if (this.lYO.lYx != null) {
                this.lYO.lYx.rollback();
            }
        }
    };
    private d lYD = new d(this) {
        final /* synthetic */ PluginFTS lYO;

        {
            this.lYO = r1;
        }

        public final void axC() {
            h.vJ();
            int intValue = ((Integer) h.vI().vr().get(com.tencent.mm.storage.w.a.uIk, Integer.valueOf(3))).intValue();
            w.e("MicroMsg.FTS.PluginFTS", "DB onCorrupt dbCorruptRebuildTimes: %d", new Object[]{Integer.valueOf(intValue)});
            if (intValue > 0) {
                intValue--;
                h.vJ();
                h.vI().vr().a(com.tencent.mm.storage.w.a.uIk, Integer.valueOf(intValue));
                this.lYO.destroyNativeLogic();
                this.lYO.destroyStorage();
                this.lYO.lYx.close();
                c.axB();
                this.lYO.lYw.a(-131072, new a(this.lYO));
            }
        }
    };
    private com.tencent.mm.u.br.a lYF = new com.tencent.mm.u.br.a(this) {
        final /* synthetic */ PluginFTS lYO;

        {
            this.lYO = r1;
        }

        public final boolean Aa() {
            w.w("MicroMsg.FTS.PluginFTS", "HERE UninitForUEH is called! stg:%s ", new Object[]{this.lYO.lYx});
            PluginFTS.lYE = true;
            if (this.lYO.lYx != null) {
                this.lYO.lYx.rollback();
                this.lYO.lYx.close();
            }
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c lYG = new com.tencent.mm.sdk.b.c<bv>(this) {
        final /* synthetic */ PluginFTS lYO;

        {
            this.lYO = r2;
            this.usg = bv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (((bv) bVar) instanceof bv) {
                this.lYO.lYG.dead();
                this.lYO.lYz = true;
                w.i("MicroMsg.FTS.PluginFTS", "All account post reset");
                this.lYO.waitAndStartDaemon();
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c lYH = new com.tencent.mm.sdk.b.c<e>(this) {
        final /* synthetic */ PluginFTS lYO;

        {
            this.lYO = r2;
            this.usg = e.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            e eVar = (e) bVar;
            f fVar = this.lYO.lYw;
            boolean z = eVar.fCm.fCn;
            if (fVar.lYm != null) {
                fVar.lYm.eq(z);
            }
            this.lYO.lYB = !eVar.fCm.fCn;
            return false;
        }
    };
    public com.tencent.mm.y.e lYI = new com.tencent.mm.y.e(this) {
        final /* synthetic */ PluginFTS lYO;

        {
            this.lYO = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            h.vJ();
            if (bg.f((Integer) h.vI().vr().get(15, null)) != 0) {
                h.vd().b(138, this.lYO.lYI);
                this.lYO.lYy = true;
                w.i("MicroMsg.FTS.PluginFTS", "*** User has finished initializing.");
                this.lYO.waitAndStartDaemon();
            }
        }
    };
    private com.tencent.mm.sdk.b.c lYJ = new com.tencent.mm.sdk.b.c<ra>(this) {
        final /* synthetic */ PluginFTS lYO;

        {
            this.lYO = r2;
            this.usg = ra.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            this.lYO.lYw.a(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, new com.tencent.mm.plugin.fts.a.a.a(this) {
                String lYP = "";
                final /* synthetic */ AnonymousClass7 lYQ;

                {
                    this.lYQ = r2;
                }

                public final boolean execute() {
                    this.lYP = v.ea(ab.getContext());
                    this.lYQ.lYO.lYx.i(-3, (long) this.lYP.hashCode());
                    return true;
                }

                public final String toString() {
                    return "LanguageUpdate(\"" + this.lYP + "\")";
                }
            });
            return false;
        }
    };
    private BroadcastReceiver lYK = new BroadcastReceiver(this) {
        final /* synthetic */ PluginFTS lYO;

        {
            this.lYO = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null) {
                w.i("MicroMsg.FTS.PluginFTS", "*** Charging notified: " + intent.getAction());
                if (intent.getAction().equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                    this.lYO.lYA = true;
                } else if (intent.getAction().equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                    this.lYO.lYA = false;
                }
            }
        }
    };
    private SparseArray<g> lYL = new SparseArray();
    private e lYM;
    private SparseArray<i> lYN = new SparseArray();
    public f lYw;
    public c lYx;
    public boolean lYy = false;
    public boolean lYz = false;

    private class a extends com.tencent.mm.plugin.fts.a.a.a {
        final /* synthetic */ PluginFTS lYO;

        public a(PluginFTS pluginFTS) {
            this.lYO = pluginFTS;
        }

        public final boolean execute() {
            h.vJ();
            if (2 != ((Integer) h.vI().vr().get(com.tencent.mm.storage.w.a.uIi, Integer.valueOf(0))).intValue()) {
                c.axB();
                h.vJ();
                h.vI().vr().a(com.tencent.mm.storage.w.a.uIi, Integer.valueOf(2));
                h.vJ();
                h.vI().vr().a(com.tencent.mm.storage.w.a.uIj, Integer.valueOf(0));
            }
            h.vJ();
            File file = new File(h.vI().cachePath, "IndexMicroMsg.db");
            if (file.exists()) {
                file.delete();
            }
            try {
                PluginFTS pluginFTS = this.lYO;
                h.vJ();
                pluginFTS.lYx = new c(h.vI().cachePath);
                this.lYO.registerStorage();
                this.lYO.createIndexStorage();
                this.lYO.registerSearchLogic();
                this.lYO.createNativeLogic();
            } catch (Throwable e) {
                if (!PluginFTS.lYE) {
                    w.printErrStackTrace("MicroMsg.FTS.PluginFTS", e, "Index database corruption detected", new Object[0]);
                    com.tencent.mm.plugin.fts.a.e.mQ(19);
                    this.lYO.destroyNativeLogic();
                    this.lYO.destroyStorage();
                    this.lYO.lYx.close();
                    c.axB();
                    com.tencent.mm.plugin.report.service.g.oUh.d("FTS", "InitSearchTask: " + Log.getStackTraceString(e), null);
                }
            }
            return true;
        }

        public final String getName() {
            return "InitSearchTask";
        }
    }

    private class b extends com.tencent.mm.plugin.fts.a.a.a {
        final /* synthetic */ PluginFTS lYO;

        public b(PluginFTS pluginFTS) {
            this.lYO = pluginFTS;
        }

        public final boolean execute() {
            InputStream inputStream = null;
            try {
                inputStream = ab.getContext().getAssets().open("t2sCH.txt");
                String[] split = new String(com.tencent.mm.loader.stub.b.c(inputStream)).split(",");
                for (int i = 0; i + 1 < split.length; i += 2) {
                    SpellMap.iig.put(split[i], split[i + 1]);
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.FTS.PluginFTS", e, e.getMessage(), new Object[0]);
            } finally {
                com.tencent.mm.a.e.b(inputStream);
            }
            return true;
        }

        public final String getName() {
            return "InitT2SCHTask";
        }

        public final String toString() {
            return String.format("InitT2SCHTask size: %d", new Object[]{Integer.valueOf(SpellMap.iig.size())});
        }
    }

    public void installed() {
        alias(l.class);
    }

    public void dependency() {
        dependsOn(com.tencent.mm.plugin.zero.a.d.class);
    }

    public boolean isCharging() {
        return this.lYA;
    }

    public boolean isInBackground() {
        return this.lYB;
    }

    public void onAccountInitialized(f fVar) {
        boolean z = false;
        File file = new File(com.tencent.mm.plugin.fts.a.c.lZw);
        if (!file.exists()) {
            file.mkdir();
        }
        if (this.lYw != null) {
            this.lYw.quit();
        }
        this.lYw = new f();
        f fVar2 = this.lYw;
        if (fVar2.lYm == null || !fVar2.lYm.isAlive()) {
            fVar2.lYm = new a(fVar2);
            w.i("MicroMsg.FTS.FTSTaskDaemon", "***** Search daemon initialized, waiting for starting.");
        } else {
            w.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", new Throwable(), "Duplicated daemon initialization detected, working queue maybe dirty!", new Object[0]);
        }
        fVar2 = this.lYw;
        Runnable runnable = this.lYC;
        if (fVar2.lYm != null) {
            fVar2.lYm.lYs = runnable;
        }
        this.lYw.lYm.lYt = this.lYD;
        Intent registerReceiver = ab.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra(DownloadInfo.STATUS, -1);
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
            this.lYA = z;
        } else {
            this.lYA = false;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        ab.getContext().registerReceiver(this.lYK, intentFilter);
        h.vK().a(this.lYF);
        this.lYH.bIy();
        this.lYJ.bIy();
        this.lYG.bIy();
        h.vd().a(138, this.lYI);
        this.lYw.a(-131072, new a(this));
        this.lYw.a(-131071, new b(this));
    }

    public void onAccountRelease() {
        destroyNativeLogic();
        destroyStorage();
        if (this.lYw != null) {
            this.lYw.quit();
        }
        if (this.lYx != null) {
            this.lYx.close();
        }
        ab.getContext().unregisterReceiver(this.lYK);
        this.lYH.dead();
        this.lYG.dead();
        this.lYJ.dead();
        h.vd().b(138, this.lYI);
        h.vK().b(this.lYF);
        this.lYy = false;
        this.lYz = false;
    }

    public void configure(com.tencent.mm.kernel.b.e eVar) {
    }

    public void execute(com.tencent.mm.kernel.b.e eVar) {
    }

    public com.tencent.mm.plugin.fts.a.k getFTSTaskDaemon() {
        return this.lYw;
    }

    public com.tencent.mm.plugin.fts.a.f getFTSIndexDB() {
        return this.lYx;
    }

    public void registerSearchLogic() {
        registerNativeLogic(1, new com.tencent.mm.plugin.fts.b.e());
        registerNativeLogic(2, new com.tencent.mm.plugin.fts.b.a());
        registerNativeLogic(3, new com.tencent.mm.plugin.fts.b.c());
        registerNativeLogic(4, new com.tencent.mm.plugin.fts.b.b());
        registerNativeLogic(8, new com.tencent.mm.plugin.fts.b.d());
        registerNativeLogic(10000, new com.tencent.mm.plugin.fts.b.f());
    }

    public void registerStorage() {
        registerIndexStorage(new com.tencent.mm.plugin.fts.c.e());
        registerIndexStorage(new com.tencent.mm.plugin.fts.c.a());
        registerIndexStorage(new com.tencent.mm.plugin.fts.c.b());
        registerIndexStorage(new com.tencent.mm.plugin.fts.c.c());
        registerIndexStorage(new com.tencent.mm.plugin.fts.c.d());
    }

    public void createNativeLogic() {
        w.i("MicroMsg.FTS.PluginFTS", "Create Native Logic");
        for (int i = 0; i < this.lYN.size(); i++) {
            i iVar = (i) this.lYN.get(this.lYN.keyAt(i));
            if (iVar != null) {
                try {
                    iVar.create();
                } catch (Throwable e) {
                    w.e("MicroMsg.FTS.PluginFTS", "Create Native Logic name=%s \nexception=%s", new Object[]{iVar.getName(), bg.g(e)});
                }
            }
        }
    }

    public void destroyNativeLogic() {
        w.i("MicroMsg.FTS.PluginFTS", "Destroy Native Logic");
        for (int i = 0; i < this.lYN.size(); i++) {
            i iVar = (i) this.lYN.get(this.lYN.keyAt(i));
            if (iVar != null) {
                try {
                    iVar.destroy();
                } catch (Throwable e) {
                    w.e("MicroMsg.FTS.PluginFTS", "Create Native Logic name=%s \nexception=%s", new Object[]{iVar.getName(), bg.g(e)});
                }
            }
        }
    }

    public void createIndexStorage() {
        int i = 0;
        w.i("MicroMsg.FTS.PluginFTS", "Create Index Storage");
        LinkedList linkedList = new LinkedList();
        for (int i2 = 0; i2 < this.lYL.size(); i2++) {
            linkedList.add((g) this.lYL.get(this.lYL.keyAt(i2)));
        }
        Collections.sort(linkedList);
        while (i < linkedList.size()) {
            ((g) linkedList.get(i)).create();
            i++;
        }
    }

    public void destroyStorage() {
        w.i("MicroMsg.FTS.PluginFTS", "Destroy Index Storage");
        for (int i = 0; i < this.lYL.size(); i++) {
            g gVar = (g) this.lYL.get(this.lYL.keyAt(i));
            if (gVar != null) {
                gVar.destroy();
            }
        }
    }

    public void waitAndStartDaemon() {
        h.vJ();
        this.lYy = bg.f((Integer) h.vI().vr().get(15, null)) != 0;
        if (this.lYy) {
            w.i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon user is initialized.");
        } else {
            h.vd().a(138, this.lYI);
            w.i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon wait for account initialized");
        }
        if (this.lYz) {
            w.i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon all account post reset.");
        } else {
            w.i("MicroMsg.FTS.PluginFTS", "waitAndStartDaemon wait for all account post reset.");
        }
        if (this.lYy && this.lYz) {
            startDaemon();
        }
    }

    private void startDaemon() {
        if (!this.lYw.axD()) {
            f fVar = this.lYw;
            fVar.lYm.start();
            w.i("MicroMsg.FTS.FTSTaskDaemon", "***** Search daemon started with TID: " + fVar.lYm.getId());
        }
    }

    public com.tencent.mm.plugin.fts.a.a.a search(int i, com.tencent.mm.plugin.fts.a.a.f fVar) {
        Runnable bVar = new b(fVar);
        if (isFTSContextReady()) {
            bVar.errorCode = -3;
            if (!isFTSIndexReady()) {
                com.tencent.mm.sdk.f.e.post(bVar, "FTSExceptionHandler");
                return bVar;
            } else if (this.lYN.indexOfKey(i) >= 0) {
                i iVar = (i) this.lYN.get(i);
                if (iVar.axI()) {
                    return iVar.a(fVar);
                }
                com.tencent.mm.sdk.f.e.post(bVar, "FTSExceptionHandler");
                return bVar;
            } else {
                w.e("MicroMsg.FTS.PluginFTS", "Not Found Search Logic, LogicArraySize=%d", new Object[]{Integer.valueOf(this.lYN.size())});
                com.tencent.mm.sdk.f.e.post(bVar, "FTSExceptionHandler");
                return bVar;
            }
        }
        com.tencent.mm.sdk.f.e.post(bVar, "FTSExceptionHandler");
        return bVar;
    }

    public void cancelSearchTask(com.tencent.mm.plugin.fts.a.a.a aVar) {
        if (isFTSContextReady()) {
            f fVar = this.lYw;
            if (fVar.lYm != null) {
                a aVar2 = fVar.lYm;
                aVar.il = true;
                aVar2.lYo.remove(aVar);
                if (aVar2.lYq == aVar) {
                    aVar2.interrupt();
                }
            }
        }
    }

    public void updateTopHitsRank(String str, com.tencent.mm.plugin.fts.a.a.i iVar, int i) {
        if (isFTSContextReady() && this.lYN.indexOfKey(1) >= 0) {
            ((i) this.lYN.get(1)).a(str, iVar, i, com.tencent.mm.plugin.fts.a.d.axJ());
        }
    }

    public void addSOSHistory(String str) {
        if (isFTSContextReady() && this.lYN.indexOfKey(8) >= 0) {
            ((i) this.lYN.get(8)).addSOSHistory(str);
        }
    }

    public void deleteSOSHistory(String str) {
        if (isFTSContextReady() && this.lYN.indexOfKey(8) >= 0) {
            ((i) this.lYN.get(8)).deleteSOSHistory(str);
        }
    }

    public void registerIndexStorage(g gVar) {
        this.lYL.put(gVar.getType(), gVar);
    }

    public void unregisterIndexStorage(int i) {
        if (this.lYL.indexOfKey(i) >= 0) {
            try {
                ((g) this.lYL.get(i)).destroy();
            } catch (Throwable e) {
                w.e("MicroMsg.FTS.PluginFTS", "Destroy Index Storage name=%s \nexception=%s", new Object[]{r0.getName(), bg.g(e)});
            }
        }
        this.lYL.remove(i);
    }

    public g getFTSIndexStorage(int i) {
        return (g) this.lYL.get(i);
    }

    public com.tencent.mm.plugin.fts.a.h getFTSMainDB() {
        if (this.lYM == null) {
            this.lYM = new e();
        }
        return this.lYM;
    }

    public int stringCompareUtfBinary(String str, String str2) {
        return FTSJNIUtils.stringCompareUtfBinary(str, str2);
    }

    public void registerNativeLogic(int i, i iVar) {
        this.lYN.put(i, iVar);
    }

    public void unregisterNativeLogic(int i) {
        if (this.lYN.indexOfKey(i) >= 0) {
            try {
                ((i) this.lYN.get(i)).destroy();
            } catch (Throwable e) {
                w.e("MicroMsg.FTS.PluginFTS", "Destroy Native Logic name=%s \nexception=%s", new Object[]{r0.getName(), bg.g(e)});
            }
        }
        this.lYN.remove(i);
    }

    public boolean isFTSContextReady() {
        return this.lYw.axD();
    }

    public boolean isFTSIndexReady() {
        return ((Integer) h.vI().vr().get(com.tencent.mm.storage.w.a.uIj, Integer.valueOf(0))).intValue() == 1;
    }

    public com.tencent.mm.plugin.fts.b.e getTopHitsLogic() {
        return (com.tencent.mm.plugin.fts.b.e) this.lYN.get(1);
    }
}
