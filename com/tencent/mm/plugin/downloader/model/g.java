package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.plugin.downloader.b.a;
import com.tencent.mm.sdk.platformtools.w;
import java.net.HttpURLConnection;
import java.net.URL;

public final class g {
    public static String tP(String str) {
        Exception exception;
        Throwable th;
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection2 != null) {
                try {
                    httpURLConnection2.setConnectTimeout(1000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    int responseCode = httpURLConnection2.getResponseCode();
                    w.i("MicroMsg.FileDownloadUtil", "code : %d, md5 : %s", Integer.valueOf(responseCode), httpURLConnection2.getHeaderField("Weixin-File-MD5"));
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return r1;
                } catch (Exception e) {
                    Exception exception2 = e;
                    httpURLConnection = httpURLConnection2;
                    exception = exception2;
                    try {
                        w.e("MicroMsg.FileDownloadUtil", "get recirect location failed : %s", exception.getMessage());
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return "";
                    } catch (Throwable th2) {
                        th = th2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    httpURLConnection = httpURLConnection2;
                    th = th4;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            return "";
        } catch (Exception e2) {
            exception = e2;
            w.e("MicroMsg.FileDownloadUtil", "get recirect location failed : %s", exception.getMessage());
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return "";
        }
    }

    public static a b(f fVar) {
        a aVar = new a();
        aVar.field_downloadUrl = fVar.iyZ;
        aVar.field_secondaryUrl = fVar.kGS;
        aVar.field_fileSize = fVar.kGT;
        aVar.field_downloadUrlHashCode = fVar.iyZ.hashCode();
        aVar.field_fileName = fVar.mFileName;
        aVar.field_fileType = fVar.kGV;
        aVar.field_md5 = fVar.kGU;
        aVar.field_appId = fVar.ivH;
        aVar.field_autoInstall = fVar.kGW;
        aVar.field_showNotification = fVar.kGX;
        aVar.field_packageName = fVar.fwY;
        aVar.field_autoDownload = fVar.kGZ;
        aVar.field_scene = fVar.hPi;
        return aVar;
    }
}
