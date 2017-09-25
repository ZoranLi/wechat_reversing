package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.qq.taf.jce.JceStruct;
import com.tencent.mm.a.e;
import com.tencent.mm.bj.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import junit.framework.Assert;

public final class s {
    public static final String[] gUx = new String[]{"CREATE TABLE IF NOT EXISTS videoinfo2 ( filename text  PRIMARY KEY , clientid text  , msgsvrid int  , netoffset int  , filenowsize int  , totallen int  , thumbnetoffset int  , thumblen int  , status int  , createtime long  , lastmodifytime long  , downloadtime long  , videolength int  , msglocalid int  , nettimes int  , cameratype int  , user text  , human text  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  , videofuncflag int ,masssendid long ,masssendlist text,videomd5 text, streamvideo byte[], statextstr text, downloadscene int, mmsightextinfo byte[], preloadsize int, videoformat int )", "CREATE INDEX IF NOT EXISTS  video_status_index ON videoinfo2 ( status,downloadtime )", "CREATE TABLE IF NOT EXISTS videoinfo ( filename text  PRIMARY KEY , clientid text  , msgsvrid int  , netoffset int  , filenowsize int  , totallen int  , thumbnetoffset int  , thumblen int  , status int  , createtime long  , lastmodifytime long  , downloadtime long  , videolength int  , msglocalid int  , nettimes int  , cameratype int  , user text  , human text  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  , videofuncflag int ,masssendid long ,masssendlist text,videomd5 text, streamvideo byte[], statextstr text, downloadscene int, mmsightextinfo byte[], preloadsize int, videoformat int )", "alter table videoinfo2 add videofuncflag int ;", "alter table videoinfo2 add masssendid long default 0;", "alter table videoinfo2 add masssendlist text ;", "alter table videoinfo2 add videomd5 text ;", "alter table videoinfo2 add streamvideo byte[] ;", "alter table videoinfo2 add statextstr text ;", "alter table videoinfo2 add downloadscene int ;", "alter table videoinfo2 add mmsightextinfo byte[] ;", "alter table videoinfo2 add preloadsize int ;", "alter table videoinfo2 add videoformat int ;", "alter table videoinfo add videofuncflag int ;", "alter table videoinfo add masssendid long default 0;", "alter table videoinfo add masssendlist text ;", "alter table videoinfo add videomd5 text ;", "alter table videoinfo add streamvideo byte[] ;", "alter table videoinfo add statextstr text ;", "alter table videoinfo add downloadscene int ;", "alter table videoinfo add mmsightextinfo byte[] ;", "alter table videoinfo add preloadsize int ;", "alter table videoinfo add videoformat int ;", "insert into videoinfo2 select * from videoinfo ;", "delete from videoinfo ;", "CREATE INDEX IF NOT EXISTS  massSendIdIndex ON videoinfo2 ( masssendid )", "CREATE INDEX IF NOT EXISTS  LastModifyTimeIndex ON videoinfo2 ( lastmodifytime )", "CREATE TABLE IF NOT EXISTS  VideoHash  (size int , CreateTime long, hash text ,  cdnxml text, orgpath text);", "CREATE INDEX IF NOT EXISTS  VideoHashSizeIndex ON VideoHash ( size  )", "CREATE INDEX IF NOT EXISTS  VideoHashTimeIndex ON VideoHash ( CreateTime  )"};
    private static long iaA = 0;
    public g hnH;
    k<a, a> hrc = new k<a, a>(this) {
        final /* synthetic */ s iaB;

        {
            this.iaB = r1;
        }

        protected final /* synthetic */ void o(Object obj, Object obj2) {
            ((a) obj).a((a) obj2);
        }
    };

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ s iaB;
        final /* synthetic */ String iaC;
        final /* synthetic */ String iaD;
        final /* synthetic */ String iaE;

        AnonymousClass2(s sVar, String str, String str2, String str3) {
            this.iaB = sVar;
            this.iaC = str;
            this.iaD = str2;
            this.iaE = str3;
        }

        public final void run() {
            FileInputStream fileInputStream;
            int i;
            int i2;
            Throwable th;
            FileInputStream fileInputStream2;
            Object obj;
            long aA;
            long Nz = bg.Nz();
            int aN = e.aN(this.iaC);
            int aN2 = e.aN(this.iaD);
            w.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff now:%s size:%s,%s path:%s,%s", Long.valueOf(Nz), Integer.valueOf(aN), Integer.valueOf(aN2), this.iaC, this.iaD);
            if (aN2 != aN) {
                int i3 = (aN <= 0 ? 20 : 0) + ((aN2 <= 0 ? 10 : 0) + MMGIFException.D_GIF_ERR_NO_COLOR_MAP);
                com.tencent.mm.plugin.report.service.g.oUh.i(12696, Integer.valueOf(i3), this.iaE, "", "", Integer.valueOf(aN2));
                w.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Err File Size diff %d,%d path:%s org:%s", Integer.valueOf(aN), Integer.valueOf(aN2), this.iaC, this.iaD);
                return;
            }
            FileInputStream fileInputStream3 = null;
            FileInputStream fileInputStream4 = null;
            try {
                fileInputStream = new FileInputStream(this.iaC);
                try {
                    fileInputStream3 = new FileInputStream(this.iaD);
                    try {
                        byte[] bArr = new byte[Downloads.RECV_BUFFER_SIZE];
                        byte[] bArr2 = new byte[Downloads.RECV_BUFFER_SIZE];
                        i = 0;
                        Object obj2 = null;
                        while (true) {
                            try {
                                int read = fileInputStream.read(bArr);
                                if (read != fileInputStream3.read(bArr2)) {
                                    obj2 = 1;
                                }
                                if (read == -1) {
                                    break;
                                }
                                i3 = i;
                                i = 0;
                                while (i < read) {
                                    try {
                                        if (bArr[i] != bArr2[i]) {
                                            i3++;
                                        }
                                        i++;
                                    } catch (Throwable e) {
                                        Throwable th2 = e;
                                        fileInputStream4 = fileInputStream3;
                                        fileInputStream3 = fileInputStream;
                                        i2 = i3;
                                        th = th2;
                                    }
                                }
                                i = i3;
                            } catch (Exception e2) {
                                th = e2;
                                fileInputStream2 = fileInputStream3;
                                fileInputStream3 = fileInputStream;
                                i2 = i;
                                fileInputStream4 = fileInputStream2;
                            }
                        }
                        obj = obj2;
                    } catch (Exception e3) {
                        th = e3;
                        fileInputStream4 = fileInputStream3;
                        fileInputStream3 = fileInputStream;
                        i2 = 0;
                        w.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Err e:%s", bg.g(th));
                        obj = 1;
                        fileInputStream2 = fileInputStream4;
                        i = i2;
                        fileInputStream = fileInputStream3;
                        fileInputStream3 = fileInputStream2;
                        fileInputStream3.close();
                        fileInputStream.close();
                        if (obj == null) {
                            aA = bg.aA(Nz);
                            com.tencent.mm.plugin.report.service.g.oUh.i(12696, Integer.valueOf(400), this.iaE, String.valueOf(i), Long.valueOf(aA));
                            w.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff time:%s diff:%s check:%s org:%s", Long.valueOf(aA), Integer.valueOf(i), this.iaC, this.iaD);
                        }
                        w.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Read Failed! size:%s,%s path:%s,%s", Integer.valueOf(aN), Integer.valueOf(aN2), this.iaC, this.iaD);
                        com.tencent.mm.plugin.report.service.g.oUh.i(12696, Integer.valueOf(MMGIFException.D_GIF_ERR_WRONG_RECORD), this.iaE);
                        return;
                    }
                } catch (Exception e4) {
                    th = e4;
                    fileInputStream3 = fileInputStream;
                    i2 = 0;
                    w.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Err e:%s", bg.g(th));
                    obj = 1;
                    fileInputStream2 = fileInputStream4;
                    i = i2;
                    fileInputStream = fileInputStream3;
                    fileInputStream3 = fileInputStream2;
                    fileInputStream3.close();
                    fileInputStream.close();
                    if (obj == null) {
                        w.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Read Failed! size:%s,%s path:%s,%s", Integer.valueOf(aN), Integer.valueOf(aN2), this.iaC, this.iaD);
                        com.tencent.mm.plugin.report.service.g.oUh.i(12696, Integer.valueOf(MMGIFException.D_GIF_ERR_WRONG_RECORD), this.iaE);
                        return;
                    }
                    aA = bg.aA(Nz);
                    com.tencent.mm.plugin.report.service.g.oUh.i(12696, Integer.valueOf(400), this.iaE, String.valueOf(i), Long.valueOf(aA));
                    w.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff time:%s diff:%s check:%s org:%s", Long.valueOf(aA), Integer.valueOf(i), this.iaC, this.iaD);
                }
            } catch (Exception e5) {
                th = e5;
                i2 = 0;
                w.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Err e:%s", bg.g(th));
                obj = 1;
                fileInputStream2 = fileInputStream4;
                i = i2;
                fileInputStream = fileInputStream3;
                fileInputStream3 = fileInputStream2;
                fileInputStream3.close();
                fileInputStream.close();
                if (obj == null) {
                    aA = bg.aA(Nz);
                    com.tencent.mm.plugin.report.service.g.oUh.i(12696, Integer.valueOf(400), this.iaE, String.valueOf(i), Long.valueOf(aA));
                    w.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff time:%s diff:%s check:%s org:%s", Long.valueOf(aA), Integer.valueOf(i), this.iaC, this.iaD);
                }
                w.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Read Failed! size:%s,%s path:%s,%s", Integer.valueOf(aN), Integer.valueOf(aN2), this.iaC, this.iaD);
                com.tencent.mm.plugin.report.service.g.oUh.i(12696, Integer.valueOf(MMGIFException.D_GIF_ERR_WRONG_RECORD), this.iaE);
                return;
            }
            try {
                fileInputStream3.close();
            } catch (Exception e6) {
            }
            try {
                fileInputStream.close();
            } catch (Exception e7) {
            }
            if (obj == null) {
                w.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Read Failed! size:%s,%s path:%s,%s", Integer.valueOf(aN), Integer.valueOf(aN2), this.iaC, this.iaD);
                com.tencent.mm.plugin.report.service.g.oUh.i(12696, Integer.valueOf(MMGIFException.D_GIF_ERR_WRONG_RECORD), this.iaE);
                return;
            }
            aA = bg.aA(Nz);
            com.tencent.mm.plugin.report.service.g.oUh.i(12696, Integer.valueOf(400), this.iaE, String.valueOf(i), Long.valueOf(aA));
            w.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff time:%s diff:%s check:%s org:%s", Long.valueOf(aA), Integer.valueOf(i), this.iaC, this.iaD);
        }
    }

    public interface a {

        public static final class a {
            public final String fyF;
            public final long hYG;
            public final int iaF;
            public final c iaG;
            public final int iaw;

            public a(String str, int i, c cVar, int i2, long j) {
                this.fyF = str;
                this.iaF = i;
                this.iaG = cVar;
                this.iaw = i2;
                this.hYG = j;
            }
        }

        public enum b {
            ;

            static {
                iaH = 1;
                iaI = 2;
                iaJ = 3;
                iaK = new int[]{iaH, iaI, iaJ};
            }
        }

        public enum c {
            NORMAL,
            UPLOAD,
            DOWNLOAD
        }

        void a(a aVar);
    }

    public static class b {
        public byte[] buf = null;
        public int fAK = 0;
        public int iaP = 0;
        public int ret = 0;
    }

    public final void a(a aVar, Looper looper) {
        this.hrc.a(aVar, looper);
    }

    public final void a(a aVar) {
        this.hrc.remove(aVar);
    }

    public s(g gVar) {
        this.hnH = gVar;
    }

    public final boolean a(r rVar) {
        rVar.fRW = -1;
        if (((int) this.hnH.insert("videoinfo2", FFmpegMetadataRetriever.METADATA_KEY_FILENAME, rVar.pv())) == -1) {
            return false;
        }
        this.hrc.by(new a(rVar.getFileName(), b.iaH, c.NORMAL, rVar.iaw, rVar.hYG));
        this.hrc.doNotify();
        return true;
    }

    public final r ls(String str) {
        r rVar = null;
        Cursor a = this.hnH.a("select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2   where videoinfo2.filename = \"" + bg.my(str) + "\"", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                rVar = new r();
                rVar.b(a);
            }
            a.close();
        }
        return rVar;
    }

    public final List<r> au(long j) {
        List<r> list = null;
        Cursor a = this.hnH.a("select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2   where videoinfo2.masssendid = " + j, null, 2);
        if (a != null) {
            list = new ArrayList();
            while (a.moveToNext()) {
                r rVar = new r();
                rVar.b(a);
                list.add(rVar);
            }
            a.close();
        }
        return list;
    }

    public final List<r> Lm() {
        String str = "select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2  " + " WHERE status=200 order by masssendid desc";
        List<r> arrayList = new ArrayList();
        Cursor a = this.hnH.a(str, null, 2);
        int i = 0;
        while (a.moveToNext()) {
            r rVar = new r();
            rVar.b(a);
            arrayList.add(rVar);
            i++;
        }
        a.close();
        w.d("MicroMsg.VideoInfoStorage", "getUnfinishMassInfo resCount:" + i);
        return arrayList;
    }

    public final List<r> Ln() {
        String str = "select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2  " + " WHERE status=198 AND masssendid > 0 order by masssendid desc";
        List<r> arrayList = new ArrayList();
        Cursor a = this.hnH.a(str, null, 2);
        while (a.moveToNext()) {
            r rVar = new r();
            rVar.b(a);
            arrayList.add(rVar);
        }
        a.close();
        return arrayList;
    }

    public final boolean b(r rVar) {
        boolean z;
        Assert.assertTrue(rVar != null);
        if (rVar.getFileName().length() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        ContentValues pv = rVar.pv();
        if (pv.size() <= 0) {
            w.e("MicroMsg.VideoInfoStorage", "update failed, no values set");
        } else {
            if (this.hnH.update("videoinfo2", pv, "filename= ?", new String[]{rVar.getFileName()}) > 0) {
                c cVar = c.NORMAL;
                if (rVar.status == MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                    cVar = c.DOWNLOAD;
                } else if (rVar.status == 103 || rVar.status == 104) {
                    cVar = c.UPLOAD;
                }
                this.hrc.by(new a(rVar.getFileName(), b.iaJ, cVar, rVar.iaw, rVar.hYG));
                this.hrc.doNotify();
                return true;
            }
        }
        return false;
    }

    public final List<String> Lo() {
        Throwable th;
        List<String> list = null;
        Cursor a;
        try {
            a = this.hnH.a("select videoinfo2.filename,downloadtime from videoinfo2  " + " WHERE status=112 ORDER BY downloadtime DESC " + new StringBuilder(" LIMIT 10").toString(), null, 2);
            try {
                if (a.moveToFirst()) {
                    list = new ArrayList();
                    do {
                        list.add(a.getString(0));
                    } while (a.moveToNext());
                }
                if (a != null) {
                    a.close();
                }
                return list;
            } catch (Throwable th2) {
                th = th2;
                if (a != null) {
                    a.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }

    public final List<String> Lp() {
        Throwable th;
        List<String> list = null;
        String str = " LIMIT 10" + " )";
        Cursor a;
        try {
            a = this.hnH.a((((" SELECT * FROM ( " + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=122" + str) + " UNION SELECT * FROM ( ") + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=120" + str) + " ORDER BY downloadtime DESC", null, 2);
            try {
                if (a.moveToFirst()) {
                    list = new ArrayList();
                    do {
                        list.add(a.getString(0));
                    } while (a.moveToNext());
                }
                if (a != null) {
                    a.close();
                }
                return list;
            } catch (Throwable th2) {
                th = th2;
                if (a != null) {
                    a.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }

    public final List<String> Lq() {
        Throwable th;
        List<String> list = null;
        Cursor a;
        try {
            a = this.hnH.a("select videoinfo2.filename,downloadtime from videoinfo2  " + " WHERE status=199 AND videoformat=2 ORDER BY downloadtime DESC " + new StringBuilder(" LIMIT 10").toString(), null, 2);
            try {
                if (a.moveToFirst()) {
                    list = new ArrayList();
                    do {
                        list.add(a.getString(0));
                    } while (a.moveToNext());
                }
                if (a != null) {
                    a.close();
                }
                return list;
            } catch (Throwable th2) {
                th = th2;
                if (a != null) {
                    a.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }

    public final List<r> a(int i, int i2, long j) {
        Throwable th;
        List<r> list = null;
        Cursor a;
        try {
            a = this.hnH.a("select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2   where status=" + i + " AND preloadsize > 0 AND lastmodifytime" + " <= " + j + " ORDER BY createtime LIMIT " + 1, null, 2);
            try {
                if (a.moveToFirst()) {
                    list = new ArrayList();
                    do {
                        r rVar = new r();
                        rVar.b(a);
                        list.add(rVar);
                    } while (a.moveToNext());
                }
                if (a != null) {
                    a.close();
                }
                return list;
            } catch (Throwable th2) {
                th = th2;
                if (a != null) {
                    a.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }

    public final List<String> Lr() {
        Throwable th;
        List<String> list = null;
        String str = " LIMIT 10" + " )";
        Cursor a;
        try {
            a = this.hnH.a((((" SELECT * FROM ( " + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=103" + str) + " UNION SELECT * FROM ( ") + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=104" + str) + " ORDER BY downloadtime DESC", null, 2);
            try {
                if (a.moveToFirst()) {
                    list = new ArrayList();
                    do {
                        list.add(a.getString(0));
                    } while (a.moveToNext());
                }
                if (a != null) {
                    a.close();
                }
                return list;
            } catch (Throwable th2) {
                th = th2;
                if (a != null) {
                    a.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }

    public final boolean lt(String str) {
        if (this.hnH.delete("videoinfo2", "filename= ?", new String[]{str}) <= 0) {
            return false;
        }
        this.hrc.by(new a(str, b.iaI, c.NORMAL, 1, -1));
        this.hrc.doNotify();
        return true;
    }

    public static String lu(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        String format = new SimpleDateFormat("HHmmssddMMyy").format(new Date(currentTimeMillis));
        if (str != null && str.length() > 1) {
            format = format + com.tencent.mm.a.g.n(str.getBytes()).substring(0, 7);
        }
        StringBuilder append = new StringBuilder().append(format + (currentTimeMillis % 10000));
        currentTimeMillis = iaA;
        iaA = 1 + currentTimeMillis;
        return append.append(currentTimeMillis).toString();
    }

    private static String Ls() {
        return h.vI().gYf + "video/";
    }

    public static String lv(String str) {
        if (bg.mA(str)) {
            return null;
        }
        String str2 = Ls() + str;
        return !e.aO(str2) ? str2 + ".mp4" : str2;
    }

    public static String lw(String str) {
        if (bg.mA(str)) {
            return null;
        }
        return Ls() + str + ".jpg";
    }

    public static int a(String str, int i, byte[] bArr) {
        RandomAccessFile randomAccessFile;
        int filePointer;
        Exception e;
        Throwable th;
        if (bg.mA(str)) {
            w.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " invalid fileName");
            return 0 - com.tencent.mm.compatible.util.g.sb();
        } else if (i < 0) {
            w.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.sd() + "[" + str + "]  invalid startOffset:" + i);
            return 0 - com.tencent.mm.compatible.util.g.sb();
        } else if (bg.bm(bArr)) {
            w.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.sd() + "[" + str + "]  invalid writeBuf");
            return 0 - com.tencent.mm.compatible.util.g.sb();
        } else {
            com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
            try {
                randomAccessFile = new RandomAccessFile(str, "rw");
                try {
                    long se = aVar.se();
                    randomAccessFile.seek((long) i);
                    long se2 = aVar.se();
                    randomAccessFile.write(bArr, 0, bArr.length);
                    long se3 = aVar.se();
                    filePointer = (int) randomAccessFile.getFilePointer();
                    long se4 = aVar.se();
                    try {
                        randomAccessFile.close();
                    } catch (Exception e2) {
                    }
                    w.d("MicroMsg.VideoInfoStorage", "FIN:" + com.tencent.mm.compatible.util.g.sd() + "[" + str + "]  Offset:" + i + " buf:" + bArr.length);
                    w.d("MicroMsg.VideoInfoStorage", "FIN:" + com.tencent.mm.compatible.util.g.sd() + "[" + str + "] open:" + se + " seek:" + se2 + " write:" + se3 + " close:" + se4);
                    return filePointer;
                } catch (Exception e3) {
                    e = e3;
                    try {
                        w.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.sd() + "[" + str + "] \t\tOffset:" + i + " failed:[" + e.getMessage() + "]");
                        filePointer = 0 - com.tencent.mm.compatible.util.g.sb();
                        if (randomAccessFile != null) {
                            return filePointer;
                        }
                        try {
                            randomAccessFile.close();
                            return filePointer;
                        } catch (Exception e4) {
                            return filePointer;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e5) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                randomAccessFile = null;
                w.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.sd() + "[" + str + "] \t\tOffset:" + i + " failed:[" + e.getMessage() + "]");
                filePointer = 0 - com.tencent.mm.compatible.util.g.sb();
                if (randomAccessFile != null) {
                    return filePointer;
                }
                randomAccessFile.close();
                return filePointer;
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        }
    }

    public static b h(String str, int i, int i2) {
        Exception e;
        Throwable th;
        int i3 = 0;
        b bVar = new b();
        if (bg.mA(str)) {
            w.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " invalid fileName");
            bVar.ret = 0 - com.tencent.mm.compatible.util.g.sb();
        } else if (i < 0) {
            w.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.sd() + "[" + str + "]  invalid readOffset:" + i);
            bVar.ret = 0 - com.tencent.mm.compatible.util.g.sb();
        } else if (i2 <= 0) {
            w.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.sd() + "[" + str + "]  invalid readLen");
            bVar.ret = 0 - com.tencent.mm.compatible.util.g.sb();
        } else {
            com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
            bVar.buf = new byte[i2];
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile(str, "r");
                try {
                    long se = aVar.se();
                    randomAccessFile.seek((long) i);
                    long se2 = aVar.se();
                    int read = randomAccessFile.read(bVar.buf, 0, i2);
                    long se3 = aVar.se();
                    long se4 = aVar.se();
                    if (read >= 0) {
                        i3 = read;
                    }
                    bVar.fAK = i3;
                    bVar.iaP = i3 + i;
                    try {
                        randomAccessFile.close();
                    } catch (Exception e2) {
                    }
                    w.d("MicroMsg.VideoInfoStorage", "FIN:" + com.tencent.mm.compatible.util.g.sd() + "[" + str + "]  Offset:" + i + " readlen:" + i2);
                    w.d("MicroMsg.VideoInfoStorage", "FIN:" + com.tencent.mm.compatible.util.g.sd() + "[" + str + "] open:" + se + " seek:" + se2 + " write:" + se3 + " close:" + se4);
                } catch (Exception e3) {
                    e = e3;
                    try {
                        w.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.sd() + "[" + str + "] \t\tOffset:" + bVar.iaP + " failed:[" + e.getMessage() + "]");
                        bVar.ret = 0 - com.tencent.mm.compatible.util.g.sb();
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e4) {
                            }
                        }
                        return bVar;
                    } catch (Throwable th2) {
                        th = th2;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e5) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                randomAccessFile = null;
                w.e("MicroMsg.VideoInfoStorage", "ERR:" + com.tencent.mm.compatible.util.g.sd() + "[" + str + "] \t\tOffset:" + bVar.iaP + " failed:[" + e.getMessage() + "]");
                bVar.ret = 0 - com.tencent.mm.compatible.util.g.sb();
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                return bVar;
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        }
        return bVar;
    }

    public static int lx(String str) {
        if (bg.mA(str)) {
            return -1;
        }
        File file = new File(str);
        if (!file.exists()) {
            return 0;
        }
        int length = (int) file.length();
        if (length > 0) {
            return length;
        }
        return 0;
    }

    public final boolean o(String str, String str2, String str3) {
        return al(str, str2 + "##" + str3);
    }

    static int[] ly(String str) {
        RandomAccessFile randomAccessFile;
        Throwable e;
        int i = 0;
        int[] iArr = new int[33];
        long Nz = bg.Nz();
        int aN = e.aN(str);
        if (aN < 102400 || aN >= JceStruct.JCE_MAX_STRING_LENGTH) {
            int i2;
            w.e("MicroMsg.VideoInfoStorage", "genVideoHash file size :%d , give up. :%s ", Integer.valueOf(aN), str);
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
            Object[] objArr = new Object[2];
            if (aN < 102400) {
                i2 = 10;
            } else {
                i2 = 20;
            }
            objArr[0] = Integer.valueOf(i2 + 101);
            objArr[1] = Integer.valueOf(aN);
            gVar.i(12696, objArr);
            return null;
        }
        iArr[32] = aN;
        int i3 = (aN - 20480) / 32;
        byte[] bArr = new byte[512];
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
            while (i < 32) {
                try {
                    randomAccessFile.seek((long) ((i * i3) + 10240));
                    randomAccessFile.readFully(bArr);
                    iArr[i] = (com.tencent.mm.a.h.b(bArr, 512) % Integer.MIN_VALUE) | Integer.MIN_VALUE;
                    i++;
                } catch (Exception e2) {
                    e = e2;
                }
            }
            randomAccessFile.close();
            w.i("MicroMsg.VideoInfoStorage", "genVideoHash finish time:%d size:%d path:%s", Long.valueOf(bg.aA(Nz)), Integer.valueOf(aN), str);
            try {
                randomAccessFile.close();
                return iArr;
            } catch (Exception e3) {
                return iArr;
            }
        } catch (Exception e4) {
            e = e4;
            randomAccessFile = null;
            try {
                w.e("MicroMsg.VideoInfoStorage", "genVideoHash path:%s e:%s", str, bg.g(e));
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e5) {
                    }
                }
                return null;
            } catch (Throwable th) {
                e = th;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e6) {
                    }
                }
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw e;
        }
    }

    private boolean al(String str, String str2) {
        w.i("MicroMsg.VideoInfoStorage", "saveVideoHash path:%s xml:%s stack:%s", str, str2, bg.bJZ());
        long Nz = bg.Nz();
        if (bg.mA(str) || bg.mA(str2)) {
            w.e("MicroMsg.VideoInfoStorage", "saveVideoHash failed , path:%s xml:%s", str, str2);
            return false;
        }
        int[] ly = ly(str);
        if (ly == null || ly.length < 33) {
            w.e("MicroMsg.VideoInfoStorage", "saveVideoHash  readHash failed :%s", str);
            return false;
        }
        int i = ly[32];
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < 32; i2++) {
            stringBuffer.append(Integer.toHexString(ly[i2]));
        }
        Cursor a = this.hnH.a("select cdnxml from VideoHash where size = " + i + " and hash = \"" + stringBuffer.toString() + "\"", null, 2);
        Vector vector = new Vector();
        while (a.moveToNext()) {
            vector.add(a.getString(0));
            w.v("MicroMsg.VideoInfoStorage", "saveVideoHash index:%s get:%s", Integer.valueOf(vector.size()), vector.get(vector.size() - 1));
        }
        a.close();
        if (vector.size() == 1 && str2.equals(vector.get(0))) {
            w.w("MicroMsg.VideoInfoStorage", "saveVideoHash Check exist now return,time:%d,  path:%s xml:%s", Long.valueOf(bg.aA(Nz)), str, str2);
            return true;
        }
        if (vector.size() > 0) {
            com.tencent.mm.plugin.report.service.g.oUh.i(12696, Integer.valueOf(102), Integer.valueOf(i), "", "", Integer.valueOf(vector.size()));
            w.e("MicroMsg.VideoInfoStorage", "saveVideoHash Err Check  xml diff OR  select more than one row,  rowCount:%d size:%d ", Integer.valueOf(vector.size()), Integer.valueOf(i));
            this.hnH.eE("VideoHash", "delete from VideoHash where size = " + i + " and hash = \"" + stringBuffer.toString() + "\"");
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("size", Integer.valueOf(i));
        contentValues.put("CreateTime", Long.valueOf(bg.Ny()));
        contentValues.put("hash", stringBuffer.toString());
        contentValues.put("cdnxml", str2);
        contentValues.put("orgpath", str);
        w.i("MicroMsg.VideoInfoStorage", "summersafecdn saveVideoHash time:%d insert:%d path:%s hash:%s xml:%s", Long.valueOf(bg.aA(Nz)), Long.valueOf(this.hnH.insert("VideoHash", "", contentValues)), str, stringBuffer, str2);
        if (this.hnH.insert("VideoHash", "", contentValues) < 0) {
            com.tencent.mm.plugin.report.service.g.oUh.i(12696, Integer.valueOf(103), Integer.valueOf(i));
            w.e("MicroMsg.VideoInfoStorage", "saveVideoHash insert failed :%d  path:%s", Long.valueOf(r0), str);
        }
        return true;
    }
}
