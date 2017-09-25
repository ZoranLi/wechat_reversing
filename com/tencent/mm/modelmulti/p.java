package com.tencent.mm.modelmulti;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Debug.MemoryInfo;
import android.os.PowerManager;
import android.os.Process;
import android.os.StatFs;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.e.a.lc;
import com.tencent.mm.modelmulti.c.a;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import com.tencent.mm.plugin.report.kvdata.BDStatusInfo;
import com.tencent.mm.plugin.report.kvdata.HeavyDetailInfo;
import com.tencent.mm.plugin.report.kvdata.SDStatusInfo;
import com.tencent.mm.plugin.report.kvdata.SubDirInfo;
import com.tencent.mm.plugin.report.kvdata.TableInfo;
import com.tencent.mm.plugin.report.kvdata.WeChatSDInfo;
import com.tencent.mm.plugin.report.kvdata.log_14375;
import com.tencent.mm.plugin.report.service.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class p implements am {
    private static final long startTime = System.currentTimeMillis();
    long hLA = 10;
    long hLB = 1800;
    long hLC = 3000000;
    long hLD = 15000;
    long hLE = 100000;
    long hLF = 10000;
    long hLG = AppSupportContentFlag.MMAPP_SUPPORT_XLS;
    public long hLH = 1440;
    public long hLI = 20;
    long hLJ = 1440;
    private BroadcastReceiver hLK;
    public boolean hLL = false;
    public boolean hLM = true;
    public long hLN = 0;
    public Runnable hLO;
    public a hLP;
    public long hLQ = 0;
    private e hLR = new e(this) {
        final /* synthetic */ p hLW;

        {
            this.hLW = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            String str2 = "MicroMsg.SubCoreBaseMonitor";
            String str3 = "summerhv onIDKeyCallback onSceneEnd[%d][%d, %d, %s]";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(kVar == null ? -1 : kVar.getType());
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = str;
            w.i(str2, str3, objArr);
            if (i == 0 && i2 == 0) {
                d.aXG();
            }
        }
    };
    public Runnable hLS = new Runnable(this) {
        final /* synthetic */ p hLW;

        {
            this.hLW = r1;
        }

        public final void run() {
            w.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportAllRunnable run");
            p pVar = this.hLW;
            ap.yY();
            long longValue = ((Long) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_REPORT_SD_STATUS_TIME_LONG, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 259200000 || longValue > currentTimeMillis) {
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.USERINFO_REPORT_SD_STATUS_TIME_LONG, Long.valueOf(currentTimeMillis));
                com.tencent.mm.sdk.f.e.post(new Runnable(pVar) {
                    final /* synthetic */ p hLW;

                    {
                        this.hLW = r1;
                    }

                    public final void run() {
                        try {
                            int round;
                            long j;
                            long j2;
                            long j3;
                            long j4;
                            long j5;
                            int i;
                            int i2;
                            File file = new File(com.tencent.mm.storage.w.hgq + "SdcardInfo.cfg");
                            g.oUh.a(340, file.exists() ? 10 : 11, 1, true);
                            boolean bJF = av.bJF();
                            String path = h.getDataDirectory().getPath();
                            String path2 = h.getExternalStorageDirectory().getPath();
                            StatFs statFs = new StatFs(path);
                            long blockSize = (long) statFs.getBlockSize();
                            long blockCount = (long) statFs.getBlockCount();
                            long availableBlocks = (long) statFs.getAvailableBlocks();
                            long j6 = blockSize * blockCount;
                            long j7 = blockSize * availableBlocks;
                            if (blockCount > 0) {
                                round = Math.round((float) ((100 * availableBlocks) / blockCount));
                            } else {
                                round = -1;
                            }
                            statFs = new StatFs(path2);
                            long blockSize2 = (long) statFs.getBlockSize();
                            long blockCount2 = (long) statFs.getBlockCount();
                            long availableBlocks2 = (long) statFs.getAvailableBlocks();
                            long j8 = blockSize2 * blockCount2;
                            long j9 = blockSize2 * availableBlocks2;
                            int i3 = -1;
                            if (blockCount2 > 0) {
                                i3 = Math.round((float) ((100 * availableBlocks2) / blockCount2));
                            }
                            boolean equals = com.tencent.mm.compatible.util.e.hgs.equals(path2);
                            if (equals) {
                                j = j9;
                                j2 = j8;
                                j3 = availableBlocks2;
                                j4 = blockCount2;
                                j5 = blockSize2;
                                i = i3;
                            } else {
                                statFs = new StatFs(com.tencent.mm.compatible.util.e.hgs);
                                long blockSize3 = (long) statFs.getBlockSize();
                                long blockCount3 = (long) statFs.getBlockCount();
                                long availableBlocks3 = (long) statFs.getAvailableBlocks();
                                long j10 = blockSize3 * blockCount3;
                                long j11 = blockSize3 * availableBlocks3;
                                if (blockCount3 > 0) {
                                    j2 = j10;
                                    j3 = availableBlocks3;
                                    j4 = blockCount3;
                                    j5 = blockSize3;
                                    i = Math.round((float) ((100 * availableBlocks3) / blockCount3));
                                    j = j11;
                                } else {
                                    j = j11;
                                    j2 = j10;
                                    j3 = availableBlocks3;
                                    j4 = blockCount3;
                                    j5 = blockSize3;
                                    i = i3;
                                }
                            }
                            String PE = av.PE(com.tencent.mm.compatible.util.e.hgs);
                            String PE2 = av.PE(path);
                            String str = "MicroMsg.SubCoreBaseMonitor";
                            String str2 = "summerStorage [%s, %s, %s] [%s] [%b] [%d,%d,%d,%d,%d,%d] [%d,%d,%d,%d,%d,%d] [%b] [%d,%d,%d,%d,%d,%d], [%d][%s]";
                            Object[] objArr = new Object[26];
                            objArr[0] = path;
                            objArr[1] = path2;
                            objArr[2] = com.tencent.mm.compatible.util.e.hgs;
                            objArr[3] = PE;
                            objArr[4] = Boolean.valueOf(bJF);
                            objArr[5] = Long.valueOf(blockSize);
                            objArr[6] = Long.valueOf(blockCount);
                            objArr[7] = Long.valueOf(availableBlocks);
                            objArr[8] = Long.valueOf(j6);
                            objArr[9] = Long.valueOf(j7);
                            objArr[10] = Integer.valueOf(round);
                            objArr[11] = Long.valueOf(blockSize2);
                            objArr[12] = Long.valueOf(blockCount2);
                            objArr[13] = Long.valueOf(availableBlocks2);
                            objArr[14] = Long.valueOf(j8);
                            objArr[15] = Long.valueOf(j9);
                            objArr[16] = Integer.valueOf(i3);
                            objArr[17] = Boolean.valueOf(equals);
                            objArr[18] = Long.valueOf(j5);
                            objArr[19] = Long.valueOf(j4);
                            objArr[20] = Long.valueOf(j3);
                            objArr[21] = Long.valueOf(j2);
                            objArr[22] = Long.valueOf(j);
                            objArr[23] = Integer.valueOf(i);
                            if (file.exists()) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            objArr[24] = Integer.valueOf(i2);
                            objArr[25] = PE2;
                            w.i(str, str2, objArr);
                            g.oUh.a(340, 0, 1, true);
                            g.oUh.a(340, bJF ? 1 : 2, 1, true);
                            g.oUh.a(340, equals ? 3 : 4, 1, true);
                            g gVar = g.oUh;
                            objArr = new Object[2];
                            objArr[0] = Integer.valueOf(Downloads.MIN_RETYR_AFTER);
                            String str3 = "%s;%s;%s;%s;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%d;%s";
                            Object[] objArr2 = new Object[26];
                            objArr2[0] = path;
                            objArr2[1] = path2;
                            objArr2[2] = com.tencent.mm.compatible.util.e.hgs;
                            objArr2[3] = PE;
                            objArr2[4] = Integer.valueOf(bJF ? 1 : 0);
                            objArr2[5] = Long.valueOf(blockSize);
                            objArr2[6] = Long.valueOf(blockCount);
                            objArr2[7] = Long.valueOf(availableBlocks);
                            objArr2[8] = Long.valueOf(j6);
                            objArr2[9] = Long.valueOf(j7);
                            objArr2[10] = Integer.valueOf(round);
                            objArr2[11] = Long.valueOf(blockSize2);
                            objArr2[12] = Long.valueOf(blockCount2);
                            objArr2[13] = Long.valueOf(availableBlocks2);
                            objArr2[14] = Long.valueOf(j8);
                            objArr2[15] = Long.valueOf(j9);
                            objArr2[16] = Integer.valueOf(i3);
                            objArr2[17] = Integer.valueOf(equals ? 1 : 0);
                            objArr2[18] = Long.valueOf(j5);
                            objArr2[19] = Long.valueOf(j4);
                            objArr2[20] = Long.valueOf(j3);
                            objArr2[21] = Long.valueOf(j2);
                            objArr2[22] = Long.valueOf(j);
                            objArr2[23] = Integer.valueOf(i);
                            if (file.exists()) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            objArr2[24] = Integer.valueOf(i2);
                            objArr2[25] = PE2;
                            objArr[1] = String.format(str3, objArr2);
                            gVar.i(11098, objArr);
                            g.oUh.i(11098, Integer.valueOf(5001), path + ";" + PE2);
                            g.oUh.i(11098, Integer.valueOf(5002), com.tencent.mm.compatible.util.e.hgs + ";" + PE);
                            gVar = g.oUh;
                            objArr = new Object[2];
                            objArr[0] = Integer.valueOf(5003);
                            objArr[1] = Integer.valueOf(file.exists() ? 1 : 0);
                            gVar.i(11098, objArr);
                            gVar = g.oUh;
                            objArr = new Object[2];
                            objArr[0] = Integer.valueOf(5004);
                            objArr[1] = Integer.valueOf(bJF ? 1 : 0);
                            gVar.i(11098, objArr);
                            g.oUh.a(340, 7, 1, true);
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", e, "reportSDStatus err!", new Object[0]);
                            g.oUh.a(340, 8, 1, true);
                        }
                    }
                }, "reportSDStatus");
            }
            pVar = this.hLW;
            ap.yY();
            longValue = ((Long) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_WECHAT_DB_REPORT_LAST_TIME_LONG, Long.valueOf(0))).longValue();
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > pVar.hLJ * 60000 || longValue > currentTimeMillis) {
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.USERINFO_WECHAT_DB_REPORT_LAST_TIME_LONG, Long.valueOf(currentTimeMillis));
                com.tencent.mm.sdk.f.e.post(new AnonymousClass2(pVar, (pVar.hLB * AppSupportContentFlag.MMAPP_SUPPORT_XLS) * AppSupportContentFlag.MMAPP_SUPPORT_XLS, (pVar.hLG * AppSupportContentFlag.MMAPP_SUPPORT_XLS) * AppSupportContentFlag.MMAPP_SUPPORT_XLS, pVar.hLC, pVar.hLD, pVar.hLE, pVar.hLF), "reportDBInfo");
            }
            pVar = this.hLW;
            ap.yY();
            longValue = ((Long) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_INSTALL_LAST_REPORT_TIME_LONG, Long.valueOf(0))).longValue();
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 259200000 || longValue > currentTimeMillis) {
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.USERINFO_INSTALL_LAST_REPORT_TIME_LONG, Long.valueOf(currentTimeMillis));
                com.tencent.mm.sdk.f.e.post(new Runnable(pVar) {
                    final /* synthetic */ p hLW;

                    {
                        this.hLW = r1;
                    }

                    public final void run() {
                        try {
                            long j;
                            ap.yY();
                            int intValue = ((Integer) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_INSTALL_FIRST_CLIENT_VERSION_INT, Integer.valueOf(0))).intValue();
                            ap.yY();
                            long longValue = ((Long) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_INSTALL_FIRST_TIME_LONG, Long.valueOf(0))).longValue();
                            p pVar = this.hLW;
                            long j2 = 0;
                            ap.yY();
                            if (c.isSDCardAvailable()) {
                                File file = new File(com.tencent.mm.compatible.util.e.gSF);
                                if (file.exists() && file.isDirectory()) {
                                    File[] listFiles = file.listFiles();
                                    if (listFiles == null || listFiles.length == 0) {
                                        w.i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion getOldestXlogDay failed as no files");
                                        j = 0;
                                    } else {
                                        Arrays.sort(listFiles, new Comparator<File>(pVar) {
                                            final /* synthetic */ p hLW;

                                            {
                                                this.hLW = r1;
                                            }

                                            public final /* synthetic */ int compare(Object obj, Object obj2) {
                                                long lastModified = ((File) obj).lastModified() - ((File) obj2).lastModified();
                                                if (lastModified > 0) {
                                                    return 1;
                                                }
                                                return lastModified == 0 ? 0 : -1;
                                            }

                                            public final boolean equals(Object obj) {
                                                return true;
                                            }
                                        });
                                        for (File name : listFiles) {
                                            String name2 = name.getName();
                                            if (!bg.mA(name2) && name2.endsWith(".xlog")) {
                                                j2 = bg.getLong(name2.substring(name2.length() - 13, name2.length() - 5), 0);
                                                if (j2 > 0) {
                                                    break;
                                                }
                                            }
                                        }
                                        j = j2;
                                    }
                                } else {
                                    w.i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion getOldestXlogDay failed as path not exist");
                                    j = 0;
                                }
                            } else {
                                w.i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion getOldestXlogDay failed as sdcard not available");
                                j = 0;
                            }
                            Object obj = (intValue <= 0 || com.tencent.mm.protocal.d.sYN == intValue) ? 1 : null;
                            String str = intValue + ";" + com.tencent.mm.protocal.d.sYN + ";" + (obj != null ? 1 : 0) + ";" + new SimpleDateFormat("yyyyMMdd").format(new Date(longValue)) + ";" + j;
                            g.oUh.a(418, 1, 1, true);
                            g.oUh.i(13778, Integer.valueOf(3), Integer.valueOf(1), str);
                            w.i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion install result[%s]", str);
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", e, "reportVersion err!", new Object[0]);
                            g.oUh.a(418, 2, 1, true);
                        }
                    }
                }, "reportVersion");
            }
            this.hLW.Hx();
            ap.vL();
            af.I(this.hLW.hLT);
            ap.vL().e(this.hLW.hLT, 10000);
        }
    };
    public Runnable hLT = new Runnable(this) {
        final /* synthetic */ p hLW;

        {
            this.hLW = r1;
        }

        public final void run() {
            w.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportHeavyUserRunnable run");
            if (this.hLW.hLQ != 0) {
                ap.yY();
                long longValue = ((Long) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TIME_LONG, Long.valueOf(0))).longValue();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - longValue > 86400000 || longValue > currentTimeMillis) {
                    g.oUh.a(509, 17, 1, true);
                    ap.yY();
                    c.vr().a(com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TIME_LONG, Long.valueOf(currentTimeMillis));
                    ap.yY();
                    longValue = ((Long) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_FLAG_LONG, Long.valueOf(0))).longValue();
                    com.tencent.mm.bd.a com_tencent_mm_plugin_report_kvdata_log_14375 = new log_14375();
                    com_tencent_mm_plugin_report_kvdata_log_14375.type_ = 4;
                    HeavyDetailInfo heavyDetailInfo = new HeavyDetailInfo();
                    com_tencent_mm_plugin_report_kvdata_log_14375.heavyDetailInfo_ = heavyDetailInfo;
                    heavyDetailInfo.flag_ = longValue;
                    String valueOf = String.valueOf(longValue);
                    ap.yY();
                    long longValue2 = ((Long) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TYPE_SD_FILE_SIZE_LONG, Long.valueOf(0))).longValue();
                    heavyDetailInfo.sdFileSize_ = longValue2;
                    valueOf = valueOf + ";" + longValue2;
                    ap.yY();
                    longValue2 = ((Long) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TYPE_SD_FILE_RATIO_LONG, Long.valueOf(0))).longValue();
                    heavyDetailInfo.sdFileRatio_ = longValue2;
                    valueOf = valueOf + ";" + longValue2;
                    ap.yY();
                    longValue2 = ((Long) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_SIZE_LONG, Long.valueOf(0))).longValue();
                    heavyDetailInfo.dbSize_ = longValue2;
                    valueOf = valueOf + ";" + longValue2;
                    ap.yY();
                    longValue2 = ((Long) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_MESSAGE_LONG, Long.valueOf(0))).longValue();
                    heavyDetailInfo.message_ = longValue2;
                    valueOf = valueOf + ";" + longValue2;
                    ap.yY();
                    longValue2 = ((Long) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CONVERSATION_LONG, Long.valueOf(0))).longValue();
                    heavyDetailInfo.conversation_ = longValue2;
                    valueOf = valueOf + ";" + longValue2;
                    ap.yY();
                    longValue2 = ((Long) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CONTACT_LONG, Long.valueOf(0))).longValue();
                    heavyDetailInfo.contact_ = longValue2;
                    valueOf = valueOf + ";" + longValue2;
                    ap.yY();
                    longValue2 = ((Long) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CHATROOM_LONG, Long.valueOf(0))).longValue();
                    heavyDetailInfo.chatroom_ = longValue2;
                    valueOf = valueOf + ";" + longValue2;
                    ap.yY();
                    longValue2 = ((Long) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TYPE_FAV_DB_SIZE_LONG, Long.valueOf(0))).longValue();
                    heavyDetailInfo.favDbSize_ = longValue2;
                    String str = valueOf + ";" + longValue2;
                    g.oUh.i(13778, Integer.valueOf(4), Integer.valueOf(1), str);
                    g.oUh.b(14375, com_tencent_mm_plugin_report_kvdata_log_14375);
                    w.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportHeavyUser report heavy result[%s]", str);
                }
            }
        }
    };
    private com.tencent.mm.sdk.b.c hLU = new com.tencent.mm.sdk.b.c<lc>(this) {
        final /* synthetic */ p hLW;

        {
            this.hLW = r2;
            this.usg = lc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ap.vL();
            af.I(this.hLW.hLS);
            ap.vL().e(this.hLW.hLS, 3000);
            return false;
        }
    };
    private aj hLV = new aj(ap.vL().nJF.getLooper(), new aj.a(this) {
        final /* synthetic */ p hLW;

        {
            this.hLW = r1;
        }

        public final boolean oQ() {
            this.hLW.Hx();
            return true;
        }
    }, true);
    long hLz = AppSupportContentFlag.MMAPP_SUPPORT_XLS;
    private j.a hoU = new j.a(this) {
        final /* synthetic */ p hLW;

        {
            this.hLW = r1;
        }

        public final void a(String str, l lVar) {
            w.i("MicroMsg.SubCoreBaseMonitor", "summerhv abTestListener onNotifyChange stack[%s]", bg.bJZ());
            if (str != null && str.length() > 0 && "event_updated".equals(str)) {
                this.hLW.bk(true);
            }
        }
    };

    class AnonymousClass13 implements Runnable {
        final /* synthetic */ p hLW;
        final /* synthetic */ c hMh;
        final Map<String, Integer> hMi = this.hMj;
        final /* synthetic */ Map hMj;
        final /* synthetic */ a hMk;
        final /* synthetic */ File hMl;

        AnonymousClass13(p pVar, Map map, a aVar, File file, c cVar) {
            this.hLW = pVar;
            this.hMj = map;
            this.hMk = aVar;
            this.hMl = file;
            this.hMh = cVar;
        }

        public final void run() {
            w.i("MicroMsg.SubCoreBaseMonitor", "summerhv true scan start fileScanResult[%s], subDirMap[%d]", this.hMk, Integer.valueOf(this.hMj.size()));
            long currentTimeMillis = System.currentTimeMillis();
            this.hLW.a(this.hMl, this.hMk, null, null, this.hMi, true, 0);
            if (this.hMj.size() > 0) {
                Iterator it = this.hMj.entrySet().iterator();
                while (it != null && it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    this.hMk.hKb.add(new c.b((String) entry.getKey(), ((Integer) entry.getValue()).intValue()));
                }
            }
            this.hMk.hJZ = System.currentTimeMillis() - currentTimeMillis;
            w.i("MicroMsg.SubCoreBaseMonitor", "summerhv true scan end takes[%d], emptySubDir[%d], fileScanResult[%s], tid[%d]", Long.valueOf(this.hMk.hJZ), Integer.valueOf(this.hMj.values().size()), this.hMk, Long.valueOf(Thread.currentThread().getId()));
            this.hMh.a(0, this.hMk);
        }
    }

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ p hLW;
        final /* synthetic */ long hLX;
        final /* synthetic */ long hLY;
        final /* synthetic */ long hLZ;
        final /* synthetic */ long hMa;
        final /* synthetic */ long hMb;
        final /* synthetic */ long hMc;

        AnonymousClass2(p pVar, long j, long j2, long j3, long j4, long j5, long j6) {
            this.hLW = pVar;
            this.hLX = j;
            this.hLY = j2;
            this.hLZ = j3;
            this.hMa = j4;
            this.hMb = j5;
            this.hMc = j6;
        }

        public final void run() {
            try {
                com.tencent.mm.bd.a com_tencent_mm_plugin_report_kvdata_log_14375 = new log_14375();
                com_tencent_mm_plugin_report_kvdata_log_14375.type_ = 1;
                BDStatusInfo bDStatusInfo = new BDStatusInfo();
                com_tencent_mm_plugin_report_kvdata_log_14375.dbStatusInfo_ = bDStatusInfo;
                ap.yY();
                long length = new File(c.vp()).length();
                bDStatusInfo.mmDBSize_ = length;
                StringBuilder stringBuilder = new StringBuilder();
                ap.yY();
                long length2 = new File(stringBuilder.append(c.xu()).append("SnsMicroMsg.db").toString()).length();
                bDStatusInfo.snsDBSize_ = length2;
                stringBuilder = new StringBuilder();
                ap.yY();
                long length3 = new File(stringBuilder.append(c.xu()).append("enFavorite.db").toString()).length();
                bDStatusInfo.favDBSize_ = length3;
                this.hLW.a(4, length, this.hLX);
                this.hLW.a(FileUtils.S_IWUSR, length3, this.hLY);
                String str = length + ";" + length2 + ";" + length3;
                ap.yY();
                com.tencent.mm.bj.g wP = c.wP();
                if (wP == null || !wP.isOpen()) {
                    w.i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo db is not open!");
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    ArrayList arrayList = new ArrayList();
                    Cursor a = wP.a("SELECT name FROM sqlite_master WHERE type='table'", null, 2);
                    if (a != null) {
                        int columnIndex = a.getColumnIndex("name");
                        while (a.moveToNext()) {
                            arrayList.add(a.getString(columnIndex));
                        }
                        a.close();
                    }
                    String str2 = str + ";" + arrayList.size();
                    bDStatusInfo.mmDBTableCount_ = arrayList.size();
                    LinkedList linkedList = new LinkedList();
                    bDStatusInfo.tableList_ = linkedList;
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        str = (String) it.next();
                        Cursor a2 = wP.a("select count(*) from " + str, null, 2);
                        length = 0;
                        if (a2 != null) {
                            if (a2.moveToFirst()) {
                                length = a2.getLong(0);
                            }
                            a2.close();
                        }
                        String str3 = str2 + ";" + str + ":" + length;
                        TableInfo tableInfo = new TableInfo();
                        tableInfo.name_ = str;
                        tableInfo.count_ = length;
                        linkedList.add(tableInfo);
                        if ("message".equals(str)) {
                            this.hLW.a(8, length, this.hLZ);
                            str2 = str3;
                        } else if ("rconversation".equals(str)) {
                            this.hLW.a(16, length, this.hMa);
                            str2 = str3;
                        } else if ("rcontact".equals(str)) {
                            this.hLW.a(32, length, this.hMb);
                            str2 = str3;
                        } else {
                            if ("chatroom".equals(str)) {
                                this.hLW.a(64, length, this.hMc);
                            }
                            str2 = str3;
                        }
                    }
                    w.i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo dump all table count %d last %d", Integer.valueOf(arrayList.size()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    str = str2;
                }
                g.oUh.i(13778, Integer.valueOf(1), Integer.valueOf(1), str);
                g.oUh.b(14375, com_tencent_mm_plugin_report_kvdata_log_14375);
                g.oUh.a(418, 3, 1, true);
                w.i("MicroMsg.SubCoreBaseMonitor", "summerreportDBInfo result[%s]", str);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", e, "reportDBInfo err!", new Object[0]);
                g.oUh.a(418, 4, 1, true);
            }
        }
    }

    public final boolean bk(boolean z) {
        boolean z2;
        com.tencent.mm.storage.c dX = com.tencent.mm.u.c.c.Az().dX("100212");
        w.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg update[%b] abTest[%s][%b][%s] default[%d, %d, %d, %d, %d, %d, %d, %d, %d, %d, %d]", Boolean.valueOf(z), dX, Boolean.valueOf(dX.isValid()), dX.bKK(), Long.valueOf(AppSupportContentFlag.MMAPP_SUPPORT_XLS), Long.valueOf(10), Long.valueOf(1800), Long.valueOf(3000000), Long.valueOf(15000), Long.valueOf(15000), Long.valueOf(100000), Long.valueOf(10000), Long.valueOf(1440), Long.valueOf(20), Long.valueOf(1440));
        if (dX.isValid()) {
            w.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg abTest valid!");
            Map bKK = dX.bKK();
            long j = bg.getLong((String) bKK.get("sdsize"), AppSupportContentFlag.MMAPP_SUPPORT_XLS);
            long j2 = bg.getLong((String) bKK.get("sdratio"), 10);
            long j3 = bg.getLong((String) bKK.get("dbsize"), 1800);
            long j4 = bg.getLong((String) bKK.get("fdbsize"), AppSupportContentFlag.MMAPP_SUPPORT_XLS);
            long j5 = bg.getLong((String) bKK.get("msg"), 3000000);
            long j6 = bg.getLong((String) bKK.get("conv"), 15000);
            long j7 = bg.getLong((String) bKK.get("contact"), 100000);
            long j8 = bg.getLong((String) bKK.get("chatroom"), 10000);
            long j9 = bg.getLong((String) bKK.get("sditv"), 1440);
            long j10 = bg.getLong((String) bKK.get("sdwait"), 20);
            long j11 = bg.getLong((String) bKK.get("dbitv"), 1440);
            w.i("MicroMsg.SubCoreBaseMonitor", "summerhv reloadHeavyUserCfg sd[%d, %d] sdr[%d, %d] db[%d, %d] fdbsize[%d, %d] msg[%d, %d] conv[%d, %d] contact[%d, %d] chatroom[%d, %d] sditv[%d, %d] sdwait[%d, %d] dbitv[%d, %d]", Long.valueOf(this.hLz), Long.valueOf(j), Long.valueOf(this.hLA), Long.valueOf(j2), Long.valueOf(this.hLB), Long.valueOf(j3), Long.valueOf(this.hLG), Long.valueOf(j4), Long.valueOf(this.hLC), Long.valueOf(j5), Long.valueOf(this.hLD), Long.valueOf(j6), Long.valueOf(this.hLE), Long.valueOf(j7), Long.valueOf(this.hLF), Long.valueOf(j8), Long.valueOf(this.hLH), Long.valueOf(j9), Long.valueOf(this.hLI), Long.valueOf(j10), Long.valueOf(this.hLJ), Long.valueOf(j11));
            if (this.hLz != j) {
                this.hLz = j;
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.hLA != j2) {
                this.hLA = j2;
                z2 = true;
            }
            if (this.hLB != j3) {
                this.hLB = j3;
                z2 = true;
            }
            if (this.hLG != j4) {
                this.hLG = j4;
                z2 = true;
            }
            if (this.hLC != j5) {
                this.hLC = j5;
                z2 = true;
            }
            if (this.hLD != j6) {
                this.hLD = j6;
                z2 = true;
            }
            if (this.hLE != j7) {
                this.hLE = j7;
                z2 = true;
            }
            if (this.hLF != j8) {
                this.hLF = j8;
                z2 = true;
            }
            if (this.hLH != j9) {
                this.hLH = j9;
                z2 = true;
            }
            if (this.hLI != j10) {
                this.hLI = j10;
                z2 = true;
            }
            if (this.hLJ != j11) {
                this.hLJ = j11;
                z2 = true;
            }
        } else {
            z2 = false;
        }
        if (z2) {
            g.oUh.a(509, 0, 1, true);
            if (z) {
                g.oUh.a(509, 18, 1, true);
            }
        }
        if (this.hLz <= 0) {
            g.oUh.a(509, 30, 1, true);
            this.hLz = AppSupportContentFlag.MMAPP_SUPPORT_XLS;
        }
        if (this.hLA <= 0) {
            g.oUh.a(509, 31, 1, true);
            this.hLA = 10;
        }
        if (this.hLB <= 0) {
            g.oUh.a(509, 32, 1, true);
            this.hLB = 1800;
        }
        if (this.hLC <= 0) {
            g.oUh.a(509, 33, 1, true);
            this.hLC = 3000000;
        }
        if (this.hLD <= 0) {
            g.oUh.a(509, 34, 1, true);
            this.hLD = 15000;
        }
        if (this.hLE <= 0) {
            g.oUh.a(509, 35, 1, true);
            this.hLE = 100000;
        }
        if (this.hLF <= 0) {
            g.oUh.a(509, 36, 1, true);
            this.hLE = 10000;
        }
        if (this.hLH <= 0) {
            g.oUh.a(509, 37, 1, true);
            this.hLH = 1440;
        }
        if (this.hLI <= 0) {
            g.oUh.a(509, 38, 1, true);
            this.hLI = 20;
        }
        if (this.hLJ <= 0) {
            g.oUh.a(509, 39, 1, true);
            this.hLJ = 1440;
        }
        if (this.hLG <= 0) {
            g.oUh.a(509, 40, 1, true);
            this.hLG = AppSupportContentFlag.MMAPP_SUPPORT_XLS;
        }
        return z2;
    }

    public final HashMap<Integer, com.tencent.mm.bj.g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        com.tencent.mm.sdk.b.a.urY.a(this.hLU);
        com.tencent.mm.u.c.c.Az().c(this.hoU);
        boolean bk = bk(false);
        ap.yY();
        this.hLQ = ((Long) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_FLAG_LONG, Long.valueOf(0))).longValue();
        d.gE(this.hLQ != 0);
        w.i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountPostReset heavyuser[%d], reloadHeavyUser[%b] abTestListener[%s]", Long.valueOf(this.hLQ), Boolean.valueOf(bk), this.hoU);
        ap.vd().a(989, this.hLR);
        ap.vd().a(988, this.hLR);
        ap.vd().a(987, this.hLR);
        ap.vd().a(986, this.hLR);
        ap.yY();
        this.hLN = ((Long) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_WECHAT_FILE_SCAN_LAST_TIME_LONG, Long.valueOf(0))).longValue();
        Context context = ab.getContext();
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            boolean z2;
            int intExtra = registerReceiver.getIntExtra(DownloadInfo.STATUS, -1);
            if (intExtra == 2 || intExtra == 5) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.hLL = z2;
        } else {
            this.hLL = false;
        }
        this.hLM = ((PowerManager) context.getSystemService("power")).isScreenOn();
        this.hLK = new BroadcastReceiver(this) {
            final /* synthetic */ p hLW;

            {
                this.hLW = r1;
            }

            public final void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                boolean z = true;
                switch (action.hashCode()) {
                    case -2128145023:
                        if (action.equals("android.intent.action.SCREEN_OFF")) {
                            z = true;
                            break;
                        }
                        break;
                    case -1886648615:
                        if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                            z = true;
                            break;
                        }
                        break;
                    case -1454123155:
                        if (action.equals("android.intent.action.SCREEN_ON")) {
                            z = false;
                            break;
                        }
                        break;
                    case 1019184907:
                        if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                            z = true;
                            break;
                        }
                        break;
                }
                switch (z) {
                    case false:
                        this.hLW.hLM = true;
                        break;
                    case true:
                        this.hLW.hLM = false;
                        break;
                    case true:
                        this.hLW.hLL = true;
                        break;
                    case true:
                        this.hLW.hLL = false;
                        break;
                }
                String str = "MicroMsg.SubCoreBaseMonitor";
                String str2 = "summerhv Action received: %s, interactive: %s, charging: %s, lastScanTime:%d, delayTimerRunnable null[%b]";
                Object[] objArr = new Object[5];
                objArr[0] = action;
                objArr[1] = Boolean.valueOf(this.hLW.hLM);
                objArr[2] = Boolean.valueOf(this.hLW.hLL);
                objArr[3] = Long.valueOf(this.hLW.hLN);
                if (this.hLW.hLO == null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[4] = Boolean.valueOf(z);
                w.v(str, str2, objArr);
                if (this.hLW.hLO == null && this.hLW.hLL && !this.hLW.hLM) {
                    if (System.currentTimeMillis() - this.hLW.hLN < this.hLW.hLH * 60000) {
                        w.i("MicroMsg.SubCoreBaseMonitor", "summerhv last scan time not matched in [%d]min", Long.valueOf(this.hLW.hLH));
                        return;
                    }
                    final c anonymousClass1 = new c(this) {
                        final /* synthetic */ AnonymousClass12 hMg;

                        {
                            this.hMg = r1;
                        }

                        public final void a(int i, a aVar) {
                            this.hMg.hLW.hLN = System.currentTimeMillis();
                            w.i("MicroMsg.SubCoreBaseMonitor", "summerhv callback errType[%d] lastScanTime[%d], result[%s][%s]", Integer.valueOf(i), Long.valueOf(this.hMg.hLW.hLN), this.hMg.hLW.hLP, aVar);
                            this.hMg.hLW.hLP = null;
                            if (i == 0 && !aVar.hKd) {
                                ap.yY();
                                c.vr().a(com.tencent.mm.storage.w.a.USERINFO_WECHAT_FILE_SCAN_LAST_TIME_LONG, Long.valueOf(this.hMg.hLW.hLN));
                                ap.yY();
                                c.vr().jY(false);
                                try {
                                    long j;
                                    long j2;
                                    long j3;
                                    long j4;
                                    long j5;
                                    int i2;
                                    p pVar = this.hMg.hLW;
                                    com.tencent.mm.bd.a com_tencent_mm_plugin_report_kvdata_log_14375 = new log_14375();
                                    com_tencent_mm_plugin_report_kvdata_log_14375.type_ = 2;
                                    SDStatusInfo sDStatusInfo = new SDStatusInfo();
                                    com_tencent_mm_plugin_report_kvdata_log_14375.sdStatusInfo_ = sDStatusInfo;
                                    c.c cVar = new c.c("total/temp/acc/");
                                    Iterator it = aVar.hKc.iterator();
                                    while (it.hasNext()) {
                                        c.c cVar2 = (c.c) it.next();
                                        cVar.hJX += cVar2.hJX;
                                        cVar.hJY += cVar2.hJY;
                                        cVar.fLh += cVar2.fLh;
                                        cVar.hKe += cVar2.hKe;
                                    }
                                    w.i("MicroMsg.SubCoreBaseMonitor", "summerhv doReportSDInfo total tempAccDirResult[%d][%s]", Integer.valueOf(aVar.hKc.size()), cVar);
                                    Collections.sort(aVar.hKb, new Comparator<c.b>(pVar) {
                                        final /* synthetic */ p hLW;

                                        {
                                            this.hLW = r1;
                                        }

                                        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                                            long j = (long) (((c.b) obj).tag - ((c.b) obj2).tag);
                                            if (j > 0) {
                                                return 1;
                                            }
                                            return j == 0 ? 0 : -1;
                                        }
                                    });
                                    it = aVar.hKb.iterator();
                                    while (it.hasNext()) {
                                        w.d("MicroMsg.SubCoreBaseMonitor", "summerhv doReportSDInfo subDirResult[%s]", (c.b) it.next());
                                    }
                                    String str = aVar.fLh + ":" + aVar.hJX + ":" + aVar.hJY + ":" + aVar.fileLenInvalidCount + ":" + aVar.hKb.size() + ":" + aVar.hJZ + ":" + aVar.hKa + "|" + aVar.hKc.size() + ":" + cVar.fLh + ":" + cVar.hJX + ":" + cVar.hJY + ":" + cVar.hKe;
                                    WeChatSDInfo weChatSDInfo = new WeChatSDInfo();
                                    sDStatusInfo.weChatSDInfo_ = weChatSDInfo;
                                    weChatSDInfo.totalSize_ = aVar.fLh;
                                    weChatSDInfo.fileCount_ = aVar.hJY;
                                    weChatSDInfo.fileLenInvalidCount_ = aVar.fileLenInvalidCount;
                                    weChatSDInfo.subDirResultsSize_ = aVar.hKb.size();
                                    weChatSDInfo.totalTime_ = aVar.hJZ;
                                    weChatSDInfo.depth_ = aVar.hKa;
                                    weChatSDInfo.tempAccTotalSize_ = cVar.fLh;
                                    weChatSDInfo.tempAccDirResultsSize_ = aVar.hKc.size();
                                    weChatSDInfo.tempAccDirCount_ = cVar.hJX;
                                    weChatSDInfo.tempAccFileCount_ = cVar.hJY;
                                    weChatSDInfo.tempAccFileLenInvalidCount_ = cVar.hKe;
                                    LinkedList linkedList = new LinkedList();
                                    weChatSDInfo.subDirList_ = linkedList;
                                    it = aVar.hKb.iterator();
                                    String str2 = str;
                                    while (it.hasNext()) {
                                        c.b bVar = (c.b) it.next();
                                        String str3 = str2 + "|" + bVar.tag + ":" + bVar.fLh + ":" + bVar.hJX + ":" + bVar.hJY + ":" + bVar.fileLenInvalidCount;
                                        SubDirInfo subDirInfo = new SubDirInfo();
                                        linkedList.add(subDirInfo);
                                        subDirInfo.tag_ = bVar.tag;
                                        subDirInfo.totalSize_ = bVar.fLh;
                                        subDirInfo.dirCount_ = bVar.hJX;
                                        subDirInfo.fileCount_ = bVar.hJY;
                                        subDirInfo.fileLenInvalidCount = bVar.fileLenInvalidCount;
                                        str2 = str3;
                                    }
                                    w.i("MicroMsg.SubCoreBaseMonitor", "summerhv doReportSDInfo wechatResult[%d][%s]", Integer.valueOf(str2.length()), str2);
                                    String path = h.getExternalStorageDirectory().getPath();
                                    boolean bJF = av.bJF();
                                    String PE = av.PE(com.tencent.mm.compatible.util.e.hgs);
                                    StatFs statFs = new StatFs(path);
                                    long blockSize = (long) statFs.getBlockSize();
                                    long blockCount = (long) statFs.getBlockCount();
                                    long availableBlocks = (long) statFs.getAvailableBlocks();
                                    long j6 = blockSize * blockCount;
                                    long j7 = blockSize * availableBlocks;
                                    int i3 = -1;
                                    if (blockCount > 0) {
                                        i3 = Math.round((float) ((100 * availableBlocks) / blockCount));
                                    }
                                    boolean equals = com.tencent.mm.compatible.util.e.hgs.equals(path);
                                    if (equals) {
                                        j = j7;
                                        j2 = j6;
                                        j3 = availableBlocks;
                                        j4 = blockCount;
                                        j5 = blockSize;
                                        i2 = i3;
                                    } else {
                                        statFs = new StatFs(com.tencent.mm.compatible.util.e.hgs);
                                        j3 = (long) statFs.getBlockSize();
                                        j2 = (long) statFs.getBlockCount();
                                        j = (long) statFs.getAvailableBlocks();
                                        long j8 = j3 * j2;
                                        long j9 = j3 * j;
                                        if (j2 > 0) {
                                            j4 = j2;
                                            j5 = j3;
                                            i2 = Math.round((float) ((100 * j) / j2));
                                            j2 = j8;
                                            j3 = j;
                                            j = j9;
                                        } else {
                                            j4 = j2;
                                            j5 = j3;
                                            i2 = i3;
                                            j2 = j8;
                                            j3 = j;
                                            j = j9;
                                        }
                                    }
                                    int round = Math.round((float) ((aVar.fLh * 100) / j2));
                                    sDStatusInfo.weChatPer_ = round;
                                    pVar.a(1, aVar.fLh, (pVar.hLz * AppSupportContentFlag.MMAPP_SUPPORT_XLS) * AppSupportContentFlag.MMAPP_SUPPORT_XLS);
                                    sDStatusInfo.sizeHeavy_ = aVar.fLh > (pVar.hLz * AppSupportContentFlag.MMAPP_SUPPORT_XLS) * AppSupportContentFlag.MMAPP_SUPPORT_XLS ? 1 : 0;
                                    pVar.a(2, (long) round, pVar.hLA);
                                    sDStatusInfo.ratioHeavy_ = ((long) round) > pVar.hLA ? 1 : 0;
                                    String str4 = round + ";" + (equals ? 1 : 0) + ";" + (bJF ? 1 : 0) + ";" + j5 + ":" + j4 + ":" + j3 + ":" + j2 + ":" + j + ":" + i2 + "|" + blockSize + ":" + blockCount + ":" + availableBlocks + ":" + j6 + ":" + j7 + ":" + i3 + ";" + path + ";" + com.tencent.mm.compatible.util.e.hgs + ";" + PE;
                                    sDStatusInfo.sBlockSize_ = j5;
                                    sDStatusInfo.sBlockCount_ = j4;
                                    sDStatusInfo.sAvailableBlockCount_ = j3;
                                    sDStatusInfo.sTotalSize_ = j2;
                                    sDStatusInfo.sAvailableSize_ = j;
                                    sDStatusInfo.sAvailablePer_ = i2;
                                    sDStatusInfo.eBlockSize_ = blockSize;
                                    sDStatusInfo.eBlockCount_ = blockCount;
                                    sDStatusInfo.eAvailableBlockCount_ = availableBlocks;
                                    sDStatusInfo.eTotalSize_ = j6;
                                    sDStatusInfo.eAvailableSize_ = j7;
                                    sDStatusInfo.eAvailablePer_ = i3;
                                    sDStatusInfo.ePath_ = path;
                                    sDStatusInfo.root_ = com.tencent.mm.compatible.util.e.hgs;
                                    sDStatusInfo.fSystem_ = PE;
                                    w.i("MicroMsg.SubCoreBaseMonitor", "summerhv doReportSDInfo phoneResult[%d][%s]", Integer.valueOf(str4.length()), str4);
                                    str4 = str2 + ";" + str4;
                                    w.i("MicroMsg.SubCoreBaseMonitor", "summerhv doReportSDInfo totalResult[%d][%s]", Integer.valueOf(str4.length()), str4);
                                    g.oUh.a(418, 5, 1, true);
                                    g.oUh.i(13778, Integer.valueOf(2), Integer.valueOf(1), str4);
                                    g.oUh.b(14375, com_tencent_mm_plugin_report_kvdata_log_14375);
                                } catch (Throwable e) {
                                    w.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", e, "doReportSDInfo err!", new Object[0]);
                                    g.oUh.a(418, 6, 1, true);
                                }
                            }
                        }
                    };
                    this.hLW.hLO = new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 hMg;

                        public final void run() {
                            a aVar = null;
                            this.hMg.hLW.hLO = null;
                            p pVar = this.hMg.hLW;
                            p pVar2 = this.hMg.hLW;
                            c cVar = anonymousClass1;
                            w.i("MicroMsg.SubCoreBaseMonitor", "summerhv startScan");
                            ap.yY();
                            if (c.isSDCardAvailable()) {
                                File file = new File(com.tencent.mm.compatible.util.e.hgu);
                                String xe;
                                if (file.exists() && file.isDirectory()) {
                                    w.i("MicroMsg.SubCoreBaseMonitor", "summerhv startScan root[%s] exist[%b], diretory[%b]", xe, Boolean.valueOf(file.exists()), Boolean.valueOf(file.isDirectory()));
                                    Map hashMap = new HashMap(26);
                                    ap.yY();
                                    xe = c.xe();
                                    ap.yY();
                                    hashMap.put(xe.substring(0, c.xe().length() - 1), Integer.valueOf(1));
                                    ap.yY();
                                    xe = c.xf();
                                    ap.yY();
                                    hashMap.put(xe.substring(0, c.xf().length() - 1), Integer.valueOf(2));
                                    ap.yY();
                                    xe = c.xb();
                                    ap.yY();
                                    hashMap.put(xe.substring(0, c.xb().length() - 1), Integer.valueOf(3));
                                    ap.yY();
                                    xe = c.xc();
                                    ap.yY();
                                    hashMap.put(xe.substring(0, c.xc().length() - 1), Integer.valueOf(4));
                                    ap.yY();
                                    hashMap.put(c.xr(), Integer.valueOf(5));
                                    hashMap.put(com.tencent.mm.plugin.g.a.ZW().substring(0, com.tencent.mm.plugin.g.a.ZW().length() - 1), Integer.valueOf(6));
                                    ap.yY();
                                    xe = c.xi();
                                    ap.yY();
                                    hashMap.put(xe.substring(0, c.xi().length() - 1), Integer.valueOf(7));
                                    ap.yY();
                                    xe = c.getAccVideoPath();
                                    ap.yY();
                                    hashMap.put(xe.substring(0, c.getAccVideoPath().length() - 1), Integer.valueOf(8));
                                    ap.yY();
                                    xe = c.xl();
                                    ap.yY();
                                    hashMap.put(xe.substring(0, c.xl().length() - 1), Integer.valueOf(9));
                                    ap.yY();
                                    xe = c.xj();
                                    ap.yY();
                                    hashMap.put(xe.substring(0, c.xj().length() - 1), Integer.valueOf(10));
                                    ap.yY();
                                    xe = c.xm();
                                    ap.yY();
                                    hashMap.put(xe.substring(0, c.xm().length() - 1), Integer.valueOf(11));
                                    ap.yY();
                                    xe = c.xn();
                                    ap.yY();
                                    hashMap.put(xe.substring(0, c.xn().length() - 1), Integer.valueOf(12));
                                    ap.yY();
                                    xe = c.xo();
                                    ap.yY();
                                    hashMap.put(xe.substring(0, c.xo().length() - 1), Integer.valueOf(13));
                                    ap.yY();
                                    xe = c.xs();
                                    ap.yY();
                                    hashMap.put(xe.substring(0, c.xs().length() - 1), Integer.valueOf(14));
                                    ap.yY();
                                    xe = c.xg();
                                    ap.yY();
                                    hashMap.put(xe.substring(0, c.xg().length() - 1), Integer.valueOf(15));
                                    hashMap.put(com.tencent.mm.au.b.JJ().substring(0, com.tencent.mm.au.b.JJ().length() - 1), Integer.valueOf(16));
                                    ap.yY();
                                    xe = c.xh();
                                    ap.yY();
                                    hashMap.put(xe.substring(0, c.xh().length() - 1), Integer.valueOf(17));
                                    ap.yY();
                                    xe = c.xq();
                                    ap.yY();
                                    hashMap.put(xe.substring(0, c.xq().length() - 1), Integer.valueOf(18));
                                    ap.yY();
                                    xe = c.xp();
                                    ap.yY();
                                    hashMap.put(xe.substring(0, c.xp().length() - 1), Integer.valueOf(19));
                                    ap.yY();
                                    xe = c.getAccSnsPath();
                                    ap.yY();
                                    hashMap.put(xe.substring(0, c.getAccSnsPath().length() - 1), Integer.valueOf(20));
                                    ap.yY();
                                    xe = c.xt();
                                    ap.yY();
                                    hashMap.put(xe.substring(0, c.xt().length() - 1), Integer.valueOf(21));
                                    ap.yY();
                                    xe = c.xd();
                                    ap.yY();
                                    hashMap.put(xe.substring(0, c.xd().length() - 1), Integer.valueOf(22));
                                    hashMap.put(com.tencent.mm.compatible.util.e.gSF, Integer.valueOf(23));
                                    hashMap.put(com.tencent.mm.compatible.util.e.gSx.substring(0, com.tencent.mm.compatible.util.e.gSx.length() - 1), Integer.valueOf(24));
                                    hashMap.put(com.tencent.mm.compatible.util.e.gSB.substring(0, com.tencent.mm.compatible.util.e.gSB.length() - 1), Integer.valueOf(25));
                                    hashMap.put(com.tencent.mm.compatible.util.e.gSz.substring(0, com.tencent.mm.compatible.util.e.gSz.length() - 1), Integer.valueOf(26));
                                    aVar = new a(file.getAbsolutePath());
                                    com.tencent.mm.sdk.f.e.post(new AnonymousClass13(pVar2, hashMap, aVar, file, cVar), "summerhv_scanFile");
                                } else {
                                    w.i("MicroMsg.SubCoreBaseMonitor", "summerhv startScan failed as path not exists[%s]", xe);
                                    cVar.a(-1, null);
                                }
                            } else {
                                w.i("MicroMsg.SubCoreBaseMonitor", "summerhv startScan failed as sdcard not available");
                                cVar.a(-1, null);
                            }
                            pVar.hLP = aVar;
                            w.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan started[%s]", this.hMg.hLW.hLP);
                        }
                    };
                    ap.vL().e(this.hLW.hLO, this.hLW.hLI * 60000);
                    w.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan post delay[%d]min", Long.valueOf(this.hLW.hLI));
                } else if (this.hLW.hLO != null) {
                    ap.vL().bJl().removeCallbacks(this.hLW.hLO);
                    this.hLW.hLO = null;
                    w.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan remove[%s]", this.hLW.hLP);
                } else if (this.hLW.hLP != null) {
                    this.hLW.hLP.hKd = true;
                    w.i("MicroMsg.SubCoreBaseMonitor", "summerhv auto scan canceled[%s]", this.hLW.hLP);
                    this.hLW.hLP = null;
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        context.registerReceiver(this.hLK, intentFilter);
        String str = "MicroMsg.SubCoreBaseMonitor";
        String str2 = "summerhv registerReceiver auto scan %s. Device status:%s interactive,%s charging mLastAutoScanTime[%d], mAutoScanInterval[%d], mAutoScanWaitTime[%d].";
        Object[] objArr = new Object[6];
        objArr[0] = this.hLP != null ? "enabled" : "disabled";
        objArr[1] = this.hLM ? "" : " not";
        objArr[2] = this.hLL ? "" : " not";
        objArr[3] = Long.valueOf(this.hLN);
        objArr[4] = Long.valueOf(this.hLH * 60000);
        objArr[5] = Long.valueOf(this.hLI * 60000);
        w.i(str, str2, objArr);
        this.hLV.KH();
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        w.i("MicroMsg.SubCoreBaseMonitor", "summerhv onAccountRelease [%d]", Long.valueOf(startTime), Long.valueOf(System.currentTimeMillis()));
        if (this.hLK != null) {
            ab.getContext().unregisterReceiver(this.hLK);
            w.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver mChargeAndInteractiveReceiver[%s]", this.hLK);
            this.hLK = null;
        }
        if (this.hLO != null) {
            ap.vL().bJl().removeCallbacks(this.hLO);
            this.hLO = null;
            w.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver remove[%s]", this.hLP);
        }
        if (this.hLP != null) {
            this.hLP.hKd = true;
            w.i("MicroMsg.SubCoreBaseMonitor", "summerhv unregisterReceiver canceled[%s]", this.hLP);
            this.hLP = null;
        }
        ap.vd().b(989, this.hLR);
        ap.vd().b(988, this.hLR);
        ap.vd().b(987, this.hLR);
        ap.vd().b(986, this.hLR);
        com.tencent.mm.u.c.c.Az().f(this.hoU);
        com.tencent.mm.sdk.b.a.urY.c(this.hLU);
    }

    public final a a(File file, a aVar, c.b bVar, c.c cVar, Map<String, Integer> map, boolean z, int i) {
        if (aVar.hKd) {
            w.i("MicroMsg.SubCoreBaseMonitor", "summclean scanFile been canceled fileResult[%s], subDirResult[%s]", aVar, bVar);
        } else {
            if (aVar.hKa < i) {
                aVar.hKa++;
            }
            if (file.isDirectory()) {
                c.b bVar2;
                String absolutePath = file.getAbsolutePath();
                if (bVar != null || map == null || map.size() <= 0 || map.get(absolutePath) == null) {
                    bVar2 = bVar;
                } else {
                    c.b bVar3 = new c.b(absolutePath, ((Integer) map.get(absolutePath)).intValue());
                    map.remove(absolutePath);
                    aVar.hKb.add(bVar3);
                    w.d("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile start scan subDir[%s], fileResult[%s], newSubDirResult[%s]", absolutePath, aVar, bVar3);
                    bVar2 = bVar3;
                }
                aVar.hJX++;
                if (bVar2 != null) {
                    bVar2.hJX++;
                }
                if (cVar != null) {
                    cVar.hJX++;
                }
                if (i > 15) {
                    w.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile been stopped as depth[%d] over limit path[%s], fileResult[%s]", Integer.valueOf(i), file.getAbsolutePath(), aVar);
                } else {
                    String[] list = file.list();
                    if (list == null) {
                        w.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile dir is empty[%s] ret", file.getAbsolutePath());
                    } else if (z) {
                        c.c cVar2 = cVar;
                        for (String str : list) {
                            if (!bg.mA(str) && Pattern.matches("[a-fA-F0-9]{32}temp[0-9]{13}", str)) {
                                cVar2 = new c.c(file.getAbsolutePath() + File.separator + str);
                                aVar.hKc.add(cVar2);
                            }
                            a(new File(file.getAbsolutePath() + File.separator + str), aVar, bVar2, cVar2, map, false, i + 1);
                        }
                    } else {
                        Object obj = 1;
                        int length = list.length;
                        int i2 = 0;
                        while (i2 < length) {
                            Object obj2;
                            a(new File(file.getAbsolutePath() + File.separator + list[i2]), aVar, bVar2, cVar, map, false, i + 1);
                            if (obj == null || aVar.hKa <= 15) {
                                obj2 = obj;
                            } else {
                                g.oUh.a(418, 7, 1, true);
                                g.oUh.i(13778, Integer.valueOf(2), Integer.valueOf(2), file.getAbsolutePath() + File.separator + r18);
                                obj2 = null;
                            }
                            i2++;
                            obj = obj2;
                        }
                    }
                }
            } else {
                aVar.hJY++;
                if (bVar != null) {
                    bVar.hJY++;
                }
                if (cVar != null) {
                    cVar.hJY++;
                }
                if (file.exists()) {
                    long length2 = file.length();
                    if (length2 <= 0 || length2 >= 2147483648L) {
                        aVar.fileLenInvalidCount++;
                        if (bVar != null) {
                            bVar.fileLenInvalidCount++;
                        }
                        if (cVar != null) {
                            cVar.hKe++;
                        }
                    } else {
                        aVar.fLh += length2;
                        if (bVar != null) {
                            bVar.fLh += length2;
                        }
                        if (cVar != null) {
                            cVar.fLh = length2 + cVar.fLh;
                        }
                    }
                } else {
                    w.i("MicroMsg.SubCoreBaseMonitor", "summerhv scanFile file not exist[%s][%d] ret", file.getAbsolutePath(), Long.valueOf(aVar.hJY));
                }
            }
        }
        return aVar;
    }

    public final void Hx() {
        int i;
        ap.yY();
        int intValue = ((Integer) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_MM_LVFETIME_REPORT_PID_INT, Integer.valueOf(0))).intValue();
        ap.yY();
        long longValue = ((Long) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_MM_LVFETIME_REPORT_LIFETIME_LONG, Long.valueOf(0))).longValue();
        ap.yY();
        int intValue2 = ((Integer) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_MM_LVFETIME_REPORT_MEMORY_PSS_INT, Integer.valueOf(0))).intValue();
        int myPid = Process.myPid();
        MemoryInfo[] processMemoryInfo = ((ActivityManager) ab.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[]{myPid});
        if (processMemoryInfo == null || processMemoryInfo.length <= 0 || processMemoryInfo[0] == null) {
            i = -1;
        } else {
            i = processMemoryInfo[0].getTotalPss();
        }
        if (intValue == 0) {
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.USERINFO_MM_LVFETIME_REPORT_PID_INT, Integer.valueOf(myPid));
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.USERINFO_MM_LVFETIME_REPORT_LIFETIME_LONG, Long.valueOf(System.currentTimeMillis() - startTime));
            ap.yY();
            t vr = c.vr();
            com.tencent.mm.storage.w.a aVar = com.tencent.mm.storage.w.a.USERINFO_MM_LVFETIME_REPORT_MEMORY_PSS_INT;
            if (i <= 0) {
                i = 0;
            }
            vr.a(aVar, Integer.valueOf(i));
        } else if (intValue != myPid) {
            g.oUh.i(13778, Integer.valueOf(5), Integer.valueOf(1), Long.valueOf(longValue));
            g.oUh.i(13778, Integer.valueOf(5), Integer.valueOf(2), Integer.valueOf(intValue2));
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.USERINFO_MM_LVFETIME_REPORT_PID_INT, Integer.valueOf(myPid));
            long currentTimeMillis = System.currentTimeMillis() - startTime;
            if (i <= 0) {
                i = 0;
            }
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.USERINFO_MM_LVFETIME_REPORT_LIFETIME_LONG, Long.valueOf(currentTimeMillis));
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.USERINFO_MM_LVFETIME_REPORT_MEMORY_PSS_INT, Integer.valueOf(i));
            w.i("MicroMsg.SubCoreBaseMonitor", "summerhv reportLifeTime lifeTime[%d -> %d]ms,  pss[%d -> %d], pid[%d -> %d]", Long.valueOf(longValue), Long.valueOf(currentTimeMillis), Integer.valueOf(intValue2), Integer.valueOf(i), Integer.valueOf(intValue), Integer.valueOf(myPid));
        } else {
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.USERINFO_MM_LVFETIME_REPORT_LIFETIME_LONG, Long.valueOf(System.currentTimeMillis() - startTime));
            if (i > intValue2) {
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.USERINFO_MM_LVFETIME_REPORT_MEMORY_PSS_INT, Integer.valueOf(i));
            }
        }
        this.hLV.v(180000, 180000);
    }

    public final synchronized void a(int i, long j, long j2) {
        long j3;
        boolean z = j > j2;
        if (z) {
            j3 = this.hLQ | ((long) i);
        } else {
            j3 = this.hLQ & ((long) (i ^ -1));
        }
        w.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser type[%d] value[%d] limit[%d] heavy[%b] mHeavyUser[%d] newHeavyUser[%d] tid[%s]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z), Long.valueOf(this.hLQ), Long.valueOf(j3), Long.valueOf(Thread.currentThread().getId()));
        if (j3 != this.hLQ) {
            if (this.hLQ == 0) {
                g.oUh.a(509, 1, 1, true);
            }
            if (j3 == 0) {
                g.oUh.a(509, 2, 1, true);
            }
        }
        com.tencent.mm.storage.w.a aVar = null;
        com.tencent.mm.storage.w.a aVar2;
        switch (i) {
            case 1:
                aVar2 = com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TYPE_SD_FILE_SIZE_LONG;
                g.oUh.a(509, z ? 3 : 4, 1, true);
                aVar = aVar2;
                break;
            case 2:
                aVar2 = com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TYPE_SD_FILE_RATIO_LONG;
                g.oUh.a(509, z ? 5 : 6, 1, true);
                aVar = aVar2;
                break;
            case 4:
                aVar2 = com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_SIZE_LONG;
                g.oUh.a(509, z ? 7 : 8, 1, true);
                aVar = aVar2;
                break;
            case 8:
                aVar2 = com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_MESSAGE_LONG;
                g.oUh.a(509, z ? 9 : 10, 1, true);
                aVar = aVar2;
                break;
            case 16:
                aVar2 = com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CONVERSATION_LONG;
                g.oUh.a(509, z ? 11 : 12, 1, true);
                aVar = aVar2;
                break;
            case 32:
                aVar2 = com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CONTACT_LONG;
                g.oUh.a(509, z ? 13 : 14, 1, true);
                aVar = aVar2;
                break;
            case 64:
                aVar2 = com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CHATROOM_LONG;
                g.oUh.a(509, z ? 15 : 16, 1, true);
                aVar = aVar2;
                break;
            case FileUtils.S_IWUSR /*128*/:
                aVar2 = com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_REPORT_TYPE_FAV_DB_SIZE_LONG;
                g.oUh.a(509, z ? 19 : 20, 1, true);
                aVar = aVar2;
                break;
        }
        this.hLQ = j3;
        d.gE(j3 != 0);
        final long j4 = j3;
        final long j5 = j;
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ p hLW;

            public final void run() {
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.USERINFO_HEAVY_USER_FLAG_LONG, Long.valueOf(j4));
                if (aVar != null) {
                    ap.yY();
                    c.vr().a(aVar, Long.valueOf(j5));
                }
                w.i("MicroMsg.SubCoreBaseMonitor", "summerhv resetHeavyUser heavyUser[%d, %d], fkey[%s], value[%d]", Long.valueOf(j4), Long.valueOf(this.hLW.hLQ), aVar, Long.valueOf(j5));
            }
        });
    }
}
