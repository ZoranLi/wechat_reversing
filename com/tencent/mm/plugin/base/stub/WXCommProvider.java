package com.tencent.mm.plugin.base.stub;

import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Looper;
import android.os.Process;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.bw;
import com.tencent.mm.e.a.en;
import com.tencent.mm.e.a.eo;
import com.tencent.mm.e.a.eu;
import com.tencent.mm.e.a.h;
import com.tencent.mm.e.a.hs;
import com.tencent.mm.e.a.ng;
import com.tencent.mm.e.a.nh;
import com.tencent.mm.e.a.ni;
import com.tencent.mm.e.a.sh;
import com.tencent.mm.network.e;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetLocation;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStopPlayVoice;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.v;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class WXCommProvider extends ContentProvider {
    public static final String PREF_NAME = (ab.getPackageName() + "_comm_preferences");
    private static final String[] jPo = new String[]{DownloadInfoColumns.PACKAGENAME, SlookAirButtonFrequentContactAdapter.DATA};
    private static final UriMatcher jPq = new UriMatcher(-1);
    protected static boolean jPr = false;
    public static Object lock = new Object();
    private ae handler;
    private SharedPreferences hgx;
    protected MatrixCursor jPp = new MatrixCursor(new String[0]);

    static {
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "pref", 1);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "openQRCodeScan", 18);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "batchAddShortcut", 19);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "getUnreadCount", 20);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "jumpToBizProfile", 21);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "jumpToBizTempSession", 27);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "registerMsgListener", 22);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "getAvatar", 23);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "regWatchAppId", 24);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "decodeVoice", 25);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "addCardToWX", 26);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "unReadMsgs", 9);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "to_chatting", 3);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "setReaded", 13);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "voiceControl", 29);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "openRankList", 28);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "openWebview", 30);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "openBusiLuckyMoney", 31);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "createChatroom", 32);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "joinChatroom", 33);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "sendSight", 34);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "redirectToChattingByPhoneNumber", 35);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "redirectToWechatOutByPhoneNumber", 36);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "getWifiList", 37);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "connectWifi", 38);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "chooseCardFromWX", 39);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "openOfflinePay", 42);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "setWechatSportStep", 40);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "getWechatSportConfig", 41);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "handleScanResult", 44);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "openTypeWebview", 45);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "openCleanUI", 46);
        jPq.addURI("com.tencent.mm.sdk.comm.provider", "launchWXMiniprogram", 47);
    }

    public boolean onCreate() {
        w.d("MicroMsg.WXCommProvider", "onCreate");
        this.handler = new ae();
        w.i("MicroMsg.WXCommProvider", "pid = " + Process.myPid() + ", tid : = " + Process.myTid());
        this.hgx = getContext().getSharedPreferences(PREF_NAME, 0);
        getContext().registerReceiver(new BroadcastReceiver(this) {
            final /* synthetic */ WXCommProvider jPs;

            {
                this.jPs = r1;
            }

            public final void onReceive(Context context, Intent intent) {
                ap apVar;
                if (System.currentTimeMillis() - ap.sEF >= 600000) {
                    w.e("MicroMsg.AppUtil", "hy: get comm model time expired");
                    apVar = null;
                } else {
                    apVar = ap.sEE;
                }
                if (apVar != null) {
                    w.i("MicroMsg.WXCommProvider", "hy: has wxcomm query request. start to continue requesting");
                    this.jPs.a(apVar.uri, apVar.projection, apVar.selection, apVar.selectionArgs, apVar.sEC, apVar.code, apVar.sED);
                    p.bDe();
                }
            }
        }, new IntentFilter(ConstantsAPI.ACTION_REFRESH_WXAPP));
        if (this.hgx != null) {
            return true;
        }
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        w.i("MicroMsg.WXCommProvider", "uri:%s", uri);
        if (uri == null) {
            w.e("MicroMsg.WXCommProvider", "query fail, uri is null return null");
            return null;
        }
        String[] acI = acI();
        if (acI == null || acI.length <= 0) {
            w.e("MicroMsg.WXCommProvider", "CallingPackages is null return null");
            return null;
        }
        int match = jPq.match(uri);
        if (a.urY == null) {
            new aj(Looper.getMainLooper(), new aj.a(this) {
                final /* synthetic */ WXCommProvider jPs;

                {
                    this.jPs = r1;
                }

                public final boolean oQ() {
                    if (a.urY == null || !a.urY.s(en.class)) {
                        return true;
                    }
                    synchronized (WXCommProvider.lock) {
                        w.i("MicroMsg.WXCommProvider", "The lock was released.");
                        WXCommProvider.lock.notifyAll();
                    }
                    return false;
                }
            }, true).v(50, 50);
            try {
                synchronized (lock) {
                    w.i("MicroMsg.WXCommProvider", "Lock to wait for the first initialize of the Application.");
                    lock.wait();
                }
            } catch (Throwable e) {
                w.e("MicroMsg.WXCommProvider", "the lock may have some problem," + e.getMessage());
                w.printErrStackTrace("MicroMsg.WXCommProvider", e, "", new Object[0]);
            }
        }
        return a(uri, strArr, str, strArr2, str2, match, acI);
    }

    public final Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, int i, String[] strArr3) {
        Cursor matrixCursor;
        b eoVar;
        b shVar;
        switch (i) {
            case 3:
            case 9:
            case 13:
            case 22:
            case 23:
            case 25:
            case JsApiChooseImage.CTRL_INDEX /*29*/:
            case 34:
            case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
            case 36:
            case JsApiGetLocation.CTRL_INDEX /*37*/:
            case 38:
            case 40:
            case v.CTRL_BYTE /*41*/:
            case 42:
            case JsApiGetMusicPlayerState.CTRL_INDEX /*46*/:
                long currentTimeMillis = System.currentTimeMillis();
                if (acK()) {
                    b euVar = new eu();
                    euVar.fIY.fIt = i;
                    euVar.fIY.uri = uri;
                    euVar.fIY.selectionArgs = strArr2;
                    euVar.fIY.context = getContext();
                    euVar.fIY.fCt = strArr3;
                    if (a.urY.m(euVar)) {
                        w.i("MicroMsg.WXCommProvider", "[extApiCost] total cost = %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        return euVar.fIZ.fIu;
                    }
                    w.e("MicroMsg.WXCommProvider", "ExtCallEvent fail return code = 8");
                    matrixCursor = new MatrixCursor(com.tencent.mm.protocal.b.lqe);
                    matrixCursor.addRow(new Object[]{Integer.valueOf(8)});
                    return matrixCursor;
                }
                String mz = bg.mz(uri.getQueryParameter("appid"));
                if ("1".equals(bg.ap(uri.getQueryParameter("autoLogin"), "0"))) {
                    w.i("MicroMsg.WXCommProvider", "hy: not login. try to login return code = 9");
                    ap.sEE = new ap(uri, strArr, str, strArr2, str2, i, strArr3);
                    ap.sEF = System.currentTimeMillis();
                    d.b(getContext(), "accountsync", "com.tencent.mm.ui.account.LoginUI", null);
                    matrixCursor = new MatrixCursor(com.tencent.mm.protocal.b.lqe);
                    matrixCursor.addRow(new Object[]{Integer.valueOf(9)});
                    return matrixCursor;
                }
                w.i("MicroMsg.WXCommProvider", "not login, appID = %s, apiID = %s return code =%s ", mz, Integer.valueOf(i), Integer.valueOf(3));
                g.oUh.i(10505, bg.mz(strArr3[0]), mz, Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                matrixCursor = new MatrixCursor(com.tencent.mm.protocal.b.lqe);
                matrixCursor.addRow(new Object[]{Integer.valueOf(3)});
                return matrixCursor;
            case 18:
            case 19:
            case 20:
                if (!acJ()) {
                    return null;
                }
                eoVar = new eo();
                eoVar.fIr.fIt = i;
                eoVar.fIr.uri = uri;
                eoVar.fIr.selectionArgs = strArr2;
                eoVar.fIr.context = getContext();
                eoVar.fIr.fCt = strArr3;
                if (a.urY.m(eoVar)) {
                    return eoVar.fIs.fIu;
                }
                w.e("MicroMsg.WXCommProvider", "ExtCallEvent fail");
                return null;
            case 21:
                eoVar = new en();
                eoVar.fIp.op = 21;
                eoVar.fIp.cGa = 1;
                eoVar.fIp.selectionArgs = strArr2;
                eoVar.fIp.context = getContext();
                eoVar.fIp.fCt = strArr3;
                if (!a.urY.m(eoVar)) {
                    w.e("MicroMsg.WXCommProvider", "ExtCallBizEvent fail");
                }
                return null;
            case 24:
                if (!acJ()) {
                    return this.jPp;
                }
                shVar = new sh();
                shVar.fZN.fIt = i;
                shVar.fZN.uri = uri;
                shVar.fZN.context = getContext();
                for (int i2 = 0; i2 < strArr3.length; i2++) {
                    if (strArr3[i2] != null) {
                        shVar.fZN.fZP = strArr3[i2];
                        if (!a.urY.m(shVar)) {
                            return shVar.fZO.fIu;
                        }
                        w.e("MicroMsg.WXCommProvider", "WatchAppIdRegEvent fail");
                        return null;
                    }
                }
                if (!a.urY.m(shVar)) {
                    return shVar.fZO.fIu;
                }
                w.e("MicroMsg.WXCommProvider", "WatchAppIdRegEvent fail");
                return null;
            case 26:
                eoVar = new h();
                eoVar.fCs.selectionArgs = strArr2;
                eoVar.fCs.fCt = strArr3;
                eoVar.fCs.context = getContext();
                if (!a.urY.m(eoVar)) {
                    w.e("MicroMsg.WXCommProvider", "add card to wx fail");
                }
                return null;
            case 27:
                if (strArr2 == null || strArr2.length < 2) {
                    w.e("MicroMsg.WXCommProvider", "wrong args");
                    return null;
                }
                eoVar = new en();
                eoVar.fIp.op = 27;
                eoVar.fIp.cGa = 1;
                eoVar.fIp.selectionArgs = strArr2;
                eoVar.fIp.context = getContext();
                eoVar.fIp.fCt = strArr3;
                if (!a.urY.m(eoVar)) {
                    w.e("MicroMsg.WXCommProvider", "ExtCallBizEvent fail");
                }
                return null;
            case 28:
                eoVar = new en();
                eoVar.fIp.op = i;
                eoVar.fIp.selectionArgs = strArr2;
                eoVar.fIp.context = getContext();
                eoVar.fIp.fCt = strArr3;
                if (!a.urY.m(eoVar)) {
                    w.e("MicroMsg.WXCommProvider", "ExtCallBizEvent fail");
                }
                return null;
            case 30:
            case 45:
                shVar = new ni();
                shVar.fUu.selectionArgs = strArr2;
                shVar.fUu.fCt = strArr3;
                shVar.fUu.context = getContext();
                shVar.fUu.fUv = i == 45;
                if (i == 30 && strArr2 != null && strArr2.length > 2) {
                    com.tencent.mm.pluginsdk.d.sBk = strArr2[2];
                }
                if (!a.urY.m(shVar)) {
                    w.e("MicroMsg.WXCommProvider", "open webview fail");
                }
                return null;
            case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                eoVar = new nh();
                eoVar.fUt.selectionArgs = strArr2;
                eoVar.fUt.fCt = strArr3;
                eoVar.fUt.context = getContext();
                if (!a.urY.m(eoVar)) {
                    w.e("MicroMsg.WXCommProvider", "open busi luckymoney fail");
                }
                return null;
            case 32:
                eoVar = new bw();
                eoVar.fFm.action = 1;
                eoVar.fFm.selectionArgs = strArr2;
                eoVar.fFm.fCt = strArr3;
                eoVar.fFm.context = getContext();
                if (!a.urY.m(eoVar)) {
                    w.e("MicroMsg.WXCommProvider", "open webview fail");
                }
                return null;
            case 33:
                eoVar = new bw();
                eoVar.fFm.action = 2;
                eoVar.fFm.selectionArgs = strArr2;
                eoVar.fFm.fCt = strArr3;
                eoVar.fFm.context = getContext();
                if (!a.urY.m(eoVar)) {
                    w.e("MicroMsg.WXCommProvider", "open webview fail");
                }
                return null;
            case 39:
                eoVar = new com.tencent.mm.e.a.bg();
                eoVar.fEQ.selectionArgs = strArr2;
                eoVar.fEQ.fCt = strArr3;
                eoVar.fEQ.context = getContext();
                if (!a.urY.m(eoVar)) {
                    w.e("MicroMsg.WXCommProvider", "choose card from wx fail");
                }
                return null;
            case 44:
                eoVar = new hs();
                eoVar.fNm.selectionArgs = strArr2;
                eoVar.fNm.fCt = strArr3;
                eoVar.fNm.context = getContext();
                if (!a.urY.m(eoVar)) {
                    w.e("MicroMsg.WXCommProvider", "handle scan result failed try again");
                    af.f(new Runnable(this) {
                        final /* synthetic */ WXCommProvider jPs;

                        public final void run() {
                            if (!a.urY.m(eoVar)) {
                                w.e("MicroMsg.WXCommProvider", "handle scan result failed again");
                            }
                        }
                    }, 200);
                }
                return null;
            case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                eoVar = new ng();
                eoVar.fUs.selectionArgs = strArr2;
                eoVar.fUs.fCt = strArr3;
                eoVar.fUs.context = getContext();
                if (!a.urY.m(eoVar)) {
                    w.e("MicroMsg.WXCommProvider", "launch wx miniprogram fail");
                }
                return null;
            default:
                final MatrixCursor matrixCursor2 = new MatrixCursor(jPo);
                final Uri uri2 = uri;
                final int i3 = i;
                final String[] strArr4 = strArr3;
                matrixCursor = (Cursor) new bb<Cursor>(this) {
                    final /* synthetic */ WXCommProvider jPs;

                    protected final /* synthetic */ Object run() {
                        w.d("MicroMsg.WXCommProvider", "query, uri = %s, code = %d", uri2.toString(), Integer.valueOf(i3));
                        if (i3 != 1) {
                            w.e("MicroMsg.WXCommProvider", "query fail, invalid code = %d", Integer.valueOf(i3));
                            return null;
                        }
                        for (String string : strArr4) {
                            String string2 = this.jPs.hgx.getString(string, "");
                            matrixCursor2.addRow(new String[]{string, string2});
                        }
                        w.d("MicroMsg.WXCommProvider", "query size = %d", Integer.valueOf(matrixCursor2.getCount()));
                        return matrixCursor2;
                    }
                }.b(this.handler);
                if (matrixCursor != null) {
                    return matrixCursor;
                }
                matrixCursor2.close();
                return matrixCursor;
        }
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        if (uri == null) {
            w.e("MicroMsg.WXCommProvider", "delete fail, uri is null");
            return 0;
        }
        final int match = jPq.match(uri);
        final String[] acI = acI();
        final Uri uri2 = uri;
        return ((Integer) new bb<Integer>(this, Integer.valueOf(0)) {
            final /* synthetic */ WXCommProvider jPs;

            protected final /* synthetic */ Object run() {
                w.d("MicroMsg.WXCommProvider", "delete, uri = %s, code = %d", uri2.toString(), Integer.valueOf(match));
                if (match != 1) {
                    w.e("MicroMsg.WXCommProvider", "delete fail, invalid code = %d", Integer.valueOf(match));
                    return null;
                }
                int i = 0;
                for (String str : acI) {
                    if (!bg.mA(str)) {
                        int i2 = (this.jPs.hgx.contains(str) && this.jPs.hgx.edit().remove(str).commit()) ? 1 : 0;
                        if (i2 != 0) {
                            i++;
                        }
                    }
                }
                w.d("MicroMsg.WXCommProvider", "delete result = %d", Integer.valueOf(i));
                return Integer.valueOf(i);
            }
        }.b(this.handler)).intValue();
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private String[] acI() {
        try {
            int callingUid = Binder.getCallingUid();
            String[] packagesForUid = getContext().getPackageManager().getPackagesForUid(Binder.getCallingUid());
            String str = "MicroMsg.WXCommProvider";
            String str2 = "getCallingPackages, callingUid = %d, packages size = %d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(callingUid);
            objArr[1] = Integer.valueOf(packagesForUid == null ? 0 : packagesForUid.length);
            w.i(str, str2, objArr);
            if (packagesForUid == null) {
                w.w("MicroMsg.WXCommProvider", "getCallingPackages fail, packages is null");
                return new String[0];
            }
            int length = packagesForUid.length;
            for (callingUid = 0; callingUid < length; callingUid++) {
                w.i("MicroMsg.WXCommProvider", "getCallingPackages = %s", packagesForUid[callingUid]);
            }
            return packagesForUid;
        } catch (Exception e) {
            w.e("MicroMsg.WXCommProvider", "getCallingPackages, ex = %s", e.getMessage());
            return new String[0];
        }
    }

    private boolean acJ() {
        try {
            w.i("MicroMsg.WXCommProvider", "checkIsLogin()");
            if (jPr || ((Boolean) new bb<Boolean>(this, Boolean.valueOf(false)) {
                final /* synthetic */ WXCommProvider jPs;

                protected final /* synthetic */ Object run() {
                    return acL();
                }

                private Boolean acL() {
                    try {
                        w.i("MicroMsg.WXCommProvider", "checkIsLogin run");
                        if (!com.tencent.mm.u.ap.zb()) {
                            return Boolean.valueOf(false);
                        }
                        w.i("MicroMsg.WXCommProvider", "checkIsLogin doScene");
                        return Boolean.valueOf(com.tencent.mm.u.ap.vd().a(new com.tencent.mm.u.bb(new com.tencent.mm.u.bb.a(this) {
                            final /* synthetic */ AnonymousClass6 jPy;

                            {
                                this.jPy = r1;
                            }

                            public final void a(e eVar) {
                                w.i("MicroMsg.WXCommProvider", "checkIsLogin onSceneEnd() hasLogin:%s", Boolean.valueOf(WXCommProvider.jPr));
                                this.jPy.bv(Boolean.valueOf(true));
                            }
                        }), 0));
                    } catch (Exception e) {
                        w.e("MicroMsg.WXCommProvider", "exception in NetSceneLocalProxy.");
                        bv(Boolean.valueOf(false));
                        return Boolean.valueOf(false);
                    }
                }
            }.b(this.handler)).booleanValue()) {
                if (com.tencent.mm.u.ap.zb() && com.tencent.mm.u.ap.za() && !com.tencent.mm.u.ap.uP()) {
                    jPr = true;
                } else {
                    jPr = false;
                }
                w.i("MicroMsg.WXCommProvider", "hasLogin = " + jPr);
                return jPr;
            }
            w.i("MicroMsg.WXCommProvider", "checkIsLogin !syncTaskRet");
            jPr = false;
            return false;
        } catch (Throwable e) {
            w.w("MicroMsg.WXCommProvider", e.getMessage());
            w.printErrStackTrace("MicroMsg.WXCommProvider", e, "", new Object[0]);
            return false;
        }
    }

    private boolean acK() {
        try {
            w.i("MicroMsg.WXCommProvider", "checkIsLogin()");
            if (!jPr) {
                final com.tencent.mm.pluginsdk.f.a.a aVar = new com.tencent.mm.pluginsdk.f.a.a();
                aVar.b(4000, new Runnable(this) {
                    final /* synthetic */ WXCommProvider jPs;

                    public final void run() {
                        try {
                            if (com.tencent.mm.u.ap.zb()) {
                                com.tencent.mm.u.ap.vd().a(new com.tencent.mm.u.bb(new com.tencent.mm.u.bb.a(this) {
                                    final /* synthetic */ AnonymousClass7 jPA;

                                    {
                                        this.jPA = r1;
                                    }

                                    public final void a(e eVar) {
                                        w.i("MicroMsg.WXCommProvider", "checkIsLogin() onSceneEnd()");
                                        aVar.countDown();
                                    }
                                }), 0);
                            }
                        } catch (Exception e) {
                            w.e("MicroMsg.WXCommProvider", "exception in NetSceneLocalProxy");
                            aVar.countDown();
                        }
                    }
                });
            }
            if (com.tencent.mm.u.ap.zb() && com.tencent.mm.u.ap.za() && !com.tencent.mm.u.ap.uP()) {
                jPr = true;
            } else {
                jPr = false;
            }
            w.i("MicroMsg.WXCommProvider", "hasLogin = " + jPr);
            return jPr;
        } catch (Throwable e) {
            w.w("MicroMsg.WXCommProvider", e.getMessage());
            w.printErrStackTrace("MicroMsg.WXCommProvider", e, "", new Object[0]);
            return false;
        }
    }
}
