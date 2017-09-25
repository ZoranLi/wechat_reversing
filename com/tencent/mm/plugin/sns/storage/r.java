package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.mm.bj.g;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.memory.l;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.protocal.c.ale;
import com.tencent.mm.protocal.c.alk;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.w;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

public final class r extends j {
    public static final String[] gUx = new String[]{"CREATE TABLE IF NOT EXISTS SnsMedia ( local_id INTEGER PRIMARY KEY, seqId LONG, type INT, createTime LONG, userName VARCHAR(40), totallen INT, offset INT, local_flag INT, tmp_path TEXT, nums INT, try_times INT, StrId VARCHAR(40), upload_buf TEXT, reserved1 INT, reserved2 TEXT, reserved3 TEXT, reserved4 TEXT, reserved5 TEXT )", "CREATE INDEX IF NOT EXISTS serverSnsMediaTimeIndex ON SnsMedia ( createTime )"};
    private static int pOu = 0;
    private static int pPh = 0;
    private static Point pWg = new Point();
    public g hnH;

    class a {
        String qnU;
        String qnV;
        int qnW;
        int qnX;
        int qnY;
        int qnZ;
        int qoa;
        int qob;
        final /* synthetic */ r qoc;

        a(r rVar) {
            this.qoc = rVar;
        }

        static String Gy(String str) {
            if (bg.mA(str)) {
                return "";
            }
            return str.replace(",", ";");
        }
    }

    public r(g gVar) {
        this.hnH = gVar;
    }

    public static void cY(int i, int i2) {
        pPh = i;
        pOu = i2;
        w.i("MicroMsg.snsMediaStorage", "SCREEN %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    private static String Gu(String str) {
        if (str == null) {
            return "";
        }
        String n = com.tencent.mm.a.g.n(str.getBytes());
        String str2 = "";
        String str3 = "";
        if (n.length() > 0) {
            str2 = n.charAt(0) + "/";
        }
        if (n.length() >= 2) {
            str3 = n.charAt(1) + "/";
        }
        return ae.getAccSnsPath() + str2 + str3;
    }

    public final boolean a(String str, q qVar) {
        w.d("MicroMsg.snsMediaStorage", "replace AlbumLikeList " + str);
        Cursor a = this.hnH.a("SnsMedia", null, "StrId=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            a.close();
            w.d("MicroMsg.snsMediaStorage", "snsMedia Insert");
            if (qVar != null) {
                if (((int) this.hnH.insert("SnsMedia", "local_id", qVar.bhS())) != -1) {
                    return true;
                }
            }
            return false;
        }
        a.close();
        return this.hnH.update("SnsMedia", qVar.bhS(), "StrId=?", new String[]{str}) > 0;
    }

    public final int a(int i, q qVar) {
        return this.hnH.update("SnsMedia", qVar.bhS(), "local_id=?", new String[]{String.valueOf(i)});
    }

    public final q Gv(String str) {
        q qVar = new q();
        Cursor a = this.hnH.a("SnsMedia", null, "StrId=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            qVar.b(a);
            a.close();
            return qVar;
        }
        a.close();
        return null;
    }

    public final q dH(long j) {
        q qVar = new q();
        Cursor a = this.hnH.a("SnsMedia", null, "local_id=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            qVar.b(a);
            a.close();
            return qVar;
        }
        a.close();
        return null;
    }

    public final List<h> bv(List<h> list) {
        List<h> linkedList = new LinkedList();
        if (list == null || list.size() == 0) {
            return null;
        }
        for (h hVar : list) {
            int a = a(hVar);
            if (a == -1) {
                return null;
            }
            h hVar2 = new h(a, hVar.type);
            hVar2.height = hVar.height;
            hVar2.width = hVar.width;
            hVar2.fileSize = hVar.fileSize;
            linkedList.add(hVar2);
        }
        return linkedList;
    }

    private static h a(h hVar, String str) {
        Throwable th;
        Throwable e;
        int i;
        int i2;
        InputStream inputStream = null;
        InputStream iVar;
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            inputStream = FileOp.openRead(str);
            try {
                if (inputStream instanceof FileInputStream) {
                    iVar = new i((FileInputStream) inputStream);
                } else {
                    iVar = inputStream;
                }
            } catch (Throwable e2) {
                iVar = inputStream;
                th = e2;
                i = 0;
                try {
                    w.printErrStackTrace("MicroMsg.snsMediaStorage", th, "setImageExtInfo failed: " + str, new Object[0]);
                    if (iVar == null) {
                        i2 = 0;
                    } else {
                        try {
                            iVar.close();
                            i2 = 0;
                        } catch (IOException e3) {
                            i2 = 0;
                        }
                    }
                    hVar.width = i2;
                    hVar.height = i;
                    hVar.fileSize = (int) FileOp.ki(str);
                    return hVar;
                } catch (Throwable th2) {
                    e2 = th2;
                    if (iVar != null) {
                        try {
                            iVar.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw e2;
                }
            } catch (Throwable th3) {
                e2 = th3;
                iVar = inputStream;
                if (iVar != null) {
                    iVar.close();
                }
                throw e2;
            }
            try {
                iVar.mark(1048576);
                BitmapFactory.decodeStream(iVar, null, options);
                iVar.reset();
                Exif exif = new Exif();
                exif.parseFromStream(iVar);
                i = exif.getOrientationInDegree();
                int i3;
                if (i == 90 || i == 270) {
                    try {
                        i3 = options.outWidth;
                        i2 = options.outHeight;
                        i = i3;
                    } catch (Throwable e22) {
                        Throwable th4 = e22;
                        i = i2;
                        th = th4;
                        w.printErrStackTrace("MicroMsg.snsMediaStorage", th, "setImageExtInfo failed: " + str, new Object[0]);
                        if (iVar == null) {
                            iVar.close();
                            i2 = 0;
                        } else {
                            i2 = 0;
                        }
                        hVar.width = i2;
                        hVar.height = i;
                        hVar.fileSize = (int) FileOp.ki(str);
                        return hVar;
                    }
                }
                i3 = options.outHeight;
                i2 = options.outWidth;
                i = i3;
                if (iVar != null) {
                    try {
                        iVar.close();
                    } catch (IOException e5) {
                    }
                }
            } catch (Throwable e222) {
                th = e222;
                i = 0;
                w.printErrStackTrace("MicroMsg.snsMediaStorage", th, "setImageExtInfo failed: " + str, new Object[0]);
                if (iVar == null) {
                    i2 = 0;
                } else {
                    iVar.close();
                    i2 = 0;
                }
                hVar.width = i2;
                hVar.height = i;
                hVar.fileSize = (int) FileOp.ki(str);
                return hVar;
            }
        } catch (Throwable e2222) {
            iVar = inputStream;
            th = e2222;
            i = 0;
            w.printErrStackTrace("MicroMsg.snsMediaStorage", th, "setImageExtInfo failed: " + str, new Object[0]);
            if (iVar == null) {
                iVar.close();
                i2 = 0;
            } else {
                i2 = 0;
            }
            hVar.width = i2;
            hVar.height = i;
            hVar.fileSize = (int) FileOp.ki(str);
            return hVar;
        } catch (Throwable th5) {
            e2222 = th5;
            iVar = inputStream;
            if (iVar != null) {
                iVar.close();
            }
            throw e2222;
        }
        hVar.width = i2;
        hVar.height = i;
        hVar.fileSize = (int) FileOp.ki(str);
        return hVar;
    }

    private int a(h hVar) {
        String accSnsPath = ae.getAccSnsPath();
        String accSnsTmpPath = ae.getAccSnsTmpPath();
        w.i("MicroMsg.snsMediaStorage", "SnsMediaStorage %s %s", new Object[]{accSnsPath, accSnsTmpPath});
        long currentTimeMillis = System.currentTimeMillis();
        String str = hVar.path;
        int i = hVar.type;
        if (!FileOp.aO(str)) {
            return -1;
        }
        String n = com.tencent.mm.a.g.n((str + System.currentTimeMillis()).getBytes());
        String EF = com.tencent.mm.plugin.sns.data.i.EF(n);
        w.d("MicroMsg.snsMediaStorage", "insert : original img path = " + str);
        if (!FileOp.aO(accSnsTmpPath)) {
            w.i("MicroMsg.snsMediaStorage", "create snstmp path " + accSnsTmpPath);
            FileOp.kl(accSnsTmpPath);
        }
        if (!FileOp.aO(accSnsPath)) {
            w.i("MicroMsg.snsMediaStorage", "create snsPath " + accSnsPath);
            FileOp.kl(accSnsPath);
        }
        a aVar = new a(this);
        h a = a(hVar, str);
        int i2 = a.width;
        int i3 = a.height;
        int i4 = a.fileSize;
        aVar.qnU = str;
        aVar.qnW = i2;
        aVar.qnX = i3;
        aVar.qnY = i4;
        if (!d(accSnsTmpPath, str, EF, true)) {
            return -1;
        }
        w.d("MicroMsg.snsMediaStorage", "insert0 " + (System.currentTimeMillis() - currentTimeMillis));
        w.d("MicroMsg.snsMediaStorage", "insert: compressed bigMediaPath = " + EF);
        int ki = (int) FileOp.ki(accSnsTmpPath + EF);
        a = a(a, accSnsTmpPath + EF);
        i2 = a.width;
        i3 = a.height;
        aVar.qnZ = i2;
        aVar.qoa = i3;
        aVar.qob = ki;
        q qVar = new q();
        qVar.olJ = n;
        qVar.iam = (long) ((int) bg.Ny());
        qVar.type = i;
        alk com_tencent_mm_protocal_c_alk = new alk();
        com_tencent_mm_protocal_c_alk.tPk = a.pQZ;
        com_tencent_mm_protocal_c_alk.tPF = a.pQY;
        com_tencent_mm_protocal_c_alk.token = a.pRb;
        com_tencent_mm_protocal_c_alk.tPO = a.pRc;
        com_tencent_mm_protocal_c_alk.tQc = 0;
        com_tencent_mm_protocal_c_alk.tQb = new ale();
        com_tencent_mm_protocal_c_alk.hqX = 0;
        com_tencent_mm_protocal_c_alk.msk = a.desc;
        w.d("MicroMsg.snsMediaStorage", "upload.filterId " + a.pQX);
        com_tencent_mm_protocal_c_alk.tPE = a.pQX;
        com_tencent_mm_protocal_c_alk.tQe = 2;
        com_tencent_mm_protocal_c_alk.fFW = com.tencent.mm.a.g.aV(accSnsTmpPath + EF);
        try {
            qVar.qnT = com_tencent_mm_protocal_c_alk.toByteArray();
        } catch (Exception e) {
            w.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
        }
        qVar.bhT();
        qVar.qnP = ki;
        w.i("MicroMsg.snsMediaStorage", "insert a local snsMedia  totallen  :" + ki + " filepath: " + accSnsTmpPath + EF);
        ki = (int) this.hnH.insert("SnsMedia", "local_id", qVar.bhS());
        w.d("MicroMsg.snsMediaStorage", "insert localId " + ki);
        String str2 = "Locall_path" + ki;
        aVar.qnV = String.valueOf(ki);
        Exif fromFile = Exif.fromFile(aVar.qnU);
        int i5 = 0;
        if (aVar.qnU.indexOf("png") >= 0) {
            i5 = 1;
        } else if (aVar.qnU.indexOf("jpg") >= 0 || aVar.qnU.indexOf("jpeg") >= 0) {
            i5 = 2;
        } else if (aVar.qnU.indexOf("mp3") >= 0) {
            i5 = 3;
        }
        d dVar = new d();
        dVar.n("20 localID", aVar.qnV + ",");
        dVar.n("21 MediaType", i5 + ",");
        dVar.n("22 OriginWidth", aVar.qnW + ",");
        dVar.n("23 OriginHeight", aVar.qnX + ",");
        dVar.n("24 CompressedWidth", aVar.qnZ + ",");
        dVar.n("25 CompressedHeight", aVar.qoa + ",");
        dVar.n("26 OriginSize", aVar.qnY + ",");
        dVar.n("27 CompressedSize", aVar.qob + ",");
        dVar.n("28 FNumber", fromFile.fNumber + ",");
        dVar.n("29 ExposureTime", fromFile.exposureTime + ",");
        dVar.n("30 ISO", fromFile.isoSpeedRatings + ",");
        dVar.n("31 Flash", fromFile.flash + ",");
        dVar.n("32 LensModel", a.Gy(fromFile.model) + ",");
        dVar.n("33 CreatTime", a.Gy(fromFile.dateTimeOriginal) + ",");
        dVar.n("34 IsFromWeChat", "0,");
        dVar.n("35 Scene", "1,");
        w.v("MicroMsg.snsMediaStorage", "report logbuffer MMImageExifInfo(14525): %s, orgPath:%s", new Object[]{dVar.JG(), aVar.qnU});
        com.tencent.mm.plugin.report.service.g.oUh.i(14525, new Object[]{dVar});
        accSnsPath = com.tencent.mm.plugin.sns.data.i.EF(str2);
        n = Gu(str2);
        FileOp.kl(n);
        w.i("MicroMsg.snsMediaStorage", "checkcntpath " + n);
        FileOp.p(accSnsTmpPath + EF, n + accSnsPath);
        accSnsTmpPath = n + com.tencent.mm.plugin.sns.data.i.EB(str2);
        EF = n + com.tencent.mm.plugin.sns.data.i.EC(str2);
        FileOp.deleteFile(accSnsTmpPath);
        FileOp.deleteFile(EF);
        w.i("MicroMsg.snsMediaStorage", "insert done " + (System.currentTimeMillis() - currentTimeMillis) + " targetPath : " + n + accSnsPath + "  now delete...:" + accSnsTmpPath + " & " + EF);
        qVar.olJ = str2;
        a(ki, qVar);
        return ki;
    }

    public final h a(h hVar, String str, String str2, String str3, String str4) {
        q qVar = new q();
        qVar.iam = (long) ((int) bg.Ny());
        qVar.type = hVar.type;
        alk com_tencent_mm_protocal_c_alk = new alk();
        com_tencent_mm_protocal_c_alk.tPk = hVar.pQZ;
        com_tencent_mm_protocal_c_alk.tPF = hVar.pQY;
        com_tencent_mm_protocal_c_alk.token = hVar.pRb;
        com_tencent_mm_protocal_c_alk.tPO = hVar.pRc;
        com_tencent_mm_protocal_c_alk.tQc = 0;
        com_tencent_mm_protocal_c_alk.tQb = new ale();
        com_tencent_mm_protocal_c_alk.hqX = 0;
        com_tencent_mm_protocal_c_alk.msk = hVar.desc;
        w.d("MicroMsg.snsMediaStorage", "upload.filterId " + hVar.pQX);
        com_tencent_mm_protocal_c_alk.tPE = hVar.pQX;
        com_tencent_mm_protocal_c_alk.tQe = 2;
        com_tencent_mm_protocal_c_alk.fVB = str;
        com_tencent_mm_protocal_c_alk.tQg = str2;
        com_tencent_mm_protocal_c_alk.fFW = hVar.pRd;
        try {
            qVar.qnT = com_tencent_mm_protocal_c_alk.toByteArray();
        } catch (Exception e) {
            w.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
        }
        qVar.bhT();
        int insert = (int) this.hnH.insert("SnsMedia", "local_id", qVar.bhS());
        String str5 = "Locall_path" + insert;
        w.d("MicroMsg.snsMediaStorage", "insert localId " + insert);
        String EF = com.tencent.mm.plugin.sns.data.i.EF(str5);
        String EG = com.tencent.mm.plugin.sns.data.i.EG(str5);
        String EE = com.tencent.mm.plugin.sns.data.i.EE(str5);
        String EH = com.tencent.mm.plugin.sns.data.i.EH(str5);
        String Gu = Gu(str5);
        FileOp.kl(Gu);
        FileOp.p(str2, Gu + EF);
        FileOp.p(str2, Gu + EG);
        FileOp.p(str2, Gu + EE);
        FileOp.p(str, Gu + EH);
        com_tencent_mm_protocal_c_alk.fVB = Gu + EH;
        com_tencent_mm_protocal_c_alk.tQg = Gu + EG;
        com_tencent_mm_protocal_c_alk.fFW = hVar.pRd;
        try {
            qVar.qnT = com_tencent_mm_protocal_c_alk.toByteArray();
        } catch (Exception e2) {
            w.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
        }
        qVar.olJ = str5;
        if (!(TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4))) {
            ale com_tencent_mm_protocal_c_ale = new ale();
            com_tencent_mm_protocal_c_ale.jOc = 1;
            com_tencent_mm_protocal_c_ale.msN = str3;
            com_tencent_mm_protocal_c_alk.tQb = com_tencent_mm_protocal_c_ale;
            com_tencent_mm_protocal_c_alk.tQe = 0;
            com.tencent.mm.modelcdntran.g.Em();
            com_tencent_mm_protocal_c_alk.tPD = b.iL(str);
            if (!bg.mA(str4)) {
                com_tencent_mm_protocal_c_ale = new ale();
                com_tencent_mm_protocal_c_ale.jOc = 1;
                com_tencent_mm_protocal_c_ale.msN = str4;
                com_tencent_mm_protocal_c_alk.tQd.add(com_tencent_mm_protocal_c_ale);
            }
            try {
                qVar.qnT = com_tencent_mm_protocal_c_alk.toByteArray();
            } catch (Throwable e3) {
                w.printErrStackTrace("MicroMsg.snsMediaStorage", e3, "", new Object[0]);
            }
            qVar.bhU();
        }
        a(insert, qVar);
        h a = a(hVar, com_tencent_mm_protocal_c_alk.tQg);
        a.pRa = insert;
        return a;
    }

    public static boolean bhV() {
        if ("hevc".equals(com.tencent.mm.platformtools.r.ijL)) {
            return true;
        }
        return ae.beU();
    }

    public static boolean bhW() {
        if ("wxpc".equals(com.tencent.mm.platformtools.r.ijL)) {
            return true;
        }
        return ae.beV();
    }

    public static boolean T(String str, String str2, String str3) {
        return d(str, str2, str3, true);
    }

    public static boolean bhX() {
        return pOu >= 1080 && pPh >= 1080;
    }

    public static boolean d(String str, String str2, String str3, boolean z) {
        String str4;
        boolean z2;
        Object obj;
        int i;
        int i2;
        int i3;
        int ki;
        int i4;
        String value;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Exif fromFile;
        int i10;
        Options options;
        InputStream inputStream;
        InputStream iVar;
        DecodeResultLogger decodeResultLogger;
        Bitmap decodeStream;
        Throwable th;
        Throwable th2;
        Options Pe = com.tencent.mm.sdk.platformtools.d.Pe(str2);
        if (Pe != null) {
            str4 = Pe.outMimeType;
            w.d("MicroMsg.snsMediaStorage", "mimetype: " + str4);
            if (str4 != null) {
                str4 = str4.toLowerCase();
                if (str4.indexOf("jpg") >= 0) {
                    z2 = true;
                } else if (str4.indexOf("jpeg") >= 0) {
                    z2 = true;
                } else if (str4.indexOf("png") >= 0) {
                    z2 = true;
                }
                if (Pe != null) {
                    str4 = Pe.outMimeType;
                    if (str4 != null) {
                        str4 = str4.toLowerCase();
                        if (str4.indexOf("jpg") >= 0) {
                            obj = 1;
                        } else if (str4.indexOf("jpeg") >= 0) {
                            int i11 = 1;
                        }
                        i = 100;
                        if (z) {
                            i2 = 100;
                            i = -1;
                        } else {
                            try {
                                com.tencent.mm.modelcdntran.g.El();
                                if (!c.fA(64) || bhV() || bhW()) {
                                    if (!am.isWifi(ab.getContext())) {
                                        i = Integer.valueOf(com.tencent.mm.i.g.sV().getValue("SnsWebpCompressPicLevelForWifi")).intValue();
                                    } else if (am.is2G(ab.getContext())) {
                                        i = Integer.valueOf(com.tencent.mm.i.g.sV().getValue("SnsWebpCompressPicLevelFor3G")).intValue();
                                    } else {
                                        i = Integer.valueOf(com.tencent.mm.i.g.sV().getValue("SnsWebpCompressPicLevelFor2G")).intValue();
                                    }
                                } else if (am.isWifi(ab.getContext())) {
                                    i = Integer.valueOf(com.tencent.mm.i.g.sV().getValue("SnsCompressPicLevelForWifi")).intValue();
                                } else if (am.is2G(ab.getContext())) {
                                    i = Integer.valueOf(com.tencent.mm.i.g.sV().getValue("SnsCompressPicLevelFor2G")).intValue();
                                } else {
                                    i = Integer.valueOf(com.tencent.mm.i.g.sV().getValue("SnsCompressPicLevelFor3G")).intValue();
                                }
                                w.d("MicroMsg.snsMediaStorage", "createPic comLev---ßwebpWifi:%s, webp2G:%s, webp3G:%s,   wifi:%s, 2G:%s, 3G:%s", new Object[]{com.tencent.mm.i.g.sV().getValue("SnsWebpCompressPicLevelForWifi"), com.tencent.mm.i.g.sV().getValue("SnsWebpCompressPicLevelFor2G"), com.tencent.mm.i.g.sV().getValue("SnsWebpCompressPicLevelFor3G"), com.tencent.mm.i.g.sV().getValue("SnsCompressPicLevelForWifi"), com.tencent.mm.i.g.sV().getValue("SnsCompressPicLevelFor2G"), com.tencent.mm.i.g.sV().getValue("SnsCompressPicLevelFor3G")});
                            } catch (Exception e) {
                            }
                            w.i("MicroMsg.snsMediaStorage", "CompresssnsPicLevel-level:%d isUpload: %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
                            if (i > 10 || i > 100) {
                                i3 = 50;
                            } else {
                                i3 = i;
                            }
                            if (obj == null) {
                                i = MMNativeJpeg.queryQuality(str2);
                                i2 = (i < i3 || i <= 25) ? i3 : i;
                            } else {
                                i2 = i3;
                                i = -1;
                            }
                        }
                        ki = (int) FileOp.ki(str2);
                        i3 = 0;
                        i4 = 0;
                        if (bhX()) {
                            try {
                                if (!am.isWifi(ab.getContext())) {
                                    value = com.tencent.mm.i.g.sV().getValue("SnsCompressResolutionForWifi");
                                    i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                                    i4 = Integer.valueOf(value.split("\\*")[1]).intValue();
                                } else if (am.is2G(ab.getContext())) {
                                    value = com.tencent.mm.i.g.sV().getValue("SnsCompressResolutionFor3G");
                                    i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                                    i4 = Integer.valueOf(value.split("\\*")[1]).intValue();
                                } else {
                                    value = com.tencent.mm.i.g.sV().getValue("SnsCompressResolutionFor2G");
                                    i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                                    i4 = Integer.valueOf(value.split("\\*")[1]).intValue();
                                }
                            } catch (Exception e2) {
                            }
                        } else {
                            try {
                                if (!am.isWifi(ab.getContext())) {
                                    value = com.tencent.mm.i.g.sV().getValue("SnsCompressResolution1080PForWifi");
                                    i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                                    i4 = Integer.valueOf(value.split("\\*")[1]).intValue();
                                } else if (am.is2G(ab.getContext())) {
                                    value = com.tencent.mm.i.g.sV().getValue("SnsCompressResolution1080PFor3G");
                                    i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                                    i4 = Integer.valueOf(value.split("\\*")[1]).intValue();
                                } else {
                                    value = com.tencent.mm.i.g.sV().getValue("SnsCompressResolution1080PFor2G");
                                    i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                                    i4 = Integer.valueOf(value.split("\\*")[1]).intValue();
                                }
                            } catch (Exception e3) {
                            }
                        }
                        if (i3 >= i4) {
                            i5 = i4;
                            i4 = i3;
                            i3 = i5;
                        }
                        if (!z) {
                            i4 = 2048;
                            i3 = 2048;
                        }
                        w.i("MicroMsg.snsMediaStorage", "server target widht height %d %d screen %d %d comLev: %d is1080p:%s isUpload%s", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(pOu), Integer.valueOf(pPh), Integer.valueOf(i2), Boolean.valueOf(r5), Boolean.valueOf(z)});
                        if (i4 <= 0 || i3 <= 0 || i4 * i3 > 4194304) {
                            i4 = 960;
                            i3 = 640;
                        }
                        i6 = bg.getInt(com.tencent.mm.i.g.sV().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
                        if (i6 <= 0) {
                            i6 = 100;
                        }
                        i7 = i6 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                        i6 = bg.getInt(com.tencent.mm.i.g.sV().getValue("PicCompressAvoidanceActiveSizeLong"), m.CTRL_INDEX);
                        if (i6 <= 0) {
                            i6 = m.CTRL_INDEX;
                        }
                        i8 = i6 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                        i6 = bg.getInt(com.tencent.mm.i.g.sV().getValue("PicCompressAvoidanceRemainderPerc"), 10);
                        if (i6 > 0 || i6 >= 100) {
                            i9 = 10;
                        } else {
                            i9 = i6;
                        }
                        i6 = 0;
                        if (obj != null) {
                            try {
                                fromFile = Exif.fromFile(str2);
                                if (fromFile != null) {
                                    i6 = fromFile.getOrientationInDegree() % 360;
                                }
                                i10 = i6;
                            } catch (Exception e4) {
                                w.e("MicroMsg.snsMediaStorage", "get degree error " + e4.getMessage());
                            }
                            w.i("MicroMsg.snsMediaStorage", "option info " + Pe.outWidth + " " + Pe.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i10 + " filelen " + ki + " target " + i4 + " " + i3);
                            boolean z3;
                            if ((Pe.outWidth < Pe.outHeight * 2 || Pe.outHeight >= Pe.outWidth * 2) && Pe.outWidth * Pe.outHeight <= 10240000) {
                                if (ki >= i8 && z2 && i10 == 0) {
                                    w.i("MicroMsg.snsMediaStorage", "filelen is control in picCompressAvoidanceActiveSizeLong " + i8);
                                    if (FileOp.p(str2, str + str3) >= 0) {
                                        return true;
                                    }
                                    return false;
                                }
                                options = new Options();
                                com.tencent.mm.sdk.platformtools.d.b(options);
                                inputStream = null;
                                inputStream = FileOp.openRead(str2);
                                if (inputStream.markSupported() && (inputStream instanceof FileInputStream)) {
                                    iVar = new i((FileInputStream) inputStream);
                                } else {
                                    iVar = inputStream;
                                }
                                iVar.mark(1048576);
                                decodeResultLogger = new DecodeResultLogger();
                                decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                                iVar.reset();
                                if (decodeStream != null) {
                                    if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                                        com.tencent.mm.plugin.report.service.g.oUh.A(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                                    }
                                    if (iVar != null) {
                                        try {
                                            iVar.close();
                                        } catch (IOException e5) {
                                        }
                                    }
                                    return false;
                                }
                                com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.sdk.platformtools.d.b(decodeStream, (float) i10), i2, CompressFormat.JPEG, str + str3, true);
                                if (z2 || i10 != 0) {
                                    if (iVar != null) {
                                        try {
                                            iVar.close();
                                        } catch (IOException e6) {
                                        }
                                    }
                                    return true;
                                }
                                w.i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(ki), Long.valueOf(FileOp.ki(str + str3)), Integer.valueOf(i9)});
                                if ((((long) ki) - FileOp.ki(str + str3)) * 100 < ((long) (i9 * ki))) {
                                    FileOp.deleteFile(str + str3);
                                    z3 = FileOp.p(str2, new StringBuilder().append(str).append(str3).toString()) >= 0;
                                    if (iVar == null) {
                                        return z3;
                                    }
                                    try {
                                        iVar.close();
                                        return z3;
                                    } catch (IOException e7) {
                                        return z3;
                                    }
                                }
                                if (iVar != null) {
                                    try {
                                        iVar.close();
                                    } catch (IOException e8) {
                                    }
                                }
                                return true;
                            } else if (ki < i7 && z2 && i10 == 0) {
                                w.i("MicroMsg.snsMediaStorage", "filelen is control in picCompressAvoidanceActiveSizeNormal " + i7);
                                return FileOp.p(str2, new StringBuilder().append(str).append(str3).toString()) >= 0;
                            } else if ((Pe.outWidth > i4 || Pe.outHeight > i3) && (Pe.outHeight > i4 || Pe.outWidth > i3)) {
                                i = Pe.outWidth >= Pe.outHeight ? i4 : i3;
                                if (Pe.outWidth < Pe.outHeight) {
                                    i3 = i4;
                                }
                                if (Pe.outWidth >= Pe.outHeight * 2 || Pe.outHeight >= Pe.outWidth * 2) {
                                    w.i("MicroMsg.snsMediaStorage", "too max pic " + Pe.outWidth + " " + Pe.outHeight);
                                    if (Pe.outHeight <= 0) {
                                        Pe.outHeight = 1;
                                    }
                                    if (Pe.outWidth <= 0) {
                                        Pe.outWidth = 1;
                                    }
                                    if (Pe.outWidth > Pe.outHeight) {
                                        i = Pe.outWidth / Pe.outHeight;
                                    } else {
                                        i = Pe.outHeight / Pe.outWidth;
                                    }
                                    if (i == 0) {
                                        i = 1;
                                    }
                                    i3 = (int) Math.sqrt((double) (10240000 / i));
                                    if (Pe.outWidth > Pe.outHeight) {
                                        i4 = i3 * i;
                                    } else {
                                        i4 = i3;
                                        i3 *= i;
                                    }
                                    w.i("MicroMsg.snsMediaStorage", "new width height " + i4 + " " + i3 + " " + i);
                                } else {
                                    i4 = i;
                                }
                                z3 = a(str2, i3, i4, CompressFormat.JPEG, i2, str, str3, z);
                                if (!z2 || i10 != 0) {
                                    return z3;
                                }
                                w.i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(ki), Long.valueOf(FileOp.ki(str + str3)), Integer.valueOf(i9)});
                                if ((((long) ki) - FileOp.ki(str + str3)) * 100 >= ((long) (i9 * ki))) {
                                    return z3;
                                }
                                FileOp.deleteFile(str + str3);
                                if (FileOp.p(str2, str + str3) >= 0) {
                                    return true;
                                }
                                return false;
                            } else {
                                w.i("MicroMsg.snsMediaStorage", "hello ieg this is little img  %d w: %d h: %d", new Object[]{Integer.valueOf(ki), Integer.valueOf(Pe.outWidth), Integer.valueOf(Pe.outHeight)});
                                if (FileOp.ki(str2) < 71680) {
                                    if (z2) {
                                        w.i("MicroMsg.snsMediaStorage", "isSysSupportedPic %s", new Object[]{str2});
                                        return FileOp.p(str2, new StringBuilder().append(str).append(str3).toString()) >= 0;
                                    } else if (Pe.outWidth < ck.CTRL_INDEX && Pe.outHeight < ck.CTRL_INDEX) {
                                        return a(str2, Pe.outHeight, Pe.outWidth, CompressFormat.PNG, i2, str, str3, z);
                                    }
                                }
                                z3 = a(str2, Pe.outHeight, Pe.outWidth, CompressFormat.JPEG, i2, str, str3, z);
                                if (!z2 || i10 != 0) {
                                    return z3;
                                }
                                w.i("MicroMsg.snsMediaStorage", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(ki), Long.valueOf(FileOp.ki(str + str3)), Integer.valueOf(i9)});
                                if ((((long) ki) - FileOp.ki(str + str3)) * 100 >= ((long) (i9 * ki))) {
                                    return z3;
                                }
                                FileOp.deleteFile(str + str3);
                                return FileOp.p(str2, new StringBuilder().append(str).append(str3).toString()) >= 0;
                            }
                        }
                        i10 = 0;
                        w.i("MicroMsg.snsMediaStorage", "option info " + Pe.outWidth + " " + Pe.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i10 + " filelen " + ki + " target " + i4 + " " + i3);
                        if (Pe.outWidth < Pe.outHeight * 2) {
                        }
                        if (ki >= i8) {
                        }
                        options = new Options();
                        com.tencent.mm.sdk.platformtools.d.b(options);
                        inputStream = null;
                        inputStream = FileOp.openRead(str2);
                        if (inputStream.markSupported()) {
                        }
                        iVar = inputStream;
                        iVar.mark(1048576);
                        decodeResultLogger = new DecodeResultLogger();
                        decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                        iVar.reset();
                        if (decodeStream != null) {
                            com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.sdk.platformtools.d.b(decodeStream, (float) i10), i2, CompressFormat.JPEG, str + str3, true);
                            if (z2) {
                            }
                            if (iVar != null) {
                                iVar.close();
                            }
                            return true;
                        }
                        if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                            com.tencent.mm.plugin.report.service.g.oUh.A(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                        }
                        if (iVar != null) {
                            iVar.close();
                        }
                        return false;
                    }
                }
                obj = null;
                i = 100;
                if (z) {
                    i2 = 100;
                    i = -1;
                } else {
                    com.tencent.mm.modelcdntran.g.El();
                    if (c.fA(64)) {
                    }
                    if (!am.isWifi(ab.getContext())) {
                        i = Integer.valueOf(com.tencent.mm.i.g.sV().getValue("SnsWebpCompressPicLevelForWifi")).intValue();
                    } else if (am.is2G(ab.getContext())) {
                        i = Integer.valueOf(com.tencent.mm.i.g.sV().getValue("SnsWebpCompressPicLevelFor3G")).intValue();
                    } else {
                        i = Integer.valueOf(com.tencent.mm.i.g.sV().getValue("SnsWebpCompressPicLevelFor2G")).intValue();
                    }
                    w.d("MicroMsg.snsMediaStorage", "createPic comLev---ßwebpWifi:%s, webp2G:%s, webp3G:%s,   wifi:%s, 2G:%s, 3G:%s", new Object[]{com.tencent.mm.i.g.sV().getValue("SnsWebpCompressPicLevelForWifi"), com.tencent.mm.i.g.sV().getValue("SnsWebpCompressPicLevelFor2G"), com.tencent.mm.i.g.sV().getValue("SnsWebpCompressPicLevelFor3G"), com.tencent.mm.i.g.sV().getValue("SnsCompressPicLevelForWifi"), com.tencent.mm.i.g.sV().getValue("SnsCompressPicLevelFor2G"), com.tencent.mm.i.g.sV().getValue("SnsCompressPicLevelFor3G")});
                    w.i("MicroMsg.snsMediaStorage", "CompresssnsPicLevel-level:%d isUpload: %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
                    if (i > 10) {
                    }
                    i3 = 50;
                    if (obj == null) {
                        i2 = i3;
                        i = -1;
                    } else {
                        i = MMNativeJpeg.queryQuality(str2);
                        if (i < i3) {
                        }
                    }
                }
                ki = (int) FileOp.ki(str2);
                i3 = 0;
                i4 = 0;
                if (bhX()) {
                    if (!am.isWifi(ab.getContext())) {
                        value = com.tencent.mm.i.g.sV().getValue("SnsCompressResolutionForWifi");
                        i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                        i4 = Integer.valueOf(value.split("\\*")[1]).intValue();
                    } else if (am.is2G(ab.getContext())) {
                        value = com.tencent.mm.i.g.sV().getValue("SnsCompressResolutionFor3G");
                        i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                        i4 = Integer.valueOf(value.split("\\*")[1]).intValue();
                    } else {
                        value = com.tencent.mm.i.g.sV().getValue("SnsCompressResolutionFor2G");
                        i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                        i4 = Integer.valueOf(value.split("\\*")[1]).intValue();
                    }
                } else if (!am.isWifi(ab.getContext())) {
                    value = com.tencent.mm.i.g.sV().getValue("SnsCompressResolution1080PForWifi");
                    i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                    i4 = Integer.valueOf(value.split("\\*")[1]).intValue();
                } else if (am.is2G(ab.getContext())) {
                    value = com.tencent.mm.i.g.sV().getValue("SnsCompressResolution1080PFor3G");
                    i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                    i4 = Integer.valueOf(value.split("\\*")[1]).intValue();
                } else {
                    value = com.tencent.mm.i.g.sV().getValue("SnsCompressResolution1080PFor2G");
                    i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                    i4 = Integer.valueOf(value.split("\\*")[1]).intValue();
                }
                if (i3 >= i4) {
                    i5 = i4;
                    i4 = i3;
                    i3 = i5;
                }
                if (z) {
                    i4 = 2048;
                    i3 = 2048;
                }
                w.i("MicroMsg.snsMediaStorage", "server target widht height %d %d screen %d %d comLev: %d is1080p:%s isUpload%s", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(pOu), Integer.valueOf(pPh), Integer.valueOf(i2), Boolean.valueOf(r5), Boolean.valueOf(z)});
                i4 = 960;
                i3 = 640;
                i6 = bg.getInt(com.tencent.mm.i.g.sV().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
                if (i6 <= 0) {
                    i6 = 100;
                }
                i7 = i6 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                i6 = bg.getInt(com.tencent.mm.i.g.sV().getValue("PicCompressAvoidanceActiveSizeLong"), m.CTRL_INDEX);
                if (i6 <= 0) {
                    i6 = m.CTRL_INDEX;
                }
                i8 = i6 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                i6 = bg.getInt(com.tencent.mm.i.g.sV().getValue("PicCompressAvoidanceRemainderPerc"), 10);
                if (i6 > 0) {
                }
                i9 = 10;
                i6 = 0;
                if (obj != null) {
                    fromFile = Exif.fromFile(str2);
                    if (fromFile != null) {
                        i6 = fromFile.getOrientationInDegree() % 360;
                    }
                    i10 = i6;
                    w.i("MicroMsg.snsMediaStorage", "option info " + Pe.outWidth + " " + Pe.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i10 + " filelen " + ki + " target " + i4 + " " + i3);
                    if (Pe.outWidth < Pe.outHeight * 2) {
                    }
                    if (ki >= i8) {
                    }
                    options = new Options();
                    com.tencent.mm.sdk.platformtools.d.b(options);
                    inputStream = null;
                    inputStream = FileOp.openRead(str2);
                    if (inputStream.markSupported()) {
                    }
                    iVar = inputStream;
                    iVar.mark(1048576);
                    decodeResultLogger = new DecodeResultLogger();
                    decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                    iVar.reset();
                    if (decodeStream != null) {
                        if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                            com.tencent.mm.plugin.report.service.g.oUh.A(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                        }
                        if (iVar != null) {
                            iVar.close();
                        }
                        return false;
                    }
                    com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.sdk.platformtools.d.b(decodeStream, (float) i10), i2, CompressFormat.JPEG, str + str3, true);
                    if (z2) {
                    }
                    if (iVar != null) {
                        iVar.close();
                    }
                    return true;
                }
                i10 = 0;
                w.i("MicroMsg.snsMediaStorage", "option info " + Pe.outWidth + " " + Pe.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i10 + " filelen " + ki + " target " + i4 + " " + i3);
                if (Pe.outWidth < Pe.outHeight * 2) {
                }
                if (ki >= i8) {
                }
                options = new Options();
                com.tencent.mm.sdk.platformtools.d.b(options);
                inputStream = null;
                inputStream = FileOp.openRead(str2);
                if (inputStream.markSupported()) {
                }
                iVar = inputStream;
                iVar.mark(1048576);
                decodeResultLogger = new DecodeResultLogger();
                decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                iVar.reset();
                if (decodeStream != null) {
                    com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.sdk.platformtools.d.b(decodeStream, (float) i10), i2, CompressFormat.JPEG, str + str3, true);
                    if (z2) {
                    }
                    if (iVar != null) {
                        iVar.close();
                    }
                    return true;
                }
                if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                    com.tencent.mm.plugin.report.service.g.oUh.A(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                }
                if (iVar != null) {
                    iVar.close();
                }
                return false;
            }
        }
        z2 = false;
        if (Pe != null) {
            str4 = Pe.outMimeType;
            if (str4 != null) {
                str4 = str4.toLowerCase();
                if (str4.indexOf("jpg") >= 0) {
                    obj = 1;
                } else if (str4.indexOf("jpeg") >= 0) {
                    int i112 = 1;
                }
                i = 100;
                if (z) {
                    com.tencent.mm.modelcdntran.g.El();
                    if (c.fA(64)) {
                    }
                    if (!am.isWifi(ab.getContext())) {
                        i = Integer.valueOf(com.tencent.mm.i.g.sV().getValue("SnsWebpCompressPicLevelForWifi")).intValue();
                    } else if (am.is2G(ab.getContext())) {
                        i = Integer.valueOf(com.tencent.mm.i.g.sV().getValue("SnsWebpCompressPicLevelFor2G")).intValue();
                    } else {
                        i = Integer.valueOf(com.tencent.mm.i.g.sV().getValue("SnsWebpCompressPicLevelFor3G")).intValue();
                    }
                    w.d("MicroMsg.snsMediaStorage", "createPic comLev---ßwebpWifi:%s, webp2G:%s, webp3G:%s,   wifi:%s, 2G:%s, 3G:%s", new Object[]{com.tencent.mm.i.g.sV().getValue("SnsWebpCompressPicLevelForWifi"), com.tencent.mm.i.g.sV().getValue("SnsWebpCompressPicLevelFor2G"), com.tencent.mm.i.g.sV().getValue("SnsWebpCompressPicLevelFor3G"), com.tencent.mm.i.g.sV().getValue("SnsCompressPicLevelForWifi"), com.tencent.mm.i.g.sV().getValue("SnsCompressPicLevelFor2G"), com.tencent.mm.i.g.sV().getValue("SnsCompressPicLevelFor3G")});
                    w.i("MicroMsg.snsMediaStorage", "CompresssnsPicLevel-level:%d isUpload: %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
                    if (i > 10) {
                    }
                    i3 = 50;
                    if (obj == null) {
                        i = MMNativeJpeg.queryQuality(str2);
                        if (i < i3) {
                        }
                    } else {
                        i2 = i3;
                        i = -1;
                    }
                } else {
                    i2 = 100;
                    i = -1;
                }
                ki = (int) FileOp.ki(str2);
                i3 = 0;
                i4 = 0;
                if (bhX()) {
                    if (!am.isWifi(ab.getContext())) {
                        value = com.tencent.mm.i.g.sV().getValue("SnsCompressResolution1080PForWifi");
                        i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                        i4 = Integer.valueOf(value.split("\\*")[1]).intValue();
                    } else if (am.is2G(ab.getContext())) {
                        value = com.tencent.mm.i.g.sV().getValue("SnsCompressResolution1080PFor2G");
                        i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                        i4 = Integer.valueOf(value.split("\\*")[1]).intValue();
                    } else {
                        value = com.tencent.mm.i.g.sV().getValue("SnsCompressResolution1080PFor3G");
                        i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                        i4 = Integer.valueOf(value.split("\\*")[1]).intValue();
                    }
                } else if (!am.isWifi(ab.getContext())) {
                    value = com.tencent.mm.i.g.sV().getValue("SnsCompressResolutionForWifi");
                    i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                    i4 = Integer.valueOf(value.split("\\*")[1]).intValue();
                } else if (am.is2G(ab.getContext())) {
                    value = com.tencent.mm.i.g.sV().getValue("SnsCompressResolutionFor2G");
                    i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                    i4 = Integer.valueOf(value.split("\\*")[1]).intValue();
                } else {
                    value = com.tencent.mm.i.g.sV().getValue("SnsCompressResolutionFor3G");
                    i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                    i4 = Integer.valueOf(value.split("\\*")[1]).intValue();
                }
                if (i3 >= i4) {
                    i5 = i4;
                    i4 = i3;
                    i3 = i5;
                }
                if (z) {
                    i4 = 2048;
                    i3 = 2048;
                }
                w.i("MicroMsg.snsMediaStorage", "server target widht height %d %d screen %d %d comLev: %d is1080p:%s isUpload%s", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(pOu), Integer.valueOf(pPh), Integer.valueOf(i2), Boolean.valueOf(r5), Boolean.valueOf(z)});
                i4 = 960;
                i3 = 640;
                i6 = bg.getInt(com.tencent.mm.i.g.sV().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
                if (i6 <= 0) {
                    i6 = 100;
                }
                i7 = i6 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                i6 = bg.getInt(com.tencent.mm.i.g.sV().getValue("PicCompressAvoidanceActiveSizeLong"), m.CTRL_INDEX);
                if (i6 <= 0) {
                    i6 = m.CTRL_INDEX;
                }
                i8 = i6 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                i6 = bg.getInt(com.tencent.mm.i.g.sV().getValue("PicCompressAvoidanceRemainderPerc"), 10);
                if (i6 > 0) {
                }
                i9 = 10;
                i6 = 0;
                if (obj != null) {
                    fromFile = Exif.fromFile(str2);
                    if (fromFile != null) {
                        i6 = fromFile.getOrientationInDegree() % 360;
                    }
                    i10 = i6;
                    w.i("MicroMsg.snsMediaStorage", "option info " + Pe.outWidth + " " + Pe.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i10 + " filelen " + ki + " target " + i4 + " " + i3);
                    if (Pe.outWidth < Pe.outHeight * 2) {
                    }
                    if (ki >= i8) {
                    }
                    options = new Options();
                    com.tencent.mm.sdk.platformtools.d.b(options);
                    inputStream = null;
                    inputStream = FileOp.openRead(str2);
                    if (inputStream.markSupported()) {
                    }
                    iVar = inputStream;
                    iVar.mark(1048576);
                    decodeResultLogger = new DecodeResultLogger();
                    decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                    iVar.reset();
                    if (decodeStream != null) {
                        if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                            com.tencent.mm.plugin.report.service.g.oUh.A(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                        }
                        if (iVar != null) {
                            iVar.close();
                        }
                        return false;
                    }
                    com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.sdk.platformtools.d.b(decodeStream, (float) i10), i2, CompressFormat.JPEG, str + str3, true);
                    if (z2) {
                    }
                    if (iVar != null) {
                        iVar.close();
                    }
                    return true;
                }
                i10 = 0;
                w.i("MicroMsg.snsMediaStorage", "option info " + Pe.outWidth + " " + Pe.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i10 + " filelen " + ki + " target " + i4 + " " + i3);
                if (Pe.outWidth < Pe.outHeight * 2) {
                }
                if (ki >= i8) {
                }
                options = new Options();
                com.tencent.mm.sdk.platformtools.d.b(options);
                inputStream = null;
                inputStream = FileOp.openRead(str2);
                if (inputStream.markSupported()) {
                }
                iVar = inputStream;
                iVar.mark(1048576);
                decodeResultLogger = new DecodeResultLogger();
                decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                iVar.reset();
                if (decodeStream != null) {
                    com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.sdk.platformtools.d.b(decodeStream, (float) i10), i2, CompressFormat.JPEG, str + str3, true);
                    if (z2) {
                    }
                    if (iVar != null) {
                        iVar.close();
                    }
                    return true;
                }
                if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                    com.tencent.mm.plugin.report.service.g.oUh.A(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                }
                if (iVar != null) {
                    iVar.close();
                }
                return false;
            }
        }
        obj = null;
        i = 100;
        if (z) {
            i2 = 100;
            i = -1;
        } else {
            com.tencent.mm.modelcdntran.g.El();
            if (c.fA(64)) {
            }
            if (!am.isWifi(ab.getContext())) {
                i = Integer.valueOf(com.tencent.mm.i.g.sV().getValue("SnsWebpCompressPicLevelForWifi")).intValue();
            } else if (am.is2G(ab.getContext())) {
                i = Integer.valueOf(com.tencent.mm.i.g.sV().getValue("SnsWebpCompressPicLevelFor3G")).intValue();
            } else {
                i = Integer.valueOf(com.tencent.mm.i.g.sV().getValue("SnsWebpCompressPicLevelFor2G")).intValue();
            }
            w.d("MicroMsg.snsMediaStorage", "createPic comLev---ßwebpWifi:%s, webp2G:%s, webp3G:%s,   wifi:%s, 2G:%s, 3G:%s", new Object[]{com.tencent.mm.i.g.sV().getValue("SnsWebpCompressPicLevelForWifi"), com.tencent.mm.i.g.sV().getValue("SnsWebpCompressPicLevelFor2G"), com.tencent.mm.i.g.sV().getValue("SnsWebpCompressPicLevelFor3G"), com.tencent.mm.i.g.sV().getValue("SnsCompressPicLevelForWifi"), com.tencent.mm.i.g.sV().getValue("SnsCompressPicLevelFor2G"), com.tencent.mm.i.g.sV().getValue("SnsCompressPicLevelFor3G")});
            w.i("MicroMsg.snsMediaStorage", "CompresssnsPicLevel-level:%d isUpload: %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
            if (i > 10) {
            }
            i3 = 50;
            if (obj == null) {
                i2 = i3;
                i = -1;
            } else {
                i = MMNativeJpeg.queryQuality(str2);
                if (i < i3) {
                }
            }
        }
        ki = (int) FileOp.ki(str2);
        i3 = 0;
        i4 = 0;
        if (bhX()) {
            if (!am.isWifi(ab.getContext())) {
                value = com.tencent.mm.i.g.sV().getValue("SnsCompressResolutionForWifi");
                i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                i4 = Integer.valueOf(value.split("\\*")[1]).intValue();
            } else if (am.is2G(ab.getContext())) {
                value = com.tencent.mm.i.g.sV().getValue("SnsCompressResolutionFor3G");
                i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                i4 = Integer.valueOf(value.split("\\*")[1]).intValue();
            } else {
                value = com.tencent.mm.i.g.sV().getValue("SnsCompressResolutionFor2G");
                i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
                i4 = Integer.valueOf(value.split("\\*")[1]).intValue();
            }
        } else if (!am.isWifi(ab.getContext())) {
            value = com.tencent.mm.i.g.sV().getValue("SnsCompressResolution1080PForWifi");
            i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
            i4 = Integer.valueOf(value.split("\\*")[1]).intValue();
        } else if (am.is2G(ab.getContext())) {
            value = com.tencent.mm.i.g.sV().getValue("SnsCompressResolution1080PFor3G");
            i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
            i4 = Integer.valueOf(value.split("\\*")[1]).intValue();
        } else {
            value = com.tencent.mm.i.g.sV().getValue("SnsCompressResolution1080PFor2G");
            i3 = Integer.valueOf(value.split("\\*")[0]).intValue();
            i4 = Integer.valueOf(value.split("\\*")[1]).intValue();
        }
        if (i3 >= i4) {
            i5 = i4;
            i4 = i3;
            i3 = i5;
        }
        if (z) {
            i4 = 2048;
            i3 = 2048;
        }
        w.i("MicroMsg.snsMediaStorage", "server target widht height %d %d screen %d %d comLev: %d is1080p:%s isUpload%s", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(pOu), Integer.valueOf(pPh), Integer.valueOf(i2), Boolean.valueOf(r5), Boolean.valueOf(z)});
        i4 = 960;
        i3 = 640;
        i6 = bg.getInt(com.tencent.mm.i.g.sV().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
        if (i6 <= 0) {
            i6 = 100;
        }
        i7 = i6 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        i6 = bg.getInt(com.tencent.mm.i.g.sV().getValue("PicCompressAvoidanceActiveSizeLong"), m.CTRL_INDEX);
        if (i6 <= 0) {
            i6 = m.CTRL_INDEX;
        }
        i8 = i6 * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        i6 = bg.getInt(com.tencent.mm.i.g.sV().getValue("PicCompressAvoidanceRemainderPerc"), 10);
        if (i6 > 0) {
        }
        i9 = 10;
        i6 = 0;
        if (obj != null) {
            fromFile = Exif.fromFile(str2);
            if (fromFile != null) {
                i6 = fromFile.getOrientationInDegree() % 360;
            }
            i10 = i6;
            w.i("MicroMsg.snsMediaStorage", "option info " + Pe.outWidth + " " + Pe.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i10 + " filelen " + ki + " target " + i4 + " " + i3);
            if (Pe.outWidth < Pe.outHeight * 2) {
            }
            if (ki >= i8) {
            }
            options = new Options();
            com.tencent.mm.sdk.platformtools.d.b(options);
            inputStream = null;
            inputStream = FileOp.openRead(str2);
            if (inputStream.markSupported()) {
            }
            iVar = inputStream;
            iVar.mark(1048576);
            decodeResultLogger = new DecodeResultLogger();
            decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
            iVar.reset();
            if (decodeStream != null) {
                if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                    com.tencent.mm.plugin.report.service.g.oUh.A(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                }
                if (iVar != null) {
                    iVar.close();
                }
                return false;
            }
            com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.sdk.platformtools.d.b(decodeStream, (float) i10), i2, CompressFormat.JPEG, str + str3, true);
            if (z2) {
            }
            if (iVar != null) {
                iVar.close();
            }
            return true;
        }
        i10 = 0;
        w.i("MicroMsg.snsMediaStorage", "option info " + Pe.outWidth + " " + Pe.outHeight + " " + z2 + " origQuality: " + i + " degree:" + i10 + " filelen " + ki + " target " + i4 + " " + i3);
        if (Pe.outWidth < Pe.outHeight * 2) {
        }
        if (ki >= i8) {
        }
        options = new Options();
        com.tencent.mm.sdk.platformtools.d.b(options);
        inputStream = null;
        try {
            inputStream = FileOp.openRead(str2);
            if (inputStream.markSupported()) {
            }
            iVar = inputStream;
            try {
                iVar.mark(1048576);
                decodeResultLogger = new DecodeResultLogger();
                decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, decodeResultLogger, 0, new int[0]);
                iVar.reset();
                if (decodeStream != null) {
                    com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.sdk.platformtools.d.b(decodeStream, (float) i10), i2, CompressFormat.JPEG, str + str3, true);
                    if (z2) {
                    }
                    if (iVar != null) {
                        iVar.close();
                    }
                    return true;
                }
                if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                    com.tencent.mm.plugin.report.service.g.oUh.A(12712, KVStatHelper.getKVStatString(str2, 10, decodeResultLogger));
                }
                if (iVar != null) {
                    iVar.close();
                }
                return false;
            } catch (Throwable e9) {
                th = e9;
                inputStream = iVar;
                th2 = th;
                try {
                    w.printErrStackTrace("MicroMsg.snsMediaStorage", th2, "Decode bitmap failed: " + str2, new Object[0]);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e10) {
                        }
                    }
                    return false;
                } catch (Throwable th3) {
                    th2 = th3;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e11) {
                        }
                    }
                    throw th2;
                }
            } catch (Throwable e92) {
                th = e92;
                inputStream = iVar;
                th2 = th;
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th2;
            }
        } catch (IOException e12) {
            th2 = e12;
            w.printErrStackTrace("MicroMsg.snsMediaStorage", th2, "Decode bitmap failed: " + str2, new Object[0]);
            if (inputStream != null) {
                inputStream.close();
            }
            return false;
        }
    }

    private static boolean a(String str, int i, int i2, CompressFormat compressFormat, int i3, String str2, String str3, boolean z) {
        Options Pe = com.tencent.mm.sdk.platformtools.d.Pe(str);
        if (Pe == null || Pe.outWidth <= 0 || Pe.outHeight <= 0) {
            return false;
        }
        return a(str, Pe.outWidth, Pe.outHeight, i, i2, compressFormat, i3, str2, str3, z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean Gw(java.lang.String r9) {
        /*
        r6 = 1;
        r0 = 0;
        r7 = 0;
        r0 = com.tencent.mm.modelsfs.FileOp.openRead(r9);	 Catch:{ Exception -> 0x004b, all -> 0x0053 }
        r2 = new android.graphics.BitmapFactory$Options;	 Catch:{ Exception -> 0x004b, all -> 0x0065 }
        r2.<init>();	 Catch:{ Exception -> 0x004b, all -> 0x0065 }
        r1 = 1;
        r2.inJustDecodeBounds = r1;	 Catch:{ Exception -> 0x004b, all -> 0x0065 }
        r1 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r5 = new int[r5];	 Catch:{ Exception -> 0x004b, all -> 0x0065 }
        com.tencent.mm.sdk.platformtools.MMBitmapFactory.decodeStream(r0, r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x004b, all -> 0x0065 }
        r1 = r2.outMimeType;	 Catch:{ Exception -> 0x004b, all -> 0x0065 }
        r2 = "MicroMsg.snsMediaStorage";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x004b, all -> 0x0065 }
        r4 = "mineType ";
        r3.<init>(r4);	 Catch:{ Exception -> 0x004b, all -> 0x0065 }
        r3 = r3.append(r1);	 Catch:{ Exception -> 0x004b, all -> 0x0065 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x004b, all -> 0x0065 }
        com.tencent.mm.sdk.platformtools.w.d(r2, r3);	 Catch:{ Exception -> 0x004b, all -> 0x0065 }
        r1 = r1.toLowerCase();	 Catch:{ Exception -> 0x004b, all -> 0x0065 }
        r2 = "webp";
        r1 = r1.indexOf(r2);	 Catch:{ Exception -> 0x004b, all -> 0x0065 }
        if (r1 < 0) goto L_0x0044;
    L_0x003d:
        if (r0 == 0) goto L_0x0042;
    L_0x003f:
        r0.close();	 Catch:{ IOException -> 0x005d }
    L_0x0042:
        r0 = r6;
    L_0x0043:
        return r0;
    L_0x0044:
        if (r0 == 0) goto L_0x0049;
    L_0x0046:
        r0.close();	 Catch:{ IOException -> 0x005f }
    L_0x0049:
        r0 = r7;
        goto L_0x0043;
    L_0x004b:
        r1 = move-exception;
        if (r0 == 0) goto L_0x0051;
    L_0x004e:
        r0.close();	 Catch:{ IOException -> 0x0061 }
    L_0x0051:
        r0 = r7;
        goto L_0x0043;
    L_0x0053:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
    L_0x0057:
        if (r1 == 0) goto L_0x005c;
    L_0x0059:
        r1.close();	 Catch:{ IOException -> 0x0063 }
    L_0x005c:
        throw r0;
    L_0x005d:
        r0 = move-exception;
        goto L_0x0042;
    L_0x005f:
        r0 = move-exception;
        goto L_0x0049;
    L_0x0061:
        r0 = move-exception;
        goto L_0x0051;
    L_0x0063:
        r1 = move-exception;
        goto L_0x005c;
    L_0x0065:
        r1 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x0057;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.r.Gw(java.lang.String):boolean");
    }

    public static boolean a(String str, String str2, String str3, float f) {
        InputStream inputStream;
        int i;
        double d;
        double d2;
        double d3;
        Object obj;
        Object obj2;
        double d4;
        double d5;
        double d6;
        String str4;
        int i2;
        int i3;
        int i4;
        CompressFormat compressFormat;
        Object obj3 = 1;
        InputStream inputStream2 = null;
        try {
            Options options;
            inputStream2 = FileOp.openRead(str + str2);
            try {
                options = new Options();
                options.inJustDecodeBounds = true;
                MMBitmapFactory.decodeStream(inputStream2, null, options, null, 0, new int[0]);
                inputStream2.close();
            } catch (Exception e) {
                inputStream = inputStream2;
                i = 1;
                d = 0.0d;
                d2 = 0.0d;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        d3 = d2;
                        obj = obj2;
                        d4 = 240.0d;
                        d5 = d;
                        d = 240.0d;
                        d6 = d5;
                    } catch (IOException e2) {
                        d3 = d2;
                        obj = obj2;
                        d4 = 240.0d;
                        d5 = d;
                        d = 240.0d;
                        d6 = d5;
                        str4 = str + str2;
                        i2 = (int) d3;
                        i3 = (int) d6;
                        i4 = (int) d4;
                        i = (int) d;
                        if (obj != null) {
                            compressFormat = CompressFormat.PNG;
                        } else {
                            compressFormat = CompressFormat.JPEG;
                        }
                        return a(str4, i2, i3, i4, i, compressFormat, 70, str, str3, false);
                    }
                    str4 = str + str2;
                    i2 = (int) d3;
                    i3 = (int) d6;
                    i4 = (int) d4;
                    i = (int) d;
                    if (obj != null) {
                        compressFormat = CompressFormat.PNG;
                    } else {
                        compressFormat = CompressFormat.JPEG;
                    }
                    return a(str4, i2, i3, i4, i, compressFormat, 70, str, str3, false);
                }
                d3 = d2;
                obj = obj2;
                d4 = 240.0d;
                d5 = d;
                d = 240.0d;
                d6 = d5;
                str4 = str + str2;
                i2 = (int) d3;
                i3 = (int) d6;
                i4 = (int) d4;
                i = (int) d;
                if (obj != null) {
                    compressFormat = CompressFormat.JPEG;
                } else {
                    compressFormat = CompressFormat.PNG;
                }
                return a(str4, i2, i3, i4, i, compressFormat, 70, str, str3, false);
            }
            try {
                d3 = (double) options.outWidth;
                d2 = (double) options.outHeight;
                if (d3 > 120.0d || d2 > 120.0d) {
                    obj3 = null;
                }
                try {
                    double d7;
                    double d8;
                    str4 = options.outMimeType;
                    if (d3 < 0.0d || d2 < 0.0d) {
                        d7 = 240.0d;
                        d8 = 240.0d;
                    } else {
                        d7 = d2;
                        d8 = d3;
                    }
                    double d9 = (double) f;
                    double d10 = (double) ((f / 200.0f) * 44.0f);
                    d6 = (double) ((f / 200.0f) * 160.0f);
                    if (d8 <= 0.0d || d7 <= 0.0d) {
                        d4 = d6;
                        d5 = d6;
                        d6 = d2;
                        obj = obj3;
                        d = d5;
                        str4 = str + str2;
                        i2 = (int) d3;
                        i3 = (int) d6;
                        i4 = (int) d4;
                        i = (int) d;
                        if (obj != null) {
                            compressFormat = CompressFormat.PNG;
                        } else {
                            compressFormat = CompressFormat.JPEG;
                        }
                        return a(str4, i2, i3, i4, i, compressFormat, 70, str, str3, false);
                    }
                    d6 = Math.min(d9 / d8, d9 / d7);
                    d4 = d8 * d6;
                    d6 *= d7;
                    if (d4 < d10) {
                        d7 = (1.0d * d10) / d4;
                        d4 *= d7;
                        d6 *= d7;
                    }
                    if (d6 < d10) {
                        d7 = (1.0d * d10) / d6;
                        d4 *= d7;
                        d6 *= d7;
                    }
                    if (d4 > d9) {
                        d4 = d9;
                    }
                    if (d6 <= d9) {
                        d9 = d6;
                    }
                    d6 = d2;
                    obj = obj3;
                    d = d4;
                    d4 = d9;
                    str4 = str + str2;
                    i2 = (int) d3;
                    i3 = (int) d6;
                    i4 = (int) d4;
                    i = (int) d;
                    if (obj != null) {
                        compressFormat = CompressFormat.JPEG;
                    } else {
                        compressFormat = CompressFormat.PNG;
                    }
                    return a(str4, i2, i3, i4, i, compressFormat, 70, str, str3, false);
                } catch (Exception e3) {
                    inputStream = null;
                    obj2 = obj3;
                    d = d2;
                    d2 = d3;
                    if (inputStream != null) {
                        inputStream.close();
                        d3 = d2;
                        obj = obj2;
                        d4 = 240.0d;
                        d5 = d;
                        d = 240.0d;
                        d6 = d5;
                        str4 = str + str2;
                        i2 = (int) d3;
                        i3 = (int) d6;
                        i4 = (int) d4;
                        i = (int) d;
                        if (obj != null) {
                            compressFormat = CompressFormat.PNG;
                        } else {
                            compressFormat = CompressFormat.JPEG;
                        }
                        return a(str4, i2, i3, i4, i, compressFormat, 70, str, str3, false);
                    }
                    d3 = d2;
                    obj = obj2;
                    d4 = 240.0d;
                    d5 = d;
                    d = 240.0d;
                    d6 = d5;
                    str4 = str + str2;
                    i2 = (int) d3;
                    i3 = (int) d6;
                    i4 = (int) d4;
                    i = (int) d;
                    if (obj != null) {
                        compressFormat = CompressFormat.JPEG;
                    } else {
                        compressFormat = CompressFormat.PNG;
                    }
                    return a(str4, i2, i3, i4, i, compressFormat, 70, str, str3, false);
                }
            } catch (Exception e4) {
                inputStream = null;
                i = 1;
                d = 0.0d;
                d2 = 0.0d;
                if (inputStream != null) {
                    inputStream.close();
                    d3 = d2;
                    obj = obj2;
                    d4 = 240.0d;
                    d5 = d;
                    d = 240.0d;
                    d6 = d5;
                    str4 = str + str2;
                    i2 = (int) d3;
                    i3 = (int) d6;
                    i4 = (int) d4;
                    i = (int) d;
                    if (obj != null) {
                        compressFormat = CompressFormat.JPEG;
                    } else {
                        compressFormat = CompressFormat.PNG;
                    }
                    return a(str4, i2, i3, i4, i, compressFormat, 70, str, str3, false);
                }
                d3 = d2;
                obj = obj2;
                d4 = 240.0d;
                d5 = d;
                d = 240.0d;
                d6 = d5;
                str4 = str + str2;
                i2 = (int) d3;
                i3 = (int) d6;
                i4 = (int) d4;
                i = (int) d;
                if (obj != null) {
                    compressFormat = CompressFormat.PNG;
                } else {
                    compressFormat = CompressFormat.JPEG;
                }
                return a(str4, i2, i3, i4, i, compressFormat, 70, str, str3, false);
            }
        } catch (Exception e5) {
            inputStream = inputStream2;
            obj2 = 1;
            d = 0.0d;
            d2 = 0.0d;
            if (inputStream != null) {
                inputStream.close();
                d3 = d2;
                obj = obj2;
                d4 = 240.0d;
                d5 = d;
                d = 240.0d;
                d6 = d5;
                str4 = str + str2;
                i2 = (int) d3;
                i3 = (int) d6;
                i4 = (int) d4;
                i = (int) d;
                if (obj != null) {
                    compressFormat = CompressFormat.PNG;
                } else {
                    compressFormat = CompressFormat.JPEG;
                }
                return a(str4, i2, i3, i4, i, compressFormat, 70, str, str3, false);
            }
            d3 = d2;
            obj = obj2;
            d4 = 240.0d;
            d5 = d;
            d = 240.0d;
            d6 = d5;
            str4 = str + str2;
            i2 = (int) d3;
            i3 = (int) d6;
            i4 = (int) d4;
            i = (int) d;
            if (obj != null) {
                compressFormat = CompressFormat.JPEG;
            } else {
                compressFormat = CompressFormat.PNG;
            }
            return a(str4, i2, i3, i4, i, compressFormat, 70, str, str3, false);
        }
    }

    private static boolean a(String str, int i, int i2, int i3, int i4, CompressFormat compressFormat, int i5, String str2, String str3, boolean z) {
        OutputStream outputStream = null;
        try {
            Bitmap b;
            w.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, srcWidth: %s, srcHeight: %s, width: %s, height: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3)});
            Options options = new Options();
            DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
            double d = (((double) i2) * 1.0d) / ((double) i3);
            double d2 = (((double) i) * 1.0d) / ((double) i4);
            if (i == i4 && i2 == i3) {
                b = com.tencent.mm.plugin.sns.d.a.b(str, options, decodeResultLogger);
            } else {
                options.inSampleSize = 1;
                if (i2 > i3 || i > i4) {
                    options.inSampleSize = (int) (d < d2 ? d2 : d);
                    if (options.inSampleSize <= 1) {
                        options.inSampleSize = 1;
                    }
                }
                while (((i2 * i) / options.inSampleSize) / options.inSampleSize > 2764800) {
                    options.inSampleSize++;
                }
                w.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, sampleSize: %s", new Object[]{Integer.valueOf(options.inSampleSize)});
                b = com.tencent.mm.plugin.sns.d.a.b(str, options, decodeResultLogger);
            }
            w.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, result bm: %s", new Object[]{b});
            if (b == null) {
                if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                    com.tencent.mm.plugin.report.service.g.oUh.A(12712, KVStatHelper.getKVStatString(str, 10, decodeResultLogger));
                }
                return false;
            }
            w.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, bm.width: %s, bm.height: %s", new Object[]{Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight())});
            if (z) {
                int ceil;
                int i6;
                if (d < d2) {
                    ceil = (int) Math.ceil(((((double) i4) * 1.0d) * ((double) i2)) / ((double) i));
                    i6 = i4;
                } else {
                    i6 = (int) Math.ceil(((((double) i3) * 1.0d) * ((double) i)) / ((double) i2));
                    ceil = i3;
                }
                int Pc = ExifHelper.Pc(str);
                if (Pc == 90 || Pc == 270) {
                    int i7 = ceil;
                    ceil = i6;
                    i6 = i7;
                }
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(b, i6, ceil, true);
                if (createScaledBitmap != null) {
                    if (b != createScaledBitmap) {
                        l.wu().f(b);
                    }
                    b = createScaledBitmap;
                }
                w.i("MicroMsg.snsMediaStorage", "createThumbNailUnScalebyUpload, bm.width: %s, bm.height: %s", new Object[]{Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight())});
            }
            outputStream = FileOp.gQ(str2 + str3);
            com.tencent.mm.sdk.platformtools.d.a(b, i5, compressFormat, outputStream, false);
            l.wu().f(b);
            outputStream.close();
            return true;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.snsMediaStorage", e, "create thumbnail from orig failed: %s", new Object[]{str3});
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e2) {
                }
            }
            return false;
        }
    }

    public static boolean b(String str, String str2, String str3, float f) {
        try {
            FileOp.deleteFile(str + str3);
            DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
            Options Pe = com.tencent.mm.sdk.platformtools.d.Pe(str + str2);
            if (Pe == null) {
                w.e("MicroMsg.snsMediaStorage", "createUserAlbum, getImageOptions error");
                return false;
            }
            Bitmap b;
            if (Pe.outMimeType == null || !(Pe.outMimeType.toLowerCase().endsWith("png") || Pe.outMimeType.toLowerCase().endsWith("vcodec"))) {
                int i = Pe.outWidth;
                int i2 = Pe.outHeight;
                int i3 = (int) f;
                int i4 = (int) f;
                Pe.inJustDecodeBounds = false;
                w.i("MicroMsg.snsMediaStorage", "createUserAlbum, srcWidth: %s, srcHeight: %s, dstWidth: %s, dstHeight: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
                if (i == i3 && i2 == i4) {
                    b = com.tencent.mm.plugin.sns.d.a.b(str + str2, Pe, decodeResultLogger);
                } else {
                    int i5;
                    int ceil;
                    if ((((double) i2) * 1.0d) / ((double) i4) > (((double) i) * 1.0d) / ((double) i3)) {
                        i5 = i3;
                        ceil = (int) Math.ceil(((((double) i3) * 1.0d) * ((double) i2)) / ((double) i));
                    } else {
                        i5 = (int) Math.ceil(((((double) i4) * 1.0d) * ((double) i)) / ((double) i2));
                        ceil = i4;
                    }
                    w.d("MicroMsg.snsMediaStorage", "createUserAlbum, newWidth: %s, newHeight: %s", new Object[]{Integer.valueOf(i5), Integer.valueOf(ceil)});
                    Pe.inSampleSize = 1;
                    if (i2 > ceil || i > i5) {
                        Pe.inSampleSize = 1;
                        if (i2 > ceil || i > i5) {
                            double d = (((double) i2) * 1.0d) / ((double) ceil);
                            double d2 = (((double) i) * 1.0d) / ((double) i5);
                            if (d >= d2) {
                                d2 = d;
                            }
                            Pe.inSampleSize = (int) d2;
                            if (Pe.inSampleSize <= 1) {
                                Pe.inSampleSize = 1;
                            }
                        }
                        while (((i2 * i) / Pe.inSampleSize) / Pe.inSampleSize > 2764800) {
                            Pe.inSampleSize++;
                        }
                    }
                    w.i("MicroMsg.snsMediaStorage", "createUserAlbum, inSampleSize: %s", new Object[]{Integer.valueOf(Pe.inSampleSize)});
                    Bitmap b2;
                    if (((float) i2) / ((float) i) == ((float) i4) / ((float) i3)) {
                        b2 = com.tencent.mm.plugin.sns.d.a.b(str + str2, Pe, decodeResultLogger);
                        w.i("MicroMsg.snsMediaStorage", "createUserAlbum, directly use inSampleSize");
                        b = b2;
                    } else {
                        float max = Math.max(((float) i5) / ((float) i), ((float) ceil) / ((float) i2));
                        int i6 = (int) (((float) i4) / max);
                        int min = Math.min(i, (int) (((float) i3) / max));
                        i6 = Math.min(i2, i6);
                        i5 = (i2 - i6) >> 1;
                        i3 = Math.max(0, (i - min) >> 1);
                        i5 = Math.max(0, i5);
                        Rect rect = new Rect();
                        rect.left = i3;
                        rect.right = i3 + min;
                        rect.top = i5;
                        rect.bottom = i5 + i6;
                        String str4 = str + str2;
                        long currentTimeMillis = System.currentTimeMillis();
                        b2 = l.wu().a(str4, rect, Pe, decodeResultLogger);
                        if (b2 != null) {
                            b2 = com.tencent.mm.plugin.sns.data.i.r(str4, b2);
                        }
                        w.d("MicroMsg.SnsBitmapUtil", "regionDecodeWithRotateByExif used %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        w.i("MicroMsg.snsMediaStorage", "createUserAlbum, dstWidth: %s, dstHeight: %s, startX: %s, startY: %s, scaleFactor: %s", new Object[]{Integer.valueOf(min), Integer.valueOf(i6), Integer.valueOf(i3), Integer.valueOf(i5), Float.valueOf(max)});
                        b = b2;
                    }
                }
            } else {
                b = com.tencent.mm.sdk.platformtools.d.a(str + str2, (int) f, (int) f, true, decodeResultLogger, 0);
            }
            if (b == null) {
                w.i("MicroMsg.snsMediaStorage", "bitmap error " + str + str2);
                if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                    com.tencent.mm.plugin.report.service.g.oUh.A(12712, KVStatHelper.getKVStatString(str + str2, 10, decodeResultLogger));
                }
                FileOp.deleteFile(str + str2);
                return false;
            }
            w.i("MicroMsg.snsMediaStorage", "createUserAlbum, bm.width: %s, bm.height: %s", new Object[]{Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight())});
            Object obj = 1;
            if (b.getHeight() > 120 || b.getWidth() > 120) {
                obj = null;
            }
            com.tencent.mm.sdk.platformtools.d.a(b, 100, obj != null ? CompressFormat.PNG : CompressFormat.JPEG, str + str3, false);
            l.wu().f(b);
            return true;
        } catch (Throwable e) {
            w.e("MicroMsg.snsMediaStorage", "createUserAlbum error: %s", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.snsMediaStorage", e, "", new Object[0]);
        }
    }

    public static Bitmap Gx(String str) {
        int i = 640;
        Options Pe = com.tencent.mm.sdk.platformtools.d.Pe(str);
        int i2 = Pe.outWidth >= Pe.outHeight ? 960 : 640;
        if (Pe.outWidth < Pe.outHeight) {
            i = 960;
        }
        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
        Bitmap a = com.tencent.mm.sdk.platformtools.d.a(str, i, i2, false, decodeResultLogger, 0);
        if (a == null) {
            if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                com.tencent.mm.plugin.report.service.g.oUh.A(12712, KVStatHelper.getKVStatString(str, 10, decodeResultLogger));
            }
            return null;
        }
        try {
            Exif exif = new Exif();
            exif.parseFromFile(str);
            return com.tencent.mm.sdk.platformtools.d.b(a, (float) exif.getOrientationInDegree());
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.snsMediaStorage", e, "parse exif failed: " + str, new Object[0]);
            return a;
        }
    }
}
