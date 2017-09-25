package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelbiz.i;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.ui.base.MMListPopupWindow;
import java.util.List;

public final class y implements OnKeyListener, OnItemClickListener, OnDismissListener {
    public LayoutInflater Du;
    private int height;
    public Context mContext = null;
    public int mCount;
    private int vAA;
    public i vAB = null;
    private boolean vAC = true;
    OnItemClickListener vAv = null;
    private ViewGroup vAw = null;
    private b vAx = null;
    private MMListPopupWindow vAy;
    private int vAz = R.m.foG;

    public static class a {
        private static DisplayMetrics vpG = null;

        public static class a {
            public int jwE;
            public int jwF;

            public final String toString() {
                return " marginLeft:" + this.jwE + " marginRight:" + this.jwF;
            }
        }

        public static a a(Context context, TextPaint textPaint, List<i> list, int i) {
            a aVar = new a();
            if (vpG == null) {
                vpG = context.getResources().getDisplayMetrics();
            }
            DisplayMetrics displayMetrics = vpG;
            float f = 0.0f;
            for (i iVar : list) {
                float measureText = textPaint.measureText(iVar.name);
                if (f >= measureText) {
                    measureText = f;
                }
                f = measureText;
            }
            int fromDPToPix = (com.tencent.mm.bg.a.fromDPToPix(context, 30) * 2) + ((int) f);
            int fromDPToPix2 = com.tencent.mm.bg.a.fromDPToPix(context, 95);
            if (fromDPToPix >= fromDPToPix2) {
                fromDPToPix2 = fromDPToPix;
            }
            if (i - (fromDPToPix2 / 2) < 0) {
                aVar.jwE = 0;
                aVar.jwF = displayMetrics.widthPixels - (fromDPToPix2 + 0);
            } else if (displayMetrics.widthPixels - ((fromDPToPix2 / 2) + i) < 0) {
                aVar.jwE = displayMetrics.widthPixels - (fromDPToPix2 + 0);
                aVar.jwF = 0;
            } else {
                aVar.jwE = i - (fromDPToPix2 / 2);
                aVar.jwF = displayMetrics.widthPixels - ((fromDPToPix2 / 2) + i);
            }
            return aVar;
        }
    }

    private class b extends BaseAdapter {
        final /* synthetic */ y vAD;

        private b(y yVar) {
            this.vAD = yVar;
        }

        public final /* synthetic */ Object getItem(int i) {
            return AK(i);
        }

        public final int getCount() {
            return this.vAD.mCount;
        }

        private i AK(int i) {
            return (i) this.vAD.vAB.hvM.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            if (view == null) {
                view2 = (TextView) this.vAD.Du.inflate(R.i.dkM, viewGroup, false);
            } else {
                view2 = (TextView) view;
            }
            i AK = AK(i);
            view2.setTag(AK);
            view2.setText(h.a(this.vAD.mContext, AK.name));
            return view2;
        }
    }

    public y(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.vAw = viewGroup;
        this.Du = (LayoutInflater) context.getSystemService("layout_inflater");
        bTY();
        this.vAx = new b();
    }

    @SuppressLint({"WrongCall"})
    public final boolean a(i iVar, int i, int i2, boolean z) {
        if (isShowing() || iVar == null || iVar.hvM == null || iVar.hvM.size() <= 0) {
            return false;
        }
        this.vAC = false;
        this.vAB = iVar;
        this.mCount = iVar.hvM.size();
        this.vAx.notifyDataSetChanged();
        this.height = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getHeight();
        a a = a.a(this.mContext, ((TextView) ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.i.dkM, null)).getPaint(), iVar.hvM, i);
        this.vAA = (i2 - (this.vAx.getCount() * this.mContext.getResources().getDimensionPixelSize(R.f.aXQ))) - this.mContext.getResources().getDimensionPixelSize(R.f.aXl);
        new StringBuilder("showPointY=").append(i2).append("verticalOffset=").append(this.vAA);
        this.vAy = new MMListPopupWindow(this.mContext, null, 0);
        this.vAy.setOnDismissListener(this);
        this.vAy.Yi = this.vAv;
        this.vAy.setAdapter(this.vAx);
        this.vAy.fe();
        this.vAy.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.g.bkn));
        this.vAy.setAnimationStyle(this.vAz);
        this.vAy.XX = a.jwF;
        this.vAy.setVerticalOffset(this.vAA);
        this.vAy.Yg = this.vAw;
        this.vAy.setContentWidth(b(this.vAx));
        this.vAy.ff();
        this.vAy.show();
        this.vAy.vkP.setOnKeyListener(this);
        this.vAy.vkP.setDivider(new ColorDrawable(this.mContext.getResources().getColor(R.e.aVQ)));
        this.vAy.vkP.setSelector(this.mContext.getResources().getDrawable(R.g.biv));
        this.vAy.vkP.setDividerHeight(1);
        this.vAy.vkP.setVerticalScrollBarEnabled(false);
        this.vAy.vkP.setHorizontalScrollBarEnabled(false);
        return true;
    }

    public final boolean isShowing() {
        return this.vAy != null && this.vAy.iuS.isShowing();
    }

    public final boolean bTY() {
        if (!isShowing()) {
            return false;
        }
        this.vAy.dismiss();
        return true;
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
            if (this.vAw == null) {
                this.vAw = new FrameLayout(this.mContext);
            }
            view = listAdapter.getView(i, view2, this.vAw);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
            i++;
            i2 = itemViewType;
        }
        return i3;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        return false;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public final void onDismiss() {
    }
}
