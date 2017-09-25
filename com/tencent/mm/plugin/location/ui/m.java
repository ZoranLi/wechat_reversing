package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.location.model.f;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.plugin.location.ui.impl.TrackPointAnimAvatar;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aqv;
import com.tencent.mm.protocal.c.bfj;
import com.tencent.mm.protocal.c.biq;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class m {
    private static Object nfn = new Object();
    private com.tencent.mm.modelgeo.a.a gKp = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ m nfF;

        {
            this.nfF = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (!z) {
                return false;
            }
            m mVar = this.nfF;
            double d4 = (double) f2;
            double d5 = (double) f;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[refreshMyLocation] ");
            stringBuffer.append(String.format("latitude = %f, longtitude = %f", new Object[]{Double.valueOf(d4), Double.valueOf(d5)}));
            if (mVar.ncd == null) {
                mVar.ncd = new biq();
                mVar.ncd.uiu = new aqv();
                mVar.ncd.tgG = com.tencent.mm.u.m.xL();
                mVar.ncd.uiu.tle = d4;
                mVar.ncd.uiu.tld = d5;
                if (mVar.ndd && mVar.nfq) {
                    mVar.aGY();
                }
            }
            mVar.ncd.uiu.tle = d4;
            mVar.ncd.uiu.tld = d5;
            View viewByItag = mVar.ndc.getViewByItag(mVar.ncd.tgG);
            if (viewByItag != null) {
                stringBuffer.append("[ view is not null hasCode: " + viewByItag.hashCode() + " ] ");
            } else {
                viewByItag = new TrackPoint(mVar.mContext);
                if (mVar.nfv) {
                    ((TrackPoint) viewByItag).c(null);
                    ((TrackPoint) viewByItag).b(null);
                    ((TrackPoint) viewByItag).aHz();
                } else {
                    ((TrackPoint) viewByItag).c(mVar.nfD);
                    ((TrackPoint) viewByItag).b(mVar.nfC);
                }
                if (!mVar.nfs) {
                    ((TrackPoint) viewByItag).aHB();
                }
                stringBuffer.append("[view is null new one: " + viewByItag.hashCode() + " ] ");
                mVar.ndc.addView(viewByItag, d4, d5, mVar.ncd.tgG);
                mVar.nfp = new TrackPointAnimAvatar(mVar.mContext);
            }
            w.d("MicroMsg.TrackPointViewMgrImpl", stringBuffer.toString());
            if (viewByItag instanceof TrackPoint) {
                mVar.nfo = (TrackPoint) viewByItag;
                w.d("MicroMsg.TrackPointViewMgrImpl", "udpate view layout");
                mVar.ndc.updateViewLayout(viewByItag, d4, d5);
                mVar.nfo.zH(mVar.ncd.tgG);
                TrackPoint trackPoint = mVar.nfo;
                trackPoint.niJ.setImageResource(R.g.bgr);
                trackPoint = mVar.nfo;
                if (trackPoint.iSR == -1.0d && trackPoint.iSS == -1.0d) {
                    trackPoint.iSR = d4;
                    trackPoint.iSP = d4;
                    trackPoint.iSS = d5;
                    trackPoint.iSQ = d5;
                } else {
                    trackPoint.iSR = trackPoint.iSP;
                    trackPoint.iSS = trackPoint.iSQ;
                    trackPoint.iSQ = d5;
                    trackPoint.iSP = d4;
                }
                if (mVar.nfs) {
                    mVar.nfo.niK.setVisibility(0);
                } else {
                    mVar.nfo.aHB();
                }
            }
            if (mVar.nfx) {
                mVar.ndc.getIController().setCenter(mVar.ncd.uiu.tle, mVar.ncd.uiu.tld);
            }
            return true;
        }
    };
    public boolean jGP = false;
    protected float jWC = 0.0f;
    Context mContext;
    protected float mxi = 0.0f;
    public biq ncd;
    private com.tencent.mm.plugin.location.model.i.a ncp = new com.tencent.mm.plugin.location.model.i.a(this) {
        final /* synthetic */ m nfF;

        {
            this.nfF = r1;
        }

        public final void h(double d) {
            if (this.nfF.nfo != null) {
                w.d("MicroMsg.TrackPointViewMgrImpl", "updateMyTrackPointDegree, degree = %f", new Object[]{Double.valueOf(d)});
                this.nfF.nfo.i(d);
            }
        }
    };
    public d ndc;
    boolean ndd = false;
    public long nfA = 0;
    private OnTouchListener nfB = new OnTouchListener(this) {
        final /* synthetic */ m nfF;

        {
            this.nfF = r1;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            boolean z = true;
            switch (motionEvent.getAction()) {
                case 0:
                    this.nfF.mxi = motionEvent.getX();
                    this.nfF.jWC = motionEvent.getY();
                    this.nfF.nfA = System.currentTimeMillis();
                    this.nfF.jGP = false;
                    break;
                case 1:
                    if (!this.nfF.jGP && System.currentTimeMillis() - this.nfF.nfA < 200) {
                        m mVar = this.nfF;
                        if (mVar.nfu) {
                            mVar.fq(false);
                        }
                        Collection<View> childs = mVar.ndc.getChilds();
                        for (View view2 : childs) {
                            if (view2 instanceof TrackPoint) {
                                if (((TrackPoint) view2).niL.getVisibility() == 0) {
                                    for (View view22 : childs) {
                                        if (!(view22 instanceof TrackPoint)) {
                                            if (z) {
                                                ((TrackPoint) view22).aHA();
                                            } else {
                                                ((TrackPoint) view22).aHz();
                                            }
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                        z = false;
                        for (View view222 : childs) {
                            if (!(view222 instanceof TrackPoint)) {
                                if (z) {
                                    ((TrackPoint) view222).aHA();
                                } else {
                                    ((TrackPoint) view222).aHz();
                                }
                            }
                        }
                    }
                case 2:
                    if (Math.abs(motionEvent.getX() - this.nfF.mxi) > 10.0f || Math.abs(motionEvent.getY() - this.nfF.jWC) > 10.0f) {
                        this.nfF.jGP = true;
                        break;
                    }
            }
            return false;
        }
    };
    OnClickListener nfC = new OnClickListener(this) {
        final /* synthetic */ m nfF;

        {
            this.nfF = r1;
        }

        public final void onClick(View view) {
            String str = (String) view.getTag();
            w.d("MicroMsg.TrackPointViewMgrImpl", "onLocationTpClick, username=%s", new Object[]{str});
            if (!bg.mA(str)) {
                View viewByItag = this.nfF.ndc.getViewByItag(str);
                if (viewByItag != null && (viewByItag instanceof TrackPoint)) {
                    TrackPoint trackPoint = (TrackPoint) viewByItag;
                    if (trackPoint.visible) {
                        trackPoint.aHz();
                    } else {
                        trackPoint.aHA();
                    }
                }
            }
        }
    };
    OnClickListener nfD = new OnClickListener(this) {
        final /* synthetic */ m nfF;

        {
            this.nfF = r1;
        }

        public final void onClick(View view) {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            m mVar = this.nfF;
            int i = iArr[0];
            int i2 = iArr[1];
            if (mVar.nfm != null) {
                ArrayList arrayList = new ArrayList();
                float a = (float) b.a(mVar.mContext, 85.0f);
                for (biq com_tencent_mm_protocal_c_biq : mVar.nfm) {
                    Point pointByGeoPoint = mVar.ndc.getPointByGeoPoint(com_tencent_mm_protocal_c_biq.uiu.tle, com_tencent_mm_protocal_c_biq.uiu.tld);
                    w.d("MicroMsg.TrackPointViewMgrImpl", "cal %f %f %d %d", new Object[]{Double.valueOf(com_tencent_mm_protocal_c_biq.uiu.tle), Double.valueOf(com_tencent_mm_protocal_c_biq.uiu.tld), Integer.valueOf(pointByGeoPoint.x), Integer.valueOf(pointByGeoPoint.y)});
                    if (f.i(pointByGeoPoint.x, pointByGeoPoint.y, i, i2) < ((double) a)) {
                        arrayList.add(com_tencent_mm_protocal_c_biq.tgG);
                    }
                }
                if (mVar.ncd != null) {
                    Point pointByGeoPoint2 = mVar.ndc.getPointByGeoPoint(mVar.ncd.uiu.tle, mVar.ncd.uiu.tld);
                    w.d("MicroMsg.TrackPointViewMgrImpl", "cal %f %f %d %d", new Object[]{Double.valueOf(mVar.ncd.uiu.tle), Double.valueOf(mVar.ncd.uiu.tld), Integer.valueOf(pointByGeoPoint2.x), Integer.valueOf(pointByGeoPoint2.y)});
                    if (f.i(pointByGeoPoint2.x, pointByGeoPoint2.y, i, i2) < ((double) a)) {
                        arrayList.add(mVar.ncd.tgG);
                    }
                }
                w.d("MicroMsg.TrackPointViewMgrImpl", "cal username size %d ", new Object[]{Integer.valueOf(arrayList.size())});
                if (arrayList.size() > 1) {
                    g.oUh.i(10997, new Object[]{"12", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                    b.b(mVar.mContext, arrayList);
                }
                arrayList.size();
            }
        }
    };
    public a nfE = null;
    public List<biq> nfm;
    public TrackPoint nfo;
    TrackPointAnimAvatar nfp;
    boolean nfq = false;
    public boolean nfr = false;
    public boolean nfs = true;
    public boolean nft = false;
    public boolean nfu = false;
    public boolean nfv = false;
    public bfj nfw;
    public boolean nfx = true;
    public boolean nfy = true;
    private boolean nfz = false;

    public interface a {
    }

    public m(Context context, d dVar, boolean z) {
        this.mContext = context;
        this.ndd = z;
        this.ndc = dVar;
        this.nfm = new ArrayList();
        dVar.setMapViewOnTouchListener(this.nfB);
    }

    public final void fq(boolean z) {
        if (z) {
            if ((this.nfo != null ? 1 : 0) != 0) {
                g.oUh.i(10997, new Object[]{"20", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
            } else {
                return;
            }
        }
        this.nfu = z;
    }

    public final void destroy() {
        synchronized (nfn) {
            if (this.nfm != null) {
                this.nfm.clear();
            }
        }
    }

    public final void fr(boolean z) {
        if (!(!z || this.nft || this.ndc == null)) {
            for (View view : this.ndc.getChilds()) {
                if (view instanceof TrackPoint) {
                    ((TrackPoint) view).aHA();
                }
            }
        }
        this.nft = z;
    }

    public final void aN(List<biq> list) {
        this.nfq = true;
        int size = this.nfm.size() + 1;
        synchronized (nfn) {
            this.nfm.clear();
            for (int i = 0; i < list.size(); i++) {
                this.nfm.add(list.get(i));
            }
        }
        int size2 = this.nfm.size() + 1;
        synchronized (nfn) {
            View view;
            Set<String> tags = this.ndc.getTags();
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < this.nfm.size(); i2++) {
                hashSet.add(((biq) this.nfm.get(i2)).tgG);
            }
            List<String> linkedList = new LinkedList();
            for (String str : tags) {
                if (!(hashSet.contains(str) || str.endsWith("myAnim"))) {
                    if (this.nfo == null || !this.nfo.equals(this.ndc.getViewByItag(str))) {
                        linkedList.add(str);
                    }
                }
            }
            for (String str2 : linkedList) {
                this.ndc.removeViewByTag(str2);
            }
            for (int i3 = 0; i3 < this.nfm.size(); i3++) {
                biq com_tencent_mm_protocal_c_biq = (biq) this.nfm.get(i3);
                View viewByItag = this.ndc.getViewByItag(com_tencent_mm_protocal_c_biq.tgG);
                w.d("MicroMsg.TrackPointViewMgrImpl", "position %d %s %f %f %f", new Object[]{Integer.valueOf(i3), com_tencent_mm_protocal_c_biq.tgG, Double.valueOf(com_tencent_mm_protocal_c_biq.uiu.tle), Double.valueOf(com_tencent_mm_protocal_c_biq.uiu.tld), Double.valueOf(com_tencent_mm_protocal_c_biq.uiu.tVp)});
                if (viewByItag != null) {
                    this.ndc.updateViewLayout(viewByItag, com_tencent_mm_protocal_c_biq.uiu.tle, com_tencent_mm_protocal_c_biq.uiu.tld);
                    view = viewByItag;
                } else {
                    viewByItag = new TrackPoint(this.mContext);
                    viewByItag.setVisibility(0);
                    if (!this.nfs) {
                        ((TrackPoint) viewByItag).aHB();
                    }
                    this.ndc.addView(viewByItag, com_tencent_mm_protocal_c_biq.uiu.tle, com_tencent_mm_protocal_c_biq.uiu.tld, com_tencent_mm_protocal_c_biq.tgG);
                    ((TrackPoint) viewByItag).c(this.nfD);
                    ((TrackPoint) viewByItag).b(this.nfC);
                    view = viewByItag;
                }
                if (view instanceof TrackPoint) {
                    TrackPoint trackPoint = (TrackPoint) view;
                    trackPoint.zH(com_tencent_mm_protocal_c_biq.tgG);
                    trackPoint.i(com_tencent_mm_protocal_c_biq.uiu.tVp);
                    if (!this.nft) {
                        trackPoint.aHz();
                    }
                }
            }
            if (this.ndd && this.nfq) {
                if (o.dH(l.aGe().nci)) {
                    aGY();
                } else if (this.nfm.size() > 0) {
                    aGY();
                }
            }
            if (size < 10 && size2 >= 10) {
                for (View view2 : this.ndc.getChilds()) {
                    if (view2 instanceof TrackPoint) {
                        ((TrackPoint) view2).aHz();
                    }
                }
            } else if (size >= 10 && size2 < 10) {
                for (View view22 : this.ndc.getChilds()) {
                    if (view22 instanceof TrackPoint) {
                        ((TrackPoint) view22).aHA();
                    }
                }
            }
        }
    }

    final void aGY() {
        if (!this.nfr && this.ncd != null) {
            double d = 0.0d;
            double d2 = 0.0d;
            if (this.ncd != null) {
                LocationInfo locationInfo = l.aGe().nce;
                if (this.ncd != null && e.f(locationInfo.naO, locationInfo.naP)) {
                    d = 2.0d * Math.abs(this.ncd.uiu.tle - locationInfo.naO);
                    d2 = Math.abs(this.ncd.uiu.tld - locationInfo.naP) * 2.0d;
                }
                double d3 = d2;
                double d4 = d;
                for (int i = 0; i < this.nfm.size(); i++) {
                    biq com_tencent_mm_protocal_c_biq = (biq) this.nfm.get(i);
                    if (com_tencent_mm_protocal_c_biq != null && e.f(com_tencent_mm_protocal_c_biq.uiu.tle, com_tencent_mm_protocal_c_biq.uiu.tld)) {
                        double abs = 2.0d * Math.abs(com_tencent_mm_protocal_c_biq.uiu.tle - this.ncd.uiu.tle);
                        d = Math.abs(com_tencent_mm_protocal_c_biq.uiu.tld - this.ncd.uiu.tld) * 2.0d;
                        if (abs > d4) {
                            d4 = abs;
                        }
                        if (d > d3) {
                            d3 = d;
                        }
                        w.d("MicroMsg.TrackPointViewMgrImpl", "update %s %f %f", new Object[]{com_tencent_mm_protocal_c_biq.tgG, Double.valueOf(com_tencent_mm_protocal_c_biq.uiu.tle), Double.valueOf(com_tencent_mm_protocal_c_biq.uiu.tld)});
                    }
                }
                if (Math.abs(d4 - -1000.0d) >= 0.5d && Math.abs(d3 - -1000.0d) >= 0.5d) {
                    w.d("MicroMsg.TrackPointViewMgrImpl", "zoomToSpan maxlat " + (1000000.0d * d4) + " maxlng " + (1000000.0d * d3) + " poi " + locationInfo.naO + " " + locationInfo.naP);
                    if (this.ncd != null) {
                        w.d("MicroMsg.TrackPointViewMgrImpl", "mPosition item %f %f", new Object[]{Double.valueOf(this.ncd.uiu.tle), Double.valueOf(this.ncd.uiu.tld)});
                        this.ndc.zoomToSpan(this.ncd.uiu.tle, this.ncd.uiu.tld, d4, d3);
                    } else if (e.f(locationInfo.naO, locationInfo.naP)) {
                        this.ndc.zoomToSpan(locationInfo.naO, locationInfo.naP, d4, d3);
                    }
                }
            }
            this.nfr = true;
        }
    }

    public final void a(d dVar) {
        if (this.ncd != null) {
            double d = this.ncd.uiu.tld;
            dVar.getIController().animateTo(this.ncd.uiu.tle, d);
            if (dVar.getZoomLevel() < 16) {
                dVar.getIController().setZoom(16);
            }
        }
    }

    public final void onResume() {
        c.Gk().b(this.gKp, true);
        l.aGg().a(this.ncp);
    }

    public final void onPause() {
        c.Gk().c(this.gKp);
        l.aGg().b(this.ncp);
    }
}
