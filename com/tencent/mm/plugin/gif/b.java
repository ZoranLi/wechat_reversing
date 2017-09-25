package com.tencent.mm.plugin.gif;

import com.tencent.mm.a.f;
import com.tencent.mm.af.a;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;

public class b {
    private static b mJN;
    public f<String, WeakReference<c>> mJO = new f(10);
    f<String, WeakReference<a>> mJP = new f(10, new com.tencent.mm.a.f.b<String, WeakReference<a>>(this) {
        final /* synthetic */ b mJQ;

        {
            this.mJQ = r1;
        }

        public final /* synthetic */ void l(Object obj, Object obj2) {
            WeakReference weakReference = (WeakReference) obj2;
            if (weakReference != null) {
                a aVar = (a) weakReference.get();
                if (aVar != null) {
                    w.i("MicroMsg.GIF.MMGIFDrawableCacheMgr", "recycle bitmap:%s", aVar.toString());
                    aVar.recycle();
                }
            }
        }
    });

    public static synchronized b aCV() {
        b bVar;
        synchronized (b.class) {
            if (mJN == null) {
                synchronized (b.class) {
                    if (mJN == null) {
                        mJN = new b();
                    }
                }
            }
            bVar = mJN;
        }
        return bVar;
    }

    public final a yh(String str) {
        if (this.mJP.get(str) != null) {
            return (a) ((WeakReference) this.mJP.get(str)).get();
        }
        return null;
    }

    public final a cr(String str, String str2) {
        a aVar = null;
        if (this.mJP.get(str) != null) {
            aVar = (a) ((WeakReference) this.mJP.get(str)).get();
        }
        if (aVar != null) {
            return aVar;
        }
        long currentTimeMillis = System.currentTimeMillis();
        aVar = new a(str2);
        w.d("MicroMsg.GIF.MMGIFDrawableCacheMgr", "new MMGIFDrawable use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        this.mJP.put(str, new WeakReference(aVar));
        return aVar;
    }

    public final a p(String str, byte[] bArr) {
        a aVar = null;
        if (bArr != null) {
            if (this.mJP.get(str) != null) {
                aVar = (a) ((WeakReference) this.mJP.get(str)).get();
            }
            if (aVar == null) {
                aVar = new a(bArr);
                this.mJP.put(str, new WeakReference(aVar));
            }
            if (!aVar.isRunning()) {
                aVar.mJl = false;
                aVar.lp = true;
                a.a(aVar.mJJ, 300);
            }
        }
        return aVar;
    }
}
