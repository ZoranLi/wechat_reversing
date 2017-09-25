package com.tencent.mm.ui.base;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.z;
import android.support.v4.widget.i;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HorizontalListViewV2 extends AdapterView<ListAdapter> {
    protected ListAdapter FA;
    private Drawable Xj = null;
    private int Xk = 0;
    private Rect fv = new Rect();
    private GestureDetector iXs;
    private OnClickListener mOnClickListener;
    protected int vgT;
    protected int vgU;
    private int vgV = Integer.MAX_VALUE;
    private int vgW;
    private boolean vhb = false;
    protected Scroller vhf = new Scroller(getContext());
    private final a vhg = new a();
    private List<Queue<View>> vhh = new ArrayList();
    private View vhi = null;
    private Integer vhj = null;
    private int vhk;
    private int vhl;
    private int vhm;
    private e vhn = null;
    private int vho = 0;
    private boolean vhp = false;
    public d vhq = null;
    private int vhr = a.vhA;
    private i vhs;
    private i vht;
    private int vhu;
    private boolean vhv = false;
    private boolean vhw = false;
    private DataSetObserver vhx = new DataSetObserver(this) {
        final /* synthetic */ HorizontalListViewV2 vhz;

        {
            this.vhz = r1;
        }

        public final void onChanged() {
            this.vhz.vhb = true;
            this.vhz.vhp = false;
            this.vhz.bRH();
            this.vhz.invalidate();
            this.vhz.requestLayout();
        }

        public final void onInvalidated() {
            this.vhz.vhp = false;
            this.vhz.bRH();
            this.vhz.reset();
            this.vhz.invalidate();
            this.vhz.requestLayout();
        }
    };
    private Runnable vhy = new Runnable(this) {
        final /* synthetic */ HorizontalListViewV2 vhz;

        {
            this.vhz = r1;
        }

        public final void run() {
            this.vhz.requestLayout();
        }
    };

    private class a extends SimpleOnGestureListener {
        final /* synthetic */ HorizontalListViewV2 vhz;

        private a(HorizontalListViewV2 horizontalListViewV2) {
            this.vhz = horizontalListViewV2;
        }

        public final boolean onDown(MotionEvent motionEvent) {
            return this.vhz.onDown(motionEvent);
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return this.vhz.as(f);
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            this.vhz.g(Boolean.valueOf(true));
            this.vhz.zP(a.vhB);
            this.vhz.bRH();
            HorizontalListViewV2 horizontalListViewV2 = this.vhz;
            horizontalListViewV2.vgU += (int) f;
            HorizontalListViewV2.b(this.vhz, Math.round(f));
            this.vhz.requestLayout();
            return true;
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            this.vhz.bRH();
            OnItemClickListener onItemClickListener = this.vhz.getOnItemClickListener();
            int a = this.vhz.dV((int) motionEvent.getX(), (int) motionEvent.getY());
            if (a >= 0 && !this.vhz.vhv) {
                View childAt = this.vhz.getChildAt(a);
                int g = this.vhz.vhk + a;
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(this.vhz, childAt, g, this.vhz.FA.getItemId(g));
                    return true;
                }
            }
            if (!(this.vhz.mOnClickListener == null || this.vhz.vhv)) {
                this.vhz.mOnClickListener.onClick(this.vhz);
            }
            return false;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            this.vhz.bRH();
            int a = this.vhz.dV((int) motionEvent.getX(), (int) motionEvent.getY());
            if (a >= 0 && !this.vhz.vhv) {
                View childAt = this.vhz.getChildAt(a);
                OnItemLongClickListener onItemLongClickListener = this.vhz.getOnItemLongClickListener();
                if (onItemLongClickListener != null) {
                    int g = this.vhz.vhk + a;
                    if (onItemLongClickListener.onItemLongClick(this.vhz, childAt, g, this.vhz.FA.getItemId(g))) {
                        this.vhz.performHapticFeedback(0);
                    }
                }
            }
        }
    }

    @TargetApi(11)
    private static final class b {
        static {
            if (VERSION.SDK_INT < 11) {
                throw new RuntimeException("sdk is >= 11!");
            }
        }

        public static void a(Scroller scroller) {
            if (scroller != null) {
                scroller.setFriction(0.009f);
            }
        }
    }

    @TargetApi(14)
    private static final class c {
        static {
            if (VERSION.SDK_INT < 14) {
                throw new RuntimeException("sdk is >= 14!");
            }
        }

        public static float b(Scroller scroller) {
            return scroller.getCurrVelocity();
        }
    }

    public interface d {

        public enum a {
            ;

            static {
                vhA = 1;
                vhB = 2;
                vhC = 3;
                vhD = new int[]{vhA, vhB, vhC};
            }
        }

        void oL(int i);
    }

    public interface e {
    }

    static /* synthetic */ void b(HorizontalListViewV2 horizontalListViewV2, int i) {
        if (horizontalListViewV2.vhs != null && horizontalListViewV2.vht != null) {
            int i2 = horizontalListViewV2.vgT + i;
            if (horizontalListViewV2.vhf != null && !horizontalListViewV2.vhf.isFinished()) {
                return;
            }
            if (i2 < 0) {
                horizontalListViewV2.vhs.u(((float) Math.abs(i)) / ((float) horizontalListViewV2.bRG()));
                if (!horizontalListViewV2.vht.isFinished()) {
                    horizontalListViewV2.vht.cr();
                }
            } else if (i2 > horizontalListViewV2.vgV) {
                horizontalListViewV2.vht.u(((float) Math.abs(i)) / ((float) horizontalListViewV2.bRG()));
                if (!horizontalListViewV2.vhs.isFinished()) {
                    horizontalListViewV2.vhs.cr();
                }
            }
        }
    }

    public /* bridge */ /* synthetic */ Adapter getAdapter() {
        return this.FA;
    }

    public HorizontalListViewV2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.vhs = new i(context);
        this.vht = new i(context);
        this.iXs = new GestureDetector(context, this.vhg);
        setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ HorizontalListViewV2 vhz;

            {
                this.vhz = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.vhz.iXs.onTouchEvent(motionEvent);
            }
        });
        KC();
        setWillNotDraw(false);
        if (VERSION.SDK_INT >= 11) {
            b.a(this.vhf);
        }
    }

    private void g(Boolean bool) {
        if (this.vhw != bool.booleanValue()) {
            View view = this;
            while (view.getParent() instanceof View) {
                if ((view.getParent() instanceof ListView) || (view.getParent() instanceof ScrollView)) {
                    view.getParent().requestDisallowInterceptTouchEvent(bool.booleanValue());
                    this.vhw = bool.booleanValue();
                    return;
                }
                view = (View) view.getParent();
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
        bundle.putInt("BUNDLE_ID_CURRENT_X", this.vgT);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.vhj = Integer.valueOf(bundle.getInt("BUNDLE_ID_CURRENT_X"));
            super.onRestoreInstanceState(bundle.getParcelable("BUNDLE_ID_PARENT_STATE"));
        }
    }

    private void KC() {
        this.vhk = -1;
        this.vhl = -1;
        this.vgW = 0;
        this.vgT = 0;
        this.vgU = 0;
        this.vgV = Integer.MAX_VALUE;
        zP(a.vhA);
    }

    private void reset() {
        KC();
        removeAllViewsInLayout();
        requestLayout();
    }

    public void setSelection(int i) {
        this.vhm = i;
    }

    public View getSelectedView() {
        int i = this.vhm;
        return (i < this.vhk || i > this.vhl) ? null : getChildAt(i - this.vhk);
    }

    public final void setAdapter(ListAdapter listAdapter) {
        int i = 0;
        if (this.FA != null) {
            this.FA.unregisterDataSetObserver(this.vhx);
        }
        if (listAdapter != null) {
            this.vhp = false;
            this.FA = listAdapter;
            this.FA.registerDataSetObserver(this.vhx);
        }
        int viewTypeCount = this.FA.getViewTypeCount();
        this.vhh.clear();
        while (i < viewTypeCount) {
            this.vhh.add(new LinkedList());
            i++;
        }
        reset();
    }

    private View zL(int i) {
        int itemViewType = this.FA.getItemViewType(i);
        if (zM(itemViewType)) {
            return (View) ((Queue) this.vhh.get(itemViewType)).poll();
        }
        return null;
    }

    private void h(int i, View view) {
        int itemViewType = this.FA.getItemViewType(i);
        if (zM(itemViewType)) {
            ((Queue) this.vhh.get(itemViewType)).offer(view);
        }
    }

    private boolean zM(int i) {
        return i < this.vhh.size();
    }

    private void G(View view, int i) {
        addViewInLayout(view, i, dc(view), true);
        LayoutParams dc = dc(view);
        view.measure(dc.width > 0 ? MeasureSpec.makeMeasureSpec(dc.width, 1073741824) : MeasureSpec.makeMeasureSpec(0, 0), ViewGroup.getChildMeasureSpec(this.vhu, getPaddingTop() + getPaddingBottom(), dc.height));
    }

    private static LayoutParams dc(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return new LayoutParams(-2, -1);
        }
        return layoutParams;
    }

    @SuppressLint({"WrongCall"})
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2 = false;
        super.onLayout(z, i, i2, i3, i4);
        if (this.FA != null) {
            int i5;
            int i6;
            View bRF;
            View view;
            int i7;
            invalidate();
            if (this.vhb) {
                i5 = this.vgT;
                KC();
                removeAllViewsInLayout();
                this.vgU = i5;
                this.vhb = false;
            }
            if (this.vhj != null) {
                this.vgU = this.vhj.intValue();
                this.vhj = null;
            }
            if (this.vhf.computeScrollOffset()) {
                this.vgU = this.vhf.getCurrX();
            }
            if (this.vgU < 0) {
                this.vgU = 0;
                if (this.vhs.isFinished()) {
                    this.vhs.ag((int) bRE());
                }
                this.vhf.forceFinished(true);
                zP(a.vhA);
            } else if (this.vgU > this.vgV) {
                this.vgU = this.vgV;
                if (this.vht.isFinished()) {
                    this.vht.ag((int) bRE());
                }
                this.vhf.forceFinished(true);
                zP(a.vhA);
            }
            int i8 = this.vgT - this.vgU;
            View childAt = getChildAt(0);
            while (childAt != null && childAt.getRight() + i8 <= 0) {
                i6 = this.vgW;
                if (zN(this.vhk)) {
                    i5 = childAt.getMeasuredWidth();
                } else {
                    i5 = this.Xk + childAt.getMeasuredWidth();
                }
                this.vgW = i5 + i6;
                h(this.vhk, childAt);
                removeViewInLayout(childAt);
                this.vhk++;
                childAt = getChildAt(0);
            }
            while (true) {
                bRF = bRF();
                if (bRF == null || bRF.getLeft() + i8 < getWidth()) {
                    bRF = bRF();
                } else {
                    h(this.vhl, bRF);
                    removeViewInLayout(bRF);
                    this.vhl--;
                }
            }
            bRF = bRF();
            i5 = bRF != null ? bRF.getRight() : 0;
            while ((i5 + i8) + this.Xk < getWidth() && this.vhl + 1 < this.FA.getCount()) {
                this.vhl++;
                if (this.vhk < 0) {
                    this.vhk = this.vhl;
                }
                view = this.FA.getView(this.vhl, zL(this.vhl), this);
                G(view, -1);
                i5 += (this.vhl == 0 ? 0 : this.Xk) + view.getMeasuredWidth();
                if (!(this.vhn == null || this.FA == null || this.FA.getCount() - (this.vhl + 1) >= this.vho || this.vhp)) {
                    this.vhp = true;
                }
            }
            bRF = getChildAt(0);
            i5 = bRF != null ? bRF.getLeft() : 0;
            while ((i5 + i8) - this.Xk > 0 && this.vhk > 0) {
                this.vhk--;
                view = this.FA.getView(this.vhk, zL(this.vhk), this);
                G(view, 0);
                i5 -= this.vhk == 0 ? view.getMeasuredWidth() : this.Xk + view.getMeasuredWidth();
                this.vgW -= i5 + i8 == 0 ? view.getMeasuredWidth() : this.Xk + view.getMeasuredWidth();
            }
            i6 = getChildCount();
            if (i6 > 0) {
                this.vgW += i8;
                i7 = this.vgW;
                for (i5 = 0; i5 < i6; i5++) {
                    View childAt2 = getChildAt(i5);
                    int paddingLeft = getPaddingLeft() + i7;
                    int paddingTop = getPaddingTop();
                    childAt2.layout(paddingLeft, paddingTop, childAt2.getMeasuredWidth() + paddingLeft, childAt2.getMeasuredHeight() + paddingTop);
                    i7 += childAt2.getMeasuredWidth() + this.Xk;
                }
            }
            this.vgT = this.vgU;
            if (zN(this.vhl)) {
                bRF = bRF();
                if (bRF != null) {
                    i7 = this.vgV;
                    this.vgV = ((bRF.getRight() - getPaddingLeft()) + this.vgT) - bRG();
                    if (this.vgV < 0) {
                        this.vgV = 0;
                    }
                    if (this.vgV != i7) {
                        z2 = true;
                    }
                }
            }
            if (z2) {
                onLayout(z, i, i2, i3, i4);
            } else if (!this.vhf.isFinished()) {
                z.a(this, this.vhy);
            } else if (this.vhr == a.vhC) {
                zP(a.vhA);
            }
        }
    }

    protected float getLeftFadingEdgeStrength() {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (this.vgT == 0) {
            return 0.0f;
        }
        if (this.vgT < horizontalFadingEdgeLength) {
            return ((float) this.vgT) / ((float) horizontalFadingEdgeLength);
        }
        return 1.0f;
    }

    protected float getRightFadingEdgeStrength() {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (this.vgT == this.vgV) {
            return 0.0f;
        }
        if (this.vgV - this.vgT < horizontalFadingEdgeLength) {
            return ((float) (this.vgV - this.vgT)) / ((float) horizontalFadingEdgeLength);
        }
        return 1.0f;
    }

    private float bRE() {
        if (VERSION.SDK_INT >= 14) {
            return c.b(this.vhf);
        }
        return 30.0f;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.vhu = i2;
    }

    private View bRF() {
        return getChildAt(getChildCount() - 1);
    }

    private int dV(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).getHitRect(this.fv);
            if (this.fv.contains(i, i2)) {
                return i3;
            }
        }
        return -1;
    }

    private boolean zN(int i) {
        return i == this.FA.getCount() + -1;
    }

    private int bRG() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public final void zO(int i) {
        this.vhf.startScroll(this.vgU, 0, i - this.vgU, 0);
        zP(a.vhC);
        requestLayout();
    }

    public int getFirstVisiblePosition() {
        return this.vhk;
    }

    public int getLastVisiblePosition() {
        return this.vhl;
    }

    private void a(Canvas canvas, Rect rect) {
        if (this.Xj != null) {
            this.Xj.setBounds(rect);
            this.Xj.draw(canvas);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int childCount = getChildCount();
        Rect rect = this.fv;
        this.fv.top = getPaddingTop();
        this.fv.bottom = this.fv.top + ((getHeight() - getPaddingTop()) - getPaddingBottom());
        for (int i = 0; i < childCount; i++) {
            if (i != childCount - 1 || !zN(this.vhl)) {
                View childAt = getChildAt(i);
                rect.left = childAt.getRight();
                rect.right = childAt.getRight() + this.Xk;
                if (rect.left < getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                }
                if (rect.right > getWidth() - getPaddingRight()) {
                    rect.right = getWidth() - getPaddingRight();
                }
                a(canvas, rect);
                if (i == 0 && childAt.getLeft() > getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                    rect.right = childAt.getLeft();
                    a(canvas, rect);
                }
            }
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    protected void dispatchSetPressed(boolean z) {
    }

    protected final boolean as(float f) {
        this.vhf.fling(this.vgU, 0, (int) (-f), 0, 0, this.vgV, 0, 0);
        zP(a.vhC);
        requestLayout();
        return true;
    }

    protected final boolean onDown(MotionEvent motionEvent) {
        this.vhv = !this.vhf.isFinished();
        this.vhf.forceFinished(true);
        zP(a.vhA);
        bRH();
        if (!this.vhv) {
            int dV = dV((int) motionEvent.getX(), (int) motionEvent.getY());
            if (dV >= 0) {
                this.vhi = getChildAt(dV);
                if (this.vhi != null) {
                    this.vhi.setPressed(true);
                    refreshDrawableState();
                }
            }
        }
        return true;
    }

    private void bRH() {
        if (this.vhi != null) {
            this.vhi.setPressed(false);
            refreshDrawableState();
            this.vhi = null;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.vhf == null || this.vhf.isFinished()) {
                zP(a.vhA);
            }
            g(Boolean.valueOf(false));
            bRI();
        } else if (motionEvent.getAction() == 3) {
            bRH();
            bRI();
            g(Boolean.valueOf(false));
        }
        return super.onTouchEvent(motionEvent);
    }

    private void bRI() {
        if (this.vhs != null) {
            this.vhs.cr();
        }
        if (this.vht != null) {
            this.vht.cr();
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    private void zP(int i) {
        if (!(this.vhr == i || this.vhq == null)) {
            this.vhq.oL(i);
        }
        this.vhr = i;
    }
}
