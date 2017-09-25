package com.tencent.mm.plugin.webview.wepkg.downloader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.webview.wepkg.utils.a;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WePkgDownloader {
    private static volatile WePkgDownloader sps = null;
    public Map<String, IWepkgUpdateCallback> spt;
    private a spu = new a(this) {
        final /* synthetic */ WePkgDownloader spv;

        {
            this.spv = r1;
        }

        public final synchronized void a(g gVar) {
            String str;
            RetCode retCode;
            d.bAt().KA(gVar.sph.spE);
            if (gVar.mStatus == 1) {
                str = gVar.sph.mFilePath;
                if (bg.mA(str) || !new File(str).exists()) {
                    w.e("MicroMsg.Wepkg.WepkgDownloader", "onDownloadComplete, pkgPath is null or nil");
                    retCode = RetCode.LOCAL_FILE_NOT_FOUND;
                } else {
                    if (bg.mz(g.aV(str)).equalsIgnoreCase(gVar.sph.kPx)) {
                        retCode = RetCode.OK;
                    } else {
                        w.e("MicroMsg.Wepkg.WepkgDownloader", "onDownloadComplete, file.md5(%s) != net.md5(%s)", new Object[]{g.aV(str), gVar.sph.kPx});
                        b.deleteFile(str);
                        RetCode retCode2 = RetCode.PKG_INTEGRITY_FAILED;
                        gVar.lav = 1012;
                        retCode = retCode2;
                    }
                }
            } else {
                retCode = RetCode.FAILED;
            }
            w.i("MicroMsg.Wepkg.WepkgDownloader", "download callback retCode:" + retCode);
            IWepkgUpdateCallback iWepkgUpdateCallback = (IWepkgUpdateCallback) this.spv.spt.remove(gVar.sph.spE);
            if (iWepkgUpdateCallback != null) {
                iWepkgUpdateCallback.a(gVar.sph.spF, gVar.sph.mFilePath, retCode);
            } else {
                w.i("MicroMsg.Wepkg.WepkgDownloader", "download callback invalid");
                a.b("CallbackInvalid", gVar.sph.mUrl, gVar.sph.spF, null, -1, 0, null);
            }
            if (gVar.sph.kGV == 1) {
                str = gVar.sph.spF;
                WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                wepkgCrossProcessTask.ou = 3008;
                wepkgCrossProcessTask.sqr.sqL = str;
                if (ab.bJb()) {
                    wepkgCrossProcessTask.PM();
                } else {
                    WepkgMainProcessService.b(wepkgCrossProcessTask);
                }
            } else {
                str = gVar.sph.spF;
                String str2 = gVar.sph.spG;
                WepkgMainProcessTask wepkgCrossProcessTask2 = new WepkgCrossProcessTask();
                wepkgCrossProcessTask2.ou = 4005;
                wepkgCrossProcessTask2.sqt.sqL = str;
                wepkgCrossProcessTask2.sqt.sqw = str2;
                if (ab.bJb()) {
                    wepkgCrossProcessTask2.PM();
                } else {
                    WepkgMainProcessService.b(wepkgCrossProcessTask2);
                }
            }
            WePkgDownloader.b(gVar);
        }
    };

    public interface IWepkgUpdateCallback {

        public enum RetCode implements Parcelable {
            OK,
            LOCAL_FILE_NOT_FOUND,
            PKG_INTEGRITY_FAILED,
            PKG_INVALID,
            FAILED,
            CANCEL;
            
            public static final Creator<RetCode> CREATOR = null;

            static {
                CREATOR = new Creator<RetCode>() {
                    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                        return RetCode.values()[parcel.readInt()];
                    }

                    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                        return new RetCode[i];
                    }
                };
            }

            public final int describeContents() {
                return 0;
            }

            public final void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(ordinal());
            }
        }

        void a(String str, String str2, RetCode retCode);
    }

    public static WePkgDownloader bAv() {
        if (sps == null) {
            synchronized (WePkgDownloader.class) {
                if (sps == null) {
                    sps = new WePkgDownloader();
                }
            }
        }
        return sps;
    }

    public WePkgDownloader() {
        if (this.spt == null) {
            this.spt = new ConcurrentHashMap();
        }
    }

    public final void a(int i, String str, String str2, String str3, long j, String str4, String str5, int i2, IWepkgUpdateCallback iWepkgUpdateCallback) {
        String ec;
        String str6;
        w.i("MicroMsg.Wepkg.WepkgDownloader", "triggerDownloadWepkg, fileType:%s, pkgid:%s, downloadUrl:%s, pkgSize:%d, version:%s, md5:%s, downloadNetType:%d", new Object[]{Integer.valueOf(i), str, str3, Long.valueOf(j), str4, str5, Integer.valueOf(i2)});
        if (i == 1) {
            ec = d.ec(str, str4);
            d.KS(ec);
            str6 = ec + "/package";
        } else {
            ec = d.ec(str, str4) + "/preload_files";
            d.KS(ec);
            str6 = ec + "/" + str5;
        }
        if (bg.mA(str6)) {
            w.i("MicroMsg.Wepkg.WepkgDownloader", "pkgPath:%s is null", new Object[]{str6});
            iWepkgUpdateCallback.a(str, "", RetCode.FAILED);
            return;
        }
        Object obj;
        File file;
        boolean z;
        boolean z2;
        c cVar;
        d bAt;
        if (!bg.mA(str6)) {
            File file2 = new File(str6);
            if (file2.exists() && file2.isFile()) {
                obj = 1;
                if (obj != null) {
                    ec = d.KN(str);
                    if (!bg.mA(ec)) {
                        File file3 = new File(ec);
                        List<String> arrayList = new ArrayList();
                        if (str6 != null || str6.length() <= 0) {
                            ec = "";
                        } else {
                            ec = new File(str6).getName();
                            int lastIndexOf = ec.lastIndexOf(46);
                            if (lastIndexOf >= 0) {
                                ec = lastIndexOf == 0 ? "" : ec.substring(0, lastIndexOf);
                            }
                        }
                        a(file3, ec, arrayList);
                        w.i("MicroMsg.Wepkg.WepkgDownloader", "local have the same file. size:%s", new Object[]{Integer.valueOf(arrayList.size())});
                        for (String ec2 : arrayList) {
                            file = new File(ec2);
                            if (!file.isFile() && file.length() == j && bg.mz(g.f(file)).equalsIgnoreCase(str5)) {
                                e.p(file.getAbsolutePath(), str6);
                                w.i("MicroMsg.Wepkg.WepkgDownloader", "file exist in other version path:%s, pkgPath:%s", new Object[]{file.getAbsolutePath(), str6});
                                iWepkgUpdateCallback.a(str, str6, RetCode.OK);
                                return;
                            }
                        }
                    }
                } else if (bg.mz(g.aV(str6)).equals(str5)) {
                    w.i("MicroMsg.Wepkg.WepkgDownloader", "file exist in current %s version, pkgPath:%s", new Object[]{str4, str6});
                    iWepkgUpdateCallback.a(str, str6, RetCode.OK);
                    return;
                }
                z = false;
                z2 = false;
                switch (i2) {
                    case 1:
                        if (am.isWifi(ab.getContext())) {
                            z = true;
                            z2 = true;
                            break;
                        }
                        break;
                    case 3:
                        if (am.eh(ab.getContext()) || am.is3G(ab.getContext())) {
                            z = true;
                            break;
                        }
                    case 4:
                        z = true;
                        break;
                    case 9:
                        if (!am.isWifi(ab.getContext())) {
                            if ((am.eh(ab.getContext()) || am.is3G(ab.getContext())) && d.bAE()) {
                                z = true;
                                break;
                            }
                        }
                        z = true;
                        break;
                }
                w.i("MicroMsg.Wepkg.WepkgDownloader", "allowDownload:%s", new Object[]{Boolean.valueOf(z)});
                if (z) {
                    w.i("MicroMsg.Wepkg.WepkgDownloader", "net is not match, dont download");
                    iWepkgUpdateCallback.a(str, "", RetCode.CANCEL);
                    return;
                }
                cVar = new c(new f(g.n(str3.getBytes()), i, str, str2, str4, str3, str6, j, str5, z2, this.spu));
                bAt = d.bAt();
                if (bAt.spr.containsKey(cVar.sph.spE)) {
                    cVar.spi = b.bAr().spg.submit(cVar);
                    bAt.spr.put(cVar.sph.spE, cVar);
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    this.spt.put(g.n(str3.getBytes()), iWepkgUpdateCallback);
                } else {
                    iWepkgUpdateCallback.a(str, "", RetCode.CANCEL);
                }
            }
        }
        obj = null;
        if (obj != null) {
            ec2 = d.KN(str);
            if (bg.mA(ec2)) {
                File file32 = new File(ec2);
                List<String> arrayList2 = new ArrayList();
                if (str6 != null) {
                }
                ec2 = "";
                a(file32, ec2, arrayList2);
                w.i("MicroMsg.Wepkg.WepkgDownloader", "local have the same file. size:%s", new Object[]{Integer.valueOf(arrayList2.size())});
                while (r3.hasNext()) {
                    file = new File(ec2);
                    if (!file.isFile()) {
                    }
                }
            }
        } else if (bg.mz(g.aV(str6)).equals(str5)) {
            w.i("MicroMsg.Wepkg.WepkgDownloader", "file exist in current %s version, pkgPath:%s", new Object[]{str4, str6});
            iWepkgUpdateCallback.a(str, str6, RetCode.OK);
            return;
        }
        z = false;
        z2 = false;
        switch (i2) {
            case 1:
                if (am.isWifi(ab.getContext())) {
                    z = true;
                    z2 = true;
                    break;
                }
                break;
            case 3:
                z = true;
                break;
            case 4:
                z = true;
                break;
            case 9:
                if (!am.isWifi(ab.getContext())) {
                    z = true;
                    break;
                } else {
                    z = true;
                    break;
                }
        }
        w.i("MicroMsg.Wepkg.WepkgDownloader", "allowDownload:%s", new Object[]{Boolean.valueOf(z)});
        if (z) {
            w.i("MicroMsg.Wepkg.WepkgDownloader", "net is not match, dont download");
            iWepkgUpdateCallback.a(str, "", RetCode.CANCEL);
            return;
        }
        cVar = new c(new f(g.n(str3.getBytes()), i, str, str2, str4, str3, str6, j, str5, z2, this.spu));
        bAt = d.bAt();
        if (bAt.spr.containsKey(cVar.sph.spE)) {
            obj = null;
        } else {
            cVar.spi = b.bAr().spg.submit(cVar);
            bAt.spr.put(cVar.sph.spE, cVar);
            obj = 1;
        }
        if (obj == null) {
            iWepkgUpdateCallback.a(str, "", RetCode.CANCEL);
        } else {
            this.spt.put(g.n(str3.getBytes()), iWepkgUpdateCallback);
        }
    }

    public static void b(g gVar) {
        f fVar = gVar.sph;
        if (fVar != null) {
            String str = fVar.spF;
            String str2 = fVar.spH;
            int i = gVar.spO;
            int i2 = gVar.lav;
            int i3 = gVar.ihm;
            String ee = am.ee(ab.getContext());
            w.i("MicroMsg.WePkgReport", "pkgId = %s, version = %s, isRange = %d, errCode=%d, retryTimes = %d, netType = %s", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), ee});
            String KL = a.KL(fVar.mUrl);
            Object[] objArr = new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), ee, Integer.valueOf(i3), KL};
            StringBuilder stringBuilder = new StringBuilder();
            for (int i4 = 0; i4 < 6; i4++) {
                stringBuilder.append(String.valueOf(objArr[i4])).append(',');
            }
            stringBuilder.append(String.valueOf(objArr[6]));
            ap.vd().a(new al(14229, stringBuilder.toString()), 0);
        }
    }

    private void a(File file, String str, List<String> list) {
        if (file != null && file.exists()) {
            if (file.isFile() && file.getName().equals(str)) {
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File a : listFiles) {
                        a(a, str, list);
                    }
                }
            }
        }
    }
}
