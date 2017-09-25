package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.widget.ImageView;
import com.tencent.mm.a.f;
import com.tencent.mm.a.f.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

final class e implements android.support.v4.view.ViewPager.e {
    private static int mScreenHeight = 0;
    private static int mScreenWidth = 0;
    private static long vRz = 0;
    public ae hgN = new ae();
    private ar hwd = new ar(1, "chatting-image-gallery-lazy-loader");
    SparseArray<WeakReference<ImageView>> mhb = new SparseArray();
    public HashMap<String, Integer> mhc = new HashMap();
    SparseArray<String> mhd = new SparseArray();
    public SparseArray<Bitmap> mhe = new SparseArray();
    protected f<String, Bitmap> mhf = new f(5, new b<String, Bitmap>(this) {
        final /* synthetic */ e vRB;

        {
            this.vRB = r1;
        }

        public final /* synthetic */ void l(Object obj, Object obj2) {
            Bitmap bitmap = (Bitmap) obj2;
            w.i("MicroMsg.ImageGalleryLazyLoader", "preRemoveCallback %s", (String) obj);
            if (bitmap != null && !bitmap.isRecycled() && this.vRB.mhg.indexOfKey(bitmap.hashCode()) < 0) {
                if (this.vRB.vRA.contains(Integer.valueOf(bitmap.hashCode()))) {
                    this.vRB.vRA.remove(Integer.valueOf(bitmap.hashCode()));
                    return;
                }
                w.i("MicroMsg.ImageGalleryLazyLoader", "recycle bitmap:%s", bitmap.toString());
                bitmap.recycle();
            }
        }
    });
    protected SparseIntArray mhg = new SparseIntArray();
    public boolean mhi = false;
    private int mhm = -1;
    private LinkedList<String> ta = new LinkedList();
    public LinkedList<Integer> vRA = new LinkedList();
    public a vRx;
    protected f<Integer, Bitmap> vRy = new f(40, new b<Integer, Bitmap>(this) {
        final /* synthetic */ e vRB;

        {
            this.vRB = r1;
        }

        public final /* synthetic */ void l(Object obj, Object obj2) {
            Bitmap bitmap = (Bitmap) obj2;
            if (bitmap != null && !bitmap.isRecycled()) {
                w.i("MicroMsg.ImageGalleryLazyLoader", "recycle bitmap:%s", bitmap.toString());
                bitmap.recycle();
            }
        }
    });
    private int xV = 0;

    public interface a {
        Bitmap BA(int i);

        Bitmap TJ(String str);

        void c(ImageView imageView, Bitmap bitmap);
    }

    protected final void t(String str, Bitmap bitmap) {
        int i;
        if (bitmap != null) {
            long width = (long) (bitmap.getWidth() * bitmap.getHeight());
            if (mScreenHeight == 0 || mScreenWidth == 0) {
                mScreenWidth = ab.getContext().getResources().getDisplayMetrics().widthPixels;
                mScreenHeight = ab.getContext().getResources().getDisplayMetrics().heightPixels;
                vRz = ((long) mScreenWidth) * vRz;
            }
            if (width > vRz * 2) {
                i = 1;
                if (i == 0) {
                    w.i("MicroMsg.ImageGalleryLazyLoader", "file %s too big to cache");
                }
                this.mhf.k(str, bitmap);
                if (a.vRG.mhf.aV(str)) {
                    w.i("MicroMsg.ImageGalleryLazyLoader", "update origCache and preload cache");
                    try {
                        a.vRG.mhf.k(str, bitmap);
                        return;
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.ImageGalleryLazyLoader", e, "update preload cache failed", new Object[0]);
                        return;
                    }
                }
                return;
            }
        }
        i = 0;
        if (i == 0) {
            this.mhf.k(str, bitmap);
            if (a.vRG.mhf.aV(str)) {
                w.i("MicroMsg.ImageGalleryLazyLoader", "update origCache and preload cache");
                a.vRG.mhf.k(str, bitmap);
                return;
            }
            return;
        }
        w.i("MicroMsg.ImageGalleryLazyLoader", "file %s too big to cache");
    }

    public final void aj(Map<String, Bitmap> map) {
        for (String str : map.keySet()) {
            Bitmap bitmap = (Bitmap) map.get(str);
            if (bitmap != null) {
                this.mhf.put(str, bitmap);
                this.vRA.push(Integer.valueOf(bitmap.hashCode()));
                w.i("MicroMsg.ImageGalleryLazyLoader", "we got one cache from preload : %s %s", str, Integer.valueOf(bitmap.hashCode()));
            } else {
                w.e("MicroMsg.ImageGalleryLazyLoader", "we got one null cache from preload");
            }
        }
    }

    public e(a aVar) {
        this.vRx = aVar;
    }

    final void ayW() {
        this.vRy.a(new com.tencent.mm.a.f.a<Integer, Bitmap>(this) {
            final /* synthetic */ e vRB;

            {
                this.vRB = r1;
            }
        });
        this.mhf.a(new com.tencent.mm.a.f.a<String, Bitmap>(this) {
            final /* synthetic */ e vRB;

            {
                this.vRB = r1;
            }
        });
    }

    public final void W(int i) {
        int i2 = 0;
        this.xV = i;
        if (ayX()) {
            int[] iArr = new int[this.mhe.size()];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                iArr[i3] = this.mhe.keyAt(i3);
            }
            while (i2 < iArr.length) {
                int i4 = iArr[i2];
                a(i4, (Bitmap) this.mhe.get(i4));
                i2++;
            }
        }
    }

    public final void V(int i) {
        if (((d) this.vRx).vPU.vPW.vQn) {
            if (this.mhm == -1) {
                int i2 = 0;
                while (true) {
                    if (i2 != 0) {
                        if (i + i2 > i + 3 && i - i2 < Math.max(i - 3, 0)) {
                            break;
                        }
                        if (i + i2 <= i + 3) {
                            nn(i + i2);
                        }
                        if (i - i2 >= Math.max(i - 3, 0)) {
                            nn(i - i2);
                        }
                    } else {
                        nn(i);
                    }
                    i2++;
                }
            } else if (this.mhm > i) {
                nn(Math.max(i - 3, 0));
            } else if (this.mhm < i) {
                nn(i + 3);
            }
            this.mhm = i;
        }
    }

    private void nn(final int i) {
        if (!this.vRy.aV(Integer.valueOf(i))) {
            ap.vL().e(new Runnable(this) {
                final /* synthetic */ e vRB;

                public final void run() {
                    if (this.vRB.vRx == null) {
                        w.e("MicroMsg.ImageGalleryLazyLoader", "loader is null!");
                        return;
                    }
                    final Bitmap BA = this.vRB.vRx.BA(i);
                    if (BA != null) {
                        this.vRB.hgN.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass5 vRD;

                            public final void run() {
                                this.vRD.vRB.vRy.put(Integer.valueOf(i), BA);
                            }
                        });
                    }
                }
            }, 300);
        }
    }

    public final boolean ayX() {
        return this.xV == 0;
    }

    private void nm(int i) {
        if (this.mhd.get(i) != null) {
            String str = (String) this.mhd.get(i);
            this.mhb.remove(i);
            this.mhd.remove(i);
            this.mhc.remove(str);
            this.mhe.remove(i);
        }
    }

    public final void a(int i, Bitmap bitmap) {
        if (this.mhb.get(i) != null) {
            ImageView imageView = (ImageView) ((WeakReference) this.mhb.get(i)).get();
            this.mhd.get(i);
            this.vRx.c(imageView, bitmap);
            nm(i);
        }
    }

    public final boolean b(ImageView imageView, int i) {
        w.i("MicroMsg.ImageGalleryLazyLoader", "loadThumb position %s", Integer.valueOf(i));
        Bitmap bitmap = (Bitmap) this.vRy.get(Integer.valueOf(i));
        if (bitmap == null || bitmap.isRecycled()) {
            return false;
        }
        this.vRx.c(imageView, bitmap);
        return true;
    }

    public final void q(ImageView imageView, String str) {
        if (!this.ta.contains(str)) {
            int hashCode = imageView.hashCode();
            nm(hashCode);
            this.mhc.put(str, Integer.valueOf(hashCode));
            this.mhd.put(hashCode, str);
            this.mhb.put(hashCode, new WeakReference(imageView));
            this.ta.add(str);
            ayY();
        }
    }

    public final void ayY() {
        if (!this.mhi && this.ta.size() != 0) {
            final String str = (String) this.ta.removeLast();
            if (this.mhc.containsKey(str)) {
                this.mhi = true;
                this.hwd.c(new com.tencent.mm.sdk.platformtools.ar.a(this) {
                    private Bitmap mhk = null;
                    final /* synthetic */ e vRB;

                    public final boolean Bo() {
                        int intValue;
                        this.vRB.mhi = false;
                        if (this.vRB.mhc.containsKey(str)) {
                            intValue = ((Integer) this.vRB.mhc.get(str)).intValue();
                            if (this.vRB.ayX()) {
                                this.vRB.a(intValue, this.mhk);
                            } else {
                                this.vRB.mhe.put(intValue, this.mhk);
                            }
                        }
                        this.vRB.t(str, this.mhk);
                        String str = "MicroMsg.ImageGalleryLazyLoader";
                        String str2 = "bmp size : %s";
                        Object[] objArr = new Object[1];
                        Bitmap bitmap = this.mhk;
                        if (bitmap == null || bitmap.isRecycled()) {
                            intValue = 0;
                        } else {
                            intValue = VERSION.SDK_INT >= 12 ? bitmap.getByteCount() : bitmap.getRowBytes() * bitmap.getHeight();
                            if (intValue < 0) {
                                throw new IllegalStateException("Negative size: " + bitmap);
                            }
                        }
                        objArr[0] = Integer.valueOf(intValue);
                        w.i(str, str2, objArr);
                        this.mhk = null;
                        this.vRB.ayY();
                        return false;
                    }

                    public final boolean Bn() {
                        if (this.vRB.vRx == null || TextUtils.isEmpty(str)) {
                            return false;
                        }
                        try {
                            this.mhk = this.vRB.vRx.TJ(str);
                            return true;
                        } catch (Exception e) {
                            w.w("MicroMsg.ImageGalleryLazyLoader", "try to load Bmp fail: %s", e.getMessage());
                            this.mhk = null;
                            return false;
                        }
                    }
                });
            }
        }
    }

    public final void a(int i, float f, int i2) {
    }
}
