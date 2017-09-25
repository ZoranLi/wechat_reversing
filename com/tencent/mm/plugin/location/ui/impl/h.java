package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.fp;
import com.tencent.mm.e.a.qk;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.MyLocationButton;
import com.tencent.mm.plugin.location.ui.NewMyLocationButton;
import com.tencent.mm.plugin.location.ui.f;
import com.tencent.mm.plugin.location.ui.l;
import com.tencent.mm.plugin.location.ui.m;
import com.tencent.mm.plugin.location.ui.n;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.widget.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class h extends i {
    private View niA;
    private boolean niB = false;
    private e niC;
    public Map<String, String> niD;
    public int niE;
    public MyLocationButton nih;
    public m nij;
    public l nil;
    private Button nix;
    private NewMyLocationButton niy;
    private f niz;

    public h(Activity activity) {
        super(activity);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.yY();
        this.niE = ((Integer) c.vr().get(a.uHq, Integer.valueOf(0))).intValue();
        w.i("MicroMsg.TrackMapUI", "count: %s", new Object[]{Integer.valueOf(this.niE)});
    }

    final void aHe() {
        super.aHe();
        if (this.activity.getIntent().getBooleanExtra("KFavLocSigleView", false) && this.activity.getIntent().getBooleanExtra("kFavCanRemark", false)) {
            this.niB = true;
        }
        w.d("MicroMsg.TrackMapUI", "oldVer %s", new Object[]{Boolean.valueOf(this.niB)});
        ((TextView) findViewById(R.h.cjU)).setText(R.l.ccb);
        findViewById(R.h.cJe).setVisibility(8);
        if (!this.niB) {
            ViewStub viewStub = (ViewStub) findViewById(R.h.ccf);
            viewStub.setOnInflateListener(new OnInflateListener(this) {
                final /* synthetic */ h niF;

                {
                    this.niF = r1;
                }

                public final void onInflate(ViewStub viewStub, View view) {
                    view.findViewById(R.h.ccd).setOnTouchListener(new OnTouchListener(this) {
                        final /* synthetic */ AnonymousClass1 niG;

                        {
                            this.niG = r1;
                        }

                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            return true;
                        }
                    });
                }
            });
            this.niA = viewStub.inflate();
            findViewById(R.h.cbY).setVisibility(8);
        }
        this.nij = new m(this.activity, this.ngo.ndu, false);
        this.nij.nfx = false;
        this.nij.nfy = false;
        m mVar = this.nij;
        mVar.nfv = true;
        if (mVar.nfo != null) {
            mVar.nfo.c(null);
            mVar.nfo.b(null);
            mVar.nfo.aHz();
        }
        this.nij.nfs = false;
        this.nil = new l(this.activity, new l.a(this) {
            final /* synthetic */ h niF;

            {
                this.niF = r1;
            }

            public final void fp(boolean z) {
                if (com.tencent.mm.plugin.location.model.l.aGf().cH(this.niF.nci, com.tencent.mm.u.m.xL())) {
                    this.niF.aHy();
                } else if (z || this.niF.d(this.niF.ngm)) {
                    this.niF.aHy();
                } else {
                    l lVar = this.niF.nil;
                    if (lVar.nfk == null) {
                        lVar.nfk = g.a(lVar.mContext, lVar.Cu.getString(R.l.ewq), "", false, new OnClickListener(lVar) {
                            final /* synthetic */ l nfl;

                            {
                                this.nfl = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (this.nfl.nfj != null) {
                                    this.nfl.nfj.aGX();
                                }
                                this.nfl.nfk = null;
                            }
                        }, new OnClickListener(lVar) {
                            final /* synthetic */ l nfl;

                            {
                                this.nfl = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.nfl.nfk = null;
                            }
                        });
                    }
                }
            }

            public final void aGV() {
            }

            public final void oH(int i) {
            }

            public final void aGW() {
            }

            public final void aGX() {
                this.niF.aHy();
            }
        });
        if (this.niB) {
            boolean z;
            this.nix = (Button) findViewById(R.h.cGn);
            this.nix.setVisibility(0);
            this.nix.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ h niF;

                {
                    this.niF = r1;
                }

                public final void onClick(View view) {
                    boolean z = com.tencent.mm.pluginsdk.l.a.sBy != null && com.tencent.mm.pluginsdk.l.a.sBy.zs(this.niF.nci);
                    boolean z2;
                    if (com.tencent.mm.pluginsdk.l.a.sBr == null || !com.tencent.mm.pluginsdk.l.a.sBr.Hr(this.niF.nci)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (z || !r2) {
                        l lVar = this.niF.nil;
                        if (!l.oF(67589)) {
                            g.a(lVar.mContext, lVar.Cu.getString(R.l.ewE), "", false, new OnClickListener(lVar) {
                                final /* synthetic */ l nfl;

                                {
                                    this.nfl = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    if (this.nfl.nfj != null) {
                                        this.nfl.nfj.fp(true);
                                    }
                                }
                            }, new OnClickListener(lVar) {
                                final /* synthetic */ l nfl;

                                {
                                    this.nfl = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            l.oG(67589);
                            return;
                        } else if (lVar.nfj != null) {
                            lVar.nfj.fp(false);
                            return;
                        } else {
                            return;
                        }
                    }
                    b qkVar = new qk();
                    qkVar.fXu.fXw = true;
                    com.tencent.mm.sdk.b.a.urY.m(qkVar);
                    if (this.niF.nci.equals(qkVar.fXv.fXy)) {
                        g.a(this.niF.activity, this.niF.getString(R.l.eew), "", this.niF.getString(R.l.esq), false, new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass6 niH;

                            {
                                this.niH = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    } else {
                        g.a(this.niF.activity, this.niF.getString(R.l.eex), "", this.niF.getString(R.l.esq), false, new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass6 niH;

                            {
                                this.niH = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    }
                }
            });
            this.nix.setEnabled(true);
            if (this.type == 2) {
                z = false;
            } else if (this.type == 3) {
                z = false;
            } else if (this.type == 7) {
                z = false;
            } else if (this.type == 9) {
                z = false;
            } else if (this.fGM != -1) {
                ap.yY();
                ce cA = c.wT().cA(this.fGM);
                z = (o.eV(cA.field_talker) || o.fB(cA.field_talker) || x.QM(cA.field_talker) || x.QO(cA.field_talker) || x.eO(cA.field_talker)) ? false : true;
            } else {
                z = true;
            }
            if (!z) {
                this.nix.setVisibility(8);
            }
        } else {
            findViewById(R.h.cGn).setVisibility(8);
        }
        this.ngo.ngD.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ h niF;

            {
                this.niF = r1;
            }

            public final void onClick(View view) {
                this.niF.aHd();
                this.niF.aHf();
                this.niF.activity.finish();
            }
        });
        final String stringExtra;
        if (this.niB) {
            this.nih = (MyLocationButton) findViewById(R.h.cbY);
            this.nih.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ h niF;

                {
                    this.niF = r1;
                }

                public final void onClick(View view) {
                    w.d("MicroMsg.TrackMapUI", "newpoi my position ", new Object[]{this.niF.nih});
                    this.niF.nij.a(this.niF.ngo.ndu);
                }
            });
            if (this.type == 2 && this.activity.getIntent().getBooleanExtra("kFavCanRemark", true)) {
                ((MarginLayoutParams) this.nih.getLayoutParams()).bottomMargin = com.tencent.mm.bg.a.fromDPToPix(this.activity, 80);
            }
            stringExtra = this.activity.getIntent().getStringExtra("kPoi_url");
            if (bg.mA(stringExtra)) {
                this.ngo.ngK.setVisibility(8);
            } else {
                this.ngo.ngK.setVisibility(0);
                this.ngo.ngK.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ h niF;

                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setClass(this.niF.activity, com.tencent.mm.ui.d.h.class);
                        w.d("MicroMsg.TrackMapUI", "click url %s", new Object[]{stringExtra});
                        intent.putExtra("rawUrl", stringExtra);
                        intent.putExtra("showShare", false);
                        d.a(this.niF.activity, "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                    }
                });
            }
        } else {
            this.niy = (NewMyLocationButton) this.niA.findViewById(R.h.cnO);
            this.niy.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ h niF;

                {
                    this.niF = r1;
                }

                public final void onClick(View view) {
                    this.niF.nij.a(this.niF.ngo.ndu);
                }
            });
            stringExtra = this.activity.getIntent().getStringExtra("kPoi_url");
            if (bg.mA(stringExtra)) {
                this.ngo.ngK.setVisibility(8);
            } else {
                this.ngo.ngK.setVisibility(0);
                this.ngo.ngK.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ h niF;

                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setClass(this.niF.activity, com.tencent.mm.ui.d.h.class);
                        w.d("MicroMsg.TrackMapUI", "click url %s", new Object[]{stringExtra});
                        intent.putExtra("rawUrl", stringExtra);
                        intent.putExtra("showShare", false);
                        d.a(this.niF.activity, "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                    }
                });
            }
        }
        if (!this.niB) {
            n nVar = this.niT;
            int i = R.g.bgk;
            if (nVar.ndt != null && nVar.ngb == null) {
                nVar.ngb = (ImageView) nVar.ndt.findViewById(R.h.cbZ);
            }
            nVar.ngb.setImageResource(i);
            this.niT.ngd.setVisibility(4);
            this.niz = new f(this.ngo.ndu, this.activity);
            if (this.ngm.aFV()) {
                if (!(this.ndv == null || this.ndv.equals(""))) {
                    this.niz.ndv = this.ndv;
                }
                this.niz.setText(this.niT.ncS + this.ngm.naQ);
            }
            View.OnClickListener anonymousClass4 = new View.OnClickListener(this) {
                final /* synthetic */ h niF;

                {
                    this.niF = r1;
                }

                public final void onClick(View view) {
                    w.d("MicroMsg.TrackMapUI", "newpoi old go back onclick");
                    this.niF.ngt = 0;
                    this.niF.aHu();
                    this.niF.aHF();
                }
            };
            f fVar = this.niz;
            fVar.ndy.setOnClickListener(anonymousClass4);
            fVar.ndy.setVisibility(0);
        }
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            keyEvent.getAction();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public final void aHs() {
        super.aHs();
    }

    public final void aHt() {
        super.aHt();
    }

    public final void aHv() {
        super.aHv();
        w.i("MicroMsg.TrackMapUI", "onDown");
    }

    protected final void aHw() {
        this.niC = new e(this.activity, e.wuP, false);
        this.niC.qJf = new com.tencent.mm.ui.base.n.c(this) {
            final /* synthetic */ h niF;

            {
                this.niF = r1;
            }

            public final void a(com.tencent.mm.ui.base.l lVar) {
                if (this.niF.niV) {
                    lVar.a(1, this.niF.getString(R.l.ewG), 0);
                }
                h hVar = this.niF;
                com.tencent.mm.plugin.location.ui.d dVar = this.niF.ngl;
                LocationInfo locationInfo = this.niF.ngm;
                ArrayList arrayList = new ArrayList();
                arrayList.add("com.tencent.map");
                arrayList.add("com.google.android.apps.maps");
                arrayList.add("com.baidu.BaiduMap");
                arrayList.add("com.autonavi.minimap");
                arrayList.add("com.sogou.map.android.maps");
                String str = "android.intent.action.VIEW";
                Intent intent = new Intent(str, Uri.parse(String.format("geo:%f,%f", new Object[]{Double.valueOf(locationInfo.naO), Double.valueOf(locationInfo.naP)})));
                PackageManager packageManager = dVar.context.getPackageManager();
                Map hashMap = new HashMap();
                for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 65536)) {
                    if (arrayList.contains(resolveInfo.activityInfo.packageName)) {
                        hashMap.put(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.loadLabel(dVar.context.getPackageManager()).toString());
                    }
                }
                hVar.niD = hashMap;
                if (this.niF.niE < 4 || this.niF.aHx()) {
                    lVar.W(2, R.l.eYg, 0);
                }
                int i = 3;
                for (Entry entry : this.niF.niD.entrySet()) {
                    if (!((String) entry.getKey()).equals("com.tencent.map")) {
                        lVar.a(i, (CharSequence) entry.getValue(), 0);
                    }
                    i++;
                }
            }
        };
        this.niC.qJg = new com.tencent.mm.ui.base.n.d(this) {
            final /* synthetic */ h niF;

            {
                this.niF = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 1:
                        this.niF.aHD();
                        return;
                    case 2:
                        w.i("MicroMsg.TrackMapUI", "click tencent map: %s", new Object[]{Boolean.valueOf(this.niF.niD.containsKey("com.tencent.map"))});
                        if (this.niF.aHx()) {
                            this.niF.ngl.a(this.niF.ngm, this.niF.ngn, "com.tencent.map", false);
                            return;
                        }
                        if (this.niF.niE < 4) {
                            h hVar = this.niF;
                            hVar.niE++;
                            ap.yY();
                            c.vr().a(a.uHq, Integer.valueOf(this.niF.niE));
                        }
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", "https://3gimg.qq.com/map_site_cms/download/index.html?appid=wechat_android&logid=and_wechat_1.0&ch=appdownload");
                        d.b(this.niF.activity, "webview", ".ui.tools.WebViewUI", intent);
                        return;
                    default:
                        if (this.niF.niD != null) {
                            for (Entry entry : this.niF.niD.entrySet()) {
                                if (((String) entry.getValue()).equals(menuItem.getTitle())) {
                                    this.niF.ngl.a(this.niF.ngm, this.niF.ngn, (String) entry.getKey(), false);
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                }
            }
        };
        this.niC.bzh();
    }

    public final boolean aHx() {
        return this.niD.containsKey("com.tencent.map");
    }

    public final void aHy() {
        w.i("MicroMsg.TrackMapUI", "onShare");
        d.D(this.activity);
        Intent intent = this.activity.getIntent();
        intent.putExtra("intent_map_key", 5);
        intent.putExtra("kwebmap_scale", this.ngo.ndu.getZoomLevel());
        com.tencent.mm.plugin.location.a.a zr = com.tencent.mm.plugin.location.model.l.aGf().zr(this.nci);
        if (zr != null && zr.fPA.size() > 0) {
            intent.putExtra("kwebmap_slat", zr.latitude);
            intent.putExtra("kwebmap_lng", zr.longitude);
            intent.putExtra("Kwebmap_locaion", zr.naK);
            intent.putExtra("fromWhereShare", "fromTrackButton");
        }
        this.activity.startActivity(intent);
        this.activity.finish();
    }

    public final boolean d(LocationInfo locationInfo) {
        com.tencent.mm.plugin.location.a.a zr = com.tencent.mm.plugin.location.model.l.aGf().zr(this.nci);
        w.i("MicroMsg.TrackMapUI", "resume try to enter trackRoom " + (zr != null));
        if (zr == null) {
            return true;
        }
        if (!bg.mA(zr.naK) && !bg.mA(locationInfo.naQ) && !zr.naK.equals(locationInfo.naQ)) {
            return false;
        }
        if (Math.abs(zr.latitude - locationInfo.naO) >= 0.001d || Math.abs(zr.longitude - locationInfo.naP) >= 0.001d) {
            return false;
        }
        return true;
    }

    public final void onDestroy() {
        super.onDestroy();
        if (this.nij != null) {
            this.nij.destroy();
        }
    }

    public final void onResume() {
        super.onResume();
        if (this.nij != null) {
            this.nij.onResume();
        }
        if (this.type == 2) {
            b fpVar = new fp();
            fpVar.fKp.fFx = this.activity.getIntent().getLongExtra("kFavInfoLocalId", -1);
            fpVar.fKp.type = 4;
            com.tencent.mm.sdk.b.a.urY.m(fpVar);
            if (fpVar.fKq.fKy != null) {
                if (this.ngu == null) {
                    this.ngu = new ArrayList();
                } else {
                    this.ngu.clear();
                }
                this.ngu.addAll(fpVar.fKq.fKy);
                aHa();
            }
        }
    }

    public final void onPause() {
        super.onPause();
        if (this.nij != null) {
            this.nij.onPause();
        }
    }
}
