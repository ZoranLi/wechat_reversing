package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.mm.a.g;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.i.a;
import com.tencent.mm.plugin.comm.a.c;
import com.tencent.mm.plugin.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public final class d implements i {
    private int height = 0;
    private String lEi;
    private String url;
    private int width = 0;

    public d(String str, String str2) {
        this.lEi = str;
        this.url = str2;
    }

    public final String Nm() {
        return b.xb() + "/" + g.n(this.url.getBytes());
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
        return BitmapFactory.decodeResource(ab.getContext().getResources(), c.bhR);
    }

    public final Bitmap a(Bitmap bitmap, a aVar, String str) {
        FileOutputStream fileOutputStream;
        Throwable e;
        if (a.NET == aVar) {
            try {
                w.v("MicroMsg.DefaultPicStrategy", "handlerBitmap get from net url:%s", this.url);
                if (this.width > 0 && this.height > 0) {
                    bitmap = com.tencent.mm.sdk.platformtools.d.a(bitmap, this.width, this.height, true);
                }
                File file = new File(Nm());
                file.createNewFile();
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        try {
                            w.printErrStackTrace("MicroMsg.DefaultPicStrategy", e, "", new Object[0]);
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
                    w.printErrStackTrace("MicroMsg.DefaultPicStrategy", e, "", new Object[0]);
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
                w.printErrStackTrace("MicroMsg.DefaultPicStrategy", e4, "", new Object[0]);
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

    public final i.b Nl() {
        return null;
    }
}
