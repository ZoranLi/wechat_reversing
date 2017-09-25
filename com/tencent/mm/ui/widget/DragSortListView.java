package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DragSortListView extends ListView {
    private int EK = 0;
    private int jdE;
    private int jdF;
    private DataSetObserver mObserver;
    private View wsJ;
    private Point wsK = new Point();
    private Point wsL = new Point();
    private int wsM;
    private boolean wsN = false;
    private float wsO = 1.0f;
    private float wsP = 1.0f;
    private int wsQ;
    private int wsR;
    private int wsS;
    private boolean wsT = false;
    private int wsU;
    private int wsV;
    private int wsW;
    private int wsX;
    private int wsY;
    private b wsZ;
    private MotionEvent wtA;
    private int wtB = 0;
    private float wtC = 0.25f;
    private float wtD = 0.0f;
    private a wtE;
    private boolean wtF = false;
    private e wtG;
    private boolean wtH = false;
    private boolean wtI = false;
    private i wtJ = new i(this);
    private k wtK;
    private j wtL;
    private f wtM;
    boolean wtN;
    private float wtO = 0.0f;
    boolean wtP = false;
    private boolean wtQ = false;
    public g wta;
    public l wtb;
    boolean wtc = true;
    private int wtd = 1;
    private int wte;
    private int wtf;
    private int wtg = 0;
    private View[] wth = new View[1];
    private d wti;
    private float wtj = 0.33333334f;
    private float wtk = 0.33333334f;
    private int wtl;
    private int wtm;
    private float wtn;
    private float wto;
    private float wtp;
    private float wtq;
    private float wtr = 0.5f;
    private c wts = new c(this) {
        final /* synthetic */ DragSortListView wtR;

        {
            this.wtR = r1;
        }

        public final float av(float f) {
            return this.wtR.wtr * f;
        }
    };
    private int wtt;
    private int wtu;
    private int wtv;
    private int wtw = 0;
    private boolean wtx = false;
    boolean wty = false;
    h wtz = null;

    private class a extends BaseAdapter {
        private ListAdapter FA;
        final /* synthetic */ DragSortListView wtR;

        public a(final DragSortListView dragSortListView, ListAdapter listAdapter) {
            this.wtR = dragSortListView;
            this.FA = listAdapter;
            this.FA.registerDataSetObserver(new DataSetObserver(this) {
                final /* synthetic */ a wtT;

                public final void onChanged() {
                    this.wtT.notifyDataSetChanged();
                }

                public final void onInvalidated() {
                    this.wtT.notifyDataSetInvalidated();
                }
            });
        }

        public final long getItemId(int i) {
            return this.FA.getItemId(i);
        }

        public final Object getItem(int i) {
            return this.FA.getItem(i);
        }

        public final int getCount() {
            return this.FA.getCount();
        }

        public final boolean areAllItemsEnabled() {
            return this.FA.areAllItemsEnabled();
        }

        public final boolean isEnabled(int i) {
            return this.FA.isEnabled(i);
        }

        public final int getItemViewType(int i) {
            return this.FA.getItemViewType(i);
        }

        public final int getViewTypeCount() {
            return this.FA.getViewTypeCount();
        }

        public final boolean hasStableIds() {
            return this.FA.hasStableIds();
        }

        public final boolean isEmpty() {
            return this.FA.isEmpty();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View childAt;
            View view2;
            if (view != null) {
                view = (b) view;
                childAt = view.getChildAt(0);
                view2 = this.FA.getView(i, childAt, this.wtR);
                if (view2 != childAt) {
                    if (childAt != null) {
                        view.removeViewAt(0);
                    }
                    view.addView(view2);
                }
            } else {
                view2 = this.FA.getView(i, null, this.wtR);
                if (view2 instanceof Checkable) {
                    childAt = new c(this.wtR.getContext());
                } else {
                    childAt = new b(this.wtR.getContext());
                }
                childAt.setLayoutParams(new LayoutParams(-1, -2));
                childAt.addView(view2);
                view = childAt;
            }
            this.wtR.a(this.wtR.getHeaderViewsCount() + i, view, true);
            return view;
        }
    }

    public interface b {
    }

    public interface c {
        float av(float f);
    }

    private class d implements Runnable {
        final /* synthetic */ DragSortListView wtR;
        private boolean wtU;
        private long wtV;
        private long wtW;
        private int wtX;
        private float wtY;
        private long wtZ;
        int wua;
        private float wub;
        boolean wuc = false;

        public d(DragSortListView dragSortListView) {
            this.wtR = dragSortListView;
        }

        public final void Co(int i) {
            if (!this.wuc) {
                this.wtU = false;
                this.wuc = true;
                this.wtZ = SystemClock.uptimeMillis();
                this.wtV = this.wtZ;
                this.wua = i;
                this.wtR.post(this);
            }
        }

        public final void caz() {
            this.wtR.removeCallbacks(this);
            this.wuc = false;
        }

        public final void run() {
            if (this.wtU) {
                this.wuc = false;
                return;
            }
            View childAt;
            int firstVisiblePosition = this.wtR.getFirstVisiblePosition();
            int lastVisiblePosition = this.wtR.getLastVisiblePosition();
            int count = this.wtR.getCount();
            int paddingTop = this.wtR.getPaddingTop();
            int height = (this.wtR.getHeight() - paddingTop) - this.wtR.getPaddingBottom();
            int min = Math.min(this.wtR.wtu, this.wtR.wsM + this.wtR.wtf);
            int max = Math.max(this.wtR.wtu, this.wtR.wsM - this.wtR.wtf);
            if (this.wua == 0) {
                childAt = this.wtR.getChildAt(0);
                if (childAt == null) {
                    this.wuc = false;
                    return;
                } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                    this.wuc = false;
                    return;
                } else {
                    this.wub = this.wtR.wts.av((this.wtR.wto - ((float) max)) / this.wtR.wtp);
                }
            } else {
                View childAt2 = this.wtR.getChildAt(lastVisiblePosition - firstVisiblePosition);
                if (childAt2 == null) {
                    this.wuc = false;
                    return;
                } else if (lastVisiblePosition != count - 1 || childAt2.getBottom() > height + paddingTop) {
                    this.wub = -this.wtR.wts.av((((float) min) - this.wtR.wtn) / this.wtR.wtq);
                } else {
                    this.wuc = false;
                    return;
                }
            }
            this.wtW = SystemClock.uptimeMillis();
            this.wtY = (float) (this.wtW - this.wtV);
            this.wtX = Math.round(this.wub * this.wtY);
            if (this.wtX >= 0) {
                this.wtX = Math.min(height, this.wtX);
                lastVisiblePosition = firstVisiblePosition;
            } else {
                this.wtX = Math.max(-height, this.wtX);
            }
            childAt = this.wtR.getChildAt(lastVisiblePosition - firstVisiblePosition);
            firstVisiblePosition = childAt.getTop() + this.wtX;
            if (lastVisiblePosition == 0 && firstVisiblePosition > paddingTop) {
                firstVisiblePosition = paddingTop;
            }
            this.wtR.wtH = true;
            this.wtR.setSelectionFromTop(lastVisiblePosition, firstVisiblePosition - paddingTop);
            this.wtR.layoutChildren();
            this.wtR.invalidate();
            this.wtR.wtH = false;
            this.wtR.c(lastVisiblePosition, childAt, false);
            this.wtV = this.wtW;
            this.wtR.post(this);
        }
    }

    private class e {
        File iyI = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
        StringBuilder mBuilder = new StringBuilder();
        final /* synthetic */ DragSortListView wtR;
        int wud = 0;
        int wue = 0;
        boolean wuf = false;

        public e(DragSortListView dragSortListView) {
            this.wtR = dragSortListView;
            if (!this.iyI.exists()) {
                try {
                    this.iyI.createNewFile();
                    w.d("mobeta", "file created");
                } catch (IOException e) {
                    w.w("mobeta", "Could not create dslv_state.txt");
                    w.d("mobeta", e.getMessage());
                }
            }
        }

        public final void flush() {
            FileWriter fileWriter;
            Throwable th;
            if (this.wuf) {
                FileWriter fileWriter2 = null;
                boolean z = true;
                try {
                    if (this.wue == 0) {
                        z = false;
                    }
                    fileWriter = new FileWriter(this.iyI, z);
                    try {
                        fileWriter.write(this.mBuilder.toString());
                        this.mBuilder.delete(0, this.mBuilder.length());
                        fileWriter.flush();
                        this.wue++;
                        try {
                            fileWriter.close();
                        } catch (IOException e) {
                        }
                    } catch (IOException e2) {
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (IOException e3) {
                            }
                        }
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        fileWriter2 = fileWriter;
                        th = th3;
                        if (fileWriter2 != null) {
                            try {
                                fileWriter2.close();
                            } catch (IOException e4) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException e5) {
                    fileWriter = null;
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    if (fileWriter2 != null) {
                        fileWriter2.close();
                    }
                    throw th;
                }
            }
        }
    }

    public interface g {
        void bQ(int i, int i2);
    }

    public interface h {
        View Cp(int i);

        void dD(View view);

        void e(Point point);
    }

    private class i {
        int uwD = 3;
        final /* synthetic */ DragSortListView wtR;
        SparseIntArray wuk = new SparseIntArray(3);
        ArrayList<Integer> wul = new ArrayList(3);

        public i(DragSortListView dragSortListView) {
            this.wtR = dragSortListView;
        }
    }

    public interface l {
        void remove(int i);
    }

    private class m implements Runnable {
        boolean RE;
        private float mAlpha = 0.5f;
        protected long mStartTime;
        final /* synthetic */ DragSortListView wtR;
        private float wuu;
        private float wuv;
        private float wuw;
        private float wux;
        private float wuy;

        public m(DragSortListView dragSortListView, float f, int i) {
            this.wtR = dragSortListView;
            this.wuu = (float) i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.wuy = f2;
            this.wuv = f2;
            this.wuw = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.wux = 1.0f / (1.0f - this.mAlpha);
        }

        public final void start() {
            this.mStartTime = SystemClock.uptimeMillis();
            this.RE = false;
            onStart();
            this.wtR.post(this);
        }

        public void onStart() {
        }

        public void aw(float f) {
        }

        public void onStop() {
        }

        public void run() {
            if (!this.RE) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.wuu;
                if (uptimeMillis >= 1.0f) {
                    aw(1.0f);
                    onStop();
                    return;
                }
                if (uptimeMillis < this.mAlpha) {
                    uptimeMillis *= this.wuv * uptimeMillis;
                } else if (uptimeMillis < 1.0f - this.mAlpha) {
                    uptimeMillis = (uptimeMillis * this.wux) + this.wuw;
                } else {
                    uptimeMillis = 1.0f - ((uptimeMillis - 1.0f) * (this.wuy * (uptimeMillis - 1.0f)));
                }
                aw(uptimeMillis);
                this.wtR.post(this);
            }
        }
    }

    private class f extends m {
        final /* synthetic */ DragSortListView wtR;
        private int wug;
        private int wuh;
        private float wui;
        private float wuj;

        public f(DragSortListView dragSortListView, int i) {
            this.wtR = dragSortListView;
            super(dragSortListView, 0.5f, i);
        }

        public final void onStart() {
            this.wug = this.wtR.wsQ;
            this.wuh = this.wtR.wsU;
            this.wtR.EK = 2;
            this.wui = (float) (this.wtR.wsK.y - caA());
            this.wuj = (float) (this.wtR.wsK.x - this.wtR.getPaddingLeft());
        }

        private int caA() {
            int j = (this.wtR.wtd + this.wtR.getDividerHeight()) / 2;
            View childAt = this.wtR.getChildAt(this.wug - this.wtR.getFirstVisiblePosition());
            if (childAt == null) {
                this.RE = true;
                return -1;
            } else if (this.wug == this.wuh) {
                return childAt.getTop();
            } else {
                if (this.wug < this.wuh) {
                    return childAt.getTop() - j;
                }
                return (childAt.getBottom() + j) - this.wtR.wte;
            }
        }

        public final void aw(float f) {
            int caA = caA();
            float paddingLeft = (float) (this.wtR.wsK.x - this.wtR.getPaddingLeft());
            float f2 = 1.0f - f;
            if (f2 < Math.abs(((float) (this.wtR.wsK.y - caA)) / this.wui) || f2 < Math.abs(paddingLeft / this.wuj)) {
                this.wtR.wsK.y = caA + ((int) (this.wui * f2));
                this.wtR.wsK.x = this.wtR.getPaddingLeft() + ((int) (this.wuj * f2));
                this.wtR.lR(true);
            }
        }

        public final void onStop() {
            this.wtR.cas();
        }
    }

    private class j extends m {
        final /* synthetic */ DragSortListView wtR;
        private float wum;
        private float wun;

        public final void onStart() {
            this.wum = (float) this.wtR.wsW;
            this.wun = (float) this.wtR.wtf;
        }

        public final void aw(float f) {
            if (this.wtR.EK != 4) {
                this.RE = true;
                return;
            }
            this.wtR.wsW = (int) ((this.wun * f) + ((1.0f - f) * this.wum));
            this.wtR.wsK.y = this.wtR.wtu - this.wtR.wsW;
            this.wtR.lR(true);
        }
    }

    private class k extends m {
        private int kwz;
        final /* synthetic */ DragSortListView wtR;
        private int wuh;
        private float wuo;
        private float wup;
        private float wuq;
        private int wur = -1;
        private int wus = -1;
        private int wut;

        public k(DragSortListView dragSortListView, int i) {
            this.wtR = dragSortListView;
            super(dragSortListView, 0.5f, i);
        }

        public final void onStart() {
            int i = -1;
            this.wur = -1;
            this.wus = -1;
            this.kwz = this.wtR.wsR;
            this.wut = this.wtR.wsS;
            this.wuh = this.wtR.wsU;
            this.wtR.EK = 1;
            this.wuo = (float) this.wtR.wsK.x;
            if (this.wtR.wtN) {
                float width = ((float) this.wtR.getWidth()) * 2.0f;
                if (this.wtR.wtO == 0.0f) {
                    DragSortListView dragSortListView = this.wtR;
                    if (this.wuo >= 0.0f) {
                        i = 1;
                    }
                    dragSortListView.wtO = ((float) i) * width;
                    return;
                }
                float f = width * 2.0f;
                if (this.wtR.wtO < 0.0f && this.wtR.wtO > (-f)) {
                    this.wtR.wtO = -f;
                    return;
                } else if (this.wtR.wtO > 0.0f && this.wtR.wtO < f) {
                    this.wtR.wtO = f;
                    return;
                } else {
                    return;
                }
            }
            this.wtR.cay();
        }

        public final void aw(float f) {
            float f2 = 1.0f - f;
            int firstVisiblePosition = this.wtR.getFirstVisiblePosition();
            View childAt = this.wtR.getChildAt(this.kwz - firstVisiblePosition);
            if (this.wtR.wtN) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float p = this.wtR.wtO * uptimeMillis;
                    int width = this.wtR.getWidth();
                    this.wtR.wtO = ((((float) (this.wtR.wtO > 0.0f ? 1 : -1)) * uptimeMillis) * ((float) width)) + this.wtR.wtO;
                    this.wuo += p;
                    this.wtR.wsK.x = (int) this.wuo;
                    if (this.wuo < ((float) width) && this.wuo > ((float) (-width))) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        this.wtR.lR(true);
                        return;
                    }
                }
                return;
            }
            if (childAt != null) {
                if (this.wur == -1) {
                    this.wur = this.wtR.b(this.kwz, childAt, false);
                    this.wup = (float) (childAt.getHeight() - this.wur);
                }
                int max = Math.max((int) (this.wup * f2), 1);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                layoutParams.height = max + this.wur;
                childAt.setLayoutParams(layoutParams);
            }
            if (this.wut != this.kwz) {
                View childAt2 = this.wtR.getChildAt(this.wut - firstVisiblePosition);
                if (childAt2 != null) {
                    if (this.wus == -1) {
                        this.wus = this.wtR.b(this.wut, childAt2, false);
                        this.wuq = (float) (childAt2.getHeight() - this.wus);
                    }
                    int max2 = Math.max((int) (this.wuq * f2), 1);
                    ViewGroup.LayoutParams layoutParams2 = childAt2.getLayoutParams();
                    layoutParams2.height = max2 + this.wus;
                    childAt2.setLayoutParams(layoutParams2);
                }
            }
        }

        public final void onStop() {
            this.wtR.Cm(this.wtR.wsU - this.wtR.getHeaderViewsCount());
        }
    }

    public DragSortListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i = ck.CTRL_INDEX;
        int i2 = ck.CTRL_INDEX;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.tencent.mm.bm.a.j.fpO, 0, 0);
            this.wtd = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(com.tencent.mm.bm.a.j.wAV, 1));
            this.wtF = obtainStyledAttributes.getBoolean(com.tencent.mm.bm.a.j.wBk, false);
            if (this.wtF) {
                this.wtG = new e(this);
            }
            this.wsO = obtainStyledAttributes.getFloat(com.tencent.mm.bm.a.j.wBc, this.wsO);
            this.wsP = this.wsO;
            this.wtc = obtainStyledAttributes.getBoolean(com.tencent.mm.bm.a.j.wAW, this.wtc);
            this.wtC = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(com.tencent.mm.bm.a.j.wBi, 0.75f)));
            this.wsT = this.wtC > 0.0f;
            float f = obtainStyledAttributes.getFloat(com.tencent.mm.bm.a.j.wAY, this.wtj);
            if (f > 0.5f) {
                this.wtk = 0.5f;
            } else {
                this.wtk = f;
            }
            if (f > 0.5f) {
                this.wtj = 0.5f;
            } else {
                this.wtj = f;
            }
            if (getHeight() != 0) {
                cav();
            }
            this.wtr = obtainStyledAttributes.getFloat(com.tencent.mm.bm.a.j.wBe, this.wtr);
            int i3 = obtainStyledAttributes.getInt(com.tencent.mm.bm.a.j.wBf, ck.CTRL_INDEX);
            int i4 = obtainStyledAttributes.getInt(com.tencent.mm.bm.a.j.wBa, ck.CTRL_INDEX);
            if (obtainStyledAttributes.getBoolean(com.tencent.mm.bm.a.j.wBl, true)) {
                boolean z = obtainStyledAttributes.getBoolean(com.tencent.mm.bm.a.j.wBg, false);
                int i5 = obtainStyledAttributes.getInt(com.tencent.mm.bm.a.j.wBh, 1);
                boolean z2 = obtainStyledAttributes.getBoolean(com.tencent.mm.bm.a.j.wBj, true);
                int i6 = obtainStyledAttributes.getInt(com.tencent.mm.bm.a.j.wAZ, 0);
                int resourceId = obtainStyledAttributes.getResourceId(com.tencent.mm.bm.a.j.wAX, 0);
                int resourceId2 = obtainStyledAttributes.getResourceId(com.tencent.mm.bm.a.j.wBb, 0);
                int resourceId3 = obtainStyledAttributes.getResourceId(com.tencent.mm.bm.a.j.wAU, 0);
                int color = obtainStyledAttributes.getColor(com.tencent.mm.bm.a.j.wBd, WebView.NIGHT_MODE_COLOR);
                Object aVar = new a(this, resourceId, i6, i5, resourceId3, resourceId2);
                aVar.wsq = z;
                aVar.wsp = z2;
                aVar.wxy = color;
                this.wtz = aVar;
                setOnTouchListener(aVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i4;
            i = i3;
        }
        this.wti = new d(this);
        if (i > 0) {
            this.wtK = new k(this, i);
        }
        if (i2 > 0) {
            this.wtM = new f(this, i2);
        }
        this.wtA = MotionEvent.obtain(0, 0, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        this.mObserver = new DataSetObserver(this) {
            final /* synthetic */ DragSortListView wtR;

            {
                this.wtR = r1;
            }

            private void cancel() {
                if (this.wtR.EK == 4) {
                    this.wtR.caq();
                }
            }

            public final void onChanged() {
                cancel();
            }

            public final void onInvalidated() {
                cancel();
            }
        };
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.wtE = new a(this, listAdapter);
            listAdapter.registerDataSetObserver(this.mObserver);
            if (listAdapter instanceof g) {
                this.wta = (g) listAdapter;
            }
            if (listAdapter instanceof b) {
                this.wsZ = (b) listAdapter;
            }
            if (listAdapter instanceof l) {
                this.wtb = (l) listAdapter;
            }
        } else {
            this.wtE = null;
        }
        super.setAdapter(this.wtE);
    }

    private void a(int i, Canvas canvas) {
        Drawable divider = getDivider();
        int dividerHeight = getDividerHeight();
        if (divider != null && dividerHeight != 0) {
            ViewGroup viewGroup = (ViewGroup) getChildAt(i - getFirstVisiblePosition());
            if (viewGroup != null) {
                int i2;
                int paddingLeft = getPaddingLeft();
                int width = getWidth() - getPaddingRight();
                int height = viewGroup.getChildAt(0).getHeight();
                if (i > this.wsU) {
                    height += viewGroup.getTop();
                    i2 = height + dividerHeight;
                } else {
                    i2 = viewGroup.getBottom() - height;
                    height = i2 - dividerHeight;
                }
                canvas.save();
                canvas.clipRect(paddingLeft, height, width, i2);
                divider.setBounds(paddingLeft, height, width, i2);
                divider.draw(canvas);
                canvas.restore();
            }
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.EK != 0) {
            if (this.wsR != this.wsU) {
                a(this.wsR, canvas);
            }
            if (!(this.wsS == this.wsR || this.wsS == this.wsU)) {
                a(this.wsS, canvas);
            }
        }
        if (this.wsJ != null) {
            float f;
            int width = this.wsJ.getWidth();
            int height = this.wsJ.getHeight();
            int i = this.wsK.x;
            int width2 = getWidth();
            if (i < 0) {
                i = -i;
            }
            if (i < width2) {
                f = ((float) (width2 - i)) / ((float) width2);
                f *= f;
            } else {
                f = 0.0f;
            }
            int i2 = (int) (f * (255.0f * this.wsP));
            canvas.save();
            canvas.translate((float) this.wsK.x, (float) this.wsK.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, (float) width, (float) height, i2, 31);
            this.wsJ.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    private int Cl(int i) {
        View childAt = getChildAt(i - getFirstVisiblePosition());
        if (childAt != null) {
            return childAt.getHeight();
        }
        return eo(i, Cn(i));
    }

    private int en(int i, int i2) {
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        if (i <= headerViewsCount || i >= getCount() - footerViewsCount) {
            return i2;
        }
        headerViewsCount = getDividerHeight();
        footerViewsCount = this.wte - this.wtd;
        int Cn = Cn(i);
        int Cl = Cl(i);
        if (this.wsS <= this.wsU) {
            if (i != this.wsS || this.wsR == this.wsS) {
                if (i > this.wsS && i <= this.wsU) {
                    i2 -= footerViewsCount;
                }
            } else if (i == this.wsU) {
                i2 = (i2 + Cl) - this.wte;
            } else {
                i2 = ((Cl - Cn) + i2) - footerViewsCount;
            }
        } else if (i > this.wsU && i <= this.wsR) {
            i2 += footerViewsCount;
        } else if (i == this.wsS && this.wsR != this.wsS) {
            i2 += Cl - Cn;
        }
        if (i <= this.wsU) {
            return (((this.wte - headerViewsCount) - Cn(i - 1)) / 2) + i2;
        }
        return (((Cn - headerViewsCount) - this.wte) / 2) + i2;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.wtF) {
            e eVar = this.wtG;
            if (eVar.wuf) {
                int i;
                eVar.mBuilder.append("<DSLVState>\n");
                int childCount = eVar.wtR.getChildCount();
                int firstVisiblePosition = eVar.wtR.getFirstVisiblePosition();
                eVar.mBuilder.append("    <Positions>");
                for (i = 0; i < childCount; i++) {
                    eVar.mBuilder.append(firstVisiblePosition + i).append(",");
                }
                eVar.mBuilder.append("</Positions>\n");
                eVar.mBuilder.append("    <Tops>");
                for (i = 0; i < childCount; i++) {
                    eVar.mBuilder.append(eVar.wtR.getChildAt(i).getTop()).append(",");
                }
                eVar.mBuilder.append("</Tops>\n");
                eVar.mBuilder.append("    <Bottoms>");
                for (i = 0; i < childCount; i++) {
                    eVar.mBuilder.append(eVar.wtR.getChildAt(i).getBottom()).append(",");
                }
                eVar.mBuilder.append("</Bottoms>\n");
                eVar.mBuilder.append("    <FirstExpPos>").append(eVar.wtR.wsR).append("</FirstExpPos>\n");
                eVar.mBuilder.append("    <FirstExpBlankHeight>").append(eVar.wtR.Cl(eVar.wtR.wsR) - eVar.wtR.Cn(eVar.wtR.wsR)).append("</FirstExpBlankHeight>\n");
                eVar.mBuilder.append("    <SecondExpPos>").append(eVar.wtR.wsS).append("</SecondExpPos>\n");
                eVar.mBuilder.append("    <SecondExpBlankHeight>").append(eVar.wtR.Cl(eVar.wtR.wsS) - eVar.wtR.Cn(eVar.wtR.wsS)).append("</SecondExpBlankHeight>\n");
                eVar.mBuilder.append("    <SrcPos>").append(eVar.wtR.wsU).append("</SrcPos>\n");
                eVar.mBuilder.append("    <SrcHeight>").append(eVar.wtR.wte + eVar.wtR.getDividerHeight()).append("</SrcHeight>\n");
                eVar.mBuilder.append("    <ViewHeight>").append(eVar.wtR.getHeight()).append("</ViewHeight>\n");
                eVar.mBuilder.append("    <LastY>").append(eVar.wtR.jdF).append("</LastY>\n");
                eVar.mBuilder.append("    <FloatY>").append(eVar.wtR.wsM).append("</FloatY>\n");
                eVar.mBuilder.append("    <ShuffleEdges>");
                for (i = 0; i < childCount; i++) {
                    eVar.mBuilder.append(eVar.wtR.en(firstVisiblePosition + i, eVar.wtR.getChildAt(i).getTop())).append(",");
                }
                eVar.mBuilder.append("</ShuffleEdges>\n");
                eVar.mBuilder.append("</DSLVState>\n");
                eVar.wud++;
                if (eVar.wud > 1000) {
                    eVar.flush();
                    eVar.wud = 0;
                }
            }
        }
    }

    public final void l(int i, float f) {
        if (this.EK == 0 || this.EK == 4) {
            if (this.EK == 0) {
                this.wsU = getHeaderViewsCount() + i;
                this.wsR = this.wsU;
                this.wsS = this.wsU;
                this.wsQ = this.wsU;
                View childAt = getChildAt(this.wsU - getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.EK = 1;
            this.wtO = f;
            if (this.wty) {
                switch (this.wtB) {
                    case 1:
                        super.onTouchEvent(this.wtA);
                        break;
                    case 2:
                        super.onInterceptTouchEvent(this.wtA);
                        break;
                }
            }
            if (this.wtK != null) {
                this.wtK.start();
            } else {
                Cm(i);
            }
        }
    }

    public final void caq() {
        if (this.EK == 4) {
            this.wti.caz();
            cay();
            car();
            caw();
            if (this.wty) {
                this.EK = 3;
            } else {
                this.EK = 0;
            }
        }
    }

    private void car() {
        this.wsU = -1;
        this.wsR = -1;
        this.wsS = -1;
        this.wsQ = -1;
    }

    private void cas() {
        this.EK = 2;
        if (this.wta != null && this.wsQ >= 0 && this.wsQ < getCount()) {
            int headerViewsCount = getHeaderViewsCount();
            this.wta.bQ(this.wsU - headerViewsCount, this.wsQ - headerViewsCount);
        }
        cay();
        cat();
        car();
        caw();
        if (this.wty) {
            this.EK = 3;
        } else {
            this.EK = 0;
        }
    }

    private void Cm(int i) {
        this.EK = 1;
        if (this.wtb != null) {
            this.wtb.remove(i);
        }
        cay();
        cat();
        car();
        if (this.wty) {
            this.EK = 3;
        } else {
            this.EK = 0;
        }
    }

    private void cat() {
        int i = 0;
        int firstVisiblePosition = getFirstVisiblePosition();
        if (this.wsU < firstVisiblePosition) {
            View childAt = getChildAt(0);
            if (childAt != null) {
                i = childAt.getTop();
            }
            setSelectionFromTop(firstVisiblePosition - 1, i - getPaddingTop());
        }
    }

    public final boolean au(float f) {
        this.wtN = true;
        return b(true, f);
    }

    private boolean b(boolean z, float f) {
        if (this.wsJ == null) {
            return false;
        }
        this.wti.caz();
        if (z) {
            l(this.wsU - getHeaderViewsCount(), f);
        } else if (this.wtM != null) {
            this.wtM.start();
        } else {
            cas();
        }
        if (this.wtF) {
            e eVar = this.wtG;
            if (eVar.wuf) {
                eVar.mBuilder.append("</DSLVStates>\n");
                eVar.flush();
                eVar.wuf = false;
            }
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.wtI) {
            this.wtI = false;
            return false;
        } else if (!this.wtc) {
            return super.onTouchEvent(motionEvent);
        } else {
            boolean z = this.wtx;
            this.wtx = false;
            if (!z) {
                I(motionEvent);
            }
            if (this.EK != 4) {
                if (this.EK == 0 && super.onTouchEvent(motionEvent)) {
                    z = true;
                } else {
                    z = false;
                }
                switch (motionEvent.getAction() & 255) {
                    case 1:
                    case 3:
                        cau();
                        break;
                    default:
                        if (z) {
                            this.wtB = 1;
                            break;
                        }
                        break;
                }
            }
            motionEvent.getAction();
            switch (motionEvent.getAction() & 255) {
                case 1:
                    if (this.EK == 4) {
                        this.wtN = false;
                        b(false, 0.0f);
                    }
                    cau();
                    break;
                case 2:
                    int y = (int) motionEvent.getY();
                    this.wsK.x = ((int) motionEvent.getX()) - this.wsV;
                    this.wsK.y = y - this.wsW;
                    lR(true);
                    int min = Math.min(y, this.wsM + this.wtf);
                    y = Math.max(y, this.wsM - this.wtf);
                    d dVar = this.wti;
                    int i = dVar.wuc ? dVar.wua : -1;
                    if (min <= this.jdF || min <= this.wtm || i == 1) {
                        if (y >= this.jdF || y >= this.wtl || i == 0) {
                            if (y >= this.wtl && min <= this.wtm && this.wti.wuc) {
                                this.wti.caz();
                                break;
                            }
                        }
                        if (i != -1) {
                            this.wti.caz();
                        }
                        this.wti.Co(0);
                        break;
                    }
                    if (i != -1) {
                        this.wti.caz();
                    }
                    this.wti.Co(1);
                    break;
                    break;
                case 3:
                    if (this.EK == 4) {
                        caq();
                    }
                    cau();
                    break;
            }
            z = true;
            return z;
        }
    }

    private void cau() {
        this.wtB = 0;
        this.wty = false;
        if (this.EK == 3) {
            this.EK = 0;
        }
        this.wsP = this.wsO;
        this.wtP = false;
        i iVar = this.wtJ;
        iVar.wuk.clear();
        iVar.wul.clear();
    }

    private void I(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.jdE = this.wtt;
            this.jdF = this.wtu;
        }
        this.wtt = (int) motionEvent.getX();
        this.wtu = (int) motionEvent.getY();
        if (action == 0) {
            this.jdE = this.wtt;
            this.jdF = this.wtu;
        }
        this.wsX = ((int) motionEvent.getRawX()) - this.wtt;
        this.wsY = ((int) motionEvent.getRawY()) - this.wtu;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.wtc) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        boolean z;
        I(motionEvent);
        this.wtx = true;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.EK != 0) {
                this.wtI = true;
                return true;
            }
            this.wty = true;
        }
        if (this.wsJ == null) {
            if (super.onInterceptTouchEvent(motionEvent)) {
                this.wtP = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    cau();
                    break;
                default:
                    if (!z) {
                        this.wtB = 2;
                        break;
                    }
                    this.wtB = 1;
                    break;
            }
        }
        z = true;
        if (action == 1 || action == 3) {
            this.wty = false;
        }
        return z;
    }

    private void cav() {
        int paddingTop = getPaddingTop();
        int height = (getHeight() - paddingTop) - getPaddingBottom();
        float f = (float) height;
        this.wto = ((float) paddingTop) + (this.wtj * f);
        this.wtn = (f * (1.0f - this.wtk)) + ((float) paddingTop);
        this.wtl = (int) this.wto;
        this.wtm = (int) this.wtn;
        this.wtp = this.wto - ((float) paddingTop);
        this.wtq = ((float) (paddingTop + height)) - this.wtn;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        cav();
    }

    private void caw() {
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        lastVisiblePosition = Math.min(lastVisiblePosition - firstVisiblePosition, ((getCount() - 1) - getFooterViewsCount()) - firstVisiblePosition);
        for (int max = Math.max(0, getHeaderViewsCount() - firstVisiblePosition); max <= lastVisiblePosition; max++) {
            View childAt = getChildAt(max);
            if (childAt != null) {
                a(firstVisiblePosition + max, childAt, false);
            }
        }
    }

    private void a(int i, View view, boolean z) {
        int eo;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (i == this.wsU || i == this.wsR || i == this.wsS) {
            eo = eo(i, b(i, view, z));
        } else {
            eo = -2;
        }
        if (eo != layoutParams.height) {
            layoutParams.height = eo;
            view.setLayoutParams(layoutParams);
        }
        if (i == this.wsR || i == this.wsS) {
            if (i < this.wsU) {
                ((b) view).tW = 80;
            } else if (i > this.wsU) {
                ((b) view).tW = 48;
            }
        }
        int visibility = view.getVisibility();
        eo = 0;
        if (i == this.wsU && this.wsJ != null) {
            eo = 4;
        }
        if (eo != visibility) {
            view.setVisibility(eo);
        }
    }

    private int Cn(int i) {
        if (i == this.wsU) {
            return 0;
        }
        View childAt = getChildAt(i - getFirstVisiblePosition());
        if (childAt != null) {
            return b(i, childAt, false);
        }
        int i2 = this.wtJ.wuk.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        ListAdapter adapter = getAdapter();
        int itemViewType = adapter.getItemViewType(i);
        int viewTypeCount = adapter.getViewTypeCount();
        if (viewTypeCount != this.wth.length) {
            this.wth = new View[viewTypeCount];
        }
        if (itemViewType < 0) {
            childAt = adapter.getView(i, null, this);
        } else if (this.wth[itemViewType] == null) {
            childAt = adapter.getView(i, null, this);
            this.wth[itemViewType] = childAt;
        } else {
            childAt = adapter.getView(i, this.wth[itemViewType], this);
        }
        itemViewType = b(i, childAt, true);
        i iVar = this.wtJ;
        i2 = iVar.wuk.get(i, -1);
        if (i2 != itemViewType) {
            if (i2 != -1) {
                iVar.wul.remove(Integer.valueOf(i));
            } else if (iVar.wuk.size() == iVar.uwD) {
                iVar.wuk.delete(((Integer) iVar.wul.remove(0)).intValue());
            }
            iVar.wuk.put(i, itemViewType);
            iVar.wul.add(Integer.valueOf(i));
        }
        return itemViewType;
    }

    private int b(int i, View view, boolean z) {
        if (i == this.wsU) {
            return 0;
        }
        if (i >= getHeaderViewsCount() && i < getCount() - getFooterViewsCount()) {
            view = ((ViewGroup) view).getChildAt(0);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null && layoutParams.height > 0) {
            return layoutParams.height;
        }
        int height = view.getHeight();
        if (height != 0 && !z) {
            return height;
        }
        dC(view);
        return view.getMeasuredHeight();
    }

    private int eo(int i, int i2) {
        getDividerHeight();
        Object obj = (!this.wsT || this.wsR == this.wsS) ? null : 1;
        int i3 = this.wte - this.wtd;
        int i4 = (int) (this.wtD * ((float) i3));
        if (i == this.wsU) {
            if (this.wsU == this.wsR) {
                if (obj != null) {
                    return i4 + this.wtd;
                }
                return this.wte;
            } else if (this.wsU == this.wsS) {
                return this.wte - i4;
            } else {
                return this.wtd;
            }
        } else if (i == this.wsR) {
            if (obj != null) {
                return i2 + i4;
            }
            return i2 + i3;
        } else if (i == this.wsS) {
            return (i2 + i3) - i4;
        } else {
            return i2;
        }
    }

    public void requestLayout() {
        if (!this.wtH) {
            super.requestLayout();
        }
    }

    private void dC(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -2);
            view.setLayoutParams(layoutParams);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.wtg, getListPaddingLeft() + getListPaddingRight(), layoutParams.width);
        if (layoutParams.height > 0) {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
        } else {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    private void cax() {
        if (this.wsJ != null) {
            dC(this.wsJ);
            this.wte = this.wsJ.getMeasuredHeight();
            this.wtf = this.wte / 2;
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.wsJ != null) {
            if (this.wsJ.isLayoutRequested()) {
                cax();
            }
            this.wsN = true;
        }
        this.wtg = i;
    }

    protected void layoutChildren() {
        super.layoutChildren();
        if (this.wsJ != null) {
            if (this.wsJ.isLayoutRequested() && !this.wsN) {
                cax();
            }
            this.wsJ.layout(0, 0, this.wsJ.getMeasuredWidth(), this.wsJ.getMeasuredHeight());
            this.wsN = false;
        }
    }

    public final boolean a(int i, View view, int i2, int i3, int i4) {
        if (this.EK != 0 || !this.wty || this.wsJ != null || view == null || !this.wtc) {
            return false;
        }
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        int headerViewsCount = getHeaderViewsCount() + i;
        this.wsR = headerViewsCount;
        this.wsS = headerViewsCount;
        this.wsU = headerViewsCount;
        this.wsQ = headerViewsCount;
        this.EK = 4;
        this.wtw = 0;
        this.wtw |= i2;
        this.wsJ = view;
        cax();
        this.wsV = i3;
        this.wsW = i4;
        this.wtv = this.wtu;
        this.wsK.x = this.wtt - this.wsV;
        this.wsK.y = this.wtu - this.wsW;
        View childAt = getChildAt(this.wsU - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setVisibility(4);
        }
        if (this.wtF) {
            e eVar = this.wtG;
            eVar.mBuilder.append("<DSLVStates>\n");
            eVar.wue = 0;
            eVar.wuf = true;
        }
        switch (this.wtB) {
            case 1:
                super.onTouchEvent(this.wtA);
                break;
            case 2:
                super.onInterceptTouchEvent(this.wtA);
                break;
        }
        requestLayout();
        if (this.wtL == null) {
            return true;
        }
        this.wtL.start();
        return true;
    }

    private void lR(boolean z) {
        int firstVisiblePosition = getFirstVisiblePosition() + (getChildCount() / 2);
        View childAt = getChildAt(getChildCount() / 2);
        if (childAt != null) {
            c(firstVisiblePosition, childAt, true);
        }
    }

    private void c(int i, View view, boolean z) {
        int count;
        Object obj;
        Object obj2;
        this.wtH = true;
        if (this.wtz != null) {
            this.wsL.set(this.wtt, this.wtu);
            this.wtz.e(this.wsK);
        }
        int i2 = this.wsK.x;
        int i3 = this.wsK.y;
        int paddingLeft = getPaddingLeft();
        if ((this.wtw & 1) == 0 && i2 > paddingLeft) {
            this.wsK.x = paddingLeft;
        } else if ((this.wtw & 2) == 0 && i2 < paddingLeft) {
            this.wsK.x = paddingLeft;
        }
        paddingLeft = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        i2 = getPaddingTop();
        if (firstVisiblePosition < paddingLeft) {
            i2 = getChildAt((paddingLeft - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.wtw & 8) == 0 && firstVisiblePosition <= this.wsU) {
            i2 = Math.max(getChildAt(this.wsU - firstVisiblePosition).getTop(), i2);
        }
        paddingLeft = getHeight() - getPaddingBottom();
        if (lastVisiblePosition >= (getCount() - footerViewsCount) - 1) {
            paddingLeft = getChildAt(((getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.wtw & 4) == 0 && lastVisiblePosition >= this.wsU) {
            paddingLeft = Math.min(getChildAt(this.wsU - firstVisiblePosition).getBottom(), paddingLeft);
        }
        if (i3 < i2) {
            this.wsK.y = i2;
        } else if (this.wte + i3 > paddingLeft) {
            this.wsK.y = paddingLeft - this.wte;
        }
        this.wsM = this.wsK.y + this.wtf;
        int i4 = this.wsR;
        int i5 = this.wsS;
        i3 = getFirstVisiblePosition();
        paddingLeft = this.wsR;
        View childAt = getChildAt(paddingLeft - i3);
        if (childAt == null) {
            paddingLeft = i3 + (getChildCount() / 2);
            childAt = getChildAt(paddingLeft - i3);
        }
        footerViewsCount = childAt.getTop();
        i2 = childAt.getHeight();
        i3 = en(paddingLeft, footerViewsCount);
        lastVisiblePosition = getDividerHeight();
        if (this.wsM >= i3) {
            count = getCount();
            firstVisiblePosition = footerViewsCount;
            footerViewsCount = i2;
            i2 = paddingLeft;
            paddingLeft = i3;
            while (i2 < count) {
                if (i2 != count - 1) {
                    firstVisiblePosition += lastVisiblePosition + footerViewsCount;
                    footerViewsCount = Cl(i2 + 1);
                    i3 = en(i2 + 1, firstVisiblePosition);
                    if (this.wsM < i3) {
                        break;
                    }
                    i2++;
                    paddingLeft = i3;
                } else {
                    i3 = (firstVisiblePosition + lastVisiblePosition) + footerViewsCount;
                    break;
                }
            }
        }
        i2 = paddingLeft;
        paddingLeft = i3;
        while (i2 >= 0) {
            i2--;
            i3 = Cl(i2);
            if (i2 != 0) {
                footerViewsCount -= i3 + lastVisiblePosition;
                i3 = en(i2, footerViewsCount);
                if (this.wsM >= i3) {
                    break;
                }
                paddingLeft = i3;
            } else {
                i3 = (footerViewsCount - lastVisiblePosition) - i3;
                break;
            }
        }
        footerViewsCount = getHeaderViewsCount();
        lastVisiblePosition = getFooterViewsCount();
        count = this.wsR;
        int i6 = this.wsS;
        float f = this.wtD;
        if (this.wsT) {
            int abs = Math.abs(i3 - paddingLeft);
            if (this.wsM >= i3) {
                int i7 = i3;
                i3 = paddingLeft;
                paddingLeft = i7;
            }
            abs = (int) (((float) abs) * (0.5f * this.wtC));
            float f2 = (float) abs;
            paddingLeft += abs;
            abs = i3 - abs;
            if (this.wsM < paddingLeft) {
                this.wsR = i2 - 1;
                this.wsS = i2;
                this.wtD = (((float) (paddingLeft - this.wsM)) * 0.5f) / f2;
            } else if (this.wsM >= abs) {
                this.wsR = i2;
                this.wsS = i2 + 1;
                this.wtD = 0.5f * ((((float) (i3 - this.wsM)) / f2) + 1.0f);
            }
            if (this.wsR < footerViewsCount) {
                this.wsR = footerViewsCount;
                this.wsS = footerViewsCount;
                i2 = footerViewsCount;
            } else if (this.wsS >= getCount() - lastVisiblePosition) {
                i2 = (getCount() - lastVisiblePosition) - 1;
                this.wsR = i2;
                this.wsS = i2;
            }
            if (this.wsR != count && this.wsS == i6 && this.wtD == f) {
                obj = null;
            } else {
                obj = 1;
            }
            if (i2 == this.wsQ) {
                this.wsQ = i2;
                obj2 = 1;
            } else {
                obj2 = obj;
            }
            if (obj2 != null) {
                caw();
                i3 = Cn(i);
                paddingLeft = view.getHeight();
                footerViewsCount = eo(i, i3);
                if (i == this.wsU) {
                    i2 = paddingLeft - i3;
                    i3 = footerViewsCount - i3;
                } else {
                    i2 = paddingLeft;
                    i3 = footerViewsCount;
                }
                lastVisiblePosition = this.wte;
                if (!(this.wsU == this.wsR || this.wsU == this.wsS)) {
                    lastVisiblePosition -= this.wtd;
                }
                if (i <= i4) {
                    if (i > this.wsR) {
                        i2 = (lastVisiblePosition - i3) + 0;
                    }
                    i2 = 0;
                } else if (i != i5) {
                    i2 = i > this.wsR ? (i2 - lastVisiblePosition) + 0 : i != this.wsS ? (paddingLeft - footerViewsCount) + 0 : i2 + 0;
                } else if (i > this.wsR) {
                    i2 = 0 - lastVisiblePosition;
                } else {
                    if (i == this.wsS) {
                        i2 = 0 - i3;
                    }
                    i2 = 0;
                }
                setSelectionFromTop(i, (i2 + view.getTop()) - getPaddingTop());
                layoutChildren();
            }
            if (obj2 != null || z) {
                invalidate();
            }
            this.wtH = false;
        }
        this.wsR = i2;
        this.wsS = i2;
        if (this.wsR < footerViewsCount) {
            this.wsR = footerViewsCount;
            this.wsS = footerViewsCount;
            i2 = footerViewsCount;
        } else if (this.wsS >= getCount() - lastVisiblePosition) {
            i2 = (getCount() - lastVisiblePosition) - 1;
            this.wsR = i2;
            this.wsS = i2;
        }
        if (this.wsR != count) {
        }
        obj = 1;
        if (i2 == this.wsQ) {
            obj2 = obj;
        } else {
            this.wsQ = i2;
            obj2 = 1;
        }
        if (obj2 != null) {
            caw();
            i3 = Cn(i);
            paddingLeft = view.getHeight();
            footerViewsCount = eo(i, i3);
            if (i == this.wsU) {
                i2 = paddingLeft;
                i3 = footerViewsCount;
            } else {
                i2 = paddingLeft - i3;
                i3 = footerViewsCount - i3;
            }
            lastVisiblePosition = this.wte;
            lastVisiblePosition -= this.wtd;
            if (i <= i4) {
                if (i > this.wsR) {
                    i2 = (lastVisiblePosition - i3) + 0;
                }
                i2 = 0;
            } else if (i != i5) {
                if (i > this.wsR) {
                    if (i == this.wsS) {
                        i2 = 0 - i3;
                    }
                    i2 = 0;
                } else {
                    i2 = 0 - lastVisiblePosition;
                }
            } else if (i > this.wsR) {
                if (i != this.wsS) {
                }
            }
            setSelectionFromTop(i, (i2 + view.getTop()) - getPaddingTop());
            layoutChildren();
        }
        invalidate();
        this.wtH = false;
    }

    private void cay() {
        if (this.wsJ != null) {
            this.wsJ.setVisibility(8);
            if (this.wtz != null) {
                this.wtz.dD(this.wsJ);
            }
            this.wsJ = null;
            invalidate();
        }
    }
}
