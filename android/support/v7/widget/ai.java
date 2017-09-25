package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.a.a.d;
import android.support.v7.a.a.k;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public final class ai extends HorizontalScrollView implements OnItemSelectedListener {
    private static final Interpolator abS = new DecelerateInterpolator();
    private int RA;
    Runnable abL;
    private LinearLayoutCompat abM;
    private Spinner abN;
    boolean abO;
    int abP;
    int abQ;
    private int abR;

    private class a extends BaseAdapter {
        final /* synthetic */ ai abU;

        private a(ai aiVar) {
            this.abU = aiVar;
        }

        public final int getCount() {
            return this.abU.abM.getChildCount();
        }

        public final Object getItem(int i) {
            return ((b) this.abU.abM.getChildAt(i)).abW;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ai.a(this.abU, (android.support.v7.app.ActionBar.a) getItem(i));
            }
            b bVar = (b) view;
            bVar.abW = (android.support.v7.app.ActionBar.a) getItem(i);
            bVar.update();
            return view;
        }
    }

    private class b extends LinearLayoutCompat implements OnLongClickListener {
        final /* synthetic */ ai abU;
        private final int[] abV = new int[]{16842964};
        android.support.v7.app.ActionBar.a abW;
        private View kD;
        private TextView kH;
        private ImageView kI;

        public b(ai aiVar, Context context, android.support.v7.app.ActionBar.a aVar, boolean z) {
            this.abU = aiVar;
            super(context, null, android.support.v7.a.a.a.actionBarTabStyle);
            this.abW = aVar;
            ap a = ap.a(context, null, this.abV, android.support.v7.a.a.a.actionBarTabStyle);
            if (a.hasValue(0)) {
                setBackgroundDrawable(a.getDrawable(0));
            }
            a.aeG.recycle();
            setGravity(8388627);
            update();
        }

        public final void setSelected(boolean z) {
            Object obj = isSelected() != z ? 1 : null;
            super.setSelected(z);
            if (obj != null && z) {
                sendAccessibilityEvent(4);
            }
        }

        public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(android.support.v7.app.ActionBar.a.class.getName());
        }

        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            if (VERSION.SDK_INT >= 14) {
                accessibilityNodeInfo.setClassName(android.support.v7.app.ActionBar.a.class.getName());
            }
        }

        public final void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.abU.abP > 0 && getMeasuredWidth() > this.abU.abP) {
                super.onMeasure(MeasureSpec.makeMeasureSpec(this.abU.abP, 1073741824), i2);
            }
        }

        public final void update() {
            android.support.v7.app.ActionBar.a aVar = this.abW;
            View customView = aVar.getCustomView();
            if (customView != null) {
                b parent = customView.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(customView);
                    }
                    addView(customView);
                }
                this.kD = customView;
                if (this.kH != null) {
                    this.kH.setVisibility(8);
                }
                if (this.kI != null) {
                    this.kI.setVisibility(8);
                    this.kI.setImageDrawable(null);
                    return;
                }
                return;
            }
            boolean z;
            if (this.kD != null) {
                removeView(this.kD);
                this.kD = null;
            }
            Drawable icon = aVar.getIcon();
            CharSequence text = aVar.getText();
            if (icon != null) {
                if (this.kI == null) {
                    View imageView = new ImageView(getContext());
                    LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    imageView.setLayoutParams(layoutParams);
                    addView(imageView, 0);
                    this.kI = imageView;
                }
                this.kI.setImageDrawable(icon);
                this.kI.setVisibility(0);
            } else if (this.kI != null) {
                this.kI.setVisibility(8);
                this.kI.setImageDrawable(null);
            }
            if (TextUtils.isEmpty(text)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                if (this.kH == null) {
                    imageView = new AppCompatTextView(getContext(), null, android.support.v7.a.a.a.actionBarTabTextStyle);
                    imageView.setEllipsize(TruncateAt.END);
                    layoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    imageView.setLayoutParams(layoutParams);
                    addView(imageView);
                    this.kH = imageView;
                }
                this.kH.setText(text);
                this.kH.setVisibility(0);
            } else if (this.kH != null) {
                this.kH.setVisibility(8);
                this.kH.setText(null);
            }
            if (this.kI != null) {
                this.kI.setContentDescription(aVar.getContentDescription());
            }
            if (z || TextUtils.isEmpty(aVar.getContentDescription())) {
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
            Toast makeText = Toast.makeText(context, this.abW.getContentDescription(), 0);
            makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
            makeText.show();
            return true;
        }
    }

    static /* synthetic */ b a(ai aiVar, android.support.v7.app.ActionBar.a aVar) {
        b bVar = new b(aiVar, aiVar.getContext(), aVar, true);
        bVar.setBackgroundDrawable(null);
        bVar.setLayoutParams(new AbsListView.LayoutParams(-1, aiVar.RA));
        return bVar;
    }

    public final void onMeasure(int i, int i2) {
        byte b = (byte) 1;
        int mode = MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.abM.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.abP = -1;
        } else {
            if (childCount > 2) {
                this.abP = (int) (((float) MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.abP = MeasureSpec.getSize(i) / 2;
            }
            this.abP = Math.min(this.abP, this.abQ);
        }
        mode = MeasureSpec.makeMeasureSpec(this.RA, 1073741824);
        if (z || !this.abO) {
            b = (byte) 0;
        }
        if (b != (byte) 0) {
            this.abM.measure(0, mode);
            if (this.abM.getMeasuredWidth() <= MeasureSpec.getSize(i)) {
                gu();
            } else if (!gt()) {
                if (this.abN == null) {
                    Spinner appCompatSpinner = new AppCompatSpinner(getContext(), null, android.support.v7.a.a.a.actionDropDownStyle);
                    appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
                    appCompatSpinner.setOnItemSelectedListener(this);
                    this.abN = appCompatSpinner;
                }
                removeView(this.abM);
                addView(this.abN, new LayoutParams(-2, -1));
                if (this.abN.getAdapter() == null) {
                    this.abN.setAdapter(new a());
                }
                if (this.abL != null) {
                    removeCallbacks(this.abL);
                    this.abL = null;
                }
                this.abN.setSelection(this.abR);
            }
        } else {
            gu();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, mode);
        int measuredWidth2 = getMeasuredWidth();
        if (z && measuredWidth != measuredWidth2) {
            bp(this.abR);
        }
    }

    private boolean gt() {
        return this.abN != null && this.abN.getParent() == this;
    }

    private boolean gu() {
        if (gt()) {
            removeView(this.abN);
            addView(this.abM, new LayoutParams(-2, -1));
            bp(this.abN.getSelectedItemPosition());
        }
        return false;
    }

    private void bp(int i) {
        this.abR = i;
        int childCount = this.abM.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            boolean z;
            View childAt = this.abM.getChildAt(i2);
            if (i2 == i) {
                z = true;
            } else {
                z = false;
            }
            childAt.setSelected(z);
            if (z) {
                final View childAt2 = this.abM.getChildAt(i);
                if (this.abL != null) {
                    removeCallbacks(this.abL);
                }
                this.abL = new Runnable(this) {
                    final /* synthetic */ ai abU;

                    public final void run() {
                        this.abU.smoothScrollTo(childAt2.getLeft() - ((this.abU.getWidth() - childAt2.getWidth()) / 2), 0);
                        this.abU.abL = null;
                    }
                };
                post(this.abL);
            }
        }
        if (this.abN != null && i >= 0) {
            this.abN.setSelection(i);
        }
    }

    protected final void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        android.support.v7.view.a n = android.support.v7.view.a.n(getContext());
        TypedArray obtainStyledAttributes = n.mContext.obtainStyledAttributes(null, k.aV, android.support.v7.a.a.a.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(k.Lg, 0);
        Resources resources = n.mContext.getResources();
        if (!n.de()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(d.IQ));
        }
        obtainStyledAttributes.recycle();
        this.RA = layoutDimension;
        requestLayout();
        this.abQ = n.mContext.getResources().getDimensionPixelSize(d.IR);
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.abL != null) {
            post(this.abL);
        }
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.abL != null) {
            removeCallbacks(this.abL);
        }
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
    }
}
