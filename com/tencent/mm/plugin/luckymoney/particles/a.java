package com.tencent.mm.plugin.luckymoney.particles;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.particles.a.b;
import java.util.Iterator;

public final class a {
    private static int nof;
    private static int nog;
    private static int noh;
    private static int noi;
    private static int noj;
    private static int nok;
    public c nol;

    public a(ViewGroup viewGroup) {
        if (nof == 0) {
            Resources resources = viewGroup.getResources();
            nof = resources.getDimensionPixelSize(R.f.aZs);
            nog = resources.getDimensionPixelOffset(R.f.aZw);
            noh = resources.getDimensionPixelOffset(R.f.aZv);
            noi = resources.getDimensionPixelOffset(R.f.aZu);
            noj = resources.getDimensionPixelOffset(R.f.aZx);
            nok = resources.getDimensionPixelOffset(R.f.aZt);
        }
    }

    public static a a(ViewGroup viewGroup, b bVar) {
        a aVar = new a(viewGroup);
        c X = new c(viewGroup.getContext(), bVar, new d(viewGroup.getWidth() / 2, viewGroup.getHeight() + 400), viewGroup).t(0.0f, 800.0f).u(-2000.0f, 1250.0f).X(2000.0f);
        X.noU = 3000.0f;
        X.noV = 500.0f;
        X = X.aIb();
        X.nox = e.aIf();
        aVar.nol = X.aIc().aId();
        return aVar;
    }

    public final c w(int i, long j) {
        c cVar = this.nol;
        cVar.not = 0;
        cVar.nou = j;
        cVar.nov = ((float) i) / 1000.0f;
        cVar.now = 1.0f / cVar.nov;
        if (cVar.jsj != null) {
            cVar.jsj.cancel();
        }
        cVar.nos = 0;
        Iterator it = cVar.nor.iterator();
        while (it.hasNext()) {
            cVar.noq.add(it.next());
            it.remove();
        }
        ViewParent parent = cVar.nop.getParent();
        if (parent != null) {
            if (parent != cVar.noo) {
                ((ViewGroup) parent).removeView(cVar.nop);
            }
            cVar.nop.npb = false;
            cVar.x(cVar.not, 0);
            cVar.jsj = ValueAnimator.ofInt(new int[]{0}).setDuration(Long.MAX_VALUE);
            cVar.jsj.addUpdateListener(new AnimatorUpdateListener(cVar) {
                final /* synthetic */ c noW;

                {
                    this.noW = r1;
                }

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    long currentPlayTime = valueAnimator.getCurrentPlayTime();
                    c cVar = this.noW;
                    if (currentPlayTime < cVar.nou) {
                        if (cVar.nos == 0) {
                            cVar.nos = currentPlayTime;
                        } else {
                            int nextFloat = (int) ((cVar.random.nextFloat() * cVar.nov) * ((float) (currentPlayTime - cVar.nos)));
                            if (nextFloat > 0) {
                                cVar.nos = (long) (((float) cVar.nos) + (cVar.now * ((float) nextFloat)));
                                cVar.x(nextFloat, currentPlayTime);
                            }
                        }
                    }
                    c cVar2 = this.noW;
                    Iterator it = cVar2.nor.iterator();
                    while (it.hasNext()) {
                        b bVar = (b) it.next();
                        if (bVar.npk == -1) {
                            bVar.npk = currentPlayTime;
                        }
                        long j = currentPlayTime - bVar.npk;
                        bVar.npz = j >= 0;
                        if (bVar.npz && !bVar.npb) {
                            bVar.npw = b.a(j, bVar.npl, bVar.npn, bVar.noD, bVar.npp, bVar.noH);
                            bVar.npx = b.a(j, bVar.npm, bVar.npo, bVar.noF, bVar.npq, bVar.noJ);
                            bVar.npy = b.a(j, bVar.npr, bVar.nps, bVar.noP, bVar.npt, bVar.noR);
                            if (bVar.nox != null) {
                                bVar.alpha = (int) (bVar.nox.getInterpolation(((float) j) / bVar.npu) * 255.0f);
                            } else {
                                bVar.alpha = 255;
                            }
                            boolean z = !bVar.npA && ((float) j) >= bVar.npu;
                            bVar.npb = z;
                            bVar.npv = Math.min(1.0f, ((float) j) / bVar.npu);
                        }
                        if ((!bVar.npb ? 1 : null) == null) {
                            it.remove();
                            cVar2.noq.add(bVar);
                        }
                    }
                    if (this.noW.nor.size() != 0 || currentPlayTime < this.noW.nou) {
                        this.noW.nop.invalidate();
                    } else {
                        this.noW.aIe();
                    }
                }
            });
            cVar.jsj.start();
            return cVar;
        }
        cVar.noo.addView(cVar.nop);
        cVar.nop.npb = false;
        cVar.x(cVar.not, 0);
        cVar.jsj = ValueAnimator.ofInt(new int[]{0}).setDuration(Long.MAX_VALUE);
        cVar.jsj.addUpdateListener(/* anonymous class already generated */);
        cVar.jsj.start();
        return cVar;
    }
}
