package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Properties;

public final class q {
    private static q wYt = null;
    private Context mContext = null;
    private String wYA = "http://mqqad.html5.qq.com/adjs";
    private String wYB = "http://log.tbs.qq.com/ajax?c=ucfu&k=";
    private File wYs = null;
    public String wYu = "http://log.tbs.qq.com/ajax?c=pu&v=2&k=";
    public String wYv = "http://log.tbs.qq.com/ajax?c=pu&tk=";
    private String wYw = "http://wup.imtt.qq.com:8080";
    public String wYx = "http://log.tbs.qq.com/ajax?c=dl&k=";
    public String wYy = "http://cfg.imtt.qq.com/tbs?v=2&mk=";
    public String wYz = "http://log.tbs.qq.com/ajax?c=ul&v=2&k=";

    @TargetApi(11)
    private q(Context context) {
        TbsLog.w("TbsCommonConfig", "TbsCommonConfig constructing...");
        this.mContext = context.getApplicationContext();
        cfx();
    }

    public static synchronized q cfw() {
        q qVar;
        synchronized (q.class) {
            qVar = wYt;
        }
        return qVar;
    }

    private synchronized void cfx() {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        Writer stringWriter;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            File cfy = cfy();
            if (cfy == null) {
                TbsLog.e("TbsCommonConfig", "Config file is null, default values will be applied");
            } else {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(cfy));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream);
                    String property = properties.getProperty("pv_post_url", "");
                    if (!"".equals(property)) {
                        this.wYu = property;
                    }
                    property = properties.getProperty("wup_proxy_domain", "");
                    if (!"".equals(property)) {
                        this.wYw = property;
                    }
                    property = properties.getProperty("tbs_download_stat_post_url", "");
                    if (!"".equals(property)) {
                        this.wYx = property;
                    }
                    property = properties.getProperty("tbs_downloader_post_url", "");
                    if (!"".equals(property)) {
                        this.wYy = property;
                    }
                    property = properties.getProperty("tbs_log_post_url", "");
                    if (!"".equals(property)) {
                        this.wYz = property;
                    }
                    property = properties.getProperty("tips_url", "");
                    if (!"".equals(property)) {
                        this.wYA = property;
                    }
                    property = properties.getProperty("tbs_cmd_post_url", "");
                    if (!"".equals(property)) {
                        this.wYB = property;
                    }
                    String property2 = properties.getProperty("pv_post_url_tk", "");
                    if (!"".equals(property2)) {
                        this.wYv = property2;
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th;
        }
        return;
    }

    private File cfy() {
        File file;
        Throwable th;
        Writer stringWriter;
        try {
            if (this.wYs == null) {
                this.wYs = new File(f.al(this.mContext, 5));
                if (this.wYs == null || !this.wYs.isDirectory()) {
                    return null;
                }
            }
            file = new File(this.wYs, "tbsnet.conf");
            if (file.exists()) {
                try {
                    TbsLog.w("TbsCommonConfig", "pathc:" + file.getCanonicalPath());
                    return file;
                } catch (Throwable th2) {
                    th = th2;
                    stringWriter = new StringWriter();
                    th.printStackTrace(new PrintWriter(stringWriter));
                    TbsLog.e("TbsCommonConfig", "exceptions occurred2:" + stringWriter.toString());
                    return file;
                }
            }
            TbsLog.e("TbsCommonConfig", "Get file(" + file.getCanonicalPath() + ") failed!");
            return null;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            file = null;
            th = th4;
            stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            TbsLog.e("TbsCommonConfig", "exceptions occurred2:" + stringWriter.toString());
            return file;
        }
    }

    public static synchronized q gZ(Context context) {
        q qVar;
        synchronized (q.class) {
            if (wYt == null) {
                wYt = new q(context);
            }
            qVar = wYt;
        }
        return qVar;
    }
}
