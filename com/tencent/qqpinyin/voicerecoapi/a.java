package com.tencent.qqpinyin.voicerecoapi;

import com.tencent.mm.sdk.platformtools.MMBitmapFactory;

public final class a {
    public static int wPA = MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN;
    private byte[] wPB = null;
    public byte[] wPC = null;
    private int wPD = 0;
    public int wPE = 0;
    public TRSpeexNative wPF = new TRSpeexNative();

    public final int cdq() {
        if (this.wPD != 0) {
            return -103;
        }
        int nativeTRSpeexInit = this.wPF.nativeTRSpeexInit();
        if (nativeTRSpeexInit == -1) {
            return nativeTRSpeexInit;
        }
        this.wPD = nativeTRSpeexInit;
        this.wPB = new byte[(wPA * 10)];
        return 0;
    }

    public final byte[] E(byte[] bArr, int i) {
        if (this.wPD == 0) {
            throw new b(-102);
        } else if (bArr == null || bArr.length == 0) {
            throw new b(-104);
        } else {
            int nativeTRSpeexEncode = this.wPF.nativeTRSpeexEncode(this.wPD, bArr, 0, i, this.wPB);
            if (nativeTRSpeexEncode < 0) {
                throw new b(nativeTRSpeexEncode);
            } else if (nativeTRSpeexEncode == 0) {
                return null;
            } else {
                byte[] bArr2 = new byte[nativeTRSpeexEncode];
                System.arraycopy(this.wPB, 0, bArr2, 0, nativeTRSpeexEncode);
                return bArr2;
            }
        }
    }

    public final int cdr() {
        if (this.wPD == 0) {
            return -102;
        }
        this.wPB = null;
        int nativeTRSpeexRelease = this.wPF.nativeTRSpeexRelease(this.wPD);
        this.wPD = 0;
        return nativeTRSpeexRelease;
    }
}
