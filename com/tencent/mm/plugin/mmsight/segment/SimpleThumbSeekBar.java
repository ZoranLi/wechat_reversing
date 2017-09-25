package com.tencent.mm.plugin.mmsight.segment;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.segment.d.b;
import com.tencent.mm.plugin.mmsight.segment.e.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class SimpleThumbSeekBar extends RelativeLayout implements d {
    private int duration;
    private int hhC;
    private int hhD;
    private a nHD = new a(3, new Callable<e>(this) {
        final /* synthetic */ SimpleThumbSeekBar nHY;

        {
            this.nHY = r1;
        }

        public final /* synthetic */ Object call() {
            e cVar = new c();
            cVar.init(this.nHY.path, 0, this.nHY.hhD, this.nHY.hhC);
            return cVar;
        }
    });
    private n.a nHG = new n.a(this) {
        final /* synthetic */ SimpleThumbSeekBar nHY;

        {
            this.nHY = r1;
        }

        public final void aLQ() {
            if (this.nHY.nHW != null) {
                b i = this.nHY.nHW;
                this.nHY.nHT.aLS();
                this.nHY.getWidth();
                this.nHY.nHT.aLT();
                this.nHY.getWidth();
                i.aLH();
            }
        }

        public final void aLR() {
            if (this.nHY.nHW != null) {
                this.nHY.nHW.w(((float) this.nHY.nHT.aLS()) / ((float) this.nHY.getWidth()), ((float) this.nHY.nHT.aLT()) / ((float) this.nHY.getWidth()));
            }
        }

        public final void fI(boolean z) {
            if (this.nHY.nHW != null) {
                this.nHY.nHW.x(((float) this.nHY.nHT.aLS()) / ((float) this.nHY.getWidth()), ((float) this.nHY.nHT.aLT()) / ((float) this.nHY.getWidth()));
            }
        }
    };
    private n nHT;
    private int nHU;
    private d.a nHV;
    private b nHW;
    private CountDownLatch nHX;
    private String path;

    static /* synthetic */ boolean b(SimpleThumbSeekBar simpleThumbSeekBar, final int i) {
        if (simpleThumbSeekBar.getChildCount() <= 0 || !(simpleThumbSeekBar.getChildAt(0) instanceof LinearLayout)) {
            throw new IllegalStateException("ImageView Container not found. It means this view was not init correctly.");
        }
        ImageView imageView;
        LinearLayout linearLayout = (LinearLayout) simpleThumbSeekBar.getChildAt(0);
        if (i >= linearLayout.getChildCount() || !(linearLayout.getChildAt(i) instanceof ImageView)) {
            String str = "MicroMsg.SimpleThumbSeekBar";
            String str2 = "not found this index %d container.getChildCount() %d View %s";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(linearLayout.getChildCount());
            objArr[2] = i >= linearLayout.getChildCount() ? null : linearLayout.getChildAt(i);
            w.d(str, str2, objArr);
            imageView = null;
        } else {
            imageView = (ImageView) linearLayout.getChildAt(i);
        }
        if (imageView == null) {
            throw new IllegalStateException("Can not find ImageView index [" + i + "]");
        } else if (simpleThumbSeekBar.nHD == null) {
            w.e("MicroMsg.SimpleThumbSeekBar", "this thumb may be destroyed, the fetcher pool is null.");
            return false;
        } else {
            e.post(new Runnable(simpleThumbSeekBar) {
                final /* synthetic */ SimpleThumbSeekBar nHY;

                public final void run() {
                    try {
                        Bitmap frameAtTime;
                        e aLI = this.nHY.nHD.aLI();
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            frameAtTime = aLI.getFrameAtTime((long) (((float) (i * this.nHY.duration)) / ((float) this.nHY.nHU)));
                        } catch (o e) {
                            frameAtTime = null;
                        }
                        w.d("MicroMsg.SimpleThumbSeekBar", "time flee, getFrameBitmap use %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        this.nHY.nHD.a(aLI);
                        if (frameAtTime == null) {
                            w.d("MicroMsg.SimpleThumbSeekBar", "loadThumb get null");
                            this.nHY.nHX.countDown();
                            return;
                        }
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass4 nIb;

                            public final void run() {
                                this.nIb.nHY.nHX.countDown();
                                imageView.setImageBitmap(frameAtTime);
                            }
                        });
                    } catch (Exception e2) {
                        w.e("MicroMsg.SimpleThumbSeekBar", "acquireFetcher error");
                        this.nHY.nHX.countDown();
                    }
                }
            }, "load_video_thumb");
            return true;
        }
    }

    public SimpleThumbSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SimpleThumbSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.nHT = new n(getContext());
        this.nHT.nIc = this.nHG;
    }

    public final void AT(final String str) {
        if (str == null || str.length() == 0 || !FileOp.aO(str)) {
            throw new IllegalArgumentException(String.format("SimpleThumbSeekBar can not handle this path[%s]", new Object[]{str}));
        } else if (getHeight() <= 0 || getWidth() <= 0) {
            throw new IllegalArgumentException(String.format(Locale.CHINA, "SimpleThumbSeekBar can not handle width = [%d], height = [%d]", new Object[]{Integer.valueOf(getWidth()), Integer.valueOf(getHeight())}));
        } else {
            this.path = str;
            this.nHU = 10;
            this.hhD = (int) (((float) getWidth()) / ((float) this.nHU));
            this.hhC = getHeight();
            removeAllViews();
            int width = getWidth();
            int height = getHeight();
            LayoutParams layoutParams = getLayoutParams();
            if (!(width == layoutParams.width && height == layoutParams.width)) {
                layoutParams.height = height;
                layoutParams.width = width;
                setLayoutParams(layoutParams);
            }
            View linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(0);
            addView(linearLayout, -1, -1);
            addView(this.nHT, -1, -1);
            int width2 = (int) (((float) getWidth()) / ((float) this.nHU));
            for (height = 0; height < this.nHU; height++) {
                int height2 = getHeight();
                if (getChildCount() <= 0 || !(getChildAt(0) instanceof LinearLayout)) {
                    w.e("MicroMsg.SimpleThumbSeekBar", "ImageView Container not found. It means this view was not init correctly. getChildCount %d indexAt(0) %s", new Object[]{Integer.valueOf(getChildCount()), getChildAt(0)});
                    throw new IllegalStateException("ImageView Container not found. It means this view was not init correctly.");
                }
                LinearLayout linearLayout2 = (LinearLayout) getChildAt(0);
                View imageView = new ImageView(getContext());
                imageView.setScaleType(ScaleType.CENTER_CROP);
                imageView.setPadding(0, 0, 0, 0);
                linearLayout2.addView(imageView, new LinearLayout.LayoutParams(width2, height2));
            }
            e.post(new Runnable(this) {
                final /* synthetic */ SimpleThumbSeekBar nHY;

                public final void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(str);
                    this.nHY.duration = Integer.valueOf(mediaMetadataRetriever.extractMetadata(9)).intValue();
                    w.d("MicroMsg.SimpleThumbSeekBar", "time flee : construct first fetcher, cost %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    currentTimeMillis = System.currentTimeMillis();
                    this.nHY.nHX = new CountDownLatch(this.nHY.nHU);
                    w.d("MicroMsg.SimpleThumbSeekBar", "time flee : build thread. start task, cost %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    for (int i = 0; i < this.nHY.nHU; i++) {
                        SimpleThumbSeekBar.b(this.nHY, i);
                    }
                    try {
                        this.nHY.nHX.await(3, TimeUnit.SECONDS);
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 nHZ;

                            {
                                this.nHZ = r1;
                            }

                            public final void run() {
                                this.nHZ.nHY.nHT.Z(-1.0f);
                                this.nHZ.nHY.nHT.G(Integer.MAX_VALUE, 0, 0);
                                if (this.nHZ.nHY.nHV != null) {
                                    this.nHZ.nHY.nHV.fH(false);
                                }
                            }
                        });
                        if (this.nHY.nHD != null) {
                            this.nHY.nHD.destroy();
                        }
                    } catch (InterruptedException e) {
                        w.e("MicroMsg.SimpleThumbSeekBar", "ThumbLoadedLatch %s", new Object[]{e.getMessage()});
                    }
                }
            }, "init thumb seek bar");
        }
    }

    public final void fG(boolean z) {
        if (z) {
            this.nHT.nIe = true;
        } else {
            this.nHT.nIe = false;
        }
    }

    public final void release() {
        if (this.nHD != null) {
            this.nHD.destroy();
            this.nHD = null;
        }
    }

    public final int getDurationMs() {
        return 0;
    }

    public final void a(d.a aVar) {
        this.nHV = aVar;
    }

    public final void a(b bVar) {
        this.nHW = bVar;
    }

    public final float aLF() {
        float aLS = ((float) this.nHT.aLS()) / ((float) getWidth());
        w.d("MicroMsg.SimpleThumbSeekBar", "computeStartPercent() returned: " + aLS);
        return aLS;
    }

    public final float aLG() {
        float aLT = ((float) this.nHT.aLT()) / ((float) getWidth());
        w.d("MicroMsg.SimpleThumbSeekBar", "computeEndPercent() returned: " + aLT);
        return aLT;
    }

    public final void Y(float f) {
        if (this.nHT != null) {
            this.nHT.Z(f);
        }
    }
}
