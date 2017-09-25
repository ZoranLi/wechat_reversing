package com.tencent.mm.plugin.music.a.f;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.plugin.music.a.h;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.n;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a extends i<com.tencent.mm.am.a> {
    public e gUz;
    public f<String, com.tencent.mm.am.a> nUv = new f(20);
    public f<String, com.tencent.mm.plugin.music.a.a> nUw = new f(10);

    public a(e eVar) {
        super(eVar, com.tencent.mm.am.a.gTP, "Music", null);
        this.gUz = eVar;
    }

    public final com.tencent.mm.am.a BE(String str) {
        if (this.nUv.get(str) != null) {
            return (com.tencent.mm.am.a) this.nUv.get(str);
        }
        String format = String.format("Select * From Music Where musicId=?", new Object[0]);
        Cursor a = this.gUz.a(format, new String[]{str}, 2);
        if (a == null || !a.moveToFirst()) {
            if (a != null) {
                a.close();
            }
            return null;
        }
        com.tencent.mm.am.a aVar = new com.tencent.mm.am.a();
        aVar.b(a);
        a.close();
        this.nUv.put(str, aVar);
        return aVar;
    }

    public final com.tencent.mm.plugin.music.a.a g(com.tencent.mm.am.a aVar, boolean z) {
        com.tencent.mm.plugin.music.a.a.a aVar2;
        String str = aVar.field_songLyric;
        String string = ab.getContext().getString(R.l.eCC);
        String str2 = aVar.field_songSnsShareUser;
        boolean e = h.e(aVar);
        String str3 = aVar.field_songSinger;
        com.tencent.mm.plugin.music.a.a aVar3 = new com.tencent.mm.plugin.music.a.a();
        long NA = bg.NA();
        if (bg.mA(str)) {
            com.tencent.mm.plugin.music.a.a.a aVar4 = new com.tencent.mm.plugin.music.a.a.a();
            aVar4.timestamp = 0;
            if (z) {
                aVar4.content = str3;
            } else if (e) {
                aVar4.content = ab.getContext().getString(R.l.eDL);
            } else {
                aVar4.content = ab.getContext().getString(R.l.eDK);
            }
            if (aVar4.content != null) {
                aVar3.nSl.add(aVar4);
            }
        } else {
            if (str == null) {
                w.w("MicroMsg.Music.LyricObj", "parserLrc: but lrc or lrcMgr is null");
            } else {
                int i;
                Matcher matcher = Pattern.compile("(\\[((\\d{2}:\\d{2}(\\.\\d{2}){0,1}\\])|(al:|ar:|by:|offset:|re:|ti:|ve:))[^\\[]*)").matcher(str.replaceAll("\n", " ").replaceAll("\r", " "));
                while (matcher.find()) {
                    CharSequence group = matcher.group();
                    matcher.start();
                    matcher.end();
                    if (group == null) {
                        w.w("MicroMsg.Music.LyricObj", "parserLine fail: lrcMgr or str is null");
                    } else if (group.startsWith("[ti:")) {
                        aVar3.title = com.tencent.mm.plugin.music.a.a.cW(group, "[ti:");
                    } else if (group.startsWith("[ar:")) {
                        aVar3.iMN = com.tencent.mm.plugin.music.a.a.cW(group, "[ar:");
                    } else if (group.startsWith("[al:")) {
                        aVar3.album = com.tencent.mm.plugin.music.a.a.cW(group, "[al:");
                    } else if (group.startsWith("[by:")) {
                        aVar3.nSn = com.tencent.mm.plugin.music.a.a.cW(group, "[by:");
                    } else if (group.startsWith("[offset:")) {
                        aVar3.hHx = bg.getLong(com.tencent.mm.plugin.music.a.a.cW(group, "[offset:"), 0);
                    } else if (group.startsWith("[re:")) {
                        aVar3.nSo = com.tencent.mm.plugin.music.a.a.cW(group, "[re:");
                    } else if (group.startsWith("[ve:")) {
                        aVar3.nSp = com.tencent.mm.plugin.music.a.a.cW(group, "[ve:");
                    } else {
                        Pattern compile = Pattern.compile("\\[(\\d{2}:\\d{2}(\\.\\d{2}){0,1})\\]");
                        Matcher matcher2 = compile.matcher(group);
                        com.tencent.mm.plugin.music.a.a.a aVar5 = new com.tencent.mm.plugin.music.a.a.a();
                        while (matcher2.find()) {
                            if (matcher2.groupCount() > 0) {
                                aVar5.timestamp = com.tencent.mm.plugin.music.a.a.Bp(matcher2.group(1));
                            }
                            String[] split = compile.split(group);
                            if (split == null || split.length <= 0) {
                                aVar3.nSm.add(Long.valueOf(aVar5.timestamp));
                                break;
                            }
                            String str4 = split[split.length - 1];
                            if (str4 != null) {
                                str4 = str4.trim();
                            }
                            if (bg.mA(str4)) {
                                str4 = " ";
                            }
                            aVar5.content = str4;
                            for (i = 0; i < aVar3.nSm.size(); i++) {
                                com.tencent.mm.plugin.music.a.a.a aVar6 = new com.tencent.mm.plugin.music.a.a.a();
                                aVar6.timestamp = ((Long) aVar3.nSm.get(i)).longValue();
                                aVar6.content = aVar5.content;
                                aVar6.nSr = true;
                            }
                            aVar3.nSm.clear();
                            i = aVar3.nSl.size() - 1;
                            while (i >= 0 && ((com.tencent.mm.plugin.music.a.a.a) aVar3.nSl.get(i)).timestamp != aVar5.timestamp) {
                                if (((com.tencent.mm.plugin.music.a.a.a) aVar3.nSl.get(i)).timestamp < aVar5.timestamp) {
                                    aVar3.nSl.add(i + 1, aVar5);
                                    break;
                                }
                                i--;
                            }
                            if (i < 0) {
                                aVar3.nSl.add(0, aVar5);
                            }
                        }
                    }
                }
                w.d("MicroMsg.Music.LyricObj", "handle offset %d", new Object[]{Long.valueOf(aVar3.hHx)});
                if (aVar3.hHx != 0) {
                    for (i = 0; i < aVar3.nSl.size(); i++) {
                        aVar2 = (com.tencent.mm.plugin.music.a.a.a) aVar3.nSl.get(i);
                        aVar2.timestamp += aVar3.hHx;
                    }
                    aVar3.hHx = 0;
                }
                int i2 = 0;
                while (i2 < aVar3.nSl.size() - 1) {
                    aVar2 = (com.tencent.mm.plugin.music.a.a.a) aVar3.nSl.get(i2);
                    if (aVar2.nSr && aVar2.content.equals(((com.tencent.mm.plugin.music.a.a.a) aVar3.nSl.get(i2 + 1)).content)) {
                        aVar2.content = " ";
                    }
                    i2++;
                }
            }
            w.d("MicroMsg.Music.LyricObj", "getLrcMgr beg: src lrc = %s", new Object[]{str});
            w.d("MicroMsg.Music.LyricObj", "parse finish: sentence size [%d], result:", new Object[]{Integer.valueOf(aVar3.nSl.size())});
        }
        if (bg.mA(str2)) {
            w.w("MicroMsg.Music.LyricObj", "add lyric prefix: but prefix is empty, return");
        } else {
            aVar2 = new com.tencent.mm.plugin.music.a.a.a();
            aVar2.timestamp = 0;
            aVar2.content = ab.getContext().getString(R.l.eZz, new Object[]{n.eK(str2)});
            if (aVar3.nSl.isEmpty()) {
                aVar3.nSl.add(aVar2);
            } else if (aVar3.nSl.size() == 1) {
                aVar3.nSl.add(0, aVar2);
                ((com.tencent.mm.plugin.music.a.a.a) aVar3.nSl.get(1)).timestamp = 5000;
            } else {
                aVar3.nSl.add(0, aVar2);
                ((com.tencent.mm.plugin.music.a.a.a) aVar3.nSl.get(1)).timestamp = 3 * (((com.tencent.mm.plugin.music.a.a.a) aVar3.nSl.get(2)).timestamp >> 2);
            }
        }
        if (!bg.mA(str)) {
            if (bg.mA(string)) {
                w.w("MicroMsg.Music.LyricObj", "add lyric prefix: but prefix is empty, return");
            } else {
                aVar2 = new com.tencent.mm.plugin.music.a.a.a();
                aVar2.timestamp = 0;
                aVar2.content = string;
                if (aVar3.nSl.isEmpty()) {
                    aVar3.nSl.add(aVar2);
                } else if (aVar3.nSl.size() == 1) {
                    aVar3.nSl.add(0, aVar2);
                    ((com.tencent.mm.plugin.music.a.a.a) aVar3.nSl.get(1)).timestamp = 5000;
                } else {
                    aVar3.nSl.add(0, aVar2);
                    ((com.tencent.mm.plugin.music.a.a.a) aVar3.nSl.get(1)).timestamp = 3 * (((com.tencent.mm.plugin.music.a.a.a) aVar3.nSl.get(2)).timestamp >> 2);
                }
            }
        }
        w.d("MicroMsg.Music.LyricObj", "getLrcMgr finish: use %d ms", new Object[]{Long.valueOf(bg.aB(NA))});
        this.nUw.put(aVar.field_musicId, aVar3);
        return aVar3;
    }

    public final com.tencent.mm.am.a F(String str, int i, int i2) {
        w.i("MicroMsg.Music.MusicStorage", "updateMusicWithColor %s %d %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        com.tencent.mm.am.a BE = BE(str);
        if (BE == null) {
            w.e("MicroMsg.Music.MusicStorage", "updateMusicWithColor can not find music %s", new Object[]{str});
            return null;
        }
        BE.field_songBgColor = i;
        BE.field_songLyricColor = i2;
        c(BE, new String[]{"songBgColor", "songLyricColor"});
        this.nUv.put(str, BE);
        return BE;
    }

    public final com.tencent.mm.am.a s(anf com_tencent_mm_protocal_c_anf) {
        c aVar;
        int i;
        String h = h.h(com_tencent_mm_protocal_c_anf);
        c BE = BE(h);
        if (BE == null) {
            aVar = new com.tencent.mm.am.a();
            i = 0;
        } else {
            aVar = BE;
            i = 1;
        }
        aVar.field_musicId = h;
        aVar.field_originMusicId = com_tencent_mm_protocal_c_anf.tqY;
        aVar.field_musicType = com_tencent_mm_protocal_c_anf.tRH;
        aVar.field_appId = com_tencent_mm_protocal_c_anf.mtb;
        if (bg.mA(aVar.field_appId)) {
            aVar.field_appId = h.j(com_tencent_mm_protocal_c_anf);
        }
        aVar.field_songAlbum = com_tencent_mm_protocal_c_anf.tRL;
        aVar.field_songAlbumType = com_tencent_mm_protocal_c_anf.tRT;
        aVar.field_songWifiUrl = com_tencent_mm_protocal_c_anf.tRN;
        aVar.field_songName = com_tencent_mm_protocal_c_anf.tRJ;
        aVar.field_songSinger = com_tencent_mm_protocal_c_anf.tRK;
        aVar.field_songWapLinkUrl = com_tencent_mm_protocal_c_anf.tRO;
        aVar.field_songWebUrl = com_tencent_mm_protocal_c_anf.tRP;
        aVar.field_songAlbumLocalPath = com_tencent_mm_protocal_c_anf.tRR;
        aVar.field_songMediaId = com_tencent_mm_protocal_c_anf.ttW;
        aVar.field_songSnsAlbumUser = com_tencent_mm_protocal_c_anf.tRX;
        aVar.field_songAlbumUrl = com_tencent_mm_protocal_c_anf.tRM;
        aVar.field_songSnsShareUser = com_tencent_mm_protocal_c_anf.tRY;
        if (!bg.mA(com_tencent_mm_protocal_c_anf.tRU)) {
            aVar.field_songHAlbumUrl = com_tencent_mm_protocal_c_anf.tRU;
        }
        aVar.field_updateTime = System.currentTimeMillis();
        if (aVar.field_songId == 0) {
            h.g(com_tencent_mm_protocal_c_anf);
            aVar.field_songId = com_tencent_mm_protocal_c_anf.tGt;
        }
        if (bg.mA(aVar.field_songWapLinkUrl) || aVar.field_songWapLinkUrl.equals(aVar.field_songWebUrl)) {
            aVar.field_songWapLinkUrl = aVar.field_songWifiUrl;
        }
        if (aVar.field_songId == 0 && com_tencent_mm_protocal_c_anf.tRH == 4) {
            try {
                aVar.field_songId = Integer.valueOf(com_tencent_mm_protocal_c_anf.tqY).intValue();
            } catch (Exception e) {
            }
        }
        aVar.field_hideBanner = com_tencent_mm_protocal_c_anf.tSa;
        aVar.field_jsWebUrlDomain = com_tencent_mm_protocal_c_anf.tSb;
        aVar.field_startTime = com_tencent_mm_protocal_c_anf.iMR;
        aVar.hMU = com_tencent_mm_protocal_c_anf.hMU;
        if (i != 0) {
            w.i("MicroMsg.Music.MusicStorage", "update music %s", new Object[]{h});
            c(aVar, new String[0]);
        } else {
            w.i("MicroMsg.Music.MusicStorage", "insert music %s", new Object[]{h});
            b(aVar);
        }
        this.nUv.put(h, aVar);
        return aVar;
    }

    public final void L(String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("wifiDownloadedLength", Long.valueOf(j));
        int update = this.gUz.update("Music", contentValues, "musicId=?", new String[]{str});
        w.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s wifiDownloadedLength=%d", new Object[]{Integer.valueOf(update), str, Long.valueOf(j)});
        com.tencent.mm.am.a aVar = (com.tencent.mm.am.a) this.nUv.get(str);
        if (aVar != null) {
            aVar.field_wifiDownloadedLength = j;
        }
    }

    public final void M(String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("songWifiFileLength", Long.valueOf(j));
        int update = this.gUz.update("Music", contentValues, "musicId=?", new String[]{str});
        w.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s songWifiFileLength=%d", new Object[]{Integer.valueOf(update), str, Long.valueOf(j)});
        com.tencent.mm.am.a aVar = (com.tencent.mm.am.a) this.nUv.get(str);
        if (aVar != null) {
            aVar.field_songWifiFileLength = j;
        }
    }

    public final void bq(String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("wifiEndFlag", Integer.valueOf(i));
        int update = this.gUz.update("Music", contentValues, "musicId=?", new String[]{str});
        w.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s wifiEndFlag=%d", new Object[]{Integer.valueOf(update), str, Integer.valueOf(i)});
        com.tencent.mm.am.a aVar = (com.tencent.mm.am.a) this.nUv.get(str);
        if (aVar != null) {
            aVar.field_wifiEndFlag = i;
        }
    }

    public final void N(String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("downloadedLength", Long.valueOf(j));
        int update = this.gUz.update("Music", contentValues, "musicId=?", new String[]{str});
        w.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s downloadedLength=%d", new Object[]{Integer.valueOf(update), str, Long.valueOf(j)});
        com.tencent.mm.am.a aVar = (com.tencent.mm.am.a) this.nUv.get(str);
        if (aVar != null) {
            aVar.field_downloadedLength = j;
        }
    }

    public final void br(String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("endFlag", Integer.valueOf(i));
        int update = this.gUz.update("Music", contentValues, "musicId=?", new String[]{str});
        w.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s endFlag=%d", new Object[]{Integer.valueOf(update), str, Integer.valueOf(i)});
        com.tencent.mm.am.a aVar = (com.tencent.mm.am.a) this.nUv.get(str);
        if (aVar != null) {
            aVar.field_endFlag = i;
        }
    }

    public final void O(String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("songFileLength", Long.valueOf(j));
        int update = this.gUz.update("Music", contentValues, "musicId=?", new String[]{str});
        w.i("MicroMsg.Music.MusicStorage", "update raw=%d musicId=%s songFileLength=%d", new Object[]{Integer.valueOf(update), str, Long.valueOf(j)});
        com.tencent.mm.am.a aVar = (com.tencent.mm.am.a) this.nUv.get(str);
        if (aVar != null) {
            aVar.field_songFileLength = j;
        }
    }
}
