package com.tencent.mm.plugin.webview.wepkg.model;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

public final class f {
    private String charset = "UTF-8";
    private e sqB;
    public Map<String, WepkgPreloadFile> sqC;
    public WepkgVersion sqr;

    public f(WepkgVersion wepkgVersion, e eVar, Map<String, WepkgPreloadFile> map) {
        this.sqr = wepkgVersion;
        this.sqB = eVar;
        this.sqC = map;
        if (wepkgVersion != null && !bg.mA(wepkgVersion.charset)) {
            this.charset = wepkgVersion.charset;
        }
    }

    public final WebResourceResponse KB(String str) {
        if (bg.mA(str)) {
            return null;
        }
        if (!(this.sqC == null || this.sqC.get(str) == null)) {
            WepkgPreloadFile wepkgPreloadFile = (WepkgPreloadFile) this.sqC.get(str);
            if (!bg.mA(wepkgPreloadFile.filePath)) {
                File file = new File(wepkgPreloadFile.filePath);
                if (file.exists() && file.isFile() && file.length() == ((long) wepkgPreloadFile.size)) {
                    try {
                        w.i("MicroMsg.Wepkg.WepkgInterceptor", "rid hit preload file. rid:%s", new Object[]{str});
                        return new WebResourceResponse(wepkgPreloadFile.mimeType, this.charset, new FileInputStream(file));
                    } catch (FileNotFoundException e) {
                    }
                }
            }
        }
        return this.sqB != null ? this.sqB.ea(str, this.charset) : null;
    }
}
