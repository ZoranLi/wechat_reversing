package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.l;
import com.tencent.smtt.sdk.y;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.t;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class w {
    private static long sCT;
    private static final Map<String, Object> sCU = new HashMap();

    public static final class a {
        private static boolean sCX = false;

        static {
            TbsLog.setTbsLogClient(new t(ab.getContext()) {
                public final void qQ(String str) {
                    com.tencent.mm.sdk.platformtools.w.i("TBSDownloadChecker.TbsLogClient", "TbsLogClient: " + str);
                }
            });
        }

        public static void dw(Context context) {
            int i;
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.TBSDownloadChecker", "webview start check tbs");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.TBSDownloadChecker", "user hasDownloadOverSea = %b", Boolean.valueOf(sharedPreferences.getBoolean("tbs_download_oversea", false)));
            if (sharedPreferences.getBoolean("tbs_download_oversea", false)) {
                i = 2;
            } else if (bg.bKe()) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.TBSDownloadChecker", "isGPVersion, ignore this request");
                return;
            } else {
                i = 1;
            }
            if ("1".equals(sharedPreferences.getString("tbs_download", null))) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.TBSDownloadChecker", "check, tbsDownload = %s, isWifi = %b", r5, Boolean.valueOf(am.isWifi(context)));
                if (am.isWifi(context)) {
                    boolean z;
                    Intent intent;
                    if (sharedPreferences == null) {
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.TBSDownloadChecker", "sp is null");
                    } else {
                        long j = sharedPreferences.getLong("last_check_ts", 0);
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - j > 7200000) {
                            Editor edit = sharedPreferences.edit();
                            edit.putLong("last_check_ts", currentTimeMillis);
                            edit.apply();
                            z = true;
                            if (!z) {
                                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.TBSDownloadChecker", "check expired false, tbsCoreVersion = %d", Integer.valueOf(WebView.getTbsCoreVersion(context)));
                                if (WebView.getTbsCoreVersion(context) > 0) {
                                    return;
                                }
                            }
                            intent = new Intent();
                            intent.setClassName(ab.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
                            intent.putExtra("intent_extra_download_type", i);
                            context.startService(intent);
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
                            return;
                        }
                    }
                    z = false;
                    if (z) {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.TBSDownloadChecker", "check expired false, tbsCoreVersion = %d", Integer.valueOf(WebView.getTbsCoreVersion(context)));
                        if (WebView.getTbsCoreVersion(context) > 0) {
                            return;
                        }
                    }
                    intent = new Intent();
                    intent.setClassName(ab.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
                    intent.putExtra("intent_extra_download_type", i);
                    context.startService(intent);
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
                    return;
                }
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.TBSDownloadChecker", "check, net type is not wifi");
                return;
            }
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.TBSDownloadChecker", "tbsDownload switch is off, value = %s", sharedPreferences.getString("tbs_download", null));
        }

        public static void bCM() {
            if (bg.bKe()) {
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.TBSDownloadChecker", "preCheck isGPVersion, ignore this request");
            } else if (l.fN(ab.getContext()) && WebView.getTbsCoreVersion(ab.getContext()) <= 0) {
                Intent intent = new Intent();
                intent.setClassName(ab.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
                intent.putExtra("intent_extra_download_type", 1);
                ab.getContext().startService(intent);
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
            }
        }

        public static boolean bCN() {
            return l.atk() || QbSdk.getTBSInstalling() || sCX;
        }

        public static void jj(boolean z) {
            sCX = z;
        }

        public static int bCO() {
            if (QbSdk.getTbsVersion(ab.getContext()) < 36824) {
                if (!bg.bKe()) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.TBSDownloadChecker", "tbsCoreVersion %d should download", Integer.valueOf(r2));
                    return 1;
                } else if (d.ep(17)) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.TBSDownloadChecker", "is GP version can not download");
                    return 2;
                } else {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.TBSDownloadChecker", "is GP version no need download");
                    return 0;
                }
            } else if (QbSdk.canOpenWebPlus(ab.getContext())) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.TBSDownloadChecker", "tbsCoreVersion %d can load x5", Integer.valueOf(r2));
                return 0;
            } else {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.TBSDownloadChecker", "tbsCoreVersion %d can not load x5", Integer.valueOf(r2));
                return 1;
            }
        }

        public static int bCP() {
            if (d.eo(19) || d.ep(16)) {
                return 1;
            }
            if (WebView.getTbsCoreVersion(ab.getContext()) > 0) {
                return 4;
            }
            if (l.atk()) {
                return 2;
            }
            if (QbSdk.getTBSInstalling()) {
                return 3;
            }
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.TBSDownloadChecker", "oversea = %b", Boolean.valueOf(ab.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_download_oversea", false)));
            if (ab.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_download_oversea", false)) {
                return 2;
            }
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.TBSDownloadChecker", "WTF, how could it be?");
            return 0;
        }

        public static void dx(Context context) {
            Intent intent = new Intent();
            intent.setClassName(ab.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
            intent.putExtra("intent_extra_download_type", 2);
            intent.putExtra("intent_extra_download_ignore_network_type", true);
            context.startService(intent);
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
            SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
            if (sharedPreferences != null) {
                sharedPreferences.edit().putBoolean("tbs_download_oversea", true).apply();
            }
        }
    }

    public static void bCK() {
        final long currentTimeMillis = System.currentTimeMillis();
        QbSdk.preInit(ab.getContext(), new com.tencent.smtt.sdk.QbSdk.a() {
            public final void ot() {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.TBSHelper", "init TBS Core cost = %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                a.bCM();
            }

            public final void al(boolean z) {
            }
        });
    }

    public static String bCL() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<TBSInfo>");
        stringBuilder.append("<TBSCoreVersion>");
        stringBuilder.append(WebView.getTbsCoreVersion(ab.getContext()));
        stringBuilder.append("</TBSCoreVersion>");
        stringBuilder.append("<TBSSDKVersion>");
        stringBuilder.append(WebView.getTbsSDKVersion(ab.getContext()));
        stringBuilder.append("</TBSSDKVersion>");
        stringBuilder.append("</TBSInfo>");
        stringBuilder.append("<IMEI>");
        stringBuilder.append(p.rA());
        stringBuilder.append("</IMEI>");
        return stringBuilder.toString();
    }

    public static void Y(Intent intent) {
        final String stringExtra = intent.getStringExtra("file_path");
        final String stringExtra2 = intent.getStringExtra("file_ext");
        if (System.currentTimeMillis() - sCT >= 1000 && !bg.mA(stringExtra)) {
            sCT = System.currentTimeMillis();
            final Context context = ab.getContext();
            String str = "";
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("path", stringExtra);
                jSONObject.putOpt("ext", stringExtra2);
                str = jSONObject.toString();
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.TBSHelper", e, "", new Object[0]);
            }
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.TBSHelper", "openFileByMiniQB, file pathinfo:%s", str);
            QbSdk.canOpenFile(context, str, new y<Boolean>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    if (!((Boolean) obj).booleanValue()) {
                        w.ej(stringExtra, stringExtra2);
                    } else if (QbSdk.isTbsCoreInited()) {
                        w.ek(stringExtra, stringExtra2);
                    } else {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.TBSHelper", "tbs preInit");
                        QbSdk.preInit(context, new com.tencent.smtt.sdk.QbSdk.a(this) {
                            final /* synthetic */ AnonymousClass2 sCW;

                            {
                                this.sCW = r1;
                            }

                            public final void ot() {
                            }

                            public final void al(boolean z) {
                                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.TBSHelper", "tbs preInit callback, %b", Boolean.valueOf(z));
                                if (z) {
                                    w.ek(stringExtra, stringExtra2);
                                } else {
                                    w.ej(stringExtra, stringExtra2);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public static void ej(String str, String str2) {
        Intent intent = new Intent();
        intent.setAction("MINIQB_OPEN_RET");
        intent.putExtra("file_path", str);
        intent.putExtra("file_ext", str2);
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.TBSHelper", "TBS MiniQB cannot open this file:%s", str);
        intent.putExtra("MINIQB_OPEN_RET_VAL", false);
        ab.getContext().sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
    }

    public static void ek(String str, String str2) {
        Intent intent = new Intent();
        intent.setClassName(ab.getContext(), "com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI");
        intent.putExtra("file_path", str);
        intent.putExtra("file_ext", str2);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        ab.getContext().startActivity(intent);
    }

    public static void o(String str, Object obj) {
        sCU.put(str, obj);
        QbSdk.initTbsSettings(sCU);
    }
}
