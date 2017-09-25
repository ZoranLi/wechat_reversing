package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Shader.TileMode;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.support.Log;
import java.util.ArrayList;
import java.util.List;

public class MMSightProgressBar extends View {
    public static final int loq = com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), 3);
    public static final int nMT = com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), 5);
    private static final int[] nMU = new int[]{-1, -1, Color.parseColor("#F5B3B2"), Color.parseColor("#EB6866"), Color.parseColor("#E64340")};
    private int centerX = 0;
    private int centerY = 0;
    private boolean fOV = false;
    private ae handler = null;
    private Paint jXK;
    private List<a> nMV = new ArrayList(5);
    private int nMW = 0;
    private b nMX;
    private boolean nMY = false;
    private a nMZ;

    public interface a {
    }

    public MMSightProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMSightProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.jXK = new Paint();
        this.jXK.setColor(-65536);
        this.jXK.setAntiAlias(true);
        this.handler = new ae(this, Looper.getMainLooper()) {
            final /* synthetic */ MMSightProgressBar nNa;

            public final void handleMessage(Message message) {
                if (message.what == 233 && this.nNa.fOV && this.nNa.nMV.size() > 0 && this.nNa.nMV.size() < 5) {
                    this.nNa.nMX = new b((a) this.nNa.nMV.get(this.nNa.nMV.size() - 1), new a(this.nNa.nMV.size(), this.nNa.centerX, this.nNa.centerY, MMSightProgressBar.nMU[this.nNa.nMV.size()]), new com.tencent.mm.plugin.mmsight.ui.progressbar.b.a(this) {
                        final /* synthetic */ AnonymousClass1 nNb;

                        {
                            this.nNb = r1;
                        }

                        public final void a(a aVar) {
                            this.nNb.nNa.nMV.add(aVar);
                            this.nNb.nNa.nMX = null;
                            if (this.nNb.nNa.nMV.size() >= 5) {
                                Log.i("MicroMsg.MMSightProgressBar", "progress finish!");
                                if (this.nNb.nNa.nMZ != null) {
                                    this.nNb.nNa.nMZ;
                                }
                            } else if (this.nNb.nNa.fOV) {
                                this.nNb.nNa.handler.sendEmptyMessage(233);
                            }
                            this.nNb.nNa.invalidate();
                        }

                        public final void aMp() {
                            this.nNb.nNa.invalidate();
                        }
                    });
                    b g = this.nNa.nMX;
                    g.jsj = ValueAnimator.ofFloat(new float[]{0.0f, 100.0f});
                    g.jsj.addUpdateListener(new AnimatorUpdateListener(g) {
                        final /* synthetic */ b nNx;

                        {
                            this.nNx = r1;
                        }

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            this.nNx.nNg = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            b bVar = this.nNx;
                            float f = this.nNx.nNg;
                            bVar.nNu = (float) ((int) (((float) Math.round((float) (MMSightProgressBar.nMT + (MMSightProgressBar.loq * 2)))) * (f / 100.0f)));
                            bVar.nNr = bVar.nNs - ((f / 100.0f) * (bVar.nNs - bVar.nNt));
                            bVar.nNl = new PointF((float) MMSightProgressBar.loq, 0.0f);
                            bVar.nNm = new PointF(((float) MMSightProgressBar.loq) + (bVar.nNu / 2.0f), ((float) MMSightProgressBar.loq) - (bVar.nNr / 2.0f));
                            bVar.nNn = new PointF(((float) MMSightProgressBar.loq) + bVar.nNu, 0.0f);
                            bVar.nNo = new PointF((float) MMSightProgressBar.loq, (float) (MMSightProgressBar.loq * 2));
                            bVar.nNp = new PointF(((float) MMSightProgressBar.loq) + (bVar.nNu / 2.0f), ((float) MMSightProgressBar.loq) + (bVar.nNr / 2.0f));
                            bVar.nNq = new PointF(((float) MMSightProgressBar.loq) + bVar.nNu, ((float) MMSightProgressBar.loq) * 2.0f);
                            w.d("MicroMsg.MMSightProgressPointSplitter", "calPoints, currentPointDistance: %s, curveCenterDistance: %s", new Object[]{Float.valueOf(bVar.nNu), Float.valueOf(bVar.nNr)});
                            w.d("MicroMsg.MMSightProgressPointSplitter", "calPoints, point1: %s, point2: %s, point3: %s, point4: %s, point5: %s, point6: %s", new Object[]{bVar.nNl, bVar.nNm, bVar.nNn, bVar.nNo, bVar.nNp, bVar.nNq});
                            if (this.nNx.nNk != null) {
                                this.nNx.nNk.aMp();
                            }
                        }
                    });
                    g.jsj.addListener(new AnimatorListenerAdapter(g) {
                        final /* synthetic */ b nNx;

                        {
                            this.nNx = r1;
                        }

                        public final void onAnimationStart(Animator animator) {
                            this.nNx.nNj = true;
                        }

                        public final void onAnimationEnd(Animator animator) {
                            this.nNx.nNj = true;
                            if (this.nNx.nNk != null) {
                                this.nNx.nNk.a(this.nNx.nNi);
                            }
                        }
                    });
                    g.jsj.setInterpolator(new AccelerateDecelerateInterpolator());
                    g.jsj.setDuration(2000);
                    g.jsj.start();
                }
            }
        };
        Log.i("MicroMsg.MMSightProgressBar", "init, pointRadius: %s, pointDistance: %s", new Object[]{Integer.valueOf(loq), Integer.valueOf(nMT)});
    }

    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.fOV && (this.centerX <= 0 || this.centerY <= 0)) {
            int left = getLeft();
            int right = getRight();
            int top = getTop();
            int bottom = getBottom();
            this.centerX = (right - left) / 2;
            this.centerY = (bottom - top) / 2;
            Log.i("MicroMsg.MMSightProgressBar", "left: %s, right: %s, top: %s, bottom: %s, centerX: %s, centerY: %s", new Object[]{Integer.valueOf(left), Integer.valueOf(right), Integer.valueOf(top), Integer.valueOf(bottom), Integer.valueOf(this.centerX), Integer.valueOf(this.centerY)});
            Log.i("MicroMsg.MMSightProgressBar", "add init point");
            this.nMV.add(new a(0, this.centerX, this.centerY, -1));
        }
        int save = canvas.save();
        this.nMW = this.nMV.size();
        if (this.nMW % 2 == 0) {
            f = -(((((float) nMT) / 2.0f) + ((float) (((this.nMW / 2) - 1) * nMT))) + ((float) ((this.nMW / 2) * loq)));
        } else {
            f = -(((((float) loq) / 2.0f) + ((float) ((this.nMW / 2) * nMT))) + ((float) ((this.nMW / 2) * loq)));
        }
        if (this.nMX != null && this.nMX.nNj) {
            float f2;
            right = this.nMW + 1;
            if (right % 2 == 0) {
                f2 = -(((float) ((right / 2) * loq)) + ((((float) nMT) / 2.0f) + ((float) (((right / 2) - 1) * nMT))));
            } else {
                f2 = -(((float) ((right / 2) * loq)) + ((((float) loq) / 2.0f) + ((float) ((right / 2) * nMT))));
            }
            Log.d("MicroMsg.MMSightProgressBar", "add translateX for splitting, dstTranslateX: %s, progress: %s", new Object[]{Float.valueOf(f2), Float.valueOf(this.nMX.nNg)});
            f -= (Math.abs(f2) - Math.abs(f)) * (this.nMX.nNg / 100.0f);
        }
        Log.d("MicroMsg.MMSightProgressBar", "draw, translateX: %s, currentPointCount: %s", new Object[]{Float.valueOf(f), Integer.valueOf(this.nMW)});
        canvas.translate(f, 0.0f);
        if (this.nMX != null && this.nMX.nNj) {
            b bVar = this.nMX;
            Paint paint = this.jXK;
            w.d("MicroMsg.MMSightProgressPointSplitter", "drawForSplitProgress, progress: %s, rightPointXOffset: %s", new Object[]{Float.valueOf(bVar.nNg), Float.valueOf(((float) (nMT + (loq * 2))) * (bVar.nNg / 100.0f))});
            if (bVar.nNr > bVar.nNt) {
                float f3 = bVar.nNh.nNc - ((float) loq);
                f = bVar.nNh.nNd - ((float) loq);
                paint.setColor(bVar.nNi.color);
                bVar.nNv.reset();
                bVar.nNv.moveTo(bVar.nNl.x + f3, bVar.nNl.y + f);
                bVar.nNv.quadTo(bVar.nNm.x + f3, bVar.nNm.y + f, bVar.nNn.x + f3, bVar.nNn.y + f);
                bVar.nNv.lineTo(bVar.nNq.x + f3, bVar.nNq.y + f);
                bVar.nNv.quadTo(bVar.nNp.x + f3, bVar.nNp.y + f, bVar.nNo.x + f3, f + bVar.nNo.y);
                if (bVar.nNi.color != bVar.nNh.color) {
                    paint.setShader(new LinearGradient(bVar.nNl.x + f3, bVar.nNh.nNd - ((float) loq), f3 + bVar.nNn.x, bVar.nNh.nNd - ((float) loq), new int[]{bVar.nNh.color, bVar.nNi.color}, null, TileMode.REPEAT));
                }
                canvas.drawPath(bVar.nNv, paint);
                paint.setShader(null);
            }
            a aVar = bVar.nNi;
            paint.setColor(aVar.color);
            aVar.nNd = (float) aVar.nNf;
            aVar.nNc = ((float) (aVar.nNe + ((aVar.index - 1) * (nMT + (loq * 2))))) + r11;
            Log.d("MicroMsg.MMSightProgressPoint", "drawWithOffset, index: %s, offset: %s, pointX: %s", new Object[]{Integer.valueOf(aVar.index), Float.valueOf(r11), Float.valueOf(aVar.nNc)});
            canvas.drawCircle(aVar.nNc, aVar.nNd, (float) loq, paint);
            paint.setShader(null);
        }
        for (a aVar2 : this.nMV) {
            Paint paint2 = this.jXK;
            paint2.setColor(aVar2.color);
            aVar2.nNc = (float) (aVar2.nNe + (aVar2.index * (nMT + (loq * 2))));
            aVar2.nNd = (float) aVar2.nNf;
            Log.d("MicroMsg.MMSightProgressPoint", "draw, index: %s, pointX: %s", new Object[]{Integer.valueOf(aVar2.index), Float.valueOf(aVar2.nNc)});
            canvas.drawCircle(aVar2.nNc, aVar2.nNd, (float) loq, paint2);
            paint2.setShader(null);
        }
        canvas.restoreToCount(save);
        if (this.fOV && !this.nMY && this.nMV.size() > 0) {
            Log.i("MicroMsg.MMSightProgressBar", "start handler loop");
            this.nMY = true;
            this.handler.sendEmptyMessage(233);
        }
    }
}
