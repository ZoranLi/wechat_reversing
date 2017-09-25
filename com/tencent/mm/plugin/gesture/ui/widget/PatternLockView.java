package com.tencent.mm.plugin.gesture.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.sdk.platformtools.d;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PatternLockView extends View {
    private static Bitmap mIQ = null;
    private static Bitmap mIR = null;
    private static Bitmap mIS = null;
    private static Bitmap mIT = null;
    private int lnZ;
    private Paint mIA = new Paint();
    private Paint mIB = new Paint();
    private Path mIC = new Path();
    private Matrix mID = new Matrix();
    private Rect mIE = new Rect();
    private Rect mIF = new Rect();
    private ArrayList<com.tencent.mm.plugin.gesture.a.c> mIG = new ArrayList(9);
    private boolean[][] mIH = ((boolean[][]) Array.newInstance(Boolean.TYPE, new int[]{3, 3}));
    private int mII = c.mJi;
    private int mIJ = 6;
    private int mIK = m.CTRL_INDEX;
    private float mIL = 0.66f;
    private boolean mIM = false;
    private boolean mIN = true;
    public boolean mIO = false;
    private b mIP;
    private float mIU;
    private float mIV;
    private boolean mIW;
    private long mIX;
    private float mIY;
    private float mIZ;
    public a mJa;
    private int ud;
    private int ue;

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean mIM;
        boolean mIN;
        boolean mIO;
        String mJg;
        int mJh;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.mJg = parcel.readString();
            this.mJh = parcel.readInt();
            this.mIN = ((Boolean) parcel.readValue(null)).booleanValue();
            this.mIO = ((Boolean) parcel.readValue(null)).booleanValue();
            this.mIM = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public SavedState(Parcelable parcelable, String str, int i, boolean z, boolean z2, boolean z3) {
            super(parcelable);
            this.mJg = str;
            this.mJh = i;
            this.mIN = z;
            this.mIO = z2;
            this.mIM = z3;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.mJg);
            parcel.writeInt(this.mJh);
            parcel.writeValue(Boolean.valueOf(this.mIN));
            parcel.writeValue(Boolean.valueOf(this.mIO));
            parcel.writeValue(Boolean.valueOf(this.mIM));
        }
    }

    public interface a {
        void a(PatternLockView patternLockView);

        void a(PatternLockView patternLockView, List<com.tencent.mm.plugin.gesture.a.c> list);
    }

    public enum b {
        Correct,
        Wrong,
        Animate
    }

    public enum c {
        ;

        static {
            mJi = 1;
            mJj = 2;
            mJk = new int[]{mJi, mJj};
        }
    }

    public PatternLockView(Context context, AttributeSet attributeSet) {
        int i;
        super(context, attributeSet);
        if (isInEditMode()) {
            i = -1;
        } else {
            i = getResources().getColor(R.e.aTZ);
        }
        this.lnZ = i;
        this.mIP = b.Correct;
        this.mIU = -1.0f;
        this.mIV = -1.0f;
        this.mIW = false;
        this.mIX = 0;
        this.ud = 0;
        this.ue = 0;
        this.mIY = 0.0f;
        this.mIZ = 0.0f;
        this.mJa = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.fsU);
        this.mIN = obtainStyledAttributes.getBoolean(R.n.fsZ, this.mIN);
        this.mIK = obtainStyledAttributes.getInt(R.n.fsW, this.mIK);
        this.mIJ = obtainStyledAttributes.getInt(R.n.fsX, this.mIJ);
        this.mIM = obtainStyledAttributes.getBoolean(R.n.fsV, this.mIM);
        switch (obtainStyledAttributes.getInt(R.n.fsY, this.mII - 1)) {
            case 0:
                this.mII = c.mJi;
                break;
            case 1:
                this.mII = c.mJj;
                break;
            default:
                this.mII = c.mJi;
                break;
        }
        obtainStyledAttributes.recycle();
        setClickable(true);
        this.mIB.setStyle(Style.STROKE);
        this.mIB.setStrokeJoin(Join.ROUND);
        this.mIB.setStrokeCap(Cap.ROUND);
        this.mIB.setAntiAlias(true);
        this.mIB.setDither(false);
        this.mIB.setAlpha(this.mIK);
        this.mIA.setAntiAlias(true);
        this.mIA.setDither(true);
        if (!isInEditMode()) {
            if (mIQ == null) {
                mIQ = q(com.tencent.mm.bg.a.a(getContext(), R.g.bfC));
                Bitmap q = q(com.tencent.mm.bg.a.a(getContext(), R.g.bfD));
                mIR = q;
                mIS = q;
                mIT = q(com.tencent.mm.bg.a.a(getContext(), R.g.bfE));
            }
            this.mIJ = (int) (((float) this.mIJ) * d.bIz().density);
            Bitmap[] bitmapArr = new Bitmap[]{mIQ, mIR, mIS, mIT};
            for (i = 0; i < 4; i++) {
                Bitmap bitmap = bitmapArr[i];
                this.ud = Math.max(bitmap.getWidth(), this.ud);
                this.ue = Math.max(bitmap.getHeight(), this.ue);
            }
        }
    }

    private static Bitmap q(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Config.ARGB_8888 : Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private static String aH(List<com.tencent.mm.plugin.gesture.a.c> list) {
        if (list == null) {
            throw new IllegalArgumentException("pattern is null");
        }
        int size = list.size();
        byte[] bArr = new byte[size];
        for (int i = 0; i < size; i++) {
            com.tencent.mm.plugin.gesture.a.c cVar = (com.tencent.mm.plugin.gesture.a.c) list.get(i);
            bArr[i] = (byte) (cVar.kTJ + (cVar.kTI * 3));
        }
        return new String(bArr);
    }

    protected Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), aH(this.mIG), this.mIP.ordinal(), this.mIN, this.mIO, this.mIM);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        b bVar = b.Correct;
        String str = savedState.mJg;
        if (str == null) {
            throw new IllegalArgumentException("Serialized pattern is null");
        }
        List arrayList = new ArrayList();
        byte[] bytes = str.getBytes();
        for (byte b : bytes) {
            arrayList.add(com.tencent.mm.plugin.gesture.a.c.ch(b / 3, b % 3));
        }
        a(bVar, arrayList);
        this.mIP = b.values()[savedState.mJh];
        this.mIN = savedState.mIN;
        this.mIO = savedState.mIO;
        this.mIM = savedState.mIM;
    }

    protected int getSuggestedMinimumWidth() {
        return (int) ((3.0d * ((double) ((float) this.ud))) / ((double) getResources().getDisplayMetrics().density));
    }

    protected int getSuggestedMinimumHeight() {
        return (int) ((3.0d * ((double) ((float) this.ue))) / ((double) getResources().getDisplayMetrics().density));
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.mIY = ((float) ((i - getPaddingLeft()) - getPaddingRight())) / 3.0f;
        this.mIZ = ((float) ((i2 - getPaddingTop()) - getPaddingBottom())) / 3.0f;
    }

    private static int ci(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        switch (MeasureSpec.getMode(i)) {
            case Integer.MIN_VALUE:
                return Math.max(size, i2);
            case 0:
                return i2;
            default:
                return size;
        }
    }

    protected void onMeasure(int i, int i2) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        int ci = ci(i, suggestedMinimumWidth);
        suggestedMinimumWidth = ci(i2, suggestedMinimumHeight);
        if (this.mII == c.mJi) {
            suggestedMinimumWidth = Math.min(ci, suggestedMinimumWidth);
            ci = suggestedMinimumWidth;
        }
        setMeasuredDimension(ci, suggestedMinimumWidth);
    }

    protected void onDraw(Canvas canvas) {
        int elapsedRealtime;
        int i;
        com.tencent.mm.plugin.gesture.a.c cVar;
        Object obj;
        ArrayList arrayList = this.mIG;
        int size = arrayList.size();
        boolean[][] zArr = this.mIH;
        if (this.mIP == b.Animate) {
            elapsedRealtime = ((int) (SystemClock.elapsedRealtime() - this.mIX)) % ((size + 1) * 700);
            i = elapsedRealtime / 700;
            aCR();
            for (int i2 = 0; i2 < i; i2++) {
                cVar = (com.tencent.mm.plugin.gesture.a.c) arrayList.get(i2);
                zArr[cVar.kTI][cVar.kTJ] = true;
            }
            obj = (i <= 0 || i >= size) ? null : 1;
            if (obj != null) {
                float f = ((float) (elapsedRealtime % 700)) / 700.0f;
                cVar = (com.tencent.mm.plugin.gesture.a.c) arrayList.get(i - 1);
                float nS = nS(cVar.kTJ);
                float nT = nT(cVar.kTI);
                cVar = (com.tencent.mm.plugin.gesture.a.c) arrayList.get(i);
                float nS2 = (nS(cVar.kTJ) - nS) * f;
                float nT2 = (nT(cVar.kTI) - nT) * f;
                this.mIU = nS + nS2;
                this.mIV = nT2 + nT;
            }
            invalidate();
        }
        this.mIB.setColor(this.lnZ);
        this.mIB.setStrokeWidth((float) this.mIJ);
        Path path = this.mIC;
        path.rewind();
        obj = (this.mIN || this.mIP == b.Wrong) ? 1 : null;
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        float f2 = this.mIY;
        float f3 = this.mIZ;
        boolean z = (this.mIA.getFlags() & 2) != 0;
        this.mIA.setFilterBitmap(true);
        for (i = 0; i < 3; i++) {
            float f4 = (((float) i) * f3) + ((float) paddingTop);
            for (elapsedRealtime = 0; elapsedRealtime < 3; elapsedRealtime++) {
                float f5 = ((float) paddingLeft) + (((float) elapsedRealtime) * f2);
                if (!zArr[i][elapsedRealtime]) {
                    a(canvas, (int) f5, (int) f4, zArr[i][elapsedRealtime]);
                }
            }
        }
        if (obj != null) {
            Object obj2 = null;
            for (elapsedRealtime = 0; elapsedRealtime < size; elapsedRealtime++) {
                cVar = (com.tencent.mm.plugin.gesture.a.c) arrayList.get(elapsedRealtime);
                if (!zArr[cVar.kTI][cVar.kTJ]) {
                    break;
                }
                obj2 = 1;
                f4 = nS(cVar.kTJ);
                nT2 = nT(cVar.kTI);
                if (elapsedRealtime == 0) {
                    path.moveTo(f4, nT2);
                } else {
                    path.lineTo(f4, nT2);
                }
            }
            if ((this.mIW || this.mIP == b.Animate) && r9 != null) {
                path.lineTo(this.mIU, this.mIV);
            }
            canvas.drawPath(path, this.mIB);
        }
        for (elapsedRealtime = 0; elapsedRealtime < 3; elapsedRealtime++) {
            nS2 = (((float) elapsedRealtime) * f3) + ((float) paddingTop);
            for (int i3 = 0; i3 < 3; i3++) {
                float f6 = ((float) paddingLeft) + (((float) i3) * f2);
                if (zArr[elapsedRealtime][i3]) {
                    a(canvas, (int) f6, (int) nS2, zArr[elapsedRealtime][i3]);
                }
            }
        }
        this.mIA.setFilterBitmap(z);
    }

    private void a(Canvas canvas, int i, int i2, boolean z) {
        Bitmap bitmap;
        if (!z || (!this.mIN && this.mIP != b.Wrong)) {
            bitmap = mIQ;
        } else if (this.mIW) {
            bitmap = mIR;
        } else if (this.mIP == b.Wrong) {
            bitmap = mIT;
        } else if (this.mIP == b.Correct || this.mIP == b.Animate) {
            bitmap = mIS;
        } else {
            throw new IllegalStateException("unknown display mode " + this.mIP);
        }
        int i3 = this.ud;
        int i4 = this.ue;
        i3 = (int) ((this.mIY - ((float) i3)) * 0.5f);
        i4 = (int) ((this.mIZ - ((float) i4)) * 0.5f);
        float f = getResources().getDisplayMetrics().density;
        float min = Math.min((this.mIY - (33.0f * f)) / ((float) this.ud), 1.0f);
        f = Math.min((this.mIZ - (f * 33.0f)) / ((float) this.ue), 1.0f);
        this.mID.setTranslate((float) (i3 + i), (float) (i4 + i2));
        this.mID.preTranslate((float) (this.ud / 2), (float) (this.ue / 2));
        this.mID.preScale(min, f);
        this.mID.preTranslate((float) ((-this.ud) / 2), (float) ((-this.ue) / 2));
        if (!isInEditMode()) {
            canvas.drawBitmap(bitmap, this.mID, this.mIA);
        }
    }

    private com.tencent.mm.plugin.gesture.a.c q(float f, float f2) {
        int i = 0;
        com.tencent.mm.plugin.gesture.a.c cVar = null;
        float f3 = this.mIZ;
        float f4 = f3 * this.mIL;
        float paddingTop = ((f3 - f4) / 2.0f) + ((float) getPaddingTop());
        int i2 = 0;
        while (i2 < 3) {
            float f5 = (((float) i2) * f3) + paddingTop;
            if (f2 >= f5 && f2 <= f5 + f4) {
                break;
            }
            i2++;
        }
        i2 = -1;
        if (i2 >= 0) {
            f3 = this.mIY;
            f4 = this.mIL * f3;
            paddingTop = ((float) getPaddingLeft()) + ((f3 - f4) / 2.0f);
            while (i < 3) {
                f5 = (((float) i) * f3) + paddingTop;
                if (f >= f5 && f <= f5 + f4) {
                    break;
                }
                i++;
            }
            i = -1;
            if (i >= 0 && !this.mIH[i2][i]) {
                cVar = com.tencent.mm.plugin.gesture.a.c.ch(i2, i);
            }
        }
        if (cVar == null) {
            return null;
        }
        this.mIH[cVar.kTI][cVar.kTJ] = true;
        this.mIG.add(cVar);
        if (this.mJa != null) {
            ArrayList arrayList = new ArrayList(this.mIG);
        }
        if (!this.mIM) {
            return cVar;
        }
        performHapticFeedback(1, 3);
        return cVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r14) {
        /*
        r13 = this;
        r0 = r13.mIO;
        if (r0 == 0) goto L_0x000a;
    L_0x0004:
        r0 = r13.isEnabled();
        if (r0 != 0) goto L_0x000c;
    L_0x000a:
        r0 = 0;
    L_0x000b:
        return r0;
    L_0x000c:
        r0 = r14.getAction();
        switch(r0) {
            case 0: goto L_0x0015;
            case 1: goto L_0x0060;
            case 2: goto L_0x0080;
            case 3: goto L_0x0207;
            default: goto L_0x0013;
        };
    L_0x0013:
        r0 = 0;
        goto L_0x000b;
    L_0x0015:
        r13.aCS();
        r0 = r14.getX();
        r1 = r14.getY();
        r2 = r13.q(r0, r1);
        if (r2 == 0) goto L_0x005c;
    L_0x0026:
        r3 = 1;
        r13.mIW = r3;
        r3 = com.tencent.mm.plugin.gesture.ui.widget.PatternLockView.b.Correct;
        r13.mIP = r3;
        r3 = r13.mJa;
        if (r3 == 0) goto L_0x0031;
    L_0x0031:
        if (r2 == 0) goto L_0x0056;
    L_0x0033:
        r3 = r2.kTJ;
        r3 = r13.nS(r3);
        r2 = r2.kTI;
        r2 = r13.nT(r2);
        r4 = r13.mIY;
        r5 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r4 = r4 * r5;
        r5 = r13.mIZ;
        r6 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r5 = r5 * r6;
        r6 = r3 - r4;
        r6 = (int) r6;
        r7 = r2 - r5;
        r7 = (int) r7;
        r3 = r3 + r4;
        r3 = (int) r3;
        r2 = r2 + r5;
        r2 = (int) r2;
        r13.invalidate(r6, r7, r3, r2);
    L_0x0056:
        r13.mIU = r0;
        r13.mIV = r1;
        r0 = 1;
        goto L_0x000b;
    L_0x005c:
        r3 = 0;
        r13.mIW = r3;
        goto L_0x0031;
    L_0x0060:
        r0 = r13.mIG;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x007e;
    L_0x0068:
        r0 = 0;
        r13.mIW = r0;
        r0 = r13.mJa;
        if (r0 == 0) goto L_0x007b;
    L_0x006f:
        r0 = r13.mJa;
        r1 = new java.util.ArrayList;
        r2 = r13.mIG;
        r1.<init>(r2);
        r0.a(r13, r1);
    L_0x007b:
        r13.invalidate();
    L_0x007e:
        r0 = 1;
        goto L_0x000b;
    L_0x0080:
        r0 = r13.mIJ;
        r7 = (float) r0;
        r8 = r14.getHistorySize();
        r0 = r13.mIE;
        r0.setEmpty();
        r2 = 0;
        r0 = 0;
        r6 = r0;
    L_0x008f:
        r0 = r8 + 1;
        if (r6 >= r0) goto L_0x0159;
    L_0x0093:
        if (r6 >= r8) goto L_0x014b;
    L_0x0095:
        r0 = r14.getHistoricalX(r6);
        r3 = r0;
    L_0x009a:
        if (r6 >= r8) goto L_0x0152;
    L_0x009c:
        r0 = r14.getHistoricalY(r6);
        r1 = r0;
    L_0x00a1:
        r9 = r13.q(r3, r1);
        r0 = r13.mIG;
        r4 = r0.size();
        if (r9 == 0) goto L_0x00b3;
    L_0x00ad:
        r0 = 1;
        if (r4 != r0) goto L_0x00b3;
    L_0x00b0:
        r0 = 1;
        r13.mIW = r0;
    L_0x00b3:
        r0 = r13.mIU;
        r0 = r3 - r0;
        r0 = java.lang.Math.abs(r0);
        r5 = r13.mIV;
        r5 = r1 - r5;
        r5 = java.lang.Math.abs(r5);
        r10 = 0;
        r0 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1));
        if (r0 > 0) goto L_0x00cd;
    L_0x00c8:
        r0 = 0;
        r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x00cf;
    L_0x00cd:
        r0 = 1;
        r2 = r0;
    L_0x00cf:
        r0 = r13.mIW;
        if (r0 == 0) goto L_0x0146;
    L_0x00d3:
        if (r4 <= 0) goto L_0x0146;
    L_0x00d5:
        r0 = r13.mIG;
        r4 = r4 + -1;
        r0 = r0.get(r4);
        r0 = (com.tencent.mm.plugin.gesture.a.c) r0;
        r4 = r0.kTJ;
        r4 = r13.nS(r4);
        r0 = r0.kTI;
        r10 = r13.nT(r0);
        r0 = java.lang.Math.min(r4, r3);
        r0 = r0 - r7;
        r3 = java.lang.Math.max(r4, r3);
        r5 = r3 + r7;
        r3 = java.lang.Math.min(r10, r1);
        r3 = r3 - r7;
        r1 = java.lang.Math.max(r10, r1);
        r4 = r1 + r7;
        if (r9 == 0) goto L_0x021d;
    L_0x0103:
        r1 = r13.mIY;
        r10 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r1 = r1 * r10;
        r10 = r13.mIZ;
        r11 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r10 = r10 * r11;
        r11 = r9.kTJ;
        r11 = r13.nS(r11);
        r9 = r9.kTI;
        r9 = r13.nT(r9);
        r12 = r11 - r1;
        r0 = java.lang.Math.min(r12, r0);
        r1 = r1 + r11;
        r5 = java.lang.Math.max(r1, r5);
        r1 = r9 - r10;
        r1 = java.lang.Math.min(r1, r3);
        r3 = r9 + r10;
        r3 = java.lang.Math.max(r3, r4);
        r4 = r5;
    L_0x0131:
        r5 = r13.mIE;
        r0 = java.lang.Math.round(r0);
        r1 = java.lang.Math.round(r1);
        r4 = java.lang.Math.round(r4);
        r3 = java.lang.Math.round(r3);
        r5.union(r0, r1, r4, r3);
    L_0x0146:
        r0 = r6 + 1;
        r6 = r0;
        goto L_0x008f;
    L_0x014b:
        r0 = r14.getX();
        r3 = r0;
        goto L_0x009a;
    L_0x0152:
        r0 = r14.getY();
        r1 = r0;
        goto L_0x00a1;
    L_0x0159:
        r0 = r14.getX();
        r13.mIU = r0;
        r0 = r13.mIU;
        r1 = r13.getPaddingLeft();
        r3 = r13.mIJ;
        r1 = r1 + r3;
        r1 = (float) r1;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 >= 0) goto L_0x01ad;
    L_0x016d:
        r0 = r13.getPaddingLeft();
        r1 = r13.mIJ;
        r0 = r0 + r1;
        r0 = (float) r0;
        r13.mIU = r0;
    L_0x0177:
        r0 = r14.getY();
        r13.mIV = r0;
        r0 = r13.mIV;
        r1 = r13.getPaddingTop();
        r3 = r13.mIJ;
        r1 = r1 + r3;
        r1 = (float) r1;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 >= 0) goto L_0x01da;
    L_0x018b:
        r0 = r13.getPaddingTop();
        r1 = r13.mIJ;
        r0 = r0 + r1;
        r0 = (float) r0;
        r13.mIV = r0;
    L_0x0195:
        if (r2 == 0) goto L_0x01aa;
    L_0x0197:
        r0 = r13.mIF;
        r1 = r13.mIE;
        r0.union(r1);
        r0 = r13.mIF;
        r13.invalidate(r0);
        r0 = r13.mIF;
        r1 = r13.mIE;
        r0.set(r1);
    L_0x01aa:
        r0 = 1;
        goto L_0x000b;
    L_0x01ad:
        r0 = r13.mIU;
        r1 = r13.getPaddingLeft();
        r3 = r13.getWidth();
        r1 = r1 + r3;
        r3 = r13.getPaddingRight();
        r1 = r1 - r3;
        r3 = r13.mIJ;
        r1 = r1 - r3;
        r1 = (float) r1;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 <= 0) goto L_0x0177;
    L_0x01c5:
        r0 = r13.getPaddingLeft();
        r1 = r13.getWidth();
        r0 = r0 + r1;
        r1 = r13.getPaddingRight();
        r0 = r0 - r1;
        r1 = r13.mIJ;
        r0 = r0 - r1;
        r0 = (float) r0;
        r13.mIU = r0;
        goto L_0x0177;
    L_0x01da:
        r0 = r13.mIV;
        r1 = r13.getPaddingTop();
        r3 = r13.getHeight();
        r1 = r1 + r3;
        r3 = r13.getPaddingRight();
        r1 = r1 - r3;
        r3 = r13.mIJ;
        r1 = r1 - r3;
        r1 = (float) r1;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 <= 0) goto L_0x0195;
    L_0x01f2:
        r0 = r13.getPaddingTop();
        r1 = r13.getHeight();
        r0 = r0 + r1;
        r1 = r13.getPaddingBottom();
        r0 = r0 - r1;
        r1 = r13.mIJ;
        r0 = r0 - r1;
        r0 = (float) r0;
        r13.mIV = r0;
        goto L_0x0195;
    L_0x0207:
        r0 = r13.mIW;
        if (r0 == 0) goto L_0x021a;
    L_0x020b:
        r0 = 0;
        r13.mIW = r0;
        r13.aCS();
        r0 = r13.mJa;
        if (r0 == 0) goto L_0x021a;
    L_0x0215:
        r0 = r13.mJa;
        r0.a(r13);
    L_0x021a:
        r0 = 1;
        goto L_0x000b;
    L_0x021d:
        r1 = r3;
        r3 = r4;
        r4 = r5;
        goto L_0x0131;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gesture.ui.widget.PatternLockView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void aCR() {
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                this.mIH[i][i2] = false;
            }
        }
    }

    private float nS(int i) {
        return (((float) getPaddingLeft()) + (((float) i) * this.mIY)) + (this.mIY * 0.5f);
    }

    private float nT(int i) {
        return (((float) getPaddingTop()) + (((float) i) * this.mIZ)) + (this.mIZ * 0.5f);
    }

    private void a(b bVar, List<com.tencent.mm.plugin.gesture.a.c> list) {
        this.mIG.clear();
        aCR();
        this.mIG.addAll(list);
        Iterator it = this.mIG.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.gesture.a.c cVar = (com.tencent.mm.plugin.gesture.a.c) it.next();
            this.mIH[cVar.kTI][cVar.kTJ] = true;
        }
        a(bVar);
    }

    private void aCS() {
        this.mIG.clear();
        aCR();
        this.mIP = b.Correct;
        invalidate();
    }

    public final void aCT() {
        aCS();
        if (this.mJa != null) {
            this.mJa.a(this);
        }
    }

    public final void a(b bVar) {
        switch (bVar) {
            case Correct:
                this.lnZ = getResources().getColor(R.e.aTZ);
                break;
            case Wrong:
                this.lnZ = getResources().getColor(R.e.aUc);
                break;
            case Animate:
                if (this.mIG.size() != 0) {
                    this.mIO = false;
                    this.lnZ = getResources().getColor(R.e.aTZ);
                    com.tencent.mm.plugin.gesture.a.c cVar = (com.tencent.mm.plugin.gesture.a.c) this.mIG.get(0);
                    this.mIU = nS(cVar.kTJ);
                    this.mIV = nT(cVar.kTI);
                    aCR();
                    this.mIX = SystemClock.elapsedRealtime();
                    break;
                }
                throw new IllegalStateException("You should set a pattern before animating.");
        }
        this.mIP = bVar;
        invalidate();
    }
}
