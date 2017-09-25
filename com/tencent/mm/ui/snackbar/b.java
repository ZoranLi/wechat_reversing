package com.tencent.mm.ui.snackbar;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.s.a.d;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.x;

public final class b {
    public ae mHandler = new ae();
    View mParentView;
    public SnackContainer wjN;
    public b wjO;
    c wjP;
    private final OnClickListener wjQ = new OnClickListener(this) {
        final /* synthetic */ b wjR;

        {
            this.wjR = r1;
        }

        public final void onClick(View view) {
            if (this.wjR.wjO != null && this.wjR.wjN.isShowing()) {
                this.wjR.wjO.aAt();
            }
            this.wjR.mHandler.postDelayed(new Runnable(this) {
                final /* synthetic */ AnonymousClass2 wjT;

                {
                    this.wjT = r1;
                }

                public final void run() {
                    this.wjT.wjR.wjN.hide();
                }
            }, 100);
        }
    };

    public static class a {
        private Context mContext;
        String mMessage;
        String wjI;
        private int wjJ = 0;
        private Parcelable wjK;
        private short wjL = (short) 3500;
        b wjU;
        int wjV = 0;
        private int xT = -1;

        public a(Activity activity) {
            this.mContext = activity.getApplicationContext();
            this.wjU = new b(activity, this.wjV);
        }

        public a(Context context, View view) {
            this.mContext = context;
            this.wjU = new b(context, view, this.wjV);
        }

        public final a a(Short sh) {
            this.wjL = sh.shortValue();
            return this;
        }

        public final b bZq() {
            int i;
            String str = this.mMessage;
            String toUpperCase = this.wjI != null ? this.wjI.toUpperCase() : null;
            int i2 = this.wjJ;
            Parcelable parcelable = this.wjK;
            short s = this.wjL;
            if (this.xT != -1) {
                i = this.xT;
            } else {
                i = this.mContext.getResources().getColor(d.aWu);
            }
            Snack snack = new Snack(str, toUpperCase, i2, parcelable, s, i);
            b bVar = this.wjU;
            ViewParent viewParent = bVar.wjN;
            View view = bVar.mParentView;
            c cVar = bVar.wjP;
            if (!(view.getParent() == null || view.getParent() == viewParent)) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            a aVar = new a(snack, view, cVar);
            viewParent.wjW.offer(aVar);
            if (viewParent.wjW.size() == 1) {
                viewParent.a(aVar, false);
            }
            return this.wjU;
        }
    }

    public interface b {
        void aAt();
    }

    public interface c {
        void azn();

        void azo();

        void onHide();
    }

    public b(Activity activity, int i) {
        View childAt = ((ViewGroup) activity.findViewById(16908290)).getChildAt(0);
        if (childAt == null) {
            childAt = activity.findViewById(16908290);
        }
        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService("layout_inflater");
        layoutInflater.inflate(h.heL, (ViewGroup) childAt);
        a((ViewGroup) childAt, layoutInflater.inflate(h.heM, (ViewGroup) childAt, false), i, activity);
    }

    public b(Context context, View view, int i) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        layoutInflater.inflate(h.heL, (ViewGroup) view);
        a((ViewGroup) view, layoutInflater.inflate(h.heM, (ViewGroup) view, false), i, context);
    }

    private void a(ViewGroup viewGroup, View view, int i, Context context) {
        boolean z;
        this.wjN = (SnackContainer) viewGroup.findViewById(g.hdd);
        if (this.wjN == null) {
            this.wjN = new SnackContainer(viewGroup);
        }
        this.mParentView = view;
        if (i == 36) {
            this.wjN.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ b wjR;

                {
                    this.wjR = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (a.asn() && this.wjR.wjN.isShowing()) {
                        a.lD(false);
                        this.wjR.mHandler.postDelayed(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 wjS;

                            {
                                this.wjS = r1;
                            }

                            public final void run() {
                                this.wjS.wjR.wjN.hide();
                            }
                        }, 100);
                    }
                    return true;
                }
            });
        }
        ((TextView) view.findViewById(g.hdc)).setOnClickListener(this.wjQ);
        w.i("MicroMsg.SnackBar", "snackbar:isNavBarVisibility : %B,navBarHeightd:%d", Boolean.valueOf(x.eF(context)), Integer.valueOf(x.eE(context)));
        Activity activity = (Activity) context;
        if (com.tencent.mm.compatible.util.d.eo(19)) {
            LayoutParams attributes = activity.getWindow().getAttributes();
            if (attributes.flags == ((attributes.flags & -134217729) | 134217728)) {
                z = true;
                w.i("MicroMsg.SnackBar", "snackbar:isNavBarTranslucent : %B", Boolean.valueOf(z));
                if (z && r3) {
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(g.hdb);
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) linearLayout.getLayoutParams();
                    marginLayoutParams.bottomMargin = r4;
                    linearLayout.setLayoutParams(marginLayoutParams);
                    return;
                }
            }
        }
        z = false;
        w.i("MicroMsg.SnackBar", "snackbar:isNavBarTranslucent : %B", Boolean.valueOf(z));
        if (z) {
        }
    }
}
