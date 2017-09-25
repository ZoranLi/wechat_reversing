package com.tencent.mm.plugin.favorite.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.favorite.c;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.ui.applet.d;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(3)
public class FavOpenApiEntry extends MMActivity {
    private String aJE;
    private String appId;
    private Intent fNO;
    private aj fyI = new aj(new aj.a(this) {
        final /* synthetic */ FavOpenApiEntry lHA;

        {
            this.lHA = r1;
        }

        public final boolean oQ() {
            if (this.lHA.getWindow() != null && this.lHA.getWindow().getDecorView() != null && this.lHA.getWindow().getDecorView().getWindowToken() != null) {
                FavOpenApiEntry.a(this.lHA, this.lHA.lHx.message);
                return false;
            } else if (this.lHA.lHz >= 10) {
                return false;
            } else {
                FavOpenApiEntry.b(this.lHA);
                return true;
            }
        }
    }, true);
    private Bundle lHw;
    private Req lHx;
    private String lHy;
    private int lHz = 0;

    static /* synthetic */ void a(FavOpenApiEntry favOpenApiEntry, WXMediaMessage wXMediaMessage) {
        boolean z = true;
        boolean z2 = false;
        if (wXMediaMessage == null) {
            w.e("MicroMsg.FavOpenApiEntry", "deal fail, WXMediaMessage is null");
            return;
        }
        int type = wXMediaMessage.getType();
        h b;
        switch (type) {
            case 1:
                if (!bg.mA(((WXTextObject) wXMediaMessage.mediaObject).text)) {
                    favOpenApiEntry.appId.equals("wx4310bbd51be7d979");
                    if (d.a(favOpenApiEntry.uSU, wXMediaMessage.description, false, favOpenApiEntry.lHy, favOpenApiEntry.a(wXMediaMessage)) != null) {
                        z2 = true;
                        break;
                    }
                }
                w.e("MicroMsg.FavOpenApiEntry", "dealText null!");
                break;
                break;
            case 2:
                WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
                if (wXImageObject.imageData != null || e.aO(wXImageObject.imagePath)) {
                    if (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) {
                        wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
                        b = (wXImageObject.imageData == null || wXImageObject.imageData.length <= 0) ? d.b(favOpenApiEntry.uSU, wXImageObject.imagePath, false, favOpenApiEntry.lHy, favOpenApiEntry.a(wXMediaMessage)) : d.a(favOpenApiEntry.uSU, wXImageObject.imageData, false, favOpenApiEntry.lHy, favOpenApiEntry.a(wXMediaMessage));
                    } else {
                        b = d.a(favOpenApiEntry.uSU, wXMediaMessage.thumbData, false, favOpenApiEntry.lHy, favOpenApiEntry.a(wXMediaMessage));
                    }
                    if (b != null) {
                        z2 = true;
                        break;
                    } else {
                        w.e("MicroMsg.FavOpenApiEntry", "showImgDialog fail, invalid argument");
                        break;
                    }
                }
                break;
            case 3:
                b = (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) ? d.a(favOpenApiEntry.uSU, R.k.dtg, wXMediaMessage.title, false, favOpenApiEntry.lHy, favOpenApiEntry.a(wXMediaMessage)) : d.a(favOpenApiEntry.uSU, wXMediaMessage.title, false, 2, favOpenApiEntry.lHy, favOpenApiEntry.a(wXMediaMessage));
                if (b == null) {
                    z = false;
                }
                z2 = z;
                break;
            case 4:
                b = (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) ? d.a(favOpenApiEntry.uSU, R.k.dtr, wXMediaMessage.title, false, favOpenApiEntry.lHy, favOpenApiEntry.a(wXMediaMessage)) : d.a(favOpenApiEntry.uSU, wXMediaMessage.title, false, 1, favOpenApiEntry.lHy, favOpenApiEntry.a(wXMediaMessage));
                if (b == null) {
                    z = false;
                }
                z2 = z;
                break;
            case 5:
                if (d.a(favOpenApiEntry.uSU, wXMediaMessage.title, wXMediaMessage.description, false, favOpenApiEntry.lHy, favOpenApiEntry.a(wXMediaMessage)) == null) {
                    z = false;
                }
                z2 = z;
                break;
            case 6:
                b = (wXMediaMessage.thumbData == null || wXMediaMessage.thumbData.length <= 0) ? d.a(favOpenApiEntry.uSU, R.k.dte, wXMediaMessage.title, false, favOpenApiEntry.lHy, favOpenApiEntry.a(wXMediaMessage)) : d.a(favOpenApiEntry.uSU, wXMediaMessage.title, false, 0, favOpenApiEntry.lHy, favOpenApiEntry.a(wXMediaMessage));
                if (b == null) {
                    z = false;
                }
                z2 = z;
                break;
            case 7:
            case 8:
                break;
            default:
                w.e("MicroMsg.FavOpenApiEntry", "unknown type = " + type);
                break;
        }
        if (!z2) {
            w.e("MicroMsg.FavOpenApiEntry", "deal fail, result is false finish()");
            favOpenApiEntry.finish();
        }
    }

    static /* synthetic */ int b(FavOpenApiEntry favOpenApiEntry) {
        int i = favOpenApiEntry.lHz + 1;
        favOpenApiEntry.lHz = i;
        return i;
    }

    static /* synthetic */ void b(FavOpenApiEntry favOpenApiEntry, WXMediaMessage wXMediaMessage) {
        if (wXMediaMessage == null) {
            w.e("MicroMsg.FavOpenApiEntry", "deal fail, WXMediaMessage is null");
            return;
        }
        int type = wXMediaMessage.getType();
        j jVar;
        rm rmVar;
        switch (type) {
            case 1:
                WXTextObject wXTextObject = (WXTextObject) wXMediaMessage.mediaObject;
                if (!bg.mA(wXTextObject.text)) {
                    jVar = new j();
                    jVar.field_type = 1;
                    a(wXMediaMessage, jVar);
                    jVar.field_favProto.OC(wXTextObject.text);
                    favOpenApiEntry.y(jVar);
                    com.tencent.mm.plugin.favorite.c.a.w(jVar);
                    break;
                }
                w.e("MicroMsg.FavOpenApiEntry", "addText null!");
                break;
            case 2:
                WXImageObject wXImageObject = (WXImageObject) wXMediaMessage.mediaObject;
                if (wXImageObject.imageData != null || e.aO(wXImageObject.imagePath)) {
                    jVar = new j();
                    jVar.field_type = 2;
                    a(wXMediaMessage, jVar);
                    favOpenApiEntry.y(jVar);
                    jVar.field_favProto.tzn.add(a(wXMediaMessage, wXImageObject.imagePath, wXImageObject.imageData, jVar.field_type));
                    com.tencent.mm.plugin.favorite.c.a.w(jVar);
                    break;
                }
            case 3:
                WXMusicObject wXMusicObject = (WXMusicObject) wXMediaMessage.mediaObject;
                if (!bg.mA(wXMusicObject.musicDataUrl) || !bg.mA(wXMusicObject.musicUrl) || !bg.mA(wXMusicObject.musicLowBandUrl)) {
                    jVar = new j();
                    jVar.field_type = 7;
                    a(wXMediaMessage, jVar);
                    rmVar = new rm();
                    rmVar.NR(wXMusicObject.musicUrl);
                    rmVar.NT(wXMusicObject.musicLowBandUrl);
                    rmVar.NS(wXMusicObject.musicDataUrl);
                    rmVar.NL(wXMediaMessage.title);
                    rmVar.NM(wXMediaMessage.description);
                    a(wXMediaMessage, rmVar, jVar.field_type);
                    rmVar.jJ(true);
                    rmVar.yb(jVar.field_type);
                    jVar.field_favProto.tzn.add(rmVar);
                    favOpenApiEntry.y(jVar);
                    com.tencent.mm.plugin.favorite.c.a.w(jVar);
                    break;
                }
                w.e("MicroMsg.FavOpenApiEntry", "addMusic, both url null");
                break;
                break;
            case 4:
                WXVideoObject wXVideoObject = (WXVideoObject) wXMediaMessage.mediaObject;
                if (!bg.mA(wXVideoObject.videoLowBandUrl) || !bg.mA(wXVideoObject.videoUrl)) {
                    jVar = new j();
                    jVar.field_type = 4;
                    a(wXMediaMessage, jVar);
                    rmVar = new rm();
                    rmVar.NR(wXVideoObject.videoUrl);
                    rmVar.NT(wXVideoObject.videoLowBandUrl);
                    rmVar.NL(wXMediaMessage.title);
                    rmVar.NM(wXMediaMessage.description);
                    a(wXMediaMessage, rmVar, jVar.field_type);
                    rmVar.jJ(true);
                    rmVar.yb(jVar.field_type);
                    jVar.field_favProto.tzn.add(rmVar);
                    favOpenApiEntry.y(jVar);
                    com.tencent.mm.plugin.favorite.c.a.w(jVar);
                    break;
                }
                w.e("MicroMsg.FavOpenApiEntry", "addVideo, both url null");
                break;
                break;
            case 5:
                WXWebpageObject wXWebpageObject = (WXWebpageObject) wXMediaMessage.mediaObject;
                if (!bg.mA(wXWebpageObject.webpageUrl)) {
                    jVar = new j();
                    jVar.field_sessionId = favOpenApiEntry.getIntent().getStringExtra("reportSessionId");
                    jVar.field_type = 5;
                    a(wXMediaMessage, jVar);
                    favOpenApiEntry.y(jVar);
                    jVar.field_favProto.tzl.OK(wXWebpageObject.webpageUrl);
                    if (wXMediaMessage.thumbData != null) {
                        rm rmVar2 = new rm();
                        rmVar2.NL(wXMediaMessage.title);
                        rmVar2.NM(wXMediaMessage.description);
                        a(wXMediaMessage, rmVar2, jVar.field_type);
                        rmVar2.jJ(true);
                        rmVar2.yb(jVar.field_type);
                        jVar.field_favProto.tzn.add(rmVar2);
                    }
                    com.tencent.mm.plugin.favorite.c.a.w(jVar);
                    break;
                }
                w.e("MicroMsg.FavOpenApiEntry", "addUrl null!");
                break;
            case 6:
                WXFileObject wXFileObject = (WXFileObject) wXMediaMessage.mediaObject;
                if (wXFileObject.fileData == null && !e.aO(wXFileObject.filePath)) {
                    w.e("MicroMsg.FavOpenApiEntry", "addFile data null");
                    break;
                }
                jVar = new j();
                jVar.field_type = 8;
                a(wXMediaMessage, jVar);
                favOpenApiEntry.y(jVar);
                jVar.field_favProto.tzn.add(a(wXMediaMessage, wXFileObject.filePath, wXFileObject.fileData, jVar.field_type));
                com.tencent.mm.plugin.favorite.c.a.w(jVar);
                break;
                break;
            default:
                w.e("MicroMsg.FavOpenApiEntry", "unsupport type = " + type);
                break;
        }
        favOpenApiEntry.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.fNO == null) {
            this.fNO = getIntent();
        }
        this.lHw = this.fNO.getExtras();
        this.appId = this.lHw.getString("SendAppMessageWrapper_AppId");
        if (this.appId == null) {
            this.appId = Uri.parse(this.lHw.getString(ConstantsAPI.CONTENT)).getQueryParameter("appid");
        }
        this.lHx = new Req(this.lHw);
        if (this.lHx.scene != 2) {
            w.e("MicroMsg.FavOpenApiEntry", "scene not WXSceneFavorite!");
            finish();
            return;
        }
        this.lHy = getString(R.l.ehy);
        String appName = c.getAppName(this, this.appId);
        this.aJE = getString(R.l.dXn, new Object[]{appName});
        this.fyI.v(100, 100);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.fNO = intent;
    }

    protected void onResume() {
        super.onResume();
    }

    private static void a(WXMediaMessage wXMediaMessage, j jVar) {
        jVar.field_sourceType = 4;
        jVar.field_favProto.OB(wXMediaMessage.title);
        jVar.field_favProto.OC(wXMediaMessage.description);
    }

    private void y(j jVar) {
        rw rwVar = new rw();
        rwVar.OJ(this.appId);
        rwVar.yj(4);
        rwVar.OD(m.xL());
        rwVar.OE(m.xL());
        jVar.field_fromUser = rwVar.fOu;
        jVar.field_toUser = rwVar.toUser;
        jVar.field_favProto.a(rwVar);
    }

    private static rm a(WXMediaMessage wXMediaMessage, String str, byte[] bArr, int i) {
        rm rmVar = new rm();
        rmVar.NL(wXMediaMessage.title);
        rmVar.NM(wXMediaMessage.description);
        rmVar.yb(i);
        if (str != null) {
            rmVar.NZ(str);
            rmVar.NV(e.aQ(str));
        } else {
            String n = g.n(bArr);
            if (bArr.length >= 256) {
                rmVar.NX(n);
            } else {
                Object obj = new byte[256];
                System.arraycopy(bArr, 0, obj, 0, 256);
                rmVar.NX(g.n(obj));
            }
            rmVar.NW(n);
            rmVar.ej((long) bArr.length);
            rmVar.NY(x.aS(rmVar.toString(), i));
            e.e(x.g(rmVar), bArr);
        }
        a(wXMediaMessage, rmVar, i);
        return rmVar;
    }

    private static void a(WXMediaMessage wXMediaMessage, rm rmVar, int i) {
        if (wXMediaMessage.thumbData != null) {
            String n = g.n(wXMediaMessage.thumbData);
            rmVar.Ob(n);
            if (wXMediaMessage.thumbData.length >= 256) {
                rmVar.Oc(n);
            } else {
                Object obj = new byte[256];
                System.arraycopy(wXMediaMessage.thumbData, 0, obj, 0, 256);
                rmVar.Oc(g.n(obj));
            }
            if (bg.mA(rmVar.lKv)) {
                rmVar.NY(x.aS(rmVar.toString(), i));
            }
            rmVar.ek((long) wXMediaMessage.thumbData.length);
            e.e(x.h(rmVar), wXMediaMessage.thumbData);
            return;
        }
        rmVar.jK(true);
    }

    private k.a a(final WXMediaMessage wXMediaMessage) {
        return new k.a(this) {
            final /* synthetic */ FavOpenApiEntry lHA;

            public final void a(boolean z, String str, int i) {
                if (z) {
                    FavOpenApiEntry.b(this.lHA, wXMediaMessage);
                    ReportUtil.a(this.lHA, ReportUtil.b(this.lHA.getIntent().getExtras(), 0));
                    return;
                }
                this.lHA.finish();
                ReportUtil.a(this.lHA, ReportUtil.b(this.lHA.getIntent().getExtras(), -2));
            }
        };
    }

    protected void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return -1;
    }
}
