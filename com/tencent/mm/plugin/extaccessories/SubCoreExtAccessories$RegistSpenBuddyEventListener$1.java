package com.tencent.mm.plugin.extaccessories;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy.ImageWritingListener;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.e.a.mf;
import com.tencent.mm.plugin.extaccessories.b.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;

class SubCoreExtAccessories$RegistSpenBuddyEventListener$1 implements ImageWritingListener {
    final /* synthetic */ mf lrN;
    final /* synthetic */ a lrO;

    SubCoreExtAccessories$RegistSpenBuddyEventListener$1(a aVar, mf mfVar) {
        this.lrO = aVar;
        this.lrN = mfVar;
    }

    public void onImageReceived(Bitmap bitmap) {
        w.i("MicroMsg.extaccessories.SubCoreExtAccessories", "onImageReceived");
        if (bitmap == null) {
            w.e("MicroMsg.extaccessories.SubCoreExtAccessories", "img is null");
            this.lrN.fTw.fTx.MJ(null);
        } else if (f.rZ()) {
            b bVar = (b) ap.yR().gs("plugin.extaccessories");
            if (bVar == null) {
                w.w("MicroMsg.extaccessories.SubCoreExtAccessories", "not found in MMCore, new one");
                bVar = new b();
                ap.yR().a("plugin.extaccessories", bVar);
            }
            String str = System.currentTimeMillis();
            String str2 = (!ap.zb() || bg.mA(str)) ? "" : bVar.gYf + "image/spen/spen_" + str;
            if (bg.mA(str2)) {
                w.e("MicroMsg.extaccessories.SubCoreExtAccessories", "filePath is null");
                this.lrN.fTw.fTx.MJ(null);
                return;
            }
            try {
                if (bitmap.getWidth() > 1000 || bitmap.getHeight() > 1000) {
                    w.d("MicroMsg.extaccessories.SubCoreExtAccessories", "spen image %d, %d, need scale", new Object[]{Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())});
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / 2, bitmap.getHeight() / 2, true);
                    if (!(bitmap == createScaledBitmap || createScaledBitmap == null)) {
                        bitmap.recycle();
                        bitmap = createScaledBitmap;
                    }
                }
                d.a(bitmap, 55, CompressFormat.JPEG, str2, true);
                w.d("MicroMsg.extaccessories.SubCoreExtAccessories", "save spen temp image : %s", new Object[]{str2});
                this.lrN.fTw.fTx.MJ(str2);
            } catch (Throwable e) {
                w.e("MicroMsg.extaccessories.SubCoreExtAccessories", "Exception %s", new Object[]{e.getMessage()});
                w.printErrStackTrace("MicroMsg.extaccessories.SubCoreExtAccessories", e, "", new Object[0]);
                this.lrN.fTw.fTx.MJ(null);
            }
        } else {
            w.e("MicroMsg.extaccessories.SubCoreExtAccessories", "SDCard not available");
            this.lrN.fTw.fTx.MJ(null);
        }
    }
}
