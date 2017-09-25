package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.text.ClipboardManager;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.e.a.bs;
import com.tencent.mm.e.a.f;
import com.tencent.mm.e.a.gg;
import com.tencent.mm.e.a.jm;
import com.tencent.mm.e.a.jq;
import com.tencent.mm.e.a.jx;
import com.tencent.mm.e.a.jy;
import com.tencent.mm.e.a.ke;
import com.tencent.mm.e.a.mu;
import com.tencent.mm.e.a.om;
import com.tencent.mm.e.a.op;
import com.tencent.mm.e.a.oq;
import com.tencent.mm.e.a.ou;
import com.tencent.mm.e.a.ov;
import com.tencent.mm.e.a.ow;
import com.tencent.mm.e.a.pb;
import com.tencent.mm.e.a.pd;
import com.tencent.mm.e.a.pn;
import com.tencent.mm.e.a.qv;
import com.tencent.mm.e.a.rf;
import com.tencent.mm.kiss.WxPresenterActivity;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.h;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.model.t;
import com.tencent.mm.plugin.sns.model.x;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ak;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.d;
import com.tencent.mm.y.e;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class En_424b8e16 extends WxPresenterActivity implements com.tencent.mm.plugin.sns.b.g.a, t, ak, e {
    private static final Set<Activity> qrQ = new HashSet();
    private ActionBar Gx;
    private long jXw = 0;
    private String jia;
    private int mScreenHeight = 0;
    private int mScreenWidth = 0;
    private int nVs = 0;
    private c pXq = new c<f>(this) {
        final /* synthetic */ En_424b8e16 qrZ;

        {
            this.qrZ = r2;
            this.usg = f.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            boolean z = true;
            f fVar = (f) bVar;
            if (!(this.qrZ.qrb == null || this.qrZ.qrb.qpZ == null)) {
                com.tencent.mm.plugin.sns.h.b bVar2 = this.qrZ.qrb.qpZ.pWR;
                boolean z2 = fVar.fCo.fCp;
                String str = fVar.fCo.className;
                if (str.toLowerCase().indexOf("sns") < 0 && str.toLowerCase().indexOf("sightuploadui") < 0 && !str.contains("WebViewUI")) {
                    z = false;
                }
                if (!z) {
                    w.d("MicroMsg.SnsBrowseInfoHelper", "handleActivityStatusChanged, not sns scene, className" + str + ",_active=" + z2);
                } else if (!z2) {
                    bVar2.qcb = System.currentTimeMillis();
                } else if (bVar2.qcb > 0) {
                    bVar2.qca += System.currentTimeMillis() - bVar2.qcb;
                    bVar2.qcb = 0;
                }
            }
            return false;
        }
    };
    private boolean qaV = false;
    private final long qqS = 300;
    private long qqT = SystemClock.elapsedRealtime();
    private com.tencent.mm.plugin.sns.j.b qqU = ((com.tencent.mm.plugin.sns.j.b) m(com.tencent.mm.plugin.sns.j.b.class));
    private com.tencent.mm.plugin.sns.j.a qqV = this.qqU.blO();
    private aw qqW;
    private LinearLayout qqX;
    private QFadeImageView qqY;
    private boolean qqZ = false;
    private boolean qqg = false;
    private c qrA = new c<pb>(this) {
        final /* synthetic */ En_424b8e16 qrZ;

        {
            this.qrZ = r2;
            this.usg = pb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.qrZ.qqW.qHY.notifyVendingDataChange();
            return false;
        }
    };
    private c qrB = new c<gg>(this) {
        final /* synthetic */ En_424b8e16 qrZ;

        {
            this.qrZ = r2;
            this.usg = gg.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            gg ggVar = (gg) bVar;
            En_424b8e16.a(this.qrZ, ggVar.fLx.fLA, ggVar.fLx.fLz, ggVar);
            return false;
        }
    };
    private c qrC = new c<om>(this) {
        final /* synthetic */ En_424b8e16 qrZ;

        {
            this.qrZ = r2;
            this.usg = om.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (!(this.qrZ.qrb == null || this.qrZ.qrb.qpZ == null)) {
                this.qrZ.qrb.qpZ.pWR.hz(true);
            }
            return false;
        }
    };
    private c qrD = new c<oq>(this) {
        final /* synthetic */ En_424b8e16 qrZ;

        {
            this.qrZ = r2;
            this.usg = oq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            oq oqVar = (oq) bVar;
            if (!(this.qrZ.qrb == null || this.qrZ.qrb.qpZ == null)) {
                this.qrZ.qrb.qpZ.pWR.dz(oqVar.fVK.fGN, oqVar.fVK.fVJ);
            }
            return false;
        }
    };
    private c qrE = new c<ou>(this) {
        final /* synthetic */ En_424b8e16 qrZ;

        {
            this.qrZ = r2;
            this.usg = ou.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ou ouVar = (ou) bVar;
            if (!(this.qrZ.qrb == null || this.qrZ.qrb.qpZ == null)) {
                com.tencent.mm.plugin.sns.h.b bVar2 = this.qrZ.qrb.qpZ.pWR;
                bVar2.qcS.add(ouVar.fVO.fVJ);
            }
            return false;
        }
    };
    private c qrF = new c<ov>(this) {
        final /* synthetic */ En_424b8e16 qrZ;

        {
            this.qrZ = r2;
            this.usg = ov.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ov ovVar = (ov) bVar;
            if (!(this.qrZ.qrb == null || this.qrZ.qrb.qpZ == null)) {
                com.tencent.mm.plugin.sns.h.b bVar2 = this.qrZ.qrb.qpZ.pWR;
                bVar2.qcR.add(ovVar.fVP.fVJ);
            }
            return false;
        }
    };
    private c qrG = new c<ow>(this) {
        final /* synthetic */ En_424b8e16 qrZ;

        {
            this.qrZ = r2;
            this.usg = ow.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ow owVar = (ow) bVar;
            if (!(this.qrZ.qrb == null || this.qrZ.qrb.qpZ == null)) {
                com.tencent.mm.plugin.sns.h.b bVar2 = this.qrZ.qrb.qpZ.pWR;
                bVar2.qcO.add(owVar.fVQ.fVJ);
            }
            return false;
        }
    };
    private long qrH = 0;
    boolean qrI = false;
    Runnable qrJ = new Runnable(this) {
        final /* synthetic */ En_424b8e16 qrZ;

        {
            this.qrZ = r1;
        }

        public final void run() {
            if (this.qrZ.qqW != null && this.qrZ.qrI) {
                ae.beI().pause();
            }
        }
    };
    Runnable qrK = new Runnable(this) {
        final /* synthetic */ En_424b8e16 qrZ;

        {
            this.qrZ = r1;
        }

        public final void run() {
            if (this.qrZ.qqW != null && !this.qrZ.qrI) {
                w.v("MicroMsg.SnsTimeLineUI", "zeustest update onFling notify resume %s", new Object[]{Integer.valueOf(this.qrZ.qrp.mUX.getFirstVisiblePosition() - this.qrZ.qrp.mUX.getHeaderViewsCount())});
                ae.beI().start();
                this.qrZ.qqW.qHX.bkW();
            }
        }
    };
    private Handler qrL = ((com.tencent.mm.vending.h.b) d.wDB.wDH).mHandler;
    private Runnable qrM = new Runnable(this) {
        final /* synthetic */ En_424b8e16 qrZ;

        {
            this.qrZ = r1;
        }

        public final void run() {
            this.qrZ.bPZ();
            this.qrZ.biw();
            this.qrZ.qP(this.qrZ.getString(j.pMJ));
            this.qrZ.qrH = 0;
            this.qrZ.nVs = this.qrZ.qrp.mUX.getFirstVisiblePosition();
        }
    };
    private com.tencent.mm.plugin.sns.ui.ba.a qrN = new com.tencent.mm.plugin.sns.ui.ba.a(this) {
        final /* synthetic */ En_424b8e16 qrZ;
        private int qsd = 0;
        private int qse = 0;

        {
            this.qrZ = r2;
        }

        public final void biA() {
            this.qrZ.qqU.qPI.b(this.qrZ.jia, this.qrZ.qrm, false, this.qrZ.qro);
            w.d("MicroMsg.SnsTimeLineUI", "onLoadingMore here");
            if (this.qrZ.qrL == null) {
                w.e("MicroMsg.SnsTimeLineUI", "mLogicHandler handler null");
            } else if (this.qrZ.qrb != null) {
                this.qrZ.qrL.removeCallbacks(this.qrZ.qrq);
                this.qrZ.qrL.postDelayed(this.qrZ.qrq, 3000);
            }
        }

        public final ListView biB() {
            if (this.qrZ.qrb.mUX == null) {
                this.qrZ.qrb.mUX = (ListView) this.qrZ.findViewById(i.f.pFz);
            }
            return this.qrZ.qrb.mUX;
        }

        public final MMPullDownView biC() {
            return (MMPullDownView) this.qrZ.findViewById(i.f.pFG);
        }

        public final int getType() {
            return 1;
        }

        public final void a(int i, List<Integer> list, List<Integer> list2) {
            int i2 = 1;
            if (i > 0) {
                m tH = ae.beL().tH(i);
                if (tH != null) {
                    if (tH.field_pravited > 0) {
                        Toast.makeText(this.qrZ, j.pLj, 1).show();
                    }
                    if (tH.field_pravited == 1) {
                        i2 = 0;
                    }
                }
            }
            if (i2 != 0) {
                BackwardSupportUtil.c.a(this.qrZ.qrp.mUX);
            }
            if (this.qrZ.qqW != null) {
                this.qrZ.qqW.qHY.notifyVendingDataChange();
            }
        }

        public final boolean biD() {
            return this.qrZ.qqg;
        }

        public final void biE() {
            this.qrZ.biz();
            if (this.qrZ.qqY != null) {
                w.d("MicroMsg.SnsTimeLineUI", "refreshIv onLoadingTap");
                this.qrZ.qqY.setVisibility(0);
            }
            this.qrZ.qqU.qPH.b(this.qrZ.jia, this.qrZ.qrm, this.qrZ.qrn, this.qrZ.qro);
        }

        public final void biF() {
            this.qrZ.biz();
        }

        public final void biG() {
            int firstVisiblePosition = this.qrZ.qrp.mUX.getFirstVisiblePosition();
            int lastVisiblePosition = this.qrZ.qrp.mUX.getLastVisiblePosition();
            if (firstVisiblePosition != this.qsd || lastVisiblePosition != this.qse) {
                com.tencent.mm.plugin.sns.h.a.a aVar;
                this.qsd = firstVisiblePosition;
                this.qse = lastVisiblePosition;
                w.i("MicroMsg.SnsTimeLineUI", "onListViewScoll %s %s ", new Object[]{Integer.valueOf(firstVisiblePosition), Integer.valueOf(lastVisiblePosition)});
                com.tencent.mm.plugin.sns.h.a f = this.qrZ.qrh;
                au auVar = this.qrZ.qqW.qHX;
                firstVisiblePosition = com.tencent.mm.modelsns.c.hTF;
                if (firstVisiblePosition == 2) {
                    aVar = null;
                } else if (firstVisiblePosition != 4 || f.qaV) {
                    long nanoTime = System.nanoTime();
                    com.tencent.mm.plugin.sns.h.a.a aVar2 = new com.tencent.mm.plugin.sns.h.a.a();
                    aVar2.qaW = System.currentTimeMillis();
                    aVar2.mScreenHeight = f.mScreenHeight;
                    aVar2.mScreenWidth = f.mScreenWidth;
                    lastVisiblePosition = f.qaU.getTop();
                    firstVisiblePosition = f.qaU.getHeight();
                    if (lastVisiblePosition < 0) {
                        firstVisiblePosition += lastVisiblePosition;
                    }
                    aVar2.qaY = firstVisiblePosition;
                    lastVisiblePosition = f.iuu.getFirstVisiblePosition() - 1;
                    int lastVisiblePosition2 = f.iuu.getLastVisiblePosition() - 1;
                    aVar2.qaX = lastVisiblePosition;
                    aVar2.mhm = lastVisiblePosition2;
                    int count = auVar.getCount();
                    boolean z = false;
                    if (f.iuu.getChildAt(0) != null) {
                        z = f.iuu.getChildAt(0) instanceof SnsHeader;
                    }
                    w.v("MicroMsg.CaptureSnsHelper", "first last %s %s isHeaderExist %s", new Object[]{Integer.valueOf(lastVisiblePosition), Integer.valueOf(lastVisiblePosition2), Boolean.valueOf(z)});
                    firstVisiblePosition = z ? 1 : 0;
                    int childCount = f.iuu.getChildCount();
                    int i = lastVisiblePosition;
                    while (i <= lastVisiblePosition2) {
                        if (i < count && i >= 0) {
                            if (firstVisiblePosition >= childCount) {
                                w.e("MicroMsg.CaptureSnsHelper", "childPos biger than childCount %d %d", new Object[]{Integer.valueOf(firstVisiblePosition), Integer.valueOf(childCount)});
                            } else {
                                if (aVar2.qaZ == null) {
                                    aVar2.qaZ = new LinkedList();
                                }
                                com.tencent.mm.plugin.sns.h.a.b bVar = new com.tencent.mm.plugin.sns.h.a.b();
                                aVar2.qaZ.add(bVar);
                                View childAt = f.iuu.getChildAt(firstVisiblePosition);
                                lastVisiblePosition = firstVisiblePosition + 1;
                                firstVisiblePosition = childAt.getTop();
                                int left = childAt.getLeft();
                                int height = childAt.getHeight();
                                int width = childAt.getWidth();
                                m tM = auVar.tM(i);
                                bVar.qbe = com.tencent.mm.plugin.sns.data.i.g(tM);
                                bVar.qbc = tM.field_type;
                                bVar.qbd = tM.tE(32);
                                bVar.qba = firstVisiblePosition;
                                bVar.qbb = left;
                                bVar.jzY = height;
                                bVar.jrj = width;
                                if (!(childAt == null || childAt.getTag() == null || !(childAt.getTag() instanceof com.tencent.mm.plugin.sns.ui.a.a.c))) {
                                    com.tencent.mm.plugin.sns.ui.a.a.c cVar = (com.tencent.mm.plugin.sns.ui.a.a.c) childAt.getTag();
                                    if (cVar.qMu && cVar.qpm != null) {
                                        int top = cVar.qpm.getTop();
                                        left = cVar.qpm.getLeft();
                                        height = cVar.qMm.getHeight();
                                        width = cVar.qMm.getWidth();
                                        int top2 = cVar.qMn.getTop() + top;
                                        int left2 = cVar.qMn.getLeft() + left;
                                        int height2 = cVar.qMn.getHeight();
                                        int width2 = cVar.qMn.getWidth();
                                        w.v("MicroMsg.CaptureSnsHelper", "holder position %s %s index %s", new Object[]{Integer.valueOf(cVar.position), Integer.valueOf(i), Integer.valueOf(lastVisiblePosition)});
                                        if (cVar.pOp.ucl != 0) {
                                            bVar.qbg = cVar.pOp.ucl;
                                            bVar.qbh = top;
                                            bVar.qbi = left;
                                            bVar.qbj = width;
                                            bVar.qbk = height;
                                        }
                                        if (cVar.pOp.uco != 0) {
                                            bVar.qbf = cVar.pOp.uco;
                                            bVar.qbm = left2;
                                            bVar.qbl = top2;
                                            bVar.qbn = width2;
                                            bVar.qbo = height2;
                                        }
                                    }
                                }
                                firstVisiblePosition = lastVisiblePosition;
                            }
                        }
                        i++;
                    }
                    w.i("MicroMsg.CaptureSnsHelper", "end cap: " + (System.nanoTime() - nanoTime));
                    aVar = aVar2;
                } else {
                    aVar = null;
                }
                g.cbJ().b(new com.tencent.mm.vending.c.a<Void, Void>(this) {
                    final /* synthetic */ AnonymousClass18 qsg;

                    public final /* synthetic */ Object call(Object obj) {
                        Void voidR = (Void) obj;
                        if (aVar != null) {
                            com.tencent.mm.plugin.sns.h.a.a aVar = aVar;
                            com.tencent.mm.modelsns.b gz = com.tencent.mm.modelsns.b.gz(501);
                            gz.hTv = aVar.qaW;
                            gz.gC(aVar.mScreenWidth).gC(aVar.mScreenHeight);
                            gz.gC(aVar.qaY);
                            gz.gC(0);
                            gz.gC(aVar.qaX);
                            gz.gC(aVar.mhm);
                            gz.JE();
                            if (aVar.qaZ != null) {
                                for (com.tencent.mm.plugin.sns.h.a.b bVar : aVar.qaZ) {
                                    com.tencent.mm.modelsns.b gz2 = com.tencent.mm.modelsns.b.gz(502);
                                    gz2.hTv = aVar.qaW;
                                    gz2.kG(bVar.qbe).gC(bVar.qbc).bp(bVar.qbd).gC(bVar.qbb).gC(bVar.qba).gC(bVar.jrj).gC(bVar.jzY);
                                    gz2.JE();
                                    w.v("MicroMsg.CaptureSnsHelper", "rootview top left %s %s viewWidth: %s viewHeight: %s", new Object[]{Integer.valueOf(bVar.qba), Integer.valueOf(bVar.qbb), Integer.valueOf(bVar.jrj), Integer.valueOf(bVar.jzY)});
                                    w.v("MicroMsg.CaptureSnsHelper", "like %s %s likeheight: %s likewidth: %s", new Object[]{Integer.valueOf(bVar.qbh), Integer.valueOf(bVar.qbi), Integer.valueOf(bVar.qbk), Integer.valueOf(bVar.qbj)});
                                    w.v("MicroMsg.CaptureSnsHelper", "comment %s %s commentheight: %s commentwidth: %s", new Object[]{Integer.valueOf(bVar.qbl), Integer.valueOf(bVar.qbm), Integer.valueOf(bVar.qbo), Integer.valueOf(bVar.qbn)});
                                    if (bVar.qbg != 0) {
                                        gz2 = com.tencent.mm.modelsns.b.gz(503);
                                        gz2.hTv = aVar.qaW;
                                        gz2.kG(bVar.qbe).gC(bVar.qbc).bp(bVar.qbd).gC(bVar.qbg).gC(bVar.qbi).gC(bVar.qbh).gC(bVar.qbj).gC(bVar.qbk);
                                        gz2.JE();
                                    }
                                    if (bVar.qbf != 0) {
                                        gz2 = com.tencent.mm.modelsns.b.gz(504);
                                        gz2.hTv = aVar.qaW;
                                        gz2.kG(bVar.qbe).gC(bVar.qbc).bp(bVar.qbd).gC(bVar.qbf).gC(bVar.qbm).gC(bVar.qbl).gC(bVar.qbn).gC(bVar.qbo);
                                        gz2.JE();
                                    }
                                }
                            }
                            gz = com.tencent.mm.modelsns.b.gz(506);
                            gz.hTv = aVar.qaW;
                            gz.JE();
                        }
                        return voidR;
                    }
                });
            }
        }

        public final void Q(int i, boolean z) {
            if (this.qrZ.qqW != null) {
                this.qrZ.qqW.qHY.notifyVendingDataChange();
            }
            if (!z) {
                this.qrZ.vQ().z(com.tencent.mm.plugin.sns.j.c.b.class);
            }
        }

        public final void hF(boolean z) {
            En_424b8e16 en_424b8e16 = this.qrZ;
            en_424b8e16.qrI = z;
            com.tencent.mm.sdk.platformtools.ae ayz = ae.ayz();
            com.tencent.mm.plugin.sns.model.g beI = ae.beI();
            com.tencent.mm.plugin.sns.model.b beG = ae.beG();
            if (z) {
                if (beI.pSE || beG.pSE) {
                    ayz.removeCallbacks(en_424b8e16.qrJ);
                    ayz.removeCallbacks(en_424b8e16.qrK);
                    ayz.postDelayed(en_424b8e16.qrJ, 0);
                }
            } else if (!beI.pSE || !beG.pSE) {
                ayz.removeCallbacks(en_424b8e16.qrJ);
                ayz.removeCallbacks(en_424b8e16.qrK);
                ayz.postDelayed(en_424b8e16.qrK, 0);
            }
        }
    };
    private com.tencent.mm.vending.app.a.b qrO = new com.tencent.mm.vending.app.a.b<com.tencent.mm.plugin.sns.j.c.b>(this) {
        final /* synthetic */ En_424b8e16 qrZ;

        {
            this.qrZ = r1;
        }

        public final /* synthetic */ void aE(Object obj) {
            com.tencent.mm.plugin.sns.j.c.b bVar = (com.tencent.mm.plugin.sns.j.c.b) obj;
            if (bVar.qPL > 0) {
                En_424b8e16.a(this.qrZ, bVar);
                this.qrZ.qqX.findViewById(i.f.pFt).setVisibility(0);
            } else {
                this.qrZ.qqX.findViewById(i.f.pFt).setVisibility(8);
            }
            if (this.qrZ.qrp.qaU != null && this.qrZ.qrp.qaU.bkl()) {
                this.qrZ.qqX.setVisibility(0);
            } else if (bVar.qPL == 0) {
                this.qrZ.qqX.setVisibility(8);
            }
            if (this.qrZ.qqW != null && this.qrZ.qrd.hasDrawed()) {
                this.qrZ.qqW.qHY.notifyVendingDataChange();
                w.i("MicroMsg.SnsTimeLineUI", "has not show view, pass");
            }
        }
    };
    boolean qrP = true;
    private OnMenuItemClickListener qrR = new OnMenuItemClickListener(this) {
        final /* synthetic */ En_424b8e16 qrZ;

        {
            this.qrZ = r1;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            this.qrZ.aHf();
            this.qrZ.finish();
            return false;
        }
    };
    private View qrS;
    private ImageView qrT;
    private View qrU;
    private MenuItem qrV;
    private az qrW = null;
    private OnClickListener qrX = new OnClickListener(this) {
        final /* synthetic */ En_424b8e16 qrZ;

        {
            this.qrZ = r1;
        }

        public final void onClick(View view) {
            if (SystemClock.elapsedRealtime() - this.qrZ.qqT < 300) {
                En_424b8e16.D(this.qrZ);
            }
            this.qrZ.qqT = SystemClock.elapsedRealtime();
            ae.ayz().removeCallbacks(this.qrZ.qrM);
            this.qrZ.qrM.run();
        }
    };
    private boolean qrY = false;
    private boolean qra = false;
    private i qrb;
    private a qrc;
    private TestTimeForSns qrd;
    private int qre = 0;
    private boolean qrf = false;
    private String qrg = "";
    private com.tencent.mm.plugin.sns.h.a qrh = new com.tencent.mm.plugin.sns.h.a();
    protected com.tencent.mm.plugin.sns.a.a.g qri = new com.tencent.mm.plugin.sns.a.a.g(1);
    private au qrj = new au();
    private as qrk = new as();
    private String qrl;
    private boolean qrm;
    private boolean qrn;
    private int qro;
    private ba qrp;
    private Runnable qrq = new Runnable(this) {
        final /* synthetic */ En_424b8e16 qrZ;

        {
            this.qrZ = r1;
        }

        public final void run() {
            aw a = this.qrZ.qqW;
            if (a != null) {
                a.qHY.bkI();
                a.qHY.notifyVendingDataChange();
            }
        }
    };
    private c qrr = new c<rf>(this) {
        final /* synthetic */ En_424b8e16 qrZ;

        {
            this.qrZ = r2;
            this.usg = rf.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.qrZ.vQ().z(com.tencent.mm.plugin.sns.j.c.b.class);
            return false;
        }
    };
    private boolean qrs = false;
    private c qrt = new c<jx>(this) {
        final /* synthetic */ En_424b8e16 qrZ;

        {
            this.qrZ = r2;
            this.usg = jx.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (((jx) bVar) instanceof jx) {
                this.qrZ.qqU.qPH.b(this.qrZ.jia, this.qrZ.qrm, this.qrZ.qrn, this.qrZ.qro);
                this.qrZ.qqW.notifyDataSetChanged();
            }
            return false;
        }
    };
    private c qru = new c<jy>(this) {
        final /* synthetic */ En_424b8e16 qrZ;

        {
            this.qrZ = r2;
            this.usg = jy.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.qrZ.qqW.notifyDataSetChanged();
            return false;
        }
    };
    private c qrv = new c<jm>(this) {
        final /* synthetic */ En_424b8e16 qrZ;

        {
            this.qrZ = r2;
            this.usg = jm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.qrZ.qrs = true;
            return false;
        }
    };
    private c qrw = new c<jq>(this) {
        final /* synthetic */ En_424b8e16 qrZ;

        {
            this.qrZ = r2;
            this.usg = jq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            jq jqVar = (jq) bVar;
            this.qrZ.qaV = true;
            this.qrZ.qrh.qaV = this.qrZ.qaV;
            En_424b8e16.a(this.qrZ, jqVar.fQd.position);
            return false;
        }
    };
    private c qrx = new c<pn>(this) {
        final /* synthetic */ En_424b8e16 qrZ;

        {
            this.qrZ = r2;
            this.usg = pn.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (this.qrZ.qrb != null) {
                com.tencent.mm.plugin.sns.h.b bVar2 = this.qrZ.qrb.qpZ.pWR;
                bVar2.qbw++;
                this.qrZ.qrb.qpZ.pWR.hq(false);
            }
            return false;
        }
    };
    private c qry = new c<op>(this) {
        final /* synthetic */ En_424b8e16 qrZ;

        {
            this.qrZ = r2;
            this.usg = op.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            op opVar = (op) bVar;
            if (this.qrZ.qrb != null) {
                com.tencent.mm.plugin.sns.h.b bVar2 = this.qrZ.qrb.qpZ.pWR;
                String str = opVar.fVH.fVI;
                bVar2.qcM.add(opVar.fVH.fVJ);
                bVar2.qcU.add(str);
                bVar2.qbx = bVar2.qcU.size();
            }
            return false;
        }
    };
    private c qrz = new c<pd>(this) {
        final /* synthetic */ En_424b8e16 qrZ;

        {
            this.qrZ = r2;
            this.usg = pd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            pd pdVar = (pd) bVar;
            if (this.qrZ.qrb != null) {
                com.tencent.mm.plugin.sns.h.b bVar2;
                if (pdVar.fWa.fWb) {
                    bVar2 = this.qrZ.qrb.qpZ.pWR;
                    bVar2.qcW.add(pdVar.fWa.username);
                    bVar2.qbz = bVar2.qcW.size();
                } else {
                    bVar2 = this.qrZ.qrb.qpZ.pWR;
                    bVar2.qcX.add(pdVar.fWa.username);
                    bVar2.qbA = bVar2.qcX.size();
                }
            }
            return false;
        }
    };

    class a extends Animation {
        ListView mUX;
        final /* synthetic */ En_424b8e16 qrZ;
        float qsk;
        float qsl;
        float qsm = -1.0f;
        float qsn;
        float qso = 0.0f;
        private float qsp;
        boolean qsq;
        int qsr;
        boolean qss = false;
        int qst = 0;
        float qsu = 0.0f;
        float qsv = 0.0f;

        public a(En_424b8e16 en_424b8e16, ListView listView) {
            this.qrZ = en_424b8e16;
            this.mUX = listView;
        }

        public final void biL() {
            w.d("MicroMsg.SnsTimeLineUI", "animtest playLoading");
            if (this.qrZ.qqY.getVisibility() == 0) {
                init();
                this.qso = this.qsm + 20.0f;
                LayoutParams layoutParams = (LayoutParams) this.qrZ.qqY.getLayoutParams();
                layoutParams.y = (int) this.qsm;
                this.qrZ.qqY.setLayoutParams(layoutParams);
                biM();
            }
        }

        public final void biM() {
            if (this.qrZ.qqY.getVisibility() == 0) {
                init();
                this.qrZ.qqY.clearAnimation();
                this.qrZ.qqY.startAnimation(this);
                if (this.qso >= this.qsm) {
                    setDuration(20000);
                    this.qsq = false;
                    return;
                }
                setDuration(600);
                this.qsq = true;
            }
        }

        final void init() {
            if (this.qsm == -1.0f || ((double) this.qsl) < 0.1d) {
                this.qsm = (float) BackwardSupportUtil.b.a(this.qrZ, 25.0f);
                this.qsk = (float) (this.qrZ.qqY.getWidth() / 2);
                this.qsl = (float) (this.qrZ.qqY.getHeight() / 2);
                this.qsn = (this.qsl * -2.0f) - 3.0f;
                w.d("MicroMsg.SnsTimeLineUI", "MIN_Y" + this.qsn);
                this.qso = this.qsn;
                if (!this.qss) {
                    w.i("MicroMsg.SnsTimeLineUI", "initState");
                    this.qst = ((LayoutParams) this.qrZ.qqY.getLayoutParams()).y;
                    this.qsu = this.qsm;
                    this.qsv = this.qso;
                }
                this.qss = true;
            }
        }

        protected final void applyTransformation(float f, Transformation transformation) {
            if (this.qrZ.qqY.getVisibility() == 0) {
                float duration = ((float) getDuration()) * (f - this.qsp);
                if (duration >= 2.0f) {
                    this.qsp = f;
                    this.qrZ.qqY.setImageResource(i.i.pIZ);
                    this.qrZ.qqY.a(com.tencent.mm.ui.widget.QImageView.a.wxn);
                    if (((float) getDuration()) * f >= ((float) (getDuration() - 600)) || this.qsq) {
                        LayoutParams layoutParams = (LayoutParams) this.qrZ.qqY.getLayoutParams();
                        this.qso = ((float) layoutParams.y) - (duration / 3.0f);
                        layoutParams.y = (int) this.qso;
                        this.qrZ.qqY.setLayoutParams(layoutParams);
                    } else {
                        this.qrZ.qqY.mMatrix.postRotate(duration / 2.5f, this.qsk, this.qsl);
                    }
                    this.qrZ.qqY.invalidate();
                }
            }
        }

        public final void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            this.qsp = 0.0f;
            this.qso = this.qsm;
        }
    }

    static /* synthetic */ void B(En_424b8e16 en_424b8e16) {
        int i = 1;
        if (en_424b8e16.qre <= 3) {
            int firstVisiblePosition = en_424b8e16.qrp.mUX.getFirstVisiblePosition();
            if (System.currentTimeMillis() - en_424b8e16.qrH > 1000 || firstVisiblePosition > en_424b8e16.nVs) {
                en_424b8e16.qrH = 0;
                en_424b8e16.nVs = en_424b8e16.qrp.mUX.getFirstVisiblePosition();
            }
            en_424b8e16.qrH = System.currentTimeMillis();
            if (en_424b8e16.nVs - firstVisiblePosition >= 10 && firstVisiblePosition > 10) {
                w.i("MicroMsg.SnsTimeLineUI", "showTopTip %d", new Object[]{Integer.valueOf(en_424b8e16.qre)});
                if (en_424b8e16.qre <= 3) {
                    l lVar = en_424b8e16.uSU;
                    if (lVar.Gx == null || lVar.Gx.getCustomView() == null || lVar.Gx.getCustomView().findViewById(com.tencent.mm.s.a.g.hca) == null) {
                        i = 0;
                    }
                    if (i == 0) {
                        Animation loadAnimation = AnimationUtils.loadAnimation(en_424b8e16.uSU.uTo, com.tencent.mm.plugin.sns.i.a.pyV);
                        CharSequence string = en_424b8e16.getString(j.pKz);
                        l lVar2 = en_424b8e16.uSU;
                        if (lVar2.Gx != null) {
                            lVar2.Gx.setCustomView(l.uTE);
                            TextView textView = (TextView) lVar2.Gx.getCustomView().findViewById(com.tencent.mm.s.a.g.hca);
                            if (textView != null) {
                                textView.clearAnimation();
                                if (loadAnimation != null) {
                                    textView.startAnimation(loadAnimation);
                                }
                                if (!bg.mA(string)) {
                                    textView.setText(string);
                                }
                            }
                        }
                        en_424b8e16.uSU.bQf();
                        en_424b8e16.zn(16908332);
                        en_424b8e16.biu();
                        en_424b8e16.qre++;
                        ae.ayz().removeCallbacks(en_424b8e16.qrM);
                        ae.ayz().postDelayed(en_424b8e16.qrM, 4000);
                    }
                }
            }
        }
    }

    static /* synthetic */ void D(En_424b8e16 en_424b8e16) {
        w.i("MicroMsg.SnsTimeLineUI", "double click");
        BackwardSupportUtil.c.a(en_424b8e16.qrp.mUX);
        en_424b8e16.qqY.setVisibility(0);
        en_424b8e16.qrM.run();
        en_424b8e16.qrb.bil();
        en_424b8e16.biz();
        new com.tencent.mm.sdk.platformtools.ae().postDelayed(new Runnable(en_424b8e16) {
            final /* synthetic */ En_424b8e16 qrZ;

            {
                this.qrZ = r1;
            }

            public final void run() {
                this.qrZ.qrp.mUX.setSelection(0);
                a y = this.qrZ.qrc;
                if (y.qss) {
                    LayoutParams layoutParams = (LayoutParams) y.qrZ.qqY.getLayoutParams();
                    layoutParams.y = y.qst;
                    y.qrZ.qqY.setLayoutParams(layoutParams);
                    y.qsm = y.qsu;
                    y.qso = y.qsv;
                }
                this.qrZ.qrc.biL();
                this.qrZ.qqU.qPH.b(this.qrZ.jia, this.qrZ.qrm, this.qrZ.qrn, this.qrZ.qro);
            }
        }, 300);
    }

    static /* synthetic */ void E(En_424b8e16 en_424b8e16) {
        en_424b8e16.bix();
        if (!(en_424b8e16.qrb == null || en_424b8e16.qrb.qpZ == null)) {
            en_424b8e16.qrb.qpZ.pWR.hq(true);
        }
        final com.tencent.mm.modelsns.b gz = com.tencent.mm.modelsns.b.gz(705);
        gz.gD(gz.hTu).kH(System.currentTimeMillis()).gD(gz.hTw).gD(1);
        en_424b8e16.qrW = new az(en_424b8e16);
        en_424b8e16.qrW.qJf = new n.c(en_424b8e16) {
            final /* synthetic */ En_424b8e16 qrZ;

            {
                this.qrZ = r1;
            }

            public final void a(com.tencent.mm.ui.base.l lVar) {
                if (!r.ijS) {
                    lVar.e(3, this.qrZ.getString(j.dHa));
                }
                lVar.e(1, this.qrZ.getString(j.dHe));
            }
        };
        en_424b8e16.qrW.c(3, en_424b8e16.uSU.uTo.getString(j.pJE));
        en_424b8e16.qrW.qJg = new n.d(en_424b8e16) {
            final /* synthetic */ En_424b8e16 qrZ;

            public final void c(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 1:
                        com.tencent.mm.plugin.report.service.g.oUh.i(13822, new Object[]{Integer.valueOf(2), Integer.valueOf(2)});
                        com.tencent.mm.plugin.sns.h.e.qdB.a(gz);
                        gz.JE();
                        this.qrZ.qrp.qJN = gz;
                        this.qrZ.qrp.ui(1);
                        return;
                    case 3:
                        this.qrZ.biy();
                        return;
                    default:
                        return;
                }
            }
        };
        en_424b8e16.qrW.blb();
    }

    static /* synthetic */ void a(En_424b8e16 en_424b8e16, int i) {
        com.tencent.mm.modelsns.b gz = com.tencent.mm.modelsns.b.gz(507);
        int firstVisiblePosition = en_424b8e16.qrp.mUX.getFirstVisiblePosition() - 1;
        int lastVisiblePosition = en_424b8e16.qrp.mUX.getLastVisiblePosition() - 1;
        int count = en_424b8e16.qqW.getCount();
        while (firstVisiblePosition <= lastVisiblePosition) {
            if (firstVisiblePosition < count && firstVisiblePosition >= 0 && firstVisiblePosition != i) {
                if (i > firstVisiblePosition) {
                    String g = com.tencent.mm.plugin.sns.data.i.g(en_424b8e16.qrb.pZQ.tM(firstVisiblePosition));
                    if (gz.JA()) {
                        if (gz.hTC.length() != 0) {
                            gz.hTC.append("||" + g);
                        } else if (bg.mA(g)) {
                            gz.hTC.append(" ");
                        } else {
                            gz.hTC.append(g);
                        }
                    }
                } else {
                    gz.kG(com.tencent.mm.plugin.sns.data.i.g(en_424b8e16.qrb.pZQ.tM(firstVisiblePosition)));
                }
            }
            firstVisiblePosition++;
        }
        gz.JE();
    }

    static /* synthetic */ void a(En_424b8e16 en_424b8e16, int i, int i2, gg ggVar) {
        int firstVisiblePosition = en_424b8e16.qrb.mUX.getFirstVisiblePosition();
        int headerViewsCount = en_424b8e16.qrb.mUX.getHeaderViewsCount();
        m tM = en_424b8e16.qrb.pZQ.tM(i2);
        if (tM != null) {
            bfc bhd = tM.bhd();
            if (bhd.ufB.tsN == 1 && bhd.ufB.tsO.size() == 4 && i > 1) {
                i++;
            }
        } else {
            w.e("MicroMsg.SnsTimeLineUI", "snsInfo is null");
        }
        View childAt = en_424b8e16.qrb.mUX.getChildAt((i2 - firstVisiblePosition) + headerViewsCount);
        if (childAt != null && childAt.getTag() != null && (childAt.getTag() instanceof com.tencent.mm.plugin.sns.ui.a.a.c)) {
            com.tencent.mm.plugin.sns.ui.a.a.c cVar = (com.tencent.mm.plugin.sns.ui.a.a.c) childAt.getTag();
            if (cVar.qMr != null) {
                TagImageView tR = cVar.qMr.tR(i);
                if (tR != null) {
                    int[] iArr = new int[2];
                    tR.getLocationInWindow(iArr);
                    ggVar.fLy.fEb = iArr[0];
                    ggVar.fLy.fEc = iArr[1];
                    ggVar.fLy.fEd = tR.getWidth();
                    ggVar.fLy.fEe = tR.getHeight();
                }
            }
        }
    }

    static /* synthetic */ void a(En_424b8e16 en_424b8e16, com.tencent.mm.plugin.sns.j.c.b bVar) {
        en_424b8e16.qqX.setVisibility(0);
        ((TextView) en_424b8e16.findViewById(i.f.pFw)).setText(en_424b8e16.getResources().getQuantityString(h.pII, bVar.qPL, new Object[]{Integer.valueOf(bVar.qPL)}));
        com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) en_424b8e16.findViewById(i.f.pFu), bVar.qPK);
    }

    public final void a(final boolean z, final boolean z2, final String str, boolean z3, boolean z4, int i, long j) {
        this.qrL.removeCallbacks(this.qrq);
        g.cbJ().b(new com.tencent.mm.vending.c.a<Void, Void>(this) {
            final /* synthetic */ En_424b8e16 qrZ;

            public final /* synthetic */ Object call(Object obj) {
                Void voidR = (Void) obj;
                aw a = this.qrZ.qqW;
                if (a != null) {
                    a.qHY.qxe = str;
                    av avVar = a.qHY;
                    avVar.looperCheckForVending();
                    w.i("MicroMsg.SnsTimeLineVendingSide", "resetSize %s", new Object[]{Boolean.valueOf(avVar.qHS)});
                    if (!avVar.qHS) {
                        avVar.lri = avVar.p(0, avVar.lri);
                    }
                    a.qHY.notifyVendingDataChange();
                }
                return voidR;
            }
        }).d(new com.tencent.mm.vending.c.a<Void, Void>(this) {
            final /* synthetic */ En_424b8e16 qrZ;

            public final /* synthetic */ Object call(Object obj) {
                Void voidR = (Void) obj;
                this.qrZ.qrp.qJJ = z2;
                if (z2) {
                    this.qrZ.qrp.hG(false);
                } else if (z) {
                    this.qrZ.qqU.qPI.b("@__weixintimtline", this.qrZ.qrm, this.qrZ.qrn, 0);
                }
                return voidR;
            }
        });
    }

    public final void a(final boolean z, final String str, boolean z2, boolean z3, int i, long j) {
        this.qrL.removeCallbacks(this.qrq);
        g.cbJ().b(new com.tencent.mm.vending.c.a<Void, Void>(this) {
            final /* synthetic */ En_424b8e16 qrZ;

            public final /* synthetic */ Object call(Object obj) {
                Void voidR = (Void) obj;
                aw a = this.qrZ.qqW;
                if (a != null) {
                    a.qHY.qxe = str;
                    a.qHY.bkI();
                    a.qHY.notifyVendingDataChange();
                }
                return voidR;
            }
        }).d(new com.tencent.mm.vending.c.a<Void, Void>(this) {
            final /* synthetic */ En_424b8e16 qrZ;

            public final /* synthetic */ Object call(Object obj) {
                Void voidR = (Void) obj;
                this.qrZ.qrp.qJJ = z;
                w.d("MicroMsg.SnsTimeLineUI", "onNpSize %s", new Object[]{Boolean.valueOf(z)});
                if (z) {
                    this.qrZ.qrp.hG(false);
                }
                return voidR;
            }
        });
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int i = 0;
        w.i("MicroMsg.SnsTimeLineUI", "dispatchKeyEvent %s", new Object[]{keyEvent.toString()});
        int i2 = this.uSU.uTG;
        i iVar = this.qrb;
        if (keyEvent.getKeyCode() == 4 && iVar.qqb.getVisibility() == 0) {
            iVar.qqb.setVisibility(8);
            i = 1;
        }
        if (i == 0 || i2 != 2) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public void onCreate(Bundle bundle) {
        int i = 1;
        if (this.uSU != null) {
            this.uSU.ag(2, true);
        }
        getIntent().setExtrasClassLoader(getClass().getClassLoader());
        com.tencent.mm.pluginsdk.e.f(this);
        super.onCreate(bundle);
        int cF = com.tencent.mm.u.c.c.AA().cF("Sns_Private_Recent_Setting_Guide", 0);
        w.i("MicroMsg.SnsTimeLineUI", "Sns_Private_Recent_Setting_Guide abtestvalue = " + cF);
        if (cF == 1) {
            com.tencent.mm.kernel.h.vJ();
            if (!com.tencent.mm.kernel.h.vI().vr().c(com.tencent.mm.storage.w.a.uGf, false)) {
                Intent intent = getIntent();
                intent.setClass(this.uSU.uTo, SnsSettingIntroduceUI.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
                com.tencent.mm.kernel.h.vJ();
                com.tencent.mm.kernel.h.vI().vr().a(com.tencent.mm.storage.w.a.uGf, Boolean.valueOf(true));
            }
        }
        com.tencent.mm.bl.b.bOh();
        this.qqV.a(com.tencent.mm.plugin.sns.j.c.b.class, this.qrO);
        this.qqV.a(this);
        com.tencent.mm.plugin.sns.j.c.a aVar = (com.tencent.mm.plugin.sns.j.c.a) this.qqV.y(com.tencent.mm.plugin.sns.j.c.a.class);
        this.jia = aVar.jia;
        this.qrl = aVar.qrl;
        this.qrm = aVar.qrm;
        this.qrn = aVar.qrn;
        this.qro = aVar.qro;
        String str = aVar.mwO;
        String str2 = aVar.qJM;
        this.qrp = new ba(this);
        this.qrp.qJL = this.qrN;
        ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.notification.b.a.class)).getNotification().dP(2);
        com.tencent.mm.plugin.sns.ui.widget.c.blK().qPx = 0;
        com.tencent.mm.plugin.sns.ui.widget.a.blI().qPx = 0;
        com.tencent.mm.modelsns.c cVar = com.tencent.mm.modelsns.c.hTG;
        com.tencent.mm.modelsns.c.JF();
        this.qrb = new i(this, getIntent().getBooleanExtra("is_sns_notify_open", true) ? 1 : 0, bg.ap(getIntent().getStringExtra("new_feed_id"), ""), getIntent().getIntExtra("sns_unread_count", 0));
        this.qqg = getIntent().getBooleanExtra("sns_resume_state", true);
        if (ae.beu()) {
            this.qqg = false;
        } else if (this.qqg) {
            this.qqg = ae.beR().bjC();
        }
        this.qqZ = this.qqg;
        this.qrp.a(this.qrl, this.jia, str, str2, this.qrm, this.qrn, this.qro);
        this.qrp.onCreate();
        ae.beC().init();
        this.Gx = cO().cP();
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vH().gXC.a(com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX, this);
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vH().gXC.a(682, this);
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vH().gXC.a(218, this);
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vH().gXC.a(com.tencent.mm.plugin.appbrand.jsapi.share.g.CTRL_INDEX, this);
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vH().gXC.a(683, this);
        KC();
        com.tencent.mm.plugin.sns.f.c beC = ae.beC();
        ListView listView = this.qrp.mUX;
        au auVar = this.qqW.qHX;
        beC.pZP = listView;
        beC.pZQ = auVar;
        e beC2 = ae.beC();
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vH().gXC.a(291, beC2);
        this.qra = getIntent().getBooleanExtra("sns_timeline_NeedFirstLoadint", false);
        this.qrb.lMa = (ClipboardManager) getSystemService("clipboard");
        if (ae.beu()) {
            this.qqg = false;
        } else if (this.qqg) {
            this.qqg = ae.beR().bjC();
        }
        com.tencent.mm.vending.app.a aVar2 = this.qqV;
        aVar2.qHY = this.qqW.qHY;
        aVar2.wBD.a(aVar2.qHY);
        if (this.qqg) {
            this.qra = false;
            cF = ae.beR().position;
            this.qqW.qHY.lri = ae.beR().lri;
            this.qqW.qHY.qxe = ae.beR().qxe;
            this.qqW.qHY.qHS = true;
            this.qqW.sL();
            if (cF >= this.qqW.getCount()) {
                cF = this.qqW.getCount() - 1;
                w.e("MicroMsg.SnsTimeLineUI", "error position %s", new Object[]{Integer.valueOf(this.qqW.getCount())});
            }
            this.qrp.mUX.setAdapter(this.qqW);
            w.d("MicroMsg.SnsTimeLineUI", "resume position %s", new Object[]{Integer.valueOf(ae.beR().qxf)});
            this.qrp.mUX.setSelectionFromTop(cF, ae.beR().qxf);
            this.qqY.setVisibility(4);
        } else {
            this.qrp.mUX.setAdapter(this.qqW);
            this.qqY.setVisibility(0);
            this.qqW.sL();
        }
        int count = this.qqW.getCount();
        cF = this.qrp.mUX.getFirstVisiblePosition();
        if (cF < count) {
            this.qrg = com.tencent.mm.plugin.sns.data.i.g(this.qqW.tM(cF));
        }
        com.tencent.mm.kernel.h.vJ();
        this.qre = ((Integer) com.tencent.mm.kernel.h.vI().vr().get(327776, Integer.valueOf(0))).intValue();
        this.qrb.qqi = new bg(this, this.qqW.qHX, this.qrb.pZl);
        this.qrb.qqk = new com.tencent.mm.plugin.sns.f.b(this, this.qqW.qHX.pZk, this.qrb.pZl);
        this.qrb.qqj = new c(this, this.qqW.qHX.pZk, this.qrb.pZl, this.qrb.qqk);
        if (this.qrk != null) {
            this.qrk.a(this.qrb.qqk);
        }
        if (count > 0) {
            m tM = this.qqW.tM(0);
            if (!(this.qrb.qpZ == null || this.qrb.qpZ.pWR == null)) {
                this.qrb.qpZ.pWR.qbq = tM.field_snsId;
            }
            com.tencent.mm.plugin.sns.h.d dVar = com.tencent.mm.plugin.sns.h.d.qdx;
            if (dVar.gVo != 0) {
                if (dVar.qdy.isEmpty()) {
                    dVar.gKF.setLong(2, bg.Ny());
                }
                w.i("MicroMsg.SnsReportHelper", "enterTimeLine exposureFeedSize %d", new Object[]{Integer.valueOf(dVar.qdy.size())});
            }
        }
        com.tencent.mm.plugin.report.service.g.oUh.A(13312, "1," + bg.Nz());
        com.tencent.mm.sdk.b.a.urY.b(this.qrr);
        if (getIntent().getBooleanExtra("is_need_resend_sns", false)) {
            af.f(new Runnable(this) {
                final /* synthetic */ En_424b8e16 qrZ;

                {
                    this.qrZ = r1;
                }

                public final void run() {
                    com.tencent.mm.ui.base.g.a(this.qrZ, this.qrZ.getString(j.eEr), "", this.qrZ.getString(j.eEs), this.qrZ.getString(j.dGs), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass20 qsh;

                        {
                            this.qsh = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.sdk.b.a.urY.m(new mu());
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass20 qsh;

                        {
                            this.qsh = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.sdk.b.a.urY.m(new ke());
                        }
                    });
                }
            }, 500);
            getIntent().putExtra("is_need_resend_sns", false);
        }
        com.tencent.mm.kernel.h.vJ();
        if (com.tencent.mm.kernel.h.vG().uV()) {
            com.tencent.mm.kernel.h.vJ();
            com.tencent.mm.kernel.h.vI().vr().set(589825, Boolean.valueOf(false));
        }
        this.qrb.qpY = this.qri;
        com.tencent.mm.plugin.sns.a.a.g gVar = this.qri;
        count = this.qrp.pOu;
        View customView = this.Gx.getCustomView();
        gVar.pOu = count;
        gVar.pPi = customView;
        gVar.activity = this;
        com.tencent.mm.sdk.b.a.urY.b(this.qrv);
        com.tencent.mm.sdk.b.a.urY.b(this.qrw);
        com.tencent.mm.sdk.b.a.urY.b(this.qrx);
        com.tencent.mm.sdk.b.a.urY.b(this.qry);
        com.tencent.mm.sdk.b.a.urY.b(this.qrz);
        com.tencent.mm.sdk.b.a.urY.b(this.qrB);
        com.tencent.mm.sdk.b.a.urY.b(this.qrA);
        com.tencent.mm.sdk.b.a.urY.b(this.pXq);
        com.tencent.mm.sdk.b.a.urY.b(this.qrC);
        com.tencent.mm.sdk.b.a.urY.b(this.qrD);
        com.tencent.mm.sdk.b.a.urY.b(this.qrF);
        com.tencent.mm.sdk.b.a.urY.b(this.qrE);
        com.tencent.mm.sdk.b.a.urY.b(this.qrG);
        com.tencent.mm.plugin.sns.abtest.c.bdk();
        com.tencent.mm.plugin.sns.abtest.a.b((Context) this, this.qrb.pZl);
        if (this.qrh != null) {
            com.tencent.mm.plugin.sns.h.a aVar3 = this.qrh;
            listView = this.qrp.mUX;
            SnsHeader snsHeader = this.qrp.qaU;
            aVar3.iuu = listView;
            aVar3.qaU = snsHeader;
        }
        if (!(this.qrb == null || this.qrb.qpZ == null)) {
            com.tencent.mm.plugin.sns.h.b bVar = this.qrb.qpZ.pWR;
            w.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineCreate");
            bVar.qbp = true;
            bVar.qdm = System.currentTimeMillis();
        }
        boolean booleanExtra = getIntent().getBooleanExtra("enter_by_red", false);
        if (!(this.qrb == null || this.qrb.qpZ == null)) {
            com.tencent.mm.plugin.sns.h.b bVar2 = this.qrb.qpZ.pWR;
            if (!booleanExtra) {
                i = 0;
            }
            bVar2.qbC = i;
        }
        ae.beI().pSY.clear();
        com.tencent.mm.pluginsdk.e.g(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        w.i("MicroMsg.SnsTimeLineUI", "onConfigurationChanged");
        com.tencent.mm.sdk.b.a.urY.m(new bs());
        com.tencent.mm.pluginsdk.e.g(this);
        com.tencent.mm.plugin.sns.ui.widget.c.blK().qPx = 0;
        com.tencent.mm.plugin.sns.ui.widget.a.blI().qPx = 0;
        com.tencent.mm.kiss.widget.textview.c.hag.vV();
        this.qqW.qHX.bkR();
        this.qqW.qHY.resolvedClear();
    }

    public void onDestroy() {
        this.qrf = true;
        w.i("MicroMsg.SnsTimeLineUI", "timeline on destory");
        com.tencent.mm.sdk.b.a.urY.c(this.qrv);
        com.tencent.mm.sdk.b.a.urY.c(this.qrw);
        com.tencent.mm.sdk.b.a.urY.c(this.qrx);
        com.tencent.mm.sdk.b.a.urY.c(this.qry);
        com.tencent.mm.sdk.b.a.urY.c(this.qrz);
        com.tencent.mm.sdk.b.a.urY.c(this.qrB);
        com.tencent.mm.sdk.b.a.urY.c(this.qrA);
        com.tencent.mm.sdk.b.a.urY.c(this.pXq);
        com.tencent.mm.sdk.b.a.urY.c(this.qrC);
        com.tencent.mm.sdk.b.a.urY.c(this.qrD);
        com.tencent.mm.sdk.b.a.urY.c(this.qrE);
        com.tencent.mm.sdk.b.a.urY.c(this.qrF);
        com.tencent.mm.sdk.b.a.urY.c(this.qrG);
        if (!(this.qrb == null || this.qrb.qpZ == null)) {
            this.qrb.qpZ.pWR.qbD = this.qrs ? 1 : 0;
        }
        com.tencent.mm.plugin.sns.h.d dVar = com.tencent.mm.plugin.sns.h.d.qdx;
        if (dVar.gVo != 0) {
            w.i("MicroMsg.SnsReportHelper", "exitTimeline exposureFeedSize %d", new Object[]{Integer.valueOf(dVar.qdy.size())});
            long j = dVar.gKF.getLong(2, 0);
            if (dVar.qdy.isEmpty() || (dVar.qdy.size() <= dVar.qdz && bg.az(j) <= ((long) dVar.qdA))) {
                dVar.gKF.set(3, dVar.qdy);
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                for (String str : dVar.qdy.keySet()) {
                    stringBuffer.append(str + "#" + dVar.qdy.get(str) + "|");
                }
                stringBuffer.append("," + j + "," + bg.Ny() + ",1");
                w.v("MicroMsg.SnsReportHelper", "report(13226) %d: %s", new Object[]{Integer.valueOf(13226), stringBuffer});
                com.tencent.mm.plugin.report.service.g.oUh.A(13226, stringBuffer.toString());
                dVar.gKF.set(3, null);
                dVar.qdy.clear();
                dVar.gKF.setLong(2, bg.Ny());
            }
        }
        com.tencent.mm.kernel.h.vJ();
        String str2 = (String) com.tencent.mm.kernel.h.vI().vr().get(68377, null);
        int count = this.qqW.getCount();
        String str3 = "";
        m mVar = null;
        if (count > 0) {
            mVar = this.qqW.tM(count - 1);
            str3 = com.tencent.mm.plugin.sns.data.i.g(mVar);
        }
        if (!(this.qrb == null || this.qrb.qpZ == null)) {
            com.tencent.mm.plugin.sns.h.b bVar = this.qrb.qpZ.pWR;
            int i = mVar == null ? -1 : mVar.field_createTime;
            w.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineDestroy");
            long currentTimeMillis = System.currentTimeMillis() - bVar.qdm;
            bVar.qbr += currentTimeMillis;
            w.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineEns passedtime: " + currentTimeMillis + " BrowseTime: " + bVar.qbr + "BackgroundTime: " + bVar.qca);
            com.tencent.mm.sdk.f.e.b(new com.tencent.mm.plugin.sns.h.b.AnonymousClass2(bVar, i), "onTimelineDestroy_report", 1);
            bVar.qbp = false;
        }
        com.tencent.mm.modelsns.b gz = com.tencent.mm.modelsns.b.gz(704);
        if (gz.JA()) {
            gz.bp(this.qrs);
            gz.bp(!bg.mA(str2));
            gz.kG(this.qrg);
            gz.kG(str3);
            gz.kG(str3);
            gz.gC(this.qrp.qJK);
            gz.kG("");
            com.tencent.mm.modelsns.b.JD();
            gz.JE();
        }
        AdListView adListView = (AdListView) this.qrp.biB();
        this.qrk.pXJ.clear();
        ae.beC().clean();
        ae.bey().post(new Runnable(ae.beF()) {
            final /* synthetic */ i pPN;

            {
                this.pPN = r1;
            }

            public final void run() {
                this.pPN.bdt();
            }
        });
        adListView.qoI.clear();
        adListView.qoI = null;
        adListView.qoJ.bdZ();
        adListView.qoJ = null;
        t.bef();
        if (!ae.beu()) {
            this.qrL.removeCallbacks(this.qrq);
        }
        com.tencent.mm.kernel.h.vJ();
        if (com.tencent.mm.kernel.h.vG().uV()) {
            com.tencent.mm.kernel.h.vJ();
            com.tencent.mm.kernel.h.vH().gXC.b(com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX, this);
            com.tencent.mm.kernel.h.vJ();
            com.tencent.mm.kernel.h.vH().gXC.b(682, this);
            com.tencent.mm.kernel.h.vJ();
            com.tencent.mm.kernel.h.vH().gXC.b(218, this);
            com.tencent.mm.kernel.h.vJ();
            com.tencent.mm.kernel.h.vH().gXC.b(com.tencent.mm.plugin.appbrand.jsapi.share.g.CTRL_INDEX, this);
            com.tencent.mm.kernel.h.vJ();
            com.tencent.mm.kernel.h.vH().gXC.b(683, this);
            com.tencent.mm.kernel.h.vJ();
            com.tencent.mm.kernel.h.vI().vr().set(327776, Integer.valueOf(this.qre));
            com.tencent.mm.kernel.h.vJ();
            com.tencent.mm.kernel.h.vI().vr().set(589825, Boolean.valueOf(false));
        }
        if (this.qrb != null) {
            i iVar = this.qrb;
            iVar.qql.amk();
            if (iVar.qqb != null) {
                iVar.qqb.aIL();
            }
            com.tencent.mm.sdk.b.a.urY.c(iVar.qqn);
        }
        ae.ayz().removeCallbacks(this.qrM);
        if (this.qqW != null) {
            int i2;
            int firstVisiblePosition = this.qrp.mUX.getFirstVisiblePosition();
            i = 0;
            for (i2 = 0; i2 < this.qrp.mUX.getCount(); i2++) {
                View childAt = this.qrp.mUX.getChildAt(i2);
                if (childAt != null && this.qrp.mUX.getPositionForView(childAt) == firstVisiblePosition) {
                    int[] iArr = new int[2];
                    childAt.getLocationInWindow(iArr);
                    w.d("MicroMsg.SnsTimeLineUI", "this is the pos for view %d x %d y %d", new Object[]{Integer.valueOf(r4), Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1])});
                    i = iArr[1];
                }
            }
            i2 = BackwardSupportUtil.b.a(this, 50.0f);
            if (!(ae.beu() || this.qqV.beB() == null)) {
                ai beR = ae.beR();
                String str4 = this.qqW.qHY.lri;
                String str5 = this.qqW.qHY.qxe;
                long j2 = this.qqV.beB().pXf;
                int i3 = i - i2;
                beR.qxd = bg.NA();
                beR.lri = str4;
                beR.qxe = str5;
                beR.pXf = j2;
                beR.position = firstVisiblePosition;
                beR.qxf = i3;
                w.i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s", new Object[]{Long.valueOf(beR.qxd), str4, str5, Long.valueOf(j2), Integer.valueOf(firstVisiblePosition), Integer.valueOf(beR.qxf)});
            }
            w.d("MicroMsg.SnsTimeLineUI", "top h %d", new Object[]{Integer.valueOf(i - i2)});
            com.tencent.mm.sdk.b.a.urY.c(this.qqW.qHX.iOT);
            if (ae.beu()) {
                w.e("MicroMsg.SnsTimeLineBaseAdapter", "is invalid to getSnsInfoStorage");
            } else {
                ae.beI();
            }
            au auVar = this.qqW.qHX;
            if (auVar.qzO != null) {
                auVar.qzO.activity = null;
            }
            com.tencent.mm.sdk.b.a.urY.c(this.qqW.qHX.iOT);
            this.qqW.qHX.bkU();
        }
        ay.clean();
        com.tencent.mm.sdk.b.a.urY.c(this.qrr);
        com.tencent.mm.kernel.h.vJ();
        if (com.tencent.mm.kernel.h.vG().uV()) {
            ae.beI().pSY.clear();
        }
        this.qqW = null;
        this.qrb = null;
        aw.bkZ();
        com.tencent.mm.plugin.sns.abtest.c.bdl();
        e beC = ae.beC();
        com.tencent.mm.kernel.h.vJ();
        com.tencent.mm.kernel.h.vH().gXC.b(291, beC);
        com.tencent.mm.plugin.sns.abtest.a.clean();
        this.qrp.onDestroy();
        super.onDestroy();
        com.tencent.mm.kiss.widget.textview.c.hag.vV();
    }

    public void onResume() {
        int count;
        if (com.tencent.mm.sdk.a.b.bIu() && com.tencent.mm.sdk.a.b.bIs()) {
            qrQ.add(this);
        }
        ba.onResume();
        super.onResume();
        this.jXw = bg.Ny();
        if (this.qrP) {
            this.qrP = false;
            count = this.qqW.getCount();
            if (getIntent().getBooleanExtra("is_from_find_more", false)) {
                com.tencent.mm.modelsns.b c = com.tencent.mm.modelsns.b.c(getIntent(), "enter_log");
                if (c != null) {
                    if (count > 0) {
                        String str;
                        m tM = this.qqW.tM(0);
                        if (tM == null) {
                            str = "0";
                        } else {
                            str = com.tencent.mm.plugin.sns.data.i.df(tM.field_snsId);
                        }
                        c.kG(str);
                        if (tM == null) {
                            str = "0";
                        } else {
                            str = tM.field_createTime;
                        }
                        c.kG(str);
                        c.kG(String.valueOf(count));
                    } else {
                        c.kG("");
                        c.kG("");
                        c.kG("0");
                    }
                    c.JE();
                }
            }
        }
        if (this.mScreenWidth == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.mScreenWidth = displayMetrics.widthPixels;
            this.mScreenHeight = displayMetrics.heightPixels;
            com.tencent.mm.plugin.sns.h.a aVar = this.qrh;
            count = this.mScreenWidth;
            int i = this.mScreenHeight;
            aVar.mScreenWidth = count;
            aVar.mScreenHeight = i;
        }
        if (ae.beu()) {
            finish();
        }
        ae.beI().pTa = this.qqW.qHX;
        vQ().z(com.tencent.mm.plugin.sns.j.c.b.class);
        t.a((ak) this);
        if (this.qra) {
            this.qqY.post(new Runnable(this) {
                final /* synthetic */ En_424b8e16 qrZ;

                {
                    this.qrZ = r1;
                }

                public final void run() {
                    w.i("MicroMsg.SnsTimeLineUI", "onResume go to playAnim " + this.qrZ.qra);
                    if (this.qrZ.qra) {
                        this.qrZ.qra = false;
                        this.qrZ.qrc.biL();
                    }
                }
            });
        } else {
            a aVar2 = this.qrc;
            if (aVar2.qrZ.qqY.getVisibility() == 0) {
                aVar2.init();
                LayoutParams layoutParams = (LayoutParams) aVar2.qrZ.qqY.getLayoutParams();
                layoutParams.y = (int) aVar2.qsn;
                aVar2.qrZ.qqY.setLayoutParams(layoutParams);
                aVar2.qrZ.qqY.invalidate();
            }
        }
        b qvVar = new qv();
        qvVar.fXQ.fXR = this.qrp.mUX.getFirstVisiblePosition();
        qvVar.fXQ.fXS = this.qrp.mUX.getLastVisiblePosition();
        qvVar.fXQ.fXT = this.qrp.mUX.getHeaderViewsCount();
        qvVar.fXQ.type = 0;
        com.tencent.mm.sdk.b.a.urY.m(qvVar);
        if (!(this.qrb == null || this.qrb.qpY == null)) {
            this.qrb.qpY.onResume();
        }
        if (this.qqW != null) {
            au auVar = this.qqW.qHX;
            com.tencent.mm.sdk.b.a.urY.b(auVar.qAd);
            com.tencent.mm.sdk.b.a.urY.b(auVar.qAc);
            com.tencent.mm.sdk.b.a.urY.b(auVar.qAe);
        }
        if (!(this.qrb == null || this.qrb.qpZ == null)) {
            this.qrb.qpZ.pWR.hm(true);
            this.qrb.qpZ.pWR.hn(false);
            this.qrb.qpZ.pWR.ho(false);
            this.qrb.qpZ.pWR.hp(false);
            this.qrb.qpZ.pWR.hz(false);
            com.tencent.mm.plugin.sns.h.b bVar = this.qrb.qpZ.pWR;
            bVar.hx(false);
            bVar.hy(false);
            bVar.hr(false);
            bVar.hw(false);
            bVar.hu(false);
            bVar.hw(false);
            bVar.hA(false);
            bVar.hv(false);
            bVar.hw(false);
            bVar.hs(false);
            bVar.ht(false);
        }
        com.tencent.mm.plugin.sns.model.g beI = ae.beI();
        beI.pTb = 0;
        beI.pTc = 0;
        com.tencent.mm.sdk.b.a.urY.b(this.qru);
        com.tencent.mm.sdk.b.a.urY.b(this.qrt);
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onPause() {
        this.qqY.clearAnimation();
        t.b(this);
        ae.beI().pTa = null;
        b qvVar = new qv();
        qvVar.fXQ.type = 1;
        com.tencent.mm.sdk.b.a.urY.m(qvVar);
        if (this.qqW != null) {
            au auVar = this.qqW.qHX;
            com.tencent.mm.sdk.b.a.urY.c(auVar.qAd);
            com.tencent.mm.sdk.b.a.urY.c(auVar.qAc);
            com.tencent.mm.sdk.b.a.urY.c(auVar.qAe);
        }
        if (!(this.qrb == null || this.qrb.qpY == null)) {
            this.qrb.qpY.jXw = bg.NA();
        }
        if (!(this.qrb == null || this.qrb.qpZ == null)) {
            this.qrb.qpZ.pWR.hm(false);
        }
        com.tencent.mm.modelstat.d.d("En_424b8e16", this.jXw, bg.Ny());
        ba.onPause();
        super.onPause();
        com.tencent.mm.sdk.b.a.urY.c(this.qru);
        com.tencent.mm.sdk.b.a.urY.c(this.qrt);
    }

    protected final int getLayoutId() {
        return i.g.pIs;
    }

    protected final void KC() {
        this.qrp.qaU.setDrawingCacheEnabled(false);
        this.qrb.pZl = (FrameLayout) findViewById(i.f.pGg);
        zi(j.pMJ);
        int i = ae.beR().position;
        AdListView adListView = (AdListView) this.qrp.biB();
        adListView.qoI = this.qri;
        adListView.qoJ = this.qrj;
        adListView.qoK = this.qrk;
        this.qrk.a(ae.beC());
        w.i("MicroMsg.SnsTimeLineUI", "oncreate firstPosition %d isToResume: " + this.qqg, new Object[]{Integer.valueOf(i)});
        this.qqY = (QFadeImageView) findViewById(i.f.pFH);
        this.qqY.setImageResource(i.i.pIZ);
        this.qrc = new a(this, this.qrp.biB());
        this.qrc.setInterpolator(new LinearInterpolator());
        this.qrc.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ En_424b8e16 qrZ;

            {
                this.qrZ = r1;
            }

            public final void onAnimationStart(Animation animation) {
                w.i("MicroMsg.SnsTimeLineUI", "refreshAnim start");
            }

            public final void onAnimationRepeat(Animation animation) {
                w.i("MicroMsg.SnsTimeLineUI", "refreshAnim repeat");
            }

            public final void onAnimationEnd(Animation animation) {
                w.i("MicroMsg.SnsTimeLineUI", "refreshAnim end");
            }
        });
        this.qqW = new aw(this, this.qrp.biB(), this.qrb.qql, this.qrb, this.qrl);
        this.qrb.qql.qNU = new com.tencent.mm.plugin.sns.ui.au.a(this) {
            final /* synthetic */ En_424b8e16 qrZ;

            {
                this.qrZ = r1;
            }

            public final boolean biH() {
                this.qrZ.vQ().z(com.tencent.mm.plugin.sns.j.c.b.class);
                return false;
            }
        };
        this.qrb.pZQ = this.qqW.qHX;
        this.qqW.qHY.wBA = new com.tencent.mm.vending.a.b.a(this) {
            final /* synthetic */ En_424b8e16 qrZ;

            {
                this.qrZ = r1;
            }

            public final void biI() {
                com.tencent.mm.plugin.report.service.f.rY(14);
            }

            public final void biJ() {
                com.tencent.mm.plugin.report.service.f.rZ(14);
            }
        };
        this.qrd = (TestTimeForSns) this.qrb.pZl;
        this.qrd.setListener(new com.tencent.mm.plugin.sns.ui.TestTimeForSns.a(this) {
            final /* synthetic */ En_424b8e16 qrZ;

            {
                this.qrZ = r1;
            }

            public final void om() {
                w.i("MicroMsg.SnsTimeLineUI", "sns has drawed");
                this.qrZ.qrd.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass26 qsi;

                    {
                        this.qsi = r1;
                    }

                    public final void run() {
                        if (this.qsi.qrZ.qqW == null || this.qsi.qrZ.qrd == null) {
                            w.i("MicroMsg.SnsTimeLineUI", "onViewDrawed is error");
                            return;
                        }
                        this.qsi.qrZ.qrd.setListener(null);
                        this.qsi.qrZ.qqg = this.qsi.qrZ.qqZ;
                        if (this.qsi.qrZ.qrf) {
                            w.w("MicroMsg.SnsTimeLineUI", "too fast that it finish");
                            return;
                        }
                        if (this.qsi.qrZ.qqg) {
                            ae.beB().w(ae.beR().pXf, -1);
                        }
                        if (!this.qsi.qrZ.qqg) {
                            this.qsi.qrZ.qqU.qPH.b(this.qsi.qrZ.jia, this.qsi.qrZ.qrm, this.qsi.qrZ.qrn, this.qsi.qrZ.qro);
                        }
                        this.qsi.qrZ.qqg = false;
                    }
                });
            }
        });
        this.qrp.mUX.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ En_424b8e16 qrZ;

            {
                this.qrZ = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    this.qrZ.biz();
                    if (this.qrZ.qrp.mUX != null && this.qrZ.qrp.mUX.getFirstVisiblePosition() == 0) {
                        w.d("MicroMsg.SnsTimeLineUI", "refreshIv onTouch set refreshIv visible");
                        this.qrZ.qqY.setVisibility(0);
                    }
                    this.qrZ.qrc.biM();
                }
                if (motionEvent.getAction() == 0) {
                    if (this.qrZ.qrp.mUX != null && this.qrZ.qrp.mUX.getFirstVisiblePosition() == 0) {
                        this.qrZ.qqY.setVisibility(0);
                    }
                    this.qrZ.qrb.bil();
                    this.qrZ.qrb.qqc.blp();
                }
                if (this.qrZ.qri != null) {
                    this.qrZ.qri.bdo();
                }
                return false;
            }
        });
        this.qrp.mUX.post(new Runnable(this) {
            final /* synthetic */ En_424b8e16 qrZ;

            {
                this.qrZ = r1;
            }

            public final void run() {
                if (this.qrZ.qrb != null) {
                    this.qrZ.qrb.qqc.qzH = this.qrZ.qrp.mUX.getBottom();
                    this.qrZ.qrb.qqc.qLb = this.qrZ.qrp.nxK.getTop();
                    this.qrZ.qrc.qsr = this.qrZ.qrp.qaU.getTop();
                }
            }
        });
        this.qrp.nxK.vlH = new MMPullDownView.f(this) {
            final /* synthetic */ En_424b8e16 qrZ;

            {
                this.qrZ = r1;
            }

            public final void an(float f) {
                En_424b8e16.B(this.qrZ);
                if (this.qrZ.qrp.qaU.getTop() >= this.qrZ.qrc.qsr || f > 0.0f) {
                    a y = this.qrZ.qrc;
                    if (y.mUX != null) {
                        if (y.mUX.getFirstVisiblePosition() == 0) {
                            y.qrZ.qqY.setVisibility(0);
                        } else {
                            y.qrZ.qqY.setVisibility(8);
                        }
                    }
                    if (y.qrZ.qqY.getVisibility() == 0) {
                        y.qrZ.qqY.clearAnimation();
                        y.init();
                        y.qso -= f / 2.0f;
                        float f2 = y.qso;
                        if (f2 < y.qsn) {
                            f2 = y.qsn;
                            y.qso = y.qsn;
                        }
                        float f3 = f2 > y.qsm ? y.qsm : f2;
                        f2 = f3 == y.qsm ? f * 2.0f : 5.0f * f;
                        y.qrZ.qqY.a(com.tencent.mm.ui.widget.QImageView.a.wxn);
                        y.qrZ.qqY.mMatrix.postRotate(f2, y.qsk, y.qsl);
                        y.qrZ.qqY.setImageResource(i.i.pIZ);
                        LayoutParams layoutParams = (LayoutParams) y.qrZ.qqY.getLayoutParams();
                        layoutParams.y = (int) f3;
                        y.qrZ.qqY.setLayoutParams(layoutParams);
                        y.qrZ.qqY.invalidate();
                    }
                }
                this.qrZ.qrb.bil();
                this.qrZ.biz();
                this.qrZ.qrb.qqc.blp();
            }

            public final void biK() {
                this.qrZ.qrc.biM();
            }
        };
        this.qrb.qqb = (SnsCommentFooter) findViewById(i.f.pBY);
        this.qrb.qqb.post(new Runnable(this) {
            final /* synthetic */ En_424b8e16 qrZ;

            {
                this.qrZ = r1;
            }

            public final void run() {
                com.tencent.mm.compatible.util.j.f(this.qrZ);
            }
        });
        this.qrb.qqc = new bh(this.qrp.mUX, this.qrb.qqb);
        this.qqX = (LinearLayout) this.qrp.qaU.findViewById(i.f.pFv);
        this.qqX.findViewById(i.f.pFt).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ En_424b8e16 qrZ;

            {
                this.qrZ = r1;
            }

            public final void onClick(View view) {
                if (!(this.qrZ.qrb == null || this.qrZ.qrb.qpZ == null)) {
                    this.qrZ.qrb.qpZ.pWR.hp(true);
                }
                com.tencent.mm.plugin.sns.j.c.b bVar = (com.tencent.mm.plugin.sns.j.c.b) this.qrZ.vQ().y(com.tencent.mm.plugin.sns.j.c.b.class);
                com.tencent.mm.modelsns.b gz = com.tencent.mm.modelsns.b.gz(725);
                gz.gC(bVar.qPL);
                gz.JE();
                Intent intent = new Intent();
                intent.setClass(this.qrZ, SnsMsgUI.class);
                this.qrZ.startActivityForResult(intent, 13);
            }
        });
        SnsHeader snsHeader = this.qrp.qaU;
        OnClickListener anonymousClass32 = new OnClickListener(this) {
            final /* synthetic */ En_424b8e16 qrZ;

            {
                this.qrZ = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(this.qrZ, SnsUserUI.class);
                Intent f = ae.beB().f(intent, this.qrZ.qrl);
                if (f == null) {
                    this.qrZ.finish();
                    return;
                }
                com.tencent.mm.kernel.h.vJ();
                int a = bg.a((Integer) com.tencent.mm.kernel.h.vI().vr().get(68388, null), 0);
                com.tencent.mm.kernel.h.vJ();
                com.tencent.mm.kernel.h.vI().vr().set(68388, Integer.valueOf(a + 1));
                this.qrZ.startActivity(f);
                if ((f.getFlags() & 67108864) != 0) {
                    this.qrZ.finish();
                }
            }
        };
        if (!(snsHeader.qBB == null || snsHeader.qBB.ioV == null)) {
            snsHeader.qBB.ioV.setOnClickListener(anonymousClass32);
        }
        this.qrb.qqd = new an(this);
        biw();
    }

    public final void bit() {
        super.bit();
        af.v(new Runnable(this) {
            final /* synthetic */ En_424b8e16 qrZ;

            {
                this.qrZ = r1;
            }

            public final void run() {
                this.qrZ.biz();
            }
        });
        if (this.uSU.uTG == 2) {
            if (this.qrb != null && this.qrb.qqb != null && !this.qrb.qqb.bke()) {
                w.i("MicroMsg.SnsTimeLineUI", "onKeyBoardStateChange find");
            }
        } else if (this.uSU.uTG == 1 && this.qrb != null) {
            i iVar = this.qrb;
            if (iVar.qqa) {
                iVar.qqa = false;
                iVar.qqc.blo();
            }
        }
    }

    private void biu() {
        Y(new Runnable(this) {
            final /* synthetic */ En_424b8e16 qrZ;

            {
                this.qrZ = r1;
            }

            public final void run() {
                En_424b8e16.D(this.qrZ);
            }
        });
    }

    public final boolean biv() {
        return super.biv();
    }

    private void biw() {
        biu();
        a(this.qrR, i.e.bbC);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        this.qrV = menu.add(0, 0, 0, j.pKd);
        if (this.qrS == null) {
            int dimensionPixelSize;
            int height = cO().cP().getHeight();
            if (height == 0) {
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                dimensionPixelSize = displayMetrics.widthPixels > displayMetrics.heightPixels ? getResources().getDimensionPixelSize(i.d.aWR) : getResources().getDimensionPixelSize(i.d.aWS);
            } else {
                dimensionPixelSize = height;
            }
            int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(this, 56);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(fromDPToPix, dimensionPixelSize);
            this.qrS = View.inflate(this, i.g.pIl, null);
            this.qrT = (ImageView) this.qrS.findViewById(i.f.icon);
            this.qrU = this.qrS.findViewById(i.f.cIN);
            this.qrS.setLayoutParams(layoutParams);
            this.qrS.setBackgroundResource(i.e.bbE);
            this.qrS.setMinimumHeight(dimensionPixelSize);
            this.qrS.setMinimumWidth(fromDPToPix);
            this.qrT.setImageResource(i.i.dvr);
            this.qrS.setContentDescription(getString(j.eYj));
            this.qrS.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ En_424b8e16 qrZ;

                {
                    this.qrZ = r1;
                }

                public final void onClick(View view) {
                    En_424b8e16.E(this.qrZ);
                }
            });
            this.qrS.setOnLongClickListener(new OnLongClickListener(this) {
                final /* synthetic */ En_424b8e16 qrZ;

                {
                    this.qrZ = r1;
                }

                public final boolean onLongClick(View view) {
                    if (!(this.qrZ.qrb == null || this.qrZ.qrb.qpZ == null)) {
                        this.qrZ.qrb.qpZ.pWR.hq(true);
                    }
                    com.tencent.mm.kernel.h.vJ();
                    if (((Boolean) com.tencent.mm.kernel.h.vI().vr().get(7490, Boolean.valueOf(true))).booleanValue()) {
                        this.qrZ.startActivity(new Intent().setClass(this.qrZ, SnsLongMsgUI.class));
                        com.tencent.mm.kernel.h.vJ();
                        com.tencent.mm.kernel.h.vI().vr().set(7490, Boolean.valueOf(false));
                    } else {
                        Intent intent = new Intent();
                        intent.setClass(this.qrZ, En_c4f742e5.class);
                        intent.putExtra("KSnsPostManu", true);
                        intent.putExtra("KTouchCameraTime", bg.Ny());
                        intent.putExtra("sns_comment_type", 1);
                        intent.putExtra("Ksnsupload_type", 9);
                        com.tencent.mm.modelsns.b gz = com.tencent.mm.modelsns.b.gz(705);
                        gz.gD(gz.hTu).kH(System.currentTimeMillis()).gD(gz.hTw).gD(1);
                        gz = com.tencent.mm.plugin.sns.h.e.qdB.a(gz);
                        gz.JE();
                        gz.b(intent, "intent_key_StatisticsOplog");
                        this.qrZ.startActivityForResult(intent, 9);
                    }
                    return true;
                }
            });
            this.qrS.post(new Runnable(this) {
                final /* synthetic */ En_424b8e16 qrZ;

                {
                    this.qrZ = r1;
                }

                public final void run() {
                    this.qrZ.aQ();
                }

                public final String toString() {
                    return super.toString() + "|supportInvalidateOptionsMenu";
                }
            });
        }
        android.support.v4.view.m.a(this.qrV, this.qrS);
        android.support.v4.view.m.a(this.qrV, 2);
        this.qrV.setVisible(true);
        bix();
        return onCreateOptionsMenu;
    }

    private void bix() {
        if (this.qrU != null) {
            this.qrU.setVisibility(8);
        }
    }

    private void biy() {
        if (!com.tencent.mm.n.a.aH(this)) {
            w.i("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 18, "", "")), bg.bJZ(), this});
            if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 18, "", "")) {
                w.i("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 18, "", "")), bg.bJZ(), this});
                if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 18, "", "")) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(13822, new Object[]{Integer.valueOf(1), Integer.valueOf(2)});
                    k.w(this.uSU.uTo, new Intent());
                }
            }
        }
    }

    public final boolean cz(View view) {
        this.qrb.qqj.bfB();
        bg bgVar = this.qrb.qqi;
        if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.a.a.c) {
            com.tencent.mm.plugin.sns.ui.a.a.c cVar = (com.tencent.mm.plugin.sns.ui.a.a.c) view.getTag();
            String str = cVar.fGN;
            if (bgVar.qKW != null) {
                if (bgVar.qKW.getTag() instanceof a) {
                    a aVar = (a) bgVar.qKW.getTag();
                    if (aVar.pZF.equals(str)) {
                        bgVar.cB(aVar.pOr);
                        return true;
                    }
                    bgVar.biz();
                }
                bgVar.qKW = null;
            }
            bgVar.qKW = new SnsCommentShowAbLayout(bgVar.mContext);
            com.tencent.mm.sdk.platformtools.k.bB(bgVar.qKW);
            bgVar.qKW.setId(i.f.cTF);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            bgVar.pZl.addView(bgVar.qKW);
            int a = BackwardSupportUtil.b.a(bgVar.mContext, 192.0f);
            int a2 = BackwardSupportUtil.b.a(bgVar.mContext, 76.0f);
            BackwardSupportUtil.b.a(bgVar.mContext, 20.0f);
            int a3 = BackwardSupportUtil.b.a(bgVar.mContext, 12.0f);
            int a4 = BackwardSupportUtil.b.a(bgVar.mContext, 40.0f);
            View inflate = com.tencent.mm.ui.r.eC(bgVar.mContext).inflate(i.g.pHr, null);
            Rect rect = new Rect();
            int[] iArr = new int[2];
            int dr = com.tencent.mm.pluginsdk.e.dr(bgVar.mContext);
            view.getLocationInWindow(iArr);
            bgVar.pPk = com.tencent.mm.pluginsdk.e.ds(bgVar.mContext);
            w.d("MicroMsg.TimeLineCommentHelper", "addCommentView getLocationInWindow " + iArr[0] + "  " + iArr[1] + " height: " + dr + " height_hardcode:" + a2 + " statusBarHeight: " + bgVar.pPk);
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -2, (iArr[0] - a) + a3, ((iArr[1] - bgVar.pPk) - dr) - ((a4 / 2) - (view.getMeasuredHeight() / 2)));
            bgVar.qKW.setTag(new a(bgVar, str, inflate));
            bgVar.qKW.addView(inflate, layoutParams2);
            if (cVar.knu == 11) {
                inflate.findViewById(i.f.pAW).setBackgroundResource(i.e.pzD);
            }
            inflate.setVisibility(8);
            new com.tencent.mm.sdk.platformtools.ae().post(new com.tencent.mm.plugin.sns.ui.bg.AnonymousClass1(bgVar, view, inflate));
            return true;
        }
        w.e("MicroMsg.TimeLineCommentHelper", "showCommentBtn err2");
        return false;
    }

    public final boolean biz() {
        if (this.qrb == null || this.qrb.qqi == null) {
            return false;
        }
        if (!(this.qrb == null || this.qrb.qqj == null)) {
            this.qrb.qqj.bfB();
        }
        com.tencent.mm.plugin.sns.abtest.a.bdf();
        return this.qrb.qqi.biz();
    }

    public final void yL() {
        vQ().z(com.tencent.mm.plugin.sns.j.c.b.class);
    }

    public final void yM() {
    }

    public final void yN() {
        if (!this.qrY) {
            w.v("MicroMsg.SnsTimeLineUI", "notifyHbReward imp");
            this.qrY = true;
            ae.ayz().postDelayed(new Runnable(this) {
                final /* synthetic */ En_424b8e16 qrZ;

                {
                    this.qrZ = r1;
                }

                public final void run() {
                    if (this.qrZ.qqW != null) {
                        this.qrZ.qqW.qHY.notifyVendingDataChange();
                    }
                    this.qrZ.qrY = false;
                }
            }, 1000);
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        w.i("MicroMsg.SnsTimeLineUI", "uionSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + kVar.getType());
        if (kVar.getType() == 218) {
            q qVar = (q) kVar;
            if ((qVar.type == 1 || qVar.type == 6 || qVar.type == 4) && this.qrb.qqm != null) {
                this.qrb.qqm.dismiss();
            }
            if (qVar.type == 11) {
                if (this.qrp.irJ != null) {
                    this.qrp.irJ.dismiss();
                }
                if (this.qrT != null) {
                    this.qrT.setImageResource(i.i.dvr);
                }
            }
        }
        if (this.qqW != null) {
            this.qqW.qHY.notifyVendingDataChange();
        }
        if (kVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.share.g.CTRL_INDEX) {
            x xVar = (x) kVar;
            com.tencent.mm.modelsns.b gz;
            if (xVar.pTN) {
                gz = com.tencent.mm.modelsns.b.gz(727);
                gz.gC(this.qqW.getCount()).gC(xVar.Ul);
                gz.JE();
            } else {
                gz = com.tencent.mm.modelsns.b.gz(728);
                gz.gC(this.qqW.getCount()).gC(xVar.Ul).gC(0);
                gz.JE();
            }
            if (this.qrc != null) {
                this.qra = false;
                Animation animation = this.qrc;
                w.i("MicroMsg.SnsTimeLineUI", "play end vis: %d, sumY %f MAX_Y %f", new Object[]{Integer.valueOf(animation.qrZ.qqY.getVisibility()), Float.valueOf(animation.qso), Float.valueOf(animation.qsm)});
                if (animation.qrZ.qqY.getVisibility() == 0) {
                    animation.init();
                    if (animation.qso >= animation.qsm) {
                        animation.qrZ.qqY.clearAnimation();
                        animation.qrZ.qqY.startAnimation(animation);
                        animation.setDuration(1200);
                        animation.qsq = false;
                    }
                }
            }
        }
    }

    protected void finalize() {
        w.d("MicroMsg.SnsTimeLineUI", "finalize");
        super.finalize();
    }

    public final void yO() {
        vQ().z(com.tencent.mm.plugin.sns.j.c.b.class);
    }

    public void onBackPressed() {
        finish();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.v("MicroMsg.SnsTimeLineUI", "on ActivityResult, requestCode %d, resultCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 15) {
            if (this.qrb != null && this.qrb.qql != null && this.qrb.qql.qNp != null) {
                this.qrb.qql.qNp.onActivityResult(i, i2, intent);
                af.f(new Runnable(this) {
                    final /* synthetic */ En_424b8e16 qrZ;

                    {
                        this.qrZ = r1;
                    }

                    public final void run() {
                        this.qrZ.aHf();
                    }
                }, 300);
            }
        } else if (i == 16) {
            w.i("MicroMsg.SnsTimeLineUI", "REQUEST_CODE_FOR_FULLSCREEN");
        } else {
            super.onActivityResult(i, i2, intent);
            this.qrp.onActivityResult(i, i2, intent);
            if (i == 11) {
                this.qqU.qPH.b(this.jia, this.qrm, this.qrn, this.qro);
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.SnsTimeLineUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 18:
                if (iArr[0] == 0) {
                    biy();
                    return;
                }
                int i2 = "android.permission.CAMERA".equals(strArr[0]) ? j.eFG : j.eFJ;
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a(this, getString(i2), getString(j.eFM), getString(j.evw), getString(j.dGs), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ En_424b8e16 qrZ;

                        {
                            this.qrZ = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.qrZ.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ En_424b8e16 qrZ;

                        {
                            this.qrZ = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }
}
