package com.tencent.mm.plugin.wallet_index.b.a;

import com.tencent.mm.R;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.ab;

public final class b {
    public int mKQ;
    public String mMessage;
    public int rPy = 0;

    private b(int i, String str) {
        this.mKQ = i;
        this.mMessage = str;
    }

    public static b vH(int i) {
        int i2;
        int i3 = -1;
        switch (i) {
            case -3000:
                i3 = 100000009;
                i2 = R.l.eqT;
                break;
            case -2002:
                i3 = 1000000093;
                i2 = R.l.eqO;
                break;
            case -2001:
                i3 = 100000004;
                i2 = R.l.eqN;
                break;
            case -1010:
            case -1006:
            case -1003:
            case -1002:
                i2 = R.l.eqL;
                break;
            case -1005:
            case 1:
                i3 = 100000000;
                i2 = R.l.eqU;
                break;
            case 0:
                i3 = 0;
                i2 = R.l.eqS;
                break;
            case 3:
                i2 = R.l.eqM;
                break;
            case 4:
                i2 = R.l.eqR;
                break;
            case 7:
            case 103:
                i3 = 103;
                i2 = R.l.eqP;
                break;
            case 8:
                i2 = R.l.eqQ;
                break;
            default:
                i2 = R.l.eqT;
                break;
        }
        b bVar = new b(i3, ab.getContext().getString(i2));
        bVar.rPy = i;
        return bVar;
    }

    public static b av(int i, String str) {
        int i2;
        int i3 = -1;
        switch (i) {
            case 0:
                i3 = 0;
                i2 = R.l.foj;
                break;
            case 1:
            case 100000000:
                i3 = 100000000;
                i2 = R.l.fol;
                break;
            case 103:
                i3 = 103;
                i2 = R.l.foi;
                break;
            case MMGIFException.D_GIF_ERR_NO_IMAG_DSCR /*105*/:
                return new b(-1, str);
            case MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM /*109*/:
                i3 = MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM;
                i2 = R.l.fom;
                break;
            case MMGIFException.D_GIF_ERR_CLOSE_FAILED /*110*/:
                i3 = MMGIFException.D_GIF_ERR_CLOSE_FAILED;
                i2 = R.l.foo;
                break;
            case 111:
                i3 = 111;
                i2 = R.l.fop;
                break;
            case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
                i3 = MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
                i2 = R.l.fon;
                break;
            case 113:
                i3 = 113;
                i2 = R.l.fok;
                break;
            default:
                i2 = R.l.fok;
                break;
        }
        return new b(i3, ab.getContext().getString(i2));
    }

    public final boolean bvv() {
        return this.mKQ == 7 || this.mKQ == 103;
    }

    public final boolean isFailure() {
        return ((this.mKQ == 0) || bvv()) ? false : true;
    }

    public final String toString() {
        return "IabResult: " + this.mMessage;
    }
}
