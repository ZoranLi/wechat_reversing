package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.webkit.URLUtil;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.OpenWebview.Resp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStopPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiSendAppMessage;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.am;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.qqvideo.proxy.api.IUtils;
import com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.FindListener;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult.ImageData;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings.RenderPriority;
import com.tencent.smtt.sdk.WebSettings.TextSize;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebView.HitTestResult;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.smtt.sdk.ac;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wework.api.WWAPIFactory;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.Thread.State;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebViewUI extends MMActivity implements OnCreateContextMenuListener {
    private static final Pattern mnk = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    private static final Pattern mnl = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    private static final Set<String> rWS;
    private static final ArrayList<ab> sds = new ArrayList();
    private static RenderPriority sdy = RenderPriority.NORMAL;
    private static int sek = 0;
    private static IUtils sep = null;
    private String fFF = "";
    private String fUX;
    public volatile String fWY = null;
    private int fromScene;
    private int gaA;
    public ae handler;
    private int height;
    public com.tencent.mm.plugin.webview.stub.d iYF = null;
    public e iYG = null;
    com.tencent.mm.ui.tools.l iYI;
    String iYJ;
    int iYK;
    int iYL;
    com.tencent.mm.plugin.webview.d.g iYM;
    HitTestResult iYN;
    IX5WebViewBase.HitTestResult iYO;
    private com.tencent.mm.plugin.webview.d.g.c iYR = new com.tencent.mm.plugin.webview.d.g.c(this) {
        final /* synthetic */ WebViewUI seQ;

        {
            this.seQ = r1;
        }

        public final void pF(String str) {
            try {
                if (this.seQ.iYF != null) {
                    this.seQ.iYF.Jy(str);
                } else {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "viewCaptureCallback, invoker is null");
                }
            } catch (RemoteException e) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "recog failed");
            }
        }
    };
    private long jXw = 0;
    private long jgr = 0;
    public int jkQ;
    private String lUe;
    private ServiceConnection mgm = new ServiceConnection(this) {
        final /* synthetic */ WebViewUI seQ;

        {
            this.seQ = r1;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            boolean z = true;
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "edw onServiceConnected");
            if (this.seQ.oET == null) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "onServiceConnected, activity destroyed");
                return;
            }
            this.seQ.iYF = com.tencent.mm.plugin.webview.stub.d.a.V(iBinder);
            try {
                this.seQ.iYF.a(this.seQ.rXh, this.seQ.hashCode());
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "addCallback fail, ex = %s", new Object[]{e.getMessage()});
            }
            String str = "MicroMsg.WebViewUI";
            String str2 = "onServiceConnected, invoker == null ? %b";
            Object[] objArr = new Object[1];
            if (this.seQ.iYF != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            com.tencent.mm.sdk.platformtools.w.i(str, str2, objArr);
            if (this.seQ.iYF == null) {
                com.tencent.mm.sdk.platformtools.w.f("MicroMsg.WebViewUI", "service connect success, while invoker is null");
                this.seQ.finish();
                return;
            }
            this.seQ.axz();
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "edw onServiceDisconnected");
            if ((this.seQ.sel && WebViewUI.sek <= 0) || (!this.seQ.sel && WebViewUI.sek <= 1)) {
                com.tencent.mm.plugin.webview.d.b.c(this.seQ.iYF);
                com.tencent.mm.plugin.webview.modelcache.o oVar = a.rYq;
                for (int i = 0; i < oVar.rYo.size(); i++) {
                    oVar.rYo.valueAt(i);
                }
                oVar.rYo.clear();
                oVar.rYp.clear();
            }
            if (this.seQ.sel || this.seQ.sem || this.seQ.isFinishing()) {
                this.seQ.iYF = null;
                return;
            }
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "maybe mm process crash, try rebind service");
            this.seQ.bxW();
        }
    };
    private String mkT;
    private Map<String, Integer> mnT = new HashMap();
    public com.tencent.mm.ui.snackbar.b.b mnV = new com.tencent.mm.ui.snackbar.b.b(this) {
        final /* synthetic */ WebViewUI seQ;

        {
            this.seQ = r1;
        }

        public final void aAt() {
            try {
                this.seQ.iYF.favEditTag();
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "favorite edittag fail, ex = " + e.getMessage());
            }
        }
    };
    public boolean mna = true;
    private int mne = 0;
    private List<com.tencent.mm.plugin.webview.ui.tools.jsapi.b> mot = new ArrayList();
    private long mou = 0;
    private int networkType;
    public MMWebView oET;
    private boolean qyZ = true;
    public com.tencent.mm.plugin.webview.ui.tools.jsapi.d rVm = null;
    public ai rWq = new ai();
    private volatile String rXM;
    public com.tencent.mm.plugin.webview.stub.e rXh = new com.tencent.mm.plugin.webview.stub.e.a(this) {
        final /* synthetic */ WebViewUI seQ;

        {
            this.seQ = r1;
        }

        public final boolean m(int i, final Bundle bundle) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "callback, actionCode = " + i);
            final String string;
            final String string2;
            final boolean z;
            int i2;
            final String string3;
            final Map hashMap;
            final int i3;
            switch (i) {
                case 13:
                    if (bundle != null) {
                        bundle.putString("application_language", this.seQ.iYF.getLanguage());
                        this.seQ.sdR = new d(bundle);
                        break;
                    }
                    break;
                case 15:
                    string = bundle.getString("exdevice_device_id");
                    final boolean z2 = bundle.getBoolean("exdevice_is_complete");
                    final byte[] byteArray = bundle.getByteArray("exdevice_broadcast_data");
                    final boolean z3 = bundle.getBoolean("exdevice_is_lan_device");
                    this.seQ.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            if (this.seS.seQ.rVm != null) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.seS.seQ.rVm;
                                String str = string;
                                byte[] bArr = byteArray;
                                boolean z = z2;
                                boolean z2 = z3;
                                if (dVar.sjS) {
                                    String str2 = "MicroMsg.JsApiHandler";
                                    String str3 = "onScanWXDeviceResult: device id = %s, isCompleted = %s, %s";
                                    Object[] objArr = new Object[3];
                                    objArr[0] = str;
                                    objArr[1] = Boolean.valueOf(z);
                                    objArr[2] = Integer.valueOf(bArr == null ? 0 : bArr.length);
                                    com.tencent.mm.sdk.platformtools.w.i(str2, str3, objArr);
                                    if (bg.mA(str)) {
                                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.JsApiHandler", "parameter error!!!");
                                        return;
                                    }
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        JSONArray jSONArray = new JSONArray();
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("deviceId", str);
                                        com.tencent.mm.plugin.webview.ui.tools.a.b.byM();
                                        if (com.tencent.mm.plugin.webview.ui.tools.a.b.aS(bArr) || (bArr != null && z2)) {
                                            jSONObject2.put("base64BroadcastData", Base64.encodeToString(bArr, 2));
                                        }
                                        jSONArray.put(jSONObject2);
                                        jSONObject.put("devices", jSONArray);
                                        if (z) {
                                            jSONObject.put("isCompleted", "1");
                                        } else {
                                            jSONObject.put("isCompleted", "0");
                                        }
                                    } catch (Exception e) {
                                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.JsApiHandler", "Ex in onScanWXDeviceResult, %s", new Object[]{e.getMessage()});
                                    }
                                    try {
                                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.JsApiHandler", "hakon onScanWXDeviceResult, %s", new Object[]{com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onScanWXDeviceResult", jSONObject, dVar.sjU, dVar.sjV)});
                                        dVar.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + r0 + ")", null);
                                    } catch (Exception e2) {
                                        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.JsApiHandler", "onScanWXDeviceResult, %s", new Object[]{e2.getMessage()});
                                    }
                                    if (!z2) {
                                        com.tencent.mm.plugin.webview.ui.tools.a.b.byM().sgi = bArr;
                                        return;
                                    }
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.JsApiHandler", "onScanWXDeviceResult fail, not ready");
                                return;
                            }
                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "hakon can not call onScanWXDeviceResult, %s, %s", new Object[]{this.seS.seQ.rVm, this.seS.seQ.iYG});
                        }
                    });
                    break;
                case 16:
                    string2 = bundle.getString("exdevice_device_id");
                    final String string4 = bundle.getString("exdevice_brand_name");
                    final byte[] byteArray2 = bundle.getByteArray("exdevice_data");
                    this.seQ.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            if (this.seS.seQ.rVm != null) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.seS.seQ.rVm;
                                String str = string2;
                                byte[] bArr = byteArray2;
                                String str2 = string4;
                                if (dVar.sjS) {
                                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.JsApiHandler", "onReceiveDataFromWXDevice: device id = %s, brandName = %s", new Object[]{str, str2});
                                    if (bg.mA(str) || bg.mA(str2) || bArr == null) {
                                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.JsApiHandler", "parameter error!!!");
                                        return;
                                    }
                                    Map hashMap = new HashMap();
                                    hashMap.put("deviceId", str);
                                    hashMap.put("base64Data", Base64.encodeToString(bArr, 2));
                                    af.v(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass47(dVar, com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onReceiveDataFromWXDevice", hashMap, dVar.sjU, dVar.sjV)));
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.JsApiHandler", "onReceiveDataFromWXDevice fail, not ready");
                            }
                        }
                    });
                    break;
                case 17:
                    string2 = bundle.getString("exdevice_device_id");
                    final boolean z4 = bundle.getBoolean("exdevice_is_bound");
                    this.seQ.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            if (this.seS.seQ.rVm != null) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.seS.seQ.rVm;
                                String str = string2;
                                boolean z = z4;
                                if (dVar.sjS) {
                                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange: device id = %s, isBound = %s", new Object[]{str, Boolean.valueOf(z)});
                                    if (bg.mA(str)) {
                                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.JsApiHandler", "parameter error!!!");
                                        return;
                                    }
                                    Map hashMap = new HashMap();
                                    hashMap.put("deviceId", str);
                                    if (z) {
                                        hashMap.put("state", "bind");
                                    } else {
                                        hashMap.put("state", "unbind");
                                    }
                                    af.v(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass48(dVar, com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onWXDeviceBindStateChange", hashMap, dVar.sjU, dVar.sjV)));
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange fail, not ready");
                            }
                        }
                    });
                    break;
                case 18:
                    z = bundle.getBoolean("exdevice_bt_state");
                    this.seQ.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            if (this.seS.seQ.rVm != null) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.seS.seQ.rVm;
                                boolean z = z;
                                if (dVar.sjS) {
                                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.JsApiHandler", "onWXDeviceBTStateChange: state = %s", new Object[]{Boolean.valueOf(z)});
                                    Map hashMap = new HashMap();
                                    if (z) {
                                        hashMap.put("state", "on");
                                    } else {
                                        hashMap.put("state", "off");
                                    }
                                    af.v(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass49(dVar, com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onWXDeviceBluetoothStateChange", hashMap, dVar.sjU, dVar.sjV)));
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.JsApiHandler", "onWXDeviceBTStateChange fail, not ready");
                            }
                        }
                    });
                    break;
                case 26:
                case 27:
                case 28:
                case JsApiChooseImage.CTRL_INDEX /*29*/:
                case 30:
                case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                case 32:
                case 33:
                case 34:
                case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
                case 36:
                case JsApiGetLocation.CTRL_INDEX /*37*/:
                case 38:
                case 39:
                case 40:
                case com.tencent.mm.plugin.game.gamewebview.jsapi.biz.v.CTRL_BYTE /*41*/:
                case 42:
                case 43:
                case 44:
                case 45:
                case JsApiGetMusicPlayerState.CTRL_INDEX /*46*/:
                    this.seQ.s(i, bundle);
                    break;
                case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    z = bundle.getBoolean("exdevice_lan_state");
                    this.seQ.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            if (this.seS.seQ.rVm != null) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.seS.seQ.rVm;
                                boolean z = z;
                                if (dVar.sjS) {
                                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.JsApiHandler", "onWXDeviceLanStateChange: state = %s", new Object[]{Boolean.valueOf(z)});
                                    Map hashMap = new HashMap();
                                    if (z) {
                                        hashMap.put("state", "on");
                                    } else {
                                        hashMap.put("state", "off");
                                    }
                                    af.v(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass50(dVar, com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onWXDeviceLanStateChange", hashMap, dVar.sjU, dVar.sjV)));
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.JsApiHandler", "onWXDeviceLanStateChange fail, not ready");
                            }
                        }
                    });
                    break;
                case 48:
                    String[] stringArray = bundle.getStringArray("msgIds");
                    String[] stringArray2 = bundle.getStringArray("contents");
                    String[] stringArray3 = bundle.getStringArray("senders");
                    int[] intArray = bundle.getIntArray("msgTypes");
                    int[] intArray2 = bundle.getIntArray("msgTimes");
                    final JSONArray jSONArray = new JSONArray();
                    int length = stringArray.length;
                    for (i2 = 0; i2 < length; i2++) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("newMsgId", stringArray[i2]);
                            jSONObject.put("content", stringArray2[i2]);
                            jSONObject.put("sender", stringArray3[i2]);
                            jSONObject.put("msgType", intArray[i2]);
                            jSONObject.put("msgTime", intArray2[i2]);
                            jSONArray.put(jSONObject);
                        } catch (JSONException e) {
                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "GetMsgProofItems exception " + e.getMessage());
                        }
                    }
                    this.seQ.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            if (this.seS.seQ.rVm != null) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.seS.seQ.rVm;
                                JSONArray jSONArray = jSONArray;
                                if (jSONArray == null) {
                                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, not ready");
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.JsApiHandler", "onGetMsgProofItems success, ready");
                                Map hashMap = new HashMap();
                                hashMap.put("msgs", jSONArray);
                                af.v(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass38(dVar, com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onGetMsgProofItems", hashMap, dVar.sjU, dVar.sjV)));
                            }
                        }
                    });
                    break;
                case 60:
                case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                case 62:
                case 119:
                case 120:
                case 121:
                case 122:
                case 123:
                case 124:
                case 125:
                case 126:
                case 127:
                case FileUtils.S_IWUSR /*128*/:
                case 130:
                case 100001:
                    this.seQ.p(i, bundle);
                    break;
                case PlayerException.EXCEPTION_IN_SETDATASOURCE /*90*/:
                    string2 = bundle.getString("webview_network_type");
                    this.seQ.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            if (this.seS.seQ.rVm != null) {
                                this.seS.seQ.rVm.Kd(string2);
                            }
                        }
                    });
                    break;
                case MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED /*1001*/:
                    if (!this.seQ.isFinishing()) {
                        this.seQ.finish();
                        break;
                    }
                    break;
                case MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED /*1002*/:
                    this.seQ.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            if (this.seS.seQ.rVm != null && this.seS.seQ.iYG != null && this.seS.seQ.iYG.bxQ() != null && this.seS.seQ.iYG.bxQ().nw(42)) {
                                this.seS.seQ.rVm.f(bundle, "download_succ");
                            }
                        }
                    });
                    break;
                case MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED /*1003*/:
                    this.seQ.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            if (this.seS.seQ.rVm != null && this.seS.seQ.iYG != null && this.seS.seQ.iYG.bxQ() != null && this.seS.seQ.iYG.bxQ().nw(42)) {
                                this.seS.seQ.rVm.f(bundle, "download_fail");
                            }
                        }
                    });
                    break;
                case MMBitmapFactory.ERROR_BEGIN_SAMPLE_FAILED /*1004*/:
                    string2 = bundle.getString("exdevice_device_id");
                    i2 = bundle.getInt("exdevice_on_state_change_state");
                    final Boolean valueOf = Boolean.valueOf(bundle.getBoolean("exdevice_inner_call"));
                    this.seQ.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            boolean z = false;
                            if (this.seS.seQ.rVm != null && this.seS.seQ.iYG != null && this.seS.seQ.iYG.bxQ() != null) {
                                this.seS.seQ.iYG.bxQ();
                                JsapiPermissionWrapper.bHm();
                                this.seS.seQ.rVm.cg(string2, i2);
                            } else if (this.seS.seQ.rVm == null || !valueOf.booleanValue()) {
                                String str = "MicroMsg.WebViewUI";
                                String str2 = "something null, %s, %s";
                                Object[] objArr = new Object[2];
                                objArr[0] = Boolean.valueOf(this.seS.seQ.rVm == null);
                                if (this.seS.seQ.iYG == null) {
                                    z = true;
                                }
                                objArr[1] = Boolean.valueOf(z);
                                com.tencent.mm.sdk.platformtools.w.w(str, str2, objArr);
                            } else {
                                this.seS.seQ.rVm.cg(string2, i2);
                            }
                        }
                    });
                    break;
                case MMBitmapFactory.ERROR_UNSUPPORT_IMAGE_FORMAT /*1006*/:
                    if (this.seQ.rVm != null) {
                        this.seQ.handler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass12 seS;

                            public final void run() {
                                boolean z = false;
                                byte[] byteArray = bundle.getByteArray("jsapi_control_bytes");
                                if (byteArray == null || this.seS.seQ.iYG == null || this.seS.seQ.iYG.bxQ() == null) {
                                    String str = "MicroMsg.WebViewUI";
                                    String str2 = "has JSAPI_CONTROL_BYTES %b, has wvPerm %b";
                                    Object[] objArr = new Object[2];
                                    objArr[0] = Boolean.valueOf(byteArray != null);
                                    if (this.seS.seQ.iYG != null) {
                                        z = true;
                                    }
                                    objArr[1] = Boolean.valueOf(z);
                                    com.tencent.mm.sdk.platformtools.w.e(str, str2, objArr);
                                } else {
                                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "update control bytes, %d", new Object[]{Integer.valueOf(byteArray.length)});
                                    this.seS.seQ.iYG.bxQ().sZd = byteArray;
                                }
                                if (this.seS.seQ.rVm != null) {
                                    this.seS.seQ.rVm.bzk();
                                }
                            }
                        });
                        break;
                    }
                    break;
                case MMBitmapFactory.ERROR_IMAGE_SIZE_IS_TOO_LARGE /*1007*/:
                    final long j = bundle.getLong("download_manager_downloadid");
                    final int i4 = bundle.getInt("download_manager_progress");
                    string3 = bundle.getString("download_manager_appid", "");
                    this.seQ.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            if (this.seS.seQ.rVm != null && this.seS.seQ.iYG != null && this.seS.seQ.iYG.bxQ() != null && this.seS.seQ.iYG.bxQ().nw(42)) {
                                this.seS.seQ.rVm.f(string3, j, i4);
                            }
                        }
                    });
                    break;
                case MMBitmapFactory.ERROR_ILLEGAL_IMAGE_SIZE /*1008*/:
                    this.seQ.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            if (this.seS.seQ.rVm != null && this.seS.seQ.iYG != null && this.seS.seQ.iYG.bxQ() != null && this.seS.seQ.iYG.bxQ().nw(42)) {
                                this.seS.seQ.rVm.f(bundle, "download_removed");
                            }
                        }
                    });
                    break;
                case MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK /*2002*/:
                    hashMap = new HashMap();
                    hashMap.put("err_msg", bundle.getString("playResult"));
                    hashMap.put("localId", bundle.getString("localId"));
                    this.seQ.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            if (this.seS.seQ.rVm != null) {
                                this.seS.seQ.rVm.V(hashMap);
                            }
                        }
                    });
                    break;
                case MMBitmapFactory.ERROR_ILLEGAL_IDATA_CHUNK /*2003*/:
                    string2 = bundle.getString("webview_jssdk_file_item_local_id");
                    i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                    this.seQ.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            if (this.seS.seQ.rVm != null) {
                                this.seS.seQ.rVm.ch(string2, i2);
                            }
                        }
                    });
                    break;
                case 2004:
                    string2 = bundle.getString("webview_jssdk_file_item_local_id");
                    i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                    this.seQ.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            if (this.seS.seQ.rVm != null) {
                                this.seS.seQ.rVm.ci(string2, i2);
                            }
                        }
                    });
                    break;
                case 2005:
                    string2 = bundle.getString("webview_jssdk_file_item_local_id");
                    i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                    this.seQ.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            if (this.seS.seQ.rVm != null) {
                                this.seS.seQ.rVm.cj(string2, i2);
                            }
                        }
                    });
                    break;
                case 2006:
                    string2 = bundle.getString("webview_jssdk_file_item_local_id");
                    i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                    this.seQ.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            if (this.seS.seQ.rVm != null) {
                                this.seS.seQ.rVm.ck(string2, i2);
                            }
                        }
                    });
                    break;
                case 2007:
                    this.seQ.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        {
                            this.seS = r1;
                        }

                        public final void run() {
                            this.seS.seQ.zj(R.l.fmy);
                        }
                    });
                    break;
                case 2008:
                    hashMap = new HashMap();
                    hashMap.put("localId", bundle.getString("localId"));
                    hashMap.put("err_msg", bundle.getString("recordResult"));
                    this.seQ.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            this.seS.seQ.SE(null);
                            if (this.seS.seQ.rVm != null) {
                                this.seS.seQ.rVm.W(hashMap);
                            }
                        }
                    });
                    break;
                case 2009:
                    this.seQ.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        {
                            this.seS = r1;
                        }

                        public final void run() {
                            this.seS.seQ.SE(null);
                        }
                    });
                    break;
                case 2010:
                    string2 = bundle.getString("webview_jssdk_file_item_local_id");
                    i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                    this.seQ.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            if (this.seS.seQ.rVm != null) {
                                this.seS.seQ.rVm.cl(string2, i2);
                            }
                        }
                    });
                    break;
                case 2011:
                    string2 = bundle.getString("webview_jssdk_file_item_local_id");
                    i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                    this.seQ.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            if (this.seS.seQ.rVm != null) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.seS.seQ.rVm;
                                String str = string2;
                                int i = i2;
                                if (dVar.sjS) {
                                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.JsApiHandler", "onMediaFileUploadProgress, local id : %s, percent : %d", new Object[]{str, Integer.valueOf(i)});
                                    Map hashMap = new HashMap();
                                    hashMap.put("localId", str);
                                    hashMap.put("percent", Integer.valueOf(i));
                                    af.v(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass5(dVar, com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a(com.tencent.mm.plugin.game.gamewebview.b.a.e.NAME, hashMap, dVar.sjU, dVar.sjV)));
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.JsApiHandler", "onMediaFileUploadProgress fail, not ready");
                            }
                        }
                    });
                    break;
                case 2100:
                    string = bundle.getString("background_audio_state_player_state");
                    final int i5 = bundle.getInt("background_audio_state_player_duration");
                    final String string5 = bundle.getString("background_audio_state_player_src");
                    i3 = bundle.getInt("background_audio_state_player_err_code");
                    final String string6 = bundle.getString("background_audio_state_player_err_msg");
                    final String string7 = bundle.getString("background_audio_state_player_src_id");
                    this.seQ.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            if (this.seS.seQ.rVm != null) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.seS.seQ.rVm;
                                String str = string;
                                int i = i5;
                                String str2 = string5;
                                int i2 = i3;
                                String str3 = string6;
                                String str4 = string7;
                                if (dVar.sjS) {
                                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.JsApiHandler", "onBackgroundAudioStateChange, state : %s, duration : %d, src:%s, errCode:%d, errMsg:%s, srcId:%s", new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2), str3, str4});
                                    Map hashMap = new HashMap();
                                    hashMap.put("state", str);
                                    hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(i));
                                    hashMap.put("src", str2);
                                    hashMap.put("errCode", Integer.valueOf(i2));
                                    hashMap.put("errMsg", str3);
                                    hashMap.put("srcId ", str4);
                                    af.v(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass11(dVar, com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onBackgroundAudioStateChange", hashMap, dVar.sjU, dVar.sjV)));
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.JsApiHandler", "onBackgroundAudioStateChange fail, not ready");
                            }
                        }
                    });
                    break;
                case 4007:
                    final int i6 = bundle.getInt("nfc_key_on_touch_errcode", 0);
                    this.seQ.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            if (this.seS.seQ.rVm != null) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.seS.seQ.rVm;
                                int i = i6;
                                if (dVar.sjS) {
                                    Map hashMap = new HashMap();
                                    hashMap.put("errCode", Integer.valueOf(i));
                                    af.v(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass13(dVar, com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onNfcTouch", hashMap, dVar.sjU, dVar.sjV)));
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.JsApiHandler", "onNfcTouch fail, not ready");
                            }
                        }
                    });
                    break;
                case 40001:
                    string2 = bundle.getString("err_msg");
                    this.seQ.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            if (this.seS.seQ.rVm != null) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.seS.seQ.rVm;
                                String str = string2;
                                Map hashMap = new HashMap();
                                hashMap.put("err_msg", str);
                                af.v(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass17(dVar, com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onBeaconMonitoring", hashMap, dVar.sjU, dVar.sjV)));
                            }
                        }
                    });
                    break;
                case 40002:
                    string3 = bundle.getString("uuid");
                    final int i7 = bundle.getInt("major");
                    i3 = bundle.getInt("minor");
                    final double d = bundle.getDouble("accuracy");
                    final double d2 = bundle.getDouble("rssi");
                    final float f = bundle.getFloat("heading");
                    this.seQ.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            if (this.seS.seQ.rVm != null) {
                                this.seS.seQ.rVm.a(string3, i7, i3, d, d2, f);
                            }
                        }
                    });
                    break;
                case 80001:
                case 80002:
                    this.seQ.r(i, bundle);
                    break;
                default:
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "undefine action code!!!");
                    break;
            }
            return true;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(final com.tencent.mm.plugin.webview.stub.c r4) {
            /*
            r3 = this;
            r0 = 0;
            r1 = 1;
            r2 = r3.seQ;
            r2 = r2.sdA;
            r2 = r2.sfT;
            if (r2 <= 0) goto L_0x003e;
        L_0x000a:
            r2 = r1;
        L_0x000b:
            if (r2 != 0) goto L_0x002f;
        L_0x000d:
            r2 = r3.seQ;
            r2 = r2.sdB;
            r2 = r2.sfU;
            if (r2 <= 0) goto L_0x0040;
        L_0x0015:
            r2 = r1;
        L_0x0016:
            if (r2 != 0) goto L_0x002f;
        L_0x0018:
            r2 = r3.seQ;
            r2 = r2.sdC;
            r2 = r2.sfV;
            if (r2 <= 0) goto L_0x0021;
        L_0x0020:
            r0 = r1;
        L_0x0021:
            if (r0 != 0) goto L_0x002f;
        L_0x0023:
            r0 = r3.seQ;
            r0 = r0.seM;
            r0 = r0.bwl();
            if (r0 == 0) goto L_0x003d;
        L_0x002f:
            r0 = r3.seQ;
            r0 = r0.handler;
            r2 = new com.tencent.mm.plugin.webview.ui.tools.WebViewUI$12$21;
            r2.<init>(r3, r4);
            r0.post(r2);
        L_0x003d:
            return r1;
        L_0x003e:
            r2 = r0;
            goto L_0x000b;
        L_0x0040:
            r2 = r0;
            goto L_0x0016;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.12.a(com.tencent.mm.plugin.webview.stub.c):boolean");
        }

        public final boolean vY(final int i) {
            this.seQ.handler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass12 seS;

                public final void run() {
                    this.seS.seQ.setProgressBarIndeterminateVisibility(false);
                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "[cpan] set title pb visibility:%d", new Object[]{Integer.valueOf(i)});
                    if (i != 0) {
                        this.seS.seQ.scM.finish();
                    } else if (!this.seS.seQ.sdY && !this.seS.seQ.sea) {
                        this.seS.seQ.scM.start();
                    }
                }
            });
            return true;
        }

        public final boolean a(String str, String str2, Bundle bundle, boolean z) {
            if (this.seQ.rVm != null) {
                final String str3 = str;
                final String str4 = str2;
                final Bundle bundle2 = bundle;
                final boolean z2 = z;
                this.seQ.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ AnonymousClass12 seS;

                    public final void run() {
                        this.seS.seQ.rVm.a(str3, str4, com.tencent.mm.plugin.webview.ui.tools.jsapi.i.W(bundle2), z2);
                    }
                });
            }
            return false;
        }

        public final String bxj() {
            return this.seQ.fWY;
        }

        public final String VD() {
            return this.seQ.azN();
        }

        public final String bxk() {
            return this.seQ.getIntent().getStringExtra("srcUsername");
        }

        public final void iN(final boolean z) {
            final boolean booleanExtra = this.seQ.getIntent().getBooleanExtra("forceHideShare", false);
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "[cpan] setShareBtnVisible:%d visible:%b  forceHideShare:%b", new Object[]{Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(z), Boolean.valueOf(booleanExtra)});
            this.seQ.handler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass12 seS;

                public final void run() {
                    if (booleanExtra) {
                        if (!(this.seS.seQ.oET == null || bg.mA(this.seS.seQ.oET.getUrl()))) {
                            this.seS.seQ.sdM.put(this.seS.seQ.oET.getUrl(), Boolean.valueOf(false));
                        }
                        this.seS.seQ.iS(false);
                        return;
                    }
                    if (!(this.seS.seQ.oET == null || bg.mA(this.seS.seQ.oET.getUrl()))) {
                        this.seS.seQ.sdM.put(this.seS.seQ.oET.getUrl(), Boolean.valueOf(z));
                    }
                    this.seS.seQ.iS(z);
                }
            });
        }

        public final void iO(final boolean z) {
            this.seQ.handler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass12 seS;

                public final void run() {
                    this.seS.seQ.iT(z);
                }
            });
        }

        public final void bxl() {
            if (this.seQ.rVm != null) {
                this.seQ.rVm.bxl();
            }
        }

        public final void M(Bundle bundle) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "IUIController, closeWindow");
            if (bundle != null) {
                Intent intent = new Intent();
                intent.putExtra("result_data", bundle);
                this.seQ.setResult(-1, intent);
            }
            this.seQ.finish();
        }

        public final void Jn(String str) {
            int i = 0;
            try {
                i = bg.getInt(str, 0);
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "setFontSizeCb, ex = " + e.getMessage());
            }
            if (this.seQ.oET == null) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "setFontSizeCb fail, viewWV is null");
            } else {
                this.seQ.handler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass12 seS;

                    public final void run() {
                        this.seS.seQ.wu(i);
                    }
                });
            }
        }

        public final void bxm() {
            if (this.seQ.rVm != null) {
                this.seQ.rVm.bxm();
            }
        }

        public final void e(String str, final String str2, int i, int i2) {
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "result: " + str2);
            if (this.seQ.iYM != null && str != null && str.equals(this.seQ.iYM.rZF)) {
                if (this.seQ.iYM != null) {
                    this.seQ.iYM.bxd();
                }
                this.seQ.iYK = i;
                this.seQ.iYL = i2;
                if (str2 != null && this.seQ.iYI != null) {
                    this.seQ.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            if (this.seS.seQ.oET != null) {
                                this.seS.seQ.iYJ = str2;
                                this.seS.seQ.iYI.b(this.seS.seQ.oET, new OnCreateContextMenuListener(this) {
                                    final /* synthetic */ AnonymousClass28 sfm;

                                    {
                                        this.sfm = r1;
                                    }

                                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                                        if (this.sfm.seS.seQ.iYN != null) {
                                            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "show webkit menu");
                                            this.sfm.seS.seQ.a(contextMenu, this.sfm.seS.seQ.iYN);
                                            this.sfm.seS.seQ.iYN = null;
                                        } else if (this.sfm.seS.seQ.iYO != null) {
                                            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "show IX5 menu");
                                            this.sfm.seS.seQ.a(contextMenu, this.sfm.seS.seQ.iYO);
                                            this.sfm.seS.seQ.iYO = null;
                                        }
                                    }
                                }, null);
                                this.seS.seQ.iYI.blb();
                            }
                        }
                    });
                }
            }
        }

        public final void n(final int i, final Bundle bundle) {
            this.seQ.handler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass12 seS;

                public final void run() {
                    if (this.seS.seQ.oET != null) {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "setMenuItemsVisible, actionCode = " + i);
                        Set<Object> hashSet = new HashSet();
                        if (i == 3003 || i == 3004) {
                            hashSet.add("menuItem:share:brand");
                            hashSet.add("menuItem:share:appMessage");
                            hashSet.add("menuItem:share:dataMessage");
                            hashSet.add("menuItem:share:timeline");
                            hashSet.add("menuItem:favorite");
                            hashSet.add("menuItem:profile");
                            hashSet.add("menuItem:addContact");
                            hashSet.add("menuItem:copyUrl");
                            hashSet.add("menuItem:openWithSafari");
                            hashSet.add("menuItem:share:email");
                            hashSet.add("menuItem:delete");
                            hashSet.add("menuItem:editTag");
                            hashSet.add("menuItem:readMode");
                            hashSet.add("menuItem:originPage");
                            hashSet.add("menuItem:share:qq");
                            hashSet.add("menuItem:share:weiboApp");
                            hashSet.add("menuItem:share:QZone");
                            hashSet.add("menuItem:share:Facebook");
                            hashSet.add("menuItem:share:enterprise");
                            hashSet.add("menuItem:share:wework");
                            hashSet.add("menuItem:share:weread");
                            hashSet.add("menuItem:addShortcut");
                        } else if (bundle == null) {
                            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "setMenuItemsVisible data is null.");
                            return;
                        } else {
                            Collection stringArrayList = bundle.getStringArrayList("menu_item_list");
                            if (stringArrayList == null || stringArrayList.size() == 0) {
                                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "setMenuItemsVisible menuItems is null or nil.");
                                return;
                            }
                            hashSet.addAll(stringArrayList);
                            hashSet.remove("menuItem:exposeArticle");
                            hashSet.remove("menuItem:setFont");
                            hashSet.remove("menuItem:keepTop");
                            hashSet.remove("menuItem:cancelKeepTop");
                            hashSet.remove("menuItem:profile");
                            hashSet.remove("menuItem:addContact");
                            hashSet.remove("menuItem:refresh");
                        }
                        String url = this.seS.seQ.oET.getUrl();
                        SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) this.seS.seQ.seE.get(url);
                        switch (i) {
                            case 3001:
                            case 3003:
                                SparseBooleanArray sparseBooleanArray2;
                                if (sparseBooleanArray == null) {
                                    sparseBooleanArray = new SparseBooleanArray();
                                    this.seS.seQ.seE.put(url, sparseBooleanArray);
                                    sparseBooleanArray2 = sparseBooleanArray;
                                } else {
                                    sparseBooleanArray2 = sparseBooleanArray;
                                }
                                for (Object obj : hashSet) {
                                    int a = bg.a((Integer) this.seS.seQ.mnT.get(obj), -1);
                                    if (a >= 0) {
                                        sparseBooleanArray2.put(a, true);
                                    }
                                }
                                return;
                            case 3002:
                            case 3004:
                                if (sparseBooleanArray != null) {
                                    for (Object obj2 : hashSet) {
                                        int a2 = bg.a((Integer) this.seS.seQ.mnT.get(obj2), -1);
                                        if (a2 >= 0) {
                                            sparseBooleanArray.delete(a2);
                                        }
                                    }
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                }
            });
        }

        public final void dQ(final String str, String str2) {
            this.seQ.handler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass12 seS;

                public final void run() {
                    if (bg.mA(this.seS.seQ.oET.getUrl())) {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "setPageOwner, null url");
                        return;
                    }
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "setPageOwner, userName = " + str);
                    this.seS.seQ.sdN.put(this.seS.seQ.oET.getUrl(), str);
                }
            });
        }

        public final Bundle d(int i, final Bundle bundle) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "invokeAsResult, actionCode = " + i);
            final Bundle bundle2 = new Bundle();
            Intent intent;
            int a;
            final String string;
            final String string2;
            final boolean z;
            boolean z2;
            CharSequence bPV;
            String VD;
            int init;
            switch (i) {
                case 11:
                    this.seQ.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        {
                            this.seS = r1;
                        }

                        public final void run() {
                            if (this.seS.seQ.sdS != null && this.seS.seQ.sdS.isShowing()) {
                                this.seS.seQ.sdS.dismiss();
                            }
                        }
                    });
                    break;
                case 12:
                    this.seQ.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        {
                            this.seS = r1;
                        }

                        public final void run() {
                            this.seS.seQ.sdR = null;
                        }
                    });
                    break;
                case 18:
                    bundle2.putString("KPublisherId", this.seQ.fUX);
                    intent = this.seQ.getIntent();
                    if (intent != null) {
                        a = this.seQ.JS(this.seQ.getIntent().getStringExtra("geta8key_username"));
                        bundle2.putString("preChatName", intent.getStringExtra("preChatName"));
                        bundle2.putInt("preMsgIndex", intent.getIntExtra("preMsgIndex", 0));
                        bundle2.putString("prePublishId", intent.getStringExtra("prePublishId"));
                        bundle2.putString("preUsername", intent.getStringExtra("preUsername"));
                        bundle2.putInt("getA8KeyScene", a);
                        bundle2.putString("referUrl", this.seQ.rXM);
                        break;
                    }
                    break;
                case 22:
                    bundle2.putInt("pay_channel", this.seQ.getIntent().getIntExtra("pay_channel", -1));
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "key value: pay channel(%d)", new Object[]{Integer.valueOf(this.seQ.getIntent().getIntExtra("pay_channel", -1))});
                    break;
                case 25:
                    bundle2.putInt("scene", this.seQ.getIntent().getIntExtra("scene", -1));
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "Key value: Scene(%d)", new Object[]{Integer.valueOf(this.seQ.getIntent().getIntExtra("scene", 0))});
                    break;
                case 33:
                    intent = this.seQ.getIntent();
                    if (intent != null) {
                        bundle2.putString("publishIdPrefix", intent.getStringExtra("publishIdPrefix"));
                        bundle2.putString("reportSessionId", intent.getStringExtra("reportSessionId"));
                        break;
                    }
                    break;
                case 34:
                    this.seQ.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        {
                            this.seS = r1;
                        }

                        public final void run() {
                            WebViewUI.p(this.seS.seQ);
                        }
                    });
                    break;
                case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
                    this.seQ.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        {
                            this.seS = r1;
                        }

                        public final void run() {
                            this.seS.seQ.sez.startLoading();
                        }
                    });
                    break;
                case 36:
                    this.seQ.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        {
                            this.seS = r1;
                        }

                        public final void run() {
                            this.seS.seQ.sez.stopLoading();
                        }
                    });
                    break;
                case JsApiGetLocation.CTRL_INDEX /*37*/:
                    string = bundle.getString("show_kb_placeholder");
                    a = bundle.getInt("show_kb_max_length");
                    this.seQ.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            this.seS.seQ.ce(string, a);
                        }
                    });
                    break;
                case 38:
                    if (bundle.getInt("webview_disable_bounce_scroll_top", 0) > 0) {
                        this.seQ.runOnUiThread(new Runnable(this) {
                            final /* synthetic */ AnonymousClass12 seS;

                            {
                                this.seS = r1;
                            }

                            public final void run() {
                                this.seS.seQ.sez.iQ(true);
                            }
                        });
                        break;
                    }
                    break;
                case 39:
                    this.seQ.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        {
                            this.seS = r1;
                        }

                        public final void run() {
                            WebViewUI.q(this.seS.seQ);
                        }
                    });
                    break;
                case 43:
                    string = bundle.getString("set_page_title_text");
                    a = d.cd(bundle.getString("set_page_title_color"), this.seQ.getResources().getColor(R.e.aSC));
                    this.seQ.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            if (this.seS.seQ.qyZ) {
                                if (string != null) {
                                    this.seS.seQ.qP(string);
                                }
                                this.seS.seQ.zh(a);
                            }
                        }
                    });
                    break;
                case 44:
                    Bitmap bitmap;
                    string2 = bundle.getString("set_navigation_bar_buttons_text");
                    string = bundle.getString("set_navigation_bar_buttons_icon_data");
                    z = bundle.getBoolean("set_navigation_bar_buttons_hide_right_button", false);
                    if (bg.mA(string)) {
                        bitmap = null;
                    } else {
                        try {
                            bitmap = d.JI(string);
                        } catch (Exception e) {
                            bitmap = null;
                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "setNavigationBarButtons, decode base64 image, exception = %s", new Object[]{e});
                        }
                    }
                    final int cd = d.cd(bundle.getString("set_navigation_bar_buttons_left_text_color"), -1);
                    this.seQ.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            if (z) {
                                this.seS.seQ.iV(true);
                                return;
                            }
                            Boolean bool = null;
                            String azN = this.seS.seQ.azN();
                            if (!bg.mA(azN)) {
                                bool = (Boolean) this.seS.seQ.sdP.get(azN);
                            }
                            this.seS.seQ.iV(Boolean.valueOf(bool == null ? false : bool.booleanValue()).booleanValue());
                            if (bitmap != null && !bitmap.isRecycled()) {
                                this.seS.seQ.b(string2, new BitmapDrawable(this.seS.seQ.getResources(), bitmap));
                            } else if (!bg.mA(string2)) {
                                this.seS.seQ.a(0, string2, new OnMenuItemClickListener(this) {
                                    final /* synthetic */ AnonymousClass42 sfr;

                                    {
                                        this.sfr = r1;
                                    }

                                    public final boolean onMenuItemClick(MenuItem menuItem) {
                                        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "click item: %s", new Object[]{Integer.valueOf(menuItem.getItemId())});
                                        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.sfr.seS.seQ.rVm;
                                        if (dVar.sjS) {
                                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick success, ready");
                                            dVar.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onNavigationBarRightButtonClick", new HashMap(), dVar.sjU, dVar.sjV) + ")", null);
                                        } else {
                                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.JsApiHandler", "onNavigationBarRightButtonClick fail, not ready");
                                        }
                                        return false;
                                    }
                                });
                            }
                            this.seS.seQ.wq(cd);
                        }
                    });
                    break;
                case 45:
                    this.seQ.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        {
                            this.seS = r1;
                        }

                        public final void run() {
                            this.seS.seQ.byc();
                        }
                    });
                    break;
                case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    this.seQ.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        {
                            this.seS = r1;
                        }

                        public final void run() {
                            this.seS.seQ.sez.bxS();
                        }
                    });
                    break;
                case 48:
                case 49:
                    break;
                case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                    this.seQ.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            this.seS.seQ.R(bundle);
                        }
                    });
                    break;
                case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
                    z2 = bundle.getBoolean("add_shortcut_status");
                    if (this.seQ.rVm != null) {
                        this.seQ.rVm.iX(z2);
                        break;
                    }
                    break;
                case 71:
                    if (bundle.getString("enterprise_action").equals("enterprise_get_context_bizchat")) {
                        bundle2.putString("enterprise_context_biz", this.seQ.getIntent().getStringExtra("enterprise_biz_name"));
                        bundle2.putLong("enterprise_context_bizchatid", this.seQ.getIntent().getLongExtra("biz_chat_chat_id", -1));
                        break;
                    }
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.q.CTRL_INDEX /*72*/:
                    this.seQ.sez.wm(d.cd(bundle.getString("key_set_bounce_background_color"), this.seQ.getResources().getColor(R.e.aWs)));
                    break;
                case com.tencent.mm.plugin.appbrand.jsapi.share.b.CTRL_INDEX /*73*/:
                    intent = this.seQ.getIntent();
                    if (bundle != null) {
                        switch (bundle.getInt("scene")) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case JsApiGetLocation.CTRL_INDEX /*37*/:
                            case 45:
                                bundle2.putStringArrayList("content", intent.getStringArrayListExtra("k_outside_expose_proof_item_list"));
                                break;
                            case 33:
                                bundle2.putString("newMsgId", String.valueOf(intent.getLongExtra("k_expose_msg_id", 0)));
                                break;
                            case 34:
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("<exposecontent>");
                                stringBuilder.append("<weburl>");
                                if (intent.getStringExtra("k_expose_current_url") != null) {
                                    stringBuilder.append(intent.getStringExtra("k_expose_current_url"));
                                }
                                stringBuilder.append("</weburl>");
                                stringBuilder.append("<webscence>");
                                stringBuilder.append(this.seQ.JS(this.seQ.getIntent().getStringExtra("geta8key_username")));
                                stringBuilder.append("</webscence>");
                                stringBuilder.append("</exposecontent>");
                                bundle2.putString("content", stringBuilder.toString());
                                break;
                            case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
                            case 36:
                            case 38:
                            case 39:
                                break;
                            case 51:
                                bundle2.putString("newMsgId", String.valueOf(intent.getLongExtra("k_expose_msg_id", 0)));
                                bundle2.putStringArrayList("content", intent.getStringArrayListExtra("k_outside_expose_proof_item_list"));
                                bundle2.putInt("msgType", intent.getIntExtra("k_expose_msg_type", 0));
                                break;
                            default:
                                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "unknown expose scene: %d", new Object[]{Integer.valueOf(bundle.getInt("scene"))});
                                return bundle2;
                        }
                        bundle2.putString("username", intent.getStringExtra("k_username"));
                        break;
                    }
                    break;
                case am.CTRL_BYTE /*77*/:
                    bundle2.putString("KSessionId", this.seQ.fFF);
                    bundle2.putString("KUserAgent", this.seQ.sdc);
                    bundle2.putBoolean("KReportPage", this.seQ.sdd);
                    bundle2.putString("KUrl", this.seQ.seI);
                    break;
                case JsApiOperateWXData.CTRL_INDEX /*79*/:
                    this.seQ.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            bundle2.putInt("height", this.seS.seQ.byg());
                        }
                    });
                    break;
                case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_NATIVE_DATASOURCE /*81*/:
                    bundle2.putBoolean("from_shortcut", this.seQ.sdl);
                    break;
                case 84:
                    bPV = this.seQ.bPV();
                    VD = VD();
                    bundle2.putString("webview_current_url", VD);
                    bundle2.putString("webview_current_title", bPV != null ? bPV.toString() : "");
                    bundle2.putString("webview_current_desc", VD);
                    break;
                case 85:
                    bPV = this.seQ.bPV();
                    VD = VD();
                    Intent intent2 = this.seQ.getIntent();
                    if (intent2 != null) {
                        bundle2.putString("share_report_pre_msg_url", intent2.getStringExtra("share_report_pre_msg_url"));
                        bundle2.putString("share_report_pre_msg_title", intent2.getStringExtra("share_report_pre_msg_title"));
                        bundle2.putString("share_report_pre_msg_desc", intent2.getStringExtra("share_report_pre_msg_desc"));
                        bundle2.putString("share_report_pre_msg_icon_url", intent2.getStringExtra("share_report_pre_msg_icon_url"));
                        bundle2.putString("share_report_pre_msg_appid", intent2.getStringExtra("share_report_pre_msg_appid"));
                        bundle2.putInt("share_report_from_scene", intent2.getIntExtra("share_report_from_scene", 0));
                        bundle2.putString("share_report_biz_username", intent2.getStringExtra("share_report_biz_username"));
                    }
                    bundle2.putString("share_report_current_url", VD);
                    bundle2.putString("share_report_current_title", bPV != null ? bPV.toString() : "");
                    break;
                case 86:
                    bundle2.putBoolean("is_from_keep_top", this.seQ.getIntent().getBooleanExtra("is_from_keep_top", false));
                    break;
                case 87:
                    if (!this.seQ.seb) {
                        bundle2.putString("full_url", bg.mz(this.seQ.lUe));
                        if (this.seQ.sed != null && this.seQ.sed.size() != 0) {
                            bundle2.putInt("set_cookie", 1);
                            CookieSyncManager.createInstance(com.tencent.mm.sdk.platformtools.ab.getContext());
                            CookieManager instance = CookieManager.getInstance();
                            for (String string3 : this.seQ.sed.keySet()) {
                                instance.setCookie(bg.Qo(this.seQ.lUe), string3 + "=" + ((String) this.seQ.sed.get(string3)));
                            }
                            instance.setCookie(bg.Qo(this.seQ.lUe), "httponly");
                            CookieSyncManager.getInstance().sync();
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "cookies:%s", new Object[]{instance.getCookie(bg.Qo(this.seQ.lUe))});
                            break;
                        }
                        bundle2.putInt("set_cookie", 0);
                        break;
                    }
                    bundle2.putString("result", "not_return");
                    break;
                    break;
                case 99:
                    bundle2.putInt("geta8key_scene", this.seQ.getIntent().getIntExtra("geta8key_scene", 0));
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "Key value: getA8KeyScene(%d)", new Object[]{Integer.valueOf(init)});
                    break;
                case 101:
                    bundle.setClassLoader(WebViewUI.class.getClassLoader());
                    com.tencent.mm.bb.d.b(this.seQ, bundle.getString("open_ui_with_webview_ui_plugin_name"), bundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(bundle.getBundle("open_ui_with_webview_ui_extras")).putExtra("KPublisherId", this.seQ.fUX));
                    break;
                case 1009:
                    if (this.seQ.scW != null) {
                        this.seQ.scW.disable();
                    }
                    this.seQ.screenOrientation = bundle.getInt("screen_orientation", -1);
                    if (this.seQ.screenOrientation == MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED) {
                        this.seQ.screenOrientation = 0;
                        if (this.seQ.scW != null) {
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "OrientationListener, start listen orientation change");
                            this.seQ.scW.enable();
                        }
                    } else if (this.seQ.screenOrientation == MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED) {
                        this.seQ.screenOrientation = 1;
                        if (this.seQ.scW != null) {
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "OrientationListener, start listen orientation change");
                            this.seQ.scW.enable();
                        }
                    }
                    this.seQ.azv();
                    break;
                case 4001:
                case 4002:
                case 4003:
                case 4004:
                case 4005:
                case 4008:
                    final com.tencent.mm.sdk.b.b kVar = new com.tencent.mm.e.a.k();
                    kVar.fCy.context = this.seQ.uSU.uTo;
                    kVar.fCy.actionCode = i;
                    if (4003 == i) {
                        kVar.fCy.fCA = bundle.getString("apdu");
                    } else if (4004 == i) {
                        VD = bundle.getString("apdus");
                        z = bundle.getBoolean("breakIfFail", true);
                        boolean z3 = bundle.getBoolean("breakIfTrue", false);
                        kVar.fCy.fCA = VD;
                        kVar.fCy.fCB = z;
                        kVar.fCy.fCC = z3;
                    }
                    kVar.nFq = new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 seS;

                        public final void run() {
                            bundle2.putAll(kVar.fCz.fCD);
                        }
                    };
                    com.tencent.mm.sdk.b.a.urY.m(kVar);
                    break;
                case 5001:
                    if (this.seQ.iYF.isSDCardAvailable()) {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "availableSize = %d", new Object[]{Long.valueOf(av.bJE())});
                        if (av.bJE() < 524288000) {
                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "available size not enough");
                        } else {
                            File file = new File(com.tencent.mm.plugin.webview.a.rUY);
                            z2 = true;
                            if (!file.exists()) {
                                z2 = file.mkdirs();
                                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "create proxy cache path : %s, %b", new Object[]{file.getAbsolutePath(), Boolean.valueOf(z2)});
                            }
                            if (z2) {
                                init = FactoryProxyManager.getPlayManager().init(this.seQ, com.tencent.mm.plugin.webview.a.rUY);
                                FactoryProxyManager.getPlayManager().setMaxStorageSize(200);
                            }
                        }
                        init = FactoryProxyManager.getPlayManager().init(this.seQ, null);
                    } else {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "sdcard not available");
                        init = FactoryProxyManager.getPlayManager().init(this.seQ, null);
                    }
                    if (init == 0) {
                        if (WebViewUI.sep == null) {
                            WebViewUI.sep = new y(this.seQ);
                            FactoryProxyManager.getPlayManager().setUtilsObject(WebViewUI.sep);
                        }
                        a = FactoryProxyManager.getPlayManager().getLocalServerPort();
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "webview video init result = %d, local port = %d", new Object[]{Integer.valueOf(init), Integer.valueOf(a)});
                        com.tencent.mm.plugin.webview.model.af n = this.seQ.seq;
                        if (a <= 0 || a > 65535) {
                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewResourceInterrupter", "err port = %d", new Object[]{Integer.valueOf(a)});
                        }
                        if (!n.rXd.contains(Integer.valueOf(a))) {
                            n.rXd.add(Integer.valueOf(a));
                        }
                    }
                    bundle2.putInt("webview_video_proxy_init", init);
                    break;
                case 5002:
                    init = FactoryProxyManager.getPlayManager().startPlay(bundle.getString("webview_video_proxy_cdn_urls"), bundle.getInt("webview_video_proxy_file_type"), bundle.getString("webview_video_proxy_fileId"), (long) bundle.getInt("webview_video_proxy_file_size"), bundle.getInt("webview_video_proxy_file_duration"));
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d, playDataId = %d, localUrl = %s", new Object[]{VD, r3, Integer.valueOf(r8), Integer.valueOf(r6), Integer.valueOf(r2), Integer.valueOf(init), FactoryProxyManager.getPlayManager().buildPlayURLMp4(init)});
                    bundle2.putInt("webview_video_proxy_play_data_id", init);
                    bundle2.putString("webview_video_proxy_local_url", string2);
                    break;
                case 5003:
                    init = bundle.getInt("webview_video_proxy_play_data_id");
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "webview proxy stop play, play id = %d", new Object[]{Integer.valueOf(init)});
                    if (init > 0) {
                        FactoryProxyManager.getPlayManager().stopPlay(init);
                        break;
                    }
                    break;
                case 5004:
                    FactoryProxyManager.getPlayManager().setPlayerState(bundle.getInt("webview_video_proxy_play_state"));
                    break;
                case 5005:
                    FactoryProxyManager.getPlayManager().setNetWorkState(bundle.getInt("webview_video_proxy_net_state"));
                    break;
                case 5006:
                    FactoryProxyManager.getPlayManager().setRemainTime(bundle.getInt("webview_video_proxy_play_data_id"), bundle.getInt("webview_video_proxy_play_remain_time"));
                    break;
                case 5007:
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "playid = %d, duration = %d", new Object[]{Integer.valueOf(bundle.getInt("webview_video_proxy_play_data_id")), Integer.valueOf(bundle.getInt("webview_video_proxy_preload_duration"))});
                    bundle2.putInt("webview_video_proxy_pre_load_result", FactoryProxyManager.getPlayManager().preLoad(init, a));
                    break;
                case 6001:
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "includeCookie = %b", new Object[]{Boolean.valueOf(bundle.getBoolean("clear_webview_cache_clear_cookie", false))});
                    Intent intent3 = new Intent();
                    intent3.setComponent(new ComponentName(com.tencent.mm.ui.d.g.uOD, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                    intent3.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                    intent3.putExtra("tools_clean_webview_cache_ignore_cookie", z2);
                    this.seQ.sendBroadcast(intent3);
                    break;
                case 90000:
                    bundle2.putStringArray("webview_get_route_url_list", this.seQ.seo.bxe());
                    bundle2.putInt("webview_get_route_url_geta8key_scene", this.seQ.gaA);
                    break;
                case 90001:
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "url = %s, cookie = %s", new Object[]{this.seQ.azN(), CookieManager.getInstance().getCookie(this.seQ.azN())});
                    bundle2.putString("cookie", VD);
                    break;
                case 90002:
                    g.scG.dT(bundle.getString("traceid"), bundle.getString("username"));
                    break;
                default:
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "undefine action code!!!");
                    break;
            }
            return bundle2;
        }

        public final void N(Bundle bundle) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "setCustomMenu");
            ArrayList stringArrayList = bundle.getStringArrayList("keys");
            ArrayList stringArrayList2 = bundle.getStringArrayList("titles");
            int size = stringArrayList.size();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                arrayList.add(new com.tencent.mm.i.d.b((String) stringArrayList.get(i), (String) stringArrayList2.get(i)));
            }
            if (stringArrayList.size() > 0) {
                String url = this.seQ.oET.getUrl();
                if (this.seQ.sdO.containsKey(url)) {
                    this.seQ.sdO.remove(url);
                }
                this.seQ.sdO.put(url, arrayList);
            }
        }

        public final void iP(boolean z) {
            this.seQ.iV(z);
        }

        public final void dR(final String str, final String str2) {
            this.seQ.handler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass12 seS;

                public final void run() {
                    if (!bg.mA(str)) {
                        if (!bg.mA(str2)) {
                            this.seS.seQ.getIntent().putExtra("view_port_code", str2);
                        }
                        this.seS.seQ.oET.loadUrl(str);
                    }
                }
            });
        }
    };
    private final com.tencent.mm.plugin.webview.d.a sbX = new com.tencent.mm.plugin.webview.d.a();
    protected boolean sbh = true;
    protected boolean scL = false;
    public MMFalseProgressBar scM;
    public ProgressBar scN;
    private ImageButton scO;
    private ImageButton scP;
    private View scQ;
    public FrameLayout scR;
    public FrameLayout scS;
    public MovingImageButton scT;
    public boolean scU = false;
    public boolean scV = false;
    protected com.tencent.mm.plugin.webview.d.e scW;
    private WebViewInputFooter scX;
    public WebViewSearchContentInputFooter scY;
    private boolean scZ;
    public int screenOrientation = -1;
    protected n sdA = new n(this);
    protected p sdB = new p(this);
    protected r sdC = new r(this);
    private boolean sdD = false;
    private com.tencent.mm.sdk.platformtools.y<String, Bitmap> sdE = new com.tencent.mm.sdk.platformtools.y(12);
    private HashMap<String, String> sdF = new HashMap();
    private b sdG;
    private int sdH = 0;
    private com.tencent.mm.plugin.webview.ui.tools.jsapi.f sdI;
    protected volatile boolean sdJ = false;
    private boolean sdK = false;
    private String sdL = "";
    private HashMap<String, Boolean> sdM = new HashMap();
    private HashMap<String, String> sdN = new HashMap();
    private HashMap<String, ArrayList<com.tencent.mm.i.d.b>> sdO = new HashMap();
    private HashMap<String, Boolean> sdP = new HashMap();
    private HashMap<String, Integer> sdQ = new HashMap();
    private d sdR;
    private com.tencent.mm.ui.base.h sdS = null;
    private View sdT;
    protected View sdU = null;
    private String sdV = null;
    private boolean sdW = false;
    private volatile boolean sdX = false;
    private volatile boolean sdY = false;
    private final Set<String> sdZ = new HashSet();
    private boolean sda;
    public String sdb = null;
    private String sdc = "";
    public boolean sdd = false;
    public boolean sde = false;
    private boolean sdf = false;
    private boolean sdg = false;
    private boolean sdh = true;
    private boolean sdi = false;
    private boolean sdj = false;
    private boolean sdk = false;
    private boolean sdl = false;
    private boolean sdm = true;
    private int sdn;
    private String sdo = null;
    private boolean sdp = false;
    private View sdq;
    private aj sdr;
    private boolean sdt = false;
    private CustomViewCallback sdu;
    private View sdv;
    protected WebChromeClient sdw;
    private ProgressBar sdx;
    public m sdz = new m(null);
    private final com.tencent.mm.plugin.webview.d.c seA = new com.tencent.mm.plugin.webview.d.c();
    private boolean seB;
    private OnLongClickListener seC = new OnLongClickListener(this) {
        final /* synthetic */ WebViewUI seQ;

        {
            this.seQ = r1;
        }

        public final boolean onLongClick(View view) {
            if (this.seQ.getIntent().getBooleanExtra("show_long_click_popup_menu", true)) {
                return byF();
            }
            return true;
        }

        private boolean byF() {
            Exception e;
            boolean z;
            HitTestResult hitTestResult = this.seQ.oET.getHitTestResult();
            if (hitTestResult == null || bg.mA(hitTestResult.getExtra())) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "hittestresult getExtra is null");
                return false;
            }
            boolean bu;
            try {
                bu = this.seQ.iYF.bu(hitTestResult.getExtra());
                if (bu) {
                    try {
                        this.seQ.iYF.ca(hitTestResult.getExtra(), this.seQ.hashCode());
                    } catch (Exception e2) {
                        e = e2;
                        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "postBinded, handleEvents, ex = " + e.getMessage());
                        z = bu;
                        if (!z) {
                            return z;
                        }
                        com.tencent.mm.ui.base.g.a(this.seQ, hitTestResult.getExtra(), new String[]{com.tencent.mm.bg.a.V(this.seQ, R.l.eHp), com.tencent.mm.bg.a.V(this.seQ, R.l.eHn)}, "", new com.tencent.mm.ui.base.g.c(this.seQ, hitTestResult.getExtra()) {
                            final /* synthetic */ WebViewUI seQ;

                            public final void hq(int i) {
                                switch (i) {
                                    case 0:
                                        if (this.seQ.JU(r4)) {
                                            this.seQ.oET.loadUrl(r4);
                                            return;
                                        }
                                        com.tencent.mm.sdk.platformtools.w.f("MicroMsg.WebViewUI", "showLoadUrlMenu, canLoadUrl fail, url = " + r4);
                                        this.seQ.azI();
                                        return;
                                    case 1:
                                        com.tencent.mm.pluginsdk.j.d.a(this.seQ, r4, r4);
                                        return;
                                    default:
                                        return;
                                }
                            }
                        });
                        return true;
                    }
                }
                z = bu;
            } catch (Exception e3) {
                e = e3;
                bu = true;
                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "postBinded, handleEvents, ex = " + e.getMessage());
                z = bu;
                if (!z) {
                    return z;
                }
                com.tencent.mm.ui.base.g.a(this.seQ, hitTestResult.getExtra(), new String[]{com.tencent.mm.bg.a.V(this.seQ, R.l.eHp), com.tencent.mm.bg.a.V(this.seQ, R.l.eHn)}, "", /* anonymous class already generated */);
                return true;
            }
            if (!z) {
                return z;
            }
            com.tencent.mm.ui.base.g.a(this.seQ, hitTestResult.getExtra(), new String[]{com.tencent.mm.bg.a.V(this.seQ, R.l.eHp), com.tencent.mm.bg.a.V(this.seQ, R.l.eHn)}, "", /* anonymous class already generated */);
            return true;
        }
    };
    String[] seD;
    private Map<String, SparseBooleanArray> seE = new HashMap();
    private String seF = "";
    private volatile String seG = null;
    private volatile String seH = "";
    private volatile String seI = "";
    private long seJ = 0;
    private com.tencent.mm.ui.base.p seK;
    private com.tencent.mm.plugin.webview.model.y.c seL = new com.tencent.mm.plugin.webview.model.y.c(this) {
        final /* synthetic */ WebViewUI seQ;

        {
            this.seQ = r1;
        }

        public final void IM(String str) {
            this.seQ.j(str, true, 9);
        }

        public final void goBack() {
            if (this.seQ.oET != null && !this.seQ.sdW) {
                if (this.seQ.oET.canGoBack() && this.seQ.mna) {
                    this.seQ.byf();
                    return;
                }
                g.scG.close();
                this.seQ.finish();
            }
        }

        public final void c(OnCancelListener onCancelListener) {
            if (this.seQ.seK != null) {
                this.seQ.seK.dismiss();
            }
            this.seQ.seK = com.tencent.mm.ui.base.g.a(this.seQ, this.seQ.getString(R.l.eFd), true, onCancelListener);
        }

        public final void amV() {
            if (this.seQ.seK != null) {
                this.seQ.seK.dismiss();
            }
        }
    };
    private com.tencent.mm.plugin.webview.model.y.a seM = new com.tencent.mm.plugin.webview.model.y.a(this) {
        final /* synthetic */ WebViewUI seQ;
        private Map<Integer, Integer> sfL = new HashMap();

        {
            this.seQ = r2;
        }

        public final void vP(int i) {
            this.seQ.wo(i);
            if (this.sfL.containsKey(Integer.valueOf(i))) {
                this.sfL.put(Integer.valueOf(i), Integer.valueOf(((Integer) this.sfL.get(Integer.valueOf(i))).intValue() + 1));
                return;
            }
            this.sfL.put(Integer.valueOf(i), Integer.valueOf(1));
        }

        public final void remove(int i) {
            this.seQ.wp(i);
            if (this.sfL.containsKey(Integer.valueOf(i))) {
                this.sfL.put(Integer.valueOf(i), Integer.valueOf(((Integer) this.sfL.get(Integer.valueOf(i))).intValue() - 1));
                return;
            }
            this.sfL.put(Integer.valueOf(i), Integer.valueOf(0));
        }

        public final boolean bwl() {
            for (Entry value : this.sfL.entrySet()) {
                if (((Integer) value.getValue()).intValue() > 0) {
                    return true;
                }
            }
            return false;
        }
    };
    private com.tencent.mm.ui.base.i seN;
    private String[] seO = null;
    public int seP = -1;
    private boolean sea = false;
    private boolean seb = false;
    private final Map<String, Map<String, String>> sec = new ConcurrentHashMap();
    private Map<String, String> sed;
    private Map see;
    private boolean sef = false;
    private String seg = "";
    private boolean seh = false;
    private final Map<String, String> sei = new HashMap();
    private final Set<String> sej = new HashSet();
    public boolean sel = false;
    private boolean sem = false;
    private com.tencent.mm.plugin.webview.model.a sen = new com.tencent.mm.plugin.webview.model.a(this.rWq);
    private com.tencent.mm.plugin.webview.d.j seo = new com.tencent.mm.plugin.webview.d.j();
    private com.tencent.mm.plugin.webview.model.af seq = new com.tencent.mm.plugin.webview.model.af();
    public com.tencent.smtt.sdk.ab ser = new com.tencent.smtt.sdk.ab(this) {
        final /* synthetic */ WebViewUI seQ;

        {
            this.seQ = r1;
        }

        public final boolean s(MotionEvent motionEvent) {
            if (this.seQ.oET == null) {
                return false;
            }
            return this.seQ.oET.J(motionEvent);
        }

        public final boolean a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            if (this.seQ.oET == null) {
                return false;
            }
            return this.seQ.oET.b(i, i2, i3, i4, i5, i6, i7, i8, z);
        }

        public final void UN() {
            if (this.seQ.oET != null) {
                this.seQ.oET.caJ();
            }
        }

        @TargetApi(9)
        public final void b(int i, int i2, boolean z, boolean z2) {
            if (this.seQ.oET != null) {
                this.seQ.oET.c(i, i2, z, z2);
            }
        }

        public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
            if (this.seQ.oET != null) {
                this.seQ.oET.v(i, i2, i3, i4);
            }
        }

        public final boolean t(MotionEvent motionEvent) {
            if (this.seQ.oET == null) {
                return false;
            }
            return this.seQ.oET.K(motionEvent);
        }

        public final boolean u(MotionEvent motionEvent) {
            if (this.seQ.oET == null) {
                return false;
            }
            return this.seQ.oET.L(motionEvent);
        }
    };
    private boolean ses = true;
    public View set;
    private View seu;
    public boolean sev = false;
    private int sew = 0;
    private com.tencent.mm.plugin.webview.d.e.b sex = new com.tencent.mm.plugin.webview.d.e.b(this) {
        final /* synthetic */ WebViewUI seQ;

        {
            this.seQ = r1;
        }

        public final void a(com.tencent.mm.plugin.webview.d.e.a aVar, com.tencent.mm.plugin.webview.d.e.a aVar2) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "OrientationListener lastOrientation:" + aVar.name() + "; newOrientation:" + aVar2.name());
            this.seQ.screenOrientation = 4;
            this.seQ.azv();
            if (this.seQ.scW != null) {
                this.seQ.scW.disable();
            }
        }
    };
    private boolean sey = false;
    public final f sez = new f();
    private int width;

    private static final class ab {
        public final int id;
        public final WeakReference<WebViewUI> qQW;

        public ab(WebViewUI webViewUI) {
            this.qQW = new WeakReference(webViewUI);
            this.id = webViewUI.hashCode();
        }
    }

    private static final class d {
        private String lang;
        private String mlT;
        private String mlU;
        private String mlV;
        private String mlW;
        private String mlX;
        private String mlY;
        String sfO;

        public d(Bundle bundle) {
            this.sfO = bundle.getString("close_window_confirm_dialog_switch");
            this.mlT = bundle.getString("close_window_confirm_dialog_title_cn");
            this.mlU = bundle.getString("close_window_confirm_dialog_title_eng");
            this.mlV = bundle.getString("close_window_confirm_dialog_ok_cn");
            this.mlW = bundle.getString("close_window_confirm_dialog_ok_eng");
            this.mlX = bundle.getString("close_window_confirm_dialog_cancel_cn");
            this.mlY = bundle.getString("close_window_confirm_dialog_cancel_eng");
            this.lang = bundle.getString("application_language");
        }

        public final String azs() {
            if ("zh_CN".equals(this.lang)) {
                return this.mlT;
            }
            return this.mlU;
        }

        public final String azt() {
            if ("zh_CN".equals(this.lang)) {
                return this.mlV;
            }
            return this.mlW;
        }

        public final String azu() {
            if ("zh_CN".equals(this.lang)) {
                return this.mlX;
            }
            return this.mlY;
        }
    }

    protected class h extends ProxyWebViewClientExtension {
        final /* synthetic */ WebViewUI seQ;

        public h(WebViewUI webViewUI) {
            this.seQ = webViewUI;
        }

        public Object onMiscCallBack(String str, Bundle bundle) {
            String str2 = null;
            String str3 = "MicroMsg.WebViewUI";
            String str4 = "method = %s, bundler == null ? %b, invoker == null ? %b";
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(bundle == null);
            objArr[2] = Boolean.valueOf(this.seQ.iYF == null);
            com.tencent.mm.sdk.platformtools.w.i(str3, str4, objArr);
            if (bg.mA(str) || bundle == null || this.seQ.iYF == null) {
                return str2;
            }
            String Ju;
            try {
                Ju = this.seQ.iYF.Ju("WebviewEnableTbsDownload");
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "get dynamic config failed");
                Ju = str2;
            }
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "enable value = %s", new Object[]{Ju});
            if (bg.mA(Ju) || !Ju.equals("0")) {
                Bundle d;
                if (str.equals("addDownloadTask")) {
                    try {
                        d = this.seQ.iYF.d(14, bundle);
                        if (d != null) {
                            return Long.valueOf(d.getLong("download_id", 0));
                        }
                    } catch (RemoteException e2) {
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "invoke the add downloadtask failed");
                    }
                }
                if (str.equals(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.f.NAME)) {
                    try {
                        d = this.seQ.iYF.d(16, bundle);
                        if (d != null) {
                            return Boolean.valueOf(d.getBoolean("cancel_result", false));
                        }
                    } catch (RemoteException e3) {
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "invoke the cancel downloadtask failed");
                    }
                }
                if (str.equals(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ai.NAME)) {
                    try {
                        d = this.seQ.iYF.d(15, bundle);
                        if (d != null) {
                            return Integer.valueOf(d.getInt("download_state", 0));
                        }
                    } catch (RemoteException e4) {
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "invoke the queryDownloadTask downloadtask failed");
                    }
                }
                if (str.equals(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.v.NAME)) {
                    try {
                        d = this.seQ.iYF.d(17, bundle);
                        if (d != null) {
                            return Boolean.valueOf(d.getBoolean("install_result"));
                        }
                    } catch (RemoteException e5) {
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "invoke the install downloadtask failed");
                    }
                }
                if (str.equals("getDrawable")) {
                    str3 = bundle.getString(DownloadInfoColumns.PACKAGENAME);
                    int i = bundle.getInt("resourceId");
                    if (!bg.mA(str3) && i > 0) {
                        try {
                            return com.tencent.mm.bh.a.b(this.seQ.getPackageManager().getResourcesForApplication(str3), i);
                        } catch (Exception e6) {
                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "get resource for package : %s, fail, : %s", new Object[]{str3, e6.getMessage()});
                        }
                    }
                }
                if (!str.equals("getShareUrl")) {
                    return str2;
                }
                try {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "getShareUrl by x5 core, shareurl = %s", new Object[]{this.seQ.iYF.xH(this.seQ.oET.getUrl())});
                    return this.seQ.iYF.xH(this.seQ.oET.getUrl());
                } catch (Exception e7) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "getShare url failed");
                    return str2;
                }
            }
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "config closed, not allows tbs download");
            return str2;
        }

        public boolean onTouchEvent(MotionEvent motionEvent, View view) {
            return this.seQ.ser.s(motionEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
            return this.seQ.ser.u(motionEvent);
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
            return this.seQ.ser.t(motionEvent);
        }

        public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
            return this.seQ.ser.a(i, i2, i3, i4, i5, i6, i7, i8, z);
        }

        public void onScrollChanged(int i, int i2, int i3, int i4, View view) {
            this.seQ.ser.onScrollChanged(i, i2, i3, i4, view);
        }

        public void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
            this.seQ.ser.b(i, i2, z, z2);
        }

        public void computeScroll(View view) {
            this.seQ.ser.UN();
        }

        public boolean onShowLongClickPopupMenu() {
            if (this.seQ.getIntent().getBooleanExtra("show_long_click_popup_menu", true)) {
                return false;
            }
            return true;
        }

        public void invalidate() {
        }
    }

    protected class i extends WebViewClient {
        final /* synthetic */ WebViewUI seQ;

        public i(WebViewUI webViewUI) {
            this.seQ = webViewUI;
        }

        public boolean b(WebView webView, String str) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "edw mmShouldOverride");
            if (str.startsWith("weixinping://iframe") || str.startsWith("weixinpreinject://iframe")) {
                return true;
            }
            if (this.seQ.xF(str)) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "custom scheme url deal success, url = " + str);
                return true;
            }
            this.seQ.seG = str;
            return false;
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, final String str) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "edw opt, shouldOverride url = " + str);
            if (!this.seQ.JU(str)) {
                com.tencent.mm.sdk.platformtools.w.f("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, canLoadUrl fail, url = " + str);
                this.seQ.azI();
                return true;
            } else if (com.tencent.mm.pluginsdk.ui.tools.s.eq(str, "about:blank")) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "shouldOverride, url is about:blank");
                return true;
            } else {
                try {
                    if (str.startsWith("weixin://jump/") || str.startsWith("weixin://scanqrcode/")) {
                        this.seQ.JQ(str);
                        return true;
                    } else if (str.startsWith("weixin://dl/business") && com.tencent.mm.pluginsdk.d.i(Uri.parse(str))) {
                        String host = Uri.parse(this.seQ.fWY).getHost();
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.addCategory("android.intent.category.BROWSABLE");
                        intent.setData(Uri.parse(str + "&domain=" + host));
                        intent.putExtra("translate_link_scene", 13);
                        this.seQ.startActivity(intent);
                        return true;
                    } else if (str.startsWith("weixinpreinject://iframe") && this.seQ.sdI != null) {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "preInjectJsBridge,accept preinject_Iframe and continue preinjectjsbridge");
                        this.seQ.sdI.skp = true;
                        if (!str.equals(this.seQ.seF)) {
                            this.seQ.seF = "";
                            return true;
                        } else if (!this.seQ.xM(str)) {
                            return true;
                        } else {
                            if (str.startsWith("weixin://")) {
                                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", new Object[]{str});
                                return true;
                            }
                            r1 = this.seQ.sdz.xB(str);
                            if (r1 == 0) {
                            }
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "edw shouldOverride, should not continue, reason = " + r1);
                            if (this.seQ.JO(str)) {
                                this.seQ.oET.stopLoading();
                                this.seQ.oET.post(new Runnable(this) {
                                    final /* synthetic */ i sfQ;

                                    public final void run() {
                                        this.sfQ.seQ.xG(str);
                                    }
                                });
                            } else {
                                this.seQ.oET.stopLoading();
                            }
                            if (str.equals(this.seQ.sdo)) {
                                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
                                return b(webView, str);
                            }
                            this.seQ.j(str, true, r1);
                            return true;
                        }
                    } else if (str.startsWith("weixin://dl/login/common_view") || str.startsWith("weixin://dl/login/phone_view")) {
                        if ((this.seQ.fWY.startsWith("https://support.weixin.qq.com/security") || str.startsWith("https://support.wechat.com/security")) && this.seQ.sdj) {
                            com.tencent.mm.pluginsdk.d.aN(this.seQ.uSU.uTo, str);
                            this.seQ.finish();
                            return true;
                        }
                        if (!str.equals(this.seQ.seF)) {
                            this.seQ.seF = "";
                            return true;
                        } else if (!this.seQ.xM(str)) {
                            return true;
                        } else {
                            if (str.startsWith("weixin://")) {
                                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", new Object[]{str});
                                return true;
                            }
                            r1 = this.seQ.sdz.xB(str);
                            if (r1 == 0 && r1 != 2 && (r1 != 8 || this.seQ.sdf)) {
                                return b(webView, str);
                            }
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "edw shouldOverride, should not continue, reason = " + r1);
                            if (this.seQ.JO(str)) {
                                this.seQ.oET.stopLoading();
                                this.seQ.oET.post(/* anonymous class already generated */);
                            } else {
                                this.seQ.oET.stopLoading();
                            }
                            if (str.equals(this.seQ.sdo)) {
                                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
                                return b(webView, str);
                            }
                            this.seQ.j(str, true, r1);
                            return true;
                        }
                    } else if (str.startsWith("weixin://webview/initReady/")) {
                        return true;
                    } else {
                        if (str.startsWith("weixin://webview/preInjectJSBridge/")) {
                            return true;
                        }
                        if (!str.equals(this.seQ.seF)) {
                            this.seQ.seF = "";
                            return true;
                        } else if (!this.seQ.xM(str)) {
                            return true;
                        } else {
                            if (str.startsWith("weixin://")) {
                                r1 = this.seQ.sdz.xB(str);
                                if (r1 == 0) {
                                }
                                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "edw shouldOverride, should not continue, reason = " + r1);
                                if (this.seQ.JO(str)) {
                                    this.seQ.oET.stopLoading();
                                } else {
                                    this.seQ.oET.stopLoading();
                                    this.seQ.oET.post(/* anonymous class already generated */);
                                }
                                if (str.equals(this.seQ.sdo)) {
                                    this.seQ.j(str, true, r1);
                                    return true;
                                }
                                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
                                return b(webView, str);
                            }
                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", new Object[]{str});
                            return true;
                        }
                    }
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "shouldOverride, jumpToActivity, ex = " + e.getMessage());
                    if (this.seQ.iYG == null) {
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "wvPerm is null, maybe has detach");
                        return true;
                    }
                }
            }
        }

        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "doUpdateVisitedHistory, url = %s, isReload = %b", new Object[]{str, Boolean.valueOf(z)});
            super.doUpdateVisitedHistory(webView, str, z);
            if (com.tencent.mm.pluginsdk.ui.tools.s.eq(str, "about:blank")) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "doUpdateVisitedHistory, url is about:blank");
                return;
            }
            String url = webView.getUrl();
            if (this.seQ.sdf) {
                this.seQ.j(url, false, -1);
            }
            if (!(this.seQ.iYG == null || this.seQ.iYG.has(url))) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "doUpdateVisitedHistory start geta8key, url = %s", new Object[]{url});
                this.seQ.j(url, false, -1);
                this.seQ.A(true, false);
                this.seQ.seh = true;
            }
            this.seQ.sez.bxS();
            this.seQ.seG = str;
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "edw onPageStarted opt, url = " + str);
            com.tencent.mm.plugin.report.service.g.oUh.a(155, 0, 1, false);
            if (com.tencent.mm.sdk.a.b.bIu() && "http://www.dktest-mmcrash.com/".equals(str)) {
                Assert.assertTrue("test errlog in tools " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), false);
            }
            this.seQ.rXM = this.seQ.seG;
            this.seQ.e(str, bg.Ny(), 1);
            this.seQ.rWq.bwA().rXM = this.seQ.rXM;
            this.seQ.seG = str;
            g gVar = g.scG;
            String str2 = gVar.scH;
            gVar.scH = str;
            if (!bg.mA(gVar.qdW)) {
                gVar.c(1, str2, 0);
            }
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "onPageStarted preUrl : %s, curUrl : %s.", new Object[]{this.seQ.rXM, this.seQ.seG});
            if (this.seQ.JU(str)) {
                this.seQ.sez.bxS();
                this.seQ.sez.pE(str);
                if (this.seQ.xM(str)) {
                    this.seQ.seF = str;
                    return;
                }
                this.seQ.sdI.bzu();
                this.seQ.setProgressBarIndeterminateVisibility(false);
                if (this.seQ.JO(str)) {
                    this.seQ.sdY = true;
                    this.seQ.scM.finish();
                    this.seQ.oET.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
                    if (this.seQ.rVm != null) {
                        this.seQ.rVm.l((String) this.seQ.sei.get(str), (Map) this.seQ.sec.get(str));
                    }
                } else {
                    this.seQ.sdY = false;
                    if (!this.seQ.sea) {
                        this.seQ.scM.start();
                    }
                }
                if (x.NO_NEED.equals(this.seQ.j(str, false, -1))) {
                    this.seQ.seo.Jl(str);
                }
                this.seQ.A(true, false);
                this.seQ.seh = false;
                com.tencent.mm.plugin.webview.model.ai.k bwy = this.seQ.rWq.bwy();
                int v = this.seQ.gaA;
                String i = this.seQ.fUX;
                bwy.gaA = v;
                bwy.rXD = i;
                if (bg.mA(str)) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.startLoadUrl failed, url is null");
                } else if (!bwy.rXQ.containsKey(str)) {
                    bwy.rXQ.put(str, Long.valueOf(bg.Nz()));
                }
                this.seQ.mne = 0;
                return;
            }
            com.tencent.mm.sdk.platformtools.w.f("MicroMsg.WebViewUI", "onPageStarted, canLoadUrl fail, url = " + str);
            this.seQ.azI();
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            this.seQ.sdp = true;
            if (!this.seQ.sdW) {
                this.seQ.sdW = true;
                this.seQ.rWq.bwC().rXv = true;
            }
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "edw onPageFinished opt, url = %s", new Object[]{str});
            com.tencent.mm.plugin.webview.model.ai.b bwH = this.seQ.rWq.bwH();
            if (bwH.rXx && !bwH.rXy) {
                try {
                    Uri parse = Uri.parse(str);
                    if (str.startsWith("http")) {
                        String host = parse.getHost();
                        if (host != null && host.equalsIgnoreCase("v.html5.qq.com")) {
                            com.tencent.mm.plugin.report.service.g.oUh.a(283, 0, 1, true);
                            bwH.rXy = true;
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, domain visit reported, url = %s", new Object[]{str});
                        }
                    } else {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, url not startswith http");
                    }
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebviewReporter.DomainReporter", "onPageFinished, parse url fail, url = %s", new Object[]{str});
                }
            }
            g gVar = g.scG;
            if (!bg.mA(gVar.qdW)) {
                gVar.mN(2);
            }
            if (this.seQ.oET == null) {
                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "onPageFinished, webview has been destroyed, skip");
                return;
            }
            this.seQ.seo.Jl(str);
            String title = this.seQ.oET.getTitle();
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "onPageFinished, old title = %s, new title = %s, fixedTitle = %b, showTitle = %b, loadUrl = %s", new Object[]{this.seQ.bPV(), title, Boolean.valueOf(this.seQ.scL), Boolean.valueOf(this.seQ.qyZ), this.seQ.seG});
            if (this.seQ.oET.getX5WebViewExtension() == null && !bg.mA(title) && title.length() > 0 && !title.equals(this.seQ.bPV()) && !title.startsWith("http") && ((this.seQ.seG == null || !this.seQ.seG.equals(title)) && !this.seQ.scL && this.seQ.qyZ)) {
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "onPageFinished, update old title while goback");
                this.seQ.qP(title);
            }
            this.seQ.sez.pE(this.seQ.azN());
            boolean booleanExtra = this.seQ.getIntent().getBooleanExtra("shouldForceViewPort", false);
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "hy: shouldForceViewPort: " + booleanExtra);
            if (booleanExtra) {
                webView.evaluateJavascript(this.seQ.getIntent().getStringExtra("view_port_code"), null);
            }
            this.seQ.byv();
            if (this.seQ.JU(str)) {
                this.seQ.setProgressBarIndeterminateVisibility(false);
                this.seQ.scM.finish();
                this.seQ.seF = "";
                if (str.equals("file:///android_asset/jsapi/wxjs.js")) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "onPageFinished, js is finished loaded");
                    return;
                }
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "onPageFinished, inject url" + this.seQ.seg);
                com.tencent.mm.pluginsdk.ui.tools.s.a(this.seQ.oET);
                this.seQ.sdI.bzv();
                if (!(this.seQ.iYG == null || this.seQ.iYG.JN(str) == null)) {
                    this.seQ.B(this.seQ.iYG.JN(str).nw(34), this.seQ.iYG.JN(str).nw(75));
                }
                this.seQ.iT(false);
                com.tencent.mm.plugin.webview.model.ai.k bwy = this.seQ.rWq.bwy();
                if (bg.mA(str)) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebviewReporter", "WebviewOpenUrl.stopLoadUrl failed, url is null");
                } else if (bwy.rXQ.containsKey(str)) {
                    bwy.rXQ.put(str, Long.valueOf(bg.Nz() - ((Long) bwy.rXQ.get(str)).longValue()));
                }
                com.tencent.mm.plugin.webview.model.ai.d bwz = this.seQ.rWq.bwz();
                if (bg.mA(str)) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageFinish failed, url is null");
                } else if (bwz.rXB.containsKey(str)) {
                    bwz.rXB.put(str, Long.valueOf(bg.Nz() - ((Long) bwz.rXB.get(str)).longValue()));
                }
                com.tencent.mm.plugin.webview.model.ai.e bwB = this.seQ.rWq.bwB();
                com.tencent.mm.plugin.webview.stub.d dVar = this.seQ.iYF;
                if (!(dVar == null || bwB.kaI)) {
                    bwB.kaI = true;
                    int bwu = ai.bwu();
                    long Nz = bg.Nz() - bwB.startTime;
                    if (Nz >= 0 && Nz <= 180000) {
                        Object[] objArr = new Object[11];
                        objArr[0] = Integer.valueOf(4);
                        objArr[1] = Long.valueOf(Nz);
                        objArr[2] = Integer.valueOf(bwu);
                        objArr[3] = bwB.url == null ? bwB.url : bwB.url.replace(",", "!");
                        objArr[4] = Integer.valueOf(0);
                        objArr[5] = Integer.valueOf(0);
                        objArr[6] = Integer.valueOf(0);
                        objArr[7] = Integer.valueOf(ai.mlK);
                        objArr[8] = Integer.valueOf(ai.rXu);
                        objArr[9] = Integer.valueOf(bwB.gaA);
                        objArr[10] = bwB.rXD;
                        d.a(dVar, 11215, objArr);
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebviewReporter", "WebViewTotalTimeReporter.report url : %s, cost time : %d, netType : %d, %d, %d, getA8KeyScene:%d, prePublishid:%s", new Object[]{bwB.url, Long.valueOf(Nz), Integer.valueOf(bwu), Integer.valueOf(ai.mlK), Integer.valueOf(ai.rXu), Integer.valueOf(bwB.gaA), bwB.rXD});
                    }
                }
                if (!this.seQ.sdM.containsKey(str)) {
                    this.seQ.sdM.put(str, Boolean.valueOf(this.seQ.bPU()));
                }
                this.seQ.iS(((Boolean) this.seQ.sdM.get(str)).booleanValue());
                Boolean bool = (Boolean) this.seQ.sdP.get(str);
                if (bool == null || !bool.booleanValue()) {
                    this.seQ.af(0, true);
                } else {
                    this.seQ.af(0, false);
                }
                this.seQ.seJ = bg.Ny();
                return;
            }
            com.tencent.mm.sdk.platformtools.w.f("MicroMsg.WebViewUI", "onPageFinished, canLoadUrl fail, url = " + str);
            this.seQ.azI();
        }

        @TargetApi(8)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String F = webView.getUrl() == null ? this.seQ.seG : webView.getUrl();
            com.tencent.mm.plugin.report.service.g.oUh.a(155, 1, 1, false);
            com.tencent.mm.plugin.report.service.g.oUh.a(155, 30, 1, false);
            if (this.seQ.sdG == null) {
                this.seQ.sdG = new b(this.seQ, this.seQ.oET);
            }
            this.seQ.sdG.a(F, sslErrorHandler, sslError);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            boolean isConnected = com.tencent.mm.sdk.platformtools.am.isConnected(this.seQ);
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "edw onReceivedError, failingUrl = %s, errorCode = %d, desc = %s, isNetworkConnected = %b", new Object[]{str2, Integer.valueOf(i), str, Boolean.valueOf(isConnected)});
            com.tencent.mm.plugin.report.service.g.oUh.a(155, 1, 1, false);
            com.tencent.mm.plugin.report.service.g.oUh.a(155, (long) a.we(i), 1, false);
            super.onReceivedError(webView, i, str, str2);
            g.scG.wn(i);
            if (this.seQ.sdk) {
                this.seQ.finish();
            }
        }

        public void onLoadResource(WebView webView, String str) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "edw onLoadResource opt, url = " + str);
            if (this.seQ.JU(str) || this.seQ.byy()) {
                com.tencent.mm.plugin.webview.model.ai.d bwz = this.seQ.rWq.bwz();
                if (bg.mA(str)) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onLoadResource failed, url is null");
                } else if (!(bg.mA(bwz.mkT) || str.equals(bwz.mkT) || !bwz.rXC)) {
                    if (bwz.rXA.containsKey(bwz.mkT)) {
                        bwz.rXA.put(bwz.mkT, Long.valueOf(bg.Nz() - ((Long) bwz.rXA.get(bwz.mkT)).longValue()));
                    }
                    bwz.rXC = false;
                }
                super.onLoadResource(webView, str);
                return;
            }
            com.tencent.mm.sdk.platformtools.w.f("MicroMsg.WebViewUI", "onLoadResource, canLoadUrl fail, url = " + str);
            super.onLoadResource(webView, str);
            this.seQ.azI();
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            boolean z = true;
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "shouldInterceptRequest, url = %s", new Object[]{str});
            if (this.seQ.JU(str)) {
                String azN = this.seQ.azN();
                com.tencent.mm.plugin.webview.model.af n = this.seQ.seq;
                if (this.seQ.sdX) {
                    z = false;
                }
                WebResourceResponse a = n.a(azN, str, z, this.seQ.iYF, this.seQ.hashCode());
                if (a == null) {
                    return null;
                }
                dW(azN, str);
                return a;
            }
            com.tencent.mm.sdk.platformtools.w.f("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, canLoadUrl fail, url = " + str);
            this.seQ.azI();
            return null;
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            boolean z = true;
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[]{webResourceRequest.getUrl(), webResourceRequest.getMethod(), Boolean.valueOf(webResourceRequest.isForMainFrame())});
            if (webResourceRequest == null || webResourceRequest.getUrl() == null || bg.mA(webResourceRequest.getUrl().toString())) {
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
            if (this.seQ.JU(webResourceRequest.getUrl().toString())) {
                String azN = this.seQ.azN();
                String uri = webResourceRequest.getUrl().toString();
                com.tencent.mm.plugin.webview.model.af n = this.seQ.seq;
                if (this.seQ.sdX) {
                    z = false;
                }
                WebResourceResponse a = n.a(azN, uri, z, this.seQ.iYF, this.seQ.hashCode());
                if (a == null) {
                    return null;
                }
                dW(azN, uri);
                return a;
            }
            com.tencent.mm.sdk.platformtools.w.f("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, canLoadUrl fail, url = " + webResourceRequest.getUrl().toString());
            this.seQ.azI();
            return null;
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
            boolean z = true;
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[]{webResourceRequest.getUrl(), webResourceRequest.getMethod(), Boolean.valueOf(webResourceRequest.isForMainFrame())});
            if (webResourceRequest == null || webResourceRequest.getUrl() == null || bg.mA(webResourceRequest.getUrl().toString())) {
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
            if (this.seQ.JU(webResourceRequest.getUrl().toString())) {
                if (WebView.getTbsCoreVersion(this.seQ) > 36541) {
                    try {
                        int i = bundle.getInt("resourceType");
                        if (i == 1 || i == 7) {
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "get resoutce type is iframe : %d, start geta8key", new Object[]{Integer.valueOf(i)});
                            this.seQ.j(webResourceRequest.getUrl().toString(), false, 5);
                        }
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "get resource type failed Exception ; %s", new Object[]{e.getMessage()});
                    } catch (Throwable th) {
                        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "get resource type failed Throwable ; %s", new Object[]{th.getMessage()});
                    }
                }
                String azN = this.seQ.azN();
                String uri = webResourceRequest.getUrl().toString();
                com.tencent.mm.plugin.webview.model.af n = this.seQ.seq;
                if (this.seQ.sdX) {
                    z = false;
                }
                WebResourceResponse a = n.a(azN, uri, z, this.seQ.iYF, this.seQ.hashCode());
                if (a == null) {
                    return null;
                }
                dW(azN, uri);
                return a;
            }
            com.tencent.mm.sdk.platformtools.w.f("MicroMsg.WebViewUI", "shouldOverrideUrlLoading, canLoadUrl fail, url = " + webResourceRequest.getUrl().toString());
            this.seQ.azI();
            return null;
        }

        private void dW(String str, String str2) {
            if (str2.equals(str) || this.seQ.dU(str, str2)) {
                this.seQ.handler.post(new Runnable(this) {
                    final /* synthetic */ i sfQ;

                    {
                        this.sfQ = r1;
                    }

                    public final void run() {
                        if (this.sfQ.seQ.oET != null) {
                            this.sfQ.seQ.oET.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
                        }
                        WebViewUI webViewUI = this.sfQ.seQ;
                        Runnable anonymousClass65 = new Runnable(webViewUI) {
                            final /* synthetic */ WebViewUI seQ;

                            {
                                this.seQ = r1;
                            }

                            public final void run() {
                                if (this.seQ.scM != null) {
                                    this.seQ.scM.finish();
                                }
                            }
                        };
                        if (Thread.currentThread().getId() == webViewUI.handler.getLooper().getThread().getId()) {
                            anonymousClass65.run();
                        } else {
                            webViewUI.handler.post(anonymousClass65);
                        }
                    }
                });
            }
        }
    }

    public static class m {
        private static final Pattern mlF = Pattern.compile(".*#.*wechat_redirect");
        public String mlG = null;
        String[] seD = null;
        private LinkedList<String> sfS = new LinkedList();

        public m(String str) {
            this.mlG = str;
        }

        public final int xB(String str) {
            int i = 0;
            if (bg.mA(str)) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "getReason fail, url is null");
                return 0;
            } else if (str.equals(this.mlG)) {
                return 0;
            } else {
                if (mlF.matcher(str).find()) {
                    return 2;
                }
                if (!bg.mA(str) && this.seD != null && this.seD.length != 0 && !this.sfS.contains(str)) {
                    boolean isHttpUrl;
                    String substring;
                    ac cfb = ac.cfb();
                    if (cfb == null || !cfb.cfc()) {
                        isHttpUrl = URLUtil.isHttpUrl(str);
                    } else {
                        Object invokeStaticMethod = cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpUrl", new Class[]{String.class}, new Object[]{str});
                        isHttpUrl = invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
                    }
                    if (isHttpUrl) {
                        substring = str.substring(7);
                    } else {
                        substring = str;
                    }
                    if (com.tencent.smtt.sdk.x.isHttpsUrl(substring)) {
                        substring = str.substring(8);
                    }
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "rawUrl = %s, subUrl = %s", new Object[]{str, substring});
                    for (String str2 : this.seD) {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "force geta8key path = %s", new Object[]{str2});
                        if (substring.startsWith(r5[r2])) {
                            this.sfS.add(str);
                            i = 1;
                            break;
                        }
                    }
                }
                return i != 0 ? 8 : 1;
            }
        }
    }

    protected class n {
        final /* synthetic */ WebViewUI seQ;
        int sfT = 0;

        protected n(WebViewUI webViewUI) {
            this.seQ = webViewUI;
        }

        public final void byH() {
            if (this.sfT == 0) {
                this.seQ.wo(233);
            }
            this.sfT++;
        }

        public final void byI() {
            this.sfT--;
            if (this.sfT <= 0) {
                this.seQ.wp(233);
            }
        }
    }

    protected class p {
        final /* synthetic */ WebViewUI seQ;
        int sfU = 0;

        protected p(WebViewUI webViewUI) {
            this.seQ = webViewUI;
        }
    }

    protected class r {
        final /* synthetic */ WebViewUI seQ;
        int sfV = 0;

        protected r(WebViewUI webViewUI) {
            this.seQ = webViewUI;
        }
    }

    enum x {
        NO_NEED,
        WILL_GET,
        FAILED
    }

    private class a implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        final /* synthetic */ WebViewUI seQ;

        public a(WebViewUI webViewUI) {
            this.seQ = webViewUI;
        }

        public final boolean xL(String str) {
            if (bg.mA(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eq(str, "weixin://jump/");
        }

        public final boolean xM(String str) {
            if (this.seQ.iYG.bxR().bHh()) {
                try {
                    this.seQ.iYF.ay(str, this.seQ.iYG.bxQ().nw(7));
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "ActivityJumpHandler, ex = " + e.getMessage());
                }
            } else {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "ActivityJumpHandler not allow, no inner url generalcontrol, url = %s", new Object[]{str});
            }
            return true;
        }
    }

    private class aa implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        final /* synthetic */ WebViewUI seQ;

        public aa(WebViewUI webViewUI) {
            this.seQ = webViewUI;
        }

        public final boolean xL(String str) {
            if (bg.mA(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eq(str, "weixin://viewimage/");
        }

        public final boolean xM(String str) {
            try {
                if (this.seQ.iYF.isSDCardAvailable()) {
                    this.seQ.mkT = str.substring(19);
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "viewimage currentUrl :" + this.seQ.mkT);
                    com.tencent.mm.pluginsdk.ui.tools.s.a(this.seQ.oET, "weixin://private/gethtml/", "'<head>' + document.getElementsByTagName('head')[0].innerHTML + '</head><body>' + document.getElementsByTagName('body')[0].innerHTML + '</body>'", this.seQ.sdm);
                    return true;
                }
                this.seQ.iYF.a(2, null, this.seQ.hashCode());
                return true;
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "edw handleUrl, ex = " + e.getMessage());
                return false;
            }
        }
    }

    private class b implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        final /* synthetic */ WebViewUI seQ;
        public final String sfN = "weixin://addfriend/";

        public b(WebViewUI webViewUI) {
            this.seQ = webViewUI;
        }

        public final boolean xL(String str) {
            if (bg.mA(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eq(str, "weixin://addfriend/");
        }

        public final boolean xM(String str) {
            if (this.seQ.iYG.bxQ().nw(5)) {
                String substring = str.substring(19);
                if (bg.mA(substring)) {
                    return false;
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("from_webview", true);
                bundle.putString("userName", substring);
                try {
                    this.seQ.iYF.a(8, bundle, this.seQ.hashCode());
                    return true;
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "AddFriendHandler, ex = " + e.getMessage());
                    return true;
                }
            }
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "AddFriendHandler, permission fail");
            return true;
        }
    }

    private class c implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        final /* synthetic */ WebViewUI seQ;

        public c(WebViewUI webViewUI) {
            this.seQ = webViewUI;
        }

        public final boolean xL(String str) {
            if (bg.mA(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eq(str, "weixin://webview/close/");
        }

        public final boolean xM(String str) {
            if (this.seQ.iYG.bxQ().nw(17)) {
                this.seQ.finish();
            } else {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "close window permission fail");
            }
            return true;
        }
    }

    private class e implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        final /* synthetic */ WebViewUI seQ;
        private final String sfP = "weixin://webview/copy/";

        public e(WebViewUI webViewUI) {
            this.seQ = webViewUI;
        }

        public final boolean xL(String str) {
            if (bg.mA(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eq(str, "weixin://webview/copy/");
        }

        public final boolean xM(String str) {
            CharSequence substring = str.substring(22);
            com.tencent.mm.pluginsdk.j.d.a(this.seQ, substring, substring);
            return true;
        }
    }

    private class f implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        final /* synthetic */ WebViewUI seQ;

        public f(WebViewUI webViewUI) {
            this.seQ = webViewUI;
        }

        public final boolean xL(String str) {
            if (bg.mA(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eq(str, "weixin://critical_update/");
        }

        public final boolean xM(String str) {
            com.tencent.mm.plugin.report.service.g.oUh.a(405, 25, 1, true);
            WebViewUI.g(this.seQ, 1);
            return true;
        }
    }

    private class g implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        final /* synthetic */ WebViewUI seQ;

        public g(WebViewUI webViewUI) {
            this.seQ = webViewUI;
        }

        public final boolean xL(String str) {
            if (bg.mA(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eq(str, "weixin://");
        }

        public final boolean xM(String str) {
            int a = this.seQ.JS(bg.mz(this.seQ.sdV));
            if (!com.tencent.mm.pluginsdk.d.X(str, this.seQ.mou)) {
                return false;
            }
            try {
                if ("weixin://dl/shopping".equals(str)) {
                    String bxq = this.seQ.iYF.bxq();
                    if (!bg.mA(bxq)) {
                        this.seQ.oET.loadUrl(bxq);
                    }
                } else if ("weixin://dl/faq".equals(str)) {
                    int bxs = this.seQ.iYF.bxs();
                    int bxt = this.seQ.iYF.bxt();
                    this.seQ.oET.loadUrl(com.tencent.mm.sdk.platformtools.ab.getContext().getString(R.l.eUp, new Object[]{Integer.valueOf(bxs), Integer.valueOf(bxt)}));
                } else if ("weixin://dl/posts".equals(str)) {
                    this.seQ.iYF.bxu();
                } else if ("weixin://dl/moments".equals(str)) {
                    this.seQ.iYF.bxv();
                } else if (str.startsWith("weixin://dl/feedback")) {
                    this.seQ.iYF.JA(str);
                } else if ("weixin://dl/scan".equals(str)) {
                    com.tencent.mm.bb.d.a(this.seQ, "scanner", ".ui.SingleTopScanUI", new Intent(), false);
                } else {
                    com.tencent.mm.pluginsdk.d.LG(str);
                }
                List arrayList = new ArrayList();
                arrayList.add(str);
                arrayList.add("1");
                arrayList.add(String.valueOf(a));
                arrayList.add(bg.mz(this.seQ.sdV));
                arrayList.add(bg.mz(this.seQ.fWY));
                this.seQ.iYF.f(11405, arrayList);
                return true;
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "kv report fail, ex = %s", new Object[]{e.getMessage()});
                return true;
            }
        }
    }

    private class j implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        final /* synthetic */ WebViewUI seQ;
        private final String sfR = "weixin://feedback/";

        public j(WebViewUI webViewUI) {
            this.seQ = webViewUI;
        }

        public final boolean xL(String str) {
            if (bg.mA(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eq(str, "weixin://feedback/");
        }

        public final boolean xM(String str) {
            Bundle bundle = new Bundle();
            bundle.putInt("MMActivity.OverrideEnterAnimation", 0);
            bundle.putInt("MMActivity.OverrideExitAnimation", R.a.aRo);
            try {
                this.seQ.iYF.a(7, bundle, this.seQ.hashCode());
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "FeedbackJumpHandler, ex = " + e.getMessage());
            }
            return true;
        }
    }

    private class k implements com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView.a {
        final /* synthetic */ WebViewUI seQ;

        public k(WebViewUI webViewUI) {
            this.seQ = webViewUI;
        }

        public final void sq(int i) {
            int i2 = 2;
            switch (i) {
                case 0:
                    i2 = 1;
                    break;
                case 2:
                    i2 = 3;
                    break;
                case 3:
                    i2 = 4;
                    break;
            }
            this.seQ.wt(i2);
            try {
                if (this.seQ.iYF.azg()) {
                    this.seQ.iYF.dx(16384, i2);
                    this.seQ.iYF.dx(16388, i2);
                }
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "onCheckedChanged, ex = " + e.getMessage());
            }
        }
    }

    private class l implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        final /* synthetic */ WebViewUI seQ;

        public l(WebViewUI webViewUI) {
            this.seQ = webViewUI;
        }

        public final boolean xL(String str) {
            if (bg.mA(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eq(str, "weixin://connectToFreeWifi/");
        }

        public final boolean xM(String str) {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("apKey");
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "apKey value = %s", new Object[]{queryParameter});
            String queryParameter2 = parse.getQueryParameter("ticket");
            if (!bg.mA(queryParameter)) {
                Intent intent = new Intent();
                intent.putExtra("free_wifi_schema_uri", parse.toString());
                intent.putExtra("free_wifi_ap_key", queryParameter);
                intent.putExtra("free_wifi_source", 5);
                if (!bg.mA(queryParameter2)) {
                    intent.putExtra("free_wifi_schema_ticket", queryParameter2);
                }
                intent.addFlags(67108864);
                com.tencent.mm.bb.d.b(com.tencent.mm.sdk.platformtools.ab.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent);
            }
            return true;
        }
    }

    private class o implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        final /* synthetic */ WebViewUI seQ;

        public o(WebViewUI webViewUI) {
            this.seQ = webViewUI;
        }

        public final boolean xL(String str) {
            if (bg.mA(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eq(str, "weixin://gethtml/");
        }

        public final boolean xM(String str) {
            if (!bg.mA(str)) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "[oneliang]get html content :" + str.substring(17));
                this.seQ.byq();
            }
            return false;
        }
    }

    private class q implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        final /* synthetic */ WebViewUI seQ;

        public q(WebViewUI webViewUI) {
            this.seQ = webViewUI;
        }

        public final boolean xL(String str) {
            if (bg.mA(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eq(str, "weixin://profile/");
        }

        public final boolean xM(String str) {
            String substring = str.substring(17);
            if (substring == null || substring.length() == 0) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "handleUrl fail, username is null");
            } else if (!(this.seQ.iYG == null || this.seQ.iYG.bxQ() == null || !this.seQ.iYG.bxQ().nw(2))) {
                this.seQ.rVm.Ka(substring);
            }
            return true;
        }
    }

    private class s implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        final /* synthetic */ WebViewUI seQ;

        public s(WebViewUI webViewUI) {
            this.seQ = webViewUI;
        }

        public final boolean xL(String str) {
            if (bg.mA(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eq(str, "weixin://manual_update/");
        }

        public final boolean xM(String str) {
            com.tencent.mm.plugin.report.service.g.oUh.a(405, 26, 1, true);
            WebViewUI.g(this.seQ, 3);
            return true;
        }
    }

    private class t implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        final /* synthetic */ WebViewUI seQ;

        public t(WebViewUI webViewUI) {
            this.seQ = webViewUI;
        }

        public final boolean xL(String str) {
            com.tencent.mm.plugin.webview.stub.d dVar = this.seQ.iYF;
            if (6 != this.seQ.getIntent().getIntExtra("geta8key_scene", 0)) {
                return !bg.mA(str) && dVar != null && com.tencent.mm.plugin.webview.model.y.b.a(dVar) && com.tencent.mm.plugin.webview.model.y.b.a(str, dVar);
            } else {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.OauthAuthorizeLogic", "shouldNativeOauthIntercept from oauth");
                return false;
            }
        }

        public final boolean xM(String str) {
            String stringExtra = this.seQ.getIntent().getStringExtra("geta8key_username");
            return com.tencent.mm.plugin.webview.model.y.b.a(str, stringExtra, this.seQ.JS(stringExtra), this.seQ.iYF, this.seQ.seL, this.seQ.seM);
        }
    }

    private class u implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        final /* synthetic */ WebViewUI seQ;

        public u(WebViewUI webViewUI) {
            this.seQ = webViewUI;
        }

        public final boolean xL(String str) {
            if (bg.mA(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eq(str, "weixin://readershare/");
        }

        public final boolean xM(String str) {
            com.tencent.mm.ui.base.g.a(this.seQ, "", new String[]{this.seQ.getString(R.l.eIf)}, "", new com.tencent.mm.ui.base.g.c(this) {
                final /* synthetic */ u sfW;

                {
                    this.sfW = r1;
                }

                public final void hq(int i) {
                    if (i == 0) {
                        u uVar = this.sfW;
                        try {
                            Bundle bundle = new Bundle();
                            bundle.putString("shortUrl", uVar.seQ.getIntent().getStringExtra("shortUrl"));
                            bundle.putInt(Columns.TYPE, uVar.seQ.getIntent().getIntExtra(Columns.TYPE, 0));
                            uVar.seQ.iYF.a(4, bundle, uVar.hashCode());
                        } catch (Exception e) {
                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "share fail, ex = " + e.getMessage());
                        }
                    }
                }
            });
            return true;
        }
    }

    private class v implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        final /* synthetic */ WebViewUI seQ;

        public v(WebViewUI webViewUI) {
            this.seQ = webViewUI;
        }

        public final boolean xL(String str) {
            if (bg.mA(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eq(str, "weixin://recommend_update/");
        }

        public final boolean xM(String str) {
            com.tencent.mm.plugin.report.service.g.oUh.a(405, 24, 1, true);
            WebViewUI.g(this.seQ, 2);
            return true;
        }
    }

    private class w implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        final /* synthetic */ WebViewUI seQ;
        private final String sfP = "weixin://openapi/openwebview/result?";

        public w(WebViewUI webViewUI) {
            this.seQ = webViewUI;
        }

        public final boolean xL(String str) {
            if (bg.mA(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eq(str, "weixin://openapi/openwebview/result?");
        }

        public final boolean xM(String str) {
            Resp resp = new Resp();
            Uri parse = Uri.parse(str);
            resp.result = parse.getQuery();
            resp.errCode = bg.getInt(parse.getQueryParameter("errCode"), 0);
            resp.errStr = parse.getQueryParameter("errMsg");
            resp.transaction = this.seQ.getIntent().getStringExtra("transaction_for_openapi_openwebview");
            String queryParameter = parse.getQueryParameter("appid");
            if (bg.mA(queryParameter)) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "SDKOpenWebViewResultHandler handleUrl, appId is null");
            } else {
                Bundle bundle = new Bundle();
                resp.toBundle(bundle);
                com.tencent.mm.pluginsdk.model.app.p.aa(bundle);
                Args args = new Args();
                try {
                    args.targetPkgName = this.seQ.iYF.Js(queryParameter);
                    args.bundle = bundle;
                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "SDKOpenWebViewResultHandler, handleUrl, sendResp:%s", new Object[]{args});
                    MMessageActV2.send(this.seQ, args);
                    this.seQ.finish();
                } catch (Throwable e) {
                    com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.WebViewUI", e, "", new Object[0]);
                }
            }
            return true;
        }
    }

    private class y implements IUtils {
        final /* synthetic */ WebViewUI seQ;

        public y(WebViewUI webViewUI) {
            this.seQ = webViewUI;
        }

        public final void javaUtilLog(int i, String str, String str2) {
            switch (i) {
                case 2:
                    com.tencent.mm.sdk.platformtools.w.v(str, str2);
                    return;
                case 3:
                    com.tencent.mm.sdk.platformtools.w.d(str, str2);
                    return;
                case 4:
                    com.tencent.mm.sdk.platformtools.w.i(str, str2);
                    return;
                case 5:
                    com.tencent.mm.sdk.platformtools.w.w(str, str2);
                    return;
                case 6:
                    com.tencent.mm.sdk.platformtools.w.e(str, str2);
                    return;
                default:
                    return;
            }
        }

        public final void httpproxyReport(String... strArr) {
            com.tencent.mm.plugin.webview.model.ai.h bwF = this.seQ.rWq.bwF();
            if (!(strArr == null || strArr.length == 0)) {
                if (bwF.rXF == null) {
                    bwF.rXF = new ArrayList();
                } else {
                    bwF.rXF.clear();
                }
                for (Object add : strArr) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebviewReporter", "WebViewVideoProxyReporter report info = %s", new Object[]{strArr[r0]});
                    bwF.rXF.add(add);
                }
            }
            com.tencent.mm.plugin.webview.model.ai.h bwF2 = this.seQ.rWq.bwF();
            com.tencent.mm.plugin.webview.stub.d dVar = this.seQ.iYF;
            if (bwF2.rXF != null && bwF2.rXF.size() != 0 && dVar != null) {
                d.a(dVar, 12033, bwF2.rXF);
                bwF2.rXF.clear();
            }
        }

        public final void idKeyReport(String str, String str2, String str3) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "idkey report, id = %s, key = %s, value = %s", new Object[]{str, str2, str3});
            if (!bg.mA(str) && !bg.mA(str2) && !bg.mA(str3)) {
                com.tencent.mm.plugin.report.service.g.oUh.a((long) bg.getInt(str, 0), (long) bg.getInt(str2, 0), (long) bg.getInt(str3, 0), false);
            }
        }

        public final void kvReport(String... strArr) {
            com.tencent.mm.plugin.webview.model.ai.g bwG = this.seQ.rWq.bwG();
            if (!(strArr == null || strArr.length == 0)) {
                if (bwG.rXF == null) {
                    bwG.rXF = new ArrayList();
                } else {
                    bwG.rXF.clear();
                }
                for (Object add : strArr) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebviewReporter", "WebViewVideoDownloadReporter report info = %s", new Object[]{strArr[r0]});
                    bwG.rXF.add(add);
                }
            }
            com.tencent.mm.plugin.webview.model.ai.g bwG2 = this.seQ.rWq.bwG();
            com.tencent.mm.plugin.webview.stub.d dVar = this.seQ.iYF;
            if (bwG2.rXF != null && bwG2.rXF.size() != 0 && dVar != null) {
                d.a(dVar, 12666, bwG2.rXF);
                bwG2.rXF.clear();
            }
        }
    }

    private class z implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        final /* synthetic */ WebViewUI seQ;

        public z(WebViewUI webViewUI) {
            this.seQ = webViewUI;
        }

        public final boolean xL(String str) {
            if (bg.mA(str)) {
                return false;
            }
            return com.tencent.mm.pluginsdk.ui.tools.s.eq(str, "weixin://private/gethtml/");
        }

        public final boolean xM(String str) {
            try {
                String decode = URLDecoder.decode(str.substring(25));
                Bundle bundle = new Bundle();
                bundle.putString("nowUrl", this.seQ.mkT);
                bundle.putString("tweetid", bg.mz(this.seQ.getIntent().getStringExtra("tweetid")));
                bundle.putString("htmlData", decode);
                bundle.putInt(Columns.TYPE, this.seQ.getIntent().getIntExtra(Columns.TYPE, 0));
                this.seQ.iYF.a(3, bundle, this.seQ.hashCode());
                return true;
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "edw ViewImageGetHtmlHandler handleUrl, ex = " + e.getMessage());
                return false;
            }
        }
    }

    static /* synthetic */ void T(WebViewUI webViewUI) {
        webViewUI.byw();
        if (!webViewUI.azQ()) {
            webViewUI.sel = true;
            g.scG.close();
            webViewUI.finish();
        }
    }

    static /* synthetic */ void U(WebViewUI webViewUI) {
        View view = webViewUI.oET.getView();
        view.scrollTo(view.getScrollX(), 0);
        com.tencent.mm.plugin.webview.model.ai.f bwD = webViewUI.rWq.bwD();
        bwD.rXz = new Object[]{webViewUI.fWY, Integer.valueOf(7)};
        bwD.b(webViewUI.iYF);
    }

    static /* synthetic */ void a(WebViewUI webViewUI, MenuItem menuItem) {
        if (menuItem instanceof com.tencent.mm.ui.base.m) {
            String str = ((com.tencent.mm.ui.base.m) menuItem).iMP;
            if (!bg.mA(str) && !str.equals(webViewUI.oET.getUrl())) {
                webViewUI.oET.loadUrl(str);
            }
        }
    }

    static /* synthetic */ void a(WebViewUI webViewUI, ViewGroup viewGroup, WindowInsets windowInsets) {
        if (webViewUI.jkQ != windowInsets.getSystemWindowInsetTop()) {
            webViewUI.jkQ = windowInsets.getSystemWindowInsetTop();
            webViewUI.bxZ();
            if (viewGroup instanceof SwipeBackLayout) {
                viewGroup = viewGroup.getChildAt(0);
            }
            int i = R.h.JN;
            if (i > 0) {
                View findViewById = viewGroup.findViewById(i);
                if (findViewById != null) {
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) findViewById.getLayoutParams();
                    marginLayoutParams.topMargin = windowInsets.getSystemWindowInsetTop();
                    findViewById.setLayoutParams(marginLayoutParams);
                    findViewById.requestLayout();
                }
            }
            if (webViewUI.byb()) {
                webViewUI.setStatusBarColor(webViewUI.WR());
            }
        }
    }

    static /* synthetic */ void a(WebViewUI webViewUI, WebViewKeyboardLinearLayout webViewKeyboardLinearLayout, int i) {
        if (!webViewUI.sdp) {
            return;
        }
        if (webViewUI.oET.getX5WebViewExtension() == null && VERSION.SDK_INT < 19) {
            return;
        }
        if (i == -3) {
            final int i2 = webViewKeyboardLinearLayout.scd;
            webViewUI.handler.post(new Runnable(webViewUI) {
                final /* synthetic */ WebViewUI seQ;

                public final void run() {
                    if (this.seQ.rVm != null) {
                        this.seQ.rVm.wC(i2);
                    }
                }
            });
            return;
        }
        webViewUI.handler.post(new Runnable(webViewUI) {
            final /* synthetic */ WebViewUI seQ;

            {
                this.seQ = r1;
            }

            public final void run() {
                if (this.seQ.rVm != null) {
                    this.seQ.rVm.wC(0);
                }
            }
        });
    }

    static /* synthetic */ void a(WebViewUI webViewUI, String str, long j) {
        final Intent intent = new Intent(webViewUI, WebViewDownloadWithX5UI.class);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.putExtra("task_url", str);
        intent.putExtra("page_url", webViewUI.azN());
        intent.putExtra("task_size", j);
        if (WebView.getTbsCoreVersion(webViewUI) < 43305) {
            webViewUI.startActivity(intent);
        } else {
            QbSdk.fileInfoDetect(webViewUI, str, new com.tencent.smtt.sdk.y<String>(webViewUI) {
                final /* synthetic */ WebViewUI seQ;

                public final /* synthetic */ void onReceiveValue(Object obj) {
                    String str = (String) obj;
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "onReceiveValue value = %s", new Object[]{str});
                    if (!bg.mA(str)) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.optBoolean("ret")) {
                                intent.putExtra("title", jSONObject.optString("appName"));
                                intent.putExtra("thumb_url", jSONObject.optString("apkIconUrl"));
                            }
                        } catch (Throwable e) {
                            com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.WebViewUI", e, "onReceiveValue", new Object[0]);
                        }
                    }
                    this.seQ.startActivity(intent);
                }
            });
        }
    }

    static /* synthetic */ void a(WebViewUI webViewUI, String str, String str2, int i, int i2) {
        if (webViewUI.iYG == null) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "startGetReadingModeInfo fail, after onDestroy");
            return;
        }
        p pVar = webViewUI.sdB;
        if (pVar.sfU == 0) {
            pVar.seQ.wo(673);
        }
        pVar.sfU++;
        webViewUI.sdL = str;
        webViewUI.sdK = true;
        Bundle bundle = new Bundle();
        bundle.putString("reading_mode_data_url", str);
        bundle.putString("reading_mode_data_useragent", str2);
        bundle.putInt("reading_mode_data_width", i);
        bundle.putInt("reading_mode_data_height", i2);
        boolean z = false;
        try {
            z = webViewUI.iYF.q(673, bundle);
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "startGetReadingModeInfo, ex = " + e.getMessage());
        }
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "startGetReadingModeInfo, doScene ret = " + z);
    }

    static /* synthetic */ void ab(WebViewUI webViewUI) {
        CharSequence url = webViewUI.oET.getUrl();
        if (url == null || url.length() == 0) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "copyLink fail, url is null");
            return;
        }
        CharSequence xH;
        try {
            xH = webViewUI.iYF.xH(url);
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "copy link failed");
            xH = url;
        }
        ClipboardManager clipboardManager = (ClipboardManager) webViewUI.getSystemService("clipboard");
        if (clipboardManager != null) {
            try {
                clipboardManager.setText(xH);
                Toast.makeText(webViewUI, webViewUI.getString(R.l.fnn), 0).show();
                return;
            } catch (Throwable e2) {
                com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.WebViewUI", e2, "clip.setText error", new Object[0]);
                return;
            }
        }
        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "clipboard manager is null");
    }

    static /* synthetic */ void ac(WebViewUI webViewUI) {
        com.tencent.mm.plugin.webview.stub.d dVar = webViewUI.iYF;
        if (webViewUI != null && !webViewUI.isFinishing()) {
            String azN = webViewUI.azN();
            if (bg.mA(azN)) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.BrowserChooserHelper", "open in browser fail, url is null");
                return;
            }
            if (dVar != null) {
                try {
                    azN = dVar.xH(azN);
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.BrowserChooserHelper", "showAndOpenInBrowser, getShareUrl, exception = %s", new Object[]{e});
                }
            }
            if (!(azN.startsWith("http://") || azN.startsWith("https://"))) {
                azN = "http://" + azN;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(azN));
            try {
                if (bg.Hp()) {
                    webViewUI.startActivity(intent);
                } else {
                    webViewUI.startActivityForResult(com.tencent.mm.plugin.webview.d.a.a(webViewUI, intent, azN), 2);
                }
            } catch (Exception e2) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.BrowserChooserHelper", "open in browser failed : %s", new Object[]{e2.getMessage()});
            }
        }
    }

    static /* synthetic */ void ad(WebViewUI webViewUI) {
        webViewUI.rVm.az("sendEmail", true);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.rVm;
        if (dVar.sjS) {
            dVar.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:share:email", new HashMap(), dVar.sjU, dVar.sjV) + ")", null);
            return;
        }
        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.JsApiHandler", "onSendMail fail, not ready");
    }

    static /* synthetic */ void aj(WebViewUI webViewUI) {
        webViewUI.rVm.az(GameJsApiSendAppMessage.NAME, true);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.rVm;
        if (dVar.sjS) {
            dVar.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:share:appmessage", new HashMap(), dVar.sjU, dVar.sjV) + ")", null);
            try {
                dVar.iYF.D("scene", "wework", dVar.rZN);
                return;
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                return;
            }
        }
        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.JsApiHandler", "onShareWeWork fail, not ready");
    }

    static /* synthetic */ void ak(WebViewUI webViewUI) {
        String str = null;
        try {
            str = webViewUI.iYF.xH(webViewUI.oET.getUrl());
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "getShareUrl failed : %s", new Object[]{e.getMessage()});
        }
        if (bg.mA(str)) {
            str = webViewUI.fWY;
        }
        try {
            str = "weread://mp?url=" + com.tencent.mm.compatible.util.p.encode(str, ProtocolPackage.ServerEncoding);
        } catch (Exception e2) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "encode url failed ; %s", new Object[]{e2.getMessage()});
        }
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "now url = %s", new Object[]{str});
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        if (bg.j(webViewUI.uSU.uTo, intent)) {
            webViewUI.startActivity(intent);
        } else {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "not availble app match this intent");
        }
    }

    static /* synthetic */ void al(WebViewUI webViewUI) {
        webViewUI.rVm.az("shareQQ", true);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.rVm;
        if (dVar.sjS) {
            dVar.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:share:qq", new HashMap(), dVar.sjU, dVar.sjV) + ")", null);
            return;
        }
        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.JsApiHandler", "onShareQQ fail, not ready");
    }

    static /* synthetic */ void am(WebViewUI webViewUI) {
        webViewUI.rVm.az("shareWeiboApp", true);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.rVm;
        if (dVar.sjS) {
            dVar.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:share:weiboApp", new HashMap(), dVar.sjU, dVar.sjV) + ")", null);
            return;
        }
        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.JsApiHandler", "onShareWeiboApp fail, not ready");
    }

    static /* synthetic */ void an(WebViewUI webViewUI) {
        webViewUI.rVm.az("shareQZone", true);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.rVm;
        if (dVar.sjS) {
            dVar.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:share:QZone", new HashMap(), dVar.sjU, dVar.sjV) + ")", null);
            return;
        }
        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.JsApiHandler", "onShareQzone fail, not ready");
    }

    static /* synthetic */ void ao(WebViewUI webViewUI) {
        webViewUI.rVm.az(GameJsApiSendAppMessage.NAME, true);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.rVm;
        if (dVar.sjS) {
            dVar.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:share:appmessage", new HashMap(), dVar.sjU, dVar.sjV) + ")", null);
            try {
                dVar.iYF.D("scene", "facebook", dVar.rZN);
                return;
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                return;
            }
        }
        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.JsApiHandler", "onShareFaceBook fail, not ready");
    }

    static /* synthetic */ void ap(WebViewUI webViewUI) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("enterprise_action", "enterprise_connectors");
            final Object stringArrayList = webViewUI.iYF.d(71, bundle).getStringArrayList("enterprise_connectors");
            if (stringArrayList != null && stringArrayList.size() > 0) {
                if (stringArrayList.size() == 1) {
                    webViewUI.JP((String) stringArrayList.get(0));
                    return;
                }
                webViewUI.bN(stringArrayList);
                com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(webViewUI.uSU.uTo);
                lVar.a(webViewUI.oET, webViewUI, null);
                lVar.wnf = new com.tencent.mm.ui.base.n.a(webViewUI) {
                    final /* synthetic */ WebViewUI seQ;

                    {
                        this.seQ = r1;
                    }

                    public final void a(ImageView imageView, MenuItem menuItem) {
                        if (WebViewUI.i(menuItem)) {
                            imageView.setVisibility(8);
                            return;
                        }
                        String str = menuItem.getTitle();
                        if (this.seQ.sdE.get(str) == null || ((Bitmap) this.seQ.sdE.get(str)).isRecycled()) {
                            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "on attach icon, load from cache fail");
                            try {
                                String Jp = this.seQ.iYF.Jp(str);
                                if (!bg.mA(Jp)) {
                                    Bitmap JG = d.JG(Jp);
                                    if (JG != null && !JG.isRecycled()) {
                                        imageView.setImageBitmap(JG);
                                        this.seQ.sdE.put(str, JG);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            } catch (Exception e) {
                                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "getheadimg, ex = " + e.getMessage());
                                return;
                            }
                        }
                        imageView.setImageBitmap((Bitmap) this.seQ.sdE.get(str));
                    }
                };
                lVar.wng = new com.tencent.mm.ui.base.n.b(webViewUI) {
                    final /* synthetic */ WebViewUI seQ;

                    {
                        this.seQ = r1;
                    }

                    public final void a(TextView textView, MenuItem menuItem) {
                        String str = menuItem.getTitle();
                        if (textView != null) {
                            String str2 = (String) this.seQ.sdF.get(str);
                            if (bg.mA(str2)) {
                                textView.setText(str);
                            } else {
                                textView.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.seQ.uSU.uTo, str2, textView.getTextSize()));
                            }
                        }
                    }
                };
                lVar.b(webViewUI.oET, new OnCreateContextMenuListener(webViewUI) {
                    final /* synthetic */ WebViewUI seQ;

                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        Iterator it = stringArrayList.iterator();
                        while (it.hasNext()) {
                            contextMenu.add((String) it.next());
                        }
                    }
                }, new com.tencent.mm.ui.base.n.d(webViewUI) {
                    final /* synthetic */ WebViewUI seQ;

                    {
                        this.seQ = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        this.seQ.JP(menuItem.getTitle().toString());
                    }
                });
                lVar.blb();
            }
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "builder add, ex = " + e.getMessage());
        }
    }

    static /* synthetic */ void b(WebViewUI webViewUI, int i) {
        if (webViewUI.scX != null && com.tencent.mm.compatible.util.d.eo(21) && webViewUI.bxX()) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) webViewUI.scX.getLayoutParams();
            if (marginLayoutParams.bottomMargin != i) {
                marginLayoutParams.bottomMargin = i;
                webViewUI.scX.setLayoutParams(marginLayoutParams);
            }
        }
    }

    static /* synthetic */ void b(WebViewUI webViewUI, String str) {
        if (webViewUI.iYF != null) {
            Bundle bundle = new Bundle(1);
            bundle.putString("show_kb_input_callback_text", bg.mz(str));
            try {
                webViewUI.iYF.a(41, bundle, webViewUI.hashCode());
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "showKbInputCallback, exception = %s, text = %s", new Object[]{e, str});
            }
        }
        if (webViewUI.scX != null) {
            webViewUI.scX.hide();
        }
    }

    static /* synthetic */ void c(WebViewUI webViewUI, int i) {
        if (webViewUI.scY != null && com.tencent.mm.compatible.util.d.eo(21) && webViewUI.bxX()) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) webViewUI.scY.getLayoutParams();
            if (marginLayoutParams.bottomMargin != i) {
                marginLayoutParams.bottomMargin = i;
                webViewUI.scY.setLayoutParams(marginLayoutParams);
            }
            webViewUI.oET.setPadding(webViewUI.oET.getPaddingLeft(), webViewUI.oET.getPaddingTop(), webViewUI.oET.getPaddingRight(), webViewUI.scY.getVisibility() == 0 ? webViewUI.scY.getHeight() + i : 0);
        }
    }

    static /* synthetic */ void e(WebViewUI webViewUI, String str) {
        try {
            webViewUI.iYF.Jx(str);
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "sendImgToFriend fail, ex = " + e.getMessage());
        }
    }

    static /* synthetic */ void f(WebViewUI webViewUI, String str) {
        try {
            com.tencent.mm.pluginsdk.model.c.a(webViewUI.iYF.Jw(str), 34, webViewUI, webViewUI.mnV);
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "favoriteUrl fail, ex = " + e.getMessage());
        }
    }

    static /* synthetic */ void g(WebViewUI webViewUI, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("update_type_key", i);
        try {
            webViewUI.iYF.a(1, bundle, webViewUI.hashCode());
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "doUpdate fail, ex = " + e.getMessage());
        }
    }

    static /* synthetic */ void h(WebViewUI webViewUI, String str) {
        if (webViewUI.rVm != null) {
            Bundle bundle = new Bundle();
            bundle.putInt(str, 43);
            com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.rVm;
            try {
                dVar.iYF.a(21, bundle, dVar.rZN);
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.JsApiHandler", "updateJsapiArgsBundleKV, ex = " + e);
            }
        }
    }

    static /* synthetic */ void i(WebViewUI webViewUI, String str) {
        webViewUI.rVm.az("profile", true);
        webViewUI.rVm.Ka(str);
    }

    static /* synthetic */ boolean i(MenuItem menuItem) {
        return menuItem.getItemId() >= 10000;
    }

    static /* synthetic */ void j(WebViewUI webViewUI, String str) {
        if (!(bg.mA(str) || str.equals(webViewUI.oET.getUrl()))) {
            webViewUI.oET.loadUrl(str);
        }
        webViewUI.sdK = false;
    }

    static /* synthetic */ void l(WebViewUI webViewUI, String str) {
        webViewUI.rVm.az(GameJsApiSendAppMessage.NAME, false);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.rVm;
        if (dVar.sjS) {
            Map hashMap = new HashMap();
            hashMap.put("scene", "connector");
            dVar.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:share:appmessage", hashMap, dVar.sjU, dVar.sjV) + ")", null);
            try {
                dVar.iYF.D("connector_local_send", str, dVar.rZN);
                dVar.iYF.D("scene", "connector", dVar.rZN);
                return;
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                return;
            }
        }
        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.JsApiHandler", "onSendToConnector fail, not ready");
    }

    static /* synthetic */ void p(WebViewUI webViewUI) {
        webViewUI.sez.sco = new com.tencent.mm.plugin.webview.ui.tools.f.a(webViewUI) {
            final /* synthetic */ WebViewUI seQ;

            {
                this.seQ = r1;
            }

            public final void bxU() {
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "onPullDownRefresh, start");
                if (this.seQ.rVm != null) {
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.seQ.rVm;
                    if (dVar.sjS) {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.JsApiHandler", "onPullDownRefresh success, ready");
                        af.v(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass35(dVar, com.tencent.mm.plugin.webview.ui.tools.jsapi.d.Kc(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onPullDownRefresh", null, dVar.sjU, dVar.sjV))));
                        return;
                    }
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.JsApiHandler", "onPullDownRefresh fail, not ready");
                }
            }
        };
        f fVar = webViewUI.sez;
        fVar.iEh = true;
        if (fVar.scq != null) {
            fVar.scq.setVisibility(0);
            fVar.scq.saM = fVar;
            fVar.scq.saJ = true;
            fVar.scq.iQ(false);
            fVar.scq.saK = fVar.scr;
        }
        if (fVar.scp != null) {
            fVar.scp.setWillNotDraw(true);
            fVar.scp.setImageResource(f.scs);
            fVar.scp.setVisibility(0);
            fVar.scp.setAlpha(0.0f);
            fVar.scp.setWillNotDraw(false);
            fVar.scp.invalidate();
        }
        if (fVar.scB != null) {
            fVar.scB.setVisibility(8);
        }
    }

    static /* synthetic */ void q(WebViewUI webViewUI) {
        if (webViewUI.oET != null) {
            webViewUI.oET.evaluateJavascript("javascript:(function(){return window.getComputedStyle(document.body,null).backgroundColor})()", new com.tencent.smtt.sdk.y<String>(webViewUI) {
                final /* synthetic */ WebViewUI seQ;

                {
                    this.seQ = r1;
                }

                public final /* synthetic */ void onReceiveValue(Object obj) {
                    String str = (String) obj;
                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "get background color s = %s", new Object[]{str});
                    if (!bg.mA(str)) {
                        int color = this.seQ.getResources().getColor(R.e.aWs);
                        String[] split;
                        if (WebViewUI.mnk.matcher(str).matches()) {
                            split = str.replaceAll("\"", "").replaceFirst("rgba", "").replaceFirst("\\(", "").replaceFirst("\\)", "").split(",");
                            if (split.length == 4) {
                                try {
                                    color = Color.argb(bg.getInt(bg.mz(split[3]).trim(), 0), bg.getInt(bg.mz(split[0]).trim(), 0), bg.getInt(bg.mz(split[1]).trim(), 0), bg.getInt(bg.mz(split[2]).trim(), 0));
                                } catch (Exception e) {
                                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "handle bgColor from html, bgColor = %s, exception = %s", new Object[]{str, e});
                                    return;
                                }
                            }
                            return;
                        } else if (WebViewUI.mnl.matcher(str).matches()) {
                            split = str.replaceAll("\"", "").replaceFirst("rgb", "").replaceFirst("\\(", "").replaceFirst("\\)", "").split(",");
                            if (split.length == 3) {
                                try {
                                    color = Color.argb(255, bg.getInt(bg.mz(split[0]).trim(), 0), bg.getInt(bg.mz(split[1]).trim(), 0), bg.getInt(bg.mz(split[2]).trim(), 0));
                                } catch (Exception e2) {
                                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "handle bgColor from html, bgColor = %s, exception = %s", new Object[]{str, e2});
                                    return;
                                }
                            }
                            return;
                        } else {
                            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "handle bgColor from html, bgColor = %s, can not match", new Object[]{str});
                        }
                        this.seQ.sez.wm(color);
                        this.seQ.sez.bxT();
                    }
                }
            });
        }
    }

    static {
        Set hashSet = new HashSet();
        rWS = hashSet;
        hashSet.add("file:///android_asset/");
        String str = com.tencent.mm.compatible.util.e.hgr;
        if (!bg.mA(str)) {
            str = com.tencent.mm.compatible.util.e.hgr.replace("/data/user/0", "/data/data");
        }
        rWS.add("file://" + new File(str, "fts/res").getAbsolutePath());
        rWS.add("file://" + new File(com.tencent.mm.compatible.util.e.hgu, "fts/res").getAbsolutePath());
        rWS.add("file://" + new File(str, "wenote/res").getAbsolutePath());
        rWS.add("file://" + new File(com.tencent.mm.compatible.util.e.hgu, "wenote/res").getAbsolutePath());
        rWS.add("file://" + new File(str, "wxa_fts/res").getAbsolutePath());
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s, wxapp : %s", new Object[]{r1.getAbsolutePath(), r2.getAbsolutePath(), r3.getAbsolutePath()});
        rWS.add("file://" + new File(str, "emoji/res").getAbsolutePath());
        rWS.add("file://" + new File(com.tencent.mm.compatible.util.e.hgu, "emoji/res").getAbsolutePath());
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[]{r1.getAbsolutePath(), r0.getAbsolutePath()});
        Iterator it = rWS.iterator();
        while (it.hasNext()) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "albie: WebViewUI white list path : %s", new Object[]{(String) it.next()});
        }
    }

    public void R(Bundle bundle) {
        int color;
        int i;
        boolean z = bundle.getBoolean("set_navigation_bar_color_reset", false);
        if (z) {
            color = getResources().getColor(R.e.aSB);
            i = 255;
        } else {
            color = bundle.getInt("set_navigation_bar_color_color");
            i = bundle.getInt("set_navigation_bar_color_alpha");
        }
        Drawable colorDrawable = new ColorDrawable(color);
        colorDrawable.setAlpha(i);
        if (cO().cP() != null) {
            cO().cP().setBackgroundDrawable(colorDrawable);
        }
        View customView = cO().cP().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(R.h.divider);
            if (findViewById != null && !z) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "setNavigationBar set divider half_alpha_white color");
                findViewById.setBackgroundColor(getResources().getColor(R.e.aUl));
            } else if (findViewById != null && z) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "setNavigationBar set divider actionbar_devider_color color");
                findViewById.setBackgroundColor(getResources().getColor(R.e.aSE));
            }
            customView.setBackgroundDrawable(colorDrawable);
            customView.invalidate();
            if (color == getResources().getColor(R.e.aSB)) {
                color = getResources().getColor(R.e.aVV);
            } else {
                color = d.d(color, WebView.NIGHT_MODE_COLOR, 0.8f);
            }
            setStatusBarColor(color);
            return;
        }
        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "setNavigationBar view is null");
    }

    private void xE(String str) {
        if (this.oET != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.oET, new Object[0]);
            } catch (NoSuchMethodException e) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "No such method: " + str + ", " + e.toString());
            } catch (IllegalAccessException e2) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "Illegal Access: " + str + ", " + e2.toString());
            } catch (InvocationTargetException e3) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "Invocation Target Exception: " + str + ", " + e3.toString());
            } catch (Exception e4) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "Exception : " + str + ", " + e4.toString());
            }
        }
    }

    private void iR(boolean z) {
        if (!z) {
            this.sdt = true;
        }
    }

    public void onResume() {
        super.onResume();
        this.rWq.bwA().rXO = bg.NA();
        g gVar = g.scG;
        if (!bg.mA(gVar.qdW)) {
            gVar.mN(7);
        }
        if (!this.ses) {
            int hashCode = hashCode();
            for (int size = sds.size() - 1; size >= 0; size--) {
                if (((ab) sds.get(size)).id == hashCode) {
                    sds.remove(size);
                    break;
                }
            }
            sds.add(new ab(this));
        }
        this.ses = false;
        if (this.sdt) {
            iR(true);
            this.sdt = false;
        }
        byh();
        if (this.iYF != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("screen_orientation", this.screenOrientation);
                this.iYF.d(83, bundle);
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "ac_set_screen_orientation : " + e.getMessage());
            }
        }
        if (getIntent().getBooleanExtra("disable_swipe_back", false) && this.uUD != null) {
            this.uUD.mEnable = false;
        }
        xE("onResume");
        xD("onResume");
        try {
            if (this.iYF != null) {
                bundle = this.iYF.d(19, null);
                if (bundle != null) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "onResume, has init = %b", new Object[]{Boolean.valueOf(bundle.getBoolean("webview_video_proxy_init"))});
                    if (bundle.getBoolean("webview_video_proxy_init")) {
                        FactoryProxyManager.getPlayManager().appToFront();
                    }
                }
            }
        } catch (Exception e2) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "notify app tofront failed : %s", new Object[]{e2.getMessage()});
        }
        this.jXw = bg.Ny();
        com.tencent.mm.modelstat.d.a(3, "WebViewUI_" + JS(bg.mz(this.sdV)), hashCode());
        com.tencent.mm.pluginsdk.n.unlock();
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.modelstat.d.a(4, "WebViewUI_" + JS(bg.mz(this.sdV)), hashCode());
        com.tencent.mm.modelstat.d.d("WebViewUI_" + JS(bg.mz(this.sdV)), this.jXw, bg.Ny());
        com.tencent.mm.plugin.webview.model.ai.i bwA = this.rWq.bwA();
        if (bwA.rXO != -1) {
            bwA.jgn += bg.aB(bwA.rXO) / 1000;
        }
        g gVar = g.scG;
        if (gVar.hoD) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewReportUtil", "isFinish is true");
        } else if (!bg.mA(gVar.qdW)) {
            gVar.mN(6);
        }
        try {
            if (this.iYF != null) {
                Bundle d = this.iYF.d(19, null);
                if (d != null) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "onPause, has init = %b", new Object[]{Boolean.valueOf(d.getBoolean("webview_video_proxy_init"))});
                    if (d.getBoolean("webview_video_proxy_init")) {
                        FactoryProxyManager.getPlayManager().appToBack();
                    }
                }
            }
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "notify app toback failed : %s", new Object[]{e.getMessage()});
        }
        byp();
        xE("onPause");
        xD("onPause");
        if (this.sdw != null) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "onPause, now try to hide customview");
            try {
                this.sdw.onHideCustomView();
            } catch (Throwable e2) {
                com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.WebViewUI", e2, "onPause", new Object[0]);
            }
        }
        com.tencent.mm.pluginsdk.n.lock();
    }

    public void finish() {
        if (this.sdg) {
            setResult(-1);
        }
        try {
            if (this.iYF != null) {
                this.iYF.wb(hashCode());
                this.iYF.vX(hashCode());
            }
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "invoke onWebViewUIDestroy");
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "onDestroy, remove callback and invoke event on webview destroy, ex = " + e);
        }
        this.sem = true;
        super.finish();
    }

    public int getLayoutId() {
        return R.i.cSk;
    }

    protected final boolean bxV() {
        return getIntent().getBooleanExtra("convertActivityFromTranslucent", true);
    }

    public void qP(String str) {
        super.qP(str);
        zh(getResources().getColor(R.e.aSC));
    }

    private void xD(String str) {
        if (this.rVm != null) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.rVm;
            if (dVar.sjS) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.JsApiHandler", "onActivityStateChanged, state = " + str);
                Map hashMap = new HashMap();
                hashMap.put("state", str);
                String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("activity:state_change", hashMap, dVar.sjU, dVar.sjV);
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    try {
                        dVar.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", new Object[]{e.getMessage()});
                    }
                } else {
                    af.v(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass2(dVar, a));
                }
            } else {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.JsApiHandler", "onActivityStateChanged fail, not ready");
            }
            try {
                if (str.equals("onPause")) {
                    this.iYF.wd(hashCode());
                } else if (str.equals("onResume")) {
                    this.iYF.wc(hashCode());
                }
            } catch (Exception e2) {
                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "onResume, ex = " + e2.getMessage());
            }
        }
    }

    protected boolean bxH() {
        return false;
    }

    private void bxW() {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "edw tryBindService");
        bindService(new Intent(this, WebViewStubService.class), this.mgm, 1);
    }

    protected final void SC() {
        aq(5);
        aq(9);
        setProgressBarIndeterminateVisibility(false);
    }

    @TargetApi(11)
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "onCreate" + hashCode());
        this.sdn = getIntent().getIntExtra("geta8key_session_id", (int) System.currentTimeMillis());
        this.sdb = bym();
        this.screenOrientation = getIntent().getIntExtra("screen_orientation", -1);
        this.scU = getIntent().getBooleanExtra("show_full_screen", false);
        this.sdl = getIntent().getBooleanExtra("from_shortcut", false);
        this.fWY = bym();
        this.sea = getIntent().getBooleanExtra("show_native_web_view", false);
        this.sda = getIntent().getBooleanExtra("key_trust_url", false);
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "albie: trustUrl : %b.", new Object[]{Boolean.valueOf(this.sda)});
        sek++;
        sds.add(new ab(this));
        if (sds.size() > 1) {
            ab abVar = (ab) sds.get(sds.size() - 2);
            if (!(abVar.qQW == null || abVar.qQW.get() == null)) {
                ((WebViewUI) abVar.qQW.get()).iR(false);
            }
        }
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "initView , rawUrl = %s ", new Object[]{this.fWY});
        this.fUX = bg.mz(getIntent().getStringExtra("KPublisherId"));
        this.gaA = JS(getIntent().getStringExtra("geta8key_username"));
        com.tencent.mm.plugin.webview.model.ai.l bww = this.rWq.bww();
        int i = this.gaA;
        String str = this.fUX;
        bww.gaA = i;
        bww.rXD = str;
        this.handler = new ae();
        if (VERSION.SDK_INT >= 11) {
            getWindow().setFlags(16777216, 16777216);
        }
        getWindow().setFormat(-3);
        this.mnT.clear();
        this.mnT.put("menuItem:share:brand", Integer.valueOf(0));
        this.mnT.put("menuItem:share:appMessage", Integer.valueOf(1));
        this.mnT.put("menuItem:share:dataMessage", Integer.valueOf(23));
        this.mnT.put("menuItem:share:timeline", Integer.valueOf(2));
        this.mnT.put("menuItem:favorite", Integer.valueOf(3));
        this.mnT.put("menuItem:profile", Integer.valueOf(5));
        this.mnT.put("menuItem:addContact", Integer.valueOf(5));
        this.mnT.put("menuItem:copyUrl", Integer.valueOf(6));
        this.mnT.put("menuItem:openWithSafari", Integer.valueOf(7));
        this.mnT.put("menuItem:share:email", Integer.valueOf(8));
        this.mnT.put("menuItem:delete", Integer.valueOf(9));
        this.mnT.put("menuItem:exposeArticle", Integer.valueOf(10));
        this.mnT.put("menuItem:setFont", Integer.valueOf(11));
        this.mnT.put("menuItem:editTag", Integer.valueOf(12));
        this.mnT.put("menuItem:readMode", Integer.valueOf(14));
        this.mnT.put("menuItem:originPage", Integer.valueOf(14));
        this.mnT.put("menuItem:share:qq", Integer.valueOf(20));
        this.mnT.put("menuItem:share:weiboApp", Integer.valueOf(21));
        this.mnT.put("menuItem:share:QZone", Integer.valueOf(22));
        this.mnT.put("menuItem:share:Facebook", Integer.valueOf(33));
        this.mnT.put("menuItem:share:enterprise", Integer.valueOf(24));
        this.mnT.put("menuItem:refresh", Integer.valueOf(28));
        this.mnT.put("menuItem:share:wework", Integer.valueOf(25));
        this.mnT.put("menuItem:share:weread", Integer.valueOf(26));
        this.mnT.put("menuItem:keepTop", Integer.valueOf(30));
        this.mnT.put("menuItem:cancelKeepTop", Integer.valueOf(32));
        this.mnT.put("menuItem:addShortcut", Integer.valueOf(29));
        this.mnT.put("menuItem:search", Integer.valueOf(31));
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.pluginsdk.model.w.a.dw(this);
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "initWebView, check Tbs time consumed = %d(ms)", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        boolean booleanExtra = getIntent().getBooleanExtra("usePlugin", true);
        boolean booleanExtra2 = getIntent().getBooleanExtra("zoom", true);
        boolean booleanExtra3 = getIntent().getBooleanExtra("useJs", true);
        this.oET = byd();
        if (!(this.oET == null || this.oET.wwS || com.tencent.mm.compatible.util.d.eo(19))) {
            try {
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new Object[]{new com.tencent.mm.compatible.loader.c(this.oET, "mSysWebView", null).get()});
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new Object[]{new com.tencent.mm.compatible.loader.c(r0, "mProvider", null).get()});
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new Object[]{new com.tencent.mm.compatible.loader.c(r0, "mWebViewCore", null).get()});
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new Object[]{new com.tencent.mm.compatible.loader.c(r0, "sWebCoreHandler", null).get()});
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new Object[]{new com.tencent.mm.compatible.loader.c(r0, "mLooper", null).get()});
                Object obj = new com.tencent.mm.compatible.loader.c(obj, "mThread", null).get();
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, mThread = %s", new Object[]{obj});
                if (obj instanceof Thread) {
                    Thread thread = (Thread) obj;
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", new Object[]{thread.getState()});
                    if (thread.getState() == State.WAITING) {
                        thread.interrupt();
                    }
                }
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, exception = %s", new Object[]{e});
            }
        }
        this.oET.getSettings().setJavaScriptEnabled(booleanExtra3);
        this.oET.getSettings().setPluginsEnabled(booleanExtra);
        this.oET.getSettings().setDomStorageEnabled(true);
        this.oET.getSettings().setBuiltInZoomControls(booleanExtra2);
        this.oET.getSettings().setUseWideViewPort(true);
        this.oET.getSettings().setLoadWithOverviewMode(true);
        this.oET.getSettings().setSavePassword(false);
        this.oET.getSettings().setSaveFormData(false);
        this.oET.getSettings().setGeolocationEnabled(true);
        this.oET.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.oET.getSettings().setMixedContentMode(0);
        this.oET.getSettings().setAppCacheMaxSize(10485760);
        this.oET.getSettings().setAppCachePath(getDir("webviewcache", 0).getAbsolutePath());
        this.oET.getSettings().setAppCacheEnabled(true);
        this.oET.getSettings().setDatabaseEnabled(true);
        this.oET.getSettings().setDatabasePath(com.tencent.mm.compatible.util.e.hgp + "databases/");
        CookieManager.getInstance().setAcceptCookie(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(this.oET, true);
        WindowManager windowManager = (WindowManager) getApplicationContext().getSystemService("window");
        try {
            Field declaredField = WebView.class.getDeclaredField("mWebViewCore").getType().getDeclaredField("mBrowserFrame").getType().getDeclaredField("sConfigCallback");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(null);
            if (obj2 != null) {
                declaredField = declaredField.getType().getDeclaredField("mWindowManager");
                declaredField.setAccessible(true);
                declaredField.set(obj2, windowManager);
            }
        } catch (Exception e2) {
        }
        bxW();
        this.iYG = new e(this, this.oET);
        KC();
        xD("onCreate");
        this.sdc = this.oET.getSettings().getUserAgentString();
        this.fromScene = getIntent().getIntExtra("from_scence", 0);
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", " onCreate fromScene %d", new Object[]{Integer.valueOf(this.fromScene)});
        this.fFF = com.tencent.mm.u.q.fQ(bg.mz(hashCode()));
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", " onCreate sessionId %s", new Object[]{this.fFF});
        if (com.tencent.mm.sdk.platformtools.am.isConnected(this)) {
            if (com.tencent.mm.sdk.platformtools.am.isWifi(this)) {
                this.networkType = 1;
            } else if (com.tencent.mm.sdk.platformtools.am.is4G(this)) {
                this.networkType = 4;
            } else if (com.tencent.mm.sdk.platformtools.am.is3G(this)) {
                this.networkType = 3;
            } else if (com.tencent.mm.sdk.platformtools.am.is2G(this)) {
                this.networkType = 2;
            }
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "get networkType %d", new Object[]{Integer.valueOf(this.networkType)});
        }
        this.width = getResources().getDisplayMetrics().widthPixels;
        this.height = getResources().getDisplayMetrics().heightPixels;
        com.tencent.mm.plugin.webview.model.ai.e bwB = this.rWq.bwB();
        i = this.gaA;
        str = this.fUX;
        bwB.gaA = i;
        bwB.rXD = str;
        bwB.url = this.fWY;
        com.tencent.mm.plugin.webview.model.ai.b bwH = this.rWq.bwH();
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebviewReporter.DomainReporter", "setRawUrl, value = %s", new Object[]{this.fWY});
        try {
            Uri parse = Uri.parse(this.fWY);
            if (parse.getScheme() == null || parse.getScheme().toLowerCase().startsWith("http")) {
                str = parse.getHost();
                if (str == null || str.toLowerCase().endsWith(".qq.com")) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebviewReporter.DomainReporter", "rawUrl, host is .qq.com, skip, host = %s", new Object[]{str});
                    try {
                        this.set = this.uSU.ipu;
                        if (this.set != null) {
                            bxZ();
                            ((ViewGroup) ((ViewGroup) getWindow().getDecorView()).getChildAt(0)).addOnLayoutChangeListener(new OnLayoutChangeListener(this) {
                                final /* synthetic */ WebViewUI seQ;

                                {
                                    this.seQ = r1;
                                }

                                public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                                    this.seQ.bxZ();
                                }
                            });
                        }
                    } catch (Exception e3) {
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "fixContentMargin error : %s", new Object[]{e3.getMessage()});
                    }
                    try {
                        if (com.tencent.mm.compatible.util.d.eo(21) || !bxX()) {
                            ((ViewGroup) getWindow().getDecorView()).setFitsSystemWindows(true);
                            this.scW = new com.tencent.mm.plugin.webview.d.e(this, this.sex);
                            this.sen.vL().D(new Runnable(this) {
                                final /* synthetic */ WebViewUI seQ;

                                {
                                    this.seQ = r1;
                                }

                                public final void run() {
                                    com.tencent.mm.bi.f.bKE();
                                    com.tencent.mm.bi.b.bKy();
                                }
                            });
                        }
                        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) getWindow().getDecorView()).getChildAt(0);
                        viewGroup.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener(this) {
                            final /* synthetic */ WebViewUI seQ;

                            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                                WebViewUI.a(this.seQ, viewGroup, windowInsets);
                                return windowInsets.consumeSystemWindowInsets();
                            }
                        });
                        this.scW = new com.tencent.mm.plugin.webview.d.e(this, this.sex);
                        this.sen.vL().D(/* anonymous class already generated */);
                    } catch (Exception e32) {
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "tryToExpandToStatusBar error : %s", new Object[]{e32.getMessage()});
                    }
                } else {
                    bwH.rXx = true;
                    this.set = this.uSU.ipu;
                    if (this.set != null) {
                        bxZ();
                        ((ViewGroup) ((ViewGroup) getWindow().getDecorView()).getChildAt(0)).addOnLayoutChangeListener(/* anonymous class already generated */);
                    }
                    if (com.tencent.mm.compatible.util.d.eo(21)) {
                    }
                    ((ViewGroup) getWindow().getDecorView()).setFitsSystemWindows(true);
                    this.scW = new com.tencent.mm.plugin.webview.d.e(this, this.sex);
                    this.sen.vL().D(/* anonymous class already generated */);
                }
            }
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebviewReporter.DomainReporter", "rawUrl scheme is not http/https, skip, scheme = %s", new Object[]{parse.getScheme()});
            this.set = this.uSU.ipu;
            if (this.set != null) {
                bxZ();
                ((ViewGroup) ((ViewGroup) getWindow().getDecorView()).getChildAt(0)).addOnLayoutChangeListener(/* anonymous class already generated */);
            }
            if (com.tencent.mm.compatible.util.d.eo(21)) {
            }
            ((ViewGroup) getWindow().getDecorView()).setFitsSystemWindows(true);
            this.scW = new com.tencent.mm.plugin.webview.d.e(this, this.sex);
            this.sen.vL().D(/* anonymous class already generated */);
        } catch (Exception e4) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebviewReporter.DomainReporter", "parse rawUrl fail, rawUrl = %s", new Object[]{r1});
        }
    }

    public boolean bxX() {
        return true;
    }

    public final int bxY() {
        if (getResources().getDimensionPixelSize(R.f.bbw) > com.tencent.mm.bg.a.fromDPToPix(this, 48)) {
            return getResources().getDimensionPixelSize(R.f.bbw);
        }
        if (com.tencent.mm.compatible.util.j.aF(this)) {
            return getResources().getDimensionPixelSize(R.f.aWS);
        }
        return getResources().getDimensionPixelSize(R.f.aWR);
    }

    protected final void bxZ() {
        if (!this.sev && this.set != null) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.set.getLayoutParams();
            int bya = bya();
            if (bya != marginLayoutParams.topMargin) {
                marginLayoutParams.topMargin = bya;
                this.set.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public int bya() {
        return this.jkQ + bxY();
    }

    public boolean byb() {
        return true;
    }

    public int WR() {
        return getResources().getColor(R.e.aVV);
    }

    @TargetApi(21)
    public final void setStatusBarColor(int i) {
        if (bxX()) {
            if (this.jkQ > 0 && !com.tencent.mm.compatible.util.d.ep(21)) {
                getWindow().setStatusBarColor(0);
                if (this.seu == null) {
                    this.seu = new View(this);
                    ((ViewGroup) findViewById(16908290)).addView(this.seu, new LayoutParams(-1, this.jkQ));
                } else {
                    LayoutParams layoutParams = this.seu.getLayoutParams();
                    if (layoutParams.height != this.jkQ) {
                        layoutParams.height = this.jkQ;
                        this.seu.setLayoutParams(layoutParams);
                    }
                }
                this.seu.setBackgroundColor(i);
            }
        } else if (com.tencent.mm.compatible.util.d.eo(21)) {
            getWindow().setStatusBarColor(i);
        }
    }

    public void byc() {
        this.sev = true;
        cO().cP().setBackgroundDrawable(new ColorDrawable(0));
        if (cO().cP().getCustomView() != null) {
            cO().cP().getCustomView().setBackgroundColor(0);
            cO().cP().getCustomView().invalidate();
        }
        setStatusBarColor(0);
        if (this.set != null) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.set.getLayoutParams();
            marginLayoutParams.topMargin = 0;
            this.set.setLayoutParams(marginLayoutParams);
        }
    }

    public final String azN() {
        if (this.handler == null) {
            return this.seG;
        }
        if (Thread.currentThread().getId() == this.handler.getLooper().getThread().getId()) {
            return this.oET == null ? "" : this.oET.getUrl();
        } else {
            if (bg.mA(this.seG)) {
                return (String) new bb<String>(this, "") {
                    final /* synthetic */ WebViewUI seQ;

                    protected final /* synthetic */ Object run() {
                        return this.seQ.oET == null ? "" : this.seQ.oET.getUrl();
                    }
                }.b(this.handler);
            }
            return this.seG;
        }
    }

    public MMWebView byd() {
        return com.tencent.mm.ui.widget.MMWebView.a.fi(this);
    }

    public void azv() {
        if (VERSION.SDK_INT <= 10) {
            super.azv();
        } else if (this.screenOrientation == -1) {
            this.uST = getSharedPreferences(com.tencent.mm.sdk.platformtools.ab.bIX(), 4).getBoolean("settings_landscape_mode", false);
            if (this.uST) {
                setRequestedOrientation(-1);
            } else {
                setRequestedOrientation(1);
            }
        } else {
            setRequestedOrientation(this.screenOrientation);
        }
    }

    public final int Ol() {
        return this.screenOrientation;
    }

    private View bye() {
        int identifier;
        View view = null;
        if (com.tencent.mm.compatible.util.d.eo(11)) {
            try {
                identifier = Resources.getSystem().getIdentifier("action_bar_container", SlookAirButtonFrequentContactAdapter.ID, "android");
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "get resId action_bar_container, exp = %s", new Object[]{e});
            }
            if (identifier > 0) {
                view = findViewById(identifier);
            }
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "getActionBarContainer, viewResId = %d, get view = %s", new Object[]{Integer.valueOf(identifier), view});
            return view;
        }
        identifier = -1;
        if (identifier > 0) {
            view = findViewById(identifier);
        }
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "getActionBarContainer, viewResId = %d, get view = %s", new Object[]{Integer.valueOf(identifier), view});
        return view;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.sew != configuration.orientation) {
            View bye = bye();
            bye = bye == null ? null : (View) bye.getParent();
            if (bye != null) {
                bye.dispatchConfigurationChanged(configuration);
                bye.requestLayout();
                this.sew = configuration.orientation;
            }
        }
    }

    public void onStart() {
        super.onStart();
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "edw onStart");
    }

    protected void onStop() {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "edw onStop");
        A(true, true);
        super.onStop();
    }

    private void wo(int i) {
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("scene_end_type", i);
            bundle.putInt("scene_end_listener_hash_code", hashCode());
            this.iYF.a(5, bundle, hashCode());
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "addSceneEnd, ex = " + e.getMessage());
        }
    }

    private void wp(int i) {
        try {
            if (this.iYF != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("scene_end_type", i);
                bundle.putInt("scene_end_listener_hash_code", hashCode());
                this.iYF.a(6, bundle, hashCode());
            }
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "removeSceneEnd, ex = " + e.getMessage());
        }
    }

    @TargetApi(11)
    public void onDestroy() {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "onDestroy " + hashCode());
        super.onDestroy();
        if (this.scW != null) {
            this.scW.disable();
        }
        this.sel = true;
        sek--;
        int hashCode = hashCode();
        for (int size = sds.size() - 1; size >= 0; size--) {
            if (((ab) sds.get(size)).id == hashCode) {
                sds.remove(size);
                break;
            }
        }
        if (bg.bV(sds)) {
            com.tencent.mm.pluginsdk.n.bCu();
        } else {
            com.tencent.mm.pluginsdk.n.unlock();
        }
        e("", bg.Ny(), 0);
        com.tencent.mm.plugin.webview.modelcache.o oVar = a.rYq;
        oVar.rYp.put(hashCode(), Boolean.valueOf(false));
        com.tencent.mm.plugin.webview.model.ai.f bwD = this.rWq.bwD();
        bwD.rXz = new Object[]{this.fWY, Integer.valueOf(2)};
        bwD.b(this.iYF);
        this.rWq.b(this.iYF);
        ai aiVar = this.rWq;
        aiVar.rXl = null;
        aiVar.rXj = null;
        aiVar.rXk = null;
        aiVar.rXi = null;
        aiVar.rXm = null;
        aiVar.rXn = null;
        aiVar.rXo = null;
        aiVar.rXp = null;
        xD("onDestroy");
        this.sdM.clear();
        for (SparseBooleanArray sparseBooleanArray : this.seE.values()) {
            if (sparseBooleanArray != null) {
                sparseBooleanArray.clear();
            }
        }
        this.seE.clear();
        com.tencent.mm.plugin.webview.model.a aVar = this.sen;
        if (!(aVar.rWp == null || aVar.rWp.nJF.getLooper() == null)) {
            aVar.rWp.nJF.getLooper().quit();
        }
        aVar.rWp = null;
        com.tencent.mm.plugin.webview.model.af afVar = this.seq;
        afVar.rXd.clear();
        afVar.rXe.clear();
        afVar.rXf.clear();
        afVar.rXb.clear();
        afVar.rXc.clear();
        if (this.seN != null) {
            this.seN.dismiss();
            this.seN = null;
        }
        if (this.seK != null) {
            this.seK.dismiss();
            this.seK = null;
        }
        wp(233);
        this.sdN.clear();
        this.sdQ.clear();
        CookieSyncManager createInstance = CookieSyncManager.createInstance(com.tencent.mm.sdk.platformtools.ab.getContext());
        if (createInstance != null) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "now force sync the cookie between ram and db");
            createInstance.sync();
        }
        if (byo()) {
            try {
                if (this.iYF != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("srcUsername", getIntent().getStringExtra("srcUsername"));
                    this.iYF.a(30, bundle, hashCode());
                }
            } catch (Exception e) {
            }
        }
        try {
            if (this.iYF != null) {
                bundle = this.iYF.d(19, null);
                if (bundle != null) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "onDestroy, has init = %b, webviewHoldingCounter = %d", new Object[]{Boolean.valueOf(bundle.getBoolean("webview_video_proxy_init")), Integer.valueOf(sek)});
                    if (bundle.getBoolean("webview_video_proxy_init") && sek <= 0) {
                        FactoryProxyManager.getPlayManager().deinit();
                        this.iYF.d(75, null);
                    }
                }
            }
        } catch (Exception e2) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "deinit video player failed : %s", new Object[]{e2.getMessage()});
        }
        if (this.mgm != null) {
            try {
                unbindService(this.mgm);
            } catch (Throwable e3) {
                com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.WebViewUI", e3, "unbindService", new Object[0]);
            }
        }
        if (this.rVm != null) {
            this.rVm.detach();
        }
        this.mot.clear();
        if (this.sdG != null) {
            b bVar = this.sdG;
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebView.MMSslErrorHandler", "detach");
            bVar.context = null;
            bVar.saV = null;
            bVar.saW.clear();
            bVar.saX.clear();
        }
        if (this.sdI != null) {
            this.sdI.detach();
        }
        if (VERSION.SDK_INT >= 11) {
            this.oET.removeJavascriptInterface("MicroMsg");
            this.oET.removeJavascriptInterface("JsApi");
        }
        try {
            this.oET.setWebChromeClient(null);
            this.oET.setWebViewClient(null);
            this.oET.setOnTouchListener(null);
            this.oET.setOnLongClickListener(null);
            this.oET.setVisibility(8);
            this.oET.removeAllViews();
            this.oET.clearView();
        } catch (Exception e22) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "onDestroy, set web infos to null,  ex = %s", new Object[]{e22.getMessage()});
        }
        this.seo.bxf();
        if (this.iYG != null) {
            this.iYG.detach();
            this.iYG = null;
        }
        try {
            this.sez.release();
        } catch (Exception e222) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "onDestroy, remove view,  ex = " + e222.getMessage());
        }
        try {
            this.oET.destroy();
        } catch (Exception e2222) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "onDestroy, viewWV destroy, ex = %s", new Object[]{e2222.getMessage()});
        }
        this.oET = null;
        System.gc();
    }

    private void azI() {
        try {
            this.sez.release();
            this.oET.stopLoading();
            this.oET.removeAllViews();
            this.oET.clearView();
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "forceQuit, ex = " + e.getMessage());
        }
        if (this.rVm != null) {
            this.rVm.detach();
        }
        try {
            this.oET.destroy();
        } catch (Exception e2) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "forceQuit, viewWV destroy, ex = %s", new Object[]{e2.getMessage()});
        }
        this.oET = null;
        finish();
        com.tencent.mm.sdk.platformtools.w.bIP();
        Process.killProcess(Process.myPid());
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 82 || this.sey) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.sdv == null || this.sdu == null || this.sdw == null) {
            if (i == 4) {
                boolean z;
                if (this.scX == null || !this.scX.isShown()) {
                    z = false;
                } else {
                    this.scX.hide();
                    byp();
                    z = true;
                }
                if (z) {
                    return true;
                }
            }
            if (i == 4) {
                if (this.oET.canGoBack() && this.mna) {
                    byf();
                    com.tencent.mm.plugin.webview.model.ai.f bwD = this.rWq.bwD();
                    bwD.rXz = new Object[]{this.fWY, Integer.valueOf(1)};
                    bwD.b(this.iYF);
                    return true;
                }
                g.scG.close();
                byw();
            }
            if (i == 4 && azQ()) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        }
        try {
            this.sdw.onHideCustomView();
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.WebViewUI", e, "onkeydown", new Object[0]);
        }
        bwD = this.rWq.bwD();
        bwD.rXz = new Object[]{this.fWY, Integer.valueOf(1)};
        bwD.b(this.iYF);
        return true;
    }

    public void byf() {
        this.oET.goBack();
        this.sdo = null;
        if (this.sdK) {
            this.sdK = false;
        }
        g gVar = g.scG;
        if (!bg.mA(gVar.qdW)) {
            gVar.mN(5);
        }
    }

    public void ce(String str, int i) {
        if (this.scX != null) {
            this.scX.show();
            if (!bg.mA(str)) {
                this.scX.setText(str);
            }
            if (i >= 0) {
                this.scX.wJ(i);
            }
        }
    }

    public int byg() {
        if (this.scX == null) {
            return 0;
        }
        return this.scX.bAb();
    }

    protected void bxP() {
        int intExtra = getIntent().getIntExtra("webview_bg_color_rsID", -1);
        if (intExtra == -1 || this.uSU.ipu == null) {
            this.oET.setBackgroundDrawable(com.tencent.mm.bg.a.a(this, R.e.aVj));
            return;
        }
        zf(intExtra);
        this.uSU.ipu.setBackgroundResource(intExtra);
        this.oET.setBackgroundResource(17170445);
        findViewById(R.h.cSv).setBackgroundResource(17170445);
    }

    public void byh() {
        if (this.scT == null) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "fullScreenMenu is null");
        } else if (this.scU) {
            if (cO().cP() != null) {
                cO().cP().hide();
            }
            this.scV = true;
            this.sev = true;
            if (this.set != null) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.set.getLayoutParams();
                marginLayoutParams.topMargin = 0;
                this.set.setLayoutParams(marginLayoutParams);
            }
            if (this.seu != null) {
                this.seu.setVisibility(8);
            }
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            final View decorView = getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new OnSystemUiVisibilityChangeListener(this) {
                final /* synthetic */ WebViewUI seQ;

                public final void onSystemUiVisibilityChange(int i) {
                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "visibility = " + i);
                    if ((i & 4) == 0 && this.seQ.scV) {
                        decorView.setSystemUiVisibility(5894);
                    }
                }
            });
            decorView.setSystemUiVisibility(5894);
            this.scT.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WebViewUI seQ;

                {
                    this.seQ = r1;
                }

                public final void onClick(View view) {
                    this.seQ.aAb();
                }
            });
            this.scT.setVisibility(0);
        } else {
            this.scT.setVisibility(8);
            if (this.scV) {
                getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                getWindow().getDecorView().setSystemUiVisibility(0);
                if (cO().cP() != null) {
                    cO().cP().show();
                }
                this.sev = false;
                this.scV = false;
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && this.scU) {
            getWindow().getDecorView().setSystemUiVisibility(5894);
        }
    }

    public void KC() {
        boolean booleanExtra = getIntent().getBooleanExtra("vertical_scroll", true);
        this.sdk = getIntent().getBooleanExtra("finishviewifloadfailed", false);
        this.sdh = getIntent().getBooleanExtra("is_favorite_item", false);
        this.qyZ = getIntent().getBooleanExtra("isWebwx", true);
        this.sdf = getIntent().getBooleanExtra("neverGetA8Key", false);
        this.sdX = getIntent().getBooleanExtra("neverBlockLocalRequest", false);
        this.sdj = getIntent().getBooleanExtra("KFromLoginHistory", false);
        this.sdT = LayoutInflater.from(this.uSU.uTo).inflate(R.i.doV, null);
        boolean booleanExtra2 = getIntent().getBooleanExtra("show_feedback", false);
        this.sdV = bg.mz(getIntent().getStringExtra("sentUsername"));
        if (booleanExtra2) {
            a(1, getString(R.l.eSB), new OnMenuItemClickListener(this) {
                final /* synthetic */ WebViewUI seQ;

                {
                    this.seQ = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    try {
                        this.seQ.oET.loadUrl(this.seQ.iYF.JA(null));
                    } catch (Throwable e) {
                        com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.WebViewUI", e, "[oneliang]feedback exception:%s", new Object[]{e.getMessage()});
                    }
                    return false;
                }
            });
        }
        this.scN = (ProgressBar) findViewById(R.h.bHg);
        this.sdU = findViewById(R.h.cxo);
        this.sdU.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WebViewUI seQ;

            {
                this.seQ = r1;
            }

            public final void onClick(View view) {
                this.seQ.j(this.seQ.sdo, true, -1);
                com.tencent.mm.plugin.webview.model.ai.f bwD = this.seQ.rWq.bwD();
                bwD.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(4)};
                bwD.b(this.seQ.iYF);
            }
        });
        if (this.qyZ) {
            CharSequence mz = bg.mz(getIntent().getStringExtra("title"));
            if (mz.length() > 0) {
                this.scL = true;
            }
            super.L(mz);
            zh(getResources().getColor(R.e.aSC));
        } else {
            qP("");
        }
        iT(false);
        iU(false);
        if (sdy == RenderPriority.NORMAL) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "initView, set render priority to HIGH");
            this.oET.getSettings().setRenderPriority(RenderPriority.HIGH);
            sdy = RenderPriority.HIGH;
        }
        this.sez.cM(this.uSU.ipu);
        this.sez.a(this.oET);
        bxP();
        this.scR = (FrameLayout) findViewById(R.h.czp);
        this.scS = (FrameLayout) findViewById(R.h.bGr);
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "Is the current broswer kernel X5, " + this.oET.wwS);
        if (this.oET.wwS) {
            this.oET.setWebViewCallbackClient(this.ser);
            this.oET.getX5WebViewExtension().setWebViewClientExtension(new h(this));
            f fVar = this.sez;
            com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper.a anonymousClass8 = new com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper.a(this) {
                final /* synthetic */ WebViewUI seQ;

                {
                    this.seQ = r1;
                }

                public final void bxF() {
                    if (this.seQ.oET.wwS) {
                        com.tencent.mm.plugin.webview.model.ai.f bwD = this.seQ.rWq.bwD();
                        bwD.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(10)};
                        bwD.b(this.seQ.iYF);
                    }
                }
            };
            if (fVar.scq != null) {
                fVar.scq.saL = anonymousClass8;
            }
        }
        this.scX = (WebViewInputFooter) findViewById(R.h.cSq);
        if (this.scX != null) {
            this.scX.hide();
            this.scX.snS = new com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.c(this) {
                final /* synthetic */ WebViewUI seQ;

                {
                    this.seQ = r1;
                }

                public final void xK(String str) {
                    WebViewUI.b(this.seQ, str);
                }
            };
            this.scX.snT = new com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.a(this) {
                final /* synthetic */ WebViewUI seQ;

                {
                    this.seQ = r1;
                }

                public final boolean rl(String str) {
                    if (this.seQ.rVm != null) {
                        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.seQ.rVm;
                        Map hashMap = new HashMap();
                        hashMap.put("smiley", str);
                        af.v(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass15(dVar, com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onGetSmiley", hashMap, dVar.sjU, dVar.sjV)));
                    }
                    return true;
                }
            };
            this.scX.snU = new com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.b(this) {
                final /* synthetic */ WebViewUI seQ;

                {
                    this.seQ = r1;
                }

                public final void azV() {
                    WebViewUI.b(this.seQ, 0);
                }

                public final void azW() {
                    WebViewKeyboardLinearLayout webViewKeyboardLinearLayout = (WebViewKeyboardLinearLayout) this.seQ.findViewById(R.h.cSv);
                    if (webViewKeyboardLinearLayout != null && webViewKeyboardLinearLayout.scd > 0) {
                        WebViewUI.b(this.seQ, webViewKeyboardLinearLayout.scd);
                    }
                }
            };
        }
        this.scY = (WebViewSearchContentInputFooter) findViewById(R.h.cAB);
        if (this.scY != null) {
            this.scY.snQ = new com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter.a(this) {
                final /* synthetic */ WebViewUI seQ;

                {
                    this.seQ = r1;
                }

                public final void azX() {
                    WebViewUI.c(this.seQ, 0);
                    this.seQ.oET.clearMatches();
                    this.seQ.scY.bzY();
                }

                public final void a(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
                    if (webViewSearchContentInputFooter.getVisibility() == 0) {
                        b(webViewSearchContentInputFooter);
                    }
                }

                public final void azY() {
                    com.tencent.mm.plugin.report.service.g.oUh.a(480, 5, 1, false);
                    this.seQ.oET.findNext(false);
                }

                public final void azZ() {
                    com.tencent.mm.plugin.report.service.g.oUh.a(480, 4, 1, false);
                    this.seQ.oET.findNext(true);
                }

                public final void b(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
                    this.seQ.oET.clearMatches();
                    webViewSearchContentInputFooter.reset();
                    this.seQ.scY.q(0, 0, true);
                    this.seQ.scZ = false;
                    this.seQ.oET.findAllAsync(webViewSearchContentInputFooter.bzZ());
                }

                public final boolean c(int i, KeyEvent keyEvent) {
                    if (i == 67 && keyEvent.getAction() == 0) {
                        com.tencent.mm.plugin.report.service.g.oUh.a(480, 6, 1, false);
                    }
                    return false;
                }

                public final void azn() {
                }
            };
            this.oET.setFindListener(new FindListener(this) {
                final /* synthetic */ WebViewUI seQ;

                {
                    this.seQ = r1;
                }

                public final void onFindResultReceived(int i, int i2, boolean z) {
                    if (!(!z || this.seQ.scZ || bg.mA(this.seQ.scY.bzZ()))) {
                        if (i2 == 0) {
                            com.tencent.mm.plugin.report.service.g.oUh.a(480, 3, 1, false);
                        } else {
                            com.tencent.mm.plugin.report.service.g.oUh.a(480, 2, 1, false);
                        }
                        this.seQ.scZ = true;
                    }
                    this.seQ.scY.q(i, i2, z);
                }
            });
        }
        this.scT = (MovingImageButton) findViewById(R.h.bSm);
        this.sdq = findViewById(R.h.cSn);
        if (this.sdq != null) {
            this.sdq.setVisibility(8);
        }
        if (!booleanExtra) {
            this.oET.setVerticalScrollBarEnabled(false);
        }
        this.sdw = new WebChromeClient(this) {
            public volatile boolean lre = false;
            private Dialog mnu = null;
            final /* synthetic */ WebViewUI seQ;
            public final List<String> sfA = new LinkedList();

            {
                this.seQ = r2;
            }

            public final void onProgressChanged(WebView webView, int i) {
                if (i < 100) {
                    this.seQ.iU(false);
                } else if (i >= 100) {
                    this.seQ.iU(true);
                }
            }

            public final void onReceivedTitle(WebView webView, String str) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "onReceivedTitle, title = %s, loadurl = %s", new Object[]{str, this.seQ.seG});
                super.onReceivedTitle(webView, str);
                if (this.seQ.scL) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "fixed title, ignore received title: " + str);
                } else if (str == null) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "null title");
                } else if (this.seQ.qyZ && !bg.mz(this.seQ.seG).equals(str) && !com.tencent.mm.plugin.webview.modelcache.p.xt(str)) {
                    this.seQ.qP(str);
                }
            }

            public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "onShowCustomView, sdk int = " + VERSION.SDK_INT);
                try {
                    if (this.seQ.sdv != null) {
                        customViewCallback.onCustomViewHidden();
                        return;
                    }
                    this.seQ.zg(4);
                    this.seQ.iT(false);
                    this.seQ.sdv = view;
                    this.seQ.sdu = customViewCallback;
                    this.seQ.oET.setVisibility(8);
                    this.seQ.scS.addView(view);
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "onShowCustomView error " + e.getMessage());
                }
            }

            public final void onHideCustomView() {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "onHideCustomView, sdk int = " + VERSION.SDK_INT);
                if (this.seQ.sdv != null) {
                    try {
                        this.seQ.zg(0);
                        this.seQ.iT(false);
                        this.seQ.oET.setVisibility(0);
                        if (this.seQ.scS != null) {
                            this.seQ.scS.removeView(this.seQ.sdv);
                        }
                        this.seQ.sdv = null;
                        if (this.seQ.sdu != null) {
                            this.seQ.sdu.onCustomViewHidden();
                        }
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "onHideCustomView error " + e.getMessage());
                    }
                }
            }

            public final View getVideoLoadingProgressView() {
                if (this.seQ.sdx == null) {
                    this.seQ.sdx = new ProgressBar(this.seQ);
                    this.seQ.sdx.setIndeterminate(true);
                }
                return this.seQ.sdx;
            }

            public final void onGeolocationPermissionsShowPrompt(final String str, final GeolocationPermissionsCallback geolocationPermissionsCallback) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt, origin = %s", new Object[]{str});
                com.tencent.mm.ui.base.g.a(this.seQ, false, this.seQ.getString(R.l.fnE, new Object[]{str}), this.seQ.getString(R.l.fnF), this.seQ.getString(R.l.dHT), this.seQ.getString(R.l.dGs), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass15 sfB;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt ok, origin = %s");
                        geolocationPermissionsCallback.invoke(str, true, false);
                        d.a(this.sfB.seQ.iYF, 14340, this.sfB.seQ.fWY, this.sfB.seQ.azN(), Integer.valueOf(this.sfB.seQ.gaA), this.sfB.seQ.getIntent().getStringExtra("geta8key_username"), Integer.valueOf(ai.bwu()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass15 sfB;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "onGeolocationPermissionsShowPrompt cancel, origin = %s");
                        geolocationPermissionsCallback.invoke(str, false, false);
                        d.a(this.sfB.seQ.iYF, 14340, this.sfB.seQ.fWY, this.sfB.seQ.azN(), Integer.valueOf(this.sfB.seQ.gaA), this.sfB.seQ.getIntent().getStringExtra("geta8key_username"), Integer.valueOf(ai.bwu()), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    }
                });
            }

            public final void openFileChooser(com.tencent.smtt.sdk.y<Uri> yVar, String str, String str2) {
                this.seQ.seA.a(this.seQ, this.seQ.iYG, yVar, null, str, str2);
            }

            public final boolean onShowFileChooser(WebView webView, com.tencent.smtt.sdk.y<Uri[]> yVar, com.tencent.smtt.sdk.WebChromeClient.a aVar) {
                if (aVar.getMode() != 0) {
                    return false;
                }
                if (aVar.getAcceptTypes() == null || aVar.getAcceptTypes().length <= 0) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
                    return true;
                }
                String str = aVar.getAcceptTypes()[0];
                String str2 = "*";
                if (aVar.isCaptureEnabled()) {
                    if ("image/*".equalsIgnoreCase(str)) {
                        str2 = "camera";
                    } else if ("video/*".equalsIgnoreCase(str)) {
                        str2 = "camcorder";
                    }
                }
                this.seQ.seA.a(this.seQ, this.seQ.iYG, null, yVar, str, str2);
                return true;
            }

            public final boolean onJsConfirm(WebView webView, final String str, String str2, final JsResult jsResult) {
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "onJsConfirm");
                final PBool pBool = new PBool();
                pBool.value = false;
                if (this.seQ.isFinishing() || this.seQ.uSW) {
                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "onJsConfirm finish");
                    jsResult.cancel();
                    return true;
                }
                this.seQ.mne = this.seQ.mne + 1;
                if (this.seQ.mne > 2) {
                    this.mnu = com.tencent.mm.ui.base.g.a(this.seQ, str2, "", this.seQ.getString(R.l.fnz), this.seQ.getString(R.l.dHT), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass15 sfB;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.plugin.report.service.g.oUh.i(11683, new Object[]{str, Integer.valueOf(1), Integer.valueOf(this.sfB.seQ.mne)});
                            jsResult.cancel();
                            if (dialogInterface != null) {
                                dialogInterface.dismiss();
                            }
                            this.sfB.seQ.finish();
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass15 sfB;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            pBool.value = true;
                            jsResult.confirm();
                        }
                    }, R.e.aTa);
                } else {
                    this.mnu = com.tencent.mm.ui.base.g.a(this.seQ.uSU.uTo, false, str2, "", this.seQ.getString(R.l.dHT), this.seQ.getString(R.l.dGs), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass15 sfB;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            pBool.value = true;
                            jsResult.confirm();
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass15 sfB;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            jsResult.cancel();
                        }
                    });
                }
                if (this.mnu == null) {
                    return super.onJsConfirm(webView, str, str2, jsResult);
                }
                this.mnu.setOnDismissListener(new OnDismissListener(this) {
                    final /* synthetic */ AnonymousClass15 sfB;

                    public final void onDismiss(DialogInterface dialogInterface) {
                        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "onJsConfirm, onDismiss");
                        if (!pBool.value) {
                            jsResult.cancel();
                        }
                    }
                });
                this.mnu.setCancelable(false);
                this.mnu.setCanceledOnTouchOutside(false);
                return true;
            }

            public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }

            public final boolean onJsAlert(WebView webView, final String str, String str2, final JsResult jsResult) {
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "onJsAlert");
                final PBool pBool = new PBool();
                pBool.value = false;
                if (this.seQ.isFinishing() || this.seQ.uSW) {
                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "onJsAlert finish");
                    jsResult.cancel();
                    return true;
                }
                com.tencent.mm.ui.base.h a;
                this.seQ.mne = this.seQ.mne + 1;
                if (this.seQ.mne > 2) {
                    a = com.tencent.mm.ui.base.g.a(this.seQ, str2, "", this.seQ.getString(R.l.fnz), this.seQ.getString(R.l.dHT), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass15 sfB;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.plugin.report.service.g.oUh.i(11683, new Object[]{str, Integer.valueOf(1), Integer.valueOf(this.sfB.seQ.mne)});
                            jsResult.cancel();
                            if (dialogInterface != null) {
                                dialogInterface.dismiss();
                            }
                            this.sfB.seQ.finish();
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass15 sfB;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            pBool.value = true;
                            jsResult.confirm();
                        }
                    }, R.e.aUA);
                } else {
                    a = com.tencent.mm.ui.base.g.a(this.seQ, str2, "", this.seQ.getString(R.l.dHT), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass15 sfB;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            pBool.value = true;
                            jsResult.confirm();
                        }
                    });
                }
                if (a == null) {
                    return super.onJsAlert(webView, str, str2, jsResult);
                }
                a.setOnDismissListener(new OnDismissListener(this) {
                    final /* synthetic */ AnonymousClass15 sfB;

                    public final void onDismiss(DialogInterface dialogInterface) {
                        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "onJsAlert, onDismiss");
                        if (!pBool.value) {
                            jsResult.cancel();
                        }
                    }
                });
                a.setCanceledOnTouchOutside(false);
                a.kI(false);
                return true;
            }

            public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                String message = consoleMessage != null ? consoleMessage.message() : null;
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "onConsoleMessage : %s", new Object[]{message});
                if (bg.mA(message) || this.seQ.sdI == null) {
                    return false;
                }
                if (message.equalsIgnoreCase("weixin://preInjectJSBridge/start")) {
                    this.seQ.sef = true;
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "now inject js library");
                    return true;
                } else if (message.equalsIgnoreCase("weixin://preInjectJSBridge/fail")) {
                    if (this.seQ.sef) {
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "preInjectJSBridge fail");
                        com.tencent.mm.plugin.report.service.g.oUh.a(156, 3, 1, false);
                    }
                    this.seQ.sef = false;
                    return true;
                } else if (message.equalsIgnoreCase("weixin://preInjectJSBridge/ok")) {
                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "preInjectJSBridge ok");
                    return true;
                } else if (message.equalsIgnoreCase("weixin://whiteScreenEnd")) {
                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "whiteScreenEnd");
                    this.seQ.sde = true;
                    return true;
                } else if (this.seQ.sdI.sko) {
                    if (com.tencent.mm.pluginsdk.ui.tools.s.Nu(message).booleanValue()) {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "onConsoleMessage,set by console handle");
                        this.seQ.sdI.sko = false;
                        this.seQ.sdm = false;
                        return true;
                    } else if (!com.tencent.mm.pluginsdk.ui.tools.s.Nt(message).booleanValue()) {
                        return false;
                    } else {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "onConsoleMessage preinject ,set by console handle");
                        this.seQ.sdI.sko = false;
                        this.seQ.sdm = false;
                        this.seQ.sdI.skp = true;
                        return true;
                    }
                } else if (!com.tencent.mm.pluginsdk.ui.tools.s.eq(message, "weixin://private/setresult/") && !com.tencent.mm.pluginsdk.ui.tools.s.eq(message, "weixin://dispatch_message/") && !com.tencent.mm.pluginsdk.ui.tools.s.eq(message, "weixin://gethtml/")) {
                    return false;
                } else {
                    if (message.equals(this.seQ.seF)) {
                        this.seQ.seF = "";
                        return true;
                    } else if (this.sfA.size() > com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX) {
                        return true;
                    } else {
                        this.sfA.add(message);
                        if (!(this.seQ.handler == null || this.lre)) {
                            this.seQ.handler.post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass15 sfB;

                                {
                                    this.sfB = r1;
                                }

                                public final void run() {
                                    if (this.sfB.sfA.size() > 0) {
                                        this.sfB.lre = true;
                                        String str = (String) this.sfB.sfA.remove(0);
                                        this.sfB.seQ.xM(str);
                                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "onConsoleMessage, handleUrl = " + str);
                                        this.sfB.seQ.handler.postDelayed(this, 20);
                                        return;
                                    }
                                    this.sfB.lre = false;
                                }
                            });
                        }
                        return true;
                    }
                }
            }
        };
        this.oET.setWebChromeClient(this.sdw);
        this.oET.setWebViewClient(new i(this));
        this.oET.setDownloadListener(new DownloadListener(this) {
            final /* synthetic */ WebViewUI seQ;

            {
                this.seQ = r1;
            }

            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                int i;
                int i2 = 1;
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "edw onDownloadStart, url = " + str + ", mimetype = " + str4 + ", userAgent = " + str2);
                if (str4 == null || !str4.equalsIgnoreCase("application/vnd.android.package-archive")) {
                    i = 0;
                } else {
                    com.tencent.mm.sdk.platformtools.w.v("MicroMsg.WebViewUI", "edw onDownloadStart, report download url: %s", new Object[]{str});
                    d.a(this.seQ.iYF, 11154, str);
                    i = 1;
                }
                if (this.seQ.iYG == null || this.seQ.iYG.bxQ() == null) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "onDownloadStart fail, wvPerm is null");
                    return;
                }
                if (str4 != null) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "onDownloadStart configOpen:%s", new Object[]{Boolean.valueOf(this.seQ.bxB())});
                    CharSequence JV = WebViewUI.xv(str3);
                    int i3 = (JV == null || !Pattern.matches("(?i).*\\.(doc|ppt|xls|docx|pptx|xlsx|wps|dps|et|txt|pdf)$", JV)) ? 0 : 1;
                    boolean contains = com.tencent.mm.plugin.webview.ui.tools.jsapi.a.sjy.contains(str4.toLowerCase());
                    if (!r4 || (i3 == 0 && !contains)) {
                        i2 = 0;
                    }
                } else {
                    i2 = 0;
                }
                if (i2 == 0 && !this.seQ.iYG.bxQ().nw(24) && !this.seQ.sdD) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "onDownloadStart permission fail");
                } else if (i != 0) {
                    WebViewUI.a(this.seQ, str, j);
                } else {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    try {
                        this.seQ.startActivity(intent);
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "startActivity fail, e = " + e.getMessage());
                    }
                }
            }
        });
        this.oET.requestFocus(130);
        this.oET.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ WebViewUI seQ;

            {
                this.seQ = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.seQ.scQ != null && this.seQ.scQ.getVisibility() == 0) {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.seQ, R.a.aRd);
                    loadAnimation.setAnimationListener(new AnimationListener(this) {
                        final /* synthetic */ AnonymousClass17 sfD;

                        {
                            this.sfD = r1;
                        }

                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            this.sfD.seQ.scQ.setVisibility(8);
                        }
                    });
                    this.seQ.scQ.startAnimation(loadAnimation);
                    this.seQ.scQ.setVisibility(8);
                }
                switch (motionEvent.getAction()) {
                    case 0:
                    case 1:
                        if (!view.hasFocus()) {
                            view.requestFocus();
                            break;
                        }
                        break;
                }
                if (this.seQ.oET != null && (motionEvent.getAction() == 0 || motionEvent.getAction() == 5 || motionEvent.getAction() == 5 || motionEvent.getAction() == 261 || motionEvent.getAction() == 517)) {
                    if (motionEvent.getPointerCount() > 1) {
                        this.seQ.oET.getSettings().setBuiltInZoomControls(true);
                        this.seQ.oET.getSettings().setSupportZoom(true);
                    } else {
                        this.seQ.oET.getSettings().setBuiltInZoomControls(false);
                        this.seQ.oET.getSettings().setSupportZoom(false);
                    }
                }
                return false;
            }
        });
        this.oET.getSettings().setUserAgentString(com.tencent.mm.pluginsdk.ui.tools.s.aZ(this, this.oET.getSettings().getUserAgentString()));
        this.oET.caH();
        this.iYI = new com.tencent.mm.ui.tools.l(this.uSU.uTo);
        this.iYI.a(this.oET, this, null);
        this.iYI.e(new OnCancelListener(this) {
            final /* synthetic */ WebViewUI seQ;

            {
                this.seQ = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.seQ.iYM != null && this.seQ.iYF != null) {
                    try {
                        this.seQ.iYF.Jz(this.seQ.iYM.rZF);
                        this.seQ.iYM.bxd();
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "cancel capture failed");
                    }
                }
            }
        });
        a(new OnMenuItemClickListener(this) {
            final /* synthetic */ WebViewUI seQ;

            {
                this.seQ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.seQ.aHf();
                WebViewUI.T(this.seQ);
                return true;
            }
        }, byi());
        if (byj()) {
            final WebViewKeyboardLinearLayout webViewKeyboardLinearLayout = (WebViewKeyboardLinearLayout) findViewById(R.h.cSv);
            webViewKeyboardLinearLayout.uRI = new com.tencent.mm.ui.KeyboardLinearLayout.a(this) {
                final /* synthetic */ WebViewUI seQ;

                public final void nx(int i) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "onKeyBoardStateChange, state = " + i);
                    WebViewUI.a(this.seQ, webViewKeyboardLinearLayout, i);
                    if (i == -3) {
                        int i2 = webViewKeyboardLinearLayout.scd;
                        if (i2 > 0 && this.seQ.bxX()) {
                            WebViewUI.b(this.seQ, i2);
                        }
                        WebViewUI.c(this.seQ, i2);
                        if (this.seQ.scX != null && this.seQ.scX.getVisibility() == 0) {
                            this.seQ.scX.bAc();
                        }
                    } else {
                        WebViewUI.c(this.seQ, 0);
                        WebViewUI.b(this.seQ, 0);
                    }
                    this.seQ.a(webViewKeyboardLinearLayout, i);
                    this.seQ.seP = i;
                }
            };
        }
        this.scM = (MMFalseProgressBar) findViewById(R.h.cSh);
        super.Y(new Runnable(this) {
            final /* synthetic */ WebViewUI seQ;

            {
                this.seQ = r1;
            }

            public final void run() {
                WebViewUI.U(this.seQ);
            }
        });
    }

    public int byi() {
        return this.sea ? 0 : R.k.bbF;
    }

    public final void wq(int i) {
        Drawable mutate = getResources().getDrawable(R.g.bbF).mutate();
        mutate.setColorFilter(i, Mode.SRC_IN);
        com.tencent.mm.ui.l lVar = this.uSU;
        if (lVar.Gx != null && lVar.uTx != null && mutate != null) {
            lVar.uTx.setImageDrawable(mutate);
            mutate.invalidateSelf();
        }
    }

    public boolean byj() {
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.seA.a(this, i, i2, intent) || !com.tencent.mm.plugin.webview.d.a.a(this, i, i2, intent)) {
        }
    }

    public final void VK() {
        if (this.oET != null) {
            if (this.seB) {
                this.oET.setOnLongClickListener(this.seC);
            } else {
                this.oET.setOnLongClickListener(null);
            }
        }
        aHf();
        super.VK();
    }

    public final boolean byk() {
        byw();
        return true;
    }

    public final void onCancel() {
        if (this.oET != null) {
            if (this.seB) {
                this.oET.setOnLongClickListener(this.seC);
            } else {
                this.oET.setOnLongClickListener(null);
            }
        }
        super.onCancel();
    }

    public final void VL() {
        if (this.oET != null) {
            this.oET.setOnLongClickListener(new OnLongClickListener(this) {
                final /* synthetic */ WebViewUI seQ;

                {
                    this.seQ = r1;
                }

                public final boolean onLongClick(View view) {
                    return true;
                }
            });
        }
        super.VL();
    }

    private static boolean a(com.tencent.mm.plugin.webview.ui.tools.jsapi.b bVar, String str) {
        if (bg.mA(str) || bVar == null) {
            return false;
        }
        return bVar.xL(str);
    }

    public void axz() {
        String Ju;
        boolean z;
        int bxA;
        Map hashMap;
        Object obj;
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "edw postBinded");
        byv();
        com.tencent.mm.plugin.webview.model.a aVar = this.sen;
        com.tencent.mm.plugin.webview.stub.d dVar = this.iYF;
        try {
            Ju = dVar.Ju("DNSAdvanceOpen");
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.DNSPreGetOptimize", "switch open value : %s", new Object[]{Ju});
            if (bg.mA(Ju)) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.DNSPreGetOptimize", "get switch value is null or nil");
                z = false;
            } else {
                z = Ju.equalsIgnoreCase("1");
            }
            if (z) {
                try {
                    Ju = dVar.Ju("DNSAdvanceRelateDomain");
                    if (bg.mA(Ju)) {
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.DNSPreGetOptimize", "domain list is null, just return");
                    } else {
                        aVar.vL().D(new com.tencent.mm.plugin.webview.model.a.AnonymousClass1(aVar, Ju, dVar));
                    }
                } catch (Throwable e) {
                    com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.DNSPreGetOptimize", e, "", new Object[0]);
                }
            } else {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.DNSPreGetOptimize", "server closed the switch");
            }
        } catch (Exception e2) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.DNSPreGetOptimize", "get dns pre get switch failed");
        }
        Bundle bundle = new Bundle();
        Bundle bundleExtra = getIntent().getBundleExtra("jsapiargs");
        if (bundleExtra == null) {
            bundleExtra = new Bundle();
        }
        bundle.putBundle("jsapiargs", bundleExtra);
        bundle.putCharSequence("bizofstartfrom", getIntent().getStringExtra("bizofstartfrom"));
        bundle.putBundle("startwebviewparams", getIntent().getBundleExtra("startwebviewparams"));
        bundle.putInt("screen_orientation", this.screenOrientation);
        try {
            this.iYF.a(20, bundle, hashCode());
        } catch (RemoteException e3) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "postBinded, invoke AC_SET_INITIAL_ARGS, ex = " + e3.getMessage());
        }
        String stringExtra = getIntent().getStringExtra("geta8key_username");
        int intExtra = getIntent().getIntExtra("preChatTYPE", 0);
        String stringExtra2 = getIntent().getStringExtra("srcUsername");
        long longExtra = getIntent().getLongExtra("message_id", 0);
        int intExtra2 = getIntent().getIntExtra("message_index", 0);
        String stringExtra3 = getIntent().getStringExtra("KsnsViewId");
        String stringExtra4 = getIntent().getStringExtra("KPublisherId");
        String stringExtra5 = getIntent().getStringExtra("KAppId");
        String stringExtra6 = getIntent().getStringExtra("pre_username");
        String stringExtra7 = getIntent().getStringExtra("expid_str");
        String string = bundleExtra.getString("key_snsad_statextstr");
        Ju = null;
        if (this.oET != null) {
            Ju = this.oET.getTitle();
        }
        if (bg.mA(Ju)) {
            Ju = getIntent().getStringExtra("title");
        }
        if (bg.mA(Ju)) {
            Ju = getIntent().getStringExtra("webpageTitle");
        }
        com.tencent.mm.plugin.webview.model.ai.i bwA = this.rWq.bwA();
        bwA.username = stringExtra;
        bwA.rXN = intExtra;
        bwA.fWY = this.fWY;
        bwA.rXJ = intExtra2;
        bwA.scene = JS(stringExtra);
        bwA.rXI = longExtra;
        bwA.rXK = new com.tencent.mm.a.o(longExtra).toString();
        bwA.rXG = stringExtra2;
        bwA.rXH = stringExtra3;
        bwA.mkU = stringExtra4;
        bwA.appId = stringExtra5;
        bwA.rXL = stringExtra6;
        bwA.rXM = this.rXM;
        bwA.qui = string;
        bwA.title = bg.ap(Ju, "");
        bwA.gxO = stringExtra7;
        this.rWq.bwC().fWY = this.fWY;
        if (byo()) {
            try {
                bundleExtra = new Bundle();
                bundleExtra.putString("srcUsername", getIntent().getStringExtra("srcUsername"));
                this.iYF.a(29, bundleExtra, hashCode());
            } catch (Exception e4) {
            }
        }
        if (!bg.mA(stringExtra2)) {
            try {
                this.iYF.Jv(stringExtra2);
            } catch (Exception e5) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "postBinded, fail triggerGetContact, ex = " + e5.getMessage());
            }
        }
        try {
            if (getIntent().getIntExtra("pay_channel", -1) != -1) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "hy: found channel in intent. pay channel: %d", new Object[]{Integer.valueOf(getIntent().getIntExtra("pay_channel", -1))});
            } else {
                bxA = this.iYF.bxA();
                if (bxA != -1) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "hy: found channel in channel helper. pay channel: %d", new Object[]{Integer.valueOf(bxA)});
                    getIntent().putExtra("pay_channel", bxA);
                }
            }
        } catch (Exception e6) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "hy: init pay channel failed");
        }
        this.mot.clear();
        MMWebView mMWebView = this.oET;
        e eVar = this.iYG;
        Map hashMap2 = new HashMap();
        hashMap2.put("webview_type", "1");
        hashMap2.put("init_url", this.fWY);
        hashMap2.put("init_font_size", "1");
        hashMap2.put("short_url", bg.mz(getIntent().getStringExtra("shortUrl")));
        this.rVm = new com.tencent.mm.plugin.webview.ui.tools.jsapi.d(mMWebView, eVar, hashMap2, this.iYF, hashCode());
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar2 = this.rVm;
        String stringExtra8 = getIntent().getStringExtra("geta8key_username");
        if (!bg.mA(getIntent().getStringExtra("srcUsername"))) {
            hashMap = new HashMap();
            hashMap.put("srcUsername", getIntent().getStringExtra("srcUsername"));
            hashMap.put("srcDisplayname", getIntent().getStringExtra("srcDisplayname"));
        } else if (bg.mA(stringExtra8)) {
            hashMap = new HashMap();
        } else {
            hashMap = new HashMap();
            hashMap.put("srcUsername", stringExtra8);
        }
        hashMap.put("message_id", Long.valueOf(getIntent().getLongExtra("message_id", 0)));
        hashMap.put("message_index", Integer.valueOf(getIntent().getIntExtra("message_index", 0)));
        hashMap.put("scene", Integer.valueOf(JS(stringExtra8)));
        hashMap.put("pay_channel", Integer.valueOf(getIntent().getIntExtra("pay_channel", 0)));
        hashMap.put("stastic_scene", Integer.valueOf(getIntent().getIntExtra("stastic_scene", 0)));
        hashMap.put("from_scence", Integer.valueOf(getIntent().getIntExtra("from_scence", 0)));
        if (!bg.mA(getIntent().getStringExtra("KTemplateId"))) {
            hashMap.put("KTemplateId", getIntent().getStringExtra("KTemplateId"));
        }
        dVar2.sjR = hashMap;
        this.mot.add(this.rVm);
        this.mot.add(new t(this));
        this.mot.add(new q(this));
        this.mot.add(new f(this));
        this.mot.add(new s(this));
        this.mot.add(new v(this));
        this.mot.add(new a(this));
        this.mot.add(new aa(this));
        this.mot.add(new u(this));
        this.mot.add(new j(this));
        this.mot.add(new b(this));
        this.mot.add(new e(this));
        this.mot.add(new c(this));
        this.mot.add(new com.tencent.mm.plugin.webview.ui.tools.jsapi.e(this.oET, this.iYF, hashCode(), this.rVm));
        this.mot.add(new z(this));
        this.mot.add(new w(this));
        this.mot.add(new o(this));
        if (getIntent().getBooleanExtra("allow_wx_schema_url", false)) {
            this.mot.add(new l(this));
        }
        this.mot.add(new g(this));
        try {
            bxA = bg.getInt(this.iYF.Ju("WebviewDisableX5Logo"), 0);
        } catch (Exception e52) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "getting flag of x5 logo state failed, ex = " + e52.getMessage());
            bxA = 0;
        }
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "getting flag of x5 logo state, disableX5Logo = %d, disableBounceScroll = %b", new Object[]{Integer.valueOf(bxA), Boolean.valueOf(getIntent().getBooleanExtra("disable_bounce_scroll", false))});
        if (bxA == 1 || r1) {
            this.sez.iQ(true);
        }
        if (getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_disable_over_scroll", false)) {
            this.sez.iQ(true);
        }
        try {
            this.sdH = bg.getInt(this.iYF.Ju("OpenJSReadySpeedy"), 0);
        } catch (Exception e522) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "postBinded, openJSReadySpeedy, ex = " + e522.getMessage());
        }
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "postBinded, openJSReadySpeedy = %d", new Object[]{Integer.valueOf(this.sdH)});
        ai.z(this.oET.getX5WebViewExtension() != null, bg.mz(this.fWY).startsWith("https://"));
        if (this.oET.getX5WebViewExtension() != null) {
            com.tencent.mm.pluginsdk.ui.tools.j.mN(7);
            com.tencent.mm.plugin.report.service.g.oUh.n(64, 64, 1, 0);
        } else {
            com.tencent.mm.plugin.report.service.g.oUh.a(64, 0, 1, false);
        }
        this.sdI = new com.tencent.mm.plugin.webview.ui.tools.jsapi.f(this.oET, this.rVm, new com.tencent.mm.plugin.webview.ui.tools.jsapi.f.a(this) {
            final /* synthetic */ WebViewUI seQ;

            {
                this.seQ = r1;
            }

            public final void byG() {
                int V;
                int i = 2;
                boolean z = false;
                try {
                    if (this.seQ.iYF.azg()) {
                        if (this.seQ.bys() || this.seQ.byt()) {
                            V = this.seQ.byu();
                            if (V > 0 && V <= 4) {
                                i = V;
                            }
                            this.seQ.wt(i);
                            this.seQ.A(true, true);
                            if (this.seQ.oET != null && this.seQ.iYG != null && this.seQ.rVm != null) {
                                String url = this.seQ.oET.getUrl();
                                if (!bg.mA(url) && this.seQ.sej.add(url)) {
                                    GeneralControlWrapper bxR = this.seQ.iYG.bxR();
                                    boolean z2 = (bxR.sYY & 512) > 0;
                                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.GeneralControlWrapper", "allowUploadHosts, ret = " + z2);
                                    if (z2) {
                                        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.seQ.rVm;
                                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.JsApiHandler", "getAllHostsInPage, ready(%s).", new Object[]{Boolean.valueOf(dVar.sjS)});
                                        if (dVar.sjM != null && dVar.sjS) {
                                            dVar.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("sys:get_all_hosts", new HashMap(), dVar.sjU, dVar.sjV) + ")", null);
                                        }
                                    }
                                    if ((bxR.sYY & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) > 0) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.GeneralControlWrapper", "allowUploadHTML, ret = " + z2);
                                    if (z2) {
                                        this.seQ.rVm.iY(false);
                                        return;
                                    }
                                    com.tencent.mm.plugin.webview.model.af n = this.seQ.seq;
                                    if (!bg.mA(url)) {
                                        url = Uri.parse(url).getHost();
                                        if (!bg.mA(url)) {
                                            z = n.rXf.remove(url);
                                        }
                                    }
                                    if (z) {
                                        this.seQ.rVm.iY(true);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (bg.mA(this.seQ.fWY) || !com.tencent.mm.plugin.webview.a.rUX.matcher(this.seQ.fWY).matches()) {
                            V = this.seQ.iYF.dw(16384, 2);
                            i = V;
                            this.seQ.wt(i);
                            this.seQ.A(true, true);
                            if (this.seQ.oET != null) {
                            }
                        } else {
                            V = this.seQ.iYF.dw(16388, 2);
                            i = V;
                            this.seQ.wt(i);
                            this.seQ.A(true, true);
                            if (this.seQ.oET != null) {
                            }
                        }
                    }
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "onLoadJsApiFinished, ex = " + e.getMessage());
                }
                V = 2;
                i = V;
                this.seQ.wt(i);
                this.seQ.A(true, true);
                if (this.seQ.oET != null) {
                }
            }
        }, getIntent().getBooleanExtra("key_load_js_without_delay", false));
        try {
            bxA = bg.getInt(this.iYF.Ju("WebviewDisableDigestVerify"), 0);
        } catch (Exception e5222) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "getting js digest verification config fails, ex = " + e5222.getMessage());
            bxA = 0;
        }
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "js digest verification config = %d", new Object[]{Integer.valueOf(bxA)});
        if (bxA == 0 && getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("wvsha1", true) && byx()) {
            this.sdI.bzt();
        }
        if (getIntent().getBooleanExtra("forceHideShare", false)) {
            iS(false);
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "[hakon] postBinded :%d: force hide", new Object[]{Long.valueOf(System.currentTimeMillis())});
        } else {
            iS(getIntent().getBooleanExtra("showShare", true));
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "[cpan] postBinded :%d: show:%b", new Object[]{Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(z)});
        }
        this.scQ = LayoutInflater.from(this).inflate(R.i.drK, null);
        FontChooserView fontChooserView = (FontChooserView) this.scQ.findViewById(R.h.bQS);
        View findViewById = this.scQ.findViewById(R.h.bQR);
        if (this.oET.getX5WebViewExtension() != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WebViewUI seQ;

                {
                    this.seQ = r1;
                }

                public final void onClick(View view) {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.seQ, R.a.aRd);
                    loadAnimation.setAnimationListener(new AnimationListener(this) {
                        final /* synthetic */ AnonymousClass61 sfM;

                        {
                            this.sfM = r1;
                        }

                        public final void onAnimationStart(Animation animation) {
                        }

                        public final void onAnimationRepeat(Animation animation) {
                        }

                        public final void onAnimationEnd(Animation animation) {
                            this.sfM.seQ.scQ.setVisibility(8);
                        }
                    });
                    this.seQ.scQ.startAnimation(loadAnimation);
                    this.seQ.scQ.setVisibility(8);
                }
            });
        }
        fontChooserView.sne = new k(this);
        this.scQ.setLayoutParams(new FrameLayout.LayoutParams(-1, -2, 80));
        this.scS.addView(this.scQ);
        this.scQ.setVisibility(8);
        bxA = 2;
        try {
            if (this.iYF.azg()) {
                bxA = (bys() || byt()) ? byu() : (bg.mA(this.fWY) || !com.tencent.mm.plugin.webview.a.rUX.matcher(this.fWY).matches()) ? this.iYF.dw(16384, 0) : this.iYF.dw(16388, 0);
            }
        } catch (Exception e7) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "initFontChooserView, ex = " + e7.getMessage());
        }
        if (bxA <= 0 || bxA > 4) {
            bxA = 2;
        }
        wt(bxA);
        wu(bxA);
        try {
            this.iYF.a(this.fWY, true, null);
        } catch (Exception e52222) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "postBinded, jumpToActivity, ex = " + e52222.getMessage());
        }
        for (com.tencent.mm.plugin.webview.ui.tools.jsapi.b bVar : this.mot) {
            if (a(bVar, this.fWY)) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "initView, url handled, result = " + bVar.xM(this.fWY) + ", url = " + this.fWY);
                return;
            }
        }
        if (bxH()) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "needDelayLoadUrl is true, do nothing");
            return;
        }
        stringExtra8 = getIntent().getStringExtra(SlookAirButtonFrequentContactAdapter.DATA);
        if (stringExtra8 != null) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", stringExtra8);
            if (getIntent().getBooleanExtra("QRDataFlag", true)) {
                try {
                    stringExtra8 = this.iYF.Jq(stringExtra8);
                } catch (Exception e522222) {
                    com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "postBinded, formatQRString, ex = " + e522222.getMessage());
                }
            }
            this.oET.setOnLongClickListener(this.seC);
            this.seB = true;
            this.oET.getSettings().setUseWideViewPort(false);
            this.oET.getSettings().setLoadWithOverviewMode(false);
            if (JU(null)) {
                this.oET.getSettings().setJavaScriptEnabled(false);
                this.oET.loadDataWithBaseURL(null, stringExtra8, "text/html", ProtocolPackage.ServerEncoding, null);
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "loadDataWithBaseUrl, data = " + stringExtra8);
                return;
            }
            com.tencent.mm.sdk.platformtools.w.f("MicroMsg.WebViewUI", "postBinded baseUrl, canLoadUrl fail, url = " + null);
            azI();
            return;
        }
        if (bg.mA(this.fWY)) {
            ga(false);
        }
        if (this.fWY == null || this.fWY.length() == 0) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "initView, rawUrl is null, no data or getStringExtra(\"data\") is null");
            return;
        }
        Uri parse = Uri.parse(this.fWY);
        if (parse == null) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "initView uri is null");
            return;
        }
        if (parse.getScheme() == null) {
            this.fWY = "http://" + this.fWY;
        } else if (!parse.getScheme().startsWith("http")) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "uri scheme not startwith http, scheme = " + parse.getScheme());
            if (JU(this.fWY)) {
                this.oET.loadUrl(this.fWY);
                return;
            }
            com.tencent.mm.sdk.platformtools.w.f("MicroMsg.WebViewUI", "postBinded, canLoadUrl fail, url = " + this.fWY);
            azI();
            return;
        }
        this.sdz = new m(this.fWY);
        try {
            bundleExtra = this.iYF.d(100000, null);
            if (!(bundleExtra == null || bundleExtra.getString("force_geta8key_host_path") == null)) {
                this.seD = bundleExtra.getString("force_geta8key_host_path").split(";");
                this.sdz.seD = this.seD;
            }
        } catch (Exception e5222222) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "get force geta8key paths failed : %s", new Object[]{e5222222.getMessage()});
        }
        if (this.sdf || this.iYG.has(this.fWY)) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "initView, no need to geta8key, loadUrl directly, neverGetA8Key = " + this.sdf);
            if (!JU(this.fWY)) {
                com.tencent.mm.sdk.platformtools.w.f("MicroMsg.WebViewUI", "postBinded 2, canLoadUrl fail, url = " + this.fWY);
                azI();
                return;
            } else if (JO(this.fWY)) {
                this.sdY = true;
                this.scM.finish();
                this.scM.setVisibility(8);
                xG(this.fWY);
                return;
            } else {
                this.oET.loadUrl(this.fWY);
                return;
            }
        }
        if (JO(this.fWY)) {
            xG(this.fWY);
            this.seG = this.fWY;
            this.sdY = true;
            this.scM.finish();
            this.scM.setVisibility(8);
        }
        if (!this.sel && !this.sem && !isFinishing()) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "not call onDestory, try to geta8key again");
            j(this.fWY, false, -1);
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "before geta8key, rawUrl = " + this.fWY);
        }
    }

    public boolean JO(String str) {
        return com.tencent.mm.plugin.webview.modelcache.o.a(str, this.iYF, hashCode());
    }

    public void xG(String str) {
        Map hashMap = new HashMap(2);
        hashMap.put("Pragma", "no-cache");
        hashMap.put("Cache-Control", "no-cache");
        this.oET.loadUrl(str, hashMap);
    }

    public final boolean byl() {
        return false;
    }

    private boolean aAf() {
        boolean z = false;
        try {
            if (this.iYF == null) {
                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "invoker is null");
            } else {
                z = this.iYF.bxx();
            }
        } catch (RemoteException e) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "unable get config for Scan QRCode" + e.getMessage());
        }
        return z;
    }

    private boolean bxB() {
        boolean z = false;
        try {
            if (this.iYF == null) {
                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "invoker is null");
            } else {
                z = this.iYF.bxB();
            }
        } catch (RemoteException e) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "unable get config for WebViewDownLoadFile" + e.getMessage());
        }
        return z;
    }

    private static String xv(String str) {
        String str2 = null;
        try {
            Matcher matcher = Pattern.compile("(?i)^.*filename=\"?([^\"]+)\"?.*$").matcher(str);
            if (matcher.find() && matcher.groupCount() == 1) {
                str2 = matcher.group(1);
            }
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "getFileNameFromContentDisposition error " + e.getMessage());
        }
        return str2;
    }

    private boolean a(ContextMenu contextMenu, final String str) {
        boolean isSDCardAvailable;
        try {
            isSDCardAvailable = this.iYF.isSDCardAvailable();
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "onCreateContextMenu fail, ex = " + e.getMessage());
            isSDCardAvailable = false;
        }
        if (!isSDCardAvailable) {
            return true;
        }
        contextMenu.setHeaderTitle(R.l.fnH);
        try {
            isSDCardAvailable = this.iYF.azg();
        } catch (Exception e2) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "get has setuin failed : %s", new Object[]{e2.getMessage()});
            isSDCardAvailable = false;
        }
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "hasSetAcc = %b, canShareImage = %b, canFavImage = %b", new Object[]{Boolean.valueOf(isSDCardAvailable), Boolean.valueOf(this.iYG.bxR().bHk()), Boolean.valueOf(this.iYG.bxR().bHl())});
        if (isSDCardAvailable && r3) {
            contextMenu.add(0, 0, 0, getString(R.l.eHR)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ WebViewUI seQ;

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    try {
                        com.tencent.mm.pluginsdk.ui.tools.s.a(this.seQ, str, CookieManager.getInstance().getCookie(str), this.seQ.iYF.isSDCardAvailable(), new com.tencent.mm.pluginsdk.ui.tools.s.b(this) {
                            final /* synthetic */ AnonymousClass27 sfE;

                            {
                                this.sfE = r1;
                            }

                            public final void pG(String str) {
                                if (bg.mA(str)) {
                                    com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "share image to friend fail, imgPath is null");
                                } else {
                                    WebViewUI.e(this.sfE.seQ, str);
                                }
                            }
                        });
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "onMenuItemClick fail, ex = " + e.getMessage());
                    }
                    return true;
                }
            });
        }
        contextMenu.add(0, 0, 0, getString(R.l.eOm)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ WebViewUI seQ;

            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean isSDCardAvailable;
                try {
                    isSDCardAvailable = this.seQ.iYF.isSDCardAvailable();
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "onMenuItemClick fail, ex = " + e.getMessage());
                    isSDCardAvailable = false;
                }
                try {
                    com.tencent.mm.pluginsdk.ui.tools.s.a(this.seQ, str, CookieManager.getInstance().getCookie(str), isSDCardAvailable);
                } catch (Exception e2) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "save to sdcard failed : %s", new Object[]{e2.getMessage()});
                }
                return true;
            }
        });
        if (isSDCardAvailable && r4) {
            contextMenu.add(0, 0, 0, getString(R.l.eGa)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ WebViewUI seQ;

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    try {
                        boolean isSDCardAvailable = this.seQ.iYF.isSDCardAvailable();
                        String replaceAll = str.replaceAll("tp=webp", "");
                        com.tencent.mm.pluginsdk.ui.tools.s.a(this.seQ, replaceAll, CookieManager.getInstance().getCookie(replaceAll), isSDCardAvailable, new com.tencent.mm.pluginsdk.ui.tools.s.b(this) {
                            final /* synthetic */ AnonymousClass29 sfF;

                            {
                                this.sfF = r1;
                            }

                            public final void pG(String str) {
                                WebViewUI.f(this.sfF.seQ, str);
                            }
                        });
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "onMenuItemClick fail, ex = " + e.getMessage());
                    }
                    return true;
                }
            });
        }
        if (this.iYJ == null) {
            return false;
        }
        final String str2 = this.iYJ;
        contextMenu.add(0, 0, 0, com.tencent.mm.plugin.scanner.a.ak(this.iYK, this.iYJ) ? getString(R.l.eIB) : getString(R.l.eIA)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ WebViewUI seQ;

            public final boolean onMenuItemClick(MenuItem menuItem) {
                try {
                    this.seQ.iYF.f(str2, this.seQ.azN(), str, this.seQ.iYK, this.seQ.iYL);
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "onMenuItemClick recognize qbcode");
                } catch (RemoteException e) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "recognize qbar result failed");
                }
                return false;
            }
        });
        this.iYJ = null;
        return true;
    }

    private void a(ContextMenu contextMenu, IX5WebViewBase.HitTestResult hitTestResult) {
        if (!a(contextMenu, ((ImageData) hitTestResult.getData()).mPicUrl) && this.iYG.bxR().bHi() && aAf()) {
            this.iYO = hitTestResult;
            this.iYM = new com.tencent.mm.plugin.webview.d.g();
            this.iYM.a(this.oET, this.iYR);
        }
    }

    private void a(ContextMenu contextMenu, HitTestResult hitTestResult) {
        if (!a(contextMenu, hitTestResult.getExtra()) && this.iYG.bxR().bHi() && aAf()) {
            this.iYN = hitTestResult;
            this.iYM = new com.tencent.mm.plugin.webview.d.g();
            this.iYM.a(this.oET, this.iYR);
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        if (view instanceof android.webkit.WebView) {
            HitTestResult hitTestResult = this.oET.getHitTestResult();
            if (hitTestResult != null) {
                if (hitTestResult.getType() == 5 || hitTestResult.getType() == 8) {
                    a(contextMenu, hitTestResult);
                }
            }
        } else if (view instanceof IX5WebViewBase) {
            IX5WebViewBase.HitTestResult hitTestResult2 = ((IX5WebViewBase) view).getHitTestResult();
            if (hitTestResult2 == null) {
                return;
            }
            if (hitTestResult2.getType() == 5 || hitTestResult2.getType() == 8) {
                a(contextMenu, hitTestResult2);
            }
        }
    }

    protected final String bym() {
        String str = null;
        try {
            str = getIntent().getStringExtra("rawUrl");
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "getRawUrl exception:%s", new Object[]{e.getMessage()});
            if (e instanceof ClassNotFoundException) {
                finish();
                return str;
            }
        }
        if (str != null && str.length() > 0) {
            return str;
        }
        Uri data = getIntent().getData();
        if (data == null) {
            return "";
        }
        return data.toString();
    }

    private boolean aAs() {
        boolean z = false;
        try {
            z = this.iYF.Jt("favorite");
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.WebViewUI", e, "", new Object[z]);
        }
        return z;
    }

    private void bN(List<String> list) {
        Exception e;
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                if (this.sdE.get(str) != null) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "find %s icon from cache ok", new Object[]{str});
                } else {
                    com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "not found %s icon from cache, try to load", new Object[]{str});
                    try {
                        String Jp = this.iYF.Jp(str);
                        if (!bg.mA(Jp)) {
                            Bitmap JG = d.JG(Jp);
                            if (JG != null) {
                                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "load ok, and cache it");
                                this.sdE.put(str, JG);
                            }
                        }
                    } catch (Exception e2) {
                        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "getheadimg, ex = " + e2.getMessage());
                    }
                }
                if (this.sdF.containsKey(str)) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "find %s nick from cache ok", new Object[]{str});
                } else {
                    Object eK;
                    com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "not found %s nick from cache, try to load", new Object[]{str});
                    try {
                        eK = this.iYF.eK(str);
                        try {
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "load nick ok");
                        } catch (Exception e3) {
                            e = e3;
                            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "onAttach, ex = " + e.getMessage());
                            this.sdF.put(str, eK);
                        }
                    } catch (Exception e22) {
                        Exception exception = e22;
                        eK = null;
                        e = exception;
                        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "onAttach, ex = " + e.getMessage());
                        this.sdF.put(str, eK);
                    }
                    this.sdF.put(str, eK);
                }
            }
        }
    }

    protected final boolean nA(int i) {
        SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) this.seE.get(this.oET.getUrl());
        if (sparseBooleanArray == null || !sparseBooleanArray.get(i, false)) {
            return true;
        }
        return false;
    }

    public final void aAn() {
        String JR = JR(this.seG);
        String stringExtra = getIntent().getStringExtra("shortcut_user_name");
        if (bg.mA(JR) || bg.mA(stringExtra)) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "addShortcut, appid or username is null");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("KAppId", JR);
        bundle.putString("shortcut_user_name", stringExtra);
        bundle.putInt("webviewui_binder_id", hashCode());
        try {
            this.iYF.d(80, bundle);
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "addShortcut, e = " + e.getMessage());
        }
    }

    public void aAb() {
        boolean z;
        com.tencent.mm.ui.widget.e eVar;
        String str = null;
        String url = this.oET.getUrl();
        final ArrayList arrayList = this.sdO.containsKey(url) ? (ArrayList) this.sdO.get(url) : null;
        if (arrayList == null || arrayList.size() <= 0) {
            z = false;
        } else {
            z = true;
        }
        final Boolean valueOf = Boolean.valueOf(z);
        if (valueOf.booleanValue()) {
            eVar = new com.tencent.mm.ui.widget.e(this.uSU.uTo, com.tencent.mm.ui.widget.e.wuP, false);
        } else {
            eVar = new com.tencent.mm.ui.widget.e(this.uSU.uTo, com.tencent.mm.ui.widget.e.wuO, true);
        }
        eVar.wnf = new com.tencent.mm.ui.base.n.a(this) {
            final /* synthetic */ WebViewUI seQ;

            {
                this.seQ = r1;
            }

            public final void a(ImageView imageView, MenuItem menuItem) {
                if (WebViewUI.i(menuItem)) {
                    imageView.setVisibility(8);
                    return;
                }
                String str = menuItem.getTitle();
                if (this.seQ.sdE.get(str) == null || ((Bitmap) this.seQ.sdE.get(str)).isRecycled()) {
                    com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "on attach icon, load from cache fail");
                    try {
                        String Jp = this.seQ.iYF.Jp(str);
                        if (!bg.mA(Jp)) {
                            Bitmap JG = d.JG(Jp);
                            if (JG != null && !JG.isRecycled()) {
                                imageView.setImageBitmap(JG);
                                this.seQ.sdE.put(str, JG);
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "getheadimg, ex = " + e.getMessage());
                        return;
                    }
                }
                imageView.setImageBitmap((Bitmap) this.seQ.sdE.get(str));
            }
        };
        eVar.wng = new com.tencent.mm.ui.base.n.b(this) {
            final /* synthetic */ WebViewUI seQ;

            {
                this.seQ = r1;
            }

            public final void a(TextView textView, MenuItem menuItem) {
                String str = menuItem.getTitle();
                if (textView != null) {
                    String str2 = (String) this.seQ.sdF.get(str);
                    if (bg.mA(str2)) {
                        textView.setText(str);
                    } else {
                        textView.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.seQ.uSU.uTo, str2, textView.getTextSize()));
                    }
                }
            }
        };
        eVar.qJg = new com.tencent.mm.ui.base.n.d(this) {
            final /* synthetic */ WebViewUI seQ;

            {
                this.seQ = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                String stringExtra;
                Throwable e;
                boolean z;
                boolean z2 = false;
                if (WebViewUI.i(menuItem)) {
                    com.tencent.mm.i.d.b bVar = (com.tencent.mm.i.d.b) menuItem.getMenuInfo();
                    if (bVar != null) {
                        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.seQ.rVm;
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.JsApiHandler", "onCustomMenuClick");
                        Map hashMap = new HashMap();
                        hashMap.put("key", bVar.arH);
                        hashMap.put("title", bVar.title);
                        dVar.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:custom", hashMap, dVar.sjU, dVar.sjV) + ")", null);
                        return;
                    }
                    return;
                }
                String stringExtra2;
                String stringExtra3;
                com.tencent.mm.plugin.webview.model.ai.c bwE;
                com.tencent.mm.plugin.webview.model.ai.c bwE2;
                Intent intent;
                switch (menuItem.getItemId()) {
                    case 1:
                        stringExtra2 = this.seQ.getIntent().getStringExtra("KPublisherId");
                        stringExtra3 = this.seQ.getIntent().getStringExtra("KAppId");
                        stringExtra = this.seQ.getIntent().getStringExtra("srcUsername");
                        bwE = this.seQ.rWq.bwE();
                        bwE.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(1), Integer.valueOf(1), stringExtra2, stringExtra3, stringExtra};
                        bwE.b(this.seQ.iYF);
                        this.seQ.sdd = this.seQ.iYG.bxR().bHj();
                        this.seQ.aAh();
                        return;
                    case 2:
                        int intValue;
                        stringExtra2 = this.seQ.getIntent().getStringExtra("KPublisherId");
                        stringExtra3 = this.seQ.getIntent().getStringExtra("KAppId");
                        stringExtra = this.seQ.getIntent().getStringExtra("srcUsername");
                        bwE = this.seQ.rWq.bwE();
                        bwE.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(2), Integer.valueOf(1), stringExtra2, stringExtra3, stringExtra};
                        bwE.b(this.seQ.iYF);
                        this.seQ.sdd = this.seQ.iYG.bxR().bHj();
                        if (this.seQ.sdQ.containsKey(this.seQ.oET.getUrl())) {
                            intValue = ((Integer) this.seQ.sdQ.get(this.seQ.oET.getUrl())).intValue();
                        } else {
                            intValue = 0;
                        }
                        WebViewUI webViewUI = this.seQ;
                        webViewUI.rVm.az("shareTimeline", true);
                        dVar = webViewUI.rVm;
                        if (dVar.sjS) {
                            try {
                                dVar.iYF.D("urlAttribute", String.valueOf(intValue), dVar.rZN);
                            } catch (Throwable e2) {
                                com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                            }
                            dVar.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:share:timeline", new HashMap(), dVar.sjU, dVar.sjV) + ")", null);
                            return;
                        }
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.JsApiHandler", "onShareTimeline fail, not ready");
                        return;
                    case 3:
                        bwE2 = this.seQ.rWq.bwE();
                        bwE2.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(3), Integer.valueOf(1)};
                        bwE2.b(this.seQ.iYF);
                        com.tencent.mm.plugin.report.service.g.oUh.a(157, 6, 1, false);
                        this.seQ.sdd = this.seQ.iYG.bxR().bHj();
                        this.seQ.aAo();
                        return;
                    case 5:
                        bwE2 = this.seQ.rWq.bwE();
                        bwE2.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(4), Integer.valueOf(1)};
                        bwE2.b(this.seQ.iYF);
                        stringExtra2 = (String) this.seQ.sdN.get(this.seQ.oET.getUrl());
                        if (stringExtra2 == null) {
                            stringExtra2 = this.seQ.getIntent().getStringExtra("srcUsername");
                        }
                        WebViewUI.h(this.seQ, "Contact_Scene");
                        WebViewUI.i(this.seQ, stringExtra2);
                        return;
                    case 6:
                        bwE2 = this.seQ.rWq.bwE();
                        bwE2.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(5), Integer.valueOf(1)};
                        bwE2.b(this.seQ.iYF);
                        WebViewUI.ab(this.seQ);
                        return;
                    case 7:
                        bwE2 = this.seQ.rWq.bwE();
                        bwE2.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(13), Integer.valueOf(1)};
                        bwE2.b(this.seQ.iYF);
                        WebViewUI.ac(this.seQ);
                        return;
                    case 8:
                        bwE2 = this.seQ.rWq.bwE();
                        bwE2.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(15), Integer.valueOf(1)};
                        bwE2.b(this.seQ.iYF);
                        WebViewUI.ad(this.seQ);
                        return;
                    case 9:
                        bwE2 = this.seQ.rWq.bwE();
                        bwE2.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(7), Integer.valueOf(1)};
                        bwE2.b(this.seQ.iYF);
                        com.tencent.mm.ui.base.g.a(this.seQ.uSU.uTo, this.seQ.uSU.uTo.getString(R.l.dGC), null, null, this.seQ.uSU.uTo.getString(R.l.dGB), new com.tencent.mm.ui.base.g.d(this.seQ) {
                            final /* synthetic */ WebViewUI seQ;

                            {
                                this.seQ = r1;
                            }

                            public final void bN(int i, int i2) {
                                switch (i2) {
                                    case -1:
                                        Bundle bundle = new Bundle();
                                        bundle.putLong("fav_local_id", this.seQ.getIntent().getLongExtra("fav_local_id", -1));
                                        try {
                                            if (this.seQ.iYF.Q(bundle)) {
                                                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "del fav web url ok, finish webview ui");
                                                this.seQ.finish();
                                                return;
                                            }
                                            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "try to del web url fail");
                                            return;
                                        } catch (Throwable e) {
                                            com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.WebViewUI", e, "", new Object[0]);
                                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "try to del web url crash");
                                            return;
                                        }
                                    default:
                                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "do del cancel");
                                        return;
                                }
                            }
                        });
                        return;
                    case 10:
                        bwE2 = this.seQ.rWq.bwE();
                        bwE2.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(11), Integer.valueOf(1)};
                        bwE2.b(this.seQ.iYF);
                        this.seQ.byq();
                        return;
                    case 11:
                        bwE2 = this.seQ.rWq.bwE();
                        bwE2.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(8), Integer.valueOf(1)};
                        bwE2.b(this.seQ.iYF);
                        if (this.seQ.scQ.getVisibility() == 8) {
                            this.seQ.scQ.startAnimation(AnimationUtils.loadAnimation(this.seQ, R.a.aRc));
                            this.seQ.scQ.setVisibility(0);
                            return;
                        }
                        Animation loadAnimation = AnimationUtils.loadAnimation(this.seQ, R.a.aRd);
                        loadAnimation.setAnimationListener(new AnimationListener(this) {
                            final /* synthetic */ AnonymousClass35 sfG;

                            {
                                this.sfG = r1;
                            }

                            public final void onAnimationStart(Animation animation) {
                            }

                            public final void onAnimationRepeat(Animation animation) {
                            }

                            public final void onAnimationEnd(Animation animation) {
                                this.sfG.seQ.scQ.setVisibility(8);
                            }
                        });
                        this.seQ.scQ.startAnimation(loadAnimation);
                        this.seQ.scQ.setVisibility(8);
                        return;
                    case 12:
                        bwE2 = this.seQ.rWq.bwE();
                        bwE2.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(6), Integer.valueOf(1)};
                        bwE2.b(this.seQ.iYF);
                        intent = new Intent();
                        intent.putExtra("key_fav_scene", 2);
                        intent.putExtra("key_fav_item_id", this.seQ.getIntent().getLongExtra("fav_local_id", -1));
                        com.tencent.mm.bb.d.b(this.seQ.uSU.uTo, "favorite", ".ui.FavTagEditUI", intent);
                        return;
                    case 14:
                        bwE2 = this.seQ.rWq.bwE();
                        bwE2.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(9), Integer.valueOf(1)};
                        bwE2.b(this.seQ.iYF);
                        if (this.seQ.sdK) {
                            WebViewUI.j(this.seQ, this.seQ.sdL);
                            return;
                        } else {
                            WebViewUI.a(this.seQ, this.seQ.oET.getUrl(), this.seQ.oET.getSettings().getUserAgentString(), this.seQ.width, this.seQ.height);
                            return;
                        }
                    case 15:
                        bwE2 = this.seQ.rWq.bwE();
                        bwE2.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(19), Integer.valueOf(1)};
                        bwE2.b(this.seQ.iYF);
                        WebViewUI.a(this.seQ, menuItem);
                        return;
                    case 16:
                        bwE2 = this.seQ.rWq.bwE();
                        bwE2.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(21), Integer.valueOf(1)};
                        bwE2.b(this.seQ.iYF);
                        WebViewUI.a(this.seQ, menuItem);
                        return;
                    case 17:
                        bwE2 = this.seQ.rWq.bwE();
                        bwE2.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(20), Integer.valueOf(1)};
                        bwE2.b(this.seQ.iYF);
                        WebViewUI.a(this.seQ, menuItem);
                        return;
                    case 18:
                        bwE2 = this.seQ.rWq.bwE();
                        bwE2.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(22), Integer.valueOf(1)};
                        bwE2.b(this.seQ.iYF);
                        WebViewUI.a(this.seQ, menuItem);
                        return;
                    case 19:
                        bwE2 = this.seQ.rWq.bwE();
                        bwE2.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(23), Integer.valueOf(1)};
                        bwE2.b(this.seQ.iYF);
                        WebViewUI.a(this.seQ, menuItem);
                        return;
                    case 20:
                        bwE2 = this.seQ.rWq.bwE();
                        bwE2.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(17), Integer.valueOf(1)};
                        bwE2.b(this.seQ.iYF);
                        WebViewUI.al(this.seQ);
                        return;
                    case 21:
                        bwE2 = this.seQ.rWq.bwE();
                        bwE2.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(18), Integer.valueOf(1)};
                        bwE2.b(this.seQ.iYF);
                        WebViewUI.am(this.seQ);
                        return;
                    case 22:
                        bwE2 = this.seQ.rWq.bwE();
                        bwE2.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(24), Integer.valueOf(1)};
                        bwE2.b(this.seQ.iYF);
                        WebViewUI.an(this.seQ);
                        return;
                    case 23:
                        intent = new Intent();
                        stringExtra3 = this.seQ.getIntent().getStringExtra("sns_local_id");
                        if (stringExtra3 != null) {
                            intent.putExtra("sns_send_data_ui_activity", true);
                            intent.putExtra("sns_local_id", stringExtra3);
                        } else {
                            intent.putExtra("Retr_Msg_Id", Long.valueOf(this.seQ.getIntent().getLongExtra("msg_id", Long.MIN_VALUE)));
                        }
                        com.tencent.mm.bb.d.a(this.seQ.uSU.uTo, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
                        return;
                    case 24:
                        bwE2 = this.seQ.rWq.bwE();
                        bwE2.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(16), Integer.valueOf(1)};
                        bwE2.b(this.seQ.iYF);
                        WebViewUI.ap(this.seQ);
                        return;
                    case 25:
                        bwE2 = this.seQ.rWq.bwE();
                        bwE2.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(26), Integer.valueOf(1)};
                        bwE2.b(this.seQ.iYF);
                        WebViewUI.aj(this.seQ);
                        return;
                    case 26:
                        bwE2 = this.seQ.rWq.bwE();
                        bwE2.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(27), Integer.valueOf(1)};
                        bwE2.b(this.seQ.iYF);
                        WebViewUI.ak(this.seQ);
                        return;
                    case 27:
                        bwE2 = this.seQ.rWq.bwE();
                        bwE2.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(32), Integer.valueOf(1)};
                        bwE2.b(this.seQ.iYF);
                        if (!this.seQ.azQ()) {
                            this.seQ.finish();
                            return;
                        }
                        return;
                    case 28:
                        bwE2 = this.seQ.rWq.bwE();
                        bwE2.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(10), Integer.valueOf(1)};
                        bwE2.b(this.seQ.iYF);
                        if (this.seQ.oET != null) {
                            this.seQ.oET.reload();
                            return;
                        }
                        return;
                    case JsApiChooseImage.CTRL_INDEX /*29*/:
                        bwE2 = this.seQ.rWq.bwE();
                        bwE2.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(31), Integer.valueOf(1)};
                        bwE2.b(this.seQ.iYF);
                        this.seQ.aAn();
                        return;
                    case 30:
                        bwE2 = this.seQ.rWq.bwE();
                        bwE2.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(29), Integer.valueOf(1)};
                        bwE2.b(this.seQ.iYF);
                        this.seQ.aAk();
                        return;
                    case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                        com.tencent.mm.plugin.report.service.g.oUh.a(480, 1, 1, false);
                        bwE2 = this.seQ.rWq.bwE();
                        bwE2.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(28), Integer.valueOf(1)};
                        bwE2.b(this.seQ.iYF);
                        if (!this.seQ.scY.isShown()) {
                            this.seQ.scY.reset();
                            this.seQ.scY.bzY();
                            this.seQ.scY.show();
                            return;
                        }
                        return;
                    case 32:
                        bwE2 = this.seQ.rWq.bwE();
                        bwE2.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(30), Integer.valueOf(1)};
                        bwE2.b(this.seQ.iYF);
                        this.seQ.aAl();
                        return;
                    case 33:
                        bwE2 = this.seQ.rWq.bwE();
                        bwE2.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(14), Integer.valueOf(1)};
                        bwE2.b(this.seQ.iYF);
                        WebViewUI.ao(this.seQ);
                        return;
                    default:
                        bwE2 = this.seQ.rWq.bwE();
                        bwE2.rXz = new Object[]{this.seQ.fWY, Integer.valueOf(16), Integer.valueOf(1)};
                        bwE2.b(this.seQ.iYF);
                        stringExtra = menuItem.getTitle();
                        if (!bg.mA(stringExtra)) {
                            try {
                                Bundle bundle = new Bundle();
                                bundle.putString(SlookAirButtonFrequentContactAdapter.DATA, stringExtra);
                                bundle = this.seQ.iYF.d(50, bundle);
                                if (bundle != null) {
                                    z = bundle.getInt("key_biz_type") == 2;
                                    try {
                                        if (bundle.getInt("key_biz_type") == 3) {
                                            z2 = true;
                                        }
                                    } catch (RemoteException e3) {
                                        e2 = e3;
                                        com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.WebViewUI", e2, "", new Object[0]);
                                        z2 = z;
                                        if (z2) {
                                            this.seQ.JP(stringExtra);
                                            return;
                                        } else {
                                            WebViewUI.l(this.seQ, stringExtra);
                                            return;
                                        }
                                    }
                                }
                            } catch (RemoteException e4) {
                                e2 = e4;
                                z = false;
                                com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.WebViewUI", e2, "", new Object[0]);
                                z2 = z;
                                if (z2) {
                                    WebViewUI.l(this.seQ, stringExtra);
                                    return;
                                } else {
                                    this.seQ.JP(stringExtra);
                                    return;
                                }
                            }
                            if (z2) {
                                this.seQ.JP(stringExtra);
                                return;
                            } else {
                                WebViewUI.l(this.seQ, stringExtra);
                                return;
                            }
                        }
                        return;
                }
            }
        };
        eVar.qJf = new com.tencent.mm.ui.base.n.c(this) {
            final /* synthetic */ WebViewUI seQ;

            public final void a(com.tencent.mm.ui.base.l lVar) {
                com.tencent.mm.plugin.report.service.g.oUh.a(480, 0, 1, false);
                int i;
                if (valueOf.booleanValue()) {
                    int size = arrayList.size();
                    for (i = 0; i < size; i++) {
                        com.tencent.mm.i.d.b bVar = (com.tencent.mm.i.d.b) arrayList.get(i);
                        com.tencent.mm.ui.base.m mVar = (com.tencent.mm.ui.base.m) lVar.e(bVar.id, bVar.title);
                        mVar.vld = bVar;
                        mVar.setIcon(null);
                        mVar.setIcon(0);
                    }
                    return;
                }
                try {
                    LinkedList aq = this.seQ.byn();
                    if (aq != null) {
                        i = 0;
                        while (i < aq.size() && i < 8) {
                            com.tencent.mm.i.d.a aVar = (com.tencent.mm.i.d.a) aq.get(i);
                            if ("index".equals(bg.mz(aVar.id))) {
                                mVar = (com.tencent.mm.ui.base.m) lVar.a(15, this.seQ.getString(R.l.fmh), R.k.duM);
                            } else if ("categories".equals(bg.mz(aVar.id))) {
                                mVar = (com.tencent.mm.ui.base.m) lVar.a(16, this.seQ.getString(R.l.fmg), R.k.duL);
                            } else if ("cart".equals(bg.mz(aVar.id))) {
                                mVar = (com.tencent.mm.ui.base.m) lVar.a(17, this.seQ.getString(R.l.fmf), R.k.duK);
                            } else if ("profile".equals(bg.mz(aVar.id))) {
                                mVar = (com.tencent.mm.ui.base.m) lVar.a(18, this.seQ.getString(R.l.fmj), R.k.duR);
                            } else if ("member".equals(bg.mz(aVar.id))) {
                                mVar = (com.tencent.mm.ui.base.m) lVar.a(19, this.seQ.getString(R.l.fmi), R.k.duN);
                            } else {
                                mVar = null;
                            }
                            if (mVar != null) {
                                mVar.iMP = aVar.url;
                            }
                            i++;
                        }
                    }
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "exception in add jd menu, " + e.getMessage());
                }
                if (this.seQ.iYG == null || this.seQ.iYG.bxQ() == null) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "get permission failed");
                    return;
                }
                boolean eV;
                String bxo;
                JsapiPermissionWrapper bxQ = this.seQ.iYG.bxQ();
                if (bxQ.nw(21) && this.seQ.nA(1)) {
                    lVar.a(1, this.seQ.getString(R.l.eHR), R.k.duZ);
                }
                if (bxQ.nw(23) && this.seQ.nA(2)) {
                    lVar.a(2, this.seQ.getString(R.l.eHS), R.k.duP);
                }
                if (!this.seQ.sdh && this.seQ.aAs() && this.seQ.nA(3)) {
                    lVar.a(3, this.seQ.getString(R.l.eGa), R.k.duI);
                }
                try {
                    if (this.seQ.iYF.q(this.seQ.getIntent().getLongExtra("msg_id", Long.MIN_VALUE), this.seQ.getIntent().getStringExtra("sns_local_id"))) {
                        lVar.a(23, this.seQ.getString(R.l.ebR), R.k.duQ);
                    }
                } catch (Throwable e2) {
                    com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.WebViewUI", e2, "", new Object[0]);
                }
                lVar.a(31, this.seQ.getString(R.l.fnQ), R.k.duX);
                if (bxQ.nw(44) && this.seQ.nA(6)) {
                    lVar.a(6, this.seQ.getString(R.l.fnm), R.k.duC);
                }
                if (bxQ.sZd != null && this.seQ.sdh && this.seQ.getIntent().getBooleanExtra("key_detail_can_delete", true) && this.seQ.aAs()) {
                    if (this.seQ.nA(12)) {
                        lVar.a(12, this.seQ.getString(R.l.ehz), R.k.dux);
                    }
                    if (this.seQ.nA(9)) {
                        lVar.a(9, this.seQ.getString(R.l.dGB), R.k.duD);
                    }
                }
                String stringExtra = this.seQ.getIntent().getStringExtra("srcUsername");
                if (!bg.mA(stringExtra)) {
                    try {
                        eV = this.seQ.iYF.eV(stringExtra);
                    } catch (Exception e3) {
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "sharebtn click fail isBizContact, ex = " + e3.getMessage());
                        eV = false;
                    }
                    if (eV) {
                        boolean eU;
                        try {
                            eU = this.seQ.iYF.eU(stringExtra);
                        } catch (Exception e32) {
                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "sharebtn click fail, ex = " + e32.getMessage());
                            eU = false;
                        }
                        if (eU) {
                            eV = bxQ.nw(19);
                        } else {
                            eV = bxQ.nw(20);
                        }
                        boolean byo = this.seQ.byo();
                        if ((eV && this.seQ.nA(5)) || byo) {
                            int i2 = eU ? R.l.fnx : R.l.fno;
                            if (byo) {
                                i2 = R.l.fny;
                            }
                            lVar.a(5, this.seQ.getString(i2), R.k.duz);
                        }
                    } else {
                        try {
                            this.seQ.iYF.Jv(stringExtra);
                        } catch (Exception e322) {
                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "sharebtn click fail triggerGetContact, ex = " + e322.getMessage());
                        }
                    }
                }
                if (this.seQ.LZ()) {
                    if (this.seQ.nA(32)) {
                        lVar.a(32, this.seQ.getString(R.l.eHT), R.k.dva);
                    }
                } else if (this.seQ.nA(30)) {
                    lVar.a(30, this.seQ.getString(R.l.eHY), R.k.dvb);
                }
                if (bxQ.nw(45) && this.seQ.nA(7)) {
                    lVar.a(7, this.seQ.getString(R.l.fnr), R.k.duA);
                }
                if (bxQ.nw(43) && this.seQ.nA(24) && !com.tencent.mm.pluginsdk.model.app.p.n(this.seQ.uSU.uTo, "com.tencent.wework")) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString("enterprise_action", "enterprise_has_connector");
                        bundle = this.seQ.iYF.d(71, bundle);
                        if (bundle != null) {
                            eV = bundle.getBoolean("enterprise_has_connector");
                            if (eV) {
                                lVar.a(24, this.seQ.getString(R.l.eIc), R.k.duG);
                            }
                        }
                    } catch (Exception e3222) {
                        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "builder add, ex = " + e3222.getMessage());
                    }
                    eV = false;
                    if (eV) {
                        lVar.a(24, this.seQ.getString(R.l.eIc), R.k.duG);
                    }
                }
                if (bxQ.nw(18) && this.seQ.nA(11)) {
                    lVar.a(11, this.seQ.getString(R.l.eHQ), R.k.duJ);
                }
                if (this.seQ.nA(28)) {
                    lVar.a(28, this.seQ.getString(R.l.flP), R.k.duV);
                }
                if (bxQ.nw(73) && this.seQ.nA(14) && !this.seQ.sdK) {
                    lVar.a(14, this.seQ.getString(R.l.fnN), R.k.duU);
                }
                if (this.seQ.sdK && this.seQ.nA(14)) {
                    lVar.a(14, this.seQ.getString(R.l.fnM), R.k.duQ);
                }
                eV = (this.seQ.iYG.bxR().sYY & 16) > 0;
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.GeneralControlWrapper", "allowExpose, ret = " + eV);
                if (eV && this.seQ.nA(10)) {
                    lVar.a(10, this.seQ.getString(R.l.dOR), R.k.duB);
                }
                if (bxQ.nw(36) && this.seQ.nA(8)) {
                    try {
                        bxo = this.seQ.iYF.bxo();
                    } catch (Exception e4) {
                        bxo = null;
                    }
                    if (bg.mA(bxo)) {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "get mail session key is null or nil, should not show send mail menu");
                    } else {
                        lVar.a(8, this.seQ.getString(R.l.fnt), R.k.duO);
                    }
                }
                if (bxQ.nw(31) && this.seQ.nA(30)) {
                    try {
                        if (this.seQ.iYF.d(78, null).getBoolean("isOpenForFaceBook", false)) {
                            lVar.a(33, this.seQ.getString(R.l.fnT), R.k.dwr);
                        }
                    } catch (Throwable e22) {
                        com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.WebViewUI", e22, "", new Object[0]);
                    }
                }
                if (WWAPIFactory.hM(this.seQ).chS() && this.seQ.nA(25)) {
                    bxo = WWAPIFactory.hM(this.seQ).chT();
                    lVar.a(25, this.seQ.getString(R.l.eId, new Object[]{bxo}), R.k.dvd);
                }
                if (com.tencent.mm.plugin.webview.stub.a.aK(this.seQ, this.seQ.oET.getUrl()) && this.seQ.nA(26)) {
                    lVar.a(26, this.seQ.getString(R.l.fnS), R.k.dvc);
                }
                if (bxQ.nw(91) && com.tencent.mm.plugin.webview.stub.a.dc(this.seQ) && this.seQ.nA(20)) {
                    lVar.a(20, this.seQ.getString(R.l.fnU), R.k.duS);
                }
                if (bxQ.nw(com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX) && com.tencent.mm.plugin.webview.stub.a.dc(this.seQ) && this.seQ.nA(22)) {
                    lVar.a(22, this.seQ.getString(R.l.fnV), R.k.duT);
                }
                try {
                    if (bxQ.nw(43) && this.seQ.nA(0) && this.seQ.iYF.Dw()) {
                        List<String> Dv = this.seQ.iYF.Dv();
                        for (String bxo2 : Dv) {
                            lVar.add(bxo2);
                        }
                        this.seQ.bN(Dv);
                    }
                } catch (Exception e32222) {
                    com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "builder add, ex = " + e32222.getMessage());
                }
                if (this.seQ.scT != null && this.seQ.scT.getVisibility() == 0) {
                    lVar.a(27, this.seQ.getString(R.l.eHX), R.k.duH);
                }
                bxo2 = this.seQ.JR(this.seQ.seG);
                stringExtra = this.seQ.getIntent().getStringExtra("shortcut_user_name");
                if (!this.seQ.sdl && !bg.mA(bxo2) && !bg.mA(stringExtra) && bxQ.nw(255) && this.seQ.nA(29)) {
                    lVar.a(29, this.seQ.getString(R.l.eHP), R.k.dAF);
                }
            }
        };
        if (this.oET != null) {
            str = this.oET.getUrl();
        }
        if (!bg.mA(str)) {
            if (!bg.mA(Uri.parse(str).getHost())) {
                eVar.d(getString(R.l.fmw, new Object[]{Uri.parse(str).getHost()}), 1);
            }
        }
        if (this.scV) {
            eVar.sjm = true;
            eVar.sjn = true;
        } else {
            eVar.sjm = false;
            eVar.sjn = false;
        }
        if (this.scY == null || !this.scY.isShown()) {
            aHf();
            af.f(new Runnable(this) {
                final /* synthetic */ WebViewUI seQ;

                public final void run() {
                    if (this.seQ.isFinishing() || this.seQ.sel) {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
                    } else {
                        eVar.bzh();
                    }
                }
            }, 100);
            return;
        }
        this.scY.hide();
        af.f(new Runnable(this) {
            final /* synthetic */ WebViewUI seQ;

            public final void run() {
                if (this.seQ.isFinishing() || this.seQ.sel) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
                } else {
                    eVar.bzh();
                }
            }
        }, 100);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.LinkedList<com.tencent.mm.i.d.a> byn() {
        /*
        r12 = this;
        r0 = 0;
        r2 = 1;
        r3 = 0;
        r1 = r12.oET;
        if (r1 != 0) goto L_0x0011;
    L_0x0007:
        r1 = "MicroMsg.WebViewUI";
        r2 = "viewwv is null, maybe has destroyed";
        com.tencent.mm.sdk.platformtools.w.e(r1, r2);
    L_0x0010:
        return r0;
    L_0x0011:
        r4 = r12.fWY;
        r1 = r12.oET;
        if (r1 == 0) goto L_0x00cc;
    L_0x0017:
        r1 = r12.oET;
        r1 = r1.getUrl();
        r5 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r5 != 0) goto L_0x00cc;
    L_0x0023:
        if (r1 == 0) goto L_0x0010;
    L_0x0025:
        r4 = new java.net.URL;	 Catch:{ Exception -> 0x00b8 }
        r4.<init>(r1);	 Catch:{ Exception -> 0x00b8 }
        r1 = ".*(\\.wanggou\\.com|\\.jd\\.com)";
        r5 = java.util.regex.Pattern.compile(r1);	 Catch:{ Exception -> 0x00b8 }
        r1 = r4.getHost();	 Catch:{ Exception -> 0x00b8 }
        r4 = com.tencent.mm.sdk.platformtools.bg.mA(r1);	 Catch:{ Exception -> 0x00b8 }
        if (r4 != 0) goto L_0x0010;
    L_0x003b:
        r4 = ".";
        r4 = r1.startsWith(r4);	 Catch:{ Exception -> 0x00b8 }
        if (r4 != 0) goto L_0x0054;
    L_0x0044:
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00b8 }
        r6 = ".";
        r4.<init>(r6);	 Catch:{ Exception -> 0x00b8 }
        r1 = r4.append(r1);	 Catch:{ Exception -> 0x00b8 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00b8 }
    L_0x0054:
        r4 = "MicroMsg.WebViewUI";
        r6 = "host = %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x00b8 }
        r8 = 0;
        r7[r8] = r1;	 Catch:{ Exception -> 0x00b8 }
        com.tencent.mm.sdk.platformtools.w.d(r4, r6, r7);	 Catch:{ Exception -> 0x00b8 }
        r1 = r5.matcher(r1);	 Catch:{ Exception -> 0x00b8 }
        r1 = r1.matches();	 Catch:{ Exception -> 0x00b8 }
        if (r1 == 0) goto L_0x0010;
    L_0x006d:
        r1 = r12.see;	 Catch:{ Exception -> 0x00b8 }
        if (r1 != 0) goto L_0x00a2;
    L_0x0071:
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00b8 }
        r1 = r12.iYF;	 Catch:{ Exception -> 0x00b8 }
        r1 = r1.bxr();	 Catch:{ Exception -> 0x00b8 }
        r12.see = r1;	 Catch:{ Exception -> 0x00b8 }
        r6 = "MicroMsg.WebViewUI";
        r7 = "[hakon] getConfigListMap %b, cost %d";
        r1 = 2;
        r8 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x00b8 }
        r9 = 0;
        r1 = r12.see;	 Catch:{ Exception -> 0x00b8 }
        if (r1 == 0) goto L_0x00b6;
    L_0x008b:
        r1 = r2;
    L_0x008c:
        r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x00b8 }
        r8[r9] = r1;	 Catch:{ Exception -> 0x00b8 }
        r1 = 1;
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00b8 }
        r4 = r10 - r4;
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x00b8 }
        r8[r1] = r4;	 Catch:{ Exception -> 0x00b8 }
        com.tencent.mm.sdk.platformtools.w.d(r6, r7, r8);	 Catch:{ Exception -> 0x00b8 }
    L_0x00a2:
        r1 = r12.see;	 Catch:{ Exception -> 0x00b8 }
        if (r1 == 0) goto L_0x0010;
    L_0x00a6:
        r1 = r12.see;	 Catch:{ Exception -> 0x00b8 }
        r1 = r1.size();	 Catch:{ Exception -> 0x00b8 }
        if (r1 <= 0) goto L_0x0010;
    L_0x00ae:
        r1 = r12.see;	 Catch:{ Exception -> 0x00b8 }
        r0 = com.tencent.mm.i.d.j(r1);	 Catch:{ Exception -> 0x00b8 }
        goto L_0x0010;
    L_0x00b6:
        r1 = r3;
        goto L_0x008c;
    L_0x00b8:
        r1 = move-exception;
        r4 = "MicroMsg.WebViewUI";
        r5 = "[hakon] getJDMenuItems, ex = ";
        r2 = new java.lang.Object[r2];
        r1 = r1.getMessage();
        r2[r3] = r1;
        com.tencent.mm.sdk.platformtools.w.d(r4, r5, r2);
        goto L_0x0010;
    L_0x00cc:
        r1 = r4;
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.byn():java.util.LinkedList<com.tencent.mm.i.d$a>");
    }

    protected final boolean byo() {
        String stringExtra = getIntent().getStringExtra("srcUsername");
        String stringExtra2 = getIntent().getStringExtra("bizofstartfrom");
        return (stringExtra == null || stringExtra2 == null || !"enterpriseHomeSubBrand".equals(stringExtra2)) ? false : true;
    }

    protected final void b(String str, Drawable drawable) {
        final boolean byo = byo();
        final String stringExtra = getIntent().getStringExtra("srcUsername");
        this.uSU.a(0, str, drawable, new OnMenuItemClickListener(this) {
            final /* synthetic */ WebViewUI seQ;

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (byo) {
                    WebViewUI.i(this.seQ, stringExtra);
                } else {
                    this.seQ.aAb();
                }
                return true;
            }
        });
    }

    public final void iS(boolean z) {
        this.sey = z;
        if (this.oET == null) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "viewwv is null, maybe has destroyed");
            return;
        }
        kr(z);
        ks(z);
        boolean booleanExtra = getIntent().getBooleanExtra("show_feedback", false);
        if (booleanExtra) {
            ks(booleanExtra);
        }
        int i = R.g.bhb;
        if (byn() != null) {
            i = R.k.dxG;
        }
        getIntent().getStringExtra("srcUsername");
        byo();
        if (!getIntent().getBooleanExtra("KRightBtn", false)) {
            a(0, i, new OnMenuItemClickListener(this) {
                final /* synthetic */ WebViewUI seQ;

                {
                    this.seQ = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.seQ.aAb();
                    return true;
                }
            });
        }
        iV(!z);
    }

    public void a(WebViewKeyboardLinearLayout webViewKeyboardLinearLayout, int i) {
        if (i == -3 && this.sdq != null) {
            boolean z = (this.iYG.bxR().sYY & 1) > 0;
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.GeneralControlWrapper", "needShowInputAlertTips, ret = " + z);
            if (z && this.sdq.getVisibility() != 0 && !this.scY.isShown()) {
                if (this.sdr == null) {
                    this.sdr = new aj(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
                        final /* synthetic */ WebViewUI seQ;

                        {
                            this.seQ = r1;
                        }

                        public final boolean oQ() {
                            this.seQ.byp();
                            return false;
                        }
                    }, false);
                }
                this.sdr.v(4000, 4000);
                View view = this.sdq;
                ((ImageView) view.findViewById(R.h.cbv)).setImageResource(R.k.dyc);
                TextView textView = (TextView) view.findViewById(R.h.cbw);
                textView.setTextSize(14.0f);
                textView.setText(R.l.fnp);
                ((ImageButton) view.findViewById(R.h.cbu)).setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ WebViewUI seQ;

                    {
                        this.seQ = r1;
                    }

                    public final void onClick(View view) {
                        this.seQ.byp();
                    }
                });
                this.sdq.setVisibility(0);
                com.tencent.mm.plugin.report.service.g.oUh.A(13125, bym());
            }
        }
    }

    private void byp() {
        if (this.sdq != null) {
            this.sdq.setVisibility(8);
        }
        if (this.sdr != null) {
            this.sdr.KH();
        }
    }

    public final void aAh() {
        this.rVm.az(GameJsApiSendAppMessage.NAME, true);
        this.rVm.bzo();
    }

    private void JP(String str) {
        this.rVm.az(GameJsApiSendAppMessage.NAME, false);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.rVm;
        if (dVar.sjS) {
            Map hashMap = new HashMap();
            hashMap.put("scene", "enterprise");
            dVar.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:share:appmessage", hashMap, dVar.sjU, dVar.sjV) + ")", null);
            try {
                dVar.iYF.D("connector_local_send", str, dVar.rZN);
                dVar.iYF.D("scene", "enterprise", dVar.rZN);
                return;
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                return;
            }
        }
        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.JsApiHandler", "onSendToEnterprise fail, not ready");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void byq() {
        /*
        r14 = this;
        r13 = 3;
        r12 = 2;
        r11 = 4;
        r10 = 1;
        r9 = 0;
        r0 = r14.getIntent();
        r1 = "geta8key_username";
        r0 = r0.getStringExtra(r1);
        r1 = r14.getIntent();
        r2 = "k_username";
        r1.putExtra(r2, r0);
        r0 = r14.getIntent();
        r1 = "k_expose_url";
        r2 = r14.oET;
        r2 = r2.getUrl();
        r0.putExtra(r1, r2);
        r0 = r14.getIntent();
        r1 = "showShare";
        r0.putExtra(r1, r9);
        r0 = r14.oET;
        r2 = r0.getUrl();
        r0 = 0;
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r1 != 0) goto L_0x0049;
    L_0x0041:
        r0 = android.net.Uri.parse(r2);
        r0 = r0.getHost();
    L_0x0049:
        r1 = 0;
        r3 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r3 != 0) goto L_0x0148;
    L_0x0050:
        r3 = "mp.weixin.qq.com";
        r0 = r0.startsWith(r3);
        if (r0 == 0) goto L_0x0148;
    L_0x0059:
        r0 = "https://mp.weixin.qq.com/mp/infringement?url=%s#wechat_redirect";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ UnsupportedEncodingException -> 0x013a }
        r4 = 0;
        r5 = r14.oET;	 Catch:{ UnsupportedEncodingException -> 0x013a }
        r5 = r5.getUrl();	 Catch:{ UnsupportedEncodingException -> 0x013a }
        r6 = "utf-8";
        r5 = com.tencent.mm.compatible.util.p.encode(r5, r6);	 Catch:{ UnsupportedEncodingException -> 0x013a }
        r3[r4] = r5;	 Catch:{ UnsupportedEncodingException -> 0x013a }
        r0 = java.lang.String.format(r0, r3);	 Catch:{ UnsupportedEncodingException -> 0x013a }
    L_0x0073:
        if (r0 == 0) goto L_0x0156;
    L_0x0075:
        r1 = r14.oET;
        r1 = r1.getUrl();
        r3 = r14.JR(r1);
        r1 = r14.iYG;
        r1 = r1.bxR();
        r1 = r1.bHj();
        r2 = "MicroMsg.WebViewUI";
        r4 = "doExpose enableReportPageEvent %s";
        r5 = new java.lang.Object[r10];
        r6 = java.lang.Boolean.valueOf(r1);
        r5[r9] = r6;
        com.tencent.mm.sdk.platformtools.w.d(r2, r4, r5);
        r2 = android.text.TextUtils.isEmpty(r3);
        if (r2 != 0) goto L_0x011d;
    L_0x00a0:
        if (r1 == 0) goto L_0x011d;
    L_0x00a2:
        r1 = r14.oET;
        r1 = r1.getUrl();
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x011d;
    L_0x00ae:
        r4 = com.tencent.mm.sdk.platformtools.bg.Ny();
        r1 = "MicroMsg.WebViewUI";
        r2 = "report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d";
        r6 = 7;
        r6 = new java.lang.Object[r6];
        r7 = 13377; // 0x3441 float:1.8745E-41 double:6.609E-320;
        r7 = java.lang.Integer.valueOf(r7);
        r6[r9] = r7;
        r7 = java.lang.Long.valueOf(r4);
        r6[r10] = r7;
        r6[r12] = r3;
        r7 = r14.oET;
        r7 = r7.getUrl();
        r6[r13] = r7;
        r7 = r14.fFF;
        r6[r11] = r7;
        r7 = 5;
        r8 = java.lang.Integer.valueOf(r11);
        r6[r7] = r8;
        r7 = 6;
        r8 = java.lang.Integer.valueOf(r10);
        r6[r7] = r8;
        com.tencent.mm.sdk.platformtools.w.d(r1, r2, r6);
        r1 = "";
        r2 = r14.oET;	 Catch:{ UnsupportedEncodingException -> 0x0159 }
        r2 = r2.getUrl();	 Catch:{ UnsupportedEncodingException -> 0x0159 }
        r6 = "UTF-8";
        r1 = com.tencent.mm.compatible.util.p.encode(r2, r6);	 Catch:{ UnsupportedEncodingException -> 0x0159 }
    L_0x00f8:
        r2 = com.tencent.mm.plugin.report.service.g.oUh;
        r6 = 13377; // 0x3441 float:1.8745E-41 double:6.609E-320;
        r7 = 6;
        r7 = new java.lang.Object[r7];
        r4 = java.lang.Long.valueOf(r4);
        r7[r9] = r4;
        r7[r10] = r3;
        r7[r12] = r1;
        r1 = r14.fFF;
        r7[r13] = r1;
        r1 = java.lang.Integer.valueOf(r11);
        r7[r11] = r1;
        r1 = 5;
        r3 = java.lang.Integer.valueOf(r10);
        r7[r1] = r3;
        r2.i(r6, r7);
    L_0x011d:
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r1 == 0) goto L_0x0134;
    L_0x0123:
        r0 = "https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect";
        r1 = new java.lang.Object[r10];
        r2 = 34;
        r2 = java.lang.Integer.valueOf(r2);
        r1[r9] = r2;
        r0 = java.lang.String.format(r0, r1);
    L_0x0134:
        r1 = r14.oET;
        r1.loadUrl(r0);
        return;
    L_0x013a:
        r0 = move-exception;
        r3 = "MicroMsg.WebViewUI";
        r0 = r0.getMessage();
        com.tencent.mm.sdk.platformtools.w.e(r3, r0);
        r0 = r2;
        goto L_0x0073;
    L_0x0148:
        r0 = r14.getIntent();
        r2 = "k_expose_current_url";
        r3 = r14.azN();
        r0.putExtra(r2, r3);
    L_0x0156:
        r0 = r1;
        goto L_0x0075;
    L_0x0159:
        r2 = move-exception;
        r6 = "MicroMsg.WebViewUI";
        r7 = "";
        r8 = new java.lang.Object[r9];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r6, r2, r7, r8);
        goto L_0x00f8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.WebViewUI.byq():void");
    }

    private void wr(int i) {
        CharSequence JR = JR(this.seI);
        if (TextUtils.isEmpty(this.seI) || TextUtils.isEmpty(JR)) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "stev appId is null or empty");
            return;
        }
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "stev appId %s", new Object[]{JR});
        long Ny = bg.Ny();
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "stev report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13377), Long.valueOf(Ny), JR, this.seI, this.fFF, Integer.valueOf(3), Integer.valueOf(i)});
        String str = "";
        try {
            str = com.tencent.mm.compatible.util.p.encode(this.seI, "UTF-8");
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.WebViewUI", e, "", new Object[0]);
        }
        com.tencent.mm.plugin.report.service.g.oUh.i(13377, new Object[]{Long.valueOf(Ny), JR, str, this.fFF, Integer.valueOf(3), Integer.valueOf(i)});
    }

    public final void aAo() {
        Bundle bundle = new Bundle();
        bundle.putLong("msg_id", getIntent().getLongExtra("msg_id", Long.MIN_VALUE));
        bundle.putString("sns_local_id", getIntent().getStringExtra("sns_local_id"));
        bundle.putInt("news_svr_id", getIntent().getIntExtra("news_svr_id", 0));
        bundle.putString("news_svr_tweetid", getIntent().getStringExtra("news_svr_tweetid"));
        bundle.putInt("message_index", getIntent().getIntExtra("message_index", 0));
        bundle.putString("rawUrl", this.fWY);
        if (!bg.mA(this.fWY) && this.fWY.endsWith("#rd")) {
            String substring = this.fWY.substring(0, this.fWY.length() - 3);
            if (!(bg.mA(this.seI) || this.seI.startsWith(substring))) {
                bundle.putString("rawUrl", this.seI);
                bundle.putLong("msg_id", Long.MIN_VALUE);
            }
        } else if (!(bg.mA(this.seI) || this.seI.startsWith(this.fWY))) {
            bundle.putString("rawUrl", this.seI);
            bundle.putLong("msg_id", Long.MIN_VALUE);
        }
        Intent intent = getIntent();
        if (intent != null) {
            bundle.putString("preChatName", intent.getStringExtra("preChatName"));
            bundle.putInt("preMsgIndex", intent.getIntExtra("preMsgIndex", 0));
            bundle.putString("prePublishId", intent.getStringExtra("prePublishId"));
            bundle.putString("preUsername", intent.getStringExtra("preUsername"));
        }
        try {
            com.tencent.mm.plugin.webview.stub.b P = this.iYF.P(bundle);
            if (P.bxg()) {
                this.rVm.az(GameJsApiSendAppMessage.NAME, false);
                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.rVm;
                if (dVar.sjS) {
                    Map hashMap = new HashMap();
                    hashMap.put("scene", "favorite");
                    dVar.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:share:appmessage", hashMap, dVar.sjU, dVar.sjV) + ")", null);
                    try {
                        dVar.iYF.D("scene", "favorite", dVar.rZN);
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                    }
                } else {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.JsApiHandler", "onFavorite fail, not ready");
                }
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "on favorite simple url");
                return;
            }
            com.tencent.mm.pluginsdk.model.c.a(P.getRet(), 35, this, this.mnV);
            if (P.getRet() == 0) {
                wr(1);
            } else {
                wr(2);
            }
        } catch (Exception e2) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "edw, favoriteUrl fail, ex = " + e2.getMessage());
        }
    }

    private void iT(boolean z) {
        if (findViewById(R.h.cSi) != null) {
            if ((findViewById(R.h.cSi).getVisibility() == 0) != z) {
                findViewById(R.h.cSi).startAnimation(AnimationUtils.loadAnimation(this.uSU.uTo, z ? R.a.aQJ : R.a.aQK));
            }
            if (z) {
                findViewById(R.h.cSi).setVisibility(0);
                this.scO = (ImageButton) findViewById(R.h.cSg);
                ImageButton imageButton = this.scO;
                boolean z2 = this.oET != null && this.oET.canGoBack();
                imageButton.setEnabled(z2);
                this.scO.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ WebViewUI seQ;

                    {
                        this.seQ = r1;
                    }

                    public final void onClick(View view) {
                        if (this.seQ.oET != null) {
                            this.seQ.oET.goBack();
                            this.seQ.sdo = null;
                        }
                    }
                });
                this.scP = (ImageButton) findViewById(R.h.cSj);
                this.scP.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ WebViewUI seQ;

                    {
                        this.seQ = r1;
                    }

                    public final void onClick(View view) {
                        if (this.seQ.oET != null) {
                            this.seQ.oET.reload();
                        }
                    }
                });
                return;
            }
            findViewById(R.h.cSi).setVisibility(8);
        }
    }

    private void iU(boolean z) {
        if (this.scP != null) {
            this.scP.setEnabled(z);
        }
    }

    protected final void A(boolean z, boolean z2) {
        if (!byy()) {
            kr(z);
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "[cpan] set title enable:%b", new Object[]{Boolean.valueOf(z)});
            setProgressBarIndeterminateVisibility(false);
            if (z2) {
                this.scM.finish();
            } else if (!this.sdY && !this.sea) {
                this.scM.start();
            }
        }
    }

    public void JQ(String str) {
        if (this.iYG.bxR().bHh()) {
            Bundle bundle = new Bundle();
            bundle.putInt("fromScene", 100);
            if (this.iYF.a(str, this.iYG.bxQ().nw(7), bundle)) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "shouldOverride, built in url handled, url = " + str);
                return;
            }
            return;
        }
        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "shouldOverride, allow inner open url, not allow");
    }

    public boolean xM(String str) {
        for (com.tencent.mm.plugin.webview.ui.tools.jsapi.b bVar : this.mot) {
            if (a(bVar, str)) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "url handled, url = " + str);
                if (this.seF.equals(str)) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "url " + str + " has been handle");
                    return true;
                }
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "url handled, ret = " + bVar.xM(str) + ", url = " + str);
                return true;
            }
        }
        return false;
    }

    public final String JR(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str) || this.iYF == null) {
            return str2;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("webview_binder_id", hashCode());
        bundle.putString("rawUrl", str);
        try {
            str2 = bg.mz(this.iYF.d(76, bundle).getString("appId"));
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "stev cachedAppId %s", new Object[]{str2});
            return str2;
        } catch (RemoteException e) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "get cachedAppId error ", new Object[]{e.getMessage()});
            return str2;
        }
    }

    public final void e(String str, long j, int i) {
        String encode;
        Throwable e;
        CharSequence JR = JR(this.seI);
        if (this.fromScene != 0) {
            this.seH = " ";
        }
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "webpageVisitInfoReport enableReportPageEvent %s", new Object[]{Boolean.valueOf(this.iYG.bxR().bHj())});
        if (this.jgr > 0 && this.seJ > this.jgr && j > this.seJ && !TextUtils.isEmpty(JR) && r4) {
            long j2 = this.seJ - this.jgr;
            long j3 = j - this.seJ;
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "report(%s), clickTimestamp : %d, appID : %s, usedTime : %s, stayTime : %s, networkType : %s, userAgent : %s, url : %s, sessionID : %s, targetAction : %s, targetUrl : %s,scene : %s, refererUrl : %s", new Object[]{Integer.valueOf(13376), Long.valueOf(this.jgr), JR, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(this.networkType), this.sdc, this.seI, this.fFF, Integer.valueOf(i), str, Integer.valueOf(this.fromScene), this.seH});
            String str2 = "";
            String str3 = "";
            String str4 = "";
            String str5 = "";
            try {
                str2 = com.tencent.mm.compatible.util.p.encode(bg.mz(this.sdc), "UTF-8");
                str3 = com.tencent.mm.compatible.util.p.encode(bg.mz(this.seI), "UTF-8");
                encode = com.tencent.mm.compatible.util.p.encode(bg.mz(str), "UTF-8");
                try {
                    str5 = com.tencent.mm.compatible.util.p.encode(bg.mz(this.seH), "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    e = e2;
                    com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.WebViewUI", e, "", new Object[0]);
                    com.tencent.mm.plugin.report.service.g.oUh.i(13376, new Object[]{Long.valueOf(this.jgr), JR, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(this.networkType), str2, str3, this.fFF, Integer.valueOf(i), encode, Integer.valueOf(this.fromScene), str5});
                    this.fromScene = 0;
                    if (i != 1) {
                        this.seH = this.seI;
                        this.seI = str;
                        this.jgr = j;
                    }
                }
            } catch (Throwable e3) {
                Throwable th = e3;
                encode = str4;
                e = th;
                com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.WebViewUI", e, "", new Object[0]);
                com.tencent.mm.plugin.report.service.g.oUh.i(13376, new Object[]{Long.valueOf(this.jgr), JR, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(this.networkType), str2, str3, this.fFF, Integer.valueOf(i), encode, Integer.valueOf(this.fromScene), str5});
                this.fromScene = 0;
                if (i != 1) {
                    this.seH = this.seI;
                    this.seI = str;
                    this.jgr = j;
                }
            }
            com.tencent.mm.plugin.report.service.g.oUh.i(13376, new Object[]{Long.valueOf(this.jgr), JR, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(this.networkType), str2, str3, this.fFF, Integer.valueOf(i), encode, Integer.valueOf(this.fromScene), str5});
            this.fromScene = 0;
        }
        if (i != 1) {
            this.seH = this.seI;
            this.seI = str;
            this.jgr = j;
        }
    }

    public final x j(String str, boolean z, int i) {
        if (this.sel || this.sem || isFinishing()) {
            return x.FAILED;
        }
        if (this.sdU != null) {
            this.sdU.setVisibility(8);
        }
        if (this.iYG == null) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "startGetA8Key fail, after onDestroy");
            return x.FAILED;
        } else if (this.sdf) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "edw startGetA8Key, nevergeta8key");
            this.iYG.a(str, null, null);
            return x.NO_NEED;
        } else {
            boolean z2 = this.iYF != null && this.sdZ.contains(str) && JO(str);
            if ((this.iYG.has(str) || z2) && !z) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "edw startGetA8Key no need, wvPerm already has value, url = " + str);
                return x.NO_NEED;
            }
            int xB;
            String stringExtra = getIntent().getStringExtra("geta8key_username");
            int JS = JS(stringExtra);
            if (i == -1) {
                xB = this.sdz.xB(str);
            } else {
                xB = i;
            }
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "edw startGetA8Key, url = " + str + ", scene = " + JS + ", username = " + stringExtra + ", reason = " + xB + ", force = " + z);
            if (i != 5) {
                A(false, false);
            }
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "edw startGetA8Key, begin, set a default permission");
            this.sdZ.add(str);
            this.iYG.a(str, null, null);
            this.seb = true;
            this.sdA.byH();
            Bundle bundle = new Bundle();
            bundle.putString("geta8key_data_req_url", str);
            bundle.putString("geta8key_data_username", stringExtra);
            bundle.putInt("geta8key_data_scene", JS);
            bundle.putInt("geta8key_data_reason", xB);
            if (this.oET.getX5WebViewExtension() != null) {
                bundle.putInt("geta8key_data_flag", 1);
            } else {
                bundle.putInt("geta8key_data_flag", 0);
            }
            bundle.putString("geta8key_data_net_type", ai.bwv());
            bundle.putInt("geta8key_session_id", this.sdn);
            if (!bg.mA(getIntent().getStringExtra("k_share_url"))) {
                bundle.putString("k_share_url", getIntent().getStringExtra("k_share_url"));
                getIntent().putExtra("k_share_url", "");
            }
            this.sdo = str;
            try {
                z2 = this.iYF.q(233, bundle);
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "startGetA8Key, ex = " + e.getMessage());
                z2 = false;
            }
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "startGetA8Key, doScene ret = " + z2);
            com.tencent.mm.plugin.webview.model.ai.j bwx = this.rWq.bwx();
            int i2 = this.gaA;
            stringExtra = this.fUX;
            bwx.gaA = i2;
            bwx.rXD = stringExtra;
            if (bg.mA(str)) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.startGetA8Key failed, url is null");
            } else if (!bwx.rXP.containsKey(str)) {
                bwx.rXP.put(str, Long.valueOf(bg.Nz()));
            }
            com.tencent.mm.plugin.report.service.g.oUh.a(154, 11, 1, false);
            return x.WILL_GET;
        }
    }

    private int JS(String str) {
        int intExtra = getIntent().getIntExtra("geta8key_scene", 0);
        if (intExtra == 0) {
            if (str == null || str.length() <= 0) {
                intExtra = 0;
            } else if (this.iYF == null) {
                intExtra = 1;
            } else {
                try {
                    intExtra = this.iYF.fE(str) ? 8 : this.iYF.eV(str) ? 7 : 1;
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "getScene fail, ex = " + e.getMessage());
                    intExtra = 1;
                }
            }
        }
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "KGetA8KeyScene = %s", new Object[]{Integer.valueOf(intExtra)});
        return intExtra;
    }

    private boolean JT(String str) {
        if (bg.mA(str)) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "search contact err: null or nill url");
            return false;
        }
        wo(MMGIFException.D_GIF_ERR_NO_COLOR_MAP);
        Bundle bundle = new Bundle();
        bundle.putString("search_contact_data_url", str);
        try {
            this.iYF.q((int) MMGIFException.D_GIF_ERR_NO_COLOR_MAP, bundle);
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "startSearchContact, ex = " + e.getMessage());
        }
        return true;
    }

    private boolean xF(String str) {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "dealCustomScheme, url = " + str);
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            if (this.iYF.bu(str)) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "dealCustomScheme, url is handled by QrCodeURLHelper, url = " + str);
                this.iYF.ca(str, hashCode());
                return true;
            }
        } catch (Exception e) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "dealCustomScheme, tryHandleEvents, ex = " + e.getMessage());
        }
        final Uri parse = Uri.parse(str);
        if (!(parse == null || str.startsWith("weixin://") || str.startsWith("http"))) {
            String replace;
            if (str.startsWith(WebView.SCHEME_TEL)) {
                replace = str.replace(WebView.SCHEME_TEL, "");
                if (!bg.mA(replace)) {
                    try {
                        this.iYF.cc(replace, hashCode());
                    } catch (Exception e2) {
                        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "showPhoneSpanDialog, ex = %s", new Object[]{e2.getMessage()});
                    }
                }
                return true;
            } else if (str.startsWith("sms:") || str.startsWith("smsto:")) {
                r0 = new Intent("android.intent.action.SENDTO", parse);
                r0.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                try {
                    startActivity(r0);
                } catch (Exception e22) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "start sms app failed:[%s]", new Object[]{e22.getMessage()});
                }
                return true;
            } else {
                try {
                    if (!(this.iYG.bxR().bHg() || this.iYF == null || !this.iYF.azg())) {
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "dealCustomScheme, not allow outer open url");
                        return true;
                    }
                } catch (Throwable e3) {
                    com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.WebViewUI", e3, "", new Object[0]);
                }
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "scheme launch interval ; %d", new Object[]{Long.valueOf(bg.Ny() - this.seJ)});
                if (bg.Ny() - this.seJ <= 2) {
                    replace = azN();
                    try {
                        replace = com.tencent.mm.compatible.util.p.encode(replace, "UTF-8");
                        str = com.tencent.mm.compatible.util.p.encode(str, "UTF-8");
                    } catch (Exception e4) {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "formate url failed");
                    }
                    com.tencent.mm.plugin.report.service.g.oUh.i(13983, new Object[]{Integer.valueOf(4), replace, str});
                }
                if (getIntent().getBooleanExtra("show_openapp_dialog", true)) {
                    return com.tencent.mm.bk.a.post(new Runnable(this) {
                        final /* synthetic */ WebViewUI seQ;

                        public final void run() {
                            com.tencent.mm.pluginsdk.model.app.g.d(this.seQ, parse);
                        }
                    });
                }
                r0 = new Intent("android.intent.action.VIEW", parse);
                r0.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                if (bg.j(this, r0)) {
                    startActivity(r0);
                    return true;
                }
            }
        }
        return false;
    }

    private void a(String str, String str2, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        if (!bg.mA(str2)) {
            this.iYG.a(str2, jsapiPermissionWrapper, generalControlWrapper);
            this.sdZ.remove(str2);
            this.seb = false;
            this.lUe = str2;
        }
        if (dU(str, str2)) {
            this.iYG.a(str, jsapiPermissionWrapper, generalControlWrapper);
            this.sdZ.remove(str);
        } else if (this.iYF != null && !bg.mA(str) && JO(str)) {
            this.iYG.a(str, jsapiPermissionWrapper, generalControlWrapper);
            this.sdZ.remove(str);
        }
    }

    public void byr() {
    }

    protected void b(com.tencent.mm.plugin.webview.stub.c cVar) {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "onSceneEnd, instance hashcode = " + hashCode());
        if (this.oET == null) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "onSceneEnd, viewWV is null, do nothing");
        } else if (isFinishing() || this.iYG == null) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "onSceneEnd, isFinishing, do nothing");
        } else {
            Bundle data;
            int i;
            Bundle bundle;
            int i2 = 0;
            int i3 = -1;
            int i4 = -1;
            String str = null;
            try {
                i2 = cVar.getType();
                i3 = cVar.bxh();
                i4 = cVar.bxi();
                str = cVar.Cp();
                data = cVar.getData();
                i = i2;
                i2 = i3;
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "onSceneEnd, ex = " + e.getMessage());
                data = null;
                i = i2;
                i2 = i3;
            }
            if (data == null) {
                bundle = new Bundle();
            } else {
                bundle = data;
            }
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "get hash code = %d, self hash code = %d", new Object[]{Integer.valueOf(bundle.getInt("scene_end_listener_hash_code")), Integer.valueOf(hashCode())});
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "edw onSceneEnd, type = " + i + ", errCode = " + i4 + ", errType = " + i2);
            if (bundle.getInt("scene_end_listener_hash_code") != hashCode()) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "hash code not equal");
            } else if (i == 233 || i == 131 || i == MMGIFException.D_GIF_ERR_NO_COLOR_MAP || i == 673 || i == 666 || i == 1254 || i == 1373) {
                String str2;
                boolean z;
                switch (i) {
                    case MMGIFException.D_GIF_ERR_NO_COLOR_MAP /*106*/:
                        finish();
                        return;
                    case 233:
                        this.sdA.byI();
                        byr();
                        JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper(bundle.getByteArray("geta8key_result_jsapi_perm_control_bytes"));
                        GeneralControlWrapper generalControlWrapper = new GeneralControlWrapper(bundle.getInt("geta8key_result_general_ctrl_b1"));
                        this.mou = bundle.getLong("geta8key_result_deep_link_bit_set", 0);
                        int i5 = bundle.getInt("geta8key_result_reason");
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "edw geta8key onSceneEnd, req reason = " + i5);
                        str2 = null;
                        switch (i5) {
                            case 0:
                            case 2:
                            case 8:
                            case 9:
                                if ((i2 != 0 || i4 != 0) && (i2 != 4 || i4 != -2005)) {
                                    g.scG.wn(i2);
                                    str = bundle.getString("geta8key_result_req_url");
                                    if (!(this.sdU == null || JO(str))) {
                                        this.sdU.setVisibility(0);
                                        A(true, true);
                                    }
                                    this.rWq.bwC().rXw = false;
                                    this.rWq.bwx().ax(str, false);
                                    com.tencent.mm.plugin.report.service.g.oUh.a(154, 12, 1, false);
                                    i2 = a.wg(i5);
                                    if (-1 != i2) {
                                        com.tencent.mm.plugin.report.service.g.oUh.a(154, (long) i2, 1, false);
                                    }
                                    if (this.sdk) {
                                        finish();
                                        break;
                                    }
                                }
                                str2 = bundle.getString("geta8key_result_full_url");
                                a(bundle.getString("geta8key_result_req_url"), str2, jsapiPermissionWrapper, generalControlWrapper);
                                S(bundle);
                                this.sdD = jsapiPermissionWrapper.nw(24);
                                this.rWq.bwC().rXw = true;
                                break;
                                break;
                            case 1:
                            case 5:
                                if (i2 != 0 || i4 != 0) {
                                    if (i2 != 4 || i4 != -2005) {
                                        com.tencent.mm.plugin.report.service.g.oUh.a(154, 12, 1, false);
                                        com.tencent.mm.plugin.report.service.g.oUh.a(154, (long) a.wg(i5), 1, false);
                                        A(true, true);
                                        break;
                                    }
                                    this.oET.stopLoading();
                                    str2 = bundle.getString("geta8key_result_full_url");
                                    a(bundle.getString("geta8key_result_req_url"), str2, jsapiPermissionWrapper, generalControlWrapper);
                                    S(bundle);
                                    break;
                                }
                                str2 = bundle.getString("geta8key_result_req_url");
                                this.iYG.a(str2, jsapiPermissionWrapper, generalControlWrapper);
                                this.sdZ.remove(str2);
                                if (this.seh) {
                                    A(true, true);
                                    this.seh = false;
                                }
                                if (i5 != 5) {
                                    this.sdD = jsapiPermissionWrapper.nw(24);
                                    break;
                                }
                                break;
                        }
                        B(this.iYG.JN(str2).nw(34), this.iYG.JN(str2).nw(75));
                        return;
                    case 666:
                        r rVar = this.sdC;
                        rVar.sfV--;
                        if (rVar.sfV <= 0) {
                            rVar.seQ.wp(666);
                        }
                        finish();
                        return;
                    case 673:
                        p pVar = this.sdB;
                        pVar.sfU--;
                        if (pVar.sfU <= 0) {
                            pVar.seQ.wp(673);
                        }
                        if (i2 == 0 && i4 == 0) {
                            str2 = bundle != null ? bundle.getString("reading_mode_result_url") : null;
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "[cpan] onsceneend url:%s", new Object[]{str2});
                            if (bg.mA(str2)) {
                                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "[cpan] onsceneend failed");
                                return;
                            } else {
                                this.oET.loadUrl(str2);
                                return;
                            }
                        }
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "[cpan] onsceneend failed");
                        return;
                    case 1254:
                        z = i2 == 0 && i4 == 0;
                        com.tencent.mm.plugin.webview.stub.d dVar = this.iYF;
                        com.tencent.mm.plugin.webview.model.y.c cVar2 = this.seL;
                        com.tencent.mm.plugin.webview.model.y.a aVar = this.seM;
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd suc: %b", new Object[]{Boolean.valueOf(z)});
                        cVar2.amV();
                        aVar.remove(1254);
                        if (!z) {
                            com.tencent.mm.ui.base.g.a(this, str, com.tencent.mm.sdk.platformtools.ab.getContext().getString(R.l.fmU), new com.tencent.mm.plugin.webview.model.y.b.AnonymousClass2(cVar2));
                            return;
                        } else if (bundle == null) {
                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd_Tools resp null");
                            return;
                        } else {
                            z = bundle.getBoolean("is_recent_has_auth");
                            boolean z2 = bundle.getBoolean("is_silence_auth");
                            if (z || z2) {
                                String string = bundle.getString("redirect_url");
                                if (bg.mA(string)) {
                                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd redirect null");
                                    return;
                                }
                                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd isRecentHasAuth:%b isSilenceAuth:%b redirectUrl:%s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), string});
                                cVar2.IM(string);
                                return;
                            }
                            com.tencent.mm.plugin.webview.ui.tools.widget.e.a anonymousClass3 = new com.tencent.mm.plugin.webview.model.y.b.AnonymousClass3(bundle, cVar2, dVar, aVar);
                            if ((this instanceof WebViewUI) && isFinishing()) {
                                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.OauthAuthorizeLogic", "showWebAuthorizeDialog isFinishing");
                                return;
                            } else {
                                new com.tencent.mm.plugin.webview.ui.tools.widget.e(this).a(com.tencent.mm.plugin.webview.model.y.W((ArrayList) bundle.getSerializable("scope_list")), bundle.getString("appname"), bundle.getString("appicon_url"), getString(R.l.fnc), anonymousClass3);
                                return;
                            }
                        }
                    case 1373:
                        z = i2 == 0 && i4 == 0;
                        com.tencent.mm.plugin.webview.model.y.c cVar3 = this.seL;
                        com.tencent.mm.plugin.webview.model.y.a aVar2 = this.seM;
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd suc: %b", new Object[]{Boolean.valueOf(z)});
                        aVar2.remove(1373);
                        if (!z) {
                            com.tencent.mm.ui.base.g.a(this, str, com.tencent.mm.sdk.platformtools.ab.getContext().getString(R.l.fmU), new com.tencent.mm.plugin.webview.model.y.b.AnonymousClass4(cVar3));
                            return;
                        } else if (bundle == null) {
                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd resp null");
                            return;
                        } else {
                            str2 = bundle.getString("redirect_url");
                            if (bg.mA(str2)) {
                                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirect null");
                                return;
                            }
                            cVar3.IM(str2);
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirectUrl: %s", new Object[]{str2});
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    private void B(boolean z, boolean z2) {
        if (z) {
            zj(R.l.fmW);
            if (!this.sdi) {
                int i;
                if (com.tencent.mm.sdk.platformtools.ab.bIY().getInt("enter_web_pay_over_time", 2) <= 0) {
                    i = 0;
                } else {
                    i = com.tencent.mm.sdk.platformtools.ab.bIZ().getInt("enter_web_pay_over_time", 2);
                    if (i > 0) {
                        Editor edit = com.tencent.mm.sdk.platformtools.ab.bIZ().edit();
                        edit.putInt("enter_web_pay_over_time", i - 1);
                        edit.commit();
                    }
                }
                switch (i) {
                    case 1:
                        ws(R.i.drx);
                        break;
                    case 2:
                        ws(R.i.dry);
                        break;
                }
                this.sdi = true;
            }
        } else if (z2) {
            zj(R.l.fne);
        } else {
            SE(null);
        }
    }

    private void ws(int i) {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "showUserEdPage");
        this.seN = new com.tencent.mm.ui.base.i(this, R.m.foN);
        LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) getSystemService("layout_inflater")).inflate(i, null);
        ImageView imageView;
        if (i == R.i.drx) {
            imageView = (ImageView) linearLayout.findViewById(R.h.bVS);
            ImageView imageView2 = (ImageView) linearLayout.findViewById(R.h.bKE);
            try {
                if (this.iYF.bxw()) {
                    imageView2.setImageResource(R.g.bip);
                } else {
                    imageView2.setImageResource(R.g.bij);
                }
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.WebViewUI", e, "", new Object[0]);
            }
            try {
                String Jp = this.iYF.Jp(this.iYF.aw(2, null));
                if (!bg.mA(Jp)) {
                    Bitmap a = com.tencent.mm.sdk.platformtools.d.a(d.JG(Jp), false, 1.0f);
                    if (!(a == null || a.isRecycled())) {
                        imageView.setImageBitmap(a);
                    }
                }
            } catch (RemoteException e2) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", e2.toString());
            }
        } else if (i == R.i.dry) {
            imageView = (ImageView) linearLayout.findViewById(R.h.cjV);
            try {
                if (this.iYF.bxw()) {
                    imageView.setImageResource(R.g.biq);
                } else {
                    imageView.setImageResource(R.g.bik);
                }
            } catch (Throwable e3) {
                com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.WebViewUI", e3, "", new Object[0]);
            }
        }
        linearLayout.setMinimumWidth(10000);
        TextView textView = (TextView) linearLayout.findViewById(R.h.ckg);
        this.seN.getWindow();
        this.seN.setCanceledOnTouchOutside(true);
        this.seN.setOnDismissListener(new OnDismissListener(this) {
            final /* synthetic */ WebViewUI seQ;

            {
                this.seQ = r1;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
            }
        });
        this.seN.setOnCancelListener(new OnCancelListener(this) {
            final /* synthetic */ WebViewUI seQ;

            {
                this.seQ = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        textView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WebViewUI seQ;

            {
                this.seQ = r1;
            }

            public final void onClick(View view) {
                this.seQ.seN.dismiss();
            }
        });
        this.seN.setContentView(linearLayout);
        this.seN.show();
    }

    private void k(String str, Map<String, String> map) {
        String ap = bg.ap(azN(), this.fWY);
        if (bg.mA(ap)) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "after getA8Key, currentURL is null or nil, wtf");
            this.oET.loadUrl(str);
        } else if (this.rVm == null) {
            if (map.size() > 0) {
                this.oET.loadUrl(str, map);
            } else {
                this.oET.loadUrl(str);
            }
        } else if (!bg.mz(str).contains("#wechat_redirect")) {
            if (!dU(ap, str)) {
                String Jf = com.tencent.mm.plugin.webview.modelcache.p.Jf(ap);
                String Jf2 = com.tencent.mm.plugin.webview.modelcache.p.Jf(str);
                Object obj = (bg.mA(Jf2) || bg.mA(Jf) || !Jf2.equals(Jf) || this.iYF == null || !JO(ap)) ? null : 1;
                if (obj == null) {
                    if (map.size() > 0) {
                        this.oET.loadUrl(str, map);
                        return;
                    } else {
                        this.oET.loadUrl(str);
                        return;
                    }
                }
            }
            this.sei.put(ap, str);
            this.sec.put(ap, map);
            this.rVm.l(str, map);
        } else if (map.size() > 0) {
            this.oET.loadUrl(str, map);
        } else {
            this.oET.loadUrl(str);
        }
    }

    private boolean dU(String str, String str2) {
        if (bg.mA(str) || bg.mA(str2)) {
            return false;
        }
        if (com.tencent.mm.plugin.webview.a.rUX.matcher(str).matches() && com.tencent.mm.plugin.webview.a.rUX.matcher(str2).matches()) {
            String replaceFirst = str.replaceFirst("http://", "").replaceFirst("https://", "");
            int indexOf = replaceFirst.indexOf(35);
            if (indexOf > 0) {
                replaceFirst = replaceFirst.substring(0, indexOf);
            }
            if (str2.replaceFirst("http://", "").replaceFirst("https://", "").startsWith(replaceFirst) && this.iYF != null && JO(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean S(Bundle bundle) {
        String str;
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.WebViewUI", "[cpan] process a8 key:%d", new Object[]{Long.valueOf(System.currentTimeMillis())});
        int i = bundle.getInt("geta8key_result_action_code");
        String string = bundle.getString("geta8key_result_title");
        String string2 = bundle.getString("geta8key_result_full_url");
        String string3 = bundle.getString("geta8key_result_content");
        String string4 = bundle.getString("geta8key_result_req_url");
        String[] stringArray = bundle.getStringArray("geta8key_result_http_header_key_list");
        String[] stringArray2 = bundle.getStringArray("geta8key_result_http_header_value_list");
        if (getIntent().getBooleanExtra("k_has_http_header", false) && (stringArray == null || stringArray.length == 0 || stringArray2 == null || stringArray2.length == 0)) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "use intent httpheader info");
            getIntent().putExtra("k_has_http_header", false);
            stringArray = getIntent().getStringArrayExtra("geta8key_result_http_header_key_list");
            stringArray2 = getIntent().getStringArrayExtra("geta8key_result_http_header_value_list");
            getIntent().putStringArrayListExtra("geta8key_result_http_header_key_list", null);
            getIntent().putStringArrayListExtra("geta8key_result_http_header_value_list", null);
        }
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "processGetA8Key, actionCode = %d, title = %s, fullUrl = %s, content = %s", new Object[]{Integer.valueOf(i), string, string2, string3});
        Map hashMap = new HashMap();
        if (stringArray != null && stringArray2 != null && stringArray.length > 0 && stringArray2.length > 0 && stringArray.length == stringArray2.length) {
            for (int i2 = 0; i2 < stringArray.length; i2++) {
                hashMap.put(stringArray[i2], stringArray2[i2]);
            }
        }
        this.sed = hashMap;
        if (bg.mA(string2)) {
            str = string4;
        } else {
            str = string2;
        }
        ai.z(this.oET.getX5WebViewExtension() != null, bg.mz(str).startsWith("https://"));
        this.rWq.bwx().ax(string4, true);
        com.tencent.mm.plugin.webview.model.ai.d bwz = this.rWq.bwz();
        int i3 = this.gaA;
        String str2 = this.fUX;
        bwz.gaA = i3;
        bwz.rXD = str2;
        if (bg.mA(string2)) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageStart failed, url is null");
        } else {
            bwz.mkT = string2;
            bwz.rXC = true;
            if (!bwz.rXA.containsKey(string2)) {
                bwz.rXA.put(string2, Long.valueOf(bg.Nz()));
            }
            if (!bwz.rXB.containsKey(string2)) {
                bwz.rXB.put(string2, Long.valueOf(bg.Nz()));
            }
        }
        switch (i) {
            case 1:
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "getA8key-text: " + string3);
                if (string3 == null || string3.length() == 0) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "getA8key-text fail, invalid content");
                    return false;
                }
                this.oET.getSettings().setJavaScriptEnabled(false);
                this.oET.loadData(string3, "text/html", ProtocolPackage.ServerEncoding);
                return true;
            case 2:
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "getA8key-webview: title = " + string + ", fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "getA8key-webview fail, invalid fullUrl");
                    return false;
                }
                if (string != null && string.length() > 0) {
                    qP(string);
                }
                if (JU(string2)) {
                    k(string2, hashMap);
                    return true;
                }
                com.tencent.mm.sdk.platformtools.w.f("MicroMsg.WebViewUI", "processGetA8Key qrcode, canLoadUrl fail, url = " + string2);
                azI();
                return true;
            case 3:
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "getA8key-app: " + string2);
                if (string2 != null && string2.length() != 0) {
                    return xF(string2);
                }
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "getA8key-app, fullUrl is null");
                return false;
            case 4:
                return JT(string2);
            case 6:
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "getA8key-special_webview: fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "getA8key-special_webview fail, invalid fullUrl");
                    return false;
                } else if (JU(string2)) {
                    this.oET.loadUrl(string2);
                    iS(false);
                    return true;
                } else {
                    com.tencent.mm.sdk.platformtools.w.f("MicroMsg.WebViewUI", "processGetA8Key special, canLoadUrl fail, url = " + string2);
                    azI();
                    return true;
                }
            case 7:
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "getA8key-webview_no_notice: title = " + string + ", fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "getA8key-webview_no_notice fail, invalid fullUrl");
                    return false;
                }
                if (string != null && string.length() > 0) {
                    qP(string);
                }
                if (JU(string2)) {
                    k(string2, hashMap);
                    return true;
                }
                com.tencent.mm.sdk.platformtools.w.f("MicroMsg.WebViewUI", "processGetA8Key qrcode no notice, canLoadUrl fail, url = " + string2);
                azI();
                return true;
            case 20:
                if (bg.mA(string2)) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "doJumpEmotionDetailUrlScene err: null or nill url");
                } else {
                    r rVar = this.sdC;
                    if (rVar.sfV == 0) {
                        rVar.seQ.wo(666);
                    }
                    rVar.sfV++;
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("emoji_store_jump_url", string2);
                    try {
                        this.iYF.q(666, bundle2);
                    } catch (Exception e) {
                        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "startSearchContact, ex = " + e.getMessage());
                    }
                }
                return true;
            default:
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "qrcode-getA8key-not_catch: action code = " + i);
                return false;
        }
    }

    public boolean bys() {
        return false;
    }

    public boolean byt() {
        return false;
    }

    private int byu() {
        float f = this.uSU.uTo.getSharedPreferences(com.tencent.mm.sdk.platformtools.ab.bIX(), 0).getFloat("current_text_size_scale_key", 1.0f);
        if (f == 0.875f) {
            return 1;
        }
        if (f == 1.125f) {
            return 3;
        }
        if (f == 1.25f || f == 1.375f || f == 1.625f) {
            return 4;
        }
        return 2;
    }

    private void wt(int i) {
        if (i <= 0 || i > 4) {
            i = 2;
        }
        if (this.rVm != null) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.rVm;
            if (dVar.sjS) {
                Map hashMap = new HashMap();
                hashMap.put("fontSize", String.valueOf(i));
                dVar.sjM.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:setfont", hashMap, dVar.sjU, dVar.sjV) + ")", null);
            } else {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.JsApiHandler", "onFontSizeChanged fail, not ready");
            }
        }
        FontChooserView fontChooserView = (FontChooserView) this.scQ.findViewById(R.h.bQS);
        if (fontChooserView != null) {
            fontChooserView.pnI = i - 1;
        }
    }

    private void wu(int i) {
        if (this.oET != null && this.oET.getSettings() != null) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "localSetFontSize, fontSize = " + i);
            switch (i) {
                case 1:
                    this.oET.getSettings().setTextSize(TextSize.SMALLER);
                    return;
                case 3:
                    this.oET.getSettings().setTextSize(TextSize.LARGER);
                    return;
                case 4:
                    this.oET.getSettings().setTextSize(TextSize.LARGEST);
                    return;
                default:
                    this.oET.getSettings().setTextSize(TextSize.NORMAL);
                    return;
            }
        }
    }

    private final boolean JU(String str) {
        if (com.tencent.mm.platformtools.r.iiT) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.WebViewUI", "skipLoadUrlCheck");
            return true;
        } else if (bg.mA(str)) {
            return true;
        } else {
            if (this.sda) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "albie: trust this url(%s)", new Object[]{str});
                return true;
            }
            String toLowerCase = str.toLowerCase();
            if (toLowerCase.startsWith("file://")) {
                for (String eq : rWS) {
                    if (com.tencent.mm.pluginsdk.ui.tools.s.eq(toLowerCase, eq)) {
                        return true;
                    }
                }
                return false;
            }
            Uri parse = Uri.parse(toLowerCase);
            if (bg.mA(parse.getHost())) {
                return true;
            }
            return !parse.getHost().contains(com.tencent.mm.pluginsdk.ui.tools.s.bGM());
        }
    }

    @TargetApi(11)
    private void byv() {
        if (com.tencent.mm.compatible.util.d.ep(11)) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "removeConfigJsInterface, api level too low");
        } else if (this.oET == null || this.iYF == null) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "viewwv is null or invoker is null");
        } else {
            int i;
            try {
                this.oET.removeJavascriptInterface("searchBoxJavaBridge_");
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "removeConfigJsInterface, ex = %s", new Object[]{e.getMessage()});
            }
            if (this.seO == null) {
                try {
                    if (this.iYF.azg()) {
                        this.seO = this.iYF.bxn();
                    }
                } catch (Exception e2) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "getRemoveJsInterfaceList, ex = %s", new Object[]{e2.getMessage()});
                }
            }
            String str = "MicroMsg.WebViewUI";
            String str2 = "removeConfigJsInterface, to remove list size = %d";
            Object[] objArr = new Object[1];
            if (this.seO == null) {
                i = 0;
            } else {
                i = this.seO.length;
            }
            objArr[0] = Integer.valueOf(i);
            com.tencent.mm.sdk.platformtools.w.i(str, str2, objArr);
            if (this.seO != null && this.seO.length != 0) {
                try {
                    for (String str3 : this.seO) {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "removeConfigJsInterface, js interface name = %s", new Object[]{str3});
                        this.oET.removeJavascriptInterface(str3);
                    }
                } catch (Exception e22) {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "removeConfigJsInterface, ex = %s", new Object[]{e22.getMessage()});
                }
            }
        }
    }

    public final void aAk() {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "doKeepPageTopLogic");
        getIntent().putExtra("is_from_keep_top", true);
        if (this.oET != null) {
            com.tencent.mm.ui.snackbar.a.e(this.uSU.uTo, getString(R.l.eHZ));
            if (getIntent().getIntExtra("keep_top_scene", 0) == 2) {
                dV(getIntent().getStringExtra("custom_keep_top_url"), getIntent().getStringExtra("custom_keep_top_title"));
            } else {
                dV(this.oET.getUrl(), String.valueOf(bPV()));
            }
        }
    }

    public final void aAl() {
        dV(null, null);
        com.tencent.mm.ui.snackbar.a.e(this.uSU.uTo, getString(R.l.eHU));
    }

    private void dV(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("key_last_page", str);
        bundle.putString("key_last_page_title", str2);
        bundle.putInt("key_keep_top_scene", getIntent().getIntExtra("keep_top_scene", 0));
        try {
            this.iYF.d(82, bundle);
        } catch (RemoteException e) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "keepLastPage exp=%s", new Object[]{e.getLocalizedMessage()});
        }
    }

    public final boolean LZ() {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "hasKeepLastPageTop KIsFromKeepTop=%b", new Object[]{Boolean.valueOf(com.tencent.mm.sdk.platformtools.s.a(getIntent(), "is_from_keep_top", false))});
        if (!com.tencent.mm.sdk.platformtools.s.a(getIntent(), "is_from_keep_top", false)) {
            return false;
        }
        try {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "hasKeepLastPageTop hasKeep=%b", new Object[]{Boolean.valueOf(this.iYF.d(89, new Bundle()).getBoolean("key_is_webview_keep_top", true))});
            return this.iYF.d(89, new Bundle()).getBoolean("key_is_webview_keep_top", true);
        } catch (RemoteException e) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "hasKeepLastPageTop exp=%s", new Object[]{e.getLocalizedMessage()});
            return true;
        }
    }

    public final boolean azQ() {
        if (this.sdR != null) {
            boolean z;
            d dVar = this.sdR;
            if (bg.mA(dVar.sfO)) {
                z = false;
            } else {
                z = dVar.sfO.equals("true");
            }
            if (!(!z || bg.mA(this.sdR.azs()) || bg.mA(this.sdR.azt()) || bg.mA(this.sdR.azu()))) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "use js api close window confirm info : %s, %s, %s", new Object[]{this.sdR.azs(), this.sdR.azt(), this.sdR.azu()});
                View inflate = View.inflate(this.uSU.uTo, R.i.dit, null);
                final CheckBox checkBox = (CheckBox) inflate.findViewById(R.h.cjX);
                checkBox.setChecked(false);
                checkBox.setVisibility(8);
                TextView textView = (TextView) inflate.findViewById(R.h.cjZ);
                textView.setText(r6);
                textView.setTextColor(getResources().getColor(R.e.aVo));
                textView = (TextView) inflate.findViewById(R.h.cjY);
                textView.setTextColor(getResources().getColor(R.e.aVo));
                textView.setVisibility(8);
                this.sdS = com.tencent.mm.ui.base.g.a(this.uSU.uTo, true, "", inflate, r4, r5, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ WebViewUI seQ;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (checkBox != null && checkBox.isChecked()) {
                            try {
                                if (this.seQ.iYF.azg()) {
                                    this.seQ.iYF.dx(327792, 1);
                                }
                            } catch (Exception e) {
                                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.WebViewUI", "tryShowCloseWindowConfirmInfo, ex = " + e.getMessage());
                            }
                        }
                        this.seQ.sel = true;
                        this.seQ.sdS = null;
                        g.scG.close();
                        this.seQ.finish();
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ WebViewUI seQ;

                    {
                        this.seQ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.seQ.sdS = null;
                    }
                });
                return true;
            }
        }
        return false;
    }

    private void byw() {
        if (this.oET != null) {
            if (getIntent().getIntExtra("keep_top_scene", 0) == 2) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "updateKeepTopPage: SCENE_CUSTOM_TOP_URL no update");
            } else if (LZ()) {
                dV(this.oET.getUrl(), String.valueOf(bPV()));
            }
        }
    }

    public void ga(boolean z) {
    }

    public void p(int i, Bundle bundle) {
    }

    public boolean byx() {
        return true;
    }

    public void r(int i, Bundle bundle) {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.WebViewUI", "handleEmojiStoreAction");
    }

    public void s(int i, Bundle bundle) {
    }

    public final void iV(boolean z) {
        String url = this.oET.getUrl();
        if (z) {
            af(0, false);
            this.sdP.put(url, Boolean.valueOf(true));
            return;
        }
        af(0, true);
        if (this.sdP.containsKey(url)) {
            this.sdP.remove(url);
        }
    }

    public boolean byy() {
        return false;
    }

    public final boolean byz() {
        if (this.seP == -3) {
            return false;
        }
        aHj();
        return true;
    }

    public final void aHf() {
        super.aHf();
        this.seP = -2;
    }

    public final void aHj() {
        super.aHj();
        if (this.seP == -3) {
            this.seP = -2;
        } else {
            this.seP = -3;
        }
    }
}
