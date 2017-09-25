package com.tencent.mm.c.c;

import com.tencent.mm.loader.stub.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public final class d implements a {
    public BlockingQueue<com.tencent.mm.c.b.g.a> fBH = new ArrayBlockingQueue(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
    public boolean fBI = false;
    public String fBJ;
    private com.tencent.qqpinyin.voicerecoapi.a fBT;
    private a fBU;
    private FileOutputStream mFileOutputStream;

    private final class a implements Runnable {
        final /* synthetic */ d fBV;

        public final void run() {
            while (true) {
                boolean z;
                synchronized (this.fBV) {
                    z = this.fBV.fBI;
                }
                w.d("MicroMsg.SpeexWriter", "ThreadSpeex in: " + z + " queueLen: " + this.fBV.fBH.size());
                if (!z || !this.fBV.fBH.isEmpty()) {
                    try {
                        com.tencent.mm.c.b.g.a aVar = (com.tencent.mm.c.b.g.a) this.fBV.fBH.poll(200, TimeUnit.MILLISECONDS);
                        if (aVar == null) {
                            w.e("MicroMsg.SpeexWriter", "poll byteBuf is null, " + this.fBV.fBJ);
                        } else {
                            this.fBV.a(aVar, 0, false);
                        }
                    } catch (InterruptedException e) {
                        w.i("MicroMsg.SpeexWriter", "ThreadSpeex poll null");
                    }
                } else {
                    return;
                }
            }
        }
    }

    public final boolean bz(String str) {
        w.i("MicroMsg.SpeexWriter", "initWriter, path: " + str);
        if (str == null) {
            return false;
        }
        this.fBJ = str;
        try {
            this.mFileOutputStream = new FileOutputStream(new File(str));
            this.fBT = new com.tencent.qqpinyin.voicerecoapi.a();
            int cdq = this.fBT.cdq();
            if (cdq == 0) {
                return true;
            }
            w.e("MicroMsg.SpeexWriter", "speexInit failed: " + cdq);
            return false;
        } catch (Exception e) {
            if (this.mFileOutputStream != null) {
                try {
                    this.mFileOutputStream.close();
                } catch (IOException e2) {
                }
            }
            w.e("MicroMsg.SpeexWriter", "Error on init file: ", e);
            return false;
        }
    }

    public final int a(com.tencent.mm.c.b.g.a aVar, int i) {
        return a(aVar, 0, false);
    }

    public final int a(com.tencent.mm.c.b.g.a aVar, int i, boolean z) {
        if (this.fBT == null || aVar.buf == null || aVar.fAK == 0) {
            w.e("MicroMsg.SpeexWriter", "try write invalid data to file");
            return -1;
        }
        try {
            byte[] E = this.fBT.E(aVar.buf, aVar.fAK);
            if (E == null || E.length <= 0) {
                w.e("MicroMsg.SpeexWriter", "convert failed: " + (E == null ? "outBuffer is null" : "size is zero"));
                return -1;
            }
            w.d("MicroMsg.SpeexWriter", "write to file, len: %d", Integer.valueOf(E.length));
            this.mFileOutputStream.write(E);
            this.mFileOutputStream.flush();
            return E.length;
        } catch (Exception e) {
            w.e("MicroMsg.SpeexWriter", "write to file failed", e);
            return -1;
        }
    }

    public final void ps() {
        w.i("MicroMsg.SpeexWriter", "wait Stop");
        synchronized (this) {
            this.fBI = true;
        }
        if (this.fBU != null) {
            try {
                e.Q(this.fBU);
                this.fBU = null;
            } catch (InterruptedException e) {
                w.e("MicroMsg.SpeexWriter", "thread speex interrupted");
            }
        }
        if (this.fBT != null) {
            this.fBT.cdr();
            this.fBT = null;
        }
        if (this.mFileOutputStream != null) {
            try {
                this.mFileOutputStream.close();
            } catch (Exception e2) {
                w.e("MicroMsg.SpeexWriter", "close silk file: " + this.fBJ + "msg: " + e2.getMessage());
            }
            this.mFileOutputStream = null;
        }
    }

    public final boolean pt() {
        if (this.fBT != null) {
            this.fBT.cdr();
            this.fBT = null;
        }
        this.fBT = new com.tencent.qqpinyin.voicerecoapi.a();
        int cdq = this.fBT.cdq();
        if (cdq == 0) {
            return true;
        }
        w.e("MicroMsg.SpeexWriter", "resetWriter speexInit failed: " + cdq);
        return false;
    }

    public static boolean t(String str, String str2) {
        FileInputStream fileInputStream;
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || str.length() <= 0) {
            w.e("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex filePath null");
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            w.i("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex pcmLen = " + file.length());
            try {
                com.tencent.qqpinyin.voicerecoapi.a aVar = new com.tencent.qqpinyin.voicerecoapi.a();
                if (aVar.cdq() != 0) {
                    w.e("MicroMsg.SpeexWriter", "[voiceControl] speexInit fail");
                    aVar.cdr();
                    return false;
                }
                b.deleteFile(str2);
                File file2 = new File(str2);
                file2.createNewFile();
                file2.setReadable(true);
                try {
                    byte[] bArr = new byte[Downloads.RECV_BUFFER_SIZE];
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read > 0) {
                            byte[] E = aVar.E(bArr, read);
                            if (E == null) {
                                fileInputStream2.close();
                                return false;
                            }
                            try {
                                w.i("MicroMsg.SpeexWriter", "[voiceControl] appendToFile " + com.tencent.mm.a.e.e(str2, E) + ", readLen = " + read);
                            } catch (Exception e) {
                                fileInputStream = fileInputStream2;
                            }
                        } else {
                            fileInputStream2.close();
                            aVar.cdr();
                            w.i("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex = " + (System.currentTimeMillis() - currentTimeMillis));
                            return true;
                        }
                    }
                } catch (Exception e2) {
                    fileInputStream = null;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    aVar.cdr();
                    return false;
                }
            } catch (Exception e3) {
                w.e("MicroMsg.SpeexWriter", "[voiceControl] Exception in decodePCMToSpeex, " + e3.getMessage());
                return false;
            }
        }
        w.e("MicroMsg.SpeexWriter", "[voiceControl] decodePCMToSpeex filePath null");
        return false;
    }
}
