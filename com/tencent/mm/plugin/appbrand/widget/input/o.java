package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.widget.e.a;
import com.tencent.mm.plugin.appbrand.widget.input.y.b;

public final class o extends w {
    private float iYt;
    private a jrg;
    private final InputFilter jtZ = new InputFilter(this) {
        final /* synthetic */ o juh;

        {
            this.juh = r1;
        }

        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            if (TextUtils.isEmpty(charSequence) || this.juh.jrg == null) {
                return null;
            }
            if (charSequence instanceof Spannable) {
                charSequence = (Spannable) charSequence;
            } else {
                Object spannableStringBuilder = new SpannableStringBuilder(charSequence);
            }
            charSequence.setSpan(this.juh.jrg, 0, charSequence.length(), 18);
            return charSequence;
        }
    };
    private float jua = 0.0f;
    float jub = 1.2f;
    private float juc = getTextSize();
    private boolean jud = false;
    private MotionEvent jue;
    private boolean juf = false;
    final aa<o> jug = new aa(this);

    public o(Context context) {
        super(context);
        super.setSingleLine(false);
        super.setLineSpacing(0.0f, 1.0f);
        super.setVerticalScrollbarPosition(2);
        super.setSpannableFactory(new Factory(this) {
            final /* synthetic */ o juh;

            {
                this.juh = r1;
            }

            public final Spannable newSpannable(CharSequence charSequence) {
                Spannable newSpannable = super.newSpannable(charSequence);
                if (!(this.juh.jrg == null || TextUtils.isEmpty(newSpannable))) {
                    newSpannable.setSpan(this.juh.jrg, 0, newSpannable.length(), 18);
                }
                return newSpannable;
            }
        });
        super.setEditableFactory(new Editable.Factory(this) {
            final /* synthetic */ o juh;

            {
                this.juh = r1;
            }

            public final Editable newEditable(CharSequence charSequence) {
                Editable newEditable = super.newEditable(charSequence);
                if (!(this.juh.jrg == null || TextUtils.isEmpty(newEditable))) {
                    newEditable.setSpan(this.juh.jrg, 0, newEditable.length(), 18);
                }
                return newEditable;
            }
        });
        super.a(new b(this) {
            final /* synthetic */ o juh;

            {
                this.juh = r1;
            }

            public final void YS() {
                this.juh.YO();
            }
        });
        super.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ o juh;

            {
                this.juh = r1;
            }

            public final boolean onLongClick(View view) {
                return this.juh.Yh();
            }
        });
        this.iYt = (float) ViewConfiguration.get(context).getScaledTouchSlop();
        cw(false);
        a(0.0f, false);
    }

    public final void cw(boolean z) {
        this.jud = z;
        setVerticalScrollBarEnabled(!this.jud);
    }

    protected final void YO() {
        if (!this.jud) {
            return;
        }
        if (getMeasuredHeight() > getMaxHeight()) {
            setMeasuredDimension(getMeasuredWidth(), getMaxHeight());
        } else if (getMeasuredHeight() < getMinHeight() && getMinHeight() > 0) {
            setMeasuredDimension(getMeasuredWidth(), getMinHeight());
        }
    }

    public final void setGravity(int i) {
        super.setGravity(((i & -81) & -17) | 48);
    }

    public final void setSingleLine(boolean z) {
    }

    public final void setInputType(int i) {
        super.setInputType(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT | i);
    }

    public final void setFilters(InputFilter[] inputFilterArr) {
        int i = 0;
        if (this.jtZ != null) {
            if (inputFilterArr == null) {
                inputFilterArr = new InputFilter[0];
            }
            InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length + 1)];
            while (i < inputFilterArr.length) {
                inputFilterArr2[i] = inputFilterArr[i];
                i++;
            }
            inputFilterArr2[i] = this.jtZ;
            inputFilterArr = inputFilterArr2;
        }
        super.setFilters(inputFilterArr);
    }

    final void a(float f, boolean z) {
        if (f <= 0.0f) {
            f = (this.jub * this.juc) + this.jua;
        }
        if (this.jrg == null || this.jrg.Q(f)) {
            this.jrg = new a(f);
            if (!z) {
                return;
            }
            if (hasFocus()) {
                invalidate();
                return;
            }
            Zn();
            setText(getEditableText());
            Zo();
        }
    }

    @Deprecated
    public final float getLineSpacingMultiplier() {
        return super.getLineSpacingMultiplier();
    }

    @Deprecated
    public final float getLineSpacingExtra() {
        return super.getLineSpacingExtra();
    }

    public final void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        this.juc = TypedValue.applyDimension(i, f, getResources().getDisplayMetrics());
        a(0.0f, true);
    }

    public final int getLineHeight() {
        if (this.jrg != null) {
            return this.jrg.height;
        }
        return super.getLineHeight();
    }

    public final void setLineSpacing(float f, float f2) {
        this.jua = f;
        this.jub = f2;
        a(0.0f, true);
    }

    public final View Yq() {
        return v.bT(this);
    }

    public final boolean YP() {
        return true;
    }

    public final boolean YQ() {
        return false;
    }

    public final void YR() {
        ad.bY(this).restartInput(this);
    }

    public final boolean Yh() {
        if (!this.jud) {
            Zj();
            getMeasuredHeight();
        }
        return (isFocusable() || this.jvd) ? false : true;
    }

    protected final void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
    }

    public final void scrollTo(int i, int i2) {
        super.scrollTo(i, i2);
    }

    public final void scrollBy(int i, int i2) {
        super.scrollBy(i, i2);
    }

    public final boolean canScrollVertically(int i) {
        if (Zj() <= getHeight()) {
            return false;
        }
        return super.canScrollVertically(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
        r14 = this;
        r10 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r3 = 1;
        r4 = 0;
        r0 = r14.Yh();
        if (r0 == 0) goto L_0x0319;
    L_0x000a:
        r0 = r14.getParent();
        r0 = r0 instanceof com.tencent.mm.plugin.appbrand.widget.a.e;
        if (r0 == 0) goto L_0x0319;
    L_0x0012:
        r0 = r15.getActionMasked();
        if (r0 != 0) goto L_0x0024;
    L_0x0018:
        r0 = r14.getParent();
        r0 = (com.tencent.mm.plugin.appbrand.widget.a.e) r0;
        r0 = r0.w(r15);
        if (r0 == 0) goto L_0x0051;
    L_0x0024:
        r6 = r14.jug;
        r0 = r6.TAG;
        r1 = "processTouchEvent";
        com.tencent.mm.plugin.appbrand.widget.a.b.a(r0, r1, r15);
        r0 = r6.jvr;
        r1 = r15.getActionIndex();
        r2 = r15.getX(r1);
        r1 = r15.getY(r1);
        r5 = r15.getActionMasked();
        if (r5 == 0) goto L_0x0052;
    L_0x0042:
        r5 = r6.jvt;
        if (r5 != 0) goto L_0x0052;
    L_0x0046:
        r0 = r6.TAG;
        r1 = "[textscroll] no pointer down before, just return";
        com.tencent.mm.sdk.platformtools.w.v(r0, r1);
        r6.Zr();
    L_0x0051:
        return r4;
    L_0x0052:
        r5 = r15.getActionMasked();
        switch(r5) {
            case 0: goto L_0x00f7;
            case 1: goto L_0x008f;
            case 2: goto L_0x0140;
            case 3: goto L_0x013a;
            default: goto L_0x0059;
        };
    L_0x0059:
        r1 = r4;
    L_0x005a:
        r7 = r6.jvr;
        r0 = r6.jvr;
        r5 = r0.getText();
        r0 = -1;
        r0 = r7.canScrollVertically(r0);
        if (r0 != 0) goto L_0x006f;
    L_0x0069:
        r0 = r7.canScrollVertically(r3);
        if (r0 == 0) goto L_0x0076;
    L_0x006f:
        r0 = r15.getActionMasked();
        switch(r0) {
            case 0: goto L_0x017f;
            case 1: goto L_0x01b3;
            case 2: goto L_0x01c3;
            case 3: goto L_0x01b3;
            default: goto L_0x0076;
        };
    L_0x0076:
        r3 = r4;
    L_0x0077:
        r4 = r1 | r3;
        r0 = r6.TAG;
        r1 = new java.lang.StringBuilder;
        r2 = "[textscroll] handled | ";
        r1.<init>(r2);
        r1 = r1.append(r4);
        r1 = r1.toString();
        com.tencent.mm.plugin.appbrand.widget.a.b.a(r0, r1, r15);
        goto L_0x0051;
    L_0x008f:
        r5 = r6.TAG;
        r7 = "[apptouch] ACTION_UP, pointerDown %B";
        r8 = new java.lang.Object[r3];
        r9 = r6.jvu;
        r9 = java.lang.Boolean.valueOf(r9);
        r8[r4] = r9;
        com.tencent.mm.sdk.platformtools.w.v(r5, r7, r8);
        r5 = r6.jvu;
        if (r5 == 0) goto L_0x00da;
    L_0x00a5:
        r5 = r6.jvt;
        if (r5 == 0) goto L_0x00da;
    L_0x00a9:
        r5 = r6.jvr;
        r5 = com.tencent.mm.plugin.appbrand.jsapi.k.c.bD(r5);
        r7 = r6.jvs;
        if (r7 == 0) goto L_0x00d2;
    L_0x00b3:
        r7 = r6.jvs;
        r7 = r7.x;
        r8 = r5.x;
        r7 = r7 - r8;
        r7 = java.lang.Math.abs(r7);
        r7 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1));
        if (r7 > 0) goto L_0x00d2;
    L_0x00c2:
        r7 = r6.jvs;
        r7 = r7.y;
        r5 = r5.y;
        r5 = r7 - r5;
        r5 = java.lang.Math.abs(r5);
        r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1));
        if (r5 <= 0) goto L_0x00e0;
    L_0x00d2:
        r0 = r6.TAG;
        r1 = "[apptouch] check tap on ACTION_UP, but view has moved.";
        com.tencent.mm.sdk.platformtools.w.v(r0, r1);
    L_0x00da:
        r6.Zr();
        r1 = r4;
        goto L_0x005a;
    L_0x00e0:
        r5 = r6.jvt;
        r5 = r6.a(r5, r15);
        if (r5 != 0) goto L_0x00f1;
    L_0x00e8:
        r0 = r6.TAG;
        r1 = "[apptouch] check tap on ACTION_UP exceed tap scope";
        com.tencent.mm.sdk.platformtools.w.v(r0, r1);
        goto L_0x00da;
    L_0x00f1:
        r0 = (com.tencent.mm.plugin.appbrand.widget.input.y) r0;
        r0.l(r2, r1);
        goto L_0x00da;
    L_0x00f7:
        r1 = android.view.MotionEvent.obtain(r15);
        r6.jvt = r1;
        r1 = com.tencent.mm.plugin.appbrand.jsapi.k.c.bD(r0);
        r6.jvs = r1;
        if (r0 == 0) goto L_0x0132;
    L_0x0105:
        r2 = r0.getParent();
    L_0x0109:
        if (r2 == 0) goto L_0x0132;
    L_0x010b:
        r1 = r2 instanceof android.view.ViewGroup;
        if (r1 == 0) goto L_0x0132;
    L_0x010f:
        r1 = r2;
        r1 = (android.view.ViewGroup) r1;
        r1 = r1.shouldDelayChildPressedState();
        if (r1 == 0) goto L_0x012d;
    L_0x0118:
        r1 = r3;
    L_0x0119:
        r2 = r6.jvv;
        r0.removeCallbacks(r2);
        if (r1 == 0) goto L_0x0134;
    L_0x0120:
        r1 = r6.jvv;
        r2 = android.view.ViewConfiguration.getTapTimeout();
        r8 = (long) r2;
        r0.postDelayed(r1, r8);
    L_0x012a:
        r1 = r3;
        goto L_0x005a;
    L_0x012d:
        r2 = r2.getParent();
        goto L_0x0109;
    L_0x0132:
        r1 = r4;
        goto L_0x0119;
    L_0x0134:
        r0 = r6.jvv;
        r0.run();
        goto L_0x012a;
    L_0x013a:
        r6.Zr();
        r1 = r4;
        goto L_0x005a;
    L_0x0140:
        r5 = r6.jsF;
        r7 = -r5;
        r7 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1));
        if (r7 < 0) goto L_0x017a;
    L_0x0147:
        r7 = -r5;
        r7 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1));
        if (r7 < 0) goto L_0x017a;
    L_0x014c:
        r7 = r0.getWidth();
        r7 = (float) r7;
        r7 = r7 + r5;
        r2 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1));
        if (r2 >= 0) goto L_0x017a;
    L_0x0156:
        r2 = r0.getHeight();
        r2 = (float) r2;
        r2 = r2 + r5;
        r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
        if (r1 >= 0) goto L_0x017a;
    L_0x0160:
        r1 = r3;
    L_0x0161:
        if (r1 == 0) goto L_0x016b;
    L_0x0163:
        r1 = r6.jvt;
        r1 = r6.a(r1, r15);
        if (r1 != 0) goto L_0x017c;
    L_0x016b:
        r6.jvu = r4;
        r1 = r6.jvv;
        r0.removeCallbacks(r1);
        r1 = r6.jvw;
        r0.removeCallbacks(r1);
        r1 = r4;
        goto L_0x005a;
    L_0x017a:
        r1 = r4;
        goto L_0x0161;
    L_0x017c:
        r1 = r3;
        goto L_0x005a;
    L_0x017f:
        r0 = r5.length();
        r2 = com.tencent.mm.plugin.appbrand.widget.input.ac.a.class;
        r0 = r5.getSpans(r4, r0, r2);
        r0 = (com.tencent.mm.plugin.appbrand.widget.input.ac.a[]) r0;
        r2 = r4;
    L_0x018c:
        r8 = r0.length;
        if (r2 >= r8) goto L_0x0197;
    L_0x018f:
        r8 = r0[r2];
        r5.removeSpan(r8);
        r2 = r2 + 1;
        goto L_0x018c;
    L_0x0197:
        r0 = new com.tencent.mm.plugin.appbrand.widget.input.ac$a;
        r2 = r15.getX();
        r8 = r15.getY();
        r9 = r7.getScrollX();
        r7 = r7.getScrollY();
        r0.<init>(r2, r8, r9, r7);
        r2 = 17;
        r5.setSpan(r0, r4, r4, r2);
        goto L_0x0077;
    L_0x01b3:
        r0 = com.tencent.mm.plugin.appbrand.widget.input.ac.e(r7);
        r2 = r0.length;
        if (r2 <= 0) goto L_0x01c0;
    L_0x01ba:
        r0 = r0[r4];
        r0 = r0.jvH;
        if (r0 != 0) goto L_0x0077;
    L_0x01c0:
        r3 = r4;
        goto L_0x0077;
    L_0x01c3:
        r0 = r5.length();
        r2 = com.tencent.mm.plugin.appbrand.widget.input.ac.a.class;
        r0 = r5.getSpans(r4, r0, r2);
        r0 = (com.tencent.mm.plugin.appbrand.widget.input.ac.a[]) r0;
        r2 = r0.length;
        if (r2 <= 0) goto L_0x0076;
    L_0x01d2:
        r2 = r0[r4];
        r2 = r2.jvG;
        if (r2 != 0) goto L_0x020c;
    L_0x01d8:
        r2 = r7.getContext();
        r2 = android.view.ViewConfiguration.get(r2);
        r2 = r2.getScaledTouchSlop();
        r8 = r15.getX();
        r9 = r0[r4];
        r9 = r9.agA;
        r8 = r8 - r9;
        r8 = java.lang.Math.abs(r8);
        r9 = (float) r2;
        r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1));
        if (r8 >= 0) goto L_0x0208;
    L_0x01f6:
        r8 = r15.getY();
        r9 = r0[r4];
        r9 = r9.agB;
        r8 = r8 - r9;
        r8 = java.lang.Math.abs(r8);
        r2 = (float) r2;
        r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x020c;
    L_0x0208:
        r2 = r0[r4];
        r2.jvG = r3;
    L_0x020c:
        r2 = r0[r4];
        r2 = r2.jvG;
        if (r2 == 0) goto L_0x0076;
    L_0x0212:
        r2 = r0[r4];
        r2.jvH = r3;
        r2 = r15.getMetaState();
        r2 = r2 & 1;
        if (r2 != 0) goto L_0x022c;
    L_0x021e:
        r2 = android.text.method.MetaKeyKeyListener.getMetaState(r5, r3);
        if (r2 == r3) goto L_0x022c;
    L_0x0224:
        r2 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r2 = android.text.method.MetaKeyKeyListener.getMetaState(r5, r2);
        if (r2 == 0) goto L_0x0262;
    L_0x022c:
        r2 = r3;
    L_0x022d:
        if (r2 == 0) goto L_0x0264;
    L_0x022f:
        r2 = r15.getX();
        r5 = r0[r4];
        r5 = r5.agA;
        r5 = r2 - r5;
        r2 = r15.getY();
        r8 = r0[r4];
        r8 = r8.agB;
        r2 = r2 - r8;
    L_0x0242:
        r8 = r0[r4];
        r9 = r15.getX();
        r8.agA = r9;
        r8 = r0[r4];
        r9 = r15.getY();
        r8.agB = r9;
        r8 = r0[r4];
        r8 = r8.jvJ;
        if (r8 == 0) goto L_0x0278;
    L_0x0258:
        r2 = r0[r4];
        r2.jvJ = r4;
        r0 = r0[r4];
        r0.jvG = r4;
        goto L_0x0076;
    L_0x0262:
        r2 = r4;
        goto L_0x022d;
    L_0x0264:
        r2 = r0[r4];
        r2 = r2.agA;
        r5 = r15.getX();
        r5 = r2 - r5;
        r2 = r0[r4];
        r2 = r2.agB;
        r8 = r15.getY();
        r2 = r2 - r8;
        goto L_0x0242;
    L_0x0278:
        r8 = r7.getScrollX();
        r5 = (int) r5;
        r5 = r5 + r8;
        r8 = r7.getScrollY();
        r2 = (int) r2;
        r2 = r2 + r8;
        r8 = r7.getTotalPaddingTop();
        r9 = r7.getTotalPaddingBottom();
        r8 = r8 + r9;
        r9 = r7.getLayout();
        r10 = r9.getHeight();
        r11 = r7.getHeight();
        r8 = r11 - r8;
        r8 = r10 - r8;
        r2 = java.lang.Math.min(r2, r8);
        r8 = java.lang.Math.max(r2, r4);
        r10 = r7.getScrollX();
        r11 = r7.getScrollY();
        r2 = r7.getTotalPaddingLeft();
        r12 = r7.getTotalPaddingRight();
        r2 = r2 + r12;
        r12 = r7.getWidth();
        r12 = r12 - r2;
        r2 = r9.getLineForVertical(r8);
        r13 = r9.getParagraphAlignment(r2);
        r2 = r9.getParagraphDirection(r2);
        if (r2 <= 0) goto L_0x02f0;
    L_0x02c9:
        r2 = r3;
    L_0x02ca:
        r9 = r12 + 0;
        if (r9 >= r12) goto L_0x0305;
    L_0x02ce:
        r5 = android.text.Layout.Alignment.ALIGN_CENTER;
        if (r13 != r5) goto L_0x02f2;
    L_0x02d2:
        r2 = r12 - r9;
        r2 = r2 / 2;
        r2 = 0 - r2;
    L_0x02d8:
        r7.scrollTo(r2, r8);
        r2 = r7.getScrollX();
        if (r10 != r2) goto L_0x02e7;
    L_0x02e1:
        r2 = r7.getScrollY();
        if (r11 == r2) goto L_0x030e;
    L_0x02e7:
        r7.cancelLongPress();
        r0 = r0[r4];
        r0.jvI = r3;
        goto L_0x0077;
    L_0x02f0:
        r2 = r4;
        goto L_0x02ca;
    L_0x02f2:
        if (r2 == 0) goto L_0x02f8;
    L_0x02f4:
        r5 = android.text.Layout.Alignment.ALIGN_OPPOSITE;
        if (r13 == r5) goto L_0x02fe;
    L_0x02f8:
        if (r2 != 0) goto L_0x0303;
    L_0x02fa:
        r2 = android.text.Layout.Alignment.ALIGN_NORMAL;
        if (r13 != r2) goto L_0x0303;
    L_0x02fe:
        r2 = r12 - r9;
        r2 = 0 - r2;
        goto L_0x02d8;
    L_0x0303:
        r2 = r4;
        goto L_0x02d8;
    L_0x0305:
        r2 = java.lang.Math.min(r5, r4);
        r2 = java.lang.Math.max(r2, r4);
        goto L_0x02d8;
    L_0x030e:
        r0 = r0[r4];
        r0 = r0.jvI;
        if (r0 != 0) goto L_0x0077;
    L_0x0314:
        com.tencent.mm.plugin.appbrand.widget.input.ac.e(r7);
        goto L_0x0076;
    L_0x0319:
        r0 = r15.getActionMasked();
        switch(r0) {
            case 0: goto L_0x0352;
            case 1: goto L_0x0326;
            case 2: goto L_0x035b;
            case 3: goto L_0x0326;
            default: goto L_0x0320;
        };
    L_0x0320:
        r4 = super.onTouchEvent(r15);
        goto L_0x0051;
    L_0x0326:
        r14.juf = r4;
        r0 = r14.jue;
        if (r0 == 0) goto L_0x0334;
    L_0x032c:
        r0 = r14.jue;
        r0.recycle();
        r0 = 0;
        r14.jue = r0;
    L_0x0334:
        r0 = r14.juf;
        if (r0 == 0) goto L_0x0320;
    L_0x0338:
        r0 = r15.getActionIndex();
        r0 = r15.getX(r0);
        r1 = r15.getActionIndex();
        r1 = r15.getY(r1);
        r0 = com.tencent.mm.plugin.appbrand.widget.input.ad.b.a(r14, r0, r1);
        if (r0 < 0) goto L_0x0320;
    L_0x034e:
        r14.setSelection(r0);
        goto L_0x0320;
    L_0x0352:
        r0 = android.view.MotionEvent.obtain(r15);
        r14.jue = r0;
        r14.juf = r3;
        goto L_0x0320;
    L_0x035b:
        r0 = r14.juf;
        if (r0 == 0) goto L_0x0320;
    L_0x035f:
        r0 = r14.jue;
        r1 = r14.jue;
        r1 = r1.getActionIndex();
        r0 = r0.getX(r1);
        r1 = r14.jue;
        r2 = r14.jue;
        r2 = r2.getActionIndex();
        r1 = r1.getY(r2);
        r2 = r15.getActionIndex();
        r2 = r15.getX(r2);
        r3 = r15.getActionIndex();
        r3 = r15.getY(r3);
        r0 = r0 - r2;
        r0 = java.lang.Math.abs(r0);
        r2 = r14.iYt;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 > 0) goto L_0x039e;
    L_0x0392:
        r0 = r1 - r3;
        r0 = java.lang.Math.abs(r0);
        r1 = r14.iYt;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 <= 0) goto L_0x0320;
    L_0x039e:
        r14.cancelLongPress();
        r14.setPressed(r4);
        r14.juf = r4;
        goto L_0x0320;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.widget.input.o.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void l(float f, float f2) {
        if (isEnabled()) {
            if (Yh()) {
                int a = b.a(this, f, f2);
                if (a >= 0) {
                    setSelection(a);
                }
            }
            super.performClick();
        }
    }

    public final boolean performHapticFeedback(int i, int i2) {
        return super.performHapticFeedback(i, i2);
    }
}
