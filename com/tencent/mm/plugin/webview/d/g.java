package com.tencent.mm.plugin.webview.d;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Locale;

public final class g {
    ae jiB = new ae(Looper.getMainLooper(), this.rZH);
    View rZE;
    public String rZF;
    c rZG;
    private com.tencent.mm.sdk.platformtools.ae.a rZH = new com.tencent.mm.sdk.platformtools.ae.a(this) {
        final /* synthetic */ g rZI;

        {
            this.rZI = r1;
        }

        public final boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Bitmap createBitmap = Bitmap.createBitmap(this.rZI.rZE.getWidth(), this.rZI.rZE.getHeight(), Config.ARGB_8888);
                    if (createBitmap != null) {
                        createBitmap.eraseColor(-1);
                        this.rZI.rZE.draw(new Canvas(createBitmap));
                    }
                    if (createBitmap != null) {
                        e.post(new b(this.rZI, createBitmap), "ViewCaptureHelper_SaveBitmap");
                        this.rZI.rZE = null;
                        break;
                    }
                    break;
                case 2:
                    if (this.rZI.rZG != null) {
                        this.rZI.rZG.pF(this.rZI.rZF);
                        break;
                    }
                    break;
            }
            return false;
        }
    };

    private final class a implements Runnable {
        final /* synthetic */ g rZI;

        public a(g gVar) {
            this.rZI = gVar;
        }

        public final void run() {
            if (this.rZI.rZF != null) {
                int length = new File(this.rZI.rZF).getParentFile().listFiles(new FilenameFilter(this) {
                    final /* synthetic */ a rZJ;

                    {
                        this.rZJ = r1;
                    }

                    public final boolean accept(File file, String str) {
                        return str.matches(".+_.+.\\.jpg");
                    }
                }).length;
                for (int i = 0; i < length; i++) {
                    w.i("MicroMsg.ViewCaptureHelper", "deleteFile result: %b", new Object[]{Boolean.valueOf(r2[i].delete())});
                }
                this.rZI.rZF = null;
            }
        }
    }

    private final class b implements Runnable {
        private Bitmap mBitmap;
        final /* synthetic */ g rZI;

        public b(g gVar, Bitmap bitmap) {
            this.rZI = gVar;
            this.mBitmap = bitmap;
        }

        public final void run() {
            this.rZI.rZF = String.format(Locale.US, "%s%s_%08x.jpg", new Object[]{com.tencent.mm.compatible.util.e.hgu, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.mBitmap.hashCode())});
            try {
                d.a(this.mBitmap, 100, CompressFormat.JPEG, this.rZI.rZF, true);
            } catch (IOException e) {
                w.e("MicroMsg.ViewCaptureHelper", "saveBitmapToImage failed, " + e.getMessage());
                this.rZI.rZF = null;
            }
            this.mBitmap.recycle();
            this.rZI.jiB.sendEmptyMessage(2);
        }
    }

    public interface c {
        void pF(String str);
    }

    public final void a(View view, c cVar) {
        this.rZE = view;
        this.rZG = cVar;
        this.jiB.sendEmptyMessage(1);
    }

    public final void bxd() {
        e.post(new a(this), "ViewCaptureHelper_DeleteBitmap");
    }
}
