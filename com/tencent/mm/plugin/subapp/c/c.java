package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class c {
    private String fyF = "";
    private RandomAccessFile ibc = null;

    public static class a {
        public byte[] buf = null;
        public int fAK = 0;
        public int iaP = 0;
        public int ret = 0;
    }

    public c(String str) {
        this.fyF = str;
    }

    public static int lx(String str) {
        Assert.assertTrue(str.length() >= 0);
        File file = new File(str);
        if (!file.exists()) {
            return 0;
        }
        int length = (int) file.length();
        if (length > 0) {
            return length;
        }
        return 0;
    }

    public final void Lu() {
        if (this.ibc != null) {
            try {
                this.ibc.close();
                this.ibc = null;
                w.d("MicroMsg.SpxFileOperator", "Close :" + this.fyF);
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
        w.d("MicroMsg.SpxFileOperator", "Open file:" + this.ibc + " mode:" + str);
        try {
            this.ibc = new RandomAccessFile(this.fyF, str);
            return true;
        } catch (Exception e) {
            w.e("MicroMsg.SpxFileOperator", "ERR: OpenFile[" + this.fyF + "] failed:[" + e.getMessage() + "]");
            this.ibc = null;
            return false;
        }
    }

    public final a uv(int i) {
        a aVar = new a();
        if (i < 0) {
            aVar.ret = -3;
        } else if (this.ibc != null || lO("r")) {
            aVar.buf = new byte[6000];
            try {
                long length = this.ibc.length();
                this.ibc.seek((long) i);
                int read = this.ibc.read(aVar.buf, 0, 6000);
                w.d("MicroMsg.SpxFileOperator", "DBG: ReadFile[" + this.fyF + "] readOffset:" + i + " readRet:" + read + " fileNow:" + this.ibc.getFilePointer() + " fileSize:" + length);
                if (read < 0) {
                    read = 0;
                }
                aVar.fAK = read;
                aVar.iaP = read + i;
                aVar.ret = 0;
            } catch (Exception e) {
                w.e("MicroMsg.SpxFileOperator", "ERR: ReadFile[" + this.fyF + "] Offset:" + i + "  failed:[" + e.getMessage() + "] ");
                Lu();
                aVar.ret = -1;
            }
        } else {
            aVar.ret = -2;
        }
        return aVar;
    }
}
