package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.R;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class FontChooserView extends View {
    private static SoftReference<Bitmap> pnB = null;
    private int icA = 0;
    private float jWC = 0.0f;
    private float mxi = 0.0f;
    private int nUG = 0;
    private List<b> pnC = new ArrayList(4);
    private int pnD = 0;
    private int pnE = 0;
    private int pnF = 0;
    private int pnG = 0;
    public int pnI = 0;
    private boolean pnL = false;
    private boolean pnM = false;
    public a sne = null;
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

    public FontChooserView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FontChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @SuppressLint({"DrawAllocation"})
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        baC();
        this.pnC.clear();
        setClickable(true);
        this.pnD = com.tencent.mm.bg.a.fromDPToPix(getContext(), 50);
        this.topOffset = com.tencent.mm.bg.a.fromDPToPix(getContext(), 10);
        int width = getWidth();
        this.nUG = (getHeight() / 2) + this.topOffset;
        this.icA = (width - (this.pnD * 2)) / 3;
        Bitmap bitmap = (Bitmap) pnB.get();
        for (int i5 = 0; i5 < 4; i5++) {
            b bVar = new b();
            bVar.left = (this.pnD + (this.icA * i5)) - (bitmap.getWidth() / 2);
            bVar.top = this.nUG - (bitmap.getHeight() / 2);
            bVar.right = (this.pnD + (this.icA * i5)) + (bitmap.getWidth() / 2);
            bVar.bottom = this.nUG + (bitmap.getHeight() / 2);
            this.pnC.add(bVar);
        }
        this.pnE = this.pnI;
        this.pnF = ((b) this.pnC.get(this.pnE)).left;
        this.pnG = ((b) this.pnC.get(this.pnE)).top;
        invalidate();
    }

    private void baC() {
        if (pnB == null || pnB.get() == null) {
            pnB = new SoftReference(BitmapFactory.decodeResource(getResources(), R.g.bff));
        }
    }

    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        baC();
        Paint paint = new Paint();
        paint.setARGB(255, com.tencent.mm.plugin.appbrand.jsapi.contact.b.CTRL_INDEX, com.tencent.mm.plugin.appbrand.jsapi.contact.b.CTRL_INDEX, com.tencent.mm.plugin.appbrand.jsapi.contact.b.CTRL_INDEX);
        paint.setStrokeWidth(2.0f);
        int width = getWidth();
        int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(getContext(), 5);
        canvas.drawLine((float) this.pnD, (float) this.nUG, (float) (width - this.pnD), (float) this.nUG, paint);
        for (int i = 0; i < 4; i++) {
            canvas.drawLine((float) (this.pnD + (this.icA * i)), (float) (this.nUG - fromDPToPix), (float) (this.pnD + (this.icA * i)), (float) (this.nUG + fromDPToPix), paint);
        }
        Bitmap bitmap = (Bitmap) pnB.get();
        canvas.drawBitmap(bitmap, (float) this.pnF, (float) this.pnG, null);
        String string = getResources().getString(R.l.fmd);
        String string2 = getResources().getString(R.l.fme);
        String string3 = getResources().getString(R.l.fmb);
        String string4 = getResources().getString(R.l.fmc);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.aZV);
        Paint paint2 = new Paint();
        paint2.setTextSize((float) dimensionPixelSize);
        fromDPToPix = (int) paint2.measureText(string);
        dimensionPixelSize = wI(dimensionPixelSize);
        paint2.setColor(getResources().getColor(R.e.aWr));
        paint2.setAntiAlias(true);
        canvas.drawText(string, (float) (this.pnD - (fromDPToPix / 2)), (float) ((this.nUG - dimensionPixelSize) - (bitmap.getHeight() / 3)), paint2);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.f.aZW);
        paint2.setTextSize((float) dimensionPixelSize2);
        canvas.drawText(string2, (float) ((this.pnD + (this.icA * 1)) - (((int) paint2.measureText(string2)) / 2)), (float) ((this.nUG - wI(dimensionPixelSize2)) - (bitmap.getHeight() / 3)), paint2);
        dimensionPixelSize2 = getResources().getDimensionPixelSize(R.f.aZT);
        paint2.setTextSize((float) dimensionPixelSize2);
        canvas.drawText(string3, (float) ((this.pnD + (this.icA * 2)) - (((int) paint2.measureText(string3)) / 2)), (float) ((this.nUG - wI(dimensionPixelSize2)) - (bitmap.getHeight() / 3)), paint2);
        dimensionPixelSize2 = getResources().getDimensionPixelSize(R.f.aZU);
        paint2.setTextSize((float) dimensionPixelSize2);
        canvas.drawText(string4, (float) ((this.pnD + (this.icA * 3)) - (((int) paint2.measureText(string4)) / 2)), (float) ((this.nUG - wI(dimensionPixelSize2)) - (bitmap.getHeight() / 3)), paint2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        b bVar;
        b bVar2;
        float y;
        switch (motionEvent.getAction()) {
            case 0:
                this.mxi = motionEvent.getX();
                this.jWC = motionEvent.getY();
                bVar = (b) this.pnC.get(this.pnE);
                if (this.mxi >= ((float) bVar.left) && this.mxi <= ((float) bVar.right) && this.jWC >= ((float) bVar.top) && this.jWC <= ((float) bVar.bottom)) {
                    i = 1;
                }
                if (i == 0) {
                    this.pnM = true;
                    break;
                }
                this.pnL = true;
                return true;
            case 1:
                if (this.pnL) {
                    int i2 = 0;
                    while (i2 < 3) {
                        bVar = (b) this.pnC.get(i2);
                        bVar2 = (b) this.pnC.get(i2 + 1);
                        if (this.pnF <= bVar.left + (this.icA / 2) && this.pnF >= bVar.left) {
                            this.pnE = i2;
                            this.pnF = bVar.left;
                            this.pnI = this.pnE;
                            if (this.sne != null) {
                                this.sne.sq(this.pnE);
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
                            if (this.sne != null) {
                                this.sne.sq(this.pnE);
                            }
                            invalidate();
                            this.pnL = false;
                            return true;
                        }
                    }
                    this.pnI = this.pnE;
                    if (this.sne != null) {
                        this.sne.sq(this.pnE);
                    }
                    invalidate();
                    this.pnL = false;
                    return true;
                } else if (this.pnM) {
                    float x = motionEvent.getX();
                    y = motionEvent.getY();
                    if (Math.abs(x - this.mxi) <= 10.0f && Math.abs(y - this.jWC) <= 10.0f) {
                        int i3 = 0;
                        while (i3 < 4) {
                            bVar = (b) this.pnC.get(i3);
                            if (x < ((float) (bVar.left - 5)) || x > ((float) (bVar.right + 5))) {
                                i3++;
                            } else {
                                this.pnE = i3;
                                this.pnI = this.pnE;
                                this.pnF = bVar.left;
                                if (this.sne != null) {
                                    this.sne.sq(this.pnE);
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
                this.pnF += (int) (y - this.mxi);
                this.mxi = y;
                this.jWC = y2;
                bVar = (b) this.pnC.get(0);
                bVar2 = (b) this.pnC.get(3);
                if (this.pnF <= bVar.left) {
                    this.pnF = bVar.left;
                } else if (this.pnF >= bVar2.left) {
                    this.pnF = bVar2.left;
                } else {
                    while (i < 4) {
                        bVar = (b) this.pnC.get(i);
                        if (this.pnF < bVar.left - 5 || this.pnF > bVar.right + 5) {
                            i++;
                        } else {
                            this.pnE = i;
                            this.pnI = this.pnE;
                            if (this.sne != null) {
                                this.sne.sq(this.pnE);
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

    private static int wI(int i) {
        Paint paint = new Paint();
        paint.setTextSize((float) i);
        paint.setAntiAlias(true);
        return (int) Math.ceil((double) paint.getFontMetrics().bottom);
    }
}
