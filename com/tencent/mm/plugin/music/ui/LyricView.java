package com.tencent.mm.plugin.music.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.music.a.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class LyricView extends View {
    public static int nUD = com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), 16);
    public static int nUE = com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), 10);
    private int height;
    private long hoC;
    private float mTA;
    private float nCw;
    private int nUA;
    private int nUB;
    private int nUC = -1;
    private int nUF = (nUD + nUE);
    private int nUG = this.nUF;
    private boolean nUH;
    private boolean nUI;
    private int nUJ;
    com.tencent.mm.plugin.music.a.a nUx;
    TextPaint nUy;
    TextPaint nUz;
    private GestureDetector nlD;
    private int width;

    private class a extends SimpleOnGestureListener {
        final /* synthetic */ LyricView nUK;

        private a(LyricView lyricView) {
            this.nUK = lyricView;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            CharSequence a = LyricView.a(this.nUK, motionEvent.getX(), motionEvent.getY());
            if (bg.mA(a)) {
                w.i("MicroMsg.Music.LyricView", "onLongPress not found sentence");
                return;
            }
            if (i.aNR().nTp == null) {
                i.aNR().nTp = (ClipboardManager) ab.getContext().getSystemService("clipboard");
            }
            i.aNR().nTp.setPrimaryClip(ClipData.newPlainText("MicroMsg.Music", a));
            Toast.makeText(this.nUK.getContext(), this.nUK.getContext().getString(R.l.eCy, new Object[]{a}), 0).show();
        }
    }

    static /* synthetic */ String a(LyricView lyricView, float f, float f2) {
        w.i("MicroMsg.Music.LyricView", "getSentenceByXY %f, %f", new Object[]{Float.valueOf(f), Float.valueOf(f2)});
        if (lyricView.nUx != null && lyricView.nUx.nSl.size() > 0) {
            int i = (lyricView.height / 2) - lyricView.nUG;
            int i2 = i - ((nUD + nUE) / 2);
            i += (nUD + nUE) / 2;
            if (f2 >= ((float) i2) && f2 <= ((float) i)) {
                return lyricView.nUx.pY(lyricView.nUC).content;
            }
            if (f2 < ((float) i2)) {
                i = (lyricView.nUC - (((int) (((float) i2) - f2)) / (nUD + nUE))) - 1;
                if (i < lyricView.nUx.nSl.size() && i >= 0) {
                    return lyricView.nUx.pY(i).content;
                }
            } else if (f2 > ((float) i)) {
                i = ((((int) (f2 - ((float) i))) / (nUD + nUE)) + lyricView.nUC) + 1;
                if (i < lyricView.nUx.nSl.size() && i >= 0) {
                    return lyricView.nUx.pY(i).content;
                }
            }
        }
        return "";
    }

    public final void cI(long j) {
        if (this.hoC != j) {
            this.hoC = j;
            if (this.nUx != null && this.nUx.nSl.size() != 0) {
                int i = -1;
                int i2 = 0;
                while (i2 < this.nUx.nSl.size() && this.nUx.pY(i2).timestamp < j) {
                    if (!this.nUx.pY(i2).nSr) {
                        i = i2;
                    }
                    i2++;
                }
                if (!this.nUI && i != this.nUC) {
                    this.nUC = i;
                    this.nUA = (nUD + nUE) * this.nUC;
                    this.nUB = (nUD + nUE) * ((this.nUx.nSl.size() - this.nUC) - 1);
                    if (this.nUG == 0) {
                        this.nUG = -this.nUF;
                    }
                    this.nUH = true;
                    invalidate();
                }
            }
        }
    }

    public LyricView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        KC();
    }

    public LyricView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        KC();
    }

    private void KC() {
        this.nUy = new TextPaint();
        this.nUy.setTextSize((float) nUD);
        this.nUy.setColor(-1);
        this.nUy.setAntiAlias(true);
        this.nUy.setTextAlign(Align.CENTER);
        this.nUz = new TextPaint();
        this.nUz.setTextSize((float) nUD);
        this.nUz.setColor(-1);
        this.nUz.setAlpha(127);
        this.nUz.setAntiAlias(true);
        this.nUz.setTextAlign(Align.CENTER);
        this.nlD = new GestureDetector(getContext(), new a());
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.nUx == null) {
            w.v("MicroMsg.Music.LyricView", "lyricObj is null");
            return;
        }
        if (this.height == 0 || this.width == 0) {
            this.height = getMeasuredHeight();
            this.width = getMeasuredWidth();
        }
        if (this.nUC >= 0) {
            int i = this.nUG;
            if (this.nUx != null && this.nUx.nSl.size() > this.nUC) {
                int i2;
                int i3 = (this.height / 2) - i;
                if (i3 < this.height && i3 > 0) {
                    canvas.drawText(this.nUx.pY(this.nUC).content, (float) (this.width / 2), (float) i3, this.nUy);
                }
                for (i = this.nUC - 1; i >= 0; i--) {
                    i2 = i3 - ((this.nUC - i) * (nUD + nUE));
                    if (i2 > 0 && i2 < this.height) {
                        canvas.drawText(this.nUx.pY(i).content, (float) (this.width / 2), (float) i2, this.nUz);
                    }
                }
                for (i = this.nUC + 1; i < this.nUx.nSl.size(); i++) {
                    i2 = ((i - this.nUC) * (nUD + nUE)) + i3;
                    if (i2 < this.height && i2 > 0) {
                        canvas.drawText(this.nUx.pY(i).content, (float) (this.width / 2), (float) i2, this.nUz);
                    }
                }
            }
            if (this.nUH) {
                if ((this.nUG != 0 ? 1 : null) != null) {
                    this.nUG = (int) (((float) this.nUG) * 0.9f);
                    invalidate();
                }
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.height = i2;
        this.width = i;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.nlD.onTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                this.mTA = motionEvent.getY();
                this.nCw = motionEvent.getX();
                this.nUJ = this.nUG;
                this.nUI = true;
                this.nUH = false;
                break;
            case 1:
                this.nUI = false;
                break;
            case 2:
                int x = (int) (motionEvent.getX() - this.nCw);
                int y = this.nUJ - ((int) (motionEvent.getY() - this.mTA));
                if (y > 0) {
                    this.nUG = y > this.nUB ? this.nUB : y;
                } else {
                    this.nUG = y < (-this.nUA) ? -this.nUA : y;
                }
                invalidate();
                w.d("MicroMsg.Music.LyricView", "xDistance: %d yDisntance: %d tempYOffset: %d baseYOffset: %d", new Object[]{Integer.valueOf(x), Integer.valueOf(r3), Integer.valueOf(y), Integer.valueOf(this.nUJ)});
                break;
        }
        return true;
    }
}
