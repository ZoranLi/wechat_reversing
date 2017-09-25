package com.tencent.mm.plugin.location.ui;

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

public class SimpleImageView extends ImageView {
    public ae handler = new ae(this) {
        final /* synthetic */ SimpleImageView neK;

        {
            this.neK = r1;
        }

        public final void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null || bArr.length == 0) {
                w.e("MicroMsg.SimpleImageView", "handleMsg fail, data is null");
                return;
            }
            Bitmap bitmap;
            Bitmap bd = d.bd(bArr);
            w.d("MicroMsg.SimpleImageView", "filePath  %s", new Object[]{this.neK.imagePath + g.n(this.neK.url.getBytes())});
            e.b(r2, bArr, bArr.length);
            if (bd == null || this.neK.neJ <= 0 || this.neK.lKi <= 0) {
                bitmap = bd;
            } else {
                bitmap = d.a(bd, this.neK.lKi, this.neK.neJ, true, false);
            }
            this.neK.setImageBitmap(bitmap);
        }
    };
    public String imagePath;
    public int lKi;
    public int neJ;
    public String url = null;

    static class a implements Runnable {
        private ae handler;
        private String url;

        public a(String str, ae aeVar) {
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

    public SimpleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
