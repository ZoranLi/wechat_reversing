package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.a;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c;
import com.tencent.mm.ui.base.m;

public class GameMenuView extends LinearLayout {
    private LayoutInflater Du;
    private Context mContext;
    private boolean sjk = false;
    private View sjp;
    private LinearLayout sjq;
    private LinearLayout sjr;
    f sjs;
    c sjt;
    a sju;

    static /* synthetic */ void a(GameMenuView gameMenuView) {
        int count = gameMenuView.sjs.getCount();
        if (count != 0) {
            View childAt;
            int dP = (gameMenuView.sjk ? com.tencent.mm.bg.a.dP(gameMenuView.mContext) : com.tencent.mm.bg.a.dO(gameMenuView.mContext)) - (com.tencent.mm.bg.a.U(gameMenuView.mContext, R.f.bab) * 2);
            int U = com.tencent.mm.bg.a.U(gameMenuView.mContext, R.f.baa);
            int U2 = com.tencent.mm.bg.a.U(gameMenuView.mContext, R.f.aZZ);
            f fVar = gameMenuView.sjs;
            Object obj = (fVar.qJh == null || fVar.qJh.size() == 0) ? null : (fVar.qJh.size() + 1) / 2 > 4 ? 1 : null;
            int i = obj != null ? gameMenuView.sjk ? (int) (((((double) dP) - (0.375d * ((double) U2))) - ((double) (U2 * 4))) / 9.0d) : (int) (((((double) dP) - (0.5d * ((double) U))) - ((double) (U * 4))) / 9.0d) : gameMenuView.sjk ? (int) (((double) (dP - (U2 * 4))) / 8.0d) : (int) (((double) (dP - (U * 4))) / 8.0d);
            LayoutParams layoutParams = gameMenuView.sjk ? i > 0 ? new LinearLayout.LayoutParams(U2, (i * 2) + U2) : new LinearLayout.LayoutParams(U2, U2) : i > 0 ? new LinearLayout.LayoutParams((i * 2) + U, U) : new LinearLayout.LayoutParams(U, U);
            for (dP = 0; dP < count; dP++) {
                View view = gameMenuView.sjs.getView(dP, null, gameMenuView.sjq);
                if (view != null) {
                    view.setOnClickListener(new OnClickListener(gameMenuView) {
                        final /* synthetic */ GameMenuView sjv;

                        {
                            this.sjv = r1;
                        }

                        public final void onClick(View view) {
                            if (this.sjv.sjt != null) {
                                this.sjv.sjt.g((m) view.getTag());
                            }
                            if (this.sjv.sju != null) {
                                this.sjv.sju.onDismiss();
                            }
                        }
                    });
                    view.setLayoutParams(layoutParams);
                    if (dP % 2 == 0) {
                        gameMenuView.sjq.addView(view);
                    } else {
                        gameMenuView.sjr.addView(view);
                    }
                }
            }
            while (true) {
                i = gameMenuView.sjq.getChildCount();
                if (i <= 0) {
                    break;
                }
                childAt = gameMenuView.sjq.getChildAt(i - 1);
                if (childAt != null && childAt.getTag() != null) {
                    break;
                }
                gameMenuView.sjq.removeViewAt(i - 1);
            }
            while (true) {
                i = gameMenuView.sjr.getChildCount();
                if (i <= 0) {
                    break;
                }
                childAt = gameMenuView.sjr.getChildAt(i - 1);
                if (childAt != null && childAt.getTag() != null) {
                    break;
                }
                gameMenuView.sjr.removeViewAt(i - 1);
            }
            if (gameMenuView.sjq.getChildCount() == 0 && gameMenuView.sjr.getChildCount() == 0) {
                if (gameMenuView.sju != null) {
                    gameMenuView.sju.onDismiss();
                }
            } else if (gameMenuView.sjq.getChildCount() == 0) {
                ((ViewGroup) gameMenuView.sjq.getParent()).setVisibility(8);
            } else if (gameMenuView.sjr.getChildCount() == 0) {
                ((ViewGroup) gameMenuView.sjr.getParent()).setVisibility(8);
            }
        }
    }

    public GameMenuView(Context context) {
        boolean z = false;
        super(context, null);
        this.mContext = context;
        this.Du = LayoutInflater.from(this.mContext);
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            z = true;
        }
        this.sjk = z;
        KC();
    }

    public GameMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mContext = context;
        KC();
    }

    private void KC() {
        View inflate;
        if (this.sjk) {
            setOrientation(0);
            this.Du.inflate(R.i.deX, this, true);
            inflate = this.Du.inflate(R.i.deU, this, true);
        } else {
            setOrientation(1);
            this.Du.inflate(R.i.deY, this, true);
            inflate = this.Du.inflate(R.i.deV, this, true);
        }
        this.sjp = inflate.findViewById(R.h.bUy);
        this.sjq = (LinearLayout) inflate.findViewById(R.h.bUx);
        this.sjr = (LinearLayout) inflate.findViewById(R.h.bUz);
    }
}
