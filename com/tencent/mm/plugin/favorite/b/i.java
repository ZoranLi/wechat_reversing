package com.tencent.mm.plugin.favorite.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.platformtools.i.a;
import com.tencent.mm.platformtools.i.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public final class i implements com.tencent.mm.platformtools.i {
    private int height;
    private String lEi;
    private String url;
    private int width;

    public i(String str, String str2, int i, int i2) {
        this.lEi = str;
        this.url = str2;
        this.width = i;
        this.height = i2;
    }

    public final b Nl() {
        return null;
    }

    public final String Nm() {
        return x.aty() + g.n(this.url.getBytes());
    }

    public final String Nn() {
        return this.url;
    }

    public final String No() {
        return this.lEi;
    }

    public final String Np() {
        return this.lEi;
    }

    public final boolean Nq() {
        return true;
    }

    public final boolean Nr() {
        return false;
    }

    public final Bitmap Ns() {
        return BitmapFactory.decodeResource(ab.getContext().getResources(), R.g.bhR);
    }

    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        Throwable e;
        if (a.ihH == aVar) {
            try {
                w.v("MicroMsg.FavGetPicStrategy", "handlerBitmap get from net url:%s", new Object[]{this.url});
                File file = new File(x.aty());
                if (!file.exists()) {
                    file.mkdirs();
                }
                if (this.width > 0 && this.height > 0) {
                    bitmap = d.a(bitmap, this.width, this.height, true);
                }
                File file2 = new File(Nm());
                file2.createNewFile();
                FileOutputStream fileOutputStream;
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        try {
                            w.printErrStackTrace("MicroMsg.FavGetPicStrategy", e, "", new Object[0]);
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            return bitmap;
                        } catch (Throwable th) {
                            e = th;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw e;
                        }
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileOutputStream = null;
                    w.printErrStackTrace("MicroMsg.FavGetPicStrategy", e, "", new Object[0]);
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return bitmap;
                } catch (Throwable th2) {
                    e = th2;
                    fileOutputStream = null;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e;
                }
            } catch (Throwable e4) {
                w.printErrStackTrace("MicroMsg.FavGetPicStrategy", e4, "", new Object[0]);
            }
        }
        return bitmap;
    }

    public final void Nt() {
    }

    public final void F(String str, boolean z) {
    }

    public final void a(a aVar, String str) {
    }
}
