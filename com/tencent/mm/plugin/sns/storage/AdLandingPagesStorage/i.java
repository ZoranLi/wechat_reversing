package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.database.Cursor;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.d;
import com.tencent.mm.protocal.c.tv;
import com.tencent.mm.protocal.c.tw;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;
import java.util.HashMap;
import java.util.Map;

public final class i {
    private static final i qnd = new i();
    public Map<Long, String> lSA = new HashMap();
    public d qne = ae.beM();

    public static i bgZ() {
        return qnd;
    }

    private i() {
        HandlerThread Qu = e.Qu("OpenCanvasMgr");
        Qu.start();
        new com.tencent.mm.sdk.platformtools.ae(Qu.getLooper()).postDelayed(new Runnable(this) {
            final /* synthetic */ i qnf;

            {
                this.qnf = r1;
            }

            public final void run() {
                i iVar = this.qnf;
                w.i("OpenCanvasMgr", "clearing old canvasInfo cache");
                Cursor Kk = iVar.qne.Kk();
                if (Kk != null) {
                    long currentTimeMillis = System.currentTimeMillis() - 777600000;
                    while (Kk.moveToNext()) {
                        c cVar = new com.tencent.mm.plugin.sns.storage.c();
                        cVar.b(Kk);
                        if (cVar.field_createTime < currentTimeMillis) {
                            w.i("OpenCanvasMgr", "eliminate %d " + cVar.field_canvasId);
                            iVar.qne.a(cVar, new String[0]);
                        }
                    }
                    Kk.close();
                }
            }
        }, 5000);
    }

    public final String e(long j, int i, int i2) {
        w.i("OpenCanvasMgr", "open pageId %d, preLoad %d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        if (j <= 0) {
            return "";
        }
        String str = "";
        if (i2 != 1) {
            if (this.lSA.containsKey(Long.valueOf(j))) {
                str = (String) this.lSA.get(Long.valueOf(j));
            } else {
                c cVar = new com.tencent.mm.plugin.sns.storage.c();
                cVar.field_canvasId = j;
                this.qne.b(cVar, new String[0]);
                if (TextUtils.isEmpty(cVar.field_canvasXml)) {
                    str = "";
                } else {
                    this.lSA.put(Long.valueOf(j), cVar.field_canvasXml);
                    str = cVar.field_canvasXml;
                }
            }
        }
        if (i != 1 || !TextUtils.isEmpty(str)) {
            return str;
        }
        final com.tencent.mm.plugin.sns.storage.c cVar2 = new com.tencent.mm.plugin.sns.storage.c();
        cVar2.field_canvasId = j;
        a aVar = new a();
        aVar.hsm = new tv();
        aVar.hsn = new tw();
        aVar.uri = "/cgi-bin/mmoc-bin/adplayinfo/get_adcanvasinfo";
        aVar.hsl = 1286;
        b BE = aVar.BE();
        ((tv) BE.hsj.hsr).tCb = j;
        final long j2 = j;
        final int i3 = i;
        u.a(BE, new u.a(this) {
            final /* synthetic */ i qnf;

            public final int a(int i, int i2, String str, b bVar, k kVar) {
                if (i == 0 && i2 == 0) {
                    tw twVar = (tw) bVar.hsk.hsr;
                    w.i("OpenCanvasMgr", "getCanvasInfo pageid %d ,xml %s", new Object[]{Long.valueOf(j2), twVar.tCc});
                    if (!TextUtils.isEmpty(twVar.tCc)) {
                        this.qnf.lSA.put(Long.valueOf(j2), twVar.tCc);
                        cVar2.field_canvasXml = twVar.tCc;
                        this.qnf.qne.a(cVar2);
                    }
                } else {
                    w.e("OpenCanvasMgr", "cgi fail page id %d,preLoad %d, errType %d,errCode %d", new Object[]{Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2)});
                }
                return 0;
            }
        });
        return "";
    }

    public final void n(long j, String str) {
        if (!TextUtils.isEmpty(str) && j > 0) {
            this.lSA.put(Long.valueOf(j), str);
            com.tencent.mm.plugin.sns.storage.c cVar = new com.tencent.mm.plugin.sns.storage.c();
            cVar.field_canvasId = j;
            cVar.field_canvasXml = str;
            this.qne.a(cVar);
        }
    }
}
