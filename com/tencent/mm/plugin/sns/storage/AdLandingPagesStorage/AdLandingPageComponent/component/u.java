package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class u extends a {
    private ImageView fKf;
    ProgressBar jKM;
    private int jYp;
    private int jYq;
    boolean qfv;
    boolean qhU = true;
    private WindowManager qju;

    public u(Context context, m mVar, ViewGroup viewGroup) {
        super(context, mVar, viewGroup);
    }

    protected final int aTQ() {
        return g.pHd;
    }

    public final View bgf() {
        this.fKf = (ImageView) this.ipu.findViewById(f.pEm);
        this.jKM = (ProgressBar) this.ipu.findViewById(f.cts);
        return this.ipu;
    }

    protected final void bgl() {
        if (this.ipu != null && this.fKf != null && this.jKM != null && ((m) this.qib) != null) {
            if (this.qju == null) {
                this.qju = (WindowManager) this.context.getSystemService("window");
                this.jYp = this.qju.getDefaultDisplay().getWidth();
                this.jYq = this.qju.getDefaultDisplay().getHeight();
            }
            float f = ((m) this.qib).qfM;
            float f2 = ((m) this.qib).qfN;
            String str = ((m) this.qib).qfy;
            float f3 = ((m) this.qib).height;
            float f4 = ((m) this.qib).width;
            this.qfv = ((m) this.qib).qfv;
            if (f3 != 0.0f && f4 != 0.0f && !this.qfv) {
                this.fKf.setLayoutParams(new LayoutParams((this.jYp - ((int) f)) - ((int) f2), (((this.jYp - ((int) f)) - ((int) f2)) * ((int) f3)) / ((int) f4)));
            } else if (!this.qfv || f3 == 0.0f || f4 == 0.0f) {
                this.fKf.setLayoutParams(new LayoutParams(this.jYp, this.jYq));
            } else {
                this.fKf.setLayoutParams(new LayoutParams(this.jYp, this.jYq));
            }
            Bitmap dC = d.dC("adId", str);
            if (dC == null || !F(dC)) {
                this.qhU = false;
                startLoading();
                d.a(str, ((m) this.qib).qfJ, new a(this) {
                    final /* synthetic */ u qjv;

                    {
                        this.qjv = r1;
                    }

                    public final void bgn() {
                        this.qjv.startLoading();
                    }

                    public final void bgo() {
                        this.qjv.jKM.setVisibility(8);
                    }

                    public final void FW(String str) {
                        try {
                            this.qjv.F(BitmapFactory.decodeFile(str));
                        } catch (Throwable e) {
                            w.e("AdLandingPagePureImageComponet", "%s" + bg.g(e));
                        }
                    }
                });
                return;
            }
            w.i("AdLandingPagePureImageComponet", "loaded cached image with  " + str);
            this.qhU = true;
        }
    }

    public final void startLoading() {
        this.jKM.setVisibility(0);
    }

    public final boolean F(Bitmap bitmap) {
        if (bitmap == null) {
            w.e("AdLandingPagePureImageComponet", "when set image the bmp is null!");
            return false;
        } else if (this.fKf == null) {
            w.e("AdLandingPagePureImageComponet", "when set image the imageView is null!");
            return false;
        } else if (bitmap.getWidth() == 0) {
            w.e("AdLandingPagePureImageComponet", "when set image the bmp.getWidth is 0!");
            return false;
        } else {
            this.fKf.setImageBitmap(bitmap);
            this.jKM.setVisibility(8);
            return true;
        }
    }

    public final boolean J(JSONObject jSONObject) {
        if (!super.J(jSONObject)) {
            return false;
        }
        try {
            if (!this.qhU) {
                String Pq = aa.Pq(((m) this.qib).qfy);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", Pq);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("imgUrlInfo", jSONObject2);
            }
            return true;
        } catch (Throwable e) {
            w.printErrStackTrace("AdLandingPagePureImageComponet", e, "", new Object[0]);
            return false;
        }
    }
}
