package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.view.ai;
import android.support.v4.view.o;
import android.support.v4.view.z;
import android.support.v4.widget.k;
import android.support.v4.widget.m;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import java.lang.reflect.Method;

public class ListPopupWindow {
    private static Method XS;
    private static Method XT;
    private ListAdapter FA;
    public int Rr;
    int Vf;
    private int WV;
    public PopupWindow XU;
    public a XV;
    private int XW;
    int XX;
    int XY;
    private int XZ;
    boolean Ya;
    private boolean Yb;
    private boolean Yc;
    int Yd;
    private View Ye;
    int Yf;
    public View Yg;
    private Drawable Yh;
    public OnItemClickListener Yi;
    private OnItemSelectedListener Yj;
    public final g Yk;
    private final f Yl;
    private final e Ym;
    private final c Yn;
    private Runnable Yo;
    private boolean Yp;
    private Rect eq;
    private Context mContext;
    public final Handler mHandler;
    private DataSetObserver mObserver;

    public static abstract class b implements OnTouchListener {
        private Runnable YA;
        private Runnable YB;
        boolean YC;
        boolean YD;
        private final int[] YE = new int[2];
        private final float Yw;
        private final int Yx;
        private final int Yy;
        public final View Yz;
        private int fl;

        private class a implements Runnable {
            final /* synthetic */ b YF;

            public a(b bVar) {
                this.YF = bVar;
            }

            public final void run() {
                this.YF.Yz.getParent().requestDisallowInterceptTouchEvent(true);
            }
        }

        private class b implements Runnable {
            final /* synthetic */ b YF;

            public b(b bVar) {
                this.YF = bVar;
            }

            public final void run() {
                b bVar = this.YF;
                bVar.fh();
                View view = bVar.Yz;
                if (view.isEnabled() && !view.isLongClickable() && bVar.dp()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    view.onTouchEvent(obtain);
                    obtain.recycle();
                    bVar.YC = true;
                    bVar.YD = true;
                }
            }
        }

        public abstract ListPopupWindow do();

        public b(View view) {
            this.Yz = view;
            this.Yw = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.Yx = ViewConfiguration.getTapTimeout();
            this.Yy = (this.Yx + ViewConfiguration.getLongPressTimeout()) / 2;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouch(android.view.View r12, android.view.MotionEvent r13) {
            /*
            r11 = this;
            r5 = 0;
            r8 = 1;
            r7 = 0;
            r10 = r11.YC;
            if (r10 == 0) goto L_0x0027;
        L_0x0007:
            r0 = r11.YD;
            if (r0 == 0) goto L_0x0017;
        L_0x000b:
            r0 = r11.l(r13);
        L_0x000f:
            r11.YC = r0;
            if (r0 != 0) goto L_0x0015;
        L_0x0013:
            if (r10 == 0) goto L_0x0016;
        L_0x0015:
            r7 = r8;
        L_0x0016:
            return r7;
        L_0x0017:
            r0 = r11.l(r13);
            if (r0 != 0) goto L_0x0023;
        L_0x001d:
            r0 = r11.ea();
            if (r0 != 0) goto L_0x0025;
        L_0x0023:
            r0 = r8;
            goto L_0x000f;
        L_0x0025:
            r0 = r7;
            goto L_0x000f;
        L_0x0027:
            r1 = r11.Yz;
            r0 = r1.isEnabled();
            if (r0 == 0) goto L_0x0036;
        L_0x002f:
            r0 = android.support.v4.view.o.d(r13);
            switch(r0) {
                case 0: goto L_0x0057;
                case 1: goto L_0x00d2;
                case 2: goto L_0x0086;
                case 3: goto L_0x00d2;
                default: goto L_0x0036;
            };
        L_0x0036:
            r0 = r7;
        L_0x0037:
            if (r0 == 0) goto L_0x00d7;
        L_0x0039:
            r0 = r11.dp();
            if (r0 == 0) goto L_0x00d7;
        L_0x003f:
            r9 = r8;
        L_0x0040:
            if (r9 == 0) goto L_0x0055;
        L_0x0042:
            r0 = android.os.SystemClock.uptimeMillis();
            r4 = 3;
            r2 = r0;
            r6 = r5;
            r0 = android.view.MotionEvent.obtain(r0, r2, r4, r5, r6, r7);
            r1 = r11.Yz;
            r1.onTouchEvent(r0);
            r0.recycle();
        L_0x0055:
            r0 = r9;
            goto L_0x000f;
        L_0x0057:
            r0 = r13.getPointerId(r7);
            r11.fl = r0;
            r11.YD = r7;
            r0 = r11.YA;
            if (r0 != 0) goto L_0x006a;
        L_0x0063:
            r0 = new android.support.v7.widget.ListPopupWindow$b$a;
            r0.<init>(r11);
            r11.YA = r0;
        L_0x006a:
            r0 = r11.YA;
            r2 = r11.Yx;
            r2 = (long) r2;
            r1.postDelayed(r0, r2);
            r0 = r11.YB;
            if (r0 != 0) goto L_0x007d;
        L_0x0076:
            r0 = new android.support.v7.widget.ListPopupWindow$b$b;
            r0.<init>(r11);
            r11.YB = r0;
        L_0x007d:
            r0 = r11.YB;
            r2 = r11.Yy;
            r2 = (long) r2;
            r1.postDelayed(r0, r2);
            goto L_0x0036;
        L_0x0086:
            r0 = r11.fl;
            r0 = r13.findPointerIndex(r0);
            if (r0 < 0) goto L_0x0036;
        L_0x008e:
            r2 = r13.getX(r0);
            r0 = r13.getY(r0);
            r3 = r11.Yw;
            r4 = -r3;
            r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r4 < 0) goto L_0x00d0;
        L_0x009d:
            r4 = -r3;
            r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
            if (r4 < 0) goto L_0x00d0;
        L_0x00a2:
            r4 = r1.getRight();
            r6 = r1.getLeft();
            r4 = r4 - r6;
            r4 = (float) r4;
            r4 = r4 + r3;
            r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r2 >= 0) goto L_0x00d0;
        L_0x00b1:
            r2 = r1.getBottom();
            r4 = r1.getTop();
            r2 = r2 - r4;
            r2 = (float) r2;
            r2 = r2 + r3;
            r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r0 >= 0) goto L_0x00d0;
        L_0x00c0:
            r0 = r8;
        L_0x00c1:
            if (r0 != 0) goto L_0x0036;
        L_0x00c3:
            r11.fh();
            r0 = r1.getParent();
            r0.requestDisallowInterceptTouchEvent(r8);
            r0 = r8;
            goto L_0x0037;
        L_0x00d0:
            r0 = r7;
            goto L_0x00c1;
        L_0x00d2:
            r11.fh();
            goto L_0x0036;
        L_0x00d7:
            r9 = r7;
            goto L_0x0040;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ListPopupWindow.b.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }

        public boolean dp() {
            ListPopupWindow listPopupWindow = do();
            if (!(listPopupWindow == null || listPopupWindow.XU.isShowing())) {
                listPopupWindow.show();
            }
            return true;
        }

        protected boolean ea() {
            ListPopupWindow listPopupWindow = do();
            if (listPopupWindow != null && listPopupWindow.XU.isShowing()) {
                listPopupWindow.dismiss();
            }
            return true;
        }

        void fh() {
            if (this.YB != null) {
                this.Yz.removeCallbacks(this.YB);
            }
            if (this.YA != null) {
                this.Yz.removeCallbacks(this.YA);
            }
        }

        private boolean l(MotionEvent motionEvent) {
            View view = this.Yz;
            ListPopupWindow listPopupWindow = do();
            if (listPopupWindow == null || !listPopupWindow.XU.isShowing()) {
                return false;
            }
            View view2 = listPopupWindow.XV;
            if (view2 == null || !view2.isShown()) {
                return false;
            }
            MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
            int[] iArr = this.YE;
            view.getLocationOnScreen(iArr);
            obtainNoHistory.offsetLocation((float) iArr[0], (float) iArr[1]);
            int[] iArr2 = this.YE;
            view2.getLocationOnScreen(iArr2);
            obtainNoHistory.offsetLocation((float) (-iArr2[0]), (float) (-iArr2[1]));
            boolean h = view2.h(obtainNoHistory, this.fl);
            obtainNoHistory.recycle();
            int d = o.d(motionEvent);
            boolean z;
            if (d == 1 || d == 3) {
                z = false;
            } else {
                z = true;
            }
            if (h && r2) {
                return true;
            }
            return false;
        }
    }

    private class c implements Runnable {
        final /* synthetic */ ListPopupWindow Yq;

        public c(ListPopupWindow listPopupWindow) {
            this.Yq = listPopupWindow;
        }

        public final void run() {
            this.Yq.clearListSelection();
        }
    }

    private class d extends DataSetObserver {
        final /* synthetic */ ListPopupWindow Yq;

        private d(ListPopupWindow listPopupWindow) {
            this.Yq = listPopupWindow;
        }

        public final void onChanged() {
            if (this.Yq.XU.isShowing()) {
                this.Yq.show();
            }
        }

        public final void onInvalidated() {
            this.Yq.dismiss();
        }
    }

    private class e implements OnScrollListener {
        final /* synthetic */ ListPopupWindow Yq;

        public e(ListPopupWindow listPopupWindow) {
            this.Yq = listPopupWindow;
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !this.Yq.isInputMethodNotNeeded() && this.Yq.XU.getContentView() != null) {
                this.Yq.mHandler.removeCallbacks(this.Yq.Yk);
                this.Yq.Yk.run();
            }
        }
    }

    private class f implements OnTouchListener {
        final /* synthetic */ ListPopupWindow Yq;

        public f(ListPopupWindow listPopupWindow) {
            this.Yq = listPopupWindow;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && this.Yq.XU != null && this.Yq.XU.isShowing() && x >= 0 && x < this.Yq.XU.getWidth() && y >= 0 && y < this.Yq.XU.getHeight()) {
                this.Yq.mHandler.postDelayed(this.Yq.Yk, 250);
            } else if (action == 1) {
                this.Yq.mHandler.removeCallbacks(this.Yq.Yk);
            }
            return false;
        }
    }

    private class g implements Runnable {
        final /* synthetic */ ListPopupWindow Yq;

        public g(ListPopupWindow listPopupWindow) {
            this.Yq = listPopupWindow;
        }

        public final void run() {
            if (this.Yq.XV != null && z.al(this.Yq.XV) && this.Yq.XV.getCount() > this.Yq.XV.getChildCount() && this.Yq.XV.getChildCount() <= this.Yq.Yd) {
                this.Yq.XU.setInputMethodMode(2);
                this.Yq.show();
            }
        }
    }

    private static class a extends ListViewCompat {
        private boolean Yr;
        private boolean Ys;
        private boolean Yt;
        private ai Yu;
        private k Yv;

        public a(Context context, boolean z) {
            super(context, null, android.support.v7.a.a.a.dropDownListViewStyle);
            this.Ys = z;
            setCacheColorHint(0);
        }

        public final boolean h(MotionEvent motionEvent, int i) {
            boolean z;
            boolean z2;
            View childAt;
            int d = o.d(motionEvent);
            switch (d) {
                case 1:
                    z = false;
                    break;
                case 2:
                    z = true;
                    break;
                case 3:
                    z = false;
                    z2 = false;
                    break;
                default:
                    z = false;
                    z2 = true;
                    break;
            }
            int findPointerIndex = motionEvent.findPointerIndex(i);
            if (findPointerIndex < 0) {
                z = false;
                z2 = false;
            } else {
                int x = (int) motionEvent.getX(findPointerIndex);
                findPointerIndex = (int) motionEvent.getY(findPointerIndex);
                int pointToPosition = pointToPosition(x, findPointerIndex);
                if (pointToPosition == -1) {
                    z2 = z;
                    z = true;
                } else {
                    View childAt2 = getChildAt(pointToPosition - getFirstVisiblePosition());
                    float f = (float) x;
                    float f2 = (float) findPointerIndex;
                    this.Yt = true;
                    if (VERSION.SDK_INT >= 21) {
                        drawableHotspotChanged(f, f2);
                    }
                    if (!isPressed()) {
                        setPressed(true);
                    }
                    layoutChildren();
                    if (this.YM != -1) {
                        childAt = getChildAt(this.YM - getFirstVisiblePosition());
                        if (!(childAt == null || childAt == childAt2 || !childAt.isPressed())) {
                            childAt.setPressed(false);
                        }
                    }
                    this.YM = pointToPosition;
                    float left = f - ((float) childAt2.getLeft());
                    float top = f2 - ((float) childAt2.getTop());
                    if (VERSION.SDK_INT >= 21) {
                        childAt2.drawableHotspotChanged(left, top);
                    }
                    if (!childAt2.isPressed()) {
                        childAt2.setPressed(true);
                    }
                    Drawable selector = getSelector();
                    if (selector == null || pointToPosition == -1) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        selector.setVisible(false, false);
                    }
                    super.a(pointToPosition, childAt2);
                    if (z) {
                        Rect rect = this.YH;
                        float exactCenterX = rect.exactCenterX();
                        float exactCenterY = rect.exactCenterY();
                        if (getVisibility() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        selector.setVisible(z, false);
                        android.support.v4.b.a.a.a(selector, exactCenterX, exactCenterY);
                    }
                    Drawable selector2 = getSelector();
                    if (!(selector2 == null || pointToPosition == -1)) {
                        android.support.v4.b.a.a.a(selector2, f, f2);
                    }
                    Q(false);
                    refreshDrawableState();
                    if (d == 1) {
                        performItemClick(childAt2, pointToPosition, getItemIdAtPosition(pointToPosition));
                    }
                    z = false;
                    z2 = true;
                }
            }
            if (!z2 || r0) {
                this.Yt = false;
                setPressed(false);
                drawableStateChanged();
                childAt = getChildAt(this.YM - getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setPressed(false);
                }
                if (this.Yu != null) {
                    this.Yu.cancel();
                    this.Yu = null;
                }
            }
            if (z2) {
                if (this.Yv == null) {
                    this.Yv = new k(this);
                }
                this.Yv.s(true);
                this.Yv.onTouch(this, motionEvent);
            } else if (this.Yv != null) {
                this.Yv.s(false);
            }
            return z2;
        }

        protected final boolean fg() {
            return this.Yt || super.fg();
        }

        public final boolean isInTouchMode() {
            return (this.Ys && this.Yr) || super.isInTouchMode();
        }

        public final boolean hasWindowFocus() {
            return this.Ys || super.hasWindowFocus();
        }

        public final boolean isFocused() {
            return this.Ys || super.isFocused();
        }

        public final boolean hasFocus() {
            return this.Ys || super.hasFocus();
        }
    }

    static {
        try {
            XS = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
        }
        try {
            XT = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, android.support.v7.a.a.a.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.a.a.a.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.XW = -2;
        this.Vf = -2;
        this.XZ = MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED;
        this.Rr = 0;
        this.Yb = false;
        this.Yc = false;
        this.Yd = Integer.MAX_VALUE;
        this.Yf = 0;
        this.Yk = new g(this);
        this.Yl = new f(this);
        this.Ym = new e(this);
        this.Yn = new c(this);
        this.eq = new Rect();
        this.mContext = context;
        this.mHandler = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.v7.a.a.k.ck, i, i2);
        this.XX = obtainStyledAttributes.getDimensionPixelOffset(android.support.v7.a.a.k.Mi, 0);
        this.XY = obtainStyledAttributes.getDimensionPixelOffset(android.support.v7.a.a.k.Mj, 0);
        if (this.XY != 0) {
            this.Ya = true;
        }
        obtainStyledAttributes.recycle();
        this.XU = new AppCompatPopupWindow(context, attributeSet, i);
        this.XU.setInputMethodMode(1);
        this.WV = android.support.v4.d.f.getLayoutDirectionFromLocale(this.mContext.getResources().getConfiguration().locale);
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (this.mObserver == null) {
            this.mObserver = new d();
        } else if (this.FA != null) {
            this.FA.unregisterDataSetObserver(this.mObserver);
        }
        this.FA = listAdapter;
        if (this.FA != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
        }
        if (this.XV != null) {
            this.XV.setAdapter(this.FA);
        }
    }

    public final void fe() {
        this.Yp = true;
        this.XU.setFocusable(true);
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.XU.setBackgroundDrawable(drawable);
    }

    public final void setContentWidth(int i) {
        Drawable background = this.XU.getBackground();
        if (background != null) {
            background.getPadding(this.eq);
            this.Vf = (this.eq.left + this.eq.right) + i;
            return;
        }
        this.Vf = i;
    }

    public void show() {
        int i;
        int i2;
        boolean z;
        int makeMeasureSpec;
        boolean z2 = true;
        LayoutParams layoutParams;
        if (this.XV == null) {
            Context context = this.mContext;
            this.Yo = new Runnable(this) {
                final /* synthetic */ ListPopupWindow Yq;

                {
                    this.Yq = r1;
                }

                public final void run() {
                    View view = this.Yq.Yg;
                    if (view != null && view.getWindowToken() != null) {
                        this.Yq.show();
                    }
                }
            };
            this.XV = new a(context, !this.Yp);
            if (this.Yh != null) {
                this.XV.setSelector(this.Yh);
            }
            this.XV.setAdapter(this.FA);
            this.XV.setOnItemClickListener(this.Yi);
            this.XV.setFocusable(true);
            this.XV.setFocusableInTouchMode(true);
            this.XV.setOnItemSelectedListener(new OnItemSelectedListener(this) {
                final /* synthetic */ ListPopupWindow Yq;

                {
                    this.Yq = r1;
                }

                public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    if (i != -1) {
                        a aVar = this.Yq.XV;
                        if (aVar != null) {
                            aVar.Yr = false;
                        }
                    }
                }

                public final void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.XV.setOnScrollListener(this.Ym);
            if (this.Yj != null) {
                this.XV.setOnItemSelectedListener(this.Yj);
            }
            View view = this.XV;
            View view2 = this.Ye;
            if (view2 != null) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, 0, 1.0f);
                switch (this.Yf) {
                    case 0:
                        linearLayout.addView(view2);
                        linearLayout.addView(view, layoutParams2);
                        break;
                    case 1:
                        linearLayout.addView(view, layoutParams2);
                        linearLayout.addView(view2);
                        break;
                    default:
                        new StringBuilder("Invalid hint position ").append(this.Yf);
                        break;
                }
                if (this.Vf >= 0) {
                    i = this.Vf;
                    i2 = Integer.MIN_VALUE;
                } else {
                    i = 0;
                    i2 = 0;
                }
                view2.measure(MeasureSpec.makeMeasureSpec(i, i2), 0);
                layoutParams = (LayoutParams) view2.getLayoutParams();
                i2 = layoutParams.bottomMargin + (view2.getMeasuredHeight() + layoutParams.topMargin);
                view = linearLayout;
            } else {
                i2 = 0;
            }
            this.XU.setContentView(view);
        } else {
            this.XU.getContentView();
            View view3 = this.Ye;
            if (view3 != null) {
                layoutParams = (LayoutParams) view3.getLayoutParams();
                i2 = (view3.getMeasuredHeight() + layoutParams.topMargin) + layoutParams.bottomMargin;
            } else {
                i2 = 0;
            }
        }
        Drawable background = this.XU.getBackground();
        if (background != null) {
            background.getPadding(this.eq);
            i = this.eq.top + this.eq.bottom;
            if (!this.Ya) {
                this.XY = -this.eq.top;
            }
        } else {
            this.eq.setEmpty();
            i = 0;
        }
        if (this.XU.getInputMethodMode() == 2) {
            z = true;
        } else {
            z = false;
        }
        int b = b(this.Yg, this.XY, z);
        if (this.Yb || this.XW == -1) {
            i += b;
        } else {
            switch (this.Vf) {
                case -2:
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.eq.left + this.eq.right), Integer.MIN_VALUE);
                    break;
                case -1:
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.eq.left + this.eq.right), 1073741824);
                    break;
                default:
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.Vf, 1073741824);
                    break;
            }
            makeMeasureSpec = this.XV.L(makeMeasureSpec, b - i2);
            if (makeMeasureSpec > 0) {
                i2 += i;
            }
            i = makeMeasureSpec + i2;
        }
        z = isInputMethodNotNeeded();
        m.a(this.XU, this.XZ);
        if (this.XU.isShowing()) {
            if (this.Vf == -1) {
                makeMeasureSpec = -1;
            } else if (this.Vf == -2) {
                makeMeasureSpec = this.Yg.getWidth();
            } else {
                makeMeasureSpec = this.Vf;
            }
            if (this.XW == -1) {
                if (z) {
                    i2 = i;
                } else {
                    i2 = -1;
                }
                PopupWindow popupWindow;
                if (z) {
                    popupWindow = this.XU;
                    if (this.Vf == -1) {
                        i = -1;
                    } else {
                        i = 0;
                    }
                    popupWindow.setWidth(i);
                    this.XU.setHeight(0);
                    b = i2;
                } else {
                    popupWindow = this.XU;
                    if (this.Vf == -1) {
                        i = -1;
                    } else {
                        i = 0;
                    }
                    popupWindow.setWidth(i);
                    this.XU.setHeight(-1);
                    b = i2;
                }
            } else if (this.XW == -2) {
                b = i;
            } else {
                b = this.XW;
            }
            PopupWindow popupWindow2 = this.XU;
            if (this.Yc || this.Yb) {
                z2 = false;
            }
            popupWindow2.setOutsideTouchable(z2);
            popupWindow2 = this.XU;
            View view4 = this.Yg;
            int i3 = this.XX;
            i2 = this.XY;
            if (makeMeasureSpec < 0) {
                makeMeasureSpec = -1;
            }
            if (b < 0) {
                b = -1;
            }
            popupWindow2.update(view4, i3, i2, makeMeasureSpec, b);
            return;
        }
        if (this.Vf == -1) {
            i2 = -1;
        } else if (this.Vf == -2) {
            i2 = this.Yg.getWidth();
        } else {
            i2 = this.Vf;
        }
        if (this.XW == -1) {
            i = -1;
        } else if (this.XW != -2) {
            i = this.XW;
        }
        this.XU.setWidth(i2);
        this.XU.setHeight(i);
        if (XS != null) {
            try {
                XS.invoke(this.XU, new Object[]{Boolean.valueOf(true)});
            } catch (Exception e) {
            }
        }
        popupWindow2 = this.XU;
        if (this.Yc || this.Yb) {
            z2 = false;
        }
        popupWindow2.setOutsideTouchable(z2);
        this.XU.setTouchInterceptor(this.Yl);
        m.a(this.XU, this.Yg, this.XX, this.XY, this.Rr);
        this.XV.setSelection(-1);
        if (!this.Yp || this.XV.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.Yp) {
            this.mHandler.post(this.Yn);
        }
    }

    public final void dismiss() {
        this.XU.dismiss();
        if (this.Ye != null) {
            ViewParent parent = this.Ye.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.Ye);
            }
        }
        this.XU.setContentView(null);
        this.XV = null;
        this.mHandler.removeCallbacks(this.Yk);
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        this.XU.setOnDismissListener(onDismissListener);
    }

    public final void ff() {
        this.XU.setInputMethodMode(2);
    }

    public final void clearListSelection() {
        a aVar = this.XV;
        if (aVar != null) {
            aVar.Yr = true;
            aVar.requestLayout();
        }
    }

    public final boolean isInputMethodNotNeeded() {
        return this.XU.getInputMethodMode() == 2;
    }

    private int b(View view, int i, boolean z) {
        if (XT != null) {
            try {
                return ((Integer) XT.invoke(this.XU, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
            } catch (Exception e) {
            }
        }
        return this.XU.getMaxAvailableHeight(view, i);
    }
}
