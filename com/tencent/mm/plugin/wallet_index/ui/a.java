package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.mm.opensdk.modelpay.PayReq.Options;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class a {
    public static boolean a(Context context, String str, PayResp payResp, Options options) {
        w.d("MicroMsg.PayCallbackHelper", "callback, packageName = " + str);
        String str2 = (options == null || bg.mA(options.callbackClassName)) ? str + ".wxapi.WXPayEntryActivity" : options.callbackClassName;
        int i = (options == null || options.callbackFlags == -1) ? SQLiteDatabase.CREATE_IF_NECESSARY : options.callbackFlags;
        w.d("MicroMsg.PayCallbackHelper", "callback, cbPkg = " + str + ", cbCls = " + str2 + ", cbFlags(hex) = " + Integer.toHexString(i));
        Bundle bundle = new Bundle();
        bundle.putString(Token.WX_TOKEN_KEY, Token.WX_TOKEN_VALUE_MSG);
        if (payResp != null) {
            payResp.toBundle(bundle);
        }
        Args args = new Args();
        args.targetPkgName = str;
        args.targetClassName = str2;
        args.bundle = bundle;
        args.flags = i;
        return MMessageActV2.send(context, args);
    }
}
