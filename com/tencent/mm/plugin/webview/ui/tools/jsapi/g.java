package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.app.Activity;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.ProgressDialog;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.Uri;
import android.nfc.NfcAdapter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.DatePicker;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.R;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.cu;
import com.tencent.mm.e.a.cv;
import com.tencent.mm.e.a.cy;
import com.tencent.mm.e.a.cz;
import com.tencent.mm.e.a.da;
import com.tencent.mm.e.a.dc;
import com.tencent.mm.e.a.df;
import com.tencent.mm.e.a.dg;
import com.tencent.mm.e.a.dl;
import com.tencent.mm.e.a.dm;
import com.tencent.mm.e.a.dr;
import com.tencent.mm.e.a.ds;
import com.tencent.mm.e.a.du;
import com.tencent.mm.e.a.dv;
import com.tencent.mm.e.a.dy;
import com.tencent.mm.e.a.ei;
import com.tencent.mm.e.a.ev;
import com.tencent.mm.e.a.ey;
import com.tencent.mm.e.a.fb;
import com.tencent.mm.e.a.gh;
import com.tencent.mm.e.a.gi;
import com.tencent.mm.e.a.gj;
import com.tencent.mm.e.a.gk;
import com.tencent.mm.e.a.gl;
import com.tencent.mm.e.a.gn;
import com.tencent.mm.e.a.hd;
import com.tencent.mm.e.a.he;
import com.tencent.mm.e.a.i;
import com.tencent.mm.e.a.ie;
import com.tencent.mm.e.a.jc;
import com.tencent.mm.e.a.ju;
import com.tencent.mm.e.a.km;
import com.tencent.mm.e.a.kp;
import com.tencent.mm.e.a.kv;
import com.tencent.mm.e.a.ld;
import com.tencent.mm.e.a.ln;
import com.tencent.mm.e.a.mq;
import com.tencent.mm.e.a.mr;
import com.tencent.mm.e.a.nt;
import com.tencent.mm.e.a.nv;
import com.tencent.mm.e.a.nz;
import com.tencent.mm.e.a.ow;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.e.a.pw;
import com.tencent.mm.e.a.sg;
import com.tencent.mm.e.a.sq;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo;
import com.tencent.mm.modelbiz.a.t;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.network.aa;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStopPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiSendAppMessage;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aw;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.ad;
import com.tencent.mm.plugin.webview.model.ag;
import com.tencent.mm.plugin.webview.model.ah;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.plugin.webview.model.h;
import com.tencent.mm.plugin.webview.model.x;
import com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper;
import com.tencent.mm.plugin.webview.stub.WebViewStubTempUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.afo;
import com.tencent.mm.protocal.c.afp;
import com.tencent.mm.protocal.c.afr;
import com.tencent.mm.protocal.c.aga;
import com.tencent.mm.protocal.c.ago;
import com.tencent.mm.protocal.c.agp;
import com.tencent.mm.protocal.c.agr;
import com.tencent.mm.protocal.c.aha;
import com.tencent.mm.protocal.c.ahc;
import com.tencent.mm.protocal.c.ahe;
import com.tencent.mm.protocal.c.ahg;
import com.tencent.mm.protocal.c.aif;
import com.tencent.mm.protocal.c.aig;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.protocal.c.bfm;
import com.tencent.mm.protocal.c.bfx;
import com.tencent.mm.protocal.c.bfy;
import com.tencent.mm.protocal.c.biv;
import com.tencent.mm.protocal.c.biy;
import com.tencent.mm.protocal.c.bmp;
import com.tencent.mm.protocal.c.bmq;
import com.tencent.mm.protocal.c.ji;
import com.tencent.mm.protocal.c.mo;
import com.tencent.mm.protocal.c.uj;
import com.tencent.mm.protocal.c.ux;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vp;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.ay;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.aq;
import com.tencent.mm.u.j;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.u.p;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.x.n;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wework.api.WWAPIFactory;
import com.tencent.wework.api.model.BaseMessage;
import com.tencent.wework.api.model.WWMediaLink;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class g implements com.tencent.mm.ui.MMActivity.a {
    private static final HashSet<String> iNc;
    private static final char[] jnN = new char[]{'<', '>', '\"', '\'', '&', ' ', '\''};
    private static final String[] jnO = new String[]{"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&nbsp;", "&#39;"};
    public static Context skD;
    public static int skE = -1;
    public static final LinkedList<Runnable> slb = new LinkedList();
    public static boolean slc = false;
    public static a sld = new a() {
        public final void Tn() {
            a.rYG.vL().D(new Runnable(this) {
                final /* synthetic */ AnonymousClass104 smw;

                {
                    this.smw = r1;
                }

                public final void run() {
                    Runnable runnable = (Runnable) g.slb.pollFirst();
                    if (runnable != null) {
                        runnable.run();
                        return;
                    }
                    w.i("MicroMsg.MsgHandler", "authJsApiQueue processed!");
                    g.slc = false;
                }
            });
        }
    };
    public Context context;
    private WXMediaMessage fNK;
    public final int fRO;
    public com.tencent.mm.modelgeo.c gKi = null;
    public Map<String, afo> gKm = new ConcurrentHashMap();
    public com.tencent.mm.modelgeo.a.a iNl = null;
    private ae iNm;
    public ProgressDialog isv = null;
    private String kbi = null;
    public boolean lre = false;
    public ProgressDialog mSZ;
    public HashSet<String> mjR;
    public float pbU = 0.0f;
    com.tencent.mm.sdk.b.c psH = new com.tencent.mm.sdk.b.c<dg>(this) {
        final /* synthetic */ g sll;

        {
            this.sll = r2;
            this.usg = dg.class.getName().hashCode();
        }

        private boolean a(dg dgVar) {
            if (dgVar != null && (dgVar instanceof dg)) {
                System.currentTimeMillis();
                long j = this.sll.skP;
                if (g.skE != -1) {
                    this.sll.skt = this.sll.wD(g.skE).skt;
                    this.sll.rXh = this.sll.wD(g.skE).rXh;
                }
                this.sll.skP = System.currentTimeMillis();
                String str = dgVar.fHe.fHc;
                int i = dgVar.fHe.fHf;
                int i2 = dgVar.fHe.fHg & 65535;
                double d = dgVar.fHe.fHi;
                double d2 = dgVar.fHe.fHh;
                w.i("MicroMsg.MsgHandler", "[MsgHandler][IBeaconRangeResult],iBeacon = %s", new Object[]{str + "," + i + "," + i2 + "," + d});
                String str2 = str + "," + i + "," + i2;
                boolean z = false;
                List<afp> list;
                Iterator it;
                afr com_tencent_mm_protocal_c_afr;
                if (this.sll.gKm.containsKey(str2)) {
                    list = (List) this.sll.skM.get(str + "," + i);
                    if (list != null) {
                        for (afp com_tencent_mm_protocal_c_afp : list) {
                            if (com_tencent_mm_protocal_c_afp != null && com_tencent_mm_protocal_c_afp.tKM != null && !com_tencent_mm_protocal_c_afp.tKM.isEmpty()) {
                                it = com_tencent_mm_protocal_c_afp.tKM.iterator();
                                while (it.hasNext()) {
                                    com_tencent_mm_protocal_c_afr = (afr) it.next();
                                    if (i2 >= com_tencent_mm_protocal_c_afr.tKN && i2 <= com_tencent_mm_protocal_c_afr.tKO) {
                                        z = true;
                                        continue;
                                        break;
                                    }
                                }
                                continue;
                            }
                            if (z) {
                                break;
                            }
                        }
                    }
                } else {
                    afo com_tencent_mm_protocal_c_afo = new afo();
                    com_tencent_mm_protocal_c_afo.mry = str;
                    com_tencent_mm_protocal_c_afo.major = i;
                    com_tencent_mm_protocal_c_afo.minor = i2;
                    this.sll.gKm.put(str2, com_tencent_mm_protocal_c_afo);
                    if (this.sll.skM.containsKey(str + "," + i)) {
                        list = (List) this.sll.skM.get(str + "," + i);
                        if (list != null) {
                            for (afp com_tencent_mm_protocal_c_afp2 : list) {
                                boolean z2;
                                if (!(com_tencent_mm_protocal_c_afp2 == null || com_tencent_mm_protocal_c_afp2.tKM == null || com_tencent_mm_protocal_c_afp2.tKM.isEmpty())) {
                                    Iterator it2 = com_tencent_mm_protocal_c_afp2.tKM.iterator();
                                    while (it2.hasNext()) {
                                        com_tencent_mm_protocal_c_afr = (afr) it2.next();
                                        if (i2 >= com_tencent_mm_protocal_c_afr.tKN && i2 <= com_tencent_mm_protocal_c_afr.tKO) {
                                            z2 = true;
                                            break;
                                        }
                                    }
                                }
                                z2 = z;
                                if (z2) {
                                    z = z2;
                                    break;
                                }
                                z = z2;
                            }
                        }
                    }
                    if (!z) {
                        this.sll.skN.add(com_tencent_mm_protocal_c_afo);
                        String str3 = null;
                        if (!(this.sll.skt == null || this.sll.skt.ozE == null)) {
                            Object obj = this.sll.skt.ozE.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
                            str3 = bg.mz(this.sll.skF.JZ(obj != null ? obj.toString() : ""));
                        }
                        if (!this.sll.skO) {
                            this.sll.skO = true;
                            final k hVar = new h(this.sll.skN, bg.mz(str3));
                            this.sll.skN.clear();
                            ap.vd().a(1704, new e(this) {
                                final /* synthetic */ AnonymousClass21 slE;

                                public final void a(int i, int i2, String str, k kVar) {
                                    if (i == 0 && i2 == 0) {
                                        ux uxVar = (ux) hVar.hKp.hsk.hsr;
                                        if (uxVar.leR == 0) {
                                            List<afp> list = uxVar.tCy;
                                            StringBuilder stringBuilder = new StringBuilder();
                                            for (afp com_tencent_mm_protocal_c_afp : list) {
                                                List list2;
                                                String str2 = com_tencent_mm_protocal_c_afp.mry + "," + com_tencent_mm_protocal_c_afp.major;
                                                if (this.slE.sll.skM.containsKey(str2)) {
                                                    list2 = (List) this.slE.sll.skM.get(str2);
                                                } else {
                                                    list2 = new ArrayList();
                                                    this.slE.sll.skM.put(str2, list2);
                                                }
                                                list2.add(com_tencent_mm_protocal_c_afp);
                                                stringBuilder.append("{uuid:" + com_tencent_mm_protocal_c_afp.mry + ",major:" + com_tencent_mm_protocal_c_afp.major + ",minors:[");
                                                Iterator it = com_tencent_mm_protocal_c_afp.tKM.iterator();
                                                while (it.hasNext()) {
                                                    afr com_tencent_mm_protocal_c_afr = (afr) it.next();
                                                    stringBuilder.append(com_tencent_mm_protocal_c_afr.tKN + "-" + com_tencent_mm_protocal_c_afr.tKO + ",");
                                                }
                                                stringBuilder.append("]},");
                                            }
                                            w.d("MicroMsg.MsgHandler", "[MsgHandler][ibeacon check callback]" + stringBuilder.toString());
                                        }
                                    }
                                    ap.vd().b(1704, this);
                                    this.slE.sll.skO = false;
                                }
                            });
                            ap.vd().a(hVar, 0);
                        }
                    }
                }
                w.d("MicroMsg.MsgHandler", "[MsgHandler][ibeacon check and find] find:%s", new Object[]{String.valueOf(z) + "," + str2});
                try {
                    if (this.sll.rXh != null && z) {
                        Bundle bundle = new Bundle();
                        bundle.putString("uuid", str);
                        bundle.putInt("major", i);
                        bundle.putInt("minor", i2);
                        bundle.putDouble("accuracy", d2);
                        bundle.putDouble("rssi", d);
                        bundle.putFloat("heading", this.sll.pbU);
                        this.sll.rXh.m(40002, bundle);
                    }
                } catch (RemoteException e) {
                    w.i("MicroMsg.MsgHandler", "[MsgHandler]callback failure:%s", new Object[]{e.getMessage()});
                }
                w.i("MicroMsg.MsgHandler", "[MsgHandler]result iBeacon = %s,beaconMap.size:%d", new Object[]{this.sll.gKm.get(str2), Integer.valueOf(this.sll.gKm.size())});
            }
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c psI = new com.tencent.mm.sdk.b.c<dm>(this) {
        final /* synthetic */ g sll;

        {
            this.sll = r2;
            this.usg = dm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            dm dmVar = (dm) bVar;
            if (dmVar != null && (dmVar instanceof dm)) {
                w.d("MicroMsg.MsgHandler", "ExDeviceOnBluetoothStateChangeEvent = %s", new Object[]{Integer.valueOf(dmVar.fHu.fHv)});
                if (dmVar.fHu.fHv != 10 && dmVar.fHu.fHv == 12 && this.sll.skT) {
                    this.sll.a(this.sll.sku, 1);
                }
            }
            return false;
        }
    };
    public com.tencent.mm.plugin.webview.stub.e rXh;
    public String skA = null;
    public com.tencent.mm.plugin.webview.stub.e skB;
    private com.tencent.mm.plugin.webview.stub.e skC;
    public c skF = null;
    public boolean skG = false;
    public final j skH;
    final com.tencent.mm.plugin.webview.d.d skI;
    public long skJ = 0;
    private int skK = -1;
    Map<String, String> skL = new ConcurrentHashMap();
    public Map<String, List<afp>> skM = new ConcurrentHashMap();
    public List<afo> skN = new CopyOnWriteArrayList();
    public boolean skO = false;
    public long skP = 0;
    LocationManager skQ = null;
    public String skR = "-1000.0";
    public String skS = "-1000.0";
    public boolean skT = false;
    private SensorEventListener skU = new SensorEventListener(this) {
        final /* synthetic */ g sll;

        {
            this.sll = r1;
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == 3) {
                this.sll.pbU = sensorEvent.values[0];
            }
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }
    };
    public com.tencent.mm.sdk.b.c skV;
    public i skW;
    public com.tencent.mm.sdk.b.c skX = new com.tencent.mm.sdk.b.c<pw>(this) {
        final /* synthetic */ g sll;

        {
            this.sll = r2;
            this.usg = pw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            pw pwVar = (pw) bVar;
            if (pwVar != null && (pwVar instanceof pw)) {
                w.d("MicroMsg.MsgHandler", "StartVoipCSResultEvent = %s", new Object[]{Integer.valueOf(pwVar.fWW.status)});
                g gVar = this.sll;
                int i = pwVar.fWW.status;
                if (i == 1) {
                    gVar.a(gVar.skW, "startVoipCall:cancel", null);
                } else if (i == 2) {
                    gVar.a(gVar.skW, "startVoipCall:hangup", null);
                } else if (i == 3) {
                    gVar.a(gVar.skW, "startVoipCall:network error", null);
                } else if (i == 4) {
                    gVar.a(gVar.skW, "startVoipCall:param not match", null);
                } else {
                    gVar.a(gVar.skW, "startVoipCall:unknow", null);
                }
            }
            return false;
        }
    };
    public final Map<String, b> skY = new HashMap();
    public String skZ;
    public i skt;
    public i sku;
    public HashSet<String> skv;
    public Bundle skw;
    private String skx = null;
    public HashMap<String, String> sky = null;
    public HashMap<String, String> skz = null;
    public final List<String> sla = new LinkedList();
    public final Map<Integer, c> sle = new HashMap();
    private int slf = 0;
    public volatile i slg = null;
    public final com.tencent.mm.sdk.b.c slh = new com.tencent.mm.sdk.b.c<jc>(this) {
        final /* synthetic */ g sll;

        {
            this.sll = r2;
            this.usg = jc.class.getName().hashCode();
        }

        private boolean a(jc jcVar) {
            w.i("MicroMsg.MsgHandler", "backgroundAudioListener callback in, state:%s", new Object[]{jcVar.fPc.state});
            int i = (int) (jcVar.fPc.duration / 1000);
            if (jcVar.fPc.fPe) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString("background_audio_state_player_state", r2);
                    bundle.putInt("background_audio_state_player_duration", i);
                    if (jcVar.fPc.fOY != null) {
                        bundle.putString("background_audio_state_player_src", jcVar.fPc.fOY.tRN);
                        bundle.putString("background_audio_state_player_src_id", jcVar.fPc.fOY.hMU);
                    }
                    bundle.putInt("background_audio_state_player_err_code", jcVar.fPc.errCode);
                    String str = "";
                    if (!TextUtils.isEmpty(jcVar.fPc.fPf)) {
                        str = jcVar.fPc.fPf;
                    }
                    bundle.putString("background_audio_state_player_err_msg", str);
                    if (this.sll.rXh != null) {
                        w.i("MicroMsg.MsgHandler", "onBackgroundAudioStateChange");
                        this.sll.rXh.m(2100, bundle);
                    } else {
                        w.e("MicroMsg.MsgHandler", "backgroundAudioListener callbacker is null");
                    }
                    return true;
                } catch (Exception e) {
                    w.e("MicroMsg.MsgHandler", e.getMessage());
                    return false;
                }
            }
            w.e("MicroMsg.MsgHandler", "is not from QQMusicPlayer, don't callback!");
            return false;
        }
    };

    class AnonymousClass58 implements Runnable {
        final /* synthetic */ WebViewJSSDKFileItem slV;
        final /* synthetic */ g sll;

        public AnonymousClass58(g gVar, WebViewJSSDKFileItem webViewJSSDKFileItem) {
            this.sll = gVar;
            this.slV = webViewJSSDKFileItem;
        }

        public final void run() {
            com.tencent.mm.sdk.b.b eyVar = new ey();
            eyVar.fJh.op = 2;
            eyVar.fJh.filePath = this.slV.iDA;
            com.tencent.mm.sdk.b.a.urY.m(eyVar);
            this.sll.skZ = null;
        }
    }

    class AnonymousClass96 implements com.tencent.mm.pluginsdk.ui.applet.k.a {
        final /* synthetic */ String fxL;
        final /* synthetic */ String hGc;
        final /* synthetic */ String jOW;
        final /* synthetic */ g sll;
        final /* synthetic */ f slp;
        final /* synthetic */ String slq;
        final /* synthetic */ String slr;
        final /* synthetic */ String slt;
        final /* synthetic */ boolean smq = true;
        final /* synthetic */ String smr;
        final /* synthetic */ String sms;

        AnonymousClass96(g gVar, f fVar, String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8) {
            this.sll = gVar;
            this.slp = fVar;
            this.jOW = str;
            this.fxL = str2;
            this.hGc = str3;
            this.slq = str4;
            this.slr = str5;
            this.slt = str6;
            this.smr = str7;
            this.sms = str8;
        }

        public final void a(boolean z, String str, int i) {
            if (z) {
                this.sll.a(this.slp, this.jOW, this.fxL, this.hGc, this.slq, this.slr, str, this.slt);
                if (this.smq) {
                    com.tencent.mm.bb.d.a(this.sll.context, ".ui.chatting.En_5b8fbb1e", new Intent().putExtra("Chat_User", this.fxL));
                } else if (this.sll.context != null) {
                    com.tencent.mm.ui.base.g.bl(this.sll.context, this.sll.context.getResources().getString(R.l.dIG));
                }
                this.sll.dy(1, 1);
                this.sll.a(this.sll.skt, this.smr, null);
                return;
            }
            this.sll.dy(1, 3);
            this.sll.a(this.sll.skt, this.sms, null);
        }
    }

    public interface a {
        void Tn();
    }

    private static final class b {
        public i skt;
        public com.tencent.mm.plugin.webview.model.c.b smF;
    }

    private class c {
        public com.tencent.mm.plugin.webview.stub.e rXh;
        public i skt;
        final /* synthetic */ g sll;

        public c(g gVar, i iVar, com.tencent.mm.plugin.webview.stub.e eVar) {
            this.sll = gVar;
            this.skt = iVar;
            this.rXh = eVar;
        }
    }

    private static class d implements com.tencent.mm.pluginsdk.model.app.g.c {
        volatile boolean fNM;
        volatile boolean htw;
        volatile boolean smG;
        volatile boolean smH;
        a smI;

        interface a {
            void C(boolean z, boolean z2);
        }

        d(a aVar) {
            this.smI = aVar;
        }

        public final void ex(boolean z) {
            this.htw = true;
            this.smG = z;
            if (this.smH && this.smI != null) {
                this.smI.C(this.fNM, z);
            }
        }

        final void jc(boolean z) {
            this.fNM = z;
            this.smH = true;
            if (this.htw && this.smI != null) {
                this.smI.C(z, this.smG);
            }
        }
    }

    class AnonymousClass102 implements com.tencent.mm.plugin.webview.d.d.a {
        final /* synthetic */ i slC;
        final /* synthetic */ g sll;

        AnonymousClass102(g gVar, i iVar) {
            this.sll = gVar;
            this.slC = iVar;
        }

        public final void a(String str, JSONObject jSONObject, Bitmap bitmap) {
            if (bitmap == null) {
                this.sll.a(this.slC, "chooseIdCard:fail", null);
                return;
            }
            try {
                String str2 = com.tencent.mm.compatible.util.e.hgq + "tmpScanLicense/";
                w.d("MicroMsg.MsgHandler", "tmpSaveCardBitmapDir: %s", new Object[]{str2});
                if (FileOp.aO(str2)) {
                    FileOp.y(str2, true);
                }
                FileOp.kl(str2);
                FileOp.kn(str2);
                str2 = str2 + System.currentTimeMillis() + ".jpg";
                w.d("MicroMsg.MsgHandler", "tmpSaveCardBitmapPath: %s", new Object[]{str2});
                com.tencent.mm.sdk.platformtools.d.a(bitmap, 100, CompressFormat.JPEG, str2, true);
                WebViewJSSDKFileItem IP = WebViewJSSDKFileItem.IP(str2);
                com.tencent.mm.plugin.webview.d.f.bwZ().b(IP);
                Map hashMap = new HashMap();
                hashMap.put("sourceType", "scan");
                hashMap.put("localId", IP.fJz);
                this.sll.a(this.slC, "chooseIdCard:ok", hashMap);
            } catch (Exception e) {
                w.e("MicroMsg.MsgHandler", "save scan license error: %s", new Object[]{e.getMessage()});
                this.sll.a(this.slC, "chooseIdCard:fail", null);
            }
        }

        public final void Jk(String str) {
            this.sll.a(this.slC, "chooseIdCard:cancel", null);
        }

        public final void FY(String str) {
            this.sll.a(this.slC, "chooseIdCard:fail", null);
        }
    }

    class AnonymousClass106 implements com.tencent.mm.r.a.d.a<com.tencent.mm.r.a.d> {
        final /* synthetic */ int iQW;
        final /* synthetic */ i sli;
        final /* synthetic */ g sll;
        final /* synthetic */ a smx;

        AnonymousClass106(g gVar, i iVar, a aVar, int i) {
            this.sll = gVar;
            this.sli = iVar;
            this.smx = aVar;
            this.iQW = i;
        }

        public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
            com.tencent.mm.r.a.d dVar = (com.tencent.mm.r.a.d) kVar;
            w.i("MicroMsg.MsgHandler", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (i != 0 || i2 != 0) {
                this.sll.a(this.sli, "login:fail", null);
                this.smx.Tn();
            } else if (!(dVar instanceof com.tencent.mm.r.a.d)) {
            } else {
                if (this.iQW == 2) {
                    w.d("MicroMsg.MsgHandler", "press reject button");
                    this.smx.Tn();
                    return;
                }
                ahe uG = dVar.uG();
                int i3 = uG.tLL.fIz;
                String str2 = uG.tLL.fIA;
                w.i("MicroMsg.MsgHandler", "stev NetSceneJSLoginConfirm jsErrcode %d", new Object[]{Integer.valueOf(i3)});
                if (i3 == 0) {
                    String str3 = uG.tLO;
                    Map hashMap = new HashMap();
                    hashMap.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, str3);
                    this.sll.a(this.sli, "login:ok", hashMap);
                    this.smx.Tn();
                    w.d("MicroMsg.MsgHandler", "resp data code [%s]", new Object[]{str3});
                    return;
                }
                this.sll.a(this.sli, "login:fail", null);
                this.smx.Tn();
                w.e("MicroMsg.MsgHandler", "onSceneEnd NetSceneJSLoginConfirm %s", new Object[]{str2});
            }
        }
    }

    class AnonymousClass108 implements com.tencent.mm.r.a.b.a<com.tencent.mm.r.a.b> {
        final /* synthetic */ int iQW;
        final /* synthetic */ i sli;
        final /* synthetic */ g sll;
        final /* synthetic */ a smx;

        AnonymousClass108(g gVar, i iVar, a aVar, int i) {
            this.sll = gVar;
            this.sli = iVar;
            this.smx = aVar;
            this.iQW = i;
        }

        public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
            com.tencent.mm.r.a.b bVar = (com.tencent.mm.r.a.b) kVar;
            w.d("MicroMsg.MsgHandler", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (i != 0 || i2 != 0) {
                this.sll.a(this.sli, "authorize:fail", null);
                this.smx.Tn();
            } else if (!(bVar instanceof com.tencent.mm.r.a.b)) {
            } else {
                if (this.iQW == 2) {
                    w.d("MicroMsg.MsgHandler", "press reject button");
                    this.smx.Tn();
                    return;
                }
                aha uE = bVar.uE();
                int i3 = uE.tLL.fIz;
                String str2 = uE.tLL.fIA;
                w.i("MicroMsg.MsgHandler", "NetSceneJSAuthorizeConfirm jsErrcode %d", new Object[]{Integer.valueOf(i3)});
                if (i3 == 0) {
                    this.sll.a(this.sli, "authorize:ok", null);
                    this.smx.Tn();
                    return;
                }
                w.e("MicroMsg.MsgHandler", "onSceneEnd NetSceneJSAuthorizeConfirm ERROR %s", new Object[]{str2});
                this.sll.a(this.sli, "authorize:fail", null);
                this.smx.Tn();
            }
        }
    }

    static {
        HashSet hashSet = new HashSet();
        iNc = hashSet;
        hashSet.add("gcj02");
        iNc.add("wgs84");
    }

    g(int i) {
        this.fRO = i;
        this.lre = false;
        this.skv = new HashSet();
        this.mjR = new HashSet();
        this.skF = new c(this.fRO);
        this.skH = new j();
        this.skI = new com.tencent.mm.plugin.webview.d.d();
    }

    public final void a(Context context, com.tencent.mm.plugin.webview.stub.e eVar) {
        w.i("MicroMsg.MsgHandler", "set context and callbacker");
        this.context = context;
        if (this.skF != null) {
            this.skF.a(context, eVar);
        }
        this.rXh = eVar;
    }

    public final void a(Context context, com.tencent.mm.plugin.webview.stub.e eVar, com.tencent.mm.plugin.webview.stub.e eVar2) {
        w.i("MicroMsg.MsgHandler", "set context, callbacker and service callbacker");
        this.context = context;
        if (this.skF != null) {
            this.skF.a(context, eVar);
        }
        this.rXh = eVar;
        this.skC = eVar2;
    }

    public final Bundle bzx() {
        if (this.skw == null) {
            this.skw = new Bundle();
        }
        return this.skw;
    }

    public final String pH(String str) {
        if (this.skF != null) {
            return this.skF.JZ(str);
        }
        w.i("MicroMsg.MsgHandler", "getCachedAppId, jsVerifyHelper is null, return null");
        return null;
    }

    private void Kf(String str) {
        if (this.skw == null) {
            this.skw = new Bundle();
        }
        int i = bg.getInt(str, 33);
        if (this.skw.getBoolean("KFromBizSearch")) {
            Bundle bundle = this.skw.getBundle("KBizSearchExtArgs");
            if (bundle != null) {
                i = bundle.getInt("Contact_Scene");
            }
        }
        this.skw.putInt("Contact_Scene", i);
    }

    private boolean Kg(String str) {
        w.i("MicroMsg.MsgHandler", "getFromMenu, functionName = " + str);
        if (!this.skv.contains(str)) {
            return false;
        }
        this.skv.remove(str);
        return true;
    }

    public final boolean Kh(String str) {
        w.i("MicroMsg.MsgHandler", "removeInvokedJsApiFromMenu, functionName = %s, succ = %s.", new Object[]{str, Boolean.valueOf(this.mjR.remove(str))});
        return this.mjR.remove(str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.tencent.mm.plugin.webview.ui.tools.jsapi.i r21, com.tencent.mm.protocal.JsapiPermissionWrapper r22) {
        /*
        r20 = this;
        r0 = r20;
        r4 = r0.lre;
        if (r4 == 0) goto L_0x000f;
    L_0x0006:
        r4 = "MicroMsg.MsgHandler";
        r5 = "handleMsg, MsgHandler is busy, old msg will be overrided";
        com.tencent.mm.sdk.platformtools.w.w(r4, r5);
    L_0x000f:
        r0 = r20;
        r4 = r0.skw;
        if (r4 == 0) goto L_0x0024;
    L_0x0015:
        r0 = r20;
        r4 = r0.skw;
        r5 = r20.getClass();
        r5 = r5.getClassLoader();
        r4.setClassLoader(r5);
    L_0x0024:
        r0 = r21;
        r1 = r20;
        r1.skt = r0;
        r4 = 1;
        r0 = r20;
        r0.lre = r4;
        r0 = r21;
        r4 = r0.type;
        r5 = "call";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x0160;
    L_0x003c:
        r0 = r21;
        r4 = r0.smN;
        r0 = r20;
        r0.skA = r4;
        r0 = r21;
        r4 = r0.smN;
        r4 = com.tencent.mm.plugin.webview.ui.tools.a.JB(r4);
        r5 = -1;
        if (r5 == r4) goto L_0x005a;
    L_0x004f:
        r5 = com.tencent.mm.plugin.report.service.g.oUh;
        r6 = 157; // 0x9d float:2.2E-43 double:7.76E-322;
        r8 = (long) r4;
        r10 = 1;
        r12 = 0;
        r5.a(r6, r8, r10, r12);
    L_0x005a:
        r0 = r20;
        r4 = r0.skA;
        r4 = com.tencent.mm.sdk.platformtools.bg.mz(r4);
        r5 = com.tencent.mm.protocal.c.NH(r4);
        if (r5 != 0) goto L_0x008a;
    L_0x0068:
        r4 = "MicroMsg.MsgHandler";
        r5 = "unknown function = %s";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r0 = r20;
        r8 = r0.skA;
        r6[r7] = r8;
        com.tencent.mm.sdk.platformtools.w.e(r4, r5, r6);
        r6 = "system:function_not_exist";
        r7 = 0;
        r8 = 1;
        r9 = 0;
        r4 = r20;
        r5 = r21;
        r4.a(r5, r6, r7, r8, r9);
        r4 = 1;
    L_0x0089:
        return r4;
    L_0x008a:
        r4 = r5.getName();
        r0 = r20;
        r6 = r0.mjR;
        r4 = r6.contains(r4);
        if (r4 != 0) goto L_0x00c6;
    L_0x0098:
        r4 = r5.bHa();
        r0 = r22;
        r4 = r0.xX(r4);
        if (r4 != 0) goto L_0x00c6;
    L_0x00a4:
        r4 = "MicroMsg.MsgHandler";
        r6 = "handleMsg access denied func: %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r5 = r5.getName();
        r7[r8] = r5;
        com.tencent.mm.sdk.platformtools.w.e(r4, r6, r7);
        r6 = "system:access_denied";
        r7 = 0;
        r8 = 1;
        r9 = 0;
        r4 = r20;
        r5 = r21;
        r4.a(r5, r6, r7, r8, r9);
        r4 = 1;
        goto L_0x0089;
    L_0x00c6:
        r4 = new com.tencent.mm.plugin.webview.ui.tools.jsapi.g$1;	 Catch:{ Exception -> 0x0140 }
        r0 = r20;
        r1 = r21;
        r2 = r22;
        r4.<init>(r0, r1, r5, r2);	 Catch:{ Exception -> 0x0140 }
        r0 = r20;
        r0 = r0.skF;	 Catch:{ Exception -> 0x0140 }
        r18 = r0;
        r0 = r20;
        r6 = r0.rXh;	 Catch:{ Exception -> 0x0140 }
        r7 = r6.VD();	 Catch:{ Exception -> 0x0140 }
        r5 = r5.bHa();	 Catch:{ Exception -> 0x0140 }
        r0 = r21;
        r9 = r0.smN;	 Catch:{ Exception -> 0x0140 }
        r6 = com.tencent.mm.sdk.platformtools.bg.mA(r9);	 Catch:{ Exception -> 0x0140 }
        if (r6 == 0) goto L_0x010a;
    L_0x00ed:
        r5 = "MicroMsg.webview.JSVerifyHelper";
        r6 = "jsapi is null, %s";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x0140 }
        r9 = 0;
        r8[r9] = r7;	 Catch:{ Exception -> 0x0140 }
        com.tencent.mm.sdk.platformtools.w.e(r5, r6, r8);	 Catch:{ Exception -> 0x0140 }
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_ACCESS_DENIED;	 Catch:{ Exception -> 0x0140 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0140 }
    L_0x0105:
        r4 = r4.bzj();	 Catch:{ Exception -> 0x0140 }
        goto L_0x0089;
    L_0x010a:
        if (r22 == 0) goto L_0x0118;
    L_0x010c:
        r6 = com.tencent.mm.sdk.platformtools.bg.mA(r7);	 Catch:{ Exception -> 0x0140 }
        if (r6 != 0) goto L_0x0118;
    L_0x0112:
        r0 = r22;
        r6 = r0.sZd;	 Catch:{ Exception -> 0x0140 }
        if (r6 != 0) goto L_0x0184;
    L_0x0118:
        r6 = "MicroMsg.webview.JSVerifyHelper";
        r8 = "handleJSVerify invalid argument, currentUrl = %s, jsapi = %s, %s";
        r5 = 3;
        r10 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0140 }
        r5 = 0;
        r10[r5] = r7;	 Catch:{ Exception -> 0x0140 }
        r5 = 1;
        r10[r5] = r9;	 Catch:{ Exception -> 0x0140 }
        r7 = 2;
        if (r22 == 0) goto L_0x0182;
    L_0x012a:
        r5 = 1;
    L_0x012b:
        r5 = java.lang.Boolean.valueOf(r5);	 Catch:{ Exception -> 0x0140 }
        r10[r7] = r5;	 Catch:{ Exception -> 0x0140 }
        com.tencent.mm.sdk.platformtools.w.e(r6, r8, r10);	 Catch:{ Exception -> 0x0140 }
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_FAIL;	 Catch:{ Exception -> 0x0140 }
        r6 = "localParameters";
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0140 }
        goto L_0x0105;
    L_0x0140:
        r4 = move-exception;
        r5 = "MicroMsg.MsgHandler";
        r6 = "handleMsg excpetion %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r9 = r4.getMessage();
        r7[r8] = r9;
        com.tencent.mm.sdk.platformtools.w.e(r5, r6, r7);
        r5 = "MicroMsg.MsgHandler";
        r6 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r5, r4, r6, r7);
    L_0x0160:
        r4 = "MicroMsg.MsgHandler";
        r5 = new java.lang.StringBuilder;
        r6 = "unknown type = ";
        r5.<init>(r6);
        r0 = r21;
        r6 = r0.type;
        r5 = r5.append(r6);
        r5 = r5.toString();
        com.tencent.mm.sdk.platformtools.w.e(r4, r5);
        r4 = 0;
        r0 = r20;
        r0.lre = r4;
        r4 = 0;
        goto L_0x0089;
    L_0x0182:
        r5 = 0;
        goto L_0x012b;
    L_0x0184:
        r0 = r22;
        r17 = r0.xX(r5);	 Catch:{ Exception -> 0x0140 }
        r6 = "MicroMsg.webview.JSVerifyHelper";
        r8 = "handleJSVerify jsApi = %s, permission pos = %d, permission = %s currentUrl = %s";
        r10 = 4;
        r10 = new java.lang.Object[r10];	 Catch:{ Exception -> 0x0140 }
        r11 = 0;
        r10[r11] = r9;	 Catch:{ Exception -> 0x0140 }
        r11 = 1;
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0140 }
        r10[r11] = r5;	 Catch:{ Exception -> 0x0140 }
        r5 = 2;
        r11 = java.lang.Integer.valueOf(r17);	 Catch:{ Exception -> 0x0140 }
        r10[r5] = r11;	 Catch:{ Exception -> 0x0140 }
        r5 = 3;
        r10[r5] = r7;	 Catch:{ Exception -> 0x0140 }
        com.tencent.mm.sdk.platformtools.w.i(r6, r8, r10);	 Catch:{ Exception -> 0x0140 }
        r0 = r18;
        r5 = r0.sjA;	 Catch:{ Exception -> 0x0140 }
        r5 = r5.get(r7);	 Catch:{ Exception -> 0x0140 }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x0140 }
        r6 = com.tencent.mm.sdk.platformtools.bg.mA(r5);	 Catch:{ Exception -> 0x0140 }
        if (r6 == 0) goto L_0x038a;
    L_0x01ba:
        r0 = r21;
        r5 = r0.ozE;	 Catch:{ Exception -> 0x0140 }
        r6 = "verifyAppId";
        r5 = r5.get(r6);	 Catch:{ Exception -> 0x0140 }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x0140 }
        r12 = r5;
    L_0x01c8:
        r0 = r21;
        r5 = r0.smM;	 Catch:{ Exception -> 0x0140 }
        r6 = "permissionValue";
        r8 = java.lang.Integer.valueOf(r17);	 Catch:{ Exception -> 0x0140 }
        r5.put(r6, r8);	 Catch:{ Exception -> 0x0140 }
        r6 = "appId";
        r5.put(r6, r12);	 Catch:{ Exception -> 0x0140 }
        switch(r17) {
            case 0: goto L_0x022e;
            case 1: goto L_0x0204;
            case 2: goto L_0x020f;
            case 3: goto L_0x0266;
            case 4: goto L_0x0239;
            default: goto L_0x01df;
        };	 Catch:{ Exception -> 0x0140 }
    L_0x01df:
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_FAIL;	 Catch:{ Exception -> 0x0140 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0140 }
        r7 = "unkonwPermission_";
        r6.<init>(r7);	 Catch:{ Exception -> 0x0140 }
        r0 = r17;
        r6 = r6.append(r0);	 Catch:{ Exception -> 0x0140 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0140 }
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0140 }
        r5 = "MicroMsg.webview.JSVerifyHelper";
        r6 = "unknow permission";
        com.tencent.mm.sdk.platformtools.w.e(r5, r6);	 Catch:{ Exception -> 0x0140 }
        goto L_0x0105;
    L_0x0204:
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_OK;	 Catch:{ Exception -> 0x0140 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0140 }
        goto L_0x0105;
    L_0x020f:
        r5 = "preVerifyJSAPI";
        r5 = r9.equals(r5);	 Catch:{ Exception -> 0x0140 }
        if (r5 == 0) goto L_0x0223;
    L_0x0218:
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_OK;	 Catch:{ Exception -> 0x0140 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0140 }
        goto L_0x0105;
    L_0x0223:
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_ACCESS_DENIED;	 Catch:{ Exception -> 0x0140 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0140 }
        goto L_0x0105;
    L_0x022e:
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_ACCESS_DENIED;	 Catch:{ Exception -> 0x0140 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0140 }
        goto L_0x0105;
    L_0x0239:
        r0 = r18;
        r5 = r0.sjz;	 Catch:{ Exception -> 0x0140 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0140 }
        r6.<init>();	 Catch:{ Exception -> 0x0140 }
        r6 = r6.append(r9);	 Catch:{ Exception -> 0x0140 }
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x0140 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0140 }
        r5 = r5.get(r6);	 Catch:{ Exception -> 0x0140 }
        r5 = (com.tencent.mm.protocal.c.agk) r5;	 Catch:{ Exception -> 0x0140 }
        if (r5 == 0) goto L_0x0266;
    L_0x0256:
        r5 = r5.thx;	 Catch:{ Exception -> 0x0140 }
        r6 = 1;
        if (r5 != r6) goto L_0x0266;
    L_0x025b:
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_OK;	 Catch:{ Exception -> 0x0140 }
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r4.a(r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0140 }
        goto L_0x0105;
    L_0x0266:
        r0 = r21;
        r5 = r0.ozE;	 Catch:{ Exception -> 0x0140 }
        r6 = "verifySignature";
        r5 = r5.get(r6);	 Catch:{ Exception -> 0x0140 }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x0140 }
        r0 = r21;
        r6 = r0.ozE;	 Catch:{ Exception -> 0x0140 }
        r8 = "verifyNonceStr";
        r6 = r6.get(r8);	 Catch:{ Exception -> 0x0140 }
        r6 = (java.lang.String) r6;	 Catch:{ Exception -> 0x0140 }
        r0 = r21;
        r8 = r0.ozE;	 Catch:{ Exception -> 0x0140 }
        r10 = "verifyTimestamp";
        r8 = r8.get(r10);	 Catch:{ Exception -> 0x0140 }
        r8 = (java.lang.String) r8;	 Catch:{ Exception -> 0x0140 }
        r0 = r21;
        r10 = r0.ozE;	 Catch:{ Exception -> 0x0140 }
        r11 = "verifySignType";
        r10 = r10.get(r11);	 Catch:{ Exception -> 0x0140 }
        r10 = (java.lang.String) r10;	 Catch:{ Exception -> 0x0140 }
        r0 = r21;
        r11 = r0.ozE;	 Catch:{ Exception -> 0x0140 }
        r13 = "scope";
        r16 = r11.get(r13);	 Catch:{ Exception -> 0x0140 }
        r16 = (java.lang.String) r16;	 Catch:{ Exception -> 0x0140 }
        r0 = r21;
        r11 = r0.ozE;	 Catch:{ Exception -> 0x0140 }
        r13 = "addrSign";
        r11 = r11.get(r13);	 Catch:{ Exception -> 0x0140 }
        r11 = (java.lang.String) r11;	 Catch:{ Exception -> 0x0140 }
        r13 = "MicroMsg.webview.JSVerifyHelper";
        r14 = "handleJSVerify addrSign = %s, signature = %s";
        r15 = 2;
        r15 = new java.lang.Object[r15];	 Catch:{ Exception -> 0x0140 }
        r19 = 0;
        r15[r19] = r11;	 Catch:{ Exception -> 0x0140 }
        r19 = 1;
        r15[r19] = r5;	 Catch:{ Exception -> 0x0140 }
        com.tencent.mm.sdk.platformtools.w.i(r13, r14, r15);	 Catch:{ Exception -> 0x0140 }
        r15 = 0;
        r13 = com.tencent.mm.sdk.platformtools.bg.mA(r5);	 Catch:{ Exception -> 0x0140 }
        if (r13 == 0) goto L_0x0353;
    L_0x02cf:
        r11 = com.tencent.mm.sdk.platformtools.bg.mA(r11);	 Catch:{ Exception -> 0x0140 }
        if (r11 != 0) goto L_0x0353;
    L_0x02d5:
        r15 = 1;
        r0 = r21;
        r5 = r0.ozE;	 Catch:{ Exception -> 0x0140 }
        r6 = "appId";
        r5 = r5.get(r6);	 Catch:{ Exception -> 0x0140 }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x0140 }
        r0 = r21;
        r6 = r0.ozE;	 Catch:{ Exception -> 0x0140 }
        r8 = "addrSign";
        r6 = r6.get(r8);	 Catch:{ Exception -> 0x0140 }
        r6 = (java.lang.String) r6;	 Catch:{ Exception -> 0x0140 }
        r0 = r21;
        r8 = r0.ozE;	 Catch:{ Exception -> 0x0140 }
        r10 = "signType";
        r8 = r8.get(r10);	 Catch:{ Exception -> 0x0140 }
        r8 = (java.lang.String) r8;	 Catch:{ Exception -> 0x0140 }
        r0 = r21;
        r10 = r0.ozE;	 Catch:{ Exception -> 0x0140 }
        r11 = "timeStamp";
        r10 = r10.get(r11);	 Catch:{ Exception -> 0x0140 }
        r10 = (java.lang.String) r10;	 Catch:{ Exception -> 0x0140 }
        r0 = r21;
        r11 = r0.ozE;	 Catch:{ Exception -> 0x0140 }
        r12 = "nonceStr";
        r11 = r11.get(r12);	 Catch:{ Exception -> 0x0140 }
        r11 = (java.lang.String) r11;	 Catch:{ Exception -> 0x0140 }
        r13 = r8;
        r12 = r6;
        r8 = r5;
    L_0x031a:
        r14 = 0;
        r0 = r21;
        r5 = r0.ozE;	 Catch:{ Exception -> 0x0140 }
        r5 = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.Z(r5);	 Catch:{ Exception -> 0x0140 }
        if (r5 == 0) goto L_0x032d;
    L_0x0325:
        r5 = r5.toString();	 Catch:{ Exception -> 0x0140 }
        r14 = r5.getBytes();	 Catch:{ Exception -> 0x0140 }
    L_0x032d:
        r5 = 4;
        r0 = r17;
        if (r0 != r5) goto L_0x0360;
    L_0x0332:
        r5 = new com.tencent.mm.plugin.webview.model.l;	 Catch:{ Exception -> 0x0140 }
        r0 = r18;
        r0 = r0.rWF;	 Catch:{ Exception -> 0x0140 }
        r17 = r0;
        r6 = r4;
        r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);	 Catch:{ Exception -> 0x0140 }
        r6 = com.tencent.mm.u.ap.vd();	 Catch:{ Exception -> 0x0140 }
        r7 = 1095; // 0x447 float:1.534E-42 double:5.41E-321;
        r0 = r18;
        r6.a(r7, r0);	 Catch:{ Exception -> 0x0140 }
        r6 = com.tencent.mm.u.ap.vd();	 Catch:{ Exception -> 0x0140 }
        r7 = 0;
        r6.a(r5, r7);	 Catch:{ Exception -> 0x0140 }
        goto L_0x0105;
    L_0x0353:
        r11 = com.tencent.mm.sdk.platformtools.bg.mA(r5);	 Catch:{ Exception -> 0x0140 }
        if (r11 != 0) goto L_0x0384;
    L_0x0359:
        r15 = 2;
        r13 = r10;
        r11 = r6;
        r10 = r8;
        r8 = r12;
        r12 = r5;
        goto L_0x031a;
    L_0x0360:
        r5 = 3;
        r0 = r17;
        if (r0 != r5) goto L_0x01df;
    L_0x0365:
        r5 = new com.tencent.mm.plugin.webview.model.n;	 Catch:{ Exception -> 0x0140 }
        r0 = r18;
        r15 = r0.rWF;	 Catch:{ Exception -> 0x0140 }
        r6 = r4;
        r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);	 Catch:{ Exception -> 0x0140 }
        r6 = com.tencent.mm.u.ap.vd();	 Catch:{ Exception -> 0x0140 }
        r7 = 1094; // 0x446 float:1.533E-42 double:5.405E-321;
        r0 = r18;
        r6.a(r7, r0);	 Catch:{ Exception -> 0x0140 }
        r6 = com.tencent.mm.u.ap.vd();	 Catch:{ Exception -> 0x0140 }
        r7 = 0;
        r6.a(r5, r7);	 Catch:{ Exception -> 0x0140 }
        goto L_0x0105;
    L_0x0384:
        r13 = r10;
        r11 = r6;
        r10 = r8;
        r8 = r12;
        r12 = r5;
        goto L_0x031a;
    L_0x038a:
        r12 = r5;
        goto L_0x01c8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.jsapi.g.a(com.tencent.mm.plugin.webview.ui.tools.jsapi.i, com.tencent.mm.protocal.JsapiPermissionWrapper):boolean");
    }

    public final boolean b(final i iVar) {
        w.d("MicroMsg.MsgHandler", "doResendRemittanceMsg");
        final String str = (String) iVar.ozE.get("transactionId");
        final String str2 = (String) iVar.ozE.get("receiverName");
        if (bg.mA(str) || bg.mA(str2)) {
            a(iVar, "doResendRemittanceMsg:fail", null);
        } else {
            com.tencent.mm.ui.base.g.a(this.context, R.l.eKx, R.l.dIs, R.l.eLt, R.l.dGs, new OnClickListener(this) {
                final /* synthetic */ g sll;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent();
                    intent.putExtra("transaction_id", str);
                    intent.putExtra("receiver_name", str2);
                    com.tencent.mm.bb.d.b(this.sll.context, "remittance", ".ui.RemittanceResendMsgUI", intent);
                    this.sll.a(iVar, "doResendRemittanceMsg:ok", null);
                }
            }, new OnClickListener(this) {
                final /* synthetic */ g sll;

                {
                    this.sll = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
        return true;
    }

    public final boolean c(i iVar) {
        w.d("MicroMsg.MsgHandler", "doOpenLuckyMoneyDetailView");
        String str = (String) iVar.ozE.get("sendId");
        int parseInt = Integer.parseInt((String) iVar.ozE.get("hbKind"));
        if (bg.mA(str)) {
            a(iVar, "openLuckyMoneyDetailView:fail", null);
        } else {
            w.i("MicroMsg.MsgHandler", "sendId: %s, hbKind: %s", new Object[]{str, Integer.valueOf(parseInt)});
            Intent intent = new Intent();
            intent.putExtra("key_sendid", str);
            intent.putExtra("key_jump_from", 4);
            if (parseInt == 2) {
                com.tencent.mm.bb.d.b(this.context, "luckymoney", ".ui.LuckyMoneyBusiDetailUI", intent);
            } else {
                com.tencent.mm.bb.d.b(this.context, "luckymoney", ".ui.LuckyMoneyDetailUI", intent);
            }
            a(iVar, "openLuckyMoneyDetailView:ok", null);
        }
        return true;
    }

    public final boolean d(final i iVar) {
        w.d("MicroMsg.MsgHandler", "doShowDatePicker");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String format;
            String str;
            String str2;
            String str3;
            String str4 = (String) iVar.ozE.get("current");
            if (bg.mA(str4)) {
                format = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
            } else {
                format = str4;
            }
            str4 = (String) iVar.ozE.get("range");
            if (bg.mA(str4)) {
                str = null;
                str2 = null;
            } else {
                JSONObject jSONObject = new JSONObject(str4);
                String optString = jSONObject.optString("start", "2013-01-01");
                str = jSONObject.optString("end", format);
                str2 = optString;
            }
            str4 = (String) iVar.ozE.get("fields");
            if (bg.mA(str4)) {
                str3 = "month";
            } else {
                str3 = str4;
            }
            Calendar instance = Calendar.getInstance();
            instance.setTime(simpleDateFormat.parse(format));
            if (this.context == null || !(this.context instanceof Activity)) {
                w.e("MicroMsg.MsgHandler", "context error!");
                return false;
            }
            com.tencent.mm.ui.widget.f fVar = new com.tencent.mm.ui.widget.f(this.context, new OnDateSetListener(this) {
                final /* synthetic */ g sll;

                public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                    w.i("MicroMsg.MsgHandler", "date set: %d, %d, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2 + 1), Integer.valueOf(i3)});
                    Map hashMap = new HashMap();
                    hashMap.put("selectTime", String.format("%d-%d-%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2 + 1), Integer.valueOf(i3)}));
                    this.sll.a(iVar, "showDatePickerView:ok", hashMap);
                }
            }, instance.get(1), instance.get(2), instance.get(5), simpleDateFormat.parse(str2).getTime(), str3);
            fVar.setOnCancelListener(new OnCancelListener(this) {
                final /* synthetic */ g sll;

                public final void onCancel(DialogInterface dialogInterface) {
                    w.i("MicroMsg.MsgHandler", "cancel date set");
                    this.sll.a(iVar, "showDatePickerView:cancel", null);
                }
            });
            if (!bg.mA(str2)) {
                w.d("MicroMsg.MsgHandler", "min date: %s", new Object[]{str2});
                fVar.getDatePicker().setMinDate(simpleDateFormat.parse(str2).getTime());
            }
            if (!bg.mA(str)) {
                w.d("MicroMsg.MsgHandler", "max date: %s", new Object[]{str});
                fVar.getDatePicker().setMaxDate(simpleDateFormat.parse(str).getTime());
            }
            fVar.show();
            return true;
        } catch (JSONException e) {
        } catch (ParseException e2) {
        }
    }

    public final boolean e(i iVar) {
        try {
            String str = (String) this.skt.ozE.get("link");
            k.a(this.skt.smM, Kg("shareTimeline"), str, null);
            if (str == null || str.length() == 0) {
                w.e("MicroMsg.MsgHandler", "naerCheckIn fail, link is null");
                a(this.skt, "timeline_check_in:fail", null);
                return true;
            }
            int intValue;
            truncate((String) this.skt.ozE.get("desc"));
            w.i("MicroMsg.MsgHandler", "naerCheckIn, img_url = " + ((String) this.skt.ozE.get("img_url")) + ", title = " + ((String) this.skt.ozE.get("title")) + ", desc = " + ((String) this.skt.ozE.get("desc")));
            str = (String) this.skt.ozE.get("img_width");
            String str2 = (String) this.skt.ozE.get("img_height");
            w.i("MicroMsg.MsgHandler", "naerCheckIn, rawUrl:[%s], shareUrl:[%s]", new Object[]{(String) this.skt.ozE.get("link"), aj.xH((String) this.skt.ozE.get("link"))});
            String str3 = (String) this.skt.ozE.get(Columns.TYPE);
            this.skt.ozE.get("desc");
            String str4 = (String) this.skt.ozE.get("title");
            String str5 = (String) this.skt.ozE.get("img_url");
            try {
                intValue = Integer.valueOf(str).intValue();
                try {
                    Integer.valueOf(str2);
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                intValue = -1;
            }
            Intent intent = new Intent();
            intent.putExtra("Ksnsupload_width", intValue);
            intent.putExtra("Ksnsupload_height", intValue);
            intent.putExtra("Ksnsupload_link", r8);
            intent.putExtra("Ksnsupload_title", str4);
            intent.putExtra("Ksnsupload_imgurl", str5);
            intent.putExtra("Ksnsupload_type", 1);
            if (!bg.mA(str3) && str3.equals("music")) {
                intent.putExtra("ksnsis_music", true);
            }
            if (!bg.mA(str3) && str3.equals(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
                intent.putExtra("ksnsis_video", true);
            }
            str = (String) this.skt.ozE.get("poiId");
            str2 = (String) this.skt.ozE.get("poiName");
            str3 = (String) this.skt.ozE.get("poiAddress");
            float f = bg.getFloat((String) iVar.ozE.get("latitude"), 0.0f);
            float f2 = bg.getFloat((String) iVar.ozE.get("longitude"), 0.0f);
            intent.putExtra("kpoi_id", str);
            intent.putExtra("kpoi_name", str2);
            intent.putExtra("Kpoi_address", str3);
            intent.putExtra("k_lat", f);
            intent.putExtra("k_lng", f2);
            com.tencent.mm.bb.d.b(this.context, "sns", ".ui.En_c4f742e5", intent);
            this.lre = false;
            return false;
        } catch (Exception e3) {
            return true;
        }
    }

    public final boolean f(i iVar) {
        int i = 0;
        try {
            float f = bg.getFloat((String) iVar.ozE.get("latitude"), 0.0f);
            float f2 = bg.getFloat((String) iVar.ozE.get("longitude"), 0.0f);
            String qU = qU((String) iVar.ozE.get("name"));
            String qU2 = qU((String) iVar.ozE.get("address"));
            String qU3 = qU((String) iVar.ozE.get("infoUrl"));
            try {
                i = bg.getInt((String) iVar.ozE.get("scale"), 0);
            } catch (Exception e) {
            }
            Intent intent = new Intent();
            if (bg.getInt((String) this.skt.ozE.get("webview_scene"), 0) == 25) {
                intent.putExtra("map_view_type", 9);
                intent.putExtra("kPoi_url", qU3);
            } else {
                intent.putExtra("map_view_type", 7);
            }
            intent.putExtra("kwebmap_slat", (double) f);
            intent.putExtra("kwebmap_lng", (double) f2);
            if (i > 0) {
                intent.putExtra("kwebmap_scale", i);
            }
            intent.putExtra("kPoiName", qU);
            intent.putExtra("Kwebmap_locaion", qU2);
            com.tencent.mm.bb.d.b(this.context, "location", ".ui.RedirectUI", intent);
            a(this.skt, "open_location:ok", null);
        } catch (Exception e2) {
            a(this.skt, "open_location:invalid_coordinate", null);
        }
        return true;
    }

    private static String qU(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int i2 = 0;
            while (i2 < jnN.length) {
                String str2 = jnO[i2];
                int i3 = 0;
                while (i3 < str2.length() && i + i3 < length && str2.charAt(i3) == str.charAt(i + i3)) {
                    i3++;
                }
                if (i3 == str2.length()) {
                    break;
                }
                i2++;
            }
            if (i2 != jnN.length) {
                stringBuffer.append(jnN[i2]);
                i = jnO[i2].length() + i;
            } else {
                stringBuffer.append(str.charAt(i));
                i++;
            }
        }
        return stringBuffer.toString();
    }

    public final boolean g(i iVar) {
        try {
            String str = (String) iVar.ozE.get("bid");
            Intent intent = new Intent();
            intent.putExtra("sns_bid", str);
            com.tencent.mm.bb.d.b(this.context, "sns", ".ui.ClassifyTimeLineUI", intent);
            a(this.skt, "open_timeline_checkin_list:ok", null);
        } catch (Exception e) {
        }
        return true;
    }

    public final boolean b(i iVar, JsapiPermissionWrapper jsapiPermissionWrapper) {
        this.fNK = h(iVar);
        if (this.fNK == null) {
            w.e("MicroMsg.MsgHandler", "doSendAppMsg fail, appmsg is null");
            a(iVar, "send_app_msg:fail", null);
        } else {
            String string = bzx().getString("scene");
            bzx().remove("scene");
            if (!"friend".equals(string)) {
                k.a(iVar.smM, Kg(GameJsApiSendAppMessage.NAME), null, (String) iVar.ozE.get("appid"));
            }
            w.i("MicroMsg.MsgHandler", "send appmsg scene is '%s'", new Object[]{string});
            String string2;
            if ("connector".equals(string)) {
                w.i("MicroMsg.MsgHandler", "directly send to %s", new Object[]{bzy()});
                a(1, -1, new Intent().putExtra("Select_Conv_User", string2));
            } else if ("favorite".equals(string)) {
                w.i("MicroMsg.MsgHandler", "favorite url");
                com.tencent.mm.sdk.b.b cbVar = new cb();
                com.tencent.mm.plugin.webview.model.b.a aVar = new com.tencent.mm.plugin.webview.model.b.a();
                w.i("MicroMsg.MsgHandler", "rawurl:[%s], shareurl:[%s]", new Object[]{(String) this.skt.ozE.get("link"), aj.xH((String) this.skt.ozE.get("link"))});
                aVar.url = r4;
                aVar.thumbUrl = (String) this.skt.ozE.get("img_url");
                aVar.title = (String) this.skt.ozE.get("title");
                aVar.desc = (String) this.skt.ozE.get("desc");
                aVar.fTO = (String) this.skt.ozE.get("appid");
                if (this.skw != null) {
                    string2 = this.skw.getString("key_snsad_statextstr");
                    aVar.fUY = string2;
                } else {
                    string2 = null;
                }
                try {
                    Bundle d = this.rXh.d(18, null);
                    if (d != null) {
                        String fQ = q.fQ(bg.mz(d.getString("KPublisherId")));
                        com.tencent.mm.u.q.b n = q.yC().n(fQ, true);
                        n.l("sendAppMsgScene", Integer.valueOf(2));
                        n.l("preChatName", d.getString("preChatName"));
                        n.l("preMsgIndex", Integer.valueOf(d.getInt("preMsgIndex")));
                        n.l("prePublishId", d.getString("prePublishId"));
                        n.l("preUsername", d.getString("preUsername"));
                        n.l("getA8KeyScene", Integer.valueOf(d.getInt("getA8KeyScene")));
                        n.l("referUrl", d.getString("referUrl"));
                        if (!bg.mA(string2)) {
                            n.l("adExtStr", string2);
                        }
                        cbVar.fFA.fFF = fQ;
                    }
                } catch (RemoteException e) {
                    w.e("MicroMsg.MsgHandler", "try to report error, %s", new Object[]{e});
                }
                if (this.context instanceof Activity) {
                    cbVar.fFA.activity = (Activity) this.context;
                    cbVar.fFA.fFH = 36;
                }
                com.tencent.mm.plugin.webview.model.b.a(cbVar, aVar);
                cbVar.fFA.fFJ = new com.tencent.mm.ui.snackbar.b.c(this) {
                    final /* synthetic */ g sll;

                    {
                        this.sll = r1;
                    }

                    public final void azn() {
                    }

                    public final void onHide() {
                        this.sll.a(this.sll.skt, "send_app_msg:ok", null);
                    }

                    public final void azo() {
                    }
                };
                com.tencent.mm.sdk.b.a.urY.m(cbVar);
                if (cbVar.fFB.ret == 0) {
                    dy(3, 1);
                    try {
                        a(aVar.fTO, aVar.thumbUrl, 4, this.rXh.d(85, null));
                    } catch (RemoteException e2) {
                        w.e("MicroMsg.MsgHandler", "invokeAsResult error : %s", new Object[]{e2});
                    }
                } else {
                    dy(3, 2);
                    a(this.skt, "send_fav_msg:fail", null);
                }
            } else if ("enterprise".equals(string)) {
                String bzy = bzy();
                Serializable hashMap = new HashMap();
                hashMap.put("img_url", (String) iVar.ozE.get("img_url"));
                hashMap.put("desc", (String) iVar.ozE.get("desc"));
                hashMap.put("title", (String) iVar.ozE.get("title"));
                hashMap.put("src_username", (String) iVar.ozE.get("src_username"));
                hashMap.put("src_displayname", (String) iVar.ozE.get("src_displayname"));
                w.i("MicroMsg.MsgHandler", "doSendAppMessage, img_url=%s, desc=%s, title=%s", new Object[]{(String) iVar.ozE.get("img_url"), (String) iVar.ozE.get("desc"), (String) iVar.ozE.get("title")});
                Intent intent;
                if (com.tencent.mm.modelbiz.e.dr(bzy)) {
                    intent = new Intent();
                    intent.setClassName(this.context, "com.tencent.mm.ui.bizchat.BizChatSelectConversationUI");
                    intent.putExtra("enterprise_biz_name", bzy);
                    intent.putExtra("biz_chat_scene", 1);
                    intent.putExtra("enterprise_extra_params", hashMap);
                    if (this.context instanceof MMActivity) {
                        ((MMActivity) this.context).uSV = this;
                        ((MMActivity) this.context).a(this, intent, 37);
                    }
                } else if (com.tencent.mm.modelbiz.e.ib(bzy)) {
                    intent = new Intent();
                    intent.putExtra("enterprise_biz_name", bzy);
                    intent.putExtra("enterprise_scene", 3);
                    intent.putExtra("enterprise_extra_params", hashMap);
                    if (this.context instanceof MMActivity) {
                        ((MMActivity) this.context).uSV = this;
                        com.tencent.mm.bb.d.b(this.context, "brandservice", ".ui.EnterpriseBizContactPlainListUI", intent, 37);
                    }
                }
            } else if ("wework".equals(string)) {
                bk(iVar);
            } else if ("facebook".equals(string)) {
                Intent intent2 = new Intent();
                intent2.putExtra("title", (String) iVar.ozE.get("title"));
                intent2.putExtra("digest", (String) iVar.ozE.get("desc"));
                intent2.putExtra("img", (String) iVar.ozE.get("img_url"));
                intent2.putExtra("link", (String) iVar.ozE.get("link"));
                intent2.setClassName(this.context, "com.tencent.mm.plugin.accountsync.ui.ShareToFacebookRedirectUI");
                this.context.startActivity(intent2);
                a(iVar, "shareQZone:ok", null);
            } else if ("qq".equals(string)) {
                bl(iVar);
            } else {
                w.i("MicroMsg.MsgHandler", "select user to send");
                Serializable hashMap2 = new HashMap();
                if (a(iVar, jsapiPermissionWrapper.nw(89))) {
                    this.fNK = h(iVar);
                }
                if (jsapiPermissionWrapper.nw(290)) {
                    this.skt.ozE.put("share_callback_with_scene", Boolean.valueOf(true));
                } else {
                    this.skt.ozE.put("share_callback_with_scene", Boolean.valueOf(false));
                }
                hashMap2.put("img_url", (String) iVar.ozE.get("img_url"));
                hashMap2.put("desc", (String) iVar.ozE.get("desc"));
                hashMap2.put("title", (String) iVar.ozE.get("title"));
                hashMap2.put(SlookSmartClipMetaTag.TAG_TYPE_URL, (String) iVar.ozE.get(SlookSmartClipMetaTag.TAG_TYPE_URL));
                w.i("MicroMsg.MsgHandler", "doSendAppMessage, img_url=%s, desc=%s, title=%s, url=%s", new Object[]{(String) iVar.ozE.get("img_url"), (String) iVar.ozE.get("desc"), (String) iVar.ozE.get("title"), (String) iVar.ozE.get(SlookSmartClipMetaTag.TAG_TYPE_URL)});
                com.tencent.mm.plugin.report.service.g.oUh.a(157, 5, 1, false);
                Intent intent3 = new Intent();
                intent3.putExtra("Select_Conv_Type", 3);
                intent3.putExtra("scene_from", 2);
                intent3.putExtra("mutil_select_is_ret", true);
                intent3.putExtra("webview_params", hashMap2);
                intent3.putExtra("Retr_Msg_Type", 2);
                if (this.context instanceof MMActivity) {
                    iVar.smM.put("Internal@AsyncReport", Boolean.valueOf(true));
                    if (bg.getInt((String) iVar.ozE.get("open_from_scene"), 0) == 4) {
                        com.tencent.mm.plugin.report.service.g.oUh.i(10651, new Object[]{Integer.valueOf(5), Integer.valueOf(1), Integer.valueOf(0)});
                    }
                    com.tencent.mm.bb.d.a((MMActivity) this.context, ".ui.transmit.SelectConversationUI", intent3, 1, this);
                }
            }
        }
        return true;
    }

    private boolean a(i iVar, boolean z) {
        Object string;
        int i;
        com.tencent.mm.plugin.webview.ui.tools.jsapi.c.d dVar = null;
        Object obj = iVar.ozE.get("__jsapi_fw_ext_info");
        String str = (String) iVar.ozE.get("link");
        if (obj instanceof Bundle) {
            string = ((Bundle) obj).getString("__jsapi_fw_ext_info_key_current_url");
        } else {
            string = null;
        }
        c cVar = this.skF;
        if (!TextUtils.isEmpty(string)) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.c.d dVar2 = (com.tencent.mm.plugin.webview.ui.tools.jsapi.c.d) cVar.mnj.get(string);
            if (dVar2 == null) {
                dVar2 = (com.tencent.mm.plugin.webview.ui.tools.jsapi.c.d) cVar.mnj.get(c.xI(string));
            }
            dVar = dVar2;
        }
        if (TextUtils.isEmpty(str) || r3 == null || r3.sjK == null || r3.sjK.size() <= 0) {
            i = 0;
        } else {
            int i2;
            List<String> linkedList = new LinkedList();
            int indexOf = str.indexOf("://");
            if (indexOf == -1) {
                i2 = 1;
            } else {
                i2 = 3;
            }
            String substring = str.substring(i2 + indexOf);
            for (String str2 : r3.sjK) {
                String str22;
                w.i("MicroMsg.MsgHandler", "now domain : %s", new Object[]{str22});
                if (!TextUtils.isEmpty(str22)) {
                    int i3;
                    int indexOf2 = str22.indexOf("://");
                    if (indexOf2 == -1) {
                        i3 = 1;
                    } else {
                        i3 = 3;
                    }
                    str22 = str22.substring(i3 + indexOf2);
                    if (!str22.contains("/")) {
                        linkedList.add(str22);
                    } else if (substring.equals(str22)) {
                        i2 = 0;
                        break;
                    } else {
                        if (!str22.endsWith("/")) {
                            str22 = str22 + "/";
                        }
                        if (substring.startsWith(str22)) {
                            i2 = 0;
                            break;
                        }
                    }
                }
            }
            boolean z2 = true;
            if (!(i2 == 0 || linkedList.isEmpty())) {
                String host = URI.create(str).getHost();
                w.i("MicroMsg.MsgHandler", "share domain : %s", new Object[]{host});
                if (!bg.mA(host)) {
                    for (String str3 : linkedList) {
                        if (!host.equals(str3)) {
                            if (host.endsWith("." + str3)) {
                            }
                        }
                        i = 0;
                    }
                }
            }
            i = i2;
        }
        if (!(i == 0 && z)) {
            try {
                Bundle d = this.rXh.d(84, null);
                if (d != null) {
                    if (TextUtils.isEmpty(string)) {
                        string = aj.xH(d.getString("webview_current_url"));
                    }
                    iVar.ozE.put("img_url", "");
                    iVar.ozE.put("link", string);
                    iVar.ozE.put("desc", d.getString("webview_current_desc"));
                    iVar.ozE.put("title", d.getString("webview_current_title"));
                    return true;
                }
            } catch (RemoteException e) {
                w.e("MicroMsg.MsgHandler", "invokeAsResult error : %s", new Object[]{e});
            }
        }
        return false;
    }

    private String bzy() {
        String string = bzx().getString("connector_local_send");
        bzx().remove("connector_local_send");
        bzx().putString("connector_local_report", string);
        return string;
    }

    final String bzz() {
        String string = bzx().getString("connector_local_report");
        bzx().remove("connector_local_report");
        return string;
    }

    private static WXMediaMessage h(i iVar) {
        String str = (String) iVar.ozE.get("link");
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.MsgHandler", "convert fail, link is null");
            return null;
        }
        w.i("MicroMsg.MsgHandler", "rawurl:[%s], shareurl:[%s]", new Object[]{str, aj.xH(str)});
        IMediaObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = r1;
        wXWebpageObject.extInfo = (String) iVar.ozE.get("review_data");
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXWebpageObject;
        wXMediaMessage.title = (String) iVar.ozE.get("title");
        wXMediaMessage.description = (String) iVar.ozE.get("desc");
        return wXMediaMessage;
    }

    public final boolean i(i iVar) {
        this.lre = false;
        String str = (String) iVar.ozE.get("phoneNumber");
        w.d("MicroMsg.MsgHandler", "jsapi makePhoneCall num %s", new Object[]{str});
        if (TextUtils.isEmpty(str)) {
            a(iVar, "makePhoneCall:fail", null);
        } else {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str).toString()));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            if (bg.j(this.context, intent)) {
                this.context.startActivity(intent);
            }
            a(iVar, "makePhoneCall:succ", null);
        }
        return true;
    }

    public final boolean j(i iVar) {
        this.lre = false;
        String str = (String) iVar.ozE.get("selected_user_name");
        Intent intent = new Intent();
        intent.putExtra("list_type", 15);
        intent.putExtra("already_select_contact", str);
        intent.putExtra("titile", this.context.getString(R.l.dCT));
        intent.putExtra("list_attr", s.q(new int[]{16384, 1, 4, 1048576}));
        if (this.context instanceof MMActivity) {
            com.tencent.mm.bb.d.a((MMActivity) this.context, ".ui.contact.SelectContactUI", intent, 54, this);
        }
        return true;
    }

    public final boolean k(i iVar) {
        com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(iVar.ozE);
        Intent intent = new Intent();
        intent.putExtra("appId", bg.ap((String) iVar.ozE.get("appid"), ""));
        intent.putExtra("timeStamp", dVar.timeStamp);
        intent.putExtra("nonceStr", dVar.nonceStr);
        intent.putExtra("packageExt", dVar.packageExt);
        intent.putExtra("signtype", dVar.signType);
        intent.putExtra("paySignature", dVar.fRt);
        intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, dVar.url);
        intent.putExtra("reset_pwd_token", dVar.sYp);
        ((MMActivity) this.context).uSV = this;
        com.tencent.mm.bb.d.b(this.context, "wallet", ".pwd.ui.WalletResetPwdAdapterUI", intent, 55);
        return true;
    }

    public final boolean l(i iVar) {
        String str = (String) iVar.ozE.get("username");
        Kf((String) iVar.ozE.get("scene"));
        return Ki(str);
    }

    public final boolean Ki(final String str) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.MsgHandler", "doProfile fail, username is null");
            this.lre = false;
            return false;
        } else if (bg.mA(str)) {
            Toast.makeText(ab.getContext(), this.context.getString(R.l.elS, new Object[]{Integer.valueOf(3), Integer.valueOf(-1)}), 0).show();
            this.lre = false;
            return false;
        } else {
            if (this.skt != null) {
                k.a(this.skt.smM, Kg("profile"), str, null);
            }
            if (ap.za()) {
                af QZ;
                ap.yY();
                af Rc = com.tencent.mm.u.c.wR().Rc(str);
                if (Rc == null || ((int) Rc.gTQ) <= 0) {
                    ap.yY();
                    QZ = com.tencent.mm.u.c.wR().QZ(str);
                } else {
                    QZ = Rc;
                }
                final Intent intent = new Intent();
                String str2 = "";
                if (!(this.skt == null || this.skt.ozE == null || this.skt.ozE.get("profileReportInfo") == null)) {
                    str2 = (String) this.skt.ozE.get("profileReportInfo");
                }
                if (!bg.mA(str2)) {
                    intent.putExtra("key_add_contact_report_info", str2);
                }
                if (this.skw != null && this.skw.getBoolean("KFromBizSearch")) {
                    intent.putExtra("Contact_Ext_Args", this.skw.getBundle("KBizSearchExtArgs"));
                }
                if (QZ == null || ((int) QZ.gTQ) <= 0) {
                    com.tencent.mm.u.ag.a.hlS.a(str, "", new com.tencent.mm.u.ag.b.a(this) {
                        final /* synthetic */ g sll;

                        public final void p(String str, boolean z) {
                            int i = 42;
                            if (this.sll.context == null) {
                                w.w("MicroMsg.MsgHandler", "getNow callback, msghandler has already been detached!");
                                this.sll.a(this.sll.skt, "profile:fail", null);
                                return;
                            }
                            if (this.sll.isv != null) {
                                this.sll.isv.dismiss();
                            }
                            ap.yY();
                            af Rc = com.tencent.mm.u.c.wR().Rc(str);
                            if (Rc == null || ((int) Rc.gTQ) <= 0) {
                                ap.yY();
                                Rc = com.tencent.mm.u.c.wR().QZ(str);
                            }
                            if (Rc == null || ((int) Rc.gTQ) <= 0) {
                                z = false;
                            } else {
                                str = Rc.field_username;
                            }
                            if (z) {
                                com.tencent.mm.x.b.u(str, 3);
                                n.Bz().hf(str);
                                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                intent.putExtra("Contact_User", str);
                                if (Rc.bLe()) {
                                    if (this.sll.skw != null) {
                                        i = this.sll.skw.getInt("Contact_Scene", 42);
                                    }
                                    com.tencent.mm.plugin.report.service.g.oUh.A(10298, Rc.field_username + "," + i);
                                    intent.putExtra("Contact_Scene", i);
                                }
                                this.sll.W(intent);
                                this.sll.a(this.sll.skt, "profile:ok", null);
                                return;
                            }
                            Toast.makeText(ab.getContext(), this.sll.context.getString(R.l.elS, new Object[]{Integer.valueOf(3), Integer.valueOf(-1)}), 0).show();
                            this.sll.a(this.sll.skt, "profile:fail", null);
                        }
                    });
                    Context context = this.context;
                    this.context.getString(R.l.dIO);
                    this.isv = com.tencent.mm.ui.base.g.a(context, this.context.getString(R.l.dJd), true, new OnCancelListener(this) {
                        final /* synthetic */ g sll;

                        public final void onCancel(DialogInterface dialogInterface) {
                            com.tencent.mm.u.ag.a.hlS.gc(str);
                            this.sll.a(this.sll.skt, "profile:cancel", null);
                        }
                    });
                    return true;
                }
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                intent.putExtra("Contact_User", QZ.field_username);
                if (QZ.bLe()) {
                    int i;
                    if (this.skw == null) {
                        i = 42;
                    } else {
                        i = this.skw.getInt("Contact_Scene", 42);
                    }
                    com.tencent.mm.plugin.report.service.g.oUh.A(10298, QZ.field_username + "," + i);
                    intent.putExtra("Contact_Scene", i);
                }
                if (com.tencent.mm.j.a.ez(QZ.field_type)) {
                    com.tencent.mm.sdk.b.b nzVar = new nz();
                    nzVar.fVf.intent = intent;
                    nzVar.fVf.username = QZ.field_username;
                    com.tencent.mm.sdk.b.a.urY.m(nzVar);
                }
                W(intent);
                a(this.skt, "profile:ok", null);
                return false;
            }
            w.e("MicroMsg.MsgHandler", "doProfile, MMCore.hasCfgDefaultUin() is false");
            this.lre = false;
            return false;
        }
    }

    public final void W(final Intent intent) {
        com.tencent.mm.plugin.webview.ui.tools.d.a(intent.getExtras(), "profile", ".ui.ContactInfoUI", this.rXh, new Runnable(this) {
            final /* synthetic */ g sll;

            public final void run() {
                com.tencent.mm.plugin.webview.a.a.imv.d(intent, this.sll.context);
            }
        });
    }

    public final boolean m(final i iVar) {
        com.tencent.mm.ui.base.h a;
        if (m.ys()) {
            ap.yY();
            ay AH = com.tencent.mm.u.c.wZ().AH("@t.qq.com");
            if (AH == null || bg.mz(AH.name).length() == 0) {
                a = com.tencent.mm.ui.base.g.a(this.context, R.l.fnq, R.l.dIO, new OnClickListener(this) {
                    final /* synthetic */ g sll;

                    {
                        this.sll = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                a.setCancelable(false);
                a.setOnDismissListener(new OnDismissListener(this) {
                    final /* synthetic */ g sll;

                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.sll.a(iVar, "share_weibo:no_weibo", null);
                    }
                });
            } else {
                int i;
                int i2;
                String ap = bg.ap((String) iVar.ozE.get(Columns.TYPE), "40");
                if (ap == null || ap.length() <= 0) {
                    i = 40;
                } else {
                    try {
                        i = bg.getInt(ap, 40);
                    } catch (Exception e) {
                        i = 40;
                    }
                }
                if (i == 11 || i == 20) {
                    i2 = i;
                } else {
                    i2 = 40;
                }
                ap = (String) iVar.ozE.get("content");
                String str = (String) iVar.ozE.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
                if (ap == null || ap.trim().length() == 0) {
                    ap = "";
                }
                if (str == null || str.length() == 0) {
                    w.e("MicroMsg.MsgHandler", "doWeibo fail, invalid argument, content = " + ap + ", url = " + str);
                    a(iVar, "share_weibo:fail_-2", null);
                } else {
                    k.a(iVar.smM, Kg("shareWeibo"), null, null);
                    str = aj.xH(str);
                    Intent intent = new Intent(this.context, ShareToQQWeiboUI.class);
                    intent.putExtra(Columns.TYPE, i2);
                    intent.putExtra("shortUrl", str);
                    intent.putExtra("content", ap);
                    if (this.context instanceof MMActivity) {
                        ((MMActivity) this.context).a(this, intent, 2);
                    }
                }
            }
        } else {
            w.e("MicroMsg.MsgHandler", "doWeibo fail, qq not binded");
            a = com.tencent.mm.ui.base.g.a(this.context, R.l.fns, R.l.dIO, new OnClickListener(this) {
                final /* synthetic */ g sll;

                {
                    this.sll = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.plugin.webview.a.a.imv.h(new Intent(), this.sll.context);
                }
            }, null);
            a.setCancelable(false);
            a.setOnDismissListener(new OnDismissListener(this) {
                final /* synthetic */ g sll;

                public final void onDismiss(DialogInterface dialogInterface) {
                    this.sll.a(iVar, "share_weibo:not_bind_qq", null);
                }
            });
        }
        return true;
    }

    public final boolean c(i iVar, JsapiPermissionWrapper jsapiPermissionWrapper) {
        a(iVar, jsapiPermissionWrapper.nw(88));
        this.fNK = h(iVar);
        if (this.fNK == null) {
            w.e("MicroMsg.MsgHandler", "doTimeline fail, appmsg is null");
        }
        String str = (String) iVar.ozE.get("link");
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.MsgHandler", "doTimeline fail, link is null");
            a(iVar, "share_timeline:fail", null);
            return true;
        }
        String str2;
        String str3 = (String) iVar.ozE.get("desc");
        if (str3 != null) {
            truncate(str3);
        }
        w.i("MicroMsg.MsgHandler", "doTimeline, img_url = " + ((String) iVar.ozE.get("img_url")) + ", title = " + ((String) iVar.ozE.get("title")) + ", desc = " + ((String) iVar.ozE.get("desc")));
        int i = 1;
        String str4 = "";
        int i2 = 0;
        if (this.skw != null) {
            this.skw.setClassLoader(getClass().getClassLoader());
            i = this.skw.getInt("snsWebSource", 1);
            str4 = this.skw.getString("jsapi_args_appid");
            i2 = bg.getInt(this.skw.getString("urlAttribute"), 0);
            this.skw.remove("urlAttribute");
        }
        int i3 = i2;
        int i4 = i;
        str3 = str4;
        if (bg.mA(str3)) {
            str2 = (String) iVar.ozE.get("appid");
        } else {
            str2 = str3;
        }
        k.a(iVar.smM, Kg("shareTimeline"), str, str2);
        str3 = (String) iVar.ozE.get("img_width");
        str4 = (String) iVar.ozE.get("img_height");
        String xH = aj.xH((String) iVar.ozE.get("link"));
        w.i("MicroMsg.MsgHandler", "doTimeline, rawUrl:[%s], shareUrl:[%s]", new Object[]{r3, xH});
        String str5 = (String) iVar.ozE.get(Columns.TYPE);
        iVar.ozE.get("desc");
        String str6 = (String) iVar.ozE.get("title");
        String str7 = (String) iVar.ozE.get("img_url");
        String str8 = (String) iVar.ozE.get("src_username");
        String str9 = (String) iVar.ozE.get("src_displayname");
        try {
            i2 = Integer.valueOf(str3).intValue();
            try {
                Integer.valueOf(str4);
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            i2 = -1;
        }
        w.i("MicroMsg.MsgHandler", "doTimeline, init intent");
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_width", i2);
        intent.putExtra("Ksnsupload_height", i2);
        intent.putExtra("Ksnsupload_link", xH);
        intent.putExtra("Ksnsupload_title", str6);
        intent.putExtra("Ksnsupload_imgurl", str7);
        intent.putExtra("Ksnsupload_contentattribute", i3);
        if (o.eV(str8)) {
            intent.putExtra("src_username", str8);
            intent.putExtra("src_displayname", str9);
        }
        intent.putExtra("Ksnsupload_source", i4);
        intent.putExtra("Ksnsupload_type", 1);
        if (!bg.mA(str5) && str5.equals("music")) {
            intent.putExtra("ksnsis_music", true);
        }
        if (!bg.mA(str5) && str5.equals(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
            intent.putExtra("ksnsis_video", true);
        }
        if (str2 != null && str2.length() > 0) {
            intent.putExtra("Ksnsupload_appid", str2);
        }
        str4 = "MicroMsg.MsgHandler";
        str5 = "doTimeline, init intent, jsapiArgs == null ? %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.skw == null);
        w.i(str4, str5, objArr);
        str3 = null;
        if (this.skw != null) {
            str4 = this.skw.getString("K_sns_thumb_url");
            str5 = this.skw.getString("K_sns_raw_url");
            str6 = bg.ap(this.skw.getString("KSnsStrId"), "");
            str7 = bg.ap(this.skw.getString("KSnsLocalId"), "");
            str3 = this.skw.getString("key_snsad_statextstr");
            intent.putExtra("key_snsad_statextstr", str3);
            w.i("MicroMsg.MsgHandler", "currentUrl %s contentUrl %s thumbUrl %s", new Object[]{str, str5, str4});
            if (!(str5 == null || str == null || !str5.equals(str))) {
                intent.putExtra("KlinkThumb_url", str4);
            }
            intent.putExtra("KSnsStrId", str6);
            intent.putExtra("KSnsLocalId", str7);
            Parcelable parcelable = this.skw.getParcelable("KSnsAdTag");
            w.i("MicroMsg.MsgHandler", "doTimeline, snsAdTag : %s", new Object[]{parcelable});
            if (parcelable != null && (parcelable instanceof SnsAdClick)) {
                intent.putExtra("KsnsAdTag", (SnsAdClick) parcelable);
            }
            if (str6 != null && this.skw.getBoolean("KFromTimeline", false)) {
                com.tencent.mm.sdk.b.b owVar = new ow();
                owVar.fVQ.fVJ = str6;
                owVar.fVQ.fGN = str7;
                com.tencent.mm.sdk.b.a.urY.m(owVar);
            }
        }
        try {
            intent.putExtra("ShareUrlOriginal", this.rXh.bxj());
            Bundle d = this.rXh.d(18, null);
            intent.putExtra("KPublisherId", d == null ? "" : bg.mz(d.getString("KPublisherId")));
            str = this.rXh.VD();
            intent.putExtra("ShareUrlOpen", str);
            intent.putExtra("JsAppId", this.skF.JZ(str));
        } catch (Throwable e3) {
            w.printErrStackTrace("MicroMsg.MsgHandler", e3, "", new Object[0]);
        }
        w.i("MicroMsg.MsgHandler", "doTimeline, start activity");
        if (this.context instanceof MMActivity) {
            intent.putExtra("need_result", true);
            try {
                d = this.rXh.d(18, null);
                if (d != null) {
                    str4 = q.fQ(bg.mz(d.getString("KPublisherId")));
                    com.tencent.mm.u.q.b n = q.yC().n(str4, true);
                    n.l("sendAppMsgScene", Integer.valueOf(2));
                    n.l("preChatName", d.getString("preChatName"));
                    n.l("preMsgIndex", Integer.valueOf(d.getInt("preMsgIndex")));
                    n.l("prePublishId", d.getString("prePublishId"));
                    n.l("preUsername", d.getString("preUsername"));
                    n.l(SlookSmartClipMetaTag.TAG_TYPE_URL, xH);
                    n.l("getA8KeyScene", Integer.valueOf(d.getInt("getA8KeyScene")));
                    n.l("referUrl", d.getString("referUrl"));
                    if (!bg.mA(str3)) {
                        n.l("adExtStr", str3);
                    }
                    intent.putExtra("reportSessionId", str4);
                }
            } catch (RemoteException e4) {
                w.e("MicroMsg.MsgHandler", "try to attach report args error, %s", new Object[]{e4});
            }
            ((MMActivity) this.context).uSV = this;
            com.tencent.mm.bb.d.a(this.context, "sns", ".ui.En_c4f742e5", intent, 24, false);
        }
        return true;
    }

    public final boolean n(i iVar) {
        String str = (String) iVar.ozE.get("ad_info");
        String str2 = str + ",";
        String xL = m.xL();
        try {
            String str3;
            Bundle bundle;
            Bundle d = this.rXh.d(18, null);
            if (d != null) {
                String string = d.getString("prePublishId");
                String string2 = d.getString("preChatName");
                String string3 = d.getString("preUsername");
                str3 = str2 + string + "," + string2 + "," + string3 + "," + d.getInt("getA8KeyScene") + ",";
                if (string != null) {
                    try {
                        if (string.startsWith("msg_")) {
                            long parseLong = Long.parseLong(string.substring(4));
                            ap.yY();
                            ce x = com.tencent.mm.u.c.wT().x(string2, parseLong);
                            str3 = str3 + x.field_type + "," + j.eC(x.field_talker) + "," + p.G(string3, string2) + "," + ai.bwu() + ",";
                            str3 = str3 + xL;
                            ((com.tencent.mm.plugin.sns.b.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.sns.b.a.class)).bD(str3, (int) bg.Ny());
                            if (Integer.parseInt(bg.ap((String) iVar.ozE.get("need_record_page_operation"), "0")) != 0) {
                                bundle = new Bundle();
                                bundle.putString("traceid", str);
                                bundle.putString("username", xL);
                                try {
                                    this.rXh.d(90002, bundle);
                                } catch (RemoteException e) {
                                }
                            }
                            a(iVar, "adDataReport：ok", null);
                            return true;
                        }
                    } catch (Throwable e2) {
                        Throwable th = e2;
                        str2 = str3;
                        w.printErrStackTrace("MicroMsg.MsgHandler", th, "", new Object[0]);
                    }
                }
                str3 = str3 + ",,,,";
                str3 = str3 + xL;
                ((com.tencent.mm.plugin.sns.b.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.sns.b.a.class)).bD(str3, (int) bg.Ny());
                if (Integer.parseInt(bg.ap((String) iVar.ozE.get("need_record_page_operation"), "0")) != 0) {
                    bundle = new Bundle();
                    bundle.putString("traceid", str);
                    bundle.putString("username", xL);
                    this.rXh.d(90002, bundle);
                }
                a(iVar, "adDataReport：ok", null);
                return true;
            }
            str3 = str2;
            ((com.tencent.mm.plugin.sns.b.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.sns.b.a.class)).bD(str3, (int) bg.Ny());
            if (Integer.parseInt(bg.ap((String) iVar.ozE.get("need_record_page_operation"), "0")) != 0) {
                bundle = new Bundle();
                bundle.putString("traceid", str);
                bundle.putString("username", xL);
                this.rXh.d(90002, bundle);
            }
            a(iVar, "adDataReport：ok", null);
        } catch (Throwable e3) {
            w.printErrStackTrace("MicroMsg.MsgHandler", e3, "", new Object[0]);
            a(iVar, "adDataReport：fail", null);
        }
        return true;
    }

    public final boolean o(i iVar) {
        w.i("MicroMsg.MsgHandler", "doGoVideoPlayerUI");
        String str = (String) iVar.ozE.get("streamingUrl");
        int i = (int) bg.getDouble((String) iVar.ozE.get("streamingVideoTime"), 0.0d);
        String str2 = (String) iVar.ozE.get("btnTitle");
        String str3 = (String) iVar.ozE.get("jumpUrl");
        String str4 = (String) iVar.ozE.get("shareTitle");
        String str5 = (String) iVar.ozE.get("shareThumbUrl");
        int i2 = bg.getInt((String) iVar.ozE.get("shareBtnHidden"), 0);
        String str6 = (String) iVar.ozE.get("reportArgs");
        int i3 = bg.getInt((String) iVar.ozE.get("needReportData"), 0);
        Intent intent = new Intent();
        intent.putExtra("IsAd", true);
        intent.putExtra("KStremVideoUrl", str);
        intent.putExtra("StreamWording", str2);
        intent.putExtra("StremWebUrl", str3);
        intent.putExtra("KThumUrl", str5);
        intent.putExtra("KMediaId", "fakeid_" + str5.hashCode());
        intent.putExtra("KMediaVideoTime", i);
        intent.putExtra("KMediaTitle", str4);
        intent.putExtra("ShareBtnHidden", i2);
        intent.putExtra("ReportArgs", str6);
        intent.putExtra("NeedReportData", i3);
        com.tencent.mm.bb.d.b(this.context, "sns", ".ui.VideoAdPlayerUI", intent);
        a(iVar, "playStreamingVideo:ok", null);
        return true;
    }

    public final boolean p(i iVar) {
        try {
            if (this.rXh != null) {
                Bundle d = this.rXh.d(87, null);
                if (d != null) {
                    if (bg.mz(d.getString("result")).equals("not_return")) {
                        a(iVar, "getWePkgAuthResult:fail_auth_result_not_return", null);
                    } else {
                        String string = d.getString("full_url");
                        int i = d.getInt("set_cookie");
                        if (bg.mA(string)) {
                            a(iVar, "getWePkgAuthResult:fail_full_url_empty", null);
                        } else {
                            Map hashMap = new HashMap();
                            hashMap.put("full_url", string);
                            hashMap.put("set_cookie", Integer.valueOf(i));
                            a(iVar, "getWePkgAuthResult:ok", hashMap);
                        }
                    }
                }
            }
        } catch (Exception e) {
            w.e("MicroMsg.MsgHandler", "doGetWePkgAuthResult exception, " + e.getMessage());
            a(iVar, "getWePkgAuthResult:fail", null);
        }
        return true;
    }

    public final boolean q(final i iVar) {
        w.i("MicroMsg.MsgHandler", "getLocalWePkgInfo call");
        com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
            final /* synthetic */ g sll;

            public final void run() {
                com.tencent.mm.plugin.webview.wepkg.model.g.a(new com.tencent.mm.plugin.webview.wepkg.model.g.a(this) {
                    final /* synthetic */ AnonymousClass18 slA;

                    {
                        this.slA = r1;
                    }

                    public final void y(JSONObject jSONObject) {
                        Map hashMap = new HashMap();
                        hashMap.put("wepkg_info", jSONObject);
                        this.slA.sll.a(iVar, "getLocalWePkgInfo:ok", hashMap);
                    }
                });
            }
        });
        return true;
    }

    public final boolean r(i iVar) {
        boolean z = false;
        String str = (String) iVar.ozE.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bg.mA(str)) {
            w.e("MicroMsg.MsgHandler", "url is null or nil");
            a(iVar, "openGameWebView:fail_invalid_url", null);
        } else {
            int i;
            boolean z2;
            String mz;
            Intent intent;
            com.tencent.mm.sdk.b.b giVar;
            String mz2 = bg.mz((String) iVar.ozE.get("orientation"));
            if (!bg.mA(mz2)) {
                if (mz2.equals("horizontal")) {
                    i = 0;
                } else if (mz2.equals("vertical")) {
                    i = 1;
                } else if (mz2.equals("sensor")) {
                    i = 4;
                }
                if (bg.mz((String) iVar.ozE.get("fullscreen")).equals("true")) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (bg.mz((String) iVar.ozE.get("disable_swipe_back")).equals("1")) {
                    z = true;
                }
                mz = bg.mz((String) iVar.ozE.get("gameAppid"));
                intent = new Intent();
                intent.putExtra("rawUrl", str);
                intent.putExtra("geta8key_scene", 32);
                intent.putExtra("KPublisherId", "game_webview");
                intent.putExtra("screen_orientation", i);
                intent.putExtra("show_full_screen", z2);
                intent.putExtra("disable_swipe_back", z);
                intent.putExtra("game_hv_menu_appid", mz);
                if (QbSdk.getTbsVersion(this.context) < 43114) {
                    com.tencent.mm.bb.d.b(this.context, "game", ".gamewebview.ui.GameWebViewUI", intent);
                } else {
                    com.tencent.mm.bb.d.b(this.context, "webview", ".ui.tools.game.GameWebViewUI", intent);
                }
                giVar = new gi();
                giVar.fLC.ou = 2;
                giVar.fLC.fLE = mz;
                com.tencent.mm.sdk.b.a.urY.m(giVar);
                a(iVar, "openGameWebView:ok", null);
            }
            i = -1;
            if (bg.mz((String) iVar.ozE.get("fullscreen")).equals("true")) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (bg.mz((String) iVar.ozE.get("disable_swipe_back")).equals("1")) {
                z = true;
            }
            mz = bg.mz((String) iVar.ozE.get("gameAppid"));
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("geta8key_scene", 32);
            intent.putExtra("KPublisherId", "game_webview");
            intent.putExtra("screen_orientation", i);
            intent.putExtra("show_full_screen", z2);
            intent.putExtra("disable_swipe_back", z);
            intent.putExtra("game_hv_menu_appid", mz);
            if (QbSdk.getTbsVersion(this.context) < 43114) {
                com.tencent.mm.bb.d.b(this.context, "webview", ".ui.tools.game.GameWebViewUI", intent);
            } else {
                com.tencent.mm.bb.d.b(this.context, "game", ".gamewebview.ui.GameWebViewUI", intent);
            }
            giVar = new gi();
            giVar.fLC.ou = 2;
            giVar.fLC.fLE = mz;
            com.tencent.mm.sdk.b.a.urY.m(giVar);
            a(iVar, "openGameWebView:ok", null);
        }
        return true;
    }

    private static String truncate(String str) {
        if (str.startsWith("http://")) {
            return str.substring(7);
        }
        if (str.startsWith("https://")) {
            return str.substring(8);
        }
        return str;
    }

    public final boolean s(final i iVar) {
        int i = 33;
        String str = (String) iVar.ozE.get("webtype");
        String str2 = (String) iVar.ozE.get("username");
        String str3 = (String) iVar.ozE.get("scene");
        String str4 = (String) iVar.ozE.get("profileReportInfo");
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
            Kf(str3);
            int i2 = bg.getInt(str, -1);
            if (i2 != -1) {
                k.a(iVar.smM, false, str2, null);
                switch (i2) {
                    case 1:
                        if (this.skw != null) {
                            i = this.skw.getInt("Contact_Scene", 33);
                        }
                        new com.tencent.mm.pluginsdk.ui.applet.b(this.context, str2, i, new com.tencent.mm.pluginsdk.ui.applet.b.a(this) {
                            final /* synthetic */ g sll;

                            public final void pb(int i) {
                                switch (i) {
                                    case -2:
                                        this.sll.a(iVar, "add_contact:added", null);
                                        return;
                                    case -1:
                                        this.sll.a(iVar, "add_contact:fail", null);
                                        return;
                                    case 0:
                                        this.sll.a(iVar, "add_contact:cancel", null);
                                        return;
                                    case 1:
                                        this.sll.a(iVar, "add_contact:ok", null);
                                        return;
                                    default:
                                        this.sll.a(iVar, "add_contact:fail", null);
                                        return;
                                }
                            }
                        }, str4).show();
                        break;
                    default:
                        w.e("MicroMsg.MsgHandler", "unknown addScene = " + i2);
                        a(iVar, "add_contact:fail", null);
                        break;
                }
            }
            w.e("MicroMsg.MsgHandler", "doAddContact fail, parseInt fail, str = " + str);
            a(iVar, "add_contact:fail", null);
        } else {
            w.e("MicroMsg.MsgHandler", "doAddContact fail, invalid arguments, webType = " + str + ", username = " + str2);
            a(iVar, "add_contact:fail", null);
        }
        return true;
    }

    public final boolean t(i iVar) {
        String str = (String) iVar.ozE.get("current");
        String[] strArr = (String[]) iVar.ozE.get("urls");
        ArrayList arrayList = new ArrayList();
        if (strArr == null || strArr.length == 0) {
            w.e("MicroMsg.MsgHandler", "doImgPreview fail, urls is null");
            this.lre = false;
        } else {
            Bundle d;
            w.d("MicroMsg.MsgHandler", "doImgPreview ok");
            int i = 0;
            while (i < strArr.length) {
                if (bg.mA(strArr[i]) || strArr[i].equalsIgnoreCase("null")) {
                    w.e("MicroMsg.MsgHandler", "null url, i = %d", new Object[]{Integer.valueOf(i)});
                } else {
                    if (bg.mz(strArr[i]).startsWith("weixin://resourceid/")) {
                        strArr[i] = com.tencent.mm.plugin.webview.d.f.bwZ().IS(strArr[i]).iDA;
                    }
                    arrayList.add(strArr[i]);
                }
                i++;
            }
            strArr = (String[]) arrayList.toArray(strArr);
            String[] strArr2 = (String[]) arrayList.toArray(new String[arrayList.size()]);
            if (bg.mA(str)) {
                str = strArr[0];
            } else if (str.startsWith("weixin://resourceid/")) {
                str = com.tencent.mm.plugin.webview.d.f.bwZ().IS(str).iDA;
            }
            Intent intent = new Intent();
            intent.putExtra("nowUrl", str);
            intent.putExtra("urlList", strArr2);
            intent.putExtra(Columns.TYPE, -255);
            intent.putExtra("isFromWebView", true);
            intent.putExtra("shouldShowScanQrCodeMenu", true);
            try {
                d = this.rXh.d(90001, new Bundle());
                if (d != null) {
                    str = d.getString("cookie", null);
                    if (!bg.mA(str)) {
                        intent.putExtra("cookie", str);
                    }
                }
            } catch (Exception e) {
                w.e("MicroMsg.MsgHandler", "getCookie fail : %s", new Object[]{e.getMessage()});
            }
            if (this.context instanceof Service) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            d = new Bundle();
            d.putInt("stat_scene", 4);
            d.putString("stat_url", VD());
            intent.putExtra("_stat_obj", d);
            com.tencent.mm.plugin.webview.a.a.imv.u(intent, this.context);
            this.lre = false;
        }
        return false;
    }

    public final boolean u(i iVar) {
        w.i("MicroMsg.MsgHandler", "jslog : " + iVar.ozE.get("msg"));
        this.lre = false;
        return false;
    }

    public final boolean v(i iVar) {
        if (am.isConnected(this.context)) {
            w.i("MicroMsg.MsgHandler", "getNetworkType, type = " + am.getNetType(this.context));
            Map hashMap = new HashMap();
            if (am.is2G(this.context)) {
                w.i("MicroMsg.MsgHandler", "getNetworkType, 2g");
                hashMap.put("subtype", "2g");
                a(iVar, "network_type:wwan", hashMap);
            } else if (am.is3G(this.context)) {
                w.i("MicroMsg.MsgHandler", "getNetworkType, 3g");
                hashMap.put("subtype", "3g");
                a(iVar, "network_type:wwan", hashMap);
            } else if (am.is4G(this.context)) {
                w.i("MicroMsg.MsgHandler", "getNetworkType, 4g");
                hashMap.put("subtype", "4g");
                a(iVar, "network_type:wwan", hashMap);
            } else if (am.isWifi(this.context)) {
                w.i("MicroMsg.MsgHandler", "getNetworkType, wifi");
                a(iVar, "network_type:wifi", null);
            } else {
                w.w("MicroMsg.MsgHandler", "getNetworkType, unknown");
                a(iVar, "network_type:fail", null);
            }
        } else {
            w.i("MicroMsg.MsgHandler", "getNetworkType, not connected");
            a(iVar, "network_type:fail", null);
        }
        return true;
    }

    public final boolean w(i iVar) {
        try {
            Bundle Y = i.Y(iVar.ozE);
            this.rXh.bxl();
            this.rXh.M(Y);
            com.tencent.mm.sdk.b.a.urY.m(new sq());
        } catch (Exception e) {
            w.w("MicroMsg.MsgHandler", "doCloseWindow, ex = " + e.getMessage());
        }
        a(iVar, "close_window:ok", null);
        return true;
    }

    public final boolean x(i iVar) {
        w.i("MicroMsg.MsgHandler", "hy: start soter auth");
        ((MMActivity) this.context).uSV = this;
        Bundle Y = i.Y(iVar.ozE);
        Intent intent = new Intent();
        intent.putExtras(Y);
        intent.putExtra("key_soter_fp_mp_scene", 0);
        String pH = pH(VD());
        if (pH == null) {
            pH = (String) iVar.ozE.get("appId");
        }
        intent.putExtra("key_app_id", pH);
        com.tencent.mm.bb.d.b(this.context, "soter_mp", ".ui.SoterAuthenticationUI", intent, 38);
        return true;
    }

    public final boolean y(i iVar) {
        int i;
        w.i("MicroMsg.MsgHandler", "hy: do get soter support");
        com.tencent.mm.sdk.b.b heVar = new he();
        com.tencent.mm.sdk.b.a.urY.m(heVar);
        Map hashMap = new HashMap();
        hashMap.put("support_mode", Integer.valueOf(heVar.fME.fMF));
        a(iVar, "getSupportSoter", hashMap);
        if (heVar.fME.fMF == 1) {
            i = 1;
        } else {
            i = 0;
        }
        a(iVar, 0, i);
        return true;
    }

    public final void a(i iVar, int i, int i2) {
        String str = iVar.smN;
        if (str.equals("requireSoterBiometricAuthentication") || str.equals("getSupportSoter")) {
            String pH = pH(VD());
            com.tencent.mm.plugin.soter.c.f fVar = com.tencent.mm.plugin.soter.c.f.qQb;
            com.tencent.mm.plugin.soter.c.f.l(str, pH, i, i2);
        }
    }

    public final boolean z(i iVar) {
        w.i("MicroMsg.MsgHandler", "hy: start do check is support face detect");
        com.tencent.mm.sdk.b.b hdVar = new hd();
        com.tencent.mm.sdk.b.a.urY.m(hdVar);
        boolean z = hdVar.fMz.fMA;
        int i = hdVar.fMz.fMB;
        w.i("MicroMsg.MsgHandler", "hy: is support: %b, errCode: %d, errMsg: %s, ilbVersion: %d", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), hdVar.fMz.fMC, Integer.valueOf(hdVar.fMz.fMD)});
        Map hashMap = new HashMap();
        hashMap.put("err_code", String.valueOf(i));
        hashMap.put("err_msg", r3);
        hashMap.put("lib_version_code", String.valueOf(r0));
        a(iVar, "doCheckIsSupportFaceDetect: ok", hashMap);
        return true;
    }

    public final boolean A(i iVar) {
        ((MMActivity) this.context).uSV = this;
        Bundle bundle = new Bundle();
        bundle.putBoolean("k_need_signature", true);
        bundle.putInt("k_server_scene", 3);
        bundle.putBoolean("key_is_need_video", false);
        bundle.putBoolean("is_check_dyncfg", false);
        bundle.putString("k_ticket", (String) iVar.ozE.get("request_ticket"));
        com.tencent.mm.sdk.b.b mrVar = new mr();
        mrVar.fTX.context = this.context;
        mrVar.fTX.fTZ = 50;
        mrVar.fTX.extras = bundle;
        com.tencent.mm.sdk.b.a.urY.m(mrVar);
        w.i("MicroMsg.MsgHandler", "hy: start face register rsa event result: %b", new Object[]{Boolean.valueOf(mrVar.fTY.fUa)});
        if (!mrVar.fTY.fUa) {
            ((MMActivity) this.context).uSV = null;
            a(iVar, "requestWxFaceRegisterInternal:fail", i.W(mrVar.fTY.extras));
        }
        return true;
    }

    public final boolean B(i iVar) {
        long PZ;
        int PY;
        int PY2;
        if (iVar.ozE.containsKey("canvasId")) {
            PZ = bg.PZ(iVar.ozE.get("canvasId").toString());
        } else {
            PZ = 0;
        }
        if (iVar.ozE.containsKey("preLoad")) {
            PY = bg.PY(iVar.ozE.get("preLoad").toString());
        } else {
            PY = 0;
        }
        if (iVar.ozE.containsKey("noStore")) {
            PY2 = bg.PY(iVar.ozE.get("noStore").toString());
        } else {
            PY2 = 0;
        }
        String str = "";
        if (iVar.ozE.containsKey("extraData")) {
            str = iVar.ozE.get("extraData").toString();
        }
        w.i("MicroMsg.MsgHandler", "doOpenCanvas id %d,preLoad %d, noStore %d, extra %s ", new Object[]{Long.valueOf(PZ), Integer.valueOf(PY), Integer.valueOf(PY2), str});
        Map hashMap = new HashMap();
        if (PZ == 0) {
            hashMap.put("ret", Integer.valueOf(-1));
            hashMap.put("ret_msg", "invalid page id = " + PZ);
            a(iVar, "doOpenCanvas:fail", hashMap);
            return false;
        }
        com.tencent.mm.sdk.b.b kmVar = new km();
        kmVar.fQS.fQU = PZ;
        kmVar.fQS.fQV = PY;
        kmVar.fQS.fQW = PY2;
        com.tencent.mm.sdk.b.a.urY.m(kmVar);
        if (PY != 1) {
            String str2 = kmVar.fQT.fQX;
            Intent intent = new Intent();
            intent.putExtra("sns_landig_pages_from_source", 13);
            String str3 = "sns_landing_pages_xml";
            if (str2 == null) {
                str2 = "";
            }
            intent.putExtra(str3, str2);
            intent.putExtra("sns_landing_pages_pageid", PZ);
            intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
            intent.putExtra("sns_landing_pages_extra", str);
            intent.putExtra("sns_landing_pages_no_store", PY2);
            com.tencent.mm.bb.d.b(this.context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
        }
        hashMap.put("ret", Integer.valueOf(0));
        a(iVar, "doOpenCanvas:succ", hashMap);
        return true;
    }

    public final boolean C(i iVar) {
        ((MMActivity) this.context).uSV = this;
        Bundle bundle = new Bundle();
        bundle.putBoolean("k_need_signature", true);
        bundle.putString("k_user_name", ao.hlW.A("login_user_name", ""));
        bundle.putInt("k_server_scene", 4);
        bundle.putBoolean("key_is_need_video", false);
        bundle.putBoolean("is_check_dyncfg", false);
        bundle.putString("k_ticket", (String) iVar.ozE.get("request_ticket"));
        com.tencent.mm.sdk.b.b mrVar = new mr();
        mrVar.fTX.context = this.context;
        mrVar.fTX.fTZ = 51;
        mrVar.fTX.extras = bundle;
        com.tencent.mm.sdk.b.a.urY.m(mrVar);
        w.i("MicroMsg.MsgHandler", "hy: start face verify rsa event result: %b", new Object[]{Boolean.valueOf(mrVar.fTY.fUa)});
        if (!mrVar.fTY.fUa) {
            ((MMActivity) this.context).uSV = null;
            a(iVar, "requestWxFaceVerifyInternal:fail", i.W(mrVar.fTY.extras));
        }
        return true;
    }

    public final boolean b(i iVar, boolean z) {
        int i;
        ((MMActivity) this.context).uSV = this;
        if (z) {
            i = 49;
        } else {
            i = 48;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("k_need_signature", true);
        bundle.putString("k_user_name", m.xO());
        bundle.putInt("k_server_scene", 2);
        bundle.putBoolean("key_is_need_video", z);
        bundle.putBoolean("is_check_dyncfg", false);
        bundle.putString("key_function_name", iVar.smN);
        bundle.putInt("key_business_type", 1);
        w.v("MicroMsg.MsgHandler", "alvinluo facedetect current url: %s", new Object[]{VD()});
        String pH = pH(pH);
        if (pH == null) {
            pH = (String) iVar.ozE.get("appId");
        }
        bundle.putString("k_app_id", pH);
        bundle.putString("request_verify_pre_info", (String) iVar.ozE.get("request_verify_pre_info"));
        com.tencent.mm.sdk.b.b mrVar = new mr();
        mrVar.fTX.context = this.context;
        mrVar.fTX.fTZ = i;
        mrVar.fTX.extras = bundle;
        com.tencent.mm.sdk.b.a.urY.m(mrVar);
        w.i("MicroMsg.MsgHandler", "start face detect event result: %b", new Object[]{Boolean.valueOf(mrVar.fTY.fUa)});
        if (!mrVar.fTY.fUa) {
            ((MMActivity) this.context).uSV = null;
            a(iVar, z ? "requestWxFacePictureVerifyUnionVideo:fail" : "requestWxFacePictureVerify:fail", i.W(mrVar.fTY.extras));
        }
        return true;
    }

    public final boolean D(i iVar) {
        String str = (String) iVar.ozE.get(DownloadInfoColumns.PACKAGENAME);
        if (bg.mA(str)) {
            w.i("MicroMsg.MsgHandler", "packageName is null or nil");
            a(iVar, "get_install_state:no", null);
            return true;
        }
        k.a(iVar.smM, false, str, null);
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                Object obj = null;
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getString(i);
                    PackageInfo az = com.tencent.mm.pluginsdk.model.app.p.az(this.context, string);
                    int i2 = az == null ? 0 : az.versionCode;
                    String str2 = az == null ? "null" : az.versionName;
                    w.i("MicroMsg.MsgHandler", "doGetInstallState, packageName = " + string + ", packageInfo = " + az + ", version = " + i2 + ", versionName = " + str2);
                    if (obj == null && i2 > 0) {
                        obj = 1;
                    }
                    jSONObject.put(string, i2);
                    jSONObject2.put(string, str2);
                }
                Map hashMap = new HashMap();
                hashMap.put("result", jSONObject);
                hashMap.put("versionName", jSONObject2);
                if (obj != null) {
                    a(iVar, "get_install_state:yes", hashMap);
                } else {
                    a(iVar, "get_install_state:no", null);
                }
                return true;
            }
        } catch (Exception e) {
            w.i("MicroMsg.MsgHandler", "it is not batch get install state");
        }
        PackageInfo az2 = com.tencent.mm.pluginsdk.model.app.p.az(this.context, str);
        int i3 = az2 == null ? 0 : az2.versionCode;
        String str3 = az2 == null ? "null" : az2.versionName;
        w.i("MicroMsg.MsgHandler", "doGetInstallState, packageName = " + str + ", packageInfo = " + az2 + ", version = " + i3 + ", versionName = " + str3);
        if (az2 == null) {
            a(iVar, "get_install_state:no", null);
        } else {
            Map hashMap2 = new HashMap();
            hashMap2.put("versionName", str3);
            a(iVar, "get_install_state:yes_" + i3, hashMap2);
        }
        return true;
    }

    public final boolean E(final i iVar) {
        final String str = (String) iVar.ozE.get("cardType");
        if (bg.mA(str) || this.context == null) {
            a(iVar, "scanLicence:fail", null);
        } else {
            if (!this.skI.a(str, this.context, new com.tencent.mm.plugin.webview.d.d.a(this) {
                final /* synthetic */ g sll;

                public final void a(String str, JSONObject jSONObject, Bitmap bitmap) {
                    if (!bg.mz(str).equalsIgnoreCase(str)) {
                        w.i("MicroMsg.MsgHandler", "msg.params.cardType = %s, callback type = %s, mismatch!!!", new Object[]{str, str});
                    } else if (jSONObject == null) {
                        w.e("MicroMsg.MsgHandler", "doScanLicence, type = %s, callback onSuccess but result is null", new Object[]{str});
                        FY(str);
                    } else {
                        Map hashMap = new HashMap(2);
                        hashMap.put("cardType", str);
                        hashMap.put("cardInfo", jSONObject);
                        this.sll.a(iVar, "scanLicence:ok", hashMap);
                    }
                }

                public final void Jk(String str) {
                    if (bg.mz(str).equals(str)) {
                        Map hashMap = new HashMap(1);
                        hashMap.put("cardType", str);
                        this.sll.a(iVar, "scanLicence:cancel", hashMap);
                    }
                }

                public final void FY(String str) {
                    if (bg.mz(str).equals(str)) {
                        Map hashMap = new HashMap(1);
                        hashMap.put("cardType", str);
                        this.sll.a(iVar, "scanLicence:fail", hashMap);
                    }
                }
            })) {
                Map hashMap = new HashMap(1);
                hashMap.put("cardType", str);
                a(iVar, "scanLicence:type not supported", hashMap);
            }
        }
        return true;
    }

    public final boolean F(i iVar) {
        boolean z;
        boolean z2;
        int i;
        Intent intent;
        String str = (String) iVar.ozE.get("desc");
        int i2 = bg.getInt((String) iVar.ozE.get("needResult"), 1);
        String str2 = (String) iVar.ozE.get("scanType");
        w.i("MicroMsg.MsgHandler", "desc : %s, scene : %d, scanType : %s", new Object[]{str, Integer.valueOf(i2), str2});
        if (bg.mA(str2)) {
            z = true;
            z2 = true;
        } else {
            z = false;
            z2 = false;
        }
        boolean z3;
        if (str2 != null) {
            try {
                JSONArray jSONArray = new JSONArray(str2);
                z3 = z;
                int i3 = 0;
                while (i3 < jSONArray.length()) {
                    try {
                        str = (String) jSONArray.get(i3);
                        if (str.equalsIgnoreCase("qrCode")) {
                            z = z3;
                            z3 = true;
                        } else if (str.equalsIgnoreCase("barCode")) {
                            z = true;
                            z3 = z2;
                        } else {
                            z = z3;
                            z3 = z2;
                        }
                        i3++;
                        z2 = z3;
                        z3 = z;
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                z3 = z;
                w.e("MicroMsg.MsgHandler", "doScanQRCode, ex in scanType");
                if (!z2) {
                }
                if (!z2) {
                }
                i = 1;
                if (i2 == 0) {
                    w.d("MicroMsg.MsgHandler", "doScanQRCode, startActivity to GetFriendQRCodeUI");
                    intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", i);
                    com.tencent.mm.bb.d.a(this.context, "scanner", ".ui.SingleTopScanUI", intent, false);
                    a(iVar, "scanQRCode:ok", null);
                } else if (i2 != 1) {
                    w.e("MicroMsg.MsgHandler", "unkown scene");
                    a(iVar, "scanQRCode:fail_invalid_scene", null);
                } else {
                    intent = new Intent();
                    intent.putExtra("BaseScanUI_select_scan_mode", i);
                    intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                    intent.putExtra("key_is_finish_on_scanned", true);
                    intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 3);
                    WebViewStubTempUI.a(this.context, "scanner", ".ui.SingleTopScanUI", intent, this.fRO);
                }
                return true;
            }
        }
        z3 = z;
        if (!z2 && !r1) {
            i = 8;
        } else if (z2 || !r1) {
            i = 1;
        } else {
            i = 4;
        }
        if (i2 == 0) {
            w.d("MicroMsg.MsgHandler", "doScanQRCode, startActivity to GetFriendQRCodeUI");
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", i);
            if (!(com.tencent.mm.n.a.aI(this.context) || com.tencent.mm.n.a.aH(this.context))) {
                com.tencent.mm.bb.d.a(this.context, "scanner", ".ui.SingleTopScanUI", intent, false);
            }
            a(iVar, "scanQRCode:ok", null);
        } else if (i2 != 1) {
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", i);
            intent.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
            intent.putExtra("key_is_finish_on_scanned", true);
            intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 3);
            if (!(com.tencent.mm.n.a.aI(this.context) || com.tencent.mm.n.a.aH(this.context))) {
                WebViewStubTempUI.a(this.context, "scanner", ".ui.SingleTopScanUI", intent, this.fRO);
            }
        } else {
            w.e("MicroMsg.MsgHandler", "unkown scene");
            a(iVar, "scanQRCode:fail_invalid_scene", null);
        }
        return true;
    }

    public final boolean G(i iVar) {
        String str = (String) iVar.ozE.get("fontSize");
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.MsgHandler", "doSetFontSizeCb, fontSize is null");
            this.lre = false;
        } else {
            w.i("MicroMsg.MsgHandler", "doSetFontSizeCb, fontSize = " + str);
            try {
                this.rXh.Jn(str);
            } catch (Exception e) {
                w.w("MicroMsg.MsgHandler", "setFontSizeCb, ex = " + e.getMessage());
            }
            this.lre = false;
        }
        return false;
    }

    public final boolean H(i iVar) {
        w.i("MicroMsg.MsgHandler", "doJumpToInstallUrl");
        String str = (String) iVar.ozE.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bg.mA(str)) {
            w.e("MicroMsg.MsgHandler", "jumpurl is null or nil");
            this.lre = false;
        } else {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            if (bg.j(this.context, intent)) {
                this.context.startActivity(intent);
            }
            this.lre = false;
        }
        return false;
    }

    public final boolean I(i iVar) {
        k.a(iVar.smM, false, null, (String) iVar.ozE.get("appId"));
        w.i("MicroMsg.MsgHandler", "doPay");
        if (this.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(iVar.ozE);
            dVar.sYo = 1;
            w.i("MicroMsg.MsgHandler", "doPay, pay channel: %s", new Object[]{Integer.valueOf(dVar.fRx)});
            com.tencent.mm.pluginsdk.wallet.e.a((MMActivity) this.context, dVar, 4, this);
            long j = bg.getLong((String) iVar.ozE.get("message_id"), 0);
            int i = bg.getInt((String) iVar.ozE.get("message_index"), 0);
            com.tencent.mm.plugin.report.service.g.oUh.i(10593, new Object[]{dVar.fRu, dVar.appId, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(dVar.fRv), dVar.url});
            this.skK = cA(iVar);
        }
        return true;
    }

    public final boolean J(i iVar) {
        w.i("MicroMsg.MsgHandler", "doJumpToMall");
        String str = (String) iVar.ozE.get("appId");
        String str2 = (String) iVar.ozE.get("funcId");
        String str3 = (String) iVar.ozE.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        k.a(iVar.smM, false, null, str);
        Intent intent = new Intent();
        intent.putExtra("key_app_id", str);
        intent.putExtra("key_func_id", str2);
        intent.putExtra("key_url", str3);
        if (this.context instanceof MMActivity) {
            ((MMActivity) this.context).uSV = this;
            com.tencent.mm.bb.d.a(this.context, "mall", ".ui.MallIndexUI", intent, 5, false);
        }
        return true;
    }

    public final boolean K(i iVar) {
        w.d("MicroMsg.MsgHandler", "hy: doGetPayResultReq");
        if (this.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(iVar.ozE);
            com.tencent.mm.sdk.b.b kvVar = new kv();
            kvVar.fRs.appId = dVar.appId;
            kvVar.fRs.partnerId = dVar.partnerId;
            kvVar.fRs.signType = dVar.signType;
            kvVar.fRs.nonceStr = dVar.nonceStr;
            kvVar.fRs.timeStamp = dVar.timeStamp;
            kvVar.fRs.packageExt = dVar.packageExt;
            kvVar.fRs.fRt = dVar.fRt;
            kvVar.fRs.url = dVar.url;
            kvVar.fRs.fRu = dVar.fRu;
            kvVar.fRs.fRv = dVar.fRv;
            kvVar.fRs.fRx = dVar.fRx;
            kvVar.fRs.fRw = dVar.fRw;
            com.tencent.mm.sdk.b.a.urY.m(kvVar);
            a(21, -1, null);
        }
        k.a(iVar.smM, false, null, (String) iVar.ozE.get("appId"));
        return true;
    }

    public final boolean L(i iVar) {
        w.i("MicroMsg.MsgHandler", "doOpenProductView");
        String str = (String) iVar.ozE.get("productInfo");
        String str2 = (String) iVar.ozE.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        Integer valueOf = Integer.valueOf(0);
        try {
            valueOf = Integer.valueOf(new JSONObject(str).getInt("product_type"));
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        Intent intent = new Intent();
        intent.putExtra("key_product_info", str);
        intent.putExtra("key_source_url", str2);
        return a(valueOf, 3, 0, null, intent);
    }

    public final boolean M(i iVar) {
        w.i("MicroMsg.MsgHandler", "doOpenProductViewWithPid");
        String str = (String) iVar.ozE.get("pid");
        String str2 = (String) iVar.ozE.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        Integer valueOf = Integer.valueOf(bg.getInt((String) iVar.ozE.get(Columns.TYPE), 0));
        int i = bg.getInt((String) iVar.ozE.get("view_type"), 0);
        String str3 = (String) iVar.ozE.get("ext_info");
        Intent intent = new Intent();
        intent.putExtra("key_product_id", str);
        intent.putExtra("key_source_url", str2);
        return a(valueOf, 8, i, str3, intent);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.lang.Integer r7, int r8, int r9, java.lang.String r10, android.content.Intent r11) {
        /*
        r6 = this;
        r3 = 0;
        r5 = 1;
        r4 = 0;
        r0 = "key_product_scene";
        r11.putExtra(r0, r8);
        r0 = "MicroMsg.MsgHandler";
        r1 = "doOpenProductView, productType = %d";
        r2 = new java.lang.Object[r5];
        r2[r3] = r7;
        com.tencent.mm.sdk.platformtools.w.e(r0, r1, r2);
        r0 = r6.context;
        r0 = r0 instanceof com.tencent.mm.ui.MMActivity;
        if (r0 == 0) goto L_0x005a;
    L_0x001c:
        r0 = r6.context;
        r0 = (com.tencent.mm.ui.MMActivity) r0;
        r0.uSV = r6;
        r0 = r7.intValue();
        switch(r0) {
            case 0: goto L_0x0043;
            case 10000: goto L_0x0092;
            case 20000: goto L_0x0092;
            default: goto L_0x0029;
        };
    L_0x0029:
        r0 = "MicroMsg.MsgHandler";
        r1 = "doOpenProductView fail, productType = %d";
        r2 = new java.lang.Object[r5];
        r2[r3] = r7;
        com.tencent.mm.sdk.platformtools.w.e(r0, r1, r2);
        r0 = 8;
        if (r8 != r0) goto L_0x00a6;
    L_0x003a:
        r0 = r6.skt;
        r1 = "open_product_view_with_id:fail";
        r6.a(r0, r1, r4);
    L_0x0042:
        return r5;
    L_0x0043:
        switch(r9) {
            case 0: goto L_0x0063;
            case 1: goto L_0x0077;
            default: goto L_0x0046;
        };
    L_0x0046:
        r0 = "MicroMsg.MsgHandler";
        r1 = "doOpenProductView fail, productType = %d, viewType = %d";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r2[r3] = r7;
        r3 = java.lang.Integer.valueOf(r9);
        r2[r5] = r3;
        com.tencent.mm.sdk.platformtools.w.e(r0, r1, r2);
    L_0x005a:
        r0 = r6.skt;
        r1 = "open_product_view:fail";
        r6.a(r0, r1, r4);
        goto L_0x0042;
    L_0x0063:
        r0 = r6.context;
        r1 = "product";
        r2 = ".ui.MallProductUI";
        com.tencent.mm.bb.d.b(r0, r1, r2, r11);
        r0 = r6.skt;
        r1 = "open_product_view:ok";
        r6.a(r0, r1, r4);
        goto L_0x0042;
    L_0x0077:
        r0 = "key_Qrcode_Url";
        r11.putExtra(r0, r10);
        r0 = "key_ProductUI_getProductInfoScene";
        r1 = 4;
        r11.putExtra(r0, r1);
        r0 = r6.context;
        r1 = "scanner";
        r2 = ".ui.ProductUI";
        r3 = 10;
        com.tencent.mm.bb.d.b(r0, r1, r2, r11, r3);
        goto L_0x0042;
    L_0x0092:
        r0 = r6.context;
        r1 = "card";
        r2 = ".ui.CardProductUI";
        com.tencent.mm.bb.d.b(r0, r1, r2, r11);
        r0 = r6.skt;
        r1 = "open_product_view:ok";
        r6.a(r0, r1, r4);
        goto L_0x0042;
    L_0x00a6:
        r0 = r6.skt;
        r1 = "open_product_view:fail";
        r6.a(r0, r1, r4);
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.jsapi.g.a(java.lang.Integer, int, int, java.lang.String, android.content.Intent):boolean");
    }

    public final boolean N(i iVar) {
        k.a(iVar.smM, false, null, (String) iVar.ozE.get("appId"));
        w.i("MicroMsg.MsgHandler", "doEditAddress");
        Intent intent = new Intent();
        intent.putExtra("req_url", (String) iVar.ozE.get(SlookSmartClipMetaTag.TAG_TYPE_URL));
        intent.putExtra("req_app_id", (String) iVar.ozE.get("appId"));
        intent.putExtra("launch_from_webview", true);
        if (this.context instanceof MMActivity) {
            ((MMActivity) this.context).uSV = this;
            com.tencent.mm.bb.d.a(this.context, "address", ".ui.WalletSelectAddrUI", intent, 3, false);
        }
        return true;
    }

    public final boolean O(i iVar) {
        k.a(iVar.smM, false, null, (String) iVar.ozE.get("appId"));
        w.i("MicroMsg.MsgHandler", "doChooseInvoiceTitle");
        Intent intent = new Intent();
        intent.putExtra("req_scene", 0);
        intent.putExtra("launch_from_webview", true);
        if (this.context instanceof MMActivity) {
            ((MMActivity) this.context).uSV = this;
            com.tencent.mm.bb.d.a(this.context, "address", ".ui.InvoiceListUI", intent, 56, false);
        }
        return true;
    }

    public final boolean P(i iVar) {
        k.a(iVar.smM, false, null, (String) iVar.ozE.get("appId"));
        w.i("MicroMsg.MsgHandler", "dogetBrandWCPayBindCardRequest JSOAUTH");
        if (this.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(iVar.ozE);
            dVar.fRw = 4;
            com.tencent.mm.pluginsdk.wallet.e.b((MMActivity) this.context, dVar, 7, this);
        }
        return true;
    }

    public final boolean Q(i iVar) {
        w.i("MicroMsg.MsgHandler", "doGetTransferMoneyRequest JSOAUTH");
        k.a(iVar.smM, false, null, (String) iVar.ozE.get("appId"));
        if (this.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(iVar.ozE);
            Intent intent = new Intent();
            intent.putExtra("scene", 3);
            intent.putExtra("appId", dVar.appId);
            intent.putExtra("timeStamp", dVar.timeStamp);
            intent.putExtra("nonceStr", dVar.nonceStr);
            intent.putExtra("packageExt", dVar.packageExt);
            intent.putExtra("signtype", dVar.signType);
            intent.putExtra("paySignature", dVar.fRt);
            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, dVar.url);
            ((MMActivity) this.context).uSV = this;
            com.tencent.mm.bb.d.b(this.context, "remittance", ".ui.RemittanceAdapterUI", intent, 11);
        }
        return true;
    }

    public final boolean R(i iVar) {
        w.i("MicroMsg.MsgHandler", "doOpenWCPaySpecificView");
        k.a(iVar.smM, false, null, (String) iVar.ozE.get("appId"));
        if (this.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(iVar.ozE);
            Intent intent = new Intent();
            intent.putExtra("appId", dVar.appId);
            intent.putExtra("timeStamp", dVar.timeStamp);
            intent.putExtra("nonceStr", dVar.nonceStr);
            intent.putExtra("packageExt", dVar.packageExt);
            intent.putExtra("signtype", dVar.signType);
            intent.putExtra("paySignature", dVar.fRt);
            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, dVar.url);
            ((MMActivity) this.context).uSV = this;
            com.tencent.mm.bb.d.a(this.context, "wallet_index", ".ui.WalletOpenViewProxyUI", intent, 17, false);
        }
        return true;
    }

    public final boolean S(i iVar) {
        w.i("MicroMsg.MsgHandler", "doJumpToWXWallet");
        k.a(iVar.smM, false, null, (String) iVar.ozE.get("appId"));
        if (this.context instanceof MMActivity) {
            Intent intent = new Intent();
            intent.putExtra("key_wallet_region", 1);
            com.tencent.mm.bb.d.a(this.context, "mall", ".ui.MallIndexUI", intent, false);
            a(iVar, "jump_to_wx_wallet:ok", null);
        }
        return true;
    }

    public final boolean T(i iVar) {
        w.i("MicroMsg.MsgHandler", "doOpenWCPaySpecificView JSOAUTH");
        k.a(iVar.smM, false, null, (String) iVar.ozE.get("appId"));
        if (this.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(iVar.ozE);
            Intent intent = new Intent();
            intent.putExtra("appId", dVar.appId);
            intent.putExtra("timeStamp", dVar.timeStamp);
            intent.putExtra("nonceStr", dVar.nonceStr);
            intent.putExtra("packageExt", dVar.packageExt);
            intent.putExtra("signtype", dVar.signType);
            intent.putExtra("paySignature", dVar.fRt);
            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, dVar.url);
            ((MMActivity) this.context).uSV = this;
            com.tencent.mm.bb.d.a(this.context, "wallet_index", ".ui.WalletSendC2CMsgUI", intent, 18, false);
        }
        return true;
    }

    public final boolean U(i iVar) {
        w.i("MicroMsg.MsgHandler", "doVerifyWCPayPassword JSOAUTH");
        k.a(iVar.smM, false, null, (String) iVar.ozE.get("appId"));
        if (this.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(iVar.ozE);
            Intent intent = new Intent();
            intent.putExtra("appId", dVar.appId);
            intent.putExtra("timeStamp", dVar.timeStamp);
            intent.putExtra("nonceStr", dVar.nonceStr);
            intent.putExtra("packageExt", dVar.packageExt);
            intent.putExtra("signtype", dVar.signType);
            intent.putExtra("paySignature", dVar.fRt);
            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, dVar.url);
            intent.putExtra("scene", 1);
            ((MMActivity) this.context).uSV = this;
            com.tencent.mm.bb.d.a(this.context, "wallet_core", ".ui.WalletCheckPwdUI", intent, 20, false);
        }
        return true;
    }

    public final void bzA() {
        com.tencent.mm.sdk.b.a.urY.b(this.psI);
        this.skQ = (LocationManager) this.context.getSystemService("location");
        skE = cA(this.skt);
        this.skB = this.rXh;
        skD = this.context;
        this.sku = this.skt;
    }

    public final boolean a(final i iVar, int... iArr) {
        if (skE != -1) {
            this.skt = wD(skE).skt;
            this.rXh = wD(skE).rXh;
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (VERSION.SDK_INT < 18) {
            a(iVar, "startMonitoringBeacons:system unsupported", null);
        } else {
            if (!(defaultAdapter == null || defaultAdapter.getState() == 12)) {
                if (defaultAdapter.getState() == 10) {
                    a(iVar, "startMonitoringBeacons:bluetooth power off", null);
                } else {
                    a(iVar, "startMonitoringBeacons:bluetooth state unknown", null);
                }
            }
            if (iArr.length == 0) {
                if (!this.skQ.isProviderEnabled("gps")) {
                    a(iVar, "startMonitoringBeacons:location service disable", null);
                }
                SensorManager sensorManager = (SensorManager) skD.getSystemService("sensor");
                sensorManager.registerListener(this.skU, sensorManager.getDefaultSensor(3), 0);
            }
            if (this.skT) {
                a(iVar, "startMonitoringBeacons:already started", null);
            } else {
                this.skT = true;
                a(iVar, "startMonitoringBeacons:ok", null);
            }
            if (!(iVar == null || iVar.ozE == null)) {
                Object obj = iVar.ozE.get("uuid");
                Object obj2 = iVar.ozE.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
                Object obj3 = iVar.ozE.get("ticket");
                String obj4 = obj2 != null ? obj2.toString() : "";
                String obj5 = obj != null ? obj.toString() : "";
                com.tencent.mm.plugin.report.service.g.oUh.i(12101, new Object[]{bg.mz(this.skF.JZ(obj4)), obj4, this.skR, this.skS, obj3 != null ? obj3.toString() : ""});
                new StringBuilder("{\"UUID\":\"").append(obj5).append("\",\"Major\":0,\"Minor\":0").append("}");
                final k xVar = new x(obj4, r4, r1);
                ap.vd().a(1702, new e(this) {
                    final /* synthetic */ g sll;

                    public final void a(int i, int i2, String str, k kVar) {
                        if (i == 0 && i2 == 0) {
                            biv com_tencent_mm_protocal_c_biv = (biv) xVar.hKp.hsk.hsr;
                            if (com_tencent_mm_protocal_c_biv.leR == 0) {
                                List<String> list = com_tencent_mm_protocal_c_biv.uiA;
                                if (list == null || list.isEmpty()) {
                                    this.sll.a(iVar, "startMonitoringBeacons:no uuids", null);
                                } else {
                                    for (String str2 : list) {
                                        g gVar = this.sll;
                                        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                                        if (VERSION.SDK_INT >= 18 && defaultAdapter != null) {
                                            com.tencent.mm.sdk.b.a.urY.b(gVar.psH);
                                            String str22 = bg.mz(str22);
                                            gVar.skL.put(str22, str22);
                                            w.i("MicroMsg.MsgHandler", "[MsgHandler][doStartIBeaconRange]op=true,iBeacon = %s", new Object[]{str22});
                                            Editor edit = ab.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).edit();
                                            edit.putBoolean("isNewScanning", true);
                                            edit.commit();
                                            if (ap.zb()) {
                                                ap.yY();
                                                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCx, Boolean.valueOf(true));
                                            }
                                            com.tencent.mm.sdk.b.b dfVar = new df();
                                            dfVar.fHa.fHc = str22;
                                            dfVar.fHa.fGZ = true;
                                            com.tencent.mm.sdk.b.a.urY.m(dfVar);
                                        }
                                    }
                                }
                            } else {
                                this.sll.a(iVar, "startMonitoringBeacons:system error", null);
                                w.i("MicroMsg.MsgHandler", "verify beacon js permission err:%s", new Object[]{com_tencent_mm_protocal_c_biv.leS});
                            }
                            ap.vd().b(1702, this);
                        }
                    }
                });
                ap.vd().a(xVar, 0);
            }
        }
        return true;
    }

    public final boolean V(i iVar) {
        if (skE != -1) {
            this.skt = wD(skE).skt;
            this.rXh = wD(skE).rXh;
        }
        if (VERSION.SDK_INT >= 18) {
            boolean b;
            com.tencent.mm.sdk.b.a.urY.c(this.psH);
            if (ap.zb()) {
                ap.yY();
                b = bg.b((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uCC, null), false);
            } else {
                b = false;
            }
            for (String str : this.skL.keySet()) {
                com.tencent.mm.sdk.b.b dfVar = new df();
                w.i("MicroMsg.MsgHandler", "[MsgHandler][doStopIBeaconRange]op=false,iBeacon = %s", new Object[]{str});
                dfVar.fHa.fHc = str;
                dfVar.fHa.fGZ = false;
                if (!b) {
                    com.tencent.mm.sdk.b.a.urY.m(dfVar);
                }
            }
            if (ap.zb()) {
                ap.yY();
                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uCx, Boolean.valueOf(false));
            }
            Editor edit = ab.getContext().getSharedPreferences("com.tencent.mm_exdevice_ibeacon_isNewScanning", 4).edit();
            edit.putBoolean("isNewScanning", false);
            edit.commit();
            this.skL.clear();
            this.gKm.clear();
            this.skM.clear();
            this.skN.clear();
            this.skT = false;
            a(iVar, "stopMonitoringBeacons:ok", null);
            this.skT = false;
        }
        if (!(skD == null || this.skU == null)) {
            ((SensorManager) skD.getSystemService("sensor")).unregisterListener(this.skU);
        }
        return true;
    }

    public final boolean bzB() {
        String VD;
        w.i("MicroMsg.MsgHandler", "doGetLatestAddress JSOAUTH");
        String str = "";
        try {
            VD = this.rXh.VD();
        } catch (Exception e) {
            w.w("MicroMsg.MsgHandler", "exception in get currentUrl %s", new Object[]{e.getMessage()});
            VD = str;
        }
        final String str2 = "get_recently_used_address:";
        if (VD == null) {
            a(this.skt, str2 + "fail", null);
        } else {
            final com.tencent.mm.sdk.b.b lnVar = new ln();
            lnVar.fSw.appId = (String) this.skt.ozE.get("appId");
            lnVar.fSw.url = VD;
            lnVar.fSx.errCode = -119;
            lnVar.nFq = new Runnable(this) {
                final /* synthetic */ g sll;

                public final void run() {
                    w.i("MicroMsg.MsgHandler", "JSOAUTH errCode[%s], isAccept[%s]", new Object[]{Integer.valueOf(lnVar.fSx.errCode), Boolean.valueOf(lnVar.fSx.fSy)});
                    if (lnVar.fSx.errCode != -119) {
                        if (lnVar.fSx.errCode != 0) {
                            this.sll.a(this.sll.skt, str2 + "fail", null);
                        } else if (lnVar.fSx.fSy) {
                            Map hashMap = new HashMap();
                            hashMap.put("nationalCode", lnVar.fSx.fSz);
                            hashMap.put("userName", lnVar.fSx.userName);
                            hashMap.put("telNumber", lnVar.fSx.fSA);
                            hashMap.put("addressPostalCode", lnVar.fSx.fSB);
                            hashMap.put("proviceFirstStageName", lnVar.fSx.fSC);
                            hashMap.put("addressCitySecondStageName", lnVar.fSx.fSD);
                            hashMap.put("addressCountiesThirdStageName", lnVar.fSx.fSE);
                            hashMap.put("addressDetailInfo", lnVar.fSx.fSF);
                            this.sll.a(this.sll.skt, str2 + "ok", hashMap);
                        } else {
                            this.sll.a(this.sll.skt, str2 + "cancel", null);
                        }
                    }
                }
            };
            com.tencent.mm.sdk.b.a.urY.a(lnVar, Looper.getMainLooper());
        }
        return true;
    }

    public final boolean W(i iVar) {
        Map hashMap = new HashMap();
        if (com.tencent.mm.pluginsdk.ui.tools.e.sVN == null) {
            w.w("MicroMsg.MsgHandler", "HeadingPitchSensorMgr.instance == null, init here");
            com.tencent.mm.pluginsdk.ui.tools.e eVar = new com.tencent.mm.pluginsdk.ui.tools.e();
            r.a(eVar);
            com.tencent.mm.pluginsdk.ui.tools.e.sVN = eVar;
            eVar.dE(this.context);
            com.tencent.mm.pluginsdk.ui.tools.e.sVN = eVar;
        }
        hashMap.put("heading", Integer.valueOf(com.tencent.mm.pluginsdk.ui.tools.e.sVN.bGz()));
        hashMap.put("pitch", Integer.valueOf(com.tencent.mm.pluginsdk.ui.tools.e.sVN.getPitch()));
        w.i("MicroMsg.MsgHandler", "doGetHeadingAndPitch, heading=[%s], pitch=[%s]", new Object[]{Integer.valueOf(com.tencent.mm.pluginsdk.ui.tools.e.sVN.bGz()), Integer.valueOf(com.tencent.mm.pluginsdk.ui.tools.e.sVN.getPitch())});
        a(iVar, "get_heading_and_pitch:ok", hashMap);
        return true;
    }

    public final boolean X(i iVar) {
        k.a(iVar.smM, Kg("sendEmail"), null, null);
        String str = (String) iVar.ozE.get("title");
        String str2 = "";
        try {
            str2 = aj.xH(this.rXh.VD());
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        Intent intent = new Intent();
        intent.putExtra("composeType", 1);
        intent.putExtra("subject", str);
        intent.putExtra("mail_content", str2);
        com.tencent.mm.bb.d.a(this.context, "qqmail", ".ui.ComposeUI", intent, false);
        a(iVar, "send_email:ok", null);
        return true;
    }

    public final boolean d(final i iVar, final JsapiPermissionWrapper jsapiPermissionWrapper) {
        String str = (String) iVar.ozE.get("appid");
        String str2 = (String) iVar.ozE.get("extInfo");
        if (!am.isNetworkConnected(this.context)) {
            Toast.makeText(this.context, this.context.getString(R.l.eoG), 0).show();
            a(iVar, "add_download_task_straight:fail_network_not_connected", null);
            w.i("MicroMsg.MsgHandler", "doAddDownloadTaskStraight fail, network not ready");
            m(str, com.tencent.mm.plugin.downloader.model.c.kGz, str2);
        } else if (am.isWifi(this.context)) {
            Y(iVar);
        } else {
            com.tencent.mm.ui.base.g.a(this.context, this.context.getString(R.l.flW), this.context.getString(R.l.flX), this.context.getString(R.l.flR), this.context.getString(R.l.dGs), false, new OnClickListener(this) {
                final /* synthetic */ g sll;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.sll.Y(iVar);
                    dialogInterface.dismiss();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ g sll;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    this.sll.a(iVar, "add_download_task_straight:fail_network_not_wifi", null);
                }
            }, R.e.aWu);
        }
        return true;
    }

    public final boolean Y(i iVar) {
        com.tencent.mm.plugin.report.service.g.oUh.a(157, 27, 1, false);
        String str = (String) iVar.ozE.get("task_name");
        String str2 = (String) iVar.ozE.get("task_url");
        String str3 = (String) iVar.ozE.get("alternative_url");
        long j = bg.getLong((String) iVar.ozE.get("task_size"), 0);
        String str4 = (String) iVar.ozE.get("file_md5");
        String str5 = (String) iVar.ozE.get("extInfo");
        String str6 = (String) iVar.ozE.get("fileType");
        String str7 = (String) iVar.ozE.get("appid");
        String str8 = (String) iVar.ozE.get("package_name");
        w.i("MicroMsg.MsgHandler", "doAddDownloadTaskStraight, md5 = " + str4 + ", url = " + str2 + ", extinfo = " + str5 + ", fileType = " + str6);
        ap.yY();
        if (!com.tencent.mm.u.c.isSDCardAvailable()) {
            Toast.makeText(this.context, this.context.getString(R.l.eoI), 0).show();
            a(iVar, "add_download_task_straight:fail_sdcard_not_ready", null);
            m(str7, com.tencent.mm.plugin.downloader.model.c.kGA, str5);
            w.i("MicroMsg.MsgHandler", "doAddDownloadTaskStraight fail, sdcard not ready");
            return true;
        } else if (j > 0 && !com.tencent.mm.compatible.util.f.G(j)) {
            Toast.makeText(this.context, this.context.getString(R.l.eoH), 0).show();
            a(iVar, "add_download_task_straight:fail_sdcard_has_not_enough_space", null);
            m(str7, com.tencent.mm.plugin.downloader.model.c.kGA, str5);
            w.i("MicroMsg.MsgHandler", "doAddDownloadTaskStraight fail, not enough space, require size = " + j);
            return true;
        } else if (bg.mA(str2)) {
            w.e("MicroMsg.MsgHandler", "doAddDownloadTaskStraight fail, url is null");
            a(iVar, "add_download_task_straight:fail_invalid_url", null);
            m(str7, com.tencent.mm.plugin.downloader.model.c.DOWNLOAD_ERR_URL_INVALID, str5);
            return true;
        } else {
            int i = bg.getInt((String) iVar.ozE.get("scene"), 1000);
            com.tencent.mm.sdk.b.b gkVar = new gk();
            gkVar.fLI.url = str2;
            gkVar.fLI.fFW = str4;
            gkVar.fLI.extInfo = str5;
            gkVar.fLI.appId = str7;
            gkVar.fLI.scene = i;
            com.tencent.mm.sdk.b.a.urY.m(gkVar);
            com.tencent.mm.plugin.downloader.model.f.a aVar = new com.tencent.mm.plugin.downloader.model.f.a();
            aVar.tL(str2);
            aVar.tM(str3);
            aVar.be(j);
            aVar.tN(str);
            aVar.tO(str4);
            aVar.setAppId(str7);
            aVar.bl(str8);
            aVar.dn(true);
            aVar.la(bg.getInt(str6, 1));
            aVar.kc(i);
            long a = com.tencent.mm.plugin.downloader.model.e.akM().a(aVar.kHa);
            w.i("MicroMsg.MsgHandler", "doAddDownloadTaskStraight, downloadId = " + a);
            if (a <= 0) {
                w.e("MicroMsg.MsgHandler", "doAddDownloadTaskStraight fail, downloadId = " + a);
                a(iVar, "add_download_task_straight:fail", null);
            } else {
                Map hashMap = new HashMap();
                hashMap.put("download_id", Long.valueOf(a));
                a(iVar, "add_download_task_straight:ok", hashMap);
            }
            return true;
        }
    }

    public final boolean Z(i iVar) {
        String str = (String) iVar.ozE.get("task_name");
        String str2 = (String) iVar.ozE.get("task_url");
        String str3 = (String) iVar.ozE.get("alternative_url");
        long j = bg.getLong((String) iVar.ozE.get("task_size"), 0);
        String str4 = (String) iVar.ozE.get("file_md5");
        String str5 = (String) iVar.ozE.get("extInfo");
        String str6 = (String) iVar.ozE.get("fileType");
        String str7 = (String) iVar.ozE.get("appid");
        String str8 = (String) iVar.ozE.get("package_name");
        String str9 = (String) iVar.ozE.get("thumb_url");
        String str10 = (String) iVar.ozE.get("title");
        w.i("MicroMsg.MsgHandler", "doAddDownloadTask, md5 = " + str4 + ", url = " + str2 + ", extinfo = " + str5 + ", fileType = " + str6);
        if (am.isNetworkConnected(this.context)) {
            ap.yY();
            if (!com.tencent.mm.u.c.isSDCardAvailable()) {
                a(iVar, "add_download_task:fail_sdcard_not_ready", null);
                com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                    final /* synthetic */ g sll;

                    {
                        this.sll = r1;
                    }

                    public final void run() {
                        Toast.makeText(this.sll.context, this.sll.context.getString(R.l.eoI), 0).show();
                    }
                });
                m(str7, com.tencent.mm.plugin.downloader.model.c.kGA, str5);
                w.i("MicroMsg.MsgHandler", "doAddDownloadTask fail, sdcard not ready");
                return true;
            } else if (j > 0 && !com.tencent.mm.compatible.util.f.G(j)) {
                a(iVar, "add_download_task:fail_sdcard_has_not_enough_space", null);
                com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                    final /* synthetic */ g sll;

                    {
                        this.sll = r1;
                    }

                    public final void run() {
                        Toast.makeText(this.sll.context, this.sll.context.getString(R.l.eoH), 0).show();
                    }
                });
                m(str7, com.tencent.mm.plugin.downloader.model.c.kGA, str5);
                w.i("MicroMsg.MsgHandler", "doAddDownloadTask fail, not enough space, require size = " + j);
                return true;
            } else if (bg.mA(str2)) {
                w.e("MicroMsg.MsgHandler", "doAddDownloadTask fail, url is null");
                a(iVar, "add_download_task:fail_invalid_url", null);
                m(str7, com.tencent.mm.plugin.downloader.model.c.DOWNLOAD_ERR_URL_INVALID, str5);
                return true;
            } else {
                Intent intent = new Intent();
                intent.setClass(this.context, WebViewDownloadUI.class);
                intent.putExtra("task_name", str);
                intent.putExtra("task_url", str2);
                intent.putExtra("alternative_url", str3);
                intent.putExtra("task_size", j);
                intent.putExtra("file_md5", str4);
                intent.putExtra("extInfo", str5);
                intent.putExtra("fileType", str6);
                intent.putExtra("appid", str7);
                intent.putExtra("package_name", str8);
                intent.putExtra("thumb_url", str9);
                intent.putExtra("title", str10);
                intent.putExtra("page_url", (String) iVar.ozE.get(SlookSmartClipMetaTag.TAG_TYPE_URL));
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                this.context.startActivity(intent);
                final i iVar2 = iVar;
                this.skV = new com.tencent.mm.sdk.b.c<i>(this) {
                    final /* synthetic */ g sll;

                    private boolean a(i iVar) {
                        if (iVar.fCu.fCv) {
                            w.i("MicroMsg.MsgHandler", "doAddDownloadTask callback, cancel");
                            this.sll.a(iVar2, "add_download_task:cancel", null);
                        } else {
                            if (iVar.fCu.fCw > 0) {
                                Map hashMap = new HashMap();
                                hashMap.put("download_id", Long.valueOf(iVar.fCu.fCw));
                                w.i("MicroMsg.MsgHandler", "doAddDownloadTask callback, ok");
                                this.sll.a(iVar2, "add_download_task:ok", hashMap);
                            } else {
                                w.i("MicroMsg.MsgHandler", "doAddDownloadTask callback, failed");
                                this.sll.a(iVar2, "add_download_task:fail", null);
                            }
                            com.tencent.mm.sdk.b.a.urY.c(this.sll.skV);
                        }
                        return false;
                    }
                };
                com.tencent.mm.sdk.b.a.urY.a(this.skV);
                return true;
            }
        }
        a(iVar, "add_download_task:fail_network_not_connected", null);
        com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
            final /* synthetic */ g sll;

            {
                this.sll = r1;
            }

            public final void run() {
                Toast.makeText(this.sll.context, this.sll.context.getString(R.l.eoG), 0).show();
            }
        });
        w.i("MicroMsg.MsgHandler", "doAddDownloadTask fail, network not ready");
        m(str7, com.tencent.mm.plugin.downloader.model.c.kGz, str5);
        return true;
    }

    private static void m(String str, int i, String str2) {
        com.tencent.mm.sdk.b.b gnVar = new gn();
        gnVar.fLN.appId = str;
        gnVar.fLN.opType = 2;
        gnVar.fLN.fLO = i;
        gnVar.fLN.fFs = str2;
        com.tencent.mm.sdk.b.a.urY.m(gnVar);
    }

    public final boolean aa(i iVar) {
        long j = bg.getLong((String) iVar.ozE.get("download_id"), -1);
        w.i("MicroMsg.MsgHandler", "doCancelDownloadTask, downloadId = " + j);
        if (j <= 0) {
            w.e("MicroMsg.MsgHandler", "doCancelDownloadTask fail, invalid downloadId = " + j);
            a(iVar, "cancel_download_task:fail", null);
        } else {
            int aT = com.tencent.mm.plugin.downloader.model.e.akM().aT(j);
            w.i("MicroMsg.MsgHandler", "doCancelDownloadTask, ret = " + aT);
            if (aT <= 0) {
                a(iVar, "cancel_download_task:fail", null);
            } else {
                a(iVar, "cancel_download_task:ok", null);
            }
        }
        return true;
    }

    public final boolean ab(i iVar) {
        long j = bg.getLong((String) iVar.ozE.get("download_id"), -1);
        w.i("MicroMsg.MsgHandler", "doCancelDownloadTask, downloadId = " + j);
        if (j <= 0) {
            w.e("MicroMsg.MsgHandler", "doCancelDownloadTask fail, invalid downloadId = " + j);
            a(iVar, "pause_download_task:fail", null);
        } else {
            boolean aV = com.tencent.mm.plugin.downloader.model.e.akM().aV(j);
            w.i("MicroMsg.MsgHandler", "doCancelDownloadTask, ret = " + aV);
            if (aV) {
                a(iVar, "pause_download_task:ok", null);
            } else {
                a(iVar, "pause_download_task:fail", null);
            }
        }
        return true;
    }

    public final boolean e(final i iVar, final JsapiPermissionWrapper jsapiPermissionWrapper) {
        String str = (String) iVar.ozE.get("appid");
        String str2 = (String) iVar.ozE.get("extInfo");
        if (!am.isNetworkConnected(this.context)) {
            Toast.makeText(this.context, this.context.getString(R.l.eoG), 0).show();
            a(iVar, "doResumeDownloadTask:fail_network_not_connected", null);
            w.i("MicroMsg.MsgHandler", "doResumeDownloadTask fail, network not ready");
            m(str, com.tencent.mm.plugin.downloader.model.c.kGz, str2);
        } else if (am.isWifi(this.context)) {
            ac(iVar);
        } else {
            com.tencent.mm.ui.base.g.a(this.context, this.context.getString(R.l.flW), this.context.getString(R.l.flX), this.context.getString(R.l.flR), this.context.getString(R.l.dGs), false, new OnClickListener(this) {
                final /* synthetic */ g sll;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.sll.ac(iVar);
                    dialogInterface.dismiss();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ g sll;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    this.sll.a(iVar, "doResumeDownloadTask:fail_network_not_wifi", null);
                }
            }, R.e.aWu);
        }
        return true;
    }

    public final boolean ac(i iVar) {
        long j = bg.getLong((String) iVar.ozE.get("download_id"), -1);
        w.i("MicroMsg.MsgHandler", "doResumeDownloadTask, downloadId = " + j);
        if (j <= 0) {
            w.e("MicroMsg.MsgHandler", "doResumeDownloadTask fail, invalid downloadId = " + j);
            a(iVar, "resume_download_task:fail", null);
        } else {
            com.tencent.mm.plugin.downloader.b.a ba = com.tencent.mm.plugin.downloader.model.d.ba(j);
            if (ba != null) {
                ba.field_scene = bg.getInt((String) iVar.ozE.get("scene"), 1000);
                com.tencent.mm.plugin.downloader.model.d.b(ba);
            }
            boolean aW = com.tencent.mm.plugin.downloader.model.e.akM().aW(j);
            w.i("MicroMsg.MsgHandler", "doResumeDownloadTask, ret = " + aW);
            if (aW) {
                a(iVar, "resume_download_task:ok", null);
            } else {
                a(iVar, "resume_download_task:fail", null);
            }
        }
        return true;
    }

    private boolean a(String str, i iVar) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    String str2;
                    String string = jSONArray.getString(i);
                    FileDownloadTaskInfo tI = com.tencent.mm.plugin.downloader.model.e.akM().tI(string);
                    JSONObject jSONObject2 = new JSONObject();
                    switch (tI.status) {
                        case -1:
                            str2 = "api_not_support";
                            break;
                        case 1:
                            str2 = "downloading";
                            break;
                        case 2:
                            str2 = "download_pause";
                            break;
                        case 3:
                            if (!com.tencent.mm.a.e.aO(tI.path)) {
                                str2 = "default";
                                break;
                            }
                            str2 = "download_succ";
                            break;
                        case 4:
                            str2 = "download_fail";
                            break;
                        default:
                            str2 = "default";
                            break;
                    }
                    jSONObject2.put("download_id", tI.id);
                    jSONObject2.put("state", str2);
                    if (str2 == "downloading" && tI.fLh != 0) {
                        jSONObject2.put("progress", (tI.fLg / tI.fLh) * 100);
                    }
                    jSONObject.put(string, jSONObject2);
                }
                Map hashMap = new HashMap();
                hashMap.put("result", jSONObject);
                a(iVar, "query_download_task:ok", hashMap);
            } else {
                a(iVar, "query_download_task:fail", null);
            }
        } catch (JSONException e) {
            w.e("MicroMsg.MsgHandler", e.getMessage());
            a(iVar, "query_download_task:fail", null);
        }
        return true;
    }

    public final boolean ad(i iVar) {
        long j = bg.getLong((String) iVar.ozE.get("download_id"), -1);
        String str = (String) iVar.ozE.get("appid");
        String str2 = (String) iVar.ozE.get("appIdArray");
        w.i("MicroMsg.MsgHandler", "doQueryDownloadTask, downloadId = " + j + ",appId = " + str + ",appIds = " + str2);
        if (!bg.mA(str2)) {
            return a(str2, iVar);
        }
        FileDownloadTaskInfo aU;
        if (j > 0) {
            aU = com.tencent.mm.plugin.downloader.model.e.akM().aU(j);
        } else if (bg.mA(str)) {
            w.e("MicroMsg.MsgHandler", "doQueryDownloadTask fail, invalid downloadId = " + j + " or appid is null");
            a(iVar, "query_download_task:fail", null);
            return true;
        } else {
            aU = com.tencent.mm.plugin.downloader.model.e.akM().tI(str);
        }
        switch (aU.status) {
            case -1:
                w.e("MicroMsg.MsgHandler", "doQueryDownloadTask fail, api not support");
                a(iVar, "query_download_task:fail_apilevel_too_low", null);
                return true;
            case 1:
                str2 = "downloading";
                break;
            case 2:
                str2 = "download_pause";
                break;
            case 3:
                if (!com.tencent.mm.a.e.aO(aU.path)) {
                    str2 = "default";
                    break;
                }
                str2 = "download_succ";
                break;
            case 4:
                str2 = "download_fail";
                break;
            default:
                str2 = "default";
                break;
        }
        w.i("MicroMsg.MsgHandler", "doQueryDownloadTask, state = " + str2);
        Map hashMap = new HashMap();
        hashMap.put("state", str2);
        hashMap.put("download_id", Long.valueOf(aU.id));
        if (str2 == "downloading" && aU.fLh != 0) {
            hashMap.put("progress", Long.valueOf((long) ((((float) aU.fLg) / ((float) aU.fLh)) * 100.0f)));
        }
        a(iVar, "query_download_task:ok", hashMap);
        return true;
    }

    public final boolean ae(i iVar) {
        long j = bg.getLong((String) iVar.ozE.get("download_id"), -1);
        w.i("MicroMsg.MsgHandler", "doInstallDownloadTask, downloadId = " + j);
        if (j <= 0) {
            w.e("MicroMsg.MsgHandler", "doInstallDownloadTask fail, invalid downloadId = " + j);
            a(iVar, "install_download_task:fail", null);
        } else {
            FileDownloadTaskInfo aU = com.tencent.mm.plugin.downloader.model.e.akM().aU(j);
            if (aU.status == -1) {
                w.e("MicroMsg.MsgHandler", "doInstallDownloadTask fail, apilevel not supported");
                a(iVar, "install_download_task:fail_apilevel_too_low", null);
            } else if (aU.status != 3) {
                w.e("MicroMsg.MsgHandler", "doInstallDownloadTask fail, invalid status = " + aU.status);
                a(iVar, "install_download_task:fail", null);
            } else if (com.tencent.mm.a.e.aO(aU.path)) {
                a(iVar, com.tencent.mm.pluginsdk.model.app.q.e(this.context, Uri.fromFile(new File(aU.path))) ? "install_download_task:ok" : "install_download_task:fail", null);
            } else {
                a(iVar, "install_download_task:fail", null);
            }
        }
        return true;
    }

    public final boolean af(i iVar) {
        String str = (String) iVar.ozE.get("specificview");
        if (bg.mA(str)) {
            w.e("MicroMsg.MsgHandler", "doOpenSpecificView fail, invalid specificview");
            a(iVar, "specific_view:fail", null);
        } else {
            new Intent().addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            Bundle bundle = new Bundle();
            String str2 = (String) iVar.ozE.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
            String str3 = (String) iVar.ozE.get("extinfo");
            bundle.putInt("webview_scene", bg.getInt((String) iVar.ozE.get("webview_scene"), 0));
            bundle.putString(SlookSmartClipMetaTag.TAG_TYPE_URL, str2);
            bundle.putString("extinfo", str3);
            w.i("MicroMsg.MsgHandler", "doOpenSpecificView, targetView = %s, ret = %b", new Object[]{str, Boolean.valueOf(com.tencent.mm.plugin.webview.a.a.imv.a(this.context, str, new Object[]{bundle}))});
            if (com.tencent.mm.plugin.webview.a.a.imv.a(this.context, str, new Object[]{bundle})) {
                a(iVar, "specific_view:ok", null);
            } else {
                w.e("MicroMsg.MsgHandler", "doOpenSpecificView, targetView not supported in current wechat version");
                a(iVar, "specific_view:not_supported", null);
            }
        }
        return true;
    }

    public final boolean ag(final i iVar) {
        String str;
        int i;
        IMediaObject wXAppExtendObject;
        WXMediaMessage wXMediaMessage;
        com.tencent.mm.sdk.b.b ieVar;
        String str2 = (String) iVar.ozE.get(Columns.TYPE);
        String str3 = (String) iVar.ozE.get("appID");
        w.i("MicroMsg.MsgHandler", "lauchTimeInterval = %d", new Object[]{Long.valueOf(bg.Ny() - this.skJ)});
        String str4 = "";
        String str5 = "";
        if (bg.Ny() - this.skJ < 2 && this.skJ > 0) {
            try {
                str4 = this.rXh.VD();
                str5 = this.skF.JZ(str4);
                str4 = URLEncoder.encode(str4, "UTF-8");
                com.tencent.mm.plugin.report.service.g.oUh.i(13983, new Object[]{Integer.valueOf(5), str4, ""});
                str = str4;
                str4 = str5;
            } catch (Exception e) {
                str4 = "";
                w.e("MicroMsg.MsgHandler", "report lauch3rd failed");
            }
            k.a(iVar.smM, false, null, str3);
            if (!bg.mA(str2)) {
                try {
                    i = bg.getInt(str2, 0);
                } catch (Exception e2) {
                    w.e("MicroMsg.MsgHandler", "invalid type", new Object[]{e2.getMessage()});
                }
                w.i("MicroMsg.MsgHandler", "doLaunch3RdApp launchType = %s", new Object[]{str2});
                if (i != 0) {
                    str2 = (String) iVar.ozE.get("extInfo");
                    w.i("MicroMsg.MsgHandler", "doLaunch3RdApp, appid:[%s], extinfo:[%s]", new Object[]{str3, str2});
                    if (!bg.mA(str3)) {
                        w.e("MicroMsg.MsgHandler", "appid is null or nil");
                        a(iVar, "launch_3rdApp:fail", null);
                    } else if (com.tencent.mm.plugin.webview.a.a.imw.n(ab.getContext(), str3)) {
                        w.e("MicroMsg.MsgHandler", "app is not installed, appid:[%s]", new Object[]{str3});
                        a(iVar, "launch_3rdApp:fail", null);
                    } else {
                        wXAppExtendObject = new WXAppExtendObject();
                        wXAppExtendObject.extInfo = str2;
                        wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                        wXMediaMessage.sdkVer = 620757000;
                        wXMediaMessage.messageExt = str2;
                        ieVar = new ie();
                        ieVar.fNI.fNK = wXMediaMessage;
                        ieVar.fNI.appId = str3;
                        ieVar.fNI.context = this.context;
                        ieVar.fNI.fNL = new com.tencent.mm.pluginsdk.model.app.g.c(this) {
                            final /* synthetic */ g sll;

                            public final void ex(boolean z) {
                                this.sll.a(iVar, "launch_3rdApp:ok", null);
                            }
                        };
                        com.tencent.mm.sdk.b.a.urY.m(ieVar);
                    }
                } else if (i != 1) {
                    str2 = (String) iVar.ozE.get("signature");
                    str3 = (String) iVar.ozE.get(DownloadInfoColumns.PACKAGENAME);
                    w.i("MicroMsg.MsgHandler", "doLaunch3RdApp, signature:[%s], packageName:[%s], param:[%s]", new Object[]{str2, str3, (String) iVar.ozE.get("param")});
                    if (!bg.mA(str2) || bg.mA(str3)) {
                        w.e("MicroMsg.MsgHandler", "doLaunch3RdApp invalid_args");
                        a(iVar, "launch_3rdApp:fail_invalid_args", null);
                    } else if (com.tencent.mm.pluginsdk.model.app.p.n(this.context, str3)) {
                        Signature[] aR = com.tencent.mm.pluginsdk.model.app.p.aR(this.context, str3);
                        if (!(aR == null || aR[0] == null)) {
                            String n = com.tencent.mm.a.g.n(aR[0].toByteArray());
                            if (n != null && n.equalsIgnoreCase(str2)) {
                                try {
                                    Intent launchIntentForPackage = this.context.getPackageManager().getLaunchIntentForPackage(str3);
                                    if (launchIntentForPackage != null) {
                                        Bundle bundle = new Bundle();
                                        com.tencent.mm.pluginsdk.model.app.p.g(bundle, str5);
                                        launchIntentForPackage.putExtras(bundle);
                                        launchIntentForPackage.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                        bundle = new Bundle();
                                        bundle.putString("current_page_url", str);
                                        bundle.putString("current_page_appid", str4);
                                        com.tencent.mm.pluginsdk.model.app.g.a(this.context, launchIntentForPackage, null, new com.tencent.mm.pluginsdk.model.app.g.c(this) {
                                            final /* synthetic */ g sll;

                                            public final void ex(boolean z) {
                                                this.sll.a(iVar, "launch_3rdApp:ok", null);
                                            }
                                        }, bundle);
                                    }
                                } catch (Exception e3) {
                                    w.e("MicroMsg.MsgHandler", "doLaunch3RdApp getLaunchIntentForPackage, %s", new Object[]{e3.getMessage()});
                                }
                                a(iVar, "launch_3rdApp:fail", null);
                            }
                        }
                        w.e("MicroMsg.MsgHandler", "doLaunch3RdApp signature_mismatch");
                        a(iVar, "launch_3rdApp:fail_signature_mismatch", null);
                    } else {
                        w.e("MicroMsg.MsgHandler", "doLaunch3RdApp not_install");
                        a(iVar, "launch_3rdApp:fail_not_install", null);
                    }
                } else {
                    a(iVar, "launch_3rdApp:fail_invalid_type", null);
                }
                return true;
            }
            i = 0;
            w.i("MicroMsg.MsgHandler", "doLaunch3RdApp launchType = %s", new Object[]{str2});
            if (i != 0) {
                str2 = (String) iVar.ozE.get("extInfo");
                w.i("MicroMsg.MsgHandler", "doLaunch3RdApp, appid:[%s], extinfo:[%s]", new Object[]{str3, str2});
                if (!bg.mA(str3)) {
                    w.e("MicroMsg.MsgHandler", "appid is null or nil");
                    a(iVar, "launch_3rdApp:fail", null);
                } else if (com.tencent.mm.plugin.webview.a.a.imw.n(ab.getContext(), str3)) {
                    wXAppExtendObject = new WXAppExtendObject();
                    wXAppExtendObject.extInfo = str2;
                    wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                    wXMediaMessage.sdkVer = 620757000;
                    wXMediaMessage.messageExt = str2;
                    ieVar = new ie();
                    ieVar.fNI.fNK = wXMediaMessage;
                    ieVar.fNI.appId = str3;
                    ieVar.fNI.context = this.context;
                    ieVar.fNI.fNL = /* anonymous class already generated */;
                    com.tencent.mm.sdk.b.a.urY.m(ieVar);
                } else {
                    w.e("MicroMsg.MsgHandler", "app is not installed, appid:[%s]", new Object[]{str3});
                    a(iVar, "launch_3rdApp:fail", null);
                }
            } else if (i != 1) {
                a(iVar, "launch_3rdApp:fail_invalid_type", null);
            } else {
                str2 = (String) iVar.ozE.get("signature");
                str3 = (String) iVar.ozE.get(DownloadInfoColumns.PACKAGENAME);
                w.i("MicroMsg.MsgHandler", "doLaunch3RdApp, signature:[%s], packageName:[%s], param:[%s]", new Object[]{str2, str3, (String) iVar.ozE.get("param")});
                if (bg.mA(str2)) {
                }
                w.e("MicroMsg.MsgHandler", "doLaunch3RdApp invalid_args");
                a(iVar, "launch_3rdApp:fail_invalid_args", null);
            }
            return true;
        }
        str = str4;
        str4 = str5;
        k.a(iVar.smM, false, null, str3);
        if (bg.mA(str2)) {
            i = bg.getInt(str2, 0);
            w.i("MicroMsg.MsgHandler", "doLaunch3RdApp launchType = %s", new Object[]{str2});
            if (i != 0) {
                str2 = (String) iVar.ozE.get("extInfo");
                w.i("MicroMsg.MsgHandler", "doLaunch3RdApp, appid:[%s], extinfo:[%s]", new Object[]{str3, str2});
                if (!bg.mA(str3)) {
                    w.e("MicroMsg.MsgHandler", "appid is null or nil");
                    a(iVar, "launch_3rdApp:fail", null);
                } else if (com.tencent.mm.plugin.webview.a.a.imw.n(ab.getContext(), str3)) {
                    w.e("MicroMsg.MsgHandler", "app is not installed, appid:[%s]", new Object[]{str3});
                    a(iVar, "launch_3rdApp:fail", null);
                } else {
                    wXAppExtendObject = new WXAppExtendObject();
                    wXAppExtendObject.extInfo = str2;
                    wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                    wXMediaMessage.sdkVer = 620757000;
                    wXMediaMessage.messageExt = str2;
                    ieVar = new ie();
                    ieVar.fNI.fNK = wXMediaMessage;
                    ieVar.fNI.appId = str3;
                    ieVar.fNI.context = this.context;
                    ieVar.fNI.fNL = /* anonymous class already generated */;
                    com.tencent.mm.sdk.b.a.urY.m(ieVar);
                }
            } else if (i != 1) {
                str2 = (String) iVar.ozE.get("signature");
                str3 = (String) iVar.ozE.get(DownloadInfoColumns.PACKAGENAME);
                w.i("MicroMsg.MsgHandler", "doLaunch3RdApp, signature:[%s], packageName:[%s], param:[%s]", new Object[]{str2, str3, (String) iVar.ozE.get("param")});
                if (bg.mA(str2)) {
                }
                w.e("MicroMsg.MsgHandler", "doLaunch3RdApp invalid_args");
                a(iVar, "launch_3rdApp:fail_invalid_args", null);
            } else {
                a(iVar, "launch_3rdApp:fail_invalid_type", null);
            }
            return true;
        }
        i = 0;
        w.i("MicroMsg.MsgHandler", "doLaunch3RdApp launchType = %s", new Object[]{str2});
        if (i != 0) {
            str2 = (String) iVar.ozE.get("extInfo");
            w.i("MicroMsg.MsgHandler", "doLaunch3RdApp, appid:[%s], extinfo:[%s]", new Object[]{str3, str2});
            if (!bg.mA(str3)) {
                w.e("MicroMsg.MsgHandler", "appid is null or nil");
                a(iVar, "launch_3rdApp:fail", null);
            } else if (com.tencent.mm.plugin.webview.a.a.imw.n(ab.getContext(), str3)) {
                wXAppExtendObject = new WXAppExtendObject();
                wXAppExtendObject.extInfo = str2;
                wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                wXMediaMessage.sdkVer = 620757000;
                wXMediaMessage.messageExt = str2;
                ieVar = new ie();
                ieVar.fNI.fNK = wXMediaMessage;
                ieVar.fNI.appId = str3;
                ieVar.fNI.context = this.context;
                ieVar.fNI.fNL = /* anonymous class already generated */;
                com.tencent.mm.sdk.b.a.urY.m(ieVar);
            } else {
                w.e("MicroMsg.MsgHandler", "app is not installed, appid:[%s]", new Object[]{str3});
                a(iVar, "launch_3rdApp:fail", null);
            }
        } else if (i != 1) {
            a(iVar, "launch_3rdApp:fail_invalid_type", null);
        } else {
            str2 = (String) iVar.ozE.get("signature");
            str3 = (String) iVar.ozE.get(DownloadInfoColumns.PACKAGENAME);
            w.i("MicroMsg.MsgHandler", "doLaunch3RdApp, signature:[%s], packageName:[%s], param:[%s]", new Object[]{str2, str3, (String) iVar.ozE.get("param")});
            if (bg.mA(str2)) {
            }
            w.e("MicroMsg.MsgHandler", "doLaunch3RdApp invalid_args");
            a(iVar, "launch_3rdApp:fail_invalid_args", null);
        }
        return true;
    }

    public final boolean ah(i iVar) {
        String str = (String) iVar.ozE.get(DownloadInfoColumns.PACKAGENAME);
        if (bg.mA(str)) {
            w.e("MicroMsg.MsgHandler", "doWriteCommData fail, packageName is null");
            a(iVar, "write_comm_data:fail", null);
        } else {
            int i;
            String str2 = (String) iVar.ozE.get(SlookAirButtonFrequentContactAdapter.DATA);
            boolean commit = this.context.getSharedPreferences(ab.getPackageName() + "_comm_preferences", 0).edit().putString(str, str2).commit();
            String str3 = "MicroMsg.MsgHandler";
            String str4 = "doWriteCommData, ret = %b, packageName = %s, data length = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(commit);
            objArr[1] = str;
            if (str2 == null) {
                i = 0;
            } else {
                i = str2.length();
            }
            objArr[2] = Integer.valueOf(i);
            w.i(str3, str4, objArr);
            if (commit) {
                a(iVar, "write_comm_data:ok", null);
            } else {
                a(iVar, "write_comm_data:fail", null);
            }
        }
        return true;
    }

    public final boolean ai(i iVar) {
        String str = (String) iVar.ozE.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bg.mA(str)) {
            w.e("MicroMsg.MsgHandler", "doOpenUrlByExtBrowser fail, url is null");
            a(iVar, "open_url_by_ext_browser:fail", null);
        } else {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            try {
                this.context.startActivity(intent);
                a(iVar, "open_url_by_ext_browser:ok", null);
            } catch (Exception e) {
                w.e("MicroMsg.MsgHandler", "doOpenUrlByExtBrowser fail, e = " + e.getMessage());
                a(iVar, "open_url_by_ext_browser:fail", null);
            }
        }
        return true;
    }

    public final boolean aj(i iVar) {
        String str = (String) iVar.ozE.get("gameId");
        if (bg.mA(str)) {
            str = (String) iVar.ozE.get("appId");
        }
        w.i("MicroMsg.MsgHandler", "openGameDetail, appid = %s", new Object[]{str});
        if (bg.mA(str)) {
            a(iVar, "openGameDetail:fail", null);
        } else {
            com.tencent.mm.sdk.b.b ghVar = new gh();
            ghVar.fLB.appId = str;
            ghVar.fLB.scene = 5;
            ghVar.fLB.actionCode = 2;
            ghVar.fLB.context = this.context;
            com.tencent.mm.sdk.b.a.urY.m(ghVar);
            a(iVar, "openGameDetail:ok", null);
        }
        return true;
    }

    public final boolean ak(i iVar) {
        int i = bg.getInt((String) iVar.ozE.get("jumpView"), 0);
        int i2 = bg.getInt((String) iVar.ozE.get("jumpType"), 0);
        String str = (String) iVar.ozE.get("extInfo");
        com.tencent.mm.sdk.b.b kpVar = new kp();
        kpVar.fRg.fRh = i;
        kpVar.fRg.jumpType = i2;
        kpVar.fRg.extraInfo = str;
        kpVar.fRg.context = this.context;
        com.tencent.mm.sdk.b.a.urY.m(kpVar);
        a(iVar, "gameCenterJump:ok", null);
        return true;
    }

    public final boolean al(i iVar) {
        int i = bg.getInt((String) iVar.ozE.get("downloaderType"), 0);
        String str = (String) iVar.ozE.get("countryCode");
        int i2 = bg.getInt((String) iVar.ozE.get("showAllLog"), 0);
        com.tencent.mm.sdk.b.b gjVar = new gj();
        gjVar.fLF.fLG = i;
        gjVar.fLF.fLH = i2;
        gjVar.fLF.countryCode = str;
        com.tencent.mm.sdk.b.a.urY.m(gjVar);
        a(iVar, "setGameDebugConfig:ok", null);
        return true;
    }

    public final boolean am(i iVar) {
        String str = (String) iVar.ozE.get(Columns.TYPE);
        w.v("MicroMsg.MsgHandler", "doGeoLocation, geoType = %s", new Object[]{str});
        if (bg.mA(str) || iNc.contains(str)) {
            this.gKi = com.tencent.mm.modelgeo.c.Gk();
            if (this.gKi == null) {
                w.e("MicroMsg.MsgHandler", "doGeoLocation fail, iGetLocation is null");
                a(iVar, "geo_location:fail", null);
            } else {
                str = (String) this.skt.ozE.get(Columns.TYPE);
                if (this.iNl == null) {
                    this.iNl = new com.tencent.mm.modelgeo.a.a(this) {
                        final /* synthetic */ g sll;

                        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                            if (!z) {
                                return true;
                            }
                            w.v("MicroMsg.MsgHandler", "doGeoLocation.onGetLocation, fLongitude:%f, fLatitude:%f, locType:%d, speed:%f, accuracy:%f", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2)});
                            if (this.sll.gKi != null) {
                                this.sll.gKi.c(this.sll.iNl);
                            }
                            if (this.sll.iNl == null) {
                                w.w("MicroMsg.MsgHandler", "already callback");
                                return false;
                            }
                            this.sll.iNl = null;
                            Map hashMap = new HashMap();
                            hashMap.put("longitude", Float.valueOf(f));
                            this.sll.skS = String.valueOf(f);
                            hashMap.put("latitude", Float.valueOf(f2));
                            this.sll.skR = String.valueOf(f2);
                            hashMap.put("speed", Double.valueOf(d));
                            hashMap.put("accuracy", Double.valueOf(d2));
                            hashMap.put(Columns.TYPE, str);
                            this.sll.a(this.sll.skt, "geo_location:ok", hashMap);
                            return false;
                        }
                    };
                }
                if (this.iNm == null) {
                    this.iNm = new ae(Looper.getMainLooper());
                }
                this.iNm.postDelayed(new Runnable(this) {
                    final /* synthetic */ g sll;

                    {
                        this.sll = r1;
                    }

                    public final void run() {
                        if (this.sll.gKi != null) {
                            this.sll.gKi.c(this.sll.iNl);
                        }
                        if (this.sll.iNl == null) {
                            w.w("MicroMsg.MsgHandler", "already callback");
                            return;
                        }
                        this.sll.iNl = null;
                        this.sll.a(this.sll.skt, "geo_location:fail_timeout", null);
                    }
                }, 20000);
                if (bg.mA(str) || str.equalsIgnoreCase("gcj02")) {
                    this.gKi.b(this.iNl, false);
                } else if (str.equalsIgnoreCase("wgs84")) {
                    this.gKi.a(this.iNl, false);
                } else {
                    w.e("MicroMsg.MsgHandler", "startGeoLocation, should not reach here !!!!!");
                    this.iNl = null;
                    a(this.skt, "geo_location:fail_unsupported_type_startgeo", null);
                }
            }
        } else {
            w.e("MicroMsg.MsgHandler", "doGeoLocation fail, unsupported type = %s", new Object[]{str});
            a(iVar, "geo_location:fail_unsupported_type", null);
        }
        return true;
    }

    public final boolean an(i iVar) {
        k.a(iVar.smM, false, null, (String) iVar.ozE.get("appId"));
        w.i("MicroMsg.MsgHandler", "doOpenWXCredit JSOAUTH");
        if (this.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(iVar.ozE);
            dVar.fRw = 6;
            com.tencent.mm.pluginsdk.wallet.e.b((MMActivity) this.context, dVar, 9, this);
        }
        return true;
    }

    public final boolean ao(final i iVar) {
        if (this.skw == null) {
            w.e("MicroMsg.MsgHandler", "doSendServiceAppMsg fail, jsapiArgs is null");
            a(iVar, "send_service_app_msg:fail", null);
        } else if (this.skw.getBoolean("isFromService", false)) {
            String string = this.skw.getString("jsapi_args_appid");
            String string2 = this.skw.getString("sendAppMsgToUserName");
            k.a(iVar.smM, false, null, string);
            this.fNK = h(iVar);
            if (this.fNK == null) {
                w.e("MicroMsg.MsgHandler", "doSendServiceAppMsg fail, appmsg is null");
                a(iVar, "send_service_app_msg:fail", null);
            } else {
                f aJ = com.tencent.mm.pluginsdk.model.app.g.aJ(string, true);
                if (bg.mA(string2)) {
                    w.e("MicroMsg.MsgHandler", "toUser is null");
                    a(iVar, "send_service_app_msg:fail", null);
                } else {
                    final String str = (String) iVar.ozE.get("img_url");
                    com.tencent.mm.plugin.report.service.g.oUh.i(10923, new Object[]{Integer.valueOf(13), aJ.field_appId, Integer.valueOf(1)});
                    if (bg.mA(str)) {
                        a(aJ, "", string2, str, null, null, null, null);
                        com.tencent.mm.ui.base.g.bl(this.context, this.context.getString(R.l.dIy));
                        a(iVar, "send_service_app_msg:ok", null);
                        cz(iVar);
                    } else {
                        final ProgressDialog a = com.tencent.mm.ui.base.g.a(this.context, this.context.getResources().getString(R.l.dIB), true, new OnCancelListener(this) {
                            final /* synthetic */ g sll;

                            public final void onCancel(DialogInterface dialogInterface) {
                                com.tencent.mm.ah.n.GR().jm(str);
                                this.sll.a(iVar, "send_service_app_msg:fail", null);
                            }
                        });
                        final f fVar = aJ;
                        final String str2 = string2;
                        final String str3 = str;
                        final i iVar2 = iVar;
                        com.tencent.mm.ah.n.GR().a(str, new com.tencent.mm.ah.b.c(this) {
                            final /* synthetic */ g sll;

                            public final void l(Bitmap bitmap) {
                                if (a != null) {
                                    a.dismiss();
                                }
                                this.sll.a(fVar, "", str2, str3, null, null, null, null);
                                this.sll.a(iVar2, "send_service_app_msg:ok", null);
                                this.sll.cz(iVar2);
                            }
                        });
                    }
                }
            }
        } else {
            w.e("MicroMsg.MsgHandler", "doSendServiceAppMsg fail, not from service");
            a(iVar, "send_service_app_msg:fail", null);
        }
        return true;
    }

    private static byte[] bzC() {
        try {
            com.tencent.mm.sdk.platformtools.g gVar = new com.tencent.mm.sdk.platformtools.g("softtype");
            w.d("MicroMsg.AndroidDevicesReport", "cpu %s", new Object[]{bg.ap((String) com.tencent.mm.compatible.d.m.rp().get("Processor"), "")});
            gVar.bm("cpu", r0);
            gVar.bm(TencentLocationListener.RADIO, com.tencent.mm.compatible.d.p.rI());
            gVar.bm("osversion", VERSION.RELEASE);
            String deviceID = com.tencent.mm.compatible.d.p.getDeviceID(ab.getContext());
            String rK = com.tencent.mm.compatible.d.p.rK();
            String rL = com.tencent.mm.compatible.d.p.rL();
            gVar.bm("deviceId", deviceID);
            gVar.bm("imsi", rK);
            gVar.bm("iccid", rL);
            gVar.bm("androidid", com.tencent.mm.compatible.d.p.getAndroidId());
            gVar.bm("serial", com.tencent.mm.compatible.d.p.rM());
            gVar.bm("model", com.tencent.mm.compatible.d.p.rF());
            gVar.bm("core_count", com.tencent.mm.compatible.d.m.ru());
            gVar.bm("cpuhardware", bg.ap((String) com.tencent.mm.compatible.d.m.rv().get("Hardware"), ""));
            gVar.bm("cpureversion", bg.ap((String) com.tencent.mm.compatible.d.m.rv().get("CPU revision"), ""));
            gVar.bm("cpuserial", bg.ap((String) com.tencent.mm.compatible.d.m.rv().get("Serial"), ""));
            gVar.bm("Features", bg.ap((String) com.tencent.mm.compatible.d.m.rv().get("Features"), ""));
            gVar.bm("wifi-mac", bg.ap(com.tencent.mm.compatible.d.p.rC(), ""));
            gVar.bm("bluetooth", bg.ap(com.tencent.mm.compatible.d.p.rD(), ""));
            if (!bg.mA(gVar.usx)) {
                gVar.rK(gVar.usx);
                gVar.usx = "";
            }
            w.d("MicroMsg.AndroidDevicesReport", "xmlStr %s", new Object[]{gVar.jGf.toString()});
            w.i("MicroMsg.MsgHandler", "xml %s", new Object[]{deviceID});
            bfx com_tencent_mm_protocal_c_bfx = new bfx();
            com_tencent_mm_protocal_c_bfx.ugo = com.tencent.mm.bd.b.aU(com.tencent.mm.compatible.d.p.rB().getBytes()).xV(16);
            w.i("MicroMsg.MsgHandler", bg.bo(com_tencent_mm_protocal_c_bfx.ugo.sYA));
            com_tencent_mm_protocal_c_bfx.ugp = deviceID;
            SharedPreferences ze = aq.ze();
            w.i("MicroMsg.MsgHandler", "cpan aak string:%s md5:%s uin:%d", new Object[]{bg.bo(r2), com.tencent.mm.a.g.n(bg.PT(ze.getString("_auth_key", ""))), Integer.valueOf(ze.getInt("_auth_uin", 0))});
            w.i("MicroMsg.MsgHandler", "aat len:%d", new Object[]{Integer.valueOf(r2.length)});
            com_tencent_mm_protocal_c_bfx.ugq = com.tencent.mm.bd.b.aU(r2);
            com_tencent_mm_protocal_c_bfx.uin = r0;
            ac bHs = ac.bHs();
            byte[] toByteArray = com_tencent_mm_protocal_c_bfx.toByteArray();
            PByteArray pByteArray = new PByteArray();
            if (MMProtocalJni.rsaPublicEncrypt(toByteArray, pByteArray, bHs.tal.getBytes(), bHs.tam.getBytes())) {
                toByteArray = pByteArray.value;
            }
            w.d("MicroMsg.MsgHandler", "cpan buf string:%s ", new Object[]{bg.bo(toByteArray)});
            bfy com_tencent_mm_protocal_c_bfy = new bfy();
            com_tencent_mm_protocal_c_bfy.ugs = bHs.ver;
            com_tencent_mm_protocal_c_bfy.ugr = com.tencent.mm.protocal.d.sYN;
            com_tencent_mm_protocal_c_bfy.ugt = com.tencent.mm.protocal.d.DEVICE_TYPE;
            com_tencent_mm_protocal_c_bfy.ugu = com.tencent.mm.bd.b.aU(toByteArray);
            w.i("MicroMsg.MsgHandler", "getdevice done");
            return com_tencent_mm_protocal_c_bfy.toByteArray();
        } catch (Throwable e) {
            w.e("MicroMsg.MsgHandler", "report error");
            w.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
            return null;
        }
    }

    public final boolean ap(i iVar) {
        String str = "";
        try {
            str = this.rXh.VD();
        } catch (Exception e) {
            w.w("MicroMsg.MsgHandler", "JSOAUTH exception in get currentUrl" + e.getMessage());
        }
        w.i("MicroMsg.MsgHandler", "currentUrl %s", new Object[]{str});
        if (str.startsWith("https://support.weixin.qq.com/security/") || str.startsWith("https://support.wechat.com/security/") || str.startsWith("https://weixin110.qq.com/security/")) {
            Object obj = "";
            Map hashMap = new HashMap();
            try {
                w.i("MicroMsg.MsgHandler", "getDeviceInfo");
                obj = Base64.encodeToString(bzC(), 0);
            } catch (Throwable e2) {
                w.e("MicroMsg.MsgHandler", "device info get error %s", new Object[]{e2.getMessage()});
                w.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
            }
            hashMap.put("securityInfo", obj);
            a(iVar, "mmsf0001:ok", hashMap);
        } else {
            a(iVar, "system:access_denied", null);
        }
        return true;
    }

    public final boolean aq(i iVar) {
        Map map = null;
        if (this.context instanceof MMActivity) {
            String VD;
            w.d("MicroMsg.MsgHandler", "doJumpToBizProfile %s, %s", new Object[]{(String) iVar.ozE.get("tousername"), (String) iVar.ozE.get("extmsg")});
            try {
                VD = this.rXh.VD();
            } catch (RemoteException e) {
                w.w("MicroMsg.MsgHandler", "JSOAUTH exception in get currentUrl" + e.getMessage());
            }
            Intent intent = new Intent();
            intent.putExtra("toUserName", r0);
            intent.putExtra("extInfo", r1);
            intent.putExtra("fromURL", VD);
            intent.putExtra("source", 2);
            com.tencent.mm.plugin.webview.a.a.imv.a(intent, this, (MMActivity) this.context);
        } else {
            a(iVar, "jump_to_biz_profile:fail", map);
        }
        return true;
    }

    public final boolean ar(i iVar) {
        w.i("MicroMsg.MsgHandler", "doChooseCard JSOAUTH");
        String str = (String) iVar.ozE.get("app_id");
        int i = bg.getInt((String) iVar.ozE.get("location_id"), 0);
        String str2 = (String) iVar.ozE.get("sign_type");
        String str3 = (String) iVar.ozE.get("card_sign");
        int i2 = bg.getInt((String) iVar.ozE.get("time_stamp"), 0);
        String str4 = (String) iVar.ozE.get("nonce_str");
        String str5 = (String) iVar.ozE.get("card_id");
        String str6 = (String) iVar.ozE.get("card_type");
        if ("INVOICE".equalsIgnoreCase(str6)) {
            a(iVar, "choose_card:fail", new HashMap());
            return false;
        }
        int i3 = bg.getInt((String) iVar.ozE.get("can_multi_select"), 0);
        k.a(iVar.smM, false, null, str);
        Intent intent = new Intent();
        intent.putExtra("app_id", str);
        intent.putExtra("shop_id", i);
        intent.putExtra("sign_type", str2);
        intent.putExtra("card_sign", str3);
        intent.putExtra("time_stamp", i2);
        intent.putExtra("nonce_str", str4);
        intent.putExtra("card_tp_id", str5);
        intent.putExtra("card_type", str6);
        intent.putExtra("can_multi_select", i3);
        intent.putExtra("key_from_scene", 7);
        if (this.context instanceof MMActivity) {
            ((MMActivity) this.context).uSV = this;
            com.tencent.mm.bb.d.a(this.context, "card", ".ui.CardListSelectedUI", intent, 13, false);
        }
        return true;
    }

    public final boolean as(i iVar) {
        w.i("MicroMsg.MsgHandler", "doChooseInvoice JSOAUTH");
        String str = (String) iVar.ozE.get("appId");
        String str2 = (String) iVar.ozE.get("signType");
        String str3 = (String) iVar.ozE.get("cardSign");
        int i = bg.getInt((String) iVar.ozE.get("timestamp"), 0);
        String str4 = (String) iVar.ozE.get("nonceStr");
        Intent intent = new Intent();
        intent.putExtra("app_id", str);
        intent.putExtra("sign_type", str2);
        intent.putExtra("card_sign", str3);
        intent.putExtra("time_stamp", i);
        intent.putExtra("nonce_str", str4);
        intent.putExtra("can_multi_select", 1);
        intent.putExtra("card_type", "INVOICE");
        intent.putExtra("key_from_scene", 7);
        if (this.context instanceof MMActivity) {
            ((MMActivity) this.context).uSV = this;
            com.tencent.mm.bb.d.a(this.context, "card", ".ui.CardListSelectedUI", intent, 36, false);
        }
        return true;
    }

    public final boolean at(i iVar) {
        String str = (String) iVar.ozE.get("card_list");
        String str2 = (String) iVar.ozE.get("src_username");
        String str3 = (String) iVar.ozE.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        String str4 = (String) iVar.ozE.get("tempalate_id");
        w.i("MicroMsg.MsgHandler", "doBatchAddCard consumedCardId %s", new Object[]{(String) iVar.ozE.get("consumedCardId")});
        w.i("MicroMsg.MsgHandler", "doBatchAddCard %s", new Object[]{iVar.ozE.toString()});
        int i = bg.getInt((String) iVar.ozE.get("webview_scene"), 0);
        int i2 = bg.getInt((String) iVar.ozE.get("stastic_scene"), 0);
        if (i == 25) {
            i = 16;
        } else {
            i = 7;
        }
        w.i("MicroMsg.MsgHandler", "doBatchAddCard src_username is %s, scene is %d, stasticScene is %d", new Object[]{str2, Integer.valueOf(i), Integer.valueOf(i2)});
        Intent intent = new Intent();
        intent.putExtra("key_in_card_list", str);
        intent.putExtra("key_from_scene", i);
        intent.putExtra("key_stastic_scene", i2);
        intent.putExtra("src_username", str2);
        intent.putExtra("js_url", str3);
        intent.putExtra("key_consumed_card_id", r4);
        intent.putExtra("key_template_id", str4);
        if (this.context instanceof MMActivity) {
            ((MMActivity) this.context).uSV = this;
            com.tencent.mm.bb.d.a(this.context, "card", ".ui.CardAddEntranceUI", intent, 16, false);
        }
        return true;
    }

    public final boolean au(i iVar) {
        w.i("MicroMsg.MsgHandler", "doBatchViewCard JSOAUTH");
        String str = (String) iVar.ozE.get("card_list");
        String str2 = (String) iVar.ozE.get("tempalate_id");
        Intent intent = new Intent();
        intent.putExtra("card_list", str);
        intent.putExtra("key_template_id", str2);
        intent.putExtra("key_from_scene", 7);
        if (this.context instanceof MMActivity) {
            ((MMActivity) this.context).uSV = this;
            com.tencent.mm.bb.d.a(this.context, "card", ".ui.CardViewEntranceUI", intent, 23, false);
        }
        this.lre = false;
        return true;
    }

    public final boolean av(i iVar) {
        String str;
        String str2 = (String) iVar.ozE.get("title");
        String str3 = (String) iVar.ozE.get("singer");
        String str4 = (String) iVar.ozE.get("epname");
        String str5 = (String) iVar.ozE.get("coverImgUrl");
        String str6 = (String) iVar.ozE.get("dataUrl");
        String str7 = (String) iVar.ozE.get("lowbandUrl");
        String str8 = (String) iVar.ozE.get("webUrl");
        String str9 = (String) iVar.ozE.get("appId");
        if (str5 == null) {
            str = "";
        } else {
            str = str5;
        }
        k.a(iVar.smM, false, null, str9);
        w.i("MicroMsg.MsgHandler", "title : %s, singer : %s, epName : %s, coverImgUrl : %s, dataUrl : %s, lowbandUrl : %s, webUrl : %s, appid : %s", new Object[]{str2, str3, str4, str, str6, str7, str8, str9});
        if (bg.mA(str2) || bg.mA(str3) || bg.mA(str4) || bg.mA(str) || bg.mA(str7) || bg.mA(str6) || bg.mA(str8)) {
            a(iVar, "playMusic:fail", null);
        } else {
            com.tencent.mm.am.b.HH();
            com.tencent.mm.am.a.a aVar = (com.tencent.mm.am.a.a) com.tencent.mm.kernel.h.h(com.tencent.mm.am.a.a.class);
            String str10 = str6.hashCode();
            String str11 = com.tencent.mm.compatible.util.e.hgu;
            StringBuilder stringBuilder = new StringBuilder();
            ap.yY();
            com.tencent.mm.am.b.b(aVar.a(7, str, str2, str3, str8, str7, str6, str10, str11, stringBuilder.append(com.tencent.mm.u.c.xb()).append(str.hashCode()).toString(), str4, str9));
            a(iVar, "playMusic:ok", null);
        }
        return true;
    }

    public final boolean aw(i iVar) {
        w.i("MicroMsg.MsgHandler", "doSetCloseWindowConfirmDialogInfo, switch value : %s, title_cn : %s, title_eng : %s, ok_cn : %s,  ok_eng : %s,  cancel_cn : %s,  cancel_eng : %s", new Object[]{(String) iVar.ozE.get("switch"), (String) iVar.ozE.get("title_cn"), (String) iVar.ozE.get("title_eng"), (String) iVar.ozE.get("ok_cn"), (String) iVar.ozE.get("ok_eng"), (String) iVar.ozE.get("cancel_cn"), (String) iVar.ozE.get("cancel_eng")});
        Bundle bundle = new Bundle();
        bundle.putString("close_window_confirm_dialog_switch", r0);
        bundle.putString("close_window_confirm_dialog_title_cn", r1);
        bundle.putString("close_window_confirm_dialog_title_eng", r2);
        bundle.putString("close_window_confirm_dialog_ok_cn", r3);
        bundle.putString("close_window_confirm_dialog_ok_eng", r4);
        bundle.putString("close_window_confirm_dialog_cancel_cn", r5);
        bundle.putString("close_window_confirm_dialog_cancel_eng", r6);
        try {
            this.rXh.m(13, bundle);
        } catch (RemoteException e) {
            w.e("MicroMsg.MsgHandler", "doSetCloseWindowConfirmDialogInfo invoke callback failed : %s", new Object[]{e.getMessage()});
        }
        a(iVar, "setCloseWindowConfirmDialogInfo:ok", null);
        return true;
    }

    public final boolean f(i iVar, JsapiPermissionWrapper jsapiPermissionWrapper) {
        String str = (String) iVar.ozE.get("verifyAppId");
        String str2 = (String) iVar.ozE.get("verifyJsApiList");
        w.i("MicroMsg.MsgHandler", "doPreVerifyJSAPI, appid : %s, %s, %s, %s, %s", new Object[]{str, (String) iVar.ozE.get("verifySignature"), (String) iVar.ozE.get("verifyNonceStr"), (String) iVar.ozE.get("verifyTimestamp"), (String) iVar.ozE.get("verifySignType")});
        k.a(iVar.smM, false, null, str);
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(str2);
            w.i("MicroMsg.MsgHandler", "doPreVerifyJSAPI jsItem length %s", new Object[]{Integer.valueOf(jSONArray.length())});
            if (jSONArray.length() == 0) {
                a(iVar, "checkJsApi:param is empty", null);
                return true;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                String string = jSONArray.getString(i);
                if (!bg.mA(string)) {
                    linkedList.add(string);
                }
            }
            String VD = this.rXh.VD();
            int i2 = 0;
            String str3 = "";
            try {
                Bundle d = this.rXh.d(com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX, null);
                i2 = d.getInt("key_webview_preverify_info_scene", 0);
                str3 = d.getString("key_webview_preverify_info_source_appid", "");
            } catch (Exception e) {
                w.e("TAG", "doPreVerifyJSAPI: %s", new Object[]{e});
            }
            Object obj = this.skF;
            final JsapiPermissionWrapper jsapiPermissionWrapper2 = jsapiPermissionWrapper;
            final i iVar2 = iVar;
            com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a anonymousClass39 = new com.tencent.mm.plugin.webview.ui.tools.jsapi.c.c(this) {
                final /* synthetic */ g sll;

                public final void a(com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a aVar, String str, LinkedList<biy> linkedList, int i, int i2) {
                    if (aVar != com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_OK || jsapiPermissionWrapper2.sZd == null) {
                        if (this.sll.rXh != null) {
                            Bundle bundle = new Bundle();
                            bundle.putByteArray("jsapi_control_bytes", jsapiPermissionWrapper2.sZd);
                            try {
                                w.e("MicroMsg.MsgHandler", "doPreVerifyJSAPI fail, update controlBytes with default permission");
                                this.sll.rXh.m(MMBitmapFactory.ERROR_UNSUPPORT_IMAGE_FORMAT, bundle);
                            } catch (Exception e) {
                                w.e("MicroMsg.MsgHandler", "doPreVerifyJSAPI remote ex, %s", new Object[]{e.getMessage()});
                            }
                        }
                        if (bg.mA(str)) {
                            this.sll.a(iVar2, "pre_verify_jsapi:fail", null);
                            return;
                        } else {
                            this.sll.a(iVar2, "pre_verify_jsapi:fail_" + str, null);
                            return;
                        }
                    }
                    int i3;
                    this.sll.skJ = bg.Ny();
                    if (linkedList == null || linkedList.size() <= 0) {
                        i3 = 0;
                    } else {
                        Iterator it = linkedList.iterator();
                        i3 = 0;
                        while (it.hasNext()) {
                            biy com_tencent_mm_protocal_c_biy = (biy) it.next();
                            com.tencent.mm.protocal.c.g NH = com.tencent.mm.protocal.c.NH(bg.mz(com_tencent_mm_protocal_c_biy.tLm));
                            if (NH != null) {
                                int i4;
                                if (jsapiPermissionWrapper2.xX(NH.bHa()) != com_tencent_mm_protocal_c_biy.state) {
                                    jsapiPermissionWrapper2.a(NH.bHa(), (byte) com_tencent_mm_protocal_c_biy.state);
                                    i4 = 1;
                                } else {
                                    i4 = i3;
                                }
                                i3 = i4;
                            }
                        }
                    }
                    if (!(i3 == 0 || this.sll.rXh == null)) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putByteArray("jsapi_control_bytes", jsapiPermissionWrapper2.sZd);
                        try {
                            String str2 = "MicroMsg.MsgHandler";
                            String str3 = "doPreVerifyJSAPI update controlBytes, %d, jsPerm = %s";
                            Object[] objArr = new Object[2];
                            objArr[0] = Integer.valueOf(jsapiPermissionWrapper2.sZd == null ? 0 : jsapiPermissionWrapper2.sZd.length);
                            objArr[1] = jsapiPermissionWrapper2;
                            w.i(str2, str3, objArr);
                            this.sll.rXh.m(MMBitmapFactory.ERROR_UNSUPPORT_IMAGE_FORMAT, bundle2);
                        } catch (Exception e2) {
                            w.e("MicroMsg.MsgHandler", "doPreVerifyJSAPI remote ex, %s", new Object[]{e2.getMessage()});
                        }
                    }
                    this.sll.a(iVar2, "pre_verify_jsapi:ok", null);
                }

                public final boolean bzj() {
                    return this.sjJ;
                }
            };
            if (bg.mA(str) || linkedList.size() <= 0) {
                w.e("MicroMsg.webview.JSVerifyHelper", "handlePreVerify wrong args, %s", new Object[]{str});
                anonymousClass39.a(com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a.RET_FAIL, null, null, 0, 0);
            } else {
                ap.vd().a(1093, obj);
                ap.vd().a(new com.tencent.mm.plugin.webview.model.m(anonymousClass39, VD, str, linkedList, r9, r10, r11, r12, i2, str3, obj.rWF), 0);
            }
            return true;
        } catch (Exception e2) {
            w.w("MicroMsg.MsgHandler", "exception occur " + e2.getMessage());
            a(iVar, "pre_verify_jsapi:fail", null);
            return true;
        }
    }

    public final boolean ax(i iVar) {
        boolean z = false;
        final String str = (String) iVar.ozE.get("ssid");
        final String str2 = (String) iVar.ozE.get("password");
        w.d("MicroMsg.MsgHandler", "doConnectToWifi, ssid : %s, password : %s, encryptType : %s, hidessid : %s", new Object[]{str, str2, (String) iVar.ozE.get(Columns.TYPE), (String) iVar.ozE.get("isHidden")});
        if (bg.mA(str)) {
            w.e("MicroMsg.MsgHandler", "ssid is null");
            a(iVar, "connecttowifi:failed_ssid_invalid", null);
        } else {
            final int i = bg.getInt(r0, 0);
            if (i == 0 || !bg.mA(str2)) {
                if (bg.getInt(r1, 0) == 1) {
                    z = true;
                }
                com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                    final /* synthetic */ g sll;

                    public final void run() {
                        Intent intent = new Intent();
                        intent.putExtra("free_wifi_ssid", str);
                        intent.putExtra("free_wifi_source", 3);
                        intent.putExtra("free_wifi_passowrd", str2);
                        intent.putExtra("free_wifi_hide_ssid", z);
                        intent.putExtra("free_wifi_encrypt_type", i);
                        intent.addFlags(67108864);
                        com.tencent.mm.bb.d.b(this.sll.context, "freewifi", ".ui.FreeWifiEntryUI", intent);
                    }
                });
                a(iVar, "connecttowifi:ok", null);
            } else {
                w.e("MicroMsg.MsgHandler", "encrypt type, while the password is null");
                a(iVar, "connecttowifi:failed_password_invalid", null);
            }
        }
        return true;
    }

    public final boolean ay(i iVar) {
        Map hashMap = new HashMap();
        try {
            com.tencent.mm.sdk.b.b cyVar = new cy();
            cyVar.fGC.fGt = true;
            com.tencent.mm.sdk.b.a.urY.m(cyVar);
            if (cyVar.fGD.fGu) {
                hashMap.put("currentSSID", cyVar.fGD.fGE);
                a(iVar, "getCurrentSSID:ok", hashMap);
            } else {
                hashMap.put("err_desc", "not on wifi");
                a(iVar, "getCurrentSSID:fail", hashMap);
            }
        } catch (Exception e) {
            w.e("MicroMsg.MsgHandler", "getCurrentSSID:fail");
            hashMap.put("err_desc", "not on wifi");
            a(iVar, "getCurrentSSID:fail", hashMap);
        }
        return true;
    }

    public final boolean az(i iVar) {
        int bxA = bxA();
        int bzE = bzE();
        String bzD = bzD();
        w.i("MicroMsg.MsgHandler", "Key Scene(%d)", new Object[]{Integer.valueOf(bzE)});
        if (bzE == 27) {
            this.skx = (String) iVar.ozE.get("brandUserName");
            w.i("MicroMsg.MsgHandler", "BrandUserName from shake(%s)", new Object[]{this.skx});
        } else if (!(bxA == 8 || bxA == -1)) {
            this.kbi = (String) iVar.ozE.get("brandUserName");
            w.i("MicroMsg.MsgHandler", "BrandUserName from H5(%s)", new Object[]{this.kbi});
            if (!(bg.mA(bzD) || bg.mA(this.kbi))) {
                w.i("MicroMsg.MsgHandler", "Chat name(%s)", new Object[]{bzD});
                BizInfo hW = com.tencent.mm.modelbiz.e.hW(bzD);
                if (hW != null) {
                    ExtInfo bd = hW.bd(false);
                    if (!(bd == null || bd.Da() == null || !bd.Da().Dj() || bzD.equals(this.kbi))) {
                        a(iVar, "openWXDeviceLib:fail_UsernameError", null);
                        return true;
                    }
                }
            }
        }
        bzD = aJ(iVar);
        w.i("MicroMsg.MsgHandler", "srcUsername(%s)", new Object[]{bzD});
        if (bg.mA(bzD)) {
            a(iVar, "openWXDeviceLib:fail_UsernameError", null);
        } else {
            com.tencent.mm.plugin.report.service.g.oUh.i(11533, new Object[]{bzD, "openWXDeviceLib"});
            String str = "";
            if (iVar.ozE.containsKey("connType")) {
                str = (String) iVar.ozE.get("connType");
            }
            Object obj;
            if (str.equalsIgnoreCase("lan")) {
                if (this.skz == null) {
                    this.skz = new HashMap();
                }
                try {
                    com.tencent.mm.plugin.webview.ui.tools.a.a byJ = com.tencent.mm.plugin.webview.ui.tools.a.a.byJ();
                    com.tencent.mm.plugin.webview.stub.e eVar = this.rXh;
                    w.i("MicroMsg.webview.WebViewExDeviceLanMgr", "tryInit");
                    if (byJ.sgg == null) {
                        byJ.sgg = new com.tencent.mm.plugin.webview.ui.tools.a.a.a(eVar, bzD);
                        com.tencent.mm.sdk.b.a.urY.b(byJ.sgg.sgl);
                        com.tencent.mm.sdk.b.a.urY.b(byJ.sgg.sgm);
                        com.tencent.mm.sdk.b.a.urY.b(byJ.sgg.sgo);
                        com.tencent.mm.sdk.b.a.urY.b(byJ.sgg.sgn);
                        com.tencent.mm.sdk.b.a.urY.b(byJ.sgg.sgp);
                    }
                    com.tencent.mm.sdk.b.b drVar = new dr();
                    drVar.fHA.fGt = true;
                    com.tencent.mm.sdk.b.a.urY.m(drVar);
                    byJ.hasInit = true;
                    byJ.fGs = bzD;
                    byJ.sgi = null;
                    r.a(com.tencent.mm.plugin.webview.ui.tools.a.a.byJ());
                    if (am.isWifi(this.context)) {
                        obj = "on";
                    } else {
                        obj = "off";
                    }
                    Map hashMap = new HashMap();
                    hashMap.put("minVersion", Integer.valueOf(1));
                    hashMap.put("maxVersion", Integer.valueOf(1));
                    hashMap.put("lanState", obj);
                    a(iVar, "openWXDeviceLib:ok", hashMap);
                } catch (Exception e) {
                    w.e("MicroMsg.MsgHandler", "openWXDeviceLib failed : %s", new Object[]{e.getMessage()});
                    a(iVar, "openWXDeviceLib:fail_exception", null);
                }
            } else {
                if (this.sky == null) {
                    this.sky = new HashMap();
                }
                try {
                    com.tencent.mm.plugin.webview.ui.tools.a.b byM = com.tencent.mm.plugin.webview.ui.tools.a.b.byM();
                    com.tencent.mm.plugin.webview.stub.e eVar2 = this.rXh;
                    w.i("MicroMsg.webview.WebViewExDeviceMgr", "tryInit");
                    if (byM.sgr == null) {
                        byM.sgr = new com.tencent.mm.plugin.webview.ui.tools.a.b.a(eVar2, bzD);
                        com.tencent.mm.sdk.b.a.urY.b(byM.sgr.sgv);
                        com.tencent.mm.sdk.b.a.urY.b(byM.sgr.sgw);
                        com.tencent.mm.sdk.b.a.urY.b(byM.sgr.sgx);
                        com.tencent.mm.sdk.b.a.urY.b(byM.sgr.sgl);
                        com.tencent.mm.sdk.b.a.urY.b(byM.sgr.psI);
                    }
                    com.tencent.mm.sdk.b.b dlVar = new dl();
                    dlVar.fHt.op = 1;
                    com.tencent.mm.sdk.b.a.urY.m(dlVar);
                    byM.hasInit = true;
                    byM.fGs = bzD;
                    byM.sgi = null;
                    r.a(com.tencent.mm.plugin.webview.ui.tools.a.b.byM());
                    BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                    if (defaultAdapter != null) {
                        obj = "unknow";
                        switch (defaultAdapter.getState()) {
                            case 10:
                                obj = "off";
                                break;
                            case 11:
                                obj = "resetting";
                                break;
                            case 12:
                                obj = "on";
                                break;
                            default:
                                break;
                        }
                    }
                    obj = "unknow";
                    w.i("MicroMsg.webview.ExDeviceBluetoothUtil", "isBLESupported, ret = %b", new Object[]{Boolean.valueOf(ab.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le"))});
                    Map hashMap2 = new HashMap();
                    hashMap2.put("minVersion", Integer.valueOf(1));
                    hashMap2.put("maxVersion", Integer.valueOf(1));
                    hashMap2.put("bluetoothState", obj);
                    hashMap2.put("isSupportBLE", ab.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le") ? "yes" : "no");
                    if (bxA == 1) {
                        hashMap2.put("OS", "android");
                    }
                    a(iVar, "openWXDeviceLib:ok", hashMap2);
                } catch (Exception e2) {
                    w.e("MicroMsg.MsgHandler", "openWXDeviceLib failed : %s", new Object[]{e2.getMessage()});
                    a(iVar, "openWXDeviceLib:fail_exception", null);
                }
            }
        }
        return true;
    }

    public final boolean aA(i iVar) {
        String str = "";
        if (iVar.ozE.containsKey("connType")) {
            str = (String) iVar.ozE.get("connType");
        }
        if (str.equalsIgnoreCase("lan")) {
            try {
                str = aJ(iVar);
                com.tencent.mm.plugin.report.service.g.oUh.i(11533, new Object[]{str, "closeWXDeviceLib"});
                com.tencent.mm.plugin.webview.ui.tools.a.a.byJ().byK();
            } catch (Exception e) {
                w.e("MicroMsg.MsgHandler", "closeWXDeviceLib failed : %s", new Object[]{e.getMessage()});
                a(iVar, "closeWXDeviceLib:fail_exception", null);
            }
        } else {
            try {
                str = aJ(iVar);
                com.tencent.mm.plugin.report.service.g.oUh.i(11533, new Object[]{str, "closeWXDeviceLib"});
                com.tencent.mm.plugin.webview.ui.tools.a.b.byM().byK();
            } catch (Exception e2) {
                w.e("MicroMsg.MsgHandler", "closeWXDeviceLib failed : %s", new Object[]{e2.getMessage()});
                a(iVar, "closeWXDeviceLib:fail_exception", null);
            }
        }
        a(iVar, "closeWXDeviceLib:ok", null);
        return true;
    }

    public final boolean aB(i iVar) {
        String str = "";
        if (iVar.ozE.containsKey("connType")) {
            str = (String) iVar.ozE.get("connType");
        }
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.byJ().hasInit) {
                try {
                    w.i("MicroMsg.MsgHandler", "srcUsername(%s)", new Object[]{aJ(iVar)});
                    com.tencent.mm.plugin.report.service.g.oUh.i(11533, new Object[]{str, "startScanWXDevice"});
                    if (bg.mA(aJ(iVar))) {
                        a(iVar, "startScanWXDevice:fail_UsernameError", null);
                    } else {
                        com.tencent.mm.sdk.b.b eiVar = new ei();
                        eiVar.fIk.fGt = true;
                        com.tencent.mm.sdk.b.a.urY.m(eiVar);
                        com.tencent.mm.plugin.webview.ui.tools.a.a.byJ().sgk = true;
                        a(iVar, "startScanWXDevice:ok", null);
                    }
                } catch (Exception e) {
                    w.e("MicroMsg.MsgHandler", "startScanWXDevice failed : %s", new Object[]{e.getMessage()});
                    a(iVar, "startScanWXDevice:fail_exception", null);
                }
            } else {
                w.e("MicroMsg.MsgHandler", "startScanWXDevice not init");
                a(iVar, "startScanWXDevice:fail_notInit", null);
            }
        } else if (com.tencent.mm.compatible.util.f.eo(23) && !((LocationManager) this.context.getSystemService("location")).isProviderEnabled("gps") && !VERSION.RELEASE.equalsIgnoreCase("6.0") && !VERSION.RELEASE.equalsIgnoreCase("6.0.0")) {
            w.d("MicroMsg.MsgHandler", "Android version realse code: %s", new Object[]{VERSION.RELEASE});
            w.e("MicroMsg.MsgHandler", "ScannerInThisAndroidVersionRequireGPSServiceOn");
            a(iVar, "startScanWXDevice:fail_ThisAndroidVersionRequireGPSServiceOn", null);
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.byM().hasInit) {
            try {
                String aJ = aJ(iVar);
                str = (String) iVar.ozE.get("btVersion");
                w.i("MicroMsg.MsgHandler", "BtVersion(%s), srcUsername(%s)", new Object[]{str, aJ});
                com.tencent.mm.plugin.report.service.g.oUh.i(11533, new Object[]{aJ, "startScanWXDevice"});
                if (bg.mA(aJ)) {
                    a(iVar, "startScanWXDevice:fail_UsernameError", null);
                } else {
                    com.tencent.mm.sdk.b.b dsVar = new ds();
                    dsVar.fHB.fGt = true;
                    dsVar.fHB.fGs = aJ;
                    if (bg.mz(str).equals("ble")) {
                        dsVar.fHB.fHD = 0;
                    } else if (bg.mz(str).equals("bc")) {
                        dsVar.fHB.fHD = 1;
                    }
                    com.tencent.mm.plugin.webview.ui.tools.a.b.byM().sgt = dsVar.fHB.fHD;
                    com.tencent.mm.sdk.b.a.urY.m(dsVar);
                    if (dsVar.fHC.fGu) {
                        com.tencent.mm.plugin.webview.ui.tools.a.b.byM().sgk = true;
                        a(iVar, "startScanWXDevice:ok", null);
                    } else {
                        a(iVar, "startScanWXDevice:fail", null);
                    }
                }
            } catch (Exception e2) {
                w.e("MicroMsg.MsgHandler", "startScanWXDevice failed : %s", new Object[]{e2.getMessage()});
                a(iVar, "startScanWXDevice:fail_exception", null);
            }
        } else {
            w.e("MicroMsg.MsgHandler", "startScanWXDevice not init");
            a(iVar, "startScanWXDevice:fail_notInit", null);
        }
        return true;
    }

    public final boolean aC(i iVar) {
        String str = "";
        if (iVar.ozE.containsKey("connType")) {
            str = (String) iVar.ozE.get("connType");
        }
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.byJ().hasInit) {
                try {
                    str = aJ(iVar);
                    com.tencent.mm.plugin.report.service.g.oUh.i(11533, new Object[]{str, "stopScanWXDevice"});
                    if (bg.mA(str)) {
                        a(iVar, "stopScanWXDevice:fail_UsernameError", null);
                    } else {
                        com.tencent.mm.sdk.b.b eiVar = new ei();
                        eiVar.fIk.fGt = false;
                        com.tencent.mm.sdk.b.a.urY.m(eiVar);
                        com.tencent.mm.plugin.webview.ui.tools.a.a.byJ().sgk = false;
                        a(iVar, "stopScanWXDevice:ok", null);
                    }
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
                    w.e("MicroMsg.MsgHandler", "stopScanWXDevice failed : %s", new Object[]{e.getMessage()});
                    a(iVar, "stopScanWXDevice:fail_exception", null);
                }
            } else {
                w.e("MicroMsg.MsgHandler", "stopScanWXDevice not init");
                a(iVar, "stopScanWXDevice:fail_notInit", null);
            }
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.byM().hasInit) {
            try {
                str = aJ(iVar);
                com.tencent.mm.plugin.report.service.g.oUh.i(11533, new Object[]{str, "stopScanWXDevice"});
                if (bg.mA(str)) {
                    a(iVar, "stopScanWXDevice:fail_UsernameError", null);
                } else {
                    com.tencent.mm.sdk.b.b dsVar = new ds();
                    dsVar.fHB.fGt = false;
                    dsVar.fHB.fGs = str;
                    dsVar.fHB.fHD = com.tencent.mm.plugin.webview.ui.tools.a.b.byM().sgt;
                    com.tencent.mm.sdk.b.a.urY.m(dsVar);
                    if (dsVar.fHC.fGu) {
                        com.tencent.mm.plugin.webview.ui.tools.a.b.byM().sgk = false;
                        a(iVar, "stopScanWXDevice:ok", null);
                    } else {
                        w.e("MicroMsg.MsgHandler", "stopScanWXDevice fail");
                        a(iVar, "stopScanWXDevice:fail", null);
                    }
                }
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
                w.e("MicroMsg.MsgHandler", "stopScanWXDevice failed : %s", new Object[]{e2.getMessage()});
                a(iVar, "stopScanWXDevice:fail_exception", null);
            }
        } else {
            w.e("MicroMsg.MsgHandler", "stopScanWXDevice not init");
            a(iVar, "stopScanWXDevice:fail_notInit", null);
        }
        return true;
    }

    public final boolean aD(i iVar) {
        String str = "";
        if (iVar.ozE.containsKey("connType")) {
            str = (String) iVar.ozE.get("connType");
        }
        String aJ;
        com.tencent.mm.sdk.b.b cvVar;
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.byJ().hasInit) {
                str = (String) iVar.ozE.get("deviceId");
                w.i("MicroMsg.MsgHandler", "doConnectWXDevice, deviceId : %s", new Object[]{str});
                if (bg.mA(str)) {
                    w.e("MicroMsg.MsgHandler", "deviceId is null");
                    a(iVar, "connectWXDevice:fail_noDeviceId", null);
                } else {
                    aJ = aJ(iVar);
                    com.tencent.mm.plugin.report.service.g.oUh.i(11533, new Object[]{aJ, "connectWXDevice"});
                    if (bg.mA(aJ)) {
                        a(iVar, "connectWXDevice:fail_UsernameError", null);
                    } else {
                        if (!(this.skz == null || this.skz.containsKey(aJ))) {
                            this.skz.put(aJ, str);
                        }
                        try {
                            cvVar = new cv();
                            cvVar.fGv.fGt = true;
                            cvVar.fGv.fGs = aJ;
                            cvVar.fGv.fwJ = str;
                            com.tencent.mm.sdk.b.a.urY.m(cvVar);
                            if (cvVar.fGw.fGu) {
                                a(iVar, "connectWXDevice:ok", null);
                            } else {
                                a(iVar, "connectWXDevice:fail", null);
                            }
                        } catch (Exception e) {
                            w.e("MicroMsg.MsgHandler", "connectWXDevice failed : %s", new Object[]{e.getMessage()});
                            a(iVar, "connectWXDevice:fail_exception", null);
                        }
                    }
                }
            } else {
                w.e("MicroMsg.MsgHandler", "connectWXDevice not init");
                a(iVar, "connectWXDevice:fail_notInit", null);
            }
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.byM().hasInit) {
            str = (String) iVar.ozE.get("deviceId");
            w.i("MicroMsg.MsgHandler", "doConnectWXDevice, deviceId : %s", new Object[]{str});
            if (bg.mA(str)) {
                w.e("MicroMsg.MsgHandler", "deviceId is null");
                a(iVar, "connectWXDevice:fail_noDeviceId", null);
            } else {
                aJ = aJ(iVar);
                com.tencent.mm.plugin.report.service.g.oUh.i(11533, new Object[]{aJ, "connectWXDevice"});
                if (bg.mA(aJ)) {
                    a(iVar, "connectWXDevice:fail_UsernameError", null);
                } else {
                    if (!(this.sky == null || this.sky.containsValue(str))) {
                        this.sky.put(aJ, str);
                    }
                    try {
                        cvVar = new cu();
                        cvVar.fGq.fGt = true;
                        cvVar.fGq.fGs = aJ;
                        cvVar.fGq.fwJ = str;
                        com.tencent.mm.sdk.b.a.urY.m(cvVar);
                        if (cvVar.fGr.fGu) {
                            a(iVar, "connectWXDevice:ok", null);
                        } else {
                            a(iVar, "connectWXDevice:fail", null);
                        }
                    } catch (Exception e2) {
                        w.e("MicroMsg.MsgHandler", "connectWXDevice failed : %s", new Object[]{e2.getMessage()});
                        a(iVar, "connectWXDevice:fail_exception", null);
                    }
                }
            }
        } else {
            w.e("MicroMsg.MsgHandler", "connectWXDevice not init");
            a(iVar, "connectWXDevice:fail_notInit", null);
        }
        return true;
    }

    public final boolean aE(i iVar) {
        String str = "";
        if (iVar.ozE.containsKey("connType")) {
            str = (String) iVar.ozE.get("connType");
        }
        String aJ;
        com.tencent.mm.sdk.b.b cvVar;
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.byJ().hasInit) {
                str = (String) iVar.ozE.get("deviceId");
                w.i("MicroMsg.MsgHandler", "doDisconnectWXDevice, deviceId : %s", new Object[]{str});
                if (bg.mA(str)) {
                    w.e("MicroMsg.MsgHandler", "deviceId is null");
                    a(iVar, "disconnectWXDevice:fail_noDeviceId", null);
                } else {
                    aJ = aJ(iVar);
                    com.tencent.mm.plugin.report.service.g.oUh.i(11533, new Object[]{aJ, "disconnectWXDevice"});
                    if (bg.mA(aJ)) {
                        a(iVar, "disconnectWXDevice:fail_UsernameError", null);
                    } else {
                        try {
                            cvVar = new cv();
                            cvVar.fGv.fGt = false;
                            cvVar.fGv.fGs = aJ;
                            cvVar.fGv.fwJ = str;
                            com.tencent.mm.sdk.b.a.urY.m(cvVar);
                            if (cvVar.fGw.fGu) {
                                a(iVar, "disconnectWXDevice:ok", null);
                                if (this.skz != null && this.skz.containsKey(aJ)) {
                                    this.skz.remove(aJ);
                                }
                            } else {
                                a(iVar, "disconnectWXDevice:fail", null);
                            }
                        } catch (Exception e) {
                            w.e("MicroMsg.MsgHandler", "disconnectWXDevice failed : %s", new Object[]{e.getMessage()});
                            a(iVar, "disconnectWXDevice:fail_exception", null);
                        }
                    }
                }
            } else {
                w.e("MicroMsg.MsgHandler", "disconnectWXDevice  not init");
                a(iVar, "disconnectWXDevice:fail_notInit", null);
            }
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.byM().hasInit) {
            str = (String) iVar.ozE.get("deviceId");
            w.i("MicroMsg.MsgHandler", "doDisconnectWXDevice, deviceId : %s", new Object[]{str});
            if (bg.mA(str)) {
                w.e("MicroMsg.MsgHandler", "deviceId is null");
                a(iVar, "disconnectWXDevice:fail_noDeviceId", null);
            } else {
                aJ = aJ(iVar);
                com.tencent.mm.plugin.report.service.g.oUh.i(11533, new Object[]{aJ, "disconnectWXDevice"});
                if (bg.mA(aJ)) {
                    a(iVar, "disconnectWXDevice:fail_UsernameError", null);
                } else {
                    try {
                        cvVar = new cu();
                        cvVar.fGq.fGt = false;
                        cvVar.fGq.fGs = aJ;
                        cvVar.fGq.fwJ = str;
                        com.tencent.mm.sdk.b.a.urY.m(cvVar);
                        if (cvVar.fGr.fGu) {
                            a(iVar, "disconnectWXDevice:ok", null);
                            if (this.sky != null && this.sky.containsKey(aJ)) {
                                this.sky.remove(aJ);
                            }
                        } else {
                            a(iVar, "disconnectWXDevice:fail", null);
                        }
                    } catch (Exception e2) {
                        w.e("MicroMsg.MsgHandler", "disconnectWXDevice failed : %s", new Object[]{e2.getMessage()});
                        a(iVar, "disconnectWXDevice:fail_exception", null);
                    }
                }
            }
        } else {
            w.e("MicroMsg.MsgHandler", "disconnectWXDevice  not init");
            a(iVar, "disconnectWXDevice:fail_notInit", null);
        }
        return true;
    }

    public final boolean aF(final i iVar) {
        if (com.tencent.mm.plugin.webview.ui.tools.a.b.byM().hasInit || com.tencent.mm.plugin.webview.ui.tools.a.a.byJ().hasInit) {
            String str = (String) iVar.ozE.get("deviceId");
            String str2 = (String) iVar.ozE.get(Columns.TYPE);
            w.i("MicroMsg.MsgHandler", "doGetWXDeviceTicket, deviceId : %s, type : %s", new Object[]{str, str2});
            if (bg.mA(str) || bg.mA(str2)) {
                w.e("MicroMsg.MsgHandler", "deviceId or type is null");
                a(iVar, "getWXDeviceTicket:fail_wrongParams", null);
            } else {
                try {
                    String aJ = aJ(iVar);
                    com.tencent.mm.plugin.report.service.g.oUh.i(11533, new Object[]{aJ, "getWXDeviceTicket"});
                    if (bg.mA(aJ)) {
                        a(iVar, "getWXDeviceTicket:fail_UsernameError", null);
                    } else {
                        final com.tencent.mm.sdk.b.b dcVar = new dc();
                        dcVar.fGR.type = bg.getInt(str2, 0);
                        dcVar.fGR.fGs = aJ;
                        dcVar.fGR.fwJ = str;
                        dcVar.fGR.fGT = iVar.smL;
                        dcVar.nFq = new Runnable(this) {
                            final /* synthetic */ g sll;

                            public final void run() {
                                w.i("MicroMsg.MsgHandler", "ExDeviceGetTicketEvent isOk[%s], ticket[%s]", new Object[]{Boolean.valueOf(dcVar.fGS.fGU), dcVar.fGS.fGV});
                                if (!dcVar.fGS.fGU) {
                                    return;
                                }
                                if (bg.mA(dcVar.fGS.fGV)) {
                                    this.sll.a(iVar, "getWXDeviceTicket:fail", null);
                                    return;
                                }
                                Map hashMap = new HashMap();
                                w.i("MicroMsg.MsgHandler", "ticket %s", new Object[]{dcVar.fGS.fGV});
                                hashMap.put("ticket", dcVar.fGS.fGV);
                                this.sll.a(iVar, "getWXDeviceTicket:ok", hashMap);
                            }
                        };
                        com.tencent.mm.sdk.b.a.urY.a(dcVar, Looper.getMainLooper());
                    }
                } catch (Exception e) {
                    w.e("MicroMsg.MsgHandler", "getWXDeviceTicket failed : %s", new Object[]{e.getMessage()});
                    a(iVar, "getWXDeviceTicket:fail_exception", null);
                }
            }
        } else {
            w.e("MicroMsg.MsgHandler", "getWXDeviceTicket not init");
            a(iVar, "getWXDeviceTicket:fail_notInit", null);
        }
        return true;
    }

    public final boolean aG(i iVar) {
        String str = "";
        if (iVar.ozE.containsKey("connType")) {
            str = (String) iVar.ozE.get("connType");
        }
        com.tencent.mm.sdk.b.b daVar;
        Map hashMap;
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.byJ().hasInit) {
                try {
                    str = aJ(iVar);
                    com.tencent.mm.plugin.report.service.g.oUh.i(11533, new Object[]{str, "getWXDeviceInfos"});
                    w.i("MicroMsg.MsgHandler", "doGetWXDeviceInfos, %s", new Object[]{str});
                    if (bg.mA(str)) {
                        a(iVar, "getWXDeviceInfos:fail_UsernameError", null);
                    } else {
                        daVar = new da();
                        daVar.fGI.fGs = str;
                        daVar.fGI.context = this.context;
                        com.tencent.mm.sdk.b.a.urY.m(daVar);
                        if (!daVar.fGJ.fGu || daVar.fGJ.fGH == null) {
                            a(iVar, "getWXDeviceInfos:fail", null);
                        } else {
                            hashMap = new HashMap();
                            hashMap.put("jsapi_callback_json_special_key", "deviceInfos");
                            hashMap.put("deviceInfos", daVar.fGJ.fGH.toString());
                            a(iVar, "getWXDeviceInfos:ok", hashMap);
                        }
                    }
                } catch (Exception e) {
                    w.e("MicroMsg.MsgHandler", "getWXDeviceInfos failed : %s", new Object[]{e.getMessage()});
                    a(iVar, "getWXDeviceInfos:fail_exception", null);
                }
            } else {
                w.e("MicroMsg.MsgHandler", "getWXDeviceInfos not init");
                a(iVar, "getWXDeviceInfos:fail_notInit", null);
            }
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.byM().hasInit) {
            try {
                str = aJ(iVar);
                com.tencent.mm.plugin.report.service.g.oUh.i(11533, new Object[]{str, "getWXDeviceInfos"});
                w.i("MicroMsg.MsgHandler", "doGetWXDeviceInfos, %s", new Object[]{str});
                if (bg.mA(str)) {
                    a(iVar, "getWXDeviceInfos:fail_UsernameError", null);
                } else {
                    daVar = new cz();
                    daVar.fGF.fGs = str;
                    daVar.fGF.context = this.context;
                    com.tencent.mm.sdk.b.a.urY.m(daVar);
                    if (!daVar.fGG.fGu || daVar.fGG.fGH == null) {
                        a(iVar, "getWXDeviceInfos:fail", null);
                    } else {
                        hashMap = new HashMap();
                        hashMap.put("jsapi_callback_json_special_key", "deviceInfos");
                        hashMap.put("deviceInfos", daVar.fGG.fGH.toString());
                        a(iVar, "getWXDeviceInfos:ok", hashMap);
                    }
                }
            } catch (Exception e2) {
                w.e("MicroMsg.MsgHandler", "getWXDeviceInfos failed : %s", new Object[]{e2.getMessage()});
                a(iVar, "getWXDeviceInfos:fail_exception", null);
            }
        } else {
            w.e("MicroMsg.MsgHandler", "getWXDeviceInfos not init");
            a(iVar, "getWXDeviceInfos:fail_notInit", null);
        }
        return true;
    }

    public final boolean aH(i iVar) {
        String str = "";
        if (iVar.ozE.containsKey("connType")) {
            str = (String) iVar.ozE.get("connType");
        }
        String str2;
        String str3;
        String str4;
        Object[] objArr;
        boolean z;
        String aJ;
        com.tencent.mm.sdk.b.b dvVar;
        if (str.equalsIgnoreCase("lan")) {
            if (com.tencent.mm.plugin.webview.ui.tools.a.a.byJ().hasInit) {
                str = (String) iVar.ozE.get("deviceId");
                str2 = (String) iVar.ozE.get("base64Data");
                str3 = "MicroMsg.MsgHandler";
                str4 = "doSendDataToWXDevice, deviceId : %s, has data : %s";
                objArr = new Object[2];
                objArr[0] = str;
                if (bg.mA(str2)) {
                    z = false;
                } else {
                    z = true;
                }
                objArr[1] = Boolean.valueOf(z);
                w.i(str3, str4, objArr);
                if (bg.mA(str) || str2 == null) {
                    w.e("MicroMsg.MsgHandler", "deviceId or data is null");
                    a(iVar, "sendDataToWXDevice:fail_wrongParams", null);
                } else {
                    try {
                        aJ = aJ(iVar);
                        com.tencent.mm.plugin.report.service.g.oUh.i(11533, new Object[]{aJ, "sendDataToWXDevice"});
                        if (bg.mA(aJ)) {
                            a(iVar, "sendDataToWXDevice:fail_UsernameError", null);
                        } else {
                            dvVar = new dv();
                            dvVar.fHI.fGs = aJ;
                            dvVar.fHI.data = str2;
                            dvVar.fHI.fwJ = str;
                            com.tencent.mm.sdk.b.a.urY.m(dvVar);
                            if (dvVar.fHJ.fGu) {
                                a(iVar, "sendDataToWXDevice:ok", null);
                            } else {
                                a(iVar, "sendDataToWXDevice:fail", null);
                            }
                        }
                    } catch (Exception e) {
                        w.e("MicroMsg.MsgHandler", "sendDataToWXDevice failed : %s", new Object[]{e.getMessage()});
                        a(iVar, "sendDataToWXDevice:fail_exception", null);
                    }
                }
            } else {
                w.e("MicroMsg.MsgHandler", "sendDataToWXDevice not init");
                a(iVar, "sendDataToWXDevice:fail_notInit", null);
            }
        } else if (com.tencent.mm.plugin.webview.ui.tools.a.b.byM().hasInit) {
            str = (String) iVar.ozE.get("deviceId");
            str2 = (String) iVar.ozE.get("base64Data");
            str3 = "MicroMsg.MsgHandler";
            str4 = "doSendDataToWXDevice, deviceId : %s, has data : %s";
            objArr = new Object[2];
            objArr[0] = str;
            if (bg.mA(str2)) {
                z = false;
            } else {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            w.i(str3, str4, objArr);
            if (bg.mA(str) || str2 == null) {
                w.e("MicroMsg.MsgHandler", "deviceId or data is null");
                a(iVar, "sendDataToWXDevice:fail_wrongParams", null);
            } else {
                try {
                    aJ = aJ(iVar);
                    com.tencent.mm.plugin.report.service.g.oUh.i(11533, new Object[]{aJ, "sendDataToWXDevice"});
                    if (bg.mA(aJ)) {
                        a(iVar, "sendDataToWXDevice:fail_UsernameError", null);
                    } else {
                        dvVar = new du();
                        dvVar.fHG.fGs = aJ;
                        dvVar.fHG.data = Base64.decode(str2, 0);
                        dvVar.fHG.fwJ = str;
                        com.tencent.mm.sdk.b.a.urY.m(dvVar);
                        if (dvVar.fHH.fGu) {
                            a(iVar, "sendDataToWXDevice:ok", null);
                        } else {
                            a(iVar, "sendDataToWXDevice:fail", null);
                        }
                    }
                } catch (Exception e2) {
                    w.e("MicroMsg.MsgHandler", "sendDataToWXDevice failed : %s", new Object[]{e2.getMessage()});
                    a(iVar, "sendDataToWXDevice:fail_exception", null);
                }
            }
        } else {
            w.e("MicroMsg.MsgHandler", "sendDataToWXDevice not init");
            a(iVar, "sendDataToWXDevice:fail_notInit", null);
        }
        return true;
    }

    public final boolean aI(i iVar) {
        if (com.tencent.mm.plugin.webview.ui.tools.a.b.byM().hasInit) {
            try {
                String str = (String) iVar.ozE.get("deviceId");
                String str2 = (String) iVar.ozE.get(TencentLocation.EXTRA_DIRECTION);
                w.i("MicroMsg.MsgHandler", "setSendDataDirection, deviceId = %s, direction = %s", new Object[]{str, str2});
                if (bg.mA(str) || bg.mA(str2)) {
                    w.e("MicroMsg.MsgHandler", "wrong args");
                    a(iVar, "setSendDataDirection:fail_wrongParams", null);
                } else {
                    int i = bg.getInt(str2, 0);
                    String aJ = aJ(iVar);
                    com.tencent.mm.plugin.report.service.g.oUh.i(11533, new Object[]{aJ, "setSendDataDirection"});
                    if (bg.mA(aJ)) {
                        a(iVar, "setSendDataDirection:fail_UsernameError", null);
                    } else {
                        com.tencent.mm.sdk.b.b dyVar = new dy();
                        dyVar.fHS.fwJ = str;
                        dyVar.fHS.direction = i;
                        dyVar.fHS.clear = false;
                        com.tencent.mm.sdk.b.a.urY.m(dyVar);
                        if (dyVar.fHT.fGu) {
                            a(iVar, "setSendDataDirection:ok", null);
                        } else {
                            a(iVar, "setSendDataDirection:fail", null);
                        }
                    }
                }
            } catch (Exception e) {
                w.e("MicroMsg.MsgHandler", "setSendDataDirection failed : %s", new Object[]{e.getMessage()});
                a(iVar, "setSendDataDirection:fail_exception", null);
            }
        } else {
            w.e("MicroMsg.MsgHandler", "setSendDataDirection not init");
            a(iVar, "setSendDataDirection:fail_notInit", null);
        }
        return true;
    }

    public String bzD() {
        String str = null;
        try {
            if (this.rXh != null) {
                Bundle d = this.rXh.d(18, null);
                if (d != null) {
                    str = d.getString("preChatName");
                }
            }
        } catch (RemoteException e) {
            w.e("MicroMsg.MsgHandler", "invokeAsResult error.%s", new Object[]{e});
        }
        return str;
    }

    public int bxA() {
        int i = -1;
        try {
            if (this.rXh != null) {
                Bundle d = this.rXh.d(22, null);
                if (d != null) {
                    i = d.getInt("pay_channel");
                }
            }
        } catch (RemoteException e) {
            w.e("MicroMsg.MsgHandler", "invokeAsResult error.%s", new Object[]{e});
        }
        return i;
    }

    public int bzE() {
        int i = 0;
        try {
            if (this.rXh != null) {
                Bundle d = this.rXh.d(25, null);
                if (d != null) {
                    i = d.getInt("scene");
                }
            }
        } catch (RemoteException e) {
            w.e("MicroMsg.MsgHandler", "invokeAsResult error.%s", new Object[]{e});
        }
        return i;
    }

    private int UP() {
        int i = 0;
        try {
            if (this.rXh != null) {
                Bundle d = this.rXh.d(99, null);
                if (d != null) {
                    i = d.getInt("geta8key_scene");
                }
            }
        } catch (RemoteException e) {
            w.e("MicroMsg.MsgHandler", "invokeAsResult error.%s", new Object[]{e});
        }
        return i;
    }

    private String aJ(i iVar) {
        String bzD = bzD();
        if (bzE() == 27) {
            return this.skx;
        }
        String str;
        if (bxA() == 8 || bxA() == -1) {
            if (iVar == null) {
                return null;
            }
            str = (String) iVar.ozE.get("src_username");
            w.i("MicroMsg.MsgHandler", "key_src_username(%s)", new Object[]{(String) iVar.ozE.get("src_username")});
            return str;
        } else if (this.kbi != null) {
            return this.kbi;
        } else {
            if (bg.mA(bzD)) {
                return null;
            }
            w.i("MicroMsg.MsgHandler", "BrandUsername in H5 is null, check if it is in hardBiz chat");
            BizInfo hW = com.tencent.mm.modelbiz.e.hW(bzD);
            if (hW == null) {
                return null;
            }
            ExtInfo bd = hW.bd(false);
            if (bd == null || bd.Da() == null || !bd.Da().Dj()) {
                return null;
            }
            str = (String) iVar.ozE.get("src_username");
            w.i("MicroMsg.MsgHandler", "HardBiz chat, key_src_username(%s)", new Object[]{(String) iVar.ozE.get("src_username")});
            return str;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean aK(com.tencent.mm.plugin.webview.ui.tools.jsapi.i r14) {
        /*
        r13 = this;
        r6 = 7;
        r12 = 2;
        r2 = 3;
        r11 = 1;
        r5 = 0;
        r0 = r14.ozE;
        r1 = "sourceType";
        r0 = r0.get(r1);
        r0 = (java.lang.String) r0;
        r1 = "MicroMsg.MsgHandler";
        r3 = "source Type = %s";
        r4 = new java.lang.Object[r11];
        r4[r5] = r0;
        com.tencent.mm.sdk.platformtools.w.i(r1, r3, r4);
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r1 != 0) goto L_0x019c;
    L_0x0023:
        r3 = new org.json.JSONArray;	 Catch:{ Exception -> 0x0052 }
        r3.<init>(r0);	 Catch:{ Exception -> 0x0052 }
        r1 = r5;
        r0 = r5;
    L_0x002a:
        r4 = r3.length();	 Catch:{ Exception -> 0x0192 }
        if (r1 >= r4) goto L_0x005d;
    L_0x0030:
        r4 = r3.getString(r1);	 Catch:{ Exception -> 0x0192 }
        r7 = "album";
        r4 = r4.equals(r7);	 Catch:{ Exception -> 0x0192 }
        if (r4 == 0) goto L_0x0042;
    L_0x003d:
        r0 = r0 | 1;
    L_0x003f:
        r1 = r1 + 1;
        goto L_0x002a;
    L_0x0042:
        r4 = r3.getString(r1);	 Catch:{ Exception -> 0x0192 }
        r7 = "camera";
        r4 = r4.equals(r7);	 Catch:{ Exception -> 0x0192 }
        if (r4 == 0) goto L_0x003f;
    L_0x004f:
        r0 = r0 | 2;
        goto L_0x003f;
    L_0x0052:
        r0 = move-exception;
        r0 = r5;
    L_0x0054:
        r1 = "MicroMsg.MsgHandler";
        r3 = "doChooseImage: sizeType parsing error";
        com.tencent.mm.sdk.platformtools.w.e(r1, r3);
    L_0x005d:
        if (r0 != 0) goto L_0x0199;
    L_0x005f:
        r1 = r2;
    L_0x0060:
        r0 = "MicroMsg.MsgHandler";
        r3 = "real scene = %d";
        r4 = new java.lang.Object[r11];
        r7 = java.lang.Integer.valueOf(r1);
        r4[r5] = r7;
        com.tencent.mm.sdk.platformtools.w.i(r0, r3, r4);
        if (r1 == r12) goto L_0x0075;
    L_0x0073:
        if (r1 != r2) goto L_0x009c;
    L_0x0075:
        r0 = r13.context;
        r0 = (android.app.Activity) r0;
        r3 = "android.permission.CAMERA";
        r4 = 113; // 0x71 float:1.58E-43 double:5.6E-322;
        r7 = "";
        r8 = "";
        r0 = com.tencent.mm.pluginsdk.i.a.a(r0, r3, r4, r7, r8);
        r3 = "MicroMsg.MsgHandler";
        r4 = " checkPermission checkcamera[%b]";
        r7 = new java.lang.Object[r11];
        r8 = java.lang.Boolean.valueOf(r0);
        r7[r5] = r8;
        com.tencent.mm.sdk.platformtools.w.d(r3, r4, r7);
        if (r0 != 0) goto L_0x009c;
    L_0x009b:
        return r11;
    L_0x009c:
        r0 = r14.ozE;
        r3 = "count";
        r0 = r0.get(r3);
        r0 = (java.lang.String) r0;
        r7 = com.tencent.mm.sdk.platformtools.bg.getInt(r0, r5);
        r0 = r14.ozE;
        r3 = "sizeType";
        r0 = r0.get(r3);
        r0 = (java.lang.String) r0;
        r4 = java.lang.Boolean.valueOf(r5);
        r3 = java.lang.Boolean.valueOf(r5);
        r8 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r8 != 0) goto L_0x0195;
    L_0x00c4:
        r8 = new org.json.JSONArray;	 Catch:{ Exception -> 0x00fa }
        r8.<init>(r0);	 Catch:{ Exception -> 0x00fa }
        r0 = r3;
        r3 = r4;
        r4 = r5;
    L_0x00cc:
        r9 = r8.length();	 Catch:{ Exception -> 0x018f }
        if (r4 >= r9) goto L_0x0106;
    L_0x00d2:
        r9 = r8.getString(r4);	 Catch:{ Exception -> 0x018f }
        r10 = "original";
        r9 = r9.equals(r10);	 Catch:{ Exception -> 0x018f }
        if (r9 == 0) goto L_0x00e7;
    L_0x00df:
        r9 = 1;
        r3 = java.lang.Boolean.valueOf(r9);	 Catch:{ Exception -> 0x018f }
    L_0x00e4:
        r4 = r4 + 1;
        goto L_0x00cc;
    L_0x00e7:
        r9 = r8.getString(r4);	 Catch:{ Exception -> 0x018f }
        r10 = "compressed";
        r9 = r9.equals(r10);	 Catch:{ Exception -> 0x018f }
        if (r9 == 0) goto L_0x00e4;
    L_0x00f4:
        r9 = 1;
        r0 = java.lang.Boolean.valueOf(r9);	 Catch:{ Exception -> 0x018f }
        goto L_0x00e4;
    L_0x00fa:
        r0 = move-exception;
        r0 = r3;
        r3 = r4;
    L_0x00fd:
        r4 = "MicroMsg.MsgHandler";
        r8 = "doChooseImage: sizeType parsing error";
        com.tencent.mm.sdk.platformtools.w.e(r4, r8);
    L_0x0106:
        r4 = r3.booleanValue();
        if (r4 == 0) goto L_0x0175;
    L_0x010c:
        r4 = r0.booleanValue();
        if (r4 != 0) goto L_0x0175;
    L_0x0112:
        r0 = java.lang.Boolean.valueOf(r11);
        r4 = r6;
    L_0x0117:
        r3 = new android.content.Intent;
        r3.<init>();
        r6 = "key_pick_local_pic_capture";
        r3.putExtra(r6, r1);
        r6 = "key_pick_local_pic_count";
        r3.putExtra(r6, r7);
        r6 = "key_pick_local_pic_query_source_type";
        r3.putExtra(r6, r4);
        r6 = "key_pick_local_pic_send_raw";
        r3.putExtra(r6, r0);
        r6 = "query_media_type";
        r3.putExtra(r6, r11);
        r6 = "MicroMsg.MsgHandler";
        r8 = "doChooseImage: realScene: %d, count: %d, querySourceType: %d, sendRaw: %b";
        r9 = 4;
        r9 = new java.lang.Object[r9];
        r1 = java.lang.Integer.valueOf(r1);
        r9[r5] = r1;
        r1 = java.lang.Integer.valueOf(r7);
        r9[r11] = r1;
        r1 = java.lang.Integer.valueOf(r4);
        r9[r12] = r1;
        r9[r2] = r0;
        com.tencent.mm.sdk.platformtools.w.i(r6, r8, r9);
        r0 = r13.context;
        r0 = r0 instanceof com.tencent.mm.ui.MMActivity;
        if (r0 == 0) goto L_0x009b;
    L_0x0160:
        r0 = r13.context;
        r0 = (com.tencent.mm.ui.MMActivity) r0;
        r0.uSV = r13;
        r0 = r13.context;
        r1 = "webview";
        r2 = ".ui.tools.OpenFileChooserUI";
        r4 = 14;
        com.tencent.mm.bb.d.a(r0, r1, r2, r3, r4, r5);
        goto L_0x009b;
    L_0x0175:
        r3 = r3.booleanValue();
        if (r3 != 0) goto L_0x0187;
    L_0x017b:
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x0187;
    L_0x0181:
        r0 = java.lang.Boolean.valueOf(r5);
        r4 = r6;
        goto L_0x0117;
    L_0x0187:
        r3 = 8;
        r0 = java.lang.Boolean.valueOf(r5);
        r4 = r3;
        goto L_0x0117;
    L_0x018f:
        r4 = move-exception;
        goto L_0x00fd;
    L_0x0192:
        r1 = move-exception;
        goto L_0x0054;
    L_0x0195:
        r0 = r3;
        r3 = r4;
        goto L_0x0106;
    L_0x0199:
        r1 = r0;
        goto L_0x0060;
    L_0x019c:
        r0 = r5;
        goto L_0x005d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.jsapi.g.aK(com.tencent.mm.plugin.webview.ui.tools.jsapi.i):boolean");
    }

    public final boolean aL(i iVar) {
        boolean z;
        String str = (String) iVar.ozE.get("appId");
        String str2 = (String) iVar.ozE.get("localId");
        Object obj = iVar.ozE.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bg.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                w.w("MicroMsg.MsgHandler", "Exception has occured : %s", new Object[]{e.getMessage()});
            }
            k.a(iVar.smM, false, null, str);
            w.i("MicroMsg.MsgHandler", "upload local image, appid = %s, localid = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
            if (!bg.mA(str) || bg.mA(str2)) {
                w.e("MicroMsg.MsgHandler", "appId or localid is null or nil.");
                a(iVar, "uploadImage:fail_missing arguments", null);
            } else {
                a(iVar, str, str2, com.tencent.mm.modelcdntran.b.MediaType_FILE, 0, 0, "uploadImage", z);
            }
            return true;
        }
        z = true;
        k.a(iVar.smM, false, null, str);
        w.i("MicroMsg.MsgHandler", "upload local image, appid = %s, localid = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
        if (bg.mA(str)) {
        }
        w.e("MicroMsg.MsgHandler", "appId or localid is null or nil.");
        a(iVar, "uploadImage:fail_missing arguments", null);
        return true;
    }

    public final boolean aM(final i iVar) {
        boolean z;
        String str = (String) iVar.ozE.get("appId");
        final String str2 = (String) iVar.ozE.get("serverId");
        Object obj = iVar.ozE.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bg.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                w.w("MicroMsg.MsgHandler", "Exception has occured : %s", new Object[]{e.getMessage()});
            }
            k.a(iVar.smM, false, null, str);
            w.i("MicroMsg.MsgHandler", "doDownLoadImage, appid is : %s, media id is : %s", new Object[]{str, str2});
            if (!bg.mA(str) || bg.mA(str2)) {
                a(iVar, "downloadImage:fail_missing arguments", null);
            } else {
                final com.tencent.mm.plugin.webview.model.c.b anonymousClass42 = new com.tencent.mm.plugin.webview.model.c.b(this) {
                    final /* synthetic */ g sll;

                    public final void b(boolean z, String str, String str2, String str3) {
                        w.i("MicroMsg.MsgHandler", "doDownLoadImage, on cdn finish, is success : %b, local id : %s, media id is : %s", new Object[]{Boolean.valueOf(z), str, str2});
                        if (!bg.mA(str2) && str2.equals(str2)) {
                            com.tencent.mm.plugin.webview.d.f.bwY().a((com.tencent.mm.plugin.webview.model.c.b) this);
                            if (this.sll.isv != null) {
                                this.sll.isv.dismiss();
                                this.sll.isv = null;
                            }
                            if (z) {
                                WebViewJSSDKFileItem IS = com.tencent.mm.plugin.webview.d.f.bwZ().IS(str);
                                if ((IS instanceof WebViewJSSDKImageItem) && bg.mA(IS.rWW)) {
                                    ((WebViewJSSDKImageItem) IS).bwq();
                                }
                                Map hashMap = new HashMap();
                                hashMap.put("localId", str);
                                this.sll.a(iVar, "downloadImage:ok", hashMap);
                                return;
                            }
                            this.sll.a(iVar, "downloadImage:fail", null);
                        }
                    }
                };
                com.tencent.mm.plugin.webview.d.f.bwY().a(str, str2, anonymousClass42);
                w.i("MicroMsg.MsgHandler", "doDownLoadImage, add cdn download task result : %b", new Object[]{Boolean.valueOf(true)});
                if (z) {
                    Context context = this.context;
                    this.context.getString(R.l.dIO);
                    this.isv = com.tencent.mm.ui.base.g.a(context, this.context.getString(R.l.fnA), true, new OnCancelListener(this) {
                        final /* synthetic */ g sll;

                        public final void onCancel(DialogInterface dialogInterface) {
                            com.tencent.mm.plugin.webview.d.f.bwY().a(anonymousClass42);
                            com.tencent.mm.plugin.webview.d.f.bwY();
                            com.tencent.mm.plugin.webview.model.ab.IO(str2);
                            this.sll.a(iVar, "downloadImage:fail", null);
                        }
                    });
                }
            }
            return true;
        }
        z = true;
        k.a(iVar.smM, false, null, str);
        w.i("MicroMsg.MsgHandler", "doDownLoadImage, appid is : %s, media id is : %s", new Object[]{str, str2});
        if (bg.mA(str)) {
        }
        a(iVar, "downloadImage:fail_missing arguments", null);
        return true;
    }

    public final boolean aN(i iVar) {
        String mz = bg.mz((String) iVar.ozE.get("toUsername"));
        String mz2 = bg.mz((String) iVar.ozE.get("scene"));
        String mz3 = bg.mz((String) iVar.ozE.get(Columns.TYPE));
        String mz4 = bg.mz((String) iVar.ozE.get("allowBackCamera"));
        String mz5 = bg.mz((String) iVar.ozE.get("showOther"));
        String mz6 = bg.mz((String) iVar.ozE.get("avatarUrl"));
        String mz7 = bg.mz((String) iVar.ozE.get("context"));
        w.i("MicroMsg.MsgHandler", "doStartVoipCS,toUserName:" + mz + ",scene:" + mz2 + ",type:" + mz3 + ",allowBackCamera:" + mz4 + ",showOther:" + mz5 + ",avatarUrl:" + mz6 + ",voipCSContext:" + mz7);
        String str = (String) iVar.ozE.get("appId");
        if (str == null || str.equals("") || mz == null || mz.equals("")) {
            a(iVar, "startVoipCall:param invalid", null);
        } else {
            this.skW = iVar;
            com.tencent.mm.sdk.b.a.urY.b(this.skX);
            if (mz.equals("testacs")) {
                Intent intent = new Intent();
                intent.putExtra("voipCSBizId", "gh_e8b085bb67e0");
                intent.putExtra("voipCSAppId", "wx1224160e0adcefd6");
                com.tencent.mm.bb.d.b(ab.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent);
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("voipCSBizId", mz);
                intent2.putExtra("voipCSScene", mz2);
                intent2.putExtra("voipCSType", mz3);
                intent2.putExtra("voipCSAppId", str);
                intent2.putExtra("voipCSAllowBackCamera", mz4);
                intent2.putExtra("voipCSShowOther", mz5);
                intent2.putExtra("voipCSAvatarUrl", mz6);
                intent2.putExtra("voipCSContext", mz7);
                com.tencent.mm.bb.d.b(ab.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent2);
            }
        }
        return true;
    }

    public final boolean aO(i iVar) {
        w.i("MicroMsg.MsgHandler", "doRecordVideo()");
        return a(iVar, 1);
    }

    public final boolean aP(i iVar) {
        w.i("MicroMsg.MsgHandler", "doPreviewVideo(), localId:%s", new Object[]{(String) iVar.ozE.get("localId")});
        WebViewJSSDKFileItem IS = com.tencent.mm.plugin.webview.d.f.bwZ().IS(r0);
        if (IS == null || TextUtils.isEmpty(IS.iDA)) {
            w.e("MicroMsg.MsgHandler", "the item is null or the File item not exist for localId:%s", new Object[]{IS.fJz});
            a(iVar, "previewVideo:fail", null);
        } else if (new File(IS.iDA).exists()) {
            Intent intent = new Intent();
            intent.putExtra("key_video_path", IS.iDA);
            if (this.context instanceof MMActivity) {
                ((MMActivity) this.context).uSV = this;
                com.tencent.mm.bb.d.b(this.context, "card", ".ui.CardGiftVideoUI", intent, 46);
            }
        } else {
            w.e("MicroMsg.MsgHandler", "the File not exist for origFilePath:%s", new Object[]{IS.iDA});
            a(iVar, "previewVideo:fail", null);
        }
        return true;
    }

    public final boolean aQ(i iVar) {
        boolean z;
        w.i("MicroMsg.MsgHandler", "doUploadEncryptMediaFile()");
        String str = (String) iVar.ozE.get("appId");
        String str2 = (String) iVar.ozE.get("localId");
        Object obj = iVar.ozE.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bg.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                w.w("MicroMsg.MsgHandler", "Exception has occured : %s", new Object[]{e.getMessage()});
            }
            w.i("MicroMsg.MsgHandler", "doUploadEncryptMediaFile, appid = %s, localid = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
            if (bg.mA(str) && !bg.mA(str2)) {
                k.a(iVar.smM, false, null, str);
                WebViewJSSDKFileItem IS = com.tencent.mm.plugin.webview.d.f.bwZ().IS(str2);
                if (IS != null) {
                    switch (IS.fIL) {
                        case 1:
                            a(iVar, str, str2, com.tencent.mm.modelcdntran.b.hxO, 0, 0, "uploadEncryptMediaFile", z);
                            break;
                        case 4:
                            b(iVar, str, str2, com.tencent.mm.modelcdntran.b.hxO, 0, 0, "uploadEncryptMediaFile", z);
                            break;
                        default:
                            b(iVar, str, str2, com.tencent.mm.modelcdntran.b.hxO, 0, 0, "uploadEncryptMediaFile", z);
                            break;
                    }
                }
                w.e("MicroMsg.MsgHandler", "jssdk file item is null for localId:%s", new Object[]{str2});
                a(iVar, "uploadEncryptMediaFile:file_not_exist", null);
            } else {
                w.e("MicroMsg.MsgHandler", "appId or localid is null");
                a(iVar, "uploadEncryptMediaFile:fail_missing arguments", null);
            }
            return true;
        }
        z = true;
        w.i("MicroMsg.MsgHandler", "doUploadEncryptMediaFile, appid = %s, localid = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
        if (bg.mA(str)) {
        }
        w.e("MicroMsg.MsgHandler", "appId or localid is null");
        a(iVar, "uploadEncryptMediaFile:fail_missing arguments", null);
        return true;
    }

    public final boolean aR(final i iVar) {
        w.i("MicroMsg.MsgHandler", "doChooseMedia()");
        w.i("MicroMsg.MsgHandler", " checkPermission checkcamera[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a((Activity) this.context, "android.permission.CAMERA", 119, "", ""))});
        if (!com.tencent.mm.pluginsdk.i.a.a((Activity) this.context, "android.permission.CAMERA", 119, "", "")) {
            return true;
        }
        w.i("MicroMsg.MsgHandler", " checkPermission checkMicroPhone[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a((Activity) this.context, "android.permission.RECORD_AUDIO", 120, "", ""))});
        if (!com.tencent.mm.pluginsdk.i.a.a((Activity) this.context, "android.permission.RECORD_AUDIO", 120, "", "")) {
            return true;
        }
        int i;
        String str;
        String mz = bg.mz((String) iVar.ozE.get("sourceType"));
        String mz2 = bg.mz((String) iVar.ozE.get("mediaType"));
        int min = Math.min(bg.getInt((String) iVar.ozE.get("maxDuration"), 10), 10);
        final String mz3 = bg.mz((String) iVar.ozE.get("camera"));
        int i2 = bg.getInt((String) iVar.ozE.get("count"), 1);
        String mz4 = bg.mz((String) iVar.ozE.get("sizeType"));
        w.i("MicroMsg.MsgHandler", "doChooseMedia sourceType:%s, mediaType:%s, maxDuration:%d, camera:%s, count:%d, sizeType:%s", new Object[]{mz, mz2, Integer.valueOf(min), mz3, Integer.valueOf(i2), mz4});
        final Intent intent = new Intent();
        intent.putExtra("key_pick_local_pic_count", i2);
        if (min <= 0) {
            i = 10;
        } else {
            i = min;
        }
        intent.putExtra("key_pick_local_media_duration", i);
        intent.putExtra("query_media_type", 3);
        intent.putExtra("key_pick_local_media_video_type", 2);
        intent.putExtra("key_pick_local_media_sight_type", mz2);
        intent.putExtra("key_pick_local_pic_query_source_type", (mz4.contains("original") ^ mz4.contains("compressed")) != 0 ? 7 : 8);
        intent.putExtra("key_pick_local_pic_send_raw", Boolean.valueOf(mz4.contains("compressed")));
        if (bg.mA(mz)) {
            str = "album|camera";
        } else {
            str = mz;
        }
        if (str.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM) && str.contains("camera")) {
            l lVar = new l(this.context);
            lVar.b(null, new OnCreateContextMenuListener(this) {
                final /* synthetic */ g sll;

                {
                    this.sll = r1;
                }

                public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                    contextMenu.add(0, 1, 0, this.sll.context.getString(R.l.dHa));
                    contextMenu.add(0, 2, 1, this.sll.context.getString(R.l.dHe));
                }
            }, new com.tencent.mm.ui.base.n.d(this) {
                final /* synthetic */ g sll;

                public final void c(MenuItem menuItem, int i) {
                    switch (menuItem.getItemId()) {
                        case 1:
                            this.sll.a(mz3, intent);
                            return;
                        case 2:
                            this.sll.E(intent);
                            return;
                        default:
                            return;
                    }
                }
            });
            lVar.e(new OnCancelListener(this) {
                final /* synthetic */ g sll;

                public final void onCancel(DialogInterface dialogInterface) {
                    this.sll.a(iVar, "doChooseMedia:cancel", null);
                }
            });
            lVar.blb();
            return true;
        } else if (str.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM)) {
            E(intent);
            return true;
        } else if (str.contains("camera")) {
            a(mz3, intent);
            return true;
        } else {
            a(iVar, "chooseMedia:fail_sourceType_error", null);
            return true;
        }
    }

    public final void a(String str, Intent intent) {
        int i;
        w.i("MicroMsg.MsgHandler", "chooseMediaFromCamera");
        if (str.equals("front")) {
            i = 16;
        } else {
            i = 256;
        }
        intent.putExtra("key_pick_local_pic_capture", i);
        ((MMActivity) this.context).uSV = this;
        com.tencent.mm.bb.d.a(this.context, "webview", ".ui.tools.OpenFileChooserUI", intent, 47, false);
    }

    public final void E(Intent intent) {
        w.i("MicroMsg.MsgHandler", "chooseMediaFromAlbum");
        intent.putExtra("key_pick_local_pic_capture", Downloads.RECV_BUFFER_SIZE);
        ((MMActivity) this.context).uSV = this;
        com.tencent.mm.bb.d.a(this.context, "webview", ".ui.tools.OpenFileChooserUI", intent, 47, false);
    }

    public final boolean aS(i iVar) {
        w.i("MicroMsg.MsgHandler", "doChooseVideo()");
        return a(iVar, 0);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(com.tencent.mm.plugin.webview.ui.tools.jsapi.i r13, int r14) {
        /*
        r12 = this;
        r1 = 60;
        r11 = 3;
        r10 = 2;
        r5 = 0;
        r6 = 1;
        r0 = r13.ozE;
        r2 = "sourceType";
        r0 = r0.get(r2);
        r0 = (java.lang.String) r0;
        r3 = com.tencent.mm.sdk.platformtools.bg.mz(r0);
        r0 = r13.ozE;
        r2 = "camera";
        r0 = r0.get(r2);
        r0 = (java.lang.String) r0;
        r4 = com.tencent.mm.sdk.platformtools.bg.mz(r0);
        r0 = "MicroMsg.MsgHandler";
        r2 = "doChooseVideo sourceType = %s, camera = %s, isVideoType:%d";
        r7 = new java.lang.Object[r11];
        r7[r5] = r3;
        r7[r6] = r4;
        r8 = java.lang.Integer.valueOf(r14);
        r7[r10] = r8;
        com.tencent.mm.sdk.platformtools.w.i(r0, r2, r7);
        r0 = r13.ozE;
        r2 = "maxDuration";
        r0 = r0.get(r2);
        r0 = (java.lang.String) r0;
        r2 = com.tencent.mm.sdk.platformtools.bg.getInt(r0, r1);
        r0 = "album";
        r0 = r3.contains(r0);
        if (r0 == 0) goto L_0x01ba;
    L_0x0051:
        r0 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
    L_0x0053:
        r7 = "camera";
        r3 = r3.contains(r7);
        if (r3 == 0) goto L_0x0071;
    L_0x005c:
        if (r2 > 0) goto L_0x0066;
    L_0x005e:
        r0 = "chooseVideo:fail";
        r1 = 0;
        r12.a(r13, r0, r1);
    L_0x0065:
        return r6;
    L_0x0066:
        r3 = "front";
        r3 = r4.equals(r3);
        if (r3 == 0) goto L_0x0176;
    L_0x006f:
        r0 = r0 | 16;
    L_0x0071:
        if (r0 != 0) goto L_0x01b7;
    L_0x0073:
        r0 = 4352; // 0x1100 float:6.098E-42 double:2.15E-320;
        r7 = r0;
    L_0x0076:
        r0 = 16;
        if (r7 == r0) goto L_0x0082;
    L_0x007a:
        r0 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        if (r7 == r0) goto L_0x0082;
    L_0x007e:
        r0 = 4352; // 0x1100 float:6.098E-42 double:2.15E-320;
        if (r7 != r0) goto L_0x00d0;
    L_0x0082:
        if (r14 != r6) goto L_0x017a;
    L_0x0084:
        r0 = r12.context;
        r0 = (android.app.Activity) r0;
        r3 = "android.permission.CAMERA";
        r4 = 117; // 0x75 float:1.64E-43 double:5.8E-322;
        r8 = "";
        r9 = "";
        r0 = com.tencent.mm.pluginsdk.i.a.a(r0, r3, r4, r8, r9);
        r3 = "MicroMsg.MsgHandler";
        r4 = " checkPermission checkcamera[%b]";
        r8 = new java.lang.Object[r6];
        r9 = java.lang.Boolean.valueOf(r0);
        r8[r5] = r9;
        com.tencent.mm.sdk.platformtools.w.d(r3, r4, r8);
        if (r0 == 0) goto L_0x0065;
    L_0x00aa:
        r0 = r12.context;
        r0 = (android.app.Activity) r0;
        r3 = "android.permission.RECORD_AUDIO";
        r4 = 118; // 0x76 float:1.65E-43 double:5.83E-322;
        r8 = "";
        r9 = "";
        r0 = com.tencent.mm.pluginsdk.i.a.a(r0, r3, r4, r8, r9);
        r3 = "MicroMsg.MsgHandler";
        r4 = " checkPermission checkMicroPhone[%b]";
        r8 = new java.lang.Object[r6];
        r9 = java.lang.Boolean.valueOf(r0);
        r8[r5] = r9;
        com.tencent.mm.sdk.platformtools.w.d(r3, r4, r8);
        if (r0 == 0) goto L_0x0065;
    L_0x00d0:
        r0 = r13.ozE;
        r3 = "quality";
        r0 = r0.get(r3);
        r0 = (java.lang.String) r0;
        r0 = com.tencent.mm.sdk.platformtools.bg.getInt(r0, r6);
        if (r0 == 0) goto L_0x01b4;
    L_0x00e1:
        if (r0 == r6) goto L_0x01b4;
    L_0x00e3:
        r4 = r6;
    L_0x00e4:
        if (r2 <= r1) goto L_0x01b1;
    L_0x00e6:
        r0 = r1;
    L_0x00e7:
        r1 = "MicroMsg.MsgHandler";
        r2 = "doChooseVideo real scene = %d, select count = %d, video quality = %d, duration = %d";
        r3 = 4;
        r3 = new java.lang.Object[r3];
        r8 = java.lang.Integer.valueOf(r7);
        r3[r5] = r8;
        r8 = java.lang.Integer.valueOf(r6);
        r3[r6] = r8;
        r8 = java.lang.Integer.valueOf(r4);
        r3[r10] = r8;
        r8 = java.lang.Integer.valueOf(r0);
        r3[r11] = r8;
        com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);
        r3 = new android.content.Intent;
        r3.<init>();
        r1 = "key_pick_local_pic_capture";
        r3.putExtra(r1, r7);
        r1 = "key_pick_local_pic_count";
        r3.putExtra(r1, r6);
        r1 = "key_pick_local_pic_query_source_type";
        r2 = 7;
        r3.putExtra(r1, r2);
        r1 = "key_pick_local_media_quality";
        r3.putExtra(r1, r4);
        r1 = "key_pick_local_media_duration";
        r3.putExtra(r1, r0);
        r0 = "query_media_type";
        r3.putExtra(r0, r10);
        r0 = "key_pick_local_media_video_type";
        r3.putExtra(r0, r14);
        r0 = "MicroMsg.MsgHandler";
        r1 = "doChooseVideo: realScene: %d, count: %d, querySourceType: %d";
        r2 = new java.lang.Object[r11];
        r4 = java.lang.Integer.valueOf(r7);
        r2[r5] = r4;
        r4 = java.lang.Integer.valueOf(r6);
        r2[r6] = r4;
        r4 = 7;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r10] = r4;
        com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
        r0 = r12.context;
        r0 = r0 instanceof com.tencent.mm.ui.MMActivity;
        if (r0 == 0) goto L_0x0065;
    L_0x015f:
        r0 = r12.context;
        r0 = (com.tencent.mm.ui.MMActivity) r0;
        r0.uSV = r12;
        if (r14 != r6) goto L_0x01a2;
    L_0x0167:
        r0 = r12.context;
        r1 = "webview";
        r2 = ".ui.tools.OpenFileChooserUI";
        r4 = 45;
        com.tencent.mm.bb.d.a(r0, r1, r2, r3, r4, r5);
        goto L_0x0065;
    L_0x0176:
        r0 = r0 | 256;
        goto L_0x0071;
    L_0x017a:
        r0 = r12.context;
        r0 = (android.app.Activity) r0;
        r3 = "android.permission.CAMERA";
        r4 = 115; // 0x73 float:1.61E-43 double:5.7E-322;
        r8 = "";
        r9 = "";
        r0 = com.tencent.mm.pluginsdk.i.a.a(r0, r3, r4, r8, r9);
        r3 = "MicroMsg.MsgHandler";
        r4 = " checkPermission checkcamera[%b]";
        r8 = new java.lang.Object[r6];
        r9 = java.lang.Boolean.valueOf(r0);
        r8[r5] = r9;
        com.tencent.mm.sdk.platformtools.w.d(r3, r4, r8);
        if (r0 != 0) goto L_0x00d0;
    L_0x01a0:
        goto L_0x0065;
    L_0x01a2:
        r0 = r12.context;
        r1 = "webview";
        r2 = ".ui.tools.OpenFileChooserUI";
        r4 = 32;
        com.tencent.mm.bb.d.a(r0, r1, r2, r3, r4, r5);
        goto L_0x0065;
    L_0x01b1:
        r0 = r2;
        goto L_0x00e7;
    L_0x01b4:
        r4 = r0;
        goto L_0x00e4;
    L_0x01b7:
        r7 = r0;
        goto L_0x0076;
    L_0x01ba:
        r0 = r5;
        goto L_0x0053;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.jsapi.g.a(com.tencent.mm.plugin.webview.ui.tools.jsapi.i, int):boolean");
    }

    public final boolean aT(i iVar) {
        boolean z;
        String str = (String) iVar.ozE.get("appId");
        String str2 = (String) iVar.ozE.get("localId");
        Object obj = iVar.ozE.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bg.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                w.w("MicroMsg.MsgHandler", "Exception has occured : %s", new Object[]{e.getMessage()});
            }
            w.i("MicroMsg.MsgHandler", "uploadMediaFile, appid = %s, localid = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
            if (bg.mA(str) && !bg.mA(str2)) {
                k.a(iVar.smM, false, null, str);
                WebViewJSSDKFileItem IS = com.tencent.mm.plugin.webview.d.f.bwZ().IS(str2);
                if (IS != null) {
                    switch (IS.fIL) {
                        case 1:
                            a(iVar, str, str2, com.tencent.mm.modelcdntran.b.hxQ, (int) com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX, 2, aw.NAME, z);
                            break;
                        case 4:
                            b(iVar, str, str2, com.tencent.mm.modelcdntran.b.hxR, com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX, 2, aw.NAME, z);
                            break;
                        default:
                            b(iVar, str, str2, com.tencent.mm.modelcdntran.b.hxT, com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX, 2, aw.NAME, z);
                            break;
                    }
                }
                a(iVar, "uploadMediaFile:fail", null);
            } else {
                w.e("MicroMsg.MsgHandler", "appId or localid is null or nil.");
                a(iVar, "uploadMediaFile:fail_missing arguments", null);
            }
            return true;
        }
        z = true;
        w.i("MicroMsg.MsgHandler", "uploadMediaFile, appid = %s, localid = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
        if (bg.mA(str)) {
        }
        w.e("MicroMsg.MsgHandler", "appId or localid is null or nil.");
        a(iVar, "uploadMediaFile:fail_missing arguments", null);
        return true;
    }

    private void a(final i iVar, String str, String str2, int i, int i2, int i3, String str3, boolean z) {
        final String str4 = str3;
        final String str5 = str2;
        AnonymousClass49 anonymousClass49 = new com.tencent.mm.plugin.webview.model.c.b(this) {
            final /* synthetic */ g sll;

            public final void b(boolean z, String str, String str2, String str3) {
                w.i("MicroMsg.MsgHandler", str4 + " on cdn finish,  is success : %s, mediaid : %s, local id is : %s, mediaUrl : %s", new Object[]{Boolean.valueOf(z), str2, str, str3});
                if (!bg.mA(str) && str.equals(str5)) {
                    com.tencent.mm.plugin.webview.d.f.bwY().a((com.tencent.mm.plugin.webview.model.c.b) this);
                    if (this.sll.isv != null) {
                        this.sll.isv.dismiss();
                        this.sll.isv = null;
                    }
                    if (z) {
                        Map hashMap = new HashMap();
                        hashMap.put("serverId", str2);
                        hashMap.put("mediaUrl", str3);
                        this.sll.a(iVar, str4 + ":ok", hashMap);
                        return;
                    }
                    this.sll.a(iVar, str4 + ":fail", null);
                }
            }
        };
        WebViewJSSDKFileItem IS = com.tencent.mm.plugin.webview.d.f.bwZ().IS(str2);
        if (IS == null) {
            a(iVar, str3 + ":fail", null);
            return;
        }
        com.tencent.mm.ah.d b = com.tencent.mm.ah.n.GS().b(Long.valueOf(com.tencent.mm.ah.n.GS().a(IS.iDA, IS.iDE ? 0 : 1, 0, 0, new PString(), new PInt(), new PInt())));
        String str6 = IS.iDA;
        IS.iDA = com.tencent.mm.ah.n.GS().m(b.hEZ, "", "");
        w.i("MicroMsg.MsgHandler", "Image Inserted: %s", new Object[]{r2});
        w.i("MicroMsg.MsgHandler", str3 + ", add cdn upload task result : %b", new Object[]{Boolean.valueOf(com.tencent.mm.plugin.webview.d.f.bwY().a(str, str2, i, i2, i3, anonymousClass49))});
        if (!com.tencent.mm.plugin.webview.d.f.bwY().a(str, str2, i, i2, i3, anonymousClass49)) {
            a(iVar, str3 + ":fail", null);
        } else if (z) {
            Context context = this.context;
            this.context.getString(R.l.dIO);
            final AnonymousClass49 anonymousClass492 = anonymousClass49;
            final String str7 = str2;
            final i iVar2 = iVar;
            final String str8 = str3;
            this.isv = com.tencent.mm.ui.base.g.a(context, this.context.getString(R.l.fnX), true, new OnCancelListener(this) {
                final /* synthetic */ g sll;

                public final void onCancel(DialogInterface dialogInterface) {
                    com.tencent.mm.plugin.webview.d.f.bwY().a(anonymousClass492);
                    com.tencent.mm.plugin.webview.d.f.bwY();
                    com.tencent.mm.plugin.webview.model.ab.nW(str7);
                    this.sll.a(iVar2, str8 + ":fail", null);
                }
            });
        } else if (this.context instanceof Activity) {
            ((Activity) this.context).finish();
            this.rXh = this.skC;
        }
        IS.iDA = str6;
    }

    private void b(i iVar, String str, String str2, int i, int i2, int i3, String str3, boolean z) {
        WebViewJSSDKFileItem IS = com.tencent.mm.plugin.webview.d.f.bwZ().IS(str2);
        if (IS == null || bg.mA(IS.iDA) || !com.tencent.mm.a.e.aO(IS.iDA)) {
            a(iVar, str3 + ":fail_file not exist", null);
        } else if (aa.bn(this.context)) {
            c(iVar, str, str2, i, i2, i3, str3, z);
        } else {
            String ew = bg.ew((long) com.tencent.mm.a.e.aN(IS.iDA));
            final i iVar2 = iVar;
            final String str4 = str;
            final String str5 = str2;
            final int i4 = i;
            final int i5 = i2;
            final int i6 = i3;
            final String str6 = str3;
            final boolean z2 = z;
            final i iVar3 = iVar;
            final String str7 = str3;
            com.tencent.mm.ui.base.g.a(this.context, this.context.getString(R.l.fmt, new Object[]{ew}), this.context.getString(R.l.dIO), new OnClickListener(this) {
                final /* synthetic */ g sll;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.sll.c(iVar2, str4, str5, i4, i5, i6, str6, z2);
                }
            }, new OnClickListener(this) {
                final /* synthetic */ g sll;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.sll.a(iVar3, str7 + ":cancel", null);
                }
            });
        }
    }

    public final void c(final i iVar, String str, final String str2, int i, int i2, int i3, String str3, boolean z) {
        final String str4 = str3;
        final com.tencent.mm.plugin.webview.model.c.b anonymousClass53 = new com.tencent.mm.plugin.webview.model.c.b(this) {
            final /* synthetic */ g sll;

            public final void b(boolean z, String str, String str2, String str3) {
                w.i("MicroMsg.MsgHandler", str4 + ", on cdn finish,  is success : %s, mediaId : %s, local id is : %s, mediaUrl : %s", new Object[]{Boolean.valueOf(z), str2, str, str3});
                if (!bg.mA(str) && str.equals(str2)) {
                    this.sll.skY.remove(str2);
                    com.tencent.mm.plugin.webview.d.f.bwY().a((com.tencent.mm.plugin.webview.model.c.b) this);
                    if (this.sll.isv != null) {
                        this.sll.isv.dismiss();
                        this.sll.isv = null;
                    }
                    this.sll.bzF();
                    if (z) {
                        Map hashMap = new HashMap();
                        hashMap.put("serverId", str2);
                        hashMap.put("mediaUrl", str3);
                        this.sll.a(iVar, str4 + ":ok", hashMap);
                        return;
                    }
                    this.sll.a(iVar, str4 + ":fail", null);
                }
            }
        };
        boolean a = com.tencent.mm.plugin.webview.d.f.bwY().a(str, str2, i, i2, i3, anonymousClass53);
        w.i("MicroMsg.MsgHandler", str3 + ", add cdn upload task result : %b", new Object[]{Boolean.valueOf(a)});
        if (a) {
            b bVar = new b();
            bVar.skt = iVar;
            bVar.smF = anonymousClass53;
            this.skY.put(str2, bVar);
            Bundle bundle = new Bundle();
            bundle.putString("close_window_confirm_dialog_switch", "true");
            bundle.putString("close_window_confirm_dialog_title_cn", this.context.getString(R.l.fmv));
            bundle.putString("close_window_confirm_dialog_title_eng", this.context.getString(R.l.fmv));
            bundle.putString("close_window_confirm_dialog_ok_cn", this.context.getString(R.l.fmr));
            bundle.putString("close_window_confirm_dialog_ok_eng", this.context.getString(R.l.fmr));
            bundle.putString("close_window_confirm_dialog_cancel_cn", this.context.getString(R.l.fms));
            bundle.putString("close_window_confirm_dialog_cancel_eng", this.context.getString(R.l.fms));
            try {
                this.rXh.m(13, bundle);
            } catch (Exception e) {
                w.e("MicroMsg.MsgHandler", "doSetCloseWindowConfirmDialogInfo invoke callback failed : %s", new Object[]{e.getMessage()});
            }
            if (z) {
                Context context = this.context;
                this.context.getString(R.l.dIO);
                final String str5 = str2;
                final i iVar2 = iVar;
                final String str6 = str3;
                this.isv = com.tencent.mm.ui.base.g.a(context, this.context.getString(R.l.fnX), true, new OnCancelListener(this) {
                    final /* synthetic */ g sll;

                    public final void onCancel(DialogInterface dialogInterface) {
                        com.tencent.mm.plugin.webview.d.f.bwY().a(anonymousClass53);
                        com.tencent.mm.plugin.webview.d.f.bwY();
                        com.tencent.mm.plugin.webview.model.ab.nW(str5);
                        this.sll.bzF();
                        this.sll.a(iVar2, str6 + ":cancel", null);
                    }
                });
                this.isv.setOnKeyListener(new OnKeyListener(this) {
                    final /* synthetic */ g sll;

                    {
                        this.sll = r1;
                    }

                    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i != 4 || keyEvent.getAction() != 1) {
                            return false;
                        }
                        com.tencent.mm.ui.base.g.a(this.sll.context, true, this.sll.context.getString(R.l.fmv), "", this.sll.context.getString(R.l.fmr), this.sll.context.getString(R.l.fms), new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass55 slU;

                            {
                                this.slU = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.slU.sll.isv.cancel();
                            }
                        }, new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass55 slU;

                            {
                                this.slU = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        return true;
                    }
                });
                return;
            } else if (this.context instanceof Activity) {
                ((Activity) this.context).finish();
                this.rXh = this.skC;
                return;
            } else {
                return;
            }
        }
        a(iVar, str3 + ":fail", null);
    }

    public final boolean aU(i iVar) {
        boolean z;
        String str = (String) iVar.ozE.get("appId");
        String str2 = (String) iVar.ozE.get("localId");
        Object obj = iVar.ozE.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bg.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                w.w("MicroMsg.MsgHandler", "Exception has occurred : %s", new Object[]{e.getMessage()});
            }
            w.i("MicroMsg.MsgHandler", "upload local video, appId = %s, localId = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
            if (!bg.mA(str) || bg.mA(str2)) {
                w.e("MicroMsg.MsgHandler", "appId or localId is null or nil.");
                a(iVar, "uploadVideo:fail_missing arguments", null);
            } else {
                b(iVar, str, str2, com.tencent.mm.modelcdntran.b.MediaType_FILE, 0, 0, "uploadVideo", z);
            }
            return true;
        }
        z = true;
        w.i("MicroMsg.MsgHandler", "upload local video, appId = %s, localId = %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
        if (bg.mA(str)) {
        }
        w.e("MicroMsg.MsgHandler", "appId or localId is null or nil.");
        a(iVar, "uploadVideo:fail_missing arguments", null);
        return true;
    }

    public final void bzF() {
        try {
            this.rXh.d(12, new Bundle(0));
            this.rXh.d(11, new Bundle(0));
        } catch (Exception e) {
            w.e("MicroMsg.MsgHandler", "clearCloseWindowConfirmDialogInfo, exception = %s", new Object[]{e});
        }
    }

    public final boolean bzG() {
        boolean z = !bg.mA(this.skZ);
        if (z) {
            w.e("MicroMsg.MsgHandler", "in recording state.");
        }
        return z;
    }

    public final boolean aV(i iVar) {
        if (bzG()) {
            try {
                this.rXh.m(2007, null);
            } catch (Exception e) {
                w.e("MicroMsg.MsgHandler", "callback start record failed");
            }
            a(iVar, "startRecord:fail_recording", null);
        } else {
            String str = (String) iVar.ozE.get("appId");
            if (bg.mA(str)) {
                w.e("MicroMsg.MsgHandler", "appId is null or nil.");
                a(iVar, "startRecord:fail_missing arguments", null);
            } else {
                k.a(iVar.smM, false, null, str);
                if (com.tencent.mm.pluginsdk.i.a.aT(this.context, "android.permission.RECORD_AUDIO")) {
                    final WebViewJSSDKFileItem IQ = WebViewJSSDKFileItem.IQ(ah.IZ(str));
                    IQ.appId = str;
                    com.tencent.mm.plugin.webview.d.f.bwZ().b(IQ);
                    w.i("MicroMsg.MsgHandler", "start record appId : %s, voice file name : %s, voice file path : %s", new Object[]{str, r1, IQ.iDA});
                    this.skZ = IQ.fJz;
                    com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                        final /* synthetic */ g sll;

                        public final void run() {
                            final com.tencent.mm.sdk.b.b eyVar = new ey();
                            eyVar.fJh.op = 1;
                            eyVar.fJh.filePath = IQ.iDA;
                            eyVar.fJh.fyN = new Runnable(this) {
                                final /* synthetic */ AnonymousClass56 slX;

                                public final void run() {
                                    w.i("MicroMsg.MsgHandler", "onVoiceRecordEnd, localId(%s).", new Object[]{IQ.fJz});
                                    try {
                                        this.slX.sll.skZ = null;
                                        Bundle bundle = new Bundle();
                                        bundle.putString("localId", IQ.fJz);
                                        String str = "recordResult";
                                        StringBuilder stringBuilder = new StringBuilder("onVoiceRecordEnd:");
                                        String str2 = (eyVar.fJi.fJj != 2 || eyVar.fJi.fJj == 3) ? "ok" : "fail";
                                        bundle.putString(str, stringBuilder.append(str2).toString());
                                        if (this.slX.sll.rXh != null) {
                                            this.slX.sll.rXh.m(2008, bundle);
                                        } else {
                                            w.e("MicroMsg.MsgHandler", "callbacker is null");
                                        }
                                    } catch (Exception e) {
                                        w.e("MicroMsg.MsgHandler", "callback stop record failed");
                                    }
                                }
                            };
                            com.tencent.mm.sdk.b.a.urY.m(eyVar);
                        }
                    });
                    try {
                        this.rXh.m(2007, null);
                    } catch (Exception e2) {
                        w.e("MicroMsg.MsgHandler", "callback start record failed");
                    }
                    a(iVar, "startRecord:ok", null);
                } else {
                    WebViewStubTempUI.a(this.context, this.rXh, new String[]{"android.permission.RECORD_AUDIO"}, this.fRO);
                }
            }
        }
        return true;
    }

    public final boolean aW(i iVar) {
        if (bzG()) {
            String str = (String) iVar.ozE.get("appId");
            w.i("MicroMsg.MsgHandler", "stop record appId : %s", new Object[]{str});
            k.a(iVar.smM, false, null, str);
            final WebViewJSSDKFileItem IS = com.tencent.mm.plugin.webview.d.f.bwZ().IS(this.skZ);
            if (IS == null || !str.equals(IS.appId)) {
                w.e("MicroMsg.MsgHandler", "get jssdk file item by id failed or the appid is not corrected, appid is : %s", new Object[]{str});
                a(iVar, "stopRecord:fail", null);
            } else {
                com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                    final /* synthetic */ g sll;

                    public final void run() {
                        com.tencent.mm.sdk.b.b eyVar = new ey();
                        eyVar.fJh.op = 2;
                        eyVar.fJh.filePath = IS.iDA;
                        com.tencent.mm.sdk.b.a.urY.m(eyVar);
                        this.sll.skZ = null;
                    }
                });
                w.i("MicroMsg.MsgHandler", "stop record, file name  : %s, file path : %s, localid : %s", new Object[]{IS.fyF, IS.iDA, IS.fJz});
                Map hashMap = new HashMap();
                hashMap.put("localId", IS.fJz);
                try {
                    this.rXh.m(2009, null);
                } catch (RemoteException e) {
                    w.e("MicroMsg.MsgHandler", "callback on stop record failed.");
                }
                a(iVar, "stopRecord:ok", hashMap);
            }
        } else {
            w.w("MicroMsg.MsgHandler", "Do not in recording state.");
            a(iVar, "stopRecord:fail", null);
        }
        return true;
    }

    public final boolean aX(i iVar) {
        String str = (String) iVar.ozE.get("appId");
        final String str2 = (String) iVar.ozE.get("localId");
        k.a(iVar.smM, false, null, str);
        w.i("MicroMsg.MsgHandler", "doPlayVoice, appId : %s, localId : %s", new Object[]{str, str2});
        if (bg.mA(str) || bg.mA(str2)) {
            a(iVar, "playVoice:fail_missing arguments", null);
        } else {
            final WebViewJSSDKFileItem IS = com.tencent.mm.plugin.webview.d.f.bwZ().IS(str2);
            if (IS != null) {
                com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                    final /* synthetic */ g sll;

                    public final void run() {
                        com.tencent.mm.sdk.b.b evVar = new ev();
                        evVar.fJa.op = 1;
                        evVar.fJa.fyF = IS.fyF;
                        evVar.fJa.fyQ = true;
                        evVar.fJa.fJd = new com.tencent.mm.y.g.a(this) {
                            final /* synthetic */ AnonymousClass60 slY;

                            {
                                this.slY = r1;
                            }

                            public final void oW() {
                                try {
                                    Bundle bundle = new Bundle();
                                    bundle.putString("playResult", "onVoicePlayEnd:ok");
                                    bundle.putString("localId", str2);
                                    this.slY.sll.rXh.m(MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK, bundle);
                                } catch (Exception e) {
                                    w.e("MicroMsg.MsgHandler", "notify voice play end failed : %s", new Object[]{e.getMessage()});
                                }
                            }
                        };
                        evVar.fJa.fJe = new com.tencent.mm.y.g.b(this) {
                            final /* synthetic */ AnonymousClass60 slY;

                            {
                                this.slY = r1;
                            }

                            public final void onError() {
                                try {
                                    Bundle bundle = new Bundle();
                                    bundle.putString("playResult", "onVoicePlayEnd:fail");
                                    bundle.putString("localId", str2);
                                    this.slY.sll.rXh.m(MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK, bundle);
                                } catch (Exception e) {
                                    w.e("MicroMsg.MsgHandler", "notify voice play end failed : %s", new Object[]{e.getMessage()});
                                }
                            }
                        };
                        com.tencent.mm.sdk.b.a.urY.m(evVar);
                    }
                });
                a(iVar, "playVoice:ok", null);
            } else {
                a(iVar, "playVoice:fail_arguments error", null);
            }
        }
        return true;
    }

    public final boolean aY(i iVar) {
        String str = (String) iVar.ozE.get("appId");
        String str2 = (String) iVar.ozE.get("localId");
        w.i("MicroMsg.MsgHandler", "doStopVoice, appId : %s, localId : %s", new Object[]{str, str2});
        k.a(iVar.smM, false, null, str);
        if (bg.mA(str) || bg.mA(str2)) {
            a(iVar, "stopVoice:fail_missing arguments", null);
        } else {
            final WebViewJSSDKFileItem IS = com.tencent.mm.plugin.webview.d.f.bwZ().IS(str2);
            if (IS != null) {
                com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                    final /* synthetic */ g sll;

                    public final void run() {
                        com.tencent.mm.sdk.b.b evVar = new ev();
                        evVar.fJa.op = 2;
                        evVar.fJa.fyF = IS.fyF;
                        com.tencent.mm.sdk.b.a.urY.m(evVar);
                    }
                });
                a(iVar, "stopVoice:ok", null);
            } else {
                a(iVar, "stopVoice:fail_not playing", null);
            }
        }
        return true;
    }

    public final boolean aZ(i iVar) {
        String str = (String) iVar.ozE.get("appId");
        String str2 = (String) iVar.ozE.get("localId");
        k.a(iVar.smM, false, null, str);
        w.i("MicroMsg.MsgHandler", "doStopVoice, appId : %s, localId : %s", new Object[]{str, str2});
        if (bg.mA(str) || bg.mA(str2)) {
            a(iVar, "pauseVoice:fail_missing arguments", null);
        } else {
            final WebViewJSSDKFileItem IS = com.tencent.mm.plugin.webview.d.f.bwZ().IS(str2);
            if (IS != null) {
                com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                    final /* synthetic */ g sll;

                    public final void run() {
                        com.tencent.mm.sdk.b.b evVar = new ev();
                        evVar.fJa.op = 4;
                        evVar.fJa.fyF = IS.fyF;
                        com.tencent.mm.sdk.b.a.urY.m(evVar);
                    }
                });
                a(iVar, "pauseVoice:ok", null);
            } else {
                a(iVar, "pauseVoice:fail_not playing", null);
            }
        }
        return true;
    }

    public final boolean ba(final i iVar) {
        boolean z;
        String str = (String) iVar.ozE.get("appId");
        final String str2 = (String) iVar.ozE.get("localId");
        Object obj = iVar.ozE.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bg.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                w.w("MicroMsg.MsgHandler", "Exception has occured : %s", new Object[]{e.getMessage()});
            }
            k.a(iVar.smM, false, null, str);
            w.i("MicroMsg.MsgHandler", "doUploadVoice, appId : %s, localId : %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
            if (!bg.mA(str) || bg.mA(str2)) {
                w.e("MicroMsg.MsgHandler", "appId or localId is null or nil.");
                a(iVar, "uploadVoice:fail_missing arguments", null);
            } else {
                final com.tencent.mm.plugin.webview.model.c.b anonymousClass63 = new com.tencent.mm.plugin.webview.model.c.b(this) {
                    final /* synthetic */ g sll;

                    public final void b(boolean z, String str, String str2, String str3) {
                        w.i("MicroMsg.MsgHandler", "doUploadVoice, on cdn finish,  is success : %s, mediaid : %s, local id is : %s", new Object[]{Boolean.valueOf(z), str2, str});
                        if (!bg.mA(str) && str.equals(str2)) {
                            com.tencent.mm.plugin.webview.d.f.bwY().a((com.tencent.mm.plugin.webview.model.c.b) this);
                            if (this.sll.isv != null) {
                                this.sll.isv.dismiss();
                                this.sll.isv = null;
                            }
                            if (z) {
                                Map hashMap = new HashMap();
                                hashMap.put("serverId", str2);
                                this.sll.a(iVar, "uploadVoice:ok", hashMap);
                                return;
                            }
                            this.sll.a(iVar, "uploadVoice:fail", null);
                        }
                    }
                };
                w.i("MicroMsg.MsgHandler", "doUploadVoice, add cdn upload task result : %b", new Object[]{Boolean.valueOf(com.tencent.mm.plugin.webview.d.f.bwY().b(str, str2, anonymousClass63))});
                if (!com.tencent.mm.plugin.webview.d.f.bwY().b(str, str2, anonymousClass63)) {
                    a(iVar, "uploadVoice:fail", null);
                } else if (z) {
                    Context context = this.context;
                    this.context.getString(R.l.dIO);
                    this.isv = com.tencent.mm.ui.base.g.a(context, this.context.getString(R.l.fnX), true, new OnCancelListener(this) {
                        final /* synthetic */ g sll;

                        public final void onCancel(DialogInterface dialogInterface) {
                            com.tencent.mm.plugin.webview.d.f.bwY().a(anonymousClass63);
                            com.tencent.mm.plugin.webview.d.f.bwY();
                            com.tencent.mm.plugin.webview.model.ab.nW(str2);
                            this.sll.a(iVar, "uploadVoice:fail", null);
                        }
                    });
                }
            }
            return true;
        }
        z = true;
        k.a(iVar.smM, false, null, str);
        w.i("MicroMsg.MsgHandler", "doUploadVoice, appId : %s, localId : %s, isShowProgressTips(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
        if (bg.mA(str)) {
        }
        w.e("MicroMsg.MsgHandler", "appId or localId is null or nil.");
        a(iVar, "uploadVoice:fail_missing arguments", null);
        return true;
    }

    public final boolean bb(final i iVar) {
        boolean z;
        final com.tencent.mm.plugin.webview.model.c.b anonymousClass65;
        String str = (String) iVar.ozE.get("appId");
        final String str2 = (String) iVar.ozE.get("serverId");
        Object obj = iVar.ozE.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bg.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                w.w("MicroMsg.MsgHandler", "Exception has occured : %s", new Object[]{e.getMessage()});
            }
            k.a(iVar.smM, false, null, str);
            w.i("MicroMsg.MsgHandler", "doDownloadVoice, appid is : %s, media id is : %s, isShowProgDialog(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
            if (bg.mA(str2)) {
                anonymousClass65 = new com.tencent.mm.plugin.webview.model.c.b(this) {
                    final /* synthetic */ g sll;

                    public final void b(boolean z, String str, String str2, String str3) {
                        w.i("MicroMsg.MsgHandler", "doDownloadVoice, on cdn finish, is success : %b, local id : %s, media id is : %s", new Object[]{Boolean.valueOf(z), str, str2});
                        if (!bg.mA(str2) && str2.equals(str2)) {
                            com.tencent.mm.plugin.webview.d.f.bwY().a((com.tencent.mm.plugin.webview.model.c.b) this);
                            if (this.sll.isv != null) {
                                this.sll.isv.dismiss();
                                this.sll.isv = null;
                            }
                            if (z) {
                                Map hashMap = new HashMap();
                                hashMap.put("localId", str);
                                this.sll.a(iVar, "downloadVoice:ok", hashMap);
                                return;
                            }
                            this.sll.a(iVar, "downloadVoice:fail", null);
                        }
                    }
                };
                com.tencent.mm.plugin.webview.d.f.bwY().a(str, str2, anonymousClass65);
                w.i("MicroMsg.MsgHandler", "doDownloadVoice, add cdn download task result : %b", new Object[]{Boolean.valueOf(true)});
                if (z) {
                    Context context = this.context;
                    this.context.getString(R.l.dIO);
                    this.isv = com.tencent.mm.ui.base.g.a(context, this.context.getString(R.l.fnA), true, new OnCancelListener(this) {
                        final /* synthetic */ g sll;

                        public final void onCancel(DialogInterface dialogInterface) {
                            com.tencent.mm.plugin.webview.d.f.bwY().a(anonymousClass65);
                            com.tencent.mm.plugin.webview.d.f.bwY();
                            com.tencent.mm.plugin.webview.model.ab.IO(str2);
                            this.sll.a(iVar, "downloadVoice:fail", null);
                        }
                    });
                }
            } else {
                a(iVar, "downloadVoice:fail_invaild_serverId", null);
            }
            return true;
        }
        z = true;
        k.a(iVar.smM, false, null, str);
        w.i("MicroMsg.MsgHandler", "doDownloadVoice, appid is : %s, media id is : %s, isShowProgDialog(%s)", new Object[]{str, str2, Boolean.valueOf(z)});
        if (bg.mA(str2)) {
            anonymousClass65 = /* anonymous class already generated */;
            com.tencent.mm.plugin.webview.d.f.bwY().a(str, str2, anonymousClass65);
            w.i("MicroMsg.MsgHandler", "doDownloadVoice, add cdn download task result : %b", new Object[]{Boolean.valueOf(true)});
            if (z) {
                Context context2 = this.context;
                this.context.getString(R.l.dIO);
                this.isv = com.tencent.mm.ui.base.g.a(context2, this.context.getString(R.l.fnA), true, /* anonymous class already generated */);
            }
        } else {
            a(iVar, "downloadVoice:fail_invaild_serverId", null);
        }
        return true;
    }

    public final boolean bc(i iVar) {
        String str = (String) iVar.ozE.get("menuList");
        if (bg.mA(str)) {
            a(iVar, "hideMenuItems:param is empty", null);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("menu_item_list", arrayList);
                this.rXh.n(3001, bundle);
                a(iVar, "hideMenuItems:ok", null);
            } catch (JSONException e) {
                w.w("MicroMsg.MsgHandler", "JSONException : %s", new Object[]{e.getMessage()});
                a(iVar, "hideMenuItems:param is empty", null);
            } catch (RemoteException e2) {
                a(iVar, "hideMenuItems:param is empty", null);
            }
        }
        return true;
    }

    public final boolean bd(i iVar) {
        String str = (String) iVar.ozE.get("menuList");
        if (bg.mA(str)) {
            a(iVar, "showMenuItems:param is empty", null);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("menu_item_list", arrayList);
                this.rXh.n(3002, bundle);
            } catch (JSONException e) {
                w.w("MicroMsg.MsgHandler", "JSONException : %s", new Object[]{e.getMessage()});
                a(iVar, "showMenuItems:param is empty", null);
            } catch (RemoteException e2) {
                w.w("MicroMsg.MsgHandler", "RemoteException : %s", new Object[]{e2.getMessage()});
                a(iVar, "showMenuItems:param is empty", null);
            }
            a(iVar, "showMenuItems:ok", null);
        }
        return true;
    }

    public final boolean bzH() {
        try {
            this.rXh.n(3003, null);
        } catch (RemoteException e) {
            w.w("MicroMsg.MsgHandler", "doShowOptionMenu, RemoteException : %s", new Object[]{e.getMessage()});
        }
        this.lre = false;
        return false;
    }

    public final boolean bzI() {
        try {
            this.rXh.n(3004, null);
        } catch (RemoteException e) {
            w.w("MicroMsg.MsgHandler", "RemoteException : %s", new Object[]{e.getMessage()});
        }
        this.lre = false;
        return false;
    }

    public final boolean be(i iVar) {
        try {
            this.rXh.n(3003, null);
        } catch (RemoteException e) {
            w.w("MicroMsg.MsgHandler", "RemoteException : %s", new Object[]{e.getMessage()});
            a(iVar, "hideAllNonBaseMenuItem:param is empty", null);
        }
        a(iVar, "hideAllNonBaseMenuItem:ok", null);
        return true;
    }

    public final boolean bf(i iVar) {
        try {
            this.rXh.n(3004, null);
        } catch (RemoteException e) {
            w.w("MicroMsg.MsgHandler", "RemoteException : %s", new Object[]{e.getMessage()});
            a(iVar, "showAllNonBaseMenuItem:param is empty", null);
        }
        a(iVar, "showAllNonBaseMenuItem:ok", null);
        return true;
    }

    public final boolean bg(i iVar) {
        String str = (String) iVar.ozE.get("jsApiList");
        if (bg.mA(str)) {
            a(iVar, "checkJsApi:param is empty", null);
        } else {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() == 0) {
                    a(iVar, "checkJsApi:param is empty", null);
                } else {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        boolean z;
                        String string = jSONArray.getString(i);
                        if (com.tencent.mm.protocal.c.NH(string) == null) {
                            if (ji.sYF == null) {
                                Set hashSet = new HashSet();
                                ji.sYF = hashSet;
                                hashSet.add("menu:share:QZone");
                                ji.sYF.add("onImageDownloadProgress");
                                ji.sYF.add("onVoiceUploadProgress");
                                ji.sYF.add("onVoiceDownloadProgress");
                                ji.sYF.add("onVoiceRecordEnd");
                                ji.sYF.add("onVoicePlayBegin");
                                ji.sYF.add("onVoicePlayEnd");
                                ji.sYF.add("onLocalImageUploadProgress");
                                ji.sYF.add(com.tencent.mm.plugin.game.gamewebview.b.a.c.NAME);
                                ji.sYF.add(com.tencent.mm.plugin.game.gamewebview.b.a.b.NAME);
                                ji.sYF.add("hdOnDeviceStateChanged");
                                ji.sYF.add("activity:state_change");
                                ji.sYF.add("onWXDeviceBluetoothStateChange");
                                ji.sYF.add("onWXDeviceLanStateChange");
                                ji.sYF.add("onWXDeviceBindStateChange");
                                ji.sYF.add("onReceiveDataFromWXDevice");
                                ji.sYF.add("onScanWXDeviceResult");
                                ji.sYF.add("onWXDeviceStateChange");
                                ji.sYF.add("onGetKeyboardHeight");
                                ji.sYF.add("onGetSmiley");
                                ji.sYF.add("onAddShortcutStatus");
                                ji.sYF.add("onMediaFileUploadProgess");
                                ji.sYF.add("onGetA8KeyUrl");
                                ji.sYF.add("onPageStateChange");
                                ji.sYF.add("onGetMsgProofItems");
                                ji.sYF.add("onNavigationBarRightButtonClick");
                                ji.sYF.add("onBackgroundAudioStateChange");
                                ji.sYF.add(com.tencent.mm.plugin.game.gamewebview.b.a.d.NAME);
                                ji.sYF.add(com.tencent.mm.plugin.game.gamewebview.b.a.a.NAME);
                            }
                            if (!ji.sYF.contains(string)) {
                                z = false;
                                jSONObject.put(string, z);
                            }
                        }
                        z = true;
                        jSONObject.put(string, z);
                    }
                    Map hashMap = new HashMap();
                    hashMap.put("checkResult", jSONObject.toString());
                    a(iVar, "checkJsApi:ok", hashMap);
                }
            } catch (JSONException e) {
                w.w("MicroMsg.MsgHandler", "JSONException : %s", new Object[]{e.getMessage()});
                a(iVar, "checkJsApi:param is empty", null);
            }
        }
        return true;
    }

    public final boolean bh(i iVar) {
        String str;
        Object obj = iVar.ozE.get(Columns.TYPE);
        if (obj == null) {
            str = "0";
        } else {
            str = obj.toString();
        }
        w.i("[MicroMsg.FreeWifi.MsgHandler]", "connect to freewifi, type is : %s", new Object[]{str});
        final String str2 = (String) iVar.ozE.get("src_username");
        if (str.equals("0") || str.equals("1") || str.equals("2")) {
            String str3;
            String str4 = (String) iVar.ozE.get("apKey");
            w.i("[MicroMsg.FreeWifi.MsgHandler]", "connect to freewifi, ap key is : %s", new Object[]{str4});
            if (bg.mA(str4)) {
                str3 = "";
            } else {
                str3 = str4;
            }
            if (str.equals("0") && bg.mA(str3)) {
                a(iVar, "connectToFreeWifi:failed_invaildParam", null);
            } else {
                final String str5 = (String) iVar.ozE.get("sessionKey");
                com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                    final /* synthetic */ g sll;

                    public final void run() {
                        Intent intent = new Intent();
                        intent.putExtra("free_wifi_jsapi_param_type", str);
                        intent.putExtra("free_wifi_ap_key", str3);
                        intent.putExtra("free_wifi_jsapi_param_username", str2);
                        intent.putExtra("free_wifi_sessionkey", str5);
                        intent.putExtra("free_wifi_source", 4);
                        intent.addFlags(67108864);
                        if (!(bg.mA(str) || !str.equalsIgnoreCase("2") || bg.mA(str3))) {
                            Uri parse = Uri.parse(str3);
                            String host = parse.getHost();
                            String query = parse.getQuery();
                            if (!bg.mA(host) && "connectToFreeWifi".equals(host) && !bg.mA(query) && query.startsWith("apKey=")) {
                                host = parse.getQueryParameter("apKey");
                                w.i("[MicroMsg.FreeWifi.MsgHandler]", "apKey value = %s", new Object[]{host});
                                query = parse.getQueryParameter("ticket");
                                if (!bg.mA(host) && host.length() < WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                                    intent.putExtra("free_wifi_schema_uri", parse.toString());
                                    intent.putExtra("free_wifi_ap_key", host);
                                    intent.putExtra("free_wifi_source", 5);
                                    intent.putExtra("free_wifi_threeone_startup_type", 4);
                                    if (!bg.mA(query)) {
                                        intent.putExtra("free_wifi_schema_ticket", query);
                                    }
                                }
                            }
                        }
                        com.tencent.mm.bb.d.b(this.sll.context, "freewifi", ".ui.FreeWifiEntryUI", intent);
                    }
                });
                a(iVar, "connectToFreeWifi:ok", null);
            }
        } else {
            a(iVar, "connectToFreeWifi:failed_invaildParam", null);
        }
        return true;
    }

    public final boolean bi(i iVar) {
        try {
            int intValue;
            String str = (String) iVar.ozE.get("userName");
            try {
                intValue = ((Integer) iVar.ozE.get(Columns.TYPE)).intValue();
            } catch (Exception e) {
                intValue = 0;
            }
            a(iVar, "setFreeWifiOwner:ok", null);
            Intent intent = new Intent();
            intent.putExtra("wifi_owner_name", str);
            intent.putExtra("wifi_owner_type", intValue);
            com.tencent.mm.bb.d.a(this.context, "freewifi", ".ui.FreeWifiOwnerUI", intent, false);
        } catch (Exception e2) {
            w.w("MicroMsg.MsgHandler", "setFreeWifiOwner, Exception: %s", new Object[]{e2.getMessage()});
        }
        return false;
    }

    public final boolean bj(i iVar) {
        boolean z;
        String str = (String) iVar.ozE.get("appId");
        final String str2 = (String) iVar.ozE.get("localId");
        Object obj = iVar.ozE.get("isShowProgressTips");
        if (obj != null) {
            try {
                z = bg.getInt(obj.toString(), 0) == 1;
            } catch (Exception e) {
                w.w("MicroMsg.MsgHandler", "Exception has occured : %s", new Object[]{e.getMessage()});
            }
            w.i("MicroMsg.MsgHandler", "isShowProgressTips(%s)", new Object[]{Boolean.valueOf(z)});
            k.a(iVar.smM, false, null, str);
            if (!bg.mA(str) || bg.mA(str2)) {
                w.i("MicroMsg.MsgHandler", "The localId(%s) is null or appId(%s) is null.", new Object[]{str2, str});
                a(iVar, "translateVoice:fail_missing arguments", null);
            } else {
                final WebViewJSSDKFileItem IS = com.tencent.mm.plugin.webview.d.f.bwZ().IS(str2);
                if (IS != null) {
                    final i iVar2 = iVar;
                    com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                        final /* synthetic */ g sll;

                        public final void run() {
                            if (z) {
                                g gVar = this.sll;
                                Context context = this.sll.context;
                                this.sll.context.getString(R.l.dIO);
                                gVar.isv = com.tencent.mm.ui.base.g.a(context, this.sll.context.getString(R.l.fnW), true, new OnCancelListener(this) {
                                    final /* synthetic */ AnonymousClass69 smc;

                                    {
                                        this.smc = r1;
                                    }

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        com.tencent.mm.sdk.b.b fbVar = new fb();
                                        fbVar.fJx.fJA = 1;
                                        com.tencent.mm.sdk.b.a.urY.m(fbVar);
                                        this.smc.sll.a(iVar2, "translateVoice:fail", null);
                                    }
                                });
                            }
                            final com.tencent.mm.sdk.b.b fbVar = new fb();
                            fbVar.fJx.fJz = str2;
                            fbVar.fJx.fyF = IS.fyF;
                            fbVar.fJx.fJA = 0;
                            fbVar.fJx.fJB = new Runnable(this) {
                                final /* synthetic */ AnonymousClass69 smc;

                                public final void run() {
                                    if (fbVar.fJy.fHq) {
                                        if (this.smc.sll.isv != null) {
                                            this.smc.sll.isv.dismiss();
                                            this.smc.sll.isv = null;
                                        }
                                        if (bg.mA(fbVar.fJy.content)) {
                                            this.smc.sll.a(iVar2, "translateVoice:fail", null);
                                            return;
                                        }
                                        Map hashMap = new HashMap();
                                        hashMap.put("translateResult", fbVar.fJy.content);
                                        this.smc.sll.a(iVar2, "translateVoice:ok", hashMap);
                                    }
                                }
                            };
                            com.tencent.mm.sdk.b.a.urY.m(fbVar);
                        }
                    });
                } else {
                    a(iVar, "translateVoice:fail_arguments error", null);
                }
            }
            return true;
        }
        z = true;
        w.i("MicroMsg.MsgHandler", "isShowProgressTips(%s)", new Object[]{Boolean.valueOf(z)});
        k.a(iVar.smM, false, null, str);
        if (bg.mA(str)) {
        }
        w.i("MicroMsg.MsgHandler", "The localId(%s) is null or appId(%s) is null.", new Object[]{str2, str});
        a(iVar, "translateVoice:fail_missing arguments", null);
        return true;
    }

    private boolean bk(i iVar) {
        BaseMessage wWMediaLink = new WWMediaLink();
        wWMediaLink.thumbUrl = (String) iVar.ozE.get("img_url");
        try {
            wWMediaLink.webpageUrl = aj.xH(this.rXh.VD());
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
            wWMediaLink.webpageUrl = (String) iVar.ozE.get("link");
        }
        wWMediaLink.title = (String) iVar.ozE.get("title");
        wWMediaLink.description = (String) iVar.ozE.get("desc");
        WWAPIFactory.hM(this.context).a(wWMediaLink);
        a(iVar, "shareWeWork:ok", null);
        return true;
    }

    public final boolean bl(i iVar) {
        if (com.tencent.mm.plugin.webview.stub.a.dc(this.context)) {
            String str = (String) iVar.ozE.get("img_url");
            String str2 = (String) iVar.ozE.get("title");
            String str3 = (String) iVar.ozE.get("desc");
            String string = this.context.getResources().getString(R.l.bpJ);
            String str4 = (String) iVar.ozE.get("link");
            try {
                if (bg.mA(str4)) {
                    str4 = this.rXh.VD();
                }
            } catch (RemoteException e) {
                w.w("MicroMsg.MsgHandler", "Get current url fail. exception : %s", new Object[]{e.getMessage()});
            }
            str4 = aj.xH(str4);
            if (bg.mA(str4) || bg.mA(str2) || bg.mA(str3)) {
                w.w("MicroMsg.MsgHandler", "url(%s) or title(%s) or description(%s) is null or nil.", new Object[]{str4, str2, str3});
                a(iVar, "shareQQ:fail", null);
            } else {
                Map hashMap = new HashMap();
                hashMap.put("image_url", com.tencent.mm.pluginsdk.ui.tools.s.Nr(str));
                hashMap.put("title", com.tencent.mm.pluginsdk.ui.tools.s.Nr(str2));
                hashMap.put("description", com.tencent.mm.pluginsdk.ui.tools.s.Nr(str3));
                hashMap.put(SlookSmartClipMetaTag.TAG_TYPE_URL, com.tencent.mm.pluginsdk.ui.tools.s.Nr(str4));
                hashMap.put("app_name", com.tencent.mm.pluginsdk.ui.tools.s.Nr(string));
                hashMap.put("req_type", com.tencent.mm.pluginsdk.ui.tools.s.Nr("1"));
                if (iVar.smN.equalsIgnoreCase("shareQZone")) {
                    hashMap.put("cflag", com.tencent.mm.pluginsdk.ui.tools.s.Nr("1"));
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("mqqapi://share/to_fri?file_type=news&share_id=1103188687");
                stringBuilder.append("&");
                stringBuilder.append(com.tencent.mm.pluginsdk.ui.tools.s.ac(hashMap));
                w.d("MicroMsg.MsgHandler", "Uri : %s", new Object[]{stringBuilder.toString()});
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString()));
                intent.putExtra("pkg_name", "com.tencent.mm");
                intent.getStringExtra("pkg_name");
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                if (bg.j(this.context, intent) && (this.context instanceof Activity)) {
                    ((Activity) this.context).startActivityForResult(intent, 44);
                    a(iVar, iVar.smN + ":ok", null);
                } else {
                    a(iVar, iVar.smN + ":fail", null);
                }
            }
        } else {
            w.w("MicroMsg.MsgHandler", "Tencent QQ hasn't installed at all.");
            a(iVar, "shareQQ:fail", null);
        }
        return true;
    }

    public final boolean bm(i iVar) {
        String str = (String) iVar.ozE.get("desc");
        String str2 = (String) iVar.ozE.get("img_url");
        String str3 = (String) iVar.ozE.get("link");
        try {
            if (bg.mA(str3)) {
                str3 = this.rXh.VD();
            }
        } catch (RemoteException e) {
            w.w("MicroMsg.MsgHandler", "Get current url fail. exception : %s", new Object[]{e.getMessage()});
        }
        str3 = aj.xH(str3);
        if (bg.mA(str3)) {
            w.e("MicroMsg.MsgHandler", "link is null or nil.");
            a(iVar, "shareWeiboApp:fail", null);
        } else {
            if (bg.mA(str)) {
                str = ((String) iVar.ozE.get("title")) + " " + str3;
            }
            Map hashMap = new HashMap();
            hashMap.put(Columns.TYPE, Integer.valueOf(0));
            hashMap.put("openLBS", Integer.valueOf(0));
            hashMap.put("content", com.tencent.mm.pluginsdk.ui.tools.s.Nq(str));
            hashMap.put(SlookSmartClipMetaTag.TAG_TYPE_URL, com.tencent.mm.pluginsdk.ui.tools.s.Nq(str2));
            hashMap.put("thumbnailurl", com.tencent.mm.pluginsdk.ui.tools.s.Nq(str2));
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("weibo://t.qq.com/proxy/write"));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TencentWeibo://Edit?from=weixin&");
            stringBuilder.append(com.tencent.mm.pluginsdk.ui.tools.s.ac(hashMap));
            w.i("MicroMsg.MsgHandler", "Uri : %s", new Object[]{stringBuilder.toString()});
            intent.putExtra("microblog.intent.extra.ACTION", stringBuilder.toString());
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            if (bg.j(this.context, intent)) {
                this.context.startActivity(intent);
                a(iVar, "shareWeiboApp:ok", null);
            } else {
                a(iVar, "shareWeiboApp:fail", null);
            }
        }
        return true;
    }

    public final boolean bn(i iVar) {
        String str = (String) iVar.ozE.get("sessionFrom");
        if (bg.mA((String) iVar.ozE.get("sessionId"))) {
            a(iVar, "startTempSession:fail_missing arguments", null);
        } else {
            String str2;
            int intValue;
            int i;
            String format;
            Intent intent;
            if (str != null) {
                try {
                    str = URLEncoder.encode(str, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    str2 = str;
                }
            } else {
                str = null;
            }
            str2 = str;
            Object obj = iVar.ozE.get("showType");
            if (obj != null) {
                if (obj instanceof Integer) {
                    intValue = ((Integer) obj).intValue();
                } else if (obj instanceof String) {
                    try {
                        intValue = bg.getInt((String) obj, 0);
                    } catch (NumberFormatException e2) {
                        intValue = 0;
                    }
                }
                i = bg.getInt(bg.mz((String) iVar.ozE.get("scene")), 0);
                format = String.format("weixin://dl/business/tempsession/?username=%s&appid=%s&sessionFrom=%s&showtype=%s&scene=%s", new Object[]{format, this.skF.JZ(this.rXh.VD()), bg.mz(str2), Integer.valueOf(intValue), Integer.valueOf(i)});
                intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(Uri.parse(format));
                if (i == 0) {
                    intent.putExtra("translate_link_scene", i);
                } else {
                    intent.putExtra("translate_link_scene", 4);
                }
                this.context.startActivity(intent);
                a(iVar, "startTempSession:ok", null);
            }
            intValue = 0;
            i = bg.getInt(bg.mz((String) iVar.ozE.get("scene")), 0);
            try {
                format = String.format("weixin://dl/business/tempsession/?username=%s&appid=%s&sessionFrom=%s&showtype=%s&scene=%s", new Object[]{format, this.skF.JZ(this.rXh.VD()), bg.mz(str2), Integer.valueOf(intValue), Integer.valueOf(i)});
                intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(Uri.parse(format));
                if (i == 0) {
                    intent.putExtra("translate_link_scene", 4);
                } else {
                    intent.putExtra("translate_link_scene", i);
                }
                this.context.startActivity(intent);
                a(iVar, "startTempSession:ok", null);
            } catch (Throwable e3) {
                w.printErrStackTrace("MicroMsg.MsgHandler", e3, "", new Object[0]);
                a(iVar, "startTempSession:fail_exception", null);
            }
        }
        return true;
    }

    public final boolean bo(i iVar) {
        if (this.context instanceof MMActivity) {
            String str = (String) iVar.ozE.get("key");
            int i = bg.getInt((String) iVar.ozE.get("procint"), 0);
            int i2 = bg.getInt((String) iVar.ozE.get("dataint"), 0);
            Intent intent = new Intent();
            intent.putExtra("encryptKey", str);
            intent.putExtra("procInterval", i);
            intent.putExtra("dataInterval", i2);
            intent.putExtra("exdevice_airkiss_open_type", 1);
            ((MMActivity) this.context).uSV = this;
            com.tencent.mm.bb.d.b(this.context, "exdevice", ".ui.ExdeviceConnectWifiUI", intent, 19);
        } else {
            a(iVar, "configWXDeviceWiFi:fail", null);
        }
        return true;
    }

    public final boolean bp(i iVar) {
        try {
            String str = (String) iVar.ozE.get("userName");
            String str2 = (String) iVar.ozE.get("nickName");
            if (bg.mA(str)) {
                a(iVar, "setPageOwner:missing_arguments", null);
            } else {
                this.rXh.dQ(str, str2);
                a(iVar, "setPageOwner:ok", null);
            }
        } catch (Exception e) {
            w.w("MicroMsg.MsgHandler", "setPageOwner, Exception: %s", new Object[]{e.getMessage()});
        }
        return false;
    }

    public final boolean bq(final i iVar) {
        try {
            String str = (String) iVar.ozE.get("appId");
            String str2 = (String) iVar.ozE.get("signature");
            k.a(iVar.smM, false, null, str);
            if (bg.mA(str)) {
                a(iVar, "get_wechat_verify_ticket:fail ticket", null);
            } else {
                ap.vd().a(1097, new e(this) {
                    final /* synthetic */ g sll;

                    public final void a(int i, int i2, String str, k kVar) {
                        if (i == 0 && i2 == 0) {
                            com.tencent.mm.plugin.webview.model.g gVar = (com.tencent.mm.plugin.webview.model.g) kVar;
                            Map hashMap = new HashMap();
                            hashMap.put("ticket", ((uj) gVar.ldw.hsk.hsr).fGV);
                            this.sll.a(iVar, "get_wechat_verify_ticket:ok ticket", hashMap);
                        } else {
                            w.e("MicroMsg.MsgHandler", "doGetWechatVerifyTicket, errType = " + i + ", errCode = " + i2);
                            this.sll.a(iVar, "get_wechat_verify_ticket:fail ticket", null);
                        }
                        ap.vd().b(1097, this);
                    }
                });
                ap.vd().a(new com.tencent.mm.plugin.webview.model.g(str, str2), 0);
            }
        } catch (Exception e) {
            w.w("MicroMsg.MsgHandler", "getWechatVerifyTicket, Exception: %s", new Object[]{e.getMessage()});
        }
        return false;
    }

    public final boolean br(i iVar) {
        w.i("MicroMsg.MsgHandler", "doScanCover");
        k.a(iVar.smM, false, null, (String) iVar.ozE.get("appId"));
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 2);
        if (com.tencent.mm.n.a.aI(this.context) || com.tencent.mm.n.a.aH(this.context)) {
            w.i("MicroMsg.MsgHandler", "VoipOutOfPackageUtil.checkCameraUsingAndShowToast fail");
            a(iVar, "scanCover:fail", null);
        } else {
            com.tencent.mm.bb.d.a(this.context, "scanner", ".ui.SingleTopScanUI", intent, false);
            a(iVar, "sacnCover:ok", null);
        }
        return true;
    }

    public final boolean bs(i iVar) {
        w.i("MicroMsg.MsgHandler", "doGetRecevieBizHongBaoRequest");
        k.a(iVar.smM, false, null, (String) iVar.ozE.get("appId"));
        if (this.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(iVar.ozE);
            Intent intent = new Intent();
            intent.putExtra("key_way", 3);
            intent.putExtra("appId", dVar.appId);
            intent.putExtra("timeStamp", dVar.timeStamp);
            intent.putExtra("nonceStr", dVar.nonceStr);
            intent.putExtra("packageExt", dVar.packageExt);
            intent.putExtra("signtype", dVar.signType);
            intent.putExtra("paySignature", dVar.fRt);
            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, dVar.url);
            ((MMActivity) this.context).uSV = this;
            com.tencent.mm.bb.d.b(this.context, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent, 22);
        }
        return true;
    }

    public final boolean bt(i iVar) {
        w.d("MicroMsg.MsgHandler", "doOpenMyDeviceProfile");
        if (this.context != null) {
            String str = (String) iVar.ozE.get("deviceType");
            if (bg.mA(str)) {
                w.e("MicroMsg.MsgHandler", "deviceType is null");
                a(iVar, "openMyDeviceProfile:fail_no deviceType", null);
            } else {
                String str2 = (String) iVar.ozE.get("deviceId");
                if (bg.mA(str2)) {
                    w.e("MicroMsg.MsgHandler", "deviceId is null");
                    a(iVar, "openMyDeviceProfile:fail_no deviceId", null);
                } else {
                    Intent intent = new Intent();
                    if (!(this.context instanceof Activity)) {
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    }
                    intent.putExtra("device_type", str);
                    intent.putExtra("device_id", str2);
                    com.tencent.mm.bb.d.b(this.context, "exdevice", ".ui.ExdeviceDeviceProfileUI", intent);
                    a(iVar, "openMyDeviceProfile:ok", null);
                }
            }
        } else {
            w.e("MicroMsg.MsgHandler", "context is null");
            a(iVar, "openMyDeviceProfile:fail", null);
        }
        return true;
    }

    public final boolean bu(i iVar) {
        w.d("MicroMsg.MsgHandler", "doSelectPedometerSource");
        if (this.context == null || !(this.context instanceof MMActivity)) {
            w.e("MicroMsg.MsgHandler", "context is null");
            a(iVar, "selectPedometerSource:fail", null);
        } else {
            ((MMActivity) this.context).uSV = this;
            com.tencent.mm.bb.d.b(this.context, "exdevice", ".ui.ExdeviceAddDataSourceUI", new Intent(), 26);
        }
        return true;
    }

    public final boolean bv(i iVar) {
        w.i("MicroMsg.MsgHandler", "hy: doGetIbgPrepayRequest");
        k.a(iVar.smM, false, null, (String) iVar.ozE.get("appId"));
        if (this.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(iVar.ozE);
            dVar.sYo = 2;
            com.tencent.mm.pluginsdk.wallet.e.a((MMActivity) this.context, dVar, 27, this);
            long j = bg.getLong((String) iVar.ozE.get("message_id"), 0);
            int i = bg.getInt((String) iVar.ozE.get("message_index"), 0);
            com.tencent.mm.plugin.report.service.g.oUh.i(10593, new Object[]{dVar.fRu, dVar.appId, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(dVar.fRv), dVar.url});
            this.skK = cA(iVar);
        }
        return true;
    }

    public final boolean bw(i iVar) {
        w.i("MicroMsg.MsgHandler", "hy: doGetIbgTransactionRequest");
        if (this.context instanceof MMActivity) {
            com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(iVar.ozE);
            MMActivity mMActivity = (MMActivity) this.context;
            Intent intent = new Intent();
            intent.putExtra("appId", dVar.appId);
            intent.putExtra("timeStamp", dVar.timeStamp);
            intent.putExtra("nonceStr", dVar.nonceStr);
            intent.putExtra("packageExt", dVar.packageExt);
            intent.putExtra("signtype", dVar.signType);
            intent.putExtra("paySignature", dVar.fRt);
            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, dVar.url);
            mMActivity.uSV = this;
            com.tencent.mm.bb.d.a(mMActivity, "wallet_core", ".ui.ibg.WalletIbgOrderInfoUI", intent, 25, true);
            long j = bg.getLong((String) iVar.ozE.get("message_id"), 0);
            int i = bg.getInt((String) iVar.ozE.get("message_index"), 0);
            com.tencent.mm.plugin.report.service.g.oUh.i(10593, new Object[]{dVar.fRu, dVar.appId, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(dVar.fRv), dVar.url});
        }
        return true;
    }

    public final boolean bx(i iVar) {
        if (b("nfcIsConnect", 4001, new Bundle())) {
            a(iVar, "nfcIsConnect:connect", null);
        }
        return true;
    }

    public final boolean by(i iVar) {
        if (b("nfcConnect", 4002, new Bundle())) {
            a(iVar, "nfcConnect:connect", null);
        }
        return true;
    }

    public final boolean bz(i iVar) {
        Bundle bundle = new Bundle();
        if (b("nfcGetId", 4002, bundle)) {
            bundle = a("nfcGetId", 4005, bundle);
            if (bundle != null) {
                Map hashMap = new HashMap();
                hashMap.put(SlookAirButtonFrequentContactAdapter.ID, bundle.getString(SlookAirButtonFrequentContactAdapter.ID));
                w.i("MicroMsg.MsgHandler", "[NFC] nfcGetId result : " + bundle.getString(SlookAirButtonFrequentContactAdapter.ID));
                a(iVar, "nfcGetId:ok", hashMap);
            } else {
                w.w("MicroMsg.MsgHandler", "[NFC] nfcGetId callback fail!");
                a(iVar, "nfcGetId:fail", null);
            }
        }
        return true;
    }

    public final boolean bA(i iVar) {
        Bundle bundle = new Bundle();
        if (b("nfcGetInfo", 4002, bundle)) {
            bundle = a("nfcGetInfo", 4008, bundle);
            if (bundle != null) {
                Map hashMap = new HashMap();
                hashMap.put("info", bundle.getString("info"));
                a(iVar, "nfcGetInfo:ok", hashMap);
            } else {
                w.w("MicroMsg.MsgHandler", "[NFC] nfcGetInfo callback fail!");
                a(iVar, "nfcGetInfo:fail", null);
            }
        }
        return true;
    }

    public final boolean bB(final i iVar) {
        int i = 0;
        boolean z = bg.getInt((String) iVar.ozE.get("isShowNfcSwitchGuide"), 1) == 1;
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this.context);
        if (defaultAdapter == null) {
            a(iVar, "nfcCheckState:nfc_not_support", null);
        } else {
            ap.yY();
            int intValue = ((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uBs, Integer.valueOf(0))).intValue();
            ap.yY();
            int intValue2 = ((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uBt, Integer.valueOf(0))).intValue();
            if (intValue == 2 || (intValue == 0 && intValue2 != 1)) {
                i = 1;
            }
            if (i != 0) {
                if (z) {
                    com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                        final /* synthetic */ g sll;

                        public final void run() {
                            com.tencent.mm.ui.base.g.a(this.sll.context, this.sll.context.getString(R.l.eDz), "", this.sll.context.getString(R.l.eDB), this.sll.context.getString(R.l.dGs), new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass71 sme;

                                {
                                    this.sme = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    com.tencent.mm.bb.d.w(this.sme.sll.context, "setting", ".ui.setting.SettingsAboutSystemUI");
                                    this.sme.sll.a(iVar, "nfcCheckState:nfc_wechat_setting_off", null);
                                }
                            }, new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass71 sme;

                                {
                                    this.sme = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.sme.sll.a(iVar, "nfcCheckState:nfc_wechat_setting_off", null);
                                }
                            });
                        }
                    });
                } else {
                    a(iVar, "nfcCheckState:nfc_wechat_setting_off", null);
                }
            } else if (defaultAdapter.isEnabled()) {
                a(iVar, "nfcCheckState:nfc_ok", null);
            } else if (z) {
                com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                    final /* synthetic */ g sll;

                    public final void run() {
                        com.tencent.mm.ui.base.g.a(this.sll.context, this.sll.context.getString(R.l.eDA), "", this.sll.context.getString(R.l.eDB), this.sll.context.getString(R.l.dGs), new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass72 smf;

                            {
                                this.smf = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.smf.sll.context.startActivity(new Intent("android.settings.NFC_SETTINGS"));
                                this.smf.sll.a(iVar, "nfcCheckState:nfc_off", null);
                            }
                        }, new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass72 smf;

                            {
                                this.smf = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.smf.sll.a(iVar, "nfcCheckState:nfc_off", null);
                            }
                        });
                    }
                });
            } else {
                a(iVar, "nfcCheckState:nfc_off", null);
            }
        }
        return true;
    }

    private Bundle a(String str, int i, Bundle bundle) {
        try {
            return this.rXh.d(i, bundle);
        } catch (RemoteException e) {
            w.w("MicroMsg.MsgHandler", "[NFC] " + str + " callback RemoteException!" + e.toString());
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(java.lang.String r6, int r7, android.os.Bundle r8) {
        /*
        r5 = this;
        r0 = -1;
        r4 = 0;
        r1 = r5.a(r6, r7, r8);
        if (r1 == 0) goto L_0x004e;
    L_0x0008:
        r2 = "status";
        r0 = r1.getInt(r2, r0);
    L_0x000f:
        r1 = "MicroMsg.MsgHandler";
        r2 = new java.lang.StringBuilder;
        r3 = "[NFC] ";
        r2.<init>(r3);
        r2 = r2.append(r6);
        r3 = " result status : ";
        r2 = r2.append(r3);
        r2 = r2.append(r0);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.w.i(r1, r2);
        switch(r0) {
            case 0: goto L_0x006c;
            case 1: goto L_0x0086;
            case 2: goto L_0x00a0;
            case 3: goto L_0x00b9;
            case 4: goto L_0x00bb;
            default: goto L_0x0033;
        };
    L_0x0033:
        r0 = r5.skt;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r6);
        r2 = ":fail";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r5.a(r0, r1, r4);
    L_0x004c:
        r0 = 0;
    L_0x004d:
        return r0;
    L_0x004e:
        r1 = "MicroMsg.MsgHandler";
        r2 = new java.lang.StringBuilder;
        r3 = "[NFC] ";
        r2.<init>(r3);
        r2 = r2.append(r6);
        r3 = " callback fail!";
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.w.w(r1, r2);
        goto L_0x000f;
    L_0x006c:
        r0 = r5.skt;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r6);
        r2 = ":nfc_not_support";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r5.a(r0, r1, r4);
        goto L_0x004c;
    L_0x0086:
        r0 = r5.skt;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r6);
        r2 = ":nfc_off";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r5.a(r0, r1, r4);
        goto L_0x004c;
    L_0x00a0:
        r0 = r5.skt;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r6);
        r2 = ":disconnect";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r5.a(r0, r1, r4);
    L_0x00b9:
        r0 = 1;
        goto L_0x004d;
    L_0x00bb:
        r0 = r5.skt;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r6);
        r2 = ":card_not_support";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r5.a(r0, r1, r4);
        goto L_0x004c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.jsapi.g.b(java.lang.String, int, android.os.Bundle):boolean");
    }

    public final boolean bC(i iVar) {
        if (b("nfcTransceive", 4002, new Bundle())) {
            Bundle bundle = new Bundle();
            bundle.putString("apdu", (String) iVar.ozE.get("apdu"));
            Bundle a = a("nfcTransceive", 4003, bundle);
            if (a != null) {
                Map hashMap = new HashMap();
                hashMap.put("result", a.getString("result"));
                w.i("MicroMsg.MsgHandler", "[NFC] nfcTransceive result : " + a.getString("result"));
                a(iVar, "nfcTransceive:ok", hashMap);
            } else {
                w.w("MicroMsg.MsgHandler", "[NFC] nfcGetId callback fail!");
                a(iVar, "nfcTransceive:fail", null);
            }
        }
        return true;
    }

    public final boolean bD(i iVar) {
        if (b("nfcBatchTransceive", 4002, new Bundle())) {
            Bundle bundle = new Bundle();
            bundle.putString("apdus", (String) iVar.ozE.get("apdus"));
            bundle.putBoolean("breakIfFail", bg.getInt((String) iVar.ozE.get("breakIfFail"), 1) == 1);
            Bundle a = a("nfcBatchTransceive", 4004, bundle);
            if (a != null) {
                Map hashMap = new HashMap();
                hashMap.put("result", a.getString("result"));
                w.i("MicroMsg.MsgHandler", "[NFC] nfcBatchTransceive result : " + a.getString("result"));
                a(iVar, "nfcBatchTransceive:ok", hashMap);
            } else {
                w.w("MicroMsg.MsgHandler", "[NFC] nfcGetId callback fail!");
                a(iVar, "nfcBatchTransceive:fail", null);
            }
        }
        return true;
    }

    public final boolean bE(i iVar) {
        try {
            Bundle d = this.rXh.d(5001, null);
            if (d != null) {
                int i = d.getInt("webview_video_proxy_init");
                w.i("MicroMsg.MsgHandler", "int webview video proxy : %d", new Object[]{Integer.valueOf(i)});
                Map hashMap = new HashMap();
                hashMap.put("videoProxyInitResult", Integer.valueOf(i));
                if (i == 0) {
                    ag bwr = ag.bwr();
                    bwr.rXh = this.rXh;
                    bwr.hasInit = true;
                    ArrayList arrayList = new ArrayList();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(142);
                    iDKey.SetKey(0);
                    iDKey.SetValue(1);
                    arrayList.add(iDKey);
                    iDKey = new IDKey();
                    iDKey.SetID(142);
                    iDKey.SetKey(1);
                    iDKey.SetValue(1);
                    arrayList.add(iDKey);
                    com.tencent.mm.plugin.report.service.g.oUh.b(arrayList, false);
                    a(iVar, "videoProxyInit:ok", hashMap);
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(142);
                    iDKey2.SetKey(0);
                    iDKey2.SetValue(1);
                    arrayList2.add(iDKey2);
                    iDKey2 = new IDKey();
                    iDKey2.SetID(142);
                    iDKey2.SetKey(2);
                    iDKey2.SetValue(1);
                    arrayList2.add(iDKey2);
                    iDKey2 = new IDKey();
                    iDKey2.SetID(142);
                    iDKey2.SetKey(com.tencent.mm.plugin.webview.ui.tools.a.wf(i));
                    iDKey2.SetValue(1);
                    arrayList2.add(iDKey2);
                    com.tencent.mm.plugin.report.service.g.oUh.b(arrayList2, false);
                    a(iVar, "videoProxyInit:fail", hashMap);
                }
                return false;
            }
        } catch (Exception e) {
            w.i("MicroMsg.MsgHandler", "doinit webview proxy failed : %s", new Object[]{e.getMessage()});
        }
        a(iVar, "videoProxyInit:fail", null);
        return false;
    }

    public final boolean bF(i iVar) {
        if (ag.bwr().hasInit) {
            String str = (String) iVar.ozE.get("webviewVideoProxyCdnUrls");
            w.i("MicroMsg.MsgHandler", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d", new Object[]{str, (String) iVar.ozE.get("webviewVideoProxyFileId"), Integer.valueOf(bg.getInt((String) iVar.ozE.get("webviewVideoProxyFileSize"), 0)), Integer.valueOf(bg.getInt((String) iVar.ozE.get("webviewVideoProxyFileDuration"), 0)), Integer.valueOf(bg.getInt((String) iVar.ozE.get("webviewVideoProxyFileType"), 1))});
            if (bg.mA(str)) {
                a(iVar, "videoProxyStartPlay:fail_cdnurl_is_null", null);
            } else {
                ArrayList arrayList = new ArrayList();
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString("webview_video_proxy_cdn_urls", str);
                    bundle.putString("webview_video_proxy_fileId", r1);
                    bundle.putInt("webview_video_proxy_file_size", r3);
                    bundle.putInt("webview_video_proxy_file_duration", r4);
                    bundle.putInt("webview_video_proxy_file_type", r2);
                    Bundle d = this.rXh.d(5002, bundle);
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(142);
                    iDKey.SetKey(15);
                    iDKey.SetValue(1);
                    arrayList.add(iDKey);
                    if (d != null) {
                        int i = d.getInt("webview_video_proxy_play_data_id");
                        str = d.getString("webview_video_proxy_local_url");
                        w.i("MicroMsg.MsgHandler", "invoke result palyDataId = %d, localUrl = %s", new Object[]{Integer.valueOf(i), str});
                        if (i > 0 && !bg.mA(str)) {
                            com.tencent.mm.plugin.report.service.g.oUh.b(arrayList, false);
                            Map hashMap = new HashMap();
                            hashMap.put("videoProxyPlayDataId", Integer.valueOf(i));
                            hashMap.put("videoProxyPlayLocalUrl", str);
                            a(iVar, "videoProxyStartPlay:ok", hashMap);
                            com.tencent.mm.plugin.report.service.g.oUh.b(arrayList, false);
                        }
                    }
                } catch (Exception e) {
                    w.e("MicroMsg.MsgHandler", "proxy start play failed : %s", new Object[]{e.getMessage()});
                }
                IDKey iDKey2 = new IDKey();
                iDKey2.SetID(142);
                iDKey2.SetKey(16);
                iDKey2.SetValue(1);
                arrayList.add(iDKey2);
                com.tencent.mm.plugin.report.service.g.oUh.b(arrayList, false);
                a(iVar, "videoProxyStartPlay:fail", null);
            }
        } else {
            a(iVar, "videoProxyStartPlay:fail_has_not_init", null);
        }
        return false;
    }

    public final boolean bG(i iVar) {
        if (ag.bwr().hasInit) {
            int i = bg.getInt((String) iVar.ozE.get("webviewVideoProxyPlaydataId"), 0);
            if (i > 0) {
                Bundle bundle = new Bundle();
                bundle.putInt("webview_video_proxy_play_data_id", i);
                try {
                    this.rXh.d(5003, bundle);
                    a(iVar, "videoProxyStopPlay:ok", null);
                    return false;
                } catch (Exception e) {
                    w.e("MicroMsg.MsgHandler", "webview proxy stop play failed : %s", new Object[]{e.getMessage()});
                }
            }
            a(iVar, "videoProxyStopPlay:fail", null);
            return false;
        }
        a(iVar, "videoProxyStartPlay:fail_has_not_init", null);
        return true;
    }

    public final boolean bH(i iVar) {
        if (ag.bwr().hasInit) {
            String str = (String) iVar.ozE.get("webviewVideoProxyPlayState");
            w.i("MicroMsg.MsgHandler", "set player state : %s", new Object[]{str});
            if (bg.mA(str)) {
                a(iVar, "videoProxySetPlayerState:fail", null);
                return true;
            }
            int i = bg.getInt(str, 0);
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("webview_video_proxy_play_state", i);
                this.rXh.d(5004, bundle);
                a(iVar, "videoProxySetPlayerState:ok", null);
                return false;
            } catch (Exception e) {
                w.e("MicroMsg.MsgHandler", "set player state failed : %s", new Object[]{e.getMessage()});
                a(iVar, "videoProxySetPlayerState:fail", null);
                return false;
            }
        }
        a(iVar, "videoProxyStartPlay:fail_has_not_init", null);
        return true;
    }

    public final boolean bI(i iVar) {
        if (ag.bwr().hasInit) {
            int i = bg.getInt((String) iVar.ozE.get("webviewVideoProxyPlaydataId"), 0);
            int i2 = bg.getInt((String) iVar.ozE.get("webviewVideoProxyRemainTime"), 0);
            w.i("MicroMsg.MsgHandler", "doWebviewProxySetRemainTime, id = %s, time = %s", new Object[]{r0, r1});
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("webview_video_proxy_play_data_id", i);
                bundle.putInt("webview_video_proxy_play_remain_time", i2);
                this.rXh.d(5006, bundle);
                a(iVar, "videoProxySetRemainTime:ok", null);
            } catch (Exception e) {
                w.e("MicroMsg.MsgHandler", "set remain time faild : %s", new Object[]{e.getMessage()});
                a(iVar, "videoProxySetRemainTime:fail", null);
            }
        } else {
            a(iVar, "videoProxySetRemainTime:fail_has_not_init", null);
        }
        return false;
    }

    public final boolean bJ(i iVar) {
        if (ag.bwr().hasInit) {
            String str = (String) iVar.ozE.get("webviewVideoProxyPlaydataId");
            w.i("MicroMsg.MsgHandler", "doWebviewProxyPreload, playDataId = %s, duration = %d", new Object[]{str, Integer.valueOf(bg.getInt((String) iVar.ozE.get("webviewVideoProxyPreloadTime"), 0))});
            if (bg.mA(str)) {
                w.e("MicroMsg.MsgHandler", "playDataId is null or nil");
                a(iVar, "videoProxyPreload:fail_invaild_play_data_id", null);
            } else {
                try {
                    int i = bg.getInt(str, 0);
                    Bundle bundle = new Bundle();
                    bundle.putInt("webview_video_proxy_play_data_id", i);
                    bundle.putInt("webview_video_proxy_preload_duration", r1);
                    w.i("MicroMsg.MsgHandler", "preload video result = %d", new Object[]{Integer.valueOf(this.rXh.d(5007, bundle).getInt("webview_video_proxy_pre_load_result"))});
                    if (this.rXh.d(5007, bundle).getInt("webview_video_proxy_pre_load_result") == 0) {
                        a(iVar, "videoProxyPreload:ok", null);
                    } else {
                        a(iVar, "videoProxyPreload:fail", null);
                    }
                } catch (Exception e) {
                    a(iVar, "videoProxyPreload:fail", null);
                }
            }
        } else {
            a(iVar, "videoProxyPreload:fail_has_not_init", null);
        }
        return false;
    }

    public final boolean bK(i iVar) {
        int i = bg.getInt((String) iVar.ozE.get("cmd"), 0);
        String str = (String) iVar.ozE.get("param");
        com.tencent.mm.sdk.b.b glVar = new gl();
        glVar.fLJ.ou = i;
        glVar.fLJ.fLE = str;
        com.tencent.mm.sdk.b.a.urY.m(glVar);
        Map hashMap = new HashMap();
        hashMap.put("result", glVar.fLK.fLL);
        a(iVar, "getGameMessages:ok", hashMap);
        return true;
    }

    public final void u(int i, String str, String str2) {
        c wD = wD(i);
        if (wD == null) {
            w.i("MicroMsg.MsgHandler", "onWebViewCacheCallback, get null MsgWrapperBin, may be the webview called cache api has been closed.");
            return;
        }
        i iVar = wD.skt;
        wE(i);
        if (!bg.mz(str2).equalsIgnoreCase("ok")) {
            int a = com.tencent.mm.plugin.webview.modelcache.p.a(iVar);
            if (-1 != a) {
                com.tencent.mm.plugin.webview.modelcache.m.vW(a);
            }
        }
        if (this.rXh != null) {
            a(this.rXh, iVar, String.format("%s:%s", new Object[]{str, str2}), null, false, true);
        }
    }

    public final boolean bL(i iVar) {
        a(iVar, "publicCache:not in white list", null);
        return true;
    }

    public final boolean bM(i iVar) {
        Throwable th;
        Object obj;
        Object obj2;
        Object obj3;
        String str = (String) iVar.ozE.get("actionKey");
        String str2 = (String) iVar.ozE.get("actionValue");
        w.i("MicroMsg.MsgHandler", "doReportActionInfo, actionKey =  %s, actionValue =  %s", new Object[]{str, str2});
        if (bg.mA(str) || bg.mA(str2)) {
            w.e("MicroMsg.MsgHandler", "doReportActionInfo, actionKey or actionValue is null");
            a(iVar, "reportActionInfo:fail", null);
            return true;
        } else if (str.length() <= 0 || str.length() > 32 || str2.length() <= 0 || str2.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            w.e("MicroMsg.MsgHandler", "doReportActionInfo, actionKey or actionValue size is bad");
            a(iVar, "reportActionInfo:fail", null);
            return true;
        } else {
            String str3 = " ";
            String str4 = " ";
            String str5 = " ";
            try {
                Bundle d = this.rXh.d(77, null);
                if (d != null) {
                    str3 = bg.mz(d.getString("KSessionId"));
                    str4 = bg.mz(d.getString("KUserAgent"));
                    str5 = bg.mz(d.getString("KUrl"));
                    if (TextUtils.isEmpty(str5)) {
                        w.e("MicroMsg.MsgHandler", "doReportActionInfo, url is empty");
                        a(iVar, "reportActionInfo:fail", null);
                        return true;
                    }
                    w.i("MicroMsg.MsgHandler", "doReportActionInfo, sessionId %s, userAgent %s, url %s", new Object[]{str3, str4, str5});
                }
            } catch (Exception e) {
                w.e("MicroMsg.MsgHandler", "get sessionId error, %s", new Object[]{e});
            }
            if (TextUtils.isEmpty(pH(str5))) {
                w.e("MicroMsg.MsgHandler", "doReportActionInfo, appId is empty");
                a(iVar, "reportActionInfo:fail", null);
                return true;
            }
            w.i("MicroMsg.MsgHandler", "doReportActionInfo, appId %s", new Object[]{pH(str5)});
            int i = 0;
            if (am.isConnected(this.context)) {
                if (am.isWifi(this.context)) {
                    i = 1;
                } else if (am.is4G(this.context)) {
                    i = 4;
                } else if (am.is3G(this.context)) {
                    i = 3;
                } else if (am.is2G(this.context)) {
                    i = 2;
                }
                w.i("MicroMsg.MsgHandler", "doReportActionInfo, get networkType %d", new Object[]{Integer.valueOf(i)});
            }
            long Ny = bg.Ny();
            w.d("MicroMsg.MsgHandler", "report(%s), clickTimestamp : %d, appID %s, networkType %d, userAgent %s, url : %s, sessionID : %s, actionKey : %s, actionValue : %s", new Object[]{Integer.valueOf(13379), Long.valueOf(Ny), r10, Integer.valueOf(i), str4, str5, str3, str, str2});
            String str6 = "";
            String str7 = "";
            String str8 = "";
            String str9 = "";
            try {
                str6 = URLEncoder.encode(bg.mz(str4), "UTF-8");
                str4 = URLEncoder.encode(str5, "UTF-8");
                try {
                    str5 = URLEncoder.encode(str, "UTF-8");
                } catch (Throwable e2) {
                    str2 = str4;
                    str5 = str6;
                    th = e2;
                    str = str8;
                    w.printErrStackTrace("MicroMsg.MsgHandler", th, "", new Object[0]);
                    str4 = str5;
                    str5 = str2;
                    str2 = str;
                    str = str9;
                    com.tencent.mm.plugin.report.service.g.oUh.i(13379, new Object[]{Long.valueOf(Ny), r10, Integer.valueOf(i), obj, obj2, str3, obj3, str});
                    a(iVar, "reportActionInfo:ok", null);
                    return true;
                }
                try {
                    str = URLEncoder.encode(str2, "UTF-8");
                    obj3 = str5;
                    obj2 = str4;
                    obj = str6;
                } catch (Throwable e22) {
                    str2 = str4;
                    th = e22;
                    str = str5;
                    str5 = str6;
                    w.printErrStackTrace("MicroMsg.MsgHandler", th, "", new Object[0]);
                    str4 = str5;
                    str5 = str2;
                    str2 = str;
                    str = str9;
                    com.tencent.mm.plugin.report.service.g.oUh.i(13379, new Object[]{Long.valueOf(Ny), r10, Integer.valueOf(i), obj, obj2, str3, obj3, str});
                    a(iVar, "reportActionInfo:ok", null);
                    return true;
                }
            } catch (Throwable e222) {
                th = e222;
                str2 = str7;
                str5 = str6;
                str = str8;
                w.printErrStackTrace("MicroMsg.MsgHandler", th, "", new Object[0]);
                str4 = str5;
                str5 = str2;
                str2 = str;
                str = str9;
                com.tencent.mm.plugin.report.service.g.oUh.i(13379, new Object[]{Long.valueOf(Ny), r10, Integer.valueOf(i), obj, obj2, str3, obj3, str});
                a(iVar, "reportActionInfo:ok", null);
                return true;
            }
            com.tencent.mm.plugin.report.service.g.oUh.i(13379, new Object[]{Long.valueOf(Ny), r10, Integer.valueOf(i), obj, obj2, str3, obj3, str});
            a(iVar, "reportActionInfo:ok", null);
            return true;
        }
    }

    public final boolean bN(i iVar) {
        int a = com.tencent.mm.plugin.webview.modelcache.p.a(iVar);
        if (-1 == a) {
            a(this.rXh, iVar, "cache:fail", null, true, false);
            return true;
        }
        int i = -1;
        if (2 == a) {
            i = 2;
        } else if (1 == a) {
            i = 1;
        }
        if (-1 != i) {
            com.tencent.mm.plugin.report.service.g.oUh.a(238, (long) i, 1, false);
        }
        w.i("MicroMsg.MsgHandler", "user not in white list");
        com.tencent.mm.plugin.webview.modelcache.m.vW(a);
        a(this.rXh, iVar, "cache:not in white list", null, true, false);
        return true;
    }

    public final boolean bO(i iVar) {
        w.i("MicroMsg.MsgHandler", "doGetWebPayCheckoutCounterRequst start");
        com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(iVar.ozE);
        Intent intent = new Intent();
        intent.putExtra("appId", dVar.appId);
        intent.putExtra("timeStamp", dVar.timeStamp);
        intent.putExtra("nonceStr", dVar.nonceStr);
        intent.putExtra("packageExt", dVar.packageExt);
        intent.putExtra("signtype", dVar.signType);
        intent.putExtra("paySignature", dVar.fRt);
        intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, dVar.url);
        ((MMActivity) this.context).uSV = this;
        com.tencent.mm.bb.d.a(this.context, "wallet", ".pay.ui.WalletLoanRepaymentUI", intent, 28, false);
        return true;
    }

    public final boolean bP(i iVar) {
        w.i("MicroMsg.MsgHandler", "doAddCustomMenuItems start");
        int i;
        if (iVar.ozE.containsKey("hideMenu")) {
            i = bg.getInt((String) iVar.ozE.get("hideMenu"), 0);
            w.e("MicroMsg.MsgHandler", "doAddCustomMenuItems hideMenu=" + i);
            if (jb(i == 1)) {
                a(iVar, "doAddCustomMenuItems:ok", null);
            } else {
                a(iVar, "doAddCustomMenuItems:fail", null);
            }
        } else {
            jb(false);
            String str = (String) iVar.ozE.get("itemList");
            if (bg.mA(str)) {
                w.e("MicroMsg.MsgHandler", "doAddCustomMenuItems fail: key or title must not be null");
                a(iVar, "doAddCustomMenuItems:params error", null);
            } else {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    int length = jSONArray.length();
                    for (i = 0; i < length; i++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("key");
                            String optString2 = optJSONObject.optString("title");
                            if (bg.mA(optString) || bg.mA("title")) {
                                w.e("MicroMsg.MsgHandler", "key or title is null,ignore item: " + i);
                            } else {
                                arrayList.add(optString);
                                arrayList2.add(optString2);
                            }
                        }
                    }
                    if (arrayList.size() > 0) {
                        Bundle bundle = new Bundle();
                        bundle.putStringArrayList("keys", arrayList);
                        bundle.putStringArrayList("titles", arrayList2);
                        try {
                            this.rXh.N(bundle);
                            a(iVar, "doAddCustomMenuItems:ok", null);
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
                            w.e("MicroMsg.MsgHandler", "doAddCustomMenuItems:fail");
                            a(iVar, "doAddCustomMenuItems:fail", null);
                        }
                    }
                } catch (JSONException e2) {
                    w.e("MicroMsg.MsgHandler", "doAddCustomMenuItems eroor, parse itemList to jsonarray error");
                    a(iVar, "doAddCustomMenuItems:params parse error", null);
                }
            }
        }
        return true;
    }

    public final boolean bQ(i iVar) {
        String str = (String) iVar.ozE.get("key");
        if (bg.mA(str)) {
            a(iVar, "getLocalData:fail_key_is_null", null);
        } else {
            try {
                String VD = this.rXh.VD();
                String str2 = new String(Base64.encode(str.getBytes(), 0));
                str = this.skF.JZ(VD);
                com.tencent.mm.plugin.webview.model.ae bxc = com.tencent.mm.plugin.webview.d.f.bxc();
                String Qo = bg.Qo(VD);
                w.i("MicroMsg.WebViewLocalDataStorage", "get value by key = %s, appid = %s, domin = %s", new Object[]{str2, str, Qo});
                if (bg.mA(str2) || bg.mA(str) || bg.mA(VD) || bg.mA(Qo)) {
                    str = null;
                } else {
                    str = "select value from WebviewLocalData where recordId = " + com.tencent.mm.plugin.webview.model.ae.U(str, Qo, str2);
                    w.i("MicroMsg.WebViewLocalDataStorage", str);
                    Cursor rawQuery = bxc.rawQuery(str, new String[0]);
                    if (rawQuery == null) {
                        w.e("MicroMsg.WebViewLocalDataStorage", "get cursor is null");
                        str = null;
                    } else {
                        if (rawQuery.moveToFirst()) {
                            str = rawQuery.getString(0);
                        } else {
                            str = null;
                        }
                        rawQuery.close();
                        w.i("MicroMsg.WebViewLocalDataStorage", "get value : %s for key : %s", new Object[]{str, str2});
                    }
                }
                if (bg.mA(str)) {
                    a(iVar, "getLocalData:fail", null);
                } else {
                    String str3 = new String(Base64.decode(str.getBytes(), 0));
                    Map hashMap = new HashMap();
                    hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, str3);
                    w.i("MicroMsg.MsgHandler", "get local data, key = %s, value = %s", new Object[]{str2, str3});
                    a(iVar, "getLocalData:ok", hashMap);
                }
            } catch (Exception e) {
                w.e("MicroMsg.MsgHandler", "get url failed : %s", new Object[]{e.getMessage()});
                a(iVar, "getLocalData:fail", null);
            }
        }
        return true;
    }

    public final boolean bR(i iVar) {
        String str = (String) iVar.ozE.get("key");
        String str2 = (String) iVar.ozE.get(SlookAirButtonFrequentContactAdapter.DATA);
        w.i("MicroMsg.MsgHandler", "set local data, key = %s, data = %s", new Object[]{str, str2});
        if (bg.mA(str) || bg.mA(str2)) {
            a(iVar, "setLocalData:fail_param_should_not_null", null);
            return true;
        } else if (str.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT || str2.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            a(iVar, "setLocalData:fail_param_lenght_too_long", null);
            return true;
        } else {
            try {
                String VD = this.rXh.VD();
                byte[] encode = Base64.encode(str.getBytes(), 0);
                byte[] encode2 = Base64.encode(str2.getBytes(), 0);
                String str3 = new String(encode);
                String str4 = new String(encode2);
                str2 = this.skF.JZ(VD);
                com.tencent.mm.plugin.webview.model.ae bxc = com.tencent.mm.plugin.webview.d.f.bxc();
                String Qo = bg.Qo(VD);
                w.i("MicroMsg.WebViewLocalDataStorage", "set data, key = %s, value = %s, url = %s, appId = %s, domin = %s", new Object[]{str3, str4, VD, str2, Qo});
                if (bg.mA(str3) || bg.mA(VD) || bg.mA(str2) || bg.mA(Qo)) {
                    str = "fail_params_invalid";
                } else {
                    int U = com.tencent.mm.plugin.webview.model.ae.U(str2, Qo, str3);
                    str = "select count(*) from WebviewLocalData where appId = '" + str2 + "' and domin = '" + Qo + "'";
                    w.i("MicroMsg.WebViewLocalDataStorage", str);
                    Cursor rawQuery = bxc.rawQuery(str, new String[0]);
                    if (rawQuery != null) {
                        if (rawQuery.moveToFirst()) {
                            w.i("MicroMsg.WebViewLocalDataStorage", "now count = %d", new Object[]{Integer.valueOf(rawQuery.getInt(0))});
                            rawQuery.close();
                            if (rawQuery.getInt(0) >= 5) {
                                str = "fail_exceed_max_count";
                            } else {
                                rawQuery = bxc.rawQuery("select count(*) from WebviewLocalData where recordId =" + U, new String[0]);
                                if (rawQuery != null) {
                                    if (rawQuery.moveToFirst()) {
                                        w.i("MicroMsg.WebViewLocalDataStorage", "sql = %s, count = %d", new Object[]{r7, Integer.valueOf(rawQuery.getInt(0))});
                                        rawQuery.close();
                                        if (rawQuery.getInt(0) > 0) {
                                            w.i("MicroMsg.WebViewLocalDataStorage", "sql = %s, ret = %b", new Object[]{"update WebviewLocalData set value = '" + str4 + "' where recordId =" + U, Boolean.valueOf(bxc.eE("WebviewLocalData", "update WebviewLocalData set value = '" + str4 + "' where recordId =" + U))});
                                            str = bxc.eE("WebviewLocalData", "update WebviewLocalData set value = '" + str4 + "' where recordId =" + U) ? "ok" : "fail";
                                        }
                                    }
                                    rawQuery.close();
                                }
                            }
                        }
                        rawQuery.close();
                    }
                    com.tencent.mm.sdk.e.c adVar = new ad();
                    adVar.field_appId = str2;
                    adVar.field_domin = Qo;
                    adVar.field_key = str3;
                    adVar.field_value = str4;
                    adVar.field_recordId = U;
                    w.i("MicroMsg.WebViewLocalDataStorage", "insert data, ret = %b", new Object[]{Boolean.valueOf(bxc.b(adVar))});
                    str = "ok";
                }
                w.i("MicroMsg.MsgHandler", "doSetLocalData retValue = %s", new Object[]{str});
                a(iVar, "setLocalData:" + str, null);
                return true;
            } catch (Exception e) {
                w.e("MicroMsg.MsgHandler", "get url failed : %s", new Object[]{e.getMessage()});
                a(iVar, "setLocalData:fail", null);
                return true;
            }
        }
    }

    public final boolean bS(i iVar) {
        try {
            String VD = this.rXh.VD();
            com.tencent.mm.plugin.webview.model.ae bxc = com.tencent.mm.plugin.webview.d.f.bxc();
            String JZ = this.skF.JZ(VD);
            String Qo = bg.Qo(VD);
            w.i("MicroMsg.WebViewLocalDataStorage", "appid = %s, url = %s, domin = %s", new Object[]{JZ, VD, Qo});
            if (bg.mA(JZ) || bg.mA(VD) || bg.mA(Qo)) {
                VD = "fail";
            } else {
                VD = bxc.eE("WebviewLocalData", new StringBuilder("delete from WebviewLocalData where appId = '").append(JZ).append("' and domin = '").append(Qo).append("'").toString()) ? "ok" : "fail";
            }
            w.i("MicroMsg.MsgHandler", "doClearLocalData retValue = %s", new Object[]{VD});
            a(iVar, "clearLocalData:" + VD, null);
        } catch (Exception e) {
            w.e("MicroMsg.MsgHandler", "get url failed : %s", new Object[]{e.getMessage()});
            a(iVar, "clearLocalData:fail", null);
        }
        return true;
    }

    public final boolean bT(final i iVar) {
        String VD;
        String str = (String) iVar.ozE.get("useridlist");
        String str2 = (String) iVar.ozE.get("chatname");
        final String str3 = (String) iVar.ozE.get("chatscene");
        try {
            VD = this.rXh.VD();
        } catch (RemoteException e) {
            w.w("MicroMsg.MsgHandler", "exception in get currentUrl %s", new Object[]{e.getMessage()});
            VD = null;
        }
        VD = bg.mz(this.skF.JZ(VD));
        LinkedList linkedList = new LinkedList();
        String[] split = str.split(";");
        if (split == null || split.length <= 0) {
            a(iVar, "openEnterpriseChat:fail", null);
            return false;
        }
        for (Object add : split) {
            linkedList.add(add);
        }
        com.tencent.mm.modelbiz.w.DN();
        com.tencent.mm.kernel.h.vH().gXC.a(new t(VD, str2, linkedList, new com.tencent.mm.modelbiz.m(this) {
            final /* synthetic */ g sll;

            public final void a(int i, k kVar) {
                if (i != 0) {
                    this.sll.a(iVar, "openEnterpriseChat:fail", null);
                    return;
                }
                aga Ed = ((t) kVar).Ed();
                String str;
                if (Ed != null && Ed.tkR != null && Ed.tkR.ret == 0) {
                    str = Ed.tkL;
                    String str2 = ((t) kVar).hxu;
                    if (str2 == null) {
                        this.sll.a(iVar, "openEnterpriseChat:fail", null);
                        return;
                    }
                    com.tencent.mm.modelbiz.a.c iq = com.tencent.mm.modelbiz.w.DJ().iq(str2);
                    if (iq == null || bg.mA(str)) {
                        this.sll.a(iVar, "openEnterpriseChat:fail", null);
                        return;
                    }
                    Intent intent;
                    if (bg.mA(str3) || !str3.equals("long")) {
                        intent = new Intent();
                        intent.putExtra("Chat_User", str);
                        intent.putExtra("key_biz_chat_id", iq.field_bizChatLocalId);
                        intent.putExtra("finish_direct", true);
                        intent.putExtra("key_need_send_video", false);
                        intent.putExtra("key_is_biz_chat", true);
                        com.tencent.mm.bb.d.a(this.sll.context, ".ui.chatting.En_5b8fbb1e", intent);
                    } else {
                        intent = new Intent();
                        intent.addFlags(67108864);
                        intent.putExtra("biz_chat_need_to_jump_to_chatting_ui", true);
                        intent.putExtra("Main_User", str);
                        intent.putExtra("biz_chat_chat_id", iq.field_bizChatLocalId);
                        intent.putExtra("biz_chat_from_scene", 8);
                        com.tencent.mm.bb.d.a(this.sll.context, ".ui.LauncherUI", intent);
                    }
                    Map hashMap = new HashMap();
                    if (!(bg.mA(Ed.tsT) || bg.mA(Ed.tsU))) {
                        hashMap.put("chat_type", Ed.tsT);
                        hashMap.put("chat_id", Ed.tsU);
                    }
                    this.sll.a(iVar, "openEnterpriseChat:ok", hashMap);
                } else if (Ed == null || Ed.tkR == null) {
                    this.sll.a(iVar, "openEnterpriseChat:fail", null);
                } else {
                    Map hashMap2 = new HashMap();
                    hashMap2.put("err_code", Integer.valueOf(Ed.tkR.ret));
                    str = "openEnterpriseChat:fail";
                    if (Ed.tkR.fIA != null) {
                        str = Ed.tkR.fIA;
                    }
                    this.sll.a(iVar, str, hashMap2);
                }
            }
        }), 0);
        return true;
    }

    public final boolean bU(final i iVar) {
        String VD;
        String str = (String) iVar.ozE.get("chatId");
        String str2 = (String) iVar.ozE.get("chatType");
        try {
            VD = this.rXh.VD();
        } catch (RemoteException e) {
            w.w("MicroMsg.MsgHandler", "exception in get currentUrl %s", new Object[]{e.getMessage()});
            VD = null;
        }
        VD = bg.mz(this.skF.JZ(VD));
        if (bg.mA(str) || bg.mA(str2) || bg.mA(VD)) {
            a(iVar, "enterEnterpriseChat:fail_params error", null);
        } else {
            com.tencent.mm.modelbiz.w.DN();
            com.tencent.mm.kernel.h.vH().gXC.a(new com.tencent.mm.modelbiz.a.m(VD, str, str2, new com.tencent.mm.modelbiz.m(this) {
                final /* synthetic */ g sll;

                public final void a(int i, k kVar) {
                    if (i != 0) {
                        this.sll.a(iVar, "enterEnterpriseChat:fail", null);
                        return;
                    }
                    mo Ea = ((com.tencent.mm.modelbiz.a.m) kVar).Ea();
                    String str = "enterEnterpriseChat:fail";
                    if (i < 0) {
                        if (!(Ea == null || Ea.tkR == null || !bg.mA(Ea.tkR.fIA))) {
                            str = "enterEnterpriseChat:fail_" + Ea.tkR.fIA;
                        }
                        this.sll.a(iVar, str, null);
                        return;
                    }
                    String str2 = Ea.tkL;
                    String str3 = ((com.tencent.mm.modelbiz.a.m) kVar).hxu;
                    if (str3 == null) {
                        this.sll.a(iVar, "enterEnterpriseChat:fail", null);
                        return;
                    }
                    com.tencent.mm.modelbiz.a.c iq = com.tencent.mm.modelbiz.w.DJ().iq(str3);
                    if (iq == null || bg.mA(str2)) {
                        this.sll.a(iVar, str, null);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", str2);
                    intent.putExtra("key_biz_chat_id", iq.field_bizChatLocalId);
                    intent.putExtra("finish_direct", true);
                    intent.putExtra("key_need_send_video", false);
                    intent.putExtra("key_is_biz_chat", true);
                    com.tencent.mm.bb.d.a(this.sll.context, ".ui.chatting.En_5b8fbb1e", intent);
                    this.sll.a(iVar, "enterEnterpriseChat:ok", null);
                }
            }), 0);
        }
        return true;
    }

    public final boolean bV(final i iVar) {
        try {
            String mz = bg.mz(this.skF.JZ(this.rXh.VD()));
            if (bg.mA(mz)) {
                a(iVar, "getEnterpriseChat:fail", null);
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("enterprise_action", "enterprise_get_context_bizchat");
                bundle = this.rXh.d(71, bundle);
                String string = bundle.getString("enterprise_context_biz");
                String ad = com.tencent.mm.modelbiz.a.e.ad(bundle.getLong("enterprise_context_bizchatid", -1));
                if (bg.mA(string) || bg.mA(ad)) {
                    a(iVar, "getEnterpriseChat:fail_not in enterprise chat", null);
                } else {
                    e anonymousClass75 = new e(this) {
                        final /* synthetic */ g sll;

                        public final void a(int i, int i2, String str, k kVar) {
                            String str2;
                            vp vpVar;
                            int i3;
                            com.tencent.mm.modelbiz.r.a(this);
                            String str3 = "getEnterpriseChat:fail";
                            if (i == 0 && i2 == 0) {
                                vp vpVar2;
                                com.tencent.mm.modelbiz.r rVar = (com.tencent.mm.modelbiz.r) kVar;
                                if (rVar.gUA == null || rVar.gUA.hsk.hsr == null) {
                                    vpVar2 = null;
                                } else {
                                    vpVar2 = (vp) rVar.gUA.hsk.hsr;
                                }
                                if (vpVar2 == null || vpVar2.tkR == null) {
                                    str2 = str3;
                                    vpVar = vpVar2;
                                    i3 = -1;
                                } else {
                                    int i4 = vpVar2.tkR.ret;
                                    if (vpVar2.tkR.fIA == null || vpVar2.tkR.fIA.length() <= 0) {
                                        str2 = str3;
                                        vpVar = vpVar2;
                                        i3 = i4;
                                    } else {
                                        str2 = "getEnterpriseChat:fail_" + vpVar2.tkR.fIA;
                                        vpVar = vpVar2;
                                        i3 = i4;
                                    }
                                }
                            } else {
                                str2 = str3;
                                i3 = -1;
                                vpVar = null;
                            }
                            if (i3 != 0) {
                                this.sll.a(iVar, str2, null);
                                return;
                            }
                            Map hashMap = new HashMap();
                            hashMap.put("result", vpVar.result);
                            this.sll.a(iVar, "getEnterpriseChat:ok", hashMap);
                        }
                    };
                    com.tencent.mm.kernel.h.vH().gXC.a(1285, anonymousClass75);
                    if (!com.tencent.mm.modelbiz.r.k(mz, string, ad)) {
                        com.tencent.mm.modelbiz.r.a(anonymousClass75);
                        a(iVar, "getEnterpriseChat:fail", null);
                    }
                }
            }
        } catch (Exception e) {
            a(iVar, "getEnterpriseChat:fail", null);
        }
        return true;
    }

    public final boolean bW(final i iVar) {
        String VD;
        try {
            VD = this.rXh.VD();
        } catch (RemoteException e) {
            w.w("MicroMsg.MsgHandler", "exception in get currentUrl %s", new Object[]{e.getMessage()});
            VD = null;
        }
        String mz = bg.mz(this.skF.JZ(VD));
        if (bg.mA(mz)) {
            a(iVar, "openEnterpriseContact:fail", null);
        }
        final k iVar2 = new com.tencent.mm.plugin.webview.model.i(mz, VD, iVar.ozE);
        ap.vd().a(1393, new e(this) {
            final /* synthetic */ g sll;

            public final void a(int i, int i2, String str, k kVar) {
                vn bwf;
                int i3 = -1;
                if (this.sll.isv != null && this.sll.isv.isShowing()) {
                    this.sll.isv.dismiss();
                    this.sll.isv = null;
                }
                ap.vd().b(1393, this);
                String str2 = "openEnterpriseContact:fail";
                if (i == 0 && i2 == 0) {
                    bwf = ((com.tencent.mm.plugin.webview.model.i) kVar).bwf();
                    if (!(bwf == null || bwf.tkR == null)) {
                        i3 = bwf.tkR.ret;
                        if (bwf.tkR.fIA != null && bwf.tkR.fIA.length() > 0) {
                            str2 = bwf.tkR.fIA;
                        }
                    }
                } else {
                    bwf = null;
                }
                if (i3 != 0) {
                    this.sll.a(iVar, str2, null);
                    return;
                }
                str2 = bwf.tpW;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                intent.putExtra("useJs", true);
                ((MMActivity) this.sll.context).uSV = this;
                com.tencent.mm.bb.d.b(this.sll.context, "webview", ".ui.tools.WebViewUI", intent, 31);
            }
        });
        ap.vd().a(iVar2, 0);
        Context context = this.context;
        this.context.getString(R.l.dIO);
        this.isv = com.tencent.mm.ui.base.g.a(context, this.context.getString(R.l.dJd), true, new OnCancelListener(this) {
            final /* synthetic */ g sll;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(iVar2);
            }
        });
        return true;
    }

    public final boolean bX(final i iVar) {
        String VD;
        try {
            VD = this.rXh.VD();
        } catch (RemoteException e) {
            w.w("MicroMsg.MsgHandler", "exception in get currentUrl %s", new Object[]{e.getMessage()});
            VD = null;
        }
        String mz = bg.mz(this.skF.JZ(VD));
        if (bg.mA(mz)) {
            a(iVar, "selectEnterpriseContact:fail", null);
        }
        iVar.ozE.put("groupId", "");
        iVar.ozE.put("timestamp", "");
        iVar.ozE.put("nonceStr", "");
        iVar.ozE.put("signature", "");
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray((String) iVar.ozE.get(Columns.TYPE));
            jSONObject.put("fromDepartmentId", Integer.parseInt((String) iVar.ozE.get("fromDepartmentId")));
            jSONObject.put("mode", (String) iVar.ozE.get("mode"));
            jSONObject.put(Columns.TYPE, jSONArray);
            jSONObject.put("selectedDepartmentIds", new JSONArray((String) iVar.ozE.get("selectedDepartmentIds")));
            jSONObject.put("selectedUserIds", new JSONArray((String) iVar.ozE.get("selectedUserIds")));
            iVar.ozE.put("params", jSONObject);
        } catch (JSONException e2) {
        } catch (NumberFormatException e3) {
        }
        final k iVar2 = new com.tencent.mm.plugin.webview.model.i(mz, VD, iVar.ozE);
        final e anonymousClass78 = new e(this) {
            final /* synthetic */ g sll;

            public final void a(int i, int i2, String str, k kVar) {
                vn bwf;
                int i3 = -1;
                if (this.sll.isv != null && this.sll.isv.isShowing()) {
                    this.sll.isv.dismiss();
                    this.sll.isv = null;
                }
                ap.vd().b(1393, this);
                String str2 = "selectEnterpriseContact:fail";
                if (i == 0 && i2 == 0) {
                    bwf = ((com.tencent.mm.plugin.webview.model.i) kVar).bwf();
                    if (!(bwf == null || bwf.tkR == null)) {
                        i3 = bwf.tkR.ret;
                        if (bwf.tkR.fIA != null && bwf.tkR.fIA.length() > 0) {
                            str2 = bwf.tkR.fIA;
                        }
                    }
                } else {
                    bwf = null;
                }
                if (i3 != 0) {
                    this.sll.a(iVar, str2, null);
                    return;
                }
                str2 = bwf.tpW;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                intent.putExtra("useJs", true);
                ((MMActivity) this.sll.context).uSV = this;
                com.tencent.mm.bb.d.b(this.sll.context, "webview", ".ui.tools.WebViewUI", intent, 53);
            }
        };
        ap.vd().a(1393, anonymousClass78);
        ap.vd().a(iVar2, 0);
        Context context = this.context;
        this.context.getString(R.l.dIO);
        this.isv = com.tencent.mm.ui.base.g.a(context, this.context.getString(R.l.dJd), true, new OnCancelListener(this) {
            final /* synthetic */ g sll;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(iVar2);
                ap.vd().b(1393, anonymousClass78);
            }
        });
        return true;
    }

    public final boolean bY(i iVar) {
        if (this.rXh == null) {
            a(iVar, "sendEnterpriseChat:fail", null);
            return true;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("enterprise_action", "enterprise_get_context_bizchat");
            bundle = this.rXh.d(71, bundle);
            final String string = bundle.getString("enterprise_context_biz");
            final long j = bundle.getLong("enterprise_context_bizchatid", -1);
            if (bg.mA(string) || j < 0) {
                a(iVar, "sendEnterpriseChat:fail_not in enterprise chat", null);
                return true;
            }
            String str = (String) iVar.ozE.get(Columns.TYPE);
            if ("text".equals(str)) {
                return a(iVar, string, j);
            }
            if ("link".equals(str)) {
                JSONObject jSONObject = new JSONObject((String) iVar.ozE.get(SlookAirButtonFrequentContactAdapter.DATA));
                str = jSONObject.optString("link");
                String optString = jSONObject.optString("title");
                String optString2 = jSONObject.optString("desc");
                final String optString3 = jSONObject.optString("imgUrl");
                if (bg.mA(optString) && bg.mA(optString2)) {
                    a(iVar, "sendEnterpriseChat:fail_params error", null);
                    return true;
                } else if (bg.mA(str)) {
                    a(iVar, "sendEnterpriseChat:fail_params error", null);
                    return true;
                } else {
                    String str2;
                    IMediaObject wXWebpageObject = new WXWebpageObject();
                    wXWebpageObject.webpageUrl = str;
                    this.fNK = new WXMediaMessage();
                    this.fNK.mediaObject = wXWebpageObject;
                    this.fNK.title = optString;
                    this.fNK.description = optString2;
                    str = (String) iVar.ozE.get("appid");
                    if (this.skw == null || !TextUtils.isEmpty(str)) {
                        str2 = str;
                    } else {
                        str2 = this.skw.getString("jsapi_args_appid");
                    }
                    final f aJ = com.tencent.mm.pluginsdk.model.app.g.aJ(str2, true);
                    if (this.context == null || this.context.getResources() == null) {
                        w.e("MicroMsg.MsgHandler", "showSendAppMsgDialog fail, context or context.getResources() is null");
                        a(iVar, "sendEnterpriseChat:fail", null);
                        return true;
                    } else if (this.context instanceof Activity) {
                        final i iVar2 = iVar;
                        com.tencent.mm.pluginsdk.ui.applet.d.a(((MMActivity) this.context).uSU, optString, optString3, optString2, null, true, this.context.getResources().getString(R.l.dIA), new com.tencent.mm.pluginsdk.ui.applet.k.a(this) {
                            final /* synthetic */ g sll;

                            public final void a(boolean z, final String str, int i) {
                                if (!z) {
                                    this.sll.a(iVar2, "sendEnterpriseChat:cancel", null);
                                } else if (bg.mA(optString3)) {
                                    com.tencent.mm.modelbiz.a.c aa = com.tencent.mm.modelbiz.w.DJ().aa(j);
                                    synchronized (com.tencent.mm.modelbiz.a.e.hwS) {
                                        String zz = com.tencent.mm.modelbiz.a.e.zz();
                                        com.tencent.mm.modelbiz.a.e.d(aa);
                                        this.sll.a(aJ, str2, string, optString3, null, null, str, null);
                                        com.tencent.mm.modelbiz.a.e.ix(zz);
                                    }
                                    this.sll.a(iVar2, "sendEnterpriseChat:ok", null);
                                    if (this.sll.context != null) {
                                        com.tencent.mm.ui.base.g.bl(this.sll.context, this.sll.context.getResources().getString(R.l.dIG));
                                    }
                                } else {
                                    com.tencent.mm.ah.n.GR().a(optString3, new com.tencent.mm.ah.b.c(this) {
                                        final /* synthetic */ AnonymousClass81 smk;

                                        public final void l(Bitmap bitmap) {
                                            if (this.smk.sll.mSZ != null) {
                                                this.smk.sll.mSZ.dismiss();
                                            }
                                            com.tencent.mm.modelbiz.a.c aa = com.tencent.mm.modelbiz.w.DJ().aa(j);
                                            synchronized (com.tencent.mm.modelbiz.a.e.hwS) {
                                                String zz = com.tencent.mm.modelbiz.a.e.zz();
                                                com.tencent.mm.modelbiz.a.e.d(aa);
                                                this.smk.sll.a(aJ, str2, string, optString3, null, null, str, null);
                                                com.tencent.mm.modelbiz.a.e.ix(zz);
                                            }
                                            this.smk.sll.a(iVar2, "sendEnterpriseChat:ok", null);
                                            if (this.smk.sll.context != null) {
                                                com.tencent.mm.ui.base.g.bl(this.smk.sll.context, this.smk.sll.context.getResources().getString(R.l.dIG));
                                            }
                                        }
                                    });
                                }
                            }
                        });
                        return true;
                    } else {
                        w.e("MicroMsg.MsgHandler", "showsSendAppMsgDialog fail, context is not activity");
                        a(iVar, "sendEnterpriseChat:fail", null);
                        return true;
                    }
                }
            }
            a(iVar, "sendEnterpriseChat:fail_params error", null);
            return true;
        } catch (Exception e) {
            w.e("MicroMsg.MsgHandler", "clear webview cache fail : %s", new Object[]{e.getMessage()});
            a(iVar, "sendEnterpriseChat:fail", null);
            return true;
        }
    }

    private boolean a(i iVar, String str, long j) {
        String optString = new JSONObject((String) iVar.ozE.get(SlookAirButtonFrequentContactAdapter.DATA)).optString("content");
        if (bg.mA(optString)) {
            a(iVar, "sendEnterpriseChat:fail_params error", null);
        } else {
            boolean m;
            com.tencent.mm.modelbiz.a.c aa = com.tencent.mm.modelbiz.w.DJ().aa(j);
            synchronized (com.tencent.mm.modelbiz.a.e.hwS) {
                String zz = com.tencent.mm.modelbiz.a.e.zz();
                com.tencent.mm.modelbiz.a.e.d(aa);
                com.tencent.mm.sdk.b.b nvVar = new nv();
                nvVar.fVa.fVb = str;
                nvVar.fVa.content = optString;
                nvVar.fVa.type = o.fG(str);
                nvVar.fVa.flags = 0;
                m = com.tencent.mm.sdk.b.a.urY.m(nvVar);
                com.tencent.mm.modelbiz.a.e.ix(zz);
            }
            if (m) {
                a(iVar, "sendEnterpriseChat:ok", null);
                if (this.context != null) {
                    com.tencent.mm.ui.base.g.bl(this.context, this.context.getResources().getString(R.l.dIG));
                }
            } else {
                a(iVar, "sendEnterpriseChat:fail", null);
            }
        }
        return true;
    }

    public final boolean bZ(i iVar) {
        w.i("MicroMsg.MsgHandler", "start doChangePayActivityView");
        com.tencent.mm.sdk.b.b amVar = new com.tencent.mm.e.a.am();
        String str = (String) iVar.ozE.get("showInfo");
        if (bg.mA(str)) {
            w.e("MicroMsg.MsgHandler", "changePayActivityView eroor, parse showinfo to jsonarray error");
            a(iVar, "changePayActivityView:fail", null);
            return false;
        }
        try {
            boolean z;
            JSONObject jSONObject = new JSONObject(str);
            amVar.fDO.fDQ = jSONObject.getString("buttonTitle");
            str = jSONObject.getString("isButtonEnable");
            String string = jSONObject.getString("isButtonHidden");
            String string2 = jSONObject.getString("isActivityViewHidden");
            w.i("MicroMsg.MsgHandler", "isButtonEnable:" + str + " isButtonHidden:" + string + " isActivityViewHidden:" + string2);
            amVar.fDO.fDR = bg.getInt(str, 0) > 0;
            com.tencent.mm.e.a.am.a aVar = amVar.fDO;
            if (bg.getInt(string, 0) > 0) {
                z = true;
            } else {
                z = false;
            }
            aVar.fDS = z;
            com.tencent.mm.e.a.am.a aVar2 = amVar.fDO;
            if (bg.getInt(string2, 0) > 0) {
                z = true;
            } else {
                z = false;
            }
            aVar2.fDT = z;
            com.tencent.mm.sdk.b.a.urY.m(amVar);
            if (amVar.fDP.fDU) {
                w.i("MicroMsg.MsgHandler", "changePayActivityView:ok");
                a(iVar, "changePayActivityView:ok", null);
            } else {
                w.i("MicroMsg.MsgHandler", "changePayActivityView:fail");
                a(iVar, "changePayActivityView:fail", null);
            }
            return true;
        } catch (Exception e) {
            w.e("MicroMsg.MsgHandler", "changePayActivityView eroor, parse showinfo to jsonarray error");
            a(iVar, "changePayActivityView:fail", null);
            return false;
        }
    }

    public final boolean ca(i iVar) {
        String str = (String) iVar.ozE.get("idKeyDataInfo");
        if (bg.mA(str)) {
            w.e("MicroMsg.MsgHandler", "idkey data is null");
            a(iVar, "reportIDKey:fail_invaild_parms", null);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(bg.getInt(optJSONObject.optString(SlookAirButtonFrequentContactAdapter.ID), 0));
                    iDKey.SetKey(bg.getInt(optJSONObject.optString("key"), 0));
                    iDKey.SetValue(bg.getInt(optJSONObject.optString(Columns.VALUE), 0));
                    arrayList.add(iDKey);
                }
                if (arrayList.size() > 0) {
                    com.tencent.mm.plugin.report.service.g.oUh.b(arrayList, true);
                    a(iVar, "reportIDKey:ok", null);
                }
            } catch (Exception e) {
                w.e("MicroMsg.MsgHandler", "parse json array faild : %s", new Object[]{e.getMessage()});
            }
            a(iVar, "reportIDKey:fail", null);
        }
        return false;
    }

    public final boolean cb(final i iVar) {
        String str = (String) iVar.ozE.get("username");
        if (bg.mA(str)) {
            w.e("MicroMsg.MsgHandler", "user name is null or nil");
            a(iVar, "add_contact:fail", null);
            return false;
        }
        String str2 = (String) iVar.ozE.get("profileReportInfo");
        w.i("MicroMsg.MsgHandler", "get scene = %s", new Object[]{(String) iVar.ozE.get("scene")});
        final com.tencent.mm.pluginsdk.ui.applet.b bVar = new com.tencent.mm.pluginsdk.ui.applet.b(this.context, str, bg.getInt(r0, 91), new com.tencent.mm.pluginsdk.ui.applet.b.a(this) {
            final /* synthetic */ g sll;

            public final void pb(int i) {
                switch (i) {
                    case -2:
                        this.sll.a(iVar, "quickly_add_contact:added", null);
                        return;
                    case -1:
                        this.sll.a(iVar, "quickly_add_contact:fail", null);
                        return;
                    case 0:
                        this.sll.a(iVar, "quickly_add_contact:cancel", null);
                        return;
                    case 1:
                        this.sll.a(iVar, "quickly_add_contact:ok", null);
                        return;
                    default:
                        this.sll.a(iVar, "quickly_add_contact:fail", null);
                        return;
                }
            }
        }, false, str2);
        com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
            final /* synthetic */ g sll;

            public final void run() {
                bVar.show();
            }
        });
        return true;
    }

    public final boolean cc(i iVar) {
        String str = (String) iVar.ozE.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        String str2 = (String) iVar.ozE.get("open_game_webview");
        w.i("MicroMsg.MsgHandler", "open url with extra webview, url = %s", new Object[]{str});
        if (bg.mA(str)) {
            w.e("MicroMsg.MsgHandler", "url is null or nil");
            a(iVar, "openUrlWithExtraWebview:fail_invalid_url", null);
        } else {
            final Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("convertActivityFromTranslucent", false);
            if (bg.mz(str2).equals("1")) {
                com.tencent.mm.sdk.b.b juVar = new ju();
                juVar.fQi.type = 0;
                juVar.fQi.context = this.context;
                juVar.fQi.intent = intent;
                com.tencent.mm.sdk.b.a.urY.m(juVar);
            } else {
                com.tencent.mm.plugin.webview.ui.tools.d.a(intent.getExtras(), "webview", ".ui.tools.WebViewUI", this.rXh, new Runnable(this) {
                    final /* synthetic */ g sll;

                    public final void run() {
                        com.tencent.mm.bb.d.b(this.sll.context, "webview", ".ui.tools.WebViewUI", intent);
                    }
                });
            }
            a(iVar, "openUrlWithExtraWebview:ok", null);
        }
        return true;
    }

    public final boolean cd(i iVar) {
        String str = (String) iVar.ozE.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bg.mA(str)) {
            w.e("MicroMsg.MsgHandler", "url is null or nil");
            a(iVar, "openCunstonWebview:fail_invalid_url", null);
            return true;
        }
        int i;
        boolean z;
        String str2;
        boolean z2;
        boolean z3;
        Object obj;
        boolean z4;
        String mz;
        String mz2;
        boolean z5;
        String mz3;
        Intent intent;
        com.tencent.mm.sdk.b.b juVar;
        String mz4 = bg.mz((String) iVar.ozE.get("orientation"));
        if (!bg.mA(mz4)) {
            if (mz4.equals("horizontal")) {
                i = 0;
            } else if (mz4.equals("vertical")) {
                i = 1;
            } else if (mz4.equals("sensor")) {
                i = 4;
            }
            if (bg.mz((String) iVar.ozE.get("fullscreen")).equals("true")) {
                z = false;
            } else {
                z = true;
            }
            str2 = (String) iVar.ozE.get("top_url");
            mz4 = (String) iVar.ozE.get("top_title");
            z2 = false;
            if (this.rXh != null) {
                z2 = this.rXh.d(81, new Bundle()).getBoolean("from_shortcut", false);
            }
            z3 = z2;
            obj = null;
            if (bg.mz((String) iVar.ozE.get("finish_recent_webview")).equals("1")) {
                obj = 1;
            }
            z4 = false;
            if (bg.mz((String) iVar.ozE.get("disable_swipe_back")).equals("1")) {
                z4 = true;
            }
            mz = bg.mz((String) iVar.ozE.get("username"));
            mz2 = bg.mz((String) iVar.ozE.get("open_game_webview"));
            z2 = false;
            if (this.rXh != null) {
                z2 = this.rXh.d(86, new Bundle()).getBoolean("is_from_keep_top");
            }
            z5 = z2;
            mz3 = bg.mz((String) iVar.ozE.get("gameAppid"));
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("screen_orientation", i);
            intent.putExtra("show_full_screen", z);
            intent.putExtra("disable_swipe_back", z4);
            intent.putExtra("from_shortcut", z3);
            intent.putExtra("shortcut_user_name", mz);
            if (!(bg.mA(str2) || bg.mA(mz4))) {
                intent.putExtra("keep_top_scene", 2);
                intent.putExtra("custom_keep_top_url", str2);
                intent.putExtra("custom_keep_top_title", mz4);
            }
            intent.putExtra("is_from_keep_top", z5);
            intent.putExtra("game_hv_menu_appid", mz3);
            if (z3) {
                com.tencent.mm.bb.d.b(this.context, "webview", ".ui.tools.game.H5GameWebViewUI", intent);
            } else if (bg.mz(mz2).equals("1")) {
                com.tencent.mm.bb.d.b(this.context, "webview", ".ui.tools.WebViewUI", intent);
            } else {
                juVar = new ju();
                juVar.fQi.type = 0;
                juVar.fQi.context = this.context;
                juVar.fQi.intent = intent;
                com.tencent.mm.sdk.b.a.urY.m(juVar);
            }
            if (!(obj == null || z3)) {
                com.tencent.mm.sdk.platformtools.af.f(new Runnable(this) {
                    final /* synthetic */ g sll;

                    {
                        this.sll = r1;
                    }

                    public final void run() {
                        try {
                            this.sll.w(new i());
                        } catch (Exception e) {
                            w.i("MicroMsg.MsgHandler", "openCunstomWebview, close window exception : %s", new Object[]{e.getMessage()});
                        }
                    }
                }, 200);
            }
            juVar = new gi();
            juVar.fLC.ou = 2;
            juVar.fLC.fLE = mz3;
            com.tencent.mm.sdk.b.a.urY.m(juVar);
            a(iVar, "openCunstonWebview:ok", null);
            return true;
        }
        i = -1;
        if (bg.mz((String) iVar.ozE.get("fullscreen")).equals("true")) {
            z = false;
        } else {
            z = true;
        }
        str2 = (String) iVar.ozE.get("top_url");
        mz4 = (String) iVar.ozE.get("top_title");
        z2 = false;
        try {
            if (this.rXh != null) {
                z2 = this.rXh.d(81, new Bundle()).getBoolean("from_shortcut", false);
            }
            z3 = z2;
        } catch (Exception e) {
            w.e("MicroMsg.MsgHandler", "doOpenCustomWebview, get from shortcut exception : %s", new Object[]{e.getMessage()});
            z3 = false;
        }
        obj = null;
        if (bg.mz((String) iVar.ozE.get("finish_recent_webview")).equals("1")) {
            obj = 1;
        }
        z4 = false;
        if (bg.mz((String) iVar.ozE.get("disable_swipe_back")).equals("1")) {
            z4 = true;
        }
        mz = bg.mz((String) iVar.ozE.get("username"));
        mz2 = bg.mz((String) iVar.ozE.get("open_game_webview"));
        z2 = false;
        try {
            if (this.rXh != null) {
                z2 = this.rXh.d(86, new Bundle()).getBoolean("is_from_keep_top");
            }
            z5 = z2;
        } catch (Exception e2) {
            w.e("MicroMsg.MsgHandler", "doOpenCustomWebview, get from keep top exception : %s", new Object[]{e2.getMessage()});
            z5 = false;
        }
        mz3 = bg.mz((String) iVar.ozE.get("gameAppid"));
        intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("screen_orientation", i);
        intent.putExtra("show_full_screen", z);
        intent.putExtra("disable_swipe_back", z4);
        intent.putExtra("from_shortcut", z3);
        intent.putExtra("shortcut_user_name", mz);
        intent.putExtra("keep_top_scene", 2);
        intent.putExtra("custom_keep_top_url", str2);
        intent.putExtra("custom_keep_top_title", mz4);
        intent.putExtra("is_from_keep_top", z5);
        intent.putExtra("game_hv_menu_appid", mz3);
        if (z3) {
            com.tencent.mm.bb.d.b(this.context, "webview", ".ui.tools.game.H5GameWebViewUI", intent);
        } else if (bg.mz(mz2).equals("1")) {
            com.tencent.mm.bb.d.b(this.context, "webview", ".ui.tools.WebViewUI", intent);
        } else {
            juVar = new ju();
            juVar.fQi.type = 0;
            juVar.fQi.context = this.context;
            juVar.fQi.intent = intent;
            com.tencent.mm.sdk.b.a.urY.m(juVar);
        }
        com.tencent.mm.sdk.platformtools.af.f(/* anonymous class already generated */, 200);
        juVar = new gi();
        juVar.fLC.ou = 2;
        juVar.fLC.fLE = mz3;
        com.tencent.mm.sdk.b.a.urY.m(juVar);
        a(iVar, "openCunstonWebview:ok", null);
        return true;
    }

    public final boolean ce(i iVar) {
        String mz = bg.mz((String) iVar.ozE.get("orientation"));
        int i = -1;
        if (!bg.mA(mz)) {
            if (mz.equals("horizontal")) {
                i = 0;
            } else if (mz.equals("vertical")) {
                i = 1;
            } else if (mz.equals("sensor")) {
                i = 4;
            } else if (mz.equals("horizontal_unforced")) {
                i = MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED;
            } else if (mz.equals("vertical_unforced")) {
                i = MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED;
            }
        }
        try {
            if (this.rXh != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("screen_orientation", i);
                this.rXh.d(1009, bundle);
                a(iVar, "setScreenOrientation:ok", null);
            } else {
                a(iVar, "setScreenOrientation:fail", null);
            }
        } catch (Exception e) {
            w.e("MicroMsg.MsgHandler", "doSetScreenOrientation exception, " + e.getMessage());
            a(iVar, "setScreenOrientation:fail", null);
        }
        return true;
    }

    public final boolean cf(i iVar) {
        final String mz = bg.mz((String) iVar.ozE.get("base64DataString"));
        final String mz2 = bg.mz((String) iVar.ozE.get("thumbUrl"));
        final String mz3 = bg.mz((String) iVar.ozE.get(SlookSmartClipMetaTag.TAG_TYPE_URL));
        final String mz4 = bg.mz((String) iVar.ozE.get("activityId"));
        if (!bg.mA(mz)) {
            final i iVar2 = iVar;
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ g sll;

                public final void run() {
                    w.i("MicroMsg.MsgHandler", "doAddToEmoticon use base64DataString");
                    int indexOf = mz.indexOf(";base64,");
                    String str = "";
                    if (indexOf != -1) {
                        str = mz.substring(indexOf + 8, mz.length());
                    }
                    try {
                        byte[] decode = Base64.decode(str, 0);
                        if (bg.bm(decode)) {
                            this.sll.a(iVar2, "addToEmoticon:fail", null);
                            return;
                        }
                        String n = com.tencent.mm.a.g.n(decode);
                        ap.yY();
                        String D = EmojiLogic.D(com.tencent.mm.u.c.xi(), "", n);
                        if (!(com.tencent.mm.a.e.aO(D) && com.tencent.mm.a.g.aV(D).equalsIgnoreCase(n))) {
                            com.tencent.mm.a.e.b(D, decode, decode.length);
                        }
                        this.sll.V(n, mz2, mz4);
                    } catch (Exception e) {
                        w.e("MicroMsg.MsgHandler", "doAddToEmoticon error:" + e.getMessage());
                        this.sll.a(iVar2, "addToEmoticon:fail_" + e.getMessage(), null);
                    }
                }
            });
        } else if (bg.mA(mz3)) {
            w.e("MicroMsg.MsgHandler", "doAddToEmoticon base64DataString is null and url is null");
            a(iVar, "addToEmoticon:fail_base64DataString_and_url_is_null", null);
            return false;
        } else {
            w.i("MicroMsg.MsgHandler", "doAddToEmoticon use url:%s", new Object[]{mz3});
            final File file = new File(this.context.getCacheDir(), com.tencent.mm.a.g.n(mz3.getBytes()));
            if (file.exists()) {
                ap.vL().D(new Runnable(this) {
                    final /* synthetic */ g sll;

                    public final void run() {
                        String f = com.tencent.mm.a.g.f(file);
                        ap.yY();
                        String D = EmojiLogic.D(com.tencent.mm.u.c.xi(), "", f);
                        if (!FileOp.aO(D)) {
                            FileOp.p(file.getAbsolutePath(), D);
                        }
                        this.sll.V(f, mz2, mz4);
                    }
                });
            } else {
                com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
                aVar.hIL = true;
                aVar.hIN = file.getAbsolutePath();
                aVar.hJm = new Object[]{file.getAbsolutePath()};
                final i iVar3 = iVar;
                com.tencent.mm.plugin.emoji.model.h.alV().a(mz3, null, aVar.Hg(), new com.tencent.mm.ah.a.c.i(this) {
                    final /* synthetic */ g sll;

                    public final void a(String str, Bitmap bitmap, Object... objArr) {
                        w.i("MicroMsg.MsgHandler", "imageLoaderListener onImageLoadComplete %s", new Object[]{str});
                        if (bitmap == null || objArr == null || objArr.length <= 0) {
                            this.sll.a(iVar3, "addToEmoticon:fail", null);
                        } else if (objArr[0] == null || !(objArr[0] instanceof String)) {
                            this.sll.a(iVar3, "addToEmoticon:fail", null);
                        } else if (str.equals(mz3)) {
                            File file = new File(objArr[0].toString());
                            if (file.exists()) {
                                String f = com.tencent.mm.a.g.f(file);
                                ap.yY();
                                FileOp.p(file.getAbsolutePath(), EmojiLogic.D(com.tencent.mm.u.c.xi(), "", f));
                                this.sll.V(f, mz2, mz4);
                                return;
                            }
                            this.sll.a(iVar3, "addToEmoticon:fail", null);
                        } else {
                            this.sll.a(iVar3, "addToEmoticon:fail", null);
                        }
                    }
                });
            }
        }
        return true;
    }

    public final void V(String str, String str2, String str3) {
        ap.yY();
        String D = EmojiLogic.D(com.tencent.mm.u.c.xi(), "", str);
        com.tencent.mm.storage.a.c Si = com.tencent.mm.plugin.emoji.model.h.amc().kLa.Si(str);
        if (Si == null && com.tencent.mm.a.e.aO(D)) {
            int i = com.tencent.mm.sdk.platformtools.o.Pj(D) ? com.tencent.mm.storage.a.c.uLa : com.tencent.mm.storage.a.c.uKZ;
            com.tencent.mm.storage.a.c cVar = new com.tencent.mm.storage.a.c();
            cVar.field_md5 = str;
            cVar.field_catalog = com.tencent.mm.storage.a.c.uKT;
            cVar.field_type = i;
            cVar.field_size = com.tencent.mm.a.e.aN(D);
            cVar.field_temp = 1;
            cVar.field_thumbUrl = str2;
            if (!bg.mA(str3)) {
                cVar.field_activityid = str3;
            }
            com.tencent.mm.plugin.emoji.model.h.amc().kLa.r(cVar);
            Si = cVar;
        }
        if (Si != null) {
            w.i("MicroMsg.MsgHandler", "doAddAction %b", new Object[]{Boolean.valueOf(com.tencent.mm.plugin.emoji.model.h.alY().a(this.context, Si, 18, m.xL()))});
            if (com.tencent.mm.plugin.emoji.model.h.alY().a(this.context, Si, 18, m.xL())) {
                a(this.skt, "addToEmoticon:ok", null);
                return;
            } else {
                a(this.skt, "addToEmoticon:fail", null);
                return;
            }
        }
        a(this.skt, "addToEmoticon:fail", null);
    }

    public final boolean cg(final i iVar) {
        final String mz = bg.mz((String) iVar.ozE.get("base64DataString"));
        final String mz2 = bg.mz((String) iVar.ozE.get(SlookSmartClipMetaTag.TAG_TYPE_URL));
        final String mz3 = bg.mz((String) iVar.ozE.get("activityId"));
        if (!bg.mA(mz)) {
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ g sll;

                public final void run() {
                    w.i("MicroMsg.MsgHandler", "doShareEmoticon use base64DataString");
                    int indexOf = mz.indexOf(";base64,");
                    String str = "";
                    if (indexOf != -1) {
                        str = mz.substring(indexOf + 8, mz.length());
                    }
                    try {
                        byte[] decode = Base64.decode(str, 0);
                        if (bg.bm(decode)) {
                            this.sll.a(iVar, "shareEmoticon:fail", null);
                            return;
                        }
                        String n = com.tencent.mm.a.g.n(decode);
                        ap.yY();
                        String D = EmojiLogic.D(com.tencent.mm.u.c.xi(), "", n);
                        if (!(com.tencent.mm.a.e.aO(D) && com.tencent.mm.a.g.aV(D).equalsIgnoreCase(n))) {
                            com.tencent.mm.a.e.b(D, decode, decode.length);
                        }
                        this.sll.dY(n, mz3);
                    } catch (Exception e) {
                        w.e("MicroMsg.MsgHandler", "doShareEmoticon error:" + e.getMessage());
                        this.sll.a(iVar, "shareEmoticon:fail_" + e.getMessage(), null);
                    }
                }
            });
        } else if (bg.mA(mz2)) {
            w.e("MicroMsg.MsgHandler", "doShareEmoticon base64DataString is null and url is null");
            a(iVar, "shareEmoticon:fail_base64DataString_and_url_is_null", null);
            return false;
        } else {
            w.i("MicroMsg.MsgHandler", "doShareEmoticon use url:%s", new Object[]{mz2});
            final File file = new File(this.context.getCacheDir(), com.tencent.mm.a.g.n(mz2.getBytes()));
            if (file.exists()) {
                ap.vL().D(new Runnable(this) {
                    final /* synthetic */ g sll;

                    public final void run() {
                        String f = com.tencent.mm.a.g.f(file);
                        ap.yY();
                        String D = EmojiLogic.D(com.tencent.mm.u.c.xi(), "", f);
                        if (!FileOp.aO(D)) {
                            FileOp.p(file.getAbsolutePath(), D);
                        }
                        this.sll.dY(f, mz3);
                    }
                });
            } else {
                com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
                aVar.hIL = true;
                aVar.hIN = file.getAbsolutePath();
                aVar.hJm = new Object[]{file.getAbsolutePath()};
                com.tencent.mm.plugin.emoji.model.h.alV().a(mz2, null, aVar.Hg(), new com.tencent.mm.ah.a.c.i(this) {
                    final /* synthetic */ g sll;

                    public final void a(String str, Bitmap bitmap, Object... objArr) {
                        w.i("MicroMsg.MsgHandler", "imageLoaderListener onImageLoadComplete %s", new Object[]{str});
                        if (bitmap == null || objArr == null || objArr.length <= 0) {
                            this.sll.a(iVar, "shareEmoticon:fail", null);
                        } else if (objArr[0] == null || !(objArr[0] instanceof String)) {
                            this.sll.a(iVar, "shareEmoticon:fail", null);
                        } else if (str.equals(mz2)) {
                            File file = new File(objArr[0].toString());
                            if (file.exists()) {
                                String f = com.tencent.mm.a.g.f(file);
                                ap.yY();
                                FileOp.p(file.getAbsolutePath(), EmojiLogic.D(com.tencent.mm.u.c.xi(), "", f));
                                this.sll.dY(f, mz3);
                                return;
                            }
                            this.sll.a(iVar, "shareEmoticon:fail", null);
                        } else {
                            this.sll.a(iVar, "shareEmoticon:fail", null);
                        }
                    }
                });
            }
        }
        return true;
    }

    public final void dY(final String str, final String str2) {
        com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
            final /* synthetic */ g sll;

            public final void run() {
                Intent intent = new Intent();
                intent.putExtra("scene_from", 4);
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("select_is_ret", true);
                intent.putExtra("mutil_select_is_ret", true);
                intent.putExtra("Retr_Msg_Type", 5);
                intent.putExtra("Retr_Msg_thumb_path", str);
                intent.putExtra("emoji_activity_id", str2);
                intent.putExtra("MMActivity.OverrideEnterAnimation", R.a.aQX);
                if (this.sll.context instanceof MMActivity) {
                    com.tencent.mm.bb.d.a((MMActivity) this.sll.context, ".ui.transmit.SelectConversationUI", intent, 52, this.sll);
                }
            }
        });
    }

    public final boolean ch(i iVar) {
        String str = (String) iVar.ozE.get("consumedCardId");
        String str2 = (String) iVar.ozE.get("consumedCode");
        w.i("MicroMsg.MsgHandler", "doConsumedShareCard consumedCardId is " + str);
        if (bg.mA(str) || bg.mA(str2)) {
            w.w("MicroMsg.MsgHandler", "doConsumedShareCard failed, illegal params (id : %s, code : %s)", new Object[]{str, str2});
            a(iVar, "consumedShareCard:fail", null);
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("key_from_scene", 1);
        intent.putExtra("key_consumed_card_id", str);
        intent.putExtra("key_consumed_Code", str2);
        ((MMActivity) this.context).uSV = this;
        com.tencent.mm.bb.d.b(this.context, "card", ".sharecard.ui.CardConsumeSuccessUI", intent, 29);
        return true;
    }

    public final boolean ci(i iVar) {
        w.i("MicroMsg.MsgHandler", "setNavigationBarColor");
        boolean equals = "1".equals((String) iVar.ozE.get("actionCode"));
        Bundle bundle = new Bundle();
        if (equals) {
            bundle.putBoolean("set_navigation_bar_color_reset", true);
        } else {
            int parseColor;
            int i;
            try {
                parseColor = Color.parseColor((String) iVar.ozE.get("color")) | WebView.NIGHT_MODE_COLOR;
            } catch (Exception e) {
                w.e("MicroMsg.MsgHandler", e.getMessage());
                bundle.putBoolean("set_navigation_bar_color_reset", true);
                parseColor = -1;
            }
            try {
                i = (int) (bg.getFloat((String) iVar.ozE.get("alpha"), 1.0f) * 255.0f);
                if (i < 0 || i > 255) {
                    i = 255;
                }
            } catch (Exception e2) {
                w.e("MicroMsg.MsgHandler", e2.getMessage());
                i = -1;
            }
            bundle.putInt("set_navigation_bar_color_color", parseColor);
            bundle.putInt("set_navigation_bar_color_alpha", i);
        }
        try {
            this.rXh.d(53, bundle);
            a(iVar, "setNavigationBarColor:ok", null);
        } catch (Exception e22) {
            w.e("MicroMsg.MsgHandler", e22.getMessage());
            a(iVar, "setNavigationBarColor:fail", null);
        }
        return true;
    }

    public final boolean c(i iVar, boolean z) {
        String str = (String) iVar.ozE.get("designerId");
        int i = bg.getInt((String) iVar.ozE.get("designerUin"), 0);
        String str2 = (String) iVar.ozE.get("tagId");
        String str3 = (String) iVar.ozE.get("tagDesc");
        String str4 = (String) iVar.ozE.get("keyword");
        int i2 = bg.getInt((String) iVar.ozE.get("tid"), 0);
        String ap = bg.ap((String) iVar.ozE.get("title"), "");
        String ap2 = bg.ap((String) iVar.ozE.get("desc"), "");
        String ap3 = bg.ap((String) iVar.ozE.get("iconUrl"), "");
        String ap4 = bg.ap((String) iVar.ozE.get("secondUrl"), "");
        int i3 = bg.getInt((String) iVar.ozE.get("pageType"), 0);
        long j = bg.getLong((String) iVar.ozE.get("searchID"), 0);
        w.d("MicroMsg.MsgHandler", "cpan emoji openDesignerEmojiView:%d", new Object[]{Long.valueOf(j)});
        Intent intent = new Intent();
        intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, i);
        intent.putExtra("headurl", ap4);
        intent.putExtra("set_iconURL", ap3);
        intent.putExtra("set_desc", ap2);
        intent.putExtra("pageType", i3);
        intent.putExtra("set_title", ap);
        intent.putExtra("set_id", i2);
        w.i("MicroMsg.MsgHandler", "openDesignerEmojiView event: designerID:%s tagID:%s tagDesc:%s keyword:%s", new Object[]{str, str2, str3, str4});
        if (!bg.mA(str4)) {
            intent.putExtra("keyword", str4);
            intent.putExtra("searchID", j);
            com.tencent.mm.bb.d.b(this.context, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
            a(iVar, "openDesignerEmojiView:ok" + str4, null);
            if (z) {
                com.tencent.mm.plugin.report.service.g.oUh.i(13055, new Object[]{Integer.valueOf(2), "", "", "", Integer.valueOf(com.tencent.mm.ac.a.EI()), Long.valueOf(j)});
            }
            return true;
        } else if (!bg.mA(str)) {
            intent.putExtra(SlookAirButtonFrequentContactAdapter.ID, str);
            intent.putExtra("searchID", j);
            com.tencent.mm.bb.d.b(this.context, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
            a(iVar, "openDesignerEmojiView:ok" + str, null);
            return true;
        } else if (bg.mA(str2)) {
            com.tencent.mm.bb.d.b(this.context, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
            a(iVar, "openDesignerEmojiView:ok", null);
            return true;
        } else {
            intent.putExtra("tag_id", str2);
            intent.putExtra("tag_desc", str3);
            com.tencent.mm.bb.d.b(this.context, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
            a(iVar, "openDesignerEmojiView:ok" + str2, null);
            return true;
        }
    }

    public final boolean d(i iVar, boolean z) {
        w.i("MicroMsg.MsgHandler", "openDesignerProfile");
        String str = (String) iVar.ozE.get("designerId");
        w.d("MicroMsg.MsgHandler", "cpan emoji openDesignerProfile:%d", new Object[]{Long.valueOf(bg.getLong((String) iVar.ozE.get("searchID"), 0))});
        if (bg.mA(str)) {
            w.w("MicroMsg.MsgHandler", "openDesignerProfile failed designer id is null.");
            a(iVar, "openDesignerProfile", null);
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra(SlookAirButtonFrequentContactAdapter.ID, str);
        intent.putExtra("extra_scence", 12);
        intent.putExtra("searchID", r4);
        com.tencent.mm.bb.d.b(this.context, "emoji", ".ui.v2.EmojiStoreV2DesignerUI", intent);
        a(iVar, "openDesignerProfile", null);
        if (z) {
            com.tencent.mm.plugin.report.service.g.oUh.i(13055, new Object[]{Integer.valueOf(3), "", str, "", Integer.valueOf(com.tencent.mm.ac.a.EI()), Long.valueOf(r4)});
        }
        return true;
    }

    public final boolean cj(i iVar) {
        w.i("MicroMsg.MsgHandler", "openEmoticonTopicList");
        int i = bg.getInt((String) iVar.ozE.get("tid"), 0);
        String str = (String) iVar.ozE.get("title");
        String str2 = (String) iVar.ozE.get("desc");
        String str3 = (String) iVar.ozE.get("iconUrl");
        String str4 = (String) iVar.ozE.get("secondUrl");
        Intent intent = new Intent();
        intent.putExtra("topic_id", i);
        intent.putExtra("topic_name", str);
        intent.putExtra("topic_desc", str2);
        intent.putExtra("topic_icon_url", str3);
        intent.putExtra("topic_ad_url", str4);
        intent.putExtra("extra_scence", 12);
        com.tencent.mm.bb.d.b(this.context, "emoji", ".ui.EmojiStoreTopicUI", intent);
        a(iVar, "openEmoticonTopicList", null);
        return true;
    }

    public final boolean ck(i iVar) {
        w.i("MicroMsg.MsgHandler", "openEmotionDetailView");
        String str = (String) iVar.ozE.get("ProductId");
        w.d("MicroMsg.MsgHandler", "cpan emoji openEmotionDetailView:%d", new Object[]{Long.valueOf(bg.getLong((String) iVar.ozE.get("searchID"), 0))});
        if (bg.mA(str)) {
            w.w("MicroMsg.MsgHandler", "openEmotionDetailView failed product id is null.");
            a(iVar, "openEmotionDetailView", null);
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("extra_id", str);
        intent.putExtra("preceding_scence", 12);
        intent.putExtra("download_entrance_scene", 12);
        intent.putExtra("searchID", r4);
        if (this.skG) {
            w.i("MicroMsg.MsgHandler", "had start emoji stroe detail ui.");
        } else {
            com.tencent.mm.bb.d.b(this.context, "emoji", ".ui.EmojiStoreDetailUI", intent);
            this.skG = true;
        }
        a(iVar, "openEmotionDetailView", null);
        com.tencent.mm.plugin.report.service.g.oUh.i(13055, new Object[]{Integer.valueOf(0), str, "", "", Integer.valueOf(com.tencent.mm.ac.a.EI()), Long.valueOf(r4)});
        return true;
    }

    public final boolean cl(i iVar) {
        this.lre = false;
        com.tencent.mm.plugin.webview.d.f.bwT();
        Map map = iVar.ozE;
        String EG = com.tencent.mm.ac.a.EG();
        if (bg.mA(EG)) {
            w.e("MicroMsg.emoji.EmojiStoreWebViewLogic", "load emojiStore Template Path error");
            return false;
        }
        int p = com.tencent.mm.plugin.webview.b.a.p(map, Columns.TYPE);
        String o = com.tencent.mm.plugin.webview.b.a.o(map, "pageName");
        String o2 = com.tencent.mm.plugin.webview.b.a.o(map, "keyword");
        int p2 = com.tencent.mm.plugin.webview.b.a.p(map, "scene");
        Intent intent = new Intent();
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sYW);
        intent.putExtra("neverGetA8Key", true);
        intent.putExtra("rawUrl", "file://" + EG + "/" + o + "?type=" + p + "&keyword=" + o2 + "&scene=" + p2 + "&lang=" + v.ea(ab.getContext()) + "&clientType=1&version=" + com.tencent.mm.ac.a.EI());
        intent.putExtra("keyword", o2);
        intent.putExtra(Columns.TYPE, p);
        intent.putExtra("sence", p2);
        com.tencent.mm.bb.d.b(ab.getContext(), "webview", ".ui.tools.emojistore.EmojiStoreSearchWebViewUI", intent);
        com.tencent.mm.plugin.report.service.g.oUh.i(13055, new Object[]{Integer.valueOf(1), "", "", Integer.valueOf(p), Integer.valueOf(com.tencent.mm.ac.a.EI()), Long.valueOf(0)});
        com.tencent.mm.sdk.b.b ldVar = new ld();
        ldVar.fRL.type = p;
        ldVar.fRL.fRM = o2;
        ldVar.fRL.fRN = "";
        com.tencent.mm.sdk.b.a.urY.m(ldVar);
        return true;
    }

    public final boolean cm(i iVar) {
        this.lre = false;
        return com.tencent.mm.plugin.webview.d.f.bwT().K(iVar.ozE);
    }

    public final boolean cn(i iVar) {
        this.lre = false;
        com.tencent.mm.plugin.webview.d.f.bwT();
        String o = com.tencent.mm.plugin.webview.b.a.o(iVar.ozE, "urlString");
        Intent intent = new Intent();
        intent.putExtra("rawUrl", o);
        com.tencent.mm.bb.d.b(ab.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        return false;
    }

    public final void a(String str, boolean z, String str2, long j) {
        Bundle bundle = new Bundle();
        bundle.putString("emoji_store_json_data", str);
        bundle.putBoolean("emoji_store_new_query", z);
        bundle.putString("emoji_store_page_buf", str2);
        bundle.putLong("emoji_store_search_id", j);
        w.d("MicroMsg.MsgHandler", "cpan emoji getSearchEmotionDataCallBack:%d", new Object[]{Long.valueOf(j)});
        try {
            if (this.rXh != null) {
                this.rXh.m(80001, bundle);
            }
        } catch (RemoteException e) {
            w.w("MicroMsg.MsgHandler", "getSearchEmotionDataCallBack exception" + e.getMessage());
        }
    }

    private boolean jb(boolean z) {
        w.e("MicroMsg.MsgHandler", "hideMenuEntry:" + z);
        try {
            this.rXh.iP(z);
            w.e("MicroMsg.MsgHandler", "hideMenuEntry succ");
            return true;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
            w.e("MicroMsg.MsgHandler", "hideMenuEntry error");
            w.e("MicroMsg.MsgHandler", "hideMenuEntry succ");
            return false;
        } catch (Throwable th) {
            w.e("MicroMsg.MsgHandler", "hideMenuEntry succ");
            return true;
        }
    }

    public final boolean co(i iVar) {
        w.i("MicroMsg.MsgHandler", "doSelectSingleContact selectedMode:%d", new Object[]{Integer.valueOf(bg.getInt((String) iVar.ozE.get("selectMode"), 0))});
        Intent intent = new Intent();
        if (bg.getInt((String) iVar.ozE.get("selectMode"), 0) == 1) {
            intent.putExtra("Select_Conv_Type", 263);
            intent.putExtra("jsapi_select_mode", 1);
        } else {
            intent.putExtra("Select_Conv_Type", 259);
        }
        intent.putExtra("select_is_ret", true);
        intent.putExtra("Select_block_List", m.xL());
        intent.putExtra("scene_from", 4);
        if (this.context instanceof MMActivity) {
            com.tencent.mm.bb.d.a((MMActivity) this.context, ".ui.transmit.SelectConversationUI", intent, 30, this);
        }
        return true;
    }

    public final boolean cp(final i iVar) {
        w.i("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact");
        String str = (String) iVar.ozE.get("openid");
        if (bg.mA(str)) {
            w.e("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact openid is null");
            a(iVar, "sendAppMessageToSpecifiedContact:fail", null);
        } else {
            String str2 = (String) iVar.ozE.get("appId");
            if (this.skw != null && TextUtils.isEmpty(str2)) {
                str2 = this.skw.getString("jsapi_args_appid");
            }
            if (bg.mA(str2)) {
                w.e("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact appid is null");
                a(iVar, "sendAppMessageToSpecifiedContact:fail", null);
            } else {
                this.fNK = h(iVar);
                final k vVar = new com.tencent.mm.plugin.webview.model.v(str2, str);
                ap.vd().a(1142, new e(this) {
                    final /* synthetic */ g sll;

                    public final void a(int i, int i2, String str, k kVar) {
                        if (this.sll.isv != null && this.sll.isv.isShowing()) {
                            this.sll.isv.dismiss();
                            this.sll.isv = null;
                        }
                        if (i == 0 && i2 == 0) {
                            bfm com_tencent_mm_protocal_c_bfm;
                            com.tencent.mm.plugin.webview.model.v vVar = (com.tencent.mm.plugin.webview.model.v) kVar;
                            if (vVar.gUA == null) {
                                com_tencent_mm_protocal_c_bfm = null;
                            } else {
                                com_tencent_mm_protocal_c_bfm = (bfm) vVar.gUA.hsk.hsr;
                            }
                            if (com_tencent_mm_protocal_c_bfm != null) {
                                String str2 = com_tencent_mm_protocal_c_bfm.username;
                                if (bg.mA(str2)) {
                                    w.e("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact request userName is null");
                                } else if (this.sll.context instanceof MMActivity) {
                                    com.tencent.mm.ui.base.h hVar;
                                    String str3 = (String) iVar.ozE.get("img_url");
                                    String str4 = (String) iVar.ozE.get("desc");
                                    String str5 = (String) iVar.ozE.get("src_username");
                                    String str6 = (String) iVar.ozE.get("src_displayname");
                                    String str7 = (String) iVar.ozE.get("title");
                                    g gVar = this.sll;
                                    String str8 = str2;
                                    String str9 = "sendAppMessageToSpecifiedContact:ok";
                                    String str10 = "sendAppMessageToSpecifiedContact:fail";
                                    if (gVar.context == null || gVar.context.getResources() == null) {
                                        w.e("MicroMsg.MsgHandler", "showSendAppMsgDialog fail, context or context.getResources() is null");
                                        hVar = null;
                                    } else if (gVar.context instanceof Activity) {
                                        String bzz = gVar.bzz();
                                        f aJ = com.tencent.mm.pluginsdk.model.app.g.aJ(str8, true);
                                        hVar = com.tencent.mm.pluginsdk.ui.applet.d.a(((MMActivity) gVar.context).uSU, str7, str3, str4, null, true, gVar.context.getResources().getString(R.l.dIA), new AnonymousClass96(gVar, aJ, str8, str2, str3, str5, str6, bzz, true, str9, str10));
                                    } else {
                                        w.e("MicroMsg.MsgHandler", "showsSendAppMsgDialog fail, context is not activity");
                                        hVar = null;
                                    }
                                    if (hVar == null) {
                                        w.e("MicroMsg.MsgHandler", "sendAppMessageToSpecifiedContact fail, cannot show dialog");
                                        this.sll.a(iVar, "sendAppMessageToSpecifiedContact:fail", null);
                                    } else {
                                        return;
                                    }
                                }
                            }
                            w.e("MicroMsg.MsgHandler", "TransIdResponse response is null");
                        } else {
                            w.e("MicroMsg.MsgHandler", "doSendAppMsgToSpecifiedContact request error is null");
                        }
                        this.sll.a(iVar, "sendAppMessageToSpecifiedContact:fail", null);
                    }
                });
                ap.vd().a(vVar, 0);
                Context context = this.context;
                this.context.getString(R.l.dIO);
                this.isv = com.tencent.mm.ui.base.g.a(context, this.context.getString(R.l.dJd), true, new OnCancelListener(this) {
                    final /* synthetic */ g sll;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(vVar);
                    }
                });
            }
        }
        return true;
    }

    public final boolean bzJ() {
        try {
            Bundle bundle = new Bundle(1);
            bundle.putString("place_holder", "place_holder");
            this.rXh.bxl();
            this.rXh.M(bundle);
        } catch (Exception e) {
        }
        return true;
    }

    public final boolean cq(i iVar) {
        w.i("MicroMsg.MsgHandler", "doWCPayRealnameVerify call");
        com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(iVar.ozE);
        Intent intent = new Intent();
        String str = null;
        try {
            str = this.rXh.VD();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        if (!bg.mA(str)) {
            intent.putExtra("appId", this.skF.JZ(str));
            intent.putExtra("timeStamp", dVar.timeStamp);
            intent.putExtra("nonceStr", dVar.nonceStr);
            intent.putExtra("packageExt", dVar.packageExt);
            intent.putExtra("signtype", dVar.signType);
            intent.putExtra("paySignature", dVar.fRt);
            try {
                intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, this.rXh.VD());
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
            }
            intent.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            intent.putExtra("realname_scene", 1);
            ((MMActivity) this.context).uSV = this;
            com.tencent.mm.bb.d.b(this.context, "wallet_core", ".id_verify.WalletRealNameProcessProxyUI", intent, 34);
        }
        return true;
    }

    public final boolean bzK() {
        w.i("MicroMsg.MsgHandler", "doSwitchWalletCurrency call");
        ((MMActivity) this.context).uSV = this;
        com.tencent.mm.bb.d.b(this.context, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", null, 35);
        return true;
    }

    public final boolean cr(i iVar) {
        boolean z;
        String str = (String) iVar.ozE.get("clearCookie");
        w.i("MicroMsg.MsgHandler", "clearflag = %s", new Object[]{str});
        if (bg.mA(str) || !str.equalsIgnoreCase("true")) {
            z = false;
        } else {
            z = true;
        }
        str = (String) iVar.ozE.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (!bg.mA(str)) {
            str = com.tencent.mm.plugin.webview.modelcache.p.Jb(str);
            if (bg.mA(str)) {
                str = null;
            } else {
                Uri parse = Uri.parse(str);
                str = parse.getHost() + ":" + parse.getPort();
            }
            if (!bg.mA(str)) {
                a.rYG.vL().D(new Runnable(this) {
                    final /* synthetic */ g sll;

                    public final void run() {
                        List list = null;
                        com.tencent.mm.plugin.webview.modelcache.q qVar = a.rYG;
                        String str = str;
                        if (!bg.mA(str)) {
                            com.tencent.mm.plugin.webview.modelcache.k bwL = com.tencent.mm.plugin.webview.modelcache.k.bwL();
                            if (bwL.rXW && !bg.mA(str)) {
                                list = bwL.l(String.format("select * from %s where %s=? ", new Object[]{"WebViewResourceCache", "domain"}), str);
                            }
                            if (!bg.bV(r0)) {
                                for (com.tencent.mm.plugin.webview.modelcache.f fVar : r0) {
                                    com.tencent.mm.plugin.webview.modelcache.a Ja = com.tencent.mm.plugin.webview.modelcache.a.Ja(fVar.field_appId);
                                    if (Ja != null) {
                                        String str2 = fVar.field_localPath;
                                        if (!bg.mA(str2)) {
                                            long ki = str2.startsWith(Ja.path) ? FileOp.ki(str2) : 0;
                                            if (FileOp.deleteFile(str2) && str2.startsWith(Ja.path)) {
                                                b bVar = Ja.rXS;
                                                String str3 = Ja.appId;
                                                if (bVar.rXW) {
                                                    com.tencent.mm.sdk.e.c aVar = new a();
                                                    aVar.field_appId = str3;
                                                    if (bVar.b(aVar, new String[0])) {
                                                        aVar.field_occupation = Math.max(0, aVar.field_occupation - ki);
                                                        bVar.c(aVar, new String[0]);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                com.tencent.mm.plugin.webview.modelcache.k bwL2 = com.tencent.mm.plugin.webview.modelcache.k.bwL();
                                if (bwL2.rXW && !bg.mA(str)) {
                                    com.tencent.mm.sdk.e.c fVar2 = new com.tencent.mm.plugin.webview.modelcache.f();
                                    fVar2.field_domain = str;
                                    bwL2.a(fVar2, new String[]{"domain"});
                                }
                            }
                        }
                        WebViewCacheDownloadHelper.bwO();
                    }
                });
            }
        }
        if (this.rXh != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("clear_webview_cache_clear_cookie", z);
            try {
                this.rXh.d(6001, bundle);
                a(iVar, "clearWebviewCache:ok", null);
            } catch (Exception e) {
                w.e("MicroMsg.MsgHandler", "clear webview cache fail : %s", new Object[]{e.getMessage()});
                a(iVar, "clearWebviewCache:fail", null);
            }
        } else {
            a(iVar, "clearWebviewCache:fail", null);
        }
        return true;
    }

    public final boolean cs(i iVar) {
        com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(iVar.ozE);
        Intent intent = new Intent();
        String str = (String) iVar.ozE.get("appId");
        if (this.skw != null) {
            if (TextUtils.isEmpty(str)) {
                str = this.skw.getString("jsapi_args_appid");
            }
            if (TextUtils.isEmpty(str)) {
                str = this.skF.JZ(VD());
            }
        }
        intent.putExtra("appId", str);
        intent.putExtra("timeStamp", dVar.timeStamp);
        intent.putExtra("nonceStr", dVar.nonceStr);
        intent.putExtra("packageExt", dVar.packageExt);
        intent.putExtra("signtype", dVar.signType);
        intent.putExtra("paySignature", dVar.fRt);
        intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, VD());
        ((MMActivity) this.context).uSV = this;
        com.tencent.mm.bb.d.a(this.context, "wallet", ".bind.ui.WalletUnbindBankCardProxyUI", intent, 39, false);
        return true;
    }

    public final boolean ct(i iVar) {
        w.i("MicroMsg.MsgHandler", "doIdCardRealnameVerify call");
        com.tencent.mm.pluginsdk.wallet.d dVar = new com.tencent.mm.pluginsdk.wallet.d(iVar.ozE);
        Intent intent = new Intent();
        String str = null;
        try {
            str = this.rXh.VD();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        if (!bg.mA(str)) {
            intent.putExtra("appId", this.skF.JZ(str));
            intent.putExtra("timeStamp", dVar.timeStamp);
            intent.putExtra("nonceStr", dVar.nonceStr);
            intent.putExtra("packageExt", dVar.packageExt);
            intent.putExtra("signtype", dVar.signType);
            intent.putExtra("paySignature", dVar.fRt);
            try {
                intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_URL, this.rXh.VD());
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
            }
            intent.putExtra("real_name_verify_mode", 2);
            intent.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            intent.putExtra("realname_scene", 1);
            ((MMActivity) this.context).uSV = this;
            com.tencent.mm.bb.d.b(this.context, "wallet_core", ".id_verify.WalletRealNameProcessProxyUI", intent, 41);
        }
        return true;
    }

    public final boolean cu(i iVar) {
        a(iVar, "uploadIdCardSuccess:ok", null);
        w.i("MicroMsg.MsgHandler", "uploadIdCardSuccess");
        com.tencent.mm.sdk.b.b sgVar = new sg();
        sgVar.fZM.result = -1;
        com.tencent.mm.sdk.b.a.urY.m(sgVar);
        return true;
    }

    public final boolean cv(i iVar) {
        w.i("MicroMsg.MsgHandler", "getGameCommInfo call");
        int i = bg.getInt((String) iVar.ozE.get("cmd"), 0);
        String str = (String) iVar.ozE.get("param");
        com.tencent.mm.sdk.b.b giVar = new gi();
        giVar.fLC.ou = i;
        giVar.fLC.fLE = str;
        giVar.fLC.context = this.context;
        com.tencent.mm.sdk.b.a.urY.m(giVar);
        Map hashMap = new HashMap();
        hashMap.put("gameRegionName", giVar.fLD.result);
        a(iVar, "getGameCommInfo:ok", hashMap);
        return true;
    }

    public final boolean bzL() {
        w.i("MicroMsg.MsgHandler", "openGameRegion call");
        if (this.context instanceof MMActivity) {
            ((MMActivity) this.context).uSV = this;
            com.tencent.mm.bb.d.a(this.context, "game", ".ui.GameRegionSelectUI", null, 42, false);
        }
        return true;
    }

    public final boolean cw(final i iVar) {
        l lVar = new l(this.context);
        lVar.b(null, new OnCreateContextMenuListener(this) {
            final /* synthetic */ g sll;

            {
                this.sll = r1;
            }

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                contextMenu.add(0, 1, 0, this.sll.context.getString(R.l.eOB));
                contextMenu.add(0, 2, 1, this.sll.context.getString(R.l.eOw));
            }
        }, new com.tencent.mm.ui.base.n.d(this) {
            final /* synthetic */ g sll;

            public final void c(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 1:
                        g gVar = this.sll;
                        i iVar = iVar;
                        if (gVar.context == null) {
                            gVar.a(iVar, "chooseIdCard:fail", null);
                            return;
                        }
                        if (!gVar.skI.a("identity_pay_auth", gVar.context, new AnonymousClass102(gVar, iVar))) {
                            gVar.a(iVar, "chooseIdCard:fail", null);
                            return;
                        }
                        return;
                    case 2:
                        Object obj = this.sll;
                        i iVar2 = iVar;
                        w.i("MicroMsg.MsgHandler", "real scene = %d", new Object[]{Integer.valueOf(3)});
                        w.d("MicroMsg.MsgHandler", " checkPermission checkcamera[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a((Activity) obj.context, "android.permission.CAMERA", 113, "", ""))});
                        if (com.tencent.mm.pluginsdk.i.a.a((Activity) obj.context, "android.permission.CAMERA", 113, "", "")) {
                            Intent intent = new Intent();
                            intent.putExtra("key_pick_local_pic_capture", 3);
                            intent.putExtra("key_pick_local_pic_query_source_type", 8);
                            intent.putExtra("query_media_type", 1);
                            intent.putExtra("key_pick_local_pic_count", 1);
                            w.i("MicroMsg.MsgHandler", "doChooseImageIdCard: realScene: %d, querySourceType: %d", new Object[]{Integer.valueOf(3), Integer.valueOf(8)});
                            if (obj.context instanceof MMActivity) {
                                ((MMActivity) obj.context).uSV = obj;
                                com.tencent.mm.bb.d.a(obj.context, "webview", ".ui.tools.OpenFileChooserUI", intent, 43, false);
                                return;
                            }
                            return;
                        }
                        obj.a(iVar2, "chooseIdCard:fail", null);
                        return;
                    default:
                        return;
                }
            }
        });
        lVar.e(new OnCancelListener(this) {
            final /* synthetic */ g sll;

            public final void onCancel(DialogInterface dialogInterface) {
                this.sll.a(iVar, "chooseIdCard:cancel", null);
            }
        });
        lVar.blb();
        return true;
    }

    public final boolean cx(i iVar) {
        w.i("MicroMsg.MsgHandler", "launchTimeInterval = %d", new Object[]{Long.valueOf(bg.Ny() - this.skJ)});
        if (bg.Ny() - this.skJ < 2 && this.skJ > 0) {
            try {
                String encode = URLEncoder.encode(this.rXh.VD(), "UTF-8");
                com.tencent.mm.plugin.report.service.g.oUh.i(13983, new Object[]{Integer.valueOf(5), encode, ""});
            } catch (Exception e) {
                w.e("MicroMsg.MsgHandler", "report launchApplication failed");
            }
        }
        final String str = (String) iVar.ozE.get("appID");
        final String str2 = (String) iVar.ozE.get("schemeUrl");
        final String str3 = (String) iVar.ozE.get("parameter");
        int i = bg.getInt((String) iVar.ozE.get("alertType"), 0);
        k.a(iVar.smM, false, null, str);
        final String str4 = (String) iVar.ozE.get("extInfo");
        w.i("MicroMsg.MsgHandler", "doLaunchApplication, appid : %s, scheme : %s, extinfo:[%s], parameter : %s", new Object[]{str, str2, str4, str3});
        if (bg.mA(str) && bg.mA(str2)) {
            w.e("MicroMsg.MsgHandler", "appid and scheme is null or nil");
            a(iVar, "launchApplication:fail", null);
            return true;
        }
        Object obj = iVar.ozE.get("__jsapi_fw_ext_info");
        String str5 = null;
        if (obj instanceof Bundle) {
            str5 = ((Bundle) obj).getString("__jsapi_fw_ext_info_key_current_url");
        }
        String JZ = this.skF.JZ(str5);
        final Bundle bundle = new Bundle();
        if (!bg.mA(str5)) {
            try {
                bundle.putString("current_page_url", URLEncoder.encode(str5, "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
            }
        }
        bundle.putString("current_page_appid", JZ);
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new ago();
        aVar.hsn = new agp();
        aVar.uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
        aVar.hsl = 1125;
        com.tencent.mm.y.b BE = aVar.BE();
        ago com_tencent_mm_protocal_c_ago = (ago) BE.hsj.hsr;
        com_tencent_mm_protocal_c_ago.fTO = JZ;
        com_tencent_mm_protocal_c_ago.tLw = str;
        com_tencent_mm_protocal_c_ago.scene = UP();
        com_tencent_mm_protocal_c_ago.url = str5;
        com_tencent_mm_protocal_c_ago.tLx = str2;
        com_tencent_mm_protocal_c_ago.kAF = i;
        w.i("MicroMsg.MsgHandler", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s)", new Object[]{JZ, str, Integer.valueOf(com_tencent_mm_protocal_c_ago.scene), com_tencent_mm_protocal_c_ago.url, com_tencent_mm_protocal_c_ago.tLx, Integer.valueOf(com_tencent_mm_protocal_c_ago.kAF)});
        final i iVar2 = iVar;
        u.a(BE, new com.tencent.mm.y.u.a(this) {
            final /* synthetic */ g sll;

            public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                w.d("MicroMsg.MsgHandler", "on RunCgi callback errType:%d errCode:%d msg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                if (i == 0 && i2 == 0) {
                    agp com_tencent_mm_protocal_c_agp = (agp) bVar.hsk.hsr;
                    switch (com_tencent_mm_protocal_c_agp.fIz) {
                        case 0:
                            List x;
                            Object b;
                            boolean a;
                            Object dVar = new d(new a(this) {
                                final /* synthetic */ AnonymousClass103 smv;

                                {
                                    this.smv = r1;
                                }

                                public final void C(boolean z, boolean z2) {
                                    w.i("MicroMsg.MsgHandler", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
                                    if (z) {
                                        this.smv.sll.a(iVar2, "launchApplication:ok", null);
                                    } else {
                                        this.smv.sll.a(iVar2, "launchApplication:fail", null);
                                    }
                                }
                            });
                            if (!bg.mA(str2)) {
                                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str2));
                                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                x = bg.x(this.sll.context, intent);
                                if (!(x == null || x.isEmpty())) {
                                    if (TextUtils.isEmpty(intent.getPackage()) && x.size() == 1) {
                                        b = com.tencent.mm.pluginsdk.model.app.g.b((ResolveInfo) x.get(0));
                                    } else {
                                        b = intent.getPackage();
                                    }
                                    if (!bg.mz(ab.getPackageName()).equals(b)) {
                                        dVar.jc(com.tencent.mm.pluginsdk.model.app.g.a(this.sll.context, intent, null, com_tencent_mm_protocal_c_agp.tLy, dVar, bundle));
                                        return 0;
                                    }
                                }
                            }
                            IMediaObject wXAppExtendObject = new WXAppExtendObject();
                            wXAppExtendObject.extInfo = str4;
                            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                            wXMediaMessage.sdkVer = 620757000;
                            wXMediaMessage.messageExt = str4;
                            com.tencent.mm.sdk.b.b ieVar = new ie();
                            ieVar.fNI.fNK = wXMediaMessage;
                            ieVar.fNI.appId = str;
                            ieVar.fNI.showType = com_tencent_mm_protocal_c_agp.tLy;
                            ieVar.fNI.context = this.sll.context;
                            ieVar.fNI.fFu = bundle;
                            ieVar.fNI.fNL = dVar;
                            com.tencent.mm.sdk.b.a.urY.m(ieVar);
                            boolean z = ieVar.fNJ.fNM;
                            if (!z) {
                                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str + "://" + str3));
                                w.i("MicroMsg.MsgHandler", "launchApplication by opensdk failed, try to launch by scheme(%s).", new Object[]{r0});
                                intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                x = bg.x(this.sll.context, intent2);
                                if (!(x == null || x.isEmpty())) {
                                    if (TextUtils.isEmpty(intent2.getPackage()) && x.size() == 1) {
                                        b = com.tencent.mm.pluginsdk.model.app.g.b((ResolveInfo) x.get(0));
                                    } else {
                                        b = intent2.getPackage();
                                    }
                                    if (!bg.mz(ab.getPackageName()).equals(b)) {
                                        a = com.tencent.mm.pluginsdk.model.app.g.a(this.sll.context, intent2, null, dVar, bundle);
                                        dVar.jc(a);
                                        return 0;
                                    }
                                }
                            }
                            a = z;
                            dVar.jc(a);
                            return 0;
                        case 2:
                            this.sll.a(iVar2, "launchApplication:fail_check fail forbidden scene", null);
                            return 0;
                        default:
                            this.sll.a(iVar2, "launchApplication:fail_check fail", null);
                            return 0;
                    }
                }
                this.sll.a(iVar2, "launchApplication:fail_check fail", null);
                return 0;
            }
        });
        return true;
    }

    public final boolean cy(final i iVar) {
        w.i("MicroMsg.MsgHandler", "doLoginOrAuthorize!");
        Runnable anonymousClass105 = new Runnable(this) {
            final /* synthetic */ g sll;

            public final void run() {
                if (iVar.smN.equals("login")) {
                    this.sll.a(iVar, g.sld);
                } else if (iVar.smN.equals(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.d.NAME)) {
                    this.sll.b(iVar, g.sld);
                }
            }
        };
        if (slc) {
            slb.add(anonymousClass105);
            w.i("MicroMsg.MsgHandler", "add to authJsApiQueue!");
        } else {
            slc = true;
            anonymousClass105.run();
        }
        return true;
    }

    public final boolean a(final i iVar, final a aVar) {
        String VD;
        w.i("MicroMsg.MsgHandler", "doLogin!");
        LinkedList linkedList = new LinkedList();
        String str = "";
        String str2 = "";
        try {
            VD = this.rXh.VD();
        } catch (Exception e) {
            w.e("MicroMsg.MsgHandler", "exception in get currentUrl %s", new Object[]{e.getMessage()});
            VD = null;
        }
        final String mz = bg.mz(this.skF.JZ(VD));
        if (bg.mA(mz)) {
            w.e("MicroMsg.MsgHandler", "appId is null!");
            a(iVar, "doLogin:fail", null);
            aVar.Tn();
            return false;
        }
        ap.vd().a(new com.tencent.mm.r.a.c(mz, linkedList, str2, str, new com.tencent.mm.r.a.c.a<com.tencent.mm.r.a.c>(this) {
            final /* synthetic */ g sll;

            public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
                com.tencent.mm.r.a.c cVar = (com.tencent.mm.r.a.c) kVar;
                w.i("MicroMsg.MsgHandler", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                if (i != 0 || i2 != 0) {
                    this.sll.a(iVar, "login:fail", null);
                    aVar.Tn();
                } else if (cVar instanceof com.tencent.mm.r.a.c) {
                    final ahg uF = cVar.uF();
                    int i3 = uF.tLL.fIz;
                    String str2 = uF.tLL.fIA;
                    final String str3 = uF.tLN;
                    w.i("MicroMsg.MsgHandler", "NetSceneJSLogin jsErrcode %d", new Object[]{Integer.valueOf(i3)});
                    if (i3 == -12000) {
                        com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass107 smz;

                            public final void run() {
                                LinkedList linkedList = uF.tBL;
                                w.d("MicroMsg.MsgHandler", "appName %s, appIconUrl %s", new Object[]{uF.muS, uF.tee});
                                com.tencent.mm.plugin.webview.ui.tools.widget.e eVar = new com.tencent.mm.plugin.webview.ui.tools.widget.e(this.smz.sll.context);
                                com.tencent.mm.plugin.webview.ui.tools.widget.e.a anonymousClass1 = new com.tencent.mm.plugin.webview.ui.tools.widget.e.a(this) {
                                    final /* synthetic */ AnonymousClass1 smA;

                                    {
                                        this.smA = r1;
                                    }

                                    public final void c(int i, Bundle bundle) {
                                        w.i("MicroMsg.MsgHandler", "onRevMsg resultCode %d", new Object[]{Integer.valueOf(i)});
                                        switch (i) {
                                            case 1:
                                            case 2:
                                                g gVar = this.smA.smz.sll;
                                                String str = mz;
                                                String str2 = str3;
                                                i iVar = iVar;
                                                a aVar = aVar;
                                                ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
                                                LinkedList linkedList = new LinkedList();
                                                Iterator it = arrayList.iterator();
                                                while (it.hasNext()) {
                                                    linkedList.add((String) it.next());
                                                }
                                                ap.vd().a(new com.tencent.mm.r.a.d(str, linkedList, 0, str2, 0, i, new AnonymousClass106(gVar, iVar, aVar, i)), 0);
                                                if (i == 2) {
                                                    w.e("MicroMsg.MsgHandler", "fail auth deny!");
                                                    this.smA.smz.sll.a(iVar, "login:fail auth deny", null);
                                                    aVar.Tn();
                                                    return;
                                                }
                                                return;
                                            default:
                                                w.i("MicroMsg.MsgHandler", "press back button!");
                                                this.smA.smz.sll.a(iVar, "login:fail auth cancel", null);
                                                aVar.Tn();
                                                return;
                                        }
                                    }
                                };
                                if (linkedList == null || linkedList.size() <= 0) {
                                    w.e("MicroMsg.MsgHandler", "scopeInfoList is empty!");
                                    this.smz.sll.a(iVar, "login:fail", null);
                                    aVar.Tn();
                                } else if (!eVar.a(linkedList, r1, r2, anonymousClass1)) {
                                    aVar.Tn();
                                }
                            }
                        });
                    } else if (i3 == 0) {
                        String str4 = uF.tLO;
                        Map hashMap = new HashMap();
                        hashMap.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, str4);
                        this.sll.a(iVar, "login:ok", hashMap);
                        w.d("MicroMsg.MsgHandler", "resp data code [%s]", new Object[]{str4});
                        aVar.Tn();
                    } else {
                        this.sll.a(iVar, "login:fail", null);
                        w.e("MicroMsg.MsgHandler", "onSceneEnd NetSceneJSLogin %s", new Object[]{str2});
                        aVar.Tn();
                    }
                }
            }
        }), 0);
        return true;
    }

    public final boolean b(final i iVar, final a aVar) {
        w.i("MicroMsg.MsgHandler", "doOauthAuthorize!");
        String str = (String) iVar.ozE.get("scope");
        if (bg.mA(str)) {
            w.e("MicroMsg.MsgHandler", "scope is null!");
            a(iVar, "authorize:fail", null);
            aVar.Tn();
            return true;
        }
        String VD;
        try {
            VD = this.rXh.VD();
        } catch (Exception e) {
            w.e("MicroMsg.MsgHandler", "exception in get currentUrl %s", new Object[]{e.getMessage()});
            VD = null;
        }
        VD = bg.mz(this.skF.JZ(VD));
        if (bg.mA(VD)) {
            w.e("MicroMsg.MsgHandler", "appId is null!");
            a(iVar, "authorize:fail", null);
            aVar.Tn();
            return false;
        }
        LinkedList linkedList = new LinkedList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                linkedList.add(jSONArray.optString(i));
            }
            ap.vd().a(new com.tencent.mm.r.a.a(VD, linkedList, new com.tencent.mm.r.a.a.a<com.tencent.mm.r.a.a>(this) {
                final /* synthetic */ g sll;

                public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
                    com.tencent.mm.r.a.a aVar = (com.tencent.mm.r.a.a) kVar;
                    w.i("MicroMsg.MsgHandler", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    if (i != 0 || i2 != 0) {
                        this.sll.a(iVar, "authorize:fail", null);
                        aVar.Tn();
                    } else if (aVar instanceof com.tencent.mm.r.a.a) {
                        final ahc uD = aVar.uD();
                        int i3 = uD.tLL.fIz;
                        String str2 = uD.tLL.fIA;
                        w.i("MicroMsg.MsgHandler", "NetSceneJSAuthorize jsErrcode %d", new Object[]{Integer.valueOf(i3)});
                        if (i3 == -12000) {
                            com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                                final /* synthetic */ AnonymousClass109 smC;

                                public final void run() {
                                    LinkedList linkedList = uD.tBL;
                                    String str = uD.muS;
                                    String str2 = uD.tee;
                                    com.tencent.mm.plugin.webview.ui.tools.widget.e eVar = new com.tencent.mm.plugin.webview.ui.tools.widget.e(this.smC.sll.context);
                                    com.tencent.mm.plugin.webview.ui.tools.widget.e.a anonymousClass1 = new com.tencent.mm.plugin.webview.ui.tools.widget.e.a(this) {
                                        final /* synthetic */ AnonymousClass1 smD;

                                        {
                                            this.smD = r1;
                                        }

                                        public final void c(int i, Bundle bundle) {
                                            w.i("MicroMsg.MsgHandler", "stev onRevMsg resultCode %d", new Object[]{Integer.valueOf(i)});
                                            switch (i) {
                                                case 1:
                                                case 2:
                                                    g gVar = this.smD.smC.sll;
                                                    String str = VD;
                                                    i iVar = iVar;
                                                    a aVar = aVar;
                                                    ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
                                                    LinkedList linkedList = new LinkedList();
                                                    Iterator it = arrayList.iterator();
                                                    while (it.hasNext()) {
                                                        linkedList.add((String) it.next());
                                                    }
                                                    ap.vd().a(new com.tencent.mm.r.a.b(str, linkedList, 0, i, new AnonymousClass108(gVar, iVar, aVar, i)), 0);
                                                    if (i == 2) {
                                                        this.smD.smC.sll.a(iVar, "authorize:fail auth deny", null);
                                                        aVar.Tn();
                                                        return;
                                                    }
                                                    return;
                                                default:
                                                    w.d("MicroMsg.MsgHandler", "press back button!");
                                                    this.smD.smC.sll.a(iVar, "authorize:fail auth cancel", null);
                                                    aVar.Tn();
                                                    return;
                                            }
                                        }
                                    };
                                    if (linkedList == null || linkedList.size() <= 0) {
                                        w.e("MicroMsg.MsgHandler", "scopeInfoList is empty!");
                                        this.smC.sll.a(iVar, "authorize:fail", null);
                                        aVar.Tn();
                                    } else if (!eVar.a(linkedList, str, str2, anonymousClass1)) {
                                        aVar.Tn();
                                    }
                                }
                            });
                        } else if (i3 == 0) {
                            this.sll.a(iVar, "authorize:ok", null);
                            aVar.Tn();
                        } else {
                            w.e("MicroMsg.MsgHandler", "onSceneEnd NetSceneJSAuthorize ERROR %s", new Object[]{str2});
                            this.sll.a(iVar, "authorize:fail", null);
                            aVar.Tn();
                        }
                    }
                }
            }), 0);
            return true;
        } catch (Exception e2) {
            w.e("MicroMsg.MsgHandler", "Exception %s", new Object[]{e2.getMessage()});
            a(iVar, "authorize:fail", null);
            return true;
        }
    }

    public final void dy(int i, int i2) {
        String str = "";
        String str2 = " ";
        try {
            Bundle d = this.rXh.d(77, null);
            if (d != null) {
                str = d.getString("KUrl");
                if (TextUtils.isEmpty(str)) {
                    w.e("MicroMsg.MsgHandler", "url is empty");
                    return;
                }
                w.i("MicroMsg.MsgHandler", "sessionId %s", new Object[]{bg.mz(d.getString("KSessionId"))});
                if (!d.getBoolean("KReportPage", false)) {
                    w.i("MicroMsg.MsgHandler", "not enable report page event control bytes");
                    return;
                }
            }
        } catch (Exception e) {
            w.e("MicroMsg.MsgHandler", "get sessionId error, %s", new Object[]{e});
        }
        if (TextUtils.isEmpty(pH(str))) {
            w.i("MicroMsg.MsgHandler", "appId is null or empty");
            return;
        }
        w.i("MicroMsg.MsgHandler", "appId %s", new Object[]{pH(str)});
        w.i("MicroMsg.MsgHandler", "type %d", new Object[]{Integer.valueOf(this.fNK.mediaObject.type())});
        if (this.fNK.mediaObject.type() == 5) {
            long Ny = bg.Ny();
            w.d("MicroMsg.MsgHandler", "report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13377), Long.valueOf(Ny), r3, str, str2, Integer.valueOf(i), Integer.valueOf(i2)});
            String str3 = "";
            try {
                str = URLEncoder.encode(bg.mz(str), "UTF-8");
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
                str = str3;
            }
            com.tencent.mm.plugin.report.service.g.oUh.i(13377, new Object[]{Long.valueOf(Ny), r3, str, str2, Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    public final void a(int i, int i2, Intent intent) {
        w.i("MicroMsg.MsgHandler", "mmOnActivityResult, requestCode = " + i + ", resultCode = " + i2);
        String str;
        SnsAdClick snsAdClick;
        String string;
        Object obj;
        f Cl;
        String str2;
        final String str3;
        String str4;
        String str5;
        String bzz;
        int i3;
        final String str6;
        final String str7;
        final String str8;
        final String str9;
        if (i == 1) {
            if (this.fNK == null) {
                w.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, appmsg is null");
                a(this.skt, "send_app_msg:fail", null);
                return;
            }
            str = (String) this.skt.ozE.get("appid");
            snsAdClick = null;
            if (this.skw != null) {
                snsAdClick = (SnsAdClick) this.skw.getParcelable("KSnsAdTag");
                if (TextUtils.isEmpty(str)) {
                    string = this.skw.getString("jsapi_args_appid");
                    obj = this.skt.bzT().get("Internal@AsyncReport");
                    this.skt.ozE.get("link");
                    switch (i2) {
                        case -1:
                            if (snsAdClick != null) {
                                snsAdClick.gy(7);
                            }
                            Cl = com.tencent.mm.pluginsdk.model.app.g.Cl(string);
                            if (intent != null) {
                                str2 = null;
                            } else {
                                str2 = intent.getStringExtra("Select_Conv_User");
                            }
                            if (str2 != null || str2.length() == 0) {
                                w.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, toUser is null");
                                a(this.skt, "send_app_msg:fail", null);
                                return;
                            }
                            str3 = (String) this.skt.ozE.get("img_url");
                            this.skt.ozE.get("desc");
                            str4 = (String) this.skt.ozE.get("src_username");
                            str5 = (String) this.skt.ozE.get("src_displayname");
                            bzz = bzz();
                            k.a(this.skt.bzT(), Kg(GameJsApiSendAppMessage.NAME), str2, string);
                            if (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                                e(this.skt, true);
                            }
                            String[] split = str2.split(",");
                            int i4 = 0;
                            int i5 = 0;
                            int length = split.length;
                            int i6 = 0;
                            while (i6 < length) {
                                if (split[i6].endsWith("@chatroom")) {
                                    i3 = i4 + 1;
                                    i4 = i5;
                                } else {
                                    int i7 = i4;
                                    i4 = i5 + 1;
                                    i3 = i7;
                                }
                                i6++;
                                i5 = i4;
                                i4 = i3;
                            }
                            final Map hashMap = new HashMap();
                            if (this.skt.ozE.get("share_callback_with_scene") != null && ((Boolean) this.skt.ozE.get("share_callback_with_scene")).booleanValue()) {
                                hashMap.put("groupCount", Integer.valueOf(i4));
                                hashMap.put("singleCount", Integer.valueOf(i5));
                            }
                            if (bg.mA(bzz)) {
                                a(Cl, string, str2, str3, str4, str5, intent == null ? null : intent.getStringExtra("custom_send_text"), bzz);
                                if (this.context != null) {
                                    com.tencent.mm.ui.base.g.bi(this.context, this.context.getResources().getString(R.l.dIG));
                                }
                                dy(1, 1);
                                a(this.skt, "send_app_msg:ok", hashMap);
                                return;
                            } else if (bg.mA(str3)) {
                                a(Cl, string, str2, str3, str4, str5, null, bzz);
                                com.tencent.mm.ui.base.g.bi(this.context, this.context.getString(R.l.dIy));
                                a(this.skt, "send_app_msg:ok", hashMap);
                                return;
                            } else {
                                final ProgressDialog a = com.tencent.mm.ui.base.g.a(this.context, this.context.getResources().getString(R.l.dIB), true, new OnCancelListener(this) {
                                    final /* synthetic */ g sll;

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        com.tencent.mm.ah.n.GR().jm(str3);
                                        this.sll.a(this.sll.skt, "send_app_msg:cancel", null);
                                    }
                                });
                                final f fVar = Cl;
                                final String str10 = string;
                                final String str11 = str2;
                                str6 = str3;
                                str7 = str4;
                                str8 = str5;
                                str9 = bzz;
                                com.tencent.mm.ah.n.GR().a(str3, new com.tencent.mm.ah.b.c(this) {
                                    final /* synthetic */ g sll;

                                    public final void l(Bitmap bitmap) {
                                        if (a != null) {
                                            a.dismiss();
                                        }
                                        this.sll.a(fVar, str10, str11, str6, str7, str8, null, str9);
                                        if (this.sll.context != null) {
                                            com.tencent.mm.ui.base.g.bl(this.sll.context, this.sll.context.getString(R.l.dIy));
                                        }
                                        this.sll.a(this.sll.skt, "send_app_msg:ok", hashMap);
                                    }
                                });
                                return;
                            }
                        case 0:
                            if (snsAdClick != null) {
                                snsAdClick.gy(8);
                            }
                            k.a(this.skt.bzT(), Kg(GameJsApiSendAppMessage.NAME), null, string);
                            if (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                                e(this.skt, true);
                            }
                            dy(1, 3);
                            a(this.skt, "send_app_msg:cancel", null);
                            return;
                        default:
                            return;
                    }
                }
            }
            string = str;
            obj = this.skt.bzT().get("Internal@AsyncReport");
            this.skt.ozE.get("link");
            switch (i2) {
                case -1:
                    if (snsAdClick != null) {
                        snsAdClick.gy(7);
                    }
                    Cl = com.tencent.mm.pluginsdk.model.app.g.Cl(string);
                    if (intent != null) {
                        str2 = intent.getStringExtra("Select_Conv_User");
                    } else {
                        str2 = null;
                    }
                    if (str2 != null) {
                        break;
                    }
                    w.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, toUser is null");
                    a(this.skt, "send_app_msg:fail", null);
                    return;
                case 0:
                    if (snsAdClick != null) {
                        snsAdClick.gy(8);
                    }
                    k.a(this.skt.bzT(), Kg(GameJsApiSendAppMessage.NAME), null, string);
                    e(this.skt, true);
                    dy(1, 3);
                    a(this.skt, "send_app_msg:cancel", null);
                    return;
                default:
                    return;
            }
        } else if (i == 2) {
            switch (i2) {
                case -1:
                    com.tencent.mm.ui.base.g.bi(this.context, this.context.getResources().getString(R.l.dIG));
                    a(this.skt, "share_weibo:ok", null);
                    return;
                case 0:
                    a(this.skt, "share_weibo:cancel", null);
                    return;
                case 1:
                    a(this.skt, "share_weibo:fail_" + intent.getIntExtra("err_code", 0), null);
                    return;
                default:
                    a(this.skt, "share_weibo:fail_" + intent.getIntExtra("err_code", 0), null);
                    w.e("MicroMsg.MsgHandler", "unknown resultCode");
                    return;
            }
        } else if (i == 3) {
            w.i("MicroMsg.MsgHandler", "get callback address, result code = %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1 && intent != null) {
                str = bg.ap(intent.getStringExtra("nationalCode"), "");
                r3 = bg.ap(intent.getStringExtra("userName"), "");
                string = bg.ap(intent.getStringExtra("telNumber"), "");
                str2 = bg.ap(intent.getStringExtra("addressPostalCode"), "");
                str3 = bg.ap(intent.getStringExtra("proviceFirstStageName"), "");
                str4 = bg.ap(intent.getStringExtra("addressCitySecondStageName"), "");
                str5 = bg.ap(intent.getStringExtra("addressCountiesThirdStageName"), "");
                r9 = bg.ap(intent.getStringExtra("addressDetailInfo"), "");
                w.i("MicroMsg.MsgHandler", "first =  " + str3 + " ; detail =" + r9 + "; second = " + str4 + " ; tel = " + string + "; third = " + str5);
                if (!bg.mA(r3)) {
                    Map hashMap2 = new HashMap();
                    hashMap2.put("nationalCode", str);
                    hashMap2.put("userName", r3);
                    hashMap2.put("telNumber", string);
                    hashMap2.put("addressPostalCode", str2);
                    hashMap2.put("proviceFirstStageName", str3);
                    hashMap2.put("addressCitySecondStageName", str4);
                    hashMap2.put("addressCountiesThirdStageName", str5);
                    hashMap2.put("addressDetailInfo", r9);
                    a(this.skt, "edit_address:ok", hashMap2);
                    return;
                }
            }
            if (i2 == 0) {
                a(this.skt, "edit_address:cancel", null);
            } else {
                a(this.skt, "edit_address:fail", null);
            }
        } else if (i == 4) {
            w.i("MicroMsg.MsgHandler", "request pay, resultCode = " + i2);
            if (this.skK != -1) {
                w.d("MicroMsg.MsgHandler", "hy: has blocked ");
                this.skt = wD(this.skK).skt;
                this.rXh = wD(this.skK).rXh;
                this.skK = -1;
            }
            if (i2 == -1) {
                a(this.skt, "get_brand_wcpay_request:ok", null);
            } else if (i2 == 5) {
                r2 = new HashMap();
                r3 = intent.getIntExtra("key_jsapi_pay_err_code", 0);
                string = bg.mz(intent.getStringExtra("key_jsapi_pay_err_msg"));
                r2.put("err_code", Integer.valueOf(r3));
                r2.put("err_desc", string);
                w.e("MicroMsg.MsgHandler", "hy: pay jsapi failed. errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(r3), string});
                a(this.skt, "get_brand_wcpay_request:fail", r2);
            } else {
                a(this.skt, "get_brand_wcpay_request:cancel", null);
            }
        } else if (i == 27) {
            w.i("MicroMsg.MsgHandler", "request ibg prepay request, resultCode = " + i2);
            if (this.skK != -1) {
                w.d("MicroMsg.MsgHandler", "hy: has blocked ");
                this.skt = wD(this.skK).skt;
                this.rXh = wD(this.skK).rXh;
                this.skK = -1;
            }
            if (i2 == -1) {
                if (intent != null) {
                    if (intent.hasExtra(SlookSmartClipMetaTag.TAG_TYPE_URL)) {
                        str = null;
                        if (intent.hasExtra("view_port_code")) {
                            str = intent.getStringExtra("view_port_code");
                        }
                        try {
                            this.rXh.dR(intent.getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL), str);
                        } catch (RemoteException e) {
                        }
                    }
                }
                a(this.skt, "get_h5_prepay_request:ok", null);
                return;
            }
            a(this.skt, "get_h5_prepay_request:cancel", null);
        } else if (i == 5) {
            w.i("MicroMsg.MsgHandler", "request jump to mall, resultCode = " + i2);
            if (i2 == -1) {
                a(this.skt, "jump_wcmall:ok", null);
            } else {
                a(this.skt, "jump_wcmall:fail", null);
            }
        } else if (i == 6) {
            w.i("MicroMsg.MsgHandler", "request jump to product view, resultCode = " + i2);
            if (i2 == -1) {
                a(this.skt, "open_product_view:ok", null);
            } else {
                a(this.skt, "open_product_view:fail", null);
            }
        } else if (i == 7) {
            w.i("MicroMsg.MsgHandler", "request bind card, resultCode = " + i2);
            if (i2 == -1) {
                a(this.skt, "get_brand_wcpay_bind_card_request:ok", null);
            } else {
                a(this.skt, "get_brand_wcpay_bind_card_request:fail", null);
            }
        } else if (i == 9) {
            w.i("MicroMsg.MsgHandler", "request open wxcredit, resultCode = " + i2);
            if (i2 == -1) {
                a(this.skt, "get_wcpay_create_credit_card_request:ok", null);
            } else {
                a(this.skt, "get_wcpay_create_credit_card_request:fail", null);
            }
        } else if (i == 8) {
            w.i("MicroMsg.MsgHandler", "request jumpToBizProfile, resultCode = " + i2);
            switch (i2) {
                case -1:
                    a(this.skt, "jump_to_biz_profile:ok", null);
                    return;
                case 0:
                    a(this.skt, "jump_to_biz_profile:cancel", null);
                    return;
                case 2:
                case 3:
                    a(this.skt, "jump_to_biz_profile:check_fail", null);
                    return;
                default:
                    a(this.skt, "jump_to_biz_profile:fail", null);
                    w.e("MicroMsg.MsgHandler", "unknown resultCode");
                    return;
            }
        } else if (i == 10) {
            if (i2 == 0) {
                w.i("MicroMsg.MsgHandler", "open scan product ui back");
                a(this.skt, "open_scan_product_view:ok", null);
            }
        } else if (i == 11) {
            w.i("MicroMsg.MsgHandler", "request transfer_money, resultCode = " + i2);
            if (i2 == -1) {
                a(this.skt, "get_transfer_money_request:ok", null);
            } else {
                a(this.skt, "get_transfer_money_request:fail", null);
            }
        } else if (i == 17) {
            w.i("MicroMsg.MsgHandler", "request open_wcpay_specific_view, resultCode = " + i2);
            if (i2 == -1) {
                a(this.skt, "open_wcpay_specific_view:ok", null);
            } else {
                a(this.skt, "open_wcpay_specific_view:fail", null);
            }
        } else if (i == 18) {
            w.i("MicroMsg.MsgHandler", "request request_wcpay_send_c2c_msg, resultCode = " + i2);
            if (i2 == -1) {
                a(this.skt, "get_send_c2c_message_request:ok", null);
            } else if (i2 == 0) {
                a(this.skt, "get_send_c2c_message_request:cancel", null);
            } else {
                a(this.skt, "get_send_c2c_message_request:fail", null);
            }
        } else if (i == 13) {
            w.d("MicroMsg.MsgHandler", "request choose card, resultCode = " + i2);
            r2 = new HashMap();
            if (i2 == -1) {
                if (intent != null) {
                    r2.put("choose_card_info", bg.ap(intent.getStringExtra("choose_card_info"), ""));
                }
                a(this.skt, "choose_card:ok", r2);
            } else if (i2 == 0) {
                a(this.skt, "choose_card:cancel", r2);
            } else {
                a(this.skt, "choose_card:fail", r2);
            }
        } else if (i == 36) {
            w.d("MicroMsg.MsgHandler", "request choose invoice, resultCode = " + i2);
            r2 = new HashMap();
            if (i2 == -1) {
                if (intent != null) {
                    r2.put("choose_invoice_info", bg.ap(intent.getStringExtra("choose_invoice_info"), ""));
                }
                a(this.skt, "choose_invoice:ok", r2);
            } else if (i2 == 0) {
                a(this.skt, "choose_invoice:cancel", r2);
            } else {
                a(this.skt, "choose_invoice:fail", r2);
            }
        } else if (i == 16) {
            w.d("MicroMsg.MsgHandler", "request batch add card, resultCode = " + i2);
            r3 = new HashMap();
            if (intent != null) {
                r3.put("card_list", bg.ap(intent.getStringExtra("card_list"), ""));
            }
            if (i2 == -1) {
                a(this.skt, "batch_add_card:ok", r3);
                return;
            }
            i3 = 2;
            if (intent != null) {
                i3 = intent.getIntExtra("result_code", 2);
            }
            if (i3 == 2) {
                a(this.skt, "batch_add_card:fail", r3);
            } else {
                a(this.skt, "batch_add_card:cancel", r3);
            }
        } else if (i == 23) {
            if (i2 == -1) {
                a(this.skt, "batch_view_card:ok", null);
            } else {
                a(this.skt, "batch_view_card:fail", null);
            }
        } else if (i == 15) {
            if (this.skt == null || bg.mA(this.skt.smN)) {
                w.e("MicroMsg.MsgHandler", "msg is null");
                return;
            }
            w.i("MicroMsg.MsgHandler", "request to scan qr code, result code = %d, function is %s", new Object[]{Integer.valueOf(i2), this.skt.smN});
            if (this.skt.smN.equals("scanQRCode")) {
                switch (i2) {
                    case -1:
                        r2 = new HashMap();
                        if (intent != null) {
                            r2.put("resultStr", intent.getStringExtra("key_scan_result"));
                        }
                        a(this.skt, "scanQRCode:ok", r2);
                        return;
                    case 0:
                        a(this.skt, "scanQRCode:cancel", null);
                        return;
                    default:
                        a(this.skt, "scanQRCode:fail", null);
                        return;
                }
            }
        } else if (i == 14) {
            w.i("MicroMsg.MsgHandler", "request to open file chooser, result code = %d, hasShowMemoryWarning = %b", new Object[]{Integer.valueOf(i2), Boolean.valueOf(intent == null ? false : intent.getBooleanExtra("key_pick_local_media_show_memory_warning", false))});
            r3 = new HashMap();
            if (intent == null ? false : intent.getBooleanExtra("key_pick_local_media_show_memory_warning", false)) {
                r3.put("memoryWarning", Boolean.valueOf(true));
            }
            switch (i2) {
                case -1:
                    str = intent.getStringExtra("key_pick_local_pic_callback_local_ids");
                    w.i("MicroMsg.MsgHandler", "localIds = %s", new Object[]{str});
                    if (!bg.mA(str)) {
                        r3.put("localIds", str);
                        str = intent.getStringExtra("key_pick_local_pic_source_type");
                        if (str != null) {
                            r3.put("sourceType", str);
                        }
                        a(this.skt, "chooseImage:ok", r3);
                        return;
                    }
                    break;
                case 0:
                    a(this.skt, "chooseImage:cancel", r3);
                    return;
            }
            a(this.skt, "chooseImage:fail", r3);
        } else if (i == 32) {
            switch (i2) {
                case -1:
                    r3 = intent.getStringExtra("key_pick_local_media_local_id");
                    if (!bg.mA(r3)) {
                        r2 = com.tencent.mm.plugin.webview.d.f.bwZ().IS(r3);
                        if (r2 != null && (r2 instanceof WebViewJSSDKVideoItem)) {
                            r2 = (WebViewJSSDKVideoItem) r2;
                            Map hashMap3 = new HashMap();
                            hashMap3.put("localId", r3);
                            hashMap3.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(r2.duration));
                            hashMap3.put("height", Integer.valueOf(r2.height));
                            hashMap3.put("size", Integer.valueOf(r2.size));
                            hashMap3.put("width", Integer.valueOf(r2.width));
                            a(this.skt, "chooseVideo:ok", hashMap3);
                            return;
                        }
                    }
                    a(this.skt, "chooseVideo:fail", null);
                    return;
                case 0:
                    a(this.skt, "chooseVideo:cancel", null);
                    return;
                default:
                    a(this.skt, "chooseVideo:fail", null);
                    return;
            }
        } else if (i == 45) {
            switch (i2) {
                case -1:
                    r3 = intent.getStringExtra("key_pick_local_media_local_id");
                    string = intent.getStringExtra("key_pick_local_media_thumb_local_id");
                    w.i("MicroMsg.MsgHandler", "localId:%s", new Object[]{r3});
                    w.i("MicroMsg.MsgHandler", "thumbLocalId:%s", new Object[]{string});
                    if (!bg.mA(r3)) {
                        r2 = com.tencent.mm.plugin.webview.d.f.bwZ().IS(r3);
                        if (r2 != null && (r2 instanceof WebViewJSSDKVideoItem)) {
                            r2 = (WebViewJSSDKVideoItem) r2;
                            Map hashMap4 = new HashMap();
                            hashMap4.put("localId", r3);
                            hashMap4.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(r2.duration));
                            hashMap4.put("height", Integer.valueOf(r2.height));
                            hashMap4.put("size", Integer.valueOf(r2.size));
                            hashMap4.put("width", Integer.valueOf(r2.width));
                            hashMap4.put("thumbLocalId", string);
                            a(this.skt, "recordVideo:ok", hashMap4);
                            return;
                        }
                    }
                    a(this.skt, "recordVideo:fail", null);
                    return;
                case 0:
                    a(this.skt, "recordVideo:cancel", null);
                    return;
                default:
                    a(this.skt, "recordVideo:fail", null);
                    return;
            }
        } else if (i == 47) {
            switch (i2) {
                case -1:
                    if (intent == null) {
                        w.e("MicroMsg.MsgHandler", "mmOnActivityResult REQUEST_CHOOSE_MEDIA data is null,");
                        a(this.skt, "chooseMedia:fail", null);
                        return;
                    }
                    i3 = intent.getIntExtra("key_pick_local_media_callback_type", 0);
                    if (i3 == 1) {
                        str = intent.getStringExtra("key_pick_local_media_local_id");
                        r3 = intent.getStringExtra("key_pick_local_media_thumb_local_id");
                        w.i("MicroMsg.MsgHandler", "video localId:%s", new Object[]{str});
                        w.i("MicroMsg.MsgHandler", "video thumbLocalId:%s", new Object[]{r3});
                        if (bg.mA(str)) {
                            w.e("MicroMsg.MsgHandler", "mmOnActivityResult REQUEST_CHOOSE_MEDIA video localId is null");
                            a(this.skt, "chooseMedia:fail", null);
                            return;
                        }
                        WebViewJSSDKFileItem IS = com.tencent.mm.plugin.webview.d.f.bwZ().IS(str);
                        if (IS == null || !(IS instanceof WebViewJSSDKVideoItem)) {
                            w.e("MicroMsg.MsgHandler", "mmOnActivityResult REQUEST_CHOOSE_MEDIA nor the videoitem");
                            a(this.skt, "chooseMedia:fail", null);
                            return;
                        }
                        WebViewJSSDKVideoItem webViewJSSDKVideoItem = (WebViewJSSDKVideoItem) IS;
                        w.i("MicroMsg.MsgHandler", "after parse to json data : %s", new Object[]{ah.a(str, r3, webViewJSSDKVideoItem.duration, webViewJSSDKVideoItem.height, webViewJSSDKVideoItem.width, webViewJSSDKVideoItem.size)});
                        r3 = new HashMap();
                        r3.put(Columns.TYPE, Integer.valueOf(1));
                        r3.put("localIds", str);
                        a(this.skt, "chooseMedia:ok", r3);
                        return;
                    } else if (i3 == 2) {
                        str = intent.getStringExtra("key_pick_local_media_local_ids");
                        w.i("MicroMsg.MsgHandler", "chooseMedia localIds:%s", new Object[]{str});
                        if (bg.mA(str)) {
                            w.e("MicroMsg.MsgHandler", "mmOnActivityResult REQUEST_CHOOSE_MEDIA image localIds is null");
                            a(this.skt, "chooseMedia:fail", null);
                            return;
                        }
                        r3 = new HashMap();
                        r3.put(Columns.TYPE, Integer.valueOf(2));
                        r3.put("localIds", str);
                        a(this.skt, "chooseMedia:ok", r3);
                        return;
                    } else {
                        w.e("MicroMsg.MsgHandler", "type:%d is error", new Object[]{Integer.valueOf(i3)});
                        a(this.skt, "chooseMedia:fail", null);
                        return;
                    }
                case 0:
                    a(this.skt, "chooseMedia:cancel", null);
                    return;
                default:
                    a(this.skt, "chooseMedia:fail", null);
                    return;
            }
        } else if (i == 46) {
            switch (i2) {
                case -1:
                    a(this.skt, "previewVideo:ok", null);
                    return;
                case 0:
                    a(this.skt, "previewVideo:cancel", null);
                    return;
                default:
                    a(this.skt, "previewVideo:fail", null);
                    return;
            }
        } else if (i == 19) {
            w.i("MicroMsg.MsgHandler", "request to config exdevice wifi connection, result code = " + i2);
            switch (i2) {
                case -1:
                    a(this.skt, "configWXDeviceWiFi:ok", null);
                    return;
                case 0:
                    r2 = null;
                    if (intent != null) {
                        if (!intent.getBooleanExtra("is_wifi_connected", true)) {
                            r2 = new HashMap();
                            r2.put("desc", "wifi_not_connected");
                        }
                    }
                    a(this.skt, "configWXDeviceWiFi:cancel", r2);
                    return;
                case 1:
                    a(this.skt, "configWXDeviceWiFi:fail", null);
                    return;
                default:
                    return;
            }
        } else if (i == 20) {
            w.i("MicroMsg.MsgHandler", "request request_verify_wcpay_password, resultCode = " + i2);
            r3 = new HashMap();
            if (i2 == -1) {
                CharSequence charSequence = "";
                if (intent != null) {
                    charSequence = bg.ap(intent.getStringExtra("token"), "");
                }
                if (TextUtils.isEmpty(charSequence)) {
                    w.i("MicroMsg.MsgHandler", "checkPwdToken is empty, verifyWCPayPassword:fail");
                    a(this.skt, "verifyWCPayPassword:fail", null);
                    return;
                }
                r3.put("token", charSequence);
                a(this.skt, "verifyWCPayPassword:ok", r3);
                w.i("MicroMsg.MsgHandler", "checkPwdToken is valid, verifyWCPayPassword:ok");
                return;
            }
            w.i("MicroMsg.MsgHandler", "resultCode is canlcel, verifyWCPayPassword:fail");
            a(this.skt, "verifyWCPayPassword:fail", null);
        } else if (21 == i) {
            w.d("MicroMsg.MsgHandler", "hy: callback to see order. directly finish");
            a(this.skt, "see_order_ok", null);
        } else if (i == 22) {
            w.i("MicroMsg.MsgHandler", "request get_recevie_biz_hongbao_request, resultCode = " + i2);
            if (i2 == -1) {
                a(this.skt, "get_recevie_biz_hongbao_request:ok", null);
            } else {
                a(this.skt, "get_recevie_biz_hongbao_request:fail", null);
            }
        } else if (i == 24) {
            if (i2 == -1) {
                dy(2, 1);
                try {
                    if (this.rXh != null) {
                        str = (String) this.skt.ozE.get("appId");
                        if (TextUtils.isEmpty(str)) {
                            r3 = (String) this.skt.ozE.get("appid");
                        } else {
                            r3 = str;
                        }
                        a(r3, (String) this.skt.ozE.get("img_url"), 1, this.rXh.d(85, null));
                    }
                } catch (RemoteException e2) {
                    w.e("MicroMsg.MsgHandler", "invokeAsResult : %s", new Object[]{e2});
                }
                a(this.skt, "share_timeline:ok", null);
                return;
            }
            dy(2, 3);
            a(this.skt, "share_timeline:cancel", null);
        } else if (i == 26) {
            w.d("MicroMsg.MsgHandler", "select pedometer source resultCode = " + i2);
            if (i2 == -1) {
                a(this.skt, "selectPedometerSource:ok", null);
            } else if (i2 == 0) {
                w.i("MicroMsg.MsgHandler", "selectPedometerSource result cancel");
                a(this.skt, "selectPedometerSource:cancel", null);
            } else {
                w.e("MicroMsg.MsgHandler", "selectPedometerSource result fail");
                a(this.skt, "selectPedometerSource:fail", null);
            }
        } else if (i == 25) {
            w.i("MicroMsg.MsgHandler", "hy: get ibg order finish. result code: %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1) {
                a(this.skt, "get_h5_transaction_request:ok", null);
            } else {
                a(this.skt, "get_h5_transaction_request:cancel", null);
            }
        } else if (i == 28) {
            w.i("MicroMsg.MsgHandler", "get web pay checkout counter request finish. result code: %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1) {
                r2 = new HashMap();
                r3 = bg.ap(intent.getStringExtra("token"), "");
                string = bg.ap(intent.getStringExtra("bind_serial"), "");
                r2.put("token", r3);
                r2.put("bind_serial", string);
                a(this.skt, "getWebPayCheckoutCounterRequst:ok", r2);
                return;
            }
            a(this.skt, "getWebPayCheckoutCounterRequst:fail", null);
        } else if (i == 31) {
            if (i2 != -1) {
                a(this.skt, "openEnterpriseContact:ok", null);
                return;
            }
            r2 = intent.getBundleExtra("result_data");
            if (r2 != null) {
                str = r2.getString("result");
                r3 = new HashMap();
                r3.put("result", str);
                a(this.skt, "openEnterpriseContact:ok", r3);
                return;
            }
            a(this.skt, "openEnterpriseContact:ok", null);
        } else if (i == 53) {
            if (i2 != -1) {
                a(this.skt, "selectEnterpriseContact:ok", null);
                return;
            }
            r2 = intent.getBundleExtra("result_data");
            if (r2 != null) {
                str = r2.getString("result");
                r3 = new HashMap();
                r3.put("result", str);
                a(this.skt, "selectEnterpriseContact:ok", r3);
                return;
            }
            a(this.skt, "selectEnterpriseContact:ok", null);
        } else if (i == 29) {
            r3 = "MicroMsg.MsgHandler";
            string = "consumedShareCard:ok(r : %b)";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(i2 == -1);
            w.d(r3, string, objArr);
            if (i2 == -1) {
                a(this.skt, "consumedShareCard:ok", null);
            } else {
                a(this.skt, "consumedShareCard:fail", null);
            }
        } else if (i == 113) {
            if (i2 == -1) {
                aK(this.skt);
            } else {
                a(this.skt, "chooseImage:fail_android_permission_denied", null);
            }
        } else if (i == 116) {
            if (i2 == -1) {
                aV(this.skt);
            } else {
                a(this.skt, "startRecord:fail_android_permission_denied", null);
            }
        } else if (i == 115) {
            if (i2 == -1) {
                a(this.skt, 0);
            } else {
                a(this.skt, "chooseVideo:fail_android_permission_denied", null);
            }
        } else if (i == 117) {
            if (i2 == -1) {
                a(this.skt, 1);
            } else {
                a(this.skt, "recordVideo:fail_android_permission_denied", null);
            }
        } else if (i == 118) {
            if (i2 == -1) {
                a(this.skt, 1);
            } else {
                a(this.skt, "recordVideo:fail_android_permission_denied", null);
            }
        } else if (i == 119) {
            if (i2 == -1) {
                aR(this.skt);
                return;
            }
            w.e("MicroMsg.MsgHandler", "chooseMedia:fail_android_permission_denied:CAMERA");
            a(this.skt, "chooseMedia:fail_android_permission_denied", null);
        } else if (i == 120) {
            if (i2 == -1) {
                aR(this.skt);
                return;
            }
            w.e("MicroMsg.MsgHandler", "chooseMedia:fail_android_permission_denied:MICROPHONE");
            a(this.skt, "chooseMedia:fail_android_permission_denied", null);
        } else if (i == 30) {
            w.i("MicroMsg.MsgHandler", "doSelectSingleContact activtiy callback");
            str = (String) this.skt.ozE.get("appId");
            if (this.skw == null || !TextUtils.isEmpty(str)) {
                r3 = str;
            } else {
                r3 = this.skw.getString("jsapi_args_appid");
            }
            int i8 = bg.getInt((String) this.skt.ozE.get("selectMode"), 0);
            w.i("MicroMsg.MsgHandler", "select single contact : appId:%s, busiId:%s, selectedMode:%d", new Object[]{r3, (String) this.skt.ozE.get("busiId"), Integer.valueOf(i8)});
            switch (i2) {
                case -1:
                    if (intent == null) {
                        string = null;
                    } else {
                        string = intent.getStringExtra("Select_Conv_User");
                    }
                    if (string == null || string.length() == 0) {
                        w.e("MicroMsg.MsgHandler", "mmOnActivityResult,selectSingleContact fail, user is null");
                        a(this.skt, "selectSingleContact:fail", null);
                        return;
                    } else if (i8 == 0) {
                        final k kVar = new com.tencent.mm.plugin.webview.model.k(r3, string);
                        ap.vd().a(1566, new e(this) {
                            final /* synthetic */ g sll;

                            {
                                this.sll = r1;
                            }

                            public final void a(int i, int i2, String str, k kVar) {
                                if (this.sll.isv != null && this.sll.isv.isShowing()) {
                                    this.sll.isv.dismiss();
                                    this.sll.isv = null;
                                }
                                ap.vd().b(1566, this);
                                if (i == 0 && i2 == 0) {
                                    int i3;
                                    w.i("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Cgi_PayIBGGetUserOpenId success");
                                    com.tencent.mm.plugin.webview.model.k kVar2 = (com.tencent.mm.plugin.webview.model.k) kVar;
                                    agr com_tencent_mm_protocal_c_agr = kVar2.gUA == null ? null : (agr) kVar2.gUA.hsk.hsr;
                                    Object obj = this.sll.skt.ozE.get("result_sign_type");
                                    if (obj != null) {
                                        i3 = bg.getInt((String) obj, 0);
                                    } else {
                                        i3 = 0;
                                    }
                                    Map hashMap = new HashMap();
                                    hashMap.put("package", com_tencent_mm_protocal_c_agr.trg);
                                    hashMap.put("sign", com_tencent_mm_protocal_c_agr.trh);
                                    if (i3 == 1) {
                                        hashMap.put("signType", com_tencent_mm_protocal_c_agr.tri);
                                    }
                                    hashMap.put("timestamp", com_tencent_mm_protocal_c_agr.tju);
                                    hashMap.put("noncestr", com_tencent_mm_protocal_c_agr.trf);
                                    w.d("MicroMsg.MsgHandler", "select single contact : package:%s, sign:%s", new Object[]{com_tencent_mm_protocal_c_agr.trg, com_tencent_mm_protocal_c_agr.trh});
                                    this.sll.a(this.sll.skt, "selectSingleContact:ok", hashMap);
                                    return;
                                }
                                w.e("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Cgi_PayIBGGetUserOpenId fail");
                                this.sll.a(this.sll.skt, "selectSingleContact:fail", null);
                            }
                        });
                        ap.vd().d(kVar);
                        Context context = this.context;
                        this.context.getString(R.l.dIO);
                        this.isv = com.tencent.mm.ui.base.g.a(context, this.context.getString(R.l.dJd), true, new OnCancelListener(this) {
                            final /* synthetic */ g sll;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ap.vd().c(kVar);
                            }
                        });
                        return;
                    } else if (i8 == 1) {
                        final k qVar = new com.tencent.mm.plugin.webview.model.q(r3, str, string);
                        ap.vd().a(1177, new e(this) {
                            final /* synthetic */ g sll;

                            {
                                this.sll = r1;
                            }

                            public final void a(int i, int i2, String str, k kVar) {
                                if (this.sll.isv != null && this.sll.isv.isShowing()) {
                                    this.sll.isv.dismiss();
                                    this.sll.isv = null;
                                }
                                ap.vd().b(1177, this);
                                if (i == 0 && i2 == 0) {
                                    w.i("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Biz_Jsapi_Getuseropendid success");
                                    com.tencent.mm.plugin.webview.model.q qVar = (com.tencent.mm.plugin.webview.model.q) kVar;
                                    Map hashMap = new HashMap();
                                    hashMap.put("package", qVar.rWH);
                                    hashMap.put("sign", qVar.sign);
                                    hashMap.put("headImgUrl", qVar.rWI);
                                    hashMap.put("nickName", qVar.rWJ);
                                    hashMap.put("friendRelation", Integer.valueOf(qVar.rWK));
                                    w.d("MicroMsg.MsgHandler", "select single contact : opnid:%s, sign:%s, nick_name:%s, friend_relation:%d", new Object[]{qVar.rWH, qVar.sign, qVar.rWJ, Integer.valueOf(qVar.rWK)});
                                    this.sll.a(this.sll.skt, "selectSingleContact:ok", hashMap);
                                    return;
                                }
                                w.e("MicroMsg.MsgHandler", "mmOnActivityResult, MMFunc_Biz_Jsapi_Getuseropendid fail");
                                this.sll.a(this.sll.skt, "selectSingleContact:fail", null);
                            }
                        });
                        ap.vd().d(qVar);
                        Context context2 = this.context;
                        this.context.getString(R.l.dIO);
                        this.isv = com.tencent.mm.ui.base.g.a(context2, this.context.getString(R.l.dJd), true, new OnCancelListener(this) {
                            final /* synthetic */ g sll;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ap.vd().c(qVar);
                            }
                        });
                        return;
                    } else {
                        return;
                    }
                case 0:
                    a(this.skt, "selectSingleContact:cancel", null);
                    return;
                default:
                    return;
            }
        } else if (i == 34) {
            if (i2 == -1) {
                a(this.skt, "get_wcpay_realname_verify:ok", null);
            } else if (i2 == 1) {
                a(this.skt, "get_wcpay_realname_verify:fail", null);
            } else {
                a(this.skt, "get_wcpay_realname_verify:cancel", null);
            }
        } else if (i == 35) {
            if (i2 == -1) {
                com.tencent.mm.sdk.b.b mqVar = new mq();
                mqVar.fTW.context = this.context;
                com.tencent.mm.sdk.b.a.urY.m(mqVar);
                try {
                    this.rXh.bxl();
                    this.rXh.M(null);
                    return;
                } catch (Throwable e3) {
                    w.printErrStackTrace("MicroMsg.MsgHandler", e3, "", new Object[0]);
                    return;
                }
            }
            a(this.skt, "selectWalletCurrency:cancel", null);
        } else if (i == 37) {
            if (this.fNK == null) {
                w.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, appmsg is null");
                a(this.skt, "send_app_msg:fail", null);
                return;
            }
            final long longExtra;
            str = (String) this.skt.ozE.get("appid");
            snsAdClick = null;
            if (this.skw != null) {
                snsAdClick = (SnsAdClick) this.skw.getParcelable("KSnsAdTag");
                if (TextUtils.isEmpty(str)) {
                    string = this.skw.getString("jsapi_args_appid");
                    obj = this.skt.bzT().get("Internal@AsyncReport");
                    switch (i2) {
                        case -1:
                            if (snsAdClick != null) {
                                snsAdClick.gy(7);
                            }
                            Cl = com.tencent.mm.pluginsdk.model.app.g.Cl(string);
                            if (intent != null) {
                                str2 = intent.getStringExtra("enterprise_biz_name");
                                longExtra = intent.getLongExtra("key_biz_chat_id", -1);
                                r9 = intent.getStringExtra("enterprise_share_append_text");
                                if (str2 != null || str2.length() == 0) {
                                    w.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, toUser is null");
                                    a(this.skt, "send_app_msg:fail", null);
                                    return;
                                }
                                str3 = (String) this.skt.ozE.get("img_url");
                                this.skt.ozE.get("desc");
                                str4 = (String) this.skt.ozE.get("src_username");
                                str5 = (String) this.skt.ozE.get("src_displayname");
                                bzz = bzz();
                                k.a(this.skt.bzT(), Kg(GameJsApiSendAppMessage.NAME), str2, string);
                                if (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                                    e(this.skt, true);
                                }
                                if (bg.mA(str3)) {
                                    if (longExtra >= 0) {
                                        com.tencent.mm.modelbiz.a.c aa = com.tencent.mm.modelbiz.w.DJ().aa(longExtra);
                                        synchronized (com.tencent.mm.modelbiz.a.e.hwS) {
                                            String zz = com.tencent.mm.modelbiz.a.e.zz();
                                            com.tencent.mm.modelbiz.a.e.d(aa);
                                            a(Cl, string, str2, str3, str4, str5, r9, bzz);
                                            com.tencent.mm.modelbiz.a.e.ix(zz);
                                        }
                                    } else {
                                        a(Cl, string, str2, str3, str4, str5, r9, bzz);
                                    }
                                    com.tencent.mm.ui.base.g.bi(this.context, this.context.getString(R.l.dXl));
                                    a(this.skt, "send_app_msg:ok", null);
                                    return;
                                }
                                final f fVar2 = Cl;
                                str6 = string;
                                str7 = str2;
                                str8 = str3;
                                str9 = str4;
                                final String str12 = str5;
                                final String str13 = r9;
                                final String str14 = bzz;
                                com.tencent.mm.ah.n.GR().a(str3, new com.tencent.mm.ah.b.c(this) {
                                    final /* synthetic */ g sll;

                                    public final void l(Bitmap bitmap) {
                                        if (this.sll.mSZ != null) {
                                            this.sll.mSZ.dismiss();
                                        }
                                        if (longExtra >= 0) {
                                            com.tencent.mm.modelbiz.a.c aa = com.tencent.mm.modelbiz.w.DJ().aa(longExtra);
                                            synchronized (com.tencent.mm.modelbiz.a.e.hwS) {
                                                String zz = com.tencent.mm.modelbiz.a.e.zz();
                                                com.tencent.mm.modelbiz.a.e.d(aa);
                                                this.sll.a(fVar2, str6, str7, str8, str9, str12, str13, str14);
                                                com.tencent.mm.modelbiz.a.e.ix(zz);
                                            }
                                        } else {
                                            this.sll.a(fVar2, str6, str7, str8, str9, str12, str13, str14);
                                        }
                                        if (this.sll.context != null) {
                                            com.tencent.mm.ui.base.g.bl(this.sll.context, this.sll.context.getString(R.l.dXl));
                                        }
                                        this.sll.a(this.sll.skt, "send_app_msg:ok", null);
                                    }
                                });
                                return;
                            }
                            return;
                        case 0:
                            if (snsAdClick != null) {
                                snsAdClick.gy(8);
                            }
                            k.a(this.skt.bzT(), Kg(GameJsApiSendAppMessage.NAME), null, string);
                            if (obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                                e(this.skt, true);
                            }
                            a(this.skt, "send_app_msg:cancel", null);
                            return;
                        default:
                            return;
                    }
                }
            }
            string = str;
            obj = this.skt.bzT().get("Internal@AsyncReport");
            switch (i2) {
                case -1:
                    if (snsAdClick != null) {
                        snsAdClick.gy(7);
                    }
                    Cl = com.tencent.mm.pluginsdk.model.app.g.Cl(string);
                    if (intent != null) {
                        str2 = intent.getStringExtra("enterprise_biz_name");
                        longExtra = intent.getLongExtra("key_biz_chat_id", -1);
                        r9 = intent.getStringExtra("enterprise_share_append_text");
                        if (str2 != null) {
                            break;
                        }
                        w.e("MicroMsg.MsgHandler", "mmOnActivityResult fail, toUser is null");
                        a(this.skt, "send_app_msg:fail", null);
                        return;
                    }
                    return;
                case 0:
                    if (snsAdClick != null) {
                        snsAdClick.gy(8);
                    }
                    k.a(this.skt.bzT(), Kg(GameJsApiSendAppMessage.NAME), null, string);
                    e(this.skt, true);
                    a(this.skt, "send_app_msg:cancel", null);
                    return;
                default:
                    return;
            }
        } else if (i == 38) {
            if (i2 == -1) {
                w.i("MicroMsg.MsgHandler", "hy: soter auth ok");
                a(this.skt, "soter_biometric_authentication:ok", i.W(intent.getExtras()));
            } else if (i2 == 1) {
                w.w("MicroMsg.MsgHandler", "hy: soter auth failed");
                a(this.skt, "soter_biometric_authentication:fail", i.W(intent.getExtras()));
            } else {
                w.e("MicroMsg.MsgHandler", "hy: soter user cancelled");
                a(this.skt, "soter_biometric_authentication:cancel", i.W(intent.getExtras()));
            }
        } else if (i == 39) {
            if (i2 == -1) {
                a(this.skt, "unbind_bank_card:ok", null);
            } else if (i2 == 1) {
                a(this.skt, "unbind_bank_card:fail", null);
            } else {
                a(this.skt, "unbind_bank_card:cancel", null);
            }
        } else if (i == 40) {
            if (i2 == -1) {
                r4 = new Bundle();
                if (intent != null) {
                    ArrayList b = com.tencent.mm.av.a.b(intent.getLongArrayExtra("k_outside_expose_proof_item_list"));
                    int size = b.size();
                    String[] strArr = new String[size];
                    String[] strArr2 = new String[size];
                    String[] strArr3 = new String[size];
                    int[] iArr = new int[size];
                    int[] iArr2 = new int[size];
                    for (r3 = 0; r3 < size; r3++) {
                        au auVar = (au) b.get(r3);
                        strArr[r3] = String.valueOf(auVar.pI());
                        if (intent.getBooleanExtra("k_is_group_chat", false)) {
                            strArr2[r3] = com.tencent.mm.u.ay.gj(auVar.pM());
                            strArr3[r3] = com.tencent.mm.u.ay.gi(auVar.pM());
                        } else {
                            strArr2[r3] = auVar.pM();
                            strArr3[r3] = auVar.pL();
                        }
                        if (auVar.pJ() == 1) {
                            strArr3[r3] = m.xL();
                        }
                        if (strArr2[r3] == null) {
                            strArr2[r3] = "";
                        }
                        if (strArr3[r3] == null) {
                            strArr3[r3] = "";
                        }
                        if (auVar.axO()) {
                            iArr[r3] = 49;
                        } else {
                            iArr[r3] = auVar.getType();
                        }
                        iArr2[r3] = (int) (auVar.pK() / 1000);
                    }
                    r4.putStringArray("msgIds", strArr);
                    r4.putStringArray("contents", strArr2);
                    r4.putStringArray("senders", strArr3);
                    r4.putIntArray("msgTypes", iArr);
                    r4.putIntArray("msgTimes", iArr2);
                    try {
                        if (this.rXh != null) {
                            this.rXh.m(48, r4);
                        }
                        a(this.skt, "select chat record:ok", null);
                        return;
                    } catch (RemoteException e22) {
                        w.w("MicroMsg.MsgHandler", "onGetMsgProofItems exception" + e22.getMessage());
                        a(this.skt, "select chat record:fail", null);
                        return;
                    }
                }
                a(this.skt, "select chat record:fail", null);
                return;
            }
            a(this.skt, "select chat record:cancel", null);
        } else if (i == 41) {
            if (i2 == -1) {
                a(this.skt, "id_card_realname_verify:ok", null);
            } else if (i2 == 1) {
                a(this.skt, "id_card_realname_verify:fail", null);
            } else {
                a(this.skt, "id_card_realname_verify:cancel", null);
            }
        } else if (i == 42) {
            if (i2 == -1) {
                if (intent != null) {
                    str = bg.ap(intent.getStringExtra("gameRegionName"), "");
                    r3 = new HashMap();
                    r3.put("gameRegionName", str);
                    a(this.skt, "get game region:ok", r3);
                    return;
                }
                a(this.skt, "get game region:fail", null);
            } else if (i2 == 1) {
                a(this.skt, "get game region:fail", null);
            } else {
                a(this.skt, "get game region:cancel", null);
            }
        } else if (i == 43) {
            w.i("MicroMsg.MsgHandler", "request to open file chooser for id card image, result code = " + i2);
            switch (i2) {
                case -1:
                    r2 = new HashMap();
                    r3 = intent.getStringExtra("key_pick_local_pic_callback_local_ids");
                    w.i("MicroMsg.MsgHandler", "localIds = %s", new Object[]{r3});
                    if (bg.mA(r3)) {
                        a(this.skt, "chooseIdCard:fail", null);
                        return;
                    }
                    try {
                        JSONArray jSONArray = new JSONArray(r3);
                        if (jSONArray.length() > 0) {
                            r2.put("localId", jSONArray.get(0).toString());
                            if (intent.getStringExtra("key_pick_local_pic_source_type") != null) {
                                r2.put("sourceType", FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
                            }
                            a(this.skt, "chooseIdCard:ok", r2);
                            return;
                        }
                        a(this.skt, "chooseImage:fail", null);
                        return;
                    } catch (Throwable e32) {
                        w.printErrStackTrace("MicroMsg.MsgHandler", e32, "", new Object[0]);
                        a(this.skt, "chooseImage:fail", null);
                        return;
                    }
                case 0:
                    a(this.skt, "chooseIdCard:cancel", null);
                    return;
                default:
                    a(this.skt, "chooseImage:fail", null);
                    return;
            }
        } else if (i == 48) {
            w.i("MicroMsg.MsgHandler", "alvinluo: requestWxFacePictureVerify resultCode: %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1) {
                a(this.skt, "requestWxFacePictureVerify:ok", i.W(intent != null ? intent.getExtras() : null));
            } else if (i2 == 1) {
                a(this.skt, "requestWxFacePictureVerify:fail", i.W(intent != null ? intent.getExtras() : null));
            } else if (i2 == 0) {
                a(this.skt, "requestWxFacePictureVerify:cancel", i.W(intent != null ? intent.getExtras() : null));
            }
        } else if (i == 49) {
            w.i("MicroMsg.MsgHandler", "hy: REQUEST_FACE_DETECT_WITH_VIDEO resultCode: %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1) {
                a(this.skt, "requestWxFacePictureVerifyUnionVideo:ok", i.W(intent != null ? intent.getExtras() : null));
            } else if (i2 == 1) {
                a(this.skt, "requestWxFacePictureVerifyUnionVideo:fail", i.W(intent != null ? intent.getExtras() : null));
            } else if (i2 == 0) {
                a(this.skt, "requestWxFacePictureVerifyUnionVideo:cancel", i.W(intent != null ? intent.getExtras() : null));
            }
        } else if (i == 52) {
            w.i("MicroMsg.MsgHandler", "share emmotion resultCode: %d", new Object[]{Integer.valueOf(i2)});
            switch (i2) {
                case -1:
                    com.tencent.mm.storage.a.c r;
                    string = bg.ap(intent.getStringExtra("Select_Conv_User"), "");
                    r3 = bg.ap(intent.getStringExtra("emoji_thumb_path"), "");
                    str2 = bg.ap(intent.getStringExtra("emoji_activity_id"), "");
                    com.tencent.mm.storage.a.c Si = com.tencent.mm.plugin.emoji.model.h.amc().abK().Si(r3);
                    if (Si == null) {
                        ap.yY();
                        str3 = EmojiLogic.D(com.tencent.mm.u.c.xi(), "", r3);
                        if (com.tencent.mm.a.e.aO(str3)) {
                            i3 = com.tencent.mm.sdk.platformtools.o.Pj(str3) ? com.tencent.mm.storage.a.c.uLa : com.tencent.mm.storage.a.c.uKZ;
                            com.tencent.mm.storage.a.c cVar = new com.tencent.mm.storage.a.c();
                            cVar.iY(r3);
                            cVar.yJ(com.tencent.mm.storage.a.c.uKT);
                            cVar.setType(i3);
                            cVar.setSize(com.tencent.mm.a.e.aN(str3));
                            cVar.yK(1);
                            if (!bg.mA(str2)) {
                                cVar.field_activityid = str2;
                            }
                            r = com.tencent.mm.plugin.emoji.model.h.amc().abK().r(cVar);
                            for (String str15 : bg.f(bg.ap(string, "").split(","))) {
                                if (r != null) {
                                    com.tencent.mm.plugin.emoji.model.h.alY().a(str15, r, null);
                                }
                            }
                            a(this.skt, "shareEmoticon:ok", null);
                            return;
                        }
                    }
                    r = Si;
                    for (String str152 : bg.f(bg.ap(string, "").split(","))) {
                        if (r != null) {
                            com.tencent.mm.plugin.emoji.model.h.alY().a(str152, r, null);
                        }
                    }
                    a(this.skt, "shareEmoticon:ok", null);
                    return;
                case 0:
                    a(this.skt, "shareEmoticon:cancel", null);
                    return;
                default:
                    a(this.skt, "shareEmoticon:fail", null);
                    return;
            }
        } else if (i == 50) {
            w.i("MicroMsg.MsgHandler", "hy: requestWxFaceRegisterInternal resultCode: %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1) {
                a(this.skt, "requestWxFaceRegisterInternal:ok", i.W(intent != null ? intent.getExtras() : null));
            } else if (i2 == 1) {
                a(this.skt, "requestWxFaceRegisterInternal:fail", i.W(intent != null ? intent.getExtras() : null));
            } else if (i2 == 0) {
                a(this.skt, "requestWxFaceRegisterInternal:cancel", i.W(intent != null ? intent.getExtras() : null));
            }
        } else if (i == 51) {
            w.i("MicroMsg.MsgHandler", "hy: requestWxFaceVerifyInternal resultCode: %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1) {
                a(this.skt, "requestWxFaceVerifyInternal:ok", i.W(intent != null ? intent.getExtras() : null));
            } else if (i2 == 1) {
                a(this.skt, "requestWxFaceVerifyInternal:fail", i.W(intent != null ? intent.getExtras() : null));
            } else if (i2 == 0) {
                a(this.skt, "requestWxFaceVerifyInternal:cancel", i.W(intent != null ? intent.getExtras() : null));
            }
        } else if (i == 54) {
            if (i2 != -1 || intent == null) {
                a(this.skt, "slectContact:fail", null);
                return;
            }
            str152 = intent.getStringExtra("Select_Contact");
            r3 = com.tencent.mm.u.n.eK(str152);
            r4 = new Bundle();
            r4.putString("username", str152);
            r4.putString("nickname", r3);
            r4.putInt("ret", 0);
            try {
                if (this.rXh != null) {
                    this.rXh.m(FileUtils.S_IWUSR, r4);
                }
            } catch (RemoteException e222) {
                w.w("MicroMsg.MsgHandler", "onSearchDataReady exception" + e222.getMessage());
            }
            a(this.skt, "", null);
        } else if (i == 55) {
            w.i("MicroMsg.MsgHandler", "hy: REQUEST_SET_RESET_WALLET_PWD_REQUEST resultCode: %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1) {
                a(this.skt, "setWCPayPassword:ok", i.W(intent != null ? intent.getExtras() : null));
            } else if (i2 == 0) {
                a(this.skt, "setWCPayPassword:cancel", i.W(intent != null ? intent.getExtras() : null));
            } else {
                a(this.skt, "setWCPayPassword:fail", i.W(intent != null ? intent.getExtras() : null));
            }
        } else if (i == 56) {
            w.i("MicroMsg.MsgHandler", "request choose invoice title, resultCode = " + i2);
            r2 = new HashMap();
            if (i2 == -1) {
                if (intent != null) {
                    r2.put("choose_invoice_title_info", bg.ap(intent.getStringExtra("choose_invoice_title_info"), ""));
                }
                a(this.skt, "chooseInvoiceTitle:ok", r2);
            } else if (i2 == 0) {
                a(this.skt, "chooseInvoiceTitle:cancel", r2);
            } else {
                a(this.skt, "chooseInvoiceTitle:fail", r2);
            }
        }
    }

    public final void cz(i iVar) {
        Bundle Y = i.Y(iVar.ozE);
        try {
            this.rXh.bxl();
            this.rXh.M(Y);
        } catch (RemoteException e) {
            w.w("MicroMsg.MsgHandler", "SendServiceAppMsg doCloseWindow, ex = " + e.getMessage());
        }
    }

    public final boolean a(f fVar, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (this.fNK == null) {
            w.w("MicroMsg.MsgHandler", "doSendAppMsg: but appmsg is null");
            return false;
        }
        com.tencent.mm.ah.n.GR();
        Bitmap gS = com.tencent.mm.ah.b.gS(str3);
        if (!(gS == null || gS.isRecycled())) {
            w.i("MicroMsg.MsgHandler", "thumb image is not null");
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            gS.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
            this.fNK.thumbData = byteArrayOutputStream.toByteArray();
        }
        com.tencent.mm.sdk.b.b ntVar = new nt();
        ntVar.fUP.fNK = this.fNK;
        ntVar.fUP.appId = str;
        ntVar.fUP.appName = fVar == null ? "" : fVar.field_appName;
        ntVar.fUP.toUser = str2;
        ntVar.fUP.fUQ = 2;
        if (bg.mA(str4)) {
            ntVar.fUP.fUT = null;
        } else {
            ntVar.fUP.fUR = str4;
            ntVar.fUP.fUS = str5;
        }
        try {
            String string = this.skw.getString("key_snsad_statextstr");
            ntVar.fUP.fUY = string;
            ntVar.fUP.fUU = this.rXh.bxj();
            Bundle d = this.rXh.d(18, null);
            if (d != null) {
                com.tencent.mm.e.a.nt.a aVar = ntVar.fUP;
                String mz = bg.mz(d.getString("KPublisherId"));
                aVar.fUX = mz;
                String fQ = q.fQ(mz);
                com.tencent.mm.u.q.b n = q.yC().n(fQ, true);
                n.l("sendAppMsgScene", Integer.valueOf(2));
                n.l("preChatName", d.getString("preChatName"));
                n.l("preMsgIndex", Integer.valueOf(d.getInt("preMsgIndex")));
                n.l("prePublishId", d.getString("prePublishId"));
                n.l("preUsername", d.getString("preUsername"));
                n.l("getA8KeyScene", Integer.valueOf(d.getInt("getA8KeyScene")));
                n.l("referUrl", d.getString("referUrl"));
                if (!bg.mA(string)) {
                    n.l("adExtStr", string);
                }
                ntVar.fUP.fFF = fQ;
            }
            string = this.rXh.VD();
            ntVar.fUP.fUV = string;
            ntVar.fUP.fUW = this.skF.JZ(string);
        } catch (Exception e) {
            w.e("MicroMsg.MsgHandler", "init bunddata failed : %s", new Object[]{e.getMessage()});
        }
        boolean m = com.tencent.mm.sdk.b.a.urY.m(ntVar);
        if (!bg.mA(str6)) {
            ntVar = new nv();
            ntVar.fVa.fVb = str2;
            ntVar.fVa.content = str6;
            ntVar.fVa.type = o.fG(str2);
            ntVar.fVa.flags = 0;
            com.tencent.mm.sdk.b.a.urY.m(ntVar);
        }
        if (m) {
            try {
                if (this.rXh != null) {
                    a(str, str3, o.dH(str2) ? 2 : 3, this.rXh.d(85, null));
                }
            } catch (RemoteException e2) {
                w.e("MicroMsg.MsgHandler", "invokeAsResult : %s", new Object[]{e2});
            }
        }
        if (bg.mA(str7)) {
            return m;
        }
        com.tencent.mm.plugin.report.service.g.oUh.i(10424, new Object[]{Integer.valueOf(49), Integer.valueOf(FileUtils.S_IWUSR), str7});
        return m;
    }

    private void a(String str, String str2, int i, Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("share_report_pre_msg_url");
            String string2 = bundle.getString("share_report_pre_msg_title");
            String string3 = bundle.getString("share_report_pre_msg_desc");
            String string4 = bundle.getString("share_report_pre_msg_icon_url");
            String string5 = bundle.getString("share_report_pre_msg_appid");
            int i2 = bundle.getInt("share_report_from_scene", 0);
            String string6 = bundle.getString("share_report_biz_username");
            String string7 = bundle.getString("share_report_current_url");
            String string8 = bundle.getString("share_report_current_title");
            String str3 = this.fNK.mediaObject instanceof WXWebpageObject ? ((WXWebpageObject) this.fNK.mediaObject).webpageUrl : "";
            String str4 = this.fNK.title;
            String str5 = this.fNK.description;
            com.tencent.mm.plugin.report.service.g.oUh.i(14062, new Object[]{string, string2, string3, string4, string5, Integer.valueOf(i2), string6, string7, string8, str, str3, str4, str5, str2, Integer.valueOf(i)});
        }
    }

    public final void a(i iVar, String str, Map<String, Object> map) {
        a(iVar, str, (Map) map, true, true);
    }

    public final void a(i iVar, String str, Map<String, Object> map, boolean z, boolean z2) {
        this.lre = false;
        try {
            this.rXh.a(iVar == null ? null : iVar.smL, str, i.Y(map), z);
        } catch (Exception e) {
            w.w("MicroMsg.MsgHandler", "onHandleEnd, ex = " + e.getMessage());
        }
        if (z2) {
            com.tencent.mm.pluginsdk.n.unlock();
        }
    }

    public final void a(com.tencent.mm.plugin.webview.stub.e eVar, i iVar, String str) {
        String str2 = null;
        this.lre = false;
        if (iVar != null) {
            str2 = iVar.smL;
        }
        try {
            eVar.a(str2, str, i.Y(null), true);
        } catch (Exception e) {
            w.w("MicroMsg.MsgHandler", "onHandleEnd, ex = " + e.getMessage());
        }
        com.tencent.mm.pluginsdk.n.unlock();
    }

    public final void a(com.tencent.mm.plugin.webview.stub.e eVar, i iVar, String str, Map<String, Object> map, boolean z, boolean z2) {
        if (!z2) {
            this.lre = false;
        }
        try {
            eVar.a(iVar == null ? null : iVar.smL, str, i.Y(map), z);
        } catch (Exception e) {
            w.w("MicroMsg.MsgHandler", "onHandleEnd, ex = " + e.getMessage());
        }
    }

    public final void e(i iVar, boolean z) {
        if (iVar == null) {
            w.e("MicroMsg.MsgHandler", "msg is null when report.");
            return;
        }
        String str = iVar.smN;
        Map map = iVar.smM;
        map.put("isSuccess", Boolean.valueOf(z));
        com.tencent.mm.plugin.webview.stub.e eVar = this.rXh;
        if (bg.mA(str)) {
            w.e("MicroMsg.WebViewSecurityUtil", "function name is null or nil.");
            return;
        }
        String str2;
        String str3;
        boolean f;
        String mz;
        boolean f2;
        int f3;
        int f4;
        int i = eVar == null ? 1 : 0;
        String str4 = "";
        String str5 = "";
        String str6 = "";
        String str7 = "";
        if (i != 0) {
            try {
                str4 = "";
            } catch (Exception e) {
                w.w("MicroMsg.WebViewSecurityUtil", "report, ex = " + e.getMessage());
                str2 = str5;
                str3 = str4;
            }
        } else {
            str4 = eVar.bxj();
        }
        str6 = i != 0 ? "" : eVar.bxk();
        str2 = i != 0 ? "" : eVar.VD();
        str3 = str4;
        if (map != null) {
            f = bg.f((Boolean) map.get("fromMenu"));
            mz = bg.mz((String) map.get("keyParam"));
            str4 = bg.ap((String) map.get("appId"), "");
            f2 = bg.f((Boolean) map.get("isSuccess"));
            f3 = bg.f((Integer) map.get("permissionValue"));
            f4 = bg.f((Integer) map.get("baseErrorCode"));
            i = bg.f((Integer) map.get("jsapiErrorCode"));
        } else {
            i = 0;
            f2 = false;
            str4 = str7;
            mz = null;
            f = false;
            f4 = 0;
            f3 = 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(URLEncoder.encode(bg.mz(str3)));
        stringBuilder.append(",");
        stringBuilder.append(URLEncoder.encode(bg.mz(str2)));
        stringBuilder.append(",");
        if (str6 == null) {
            str6 = "";
        }
        stringBuilder.append(str6);
        stringBuilder.append(",");
        stringBuilder.append(str == null ? "" : str);
        stringBuilder.append(",");
        stringBuilder.append(f ? "1" : "0");
        stringBuilder.append(",");
        if (mz == null) {
            mz = "";
        }
        stringBuilder.append(mz);
        stringBuilder.append(",");
        stringBuilder.append(str4);
        stringBuilder.append(",");
        stringBuilder.append(f2 ? "1" : "0");
        stringBuilder.append(",");
        stringBuilder.append(f3);
        if (!f2) {
            stringBuilder.append(",");
            stringBuilder.append(0);
            stringBuilder.append(",");
            stringBuilder.append(f4);
            stringBuilder.append(",");
            stringBuilder.append(i);
        }
        String stringBuilder2 = stringBuilder.toString();
        w.d("MicroMsg.WebViewSecurityUtil", "report: " + stringBuilder2);
        com.tencent.mm.plugin.report.service.g.oUh.A(10417, stringBuilder2);
    }

    private int cA(i iVar) {
        int hashCode = iVar.hashCode();
        this.sle.put(Integer.valueOf(hashCode), new c(this, iVar, this.rXh));
        this.lre = false;
        try {
            this.rXh.bxm();
        } catch (RemoteException e) {
            w.w("MicroMsg.MsgHandler", "blockMsg, dealNext ex = %s", new Object[]{e.getMessage()});
        }
        return hashCode;
    }

    public final c wD(int i) {
        return (c) this.sle.get(Integer.valueOf(i));
    }

    public final void wE(int i) {
        c cVar = (c) this.sle.remove(Integer.valueOf(i));
        if (cVar != null) {
            cVar.skt = null;
            cVar.rXh = null;
        }
    }

    public final boolean cB(i iVar) {
        this.lre = false;
        return com.tencent.mm.plugin.webview.d.f.bwV().R(iVar.ozE);
    }

    public final boolean cC(i iVar) {
        this.lre = false;
        return com.tencent.mm.plugin.webview.d.f.bwW().L(iVar.ozE);
    }

    public final boolean cD(i iVar) {
        this.lre = false;
        return com.tencent.mm.plugin.webview.d.f.bwU().N(iVar.ozE);
    }

    public final boolean cE(i iVar) {
        this.lre = false;
        return com.tencent.mm.plugin.webview.d.f.bwU().O(iVar.ozE);
    }

    public final boolean cF(i iVar) {
        this.lre = false;
        return com.tencent.mm.plugin.webview.d.f.bwU().P(iVar.ozE);
    }

    public final boolean cG(i iVar) {
        Map hashMap = new HashMap();
        com.tencent.mm.plugin.webview.d.f.bwV();
        com.tencent.mm.plugin.webview.c.d.b(iVar.ozE, hashMap);
        a(iVar, "getSearchDisplayName:ok", hashMap);
        return true;
    }

    public final boolean cH(i iVar) {
        this.lre = false;
        return com.tencent.mm.plugin.webview.d.f.bwV().a(iVar.ozE, this);
    }

    public final boolean cI(i iVar) {
        this.lre = false;
        com.tencent.mm.plugin.webview.c.d bwV = com.tencent.mm.plugin.webview.d.f.bwV();
        Map map = iVar.ozE;
        boolean q = com.tencent.mm.plugin.webview.c.e.q(map, "hasResult");
        String o = com.tencent.mm.plugin.webview.c.e.o(map, "query");
        int c = com.tencent.mm.plugin.webview.c.e.c(map, Columns.TYPE, 0);
        int c2 = com.tencent.mm.plugin.webview.c.e.c(map, "scene", 0);
        w.d("MicroMsg.FTS.FTSWebViewLogic", "searchDataHashResult %b %s %d", new Object[]{Boolean.valueOf(q), o, Integer.valueOf(c)});
        com.tencent.mm.plugin.webview.c.d.e eVar = bwV.rVV;
        if (eVar.scene == c2 && eVar.fRM != null && eVar.fRM.equals(o) && eVar.mde == c) {
            eVar.fDw = q;
        } else {
            w.w("MicroMsg.FTS.FTSWebViewLogic", "setHahResultNotSame: %s VS %s | %d VS %d | %d VS %d", new Object[]{eVar.fRM, o, Integer.valueOf(eVar.mde), Integer.valueOf(c), Integer.valueOf(eVar.scene), Integer.valueOf(c2)});
        }
        return false;
    }

    public final boolean cJ(i iVar) {
        this.lre = false;
        return com.tencent.mm.plugin.webview.d.f.bwW().M(iVar.ozE);
    }

    public final boolean cK(i iVar) {
        this.lre = false;
        return com.tencent.mm.plugin.webview.d.f.bwV().Q(iVar.ozE);
    }

    public final boolean cL(i iVar) {
        boolean z = true;
        this.lre = false;
        com.tencent.mm.plugin.webview.d.f.bwV();
        Map map = iVar.ozE;
        w.i("MicroMsg.FTS.FTSWebViewLogic", "openEmotionPage %s", new Object[]{map});
        int c = com.tencent.mm.plugin.webview.c.e.c(map, Columns.TYPE, 0);
        int c2 = com.tencent.mm.plugin.webview.c.e.c(map, "scene", 0);
        String o = com.tencent.mm.plugin.webview.c.e.o(map, "searchId");
        String o2 = com.tencent.mm.plugin.webview.c.e.o(map, "activityId");
        String str = "";
        Intent intent = new Intent();
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.putExtra("extra_scence", c2);
        intent.putExtra("extra_type", c);
        intent.putExtra("searchID", o);
        intent.putExtra("docID", com.tencent.mm.plugin.webview.c.e.o(map, "docID"));
        intent.putExtra("activityId", o2);
        switch (c) {
            case 1:
                intent.putExtra("extra_id", com.tencent.mm.plugin.webview.c.e.o(map, "productID"));
                intent.putExtra("preceding_scence", 18);
                intent.putExtra("download_entrance_scene", 27);
                intent.putExtra("searchID", bg.getLong(o, 0));
                str = ".ui.EmojiStoreDetailUI";
                break;
            case 2:
                intent.putExtra("extra_emoji_name", com.tencent.mm.plugin.webview.c.e.o(map, "express"));
                intent.putExtra("extra_md5", com.tencent.mm.plugin.webview.c.e.o(map, "md5"));
                intent.putExtra("extra_aeskey", com.tencent.mm.plugin.webview.c.e.o(map, "aesKey"));
                intent.putExtra("extra_encrypt_url", com.tencent.mm.plugin.webview.c.e.o(map, "encryptUrl"));
                intent.putExtra("extra_thumb_url", com.tencent.mm.plugin.webview.c.e.o(map, "thumb"));
                intent.putExtra(SlookAirButtonFrequentContactAdapter.ID, com.tencent.mm.plugin.webview.c.e.o(map, "designerId"));
                intent.putExtra("extra_product_id", com.tencent.mm.plugin.webview.c.e.o(map, "productID"));
                intent.putExtra("productUrl", com.tencent.mm.plugin.webview.c.e.o(map, "productUrl"));
                intent.putExtra("extra_product_name", com.tencent.mm.plugin.webview.c.e.o(map, "productName"));
                intent.putExtra("weapp_user_name", com.tencent.mm.plugin.webview.c.e.o(map, "weappUserName"));
                intent.putExtra("weapp_version", com.tencent.mm.plugin.webview.c.e.c(map, "weappVersion", 0));
                intent.putExtra("source_type", com.tencent.mm.plugin.webview.c.e.c(map, "sourceType", 0));
                str = ".ui.fts.FTSEmojiDetailPageUI";
                break;
            case 3:
                intent.putExtra("extra_emoji_name", com.tencent.mm.plugin.webview.c.e.o(map, "express"));
                intent.putExtra("extra_md5", com.tencent.mm.plugin.webview.c.e.o(map, "md5"));
                intent.putExtra("extra_aeskey", com.tencent.mm.plugin.webview.c.e.o(map, "aesKey"));
                intent.putExtra("extra_encrypt_url", com.tencent.mm.plugin.webview.c.e.o(map, "encryptUrl"));
                intent.putExtra("extra_thumb_url", com.tencent.mm.plugin.webview.c.e.o(map, "thumb"));
                intent.putExtra(SlookAirButtonFrequentContactAdapter.ID, com.tencent.mm.plugin.webview.c.e.o(map, "designerId"));
                intent.putExtra("name", com.tencent.mm.plugin.webview.c.e.o(map, "designerName"));
                intent.putExtra("headurl", com.tencent.mm.plugin.webview.c.e.o(map, "designerThumb"));
                intent.putExtra("weapp_user_name", com.tencent.mm.plugin.webview.c.e.o(map, "weappUserName"));
                intent.putExtra("weapp_version", com.tencent.mm.plugin.webview.c.e.c(map, "weappVersion", 0));
                intent.putExtra("source_type", com.tencent.mm.plugin.webview.c.e.c(map, "sourceType", 0));
                str = ".ui.fts.FTSEmojiDetailPageUI";
                break;
            case 4:
                intent.putExtra("extra_emoji_name", com.tencent.mm.plugin.webview.c.e.o(map, "express"));
                intent.putExtra("extra_encrypt_url", com.tencent.mm.plugin.webview.c.e.o(map, "encryptUrl"));
                intent.putExtra("extra_thumb_url", com.tencent.mm.plugin.webview.c.e.o(map, "thumb"));
                intent.putExtra("extra_article_name", com.tencent.mm.plugin.webview.c.e.o(map, "sourceTitle"));
                intent.putExtra("extra_article_url", com.tencent.mm.plugin.webview.c.e.o(map, "articleSource"));
                intent.putExtra("disableAddSticker", com.tencent.mm.plugin.webview.c.e.c(map, "disableAddSticker", 0) > 0);
                str = "needSavePhotosAlbum";
                if (com.tencent.mm.plugin.webview.c.e.c(map, "needSavePhotosAlbum", 0) <= 0) {
                    z = false;
                }
                intent.putExtra(str, z);
                intent.putExtra("weapp_user_name", com.tencent.mm.plugin.webview.c.e.o(map, "weappUserName"));
                intent.putExtra("weapp_version", com.tencent.mm.plugin.webview.c.e.c(map, "weappVersion", 0));
                intent.putExtra("source_type", com.tencent.mm.plugin.webview.c.e.c(map, "sourceType", 0));
                str = ".ui.fts.FTSEmojiDetailPageUI";
                break;
        }
        if (!bg.mA(str)) {
            com.tencent.mm.bb.d.b(ab.getContext(), "emoji", str, intent);
        }
        return false;
    }

    public final boolean cM(i iVar) {
        this.lre = false;
        com.tencent.mm.plugin.webview.d.f.bwV();
        return com.tencent.mm.plugin.webview.c.d.U(iVar.ozE);
    }

    public final boolean cN(i iVar) {
        this.lre = false;
        String str = (String) iVar.ozE.get("brandUsername");
        Intent Il = com.tencent.mm.as.d.Il();
        Il.putExtra("ftsneedkeyboard", true);
        Il.putExtra("ftsbizscene", 19);
        Il.putExtra("ftsType", 2);
        Map a = com.tencent.mm.as.d.a(19, true, 2);
        a.put("userName", str);
        Il.putExtra("rawUrl", com.tencent.mm.as.d.m(a));
        Il.putExtra("key_load_js_without_delay", true);
        Il.putExtra("ftsbizusername", str);
        com.tencent.mm.bb.d.b(ab.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", Il);
        return false;
    }

    public final boolean cO(i iVar) {
        this.lre = false;
        Bundle bundle = new Bundle();
        bundle.putString("widgetId", (String) iVar.ozE.get("widgetId"));
        try {
            if (this.rXh != null) {
                this.rXh.m(100001, bundle);
            }
        } catch (RemoteException e) {
            w.w("MicroMsg.MsgHandler", "doOpenSearchWAWidgetLogView exception" + e.getMessage());
        }
        a(iVar, "openSearchWAWidgetLogView:ok", null);
        return true;
    }

    public final boolean cP(i iVar) {
        this.lre = false;
        this.slf++;
        String str = ((String) iVar.ozE.get("appid")) + "_" + this.slf;
        JSONObject jSONObject = new JSONObject(iVar.ozE);
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", jSONObject.toString());
        bundle.putString("fts_key_widget_view_cache_key", str);
        try {
            if (this.rXh != null) {
                this.rXh.m(60, bundle);
            }
        } catch (RemoteException e) {
            w.w("MicroMsg.MsgHandler", "onSearchDataReady exception" + e.getMessage());
        }
        Map hashMap = new HashMap();
        hashMap.put("widgetId", str);
        a(iVar, "insertSearchWAWidgetView:ok", hashMap);
        return true;
    }

    public final boolean cQ(i iVar) {
        this.lre = false;
        JSONObject jSONObject = new JSONObject(iVar.ozE);
        String str = (String) iVar.ozE.get("widgetId");
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", jSONObject.toString());
        bundle.putString("fts_key_widget_view_cache_key", str);
        try {
            if (this.rXh != null) {
                this.rXh.m(61, bundle);
            }
        } catch (RemoteException e) {
            w.w("MicroMsg.MsgHandler", "onSearchDataReady exception" + e.getMessage());
        }
        Map hashMap = new HashMap();
        hashMap.put("widgetId", str);
        a(iVar, "removeSearchWAWidgetView:ok", hashMap);
        return true;
    }

    public final boolean cR(i iVar) {
        this.lre = false;
        JSONObject jSONObject = new JSONObject(iVar.ozE);
        String str = (String) iVar.ozE.get("widgetId");
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", jSONObject.toString());
        bundle.putString("fts_key_widget_view_cache_key", str);
        try {
            if (this.rXh != null) {
                this.rXh.m(62, bundle);
            }
        } catch (RemoteException e) {
            w.w("MicroMsg.MsgHandler", "onSearchDataReady exception" + e.getMessage());
        }
        Map hashMap = new HashMap();
        hashMap.put("widgetId", str);
        a(iVar, "updateSearchWAWidgetView:ok", hashMap);
        return true;
    }

    public final boolean cS(i iVar) {
        this.lre = false;
        com.tencent.mm.sdk.b.b prVar = new pr();
        prVar.fWB.context = this.context;
        prVar.fWB.userName = com.tencent.mm.plugin.webview.c.e.o(iVar.ozE, "userName");
        prVar.fWB.appId = com.tencent.mm.plugin.webview.c.e.o(iVar.ozE, "appId");
        prVar.fWB.fWD = com.tencent.mm.plugin.webview.c.e.o(iVar.ozE, "relativeURL");
        prVar.fWB.fWF = com.tencent.mm.plugin.webview.c.e.c(iVar.ozE, "appVersion", 0);
        prVar.fWB.scene = com.tencent.mm.plugin.webview.c.e.c(iVar.ozE, "scene", 1018);
        prVar.fWB.fCN = com.tencent.mm.plugin.webview.c.e.o(iVar.ozE, "sceneNote");
        if (bg.mA(prVar.fWB.fCN)) {
            prVar.fWB.fCN = com.tencent.mm.compatible.util.p.encode(bg.mz(VD()));
        }
        prVar.fWB.fKS = com.tencent.mm.plugin.webview.c.e.o(iVar.ozE, "downloadURL");
        prVar.fWB.fWE = com.tencent.mm.plugin.webview.c.e.c(iVar.ozE, "openType", 0);
        prVar.fWB.fWG = com.tencent.mm.plugin.webview.c.e.o(iVar.ozE, "checkSumMd5");
        prVar.fWB.fWI = false;
        com.tencent.mm.sdk.b.a.urY.m(prVar);
        if (prVar.fWC.fWN) {
            a(iVar, "openWeApp:ok", null);
        } else {
            a(iVar, "openWeApp:fail:" + bg.mz(prVar.fWC.fWO), null);
        }
        return true;
    }

    public final boolean cT(i iVar) {
        this.lre = false;
        w.i("MicroMsg.MsgHandler", "doOpenWeAppPage %s", new Object[]{iVar.ozE});
        String o = com.tencent.mm.plugin.webview.c.e.o(iVar.ozE, "userName");
        String o2 = com.tencent.mm.plugin.webview.c.e.o(iVar.ozE, "relativeURL");
        int c = com.tencent.mm.plugin.webview.c.e.c(iVar.ozE, "appVersion", 0);
        String o3 = com.tencent.mm.plugin.webview.c.e.o(iVar.ozE, "searchId");
        String o4 = com.tencent.mm.plugin.webview.c.e.o(iVar.ozE, "docId");
        int c2 = com.tencent.mm.plugin.webview.c.e.c(iVar.ozE, "position", 1);
        int c3 = com.tencent.mm.plugin.webview.c.e.c(iVar.ozE, "scene", 1000);
        int c4 = com.tencent.mm.plugin.webview.c.e.c(iVar.ozE, "debugMode", 0);
        if (com.tencent.mm.plugin.webview.d.f.bwW().hPH != null) {
            c4 = 1;
        }
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        if (c3 == bh.CTRL_INDEX) {
            appBrandStatObject.scene = MMBitmapFactory.ERROR_UNSUPPORT_IMAGE_FORMAT;
        } else if (c3 == 3) {
            appBrandStatObject.scene = MMBitmapFactory.ERROR_IO_FAILED;
        } else if (c3 == 16) {
            appBrandStatObject.scene = 1042;
        } else if (c3 == 20) {
            appBrandStatObject.scene = 1053;
        } else {
            appBrandStatObject.scene = 1000;
        }
        String o5 = com.tencent.mm.plugin.webview.c.e.o(iVar.ozE, "statSessionId");
        String o6 = com.tencent.mm.plugin.webview.c.e.o(iVar.ozE, "statKeywordId");
        appBrandStatObject.fCN = o5 + ":" + o6 + ":" + o3 + ":" + o4 + ":" + c2 + ":" + com.tencent.mm.plugin.webview.c.e.o(iVar.ozE, "subScene");
        ((com.tencent.mm.plugin.appbrand.i.c) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.appbrand.i.c.class)).a(this.context, o, c4, c, o2, appBrandStatObject);
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new bmp();
        aVar.hsn = new bmq();
        aVar.uri = "/cgi-bin/mmux-bin/weappsearchadclick";
        aVar.hsl = 1873;
        com.tencent.mm.y.b BE = aVar.BE();
        bmp com_tencent_mm_protocal_c_bmp = (bmp) BE.hsj.hsr;
        com_tencent_mm_protocal_c_bmp.ulZ = com.tencent.mm.plugin.webview.c.e.o(iVar.ozE, "statSessionId");
        com_tencent_mm_protocal_c_bmp.uma = com.tencent.mm.plugin.webview.c.e.o(iVar.ozE, "statKeywordId");
        com_tencent_mm_protocal_c_bmp.tOp = com.tencent.mm.plugin.webview.c.e.o(iVar.ozE, "searchId");
        com_tencent_mm_protocal_c_bmp.tYA = com.tencent.mm.plugin.webview.c.e.o(iVar.ozE, "docId");
        com_tencent_mm_protocal_c_bmp.umb = com.tencent.mm.plugin.webview.c.e.c(iVar.ozE, "position", 1);
        com_tencent_mm_protocal_c_bmp.ohj = com.tencent.mm.plugin.webview.c.e.o(iVar.ozE, "userName");
        com_tencent_mm_protocal_c_bmp.umc = com.tencent.mm.plugin.webview.c.e.c(iVar.ozE, "appVersion", 0);
        com_tencent_mm_protocal_c_bmp.umd = com.tencent.mm.plugin.webview.c.e.o(iVar.ozE, "adBuffer");
        com_tencent_mm_protocal_c_bmp.tdM = c3;
        com_tencent_mm_protocal_c_bmp.ume = com.tencent.mm.plugin.webview.c.e.o(iVar.ozE, "clickExtInfo");
        final com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
        dVar.n("20StatSessionId", com_tencent_mm_protocal_c_bmp.ulZ + ",");
        dVar.n("21KeywordId", com_tencent_mm_protocal_c_bmp.uma + ",");
        dVar.n("22SearchId", com_tencent_mm_protocal_c_bmp.tOp + ",");
        dVar.n("23DocId", com_tencent_mm_protocal_c_bmp.tYA + ",");
        dVar.n("24Pos", com_tencent_mm_protocal_c_bmp.umb + ",");
        dVar.n("25AppUserName", com_tencent_mm_protocal_c_bmp.ohj + ",");
        dVar.n("26AppVersion", com_tencent_mm_protocal_c_bmp.umc + ",");
        dVar.n("27AdBuffer", com_tencent_mm_protocal_c_bmp.umd + ",");
        dVar.n("28AdClickBuffer", com_tencent_mm_protocal_c_bmp.ume + ",");
        dVar.n("29scene", c3 + ",");
        w.i("MicroMsg.MsgHandler", "doClickReportScene oreh" + dVar.JG());
        u.a(BE, new com.tencent.mm.y.u.a(this) {
            final /* synthetic */ g sll;

            public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                w.d("MicroMsg.MsgHandler", "onGYNetEnd oreh errType:%d errCode:%d msg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                if (!(i == 0 && i2 == 0)) {
                    w.i("MicroMsg.MsgHandler", "report oreh logbuffer(13927)");
                    com.tencent.mm.plugin.report.service.g.oUh.i(13927, new Object[]{dVar});
                    com.tencent.mm.plugin.report.service.g.oUh.a(457, 0, 1, false);
                }
                return 0;
            }
        });
        a(iVar, "openWeAppPage:ok", null);
        return true;
    }

    public final boolean cU(i iVar) {
        int c = com.tencent.mm.plugin.webview.c.e.c(iVar.ozE, "logId", 0);
        w.i("MicroMsg.MsgHandler", "doSearchRailtime oreh id:%d, value:%s, params:%s", new Object[]{Integer.valueOf(c), com.tencent.mm.plugin.webview.c.e.o(iVar.ozE, "logString"), iVar.ozE});
        aig com_tencent_mm_protocal_c_aig = new aig();
        com_tencent_mm_protocal_c_aig.tMh = c;
        com_tencent_mm_protocal_c_aig.tMp = (int) (System.currentTimeMillis() / 1000);
        com_tencent_mm_protocal_c_aig.jNd = 1;
        com_tencent_mm_protocal_c_aig.tMi = new com.tencent.mm.bd.b(r1.getBytes());
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new com.tencent.mm.protocal.c.bg();
        aVar.hsn = new com.tencent.mm.protocal.c.bh();
        aVar.uri = "/cgi-bin/mmux-bin/adlog";
        aVar.hsl = 1802;
        com.tencent.mm.y.b BE = aVar.BE();
        com.tencent.mm.protocal.c.bg bgVar = (com.tencent.mm.protocal.c.bg) BE.hsj.hsr;
        aif com_tencent_mm_protocal_c_aif = new aif();
        com_tencent_mm_protocal_c_aif.tlu = com.tencent.mm.protocal.d.sYH;
        com_tencent_mm_protocal_c_aif.tlv = com.tencent.mm.protocal.d.sYG;
        com_tencent_mm_protocal_c_aif.tlw = com.tencent.mm.protocal.d.sYJ;
        com_tencent_mm_protocal_c_aif.tlx = com.tencent.mm.protocal.d.sYK;
        com_tencent_mm_protocal_c_aif.tly = v.bIN();
        com_tencent_mm_protocal_c_aif.tMo = (int) (System.currentTimeMillis() / 1000);
        bgVar.teG = com_tencent_mm_protocal_c_aif;
        bgVar.teH.add(com_tencent_mm_protocal_c_aig);
        u.a(BE, new com.tencent.mm.y.u.a(this) {
            final /* synthetic */ g sll;

            {
                this.sll = r1;
            }

            public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                w.d("MicroMsg.MsgHandler", "onGYNetEnd oreh errType:%d errCode:%d msg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                if (!(i == 0 && i2 == 0)) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(457, 1, 1, false);
                }
                return 0;
            }
        });
        a(iVar, "reportWeAppSearchRealtime:ok", null);
        return true;
    }

    public final boolean cV(i iVar) {
        this.lre = false;
        com.tencent.mm.plugin.webview.c.d bwV = com.tencent.mm.plugin.webview.d.f.bwV();
        Map map = iVar.ozE;
        w.i("MicroMsg.FTS.FTSWebViewLogic", "setSnsObjectDescList");
        String o = com.tencent.mm.plugin.webview.c.e.o(map, SlookAirButtonFrequentContactAdapter.DATA);
        boolean q = com.tencent.mm.plugin.webview.c.e.q(map, "append");
        Runnable aVar = new a(bwV);
        aVar.data = o;
        aVar.rWc = q;
        com.tencent.mm.sdk.f.e.post(aVar, "append_music_list_task");
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean cW(com.tencent.mm.plugin.webview.ui.tools.jsapi.i r13) {
        /*
        r12 = this;
        r11 = 9;
        r10 = 1;
        r9 = 0;
        r12.lre = r9;
        r1 = com.tencent.mm.plugin.webview.d.f.bwV();
        r0 = r13.ozE;
        r2 = "MicroMsg.FTS.FTSWebViewLogic";
        r3 = "clickSnsMusicPlayButton %s";
        r4 = new java.lang.Object[r10];
        r5 = r0.toString();
        r4[r9] = r5;
        com.tencent.mm.sdk.platformtools.w.i(r2, r3, r4);
        r2 = "isLoop";
        r2 = com.tencent.mm.plugin.webview.c.e.q(r0, r2);
        r3 = "needStartMusicUI";
        r3 = com.tencent.mm.plugin.webview.c.e.q(r0, r3);
        r4 = "snsid";
        r4 = com.tencent.mm.plugin.webview.c.e.o(r0, r4);
        r5 = "webview_instance_id";
        r5 = r0.get(r5);
        r6 = -1;
        r5 = com.tencent.mm.sdk.platformtools.bg.n(r5, r6);
        r6 = com.tencent.mm.am.b.HJ();
        if (r6 == 0) goto L_0x005a;
    L_0x0044:
        r6 = com.tencent.mm.am.b.HL();
        r7 = r6.tRH;
        if (r7 != r11) goto L_0x005a;
    L_0x004c:
        r6 = r6.tqY;
        r4 = r6.equals(r4);
        if (r4 == 0) goto L_0x005a;
    L_0x0054:
        com.tencent.mm.am.b.HH();
        if (r3 != 0) goto L_0x005a;
    L_0x0059:
        return r9;
    L_0x005a:
        if (r3 == 0) goto L_0x0079;
    L_0x005c:
        r4 = r1.rVW;
        if (r4 == 0) goto L_0x0079;
    L_0x0060:
        r4 = r1.rVW;
        r6 = new com.tencent.mm.e.a.jb;
        r6.<init>();
        r7 = r6.fOW;
        r8 = 5;
        r7.action = r8;
        r7 = r6.fOW;
        r7.fKC = r4;
        r4 = r6.fOW;
        r4.fPa = r10;
        r4 = com.tencent.mm.sdk.b.a.urY;
        r4.m(r6);
    L_0x0079:
        r4 = "objectXmlDesc";
        r4 = com.tencent.mm.plugin.webview.c.e.o(r0, r4);
        r0 = com.tencent.mm.plugin.sns.b.l.class;
        r0 = com.tencent.mm.kernel.h.h(r0);
        r0 = (com.tencent.mm.plugin.sns.b.l) r0;
        r4 = r0.kL(r4);
        r0 = com.tencent.mm.am.a.a.class;
        r0 = com.tencent.mm.kernel.h.h(r0);
        r0 = (com.tencent.mm.am.a.a) r0;
        com.tencent.mm.u.ap.yY();
        r6 = com.tencent.mm.u.c.xv();
        r0 = r0.a(r6, r4, r11);
        r0.tRZ = r2;
        com.tencent.mm.am.b.a(r0);
        if (r3 == 0) goto L_0x00c4;
    L_0x00a6:
        r0 = new android.content.Intent;
        r0.<init>();
        r2 = "key_scene";
        r3 = 4;
        r0.putExtra(r2, r3);
        r2 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r0.setFlags(r2);
        r2 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r3 = "music";
        r4 = ".ui.MusicMainUI";
        com.tencent.mm.bb.d.b(r2, r3, r4, r0);
    L_0x00c4:
        r0 = r1.rVR;
        r1 = java.lang.Integer.valueOf(r5);
        r0.add(r1);
        goto L_0x0059;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.jsapi.g.cW(com.tencent.mm.plugin.webview.ui.tools.jsapi.i):boolean");
    }

    public final boolean cX(i iVar) {
        this.lre = false;
        com.tencent.mm.plugin.webview.d.f.bwV();
        Map map = iVar.ozE;
        w.i("MicroMsg.FTS.FTSWebViewLogic", "reportSearchStatistics: %s", new Object[]{map.toString()});
        com.tencent.mm.as.i.p(com.tencent.mm.plugin.webview.c.e.c(map, "logId", 0), com.tencent.mm.plugin.webview.c.e.o(map, "logString"));
        return false;
    }

    public final boolean cY(i iVar) {
        this.lre = false;
        return com.tencent.mm.plugin.webview.d.f.bwV().S(iVar.ozE);
    }

    public final boolean cZ(i iVar) {
        String str = (String) iVar.ozE.get("name");
        String str2 = (String) iVar.ozE.get("arg");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", str);
            str = "arg";
            if (bg.mA(str2)) {
                str2 = "{}";
            }
            jSONObject.put(str, new JSONObject(str2));
            Bundle bundle = new Bundle();
            bundle.putString("info", jSONObject.toString());
            this.rXh.d(132, bundle);
            a(iVar, "invokeMiniProgramAPI:ok", null);
        } catch (Exception e) {
            w.e("MicroMsg.MsgHandler", "doInvokeMiniProgramApi: %s", new Object[]{e});
            a(iVar, "invokeMiniProgramAPI:fail", null);
        }
        return true;
    }

    public final void aA(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", str);
        bundle.putBoolean("fts_key_new_query", z);
        try {
            if (this.rXh != null) {
                this.rXh.m(119, bundle);
            }
        } catch (RemoteException e) {
            w.w("MicroMsg.MsgHandler", "onSearchDataReady exception" + e.getMessage());
        }
    }

    public final void Kb(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", str);
        try {
            if (this.rXh != null) {
                this.rXh.m(124, bundle);
            }
        } catch (RemoteException e) {
            w.w("MicroMsg.MsgHandler", "onSearchSuggestionDataReady exception" + e.getMessage());
        }
    }

    public final void cn(String str, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_sns_id", str);
        bundle.putInt("fts_key_status", i);
        try {
            if (this.rXh != null) {
                this.rXh.m(125, bundle);
            }
        } catch (RemoteException e) {
            w.w("MicroMsg.MsgHandler", "onMusicStatusChanged exception" + e.getMessage());
        }
    }

    public final void Kj(String str) {
        w.i("MicroMsg.MsgHandler", "onSearchImageListReady ret %d data %s", new Object[]{Integer.valueOf(0), str});
        Bundle bundle = new Bundle();
        bundle.putInt("fts_key_ret", 0);
        bundle.putString("fts_key_data", str);
        try {
            if (this.rXh != null) {
                this.rXh.m(120, bundle);
            }
        } catch (RemoteException e) {
            w.w("MicroMsg.MsgHandler", "onSearchImageListReady exception" + e.getMessage());
        }
    }

    public final void d(int i, String str, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("fts_key_teach_request_type", i);
        bundle.putString("fts_key_json_data", str);
        bundle.putInt("fts_key_is_cache_data", i2);
        try {
            if (this.rXh != null) {
                this.rXh.m(121, bundle);
            }
        } catch (RemoteException e) {
            w.w("MicroMsg.MsgHandler", "onTeachSearchDataReady exception" + e.getMessage());
        }
    }

    public final void co(String str, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", str);
        bundle.putInt("fts_key_is_cache_data", i);
        try {
            if (this.rXh != null) {
                this.rXh.m(130, bundle);
            }
        } catch (Exception e) {
        }
    }

    public final boolean da(i iVar) {
        boolean z = false;
        int i = bg.getInt(bg.bw(iVar.ozE.get(SlookAirButtonFrequentContactAdapter.ID)), 0);
        if (i <= 0) {
            a(iVar, "kvReport:fail", null);
        } else {
            boolean z2;
            String bw = bg.bw(iVar.ozE.get(Columns.VALUE));
            if (bg.getInt(bg.bw(iVar.ozE.get("is_important")), 0) > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (bg.getInt(bg.bw(iVar.ozE.get("is_report_now")), 0) > 0) {
                z = true;
            }
            com.tencent.mm.plugin.report.service.g.oUh.a(i, bw, z, z2);
            a(iVar, "kvReport:ok", null);
        }
        return true;
    }

    public final String VD() {
        String str = null;
        if (this.rXh == null) {
            w.i("MicroMsg.MsgHandler", "getCurrentUrl, callbacker is null");
        } else {
            try {
                str = this.rXh.VD();
            } catch (Exception e) {
                w.e("MicroMsg.MsgHandler", "getCurrentUrl, exception = %s", new Object[]{e});
            }
        }
        return str;
    }

    public final boolean db(i iVar) {
        int i;
        String str = (String) iVar.ozE.get("miniProgramAppId");
        if (bg.mA(str)) {
            i = 0;
        } else {
            i = ((com.tencent.mm.plugin.appbrand.i.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.appbrand.i.a.class)).ny(str);
        }
        Map hashMap = new HashMap(1);
        hashMap.put("reportId", Integer.valueOf(i));
        a(iVar, "reportMiniProgramPageData:ok", hashMap);
        return true;
    }

    public final boolean dc(i iVar) {
        int i = 0;
        String o = com.tencent.mm.plugin.webview.c.e.o(iVar.ozE, "targetAppId");
        String VD = VD();
        String pH = pH(VD);
        if (bg.mA(pH)) {
            pH = com.tencent.mm.plugin.webview.c.e.o(iVar.ozE, "referrerAppId");
        }
        if (bg.mA(o)) {
            a(iVar, "launchMiniProgram:fail_invalid_targetAppId", null);
        } else if (bg.mA(pH)) {
            a(iVar, "launchMiniProgram:fail_invalid_referrerAppId", null);
        } else {
            String mz = bg.mz(com.tencent.mm.plugin.webview.c.e.o(iVar.ozE, "envVersion"));
            int i2 = -1;
            switch (mz.hashCode()) {
                case 110628630:
                    if (mz.equals("trial")) {
                        boolean z = true;
                        break;
                    }
                    break;
                case 1559690845:
                    if (mz.equals("develop")) {
                        i2 = 0;
                        break;
                    }
                    break;
            }
            switch (i2) {
                case 0:
                    i = 1;
                    break;
                case 1:
                    i = 2;
                    break;
            }
            ((com.tencent.mm.plugin.appbrand.i.c) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.appbrand.i.c.class)).a(this.context, VD, pH, o, i, com.tencent.mm.plugin.webview.c.e.o(iVar.ozE, "path"));
            a(iVar, "launchMiniProgram:ok", null);
        }
        return true;
    }

    public final boolean dd(i iVar) {
        String str = (String) iVar.ozE.get("username");
        if (!bg.mA(str)) {
            com.tencent.mm.sdk.b.b mVar = new com.tencent.mm.e.a.m();
            mVar.fCG.username = str;
            com.tencent.mm.sdk.b.a.urY.m(mVar);
        }
        a(iVar, "forceUpdateWxaAttr:ok", null);
        return true;
    }

    public final boolean de(i iVar) {
        Bundle bundle = new Bundle(2);
        bundle.putString("set_page_title_text", (String) iVar.ozE.get("title"));
        bundle.putString("set_page_title_color", (String) iVar.ozE.get("color"));
        try {
            this.rXh.d(43, bundle);
            a(iVar, "setPageTitle:ok", null);
        } catch (Exception e) {
            w.e("MicroMsg.MsgHandler", "doSetPageTitle, exception = %s", new Object[]{e});
            a(iVar, "setPageTitle:fail", null);
        }
        return true;
    }

    @Deprecated
    public final boolean df(i iVar) {
        String str = (String) iVar.ozE.get("color");
        if (bg.mA(str)) {
            w.i("MicroMsg.MsgHandler", "doSetStatusBarStyle, color is null or nill");
            a(iVar, "setStatusBarStyle:fail", null);
        } else {
            int i;
            if (str.equalsIgnoreCase("black")) {
                i = 48;
            } else if (str.equalsIgnoreCase("white")) {
                i = 49;
            } else {
                i = -1;
            }
            if (-1 != i) {
                try {
                    this.rXh.d(i, Bundle.EMPTY);
                    a(iVar, "setStatusBarStyle:ok", null);
                } catch (Exception e) {
                    w.e("MicroMsg.MsgHandler", "doSetStatusBarStyle, exception = %s", new Object[]{e});
                    a(iVar, "setStatusBarStyle:fail", null);
                }
            } else {
                w.i("MicroMsg.MsgHandler", "doSetStatusBarStyle, color is neither black or white");
                a(iVar, "setStatusBarStyle:fail", null);
            }
        }
        return true;
    }

    public final boolean dg(i iVar) {
        try {
            this.rXh.d(45, Bundle.EMPTY);
            a(iVar, "enableFullScreen:ok", null);
        } catch (Exception e) {
            w.e("MicroMsg.MsgHandler", "doEnableFullScreen, exception = %s", new Object[]{e});
            a(iVar, "enableFullScreen:fail", null);
        }
        return true;
    }

    public final boolean dh(i iVar) {
        String str = (String) iVar.ozE.get("left");
        String str2 = (String) iVar.ozE.get("right");
        if (bg.mA(str) && bg.mA(str2)) {
            a(iVar, "setNavigationBarButtons:fail", null);
        } else {
            Bundle bundle = new Bundle();
            try {
                str = new JSONObject(str).optString("color", "");
                if (!bg.mA(str)) {
                    bundle.putString("set_navigation_bar_buttons_left_text_color", str);
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.MsgHandler", e, "setNavigationBarButtons opt left ", new Object[0]);
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                boolean optBoolean = jSONObject.optBoolean("hidden", false);
                String optString = jSONObject.optString("text", "");
                String mz = bg.mz(com.tencent.mm.pluginsdk.ui.tools.s.Ns(jSONObject.optString("iconData", "")));
                str = jSONObject.optString("color", "");
                if (optBoolean) {
                    bundle.putBoolean("set_navigation_bar_buttons_hide_right_button", true);
                } else {
                    bundle.putString("set_navigation_bar_buttons_text", optString);
                    bundle.putString("set_navigation_bar_buttons_icon_data", mz);
                    bundle.putString("set_navigation_bar_buttons_text_color", str);
                }
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.MsgHandler", e2, "setNavigationBarButtons opt right ", new Object[0]);
            }
            if (bundle.size() < 0) {
                a(iVar, "setNavigationBarButtons:fail_invalid_params", null);
            } else {
                try {
                    this.rXh.d(44, bundle);
                    a(iVar, "setNavigationBarButtons:ok", null);
                } catch (Throwable e22) {
                    w.printErrStackTrace("MicroMsg.MsgHandler", e22, " setNavigationBarButtons invoke ", new Object[0]);
                    a(iVar, "setNavigationBarButtons:fail_invoke", null);
                }
            }
        }
        return true;
    }

    public final boolean di(i iVar) {
        try {
            this.rXh.d(34, Bundle.EMPTY);
            a(iVar, "enablePullDownRefresh:ok", null);
        } catch (Exception e) {
            w.i("MicroMsg.MsgHandler", "doEnablePullDownRefresh, exception = %s", new Object[]{e});
            a(iVar, "enablePullDownRefresh:fail", null);
        }
        return true;
    }

    public final boolean dj(i iVar) {
        try {
            this.rXh.d(35, Bundle.EMPTY);
            a(iVar, "startPullDownRefresh:ok", null);
        } catch (Exception e) {
            w.i("MicroMsg.MsgHandler", "doStartPullDownRefresh, exception = %s", new Object[]{e});
            a(iVar, "startPullDownRefresh:fail", null);
        }
        return true;
    }

    public final boolean dk(i iVar) {
        try {
            this.rXh.d(36, Bundle.EMPTY);
            a(iVar, "stopPullDownRefresh:ok", null);
        } catch (Exception e) {
            w.i("MicroMsg.MsgHandler", "doStopPullDownRefresh, exception = %s", new Object[]{e});
            a(iVar, "stopPullDownRefresh:fail", null);
        }
        return true;
    }

    public final boolean bzM() {
        try {
            this.rXh.d(47, Bundle.EMPTY);
            a(this.skt, "disablePullDownRefresh:ok", null);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
            a(this.skt, "disablePullDownRefresh:fail", null);
        }
        return true;
    }

    public final boolean dl(i iVar) {
        this.lre = false;
        String mz = bg.mz((String) iVar.ozE.get("placeholder"));
        int i = bg.getInt((String) iVar.ozE.get("maxLength"), 0);
        try {
            Bundle bundle = new Bundle(2);
            bundle.putString("show_kb_placeholder", mz);
            bundle.putInt("show_kb_max_length", i);
            this.rXh.d(37, bundle);
            this.slg = iVar;
        } catch (Exception e) {
            w.i("MicroMsg.MsgHandler", "doShowKeyBoard, exception = %s", new Object[]{e});
            a(this.rXh, iVar, "showKeyboard:fail", null, true, true);
        }
        return true;
    }

    public final boolean dm(i iVar) {
        this.lre = false;
        try {
            Bundle d = this.rXh.d(79, new Bundle());
            Map hashMap = new HashMap();
            int i = d.getInt("height", 0);
            if (i > 0) {
                hashMap.put("height", Integer.valueOf(com.tencent.mm.bg.a.W(ab.getContext(), i)));
                a(this.rXh, iVar, "showSmileyPanel:ok", hashMap, true, true);
            } else {
                a(this.rXh, iVar, "showSmileyPanel:fail", null, true, true);
            }
        } catch (Exception e) {
            w.i("MicroMsg.MsgHandler", "doShowSmileyPanel, exception = %s", new Object[]{e});
            a(this.rXh, iVar, "showSmileyPanel:fail", null, true, true);
        }
        return true;
    }

    public final boolean dn(i iVar) {
        String str = (String) iVar.ozE.get("place");
        if (bg.mA(str)) {
            a(iVar, "disableBounceScroll:fail", null);
        } else {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int i = 0;
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    if ("top".equalsIgnoreCase(jSONArray.getString(i2))) {
                        i = true;
                    }
                }
                if (i == 0) {
                    a(iVar, "disableBounceScroll:ok", null);
                } else {
                    try {
                        Bundle bundle = new Bundle(1);
                        bundle.putInt("webview_disable_bounce_scroll_top", 1);
                        this.rXh.d(38, bundle);
                        a(iVar, "disableBounceScroll:ok", null);
                    } catch (Exception e) {
                        w.i("MicroMsg.MsgHandler", "doDisableBounceScroll, exception = %s", new Object[]{e});
                        a(iVar, "disableBounceScroll:fail", null);
                    }
                }
            } catch (JSONException e2) {
                w.i("MicroMsg.MsgHandler", "doDisableBounceScroll, invalid json array, string = %s", new Object[]{str});
                a(iVar, "disableBounceScroll:fail", null);
            }
        }
        return true;
    }

    public final boolean do(i iVar) {
        try {
            this.rXh.d(39, new Bundle(0));
            a(iVar, "clearBounceBackground:ok", null);
        } catch (Exception e) {
            w.e("MicroMsg.MsgHandler", "doClearBounceBackground, exception = %s", new Object[]{e});
            a(iVar, "clearBounceBackground:fail", null);
        }
        return true;
    }

    public final boolean dp(i iVar) {
        Bundle bundle = new Bundle();
        bundle.putString("key_set_bounce_background_color", (String) iVar.ozE.get("backgroundColor"));
        try {
            this.rXh.d(72, bundle);
            a(iVar, "setBounceBackground:ok", null);
        } catch (Exception e) {
            w.e("MicroMsg.MsgHandler", "setBounceBackground, exception = %s", new Object[]{e});
            a(iVar, "setBounceBackground:fail", null);
        }
        return true;
    }

    public final boolean dq(i iVar) {
        int i = bg.getInt(bg.bw(iVar.ozE.get(SlookAirButtonFrequentContactAdapter.ID)), 0);
        if (i <= 0) {
            a(iVar, "realtimeReport:fail", null);
            return true;
        }
        Object obj;
        String bw = bg.bw(iVar.ozE.get(Columns.VALUE));
        int i2 = bg.getInt(bg.bw(iVar.ozE.get(Columns.TYPE)), 0);
        com.tencent.mm.plugin.webview.model.e eVar = a.rWC;
        if (ap.zb()) {
            long longValue;
            com.tencent.mm.plugin.webview.model.d bxb = com.tencent.mm.plugin.webview.d.f.bxb();
            Long l = (Long) bxb.rWu.get(Integer.valueOf(i));
            if (l != null) {
                longValue = l.longValue();
            } else {
                Cursor a = bxb.hnH.a(String.format("select %s from %s where %s=?", new Object[]{"liftTime", "JsLogBlockList", "logId"}), new String[]{String.valueOf(i)}, 2);
                if (a == null) {
                    longValue = 0;
                } else if (a.moveToFirst()) {
                    longValue = a.getLong(0);
                    a.close();
                } else {
                    a.close();
                    longValue = 0;
                }
            }
            if (longValue != 0 && longValue < bg.Ny()) {
                at atVar = bxb.rWu;
                Integer valueOf = Integer.valueOf(i);
                if (valueOf == null) {
                    throw new NullPointerException("key == null");
                }
                if (atVar.get(valueOf) != null) {
                    atVar.q(valueOf, null);
                }
                longValue = 0;
            }
            if (longValue == 0 || longValue < bg.Ny()) {
                aig com_tencent_mm_protocal_c_aig = new aig();
                com_tencent_mm_protocal_c_aig.tMh = i;
                com_tencent_mm_protocal_c_aig.tMi = com.tencent.mm.bd.b.NG(bw);
                com_tencent_mm_protocal_c_aig.tMq = i2;
                eVar.rWz.add(com_tencent_mm_protocal_c_aig);
                obj = 1;
                if (obj == null) {
                    a(iVar, "realtimeReport:ok", null);
                } else {
                    a(iVar, "realtimeReport:fail", null);
                }
                return true;
            }
        }
        w.i("MicroMsg.WebView.JsLogHelper", "kvStat(), acc not ready, skip");
        obj = null;
        if (obj == null) {
            a(iVar, "realtimeReport:fail", null);
        } else {
            a(iVar, "realtimeReport:ok", null);
        }
        return true;
    }

    public final boolean dr(i iVar) {
        String str = (String) iVar.ozE.get("latitude");
        String str2 = (String) iVar.ozE.get("longitude");
        final String str3 = (String) iVar.ozE.get("destinationName");
        if (bg.mA(str) || bg.mA(str2)) {
            a(iVar, "openMapNavigateMenu:fail", null);
        } else {
            try {
                final double parseDouble = Double.parseDouble(str);
                final double parseDouble2 = Double.parseDouble(str2);
                final int i = bg.getInt((String) iVar.ozE.get("preferMap"), com.tencent.mm.pluginsdk.model.a.a.sBX.code);
                if (this.context == null || !(this.context instanceof Activity) || ((Activity) this.context).isFinishing()) {
                    a(iVar, "openMapNavigateMenu:fail", null);
                } else {
                    final int cA = cA(iVar);
                    com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                        final /* synthetic */ g sll;

                        public final void run() {
                            boolean z = false;
                            if (!(this.sll.context == null || !(this.sll.context instanceof Activity) || ((Activity) this.sll.context).isFinishing())) {
                                boolean z2;
                                j jVar = this.sll.skH;
                                Context context = this.sll.context;
                                int i = i;
                                double d = parseDouble;
                                double d2 = parseDouble2;
                                String str = str3;
                                int i2 = cA;
                                d anonymousClass1 = new d(this) {
                                    final /* synthetic */ AnonymousClass14 slz;

                                    {
                                        this.slz = r1;
                                    }

                                    public final void wF(int i) {
                                        ay(i, "cancel");
                                    }

                                    public final void mF(int i) {
                                        ay(i, "fail");
                                    }

                                    public final void rD(int i) {
                                        ay(i, "ok");
                                    }

                                    private void ay(int i, String str) {
                                        c wD = this.slz.sll.wD(i);
                                        if (wD != null && wD.skt != null && wD.rXh != null) {
                                            this.slz.sll.a(this.slz.sll.rXh, this.slz.sll.skt, "openMapNavigateMenu:" + bg.ap(str, "fail"));
                                        }
                                    }

                                    public final void wG(int i) {
                                        this.slz.sll.wE(i);
                                    }
                                };
                                if (context == null || !(context instanceof MMActivity) || ((MMActivity) context).isFinishing()) {
                                    z2 = false;
                                } else {
                                    jVar.rYd = i2;
                                    jVar.smO = true;
                                    jVar.smP = i;
                                    jVar.smR = new e(d, d2);
                                    jVar.smS = str;
                                    jVar.smT = new WeakReference(context);
                                    jVar.smU = anonymousClass1;
                                    jVar.hvP = null;
                                    if (jVar.hvP == null) {
                                        jVar.bzU();
                                    } else {
                                        jVar.smX = new com.tencent.mm.modelgeo.a.a(jVar) {
                                            final /* synthetic */ j smZ;

                                            {
                                                this.smZ = r1;
                                            }

                                            public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                                                if (this.smZ.hvP != null) {
                                                    this.smZ.hvP.c(this);
                                                }
                                                if (z) {
                                                    this.smZ.smQ = new e((double) f2, (double) f);
                                                    if (this.smZ.ngr != null) {
                                                        this.smZ.smV = new com.tencent.mm.modelgeo.b.a(this) {
                                                            final /* synthetic */ AnonymousClass2 sna;

                                                            {
                                                                this.sna = r1;
                                                            }

                                                            public final void b(Addr addr) {
                                                                if (this.sna.smZ.smQ != null && this.sna.smZ.smV != null) {
                                                                    this.sna.smZ.smQ.snb = addr.Gh();
                                                                    this.sna.smZ.bzU();
                                                                }
                                                            }
                                                        };
                                                        this.smZ.ngr.a((double) f2, (double) f, this.smZ.smV);
                                                        return false;
                                                    }
                                                }
                                                this.smZ.bzU();
                                                return false;
                                            }
                                        };
                                        if (jVar.ngr != null) {
                                            jVar.smW = new com.tencent.mm.modelgeo.b.a(jVar) {
                                                final /* synthetic */ j smZ;

                                                {
                                                    this.smZ = r1;
                                                }

                                                public final void b(Addr addr) {
                                                    if (this.smZ.smR != null && this.smZ.smW != null) {
                                                        this.smZ.smR.snb = addr.Gh();
                                                    }
                                                }
                                            };
                                            jVar.ngr.a(jVar.smR.latitude, jVar.smR.longitude, jVar.smW);
                                        }
                                        com.tencent.mm.sdk.platformtools.af.v(new Runnable(jVar) {
                                            final /* synthetic */ j smZ;

                                            {
                                                this.smZ = r1;
                                            }

                                            public final void run() {
                                                if (this.smZ.smT != null && this.smZ.smT.get() != null) {
                                                    Toast.makeText((Context) this.smZ.smT.get(), R.l.eRP, 0).show();
                                                }
                                            }
                                        });
                                        jVar.hvP.b(jVar.smX);
                                        com.tencent.mm.sdk.platformtools.af.f(jVar.smY, 4000);
                                    }
                                    z2 = true;
                                }
                                z = z2;
                            }
                            if (!z) {
                                c wD = this.sll.wD(cA);
                                if (wD.rXh != null && wD.skt != null) {
                                    this.sll.a(wD.rXh, wD.skt, "openMapNavigateMenu:fail");
                                }
                            }
                        }
                    });
                }
            } catch (Exception e) {
                w.e("MicroMsg.MsgHandler", "doOpenMapNavigateMenu, parse double, exception = %s");
                a(iVar, "openMapNavigateMenu:fail", null);
            }
        }
        return true;
    }

    public final Bundle bzN() {
        Bundle bundle = null;
        try {
            bundle = this.rXh.d(33, null);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MsgHandler", e, "", new Object[0]);
        }
        w.i("MicroMsg.MsgHandler", "getWebViewIntentExtras(%s)", new Object[]{bundle});
        return bundle;
    }

    public final boolean bzO() {
        this.lre = false;
        return false;
    }

    public final boolean bzP() {
        this.lre = false;
        com.tencent.mm.plugin.webview.d.f.bwX();
        return com.tencent.mm.plugin.webview.e.b.bAl();
    }

    public final boolean ds(i iVar) {
        Map hashMap = new HashMap();
        hashMap.put("ret", Integer.valueOf(0));
        hashMap.put("callbackid", Integer.valueOf(123123));
        a(iVar, "ok", hashMap);
        return true;
    }

    public final boolean dt(i iVar) {
        String str = (String) iVar.ozE.get("operationType");
        String str2 = (String) iVar.ozE.get("dataUrl");
        k.a(iVar.smM, false, null, "");
        if (bg.mA(str) || bg.mA(str2)) {
            a(iVar, "operateMusicPlayer:fail", null);
            return true;
        }
        if (str.equalsIgnoreCase("play")) {
            String str3 = (String) iVar.ozE.get("title");
            String str4 = (String) iVar.ozE.get("singer");
            String str5 = (String) iVar.ozE.get("epname");
            String str6 = (String) iVar.ozE.get("coverImgUrl");
            String str7 = (String) iVar.ozE.get("lowbandUrl");
            String str8 = (String) iVar.ozE.get("webUrl");
            iVar.ozE.get("lyric");
            w.i("MicroMsg.MsgHandler", "title : %s, singer : %s, epName : %s, coverImgUrl : %s, dataUrl : %s, lowbandUrl : %s, webUrl : %s, appid : %s", new Object[]{str3, str4, str5, str6, str2, str7, str8, ""});
            if (bg.mA(str3) || bg.mA(str4) || bg.mA(str5) || bg.mA(str6) || bg.mA(str7) || bg.mA(str2) || bg.mA(str8)) {
                a(iVar, "operateMusicPlayer:fail", null);
            } else {
                com.tencent.mm.am.b.HH();
                com.tencent.mm.am.a.a aVar = (com.tencent.mm.am.a.a) com.tencent.mm.kernel.h.h(com.tencent.mm.am.a.a.class);
                String str9 = str2.hashCode();
                String str10 = com.tencent.mm.compatible.util.e.hgu;
                StringBuilder stringBuilder = new StringBuilder();
                ap.yY();
                com.tencent.mm.am.b.b(aVar.a(7, str6, str3, str4, str8, str7, str2, str9, str10, stringBuilder.append(com.tencent.mm.u.c.xb()).append(str6.hashCode()).toString(), str5, ""));
                a(iVar, "operateMusicPlayer:ok", null);
            }
        } else if (str.equalsIgnoreCase("resume")) {
            if (com.tencent.mm.am.c.jS(str2) && com.tencent.mm.am.b.HK() && !com.tencent.mm.am.b.HJ()) {
                com.tencent.mm.am.b.qQ();
                r0 = 1;
            } else {
                r0 = null;
            }
            if (r0 != null) {
                a(iVar, "operateMusicPlayer:ok", null);
            } else {
                a(iVar, "operateMusicPlayer:fail", null);
            }
        } else if (str.equalsIgnoreCase("pause")) {
            if (com.tencent.mm.am.c.jS(str2) && com.tencent.mm.am.b.HJ()) {
                com.tencent.mm.am.b.qP();
                r0 = 1;
            } else {
                r0 = null;
            }
            if (r0 != null) {
                com.tencent.mm.am.b.HI();
                a(iVar, "operateMusicPlayer:ok", null);
            } else {
                a(iVar, "operateMusicPlayer:fail", null);
            }
        } else if (str.equalsIgnoreCase("seek")) {
            if (com.tencent.mm.am.c.jS(str2) ? com.tencent.mm.am.b.gi(bg.getInt(bg.bw(iVar.ozE.get("position")), -1) * 1000) : false) {
                a(iVar, "operateMusicPlayer:ok", null);
            } else {
                a(iVar, "operateMusicPlayer:fail", null);
            }
        } else if (str.equalsIgnoreCase("stop")) {
            if (com.tencent.mm.am.c.jS(str2) && com.tencent.mm.am.b.HK()) {
                com.tencent.mm.am.b.HH();
                r0 = 1;
            } else {
                r0 = null;
            }
            if (r0 != null) {
                a(iVar, "operateMusicPlayer:ok", null);
            } else {
                a(iVar, "operateMusicPlayer:fail", null);
            }
        } else {
            a(iVar, "operateMusicPlayer:fail", null);
        }
        return true;
    }

    public final boolean du(i iVar) {
        String str = (String) iVar.ozE.get("dataUrl");
        k.a(iVar.smM, false, null, (String) iVar.ozE.get("appId"));
        if (bg.mA(str)) {
            a(iVar, "getMusicPlayerState:fail_dataUrl_null", null);
        } else {
            w.i("MicroMsg.MsgHandler", "dataUrl : %s, appid : %s", new Object[]{str, r1});
            anf HL = com.tencent.mm.am.b.HL();
            if (HL == null || !HL.tRN.equals(str)) {
                a(iVar, "getMusicPlayerState:failed_dataUrl_diff", null);
            } else {
                int i;
                int i2;
                com.tencent.mm.am.d HM = com.tencent.mm.am.b.HM();
                if (HM != null) {
                    i = HM.ls;
                    i2 = HM.kC;
                } else {
                    i = -1;
                    i2 = 0;
                }
                if (HM == null || i < 0 || i2 < 0) {
                    a(iVar, "getMusicPlayerState:fail", null);
                } else {
                    i /= 1000;
                    i2 /= 1000;
                    int i3 = HM.mStatus;
                    int i4 = HM.hMV;
                    Map hashMap = new HashMap();
                    hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(i));
                    hashMap.put("currentPosition", Integer.valueOf(i2));
                    hashMap.put(DownloadInfo.STATUS, Integer.valueOf(i3));
                    hashMap.put("downloadPercent", Integer.valueOf(i4));
                    a(iVar, "getMusicPlayerState:ok", hashMap);
                }
            }
        }
        return true;
    }

    public final boolean dv(i iVar) {
        String str = (String) iVar.ozE.get("localId");
        if (bg.mA(str)) {
            a(iVar, "getLocalImgData:fail_invaild_localid", null);
        } else {
            WebViewJSSDKFileItem IS = com.tencent.mm.plugin.webview.d.f.bwZ().IS(str);
            if (!(IS == null || IS.rWW == null)) {
                int i;
                Bitmap decodeFile = MMBitmapFactory.decodeFile(IS.rWW);
                int i2 = decodeFile != null ? 1 : 0;
                if (decodeFile.isRecycled()) {
                    i = 0;
                } else {
                    i = 1;
                }
                if ((i2 & i) != 0) {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    decodeFile.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                    w.i("MicroMsg.MsgHandler", "rawData lenght = %d, base64 lenght = %d", new Object[]{Integer.valueOf(byteArrayOutputStream.toByteArray().length), Integer.valueOf(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0).length())});
                    Map hashMap = new HashMap();
                    hashMap.put("localData", r3);
                    a(iVar, "getLocalImgData:ok", hashMap);
                    decodeFile.recycle();
                }
            }
            a(iVar, "getLocalImgData:fail", null);
        }
        return true;
    }

    public final boolean dw(i iVar) {
        w.i("MicroMsg.MsgHandler", "Note:doWNNoteOnClick");
        this.lre = false;
        com.tencent.mm.plugin.webview.d.f.bwX();
        return com.tencent.mm.plugin.webview.e.b.aa(iVar.ozE);
    }

    public final boolean bzQ() {
        this.lre = false;
        com.tencent.mm.plugin.webview.d.f.bwX();
        return true;
    }

    public final boolean bzR() {
        this.lre = false;
        ap.vL().e(new Runnable(com.tencent.mm.plugin.webview.d.f.bwX()) {
            final /* synthetic */ b soJ;

            {
                this.soJ = r1;
            }

            public final void run() {
                Bundle bundle = new Bundle();
                bundle.putInt("operation_type", 7);
                com.tencent.mm.plugin.webview.ui.tools.jsapi.h.wH(b.soE).V(bundle);
            }
        }, 20);
        return false;
    }

    public final boolean dx(i iVar) {
        int i = 0;
        this.lre = false;
        Bundle bundle = new Bundle();
        try {
            int i2 = bg.getInt(iVar.ozE.get("scene").toString().trim(), 0);
            bundle.putInt("scene", i2);
            w.i("MicroMsg.MsgHandler", "doExposePreparation scene:%d", new Object[]{Integer.valueOf(i2)});
            if (-1 == bundle.getInt("scene")) {
                a(iVar, "doExposePreparation fail:unknown scene", null);
            } else {
                bundle = this.rXh.d(73, bundle);
                Map hashMap = new HashMap();
                if (bundle.isEmpty()) {
                    a(iVar, "doExposePreparation fail", null);
                } else {
                    switch (i2) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
                        case 36:
                        case JsApiGetLocation.CTRL_INDEX /*37*/:
                        case 38:
                        case 39:
                        case 45:
                            break;
                        case 33:
                            hashMap.put("newMsgId", bundle.getString("newMsgId"));
                            break;
                        case 34:
                            hashMap.put("webviewImg", bundle.getString("webviewImg"));
                            hashMap.put("webviewHtml", bundle.getString("webviewHtml"));
                            hashMap.put("content", bundle.getString("content"));
                            w.i("MicroMsg.MsgHandler", "content = " + bundle.getString("content"));
                            break;
                        case 51:
                            hashMap.put("newMsgId", bundle.getString("newMsgId"));
                            hashMap.put("msgType", Integer.valueOf(bundle.getInt("msgType")));
                            break;
                        default:
                            a(iVar, "doExposePreparation fail:unknown scene", null);
                            break;
                    }
                    hashMap.put("username", bundle.getString("username"));
                    JSONArray jSONArray = new JSONArray();
                    ArrayList stringArrayList = bundle.getStringArrayList("content");
                    if (stringArrayList != null) {
                        int size = stringArrayList.size();
                        while (i < size) {
                            jSONArray.put(stringArrayList.get(i));
                            i++;
                        }
                    }
                    if (hashMap.get("content") == null) {
                        hashMap.put("content", jSONArray.toString());
                    }
                    a(iVar, "doExposePreparation ok", hashMap);
                }
            }
        } catch (Exception e) {
            w.w("MicroMsg.MsgHandler", "doExposePreparation exception " + e.getMessage());
            a(iVar, "doExposePreparation fail", null);
        }
        return true;
    }

    public final boolean dy(i iVar) {
        try {
            String obj = iVar.ozE.get(Columns.TYPE).toString();
            if (bg.mA(obj)) {
                a(iVar, "openLuckyMoneyHistory:fail", null);
            } else if (obj.equals("send")) {
                r0 = new Intent();
                r0.putExtra("key_type", 1);
                com.tencent.mm.bb.d.b(this.context, "luckymoney", ".ui.LuckyMoneyMyRecordUI", r0);
                a(iVar, "openLuckyMoneyHistory:ok", null);
            } else if (obj.equals("receive")) {
                r0 = new Intent();
                r0.putExtra("key_type", 2);
                com.tencent.mm.bb.d.b(this.context, "luckymoney", ".ui.LuckyMoneyMyRecordUI", r0);
                a(iVar, "openLuckyMoneyHistory:ok", null);
            }
        } catch (Exception e) {
            w.e("MicroMsg.MsgHandler", "doOpenLuckyMoneyHistory error %s", new Object[]{e});
            a(iVar, "openLuckyMoneyHistory:fail", null);
        }
        return true;
    }

    public final boolean dz(i iVar) {
        this.lre = false;
        String obj = iVar.ozE.get("chat_username").toString();
        Intent intent = new Intent();
        intent.putExtra("Chat_User", obj);
        intent.putExtra("finish_direct", true);
        intent.putExtra("expose_edit_mode", true);
        intent.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        if (this.context instanceof MMActivity) {
            com.tencent.mm.bb.d.a((MMActivity) this.context, ".ui.chatting.En_5b8fbb1e", intent, 40, this);
        }
        return true;
    }

    public final boolean dA(i iVar) {
        this.lre = false;
        String trim = iVar.ozE.get("scene").toString().trim();
        if (!trim.equals("expose")) {
            a(iVar, "openSecurityView fail, scene error : " + trim, null);
        } else if (iVar.ozE.get("userData") != null) {
            try {
                JSONObject jSONObject = (JSONObject) new JSONTokener(iVar.ozE.get("userData").toString()).nextValue();
                Intent intent = new Intent();
                intent.putExtra("sns_permission_userName", jSONObject.get("userName").toString());
                intent.putExtra("sns_permission_anim", true);
                intent.putExtra("sns_permission_block_scene", 1);
                intent.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                com.tencent.mm.bb.d.b(this.context, "sns", ".ui.SnsPermissionUI", intent);
                a(iVar, "openSecurityView ok", null);
            } catch (JSONException e) {
                w.w("MicroMsg.MsgHandler", "openSecurityView error, userData not in json");
                a(iVar, "openSecurityView error,userData not in json", null);
            }
        } else {
            a(iVar, "openSecurityView fail, no userData", null);
        }
        return true;
    }

    public final boolean dB(i iVar) {
        String pH = pH(VD());
        String rA = com.tencent.mm.compatible.d.p.rA();
        String rB = com.tencent.mm.compatible.d.p.rB();
        if (bg.mA(rA) || bg.mA(pH) || bg.mA(rB)) {
            a(iVar, "getOpenDeviceId:fail", null);
        } else {
            rA = com.tencent.mm.sdk.platformtools.aa.Pq(com.tencent.mm.sdk.platformtools.aa.Pq(pH + rA));
            pH = com.tencent.mm.sdk.platformtools.aa.Pq(com.tencent.mm.sdk.platformtools.aa.Pq(pH + rB));
            Map hashMap = new HashMap();
            hashMap.put("deviceid", rA);
            hashMap.put("newDeviceId", pH);
            a(iVar, "getOpenDeviceId:ok", hashMap);
        }
        return true;
    }

    public final boolean dC(i iVar) {
        try {
            Bundle d = this.rXh.d(90000, null);
            if (d != null) {
                String[] stringArray = d.getStringArray("webview_get_route_url_list");
                int i = d.getInt("webview_get_route_url_geta8key_scene");
                String str = "MicroMsg.MsgHandler";
                String str2 = "routeUrl length = %d, scene = %d";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(stringArray != null ? stringArray.length : -1);
                objArr[1] = Integer.valueOf(i);
                w.i(str, str2, objArr);
                if (stringArray != null && stringArray.length > 0) {
                    Map hashMap = new HashMap();
                    JSONArray jSONArray = new JSONArray();
                    for (Object put : stringArray) {
                        jSONArray.put(put);
                    }
                    hashMap.put("urls", jSONArray.toString());
                    hashMap.put("scene", Integer.valueOf(i));
                    a(iVar, "getRouteUrl:ok", hashMap);
                    return true;
                }
            }
        } catch (Exception e) {
            w.e("MicroMsg.MsgHandler", "get routeurl failed ; %s", new Object[]{e.getMessage()});
        }
        a(iVar, "getRouteUrl:fail", null);
        return true;
    }

    public final synchronized boolean dD(i iVar) {
        w.i("MicroMsg.MsgHandler", "doWNNoteInitData");
        com.tencent.mm.plugin.webview.e.b.soE = bg.n(iVar.ozE.get("webview_instance_id"), -1);
        Map hashMap = new HashMap();
        JSONArray jSONArray = new JSONArray();
        Bundle bundle = new Bundle();
        hashMap.put("html", "");
        if (com.tencent.mm.plugin.webview.d.f.bwX().soD) {
            hashMap.put("title", "");
            hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, jSONArray);
            a(iVar, "ok", hashMap);
            try {
                if (this.rXh != null) {
                    bundle.putBoolean("showVKB", true);
                    this.rXh.m(42, bundle);
                }
            } catch (RemoteException e) {
                w.w("MicroMsg.MsgHandler", "WNJSHandlerVoicePlayStart exception" + e.getMessage());
            }
        } else {
            hashMap.put("ret", Integer.valueOf(0));
            if (com.tencent.mm.plugin.webview.d.f.bwX().soA != null) {
                com.tencent.mm.plugin.webview.d.f.bwX().soB = null;
                com.tencent.mm.plugin.webview.d.f.bwX().soF = false;
                w.i("MicroMsg.MsgHandler", "WNNote:htmldata = %s", new Object[]{com.tencent.mm.plugin.webview.d.f.bwX().soA.toString()});
                hashMap.put("html", com.tencent.mm.plugin.webview.d.f.bwX().soz);
                hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, com.tencent.mm.plugin.webview.d.f.bwX().soA);
                a(iVar, "ok", hashMap);
                try {
                    if (this.rXh != null) {
                        this.rXh.m(45, null);
                        Bundle bundle2 = new Bundle();
                        bundle2.putBoolean("showVKB", false);
                        bundle2.putString("maxhtmlid", com.tencent.mm.plugin.webview.d.f.bwX().fQG);
                        this.rXh.m(42, bundle2);
                    }
                } catch (RemoteException e2) {
                    w.w("MicroMsg.MsgHandler", "InitData_ChangeSatusEdited exception" + e2.getMessage());
                }
            } else {
                com.tencent.mm.plugin.webview.d.f.bwX().soB = iVar;
            }
            try {
                if (this.rXh != null) {
                    this.rXh.m(41, null);
                }
            } catch (RemoteException e22) {
                w.w("MicroMsg.MsgHandler", "InitData_AC_ON_WNNOTE_CHANGE_STATUS_EDITING exception" + e22.getMessage());
            }
        }
        return true;
    }

    public final void T(Bundle bundle) {
        w.i("MicroMsg.MsgHandler", "WNNote:WNJSHandlerInsert bundle: %s", new Object[]{bundle.toString()});
        try {
            if (this.rXh != null) {
                this.rXh.m(26, bundle);
            }
        } catch (RemoteException e) {
            w.w("MicroMsg.MsgHandler", "WNJSHandlerInsert exception" + e.getMessage());
        }
    }

    public final void U(Bundle bundle) {
        w.i("MicroMsg.MsgHandler", "WNJSHandlerLoadingFinish");
        try {
            if (this.rXh != null) {
                this.rXh.m(45, bundle);
            }
        } catch (RemoteException e) {
            w.w("MicroMsg.MsgHandler", "WNJSHandlerLoadingFinish exception" + e.getMessage());
        }
    }

    public final void V(Bundle bundle) {
        w.i("MicroMsg.MsgHandler", "WNJSHandlerOperation");
        try {
            if (this.rXh != null) {
                this.rXh.m(46, bundle);
            }
        } catch (RemoteException e) {
            w.w("MicroMsg.MsgHandler", "WNJSHandlerOperation exception" + e.getMessage());
        }
    }

    public final boolean dE(i iVar) {
        w.i("MicroMsg.MsgHandler", "doGetBackgroundAudioState()");
        if (dH(iVar)) {
            anf HL = com.tencent.mm.am.b.HL();
            if (HL != null) {
                int i;
                int i2;
                com.tencent.mm.am.d HM = com.tencent.mm.am.b.HM();
                if (HM != null) {
                    i = HM.ls;
                    i2 = HM.kC;
                } else {
                    i = -1;
                    i2 = 0;
                }
                if (HM == null || i < 0 || i2 < 0) {
                    w.e("MicroMsg.MsgHandler", "return parameter is invalid");
                    a(iVar, "getBackgroundAudioState:fail", null);
                } else {
                    com.tencent.mm.sdk.b.a.urY.b(this.slh);
                    i /= 1000;
                    int i3 = i2 / 1000;
                    int i4 = HM.mStatus;
                    i2 = HM.hMV;
                    if (i > 0) {
                        i2 = (i2 * i) / 100;
                    } else {
                        i2 = 0;
                    }
                    Map hashMap = new HashMap();
                    hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(i));
                    hashMap.put("currentTime", Integer.valueOf(i3));
                    hashMap.put("paused", Integer.valueOf(i4 == 1 ? 0 : 1));
                    hashMap.put("src", HL.tRN);
                    hashMap.put("buffered", Integer.valueOf(i2));
                    hashMap.put("title", HL.tRJ);
                    hashMap.put("epname", HL.tRL);
                    hashMap.put("singer", HL.tRK);
                    hashMap.put("coverImgUrl", HL.tRM);
                    hashMap.put("isLive", Integer.valueOf(0));
                    hashMap.put("startTime", Integer.valueOf(HL.iMR / 1000));
                    hashMap.put("srcId", HL.hMU);
                    w.i("MicroMsg.MsgHandler", "getBackgroundAudioState ok");
                    a(iVar, "getBackgroundAudioState:ok", hashMap);
                }
            } else {
                w.e("MicroMsg.MsgHandler", "currentWrapper is null");
                a(iVar, "getBackgroundAudioState:fail", null);
            }
        } else {
            w.e("MicroMsg.MsgHandler", "no permission to do get state");
            a(iVar, "getBackgroundAudioState:fail", null);
        }
        return true;
    }

    public final boolean dF(i iVar) {
        String JZ;
        String str;
        String Jd;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        int i;
        String str8;
        String str9;
        boolean parseBoolean;
        w.i("MicroMsg.MsgHandler", "doSetBackgroundAudioState()");
        com.tencent.mm.sdk.b.a.urY.b(this.slh);
        CharSequence charSequence = (String) iVar.ozE.get("appId");
        if (this.skw != null) {
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = this.skw.getString("jsapi_args_appid");
            }
            if (TextUtils.isEmpty(charSequence)) {
                JZ = this.skF.JZ(VD());
                w.i("MicroMsg.MsgHandler", "appId:%s", new Object[]{JZ});
                k.a(iVar.smM, false, null, JZ);
                str = (String) iVar.ozE.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
                if (bg.mA(str)) {
                    Jd = com.tencent.mm.plugin.webview.modelcache.p.Jd(str);
                } else {
                    Jd = null;
                }
                str2 = (String) iVar.ozE.get("src");
                str3 = (String) iVar.ozE.get("lowbandSrc");
                str4 = (String) iVar.ozE.get("title");
                str5 = (String) iVar.ozE.get("epname");
                str6 = (String) iVar.ozE.get("singer");
                str = (String) iVar.ozE.get("coverImgUrl");
                str7 = (String) iVar.ozE.get("webUrl");
                i = bg.getInt((String) iVar.ozE.get("startTime"), 0);
                str8 = (String) iVar.ozE.get("srcId");
                if (str != null) {
                    str9 = "";
                } else {
                    str9 = str;
                }
                parseBoolean = Boolean.parseBoolean((String) iVar.ozE.get("isLive"));
                w.i("MicroMsg.MsgHandler", "src : %s, title : %s, singer : %s, coverImgUrl : %s, webUrl : %s, isLive : %b, startTime:%d", new Object[]{str2, str4, str6, str9, str7, Boolean.valueOf(parseBoolean), Integer.valueOf(i)});
                if (!bg.mA(str2) || bg.mA(str4)) {
                    w.e("MicroMsg.MsgHandler", "setBackgroundAudioState fail, src or title is null");
                    a(iVar, "setBackgroundAudioState:fail", null);
                } else {
                    com.tencent.mm.am.a.a aVar = (com.tencent.mm.am.a.a) com.tencent.mm.kernel.h.h(com.tencent.mm.am.a.a.class);
                    String str10 = str2.hashCode();
                    String str11 = com.tencent.mm.compatible.util.e.hgu;
                    StringBuilder stringBuilder = new StringBuilder();
                    ap.yY();
                    anf a = aVar.a(10, str9, str4, str6, str7, str3, str2, str10, str11, stringBuilder.append(com.tencent.mm.u.c.xb()).append(str9.hashCode()).toString(), str5, JZ);
                    a.tSb = Jd;
                    a.iMR = i * 1000;
                    a.hMU = str8;
                    com.tencent.mm.am.b.b(a);
                    w.i("MicroMsg.MsgHandler", "setBackgroundAudioState ok");
                    a(iVar, "setBackgroundAudioState:ok", null);
                }
                return true;
            }
        }
        CharSequence charSequence2 = charSequence;
        w.i("MicroMsg.MsgHandler", "appId:%s", new Object[]{JZ});
        k.a(iVar.smM, false, null, JZ);
        str = (String) iVar.ozE.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bg.mA(str)) {
            Jd = null;
        } else {
            Jd = com.tencent.mm.plugin.webview.modelcache.p.Jd(str);
        }
        str2 = (String) iVar.ozE.get("src");
        str3 = (String) iVar.ozE.get("lowbandSrc");
        str4 = (String) iVar.ozE.get("title");
        str5 = (String) iVar.ozE.get("epname");
        str6 = (String) iVar.ozE.get("singer");
        str = (String) iVar.ozE.get("coverImgUrl");
        str7 = (String) iVar.ozE.get("webUrl");
        i = bg.getInt((String) iVar.ozE.get("startTime"), 0);
        str8 = (String) iVar.ozE.get("srcId");
        if (str != null) {
            str9 = str;
        } else {
            str9 = "";
        }
        parseBoolean = Boolean.parseBoolean((String) iVar.ozE.get("isLive"));
        w.i("MicroMsg.MsgHandler", "src : %s, title : %s, singer : %s, coverImgUrl : %s, webUrl : %s, isLive : %b, startTime:%d", new Object[]{str2, str4, str6, str9, str7, Boolean.valueOf(parseBoolean), Integer.valueOf(i)});
        if (bg.mA(str2)) {
        }
        w.e("MicroMsg.MsgHandler", "setBackgroundAudioState fail, src or title is null");
        a(iVar, "setBackgroundAudioState:fail", null);
        return true;
    }

    public final boolean dG(i iVar) {
        String str = (String) iVar.ozE.get("operationType");
        w.i("MicroMsg.MsgHandler", "doOperateBackgroundAudio(), optype:%s", new Object[]{str});
        String str2 = (String) iVar.ozE.get("appId");
        if (this.skw != null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = this.skw.getString("jsapi_args_appid");
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = this.skF.JZ(VD());
            }
        }
        k.a(iVar.smM, false, null, str2);
        if (!dH(iVar)) {
            w.e("MicroMsg.MsgHandler", "doOperateBackgroundAudio getMusicPermission is false");
            a(iVar, "operateBackgroundAudio:fail", null);
        } else if (bg.mA(str)) {
            w.e("MicroMsg.MsgHandler", "doOperateBackgroundAudio optype is empty");
            a(iVar, "operateBackgroundAudio:fail", null);
        } else {
            com.tencent.mm.sdk.b.a.urY.b(this.slh);
            if (str.equalsIgnoreCase("play")) {
                if (com.tencent.mm.am.c.HN()) {
                    a(iVar, "operateBackgroundAudio:ok", null);
                } else {
                    w.e("MicroMsg.MsgHandler", "operateBackgroundAudio play fail");
                    a(iVar, "operateBackgroundAudio:fail", null);
                }
            } else if (str.equalsIgnoreCase("resume")) {
                if (com.tencent.mm.am.c.HN()) {
                    a(iVar, "operateBackgroundAudio:ok", null);
                } else {
                    w.e("MicroMsg.MsgHandler", "operateBackgroundAudio resume fail");
                    a(iVar, "operateBackgroundAudio:fail", null);
                }
            } else if (str.equalsIgnoreCase("pause")) {
                if (com.tencent.mm.am.c.HO()) {
                    com.tencent.mm.am.b.HI();
                    a(iVar, "operateBackgroundAudio:ok", null);
                } else {
                    w.e("MicroMsg.MsgHandler", "operateBackgroundAudio pause fail");
                    a(iVar, "operateBackgroundAudio:fail", null);
                }
            } else if (str.equalsIgnoreCase("seek")) {
                int i = bg.getInt((String) iVar.ozE.get("currentTime"), -1);
                w.i("MicroMsg.MsgHandler", "currentTime:%d", new Object[]{Integer.valueOf(i)});
                if (i < 0) {
                    w.e("MicroMsg.MsgHandler", "currentTime is invalid!");
                    a(iVar, "operateBackgroundAudio:fail", null);
                } else if (com.tencent.mm.am.b.gi(i * 1000)) {
                    a(iVar, "operateBackgroundAudio:ok", null);
                } else {
                    w.e("MicroMsg.MsgHandler", "operateBackgroundAudio seek fail");
                    a(iVar, "operateBackgroundAudio:fail", null);
                }
            } else if (!str.equalsIgnoreCase("stop")) {
                w.e("MicroMsg.MsgHandler", "operateBackgroundAudio fail, invalid opeType");
                a(iVar, "operateBackgroundAudio:fail", null);
            } else if (com.tencent.mm.am.c.HP()) {
                a(iVar, "operateBackgroundAudio:ok", null);
            } else {
                w.e("MicroMsg.MsgHandler", "operateBackgroundAudio stop fail");
                a(iVar, "operateBackgroundAudio:fail", null);
            }
        }
        return true;
    }

    private boolean dH(i iVar) {
        Object JZ;
        String str;
        Object obj;
        boolean z;
        String str2;
        String str3;
        Object[] objArr;
        int i = 1;
        anf HL = com.tencent.mm.am.b.HL();
        CharSequence charSequence = (String) iVar.ozE.get("appId");
        if (this.skw != null) {
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = this.skw.getString("jsapi_args_appid");
            }
            if (TextUtils.isEmpty(charSequence)) {
                JZ = this.skF.JZ(VD());
                str = (String) iVar.ozE.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
                obj = null;
                if (!bg.mA(str)) {
                    obj = com.tencent.mm.plugin.webview.modelcache.p.Jd(str);
                }
                if (HL == null) {
                    str = HL.mtb;
                    String Jd = com.tencent.mm.plugin.webview.modelcache.p.Jd(HL.tRP);
                    String str4 = HL.tSb;
                    w.i("MicroMsg.MsgHandler", "app_id:%s, musicAppId:%s", new Object[]{JZ, str});
                    w.i("MicroMsg.MsgHandler", "domain: %s, songWebDomain: %s, jsWebDomain: %s， with no port", new Object[]{obj, Jd, str4});
                    if (TextUtils.isEmpty(JZ) && JZ.equalsIgnoreCase(str)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!TextUtils.isEmpty(obj) && obj.equalsIgnoreCase(Jd)) {
                        z = true;
                    }
                    if (!TextUtils.isEmpty(obj) && obj.equalsIgnoreCase(str4)) {
                        z = true;
                    }
                } else {
                    w.e("MicroMsg.MsgHandler", "currentWrapper is null");
                    z = false;
                }
                str2 = "MicroMsg.MsgHandler";
                str3 = "getMusicPermission hasPermmision:%d";
                objArr = new Object[1];
                if (!z) {
                    i = 0;
                }
                objArr[0] = Integer.valueOf(i);
                w.i(str2, str3, objArr);
                return z;
            }
        }
        CharSequence charSequence2 = charSequence;
        str = (String) iVar.ozE.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
        obj = null;
        if (bg.mA(str)) {
            obj = com.tencent.mm.plugin.webview.modelcache.p.Jd(str);
        }
        if (HL == null) {
            w.e("MicroMsg.MsgHandler", "currentWrapper is null");
            z = false;
        } else {
            str = HL.mtb;
            String Jd2 = com.tencent.mm.plugin.webview.modelcache.p.Jd(HL.tRP);
            String str42 = HL.tSb;
            w.i("MicroMsg.MsgHandler", "app_id:%s, musicAppId:%s", new Object[]{JZ, str});
            w.i("MicroMsg.MsgHandler", "domain: %s, songWebDomain: %s, jsWebDomain: %s， with no port", new Object[]{obj, Jd2, str42});
            if (TextUtils.isEmpty(JZ)) {
            }
            z = false;
            z = true;
            z = true;
        }
        str2 = "MicroMsg.MsgHandler";
        str3 = "getMusicPermission hasPermmision:%d";
        objArr = new Object[1];
        if (z) {
            i = 0;
        }
        objArr[0] = Integer.valueOf(i);
        w.i(str2, str3, objArr);
        return z;
    }
}
