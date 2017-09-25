package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnHoverListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.rr;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.plugin.appbrand.jsapi.map.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.o;

public final class be {
    public static b vCD = new b();

    public static class a implements OnTouchListener {
        private int sl;

        public a() {
            this(Color.argb(255, i.CTRL_INDEX, i.CTRL_INDEX, i.CTRL_INDEX));
        }

        private a(int i) {
            this.sl = i;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            Drawable drawable;
            int action = motionEvent.getAction();
            if (view instanceof ImageView) {
                drawable = ((ImageView) view).getDrawable();
            } else {
                drawable = view.getBackground();
            }
            if (drawable != null) {
                if (action == 0) {
                    drawable.setColorFilter(this.sl, Mode.MULTIPLY);
                } else if (action == 3 || action == 1) {
                    drawable.clearColorFilter();
                }
            }
            return false;
        }
    }

    public static class b implements OnClickListener, OnTouchListener, com.tencent.mm.ui.chatting.eb.b {
        public View Ih;
        private aj irQ;
        private int jkQ;
        public o vCE;
        private View vCF;
        private View vCG;
        private int vCH;
        private int vCI;
        public int vCJ;
        public int vCK;
        private int vCL;
        private boolean vCM;
        public a vCN = new a();
        private OnTouchListener vCO = new OnTouchListener(this) {
            final /* synthetic */ b vCS;

            {
                this.vCS = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.vCS.vCN != null) {
                    this.vCS.vCN.onTouch(this.vCS.Ih, motionEvent);
                }
                return false;
            }
        };
        public View vCP;
        private int vCQ = e.CTRL_INDEX;
        private com.tencent.mm.sdk.platformtools.aj.a vCR = new com.tencent.mm.sdk.platformtools.aj.a(this) {
            final /* synthetic */ b vCS;

            {
                this.vCS = r1;
            }

            public final boolean oQ() {
                if (!(this.vCS.vCP == null || this.vCS.vCE == null)) {
                    this.vCS.vCE.showAsDropDown(this.vCS.vCP, this.vCS.vCJ, this.vCS.vCK);
                }
                return false;
            }
        };

        public final void dismiss() {
            if (this.vCE != null) {
                this.vCE.dismiss();
            }
        }

        public final boolean e(View view, MotionEvent motionEvent) {
            Object tag = view.getTag();
            if (tag == null || !(tag instanceof dt)) {
                w.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "The Tag of the View is not a instance of ItemDataTag or is null.");
                return false;
            }
            boolean z;
            dt dtVar = (dt) view.getTag();
            String str = dtVar.userName;
            String xL = m.xL();
            if (u.mA(xL) || xL.equals(str)) {
                w.v("MicroMsg.ChattingItemAvatarOnHoverHelper", "Can't talk to self and self username can't be null.");
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                return false;
            }
            Context context = view.getContext();
            if (this.vCE == null) {
                Resources resources = context.getResources();
                this.vCH = (int) ((resources.getDimension(R.f.aWA) * 2.0f) + resources.getDimension(R.f.aXA));
                this.Ih = View.inflate(context, R.i.cXy, null);
                this.vCF = this.Ih.findViewById(R.h.cLD);
                this.vCG = this.Ih.findViewById(R.h.bqy);
                this.vCG.setOnClickListener(this);
                this.vCF.setOnClickListener(this);
                this.vCG.setOnTouchListener(this.vCO);
                this.vCF.setOnTouchListener(this.vCO);
                this.vCE = new o(this.Ih, -2, this.vCH, false);
                this.vCE.setOutsideTouchable(true);
                Rect rect = new Rect();
                if (context instanceof Activity) {
                    ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                }
                this.jkQ = rect.top;
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                    this.vCI = context.getResources().getDimensionPixelSize(R.f.aWR);
                } else {
                    this.vCI = context.getResources().getDimensionPixelSize(R.f.aWS);
                }
                this.vCE.setBackgroundDrawable(new ColorDrawable(16777215));
                this.vCL = 0;
                this.irQ = new aj(Looper.getMainLooper(), this.vCR, false);
                w.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "Create a new PopupWindow.");
            }
            o oVar = this.vCE;
            switch (motionEvent.getAction()) {
                case 9:
                    this.vCP = view;
                    view.setOnTouchListener(this);
                    if (oVar.isShowing()) {
                        oVar.dismiss();
                    }
                    if (!this.vCM) {
                        this.vCG.setTag(dtVar);
                        this.vCF.setTag(dtVar);
                        this.vCG.setVisibility(0);
                        this.vCF.setVisibility(8);
                        int[] iArr = new int[2];
                        view.getLocationInWindow(iArr);
                        int i = iArr[1];
                        view.getWidth();
                        int height = view.getHeight();
                        this.vCK = this.vCL;
                        if (i > (this.jkQ + this.vCI) + this.vCH) {
                            this.vCK = ((-height) - this.vCH) - this.vCL;
                        }
                        this.vCJ = 0;
                        if (this.vCK >= 0) {
                            this.Ih.setBackgroundResource(R.g.bed);
                        } else {
                            this.Ih.setBackgroundResource(R.g.bee);
                        }
                        long j = (long) this.vCQ;
                        this.irQ.v(j, j);
                        break;
                    }
                    break;
                case 10:
                    this.vCM = false;
                    this.vCP = null;
                    break;
            }
            return true;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 1:
                    this.vCM = true;
                    break;
                case 3:
                    break;
            }
            dismiss();
            return false;
        }

        public final void onClick(View view) {
            dt dtVar = (dt) view.getTag();
            if (view == this.vCG) {
                be.l(view.getContext(), dtVar.userName, 3);
            } else {
                be.l(view.getContext(), dtVar.userName, 2);
            }
            dismiss();
        }
    }

    public static void l(Context context, String str, int i) {
        com.tencent.mm.sdk.b.b rrVar = new rr();
        rrVar.fYI.fJK = 5;
        rrVar.fYI.fJL = str;
        rrVar.fYI.context = context;
        rrVar.fYI.fYD = i;
        com.tencent.mm.sdk.b.a.urY.m(rrVar);
        g.oUh.i(11033, Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(0));
    }

    public static void do(View view) {
        com.tencent.mm.ui.chatting.eb.b bVar = vCD;
        if (view == null || bVar == null) {
            w.w("MicroMsg.OnHoverCompatibleHelper", "view or callback is null.");
        } else if (VERSION.SDK_INT >= 14) {
            eb bWo = eb.bWo();
            if (VERSION.SDK_INT >= 14 && bWo.vNX == null) {
                bWo.vNX = new com.tencent.mm.ui.chatting.eb.a(bVar);
            }
            Object obj = bWo.vNX;
            if (obj != null && VERSION.SDK_INT >= 14 && (obj instanceof OnHoverListener)) {
                view.setOnHoverListener((OnHoverListener) obj);
            }
        }
    }

    public static void dismiss() {
        try {
            if (vCD != null) {
                vCD.dismiss();
            }
        } catch (Exception e) {
            w.e("MicroMsg.ChattingItemAvatarOnHoverHelper", "exception in dismiss, %s", e.getMessage());
        }
    }
}
