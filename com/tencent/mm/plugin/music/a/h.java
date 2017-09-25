package com.tencent.mm.plugin.music.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.am.a;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.music.a.e.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class h {
    private static final Pattern mlF = Pattern.compile("songid=([0-9]+)");
    private static final String[] nTj = new String[]{"#", "?", "&"};
    private static String nTk = null;
    private static String nTl = null;

    public static String cD(Context context) {
        Throwable th;
        String str = "";
        String packageName = ab.getPackageName();
        if (packageName != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
                if (packageInfo != null) {
                    packageName = str + packageInfo.versionName;
                    try {
                        str = packageName + "." + packageInfo.versionCode;
                    } catch (Throwable e) {
                        Throwable th2 = e;
                        str = packageName;
                        th = th2;
                        w.printErrStackTrace("MicroMsg.Music.MusicUtil", th, "", new Object[0]);
                        return str;
                    }
                }
            } catch (NameNotFoundException e2) {
                th = e2;
                w.printErrStackTrace("MicroMsg.Music.MusicUtil", th, "", new Object[0]);
                return str;
            }
        }
        return str;
    }

    public static String e(a aVar, boolean z) {
        ap.yY();
        File file = new File(c.xv(), "music");
        if (!file.exists()) {
            w.i("MicroMsg.Music.MusicUtil", "create file folder:%b for path:%s", new Object[]{Boolean.valueOf(file.mkdirs()), file.getAbsolutePath()});
        }
        w.d("MicroMsg.Music.MusicUtil", "music name %s path %s", new Object[]{z ? aa.Pq(aVar.field_musicId + "temp") + "-wifi" : aa.Pq(aVar.field_musicId + "temp"), new File(file, z ? aa.Pq(aVar.field_musicId + "temp") + "-wifi" : aa.Pq(aVar.field_musicId + "temp")).getAbsoluteFile()});
        return new File(file, z ? aa.Pq(aVar.field_musicId + "temp") + "-wifi" : aa.Pq(aVar.field_musicId + "temp")).getAbsolutePath();
    }

    public static String Bq(String str) {
        ap.yY();
        File file = new File(c.xv(), "music");
        if (!file.exists()) {
            file.mkdirs();
        }
        w.d("MicroMsg.Music.MusicUtil", "getMusicPieceFilePath music name %s path %s", new Object[]{Bv(str), new File(file, Bv(str)).getAbsoluteFile()});
        return new File(file, Bv(str)).getAbsolutePath();
    }

    public static String f(a aVar, boolean z) {
        return e(aVar, false) + "-thumb-" + z;
    }

    public static boolean Br(String str) {
        if (bg.mA(str)) {
            return false;
        }
        boolean contains;
        Uri parse = Uri.parse(str);
        String str2 = "";
        if (parse != null) {
            str2 = parse.getHost();
        }
        if (str2 != null) {
            contains = parse.getHost().contains(".qq.com");
            w.w("MicroMsg.Music.MusicUtil", "url %s match ? %B", new Object[]{str, Boolean.valueOf(contains)});
        } else {
            w.i("MicroMsg.Music.MusicUtil", "host is null, url is not match .qq.com");
            contains = false;
        }
        return contains;
    }

    public static boolean e(a aVar) {
        w.d("MicroMsg.Music.MusicUtil", "music urls: %s,  %s,  %s", new Object[]{aVar.field_songWapLinkUrl, aVar.field_songWebUrl, aVar.field_songWifiUrl});
        if (bg.mA(aVar.field_songWapLinkUrl) && bg.mA(aVar.field_songWebUrl) && bg.mA(aVar.field_songWifiUrl)) {
            return false;
        }
        return true;
    }

    public static String a(String str, String str2, boolean z, PBool pBool) {
        String str3;
        if (z || bg.mA(str2)) {
            str3 = str;
        } else {
            str3 = str2;
        }
        if (bg.mA(str3)) {
            return str3;
        }
        PString pString = new PString();
        w.i("MicroMsg.Music.MusicUtil", "url[%s], lowBandUrl[%s], isWifi[%B]", new Object[]{str, str2, Boolean.valueOf(z)});
        String Bs = Bs(str3);
        if (Bs != null) {
            if (a(Bs, z, pString)) {
                pBool.value = z;
            }
        } else if (str3.contains("wechat_music_url=")) {
            a(str3.substring(str3.indexOf("wechat_music_url=") + 17), z, pString);
        } else {
            pString.value = str3;
        }
        return pString.value;
    }

    private static String Bs(String str) {
        if (bg.mA(str)) {
            return null;
        }
        if (nTk != null && str.equals(nTk)) {
            return nTl;
        }
        String str2 = "";
        String str3 = null;
        for (String str22 : nTj) {
            str22 = str22 + "p=";
            if (str.contains(str22)) {
                str3 = str;
            }
            if (str3 != null) {
                break;
            }
        }
        String str4 = str3;
        str3 = str22;
        if (str4 == null) {
            return null;
        }
        int indexOf = str4 == null ? -1 : str4.indexOf(str3);
        if (indexOf < 0) {
            w.w("MicroMsg.Music.MusicUtil", "pIndex is %d, return", new Object[]{Integer.valueOf(indexOf)});
            return null;
        }
        String substring = str4.substring(str3.length() + indexOf);
        for (String indexOf2 : nTj) {
            int indexOf3 = substring.indexOf(indexOf2);
            if (indexOf3 > 0) {
                substring = substring.substring(0, indexOf3);
            }
        }
        if (substring == null) {
            return substring;
        }
        nTk = str;
        nTl = substring;
        return substring;
    }

    private static boolean a(String str, boolean z, PString pString) {
        String str2 = new String(Bt(str));
        int indexOf = str2.indexOf("{");
        if (indexOf != -1) {
            str2 = str2.substring(indexOf);
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String string = jSONObject.getString("song_WapLiveURL");
            str2 = jSONObject.getString("song_WifiURL");
            w.d("MicroMsg.Music.MusicUtil", "waplive: " + string + "  wifi:" + str2);
            if (!z) {
                str2 = string;
            }
            pString.value = str2;
            return true;
        } catch (Exception e) {
            pString.value = str;
            return false;
        }
    }

    private static byte[] Bt(String str) {
        byte[] bArr = new byte[((str.length() / 2) + (str.length() % 2))];
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            try {
                int i3 = i + 1;
                int h = h(str.charAt(i));
                if (i3 < str.length()) {
                    i = i3 + 1;
                    i3 = h(str.charAt(i3));
                } else {
                    i = i3;
                    i3 = 0;
                }
                int i4 = i2 + 1;
                bArr[i2] = (byte) (i3 | (h << 4));
                i2 = i4;
            } catch (Exception e) {
                return null;
            }
        }
        return bArr;
    }

    private static int Bu(String str) {
        int i = 0;
        if (!bg.mA(str)) {
            Matcher matcher = mlF.matcher(str);
            if (matcher.find()) {
                try {
                    i = Integer.valueOf(matcher.group(1)).intValue();
                } catch (Exception e) {
                }
            }
        }
        return i;
    }

    private static int h(char c) {
        if (c >= '1' && c <= '9') {
            return c - 48;
        }
        if (c < 'A' || c > 'F') {
            return 0;
        }
        return (c - 65) + 10;
    }

    private static String f(anf com_tencent_mm_protocal_c_anf) {
        String str;
        String Bs;
        if (com_tencent_mm_protocal_c_anf != null) {
            if (!bg.mA(com_tencent_mm_protocal_c_anf.tRN)) {
                str = com_tencent_mm_protocal_c_anf.tRN;
            } else if (!bg.mA(com_tencent_mm_protocal_c_anf.tRP)) {
                str = com_tencent_mm_protocal_c_anf.tRP;
            } else if (!bg.mA(com_tencent_mm_protocal_c_anf.tRO)) {
                str = com_tencent_mm_protocal_c_anf.tRO;
            }
            if (str == null) {
                return null;
            }
            Bs = Bs(com_tencent_mm_protocal_c_anf.tRN);
            if (Bs == null) {
                return Bs;
            }
            Bs = Bs(com_tencent_mm_protocal_c_anf.tRP);
            if (Bs != null) {
                return Bs(com_tencent_mm_protocal_c_anf.tRO);
            }
            return Bs;
        }
        str = null;
        if (str == null) {
            return null;
        }
        Bs = Bs(com_tencent_mm_protocal_c_anf.tRN);
        if (Bs == null) {
            return Bs;
        }
        Bs = Bs(com_tencent_mm_protocal_c_anf.tRP);
        if (Bs != null) {
            return Bs;
        }
        return Bs(com_tencent_mm_protocal_c_anf.tRO);
    }

    public static anf g(anf com_tencent_mm_protocal_c_anf) {
        if (com_tencent_mm_protocal_c_anf != null) {
            com_tencent_mm_protocal_c_anf.tGt = Bu(com_tencent_mm_protocal_c_anf.tRN);
            if (com_tencent_mm_protocal_c_anf.tGt <= 0) {
                com_tencent_mm_protocal_c_anf.tGt = Bu(com_tencent_mm_protocal_c_anf.tRP);
                if (com_tencent_mm_protocal_c_anf.tGt <= 0) {
                    com_tencent_mm_protocal_c_anf.tGt = Bu(com_tencent_mm_protocal_c_anf.tRO);
                    int i = com_tencent_mm_protocal_c_anf.tGt;
                }
            }
        }
        if (!(com_tencent_mm_protocal_c_anf == null || f(com_tencent_mm_protocal_c_anf) == null)) {
            long currentTimeMillis = System.currentTimeMillis();
            w.d("MicroMsg.Music.MusicUtil", "bcdUrl: %s", new Object[]{f(com_tencent_mm_protocal_c_anf)});
            String str = new String(Bt(r1));
            int indexOf = str.indexOf("{");
            if (indexOf != -1) {
                str = str.substring(indexOf);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                com_tencent_mm_protocal_c_anf.tGt = jSONObject.getInt("song_ID");
                if (bg.mA(com_tencent_mm_protocal_c_anf.tRJ)) {
                    com_tencent_mm_protocal_c_anf.tRJ = jSONObject.getString("song_Name");
                }
                if (bg.mA(com_tencent_mm_protocal_c_anf.tRO)) {
                    com_tencent_mm_protocal_c_anf.tRO = jSONObject.getString("song_WapLiveURL");
                }
                if (bg.mA(com_tencent_mm_protocal_c_anf.tRN)) {
                    com_tencent_mm_protocal_c_anf.tRN = jSONObject.getString("song_WifiURL");
                }
                if (bg.mA(com_tencent_mm_protocal_c_anf.tRL)) {
                    com_tencent_mm_protocal_c_anf.tRL = jSONObject.getString("song_Album");
                }
                if (bg.mA(com_tencent_mm_protocal_c_anf.tRK)) {
                    com_tencent_mm_protocal_c_anf.tRK = jSONObject.getString("song_Singer");
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.Music.MusicUtil", e, "", new Object[0]);
            }
            if (com_tencent_mm_protocal_c_anf.tGt == 0) {
                com_tencent_mm_protocal_c_anf.tGt = Bu(nTk);
            }
            w.i("MicroMsg.Music.MusicUtil", "parseBCDForMusicWrapper %s: expend: %d %d", new Object[]{com_tencent_mm_protocal_c_anf.tqY, Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(com_tencent_mm_protocal_c_anf.tGt)});
        }
        return com_tencent_mm_protocal_c_anf;
    }

    public static String h(anf com_tencent_mm_protocal_c_anf) {
        if (com_tencent_mm_protocal_c_anf.tRH == 6) {
            return "6_" + aa.Pq(com_tencent_mm_protocal_c_anf.tqY);
        }
        return "0_" + aa.Pq(com_tencent_mm_protocal_c_anf.tqY);
    }

    public static String Bv(String str) {
        return "piece" + aa.Pq(str.hashCode());
    }

    public static void a(anf com_tencent_mm_protocal_c_anf, Activity activity) {
        g.oUh.A(10910, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        b cbVar = new cb();
        rv rvVar = new rv();
        rw rwVar = new rw();
        rm rmVar = new rm();
        rwVar.OD(m.xL());
        rwVar.OE(m.xL());
        rwVar.yj(5);
        rwVar.ep(bg.Nz());
        rwVar.OJ(j(com_tencent_mm_protocal_c_anf));
        rmVar.NS(com_tencent_mm_protocal_c_anf.tRN);
        rmVar.NT(com_tencent_mm_protocal_c_anf.tRO);
        rmVar.NR(com_tencent_mm_protocal_c_anf.tRP);
        a BE = i.aNT().BE(h(com_tencent_mm_protocal_c_anf));
        if (BE.HF()) {
            rmVar.NU(BE.field_songHAlbumUrl);
        } else {
            rmVar.NU(BE.field_songAlbumUrl);
        }
        rmVar.jJ(true);
        String i = i(com_tencent_mm_protocal_c_anf);
        if (FileOp.aO(i)) {
            rmVar.Oa(i);
        } else {
            rmVar.jK(true);
        }
        rmVar.NL(com_tencent_mm_protocal_c_anf.tRJ);
        rmVar.NM(com_tencent_mm_protocal_c_anf.tRK);
        rmVar.yb(7);
        cbVar.fFA.title = com_tencent_mm_protocal_c_anf.tRJ;
        cbVar.fFA.desc = com_tencent_mm_protocal_c_anf.tRK;
        cbVar.fFA.fFC = rvVar;
        cbVar.fFA.type = 7;
        rvVar.a(rwVar);
        rvVar.tzn.add(rmVar);
        cbVar.fFA.activity = activity;
        cbVar.fFA.fFH = 3;
        com.tencent.mm.sdk.b.a.urY.m(cbVar);
    }

    public static boolean b(anf com_tencent_mm_protocal_c_anf, Activity activity) {
        g.oUh.A(10910, "4");
        if (com_tencent_mm_protocal_c_anf == null) {
            return false;
        }
        String str;
        String str2 = com_tencent_mm_protocal_c_anf.tRP;
        int indexOf = str2 == null ? -1 : str2.indexOf("#p=");
        if ((indexOf < 0 ? null : str2.substring(indexOf + 3)) == null) {
            w.e("MicroMsg.Music.MusicUtil", "wtf, get qq music data fail, url %s", new Object[]{str2});
            str = "androidqqmusic://";
        } else {
            w.i("MicroMsg.Music.MusicUtil", "get qq music data %s", new Object[]{indexOf < 0 ? null : str2.substring(indexOf + 3)});
            str = String.format("androidqqmusic://from=webPlayer&data=%s", new Object[]{str});
        }
        Uri parse = Uri.parse(str);
        if (parse == null) {
            w.w("MicroMsg.Music.MusicUtil", "parse qq music action url fail, url %s", new Object[]{str});
            return false;
        }
        com.tencent.mm.am.b.HH();
        Intent intent = new Intent("android.intent.action.VIEW", parse);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        if (bg.j(activity, intent)) {
            activity.startActivity(intent);
            return true;
        }
        intent = new Intent();
        intent.putExtra("rawUrl", str2);
        b.imv.j(intent, activity);
        return false;
    }

    public static void H(Activity activity) {
        Intent intent = new Intent();
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("scene_from", 6);
        d.a(activity, ".ui.transmit.SelectConversationUI", intent, 1);
    }

    public static void a(anf com_tencent_mm_protocal_c_anf, Intent intent, MMActivity mMActivity) {
        String stringExtra = intent.getStringExtra("Select_Conv_User");
        IMediaObject wXMusicObject = new WXMusicObject();
        wXMusicObject.musicUrl = com_tencent_mm_protocal_c_anf.tRP;
        wXMusicObject.musicDataUrl = com_tencent_mm_protocal_c_anf.tRN;
        wXMusicObject.musicLowBandUrl = com_tencent_mm_protocal_c_anf.tRO;
        wXMusicObject.musicLowBandDataUrl = com_tencent_mm_protocal_c_anf.tRO;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXMusicObject;
        wXMediaMessage.title = com_tencent_mm_protocal_c_anf.tRJ;
        wXMediaMessage.description = com_tencent_mm_protocal_c_anf.tRK;
        Bitmap bitmap = null;
        String i = i(com_tencent_mm_protocal_c_anf);
        if (i != null && FileOp.aO(i)) {
            int dimension = (int) mMActivity.getResources().getDimension(R.f.aXB);
            bitmap = com.tencent.mm.sdk.platformtools.d.O(i, dimension, dimension);
        }
        if (bitmap != null) {
            wXMediaMessage.thumbData = bg.O(bitmap);
        } else {
            wXMediaMessage.thumbData = bg.O(com.tencent.mm.sdk.platformtools.d.yp(R.g.beu));
        }
        b.imv.a(mMActivity, j(com_tencent_mm_protocal_c_anf), wXMediaMessage, stringExtra, k(com_tencent_mm_protocal_c_anf));
        w.i("MicroMsg.Music.MusicUtil", "succeed to share to friend:%s", new Object[]{stringExtra});
    }

    public static void c(anf com_tencent_mm_protocal_c_anf, Activity activity) {
        IMediaObject wXMusicObject = new WXMusicObject();
        wXMusicObject.musicUrl = com_tencent_mm_protocal_c_anf.tRP;
        wXMusicObject.musicDataUrl = com_tencent_mm_protocal_c_anf.tRN;
        wXMusicObject.musicLowBandUrl = com_tencent_mm_protocal_c_anf.tRO;
        wXMusicObject.musicLowBandDataUrl = com_tencent_mm_protocal_c_anf.tRO;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXMusicObject;
        wXMediaMessage.title = com_tencent_mm_protocal_c_anf.tRJ;
        wXMediaMessage.description = com_tencent_mm_protocal_c_anf.tRK;
        Bitmap bitmap = null;
        String i = i(com_tencent_mm_protocal_c_anf);
        if (i != null && FileOp.aO(i)) {
            int dimension = (int) activity.getResources().getDimension(R.f.aXB);
            bitmap = com.tencent.mm.sdk.platformtools.d.O(i, dimension, dimension);
        }
        if (bitmap != null) {
            wXMediaMessage.thumbData = bg.O(bitmap);
        } else {
            wXMediaMessage.thumbData = bg.O(com.tencent.mm.sdk.platformtools.d.yp(R.g.beu));
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        Req req = new Req();
        req.message = wXMediaMessage;
        req.toBundle(bundle);
        intent.putExtra("Ksnsupload_timeline", bundle);
        intent.putExtra("Ksnsupload_musicid", com_tencent_mm_protocal_c_anf.tqY);
        intent.putExtra("Ksnsupload_appid", j(com_tencent_mm_protocal_c_anf));
        intent.putExtra("Ksnsupload_appname", k(com_tencent_mm_protocal_c_anf));
        String fQ = q.fQ("music_player");
        q.yC().n(fQ, true).l("prePublishId", "music_player");
        intent.putExtra("reportSessionId", fQ);
        b.imv.n(intent, activity);
    }

    private static String i(anf com_tencent_mm_protocal_c_anf) {
        String f = f(i.aNT().BE(h(com_tencent_mm_protocal_c_anf)), true);
        if (!FileOp.aO(f)) {
            switch (com_tencent_mm_protocal_c_anf.tRH) {
                case 0:
                    f = n.GS().v(com_tencent_mm_protocal_c_anf.tRR, true);
                    break;
                case 4:
                    f = l.a.bCn().Ee(com_tencent_mm_protocal_c_anf.tRM);
                    if (bg.mA(f)) {
                        f = com_tencent_mm_protocal_c_anf.tRR;
                        break;
                    }
                    break;
                case 5:
                    if (com_tencent_mm_protocal_c_anf.tRR != null) {
                        f = com_tencent_mm_protocal_c_anf.tRR;
                        break;
                    }
                    f = "";
                    break;
                case 6:
                    if (com_tencent_mm_protocal_c_anf.tRR != null) {
                        f = com_tencent_mm_protocal_c_anf.tRR;
                        break;
                    }
                    f = "";
                    break;
                case 7:
                case 10:
                case 11:
                    if (com_tencent_mm_protocal_c_anf.tRR != null) {
                        f = com_tencent_mm_protocal_c_anf.tRR;
                        break;
                    }
                    f = "";
                    break;
                default:
                    if (com.tencent.mm.plugin.sns.b.m.pQB != null) {
                        alh com_tencent_mm_protocal_c_alh = new alh();
                        com_tencent_mm_protocal_c_alh.mQY = com_tencent_mm_protocal_c_anf.ttW;
                        com_tencent_mm_protocal_c_alh.tPi = com_tencent_mm_protocal_c_anf.tRM;
                        com_tencent_mm_protocal_c_alh.tPj = com_tencent_mm_protocal_c_anf.tRT;
                        com_tencent_mm_protocal_c_alh.msN = com_tencent_mm_protocal_c_alh.tPi;
                        f = com.tencent.mm.plugin.sns.b.m.pQA.a(com_tencent_mm_protocal_c_alh);
                        break;
                    }
                    break;
            }
        }
        w.i("MicroMsg.Music.MusicUtil", "real album path = %s", new Object[]{f});
        return f;
    }

    public static String j(anf com_tencent_mm_protocal_c_anf) {
        String str = com_tencent_mm_protocal_c_anf.mtb;
        if (!bg.mA(str)) {
            return str;
        }
        switch (com_tencent_mm_protocal_c_anf.tRH) {
            case 4:
                return "wx485a97c844086dc9";
            case 5:
                return "wx482a4001c37e2b74";
            default:
                return str;
        }
    }

    private static String k(anf com_tencent_mm_protocal_c_anf) {
        switch (com_tencent_mm_protocal_c_anf.tRH) {
            case 0:
            case 1:
            case 8:
                return ab.getContext().getString(R.l.eWU);
            case 4:
                return ab.getContext().getString(R.l.eVE);
            case 5:
                return ab.getContext().getString(R.l.eOX);
            default:
                return ab.getContext().getString(R.l.ebm);
        }
    }

    public static void I(Activity activity) {
        ap.yY();
        if (((Boolean) c.vr().get(82, Boolean.valueOf(true))).booleanValue()) {
            ap.yY();
            c.vr().set(82, Boolean.valueOf(false));
            switch (i.aNS().aNI().field_musicType) {
                case 0:
                    C(activity, R.l.eVe);
                    return;
                case 1:
                case 8:
                    C(activity, R.l.eVh);
                    return;
                case 4:
                    C(activity, R.l.eVg);
                    return;
                case 6:
                    C(activity, R.l.eVf);
                    return;
                default:
                    return;
            }
        } else if (i.aNS().mode == 2) {
            Toast.makeText(ab.getContext(), R.l.eXt, 0).show();
        } else {
            Toast.makeText(ab.getContext(), R.l.eXu, 0).show();
        }
    }

    public static boolean qd(int i) {
        switch (i) {
            case 10:
            case 11:
                return true;
            default:
                return f.ql(i);
        }
    }

    public static void C(String str, String str2, int i) {
        w.i("MicroMsg.Music.MusicUtil", "gotoAppbrand(), appId:%s, appUserName:%s, pkgType:%d", new Object[]{str, str2, Integer.valueOf(i)});
        b prVar = new pr();
        prVar.fWB.appId = str;
        prVar.fWB.fWF = -1;
        prVar.fWB.fWE = i;
        prVar.fWB.userName = str2;
        prVar.fWB.scene = 1056;
        if (i == 1) {
            prVar.fWB.fWH = true;
        }
        com.tencent.mm.sdk.b.a.urY.m(prVar);
    }

    private static com.tencent.mm.ui.base.h C(Context context, int i) {
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.zW(R.l.dIO);
        aVar.zX(i);
        aVar.zZ(R.l.eCa).a(null);
        aVar.kK(true);
        com.tencent.mm.ui.base.h WJ = aVar.WJ();
        WJ.show();
        return WJ;
    }
}
