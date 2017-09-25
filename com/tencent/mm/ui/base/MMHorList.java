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
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.LinkedList;
import java.util.Queue;

public class MMHorList extends AdapterView<ListAdapter> {
    public boolean nUI = false;
    private int offset;
    private boolean vkA = false;
    protected Scroller vkB;
    private GestureDetector vkC;
    private OnItemSelectedListener vkD;
    private OnItemClickListener vkE;
    private ListAdapter vkF;
    private Runnable vkG = new Runnable(this) {
        final /* synthetic */ MMHorList vkO;

        {
            this.vkO = r1;
        }

        public final void run() {
            this.vkO.requestLayout();
        }
    };
    public boolean vkH = false;
    public boolean vkI = false;
    public int vkJ = 0;
    private int vkK = 0;
    private boolean vkL = false;
    private DataSetObserver vkM = new DataSetObserver(this) {
        final /* synthetic */ MMHorList vkO;

        {
            this.vkO = r1;
        }

        public final void onChanged() {
            this.vkO.vkz = true;
            this.vkO.invalidate();
            this.vkO.requestLayout();
        }

        public final void onInvalidated() {
            this.vkO.reset();
            this.vkO.invalidate();
            this.vkO.requestLayout();
        }
    };
    private OnGestureListener vkN = new SimpleOnGestureListener(this) {
        final /* synthetic */ MMHorList vkO;

        {
            this.vkO = r1;
        }

        public final boolean onDown(MotionEvent motionEvent) {
            return this.vkO.bRD();
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return this.vkO.as(f);
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            this.vkO.vkw = this.vkO.vkw + ((int) f);
            this.vkO.requestLayout();
            return true;
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            Rect rect = new Rect();
            for (int i = 0; i < this.vkO.getChildCount(); i++) {
                View childAt = this.vkO.getChildAt(i);
                rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    if (this.vkO.vkE != null) {
                        this.vkO.vkE.onItemClick(this.vkO, childAt, (this.vkO.vkt + 1) + i, this.vkO.vkF.getItemId((this.vkO.vkt + 1) + i));
                    }
                    if (this.vkO.vkD != null) {
                        this.vkO.vkD.onItemSelected(this.vkO, childAt, (this.vkO.vkt + 1) + i, this.vkO.vkF.getItemId((this.vkO.vkt + 1) + i));
                    }
                    return true;
                }
            }
            return true;
        }
    };
    public a vks;
    private int vkt;
    private int vku;
    public int vkv;
    private int vkw;
    private int vkx = SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING;
    private Queue<View> vky = new LinkedList();
    private boolean vkz = false;

    public interface a {
        void aIp();

        void bnZ();

        void boa();
    }

    public /* bridge */ /* synthetic */ Adapter getAdapter() {
        return this.vkF;
    }

    private void init() {
        this.vkB = new Scroller(getContext());
        this.vkt = -1;
        this.vku = 0;
        this.offset = 0;
        this.vkv = 0;
        this.vkw = 0;
        this.vkz = false;
        this.vkx = SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING;
        this.vkC = new GestureDetector(getContext(), this.vkN);
    }

    public MMHorList(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.vkD = onItemSelectedListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.vkE = onItemClickListener;
    }

    public MMHorList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public final void setAdapter(ListAdapter listAdapter) {
        if (this.vkF == null) {
            listAdapter.registerDataSetObserver(this.vkM);
        }
        this.vkF = listAdapter;
        reset();
    }

    private int bSf() {
        return this.vkF.getCount() * this.vkJ;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.vkF != null) {
            int i5;
            this.vkA = true;
            if (this.vkz) {
                i5 = this.vkv;
                init();
                removeAllViewsInLayout();
                this.vkw = i5;
                if (this.vkH) {
                    this.vkK = Math.max(0, (getWidth() - bSf()) / 2);
                    this.offset = this.vkK;
                }
                this.vkz = false;
            }
            if (this.vkB.computeScrollOffset()) {
                this.vkw = this.vkB.getCurrX();
            }
            if (!this.vkI) {
                if (this.vkw < 0) {
                    this.vkw = 0;
                    this.vkB.forceFinished(true);
                }
                if (this.vkw > this.vkx) {
                    this.vkw = this.vkx;
                    this.vkB.forceFinished(true);
                }
            } else if (bSf() > getWidth()) {
                if (this.vkw < getWidth() * -1) {
                    this.vkw = (getWidth() * -1) + 1;
                    this.vkB.forceFinished(true);
                }
                if (this.vkw > this.vkx + getWidth()) {
                    this.vkw = (this.vkx + getWidth()) - 1;
                    this.vkB.forceFinished(true);
                }
            } else {
                if (this.vkw < (getWidth() * -1) + this.vkK) {
                    this.vkw = ((getWidth() * -1) + this.vkK) + 1;
                    this.vkB.forceFinished(true);
                }
                if (this.vkw > getWidth() - this.vkK) {
                    this.vkw = (getWidth() - this.vkK) - 1;
                    this.vkB.forceFinished(true);
                }
            }
            int i6 = this.vkv - this.vkw;
            View childAt = getChildAt(0);
            while (childAt != null && childAt.getRight() + i6 <= 0) {
                this.offset += childAt.getMeasuredWidth();
                this.vky.offer(childAt);
                removeViewInLayout(childAt);
                this.vkt++;
                childAt = getChildAt(0);
                this.vkA = true;
            }
            childAt = getChildAt(getChildCount() - 1);
            while (childAt != null && childAt.getLeft() + i6 >= getWidth()) {
                this.vky.offer(childAt);
                removeViewInLayout(childAt);
                this.vku--;
                childAt = getChildAt(getChildCount() - 1);
                this.vkA = true;
            }
            childAt = getChildAt(getChildCount() - 1);
            if (childAt != null) {
                i5 = childAt.getRight();
            } else {
                i5 = 0;
            }
            int i7 = i5;
            while (i7 + i6 < getWidth() && this.vku < this.vkF.getCount()) {
                childAt = this.vkF.getView(this.vku, (View) this.vky.poll(), this);
                G(childAt, -1);
                i5 = childAt.getMeasuredWidth() + i7;
                if (this.vku == this.vkF.getCount() - 1) {
                    this.vkx = (this.vkv + i5) - getWidth();
                }
                this.vku++;
                i7 = i5;
            }
            childAt = getChildAt(0);
            if (childAt != null) {
                i5 = childAt.getLeft();
            } else {
                i5 = 0;
            }
            i7 = i5;
            while (i7 + i6 > 0 && this.vkt >= 0) {
                View view = this.vkF.getView(this.vkt, (View) this.vky.poll(), this);
                G(view, 0);
                i5 = i7 - view.getMeasuredWidth();
                this.vkt--;
                this.offset -= view.getMeasuredWidth();
                i7 = i5;
            }
            if (getChildCount() > 0 && this.vkA) {
                this.offset += i6;
                i7 = this.offset;
                for (i5 = 0; i5 < getChildCount(); i5++) {
                    View childAt2 = getChildAt(i5);
                    int measuredWidth = childAt2.getMeasuredWidth();
                    childAt2.layout(i7, 0, i7 + measuredWidth, childAt2.getMeasuredHeight());
                    i7 += measuredWidth;
                }
            }
            this.vkv = this.vkw;
            if (!this.vkB.isFinished()) {
                post(this.vkG);
            } else if (this.vks != null && this.vkL) {
                this.vks.aIp();
                this.vkL = false;
            }
        }
    }

    private void G(View view, int i) {
        this.vkA = true;
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -1);
        }
        addViewInLayout(view, i, layoutParams, true);
        view.measure(MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
    }

    public View getSelectedView() {
        return null;
    }

    public void setSelection(int i) {
    }

    protected void onMeasure(int i, int i2) {
        if (this.vkF != null && this.vkF.getCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt != null) {
                super.onMeasure(i, MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), Integer.MIN_VALUE));
                return;
            }
        }
        super.onMeasure(i, i2);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.vkC.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 0) {
            this.nUI = true;
            if (this.vks != null) {
                this.vks.bnZ();
            }
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            if (this.vkI) {
                if (bSf() > getWidth()) {
                    if (this.vkv < 0) {
                        this.vkB.forceFinished(true);
                        this.vkB.startScroll(this.vkv, 0, 0 - this.vkv, 0);
                        requestLayout();
                    } else if (this.vkv > this.vkx) {
                        this.vkB.forceFinished(true);
                        this.vkB.startScroll(this.vkv, 0, this.vkx - this.vkv, 0);
                        requestLayout();
                    }
                } else if (this.vkv != this.vkK * -1) {
                    this.vkB.forceFinished(true);
                    this.vkB.startScroll(this.vkv, 0, 0 - this.vkv, 0);
                    requestLayout();
                }
            }
            this.nUI = false;
            if (this.vks != null) {
                this.vks.boa();
            }
        }
        return onTouchEvent;
    }

    protected final boolean bRD() {
        this.vkB.forceFinished(true);
        return true;
    }

    public final void Aj(int i) {
        this.vkB.forceFinished(true);
        this.vkB.startScroll(this.vkv, 0, i - this.vkv, 0);
        this.vkL = true;
        requestLayout();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    protected final boolean as(float f) {
        this.vkB.fling(this.vkw, 0, (int) (-f), 0, 0, this.vkx, 0, 0);
        requestLayout();
        return true;
    }

    private void reset() {
        init();
        removeAllViewsInLayout();
        requestLayout();
    }
}
