package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.transmit.SelectConversationUI;

public final class s {

    public interface c {
        boolean a(String str, Context context, q qVar, String str2);
    }

    static final class a implements c {
        a() {
        }

        public final boolean a(String str, Context context, q qVar, String str2) {
            if (str.startsWith("weixin://openNativeUrl/weixinHB/startsendnormalhbrequest")) {
                Intent intent = new Intent();
                intent.putExtra("key_type", 0);
                com.tencent.mm.bb.d.b(context, "luckymoney", ".ui.LuckyMoneyPrepareUI", intent);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/weixinHB/startsendrandomhbrequest")) {
                r1 = new Intent();
                r1.putExtra("key_type", 1);
                com.tencent.mm.bb.d.b(context, "luckymoney", ".ui.LuckyMoneyPrepareUI", r1);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/weixinHB/startsendhblistrequest")) {
                r1 = new Intent();
                r1.putExtra("key_type", 1);
                com.tencent.mm.bb.d.b(context, "luckymoney", ".ui.LuckyMoneyMyRecordUI", r1);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/weixinHB/startreceivehblistrequest")) {
                r1 = new Intent();
                r1.putExtra("key_type", 2);
                com.tencent.mm.bb.d.b(context, "luckymoney", ".ui.LuckyMoneyMyRecordUI", r1);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/weixinHB/openDetail")) {
                r1 = new Intent();
                r1.putExtra("key_native_url", str);
                com.tencent.mm.bb.d.b(context, "luckymoney", ".ui.LuckyMoneyDetailUI", r1);
                return true;
            } else if (!str.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
                return false;
            } else {
                r1 = new Intent();
                r1.putExtra("key_way", 5);
                r1.putExtra("key_native_url", str);
                r1.putExtra("key_static_from_scene", 1);
                com.tencent.mm.bb.d.b(context, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", r1);
                return true;
            }
        }
    }

    static final class b implements c {
        b() {
        }

        public final boolean a(String str, Context context, q qVar, String str2) {
            if (bg.mA(str)) {
                return false;
            }
            if (!str.startsWith("weixin://openNativeUrl/myDeviceList")) {
                return str.startsWith("weixin://openNativeUrl/bindMyDevice") ? false : false;
            } else {
                Intent intent = new Intent();
                intent.putExtra("device_brand_name", str2);
                com.tencent.mm.bb.d.b(context, "exdevice", ".ui.ExdeviceManageDeviceUI", intent);
                return true;
            }
        }
    }

    static final class d implements c {
        d() {
        }

        public final boolean a(String str, Context context, q qVar, String str2) {
            if (bg.mA(str)) {
                w.d("MicroMsg.BizNativeUrlDispatcher", "nativeUrl is null.");
                return false;
            } else if (str.startsWith("weixin://wesport/recommend") && qVar != null) {
                r0 = new Intent(context, SelectConversationUI.class);
                r0.putExtra("Select_Talker_Name", str2);
                r0.putExtra("Select_block_List", str2);
                r0.putExtra("Select_Conv_Type", 3);
                r0.putExtra("Select_Send_Card", true);
                qVar.startActivityForResult(r0, 224);
                return true;
            } else if (str.startsWith("weixin://openNativeUrl/rankMyHomepage")) {
                String xL = m.xL();
                if (bg.mA(xL)) {
                    w.e("MicroMsg.BizNativeUrlDispatcher", "Get username from UserInfo return null or nil.");
                    return false;
                }
                r0 = new Intent();
                r0.putExtra("username", xL);
                com.tencent.mm.bb.d.b(context, "exdevice", ".ui.ExdeviceProfileUI", r0);
                w.i("MicroMsg.BizNativeUrlDispatcher", "Jump to ExdeviceProfileUI.");
                return true;
            } else if (!str.startsWith("weixin://openNativeUrl/rankSetting")) {
                return false;
            } else {
                com.tencent.mm.bb.d.w(context, "exdevice", ".ui.ExdeviceSettingUI");
                return true;
            }
        }
    }

    public static boolean a(String str, Context context, q qVar, String str2) {
        if (bg.mA(str)) {
            return false;
        }
        c cVar = null;
        if (str.startsWith("weixin://openNativeUrl/weixinHB")) {
            cVar = new a();
        } else {
            boolean z;
            if (str == null || !(str.startsWith("weixin://openNativeUrl/myDeviceList") || str.startsWith("weixin://openNativeUrl/bindMyDevice"))) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                cVar = new b();
            } else {
                if (str == null || !(str.startsWith("weixin://wesport/recommend") || str.startsWith("weixin://openNativeUrl/rankMyHomepage") || str.startsWith("weixin://openNativeUrl/rankSetting"))) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    cVar = new d();
                }
            }
        }
        if (cVar == null || !cVar.a(str, context, qVar, str2)) {
            return false;
        }
        return true;
    }
}
