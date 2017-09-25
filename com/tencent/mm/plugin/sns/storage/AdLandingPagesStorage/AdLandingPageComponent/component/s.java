package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class s extends i implements SensorEventListener {
    private SensorManager aJs;
    Sensor aNe;
    Sensor aNg;
    ImageView fKf;
    ProgressBar jKM;
    int qjh;
    final float qji = 10.0f;
    final int qjj = 1;
    HorizontalScrollView qjk;
    float[] qjl;
    float[] qjm;
    private int qjn = 0;
    boolean qjo = true;

    public s(Context context, l lVar, ViewGroup viewGroup) {
        super(context, lVar, viewGroup);
    }

    protected final int aTQ() {
        return g.pGW;
    }

    public final View bgf() {
        View view = this.ipu;
        this.aJs = (SensorManager) this.context.getSystemService("sensor");
        this.aNe = this.aJs.getDefaultSensor(1);
        this.aNg = this.aJs.getDefaultSensor(2);
        this.qjk = (HorizontalScrollView) view.findViewById(f.pAC);
        this.fKf = (ImageView) view.findViewById(f.pAD);
        this.jKM = (ProgressBar) view.findViewById(f.cts);
        this.jKM.setVisibility(8);
        return view;
    }

    protected final void bgl() {
        if (!e.aO(d.dA("adId", ((l) this.qib).qfy))) {
            this.qjo = false;
        }
        this.qjk.setLayoutParams(new LayoutParams(this.jYp, this.jYq));
        this.fKf.setLayoutParams(new LayoutParams(this.jYp, this.jYq));
        this.ipu.setLayoutParams(new LinearLayout.LayoutParams(this.jYp, this.jYq));
        this.ipu.setPadding(this.ipu.getPaddingLeft(), (int) ((l) this.qib).qfK, this.ipu.getPaddingRight(), (int) ((l) this.qib).qfL);
        String str = ((l) this.qib).qfy;
        Bitmap dC = d.dC("adId", str);
        if (dC != null) {
            w.i("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "loaded cached image with  " + str);
            E(dC);
            return;
        }
        startLoading();
        d.a(str, ((l) this.qib).qfJ, new a(this) {
            final /* synthetic */ s qjp;

            {
                this.qjp = r1;
            }

            public final void bgn() {
                this.qjp.startLoading();
            }

            public final void bgo() {
                this.qjp.jKM.setVisibility(8);
            }

            public final void FW(String str) {
                try {
                    this.qjp.E(BitmapFactory.decodeFile(str));
                } catch (Throwable e) {
                    w.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "%s" + bg.g(e));
                }
            }
        });
    }

    public final void startLoading() {
        this.jKM.setVisibility(0);
    }

    public final void E(Bitmap bitmap) {
        if (bitmap == null) {
            w.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the bmp is null!");
        } else if (this.fKf == null) {
            w.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the imageView is null!");
        } else if (bitmap.getHeight() == 0) {
            w.e("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", "when set image the bmp.getHeight is 0!");
        } else {
            this.jKM.setVisibility(8);
            this.fKf.setImageBitmap(bitmap);
            WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
            final int width = windowManager.getDefaultDisplay().getWidth();
            int height = windowManager.getDefaultDisplay().getHeight();
            this.fKf.setLayoutParams(new LayoutParams((bitmap.getWidth() * height) / bitmap.getHeight(), height));
            this.fKf.post(new Runnable(this) {
                final /* synthetic */ s qjp;

                public final void run() {
                    int measuredWidth = this.qjp.fKf.getMeasuredWidth();
                    if (measuredWidth > width) {
                        this.qjp.qjh = (measuredWidth - width) / 2;
                        this.qjp.qjk.scrollBy(this.qjp.qjh, 0);
                    }
                }
            });
            if (bitmap.getHeight() != 0) {
                this.ipu.setLayoutParams(new LinearLayout.LayoutParams((bitmap.getWidth() * height) / bitmap.getHeight(), height));
            }
        }
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float f = -10.0f;
        if (sensorEvent.sensor.getType() == 1) {
            this.qjl = sensorEvent.values;
        }
        if (sensorEvent.sensor.getType() == 2) {
            this.qjm = sensorEvent.values;
        }
        if (this.qjl != null && this.qjm != null) {
            float[] fArr = new float[9];
            if (SensorManager.getRotationMatrix(fArr, new float[9], this.qjl, this.qjm)) {
                float[] fArr2 = new float[3];
                SensorManager.getOrientation(fArr, fArr2);
                float f2 = fArr2[2];
                if (this.qjh != 0) {
                    if (f2 > 10.0f) {
                        f2 = 10.0f;
                    }
                    if (f2 >= -10.0f) {
                        f = f2;
                    }
                    this.qjk.scrollBy((int) ((f * ((float) this.qjh)) / 10.0f), 0);
                }
            }
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void bfP() {
        super.bfP();
        this.aJs.registerListener(this, this.aNe, 1);
        this.aJs.registerListener(this, this.aNg, 1);
    }

    public final void bfQ() {
        super.bfQ();
        this.aJs.unregisterListener(this);
    }

    public final boolean J(JSONObject jSONObject) {
        if (!super.J(jSONObject)) {
            return false;
        }
        try {
            jSONObject.put("swipeCount", this.qjn);
            if (!this.qjo) {
                String Pq = aa.Pq(((l) this.qib).qfy);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", Pq);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("imgUrlInfo", jSONObject2);
            }
            return true;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Sns.AdLandingPagePanoramaImageComponent", e, "", new Object[0]);
            return false;
        }
    }
}
