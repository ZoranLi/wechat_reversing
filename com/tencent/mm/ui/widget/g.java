package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mm.bm.a.b;
import com.tencent.mm.bm.a.c;
import com.tencent.mm.bm.a.e;
import com.tencent.mm.bm.a.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.o;

public class g implements OnKeyListener, OnItemClickListener, OnDismissListener {
    public static int kaQ;
    public static int kaR;
    public static boolean wvF = false;
    public LayoutInflater Du;
    private DisplayMetrics aQa;
    private Context mContext = null;
    public View nlq;
    public d qJg;
    public l qJh;
    public MMListPopupWindow vAy;
    public View vya = null;
    public o wvA;
    private int wvB;
    private boolean wvC = false;
    public View wvD;
    public OnCreateContextMenuListener wvE;
    private boolean wvG = false;
    private a wvz = null;

    private class a extends BaseAdapter {
        final /* synthetic */ g wvI;

        private a(g gVar) {
            this.wvI = gVar;
        }

        public final /* synthetic */ Object getItem(int i) {
            return hO(i);
        }

        public final int getCount() {
            return this.wvI.qJh.size();
        }

        private String hO(int i) {
            return (String) ((MenuItem) this.wvI.qJh.vla.get(i)).getTitle();
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            if (view == null) {
                view2 = (TextView) this.wvI.Du.inflate(f.dkM, viewGroup, false);
            } else {
                view2 = (TextView) view;
            }
            CharSequence hO = hO(i);
            view2.setTag(hO);
            view2.setText(hO);
            return view2;
        }
    }

    public g(Context context, View view) {
        this.mContext = context;
        this.vya = view;
        this.Du = (LayoutInflater) context.getSystemService("layout_inflater");
        KC();
        caD();
    }

    public g(Context context) {
        this.mContext = context;
        this.Du = (LayoutInflater) context.getSystemService("layout_inflater");
        KC();
    }

    public final void c(View view, final OnCreateContextMenuListener onCreateContextMenuListener, d dVar) {
        this.vya = view;
        caD();
        this.qJg = dVar;
        if (view instanceof AbsListView) {
            w.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView");
            ((AbsListView) view).setOnItemLongClickListener(new OnItemLongClickListener(this) {
                final /* synthetic */ g wvI;

                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.wvI.qJh.clear();
                    w.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView long click");
                    ContextMenuInfo adapterContextMenuInfo = new AdapterContextMenuInfo(view, i, j);
                    onCreateContextMenuListener.onCreateContextMenu(this.wvI.qJh, view, adapterContextMenuInfo);
                    for (MenuItem menuItem : this.wvI.qJh.vla) {
                        ((m) menuItem).vld = adapterContextMenuInfo;
                    }
                    this.wvI.bv(0, 0);
                    return true;
                }
            });
            return;
        }
        w.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view");
        view.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ g wvI;

            public final boolean onLongClick(View view) {
                w.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view long click");
                this.wvI.qJh.clear();
                this.wvI.vya = view;
                onCreateContextMenuListener.onCreateContextMenu(this.wvI.qJh, view, null);
                if (view.getTag(e.cJw) instanceof int[]) {
                    int[] iArr = (int[]) view.getTag(e.cJw);
                    this.wvI.bv(iArr[0], iArr[1]);
                } else {
                    this.wvI.bv(0, 0);
                }
                return true;
            }
        });
    }

    public final void a(View view, int i, long j, OnCreateContextMenuListener onCreateContextMenuListener, d dVar, int i2, int i3) {
        this.qJg = dVar;
        this.vya = view;
        caD();
        this.qJh.clear();
        ContextMenuInfo adapterContextMenuInfo = new AdapterContextMenuInfo(view, i, j);
        onCreateContextMenuListener.onCreateContextMenu(this.qJh, view, adapterContextMenuInfo);
        for (MenuItem menuItem : this.qJh.vla) {
            ((m) menuItem).vld = adapterContextMenuInfo;
        }
        if (i2 == 0 && i3 == 0) {
            bv(0, 0);
        } else {
            bv(i2, i3);
        }
    }

    public final void a(View view, OnCreateContextMenuListener onCreateContextMenuListener, d dVar, int i, int i2) {
        this.qJg = dVar;
        this.vya = view;
        if (!(view instanceof TextView) && (i == 0 || i2 == 0)) {
            caD();
        }
        this.qJh.clear();
        onCreateContextMenuListener.onCreateContextMenu(this.qJh, view, null);
        if (i == 0 && i2 == 0) {
            bv(0, 0);
        } else {
            bv(i, i2);
        }
    }

    private boolean eq(int i, int i2) {
        if (isShowing() || caC()) {
            return false;
        }
        if (this.wvE != null) {
            this.wvE.onCreateContextMenu(this.qJh, this.vya, null);
        }
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(f.dkM, null);
        int count = this.wvz.getCount() * this.mContext.getResources().getDimensionPixelSize(c.aXQ);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(c.wzX);
        ListAdapter listAdapter = this.wvz;
        int i3 = 0;
        View view = null;
        int i4 = 0;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count2 = listAdapter.getCount();
        int i5 = 0;
        while (i5 < count2) {
            View view2;
            int itemViewType = listAdapter.getItemViewType(i5);
            if (itemViewType != i4) {
                view2 = null;
            } else {
                itemViewType = i4;
                view2 = view;
            }
            view = listAdapter.getView(i5, view2, new FrameLayout(this.mContext));
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
            i5++;
            i4 = itemViewType;
        }
        i4 = com.tencent.mm.bg.a.U(this.mContext, c.wzY);
        if (i3 >= i4) {
            i4 = i3;
        }
        boolean z = true;
        if (this.qJh.size() >= 3) {
            z = false;
        }
        if (!this.wvC) {
            if (this.wvD != null) {
                this.wvD.setSelected(true);
            } else {
                this.vya.setSelected(true);
            }
        }
        if (this.wvG) {
            er(i, i2);
        } else {
            com.tencent.mm.ui.base.w.a a = com.tencent.mm.ui.base.w.a(this.mContext, i4, i, i2, count, dimensionPixelSize, z);
            this.wvB = i2 - this.mContext.getResources().getDimensionPixelSize(c.wzX);
            w.d("MicroMsg.MMPopupMenu", "showPointY=" + i2 + "verticalOffset=" + this.wvB);
            this.vAy = new MMListPopupWindow(this.mContext, null, 0);
            this.vAy.setOnDismissListener(this);
            this.vAy.Yi = new OnItemClickListener(this) {
                final /* synthetic */ g wvI;

                {
                    this.wvI = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (this.wvI.qJg != null) {
                        this.wvI.qJg.c(this.wvI.qJh.getItem(i), i);
                    }
                    if (this.wvI.vAy != null && this.wvI.vAy.iuS.isShowing()) {
                        this.wvI.vAy.dismiss();
                    }
                }
            };
            this.vAy.setAdapter(this.wvz);
            this.vAy.fe();
            this.vAy.setBackgroundDrawable(this.mContext.getResources().getDrawable(com.tencent.mm.bm.a.d.bkn));
            this.vAy.setAnimationStyle(a.vpH);
            this.vAy.XX = a.jwF;
            this.vAy.setVerticalOffset(a.qLb);
            this.vAy.Yg = this.vya;
            this.vAy.setContentWidth(i4);
            this.vAy.ff();
            this.vAy.show();
            this.vAy.vkP.setOnKeyListener(this);
            this.vAy.vkP.setDivider(new ColorDrawable(this.mContext.getResources().getColor(b.aVQ)));
            this.vAy.vkP.setSelector(this.mContext.getResources().getDrawable(com.tencent.mm.bm.a.d.biv));
            this.vAy.vkP.setDividerHeight(0);
            this.vAy.vkP.setVerticalScrollBarEnabled(false);
            this.vAy.vkP.setHorizontalScrollBarEnabled(false);
        }
        return true;
    }

    private void er(int i, int i2) {
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(c.aXH);
        int dimensionPixelOffset2 = this.mContext.getResources().getDimensionPixelOffset(c.aXt);
        this.wvA = new o(this.mContext);
        this.wvA.setWidth(-2);
        this.wvA.setHeight(-2);
        this.wvA.setBackgroundDrawable(this.mContext.getResources().getDrawable(com.tencent.mm.bm.a.d.bkn));
        View linearLayout = new LinearLayout(this.mContext);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundColor(this.mContext.getResources().getColor(b.white));
        for (int i3 = 0; i3 < this.qJh.size(); i3++) {
            TextView textView = (TextView) this.Du.inflate(f.wAj, null, false);
            textView.setBackground(this.mContext.getResources().getDrawable(com.tencent.mm.bm.a.d.biv));
            if (i3 == 0) {
                textView.setPadding(dimensionPixelOffset2, 0, dimensionPixelOffset, 0);
            } else if (i3 == this.qJh.size() - 1) {
                textView.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset2, 0);
            }
            textView.setText(((MenuItem) this.qJh.vla.get(i3)).getTitle());
            textView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ g wvI;

                public final void onClick(View view) {
                    if (this.wvI.qJg != null) {
                        this.wvI.qJg.c(this.wvI.qJh.getItem(i3), i3);
                    }
                    this.wvI.wvA.dismiss();
                }
            });
            linearLayout.addView(textView);
        }
        linearLayout.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = linearLayout.getMeasuredHeight();
        this.wvA.setContentView(linearLayout);
        this.wvA.showAtLocation(this.vya, 0, i, i2 - measuredHeight);
    }

    private boolean isShowing() {
        return this.vAy != null && this.vAy.iuS.isShowing();
    }

    private boolean caC() {
        return this.wvA != null && this.wvA.isShowing();
    }

    private boolean bTY() {
        if (isShowing()) {
            if (this.vAy == null) {
                return true;
            }
            this.vAy.dismiss();
            return true;
        } else if (!caC()) {
            return false;
        } else {
            if (this.wvA == null) {
                return true;
            }
            this.wvA.dismiss();
            return true;
        }
    }

    public boolean bv(int i, int i2) {
        int i3;
        if (!((this.vya.equals(this.nlq) && wvF) || (i == 0 && i2 == 0))) {
            kaQ = i;
            kaR = i2;
        }
        this.nlq = null;
        int i4 = kaQ;
        int i5 = kaR;
        wvF = false;
        if (this.aQa == null) {
            this.aQa = this.mContext.getResources().getDisplayMetrics();
        }
        if (this.vya != null) {
            int[] iArr = new int[2];
            this.vya.getLocationOnScreen(iArr);
            if (i4 == 0) {
                i4 = iArr[0] + (this.vya.getWidth() / 2);
            }
            i3 = iArr[1];
            int height = iArr[1] + this.vya.getHeight();
            if (i3 < 0) {
                i3 = 0;
            }
            if (height > this.aQa.heightPixels) {
                height = this.aQa.heightPixels;
            }
            if (i5 == 0) {
                int i6 = (i3 + height) / 2;
                i3 = i4;
                i4 = i6;
                w.i("MicroMsg.MMPopupMenu", "show popMenu , xDown:%s, yDown:%s, showPointX:%s, showPointY:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                if (isShowing() || !caC()) {
                    return eq(i3, i4);
                }
                return eq(i3, i4) & bTY();
            }
        }
        i3 = i4;
        i4 = i5;
        w.i("MicroMsg.MMPopupMenu", "show popMenu , xDown:%s, yDown:%s, showPointX:%s, showPointY:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (isShowing()) {
        }
        return eq(i3, i4);
    }

    private void KC() {
        bTY();
        this.qJh = new l();
        this.wvz = new a();
        this.aQa = this.mContext.getResources().getDisplayMetrics();
    }

    private void caD() {
        this.vya.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ g wvI;

            {
                this.wvI = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        g.kaQ = (int) motionEvent.getRawX();
                        g.kaR = (int) motionEvent.getRawY();
                        this.wvI.nlq = this.wvI.vya;
                        g.wvF = true;
                        w.i("MicroMsg.MMPopupMenu", "popmenu view set , x_down=" + g.kaQ + "y_down=" + g.kaR);
                        break;
                }
                return false;
            }
        });
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        return false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public void onDismiss() {
        if (!this.wvC) {
            if (this.wvD != null) {
                this.wvD.setSelected(false);
            } else {
                this.vya.setSelected(false);
            }
        }
    }
}
