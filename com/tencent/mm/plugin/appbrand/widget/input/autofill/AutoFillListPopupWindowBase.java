package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.o;
import java.util.Locale;

public class AutoFillListPopupWindowBase {
    public ListAdapter FA;
    int Vf;
    int XW;
    int XX;
    int XY;
    boolean Ya;
    boolean Yb;
    boolean Yc;
    int Yd;
    public View Ye;
    private int Yf;
    View Yg;
    private Drawable Yh;
    private OnItemClickListener Yi;
    private OnItemSelectedListener Yj;
    private Runnable Yo;
    boolean Yp;
    private Rect eq;
    public o iuS;
    public a jwq;
    public final f jwr;
    private final e jws;
    private final d jwt;
    private final b jwu;
    private boolean jwv;
    private Context mContext;
    public ae mHandler;
    DataSetObserver mObserver;

    private static class a extends ListView {
        private boolean Yr;
        private boolean Ys;

        public a(Context context, boolean z) {
            super(context, null, com.tencent.mm.bm.a.a.dropDownListViewStyle);
            this.Ys = z;
            setCacheColorHint(0);
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

        final int L(int i, int i2) {
            int listPaddingTop = getListPaddingTop();
            int listPaddingBottom = getListPaddingBottom();
            getListPaddingLeft();
            getListPaddingRight();
            int dividerHeight = getDividerHeight();
            Drawable divider = getDivider();
            ListAdapter adapter = getAdapter();
            if (adapter == null) {
                return listPaddingTop + listPaddingBottom;
            }
            listPaddingBottom += listPaddingTop;
            if (dividerHeight <= 0 || divider == null) {
                dividerHeight = 0;
            }
            int count = adapter.getCount();
            int i3 = 0;
            View view = null;
            for (int i4 = 0; i4 < count; i4++) {
                View view2;
                listPaddingTop = adapter.getItemViewType(i4);
                if (listPaddingTop != i3) {
                    i3 = listPaddingTop;
                    view2 = null;
                } else {
                    view2 = view;
                }
                view = adapter.getView(i4, view2, this);
                listPaddingTop = view.getLayoutParams().height;
                if (listPaddingTop > 0) {
                    listPaddingTop = MeasureSpec.makeMeasureSpec(listPaddingTop, 1073741824);
                } else {
                    listPaddingTop = MeasureSpec.makeMeasureSpec(0, 0);
                }
                view.measure(i, listPaddingTop);
                if (i4 > 0) {
                    listPaddingTop = listPaddingBottom + dividerHeight;
                } else {
                    listPaddingTop = listPaddingBottom;
                }
                listPaddingBottom = view.getMeasuredHeight() + listPaddingTop;
                if (listPaddingBottom >= i2) {
                    return i2;
                }
            }
            return listPaddingBottom;
        }
    }

    private class b implements Runnable {
        final /* synthetic */ AutoFillListPopupWindowBase jww;

        public b(AutoFillListPopupWindowBase autoFillListPopupWindowBase) {
            this.jww = autoFillListPopupWindowBase;
        }

        public final void run() {
            this.jww.clearListSelection();
        }
    }

    private class c extends DataSetObserver {
        final /* synthetic */ AutoFillListPopupWindowBase jww;

        private c(AutoFillListPopupWindowBase autoFillListPopupWindowBase) {
            this.jww = autoFillListPopupWindowBase;
        }

        public final void onChanged() {
            if (this.jww.iuS.isShowing()) {
                this.jww.show();
            }
        }

        public final void onInvalidated() {
            this.jww.dismiss();
        }
    }

    private class d implements OnScrollListener {
        final /* synthetic */ AutoFillListPopupWindowBase jww;

        public d(AutoFillListPopupWindowBase autoFillListPopupWindowBase) {
            this.jww = autoFillListPopupWindowBase;
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.jww.jwq != null && this.jww.Ye != null && this.jww.FA != null && this.jww.jwq != null) {
                if (this.jww.jwq.getLastVisiblePosition() != this.jww.FA.getCount() - 1 || this.jww.jwq.getChildAt(this.jww.jwq.getChildCount() - 1) == null || this.jww.jwq.getChildAt(this.jww.jwq.getChildCount() - 1).getBottom() > this.jww.jwq.getHeight()) {
                    this.jww.Ye.setVisibility(0);
                } else {
                    this.jww.Ye.setVisibility(8);
                }
            }
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !this.jww.isInputMethodNotNeeded() && this.jww.iuS.getContentView() != null) {
                this.jww.mHandler.removeCallbacks(this.jww.jwr);
                this.jww.jwr.run();
            }
        }
    }

    private class e implements OnTouchListener {
        final /* synthetic */ AutoFillListPopupWindowBase jww;

        public e(AutoFillListPopupWindowBase autoFillListPopupWindowBase) {
            this.jww = autoFillListPopupWindowBase;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && this.jww.iuS != null && this.jww.iuS.isShowing() && x >= 0 && x < this.jww.iuS.getWidth() && y >= 0 && y < this.jww.iuS.getHeight()) {
                this.jww.mHandler.postDelayed(this.jww.jwr, 250);
            } else if (action == 1) {
                this.jww.mHandler.removeCallbacks(this.jww.jwr);
            }
            return false;
        }
    }

    private class f implements Runnable {
        final /* synthetic */ AutoFillListPopupWindowBase jww;

        public f(AutoFillListPopupWindowBase autoFillListPopupWindowBase) {
            this.jww = autoFillListPopupWindowBase;
        }

        public final void run() {
            if (this.jww.jwq != null && this.jww.jwq.getCount() > this.jww.jwq.getChildCount() && this.jww.jwq.getChildCount() <= this.jww.Yd) {
                this.jww.iuS.setInputMethodMode(2);
                this.jww.show();
            }
        }
    }

    public AutoFillListPopupWindowBase(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.tencent.mm.bm.a.a.listPopupWindowStyle);
    }

    public AutoFillListPopupWindowBase(Context context, AttributeSet attributeSet, int i) {
        this.XW = -2;
        this.Vf = -2;
        this.Yb = false;
        this.Yc = false;
        this.Yd = Integer.MAX_VALUE;
        this.Yf = 0;
        this.jwr = new f(this);
        this.jws = new e(this);
        this.jwt = new d(this);
        this.jwu = new b(this);
        this.mHandler = new ae();
        this.eq = new Rect();
        this.jwv = false;
        this.mContext = context;
        this.iuS = new o(context);
        this.iuS.setInputMethodMode(1);
        Locale locale = this.mContext.getResources().getConfiguration().locale;
    }

    public final void setVerticalOffset(int i) {
        this.XY = i;
        this.Ya = true;
    }

    public void show() {
        int i;
        int i2;
        boolean z;
        boolean z2 = true;
        int i3 = -1;
        View frameLayout;
        if (this.jwq == null) {
            Context context = this.mContext;
            this.Yo = new Runnable(this) {
                final /* synthetic */ AutoFillListPopupWindowBase jww;

                {
                    this.jww = r1;
                }

                public final void run() {
                    View view = this.jww.Yg;
                    if (view != null && view.getWindowToken() != null) {
                        this.jww.show();
                    }
                }
            };
            this.jwq = new a(context, !this.Yp);
            if (this.Yh != null) {
                this.jwq.setSelector(this.Yh);
            }
            this.jwq.setAdapter(this.FA);
            this.jwq.setOnItemClickListener(this.Yi);
            this.jwq.setFocusable(true);
            this.jwq.setFocusableInTouchMode(true);
            this.jwq.setDivider(null);
            this.jwq.setDividerHeight(0);
            this.jwq.setOnItemSelectedListener(new OnItemSelectedListener(this) {
                final /* synthetic */ AutoFillListPopupWindowBase jww;

                {
                    this.jww = r1;
                }

                public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    if (i != -1) {
                        a aVar = this.jww.jwq;
                        if (aVar != null) {
                            aVar.Yr = false;
                        }
                    }
                }

                public final void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.jwq.setOnScrollListener(this.jwt);
            if (this.Yj != null) {
                this.jwq.setOnItemSelectedListener(this.Yj);
            }
            View view = this.jwq;
            View view2 = this.Ye;
            if (view2 != null) {
                Zw();
                frameLayout = new FrameLayout(context);
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                switch (this.Yf) {
                    case 0:
                        layoutParams2.gravity = 48;
                        frameLayout.addView(view, layoutParams);
                        frameLayout.addView(view2, layoutParams2);
                        break;
                    case 1:
                        layoutParams2.gravity = 80;
                        frameLayout.addView(view, layoutParams);
                        frameLayout.addView(view2, layoutParams2);
                        break;
                    default:
                        new StringBuilder("Invalid hint position ").append(this.Yf);
                        break;
                }
                view2.measure(MeasureSpec.makeMeasureSpec(this.Vf, Integer.MIN_VALUE), 0);
            } else {
                frameLayout = view;
            }
            this.iuS.setContentView(frameLayout);
            i = 0;
        } else {
            this.iuS.getContentView();
            frameLayout = this.Ye;
            i = frameLayout != null ? frameLayout.getMeasuredHeight() : 0;
        }
        Drawable background = this.iuS.getBackground();
        if (background != null) {
            background.getPadding(this.eq);
            i2 = this.eq.top + this.eq.bottom;
            if (!this.Ya) {
                this.XY = -this.eq.top;
            }
        } else {
            this.eq.setEmpty();
            i2 = 0;
        }
        if (this.iuS.getInputMethodMode() == 2) {
            z = true;
        } else {
            z = false;
        }
        View view3 = this.Yg;
        int i4 = this.XY;
        Rect rect = new Rect();
        view3.getWindowVisibleDisplayFrame(rect);
        view3.getLocationOnScreen(new int[2]);
        int i5 = (z ? view3.getContext().getResources().getDisplayMetrics().heightPixels : rect.bottom) - i4;
        if (this.iuS.getBackground() != null) {
            this.iuS.getBackground().getPadding(this.eq);
            i5 -= this.eq.top + this.eq.bottom;
        }
        if (this.Yb || this.XW == -1) {
            i = i5 + i2;
        } else {
            int makeMeasureSpec;
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
            i5 = this.jwq.L(makeMeasureSpec, i5 - i);
            if (i5 > 0) {
                i += i2;
            }
            i += i5;
        }
        boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
        o oVar;
        if (this.iuS.isShowing()) {
            if (this.Vf == -1) {
                i2 = -1;
            } else if (this.Vf == -2) {
                i2 = this.Yg.getWidth();
            } else {
                i2 = this.Vf;
            }
            if (this.XW == -1) {
                if (isInputMethodNotNeeded) {
                    i5 = i;
                } else {
                    i5 = -1;
                }
                if (isInputMethodNotNeeded) {
                    oVar = this.iuS;
                    if (this.Vf != -1) {
                        i3 = 0;
                    }
                    oVar.setWindowLayoutMode(i3, 0);
                    i = i5;
                } else {
                    this.iuS.setWindowLayoutMode(this.Vf == -1 ? -1 : 0, -1);
                    i = i5;
                }
            } else if (this.XW != -2) {
                i = this.XW;
            }
            this.iuS.update(i2, i);
            oVar = this.iuS;
            if (this.Yc || this.Yb) {
                z2 = false;
            }
            oVar.setOutsideTouchable(z2);
            if (this.jwv) {
                this.iuS.showAtLocation(this.Yg, 17, 0, 0);
                return;
            } else {
                this.iuS.update(this.Yg, this.XX, this.XY, this.iuS.getWidth(), this.iuS.getHeight());
                return;
            }
        }
        if (this.Vf == -1) {
            i2 = -1;
        } else if (this.Vf == -2) {
            this.iuS.setWidth(this.Yg.getWidth());
            i2 = 0;
        } else {
            this.iuS.setWidth(this.Vf);
            i2 = 0;
        }
        if (this.XW == -1) {
            i = -1;
        } else if (this.XW == -2) {
            this.iuS.setHeight(i);
            i = 0;
        } else {
            this.iuS.setHeight(this.XW);
            i = 0;
        }
        this.iuS.setWindowLayoutMode(i2, i);
        oVar = this.iuS;
        if (this.Yc || this.Yb) {
            z2 = false;
        }
        oVar.setOutsideTouchable(z2);
        this.iuS.setTouchInterceptor(this.jws);
        if (this.jwv) {
            this.iuS.showAtLocation(this.Yg, 17, 0, 0);
        } else if (VERSION.SDK_INT >= 19) {
            this.iuS.showAsDropDown(this.Yg, this.XX, this.XY, 53);
        } else {
            this.iuS.showAtLocation(this.Yg, 53, this.XX, this.XY);
        }
        this.jwq.setSelection(-1);
        if (!this.Yp || this.jwq.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.Yp) {
            this.mHandler.post(this.jwu);
        }
    }

    public final void dismiss() {
        this.iuS.dismiss();
        Zw();
        this.iuS.setContentView(null);
        this.jwq = null;
        this.mHandler.removeCallbacks(this.jwr);
    }

    private void Zw() {
        if (this.Ye != null) {
            ViewParent parent = this.Ye.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.Ye);
            }
        }
    }

    public final void clearListSelection() {
        a aVar = this.jwq;
        if (aVar != null) {
            aVar.Yr = true;
            aVar.requestLayout();
        }
    }

    public final boolean isInputMethodNotNeeded() {
        return this.iuS.getInputMethodMode() == 2;
    }
}
