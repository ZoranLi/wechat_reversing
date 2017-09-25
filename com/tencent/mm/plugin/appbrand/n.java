package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public enum n {
    ;

    public static String nv(String str) {
        return String.format(Locale.US, "https://mp.weixin.qq.com/mp/waerrpage?appid=%s&type=overseas#wechat_redirect", new Object[]{str});
    }

    public static String a(WxaExposedParams wxaExposedParams) {
        String str = "";
        if (wxaExposedParams == null || bg.mA(wxaExposedParams.appId)) {
            w.e("MicroMsg.AppBrandUrlBuilders", "buildExposeUrl fail, null or nil appId");
        } else {
            try {
                str = String.format("https://mp.weixin.qq.com/mp/wacomplain?action=show&appid=%s&pageid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect", new Object[]{wxaExposedParams.appId, p.encode(bg.mz(wxaExposedParams.iGe), "UTF-8"), Integer.valueOf(wxaExposedParams.fFr), Integer.valueOf(bg.n(Integer.valueOf(wxaExposedParams.izV), -1)), Integer.valueOf(bg.n(Integer.valueOf(wxaExposedParams.izW), -1))});
            } catch (UnsupportedEncodingException e) {
                w.e("MicroMsg.AppBrandUrlBuilders", "buildExposeUrl encode fail, invalid arguments");
            }
        }
        return str;
    }

    public static String nw(String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.AppBrandUrlBuilders", "buildEntityUrl fail, null or nil appId");
            return "";
        }
        return String.format("https://mp.weixin.qq.com/mp/waverifyinfo?action=get&appid=%s#wechat_redirect", new Object[]{str});
    }

    public static String nx(String str) {
        return N(str, 3);
    }

    public static String N(String str, int i) {
        if (bg.mA(str)) {
            w.e("MicroMsg.AppBrandUrlBuilders", "buildLowVersionUrl fail, invalid arguments");
            return "";
        }
        return String.format(Locale.US, "https://mp.weixin.qq.com/mp/waerrpage?appid=%s&type=upgrade&upgradetype=%d#wechat_redirect", new Object[]{str, Integer.valueOf(i)});
    }
}
