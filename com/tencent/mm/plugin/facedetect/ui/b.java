package com.tencent.mm.plugin.facedetect.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.l;
import android.support.v4.app.o;
import android.support.v4.view.ViewPager;
import android.support.v4.view.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;

public final class b {
    public View kHP;
    u lAo;
    public a lAp;
    Button lyE;
    public Animation lyH;
    public ViewPager xF;

    interface a {
        void ast();

        void onCancel();
    }

    private class b extends o {
        final /* synthetic */ b lAq;

        public b(b bVar, l lVar) {
            this.lAq = bVar;
            super(lVar);
        }

        public final Fragment I(int i) {
            switch (i) {
                case 0:
                    return new c(this.lAq);
                default:
                    throw new InvalidParameterException("hy: invalid page status");
            }
        }

        public final int getCount() {
            return 1;
        }
    }

    @SuppressLint({"ValidFragment"})
    public static class c extends Fragment {
        private View kHP = null;
        private Button lAs = null;
        public WeakReference<b> lAt;

        public c(b bVar) {
            w.d("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: TutorialTwo constructed");
            this.lAt = new WeakReference(bVar);
        }

        public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.kHP = layoutInflater.inflate(g.ltC, viewGroup, false);
            this.lAs = (Button) this.kHP.findViewById(e.ltg);
            this.lAs.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ c lAu;

                {
                    this.lAu = r1;
                }

                public final void onClick(View view) {
                    if (this.lAu.lAt.get() != null) {
                        b bVar = (b) this.lAu.lAt.get();
                        if (bVar.lAp != null) {
                            bVar.lAp.ast();
                        }
                        bVar.dismiss();
                        return;
                    }
                    w.e("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: lost tutorial instance");
                }
            });
            return this.kHP;
        }

        public final void onCreate(Bundle bundle) {
            super.onCreate(bundle);
        }

        public final void onDestroy() {
            super.onDestroy();
            w.i("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: TutorialTwo onDestroy");
        }
    }

    public b() {
        this.kHP = null;
        this.lyH = null;
        this.lyH = AnimationUtils.loadAnimation(ab.getContext(), com.tencent.mm.plugin.facedetect.a.a.aQK);
        this.lyH.setDuration(500);
    }

    public final void dismiss() {
        if (this.kHP.getVisibility() == 0) {
            af.v(new Runnable(this) {
                final /* synthetic */ b lAq;

                {
                    this.lAq = r1;
                }

                public final void run() {
                    this.lAq.lyH.setAnimationListener(new AnimationListener(this) {
                        final /* synthetic */ AnonymousClass3 lAr;

                        {
                            this.lAr = r1;
                        }

                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            this.lAr.lAq.kHP.setVisibility(8);
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }
                    });
                    this.lAq.kHP.startAnimation(this.lAq.lyH);
                }
            });
        }
    }
}
