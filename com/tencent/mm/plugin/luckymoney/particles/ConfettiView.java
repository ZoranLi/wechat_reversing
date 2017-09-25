package com.tencent.mm.plugin.luckymoney.particles;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.particles.a.b;
import java.util.List;

public class ConfettiView extends View implements OnLayoutChangeListener {
    List<b> nor;
    boolean npb;
    private boolean npc;
    private b npd;

    public static ConfettiView cx(Context context) {
        ConfettiView confettiView = new ConfettiView(context, null);
        confettiView.setLayoutParams(new LayoutParams(-1, -1));
        if (VERSION.SDK_INT >= 21) {
            confettiView.setElevation((float) context.getResources().getDimensionPixelOffset(R.f.aZm));
        }
        return confettiView;
    }

    public ConfettiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void aIe() {
        if (!this.npb) {
            this.npb = true;
            getParent().requestLayout();
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewGroup viewGroup = (ViewGroup) getParent();
        viewGroup.removeOnLayoutChangeListener(this);
        viewGroup.addOnLayoutChangeListener(this);
        if (this.nor == null) {
            aIe();
        }
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.npb) {
            ViewParent parent = getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.removeViewInLayout(this);
                viewGroup.removeOnLayoutChangeListener(this);
                viewGroup.invalidate();
            }
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.npb) {
            canvas.save();
            for (b bVar : this.nor) {
                if (bVar.npA) {
                    bVar.a(canvas, bVar.npC + bVar.npE, bVar.npD + bVar.npF, bVar.npy);
                } else if (bVar.npz && !bVar.npb) {
                    bVar.a(canvas, bVar.npw, bVar.npx, bVar.npy);
                }
            }
            canvas.restore();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
        r8 = this;
        r1 = 0;
        r2 = 1;
        r0 = r8.npc;
        if (r0 == 0) goto L_0x000d;
    L_0x0006:
        r0 = r9.getAction();
        switch(r0) {
            case 0: goto L_0x0018;
            case 1: goto L_0x009b;
            case 2: goto L_0x0081;
            case 3: goto L_0x009b;
            default: goto L_0x000d;
        };
    L_0x000d:
        r0 = r1;
    L_0x000e:
        if (r0 != 0) goto L_0x0016;
    L_0x0010:
        r0 = super.onTouchEvent(r9);
        if (r0 == 0) goto L_0x00e7;
    L_0x0016:
        r0 = r2;
    L_0x0017:
        return r0;
    L_0x0018:
        r0 = r8.nor;
        r4 = r0.iterator();
    L_0x001e:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x007f;
    L_0x0024:
        r0 = r4.next();
        r0 = (com.tencent.mm.plugin.luckymoney.particles.a.b) r0;
        r5 = r9.getX();
        r6 = r9.getY();
        r3 = r0.npw;
        r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r3 > 0) goto L_0x007b;
    L_0x0038:
        r3 = r0.npw;
        r7 = r0.getWidth();
        r7 = (float) r7;
        r3 = r3 + r7;
        r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r3 > 0) goto L_0x007b;
    L_0x0044:
        r3 = r0.npx;
        r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1));
        if (r3 > 0) goto L_0x007b;
    L_0x004a:
        r3 = r0.npx;
        r7 = r0.getHeight();
        r7 = (float) r7;
        r3 = r3 + r7;
        r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1));
        if (r3 > 0) goto L_0x007b;
    L_0x0056:
        r3 = r2;
    L_0x0057:
        if (r3 == 0) goto L_0x007d;
    L_0x0059:
        r0.npA = r2;
        r0.npC = r5;
        r0.npD = r6;
        r3 = r0.npw;
        r3 = r3 - r5;
        r0.npE = r3;
        r3 = r0.npx;
        r3 = r3 - r6;
        r0.npF = r3;
        r3 = android.view.VelocityTracker.obtain();
        r0.npB = r3;
        r3 = r0.npB;
        r3.addMovement(r9);
        r3 = r2;
    L_0x0075:
        if (r3 == 0) goto L_0x001e;
    L_0x0077:
        r8.npd = r0;
        r0 = r2;
        goto L_0x000e;
    L_0x007b:
        r3 = r1;
        goto L_0x0057;
    L_0x007d:
        r3 = r1;
        goto L_0x0075;
    L_0x007f:
        r0 = r1;
        goto L_0x000e;
    L_0x0081:
        r0 = r8.npd;
        if (r0 == 0) goto L_0x000d;
    L_0x0085:
        r0 = r8.npd;
        r3 = r9.getX();
        r0.npC = r3;
        r3 = r9.getY();
        r0.npD = r3;
        r0 = r0.npB;
        r0.addMovement(r9);
        r0 = r2;
        goto L_0x000e;
    L_0x009b:
        r0 = r8.npd;
        if (r0 == 0) goto L_0x000d;
    L_0x009f:
        r0 = r8.npd;
        r3 = r0.npB;
        r3.addMovement(r9);
        r3 = r0.npB;
        r3.computeCurrentVelocity(r2);
        r4 = -1;
        r0.npk = r4;
        r3 = r9.getX();
        r4 = r0.npE;
        r3 = r3 + r4;
        r0.npl = r3;
        r3 = r9.getY();
        r4 = r0.npF;
        r3 = r3 + r4;
        r0.npm = r3;
        r3 = r0.npB;
        r3 = r3.getXVelocity();
        r0.npn = r3;
        r3 = r0.npB;
        r3 = r3.getYVelocity();
        r0.npo = r3;
        r3 = r0.npy;
        r0.npr = r3;
        r3 = r0.npB;
        r3.recycle();
        r3 = r0.noy;
        r0.g(r3);
        r0.npA = r1;
        r0 = 0;
        r8.npd = r0;
        r0 = r2;
        goto L_0x000e;
    L_0x00e7:
        r0 = r1;
        goto L_0x0017;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.luckymoney.particles.ConfettiView.onTouchEvent(android.view.MotionEvent):boolean");
    }
}
