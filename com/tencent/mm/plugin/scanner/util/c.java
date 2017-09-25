package com.tencent.mm.plugin.scanner.util;

import android.graphics.Rect;
import c.a;
import com.tencent.mm.sdk.platformtools.w;

public final class c extends a {
    public int height;
    public int left;
    public final byte[] pdh;
    final int pdi;
    final int pdj;
    public int top;
    public int width;

    public c(byte[] bArr, int i, int i2, Rect rect) {
        int i3 = 0;
        super(rect.width(), rect.height());
        w.v("MicroMsg.scanner.PlanarYUVLuminanceSource", "init yuvData.len: %d,  dataW: %d, dataH: %d, left: %d, top: %d, width: %d, height: %d ", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(rect.left), Integer.valueOf(rect.top), Integer.valueOf(rect.width()), Integer.valueOf(rect.height())});
        this.pdh = bArr;
        this.pdi = i;
        this.pdj = i2;
        int i4 = (rect.left < 0 || rect.left >= i) ? 0 : rect.left;
        this.left = i4;
        if (rect.top >= 0 && rect.top < i2) {
            i3 = rect.top;
        }
        this.top = i3;
        this.width = this.left + rect.width() > i ? i - this.left : rect.width();
        this.height = this.top + rect.height() > i2 ? i2 - this.top : rect.height();
        if (this.left + this.width > i || this.top + this.height > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
    }

    public final byte[] k(int i, byte[] bArr) {
        if (i < 0 || i >= this.height) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        if (bArr == null || bArr.length < this.width) {
            bArr = new byte[this.width];
        }
        System.arraycopy(this.pdh, ((this.top + i) * this.pdi) + this.left, bArr, 0, this.width);
        return bArr;
    }

    public static void aYW() {
        m aZj = m.aZj();
        if (aZj.pep != null) {
            aZj.pep = null;
        }
        if (aZj.peq != null) {
            aZj.peq = null;
        }
        System.gc();
    }

    public final byte[] aYX() {
        if (this.width == this.pdi && this.height == this.pdj) {
            return this.pdh;
        }
        try {
            int i = this.width * this.height;
            m aZj = m.aZj();
            if (aZj.pep == null) {
                aZj.pep = new byte[i];
            } else if (aZj.pep.length != i) {
                aZj.pep = null;
                aZj.pep = new byte[i];
            }
            byte[] bArr = aZj.pep;
            int i2 = (this.top * this.pdi) + this.left;
            if (this.width == this.pdi) {
                System.arraycopy(this.pdh, i2, bArr, 0, i);
                return bArr;
            }
            Object obj = this.pdh;
            for (int i3 = 0; i3 < this.height; i3++) {
                System.arraycopy(obj, i2, bArr, this.width * i3, this.width);
                i2 += this.pdi;
            }
            return bArr;
        } catch (Exception e) {
            w.e("MicroMsg.scanner.PlanarYUVLuminanceSource", " yuvData.len:" + this.pdh.length + " dataWidth:" + this.pdi + " dataHeight:" + this.pdj + " left:" + this.left + " top:" + this.top + " width:" + this.width + " height:" + this.height + " tStr:" + e.toString());
            return null;
        }
    }

    public final byte[] aYY() {
        if (this.width == this.pdi && this.height == this.pdj) {
            return this.pdh;
        }
        try {
            int i = this.width * this.height;
            byte[] bArr = new byte[i];
            int i2 = (this.top * this.pdi) + this.left;
            if (this.width == this.pdi) {
                System.arraycopy(this.pdh, i2, bArr, 0, i);
                return bArr;
            }
            Object obj = this.pdh;
            for (int i3 = 0; i3 < this.height; i3++) {
                System.arraycopy(obj, i2, bArr, this.width * i3, this.width);
                i2 += this.pdi;
            }
            return bArr;
        } catch (Exception e) {
            w.e("MicroMsg.scanner.PlanarYUVLuminanceSource", " yuvData.len:" + this.pdh.length + " dataWidth:" + this.pdi + " dataHeight:" + this.pdj + " left:" + this.left + " top:" + this.top + " width:" + this.width + " height:" + this.height + " tStr:" + e.toString());
            return null;
        }
    }
}
