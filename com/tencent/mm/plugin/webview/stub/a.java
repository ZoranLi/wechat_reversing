package com.tencent.mm.plugin.webview.stub;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class a {
    public static final boolean dc(Context context) {
        try {
            PackageInfo az = s.az(context, "com.tencent.mobileqq");
            String str = "MicroMsg.ConstantsWebViewStub";
            String str2 = "isQQSupportShare(%s).";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(az != null);
            w.d(str, str2, objArr);
            if (az != null) {
                return true;
            }
        } catch (Exception e) {
            w.e("MicroMsg.ConstantsWebViewStub", "exception has occurred in isQQSupportShare(), e : %s.", new Object[]{e.getMessage()});
        }
        return false;
    }

    public static final boolean aK(Context context, String str) {
        if (bg.mA(str)) {
            return false;
        }
        try {
            PackageInfo az = s.az(context, "com.tencent.weread");
            String str2 = "MicroMsg.ConstantsWebViewStub";
            String str3 = "isWeReadSupportShare(%s).";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(az != null);
            w.d(str2, str3, objArr);
            if (az == null || !Uri.parse(str).getHost().startsWith("mp.weixin.qq.com") || az.versionCode <= 2000812) {
                return false;
            }
            return true;
        } catch (Exception e) {
            w.e("MicroMsg.ConstantsWebViewStub", "exception has occurred in isQzoneSupportShare(), e : %s.", new Object[]{e.getMessage()});
            return false;
        }
    }
}
