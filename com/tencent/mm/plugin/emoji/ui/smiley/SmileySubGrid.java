package com.tencent.mm.plugin.emoji.ui.smiley;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ListAdapter;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.emoji.PopEmojiView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.base.MMFlipper;
import java.io.InputStream;

public class SmileySubGrid extends SmileyGrid {
    private int Xd;
    Rect YH = new Rect();
    int YM;
    private int Yy;
    int aec;
    private LayoutInflater dZ;
    private int iE = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    float kSk;
    float kSl;
    private WindowManager kSs;
    int kVI = 6;
    int kVJ = -1;
    boolean kVK;
    private PopEmojiView kVL;
    private LayoutParams kVM;
    private int kVN;
    private int kVO;
    private boolean kVP;
    private c kVQ;
    private int kVR;
    private a kVS;
    private b kVT;
    View kVU;
    private int kVV;
    private String kVW;
    public boolean kVX = false;
    public volatile int kVY = -1;
    public volatile boolean kVZ = false;
    public boolean kWa = true;
    private final String kWb = "lock_refresh";
    private ae mHandler = new ae();

    private class c implements Runnable {
        final /* synthetic */ SmileySubGrid kWc;

        public c(SmileySubGrid smileySubGrid) {
            this.kWc = smileySubGrid;
        }

        public final void run() {
            if (!this.kWc.kVP) {
                this.kWc.kSs.addView(this.kWc.kVL, this.kWc.kVM);
                this.kWc.kVP = true;
            }
        }
    }

    private class d {
        final /* synthetic */ SmileySubGrid kWc;
        private int kWf;

        public d(SmileySubGrid smileySubGrid) {
            this.kWc = smileySubGrid;
        }

        public final void aou() {
            this.kWf = this.kWc.getWindowAttachCount();
        }

        public final boolean aov() {
            return this.kWc.hasWindowFocus() && this.kWc.getWindowAttachCount() == this.kWf;
        }
    }

    private class a extends d implements Runnable {
        final /* synthetic */ SmileySubGrid kWc;

        public a(SmileySubGrid smileySubGrid) {
            this.kWc = smileySubGrid;
            super(smileySubGrid);
        }

        public final void run() {
            int i = this.kWc.YM;
            View childAt = this.kWc.getChildAt(i - this.kWc.getFirstVisiblePosition());
            if (childAt != null) {
                int i2 = this.kWc.YM;
                long itemId = this.kWc.getAdapter().getItemId(this.kWc.YM);
                if (aov()) {
                    w.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "CheckForLongPress performLongPress position:[%d] id:[%d]", new Object[]{Integer.valueOf(i2), Long.valueOf(itemId)});
                    this.kWc.v(childAt, i);
                    this.kWc.aec = -1;
                    this.kWc.kVI = 5;
                    this.kWc.du(false);
                }
            }
        }
    }

    private class b extends d implements Runnable {
        final /* synthetic */ SmileySubGrid kWc;
        View kWd;
        int kWe;

        public b(SmileySubGrid smileySubGrid) {
            this.kWc = smileySubGrid;
            super(smileySubGrid);
        }

        public final void run() {
            ListAdapter adapter = this.kWc.getAdapter();
            int i = this.kWe;
            if (adapter != null && this.kWc.getCount() > 0 && i != -1 && i < adapter.getCount() && aov()) {
                w.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "PerformClick performItemClick position:[%d] id:[%d] ", new Object[]{Integer.valueOf(i), Long.valueOf(adapter.getItemId(i))});
                this.kWc.performItemClick(this.kWd, i, adapter.getItemId(i));
            }
        }
    }

    public SmileySubGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dZ = LayoutInflater.from(context);
        this.kSs = (WindowManager) context.getSystemService("window");
        this.kVL = new PopEmojiView(getContext());
        this.kVM = new LayoutParams(-1, -1, 2, 8, 1);
        this.kVV = context.getResources().getDimensionPixelSize(R.f.aZN);
        this.kVM.width = this.kVV;
        this.kVM.height = this.kVV;
        this.kVM.gravity = 17;
        this.Yy = anr();
        this.kVR = ViewConfiguration.getPressedStateDuration();
        this.Xd = getResources().getConfiguration().orientation;
        if (this.Xd == 2) {
            this.kVN = this.kSs.getDefaultDisplay().getHeight();
            this.kVO = this.kSs.getDefaultDisplay().getWidth();
            return;
        }
        this.kVN = this.kSs.getDefaultDisplay().getWidth();
        this.kVO = this.kSs.getDefaultDisplay().getHeight();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.kWa) {
            int action = motionEvent.getAction();
            View view = null;
            int i;
            switch (action) {
                case 0:
                    action = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.kSk = (float) action;
                    this.kSl = (float) y;
                    action = pointToPosition(action, y);
                    if (action >= 0 && getAdapter().isEnabled(action)) {
                        this.aec = 0;
                    }
                    if (action >= 0) {
                        this.kVJ = action;
                        view = getChildAt(action - getFirstVisiblePosition());
                    }
                    if (view != null) {
                        view.setPressed(true);
                        view.setSelected(true);
                        cf(view);
                    }
                    if (this.kVS == null) {
                        this.kVS = new a(this);
                    }
                    this.kVS.aou();
                    this.YM = action;
                    if (this.kTk == 25 && this.kTy == 0 && action == 0) {
                        return true;
                    }
                    this.mHandler.postDelayed(this.kVS, (long) this.Yy);
                    return true;
                case 1:
                case 3:
                    i = this.YM;
                    View childAt = getChildAt(i - getFirstVisiblePosition());
                    if (action == 1 && this.aec != -1) {
                        if (this.kVT == null) {
                            this.kVT = new b(this);
                        }
                        Runnable runnable = this.kVT;
                        runnable.kWd = childAt;
                        runnable.kWe = i;
                        runnable.aou();
                        this.mHandler.post(runnable);
                    }
                    this.mHandler.removeCallbacks(this.kVS);
                    du(true);
                    aot();
                    if (this.kVJ >= 0) {
                        view = getChildAt(this.kVJ - getFirstVisiblePosition());
                        if (view != null) {
                            view.setPressed(false);
                            view.setSelected(false);
                            cf(view);
                        }
                    }
                    this.kVI = 6;
                    return true;
                case 2:
                    i = (int) motionEvent.getX();
                    action = (int) motionEvent.getY();
                    if (this.kVI == 5) {
                        i = pointToPosition(i, action);
                        this.YM = i;
                        if ((i < 0 || (this.kTk == 25 && i == 0 && this.kTy == 0)) && !this.kVX) {
                            aot();
                            if (this.kVJ >= 0) {
                                view = getChildAt(this.kVJ - getFirstVisiblePosition());
                                if (view != null) {
                                    view.setPressed(false);
                                    view.setSelected(false);
                                    cf(view);
                                }
                            }
                        } else if (this.kVJ != i) {
                            this.kVJ = i;
                            view = getChildAt(i - getFirstVisiblePosition());
                            layoutChildren();
                            if (view != null) {
                                view.setPressed(true);
                                view.setSelected(true);
                                cf(view);
                                v(view, this.kVJ);
                            }
                        }
                        this.mHandler.removeCallbacks(this.kVS);
                        return true;
                    }
                    if (Math.abs(this.kSk - ((float) i)) > ((float) this.iE)) {
                        this.aec = -1;
                        this.mHandler.removeCallbacks(this.kVS);
                    }
                    aot();
                    return true;
                default:
                    return true;
            }
        }
        aot();
        return super.onTouchEvent(motionEvent);
    }

    private void v(View view, int i) {
        boolean z = i == this.kVY && this.kVL.isShown();
        if (z) {
            w.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "jacks already show:%d", new Object[]{Integer.valueOf(i)});
        } else {
            w.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "jacks begin show:%d", new Object[]{Integer.valueOf(i)});
            com.tencent.mm.storage.a.c cVar = (com.tencent.mm.storage.a.c) getAdapter().getItem(i);
            if (this.kVQ == null) {
                this.kVQ = new c(this);
            }
            m(cVar);
            this.kVL.setBackgroundResource(R.g.beG);
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (this.Xd == 1) {
                this.kVM.x = (iArr[0] - ((this.kVN - view.getMeasuredWidth()) / 2)) + 0;
                this.kVM.y = ((iArr[1] - (this.kVO / 2)) - view.getMeasuredHeight()) + 0;
            } else {
                this.kVM.x = (iArr[0] - ((this.kVO - view.getMeasuredWidth()) / 2)) + 0;
                this.kVM.y = ((iArr[1] - (this.kVN / 2)) - view.getMeasuredHeight()) + 0;
            }
            if (this.kVP) {
                this.kSs.updateViewLayout(this.kVL, this.kVM);
            } else {
                this.kVZ = true;
                this.mHandler.postDelayed(this.kVQ, (long) this.kVR);
            }
        }
        this.kVY = i;
    }

    private void aot() {
        if (this.kVQ != null) {
            this.mHandler.removeCallbacks(this.kVQ);
        }
        if (this.kVP) {
            this.kSs.removeView(this.kVL);
            this.kVP = false;
            this.kVZ = false;
        }
        this.kVW = "";
    }

    private void cf(View view) {
        Rect rect = this.YH;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        this.YH.set(rect.left - getPaddingLeft(), rect.top - getPaddingTop(), rect.right + getPaddingRight(), rect.bottom + getPaddingBottom());
        boolean z = this.kVK;
        if (view.isEnabled() != z) {
            this.kVK = !z;
            refreshDrawableState();
        }
    }

    public void du(boolean z) {
        w.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "cpan t setScrollEnable:%b", new Object[]{Boolean.valueOf(z)});
        if (this.kVU == null) {
            return;
        }
        if (this.kVU instanceof MMFlipper) {
            ((MMFlipper) this.kVU).vhI = z;
        } else if (this.kVU instanceof CustomViewPager) {
            ((CustomViewPager) this.kVU).DC = z;
        }
    }

    public int anr() {
        return ViewConfiguration.getLongPressTimeout();
    }

    public final void m(com.tencent.mm.storage.a.c cVar) {
        Object obj = 1;
        synchronized ("lock_refresh") {
            if (this.kVL == null) {
                w.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "mPopImageView is null.");
            } else if (cVar == null) {
                this.kVL.xM(com.tencent.mm.pluginsdk.ui.emoji.PopEmojiView.a.sRA);
                w.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "emoji is null. set null");
            } else if (!cVar.EP().equals(this.kVW)) {
                this.kVL.xM(com.tencent.mm.pluginsdk.ui.emoji.PopEmojiView.a.sRB);
                this.kVW = cVar.EP();
                if (!(cVar.field_catalog == com.tencent.mm.storage.a.a.uKR && (cVar.field_content.equals(String.valueOf(com.tencent.mm.storage.a.c.uKX)) || cVar.field_content.equals(String.valueOf(com.tencent.mm.storage.a.c.uKW))))) {
                    obj = null;
                }
                if (obj != null) {
                    w.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "emoji drawable name is %s", new Object[]{cVar.getName().split("\\.")[0]});
                    int identifier = getResources().getIdentifier(r0, "drawable", ab.getPackageName());
                    PopEmojiView popEmojiView = this.kVL;
                    if (popEmojiView.sRx != null) {
                        popEmojiView.sRx.setImageResource(identifier);
                    }
                } else {
                    PopEmojiView popEmojiView2;
                    if (cVar.bNt()) {
                        popEmojiView2 = this.kVL;
                        InputStream bc = com.tencent.mm.storage.a.c.bc(ab.getContext(), cVar.getName());
                        String name = cVar.getName();
                        if (popEmojiView2.sRx != null) {
                            popEmojiView2.sRx.a(bc, name);
                        }
                    } else {
                        popEmojiView2 = this.kVL;
                        if (popEmojiView2.sRx != null) {
                            popEmojiView2.sRx.a(cVar, "");
                        }
                    }
                    popEmojiView2 = this.kVL;
                    if (popEmojiView2.sRx != null) {
                        popEmojiView2.sRx.resume();
                    }
                }
            }
        }
    }

    public final void release() {
        super.release();
        aot();
        if (this.kVL != null) {
            this.kVL = null;
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aot();
    }
}
