package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.database.DataSetObserver;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.a;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.b;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c;
import com.tencent.mm.ui.base.l;
import com.tencent.wcdb.FileUtils;

public final class d implements OnGlobalLayoutListener {
    private ViewTreeObserver Rn;
    private View hz;
    private Context mContext;
    private l qJh;
    private e sjg;
    public b sjh;
    private GameMenuView sji;
    private f sjj;
    private boolean sjk = false;
    private boolean sjl;
    public boolean sjm;
    public boolean sjn = false;

    public final void onGlobalLayout() {
        if (isShowing()) {
            View view = this.hz;
            if (view == null || !view.isShown()) {
                bzi();
            } else if (isShowing() && this.sjk != aKK()) {
                bzi();
            }
        }
    }

    public d(Context context) {
        this.mContext = context;
        if (this.mContext instanceof Activity) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) this.mContext).getWindow().getDecorView();
            if (viewGroup.getChildCount() > 0) {
                this.hz = viewGroup.getChildAt(0);
            } else {
                this.hz = viewGroup;
            }
        }
        Context context2 = this.mContext;
        this.qJh = new l();
        this.sjg = new e(context2);
        this.sji = new GameMenuView(context2);
        this.sjj = new f(context2);
        GameMenuView gameMenuView = this.sji;
        f fVar = this.sjj;
        gameMenuView.sjs = fVar;
        fVar.registerDataSetObserver(new DataSetObserver(gameMenuView) {
            final /* synthetic */ GameMenuView sjv;

            {
                this.sjv = r1;
            }

            public final void onInvalidated() {
                GameMenuView.a(this.sjv);
            }

            public final void onChanged() {
                GameMenuView.a(this.sjv);
            }
        });
        fVar.notifyDataSetChanged();
        this.sjk = aKK();
        this.sjg.setContentView(this.sji);
    }

    public final void bzh() {
        int i = 0;
        this.sjk = aKK();
        if (this.sjh != null) {
            this.sjh.a(this.qJh);
        }
        if (this.sjg != null) {
            if (this.sjj != null) {
                f fVar = this.sjj;
                fVar.qJh = this.qJh;
                fVar.notifyDataSetChanged();
            }
            if (VERSION.SDK_INT >= 21) {
                this.sjg.getWindow().addFlags(Integer.MIN_VALUE);
            }
            if (this.sjl && VERSION.SDK_INT >= 23 && this.sjg != null) {
                this.sjg.getWindow().getDecorView().setSystemUiVisibility(9216);
                this.sjg.getWindow().setStatusBarColor(0);
            }
            if (this.sjm) {
                this.sjg.getWindow().addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            }
            if (this.sjn) {
                this.sjg.getWindow().setFlags(8, 8);
                this.sjg.getWindow().addFlags(131200);
                this.sjg.getWindow().getDecorView().setSystemUiVisibility(6);
            } else {
                this.sjg.getWindow().clearFlags(8);
                this.sjg.getWindow().clearFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                this.sjg.getWindow().clearFlags(FileUtils.S_IWUSR);
                this.sjg.getWindow().getDecorView().setSystemUiVisibility(0);
            }
            if (this.hz != null) {
                if (this.Rn == null) {
                    i = 1;
                }
                this.Rn = this.hz.getViewTreeObserver();
                if (i != 0) {
                    this.Rn.addOnGlobalLayoutListener(this);
                }
            }
            this.sjg.setOnDismissListener(new OnDismissListener(this) {
                final /* synthetic */ d sjo;

                {
                    this.sjo = r1;
                }

                public final void onDismiss(DialogInterface dialogInterface) {
                    this.sjo.bzi();
                }
            });
            if (this.sji != null) {
                this.sji.sju = new a(this) {
                    final /* synthetic */ d sjo;

                    {
                        this.sjo = r1;
                    }

                    public final void onDismiss() {
                        this.sjo.bzi();
                    }
                };
            }
            this.sjg.show();
        }
    }

    public final void bzi() {
        if (this.Rn != null) {
            if (!this.Rn.isAlive()) {
                this.Rn = this.hz.getViewTreeObserver();
            }
            this.Rn.removeGlobalOnLayoutListener(this);
            this.Rn = null;
        }
        if (this.sjg != null) {
            this.sjg.dismiss();
        }
    }

    private boolean isShowing() {
        if (this.sjg == null || !this.sjg.isShowing()) {
            return false;
        }
        return true;
    }

    public final void a(c cVar) {
        if (this.sji != null) {
            this.sji.sjt = cVar;
        }
    }

    private boolean aKK() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return true;
        }
        return false;
    }
}
