package com.tencent.mm.plugin.emoji.ui.smiley;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.w;

public class SmileyPanelScrollView extends View {
    private static boolean DEBUG = false;
    private int RQ;
    private int STATE_NONE = 0;
    private int aar;
    private int abF;
    private int abG;
    f kTj;
    private boolean kUA = false;
    int kUB = -1;
    int kUC = -1;
    float kUD;
    boolean kUE = false;
    private int kUF = 1;
    private a kUG = new a(this);
    b kUk;
    private Drawable kUl;
    private Drawable kUm;
    private Drawable kUn;
    int kUo;
    int kUp;
    private int kUq;
    private Paint kUr;
    private int kUs;
    private int kUt;
    private int kUu;
    private int kUv;
    private int kUw;
    private int kUx;
    private int kUy;
    private boolean kUz = false;
    private Context mContext;
    int mState = this.STATE_NONE;

    public class a implements Runnable {
        long kUH;
        final /* synthetic */ SmileyPanelScrollView kUI;
        long mStartTime;

        public a(SmileyPanelScrollView smileyPanelScrollView) {
            this.kUI = smileyPanelScrollView;
        }

        final void aod() {
            this.kUH = 300;
            this.mStartTime = SystemClock.uptimeMillis();
            g.oUh.i(13361, new Object[]{Integer.valueOf(0)});
        }

        public final void run() {
            aod();
        }
    }

    public interface b {
        void lx(int i);
    }

    public SmileyPanelScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public SmileyPanelScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.kUm = this.mContext.getResources().getDrawable(R.g.bkf);
        this.kUl = this.mContext.getResources().getDrawable(R.g.bke);
        this.kUn = this.mContext.getResources().getDrawable(R.g.bkg);
        this.kUs = com.tencent.mm.bg.a.fromDPToPix(this.mContext, 12);
        this.kUt = this.kUl.getIntrinsicHeight();
        this.kUu = this.kUl.getIntrinsicWidth();
        this.kUv = this.kUn.getIntrinsicHeight();
        this.kUx = this.kUm.getIntrinsicHeight();
        this.kUy = this.kUm.getIntrinsicWidth();
        w.d("MicroMsg.SmileyPanelScrollView", "init mDotPadding:%d mDotHeight:%d mDotWidth:%d", new Object[]{Integer.valueOf(this.kUs), Integer.valueOf(this.kUt), Integer.valueOf(this.kUu)});
        this.kUr = new Paint();
        this.kUr.setColor(-65536);
        this.kUr.setAntiAlias(true);
        this.kUr.setTextAlign(Align.CENTER);
        this.aar = getMeasuredWidth();
        this.RQ = getMeasuredHeight();
        this.kUq = this.kUw / (this.kUu + this.kUs);
        w.d("MicroMsg.SmileyPanelScrollView", "init mWidth:%d mHeight:%d mTrackWidth:%d mMaxDot:%d", new Object[]{Integer.valueOf(this.aar), Integer.valueOf(this.RQ), Integer.valueOf(this.kUw), Integer.valueOf(this.kUq)});
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        super.draw(canvas);
        a aVar = this.kUG;
        if (aVar.kUI.mState != aVar.kUI.kUF) {
            i = 102;
        } else {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis > aVar.mStartTime + aVar.kUH) {
                i2 = 255;
            } else {
                i2 = ((int) (((uptimeMillis - aVar.mStartTime) * 153) / aVar.kUH)) + 102;
                if (i2 < 102) {
                    i2 = 102;
                }
            }
            i = i2;
        }
        int i3;
        int i4;
        int i5;
        if (this.kUo > this.kUq) {
            this.kUz = true;
            i3 = (this.RQ - this.kUv) / 2;
            i4 = (this.aar - this.kUw) / 2;
            this.abF = i4 - (this.kUy / 2);
            this.abG = (this.abF + this.kUw) + this.kUy;
            if (DEBUG) {
                canvas.drawLine((float) this.abF, 0.0f, (float) this.abF, (float) this.RQ, this.kUr);
                canvas.drawLine((float) this.abG, 0.0f, (float) this.abG, (float) this.RQ, this.kUr);
            }
            this.kUn.setBounds(i4, i3, this.kUw + i4, this.kUv + i3);
            this.kUn.setAlpha(i);
            this.kUn.draw(canvas);
            i5 = (this.RQ - this.kUx) / 2;
            if (this.kUA || this.kUE) {
                i2 = (((this.kUw / (this.kUo - 1)) * this.kUp) + i4) - (this.kUy / 2);
            } else if (this.kUC == this.kUB) {
                i2 = ((((this.kUw / (this.kUo - 1)) * this.kUB) + i4) - (this.kUy / 2)) + ((int) (((float) (this.kUw / (this.kUo - 1))) * this.kUD));
            } else {
                i2 = ((((this.kUw / (this.kUo - 1)) * this.kUB) + i4) - (this.kUy / 2)) - ((int) (((float) (this.kUw / (this.kUo - 1))) * (1.0f - this.kUD)));
            }
            this.kUm.setBounds(i2, i5, this.kUy + i2, this.kUx + i5);
            this.kUm.draw(canvas);
        } else {
            this.kUz = false;
            i3 = (this.RQ - this.kUt) / 2;
            i4 = (this.aar - (((this.kUs + this.kUu) * (this.kUo - 1)) + this.kUu)) / 2;
            this.abF = i4 - ((this.kUy - this.kUu) / 2);
            this.abG = ((this.abF + (this.kUu * this.kUo)) + (this.kUs * (this.kUo - 1))) + (this.kUy - this.kUu);
            if (DEBUG) {
                canvas.drawLine((float) this.abF, 0.0f, (float) this.abF, (float) this.RQ, this.kUr);
                canvas.drawLine((float) this.abG, 0.0f, (float) this.abG, (float) this.RQ, this.kUr);
            }
            this.kUl.setBounds(i4, i3, this.kUu + i4, this.kUt + i3);
            i5 = (this.RQ - this.kUx) / 2;
            if (this.kUA || this.kUE) {
                i2 = i4 - ((this.kUy - this.kUu) / 2);
            } else if (this.kUC == this.kUB) {
                i2 = (i4 - ((this.kUy - this.kUu) / 2)) + ((int) (((float) (this.kUu + this.kUs)) * this.kUD));
            } else {
                i2 = (i4 - ((this.kUy - this.kUu) / 2)) - ((int) (((float) (this.kUu + this.kUs)) * (1.0f - this.kUD)));
            }
            this.kUm.setBounds(i2, i5, this.kUy + i2, this.kUx + i5);
            for (i5 = 0; i5 < this.kUo; i5++) {
                canvas.save();
                if (i5 > 0) {
                    canvas.translate((float) ((this.kUu + this.kUs) * i5), 0.0f);
                }
                this.kUl.setAlpha(i);
                this.kUl.draw(canvas);
                canvas.restore();
            }
            if (this.kUB > this.kUo - 1) {
                this.kUB = this.kUo - 1;
            }
            i5 = (this.kUu + this.kUs) * this.kUB;
            if (i2 + i5 > this.abG) {
                i2 = 0;
                w.i("MicroMsg.SmileyPanelScrollView", "over right.");
            } else {
                i2 = i5;
            }
            canvas.save();
            canvas.translate((float) i2, 0.0f);
            this.kUm.draw(canvas);
            canvas.restore();
        }
        if (this.mState == this.kUF && i < 255) {
            invalidate();
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != this.aar) {
            this.aar = getMeasuredWidth();
            this.RQ = getMeasuredHeight();
            this.kUw = (this.aar - (this.kTj.getColumnWidth() - this.kTj.kUP)) - (com.tencent.mm.bg.a.T(this.mContext, R.f.aXT) * 2);
            this.kUq = this.kUw / (this.kUu + this.kUs);
            w.d("MicroMsg.SmileyPanelScrollView", "onSizeChanged mWidth:%d mHeight:%d mTrackWidth:%d mMaxDot:%d", new Object[]{Integer.valueOf(this.aar), Integer.valueOf(this.RQ), Integer.valueOf(this.kUw), Integer.valueOf(this.kUq)});
            if (this.RQ == 0) {
                w.i("MicroMsg.SmileyPanelScrollView", "user default height");
                this.RQ = com.tencent.mm.bg.a.fromDPToPix(this.mContext, 16);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        if (x < this.abF - this.kUs || x > this.abG + this.kUs) {
            w.d("MicroMsg.SmileyPanelScrollView", "over x :%d mLeft:%d mRight:%d ", new Object[]{Integer.valueOf(x), Integer.valueOf(this.abF), Integer.valueOf(this.abG)});
            if (action == 0) {
                return super.onTouchEvent(motionEvent);
            }
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (x < this.abF) {
                x = this.abF;
            }
            if (x > this.abG) {
                x = this.abG;
            }
            if (this.kUz) {
                x = (x - this.abF) / (this.kUw / (this.kUo - 1));
            } else {
                x = ((x - this.abF) + this.kUs) / (this.kUu + this.kUs);
            }
            if (x > this.kUo - 1) {
                x = this.kUo - 1;
            }
            this.kUk.lx(x);
            this.kUB = x;
            this.kUC = x;
        }
        switch (action) {
            case 0:
                if (!z) {
                    this.kUA = true;
                    this.kUE = true;
                    this.mState = this.kUF;
                    this.kUG.aod();
                    invalidate();
                    break;
                }
                break;
            case 1:
            case 3:
                this.mState = this.STATE_NONE;
                this.kUA = false;
                invalidate();
                break;
            case 2:
                if (!(z || this.mState == this.kUF)) {
                    this.mState = this.kUF;
                    this.kUG.aod();
                    invalidate();
                    break;
                }
        }
        return true;
    }
}
