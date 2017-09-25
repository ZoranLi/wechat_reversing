package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.f;
import java.util.Timer;
import java.util.TimerTask;

public class CropImageView extends ImageView {
    int fNB = 0;
    private float jWC;
    private Timer lPE = new Timer(true);
    float mAP = 0.0f;
    float mAQ = 0.0f;
    Bitmap mhk;
    private float mxi;
    private OnTouchListener nIz = new OnTouchListener(this) {
        final /* synthetic */ CropImageView wlO;

        {
            this.wlO = r1;
        }

        public final boolean onTouch(View view, final MotionEvent motionEvent) {
            if (!this.wlO.wlN || this.wlO.mhk == null) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            w.d("MicroMsg.CropImageView", "on touch : event type=" + action + ", isDownOnImg=" + this.wlO.wlw);
            if (!this.wlO.wlw && action != 0) {
                return false;
            }
            switch (action) {
                case 0:
                    w.d("MicroMsg.CropImageView", "action_down");
                    this.wlO.mxi = motionEvent.getRawX();
                    this.wlO.jWC = motionEvent.getRawY();
                    w.d("MicroMsg.CropImageView", "lastX=" + this.wlO.mxi + ",lastY=" + this.wlO.jWC);
                    this.wlO.wls = this.wlO.mxi;
                    this.wlO.wlt = this.wlO.jWC;
                    Matrix imageMatrix = this.wlO.getImageMatrix();
                    RectF rectF = new RectF();
                    rectF.set(0.0f, 0.0f, (float) this.wlO.mhk.getWidth(), (float) this.wlO.mhk.getHeight());
                    imageMatrix.mapRect(rectF);
                    this.wlO.wlw = rectF.contains(this.wlO.mxi, this.wlO.jWC);
                    this.wlO.nfA = System.currentTimeMillis();
                    return false;
                case 1:
                    w.d("MicroMsg.CropImageView", "action_up");
                    if (this.wlO.qBW) {
                        this.wlO.qBW = false;
                        if (this.wlO.wlH) {
                            this.wlO.wlH = false;
                            this.wlO.bZF();
                            this.wlO.bZF();
                            this.wlO.bZF();
                            this.wlO.bZF();
                            this.wlO.bZF();
                            return false;
                        }
                        this.wlO.wlH = true;
                        this.wlO.bZE();
                        this.wlO.bZE();
                        this.wlO.bZE();
                        this.wlO.bZE();
                        this.wlO.bZE();
                        return false;
                    }
                    this.wlO.qBW = true;
                    this.wlO.wlI = new Timer();
                    this.wlO.wlI.schedule(new TimerTask(this) {
                        final /* synthetic */ AnonymousClass3 wlQ;

                        public final void run() {
                            if (this.wlQ.wlO.qBW) {
                                Message message = new Message();
                                message.what = 4661;
                                message.obj = motionEvent;
                                this.wlQ.wlO.wlJ.sendMessage(message);
                                this.wlQ.wlO.qBW = false;
                            }
                        }
                    }, 200);
                    return false;
                case 2:
                    float f;
                    w.d("MicroMsg.CropImageView", "action_move");
                    if (this.wlO.wlv) {
                        w.d("MicroMsg.CropImageView", "is valid mult down");
                        this.wlO.mAQ = f.E(motionEvent);
                        f = this.wlO.mAQ - this.wlO.mAP;
                        if (this.wlO.mAQ > 5.0f && Math.abs(f) > 5.0f) {
                            f.a(this.wlO.wlu, motionEvent);
                            w.d("MicroMsg.CropImageView", "mX=" + this.wlO.wlu.x + ",mY=" + this.wlO.wlu.y);
                            if (f > 0.0f) {
                                w.d("MicroMsg.CropImageView", "zoom in");
                                this.wlO.bZE();
                            } else {
                                w.d("MicroMsg.CropImageView", "zoom out");
                                this.wlO.bZF();
                            }
                        }
                        this.wlO.mAP = this.wlO.mAQ;
                    }
                    if (!this.wlO.wlr) {
                        f = motionEvent.getRawX() - this.wlO.mxi;
                        float rawY = motionEvent.getRawY() - this.wlO.jWC;
                        if (Math.abs(f) > 5.0f || Math.abs(rawY) > 5.0f) {
                            this.wlO.getImageMatrix().postTranslate(f, rawY);
                        }
                        this.wlO.invalidate();
                    }
                    this.wlO.wlr = false;
                    this.wlO.mxi = motionEvent.getRawX();
                    this.wlO.jWC = motionEvent.getRawY();
                    return false;
                case 5:
                    w.d("MicroMsg.CropImageView", "action_mult_down");
                    this.wlO.wlr = true;
                    this.wlO.mAP = f.E(motionEvent);
                    if (this.wlO.mAP <= 5.0f) {
                        return false;
                    }
                    this.wlO.wlv = true;
                    f.a(this.wlO.wlu, motionEvent);
                    return true;
                case 6:
                    w.d("MicroMsg.CropImageView", "action_mult_up");
                    this.wlO.wlv = false;
                    this.wlO.wlr = true;
                    return true;
                default:
                    return false;
            }
        }
    };
    private long nfA;
    private boolean qBW = false;
    boolean vos = false;
    Drawable vot;
    private boolean wlA = false;
    private boolean wlB = false;
    private boolean wlC = false;
    private float wlD = 1.0f;
    private float wlE = 0.0f;
    private float wlF = 0.0f;
    private c wlG = null;
    private boolean wlH = false;
    private Timer wlI;
    private ae wlJ = new ae(this) {
        final /* synthetic */ CropImageView wlO;

        {
            this.wlO = r1;
        }

        public final void handleMessage(Message message) {
            w.d("MicroMsg.CropImageView", "on handler");
            if (message.what == 4659) {
                this.wlO.bZE();
            } else if (message.what == 4658) {
                this.wlO.bZF();
            } else if (message.what == 4660) {
                if (!(this.wlO.lPE == null || this.wlO.wlG == null)) {
                    this.wlO.wlG.cancel();
                    this.wlO.wlG = null;
                }
            } else if (message.what == 4661) {
                boolean z;
                MotionEvent motionEvent = (MotionEvent) message.obj;
                this.wlO.nfA = System.currentTimeMillis();
                this.wlO.wlw = false;
                if (motionEvent.getRawX() - this.wlO.wls > 10.0f || motionEvent.getRawY() - this.wlO.wlt > 10.0f || motionEvent.getRawX() - this.wlO.wls < -10.0f || motionEvent.getRawY() - this.wlO.wlt < -10.0f) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (this.wlO.nfA != 0 && currentTimeMillis - this.wlO.nfA < 300 && currentTimeMillis - this.wlO.nfA >= 0 && this.wlO.wlM != null) {
                        this.wlO.wlM.bZC();
                    }
                    this.wlO.nfA = 0;
                }
                f.a(this.wlO.wlu, this.wlO.mhk);
            }
            super.handleMessage(message);
        }
    };
    private b wlK = null;
    private ae wlL = new ae(this) {
        final /* synthetic */ CropImageView wlO;

        {
            this.wlO = r1;
        }

        public final void handleMessage(Message message) {
            if (message.what != 4653) {
                CropImageView.o(this.wlO);
            } else if (!(this.wlO.lPE == null || this.wlO.wlK == null)) {
                this.wlO.wlK.cancel();
                this.wlO.wlK = null;
            }
            super.handleMessage(message);
        }
    };
    a wlM;
    boolean wlN = true;
    boolean wlq = true;
    private boolean wlr = false;
    private float wls;
    private float wlt;
    private PointF wlu = new PointF();
    boolean wlv = false;
    private boolean wlw = false;
    private boolean wlx = false;
    private boolean wly = false;
    private boolean wlz = false;

    public interface a {
        void bZC();
    }

    private class b extends TimerTask {
        final /* synthetic */ CropImageView wlO;

        public final void run() {
            Message message = new Message();
            if (this.wlO.wlB || this.wlO.wlC || this.wlO.wlA || this.wlO.wlz) {
                message.what = 4654;
            } else {
                message.what = 4653;
            }
            this.wlO.wlL.sendMessage(message);
        }
    }

    private class c extends TimerTask {
        final /* synthetic */ CropImageView wlO;

        public final void run() {
            w.d("MicroMsg.CropImageView", "in timer task run");
            Message message = new Message();
            if (this.wlO.wly) {
                message.what = 4659;
            } else if (this.wlO.wlx) {
                message.what = 4658;
            } else {
                message.what = 4660;
            }
            this.wlO.wlJ.sendMessage(message);
        }
    }

    static /* synthetic */ void o(CropImageView cropImageView) {
        if (cropImageView.wlz) {
            cropImageView.wlE -= -20.0f;
            if (cropImageView.wlE > 0.0f) {
                cropImageView.wlz = false;
            }
            cropImageView.getImageMatrix().postTranslate(-20.0f, 0.0f);
        }
        if (cropImageView.wlA) {
            cropImageView.wlE -= 20.0f;
            if (cropImageView.wlE < 0.0f) {
                cropImageView.wlA = false;
            }
            cropImageView.getImageMatrix().postTranslate(20.0f, 0.0f);
        }
        if (cropImageView.wlB) {
            cropImageView.wlF -= 20.0f;
            if (cropImageView.wlF < 0.0f) {
                cropImageView.wlB = false;
            }
            cropImageView.getImageMatrix().postTranslate(0.0f, 20.0f);
        }
        if (cropImageView.wlC) {
            cropImageView.wlF -= -20.0f;
            if (cropImageView.wlF > 0.0f) {
                cropImageView.wlC = false;
            }
            cropImageView.getImageMatrix().postTranslate(0.0f, -20.0f);
        }
        cropImageView.setImageBitmap(cropImageView.mhk);
        cropImageView.invalidate();
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bZD();
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.vos = false;
        this.mhk = bitmap;
        f.a(this.wlu, bitmap);
        super.setImageBitmap(bitmap);
    }

    public final void bZD() {
        setOnTouchListener(this.nIz);
    }

    public final void bZE() {
        this.wlD *= 1.0666f;
        if (1.0f <= this.wlD) {
            this.wly = false;
        }
        if (1.6f < this.wlD) {
            this.wlx = true;
        } else {
            this.wlx = false;
        }
        if (!this.wlq || 4.0f >= this.wlD) {
            float[] fArr = new float[2];
            r1 = new float[2];
            float f = this.wlu.x;
            r1[0] = f;
            fArr[0] = f;
            f = this.wlu.y;
            r1[1] = f;
            fArr[1] = f;
            getImageMatrix().mapPoints(fArr);
            getImageMatrix().postScale(1.0666f, 1.0666f);
            getImageMatrix().mapPoints(r1);
            getImageMatrix().postTranslate((fArr[0] - r1[0]) / 2.0f, (fArr[1] - r1[1]) / 2.0f);
            setImageBitmap(this.mhk);
            invalidate();
            return;
        }
        this.wlD = 4.0f;
    }

    public final void bZF() {
        this.wlD *= 0.9375f;
        if (1.6f > this.wlD) {
            this.wlx = false;
        }
        if (1.0f > this.wlD) {
            this.wly = true;
        } else {
            this.wly = false;
        }
        if (0.4f > this.wlD) {
            this.wlD = 0.4f;
            return;
        }
        float[] fArr = new float[2];
        r1 = new float[2];
        float f = this.wlu.x;
        r1[0] = f;
        fArr[0] = f;
        f = this.wlu.y;
        r1[1] = f;
        fArr[1] = f;
        getImageMatrix().mapPoints(fArr);
        getImageMatrix().postScale(0.9375f, 0.9375f);
        getImageMatrix().mapPoints(r1);
        getImageMatrix().postTranslate((fArr[0] - r1[0]) / 2.0f, (fArr[1] - r1[1]) / 2.0f);
        setImageBitmap(this.mhk);
        invalidate();
    }

    public final int bZG() {
        if (!this.vos || this.vot == null) {
            return getWidth();
        }
        return this.vot.getIntrinsicWidth();
    }

    public final int bZH() {
        if (!this.vos || this.vot == null) {
            return getHeight();
        }
        return this.vot.getIntrinsicHeight();
    }
}
