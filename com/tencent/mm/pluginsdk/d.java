package com.tencent.mm.pluginsdk;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.br;
import com.tencent.mm.e.a.hf;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsimple.ah;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.bfs;
import com.tencent.mm.protocal.c.ch;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.u.t;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class d {
    public static String sBk = "";
    private static final Map<String, Long> sBl;

    public interface a {
        void a(int i, int i2, String str, k kVar, boolean z);
    }

    static {
        Map hashMap = new HashMap();
        sBl = hashMap;
        hashMap.put("weixin://", Long.valueOf(0));
        sBl.put("weixin://dl/stickers", Long.valueOf(1));
        sBl.put("weixin://dl/games", Long.valueOf(2));
        sBl.put("weixin://dl/moments", Long.valueOf(4));
        sBl.put("weixin://dl/add", Long.valueOf(8));
        sBl.put("weixin://dl/shopping", Long.valueOf(16));
        sBl.put("weixin://dl/groupchat", Long.valueOf(32));
        sBl.put("weixin://dl/scan", Long.valueOf(64));
        sBl.put("weixin://dl/profile", Long.valueOf(128));
        sBl.put("weixin://dl/settings", Long.valueOf(256));
        sBl.put("weixin://dl/general", Long.valueOf(512));
        sBl.put("weixin://dl/help", Long.valueOf(AppSupportContentFlag.MMAPP_SUPPORT_XLS));
        sBl.put("weixin://dl/notifications", Long.valueOf(AppSupportContentFlag.MMAPP_SUPPORT_XLSX));
        sBl.put("weixin://dl/terms", Long.valueOf(AppSupportContentFlag.MMAPP_SUPPORT_PDF));
        sBl.put("weixin://dl/chat", Long.valueOf(8192));
        sBl.put("weixin://dl/features", Long.valueOf(16384));
        sBl.put("weixin://dl/clear", Long.valueOf(32768));
        sBl.put("weixin://dl/feedback", Long.valueOf(65536));
        sBl.put("weixin://dl/faq", Long.valueOf(131072));
        sBl.put("weixin://dl/recommendation", Long.valueOf(262144));
        sBl.put("weixin://dl/groups", Long.valueOf(524288));
        sBl.put("weixin://dl/tags", Long.valueOf(1048576));
        sBl.put("weixin://dl/officialaccounts", Long.valueOf(2097152));
        sBl.put("weixin://dl/posts", Long.valueOf(4194304));
        sBl.put("weixin://dl/favorites", Long.valueOf(8388608));
        sBl.put("weixin://dl/privacy", Long.valueOf(16777216));
        sBl.put("weixin://dl/security", Long.valueOf(33554432));
        sBl.put("weixin://dl/wallet", Long.valueOf(67108864));
        sBl.put("weixin://dl/businessPay", Long.valueOf(134217728));
        sBl.put("weixin://dl/businessPay/", Long.valueOf(134217728));
        sBl.put("weixin://dl/wechatout", Long.valueOf(268435456));
        sBl.put("weixin://dl/protection", Long.valueOf(1073741824));
        sBl.put("weixin://dl/card", Long.valueOf(2147483648L));
        sBl.put("weixin://dl/about", Long.valueOf(1125899906842624L));
        sBl.put("weixin://dl/blacklist", Long.valueOf(4294967296L));
        sBl.put("weixin://dl/textsize", Long.valueOf(8589934592L));
        sBl.put("weixin://dl/sight", Long.valueOf(17179869184L));
        sBl.put("weixin://dl/languages", Long.valueOf(34359738368L));
        sBl.put("weixin://dl/chathistory", Long.valueOf(68719476736L));
        sBl.put("weixin://dl/bindqq", Long.valueOf(137438953472L));
        sBl.put("weixin://dl/bindmobile", Long.valueOf(274877906944L));
        sBl.put("weixin://dl/bindemail", Long.valueOf(549755813888L));
        sBl.put("weixin://dl/securityassistant", Long.valueOf(1099511627776L));
        sBl.put("weixin://dl/broadcastmessage", Long.valueOf(2199023255552L));
        sBl.put("weixin://dl/setname", Long.valueOf(4398046511104L));
        sBl.put("weixin://dl/myQRcode", Long.valueOf(8796093022208L));
        sBl.put("weixin://dl/myaddress", Long.valueOf(17592186044416L));
        sBl.put("weixin://dl/hidemoments", Long.valueOf(35184372088832L));
        sBl.put("weixin://dl/blockmoments", Long.valueOf(70368744177664L));
        sBl.put("weixin://dl/stickersetting", Long.valueOf(140737488355328L));
        sBl.put("weixin://dl/log", Long.valueOf(281474976710656L));
        sBl.put("weixin://dl/wechatoutcoupon", Long.valueOf(562949953421312L));
        sBl.put("weixin://dl/wechatoutshare", Long.valueOf(18014398509481984L));
        sBl.put("weixin://dl/personalemoticon", Long.valueOf(4503599627370496L));
        sBl.put("weixin://dl/designeremoji", Long.valueOf(9007199254740992L));
        sBl.put("weixin://dl/sightdraft", Long.valueOf(576460752303423488L));
        sBl.put("weixin://dl/jumpWxa/", Long.valueOf(576460752303423489L));
    }

    public static boolean X(String str, long j) {
        if (!bg.mA(str)) {
            long longValue;
            String LH = LH(str);
            if (sBl.containsKey(LH)) {
                longValue = ((Long) sBl.get(LH)).longValue();
            } else {
                longValue = -1;
            }
            if (longValue != -1 && (longValue == 0 || (longValue & j) == longValue)) {
                return true;
            }
        }
        return false;
    }

    public static boolean LD(String str) {
        String LH = LH(str);
        return sBl.containsKey(LH) || LE(LH);
    }

    public static boolean LE(String str) {
        return !bg.mA(str) && str.startsWith("weixin://dl/business");
    }

    public static boolean i(Uri uri) {
        if (uri == null) {
            return false;
        }
        if (bg.mA(uri.getQueryParameter("ticket"))) {
            return j(uri);
        }
        return true;
    }

    public static boolean j(Uri uri) {
        if (uri == null) {
            return false;
        }
        if (uri.toString().startsWith("weixin://dl/business/tempsession/") || uri.toString().startsWith("weixin://dl/businessTempSession/")) {
            return true;
        }
        return false;
    }

    private static boolean LF(String str) {
        if ((!str.equals("weixin://dl/wechatout") && !str.equals("weixin://dl/wechatoutcoupon") && !str.equals("weixin://dl/wechatoutshare")) || Boolean.valueOf(com.tencent.mm.plugin.ipcall.d.aDM()).booleanValue()) {
            return false;
        }
        Intent intent = new Intent();
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setClassName(ab.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
        intent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
        ab.getContext().startActivity(intent);
        return true;
    }

    public static void a(Context context, String str, String str2, int i, String str3, a aVar) {
        final String str4 = bg.mA(str) ? str3 : str;
        if (!LF(str4)) {
            k lVar = new l(str4, str2, i, (int) System.currentTimeMillis());
            final Context context2 = context;
            final int i2 = i;
            final String str5 = str2;
            final a aVar2 = aVar;
            ap.vd().a(233, new e() {
                public final void a(int i, int i2, String str, k kVar) {
                    ap.vd().b(233, (e) this);
                    w.i("MicroMsg.DeepLinkHelper", "[oneliang][doDeepLink][onSceneEnd]:errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    boolean z = false;
                    if (kVar != null && (kVar instanceof l)) {
                        l lVar = (l) kVar;
                        w.d("MicroMsg.DeepLinkHelper", "bitset:" + lVar.IW());
                        long IW = lVar.IW();
                        String IQ = lVar.IQ();
                        if (d.X(IQ, IW)) {
                            try {
                                w.i("MicroMsg.DeepLinkHelper", "[oneliang] uri: %s", IQ);
                                z = d.c(context2, lVar.IY(), IQ);
                                g.oUh.i(11405, IQ, Integer.valueOf(1), Integer.valueOf(i2), str5, bg.mz(str4));
                            } catch (Throwable e) {
                                w.printErrStackTrace("MicroMsg.DeepLinkHelper", e, "", "");
                                g.oUh.i(11405, IQ, Integer.valueOf(0), Integer.valueOf(i2), str5, bg.mz(str4));
                            }
                        } else {
                            w.i("MicroMsg.DeepLinkHelper", "[oneliang] no permission");
                            Intent intent = new Intent();
                            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            intent.setClassName(ab.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                            intent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
                            intent.putExtra("geta8key_session_id", lVar.IY());
                            ab.getContext().startActivity(intent);
                            g.oUh.i(11405, IQ, Integer.valueOf(0), Integer.valueOf(i2), str5, bg.mz(str4));
                            z = true;
                        }
                    }
                    if (aVar2 != null) {
                        aVar2.a(i, i2, str, kVar, z);
                    }
                }
            });
            ap.vd().a(lVar, 0);
        }
    }

    public static void a(final Context context, final String str, final int i, final a aVar, String str2, String str3) {
        LinkedList linkedList = new LinkedList();
        ch chVar = new ch();
        if (!(bg.mA(str2) || bg.mA(str3))) {
            w.i("MicroMsg.DeepLinkHelper", "package name = %s, package signature = %s", str2, str3);
            chVar.tfA = str2;
            chVar.signature = str3;
            linkedList.add(chVar);
        }
        if (!LF(str)) {
            k ahVar = new ah(str, i, linkedList);
            ap.vd().a(1200, new e() {
                public final void a(int i, int i2, String str, k kVar) {
                    ap.vd().b(1200, (e) this);
                    w.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: errType = %s; errCode = %s; errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    boolean z = false;
                    if (kVar != null && (kVar instanceof ah)) {
                        String Jy = ((ah) kVar).Jy();
                        if (d.LD(Jy)) {
                            try {
                                w.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: deepLinkUri = %s", Jy);
                                z = d.a(context, Jy, i, str);
                                g.oUh.i(11405, str, Integer.valueOf(i), Integer.valueOf(1), Jy);
                            } catch (Throwable e) {
                                w.printErrStackTrace("MicroMsg.DeepLinkHelper", e, "", "");
                                g.oUh.i(11405, str, Integer.valueOf(i), Integer.valueOf(0), Jy);
                            }
                        } else {
                            w.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: translate failed");
                            Intent intent = new Intent();
                            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            intent.setClassName(ab.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                            intent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
                            intent.putExtra("showShare", false);
                            ab.getContext().startActivity(intent);
                            g.oUh.i(11405, str, Integer.valueOf(i), Integer.valueOf(0), Jy);
                            z = true;
                        }
                    }
                    if (aVar != null) {
                        aVar.a(i, i2, str, kVar, z);
                    }
                }
            });
            ap.vd().a(ahVar, 0);
        }
    }

    public static void a(Context context, String str, int i, a aVar) {
        a(context, str, i, aVar, null, null);
    }

    public static boolean LG(String str) {
        return a(null, str, 0, (int) System.currentTimeMillis(), null);
    }

    public static boolean c(Context context, int i, String str) {
        return a(context, str, 0, i, null);
    }

    public static boolean a(Context context, String str, int i, String str2) {
        return a(context, str, i, (int) System.currentTimeMillis(), str2);
    }

    private static boolean a(Context context, String str, int i, int i2, String str2) {
        String LH = LH(str);
        if (bg.mA(LH)) {
            return false;
        }
        String substring;
        String encode;
        Uri parse;
        String queryParameter;
        if (sBl.containsKey(LH)) {
            long longValue = ((Long) sBl.get(LH)).longValue();
            w.i("MicroMsg.DeepLinkHelper", "gotoUri, deepLinkMap contains uri, result = %d", Long.valueOf(longValue));
            LH = null;
            Intent intent = new Intent();
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            if (longValue == 0) {
                LH = "com.tencent.mm.ui.LauncherUI";
            } else if (longValue == 1) {
                LH = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI";
                g.oUh.i(12065, Integer.valueOf(7));
            } else if (longValue == 2) {
                intent.putExtra("from_deeplink", true);
                intent.putExtra("game_report_from_scene", 6);
                LH = "com.tencent.mm.plugin.game.ui.GameCenterUI";
            } else if (longValue == 4) {
                if (((m.xW() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0 ? 1 : null) != null) {
                    LH = "com.tencent.mm.plugin.sns.ui.En_424b8e16";
                    intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                }
            } else if (longValue == 8) {
                LH = "com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI";
            } else if (longValue == 16) {
                b hfVar = new hf();
                com.tencent.mm.sdk.b.a.urY.m(hfVar);
                r4 = hfVar.fMG.url;
                if (!bg.mA(r4)) {
                    intent.putExtra("rawUrl", r4);
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    intent.putExtra("geta8key_session_id", i2);
                    LH = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
                }
            } else if (longValue == 32) {
                intent.putExtra("titile", ab.getContext().getString(R.l.dCS));
                intent.putExtra("list_type", 0);
                intent.putExtra("list_attr", s.q(s.vYP, 256, 512));
                LH = "com.tencent.mm.ui.contact.SelectContactUI";
            } else if (longValue == 64) {
                LH = "com.tencent.mm.plugin.scanner.ui.BaseScanUI";
                intent.putExtra("animation_pop_in", true);
            } else if (longValue == 128) {
                LH = "com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI";
            } else if (longValue == 256) {
                LH = "com.tencent.mm.plugin.setting.ui.setting.SettingsUI";
            } else if (longValue == 512) {
                LH = "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI";
            } else if (longValue == AppSupportContentFlag.MMAPP_SUPPORT_XLS) {
                K(ab.getContext(), i2);
            } else if (longValue == AppSupportContentFlag.MMAPP_SUPPORT_XLSX) {
                LH = "com.tencent.mm.plugin.setting.ui.setting.SettingsNotificationUI";
            } else if (longValue == AppSupportContentFlag.MMAPP_SUPPORT_PDF) {
                intent.putExtra("title", ab.getContext().getResources().getString(R.l.eGT));
                intent.putExtra("rawUrl", ab.getContext().getResources().getString(R.l.eZp));
                intent.putExtra("showShare", false);
                intent.putExtra("geta8key_session_id", i2);
                LH = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
            } else if (longValue == 8192) {
                LH = "com.tencent.mm.plugin.setting.ui.setting.SettingsChattingUI";
            } else if (longValue == 16384) {
                LH = "com.tencent.mm.plugin.setting.ui.setting.SettingsPluginsUI";
            } else if (longValue == 32768) {
                LH = "com.tencent.mm.plugin.clean.ui.CleanUI";
            } else if (longValue == 65536) {
                try {
                    r4 = "";
                    int indexOf = str.indexOf("?");
                    if (indexOf > 0) {
                        substring = str.substring(indexOf + 1);
                    } else {
                        substring = r4;
                    }
                    h.vG();
                    r4 = com.tencent.mm.kernel.a.uH();
                    encode = URLEncoder.encode(com.tencent.mm.protocal.d.sYL, ProtocolPackage.ServerEncoding);
                    r7 = URLEncoder.encode(bg.bJS(), ProtocolPackage.ServerEncoding);
                    String encode2 = URLEncoder.encode(p.rA(), ProtocolPackage.ServerEncoding);
                    String encode3 = URLEncoder.encode(com.tencent.mm.protocal.d.sYG, ProtocolPackage.ServerEncoding);
                    String encode4 = URLEncoder.encode(com.tencent.mm.protocal.d.sYH, ProtocolPackage.ServerEncoding);
                    r4 = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index" + "&version=" + com.tencent.mm.protocal.d.sYN + "&lang=" + v.ea(ab.getContext()) + "&" + bg.mz(substring) + ("&uin=" + r4 + "&deviceName=" + encode + "&timeZone=" + r7 + "&imei=" + encode2 + "&deviceBrand=" + encode3 + "&deviceModel=" + encode4 + "&ostype=" + URLEncoder.encode(com.tencent.mm.protocal.d.sYI, ProtocolPackage.ServerEncoding) + "&clientSeqID=" + URLEncoder.encode(ap.uY(), ProtocolPackage.ServerEncoding) + "&signature=" + URLEncoder.encode(bg.ep(ab.getContext()), ProtocolPackage.ServerEncoding) + "&scene=" + (bg.mA(substring) ? 0 : 1));
                    intent.putExtra("showShare", false);
                    intent.putExtra("rawUrl", r4);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("geta8key_session_id", i2);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sYW);
                    LH = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
                } catch (UnsupportedEncodingException e) {
                    w.e("MicroMsg.DeepLinkHelper", "[oneliang]UnsupportedEncodingException:%s", e.getMessage());
                }
            } else if (longValue == 131072) {
                h.vG();
                r4 = com.tencent.mm.kernel.a.uH();
                ap.yY();
                r2 = bg.f((Integer) c.vr().get(12304, null));
                LH = ab.getContext().getString(R.l.eUp, new Object[]{Integer.valueOf(r4), Integer.valueOf(r2)});
                intent.putExtra("showShare", false);
                intent.putExtra("rawUrl", LH);
                intent.putExtra("geta8key_session_id", i2);
                LH = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
            } else if (longValue == 262144) {
                LH = "com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI";
            } else if (longValue == 524288) {
                LH = "com.tencent.mm.ui.contact.ChatroomContactUI";
            } else if (longValue == 1048576) {
                LH = "com.tencent.mm.plugin.label.ui.ContactLabelManagerUI";
            } else if (longValue == 2097152) {
                LH = "com.tencent.mm.plugin.brandservice.ui.BrandServiceIndexUI";
            } else if (longValue == 268435456) {
                intent.putExtra("IPCallAddressUI_KFrom", 1);
                com.tencent.mm.bb.d.b(ab.getContext(), "ipcall", ".ui.IPCallAddressUI", intent);
                return true;
            } else if (longValue == 4194304) {
                ap.yY();
                intent.putExtra("sns_userName", (String) c.vr().get(2, null));
                intent.addFlags(67108864);
                ap.yY();
                r2 = bg.a((Integer) c.vr().get(68389, null), 0);
                ap.yY();
                c.vr().set(68389, Integer.valueOf(r2 + 1));
                LH = "com.tencent.mm.plugin.sns.ui.SnsUserUI";
            } else if (longValue == 8388608) {
                LH = "com.tencent.mm.plugin.favorite.ui.FavoriteIndexUI";
            } else if (longValue == 16777216) {
                LH = "com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI";
            } else if (longValue == 33554432) {
                LH = "com.tencent.mm.plugin.setting.ui.setting.SettingsAccountInfoUI";
            } else if (longValue == 67108864) {
                LH = "com.tencent.mm.plugin.mall.ui.MallIndexUI";
            } else if (longValue == 134217728) {
                if (!(context == null || bg.mA(str))) {
                    if (str.startsWith("weixin://dl/businessPay")) {
                        parse = Uri.parse(str);
                        if (parse != null) {
                            r4 = parse.getQueryParameter("reqkey");
                            queryParameter = parse.getQueryParameter("appid");
                            if (bg.mA(r4)) {
                                w.w("MicroMsg.DeepLinkHelper", "reqkey null");
                            } else {
                                Parcelable payInfo = new PayInfo();
                                payInfo.fJH = r4;
                                payInfo.appId = queryParameter;
                                payInfo.fRv = 36;
                                payInfo.mqD = false;
                                intent = new Intent();
                                intent.putExtra("key_pay_info", payInfo);
                                if (m.xY()) {
                                    com.tencent.mm.bb.d.b(context, "wallet_payu", ".pay.ui.WalletPayUPayUI", intent, 1);
                                } else {
                                    com.tencent.mm.bb.d.b(context, "wallet", ".pay.ui.WalletPayUI", intent, 1);
                                }
                            }
                        } else {
                            w.w("MicroMsg.DeepLinkHelper", "payUri null");
                        }
                    }
                }
                intent = null;
            } else if (longValue == 1073741824) {
                LH = "com.tencent.mm.plugin.safedevice.ui.MySafeDeviceListUI";
            } else if (longValue == 2147483648L) {
                LH = "com.tencent.mm.plugin.card.ui.CardHomePageUI";
            } else if (longValue == 4294967296L) {
                intent.putExtra("filter_type", t.fT(ab.getContext().getString(R.l.eqF)).getType());
                intent.putExtra("titile", ab.getContext().getString(R.l.eTM));
                intent.putExtra("list_attr", WXMediaMessage.THUMB_LENGTH_LIMIT);
                LH = "com.tencent.mm.ui.contact.SelectSpecialContactUI";
            } else if (longValue == 8589934592L) {
                LH = "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI";
            } else if (longValue == 17179869184L) {
                LH = "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI";
            } else if (longValue == 34359738368L) {
                LH = "com.tencent.mm.plugin.setting.ui.setting.SettingsLanguageUI";
            } else if (longValue == 68719476736L) {
                LH = "com.tencent.mm.plugin.backup.backupmoveui.BackupUI";
            } else if (longValue == 137438953472L) {
                intent.setClassName(ab.getContext(), "com.tencent.mm.ui.bindqq.BindQQUI");
                MMWizardActivity.z(context, intent);
                return true;
            } else if (longValue == 274877906944L) {
                intent.setClassName(ab.getContext(), "com.tencent.mm.ui.bindmobile.BindMContactIntroUI");
                MMWizardActivity.z(context, intent);
                return true;
            } else if (longValue == 549755813888L) {
                LH = "com.tencent.mm.plugin.setting.ui.setting.SettingsModifyEmailAddrUI";
            } else if (longValue == 1099511627776L) {
                com.tencent.mm.bb.d.b(ab.getContext(), "profile", ".ui.ContactInfoUI", intent.putExtra("Contact_User", "qqsync"));
                return true;
            } else if (longValue == 2199023255552L) {
                LH = "com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI";
            } else if (longValue == 4398046511104L) {
                LH = "com.tencent.mm.plugin.setting.ui.setting.SettingsModifyNameUI";
            } else if (longValue == 8796093022208L) {
                LH = "com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI";
            } else if (longValue == 17592186044416L) {
                intent.putExtra("launch_from_webview", false);
                com.tencent.mm.bb.d.a(ab.getContext(), "address", ".ui.WalletSelectAddrUI", intent, true);
                return true;
            } else if (longValue == 35184372088832L) {
                intent.putExtra("k_sns_tag_id", 4);
                intent.putExtra("k_sns_from_settings_about_sns", 1);
                com.tencent.mm.bb.d.b(ab.getContext(), "sns", ".ui.SnsBlackDetailUI", intent);
                return true;
            } else if (longValue == 70368744177664L) {
                intent.putExtra("k_sns_tag_id", 5);
                intent.putExtra("k_sns_from_settings_about_sns", 2);
                intent.putExtra("k_tag_detail_sns_block_scene", 8);
                com.tencent.mm.bb.d.b(ab.getContext(), "sns", ".ui.SnsTagDetailUI", intent);
            } else if (longValue == 140737488355328L) {
                LH = "com.tencent.mm.plugin.emoji.ui.EmojiMineUI";
            } else if (longValue == 281474976710656L) {
                b brVar = new br();
                brVar.fFg.fFi = "//uplog";
                brVar.fFg.context = ab.getContext();
                com.tencent.mm.sdk.b.a.urY.m(brVar);
                return true;
            } else if (longValue == 562949953421312L) {
                intent.putExtra("IPCallAddressUI_KFrom", 1);
                com.tencent.mm.bb.d.b(ab.getContext(), "ipcall", ".ui.IPCallAddressUI", intent);
                com.tencent.mm.bb.d.b(ab.getContext(), "ipcall", ".ui.IPCallShareCouponUI", intent);
                return true;
            } else if (longValue == 18014398509481984L) {
                intent.putExtra("IPCallAddressUI_KFrom", 1);
                com.tencent.mm.bb.d.b(ab.getContext(), "ipcall", ".ui.IPCallAddressUI", intent);
                com.tencent.mm.bb.d.b(ab.getContext(), "ipcall", ".ui.IPCallShareCouponUI", intent);
                com.tencent.mm.bb.d.b(ab.getContext(), "ipcall", ".ui.IPCallShareCouponCardUI", intent);
            } else if (longValue == 576460752303423488L) {
                intent.putExtra("IPCallAddressUI_KFrom", 1);
                intent.setClassName(ab.getContext(), "com.tencent.mm.plugin.sight.draft.ui.SightDraftUI");
                ab.getContext().startActivity(intent);
            } else if (longValue == 1125899906842624L) {
                LH = "com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI";
            } else if (longValue == 4503599627370496L) {
                intent.putExtra("emoji_tab", 1);
                LH = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI";
                g.oUh.i(12065, Integer.valueOf(7));
            } else if (longValue == 9007199254740992L) {
                LH = "com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI";
            } else if (longValue == 576460752303423489L) {
                Uri parse2 = Uri.parse(str);
                r7 = parse2.getQueryParameter("appid");
                r4 = parse2.getQueryParameter("userName");
                substring = parse2.getQueryParameter("path");
                w.i("MicroMsg.DeepLinkHelper", "appid = %s, userName = %s, path = %s, translateLinkScene = %d", r7, r4, substring, Integer.valueOf(i));
                if (i == 2) {
                    ((com.tencent.mm.plugin.appbrand.i.c) h.h(com.tencent.mm.plugin.appbrand.i.c.class)).a(context, r4, substring, 1065, URLEncoder.encode(str2), "");
                } else if (i == 1) {
                    ((com.tencent.mm.plugin.appbrand.i.c) h.h(com.tencent.mm.plugin.appbrand.i.c.class)).a(context, r4, substring, 1069, r7, r7);
                } else if (i == 6) {
                    ((com.tencent.mm.plugin.appbrand.i.c) h.h(com.tencent.mm.plugin.appbrand.i.c.class)).a(context, r4, substring, (int) MMBitmapFactory.ERROR_IMAGE_SIZE_IS_TOO_LARGE, URLEncoder.encode(str2), "");
                } else if (i == 7) {
                    ((com.tencent.mm.plugin.appbrand.i.c) h.h(com.tencent.mm.plugin.appbrand.i.c.class)).a(context, r4, substring, (int) MMBitmapFactory.ERROR_ILLEGAL_IMAGE_SIZE, URLEncoder.encode(str2), "");
                } else {
                    ((com.tencent.mm.plugin.appbrand.i.c) h.h(com.tencent.mm.plugin.appbrand.i.c.class)).a(context, r4, substring, 1000, URLEncoder.encode(str2), "");
                }
                return true;
            }
            if (bg.mA(LH)) {
                return false;
            }
            intent.setClassName(ab.getContext(), LH);
            if (context != null) {
                try {
                    context.startActivity(intent);
                } catch (Throwable e2) {
                    w.printErrStackTrace("MicroMsg.DeepLinkHelper", e2, "", "");
                }
            } else {
                ab.getContext().startActivity(intent);
                com.tencent.mm.ui.base.b.A(ab.getContext(), intent);
            }
            return true;
        } else if (LH.startsWith("weixin://dl/businessTempSession/")) {
            r4 = new Intent();
            r4.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            parse = Uri.parse(str);
            if (parse == null) {
                w.e("MicroMsg.DeepLinkHelper", "tempsession uri is null");
                return false;
            }
            substring = parse.getQueryParameter("sessionFrom");
            encode = parse.getQueryParameter("showtype");
            LH = parse.getQueryParameter("username");
            if (bg.mA(LH)) {
                LH = parse.getQueryParameter("userName");
            }
            if (bg.mA(LH)) {
                w.e("MicroMsg.DeepLinkHelper", "tempsession user is null");
                return false;
            }
            int i3 = bg.getInt(bg.mz(parse.getQueryParameter("scene")), 0);
            if (i3 != 0 && i == 4) {
                w.i("MicroMsg.DeepLinkHelper", "Jsapi assign scene to " + i3);
                i = i3;
            }
            w.i("MicroMsg.DeepLinkHelper", "tempsession jump, %s, %s, %s, %s, %s.", LH, substring, Integer.valueOf(i), str, encode);
            r4.setClassName(ab.getContext(), "com.tencent.mm.ui.chatting.En_5b8fbb1e");
            r4.putExtra("Chat_User", LH);
            r4.putExtra("finish_direct", true);
            r4.putExtra("key_is_temp_session", true);
            r4.putExtra("key_temp_session_from", substring);
            r4.putExtra("key_temp_session_scene", i);
            r4.putExtra("key_temp_session_show_type", bg.getInt(encode, 0));
            ap.yY();
            com.tencent.mm.j.a Rc = c.wR().Rc(LH);
            if (Rc == null || ((int) Rc.gTQ) <= 0) {
                final Context context2 = context;
                com.tencent.mm.u.ag.a.hlS.a(LH, "", new com.tencent.mm.u.ag.b.a() {
                    public final void p(String str, boolean z) {
                        if (z) {
                            r4.putExtra("Chat_User", str);
                            try {
                                if (context2 != null) {
                                    context2.startActivity(r4);
                                    return;
                                } else {
                                    ab.getContext().startActivity(r4);
                                    return;
                                }
                            } catch (Throwable e) {
                                w.printErrStackTrace("MicroMsg.DeepLinkHelper", e, "", "");
                                return;
                            }
                        }
                        w.e("MicroMsg.DeepLinkHelper", "getContact fail, %s", str);
                    }
                });
            } else {
                context.startActivity(r4);
            }
            return true;
        } else if (LH.startsWith("weixin://dl/businessGame/detail/") || LH.startsWith("weixin://dl/businessGame/detail")) {
            w.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith GAME_DETAIL");
            parse = Uri.parse(str);
            LH = null;
            r4 = new Intent();
            if (parse != null) {
                LH = "com.tencent.mm.plugin.game.ui.GameDetailUI";
                r4.putExtra("game_app_id", parse.getQueryParameter("appid"));
                r4.putExtra("game_report_from_scene", 6);
            }
            if (bg.mA(LH)) {
                return false;
            }
            r4.setClassName(ab.getContext(), LH);
            if (context != null) {
                try {
                    context.startActivity(r4);
                } catch (Throwable e22) {
                    w.printErrStackTrace("MicroMsg.DeepLinkHelper", e22, "", "");
                }
            } else {
                ab.getContext().startActivity(r4);
                com.tencent.mm.ui.base.b.A(ab.getContext(), r4);
            }
            return true;
        } else if (LH.startsWith("weixin://dl/businessGame/library/") || LH.startsWith("weixin://dl/businessGame/library")) {
            w.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith GAME_LIBRARY");
            Intent intent2 = new Intent();
            queryParameter = "com.tencent.mm.plugin.game.ui.GameLibraryUI";
            if (bg.mA(queryParameter)) {
                return false;
            }
            intent2.putExtra("game_report_from_scene", 6);
            intent2.setClassName(ab.getContext(), queryParameter);
            if (context != null) {
                try {
                    context.startActivity(intent2);
                } catch (Throwable e222) {
                    w.printErrStackTrace("MicroMsg.DeepLinkHelper", e222, "", "");
                }
            } else {
                ab.getContext().startActivity(intent2);
                com.tencent.mm.ui.base.b.A(ab.getContext(), intent2);
            }
            return true;
        } else if (!LH.startsWith("weixin://dl/businessWebview/link/") && !LH.startsWith("weixin://dl/businessWebview/link")) {
            return false;
        } else {
            w.i("MicroMsg.DeepLinkHelper", "gotoUri, uri startsWith H5_LINK");
            parse = Uri.parse(str);
            r4 = new Intent();
            LH = null;
            if (parse != null) {
                w.i("MicroMsg.DeepLinkHelper", "gotoUri, rawUrl = %s, translateLinkScene: %s", parse.getQueryParameter(SlookSmartClipMetaTag.TAG_TYPE_URL), Integer.valueOf(i));
                LH = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
                r4.putExtra("rawUrl", queryParameter);
                r4.putExtra("geta8key_session_id", i2);
                r4.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                if (i == 1) {
                    r4.putExtra("show_openapp_dialog", false);
                    r4.putExtra("pay_channel", 40);
                } else if (i == 2) {
                    r4.putExtra("pay_channel", 39);
                }
                r4.putExtra("transaction_for_openapi_openwebview", sBk);
            }
            if (bg.mA(LH)) {
                return false;
            }
            r4.setClassName(ab.getContext(), LH);
            if (context != null) {
                try {
                    context.startActivity(r4);
                } catch (Throwable e2222) {
                    w.printErrStackTrace("MicroMsg.DeepLinkHelper", e2222, "", "");
                }
            } else {
                ab.getContext().startActivity(r4);
                com.tencent.mm.ui.base.b.A(ab.getContext(), r4);
            }
            return true;
        }
    }

    public static void dq(Context context) {
        K(context, (int) System.currentTimeMillis());
    }

    private static void K(Context context, int i) {
        String string;
        if (!f.usw && v.bIN().equals("zh_CN")) {
            string = context.getString(R.l.fmX);
        } else if (v.bIN().equals("zh_HK")) {
            string = context.getString(R.l.fmY);
        } else if (v.bIN().equals("zh_TW")) {
            string = context.getString(R.l.fmZ);
        } else {
            string = context.getString(R.l.fna);
        }
        w.d("MicroMsg.DeepLinkHelper", "using faq webpage");
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("show_feedback", false);
        intent.putExtra("geta8key_session_id", i);
        com.tencent.mm.bb.d.b(context, "webview", ".ui.tools.WebViewUI", intent);
    }

    private static String LH(String str) {
        if (bg.mA(str)) {
            return null;
        }
        Uri parse = Uri.parse(str);
        return parse.getScheme() + "://" + parse.getHost() + parse.getPath();
    }

    public static void s(final Context context, String str, String str2) {
        if (!LF(str2)) {
            final ProgressDialog a = com.tencent.mm.ui.base.g.a(context, "", true, null);
            int i = 6;
            if (!bg.mA(str)) {
                if (o.dH(str)) {
                    i = 7;
                } else if (o.eV(str)) {
                    i = 9;
                }
            }
            a(context, str2, i, new a() {
                public final void a(int i, int i2, String str, k kVar, boolean z) {
                    w.i("MicroMsg.DeepLinkHelper", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
                    if (a != null && a.isShowing()) {
                        a.dismiss();
                    }
                    if (kVar != null && i != 0 && i2 != 0 && (kVar instanceof ah)) {
                        bfs Jz = ((ah) kVar).Jz();
                        if (Jz != null && context != null) {
                            com.tencent.mm.ui.base.s.makeText(context, context.getString(R.l.dIO) + " : " + bg.mz(Jz.ugf), 0).show();
                        }
                    }
                }
            });
        }
    }

    public static void aN(Context context, String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI url is null. finish");
        } else if (str.startsWith("weixin://dl/login/phone_view")) {
            Uri parse = Uri.parse(str);
            w.d("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI cc:%s num:%s", parse.getQueryParameter("cc"), parse.getQueryParameter("num"));
            Intent intent = new Intent();
            intent.putExtra("input_country_code", r1);
            intent.putExtra("input_mobile_number", r0);
            intent.putExtra("from_deep_link", true);
            intent.putExtra("mobile_input_purpose", 1);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            com.tencent.mm.bb.d.b(context, "accountsync", "com.tencent.mm.ui.account.mobile.MobileInputUI", intent);
        } else if (str.startsWith("weixin://dl/login/common_view")) {
            w.d("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI  username:%s", Uri.parse(str).getQueryParameter("username"));
            Intent intent2 = new Intent();
            intent2.putExtra("login_username", r0);
            intent2.putExtra("from_deep_link", true);
            intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            com.tencent.mm.bb.d.b(context, "accountsync", "com.tencent.mm.ui.account.LoginUI", intent2);
        } else {
            w.e("MicroMsg.DeepLinkHelper", "cpan gotoLoginUI url not Correct:%s", str);
        }
    }
}
