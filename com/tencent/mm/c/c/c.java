package com.tencent.mm.c.c;

import com.tencent.mm.compatible.d.l;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelvoice.MediaRecorder;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public final class c implements a {
    public static com.tencent.mm.c.c.a.a fBR = new com.tencent.mm.c.c.a.a();
    public BlockingQueue<com.tencent.mm.c.b.g.a> fBH = new ArrayBlockingQueue(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
    public boolean fBI = false;
    public String fBJ;
    private int fBK = 0;
    private byte[] fBL = null;
    private int fBM = 16000;
    private Object fBN = new Object();
    public a fBO = null;
    private int fBP;
    private boolean fBQ = false;
    private FileOutputStream mFileOutputStream;
    private int mSampleRate = 16000;

    private final class a implements Runnable {
        final /* synthetic */ c fBS;

        public a(c cVar) {
            this.fBS = cVar;
        }

        public final void run() {
            w.i("MicroMsg.SilkWriter", "Silk Thread start run");
            while (true) {
                boolean z;
                synchronized (this.fBS) {
                    z = this.fBS.fBI;
                }
                w.d("MicroMsg.SilkWriter", "ThreadSilk in :" + z + " cnt :" + this.fBS.fBH.size());
                if (!z || !this.fBS.fBH.isEmpty()) {
                    try {
                        com.tencent.mm.c.b.g.a aVar = (com.tencent.mm.c.b.g.a) this.fBS.fBH.poll(200, TimeUnit.MILLISECONDS);
                        if (aVar == null) {
                            w.i("MicroMsg.SilkWriter", "poll byte null file:" + this.fBS.fBJ);
                        } else {
                            int size = this.fBS.fBH.size();
                            if (size > 10 || z) {
                                w.w("MicroMsg.SilkWriter", "speed up silkcodec queue:" + size + " stop:" + z);
                                size = false;
                            } else if (size < 9) {
                                size = 1;
                            } else {
                                size = 1;
                            }
                            if (c.fBR.count >= 10 && c.fBR.fBE > 240) {
                                size = 0;
                            }
                            this.fBS.a(aVar, size, false);
                        }
                    } catch (InterruptedException e) {
                        w.i("MicroMsg.SilkWriter", "ThreadAmr poll null");
                    }
                } else {
                    return;
                }
            }
        }
    }

    public c(int i, int i2) {
        this.mSampleRate = i;
        this.fBM = i2;
    }

    public final boolean bz(String str) {
        w.i("MicroMsg.SilkWriter", "initWriter path: " + str);
        if (str == null) {
            w.e("MicroMsg.SilkWriter", "path is null");
            return false;
        }
        this.fBJ = str;
        try {
            this.mFileOutputStream = new FileOutputStream(this.fBJ);
            int rl = l.rl();
            if ((rl & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                this.fBP = 4;
            } else if ((rl & 512) != 0) {
                this.fBP = 2;
            } else {
                w.e("TAG", "initWriter cpuType error! silk don't support arm_v5!!!!");
                return false;
            }
            if (MediaRecorder.SilkEncInit(this.mSampleRate, this.fBM, this.fBP) != 0) {
                w.e("MicroMsg.SilkWriter", "initWriter SilkEncoderInit Error:%d", Integer.valueOf(MediaRecorder.SilkEncInit(this.mSampleRate, this.fBM, this.fBP)));
                return false;
            }
            this.fBL = new byte[(((this.mSampleRate * 20) * 2) / 1000)];
            rl = -1;
            com.tencent.mm.storage.c dX = com.tencent.mm.u.c.c.Az().dX("100279");
            if (dX.isValid()) {
                rl = bg.getInt((String) dX.bKK().get("isVoiceMsgOptOpen"), 0);
            }
            if (1 == rl) {
                this.fBQ = true;
            }
            if (rl == 0) {
                this.fBQ = false;
            }
            if (this.fBQ) {
                MediaRecorder.SetVoiceSilkControl(m.CTRL_INDEX, 1);
                w.i("MicroMsg.SilkWriter", "Voice Message Compression Optimization is Open !");
            } else {
                MediaRecorder.SetVoiceSilkControl(m.CTRL_INDEX, 0);
                w.i("MicroMsg.SilkWriter", "Voice Message Compression Optimization is Close !");
            }
            return true;
        } catch (Exception e) {
            w.e("MicroMsg.SilkWriter", "initWriter FileOutputStream error:%s", e.getMessage());
            return false;
        }
    }

    public final void ps() {
        w.i("MicroMsg.SilkWriter", "waitStop");
        synchronized (this) {
            this.fBI = true;
        }
        if (this.fBO != null) {
            try {
                e.Q(this.fBO);
            } catch (Throwable e) {
                w.e("MicroMsg.SilkWriter", "exception:%s", bg.g(e));
            }
        }
        synchronized (this.fBN) {
            MediaRecorder.SilkEncUnInit();
        }
        w.i("MicroMsg.SilkWriter", "finish Thread file:" + this.fBJ);
        if (this.mFileOutputStream != null) {
            try {
                this.mFileOutputStream.close();
            } catch (Exception e2) {
                w.e("MicroMsg.SilkWriter", "close silk file:" + this.fBJ + "msg:" + e2.getMessage());
            }
            this.mFileOutputStream = null;
        }
    }

    public final boolean pt() {
        w.i("MicroMsg.SilkWriter", "resetWriter");
        synchronized (this.fBN) {
            MediaRecorder.SilkEncUnInit();
        }
        if (MediaRecorder.SilkEncInit(this.mSampleRate, this.fBM, this.fBP) == 0) {
            return true;
        }
        w.e("MicroMsg.SilkWriter", "resetWriter SilkEncoderInit Error:%d", Integer.valueOf(MediaRecorder.SilkEncInit(this.mSampleRate, this.fBM, this.fBP)));
        return false;
    }

    public final int a(com.tencent.mm.c.b.g.a aVar, int i) {
        return a(aVar, 0, false);
    }

    public final int a(com.tencent.mm.c.b.g.a aVar, int i, boolean z) {
        com.tencent.mm.compatible.util.g.a aVar2 = new com.tencent.mm.compatible.util.g.a();
        short s = (short) (((this.mSampleRate * 20) * 2) / 1000);
        short s2 = this.fBK + aVar.fAK;
        int i2 = 0;
        Object obj = new byte[s];
        byte[] bArr = new byte[((this.fBQ ? 6 : 1) * s)];
        String value = ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("VoiceNoiseSuppression");
        boolean z2 = !bg.mA(value) ? bg.getInt(value, 1) == 1 : true;
        if (z) {
            z2 = false;
        }
        w.d("MicroMsg.SilkWriter", "noise suppression: %b", Boolean.valueOf(z2));
        int i3 = 0;
        while (s2 >= s) {
            if (this.fBK > 0) {
                try {
                    System.arraycopy(this.fBL, 0, obj, 0, this.fBK);
                    System.arraycopy(aVar.buf, 0, obj, this.fBK, s - this.fBK);
                    i2 += s - this.fBK;
                    this.fBK = 0;
                } catch (Exception e) {
                    w.e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode arraycopy failed, leftBufSize:%d copySize:%d error:%s", Integer.valueOf(this.fBK), Integer.valueOf(s - this.fBK), e.getMessage());
                    return -1;
                }
            }
            try {
                System.arraycopy(aVar.buf, i2, obj, 0, s);
                i2 += s;
            } catch (Exception e2) {
                w.e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode arraycopy failed, offset:%d framelen:%d error:%s", Integer.valueOf(i2), Short.valueOf(s), e2.getMessage());
                return -1;
            }
            short s3 = s2 - s;
            short[] sArr = new short[1];
            synchronized (this.fBN) {
                if (this.fBQ) {
                    if (s3 >= s || !aVar.fAL) {
                        MediaRecorder.SetVoiceSilkControl(bh.CTRL_INDEX, 0);
                    } else {
                        MediaRecorder.SetVoiceSilkControl(bh.CTRL_INDEX, 1);
                        w.i("MicroMsg.SilkWriter", "silk do encode mark last frame");
                    }
                }
                int SilkDoEnc = MediaRecorder.SilkDoEnc(obj, s, bArr, sArr, z2);
            }
            Object obj2 = null;
            if (z && sArr[0] >= (short) 10 && bArr[0] == (byte) 2 && bArr[1] == (byte) 35 && bArr[2] == (byte) 33 && bArr[3] == (byte) 83 && bArr[4] == (byte) 73 && bArr[5] == (byte) 76 && bArr[6] == (byte) 75 && bArr[7] == (byte) 95 && bArr[8] == (byte) 86 && bArr[9] == (byte) 51) {
                w.i("MicroMsg.SilkWriter", "writeSilkFile deleteHead & bDeleteHead true");
                obj2 = 1;
            }
            if (SilkDoEnc != 0) {
                this.fBK = 0;
                w.e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode failed, ret:%d", Integer.valueOf(SilkDoEnc));
                return -1;
            }
            w.v("MicroMsg.SilkWriter", "encoutdatalen: %s, framelen: %s, lastframe: %s, byteBuf.len: %s", Short.valueOf(sArr[0]), Short.valueOf(s), Boolean.valueOf(aVar.fAL), Integer.valueOf(aVar.fAK));
            try {
                if (sArr[0] < bArr.length && sArr[0] > (short) 0) {
                    if (!z || r5 == null) {
                        this.mFileOutputStream.write(bArr, 0, sArr[0]);
                        i3 += sArr[0];
                    } else {
                        w.i("MicroMsg.SilkWriter", "writeSilkFile bDeleteHead copyOfRange");
                        this.mFileOutputStream.write(Arrays.copyOfRange(bArr, 1, bArr.length), 0, sArr[0] - 1);
                        i3 += sArr[0] - 1;
                        s2 = s3;
                    }
                }
                s2 = s3;
            } catch (IOException e3) {
                w.e("MicroMsg.SilkWriter", "writeSilkFile Write File Error file:%s", this.fBJ);
                return -1;
            }
        }
        try {
            this.mFileOutputStream.flush();
            try {
                System.arraycopy(aVar.buf, i2, this.fBL, this.fBK, s2);
                this.fBK += s2;
                long se = aVar2.se();
                if (i == 1) {
                    com.tencent.mm.c.c.a.a aVar3 = fBR;
                    aVar3.fBE = ((aVar3.fBE * ((long) aVar3.count)) + se) / ((long) (aVar3.count + 1));
                    aVar3.count++;
                }
                w.d("MicroMsg.SilkWriter", "writeSilkFile append2silkfile silkTime:" + se + " useFloat:" + i + " avg:" + fBR.fBE + " cnt:" + fBR.count);
                return i3;
            } catch (Exception e22) {
                w.e("MicroMsg.SilkWriter", "writeSilkFile SilkEncode arraycopy failed, offset:%d leftBufSize:%d leftSize:%d error:%s", Integer.valueOf(i2), Integer.valueOf(this.fBK), Integer.valueOf(s2), e22.getMessage());
                return -1;
            }
        } catch (IOException e4) {
            w.e("MicroMsg.SilkWriter", "writeSilkFile flush File Error file:%s", this.fBJ);
            return -1;
        }
    }
}
