package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.mm.a.f;
import com.tencent.mm.a.f.a;
import com.tencent.mm.a.f.b;
import com.tencent.mm.plugin.gallery.model.j;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;

final class d {
    private ar hwd = new ar(1, "album-image-gallery-lazy-loader");
    SparseArray<WeakReference<MultiTouchImageView>> mhb = new SparseArray();
    public HashMap<String, Integer> mhc = new HashMap();
    SparseArray<String> mhd = new SparseArray();
    public SparseArray<Bitmap> mhe = new SparseArray();
    protected f<String, Bitmap> mhf = new f(5, new b<String, Bitmap>(this) {
        final /* synthetic */ d mhj;

        {
            this.mhj = r1;
        }

        public final /* synthetic */ void l(Object obj, Object obj2) {
            Bitmap bitmap = (Bitmap) obj2;
            if (bitmap != null && !bitmap.isRecycled() && this.mhj.mhg.indexOfKey(bitmap.hashCode()) < 0) {
                bitmap.recycle();
            }
        }
    });
    protected SparseIntArray mhg = new SparseIntArray();
    public c mhh;
    public boolean mhi = false;
    LinkedList<String> ta = new LinkedList();
    private int xV = 0;

    public d(c cVar) {
        this.mhh = cVar;
    }

    final void ayW() {
        this.mhf.a(new a<String, Bitmap>(this) {
            final /* synthetic */ d mhj;

            {
                this.mhj = r1;
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

    public final boolean ayX() {
        return this.xV == 0;
    }

    final void nm(int i) {
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
            MultiTouchImageView multiTouchImageView = (MultiTouchImageView) ((WeakReference) this.mhb.get(i)).get();
            String str = (String) this.mhd.get(i);
            if (!(bitmap == null || multiTouchImageView == null)) {
                int hashCode = bitmap.hashCode();
                int indexOfValue = this.mhg.indexOfValue(i);
                if (indexOfValue >= 0) {
                    this.mhg.removeAt(indexOfValue);
                }
                this.mhg.put(hashCode, i);
            }
            this.mhh.mgK.remove(str);
            if (!(bitmap == null || multiTouchImageView == null)) {
                c.a(multiTouchImageView, bitmap);
            }
            nm(i);
        }
    }

    public final void ayY() {
        if (!this.mhi && this.ta.size() != 0) {
            final String str = (String) this.ta.removeLast();
            if (this.mhc.containsKey(str)) {
                this.mhi = true;
                this.hwd.c(new ar.a(this) {
                    final /* synthetic */ d mhj;
                    private Bitmap mhk = null;

                    public final boolean Bo() {
                        this.mhj.mhi = false;
                        if (this.mhj.mhc.containsKey(str)) {
                            int intValue = ((Integer) this.mhj.mhc.get(str)).intValue();
                            if (this.mhj.ayX()) {
                                this.mhj.a(intValue, this.mhk);
                            } else {
                                this.mhj.mhe.put(intValue, this.mhk);
                            }
                        }
                        this.mhj.mhf.k(str, this.mhk);
                        this.mhk = null;
                        this.mhj.ayY();
                        return false;
                    }

                    public final boolean Bn() {
                        if (this.mhj.mhh == null || TextUtils.isEmpty(str)) {
                            return false;
                        }
                        String str = str;
                        long NA = bg.NA();
                        Bitmap xo = j.xo(str);
                        w.v("MicroMsg.ImageAdapter", "test decode: %d filePath:%s", new Object[]{Long.valueOf(bg.aB(NA)), str});
                        this.mhk = xo;
                        return true;
                    }
                });
            }
        }
    }
}
