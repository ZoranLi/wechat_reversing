package com.tencent.mm.plugin.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mm.bg.a;
import com.tencent.mm.e.a.hp;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.m.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public class MMGIFImageView extends ImageView {
    public String kHX;
    private float mDensity;
    public int mKc;
    private int mKd;
    private boolean mKe;

    public MMGIFImageView(Context context) {
        this(context, null);
    }

    public MMGIFImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public MMGIFImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mKc = d.laf;
        this.mKd = d.bhS;
        this.mKe = true;
        this.mDensity = 0.0f;
    }

    public void setImageResource(int i) {
        a(getResources(), i, true);
    }

    public void setBackgroundResource(int i) {
        a(getResources(), i, false);
    }

    public final void yj(String str) {
        ct(str, null);
    }

    public final void cs(String str, String str2) {
        ct(str, str2);
    }

    public final void h(byte[] bArr, String str) {
        try {
            Drawable aVar;
            if (bg.mA(str)) {
                aVar = new a(bArr);
            } else {
                this.kHX = str;
                aVar = b.aCV().p(this.kHX, bArr);
            }
            setImageDrawable(aVar);
        } catch (MMGIFException e) {
            a(e);
            if (e.getErrorCode() == 103) {
                Bitmap bd = com.tencent.mm.sdk.platformtools.d.bd(bArr);
                if (bd != null) {
                    bd.setDensity(320);
                    setImageBitmap(bd);
                    return;
                }
                w.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed bitmap is null. bytes %s", bArr.toString());
                init();
                return;
            }
            w.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed. %s", e.toString());
            init();
        } catch (IOException e2) {
            w.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileByteArray failed. %s", e2.toString());
            init();
        }
    }

    public final void a(InputStream inputStream, String str) {
        Drawable drawable = null;
        try {
            if (bg.mA(str)) {
                drawable = new a(inputStream);
            } else {
                this.kHX = str;
                b aCV = b.aCV();
                String str2 = this.kHX;
                if (inputStream != null) {
                    w.d("MicroMsg.GIF.MMGIFDrawableCacheMgr", "stream key:%s", str2);
                    if (aCV.mJP.get(str2) != null) {
                        drawable = (a) ((WeakReference) aCV.mJP.get(str2)).get();
                    }
                    if (drawable == null) {
                        drawable = new a(inputStream);
                        aCV.mJP.put(str2, new WeakReference(drawable));
                    }
                }
            }
            setImageDrawable(drawable);
        } catch (MMGIFException e) {
            a(e);
            if (e.getErrorCode() == 103) {
                Bitmap decodeStream = com.tencent.mm.sdk.platformtools.d.decodeStream(inputStream);
                if (decodeStream != null) {
                    decodeStream.setDensity(320);
                    setImageBitmap(decodeStream);
                    return;
                }
                w.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failedbitmap is null. bytes %s");
                init();
                return;
            }
            w.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failed. %s", e.toString());
            init();
        } catch (IOException e2) {
            w.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFileInputStream failed. %s", e2.toString());
            init();
        }
    }

    public final float aCU() {
        if (this.mDensity == 0.0f) {
            this.mDensity = a.getDensity(ab.getContext()) / 2.0f;
            if (this.mDensity < 1.0f) {
                this.mDensity = 1.0f;
            } else if (this.mDensity > 2.0f) {
                this.mDensity = 2.0f;
            }
        }
        return this.mDensity;
    }

    private void a(Resources resources, int i, boolean z) {
        Drawable drawable = null;
        try {
            if (bg.mA(null)) {
                drawable = new a(resources, i);
            } else {
                this.kHX = null;
                b aCV = b.aCV();
                if (aCV.mJP.get(null) != null) {
                    drawable = (a) ((WeakReference) aCV.mJP.get(null)).get();
                }
                if (drawable == null) {
                    drawable = new a(resources, i);
                    aCV.mJP.put(null, new WeakReference(drawable));
                }
            }
            if (z) {
                setImageDrawable(drawable);
            } else {
                setBackgroundDrawable(drawable);
            }
        } catch (IOException e) {
            w.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFResource failed. %s" + e.toString());
            if (z) {
                super.setImageResource(i);
            } else {
                super.setBackgroundResource(i);
            }
        }
    }

    public final void a(String str, e eVar) {
        try {
            Drawable aVar = new a(str);
            setImageDrawable(aVar);
            aVar.mJD = Integer.MAX_VALUE;
            aVar.mJF = eVar;
            return;
        } catch (MMGIFException e) {
            try {
                a(e);
                if (e.getErrorCode() == 103) {
                    Bitmap decodeStream = com.tencent.mm.sdk.platformtools.d.decodeStream(new FileInputStream(str));
                    if (decodeStream != null) {
                        decodeStream.setDensity(320);
                        setImageBitmap(decodeStream);
                        return;
                    }
                    w.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed bitmap is null. show default and delete file. path:%s", str);
                    init();
                    b.deleteFile(str);
                    return;
                }
            } catch (FileNotFoundException e2) {
                w.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + e2.toString());
            }
            w.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + e.toString());
        } catch (IOException e3) {
            w.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed. %s" + e3.toString());
        }
        init();
    }

    public final void ct(String str, String str2) {
        try {
            Drawable aVar;
            if (bg.mA(str2)) {
                aVar = new a(str);
            } else {
                this.kHX = str2;
                aVar = b.aCV().cr(this.kHX, str);
            }
            setImageDrawable(aVar);
        } catch (MMGIFException e) {
            try {
                a(e);
                if (e.getErrorCode() == 103) {
                    Bitmap decodeFile = com.tencent.mm.sdk.platformtools.d.decodeFile(str, null);
                    if (decodeFile != null) {
                        decodeFile.setDensity(320);
                        setImageBitmap(decodeFile);
                        return;
                    }
                    w.w("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failedbitmap is null. show default and delete file. path %s", str);
                    init();
                    b.deleteFile(str);
                    return;
                }
            } catch (Throwable e2) {
                w.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed1. %s", bg.g(e2));
            }
            init();
        } catch (Throwable e22) {
            w.e("MicroMsg.GIF.MMGIFImageView", "setMMGIFFilePath failed3. %s", bg.g(e22));
            b.deleteFile(str);
            init();
        }
    }

    public final void init() {
        this.mKe = h.vI().isSDCardAvailable();
        if (this.mKe) {
            if (this.mKc > 0) {
                super.setImageResource(this.mKc);
            }
        } else if (this.mKd > 0) {
            super.setImageResource(this.mKd);
        }
    }

    public final void resume() {
        if (getDrawable() != null && (getDrawable() instanceof a)) {
            a aVar = (a) getDrawable();
            if (!aVar.mJl) {
                aVar.lp = true;
                aVar.d(aVar.mJH, 0);
            }
        }
    }

    public static void a(MMGIFException mMGIFException) {
        com.tencent.mm.sdk.b.b hpVar = new hp();
        hpVar.fNe.errorCode = mMGIFException.getErrorCode();
        com.tencent.mm.sdk.b.a.urY.m(hpVar);
    }

    public final void recycle() {
        if (getDrawable() != null && (getDrawable() instanceof a)) {
            ((a) getDrawable()).recycle();
        }
    }
}
