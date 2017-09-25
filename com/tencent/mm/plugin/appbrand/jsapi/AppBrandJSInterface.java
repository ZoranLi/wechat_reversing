package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Handler;
import android.os.HandlerThread;
import android.webkit.JavascriptInterface;
import com.tencent.mm.plugin.appbrand.jsapi.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.a.h;
import com.tencent.mm.plugin.appbrand.jsapi.a.i;
import com.tencent.mm.plugin.appbrand.jsapi.a.n;
import com.tencent.mm.plugin.appbrand.jsapi.a.o;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.plugin.appbrand.jsapi.bio.soter.JsApiCheckIsSupportSoterAuthentication;
import com.tencent.mm.plugin.appbrand.jsapi.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.f;
import com.tencent.mm.plugin.appbrand.jsapi.f.j;
import com.tencent.mm.plugin.appbrand.jsapi.f.k;
import com.tencent.mm.plugin.appbrand.jsapi.f.l;
import com.tencent.mm.plugin.appbrand.jsapi.file.JsApiOpenDocument;
import com.tencent.mm.plugin.appbrand.jsapi.file.c;
import com.tencent.mm.plugin.appbrand.jsapi.file.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.e;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class AppBrandJSInterface {
    public boolean aaI;
    public Handler iHc;
    public c iKF;
    private Map<String, d> iKG;
    private int iKH = 0;
    private ConcurrentHashMap<Integer, String> iKI = new ConcurrentHashMap();

    public AppBrandJSInterface(m mVar) {
        this.iKF = mVar;
        this.aaI = true;
        f.iKT = new HashMap();
        f.a(new t());
        f.a(new aj());
        f.a(new cd());
        f.a(new u());
        f.a(new am());
        f.a(new ce());
        f.a(new b());
        f.a(new k());
        f.a(new a());
        f.a(new JsApiLogin());
        f.a(new JsApiAuthorize());
        f.a(new JsApiOperateWXData());
        f.a(new cb());
        f.a(new az());
        f.a(new bk());
        f.a(new ax());
        f.a(new JsApiChooseImage());
        f.a(new l());
        f.a(new f());
        f.a(new bi());
        f.a(new JsApiChooseVideo());
        f.a(new JsApiStartRecordVoice());
        f.a(new JsApiStopRecordVoice());
        f.a(new JsApiStartPlayVoice());
        f.a(new JsApiPausePlayVoice());
        f.a(new JsApiStopPlayVoice());
        f.a(new JsApiGetLocation());
        f.a(new bf());
        f.a(new af());
        f.a(new JsApiGetMusicPlayerState());
        f.a(new JsApiOperateMusicPlayer());
        f.a(new JsApiScanCode());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.g.b());
        f.a(new bb());
        f.a(new bq());
        f.a(new e());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.g.a());
        f.a(new j());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.file.e());
        f.a(new d());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.file.b());
        f.a(new c());
        f.a(new q());
        f.a(new ci());
        f.a(new cg());
        f.a(new ap());
        f.a(new x());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.share.b());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.share.d());
        f.a(new an());
        f.a(new br());
        f.a(new bt());
        f.a(new bs());
        f.a(new cl());
        f.a(new bz());
        f.a(new ah());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.d.b());
        f.a(new y());
        f.a(new z());
        f.a(new bn());
        f.a(new bo());
        f.a(new JsApiOpenDocument());
        f.a(new o());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.i.c());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.i.b());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.i.d());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.i.a());
        f.a(new ab());
        f.a(new av());
        f.a(new ak());
        f.a(new al());
        f.a(new s());
        f.a(new ae());
        f.a(new JsApiRefreshSession());
        f.a(new ck());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.map.f());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.map.k());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.map.m());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.g.c());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.share.e());
        f.a(new m());
        f.a(new bc());
        f.a(new JsApiMakeVoIPCall());
        f.a(new ac());
        f.a(new bw());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.a.k());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.a.c());
        f.a(new g());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.a.m());
        f.a(new n());
        f.a(new h());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.a.d());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.a.b());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.a.f());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.a.e());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.a.l());
        f.a(new o());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.a.j());
        f.a(new i());
        f.a(new JsApiLaunchMiniProgram());
        f.a(new bj());
        f.a(new JsApiChooseWeChatContact());
        f.a(new JsApiChooseMedia());
        f.a(new JsApiUploadEncryptedFileToCDN());
        f.a(new aa());
        f.a(new bg());
        f.a(new cp());
        f.a(new JsApiGetBackgroundAudioState());
        f.a(new JsApiSetBackgroundAudioState());
        f.a(new JsApiOperateBackgroundAudio());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.share.f());
        f.a(new aq());
        f.a(new bh());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.g.d());
        f.a(new n());
        f.a(new JsApiOpenWeRunSetting());
        f.a(new ai());
        f.a(new cc());
        f.a(new cr());
        f.a(new cs());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.share.h());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.share.g());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.c.b());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.c.c());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.c.d());
        f.a(new JsApiCheckIsSupportFaceDetect());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.bio.face.b());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.bio.face.c());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.video.b());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.e.b());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.e.c());
        f.a(new JsApiGetSetting());
        f.a(new bd());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.share.c());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.j.d());
        f.a(new by());
        f.a(new p());
        f.a(new aw());
        f.a(new ba());
        f.a(new ay());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.map.h());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.map.g());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.op_report.b());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.j.b());
        f.a(new bx());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.j.c());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.file.a());
        f.a(new cm());
        f.a(new ca());
        f.a(new JsApiCheckIsSupportSoterAuthentication());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.bio.soter.b());
        f.a(new r());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.f.d());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.f.h());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.f.c());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.f.g());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.f.e());
        f.a(new com.tencent.mm.plugin.appbrand.jsapi.f.i());
        f.a(new ch());
        f.a(new JsApiNavigateBackApplication());
        this.iKG = f.iKT;
        SQ();
    }

    public AppBrandJSInterface(com.tencent.mm.plugin.appbrand.g.m mVar) {
        this.iKF = mVar;
        this.aaI = true;
        f.iKU = new HashMap();
        f.b(new be());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.map.j());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.map.l());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.map.n());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.d.e());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.d.b());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.d.f());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.d.c());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.d.g());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.d.d());
        f.b(new ar());
        f.b(new bq());
        f.b(new br());
        f.b(new bt());
        f.b(new bs());
        f.b(new bu());
        f.b(new cl());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.h.d());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.h.f());
        f.b(new ad());
        f.b(new ah());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.video.a());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.video.d());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.video.c());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.video.b());
        f.b(new x());
        f.b(new as());
        f.b(new bl());
        f.b(new cn());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.map.b());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.map.e());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.map.d());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.map.i());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.map.c());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.contact.a());
        f.b(new w());
        f.b(new ao());
        f.b(new cf());
        f.b(new v());
        f.b(new bv());
        f.b(new cp());
        f.b(new cs());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.b.b());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.b.d());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.b.c());
        f.b(new ag());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.h.e());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.h.b());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.h.g());
        f.b(new cm());
        f.b(new au());
        f.b(new cq());
        f.b(new bp());
        f.b(new at());
        f.b(new co());
        f.b(new bm());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.l.c());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.l.e());
        f.b(new com.tencent.mm.plugin.appbrand.jsapi.l.d());
        this.iKG = f.iKU;
        SQ();
    }

    private void SQ() {
        HandlerThread handlerThread = new HandlerThread("AppBrandAsyncJSThread");
        handlerThread.start();
        this.iHc = new Handler(handlerThread.getLooper());
    }

    public final void Po() {
        this.iHc.getLooper().quit();
        this.aaI = false;
        this.iKI.clear();
    }

    @JavascriptInterface
    public void publishHandler(final String str, final String str2, final String str3) {
        int i = 0;
        this.iHc.post(new Runnable(this) {
            final /* synthetic */ AppBrandJSInterface iKL;

            public final void run() {
                this.iKL.iKF.a(str, str2, AppBrandJSInterface.pc(str3));
            }
        });
        String str4 = "MicroMsg.AppBrandJSInterface";
        String str5 = "publishHandler, event: %s, data size: %d";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (str2 != null) {
            i = str2.length();
        }
        objArr[1] = Integer.valueOf(i);
        w.d(str4, str5, objArr);
    }

    @JavascriptInterface
    public String invokeHandler(String str, String str2, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        String str3 = "";
        try {
            d dVar = (d) this.iKG.get(str);
            if (dVar == null) {
                this.iKF.x(i, aO(str, "fail:not supported"));
                return "fail:not supported";
            }
            String a;
            int i2;
            boolean z = dVar instanceof k;
            g gVar = this.iKF.iKE;
            c cVar = this.iKF;
            com.tencent.mm.plugin.appbrand.g.j jVar = this.iKF.PI().iwr;
            String VD = (jVar == null || jVar.VN() == null) ? "" : jVar.VN().VD();
            gVar.iKV.put(Integer.valueOf(i), new a(cVar, dVar, str2, System.currentTimeMillis(), VD));
            if (z) {
                a = a(str, str2, i, true);
            } else {
                final String str4 = str;
                final String str5 = str2;
                final int i3 = i;
                this.iHc.post(new Runnable(this) {
                    final /* synthetic */ AppBrandJSInterface iKL;

                    public final void run() {
                        if (this.iKL.aaI) {
                            this.iKL.a(str4, str5, i3, false);
                        }
                    }
                });
                a = str3;
            }
            String str6 = "MicroMsg.AppBrandJSInterface";
            String str7 = "invokeHandler, api: %s, data size: %d, sync: %b, time: %d";
            Object[] objArr = new Object[4];
            objArr[0] = str;
            if (str2 == null) {
                i2 = 0;
            } else {
                i2 = str2.length();
            }
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = Boolean.valueOf(z);
            objArr[3] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
            w.i(str6, str7, objArr);
            return a;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.AppBrandJSInterface", e, " Invoke Error %s", new Object[]{str});
            throw e;
        }
    }

    @JavascriptInterface
    public String retrieveEvent(int i) {
        String str = (String) this.iKI.get(Integer.valueOf(i));
        this.iKI.remove(Integer.valueOf(i));
        return str == null ? "" : str;
    }

    @JavascriptInterface
    public boolean isDebugPackage() {
        return com.tencent.mm.sdk.a.b.bIu();
    }

    public final String a(String str, String str2, int i, boolean z) {
        String aO;
        final d dVar = (d) this.iKG.get(str);
        if (dVar == null) {
            aO = aO(str, "fail:not supported");
        } else {
            final String str3 = str;
            final String str4 = str2;
            final int i2 = i;
            final boolean z2 = z;
            com.tencent.mm.plugin.appbrand.permission.c.a a = com.tencent.mm.plugin.appbrand.permission.c.e(this.iKF.PI()).a(this.iKF, dVar, new com.tencent.mm.plugin.appbrand.permission.c.b(this) {
                final /* synthetic */ AppBrandJSInterface iKL;

                public final void a(com.tencent.mm.plugin.appbrand.permission.c.a aVar) {
                    if (this.iKL.iKF != null && this.iKL.iKF.isRunning()) {
                        if (aVar.code == 1) {
                            this.iKL.iHc.post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass3 iKR;

                                {
                                    this.iKR = r1;
                                }

                                public final void run() {
                                    if (this.iKR.iKL.iKF != null && this.iKR.iKL.iKF.isRunning()) {
                                        this.iKR.iKL.a(str3, str4, i2, z2);
                                    }
                                }
                            });
                        } else {
                            this.iKL.iKF.x(i2, dVar.d(aVar.fEr, null));
                        }
                    }
                }
            });
            if (3 == a.code) {
                return "";
            }
            if (a.code != 1) {
                aO = dVar.d(a.fEr, null);
            } else {
                JSONObject pb = pb(str2);
                if (pb == null) {
                    aO = dVar.d("fail:invalid data", null);
                } else if (z) {
                    k kVar = (k) dVar;
                    c cVar = this.iKF;
                    aO = cVar instanceof m ? kVar.a((m) cVar, pb) : cVar instanceof com.tencent.mm.plugin.appbrand.g.m ? kVar.a((com.tencent.mm.plugin.appbrand.g.m) cVar) : "";
                } else {
                    ((a) dVar).a(this.iKF, pb, i);
                    aO = null;
                }
            }
        }
        if (aO != null) {
            this.iKF.iKE.y(i, aO);
        }
        if (!z) {
            if (aO != null) {
                this.iKF.x(i, aO);
            }
            return "";
        } else if (bg.mA(aO)) {
            return "{}";
        } else {
            return aO;
        }
    }

    private static JSONObject pb(String str) {
        try {
            if (bg.mA(str)) {
                str = "{}";
            }
            return new JSONObject(str);
        } catch (Exception e) {
            w.e("MicroMsg.AppBrandJSInterface", e.getMessage());
            return null;
        }
    }

    private static String aO(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("errMsg", str + ":" + str2);
        return new JSONObject(hashMap).toString();
    }

    public static int[] pc(String str) {
        int[] iArr;
        Exception e;
        int[] iArr2 = new int[0];
        try {
            JSONArray jSONArray = new JSONArray(str);
            iArr = new int[jSONArray.length()];
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    iArr[i] = jSONArray.getInt(i);
                    i++;
                } catch (Exception e2) {
                    e = e2;
                }
            }
        } catch (Exception e3) {
            Exception exception = e3;
            iArr = iArr2;
            e = exception;
            w.e("MicroMsg.AppBrandJSInterface", e.getMessage());
            return iArr;
        }
        return iArr;
    }
}
