package com.tencent.mm.ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.widget.BaseAdapter;
import com.tencent.mm.bj.a.g;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public abstract class e<K, T extends com.tencent.mm.bj.a.a> extends BaseAdapter {
    public String TAG = "MicroMsg.ConversationWithCacheAdapter";
    public Context context;
    private int ncA;
    private int pageSize;
    public boolean uOF;
    public c uOG;
    private HashMap<K, b<K, T>> uOH;
    protected a uOI;
    public int uOJ;
    public int uOK;
    public boolean uOL;
    int uOM;
    private boolean uON;
    private boolean uOO;
    private e uOP;
    public K uOQ;

    public interface a {
        void OH();

        void OI();
    }

    public static class b<K, T> {
        public int uOT;
        public T uOU = null;
        public K zk;

        public b(K k, int i, T t) {
            this.zk = k;
            this.uOT = i;
        }

        public final int hashCode() {
            int i;
            int i2 = (this.uOT + 31) * 31;
            if (this.zk == null) {
                i = 0;
            } else {
                i = this.zk.hashCode();
            }
            return i + i2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.uOT != bVar.uOT) {
                return false;
            }
            if (this.zk == null) {
                if (bVar.zk != null) {
                    return false;
                }
                return true;
            } else if (this.zk.equals(bVar.zk)) {
                return true;
            } else {
                return false;
            }
        }
    }

    private interface d {
        void bOT();
    }

    private class e {
        final /* synthetic */ e uOR;
        public com.tencent.mm.ui.e$e.b uOV;
        private com.tencent.mm.ui.e$e.c uOW;
        public LinkedList<Integer> uOX;
        public int uOY;

        private class a {
            int uOZ;
            final /* synthetic */ e uPa;

            public a(e eVar, int i) {
                this.uPa = eVar;
                this.uOZ = i;
            }
        }

        class b extends ae {
            final /* synthetic */ e uPa;
            boolean uPb;
            public final int uPc = 1;
            public final int uPd = 2;

            public b(e eVar, Looper looper) {
                this.uPa = eVar;
                super(looper);
            }

            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (!this.uPb) {
                    synchronized (this.uPa) {
                        this.uPa.uOY = this.uPa.bOY();
                        w.i(this.uPa.uOR.TAG, "newcursor updateWorkerRefresh status %d", Integer.valueOf(this.uPa.uOY));
                    }
                    if (message.what == 1) {
                        this.uPa.uOR.bOS();
                    } else if (message.what == 2) {
                        this.uPa.uOR.a((c) message.obj, false, true);
                    }
                }
            }
        }

        class c extends ae {
            long lastUpdateTime;
            final /* synthetic */ e uPa;
            long uPe;
            final int uPf = (hashCode() | 1910);
            final int uPg = (hashCode() | 1914);

            public c(e eVar, Looper looper) {
                this.uPa = eVar;
                super(looper);
                eVar.uOX = new LinkedList();
            }

            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == this.uPg) {
                    removeMessages(this.uPf);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.uPe > ((long) this.uPa.uOR.uOJ) || currentTimeMillis - this.uPe < 0 || ((this.lastUpdateTime != 0 && currentTimeMillis - this.lastUpdateTime > ((long) this.uPa.uOR.uOK)) || currentTimeMillis - this.lastUpdateTime < 0)) {
                        this.uPa.bOX();
                    } else {
                        sendEmptyMessageDelayed(this.uPf, (long) this.uPa.uOR.uOJ);
                    }
                    this.uPe = currentTimeMillis;
                } else if (message.what == this.uPf) {
                    this.uPa.bOX();
                }
            }
        }

        public e(e eVar) {
            this.uOR = eVar;
            bOU();
        }

        private void bOU() {
            this.uOV = new b(this, Looper.getMainLooper());
            this.uOW = new c(this, ap.vL().nJF.getLooper());
        }

        private void bOV() {
            c cVar = this.uOW;
            cVar.removeMessages(cVar.uPf);
            cVar.removeMessages(cVar.uPg);
            b bVar = this.uOV;
            bVar.uPb = true;
            bVar.removeMessages(1);
            bVar.removeMessages(2);
            this.uOX.clear();
            this.uOY = 0;
        }

        public final synchronized void bOW() {
            w.i(this.uOR.TAG, "newcursor resetQueue ");
            bOV();
            bOU();
        }

        public final synchronized void quit() {
            w.i(this.uOR.TAG, "newcursor quit ");
            bOV();
        }

        public final void bOX() {
            int bOY;
            synchronized (this) {
                bOY = bOY();
                this.uOX.clear();
            }
            a aVar = new a(this, bOY);
            if (aVar.uOZ == 2) {
                long currentTimeMillis = System.currentTimeMillis();
                c cVar = new c(aVar.uPa.uOR, aVar.uPa.uOR.bOO());
                bOY = cVar.getCount();
                w.i(aVar.uPa.uOR.TAG, "newcursor fillCursor last : %d  count %d ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(bOY));
                b bVar = aVar.uPa.uOV;
                Message obtain = Message.obtain();
                obtain.obj = cVar;
                obtain.what = 2;
                bVar.sendMessage(obtain);
                return;
            }
            aVar.uPa.uOV.sendEmptyMessage(1);
        }

        public final int bOY() {
            if (this.uOX.size() > 1) {
                return 2;
            }
            if (this.uOX.size() == 1) {
                return ((Integer) this.uOX.get(0)).intValue();
            }
            return 0;
        }

        public final synchronized boolean bOZ() {
            return this.uOY != 0;
        }

        public final synchronized void bPa() {
            this.uOW.lastUpdateTime = System.currentTimeMillis();
        }

        public final synchronized int bPb() {
            return this.uOY;
        }

        public final synchronized void yZ(int i) {
            if (!this.uOX.contains(Integer.valueOf(i))) {
                this.uOX.add(Integer.valueOf(i));
            }
            this.uOY = bOY();
            c cVar = this.uOW;
            cVar.sendEmptyMessage(cVar.uPg);
        }
    }

    class c extends g<K, T> {
        final /* synthetic */ e uOR;

        public c(e eVar, com.tencent.mm.bj.a.d<K> dVar) {
            this.uOR = eVar;
            super(dVar, eVar.pageSize);
        }

        public final T bNR() {
            return this.uOR.bNP();
        }

        public final ArrayList<T> ai(ArrayList arrayList) {
            return this.uOR.ai(arrayList);
        }
    }

    public abstract SparseArray<K>[] a(HashSet<b<K, T>> hashSet, SparseArray<K>[] sparseArrayArr);

    public abstract ArrayList<T> ai(ArrayList<K> arrayList);

    public abstract T bNP();

    public abstract com.tencent.mm.bj.a.d<K> bOO();

    static /* synthetic */ boolean a(e eVar, HashMap hashMap) {
        for (b bVar : hashMap.values()) {
            if (bVar == null || bVar.uOT == 5) {
                if (bVar == eVar.uOQ) {
                }
            }
            return false;
        }
        return true;
    }

    public /* synthetic */ Object getItem(int i) {
        return yQ(i);
    }

    public final void a(a aVar) {
        this.uOI = aVar;
    }

    public final void bOL() {
        this.uOI = null;
    }

    public e(Context context) {
        this(true, context);
        this.pageSize = Downloads.MIN_RETYR_AFTER;
        w.i(this.TAG, "newCursor setPageSize %d", Integer.valueOf(Downloads.MIN_RETYR_AFTER));
    }

    private e(boolean z, Context context) {
        this.TAG = "MicroMsg.CursorDataAdapter";
        this.uOF = true;
        this.uOJ = 1000;
        this.uOK = 3000;
        this.uOL = true;
        this.ncA = 0;
        this.uOM = 0;
        this.uOQ = null;
        this.context = context;
        this.uON = true;
    }

    private e(Context context, int i, int i2) {
        this.TAG = "MicroMsg.CursorDataAdapter";
        this.uOF = true;
        this.uOJ = 1000;
        this.uOK = 3000;
        this.uOL = true;
        this.ncA = 0;
        this.uOM = 0;
        this.uOQ = null;
        this.context = context;
        this.uON = true;
        this.uOO = false;
        this.uOJ = 800;
        this.uOK = MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN;
    }

    public e(Context context, byte b) {
        this(context, 800, MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN);
    }

    private void a(c cVar) {
        kh(false);
        this.uOG = cVar;
        this.uOG.getCount();
        bOM();
    }

    private void a(com.tencent.mm.bj.a.d<K> dVar) {
        kh(true);
        if (this.uOG == null || this.uOG.uMI != dVar) {
            if (!(this.uOG == null || this.uOG.isClosed())) {
                this.uOG.close();
                this.uOG = null;
            }
            this.uOG = new c(this, dVar);
            this.uOG.getCount();
            bOM();
            notifyDataSetChanged();
        }
    }

    private void bOM() {
        if (this.uON) {
            int i = this.uOG.bNL() ? 1 : 2;
            if (!(i == this.uOM || this.uOM == 0)) {
                if (this.uOP != null && this.uOP.bOZ()) {
                    a(new c(this, bOO()), true, false);
                }
                w.i(this.TAG, "newcursor change update stats  %d ", Integer.valueOf(i));
            }
            this.uOM = i;
        }
    }

    public boolean bNL() {
        if (this.uOG == null) {
            return false;
        }
        return this.uOG.bNL();
    }

    public int getCount() {
        if (this.uOG == null) {
            long currentTimeMillis = System.currentTimeMillis();
            a(bOO());
            w.i(this.TAG, "newcursor createCursor last : %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        aR("getcount", false);
        return this.uOG.getCount();
    }

    public final int bON() {
        if (this.uOG == null) {
            return 0;
        }
        com.tencent.mm.bj.a.d dVar = this.uOG.uMI;
        if (dVar == null) {
            return 0;
        }
        if (dVar instanceof com.tencent.mm.bj.a.e) {
            return ((com.tencent.mm.bj.a.e) dVar).uMz[0].getCount();
        }
        throw new RuntimeException("the cursor is not instanceof MergeHeapCursor ,please call getCount() instead ");
    }

    public final void aR(String str, boolean z) {
        if (this.ncA == 0) {
            int i = 1;
        } else {
            boolean z2 = false;
        }
        if (i == 0 && (this.uOL | z) != 0) {
            if (!z) {
                w.i(this.TAG, "newcursor cache needRefresh : needRefreshInfront :%b from : %s %s", Boolean.valueOf(this.uOL), str, bg.bJZ());
            }
            kg(false);
        }
    }

    public final T yQ(int i) {
        if (this.uOG == null) {
            a(bOO());
        }
        aR("getItem", false);
        this.uOG.uMI.moveToPosition(i);
        T yQ = this.uOG.uMI.yQ(i);
        if (yQ != null) {
            yQ.bKM();
        } else {
            w.e(this.TAG, "newcursor getItem error %d", Integer.valueOf(i));
        }
        return yQ;
    }

    public long getItemId(int i) {
        return 0;
    }

    public final T bC(K k) {
        if (this.uOG == null) {
            return null;
        }
        return this.uOG.uMI.bC(k);
    }

    public final SparseArray<K>[] bOP() {
        if (this.uOG == null) {
            return null;
        }
        SparseArray[] bNJ = this.uOG.bNJ();
        SparseArray<K>[] sparseArrayArr = new SparseArray[bNJ.length];
        for (int i = 0; i < sparseArrayArr.length; i++) {
            sparseArrayArr[i] = new SparseArray();
            for (int i2 = 0; i2 < bNJ[i].size(); i2++) {
                sparseArrayArr[i].put(i2, bNJ[i].get(i2));
            }
        }
        return sparseArrayArr;
    }

    private void bOQ() {
        this.uOH.clear();
        this.uOH.put(this.uOQ, null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void kg(boolean r10) {
        /*
        r9 = this;
        r8 = 2;
        r3 = 1;
        r2 = 0;
        r0 = r9.uOO;
        if (r0 != 0) goto L_0x0009;
    L_0x0007:
        if (r10 == 0) goto L_0x006e;
    L_0x0009:
        r0 = r9.uOP;
        if (r0 == 0) goto L_0x0015;
    L_0x000d:
        r0 = r9.uOP;
        r0 = r0.bOZ();
        if (r0 != 0) goto L_0x001b;
    L_0x0015:
        r0 = r9.bOR();
        if (r0 == 0) goto L_0x0068;
    L_0x001b:
        r0 = r3;
    L_0x001c:
        if (r0 == 0) goto L_0x0065;
    L_0x001e:
        r1 = r9.bOR();
        r0 = r9.uOP;
        if (r0 == 0) goto L_0x009d;
    L_0x0026:
        r0 = r9.uOP;
        r0 = r0.bPb();
        r4 = r9.TAG;
        r5 = "newcursor mWorkerHandler.isHandingMsg,type is %d ";
        r6 = new java.lang.Object[r3];
        r7 = java.lang.Integer.valueOf(r0);
        r6[r2] = r7;
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r6);
        if (r0 == 0) goto L_0x0043;
    L_0x003e:
        r4 = r9.uOP;
        r4.bOW();
    L_0x0043:
        if (r1 == r8) goto L_0x009d;
    L_0x0045:
        r1 = r9.TAG;
        r4 = "newcursor ensureNewState  refreshstatus is %d ";
        r5 = new java.lang.Object[r3];
        r6 = java.lang.Integer.valueOf(r0);
        r5[r2] = r6;
        com.tencent.mm.sdk.platformtools.w.i(r1, r4, r5);
        r9.ncA = r2;
        if (r0 != r8) goto L_0x006a;
    L_0x0059:
        r0 = new com.tencent.mm.ui.e$c;
        r1 = r9.bOO();
        r0.<init>(r9, r1);
        r9.a(r0, r3, r3);
    L_0x0065:
        r9.ncA = r2;
    L_0x0067:
        return;
    L_0x0068:
        r0 = r2;
        goto L_0x001c;
    L_0x006a:
        r9.bOS();
        goto L_0x0065;
    L_0x006e:
        r0 = r9.bOR();
        if (r0 != 0) goto L_0x007d;
    L_0x0074:
        r0 = r9.TAG;
        r1 = "newcursor need not change ";
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
        goto L_0x0067;
    L_0x007d:
        if (r0 != r8) goto L_0x008c;
    L_0x007f:
        r1 = r9.TAG;
        r3 = "newcursor enqueueMessage resetcursor ";
        com.tencent.mm.sdk.platformtools.w.i(r1, r3);
        r1 = r9.uOH;
        r1.clear();
    L_0x008c:
        r1 = r9.uOP;
        if (r1 != 0) goto L_0x0097;
    L_0x0090:
        r1 = new com.tencent.mm.ui.e$e;
        r1.<init>(r9);
        r9.uOP = r1;
    L_0x0097:
        r1 = r9.uOP;
        r1.yZ(r0);
        goto L_0x0065;
    L_0x009d:
        r0 = r1;
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.e.kg(boolean):void");
    }

    private int bOR() {
        if (this.uOH == null || this.uOH.size() == 0) {
            return 0;
        }
        if (this.uOH.containsKey(this.uOQ)) {
            return 2;
        }
        return 1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void o(K r10, int r11) {
        /*
        r9 = this;
        r6 = 5;
        r8 = 3;
        r7 = 2;
        r1 = 0;
        r2 = 1;
        r0 = r9.uOG;
        if (r0 == 0) goto L_0x0070;
    L_0x0009:
        r0 = r9.uOH;
        if (r0 != 0) goto L_0x0014;
    L_0x000d:
        r0 = new java.util.HashMap;
        r0.<init>();
        r9.uOH = r0;
    L_0x0014:
        r0 = r9.uOH;
        r3 = r9.uOQ;
        r0 = r0.containsKey(r3);
        if (r11 == r6) goto L_0x0024;
    L_0x001e:
        r3 = r9.uON;
        if (r3 == 0) goto L_0x0024;
    L_0x0022:
        if (r11 != r2) goto L_0x007f;
    L_0x0024:
        if (r11 == r6) goto L_0x0071;
    L_0x0026:
        r9.bOQ();
    L_0x0029:
        r0 = r9.TAG;
        r3 = "newcursor syncHandle is true ,changeType is %d  ";
        r4 = new java.lang.Object[r2];
        r5 = java.lang.Integer.valueOf(r11);
        r4[r1] = r5;
        com.tencent.mm.sdk.platformtools.w.i(r0, r3, r4);
        r0 = r2;
    L_0x003a:
        r3 = r9.bOR();
        r9.ncA = r3;
        r4 = r9.TAG;
        r5 = "newcursor refreshStatus: %d ,hasLoadedAllDataStatus %b changeType :%d ";
        r6 = new java.lang.Object[r8];
        r3 = r9.ncA;
        r3 = java.lang.Integer.valueOf(r3);
        r6[r1] = r3;
        r3 = r9.uOM;
        if (r3 != r2) goto L_0x0168;
    L_0x0053:
        r3 = r2;
    L_0x0054:
        r3 = java.lang.Boolean.valueOf(r3);
        r6[r2] = r3;
        r3 = java.lang.Integer.valueOf(r11);
        r6[r7] = r3;
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r6);
        if (r0 == 0) goto L_0x016b;
    L_0x0065:
        r0 = r9.TAG;
        r1 = "newcursor event is refresh sync ";
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
        r9.kg(r2);
    L_0x0070:
        return;
    L_0x0071:
        if (r0 != 0) goto L_0x0029;
    L_0x0073:
        r0 = r9.uOH;
        r3 = new com.tencent.mm.ui.e$b;
        r4 = 0;
        r3.<init>(r10, r11, r4);
        r0.put(r10, r3);
        goto L_0x0029;
    L_0x007f:
        if (r0 == 0) goto L_0x008a;
    L_0x0081:
        r0 = r9.TAG;
        r1 = "newcursor need reset ,return ";
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
        goto L_0x0070;
    L_0x008a:
        r0 = r9.uOM;
        if (r0 != r2) goto L_0x0162;
    L_0x008e:
        r0 = r9.uOG;
        r0 = r0.bB(r10);
        if (r0 != 0) goto L_0x0098;
    L_0x0096:
        if (r11 != r7) goto L_0x0157;
    L_0x0098:
        r4 = r9.uOH;
        r5 = new com.tencent.mm.ui.e$b;
        r0 = 0;
        r5.<init>(r10, r11, r0);
        r0 = r5.uOT;
        if (r0 != r7) goto L_0x00b0;
    L_0x00a4:
        r0 = r9.uOG;
        r3 = r5.zk;
        r0 = r0.bB(r3);
        if (r0 == 0) goto L_0x00b0;
    L_0x00ae:
        r5.uOT = r8;
    L_0x00b0:
        r0 = r4.get(r10);
        r0 = (com.tencent.mm.ui.e.b) r0;
        if (r0 == 0) goto L_0x0111;
    L_0x00b8:
        r3 = r2;
    L_0x00b9:
        if (r3 == 0) goto L_0x0152;
    L_0x00bb:
        r4.remove(r0);
        r3 = r5.uOT;
        switch(r3) {
            case 2: goto L_0x0126;
            case 3: goto L_0x00c3;
            case 4: goto L_0x00c3;
            case 5: goto L_0x0113;
            default: goto L_0x00c3;
        };
    L_0x00c3:
        r0 = r0.uOT;
        switch(r0) {
            case 2: goto L_0x014e;
            case 3: goto L_0x00c8;
            case 4: goto L_0x00c8;
            case 5: goto L_0x0144;
            default: goto L_0x00c8;
        };
    L_0x00c8:
        r5.uOT = r8;
    L_0x00ca:
        r4.put(r10, r5);
    L_0x00cd:
        r0 = r9.uOG;
        r3 = r4.size();
        r0 = r0.uMI;
        r0 = r0.yP(r3);
        if (r0 != 0) goto L_0x00f8;
    L_0x00db:
        r0 = r9.TAG;
        r3 = "newcursor events size exceed limit :size is :  %d";
        r5 = new java.lang.Object[r2];
        r6 = r4.size();
        r6 = java.lang.Integer.valueOf(r6);
        r5[r1] = r6;
        com.tencent.mm.sdk.platformtools.w.i(r0, r3, r5);
        r4.clear();
        r0 = r9.uOQ;
        r3 = 0;
        r4.put(r0, r3);
    L_0x00f8:
        r0 = r9.TAG;
        r3 = "newcursor add event events size %d";
        r4 = new java.lang.Object[r2];
        r5 = r9.uOH;
        r5 = r5.size();
        r5 = java.lang.Integer.valueOf(r5);
        r4[r1] = r5;
        com.tencent.mm.sdk.platformtools.w.i(r0, r3, r4);
        r0 = r1;
        goto L_0x003a;
    L_0x0111:
        r3 = r1;
        goto L_0x00b9;
    L_0x0113:
        r0 = r0.uOT;
        switch(r0) {
            case 2: goto L_0x00f8;
            case 3: goto L_0x0118;
            case 4: goto L_0x0118;
            case 5: goto L_0x011b;
            default: goto L_0x0118;
        };
    L_0x0118:
        r5.uOT = r6;
        goto L_0x00ca;
    L_0x011b:
        r0 = r9.TAG;
        r3 = "newcursor processEvent last delete, now delete, impossible";
        com.tencent.mm.sdk.platformtools.w.i(r0, r3);
        r5.uOT = r6;
        goto L_0x00ca;
    L_0x0126:
        r0 = r0.uOT;
        switch(r0) {
            case 2: goto L_0x0139;
            case 3: goto L_0x012b;
            case 4: goto L_0x012b;
            case 5: goto L_0x0136;
            default: goto L_0x012b;
        };
    L_0x012b:
        r0 = r9.TAG;
        r3 = "newcursor processEvent last update, now insert, impossible";
        com.tencent.mm.sdk.platformtools.w.i(r0, r3);
        r5.uOT = r7;
        goto L_0x00ca;
    L_0x0136:
        r5.uOT = r8;
        goto L_0x00ca;
    L_0x0139:
        r0 = r9.TAG;
        r3 = "newcursor processEvent last insert, now insert, impossible";
        com.tencent.mm.sdk.platformtools.w.i(r0, r3);
        r5.uOT = r7;
        goto L_0x00ca;
    L_0x0144:
        r0 = r9.TAG;
        r3 = "newcursor processEvent last delete, now update, impossible";
        com.tencent.mm.sdk.platformtools.w.i(r0, r3);
        goto L_0x00c8;
    L_0x014e:
        r5.uOT = r7;
        goto L_0x00ca;
    L_0x0152:
        r4.put(r10, r5);
        goto L_0x00cd;
    L_0x0157:
        r0 = r9.TAG;
        r3 = "newcursor event pass ";
        com.tencent.mm.sdk.platformtools.w.i(r0, r3);
        r0 = r1;
        goto L_0x003a;
    L_0x0162:
        r9.bOQ();
        r0 = r1;
        goto L_0x003a;
    L_0x0168:
        r3 = r1;
        goto L_0x0054;
    L_0x016b:
        r0 = r9.uOF;
        if (r0 == 0) goto L_0x0070;
    L_0x016f:
        r0 = r9.uOL;
        if (r0 == 0) goto L_0x0070;
    L_0x0173:
        r9.kg(r1);
        goto L_0x0070;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.e.o(java.lang.Object, int):void");
    }

    public void pause() {
        this.uOF = false;
        w.i(this.TAG, "new cursor pasue");
    }

    private void a(d dVar) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.uOI != null) {
            this.uOI.OI();
        }
        dVar.bOT();
        notifyDataSetChanged();
        if (this.uOI != null) {
            this.uOI.OH();
        }
        if (this.uOP != null) {
            this.uOP.bPa();
        }
        w.i(this.TAG, "newcursor update callback last :%d ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    private void bOS() {
        if (this.uOG == null || this.uOG.isClosed() || this.uOH.size() != 0) {
            a(new d(this) {
                final /* synthetic */ e uOR;

                {
                    this.uOR = r1;
                }

                public final void bOT() {
                    if (e.a(this.uOR, this.uOR.uOH)) {
                        HashSet hashSet = new HashSet(this.uOR.uOH.size());
                        for (b bVar : this.uOR.uOH.values()) {
                            hashSet.add(bVar.zk);
                        }
                        w.i(this.uOR.TAG, "newcursor all event is delete");
                        this.uOR.uOG.c(hashSet.toArray(), null);
                    } else if (this.uOR.uOH.containsKey(this.uOR.uOQ)) {
                        r2 = System.currentTimeMillis();
                        this.uOR.a(new c(this.uOR, this.uOR.bOO()), true, false);
                        w.i(this.uOR.TAG, "cache unuseful,reset cursor,last : %d", Long.valueOf(System.currentTimeMillis() - r2));
                    } else {
                        r2 = System.currentTimeMillis();
                        SparseArray[] bOP = this.uOR.bOP();
                        SparseArray[] a = this.uOR.a(new HashSet(this.uOR.uOH.values()), bOP);
                        int length = bOP.length;
                        if (length > 1) {
                            for (int i = 0; i < length; i++) {
                                w.i(this.uOR.TAG, "newcursor %d  refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - r2), Integer.valueOf(bOP[i].size()), Integer.valueOf(a[i].size()));
                            }
                        } else {
                            w.i(this.uOR.TAG, "newcursor refreshPosistion last :%d, oldpos size is %d ,newpos size is %d  ", Long.valueOf(System.currentTimeMillis() - r2), Integer.valueOf(bOP[0].size()), Integer.valueOf(a[0].size()));
                        }
                        for (b bVar2 : this.uOR.uOH.values()) {
                            if (bVar2 != null) {
                                if (bVar2.uOU != null) {
                                    w.i(this.uOR.TAG, "newcursor notify cache update : key : %s ", bVar2.zk);
                                }
                                this.uOR.uOG.c(bVar2.zk, (com.tencent.mm.bj.a.a) bVar2.uOU);
                            } else {
                                w.e(this.uOR.TAG, "newcursor event is null ! ");
                            }
                        }
                        this.uOR.a(a);
                        w.i(this.uOR.TAG, "newcursor after resort new pos size :%d  ", Integer.valueOf(this.uOR.uOG.bNJ()[0].size()));
                    }
                    this.uOR.uOH.clear();
                }
            });
        } else {
            w.i(this.TAG, "events size is 0  ");
        }
    }

    private void a(final c cVar, boolean z, boolean z2) {
        if (z) {
            if (this.uOP != null && this.uOP.bOZ()) {
                this.uOP.bOW();
            }
            if (this.uOH != null) {
                this.uOH.clear();
            }
        }
        if (z2) {
            a(new d(this) {
                final /* synthetic */ e uOR;

                public final void bOT() {
                    this.uOR.a(cVar);
                }
            });
        } else {
            a((c) cVar);
        }
    }

    public final void a(SparseArray<K>[] sparseArrayArr) {
        SparseArray[] bNJ = this.uOG.bNJ();
        for (int i = 0; i < bNJ.length; i++) {
            bNJ[i].clear();
            for (int i2 = 0; i2 < sparseArrayArr[i].size(); i2++) {
                bNJ[i].put(i2, sparseArrayArr[i].get(i2));
            }
        }
    }

    public final void kh(boolean z) {
        if (this.uOG != null) {
            this.uOG.close();
            this.uOG = null;
        }
        if (z && this.uOP != null) {
            this.uOP.quit();
            this.uOP = null;
            if (this.uOH != null) {
                this.uOH.clear();
                w.i(this.TAG, "newcursor closeCursor,clear events");
            }
        }
        this.ncA = 0;
        this.uOM = 0;
    }
}
