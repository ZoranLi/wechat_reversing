package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a.k;
import com.tencent.mm.s.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

public enum a {
    ;
    
    private static volatile WeakReference<Bitmap> hqa;

    public static Drawable AX() {
        if (hqa == null || hqa.get() == null || ((Bitmap) hqa.get()).isRecycled()) {
            hqa = new WeakReference(com.tencent.mm.compatible.f.a.decodeResource(ab.getResources(), j.bes));
        }
        Drawable a = k.a(ab.getResources(), (Bitmap) hqa.get());
        a.bt();
        return a;
    }
}
