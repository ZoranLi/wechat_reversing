package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.a.i;
import com.tencent.mm.protocal.c.pc;
import com.tencent.mm.protocal.c.pe;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.MMDotView;
import java.util.Iterator;
import java.util.LinkedList;

public class EmojiStoreVpHeader extends LinearLayout implements e {
    private View kHP;
    private MMDotView kSg;
    private ViewPager kSh;
    private LinkedList<com.tencent.mm.plugin.emoji.model.a> kSi;
    private i kSj;
    private float kSk;
    private float kSl;
    private a kSm;
    private volatile boolean kSn;
    private final int kSo = 5;
    private final int kSp = 0;
    private View khv;

    private class a extends ae {
        final /* synthetic */ EmojiStoreVpHeader kSq;

        public a(EmojiStoreVpHeader emojiStoreVpHeader) {
            this.kSq = emojiStoreVpHeader;
        }

        public final void handleMessage(Message message) {
            if (!this.kSq.kSn && message.what != 0) {
                return;
            }
            if (this.kSq.kSi == null || this.kSq.kSi.size() <= 1) {
                w.w("MicroMsg.emoji.EmojiStoreVpHeader", "list is null");
            } else if (this.kSq.kSj == null) {
                w.w("MicroMsg.emoji.EmojiStoreVpHeader", "adapter is null");
            } else {
                int i = this.kSq.kSh.ys + 1;
                if (i >= this.kSq.kSj.getCount()) {
                    i = (this.kSq.kSi.size() * i.kIF) / 2;
                }
                this.kSq.kSh.Y(i);
                if (this.kSq.kSn && this.kSq.kSm != null) {
                    sendMessageDelayed(this.kSq.kSm.obtainMessage(0), 5000);
                }
            }
        }
    }

    public EmojiStoreVpHeader(Context context) {
        super(context);
        setOrientation(1);
    }

    public EmojiStoreVpHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
    }

    public static int[] aG(Context context) {
        int[] iArr = new int[2];
        if (context instanceof Activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            iArr[0] = displayMetrics.widthPixels;
            iArr[1] = displayMetrics.heightPixels;
        } else {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            iArr[0] = defaultDisplay.getWidth();
            iArr[1] = defaultDisplay.getHeight();
        }
        return iArr;
    }

    private synchronized void anE() {
        if (this.kSi == null) {
            throw new IllegalAccessError("must has emoji baner list first");
        }
        if (this.khv == null) {
            this.khv = inflate(getContext(), R.i.daW, null);
            this.kHP = this.khv.findViewById(R.h.bLv);
            this.kSg = (MMDotView) this.khv.findViewById(R.h.bLu);
            this.kSh = (ViewPager) this.khv.findViewById(R.h.bLw);
            this.kSm = new a(this);
            int i = ((aG(getContext())[0] * 3) / 8) + 1;
            if (this.kHP != null) {
                this.kHP.setLayoutParams(new LayoutParams(-1, i));
            }
            addView(this.khv, new LayoutParams(-1, -2));
        }
        if (this.kSg != null) {
            this.kSg.Ad(this.kSi == null ? 0 : this.kSi.size());
            this.kSg.Ae(0);
            this.kSg.setVisibility(8);
        }
        if (!(this.kSh == null || this.kSi == null)) {
            if (this.kSi.size() > 0) {
                if (this.kHP != null) {
                    this.kHP.setVisibility(0);
                }
                this.kSh.zb = this;
                if (this.kSj == null) {
                    this.kSj = new i(getContext(), this.kSi);
                    this.kSh.a(this.kSj);
                    ViewPager viewPager = this.kSh;
                    if (1 != viewPager.yJ) {
                        viewPager.yJ = 1;
                        viewPager.populate();
                    }
                    anF();
                } else {
                    post(new Runnable(this) {
                        final /* synthetic */ EmojiStoreVpHeader kSq;

                        {
                            this.kSq = r1;
                        }

                        public final void run() {
                            if (this.kSq.kSj != null && this.kSq.kSi != null) {
                                this.kSq.kSj.H(this.kSq.kSi);
                            }
                        }
                    });
                }
            } else if (this.kHP != null) {
                this.kHP.setVisibility(8);
            }
        }
    }

    private void anF() {
        if (this.kSh != null) {
            this.kSh.k((i.kIF / 2) * this.kSi.size(), false);
        }
    }

    public final void anG() {
        if (this.kSm == null) {
            this.kSm = new a(this);
        }
        this.kSn = true;
        this.kSm.removeMessages(0);
        this.kSm.sendEmptyMessageDelayed(0, 5000);
    }

    public final void anH() {
        if (this.kSm != null) {
            this.kSn = false;
            this.kSm.removeMessages(0);
        }
    }

    public final void clear() {
        if (this.kSj != null) {
            i iVar = this.kSj;
            if (iVar.kIE != null) {
                iVar.kIE.clear();
            }
            if (iVar.kII != null) {
                iVar.kII.clear();
            }
            iVar.kIH = true;
            this.kSj = null;
        }
        this.kSm = null;
    }

    public final void c(LinkedList<pc> linkedList, LinkedList<pe> linkedList2) {
        if (linkedList != null) {
            if (this.kSi == null) {
                this.kSi = new LinkedList();
            } else {
                this.kSi.clear();
            }
            Iterator it = linkedList2.iterator();
            while (it.hasNext()) {
                pe peVar = (pe) it.next();
                if (!(peVar == null || peVar.tuK == null || bg.mA(peVar.tuK.tuL))) {
                    this.kSi.add(new com.tencent.mm.plugin.emoji.model.a(null, peVar, true));
                }
            }
            it = linkedList.iterator();
            while (it.hasNext()) {
                pc pcVar = (pc) it.next();
                if (!(pcVar == null || pcVar.tuK == null || bg.mA(pcVar.tuK.tuL))) {
                    this.kSi.add(new com.tencent.mm.plugin.emoji.model.a(pcVar, null, false));
                }
            }
            anE();
        }
    }

    public final void W(int i) {
    }

    public final void a(int i, float f, int i2) {
    }

    public final void V(int i) {
        if (this.kSi != null && this.kSi.size() > 1) {
            if (i == 0 || i == this.kSj.getCount() - 1) {
                this.khv.postDelayed(new Runnable(this) {
                    final /* synthetic */ EmojiStoreVpHeader kSq;

                    {
                        this.kSq = r1;
                    }

                    public final void run() {
                        this.kSq.anF();
                    }
                }, 350);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int action2 = motionEvent.getAction();
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        switch (action2) {
            case 0:
                this.kSk = rawX;
                this.kSl = rawY;
                break;
            case 1:
            case 3:
                this.kSk = 0.0f;
                this.kSl = 0.0f;
                dw(false);
                break;
            case 2:
                if (Math.abs((int) (rawX - this.kSk)) > Math.abs((int) (rawY - this.kSl))) {
                    dw(true);
                    break;
                }
                break;
        }
        switch (action) {
            case 0:
                anH();
                break;
            case 1:
            case 3:
                anG();
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private void dw(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }
}
