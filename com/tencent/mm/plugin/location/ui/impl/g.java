package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.d;
import com.tencent.mm.plugin.location.model.f;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.model.o;
import com.tencent.mm.plugin.location.model.o.b;
import com.tencent.mm.plugin.location.ui.MyLocationButton;
import com.tencent.mm.plugin.location.ui.ShareHeader;
import com.tencent.mm.plugin.location.ui.TipSayingWidget;
import com.tencent.mm.plugin.location.ui.VolumeMeter;
import com.tencent.mm.plugin.location.ui.i;
import com.tencent.mm.plugin.location.ui.k;
import com.tencent.mm.plugin.location.ui.l.a;
import com.tencent.mm.plugin.location.ui.m;
import com.tencent.mm.plugin.location.ui.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ahq;
import com.tencent.mm.protocal.c.aqv;
import com.tencent.mm.protocal.c.auk;
import com.tencent.mm.protocal.c.bfj;
import com.tencent.mm.protocal.c.biq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g extends i implements a {
    private com.tencent.mm.modelgeo.a.a gKp = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ g niw;

        {
            this.niw = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (!z) {
                return false;
            }
            w.d("MicroMsg.ShareMapUI", "onGetLocation, latitude=%f, longtitude=%f, speed=%f", new Object[]{Float.valueOf(f2), Float.valueOf(f), Double.valueOf(d)});
            if (f.g(d) && !this.niw.nij.nfu) {
                w.d("MicroMsg.ShareMapUI", "set driving mode");
                this.niw.nij.nfx = false;
                this.niw.nij.fq(true);
                this.niw.nih.aGy();
            }
            return true;
        }
    };
    private View neg;
    private m.a nfE = new m.a(this) {
        final /* synthetic */ g niw;

        {
            this.niw = r1;
        }
    };
    private Button nig;
    public MyLocationButton nih;
    private TipSayingWidget nii;
    public m nij;
    public o nik = l.aGe();
    public com.tencent.mm.plugin.location.ui.l nil;
    public k nim;
    private i nin;
    private c nio = c.Gk();
    private ShareHeader nip;
    private String niq;
    private long nir = 0;
    private long nis = 0;
    private b nit = new b(this) {
        final /* synthetic */ g niw;

        {
            this.niw = r1;
        }

        public final void aGr() {
            w.i("MicroMsg.ShareMapUI", "onJoinSucess");
            o oVar = this.niw.nik;
            oVar.ncf = true;
            oVar.aGn();
            oVar.aGo();
            this.niw.nij.fr(true);
            if (this.niw.nim != null) {
                this.niw.nim.aGJ();
            }
        }

        public final void a(auk com_tencent_mm_protocal_c_auk) {
            this.niw.b(com_tencent_mm_protocal_c_auk);
        }

        public final void onError(int i, String str) {
            w.v("MicroMsg.ShareMapUI", "onError type %d msg %s", new Object[]{Integer.valueOf(i), str});
            com.tencent.mm.plugin.report.service.g.oUh.i(10997, new Object[]{"7", "", Integer.valueOf(0), Integer.valueOf(0)});
            com.tencent.mm.plugin.location.ui.l lVar = this.niw.nil;
            w.d("MicroMsg.TrackPoiDialogMgr", "showErrorDialog, errMsg=%s", new Object[]{str});
            Context context = ab.getContext();
            String str2 = null;
            if (!bg.mA(str)) {
                str2 = str;
            } else if (i == 0) {
                str2 = context.getString(R.l.ews);
            } else if (i == 1) {
                str2 = context.getString(R.l.ewt);
            } else if (i == 2) {
                str2 = context.getString(R.l.ewu);
            }
            com.tencent.mm.ui.base.g.a(lVar.mContext, str2, "", lVar.Cu.getString(R.l.dHT), false, new com.tencent.mm.plugin.location.ui.l.AnonymousClass8(lVar, i));
        }

        public final void aGs() {
            this.niw.nij.fr(false);
            this.niw.nik.stop();
            this.niw.nik.oD(3);
            k.aGN();
            this.niw.activity.finish();
            this.niw.activity.overridePendingTransition(R.a.aRp, R.a.aRr);
        }
    };
    private o.a niu = new o.a(this) {
        final /* synthetic */ g niw;

        {
            this.niw = r1;
        }

        public final void aGq() {
            g gVar = this.niw;
            h.a aVar = new h.a(gVar.activity);
            aVar.zX(R.l.eYx);
            aVar.zZ(R.l.dHT).a(new OnClickListener(gVar) {
                final /* synthetic */ g niw;

                {
                    this.niw = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.niw.nij.fr(false);
                    this.niw.nik.stop();
                    this.niw.nik.oD(2);
                    k.aGN();
                    this.niw.activity.finish();
                }
            });
            aVar.WJ().show();
        }
    };
    private HashMap<String, biq> niv = new HashMap();
    private WakeLock wakeLock;

    public final boolean aHg() {
        return true;
    }

    public g(Activity activity) {
        super(activity);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.i("MicroMsg.ShareMapUI", "onCreate");
        this.nir = System.currentTimeMillis();
    }

    final void aHe() {
        super.aHe();
        this.wakeLock = ((PowerManager) this.activity.getSystemService("power")).newWakeLock(26, "Track Lock");
        if (this.niT != null) {
            n nVar = this.niT;
            nVar.ngc.setVisibility(4);
            nVar.isVisible = false;
        }
        findViewById(R.h.bVX).setVisibility(8);
        this.nih = (MyLocationButton) findViewById(R.h.cbY);
        MyLocationButton myLocationButton = this.nih;
        myLocationButton.ndc = this.ngo.ndu;
        myLocationButton.ndb.setVisibility(0);
        myLocationButton.nda.setVisibility(8);
        c.Gk().b(myLocationButton.gKp, true);
        this.nih.aGx();
        this.nih.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ g niw;

            {
                this.niw = r1;
            }

            public final void onClick(View view) {
                this.niw.nih.aGx();
                this.niw.nij.nfx = true;
                this.niw.nij.a(this.niw.ngo.ndu);
                this.niw.nij.fq(false);
                com.tencent.mm.plugin.report.service.g.oUh.i(10997, new Object[]{"6", "", Integer.valueOf(0), Integer.valueOf(0)});
            }
        });
        this.neg = findViewById(R.h.bVW);
        this.nip = (ShareHeader) findViewById(R.h.cEJ);
        this.nip.setVisibility(0);
        this.nin = new i(this.activity, this.nip.ndR, this.neg, this.nci, this.ngo.ndu);
        this.nin.nem = new i.a(this) {
            final /* synthetic */ g niw;

            {
                this.niw = r1;
            }

            public final void zz(String str) {
                TrackPoint trackPoint = (TrackPoint) this.niw.ngo.ndu.getViewByItag(str);
                if (trackPoint != null) {
                    d dVar;
                    trackPoint.bringToFront();
                    this.niw.ngo.ndu.invalidate();
                    m mVar = this.niw.nij;
                    if (!bg.mA(str)) {
                        if (mVar.ncd == null || !str.equals(mVar.ncd.tgG)) {
                            if (mVar.nfm != null && mVar.nfm.size() > 0) {
                                for (biq com_tencent_mm_protocal_c_biq : mVar.nfm) {
                                    if (com_tencent_mm_protocal_c_biq.tgG.equals(str)) {
                                        dVar = new d(com_tencent_mm_protocal_c_biq.uiu.tld, com_tencent_mm_protocal_c_biq.uiu.tle);
                                        break;
                                    }
                                }
                            }
                        }
                        dVar = new d(mVar.ncd.uiu.tld, mVar.ncd.uiu.tle);
                        if (dVar != null) {
                            this.niw.ngo.ndu.getIController().animateTo(dVar.naO, dVar.naP);
                        }
                    }
                    dVar = null;
                    if (dVar != null) {
                        this.niw.ngo.ndu.getIController().animateTo(dVar.naO, dVar.naP);
                    }
                }
            }
        };
        this.nik.nck = this.niu;
        if (this.nij == null) {
            this.nij = new m(this.activity, this.ngo.ndu, true);
        }
        this.nij.nfE = this.nfE;
        this.nij.nfs = false;
        this.nil = new com.tencent.mm.plugin.location.ui.l(this.activity, this);
        this.nii = (TipSayingWidget) findViewById(R.h.czL);
        this.nig = (Button) findViewById(R.h.cEK);
        this.nig.setVisibility(0);
        this.nim = new k(this.activity, this.nig);
        this.nim.nfa = this.nin;
        this.nip.ndS.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ g niw;

            {
                this.niw = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.location.ui.l lVar = this.niw.nil;
                com.tencent.mm.ui.base.g.a(lVar.mContext, lVar.Cu.getString(R.l.ewD), "", lVar.Cu.getString(R.l.dGP), lVar.Cu.getString(R.l.dGs), new OnClickListener(lVar) {
                    final /* synthetic */ l nfl;

                    {
                        this.nfl = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (this.nfl.nfj != null) {
                            this.nfl.nfj.aGW();
                        }
                    }
                }, new OnClickListener(lVar) {
                    final /* synthetic */ l nfl;

                    {
                        this.nfl = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        g.oUh.i(10997, new Object[]{"18", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                    }
                });
            }
        });
        this.nip.ndT.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ g niw;

            {
                this.niw = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.report.service.g.oUh.i(10997, new Object[]{"11", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                this.niw.nil.aGU();
            }
        });
        ((LocationManager) this.activity.getSystemService("location")).isProviderEnabled("gps");
        o oVar = this.nik;
        LocationInfo locationInfo = this.ngm;
        oVar.ncn = System.currentTimeMillis();
        oVar.hvP = c.Gk();
        oVar.hvP.b(oVar.gKp, true);
        if (oVar.nca == null) {
            oVar.nca = l.aGg();
        }
        oVar.nca.a(oVar.ncp);
        if (locationInfo != null) {
            oVar.nce = locationInfo;
        }
        if (oVar.fOV) {
            w.i("MicorMsg.TrackRefreshManager", "start location " + oVar.nce.naO + " " + oVar.nce.naP);
        } else {
            oVar.ncc = 1;
            oVar.ncd = new biq();
            oVar.ncd.uiu = new aqv();
            oVar.ncd.uiu.tle = -1000.0d;
            oVar.ncd.uiu.tld = -1000.0d;
            w.i("MicorMsg.TrackRefreshManager", "start location imp " + oVar.nce.naO + " " + oVar.nce.naP);
            ap.vd().a(492, oVar);
            ap.vd().a(490, oVar);
            ap.vd().a(491, oVar);
            oVar.fyL = false;
            oVar.fOV = true;
        }
        o oVar2 = this.nik;
        b bVar = this.nit;
        Iterator it = oVar2.ncb.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((b) weakReference.get()).equals(bVar)) {
                break;
            }
        }
        oVar2.ncb.add(new WeakReference(bVar));
        this.niq = this.activity.getIntent().getStringExtra("fromWhereShare");
        w.d("MicroMsg.ShareMapUI", "fromWhere=%s", new Object[]{this.niq});
        if (this.nik.aGj()) {
            w.i("MicroMsg.ShareMapUI", "has join");
            this.nij.fr(true);
            this.nim.aGJ();
            return;
        }
        int i;
        String xL;
        com.tencent.mm.y.k bVar2;
        o oVar3 = this.nik;
        String str = this.nci;
        if (!bg.mA(this.niq)) {
            if (this.niq.equals("fromBanner")) {
                i = 0;
            } else if (!this.niq.equals("fromPluginLocation")) {
                if (this.niq.equals("fromPluginTalk")) {
                    i = 2;
                } else if (this.niq.equals("fromTrackButton")) {
                    i = 3;
                } else if (this.niq.equals("fromMessage")) {
                    i = 4;
                }
            }
            w.i("MicorMsg.TrackRefreshManager", "track join %s", new Object[]{str});
            oVar3.nci = str;
            xL = com.tencent.mm.u.m.xL();
            xL = str.contains("@chatroom") ? str : xL.compareTo(str) <= 0 ? str + xL : xL + str;
            bVar2 = new com.tencent.mm.plugin.location.model.a.b(xL);
            ((ahq) bVar2.gUA.hsj.hsr).tdM = i;
            ap.vd().a(bVar2, 0);
        }
        i = 1;
        w.i("MicorMsg.TrackRefreshManager", "track join %s", new Object[]{str});
        oVar3.nci = str;
        xL = com.tencent.mm.u.m.xL();
        if (str.contains("@chatroom")) {
        }
        bVar2 = new com.tencent.mm.plugin.location.model.a.b(xL);
        ((ahq) bVar2.gUA.hsj.hsr).tdM = i;
        ap.vd().a(bVar2, 0);
    }

    public final void onResume() {
        boolean z;
        w.i("MicroMsg.ShareMapUI", "resume");
        super.onResume();
        this.wakeLock.acquire();
        o oVar = this.nik;
        w.d("MicorMsg.TrackRefreshManager", "resume isPuase:" + oVar.ncg);
        if (oVar.ncg) {
            oVar.ncn = System.currentTimeMillis();
            oVar.hvP.a(oVar.gKp);
            oVar.nca.a(oVar.ncp);
        }
        oVar.ncg = false;
        oVar.aGk();
        oVar = this.nik;
        com.tencent.mm.plugin.p.d dVar = this.ngo.ndu;
        oVar.ncc = oVar.nch;
        w.d("MicorMsg.TrackRefreshManager", "resumeStatus upload_status  " + oVar.ncc + " %f %f %d ", new Object[]{Double.valueOf(oVar.naO), Double.valueOf(oVar.naP), Integer.valueOf(oVar.zoom)});
        if (oVar.naO == -1000.0d || oVar.naP == -1000.0d || oVar.zoom == -1) {
            z = false;
        } else {
            dVar.getIController().setCenter(oVar.naO, oVar.naP);
            dVar.getIController().setZoom(oVar.zoom);
            z = true;
        }
        if (z) {
            this.nih.ndd = false;
            this.nih.aGy();
            this.nij.nfx = false;
            this.nij.nfr = true;
        }
        oVar = this.nik;
        com.tencent.mm.plugin.p.d dVar2 = this.ngo.ndu;
        if (oVar.ncl != -1) {
            dVar2.getIController().setZoom(oVar.ncl);
        }
        if (this.nio != null) {
            this.nio.a(this.gKp);
        }
        if (this.nij != null) {
            this.nij.onResume();
        }
    }

    public final void onPause() {
        w.i("MicroMsg.ShareMapUI", "pause");
        super.onPause();
        this.wakeLock.release();
        o oVar = this.nik;
        w.d("MicorMsg.TrackRefreshManager", "pause isShared:" + oVar.ncf);
        if (!oVar.ncf) {
            oVar.hvP.c(oVar.gKp);
            oVar.nca.b(oVar.ncp);
            oVar.ncg = true;
            oVar.ncm = true;
        }
        oVar = this.nik;
        com.tencent.mm.plugin.p.d dVar = this.ngo.ndu;
        oVar.nch = oVar.ncc;
        oVar.ncc = 0;
        w.d("MicorMsg.TrackRefreshManager", "saveStatus pause_save_upload_status: " + oVar.nch);
        if (oVar.aGp()) {
            oVar.naO = (((double) dVar.getMapCenterX()) * 1.0d) / 1000000.0d;
            oVar.naP = (((double) dVar.getMapCenterY()) * 1.0d) / 1000000.0d;
            oVar.zoom = dVar.getZoom();
        }
        com.tencent.mm.plugin.report.service.g.oUh.i(10997, new Object[]{"17", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis() - this.nir)});
        this.nir = System.currentTimeMillis();
        if (this.nio != null) {
            this.nio.c(this.gKp);
        }
        if (this.nij != null) {
            this.nij.onPause();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        o oVar = this.nik;
        b bVar = this.nit;
        Iterator it = oVar.ncb.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((b) weakReference.get()).equals(bVar)) {
                oVar.ncb.remove(weakReference);
                break;
            }
        }
        this.nik.nck = null;
        if (this.nim != null) {
            Object obj = this.nim;
            obj.neZ.b(obj);
            VolumeMeter volumeMeter = obj.neM;
            volumeMeter.nfH = true;
            volumeMeter.nfG = false;
            if (volumeMeter.nfL != null) {
                volumeMeter.nfL.getLooper().quit();
                volumeMeter.nfL = null;
            }
        }
        if (this.nij != null) {
            this.nij.destroy();
        }
        if (this.nih != null) {
            c.Gk().c(this.nih.gKp);
        }
        w.i("MicroMsg.ShareMapUI", "onDestory");
    }

    public final void b(auk com_tencent_mm_protocal_c_auk) {
        com.tencent.mm.plugin.location.a.a aVar;
        biq com_tencent_mm_protocal_c_biq;
        w.d("MicroMsg.ShareMapUI", "refreshSuccess, timeout = %b", new Object[]{Boolean.valueOf(this.nik.fyL)});
        List<biq> list = com_tencent_mm_protocal_c_auk.tYc;
        List<biq> linkedList = new LinkedList();
        com.tencent.mm.plugin.location.a.a zr = l.aGf().zr(this.nci);
        if (zr == null) {
            zr = new com.tencent.mm.plugin.location.a.a();
            zr.latitude = -1000.0d;
            zr.longitude = -1000.0d;
            aVar = zr;
        } else {
            aVar = zr;
        }
        LinkedList linkedList2 = new LinkedList();
        for (biq com_tencent_mm_protocal_c_biq2 : list) {
            linkedList2.add(com_tencent_mm_protocal_c_biq2.tgG);
        }
        if (!linkedList2.contains(com.tencent.mm.u.m.xL())) {
            linkedList2.add(com.tencent.mm.u.m.xL());
        }
        l.aGf().a(this.nci, linkedList2, aVar.latitude, aVar.longitude, aVar.naK, "", "");
        for (biq com_tencent_mm_protocal_c_biq22 : list) {
            if (Math.abs(com_tencent_mm_protocal_c_biq22.uiu.tld) > 180.0d || Math.abs(com_tencent_mm_protocal_c_biq22.uiu.tle) > 90.0d) {
                biq com_tencent_mm_protocal_c_biq3 = (biq) this.niv.get(com_tencent_mm_protocal_c_biq22.tgG);
                if (com_tencent_mm_protocal_c_biq3 != null) {
                    linkedList.add(com_tencent_mm_protocal_c_biq3);
                    w.i("MicroMsg.ShareMapUI", "error from server get latlng %s %f %f and use old one %f %f", new Object[]{com_tencent_mm_protocal_c_biq22.tgG, Double.valueOf(com_tencent_mm_protocal_c_biq22.uiu.tle), Double.valueOf(com_tencent_mm_protocal_c_biq22.uiu.tld), Double.valueOf(com_tencent_mm_protocal_c_biq3.uiu.tle), Double.valueOf(com_tencent_mm_protocal_c_biq3.uiu.tld)});
                } else {
                    w.i("MicroMsg.ShareMapUI", "error from server get latlng %s %f %f cannot user old one", new Object[]{com_tencent_mm_protocal_c_biq22.tgG, Double.valueOf(com_tencent_mm_protocal_c_biq22.uiu.tle), Double.valueOf(com_tencent_mm_protocal_c_biq22.uiu.tld)});
                }
            } else {
                linkedList.add(com_tencent_mm_protocal_c_biq22);
            }
        }
        this.niv.clear();
        for (biq com_tencent_mm_protocal_c_biq222 : linkedList) {
            this.niv.put(com_tencent_mm_protocal_c_biq222.tgG, com_tencent_mm_protocal_c_biq222);
        }
        int size = linkedList.size();
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.tencent.mm.u.m.xL());
        if (size >= 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("refreshSuccess, count =  " + size);
            for (int i = 0; i < linkedList.size(); i++) {
                com_tencent_mm_protocal_c_biq222 = (biq) linkedList.get(i);
                stringBuilder.append("[" + com_tencent_mm_protocal_c_biq222.tgG + " ] ");
                stringBuilder.append(com_tencent_mm_protocal_c_biq222.uiu.tVp + " ");
                stringBuilder.append(com_tencent_mm_protocal_c_biq222.uiu.tle + " ");
                stringBuilder.append(com_tencent_mm_protocal_c_biq222.uiu.tld + " ");
                arrayList.add(com_tencent_mm_protocal_c_biq222.tgG);
            }
            w.v("MicroMsg.ShareMapUI", "refreshSuccess TrackRoom num: " + stringBuilder.toString());
            if (this.nij != null) {
                this.nij.aN(linkedList);
            }
        }
        if (this.nij.nft) {
            m mVar = this.nij;
            bfj com_tencent_mm_protocal_c_bfj = com_tencent_mm_protocal_c_auk.tYd;
            if (mVar.nfw == null) {
                mVar.nfw = new bfj();
            }
            if (com_tencent_mm_protocal_c_bfj != null) {
                w.d("MicroMsg.TrackPointViewMgrImpl", "set trackitem  " + com_tencent_mm_protocal_c_bfj.tle + " " + com_tencent_mm_protocal_c_bfj.tld);
                mVar.nfw.tTU = com_tencent_mm_protocal_c_bfj.tTU;
                mVar.nfw.tle = com_tencent_mm_protocal_c_bfj.tle;
                mVar.nfw.tld = com_tencent_mm_protocal_c_bfj.tld;
            }
        }
        this.nin.I(arrayList);
    }

    public final void fp(boolean z) {
    }

    protected final void aHd() {
        super.aHd();
    }

    public final void aGV() {
        this.nik.ncl = this.ngo.ndu.getZoom();
        this.activity.finish();
    }

    private void aHr() {
        aHf();
        this.nij.fr(false);
        this.nik.stop();
        this.nik.oD(3);
        k.aGN();
        this.nik.ncl = this.ngo.ndu.getZoom();
        this.activity.finish();
    }

    public final void aGW() {
        this.nij.fr(false);
        this.nik.stop();
        this.nik.oD(0);
        k.aGN();
        this.activity.finish();
    }

    public final void oH(int i) {
        if (i == 0) {
            com.tencent.mm.plugin.report.service.g.oUh.i(10997, new Object[]{"8", "", Integer.valueOf(0), Integer.valueOf(0)});
            aHr();
        } else if (i == 1) {
            com.tencent.mm.plugin.report.service.g.oUh.i(10997, new Object[]{"8", "", Integer.valueOf(0), Integer.valueOf(0)});
            aHr();
        } else if (i == 2) {
            aHr();
        }
    }

    public final void aGX() {
        bfj com_tencent_mm_protocal_c_bfj = this.nij.nfw;
        if (com_tencent_mm_protocal_c_bfj != null) {
            LocationInfo locationInfo = this.ngm;
            locationInfo.naQ = com_tencent_mm_protocal_c_bfj.tTU;
            locationInfo.naP = com_tencent_mm_protocal_c_bfj.tld;
            locationInfo.naO = com_tencent_mm_protocal_c_bfj.tle;
            if (TextUtils.isEmpty(com_tencent_mm_protocal_c_bfj.tTU)) {
                this.niT.setText("");
            } else {
                this.niT.setText(com_tencent_mm_protocal_c_bfj.tTU);
            }
            this.niT.b(this.ngm);
            n nVar = this.niT;
            nVar.ndu.updateLocaitonPinLayout(nVar.ndt, nVar.naO, nVar.naP);
            this.ngo.ndu.getIController().animateTo(this.ngm.naO, this.ngm.naP);
        }
    }

    public final void onBackPressed() {
        com.tencent.mm.plugin.report.service.g.oUh.i(10997, new Object[]{"11", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
        this.nil.aGU();
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public final void aHs() {
        super.aHs();
        if (this.nij != null) {
            this.nij.nfx = false;
            this.nij.fq(false);
            this.nih.aGy();
        }
    }

    public final void aHt() {
        super.aHt();
    }

    protected final void aHu() {
        super.aHu();
        com.tencent.mm.plugin.report.service.g.oUh.i(10997, new Object[]{"1", "", Integer.valueOf(0), Integer.valueOf(0)});
    }
}
