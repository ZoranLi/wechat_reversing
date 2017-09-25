package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.s.a.d;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.s.a.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class s extends Toast {
    private final Context context;
    public long duration;
    public final aj fyI = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ s vnh;

        {
            this.vnh = r1;
        }

        public final boolean oQ() {
            if (this.vnh.duration == -1) {
                this.vnh.show();
                return true;
            }
            this.vnh.kor = this.vnh.kor - 1;
            if (this.vnh.kor >= 0) {
                this.vnh.show();
                return true;
            }
            this.vnh.cancel();
            return false;
        }
    }, true);
    private View iUW;
    public int kor;
    private int level;
    private final TextView mTC;

    private static class a {
        private static Toast sRm = null;
        public static int vnk = 0;

        public static void ac(Context context, int i) {
            Context applicationContext = context.getApplicationContext();
            if (vnk != i) {
                sRm = null;
                vnk = i;
            }
            if (sRm == null) {
                sRm = Toast.makeText(applicationContext, "", 1);
            }
            View inflate = View.inflate(applicationContext, h.heJ, null);
            if (i == 1) {
                ((TextView) inflate.findViewById(g.hcZ)).setText(k.hfj);
            } else if (i == 3) {
                ((TextView) inflate.findViewById(g.hcZ)).setText(k.hfk);
            } else {
                ((TextView) inflate.findViewById(g.hcZ)).setText(k.hfl);
            }
            sRm.setView(inflate);
            sRm.show();
        }
    }

    public s(Context context) {
        super(context);
        this.context = context;
        reset();
        this.iUW = View.inflate(context, h.heP, null);
        setView(this.iUW);
        setGravity(55, 0, b.a(context, 40.0f));
        setDuration(0);
        this.mTC = (TextView) this.iUW.findViewById(g.hdF);
        switch (this.level) {
            case 1:
                this.mTC.setTextColor(-1);
                return;
            case 2:
                this.mTC.setTextColor(this.context.getResources().getColor(d.hbE));
                return;
            default:
                return;
        }
    }

    public final void setText(CharSequence charSequence) {
        this.mTC.setText(charSequence);
    }

    public final void setText(int i) {
        this.mTC.setText(i);
    }

    public final void reset() {
        this.level = 1;
        this.duration = 2000;
        this.kor = ((int) (this.duration / 70)) + 1;
    }

    public static o a(Activity activity, String str, long j) {
        View inflate = View.inflate(activity, h.heP, null);
        ((TextView) inflate.findViewById(g.hdF)).setText(str);
        final o oVar = new o(inflate);
        oVar.setWidth(-1);
        oVar.setHeight(-2);
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        oVar.showAtLocation(activity.getWindow().getDecorView(), 48, 0, rect.top + bG(activity));
        new ae() {
            public final void handleMessage(Message message) {
                oVar.dismiss();
                super.handleMessage(message);
            }
        }.sendEmptyMessageDelayed(0, j);
        return oVar;
    }

    private static int bG(Context context) {
        if ((context instanceof ActionBarActivity) && ((ActionBarActivity) context).cO().cP() != null) {
            return ((ActionBarActivity) context).cO().cP().getHeight();
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return context.getResources().getDimensionPixelSize(e.aWR);
        }
        return context.getResources().getDimensionPixelSize(e.aWS);
    }

    public static o a(final Activity activity, int i, String str) {
        View inflate = View.inflate(activity, h.hdX, null);
        TextView textView = (TextView) inflate.findViewById(g.cbw);
        textView.setText(str);
        textView.setOnClickListener(null);
        ImageView imageView = (ImageView) inflate.findViewById(g.cbv);
        if (i == 0) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageResource(i);
        }
        final o oVar = new o(inflate);
        oVar.setWidth(-1);
        oVar.setHeight(-2);
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i2 = rect.top;
        int bG = bG(activity);
        if (i2 == 0) {
            i2 = ab(activity, 25);
        }
        i2 += bG;
        af.v(new Runnable() {
            public final void run() {
                oVar.showAtLocation(activity.getWindow().getDecorView(), 48, 0, i2);
            }
        });
        af.f(new Runnable() {
            public final void run() {
                oVar.dismiss();
            }
        }, 2000);
        ImageButton imageButton = (ImageButton) inflate.findViewById(g.cbu);
        imageButton.setVisibility(8);
        imageButton.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                oVar.dismiss();
            }
        });
        return oVar;
    }

    public static void eP(Context context) {
        if (com.tencent.mm.compatible.util.h.getExternalStorageState().equals("mounted_ro")) {
            a.ac(context, 3);
        } else {
            a.ac(context, 1);
        }
    }

    public static void eQ(Context context) {
        a.ac(context, 2);
    }

    public static int eR(Context context) {
        return ab(context, 25);
    }

    public static int ab(Context context, int i) {
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            i = context.getResources().getDimensionPixelSize(bg.getInt(cls.getField("status_bar_height").get(cls.newInstance()).toString(), 0));
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MMToast", e, "", new Object[0]);
        }
        return i;
    }
}
