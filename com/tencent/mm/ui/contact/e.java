package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.bb.d;
import com.tencent.mm.modelfriend.ad;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au.a;
import com.tencent.mm.storage.x;

public final class e {
    public static void l(Intent intent, String str) {
        intent.putExtra("Contact_User", str);
    }

    public static void a(Intent intent, String str) {
        if (intent == null || str == null || str.length() == 0) {
            w.e("MicroMsg.ContactInfoUtil", "setLocalQQMobile fail, intent = " + intent + ", username = " + str);
            return;
        }
        ad jk = af.Gd().jk(str);
        if (jk != null) {
            intent.putExtra("Contact_Uin", jk.hCb);
            intent.putExtra("Contact_QQNick", jk.getDisplayName());
        }
        b iZ = af.FY().iZ(str);
        if (iZ != null) {
            intent.putExtra("Contact_Mobile_MD5", iZ.EP());
        }
    }

    public static void a(Context context, a aVar) {
        a(context, aVar, false, false, null);
    }

    public static void a(Context context, a aVar, boolean z, boolean z2, Bundle bundle) {
        if (context != null && aVar != null) {
            x xVar = new x();
            xVar.setUsername(aVar.rUK);
            xVar.bR(aVar.getDisplayName());
            xVar.bS(aVar.hCe);
            xVar.bT(aVar.hCf);
            a(context, xVar, aVar, z, z2, bundle, aVar.ovd);
        }
    }

    public static void a(Context context, x xVar, a aVar) {
        a(context, xVar, aVar, false, false, null, aVar.ovd);
    }

    public static void a(Context context, x xVar, a aVar, boolean z, boolean z2, Bundle bundle, String str) {
        if (xVar != null && aVar != null && xVar.field_username != null && xVar.field_username.length() > 0) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", xVar.field_username);
            intent.putExtra("Contact_Alias", xVar.pA());
            intent.putExtra("Contact_Nick", xVar.tK());
            intent.putExtra("Contact_QuanPin", xVar.pC());
            intent.putExtra("Contact_PyInitial", xVar.pB());
            intent.putExtra("Contact_Sex", aVar.gkr);
            intent.putExtra("Contact_Province", aVar.getProvince());
            intent.putExtra("Contact_City", aVar.getCity());
            intent.putExtra("Contact_Signature", aVar.signature);
            intent.putExtra("Contact_Uin", aVar.ovb);
            intent.putExtra("Contact_Mobile_MD5", aVar.uJX);
            intent.putExtra("Contact_full_Mobile_MD5", aVar.uJY);
            intent.putExtra("Contact_QQNick", aVar.bMH());
            intent.putExtra("User_From_Fmessage", true);
            intent.putExtra("Contact_Scene", aVar.scene);
            intent.putExtra("Contact_from_msgType", 40);
            if (z) {
                intent.putExtra("Contact_ShowUserName", false);
            }
            if (z2) {
                intent.putExtra("Contact_KSnsIFlag", 0);
            }
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("verify_gmail", str);
            }
            d.b(context, "profile", ".ui.ContactInfoUI", intent);
        }
    }
}
