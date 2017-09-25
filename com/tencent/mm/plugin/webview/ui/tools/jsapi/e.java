package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Base64;
import com.tencent.mm.a.m;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.widget.MMWebView;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public final class e implements b {
    private MMWebView qjb;
    private d sir;
    private d sis;
    private int skl;

    public e(MMWebView mMWebView, d dVar, int i, d dVar2) {
        this.qjb = mMWebView;
        this.sir = dVar;
        this.skl = i;
        this.sis = dVar2;
    }

    public final boolean xL(String str) {
        if (bg.mA(str)) {
            return false;
        }
        return s.eq(str, "weixin://private/setresult/");
    }

    public final boolean xM(String str) {
        String str2 = null;
        if (this.qjb != null) {
            this.qjb.evaluateJavascript("javascript:WeixinJSBridge._continueSetResult()", null);
        }
        String substring = str.substring(27);
        if (bg.mA(substring)) {
            w.e("MicroMsg.JsApiResultHandler", "SetResultHandler handleUrl fail, value is null");
            return false;
        }
        int indexOf = substring.indexOf("&");
        if (indexOf <= 0) {
            w.e("MicroMsg.JsApiResultHandler", "SetResultHandler, handleUrl fail, invalid splitorIdx = %d", new Object[]{Integer.valueOf(indexOf)});
            return false;
        }
        byte[] decode;
        String substring2 = substring.substring(0, indexOf);
        try {
            decode = Base64.decode(substring.substring(indexOf + 1), 0);
        } catch (Exception e) {
            w.e("MicroMsg.JsApiResultHandler", "SetResultHandler decodeBase64 failed");
            decode = null;
        }
        substring = decode == null ? null : new String(decode);
        w.i("MicroMsg.JsApiResultHandler", "SetResultHandler, scene = %s, result = %s", new Object[]{substring2, substring});
        if ("SCENE_HANDLEMSGFROMWX".equals(substring2) && substring != null) {
            String substring3;
            if (substring.startsWith("wxGetAllHosts:")) {
                substring3 = substring.substring(14);
            } else if (substring.startsWith("\"wxGetAllHosts:")) {
                substring3 = substring.substring(15, substring.length() - 1);
            } else {
                substring3 = null;
            }
            if (substring3 != null) {
                Map A = A(substring3.split("\\,"));
                String Ke = Ke("hosts");
                if (!m(Ke, A)) {
                    w.e("MicroMsg.JsApiResultHandler", "failed to write Hosts file");
                } else if (!(this.sir == null || this.qjb == null)) {
                    try {
                        this.sir.t(0, this.qjb.getUrl(), Ke);
                    } catch (RemoteException e2) {
                        w.e("MicroMsg.JsApiResultHandler", "uploadFileToCDN error ", new Object[]{e2.getMessage()});
                    }
                }
            }
            if (substring.startsWith("wxGetHtmlContent:")) {
                str2 = substring.substring(17);
            } else if (substring.startsWith("\"wxGetHtmlContent:")) {
                str2 = substring.substring(18, substring.length() - 1);
            }
            if (str2 != null) {
                substring3 = Ke("html");
                if (!dX(substring3, str2)) {
                    w.e("MicroMsg.JsApiResultHandler", "failed to write Html file");
                } else if (!(this.sir == null || this.qjb == null)) {
                    try {
                        this.sir.t(1, this.qjb.getUrl(), substring3);
                    } catch (RemoteException e3) {
                        w.e("MicroMsg.JsApiResultHandler", "uploadFileToCDN error ", new Object[]{e3.getMessage()});
                    }
                }
            }
            if (!(this.sir == null || this.qjb == null || this.qjb.wwS || com.tencent.mm.compatible.util.d.eo(19) || !substring.contains("isWNNoteValueResult"))) {
                w.i("MicroMsg.JsApiResultHandler", "WNNoteValueResult dispos, value = %s", new Object[]{substring});
                Bundle bundle = new Bundle();
                bundle.putString("ExportData", substring);
                try {
                    this.sir.d(52, bundle);
                } catch (Exception e4) {
                    w.w("MicroMsg.JsApiResultHandler", "WNNoteValueResult dispos error ", new Object[]{e4.getMessage()});
                }
            }
        }
        this.sis.keep_setReturnValue(substring2, substring);
        return true;
    }

    private static Map<String, Integer> A(String[] strArr) {
        int length = strArr == null ? 0 : strArr.length;
        if (length == 0) {
            return null;
        }
        Map<String, Integer> hashMap = new HashMap();
        for (int i = 0; i < length; i++) {
            if (hashMap.keySet().contains(strArr[i])) {
                hashMap.put(strArr[i], Integer.valueOf(((Integer) hashMap.get(strArr[i])).intValue() + 1));
            } else {
                hashMap.put(strArr[i], Integer.valueOf(1));
            }
        }
        return hashMap;
    }

    private String Ke(String str) {
        if (this.qjb == null) {
            return null;
        }
        String url = this.qjb.getUrl();
        try {
            w.i("MicroMsg.JsApiResultHandler", "generate upload file name, url=%s, tag=%s, fullName=%s", new Object[]{url, str, com.tencent.mm.compatible.util.e.gSC + m.aX(url + str)});
            return com.tencent.mm.compatible.util.e.gSC + m.aX(url + str);
        } catch (Throwable e) {
            w.e("MicroMsg.JsApiResultHandler", "generating temp file name failed, url is " + url);
            w.printErrStackTrace("MicroMsg.JsApiResultHandler", e, "", new Object[0]);
            return null;
        }
    }

    private static boolean m(String str, Map<String, Integer> map) {
        Throwable e;
        OutputStream bufferedOutputStream;
        if (bg.mA(str) || map == null) {
            w.w("MicroMsg.JsApiResultHandler", "write to file error, path is null or empty, or data is empty");
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable e2) {
                w.e("MicroMsg.JsApiResultHandler", "creating file failed, filePath is " + str);
                w.printErrStackTrace("MicroMsg.JsApiResultHandler", e2, "", new Object[0]);
                return false;
            }
        }
        OutputStream outputStream = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str, true));
            try {
                for (String str2 : map.keySet()) {
                    bufferedOutputStream.write((((Integer) map.get(str2)).intValue() + " " + str2).getBytes());
                    bufferedOutputStream.write(13);
                    bufferedOutputStream.write(10);
                }
                bufferedOutputStream.flush();
                try {
                    bufferedOutputStream.close();
                } catch (Throwable e22) {
                    w.printErrStackTrace("MicroMsg.JsApiResultHandler", e22, "", new Object[0]);
                }
                w.d("MicroMsg.JsApiResultHandler", "writeToFile ok! " + str);
                return true;
            } catch (Exception e3) {
                e22 = e3;
                outputStream = bufferedOutputStream;
                try {
                    w.printErrStackTrace("MicroMsg.JsApiResultHandler", e22, "", new Object[0]);
                    w.w("MicroMsg.JsApiResultHandler", "write to file error");
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable e222) {
                            w.printErrStackTrace("MicroMsg.JsApiResultHandler", e222, "", new Object[0]);
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    e222 = th;
                    bufferedOutputStream = outputStream;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable e4) {
                            w.printErrStackTrace("MicroMsg.JsApiResultHandler", e4, "", new Object[0]);
                        }
                    }
                    throw e222;
                }
            } catch (Throwable th2) {
                e222 = th2;
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                throw e222;
            }
        } catch (Exception e5) {
            e222 = e5;
            w.printErrStackTrace("MicroMsg.JsApiResultHandler", e222, "", new Object[0]);
            w.w("MicroMsg.JsApiResultHandler", "write to file error");
            if (outputStream != null) {
                outputStream.close();
            }
            return false;
        } catch (Throwable th3) {
            e222 = th3;
            bufferedOutputStream = null;
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            throw e222;
        }
    }

    private static boolean dX(String str, String str2) {
        if (bg.mA(str) || bg.mA(str2)) {
            w.w("MicroMsg.JsApiResultHandler", "write to file error, path is null or empty, or data is empty");
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable e) {
                Throwable e2;
                w.e("MicroMsg.JsApiResultHandler", "creating file failed, filePath is " + str);
                w.printErrStackTrace("MicroMsg.JsApiResultHandler", e2, "", new Object[0]);
                return false;
            }
        }
        OutputStream outputStream = null;
        try {
            OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str, true));
            try {
                outputStream = new FileOutputStream(str);
                outputStream.write(str2.getBytes());
                outputStream.write(13);
                outputStream.write(10);
                outputStream.flush();
                try {
                    outputStream.close();
                } catch (Throwable e3) {
                    w.printErrStackTrace("MicroMsg.JsApiResultHandler", e3, "", new Object[0]);
                }
                w.d("MicroMsg.JsApiResultHandler", "writeToFile ok! " + str);
                return true;
            } catch (Exception e4) {
                e2 = e4;
                outputStream = bufferedOutputStream;
                try {
                    w.printErrStackTrace("MicroMsg.JsApiResultHandler", e2, "", new Object[0]);
                    w.w("MicroMsg.JsApiResultHandler", "write to file error");
                    if (outputStream != null) {
                        return false;
                    }
                    try {
                        outputStream.close();
                        return false;
                    } catch (Throwable e22) {
                        w.printErrStackTrace("MicroMsg.JsApiResultHandler", e22, "", new Object[0]);
                        return false;
                    }
                } catch (Throwable th) {
                    e22 = th;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable e32) {
                            w.printErrStackTrace("MicroMsg.JsApiResultHandler", e32, "", new Object[0]);
                        }
                    }
                    throw e22;
                }
            } catch (Throwable th2) {
                e22 = th2;
                outputStream = bufferedOutputStream;
                if (outputStream != null) {
                    outputStream.close();
                }
                throw e22;
            }
        } catch (Exception e5) {
            e22 = e5;
            w.printErrStackTrace("MicroMsg.JsApiResultHandler", e22, "", new Object[0]);
            w.w("MicroMsg.JsApiResultHandler", "write to file error");
            if (outputStream != null) {
                return false;
            }
            outputStream.close();
            return false;
        }
    }
}
