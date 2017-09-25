package com.tencent.mm.plugin.webview.e;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.e.a.fp;
import com.tencent.mm.e.a.ka;
import com.tencent.mm.e.a.lz;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.bl;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public static int soE = -1;
    public long fQF;
    public String fQG = "WeNote_";
    private String fTh = null;
    private c oPp = null;
    public int rVf = 0;
    public JSONArray soA = null;
    public i soB = null;
    private HashMap<String, String> soC = new HashMap();
    public boolean soD = false;
    public boolean soF = false;
    public String soG = "WeNote_";
    public String soH = "";
    public boolean soI = false;
    public String soy = "";
    public String soz = "";

    public static boolean bAl() {
        g wH = h.wH(soE);
        w.i("MicroMsg.MsgHandler", "WNJSHandlerBecomeEditing");
        try {
            if (wH.rXh != null) {
                wH.rXh.m(43, null);
            }
        } catch (RemoteException e) {
            w.w("MicroMsg.MsgHandler", "WNJSHandlerBecomeEditing exception" + e.getMessage());
        }
        return false;
    }

    public static boolean aa(Map<String, Object> map) {
        com.tencent.mm.sdk.b.b kaVar = new ka();
        kaVar.fQo.fQq = map.get("localEditorId").toString();
        kaVar.fQo.type = 0;
        a.urY.m(kaVar);
        return false;
    }

    public final void Km(String str) {
        String Kn = Kn(str);
        if (!bg.mA(this.soz)) {
            if (bg.mA(this.soH)) {
                String[] split = Kn.split("#WNNoteNode#");
                String Kn2 = Kn(this.soz);
                if (split.length > Kn2.split("#WNNoteNode#").length) {
                    this.soH = Kn2;
                } else {
                    this.soH = Kn;
                }
            }
            if (Kn.equals(this.soH)) {
                Kn = "";
            } else if (bg.mA(Kn)) {
                Kn = "&nbsp;";
            }
        }
        Bundle bundle = new Bundle();
        bundle.putInt("operation_type", 5);
        bundle.putString("htmlStr", Kn);
        h.wH(soE).V(bundle);
    }

    private String Kn(String str) {
        if (bg.mA(str) || str.length() == 0) {
            return str;
        }
        String str2;
        CharSequence replaceAll;
        Matcher matcher = Pattern.compile("<object[^>]*>", 2).matcher(str);
        CharSequence charSequence = "";
        int i = 0;
        while (matcher.find()) {
            str2 = charSequence + str.substring(i, matcher.start());
            int indexOf = matcher.group().indexOf("\"WeNote_");
            charSequence = str2 + "#WNNoteNode#[ThisisNoteNodeObj]_" + matcher.group().substring(indexOf + 1, (matcher.group().substring(indexOf + 1).indexOf("\"") + indexOf) + 1) + "_#WNNoteNode#";
            i = matcher.end();
        }
        if (i < str.length()) {
            charSequence = charSequence + str.substring(i, str.length());
        }
        Matcher matcher2 = Pattern.compile("<div>", 2).matcher(Pattern.compile("<br[^>]*>", 2).matcher(Pattern.compile("<span>.</span>", 2).matcher(Pattern.compile("<img[^>]*>", 2).matcher(charSequence).replaceAll("#WNNoteNode#[ThisisNoteNodeObj]#WNNoteNode#")).replaceAll("")).replaceAll(""));
        if (bg.mA(this.soz)) {
            replaceAll = matcher2.replaceAll("");
        } else {
            replaceAll = matcher2.replaceAll("\n");
        }
        str2 = Pattern.compile("<[^>]*>", 2).matcher(Pattern.compile("</p>", 2).matcher(Pattern.compile("<p [^>]*>", 2).matcher(replaceAll).replaceAll("")).replaceAll("")).replaceAll("");
        if (bg.mA(this.soz)) {
            str2 = Pattern.compile("&nbsp;", 2).matcher(str2).replaceAll("");
        }
        if (bg.mA(this.soz)) {
            return str2.trim();
        }
        return str2;
    }

    public final void s(int i, Bundle bundle) {
        while (true) {
            String Ko;
            com.tencent.mm.sdk.b.b kaVar;
            com.tencent.mm.sdk.b.b kaVar2;
            g wH;
            switch (i) {
                case 51:
                    this.soC.clear();
                    bAm();
                    this.soI = false;
                    return;
                case 52:
                    if (bundle == null) {
                        w.e("MicroMsg.WNNoteWebViewLogic", "handleWNNoteAction,but data is null");
                        return;
                    }
                    Ko = Ko(bundle.getString("ExportData"));
                    if (bg.mA(Ko)) {
                        w.e("MicroMsg.WNNoteWebViewLogic", "exportJsonData is null or nil");
                        return;
                    }
                    boolean contains = Ko.contains("\"isSave\":true");
                    boolean contains2 = Ko.contains("\"isInsert\":true");
                    if (contains) {
                        bundle.putBoolean("isInsert", contains2);
                        contains = bundle.getBoolean("isInsert");
                        kaVar = new ka();
                        kaVar.fQo.type = 5;
                        kaVar.fQo.fQs = Ko;
                        kaVar.fQo.fQt = contains;
                        a.urY.m(kaVar);
                        return;
                    }
                    i = 69;
                case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                    Ko = bundle.getString("insertJsonString");
                    com.tencent.mm.sdk.b.b kaVar3 = new ka();
                    kaVar3.fQo.type = 4;
                    kaVar3.fQo.fQr = Ko;
                    a.urY.m(kaVar3);
                    return;
                case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
                    kaVar2 = new ka();
                    kaVar2.fQo.type = 6;
                    kaVar2.fQo.fQu = bundle;
                    kaVar2.fQo.context = ab.getContext();
                    a.urY.m(kaVar2);
                    return;
                case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
                    kaVar2 = new fp();
                    kaVar2.fKp.type = 26;
                    a.urY.m(kaVar2);
                    bundle.putString("path", kaVar2.fKq.path);
                    bundle.putBoolean("isPlay", kaVar2.fKq.fKD);
                    bundle.putBoolean("resumePlay", kaVar2.fKq.fKE);
                    bundle.putBoolean("isPause", kaVar2.fKq.fKF);
                    bundle.putDouble("getProgress", kaVar2.fKq.fKG);
                    wH = h.wH(soE);
                    w.i("MicroMsg.MsgHandler", "WNJSHandlerVoicePlayStatus");
                    try {
                        if (wH.rXh != null) {
                            wH.rXh.m(38, bundle);
                            return;
                        }
                        return;
                    } catch (RemoteException e) {
                        w.w("MicroMsg.MsgHandler", "WNJSHandlerVoicePlayStatus exception" + e.getMessage());
                        return;
                    }
                case FileUtils.S_IRWXG /*56*/:
                    kaVar2 = new fp();
                    kaVar2.fKp.type = 25;
                    a.urY.m(kaVar2);
                    return;
                case com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX /*57*/:
                    kaVar2 = new fp();
                    kaVar2.fKp.type = 23;
                    a.urY.m(kaVar2);
                    return;
                case m.CTRL_INDEX /*58*/:
                    kaVar2 = new fp();
                    kaVar2.fKp.type = 24;
                    kaVar2.fKp.path = bundle.getString("path");
                    kaVar2.fKp.fKw = bundle.getInt("voicetype");
                    kaVar2.fKp.fKx = bundle.getInt("position");
                    a.urY.m(kaVar2);
                    bundle.putBoolean("result", kaVar2.fKq.fKD);
                    wH = h.wH(soE);
                    w.i("MicroMsg.MsgHandler", "WNJSHandlerVoicePlayStart");
                    try {
                        if (wH.rXh != null) {
                            wH.rXh.m(39, bundle);
                            return;
                        }
                        return;
                    } catch (RemoteException e2) {
                        w.w("MicroMsg.MsgHandler", "WNJSHandlerVoicePlayStart exception" + e2.getMessage());
                        return;
                    }
                case bc.CTRL_INDEX /*59*/:
                    kaVar2 = new fp();
                    kaVar2.fKp.type = 22;
                    a.urY.m(kaVar2);
                    return;
                case 60:
                    final long j = bundle.getLong("localId");
                    kaVar = new fp();
                    kaVar.fKp.type = 12;
                    kaVar.fKp.fFx = bundle.getLong("localId");
                    kaVar.fKp.fKu = new Runnable(this) {
                        final /* synthetic */ b soJ;

                        public final void run() {
                            w.d("MicroMsg.WNNoteWebViewLogic", "do del, local id %d", new Object[]{Long.valueOf(j)});
                            g wH = h.wH(b.soE);
                            w.i("MicroMsg.MsgHandler", "WNJSHandlerFinishActivity");
                            try {
                                if (wH.rXh != null) {
                                    wH.rXh.m(34, new Bundle());
                                }
                            } catch (RemoteException e) {
                                w.w("MicroMsg.MsgHandler", "WNJSHandlerFinishActivity exception" + e.getMessage());
                            }
                        }
                    };
                    a.urY.m(kaVar);
                    return;
                case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                    if (this.soC.containsValue("WeNoteHtmlFile")) {
                        wH = h.wH(soE);
                        w.i("MicroMsg.MsgHandler", "WNJSHandlerLoadingStart");
                        try {
                            if (wH.rXh != null) {
                                wH.rXh.m(44, null);
                                return;
                            }
                            return;
                        } catch (RemoteException e22) {
                            w.w("MicroMsg.MsgHandler", "WNJSHandlerLoadingStart exception" + e22.getMessage());
                            return;
                        }
                    }
                    return;
                case 62:
                    Ko = bundle.getString("username");
                    final String string = bundle.getString("customText");
                    if (Boolean.valueOf(bundle.getBoolean("fromsession", false)).booleanValue()) {
                        long j2 = bundle.getLong("msgId", -1);
                        ap.yY();
                        final ce cA = com.tencent.mm.u.c.wT().cA(j2);
                        if (cA.field_msgId != j2) {
                            w.w("MicroMsg.WNNoteWebViewLogic", "want to send note msg, but message info is null");
                            return;
                        } else {
                            ap.vL().D(new Runnable(this) {
                                final /* synthetic */ b soJ;

                                public final void run() {
                                    com.tencent.mm.sdk.b.b lzVar = new lz();
                                    lzVar.fTf.type = 4;
                                    lzVar.fTf.fTk = cA;
                                    lzVar.fTf.toUser = Ko;
                                    lzVar.fTf.fKv = string;
                                    a.urY.m(lzVar);
                                    af.v(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass3 soL;

                                        {
                                            this.soL = r1;
                                        }

                                        public final void run() {
                                            Bundle bundle = new Bundle();
                                            bundle.putBoolean("AC_WNNOTE_SEND_TO_USER", true);
                                            h.wH(b.soE).U(bundle);
                                        }
                                    });
                                }

                                public final String toString() {
                                    return super.toString() + "|onActivityResult";
                                }
                            });
                            return;
                        }
                    }
                    ap.vL().D(new Runnable(this) {
                        final /* synthetic */ b soJ;

                        public final void run() {
                            com.tencent.mm.sdk.b.b fpVar = new fp();
                            fpVar.fKp.type = 32;
                            fpVar.fKp.fFx = this.soJ.fQF;
                            a.urY.m(fpVar);
                            if (fpVar.fKq.ret != 0) {
                                Bundle bundle = new Bundle();
                                bundle.putBoolean("AC_WNNOTE_SEND_TO_USER", false);
                                bundle.putBoolean("AC_WNNOTE_SEND_TO_USER_FAILE_REASON", fpVar.fKq.fKF);
                                h.wH(b.soE).U(bundle);
                                return;
                            }
                            fpVar = new fp();
                            fpVar.fKp.type = 13;
                            fpVar.fKp.context = ab.getContext();
                            fpVar.fKp.toUser = Ko;
                            fpVar.fKp.fKv = string;
                            fpVar.fKp.fFx = this.soJ.fQF;
                            fpVar.fKp.fKu = new Runnable(this) {
                                final /* synthetic */ AnonymousClass4 soM;

                                {
                                    this.soM = r1;
                                }

                                public final void run() {
                                    Bundle bundle = new Bundle();
                                    bundle.putBoolean("AC_WNNOTE_SEND_TO_USER", true);
                                    h.wH(b.soE).U(bundle);
                                }
                            };
                            a.urY.m(fpVar);
                        }

                        public final String toString() {
                            return super.toString() + "|onActivityResult";
                        }
                    });
                    return;
                case 64:
                    kaVar2 = new ka();
                    kaVar2.fQo.type = 7;
                    kaVar2.fQo.fQv = 4;
                    kaVar2.fQo.path = bundle.getString("voicepath");
                    kaVar2.fQo.fQw = bundle.getInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                    a.urY.m(kaVar2);
                    return;
                case 65:
                    kaVar2 = new ka();
                    kaVar2.fQo.type = 7;
                    kaVar2.fQo.fQv = 2;
                    kaVar2.fQo.fQx = bundle.getStringArrayList("items");
                    a.urY.m(kaVar2);
                    return;
                case 66:
                    kaVar2 = new ka();
                    kaVar2.fQo.type = 7;
                    kaVar2.fQo.fQv = 3;
                    kaVar2.fQo.fQr = bundle.getString("locationData");
                    kaVar2.fQo.context = ab.getContext();
                    a.urY.m(kaVar2);
                    return;
                case 67:
                    kaVar2 = new ka();
                    kaVar2.fQo.type = 7;
                    kaVar2.fQo.fQv = 5;
                    kaVar2.fQo.path = bundle.getString("path");
                    a.urY.m(kaVar2);
                    return;
                case bl.CTRL_INDEX /*68*/:
                    kaVar2 = new ka();
                    kaVar2.fQo.type = 8;
                    kaVar2.fQo.path = bundle.getString("voicepath");
                    kaVar2.fQo.context = ab.getContext();
                    a.urY.m(kaVar2);
                    return;
                case 69:
                    Ko = null;
                    try {
                        Ko = new JSONObject(Ko(bundle.getString("ExportData", ""))).getString("html");
                    } catch (JSONException e3) {
                        w.e("MicroMsg.WNNoteWebViewLogic", "notify_ui_finishbutton crash, error is %s", new Object[]{e3.getMessage()});
                    }
                    if (bg.mA(Ko)) {
                        w.e("MicroMsg.WNNoteWebViewLogic", "AC_WNNOTE_JS_NOTIFY_UI_FINISHBUTTON,but htmlStr is null or nil");
                        return;
                    } else {
                        ap.vL().D(new Runnable(this) {
                            final /* synthetic */ b soJ;

                            public final void run() {
                                String str = Ko;
                                ArrayList arrayList = new ArrayList();
                                Set hashSet = new HashSet();
                                int i = 0;
                                while (i < str.length()) {
                                    i = str.indexOf(this.soJ.soG, i + 1);
                                    if (i == -1) {
                                        break;
                                    }
                                    int indexOf = str.indexOf("\"", i + 1);
                                    if (indexOf == -1) {
                                        break;
                                    }
                                    int indexOf2 = str.indexOf(" ", i + 1);
                                    if (indexOf2 == -1) {
                                        break;
                                    }
                                    if (indexOf >= indexOf2) {
                                        indexOf = indexOf2;
                                    }
                                    String substring = str.substring(i, indexOf);
                                    if (hashSet.add(substring)) {
                                        arrayList.add(substring);
                                    }
                                }
                                hashSet.clear();
                                this.soJ.Km(Ko);
                                com.tencent.mm.sdk.b.b kaVar = new ka();
                                kaVar.fQo.type = 11;
                                kaVar.fQo.fQx = arrayList;
                                a.urY.m(kaVar);
                            }
                        });
                        return;
                    }
                case 70:
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("operation_type", 6);
                    h.wH(soE).V(bundle2);
                    return;
                default:
                    return;
            }
        }
    }

    private static String Ko(String str) {
        if (!str.startsWith("{\"")) {
            str = str.substring(1, str.length() - 1);
        }
        if (str.startsWith("{\"")) {
            return str;
        }
        return str.replaceAll("\\\\\"", "\"").replaceAll("\\\\\\\\", "\\\\").replaceAll("\\\\u003C", "<");
    }

    public final synchronized void bAm() {
        String str = "MicroMsg.WNNoteWebViewLogic";
        String str2 = "WNNote:initWebviewLogicData hasAreadyInit = %s";
        Object[] objArr = new Object[1];
        objArr[0] = this.soI ? "true" : "false";
        w.i(str, str2, objArr);
        if (!this.soI) {
            this.soI = true;
            this.soD = false;
            this.soH = "";
            this.soA = null;
            this.soz = "";
            this.soB = null;
            this.fQF = -1;
            w.i("MicroMsg.WNNoteWebViewLogic", "WNNote:initWebviewLogicData mNoteJsonArray is null");
        }
    }
}
