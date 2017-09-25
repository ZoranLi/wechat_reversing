package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.design.a.d;
import android.support.design.a.f;
import android.support.design.a.i;
import android.support.v4.view.z;
import android.support.v4.widget.r;
import android.support.v7.widget.h;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import java.util.ArrayList;

public class TabLayout extends HorizontalScrollView {
    private static final android.support.v4.e.h.a<b> jS = new android.support.v4.e.h.c();
    private final ArrayList<b> jT;
    private b jU;
    private final a jV;
    private int jW;
    private int jX;
    private int jY;
    private int jZ;
    private int ka;
    private ColorStateList kb;
    private float kc;
    private float kd;
    private final int ke;
    private int kf;
    private final int kg;
    private final int kh;
    private final int ki;
    private int kj;
    private int kk;
    private u kl;
    private final android.support.v4.e.h.a<c> km;
    private int mMode;

    private class a extends LinearLayout {
        final /* synthetic */ TabLayout kn;
        int ko;
        final Paint kp;
        int kq = -1;
        float kr;
        private int ks = -1;
        private int kt = -1;
        u ku;

        a(TabLayout tabLayout, Context context) {
            this.kn = tabLayout;
            super(context);
            setWillNotDraw(false);
            this.kp = new Paint();
        }

        protected final void onMeasure(int i, int i2) {
            Object obj = null;
            super.onMeasure(i, i2);
            if (MeasureSpec.getMode(i) == 1073741824 && this.kn.mMode == 1 && this.kn.kk == 1) {
                int childCount = getChildCount();
                int i3 = 0;
                int i4 = 0;
                while (i3 < childCount) {
                    int max;
                    View childAt = getChildAt(i3);
                    if (childAt.getVisibility() == 0) {
                        max = Math.max(i4, childAt.getMeasuredWidth());
                    } else {
                        max = i4;
                    }
                    i3++;
                    i4 = max;
                }
                if (i4 > 0) {
                    if (i4 * childCount <= getMeasuredWidth() - (this.kn.y(16) * 2)) {
                        i3 = 0;
                        while (i3 < childCount) {
                            Object obj2;
                            LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                            if (layoutParams.width == i4 && layoutParams.weight == 0.0f) {
                                obj2 = obj;
                            } else {
                                layoutParams.width = i4;
                                layoutParams.weight = 0.0f;
                                obj2 = 1;
                            }
                            i3++;
                            obj = obj2;
                        }
                    } else {
                        this.kn.kk = 0;
                        this.kn.j(false);
                        obj = 1;
                    }
                    if (obj != null) {
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.ku == null || !this.ku.ll.isRunning()) {
                ap();
                return;
            }
            this.ku.ll.cancel();
            d(this.kq, Math.round(((float) this.ku.ll.getDuration()) * (1.0f - this.ku.ll.getAnimatedFraction())));
        }

        final void ap() {
            int i;
            int i2;
            View childAt = getChildAt(this.kq);
            if (childAt == null || childAt.getWidth() <= 0) {
                i = -1;
                i2 = -1;
            } else {
                i = childAt.getLeft();
                i2 = childAt.getRight();
                if (this.kr > 0.0f && this.kq < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.kq + 1);
                    i = (int) ((((float) i) * (1.0f - this.kr)) + (this.kr * ((float) childAt2.getLeft())));
                    i2 = (int) ((((float) i2) * (1.0f - this.kr)) + (((float) childAt2.getRight()) * this.kr));
                }
            }
            c(i, i2);
        }

        private void c(int i, int i2) {
            if (i != this.ks || i2 != this.kt) {
                this.ks = i;
                this.kt = i2;
                z.F(this);
            }
        }

        final void d(final int i, int i2) {
            if (this.ku != null && this.ku.ll.isRunning()) {
                this.ku.ll.cancel();
            }
            Object obj = z.J(this) == 1 ? 1 : null;
            View childAt = getChildAt(i);
            if (childAt == null) {
                ap();
                return;
            }
            int i3;
            int i4;
            final int left = childAt.getLeft();
            final int right = childAt.getRight();
            if (Math.abs(i - this.kq) <= 1) {
                i3 = this.ks;
                i4 = this.kt;
            } else {
                int a = this.kn.y(24);
                if (i < this.kq) {
                    if (obj == null) {
                        i4 = right + a;
                        i3 = i4;
                    }
                } else if (obj != null) {
                    i4 = right + a;
                    i3 = i4;
                }
                i4 = left - a;
                i3 = i4;
            }
            if (i3 != left || i4 != right) {
                u av = aa.av();
                this.ku = av;
                av.setInterpolator(a.et);
                av.setDuration(i2);
                av.e(0.0f, 1.0f);
                av.a(new c(this) {
                    final /* synthetic */ a kz;

                    public final void a(u uVar) {
                        float animatedFraction = uVar.ll.getAnimatedFraction();
                        this.kz.c(a.a(i3, left, animatedFraction), a.a(i4, right, animatedFraction));
                    }
                });
                av.ll.a(new android.support.design.widget.u.AnonymousClass2(av, new b(this) {
                    final /* synthetic */ a kz;

                    public final void aq() {
                        this.kz.kq = i;
                        this.kz.kr = 0.0f;
                    }
                }));
                av.ll.start();
            }
        }

        public final void draw(Canvas canvas) {
            super.draw(canvas);
            if (this.ks >= 0 && this.kt > this.ks) {
                canvas.drawRect((float) this.ks, (float) (getHeight() - this.ko), (float) this.kt, (float) getHeight(), this.kp);
            }
        }
    }

    public static final class b {
        Drawable jQ;
        CharSequence kB;
        int kC = -1;
        View kD;
        public TabLayout kE;
        public c kF;
        CharSequence mText;

        public final void select() {
            if (this.kE == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            this.kE.a(this);
        }

        public final void ar() {
            if (this.kF != null) {
                this.kF.update();
            }
        }
    }

    class c extends LinearLayout implements OnLongClickListener {
        private View kD;
        private b kG;
        private TextView kH;
        private ImageView kI;
        private TextView kJ;
        private ImageView kK;
        private int kL = 2;
        final /* synthetic */ TabLayout kn;

        static /* synthetic */ void a(c cVar, b bVar) {
            if (bVar != cVar.kG) {
                cVar.kG = bVar;
                cVar.update();
            }
        }

        public c(TabLayout tabLayout, Context context) {
            this.kn = tabLayout;
            super(context);
            if (tabLayout.ke != 0) {
                setBackgroundDrawable(h.ey().a(context, tabLayout.ke, false));
            }
            z.c(this, tabLayout.jW, tabLayout.jX, tabLayout.jY, tabLayout.jZ);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
        }

        public final boolean performClick() {
            boolean performClick = super.performClick();
            if (this.kG == null) {
                return performClick;
            }
            this.kG.select();
            return true;
        }

        public final void setSelected(boolean z) {
            Object obj = isSelected() != z ? 1 : null;
            super.setSelected(z);
            if (obj != null && z) {
                sendAccessibilityEvent(4);
                if (this.kH != null) {
                    this.kH.setSelected(z);
                }
                if (this.kI != null) {
                    this.kI.setSelected(z);
                }
            }
        }

        @TargetApi(14)
        public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(android.support.v7.app.ActionBar.a.class.getName());
        }

        @TargetApi(14)
        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(android.support.v7.app.ActionBar.a.class.getName());
        }

        public final void onMeasure(int i, int i2) {
            int i3 = 1;
            int size = MeasureSpec.getSize(i);
            int mode = MeasureSpec.getMode(i);
            int f = this.kn.kf;
            if (f > 0 && (mode == 0 || size > f)) {
                i = MeasureSpec.makeMeasureSpec(this.kn.kf, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.kH != null) {
                getResources();
                float h = this.kn.kc;
                size = this.kL;
                if (this.kI != null && this.kI.getVisibility() == 0) {
                    size = 1;
                } else if (this.kH != null && this.kH.getLineCount() > 1) {
                    h = this.kn.kd;
                }
                float textSize = this.kH.getTextSize();
                int lineCount = this.kH.getLineCount();
                int c = r.c(this.kH);
                if (h != textSize || (c >= 0 && size != c)) {
                    if (this.kn.mMode == 1 && h > textSize && lineCount == 1) {
                        Layout layout = this.kH.getLayout();
                        if (layout == null || layout.getLineWidth(0) * (h / layout.getPaint().getTextSize()) > ((float) layout.getWidth())) {
                            i3 = 0;
                        }
                    }
                    if (i3 != 0) {
                        this.kH.setTextSize(0, h);
                        this.kH.setMaxLines(size);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        final void update() {
            b bVar = this.kG;
            View view = bVar != null ? bVar.kD : null;
            if (view != null) {
                c parent = view.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(view);
                    }
                    addView(view);
                }
                this.kD = view;
                if (this.kH != null) {
                    this.kH.setVisibility(8);
                }
                if (this.kI != null) {
                    this.kI.setVisibility(8);
                    this.kI.setImageDrawable(null);
                }
                this.kJ = (TextView) view.findViewById(16908308);
                if (this.kJ != null) {
                    this.kL = r.c(this.kJ);
                }
                this.kK = (ImageView) view.findViewById(16908294);
            } else {
                if (this.kD != null) {
                    removeView(this.kD);
                    this.kD = null;
                }
                this.kJ = null;
                this.kK = null;
            }
            if (this.kD == null) {
                if (this.kI == null) {
                    ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(f.az, this, false);
                    addView(imageView, 0);
                    this.kI = imageView;
                }
                if (this.kH == null) {
                    TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(f.aA, this, false);
                    addView(textView);
                    this.kH = textView;
                    this.kL = r.c(this.kH);
                }
                this.kH.setTextAppearance(getContext(), this.kn.ka);
                if (this.kn.kb != null) {
                    this.kH.setTextColor(this.kn.kb);
                }
                a(this.kH, this.kI);
            } else if (this.kJ != null || this.kK != null) {
                a(this.kJ, this.kK);
            }
        }

        private void a(TextView textView, ImageView imageView) {
            CharSequence charSequence;
            CharSequence charSequence2;
            boolean z;
            Drawable drawable = this.kG != null ? this.kG.jQ : null;
            if (this.kG != null) {
                charSequence = this.kG.mText;
            } else {
                charSequence = null;
            }
            if (this.kG != null) {
                charSequence2 = this.kG.kB;
            } else {
                charSequence2 = null;
            }
            if (imageView != null) {
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
                imageView.setContentDescription(charSequence2);
            }
            if (TextUtils.isEmpty(charSequence)) {
                z = false;
            } else {
                z = true;
            }
            if (textView != null) {
                if (z) {
                    textView.setText(charSequence);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText(null);
                }
                textView.setContentDescription(charSequence2);
            }
            if (imageView != null) {
                int a;
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) imageView.getLayoutParams();
                if (z && imageView.getVisibility() == 0) {
                    a = this.kn.y(8);
                } else {
                    a = 0;
                }
                if (a != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = a;
                    imageView.requestLayout();
                }
            }
            if (z || TextUtils.isEmpty(charSequence2)) {
                setOnLongClickListener(null);
                setLongClickable(false);
                return;
            }
            setOnLongClickListener(this);
        }

        public final boolean onLongClick(View view) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            Context context = getContext();
            int width = getWidth();
            int height = getHeight();
            int i = context.getResources().getDisplayMetrics().widthPixels;
            Toast makeText = Toast.makeText(context, this.kG.kB, 0);
            makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
            makeText.show();
            return true;
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jT = new ArrayList();
        this.kf = Integer.MAX_VALUE;
        this.km = new android.support.v4.e.h.b(12);
        t.g(context);
        setHorizontalScrollBarEnabled(false);
        this.jV = new a(this, context);
        super.addView(this.jV, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.cS, i, android.support.design.a.h.aT);
        View view = this.jV;
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(i.cX, 0);
        if (view.ko != dimensionPixelSize) {
            view.ko = dimensionPixelSize;
            z.F(view);
        }
        view = this.jV;
        dimensionPixelSize = obtainStyledAttributes.getColor(i.cW, 0);
        if (view.kp.getColor() != dimensionPixelSize) {
            view.kp.setColor(dimensionPixelSize);
            z.F(view);
        }
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(i.db, 0);
        this.jZ = dimensionPixelSize2;
        this.jY = dimensionPixelSize2;
        this.jX = dimensionPixelSize2;
        this.jW = dimensionPixelSize2;
        this.jW = obtainStyledAttributes.getDimensionPixelSize(i.de, this.jW);
        this.jX = obtainStyledAttributes.getDimensionPixelSize(i.dg, this.jX);
        this.jY = obtainStyledAttributes.getDimensionPixelSize(i.dd, this.jY);
        this.jZ = obtainStyledAttributes.getDimensionPixelSize(i.dc, this.jZ);
        this.ka = obtainStyledAttributes.getResourceId(i.di, android.support.design.a.h.aL);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(this.ka, i.dk);
        try {
            this.kc = (float) obtainStyledAttributes2.getDimensionPixelSize(i.dq, 0);
            this.kb = obtainStyledAttributes2.getColorStateList(i.dp);
            if (obtainStyledAttributes.hasValue(i.dj)) {
                this.kb = obtainStyledAttributes.getColorStateList(i.dj);
            }
            if (obtainStyledAttributes.hasValue(i.dh)) {
                dimensionPixelSize2 = obtainStyledAttributes.getColor(i.dh, 0);
                dimensionPixelSize = this.kb.getDefaultColor();
                r4 = new int[2][];
                int[] iArr = new int[]{SELECTED_STATE_SET, dimensionPixelSize2};
                r4[1] = EMPTY_STATE_SET;
                iArr[1] = dimensionPixelSize;
                this.kb = new ColorStateList(r4, iArr);
            }
            this.kg = obtainStyledAttributes.getDimensionPixelSize(i.cZ, -1);
            this.kh = obtainStyledAttributes.getDimensionPixelSize(i.cY, -1);
            this.ke = obtainStyledAttributes.getResourceId(i.cT, 0);
            this.kj = obtainStyledAttributes.getDimensionPixelSize(i.cU, 0);
            this.mMode = obtainStyledAttributes.getInt(i.da, 1);
            this.kk = obtainStyledAttributes.getInt(i.cV, 0);
            obtainStyledAttributes.recycle();
            Resources resources = getResources();
            this.kd = (float) resources.getDimensionPixelSize(d.ap);
            this.ki = resources.getDimensionPixelSize(d.ao);
            z.c(this.jV, this.mMode == 0 ? Math.max(0, this.kj - this.jW) : 0, 0, 0, 0);
            switch (this.mMode) {
                case 0:
                    this.jV.setGravity(8388611);
                    break;
                case 1:
                    this.jV.setGravity(1);
                    break;
            }
            j(true);
        } finally {
            obtainStyledAttributes2.recycle();
        }
    }

    private void x(int i) {
        int round = Math.round(((float) i) + 0.0f);
        if (round >= 0 && round < this.jV.getChildCount()) {
            a aVar = this.jV;
            if (aVar.ku != null && aVar.ku.ll.isRunning()) {
                aVar.ku.ll.cancel();
            }
            aVar.kq = i;
            aVar.kr = 0.0f;
            aVar.ap();
            if (this.kl != null && this.kl.ll.isRunning()) {
                this.kl.ll.cancel();
            }
            scrollTo(a(i, 0.0f), 0);
            A(round);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return Math.max(0, ((this.jV.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight()) > 0;
    }

    private void a(b bVar, int i) {
        bVar.kC = i;
        this.jT.add(i, bVar);
        int size = this.jT.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            ((b) this.jT.get(i2)).kC = i2;
        }
    }

    public void addView(View view) {
        t(view);
    }

    public void addView(View view, int i) {
        t(view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        t(view);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        t(view);
    }

    private void t(View view) {
        if (view instanceof TabItem) {
            b bVar;
            TabItem tabItem = (TabItem) view;
            b bVar2 = (b) jS.bF();
            if (bVar2 == null) {
                bVar = new b();
            } else {
                bVar = bVar2;
            }
            bVar.kE = this;
            c cVar = this.km != null ? (c) this.km.bF() : null;
            if (cVar == null) {
                cVar = new c(this, getContext());
            }
            c.a(cVar, bVar);
            cVar.setFocusable(true);
            cVar.setMinimumWidth(ao());
            bVar.kF = cVar;
            if (tabItem.mText != null) {
                bVar.mText = tabItem.mText;
                bVar.ar();
            }
            if (tabItem.jQ != null) {
                bVar.jQ = tabItem.jQ;
                bVar.ar();
            }
            if (tabItem.jR != 0) {
                bVar.kD = LayoutInflater.from(bVar.kF.getContext()).inflate(tabItem.jR, bVar.kF, false);
                bVar.ar();
            }
            boolean isEmpty = this.jT.isEmpty();
            if (bVar.kE != this) {
                throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
            }
            View view2 = bVar.kF;
            a aVar = this.jV;
            LayoutParams layoutParams = new LayoutParams(-2, -1);
            a(layoutParams);
            aVar.addView(view2, layoutParams);
            if (isEmpty) {
                view2.setSelected(true);
            }
            a(bVar, this.jT.size());
            if (isEmpty) {
                bVar.select();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void a(LayoutParams layoutParams) {
        if (this.mMode == 1 && this.kk == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    private int y(int i) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i));
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4 = 1;
        int size = this.jT.size();
        for (int i5 = 0; i5 < size; i5++) {
            b bVar = (b) this.jT.get(i5);
            if (bVar != null && bVar.jQ != null && !TextUtils.isEmpty(bVar.mText)) {
                i3 = 1;
                break;
            }
        }
        i3 = 0;
        i3 = (y(i3 != 0 ? 72 : 48) + getPaddingTop()) + getPaddingBottom();
        switch (MeasureSpec.getMode(i2)) {
            case Integer.MIN_VALUE:
                i2 = MeasureSpec.makeMeasureSpec(Math.min(i3, MeasureSpec.getSize(i2)), 1073741824);
                break;
            case 0:
                i2 = MeasureSpec.makeMeasureSpec(i3, 1073741824);
                break;
        }
        i3 = MeasureSpec.getSize(i);
        if (MeasureSpec.getMode(i) != 0) {
            if (this.kh > 0) {
                i3 = this.kh;
            } else {
                i3 -= y(56);
            }
            this.kf = i3;
        }
        super.onMeasure(i, i2);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            switch (this.mMode) {
                case 0:
                    if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                        i3 = 0;
                        break;
                    } else {
                        i3 = 1;
                        break;
                    }
                case 1:
                    if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                        i4 = 0;
                    }
                    i3 = i4;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            if (i3 != 0) {
                childAt.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    private void z(int i) {
        Object obj = null;
        if (i != -1) {
            if (getWindowToken() != null && z.aj(this)) {
                int i2;
                a aVar = this.jV;
                int childCount = aVar.getChildCount();
                for (i2 = 0; i2 < childCount; i2++) {
                    if (aVar.getChildAt(i2).getWidth() <= 0) {
                        obj = 1;
                        break;
                    }
                }
                if (obj == null) {
                    int scrollX = getScrollX();
                    i2 = a(i, 0.0f);
                    if (scrollX != i2) {
                        if (this.kl == null) {
                            this.kl = aa.av();
                            this.kl.setInterpolator(a.et);
                            this.kl.setDuration(e.CTRL_INDEX);
                            this.kl.a(new c(this) {
                                final /* synthetic */ TabLayout kn;

                                {
                                    this.kn = r1;
                                }

                                public final void a(u uVar) {
                                    this.kn.scrollTo(uVar.ll.aw(), 0);
                                }
                            });
                        }
                        this.kl.e(scrollX, i2);
                        this.kl.ll.start();
                    }
                    this.jV.d(i, e.CTRL_INDEX);
                    return;
                }
            }
            x(i);
        }
    }

    private void A(int i) {
        int childCount = this.jV.getChildCount();
        if (i < childCount && !this.jV.getChildAt(i).isSelected()) {
            for (int i2 = 0; i2 < childCount; i2++) {
                boolean z;
                View childAt = this.jV.getChildAt(i2);
                if (i2 == i) {
                    z = true;
                } else {
                    z = false;
                }
                childAt.setSelected(z);
            }
        }
    }

    final void a(b bVar) {
        if (this.jU != bVar) {
            int i = bVar != null ? bVar.kC : -1;
            if (i != -1) {
                A(i);
            }
            if ((this.jU == null || this.jU.kC == -1) && i != -1) {
                x(i);
            } else {
                z(i);
            }
            this.jU = bVar;
        } else if (this.jU != null) {
            z(bVar.kC);
        }
    }

    private int a(int i, float f) {
        int i2 = 0;
        if (this.mMode != 0) {
            return 0;
        }
        int width;
        View childAt = this.jV.getChildAt(i);
        View childAt2 = i + 1 < this.jV.getChildCount() ? this.jV.getChildAt(i + 1) : null;
        if (childAt != null) {
            width = childAt.getWidth();
        } else {
            width = 0;
        }
        if (childAt2 != null) {
            i2 = childAt2.getWidth();
        }
        return ((((int) ((((float) (i2 + width)) * 0.0f) * 0.5f)) + childAt.getLeft()) + (childAt.getWidth() / 2)) - (getWidth() / 2);
    }

    private void j(boolean z) {
        for (int i = 0; i < this.jV.getChildCount(); i++) {
            View childAt = this.jV.getChildAt(i);
            childAt.setMinimumWidth(ao());
            a((LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    private int ao() {
        if (this.kg != -1) {
            return this.kg;
        }
        return this.mMode == 0 ? this.ki : 0;
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }
}
