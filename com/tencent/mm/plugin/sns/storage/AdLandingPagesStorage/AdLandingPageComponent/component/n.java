package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.support.v4.view.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingControlView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.ui.al;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.smtt.sdk.WebView;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

public final class n extends i {
    private static final Map<String, Bitmap> qiG = new WeakHashMap();
    ViewPager qiH;
    a qiI;
    AdLandingControlView qiJ;
    public int qiK = 0;
    boolean qiL = true;

    static class a extends u {
        int backgroundColor;
        LayoutInflater dZ;
        Context mContext;
        k qiO;
        private int qiP = 600;
        public int qiQ = 700;
        public int qiR = 250;
        HashMap<String, View> qiS = new HashMap();
        HashMap<String, a> qiT = new HashMap();

        public class a {
            final /* synthetic */ a qiV;
            public LinkedList<i> qiZ = new LinkedList();

            public a(a aVar) {
                this.qiV = aVar;
            }
        }

        public a(Context context, LayoutInflater layoutInflater, k kVar, int i) {
            this.mContext = context;
            this.dZ = layoutInflater;
            this.qiO = kVar;
            this.backgroundColor = i;
        }

        public final int getCount() {
            return this.qiO.qfu.size();
        }

        public final boolean a(View view, Object obj) {
            return view == ((View) obj);
        }

        public final void d(Object obj) {
        }

        public final Object b(ViewGroup viewGroup, int i) {
            View inflate = this.dZ.inflate(g.pHg, viewGroup, false);
            WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
            int width = windowManager.getDefaultDisplay().getWidth();
            windowManager.getDefaultDisplay().getHeight();
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(f.pEi);
            linearLayout.setBackgroundColor(this.backgroundColor);
            a aVar = (a) this.qiT.get(String.valueOf(i));
            Iterator it;
            i a;
            if (aVar == null || aVar.qiZ.size() == 0) {
                a aVar2 = new a(this);
                it = ((j) this.qiO.qfu.get(i)).qfu.iterator();
                while (it.hasNext()) {
                    a = al.a(this.mContext, (p) it.next(), linearLayout, this.backgroundColor);
                    aVar2.qiZ.add(a);
                    linearLayout.addView(a.getView());
                }
                this.qiT.put(String.valueOf(i), aVar2);
            } else {
                it = aVar.qiZ.iterator();
                while (it.hasNext()) {
                    a = (i) it.next();
                    if (a.getView().getParent() != null && (a.getView().getParent() instanceof ViewGroup)) {
                        ((ViewGroup) a.getView().getParent()).removeView(a.getView());
                    }
                    linearLayout.addView(a.getView());
                }
            }
            ImageView imageView = (ImageView) inflate.findViewById(f.pEk);
            TextView textView = (TextView) inflate.findViewById(f.pEj);
            if (this.backgroundColor - WebView.NIGHT_MODE_COLOR <= -1 - this.backgroundColor) {
                imageView.setImageDrawable(com.tencent.mm.bg.a.a(this.mContext, e.pzW));
            } else {
                imageView.setImageDrawable(com.tencent.mm.bg.a.a(this.mContext, e.pzX));
            }
            if (this.qiO.qfw == 1) {
                imageView.setVisibility(8);
                textView.setVisibility(8);
            } else {
                if (i == this.qiO.qfu.size() - 1) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setVisibility(0);
                }
                textView.setText((i + 1) + "/" + this.qiO.qfu.size());
            }
            inflate.setLayoutParams(new LayoutParams(width, linearLayout.getMeasuredHeight()));
            inflate.setBackgroundColor(this.backgroundColor);
            viewGroup.addView(inflate);
            viewGroup.setBackgroundColor(this.backgroundColor);
            this.qiS.put(String.valueOf(i), inflate);
            return inflate;
        }

        public final void a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public final void f(final ImageView imageView) {
            Animation animationSet = new AnimationSet(true);
            Animation translateAnimation = new TranslateAnimation(0.0f, -5.0f, 0.0f, 0.0f);
            translateAnimation.setDuration((long) this.qiQ);
            translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
            animationSet.addAnimation(translateAnimation);
            translateAnimation = new AlphaAnimation(0.8f, 0.3f);
            translateAnimation.setDuration((long) this.qiQ);
            translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
            animationSet.addAnimation(translateAnimation);
            animationSet.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ a qiV;

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    Animation animationSet = new AnimationSet(true);
                    Animation translateAnimation = new TranslateAnimation(-5.0f, 0.0f, 0.0f, 0.0f);
                    translateAnimation.setDuration((long) this.qiV.qiQ);
                    translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                    translateAnimation.setStartTime((long) this.qiV.qiQ);
                    animationSet.addAnimation(translateAnimation);
                    translateAnimation = new AlphaAnimation(0.3f, 0.8f);
                    translateAnimation.setDuration((long) this.qiV.qiQ);
                    translateAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                    translateAnimation.setStartTime((long) this.qiV.qiQ);
                    animationSet.addAnimation(translateAnimation);
                    animationSet.setAnimationListener(new AnimationListener(this) {
                        final /* synthetic */ AnonymousClass1 qiW;

                        {
                            this.qiW = r1;
                        }

                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            long longValue = new BigInteger((String) imageView.getTag()).longValue();
                            if (longValue >= 3) {
                                Animation alphaAnimation = new AlphaAnimation(0.8f, 0.0f);
                                alphaAnimation.setDuration((long) this.qiW.qiV.qiR);
                                alphaAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                                alphaAnimation.setAnimationListener(new AnimationListener(this) {
                                    final /* synthetic */ AnonymousClass1 qiX;

                                    {
                                        this.qiX = r1;
                                    }

                                    public final void onAnimationStart(Animation animation) {
                                    }

                                    public final void onAnimationEnd(Animation animation) {
                                        imageView.setAlpha(0.0f);
                                    }

                                    public final void onAnimationRepeat(Animation animation) {
                                    }
                                });
                                imageView.startAnimation(alphaAnimation);
                                return;
                            }
                            imageView.setTag(String.valueOf(longValue + 1));
                            this.qiW.qiV.f(imageView);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    });
                    imageView.startAnimation(animationSet);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            imageView.startAnimation(animationSet);
        }

        public final void tr(int i) {
            View view = (View) this.qiS.get(String.valueOf(i));
            if (view != null) {
                final ImageView imageView = (ImageView) view.findViewById(f.pEk);
                if (imageView != null && imageView.getVisibility() == 0) {
                    if (imageView.getTag() == null || !(imageView.getTag() instanceof String) || new BigInteger((String) imageView.getTag()).longValue() < 1) {
                        imageView.setTag("1");
                        Animation alphaAnimation = new AlphaAnimation(0.0f, 0.8f);
                        alphaAnimation.setDuration((long) this.qiP);
                        alphaAnimation.setInterpolator(new DecelerateInterpolator(1.2f));
                        alphaAnimation.setAnimationListener(new AnimationListener(this) {
                            final /* synthetic */ a qiV;

                            public final void onAnimationStart(Animation animation) {
                            }

                            public final void onAnimationEnd(Animation animation) {
                                new ae().postDelayed(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass2 qiY;

                                    {
                                        this.qiY = r1;
                                    }

                                    public final void run() {
                                        this.qiY.qiV.f(imageView);
                                    }
                                }, 200);
                            }

                            public final void onAnimationRepeat(Animation animation) {
                            }
                        });
                        imageView.startAnimation(alphaAnimation);
                    }
                }
            }
        }

        public final void ts(int i) {
            for (String str : this.qiT.keySet()) {
                a aVar = (a) this.qiT.get(str);
                if (!(aVar == null || aVar.qiZ.size() == 0)) {
                    int i2;
                    i iVar;
                    if (str.equals(String.valueOf(i))) {
                        for (i2 = 0; i2 < aVar.qiZ.size(); i2++) {
                            iVar = (i) aVar.qiZ.get(i2);
                            if (!iVar.qie) {
                                iVar.bfP();
                            }
                        }
                    } else {
                        for (i2 = 0; i2 < aVar.qiZ.size(); i2++) {
                            iVar = (i) aVar.qiZ.get(i2);
                            if (iVar.qie) {
                                iVar.bfQ();
                            }
                        }
                    }
                }
            }
        }
    }

    public n(Context context, k kVar, ViewGroup viewGroup) {
        super(context, kVar, viewGroup);
        this.qiJ = new AdLandingControlView(context);
    }

    public final void bfP() {
        this.qiI.tr(this.qiH.ys);
        if (this.qiL) {
            this.qiI.ts(0);
            this.qiL = false;
        } else {
            this.qiI.ts(this.qiK);
        }
        super.bfP();
    }

    public final void bfQ() {
        this.qiI.ts(-1);
        super.bfQ();
    }

    protected final void bgl() {
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        int width = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
        final u aVar = new a(this.context, layoutInflater, (k) this.qib, this.backgroundColor);
        this.qiH.zb = new ViewPager.e(this) {
            final /* synthetic */ n qiN;

            public final void a(int i, float f, int i2) {
            }

            public final void V(int i) {
                this.qiN.qiJ.tu(i);
                this.qiN.qiK = i;
                if (this.qiN.qie) {
                    aVar.tr(i);
                    aVar.ts(i);
                }
            }

            public final void W(int i) {
            }
        };
        this.qiH.a(aVar);
        this.qiJ.dY(((k) this.qib).qfu.size(), 0);
        if (((k) this.qib).qfx) {
            this.qiH.setLayoutParams(new LayoutParams(width, height));
        } else if (((k) this.qib).qfu.size() > 0) {
            j jVar = (j) ((k) this.qib).qfu.get(0);
            new LinearLayout(this.context).setOrientation(1);
            int i = 0;
            Iterator it = jVar.qfu.iterator();
            while (it.hasNext()) {
                p pVar = (p) it.next();
                int i2 = (int) (((float) i) + pVar.qfK);
                if (pVar instanceof r) {
                    r rVar = (r) pVar;
                    View inflate = layoutInflater.inflate(g.pHf, null);
                    inflate.setBackgroundColor(this.backgroundColor);
                    ((TextView) inflate.findViewById(f.pDW)).setText(rVar.qgb);
                    ((TextView) inflate.findViewById(f.pDW)).measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                    i = ((TextView) inflate.findViewById(f.pDW)).getPaddingBottom() + ((i2 + ((TextView) inflate.findViewById(f.pDW)).getPaddingTop()) + ((TextView) inflate.findViewById(f.pDW)).getHeight());
                } else if (pVar instanceof i) {
                    Button button = (Button) layoutInflater.inflate(g.pGX, null).findViewById(f.pEb);
                    button.setText(((i) pVar).title);
                    button.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                    i = button.getPaddingBottom() + ((button.getPaddingTop() + i2) + button.getHeight());
                } else if (pVar instanceof m) {
                    float f = 0.0f;
                    float f2 = 0.0f;
                    float f3 = pVar.qfK;
                    float f4 = pVar.qfL;
                    if (pVar instanceof m) {
                        m mVar = (m) pVar;
                        f = mVar.height;
                        f2 = mVar.width;
                    }
                    if (((int) f) == 0 || ((int) f2) == 0) {
                        i = i2 + height;
                    } else {
                        i = (int) (((f * ((float) width)) / f2) + ((float) i2));
                    }
                    i = (int) (((float) ((int) (((float) i) + f3))) + f4);
                } else if (pVar instanceof l) {
                    i = i2 + height;
                } else if (pVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n) {
                    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n nVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n) pVar;
                    if (nVar.qfF == 1) {
                        i = i2 + height;
                    } else if (((int) nVar.width) > 0) {
                        i = ((((int) nVar.height) * width) / ((int) nVar.width)) + i2;
                    } else {
                        i = (int) (nVar.height + ((float) i2));
                    }
                } else if (pVar instanceof t) {
                    t tVar = (t) pVar;
                    if (tVar.qgh != 1) {
                        i = i2 + height;
                    } else if (((int) tVar.width) > 0) {
                        i = ((((int) tVar.height) * width) / ((int) tVar.width)) + i2;
                    } else {
                        i = (int) (tVar.height + ((float) i2));
                    }
                } else if (pVar instanceof s) {
                    i = i2 + height;
                } else {
                    i = i2;
                }
                i = (int) (pVar.qfL + ((float) i));
            }
            this.qiH.setLayoutParams(new LayoutParams(width, i));
        }
        this.qiI = aVar;
    }

    public final View bgf() {
        View view = this.ipu;
        this.qiH = (ViewPager) view.findViewById(f.pEn);
        this.qiJ = (AdLandingControlView) view.findViewById(f.pDX);
        return view;
    }

    protected final int aTQ() {
        return g.pHh;
    }

    public final boolean J(JSONObject jSONObject) {
        if (super.J(jSONObject)) {
            return true;
        }
        return false;
    }

    public final LinkedList<JSONObject> bgx() {
        a aVar = this.qiI;
        LinkedList<JSONObject> linkedList = new LinkedList();
        for (String str : aVar.qiT.keySet()) {
            a aVar2 = (a) aVar.qiT.get(str);
            if (!(aVar2 == null || aVar2.qiZ.size() == 0)) {
                for (int i = 0; i < aVar2.qiZ.size(); i++) {
                    i iVar = (i) aVar2.qiZ.get(i);
                    JSONObject jSONObject = new JSONObject();
                    if (iVar.J(jSONObject)) {
                        linkedList.add(jSONObject);
                    }
                }
            }
        }
        return linkedList;
    }
}
