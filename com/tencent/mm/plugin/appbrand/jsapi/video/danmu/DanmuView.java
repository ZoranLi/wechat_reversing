package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DanmuView extends View {
    public int iXR;
    public int iXS;
    public int iXT;
    public float iXU;
    public float iXV;
    private boolean iXW;
    private boolean iXX;
    public c iXY;
    public HashMap<Integer, ArrayList<d>> iXZ;
    public final Deque<d> iYa;
    public List<d> iYb;
    private int[] iYc;
    private volatile boolean iYd;
    private LinkedList<Long> iYe;
    private Paint iYf;
    private long iYg;
    private LinkedList<Float> iYh;
    private final Context mContext;
    public volatile int status;

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ DanmuView iYi;
        final /* synthetic */ d iYj;

        public AnonymousClass3(DanmuView danmuView, d dVar) {
            this.iYi = danmuView;
            this.iYj = dVar;
        }

        public final void run() {
            synchronized (this.iYi.iYb) {
                for (int i = 0; i < this.iYi.iYb.size(); i++) {
                    if (this.iYj.UF() <= ((d) this.iYi.iYb.get(i)).UF()) {
                        this.iYi.iYb.add(i, this.iYj);
                        break;
                    }
                }
            }
        }
    }

    class AnonymousClass4 extends Thread {
        final /* synthetic */ DanmuView iYi;
        final /* synthetic */ List iYk;

        public AnonymousClass4(DanmuView danmuView, List list) {
            this.iYi = danmuView;
            this.iYk = list;
        }

        public final void run() {
            synchronized (this.iYi.iYa) {
                this.iYi.iYa.addAll(this.iYk);
            }
            synchronized (this.iYi.iYb) {
                this.iYi.iYb.addAll(this.iYk);
            }
            this.iYi.postInvalidate();
        }
    }

    class AnonymousClass5 implements Runnable {
        final /* synthetic */ DanmuView iYi;
        final /* synthetic */ int iYl;

        public AnonymousClass5(DanmuView danmuView, int i) {
            this.iYi = danmuView;
            this.iYl = i;
        }

        public final void run() {
            synchronized (this.iYi.iYa) {
                for (int size = this.iYi.iYb.size() - 1; size >= 0; size--) {
                    d dVar = (d) this.iYi.iYb.get(size);
                    if (dVar.UF() < this.iYl) {
                        break;
                    }
                    w.v("MicroMsg.DanmuView", "seekToPlayTime addBack i=%d showTime=%d", new Object[]{Integer.valueOf(size), Integer.valueOf(dVar.UF())});
                    this.iYi.iYa.addFirst(dVar);
                }
            }
            this.iYi.UK();
        }
    }

    public DanmuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DanmuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iXR = 5;
        this.iXS = 500;
        this.iXT = 10;
        this.iXU = 0.0f;
        this.iXV = 0.6f;
        this.iXW = false;
        this.iXX = false;
        this.iYa = new LinkedList();
        this.iYb = new LinkedList();
        this.status = 3;
        this.iYg = 0;
        this.mContext = context;
    }

    public final void prepare() {
        float f = this.iXU;
        float f2 = this.iXV;
        if (f >= f2) {
            throw new IllegalArgumentException("start_Y_offset must < end_Y_offset");
        } else if (f < 0.0f || f >= 1.0f || f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("start_Y_offset and end_Y_offset must between 0 and 1)");
        } else {
            setBackgroundColor(0);
            setDrawingCacheBackgroundColor(0);
            UH();
        }
    }

    public final void UH() {
        this.iXZ = new HashMap(this.iXR);
        for (int i = 0; i < this.iXR; i++) {
            this.iXZ.put(Integer.valueOf(i), new ArrayList(this.iXT));
        }
        UI();
    }

    private void UI() {
        int i = 0;
        this.iYc = new int[this.iXR];
        float bx = b.bx(this.mContext);
        float height = this.iXU * ((float) getHeight());
        for (int i2 = 0; i2 < this.iXR; i2++) {
            this.iYc[i2] = (int) (((((float) (i2 + 1)) * bx) + height) - ((3.0f * bx) / 4.0f));
        }
        if (this.iXX) {
            this.iYh.clear();
            this.iYh.add(Float.valueOf(height));
            while (i < this.iXR) {
                this.iYh.add(Float.valueOf((((float) (i + 1)) * bx) + height));
                i++;
            }
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.iYd) {
            w.i("MicroMsg.DanmuView", "inTransition");
        } else if (this.status == 1) {
            d dVar;
            canvas.drawColor(0);
            for (r1 = 0; r1 < this.iXZ.size(); r1++) {
                r2 = ((ArrayList) this.iXZ.get(Integer.valueOf(r1))).iterator();
                while (r2.hasNext()) {
                    dVar = (d) r2.next();
                    if (dVar.UE()) {
                        r2.remove();
                    } else {
                        try {
                            dVar.a(canvas, false);
                        } catch (Exception e) {
                            w.w("MicroMsg.DanmuView", "STATUS_RUNNING onDraw e=%s", new Object[]{e});
                        }
                    }
                }
            }
            if (System.currentTimeMillis() - this.iYg > ((long) this.iXS)) {
                this.iYg = System.currentTimeMillis();
                synchronized (this.iYa) {
                    if (this.iYa.size() > 0) {
                        dVar = (d) this.iYa.getFirst();
                        int Ug = this.iXY.Ug();
                        d dVar2 = dVar;
                        while (dVar2 != null && dVar2.hU(Ug)) {
                            this.iYa.pollFirst();
                            dVar2 = (d) this.iYa.getFirst();
                        }
                        if (dVar2 != null && dVar2.hT(Ug)) {
                            int b = b(dVar2);
                            if (b >= 0) {
                                dVar2.bq(canvas.getWidth() - 2, this.iYc[b]);
                                dVar2.a(canvas, false);
                                ((ArrayList) this.iXZ.get(Integer.valueOf(b))).add(dVar2);
                                this.iYa.pollFirst();
                            }
                        }
                    }
                }
            }
            if (this.iXW && this.iYe != null) {
                canvas.drawText("FPS:" + ((int) UM()), 5.0f, 20.0f, this.iYf);
            }
            if (this.iXX && this.iYh != null) {
                r7 = this.iYh.iterator();
                while (r7.hasNext()) {
                    r2 = ((Float) r7.next()).floatValue();
                    canvas.drawLine(0.0f, r2, (float) getWidth(), r2, this.iYf);
                }
            }
            invalidate();
        } else if (this.status == 2) {
            try {
                canvas.drawColor(0);
                for (r1 = 0; r1 < this.iXZ.size(); r1++) {
                    r2 = ((ArrayList) this.iXZ.get(Integer.valueOf(r1))).iterator();
                    while (r2.hasNext()) {
                        ((d) r2.next()).a(canvas, true);
                    }
                }
                if (this.iXW && this.iYe != null) {
                    canvas.drawText("FPS:" + ((int) UM()), 5.0f, 20.0f, this.iYf);
                }
                if (this.iXX && this.iYh != null) {
                    r7 = this.iYh.iterator();
                    while (r7.hasNext()) {
                        r2 = ((Float) r7.next()).floatValue();
                        canvas.drawLine(0.0f, r2, (float) getWidth(), r2, this.iYf);
                    }
                }
            } catch (Exception e2) {
                w.w("MicroMsg.DanmuView", "STATUS_PAUSE onDraw e=%s", new Object[]{e2});
            }
            invalidate();
        }
    }

    private int b(d dVar) {
        int i = 0;
        while (i < this.iXR) {
            try {
                int i2 = (i + 0) % this.iXR;
                ArrayList arrayList = (ArrayList) this.iXZ.get(Integer.valueOf(i2));
                if (arrayList.size() == 0) {
                    return i2;
                }
                if (arrayList.size() <= this.iXT && !dVar.a((d) arrayList.get(arrayList.size() - 1))) {
                    return i2;
                }
                i++;
            } catch (Exception e) {
                w.w("MicroMsg.DanmuView", "findVacant,Exception:" + e.getMessage());
            }
        }
        return -1;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        UI();
    }

    public final void UJ() {
        if (isMainThread()) {
            this.iYd = true;
        } else {
            post(new Runnable(this) {
                final /* synthetic */ DanmuView iYi;

                {
                    this.iYi = r1;
                }

                public final void run() {
                    this.iYi.iYd = true;
                }
            });
        }
    }

    public final void UK() {
        if (isMainThread()) {
            this.iYd = false;
            invalidate();
            return;
        }
        post(new Runnable(this) {
            final /* synthetic */ DanmuView iYi;

            {
                this.iYi = r1;
            }

            public final void run() {
                this.iYi.iYd = false;
                this.iYi.invalidate();
            }
        });
    }

    public final void show() {
        this.status = 1;
        invalidate();
    }

    public final void pause() {
        this.status = 2;
        invalidate();
    }

    public final void hide() {
        this.status = 4;
        invalidate();
    }

    public final void UL() {
        if (!(this.iXZ == null || this.iXZ.isEmpty())) {
            this.iXZ.clear();
        }
        synchronized (this.iYa) {
            if (!this.iYa.isEmpty()) {
                this.iYa.clear();
            }
        }
    }

    private double UM() {
        long nanoTime = System.nanoTime();
        this.iYe.addLast(Long.valueOf(nanoTime));
        double longValue = ((double) (nanoTime - ((Long) this.iYe.getFirst()).longValue())) / 1.0E9d;
        if (this.iYe.size() > 100) {
            this.iYe.removeFirst();
        }
        return longValue > 0.0d ? ((double) this.iYe.size()) / longValue : 0.0d;
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
