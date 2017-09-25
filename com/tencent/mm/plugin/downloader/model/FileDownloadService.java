package com.tencent.mm.plugin.downloader.model;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.downloader.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;

public class FileDownloadService extends IntentService {
    public static final String EXTRA_ID = (kHb + SlookAirButtonFrequentContactAdapter.ID);
    public static final String EXTRA_PACKAGE_NAME = (kHb + "package_name");
    private static final String kHb = (FileDownloadService.class.getSimpleName() + "_extra_");
    public static final String kHc = (kHb + "action_type");
    public static final String kHd = (kHb + "file_path");
    public static final String kHe = (kHb + "md5");
    public static final String kHf = (kHb + "change_url");

    public FileDownloadService() {
        super("FileDownloadService");
    }

    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            w.i("MicroMsg.FileDownloadService", "handle intent type : %d", Integer.valueOf(intent.getIntExtra(kHc, 0)));
            String str;
            String str2;
            switch (intent.getIntExtra(kHc, 0)) {
                case 1:
                    long longExtra = intent.getLongExtra(EXTRA_ID, -1);
                    boolean booleanExtra = intent.getBooleanExtra(kHf, false);
                    if (longExtra < 0) {
                        w.e("MicroMsg.FileDownloadService", "Invalid id");
                        return;
                    }
                    if (h.vG().uV()) {
                        h.vG();
                        if (!a.uP()) {
                            com.tencent.mm.plugin.downloader.b.a ba = d.ba(longExtra);
                            if (ba == null) {
                                return;
                            }
                            if (bg.mA(ba.field_filePath) || !e.aO(ba.field_filePath)) {
                                w.i("MicroMsg.FileDownloadService", "file not exists, appid = " + ba.field_appId);
                                return;
                            } else if (bg.mA(ba.field_md5)) {
                                w.i("MicroMsg.FileDownloadService", "Invalid original md5, abort checking");
                                ba.field_status = 3;
                                d.b(ba);
                                e.akM().g(longExtra, booleanExtra);
                                return;
                            } else if (bI(ba.field_filePath, ba.field_md5)) {
                                ba.field_status = 3;
                                d.b(ba);
                                e.akM().g(longExtra, booleanExtra);
                                return;
                            } else {
                                str = "";
                                try {
                                    str = l.q(new File(ba.field_filePath));
                                } catch (Exception e) {
                                    w.e("MicroMsg.FileDownloadService", "readChannelId exception : " + e.getMessage());
                                }
                                w.i("MicroMsg.FileDownloadService", "ChannelId = %s, receivedSize = %d, fileSize = %d", str, Long.valueOf(ba.field_downloadedSize), Integer.valueOf(e.aN(ba.field_filePath)));
                                b.deleteFile(ba.field_filePath);
                                ba.field_status = 4;
                                ba.field_channelId = str;
                                ba.field_errCode = c.kGy;
                                d.b(ba);
                                if (!am.isWifi((Context) this) || booleanExtra || bg.mA(ba.field_secondaryUrl)) {
                                    e akM = e.akM();
                                    com.tencent.mm.plugin.downloader.b.a ba2 = d.ba(longExtra);
                                    if (ba2 != null) {
                                        Context context = ab.getContext();
                                        if (ba2.field_showNotification && bg.mA(ba2.field_fileName)) {
                                            str2 = ba2.field_downloadUrl;
                                            e.a(context.getString(c.kGd), "", null);
                                        } else if (ba2.field_showNotification && !bg.mA(ba2.field_fileName)) {
                                            String str3 = ba2.field_downloadUrl;
                                            e.a(ba2.field_fileName, context.getString(c.kGd), null);
                                        }
                                        akM.kGM.c(longExtra, c.kGy, booleanExtra);
                                        return;
                                    }
                                    return;
                                }
                                f.a aVar = new f.a();
                                aVar.tL(ba.field_secondaryUrl);
                                aVar.be(ba.field_fileSize);
                                aVar.tN(ba.field_fileName);
                                aVar.setAppId(ba.field_appId);
                                aVar.tO(ba.field_md5);
                                aVar.dn(true);
                                aVar.la(1);
                                aVar.bl(ba.field_packageName);
                                w.i("MicroMsg.FileDownloadService", "MD5 check failed, restart download, id = " + e.akM().a(aVar.kHa));
                                return;
                            }
                        }
                    }
                    w.d("MicroMsg.FileDownloadService", "no user login");
                    return;
                case 3:
                    str = intent.getStringExtra(kHd);
                    str2 = intent.getStringExtra(kHe);
                    if (bg.mA(str) || !e.aO(str)) {
                        w.i("MicroMsg.FileDownloadService", "Invalid file path, ignored");
                        return;
                    } else if (bg.mA(str2) || bI(str, str2)) {
                        Uri fromFile = Uri.fromFile(new File(str));
                        Intent intent2 = new Intent("android.intent.action.VIEW");
                        intent2.setDataAndType(fromFile, "application/vnd.android.package-archive");
                        intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        startActivity(intent2);
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private static boolean bI(String str, String str2) {
        File file = new File(str);
        w.i("MicroMsg.FileDownloadService", "MD5 Check: %s, File Exists: %b", str, Boolean.valueOf(file.exists()));
        long currentTimeMillis = System.currentTimeMillis();
        String f = g.f(file);
        w.i("MicroMsg.FileDownloadService", "MD5 Check Time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        w.i("MicroMsg.FileDownloadService", "Original MD5: %s, Calculated MD5: %s", str2, f);
        if (bg.mA(str2)) {
            return file.exists();
        }
        if (!bg.mA(f)) {
            return str2.equalsIgnoreCase(f);
        }
        w.i("MicroMsg.FileDownloadService", "check from file failed, may caused by low memory while checking md5");
        return file.exists();
    }
}
