package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.d;
import android.support.v4.view.z;
import android.support.v7.a.a.f;
import android.support.v7.a.a.h;
import android.support.v7.a.a.i;
import android.support.v7.a.a.k;
import android.support.v7.widget.d.c;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.wcdb.database.SQLiteGlobal;

public class ActivityChooserView extends ViewGroup {
    private final a TE;
    private final b TF;
    private final LinearLayoutCompat TG;
    private final Drawable TH;
    private final FrameLayout TI;
    private final ImageView TJ;
    private final FrameLayout TK;
    private final ImageView TL;
    private final int TM;
    d TN;
    private final DataSetObserver TO;
    private final OnGlobalLayoutListener TP;
    private ListPopupWindow TQ;
    private OnDismissListener TR;
    boolean TS;
    int TT;
    private int TU;
    boolean hi;

    public static class InnerLayout extends LinearLayoutCompat {
        private static final int[] PZ = new int[]{16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            ap a = ap.a(context, attributeSet, PZ);
            setBackgroundDrawable(a.getDrawable(0));
            a.aeG.recycle();
        }
    }

    private class a extends BaseAdapter {
        final /* synthetic */ ActivityChooserView TV;
        d TW;
        private int TX;
        boolean TY;
        private boolean TZ;
        private boolean Ua;

        private a(ActivityChooserView activityChooserView) {
            this.TV = activityChooserView;
            this.TX = 4;
        }

        public final int getItemViewType(int i) {
            if (this.Ua && i == getCount() - 1) {
                return 1;
            }
            return 0;
        }

        public final int getViewTypeCount() {
            return 3;
        }

        public final int getCount() {
            int ef = this.TW.ef();
            if (!(this.TY || this.TW.eg() == null)) {
                ef--;
            }
            ef = Math.min(ef, this.TX);
            if (this.Ua) {
                return ef + 1;
            }
            return ef;
        }

        public final Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!(this.TY || this.TW.eg() == null)) {
                        i++;
                    }
                    return this.TW.aC(i);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != f.Ke) {
                        view = LayoutInflater.from(this.TV.getContext()).inflate(h.KE, viewGroup, false);
                    }
                    PackageManager packageManager = this.TV.getContext().getPackageManager();
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    ((ImageView) view.findViewById(f.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(f.title)).setText(resolveInfo.loadLabel(packageManager));
                    if (this.TY && i == 0 && this.TZ) {
                        z.b(view, true);
                        return view;
                    }
                    z.b(view, false);
                    return view;
                case 1:
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    view = LayoutInflater.from(this.TV.getContext()).inflate(h.KE, viewGroup, false);
                    view.setId(1);
                    ((TextView) view.findViewById(f.title)).setText(this.TV.getContext().getString(i.KT));
                    return view;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public final int eq() {
            int i = 0;
            int i2 = this.TX;
            this.TX = Integer.MAX_VALUE;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i3 = 0;
            while (i < count) {
                view = getView(i, view, null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i3 = Math.max(i3, view.getMeasuredWidth());
                i++;
            }
            this.TX = i2;
            return i3;
        }

        public final void aF(int i) {
            if (this.TX != i) {
                this.TX = i;
                notifyDataSetChanged();
            }
        }

        public final void L(boolean z) {
            if (this.Ua != z) {
                this.Ua = z;
                notifyDataSetChanged();
            }
        }

        public final void b(boolean z, boolean z2) {
            if (this.TY != z || this.TZ != z2) {
                this.TY = z;
                this.TZ = z2;
                notifyDataSetChanged();
            }
        }
    }

    private class b implements OnClickListener, OnLongClickListener, OnItemClickListener, OnDismissListener {
        final /* synthetic */ ActivityChooserView TV;

        public b(ActivityChooserView activityChooserView) {
            this.TV = activityChooserView;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((a) adapterView.getAdapter()).getItemViewType(i)) {
                case 0:
                    this.TV.en();
                    if (!this.TV.TS) {
                        if (!this.TV.TE.TY) {
                            i++;
                        }
                        Intent aD = this.TV.TE.TW.aD(i);
                        if (aD != null) {
                            aD.addFlags(SQLiteGlobal.journalSizeLimit);
                            this.TV.getContext().startActivity(aD);
                            return;
                        }
                        return;
                    } else if (i > 0) {
                        d dVar = this.TV.TE.TW;
                        synchronized (dVar.Tr) {
                            dVar.eh();
                            android.support.v7.widget.d.a aVar = (android.support.v7.widget.d.a) dVar.Ts.get(i);
                            android.support.v7.widget.d.a aVar2 = (android.support.v7.widget.d.a) dVar.Ts.get(0);
                            dVar.a(new c(new ComponentName(aVar.resolveInfo.activityInfo.packageName, aVar.resolveInfo.activityInfo.name), System.currentTimeMillis(), aVar2 != null ? (aVar2.weight - aVar.weight) + 5.0f : 1.0f));
                        }
                        return;
                    } else {
                        return;
                    }
                case 1:
                    this.TV.aE(Integer.MAX_VALUE);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public final void onClick(View view) {
            if (view == this.TV.TK) {
                this.TV.en();
                Intent aD = this.TV.TE.TW.aD(this.TV.TE.TW.a(this.TV.TE.TW.eg()));
                if (aD != null) {
                    aD.addFlags(SQLiteGlobal.journalSizeLimit);
                    this.TV.getContext().startActivity(aD);
                }
            } else if (view == this.TV.TI) {
                this.TV.TS = false;
                this.TV.aE(this.TV.TT);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public final boolean onLongClick(View view) {
            if (view == this.TV.TK) {
                if (this.TV.TE.getCount() > 0) {
                    this.TV.TS = true;
                    this.TV.aE(this.TV.TT);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        public final void onDismiss() {
            if (this.TV.TR != null) {
                this.TV.TR.onDismiss();
            }
            if (this.TV.TN != null) {
                this.TV.TN.p(false);
            }
        }
    }

    static /* synthetic */ void c(ActivityChooserView activityChooserView) {
        if (activityChooserView.TE.getCount() > 0) {
            activityChooserView.TI.setEnabled(true);
        } else {
            activityChooserView.TI.setEnabled(false);
        }
        int ef = activityChooserView.TE.TW.ef();
        int historySize = activityChooserView.TE.TW.getHistorySize();
        if (ef == 1 || (ef > 1 && historySize > 0)) {
            activityChooserView.TK.setVisibility(0);
            ResolveInfo eg = activityChooserView.TE.TW.eg();
            PackageManager packageManager = activityChooserView.getContext().getPackageManager();
            activityChooserView.TL.setImageDrawable(eg.loadIcon(packageManager));
            if (activityChooserView.TU != 0) {
                CharSequence loadLabel = eg.loadLabel(packageManager);
                activityChooserView.TK.setContentDescription(activityChooserView.getContext().getString(activityChooserView.TU, new Object[]{loadLabel}));
            }
        } else {
            activityChooserView.TK.setVisibility(8);
        }
        if (activityChooserView.TK.getVisibility() == 0) {
            activityChooserView.TG.setBackgroundDrawable(activityChooserView.TH);
        } else {
            activityChooserView.TG.setBackgroundDrawable(null);
        }
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TO = new DataSetObserver(this) {
            final /* synthetic */ ActivityChooserView TV;

            {
                this.TV = r1;
            }

            public final void onChanged() {
                super.onChanged();
                this.TV.TE.notifyDataSetChanged();
            }

            public final void onInvalidated() {
                super.onInvalidated();
                this.TV.TE.notifyDataSetInvalidated();
            }
        };
        this.TP = new OnGlobalLayoutListener(this) {
            final /* synthetic */ ActivityChooserView TV;

            {
                this.TV = r1;
            }

            public final void onGlobalLayout() {
                if (!this.TV.eo()) {
                    return;
                }
                if (this.TV.isShown()) {
                    this.TV.ep().show();
                    if (this.TV.TN != null) {
                        this.TV.TN.p(true);
                        return;
                    }
                    return;
                }
                this.TV.ep().dismiss();
            }
        };
        this.TT = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.ba, i, 0);
        this.TT = obtainStyledAttributes.getInt(k.Lx, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(k.Lw);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(h.KD, this, true);
        this.TF = new b(this);
        this.TG = (LinearLayoutCompat) findViewById(f.JU);
        this.TH = this.TG.getBackground();
        this.TK = (FrameLayout) findViewById(f.Ka);
        this.TK.setOnClickListener(this.TF);
        this.TK.setOnLongClickListener(this.TF);
        this.TL = (ImageView) this.TK.findViewById(f.Kd);
        FrameLayout frameLayout = (FrameLayout) findViewById(f.Kc);
        frameLayout.setOnClickListener(this.TF);
        frameLayout.setOnTouchListener(new android.support.v7.widget.ListPopupWindow.b(this, frameLayout) {
            final /* synthetic */ ActivityChooserView TV;

            public final ListPopupWindow do() {
                return this.TV.ep();
            }

            protected final boolean dp() {
                ActivityChooserView activityChooserView = this.TV;
                if (!activityChooserView.eo() && activityChooserView.hi) {
                    activityChooserView.TS = false;
                    activityChooserView.aE(activityChooserView.TT);
                }
                return true;
            }

            protected final boolean ea() {
                this.TV.en();
                return true;
            }
        });
        this.TI = frameLayout;
        this.TJ = (ImageView) frameLayout.findViewById(f.Kd);
        this.TJ.setImageDrawable(drawable);
        this.TE = new a();
        this.TE.registerDataSetObserver(new DataSetObserver(this) {
            final /* synthetic */ ActivityChooserView TV;

            {
                this.TV = r1;
            }

            public final void onChanged() {
                super.onChanged();
                ActivityChooserView.c(this.TV);
            }
        });
        Resources resources = context.getResources();
        this.TM = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(android.support.v7.a.a.d.IS));
    }

    final void aE(int i) {
        if (this.TE.TW == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.TP);
        boolean z = this.TK.getVisibility() == 0;
        int ef = this.TE.TW.ef();
        int i2;
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i == Integer.MAX_VALUE || ef <= r3 + i) {
            this.TE.L(false);
            this.TE.aF(i);
        } else {
            this.TE.L(true);
            this.TE.aF(i - 1);
        }
        ListPopupWindow ep = ep();
        if (!ep.XU.isShowing()) {
            if (this.TS || !z) {
                this.TE.b(true, z);
            } else {
                this.TE.b(false, false);
            }
            ep.setContentWidth(Math.min(this.TE.eq(), this.TM));
            ep.show();
            if (this.TN != null) {
                this.TN.p(true);
            }
            ep.XV.setContentDescription(getContext().getString(i.KU));
        }
    }

    public final boolean en() {
        if (ep().XU.isShowing()) {
            ep().dismiss();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.TP);
            }
        }
        return true;
    }

    public final boolean eo() {
        return ep().XU.isShowing();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d dVar = this.TE.TW;
        if (dVar != null) {
            dVar.registerObserver(this.TO);
        }
        this.hi = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dVar = this.TE.TW;
        if (dVar != null) {
            dVar.unregisterObserver(this.TO);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.TP);
        }
        if (eo()) {
            en();
        }
        this.hi = false;
    }

    protected void onMeasure(int i, int i2) {
        View view = this.TG;
        if (this.TK.getVisibility() != 0) {
            i2 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.TG.layout(0, 0, i3 - i, i4 - i2);
        if (!eo()) {
            en();
        }
    }

    private ListPopupWindow ep() {
        if (this.TQ == null) {
            this.TQ = new ListPopupWindow(getContext());
            this.TQ.setAdapter(this.TE);
            this.TQ.Yg = this;
            this.TQ.fe();
            this.TQ.Yi = this.TF;
            this.TQ.setOnDismissListener(this.TF);
        }
        return this.TQ;
    }
}
