package com.tencent.mm.plugin.setting.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.setting.ui.setting.SetTextSizeUI;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class FontSelectorView extends View {
    private static SoftReference<Bitmap> pnB = null;
    private static int pnK = 8;
    private int icA = 0;
    private float jWC = 0.0f;
    private float mxi = 0.0f;
    private int nUG = 0;
    private List<b> pnC = new ArrayList(8);
    private int pnD = 0;
    private int pnE = 0;
    private int pnF = 0;
    private int pnG = 0;
    private int pnH = 0;
    public int pnI = 0;
    public a pnJ = null;
    private boolean pnL = false;
    private boolean pnM = false;
    private int topOffset = 0;

    public interface a {
        void sq(int i);
    }

    private static class b {
        public int bottom = 0;
        public int left = 0;
        public int right = 0;
        public int top = 0;
    }

    public FontSelectorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FontSelectorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @SuppressLint({"DrawAllocation"})
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        baC();
        this.pnC.clear();
        setClickable(true);
        this.pnD = com.tencent.mm.bg.a.fromDPToPix(getContext(), 30);
        this.topOffset = com.tencent.mm.bg.a.fromDPToPix(getContext(), 10);
        int width = getWidth();
        this.nUG = (getHeight() / 2) + this.topOffset;
        pnK = 8;
        this.icA = (width - (this.pnD * 2)) / (pnK - 1);
        Bitmap bitmap = (Bitmap) pnB.get();
        for (int i5 = 0; i5 < pnK; i5++) {
            b bVar = new b();
            bVar.left = (this.pnD + (this.icA * i5)) - (bitmap.getWidth() / 2);
            bVar.top = this.nUG - (bitmap.getHeight() / 2);
            bVar.right = (this.pnD + (this.icA * i5)) + (bitmap.getWidth() / 2);
            bVar.bottom = this.nUG + (bitmap.getHeight() / 2);
            this.pnC.add(bVar);
        }
        this.pnE = this.pnI;
        if (this.pnH >= 0) {
            this.pnF = ((b) this.pnC.get(this.pnE)).left;
        } else if (this.pnF <= ((b) this.pnC.get(this.pnE)).right - (this.icA / 2)) {
            this.pnF = ((b) this.pnC.get(this.pnE)).left;
        } else {
            this.pnF = ((b) this.pnC.get(this.pnE)).right;
        }
        this.pnG = ((b) this.pnC.get(this.pnE)).top;
        invalidate();
    }

    public static void baB() {
        pnK = 8;
    }

    private void baC() {
        if (pnB == null || pnB.get() == null) {
            pnB = new SoftReference(BitmapFactory.decodeResource(getResources(), R.g.bff));
        }
    }

    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        baC();
        Paint paint = new Paint();
        paint.setARGB(255, com.tencent.mm.plugin.appbrand.jsapi.contact.b.CTRL_INDEX, com.tencent.mm.plugin.appbrand.jsapi.contact.b.CTRL_INDEX, com.tencent.mm.plugin.appbrand.jsapi.contact.b.CTRL_INDEX);
        paint.setStrokeWidth(2.0f);
        int width = getWidth();
        int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(getContext(), 5);
        canvas.drawLine((float) this.pnD, (float) this.nUG, (float) (width - this.pnD), (float) this.nUG, paint);
        for (i = 0; i < pnK; i++) {
            canvas.drawLine((float) (this.pnD + (this.icA * i)), (float) (this.nUG - fromDPToPix), (float) (this.pnD + (this.icA * i)), (float) (this.nUG + fromDPToPix), paint);
        }
        Bitmap bitmap = (Bitmap) pnB.get();
        canvas.drawBitmap(bitmap, (float) this.pnF, (float) this.pnG, null);
        String str = "A";
        String string = getResources().getString(R.l.eRx);
        getResources().getString(R.l.eRw);
        getResources().getString(R.l.eRz);
        String str2 = "A";
        float ah = ah(SetTextSizeUI.af(0.875f));
        paint = new Paint();
        paint.setTextSize(ah);
        i = (int) paint.measureText(str);
        int ai = ai(ah);
        paint.setColor(getResources().getColor(R.e.black));
        paint.setAntiAlias(true);
        canvas.drawText(str, (float) (this.pnD - (i / 2)), (float) ((this.nUG - ai) - (bitmap.getHeight() / 3)), paint);
        float ah2 = ah(SetTextSizeUI.af(1.0f));
        paint.setTextSize(ah2);
        canvas.drawText(string, (float) ((this.pnD + (this.icA * 1)) - (((int) paint.measureText(string)) / 2)), (float) ((this.nUG - ai(ah2)) - (bitmap.getHeight() / 3)), paint);
        ah2 = ah(SetTextSizeUI.af(2.025f));
        paint.setTextSize(ah2);
        canvas.drawText(str2, (float) ((this.pnD + (this.icA * (pnK - 1))) - (((int) paint.measureText(str2)) / 2)), (float) ((this.nUG - ai(ah2)) - (bitmap.getHeight() / 3)), paint);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        b bVar;
        b bVar2;
        float y;
        int i;
        switch (motionEvent.getAction()) {
            case 0:
                this.mxi = motionEvent.getX();
                this.jWC = motionEvent.getY();
                bVar = (b) this.pnC.get(this.pnE);
                if (this.mxi >= ((float) bVar.left) && this.mxi <= ((float) bVar.right) && this.jWC >= ((float) bVar.top) && this.jWC <= ((float) bVar.bottom)) {
                    z = true;
                }
                if (!z) {
                    this.pnM = true;
                    break;
                }
                this.pnL = true;
                return true;
            case 1:
                if (this.pnL) {
                    int i2 = 0;
                    while (i2 < pnK - 1) {
                        bVar = (b) this.pnC.get(i2);
                        bVar2 = (b) this.pnC.get(i2 + 1);
                        if (this.pnF <= bVar.left + (this.icA / 2) && this.pnF >= bVar.left) {
                            this.pnE = i2;
                            this.pnF = bVar.left;
                            this.pnI = this.pnE;
                            if (this.pnJ != null) {
                                this.pnJ.sq(this.pnE);
                            }
                            invalidate();
                            this.pnL = false;
                            return true;
                        } else if (this.pnF < bVar2.left - (this.icA / 2) || this.pnF > bVar2.left) {
                            i2++;
                        } else {
                            this.pnE = i2 + 1;
                            this.pnF = bVar2.left;
                            this.pnI = this.pnE;
                            if (this.pnJ != null) {
                                this.pnJ.sq(this.pnE);
                            }
                            invalidate();
                            this.pnL = false;
                            return true;
                        }
                    }
                    this.pnI = this.pnE;
                    if (this.pnJ != null) {
                        this.pnJ.sq(this.pnE);
                    }
                    invalidate();
                    this.pnL = false;
                    return true;
                } else if (this.pnM) {
                    float x = motionEvent.getX();
                    y = motionEvent.getY();
                    if (Math.abs(x - this.mxi) <= 10.0f && Math.abs(y - this.jWC) <= 10.0f) {
                        i = 0;
                        while (i < pnK) {
                            bVar = (b) this.pnC.get(i);
                            if (x < ((float) (bVar.left - 5)) || x > ((float) (bVar.right + 5))) {
                                i++;
                            } else {
                                this.pnE = i;
                                this.pnI = this.pnE;
                                this.pnF = bVar.left;
                                if (this.pnJ != null) {
                                    this.pnJ.sq(this.pnE);
                                }
                            }
                        }
                    }
                    this.pnM = false;
                    invalidate();
                    return true;
                }
                break;
            case 2:
                if (!this.pnL) {
                    return super.onTouchEvent(motionEvent);
                }
                y = motionEvent.getX();
                float y2 = motionEvent.getY();
                this.pnH = (int) (y - this.mxi);
                this.pnF += this.pnH;
                this.mxi = y;
                this.jWC = y2;
                bVar = (b) this.pnC.get(0);
                bVar2 = (b) this.pnC.get(pnK - 1);
                if (this.pnF <= bVar.left) {
                    this.pnF = bVar.left;
                } else if (this.pnF >= bVar2.left) {
                    this.pnF = bVar2.left;
                } else {
                    i = 0;
                    while (i < pnK) {
                        bVar = (b) this.pnC.get(i);
                        if (this.pnF < bVar.left - 5 || this.pnF > bVar.right + 5) {
                            i++;
                        } else {
                            this.pnE = i;
                            this.pnI = this.pnE;
                            if (this.pnJ != null) {
                                this.pnJ.sq(this.pnE);
                            }
                        }
                    }
                }
                invalidate();
                return true;
            default:
                return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    private float ah(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    private static int ai(float f) {
        Paint paint = new Paint();
        paint.setTextSize(f);
        paint.setAntiAlias(true);
        return (int) Math.ceil((double) paint.getFontMetrics().bottom);
    }
}
