package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.mm.plugin.gallery.model.b.b;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class h extends Drawable implements b {
    private static final Paint hgY = new Paint();
    private static Rect rect = null;
    private int aar;
    protected int fIL = 0;
    protected ImageView kZz;
    private Bitmap mBitmap;
    protected String mFilePath = "";
    protected String mdY = "";
    protected long mdZ = 0;
    private Runnable miA = new Runnable(this) {
        final /* synthetic */ h miB;

        {
            this.miB = r1;
        }

        public final void run() {
            w.v("MicroMsg.ThumbDrawable", "invalidateSelf");
            h hVar = this.miB;
            com.tencent.mm.plugin.gallery.model.a ayj = c.ayj();
            String str = this.miB.mFilePath;
            String str2 = this.miB.mdY;
            long j = this.miB.mdZ;
            hVar.mBitmap = ayj.xk(str);
            if (!(this.miB.miw == null || this.miB.mBitmap == null || this.miB.mBitmap.isRecycled())) {
                this.miB.miw.ayR();
            }
            this.miB.mix = SystemClock.uptimeMillis();
            this.miB.invalidateSelf();
        }
    };
    protected boolean miv = false;
    public a miw;
    long mix;
    boolean miy = false;
    private Rect miz = new Rect();

    public interface a {
        void ayR();
    }

    static {
        hgY.setAntiAlias(true);
        hgY.setFilterBitmap(true);
    }

    private h(ImageView imageView) {
        this.kZz = imageView;
        this.mFilePath = "";
    }

    public final int getIntrinsicWidth() {
        return 400;
    }

    public final int getIntrinsicHeight() {
        return 400;
    }

    public final void setBounds(int i, int i2, int i3, int i4) {
        w.v("MicroMsg.ThumbDrawable", "setBountsLTRB:%d %d - %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        super.setBounds(i, i2, i3, i4);
    }

    public final void setBounds(Rect rect) {
        w.v("MicroMsg.ThumbDrawable", "setBountsRECT:%s", new Object[]{rect.toString()});
        super.setBounds(rect);
    }

    public final void draw(Canvas canvas) {
        float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mix)) / 200.0f;
        if (this.mix == 0) {
            w.d("MicroMsg.ThumbDrawable", "[duanyi test]: draw:[%s] startTimeMillis is 0", new Object[]{this.mFilePath});
            uptimeMillis = 0.0f;
        }
        w.d("MicroMsg.ThumbDrawable", "[duanyi test]: hash:[%s] draw:[%s] animating:[%s] normalized:[%s] alpha[%s]", new Object[]{Integer.valueOf(hashCode()), this.mFilePath, Boolean.valueOf(this.miy), Float.valueOf(uptimeMillis), Integer.valueOf((int) (255.0f * uptimeMillis))});
        if (!this.miy) {
            c(canvas, 255);
            setAlpha(255);
        } else if (uptimeMillis >= 1.0f) {
            this.miy = false;
            c(canvas, 255);
        } else if (c(canvas, (int) (uptimeMillis * 255.0f))) {
            invalidateSelf();
        }
    }

    private boolean c(Canvas canvas, int i) {
        if (this.mBitmap == null || this.mBitmap.isRecycled()) {
            w.d("MicroMsg.ThumbDrawable", "[duanyi test] get bitmap is null: " + this.mFilePath);
            if (this.mBitmap != null && this.mBitmap.isRecycled()) {
                this.miy = true;
                this.mix = 0;
                this.mBitmap = c.ayj().b(this.mFilePath, this.fIL, this.mdY, this.mdZ);
                if (!(this.miw == null || this.mBitmap == null || this.mBitmap.isRecycled())) {
                    this.miw.ayR();
                }
            }
            return false;
        }
        w.d("MicroMsg.ThumbDrawable", "[duanyi test] get bitmap ok:" + this.mFilePath);
        Bitmap bitmap = this.mBitmap;
        Rect rect = this.miz;
        if (bitmap.getWidth() > bitmap.getHeight()) {
            rect.top = 0;
            rect.bottom = bitmap.getHeight();
            rect.left = (bitmap.getWidth() - bitmap.getHeight()) >> 1;
            rect.right = bitmap.getHeight() + rect.left;
        } else {
            rect.left = 0;
            rect.right = bitmap.getWidth();
            rect.top = (bitmap.getHeight() - bitmap.getWidth()) >> 1;
            rect.bottom = bitmap.getWidth() + rect.top;
        }
        hgY.setAlpha(i);
        canvas.drawBitmap(this.mBitmap, this.miz, getBounds(), hgY);
        w.v("MicroMsg.ThumbDrawable", "Bounts:%s", new Object[]{getBounds().toString()});
        return true;
    }

    public final void xl(String str) {
        if (bg.mA(str)) {
            w.d("MicroMsg.ThumbDrawable", "filepath is null or nill");
        } else if (this.mFilePath.equals(str)) {
            w.d("MicroMsg.ThumbDrawable", "notify thumb get " + str);
            this.kZz.post(this.miA);
        } else {
            w.d("MicroMsg.ThumbDrawable", "not current filepath:[%s]", new Object[]{str});
        }
    }

    public static void a(ImageView imageView, int i, String str, String str2, long j) {
        a(imageView, i, str, str2, j, -1, null);
    }

    public static void a(ImageView imageView, int i, String str, String str2, long j, int i2, a aVar) {
        h hVar;
        String str3;
        Drawable drawable = imageView.getDrawable();
        if (drawable == null || !(drawable instanceof h)) {
            hVar = new h(imageView);
        } else {
            hVar = (h) drawable;
        }
        if (i2 > 0) {
            hVar.aar = i2;
        }
        hVar.miw = aVar;
        if (bg.mA(str)) {
            str3 = str2;
        } else {
            str3 = str;
        }
        if (bg.mA(str3)) {
            w.e("MicroMsg.ThumbDrawable", "filepath is null or nil");
        } else {
            if (bg.mA(str)) {
                hVar.miv = false;
            } else {
                hVar.miv = true;
            }
            c.ayj().a(hVar);
            String str4;
            String str5;
            Object[] objArr;
            if (!hVar.mFilePath.equals(str3) || hVar.mBitmap == null || hVar.mBitmap.isRecycled()) {
                hVar.mFilePath = str3;
                hVar.mdY = str2;
                hVar.mdZ = j;
                hVar.fIL = i;
                hVar.mBitmap = c.ayj().xk(hVar.mFilePath);
                str4 = "MicroMsg.ThumbDrawable";
                str5 = "setMediaFeature ok filePath:[%s] mBitmap:[%s], mBitmap.isRecycled():[%s]";
                objArr = new Object[3];
                objArr[0] = str3;
                objArr[1] = Boolean.valueOf(hVar.mBitmap == null);
                objArr[2] = Boolean.valueOf(hVar.mBitmap != null ? hVar.mBitmap.isRecycled() : false);
                w.d(str4, str5, objArr);
                if (hVar.mBitmap == null || hVar.mBitmap.isRecycled()) {
                    hVar.miy = true;
                    hVar.mix = 0;
                    hVar.mBitmap = c.ayj().b(str3, i, str2, j);
                } else {
                    hVar.miy = false;
                }
                if (!(hVar.miw == null || hVar.mBitmap == null || hVar.mBitmap.isRecycled())) {
                    hVar.miw.ayR();
                }
                hVar.kZz.invalidate();
            } else {
                str4 = "MicroMsg.ThumbDrawable";
                str5 = "setMediaFeature fuck filePath:[%s] mBitmap:[%s], mBitmap.isRecycled():[%s]";
                objArr = new Object[3];
                objArr[0] = str3;
                objArr[1] = Boolean.valueOf(hVar.mBitmap == null);
                objArr[2] = Boolean.valueOf(hVar.mBitmap != null ? hVar.mBitmap.isRecycled() : false);
                w.d(str4, str5, objArr);
            }
        }
        imageView.setImageDrawable(hVar);
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getOpacity() {
        return 0;
    }
}
