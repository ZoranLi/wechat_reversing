package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.by;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.n;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.protocal.c.awf;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.ArrayList;

public class i extends a implements e {
    protected long fGM = -1;
    private boolean fQy = true;
    private boolean jGP = false;
    public d lvq = new d(this.activity);
    private long nfA = 0;
    private String niS = "";
    n niT;
    public com.tencent.mm.ui.widget.e niU;
    boolean niV = false;
    private Runnable niW;
    private a niX = new a(this) {
        final /* synthetic */ i niY;

        {
            this.niY = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (!z) {
                return false;
            }
            w.d("MicroMsg.ViewMapUI", "onGetLocation flong " + f + " flat " + f2);
            if (((double) f2) == 0.0d && ((double) f) == 0.0d) {
                return true;
            }
            w.d("MicroMsg.ViewMapUI", "myLocation " + this.niY.ngn.naO + " " + this.niY.ngn.naP);
            if (!this.niY.ngn.aFU()) {
                w.d("MicroMsg.ViewMapUI", "location my show");
                this.niY.ngn.naO = (double) f2;
                this.niY.ngn.naP = (double) f;
                this.niY.ngr.a(this.niY.ngn.naO, this.niY.ngn.naP, this.niY.ngz, this.niY.ngn.naN);
            }
            return true;
        }
    };

    public i(Activity activity) {
        super(activity);
        ap.vd().a(424, this);
    }

    public boolean aHg() {
        if (this.niU == null || !this.niU.isShowing()) {
            aHC();
            this.niU.bzh();
        } else {
            this.niU.bzi();
        }
        return true;
    }

    public final void aHC() {
        this.niU = new com.tencent.mm.ui.widget.e(this.activity, com.tencent.mm.ui.widget.e.wuP, false);
        this.niU.qJf = new c(this) {
            final /* synthetic */ i niY;

            {
                this.niY = r1;
            }

            public final void a(l lVar) {
                lVar.a(1, this.niY.getString(R.l.dIF), 0);
                if (this.niY.type == 1) {
                    lVar.a(3, this.niY.getString(R.l.eGa), 0);
                } else if (this.niY.type == 2 && this.niY.activity.getIntent().getBooleanExtra("kFavCanDel", true)) {
                    lVar.a(5, this.niY.getString(R.l.ehS), 0);
                    lVar.a(4, this.niY.getString(R.l.dGB), 0);
                }
                b ddVar = new dd();
                ddVar.fGW.fGM = this.niY.fGM;
                com.tencent.mm.sdk.b.a.urY.m(ddVar);
                if (ddVar.fGX.fGu || g.m(ab.getContext(), 4)) {
                    lVar.a(6, this.niY.getString(R.l.ebR), 0);
                }
            }
        };
        this.niU.qJg = new com.tencent.mm.ui.base.n.d(this) {
            final /* synthetic */ i niY;

            {
                this.niY = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                Intent intent;
                switch (menuItem.getItemId()) {
                    case 0:
                        this.niY.aHD();
                        return;
                    case 1:
                        if (this.niY.type == 2) {
                            com.tencent.mm.plugin.report.service.g.oUh.i(10651, new Object[]{Integer.valueOf(6), Integer.valueOf(1), Integer.valueOf(0)});
                        }
                        intent = new Intent();
                        intent.putExtra("Retr_Msg_content", com.tencent.mm.plugin.location.model.e.a(this.niY.ngm));
                        intent.putExtra("Retr_Msg_Type", 9);
                        com.tencent.mm.bb.d.a(this.niY.activity, ".ui.transmit.MsgRetransmitUI", intent);
                        return;
                    case 2:
                        this.niY.ngt = 0;
                        this.niY.aHF();
                        return;
                    case 3:
                        this.niY.aHE();
                        return;
                    case 4:
                        com.tencent.mm.ui.base.g.a(this.niY.activity, this.niY.activity.getString(R.l.dGC), "", new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass2 niZ;

                            {
                                this.niZ = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                long longExtra = this.niZ.niY.activity.getIntent().getLongExtra("kFavInfoLocalId", -1);
                                b byVar = new by();
                                byVar.fFv.fFx = longExtra;
                                com.tencent.mm.sdk.b.a.urY.m(byVar);
                                w.d("MicroMsg.ViewMapUI", "do del fav voice, local id %d, result %B", new Object[]{Long.valueOf(longExtra), Boolean.valueOf(bg.b(Boolean.valueOf(byVar.fFw.fFj), false))});
                                if (bg.b(Boolean.valueOf(byVar.fFw.fFj), false)) {
                                    this.niZ.niY.activity.finish();
                                }
                            }
                        }, null);
                        return;
                    case 5:
                        long longExtra = this.niY.activity.getIntent().getLongExtra("kFavInfoLocalId", -1);
                        Intent intent2 = new Intent();
                        intent2.putExtra("key_fav_item_id", longExtra);
                        intent2.putExtra("key_fav_scene", 2);
                        com.tencent.mm.bb.d.b(this.niY.activity, "favorite", ".ui.FavTagEditUI", intent2);
                        return;
                    case 6:
                        intent = new Intent();
                        intent.putExtra("Retr_Msg_content", com.tencent.mm.plugin.location.model.e.a(this.niY.ngm));
                        intent.putExtra("Retr_Msg_Id", this.niY.fGM);
                        com.tencent.mm.bb.d.a(this.niY.activity, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    void aHe() {
        this.ngo.ngG.setEnabled(true);
        this.ngo.ngB.setVisibility(8);
        c(this.ngm);
        this.ngo.ndu.getIController().setZoom(this.zoom);
        this.ngo.ngE.setEnabled(true);
        this.fQy = this.activity.getIntent().getBooleanExtra("kShowshare", true);
        if (this.fQy) {
            this.ngo.ngE.setVisibility(0);
        } else {
            this.ngo.ngE.setVisibility(8);
        }
        this.niS = this.activity.getIntent().getStringExtra("soso_street_view_url");
        if (!bg.mA(this.niS) && (v.bIL() || v.bIK())) {
            this.niV = true;
        } else if (v.bIL() || v.bIK()) {
            this.niV = false;
            try {
                awf com_tencent_mm_protocal_c_awf = (awf) new z((float) this.ngm.naP, (float) this.ngm.naO, this.fGM).gUA.hsj.hsr;
                z zVar = new z(com_tencent_mm_protocal_c_awf);
                ap.vd().a(new z(com_tencent_mm_protocal_c_awf), 0);
            } catch (Exception e) {
                w.e("MicroMsg.ViewMapUI", e.toString());
            }
        }
        this.ngo.ngE.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ i niY;

            {
                this.niY = r1;
            }

            public final void onClick(View view) {
                this.niY.aHC();
                this.niY.niU.bzh();
            }
        });
        this.niT = new n(this.ngo.ndu, this.activity);
        n nVar = this.niT;
        if (nVar.ngb != null) {
            nVar.ngb.setOnClickListener(new View.OnClickListener(nVar) {
                final /* synthetic */ n ngg;

                {
                    this.ngg = r1;
                }

                public final void onClick(View view) {
                    if (this.ngg.ngc == null) {
                        return;
                    }
                    if (this.ngg.ngc.getVisibility() == 0) {
                        this.ngg.ngc.setVisibility(4);
                        this.ngg.isVisible = false;
                        return;
                    }
                    this.ngg.ngc.setVisibility(0);
                    this.ngg.isVisible = true;
                }
            });
            nVar.ngc.setVisibility(0);
        }
        a(this.niT);
        this.niT.b(this.ngm);
        this.niT.zD("");
        if (!com.tencent.mm.plugin.location.model.e.f(this.ngm.naO, this.ngm.naP)) {
            w.d("MicroMsg.ViewMapUI", "isValidLatLng %f %f", new Object[]{Double.valueOf(this.ngm.naO), Double.valueOf(this.ngm.naP)});
            nVar = this.niT;
            nVar.nds = false;
            nVar.ndt.setVisibility(8);
        }
        if (2 == this.type) {
            w.i("MicroMsg.ViewMapUI", "location id %s", new Object[]{this.ngm.naN});
            if (this.activity.getIntent().getBooleanExtra("kFavCanRemark", true)) {
                aHb();
            }
            if (!bg.mA(this.ngm.naQ)) {
                this.ngo.ngC.setVisibility(0);
            }
        }
        this.ngq.put(this.ngm.naN, this.niT);
        if (this.ngm.aFV()) {
            if (!(this.ndv == null || this.ndv.equals(""))) {
                this.niT.ndv = this.ndv;
            }
            this.niT.setText(this.niT.ncS + this.ngm.naQ);
        } else if (com.tencent.mm.plugin.location.model.e.f(this.ngm.naO, this.ngm.naP)) {
            this.ngr.a(this.ngm.naO, this.ngm.naP, this.ngz, this.ngm.naN);
        }
        this.ngo.ngH = this.niT.ngf;
        this.ngo.ngH.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ i niY;

            {
                this.niY = r1;
            }

            public final void onClick(View view) {
                this.niY.ngt = 0;
                this.niY.aHu();
                this.niY.aHF();
            }
        });
        this.ngo.ngH.setVisibility(0);
    }

    protected void aHw() {
    }

    protected void aHu() {
    }

    protected final void aHD() {
        if (this.niV) {
            r.a(new com.tencent.mm.pluginsdk.ui.tools.e());
            Intent intent = new Intent();
            intent.putExtra("show_bottom", false);
            intent.putExtra("jsapi_args_appid", "wx751a1acca5688ba3");
            intent.putExtra("rawUrl", this.niS);
            intent.putExtra("title", R.l.eOH);
            intent.putExtra("webview_bg_color_rsID", R.e.black);
            com.tencent.mm.bb.d.b(this.activity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    }

    public void onResume() {
        super.onResume();
        w.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
        if (this.ngy != null) {
            this.ngy.b(this.niX, true);
        }
    }

    public void onPause() {
        w.d("MicroMsg.ViewMapUI", "onbaseGeoResume");
        if (this.ngy != null) {
            this.ngy.c(this.niX);
        }
        super.onPause();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        double doubleExtra = this.activity.getIntent().getDoubleExtra("kwebmap_slat", 0.0d);
        double doubleExtra2 = this.activity.getIntent().getDoubleExtra("kwebmap_lng", 0.0d);
        w.i("MicroMsg.ViewMapUI", "start dslat " + doubleExtra + " " + doubleExtra2);
        this.zoom = this.activity.getIntent().getIntExtra("kwebmap_scale", 15);
        if (this.zoom <= 0) {
            this.zoom = 15;
        }
        this.ndv = this.activity.getIntent().getStringExtra("kPoiName");
        String stringExtra = this.activity.getIntent().getStringExtra("Kwebmap_locaion");
        w.d("MicroMsg.ViewMapUI", "view " + doubleExtra + " " + doubleExtra2);
        LocationInfo locationInfo = this.ngm;
        locationInfo.naO = doubleExtra;
        locationInfo.naP = doubleExtra2;
        locationInfo.naQ = stringExtra;
        locationInfo.zoom = this.zoom;
        locationInfo.fRX = this.ndv;
        this.fGM = this.activity.getIntent().getLongExtra("kMsgId", -1);
        this.nci = this.activity.getIntent().getStringExtra("map_talker_name");
        KC();
    }

    protected void aHd() {
        Intent intent = new Intent();
        intent.putExtra("kopenGmapNums", this.ngl.ncX);
        intent.putExtra("kopenOthersNums", this.ngl.ncY);
        intent.putExtra("kopenreportType", this.ngl.hNV);
        intent.putExtra("kRemark", aHc());
        intent.putExtra("soso_street_view_url", this.niS);
        this.activity.setResult(-1, intent);
    }

    protected final void aHE() {
        w.d("MicroMsg.ViewMapUI", "directlyFavorite lat %s, long %s, scale", new Object[]{Double.valueOf(this.ngm.naO), Double.valueOf(this.ngm.naP)});
        Intent intent = new Intent();
        intent.putExtra("kfavorite", true);
        intent.putExtra("kopenGmapNums", this.ngl.ncX);
        intent.putExtra("kopenOthersNums", this.ngl.ncY);
        intent.putExtra("kopenreportType", this.ngl.hNV);
        intent.putExtra("kRemark", aHc());
        intent.putExtra("kwebmap_slat", this.ngm.naO);
        intent.putExtra("kwebmap_lng", this.ngm.naP);
        intent.putExtra("Kwebmap_locaion", this.ngm.naQ);
        intent.putExtra("kPoiName", this.ndv);
        this.activity.setResult(-1, intent);
        this.activity.getIntent().getIntExtra("MMActivity.OverrideEnterAnimation", -1);
        this.activity.getIntent().getIntExtra("MMActivity.OverrideExitAnimation", -1);
        this.activity.finish();
    }

    protected final void aHF() {
        com.tencent.mm.plugin.report.service.g.oUh.i(12809, new Object[]{Integer.valueOf(3), ""});
        w.d("MicroMsg.ViewMapUI", "locationLine, locationInfo.slat=%f, locationInfo.slong=%f, myLocation.slat=%f, myLocation.slong=%f", new Object[]{Double.valueOf(this.ngm.naO), Double.valueOf(this.ngm.naP), Double.valueOf(this.ngn.naO), Double.valueOf(this.ngn.naP)});
        if (this.ngn.aFU()) {
            aHw();
            return;
        }
        this.ngs = true;
        if (this.handler != null) {
            if (this.niW != null) {
                this.handler.removeCallbacks(this.niW);
            }
            this.niW = new Runnable(this) {
                final /* synthetic */ i niY;

                {
                    this.niY = r1;
                }

                public final void run() {
                    if (this.niY.ngs) {
                        if (this.niY.isv != null) {
                            this.niY.isv.dismiss();
                        }
                        this.niY.aHw();
                    }
                    this.niY.ngs = false;
                }
            };
            this.handler.postDelayed(this.niW, 10000);
            Context context = this.activity;
            getString(R.l.dIO);
            this.isv = com.tencent.mm.ui.base.g.a(context, getString(R.l.eqB), true, new OnCancelListener(this) {
                final /* synthetic */ i niY;

                {
                    this.niY = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.niY.ngs = false;
                }
            });
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 4098:
            case 4099:
                com.tencent.mm.plugin.location.ui.d dVar = this.ngl;
                Intent intent2;
                switch (i) {
                    case 4098:
                        Bundle bundleExtra;
                        ArrayList parcelableArrayList;
                        if (-1 == i2 && intent != null) {
                            String stringExtra = intent.getStringExtra("selectpkg");
                            bundleExtra = intent.getBundleExtra("transferback");
                            boolean booleanExtra = intent.getBooleanExtra("isalways", false);
                            parcelableArrayList = bundleExtra.getParcelableArrayList("locations");
                            dVar.a((LocationInfo) parcelableArrayList.get(0), (LocationInfo) parcelableArrayList.get(1), stringExtra, booleanExtra);
                            return;
                        } else if (4097 == i2) {
                            if (intent.getBooleanExtra("isalways", false)) {
                                com.tencent.mm.plugin.report.service.g.oUh.i(11091, new Object[]{Integer.valueOf(6), Integer.valueOf(2)});
                            } else {
                                com.tencent.mm.plugin.report.service.g.oUh.i(11091, new Object[]{Integer.valueOf(6), Integer.valueOf(1)});
                            }
                            parcelableArrayList = intent.getBundleExtra("transferback").getParcelableArrayList("locations");
                            LocationInfo locationInfo = (LocationInfo) parcelableArrayList.get(0);
                            LocationInfo locationInfo2 = (LocationInfo) parcelableArrayList.get(1);
                            Parcelable intent3 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?f=d&saddr=%f,%f&daddr=%f,%f&hl=" + (bg.mA(locationInfo.naR) ? "zh-cn" : locationInfo.naR), new Object[]{Double.valueOf(locationInfo2.naO), Double.valueOf(locationInfo2.naP), Double.valueOf(locationInfo.naO), Double.valueOf(locationInfo.naP)})));
                            bundleExtra = new Bundle();
                            bundleExtra.putParcelable("targetintent", intent3);
                            intent2 = new Intent();
                            intent2.setClass(dVar.context, AppChooserUI.class);
                            intent2.putExtra(Columns.TYPE, 1);
                            intent2.putExtra("title", dVar.context.getResources().getString(R.l.ewr));
                            intent2.putExtra("targetintent", intent3);
                            intent2.putExtra("transferback", bundleExtra);
                            intent2.putExtra("scene", 6);
                            ((Activity) dVar.context).startActivityForResult(intent2, 4099);
                            return;
                        } else {
                            return;
                        }
                    case 4099:
                        if (-1 == i2 && intent != null) {
                            String stringExtra2 = intent.getStringExtra("selectpkg");
                            intent2 = new Intent((Intent) intent.getBundleExtra("transferback").getParcelable("targetintent"));
                            intent2.setPackage(stringExtra2);
                            intent2.addFlags(SQLiteGlobal.journalSizeLimit);
                            dVar.context.startActivity(intent2);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            default:
                return;
        }
    }

    public void onDestroy() {
        this.lvq.release();
        this.handler.removeCallbacks(this.niW);
        this.handler = null;
        ap.vd().b(424, this);
        super.onDestroy();
    }

    protected final String Oh() {
        return getString(R.l.ewx);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.mxi = motionEvent.getX();
                this.jWC = motionEvent.getY();
                this.nfA = System.currentTimeMillis();
                this.jGP = false;
                aHv();
                break;
            case 1:
                if (!this.jGP) {
                    System.currentTimeMillis();
                }
                aHt();
                break;
            case 2:
                if (Math.abs(motionEvent.getX() - this.mxi) > 10.0f || Math.abs(motionEvent.getY() - this.jWC) > 10.0f) {
                    this.jGP = true;
                    aHs();
                    break;
                }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void aHs() {
        if (this.niT != null) {
            this.niT.fs(false);
        }
    }

    public void aHt() {
        if (this.niT != null) {
            this.niT.fs(true);
        }
    }

    public void aHv() {
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.ViewMapUI", "onScene end %d %d %d", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        if (kVar.getType() != 424) {
            w.e("MicroMsg.ViewMapUI", "msg failed.errtype:%d, errcode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (i2 == 0 && i == 0) {
            String kD = z.kD(((z) kVar).Jw().tlo);
            w.d("MicroMsg.ViewMapUI", "getUrl success! url is %s", new Object[]{kD});
            this.niS = kD;
            if (!bg.mA(kD)) {
                this.niV = true;
            }
            if (this.type == 9 && !bg.mA(kD)) {
                TextView textView = (TextView) findViewById(R.h.cGF);
                textView.setVisibility(0);
                textView.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ i niY;

                    {
                        this.niY = r1;
                    }

                    public final void onClick(View view) {
                        this.niY.aHD();
                    }
                });
            }
        }
    }
}
