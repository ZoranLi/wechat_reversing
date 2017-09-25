package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bg.a;
import com.tencent.mm.s.a.d;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.f;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.tools.s;

public class MMTabView extends ViewGroup {
    private int index;
    private TextView ipw;
    private int padding;
    public int piG;
    private TextView uSx;
    private ImageView uVd;

    public MMTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.piG = 3;
        this.padding = 0;
        init();
    }

    public MMTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.piG = 3;
        this.padding = 0;
        init();
    }

    private MMTabView(Context context) {
        super(context);
        this.piG = 3;
        this.padding = 0;
        init();
    }

    public MMTabView(Context context, int i) {
        this(context);
        this.index = i;
        bQq();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bQq() {
        /*
        r10 = this;
        r9 = 2;
        r8 = 1;
        r1 = 0;
        r0 = "MicroMsg.MMTabView";
        r2 = "jacks build : %d desc, unread: %s";
        r3 = new java.lang.Object[r9];
        r4 = r10.index;
        r4 = java.lang.Integer.valueOf(r4);
        r3[r1] = r4;
        r4 = r10.bQr();
        r3[r8] = r4;
        com.tencent.mm.sdk.platformtools.w.d(r0, r2, r3);
        r2 = com.tencent.mm.ui.a.a.a.uWW;
        r0 = r10.ipw;
        r0 = r0.getText();
        r0 = r0.toString();
        r3 = r10.bQr();
        r4 = r10.index;
        r5 = r2.bQH();
        if (r5 == 0) goto L_0x0040;
    L_0x0034:
        if (r10 == 0) goto L_0x0040;
    L_0x0036:
        r5 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r5 != 0) goto L_0x0040;
    L_0x003c:
        r5 = r2.ty;
        if (r5 != 0) goto L_0x0041;
    L_0x0040:
        return;
    L_0x0041:
        r5 = new com.tencent.mm.ui.a.b;
        r5.<init>();
        r5.SK(r0);
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r3);
        if (r0 != 0) goto L_0x0095;
    L_0x004f:
        r0 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bg.getInt(r3, r0);	 Catch:{ Exception -> 0x0094 }
        if (r0 <= 0) goto L_0x0095;
    L_0x0056:
        if (r0 <= 0) goto L_0x006f;
    L_0x0058:
        r3 = r2.ty;
        r3 = r3.getResources();
        r6 = com.tencent.mm.s.a.i.heS;
        r7 = new java.lang.Object[r8];
        r0 = java.lang.Integer.valueOf(r0);
        r7[r1] = r0;
        r0 = r3.getQuantityString(r6, r8, r7);
        r5.SK(r0);
    L_0x006f:
        r0 = r2.ty;
        r0 = r0.getResources();
        r2 = com.tencent.mm.s.a.i.heT;
        r3 = 5;
        r6 = new java.lang.Object[r9];
        r7 = 3;
        r7 = java.lang.Integer.valueOf(r7);
        r6[r1] = r7;
        r1 = r4 + 1;
        r1 = java.lang.Integer.valueOf(r1);
        r6[r8] = r1;
        r0 = r0.getQuantityString(r2, r3, r6);
        r5.SK(r0);
        r5.cZ(r10);
        goto L_0x0040;
    L_0x0094:
        r0 = move-exception;
    L_0x0095:
        r0 = r1;
        goto L_0x0056;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.MMTabView.bQq():void");
    }

    private void init() {
        int dI;
        this.padding = getResources().getDimensionPixelSize(e.aXV);
        String bIN = v.bIN();
        boolean bIJ = v.bIJ();
        boolean equalsIgnoreCase = bIN.equalsIgnoreCase("en");
        if (bIJ) {
            dI = (int) (a.dI(getContext()) * ((float) a.fromDPToPix(getContext(), 2)));
        } else {
            dI = 0;
        }
        this.ipw = new TextView(getContext());
        this.ipw.setSingleLine();
        this.ipw.setEllipsize(TruncateAt.END);
        this.ipw.setTextColor(getResources().getColorStateList(d.aWu));
        this.ipw.setTextSize(0, (float) a.T(getContext(), e.aXs));
        this.ipw.setText("");
        if (bIJ) {
            this.ipw.setTextSize(0, ((float) dI) + this.ipw.getTextSize());
            this.ipw.setTypeface(null, 0);
        } else if (equalsIgnoreCase) {
            this.ipw.setTypeface(null, 1);
        }
        addView(this.ipw);
        this.uVd = new ImageView(getContext());
        this.uVd.setBackgroundResource(f.hbX);
        this.uVd.setVisibility(4);
        addView(this.uVd);
        this.uSx = new TextView(getContext());
        this.uSx.setTextColor(getResources().getColor(d.white));
        this.uSx.setTextSize(1, 11.0f);
        this.uSx.setBackgroundResource(s.fg(getContext()));
        this.uSx.setTypeface(Typeface.DEFAULT_BOLD);
        this.uSx.setGravity(17);
        this.uSx.setVisibility(4);
        addView(this.uSx);
        setBackgroundResource(f.bgi);
    }

    public final void setText(int i) {
        this.ipw.setText(i);
    }

    public final void setTextColor(ColorStateList colorStateList) {
        this.ipw.setTextColor(colorStateList);
    }

    private String bQr() {
        return this.uSx.getText().toString();
    }

    public final void SH(final String str) {
        if (bg.mA(str)) {
            this.uSx.setVisibility(4);
            return;
        }
        this.uSx.setVisibility(0);
        this.uSx.post(new Runnable(this) {
            final /* synthetic */ MMTabView uVf;

            public final void run() {
                this.uVf.uSx.setText(str);
                this.uVf.bQq();
            }
        });
    }

    public final void kz(boolean z) {
        this.uVd.setVisibility(z ? 0 : 4);
    }

    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec;
        int size = (MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        int size2 = (MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
        if (MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE);
        } else {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        }
        this.ipw.measure(MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), makeMeasureSpec);
        this.uVd.measure(MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), makeMeasureSpec);
        this.uSx.measure(MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), makeMeasureSpec);
        setMeasuredDimension(size, size2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int measuredWidth = (i5 - this.ipw.getMeasuredWidth()) / 2;
        int measuredWidth2 = this.ipw.getMeasuredWidth() + measuredWidth;
        int measuredHeight = (i6 - this.ipw.getMeasuredHeight()) / 2;
        this.ipw.layout(measuredWidth, measuredHeight, measuredWidth2, this.ipw.getMeasuredHeight() + measuredHeight);
        measuredHeight = this.padding + measuredWidth2;
        int measuredHeight2 = (i6 - this.uVd.getMeasuredHeight()) / 2;
        this.uVd.layout(measuredHeight, measuredHeight2, this.uVd.getMeasuredWidth() + measuredHeight, this.uVd.getMeasuredHeight() + measuredHeight2);
        if (measuredWidth - this.padding < this.uSx.getMeasuredWidth()) {
            i5 -= this.uSx.getMeasuredWidth();
            i6 = (i6 - this.uSx.getMeasuredHeight()) / 2;
            this.uSx.layout(i5, i6, this.uSx.getMeasuredWidth() + i5, this.uSx.getMeasuredHeight() + i6);
            return;
        }
        i5 = this.padding + measuredWidth2;
        i6 = (i6 - this.uSx.getMeasuredHeight()) / 2;
        this.uSx.layout(i5, i6, this.uSx.getMeasuredWidth() + i5, this.uSx.getMeasuredHeight() + i6);
    }
}
