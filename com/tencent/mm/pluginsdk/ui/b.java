package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.x.d.a;

public final class b extends j implements a {
    Bitmap kcf;
    private float sIi;

    private b(String str) {
        super(com.tencent.mm.pluginsdk.ui.a.b.bEa(), str);
        this.sIi = 0.5f;
        this.kcf = null;
    }

    public b(String str, float f) {
        this(str);
        this.sIi = f;
    }

    public final void ho(String str) {
        super.ho(str);
    }

    public final void draw(Canvas canvas) {
        Bitmap bitmap = null;
        com.tencent.mm.be.a.a aVar = com.tencent.mm.be.a.a.a.upb;
        if (aVar != null) {
            bitmap = com.tencent.mm.be.a.a.a.upb.zo(this.tag);
        }
        if (bitmap != null) {
            a(canvas, bitmap);
            return;
        }
        if (this.sJb) {
            bitmap = this.owB.a(this.tag, canvas.getWidth(), canvas.getHeight(), 1);
        } else {
            bitmap = this.owB.bf(this.tag);
        }
        if (bitmap != null) {
            bitmap = d.a(bitmap, false, this.sIi * ((float) bitmap.getWidth()));
            if (aVar != null) {
                aVar.o(this.tag, bitmap);
            }
            a(canvas, bitmap);
        } else if (bitmap == null || bitmap.isRecycled()) {
            if (this.kcf == null) {
                try {
                    this.kcf = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(ab.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bg.a.getDensity(null));
                    this.kcf = d.a(this.kcf, false, this.sIi * ((float) this.kcf.getWidth()));
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.AvatarRoundDrawable", e, "", new Object[0]);
                }
            }
            a(canvas, this.kcf);
        }
    }

    private void a(Canvas canvas, Bitmap bitmap) {
        Rect bounds = getBounds();
        Rect rect = null;
        if (this.sJg > 1.0f || this.sJa) {
            int height = (bitmap.getHeight() / 15) / 2;
            int width = (bitmap.getWidth() / 15) / 2;
            rect = new Rect(width, height, bitmap.getWidth() - width, bitmap.getHeight() - height);
        }
        canvas.drawBitmap(bitmap, rect, bounds, hgY);
    }
}
