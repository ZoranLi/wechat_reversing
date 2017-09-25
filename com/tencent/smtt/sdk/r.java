package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.g;
import com.tencent.smtt.utils.j;
import com.tencent.smtt.utils.p;
import com.tencent.smtt.utils.q;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONArray;

class r {
    private static r wVu;
    Context mContext;
    private Handler wVv = null;
    boolean wVw = false;

    public enum a {
        TYPE_DOWNLOAD(0),
        TYPE_INSTALL(1),
        TYPE_LOAD(2),
        TYPE_DOWNLOAD_DECOUPLE(3),
        TYPE_INSTALL_DECOUPLE(4),
        TYPE_COOKIE_DB_SWITCH(5);
        
        int value;

        private a(int i) {
            this.value = i;
        }
    }

    public static class b implements Cloneable {
        int jUO;
        public long wVF;
        public String wVG;
        public String wVH;
        public int wVI;
        public int wVJ;
        public int wVK;
        public int wVL;
        public String wVM;
        public int wVN;
        public int wVO;
        public long wVP;
        public long wVQ;
        public int wVR;
        public String wVS;
        public String wVT;
        public long wVU;

        public b() {
            cdW();
        }

        public final void Vv(String str) {
            setErrorCode(108);
            this.wVS = str;
        }

        public final void Vw(String str) {
            if (str != null) {
                if (str.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                    str = str.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                }
                this.wVT = str;
            }
        }

        public final void cdW() {
            this.wVF = 0;
            this.wVG = null;
            this.wVH = null;
            this.wVI = 0;
            this.wVJ = 0;
            this.wVK = 0;
            this.wVL = 2;
            this.wVM = "unknown";
            this.wVN = 0;
            this.wVO = 2;
            this.wVP = 0;
            this.wVQ = 0;
            this.wVR = 1;
            this.jUO = 0;
            this.wVS = null;
            this.wVT = null;
            this.wVU = 0;
        }

        protected final Object clone() {
            Object clone;
            try {
                clone = super.clone();
            } catch (CloneNotSupportedException e) {
            }
            return clone;
        }

        public final void k(Throwable th) {
            if (th == null) {
                this.wVT = "";
                return;
            }
            String stackTraceString = Log.getStackTraceString(th);
            if (stackTraceString.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                stackTraceString = stackTraceString.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            }
            this.wVT = stackTraceString;
        }

        public final void setErrorCode(int i) {
            if (!(i == 100 || i == MMGIFException.D_GIF_ERR_CLOSE_FAILED || i == 120 || i == 111 || i >= 400)) {
                TbsLog.i("TbsDownload", "error occured, errorCode:" + i, true);
            }
            if (i == 111) {
                TbsLog.i("TbsDownload", "you are not in wifi, downloading stoped", true);
            }
            this.jUO = i;
        }
    }

    private static class c {
        private final String wVV;
        private final String wVW;

        public c(String str, String str2) {
            this.wVV = str;
            this.wVW = str2;
        }

        public final void ceJ() {
            FileOutputStream fileOutputStream;
            FileInputStream fileInputStream;
            BufferedInputStream bufferedInputStream;
            RandomAccessFile randomAccessFile;
            int parseInt;
            int read;
            Throwable th;
            BufferedInputStream bufferedInputStream2;
            Throwable th2;
            ZipOutputStream zipOutputStream;
            FileOutputStream fileOutputStream2;
            RandomAccessFile randomAccessFile2 = null;
            ZipOutputStream zipOutputStream2;
            try {
                fileOutputStream = new FileOutputStream(this.wVW);
                try {
                    zipOutputStream2 = new ZipOutputStream(new BufferedOutputStream(fileOutputStream));
                    try {
                        byte[] bArr = new byte[2048];
                        String str = this.wVV;
                        try {
                            fileInputStream = new FileInputStream(str);
                            try {
                                bufferedInputStream = new BufferedInputStream(fileInputStream, 2048);
                            } catch (Exception e) {
                                bufferedInputStream = null;
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e2) {
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e3) {
                                    }
                                }
                                randomAccessFile = new RandomAccessFile(new File(this.wVW), "rw");
                                parseInt = Integer.parseInt("00001000", 2);
                                randomAccessFile.seek(7);
                                read = randomAccessFile.read();
                                if ((read & parseInt) > 0) {
                                    randomAccessFile.seek(7);
                                    randomAccessFile.write(((parseInt ^ -1) & 255) & read);
                                }
                                try {
                                    randomAccessFile.close();
                                } catch (IOException e4) {
                                }
                                zipOutputStream2.close();
                                fileOutputStream.close();
                            } catch (Throwable th3) {
                                th = th3;
                                if (bufferedInputStream2 != null) {
                                    try {
                                        bufferedInputStream2.close();
                                    } catch (IOException e5) {
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e6) {
                                    }
                                }
                                throw th;
                            }
                            try {
                                zipOutputStream2.putNextEntry(new ZipEntry(str.substring(str.lastIndexOf("/") + 1)));
                                while (true) {
                                    int read2 = bufferedInputStream.read(bArr, 0, 2048);
                                    if (read2 == -1) {
                                        break;
                                    }
                                    zipOutputStream2.write(bArr, 0, read2);
                                }
                                zipOutputStream2.flush();
                                zipOutputStream2.closeEntry();
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e7) {
                                }
                                try {
                                    fileInputStream.close();
                                } catch (IOException e8) {
                                }
                            } catch (Exception e9) {
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                randomAccessFile = new RandomAccessFile(new File(this.wVW), "rw");
                                parseInt = Integer.parseInt("00001000", 2);
                                randomAccessFile.seek(7);
                                read = randomAccessFile.read();
                                if ((read & parseInt) > 0) {
                                    randomAccessFile.seek(7);
                                    randomAccessFile.write(((parseInt ^ -1) & 255) & read);
                                }
                                randomAccessFile.close();
                                zipOutputStream2.close();
                                fileOutputStream.close();
                            } catch (Throwable th4) {
                                th2 = th4;
                                bufferedInputStream2 = bufferedInputStream;
                                th = th2;
                                if (bufferedInputStream2 != null) {
                                    bufferedInputStream2.close();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                throw th;
                            }
                        } catch (Exception e10) {
                            bufferedInputStream = null;
                            fileInputStream = null;
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            randomAccessFile = new RandomAccessFile(new File(this.wVW), "rw");
                            parseInt = Integer.parseInt("00001000", 2);
                            randomAccessFile.seek(7);
                            read = randomAccessFile.read();
                            if ((read & parseInt) > 0) {
                                randomAccessFile.seek(7);
                                randomAccessFile.write(((parseInt ^ -1) & 255) & read);
                            }
                            randomAccessFile.close();
                            zipOutputStream2.close();
                            fileOutputStream.close();
                        } catch (Throwable th5) {
                            th = th5;
                            fileInputStream = null;
                            if (bufferedInputStream2 != null) {
                                bufferedInputStream2.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                        try {
                            randomAccessFile = new RandomAccessFile(new File(this.wVW), "rw");
                            try {
                                parseInt = Integer.parseInt("00001000", 2);
                                randomAccessFile.seek(7);
                                read = randomAccessFile.read();
                                if ((read & parseInt) > 0) {
                                    randomAccessFile.seek(7);
                                    randomAccessFile.write(((parseInt ^ -1) & 255) & read);
                                }
                                randomAccessFile.close();
                            } catch (Exception e11) {
                                randomAccessFile2 = randomAccessFile;
                                if (randomAccessFile2 != null) {
                                    try {
                                        randomAccessFile2.close();
                                    } catch (IOException e12) {
                                    }
                                }
                                zipOutputStream2.close();
                                fileOutputStream.close();
                            } catch (Throwable th42) {
                                th2 = th42;
                                randomAccessFile2 = randomAccessFile;
                                th = th2;
                                if (randomAccessFile2 != null) {
                                    try {
                                        randomAccessFile2.close();
                                    } catch (IOException e13) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e14) {
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.close();
                            }
                            zipOutputStream2.close();
                            fileOutputStream.close();
                        } catch (Throwable th6) {
                            th = th6;
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.close();
                            }
                            throw th;
                        }
                        try {
                            zipOutputStream2.close();
                        } catch (IOException e15) {
                        }
                        try {
                            fileOutputStream.close();
                        } catch (IOException e16) {
                        }
                    } catch (Exception e17) {
                        zipOutputStream = zipOutputStream2;
                        fileOutputStream2 = fileOutputStream;
                    } catch (Throwable th7) {
                        th = th7;
                        if (zipOutputStream2 != null) {
                            try {
                                zipOutputStream2.close();
                            } catch (IOException e18) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e19) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e20) {
                    fileOutputStream2 = fileOutputStream;
                    if (zipOutputStream != null) {
                        try {
                            zipOutputStream.close();
                        } catch (IOException e21) {
                        }
                    }
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e22) {
                        }
                    }
                } catch (Throwable th8) {
                    th = th8;
                    zipOutputStream2 = null;
                    if (zipOutputStream2 != null) {
                        zipOutputStream2.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e23) {
                fileOutputStream2 = null;
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable th9) {
                th = th9;
                zipOutputStream2 = null;
                fileOutputStream = null;
                if (zipOutputStream2 != null) {
                    zipOutputStream2.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        }
    }

    private r(Context context) {
        this.mContext = context.getApplicationContext();
        HandlerThread handlerThread = new HandlerThread("TbsLogReportThread");
        handlerThread.start();
        this.wVv = new Handler(this, handlerThread.getLooper()) {
            final /* synthetic */ r wVx;

            public final void handleMessage(Message message) {
                if (message.what == 600) {
                    if (message.obj instanceof b) {
                        String str;
                        b bVar = (b) message.obj;
                        int i = message.arg1;
                        r rVar = this.wVx;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(r.Dd(i));
                        stringBuilder.append(r.Vu(com.tencent.smtt.utils.c.V(rVar.mContext)));
                        stringBuilder.append(r.Vu(p.gW(rVar.mContext)));
                        stringBuilder.append(r.Dd(p.ceA().ge(rVar.mContext)));
                        String str2 = Build.MODEL;
                        try {
                            str = new String(str2.getBytes("UTF-8"), "ISO8859-1");
                        } catch (Exception e) {
                            str = str2;
                        }
                        stringBuilder.append(r.Vu(str));
                        str = rVar.mContext.getPackageName();
                        stringBuilder.append(r.Vu(str));
                        if ("com.tencent.mm".equals(str)) {
                            stringBuilder.append(r.Vu(com.tencent.smtt.utils.c.bD(rVar.mContext, "com.tencent.mm.BuildInfo.CLIENT_VERSION")));
                        } else {
                            stringBuilder.append(r.Dd(com.tencent.smtt.utils.c.getAppVersionCode(rVar.mContext)));
                        }
                        stringBuilder.append(r.Vu(r.aq(bVar.wVF)));
                        stringBuilder.append(r.Vu(bVar.wVG));
                        stringBuilder.append(r.Vu(bVar.wVH));
                        stringBuilder.append(r.Dd(bVar.wVI));
                        stringBuilder.append(r.Dd(bVar.wVJ));
                        stringBuilder.append(r.Dd(bVar.wVK));
                        stringBuilder.append(r.Dd(bVar.wVL));
                        stringBuilder.append(r.Vu(bVar.wVM));
                        stringBuilder.append(r.Dd(bVar.wVN));
                        stringBuilder.append(r.Dd(bVar.wVO));
                        stringBuilder.append(r.fa(bVar.wVU));
                        stringBuilder.append(r.fa(bVar.wVP));
                        stringBuilder.append(r.fa(bVar.wVQ));
                        stringBuilder.append(r.Dd(bVar.wVR));
                        stringBuilder.append(r.Dd(bVar.jUO));
                        stringBuilder.append(r.Vu(bVar.wVS));
                        stringBuilder.append(r.Vu(bVar.wVT));
                        stringBuilder.append(r.Dd(k.fM(rVar.mContext).wUG.getInt("tbs_download_version", 0)));
                        stringBuilder.append(r.Vu(com.tencent.smtt.utils.c.gR(rVar.mContext)));
                        stringBuilder.append(r.Vu("3.5.0.1016_43501"));
                        stringBuilder.append(false);
                        SharedPreferences ceI = rVar.ceI();
                        JSONArray ceF = rVar.ceF();
                        JSONArray jSONArray = new JSONArray();
                        if (jSONArray.length() >= 5) {
                            for (int i2 = 4; i2 > 0; i2--) {
                                try {
                                    jSONArray.put(ceF.get(jSONArray.length() - i2));
                                } catch (Exception e2) {
                                    TbsLog.e("upload", "JSONArray transform error!");
                                }
                            }
                        } else {
                            jSONArray = ceF;
                        }
                        jSONArray.put(stringBuilder.toString());
                        Editor edit = ceI.edit();
                        edit.putString("tbs_download_upload", jSONArray.toString());
                        edit.commit();
                        if (rVar.wVw || i != a.TYPE_LOAD.value) {
                            rVar.ceH();
                        }
                    }
                } else if (message.what == 601) {
                    this.wVx.ceH();
                }
            }
        };
    }

    static String Dd(int i) {
        return i + "|";
    }

    static String Vu(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        if (str == null) {
            str = "";
        }
        return stringBuilder.append(str).append("|").toString();
    }

    private void a(int i, b bVar, a aVar) {
        bVar.setErrorCode(i);
        bVar.wVF = System.currentTimeMillis();
        QbSdk.wTz.iv(i);
        a(aVar, bVar);
    }

    static String aq(long j) {
        String str = null;
        try {
            str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j));
        } catch (Exception e) {
        }
        return str;
    }

    public static b ceD() {
        return new b();
    }

    static String fa(long j) {
        return j + "|";
    }

    public static r gr(Context context) {
        if (wVu == null) {
            synchronized (r.class) {
                if (wVu == null) {
                    wVu = new r(context);
                }
            }
        }
        return wVu;
    }

    public final void a(int i, String str, a aVar) {
        if (!(i == m.CTRL_INDEX || i == 220 || i == 221)) {
            TbsLog.i("TbsDownload", "error occured in installation, errorCode:" + i, true);
        }
        b bVar = new b();
        bVar.Vw(str);
        a(i, bVar, aVar);
    }

    public final void a(a aVar, b bVar) {
        try {
            b bVar2 = (b) bVar.clone();
            Message obtainMessage = this.wVv.obtainMessage();
            obtainMessage.what = 600;
            obtainMessage.arg1 = aVar.value;
            obtainMessage.obj = bVar2;
            this.wVv.sendMessage(obtainMessage);
        } catch (Throwable th) {
            TbsLog.w("upload", "[TbsLogReport.eventReport] error, message=" + th.getMessage());
        }
    }

    public final void aM(int i, String str) {
        a(i, str, a.TYPE_INSTALL);
    }

    public final void aN(int i, String str) {
        b bVar = new b();
        bVar.setErrorCode(i);
        bVar.wVF = System.currentTimeMillis();
        bVar.Vw(str);
        a(a.TYPE_LOAD, bVar);
    }

    public final void c(int i, Throwable th) {
        b bVar = new b();
        bVar.k(th);
        a(i, bVar, a.TYPE_INSTALL);
    }

    public final void ceE() {
        this.wVv.sendEmptyMessage(601);
    }

    final JSONArray ceF() {
        String string = ceI().getString("tbs_download_upload", null);
        if (string == null) {
            return new JSONArray();
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() <= 5) {
                return jSONArray;
            }
            JSONArray jSONArray2 = new JSONArray();
            int length = jSONArray.length() - 1;
            if (length <= jSONArray.length() - 5) {
                return jSONArray;
            }
            jSONArray2.put(jSONArray.get(length));
            return jSONArray2;
        } catch (Exception e) {
            return new JSONArray();
        }
    }

    public final void ceG() {
        File file;
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        File file2;
        FileInputStream fileInputStream2;
        com.tencent.smtt.utils.g.a anonymousClass2;
        HttpURLConnection p;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (com.tencent.smtt.utils.b.gN(this.mContext) == 3) {
            String tbsLogFilePath = TbsLog.getTbsLogFilePath();
            if (tbsLogFilePath != null) {
                j.cfn();
                String cfo = j.cfo();
                String V = com.tencent.smtt.utils.c.V(this.mContext);
                String gR = com.tencent.smtt.utils.c.gR(this.mContext);
                byte[] bytes = V.getBytes();
                byte[] bytes2 = gR.getBytes();
                try {
                    bytes = j.cfn().bA(bytes);
                    bytes2 = j.cfn().bA(bytes2);
                } catch (Exception e) {
                }
                String bytesToHex = j.bytesToHex(bytes);
                String str = q.gZ(this.mContext).wYz + bytesToHex + "&aid=" + j.bytesToHex(bytes2);
                Map hashMap = new HashMap();
                hashMap.put("Content-Type", "application/octet-stream");
                hashMap.put("Charset", "UTF-8");
                hashMap.put("QUA2", p.gW(this.mContext));
                try {
                    File file3 = new File(f.wXQ);
                    new c(tbsLogFilePath, f.wXQ + "/tbslog_temp.zip").ceJ();
                    file = new File(f.wXQ, "tbslog_temp.zip");
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (Exception e2) {
                        byteArrayOutputStream = null;
                        file2 = file;
                        fileInputStream2 = null;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception e3) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        if (file2 != null) {
                            file2.delete();
                            bytes2 = null;
                        } else {
                            bytes2 = null;
                        }
                        bytesToHex = str + "&ek=" + cfo;
                        anonymousClass2 = new com.tencent.smtt.utils.g.a(this) {
                            final /* synthetic */ r wVx;

                            {
                                this.wVx = r1;
                            }

                            public final void Dc(int i) {
                                TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportTbsLog] httpResponseCode=" + i);
                            }
                        };
                        if (bytes2 == null) {
                            p = g.p(bytesToHex, hashMap);
                            if (p == null) {
                                g.a(p, bytes2);
                                g.a(p, anonymousClass2, false);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = null;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e5) {
                            }
                        }
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (Exception e6) {
                            }
                        }
                        if (file != null) {
                            file.delete();
                        }
                        throw th;
                    }
                    try {
                        bytes2 = new byte[8192];
                        ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                        while (true) {
                            try {
                                int read = fileInputStream.read(bytes2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream3.write(bytes2, 0, read);
                            } catch (Exception e7) {
                                byteArrayOutputStream = byteArrayOutputStream3;
                                file2 = file;
                                fileInputStream2 = fileInputStream;
                            } catch (Throwable th3) {
                                th = th3;
                                byteArrayOutputStream2 = byteArrayOutputStream3;
                            }
                        }
                        byteArrayOutputStream3.flush();
                        bytes2 = j.cfn().bA(byteArrayOutputStream3.toByteArray());
                        try {
                            fileInputStream.close();
                        } catch (Exception e8) {
                        }
                        try {
                            byteArrayOutputStream3.close();
                        } catch (Exception e9) {
                        }
                        file.delete();
                    } catch (Exception e10) {
                        byteArrayOutputStream = null;
                        file2 = file;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        if (file2 != null) {
                            bytes2 = null;
                        } else {
                            file2.delete();
                            bytes2 = null;
                        }
                        bytesToHex = str + "&ek=" + cfo;
                        anonymousClass2 = /* anonymous class already generated */;
                        if (bytes2 == null) {
                            p = g.p(bytesToHex, hashMap);
                            if (p == null) {
                                g.a(p, bytes2);
                                g.a(p, anonymousClass2, false);
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.close();
                        }
                        if (file != null) {
                            file.delete();
                        }
                        throw th;
                    }
                } catch (Exception e11) {
                    byteArrayOutputStream = null;
                    file2 = null;
                    fileInputStream2 = null;
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (file2 != null) {
                        file2.delete();
                        bytes2 = null;
                    } else {
                        bytes2 = null;
                    }
                    bytesToHex = str + "&ek=" + cfo;
                    anonymousClass2 = /* anonymous class already generated */;
                    if (bytes2 == null) {
                        p = g.p(bytesToHex, hashMap);
                        if (p == null) {
                            g.a(p, bytes2);
                            g.a(p, anonymousClass2, false);
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    file = null;
                    fileInputStream = null;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (byteArrayOutputStream2 != null) {
                        byteArrayOutputStream2.close();
                    }
                    if (file != null) {
                        file.delete();
                    }
                    throw th;
                }
                bytesToHex = str + "&ek=" + cfo;
                anonymousClass2 = /* anonymous class already generated */;
                if (bytes2 == null) {
                    p = g.p(bytesToHex, hashMap);
                    if (p == null) {
                        g.a(p, bytes2);
                        g.a(p, anonymousClass2, false);
                    }
                }
            }
        }
    }

    public final void ceH() {
        TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat]");
        JSONArray ceF = ceF();
        if (ceF.length() == 0) {
            TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] no data");
            return;
        }
        TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] jsonArray:" + ceF);
        try {
            TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] response:" + g.a(q.gZ(this.mContext).wYx, ceF.toString().getBytes(ProtocolPackage.ServerEncoding), new com.tencent.smtt.utils.g.a(this) {
                final /* synthetic */ r wVx;

                {
                    this.wVx = r1;
                }

                public final void Dc(int i) {
                    TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] onHttpResponseCode:" + i);
                    if (i < e.CTRL_INDEX) {
                        Editor edit = this.wVx.ceI().edit();
                        edit.remove("tbs_download_upload");
                        edit.commit();
                    }
                }
            }, true) + " testcase: -1");
        } catch (Throwable th) {
        }
    }

    final SharedPreferences ceI() {
        return this.mContext.getSharedPreferences("tbs_download_stat", 4);
    }
}
