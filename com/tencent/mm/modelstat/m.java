package com.tencent.mm.modelstat;

import com.tencent.mm.network.aa;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.plugin.appbrand.jsapi.g.c;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteGlobal;

public final class m {
    static {
        bf.reset();
    }

    public static void r(int i, int i2, int i3) {
        if (aa.bn(ab.getContext())) {
            w.i("MicroMsg.NetStatStorageLogic", "dknetflow wifi recv:%d send:%d type:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0));
            s(i, i2, 0);
            return;
        }
        w.i("MicroMsg.NetStatStorageLogic", "dknetflow mobile recv:%d send:%d type:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0));
        t(i, i2, 0);
    }

    public static void s(int i, int i2, int i3) {
        j jVar = new j();
        jVar.hWv = i;
        jVar.hWH = i2;
        jVar.fRW = 8390656;
        c(jVar);
        a(jVar, i3);
        p.Kh().a(jVar);
    }

    public static void t(int i, int i2, int i3) {
        j jVar = new j();
        jVar.hWu = i;
        jVar.hWG = i2;
        jVar.fRW = 4195328;
        c(jVar);
        a(jVar, i3);
        p.Kh().a(jVar);
    }

    private static void c(j jVar) {
        bf.update();
        jVar.hWw = (int) bf.bJL();
        jVar.hWI = (int) bf.bJK();
        jVar.hWx = (int) bf.bJJ();
        jVar.hWJ = (int) bf.bJI();
        jVar.hWK = (int) bf.bJP();
        jVar.hWM = (int) bf.bJO();
        jVar.hWL = (int) bf.bJN();
        jVar.hWN = (int) bf.bJM();
        jVar.fRW = (((((((jVar.fRW | 8192) | 33554432) | Downloads.RECV_BUFFER_SIZE) | 16777216) | 134217728) | SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING) | 67108864) | SQLiteDatabase.CREATE_IF_NECESSARY;
    }

    private static void a(j jVar, int i) {
        switch (i) {
            case MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM /*109*/:
            case 123:
                jVar.hWp = jVar.hWu + jVar.hWv;
                jVar.fRW |= 32;
                return;
            case MMGIFException.D_GIF_ERR_CLOSE_FAILED /*110*/:
                jVar.hWB = jVar.hWG + jVar.hWH;
                jVar.fRW |= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                return;
            case 127:
                jVar.hWD = jVar.hWG + jVar.hWH;
                jVar.fRW |= SQLiteGlobal.journalSizeLimit;
                return;
            case FileUtils.S_IWUSR /*128*/:
                jVar.hWr = jVar.hWu + jVar.hWv;
                jVar.fRW |= FileUtils.S_IWUSR;
                return;
            case 138:
            case com.tencent.mm.plugin.appbrand.jsapi.w.CTRL_INDEX /*139*/:
                jVar.hWn = jVar.hWu + jVar.hWv;
                jVar.fRW |= 8;
                return;
            case c.CTRL_INDEX /*149*/:
                jVar.hWF = jVar.hWG + jVar.hWH;
                jVar.fRW |= 2097152;
                return;
            case ck.CTRL_INDEX /*150*/:
                jVar.hWt = jVar.hWu + jVar.hWv;
                jVar.fRW |= 512;
                return;
            case 522:
                jVar.hWz = jVar.hWG + jVar.hWH;
                jVar.fRW |= WXMediaMessage.THUMB_LENGTH_LIMIT;
                return;
            default:
                return;
        }
    }
}
