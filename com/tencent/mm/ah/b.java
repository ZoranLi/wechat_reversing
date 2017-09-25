package com.tencent.mm.ah;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;

public final class b {
    private HashMap<String, c> hEJ = new HashMap();

    static class a implements Runnable {
        private HashMap<String, c> hEJ;
        private Bitmap hEK;
        private String url;

        public a(String str, Bitmap bitmap, HashMap<String, c> hashMap) {
            this.url = str;
            this.hEK = bitmap;
            this.hEJ = hashMap;
        }

        public final void run() {
            n.GR();
            b.f(this.url, this.hEK);
            if (this.hEJ != null) {
                c cVar = (c) this.hEJ.remove(this.url);
                if (cVar != null) {
                    cVar.l(this.hEK);
                }
            }
            String str = "MicroMsg.CdnImageService";
            String str2 = "finish download post job, url[%s]";
            Object[] objArr = new Object[1];
            objArr[0] = this.url == null ? "null" : this.url;
            w.i(str, str2, objArr);
        }
    }

    static class b implements Runnable {
        private HashMap<String, c> hEJ;
        private String url;

        b(String str, HashMap<String, c> hashMap) {
            this.url = str;
            this.hEJ = hashMap;
        }

        public final void run() {
            byte[] Qc = bg.Qc(this.url);
            if (Qc == null) {
                w.w("MicroMsg.CdnImageService", "download fail: url[%s] data is null", this.url);
                return;
            }
            Bitmap bd;
            try {
                bd = d.bd(Qc);
            } catch (Exception e) {
                w.w("MicroMsg.CdnImageService", "download fail: url[%s] decode bitmap error[%s]", this.url, e.getLocalizedMessage());
                bd = null;
            }
            w.i("MicroMsg.CdnImageService", "download finish, url[%s], do post job", this.url);
            af.v(new a(this.url, bd, this.hEJ));
        }
    }

    public interface c {
        void l(Bitmap bitmap);
    }

    protected final void finalize() {
        super.finalize();
    }

    public static void f(String str, Bitmap bitmap) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.CdnImageService", "push fail, key is null");
        } else {
            com.tencent.mm.cache.a.a.a("local_cdn_img_cache", str, (Object) bitmap);
        }
    }

    public static Bitmap gS(String str) {
        if (str != null && str.length() != 0) {
            return (Bitmap) com.tencent.mm.cache.a.a.x("local_cdn_img_cache", str);
        }
        w.e("MicroMsg.CdnImageService", "get fail, key is null");
        return null;
    }

    public final void jm(String str) {
        if (bg.mA(str)) {
            w.w("MicroMsg.CdnImageService", "stop load fail, url is empty");
        } else {
            this.hEJ.remove(str);
        }
    }

    public final void a(String str, c cVar) {
        if (bg.mA(str)) {
            w.w("MicroMsg.CdnImageService", "do load fail, url is empty");
            return;
        }
        Bitmap gS = gS(str);
        if (gS == null || gS.isRecycled()) {
            boolean z;
            String str2 = "MicroMsg.CdnImageService";
            String str3 = "try to download: url[%s], src bitmap is null[%B]";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (gS == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            w.w(str2, str3, objArr);
            if (this.hEJ.containsKey(str)) {
                w.w("MicroMsg.CdnImageService", "contains url[%s]", str);
                return;
            }
            this.hEJ.put(str, cVar);
            e.post(new b(str, this.hEJ), "CdnImageService_download");
            return;
        }
        w.i("MicroMsg.CdnImageService", "do load ok, url[%s], bitmap exists", str);
        if (cVar != null) {
            cVar.l(gS);
        }
    }
}
