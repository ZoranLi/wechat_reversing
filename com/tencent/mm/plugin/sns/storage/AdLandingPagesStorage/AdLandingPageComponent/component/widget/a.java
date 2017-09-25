package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.Surface;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.mm.e.a.qv;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class a {
    private static HashMap<String, WeakReference<Bitmap>> pul = new HashMap();
    public static Map<String, Integer> pup = new ConcurrentHashMap();
    public boolean hRa;
    public ae jsW;
    public boolean mNI;
    public Surface nIX;
    public int position;
    public int ptM;
    public int ptN;
    public String ptO;
    public String ptP;
    public int ptQ;
    protected int ptR;
    public Bitmap ptS;
    public Bitmap ptT;
    public Bitmap ptU;
    public WeakReference<View> ptV;
    public WeakReference<TextView> ptW;
    public long ptX;
    public WeakReference<View> ptY;
    public Animation ptZ;
    public Animation pua;
    boolean puj;
    public boolean puk;
    public boolean pum;
    double pun;
    boolean puo;
    public double puq;
    public boolean pur;
    public boolean pus;
    volatile h qkI;
    public volatile b qkJ;
    public volatile i qkK;
    public volatile c qkL;
    private k qkM;
    public j qkN;
    private d qkO;
    private a qkP;
    public e qkQ;
    public f qkR;
    public g qkS;

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ double puy;
        final /* synthetic */ a qkT;

        AnonymousClass2(a aVar, double d) {
            this.qkT = aVar;
            this.puy = d;
        }

        public final void run() {
            w.i("MicroMsg.SightPlayController", "SeekToFrame   %f  %s", new Object[]{Double.valueOf(this.puy), bg.bJZ().toString()});
            this.qkT.puq = this.puy;
        }
    }

    private static class a extends com.tencent.mm.sdk.b.c<qv> {
        int lHi = 0;
        int puA = 0;
        WeakReference<a> puB;
        int puz = 0;

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b r9) {
            /*
            r8 = this;
            r7 = 2;
            r6 = 1;
            r5 = 0;
            r9 = (com.tencent.mm.e.a.qv) r9;
            r0 = r8.puB;
            r0 = r0.get();
            if (r0 == 0) goto L_0x007e;
        L_0x000d:
            r1 = "MicroMsg.SightPlayController";
            r2 = "#0x%x on chatting status callback, type %d, selfPos %d, visiblePos[%d, %d], headerCount %d recording %B";
            r0 = 7;
            r3 = new java.lang.Object[r0];
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0 = r0.hashCode();
            r0 = java.lang.Integer.valueOf(r0);
            r3[r5] = r0;
            r0 = r9.fXQ;
            r0 = r0.type;
            r0 = java.lang.Integer.valueOf(r0);
            r3[r6] = r0;
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0 = r0.position;
            r0 = java.lang.Integer.valueOf(r0);
            r3[r7] = r0;
            r0 = 3;
            r4 = r9.fXQ;
            r4 = r4.fXR;
            r4 = java.lang.Integer.valueOf(r4);
            r3[r0] = r4;
            r0 = 4;
            r4 = r9.fXQ;
            r4 = r4.fXS;
            r4 = java.lang.Integer.valueOf(r4);
            r3[r0] = r4;
            r0 = 5;
            r4 = r9.fXQ;
            r4 = r4.fXT;
            r4 = java.lang.Integer.valueOf(r4);
            r3[r0] = r4;
            r4 = 6;
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0 = r0.pus;
            r0 = java.lang.Boolean.valueOf(r0);
            r3[r4] = r0;
            com.tencent.mm.sdk.platformtools.w.d(r1, r2, r3);
            r0 = r9.fXQ;
            r0 = r0.type;
            switch(r0) {
                case 0: goto L_0x00b7;
                case 1: goto L_0x0095;
                case 2: goto L_0x007e;
                case 3: goto L_0x007f;
                case 4: goto L_0x007e;
                case 5: goto L_0x00d8;
                case 6: goto L_0x008b;
                case 7: goto L_0x00a1;
                default: goto L_0x007e;
            };
        L_0x007e:
            return r5;
        L_0x007f:
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0.clear();
            goto L_0x007e;
        L_0x008b:
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0.pus = r6;
        L_0x0095:
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0.ha(r5);
            goto L_0x007e;
        L_0x00a1:
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0 = r0.pus;
            if (r0 == 0) goto L_0x007e;
        L_0x00ad:
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0.pus = r5;
        L_0x00b7:
            r8.a(r9);
            r0 = r8.bcf();
            if (r0 == 0) goto L_0x007e;
        L_0x00c0:
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0 = r0.pus;
            if (r0 != 0) goto L_0x007e;
        L_0x00cc:
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0.restart();
            goto L_0x007e;
        L_0x00d8:
            r8.a(r9);
            r0 = r8.bcf();
            if (r0 == 0) goto L_0x0188;
        L_0x00e1:
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0 = r0.pus;
            if (r0 != 0) goto L_0x0188;
        L_0x00ed:
            r1 = "ERROR#PATH";
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0 = r0.ptP;
            r0 = r1.equals(r0);
            if (r0 != 0) goto L_0x016f;
        L_0x0100:
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r1 = r0.ptO;
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0 = r0.ptP;
            r0 = r1.equals(r0);
            if (r0 != 0) goto L_0x016f;
        L_0x011a:
            r1 = "MicroMsg.SightPlayController";
            r2 = "match diff path, change %s to %s";
            r3 = new java.lang.Object[r7];
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0 = r0.ptO;
            r3[r5] = r0;
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0 = r0.ptP;
            r3[r6] = r0;
            com.tencent.mm.sdk.platformtools.w.d(r1, r2, r3);
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0 = r0.ptP;
            if (r0 != 0) goto L_0x017c;
        L_0x0149:
            r0 = "";
            r1 = r0;
        L_0x014d:
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0.clear();
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0.ptO = r1;
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r1 = "ERROR#PATH";
            r0.ptP = r1;
        L_0x016f:
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0.restart();
            goto L_0x007e;
        L_0x017c:
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0 = r0.ptP;
            r1 = r0;
            goto L_0x014d;
        L_0x0188:
            r0 = r8.puB;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0.clear();
            goto L_0x007e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.a.a(com.tencent.mm.sdk.b.b):boolean");
        }

        public a(a aVar) {
            super(0);
            this.puB = new WeakReference(aVar);
            this.usg = qv.class.getName().hashCode();
        }

        private void a(qv qvVar) {
            this.puz = qvVar.fXQ.fXT;
            this.puA = qvVar.fXQ.fXR;
            this.lHi = qvVar.fXQ.fXS;
        }

        private boolean bcf() {
            if (this.puB.get() == null) {
                return false;
            }
            int i = ((a) this.puB.get()).position + this.puz;
            if (i < this.puA || i > this.lHi) {
                return false;
            }
            return true;
        }
    }

    private class b implements Runnable {
        volatile boolean nDu = false;
        final /* synthetic */ a qkT;
        c qkU;

        public b(a aVar) {
            this.qkT = aVar;
        }

        public final void run() {
            if (!(this.qkT.qkS == null || this.qkT.qkS.bch() == null || this.qkT.qkS.bch().getVisibility() != 0)) {
                this.qkT.jsW.post(new Runnable(this) {
                    final /* synthetic */ b qkV;

                    {
                        this.qkV = r1;
                    }

                    public final void run() {
                        this.qkV.qkT.qkS.bch().setVisibility(8);
                    }
                });
            }
            if (this.qkT.ptQ < 0) {
                w.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id, path %s", new Object[]{Integer.valueOf(this.qkT.hashCode()), Integer.valueOf(hashCode()), this.qkT.ptO});
            } else if (this.nDu) {
                w.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at beg", new Object[]{Integer.valueOf(this.qkT.hashCode()), Integer.valueOf(hashCode())});
            } else {
                float f;
                double bck;
                if (this.qkT.ptX == 0) {
                    if (this.qkT.qkK != null) {
                        this.qkT.qkK.type = 1;
                        this.qkT.qkK.run();
                    }
                    this.qkT.ptX = System.currentTimeMillis();
                }
                Object obj = null;
                if (this.qkT.puq != -1.0d) {
                    if (this.qkT.puk) {
                        if (this.qkT.qkK != null) {
                            this.qkT.qkK.type = 4;
                            this.qkT.qkK.puq = this.qkT.puq;
                            this.qkT.qkK.run();
                            this.qkT.jsW.postDelayed(new Runnable(this) {
                                final /* synthetic */ b qkV;

                                {
                                    this.qkV = r1;
                                }

                                public final void run() {
                                    this.qkV.qkT.pur = true;
                                }
                            }, 100);
                        } else if (SightVideoJNI.seekStream(this.qkT.puq, this.qkT.ptQ) > 0) {
                            if (this.qkT.qkK == null) {
                                this.qkT.qkK = new i(this.qkT);
                            }
                            this.qkT.qkK.type = 4;
                            this.qkT.qkK.puq = this.qkT.puq;
                            this.qkT.qkK.run();
                            obj = 1;
                        }
                    } else if (SightVideoJNI.seekStream(this.qkT.puq, this.qkT.ptQ) > 0) {
                        if (this.qkT.qkK == null) {
                            this.qkT.qkK = new i(this.qkT);
                        }
                        this.qkT.qkK.type = 4;
                        this.qkT.qkK.puq = this.qkT.puq;
                        this.qkT.qkK.run();
                        obj = 1;
                    }
                }
                float currentTimeMillis = (float) (System.currentTimeMillis() - this.qkT.ptX);
                if (obj != null) {
                    f = 0.0f;
                } else {
                    f = (currentTimeMillis / ((float) this.qkT.ptR)) + 0.5f;
                }
                if (this.qkT.puk && this.qkT.pur) {
                    this.qkT.pur = false;
                    if (this.qkT.qkK != null) {
                        bck = this.qkT.qkK.bck() / 1000.0d;
                        if (SightVideoJNI.seekStream(bck, this.qkT.ptQ) > 0) {
                            f = 0.0f;
                            w.i("MicroMsg.SightPlayController", "seek to " + bck + " modify time : 0.0");
                        }
                    }
                }
                float f2 = f;
                if (this.qkT.hRa) {
                    w.i("MicroMsg.SightPlayController", "#0x%x video %d id passedTime:  %s  seek  %s", new Object[]{Integer.valueOf(this.qkT.hashCode()), Integer.valueOf(this.qkT.ptQ), Float.valueOf(currentTimeMillis), Float.valueOf(f2)});
                }
                this.qkT.ptX = System.currentTimeMillis();
                if (f2 >= 2.0f) {
                    a aVar = this.qkT;
                    aVar.ptM++;
                } else {
                    this.qkT.ptM = Math.max(0, this.qkT.ptM - 1);
                }
                if (this.qkT.bca()) {
                    w.e("MicroMsg.SightPlayController", "match tolerate bad seek times %d", new Object[]{Integer.valueOf(this.qkT.ptM)});
                    this.qkT.clear();
                    return;
                }
                int i;
                Object obj2 = null;
                int i2 = 0;
                if (1 == this.qkT.ptN) {
                    Object obj3;
                    if (this.qkT.nIX == null || this.qkT.nIX.isValid()) {
                        i2 = SightVideoJNI.drawSurfaceFrame(this.qkT.ptQ, this.qkT.nIX, (int) f2, this.qkT.ptT, this.qkT.mNI);
                        if (this.qkT.qkR != null) {
                            bck = SightVideoJNI.getVideoPlayTime(this.qkT.ptQ);
                            i = (int) bck;
                            if (i != ((int) this.qkT.pun)) {
                                this.qkT.qkR.dy((long) i);
                            }
                            this.qkT.pun = bck;
                        }
                        if (i2 == 0) {
                            this.qkT.puq = -1.0d;
                            obj3 = null;
                        } else if (1 == i2) {
                            this.qkT.puq = -1.0d;
                            obj3 = 1;
                            this.qkT.ptX = 0;
                            this.qkT.bcc();
                        } else if (-7 == i2) {
                            w.w("MicroMsg.SightPlayController", "surface is null, continue");
                            obj3 = null;
                        } else {
                            w.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error:%d", new Object[]{Integer.valueOf(this.qkT.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2)});
                            this.nDu = true;
                            if (this.qkU != null) {
                                this.qkU.nDu = true;
                            }
                            this.qkT.bgG();
                            if (this.qkT.qkQ != null) {
                                this.qkT.qkQ.tv(-1);
                            }
                            obj3 = null;
                        }
                    } else {
                        w.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error, surface is not valid", new Object[]{Integer.valueOf(this.qkT.hashCode()), Integer.valueOf(hashCode())});
                        this.nDu = true;
                        if (this.qkU != null) {
                            this.qkU.nDu = true;
                            obj3 = null;
                        }
                        obj3 = null;
                    }
                    if (this.qkT.qkK != null) {
                        w.d("MicroMsg.SightPlayController", "voice time is" + (this.qkT.qkK.bck() / 1000.0d));
                        obj2 = obj3;
                    } else {
                        obj2 = obj3;
                    }
                } else {
                    i2 = SightVideoJNI.drawFrame(this.qkT.ptQ, this.qkT.ptS, (int) f2, null, false, this.qkT.mNI);
                    if (this.qkT.qkR != null) {
                        bck = SightVideoJNI.getVideoPlayTime(this.qkT.ptQ);
                        i = (int) bck;
                        if (i != ((int) this.qkT.pun)) {
                            this.qkT.qkR.dy((long) i);
                        }
                        this.qkT.pun = bck;
                        if (this.qkT.hRa) {
                            w.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[]{Integer.valueOf(this.qkT.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2), Double.valueOf(bck)});
                        }
                    } else if (this.qkT.hRa) {
                        bck = SightVideoJNI.getVideoPlayTime(this.qkT.ptQ);
                        if (this.qkT.hRa) {
                            w.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[]{Integer.valueOf(this.qkT.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2), Double.valueOf(bck)});
                        }
                    } else if (this.qkT.hRa) {
                        w.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d", new Object[]{Integer.valueOf(this.qkT.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2)});
                    }
                    if (i2 == 0) {
                        this.qkT.puq = -1.0d;
                    } else if (1 == i2) {
                        this.qkT.puq = -1.0d;
                        obj2 = 1;
                        this.qkT.ptX = 0;
                        this.qkT.bcc();
                    } else {
                        this.qkT.puq = -1.0d;
                        w.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw bitmap match error:%d", new Object[]{Integer.valueOf(this.qkT.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2)});
                        this.nDu = true;
                        if (this.qkU != null) {
                            this.qkU.nDu = true;
                        }
                        this.qkT.jsW.post(new Runnable(this) {
                            final /* synthetic */ b qkV;

                            {
                                this.qkV = r1;
                            }

                            public final void run() {
                                this.qkV.qkT.A(null);
                            }
                        });
                        if (this.qkT.qkQ != null) {
                            this.qkT.qkQ.tv(-1);
                        }
                    }
                }
                if (1 == i2) {
                    this.qkT.jsW.post(new Runnable(this) {
                        final /* synthetic */ b qkV;

                        {
                            this.qkV = r1;
                        }

                        public final void run() {
                            if (this.qkV.qkT.qkQ != null) {
                                this.qkV.qkT.qkQ.tv(0);
                            }
                        }
                    });
                }
                if (this.nDu) {
                    w.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at end", new Object[]{Integer.valueOf(this.qkT.hashCode()), Integer.valueOf(hashCode())});
                    if (this.qkT.qkK != null) {
                        this.qkT.qkK.type = 0;
                        this.qkT.qkK.run();
                        return;
                    }
                    return;
                }
                if (1 == this.qkT.ptN) {
                    long currentTimeMillis2 = ((long) this.qkT.ptR) - (System.currentTimeMillis() - this.qkT.ptX);
                    if (this.qkT.ptX == 0) {
                        o.b(this, (long) (this.qkT.ptR * 5));
                    } else if (currentTimeMillis2 > 0) {
                        o.b(this, currentTimeMillis2);
                    } else {
                        o.b(this, 0);
                    }
                } else if (obj2 == null || this.qkT.qkS == null) {
                    this.qkU.puE = i2;
                    this.qkT.jsW.post(this.qkU);
                } else {
                    i = this.qkT.qkS.bcg();
                    this.qkT.jsW.post(new Runnable(this) {
                        final /* synthetic */ b qkV;

                        {
                            this.qkV = r1;
                        }

                        public final void run() {
                            if (this.qkV.qkT.qkS != null) {
                                View bch = this.qkV.qkT.qkS.bch();
                                if (bch != null) {
                                    if (!(this.qkV.qkT.pua != null || this.qkV.qkT.qkS.bci() == -1 || this.qkV.qkT.ptY.get() == null)) {
                                        this.qkV.qkT.pua = AnimationUtils.loadAnimation(((View) this.qkV.qkT.ptY.get()).getContext(), this.qkV.qkT.qkS.bci());
                                    }
                                    if (this.qkV.qkT.pua != null) {
                                        bch.startAnimation(this.qkV.qkT.pua);
                                    }
                                    bch.setVisibility(0);
                                }
                            }
                        }
                    });
                    this.qkU.puE = i2;
                    this.qkT.jsW.postDelayed(this.qkU, (long) i);
                }
                if (this.qkT.qkK != null) {
                    w.d("MicroMsg.SightPlayController", "voice time is" + (this.qkT.qkK.bck() / 1000.0d));
                }
            }
        }
    }

    private class c implements Runnable {
        volatile boolean nDu = false;
        int puE;
        final /* synthetic */ a qkT;
        b qkW;

        public c(a aVar) {
            this.qkT = aVar;
            w.i("MicroMsg.SightPlayController", "make sure drawJob alive");
        }

        public final void run() {
            if (this.nDu) {
                w.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop draw", new Object[]{Integer.valueOf(this.qkT.hashCode()), Integer.valueOf(hashCode())});
                return;
            }
            this.qkT.A(this.qkT.ptS);
            if (this.qkT.ptX == 0) {
                o.b(this.qkW, 0);
                return;
            }
            long currentTimeMillis = ((long) this.qkT.ptR) - (System.currentTimeMillis() - this.qkT.ptX);
            if (currentTimeMillis > 0) {
                o.b(this.qkW, currentTimeMillis);
            } else {
                o.b(this.qkW, 0);
            }
        }
    }

    private class d implements Runnable {
        final /* synthetic */ a qkT;

        public d(a aVar) {
            this.qkT = aVar;
        }

        public final void run() {
            if (this.qkT.ptY.get() != null) {
                ((View) this.qkT.ptY.get()).startAnimation(this.qkT.ptZ);
            }
        }
    }

    public interface e {
        void tv(int i);
    }

    public interface f {
        void dy(long j);
    }

    public interface g {
        int bcg();

        View bch();

        int bci();
    }

    private class h implements Runnable {
        volatile boolean nDu = false;
        final /* synthetic */ a qkT;

        public h(a aVar) {
            this.qkT = aVar;
        }

        public final void run() {
            if (this.qkT.bca()) {
                w.e("MicroMsg.SightPlayController", "is bad fps, do nothing when open file");
                return;
            }
            this.qkT.ptQ = SightVideoJNI.openFile(this.qkT.ptO, 1 == this.qkT.ptN ? 0 : 1, 1, false);
            if (this.qkT.ptQ < 0) {
                w.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id %d, path %s", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.qkT.hashCode()), Integer.valueOf(this.qkT.ptQ), this.qkT.ptO});
                this.qkT.bgG();
                if (this.qkT.qkQ != null) {
                    this.qkT.qkQ.tv(-1);
                    return;
                }
                return;
            }
            if (((Boolean) AdLandingPagesProxy.getInstance().getCfg(344065, Boolean.valueOf(false))).booleanValue()) {
                if (this.qkT.qkN == null) {
                    this.qkT.qkN = new j(this.qkT);
                }
                this.qkT.jsW.removeCallbacks(this.qkT.qkN);
                this.qkT.jsW.post(this.qkT.qkN);
            }
            int max = Math.max(1, SightVideoJNI.getVideoWidth(this.qkT.ptQ));
            int max2 = Math.max(1, SightVideoJNI.getVideoHeight(this.qkT.ptQ));
            if (this.qkT.ptN == 0) {
                if (max * max2 >= 1048576 || max <= 0 || max2 <= 0) {
                    w.e("MicroMsg.SightPlayController", "get error info videoWidth %d height  %d", new Object[]{Integer.valueOf(max), Integer.valueOf(max2)});
                    return;
                }
                a aVar = this.qkT;
                w.d("MicroMsg.SightPlayController", "#0x%x check bmp, video width %d, height %d", new Object[]{Integer.valueOf(aVar.hashCode()), Integer.valueOf(max), Integer.valueOf(max2)});
                if (aVar.ptS == null) {
                    aVar.ptS = com.tencent.mm.memory.o.hgW.a(new com.tencent.mm.memory.o.b(max, max2));
                    w.h("MicroMsg.SightPlayController", "checkBmp, create new one, videoPath: %s", new Object[]{aVar.ptO});
                } else if (!(aVar.ptS.getWidth() == max && aVar.ptS.getHeight() == max2)) {
                    boolean z;
                    w.w("MicroMsg.SightPlayController", "reset bmp, old value " + aVar.ptS.getWidth() + "*" + aVar.ptS.getHeight());
                    if (!com.tencent.mm.compatible.util.d.eo(19) || aVar.ptS.getAllocationByteCount() < (max2 * max) * 4) {
                        z = false;
                    } else {
                        try {
                            w.w("MicroMsg.SightPlayController", "reset bmp, try directly reconfigure");
                            aVar.ptS.reconfigure(max, max2, Config.ARGB_8888);
                            z = true;
                        } catch (Exception e) {
                            w.e("MicroMsg.SightPlayController", "reconfigure failed: %s" + e.getMessage());
                            z = false;
                        }
                    }
                    if (!z) {
                        com.tencent.mm.memory.o.hgW.e(aVar.ptS);
                        aVar.ptS = com.tencent.mm.memory.o.hgW.a(new com.tencent.mm.memory.o.b(max, max2));
                    }
                    w.h("MicroMsg.SightPlayController", "checkBmp, the origin bmp size not match, create new one, videoPath: %s", new Object[]{aVar.ptO});
                }
            }
            this.qkT.bcb();
            if (Float.compare(((float) max) / ((float) max2), 5.0f) > 0 || Float.compare(((float) max2) / ((float) max), 5.0f) > 0) {
                w.w("MicroMsg.SightPlayController", "ERROR Video size %d, %d", new Object[]{Integer.valueOf(max), Integer.valueOf(max2)});
                if (!bg.mA(this.qkT.ptO)) {
                    a.pup.put(this.qkT.ptO, Integer.valueOf(2));
                }
                this.qkT.ptX = 0;
                this.qkT.sG(this.qkT.ptQ);
                this.qkT.ptQ = -1;
                this.qkT.ptO = "";
                this.qkT.ptP = "ERROR#PATH";
                this.qkT.ptU = null;
                this.nDu = true;
                if (this.qkT.qkQ != null) {
                    this.qkT.qkQ.tv(-1);
                    return;
                }
                return;
            }
            this.qkT.bp(max, max2);
            if (1 == this.qkT.ptN) {
                this.qkT.qkJ = new b(this.qkT);
                this.qkT.qkL = null;
                if (!this.nDu) {
                    o.b(this.qkT.qkJ, 0);
                }
            } else {
                this.qkT.qkJ = new b(this.qkT);
                this.qkT.qkL = new c(this.qkT);
                this.qkT.qkJ.qkU = this.qkT.qkL;
                this.qkT.qkL.qkW = this.qkT.qkJ;
                if (!this.nDu) {
                    o.b(this.qkT.qkJ, 0);
                }
            }
            if (this.nDu) {
                w.e("MicroMsg.SightPlayController", "#0x%x-#0x%x open file end, match stop %B", new Object[]{Integer.valueOf(this.qkT.hashCode()), Integer.valueOf(hashCode()), Boolean.valueOf(this.nDu)});
            }
        }
    }

    private class i implements Runnable {
        MediaPlayer puG;
        double puq = -1.0d;
        final /* synthetic */ a qkT;
        int type;

        public i(a aVar) {
            this.qkT = aVar;
        }

        private void bcj() {
            w.i("MicroMsg.SightPlayController", "stopPlayer");
            try {
                if (this.puG != null) {
                    this.puG.stop();
                    this.puG.release();
                    this.puG = null;
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.SightPlayController", e, "stop play sound error: %s", new Object[]{e.getMessage()});
                this.puG = null;
            }
        }

        public final double bck() {
            if (this.puG == null) {
                return 0.0d;
            }
            return (double) this.puG.getCurrentPosition();
        }

        public final void run() {
            String str;
            String str2 = "MicroMsg.SightPlayController";
            String str3 = "do play sound, operation %s";
            Object[] objArr = new Object[1];
            switch (this.type) {
                case 0:
                    str = "stop";
                    break;
                case 1:
                    str = "start";
                    break;
                case 2:
                    str = "pause";
                    break;
                case 3:
                    str = "resume";
                    break;
                case 4:
                    str = "seek";
                    break;
                default:
                    str = "unknown";
                    break;
            }
            objArr[0] = str;
            w.i(str2, str3, objArr);
            switch (this.type) {
                case 0:
                    bcj();
                    return;
                case 1:
                    bcj();
                    if (!bg.mA(this.qkT.ptO)) {
                        try {
                            this.puG = new com.tencent.mm.compatible.b.i();
                            this.puG.setDisplay(null);
                            this.puG.reset();
                            this.puG.setDataSource(this.qkT.ptO);
                            this.puG.setAudioStreamType(3);
                            this.puG.setOnErrorListener(new OnErrorListener(this) {
                                final /* synthetic */ i qkX;

                                {
                                    this.qkX = r1;
                                }

                                public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                    w.e("MicroMsg.SightPlayController", "on error: play %s ERROR!! %d %d", new Object[]{this.qkX.qkT.ptO, Integer.valueOf(i), Integer.valueOf(i2)});
                                    this.qkX.qkT.clear();
                                    if (this.qkX.qkT.qkQ != null) {
                                        this.qkX.qkT.qkQ.tv(-1);
                                    }
                                    return true;
                                }
                            });
                            this.puG.prepare();
                            this.puG.start();
                            return;
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.SightPlayController", e, "play sound error: %s", new Object[]{e.getMessage()});
                            w.e("MicroMsg.SightPlayController", "on Exception: play %s ERROR!!", new Object[]{this.qkT.ptO});
                            this.qkT.clear();
                            if (this.qkT.qkQ != null) {
                                this.qkT.qkQ.tv(-1);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                case 2:
                    try {
                        if (this.puG != null && this.puG.isPlaying()) {
                            this.puG.pause();
                            return;
                        }
                        return;
                    } catch (Throwable e2) {
                        w.printErrStackTrace("MicroMsg.SightPlayController", e2, "pause sound error: %s", new Object[]{e2.getMessage()});
                        bcj();
                        return;
                    }
                case 3:
                    try {
                        if (this.puG != null) {
                            this.puG.start();
                            return;
                        }
                        return;
                    } catch (Throwable e22) {
                        w.printErrStackTrace("MicroMsg.SightPlayController", e22, "pause sound error: %s", new Object[]{e22.getMessage()});
                        bcj();
                        return;
                    }
                case 4:
                    try {
                        w.i("MicroMsg.SightPlayController", "soundplayer seek %f", new Object[]{Double.valueOf(this.puq)});
                        this.puG.seekTo((int) (this.puq * 1000.0d));
                        return;
                    } catch (Throwable e222) {
                        w.printErrStackTrace("MicroMsg.SightPlayController", e222, "seek sound error: %s", new Object[]{e222.getMessage()});
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private class j implements Runnable {
        final /* synthetic */ a qkT;

        public j(a aVar) {
            this.qkT = aVar;
        }

        public final void run() {
            if (this.qkT.ptQ >= 0 && this.qkT.ptW != null && this.qkT.ptW.get() != null) {
                ((TextView) this.qkT.ptW.get()).setText(SightVideoJNI.getVideoInfo(this.qkT.ptQ));
            }
        }
    }

    private class k implements Runnable {
        WeakReference<Bitmap> puI = new WeakReference(null);
        final /* synthetic */ a qkT;

        public k(a aVar) {
            this.qkT = aVar;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r10 = this;
            r1 = 0;
            r2 = 1;
            r3 = 0;
            r0 = r10.qkT;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.nIX;	 Catch:{ Exception -> 0x00ce }
            if (r0 == 0) goto L_0x0013;
        L_0x0009:
            r0 = r10.qkT;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.nIX;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.isValid();	 Catch:{ Exception -> 0x00ce }
            if (r0 != 0) goto L_0x01db;
        L_0x0013:
            r4 = "MicroMsg.SightPlayController";
            r5 = "#0x%x-#0x%x want draw thumb, but surface status error, surface null ? %B, thumb bgView null ? %B, thumb null ? %B, mask null ? %B";
            r0 = 6;
            r6 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x00ce }
            r0 = 0;
            r7 = r10.qkT;	 Catch:{ Exception -> 0x00ce }
            r7 = r7.hashCode();	 Catch:{ Exception -> 0x00ce }
            r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x00ce }
            r6[r0] = r7;	 Catch:{ Exception -> 0x00ce }
            r0 = 1;
            r7 = r10.hashCode();	 Catch:{ Exception -> 0x00ce }
            r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x00ce }
            r6[r0] = r7;	 Catch:{ Exception -> 0x00ce }
            r7 = 2;
            r0 = r10.qkT;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.nIX;	 Catch:{ Exception -> 0x00ce }
            if (r0 != 0) goto L_0x00b9;
        L_0x003b:
            r0 = r2;
        L_0x003c:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00ce }
            r6[r7] = r0;	 Catch:{ Exception -> 0x00ce }
            r7 = 3;
            r0 = r10.qkT;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.ptV;	 Catch:{ Exception -> 0x00ce }
            if (r0 != 0) goto L_0x00bb;
        L_0x0049:
            r0 = r2;
        L_0x004a:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00ce }
            r6[r7] = r0;	 Catch:{ Exception -> 0x00ce }
            r7 = 4;
            r0 = r10.puI;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.get();	 Catch:{ Exception -> 0x00ce }
            if (r0 != 0) goto L_0x00bd;
        L_0x0059:
            r0 = r2;
        L_0x005a:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00ce }
            r6[r7] = r0;	 Catch:{ Exception -> 0x00ce }
            r7 = 5;
            r0 = r10.qkT;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.ptT;	 Catch:{ Exception -> 0x00ce }
            if (r0 != 0) goto L_0x00bf;
        L_0x0067:
            r0 = r2;
        L_0x0068:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00ce }
            r6[r7] = r0;	 Catch:{ Exception -> 0x00ce }
            com.tencent.mm.sdk.platformtools.w.w(r4, r5, r6);	 Catch:{ Exception -> 0x00ce }
            r0 = r10.qkT;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.ptT;	 Catch:{ Exception -> 0x00ce }
            if (r0 != 0) goto L_0x00db;
        L_0x0077:
            r0 = r10.puI;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.get();	 Catch:{ Exception -> 0x00ce }
            r0 = (android.graphics.Bitmap) r0;	 Catch:{ Exception -> 0x00ce }
            r4 = r10.qkT;	 Catch:{ Exception -> 0x00ce }
            r4 = r4.ptV;	 Catch:{ Exception -> 0x00ce }
            if (r4 == 0) goto L_0x008f;
        L_0x0085:
            r1 = r10.qkT;	 Catch:{ Exception -> 0x00ce }
            r1 = r1.ptV;	 Catch:{ Exception -> 0x00ce }
            r1 = r1.get();	 Catch:{ Exception -> 0x00ce }
            r1 = (android.view.View) r1;	 Catch:{ Exception -> 0x00ce }
        L_0x008f:
            if (r1 == 0) goto L_0x0099;
        L_0x0091:
            if (r0 == 0) goto L_0x0099;
        L_0x0093:
            r4 = r0.isRecycled();	 Catch:{ Exception -> 0x00ce }
            if (r4 == 0) goto L_0x00c5;
        L_0x0099:
            r4 = "MicroMsg.SightPlayController";
            r5 = "bgView:%B, thumb:%B";
            r6 = 2;
            r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x00ce }
            r7 = 0;
            if (r1 != 0) goto L_0x00c1;
        L_0x00a5:
            r1 = r2;
        L_0x00a6:
            r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x00ce }
            r6[r7] = r1;	 Catch:{ Exception -> 0x00ce }
            r1 = 1;
            if (r0 != 0) goto L_0x00c3;
        L_0x00af:
            r0 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x00ce }
            r6[r1] = r0;	 Catch:{ Exception -> 0x00ce }
            com.tencent.mm.sdk.platformtools.w.e(r4, r5, r6);	 Catch:{ Exception -> 0x00ce }
        L_0x00b8:
            return;
        L_0x00b9:
            r0 = r3;
            goto L_0x003c;
        L_0x00bb:
            r0 = r3;
            goto L_0x004a;
        L_0x00bd:
            r0 = r3;
            goto L_0x005a;
        L_0x00bf:
            r0 = r3;
            goto L_0x0068;
        L_0x00c1:
            r1 = r3;
            goto L_0x00a6;
        L_0x00c3:
            r2 = r3;
            goto L_0x00af;
        L_0x00c5:
            r2 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a$k$1;	 Catch:{ Exception -> 0x00ce }
            r2.<init>(r10, r1, r0);	 Catch:{ Exception -> 0x00ce }
            r1.post(r2);	 Catch:{ Exception -> 0x00ce }
            goto L_0x00b8;
        L_0x00ce:
            r0 = move-exception;
            r1 = "MicroMsg.SightPlayController";
            r2 = "";
            r3 = new java.lang.Object[r3];
            com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r1, r0, r2, r3);
            goto L_0x00b8;
        L_0x00db:
            r0 = r10.qkT;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.ptU;	 Catch:{ Exception -> 0x00ce }
            if (r0 == 0) goto L_0x0105;
        L_0x00e1:
            r0 = r10.qkT;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.ptU;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.getWidth();	 Catch:{ Exception -> 0x00ce }
            r4 = r10.qkT;	 Catch:{ Exception -> 0x00ce }
            r4 = r4.ptT;	 Catch:{ Exception -> 0x00ce }
            r4 = r4.getWidth();	 Catch:{ Exception -> 0x00ce }
            if (r0 != r4) goto L_0x0105;
        L_0x00f3:
            r0 = r10.qkT;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.ptU;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.getHeight();	 Catch:{ Exception -> 0x00ce }
            r4 = r10.qkT;	 Catch:{ Exception -> 0x00ce }
            r4 = r4.ptT;	 Catch:{ Exception -> 0x00ce }
            r4 = r4.getHeight();	 Catch:{ Exception -> 0x00ce }
            if (r0 == r4) goto L_0x011f;
        L_0x0105:
            r0 = r10.qkT;	 Catch:{ Exception -> 0x0166 }
            r4 = r10.qkT;	 Catch:{ Exception -> 0x0166 }
            r4 = r4.ptT;	 Catch:{ Exception -> 0x0166 }
            r4 = r4.getWidth();	 Catch:{ Exception -> 0x0166 }
            r5 = r10.qkT;	 Catch:{ Exception -> 0x0166 }
            r5 = r5.ptT;	 Catch:{ Exception -> 0x0166 }
            r5 = r5.getHeight();	 Catch:{ Exception -> 0x0166 }
            r6 = android.graphics.Bitmap.Config.ARGB_8888;	 Catch:{ Exception -> 0x0166 }
            r4 = android.graphics.Bitmap.createBitmap(r4, r5, r6);	 Catch:{ Exception -> 0x0166 }
            r0.ptU = r4;	 Catch:{ Exception -> 0x0166 }
        L_0x011f:
            r0 = r10.qkT;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.ptU;	 Catch:{ Exception -> 0x00ce }
            if (r0 == 0) goto L_0x013b;
        L_0x0125:
            r0 = r10.puI;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.get();	 Catch:{ Exception -> 0x00ce }
            if (r0 == 0) goto L_0x013b;
        L_0x012d:
            r0 = r10.puI;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.get();	 Catch:{ Exception -> 0x00ce }
            r0 = (android.graphics.Bitmap) r0;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.isRecycled();	 Catch:{ Exception -> 0x00ce }
            if (r0 == 0) goto L_0x0184;
        L_0x013b:
            r1 = "MicroMsg.SightPlayController";
            r4 = "mThubmBgBmp:%B, thumbRef:%B";
            r0 = 2;
            r5 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x00ce }
            r6 = 0;
            r0 = r10.qkT;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.ptU;	 Catch:{ Exception -> 0x00ce }
            if (r0 != 0) goto L_0x0180;
        L_0x014b:
            r0 = r2;
        L_0x014c:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00ce }
            r5[r6] = r0;	 Catch:{ Exception -> 0x00ce }
            r0 = 1;
            r6 = r10.puI;	 Catch:{ Exception -> 0x00ce }
            r6 = r6.get();	 Catch:{ Exception -> 0x00ce }
            if (r6 != 0) goto L_0x0182;
        L_0x015b:
            r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x00ce }
            r5[r0] = r2;	 Catch:{ Exception -> 0x00ce }
            com.tencent.mm.sdk.platformtools.w.e(r1, r4, r5);	 Catch:{ Exception -> 0x00ce }
            goto L_0x00b8;
        L_0x0166:
            r0 = move-exception;
            r4 = "MicroMsg.SightPlayController";
            r5 = "try to create thumb bmp error:%s";
            r6 = 1;
            r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x00ce }
            r7 = 0;
            r8 = r0.getMessage();	 Catch:{ Exception -> 0x00ce }
            r6[r7] = r8;	 Catch:{ Exception -> 0x00ce }
            com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r4, r0, r5, r6);	 Catch:{ Exception -> 0x00ce }
            r0 = r10.qkT;	 Catch:{ Exception -> 0x00ce }
            r4 = 0;
            r0.ptU = r4;	 Catch:{ Exception -> 0x00ce }
            goto L_0x011f;
        L_0x0180:
            r0 = r3;
            goto L_0x014c;
        L_0x0182:
            r2 = r3;
            goto L_0x015b;
        L_0x0184:
            r4 = java.lang.System.nanoTime();	 Catch:{ Exception -> 0x00ce }
            r0 = r10.puI;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.get();	 Catch:{ Exception -> 0x00ce }
            r0 = (android.graphics.Bitmap) r0;	 Catch:{ Exception -> 0x00ce }
            r2 = r10.qkT;	 Catch:{ Exception -> 0x00ce }
            r2 = r2.ptU;	 Catch:{ Exception -> 0x00ce }
            r6 = r10.qkT;	 Catch:{ Exception -> 0x00ce }
            r6 = r6.ptT;	 Catch:{ Exception -> 0x00ce }
            com.tencent.mm.plugin.sight.base.SightVideoJNI.handleThumb(r0, r2, r6);	 Catch:{ Exception -> 0x00ce }
            r0 = "MicroMsg.SightPlayController";
            r2 = "handle thumb use %d us";
            r6 = 1;
            r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x00ce }
            r7 = 0;
            r8 = java.lang.System.nanoTime();	 Catch:{ Exception -> 0x00ce }
            r4 = r8 - r4;
            r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            r4 = r4 / r8;
            r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x00ce }
            r6[r7] = r4;	 Catch:{ Exception -> 0x00ce }
            com.tencent.mm.sdk.platformtools.w.i(r0, r2, r6);	 Catch:{ Exception -> 0x00ce }
            r0 = r10.qkT;	 Catch:{ Exception -> 0x00ce }
            r2 = r0.ptU;	 Catch:{ Exception -> 0x00ce }
            r0 = r10.qkT;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.ptV;	 Catch:{ Exception -> 0x00ce }
            if (r0 == 0) goto L_0x01d9;
        L_0x01c1:
            r0 = r10.qkT;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.ptV;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.get();	 Catch:{ Exception -> 0x00ce }
            r0 = (android.view.View) r0;	 Catch:{ Exception -> 0x00ce }
        L_0x01cb:
            if (r0 == 0) goto L_0x00b8;
        L_0x01cd:
            if (r2 == 0) goto L_0x00b8;
        L_0x01cf:
            r1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a$k$2;	 Catch:{ Exception -> 0x00ce }
            r1.<init>(r10, r0, r2);	 Catch:{ Exception -> 0x00ce }
            r0.post(r1);	 Catch:{ Exception -> 0x00ce }
            goto L_0x00b8;
        L_0x01d9:
            r0 = r1;
            goto L_0x01cb;
        L_0x01db:
            r1 = "MicroMsg.SightPlayController";
            r4 = "#0x%x-#0x%x draw thumb, thumb empty ? %B";
            r0 = 3;
            r5 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x00ce }
            r0 = 0;
            r6 = r10.qkT;	 Catch:{ Exception -> 0x00ce }
            r6 = r6.hashCode();	 Catch:{ Exception -> 0x00ce }
            r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x00ce }
            r5[r0] = r6;	 Catch:{ Exception -> 0x00ce }
            r0 = 1;
            r6 = r10.hashCode();	 Catch:{ Exception -> 0x00ce }
            r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x00ce }
            r5[r0] = r6;	 Catch:{ Exception -> 0x00ce }
            r6 = 2;
            r0 = r10.puI;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.get();	 Catch:{ Exception -> 0x00ce }
            if (r0 != 0) goto L_0x023b;
        L_0x0205:
            r0 = r2;
        L_0x0206:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00ce }
            r5[r6] = r0;	 Catch:{ Exception -> 0x00ce }
            com.tencent.mm.sdk.platformtools.w.d(r1, r4, r5);	 Catch:{ Exception -> 0x00ce }
            r0 = r10.qkT;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.ptV;	 Catch:{ Exception -> 0x00ce }
            if (r0 == 0) goto L_0x0229;
        L_0x0215:
            r0 = r10.qkT;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.ptV;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.get();	 Catch:{ Exception -> 0x00ce }
            r0 = (android.view.View) r0;	 Catch:{ Exception -> 0x00ce }
            if (r0 == 0) goto L_0x0229;
        L_0x0221:
            r1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a$k$3;	 Catch:{ Exception -> 0x00ce }
            r1.<init>(r10, r0);	 Catch:{ Exception -> 0x00ce }
            r0.post(r1);	 Catch:{ Exception -> 0x00ce }
        L_0x0229:
            r0 = r10.puI;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.get();	 Catch:{ Exception -> 0x00ce }
            if (r0 != 0) goto L_0x023d;
        L_0x0231:
            r0 = r10.qkT;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.nIX;	 Catch:{ Exception -> 0x00ce }
            r1 = 0;
            com.tencent.mm.plugin.sight.base.SightVideoJNI.drawSurfaceColor(r0, r1);	 Catch:{ Exception -> 0x00ce }
            goto L_0x00b8;
        L_0x023b:
            r0 = r3;
            goto L_0x0206;
        L_0x023d:
            r0 = r10.qkT;	 Catch:{ Exception -> 0x00ce }
            r1 = r0.nIX;	 Catch:{ Exception -> 0x00ce }
            r0 = r10.puI;	 Catch:{ Exception -> 0x00ce }
            r0 = r0.get();	 Catch:{ Exception -> 0x00ce }
            r0 = (android.graphics.Bitmap) r0;	 Catch:{ Exception -> 0x00ce }
            r2 = r10.qkT;	 Catch:{ Exception -> 0x00ce }
            r2 = r2.ptT;	 Catch:{ Exception -> 0x00ce }
            com.tencent.mm.plugin.sight.base.SightVideoJNI.drawSurfaceThumb(r1, r0, r2);	 Catch:{ Exception -> 0x00ce }
            goto L_0x00b8;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.k.run():void");
        }
    }

    public abstract void A(Bitmap bitmap);

    public abstract void bp(int i, int i2);

    public a(int i, View view) {
        this.hRa = false;
        this.ptM = 0;
        this.ptN = 0;
        this.ptO = "";
        this.ptP = "";
        this.ptQ = -1;
        this.ptR = 41;
        this.puj = true;
        this.puk = false;
        this.pum = false;
        this.mNI = true;
        this.pun = -1.0d;
        this.puo = false;
        this.puq = -1.0d;
        this.pur = false;
        this.pus = false;
        this.ptN = 0;
        this.jsW = new ae(Looper.getMainLooper());
        this.ptY = new WeakReference(view);
        w.i("MicroMsg.SightPlayController", "new SightPlayController, drawType %d", new Object[]{Integer.valueOf(0)});
    }

    protected int bbY() {
        return -1;
    }

    public final void ha(boolean z) {
        if (this.qkI != null) {
            o.h(this.qkI);
            this.qkI.nDu = true;
        }
        if (this.qkL != null) {
            this.jsW.removeCallbacks(this.qkL);
            this.qkL.nDu = true;
        }
        if (this.qkJ != null) {
            o.h(this.qkJ);
            this.qkJ.nDu = true;
        }
        if (this.qkK != null) {
            this.qkK.type = z ? 0 : 2;
            o.b(this.qkK, 0);
        }
    }

    public final boolean bbZ() {
        if (1 == this.ptN) {
            if (this.qkJ == null || this.qkJ.nDu) {
                return false;
            }
            return true;
        } else if (this.qkL == null || this.qkL.nDu || this.qkJ == null || this.qkJ.nDu) {
            return false;
        } else {
            return true;
        }
    }

    public final void restart() {
        w.i("MicroMsg.SightPlayController", "#0x%x restart, canPlay %B, videoPath %s, videoId %d", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(this.puj), this.ptO, Integer.valueOf(this.ptQ)});
        if (!this.puj) {
            clear();
        } else if (bbZ()) {
            w.w("MicroMsg.SightPlayController", "#0x%x is runing, do nothing when restart request asked, videoPath %s", new Object[]{Integer.valueOf(hashCode()), this.ptO});
        } else {
            boolean z;
            if (this.ptQ < 0) {
                z = true;
            } else {
                z = false;
            }
            ha(z);
            this.ptX = 0;
            if (bca()) {
                w.e("MicroMsg.SightPlayController", "#0x%x is bad fps, do nothing when restart", new Object[]{Integer.valueOf(hashCode())});
            } else if (this.ptQ < 0) {
                w.w("MicroMsg.SightPlayController", "#0x%x restart match error video id, try reopen video, videoPath %s", new Object[]{Integer.valueOf(hashCode()), this.ptO});
                if (!bg.mA(this.ptO)) {
                    if (Es(this.ptO)) {
                        this.qkI = new h(this);
                        o.b(this.qkI, 0);
                        return;
                    }
                    w.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
                    clear();
                }
            } else if (1 == this.ptN) {
                this.qkJ = new b(this);
                this.qkL = null;
                o.b(this.qkJ, 0);
            } else {
                this.qkJ = new b(this);
                this.qkL = new c(this);
                this.qkJ.qkU = this.qkL;
                this.qkL.qkW = this.qkJ;
                o.b(this.qkJ, 0);
            }
        }
    }

    public final void clear() {
        w.i("MicroMsg.SightPlayController", "#0x%x do clear, remove render job, video id %d, runing %B", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.ptQ), Boolean.valueOf(bbZ())});
        ha(true);
        this.ptX = 0;
        sG(this.ptQ);
        this.ptQ = -1;
        this.ptO = "";
        this.ptP = "ERROR#PATH";
        this.ptU = null;
        this.pun = 0.0d;
        this.puo = false;
        com.tencent.mm.memory.o.hgW.e(this.ptS);
        this.ptS = null;
    }

    public final void sG(final int i) {
        o.b(new Runnable(this) {
            final /* synthetic */ a qkT;

            public final void run() {
                long currentTimeMillis = System.currentTimeMillis();
                SightVideoJNI.freeObj(i);
                w.d("MicroMsg.SightPlayController", "#0x%x tick: do clear video %d, use %d ms", new Object[]{Integer.valueOf(this.qkT.hashCode()), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            }
        }, 0);
    }

    public static boolean Es(String str) {
        if (bg.mA(str)) {
            return false;
        }
        Integer num = (Integer) pup.get(str);
        if (num == null || 2 != num.intValue()) {
            return true;
        }
        return false;
    }

    public final boolean bca() {
        if (this.pum) {
            return false;
        }
        if (VERSION.SDK_INT >= 11) {
            if (this.ptM < 3) {
                return false;
            }
            w.v("MicroMsg.SightPlayController", "match not check bad fps, but now is bad fps");
            this.ptM = 0;
            return false;
        } else if (this.ptM >= 3) {
            return true;
        } else {
            return false;
        }
    }

    protected final void bcb() {
        this.ptR = 1000 / Math.max(1, (int) SightVideoJNI.getVideoRate(this.ptQ));
        w.d("MicroMsg.SightPlayController", "#0x%x update video rate to %d fps, delay %d ms", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(r0), Integer.valueOf(this.ptR)});
    }

    public final void bgG() {
        w.v("MicroMsg.SightPlayController", "draw surface thumb, thumb is null ? %B", new Object[]{Boolean.valueOf(true)});
        o.h(this.qkM);
        if (this.qkM == null) {
            this.qkM = new k(this);
        }
        this.qkM.puI = new WeakReference(null);
        o.b(this.qkM, 0);
    }

    public final void bcc() {
        if (this.ptY != null && -1 != bbY()) {
            if (this.ptZ == null && this.ptY.get() != null) {
                this.ptZ = AnimationUtils.loadAnimation(((View) this.ptY.get()).getContext(), bbY());
            }
            if (this.qkO == null) {
                this.qkO = new d(this);
            }
            this.jsW.post(this.qkO);
        }
    }

    public final com.tencent.mm.sdk.b.c bcd() {
        if (this.qkP == null) {
            this.qkP = new a(this);
        }
        return this.qkP;
    }
}
