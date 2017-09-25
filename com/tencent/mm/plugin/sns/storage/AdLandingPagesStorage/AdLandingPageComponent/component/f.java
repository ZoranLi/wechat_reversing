package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class f extends i {
    ImageView fKf;
    ProgressBar jKM;
    boolean qhU;

    public f(Context context, ViewGroup viewGroup) {
        this(context, viewGroup, (byte) 0);
    }

    private f(Context context, ViewGroup viewGroup, byte b) {
        super(context, null, viewGroup);
        this.qhU = true;
    }

    public final View bgf() {
        View view = this.ipu;
        this.fKf = (ImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.pEm);
        this.jKM = (ProgressBar) view.findViewById(com.tencent.mm.plugin.sns.i.f.cts);
        return view;
    }

    protected final int aTQ() {
        return g.pGZ;
    }

    protected final void bgl() {
        if (this.ipu != null && this.fKf != null && this.jKM != null && ((m) this.qib) != null) {
            float f = ((m) this.qib).qfK;
            float f2 = ((m) this.qib).qfL;
            float f3 = ((m) this.qib).qfM;
            float f4 = ((m) this.qib).qfN;
            String str = ((m) this.qib).qfy;
            float f5 = ((m) this.qib).height;
            LayoutParams layoutParams = (LayoutParams) this.fKf.getLayoutParams();
            layoutParams.width = (int) ((m) this.qib).width;
            layoutParams.height = (int) f5;
            this.fKf.setLayoutParams(layoutParams);
            this.qhU = false;
            startLoading();
            d.a(str, ((m) this.qib).qfJ, new a(this) {
                final /* synthetic */ f qhV;

                {
                    this.qhV = r1;
                }

                public final void bgn() {
                    this.qhV.startLoading();
                }

                public final void bgo() {
                    this.qhV.jKM.setVisibility(8);
                }

                public final void FW(String str) {
                    try {
                        Bitmap decodeFile = BitmapFactory.decodeFile(str);
                        f fVar = this.qhV;
                        if (decodeFile == null) {
                            w.e("AdLandingImageComp", "when set image the bmp is null!");
                        } else if (fVar.fKf == null) {
                            w.e("AdLandingImageComp", "when set image the imageView is null!");
                        } else if (decodeFile.getWidth() == 0) {
                            w.e("AdLandingImageComp", "when set image the bmp.getWidth is 0!");
                        } else {
                            fVar.fKf.setImageBitmap(decodeFile);
                            fVar.jKM.setVisibility(8);
                        }
                    } catch (Throwable e) {
                        w.e("AdLandingImageComp", "%s" + bg.g(e));
                    }
                }
            });
            this.ipu.setPadding((int) f3, (int) f, (int) f4, (int) f2);
            hD(false);
        }
    }

    public final void startLoading() {
        this.jKM.setVisibility(0);
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
            w.printErrStackTrace("AdLandingImageComp", e, "", new Object[0]);
            return false;
        }
    }
}
