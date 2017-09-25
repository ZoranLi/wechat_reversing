package com.tencent.mm.plugin.shake.d.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.i.b;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;

public final class a extends BitmapDrawable implements com.tencent.mm.platformtools.j.a {
    private static final Paint hgY;
    private static Bitmap pqG;
    private int mGC;
    private String pqD;
    private ImageView pqE;
    private i pqF;
    private int type;
    private String username;

    private static class a implements i {
        private String pqD;

        public a(String str) {
            this.pqD = str;
        }

        public final String Nm() {
            return a.CA(this.pqD);
        }

        public final String Nn() {
            return this.pqD;
        }

        public final String No() {
            return this.pqD;
        }

        public final String Np() {
            return this.pqD;
        }

        public final boolean Nq() {
            return true;
        }

        public final boolean Nr() {
            return false;
        }

        public final Bitmap Ns() {
            return BitmapFactory.decodeResource(ab.getContext().getResources(), R.g.bhP);
        }

        public final Bitmap a(Bitmap bitmap, com.tencent.mm.platformtools.i.a aVar, String str) {
            if (com.tencent.mm.platformtools.i.a.ihH == aVar) {
                try {
                    d.a(bitmap, 100, CompressFormat.PNG, a.CA(this.pqD), false);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.ShakeAvatarDrawable", e, "", new Object[0]);
                    w.w("MicroMsg.ShakeAvatarDrawable", "save bitmap fail");
                }
            }
            w.d("MicroMsg.ShakeAvatarDrawable", "get bitmap, from %s", new Object[]{aVar.toString()});
            return bitmap;
        }

        public final void Nt() {
        }

        public final void F(String str, boolean z) {
        }

        public final void a(com.tencent.mm.platformtools.i.a aVar, String str) {
        }

        public final b Nl() {
            return null;
        }
    }

    static {
        Paint paint = new Paint();
        hgY = paint;
        paint.setAntiAlias(true);
        hgY.setFilterBitmap(true);
    }

    public final void draw(Canvas canvas) {
        w.i("MicroMsg.ShakeAvatarDrawable", "album username[%s], url[%s], type[%d], attr[%s]", new Object[]{this.username, this.pqD, Integer.valueOf(this.type), toString()});
        if (4 == this.type || (k.sA(this.type) && 6 != this.type)) {
            Bitmap a;
            if (4 == this.type) {
                this.pqF = new a(this.pqD);
                a = j.a(this.pqF);
            } else if (!k.sA(this.type) || 6 == this.type) {
                a = null;
            } else {
                this.pqF = new com.tencent.mm.plugin.shake.e.b(this.pqD);
                a = j.a(this.pqF);
            }
            if (a == null || a.isRecycled()) {
                w.i("MicroMsg.ShakeAvatarDrawable", "bm is null or recycled, album url[%s]", new Object[]{this.pqD});
                a = C(this.pqE, this.mGC);
            }
            if (a != null) {
                canvas.drawBitmap(a, null, getBounds(), hgY);
            }
        }
    }

    private static Bitmap C(View view, int i) {
        if (view == null) {
            return pqG;
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (pqG == null || pqG.getWidth() != measuredWidth) {
            if (i > 0) {
                try {
                    pqG = d.t(view.getResources().getDrawable(i));
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.ShakeAvatarDrawable", e, "", new Object[0]);
                }
            } else {
                pqG = BackwardSupportUtil.b.a(ab.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bg.a.getDensity(null));
            }
            if (pqG.getWidth() != measuredWidth && measuredWidth > 0 && measuredHeight > 0) {
                pqG = Bitmap.createScaledBitmap(pqG, measuredWidth, measuredHeight, true);
            }
        }
        return pqG;
    }

    public final void k(String str, final Bitmap bitmap) {
        w.i("MicroMsg.ShakeAvatarDrawable", "type[%d] notifyKey[%s] albumUrl[%s]", new Object[]{Integer.valueOf(this.type), str, this.pqD});
        if (this.pqF != null && str.equals(this.pqF.No())) {
            if (4 == this.type || (k.sA(this.type) && 6 != this.type)) {
                this.pqE.post(new Runnable(this) {
                    final /* synthetic */ a pqH;

                    public final void run() {
                        this.pqH.pqE.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    public static String CA(String str) {
        if (bg.mA(str)) {
            w.w("MicroMsg.ShakeAvatarDrawable", "getStoragePath: but url is null");
            return null;
        }
        if (bg.mA(com.tencent.mm.plugin.shake.d.a.i.bbv())) {
            w.w("MicroMsg.ShakeAvatarDrawable", "getStoragePath, but save dir is null");
            return null;
        }
        return String.format("%s/%s", new Object[]{com.tencent.mm.plugin.shake.d.a.i.bbv(), g.n(str.getBytes())});
    }
}
