package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QTextView extends View {
    private static HashMap<String, a> qwN = new HashMap();
    private Context context;
    private TextPaint gm;
    private String jqT = "";
    int mGI;
    private int qwG;
    String qwH;
    String qwI;
    private boolean qwJ;
    private int qwK;
    private boolean qwL;
    boolean qwM;
    private a qwO;
    private a qwP;
    int qwQ = 0;
    private int textSize = -1;

    private static class a {
        private static HashMap<String, Integer> qwW = new HashMap();
        public String arH = "";
        private int qwQ = 0;
        boolean qwR = false;
        ArrayList<int[]> qwS = new ArrayList();
        float qwT;
        float qwU;
        float qwV;

        public final int a(String str, String str2, String str3, int i, int i2, TextPaint textPaint) {
            String str4 = str + str2 + str3 + i + i2;
            if (str4.equals(this.arH)) {
                return this.qwQ;
            }
            this.arH = str4;
            this.qwS.clear();
            this.qwR = false;
            this.qwT = 0.0f;
            this.qwU = 0.0f;
            this.qwV = 0.0f;
            if (i2 == -1) {
                this.qwS.add(new int[]{null, str.length()});
                this.qwQ = (int) (textPaint.measureText(str) + 0.5f);
                return this.qwQ;
            }
            if (str2 != null) {
                this.qwU = textPaint.measureText(str2);
            }
            if (str3 != null) {
                this.qwV = textPaint.measureText(str3);
            }
            int i3 = -1;
            float f = 0.0f;
            Object obj = 1;
            int i4 = 0;
            while (i4 < str.length()) {
                if (i3 == -1) {
                    i3 = i4;
                }
                if (this.qwS.size() == i) {
                    this.qwR = true;
                    break;
                }
                int i5;
                Object obj2;
                float measureText = textPaint.measureText(str.charAt(i4));
                Object obj3 = null;
                if (str.charAt(i4) == '\n') {
                    this.qwS.add(new int[]{i3, i4 - 1});
                    i5 = i4;
                    obj2 = 1;
                } else {
                    if (f + measureText >= ((float) i2)) {
                        obj3 = 1;
                        if (str.charAt(i4) == ' ' || r2 == null) {
                            i4--;
                            this.qwS.add(new int[]{i3, i4});
                            i5 = i4;
                            i4 = 1;
                        } else {
                            while (str.charAt(i4) != ' ') {
                                i4--;
                                if (i4 == 0) {
                                    break;
                                }
                            }
                            this.qwS.add(new int[]{i3, i4});
                        }
                    }
                    Object obj4 = obj3;
                    i5 = i4;
                    obj2 = obj4;
                }
                if (obj2 != null) {
                    i3 = -1;
                    f = 0.0f;
                    if (this.qwS.size() == i - 1) {
                        i2 = (int) (((float) i2) - (this.qwU + this.qwV));
                        obj = null;
                    }
                } else {
                    f += measureText;
                    if (i5 == str.length() - 1) {
                        this.qwS.add(new int[]{i3, i5});
                    }
                }
                i4 = i5 + 1;
            }
            if (this.qwR) {
                int[] iArr = (int[]) this.qwS.get(this.qwS.size() - 1);
                this.qwT = textPaint.measureText(str.substring(iArr[0], iArr[1] + 1));
            }
            if (this.qwS.size() == 0) {
                this.qwQ = 0;
                return this.qwQ;
            } else if (this.qwS.size() == 1) {
                this.qwQ = (int) (textPaint.measureText(str) + 0.5f);
                return this.qwQ;
            } else {
                this.qwQ = i2;
                return this.qwQ;
            }
        }
    }

    public QTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public QTextView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    private void init() {
        this.qwM = false;
        this.qwJ = true;
        this.qwL = false;
        this.mGI = -1;
        this.qwH = "...";
        this.qwI = "";
        this.qwK = -16776961;
        this.qwO = new a();
        this.qwP = new a();
        this.gm = new TextPaint();
        this.gm.setAntiAlias(true);
        if (this.textSize == -1) {
            this.textSize = b.a(this.context, 12.0f);
            this.gm.setTextSize((float) this.textSize);
        } else {
            this.gm.setTextSize(13.0f);
        }
        this.gm.setColor(WebView.NIGHT_MODE_COLOR);
        this.gm.setTextAlign(Align.LEFT);
    }

    public final void setText(String str) {
        if (bg.mA(this.jqT)) {
            this.jqT = "";
        }
        this.jqT = str;
        this.qwO.arH = "";
        this.qwP.arH = "";
        requestLayout();
        invalidate();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            tS(size);
        } else if (mode == Integer.MIN_VALUE) {
            size = Math.min(tS(size), size);
        } else {
            tS(size);
            size = 0;
        }
        int mode2 = MeasureSpec.getMode(i2);
        mode = MeasureSpec.getSize(i2);
        this.qwG = (int) this.gm.ascent();
        if (mode2 == 1073741824) {
            i3 = mode;
        } else {
            i3 = (((this.qwM ? this.qwO.qwS.size() : this.qwP.qwS.size()) * ((int) (((float) (-this.qwG)) + this.gm.descent()))) + getPaddingTop()) + getPaddingBottom();
            if (mode2 == Integer.MIN_VALUE) {
                i3 = Math.min(i3, mode);
            }
        }
        setMeasuredDimension(size, i3);
    }

    protected void onDraw(Canvas canvas) {
        a aVar;
        super.onDraw(canvas);
        a aVar2;
        if (this.qwM) {
            aVar2 = this.qwO;
            List list = this.qwO.qwS;
            aVar = aVar2;
        } else {
            aVar2 = this.qwP;
            Object obj = this.qwP.qwS;
            aVar = aVar2;
        }
        float paddingLeft = (float) getPaddingLeft();
        float paddingTop = (float) (getPaddingTop() + (-this.qwG));
        int i = 0;
        while (i < list.size()) {
            int[] iArr = (int[]) list.get(i);
            canvas.drawText(this.jqT, iArr[0], iArr[1] + 1, paddingLeft, paddingTop, this.gm);
            if (i == list.size() - 1 && aVar.qwR) {
                canvas.drawText(this.qwH, aVar.qwT + paddingLeft, paddingTop, this.gm);
                if (this.qwJ) {
                    int color = this.gm.getColor();
                    this.gm.setColor(this.qwK);
                    if (this.qwL) {
                        canvas.drawText(this.qwI, ((float) canvas.getWidth()) - ((aVar.qwV + ((float) getPaddingRight())) + ((float) getPaddingLeft())), paddingTop, this.gm);
                    } else {
                        canvas.drawText(this.qwI, (aVar.qwT + aVar.qwU) + paddingLeft, paddingTop, this.gm);
                    }
                    this.gm.setColor(color);
                }
            }
            paddingTop += ((float) (-this.qwG)) + this.gm.descent();
            if (paddingTop <= ((float) canvas.getHeight())) {
                i++;
            } else {
                return;
            }
        }
    }

    private int tS(int i) {
        if (this.qwM) {
            if (bg.mA(this.qwO.arH)) {
                this.qwQ = this.qwO.a(this.jqT, null, null, -1, (i - getPaddingLeft()) - getPaddingRight(), this.gm);
            }
        } else if (bg.mA(this.qwP.arH)) {
            this.qwQ = this.qwP.a(this.jqT, this.qwH, this.qwI, this.mGI, (i - getPaddingLeft()) - getPaddingRight(), this.gm);
        }
        return (this.qwQ + getPaddingLeft()) + getPaddingRight();
    }
}
