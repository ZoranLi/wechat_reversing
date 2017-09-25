package com.tencent.qqpinyin.voicerecoapi;

public final class c {
    private int icX;
    private int jbc;
    private TRVADNative wPG;

    public static class a {
        public int wPH = 0;
        public int wPI = 256;
        public int wPJ = 512;
        private int wPK = 0;
        public int wPL = 0;
    }

    public c(int i) {
        this.wPG = new TRVADNative();
        this.icX = i;
        this.jbc = 5000000;
    }

    public c() {
        this.wPG = new TRVADNative();
        this.icX = 500000;
        this.jbc = 10000000;
    }

    public final int start() {
        int mfeInit = this.wPG.mfeInit(this.icX, this.jbc);
        if (mfeInit == 0) {
            mfeInit = this.wPG.mfeOpen();
            if (mfeInit == 0) {
                mfeInit = this.wPG.mfeEnableNoiseDetection(true);
                if (mfeInit == 0) {
                    mfeInit = this.wPG.mfeStart();
                }
            }
        }
        return mfeInit == 0 ? 0 : -1;
    }

    public final int stop() {
        int mfeStop = this.wPG.mfeStop();
        if (mfeStop == 0) {
            mfeStop = this.wPG.mfeClose();
            if (mfeStop == 0) {
                mfeStop = this.wPG.mfeExit();
            }
        }
        return mfeStop == 0 ? 0 : -1;
    }

    public final synchronized void a(short[] sArr, int i, a aVar) {
        double d = 26.0d;
        int i2 = 0;
        synchronized (this) {
            if (i > 0) {
                switch (this.wPG.mfeSendData(sArr, i)) {
                    case 1:
                        aVar.wPH = 1;
                        break;
                    case 2:
                        aVar.wPH = 2;
                        break;
                    case 3:
                        aVar.wPH = 3;
                        break;
                    default:
                        aVar.wPH = 0;
                        break;
                }
                int i3 = 0;
                while (i2 < i) {
                    i3 = (int) (((double) i3) + (Math.sqrt((double) (sArr[i2] * sArr[i2])) / ((double) i)));
                    i2++;
                }
                if (i3 < 100) {
                    d = 0.0d;
                } else if (i3 <= 16383) {
                    d = 26.0d * ((((double) i3) - 100.0d) / 32667.0d);
                }
                aVar.wPL = (int) d;
                new StringBuilder("volumn��").append(aVar.wPL);
            }
        }
    }
}
