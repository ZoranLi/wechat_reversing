package com.tencent.mm.modelvideo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.sdk.WebView;

public final class c {
    Context context = null;
    int duration = 0;
    String fKz = null;
    String fVB = null;
    String fyF = null;
    public a hXW = null;
    String hXX = null;
    final AsyncTask<String, Integer, String> hXY = new AsyncTask<String, Integer, String>(this) {
        final /* synthetic */ c hXZ;
        int ret = 0;

        {
            this.hXZ = r2;
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            return KB();
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            if (this.hXZ.hXW != null) {
                this.hXZ.hXW.a(this.ret, this.hXZ.fyF, this.hXZ.hXX, this.hXZ.duration);
            }
        }

        private String KB() {
            com.tencent.mm.compatible.i.a.a i;
            this.ret = 0;
            boolean is2G = am.is2G(ab.getContext());
            try {
                i = com.tencent.mm.compatible.i.a.i(this.hXZ.context, this.hXZ.intent);
            } catch (Throwable e) {
                Throwable e2;
                w.e("MicroMsg.ImportVideo", "exception:%s", bg.g(e2));
                i = null;
            }
            if (i == null) {
                w.e("MicroMsg.ImportVideo", "GetVideoMetadata filed.");
                g.oUh.a(106, 244, 1, false);
                this.ret = -50005;
                return null;
            }
            this.hXZ.hXX = i.filename;
            int aN = e.aN(this.hXZ.hXX);
            w.i("MicroMsg.ImportVideo", "import file is2G:%b len:%d duration:%d path:%s ", Boolean.valueOf(is2G), Integer.valueOf(aN), Integer.valueOf(i.duration), this.hXZ.hXX);
            if (aN <= 0) {
                g.oUh.a(106, 244, 1, false);
                this.ret = -50001;
                return null;
            }
            if (aN > (is2G ? 10485760 : 20971520)) {
                g.oUh.a(106, 245, 1, false);
                this.ret = -50002;
                return null;
            }
            j.p(this.hXZ.hXX, this.hXZ.fVB, false);
            this.hXZ.duration = i.duration / 1000;
            Object obj = 1;
            if (i.bitmap != null) {
                try {
                    d.a(i.bitmap, 60, CompressFormat.JPEG, this.hXZ.fKz, true);
                    try {
                        g.oUh.a(106, 231, 1, false);
                        obj = null;
                    } catch (Exception e3) {
                        e2 = e3;
                        obj = null;
                        w.e("MicroMsg.ImportVideo", "exception:%s", bg.g(e2));
                        if (obj != null) {
                            try {
                                g.oUh.a(106, 232, 1, false);
                                d.a(d.U(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, this.hXZ.fKz, true);
                            } catch (Throwable e22) {
                                w.e("MicroMsg.ImportVideo", "exception:%s", bg.g(e22));
                            }
                        }
                        if (!e.aO(this.hXZ.fVB)) {
                            this.ret = -50003;
                        }
                        if (!e.aO(this.hXZ.fKz)) {
                            this.ret = -50004;
                        }
                        return null;
                    }
                } catch (Exception e4) {
                    e22 = e4;
                    w.e("MicroMsg.ImportVideo", "exception:%s", bg.g(e22));
                    if (obj != null) {
                        g.oUh.a(106, 232, 1, false);
                        d.a(d.U(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, this.hXZ.fKz, true);
                    }
                    if (e.aO(this.hXZ.fVB)) {
                        this.ret = -50003;
                    }
                    if (e.aO(this.hXZ.fKz)) {
                        this.ret = -50004;
                    }
                    return null;
                }
            }
            if (obj != null) {
                g.oUh.a(106, 232, 1, false);
                d.a(d.U(WebView.NIGHT_MODE_COLOR, 320, 480), 60, CompressFormat.JPEG, this.hXZ.fKz, true);
            }
            if (e.aO(this.hXZ.fVB)) {
                this.ret = -50003;
            }
            if (e.aO(this.hXZ.fKz)) {
                this.ret = -50004;
            }
            return null;
        }
    };
    Intent intent = null;

    public interface a {
        void a(int i, String str, String str2, int i2);
    }

    public final void a(Context context, Intent intent, a aVar) {
        this.context = context;
        this.intent = intent;
        this.fyF = s.lu((String) h.vI().vr().get(2, (Object) ""));
        o.KV();
        this.fKz = s.lw(this.fyF);
        o.KV();
        this.fVB = s.lv(this.fyF);
        this.hXW = aVar;
        this.hXY.execute(new String[0]);
    }
}
