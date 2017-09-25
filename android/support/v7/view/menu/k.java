package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.a.a.d;
import android.support.v7.a.a.h;
import android.support.v7.widget.ListPopupWindow;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
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
import java.util.ArrayList;

public class k implements l, OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, OnDismissListener {
    static final int Rg = h.KL;
    public final LayoutInflater Du;
    public android.support.v7.view.menu.l.a QM;
    public boolean Qh;
    private final a Rh;
    public final boolean Ri;
    private final int Rj;
    private final int Rk;
    private final int Rl;
    public ListPopupWindow Rm;
    private ViewTreeObserver Rn;
    private ViewGroup Ro;
    private boolean Rp;
    private int Rq;
    public int Rr = 8388613;
    public final f dW;
    public View hz;
    private final Context mContext;

    private class a extends BaseAdapter {
        private int Qm = -1;
        private f Rs;
        final /* synthetic */ k Rt;

        public final /* synthetic */ Object getItem(int i) {
            return ax(i);
        }

        public a(k kVar, f fVar) {
            this.Rt = kVar;
            this.Rs = fVar;
            dr();
        }

        public final int getCount() {
            ArrayList dB = this.Rt.Ri ? this.Rs.dB() : this.Rs.dz();
            if (this.Qm < 0) {
                return dB.size();
            }
            return dB.size() - 1;
        }

        public final h ax(int i) {
            ArrayList dB = this.Rt.Ri ? this.Rs.dB() : this.Rs.dz();
            if (this.Qm >= 0 && i >= this.Qm) {
                i++;
            }
            return (h) dB.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            if (view == null) {
                inflate = this.Rt.Du.inflate(k.Rg, viewGroup, false);
            } else {
                inflate = view;
            }
            android.support.v7.view.menu.m.a aVar = (android.support.v7.view.menu.m.a) inflate;
            if (this.Rt.Qh) {
                ListMenuItemView listMenuItemView = (ListMenuItemView) inflate;
                listMenuItemView.Qh = true;
                listMenuItemView.Qf = true;
            }
            aVar.a(ax(i));
            return inflate;
        }

        private void dr() {
            h hVar = this.Rt.dW.QI;
            if (hVar != null) {
                ArrayList dB = this.Rt.dW.dB();
                int size = dB.size();
                for (int i = 0; i < size; i++) {
                    if (((h) dB.get(i)) == hVar) {
                        this.Qm = i;
                        return;
                    }
                }
            }
            this.Qm = -1;
        }

        public final void notifyDataSetChanged() {
            dr();
            super.notifyDataSetChanged();
        }
    }

    private k(Context context, f fVar, View view) {
        this(context, fVar, view, false, android.support.v7.a.a.a.popupMenuStyle);
    }

    public k(Context context, f fVar, View view, boolean z, int i) {
        this(context, fVar, view, z, i, (byte) 0);
    }

    private k(Context context, f fVar, View view, boolean z, int i, byte b) {
        this.Rr = 0;
        this.mContext = context;
        this.Du = LayoutInflater.from(context);
        this.dW = fVar;
        this.Rh = new a(this, this.dW);
        this.Ri = z;
        this.Rk = i;
        this.Rl = 0;
        Resources resources = context.getResources();
        this.Rj = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.IS));
        this.hz = view;
        fVar.a((l) this, context);
    }

    public final boolean dL() {
        int i = 0;
        this.Rm = new ListPopupWindow(this.mContext, null, this.Rk, this.Rl);
        this.Rm.setOnDismissListener(this);
        this.Rm.Yi = this;
        this.Rm.setAdapter(this.Rh);
        this.Rm.fe();
        View view = this.hz;
        if (view == null) {
            return false;
        }
        boolean z = this.Rn == null;
        this.Rn = view.getViewTreeObserver();
        if (z) {
            this.Rn.addOnGlobalLayoutListener(this);
        }
        this.Rm.Yg = view;
        this.Rm.Rr = this.Rr;
        if (!this.Rp) {
            ListAdapter listAdapter = this.Rh;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
            int count = listAdapter.getCount();
            int i2 = 0;
            int i3 = 0;
            View view2 = null;
            while (i2 < count) {
                View view3;
                int itemViewType = listAdapter.getItemViewType(i2);
                if (itemViewType != i3) {
                    i3 = itemViewType;
                    view3 = null;
                } else {
                    view3 = view2;
                }
                if (this.Ro == null) {
                    this.Ro = new FrameLayout(this.mContext);
                }
                view2 = listAdapter.getView(i2, view3, this.Ro);
                view2.measure(makeMeasureSpec, makeMeasureSpec2);
                itemViewType = view2.getMeasuredWidth();
                if (itemViewType >= this.Rj) {
                    i = this.Rj;
                    break;
                }
                if (itemViewType <= i) {
                    itemViewType = i;
                }
                i2++;
                i = itemViewType;
            }
            this.Rq = i;
            this.Rp = true;
        }
        this.Rm.setContentWidth(this.Rq);
        this.Rm.ff();
        this.Rm.show();
        this.Rm.XV.setOnKeyListener(this);
        return true;
    }

    public final void dismiss() {
        if (isShowing()) {
            this.Rm.dismiss();
        }
    }

    public void onDismiss() {
        this.Rm = null;
        this.dW.close();
        if (this.Rn != null) {
            if (!this.Rn.isAlive()) {
                this.Rn = this.hz.getViewTreeObserver();
            }
            this.Rn.removeGlobalOnLayoutListener(this);
            this.Rn = null;
        }
    }

    public final boolean isShowing() {
        return this.Rm != null && this.Rm.XU.isShowing();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a aVar = this.Rh;
        aVar.Rs.a(aVar.ax(i), null, 0);
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void onGlobalLayout() {
        if (isShowing()) {
            View view = this.hz;
            if (view == null || !view.isShown()) {
                dismiss();
            } else if (isShowing()) {
                this.Rm.show();
            }
        }
    }

    public final void a(Context context, f fVar) {
    }

    public final void f(boolean z) {
        this.Rp = false;
        if (this.Rh != null) {
            this.Rh.notifyDataSetChanged();
        }
    }

    public final boolean a(p pVar) {
        if (pVar.hasVisibleItems()) {
            boolean z;
            k kVar = new k(this.mContext, pVar, this.hz);
            kVar.QM = this.QM;
            int size = pVar.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = pVar.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            z = false;
            kVar.Qh = z;
            if (kVar.dL()) {
                if (this.QM == null) {
                    return true;
                }
                this.QM.d(pVar);
                return true;
            }
        }
        return false;
    }

    public final void a(f fVar, boolean z) {
        if (fVar == this.dW) {
            dismiss();
            if (this.QM != null) {
                this.QM.a(fVar, z);
            }
        }
    }

    public final boolean B() {
        return false;
    }

    public final boolean b(h hVar) {
        return false;
    }

    public final boolean c(h hVar) {
        return false;
    }

    public final int getId() {
        return 0;
    }

    public final Parcelable onSaveInstanceState() {
        return null;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
    }
}
