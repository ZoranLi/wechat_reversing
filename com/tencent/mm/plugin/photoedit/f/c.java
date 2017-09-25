package com.tencent.mm.plugin.photoedit.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;

public class c implements Cloneable {
    public float gj = 1.0f;
    private com.tencent.mm.storage.a.c kPz;
    public boolean kuw;
    protected Context mContext;
    private Matrix mMatrix;
    private Rect old;
    public String omh;
    public Bitmap omi;
    public PointF omj;
    public int omk = 0;
    private float oml = 1.0f;
    public PointF omm;
    private float omn;
    private float omo;
    public boolean omp = false;
    public List<PointF> omq = new ArrayList();
    public float omr;
    private float oms;

    private class a {
        public float[] omt = new float[this.omv];
        public float[] omu = new float[this.omv];
        public int omv;
        final /* synthetic */ c omw;

        public a(c cVar, List<PointF> list) {
            this.omw = cVar;
            this.omv = list.size();
            for (int i = 0; i < this.omv; i++) {
                this.omt[i] = ((PointF) list.get(i)).x;
                this.omu[i] = ((PointF) list.get(i)).y;
            }
            new StringBuilder("lasso size:").append(this.omv);
        }
    }

    public /* synthetic */ Object clone() {
        return aSK();
    }

    public c(Context context, Matrix matrix, String str, com.tencent.mm.storage.a.c cVar, Rect rect) {
        this.omh = str;
        this.mMatrix = matrix;
        this.kPz = cVar;
        this.mContext = context;
        this.old = rect;
        this.omj = new PointF();
        this.omm = new PointF();
    }

    public final void a(float f, float f2, float f3, int i) {
        this.omi = w(aSI());
        this.omn = (1.2f * ((float) this.old.width())) / ((float) this.omi.getWidth());
        this.omo = (0.1f * ((float) this.old.width())) / ((float) this.omi.getWidth());
        this.oml = f3;
        this.omk = i;
        this.gj /= f3;
        w.i("MicroMsg.EmojiItem", "MAX_SCALE:%s MIN_SCALE:%s mInitScale:%s", Float.valueOf(this.omn), Float.valueOf(this.omo), Float.valueOf(this.oml));
        this.omj.set(f, f2);
        w.d("MicroMsg.EmojiItem", "[setPoint] point:%s", this.omj);
        aSJ();
    }

    public final boolean aSF() {
        w.d("MicroMsg.EmojiItem", "[checkBitmap]");
        if (this.omi != null && !this.omi.isRecycled()) {
            return false;
        }
        this.omi = w(aSI());
        return true;
    }

    public void setSelected(boolean z) {
        this.kuw = z;
    }

    public final void b(float f, float f2, float f3, int i) {
        this.omj.offset(f, f2);
        if (0.0f != f3) {
            this.gj = f3;
        }
        this.omk = i;
    }

    public final void clear() {
        w.i("MicroMsg.EmojiItem", "[clear]");
        if (this.omi != null && !this.omi.isRecycled()) {
            this.omi.recycle();
        }
    }

    public final void draw(Canvas canvas) {
        if (this.omi == null) {
            w.w("MicroMsg.EmojiItem", "[draw] null == mEmojiBoxBmp");
            return;
        }
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        if (this.omn < this.gj * this.oml) {
            this.gj = this.omn / this.oml;
        } else if (this.omo > this.gj * this.oml) {
            this.gj = this.omo / this.oml;
        }
        canvas.save();
        canvas.translate(this.omj.x, this.omj.y);
        canvas.rotate((float) this.omk);
        canvas.scale(this.gj, this.gj);
        if (this.kuw) {
            canvas.drawBitmap(this.omi, (float) ((-aSG()) / 2), (float) ((-aSH()) / 2), null);
        } else {
            canvas.clipRect(((float) ((-aSG()) / 2)) + 40.0f, ((float) ((-aSH()) / 2)) + 40.0f, ((float) (this.omi.getWidth() / 2)) - 40.0f, ((float) (this.omi.getHeight() / 2)) - 40.0f);
            canvas.drawBitmap(this.omi, (float) ((-aSG()) / 2), (float) ((-aSH()) / 2), null);
        }
        canvas.restore();
        canvas.setDrawFilter(null);
    }

    private int aSG() {
        if (this.omi != null) {
            return this.omi.getWidth();
        }
        return 0;
    }

    private int aSH() {
        if (this.omi != null) {
            return this.omi.getHeight();
        }
        return 0;
    }

    protected Bitmap aSI() {
        com.tencent.mm.storage.a.c cVar = this.kPz;
        if (cVar != null) {
            String name;
            if (cVar.field_catalog == com.tencent.mm.storage.a.a.uKR || cVar.field_catalog == com.tencent.mm.storage.a.c.uKX || cVar.field_catalog == com.tencent.mm.storage.a.c.uKW) {
                name = cVar.getName();
                if (bg.mA(name)) {
                    w.i("MicroMsg.EmojiItem", "name is null");
                } else {
                    if (name.startsWith("jsb")) {
                        name = "jsb";
                    } else if (name.startsWith("dice")) {
                        name = "dice";
                    } else {
                        name = name.replaceAll(".png", "");
                    }
                    w.i("MicroMsg.EmojiItem", "id:%s width:%s height:%s", Integer.valueOf(cVar.field_catalog), Integer.valueOf(d.t(this.mContext.getResources().getDrawable(this.mContext.getResources().getIdentifier(name, "drawable", ab.getPackageName()))).getWidth()), Integer.valueOf(d.t(this.mContext.getResources().getDrawable(this.mContext.getResources().getIdentifier(name, "drawable", ab.getPackageName()))).getHeight()));
                    return d.t(this.mContext.getResources().getDrawable(this.mContext.getResources().getIdentifier(name, "drawable", ab.getPackageName())));
                }
            } else if (cVar.field_catalog == com.tencent.mm.storage.a.a.uKQ) {
                name = cVar.getName();
                if (bg.mA(name)) {
                    w.i("MicroMsg.EmojiItem", "name is null");
                } else {
                    name = (bg.mA(cVar.pM()) ? cVar.getName() : cVar.pM()).replaceAll(".png", "");
                }
                w.i("MicroMsg.EmojiItem", "[addEmoji] drawable name:%s", name);
                w.i("MicroMsg.EmojiItem", "id:%s width:%s height:%s", Integer.valueOf(cVar.field_catalog), Integer.valueOf(r0.getWidth()), Integer.valueOf(d.t(this.mContext.getResources().getDrawable(this.mContext.getResources().getIdentifier(name, "drawable", ab.getPackageName()))).getHeight()));
                return d.t(this.mContext.getResources().getDrawable(this.mContext.getResources().getIdentifier(name, "drawable", ab.getPackageName())));
            } else {
                name = cVar.eN(cVar.field_groupId, cVar.EP()) + "_cover";
                w.i("MicroMsg.EmojiItem", "[addEmoji] thumbPath:%s isExist:%s", name, Boolean.valueOf(e.aO(name)));
                if (e.aO(name)) {
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(name, options);
                    if (options.outHeight >= 480 || options.outWidth >= 480) {
                        r0 = d.N(name, 480, 480);
                    } else {
                        r0 = d.N(name, options.outHeight, options.outWidth);
                    }
                    w.i("MicroMsg.EmojiItem", "id:%s width:%s height:%s", Integer.valueOf(cVar.field_catalog), Integer.valueOf(r0.getWidth()), Integer.valueOf(r0.getHeight()));
                    return r0;
                }
                if (e.aO(cVar.eN(cVar.field_groupId, cVar.EP()))) {
                    w.i("MicroMsg.EmojiItem", "bytes size:%s", Integer.valueOf(((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().g(cVar).length));
                    r0 = d.decodeByteArray(r0, 480, 480);
                    if (r0 == null) {
                        return r0;
                    }
                    w.i("MicroMsg.EmojiItem", "emoji:%s width:%s height:%s", cVar, Integer.valueOf(r0.getWidth()), Integer.valueOf(r0.getHeight()));
                    return r0;
                }
                w.w("MicroMsg.EmojiItem", "[addEmoji] Path:%s isExist:%s", cVar.eN(cVar.field_groupId, cVar.EP()), Boolean.valueOf(e.aO(cVar.eN(cVar.field_groupId, cVar.EP()))));
            }
            w.i("MicroMsg.EmojiItem", "emoji:%s", cVar);
        } else {
            w.e("MicroMsg.EmojiItem", "emoji == null!");
        }
        return null;
    }

    private Bitmap w(Bitmap bitmap) {
        int width = (int) (((float) bitmap.getWidth()) + 80.0f);
        int height = (int) (((float) bitmap.getHeight()) + 80.0f);
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 40.0f, 40.0f, null);
        NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(this.mContext.getResources(), BitmapFactory.decodeResource(this.mContext.getResources(), R.g.beH), BitmapFactory.decodeResource(this.mContext.getResources(), R.g.beH).getNinePatchChunk(), new Rect(), null);
        ninePatchDrawable.setBounds(0, 0, width, height);
        ninePatchDrawable.draw(canvas);
        return createBitmap;
    }

    public final void aSJ() {
        double aSG = (double) (aSG() / 2);
        double aSH = (double) (aSH() / 2);
        this.oms = (float) Math.sqrt((aSG * aSG) + (aSH * aSH));
        this.oms *= this.gj / this.oml;
        this.omr = (float) Math.toDegrees(Math.atan(aSH / aSG));
    }

    public PointF ac(float f) {
        PointF pointF = new PointF();
        double d = (((double) (((float) this.omk) + f)) * 3.141592653589793d) / 180.0d;
        pointF.x = this.omj.x + ((float) (((double) this.oms) * Math.cos(d)));
        pointF.y = this.omj.y + ((float) (Math.sin(d) * ((double) this.oms)));
        return pointF;
    }

    public final c aSK() {
        c cVar;
        Throwable e;
        try {
            cVar = (c) super.clone();
            try {
                cVar.omj = new PointF(this.omj.x, this.omj.y);
                cVar.kPz = this.kPz;
            } catch (CloneNotSupportedException e2) {
                e = e2;
                w.printErrStackTrace("MicroMsg.EmojiItem", e, "", new Object[0]);
                return cVar;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            cVar = null;
            e = th;
            w.printErrStackTrace("MicroMsg.EmojiItem", e, "", new Object[0]);
            return cVar;
        }
        return cVar;
    }

    public String toString() {
        return "mEmojiId:" + this.omh + "\n" + this.kPz.toString();
    }
}
