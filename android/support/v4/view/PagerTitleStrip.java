package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager.e;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.lang.ref.WeakReference;

public class PagerTitleStrip extends ViewGroup implements a {
    private static final int[] xQ = new int[]{16842804, 16842901, 16842904, 16842927};
    private static final int[] xR = new int[]{16843660};
    private static final b xU;
    private int tW;
    ViewPager xF;
    TextView xG;
    TextView xH;
    TextView xI;
    private int xJ = -1;
    private float xK = -1.0f;
    int xL;
    private boolean xM;
    private boolean xN;
    private final a xO = new a();
    private WeakReference<u> xP;
    private int xS;
    int xT;

    interface b {
        void b(TextView textView);
    }

    private class a extends DataSetObserver implements d, e {
        private int xV;
        final /* synthetic */ PagerTitleStrip xW;

        private a(PagerTitleStrip pagerTitleStrip) {
            this.xW = pagerTitleStrip;
        }

        public final void a(int i, float f, int i2) {
            if (f > 0.5f) {
                i++;
            }
            this.xW.a(i, f, false);
        }

        public final void V(int i) {
            float f = 0.0f;
            if (this.xV == 0) {
                this.xW.a(this.xW.xF.ys, this.xW.xF.yr);
                if (this.xW.xK >= 0.0f) {
                    f = this.xW.xK;
                }
                this.xW.a(this.xW.xF.ys, f, true);
            }
        }

        public final void W(int i) {
            this.xV = i;
        }

        public final void b(u uVar, u uVar2) {
            this.xW.a(uVar, uVar2);
        }

        public final void onChanged() {
            float f = 0.0f;
            this.xW.a(this.xW.xF.ys, this.xW.xF.yr);
            if (this.xW.xK >= 0.0f) {
                f = this.xW.xK;
            }
            this.xW.a(this.xW.xF.ys, f, true);
        }
    }

    static class c implements b {
        c() {
        }

        public final void b(TextView textView) {
            textView.setSingleLine();
        }
    }

    static class d implements b {
        d() {
        }

        public final void b(TextView textView) {
            textView.setTransformationMethod(new a(textView.getContext()));
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            xU = new d();
        } else {
            xU = new c();
        }
    }

    private static void b(TextView textView) {
        xU.b(textView);
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        boolean z = false;
        super(context, attributeSet);
        View textView = new TextView(context);
        this.xG = textView;
        addView(textView);
        textView = new TextView(context);
        this.xH = textView;
        addView(textView);
        textView = new TextView(context);
        this.xI = textView;
        addView(textView);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, xQ);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            this.xG.setTextAppearance(context, resourceId);
            this.xH.setTextAppearance(context, resourceId);
            this.xI.setTextAppearance(context, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            float f = (float) dimensionPixelSize;
            this.xG.setTextSize(0, f);
            this.xH.setTextSize(0, f);
            this.xI.setTextSize(0, f);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            dimensionPixelSize = obtainStyledAttributes.getColor(2, 0);
            this.xG.setTextColor(dimensionPixelSize);
            this.xH.setTextColor(dimensionPixelSize);
            this.xI.setTextColor(dimensionPixelSize);
        }
        this.tW = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.xT = this.xH.getTextColors().getDefaultColor();
        this.xS = 153;
        int i = (this.xS << 24) | (this.xT & 16777215);
        this.xG.setTextColor(i);
        this.xI.setTextColor(i);
        this.xG.setEllipsize(TruncateAt.END);
        this.xH.setEllipsize(TruncateAt.END);
        this.xI.setEllipsize(TruncateAt.END);
        if (resourceId != 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(resourceId, xR);
            z = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        if (z) {
            b(this.xG);
            b(this.xH);
            b(this.xI);
        } else {
            this.xG.setSingleLine();
            this.xH.setSingleLine();
            this.xI.setSingleLine();
        }
        this.xL = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    public void U(int i) {
        this.xL = i;
        requestLayout();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            u uVar = viewPager.yr;
            viewPager.a(this.xO);
            viewPager.zd = this.xO;
            this.xF = viewPager;
            a(this.xP != null ? (u) this.xP.get() : null, uVar);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.xF != null) {
            a(this.xF.yr, null);
            this.xF.a(null);
            this.xF.zd = null;
            this.xF = null;
        }
    }

    final void a(int i, u uVar) {
        CharSequence charSequence;
        CharSequence charSequence2 = null;
        int count = uVar != null ? uVar.getCount() : 0;
        this.xM = true;
        if (i <= 0 || uVar == null) {
            charSequence = null;
        } else {
            charSequence = uVar.bK();
        }
        this.xG.setText(charSequence);
        TextView textView = this.xH;
        if (uVar == null || i >= count) {
            charSequence = null;
        } else {
            charSequence = uVar.bK();
        }
        textView.setText(charSequence);
        if (i + 1 < count && uVar != null) {
            charSequence2 = uVar.bK();
        }
        this.xI.setText(charSequence2);
        count = MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.xG.measure(count, makeMeasureSpec);
        this.xH.measure(count, makeMeasureSpec);
        this.xI.measure(count, makeMeasureSpec);
        this.xJ = i;
        if (!this.xN) {
            a(i, this.xK, false);
        }
        this.xM = false;
    }

    public void requestLayout() {
        if (!this.xM) {
            super.requestLayout();
        }
    }

    final void a(u uVar, u uVar2) {
        if (uVar != null) {
            uVar.unregisterDataSetObserver(this.xO);
            this.xP = null;
        }
        if (uVar2 != null) {
            uVar2.registerDataSetObserver(this.xO);
            this.xP = new WeakReference(uVar2);
        }
        if (this.xF != null) {
            this.xJ = -1;
            this.xK = -1.0f;
            a(this.xF.ys, uVar2);
            requestLayout();
        }
    }

    void a(int i, float f, boolean z) {
        if (i != this.xJ) {
            a(i, this.xF.yr);
        } else if (!z && f == this.xK) {
            return;
        }
        this.xN = true;
        int measuredWidth = this.xG.getMeasuredWidth();
        int measuredWidth2 = this.xH.getMeasuredWidth();
        int measuredWidth3 = this.xI.getMeasuredWidth();
        int i2 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i3 = paddingRight + i2;
        int i4 = (width - (paddingLeft + i2)) - i3;
        float f2 = 0.5f + f;
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        }
        i3 = ((width - i3) - ((int) (f2 * ((float) i4)))) - i2;
        i4 = i3 + measuredWidth2;
        int baseline = this.xG.getBaseline();
        measuredWidth2 = this.xH.getBaseline();
        i2 = this.xI.getBaseline();
        int max = Math.max(Math.max(baseline, measuredWidth2), i2);
        baseline = max - baseline;
        measuredWidth2 = max - measuredWidth2;
        max -= i2;
        int measuredHeight = this.xI.getMeasuredHeight() + max;
        i2 = Math.max(Math.max(this.xG.getMeasuredHeight() + baseline, this.xH.getMeasuredHeight() + measuredWidth2), measuredHeight);
        switch (this.tW & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
            case 16:
                height = (((height - paddingTop) - paddingBottom) - i2) / 2;
                i2 = height + baseline;
                baseline = height + measuredWidth2;
                measuredWidth2 = height + max;
                break;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                height = (height - paddingBottom) - i2;
                i2 = height + baseline;
                baseline = height + measuredWidth2;
                measuredWidth2 = height + max;
                break;
            default:
                i2 = paddingTop + baseline;
                baseline = paddingTop + measuredWidth2;
                measuredWidth2 = paddingTop + max;
                break;
        }
        this.xH.layout(i3, baseline, i4, this.xH.getMeasuredHeight() + baseline);
        baseline = Math.min(paddingLeft, (i3 - this.xL) - measuredWidth);
        this.xG.layout(baseline, i2, measuredWidth + baseline, this.xG.getMeasuredHeight() + i2);
        baseline = Math.max((width - paddingRight) - measuredWidth3, this.xL + i4);
        this.xI.layout(baseline, measuredWidth2, baseline + measuredWidth3, this.xI.getMeasuredHeight() + measuredWidth2);
        this.xK = f;
        this.xN = false;
    }

    protected void onMeasure(int i, int i2) {
        if (MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int size = MeasureSpec.getSize(i);
        int childMeasureSpec2 = getChildMeasureSpec(i, (int) (((float) size) * 0.2f), -2);
        this.xG.measure(childMeasureSpec2, childMeasureSpec);
        this.xH.measure(childMeasureSpec2, childMeasureSpec);
        this.xI.measure(childMeasureSpec2, childMeasureSpec);
        if (MeasureSpec.getMode(i2) == 1073741824) {
            paddingTop = MeasureSpec.getSize(i2);
        } else {
            paddingTop = Math.max(getMinHeight(), paddingTop + this.xH.getMeasuredHeight());
        }
        setMeasuredDimension(size, z.resolveSizeAndState(paddingTop, i2, z.N(this.xH) << 16));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f = 0.0f;
        if (this.xF != null) {
            if (this.xK >= 0.0f) {
                f = this.xK;
            }
            a(this.xJ, f, true);
        }
    }

    int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }
}
