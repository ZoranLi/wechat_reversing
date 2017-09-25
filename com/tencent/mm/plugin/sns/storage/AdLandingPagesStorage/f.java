package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mm.i.g;
import com.tencent.mm.modelcontrol.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.b;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class f {
    private static f qmI = new f();
    ConcurrentLinkedQueue<String> qmH = new ConcurrentLinkedQueue();

    public static f bgX() {
        return qmI;
    }

    private f() {
    }

    private boolean Gc(String str) {
        return this.qmH.contains(str);
    }

    public final void Gd(String str) {
        this.qmH.remove(str);
    }

    public final void a(String str, p pVar) {
        if (pVar.qfJ == 101) {
            Iterator it = ((k) pVar).qfu.iterator();
            while (it.hasNext()) {
                Iterator it2 = ((j) it.next()).qfu.iterator();
                while (it2.hasNext()) {
                    a(str, (p) it2.next());
                }
            }
        } else if (pVar.qfJ == 41) {
            r0 = (m) pVar;
            if (!Gc(r0.qfy)) {
                this.qmH.add(r0.qfy);
                d.a(str, r0.qfy, true, pVar.qfJ, 0, new a(this) {
                    final /* synthetic */ f qmK;

                    public final void bgn() {
                    }

                    public final void bgo() {
                        w.e("AdLandingPagesPreDownloadResHelper", " pre download " + r0.qfy + "is error");
                        this.qmK.Gd(r0.qfy);
                    }

                    public final void FW(String str) {
                        this.qmK.Gd(r0.qfy);
                    }
                });
            }
        } else if (pVar.qfJ == 44) {
            final l lVar = (l) pVar;
            if (!Gc(lVar.qfy)) {
                this.qmH.add(lVar.qfy);
                d.a(str, lVar.qfy, true, pVar.qfJ, 0, new a(this) {
                    final /* synthetic */ f qmK;

                    public final void bgn() {
                    }

                    public final void bgo() {
                        w.e("AdLandingPagesPreDownloadResHelper", " pre download " + lVar.qfy + "is error");
                        this.qmK.Gd(lVar.qfy);
                    }

                    public final void FW(String str) {
                        this.qmK.Gd(lVar.qfy);
                    }
                });
            }
        } else if (pVar.qfJ == 45) {
            r0 = (m) pVar;
            if (!Gc(r0.qfy)) {
                this.qmH.add(r0.qfy);
                d.a(str, r0.qfy, true, pVar.qfJ, 0, new a(this) {
                    final /* synthetic */ f qmK;

                    public final void bgn() {
                    }

                    public final void bgo() {
                        w.e("AdLandingPagesPreDownloadResHelper", " pre download " + r0.qfy + "is error");
                        this.qmK.Gd(r0.qfy);
                    }

                    public final void FW(String str) {
                        this.qmK.Gd(r0.qfy);
                    }
                });
            }
        } else if (pVar.qfJ == 61) {
            final n nVar = (n) pVar;
            if (!Gc(nVar.qfz)) {
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                c.Er();
                if (c.a(pInt, pInt2)) {
                    this.qmH.add(nVar.qfz);
                    d.a(str, nVar.qfz, true, 61, new a(this) {
                        final /* synthetic */ f qmK;

                        public final void bgn() {
                        }

                        public final void bgo() {
                            w.e("AdLandingPagesPreDownloadResHelper", " pre download " + nVar.qfz + "is error");
                            this.qmK.Gd(nVar.qfz);
                        }

                        public final void FW(String str) {
                            this.qmK.Gd(nVar.qfz);
                        }
                    });
                }
            }
            if (!Gc(nVar.qfA)) {
                this.qmH.add(nVar.qfA);
                d.a(str, nVar.qfA, true, 1000000001, 0, new a(this) {
                    final /* synthetic */ f qmK;

                    public final void bgn() {
                    }

                    public final void bgo() {
                        w.e("AdLandingPagesPreDownloadResHelper", " pre download " + nVar.qfA + "is error");
                        this.qmK.Gd(nVar.qfA);
                    }

                    public final void FW(String str) {
                        this.qmK.Gd(nVar.qfA);
                    }
                });
            }
        } else if (pVar.qfJ == 62) {
            boolean z = g.sV().getInt("SnsAdNativePagePreloadStreamMedia", 0) > 0;
            w.i("AdLandingPagesPreDownloadResHelper", "pre down video value: " + z);
            final t tVar = (t) pVar;
            if (z && !Gc(tVar.qfB)) {
                this.qmH.add(tVar.qfB);
                d.a(str, tVar.qfB, true, pVar.qfJ, new b(this) {
                    final /* synthetic */ f qmK;

                    public final void FY(String str) {
                        w.e("AdLandingPagesPreDownloadResHelper", " pre download " + tVar.qfB + "is error");
                        this.qmK.Gd(tVar.qfB);
                    }

                    public final void FZ(String str) {
                        this.qmK.Gd(tVar.qfB);
                    }
                });
            }
            if (!Gc(tVar.qgg)) {
                this.qmH.add(tVar.qgg);
                d.a("adId", tVar.qgg, true, pVar.qfJ, 0, new a(this) {
                    final /* synthetic */ f qmK;

                    public final void bgn() {
                    }

                    public final void bgo() {
                        w.e("AdLandingPagesPreDownloadResHelper", " pre download " + tVar.qgg + "is error");
                        this.qmK.Gd(tVar.qfB);
                    }

                    public final void FW(String str) {
                        this.qmK.Gd(tVar.qgg);
                    }
                });
            }
        }
    }

    public final void d(final String str, String str2, String str3, int i) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) ab.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        LinkedList k = e.k(str2, str3, "", "");
        int i2;
        int i3;
        Iterator it;
        int i4;
        c cVar;
        Iterator it2;
        final p pVar;
        if (i == 0) {
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
                w.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in no wifi");
                i2 = g.sV().getInt("SnsAdNativePageNormalFeedPreloadPageCount", 1);
                i3 = g.sV().getInt("SnsAdNativePageNormalFeedPreloadResourceCount", 2);
                if (k.size() > 0) {
                    it = k.iterator();
                    i4 = i2;
                    while (it.hasNext()) {
                        cVar = (c) it.next();
                        if (i3 > 0 && i4 > 0) {
                            it2 = cVar.qms.iterator();
                            while (it2.hasNext()) {
                                pVar = (p) it2.next();
                                af.v(new Runnable(this) {
                                    final /* synthetic */ f qmK;

                                    public final void run() {
                                        this.qmK.a(str, pVar);
                                    }
                                });
                                i2 = i3 - 1;
                                if (i2 <= 0) {
                                    break;
                                }
                                i3 = i2;
                            }
                            i2 = i3;
                            i4--;
                            i3 = i2;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            w.i("AdLandingPagesPreDownloadResHelper", "start pre download all resource in wifi");
            Iterator it3 = k.iterator();
            while (it3.hasNext()) {
                Iterator it4 = ((c) it3.next()).qms.iterator();
                while (it4.hasNext()) {
                    a(str, (p) it4.next());
                }
            }
        } else if (i == 1) {
            w.i("AdLandingPagesPreDownloadResHelper", "start pre download first pages resource");
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
                w.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in shared scene in no wifi,this can't download everything");
                return;
            }
            w.i("AdLandingPagesPreDownloadResHelper", "start pre download resource in shared scene in wifi");
            i2 = g.sV().getInt("SnsAdNativePageForwardFeedPreloadPageCount", 1);
            i3 = g.sV().getInt("SnsAdNativePageForwardFeedPreloadResourceCount", 2);
            if (k.size() > 0) {
                it = k.iterator();
                i4 = i2;
                while (it.hasNext()) {
                    cVar = (c) it.next();
                    if (i3 > 0 && i4 > 0) {
                        it2 = cVar.qms.iterator();
                        while (it2.hasNext()) {
                            pVar = (p) it2.next();
                            af.v(new Runnable(this) {
                                final /* synthetic */ f qmK;

                                public final void run() {
                                    this.qmK.a(str, pVar);
                                }
                            });
                            i2 = i3 - 1;
                            if (i2 <= 0) {
                                break;
                            }
                            i3 = i2;
                        }
                        i2 = i3;
                        i4--;
                        i3 = i2;
                    } else {
                        return;
                    }
                }
            }
        } else {
            w.e("AdLandingPagesPreDownloadResHelper", "the dwnloadKind is error");
        }
    }
}
