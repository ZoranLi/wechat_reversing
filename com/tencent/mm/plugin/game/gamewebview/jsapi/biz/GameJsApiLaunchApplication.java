package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.e.a.ie;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebviewRunCgi;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.g.c;
import com.tencent.mm.protocal.c.ago;
import com.tencent.mm.protocal.c.agp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

public final class GameJsApiLaunchApplication extends a {
    public static final int CTRL_BYTE = 260;
    public static final String NAME = "launchApplication";

    private static class LaunchApplicationTask extends GameProcessActivityTask {
        public static final Creator<LaunchApplicationTask> CREATOR = new Creator<LaunchApplicationTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new LaunchApplicationTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LaunchApplicationTask[i];
            }
        };
        public String appId;
        public String extInfo;
        public Bundle fFu;
        public Runnable iMD;
        public String mkB;
        public int showType;
        public boolean success;

        public final void a(Context context, final GameProcessActivityTask.a aVar) {
            if (g.n(context, this.appId)) {
                IMediaObject wXAppExtendObject = new WXAppExtendObject();
                wXAppExtendObject.extInfo = this.extInfo;
                WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                wXMediaMessage.sdkVer = 620757000;
                wXMediaMessage.messageExt = this.extInfo;
                final b ieVar = new ie();
                ieVar.fNI.fNK = wXMediaMessage;
                ieVar.fNI.appId = this.appId;
                ieVar.fNI.showType = this.showType;
                ieVar.fNI.context = context;
                ieVar.fNI.fFu = this.fFu;
                ieVar.fNI.fNL = new c(this) {
                    final /* synthetic */ LaunchApplicationTask mkD;

                    public final void ex(boolean z) {
                        if (ieVar.fNJ.fNM || z) {
                            this.mkD.success = true;
                            aVar.TP();
                        }
                    }
                };
                com.tencent.mm.sdk.b.a.urY.m(ieVar);
                if (!ieVar.fNJ.fNM) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.appId + "://" + this.mkB));
                    w.i("MicroMsg.GameJsApiLaunchApplication", "launchApplication by opensdk failed, try to launch by scheme(%s).", new Object[]{r0});
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    List x = bg.x(context, intent);
                    if (!(x == null || x.isEmpty())) {
                        Object b;
                        if (TextUtils.isEmpty(intent.getPackage()) && x.size() == 1) {
                            b = g.b((ResolveInfo) x.get(0));
                        } else {
                            b = intent.getPackage();
                        }
                        if (!bg.mz(ab.getPackageName()).equals(b)) {
                            g.a(context, intent, null, new c(this) {
                                final /* synthetic */ LaunchApplicationTask mkD;

                                public final void ex(boolean z) {
                                    this.mkD.success = true;
                                    aVar.TP();
                                }
                            }, this.fFu);
                            return;
                        }
                    }
                    this.success = false;
                    aVar.TP();
                    return;
                }
                return;
            }
            w.e("MicroMsg.GameJsApiLaunchApplication", "app is not installed, appid:[%s]", new Object[]{this.appId});
            this.success = false;
            aVar.TP();
        }

        public final void SK() {
            if (this.iMD != null) {
                this.iMD.run();
            }
        }

        public final void f(Parcel parcel) {
            boolean z = true;
            this.showType = parcel.readInt();
            this.appId = parcel.readString();
            this.mkB = parcel.readString();
            this.extInfo = parcel.readString();
            this.fFu = parcel.readBundle();
            if (parcel.readByte() != (byte) 1) {
                z = false;
            }
            this.success = z;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.showType);
            parcel.writeString(this.appId);
            parcel.writeString(this.mkB);
            parcel.writeString(this.extInfo);
            parcel.writeBundle(this.fFu);
            parcel.writeByte((byte) (this.success ? 1 : 0));
        }

        public LaunchApplicationTask(MMActivity mMActivity) {
            super(mMActivity);
        }

        public LaunchApplicationTask(Parcel parcel) {
            f(parcel);
        }
    }

    public final void a(final d dVar, JSONObject jSONObject, final int i) {
        w.i("MicroMsg.GameJsApiLaunchApplication", "invoke");
        if (jSONObject == null) {
            w.e("MicroMsg.GameJsApiLaunchApplication", "data is null");
            dVar.x(i, a.d("launchApplication:fail", null));
            return;
        }
        final Context azK = dVar.azK();
        final String optString = jSONObject.optString("appID");
        final String optString2 = jSONObject.optString("schemeUrl");
        String optString3 = jSONObject.optString("parameter");
        int optInt = jSONObject.optInt("alertType");
        final String optString4 = jSONObject.optString("extInfo");
        w.i("MicroMsg.GameJsApiLaunchApplication", "appid : %s, scheme : %s, extinfo:[%s], parameter : %s", new Object[]{optString, optString2, optString4, optString3});
        if (bg.mA(optString) && bg.mA(optString2)) {
            w.e("MicroMsg.GameJsApiLaunchApplication", "appid and scheme is null or nil");
            dVar.x(i, a.d("launchApplication:fail", null));
            return;
        }
        Object azO = dVar.azO();
        final Bundle bundle = new Bundle();
        try {
            bundle.putString("current_page_url", URLEncoder.encode(dVar.azN(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
        }
        bundle.putString("current_page_appid", azO);
        if (!bg.mA(optString)) {
            com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
            aVar.uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
            aVar.hsl = 1125;
            com.tencent.mm.bd.a com_tencent_mm_protocal_c_ago = new ago();
            com_tencent_mm_protocal_c_ago.fTO = azO;
            com_tencent_mm_protocal_c_ago.tLw = optString;
            com_tencent_mm_protocal_c_ago.scene = dVar.mnb;
            com_tencent_mm_protocal_c_ago.url = dVar.azN();
            com_tencent_mm_protocal_c_ago.tLx = optString2;
            com_tencent_mm_protocal_c_ago.kAF = optInt;
            w.i("MicroMsg.GameJsApiLaunchApplication", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s)", new Object[]{azO, optString, Integer.valueOf(com_tencent_mm_protocal_c_ago.scene), com_tencent_mm_protocal_c_ago.url, com_tencent_mm_protocal_c_ago.tLx, Integer.valueOf(com_tencent_mm_protocal_c_ago.kAF)});
            aVar.hsm = com_tencent_mm_protocal_c_ago;
            aVar.hsn = new agp();
            com.tencent.mm.y.b BE = aVar.BE();
            final d dVar2 = dVar;
            final int i2 = i;
            GameWebviewRunCgi.a(BE, new GameWebviewRunCgi.a(this) {
                final /* synthetic */ GameJsApiLaunchApplication mkv;

                public final void a(int i, int i2, String str, com.tencent.mm.y.b bVar) {
                    w.d("MicroMsg.GameJsApiLaunchApplication", "on RunCgi callback errType:%d errCode:%d msg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    d dVar;
                    int i3;
                    GameJsApiLaunchApplication gameJsApiLaunchApplication;
                    if (i == 0 && i2 == 0) {
                        agp com_tencent_mm_protocal_c_agp = (agp) bVar.hsk.hsr;
                        switch (com_tencent_mm_protocal_c_agp.fIz) {
                            case 0:
                                if (!bg.mA(optString2)) {
                                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(optString2));
                                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                    List x = bg.x(azK, intent);
                                    if (!(x == null || x.isEmpty())) {
                                        Object b;
                                        if (TextUtils.isEmpty(intent.getPackage()) && x.size() == 1) {
                                            b = g.b((ResolveInfo) x.get(0));
                                        } else {
                                            b = intent.getPackage();
                                        }
                                        if (!bg.mz(ab.getPackageName()).equals(b)) {
                                            g.a(azK, intent, null, com_tencent_mm_protocal_c_agp.tLy, new c(this) {
                                                final /* synthetic */ AnonymousClass2 mkz;

                                                {
                                                    this.mkz = r1;
                                                }

                                                public final void ex(boolean z) {
                                                    d dVar = dVar2;
                                                    int i = i2;
                                                    GameJsApiLaunchApplication gameJsApiLaunchApplication = this.mkz.mkv;
                                                    dVar.x(i, a.d("launchApplication:ok", null));
                                                }
                                            }, bundle);
                                            return;
                                        }
                                    }
                                }
                                final LaunchApplicationTask launchApplicationTask = new LaunchApplicationTask(azK);
                                launchApplicationTask.appId = optString;
                                launchApplicationTask.extInfo = optString4;
                                launchApplicationTask.fFu = bundle;
                                launchApplicationTask.showType = com_tencent_mm_protocal_c_agp.tLy == 1 ? 1 : 0;
                                launchApplicationTask.iMD = new Runnable(this) {
                                    final /* synthetic */ AnonymousClass2 mkz;

                                    public final void run() {
                                        w.i("MicroMsg.GameJsApiLaunchApplication", "callback");
                                        if (launchApplicationTask.success) {
                                            d dVar = dVar2;
                                            int i = i2;
                                            GameJsApiLaunchApplication gameJsApiLaunchApplication = this.mkz.mkv;
                                            dVar.x(i, a.d("launchApplication:ok", null));
                                            return;
                                        }
                                        dVar = dVar2;
                                        i = i2;
                                        gameJsApiLaunchApplication = this.mkz.mkv;
                                        dVar.x(i, a.d("launchApplication:fail", null));
                                    }
                                };
                                launchApplicationTask.avz();
                                return;
                            case 2:
                                dVar = dVar2;
                                i3 = i2;
                                gameJsApiLaunchApplication = this.mkv;
                                dVar.x(i3, a.d("launchApplication:fail_check fail forbidden scene", null));
                                return;
                            default:
                                dVar = dVar2;
                                i3 = i2;
                                gameJsApiLaunchApplication = this.mkv;
                                dVar.x(i3, a.d("launchApplication:fail_check fail", null));
                                return;
                        }
                    }
                    dVar = dVar2;
                    i3 = i2;
                    gameJsApiLaunchApplication = this.mkv;
                    dVar.x(i3, a.d("launchApplication:fail_check fail", null));
                }
            });
        } else if (TextUtils.isEmpty(azO)) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(optString2));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            List x = bg.x(azK, intent);
            if (!(x == null || x.isEmpty())) {
                if (TextUtils.isEmpty(intent.getPackage()) && x.size() == 1) {
                    azO = g.b((ResolveInfo) x.get(0));
                } else {
                    azO = intent.getPackage();
                }
                if (!bg.mz(ab.getPackageName()).equals(azO)) {
                    g.a(azK, intent, null, new c(this) {
                        final /* synthetic */ GameJsApiLaunchApplication mkv;

                        public final void ex(boolean z) {
                            d dVar = dVar;
                            int i = i;
                            GameJsApiLaunchApplication gameJsApiLaunchApplication = this.mkv;
                            dVar.x(i, a.d("launchApplication:ok", null));
                        }
                    }, bundle);
                    return;
                }
            }
            dVar.x(i, a.d("launchApplication:fail", null));
        } else {
            dVar.x(i, a.d("launchApplication:fail", null));
        }
    }
}
