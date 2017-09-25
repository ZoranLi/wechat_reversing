package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;

public final class k implements OnTouchListener {
    private static boolean DEBUG = false;
    private static int sTP;
    public static int wE = ViewConfiguration.getTapTimeout();
    String iCS;
    private l sTL = null;
    private boolean sTM = false;
    private View sTN = null;
    public boolean sTO = false;
    private Context sTQ = null;
    private ae sTR = new ae(Looper.getMainLooper());
    private b sTS = new b(this);
    private a sTT = new a(this);
    public View view;

    class a implements Runnable {
        final /* synthetic */ k sTU;

        a(k kVar) {
            this.sTU = kVar;
        }

        public final void run() {
            if (this.sTU.view != null && this.sTU.view.isPressed()) {
                w.d("MicroMsg.PressSpanTouchListener", "long pressed timeout");
                this.sTU.sTO = true;
                this.sTU.aED();
            }
        }
    }

    private class b implements Runnable {
        final /* synthetic */ k sTU;

        public b(k kVar) {
            this.sTU = kVar;
        }

        public final void run() {
            this.sTU.xP(k.wE);
        }
    }

    static {
        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
        sTP = longPressTimeout;
        if (longPressTimeout > wE * 2) {
            sTP -= wE;
        }
        w.d("MicroMsg.PressSpanTouchListener", "long press timeout:%d", Integer.valueOf(sTP));
    }

    public k(Context context) {
        this.sTQ = context;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouch(android.view.View r12, android.view.MotionEvent r13) {
        /*
        r11 = this;
        r0 = r12 instanceof android.widget.TextView;
        if (r0 != 0) goto L_0x000a;
    L_0x0004:
        r0 = r12 instanceof com.tencent.mm.kiss.widget.textview.StaticTextView;
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        r0 = 0;
    L_0x0009:
        return r0;
    L_0x000a:
        r0 = r13.getAction();
        if (r0 != 0) goto L_0x0028;
    L_0x0010:
        r0 = 2;
        r0 = new int[r0];
        r1 = 0;
        r2 = r13.getRawX();
        r2 = (int) r2;
        r0[r1] = r2;
        r1 = 1;
        r2 = r13.getRawY();
        r2 = (int) r2;
        r0[r1] = r2;
        r1 = com.tencent.mm.plugin.comm.a.d.cJw;
        r12.setTag(r1, r0);
    L_0x0028:
        r11.view = r12;
        r0 = r12 instanceof android.widget.TextView;
        if (r0 == 0) goto L_0x0135;
    L_0x002e:
        r0 = r12;
        r0 = (android.widget.TextView) r0;
        r2 = r0.getLayout();
        r0 = r12;
        r0 = (android.widget.TextView) r0;
        r1 = r0.getText();
        r3 = r2;
    L_0x003d:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x008f;
    L_0x0041:
        r0 = "MicroMsg.PressSpanTouchListener";
        r2 = new java.lang.StringBuilder;
        r4 = "ontouch action: %d, isLongPress:%b ";
        r2.<init>(r4);
        r2 = r2.append(r3);
        r4 = " ";
        r2 = r2.append(r4);
        r4 = r1 instanceof android.text.Spanned;
        r2 = r2.append(r4);
        r4 = " ";
        r2 = r2.append(r4);
        r4 = new com.tencent.mm.sdk.platformtools.ah;
        r4.<init>();
        r4 = r4.toString();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = r13.getAction();
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        r5 = 1;
        r6 = r11.sTO;
        r6 = java.lang.Boolean.valueOf(r6);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.w.d(r0, r2, r4);
    L_0x008f:
        r5 = android.view.MotionEvent.obtain(r13);
        r0 = r1 instanceof android.text.Spanned;
        if (r0 == 0) goto L_0x00d6;
    L_0x0097:
        if (r3 == 0) goto L_0x00d6;
    L_0x0099:
        r0 = r1;
        r0 = (android.text.Spanned) r0;
        r2 = r5.getAction();
        r12.invalidate();
        r4 = 1;
        if (r2 == r4) goto L_0x00ae;
    L_0x00a6:
        if (r2 == 0) goto L_0x00ae;
    L_0x00a8:
        r4 = 2;
        if (r2 == r4) goto L_0x00ae;
    L_0x00ab:
        r4 = 3;
        if (r2 != r4) goto L_0x0275;
    L_0x00ae:
        r2 = r5.getX();
        r4 = (int) r2;
        r2 = r5.getY();
        r6 = (int) r2;
        r2 = r12 instanceof com.tencent.mm.kiss.widget.textview.StaticTextView;
        if (r2 == 0) goto L_0x0162;
    L_0x00bc:
        r2 = r12;
        r2 = (com.tencent.mm.kiss.widget.textview.StaticTextView) r2;
        r2 = r2.vT();
        if (r4 < r2) goto L_0x00d3;
    L_0x00c5:
        r7 = r3.getWidth();
        r2 = r12;
        r2 = (com.tencent.mm.kiss.widget.textview.StaticTextView) r2;
        r2 = r2.vT();
        r2 = r2 + r7;
        if (r4 <= r2) goto L_0x0146;
    L_0x00d3:
        r11.G(r5);
    L_0x00d6:
        r5.recycle();
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0132;
    L_0x00dd:
        r0 = "MicroMsg.PressSpanTouchListener";
        r2 = new java.lang.StringBuilder;
        r4 = "ontouch action2: %d, isLongPress:%b ";
        r2.<init>(r4);
        r2 = r2.append(r3);
        r3 = " ";
        r2 = r2.append(r3);
        r1 = r1 instanceof android.text.Spanned;
        r1 = r2.append(r1);
        r2 = " processResult: false";
        r1 = r1.append(r2);
        r2 = " ";
        r1 = r1.append(r2);
        r2 = new com.tencent.mm.sdk.platformtools.ah;
        r2.<init>();
        r2 = r2.toString();
        r1 = r1.append(r2);
        r1 = r1.toString();
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r13.getAction();
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = r11.sTO;
        r4 = java.lang.Boolean.valueOf(r4);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.w.d(r0, r1, r2);
    L_0x0132:
        r0 = 0;
        goto L_0x0009;
    L_0x0135:
        r0 = r12;
        r0 = (com.tencent.mm.kiss.widget.textview.StaticTextView) r0;
        r2 = r0.wb();
        r0 = r12;
        r0 = (com.tencent.mm.kiss.widget.textview.StaticTextView) r0;
        r1 = r0.getText();
        r3 = r2;
        goto L_0x003d;
    L_0x0146:
        r2 = r12;
        r2 = (com.tencent.mm.kiss.widget.textview.StaticTextView) r2;
        r2 = r2.vU();
        if (r6 < r2) goto L_0x015d;
    L_0x014f:
        r7 = r3.getHeight();
        r2 = r12;
        r2 = (com.tencent.mm.kiss.widget.textview.StaticTextView) r2;
        r2 = r2.vU();
        r2 = r2 + r7;
        if (r6 <= r2) goto L_0x019e;
    L_0x015d:
        r11.G(r5);
        goto L_0x00d6;
    L_0x0162:
        r2 = r12 instanceof android.widget.TextView;
        if (r2 == 0) goto L_0x019e;
    L_0x0166:
        r2 = r12;
        r2 = (android.widget.TextView) r2;
        r2 = r2.getTotalPaddingLeft();
        if (r4 < r2) goto L_0x017d;
    L_0x016f:
        r7 = r3.getWidth();
        r2 = r12;
        r2 = (android.widget.TextView) r2;
        r2 = r2.getTotalPaddingLeft();
        r2 = r2 + r7;
        if (r4 <= r2) goto L_0x0182;
    L_0x017d:
        r11.G(r5);
        goto L_0x00d6;
    L_0x0182:
        r2 = r12;
        r2 = (android.widget.TextView) r2;
        r2 = r2.getTotalPaddingTop();
        if (r6 < r2) goto L_0x0199;
    L_0x018b:
        r7 = r3.getHeight();
        r2 = r12;
        r2 = (android.widget.TextView) r2;
        r2 = r2.getTotalPaddingTop();
        r2 = r2 + r7;
        if (r6 <= r2) goto L_0x019e;
    L_0x0199:
        r11.G(r5);
        goto L_0x00d6;
    L_0x019e:
        r2 = r12 instanceof android.widget.TextView;
        if (r2 == 0) goto L_0x0295;
    L_0x01a2:
        r2 = r12;
        r2 = (android.widget.TextView) r2;
        r2 = r2.getTotalPaddingLeft();
        r4 = r4 - r2;
        r2 = r12;
        r2 = (android.widget.TextView) r2;
        r2 = r2.getTotalPaddingTop();
        r2 = r6 - r2;
    L_0x01b3:
        r6 = r12.getScrollX();
        r4 = r4 + r6;
        r6 = r12.getScrollY();
        r2 = r2 + r6;
        r2 = r3.getLineForVertical(r2);
        r4 = (float) r4;
        r2 = r3.getOffsetForHorizontal(r2, r4);
        r4 = r12 instanceof android.widget.TextView;
        if (r4 == 0) goto L_0x01d2;
    L_0x01ca:
        r4 = r0.length();
        if (r2 >= r4) goto L_0x01d2;
    L_0x01d0:
        r2 = r2 + 1;
    L_0x01d2:
        r4 = r5.getAction();
        r6 = com.tencent.mm.pluginsdk.ui.d.l.class;
        r0 = r0.getSpans(r2, r2, r6);
        r0 = (com.tencent.mm.pluginsdk.ui.d.l[]) r0;
        r2 = r0.length;
        r2 = r2 + -1;
        r6 = DEBUG;
        if (r6 == 0) goto L_0x0234;
    L_0x01e5:
        r6 = "MicroMsg.PressSpanTouchListener";
        r7 = new java.lang.StringBuilder;
        r8 = "processPress action: %d, isLongPress:%b ";
        r7.<init>(r8);
        r8 = r0.length;
        r7 = r7.append(r8);
        r8 = " ";
        r7 = r7.append(r8);
        r8 = r11.sTL;
        r7 = r7.append(r8);
        r8 = " ";
        r7 = r7.append(r8);
        r8 = new com.tencent.mm.sdk.platformtools.ah;
        r8.<init>();
        r8 = r8.toString();
        r7 = r7.append(r8);
        r7 = r7.toString();
        r8 = 2;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r10 = r5.getAction();
        r10 = java.lang.Integer.valueOf(r10);
        r8[r9] = r10;
        r9 = 1;
        r10 = r11.sTO;
        r10 = java.lang.Boolean.valueOf(r10);
        r8[r9] = r10;
        com.tencent.mm.sdk.platformtools.w.d(r6, r7, r8);
    L_0x0234:
        r6 = r0.length;
        if (r6 == 0) goto L_0x03d1;
    L_0x0237:
        r6 = 1;
        if (r4 != r6) goto L_0x0312;
    L_0x023a:
        r0 = r11.sTR;
        r2 = r11.sTS;
        r0.removeCallbacks(r2);
        r0 = r11.sTR;
        r2 = r11.sTT;
        r0.removeCallbacks(r2);
        r0 = r11.sTO;
        if (r0 == 0) goto L_0x02b9;
    L_0x024c:
        r11.aED();
        r0 = 0;
        r11.sTO = r0;
        r0 = r11.sTM;
        r12.setClickable(r0);
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0275;
    L_0x025b:
        r0 = "MicroMsg.PressSpanTouchListener";
        r2 = new java.lang.StringBuilder;
        r4 = "processPress action1 ";
        r2.<init>(r4);
        r4 = r5.getAction();
        r2 = r2.append(r4);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.w.i(r0, r2);
    L_0x0275:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x00d6;
    L_0x0279:
        r0 = "MicroMsg.PressSpanTouchListener";
        r2 = new java.lang.StringBuilder;
        r4 = "processTouch action2 ";
        r2.<init>(r4);
        r4 = r5.getAction();
        r2 = r2.append(r4);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.w.i(r0, r2);
        goto L_0x00d6;
    L_0x0295:
        r2 = r12 instanceof com.tencent.mm.kiss.widget.textview.StaticTextView;
        if (r2 == 0) goto L_0x02ac;
    L_0x0299:
        r2 = r12;
        r2 = (com.tencent.mm.kiss.widget.textview.StaticTextView) r2;
        r2 = r2.vT();
        r4 = r4 - r2;
        r2 = r12;
        r2 = (com.tencent.mm.kiss.widget.textview.StaticTextView) r2;
        r2 = r2.vU();
        r2 = r6 - r2;
        goto L_0x01b3;
    L_0x02ac:
        r2 = r12.getPaddingLeft();
        r4 = r4 - r2;
        r2 = r12.getPaddingTop();
        r2 = r6 - r2;
        goto L_0x01b3;
    L_0x02b9:
        r0 = 0;
        r11.sTO = r0;
        r0 = r11.sTL;
        if (r0 == 0) goto L_0x0308;
    L_0x02c0:
        r0 = r11.sTL;
        r2 = r11.iCS;
        r0.iCS = r2;
        r2 = r0.sTW;
        if (r2 == 0) goto L_0x02d0;
    L_0x02ca:
        r2 = r0.sTW;
        r0 = r0.iCS;
        r2.iCS = r0;
    L_0x02d0:
        r0 = r11.sTQ;
        if (r0 == 0) goto L_0x02db;
    L_0x02d4:
        r0 = r11.sTL;
        r2 = r11.sTQ;
        r0.setContext(r2);
    L_0x02db:
        r0 = r11.sTL;
        r0.onClick(r12);
    L_0x02e0:
        r0 = r11.sTM;
        r12.setClickable(r0);
        r11.aED();
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0275;
    L_0x02ec:
        r0 = "MicroMsg.PressSpanTouchListener";
        r2 = new java.lang.StringBuilder;
        r4 = "processPress action2 ";
        r2.<init>(r4);
        r4 = r5.getAction();
        r2 = r2.append(r4);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.w.i(r0, r2);
        goto L_0x0275;
    L_0x0308:
        r0 = "MicroMsg.PressSpanTouchListener";
        r2 = "ACTION_UP error, lastClickSpan is null";
        com.tencent.mm.sdk.platformtools.w.e(r0, r2);
        goto L_0x02e0;
    L_0x0312:
        if (r4 == 0) goto L_0x0317;
    L_0x0314:
        r6 = 2;
        if (r4 != r6) goto L_0x0398;
    L_0x0317:
        if (r4 != 0) goto L_0x0321;
    L_0x0319:
        r6 = sTP;
        if (r6 <= 0) goto L_0x0321;
    L_0x031d:
        r6 = 0;
        r11.xP(r6);
    L_0x0321:
        if (r4 != 0) goto L_0x0329;
    L_0x0323:
        r4 = r12.isClickable();
        r11.sTM = r4;
    L_0x0329:
        r11.aED();
        r4 = r0[r2];
        r11.sTL = r4;
        r11.sTN = r12;
        r4 = r0[r2];
        r6 = 0;
        r4.setContext(r6);
        r4 = r0[r2];
        r6 = 1;
        r4.nII = r6;
        r4 = r0[r2];
        r6 = 1;
        r4.mEnable = r6;
        r12.invalidate();
        r4 = r11.sTO;
        if (r4 == 0) goto L_0x0378;
    L_0x0349:
        r4 = r0[r2];
        r6 = 0;
        r4.nII = r6;
        r0 = r0[r2];
        r2 = 0;
        r0.mEnable = r2;
        r0 = r11.sTM;
        r12.setClickable(r0);
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0275;
    L_0x035c:
        r0 = "MicroMsg.PressSpanTouchListener";
        r2 = new java.lang.StringBuilder;
        r4 = "processPress action3 ";
        r2.<init>(r4);
        r4 = r5.getAction();
        r2 = r2.append(r4);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.w.i(r0, r2);
        goto L_0x0275;
    L_0x0378:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0275;
    L_0x037c:
        r0 = "MicroMsg.PressSpanTouchListener";
        r2 = new java.lang.StringBuilder;
        r4 = "processPress action4 ";
        r2.<init>(r4);
        r4 = r5.getAction();
        r2 = r2.append(r4);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.w.i(r0, r2);
        goto L_0x0275;
    L_0x0398:
        r0 = 3;
        if (r4 != r0) goto L_0x03d4;
    L_0x039b:
        r0 = r11.sTR;
        r2 = r11.sTS;
        r0.removeCallbacks(r2);
        r0 = r11.sTR;
        r2 = r11.sTT;
        r0.removeCallbacks(r2);
        r0 = r11.sTM;
        r12.setClickable(r0);
        r11.aED();
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0275;
    L_0x03b5:
        r0 = "MicroMsg.PressSpanTouchListener";
        r2 = new java.lang.StringBuilder;
        r4 = "processPress action5 ";
        r2.<init>(r4);
        r4 = r5.getAction();
        r2 = r2.append(r4);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.w.i(r0, r2);
        goto L_0x0275;
    L_0x03d1:
        r11.aED();
    L_0x03d4:
        r0 = 1;
        if (r4 != r0) goto L_0x03da;
    L_0x03d7:
        r0 = 0;
        r11.sTO = r0;
    L_0x03da:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0275;
    L_0x03de:
        r0 = "MicroMsg.PressSpanTouchListener";
        r2 = new java.lang.StringBuilder;
        r4 = "processPress action6 ";
        r2.<init>(r4);
        r4 = r5.getAction();
        r2 = r2.append(r4);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.w.i(r0, r2);
        goto L_0x0275;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.d.k.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    private void G(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            aED();
        }
    }

    public final void aED() {
        if (this.sTL != null) {
            this.sTL.nII = false;
            this.sTL.setContext(null);
            this.sTN.invalidate();
            this.sTN = null;
            this.sTL = null;
        }
    }

    public final void xP(int i) {
        if (this.view != null) {
            this.sTR.postDelayed(this.sTT, (long) (sTP - i));
        }
    }
}
