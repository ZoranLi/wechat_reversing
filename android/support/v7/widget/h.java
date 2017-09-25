package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.v4.e.f;
import android.support.v7.a.a.e;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class h {
    private static h UA;
    private static final b UB = new b();
    private static final int[] UC = new int[]{e.JJ, e.JH, e.IW};
    private static final int[] UD = new int[]{e.Jg, e.Jj, e.Jq, e.Ji, e.Jh, e.Jp, e.Jk, e.Jl, e.Jo, e.Jn, e.Jm, e.Jr};
    private static final int[] UE = new int[]{e.JG, e.JI, e.Je, e.JF};
    private static final int[] UF = new int[]{e.Ju, e.Jc, e.Jt};
    private static final int[] UG = new int[]{e.Jf, e.JE, e.JK, e.JA, e.JB, e.Jv, e.JD, e.JC, e.Ja, e.IX};
    private static final int[] UH = new int[]{e.IY, e.Jb};
    private static final Mode Uz = Mode.SRC_IN;
    private WeakHashMap<Context, SparseArray<ColorStateList>> UI;
    private android.support.v4.e.a<String, c> UJ;
    private SparseArray<String> UK;
    private final Object UL = new Object();
    private final WeakHashMap<Context, android.support.v4.e.e<WeakReference<ConstantState>>> UM = new WeakHashMap(0);
    private TypedValue UN;

    private interface c {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);
    }

    private static class a implements c {
        public final Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return android.support.b.a.b.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                return null;
            }
        }
    }

    private static class b extends f<Integer, PorterDuffColorFilter> {
        public b() {
            super(6);
        }

        static int b(int i, Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }
    }

    private static class d implements c {
        public final Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return android.support.b.a.f.a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                return null;
            }
        }
    }

    public static h ey() {
        if (UA == null) {
            h hVar = new h();
            UA = hVar;
            int i = VERSION.SDK_INT;
            if (i < 23) {
                hVar.a("vector", new d());
                if (i >= 11) {
                    hVar.a("animated-vector", new a());
                }
            }
        }
        return UA;
    }

    public final Drawable a(Context context, int i, boolean z) {
        Drawable d = d(context, i);
        if (d == null) {
            if (this.UN == null) {
                this.UN = new TypedValue();
            }
            TypedValue typedValue = this.UN;
            context.getResources().getValue(i, typedValue, true);
            long a = a(typedValue);
            d = a(context, a);
            if (d == null) {
                if (i == e.Jd) {
                    d = new LayerDrawable(new Drawable[]{a(context, e.Jc, false), a(context, e.Je, false)});
                }
                if (d != null) {
                    d.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, a, d);
                }
            }
        }
        if (d == null) {
            d = android.support.v4.content.a.a(context, i);
        }
        if (d != null) {
            d = a(context, i, z, d);
        }
        if (d != null) {
            w.n(d);
        }
        return d;
    }

    private static long a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    final Drawable a(Context context, int i, boolean z, Drawable drawable) {
        Mode mode = null;
        ColorStateList e = e(context, i);
        if (e != null) {
            if (w.o(drawable)) {
                drawable = drawable.mutate();
            }
            drawable = android.support.v4.b.a.a.g(drawable);
            android.support.v4.b.a.a.a(drawable, e);
            if (i == e.JC) {
                mode = Mode.MULTIPLY;
            }
            if (mode == null) {
                return drawable;
            }
            android.support.v4.b.a.a.a(drawable, mode);
            return drawable;
        } else if (i == e.Jz) {
            r0 = (LayerDrawable) drawable;
            a(r0.findDrawableByLayerId(16908288), al.h(context, android.support.v7.a.a.a.colorControlNormal), Uz);
            a(r0.findDrawableByLayerId(16908303), al.h(context, android.support.v7.a.a.a.colorControlNormal), Uz);
            a(r0.findDrawableByLayerId(16908301), al.h(context, android.support.v7.a.a.a.colorControlActivated), Uz);
            return drawable;
        } else if (i == e.Jw || i == e.Jx) {
            r0 = (LayerDrawable) drawable;
            a(r0.findDrawableByLayerId(16908288), al.j(context, android.support.v7.a.a.a.colorControlNormal), Uz);
            a(r0.findDrawableByLayerId(16908303), al.h(context, android.support.v7.a.a.a.colorControlActivated), Uz);
            a(r0.findDrawableByLayerId(16908301), al.h(context, android.support.v7.a.a.a.colorControlActivated), Uz);
            return drawable;
        } else if (a(context, i, drawable) || !z) {
            return drawable;
        } else {
            return null;
        }
    }

    final Drawable d(Context context, int i) {
        if (this.UJ == null || this.UJ.isEmpty()) {
            return null;
        }
        String str;
        if (this.UK != null) {
            str = (String) this.UK.get(i);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.UJ.get(str) == null)) {
                return null;
            }
        }
        this.UK = new SparseArray();
        if (this.UN == null) {
            this.UN = new TypedValue();
        }
        TypedValue typedValue = this.UN;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long a = a(typedValue);
        Drawable a2 = a(context, a);
        if (a2 != null) {
            return a2;
        }
        Drawable drawable;
        if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
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
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                str = xml.getName();
                this.UK.append(i, str);
                c cVar = (c) this.UJ.get(str);
                if (cVar != null) {
                    a2 = cVar.a(context, xml, asAttributeSet, context.getTheme());
                }
                if (a2 != null) {
                    a2.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, a, a2);
                }
                drawable = a2;
                if (drawable == null) {
                    return drawable;
                }
                this.UK.append(i, "appcompat_skip_skip");
                return drawable;
            } catch (Exception e) {
            }
        }
        drawable = a2;
        if (drawable == null) {
            return drawable;
        }
        this.UK.append(i, "appcompat_skip_skip");
        return drawable;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable a(android.content.Context r7, long r8) {
        /*
        r6 = this;
        r2 = 0;
        r3 = r6.UL;
        monitor-enter(r3);
        r0 = r6.UM;	 Catch:{ all -> 0x002b }
        r0 = r0.get(r7);	 Catch:{ all -> 0x002b }
        r0 = (android.support.v4.e.e) r0;	 Catch:{ all -> 0x002b }
        if (r0 != 0) goto L_0x0011;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        r0 = r2;
    L_0x0010:
        return r0;
    L_0x0011:
        r1 = r0.get(r8);	 Catch:{ all -> 0x002b }
        r1 = (java.lang.ref.WeakReference) r1;	 Catch:{ all -> 0x002b }
        if (r1 == 0) goto L_0x0049;
    L_0x0019:
        r1 = r1.get();	 Catch:{ all -> 0x002b }
        r1 = (android.graphics.drawable.Drawable.ConstantState) r1;	 Catch:{ all -> 0x002b }
        if (r1 == 0) goto L_0x002e;
    L_0x0021:
        r0 = r7.getResources();	 Catch:{ all -> 0x002b }
        r0 = r1.newDrawable(r0);	 Catch:{ all -> 0x002b }
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        goto L_0x0010;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        throw r0;
    L_0x002e:
        r1 = r0.vV;	 Catch:{ all -> 0x002b }
        r4 = r0.hP;	 Catch:{ all -> 0x002b }
        r1 = android.support.v4.e.b.a(r1, r4, r8);	 Catch:{ all -> 0x002b }
        if (r1 < 0) goto L_0x0049;
    L_0x0038:
        r4 = r0.vW;	 Catch:{ all -> 0x002b }
        r4 = r4[r1];	 Catch:{ all -> 0x002b }
        r5 = android.support.v4.e.e.vT;	 Catch:{ all -> 0x002b }
        if (r4 == r5) goto L_0x0049;
    L_0x0040:
        r4 = r0.vW;	 Catch:{ all -> 0x002b }
        r5 = android.support.v4.e.e.vT;	 Catch:{ all -> 0x002b }
        r4[r1] = r5;	 Catch:{ all -> 0x002b }
        r1 = 1;
        r0.vU = r1;	 Catch:{ all -> 0x002b }
    L_0x0049:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        r0 = r2;
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.h.a(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    private boolean a(Context context, long j, Drawable drawable) {
        ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        synchronized (this.UL) {
            android.support.v4.e.e eVar = (android.support.v4.e.e) this.UM.get(context);
            if (eVar == null) {
                eVar = new android.support.v4.e.e();
                this.UM.put(context, eVar);
            }
            eVar.put(j, new WeakReference(constantState));
        }
        return true;
    }

    static boolean a(Context context, int i, Drawable drawable) {
        int i2;
        Mode mode;
        boolean z;
        int i3;
        Mode mode2 = Uz;
        if (a(UC, i)) {
            i2 = android.support.v7.a.a.a.colorControlNormal;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (a(UE, i)) {
            i2 = android.support.v7.a.a.a.colorControlActivated;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (a(UF, i)) {
            z = true;
            mode = Mode.MULTIPLY;
            i2 = 16842801;
            i3 = -1;
        } else if (i == e.Js) {
            i2 = 16842800;
            i3 = Math.round(40.8f);
            mode = mode2;
            z = true;
        } else {
            i3 = -1;
            i2 = 0;
            mode = mode2;
            z = false;
        }
        if (!z) {
            return false;
        }
        if (w.o(drawable)) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter(a(al.h(context, i2), mode));
        if (i3 == -1) {
            return true;
        }
        drawable.setAlpha(i3);
        return true;
    }

    private void a(String str, c cVar) {
        if (this.UJ == null) {
            this.UJ = new android.support.v4.e.a();
        }
        this.UJ.put(str, cVar);
    }

    private static boolean a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public final ColorStateList e(Context context, int i) {
        ColorStateList colorStateList;
        if (this.UI != null) {
            SparseArray sparseArray = (SparseArray) this.UI.get(context);
            colorStateList = sparseArray != null ? (ColorStateList) sparseArray.get(i) : null;
        } else {
            colorStateList = null;
        }
        if (colorStateList != null) {
            return colorStateList;
        }
        ColorStateList colorStateList2;
        int[][] iArr;
        int[] iArr2;
        if (i == e.Jf) {
            iArr = new int[3][];
            iArr2 = new int[]{al.iK, al.j(context, android.support.v7.a.a.a.colorControlNormal), al.aez};
            iArr2[1] = al.h(context, android.support.v7.a.a.a.colorControlNormal);
            iArr[2] = al.EMPTY_STATE_SET;
            iArr2[2] = al.h(context, android.support.v7.a.a.a.colorControlActivated);
            colorStateList2 = new ColorStateList(iArr, iArr2);
        } else if (i == e.JD) {
            iArr = new int[3][];
            iArr2 = new int[]{al.iK, al.a(context, 16842800, 0.1f), al.dN};
            iArr2[1] = al.a(context, android.support.v7.a.a.a.colorControlActivated, 0.3f);
            iArr[2] = al.EMPTY_STATE_SET;
            iArr2[2] = al.a(context, 16842800, 0.3f);
            colorStateList2 = new ColorStateList(iArr, iArr2);
        } else if (i == e.JC) {
            iArr = new int[3][];
            iArr2 = new int[3];
            colorStateList2 = al.i(context, android.support.v7.a.a.a.IH);
            if (colorStateList2 == null || !colorStateList2.isStateful()) {
                iArr[0] = al.iK;
                iArr2[0] = al.j(context, android.support.v7.a.a.a.IH);
                iArr[1] = al.dN;
                iArr2[1] = al.h(context, android.support.v7.a.a.a.colorControlActivated);
                iArr[2] = al.EMPTY_STATE_SET;
                iArr2[2] = al.h(context, android.support.v7.a.a.a.IH);
            } else {
                iArr[0] = al.iK;
                iArr2[0] = colorStateList2.getColorForState(iArr[0], 0);
                iArr[1] = al.dN;
                iArr2[1] = al.h(context, android.support.v7.a.a.a.colorControlActivated);
                iArr[2] = al.EMPTY_STATE_SET;
                iArr2[2] = colorStateList2.getDefaultColor();
            }
            colorStateList2 = new ColorStateList(iArr, iArr2);
        } else if (i == e.Ja) {
            colorStateList2 = f(context, al.h(context, android.support.v7.a.a.a.colorButtonNormal));
        } else if (i == e.IX) {
            colorStateList2 = f(context, 0);
        } else if (i == e.IZ) {
            colorStateList2 = f(context, al.h(context, android.support.v7.a.a.a.colorAccent));
        } else if (i == e.JA || i == e.JB) {
            iArr = new int[3][];
            iArr2 = new int[]{al.iK, al.j(context, android.support.v7.a.a.a.colorControlNormal), al.aez};
            iArr2[1] = al.h(context, android.support.v7.a.a.a.colorControlNormal);
            iArr[2] = al.EMPTY_STATE_SET;
            iArr2[2] = al.h(context, android.support.v7.a.a.a.colorControlActivated);
            colorStateList2 = new ColorStateList(iArr, iArr2);
        } else if (a(UD, i)) {
            colorStateList2 = al.i(context, android.support.v7.a.a.a.colorControlNormal);
        } else if (a(UG, i)) {
            int h = al.h(context, android.support.v7.a.a.a.colorControlNormal);
            int h2 = al.h(context, android.support.v7.a.a.a.colorControlActivated);
            r2 = new int[7][];
            int[] iArr3 = new int[]{al.iK, al.j(context, android.support.v7.a.a.a.colorControlNormal), al.FOCUSED_STATE_SET, h2, al.aey, h2, al.PRESSED_STATE_SET};
            iArr3[3] = h2;
            r2[4] = al.dN;
            iArr3[4] = h2;
            r2[5] = al.SELECTED_STATE_SET;
            iArr3[5] = h2;
            r2[6] = al.EMPTY_STATE_SET;
            iArr3[6] = h;
            colorStateList2 = new ColorStateList(r2, iArr3);
        } else if (a(UH, i)) {
            iArr = new int[3][];
            iArr2 = new int[]{al.iK, al.j(context, android.support.v7.a.a.a.colorControlNormal), al.dN};
            iArr2[1] = al.h(context, android.support.v7.a.a.a.colorControlActivated);
            iArr[2] = al.EMPTY_STATE_SET;
            iArr2[2] = al.h(context, android.support.v7.a.a.a.colorControlNormal);
            colorStateList2 = new ColorStateList(iArr, iArr2);
        } else if (i == e.Jy) {
            iArr = new int[2][];
            iArr2 = new int[]{al.iK, al.j(context, android.support.v7.a.a.a.colorControlActivated)};
            iArr[1] = al.EMPTY_STATE_SET;
            iArr2[1] = al.h(context, android.support.v7.a.a.a.colorControlActivated);
            colorStateList2 = new ColorStateList(iArr, iArr2);
        } else {
            colorStateList2 = colorStateList;
        }
        if (colorStateList2 != null) {
            if (this.UI == null) {
                this.UI = new WeakHashMap();
            }
            sparseArray = (SparseArray) this.UI.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.UI.put(context, sparseArray);
            }
            sparseArray.append(i, colorStateList2);
        }
        return colorStateList2;
    }

    private static ColorStateList f(Context context, int i) {
        r0 = new int[4][];
        r1 = new int[4];
        int h = al.h(context, android.support.v7.a.a.a.colorControlHighlight);
        r0[0] = al.iK;
        r1[0] = al.j(context, android.support.v7.a.a.a.colorButtonNormal);
        r0[1] = al.PRESSED_STATE_SET;
        r1[1] = android.support.v4.b.b.i(h, i);
        r0[2] = al.FOCUSED_STATE_SET;
        r1[2] = android.support.v4.b.b.i(h, i);
        r0[3] = al.EMPTY_STATE_SET;
        r1[3] = i;
        return new ColorStateList(r0, r1);
    }

    public static void a(Drawable drawable, an anVar, int[] iArr) {
        ColorFilter colorFilter = null;
        if (!w.o(drawable) || drawable.mutate() == drawable) {
            if (anVar.aeE || anVar.aeD) {
                ColorStateList colorStateList = anVar.aeE ? anVar.aeC : null;
                Mode mode = anVar.aeD ? anVar.nl : Uz;
                if (!(colorStateList == null || mode == null)) {
                    colorFilter = a(colorStateList.getColorForState(iArr, 0), mode);
                }
                drawable.setColorFilter(colorFilter);
            } else {
                drawable.clearColorFilter();
            }
            if (VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
            }
        }
    }

    public static PorterDuffColorFilter a(int i, Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter = (PorterDuffColorFilter) UB.get(Integer.valueOf(b.b(i, mode)));
        if (porterDuffColorFilter != null) {
            return porterDuffColorFilter;
        }
        porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
        UB.put(Integer.valueOf(b.b(i, mode)), porterDuffColorFilter);
        return porterDuffColorFilter;
    }

    private static void a(Drawable drawable, int i, Mode mode) {
        if (w.o(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = Uz;
        }
        drawable.setColorFilter(a(i, mode));
    }
}
