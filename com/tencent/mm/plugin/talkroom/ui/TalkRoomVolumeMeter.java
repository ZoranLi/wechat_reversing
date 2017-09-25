package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.sdk.WebView;

public class TalkRoomVolumeMeter extends FrameLayout {
    a qZL;
    private ImageView qZM;
    private ImageView qZN;
    private ImageView qZO;
    private FrameLayout qZP;

    private class a extends SurfaceView implements Callback {
        Paint jXK;
        int max = 100;
        float qZQ = 0.0f;
        float qZR = 0.0f;
        SurfaceHolder qZS = getHolder();
        Bitmap qZT;
        Bitmap qZU;
        private Bitmap qZV;
        Rect qZW;
        int qZX;
        int qZY;
        aj qZZ;
        private boolean raa = false;
        private float rab = this.qZR;
        float rac = this.qZR;
        PaintFlagsDrawFilter rad;
        boolean rae = false;
        private float[] raf;
        final /* synthetic */ TalkRoomVolumeMeter rag;
        boolean started = false;
        int value = 0;

        static /* synthetic */ void a(a aVar) {
            if (aVar.rac >= aVar.qZQ && aVar.rac <= aVar.qZR && aVar.qZU != null && aVar.qZT != null) {
                Canvas lockCanvas = aVar.qZS.lockCanvas();
                if (lockCanvas != null && aVar.qZW != null) {
                    lockCanvas.setDrawFilter(aVar.rad);
                    float f = aVar.rac;
                    if (aVar.raf == null) {
                        aVar.raf = new float[]{aVar.qZR, aVar.qZR, aVar.qZR, aVar.qZR, aVar.qZR};
                    }
                    int i = 0;
                    while (i < aVar.raf.length - 1) {
                        aVar.raf[i] = aVar.raf[i + 1];
                        i++;
                    }
                    aVar.raf[i] = f;
                    aVar.rab = ((((aVar.raf[0] + (aVar.raf[1] * 4.0f)) + (aVar.raf[2] * 6.0f)) + (aVar.raf[3] * 4.0f)) + (aVar.raf[4] * 1.0f)) / 16.0f;
                    aVar.qZW.set(0, (int) aVar.rab, aVar.qZY, ((int) aVar.rab) + aVar.qZX);
                    lockCanvas.drawBitmap(aVar.rae ? aVar.qZU : aVar.qZT, null, aVar.qZW, aVar.jXK);
                    aVar.qZS.unlockCanvasAndPost(lockCanvas);
                }
            }
        }

        public a(TalkRoomVolumeMeter talkRoomVolumeMeter, Context context) {
            this.rag = talkRoomVolumeMeter;
            super(context);
            this.qZS.addCallback(this);
            this.jXK = new Paint();
            this.jXK.setAntiAlias(true);
            this.rad = new PaintFlagsDrawFilter(0, 3);
            this.qZZ = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
                final /* synthetic */ a rah;

                {
                    this.rah = r1;
                }

                public final boolean oQ() {
                    a.a(this.rah);
                    return this.rah.raa;
                }
            }, true);
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            w.v("MicroMsg.TalkRoomVoiceMeter", "surfaceCreated");
            this.qZT = BitmapFactory.decodeResource(getResources(), R.g.bkE);
            this.qZV = BitmapFactory.decodeResource(getResources(), R.g.bkD);
            this.qZU = BitmapFactory.decodeResource(getResources(), R.g.bkF);
        }

        private int bog() {
            return this.qZT == null ? 190 : this.qZT.getHeight();
        }

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            w.v("MicroMsg.TalkRoomVoiceMeter", "surfaceChanged, width = " + i2 + " height = " + i3);
            this.qZR = 0.0f;
            this.qZQ = (float) (i3 - bog());
            this.rab = this.qZR;
            this.rac = this.qZR;
            this.qZY = i2;
            this.qZX = bog();
            this.qZW = new Rect(0, (int) this.rab, this.qZY, ((int) this.rab) + this.qZX);
            this.raa = true;
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            w.v("MicroMsg.TalkRoomVoiceMeter", "surfaceDestroyed");
            this.raa = false;
            this.qZZ.KH();
            if (this.qZT != null) {
                this.qZT.recycle();
                this.qZT = null;
            }
            if (this.qZV != null) {
                this.qZV.recycle();
                this.qZV = null;
            }
            if (this.qZU != null) {
                this.qZU.recycle();
                this.qZU = null;
            }
        }
    }

    public TalkRoomVolumeMeter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        KC();
    }

    public TalkRoomVolumeMeter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        KC();
    }

    private void KC() {
        this.qZL = new a(this, getContext());
        this.qZM = new ImageView(getContext());
        this.qZM.setScaleType(ScaleType.FIT_XY);
        this.qZM.setImageResource(R.g.bkH);
        this.qZM.setVisibility(0);
        this.qZN = new ImageView(getContext());
        this.qZN.setScaleType(ScaleType.FIT_CENTER);
        this.qZN.setImageResource(R.g.bkG);
        this.qZN.setVisibility(8);
        this.qZO = new ImageView(getContext());
        this.qZO.setScaleType(ScaleType.FIT_CENTER);
        this.qZO.setImageResource(R.g.bkD);
        this.qZO.setVisibility(8);
        this.qZP = new FrameLayout(getContext());
        this.qZP.addView(this.qZL);
        this.qZP.addView(this.qZN);
        this.qZP.setVisibility(8);
        addView(this.qZP);
        addView(this.qZO);
        addView(this.qZM);
        setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        bringChildToFront(this.qZM);
    }

    public final void hX(boolean z) {
        this.qZP.setVisibility(z ? 0 : 8);
        if (z) {
            a aVar = this.qZL;
            if (!aVar.started) {
                aVar.started = true;
                aVar.qZZ.v(100, 100);
                return;
            }
            return;
        }
        a aVar2 = this.qZL;
        if (aVar2.started) {
            aVar2.started = false;
            if (aVar2.rac >= aVar2.qZQ && aVar2.rac <= aVar2.qZR && aVar2.qZU != null && aVar2.qZT != null) {
                Canvas lockCanvas = aVar2.qZS.lockCanvas();
                if (!(lockCanvas == null || aVar2.qZW == null)) {
                    lockCanvas.setDrawFilter(aVar2.rad);
                    aVar2.qZW.set(0, 0, aVar2.qZY, aVar2.qZX + 0);
                    lockCanvas.drawBitmap(aVar2.rae ? aVar2.qZU : aVar2.qZT, null, aVar2.qZW, aVar2.jXK);
                    aVar2.qZS.unlockCanvasAndPost(lockCanvas);
                }
            }
            aVar2.qZZ.KH();
        }
    }
}
