package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;

public final class j implements com.tencent.mm.ui.MMActivity.a {
    public com.tencent.mm.modelgeo.c hvP = null;
    public com.tencent.mm.modelgeo.b ngr = null;
    int rYd;
    boolean smO = false;
    int smP;
    public e smQ;
    public e smR;
    String smS;
    public WeakReference<Context> smT;
    d smU;
    public com.tencent.mm.modelgeo.b.a smV = null;
    public com.tencent.mm.modelgeo.b.a smW = null;
    public com.tencent.mm.modelgeo.a.a smX = null;
    final Runnable smY = new Runnable(this) {
        final /* synthetic */ j smZ;

        {
            this.smZ = r1;
        }

        public final void run() {
            if (this.smZ.smX != null && this.smZ.hvP != null) {
                this.smZ.ngr.a(this.smZ.smV);
                this.smZ.hvP.c(this.smZ.smX);
                this.smZ.smX.a(false, 0.0f, 0.0f, 0, 0.0d, 0.0d, 0.0d);
            }
        }
    };

    interface d {
        void mF(int i);

        void rD(int i);

        void wF(int i);

        void wG(int i);
    }

    private static final class e {
        public double latitude;
        public double longitude;
        public String snb = null;

        public e(double d, double d2) {
            this.latitude = d;
            this.longitude = d2;
        }
    }

    private static abstract class f {
        protected abstract String getPackageName();

        protected void a(Context context, e eVar, e eVar2, String str) {
            if (context != null) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + eVar2.latitude + "," + eVar2.longitude));
                intent.setPackage(getPackageName());
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                context.startActivity(intent);
            }
        }
    }

    private static final class a extends f {
        protected final void a(Context context, e eVar, e eVar2, String str) {
            if (context == null) {
                super.a(context, eVar, eVar2, str);
                return;
            }
            String format = String.format("baidumap://map/direction?destination=%f,%f&mode=driving", new Object[]{Double.valueOf(eVar2.latitude), Double.valueOf(eVar2.longitude)});
            if (eVar != null) {
                format = format + String.format("origin=%f,%f", new Object[]{Double.valueOf(eVar.latitude), Double.valueOf(eVar.longitude)});
            }
            w.d("MicroMsg.OpenMapNavigator", "url " + format);
            try {
                context.startActivity(Intent.parseUri(format + "&src=webapp.car.carroutelistmappg.weixindrivenav", 0));
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.OpenMapNavigator", e, "", new Object[0]);
            }
        }

        protected final String getPackageName() {
            return com.tencent.mm.pluginsdk.model.a.a.sCa.getPackage();
        }
    }

    private static final class b extends f {
        protected final void a(Context context, e eVar, e eVar2, String str) {
            if (context == null) {
                super.a(context, eVar, eVar2, str);
                return;
            }
            String str2 = "android.intent.action.VIEW";
            Intent intent = new Intent(str2, Uri.parse(String.format("androidamap://navi?sourceApplication=%s&lat=%f&lon=%f&dev=1&style=2", new Object[]{"MicroMessager", Double.valueOf(eVar2.latitude), Double.valueOf(eVar2.longitude)})));
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setPackage(com.tencent.mm.pluginsdk.model.a.a.sCb.getPackage());
            context.startActivity(intent);
        }

        protected final String getPackageName() {
            return com.tencent.mm.pluginsdk.model.a.a.sCb.getPackage();
        }
    }

    private static final class c extends f {
        protected final void a(Context context, e eVar, e eVar2, String str) {
            if (context == null) {
                super.a(context, eVar, eVar2, str);
                return;
            }
            String format = String.format("http://maps.google.com/maps?f=d&daddr=%f,%f", new Object[]{Double.valueOf(eVar2.latitude), Double.valueOf(eVar2.longitude)});
            if (eVar != null) {
                format = format + String.format("&saddr=%f,%f", new Object[]{Double.valueOf(eVar.latitude), Double.valueOf(eVar.longitude)});
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(format));
            intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
            context.startActivity(intent);
        }

        protected final String getPackageName() {
            return com.tencent.mm.pluginsdk.model.a.a.sBY.getPackage();
        }
    }

    private static final class g extends f {
        protected final void a(Context context, e eVar, e eVar2, String str) {
            if (context == null) {
                super.a(context, eVar, eVar2, str);
                return;
            }
            String format = String.format("wechatnav://type=nav&tocoord=%f,%f", new Object[]{Double.valueOf(eVar2.latitude), Double.valueOf(eVar2.longitude)});
            if (eVar != null) {
                format = format + String.format("&fromcoord=%f,%f", new Object[]{Double.valueOf(eVar.latitude), Double.valueOf(eVar.longitude)});
                if (!bg.mA(eVar.snb)) {
                    format = format + String.format("&from=%s", new Object[]{URLEncoder.encode(eVar.snb)});
                }
            } else {
                format = format + String.format("&from=%s", new Object[]{"我的位置"});
            }
            if (bg.mA(str)) {
                if (bg.mA(eVar2.snb)) {
                    str = "目的地";
                } else {
                    str = eVar2.snb;
                }
            }
            String str2 = "android.intent.action.VIEW";
            Intent intent = new Intent(str2, Uri.parse(format + String.format("&to=%s", new Object[]{str})));
            intent.setPackage(com.tencent.mm.pluginsdk.model.a.a.sBZ.getPackage());
            context.startActivity(intent);
        }

        protected final String getPackageName() {
            return com.tencent.mm.pluginsdk.model.a.a.sBZ.getPackage();
        }
    }

    private static final class h extends f {
        protected final void a(Context context, e eVar, e eVar2, String str) {
            if (context == null) {
                super.a(context, eVar, eVar2, str);
                return;
            }
            String format = String.format("sosomap://type=nav&tocoord=%f,%f", new Object[]{Double.valueOf(eVar2.longitude), Double.valueOf(eVar2.latitude)});
            if (eVar != null) {
                format = format + String.format("fromcoord=%f,%f", new Object[]{Double.valueOf(eVar.longitude), Double.valueOf(eVar.latitude)});
                if (!bg.mA(eVar.snb)) {
                    format = format + String.format("&from=%s", new Object[]{URLEncoder.encode(eVar.snb)});
                }
            }
            if (bg.mA(str)) {
                if (bg.mA(eVar2.snb)) {
                    str = "地图选点";
                } else {
                    str = eVar2.snb;
                }
            }
            format = format + String.format("&to=%s", new Object[]{URLEncoder.encode(str)});
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(format + "&referer=wx_client"));
            intent.setPackage(com.tencent.mm.pluginsdk.model.a.a.sBX.getPackage());
            context.startActivity(intent);
        }

        protected final String getPackageName() {
            return com.tencent.mm.pluginsdk.model.a.a.sBX.getPackage();
        }
    }

    public final void a(int i, int i2, Intent intent) {
        Context context = (Context) this.smT.get();
        if (!(this.smU == null || context == null)) {
            if (!this.smO) {
                w.e("MicroMsg.OpenMapNavigator", "onActivityResult called without msgId attached...");
            } else if (i != 33) {
                w.e("MicroMsg.OpenMapNavigator", "onActivityResult, mismatched request_code = %d", new Object[]{Integer.valueOf(i)});
                this.smU.mF(this.rYd);
            } else if (i2 == 4097 || i2 == 0) {
                this.smU.wF(this.rYd);
            } else if (i2 == -1) {
                String stringExtra = intent.getStringExtra("selectpkg");
                if (bg.mA(stringExtra)) {
                    w.e("MicroMsg.OpenMapNavigator", "onActivityResult, get null packageName");
                    this.smU.mF(this.rYd);
                } else {
                    f cVar = com.tencent.mm.pluginsdk.model.a.a.sBY.getPackage().equals(stringExtra) ? new c() : com.tencent.mm.pluginsdk.model.a.a.sCa.getPackage().equals(stringExtra) ? new a() : com.tencent.mm.pluginsdk.model.a.a.sBZ.getPackage().equals(stringExtra) ? new g() : com.tencent.mm.pluginsdk.model.a.a.sCb.getPackage().equals(stringExtra) ? new b() : new h();
                    cVar.a(context, this.smQ, this.smR, this.smS);
                    this.smU.rD(this.rYd);
                }
            } else {
                w.e("MicroMsg.OpenMapNavigator", "onActivityResult, not support result_code = %d", new Object[]{Integer.valueOf(i2)});
                this.smU.mF(this.rYd);
            }
        }
        if (this.smO && this.smU != null) {
            this.smU.wG(this.rYd);
        }
        this.smO = false;
        this.smP = com.tencent.mm.pluginsdk.model.a.a.sBX.code;
        this.smQ = null;
        this.smR = null;
        this.smT = null;
        this.smU = null;
        this.smS = null;
        this.smV = null;
        this.smW = null;
        if (!(this.hvP == null || this.smX == null)) {
            this.hvP.c(this.smX);
        }
        this.hvP = null;
        this.smX = null;
        if (this.ngr != null) {
            if (this.smV != null) {
                this.ngr.a(this.smV);
            }
            if (this.smW != null) {
                this.ngr.a(this.smW);
            }
        }
        this.ngr = null;
        this.smV = null;
        this.smW = null;
    }

    j() {
    }

    public final void bzU() {
        Context context = null;
        this.smX = null;
        this.smV = null;
        this.smW = null;
        if (this.smT != null) {
            context = (Context) this.smT.get();
        }
        if (context != null) {
            Intent intent = new Intent(context, AppChooserUI.class);
            ArrayList arrayList = new ArrayList(5);
            arrayList.add(com.tencent.mm.pluginsdk.model.a.a.sBX.getPackage());
            arrayList.add(com.tencent.mm.pluginsdk.model.a.a.sBY.getPackage());
            arrayList.add(com.tencent.mm.pluginsdk.model.a.a.sBZ.getPackage());
            arrayList.add(com.tencent.mm.pluginsdk.model.a.a.sCa.getPackage());
            arrayList.add(com.tencent.mm.pluginsdk.model.a.a.sCb.getPackage());
            intent.putStringArrayListExtra("targetwhitelist", arrayList);
            Parcelable intent2 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%f,%f", new Object[]{Double.valueOf(this.smR.latitude), Double.valueOf(this.smR.longitude)})));
            intent.putExtra("targetintent", intent2);
            Bundle bundle = new Bundle(2);
            bundle.putInt("key_map_app", this.smP);
            bundle.putParcelable("key_target_intent", intent2);
            intent.putExtra("key_recommend_params", bundle);
            intent.putExtra(Columns.TYPE, 2);
            intent.putExtra("title", context.getString(R.l.ewr));
            ((MMActivity) context).a(this, intent, 33);
        }
    }
}
