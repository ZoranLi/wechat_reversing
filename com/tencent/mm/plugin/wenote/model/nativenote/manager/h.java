package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.graphics.Rect;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.ArrowKeyMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;

public final class h extends ArrowKeyMovementMethod {
    private static h swh;
    private static Rect swi = new Rect();

    public static synchronized MovementMethod getInstance() {
        MovementMethod movementMethod;
        synchronized (h.class) {
            if (swh == null) {
                swh = new h();
            }
            movementMethod = swh;
        }
        return movementMethod;
    }

    public final boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 0) {
            int a = a(textView, motionEvent);
            if (a != -1) {
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(a, a, ClickableSpan.class);
                if (clickableSpanArr.length != 0) {
                    if (action != 1 && action == 0) {
                        Selection.setSelection(spannable, spannable.getSpanStart(clickableSpanArr[0]), spannable.getSpanEnd(clickableSpanArr[0]));
                    }
                    return true;
                }
            }
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(android.widget.TextView r14, android.view.MotionEvent r15) {
        /*
        r0 = r15.getX();
        r0 = (int) r0;
        r1 = r15.getY();
        r1 = (int) r1;
        r2 = r14.getTotalPaddingLeft();
        r0 = r0 - r2;
        r2 = r14.getTotalPaddingTop();
        r1 = r1 - r2;
        r2 = r14.getScrollX();
        r5 = r0 + r2;
        r0 = r14.getScrollY();
        r0 = r0 + r1;
        r1 = r14.getLayout();
        r2 = r1.getLineForVertical(r0);
        r3 = swi;
        monitor-enter(r3);
        r4 = swi;	 Catch:{ all -> 0x004f }
        r1.getLineBounds(r2, r4);	 Catch:{ all -> 0x004f }
        r4 = swi;	 Catch:{ all -> 0x004f }
        r0 = r4.contains(r5, r0);	 Catch:{ all -> 0x004f }
        if (r0 != 0) goto L_0x003a;
    L_0x0037:
        r0 = -1;
        monitor-exit(r3);	 Catch:{ all -> 0x004f }
    L_0x0039:
        return r0;
    L_0x003a:
        monitor-exit(r3);	 Catch:{ all -> 0x004f }
        r0 = r14.getText();
        r0 = (android.text.Spanned) r0;
        r6 = r1.getLineStart(r2);
        r7 = r1.getLineEnd(r2);
        r8 = r7 - r6;
        if (r8 != 0) goto L_0x0052;
    L_0x004d:
        r0 = -1;
        goto L_0x0039;
    L_0x004f:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x004f }
        throw r0;
    L_0x0052:
        r0 = r0.subSequence(r6, r7);
        r0 = (android.text.Spanned) r0;
        r2 = 0;
        r1 = 0;
        r3 = android.text.style.LeadingMarginSpan.class;
        r1 = r0.getSpans(r1, r8, r3);
        r1 = (android.text.style.LeadingMarginSpan[]) r1;
        if (r1 == 0) goto L_0x0075;
    L_0x0064:
        r9 = r1.length;
        r3 = 0;
    L_0x0066:
        if (r3 >= r9) goto L_0x0075;
    L_0x0068:
        r4 = r1[r3];
        r10 = 1;
        r4 = r4.getLeadingMargin(r10);
        r4 = r4 + r2;
        r2 = r3 + 1;
        r3 = r2;
        r2 = r4;
        goto L_0x0066;
    L_0x0075:
        r1 = r2;
        r4 = r5 - r1;
        r5 = new float[r8];
        r1 = r14.getPaint();
        r2 = 0;
        r1.getTextWidths(r0, r2, r8, r5);
        r9 = r14.getTextSize();
        r1 = 0;
        r2 = android.text.style.AbsoluteSizeSpan.class;
        r1 = r0.getSpans(r1, r8, r2);
        r1 = (android.text.style.AbsoluteSizeSpan[]) r1;
        if (r1 == 0) goto L_0x00bd;
    L_0x0091:
        r10 = r1.length;
        r2 = 0;
        r3 = r2;
    L_0x0094:
        if (r3 >= r10) goto L_0x00bd;
    L_0x0096:
        r2 = r1[r3];
        r11 = r0.getSpanStart(r2);
        r12 = r0.getSpanEnd(r2);
        r2 = r2.getSize();
        r2 = (float) r2;
        r13 = r2 / r9;
        r2 = java.lang.Math.max(r6, r11);
        r11 = java.lang.Math.min(r7, r12);
    L_0x00af:
        if (r2 >= r11) goto L_0x00b9;
    L_0x00b1:
        r12 = r5[r2];
        r12 = r12 * r13;
        r5[r2] = r12;
        r2 = r2 + 1;
        goto L_0x00af;
    L_0x00b9:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x0094;
    L_0x00bd:
        r1 = 0;
        r0 = 0;
    L_0x00bf:
        if (r0 >= r8) goto L_0x00dc;
    L_0x00c1:
        r2 = r5[r0];
        r2 = r2 + r1;
        r3 = (float) r4;
        r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r3 < 0) goto L_0x00d8;
    L_0x00c9:
        r3 = (float) r4;
        r1 = r3 - r1;
        r3 = (float) r4;
        r2 = r2 - r3;
        r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
        if (r1 >= 0) goto L_0x00d5;
    L_0x00d2:
        r0 = r0 + r6;
        goto L_0x0039;
    L_0x00d5:
        r0 = r0 + 1;
        goto L_0x00d2;
    L_0x00d8:
        r0 = r0 + 1;
        r1 = r2;
        goto L_0x00bf;
    L_0x00dc:
        r0 = -1;
        goto L_0x0039;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.h.a(android.widget.TextView, android.view.MotionEvent):int");
    }
}
