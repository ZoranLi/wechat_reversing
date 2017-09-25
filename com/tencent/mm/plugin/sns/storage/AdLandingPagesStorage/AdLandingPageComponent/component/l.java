package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.CircularImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class l extends a {
    CircularImageView qii;

    public l(Context context, m mVar, ViewGroup viewGroup) {
        super(context, mVar, viewGroup);
    }

    protected final View bgm() {
        return new CircularImageView(this.context);
    }

    public final View bgf() {
        this.qii = (CircularImageView) this.ipu;
        return this.ipu;
    }

    protected final void bgl() {
        if (this.ipu != null && this.qii != null) {
            m mVar = (m) this.qib;
            if (mVar != null) {
                d.a(mVar.qfy, mVar.qfJ, new a(this) {
                    final /* synthetic */ l qij;

                    {
                        this.qij = r1;
                    }

                    public final void bgn() {
                    }

                    public final void bgo() {
                    }

                    public final void FW(String str) {
                        try {
                            Bitmap decodeFile = BitmapFactory.decodeFile(str);
                            l lVar = this.qij;
                            if (decodeFile == null) {
                                w.e("AdLandingPageCircleImgComp", "when set image the bmp is null!");
                            } else if (lVar.qii == null) {
                                w.e("AdLandingPageCircleImgComp", "when set image the img is null!");
                            } else if (decodeFile.getWidth() == 0) {
                                w.e("AdLandingPageCircleImgComp", "when set image the bmp.getWidth is 0!");
                            } else {
                                lVar.qii.setImageBitmap(decodeFile);
                            }
                        } catch (Throwable e) {
                            w.e("AdLandingPageCircleImgComp", "%s" + bg.g(e));
                        }
                    }
                });
            }
        }
    }
}
