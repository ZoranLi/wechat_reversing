package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarChart;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarGrid;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public final class z extends a {
    private static final int qko = Color.parseColor("#26eae9e2");
    public CountDownLatch lgt;
    private RadarChart qkp;
    public Bitmap qkq;
    public Bitmap qkr;

    public z(Context context, v vVar, ViewGroup viewGroup) {
        super(context, vVar, viewGroup);
    }

    public final View bgf() {
        this.qkp = (RadarChart) this.ipu.findViewById(f.pBW);
        return this.ipu;
    }

    protected final void bgl() {
        this.lgt = new CountDownLatch(2);
        e.b(new Runnable(this) {
            final /* synthetic */ z qks;

            {
                this.qks = r1;
            }

            public final void run() {
                try {
                    this.qks.lgt.await();
                } catch (InterruptedException e) {
                }
                this.qks.ipu.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 qkt;

                    {
                        this.qkt = r1;
                    }

                    public final void run() {
                        this.qkt.qks.a(this.qkt.qks.qkq, this.qkt.qks.qkr);
                    }
                });
            }
        }, "AdlandingRadarComp").start();
        v vVar = (v) bgd();
        if (vVar != null) {
            d.a(vVar.qgi, vVar.qfJ, new a(this) {
                final /* synthetic */ z qks;

                {
                    this.qks = r1;
                }

                public final void bgn() {
                }

                public final void bgo() {
                    this.qks.qkq = null;
                    this.qks.lgt.countDown();
                }

                public final void FW(String str) {
                    try {
                        this.qks.qkq = MMBitmapFactory.decodeFile(str);
                        this.qks.lgt.countDown();
                    } catch (Throwable e) {
                        w.e("AdlandingRadarChartComp", "%s" + bg.g(e));
                    }
                }
            });
            d.a(vVar.qgp, vVar.qfJ, new a(this) {
                final /* synthetic */ z qks;

                {
                    this.qks = r1;
                }

                public final void bgn() {
                }

                public final void bgo() {
                    this.qks.qkr = null;
                    this.qks.lgt.countDown();
                }

                public final void FW(String str) {
                    try {
                        this.qks.qkr = MMBitmapFactory.decodeFile(str);
                        this.qks.lgt.countDown();
                    } catch (Throwable e) {
                        w.e("AdlandingRadarChartComp", "%s" + bg.g(e));
                    }
                }
            });
            return;
        }
        Log.wtf("AdlandingRadarChartComp", "null info");
    }

    public final void a(Bitmap bitmap, Bitmap bitmap2) {
        v vVar = (v) bgd();
        RadarChart radarChart = this.qkp;
        radarChart.qhe = 0;
        radarChart.qhg = null;
        radarChart.qgX = null;
        radarChart.qgV = null;
        this.qkp.qhf = 5;
        c cVar = new c();
        cVar.qgA = 0;
        int parseColor = Color.parseColor(vVar.qgk);
        int i = 1442840575 & parseColor;
        parseColor &= Integer.MAX_VALUE;
        cVar.backgroundColor = i;
        cVar.qgF = qko;
        cVar.qgJ = 1.0f;
        cVar.qgU = bitmap2;
        cVar.qgG = qko;
        cVar.qgH = qko;
        cVar.qgI = (float) com.tencent.mm.bg.a.fromDPToPix(this.context, 1);
        cVar.qgK = -1;
        cVar.qgM = 30.0f;
        cVar.qgL = 40.0f;
        cVar.qgQ = bitmap;
        cVar.qgR = vVar.qgj;
        cVar.qgS = Color.parseColor("#7feae9e2");
        cVar.qgT = com.tencent.mm.bg.a.fromDPToPix(this.context, 1);
        RadarChart radarChart2 = this.qkp;
        radarChart2.qgW = cVar;
        if (radarChart2.qgY != null) {
            RadarGrid radarGrid = radarChart2.qgY;
            radarGrid.qhi = cVar;
            radarGrid.invalidate();
        }
        b bVar = new b();
        bVar.qgu = qko;
        bVar.qgv = 1.0f;
        bVar.qgw = parseColor;
        bVar.qgx = 127;
        bVar.qgy = Color.parseColor("#00fcff");
        bVar.qgz = com.tencent.mm.bg.a.fromDPToPix(this.context, 2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(vVar.qgl);
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(vVar.qgn);
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(vVar.qgm);
        AbsoluteSizeSpan absoluteSizeSpan2 = new AbsoluteSizeSpan(vVar.qgo);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a aVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a(bVar);
        StringBuilder stringBuilder = new StringBuilder();
        for (v.a aVar2 : vVar.pcf) {
            if (aVar2 != null) {
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(aVar2.label).append(":").append(aVar2.qgq);
                Spannable spannableString = new SpannableString(stringBuilder.toString());
                a(spannableString, 0, aVar2.label.length() + 1, foregroundColorSpan, absoluteSizeSpan);
                a(spannableString, aVar2.label.length() + 1, stringBuilder.length(), foregroundColorSpan2, absoluteSizeSpan2);
                aVar.put(spannableString, Float.valueOf(aVar2.value));
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        try {
            this.qkp.a((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a[]) arrayList.toArray(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a[arrayList.size()]));
        } catch (Throwable e) {
            Log.getStackTraceString(e);
        }
        this.qkp.qhd = 2;
    }

    protected final int aTQ() {
        return g.pGV;
    }

    private static void a(Spannable spannable, int i, int i2, Object... objArr) {
        for (int i3 = 0; i3 < 2; i3++) {
            spannable.setSpan(objArr[i3], i, i2, 18);
        }
    }
}
