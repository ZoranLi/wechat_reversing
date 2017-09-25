package android.support.design.widget;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.design.a.i;
import android.support.v4.d.d;
import android.support.v4.d.e;
import android.support.v4.view.z;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.animation.Interpolator;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.qqmusic.mediaplayer.PlayerException;

final class f {
    private static final boolean fG = (VERSION.SDK_INT < 18);
    private static final Paint fH = null;
    private boolean fI;
    float fJ;
    private final Rect fK;
    private final Rect fL;
    private final RectF fM;
    private int fN = 16;
    private int fO = 16;
    float fP = 15.0f;
    float fQ = 15.0f;
    int fR;
    int fS;
    private float fT;
    private float fU;
    private float fV;
    private float fW;
    private float fX;
    private float fY;
    Typeface fZ;
    Typeface ga;
    private Typeface gb;
    private CharSequence gc;
    private boolean gd;
    private boolean ge;
    private Bitmap gf;
    private Paint gg;
    private float gh;
    private float gi;
    private float gj;
    private float gk;
    private boolean gl;
    private final TextPaint gm;
    Interpolator gn;
    private Interpolator go;
    private float gp;
    private float gq;
    private float gr;
    private int gs;
    private float gt;
    private float gu;
    private float gv;
    private int gw;
    CharSequence mText;
    private final View mView;

    public f(View view) {
        this.mView = view;
        this.gm = new TextPaint(129);
        this.fL = new Rect();
        this.fK = new Rect();
        this.fM = new RectF();
    }

    final void a(Interpolator interpolator) {
        this.go = interpolator;
        N();
    }

    final void l(int i) {
        if (this.fS != i) {
            this.fS = i;
            N();
        }
    }

    final void a(int i, int i2, int i3, int i4) {
        if (!a(this.fK, i, i2, i3, i4)) {
            this.fK.set(i, i2, i3, i4);
            this.gl = true;
            L();
        }
    }

    final void b(int i, int i2, int i3, int i4) {
        if (!a(this.fL, i, i2, i3, i4)) {
            this.fL.set(i, i2, i3, i4);
            this.gl = true;
            L();
        }
    }

    private void L() {
        boolean z = this.fL.width() > 0 && this.fL.height() > 0 && this.fK.width() > 0 && this.fK.height() > 0;
        this.fI = z;
    }

    final void m(int i) {
        if (this.fN != i) {
            this.fN = i;
            N();
        }
    }

    final void n(int i) {
        if (this.fO != i) {
            this.fO = i;
            N();
        }
    }

    final void o(int i) {
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(i, i.dk);
        if (obtainStyledAttributes.hasValue(i.dp)) {
            this.fS = obtainStyledAttributes.getColor(i.dp, this.fS);
        }
        if (obtainStyledAttributes.hasValue(i.dq)) {
            this.fQ = (float) obtainStyledAttributes.getDimensionPixelSize(i.dq, (int) this.fQ);
        }
        this.gs = obtainStyledAttributes.getInt(i.dl, 0);
        this.gq = obtainStyledAttributes.getFloat(i.dm, 0.0f);
        this.gr = obtainStyledAttributes.getFloat(i.dn, 0.0f);
        this.gp = obtainStyledAttributes.getFloat(i.do, 0.0f);
        obtainStyledAttributes.recycle();
        if (VERSION.SDK_INT >= 16) {
            this.fZ = q(i);
        }
        N();
    }

    final void p(int i) {
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(i, i.dk);
        if (obtainStyledAttributes.hasValue(i.dp)) {
            this.fR = obtainStyledAttributes.getColor(i.dp, this.fR);
        }
        if (obtainStyledAttributes.hasValue(i.dq)) {
            this.fP = (float) obtainStyledAttributes.getDimensionPixelSize(i.dq, (int) this.fP);
        }
        this.gw = obtainStyledAttributes.getInt(i.dl, 0);
        this.gu = obtainStyledAttributes.getFloat(i.dm, 0.0f);
        this.gv = obtainStyledAttributes.getFloat(i.dn, 0.0f);
        this.gt = obtainStyledAttributes.getFloat(i.do, 0.0f);
        obtainStyledAttributes.recycle();
        if (VERSION.SDK_INT >= 16) {
            this.ga = q(i);
        }
        N();
    }

    private Typeface q(int i) {
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(i, new int[]{16843692});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                Typeface create = Typeface.create(string, 0);
                return create;
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    final void e(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (f != this.fJ) {
            this.fJ = f;
            M();
        }
    }

    private void M() {
        f(this.fJ);
    }

    private void f(float f) {
        this.fM.left = a((float) this.fK.left, (float) this.fL.left, f, this.gn);
        this.fM.top = a(this.fT, this.fU, f, this.gn);
        this.fM.right = a((float) this.fK.right, (float) this.fL.right, f, this.gn);
        this.fM.bottom = a((float) this.fK.bottom, (float) this.fL.bottom, f, this.gn);
        this.fX = a(this.fV, this.fW, f, this.gn);
        this.fY = a(this.fT, this.fU, f, this.gn);
        g(a(this.fP, this.fQ, f, this.go));
        if (this.fS != this.fR) {
            this.gm.setColor(b(this.fR, this.fS, f));
        } else {
            this.gm.setColor(this.fS);
        }
        this.gm.setShadowLayer(a(this.gt, this.gp, f, null), a(this.gu, this.gq, f, null), a(this.gv, this.gr, f, null), b(this.gw, this.gs, f));
        z.F(this.mView);
    }

    public final void draw(Canvas canvas) {
        int save = canvas.save();
        if (this.gc != null && this.fI) {
            float f;
            float f2 = this.fX;
            float f3 = this.fY;
            int i = (!this.ge || this.gf == null) ? 0 : 1;
            if (i != 0) {
                f = this.gh * this.gj;
            } else {
                this.gm.ascent();
                f = 0.0f;
                this.gm.descent();
            }
            if (i != 0) {
                f3 += f;
            }
            if (this.gj != 1.0f) {
                canvas.scale(this.gj, this.gj, f2, f3);
            }
            if (i != 0) {
                canvas.drawBitmap(this.gf, f2, f3, this.gg);
            } else {
                canvas.drawText(this.gc, 0, this.gc.length(), f2, f3, this.gm);
            }
        }
        canvas.restoreToCount(save);
    }

    private void g(float f) {
        h(f);
        boolean z = fG && this.gj != 1.0f;
        this.ge = z;
        if (this.ge && this.gf == null && !this.fK.isEmpty() && !TextUtils.isEmpty(this.gc)) {
            f(0.0f);
            this.gh = this.gm.ascent();
            this.gi = this.gm.descent();
            int round = Math.round(this.gm.measureText(this.gc, 0, this.gc.length()));
            int round2 = Math.round(this.gi - this.gh);
            if (round > 0 && round2 > 0) {
                this.gf = Bitmap.createBitmap(round, round2, Config.ARGB_8888);
                new Canvas(this.gf).drawText(this.gc, 0, this.gc.length(), 0.0f, ((float) round2) - this.gm.descent(), this.gm);
                if (this.gg == null) {
                    this.gg = new Paint(3);
                }
            }
        }
        z.F(this.mView);
    }

    private void h(float f) {
        boolean z = true;
        if (this.mText != null) {
            float width;
            float f2;
            boolean z2;
            if (c(f, this.fQ)) {
                width = (float) this.fL.width();
                float f3 = this.fQ;
                this.gj = 1.0f;
                if (this.gb != this.fZ) {
                    this.gb = this.fZ;
                    f2 = width;
                    width = f3;
                    z2 = true;
                } else {
                    f2 = width;
                    width = f3;
                    z2 = false;
                }
            } else {
                f2 = (float) this.fK.width();
                width = this.fP;
                if (this.gb != this.ga) {
                    this.gb = this.ga;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (c(f, this.fP)) {
                    this.gj = 1.0f;
                } else {
                    this.gj = f / this.fP;
                }
            }
            if (f2 > 0.0f) {
                if (this.gk != width || this.gl || r0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.gk = width;
                this.gl = false;
            }
            if (this.gc == null || r0) {
                this.gm.setTextSize(this.gk);
                this.gm.setTypeface(this.gb);
                TextPaint textPaint = this.gm;
                if (this.gj != 1.0f) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                textPaint.setLinearText(z2);
                CharSequence ellipsize = TextUtils.ellipsize(this.mText, this.gm, f2, TruncateAt.END);
                if (!TextUtils.equals(ellipsize, this.gc)) {
                    d dVar;
                    this.gc = ellipsize;
                    CharSequence charSequence = this.gc;
                    if (z.J(this.mView) != 1) {
                        z = false;
                    }
                    if (z) {
                        dVar = e.vB;
                    } else {
                        dVar = e.vA;
                    }
                    this.gd = dVar.a(charSequence, charSequence.length());
                }
            }
        }
    }

    public final void N() {
        int i = 1;
        float f = 0.0f;
        if (this.mView.getHeight() > 0 && this.mView.getWidth() > 0) {
            float measureText;
            float f2 = this.gk;
            h(this.fQ);
            if (this.gc != null) {
                measureText = this.gm.measureText(this.gc, 0, this.gc.length());
            } else {
                measureText = 0.0f;
            }
            int absoluteGravity = android.support.v4.view.f.getAbsoluteGravity(this.fO, this.gd ? 1 : 0);
            switch (absoluteGravity & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                case 48:
                    this.fU = ((float) this.fL.top) - this.gm.ascent();
                    break;
                case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                    this.fU = (float) this.fL.bottom;
                    break;
                default:
                    this.fU = (((this.gm.descent() - this.gm.ascent()) / 2.0f) - this.gm.descent()) + ((float) this.fL.centerY());
                    break;
            }
            switch (absoluteGravity & 8388615) {
                case 1:
                    this.fW = ((float) this.fL.centerX()) - (measureText / 2.0f);
                    break;
                case 5:
                    this.fW = ((float) this.fL.right) - measureText;
                    break;
                default:
                    this.fW = (float) this.fL.left;
                    break;
            }
            h(this.fP);
            if (this.gc != null) {
                f = this.gm.measureText(this.gc, 0, this.gc.length());
            }
            int i2 = this.fN;
            if (!this.gd) {
                i = 0;
            }
            i2 = android.support.v4.view.f.getAbsoluteGravity(i2, i);
            switch (i2 & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                case 48:
                    this.fT = ((float) this.fK.top) - this.gm.ascent();
                    break;
                case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                    this.fT = (float) this.fK.bottom;
                    break;
                default:
                    this.fT = (((this.gm.descent() - this.gm.ascent()) / 2.0f) - this.gm.descent()) + ((float) this.fK.centerY());
                    break;
            }
            switch (i2 & 8388615) {
                case 1:
                    this.fV = ((float) this.fK.centerX()) - (f / 2.0f);
                    break;
                case 5:
                    this.fV = ((float) this.fK.right) - f;
                    break;
                default:
                    this.fV = (float) this.fK.left;
                    break;
            }
            O();
            g(f2);
            M();
        }
    }

    final void setText(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.mText)) {
            this.mText = charSequence;
            this.gc = null;
            O();
            N();
        }
    }

    private void O() {
        if (this.gf != null) {
            this.gf.recycle();
            this.gf = null;
        }
    }

    private static boolean c(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    private static int b(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((((float) Color.alpha(i)) * f2) + (((float) Color.alpha(i2)) * f)), (int) ((((float) Color.red(i)) * f2) + (((float) Color.red(i2)) * f)), (int) ((((float) Color.green(i)) * f2) + (((float) Color.green(i2)) * f)), (int) ((f2 * ((float) Color.blue(i))) + (((float) Color.blue(i2)) * f)));
    }

    private static float a(float f, float f2, float f3, Interpolator interpolator) {
        if (interpolator != null) {
            f3 = interpolator.getInterpolation(f3);
        }
        return a.b(f, f2, f3);
    }

    private static boolean a(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }
}
