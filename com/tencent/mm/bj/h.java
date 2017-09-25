package com.tencent.mm.bj;

import android.content.ContentValues;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.w;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class h {
    private aj fyI = new aj(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ h uMl;

        {
            this.uMl = r1;
        }

        public final boolean oQ() {
            if (this.uMl.uLS.isOpen()) {
                this.uMl.bNO();
            }
            return false;
        }
    }, false);
    public g uLS;
    private BlockingQueue<a> uMk = new LinkedBlockingQueue();
    private String uxg = null;

    public static class a {
        public String uMm;
        public String[] uMn;
        public int uvg;
        public String uxc;
        public String uxe;
        public ContentValues values;

        public final void G(String[] strArr) {
            if (strArr != null && strArr.length > 0) {
                this.uMn = new String[strArr.length];
                for (int i = 0; i < strArr.length; i++) {
                    this.uMn[i] = new String(strArr[i]);
                }
            }
        }
    }

    public h(g gVar, String str) {
        this.uLS = gVar;
        this.uxg = str;
    }

    public final int bNO() {
        w.d("MicroMsg.MemoryStorage.Holder", "appendAllToDisk table:%s trans:%b queue:%d", this.uxg, Boolean.valueOf(this.uLS.inTransaction()), Integer.valueOf(this.uMk.size()));
        if (!this.uMk.isEmpty()) {
            long j;
            if (this.uLS.inTransaction()) {
                j = 0;
            } else {
                j = this.uLS.cs(Thread.currentThread().getId());
            }
            while (!this.uMk.isEmpty()) {
                a aVar = (a) this.uMk.poll();
                if (aVar == null) {
                    w.w("MicroMsg.MemoryStorage.Holder", "appendToDisk Holder == null. table:%s", this.uxg);
                } else if (this.uLS == null || !this.uLS.isOpen()) {
                    w.e("MicroMsg.MemoryStorage.Holder", "appendToDisk diskDB already close. table:%s", this.uxg);
                } else if (aVar.uvg == 2) {
                    this.uLS.insert(this.uxg, aVar.uxc, aVar.values);
                } else if (aVar.uvg == 5) {
                    this.uLS.delete(this.uxg, aVar.uMm, aVar.uMn);
                } else if (aVar.uvg == 1) {
                    this.uLS.eE(this.uxg, aVar.uxe);
                } else if (aVar.uvg == 4) {
                    this.uLS.replace(this.uxg, aVar.uxc, aVar.values);
                } else if (aVar.uvg == 3) {
                    this.uLS.update(this.uxg, aVar.values, aVar.uMm, aVar.uMn);
                }
            }
            if (j > 0) {
                this.uLS.aD(j);
            }
        }
        return 0;
    }

    final int a(a aVar) {
        this.uMk.add(aVar);
        if (this.uMk.size() >= 40) {
            bNO();
        }
        if (this.fyI.bJq()) {
            this.fyI.v(60000, 60000);
        }
        return 0;
    }
}
