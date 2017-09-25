package com.tencent.mm.plugin.mmsight.segment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.mmsight.segment.l.e;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public final class n extends View {
    a nIc;
    private boolean nId;
    boolean nIe;
    private int nIf;
    private int nIg;
    private Drawable nIh;
    private Drawable nIi;
    private int nIj;
    private float nIk;
    private int nIl;
    private float nIm;
    private int nIn;
    private Paint nIo;
    private Paint nIp;
    private int nIq;
    private float nIr;
    private Paint nIs;
    private Paint nIt;
    private int nIu;
    private float nIv;
    private float nIw;
    private float nIx;
    private int nIy;
    private OnTouchListener nIz;
    private int padding;

    public interface a {
        void aLQ();

        void aLR();

        void fI(boolean z);
    }

    private class b extends Drawable {
        final /* synthetic */ n nID;
        boolean nII = false;
        private Drawable nIJ;
        private Drawable nIK;

        public b(n nVar, Drawable drawable, Drawable drawable2) {
            this.nID = nVar;
            this.nIJ = drawable;
            this.nIK = drawable2;
            this.nII = false;
        }

        public final void draw(Canvas canvas) {
            Drawable drawable;
            if (this.nII) {
                drawable = this.nIJ;
            } else {
                drawable = this.nIK;
            }
            if (!getBounds().equals(drawable.getBounds())) {
                drawable.setBounds(getBounds());
            }
            drawable.draw(canvas);
        }

        public final void setAlpha(int i) {
            this.nIJ.setAlpha(i);
            this.nIK.setAlpha(i);
        }

        public final void setColorFilter(ColorFilter colorFilter) {
            this.nIJ.setColorFilter(colorFilter);
            this.nIK.setColorFilter(colorFilter);
        }

        public final int getOpacity() {
            return -3;
        }
    }

    static /* synthetic */ void a(n nVar, boolean z, float f) {
        if (nVar.nId && nVar.nIh != null && nVar.nIi != null && nVar.nIh.getBounds().width() > 0 && nVar.nIi.getBounds().width() > 0) {
            float f2;
            float max;
            if (z) {
                f2 = nVar.nIk + ((float) (nVar.nIi.getBounds().right - nVar.nIg));
                max = Math.max(((float) nVar.padding) + nVar.nIk, ((float) (nVar.nIi.getBounds().right - nVar.nIf)) + nVar.nIk);
            } else {
                max = ((float) (nVar.nIh.getBounds().left + nVar.nIg)) - nVar.nIk;
                f2 = Math.min(((float) (nVar.getWidth() - nVar.padding)) - nVar.nIk, ((float) (nVar.nIh.getBounds().left + nVar.nIf)) - nVar.nIk);
            }
            max = Math.max(max, Math.min(f, f2));
            Rect bounds;
            if (z) {
                bounds = nVar.nIh.getBounds();
                bounds.offsetTo((int) Math.ceil((double) (max - nVar.nIk)), 0);
                nVar.nIh.setBounds(bounds);
            } else {
                bounds = nVar.nIi.getBounds();
                bounds.offsetTo((int) Math.floor((double) (max - nVar.nIk)), 0);
                nVar.nIi.setBounds(bounds);
            }
            nVar.postInvalidate();
        }
    }

    static /* synthetic */ void a(n nVar, boolean z, boolean z2) {
        if (nVar.nId && nVar.nIh != null && nVar.nIi != null && nVar.nIh.getBounds().width() > 0 && nVar.nIi.getBounds().width() > 0) {
            b bVar = z ? (b) nVar.nIh : (b) nVar.nIi;
            if (bVar.nII != z2) {
                bVar.nII = z2;
                bVar.nID.invalidate();
            }
            nVar.postInvalidate();
        }
    }

    static /* synthetic */ boolean a(n nVar, Drawable drawable, float f, float f2) {
        if (!nVar.nId || drawable == null) {
            return false;
        }
        Rect bounds = drawable.getBounds();
        return f2 <= ((float) (bounds.bottom + nVar.nIy)) && f2 >= ((float) (bounds.top - nVar.nIy)) && f >= ((float) (bounds.left - nVar.nIy)) && f <= ((float) (bounds.right + nVar.nIy));
    }

    public n(Context context) {
        super(context);
        this.nId = false;
        this.nIe = false;
        this.nIm = -1.0f;
        this.nIw = -1.0f;
        this.nIx = -1.0f;
        this.padding = 0;
        this.nIz = new OnTouchListener(this) {
            float jXG;
            float jzV;
            final /* synthetic */ n nID;
            int nIE = -1;
            int nIF = -1;
            int nIG;
            int nIH;

            {
                this.nID = r2;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (!this.nID.nId) {
                    return false;
                }
                switch (motionEvent.getActionMasked()) {
                    case 0:
                    case 5:
                        this.nIH = motionEvent.getActionIndex();
                        this.nIG = motionEvent.getPointerId(this.nIH);
                        this.jXG = motionEvent.getX(this.nIH);
                        this.jzV = motionEvent.getY(this.nIH);
                        if (n.a(this.nID, this.nID.nIh, this.jXG, this.jzV)) {
                            if (this.nID.fJ(true)) {
                                return false;
                            }
                            if (this.nID.nIc != null) {
                                this.nID.nIc.aLQ();
                            }
                            this.nIE = this.nIG;
                            this.nID.nIw = (float) this.nID.nIh.getBounds().left;
                            n.a(this.nID, true, true);
                            return true;
                        } else if (!n.a(this.nID, this.nID.nIi, this.jXG, this.jzV) || this.nID.fJ(false)) {
                            return false;
                        } else {
                            if (this.nID.nIc != null) {
                                this.nID.nIc.aLQ();
                            }
                            this.nIF = this.nIG;
                            this.nID.nIx = (float) this.nID.nIi.getBounds().right;
                            n.a(this.nID, false, true);
                            return true;
                        }
                    case 1:
                    case 3:
                    case 6:
                        this.nIG = motionEvent.getPointerId(motionEvent.getActionIndex());
                        if (this.nIG != this.nIE && this.nIG != this.nIF) {
                            return false;
                        }
                        if (this.nID.nIc != null) {
                            this.nID.nIc.aLR();
                        }
                        n.a(this.nID, this.nIG == this.nIE, false);
                        if (this.nIG == this.nIE) {
                            this.nIE = -1;
                        } else {
                            this.nIF = -1;
                        }
                        return true;
                    case 2:
                        if (!this.nID.fJ(true) && !this.nID.fJ(false)) {
                            return false;
                        }
                        if (this.nID.nIe) {
                            return true;
                        }
                        this.nIH = 0;
                        boolean z = false;
                        while (this.nIH < motionEvent.getPointerCount()) {
                            this.nIG = motionEvent.getPointerId(this.nIH);
                            if (this.nIG == this.nIE || this.nIG == this.nIF) {
                                n nVar = this.nID;
                                if (this.nIG == this.nIE) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                n.a(nVar, z, motionEvent.getX(this.nIH));
                                if (this.nID.nIc != null) {
                                    a h = this.nID.nIc;
                                    if (this.nIG == this.nIE) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    h.fI(z);
                                }
                                z = true;
                            }
                            this.nIH++;
                        }
                        return z;
                    default:
                        return false;
                }
            }
        };
        this.nIj = com.tencent.mm.bg.a.fromDPToPix(getContext(), 8);
        this.nIk = ((float) this.nIj) * 0.5f;
        this.nIy = com.tencent.mm.bg.a.fromDPToPix(getContext(), 8);
        this.nIh = new b(this, com.tencent.mm.bg.a.a(getContext(), e.nHt), com.tencent.mm.bg.a.a(getContext(), e.nHs));
        this.nIi = new b(this, com.tencent.mm.bg.a.a(getContext(), e.nHt), com.tencent.mm.bg.a.a(getContext(), e.nHs));
        this.nIl = com.tencent.mm.bg.a.fromDPToPix(getContext(), 1);
        this.nIn = com.tencent.mm.bg.a.T(getContext(), com.tencent.mm.plugin.mmsight.segment.l.b.nHo);
        this.nIm = -1.0f;
        this.nIo = new Paint();
        this.nIo.setColor(com.tencent.mm.bg.a.b(getContext(), com.tencent.mm.plugin.mmsight.segment.l.a.white));
        this.nIo.setAlpha(102);
        this.nIs = new Paint();
        this.nIs.setColor(com.tencent.mm.bg.a.b(getContext(), com.tencent.mm.plugin.mmsight.segment.l.a.black));
        this.nIs.setAlpha(102);
        this.nIp = new Paint();
        this.nIp.setColor(com.tencent.mm.bg.a.b(getContext(), com.tencent.mm.plugin.mmsight.segment.l.a.white));
        this.nIp.setStyle(Style.STROKE);
        this.nIq = cA(getContext());
        this.nIp.setStrokeWidth((float) this.nIq);
        this.nIr = ((float) this.nIq) * 0.5f;
        this.nIt = new Paint();
        this.nIt.setColor(com.tencent.mm.bg.a.b(getContext(), com.tencent.mm.plugin.mmsight.segment.l.a.white));
        this.nIt.setStyle(Style.STROKE);
        this.nIu = cA(getContext());
        this.nIv = ((float) this.nIu) * 0.5f;
        this.nIt.setStrokeWidth((float) this.nIu);
        this.nIt.setAlpha(178);
        setOnTouchListener(this.nIz);
    }

    private static int cA(Context context) {
        return Math.round(TypedValue.applyDimension(1, DownloadHelper.SAVE_FATOR, context.getResources().getDisplayMetrics()));
    }

    protected final void onDraw(Canvas canvas) {
        if (this.nIm > 0.0f) {
            float width = ((float) getWidth()) * this.nIm;
            canvas.drawRect(width - (((float) this.nIl) * 0.5f), 0.0f, (((float) this.nIl) * 0.5f) + width, (float) this.nIn, this.nIo);
        }
        if (this.nId) {
            int centerX = this.nIh.getBounds().centerX();
            int centerX2 = this.nIi.getBounds().centerX();
            if (fJ(true) || fJ(false)) {
                canvas.drawRect(((float) this.padding) + this.nIv, this.nIv, ((float) (getWidth() - this.padding)) - this.nIv, ((float) getBottom()) - this.nIv, this.nIt);
            }
            if (this.nIh.getBounds().left > 0) {
                canvas.drawRect(0.0f, 0.0f, (float) centerX, (float) getHeight(), this.nIs);
            }
            if (this.nIi.getBounds().right < getWidth()) {
                canvas.drawRect((float) centerX2, 0.0f, (float) getWidth(), (float) getHeight(), this.nIs);
            }
            canvas.drawLine((float) centerX, this.nIr, (float) centerX2, this.nIr, this.nIp);
            canvas.drawLine((float) centerX, ((float) getHeight()) - this.nIr, (float) centerX2, ((float) getHeight()) - this.nIr, this.nIp);
            this.nIh.draw(canvas);
            this.nIi.draw(canvas);
        }
    }

    public final void Z(float f) {
        if (this.nId) {
            this.nIm = f;
            invalidate();
        }
    }

    public final void G(final int i, final int i2, final int i3) {
        post(new Runnable(this) {
            final /* synthetic */ n nID;

            public final void run() {
                if (i <= this.nID.nIj * 2) {
                    throw new IllegalStateException("MaxExtent can not less than sliderWidth * 2");
                }
                this.nID.nId = true;
                this.nID.padding = i3;
                this.nID.nIf = Math.min(i, this.nID.getWidth() - (i3 * 2));
                this.nID.nIg = Math.max(i2, this.nID.nIj * 2);
                this.nID.nIh.setBounds(i3, 0, i3 + this.nID.nIj, this.nID.getHeight());
                this.nID.nIi.setBounds((i3 + this.nID.nIf) - this.nID.nIj, 0, this.nID.nIf + i3, this.nID.getHeight());
                this.nID.invalidate();
            }
        });
    }

    private boolean fJ(boolean z) {
        if (z) {
            return ((b) this.nIh).nII;
        }
        return ((b) this.nIi).nII;
    }

    public final int aLS() {
        return this.nIh.getBounds().left;
    }

    public final int aLT() {
        return this.nIi.getBounds().right;
    }
}
