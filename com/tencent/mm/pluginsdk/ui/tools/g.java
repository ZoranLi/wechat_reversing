package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;

public class g {
    public byte[] hAl = new byte[0];
    public ae hgN;
    public volatile boolean sVP = false;
    private HandlerThread sVQ = com.tencent.mm.sdk.f.e.Qu("ImageEngine_handlerThread" + System.currentTimeMillis());
    private ae sVR;
    public HashMap<String, ImageView> sVS = new HashMap();
    public HashMap<ImageView, String> sVT = new HashMap();
    public c<String, Bitmap> sVU;
    private SparseArray<Bitmap> sVV;
    public a<e> sVW;
    public a<b> sVX;
    private boolean sVY = true;
    private com.tencent.mm.platformtools.j.a sVZ = new com.tencent.mm.platformtools.j.a(this) {
        final /* synthetic */ g sWa;

        {
            this.sWa = r1;
        }

        public final void k(String str, final Bitmap bitmap) {
            boolean z = false;
            String str2 = "MicroMsg.ImageEngine";
            String str3 = "on get picture finish, notifyKey[%s], bitmap is null[%B]";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (bitmap == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            w.v(str2, str3, objArr);
            if (bitmap != null) {
                this.sWa.sVU.put(str, bitmap);
                final ImageView imageView = (ImageView) this.sWa.sVS.get(str);
                if (imageView != null) {
                    this.sWa.sVT.remove(imageView);
                    this.sWa.hgN.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass6 sWe;

                        public final void run() {
                            d.b(imageView, bitmap);
                        }
                    });
                }
                this.sWa.sVS.remove(str);
            }
        }
    };

    private abstract class a<T> {
        private ae handler;
        final /* synthetic */ g sWa;
        final int sWf = Math.max(1, 16);
        LinkedList<T> sWg = new LinkedList();

        protected abstract T bGB();

        public a(final g gVar, int i, Looper looper) {
            this.sWa = gVar;
            this.handler = new ae(this, looper) {
                final /* synthetic */ a sWi;

                public final void handleMessage(Message message) {
                    a aVar = this.sWi;
                    Object obj = message.obj;
                    if (obj != null && aVar.sWg.size() < aVar.sWf) {
                        aVar.sWg.add(obj);
                    }
                }
            };
        }

        public final T bGC() {
            if (this.sWg.isEmpty()) {
                return bGB();
            }
            return this.sWg.removeFirst();
        }

        public final void B(T t) {
            this.handler.sendMessage(this.handler.obtainMessage(1, t));
        }
    }

    private class b implements Runnable {
        public int lKi;
        public int neJ;
        final /* synthetic */ g sWa;
        public String[] sWj;
        public String sWk;
        public String url;

        public b(g gVar) {
            this.sWa = gVar;
        }

        private Bitmap No(String str) {
            if (str == null) {
                return null;
            }
            if (this.lKi <= 0 || this.neJ <= 0) {
                return j.mt(str);
            }
            String str2 = str + "_" + this.neJ + "_" + this.lKi;
            Bitmap l = j.l(str2, this.neJ, this.lKi);
            if (l != null) {
                return l;
            }
            int Pc = ExifHelper.Pc(str);
            if (90 == Pc || 270 == Pc) {
                l = com.tencent.mm.sdk.platformtools.d.d(str, this.neJ, this.lKi, true);
            } else {
                l = com.tencent.mm.sdk.platformtools.d.d(str, this.lKi, this.neJ, true);
            }
            if (l == null) {
                return l;
            }
            l = com.tencent.mm.sdk.platformtools.d.b(l, (float) Pc);
            try {
                com.tencent.mm.sdk.platformtools.d.a(l, 100, CompressFormat.PNG, str2, false);
                return l;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.ImageEngine", e, "", new Object[0]);
                return l;
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r6 = this;
            r2 = 0;
            r0 = r6.sWa;
            r0 = r0.sVP;
            if (r0 == 0) goto L_0x0011;
        L_0x0007:
            r0 = "MicroMsg.ImageEngine";
            r1 = "on load image jog, isQuit, return";
            com.tencent.mm.sdk.platformtools.w.w(r0, r1);
        L_0x0010:
            return;
        L_0x0011:
            r0 = r6.sWa;
            r1 = r0.hAl;
            monitor-enter(r1);
            r0 = r6.sWa;	 Catch:{ all -> 0x0035 }
            r0 = r0.sVS;	 Catch:{ all -> 0x0035 }
            r3 = r6.sWk;	 Catch:{ all -> 0x0035 }
            r0 = r0.get(r3);	 Catch:{ all -> 0x0035 }
            if (r0 != 0) goto L_0x0038;
        L_0x0022:
            r0 = "MicroMsg.ImageEngine";
            r2 = "check before decode, no match wait to render view, renderKey is %s, return";
            r3 = 1;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0035 }
            r4 = 0;
            r5 = r6.sWk;	 Catch:{ all -> 0x0035 }
            r3[r4] = r5;	 Catch:{ all -> 0x0035 }
            com.tencent.mm.sdk.platformtools.w.w(r0, r2, r3);	 Catch:{ all -> 0x0035 }
            monitor-exit(r1);	 Catch:{ all -> 0x0035 }
            goto L_0x0010;
        L_0x0035:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0035 }
            throw r0;
        L_0x0038:
            monitor-exit(r1);	 Catch:{ all -> 0x0035 }
            r0 = 0;
            r1 = r6.sWj;
            if (r1 == 0) goto L_0x0059;
        L_0x003e:
            r1 = r2;
        L_0x003f:
            r3 = r6.sWj;
            r3 = r3.length;
            if (r1 >= r3) goto L_0x0059;
        L_0x0044:
            if (r1 != 0) goto L_0x00c5;
        L_0x0046:
            r0 = r6.sWj;
            r0 = r0[r2];
            r0 = r6.No(r0);
            if (r0 == 0) goto L_0x00f2;
        L_0x0050:
            r1 = r6.sWa;
            r1 = r1.sVU;
            r2 = r6.sWk;
            r1.put(r2, r0);
        L_0x0059:
            if (r0 != 0) goto L_0x0080;
        L_0x005b:
            r1 = r6.url;
            r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
            if (r1 != 0) goto L_0x0080;
        L_0x0063:
            r0 = r6.sWa;
            r1 = r6.sWk;
            r2 = r6.url;
            r3 = r6.neJ;
            r4 = r6.lKi;
            r0 = r0.g(r1, r2, r3, r4);
            r0 = com.tencent.mm.platformtools.j.a(r0);
            if (r0 == 0) goto L_0x0080;
        L_0x0077:
            r1 = r6.sWa;
            r1 = r1.sVU;
            r2 = r6.sWk;
            r1.put(r2, r0);
        L_0x0080:
            r2 = r0;
            if (r2 == 0) goto L_0x00bc;
        L_0x0083:
            r0 = r6.sWa;
            r3 = r0.hAl;
            monitor-enter(r3);
            r0 = r6.sWa;	 Catch:{ all -> 0x00f6 }
            r0 = r0.sVS;	 Catch:{ all -> 0x00f6 }
            r1 = r6.sWk;	 Catch:{ all -> 0x00f6 }
            r0 = r0.get(r1);	 Catch:{ all -> 0x00f6 }
            r0 = (android.widget.ImageView) r0;	 Catch:{ all -> 0x00f6 }
            if (r0 == 0) goto L_0x00b2;
        L_0x0096:
            r1 = r6.sWa;	 Catch:{ all -> 0x00f6 }
            r1 = r1.sVT;	 Catch:{ all -> 0x00f6 }
            r1.remove(r0);	 Catch:{ all -> 0x00f6 }
            r1 = r6.sWa;	 Catch:{ all -> 0x00f6 }
            r1 = r1.sVW;	 Catch:{ all -> 0x00f6 }
            r1 = r1.bGC();	 Catch:{ all -> 0x00f6 }
            r1 = (com.tencent.mm.pluginsdk.ui.tools.g.e) r1;	 Catch:{ all -> 0x00f6 }
            r1.fKf = r0;	 Catch:{ all -> 0x00f6 }
            r1.mhk = r2;	 Catch:{ all -> 0x00f6 }
            r0 = r6.sWa;	 Catch:{ all -> 0x00f6 }
            r0 = r0.hgN;	 Catch:{ all -> 0x00f6 }
            r0.post(r1);	 Catch:{ all -> 0x00f6 }
        L_0x00b2:
            r0 = r6.sWa;	 Catch:{ all -> 0x00f6 }
            r0 = r0.sVS;	 Catch:{ all -> 0x00f6 }
            r1 = r6.sWk;	 Catch:{ all -> 0x00f6 }
            r0.remove(r1);	 Catch:{ all -> 0x00f6 }
            monitor-exit(r3);	 Catch:{ all -> 0x00f6 }
        L_0x00bc:
            r0 = r6.sWa;
            r0 = r0.sVX;
            r0.B(r6);
            goto L_0x0010;
        L_0x00c5:
            r0 = r6.sWj;
            r0 = r0[r1];
            r3 = r6.url;
            r4 = r6.neJ;
            r5 = r6.lKi;
            r3 = com.tencent.mm.pluginsdk.ui.tools.g.m(r0, r3, r4, r5);
            r0 = r6.sWa;
            r0 = r0.sVU;
            r0 = r0.get(r3);
            r0 = (android.graphics.Bitmap) r0;
            if (r0 != 0) goto L_0x00e7;
        L_0x00df:
            r0 = r6.sWj;
            r0 = r0[r1];
            r0 = r6.No(r0);
        L_0x00e7:
            if (r0 == 0) goto L_0x00f2;
        L_0x00e9:
            r1 = r6.sWa;
            r1 = r1.sVU;
            r1.put(r3, r0);
            goto L_0x0059;
        L_0x00f2:
            r1 = r1 + 1;
            goto L_0x003f;
        L_0x00f6:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x00f6 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.tools.g.b.run():void");
        }
    }

    private abstract class c<K, V> {
        private HashMap<K, a> plE = new HashMap();
        final /* synthetic */ g sWa;
        private final int sWf;
        private a sWl = new a(this);
        private a sWm = new a(this);
        private int sWn = 0;

        private class a {
            public V jou;
            public a sWo = this.sWl;
            public a sWp = this.sWm;
            public K sWq;
            final /* synthetic */ c sWr;

            public a(c cVar) {
                this(cVar, null, null, (byte) 0);
            }

            public a(c cVar, K k, V v) {
                this(cVar, k, v, (byte) 0);
            }

            private a(c cVar, a aVar, V v, byte b) {
                this.sWr = cVar;
                this.sWo = null;
                this.sWp = null;
                this.sWq = aVar;
                this.jou = v;
            }
        }

        protected abstract void bt(V v);

        public c(g gVar, int i) {
            this.sWa = gVar;
            this.sWf = Math.max(1, i);
        }

        private void a(a aVar) {
            aVar.sWp = this.sWl.sWp;
            aVar.sWp.sWo = aVar;
            this.sWl.sWp = aVar;
            aVar.sWo = this.sWl;
        }

        private static void b(a aVar) {
            aVar.sWo.sWp = aVar.sWp;
            aVar.sWp.sWo = aVar.sWo;
            aVar.sWp = null;
            aVar.sWo = null;
        }

        public final void clear() {
            while (this.sWn > 0) {
                a aVar = this.sWm.sWo;
                b(aVar);
                this.plE.remove(aVar.sWq);
                bt(aVar.jou);
                this.sWn--;
            }
        }

        public final V put(K k, V v) {
            synchronized (this) {
                a aVar = (a) this.plE.get(k);
                if (aVar != null) {
                    b(aVar);
                    V v2 = aVar.jou;
                    aVar.jou = v;
                    a(aVar);
                    return v2;
                }
                aVar = new a(this, k, v);
                a(aVar);
                this.plE.put(k, aVar);
                this.sWn++;
                while (this.sWf < this.sWn) {
                    aVar = this.sWm.sWo;
                    b(aVar);
                    this.plE.remove(aVar.sWq);
                    bt(aVar.jou);
                    this.sWn--;
                }
                return null;
            }
        }

        public final V get(K k) {
            V v;
            synchronized (this) {
                a aVar = (a) this.plE.get(k);
                if (aVar != null) {
                    b(aVar);
                    a(aVar);
                    v = aVar.jou;
                } else {
                    v = null;
                }
            }
            return v;
        }

        public String toString() {
            String stringBuilder;
            synchronized (this) {
                StringBuilder stringBuilder2 = new StringBuilder();
                for (a aVar = this.sWl.sWp; aVar != this.sWm; aVar = aVar.sWp) {
                    stringBuilder2.append("[key:").append(aVar.sWq).append(", value:").append(aVar.jou).append("]");
                }
                stringBuilder = stringBuilder2.toString();
            }
            return stringBuilder;
        }
    }

    public static class d extends Drawable {
        static final Paint sWs = new Paint(6);
        WeakReference<Bitmap> sWt = new WeakReference(null);
        private boolean sWu = false;
        private boolean sWv = false;
        final Rect tZ = new Rect();

        public static void b(ImageView imageView, Bitmap bitmap) {
            boolean z;
            boolean z2 = true;
            Drawable dVar = imageView.getDrawable() instanceof d ? (d) imageView.getDrawable() : new d();
            dVar.sWt = new WeakReference(bitmap);
            if (imageView.getScaleType() == ScaleType.FIT_XY) {
                z = true;
            } else {
                z = false;
            }
            dVar.sWu = z;
            if (imageView.getScaleType() != ScaleType.CENTER_CROP) {
                z2 = false;
            }
            dVar.sWv = z2;
            imageView.setImageDrawable(dVar);
            imageView.postInvalidate();
        }

        public static void g(ImageView imageView) {
            b(imageView, null);
        }

        public final void draw(Canvas canvas) {
            Object obj;
            Bitmap bitmap = (Bitmap) this.sWt.get();
            if (bitmap == null || bitmap.isRecycled()) {
                obj = null;
            } else {
                copyBounds(this.tZ);
                canvas.drawBitmap(bitmap, null, this.tZ, sWs);
                obj = 1;
            }
            if (obj == null) {
            }
        }

        public final void setAlpha(int i) {
        }

        public final void setColorFilter(ColorFilter colorFilter) {
        }

        public final int getOpacity() {
            return 0;
        }
    }

    private class e implements Runnable {
        public ImageView fKf;
        public Bitmap mhk;
        final /* synthetic */ g sWa;

        public e(g gVar) {
            this.sWa = gVar;
        }

        public final void run() {
            if (this.fKf != null) {
                if (this.mhk == null || !this.mhk.isRecycled()) {
                    d.b(this.fKf, this.mhk);
                } else {
                    d.g(this.fKf);
                }
            }
            this.fKf = null;
            this.mhk = null;
            this.sWa.sVW.B(this);
        }
    }

    public g(int i) {
        this.sVQ.start();
        this.sVR = new ae(this.sVQ.getLooper());
        this.hgN = new ae(Looper.getMainLooper());
        this.sVW = new a<e>(this, this.sVQ.getLooper()) {
            final /* synthetic */ g sWa;

            protected final /* synthetic */ Object bGB() {
                return new e(this.sWa);
            }
        };
        this.sVX = new a<b>(this, Looper.getMainLooper()) {
            final /* synthetic */ g sWa;

            protected final /* synthetic */ Object bGB() {
                return new b(this.sWa);
            }
        };
        this.sVV = new SparseArray();
        this.sVU = new c<String, Bitmap>(this, i) {
            final /* synthetic */ g sWa;

            protected final /* synthetic */ void bt(Object obj) {
                Bitmap bitmap = (Bitmap) obj;
                if (bitmap != null) {
                    w.i("MicroMsg.ImageEngine", "recycle bitmap:%s", new Object[]{bitmap.toString()});
                    bitmap.recycle();
                }
            }
        };
        j.b(this.sVZ);
    }

    public final void destory() {
        w.d("MicroMsg.ImageEngine", "do destory");
        this.sVP = true;
        this.sVQ.quit();
        j.c(this.sVZ);
        final SparseArray sparseArray = this.sVV;
        final c cVar = this.sVU;
        this.sVV = new SparseArray();
        this.sVU = new c<String, Bitmap>(this) {
            final /* synthetic */ g sWa;

            {
                this.sWa = r2;
            }

            protected final /* bridge */ /* synthetic */ void bt(Object obj) {
            }
        };
        com.tencent.mm.sdk.f.e.post(new Runnable(this) {
            final /* synthetic */ g sWa;

            public final void run() {
                w.i("MicroMsg.ImageEngine", "begin do recycled");
                for (int i = 0; i < sparseArray.size(); i++) {
                    Bitmap bitmap = (Bitmap) sparseArray.valueAt(i);
                    if (bitmap != null) {
                        w.d("MicroMsg.ImageEngine", "recycled def bmp %s", new Object[]{bitmap.toString()});
                        bitmap.recycle();
                    }
                }
                sparseArray.clear();
                w.i("MicroMsg.ImageEngine", "clear drawable cache");
                cVar.clear();
                w.i("MicroMsg.ImageEngine", "end do recycled");
            }
        }, "ImageEngine_destroy_" + System.currentTimeMillis());
    }

    public i g(String str, String str2, int i, int i2) {
        return null;
    }

    private void a(ImageView imageView, int i) {
        if (i == 0) {
            d.g(imageView);
            return;
        }
        Bitmap bitmap = (Bitmap) this.sVV.get(i);
        if (bitmap == null) {
            bitmap = com.tencent.mm.compatible.f.a.decodeResource(imageView.getResources(), i);
            this.sVV.put(i, bitmap);
        }
        d.b(imageView, bitmap);
    }

    public static String m(String str, String str2, int i, int i2) {
        return bg.ap(str, "null") + "_" + bg.ap(str2, "null") + "_" + i + "_" + i2;
    }

    public final void a(ImageView imageView, String[] strArr, String str, int i, int i2, int i3) {
        int i4 = 0;
        if (!this.sVY) {
            return;
        }
        if (this.sVP) {
            w.w("MicroMsg.ImageEngine", "on attach, isQuit, return");
        } else if (imageView == null) {
            w.w("MicroMsg.ImageEngine", "attach from file path fail, imageview is null");
        } else if ((strArr == null || strArr.length <= 0) && bg.mA(str)) {
            w.w("MicroMsg.ImageEngine", "attach from file path fail, path and url are null or empty");
            a(imageView, i);
        } else {
            String str2 = (strArr == null || strArr.length <= 0) ? null : strArr[0];
            String m = m(str2, str, i2, i3);
            synchronized (this.hAl) {
                str2 = (String) this.sVT.get(imageView);
                if (str2 != null) {
                    this.sVS.remove(str2);
                }
                this.sVT.put(imageView, m);
            }
            Bitmap bitmap = (Bitmap) this.sVU.get(m);
            if (bitmap == null || bitmap.isRecycled()) {
                w.v("MicroMsg.ImageEngine", "get first render bmp fail, key[%s]", new Object[]{m});
                if (strArr != null && strArr.length > 1) {
                    for (int i5 = 1; i5 < strArr.length; i5++) {
                        bitmap = (Bitmap) this.sVU.get(m(strArr[i5], str, i2, i3));
                        String str3 = "MicroMsg.ImageEngine";
                        String str4 = "get next render bmp, key[%s], result[%B]";
                        Object[] objArr = new Object[2];
                        objArr[0] = m;
                        objArr[1] = Boolean.valueOf(bitmap != null);
                        w.v(str3, str4, objArr);
                        if (bitmap != null) {
                            d.b(imageView, bitmap);
                            i4 = 1;
                            break;
                        }
                    }
                }
                if (i4 == 0) {
                    w.v("MicroMsg.ImageEngine", "use default res to render");
                    a(imageView, i);
                }
                synchronized (this.hAl) {
                    this.sVS.put(m, imageView);
                }
                b bVar = (b) this.sVX.bGC();
                bVar.sWj = strArr;
                bVar.url = str;
                bVar.sWk = m;
                bVar.neJ = i2;
                bVar.lKi = i3;
                this.sVR.postAtFrontOfQueueV2(bVar);
                return;
            }
            d.b(imageView, bitmap);
        }
    }
}
