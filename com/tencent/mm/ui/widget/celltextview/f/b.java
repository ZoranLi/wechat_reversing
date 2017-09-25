package com.tencent.mm.ui.widget.celltextview.f;

import android.graphics.Paint;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.widget.celltextview.c.a;
import com.tencent.mm.ui.widget.celltextview.c.e;
import java.util.Stack;

public final class b implements a {
    private static float[] wze = new float[26];
    private Paint fu;
    private float wzf;

    public final a a(e eVar, Paint paint, int i, int i2, boolean z) {
        if (!eVar.caX()) {
            return new a(eVar.getLength(), eVar.getWidth());
        }
        int i3;
        char cZ;
        float f;
        this.fu = paint;
        int indexOf = eVar.getText().indexOf(10);
        Object obj = indexOf >= 0 ? 1 : null;
        String text = obj == null ? eVar.getText() : eVar.getText().substring(0, indexOf + 1);
        int length = text.length() - (obj != null ? 1 : 0);
        float f2 = -2.14748365E9f;
        Stack stack = new Stack();
        int i4 = 0;
        while (i4 < length) {
            i3 = 25;
            if (i4 + 25 >= length) {
                i3 = length - i4;
            } else if (Character.isHighSurrogate(text.charAt((i4 + 25) - 1))) {
                i3 = 26;
            }
            int a = eVar.a(i4, i3, wze);
            if (f2 == -2.14748365E9f) {
                if (com.tencent.mm.ui.widget.celltextview.g.a.n(text.charAt(0))) {
                    char charAt = text.charAt(0);
                    b(this.fu);
                    f2 = -com.tencent.mm.ui.widget.celltextview.g.a.b(charAt, this.fu);
                } else {
                    f2 = 0.0f;
                }
            }
            int i5 = 0;
            while (i5 < a) {
                float f3 = wze[i5] + f2;
                stack.push(Float.valueOf(f3));
                f2 = f3 - ((float) i);
                if (f2 > 0.0f) {
                    float a2;
                    int i6;
                    int i7;
                    int i8;
                    i5 += i4;
                    cZ = com.tencent.mm.ui.widget.celltextview.g.a.cZ(text, i5);
                    if (com.tencent.mm.ui.widget.celltextview.g.a.m(cZ)) {
                        b(this.fu);
                        a2 = f2 - com.tencent.mm.ui.widget.celltextview.g.a.a(cZ, this.fu);
                    } else {
                        a2 = f2;
                    }
                    if (stack.size() > 0) {
                        stack.pop();
                    }
                    if (a2 > b(paint) && com.tencent.mm.ui.widget.celltextview.g.a.m(com.tencent.mm.ui.widget.celltextview.g.a.cZ(text, i5 - 1))) {
                        a2 = ((Float) stack.pop()).floatValue();
                        charAt = com.tencent.mm.ui.widget.celltextview.g.a.cZ(text, i5 - 1);
                        b(this.fu);
                        stack.push(Float.valueOf(a2 - com.tencent.mm.ui.widget.celltextview.g.a.a(charAt, this.fu)));
                        a2 = f3;
                        i6 = i5;
                    } else if (a2 <= b(paint)) {
                        i6 = i5 + 1;
                        a2 += (float) i;
                        stack.push(Float.valueOf(a2));
                    } else {
                        a2 = f3;
                        i6 = i5;
                    }
                    f3 = (float) i2;
                    i5 = i6 - 1;
                    char[] V = com.tencent.mm.ui.widget.celltextview.g.a.V(text, i5 + 1, (i5 + 2) + 1);
                    boolean o = com.tencent.mm.ui.widget.celltextview.g.a.o(V[1]);
                    boolean o2 = com.tencent.mm.ui.widget.celltextview.g.a.o(V[0]);
                    w.i("MicroMsg.NewBreakText", "[isBreakPunc] [%s:%s]", Boolean.valueOf(o2), Boolean.valueOf(o));
                    if (!o2 || o) {
                        if (o2 && o) {
                            i4 = com.tencent.mm.ui.widget.celltextview.g.a.dc(text, i5);
                            if (i4 > 0) {
                                if (this.fu.measureText(text.substring(da(text, i4 - 1), com.tencent.mm.ui.widget.celltextview.g.a.dd(text, i5 + 2) + 1)) <= f3) {
                                    i7 = i4 - 1;
                                }
                            } else {
                                i7 = i6;
                            }
                        }
                        i7 = i6;
                    } else {
                        i7 = com.tencent.mm.ui.widget.celltextview.g.a.dc(text, i5);
                        i7 = i7 > 1 ? da(text, i7 - 1) : i6;
                    }
                    i5 = da(text, i7);
                    i7 = i6 - i5;
                    if (i7 < 0) {
                        stack.push(Float.valueOf(a2));
                    } else {
                        i3 = i7;
                        while (stack.size() > 0 && i3 > 0) {
                            stack.pop();
                            i3--;
                        }
                        char cZ2 = com.tencent.mm.ui.widget.celltextview.g.a.cZ(text, i5 - 1);
                        if (i6 - i5 > 0 && com.tencent.mm.ui.widget.celltextview.g.a.m(cZ2)) {
                            a2 = ((Float) stack.pop()).floatValue();
                            b(this.fu);
                            stack.push(Float.valueOf(a2 - com.tencent.mm.ui.widget.celltextview.g.a.a(cZ2, this.fu)));
                        }
                    }
                    a2 = 0.0f;
                    if (stack.size() > 0) {
                        a2 = ((Float) stack.peek()).floatValue();
                    }
                    if (indexOf == i5) {
                        i8 = 1;
                    } else {
                        i8 = 0;
                    }
                    return new a(i8 + i5, a2);
                }
                i5++;
                f2 = f3;
            }
            i4 = i3 + i4;
        }
        if (z || !com.tencent.mm.ui.widget.celltextview.g.a.m(com.tencent.mm.ui.widget.celltextview.g.a.cZ(text, length - 1))) {
            f = f2;
        } else {
            cZ = com.tencent.mm.ui.widget.celltextview.g.a.cZ(text, length - 1);
            b(this.fu);
            f = f2 - com.tencent.mm.ui.widget.celltextview.g.a.a(cZ, this.fu);
        }
        i3 = (obj != null ? 1 : 0) + length;
        if (i3 == 0) {
            i3 = 0;
            f = (float) i;
        }
        if (f < 0.0f) {
            f = 0.0f;
        }
        return new a(i3, f);
    }

    public final float b(Paint paint) {
        if (0.0f == this.wzf) {
            this.wzf = paint.measureText("A");
        }
        return this.wzf;
    }

    private static int da(String str, int i) {
        int i2 = i - 1;
        char[] V = com.tencent.mm.ui.widget.celltextview.g.a.V(str, i2, (i2 + 1) + 1);
        if (com.tencent.mm.ui.widget.celltextview.g.a.l(V[0]) && com.tencent.mm.ui.widget.celltextview.g.a.l(V[1])) {
            return com.tencent.mm.ui.widget.celltextview.g.a.db(str, i2);
        }
        return i;
    }
}
