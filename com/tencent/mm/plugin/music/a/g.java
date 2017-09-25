package com.tencent.mm.plugin.music.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.am.a;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;

public final class g {
    public static boolean nTd;
    public static boolean nTe;
    public static int nTf;
    public static int nTg;
    public static long nTh;
    public static a nTi;
    public static int scene;

    public static final void J(int i, int i2, int i3) {
        if (i.aNS().aNI() != null) {
            w.v("MicroMsg.Music.MusicReportUtil", "kvReportShakeReport: %d, %d, %d, %s, %s, %s, %s, %d %s, %s", new Object[]{Integer.valueOf(13042), Integer.valueOf(i), Integer.valueOf(i2), i.aNS().aNI().field_musicId, i.aNS().aNI().field_songName, i.aNS().aNI().field_songAlbum, Integer.valueOf(i.aNS().aNI().field_songId), Integer.valueOf(i3), i.aNS().aNI().field_songSinger, i.aNS().aNI().field_appId});
            com.tencent.mm.plugin.report.service.g.oUh.i(13042, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), r0.field_musicId, r0.field_songName, r0.field_songAlbum, Integer.valueOf(r0.field_songId), Integer.valueOf(i3), r0.field_songSinger, r0.field_appId});
        }
    }

    public static final void cv(int i, int i2) {
        if (i.aNS().aNI() != null) {
            w.v("MicroMsg.Music.MusicReportUtil", "kvReportAction: %d, %s, %s, %s, %s, %d, %d, %s, %s", new Object[]{Integer.valueOf(13232), i.aNS().aNI().field_musicId, i.aNS().aNI().field_songName, i.aNS().aNI().field_songAlbum, Integer.valueOf(i.aNS().aNI().field_songId), Integer.valueOf(i2), Integer.valueOf(i), i.aNS().aNI().field_songSinger, i.aNS().aNI().field_appId});
            com.tencent.mm.plugin.report.service.g.oUh.i(13232, new Object[]{r0.field_musicId, r0.field_songName, r0.field_songAlbum, Integer.valueOf(r0.field_songId), Integer.valueOf(i2), Integer.valueOf(i), r0.field_songSinger, r0.field_appId});
        }
    }

    public static final void aNP() {
        int i = 1;
        if (nTi != null) {
            int i2;
            qP();
            String str = "MicroMsg.Music.MusicReportUtil";
            String str2 = "kvReportMusicPlayInfo: %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s";
            Object[] objArr = new Object[12];
            objArr[0] = Integer.valueOf(13044);
            objArr[1] = nTi.field_musicId;
            objArr[2] = nTi.field_songName;
            objArr[3] = nTi.field_songAlbum;
            objArr[4] = Integer.valueOf(nTi.field_songId);
            objArr[5] = Integer.valueOf(nTf);
            objArr[6] = Integer.valueOf(nTg);
            objArr[7] = Integer.valueOf(nTd ? 1 : 2);
            objArr[8] = Integer.valueOf(nTe ? 1 : 2);
            objArr[9] = Integer.valueOf(scene);
            objArr[10] = nTi.field_songSinger;
            objArr[11] = nTi.field_appId;
            w.v(str, str2, objArr);
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
            objArr = new Object[11];
            objArr[0] = nTi.field_musicId;
            objArr[1] = nTi.field_songName;
            objArr[2] = nTi.field_songAlbum;
            objArr[3] = Integer.valueOf(nTi.field_songId);
            objArr[4] = Integer.valueOf(nTf);
            objArr[5] = Integer.valueOf(nTg);
            if (nTd) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            objArr[6] = Integer.valueOf(i2);
            if (!nTe) {
                i = 2;
            }
            objArr[7] = Integer.valueOf(i);
            objArr[8] = Integer.valueOf(scene);
            objArr[9] = nTi.field_songSinger;
            objArr[10] = nTi.field_appId;
            gVar.i(13044, objArr);
        }
        nTi = null;
        nTd = false;
        nTe = false;
        nTf = 0;
        nTg = 0;
        nTh = 0;
        scene = 0;
    }

    public static final void qP() {
        if (nTh > 0) {
            nTg = (int) (((long) nTg) + ((System.currentTimeMillis() - nTh) / 1000));
            nTh = 0;
        }
    }

    public static final void aNQ() {
        com.tencent.mm.plugin.report.service.g.oUh.a(285, 4, 1, false);
    }

    public static final void qa(int i) {
        if (i == 2) {
            com.tencent.mm.plugin.report.service.g.oUh.i(10651, new Object[]{Integer.valueOf(7), Integer.valueOf(1), Integer.valueOf(0)});
        }
    }

    public static final void qb(int i) {
        if (i == 2) {
            com.tencent.mm.plugin.report.service.g.oUh.i(10651, new Object[]{Integer.valueOf(7), Integer.valueOf(0), Integer.valueOf(0)});
        }
    }

    public static final void d(a aVar, boolean z) {
        if (aVar == null) {
            w.e("MicroMsg.Music.MusicReportUtil", "idKeyReportMusicPlayerSum music is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(558);
        iDKey.SetKey(0);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(558);
        iDKey2.SetValue(1);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(558);
        iDKey3.SetValue(1);
        if (z) {
            iDKey3.SetKey(10);
        } else if (h.qd(aVar.field_musicType)) {
            iDKey3.SetKey(2);
            r0 = aVar.field_musicType;
            w.i("MicroMsg.PlayerErrorHandler", "getQQMusicPlayerSumidKeyByMusicType, musicType:" + r0);
            switch (r0) {
                case 0:
                    r0 = 117;
                    break;
                case 1:
                    r0 = 118;
                    break;
                case 4:
                    r0 = 119;
                    break;
                case 5:
                    r0 = 120;
                    break;
                case 6:
                    r0 = 121;
                    break;
                case 7:
                    r0 = 122;
                    break;
                case 8:
                    r0 = 123;
                    break;
                case 9:
                    r0 = 124;
                    break;
                case 10:
                    r0 = 125;
                    break;
                case 11:
                    r0 = 126;
                    break;
                default:
                    r0 = 127;
                    break;
            }
            iDKey2.SetKey(r0);
            arrayList.add(iDKey2);
        } else {
            iDKey3.SetKey(1);
            r0 = aVar.field_musicType;
            w.i("MicroMsg.PlayerErrorHandler", "getMusicPlayerSumidKeyByMusicType, musicType:" + r0);
            switch (r0) {
                case 0:
                    r0 = MMGIFException.D_GIF_ERR_NO_IMAG_DSCR;
                    break;
                case 1:
                    r0 = MMGIFException.D_GIF_ERR_NO_COLOR_MAP;
                    break;
                case 4:
                    r0 = MMGIFException.D_GIF_ERR_WRONG_RECORD;
                    break;
                case 5:
                    r0 = 108;
                    break;
                case 6:
                    r0 = MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM;
                    break;
                case 7:
                    r0 = MMGIFException.D_GIF_ERR_CLOSE_FAILED;
                    break;
                case 8:
                    r0 = 111;
                    break;
                case 9:
                    r0 = MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
                    break;
                default:
                    r0 = 113;
                    break;
            }
            iDKey2.SetKey(r0);
            arrayList.add(iDKey2);
        }
        arrayList.add(iDKey);
        arrayList.add(iDKey3);
        com.tencent.mm.plugin.report.service.g.oUh.b(arrayList, true);
    }

    public static final void qc(int i) {
        if (i.aNS().aNI() != null) {
            w.i("MicroMsg.Music.MusicReportUtil", "ReportMusicPlayerShareStat ShareType:%d, MusicId:%s, MusicTitle:%s, Singer:%s, AppId:%s", new Object[]{Integer.valueOf(i), i.aNS().aNI().field_musicId, i.aNS().aNI().field_songName, i.aNS().aNI().field_songSinger, i.aNS().aNI().field_appId});
            com.tencent.mm.plugin.report.service.g.oUh.i(12836, new Object[]{Integer.valueOf(i), r0.field_musicId, r0.field_songName, r0.field_songSinger, r0.field_appId});
        }
    }
}
