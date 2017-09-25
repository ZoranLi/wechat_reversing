package com.tencent.mm.ui.base;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
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
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Locale;

public class MMListPopupWindow {
    public ListAdapter FA;
    private int Vf;
    public int XW;
    public int XX;
    private int XY;
    private boolean Ya;
    private boolean Yb;
    private boolean Yc;
    int Yd;
    public View Ye;
    public int Yf;
    public View Yg;
    private Drawable Yh;
    public OnItemClickListener Yi;
    private OnItemSelectedListener Yj;
    private Runnable Yo;
    private boolean Yp;
    private Rect eq;
    public o iuS;
    public boolean jwv;
    private Context mContext;
    public ae mHandler;
    private DataSetObserver mObserver;
    public a vkP;
    public final f vkQ;
    private final e vkR;
    private final d vkS;
    private final b vkT;

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
        final /* synthetic */ MMListPopupWindow vkU;

        public b(MMListPopupWindow mMListPopupWindow) {
            this.vkU = mMListPopupWindow;
        }

        public final void run() {
            this.vkU.clearListSelection();
        }
    }

    private class c extends DataSetObserver {
        final /* synthetic */ MMListPopupWindow vkU;

        private c(MMListPopupWindow mMListPopupWindow) {
            this.vkU = mMListPopupWindow;
        }

        public final void onChanged() {
            if (this.vkU.iuS.isShowing()) {
                this.vkU.show();
            }
        }

        public final void onInvalidated() {
            this.vkU.dismiss();
        }
    }

    private class d implements OnScrollListener {
        final /* synthetic */ MMListPopupWindow vkU;

        public d(MMListPopupWindow mMListPopupWindow) {
            this.vkU = mMListPopupWindow;
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (this.vkU.vkP != null && this.vkU.Ye != null && this.vkU.FA != null && this.vkU.vkP != null) {
                if (this.vkU.vkP.getLastVisiblePosition() != this.vkU.FA.getCount() - 1 || this.vkU.vkP.getChildAt(this.vkU.vkP.getChildCount() - 1) == null || this.vkU.vkP.getChildAt(this.vkU.vkP.getChildCount() - 1).getBottom() > this.vkU.vkP.getHeight()) {
                    this.vkU.Ye.setVisibility(0);
                } else {
                    this.vkU.Ye.setVisibility(8);
                }
            }
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !this.vkU.isInputMethodNotNeeded() && this.vkU.iuS.getContentView() != null) {
                this.vkU.mHandler.removeCallbacks(this.vkU.vkQ);
                this.vkU.vkQ.run();
            }
        }
    }

    private class e implements OnTouchListener {
        final /* synthetic */ MMListPopupWindow vkU;

        public e(MMListPopupWindow mMListPopupWindow) {
            this.vkU = mMListPopupWindow;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && this.vkU.iuS != null && this.vkU.iuS.isShowing() && x >= 0 && x < this.vkU.iuS.getWidth() && y >= 0 && y < this.vkU.iuS.getHeight()) {
                this.vkU.mHandler.postDelayed(this.vkU.vkQ, 250);
            } else if (action == 1) {
                this.vkU.mHandler.removeCallbacks(this.vkU.vkQ);
            }
            return false;
        }
    }

    private class f implements Runnable {
        final /* synthetic */ MMListPopupWindow vkU;

        public f(MMListPopupWindow mMListPopupWindow) {
            this.vkU = mMListPopupWindow;
        }

        public final void run() {
            if (this.vkU.vkP != null && this.vkU.vkP.getCount() > this.vkU.vkP.getChildCount() && this.vkU.vkP.getChildCount() <= this.vkU.Yd) {
                this.vkU.iuS.setInputMethodMode(2);
                this.vkU.show();
            }
        }
    }

    public MMListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.tencent.mm.bm.a.a.listPopupWindowStyle);
    }

    public MMListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this.XW = -2;
        this.Vf = -2;
        this.Yb = false;
        this.Yc = false;
        this.Yd = Integer.MAX_VALUE;
        this.Yf = 0;
        this.vkQ = new f(this);
        this.vkR = new e(this);
        this.vkS = new d(this);
        this.vkT = new b(this);
        this.mHandler = new ae();
        this.eq = new Rect();
        this.jwv = false;
        this.mContext = context;
        this.iuS = new o(context);
        this.iuS.setInputMethodMode(1);
        Locale locale = this.mContext.getResources().getConfiguration().locale;
    }

    public final void setAdapter(ListAdapter listAdapter) {
        if (this.mObserver == null) {
            this.mObserver = new c();
        } else if (this.FA != null) {
            this.FA.unregisterDataSetObserver(this.mObserver);
        }
        this.FA = listAdapter;
        if (this.FA != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
        }
        if (this.vkP != null) {
            this.vkP.setAdapter(this.FA);
        }
    }

    public final void fe() {
        this.Yp = true;
        this.iuS.setFocusable(true);
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.iuS.setBackgroundDrawable(drawable);
    }

    public final void setAnimationStyle(int i) {
        this.iuS.setAnimationStyle(i);
    }

    public final void setVerticalOffset(int i) {
        this.XY = i;
        this.Ya = true;
    }

    public final void setContentWidth(int i) {
        Drawable background = this.iuS.getBackground();
        if (background != null) {
            background.getPadding(this.eq);
            this.Vf = (this.eq.left + this.eq.right) + i;
            return;
        }
        this.Vf = i;
    }

    public final void show() {
        int i;
        int i2;
        boolean z;
        boolean z2 = true;
        int i3 = -1;
        View frameLayout;
        if (this.vkP == null) {
            Context context = this.mContext;
            this.Yo = new Runnable(this) {
                final /* synthetic */ MMListPopupWindow vkU;

                {
                    this.vkU = r1;
                }

                public final void run() {
                    View view = this.vkU.Yg;
                    if (view != null && view.getWindowToken() != null) {
                        this.vkU.show();
                    }
                }
            };
            this.vkP = new a(context, !this.Yp);
            if (this.Yh != null) {
                this.vkP.setSelector(this.Yh);
            }
            this.vkP.setAdapter(this.FA);
            this.vkP.setOnItemClickListener(this.Yi);
            this.vkP.setFocusable(true);
            this.vkP.setFocusableInTouchMode(true);
            this.vkP.setDivider(null);
            this.vkP.setDividerHeight(0);
            this.vkP.setOnItemSelectedListener(new OnItemSelectedListener(this) {
                final /* synthetic */ MMListPopupWindow vkU;

                {
                    this.vkU = r1;
                }

                public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    if (i != -1) {
                        a aVar = this.vkU.vkP;
                        if (aVar != null) {
                            aVar.Yr = false;
                        }
                    }
                }

                public final void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.vkP.setOnScrollListener(this.vkS);
            if (this.Yj != null) {
                this.vkP.setOnItemSelectedListener(this.Yj);
            }
            View view = this.vkP;
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
            i5 = this.vkP.L(makeMeasureSpec, i5 - i);
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
                this.iuS.showAtLocation(this.Yg, 53, this.XX, this.XY);
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
        this.iuS.setTouchInterceptor(this.vkR);
        if (this.jwv) {
            this.iuS.showAtLocation(this.Yg, 17, 0, 0);
        } else {
            this.iuS.showAtLocation(this.Yg, 53, this.XX, this.XY);
        }
        this.vkP.setSelection(-1);
        if (!this.Yp || this.vkP.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.Yp) {
            this.mHandler.post(this.vkT);
        }
    }

    public final void dismiss() {
        this.iuS.dismiss();
        Zw();
        this.iuS.setContentView(null);
        this.vkP = null;
        this.mHandler.removeCallbacks(this.vkQ);
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        this.iuS.setOnDismissListener(onDismissListener);
    }

    public final void Zw() {
        if (this.Ye != null) {
            ViewParent parent = this.Ye.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.Ye);
            }
        }
    }

    public final void ff() {
        this.iuS.setInputMethodMode(2);
    }

    public final void clearListSelection() {
        a aVar = this.vkP;
        if (aVar != null) {
            aVar.Yr = true;
            aVar.requestLayout();
        }
    }

    public final boolean isInputMethodNotNeeded() {
        return this.iuS.getInputMethodMode() == 2;
    }
}
