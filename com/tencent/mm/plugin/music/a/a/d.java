package com.tencent.mm.plugin.music.a.a;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.mm.plugin.music.a.f.b;
import com.tencent.mm.plugin.music.a.f.c;
import com.tencent.mm.plugin.music.a.h;
import com.tencent.mm.plugin.music.a.i;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class d {
    private static y<String, String> nTF = new y(20);
    private static y<String, Boolean> nTG = new y(20);

    public static void Bx(String str) {
        b bVar;
        c aNW = i.aNW();
        if (TextUtils.isEmpty(str)) {
            w.i("MicroMsg.PieceMusicInfoStorage", "updatePieceMusicByUrl url is empty!");
            bVar = null;
        } else {
            int i;
            String Bv = h.Bv(str);
            b BF = aNW.BF(Bv);
            if (BF == null) {
                bVar = new b();
                i = 0;
            } else {
                bVar = BF;
                i = 1;
            }
            bVar.field_musicId = Bv;
            bVar.field_musicUrl = str;
            bVar.field_fileName = h.Bq(str);
            w.i("MicroMsg.PieceMusicInfoStorage", "updatePieceMusicByUrl musicId:%s, field_fileName:%s", new Object[]{Bv, bVar.field_fileName});
            if (i != 0) {
                w.i("MicroMsg.PieceMusicInfoStorage", "update PieceMusicInfo");
                aNW.c(bVar, new String[0]);
            } else {
                w.i("MicroMsg.PieceMusicInfoStorage", "insert PieceMusicInfo");
                aNW.b(bVar);
            }
            aNW.nUv.put(Bv, bVar);
        }
        if (bVar != null) {
            CharSequence charSequence = bVar.field_musicId;
            if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(charSequence))) {
                nTF.put(str, charSequence);
            }
            List arrayList = new ArrayList(1);
            arrayList.add(bVar.field_musicId);
            a aVar = new a(arrayList);
            ap.yY();
            long longValue = ((Long) com.tencent.mm.u.c.vr().get(a.uGJ, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue <= a.nTx.longValue()) {
                w.e("MicroMsg.CleanMusicController", "startClean the last clean time is in MUSIC_NO_SCAN_TIME time");
                return;
            }
            w.i("MicroMsg.CleanMusicController", "start clean music file");
            ap.yY();
            com.tencent.mm.u.c.vr().a(a.uGJ, Long.valueOf(currentTimeMillis));
            e.post(new Runnable(aVar) {
                final /* synthetic */ a nTz;

                {
                    this.nTz = r1;
                }

                public final void run() {
                    a aVar = this.nTz;
                    w.i("MicroMsg.CleanMusicController", "clean music piece file");
                    ap.yY();
                    String xv = com.tencent.mm.u.c.xv();
                    xv = xv.endsWith("/") ? xv + "music" : xv + File.separator + "music";
                    File file = new File(xv);
                    if (file.exists() && file.isDirectory()) {
                        for (String str : file.list()) {
                            if (aVar.Bw(str)) {
                                w.i("MicroMsg.CleanMusicController", "file is the block file, don't delete");
                            } else {
                                File file2 = new File(xv + File.separator + str);
                                if (!file2.exists()) {
                                    w.i("MicroMsg.CleanMusicController", "file not exist");
                                } else if (file2.isDirectory()) {
                                    w.i("MicroMsg.CleanMusicController", "file is directory, don't delete");
                                } else if (System.currentTimeMillis() - file2.lastModified() > a.kyu.longValue()) {
                                    w.e("MicroMsg.CleanMusicController", "Clean 7 days file in music file name=%s, path:%s", new Object[]{file2.getName(), file2.getAbsolutePath()});
                                    file2.delete();
                                    if (str.startsWith("piece")) {
                                        w.e("MicroMsg.CleanMusicController", "file is piece prefix, delete the piece info in db");
                                        c aNW = i.aNW();
                                        int delete = aNW.gUz.delete("PieceMusicInfo", "musicId=?", new String[]{str});
                                        w.i("MicroMsg.PieceMusicInfoStorage", "deletePieceMusicInfo raw=%d musicId=%s", new Object[]{Integer.valueOf(delete), str});
                                        aNW.nUv.remove(str);
                                    }
                                } else {
                                    w.i("MicroMsg.CleanMusicController", "not delete the file, file is in valid time for 7 day");
                                }
                            }
                        }
                        return;
                    }
                    w.i("MicroMsg.CleanMusicController", "musicFolder is not exist or not Directory");
                }
            }, "CleanMusicController");
        }
    }

    public static String By(String str) {
        if (nTF.aV(str)) {
            return (String) nTF.get(str);
        }
        return "";
    }

    public static void ad(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            nTG.put(str, Boolean.valueOf(z));
        }
    }

    public static void g(String str, Map<String, String> map) {
        if (map != null) {
            if (nTG.aV(str) ? ((Boolean) nTG.get(str)).booleanValue() : false) {
                map.put("Cookie", "qqmusic_fromtag=97;qqmusic_uin=1234567;qqmusic_key=;");
                map.put("referer", "stream12.qqmusic.qq.com");
            }
        }
    }

    public static void cX(String str, String str2) {
        w.i("MicroMsg.PieceCacheHelper", "setMusicMIMEType mimeType:%s", new Object[]{str2});
        Object By = By(str);
        if (TextUtils.isEmpty(By)) {
            w.e("MicroMsg.PieceCacheHelper", "setMusicMIMEType musicId is empty!");
            return;
        }
        b BF = i.aNW().BF(By);
        if (BF == null) {
            w.e("MicroMsg.PieceCacheHelper", "setMusicMIMEType pMusic is null!'");
        } else if (TextUtils.isEmpty(BF.field_pieceFileMIMEType)) {
            w.e("MicroMsg.PieceCacheHelper", "updatePieceFileMIMEType()'");
            c aNW = i.aNW();
            ContentValues contentValues = new ContentValues();
            contentValues.put("pieceFileMIMEType", str2);
            int update = aNW.gUz.update("PieceMusicInfo", contentValues, "musicId=?", new String[]{By});
            w.i("MicroMsg.PieceMusicInfoStorage", "updatePieceFileMIMEType raw=%d musicId=%s", new Object[]{Integer.valueOf(update), By});
            b bVar = (b) aNW.nUv.get(By);
            if (bVar != null) {
                bVar.field_pieceFileMIMEType = str2;
            }
        } else {
            w.i("MicroMsg.PieceCacheHelper", "don't need update the piece fle mime type");
        }
    }

    public static String Bz(String str) {
        Object By = By(str);
        if (TextUtils.isEmpty(By)) {
            w.e("MicroMsg.PieceCacheHelper", "getMusicMIMEType musicId is empty!");
            return null;
        }
        b BF = i.aNW().BF(By);
        if (BF == null) {
            w.e("MicroMsg.PieceCacheHelper", "getMusicMIMEType pMusic is null!'");
            return null;
        }
        w.i("MicroMsg.PieceCacheHelper", "music field_pieceFileMIMEType:%s", new Object[]{BF.field_pieceFileMIMEType});
        if (!TextUtils.isEmpty(BF.field_pieceFileMIMEType)) {
            return BF.field_pieceFileMIMEType;
        }
        w.e("MicroMsg.PieceCacheHelper", "field_pieceFileMIMEType is null!'");
        return null;
    }

    public static long BA(String str) {
        File file = new File(h.Bq(str));
        return file.exists() ? file.length() : -1;
    }

    public static void tv(String str) {
        Logger.i("MicroMsg.PieceFileCache", "deleteFileByUrl");
        e.tv(h.Bq(str));
    }
}
