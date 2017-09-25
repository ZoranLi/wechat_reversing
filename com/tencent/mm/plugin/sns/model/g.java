package com.tencent.mm.plugin.sns.model;

import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.data.f;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.x;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.bbs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.ui.widget.QImageView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class g implements e {
    public static int pTm = 0;
    Map<Integer, WeakReference<Object>> hFI = new HashMap();
    public boolean pSE = true;
    public long pSP = 0;
    public long pSQ = 0;
    public y<String, n> pSR;
    public ak<String, WeakReference<Bitmap>> pSS;
    private Map<String, LinkedList<WeakReference<c>>> pST = new HashMap();
    private ConcurrentHashMap<Integer, String> pSU = new ConcurrentHashMap();
    public LinkedList<b> pSV = new LinkedList();
    public boolean pSW = false;
    public HashSet<c> pSX = new HashSet();
    public HashMap<String, Integer> pSY = new HashMap();
    private int pSZ = 4;
    public x pTa;
    public long pTb = 0;
    public long pTc = 0;
    private int pTd = 0;
    private int pTe = 0;
    private HashMap<Long, Integer> pTf = new HashMap();
    private HashMap<Integer, Boolean> pTg = new HashMap();
    private HashMap<Integer, Boolean> pTh = new HashMap();
    private int pTi = 0;
    private int pTj = 0;
    private HashMap<Long, Integer> pTk = new HashMap();
    protected Set<String> pTl = new HashSet();

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ g pTn;
        final /* synthetic */ int pTo = 0;
        final /* synthetic */ String pTp;
        final /* synthetic */ n pTq;

        AnonymousClass2(g gVar, int i, String str, n nVar) {
            this.pTn = gVar;
            this.pTp = str;
            this.pTq = nVar;
        }

        public final void run() {
            this.pTn.a(this.pTo + "-" + this.pTp, this.pTq);
        }
    }

    class AnonymousClass4 implements Runnable {
        final /* synthetic */ g pTn;
        final /* synthetic */ int pTo = 0;
        final /* synthetic */ List pTr;
        final /* synthetic */ an pTs;

        AnonymousClass4(g gVar, List list, int i, an anVar) {
            this.pTn = gVar;
            this.pTr = list;
            this.pTs = anVar;
        }

        public final void run() {
            long NA = bg.NA();
            com.tencent.mm.plugin.sns.data.e eVar = new com.tencent.mm.plugin.sns.data.e(this.pTr);
            eVar.nif = i.bo(this.pTr);
            eVar.pQS = this.pTo;
            int i = 0;
            int i2 = 1;
            while (i < this.pTr.size() && i < 4) {
                int i3;
                alh com_tencent_mm_protocal_c_alh = (alh) this.pTr.get(i);
                b beG = ae.beG();
                String str = com_tencent_mm_protocal_c_alh.mQY;
                int i4 = beG.pSG.containsKey(i.ao(1, str)) ? 1 : beG.pSG.containsKey(i.ao(5, str)) ? 1 : 0;
                if (i4 != 0) {
                    i3 = 0;
                } else if (FileOp.aO(am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + i.e(com_tencent_mm_protocal_c_alh)) || FileOp.aO(am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + i.l(com_tencent_mm_protocal_c_alh)) || FileOp.aO(am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + i.m(com_tencent_mm_protocal_c_alh))) {
                    i3 = i2;
                } else {
                    ae.beG().a(com_tencent_mm_protocal_c_alh, 1, eVar, this.pTs);
                    i3 = 0;
                }
                i++;
                i2 = i3;
            }
            NA = bg.aB(NA);
            if (NA > 100) {
                w.i("MicroMsg.LazyerImageLoader2", "fileexist check2  endtime " + NA + " " + Thread.currentThread().getName() + " " + com.tencent.mm.compatible.util.e.hgs + " " + ae.beZ() + " " + eVar.nif);
            }
            if (bg.aB(this.pTn.pSP) > 60000) {
                com.tencent.mm.plugin.report.service.g.oUh.i(11696, new Object[]{Integer.valueOf(1), Long.valueOf(NA), Integer.valueOf(0), Thread.currentThread().getName(), ae.beZ(), com.tencent.mm.compatible.util.e.hgs});
                this.pTn.pSP = bg.NA();
            }
            final String bo = i.bo(this.pTr);
            if (i2 != 0) {
                ae.ayz().post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 pTt;

                    public final void run() {
                        new i(i.an(0, bo), bo, this.pTt.pTr).l("");
                    }
                });
            }
        }
    }

    class AnonymousClass9 implements Runnable {
        final /* synthetic */ alh pSK;
        final /* synthetic */ g pTn;

        AnonymousClass9(g gVar, alh com_tencent_mm_protocal_c_alh) {
            this.pTn = gVar;
            this.pSK = com_tencent_mm_protocal_c_alh;
        }

        public final void run() {
            this.pTn.a(1, this.pSK);
        }
    }

    public enum a {
        ;

        static {
            pTw = 1;
            pTx = 2;
            pTy = new int[]{pTw, pTx};
        }
    }

    static class c {
        public int code;
        public String id;
        public int pTA;
        public boolean pTB;

        public c(String str, int i, int i2, boolean z) {
            this.id = str;
            this.code = i;
            this.pTA = i2;
            this.pTB = z;
        }

        public final int hashCode() {
            return this.code;
        }

        public final boolean equals(Object obj) {
            return obj != null && obj.hashCode() == this.code;
        }
    }

    class b extends h<String, Integer, Boolean> {
        String arH = "";
        private alh fVV;
        private String hYa;
        private n hha = null;
        final /* synthetic */ g pTn;
        private int pTz = 0;
        private String path;

        public final /* synthetic */ Object bed() {
            this.pTn.pSW = true;
            System.currentTimeMillis();
            if (!this.pTn.pSE) {
                w.i("MicroMsg.ImageLoader", "doInBackground pass" + this.path);
                return Boolean.valueOf(false);
            } else if (this.pTn.pSR.aV(this.arH)) {
                w.i("MicroMsg.ImageLoader", "doInBackGroundgetKey");
                return Boolean.valueOf(false);
            } else {
                FileOp.kn(this.hYa);
                long currentTimeMillis = System.currentTimeMillis();
                if (FileOp.aO(this.path)) {
                    w.d("MicroMsg.ImageLoader", "doInBackground file exist:%s", new Object[]{this.path});
                } else {
                    N(i.e(this.fVV), i.l(this.fVV), i.f(this.fVV));
                }
                long NA = bg.NA();
                if (this.pTz == 5) {
                    if (!FileOp.aO(this.path)) {
                        N(i.e(this.fVV), i.l(this.fVV), i.f(this.fVV));
                    }
                    boolean aO = FileOp.aO(this.hYa + i.e(this.fVV));
                    boolean aO2 = FileOp.aO(this.hYa + i.l(this.fVV));
                    boolean aO3 = FileOp.aO(this.hYa + i.f(this.fVV));
                    this.hha = i.EI(this.path);
                    if (this.hha == null) {
                        w.i("MicroMsg.ImageLoader", "error path %s", new Object[]{this.path});
                        this.hha = com.tencent.mm.plugin.sns.lucky.a.a.dq(this.hYa + i.f(this.fVV), this.path);
                        w.i("MicroMsg.ImageLoader", "abc a" + aO + " b" + aO2 + " c" + aO3 + " d" + FileOp.aO(this.path));
                    }
                } else if (this.pTz == 4) {
                    this.hha = i.EI(this.path);
                    if (this.hha == null) {
                        w.i("MicroMsg.ImageLoader", "error path %s", new Object[]{this.path});
                        this.hha = com.tencent.mm.plugin.sns.lucky.a.a.dq(this.hYa + i.e(this.fVV), this.path);
                    }
                } else {
                    this.hha = i.EK(this.path);
                }
                long aB = bg.aB(NA);
                int ki = (int) FileOp.ki(this.path);
                if (bg.aB(this.pTn.pSQ) > 60000) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(11696, new Object[]{Integer.valueOf(4), Long.valueOf(aB), Integer.valueOf(ki), Thread.currentThread().getName(), ae.beZ(), com.tencent.mm.compatible.util.e.hgs});
                    this.pTn.pSQ = bg.NA();
                }
                if (this.hha == null) {
                    w.i("MicroMsg.ImageLoader", "mediaid %s is fail and delete it", new Object[]{this.fVV.mQY});
                    FileOp.deleteFile(this.hYa + i.f(this.fVV));
                    FileOp.deleteFile(this.path);
                    com.tencent.mm.plugin.report.service.g.oUh.a(150, 2, 1, true);
                }
                currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                com.tencent.mm.plugin.report.service.g.oUh.a(150, 0, 1, true);
                com.tencent.mm.plugin.report.service.g.oUh.a(150, 1, currentTimeMillis, true);
                w.i("MicroMsg.ImageLoader", "doInBackground decode %s and " + (this.hha == null) + " " + this.hha + " %d ", new Object[]{this.path, Long.valueOf(System.currentTimeMillis() - NA)});
                return Boolean.valueOf(true);
            }
        }

        public final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Boolean) obj);
            g.pTm--;
            this.pTn.pTl.remove(this.arH);
            this.pTn.b(this.arH, this.hha);
            this.pTn.pSW = false;
            this.pTn.beb();
        }

        public b(g gVar, String str, String str2, String str3, alh com_tencent_mm_protocal_c_alh, int i) {
            this.pTn = gVar;
            gVar.pTl.add(str);
            this.arH = str;
            this.path = str2;
            this.hYa = str3;
            this.fVV = com_tencent_mm_protocal_c_alh;
            this.pTz = i;
            g.pTm++;
            w.d("MicroMsg.ImageLoader", "peddingCount %d ", new Object[]{Integer.valueOf(g.pTm)});
        }

        private void N(String str, String str2, String str3) {
            FileOp.aO(this.hYa + str3);
            if (!FileOp.aO(this.hYa + str)) {
                if (!FileOp.aO(this.hYa + str2)) {
                    str2 = i.m(this.fVV);
                }
                if (!r.a(this.hYa, str2, str, (float) ae.beT())) {
                    w.i("MicroMsg.ImageLoader", "delete %s", new Object[]{str2});
                    FileOp.deleteFile(this.hYa + str2);
                }
                w.i("MicroMsg.ImageLoader", "createUserThumb %s -> %s, result:%b", new Object[]{this.hYa + str2, this.hYa + str, Boolean.valueOf(r0)});
            }
            r.b(this.hYa, str, str3, (float) ae.beS());
        }

        public final ae bec() {
            return ae.ayx();
        }
    }

    public final void start() {
        this.pSE = true;
        beb();
        b beG = ae.beG();
        beG.pSE = true;
        beG.pq();
    }

    public final void pause() {
        this.pSE = false;
        b beG = ae.beG();
        beG.pSE = false;
        LinkedList linkedList = new LinkedList();
        Iterator it = beG.gMT.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (fVar.requestType != 6) {
                beG.pSH.remove(fVar.arH);
                linkedList.add(fVar);
            }
        }
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            beG.gMT.remove((f) it2.next());
        }
    }

    public g() {
        int i;
        w.i("MicroMsg.LazyerImageLoader2", "BitmapPool %dMB", new Object[]{Integer.valueOf(((ActivityManager) ab.getContext().getSystemService("activity")).getLargeMemoryClass())});
        if (((ActivityManager) ab.getContext().getSystemService("activity")).getLargeMemoryClass() > 256) {
            i = 10485760;
        } else {
            i = 5242880;
        }
        this.pSR = new y<String, n>(this, i) {
            final /* synthetic */ g pTn;

            protected final /* bridge */ /* synthetic */ Object create(Object obj) {
                return (n) super.create((String) obj);
            }

            protected final /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
                String str = (String) obj;
                n nVar = (n) obj2;
                n nVar2 = (n) obj3;
                super.entryRemoved(z, str, nVar, nVar2);
                if (!(nVar == null || nVar.isRecycled() || nVar.equals(nVar2))) {
                    nVar.wy();
                }
                int i = 0;
                if (nVar2 != null) {
                    i = nVar2.getAllocationByteCount();
                }
                w.d("MicroMsg.LazyerImageLoader2", "evicted: " + z + " key: " + str + " result:" + i + " " + (nVar.bitmap.getRowBytes() * nVar.bitmap.getHeight()) + " " + nVar.bitmap.getWidth() + " " + nVar.bitmap.getHeight() + " oldValue " + (nVar == null ? "NULL" : nVar.wA()) + " newValue: " + (nVar2 == null ? "NULL" : nVar2.wA()));
            }

            protected final /* synthetic */ int sizeOf(Object obj, Object obj2) {
                String str = (String) obj;
                n nVar = (n) obj2;
                int allocationByteCount = nVar != null ? nVar.getAllocationByteCount() : 0;
                w.d("MicroMsg.LazyerImageLoader2", "key: %s, size: %s", new Object[]{str, Integer.valueOf(allocationByteCount)});
                if (allocationByteCount != 0 || (nVar != null && !nVar.isRecycled())) {
                    return allocationByteCount;
                }
                w.i("MicroMsg.LazyerImageLoader2", "size of error  " + nVar);
                return 0;
            }

            public final void trimToSize(int i) {
                try {
                    super.trimToSize(i);
                } catch (Exception e) {
                    w.e("MicroMsg.LazyerImageLoader2", "trimToSize error: %s", new Object[]{e.getMessage()});
                }
            }
        };
        this.pSS = new ak(this.pSZ, new com.tencent.mm.plugin.sns.model.ak.a(this) {
            final /* synthetic */ g pTn;

            {
                this.pTn = r1;
            }

            public final boolean bj(Object obj) {
                int i;
                String str = (String) obj;
                g gVar = this.pTn;
                if (gVar.pSX == null || gVar.pSX.size() == 0) {
                    i = true;
                } else {
                    c cVar;
                    for (Integer intValue : gVar.hFI.keySet()) {
                        int intValue2 = intValue.intValue();
                        if (((WeakReference) gVar.hFI.get(Integer.valueOf(intValue2))).get() == null) {
                            Iterator it = gVar.pSX.iterator();
                            while (it.hasNext()) {
                                cVar = (c) it.next();
                                if (cVar.code == intValue2) {
                                    gVar.pSX.remove(cVar);
                                    w.d("MicroMsg.LazyerImageLoader2", "remove code ok rCode: " + intValue2);
                                    break;
                                }
                            }
                        }
                    }
                    Iterator it2 = gVar.pSX.iterator();
                    while (it2.hasNext()) {
                        cVar = (c) it2.next();
                        if (str != null && str.equals(cVar.id)) {
                            i = 0;
                            break;
                        }
                    }
                    boolean z = true;
                }
                if (i == 0) {
                    return false;
                }
                ak akVar = this.pTn.pSS;
                try {
                    Bitmap bitmap;
                    Object obj2 = ((com.tencent.mm.plugin.sns.model.ak.b) akVar.pWX.get(str)).obj;
                    if (obj2 instanceof Bitmap) {
                        bitmap = (Bitmap) obj2;
                    } else {
                        WeakReference weakReference = (WeakReference) ((com.tencent.mm.plugin.sns.model.ak.b) akVar.pWX.get(str)).obj;
                        bitmap = weakReference != null ? (Bitmap) weakReference.get() : null;
                    }
                    if (!(bitmap == null || bitmap.isRecycled())) {
                        w.d("MicroMsg.SnsLRUMap", "remove key:" + str);
                        bitmap.recycle();
                    }
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.SnsLRUMap", e, "", new Object[0]);
                    w.e("MicroMsg.SnsLRUMap", "can not recycled forceRemove ");
                }
                w.d("MicroMsg.SnsLRUMap", "internalMap " + akVar.pWX.size() + " bfSize :" + akVar.pWX.size() + " o == null " + (akVar.pWX.remove(str) != null));
                w.i("MicroMsg.LazyerImageLoader2", "keys " + str + " deRef ok  Big:size:" + this.pTn.pSS.pWX.size() + " listPaitSize:" + this.pTn.pSX.size());
                return true;
            }
        });
    }

    public final void bea() {
        if (this.pSR != null) {
            this.hFI.clear();
            this.pSS.pWX.clear();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("mMemoryCache \n");
            stringBuffer.append("putCount:" + this.pSR.putCount() + ";");
            stringBuffer.append("missCount:" + this.pSR.missCount() + ";");
            stringBuffer.append("hitCount:" + this.pSR.hitCount() + ";");
            stringBuffer.append("createCount:" + this.pSR.createCount() + ";");
            stringBuffer.append("evictionCount:" + this.pSR.evictionCount() + ";");
            w.i("MicroMsg.LazyerImageLoader2", "report lurcache ");
            this.pSR.trimToSize(-1);
        }
        this.pSS.bfh();
        System.gc();
    }

    public final Bitmap c(alh com_tencent_mm_protocal_c_alh, View view, int i, an anVar) {
        return a(com_tencent_mm_protocal_c_alh, view, i, true, anVar);
    }

    private boolean D(View view, int i) {
        if (view.hashCode() == i) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            do {
                childCount--;
                if (childCount >= 0) {
                }
            } while (!D(viewGroup.getChildAt(childCount), i));
            return true;
        }
        return false;
    }

    public final void Q(Activity activity) {
        w.d("MicroMsg.LazyerImageLoader2", "try to remove ImageView " + this.hFI.size());
        List<Integer> linkedList = new LinkedList();
        Iterator it = this.pSX.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (D(activity.getWindow().getDecorView(), cVar.code)) {
                linkedList.add(Integer.valueOf(cVar.code));
            }
        }
        for (Integer intValue : linkedList) {
            int intValue2 = intValue.intValue();
            this.hFI.remove(Integer.valueOf(intValue2));
            Iterator it2 = this.pSX.iterator();
            while (it2.hasNext()) {
                cVar = (c) it2.next();
                if (cVar.code == intValue2) {
                    this.pSX.remove(cVar);
                    break;
                }
            }
        }
        linkedList.clear();
        it = this.pSX.iterator();
        while (it.hasNext()) {
            cVar = (c) it.next();
            if (cVar.pTA == activity.hashCode()) {
                linkedList.add(Integer.valueOf(cVar.code));
            }
        }
        for (Integer intValue3 : linkedList) {
            int intValue4 = intValue3.intValue();
            this.hFI.remove(Integer.valueOf(intValue4));
            Iterator it3 = this.pSX.iterator();
            while (it3.hasNext()) {
                cVar = (c) it3.next();
                if (cVar.code == intValue4) {
                    this.pSX.remove(cVar);
                    break;
                }
            }
        }
        this.pSS.bfh();
        w.d("MicroMsg.LazyerImageLoader2", "after try to remove ImageView " + this.hFI.size());
    }

    public final void cn(View view) {
        if (view instanceof ImageView) {
            ((ImageView) view).setImageBitmap(null);
        } else if (view instanceof QImageView) {
            ((QImageView) view).setImageBitmap(null);
        }
    }

    public final Bitmap b(alh com_tencent_mm_protocal_c_alh) {
        if (com_tencent_mm_protocal_c_alh.mQY == null || com_tencent_mm_protocal_c_alh.mQY.equals("")) {
            return null;
        }
        String an = i.an(1, com_tencent_mm_protocal_c_alh.mQY);
        String str = com_tencent_mm_protocal_c_alh.mQY;
        n EZ = EZ(an);
        if (i.a(EZ)) {
            return EZ.ww();
        }
        str = am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY);
        str = str + i.e(com_tencent_mm_protocal_c_alh);
        if (!FileOp.aO(str)) {
            return null;
        }
        if (com_tencent_mm_protocal_c_alh.mQY.startsWith("pre_temp_extend_pic")) {
            EZ = n.g(r.Gx(str));
        } else {
            EZ = i.EK(str);
        }
        if (!i.a(EZ)) {
            return null;
        }
        a(an, EZ);
        return EZ.ww();
    }

    public final String a(alh com_tencent_mm_protocal_c_alh) {
        String du = am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY);
        return du + i.e(com_tencent_mm_protocal_c_alh);
    }

    public final void b(alh com_tencent_mm_protocal_c_alh, View view, int i, an anVar) {
        b(com_tencent_mm_protocal_c_alh, view, -1, i, anVar);
    }

    public final void a(alh com_tencent_mm_protocal_c_alh, View view, int i, int i2, an anVar) {
        a(com_tencent_mm_protocal_c_alh, view, -1, i, i2, anVar);
    }

    public final n EZ(String str) {
        n nVar = (n) this.pSR.get(str);
        if (nVar != null && !nVar.isRecycled()) {
            return nVar;
        }
        this.pSR.remove(str);
        return null;
    }

    public final void b(alh com_tencent_mm_protocal_c_alh, View view, int i, int i2, an anVar) {
        a(com_tencent_mm_protocal_c_alh, view, i, i2, a.pTw, anVar);
    }

    public final void a(alh com_tencent_mm_protocal_c_alh, View view, int i, int i2, int i3, an anVar) {
        if (com_tencent_mm_protocal_c_alh != null && com_tencent_mm_protocal_c_alh.mQY != null && !com_tencent_mm_protocal_c_alh.mQY.equals("")) {
            view.setDrawingCacheEnabled(false);
            String an = i.an(0, com_tencent_mm_protocal_c_alh.mQY);
            a((Object) view, an, i, i2, i3);
            String str = com_tencent_mm_protocal_c_alh.mQY;
            n EZ = EZ(an);
            if (i.a(EZ)) {
                a((Object) view, an, EZ);
                return;
            }
            if (i == -1) {
                co(view);
            }
            if (!this.pTl.contains(an)) {
                a(0, com_tencent_mm_protocal_c_alh, anVar);
            }
        }
    }

    private static void a(Object obj, String str, n nVar) {
        long j = 0;
        if (obj != null) {
            if (nVar != null) {
                w.i("MicroMsg.LazyerImageLoader2", "setImageDrawable %s %s %s", new Object[]{obj, str, nVar.wA()});
            }
            Drawable drawable;
            if (obj instanceof QFadeImageView) {
                long j2;
                QFadeImageView qFadeImageView = (QFadeImageView) obj;
                drawable = qFadeImageView.mDrawable;
                if (!bg.mA(qFadeImageView.arH) && qFadeImageView.arH.equals(str)) {
                    j = qFadeImageView.mix;
                }
                if (drawable == null || !(drawable instanceof ah)) {
                    j2 = j;
                } else {
                    j2 = ((ah) drawable).mix;
                }
                Drawable ahVar = new ah(str, nVar, j2);
                qFadeImageView.mix = ahVar.mix;
                qFadeImageView.arH = str;
                qFadeImageView.setImageDrawable(ahVar);
                ahVar.invalidateSelf();
            } else if (obj instanceof QDisFadeImageView) {
                QDisFadeImageView qDisFadeImageView = (QDisFadeImageView) obj;
                drawable = new com.tencent.mm.memory.a.a(str, nVar);
                qDisFadeImageView.setImageDrawable(drawable);
                drawable.invalidateSelf();
            } else if (obj instanceof ImageView) {
                ImageView imageView = (ImageView) obj;
                drawable = imageView.getDrawable();
                if (drawable == null || !(drawable instanceof ah)) {
                    drawable = new ah(str, nVar, 0);
                } else {
                    drawable = new ah(str, nVar, ((ah) drawable).mix);
                }
                imageView.setImageDrawable(drawable);
                drawable.invalidateSelf();
            } else if (obj instanceof com.tencent.mm.plugin.sight.decode.a.a) {
                w.i("MicroMsg.LazyerImageLoader2", "update sight thumb " + str);
                if (obj instanceof SightPlayImageView) {
                    SightPlayImageView sightPlayImageView = (SightPlayImageView) obj;
                    drawable = sightPlayImageView.mDrawable;
                    if (drawable == null || !(drawable instanceof ah)) {
                        drawable = new ah(str, nVar, 0);
                    } else {
                        drawable = new ah(str, nVar, ((ah) drawable).mix);
                    }
                    sightPlayImageView.setImageDrawable(drawable);
                    drawable.invalidateSelf();
                }
            }
        }
    }

    public static String r(alh com_tencent_mm_protocal_c_alh) {
        if (com_tencent_mm_protocal_c_alh == null || com_tencent_mm_protocal_c_alh.mQY == null || com_tencent_mm_protocal_c_alh.mQY.equals("")) {
            return null;
        }
        String str = am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + i.e(com_tencent_mm_protocal_c_alh);
        if (FileOp.aO(str)) {
            return str;
        }
        return com_tencent_mm_protocal_c_alh.tPi;
    }

    public static String s(alh com_tencent_mm_protocal_c_alh) {
        if (com_tencent_mm_protocal_c_alh == null || com_tencent_mm_protocal_c_alh.mQY == null || com_tencent_mm_protocal_c_alh.mQY.equals("")) {
            return null;
        }
        String str = am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + i.d(com_tencent_mm_protocal_c_alh);
        if (FileOp.aO(str)) {
            return str;
        }
        return com_tencent_mm_protocal_c_alh.msN;
    }

    public final void a(alh com_tencent_mm_protocal_c_alh, View view, int i, an anVar) {
        c(com_tencent_mm_protocal_c_alh, view, -1, i, anVar);
    }

    public final boolean a(m mVar, final alh com_tencent_mm_protocal_c_alh, com.tencent.mm.plugin.sight.decode.a.a aVar, int i, int i2, final an anVar, boolean z) {
        if (com_tencent_mm_protocal_c_alh == null || com_tencent_mm_protocal_c_alh.mQY == null || com_tencent_mm_protocal_c_alh.mQY.equals("")) {
            return false;
        }
        String an = i.an(1, com_tencent_mm_protocal_c_alh.mQY);
        a((Object) aVar, an, -1, i);
        if (!FileOp.aO(am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + i.e(com_tencent_mm_protocal_c_alh))) {
            com.tencent.mm.plugin.sns.data.e eVar = new com.tencent.mm.plugin.sns.data.e(com_tencent_mm_protocal_c_alh);
            eVar.pQS = 1;
            eVar.nif = com_tencent_mm_protocal_c_alh.mQY;
            ae.beG().a(com_tencent_mm_protocal_c_alh, 1, eVar, anVar);
        }
        String str = "";
        if (z) {
            if (!u(com_tencent_mm_protocal_c_alh)) {
                str = am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY);
                String j = i.j(com_tencent_mm_protocal_c_alh);
                if (FileOp.aO(str + j)) {
                    str = str + j;
                } else if (FileOp.aO(str + i.p(com_tencent_mm_protocal_c_alh)) && com_tencent_mm_protocal_c_alh.mQY != null && com_tencent_mm_protocal_c_alh.mQY.startsWith("Locall_path")) {
                    str = str + i.p(com_tencent_mm_protocal_c_alh);
                } else if (this.pSE) {
                    w.i("MicroMsg.LazyerImageLoader2", "push sight loader " + com_tencent_mm_protocal_c_alh.mQY + " url: " + com_tencent_mm_protocal_c_alh.msN);
                    if (!z) {
                        w.i("MicroMsg.LazyerImageLoader2", "do no auto download sns sight.");
                    } else if (b(mVar, null) == 5) {
                        ae.ayz().postDelayed(new Runnable(this) {
                            final /* synthetic */ g pTn;

                            public final void run() {
                                ae.beG().a(com_tencent_mm_protocal_c_alh, 4, null, anVar);
                            }
                        }, 0);
                    }
                }
            }
            str = "";
        }
        w.i("MicroMsg.LazyerImageLoader2", "setsight %s sightPath %s isAd %b", new Object[]{an, str, Boolean.valueOf(z)});
        if (bg.mA(str) || u(com_tencent_mm_protocal_c_alh)) {
            w.i("MicroMsg.LazyerImageLoader2", "sightPath %s", new Object[]{str});
            aVar.ak(null, !this.pSE);
            str = com_tencent_mm_protocal_c_alh.mQY;
            n EZ = EZ(an);
            w.v("MicroMsg.LazyerImageLoader2", "setsight thumb  %s", new Object[]{Boolean.valueOf(i.a(EZ))});
            if (i.a(EZ)) {
                a((Object) aVar, an, EZ);
                return true;
            }
            if ((aVar instanceof ImageView) || (aVar instanceof QFadeImageView)) {
                co((View) aVar);
            } else if (aVar instanceof com.tencent.mm.plugin.sight.decode.a.a) {
                aVar.ak(null, !this.pSE);
                aVar.kj(0);
                aVar.y(null);
            }
            if (this.pTl.contains(an)) {
                return false;
            }
            a(1, com_tencent_mm_protocal_c_alh, anVar);
            return false;
        }
        if (!str.equals(aVar.Ls())) {
            aVar.y(null);
        }
        aVar.ak(str, !this.pSE);
        aVar.kj(i2);
        return true;
    }

    public final void d(alh com_tencent_mm_protocal_c_alh, View view, int i, an anVar) {
        if (com_tencent_mm_protocal_c_alh != null && com_tencent_mm_protocal_c_alh.mQY != null && !com_tencent_mm_protocal_c_alh.mQY.equals("")) {
            String an = i.an(4, com_tencent_mm_protocal_c_alh.mQY);
            a((Object) view, an, -1, i);
            String str = com_tencent_mm_protocal_c_alh.mQY;
            n EZ = EZ(an);
            boolean a = i.a(EZ);
            w.v("MicroMsg.LazyerImageLoader2", "set sns Thumb  " + a);
            if (a) {
                a((Object) view, an, EZ);
                return;
            }
            co(view);
            if (!this.pTl.contains(an)) {
                a(4, com_tencent_mm_protocal_c_alh, anVar);
            }
        }
    }

    public final boolean c(alh com_tencent_mm_protocal_c_alh, View view, int i, int i2, an anVar) {
        if (com_tencent_mm_protocal_c_alh == null || com_tencent_mm_protocal_c_alh.mQY == null || com_tencent_mm_protocal_c_alh.mQY.equals("")) {
            return false;
        }
        String an = i.an(1, com_tencent_mm_protocal_c_alh.mQY);
        a((Object) view, an, i, i2);
        String str = com_tencent_mm_protocal_c_alh.mQY;
        n EZ = EZ(an);
        boolean a = i.a(EZ);
        w.v("MicroMsg.LazyerImageLoader2", "set sns Thumb  " + a + an);
        if (a) {
            a((Object) view, an, EZ);
            return true;
        }
        if (i == -1) {
            co(view);
        }
        if (this.pTl.contains(an)) {
            return true;
        }
        a(1, com_tencent_mm_protocal_c_alh, anVar);
        return false;
    }

    private static void co(View view) {
        if (view instanceof QImageView) {
            ((QImageView) view).a(com.tencent.mm.ui.widget.QImageView.a.wxo);
            ((QImageView) view).setImageResource(com.tencent.mm.plugin.sns.i.e.pzy);
        } else if (view instanceof ImageView) {
            ((ImageView) view).setImageResource(com.tencent.mm.plugin.sns.i.e.pzy);
        }
    }

    public final void a(Object obj, String str, int i, int i2) {
        a(obj, str, true, i, i2, -1, -1, a.pTw);
    }

    private void a(Object obj, String str, int i, int i2, int i3) {
        a(obj, str, true, i, i2, -1, -1, i3);
    }

    private void a(Object obj, String str, boolean z, int i, int i2, int i3, int i4, int i5) {
        if (obj != null) {
            int hashCode = obj.hashCode();
            this.pSX.remove(new c(null, hashCode, 0, false));
            c cVar = new c(str, hashCode, i2, z);
            this.pSX.add(cVar);
            LinkedList linkedList = (LinkedList) this.pST.get(str);
            if (linkedList == null) {
                linkedList = new LinkedList();
                this.pST.put(str, linkedList);
            }
            linkedList.add(new WeakReference(cVar));
            String str2 = (String) ((View) obj).getTag(2130706432);
            if (str2 != null) {
                LinkedList linkedList2 = (LinkedList) this.pST.get(str2);
                if (linkedList2 != null) {
                    int i6 = 0;
                    while (i6 < linkedList2.size()) {
                        c cVar2 = (c) ((WeakReference) linkedList2.get(i6)).get();
                        if (cVar2 != null && cVar2.code == hashCode) {
                            break;
                        }
                        i6++;
                    }
                    i6 = -1;
                    if (i6 != -1) {
                        w.v("MicroMsg.LazyerImageLoader2", "updateImageViewToKey remove last pair %s", new Object[]{str2});
                        linkedList2.remove(i6);
                    }
                }
            }
            ((View) obj).setTag(2130706432, str);
            this.hFI.put(Integer.valueOf(hashCode), new WeakReference(obj));
            if (i != -1) {
                if (obj instanceof QFadeImageView) {
                    ((QFadeImageView) obj).setImageResource(i);
                } else if (obj instanceof ImageView) {
                    ((ImageView) obj).setImageDrawable(com.tencent.mm.bg.a.a(((ImageView) obj).getContext(), i));
                } else {
                    ((com.tencent.mm.plugin.sight.decode.a.a) obj).ak(null, !this.pSE);
                }
            }
            if (i5 == a.pTx && ((obj instanceof ImageView) || (obj instanceof QFadeImageView))) {
                k.bB((View) obj);
            } else if (str != null && str.startsWith(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                if ((obj instanceof ImageView) || (obj instanceof QFadeImageView)) {
                    k.i((View) obj, i3, i4);
                    w.d("MicroMsg.LazyerImageLoader2", "try to setlayerType " + i3 + " " + i4);
                }
            }
        }
    }

    public final boolean cp(View view) {
        int hashCode = view.hashCode();
        Iterator it = this.pSX.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (hashCode == cVar.code) {
                this.pSX.remove(cVar);
                break;
            }
        }
        this.hFI.remove(Integer.valueOf(hashCode));
        return true;
    }

    public final boolean beb() {
        if (this.pSW) {
            w.i("MicroMsg.LazyerImageLoader2", "loaderlist size runing pass");
            return false;
        }
        ae.ayz().postDelayed(new Runnable(this) {
            final /* synthetic */ g pTn;

            {
                this.pTn = r1;
            }

            public final void run() {
                if (this.pTn.pSW) {
                    w.i("MicroMsg.LazyerImageLoader2", "loaderlist size runing pass");
                } else if (this.pTn.pSV.size() > 0) {
                    w.i("MicroMsg.LazyerImageLoader2", "tryStart loaderlist size:" + this.pTn.pSV.size());
                    ((b) this.pTn.pSV.removeLast()).l("");
                }
            }
        }, 0);
        return true;
    }

    public final boolean a(int i, alh com_tencent_mm_protocal_c_alh) {
        if (!this.pSE) {
            return false;
        }
        String g;
        final String du = am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY);
        if (i == 4) {
            g = i.g(com_tencent_mm_protocal_c_alh);
        } else if (i == 5) {
            g = i.h(com_tencent_mm_protocal_c_alh);
        } else if (i == 0) {
            g = i.f(com_tencent_mm_protocal_c_alh);
        } else {
            g = i.e(com_tencent_mm_protocal_c_alh);
        }
        String e = i.e(com_tencent_mm_protocal_c_alh);
        if (com.tencent.mm.plugin.sns.model.a.b.FJ(com_tencent_mm_protocal_c_alh.mQY)) {
            return false;
        }
        long NA = bg.NA();
        boolean aO = FileOp.aO(du + e);
        if (!aO) {
            aO = FileOp.aO(du + i.l(com_tencent_mm_protocal_c_alh));
        }
        if (!aO) {
            FileOp.aO(du + i.m(com_tencent_mm_protocal_c_alh));
        }
        NA = bg.aB(NA);
        if (NA > 100) {
            w.i("MicroMsg.LazyerImageLoader2", "fileexist check  endtime " + NA + " " + Thread.currentThread().getName() + " " + com.tencent.mm.compatible.util.e.hgs + " " + ae.beZ() + " " + com_tencent_mm_protocal_c_alh.mQY);
        }
        if (bg.aB(this.pSP) > 60000) {
            com.tencent.mm.plugin.report.service.g.oUh.i(11696, new Object[]{Integer.valueOf(1), Long.valueOf(NA), Integer.valueOf(0), Thread.currentThread().getName(), ae.beZ(), com.tencent.mm.compatible.util.e.hgs});
            this.pSP = bg.NA();
        }
        if (!FileOp.aO(du + e) && !FileOp.aO(du + i.l(com_tencent_mm_protocal_c_alh)) && !FileOp.aO(du + i.m(com_tencent_mm_protocal_c_alh))) {
            return false;
        }
        final int i2 = i;
        final alh com_tencent_mm_protocal_c_alh2 = com_tencent_mm_protocal_c_alh;
        ae.ayz().post(new Runnable(this) {
            final /* synthetic */ g pTn;

            public final void run() {
                while (this.pTn.pSV.size() >= 60) {
                    this.pTn.pTl.remove(((b) this.pTn.pSV.removeFirst()).arH);
                }
                w.i("MicroMsg.LazyerImageLoader2", "add loaderlist size:" + this.pTn.pSV.size());
                b bVar = new b(this.pTn, i.an(i2, com_tencent_mm_protocal_c_alh2.mQY), du + g, du, com_tencent_mm_protocal_c_alh2, i2);
                if (this.pTn.pSR.aV(bVar.arH)) {
                    this.pTn.pTl.remove(bVar.arH);
                } else {
                    this.pTn.pSV.add(bVar);
                }
                this.pTn.beb();
            }
        });
        return true;
    }

    private boolean a(final int i, final alh com_tencent_mm_protocal_c_alh, final an anVar) {
        if (!this.pSE) {
            return false;
        }
        ae.bey().post(new Runnable(this) {
            final /* synthetic */ g pTn;

            public final void run() {
                if (!this.pTn.a(i, com_tencent_mm_protocal_c_alh)) {
                    com.tencent.mm.plugin.sns.data.e eVar = new com.tencent.mm.plugin.sns.data.e(com_tencent_mm_protocal_c_alh);
                    eVar.pQS = i;
                    eVar.nif = com_tencent_mm_protocal_c_alh.mQY;
                    ae.beG().a(com_tencent_mm_protocal_c_alh, 1, eVar, anVar);
                }
            }
        });
        return true;
    }

    public static boolean t(alh com_tencent_mm_protocal_c_alh) {
        String du = am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY);
        if (FileOp.aO(du + i.j(com_tencent_mm_protocal_c_alh))) {
            return true;
        }
        if (FileOp.aO(du + i.p(com_tencent_mm_protocal_c_alh)) && !bg.mA(com_tencent_mm_protocal_c_alh.mQY) && com_tencent_mm_protocal_c_alh.mQY.startsWith("Locall_path")) {
            return true;
        }
        return false;
    }

    public final int k(m mVar) {
        return a(mVar, null);
    }

    public final int a(m mVar, int[] iArr) {
        int i;
        int i2 = 5;
        if (iArr != null || bg.aB(this.pTb) > 60000) {
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            PInt pInt3 = new PInt();
            com.tencent.mm.modelcontrol.c.Er();
            if (com.tencent.mm.modelcontrol.c.a(pInt, pInt2, pInt3)) {
                this.pTd = 5;
            } else {
                this.pTd = 10;
            }
            if (iArr != null) {
                if (pInt.value == 0) {
                    i = 0;
                } else {
                    i = 1;
                }
                iArr[0] = i;
                iArr[1] = pInt2.value;
                iArr[2] = pInt3.value;
            }
            this.pTe = pInt.value;
            this.pTb = bg.NA();
        }
        if (this.pTe == 0 || mVar == null) {
            return this.pTd;
        }
        if (this.pTf.containsKey(Long.valueOf(mVar.field_snsId))) {
            return ((Integer) this.pTf.get(Long.valueOf(mVar.field_snsId))).intValue();
        }
        bbs com_tencent_mm_protocal_c_bbs = new bbs();
        try {
            bbk com_tencent_mm_protocal_c_bbk = (bbk) new bbk().aD(mVar.field_attrBuf);
            if (com_tencent_mm_protocal_c_bbk.ucA == null) {
                return this.pTd;
            }
            com_tencent_mm_protocal_c_bbs.aD(com_tencent_mm_protocal_c_bbk.ucA.tZp.sYA);
            if (com_tencent_mm_protocal_c_bbs.ucP == null || com_tencent_mm_protocal_c_bbs.ucP.info == null) {
                return this.pTd;
            }
            String str = com_tencent_mm_protocal_c_bbs.ucP.info;
            int hashCode = str.hashCode();
            if (this.pTe == 1) {
                if (!this.pTh.containsKey(Integer.valueOf(hashCode))) {
                    this.pTh.put(Integer.valueOf(hashCode), Boolean.valueOf(bE(str, this.pTe)));
                }
                i = ((Boolean) this.pTh.get(Integer.valueOf(hashCode))).booleanValue() ? 5 : 10;
            } else {
                if (!this.pTg.containsKey(Integer.valueOf(hashCode))) {
                    this.pTg.put(Integer.valueOf(hashCode), Boolean.valueOf(bE(str, this.pTe)));
                }
                if (!((Boolean) this.pTg.get(Integer.valueOf(hashCode))).booleanValue()) {
                    i2 = 10;
                }
                i = i2;
            }
            w.i("MicroMsg.LazyerImageLoader2", "isAutoDownload(sight_autodownload) snsID:%d, result:%d", new Object[]{Long.valueOf(mVar.field_snsId), Integer.valueOf(i)});
            this.pTf.put(Long.valueOf(mVar.field_snsId), Integer.valueOf(i));
            return i;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.LazyerImageLoader2", e, "", new Object[0]);
            return this.pTd;
        }
    }

    public final int l(m mVar) {
        return b(mVar, null);
    }

    public final int b(m mVar, int[] iArr) {
        int i;
        int i2 = 5;
        if (iArr != null || bg.aB(this.pTc) > 60000) {
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            com.tencent.mm.modelcontrol.c.Er();
            if (com.tencent.mm.modelcontrol.c.a(pInt, pInt2)) {
                this.pTi = 5;
            } else {
                this.pTi = 10;
            }
            if (iArr != null) {
                if (pInt.value == 0) {
                    i = 0;
                } else {
                    i = 1;
                }
                iArr[0] = i;
                iArr[1] = pInt2.value;
            }
            this.pTj = pInt.value;
            this.pTc = bg.NA();
        }
        if (this.pTj == 0 || mVar == null) {
            return this.pTi;
        }
        if (this.pTk.containsKey(Long.valueOf(mVar.field_snsId))) {
            return ((Integer) this.pTk.get(Long.valueOf(mVar.field_snsId))).intValue();
        }
        bbs com_tencent_mm_protocal_c_bbs = new bbs();
        try {
            bbk com_tencent_mm_protocal_c_bbk = (bbk) new bbk().aD(mVar.field_attrBuf);
            if (com_tencent_mm_protocal_c_bbk.ucA == null) {
                return this.pTi;
            }
            com_tencent_mm_protocal_c_bbs.aD(com_tencent_mm_protocal_c_bbk.ucA.tZp.sYA);
            if (com_tencent_mm_protocal_c_bbs.ucP == null || com_tencent_mm_protocal_c_bbs.ucP.info == null) {
                return this.pTd;
            }
            String str = com_tencent_mm_protocal_c_bbs.ucP.info;
            int hashCode = str.hashCode();
            if (this.pTj == 1) {
                if (!this.pTh.containsKey(Integer.valueOf(hashCode))) {
                    this.pTh.put(Integer.valueOf(hashCode), Boolean.valueOf(bE(str, this.pTj)));
                }
                i = ((Boolean) this.pTh.get(Integer.valueOf(hashCode))).booleanValue() ? 5 : 10;
            } else {
                if (!this.pTg.containsKey(Integer.valueOf(hashCode))) {
                    this.pTg.put(Integer.valueOf(hashCode), Boolean.valueOf(bE(str, this.pTj)));
                }
                if (!((Boolean) this.pTg.get(Integer.valueOf(hashCode))).booleanValue()) {
                    i2 = 10;
                }
                i = i2;
            }
            w.i("MicroMsg.LazyerImageLoader2", "isAutoAdDownload(sight_autodownload) snsID:%d, result:%d", new Object[]{Long.valueOf(mVar.field_snsId), Integer.valueOf(i)});
            this.pTk.put(Long.valueOf(mVar.field_snsId), Integer.valueOf(i));
            return i;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.LazyerImageLoader2", e, "", new Object[0]);
            return this.pTi;
        }
    }

    private static boolean bE(String str, int i) {
        Map q = bh.q(str, "SightDownloadControl");
        if (q == null || q.isEmpty()) {
            return true;
        }
        return i == 1 ? bg.getInt((String) q.get(".SightDownloadControl.G3PlusAutoDownload"), 0) == 1 : bg.getInt((String) q.get(".SightDownloadControl.WifiAutoDownload"), 0) == 1;
    }

    public final boolean u(alh com_tencent_mm_protocal_c_alh) {
        if (!this.pSY.containsKey(com_tencent_mm_protocal_c_alh.mQY)) {
            return false;
        }
        if (((Integer) this.pSY.get(com_tencent_mm_protocal_c_alh.mQY)).intValue() == 1) {
            return true;
        }
        return false;
    }

    public final boolean v(alh com_tencent_mm_protocal_c_alh) {
        if (this.pSY.containsKey(com_tencent_mm_protocal_c_alh.mQY)) {
            return ((Integer) this.pSY.get(com_tencent_mm_protocal_c_alh.mQY)).intValue() == 2;
        } else {
            return false;
        }
    }

    public final boolean w(alh com_tencent_mm_protocal_c_alh) {
        if (this.pSY.containsKey(com_tencent_mm_protocal_c_alh.mQY)) {
            return ((Integer) this.pSY.get(com_tencent_mm_protocal_c_alh.mQY)).intValue() == 3;
        } else {
            return false;
        }
    }

    public final void x(alh com_tencent_mm_protocal_c_alh) {
        this.pSY.put(com_tencent_mm_protocal_c_alh.mQY, Integer.valueOf(1));
    }

    public final void y(alh com_tencent_mm_protocal_c_alh) {
        this.pSY.put(com_tencent_mm_protocal_c_alh.mQY, Integer.valueOf(2));
    }

    public final void z(alh com_tencent_mm_protocal_c_alh) {
        this.pSY.put(com_tencent_mm_protocal_c_alh.mQY, Integer.valueOf(3));
    }

    public final boolean ds(String str, String str2) {
        if (this.pSY.containsKey(str) && 3 == ((Integer) this.pSY.get(str)).intValue()) {
            this.pSY.remove(str);
        }
        String an = i.an(1, str);
        Iterator it = ((LinkedList) this.pST.get(an)).iterator();
        while (it.hasNext()) {
            c cVar = (c) ((WeakReference) it.next()).get();
            if (cVar != null && cVar.pTB && an != null && an.equals(cVar.id)) {
                WeakReference weakReference = (WeakReference) this.hFI.get(Integer.valueOf(cVar.code));
                if (weakReference != null) {
                    Object obj = weakReference.get();
                    if (obj != null && (obj instanceof com.tencent.mm.plugin.sight.decode.a.a)) {
                        w.i("MicroMsg.LazyerImageLoader2", "download fin set sight %s %s", new Object[]{str, str2});
                        com.tencent.mm.plugin.sight.decode.a.a aVar = (com.tencent.mm.plugin.sight.decode.a.a) obj;
                        if (aVar.bbT() instanceof aj) {
                            aj ajVar = (aj) aVar.bbT();
                            if (ajVar == null) {
                                aVar.ak(str2, !this.pSE);
                            } else if (FileOp.aO(str2)) {
                                aVar.ak(str2, !this.pSE);
                                aVar.kj(ajVar.position);
                                ajVar.qxE.setVisibility(8);
                                ajVar.qjB.setVisibility(8);
                                ajVar.qjE.setVisibility(8);
                                if (this.pSY.containsKey(str) && 4 == ((Integer) this.pSY.get(str)).intValue()) {
                                    this.pSY.remove(str);
                                }
                            } else {
                                this.pSY.put(str, Integer.valueOf(4));
                                ajVar.qxE.setVisibility(8);
                                ajVar.qjB.setImageResource(com.tencent.mm.plugin.sns.i.e.bjR);
                                ajVar.qjB.setVisibility(0);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public final boolean a(String str, n nVar, int i) {
        a(i + "-" + str, nVar);
        return true;
    }

    public final boolean a(String str, n nVar) {
        if (!(nVar == null || str == null)) {
            this.pSR.put(str, nVar);
        }
        return true;
    }

    public final void Fa(String str) {
        b(str, null);
    }

    public static Bitmap a(String str, String str2, String str3, boolean z, an anVar) {
        if (!z && bg.mA(str)) {
            return null;
        }
        alh a = com.tencent.mm.modelsns.e.a(str3, 2, str2, str2, 1, 1, "");
        i.an(2, str3);
        Bitmap EJ;
        if (str3.equals("")) {
            EJ = i.EJ(str);
            if (i.k(EJ)) {
                return EJ;
            }
            return null;
        } else if (i.k(null)) {
            return null;
        } else {
            EJ = i.EJ(am.du(ae.getAccSnsPath(), str3) + i.l(a));
            if (!i.k(EJ)) {
                EJ = i.EJ(str);
            }
            if (EJ == null && z && !bg.mA(str2)) {
                ae.beG().a(a, 3, null, anVar);
            }
            if (i.k(EJ)) {
                return EJ;
            }
            return null;
        }
    }

    public final boolean A(alh com_tencent_mm_protocal_c_alh) {
        if (com_tencent_mm_protocal_c_alh == null || com_tencent_mm_protocal_c_alh.mQY == null || com_tencent_mm_protocal_c_alh.mQY.equals("")) {
            return false;
        }
        if (FileOp.aO(am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + i.f(com_tencent_mm_protocal_c_alh)) || FileOp.aO(am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + i.e(com_tencent_mm_protocal_c_alh))) {
            return true;
        }
        return i.a((n) this.pSR.get(i.an(1, com_tencent_mm_protocal_c_alh.mQY)));
    }

    public static boolean a(alh com_tencent_mm_protocal_c_alh, an anVar) {
        if (com_tencent_mm_protocal_c_alh == null || com_tencent_mm_protocal_c_alh.mQY == null || com_tencent_mm_protocal_c_alh.mQY.equals("")) {
            return false;
        }
        String str;
        if (com_tencent_mm_protocal_c_alh.mQY.startsWith("Locall_path")) {
            str = am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + i.m(com_tencent_mm_protocal_c_alh);
        } else {
            str = am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + i.d(com_tencent_mm_protocal_c_alh);
        }
        if (FileOp.aO(str)) {
            return true;
        }
        ae.beG().a(com_tencent_mm_protocal_c_alh, 2, null, anVar);
        return false;
    }

    public static String B(alh com_tencent_mm_protocal_c_alh) {
        if (com_tencent_mm_protocal_c_alh.mQY.startsWith("pre_temp_sns_pic")) {
            return ae.getAccSnsTmpPath() + com_tencent_mm_protocal_c_alh.mQY;
        }
        if (com_tencent_mm_protocal_c_alh.mQY.startsWith("Locall_path")) {
            return am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + i.m(com_tencent_mm_protocal_c_alh);
        }
        if (com_tencent_mm_protocal_c_alh.mQY.startsWith("pre_temp_extend_pic")) {
            return com_tencent_mm_protocal_c_alh.mQY.substring(19);
        }
        return am.du(ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + i.d(com_tencent_mm_protocal_c_alh);
    }

    public final Bitmap a(alh com_tencent_mm_protocal_c_alh, View view, int i, boolean z, an anVar) {
        if (com_tencent_mm_protocal_c_alh == null || com_tencent_mm_protocal_c_alh.mQY == null || com_tencent_mm_protocal_c_alh.mQY.equals("")) {
            return null;
        }
        String an = i.an(3, com_tencent_mm_protocal_c_alh.mQY);
        String B = B(com_tencent_mm_protocal_c_alh);
        int i2 = -1;
        int i3 = -1;
        try {
            Options Pe = d.Pe(B);
            i2 = Pe.outWidth;
            i3 = Pe.outHeight;
        } catch (Exception e) {
        }
        a(view, an, false, -1, i, i2, i3, a.pTw);
        if ((ae.beG().pSG.containsKey(i.ao(2, com_tencent_mm_protocal_c_alh.mQY)) ? 1 : null) != null) {
            return null;
        }
        Object obj;
        ak akVar = this.pSS;
        com.tencent.mm.plugin.sns.model.ak.b bVar = (com.tencent.mm.plugin.sns.model.ak.b) akVar.pWX.get(an);
        if (bVar == null) {
            obj = null;
        } else {
            ((com.tencent.mm.plugin.sns.model.ak.b) akVar.pWX.get(an)).bfi();
            obj = bVar.obj;
        }
        WeakReference weakReference = (WeakReference) obj;
        w.i("MicroMsg.LazyerImageLoader2", "getFromWeakReference " + an + "  " + (weakReference == null));
        Bitmap bitmap = weakReference == null ? null : (Bitmap) weakReference.get();
        if (i.k(bitmap)) {
            return bitmap;
        }
        Bitmap Gx;
        if (com_tencent_mm_protocal_c_alh.mQY.startsWith("pre_temp_extend_pic")) {
            Gx = r.Gx(B);
        } else {
            Gx = i.EJ(B);
        }
        ak akVar2 = this.pSS;
        WeakReference weakReference2 = new WeakReference(Gx);
        if (((com.tencent.mm.plugin.sns.model.ak.b) akVar2.pWX.get(an)) == null) {
            akVar2.pWX.put(an, new com.tencent.mm.plugin.sns.model.ak.b(akVar2, weakReference2));
            akVar2.bfh();
        } else {
            ((com.tencent.mm.plugin.sns.model.ak.b) akVar2.pWX.get(an)).bfi();
            ((com.tencent.mm.plugin.sns.model.ak.b) akVar2.pWX.get(an)).obj = weakReference2;
        }
        if (i.k(Gx)) {
            return Gx;
        }
        if (z) {
            ae.beG().a(com_tencent_mm_protocal_c_alh, 2, null, anVar);
        }
        return null;
    }

    public final n a(alh com_tencent_mm_protocal_c_alh, ImageView imageView, int i, an anVar) {
        if (com_tencent_mm_protocal_c_alh == null || com_tencent_mm_protocal_c_alh.mQY == null || com_tencent_mm_protocal_c_alh.mQY.equals("")) {
            return null;
        }
        imageView.setDrawingCacheEnabled(false);
        String an = i.an(0, com_tencent_mm_protocal_c_alh.mQY);
        a((Object) imageView, an, -1, i);
        String str = com_tencent_mm_protocal_c_alh.mQY;
        n EZ = EZ(an);
        if (i.a(EZ)) {
            return EZ;
        }
        a(0, com_tencent_mm_protocal_c_alh, anVar);
        return null;
    }

    public final void a(View view, int i, int i2, int i3) {
        a(view, null, true, -1, i3, -1, -1, a.pTw);
        if (i != -1) {
            view.setBackgroundResource(i);
        }
        if (i2 != -1) {
            if (view instanceof QFadeImageView) {
                ((QFadeImageView) view).setImageResource(i2);
            } else if (view instanceof ImageView) {
                ((ImageView) view).setImageDrawable(com.tencent.mm.bg.a.a(view.getContext(), i2));
            }
        } else if (view instanceof QFadeImageView) {
            ((QFadeImageView) view).setImageResource(com.tencent.mm.plugin.sns.i.e.pzy);
        } else if (view instanceof ImageView) {
            ((ImageView) view).setImageResource(com.tencent.mm.plugin.sns.i.e.pzy);
        }
    }

    public final void a(List<alh> list, View view, int i, int i2, a aVar) {
        a((List) list, view, i, i2, (an) aVar, false);
    }

    public final void a(List<alh> list, View view, int i, int i2, a aVar, boolean z) {
        if (list != null && list.size() != 0) {
            String an;
            n EZ;
            if (list.size() != 1) {
                an = i.an(0, i.bo(list));
                a(view, an, true, -1, i, -1, -1, i2);
                EZ = EZ(an);
                boolean a = i.a(EZ);
                w.v("MicroMsg.LazyerImageLoader2", "set Sns GridList " + a);
                if (a) {
                    a((Object) view, an, EZ);
                    return;
                }
                co(view);
                if (!this.pTl.contains(an)) {
                    WeakReference weakReference = new WeakReference(view);
                    ae.bey().post(new AnonymousClass4(this, list, 0, aVar));
                }
            } else if (z) {
                alh com_tencent_mm_protocal_c_alh = (alh) list.get(0);
                int i3 = a.pTx;
                if (com_tencent_mm_protocal_c_alh != null && com_tencent_mm_protocal_c_alh.mQY != null && !com_tencent_mm_protocal_c_alh.mQY.equals("")) {
                    view.setDrawingCacheEnabled(false);
                    an = i.an(5, com_tencent_mm_protocal_c_alh.mQY);
                    a((Object) view, an, -1, i, i3);
                    String str = com_tencent_mm_protocal_c_alh.mQY;
                    EZ = EZ(an);
                    if (i.a(EZ)) {
                        a((Object) view, an, EZ);
                        return;
                    }
                    co(view);
                    if (!this.pTl.contains(an)) {
                        a(5, com_tencent_mm_protocal_c_alh, (an) aVar);
                    }
                }
            } else {
                b((alh) list.get(0), view, i, aVar);
            }
        }
    }

    protected final void b(String str, n nVar) {
        if (!i.a(nVar)) {
            n nVar2 = (n) this.pSR.get(str);
            if (nVar2 == null || nVar2.isRecycled()) {
                this.pSR.remove(str);
                nVar2 = null;
            }
            nVar = nVar2;
        }
        if (i.a(nVar)) {
            if (!(this.pSR == null || nVar == null || str == null)) {
                this.pSR.put(str, nVar);
            }
            LinkedList linkedList = (LinkedList) this.pST.get(str);
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    c cVar = (c) ((WeakReference) it.next()).get();
                    if (cVar != null && cVar.pTB && str != null && str.equals(cVar.id)) {
                        WeakReference weakReference = (WeakReference) this.hFI.get(Integer.valueOf(cVar.code));
                        if (weakReference != null) {
                            Object obj = weakReference.get();
                            if (obj != null) {
                                if (obj instanceof QFadeImageView) {
                                    QFadeImageView qFadeImageView = (QFadeImageView) obj;
                                    if (this.pTa != null && (qFadeImageView instanceof TagImageView)) {
                                        int i = ((TagImageView) qFadeImageView).position;
                                        if (!(i == -1 || this.pTa.tN(i))) {
                                        }
                                    }
                                }
                                if (!i.a(nVar) || obj == null) {
                                    String str2 = "MicroMsg.LazyerImageLoader2";
                                    String str3 = "setRefImageView null bmNUll: %s ivNull: %s bimapavailable %s";
                                    Object[] objArr = new Object[3];
                                    objArr[0] = Boolean.valueOf(nVar == null);
                                    objArr[1] = Boolean.valueOf(obj == null);
                                    objArr[2] = Boolean.valueOf(i.a(nVar));
                                    w.d(str2, str3, objArr);
                                } else {
                                    a(obj, str, nVar);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final void bdw() {
        bea();
        this.pTb = 0;
        this.pTc = 0;
        this.pSV.clear();
        this.pSW = false;
    }
}
