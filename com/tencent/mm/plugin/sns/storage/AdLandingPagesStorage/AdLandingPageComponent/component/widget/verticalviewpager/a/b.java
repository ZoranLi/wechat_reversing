package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.DummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.ui.al;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.smtt.sdk.WebView;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public final class b extends Fragment {
    private static int qlA;
    public int bgColor;
    private boolean hML;
    private boolean ipi;
    public int jYp;
    public int jYq;
    private LinearLayoutManager qhy;
    public final Map<String, Bitmap> qiG = new WeakHashMap();
    private int qiP = 1000;
    public int qiQ = 700;
    public com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b qlB;
    w qlC;
    public boolean qlD;
    public boolean qlE;
    public int qlF;
    public int qlG;
    private a qlH;
    public b qlI;
    private a qlJ;
    private boolean qlK;
    public int qlL;
    public String qlM;
    public c qlw;

    public interface a extends Serializable {
        void a(b bVar);
    }

    private static class b {
        public LinearLayout jqs = null;
        public RecyclerView nHz;
        public View qlS;
        public ImageView qlT = null;
        public ImageView qlU = null;
        public boolean qlV = false;
        public LinearLayout qlW;
    }

    public static Fragment a(c cVar, DummyViewPager dummyViewPager, w wVar, boolean z, a aVar, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("pageInfo", cVar);
        bundle.putSerializable("viewpager", dummyViewPager);
        bundle.putSerializable("lifecycle", aVar);
        bundle.putSerializable("pageDownIconInfo", wVar);
        bundle.putBoolean("isLastPage", z);
        bundle.putBoolean("needEnterAnimation", z2);
        Fragment bVar = new b();
        bVar.setArguments(bundle);
        return bVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        qlA = com.tencent.mm.bg.a.fromDPToPix(getContext(), 60);
        int[] cP = ab.cP(getContext());
        this.jYp = cP[0];
        this.jYq = cP[1];
        if (this.qlw == null) {
            this.qlw = (c) this.oW.getSerializable("pageInfo");
        }
        this.qlH = (a) this.oW.getSerializable("lifecycle");
        this.qlC = (w) this.oW.getSerializable("pageDownIconInfo");
        this.ipi = this.oW.getBoolean("isLastPage");
        this.qlD = this.oW.getBoolean("needEnterAnimation");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(g.pGC, viewGroup, false);
        this.qlI = new b();
        this.qlI.qlS = inflate;
        this.qlI.qlT = (ImageView) inflate.findViewById(f.pDY);
        this.qlI.jqs = (LinearLayout) inflate.findViewById(f.pEr);
        this.qlI.qlU = (ImageView) inflate.findViewById(f.pFr);
        this.qlI.nHz = (RecyclerView) inflate.findViewById(f.pCf);
        this.qlI.qlW = (LinearLayout) inflate.findViewById(f.pCy);
        RecyclerView recyclerView = this.qlI.nHz;
        recyclerView.setOverScrollMode(2);
        recyclerView.setOnTouchListener(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a((DummyViewPager) this.oW.getSerializable("viewpager")));
        this.qhy = new LinearLayoutManager();
        recyclerView.a(this.qhy);
        this.qlJ = new a(this.qlw, this.bgColor, aG(), this.qhy);
        recyclerView.a(this.qlJ);
        this.qlB = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b(recyclerView, this);
        recyclerView.a(new k(this) {
            final /* synthetic */ b qlN;

            {
                this.qlN = r1;
            }

            public final void c(RecyclerView recyclerView, int i, int i2) {
                super.c(recyclerView, i, i2);
                if (this.qlN.qlI.qlT != null && this.qlN.qlI.qlT.getVisibility() == 0) {
                    this.qlN.qlI.qlT.scrollBy(i, i2);
                }
            }

            public final void e(RecyclerView recyclerView, int i) {
                super.e(recyclerView, i);
                this.qlN.qlF = i;
                if (i == 0) {
                    if (this.qlN.bgT()) {
                        this.qlN.bgS();
                    }
                } else if (i == 1) {
                    this.qlN.bgR();
                    ab.cQ(this.qlN.getContext());
                }
            }
        });
        inflate.setTag(this.qlI);
        auz();
        if (this.qlH != null) {
            this.qlH.a(this);
        }
        return inflate;
    }

    public final void onResume() {
        super.onResume();
        com.tencent.mm.sdk.platformtools.w.i("ContentFragment", this + " onResume " + getUserVisibleHint());
        this.hML = true;
        if (this.qlB != null && getUserVisibleHint()) {
            this.qlB.bgh();
        }
    }

    public final void onPause() {
        super.onPause();
        new StringBuilder().append(this).append(" onPause ").append(getUserVisibleHint());
        this.hML = false;
        if (this.qlB != null && getUserVisibleHint()) {
            this.qlB.bgH();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        if (this.qlB != null) {
            this.qlB.qlf.onDestroy();
        }
    }

    public final void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            if (this.qlB != null) {
                this.qlB.bgh();
            }
        } else if (this.qlB != null) {
            this.qlB.bgH();
        }
    }

    public final void bgL() {
        if (this.qlB != null) {
            this.qlB.bgg();
        }
    }

    public final void bgM() {
        if ((this.qlw.qmr || !TextUtils.isEmpty(this.qlw.qmq)) && !this.qlK) {
            this.qlK = true;
            this.qlI.qlW.setVisibility(0);
            this.qlI.qlT.setScaleType(ScaleType.CENTER_CROP);
            this.qlI.qlW.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                final /* synthetic */ b qlN;

                {
                    this.qlN = r1;
                }

                public final boolean onPreDraw() {
                    if (this.qlN.qlI.qlW.getHeight() > 0) {
                        this.qlN.qlI.qlW.getViewTreeObserver().removeOnPreDrawListener(this);
                        LayoutParams layoutParams = (LayoutParams) this.qlN.qlI.qlT.getLayoutParams();
                        layoutParams.height = this.qlN.qlI.qlW.getHeight();
                        this.qlN.qlL = this.qlN.qlI.qlW.getHeight();
                        this.qlN.qlI.qlT.setLayoutParams(layoutParams);
                        com.tencent.mm.sdk.platformtools.w.v("ContentFragment", "set bgIV height " + this.qlN.qlI.qlW.getHeight() + ", count " + this.qlN.qlI.qlW.getChildCount());
                        this.qlN.qlI.qlW.removeAllViews();
                        this.qlN.qlI.qlW.setVisibility(8);
                        this.qlN.bgN();
                    }
                    return true;
                }
            });
            a aVar = this.qlJ;
            ViewGroup viewGroup = this.qlI.qlW;
            for (int i = 0; i < aVar.qlw.qms.size(); i++) {
                i a = al.a(viewGroup.getContext(), (p) aVar.qlw.qms.get(i), viewGroup, aVar.bgColor);
                if (a != null) {
                    if (a.getView().getParent() != null && (a.getView().getParent() instanceof ViewGroup)) {
                        ((ViewGroup) a.getView().getParent()).removeView(a.getView());
                    }
                    viewGroup.addView(a.getView());
                }
            }
        }
    }

    public final void auz() {
        if (this.qlw.qmq != null && this.qlw.qmq.length() > 0) {
            final String str = this.qlw.qmq;
            final ImageView imageView = this.qlI.qlT;
            if (this.qlw.qmr || !TextUtils.isEmpty(this.qlw.qmq)) {
                if (!this.qlD || this.qlE) {
                    imageView.post(new Runnable(this) {
                        final /* synthetic */ b qlN;

                        {
                            this.qlN = r1;
                        }

                        public final void run() {
                            this.qlN.bgM();
                        }
                    });
                } else {
                    com.tencent.mm.sdk.platformtools.w.i("ContentFragment", "waiting for main page loaded to set blur bg");
                }
            }
            if (this.qiG.containsKey(str)) {
                imageView.setImageBitmap((Bitmap) this.qiG.get(str));
            } else {
                d.a("adId", str, false, 1000000001, 0, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a(this) {
                    final /* synthetic */ b qlN;

                    public final void bgn() {
                    }

                    public final void bgo() {
                        if (this.qlN.qlw.iDX != null && this.qlN.qlw.iDX.length() > 0) {
                            try {
                                this.qlN.bgColor = Color.parseColor(this.qlN.qlw.iDX);
                            } catch (Exception e) {
                                com.tencent.mm.sdk.platformtools.w.e("ContentFragment", "the color is error : " + this.qlN.qlw.iDX);
                            }
                            this.qlN.qlI.qlT.setVisibility(8);
                            this.qlN.qlI.qlS.setBackgroundColor(this.qlN.bgColor);
                            this.qlN.qlI.qlT.setBackgroundColor(this.qlN.bgColor);
                            this.qlN.qlI.jqs.setBackgroundColor(this.qlN.bgColor);
                            this.qlN.bgO();
                        }
                    }

                    public final void FW(String str) {
                        Bitmap bitmap = null;
                        float f = 1.0f;
                        try {
                            if (this.qlN.qlw.qmr) {
                                String dA = d.dA("adId", str + "_blurimg");
                                if (FileOp.aO(dA)) {
                                    bitmap = BitmapFactory.decodeFile(dA);
                                } else {
                                    Bitmap decodeFile = com.tencent.mm.sdk.platformtools.d.decodeFile(str, null);
                                    if (decodeFile != null) {
                                        if (decodeFile.getHeight() < this.qlN.jYq || decodeFile.getWidth() < this.qlN.jYp) {
                                            f = Math.max((((float) this.qlN.jYp) * 1.0f) / ((float) decodeFile.getWidth()), (1.0f * ((float) this.qlN.jYq)) / ((float) decodeFile.getHeight()));
                                        }
                                        Bitmap a = com.tencent.mm.sdk.platformtools.d.a(decodeFile, f, f);
                                        n a2 = com.tencent.mm.plugin.sns.lucky.a.a.a(Bitmap.createBitmap(a, (a.getWidth() - this.qlN.jYp) >>> 1, (a.getHeight() - this.qlN.jYq) >>> 1, this.qlN.jYp, this.qlN.jYq), dA, Color.argb(com.tencent.mm.plugin.appbrand.jsapi.map.c.CTRL_INDEX, 0, 0, 0), 180);
                                        if (a2 != null) {
                                            bitmap = a2.wx();
                                        }
                                    }
                                }
                            }
                            if (bitmap == null) {
                                this.qlN.qlM = str;
                                if (this.qlN.qlL > 0) {
                                    this.qlN.bgN();
                                    return;
                                } else {
                                    com.tencent.mm.sdk.platformtools.w.i("ContentFragment", "wait for bgHeight");
                                    return;
                                }
                            }
                            this.qlN.qiG.put(str, bitmap);
                            imageView.setImageBitmap(bitmap);
                        } catch (Exception e) {
                            com.tencent.mm.sdk.platformtools.w.e("ContentFragment", "the backgroundCoverUrl is set error ,because " + e.toString());
                        }
                    }
                });
            }
        } else if (this.qlw.iDX != null && this.qlw.iDX.length() > 0) {
            try {
                this.bgColor = Color.parseColor(this.qlw.iDX);
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.w.e("ContentFragment", "the color is error : " + this.qlw.iDX);
            }
            this.qlI.qlT.setVisibility(8);
            this.qlI.qlS.setBackgroundColor(this.bgColor);
            this.qlI.qlT.setBackgroundColor(this.bgColor);
            this.qlI.jqs.setBackgroundColor(this.bgColor);
            bgO();
        }
        if (this.qlJ != null) {
            this.qlJ.bgColor = this.bgColor;
            android.support.v7.widget.RecyclerView.a aVar = this.qlJ;
            c cVar = this.qlw;
            if (aVar.qlw != cVar) {
                aVar.qlw = cVar;
                aVar.aab.notifyChanged();
            }
        }
    }

    public final void bgN() {
        if (this.qlL > 0 && !TextUtils.isEmpty(this.qlM)) {
            try {
                if (this.qlI.jqs.getHeight() > this.qlL) {
                    this.qlL = this.qlI.jqs.getHeight();
                    LayoutParams layoutParams = (LayoutParams) this.qlI.qlT.getLayoutParams();
                    layoutParams.height = this.qlL;
                    this.qlI.qlT.setLayoutParams(layoutParams);
                }
                Bitmap decodeFile = BitmapFactory.decodeFile(this.qlM);
                if (decodeFile.getWidth() < this.jYp) {
                    float width = (1.0f * ((float) this.jYp)) / ((float) decodeFile.getWidth());
                    decodeFile = com.tencent.mm.sdk.platformtools.d.a(decodeFile, width, width);
                    if (decodeFile.getHeight() > this.qlL) {
                        decodeFile = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), this.qlL);
                    }
                }
                this.qiG.put(this.qlw.qmq, decodeFile);
                this.qlI.qlT.setImageBitmap(decodeFile);
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.w.e("ContentFragment", bg.g(e));
            }
        }
    }

    public final void bgO() {
        if (this.bgColor - WebView.NIGHT_MODE_COLOR <= -1 - this.bgColor) {
            this.qlI.qlU.setImageDrawable(com.tencent.mm.bg.a.a(aG(), e.pzV));
        } else {
            this.qlI.qlU.setImageDrawable(com.tencent.mm.bg.a.a(aG(), e.pzU));
        }
    }

    public final RecyclerView bgP() {
        if (this.qlI != null) {
            return this.qlI.nHz;
        }
        return null;
    }

    public final Collection<i> bgQ() {
        if (this.qlJ == null) {
            return Collections.EMPTY_LIST;
        }
        a aVar = this.qlJ;
        return aVar.qlx == null ? Collections.EMPTY_LIST : aVar.qlx.values();
    }

    public final void bgR() {
        if (this.qlI.qlU.getVisibility() == 0) {
            this.qlI.qlU.clearAnimation();
            this.qlI.qlU.setVisibility(4);
        }
    }

    public final void bgS() {
        if (bgT()) {
            this.qlI.qlU.clearAnimation();
            this.qlI.qlU.setVisibility(0);
            final Animation alphaAnimation = new AlphaAnimation(0.0f, 0.8f);
            alphaAnimation.setDuration((long) this.qiP);
            alphaAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
            alphaAnimation.setStartOffset((long) this.qiP);
            alphaAnimation.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ b qlN;

                {
                    this.qlN = r1;
                }

                public final void onAnimationStart(Animation animation) {
                    com.tencent.mm.sdk.platformtools.w.d("ContentFragment", "onAnimationStart show nextBtn");
                    this.qlN.qlI.qlV = true;
                }

                public final void onAnimationEnd(Animation animation) {
                    new ae().postDelayed(new Runnable(this) {
                        final /* synthetic */ AnonymousClass5 qlO;

                        {
                            this.qlO = r1;
                        }

                        public final void run() {
                            com.tencent.mm.sdk.platformtools.w.d("ContentFragment", "onAnimationEnd show nextBtn");
                            this.qlO.qlN.qlI.qlU.setAlpha(1.0f);
                            this.qlO.qlN.a(this.qlO.qlN.qlI);
                        }
                    }, 200);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            if (this.qlC == null || this.qlC.equals(this.qlI.qlU.getTag())) {
                this.qlI.qlU.startAnimation(alphaAnimation);
                return;
            }
            this.qlI.qlU.setTag(this.qlC);
            this.qlI.qlU.setVisibility(8);
            d.a(this.qlC.iconUrl, 1000000001, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a(this) {
                final /* synthetic */ b qlN;

                public final void bgn() {
                }

                public final void bgo() {
                    com.tencent.mm.sdk.platformtools.w.d("ContentFragment", "onDownloadError show nextBtn");
                    this.qlN.qlI.qlU.setVisibility(0);
                    this.qlN.qlI.qlU.startAnimation(alphaAnimation);
                }

                public final void FW(String str) {
                    com.tencent.mm.sdk.platformtools.w.d("ContentFragment", "onDownloaded show nextBtn");
                    b bVar = this.qlN;
                    ImageView imageView = this.qlN.qlI.qlU;
                    Bitmap decodeFile = BitmapFactory.decodeFile(str);
                    ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                    if (Float.compare(bVar.qlC.width, 0.0f) > 0) {
                        layoutParams.width = (int) bVar.qlC.width;
                    } else {
                        layoutParams.width = -1;
                    }
                    if (Float.compare(bVar.qlC.height, 0.0f) > 0) {
                        layoutParams.height = (int) bVar.qlC.height;
                    } else {
                        layoutParams.height = -2;
                    }
                    if (layoutParams instanceof MarginLayoutParams) {
                        ((MarginLayoutParams) layoutParams).bottomMargin = (int) bVar.qlC.qfL;
                    }
                    imageView.setImageBitmap(decodeFile);
                    this.qlN.qlI.qlU.setVisibility(0);
                    this.qlN.qlI.qlU.startAnimation(alphaAnimation);
                }
            });
        }
    }

    public final void a(final b bVar) {
        if (!bVar.qlV) {
            return;
        }
        if (bVar.qlU.getVisibility() != 0) {
            com.tencent.mm.sdk.platformtools.w.d("ContentFragment", "nextBtn not visible");
            return;
        }
        Animation animationSet = new AnimationSet(true);
        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -10.0f);
        translateAnimation.setDuration((long) this.qiQ);
        translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
        animationSet.addAnimation(translateAnimation);
        translateAnimation = new AlphaAnimation(0.8f, 0.3f);
        translateAnimation.setDuration((long) this.qiQ);
        translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
        animationSet.addAnimation(translateAnimation);
        animationSet.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ b qlN;

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                if (bVar.qlU.getVisibility() != 0) {
                    com.tencent.mm.sdk.platformtools.w.d("ContentFragment", "nextBtn not visible");
                    return;
                }
                Animation animationSet = new AnimationSet(true);
                Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, -10.0f, 0.0f);
                translateAnimation.setDuration((long) this.qlN.qiQ);
                translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                translateAnimation.setStartTime((long) this.qlN.qiQ);
                animationSet.addAnimation(translateAnimation);
                translateAnimation = new AlphaAnimation(0.3f, 0.8f);
                translateAnimation.setDuration((long) this.qlN.qiQ);
                translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                translateAnimation.setStartTime((long) this.qlN.qiQ);
                animationSet.addAnimation(translateAnimation);
                animationSet.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ AnonymousClass7 qlR;

                    {
                        this.qlR = r1;
                    }

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        this.qlR.qlN.a(bVar);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                bVar.qlU.startAnimation(animationSet);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        bVar.qlU.startAnimation(animationSet);
    }

    public final boolean bgT() {
        if (this.qlF != 0 || this.qlG != 0) {
            return false;
        }
        int fa = this.qhy.fa();
        int fb = this.qhy.fb();
        if (fa == fb && fa == -1) {
            return false;
        }
        boolean z;
        for (int i = fb; i >= fa; i--) {
            a aVar = this.qlJ;
            i iVar = (i) aVar.qlx.get(((p) aVar.qlw.qms.get(i)).qfI);
            if (iVar instanceof x) {
                fb = ((x) iVar).bgD();
                if (fb >= 0 && fb < qlA) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z && this.ipi) {
            z = this.qhy.fb() != this.qlJ.getItemCount() + -1;
        }
        return z;
    }
}
