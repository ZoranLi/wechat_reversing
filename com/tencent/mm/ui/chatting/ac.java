package com.tencent.mm.ui.chatting;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.c;
import com.tencent.mm.t.f;
import com.tencent.mm.t.l;
import com.tencent.mm.u.o;
import com.tencent.mm.x.n;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;

public final class ac {

    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ List iYk;

        AnonymousClass1(List list) {
            this.iYk = list;
        }

        public final void run() {
            List<au> list = this.iYk;
            if (!bg.bV(list)) {
                for (au auVar : list) {
                    if (auVar.bLX()) {
                        List<l> list2 = ((a) h.h(a.class)).rV(auVar.field_content).hkm;
                        if (list2 != null) {
                            for (l lVar : list2) {
                                if (!bg.mA(lVar.hkC) && com.tencent.mm.t.h.em(lVar.hkx)) {
                                    b.AY().a(new AnonymousClass2(lVar), lVar.hkC, null, ((com.tencent.mm.modelappbrand.h) h.h(com.tencent.mm.modelappbrand.h.class)).aL(MMGIFException.D_GIF_ERR_IMAGE_DEFECT, 90));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static class AnonymousClass2 implements b.h {
        final /* synthetic */ l vBi;

        AnonymousClass2(l lVar) {
            this.vBi = lVar;
        }

        public final void Ba() {
        }

        public final void h(Bitmap bitmap) {
            w.d("MicroMsg.ChattingEditModeSendToAppBrand", "onBitmapLoaded %s", this.vBi.hkC);
        }

        public final void Bb() {
        }

        public final String Bc() {
            return com.tencent.mm.plugin.appbrand.l.b.aM(this);
        }
    }

    public static void b(String str, f.a aVar, String str2) {
        Bitmap bitmap = null;
        try {
            byte[] bArr = new byte[0];
            if (!bg.mA(str2) && (str2.startsWith("http://") || str2.startsWith("https://"))) {
                bitmap = b.AY().gN(str2);
            }
            if (bitmap == null || bitmap.isRecycled()) {
                w.e("MicroMsg.ChattingEditModeSendToAppBrand", "thumb image is null");
            } else {
                w.i("MicroMsg.ChattingEditModeSendToAppBrand", "thumb image is not null ");
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                bArr = byteArrayOutputStream.toByteArray();
            }
            int i = o.dH(str) ? 1 : 0;
            com.tencent.mm.pluginsdk.model.app.l.a(aVar, aVar.hjN, aVar.title, str, null, bArr);
            g.oUh.i(14127, aVar.hjN, aVar.hjM, aVar.hjL, aVar.title, aVar.description, "", aVar.url, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(i), str);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.ChattingEditModeSendToAppBrand", e, "", new Object[0]);
            w.e("MicroMsg.ChattingEditModeSendToAppBrand", "retransmit sigle app msg error : %s", e.getLocalizedMessage());
        }
    }

    public static f.a a(String str, l lVar) {
        f.a aVar = new f.a();
        aVar.title = lVar.title;
        aVar.description = lVar.hku;
        aVar.type = 33;
        aVar.hjM = lVar.hkx;
        aVar.hjL = lVar.hky;
        aVar.hjN = lVar.hkB;
        aVar.hjT = lVar.hkA;
        aVar.hjU = lVar.hkz;
        aVar.hjP = "";
        aVar.hjO = 2;
        aVar.url = lVar.url;
        aVar.hjV = lVar.hkD;
        aVar.fUX = "wxapp_" + lVar.hkB + lVar.hky;
        aVar.fUR = lVar.hkx;
        aVar.fUS = lVar.hkE;
        c aVar2 = new com.tencent.mm.t.a();
        aVar2.hhi = false;
        aVar2.hhj = "";
        aVar.a(aVar2);
        if (bg.mA(aVar.thumburl)) {
            com.tencent.mm.x.h hs = n.Bm().hs(str);
            if (hs != null) {
                aVar.thumburl = hs.Bs();
            }
        }
        return aVar;
    }

    public static boolean g(au auVar, int i) {
        if (auVar == null || !auVar.bLX()) {
            return false;
        }
        List list = ((a) h.h(a.class)).rV(auVar.field_content).hkm;
        if (bg.bV(list)) {
            return false;
        }
        if (i < 0 || i >= list.size()) {
            i = 0;
        }
        if (com.tencent.mm.t.h.em(((l) list.get(i)).hkx)) {
            return true;
        }
        return false;
    }
}
