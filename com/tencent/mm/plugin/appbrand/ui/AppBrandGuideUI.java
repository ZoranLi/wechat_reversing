package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.plugin.appbrand.ui.banner.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.x;

@com.tencent.mm.ui.base.a(7)
public final class AppBrandGuideUI extends MMActivity implements c {

    public static final class a implements ActivityLifecycleCallbacks, c {
        public boolean jin = false;

        public static Application WL() {
            return (Application) ab.getContext().getApplicationContext();
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof AppBrandGuideUI) {
                this.jin = false;
            }
        }

        public final void onActivityStarted(Activity activity) {
        }

        public final void onActivityResumed(Activity activity) {
            if ((activity instanceof AppBrandGuideUI) || (activity instanceof AppBrandLauncherUI)) {
                this.jin = false;
            }
            if (h.vG().uV() && this.jin) {
                RunningTaskInfo aa = bg.aa(activity, activity.getTaskId());
                boolean z = (aa == null || aa.baseActivity == null) ? false : aa.baseActivity.getClassName().endsWith(".LauncherUI") || !aa.baseActivity.getClassName().contains(".AppBrandUI");
                if (z) {
                    this.jin = false;
                    activity.startActivity(new Intent(activity, AppBrandGuideUI.class).putExtra("extra_enter_scene", 11));
                }
            }
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }

        public final void S(String str, int i) {
            this.jin = false;
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    public final void onCreate(Bundle bundle) {
        setTheme(R.m.foz);
        super.onCreate(bundle);
        x.a(getWindow());
        b.b((c) this);
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(this);
        aVar.zW(R.l.dDY);
        View imageView = new ImageView(this);
        imageView.setImageResource(R.g.bcb);
        View textView = new TextView(this);
        textView.setText(R.l.dEy);
        textView.setTextSize(2, 14.0f);
        textView.setTextColor(Color.argb(Math.round(137.70001f), 0, 0, 0));
        textView.setLineSpacing(0.0f, 1.2f);
        View linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.addView(imageView, new LayoutParams(-1, -2));
        linearLayout.addView(textView, new LayoutParams(-1, -2));
        ((MarginLayoutParams) textView.getLayoutParams()).topMargin = com.tencent.mm.bg.a.fromDPToPix(this, 16);
        aVar.dd(linearLayout);
        aVar.a(new OnDismissListener(this) {
            final /* synthetic */ AppBrandGuideUI jim;

            {
                this.jim = r1;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                this.jim.finish();
            }
        });
        aVar.Aa(R.l.bCA);
        aVar.b(new OnClickListener(this) {
            final /* synthetic */ AppBrandGuideUI jim;

            {
                this.jim = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.jim.finish();
            }
        });
        aVar.zZ(R.l.dEx);
        aVar.a(false, new OnClickListener(this) {
            final /* synthetic */ AppBrandGuideUI jim;

            {
                this.jim = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.jim.startActivity(new Intent(this.jim, AppBrandLauncherUI.class));
                this.jim.finish();
            }
        });
        aVar.kK(false);
        aVar.kL(true);
        aVar.WJ().show();
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    protected final void onDestroy() {
        super.onDestroy();
        b.a(this);
    }

    public final void S(String str, int i) {
        finish();
    }
}
