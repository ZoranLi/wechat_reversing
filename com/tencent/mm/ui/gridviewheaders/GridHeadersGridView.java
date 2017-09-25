package com.tencent.mm.ui.gridviewheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.List;

public class GridHeadersGridView extends GridView implements OnScrollListener, OnItemClickListener, OnItemLongClickListener, OnItemSelectedListener {
    private DataSetObserver Br;
    private OnItemSelectedListener Gf;
    private OnItemClickListener acN;
    protected int aec;
    private int iE;
    private int kUT;
    private OnItemLongClickListener kbJ;
    private ae mHandler;
    private int mNumColumns;
    private OnScrollListener qPk;
    private int vgI;
    private int vgJ;
    protected boolean vhb;
    private Runnable vmn;
    public a wiW;
    public b wiX;
    private boolean wiY;
    private final Rect wiZ;
    private boolean wja;
    private boolean wjb;
    private long wjc;
    private int wjd;
    private float wje;
    private boolean wjf;
    private int wjg;
    public c wjh;
    d wji;
    private e wjj;
    private View wjk;
    protected c wjl;
    protected int wjm;
    private boolean wjn;
    private int xV;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean wjr;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.wjr = parcel.readByte() != (byte) 0;
        }

        public String toString() {
            return "StickyGridHeadersGridView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " areHeadersSticky=" + this.wjr + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte((byte) (this.wjr ? 1 : 0));
        }
    }

    final class b implements Runnable {
        final /* synthetic */ GridHeadersGridView wjo;

        b(GridHeadersGridView gridHeadersGridView) {
            this.wjo = gridHeadersGridView;
        }

        public final void run() {
            if (this.wjo.aec == 0) {
                this.wjo.aec = 1;
                View BY = this.wjo.BY(this.wjo.wjm);
                if (BY != null && !BY.hasFocusable()) {
                    if (this.wjo.vhb) {
                        this.wjo.aec = 2;
                        return;
                    }
                    BY.setPressed(true);
                    this.wjo.setPressed(true);
                    this.wjo.refreshDrawableState();
                    int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    if (this.wjo.isLongClickable()) {
                        if (this.wjo.wiW == null) {
                            this.wjo.wiW = new a(this.wjo);
                        }
                        this.wjo.wiW.aou();
                        this.wjo.mHandler.postDelayed(this.wjo.wiW, (long) longPressTimeout);
                        return;
                    }
                    this.wjo.aec = 2;
                }
            }
        }
    }

    public interface c {
        void ce(View view);
    }

    public interface d {
        boolean bZn();
    }

    private class f {
        private int kWf;
        final /* synthetic */ GridHeadersGridView wjo;

        public f(GridHeadersGridView gridHeadersGridView) {
            this.wjo = gridHeadersGridView;
        }

        public final void aou() {
            this.kWf = this.wjo.getWindowAttachCount();
        }

        public final boolean aov() {
            return this.wjo.hasWindowFocus() && this.wjo.getWindowAttachCount() == this.kWf;
        }
    }

    private class a extends f implements Runnable {
        final /* synthetic */ GridHeadersGridView wjo;

        public a(GridHeadersGridView gridHeadersGridView) {
            this.wjo = gridHeadersGridView;
            super(gridHeadersGridView);
        }

        public final void run() {
            View BY = this.wjo.BY(this.wjo.wjm);
            if (BY != null) {
                boolean z;
                GridHeadersGridView.a(this.wjo, this.wjo.wjm);
                if (!aov() || this.wjo.vhb) {
                    z = false;
                } else {
                    GridHeadersGridView gridHeadersGridView = this.wjo;
                    if (gridHeadersGridView.wji != null) {
                        z = gridHeadersGridView.wji.bZn();
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (BY != null) {
                            BY.sendAccessibilityEvent(2);
                        }
                        gridHeadersGridView.performHapticFeedback(0);
                    }
                }
                if (z) {
                    this.wjo.aec = -2;
                    this.wjo.setPressed(false);
                    BY.setPressed(false);
                    return;
                }
                this.wjo.aec = 2;
            }
        }
    }

    private class e extends f implements Runnable {
        int kWe;
        final /* synthetic */ GridHeadersGridView wjo;

        public e(GridHeadersGridView gridHeadersGridView) {
            this.wjo = gridHeadersGridView;
            super(gridHeadersGridView);
        }

        public final void run() {
            if (!this.wjo.vhb && this.wjo.wjl != null && this.wjo.wjl.getCount() > 0 && this.kWe != -1 && this.kWe < this.wjo.wjl.getCount() && aov()) {
                View BY = this.wjo.BY(this.kWe);
                if (BY != null) {
                    GridHeadersGridView gridHeadersGridView = this.wjo;
                    GridHeadersGridView.a(this.wjo, this.kWe);
                    if (gridHeadersGridView.wjh != null) {
                        gridHeadersGridView.playSoundEffect(0);
                        if (BY != null) {
                            BY.sendAccessibilityEvent(1);
                        }
                        gridHeadersGridView.wjh.ce(BY);
                    }
                }
            }
        }
    }

    static /* synthetic */ long a(GridHeadersGridView gridHeadersGridView, int i) {
        return i == -2 ? gridHeadersGridView.wjc : gridHeadersGridView.wjl.kS(gridHeadersGridView.getFirstVisiblePosition() + i);
    }

    public GridHeadersGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842865);
    }

    public GridHeadersGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new ae();
        this.wiY = true;
        this.wiZ = new Rect();
        this.wjc = -1;
        this.Br = new DataSetObserver(this) {
            final /* synthetic */ GridHeadersGridView wjo;

            {
                this.wjo = r1;
            }

            public final void onChanged() {
                this.wjo.reset();
            }

            public final void onInvalidated() {
                this.wjo.reset();
            }
        };
        this.wjg = 1;
        this.xV = 0;
        this.wjn = true;
        super.setOnScrollListener(this);
        setVerticalFadingEdgeEnabled(false);
        if (!this.wjf) {
            this.mNumColumns = -1;
        }
        this.iE = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public final View BY(int i) {
        if (i == -2) {
            return this.wjk;
        }
        try {
            return (View) getChildAt(i).getTag();
        } catch (Exception e) {
            return null;
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.acN.onItemClick(adapterView, view, this.wjl.BX(i).kC, j);
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return this.kbJ.onItemLongClick(adapterView, view, this.wjl.BX(i).kC, j);
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.Gf.onItemSelected(adapterView, view, this.wjl.BX(i).kC, j);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
        this.Gf.onNothingSelected(adapterView);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.wiY = savedState.wjr;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.wjr = this.wiY;
        return savedState;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.qPk != null) {
            this.qPk.onScroll(absListView, i, i2, i3);
        }
        if (VERSION.SDK_INT >= 8) {
            BZ(i);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.qPk != null) {
            this.qPk.onScrollStateChanged(absListView, i);
        }
        this.xV = i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r11) {
        /*
        r10 = this;
        r1 = -2;
        r4 = 1;
        r2 = 0;
        r3 = -1;
        r0 = r11.getAction();
        r0 = r0 & 255;
        switch(r0) {
            case 0: goto L_0x0011;
            case 1: goto L_0x00b4;
            case 2: goto L_0x0082;
            default: goto L_0x000d;
        };
    L_0x000d:
        r0 = r2;
    L_0x000e:
        if (r0 == 0) goto L_0x013a;
    L_0x0010:
        return r2;
    L_0x0011:
        r0 = r10.wiX;
        if (r0 != 0) goto L_0x001c;
    L_0x0015:
        r0 = new com.tencent.mm.ui.gridviewheaders.GridHeadersGridView$b;
        r0.<init>(r10);
        r10.wiX = r0;
    L_0x001c:
        r0 = r10.mHandler;
        r4 = r10.wiW;
        r5 = android.view.ViewConfiguration.getTapTimeout();
        r6 = (long) r5;
        r0.postDelayed(r4, r6);
        r0 = r11.getY();
        r0 = (int) r0;
        r4 = (float) r0;
        r10.wje = r4;
        r4 = (float) r0;
        r0 = r10.wjk;
        if (r0 == 0) goto L_0x004e;
    L_0x0035:
        r0 = r10.wjk;
        r0 = r0.getBottom();
        r0 = (float) r0;
        r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r0 > 0) goto L_0x004e;
    L_0x0040:
        r10.wjm = r1;
        r0 = r10.wjm;
        if (r0 == r3) goto L_0x000d;
    L_0x0046:
        r0 = r10.xV;
        r1 = 2;
        if (r0 == r1) goto L_0x000d;
    L_0x004b:
        r10.aec = r2;
        goto L_0x000d;
    L_0x004e:
        r0 = r10.getFirstVisiblePosition();
        r1 = r2;
    L_0x0053:
        r5 = r10.getLastVisiblePosition();
        if (r0 > r5) goto L_0x0080;
    L_0x0059:
        r6 = r10.getItemIdAtPosition(r0);
        r8 = -1;
        r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r5 != 0) goto L_0x0079;
    L_0x0063:
        r5 = r10.getChildAt(r1);
        r6 = r5.getBottom();
        r5 = r5.getTop();
        r6 = (float) r6;
        r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r6 > 0) goto L_0x0079;
    L_0x0074:
        r5 = (float) r5;
        r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1));
        if (r5 >= 0) goto L_0x0040;
    L_0x0079:
        r5 = r10.wjg;
        r0 = r0 + r5;
        r5 = r10.wjg;
        r1 = r1 + r5;
        goto L_0x0053;
    L_0x0080:
        r1 = r3;
        goto L_0x0040;
    L_0x0082:
        r0 = r10.wjm;
        if (r0 == r3) goto L_0x000d;
    L_0x0086:
        r0 = r11.getY();
        r1 = r10.wje;
        r0 = r0 - r1;
        r0 = java.lang.Math.abs(r0);
        r1 = r10.iE;
        r1 = (float) r1;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 <= 0) goto L_0x000d;
    L_0x0098:
        r10.aec = r3;
        r0 = r10.wjm;
        r0 = r10.BY(r0);
        if (r0 == 0) goto L_0x00a5;
    L_0x00a2:
        r0.setPressed(r2);
    L_0x00a5:
        r0 = r10.wiW;
        if (r0 == 0) goto L_0x00b0;
    L_0x00a9:
        r0 = r10.mHandler;
        r1 = r10.wiW;
        r0.removeCallbacks(r1);
    L_0x00b0:
        r10.wjm = r3;
        goto L_0x000d;
    L_0x00b4:
        r0 = r10.aec;
        if (r0 == r1) goto L_0x000d;
    L_0x00b8:
        r0 = r10.aec;
        if (r0 == r3) goto L_0x000d;
    L_0x00bc:
        r0 = r10.wjm;
        if (r0 == r3) goto L_0x000d;
    L_0x00c0:
        r0 = r10.wjm;
        r1 = r10.BY(r0);
        if (r1 == 0) goto L_0x012c;
    L_0x00c8:
        r0 = r1.hasFocusable();
        if (r0 != 0) goto L_0x012c;
    L_0x00ce:
        r0 = r10.aec;
        if (r0 == 0) goto L_0x00d5;
    L_0x00d2:
        r1.setPressed(r2);
    L_0x00d5:
        r0 = r10.wjj;
        if (r0 != 0) goto L_0x00e0;
    L_0x00d9:
        r0 = new com.tencent.mm.ui.gridviewheaders.GridHeadersGridView$e;
        r0.<init>(r10);
        r10.wjj = r0;
    L_0x00e0:
        r5 = r10.wjj;
        r0 = r10.wjm;
        r5.kWe = r0;
        r5.aou();
        r0 = r10.aec;
        if (r0 != 0) goto L_0x00f1;
    L_0x00ed:
        r0 = r10.aec;
        if (r0 == r4) goto L_0x0130;
    L_0x00f1:
        r6 = r10.mHandler;
        r0 = r10.aec;
        if (r0 != 0) goto L_0x0127;
    L_0x00f7:
        r0 = r10.wiX;
    L_0x00f9:
        r6.removeCallbacks(r0);
        r0 = r10.vhb;
        if (r0 != 0) goto L_0x012a;
    L_0x0100:
        r10.aec = r4;
        r1.setPressed(r4);
        r10.setPressed(r4);
        r0 = r10.vmn;
        if (r0 == 0) goto L_0x0111;
    L_0x010c:
        r0 = r10.vmn;
        r10.removeCallbacks(r0);
    L_0x0111:
        r0 = new com.tencent.mm.ui.gridviewheaders.GridHeadersGridView$2;
        r0.<init>(r10, r1, r5);
        r10.vmn = r0;
        r0 = r10.mHandler;
        r1 = r10.vmn;
        r3 = android.view.ViewConfiguration.getPressedStateDuration();
        r6 = (long) r3;
        r0.postDelayed(r1, r6);
        r0 = r4;
        goto L_0x000e;
    L_0x0127:
        r0 = r10.wiW;
        goto L_0x00f9;
    L_0x012a:
        r10.aec = r3;
    L_0x012c:
        r10.aec = r3;
        goto L_0x000d;
    L_0x0130:
        r0 = r10.vhb;
        if (r0 != 0) goto L_0x012c;
    L_0x0134:
        r5.run();
        r0 = r4;
        goto L_0x000e;
    L_0x013a:
        r2 = super.dispatchTouchEvent(r11);
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (!(this.wjl == null || this.Br == null)) {
            this.wjl.unregisterDataSetObserver(this.Br);
        }
        if (!this.wjb) {
            this.wja = true;
        }
        if (listAdapter instanceof b) {
            listAdapter = (b) listAdapter;
        } else if (listAdapter instanceof e) {
            r3 = new f((e) listAdapter);
        } else {
            r3 = new d(listAdapter);
        }
        this.wjl = new c(getContext(), this, listAdapter);
        this.wjl.registerDataSetObserver(this.Br);
        reset();
        super.setAdapter(this.wjl);
    }

    public void setClipToPadding(boolean z) {
        super.setClipToPadding(z);
        this.wja = z;
        this.wjb = true;
    }

    public void setColumnWidth(int i) {
        super.setColumnWidth(i);
        this.kUT = i;
    }

    public void setHorizontalSpacing(int i) {
        super.setHorizontalSpacing(i);
        this.vgI = i;
    }

    public void setNumColumns(int i) {
        super.setNumColumns(i);
        this.wjf = true;
        this.mNumColumns = i;
        if (i != -1 && this.wjl != null) {
            this.wjl.setNumColumns(i);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.acN = onItemClickListener;
        super.setOnItemClickListener(this);
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.kbJ = onItemLongClickListener;
        super.setOnItemLongClickListener(this);
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.Gf = onItemSelectedListener;
        super.setOnItemSelectedListener(this);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.qPk = onScrollListener;
    }

    public void setVerticalSpacing(int i) {
        super.setVerticalSpacing(i);
        this.vgJ = i;
    }

    private int bZl() {
        if (this.wjk != null) {
            return this.wjk.getMeasuredHeight();
        }
        return 0;
    }

    private void bZm() {
        if (this.wjk != null) {
            int makeMeasureSpec;
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec((getWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824);
            LayoutParams layoutParams = this.wjk.getLayoutParams();
            if (layoutParams == null || layoutParams.height <= 0) {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            } else {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            }
            this.wjk.measure(makeMeasureSpec2, makeMeasureSpec);
            this.wjk.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.wjk.getMeasuredHeight());
        }
    }

    private void reset() {
        this.wjd = 0;
        this.wjk = null;
        this.wjc = Long.MIN_VALUE;
    }

    private void BZ(int i) {
        if (this.wjl != null && this.wjl.getCount() != 0 && this.wiY && ((d) getChildAt(0)) != null) {
            int i2;
            long kS;
            int childCount;
            View view;
            int i3;
            View view2;
            View view3;
            int i4 = i - this.wjg;
            if (i4 < 0) {
                i4 = i;
            }
            int i5 = this.wjg + i;
            if (i5 >= this.wjl.getCount()) {
                i5 = i;
            }
            if (this.vgJ != 0) {
                if (this.vgJ < 0) {
                    this.wjl.kS(i);
                    if (getChildAt(this.wjg).getTop() <= 0) {
                        i2 = i5;
                        kS = this.wjl.kS(i5);
                    } else {
                        kS = this.wjl.kS(i);
                        i2 = i;
                    }
                } else {
                    i5 = getChildAt(0).getTop();
                    if (i5 > 0 && i5 < this.vgJ) {
                        i2 = i4;
                        kS = this.wjl.kS(i4);
                    }
                }
                if (this.wjc != kS) {
                    this.wjk = this.wjl.a(i2, this.wjk, this);
                    bZm();
                    this.wjc = kS;
                }
                childCount = getChildCount();
                if (childCount != 0) {
                    view = null;
                    i2 = 99999;
                    i3 = 0;
                    while (i3 < childCount) {
                        view2 = (d) super.getChildAt(i3);
                        if (this.wja) {
                            i5 = view2.getTop();
                        } else {
                            i5 = view2.getTop() - getPaddingTop();
                        }
                        if (i5 >= 0 || !(view2.getChildAt(0) instanceof b) || i5 >= i2) {
                            i4 = i2;
                            view3 = view;
                        } else {
                            int i6 = i5;
                            view3 = view2;
                            i4 = i6;
                        }
                        i3 = this.wjg + i3;
                        view = view3;
                        i2 = i4;
                    }
                    i4 = bZl();
                    if (view != null) {
                        this.wjd = i4;
                        if (this.wja) {
                            this.wjd += getPaddingTop();
                            return;
                        }
                        return;
                    } else if (i != 0 && super.getChildAt(0).getTop() > 0 && !this.wja) {
                        this.wjd = 0;
                        return;
                    } else if (this.wja) {
                        this.wjd = Math.min(view.getTop(), i4);
                        if (this.wjd >= 0) {
                            i4 = this.wjd;
                        }
                        this.wjd = i4;
                        return;
                    } else {
                        this.wjd = Math.min(view.getTop(), getPaddingTop() + i4);
                        this.wjd = this.wjd >= getPaddingTop() ? i4 + getPaddingTop() : this.wjd;
                    }
                }
            }
            kS = this.wjl.kS(i);
            i2 = i;
            if (this.wjc != kS) {
                this.wjk = this.wjl.a(i2, this.wjk, this);
                bZm();
                this.wjc = kS;
            }
            childCount = getChildCount();
            if (childCount != 0) {
                view = null;
                i2 = 99999;
                i3 = 0;
                while (i3 < childCount) {
                    view2 = (d) super.getChildAt(i3);
                    if (this.wja) {
                        i5 = view2.getTop();
                    } else {
                        i5 = view2.getTop() - getPaddingTop();
                    }
                    if (i5 >= 0) {
                    }
                    i4 = i2;
                    view3 = view;
                    i3 = this.wjg + i3;
                    view = view3;
                    i2 = i4;
                }
                i4 = bZl();
                if (view != null) {
                    this.wjd = i4;
                    if (this.wja) {
                        this.wjd += getPaddingTop();
                        return;
                    }
                    return;
                }
                if (i != 0) {
                }
                if (this.wja) {
                    this.wjd = Math.min(view.getTop(), i4);
                    if (this.wjd >= 0) {
                        i4 = this.wjd;
                    }
                    this.wjd = i4;
                    return;
                }
                this.wjd = Math.min(view.getTop(), getPaddingTop() + i4);
                if (this.wjd >= getPaddingTop()) {
                }
                this.wjd = this.wjd >= getPaddingTop() ? i4 + getPaddingTop() : this.wjd;
            }
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        Object obj;
        if (VERSION.SDK_INT < 8) {
            BZ(getFirstVisiblePosition());
        }
        if (this.wjk != null && this.wiY && this.wjk.getVisibility() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        int bZl = bZl();
        int i = this.wjd - bZl;
        if (obj != null && this.wjn) {
            this.wiZ.left = getPaddingLeft();
            this.wiZ.right = getWidth() - getPaddingRight();
            this.wiZ.top = this.wjd;
            this.wiZ.bottom = getHeight();
            canvas.save();
            canvas.clipRect(this.wiZ);
        }
        super.dispatchDraw(canvas);
        List arrayList = new ArrayList();
        int i2 = 0;
        int firstVisiblePosition = getFirstVisiblePosition();
        while (firstVisiblePosition <= getLastVisiblePosition()) {
            if (getItemIdAtPosition(firstVisiblePosition) == -1) {
                arrayList.add(Integer.valueOf(i2));
            }
            firstVisiblePosition += this.wjg;
            i2 += this.wjg;
        }
        int i3 = 0;
        while (i3 < arrayList.size()) {
            d dVar = (d) getChildAt(((Integer) arrayList.get(i3)).intValue());
            try {
                View view = (View) dVar.getTag();
                Object obj2 = (((long) ((b) dVar.getChildAt(0)).wiS) == this.wjc && dVar.getTop() < 0 && this.wiY) ? 1 : null;
                if (view.getVisibility() == 0 && obj2 == null) {
                    view.measure(MeasureSpec.makeMeasureSpec(getWidth(), (1073741824 - getPaddingLeft()) - getPaddingRight()), MeasureSpec.makeMeasureSpec(0, 0));
                    view.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), dVar.getHeight());
                    this.wiZ.left = getPaddingLeft();
                    this.wiZ.right = getWidth() - getPaddingRight();
                    this.wiZ.bottom = dVar.getBottom();
                    this.wiZ.top = dVar.getTop();
                    canvas.save();
                    canvas.clipRect(this.wiZ);
                    canvas.translate((float) getPaddingLeft(), (float) dVar.getTop());
                    view.draw(canvas);
                    canvas.restore();
                }
                i3++;
            } catch (Exception e) {
                return;
            }
        }
        if (obj != null && this.wjn) {
            canvas.restore();
        } else if (obj == null) {
            return;
        }
        if (this.wjk.getWidth() != (getWidth() - getPaddingLeft()) - getPaddingRight()) {
            this.wjk.measure(MeasureSpec.makeMeasureSpec(getWidth(), (1073741824 - getPaddingLeft()) - getPaddingRight()), MeasureSpec.makeMeasureSpec(0, 0));
            this.wjk.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.wjk.getHeight());
        }
        this.wiZ.left = getPaddingLeft();
        this.wiZ.right = getWidth() - getPaddingRight();
        this.wiZ.bottom = i + bZl;
        if (this.wja) {
            this.wiZ.top = getPaddingTop();
        } else {
            this.wiZ.top = 0;
        }
        canvas.save();
        canvas.clipRect(this.wiZ);
        canvas.translate((float) getPaddingLeft(), (float) i);
        canvas.saveLayerAlpha(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (int) ((255.0f * ((float) this.wjd)) / ((float) bZl)), 4);
        this.wjk.draw(canvas);
        canvas.restore();
        canvas.restore();
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1;
        if (this.mNumColumns == -1) {
            if (this.kUT > 0) {
                int max = Math.max((MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight(), 0);
                int i4 = max / this.kUT;
                if (i4 > 0) {
                    while (i4 != 1 && (this.kUT * i4) + ((i4 - 1) * this.vgI) > max) {
                        i4--;
                    }
                    i3 = i4;
                }
            } else {
                i3 = 2;
            }
            this.wjg = i3;
        } else {
            this.wjg = this.mNumColumns;
        }
        if (this.wjl != null) {
            this.wjl.setNumColumns(this.wjg);
        }
        bZm();
        super.onMeasure(i, i2);
    }
}
