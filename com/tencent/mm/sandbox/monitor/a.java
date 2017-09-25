package com.tencent.mm.sandbox.monitor;

import android.content.Intent;
import android.os.Build;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.a.c;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.a.o;
import com.tencent.mm.a.q;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sandbox.updater.AppUpdaterUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.w;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public final class a {
    static final HashMap<String, Integer> gTT;

    static {
        HashMap hashMap = new HashMap(16);
        gTT = hashMap;
        hashMap.put("exception", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
        gTT.put("anr", Integer.valueOf(CdnLogic.MediaType_FAVORITE_VIDEO));
        gTT.put("handler", Integer.valueOf(10003));
        gTT.put("sql", Integer.valueOf(10004));
        gTT.put("permission", Integer.valueOf(10005));
        gTT.put("main_thread_watch", Integer.valueOf(10006));
    }

    public static int bHL() {
        File file = new File(w.hgq + "crash/");
        if (!file.exists()) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.CrashUpload", "dkcrash checkUpload dir never create ?");
            return -1;
        } else if (file.isFile()) {
            file.delete();
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.CrashUpload", "dkcrash is the fucking file ??");
            return -1;
        } else {
            String[] list = file.list(new FilenameFilter() {
                public final boolean accept(File file, String str) {
                    return str.endsWith(".crashlog");
                }
            });
            if (list == null || list.length == 0) {
                return -1;
            }
            Pattern compile = Pattern.compile(".");
            for (CharSequence split : list) {
                String[] split2 = compile.split(split);
                if (split2 != null && split2.length > 0) {
                    eu(split2[0], split2.length >= 2 ? split2[1] : "");
                }
            }
            return 1;
        }
    }

    private static int eu(String str, String str2) {
        String str3 = w.hgq + "crash/" + str + "." + str2 + ".crashini";
        long c = bg.c(com.tencent.mm.sdk.e.a.eD(str3, "count"));
        long Nz = bg.Nz() - bg.c(com.tencent.mm.sdk.e.a.eD(str3, "lasttime"));
        String str4 = w.hgq + "crash/" + str + "." + str2 + ".crashlog";
        int aN = e.aN(str4);
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.CrashUpload", "dkcrash count:" + c + " t:" + Nz + " len:" + aN);
        if (aN < 5242880) {
            byte[] d = e.d(str4, 0, -1);
            if (!bg.bm(d)) {
                final int length = d.length;
                final String toLowerCase = g.n(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(d.sYN), Integer.valueOf(length)}).getBytes()).toLowerCase();
                d = q.l(d);
                final PByteArray pByteArray = new PByteArray();
                c.a(pByteArray, d, toLowerCase.getBytes());
                final String str5 = str2;
                final String str6 = str;
                com.tencent.mm.sdk.f.e.post(new Runnable() {
                    public final void run() {
                        StringBuilder append = new StringBuilder().append("http://" + ab.getContext().getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com")).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(d.sYN)).append("&devicetype=").append(d.DEVICE_TYPE).append("&filelength=").append(length).append("&sum=").append(toLowerCase).append("&reporttype=1&NewReportType=").append(bg.f((Integer) a.gTT.get(str5)));
                        if (!(str6 == null || str6.equals(""))) {
                            append.append("&username=").append(str6);
                        }
                        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.CrashUpload", "dkcrash sb:" + append.toString());
                        a.w(append.toString(), pByteArray.value);
                    }
                }, "CrashUpload_upload");
            }
        }
        b.deleteFile(str4);
        new com.tencent.mm.sdk.e.a(str3).cC("count", 0);
        com.tencent.mm.sdk.e.a.e(str3, "lasttime", bg.Nz());
        return 1;
    }

    public static int a(String str, String str2, a aVar) {
        if (bg.mA(aVar.toString())) {
            return -1;
        }
        File file = new File(w.hgq + "crash/");
        if (!file.exists()) {
            file.mkdir();
        }
        String str3 = w.hgq + "crash/" + str + "." + str2 + ".crashini";
        com.tencent.mm.sdk.e.a.e(str3, "count", bg.c(com.tencent.mm.sdk.e.a.eD(str3, "count")) + 1);
        if (bg.c(com.tencent.mm.sdk.e.a.eD(str3, "lasttime")) == 0) {
            com.tencent.mm.sdk.e.a.e(str3, "lasttime", bg.Nz());
        }
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.CrashUpload", "crash:[%s] len:[%d]", w.hgq + "crash/" + str + "." + str2 + ".crashlog", Integer.valueOf(aVar.toString().length()));
        a(aVar);
        a(str3, aVar);
        return eu(str, str2);
    }

    private static void a(a aVar) {
        if (aVar.upM) {
            File file = new File(com.tencent.mm.compatible.util.e.hgv);
            if (!file.exists()) {
                file.mkdirs();
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (bg.aA(file2.lastModified()) > 604800000) {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CrashUpload", "dealWithSdcardCrash del old file: %s", file2.getPath());
                        file2.delete();
                    }
                }
            }
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CrashUpload", "dealWithSdcardCrash %s", com.tencent.mm.compatible.util.e.hgv + "crash_" + new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date()) + ".txt");
            a(r0, aVar);
        }
    }

    private static void a(String str, a aVar) {
        if (!new File(str).exists()) {
            int i = ab.getContext().getSharedPreferences("system_config_prefs", 0).getInt("default_uin", 0);
            StringBuilder stringBuilder = new StringBuilder();
            if (i == 0) {
                String em = bg.em(ab.getContext());
                if (bg.mA(em)) {
                    stringBuilder.append("uin[" + Integer.toString((Build.DEVICE + Build.FINGERPRINT + Build.MANUFACTURER + Build.MODEL).hashCode()) + "] ");
                } else {
                    stringBuilder.append("uin[" + em + "] ");
                }
            } else {
                stringBuilder.append("uin[" + o.getString(i) + "] ");
            }
            stringBuilder.append(com.tencent.mm.sdk.platformtools.w.bIR());
            stringBuilder.append(" BRAND:[" + Build.BRAND + "] ");
            String[] rG = p.rG();
            stringBuilder.append("c1[" + rG[0] + "] ");
            stringBuilder.append("c2[" + rG[1] + "] ");
            stringBuilder.append("\n");
            e.e(str, stringBuilder.toString().getBytes());
        }
        if (e.aN(str) > 10485760) {
            b.deleteFile(str);
        }
        e.e(str, (aVar.toString() + "\n").getBytes());
    }

    public static void w(String str, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.CrashUpload", "doPost : url = " + str + ", data.length = " + bArr.length);
        HttpClient defaultHttpClient = new DefaultHttpClient();
        HttpUriRequest httpPost = new HttpPost(str);
        try {
            HttpEntity byteArrayEntity = new ByteArrayEntity(bArr);
            byteArrayEntity.setContentType("binary/octet-stream");
            httpPost.setEntity(byteArrayEntity);
            String convertStreamToString = bg.convertStreamToString(defaultHttpClient.execute(httpPost).getEntity().getContent());
            if (convertStreamToString != null && convertStreamToString.length() > 0) {
                final Map q = bh.q(convertStreamToString, "Response");
                if (!(q == null || !"-1000".equalsIgnoreCase((String) q.get(".Response.retCode")) || q.get(".Response.url") == null)) {
                    new Timer().schedule(new TimerTask() {
                        public final void run() {
                            Intent intent = new Intent(ab.getContext(), AppUpdaterUI.class);
                            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            intent.putExtra("intent_extra_desc", (String) q.get(".Response.desc"));
                            intent.putExtra("intent_update_type", 999);
                            intent.putExtra("intent_extra_download_url", new String[]{(String) q.get(".Response.url")});
                            ab.getContext().startActivity(intent);
                        }
                    }, 500);
                }
            }
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.CrashUpload", convertStreamToString);
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.CrashUpload", "doPost: returnConnection = %s", convertStreamToString);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.CrashUpload", e, "", new Object[0]);
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.CrashUpload", "doPost e type: %s, msg: %s", e.getClass().getSimpleName(), e.getMessage());
        }
    }
}
