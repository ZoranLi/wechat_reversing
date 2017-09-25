package com.tencent.mm.plugin.ext.openapi.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.ep;
import com.tencent.mm.e.a.es;
import com.tencent.mm.e.a.fa;
import com.tencent.mm.e.a.pv;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvoice.i;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetLocation;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStopPlayVoice;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.v;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.c;
import com.tencent.mm.pluginsdk.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.bd;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.x.n;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;

public class ExtControlProviderOpenApi extends ExtContentProviderBase {
    private static final String[] lql = new String[]{"retCode", "selfId"};
    private static final String[] lqm = new String[]{"retCode", "sportConfig"};
    private static final String[] lqn = new String[]{"openid", "avatar"};
    private static final String[] lqo = new String[]{"voiceType", "sampleRateInHz", "channelConfig", "audioFormat", DownloadInfoColumns.FILEPATH};
    private static final String[] lqp = new String[]{"ssid", "macAddress", "isSupportWechat", "name"};
    private Context context;
    private ae handler;
    private String[] lqq = null;
    private int lqr = -1;

    public ExtControlProviderOpenApi(String[] strArr, int i, Context context) {
        this.lqq = strArr;
        this.lqr = i;
        this.context = context;
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        this.handler = new ae();
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, final String[] strArr2, String str2) {
        w.i("MicroMsg.ExtControlProviderOpenApi", "query(), ApiId = %s", Integer.valueOf(this.lqr));
        a(uri, this.context, this.lqr, this.lqq);
        String str3 = this.lqz;
        if (uri == null) {
            w.e("MicroMsg.ExtControlProviderOpenApi", "uri == null return code = 5");
            bS(3, 5);
            return ExtContentProviderBase.me(5);
        } else if (bg.mA(this.lqz)) {
            w.e("MicroMsg.ExtControlProviderOpenApi", "AppID == null return code = 7");
            bS(3, 7);
            return ExtContentProviderBase.me(7);
        } else if (bg.mA(aqX())) {
            w.e("MicroMsg.ExtControlProviderOpenApi", "PkgName == null return code = 6");
            bS(3, 6);
            return ExtContentProviderBase.me(6);
        } else if (acK()) {
            int aqY = aqY();
            if (aqY != 1) {
                w.e("MicroMsg.ExtControlProviderOpenApi", "invalid appid ! return code = " + aqY);
                bS(2, aqY);
                return ExtContentProviderBase.me(aqY);
            }
            String str4;
            Intent intent;
            switch (this.lqr) {
                case 22:
                    return f(uri.getQueryParameter("op"), uri.getQueryParameter("scene"), uri.getQueryParameter("msgType"), uri.getQueryParameter("msgState"));
                case 23:
                    return i(strArr2);
                case 25:
                    return j(strArr2);
                case 34:
                    w.i("MicroMsg.ExtControlProviderOpenApi", "sendSight ");
                    if (strArr2 == null || strArr2.length <= 0 || strArr2[0].length() <= 0) {
                        String str5 = "MicroMsg.ExtControlProviderOpenApi";
                        str4 = "sendSight wrong args,args == null:%s";
                        Object[] objArr = new Object[1];
                        objArr[0] = Boolean.valueOf(strArr2 == null);
                        w.e(str5, str4, objArr);
                        bS(3, 3401);
                        return ExtContentProviderBase.me(3401);
                    }
                    Object obj;
                    str3 = strArr2[0];
                    if (bg.mA(str3) || !e.aO(str3)) {
                        obj = null;
                    } else {
                        c cVar = new c();
                        obj = SightVideoJNI.isSightOk(str3, cVar.ptH, cVar.ptI, cVar.ptJ, cVar.ptL, cVar.ptK, cVar.ptK.length) == 0 ? 1 : null;
                    }
                    if (obj == null) {
                        w.e("MicroMsg.ExtControlProviderOpenApi", "isSightOk wrong args");
                        bS(3, 3402);
                        return ExtContentProviderBase.me(3402);
                    }
                    intent = new Intent();
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    intent.addFlags(67108864);
                    intent.putExtra("sight_local_path", str3);
                    d.a(this.context, ".ui.transmit.SightForwardUI", intent);
                    z(12, 0, 1);
                    return ExtContentProviderBase.me(1);
                case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
                    w.i("MicroMsg.ExtControlProviderOpenApi", "hy: start redirect to chatting by phone num");
                    if (strArr2 == null || strArr2.length <= 0 || bg.mA(strArr2[0])) {
                        w.e("MicroMsg.ExtControlProviderOpenApi", "hy: args error: no phone num or phone num is null or nil");
                        bS(3, 3201);
                        return ExtContentProviderBase.me(3201);
                    }
                    w.i("MicroMsg.ExtControlProviderOpenApi", "hy: start searching for phone num: %s", strArr2[0]);
                    int aqR = new com.tencent.mm.plugin.ext.b.c(this.context, str3).aqR();
                    w.i("MicroMsg.ExtControlProviderOpenApi", " ret =  ", Integer.valueOf(aqR));
                    if (aqR != -1) {
                        z(14, 0, aqR);
                        aqR = 0;
                    } else {
                        z(15, 0, aqR);
                    }
                    return ExtContentProviderBase.me(aqR);
                case 36:
                    w.i("MicroMsg.ExtControlProviderOpenApi", "hy: start redirect to wechat out by phone num");
                    if (strArr2 == null || strArr2.length < 3) {
                        w.e("MicroMsg.ExtControlProviderOpenApi", "hy: wechat out args error: args length error");
                        bS(3, 3301);
                        return ExtContentProviderBase.me(3301);
                    }
                    str3 = strArr2[0];
                    aqY = bg.getInt(strArr2[1], -1);
                    str4 = strArr2[2];
                    w.i("MicroMsg.ExtControlProviderOpenApi", "hy: start wechat out: contactid: %s, countrycode: %s,  phone num: %s", str3, Integer.valueOf(aqY), str4);
                    if (bg.mA(str3) || aqY < 0 || bg.mA(str4)) {
                        w.i("MicroMsg.ExtControlProviderOpenApi", "hy: param err");
                        bS(3, 3302);
                        return ExtContentProviderBase.me(3302);
                    }
                    b pvVar = new pv();
                    pvVar.fWS.fWT = str3;
                    pvVar.fWS.fWU = aqY;
                    pvVar.fWS.fWV = str4;
                    pvVar.fWS.aIO = a.g(str3, this.context);
                    com.tencent.mm.sdk.b.a.urY.m(pvVar);
                    z(16, 0, 1);
                    return ExtContentProviderBase.me(1);
                case JsApiGetLocation.CTRL_INDEX /*37*/:
                    w.d("MicroMsg.ExtControlProviderOpenApi", "getWifiList");
                    this.handler = new ae(Looper.getMainLooper());
                    MatrixCursor matrixCursor = (MatrixCursor) new bb<MatrixCursor>(this) {
                        final /* synthetic */ ExtControlProviderOpenApi lqs;

                        protected final /* synthetic */ Object run() {
                            return aqV();
                        }

                        private MatrixCursor aqV() {
                            try {
                                w.d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
                                final b esVar = new es();
                                esVar.fIR.fIT = strArr2;
                                esVar.nFq = new Runnable(this) {
                                    final /* synthetic */ AnonymousClass1 lqu;

                                    public final void run() {
                                        w.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList run");
                                        if (esVar != null && esVar.fIS != null && esVar.fIS.fIy != 0) {
                                            w.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList return cursor");
                                            this.lqu.bv(esVar.fIS.fIU);
                                        }
                                    }
                                };
                                if (!com.tencent.mm.sdk.b.a.urY.m(esVar)) {
                                    w.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList publish getWifiListEvent fail");
                                    bv(ExtContentProviderBase.me(8));
                                }
                            } catch (Exception e) {
                                w.e("MicroMsg.ExtControlProviderOpenApi", "exception in getWifiList syncTaskCur.", e);
                                bv(ExtContentProviderBase.me(12));
                            }
                            return null;
                        }
                    }.b(this.handler);
                    if (matrixCursor == null) {
                        z(19, 4, 14);
                        return ExtContentProviderBase.me(14);
                    }
                    z(18, 0, 1);
                    w.i("MicroMsg.ExtControlProviderOpenApi", "returnMatrix syncTaskCur");
                    return matrixCursor;
                case 38:
                    w.d("MicroMsg.ExtControlProviderOpenApi", "connectWifi");
                    this.handler = new ae(Looper.getMainLooper());
                    Integer num = (Integer) new bb<Integer>(this) {
                        final /* synthetic */ ExtControlProviderOpenApi lqs;

                        protected final /* synthetic */ Object run() {
                            return Mz();
                        }

                        private Integer Mz() {
                            try {
                                w.d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
                                final b epVar = new ep();
                                epVar.fIv.version = bg.getInt(strArr2[0], 0);
                                epVar.fIv.ssid = strArr2[1];
                                epVar.fIv.bssid = strArr2[2];
                                epVar.fIv.fIx = bg.getInt(strArr2[3], 0);
                                epVar.nFq = new Runnable(this) {
                                    final /* synthetic */ AnonymousClass2 lqw;

                                    public final void run() {
                                        w.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi run");
                                        if (epVar != null && epVar.fIw != null && epVar.fIw.fIy != 0) {
                                            w.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi errcode = %s,errmsg = %s", Integer.valueOf(epVar.fIw.fIz), epVar.fIw.fIA);
                                            this.lqw.bv(Integer.valueOf(epVar.fIw.fIz));
                                        }
                                    }
                                };
                                if (!com.tencent.mm.sdk.b.a.urY.m(epVar)) {
                                    w.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi publish getWifiListEvent fail");
                                    bv(Integer.valueOf(8));
                                }
                            } catch (Exception e) {
                                w.e("MicroMsg.ExtControlProviderOpenApi", "exception in connectWifi syncTaskInt.", e);
                                bv(Integer.valueOf(12));
                            }
                            return Integer.valueOf(0);
                        }
                    }.b(this.handler);
                    if (num == null) {
                        z(21, 4, 14);
                        return ExtContentProviderBase.me(14);
                    }
                    z(20, 0, num.intValue());
                    return ExtContentProviderBase.me(num.intValue());
                case 40:
                    w.i("MicroMsg.ExtControlProviderOpenApi", "setSportStep start");
                    if (strArr2 == null || strArr2.length < 3) {
                        w.e("MicroMsg.ExtControlProviderOpenApi", "args error: args length error");
                        z(23, 3, 2);
                        return ExtContentProviderBase.me(2);
                    }
                    long j = bg.getLong(strArr2[0], -1);
                    long j2 = bg.getLong(strArr2[1], -1);
                    long j3 = bg.getLong(strArr2[2], -1);
                    w.i("MicroMsg.ExtControlProviderOpenApi", "setSportStep: timestampe: %s, stepcount: %s,  version: %s", Long.valueOf(j2), Long.valueOf(j), Long.valueOf(j3));
                    if (j2 < 0 || j < 0 || j3 < 0) {
                        w.i("MicroMsg.ExtControlProviderOpenApi", "param err");
                        z(23, 3, 2);
                        return ExtContentProviderBase.me(2);
                    }
                    aqS();
                    b faVar = new fa();
                    faVar.fJp.action = 2;
                    faVar.fJp.fJr = j2;
                    faVar.fJp.fJs = j;
                    faVar.fJp.fJt = j3;
                    if (com.tencent.mm.sdk.b.a.urY.m(faVar) && faVar.fJq.fJv) {
                        z(22, 0, faVar.fJq.fJw);
                        return ExtContentProviderBase.me(faVar.fJq.fJw);
                    }
                    z(23, 4, 8);
                    return ExtContentProviderBase.me(8);
                case v.CTRL_BYTE /*41*/:
                    w.i("MicroMsg.ExtControlProviderOpenApi", "getSportConfig start");
                    aqS();
                    b faVar2 = new fa();
                    faVar2.fJp.action = 3;
                    if (com.tencent.mm.sdk.b.a.urY.m(faVar2) && faVar2.fJq.fJv) {
                        str4 = faVar2.fJq.fJu;
                        Cursor matrixCursor2 = new MatrixCursor(lqm);
                        matrixCursor2.addRow(new Object[]{Integer.valueOf(faVar2.fJq.fJw), bg.mz(str4)});
                        z(22, 0, faVar2.fJq.fJw);
                        w.i("MicroMsg.ExtControlProviderOpenApi", "return  code =%s ", Integer.valueOf(faVar2.fJq.fJw));
                        return matrixCursor2;
                    }
                    z(23, 4, 8);
                    return ExtContentProviderBase.me(8);
                case 42:
                    intent = new Intent();
                    intent.addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
                    intent.putExtra("key_from_scene", 4);
                    if (strArr2 == null || strArr2.length <= 0 || strArr2[0].length() <= 0) {
                        w.i("MicroMsg.ExtControlProviderOpenApi", "openOffline appid:%s", str3);
                    } else {
                        w.i("MicroMsg.ExtControlProviderOpenApi", "openOffline business_attach:%s,appid:%s", strArr2[0], str3);
                        intent.putExtra("key_business_attach", strArr2[0]);
                    }
                    intent.putExtra("key_appid", str3);
                    d.b(this.context, "offline", ".ui.WalletOfflineEntranceUI", intent);
                    g.oUh.i(12097, Integer.valueOf(9), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
                    z(24, 0, 1);
                    return ExtContentProviderBase.me(1);
                case JsApiGetMusicPlayerState.CTRL_INDEX /*46*/:
                    w.d("MicroMsg.ExtControlProviderOpenApi", "openClean appid:%s", str3);
                    ap.yY();
                    if (com.tencent.mm.u.c.isSDCardAvailable()) {
                        intent = new Intent();
                        intent.putExtra("key_from_openapi", true);
                        intent.putExtra("key_openapi_appid", str3);
                        d.b(this.context, "clean", ".ui.CleanUI", intent);
                        z(26, 0, 1);
                        return ExtContentProviderBase.me(1);
                    }
                    z(27, 5, 4);
                    return ExtContentProviderBase.me(4101);
                default:
                    bS(3, 15);
                    return null;
            }
        } else {
            w.e("MicroMsg.ExtControlProviderOpenApi", "not login return code = 3");
            bS(1, 3);
            return ExtContentProviderBase.me(3);
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private Cursor f(String str, String str2, String str3, String str4) {
        int i = -1;
        w.i("MicroMsg.ExtControlProviderOpenApi", "registerMsgReceiver, op = %s", str);
        if (this.context == null) {
            w.e("MicroMsg.ExtControlProviderOpenApi", "context == null return code = 2001");
            bS(4, MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN);
            return ExtContentProviderBase.me(MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN);
        } else if (bg.mA(str)) {
            w.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, op is null return code = 2002");
            bS(3, MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK);
            return ExtContentProviderBase.me(MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK);
        } else {
            try {
                i = bg.getInt(str, -1);
            } catch (Exception e) {
            }
            if (i == 1) {
                return G(str2, str3, str4);
            }
            if (i == 2) {
                w.d("MicroMsg.ExtControlProviderOpenApi", "doUnRegisterMsgListener");
                if (com.tencent.mm.plugin.ext.b.aqL().RP(this.lqz) == null) {
                    w.w("MicroMsg.ExtControlProviderOpenApi", "This app never been registered, appId = %s, pkg = %s", this.lqz, aqX());
                    return ExtContentProviderBase.me(2007);
                }
                boolean z;
                ax aqL = com.tencent.mm.plugin.ext.b.aqL();
                String str5 = this.lqz;
                if (str5 == null || str5.length() <= 0) {
                    z = false;
                } else {
                    z = aqL.gUz.delete("OpenMsgListener", "appId=?", new String[]{bg.my(str5)}) > 0;
                }
                w.i("MicroMsg.ExtControlProviderOpenApi", "doUnRegisterMsgListener ret = %s, appId = %s, pkg = %s", Boolean.valueOf(z), this.lqz, aqX());
                if (!z) {
                    return ExtContentProviderBase.me(2008);
                }
                z(0, 0, 1);
                return ExtContentProviderBase.me(1);
            }
            w.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, no such op, %s", Integer.valueOf(i));
            bS(3, MMBitmapFactory.ERROR_ILLEGAL_IDATA_CHUNK);
            return ExtContentProviderBase.me(MMBitmapFactory.ERROR_ILLEGAL_IDATA_CHUNK);
        }
    }

    private Cursor G(String str, String str2, String str3) {
        Exception exception;
        w.i("MicroMsg.ExtControlProviderOpenApi", "doRegisterMsgListener");
        if (bg.mA(str) || bg.mA(str2) || bg.mA(str3)) {
            w.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, scene = %s, msgType = %s, msgState = %s", str, str2, str3);
            bS(3, 2004);
            return ExtContentProviderBase.me(2004);
        }
        MatrixCursor matrixCursor = null;
        try {
            int parseInt = Integer.parseInt(str3);
            int parseInt2 = Integer.parseInt(str);
            int parseInt3 = Integer.parseInt(str2);
            if (parseInt != 2) {
                w.e("MicroMsg.ExtControlProviderOpenApi", "wrong msgState: " + parseInt);
                bS(3, 2005);
                return ExtContentProviderBase.me(2005);
            }
            if (com.tencent.mm.plugin.ext.b.aqL().RP(this.lqz) == null) {
                com.tencent.mm.sdk.e.c awVar = new aw();
                awVar.field_appId = this.lqz;
                awVar.field_packageName = aqX();
                String str4 = this.lqz;
                if (bg.mA(str4) ? false : com.tencent.mm.pluginsdk.model.app.g.i(com.tencent.mm.pluginsdk.model.app.g.aJ(str4, true))) {
                    awVar.field_status = 1;
                } else {
                    awVar.field_status = 0;
                }
                awVar.field_sceneFlag = parseInt2;
                awVar.field_msgTypeFlag = parseInt3;
                awVar.field_msgState = parseInt;
                w.i("MicroMsg.ExtControlProviderOpenApi", "registerMsgReceiver ret = %s, pkgName = %s, scene = %s, msgType = %s, msgState = %s, appStatus = %s", Boolean.valueOf(com.tencent.mm.plugin.ext.b.aqL().b(awVar)), aqX(), Integer.valueOf(parseInt2), Integer.valueOf(parseInt), Integer.valueOf(parseInt), Integer.valueOf(awVar.field_status));
                if (!com.tencent.mm.plugin.ext.b.aqL().b(awVar)) {
                    return ExtContentProviderBase.me(2006);
                }
            }
            w.w("MicroMsg.ExtControlProviderOpenApi", "This app had already been registered, appId = %s, pkg = %s", this.lqz, aqX());
            StringBuilder append = new StringBuilder().append(m.xL());
            ap.yY();
            String Pq = aa.Pq(append.append(com.tencent.mm.u.c.uH()).toString());
            Cursor matrixCursor2 = new MatrixCursor(lql);
            try {
                matrixCursor2.addRow(new Object[]{Integer.valueOf(1), bg.mz(Pq)});
                z(0, 0, 1);
                w.i("MicroMsg.ExtControlProviderOpenApi", "return  code =%s ", Integer.valueOf(1));
                return matrixCursor2;
            } catch (Exception e) {
                Exception exception2 = e;
                Cursor cursor = matrixCursor2;
                exception = exception2;
                z(1, 4, 12);
                w.e("MicroMsg.ExtControlProviderOpenApi", "exception in doRegisterMsgListener, %s", exception.getMessage());
                if (matrixCursor != null) {
                    matrixCursor.close();
                }
                return ExtContentProviderBase.me(12);
            }
        } catch (Exception e2) {
            exception = e2;
            z(1, 4, 12);
            w.e("MicroMsg.ExtControlProviderOpenApi", "exception in doRegisterMsgListener, %s", exception.getMessage());
            if (matrixCursor != null) {
                matrixCursor.close();
            }
            return ExtContentProviderBase.me(12);
        }
    }

    private Cursor i(String[] strArr) {
        w.i("MicroMsg.ExtControlProviderOpenApi", "getUserAvatarByOpenId");
        if (strArr == null || strArr.length <= 0) {
            w.e("MicroMsg.ExtControlProviderOpenApi", "wrong args");
            bS(3, 3001);
            return ExtContentProviderBase.me(3001);
        }
        Cursor matrixCursor = new MatrixCursor(lqn);
        int i = 0;
        while (i < strArr.length && i < 5) {
            if (!bg.mA(strArr[i])) {
                bd RZ = com.tencent.mm.plugin.ext.b.aqM().RZ(strArr[i]);
                if (RZ == null || bg.mA(RZ.field_openId) || bg.mA(RZ.field_username)) {
                    w.e("MicroMsg.ExtControlProviderOpenApi", "openidInApp is null");
                } else {
                    ap.yY();
                    af Rc = com.tencent.mm.u.c.wR().Rc(RZ.field_username);
                    if (Rc == null || Rc.field_username == null || Rc.field_username.length() <= 0) {
                        w.e("MicroMsg.ExtControlProviderOpenApi", "contact is null");
                    } else {
                        try {
                            n.Bl();
                            String r = com.tencent.mm.x.d.r(Rc.field_username, false);
                            if (bg.mA(r)) {
                                w.w("MicroMsg.ExtControlProviderOpenApi", "hy: get avatar sfs path is null or nil");
                            } else {
                                String str = Rc.field_username;
                                com.tencent.mm.x.d.b.hp(r);
                                if (FileOp.kh(r)) {
                                    matrixCursor.addRow(new Object[]{strArr[i], r});
                                } else {
                                    w.w("MicroMsg.ExtControlProviderOpenApi", "hy: copy or replace avatar from sfs to file system failed");
                                }
                            }
                        } catch (Exception e) {
                            w.e("MicroMsg.ExtControlProviderOpenApi", "Exception occur, %s", e.getMessage());
                            z(7, 4, 12);
                            matrixCursor.close();
                            return ExtContentProviderBase.me(12);
                        }
                    }
                }
            }
            i++;
        }
        z(6, 0, 1);
        return matrixCursor;
    }

    private Cursor j(String[] strArr) {
        w.i("MicroMsg.ExtControlProviderOpenApi", "decodeVoice");
        if (strArr == null || strArr.length <= 0 || strArr[0].length() <= 0) {
            w.e("MicroMsg.ExtControlProviderOpenApi", "decodeVoice wrong args");
            bS(3, 3101);
            return ExtContentProviderBase.me(3101);
        }
        MatrixCursor matrixCursor = null;
        int i = 0;
        while (i < 5 && i < strArr.length) {
            String str = strArr[i];
            try {
                if (o.g(str, 0, true)) {
                    String am;
                    if (matrixCursor == null) {
                        matrixCursor = new MatrixCursor(lqo);
                    }
                    i iVar = new i();
                    String str2 = com.tencent.mm.plugin.ext.b.aqN() + "/" + aa.Pq(str);
                    if (!e.aO(str2) || aN(str2) == 0) {
                        am = iVar.am(str, str2);
                    } else {
                        w.d("MicroMsg.ExtControlProviderOpenApi", "pcm already exist");
                        am = str2;
                    }
                    if (aN(str2) == 0) {
                        am = iVar.am(str, str2);
                    }
                    if (bg.mA(am)) {
                        w.w("MicroMsg.ExtControlProviderOpenApi", "wrong args targetFilePath is null");
                    } else {
                        w.d("MicroMsg.ExtControlProviderOpenApi", "decode to pcm success %d", Integer.valueOf(i));
                        matrixCursor.addRow(new Object[]{Integer.valueOf(1), Integer.valueOf(iVar.mSampleRate), Integer.valueOf(iVar.fAi), Integer.valueOf(2), am});
                    }
                } else {
                    w.w("MicroMsg.ExtControlProviderOpenApi", "wrong args : %s", strArr[i]);
                }
            } catch (Exception e) {
                w.e("MicroMsg.ExtControlProviderOpenApi", "Exception in decodeVoice, %s", e.getMessage());
            }
            i++;
        }
        if (matrixCursor != null) {
            z(8, 0, 1);
            return matrixCursor;
        }
        z(9, 3, 4);
        return ExtContentProviderBase.me(4);
    }

    private static int aN(String str) {
        if (str == null) {
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            return (int) file.length();
        }
        return 0;
    }

    private void aqS() {
        String str = (String) com.tencent.mm.plugin.ext.b.aqK().get(com.tencent.mm.storage.w.a.USERINFO_EXT_SPORT_PKGNAME_STRING, null);
        w.i("MicroMsg.ExtControlProviderOpenApi", "setSportBroadPkg: pkgNames: %s, pkg: %s", str, aqX());
        if (str == null) {
            com.tencent.mm.plugin.ext.b.aqK().a(com.tencent.mm.storage.w.a.USERINFO_EXT_SPORT_PKGNAME_STRING, aqX());
        } else if (!com.tencent.mm.compatible.loader.a.a(str.split(";"), r1)) {
            com.tencent.mm.plugin.ext.b.aqK().a(com.tencent.mm.storage.w.a.USERINFO_EXT_SPORT_PKGNAME_STRING, str + ";" + aqX());
        }
    }
}
