package com.tencent.mm.app.plugin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.bb.d;
import com.tencent.mm.pluginsdk.l.w;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.JSAPIUploadLogHelperUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.ui.contact.VoipAddressUI;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.Iterator;

public final class a implements w {
    public final boolean a(Context context, String str, boolean z) {
        return a(context, str, z, null);
    }

    public final boolean a(Context context, String str, boolean z, o oVar) {
        if (context == null) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.MMURIJumpHandler", "jumpToURLWithCallback, context is null!");
            return false;
        } else if (str.startsWith("http")) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            try {
                context.startActivity(intent);
            } catch (Exception e) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.MMURIJumpHandler", "openLinkInBrowser fail:%s", e.getMessage());
            }
            return true;
        } else if (b(context, str, z, oVar)) {
            return false;
        } else {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.MMURIJumpHandler", "jumpToUI failed, uri:%s", str);
            return false;
        }
    }

    public final boolean a(Context context, String str, boolean z, Bundle bundle) {
        return a(context, str, z, null, bundle);
    }

    public final boolean b(Context context, String str, boolean z, o oVar) {
        return a(context, str, z, oVar, null);
    }

    private boolean a(Context context, String str, boolean z, o oVar, Bundle bundle) {
        if (context == null) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.MMURIJumpHandler", "jumpToUIInternal, context is null!");
            return false;
        } else if (str == null) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.MMURIJumpHandler", "jumpToUIInternal url is null");
            return false;
        } else if (str.startsWith("weixin://openSpecificView/")) {
            return b(context, str, new Object[0]);
        } else {
            e oM = e.oM();
            String str2 = "MicroMsg.URISpanHandler";
            String str3 = "handleUriJump, url:%s, isAllowScanQrCode:%b, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size: %d, mLowPriorityHandlerList.size: %d";
            Object[] objArr = new Object[6];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = Boolean.valueOf(oVar == null);
            objArr[3] = Integer.valueOf(oM.fxY.size());
            objArr[4] = Integer.valueOf(oM.fxZ.size());
            objArr[5] = Integer.valueOf(oM.fya.size());
            com.tencent.mm.sdk.platformtools.w.d(str2, str3, objArr);
            if (context == null) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.URISpanHandler", "handleUriJump, context is null!");
                oM.fxX.mContext = null;
                return false;
            }
            oM.mContext = context;
            oM.fxX.mContext = oM.mContext;
            if (bg.mA(str)) {
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.URISpanHandler", "handleUriJump, url is null");
                oM.mContext = null;
                oM.fxX.mContext = null;
                return false;
            }
            Iterator it = oM.fxY.iterator();
            while (it.hasNext()) {
                if (((BaseUriSpanHandler) it.next()).a(str, z, oVar, bundle)) {
                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", ((BaseUriSpanHandler) it.next()).getClass().getName());
                    oM.mContext = null;
                    oM.fxX.mContext = null;
                    return true;
                }
            }
            it = oM.fxZ.iterator();
            while (it.hasNext()) {
                if (((BaseUriSpanHandler) it.next()).a(str, z, oVar, bundle)) {
                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", ((BaseUriSpanHandler) it.next()).getClass().getName());
                    oM.mContext = null;
                    oM.fxX.mContext = null;
                    return true;
                }
            }
            it = oM.fya.iterator();
            while (it.hasNext()) {
                if (((BaseUriSpanHandler) it.next()).a(str, z, oVar, bundle)) {
                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", ((BaseUriSpanHandler) it.next()).getClass().getName());
                    oM.mContext = null;
                    oM.fxX.mContext = null;
                    return true;
                }
            }
            oM.mContext = null;
            oM.fxX.mContext = null;
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.URISpanHandler", "handleUriJump, nothing handle");
            return false;
        }
    }

    public final boolean b(Context context, String str, Object... objArr) {
        if (str == null) {
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.MMURIJumpHandler", "openSpecificUI uri is null");
            return false;
        } else if (context == null) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.MMURIJumpHandler", "openSpecificUI, context is null");
            return false;
        } else {
            Intent intent = new Intent();
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            String replace = str.replace("weixin://openSpecificView/", "");
            Bundle bundle = null;
            if (objArr != null && objArr.length > 0) {
                bundle = (Bundle) objArr[0];
            }
            if (replace.equalsIgnoreCase("contacts")) {
                intent.addFlags(67108864);
                intent.putExtra("preferred_tab", 2);
                context.startActivity(intent.setClass(context, LauncherUI.class));
            } else if (replace.equalsIgnoreCase("newfriend")) {
                d.b(context, "subapp", ".ui.friend.FMessageConversationUI", intent);
            } else if (replace.equalsIgnoreCase("addfriend")) {
                d.b(context, "subapp", ".ui.pluginapp.AddMoreFriendsUI", intent);
            } else if (replace.equalsIgnoreCase("searchbrand")) {
                Intent intent2 = new Intent();
                intent2.putExtra("Contact_Scene", 39);
                d.b(context, "brandservice", ".ui.SearchOrRecommendBizUI", intent2);
            } else if (replace.equalsIgnoreCase("discover")) {
                intent.addFlags(67108864);
                intent.putExtra("preferred_tab", 1);
                context.startActivity(intent.setClass(context, LauncherUI.class));
            } else if (replace.equalsIgnoreCase("timeline")) {
                d.b(context, "sns", ".ui.En_424b8e16", intent);
            } else if (replace.equalsIgnoreCase("scan")) {
                d.b(context, "scanner", ".ui.BaseScanUI", intent);
            } else if (replace.equalsIgnoreCase("myprofile")) {
                d.b(context, "setting", ".ui.setting.SettingsPersonalInfoUI", intent);
            } else if (replace.equalsIgnoreCase("myaccount")) {
                d.b(context, "setting", ".ui.setting.SettingsAccountInfoUI", intent);
            } else if (replace.equalsIgnoreCase("bindphone")) {
                MMWizardActivity.z(context, intent.setClass(context, BindMContactIntroUI.class));
            } else if (replace.equalsIgnoreCase("privacy")) {
                d.b(context, "setting", ".ui.setting.SettingsPrivacyUI", intent);
            } else if (replace.equalsIgnoreCase("general")) {
                d.b(context, "setting", ".ui.setting.SettingsAboutSystemUI", intent);
            } else if (replace.equalsIgnoreCase("invitevoip")) {
                VoipAddressUI.eY(context);
            } else if (replace.equalsIgnoreCase("expose")) {
                replace = "";
                if (bundle != null) {
                    r0 = bundle.getString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                } else {
                    r0 = replace;
                }
                intent.putExtra("k_expose_url", r0);
                intent.putExtra("k_username", m.xL());
                intent.putExtra("showShare", false);
                intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(34)}));
                d.b(context, "webview", ".ui.tools.WebViewUI", intent);
            } else if (replace.equalsIgnoreCase("shakecard")) {
                replace = "";
                if (bundle != null) {
                    r0 = bundle.getString("extinfo");
                } else {
                    r0 = replace;
                }
                intent.putExtra("key_shake_card_from_scene", 3);
                intent.putExtra("shake_card", true);
                intent.putExtra("key_shake_card_ext_info", r0);
                d.b(context, "shake", ".ui.ShakeReportUI", intent);
            } else if (replace.equalsIgnoreCase("cardlistview")) {
                d.b(context, "card", ".ui.CardHomePageUI", intent);
            } else if (!replace.equalsIgnoreCase("uploadlog")) {
                return false;
            } else {
                int i;
                replace = m.xL();
                if (bg.mA(replace)) {
                    replace = "weixin";
                }
                try {
                    i = bg.getInt(bundle.getString("extinfo"), 0);
                } catch (Exception e) {
                    i = 0;
                }
                String str2 = "MicroMsg.MMURIJumpHandler";
                String str3 = "upload log from jsapi, before upload, is-login:%b, time:%d";
                Object[] objArr2 = new Object[2];
                boolean z = ap.zb() && !ap.uP();
                objArr2[0] = Boolean.valueOf(z);
                objArr2[1] = Integer.valueOf(i);
                com.tencent.mm.sdk.platformtools.w.i(str2, str3, objArr2);
                Intent intent3 = new Intent(context, JSAPIUploadLogHelperUI.class);
                intent3.putExtra("key_user", replace);
                intent3.putExtra("key_time", i);
                context.startActivity(intent3);
            }
            return true;
        }
    }
}
