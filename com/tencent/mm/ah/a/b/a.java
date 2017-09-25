package com.tencent.mm.ah.a.b;

import com.tencent.mm.a.e;
import com.tencent.mm.ah.a.a.c;
import com.tencent.mm.ah.a.c.f;
import com.tencent.mm.ah.a.g.b;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class a implements com.tencent.mm.ah.a.c.a {
    private f hJn;

    private String a(String str, c cVar) {
        String str2 = cVar.hIN;
        if (str2 == null || str2.length() == 0) {
            str2 = cVar.hIO;
            if (!(str2 == null || str2.length() == 0)) {
                str2 = str2 + File.separator + this.hJn.jJ(str);
            }
        }
        if (cVar.hIK && bg.mA(r0)) {
            str2 = b.Hi() + File.separator + this.hJn.jJ(str);
        }
        if (str2 == null || str2.length() == 0) {
            return null;
        }
        return str2;
    }

    private String b(String str, c cVar) {
        String str2 = cVar.hIP;
        if (str2 == null || str2.length() == 0) {
            String str3 = cVar.hIN;
            if (str3 != null && str3.length() > 0) {
                str2 = cVar.hIO;
                if (str2 == null || str2.length() == 0 || !str3.startsWith(str2)) {
                    w.e("MicroMsg.imageloader.DefaultImageDiskCache", "[johnw] SFS can't deal with absolute path: %s", str3);
                    throw new IllegalArgumentException("SFS can't deal with absolute path: " + str3);
                }
                str2 = str3.substring(str2.length());
                if (str2.startsWith("/")) {
                    str2 = str2.substring(1);
                }
            }
        }
        if (str2 == null || str2.length() == 0) {
            str2 = this.hJn.jJ(str);
        }
        if (str2 == null || str2.length() == 0) {
            return null;
        }
        return str2;
    }

    public final boolean a(String str, byte[] bArr, c cVar) {
        SFSContext sFSContext = cVar.hJg;
        if (sFSContext != null) {
            String b = b(str, cVar);
            if (b == null) {
                return false;
            }
            OutputStream outputStream = null;
            try {
                if (sFSContext.mNativePtr == 0) {
                    throw new IllegalArgumentException("Reuse already released SFSContext.");
                }
                String str2 = "";
                if (com.tencent.mm.modelsfs.f.kp(b)) {
                    str2 = com.tencent.mm.modelsfs.f.ks(b);
                    b = com.tencent.mm.modelsfs.f.kq(b);
                }
                outputStream = sFSContext.ah(b, str2);
                outputStream.write(bArr);
                try {
                    outputStream.close();
                } catch (IOException e) {
                }
            } catch (IOException e2) {
                if (outputStream == null) {
                    return false;
                }
                try {
                    outputStream.close();
                    return false;
                } catch (IOException e3) {
                    return false;
                }
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                    }
                }
            }
        } else {
            String a = a(str, cVar);
            if (a == null) {
                return false;
            }
            File parentFile = new File(a).getParentFile();
            if (!(parentFile == null || parentFile.exists())) {
                parentFile.mkdirs();
            }
            parentFile = new File(a);
            if (!parentFile.exists()) {
                try {
                    parentFile.createNewFile();
                } catch (Throwable e5) {
                    w.i("MicroMsg.imageloader.DefaultImageDiskCache", bg.g(e5));
                }
            }
            if (bArr != null && e.b(a, bArr, bArr.length) < 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean c(String str, c cVar) {
        SFSContext sFSContext = cVar.hJg;
        if (sFSContext != null) {
            String b = b(str, cVar);
            if (b == null) {
                return false;
            }
            return sFSContext.gR(b);
        }
        String a = a(str, cVar);
        if (a != null) {
            return new File(a).delete();
        }
        return false;
    }

    public final void Hh() {
        b.Hk();
    }

    public final InputStream d(String str, c cVar) {
        try {
            SFSContext sFSContext = cVar.hJg;
            String b;
            if (sFSContext != null) {
                b = b(str, cVar);
                if (b == null) {
                    return null;
                }
                return sFSContext.openRead(b);
            }
            b = a(str, cVar);
            if (b != null) {
                return new FileInputStream(b);
            }
            return null;
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public final void a(f fVar) {
        this.hJn = fVar;
    }
}
