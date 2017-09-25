package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import com.tencent.mm.a.f.b;
import com.tencent.mm.sdk.platformtools.ar;
import java.util.HashMap;
import java.util.LinkedList;

public final class f {
    private ar hwd = new ar(1, "chatting-image-gallery-preload-loader");
    protected com.tencent.mm.a.f<String, Bitmap> mhf = new com.tencent.mm.a.f(4, new b<String, Bitmap>(this) {
        final /* synthetic */ f vRF;

        {
            this.vRF = r1;
        }

        public final /* synthetic */ void l(Object obj, Object obj2) {
            this.vRF.vRE.remove((String) obj);
        }
    });
    public boolean mhi = false;
    public LinkedList<String> ta = new LinkedList();
    protected HashMap<String, Long> vRE = new HashMap();
    private int xV = 0;

    private static final class a {
        public static f vRG = new f();
    }

    public final void ayW() {
        this.mhf.a(new com.tencent.mm.a.f.a<String, Bitmap>(this) {
            final /* synthetic */ f vRF;

            {
                this.vRF = r1;
            }
        });
    }
}
