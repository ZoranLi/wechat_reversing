package com.tencent.mm.ui.base;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import android.widget.Scroller;
import java.util.LinkedList;
import java.util.Queue;

public class HorizontalListView extends AdapterView<ListAdapter> {
    protected ListAdapter FA;
    public a sQK;
    public boolean vgQ = true;
    private int vgR = -1;
    private int vgS = 0;
    protected int vgT;
    protected int vgU;
    private int vgV = Integer.MAX_VALUE;
    private int vgW = 0;
    private GestureDetector vgX;
    private Queue<View> vgY = new LinkedList();
    private OnItemSelectedListener vgZ;
    private OnItemClickListener vha;
    private boolean vhb = false;
    private DataSetObserver vhc = new DataSetObserver(this) {
        final /* synthetic */ HorizontalListView vhe;

        {
            this.vhe = r1;
        }

        public final void onChanged() {
            synchronized (this.vhe) {
                this.vhe.vhb = true;
            }
            this.vhe.invalidate();
            this.vhe.requestLayout();
        }

        public final void onInvalidated() {
            this.vhe.reset();
            this.vhe.invalidate();
            this.vhe.requestLayout();
        }
    };
    private OnGestureListener vhd = new SimpleOnGestureListener(this) {
        final /* synthetic */ HorizontalListView vhe;

        {
            this.vhe = r1;
        }

        public final boolean onDown(MotionEvent motionEvent) {
            return this.vhe.bRD();
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return this.vhe.as(f);
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            synchronized (this.vhe) {
                HorizontalListView horizontalListView = this.vhe;
                horizontalListView.vgU += (int) f;
            }
            this.vhe.requestLayout();
            return true;
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            Rect rect = new Rect();
            for (int i = 0; i < this.vhe.getChildCount(); i++) {
                View childAt = this.vhe.getChildAt(i);
                rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    if (this.vhe.vha != null) {
                        this.vhe.vha.onItemClick(this.vhe, childAt, (this.vhe.vgR + 1) + i, this.vhe.FA.getItemId((this.vhe.vgR + 1) + i));
                    }
                    if (this.vhe.vgZ != null) {
                        this.vhe.vgZ.onItemSelected(this.vhe, childAt, (this.vhe.vgR + 1) + i, this.vhe.FA.getItemId((this.vhe.vgR + 1) + i));
                    }
                    return true;
                }
            }
            return true;
        }
    };
    protected Scroller yw;

    public interface a {
        boolean F(MotionEvent motionEvent);
    }

    public /* bridge */ /* synthetic */ Adapter getAdapter() {
        return this.FA;
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        KC();
    }

    private synchronized void KC() {
        this.vgR = -1;
        this.vgS = 0;
        this.vgW = 0;
        this.vgT = 0;
        this.vgU = 0;
        this.vgV = Integer.MAX_VALUE;
        this.yw = new Scroller(getContext());
        this.vgX = new GestureDetector(getContext(), this.vhd);
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.vgZ = onItemSelectedListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.vha = onItemClickListener;
    }

    public View getSelectedView() {
        return null;
    }

    public final void setAdapter(ListAdapter listAdapter) {
        if (this.FA != null) {
            this.FA.unregisterDataSetObserver(this.vhc);
        }
        this.FA = listAdapter;
        this.FA.registerDataSetObserver(this.vhc);
        reset();
    }

    private synchronized void reset() {
        KC();
        removeAllViewsInLayout();
        requestLayout();
    }

    public void setSelection(int i) {
    }

    private void G(View view, int i) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -1);
        }
        addViewInLayout(view, i, layoutParams, true);
        view.measure(MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
    }

    protected synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 0;
        synchronized (this) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.FA != null) {
                int i6;
                if (this.vhb) {
                    i6 = this.vgT;
                    KC();
                    removeAllViewsInLayout();
                    this.vgU = i6;
                    this.vhb = false;
                }
                if (this.yw.computeScrollOffset()) {
                    this.vgU = this.yw.getCurrX();
                }
                if (this.vgU <= 0) {
                    this.vgU = 0;
                    this.yw.forceFinished(true);
                }
                if (this.vgU >= this.vgV) {
                    this.vgU = this.vgV;
                    this.yw.forceFinished(true);
                }
                int i7 = this.vgT - this.vgU;
                View childAt = getChildAt(0);
                while (childAt != null && childAt.getRight() + i7 <= 0) {
                    this.vgW += childAt.getMeasuredWidth();
                    this.vgY.offer(childAt);
                    removeViewInLayout(childAt);
                    this.vgR++;
                    childAt = getChildAt(0);
                }
                while (true) {
                    childAt = getChildAt(getChildCount() - 1);
                    if (childAt == null || childAt.getLeft() + i7 < getWidth()) {
                        break;
                    }
                    this.vgY.offer(childAt);
                    removeViewInLayout(childAt);
                    this.vgS--;
                }
                childAt = getChildAt(getChildCount() - 1);
                if (childAt != null) {
                    i6 = childAt.getRight();
                } else {
                    i6 = 0;
                }
                int i8 = i6;
                while (i8 + i7 < getWidth() && this.vgS < this.FA.getCount()) {
                    childAt = this.FA.getView(this.vgS, (View) this.vgY.poll(), this);
                    G(childAt, -1);
                    i6 = childAt.getMeasuredWidth() + i8;
                    if (this.vgS == this.FA.getCount() - 1) {
                        this.vgV = (this.vgT + i6) - getWidth();
                    }
                    if (this.vgV < 0) {
                        this.vgV = 0;
                    }
                    this.vgS++;
                    i8 = i6;
                }
                childAt = getChildAt(0);
                if (childAt != null) {
                    i6 = childAt.getLeft();
                } else {
                    i6 = 0;
                }
                i8 = i6;
                while (i8 + i7 > 0 && this.vgR >= 0) {
                    View view = this.FA.getView(this.vgR, (View) this.vgY.poll(), this);
                    G(view, 0);
                    i6 = i8 - view.getMeasuredWidth();
                    this.vgR--;
                    this.vgW -= view.getMeasuredWidth();
                    i8 = i6;
                }
                if (getChildCount() > 0) {
                    this.vgW += i7;
                    i6 = this.vgW;
                    while (i5 < getChildCount()) {
                        View childAt2 = getChildAt(i5);
                        i7 = childAt2.getMeasuredWidth();
                        childAt2.layout(i6, 0, i6 + i7, childAt2.getMeasuredHeight());
                        i6 += i7;
                        i5++;
                    }
                }
                this.vgT = this.vgU;
                if (!this.yw.isFinished()) {
                    post(new Runnable(this) {
                        final /* synthetic */ HorizontalListView vhe;

                        {
                            this.vhe = r1;
                        }

                        public final void run() {
                            this.vhe.requestLayout();
                        }
                    });
                }
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.sQK != null) {
            this.sQK.F(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent) | this.vgX.onTouchEvent(motionEvent);
    }

    protected final boolean as(float f) {
        synchronized (this) {
            this.yw.fling(this.vgU, 0, (int) (-f), 0, 0, this.vgV, 0, 0);
        }
        requestLayout();
        return true;
    }

    protected final boolean bRD() {
        this.yw.forceFinished(true);
        return true;
    }
}
