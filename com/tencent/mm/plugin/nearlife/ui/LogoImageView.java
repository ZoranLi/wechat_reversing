package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;

public class LogoImageView extends ImageView {
    ae handler = new ae(this) {
        final /* synthetic */ LogoImageView nYs;

        {
            this.nYs = r1;
        }

        public final void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null || bArr.length == 0) {
                w.e("MicroMsg.LogoImageView", "handleMsg fail, data is null");
                return;
            }
            Bitmap bitmap;
            Bitmap bd = d.bd(bArr);
            w.d("MicroMsg.LogoImageView", "filePath  %s", new Object[]{this.nYs.imagePath + g.n(this.nYs.url.getBytes())});
            e.b(r2, bArr, bArr.length);
            if (bd == null || this.nYs.neJ <= 0 || this.nYs.lKi <= 0) {
                bitmap = bd;
            } else {
                bitmap = d.a(bd, this.nYs.lKi, this.nYs.neJ, true, false);
            }
            this.nYs.setImageBitmap(bitmap);
        }
    };
    String imagePath;
    int lKi;
    int neJ;
    String url = null;

    static class a implements Runnable {
        private ae handler;
        private String url;

        a(String str, ae aeVar) {
            this.url = str;
            this.handler = aeVar;
        }

        public final void run() {
            Object Qc = bg.Qc(this.url);
            Message obtain = Message.obtain();
            obtain.obj = Qc;
            this.handler.sendMessage(obtain);
        }
    }

    public LogoImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
