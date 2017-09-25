package com.tencent.mm.plugin.music.a.b;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.network.t;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.plugin.music.a.h;
import com.tencent.mm.plugin.music.a.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class a implements Runnable {
    public com.tencent.mm.am.a fPd;
    public boolean isStop = true;
    public boolean lFS;
    public float nTH;
    private long nTI = 307200;
    public b nTJ;

    private class a implements Runnable {
        int action;
        final /* synthetic */ a nTK;

        public final void run() {
            if (this.nTK.nTJ != null) {
                this.nTK.nTJ.pZ(this.action);
            }
        }

        a(a aVar, int i) {
            this.nTK = aVar;
            this.action = i;
        }
    }

    public interface b {
        void pZ(int i);
    }

    public a(com.tencent.mm.am.a aVar) {
        this.fPd = aVar;
        this.lFS = am.isWifi(ab.getContext());
    }

    public final void start() {
        if (this.isStop) {
            this.isStop = false;
            e.post(this, "music_download_thread");
        }
    }

    public final void run() {
        long j;
        long j2;
        Throwable e;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        InputStream inputStream;
        t tVar;
        if (!this.isStop) {
            if (am.isNetworkConnected(ab.getContext())) {
                long j3;
                long j4;
                long j5;
                boolean z;
                String str;
                Object obj;
                PBool pBool;
                String str2;
                String a;
                if (this.lFS) {
                    Object obj2;
                    pBool = new PBool();
                    if (bg.mA(this.fPd.field_songWifiUrl)) {
                        str2 = this.fPd.field_songWebUrl;
                    } else {
                        str2 = this.fPd.field_songWifiUrl;
                    }
                    a = h.a(str2, this.fPd.field_songWapLinkUrl, true, pBool);
                    boolean z2 = pBool.value;
                    j3 = this.fPd.field_wifiDownloadedLength;
                    j = this.fPd.field_songWifiFileLength;
                    if (j != 0) {
                        this.nTI = j / 4;
                    }
                    if (j3 < this.nTI) {
                        j4 = this.nTI;
                    } else {
                        j4 = (long) (((float) j3) + (0.15f * ((float) this.fPd.field_songWifiFileLength)));
                    }
                    if (this.fPd.field_wifiEndFlag == 1) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    j5 = j;
                    j = j3;
                    z = z2;
                    str = a;
                    obj = obj2;
                    j2 = j5;
                } else {
                    pBool = new PBool();
                    if (bg.mA(this.fPd.field_songWifiUrl)) {
                        str2 = this.fPd.field_songWebUrl;
                    } else {
                        str2 = this.fPd.field_songWifiUrl;
                    }
                    a = h.a(str2, this.fPd.field_songWapLinkUrl, false, pBool);
                    j3 = this.fPd.field_downloadedLength;
                    j = this.fPd.field_songFileLength;
                    if (j != 0) {
                        this.nTI = j / 4;
                    }
                    if (j3 < this.nTI) {
                        j4 = this.nTI;
                    } else {
                        j4 = (long) (((float) j3) + (0.15f * ((float) this.fPd.field_songFileLength)));
                    }
                    j5 = j;
                    j = j3;
                    z = false;
                    str = a;
                    obj = this.fPd.field_endFlag == 1 ? 1 : null;
                    j2 = j5;
                }
                if (this.nTI < 256000) {
                    this.nTI = 256000;
                    w.i("MicroMsg.Music.MusicDownloadTask", "music firstTimeDownloadSize is less than startPlayLength, update firstTimeDownloadSize");
                }
                File file = new File(h.e(this.fPd, this.lFS));
                if (!file.exists()) {
                    try {
                        w.i("MicroMsg.Music.MusicDownloadTask", "create file:%b", new Object[]{Boolean.valueOf(file.createNewFile())});
                    } catch (Throwable e2) {
                        w.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2, " createNewFile fail, path:%s", new Object[]{file.getAbsolutePath()});
                    }
                    j = 0;
                    j4 = this.nTI;
                    obj = null;
                    w.i("MicroMsg.Music.MusicDownloadTask", "music file delete and create again %d", new Object[]{Long.valueOf(j4)});
                }
                w.i("MicroMsg.Music.MusicDownloadTask", "downloadLength=%d musicFile.Length=%d endRange=%d", new Object[]{Long.valueOf(j), Long.valueOf(file.length()), Long.valueOf(j4)});
                if ((j >= this.nTI && this.nTH == 0.0f) || r10 != null) {
                    w.i("MicroMsg.Music.MusicDownloadTask", "can start play");
                    this.isStop = true;
                    af.v(new a(this, 1));
                } else if (bg.mA(str)) {
                    w.e("MicroMsg.Music.MusicDownloadTask", "downloadUrl is null");
                    this.isStop = true;
                    af.v(new a(this, -2));
                } else {
                    InputStream inputStream2 = null;
                    t h;
                    try {
                        randomAccessFile = new RandomAccessFile(file, "rws");
                        try {
                            w.i("MicroMsg.Music.MusicDownloadTask", "create connection %s", new Object[]{str});
                            Map hashMap = new HashMap(10);
                            hashMap.put("Accept-Encoding", "gzip, deflate");
                            if (j4 > j) {
                                w.d("MicroMsg.Music.MusicDownloadTask", "range : %d-%d", new Object[]{Long.valueOf(j), Long.valueOf(j4)});
                                hashMap.put("range", "bytes=" + j + "-" + j4);
                            }
                            if (z || h.Br(str)) {
                                w.i("MicroMsg.Music.MusicDownloadTask", "set cookie");
                                hashMap.put("Cookie", "qqmusic_fromtag=97;qqmusic_uin=1234567;qqmusic_key=;");
                                hashMap.put("referer", "stream12.qqmusic.qq.com");
                            }
                            hashMap.put("user-agent", System.getProperty("http.agent") + " Built-in music  MicroMessenger/" + h.cD(ab.getContext()));
                            h = h(str, hashMap);
                            try {
                                int responseCode = h.getResponseCode();
                                if (responseCode == m.CTRL_INDEX || responseCode == v.CTRL_INDEX) {
                                    long j6;
                                    w.i("MicroMsg.Music.MusicDownloadTask", "getResponseCode:%d", new Object[]{Integer.valueOf(responseCode)});
                                    w.d("MicroMsg.Music.MusicDownloadTask", "user-agent: " + h.ieZ.getRequestProperty("user-agent"));
                                    w.i("MicroMsg.Music.MusicDownloadTask", "ContentType:%s", new Object[]{h.ieZ.getContentType()});
                                    long[] BB = BB(h.getHeaderField("Content-Range"));
                                    w.i("MicroMsg.Music.MusicDownloadTask", "content-range: %s contentLen=%d", new Object[]{str, Long.valueOf(bg.getLong(h.getHeaderField("Content-Length"), 0))});
                                    if (BB == null) {
                                        w.i("MicroMsg.Music.MusicDownloadTask", "not support range feature");
                                        if (j != 0) {
                                            j = 0;
                                        }
                                        j2 = j4;
                                    } else {
                                        if (j > 0) {
                                            if (j != BB[0]) {
                                                w.e("MicroMsg.Music.MusicDownloadTask", "return http error, need to download again");
                                                qj(6);
                                                if (j2 == 0 && j > 0) {
                                                    w.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                                    try {
                                                        randomAccessFile.setLength(j);
                                                    } catch (Throwable e22) {
                                                        w.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22, " music raf close fail", new Object[0]);
                                                    }
                                                    cH(j);
                                                    if (j < 256000) {
                                                        af.v(new a(this, 1));
                                                    }
                                                } else if (j2 != 0 && j != j2) {
                                                    w.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                                    o(j, j2);
                                                } else if (j2 == 0 || j != j2) {
                                                    w.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                                } else {
                                                    w.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                                    cH(j2);
                                                    if (j < 256000) {
                                                        af.v(new a(this, 1));
                                                    }
                                                }
                                                try {
                                                    randomAccessFile.close();
                                                } catch (Throwable e222) {
                                                    w.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222, " music raf close fail", new Object[0]);
                                                }
                                                if (h != null) {
                                                    h.ieZ.disconnect();
                                                }
                                                this.isStop = true;
                                                w.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                                return;
                                            }
                                        }
                                        j2 = BB[2];
                                    }
                                    if (j2 != 0) {
                                        j6 = j2;
                                    } else {
                                        j6 = 10000000;
                                    }
                                    w.i("MicroMsg.Music.MusicDownloadTask", "fileLen=%d downloadLength=%d", new Object[]{Long.valueOf(j6), Long.valueOf(j)});
                                    randomAccessFile.setLength(j6);
                                    randomAccessFile.seek(j);
                                    InputStream inputStream3 = h.getInputStream();
                                    try {
                                        byte[] bArr = new byte[Downloads.RECV_BUFFER_SIZE];
                                        while (!this.isStop) {
                                            int read = inputStream3.read(bArr);
                                            if (read <= 0) {
                                                w.e("MicroMsg.Music.MusicDownloadTask", "read length:%d, isStop:%b, downloadLength:%d, realFileLength:%d", new Object[]{Integer.valueOf(read), Boolean.valueOf(this.isStop), Long.valueOf(j), Long.valueOf(j6)});
                                                break;
                                            }
                                            randomAccessFile.write(bArr, 0, read);
                                            j += (long) read;
                                            w.v("MicroMsg.Music.MusicDownloadTask", "update updateCurrentDownloadLength %d %d", new Object[]{Long.valueOf(j), Long.valueOf(j6)});
                                            if (this.lFS) {
                                                this.fPd.field_wifiDownloadedLength = j;
                                                this.fPd.field_songWifiFileLength = j6;
                                            } else {
                                                this.fPd.field_downloadedLength = j;
                                                this.fPd.field_songFileLength = j6;
                                            }
                                            if (j >= 256000) {
                                                af.v(new a(this, 1));
                                            }
                                        }
                                        if (j2 == 0 && j > 0) {
                                            w.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                            try {
                                                randomAccessFile.setLength(j);
                                            } catch (Throwable e2222) {
                                                w.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222, " music raf close fail", new Object[0]);
                                            }
                                            cH(j);
                                            if (j < 256000) {
                                                af.v(new a(this, 1));
                                            }
                                        } else if (j2 != 0 && j != j2) {
                                            w.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                            o(j, j2);
                                        } else if (j2 == 0 || j != j2) {
                                            w.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                        } else {
                                            w.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                            cH(j2);
                                            if (j < 256000) {
                                                af.v(new a(this, 1));
                                            }
                                        }
                                        if (inputStream3 != null) {
                                            try {
                                                inputStream3.close();
                                            } catch (Throwable e22222) {
                                                w.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222, " music is close fail", new Object[0]);
                                            }
                                        }
                                        try {
                                            randomAccessFile.close();
                                        } catch (Throwable e222222) {
                                            w.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222, " music raf close fail", new Object[0]);
                                        }
                                        if (h != null) {
                                            h.ieZ.disconnect();
                                        }
                                        this.isStop = true;
                                        w.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                    } catch (Exception e3) {
                                        e222222 = e3;
                                        InputStream inputStream4 = inputStream3;
                                        randomAccessFile2 = randomAccessFile;
                                        long j7 = j2;
                                        inputStream = inputStream4;
                                        tVar = h;
                                        j3 = j;
                                        j = j7;
                                    } catch (Throwable th) {
                                        e222222 = th;
                                        inputStream2 = inputStream3;
                                    }
                                } else {
                                    qi(responseCode);
                                    w.e("MicroMsg.Music.MusicDownloadTask", "music http req error responseCode:%d", new Object[]{Integer.valueOf(responseCode)});
                                    qj(-1);
                                    if (j2 == 0 && j > 0) {
                                        w.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                        try {
                                            randomAccessFile.setLength(j);
                                        } catch (Throwable e2222222) {
                                            w.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222222, " music raf close fail", new Object[0]);
                                        }
                                        cH(j);
                                        if (j < 256000) {
                                            af.v(new a(this, 1));
                                        }
                                    } else if (j2 != 0 && j != j2) {
                                        w.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                        o(j, j2);
                                    } else if (j2 == 0 || j != j2) {
                                        w.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                    } else {
                                        w.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                        cH(j2);
                                        if (j < 256000) {
                                            af.v(new a(this, 1));
                                        }
                                    }
                                    try {
                                        randomAccessFile.close();
                                    } catch (Throwable e22222222) {
                                        w.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222, " music raf close fail", new Object[0]);
                                    }
                                    if (h != null) {
                                        h.ieZ.disconnect();
                                    }
                                    this.isStop = true;
                                    w.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                }
                            } catch (Exception e4) {
                                e22222222 = e4;
                                randomAccessFile2 = randomAccessFile;
                                j5 = j2;
                                inputStream = null;
                                tVar = h;
                                j3 = j;
                                j = j5;
                                try {
                                    w.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                                    qj(5);
                                    if (j != 0) {
                                    }
                                    if (j == 0) {
                                    }
                                    if (j == 0) {
                                    }
                                    w.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable e222222222) {
                                            w.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e222222222, " music is close fail", new Object[0]);
                                        }
                                    }
                                    if (randomAccessFile2 != null) {
                                        try {
                                            randomAccessFile2.close();
                                        } catch (Throwable e2222222222) {
                                            w.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222222222, " music raf close fail", new Object[0]);
                                        }
                                    }
                                    if (tVar != null) {
                                        tVar.ieZ.disconnect();
                                    }
                                    this.isStop = true;
                                    w.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                } catch (Throwable th2) {
                                    e2222222222 = th2;
                                    randomAccessFile = randomAccessFile2;
                                    inputStream2 = inputStream;
                                    j5 = j;
                                    j = j3;
                                    h = tVar;
                                    j2 = j5;
                                    if (j2 != 0) {
                                    }
                                    if (j2 == 0) {
                                    }
                                    if (j2 == 0) {
                                    }
                                    w.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Throwable e5) {
                                            w.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e5, " music is close fail", new Object[0]);
                                        }
                                    }
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.close();
                                        } catch (Throwable e52) {
                                            w.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e52, " music raf close fail", new Object[0]);
                                        }
                                    }
                                    if (h != null) {
                                        h.ieZ.disconnect();
                                    }
                                    this.isStop = true;
                                    w.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                    throw e2222222222;
                                }
                            } catch (Throwable th3) {
                                e2222222222 = th3;
                                if (j2 != 0) {
                                }
                                if (j2 == 0) {
                                }
                                if (j2 == 0) {
                                }
                                w.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                if (randomAccessFile != null) {
                                    randomAccessFile.close();
                                }
                                if (h != null) {
                                    h.ieZ.disconnect();
                                }
                                this.isStop = true;
                                w.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                                throw e2222222222;
                            }
                        } catch (Exception e6) {
                            e2222222222 = e6;
                            randomAccessFile2 = randomAccessFile;
                            j3 = j;
                            j = j2;
                            inputStream = null;
                            tVar = null;
                            w.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e2222222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                            qj(5);
                            if (j != 0 && j3 > 0) {
                                w.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                try {
                                    randomAccessFile2.setLength(j3);
                                } catch (Throwable e22222222222) {
                                    w.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222222, " music raf close fail", new Object[0]);
                                }
                                cH(j3);
                                if (j3 < 256000) {
                                    af.v(new a(this, 1));
                                }
                            } else if (j == 0 && j3 != j) {
                                w.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j), Long.valueOf(j3)});
                                o(j3, j);
                            } else if (j == 0 && j3 == j) {
                                w.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j), Long.valueOf(j3)});
                                cH(j);
                                if (j3 < 256000) {
                                    af.v(new a(this, 1));
                                }
                            } else {
                                w.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (randomAccessFile2 != null) {
                                randomAccessFile2.close();
                            }
                            if (tVar != null) {
                                tVar.ieZ.disconnect();
                            }
                            this.isStop = true;
                            w.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                        } catch (Throwable th4) {
                            e22222222222 = th4;
                            h = null;
                            if (j2 != 0 && j > 0) {
                                w.i("MicroMsg.Music.MusicDownloadTask", "can not get contentLen, but download end");
                                try {
                                    randomAccessFile.setLength(j);
                                } catch (Throwable e522) {
                                    w.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e522, " music raf close fail", new Object[0]);
                                }
                                cH(j);
                                if (j < 256000) {
                                    af.v(new a(this, 1));
                                }
                            } else if (j2 == 0 && j != j2) {
                                w.i("MicroMsg.Music.MusicDownloadTask", "not download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                o(j, j2);
                            } else if (j2 == 0 && j == j2) {
                                w.i("MicroMsg.Music.MusicDownloadTask", "download end, total=%d, downloadLength=%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
                                cH(j2);
                                if (j < 256000) {
                                    af.v(new a(this, 1));
                                }
                            } else {
                                w.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                            }
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            if (randomAccessFile != null) {
                                randomAccessFile.close();
                            }
                            if (h != null) {
                                h.ieZ.disconnect();
                            }
                            this.isStop = true;
                            w.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                            throw e22222222222;
                        }
                    } catch (Exception e7) {
                        e22222222222 = e7;
                        randomAccessFile2 = null;
                        j3 = j;
                        j = j2;
                        inputStream = null;
                        tVar = null;
                        w.printErrStackTrace("MicroMsg.Music.MusicDownloadTask", e22222222222, " download  music file fail, :%s", new Object[]{file.getAbsolutePath()});
                        qj(5);
                        if (j != 0) {
                        }
                        if (j == 0) {
                        }
                        if (j == 0) {
                        }
                        w.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (randomAccessFile2 != null) {
                            randomAccessFile2.close();
                        }
                        if (tVar != null) {
                            tVar.ieZ.disconnect();
                        }
                        this.isStop = true;
                        w.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                    } catch (Throwable th5) {
                        e22222222222 = th5;
                        randomAccessFile = null;
                        h = null;
                        if (j2 != 0) {
                        }
                        if (j2 == 0) {
                        }
                        if (j2 == 0) {
                        }
                        w.i("MicroMsg.Music.MusicDownloadTask", "not find status");
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        if (h != null) {
                            h.ieZ.disconnect();
                        }
                        this.isStop = true;
                        w.i("MicroMsg.Music.MusicDownloadTask", "stop download music task");
                        throw e22222222222;
                    }
                }
            } else if (this.fPd.field_wifiDownloadedLength != 0 && this.fPd.field_wifiDownloadedLength >= this.nTI && (((float) this.fPd.field_wifiDownloadedLength) / ((float) this.fPd.field_songWifiFileLength)) - this.nTH >= 0.15f) {
                w.i("MicroMsg.Music.MusicDownloadTask", "can start play");
                this.isStop = true;
                this.lFS = true;
                af.v(new a(this, 1));
            } else if (this.fPd.field_downloadedLength == 0 || this.fPd.field_downloadedLength < this.nTI || (((float) this.fPd.field_downloadedLength) / ((float) this.fPd.field_songFileLength)) - this.nTH < 0.15f) {
                w.i("MicroMsg.Music.MusicDownloadTask", "not connect network");
                this.isStop = true;
                qj(4);
            } else {
                w.i("MicroMsg.Music.MusicDownloadTask", "can start play");
                this.isStop = true;
                this.lFS = false;
                af.v(new a(this, 1));
            }
        }
    }

    private static t h(String str, Map<String, String> map) {
        t tVar = null;
        int i = 0;
        while (true) {
            if (tVar != null) {
                tVar.ieZ.disconnect();
            }
            w.i("MicroMsg.Music.MusicDownloadTask", "getUrlConnect, downloadUrl:%s", new Object[]{str});
            tVar = com.tencent.mm.network.b.a(str, null);
            tVar.setRequestMethod("GET");
            tVar.setConnectTimeout(25000);
            tVar.ieZ.setInstanceFollowRedirects(true);
            for (Entry entry : map.entrySet()) {
                tVar.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            int responseCode = tVar.getResponseCode();
            w.i("MicroMsg.Music.MusicDownloadTask", "getUrlConnect response:%d, redirectCount:%d", new Object[]{Integer.valueOf(responseCode), Integer.valueOf(i)});
            if (responseCode != com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX && responseCode != com.tencent.mm.plugin.appbrand.jsapi.l.b.CTRL_INDEX && responseCode != 302 && responseCode != 303) {
                return tVar;
            }
            qi(responseCode);
            String headerField = tVar.getHeaderField("Location");
            if (headerField == null) {
                w.e("MicroMsg.Music.MusicDownloadTask", "Invalid redirect,  response:%d", new Object[]{Integer.valueOf(responseCode)});
                return tVar;
            }
            URL url = new URL(tVar.ieZ.getURL(), headerField);
            w.i("MicroMsg.Music.MusicDownloadTask", "location:%s", new Object[]{headerField});
            w.i("MicroMsg.Music.MusicDownloadTask", "tempUrl:%s", new Object[]{url.toString()});
            if (url.getProtocol().equals("https") || url.getProtocol().equals("http")) {
                responseCode = i + 1;
                if (responseCode > 5) {
                    w.e("MicroMsg.Music.MusicDownloadTask", "Too many redirects: " + responseCode);
                    return tVar;
                }
                str = url.toString();
                i = responseCode;
            } else {
                w.e("MicroMsg.Music.MusicDownloadTask", "Unsupported protocol redirect,  response:%d", new Object[]{Integer.valueOf(responseCode)});
                return tVar;
            }
        }
    }

    private static void qi(int i) {
        if (i == com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX || i == com.tencent.mm.plugin.appbrand.jsapi.l.b.CTRL_INDEX || i == 302 || i == 303) {
            IDKey iDKey = new IDKey();
            iDKey.SetID(558);
            iDKey.SetKey(15);
            iDKey.SetValue(1);
            ArrayList arrayList = new ArrayList();
            arrayList.add(iDKey);
            g.oUh.b(arrayList, true);
        }
    }

    private void qj(int i) {
        af.v(new a(this, i));
    }

    private void cH(long j) {
        if (this.lFS) {
            this.fPd.field_wifiDownloadedLength = j;
            i.aNT().L(this.fPd.field_musicId, j);
            i.aNT().bq(this.fPd.field_musicId, 1);
            i.aNT().M(this.fPd.field_musicId, j);
        } else {
            this.fPd.field_downloadedLength = j;
            i.aNT().N(this.fPd.field_musicId, j);
            i.aNT().br(this.fPd.field_musicId, 1);
            i.aNT().O(this.fPd.field_musicId, j);
        }
        af.v(new a(this, 2));
    }

    private void o(long j, long j2) {
        if (this.lFS) {
            this.fPd.field_wifiDownloadedLength = j;
            i.aNT().L(this.fPd.field_musicId, j);
            i.aNT().bq(this.fPd.field_musicId, 0);
            i.aNT().M(this.fPd.field_musicId, j2);
        } else {
            this.fPd.field_downloadedLength = j;
            i.aNT().N(this.fPd.field_musicId, j);
            i.aNT().br(this.fPd.field_musicId, 0);
            i.aNT().O(this.fPd.field_musicId, j2);
        }
        af.v(new a(this, 3));
    }

    private static long[] BB(String str) {
        if (bg.mA(str)) {
            return null;
        }
        try {
            String[] split = str.replace("bytes", "").trim().split("-");
            long longValue = Long.valueOf(split[0]).longValue();
            split = split[1].split("/");
            long longValue2 = Long.valueOf(split[0]).longValue();
            long longValue3 = Long.valueOf(split[1]).longValue();
            return new long[]{longValue, longValue2, longValue3};
        } catch (Exception e) {
            return null;
        }
    }
}
