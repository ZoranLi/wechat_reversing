package com.tencent.mm.ah.a.f;

import android.graphics.Bitmap;
import com.tencent.mm.ah.a.a.c;
import com.tencent.mm.ah.a.c.a;
import com.tencent.mm.ah.a.c.d;
import com.tencent.mm.ah.a.c.e;
import com.tencent.mm.ah.a.c.f;
import com.tencent.mm.ah.a.c.g;
import com.tencent.mm.ah.a.c.i;
import com.tencent.mm.ah.a.c.j;
import com.tencent.mm.ah.a.c.k;
import com.tencent.mm.ah.a.c.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;
import java.io.InputStream;

public final class b implements Runnable {
    private final a hIA;
    private final com.tencent.mm.ah.a.c.b hIB;
    private final f hIC;
    private final j hID;
    private final e hIF;
    private final com.tencent.mm.ah.a.a.b hIg = this.hJr.hIg;
    public final c hIy;
    private final l hIz;
    private final com.tencent.mm.ah.a.b hJr;
    public final com.tencent.mm.ah.a.c hJt;
    private final ae hJu;
    private final i hJv;
    private final g hJw;
    private final k hJx;
    private final d hJy;
    public final String url;

    public b(String str, com.tencent.mm.ah.a.c cVar, ae aeVar, c cVar2, i iVar, j jVar, com.tencent.mm.ah.a.b bVar, g gVar, e eVar, d dVar) {
        this.url = str;
        this.hJt = cVar;
        this.hJu = aeVar;
        this.hJr = bVar;
        this.hJw = gVar;
        if (cVar2 == null) {
            this.hIy = this.hIg.hIy;
        } else {
            this.hIy = cVar2;
        }
        this.hJv = iVar;
        if (jVar == null) {
            this.hID = this.hIg.hID;
        } else {
            this.hID = jVar;
        }
        if (this.hIy.hIB != null) {
            this.hIB = this.hIy.hIB;
        } else {
            this.hIB = this.hIg.hIB;
        }
        this.hIz = this.hIg.hIz;
        this.hIA = this.hIg.hIA;
        this.hIC = this.hIg.hIC;
        this.hJx = this.hIg.hIE;
        if (eVar == null) {
            this.hIF = this.hIg.hIF;
        } else {
            this.hIF = eVar;
        }
        this.hJy = dVar;
    }

    public final void run() {
        Bitmap bitmap = null;
        com.tencent.mm.ah.a.d.b bVar = new com.tencent.mm.ah.a.d.b();
        Exception e;
        Bitmap bitmap2;
        com.tencent.mm.ah.a.d.b bVar2;
        InputStream inputStream;
        try {
            Bitmap b;
            long currentTimeMillis;
            String jL = jL(this.url);
            w.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap from disk. key:%s", this.url);
            long currentTimeMillis2 = System.currentTimeMillis();
            int i = this.hIy.hIQ;
            boolean z = this.hIy.hIT;
            String str = this.hIy.fFW;
            w.d("MicroMsg.imageloader.ImageLoadTask", "hy: should check md5:" + z);
            w.d("MicroMsg.imageloader.ImageLoadTask", "hy: fileType: %d", Integer.valueOf(i));
            w.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] test view width:%d height:%d", Integer.valueOf(this.hJt.width), Integer.valueOf(this.hJt.height));
            switch (i) {
                case 1:
                    String str2 = this.hIy.fKz;
                    if (!this.hIy.hIX || bg.mA(str2) || !com.tencent.mm.a.e.aO(str2)) {
                        if (!bg.mA(this.url)) {
                            if (!com.tencent.mm.a.e.aO(this.url)) {
                                if (this.hIy.hIY) {
                                    this.hIF.d(this.hIy.hJm);
                                }
                                w.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] file does not exist.");
                                break;
                            }
                            if (z) {
                                if (!this.hJx.ac(str, this.url)) {
                                    w.w("MicroMsg.imageloader.ImageLoadTask", "hy: file md5 check failed");
                                    bitmap = null;
                                    break;
                                }
                            }
                            if (this.hIy.hJk) {
                                b = com.tencent.mm.ah.a.g.a.b(this.hJt, this.url, this.hIy.hIR, this.hIy.hIS);
                            } else if (this.hJy != null) {
                                b = com.tencent.mm.ah.a.g.a.a(this.hJt, this.hJy.e(this.hIy.hJm), this.hIy.hIR, this.hIy.hIS, this.hIy.hIZ, this.hIy.alpha, this.hIy.hIU);
                            } else {
                                b = com.tencent.mm.ah.a.g.a.a(this.hJt, this.url, this.hIy.hIR, this.hIy.hIS);
                            }
                            if (this.hIy.density > 0) {
                                b.setDensity(this.hIy.density);
                            }
                            w.d("MicroMsg.imageloader.ImageLoadTask", "hy: file md5 check success or do not need md5 check");
                            bitmap = b;
                            break;
                        }
                        w.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] url is null.");
                        break;
                    }
                    if (this.hIy.hJk) {
                        b = com.tencent.mm.ah.a.g.a.b(this.hJt, str2, this.hIy.hIR, this.hIy.hIS);
                    } else {
                        b = com.tencent.mm.ah.a.g.a.a(this.hJt, str2, this.hIy.hIR, this.hIy.hIS);
                    }
                    try {
                        if (this.hIy.density <= 0) {
                            bitmap = b;
                            break;
                        }
                        b.setDensity(this.hIy.density);
                        bitmap = b;
                        break;
                    } catch (Exception e2) {
                        e = e2;
                        bitmap2 = b;
                        bVar2 = bVar;
                        break;
                    }
                case 2:
                    bitmap = com.tencent.mm.ah.a.g.a.c(this.hJt, this.url, this.hIy.hIR, this.hIy.hIS);
                    break;
                case 3:
                    bitmap = com.tencent.mm.ah.a.g.a.a(this.hJt, this.hIg.hIv.getIdentifier(this.url, "drawable", this.hIg.packageName), this.hIy.hIR, this.hIy.hIS);
                    break;
                case 4:
                    bitmap = com.tencent.mm.ah.a.g.a.a(this.hJt, Integer.valueOf(this.url).intValue(), this.hIy.hIR, this.hIy.hIS);
                    break;
                case 5:
                    inputStream = null;
                    Object obj = null;
                    inputStream = this.hIA.d(this.url, this.hIy);
                    if (inputStream == null) {
                        bitmap2 = null;
                    } else if (!z || this.hJx.a(str, inputStream)) {
                        Bitmap a;
                        com.tencent.mm.ah.a.c cVar = this.hJt;
                        int i2 = this.hIy.hIR;
                        int i3 = this.hIy.hIS;
                        boolean z2 = this.hIy.hIZ;
                        float f = this.hIy.alpha;
                        boolean z3 = this.hIy.hIU;
                        if (i2 > 0 && i3 > 0) {
                            a = com.tencent.mm.sdk.platformtools.d.a(inputStream, 0.0f, i2, i3);
                        } else if (cVar == null || cVar.width <= 0 || cVar.width <= 0) {
                            a = com.tencent.mm.sdk.platformtools.d.decodeStream(inputStream);
                        } else {
                            a = com.tencent.mm.sdk.platformtools.d.a(inputStream, 0.0f, cVar.width, cVar.height);
                        }
                        if (z2) {
                            a = com.tencent.mm.sdk.platformtools.d.a(a, i2, i3, false, true);
                        }
                        if (f > 0.0f) {
                            a = com.tencent.mm.sdk.platformtools.d.c(a, f);
                        }
                        if (z3) {
                            a = com.tencent.mm.sdk.platformtools.d.M(a);
                        }
                        bitmap2 = a;
                        obj = 1;
                    } else {
                        obj = 1;
                        bitmap2 = null;
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (obj != null && bitmap2 == null) {
                        try {
                            this.hIA.c(this.url, this.hIy);
                            bitmap = bitmap2;
                            break;
                        } catch (Exception e4) {
                            e = e4;
                            bVar2 = bVar;
                            break;
                        }
                    }
                    bitmap = bitmap2;
                    break;
                    break;
                default:
                    w.e("MicroMsg.imageloader.ImageLoadTask", "[cpan] unknow file type :%d", Integer.valueOf(i));
                    break;
            }
            try {
                currentTimeMillis = System.currentTimeMillis();
            } catch (Exception e5) {
                e = e5;
                bVar2 = bVar;
                bitmap2 = bitmap;
            }
            Bitmap bitmap3;
            String str3;
            int min;
            i iVar;
            com.tencent.mm.ah.a.b bVar3;
            if (bitmap == null || bitmap.isRecycled()) {
                switch (i) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        w.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] run get bitmap failed");
                        bitmap3 = bitmap;
                        break;
                    case 5:
                        currentTimeMillis2 = System.currentTimeMillis();
                        w.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap from memory failed.now try to get from network.");
                        if (this.hJw != null) {
                            g gVar = this.hJw;
                            str3 = this.url;
                            this.hJt.Bf();
                            gVar.jK(str3);
                        }
                        bVar2 = this.hIB.jI(this.url);
                        if (bVar2 == null) {
                            try {
                                bVar = new com.tencent.mm.ah.a.d.b(null, null);
                            } catch (Exception e6) {
                                e = e6;
                                bitmap2 = bitmap;
                                break;
                            }
                        }
                        bVar = bVar2;
                        try {
                            if (bVar.data != null) {
                                if (z) {
                                    if (!this.hJx.j(str, bVar.data)) {
                                        bVar.status = 2;
                                        w.w("MicroMsg.imageloader.ImageLoadTask", "hy: image data md5 check failed");
                                        bitmap3 = null;
                                        break;
                                    }
                                }
                                w.d("MicroMsg.imageloader.ImageLoadTask", "hy: image data md5 check success or do not need md5 check");
                                long currentTimeMillis3 = System.currentTimeMillis();
                                b = com.tencent.mm.ah.a.g.a.a(this.hJt, bVar.data, this.hIy.hIR, this.hIy.hIS, this.hIy.hIZ, this.hIy.alpha, this.hIy.hIU);
                                if (b != null) {
                                    byte[] bArr = bVar.data;
                                    if (this.hIy.hIL) {
                                        this.hIA.a(this.url, bArr, this.hIy);
                                    }
                                    if (this.hIy.hIK) {
                                        this.hIA.a(this.url, bArr, this.hIy);
                                    }
                                    if (this.hIy.hJi) {
                                        if (this.hIy.hJj != 0.0f) {
                                            b = com.tencent.mm.sdk.platformtools.d.a(b, false, this.hIy.hJj);
                                        } else if (b.getWidth() == b.getHeight()) {
                                            b = com.tencent.mm.sdk.platformtools.d.a(b, false, (float) (b.getWidth() / 2));
                                        } else {
                                            min = Math.min(b.getWidth(), b.getHeight());
                                            if (min <= 0) {
                                                min = Math.max(b.getWidth(), b.getHeight());
                                            }
                                            b = com.tencent.mm.sdk.platformtools.d.a(b, min, min, true);
                                            b = com.tencent.mm.sdk.platformtools.d.a(b, false, (float) (b.getWidth() / 2));
                                        }
                                    }
                                    i(jL, b);
                                    ao(currentTimeMillis3 - currentTimeMillis2);
                                    bitmap3 = b;
                                    break;
                                }
                                try {
                                    bVar.status = 3;
                                    bitmap3 = b;
                                    break;
                                } catch (Exception e7) {
                                    e = e7;
                                    bitmap2 = b;
                                    bVar2 = bVar;
                                    break;
                                }
                            }
                            bVar.status = 1;
                            bitmap3 = bitmap;
                            break;
                        } catch (Exception e8) {
                            e = e8;
                            bVar2 = bVar;
                            bitmap2 = bitmap;
                            break;
                        }
                    default:
                        w.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] run unknow file type");
                        bitmap3 = bitmap;
                        break;
                }
                w.e("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. exception. %s", e.toString());
                bVar = bVar2;
                bitmap3 = bitmap2;
                if (bitmap3 != null || bitmap3.isRecycled()) {
                    w.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap failed");
                } else {
                    w.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap successs.");
                    if (this.hIy.hIV) {
                        bitmap3 = com.tencent.mm.sdk.platformtools.d.c(bitmap3, this.hIy.hIW);
                    }
                    Runnable cVar2 = new c(this.url, this.hJt, bitmap3, this.hJr, jL(this.url));
                    if (this.hJu != null) {
                        this.hJu.post(cVar2);
                    }
                    bVar.bitmap = bitmap3;
                }
                if (!(this.hJw == null || bVar == null)) {
                    bVar.bitmap = bitmap3;
                    this.hJw.a(this.url, this.hJt.Bf(), bVar);
                }
                iVar = this.hJv;
                str3 = this.url;
                this.hJt.Bf();
                iVar.a(str3, bitmap3, this.hIy.hJm);
                bVar3 = this.hJr;
                if (bVar3.hIk != null && this != null && this.hJt != null) {
                    bVar3.hIk.remove(Integer.valueOf(this.hJt.He()));
                    return;
                }
                return;
            }
            if (!this.hIy.hJi) {
                b = bitmap;
            } else if (this.hIy.hJj != 0.0f) {
                b = com.tencent.mm.sdk.platformtools.d.a(bitmap, false, this.hIy.hJj);
            } else if (bitmap.getWidth() == bitmap.getHeight()) {
                b = com.tencent.mm.sdk.platformtools.d.a(bitmap, false, (float) (bitmap.getWidth() / 2));
            } else {
                min = Math.min(bitmap.getWidth(), bitmap.getHeight());
                if (min <= 0) {
                    min = Math.max(bitmap.getWidth(), bitmap.getHeight());
                }
                b = com.tencent.mm.sdk.platformtools.d.a(bitmap, min, min, true);
                b = com.tencent.mm.sdk.platformtools.d.a(b, false, (float) (b.getWidth() / 2));
            }
            i(jL, b);
            ao(currentTimeMillis - currentTimeMillis2);
            w.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap from disk success.");
            bitmap3 = b;
            if (bitmap3 != null) {
            }
            w.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap failed");
            bVar.bitmap = bitmap3;
            this.hJw.a(this.url, this.hJt.Bf(), bVar);
            iVar = this.hJv;
            str3 = this.url;
            this.hJt.Bf();
            iVar.a(str3, bitmap3, this.hIy.hJm);
            bVar3 = this.hJr;
            if (bVar3.hIk != null) {
            }
        } catch (Exception e9) {
            e = e9;
            bVar2 = bVar;
            bitmap2 = null;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e10) {
                }
            }
        }
    }

    private void i(String str, Bitmap bitmap) {
        if (this.hIy.hIJ) {
            w.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. put key %s to memory cache.", this.url);
            this.hIz.b(str, bitmap);
        }
    }

    public final String jL(String str) {
        if (bg.mA(str) || this.hIy == null) {
            return null;
        }
        if (this.hIy.hJi) {
            str = str + "round" + this.hIy.hJj;
        }
        return str + "size" + this.hIy.hIR + this.hIy.hIS;
    }

    public final void ao(long j) {
        if (this.hID != null) {
            this.hID.ao(j);
        }
    }
}
