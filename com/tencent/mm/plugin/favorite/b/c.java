package com.tencent.mm.plugin.favorite.b;

import android.database.Cursor;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.bj.g;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.ArrayList;
import java.util.Iterator;

public final class c {
    private static c lEe = null;
    public long endTime = -1;
    public boolean kOH = false;
    public ArrayList<a> lEd = new ArrayList();
    public Object lEf = new Object();
    private Runnable lEg = new Runnable(this) {
        final /* synthetic */ c lEh;

        {
            this.lEh = r1;
        }

        public final void run() {
            k ata = h.ata();
            w.i("MicroMsg.FavItemInfoStorage", "calDataBaseDataTotalLength");
            String str = "select " + k.lEl + " from FavItemInfo where ";
            int[] iArr = x.lFi;
            int length = iArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                i++;
                str2 = str2 + iArr[i] + ",";
            }
            if (str2.endsWith(",")) {
                str2 = str2.substring(0, str2.length() - 1);
            }
            str = str + "itemStatus in (" + str2 + ")";
            iArr = x.lFh;
            length = iArr.length;
            str2 = "";
            i = 0;
            while (i < length) {
                i++;
                str2 = str2 + iArr[i] + ",";
            }
            if (str2.endsWith(",")) {
                str2 = str2.substring(0, str2.length() - 1);
            }
            Cursor rawQuery = ata.gUz.rawQuery(str + " and type in (" + str2 + ")", null);
            if (rawQuery == null) {
                w.e("MicroMsg.FavItemInfoStorage", "calDataBaseDataTotalLength cu = null");
            } else if (rawQuery.getCount() == 0) {
                rawQuery.close();
                w.i("MicroMsg.FavItemInfoStorage", "calDataBaseDataTotalLength cu.getCount() = 0");
            } else {
                long cs;
                w.i("MicroMsg.FavItemInfoStorage", "calDataBaseDataTotalLength cu.getCount() = " + rawQuery.getCount());
                if (ata.gUz instanceof g) {
                    cs = ((g) ata.gUz).cs(Thread.currentThread().getId());
                } else {
                    cs = 0;
                }
                while (rawQuery.moveToNext()) {
                    j jVar = new j();
                    jVar.b(rawQuery);
                    if (x.mu(jVar.field_itemStatus)) {
                        long j;
                        if (jVar.field_favProto != null) {
                            Iterator it = jVar.field_favProto.tzn.iterator();
                            j = 0;
                            while (it.hasNext()) {
                                j = ((rm) it.next()).txD + j;
                            }
                        } else {
                            j = 0;
                        }
                        jVar.field_datatotalsize = j;
                        ata.a(jVar, new String[]{"localId"});
                    }
                }
                if (ata.gUz instanceof g) {
                    ((g) ata.gUz).aD(cs);
                }
                rawQuery.close();
                w.i("MicroMsg.FavItemInfoStorage", "calDataBaseDataTotalLength end");
            }
            this.lEh.endTime = System.currentTimeMillis();
            w.d("MicroMsg.FavCleanFirstLoader", "calDataBaseDataTotalLength, used: %dms", new Object[]{Long.valueOf(this.lEh.endTime - this.lEh.startTime)});
            this.lEh.endTime = -1;
            this.lEh.startTime = -1;
            synchronized (this.lEh.lEf) {
                ap.yY();
                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uBX, Boolean.valueOf(true));
                this.lEh.kOH = false;
            }
            this.lEh.mHandler.sendEmptyMessage(0);
        }
    };
    ae mHandler = new ae(this, Looper.getMainLooper()) {
        final /* synthetic */ c lEh;

        public final void handleMessage(Message message) {
            Iterator it = this.lEh.lEd.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar != null) {
                    aVar.onFinish();
                }
            }
            this.lEh.lEd.clear();
        }
    };
    public long startTime = -1;

    public interface a {
        void onFinish();
    }

    private c() {
    }

    public static synchronized c atc() {
        c cVar;
        synchronized (c.class) {
            if (lEe == null) {
                lEe = new c();
            }
            cVar = lEe;
        }
        return cVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.favorite.b.c.a r5) {
        /*
        r4 = this;
        r1 = r4.lEf;
        monitor-enter(r1);
        com.tencent.mm.u.ap.yY();	 Catch:{ all -> 0x003a }
        r0 = com.tencent.mm.u.c.vr();	 Catch:{ all -> 0x003a }
        r2 = com.tencent.mm.storage.w.a.uBX;	 Catch:{ all -> 0x003a }
        r3 = 0;
        r3 = java.lang.Boolean.valueOf(r3);	 Catch:{ all -> 0x003a }
        r0 = r0.get(r2, r3);	 Catch:{ all -> 0x003a }
        r0 = (java.lang.Boolean) r0;	 Catch:{ all -> 0x003a }
        r0 = r0.booleanValue();	 Catch:{ all -> 0x003a }
        if (r0 == 0) goto L_0x0024;
    L_0x001d:
        if (r5 == 0) goto L_0x0022;
    L_0x001f:
        r5.onFinish();	 Catch:{ all -> 0x003a }
    L_0x0022:
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
    L_0x0023:
        return;
    L_0x0024:
        if (r5 == 0) goto L_0x002b;
    L_0x0026:
        r0 = r4.lEd;	 Catch:{ all -> 0x003a }
        r0.add(r5);	 Catch:{ all -> 0x003a }
    L_0x002b:
        r0 = r4.kOH;	 Catch:{ all -> 0x003a }
        if (r0 == 0) goto L_0x003d;
    L_0x002f:
        r0 = "MicroMsg.FavCleanFirstLoader";
        r2 = "isLoading is true, ignore";
        com.tencent.mm.sdk.platformtools.w.i(r0, r2);	 Catch:{ all -> 0x003a }
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        goto L_0x0023;
    L_0x003a:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
    L_0x003d:
        r0 = 1;
        r4.kOH = r0;	 Catch:{ all -> 0x003a }
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        r0 = java.lang.System.currentTimeMillis();
        r4.startTime = r0;
        r0 = r4.lEg;
        r1 = "FavCleanFirstLoader_CalFavDataLength";
        com.tencent.mm.sdk.f.e.post(r0, r1);
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.favorite.b.c.a(com.tencent.mm.plugin.favorite.b.c$a):void");
    }
}
