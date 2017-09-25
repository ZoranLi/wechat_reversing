package com.tencent.mm.modelvoice;

import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class a implements b {
    private String fyF = "";
    private RandomAccessFile ibc = null;

    public a(String str) {
        this.fyF = str;
    }

    public final void Lu() {
        if (this.ibc != null) {
            try {
                this.ibc.close();
                this.ibc = null;
                w.d("MicroMsg.AmrFileOperator", "Close :" + this.fyF);
            } catch (IOException e) {
            }
        }
    }

    private boolean lO(String str) {
        boolean z;
        Assert.assertTrue(this.fyF.length() >= 0);
        if (this.ibc == null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (str.equals("r") || str.equals("rw")) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        w.d("MicroMsg.AmrFileOperator", "Open file:" + this.ibc + " mode:" + str);
        try {
            this.ibc = new RandomAccessFile(this.fyF, str);
            return true;
        } catch (Exception e) {
            w.e("MicroMsg.AmrFileOperator", "ERR: OpenFile[" + this.fyF + "] failed:[" + e.getMessage() + "]");
            this.ibc = null;
            return false;
        }
    }

    public final g bd(int i, int i2) {
        g gVar = new g();
        if (i < 0 || i2 <= 0) {
            gVar.ret = -3;
        } else if (this.ibc != null || lO("r")) {
            int i3 = i + 6;
            gVar.buf = new byte[i2];
            try {
                long length = this.ibc.length();
                this.ibc.seek((long) i3);
                int read = this.ibc.read(gVar.buf, 0, i2);
                w.d("MicroMsg.AmrFileOperator", "DBG: ReadFile[" + this.fyF + "] readOffset:" + i3 + " readRet:" + read + " fileNow:" + this.ibc.getFilePointer() + " fileSize:" + length);
                if (read < 0) {
                    read = 0;
                }
                gVar.fAK = read;
                gVar.iaP = (read + i3) - 6;
                gVar.ret = 0;
            } catch (Exception e) {
                w.e("MicroMsg.AmrFileOperator", "ERR: ReadFile[" + this.fyF + "] Offset:" + i3 + "  failed:[" + e.getMessage() + "] ");
                Lu();
                gVar.ret = -1;
            }
        } else {
            gVar.ret = -2;
        }
        return gVar;
    }

    public final int write(byte[] bArr, int i, int i2) {
        boolean z = true;
        boolean z2 = bArr.length > 0 && i > 0;
        Assert.assertTrue(z2);
        if (this.ibc == null && !lO("rw")) {
            return -1;
        }
        if (i2 == 0) {
            try {
                this.ibc.write("#!AMR\n".getBytes(), 0, 6);
            } catch (Exception e) {
                w.e("MicroMsg.AmrFileOperator", "ERR: WriteHeadToFile[" + this.fyF + "] failed:[" + e.getMessage() + "]");
                Lu();
                return -2;
            }
        }
        int i3 = i2 + 6;
        try {
            this.ibc.seek((long) i3);
            this.ibc.write(bArr, 0, i);
            i3 += i;
            if (((int) this.ibc.getFilePointer()) == i3) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assert.assertTrue(z2);
            int i4 = i3 - 6;
            if (i4 < 0) {
                z = false;
            }
            Assert.assertTrue(z);
            return i4;
        } catch (Exception e2) {
            w.e("MicroMsg.AmrFileOperator", "ERR: WriteFile[" + this.fyF + "] Offset:" + i3 + " failed:[" + e2.getMessage() + "]");
            Lu();
            return -3;
        }
    }

    public final int getFormat() {
        return 0;
    }
}
