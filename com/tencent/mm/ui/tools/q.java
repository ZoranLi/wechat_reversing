package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.s.a.d;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.f;
import com.tencent.mm.s.a.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.MMListPopupWindow;

public abstract class q implements OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, OnDismissListener {
    private int Rj;
    private ViewTreeObserver Rn;
    private ViewGroup Ro;
    private int dividerHeight;
    private View hz;
    private boolean jwv = false;
    private BaseAdapter kjh;
    protected Context mContext;
    private boolean sjk = false;
    private MMListPopupWindow vAy;
    private int vAz = l.hfv;
    private OnCancelListener woG;
    private OnDismissListener woH;
    private boolean woI = true;
    private View woJ;
    private int woK;
    private int woL = 0;
    private int woM = 0;
    private int woN = 0;
    private float woO = 0.0f;
    private float woP = 0.0f;

    public abstract BaseAdapter aeC();

    public q(Context context) {
        this.mContext = context;
        Resources resources = context.getResources();
        this.Rj = Math.min((resources.getDisplayMetrics().widthPixels * 4) / 5, resources.getDimensionPixelSize(e.IS));
        if (this.mContext instanceof Activity) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) this.mContext).getWindow().getDecorView();
            if (viewGroup.getChildCount() > 0) {
                this.hz = viewGroup.getChildAt(0);
            } else {
                this.hz = viewGroup;
            }
        }
        this.dividerHeight = b.a(this.mContext, 1.0f);
        this.woL = resources.getDimensionPixelSize(e.aXH) * 2;
        this.woM = resources.getDimensionPixelSize(e.aXQ);
        this.woN = b.a(this.mContext, 36.0f);
        this.kjh = aeC();
    }

    public final void lL(boolean z) {
        this.jwv = z;
        if (z) {
            this.vAz = l.hfu;
        } else {
            this.vAz = l.hfv;
        }
    }

    public boolean dL() {
        int height;
        boolean z;
        Rect rect = new Rect();
        if (this.mContext instanceof ActionBarActivity) {
            height = ((ActionBarActivity) this.mContext).cO().cP().getHeight();
        } else {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            height = displayMetrics.widthPixels > displayMetrics.heightPixels ? b.a(this.mContext, 40.0f) : b.a(this.mContext, 49.0f);
        }
        int dimensionPixelSize = height - this.mContext.getResources().getDimensionPixelSize(e.aXH);
        if (this.mContext instanceof Activity) {
            ((Activity) this.mContext).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int height2 = ((Activity) this.mContext).getWindow().getDecorView().getHeight();
            int[] iArr = new int[2];
            ((Activity) this.mContext).getWindow().getDecorView().getLocationOnScreen(iArr);
            if (height2 - rect.height() < 0 || iArr[1] <= m.CTRL_INDEX) {
                height = rect.top + dimensionPixelSize;
            } else {
                height = (height2 - rect.height()) + dimensionPixelSize;
            }
        } else {
            height = dimensionPixelSize;
        }
        this.sjk = aKK();
        if (this.vAy == null || true == this.woI) {
            this.vAy = new MMListPopupWindow(this.mContext, null, 0);
        }
        this.vAy.setOnDismissListener(this);
        this.vAy.Yi = this;
        this.vAy.setAdapter(this.kjh);
        this.vAy.fe();
        this.vAy.setBackgroundDrawable(this.mContext.getResources().getDrawable(f.hbO));
        this.vAy.setAnimationStyle(this.vAz);
        this.vAy.XX = 0;
        this.vAy.Yg = this.hz;
        if (this.hz != null) {
            z = this.Rn == null;
            this.Rn = this.hz.getViewTreeObserver();
            w.v("MicroMsg.SubMenuHelperBase", "tryshow addGlobalListener:%b", Boolean.valueOf(z));
            if (z) {
                this.Rn.addOnGlobalLayoutListener(this);
            }
        }
        this.vAy.setVerticalOffset(height);
        this.vAy.jwv = this.jwv;
        this.vAy.setContentWidth(Math.min(b(this.kjh), this.Rj));
        this.vAy.ff();
        if (!(this.woO == 0.0f || this.woP == 0.0f)) {
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            ((Activity) this.mContext).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics2);
            z = displayMetrics2.widthPixels > displayMetrics2.heightPixels;
            Rect rect2 = new Rect();
            ((Activity) this.mContext).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect2);
            height = ((Activity) this.mContext).getWindow().getDecorView().getHeight();
            int height3 = height > rect2.height() ? rect2.height() : height;
            w.d("MicroMsg.SubMenuHelperBase", "menuHeightPercentPort(%f), menuHeightPercentLand(%f), frameHeight(%d), decorViewHeight(%d), menuHeight(%d)", Float.valueOf(this.woO), Float.valueOf(this.woP), Integer.valueOf(rect2.height()), Integer.valueOf(height3), Integer.valueOf(z ? (int) (this.woP * ((float) height3)) : (int) (this.woO * ((float) height3))));
            height = Math.round((float) (height / this.woM));
            if (height <= 0 || this.kjh == null) {
                w.e("MicroMsg.SubMenuHelperBase", "[cpan] setpopuHeight error.");
            } else {
                dimensionPixelSize = (this.woM * height) + this.woL;
                if (dimensionPixelSize == 0 || dimensionPixelSize >= this.kjh.getCount() * this.woM) {
                    w.w("MicroMsg.SubMenuHelperBase", "[cpan] menuheight:%d,listHeight:%d", Integer.valueOf(dimensionPixelSize), Integer.valueOf(this.kjh.getCount() * this.woM));
                } else {
                    this.vAy.XW = (((height - 1) * this.woM) + this.woL) + this.woN;
                }
            }
        }
        if (!(this.vAy == null || this.woJ == null)) {
            MMListPopupWindow mMListPopupWindow = this.vAy;
            View view = this.woJ;
            boolean isShowing = mMListPopupWindow.iuS.isShowing();
            if (isShowing) {
                mMListPopupWindow.Zw();
            }
            mMListPopupWindow.Ye = view;
            if (isShowing) {
                mMListPopupWindow.show();
            }
            this.vAy.Yf = this.woK;
        }
        this.vAy.show();
        this.vAy.vkP.setOnKeyListener(this);
        this.vAy.vkP.setSelector(new ColorDrawable(this.mContext.getResources().getColor(d.transparent)));
        this.vAy.vkP.setDividerHeight(0);
        this.vAy.vkP.setVerticalScrollBarEnabled(true);
        this.vAy.vkP.setHorizontalScrollBarEnabled(false);
        return true;
    }

    private boolean aKK() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return true;
        }
        return false;
    }

    public final void dismiss() {
        if (isShowing()) {
            this.vAy.dismiss();
        }
    }

    private int b(ListAdapter listAdapter) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i = 0;
        int i2 = 0;
        View view = null;
        int i3 = 0;
        while (i < count) {
            View view2;
            int itemViewType = listAdapter.getItemViewType(i);
            if (itemViewType != i2) {
                view2 = null;
            } else {
                itemViewType = i2;
                view2 = view;
            }
            if (this.Ro == null) {
                this.Ro = new FrameLayout(this.mContext);
            }
            view = listAdapter.getView(i, view2, this.Ro);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
            i++;
            i2 = itemViewType;
        }
        return i3;
    }

    public void onDismiss() {
        this.vAy = null;
        if (this.Rn != null) {
            if (!this.Rn.isAlive()) {
                this.Rn = this.hz.getViewTreeObserver();
            }
            this.Rn.removeGlobalOnLayoutListener(this);
            this.Rn = null;
        }
        if (this.woG != null) {
            this.woG.onCancel(null);
        }
        if (this.woH != null) {
            this.woH.onDismiss();
        }
    }

    public final boolean isShowing() {
        return this.vAy != null && this.vAy.iuS.isShowing();
    }

    public void onGlobalLayout() {
        w.v("MicroMsg.SubMenuHelperBase", "onGlobalLayout showing:%b, anchorshown:%b", Boolean.valueOf(isShowing()), Boolean.valueOf(this.hz.isShown()));
        if (isShowing()) {
            View view = this.hz;
            if (view == null || !view.isShown()) {
                dismiss();
            } else if (isShowing() && this.sjk != aKK()) {
                this.vAy.dismiss();
            }
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        w.v("MicroMsg.SubMenuHelperBase", "onKey");
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        dismiss();
    }
}
