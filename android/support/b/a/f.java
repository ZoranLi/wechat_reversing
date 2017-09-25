package android.support.b.a;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Xml;
import com.tencent.mm.plugin.appbrand.jsapi.cn;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.am;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
public final class f extends e {
    static final Mode mk = Mode.SRC_IN;
    f ml;
    private PorterDuffColorFilter mm;
    private ColorFilter mn;
    private boolean mo;
    boolean mp;
    private ConstantState mq;
    private final float[] mr;
    private final Matrix ms;
    private final Rect mt;

    private static class c {
        public final Matrix mH = new Matrix();
        final ArrayList<Object> mI = new ArrayList();
        public float mJ = 0.0f;
        float mK = 0.0f;
        float mL = 0.0f;
        float mM = 1.0f;
        float mN = 1.0f;
        float mO = 0.0f;
        float mP = 0.0f;
        public final Matrix mQ = new Matrix();
        String mR = null;
        public int ma;
        int[] mu;

        public c(c cVar, android.support.v4.e.a<String, Object> aVar) {
            this.mJ = cVar.mJ;
            this.mK = cVar.mK;
            this.mL = cVar.mL;
            this.mM = cVar.mM;
            this.mN = cVar.mN;
            this.mO = cVar.mO;
            this.mP = cVar.mP;
            this.mu = cVar.mu;
            this.mR = cVar.mR;
            this.ma = cVar.ma;
            if (this.mR != null) {
                aVar.put(this.mR, this);
            }
            this.mQ.set(cVar.mQ);
            ArrayList arrayList = cVar.mI;
            for (int i = 0; i < arrayList.size(); i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof c) {
                    this.mI.add(new c((c) obj, aVar));
                } else {
                    d bVar;
                    if (obj instanceof b) {
                        bVar = new b((b) obj);
                    } else if (obj instanceof a) {
                        bVar = new a((a) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.mI.add(bVar);
                    if (bVar.mT != null) {
                        aVar.put(bVar.mT, bVar);
                    }
                }
            }
        }
    }

    private static class d {
        protected android.support.b.a.c.b[] mS = null;
        String mT;
        int ma;

        public d(d dVar) {
            this.mT = dVar.mT;
            this.ma = dVar.ma;
            this.mS = c.a(dVar.mS);
        }

        public final void a(Path path) {
            path.reset();
            if (this.mS != null) {
                android.support.b.a.c.b[] bVarArr = this.mS;
                float[] fArr = new float[6];
                int i = 0;
                char c = 'm';
                while (i < bVarArr.length) {
                    int i2;
                    char c2 = bVarArr[i].mh;
                    float[] fArr2 = bVarArr[i].mi;
                    float f = fArr[0];
                    float f2 = fArr[1];
                    float f3 = fArr[2];
                    float f4 = fArr[3];
                    float f5 = fArr[4];
                    float f6 = fArr[5];
                    switch (c2) {
                        case 'A':
                        case PlayerException.EXCEPTION_IN_RELEASE /*97*/:
                            i2 = 7;
                            break;
                        case 'C':
                        case 'c':
                            i2 = 6;
                            break;
                        case q.CTRL_INDEX /*72*/:
                        case 'V':
                        case 'h':
                        case 'v':
                            i2 = 1;
                            break;
                        case 'L':
                        case am.CTRL_BYTE /*77*/:
                        case 'T':
                        case 'l':
                        case MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM /*109*/:
                        case 't':
                            i2 = 2;
                            break;
                        case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_NATIVE_DATASOURCE /*81*/:
                        case cn.CTRL_INDEX /*83*/:
                        case 'q':
                        case 's':
                            i2 = 4;
                            break;
                        case PlayerException.EXCEPTION_IN_SETDATASOURCE /*90*/:
                        case 'z':
                            path.close();
                            path.moveTo(f5, f6);
                            f4 = f6;
                            f3 = f5;
                            f2 = f6;
                            f = f5;
                            i2 = 2;
                            break;
                        default:
                            i2 = 2;
                            break;
                    }
                    int i3 = 0;
                    float f7 = f6;
                    float f8 = f5;
                    float f9 = f2;
                    float f10 = f;
                    while (i3 < fArr2.length) {
                        switch (c2) {
                            case 'A':
                                android.support.b.a.c.b.a(path, f10, f9, fArr2[i3 + 5], fArr2[i3 + 6], fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3] != 0.0f, fArr2[i3 + 4] != 0.0f);
                                f3 = fArr2[i3 + 5];
                                f4 = fArr2[i3 + 6];
                                f6 = f7;
                                f5 = f8;
                                f2 = f4;
                                f = f3;
                                break;
                            case 'C':
                                path.cubicTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3], fArr2[i3 + 4], fArr2[i3 + 5]);
                                f5 = fArr2[i3 + 4];
                                f6 = fArr2[i3 + 5];
                                f3 = fArr2[i3 + 2];
                                f4 = fArr2[i3 + 3];
                                f2 = f6;
                                f = f5;
                                f6 = f7;
                                f5 = f8;
                                break;
                            case q.CTRL_INDEX /*72*/:
                                path.lineTo(fArr2[i3 + 0], f9);
                                f6 = f7;
                                f2 = f9;
                                f = fArr2[i3 + 0];
                                f5 = f8;
                                break;
                            case 'L':
                                path.lineTo(fArr2[i3 + 0], fArr2[i3 + 1]);
                                f5 = fArr2[i3 + 0];
                                f2 = fArr2[i3 + 1];
                                f = f5;
                                f6 = f7;
                                f5 = f8;
                                break;
                            case am.CTRL_BYTE /*77*/:
                                f5 = fArr2[i3 + 0];
                                f6 = fArr2[i3 + 1];
                                if (i3 <= 0) {
                                    path.moveTo(fArr2[i3 + 0], fArr2[i3 + 1]);
                                    f2 = f6;
                                    f = f5;
                                    break;
                                }
                                path.lineTo(fArr2[i3 + 0], fArr2[i3 + 1]);
                                f2 = f6;
                                f = f5;
                                f6 = f7;
                                f5 = f8;
                                break;
                            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_NATIVE_DATASOURCE /*81*/:
                                path.quadTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3]);
                                f3 = fArr2[i3 + 0];
                                f4 = fArr2[i3 + 1];
                                f5 = fArr2[i3 + 2];
                                f2 = fArr2[i3 + 3];
                                f = f5;
                                f6 = f7;
                                f5 = f8;
                                break;
                            case cn.CTRL_INDEX /*83*/:
                                if (c == 'c' || c == 's' || c == 'C' || c == 'S') {
                                    f6 = (2.0f * f9) - f4;
                                    f4 = (2.0f * f10) - f3;
                                } else {
                                    f6 = f9;
                                    f4 = f10;
                                }
                                path.cubicTo(f4, f6, fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3]);
                                f3 = fArr2[i3 + 0];
                                f4 = fArr2[i3 + 1];
                                f5 = fArr2[i3 + 2];
                                f2 = fArr2[i3 + 3];
                                f = f5;
                                f6 = f7;
                                f5 = f8;
                                break;
                            case 'T':
                                if (c == 'q' || c == 't' || c == 'Q' || c == 'T') {
                                    f10 = (2.0f * f10) - f3;
                                    f9 = (2.0f * f9) - f4;
                                }
                                path.quadTo(f10, f9, fArr2[i3 + 0], fArr2[i3 + 1]);
                                f5 = fArr2[i3 + 0];
                                f4 = f9;
                                f3 = f10;
                                f2 = fArr2[i3 + 1];
                                f = f5;
                                f6 = f7;
                                f5 = f8;
                                break;
                            case 'V':
                                path.lineTo(f10, fArr2[i3 + 0]);
                                f5 = f8;
                                f2 = fArr2[i3 + 0];
                                f = f10;
                                f6 = f7;
                                break;
                            case PlayerException.EXCEPTION_IN_RELEASE /*97*/:
                                android.support.b.a.c.b.a(path, f10, f9, fArr2[i3 + 5] + f10, fArr2[i3 + 6] + f9, fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3] != 0.0f, fArr2[i3 + 4] != 0.0f);
                                f3 = f10 + fArr2[i3 + 5];
                                f4 = f9 + fArr2[i3 + 6];
                                f6 = f7;
                                f5 = f8;
                                f2 = f4;
                                f = f3;
                                break;
                            case 'c':
                                path.rCubicTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3], fArr2[i3 + 4], fArr2[i3 + 5]);
                                f3 = f10 + fArr2[i3 + 2];
                                f4 = f9 + fArr2[i3 + 3];
                                f2 = f9 + fArr2[i3 + 5];
                                f = f10 + fArr2[i3 + 4];
                                f6 = f7;
                                f5 = f8;
                                break;
                            case 'h':
                                path.rLineTo(fArr2[i3 + 0], 0.0f);
                                f6 = f7;
                                f2 = f9;
                                f = f10 + fArr2[i3 + 0];
                                f5 = f8;
                                break;
                            case 'l':
                                path.rLineTo(fArr2[i3 + 0], fArr2[i3 + 1]);
                                f2 = f9 + fArr2[i3 + 1];
                                f = f10 + fArr2[i3 + 0];
                                f6 = f7;
                                f5 = f8;
                                break;
                            case MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM /*109*/:
                                f5 = f10 + fArr2[i3 + 0];
                                f6 = f9 + fArr2[i3 + 1];
                                if (i3 <= 0) {
                                    path.rMoveTo(fArr2[i3 + 0], fArr2[i3 + 1]);
                                    f2 = f6;
                                    f = f5;
                                    break;
                                }
                                path.rLineTo(fArr2[i3 + 0], fArr2[i3 + 1]);
                                f2 = f6;
                                f = f5;
                                f6 = f7;
                                f5 = f8;
                                break;
                            case 'q':
                                path.rQuadTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3]);
                                f3 = f10 + fArr2[i3 + 0];
                                f4 = f9 + fArr2[i3 + 1];
                                f2 = f9 + fArr2[i3 + 3];
                                f = f10 + fArr2[i3 + 2];
                                f6 = f7;
                                f5 = f8;
                                break;
                            case 's':
                                f6 = 0.0f;
                                if (c == 'c' || c == 's' || c == 'C' || c == 'S') {
                                    f6 = f9 - f4;
                                    f4 = f10 - f3;
                                } else {
                                    f4 = 0.0f;
                                }
                                path.rCubicTo(f4, f6, fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3]);
                                f3 = f10 + fArr2[i3 + 0];
                                f4 = f9 + fArr2[i3 + 1];
                                f2 = f9 + fArr2[i3 + 3];
                                f = f10 + fArr2[i3 + 2];
                                f6 = f7;
                                f5 = f8;
                                break;
                            case 't':
                                float f11;
                                if (c == 'q' || c == 't' || c == 'Q' || c == 'T') {
                                    f11 = f9 - f4;
                                    f4 = f10 - f3;
                                } else {
                                    f11 = 0.0f;
                                    f4 = 0.0f;
                                }
                                path.rQuadTo(f4, f11, fArr2[i3 + 0], fArr2[i3 + 1]);
                                f3 = f10 + f4;
                                f4 = f9 + f11;
                                f2 = f9 + fArr2[i3 + 1];
                                f = f10 + fArr2[i3 + 0];
                                f6 = f7;
                                f5 = f8;
                                break;
                            case 'v':
                                path.rLineTo(0.0f, fArr2[i3 + 0]);
                                f5 = f8;
                                f2 = f9 + fArr2[i3 + 0];
                                f = f10;
                                f6 = f7;
                                break;
                            default:
                                f6 = f7;
                                f5 = f8;
                                f2 = f9;
                                f = f10;
                                break;
                        }
                        i3 += i2;
                        f7 = f6;
                        f8 = f5;
                        f9 = f2;
                        f10 = f;
                        c = c2;
                    }
                    fArr[0] = f10;
                    fArr[1] = f9;
                    fArr[2] = f3;
                    fArr[3] = f4;
                    fArr[4] = f8;
                    fArr[5] = f7;
                    char c3 = bVarArr[i].mh;
                    i++;
                    c = c3;
                }
            }
        }

        public boolean aA() {
            return false;
        }
    }

    private static class e {
        private static final Matrix mW = new Matrix();
        private final Path mU;
        private final Path mV;
        private final Matrix mX;
        public Paint mY;
        public Paint mZ;
        private int ma;
        private PathMeasure na;
        public final c nb;
        float nc;
        float nd;
        float ne;
        float nf;
        int ng;
        String nh;
        final android.support.v4.e.a<String, Object> ni;

        public e() {
            this.mX = new Matrix();
            this.nc = 0.0f;
            this.nd = 0.0f;
            this.ne = 0.0f;
            this.nf = 0.0f;
            this.ng = 255;
            this.nh = null;
            this.ni = new android.support.v4.e.a();
            this.nb = new c();
            this.mU = new Path();
            this.mV = new Path();
        }

        public e(e eVar) {
            this.mX = new Matrix();
            this.nc = 0.0f;
            this.nd = 0.0f;
            this.ne = 0.0f;
            this.nf = 0.0f;
            this.ng = 255;
            this.nh = null;
            this.ni = new android.support.v4.e.a();
            this.nb = new c(eVar.nb, this.ni);
            this.mU = new Path(eVar.mU);
            this.mV = new Path(eVar.mV);
            this.nc = eVar.nc;
            this.nd = eVar.nd;
            this.ne = eVar.ne;
            this.nf = eVar.nf;
            this.ma = eVar.ma;
            this.ng = eVar.ng;
            this.nh = eVar.nh;
            if (eVar.nh != null) {
                this.ni.put(eVar.nh, this);
            }
        }

        private void a(c cVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            cVar.mH.set(matrix);
            cVar.mH.preConcat(cVar.mQ);
            for (int i3 = 0; i3 < cVar.mI.size(); i3++) {
                Object obj = cVar.mI.get(i3);
                if (obj instanceof c) {
                    a((c) obj, cVar.mH, canvas, i, i2, colorFilter);
                } else if (obj instanceof d) {
                    d dVar = (d) obj;
                    float f = ((float) i) / this.ne;
                    float f2 = ((float) i2) / this.nf;
                    float min = Math.min(f, f2);
                    Matrix matrix2 = cVar.mH;
                    this.mX.set(matrix2);
                    this.mX.postScale(f, f2);
                    float[] fArr = new float[]{0.0f, 1.0f, 1.0f, 0.0f};
                    matrix2.mapVectors(fArr);
                    f2 = (float) Math.hypot((double) fArr[0], (double) fArr[1]);
                    float hypot = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
                    float f3 = (fArr[3] * fArr[0]) - (fArr[1] * fArr[2]);
                    f2 = Math.max(f2, hypot);
                    f = 0.0f;
                    if (f2 > 0.0f) {
                        f = Math.abs(f3) / f2;
                    }
                    if (f != 0.0f) {
                        dVar.a(this.mU);
                        Path path = this.mU;
                        this.mV.reset();
                        if (dVar.aA()) {
                            this.mV.addPath(path, this.mX);
                            canvas.clipPath(this.mV, Op.REPLACE);
                        } else {
                            Paint paint;
                            b bVar = (b) dVar;
                            if (!(bVar.mB == 0.0f && bVar.mC == 1.0f)) {
                                hypot = (bVar.mB + bVar.mD) % 1.0f;
                                f3 = (bVar.mC + bVar.mD) % 1.0f;
                                if (this.na == null) {
                                    this.na = new PathMeasure();
                                }
                                this.na.setPath(this.mU, false);
                                float length = this.na.getLength();
                                hypot *= length;
                                f3 *= length;
                                path.reset();
                                if (hypot > f3) {
                                    this.na.getSegment(hypot, length, path, true);
                                    this.na.getSegment(0.0f, f3, path, true);
                                } else {
                                    this.na.getSegment(hypot, f3, path, true);
                                }
                                path.rLineTo(0.0f, 0.0f);
                            }
                            this.mV.addPath(path, this.mX);
                            if (bVar.mx != 0) {
                                if (this.mZ == null) {
                                    this.mZ = new Paint();
                                    this.mZ.setStyle(Style.FILL);
                                    this.mZ.setAntiAlias(true);
                                }
                                paint = this.mZ;
                                paint.setColor(((((int) (((float) Color.alpha(bVar.mx)) * bVar.mA)) << 24) | (16777215 & bVar.mx)));
                                paint.setColorFilter(colorFilter);
                                canvas.drawPath(this.mV, paint);
                            }
                            if (bVar.mv != 0) {
                                if (this.mY == null) {
                                    this.mY = new Paint();
                                    this.mY.setStyle(Style.STROKE);
                                    this.mY.setAntiAlias(true);
                                }
                                paint = this.mY;
                                if (bVar.mF != null) {
                                    paint.setStrokeJoin(bVar.mF);
                                }
                                if (bVar.mE != null) {
                                    paint.setStrokeCap(bVar.mE);
                                }
                                paint.setStrokeMiter(bVar.mG);
                                paint.setColor(((((int) (((float) Color.alpha(bVar.mv)) * bVar.my)) << 24) | (16777215 & bVar.mv)));
                                paint.setColorFilter(colorFilter);
                                paint.setStrokeWidth((f * min) * bVar.mw);
                                canvas.drawPath(this.mV, paint);
                            }
                        }
                    }
                }
            }
        }

        public final void a(Canvas canvas, int i, int i2) {
            a(this.nb, mW, canvas, i, i2, null);
        }
    }

    private static class f extends ConstantState {
        int ma;
        e nj;
        ColorStateList nk;
        Mode nl;
        boolean nm;
        Bitmap nn;
        ColorStateList no;
        Mode np;
        int nq;
        boolean nr;
        boolean ns;
        Paint nt;

        public f(f fVar) {
            this.nk = null;
            this.nl = f.mk;
            if (fVar != null) {
                this.ma = fVar.ma;
                this.nj = new e(fVar.nj);
                if (fVar.nj.mZ != null) {
                    this.nj.mZ = new Paint(fVar.nj.mZ);
                }
                if (fVar.nj.mY != null) {
                    this.nj.mY = new Paint(fVar.nj.mY);
                }
                this.nk = fVar.nk;
                this.nl = fVar.nl;
                this.nm = fVar.nm;
            }
        }

        public final void f(int i, int i2) {
            this.nn.eraseColor(0);
            this.nj.a(new Canvas(this.nn), i, i2);
        }

        public f() {
            this.nk = null;
            this.nl = f.mk;
            this.nj = new e();
        }

        public final Drawable newDrawable() {
            return new f();
        }

        public final Drawable newDrawable(Resources resources) {
            return new f();
        }

        public final int getChangingConfigurations() {
            return this.ma;
        }
    }

    private static class g extends ConstantState {
        private final ConstantState me;

        public g(ConstantState constantState) {
            this.me = constantState;
        }

        public final Drawable newDrawable() {
            Drawable fVar = new f();
            fVar.mj = (VectorDrawable) this.me.newDrawable();
            return fVar;
        }

        public final Drawable newDrawable(Resources resources) {
            Drawable fVar = new f();
            fVar.mj = (VectorDrawable) this.me.newDrawable(resources);
            return fVar;
        }

        public final Drawable newDrawable(Resources resources, Theme theme) {
            Drawable fVar = new f();
            fVar.mj = (VectorDrawable) this.me.newDrawable(resources, theme);
            return fVar;
        }

        public final boolean canApplyTheme() {
            return this.me.canApplyTheme();
        }

        public final int getChangingConfigurations() {
            return this.me.getChangingConfigurations();
        }
    }

    private static class a extends d {
        public a(a aVar) {
            super(aVar);
        }

        final void a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.mT = string;
            }
            string = typedArray.getString(1);
            if (string != null) {
                this.mS = c.g(string);
            }
        }

        public final boolean aA() {
            return true;
        }
    }

    private static class b extends d {
        float mA = 1.0f;
        float mB = 0.0f;
        float mC = 1.0f;
        float mD = 0.0f;
        Cap mE = Cap.BUTT;
        Join mF = Join.MITER;
        float mG = 4.0f;
        private int[] mu;
        int mv = 0;
        float mw = 0.0f;
        int mx = 0;
        float my = 1.0f;
        int mz;

        public b(b bVar) {
            super(bVar);
            this.mu = bVar.mu;
            this.mv = bVar.mv;
            this.mw = bVar.mw;
            this.my = bVar.my;
            this.mx = bVar.mx;
            this.mz = bVar.mz;
            this.mA = bVar.mA;
            this.mB = bVar.mB;
            this.mC = bVar.mC;
            this.mD = bVar.mD;
            this.mE = bVar.mE;
            this.mF = bVar.mF;
            this.mG = bVar.mG;
        }

        final void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.mu = null;
            if (d.a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.mT = string;
                }
                string = typedArray.getString(2);
                if (string != null) {
                    this.mS = c.g(string);
                }
                this.mx = d.a(typedArray, xmlPullParser, "fillColor", 1, this.mx);
                this.mA = d.a(typedArray, xmlPullParser, "fillAlpha", 12, this.mA);
                int a = d.a(typedArray, xmlPullParser, "strokeLineCap", 8);
                Cap cap = this.mE;
                switch (a) {
                    case 0:
                        cap = Cap.BUTT;
                        break;
                    case 1:
                        cap = Cap.ROUND;
                        break;
                    case 2:
                        cap = Cap.SQUARE;
                        break;
                }
                this.mE = cap;
                a = d.a(typedArray, xmlPullParser, "strokeLineJoin", 9);
                Join join = this.mF;
                switch (a) {
                    case 0:
                        join = Join.MITER;
                        break;
                    case 1:
                        join = Join.ROUND;
                        break;
                    case 2:
                        join = Join.BEVEL;
                        break;
                }
                this.mF = join;
                this.mG = d.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.mG);
                this.mv = d.a(typedArray, xmlPullParser, "strokeColor", 3, this.mv);
                this.my = d.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.my);
                this.mw = d.a(typedArray, xmlPullParser, "strokeWidth", 4, this.mw);
                this.mC = d.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.mC);
                this.mD = d.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.mD);
                this.mB = d.a(typedArray, xmlPullParser, "trimPathStart", 5, this.mB);
            }
        }
    }

    public final /* bridge */ /* synthetic */ void applyTheme(Theme theme) {
        super.applyTheme(theme);
    }

    public final /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public final /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public final /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public final /* bridge */ /* synthetic */ int getLayoutDirection() {
        return super.getLayoutDirection();
    }

    public final /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public final /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public final /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public final /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public final /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public final /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public final /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public final /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public final /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public final /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public final /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public final /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public final /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public final /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    private f() {
        this.mp = true;
        this.mr = new float[9];
        this.ms = new Matrix();
        this.mt = new Rect();
        this.ml = new f();
    }

    private f(f fVar) {
        this.mp = true;
        this.mr = new float[9];
        this.ms = new Matrix();
        this.mt = new Rect();
        this.ml = fVar;
        this.mm = a(fVar.nk, fVar.nl);
    }

    public final Drawable mutate() {
        if (this.mj != null) {
            this.mj.mutate();
        } else if (!this.mo && super.mutate() == this) {
            this.ml = new f(this.ml);
            this.mo = true;
        }
        return this;
    }

    public final ConstantState getConstantState() {
        if (this.mj != null) {
            return new g(this.mj.getConstantState());
        }
        this.ml.ma = getChangingConfigurations();
        return this.ml;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void draw(android.graphics.Canvas r12) {
        /*
        r11 = this;
        r10 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r9 = 0;
        r4 = 1;
        r5 = 0;
        r0 = r11.mj;
        if (r0 == 0) goto L_0x0011;
    L_0x000b:
        r0 = r11.mj;
        r0.draw(r12);
    L_0x0010:
        return;
    L_0x0011:
        r0 = r11.mt;
        r11.copyBounds(r0);
        r0 = r11.mt;
        r0 = r0.width();
        if (r0 <= 0) goto L_0x0010;
    L_0x001e:
        r0 = r11.mt;
        r0 = r0.height();
        if (r0 <= 0) goto L_0x0010;
    L_0x0026:
        r0 = r11.mn;
        if (r0 != 0) goto L_0x00e0;
    L_0x002a:
        r0 = r11.mm;
    L_0x002c:
        r1 = r11.ms;
        r12.getMatrix(r1);
        r1 = r11.ms;
        r3 = r11.mr;
        r1.getValues(r3);
        r1 = r11.mr;
        r1 = r1[r5];
        r3 = java.lang.Math.abs(r1);
        r1 = r11.mr;
        r6 = 4;
        r1 = r1[r6];
        r1 = java.lang.Math.abs(r1);
        r6 = r11.mr;
        r6 = r6[r4];
        r6 = java.lang.Math.abs(r6);
        r7 = r11.mr;
        r8 = 3;
        r7 = r7[r8];
        r7 = java.lang.Math.abs(r7);
        r6 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1));
        if (r6 != 0) goto L_0x0062;
    L_0x005e:
        r6 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));
        if (r6 == 0) goto L_0x014a;
    L_0x0062:
        r1 = r2;
    L_0x0063:
        r3 = r11.mt;
        r3 = r3.width();
        r3 = (float) r3;
        r2 = r2 * r3;
        r2 = (int) r2;
        r3 = r11.mt;
        r3 = r3.height();
        r3 = (float) r3;
        r1 = r1 * r3;
        r1 = (int) r1;
        r2 = java.lang.Math.min(r10, r2);
        r3 = java.lang.Math.min(r10, r1);
        if (r2 <= 0) goto L_0x0010;
    L_0x007f:
        if (r3 <= 0) goto L_0x0010;
    L_0x0081:
        r6 = r12.save();
        r1 = r11.mt;
        r1 = r1.left;
        r1 = (float) r1;
        r7 = r11.mt;
        r7 = r7.top;
        r7 = (float) r7;
        r12.translate(r1, r7);
        r1 = r11.mt;
        r1.offsetTo(r5, r5);
        r7 = r11.ml;
        r1 = r7.nn;
        if (r1 == 0) goto L_0x00b0;
    L_0x009d:
        r1 = r7.nn;
        r1 = r1.getWidth();
        if (r2 != r1) goto L_0x00e4;
    L_0x00a5:
        r1 = r7.nn;
        r1 = r1.getHeight();
        if (r3 != r1) goto L_0x00e4;
    L_0x00ad:
        r1 = r4;
    L_0x00ae:
        if (r1 != 0) goto L_0x00ba;
    L_0x00b0:
        r1 = android.graphics.Bitmap.Config.ARGB_8888;
        r1 = android.graphics.Bitmap.createBitmap(r2, r3, r1);
        r7.nn = r1;
        r7.ns = r4;
    L_0x00ba:
        r1 = r11.mp;
        if (r1 != 0) goto L_0x00e6;
    L_0x00be:
        r1 = r11.ml;
        r1.f(r2, r3);
    L_0x00c3:
        r2 = r11.ml;
        r3 = r11.mt;
        r1 = r2.nj;
        r1 = r1.ng;
        r7 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        if (r1 >= r7) goto L_0x0127;
    L_0x00cf:
        r1 = r4;
    L_0x00d0:
        if (r1 != 0) goto L_0x0129;
    L_0x00d2:
        if (r0 != 0) goto L_0x0129;
    L_0x00d4:
        r0 = 0;
    L_0x00d5:
        r1 = r2.nn;
        r2 = 0;
        r12.drawBitmap(r1, r2, r3, r0);
        r12.restoreToCount(r6);
        goto L_0x0010;
    L_0x00e0:
        r0 = r11.mn;
        goto L_0x002c;
    L_0x00e4:
        r1 = r5;
        goto L_0x00ae;
    L_0x00e6:
        r1 = r11.ml;
        r7 = r1.ns;
        if (r7 != 0) goto L_0x0125;
    L_0x00ec:
        r7 = r1.no;
        r8 = r1.nk;
        if (r7 != r8) goto L_0x0125;
    L_0x00f2:
        r7 = r1.np;
        r8 = r1.nl;
        if (r7 != r8) goto L_0x0125;
    L_0x00f8:
        r7 = r1.nr;
        r8 = r1.nm;
        if (r7 != r8) goto L_0x0125;
    L_0x00fe:
        r7 = r1.nq;
        r1 = r1.nj;
        r1 = r1.ng;
        if (r7 != r1) goto L_0x0125;
    L_0x0106:
        r1 = r4;
    L_0x0107:
        if (r1 != 0) goto L_0x00c3;
    L_0x0109:
        r1 = r11.ml;
        r1.f(r2, r3);
        r1 = r11.ml;
        r2 = r1.nk;
        r1.no = r2;
        r2 = r1.nl;
        r1.np = r2;
        r2 = r1.nj;
        r2 = r2.ng;
        r1.nq = r2;
        r2 = r1.nm;
        r1.nr = r2;
        r1.ns = r5;
        goto L_0x00c3;
    L_0x0125:
        r1 = r5;
        goto L_0x0107;
    L_0x0127:
        r1 = r5;
        goto L_0x00d0;
    L_0x0129:
        r1 = r2.nt;
        if (r1 != 0) goto L_0x0139;
    L_0x012d:
        r1 = new android.graphics.Paint;
        r1.<init>();
        r2.nt = r1;
        r1 = r2.nt;
        r1.setFilterBitmap(r4);
    L_0x0139:
        r1 = r2.nt;
        r4 = r2.nj;
        r4 = r4.ng;
        r1.setAlpha(r4);
        r1 = r2.nt;
        r1.setColorFilter(r0);
        r0 = r2.nt;
        goto L_0x00d5;
    L_0x014a:
        r2 = r3;
        goto L_0x0063;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.b.a.f.draw(android.graphics.Canvas):void");
    }

    public final int getAlpha() {
        if (this.mj != null) {
            return android.support.v4.b.a.a.d(this.mj);
        }
        return this.ml.nj.ng;
    }

    public final void setAlpha(int i) {
        if (this.mj != null) {
            this.mj.setAlpha(i);
        } else if (this.ml.nj.ng != i) {
            this.ml.nj.ng = i;
            invalidateSelf();
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.mj != null) {
            this.mj.setColorFilter(colorFilter);
            return;
        }
        this.mn = colorFilter;
        invalidateSelf();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public final void setTint(int i) {
        if (this.mj != null) {
            android.support.v4.b.a.a.a(this.mj, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public final void setTintList(ColorStateList colorStateList) {
        if (this.mj != null) {
            android.support.v4.b.a.a.a(this.mj, colorStateList);
            return;
        }
        f fVar = this.ml;
        if (fVar.nk != colorStateList) {
            fVar.nk = colorStateList;
            this.mm = a(colorStateList, fVar.nl);
            invalidateSelf();
        }
    }

    public final void setTintMode(Mode mode) {
        if (this.mj != null) {
            android.support.v4.b.a.a.a(this.mj, mode);
            return;
        }
        f fVar = this.ml;
        if (fVar.nl != mode) {
            fVar.nl = mode;
            this.mm = a(fVar.nk, mode);
            invalidateSelf();
        }
    }

    public final boolean isStateful() {
        if (this.mj != null) {
            return this.mj.isStateful();
        }
        return super.isStateful() || !(this.ml == null || this.ml.nk == null || !this.ml.nk.isStateful());
    }

    protected final boolean onStateChange(int[] iArr) {
        if (this.mj != null) {
            return this.mj.setState(iArr);
        }
        f fVar = this.ml;
        if (fVar.nk == null || fVar.nl == null) {
            return false;
        }
        this.mm = a(fVar.nk, fVar.nl);
        invalidateSelf();
        return true;
    }

    public final int getOpacity() {
        if (this.mj != null) {
            return this.mj.getOpacity();
        }
        return -3;
    }

    public final int getIntrinsicWidth() {
        if (this.mj != null) {
            return this.mj.getIntrinsicWidth();
        }
        return (int) this.ml.nj.nc;
    }

    public final int getIntrinsicHeight() {
        if (this.mj != null) {
            return this.mj.getIntrinsicHeight();
        }
        return (int) this.ml.nj.nd;
    }

    public final boolean canApplyTheme() {
        if (this.mj != null) {
            android.support.v4.b.a.a.e(this.mj);
        }
        return false;
    }

    public static f a(Resources resources, int i, Theme theme) {
        if (VERSION.SDK_INT >= 23) {
            f fVar = new f();
            fVar.mj = VERSION.SDK_INT >= 21 ? resources.getDrawable(i, theme) : resources.getDrawable(i);
            fVar.mq = new g(fVar.mj.getConstantState());
            return fVar;
        }
        try {
            int next;
            XmlPullParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return a(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (XmlPullParserException e) {
            return null;
        } catch (IOException e2) {
            return null;
        }
    }

    public static f a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        f fVar = new f();
        fVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return fVar;
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        if (this.mj != null) {
            this.mj.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.mj != null) {
            android.support.v4.b.a.a.a(this.mj, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        f fVar = this.ml;
        fVar.nj = new e();
        TypedArray a = e.a(resources, theme, attributeSet, a.lQ);
        f fVar2 = this.ml;
        e eVar = fVar2.nj;
        int a2 = d.a(a, xmlPullParser, "tintMode", 6);
        Mode mode = Mode.SRC_IN;
        switch (a2) {
            case 3:
                mode = Mode.SRC_OVER;
                break;
            case 5:
                mode = Mode.SRC_IN;
                break;
            case 9:
                mode = Mode.SRC_ATOP;
                break;
            case 14:
                mode = Mode.MULTIPLY;
                break;
            case 15:
                mode = Mode.SCREEN;
                break;
            case 16:
                mode = Mode.ADD;
                break;
        }
        fVar2.nl = mode;
        ColorStateList colorStateList = a.getColorStateList(1);
        if (colorStateList != null) {
            fVar2.nk = colorStateList;
        }
        boolean z = fVar2.nm;
        if (d.a(xmlPullParser, "autoMirrored")) {
            z = a.getBoolean(5, z);
        }
        fVar2.nm = z;
        eVar.ne = d.a(a, xmlPullParser, "viewportWidth", 7, eVar.ne);
        eVar.nf = d.a(a, xmlPullParser, "viewportHeight", 8, eVar.nf);
        if (eVar.ne <= 0.0f) {
            throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (eVar.nf <= 0.0f) {
            throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            eVar.nc = a.getDimension(3, eVar.nc);
            eVar.nd = a.getDimension(2, eVar.nd);
            if (eVar.nc <= 0.0f) {
                throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (eVar.nd <= 0.0f) {
                throw new XmlPullParserException(a.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                eVar.ng = (int) (d.a(a, xmlPullParser, "alpha", 4, ((float) eVar.ng) / 255.0f) * 255.0f);
                String string = a.getString(0);
                if (string != null) {
                    eVar.nh = string;
                    eVar.ni.put(string, eVar);
                }
                a.recycle();
                fVar.ma = getChangingConfigurations();
                fVar.ns = true;
                b(resources, xmlPullParser, attributeSet, theme);
                this.mm = a(fVar.nk, fVar.nl);
            }
        }
    }

    private void b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        f fVar = this.ml;
        e eVar = fVar.nj;
        Object obj = 1;
        Stack stack = new Stack();
        stack.push(eVar.nb);
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            Object obj2;
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                c cVar = (c) stack.peek();
                if ("path".equals(name)) {
                    d bVar = new b();
                    TypedArray a = e.a(resources, theme, attributeSet, a.lS);
                    bVar.a(a, xmlPullParser);
                    a.recycle();
                    cVar.mI.add(bVar);
                    if (bVar.mT != null) {
                        eVar.ni.put(bVar.mT, bVar);
                    }
                    obj2 = null;
                    fVar.ma = bVar.ma | fVar.ma;
                } else if ("clip-path".equals(name)) {
                    d aVar = new a();
                    if (d.a(xmlPullParser, "pathData")) {
                        r8 = e.a(resources, theme, attributeSet, a.lT);
                        aVar.a(r8);
                        r8.recycle();
                    }
                    cVar.mI.add(aVar);
                    if (aVar.mT != null) {
                        eVar.ni.put(aVar.mT, aVar);
                    }
                    fVar.ma |= aVar.ma;
                    obj2 = obj;
                } else {
                    if ("group".equals(name)) {
                        c cVar2 = new c();
                        r8 = e.a(resources, theme, attributeSet, a.lR);
                        cVar2.mu = null;
                        cVar2.mJ = d.a(r8, xmlPullParser, "rotation", 5, cVar2.mJ);
                        cVar2.mK = r8.getFloat(1, cVar2.mK);
                        cVar2.mL = r8.getFloat(2, cVar2.mL);
                        cVar2.mM = d.a(r8, xmlPullParser, "scaleX", 3, cVar2.mM);
                        cVar2.mN = d.a(r8, xmlPullParser, "scaleY", 4, cVar2.mN);
                        cVar2.mO = d.a(r8, xmlPullParser, "translateX", 6, cVar2.mO);
                        cVar2.mP = d.a(r8, xmlPullParser, "translateY", 7, cVar2.mP);
                        String string = r8.getString(0);
                        if (string != null) {
                            cVar2.mR = string;
                        }
                        cVar2.mQ.reset();
                        cVar2.mQ.postTranslate(-cVar2.mK, -cVar2.mL);
                        cVar2.mQ.postScale(cVar2.mM, cVar2.mN);
                        cVar2.mQ.postRotate(cVar2.mJ, 0.0f, 0.0f);
                        cVar2.mQ.postTranslate(cVar2.mO + cVar2.mK, cVar2.mP + cVar2.mL);
                        r8.recycle();
                        cVar.mI.add(cVar2);
                        stack.push(cVar2);
                        if (cVar2.mR != null) {
                            eVar.ni.put(cVar2.mR, cVar2);
                        }
                        fVar.ma |= cVar2.ma;
                    }
                    obj2 = obj;
                }
            } else {
                if (eventType == 3) {
                    if ("group".equals(xmlPullParser.getName())) {
                        stack.pop();
                    }
                }
                obj2 = obj;
            }
            obj = obj2;
            eventType = xmlPullParser.next();
        }
        if (obj != null) {
            StringBuffer stringBuffer = new StringBuffer();
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" or ");
            }
            stringBuffer.append("path");
            throw new XmlPullParserException("no " + stringBuffer + " defined");
        }
    }

    protected final void onBoundsChange(Rect rect) {
        if (this.mj != null) {
            this.mj.setBounds(rect);
        }
    }

    public final int getChangingConfigurations() {
        if (this.mj != null) {
            return this.mj.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.ml.getChangingConfigurations();
    }

    public final void invalidateSelf() {
        if (this.mj != null) {
            this.mj.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public final void scheduleSelf(Runnable runnable, long j) {
        if (this.mj != null) {
            this.mj.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public final boolean setVisible(boolean z, boolean z2) {
        if (this.mj != null) {
            return this.mj.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public final void unscheduleSelf(Runnable runnable) {
        if (this.mj != null) {
            this.mj.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
