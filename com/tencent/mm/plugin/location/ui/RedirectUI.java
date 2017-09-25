package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.e.a.lf;
import com.tencent.mm.e.a.nv;
import com.tencent.mm.e.a.ql;
import com.tencent.mm.i.g;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.ui.impl.d;
import com.tencent.mm.pluginsdk.location.LocationIntent;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.a;

@a(23)
public class RedirectUI extends Activity {
    private static long gKu = 86400000;
    private long fGM;
    private boolean fOV = false;
    private final ae handler = new ae();
    private String info = "";
    private int knu;
    private double naO = 0.0d;
    private double naP = 0.0d;
    private boolean ncZ = true;
    private String ndH = "";
    private String ndI = "";
    private int ndJ;
    private final int ndK = 1;
    private boolean ndL = false;
    private final int ndM = 0;
    private final int ndN = 1;
    private final int ndO = 0;
    private final int ndP = 1;
    private int type = 0;
    private int zoom = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(0);
        }
        ap.yY();
        if ((bg.az(Long.valueOf(bg.c((Long) c.vr().get(81938, null))).longValue()) * 1000 > gKu ? 1 : 0) != 0) {
            com.tencent.mm.ap.c.HV().update();
        }
        this.type = getIntent().getIntExtra("map_view_type", -1);
        if (this.type == -1) {
            finish();
        }
        this.fGM = getIntent().getLongExtra("kMsgId", -1);
        this.ndI = getIntent().getStringExtra("map_talker_name");
        w.d("MicroMsg.RedirectUI", "tofutest type: %s", new Object[]{Integer.valueOf(this.type)});
        switch (this.type) {
            case 0:
            case 3:
            case 8:
                this.ndH = getIntent().getStringExtra("map_sender_name");
                this.knu = getIntent().getIntExtra("view_type_key", 1);
                this.ndJ = getIntent().getIntExtra("key_get_location_type", 0);
                h(-85.0d, -1000.0d);
                return;
            case 1:
            case 2:
            case 7:
            case 9:
                this.naO = getIntent().getDoubleExtra("kwebmap_slat", -85.0d);
                this.naP = getIntent().getDoubleExtra("kwebmap_lng", -1000.0d);
                this.zoom = getIntent().getIntExtra("kwebmap_scale", 0);
                this.info = getIntent().getStringExtra("Kwebmap_locaion");
                h(this.naO, this.naP);
                return;
            case 6:
                com.tencent.mm.plugin.location.a.a zr = l.aGf().zr(this.ndI);
                w.i("MicroMsg.RedirectUI", "resume try to enter trackRoom " + (zr != null));
                if (zr != null) {
                    this.naO = zr.latitude;
                    this.naP = zr.longitude;
                    this.info = zr.naK;
                    w.i("MicroMsg.RedirectUI", "resume lat %f lng %f %s member size %d", new Object[]{Double.valueOf(this.naO), Double.valueOf(this.naP), this.info, Integer.valueOf(zr.fPA.size())});
                    this.zoom = 0;
                    h(this.naO, this.naP);
                    return;
                }
                h(-1000.0d, -1000.0d);
                return;
            default:
                return;
        }
    }

    private void h(double d, double d2) {
        this.fOV = true;
        Intent D = d.D(this);
        switch (this.type) {
            case 0:
            case 3:
            case 8:
                String str = "MicroMsg.RedirectUI";
                StringBuilder stringBuilder = new StringBuilder("view poi      isHidePoiOversea : ");
                boolean z = bg.getInt(g.sW().z("ShowConfig", "hidePoiOversea"), 1) == 1;
                w.d("MicroMsg.ConfigListDecoder", "isHidePoiOversea : " + z);
                w.d(str, stringBuilder.append(z).toString());
                D.putExtra("intent_map_key", 2);
                break;
            case 1:
            case 2:
            case 7:
                w.d("MicroMsg.RedirectUI", "view normal");
                D.putExtra("intent_map_key", 4);
                break;
            case 6:
                String stringExtra = getIntent().getStringExtra("fromWhereShare");
                w.d("MicroMsg.RedirectUI", "location resume");
                D.putExtra("intent_map_key", 5);
                if (!bg.mA(stringExtra)) {
                    D.putExtra("fromWhereShare", stringExtra);
                    break;
                }
                break;
            case 9:
                D.putExtra("intent_map_key", 4);
                break;
            default:
                w.d("MicroMsg.RedirectUI", "view type error");
                D = null;
                break;
        }
        switch (this.type) {
            case 0:
                D.putExtra("location_scene", 1);
                break;
        }
        if (r.iiu) {
            final double d3 = d;
            final double d4 = d2;
            this.handler.postDelayed(new Runnable(this) {
                final /* synthetic */ RedirectUI ndQ;

                public final void run() {
                    this.ndQ.a(D, d3, d4);
                }
            }, 2000);
            return;
        }
        a(D, d, d2);
    }

    private void a(Intent intent, double d, double d2) {
        if (intent != null) {
            intent.putExtra("kShowshare", getIntent().getBooleanExtra("kShowshare", true));
            ap.yY();
            intent.putExtra("kimg_path", c.xb());
            intent.putExtra("kPoi_url", bg.ap(getIntent().getStringExtra("kPoi_url"), ""));
            intent.putExtra("map_view_type", getIntent().getIntExtra("map_view_type", 0));
            intent.putExtra("kFavInfoLocalId", getIntent().getLongExtra("kFavInfoLocalId", -1));
            intent.putExtra("kFavCanDel", getIntent().getBooleanExtra("kFavCanDel", true));
            intent.putExtra("kFavCanRemark", getIntent().getBooleanExtra("kFavCanRemark", true));
            intent.putExtra("kwebmap_slat", d);
            intent.putExtra("kwebmap_lng", d2);
            intent.putExtra("kPoiName", getIntent().getStringExtra("kPoiName"));
            intent.putExtra("kisUsername", bg.ap(getIntent().getStringExtra("kisUsername"), ""));
            intent.putExtra("map_talker_name", this.ndI);
            intent.putExtra("kIs_pick_poi", getIntent().getBooleanExtra("kIs_pick_poi", false));
            intent.putExtra("KFavLocSigleView", getIntent().getBooleanExtra("KFavLocSigleView", false));
            b qlVar = new ql();
            qlVar.fXz.fXA = true;
            com.tencent.mm.sdk.b.a.urY.m(qlVar);
            if (this.type == 6) {
                intent.putExtra("kMsgId", getIntent().getLongExtra("kMsgId", -1));
                intent.putExtra("kRemark", getIntent().getStringExtra("kRemark"));
                if (this.zoom > 0) {
                    intent.putExtra("kwebmap_scale", this.zoom);
                }
                intent.putExtra("Kwebmap_locaion", this.info);
                intent.putExtra("soso_street_view_url", getIntent().getStringExtra("soso_street_view_url"));
                startActivityForResult(intent, 3);
                return;
            } else if (this.type == 1 || this.type == 2 || this.type == 7 || this.type == 9) {
                intent.putExtra("kMsgId", getIntent().getLongExtra("kMsgId", -1));
                intent.putExtra("kRemark", getIntent().getStringExtra("kRemark"));
                intent.putExtra("kTags", getIntent().getStringArrayListExtra("kTags"));
                if (this.zoom > 0) {
                    intent.putExtra("kwebmap_scale", this.zoom);
                }
                intent.putExtra("Kwebmap_locaion", this.info);
                intent.putExtra("soso_street_view_url", getIntent().getStringExtra("soso_street_view_url"));
                startActivityForResult(intent, 3);
                return;
            } else if (this.type == 0) {
                startActivityForResult(intent, 2);
                return;
            } else if (this.type == 3) {
                startActivityForResult(intent, 5);
                return;
            } else if (this.type == 8) {
                startActivityForResult(intent, 6);
                return;
            } else {
                return;
            }
        }
        finish();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.i("MicroMsg.RedirectUI", "onAcvityResult requestCode:" + i);
        if (i2 != -1) {
            finish();
        } else if (intent == null) {
            finish();
        } else {
            LocationIntent locationIntent;
            switch (i) {
                case 2:
                    String str = this.ndI;
                    locationIntent = (LocationIntent) intent.getParcelableExtra("KLocationIntent");
                    w.i("MicroMsg.RedirectUI", "locationintent " + locationIntent.bmG());
                    b lfVar = new lf();
                    lfVar.fRU.fRW = this.ndJ;
                    lfVar.fRU.lat = locationIntent.lat;
                    lfVar.fRU.lng = locationIntent.lng;
                    lfVar.fRU.fOd = locationIntent.fOd;
                    lfVar.fRU.label = locationIntent.label;
                    lfVar.fRU.fRX = locationIntent.ndv;
                    com.tencent.mm.sdk.b.a.urY.m(lfVar);
                    double d = locationIntent.lat;
                    double d2 = locationIntent.lng;
                    int i3 = locationIntent.fOd;
                    String str2 = locationIntent.label;
                    String str3 = locationIntent.ndv;
                    String str4 = locationIntent.sBQ;
                    if (str3 == null) {
                        str3 = "";
                    }
                    str3 = "<msg><location x=\"" + d + "\" y=\"" + d2 + "\" scale=\"" + i3 + "\" label=\"" + bg.PW(str2) + "\" poiname=\"" + bg.PW(str3) + "\" infourl=\"" + bg.PW(str4) + "\" maptype=\"0\" /></msg>";
                    w.d("MicroMsg.RedirectUI", "xml " + str3);
                    b nvVar = new nv();
                    nvVar.fVa.fVb = str;
                    nvVar.fVa.content = str3;
                    nvVar.fVa.type = 48;
                    nvVar.fVa.flags = 0;
                    com.tencent.mm.sdk.b.a.urY.m(nvVar);
                    n.a(2004, (float) locationIntent.lng, (float) locationIntent.lat, 0);
                    break;
                case 5:
                    locationIntent = (LocationIntent) intent.getParcelableExtra("KLocationIntent");
                    w.i("MicroMsg.RedirectUI", "locationintent " + locationIntent.bmG());
                    if (locationIntent.sBR == 3) {
                        com.tencent.mm.plugin.report.service.g.oUh.i(10822, new Object[]{Integer.valueOf(1), locationIntent.naS, Integer.valueOf(1)});
                    } else {
                        com.tencent.mm.plugin.report.service.g.oUh.i(10822, new Object[]{Integer.valueOf(1), locationIntent.naS, Integer.valueOf(0)});
                    }
                    intent.putExtra("kwebmap_slat", locationIntent.lat);
                    intent.putExtra("kwebmap_lng", locationIntent.lng);
                    intent.putExtra("kwebmap_scale", locationIntent.fOd);
                    intent.putExtra("Kwebmap_locaion", locationIntent.label);
                    intent.putExtra("kTags", intent.getStringArrayListExtra("kTags"));
                    intent.putExtra("kPoiName", locationIntent.ndv.equals("") ? "" : locationIntent.ndv);
                    break;
                case 6:
                    locationIntent = (LocationIntent) intent.getParcelableExtra("KLocationIntent");
                    w.i("MicroMsg.RedirectUI", "locationintent " + locationIntent.bmG());
                    if (locationIntent.hCX != null) {
                        w.d("MicroMsg.RedirectUI", "addr: " + locationIntent.hCX.toString());
                    }
                    intent.putExtra("key_pick_addr", locationIntent.hCX);
                    break;
            }
            setResult(i2, intent);
            finish();
        }
    }

    protected void onDestroy() {
        this.ncZ = false;
        super.onDestroy();
    }

    public void finish() {
        super.finish();
    }
}
