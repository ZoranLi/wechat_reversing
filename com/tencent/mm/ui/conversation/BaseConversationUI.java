package com.tencent.mm.ui.conversation;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.support.v7.app.ActionBar;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.tencent.mm.R;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.HomeUI.FitSystemWindowLayoutView;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.j;

public class BaseConversationUI extends MMFragmentActivity {
    private ActionBar Gx;
    com.tencent.mm.ui.b kWn;
    String title;
    private int uQC = -1;
    private View uQK;
    private View uQL;
    private com.tencent.mm.ui.chatting.En_5b8fbb1e.a uQM;
    private TestTimeForChatting uQN;
    private OnLayoutChangedLinearLayout uQO;
    private com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a uQP = new com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a(this) {
        final /* synthetic */ BaseConversationUI wbr;

        {
            this.wbr = r1;
        }

        public final void bPH() {
            if (this.wbr.uQW == null) {
                this.wbr.uQW = AnimationUtils.loadAnimation(this.wbr, com.tencent.mm.ui.MMFragmentActivity.a.uUP);
                this.wbr.uQW.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ AnonymousClass8 wbs;

                    {
                        this.wbs = r1;
                    }

                    public final void onAnimationStart(Animation animation) {
                        w.i("MicroMsg.BaseConversationUI", "klem onAnimationStart");
                        this.wbs.wbr.uQN.hap = 0;
                        BaseConversationUI.a(this.wbs.wbr, false);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        w.i("MicroMsg.BaseConversationUI", "klem animationEnd");
                        af.v(new Runnable(this.wbs.wbr) {
                            final /* synthetic */ BaseConversationUI wbr;

                            {
                                this.wbr = r1;
                            }

                            public final void run() {
                                ap.vL().bJk();
                                af.yv(0);
                                if (!(this.wbr.uQN == null || this.wbr.uQM == null)) {
                                    this.wbr.uQN.bZV();
                                    this.wbr.uQM.nhl = true;
                                    this.wbr.uQM.bVe();
                                    this.wbr.uQM.ll(false);
                                }
                                this.wbr.bPE();
                            }

                            public final String toString() {
                                return super.toString() + "|chattingView_onAnimationEnd";
                            }
                        });
                        this.wbs.wbr.O(1.0f);
                    }
                });
            }
            if (this.wbr.uQV) {
                this.wbr.uQM.mView.startAnimation(this.wbr.uQW);
                this.wbr.uQV = false;
            } else {
                this.wbr.uQN.hap = 0;
                af.v(/* anonymous class already generated */);
            }
            this.wbr.uQO.vpz = null;
            w.i("MicroMsg.BaseConversationUI", "klem CHATTING ONLAYOUT ");
        }
    };
    String uQQ;
    Bundle uQR;
    Runnable uQS = new Runnable(this) {
        final /* synthetic */ BaseConversationUI wbr;

        {
            this.wbr = r1;
        }

        public final void run() {
            this.wbr.uQX = false;
            if (!this.wbr.isFinishing()) {
                String str = "MicroMsg.BaseConversationUI";
                String str2 = "ashutest::startChatting, ishow:%b";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(this.wbr.uQN == null ? false : this.wbr.uQN.isShown());
                w.i(str, str2, objArr);
                Intent putExtra = new Intent().putExtra("Chat_User", this.wbr.uQQ);
                if (this.wbr.uQR != null) {
                    putExtra.putExtras(this.wbr.uQR);
                }
                putExtra.putExtra("img_gallery_enter_from_chatting_ui", true);
                BaseConversationUI.a(this.wbr, putExtra);
                this.wbr.uQO.vpz = this.wbr.uQP;
                this.wbr.uQN.setVisibility(0);
                BaseConversationUI baseConversationUI = this.wbr;
                if (!(baseConversationUI.wbn == null || baseConversationUI.wbn.bQi())) {
                    baseConversationUI.wbn.ks(false);
                }
                if (this.wbr.uQM.bQi()) {
                    j.a(this.wbr);
                }
                e.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass10 wbu;

                    {
                        this.wbu = r1;
                    }

                    public final void run() {
                        d.a(4, this.wbu.wbr.getLocalClassName(), this.wbu.wbr.hashCode());
                        d.a(3, "En_5b8fbb1e" + this.wbu.wbr.uQM.bVk(), this.wbu.wbr.uQM.hashCode());
                    }
                }, "directReport_startChattingRunnable");
                this.wbr.uQn = bg.Ny();
            }
        }

        public final String toString() {
            return super.toString() + "|startChattingRunnable";
        }
    };
    private Animation uQU;
    private boolean uQV = false;
    private Animation uQW;
    public boolean uQX = true;
    private long uQn = 0;
    private String uQz;
    private boolean vKY = false;
    private long vLa = 0;
    public b wbn;
    private a wbo = a.ACTIVITY_CREATE;
    private c wbp = new c(this);

    private enum a {
        ACTIVITY_CREATE,
        ACTIVITY_RESUME,
        ACTIVITY_PAUSE
    }

    private class c implements Runnable {
        int aMA;
        int fFR;
        Intent fFS;
        int uRz = 0;
        final /* synthetic */ BaseConversationUI wbr;

        public c(BaseConversationUI baseConversationUI) {
            this.wbr = baseConversationUI;
        }

        public final void run() {
            if (ap.zb()) {
                w.i("MicroMsg.BaseConversationUI", "on post select image job, acc has ready, retry count %d", Integer.valueOf(this.uRz));
                this.wbr.a(this.wbr.uQz, null, false);
                af.v(new Runnable(this) {
                    final /* synthetic */ c wbB;

                    {
                        this.wbB = r1;
                    }

                    public final void run() {
                        boolean z = true;
                        String str = "MicroMsg.BaseConversationUI";
                        String str2 = "on select image ActivityResult. after creat chattingUI, chatting fragment is null? %B";
                        Object[] objArr = new Object[1];
                        if (this.wbB.wbr.uQM != null) {
                            z = false;
                        }
                        objArr[0] = Boolean.valueOf(z);
                        w.d(str, str2, objArr);
                        if (this.wbB.wbr.uQM != null) {
                            w.d("MicroMsg.BaseConversationUI", "on select image ActivityResult. do post activity result");
                            this.wbB.wbr.uQM.onActivityResult(this.wbB.fFR & 65535, this.wbB.aMA, this.wbB.fFS);
                        }
                    }

                    public final String toString() {
                        return super.toString() + "|PostSelectImageJob_onActivityResult";
                    }
                });
            } else if (this.uRz >= 3) {
                w.w("MicroMsg.BaseConversationUI", "on post select image job, match max retry count");
            } else {
                w.w("MicroMsg.BaseConversationUI", "on post select image job, acc not ready, cur retry count %d", Integer.valueOf(this.uRz));
                this.uRz++;
                af.f(this, 300);
            }
        }

        public final String toString() {
            return super.toString() + "|PostSelectImageJob";
        }
    }

    public static class b extends q {
        private a wbA = a.ACTIVITY_CREATE;
        public BaseConversationUI wbz;

        public int getLayoutId() {
            return 0;
        }

        public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.wbA = a.ACTIVITY_CREATE;
            this.wbz = (BaseConversationUI) bPj();
            View inflate = layoutInflater.inflate(getLayoutId(), viewGroup, false);
            aH();
            return inflate;
        }

        public final void qP(String str) {
            if (this.wbz != null) {
                BaseConversationUI baseConversationUI = this.wbz;
                baseConversationUI.title = str;
                if (baseConversationUI.kWn != null) {
                    baseConversationUI.ajj();
                }
            }
        }

        public final void finish() {
            bPj().finish();
        }

        public void onResume() {
            super.onResume();
            this.wbA = a.ACTIVITY_RESUME;
        }

        public void onPause() {
            super.onPause();
            this.wbA = a.ACTIVITY_PAUSE;
        }

        public void onDestroy() {
            if (this.wbA != a.ACTIVITY_PAUSE) {
                w.w("MicroMsg.BaseConversationUI", "fmStatus != ActivityStatus.ACTIVITY_PAUSE when fm onDestroy");
                onPause();
            }
            super.onDestroy();
        }

        public String getUserName() {
            return null;
        }
    }

    static /* synthetic */ void a(BaseConversationUI baseConversationUI, Intent intent) {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        if (baseConversationUI.uQM == null) {
            baseConversationUI.uQM = baseConversationUI.bYq();
            baseConversationUI.uQM.e(baseConversationUI.uQK, baseConversationUI.uQL);
            baseConversationUI.uQK = null;
            baseConversationUI.uQL = null;
            z = true;
        } else {
            z = false;
        }
        final int[] iArr;
        View bYt;
        if (baseConversationUI.uQN == null) {
            if (baseConversationUI.uQM.bQi()) {
                iArr = new int[2];
                baseConversationUI.cO().cP().getCustomView().getLocationInWindow(iArr);
                View testTimeForChatting = new TestTimeForChatting(baseConversationUI);
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                testTimeForChatting.setId(R.h.bAp);
                baseConversationUI.uQC = testTimeForChatting.getId();
                testTimeForChatting.setOrientation(1);
                testTimeForChatting.setLayoutParams(layoutParams);
                final View fitSystemWindowLayoutView = new FitSystemWindowLayoutView(baseConversationUI);
                fitSystemWindowLayoutView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                bYt = baseConversationUI.bYt();
                if (bYt == null) {
                    bYt = ((ViewGroup) baseConversationUI.getWindow().getDecorView()).getChildAt(0);
                }
                final ViewGroup viewGroup = bYt instanceof SwipeBackLayout ? (ViewGroup) ((ViewGroup) bYt).getChildAt(0) : (ViewGroup) bYt;
                ((ViewGroup) baseConversationUI.getWindow().getDecorView()).removeView(bYt);
                bYt.setId(R.h.caQ);
                fitSystemWindowLayoutView.addView(bYt);
                fitSystemWindowLayoutView.addView(testTimeForChatting);
                ((ViewGroup) baseConversationUI.getWindow().getDecorView()).addView(fitSystemWindowLayoutView);
                baseConversationUI.getWindow().getDecorView().requestFitSystemWindows();
                int i = iArr[1];
                if (i > 0) {
                    baseConversationUI.a(fitSystemWindowLayoutView, i, new Rect(0, i, 0, 0), viewGroup);
                } else {
                    baseConversationUI.cO().cP().getCustomView().post(new Runnable(baseConversationUI) {
                        final /* synthetic */ BaseConversationUI wbr;

                        public final void run() {
                            this.wbr.cO().cP().getCustomView().getLocationInWindow(iArr);
                            int i = iArr[1];
                            if (i > 0) {
                                this.wbr.a(fitSystemWindowLayoutView, i, new Rect(0, i, 0, 0), viewGroup);
                            } else if (com.tencent.mm.compatible.util.d.eo(20)) {
                                fitSystemWindowLayoutView.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener(this) {
                                    final /* synthetic */ AnonymousClass9 wbt;

                                    {
                                        this.wbt = r1;
                                    }

                                    @TargetApi(20)
                                    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                                        if (windowInsets != null) {
                                            w.i("MicroMsg.BaseConversationUI", "OnApplyWindowInsetsListener %s", windowInsets);
                                            windowInsets.consumeSystemWindowInsets();
                                            this.wbt.wbr.a(fitSystemWindowLayoutView, windowInsets.getSystemWindowInsetTop(), new Rect(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom()), viewGroup);
                                        }
                                        return windowInsets;
                                    }
                                });
                            }
                        }
                    });
                }
                baseConversationUI.uQN = (TestTimeForChatting) baseConversationUI.findViewById(baseConversationUI.uQC);
                w.i("MicroMsg.BaseConversationUI", "ashu::prepareChattingFragment init chattingView, top %s", Integer.valueOf(iArr[1]));
            } else {
                baseConversationUI.uQN = (TestTimeForChatting) baseConversationUI.findViewById(R.h.bzR);
                baseConversationUI.uQC = baseConversationUI.uQN.getId();
            }
        } else if (baseConversationUI.uQM.bQi()) {
            iArr = new int[2];
            baseConversationUI.uQN.getLocationInWindow(iArr);
            if (iArr[1] == 0) {
                ViewGroup viewGroup2 = (ViewGroup) baseConversationUI.getWindow().getDecorView();
                for (int i2 = 0; i2 < viewGroup2.getChildCount(); i2++) {
                    bYt = ((ViewGroup) baseConversationUI.getWindow().getDecorView()).getChildAt(i2);
                    if (bYt instanceof FitSystemWindowLayoutView) {
                        baseConversationUI.cO().cP().getCustomView().getLocationInWindow(iArr);
                        FitSystemWindowLayoutView fitSystemWindowLayoutView2 = (FitSystemWindowLayoutView) bYt;
                        fitSystemWindowLayoutView2.fitSystemWindows(new Rect(0, fitSystemWindowLayoutView2.uRx, 0, 0));
                        w.i("MicroMsg.BaseConversationUI", "rootLayout2 fitSystemWindows, top %s", Integer.valueOf(iArr[1]));
                        break;
                    }
                    w.e("MicroMsg.BaseConversationUI", "on position %d, rootLayout not found!", Integer.valueOf(i2));
                }
            }
            w.i("MicroMsg.BaseConversationUI", "ashu::prepareChattingFragment has chattingView, top %s", Integer.valueOf(iArr[1]));
        }
        if (z) {
            baseConversationUI.uQM.hML = true;
            baseConversationUI.uQM.nhl = false;
            baseConversationUI.uQM.setArguments(s.ad(intent));
            baseConversationUI.aR().aV().a(baseConversationUI.uQC, baseConversationUI.uQM).commitAllowingStateLoss();
            baseConversationUI.aR().executePendingTransactions();
            baseConversationUI.uQO = (OnLayoutChangedLinearLayout) baseConversationUI.uQM.mView.findViewById(R.h.bAb);
            baseConversationUI.uQM.ll(true);
        } else {
            baseConversationUI.uQM.hML = true;
            baseConversationUI.uQM.nhl = false;
            baseConversationUI.uQM.oW.putAll(s.ad(intent));
            baseConversationUI.uQM.bTD();
            baseConversationUI.uQM.onResume();
            baseConversationUI.uQM.ll(true);
        }
        if (baseConversationUI.uQM.bQi()) {
            baseConversationUI.uQM.uUD.wxG = false;
        }
        w.i("MicroMsg.BaseConversationUI", "ashu::prepareChattingFragment use %dms, needInit %B, Intent %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z), intent);
    }

    static /* synthetic */ void a(BaseConversationUI baseConversationUI, boolean z) {
        if (a.ACTIVITY_RESUME == baseConversationUI.wbo) {
            baseConversationUI.d(z, 0);
        }
    }

    public void onCreate(Bundle bundle) {
        getWindow().setFormat(-2);
        com.tencent.mm.pluginsdk.e.R(this);
        super.onCreate(bundle);
        getWindow().setCallback(new com.tencent.mm.ui.b.c(getWindow().getCallback(), this));
        this.Gx = cO().cP();
        bQn();
    }

    protected void onNewIntent(Intent intent) {
        w.i("MicroMsg.BaseConversationUI", "onNewIntent");
        setIntent(intent);
    }

    protected void onResume() {
        super.onResume();
        j.b(this);
        O(1.0f);
        this.wbo = a.ACTIVITY_RESUME;
        final boolean z = this.uQN != null && this.uQN.isShown();
        e.post(new Runnable(this) {
            final /* synthetic */ BaseConversationUI wbr;

            public final void run() {
                d.a(3, z ? "En_5b8fbb1e" + this.wbr.uQM.bVk() : this.wbr.getLocalClassName(), z ? this.wbr.uQM.hashCode() : this.wbr.hashCode());
            }
        }, "directReport_onResume");
        if (!z) {
            this.uQn = bg.Ny();
        }
        if (com.tencent.mm.compatible.util.d.eo(19) && com.tencent.mm.compatible.h.a.rX()) {
            Looper.myQueue().addIdleHandler(new IdleHandler(this) {
                final /* synthetic */ BaseConversationUI wbr;

                {
                    this.wbr = r1;
                }

                public final boolean queueIdle() {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (this.wbr.uQN == null) {
                        if (this.wbr.uQK == null) {
                            this.wbr.uQK = r.eC(this.wbr).inflate(R.i.cXo, null);
                        }
                        if (this.wbr.uQL == null) {
                            this.wbr.uQL = r.eC(this.wbr).inflate(R.i.cTB, null);
                        }
                    }
                    w.d("MicroMsg.BaseConversationUI", "prepare chattingUI view use %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    return false;
                }
            });
            if (this.uQM != null && this.uQM.bQi()) {
                this.uQM.uUD.mEnable = true;
            }
            Looper.myQueue().addIdleHandler(new IdleHandler(this) {
                final /* synthetic */ BaseConversationUI wbr;

                {
                    this.wbr = r1;
                }

                public final boolean queueIdle() {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (this.wbr.uQN == null) {
                        String xL;
                        if (this.wbr.wbn == null || bg.mA(this.wbr.wbn.getUserName())) {
                            xL = m.xL();
                        } else {
                            xL = this.wbr.wbn.getUserName();
                        }
                        BaseConversationUI.a(this.wbr, new Intent().putExtra("Chat_User", xL));
                        this.wbr.uQM.nhl = true;
                        this.wbr.uQM.bVe();
                        this.wbr.uQN.setVisibility(8);
                        this.wbr.uQM.uUC = true;
                        this.wbr.uQM.onPause();
                        this.wbr.uQM.bVb();
                        this.wbr.uQM.hML = false;
                        this.wbr.bYu();
                    }
                    this.wbr.uQK = null;
                    this.wbr.uQL = null;
                    w.d("MicroMsg.BaseConversationUI", "prepare chattingUI logic use %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    return false;
                }
            });
        }
        bPA();
        this.Gx.show();
    }

    protected void onPause() {
        w.i("MicroMsg.BaseConversationUI", "on pause");
        super.onPause();
        if (!isFinishing()) {
            j.a(this);
        }
        this.wbo = a.ACTIVITY_PAUSE;
        final boolean z = this.uQN != null && this.uQN.isShown();
        e.post(new Runnable(this) {
            final /* synthetic */ BaseConversationUI wbr;

            public final void run() {
                d.a(4, z ? "En_5b8fbb1e" + this.wbr.uQM.bVk() : this.wbr.getLocalClassName(), z ? this.wbr.uQM.hashCode() : this.wbr.hashCode());
                if (z) {
                    d.d("En_5b8fbb1e" + this.wbr.uQM.bVk(), this.wbr.uQn, u.Ny());
                }
            }
        }, "directReport_onPause");
        if (this.uQM != null && this.uQM.bQi()) {
            this.uQM.uUD.mEnable = false;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.uQM = null;
        this.uQO = null;
        this.uQN = null;
        this.wbn = null;
        this.kWn = null;
        this.uQW = null;
        this.uQU = null;
    }

    public final void O(float f) {
        w.v("MicroMsg.BaseConversationUI", "ashutest::on swipe %f, duration %d, status %s", Float.valueOf(f), Long.valueOf(240), this.wbo);
        if (com.tencent.mm.compatible.util.d.eo(19) && com.tencent.mm.compatible.h.a.rX()) {
            if (a.ACTIVITY_RESUME != this.wbo) {
                super.O(f);
                if (Float.compare(1.0f, f) > 0) {
                    return;
                }
            }
            View findViewById = findViewById(R.h.caQ);
            if (Float.compare(1.0f, f) <= 0) {
                com.tencent.mm.ui.tools.j.n(findViewById, 0.0f);
            } else {
                com.tencent.mm.ui.tools.j.n(findViewById, (((float) (findViewById.getWidth() / 4)) * (1.0f - f)) * -1.0f);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 1;
        super.onActivityResult(i, i2, intent);
        if (this.wbn != null) {
            this.wbn.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            if (i == MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN && this.uQM != null) {
                this.uQM.onActivityResult(i, i2, intent);
            }
            w.w("MicroMsg.BaseConversationUI", "check request code %d", Integer.valueOf(65535 & i));
            switch (65535 & i) {
                case com.tencent.mm.plugin.appbrand.jsapi.e.b.CTRL_INDEX /*217*/:
                case 218:
                    break;
                default:
                    i3 = 0;
                    break;
            }
            if (i3 != 0 && this.uQM == null) {
                w.i("MicroMsg.BaseConversationUI", "on select image ActivityResult. the chattingUI maybe kill in the background.");
                af.I(this.wbp);
                this.wbp.uRz = 0;
                this.wbp.fFR = i;
                this.wbp.aMA = i2;
                this.wbp.fFS = intent;
                af.v(this.wbp);
            }
        }
    }

    private void bPE() {
        boolean z = true;
        if (com.tencent.mm.compatible.util.d.eo(19) && com.tencent.mm.compatible.h.a.rX()) {
            String str = "MicroMsg.BaseConversationUI";
            String str2 = "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B";
            Object[] objArr = new Object[1];
            if (this.uQM != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            w.i(str, str2, objArr);
            if (this.uQM != null) {
                this.uQM.uUD.wuc = false;
            }
        }
    }

    public final void a(String str, Bundle bundle, boolean z) {
        String str2 = "MicroMsg.BaseConversationUI";
        String str3 = "try startChatting, ishow:%b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.uQN == null ? false : this.uQN.isShown());
        w.i(str2, str3, objArr);
        this.uQR = bundle;
        this.uQQ = str;
        this.uQV = z;
        ap.vL().bJh();
        af.yv(-8);
        af.v(this.uQS);
    }

    private void a(FitSystemWindowLayoutView fitSystemWindowLayoutView, int i, Rect rect, ViewGroup viewGroup) {
        int i2;
        int bottom = getWindow().getDecorView().getBottom();
        int bottom2 = cO().cP().getCustomView().getBottom();
        if (this.wbn == null || this.wbn.mView == null) {
            i2 = 0;
        } else {
            i2 = bottom - ((i + bottom2) + this.wbn.mView.getBottom());
        }
        w.i("MicroMsg.BaseConversationUI", "ashu::fitSystemWindows 2. decorBottom:%d, statusBarHeight:%d, actionBarHeight:%d, paddingForNavBar:%d", Integer.valueOf(bottom), Integer.valueOf(i), Integer.valueOf(bottom2), Integer.valueOf(i2));
        fitSystemWindowLayoutView.uRy = viewGroup;
        fitSystemWindowLayoutView.fitSystemWindows(rect);
    }

    private ViewGroup bYt() {
        ViewParent parent = this.Gx.getCustomView().getParent();
        ViewParent viewParent = null;
        ViewParent viewParent2 = (ViewGroup) getWindow().getDecorView();
        while (parent != viewParent2 && parent != null) {
            ViewParent viewParent3 = parent;
            parent = parent.getParent();
            viewParent = viewParent3;
        }
        return (ViewGroup) viewParent;
    }

    public final void bYu() {
        if (this.wbn != null) {
            this.wbn.onResume();
            if (!this.wbn.bQi()) {
                this.wbn.ks(true);
            }
        }
    }

    public final void kl(boolean z) {
        String str = "MicroMsg.BaseConversationUI";
        String str2 = "try closeChatting, ishow:%b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.uQN == null ? false : this.uQN.isShown());
        w.i(str, str2, objArr);
        if (this.uQM != null && this.uQM.bQi()) {
            j.b(this);
        }
        if (this.uQN != null && this.uQN.getVisibility() != 8 && this.uQM != null) {
            w.i("MicroMsg.BaseConversationUI", "closeChatting");
            this.uQN.setVisibility(8);
            this.uQX = true;
            if (this.uQU == null) {
                this.uQU = AnimationUtils.loadAnimation(this, com.tencent.mm.ui.MMFragmentActivity.a.uUS);
                this.uQU.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ BaseConversationUI wbr;

                    {
                        this.wbr = r1;
                    }

                    public final void onAnimationStart(Animation animation) {
                        ap.vL().bJh();
                        af.yv(-8);
                        w.i("MicroMsg.BaseConversationUI", "klem pop out onAnimationStart");
                        BaseConversationUI.a(this.wbr, true);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        ap.vL().bJk();
                        af.yv(0);
                        this.wbr.bPE();
                        w.i("MicroMsg.BaseConversationUI", "klem pop out onAnimationEnd");
                    }
                });
            }
            this.uQM.onPause();
            this.uQM.bVb();
            this.uQM.hML = false;
            if (z) {
                this.uQN.startAnimation(this.uQU);
            } else {
                O(1.0f);
                bPE();
            }
            if (!this.uQM.bQi()) {
                bPA();
            }
            aQ();
            bYu();
            e.post(new Runnable(this) {
                final /* synthetic */ BaseConversationUI wbr;

                {
                    this.wbr = r1;
                }

                public final void run() {
                    d.a(4, "En_5b8fbb1e" + this.wbr.uQM.bVk(), this.wbr.uQM.hashCode());
                    d.d("En_5b8fbb1e" + this.wbr.uQM.bVk(), this.wbr.uQn, u.Ny());
                    d.a(3, this.wbr.getLocalClassName(), this.wbr.hashCode());
                }
            }, "directReport_closeChatting");
        }
    }

    private void bPA() {
        if (this.uQM == null || !this.uQM.hML) {
            View inflate = r.eC(this).inflate(R.i.cTB, null);
            this.kWn = new com.tencent.mm.ui.b(inflate);
            this.Gx.setLogo(new ColorDrawable(getResources().getColor(17170445)));
            this.Gx.cK();
            this.Gx.setDisplayHomeAsUpEnabled(false);
            this.Gx.cJ();
            this.Gx.cL();
            this.Gx.setCustomView(inflate);
            ajj();
            this.kWn.h(new OnClickListener(this) {
                final /* synthetic */ BaseConversationUI wbr;

                {
                    this.wbr = r1;
                }

                public final void onClick(View view) {
                    this.wbr.finish();
                }
            });
        }
    }

    public final void ajj() {
        if (this.kWn != null) {
            this.kWn.setTitle(n.eK(this.title));
        }
    }

    public ActionMode onWindowStartingActionMode(Callback callback) {
        if (this.uQM == null || this.uQM.vKo == null || !this.uQM.bQi()) {
            return super.onWindowStartingActionMode(callback);
        }
        if (com.tencent.mm.compatible.util.d.eq(22)) {
            return super.onWindowStartingActionMode(callback);
        }
        ActionMode startActionMode = this.uQM.vKo.startActionMode(callback);
        if (startActionMode == null) {
            return super.onWindowStartingActionMode(callback);
        }
        return startActionMode;
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.uQz = bundle.getString("last_restore_talker");
        w.d("MicroMsg.BaseConversationUI", "onRestoreInstantceState:%s", this.uQz);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        if (this.uQM != null && !bg.mA(this.uQM.bUg())) {
            w.d("MicroMsg.BaseConversationUI", "onSaveInstanceState:%s", this.uQM.bUg());
            bundle.putString("last_restore_talker", this.uQM.bUg());
        }
    }

    public final void d(boolean z, int i) {
        long j = 120;
        w.v("MicroMsg.BaseConversationUI", "ashutest: on settle %B, speed %d, status %s", Boolean.valueOf(z), Integer.valueOf(i), this.wbo);
        if (!com.tencent.mm.compatible.util.d.eo(19) || !com.tencent.mm.compatible.h.a.rX()) {
            return;
        }
        if (a.ACTIVITY_RESUME != this.wbo) {
            super.d(z, i);
            return;
        }
        View findViewById = findViewById(R.h.caQ);
        if (z) {
            if (i <= 0) {
                j = 240;
            }
            com.tencent.mm.ui.tools.j.a(findViewById, j, 0.0f, 0.125f);
            return;
        }
        if (i <= 0) {
            j = 240;
        }
        com.tencent.mm.ui.tools.j.a(findViewById, j, (float) ((findViewById.getWidth() * -1) / 4), 0.75f);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Object[] objArr;
        int i = 1;
        w.i("MicroMsg.BaseConversationUI", "ui group onKeyDown, code:%d action:%d", Integer.valueOf(keyEvent.getKeyCode()), Integer.valueOf(keyEvent.getAction()));
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            af.I(this.uQS);
        }
        if (this.uQM == null || !this.uQM.hML || this.uQM.vKZ) {
            if (keyEvent.getKeyCode() == 4) {
                if (keyEvent.getAction() == 0) {
                    this.vKY = i;
                    this.vLa = System.currentTimeMillis();
                }
                if (keyEvent.getAction() != i) {
                    return i;
                }
                w.d("MicroMsg.BaseConversationUI", "hasBack %B, %d", Boolean.valueOf(this.vKY), Long.valueOf(System.currentTimeMillis() - this.vLa));
                if (!this.vKY || System.currentTimeMillis() - this.vLa > 30000) {
                    return i;
                }
                finish();
                return i;
            }
            try {
                return super.dispatchKeyEvent(keyEvent);
            } catch (Throwable e) {
                objArr = new Object[i];
                objArr[0] = e.getMessage();
                w.w("MicroMsg.BaseConversationUI", "dispatch key event catch exception %s", objArr);
                w.printErrStackTrace("MicroMsg.BaseConversationUI", e, "", new Object[0]);
                return 0;
            }
        } else if (this.uQM.onKeyDown(keyEvent.getKeyCode(), keyEvent)) {
            return i;
        } else {
            try {
                return super.dispatchKeyEvent(keyEvent);
            } catch (Throwable e2) {
                objArr = new Object[i];
                objArr[0] = e2.getMessage();
                w.w("MicroMsg.BaseConversationUI", "dispatch key event catch exception %s", objArr);
                w.printErrStackTrace("MicroMsg.BaseConversationUI", e2, "", new Object[0]);
                return 0;
            }
        }
    }

    protected com.tencent.mm.ui.chatting.En_5b8fbb1e.a bYq() {
        return com.tencent.mm.ui.chatting.En_5b8fbb1e.a.bUQ();
    }
}
