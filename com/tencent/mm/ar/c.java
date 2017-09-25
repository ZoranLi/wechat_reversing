package com.tencent.mm.ar;

import android.graphics.Bitmap;
import com.tencent.mm.a.g;
import com.tencent.mm.a.o;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class c {
    private static c hPb;
    private ar hPc = null;

    public interface a {
        void bl(boolean z);
    }

    class b implements com.tencent.mm.sdk.platformtools.ar.a {
        private String hIN;
        private String hPd;
        private a hPe;
        final /* synthetic */ c hPf;
        private boolean success = false;
        private String username;

        public b(c cVar, String str, String str2, a aVar) {
            this.hPf = cVar;
            this.username = str;
            this.hPd = str2;
            this.hPe = aVar;
        }

        public final boolean Bn() {
            t a;
            Throwable e;
            t tVar;
            OutputStream outputStream;
            InputStream inputStream = null;
            if (bg.mA(this.username)) {
                return false;
            }
            this.hIN = c.jU(this.username);
            String str = "";
            if (h.vG().uV()) {
                r4 = new Object[4];
                h.vG();
                r4[1] = o.getString(com.tencent.mm.kernel.a.uH());
                r4[2] = Integer.valueOf(am.getNetTypeForStat(ab.getContext()));
                r4[3] = Integer.valueOf(am.getStrength(ab.getContext()));
                str = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d", r4);
            }
            w.d("MicroMsg.RemarkImageStorage", "get remark image user: %s referer: %s  url:%s", this.username, str, this.hPd);
            this.success = false;
            try {
                a = com.tencent.mm.network.b.a(this.hPd, null);
                try {
                    a.setRequestMethod("GET");
                    a.setRequestProperty("referer", str);
                    a.setConnectTimeout(Downloads.MIN_RETYR_AFTER);
                    a.setReadTimeout(Downloads.MIN_RETYR_AFTER);
                    if (com.tencent.mm.network.b.a(a) != 0) {
                        w.e("MicroMsg.RemarkImageStorage", "checkHttpConnection failed! url:%s", this.hPd);
                        try {
                            a.ieZ.disconnect();
                        } catch (Throwable e2) {
                            w.e("MicroMsg.RemarkImageStorage", "exception:%s", bg.g(e2));
                        }
                        return true;
                    }
                    InputStream inputStream2 = a.getInputStream();
                    if (inputStream2 == null) {
                        try {
                            w.d("MicroMsg.RemarkImageStorage", "getInputStream failed. url:%s", this.hPd);
                            try {
                                a.ieZ.disconnect();
                            } catch (Throwable e22) {
                                w.e("MicroMsg.RemarkImageStorage", "exception:%s", bg.g(e22));
                            }
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Throwable e222) {
                                    w.e("MicroMsg.RemarkImageStorage", "exception:%s", bg.g(e222));
                                }
                            }
                            return true;
                        } catch (Exception e3) {
                            e222 = e3;
                            tVar = a;
                            inputStream = inputStream2;
                            Object obj = null;
                            try {
                                w.e("MicroMsg.RemarkImageStorage", "exception:%s", bg.g(e222));
                                this.success = false;
                                if (tVar != null) {
                                    try {
                                        tVar.ieZ.disconnect();
                                    } catch (Throwable e2222) {
                                        w.e("MicroMsg.RemarkImageStorage", "exception:%s", bg.g(e2222));
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable e22222) {
                                        w.e("MicroMsg.RemarkImageStorage", "exception:%s", bg.g(e22222));
                                    }
                                }
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (Throwable e222222) {
                                        w.e("MicroMsg.RemarkImageStorage", "exception:%s", bg.g(e222222));
                                    }
                                }
                                return true;
                            } catch (Throwable th) {
                                e222222 = th;
                                a = tVar;
                                if (a != null) {
                                    try {
                                        a.ieZ.disconnect();
                                    } catch (Throwable e4) {
                                        w.e("MicroMsg.RemarkImageStorage", "exception:%s", bg.g(e4));
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable e5) {
                                        w.e("MicroMsg.RemarkImageStorage", "exception:%s", bg.g(e5));
                                    }
                                }
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (Throwable e52) {
                                        w.e("MicroMsg.RemarkImageStorage", "exception:%s", bg.g(e52));
                                    }
                                }
                                throw e222222;
                            }
                        } catch (Throwable th2) {
                            e222222 = th2;
                            InputStream inputStream3 = inputStream2;
                            outputStream = null;
                            inputStream = inputStream3;
                            if (a != null) {
                                a.ieZ.disconnect();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            throw e222222;
                        }
                    }
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    OutputStream fileOutputStream = new FileOutputStream(this.hIN + ".tmp");
                    while (true) {
                        try {
                            int read = inputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        } catch (Exception e6) {
                            e222222 = e6;
                            inputStream = inputStream2;
                            outputStream = fileOutputStream;
                            tVar = a;
                        } catch (Throwable th3) {
                            e222222 = th3;
                            inputStream = inputStream2;
                            outputStream = fileOutputStream;
                        }
                    }
                    this.success = true;
                    try {
                        a.ieZ.disconnect();
                    } catch (Throwable e2222222) {
                        w.e("MicroMsg.RemarkImageStorage", "exception:%s", bg.g(e2222222));
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Throwable e22222222) {
                            w.e("MicroMsg.RemarkImageStorage", "exception:%s", bg.g(e22222222));
                        }
                    }
                    try {
                        fileOutputStream.close();
                    } catch (Throwable e222222222) {
                        w.e("MicroMsg.RemarkImageStorage", "exception:%s", bg.g(e222222222));
                    }
                    return true;
                } catch (Exception e7) {
                    e222222222 = e7;
                    outputStream = null;
                    tVar = a;
                    w.e("MicroMsg.RemarkImageStorage", "exception:%s", bg.g(e222222222));
                    this.success = false;
                    if (tVar != null) {
                        tVar.ieZ.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    return true;
                } catch (Throwable th4) {
                    e222222222 = th4;
                    outputStream = null;
                    if (a != null) {
                        a.ieZ.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    throw e222222222;
                }
            } catch (Exception e8) {
                e222222222 = e8;
                outputStream = null;
                tVar = null;
                w.e("MicroMsg.RemarkImageStorage", "exception:%s", bg.g(e222222222));
                this.success = false;
                if (tVar != null) {
                    tVar.ieZ.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                return true;
            } catch (Throwable th5) {
                e222222222 = th5;
                outputStream = null;
                a = null;
                if (a != null) {
                    a.ieZ.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                throw e222222222;
            }
        }

        public final boolean Bo() {
            if (this.success) {
                com.tencent.mm.loader.stub.b.deleteFile(this.hIN);
                new File(this.hIN + ".tmp").renameTo(new File(this.hIN));
                this.hPe.bl(true);
                return true;
            }
            this.hPe.bl(false);
            return false;
        }
    }

    public static c Ih() {
        if (hPb == null) {
            hPb = new c();
        }
        return hPb;
    }

    private c() {
    }

    public static String jU(String str) {
        if (bg.mA(str)) {
            return null;
        }
        return com.tencent.mm.sdk.platformtools.h.a(com.tencent.mm.plugin.ab.a.xd(), "remark_", g.n((str + "ZnVjaw==").getBytes()), ".png", 1);
    }

    public static boolean jV(String str) {
        w.d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", str, jU(str));
        return new File(jU(str)).exists();
    }

    public static boolean jW(String str) {
        w.d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", str, jU(str));
        return com.tencent.mm.loader.stub.b.deleteFile(jU(str));
    }

    public final Bitmap jX(String str) {
        int i = 0;
        Bitmap O = d.O(jU(str), 0, 0);
        if (!(O == null || O.isRecycled())) {
            i = 1;
        }
        return i != 0 ? O : null;
    }

    public final void a(String str, String str2, a aVar) {
        if (!bg.mA(str2) && !jV(str)) {
            if (this.hPc == null || this.hPc.bJx()) {
                this.hPc = new ar(1, "download-remark-img", 1);
            }
            this.hPc.c(new b(this, str, str2, aVar));
        }
    }
}
