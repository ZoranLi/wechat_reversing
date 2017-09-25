package com.tencent.mm.ah.a;

import android.graphics.Bitmap;
import com.tencent.mm.ah.a.c.h;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public final class b {
    public com.tencent.mm.ah.a.a.b hIg;
    h hIh;
    Executor hIi;
    public final Map<Integer, String> hIj = Collections.synchronizedMap(new HashMap());
    public HashMap<Integer, com.tencent.mm.ah.a.f.b> hIk = new HashMap();

    public b(com.tencent.mm.ah.a.a.b bVar) {
        this.hIg = bVar;
        this.hIh = bVar.hIG;
        this.hIi = bVar.hIH;
        this.hIg.hIA.a(this.hIg.hIC);
    }

    public final Bitmap jH(String str) {
        if (this.hIg != null) {
            return this.hIg.hIz.gS(str);
        }
        return null;
    }

    public final void a(c cVar) {
        this.hIj.remove(Integer.valueOf(cVar.He()));
        w.d("MicroMsg.imageloader.ImageLoaderManager", "[cpan] remove image weak holder size:%d viewcode:%s", Integer.valueOf(this.hIj.size()), Integer.valueOf(cVar.He()));
    }
}
