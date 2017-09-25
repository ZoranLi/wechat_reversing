package com.tencent.mm.plugin.scanner.util;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.mm.compatible.d.c;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.nr;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.qbar.QbarNative;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class d extends b {
    private static QbarNative pdl = new QbarNative();
    private Object hvG = new Object();
    private int mMode = 0;
    public boolean mdU = false;
    public boolean nDJ = true;
    public boolean pag = false;
    private boolean pdk = false;
    private byte[] pdm;
    byte[] pdn;
    private int pdo = 0;
    private i pdp = new i();

    public d(a aVar, int i, boolean z) {
        super(aVar);
        this.mMode = i;
        this.nDJ = z;
    }

    public final boolean a(byte[] bArr, Point point, Rect rect) {
        w.i("MicroMsg.scanner.QBarDecoder", "decode, isNeedFocus: %s", new Object[]{Boolean.valueOf(this.pdp.a(bArr, point, rect, this.nDJ))});
        b nrVar = new nr();
        nrVar.fUN.fUO = r0;
        com.tencent.mm.sdk.b.a.urY.m(nrVar);
        long currentTimeMillis = System.currentTimeMillis();
        boolean a = a(bArr, point, rect, false, true);
        this.pdo++;
        if (!a && System.currentTimeMillis() - currentTimeMillis <= 80) {
            a = a(bArr, point, rect, true, false);
            this.pdo = 0;
        }
        if (a || this.pdo < 3) {
            return a;
        }
        a = a(bArr, point, rect, true, false);
        this.pdo = 0;
        return a;
    }

    private boolean a(byte[] bArr, Point point, Rect rect, boolean z, boolean z2) {
        long currentTimeMillis = System.currentTimeMillis();
        w.i("MicroMsg.scanner.QBarDecoder", "decode() start");
        if (this.mdU) {
            w.e("MicroMsg.scanner.QBarDecoder", "is decoding, return false");
            return false;
        } else if (this.pag) {
            w.w("MicroMsg.scanner.QBarDecoder", "isReleasing, return false 1");
            return false;
        } else if (bArr == null || point == null || rect == null) {
            w.e("MicroMsg.scanner.QBarDecoder", "wrong args");
            return false;
        } else {
            this.mdU = true;
            this.pcY = null;
            this.fFp = 0;
            this.fFo = 0;
            if (z2) {
                l.oWo.aYb();
            }
            try {
                synchronized (this.hvG) {
                    int height;
                    Rect rect2 = new Rect();
                    int width;
                    if (c.rh() || this.nDJ) {
                        width = rect.width() % 4;
                        height = rect.height() % 4;
                        rect2.left = rect.left;
                        rect2.right = rect.right - width;
                        rect2.top = rect.top;
                        rect2.bottom = rect.bottom - height;
                        if (rect2.right <= rect2.left || rect2.bottom <= rect2.top) {
                            this.mdU = false;
                            return false;
                        }
                    }
                    rect2.left = (point.x / 2) - rect.height();
                    rect2.right = (point.x / 2) + rect.height();
                    rect2.top = (point.y / 2) - (rect.width() / 2);
                    rect2.bottom = (point.y / 2) + (rect.width() / 2);
                    if (rect2.left < 0) {
                        rect2.left = 0;
                    }
                    if (rect2.right > point.x - 1) {
                        rect2.right = point.x - 1;
                    }
                    if (rect2.top < 0) {
                        rect2.top = 0;
                    }
                    if (rect2.bottom > point.y - 1) {
                        rect2.bottom = point.y - 1;
                    }
                    width = rect2.width() % 4;
                    height = rect2.height() % 4;
                    if (width != 0) {
                        rect2.right -= width;
                    }
                    if (height != 0) {
                        rect2.bottom -= height;
                    }
                    if (rect2.right <= rect2.left || rect2.bottom <= rect2.top) {
                        this.mdU = false;
                        return false;
                    }
                    if (cO(this.mMode, 0)) {
                        c cVar = new c(bArr, point.x, point.y, rect2);
                        int[] iArr = new int[]{cVar.width, cVar.height};
                        int i = 0;
                        if (!(c.rh() || z)) {
                            i = 90;
                            iArr[0] = cVar.height;
                            iArr[1] = cVar.width;
                        }
                        w.d("MicroMsg.scanner.QBarDecoder", "rotate angle: " + i);
                        if (this.pdm == null) {
                            this.pdm = new byte[(((cVar.width * cVar.height) * 3) / 2)];
                            this.pdn = new byte[(cVar.width * cVar.height)];
                            w.d("MicroMsg.scanner.QBarDecoder", "tempOutBytes = null, new byte[%s]", new Object[]{Integer.valueOf(((cVar.width * cVar.height) * 3) / 2)});
                        } else if (this.pdm.length != ((cVar.width * cVar.height) * 3) / 2) {
                            this.pdm = null;
                            this.pdm = new byte[(((cVar.width * cVar.height) * 3) / 2)];
                            this.pdn = null;
                            this.pdn = new byte[(cVar.width * cVar.height)];
                            w.d("MicroMsg.scanner.QBarDecoder", "tempOutBytes size change, new byte[%s]", new Object[]{Integer.valueOf(((cVar.width * cVar.height) * 3) / 2)});
                        }
                        w.d("MicroMsg.scanner.QBarDecoder", "decode prepare , cost:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        if (QbarNative.a(this.pdm, iArr, bArr, point.x, point.y, cVar.left, cVar.top, cVar.width, cVar.height, i) != 1) {
                            w.e("MicroMsg.scanner.QBarDecoder", "decode pro_result %s", new Object[]{Integer.valueOf(QbarNative.a(this.pdm, iArr, bArr, point.x, point.y, cVar.left, cVar.top, cVar.width, cVar.height, i))});
                            this.mdU = false;
                            return false;
                        }
                        long j;
                        System.arraycopy(this.pdm, 0, this.pdn, 0, this.pdn.length);
                        w.d("MicroMsg.scanner.QBarDecoder", "decode, rotate and gray, cost:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        if (this.pdn != null) {
                            w.d("MicroMsg.scanner.QBarDecoder", "tempGrayData.len: %d, width: %d, height: %d", new Object[]{Integer.valueOf(this.pdn.length), Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1])});
                        }
                        if (this.pdn != null) {
                            if (r.ijG) {
                                String str = e.hgu + "testScan/";
                                FileOp.kl(str);
                                FileOp.k((str + r.ijI) + "_" + iArr[0] + "_" + iArr[1], this.pdn);
                                r.ijI = (r.ijI + 1) % r.ijH;
                                w.i("MicroMsg.scanner.QBarDecoder", "save test scan data in file: %s", new Object[]{str});
                            }
                            long currentTimeMillis2 = System.currentTimeMillis();
                            int i2 = pdl.i(this.pdn, iArr[0], iArr[1]);
                            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
                            QbarNative qbarNative = pdl;
                            boolean z3 = (qbarNative.GetPossibleInfo(QbarNative.wPu, qbarNative.wPz) != 0 ? QbarNative.wPu.hasQrcode : 0) != 0;
                            qbarNative = pdl;
                            float f = qbarNative.GetPossibleInfo(QbarNative.wPu, qbarNative.wPz) != 0 ? QbarNative.wPu.qrcodeAreaRatio : 0.0f;
                            w.i("MicroMsg.scanner.QBarDecoder", "after scanImage, result:%d,hasCode: %s, areaRatio: %f", new Object[]{Integer.valueOf(i2), Boolean.valueOf(z3), Float.valueOf(f)});
                            if (i2 <= 0 && z3 && this.pcV != null && f < 0.1f) {
                                Bundle bundle = new Bundle();
                                bundle.putInt("zoom_action", 6);
                                bundle.putInt("zoom_type", 1);
                                bundle.putInt("zoom_scale", (int) (100.0d * Math.sqrt((double) (0.1f / f))));
                                this.pcV.A(bundle);
                            }
                            l.oWo.cL(iArr[0], iArr[1]);
                            l.oWo.aYc();
                            long j2 = currentTimeMillis2;
                            height = i2;
                            j = j2;
                        } else {
                            height = -1;
                            j = 0;
                        }
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        l.oWo.cV(j);
                        w.d("MicroMsg.scanner.QBarDecoder", "decode ScanImage %s, cost:%d", new Object[]{Integer.valueOf(height), Long.valueOf(currentTimeMillis3)});
                        if (height != 1) {
                            this.mdU = false;
                            return false;
                        }
                        l.oWo.aYa();
                        l.oWo.cW(j);
                        aYZ();
                    } else {
                        aKx();
                        this.mdU = false;
                        return false;
                    }
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.scanner.QBarDecoder", e, "decodeInternal error", new Object[0]);
            }
        }
        this.mdU = false;
        w.i("MicroMsg.scanner.QBarDecoder", "decode() finish, resultText = [%s], cost:%d", new Object[]{this.pcY, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        if (bg.mA(this.pcY)) {
            return false;
        }
        return true;
    }

    private boolean cO(int i, int i2) {
        if (this.pdk) {
            return this.pdk;
        }
        Set hashSet = new HashSet();
        if (i == 1) {
            if (i2 != 1) {
                hashSet.add(Integer.valueOf(2));
                hashSet.add(Integer.valueOf(3));
                hashSet.add(Integer.valueOf(4));
                hashSet.add(Integer.valueOf(5));
            } else {
                hashSet.add(Integer.valueOf(2));
                hashSet.add(Integer.valueOf(3));
                hashSet.add(Integer.valueOf(5));
            }
        } else if (i == 2) {
            if (i2 != 1) {
                hashSet.add(Integer.valueOf(0));
                hashSet.add(Integer.valueOf(3));
                hashSet.add(Integer.valueOf(4));
            } else {
                hashSet.add(Integer.valueOf(0));
                hashSet.add(Integer.valueOf(3));
            }
        } else if (i2 != 1) {
            hashSet.add(Integer.valueOf(2));
            hashSet.add(Integer.valueOf(0));
            hashSet.add(Integer.valueOf(3));
            hashSet.add(Integer.valueOf(4));
            hashSet.add(Integer.valueOf(5));
        } else {
            hashSet.add(Integer.valueOf(2));
            hashSet.add(Integer.valueOf(0));
            hashSet.add(Integer.valueOf(3));
            hashSet.add(Integer.valueOf(5));
        }
        return a(i2, hashSet);
    }

    private boolean a(int i, Set<Integer> set) {
        if (!(this.pdk || set == null || set.isEmpty())) {
            QbarNative qbarNative = pdl;
            String str = "ANY";
            String str2 = "UTF-8";
            if (qbarNative.wPz < 0) {
                qbarNative.wPz = qbarNative.Init(2, 0, i, str, str2);
            }
            int i2 = qbarNative.wPz < 0 ? -1 : 1;
            l.oWo.oWD = set.contains(Integer.valueOf(5));
            int[] iArr = new int[set.size()];
            int i3 = 0;
            for (Integer num : set) {
                if (num != null) {
                    int i4 = i3 + 1;
                    iArr[i3] = num.intValue();
                    i3 = i4;
                }
            }
            qbarNative = pdl;
            w.i("MicroMsg.scanner.QBarDecoder", "QbarNative.Init = [%s], SetReaders = [%s], version = [%s], readers: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(qbarNative.SetReaders(iArr, iArr.length, qbarNative.wPz)), QbarNative.getVersion(), Arrays.toString(iArr)});
            if (i2 <= 0 || r0 <= 0) {
                w.e("MicroMsg.scanner.QBarDecoder", "QbarNative failed, releaseDecoder 1");
                return false;
            }
            this.pdk = true;
        }
        return this.pdk;
    }

    private void aYZ() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        StringBuilder stringBuilder3 = new StringBuilder();
        StringBuilder stringBuilder4 = new StringBuilder();
        int[] iArr = new int[2];
        if (pdl.a(stringBuilder, stringBuilder2, stringBuilder3, stringBuilder4, iArr) == 1) {
            w.d("MicroMsg.scanner.QBarDecoder", "decode type:%s, sCharset: %s, sBinaryMethod: %s, data:%s, gResult:%s", new Object[]{stringBuilder.toString(), stringBuilder3.toString(), stringBuilder4.toString(), stringBuilder2.toString(), Integer.valueOf(pdl.a(stringBuilder, stringBuilder2, stringBuilder3, stringBuilder4, iArr))});
            if (!bg.mA(stringBuilder2.toString())) {
                String stringBuilder5 = stringBuilder.toString();
                if (stringBuilder5.equals("QR_CODE") || stringBuilder5.equals("WX_CODE")) {
                    this.pcY = stringBuilder2.toString();
                    pcZ = 1;
                } else {
                    this.pcY = stringBuilder5 + "," + stringBuilder2;
                    pcZ = 2;
                }
            }
            this.fFo = p.DR(stringBuilder.toString());
            this.fFp = iArr[0];
        }
        l lVar = l.oWo;
        String stringBuilder6 = stringBuilder.toString();
        String str = this.pcY;
        String stringBuilder7 = stringBuilder3.toString();
        int i = iArr[0];
        int i2 = iArr[1];
        w.i("MicroMsg.QBarEngineReporter", "setDecodeResult, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s", new Object[]{stringBuilder6, str, stringBuilder7, Integer.valueOf(i), Integer.valueOf(i2), stringBuilder4.toString()});
        lVar.oWv = stringBuilder6;
        lVar.oWw = str;
        lVar.oWx = stringBuilder7;
        lVar.oWy = i;
        lVar.oWz = i2;
        lVar.oWA = r4;
    }

    public final void aKx() {
        w.d("MicroMsg.scanner.QBarDecoder", "releaseDecoder() start, hasInitQBar = %s", new Object[]{Boolean.valueOf(this.pdk)});
        this.pag = true;
        synchronized (this.hvG) {
            if (this.pdk) {
                this.pdk = false;
                w.d("MicroMsg.scanner.QBarDecoder", "QbarNative.Release() = [%s]", new Object[]{Integer.valueOf(0)});
                w.d("MicroMsg.scanner.QBarDecoder", "ImgProcessScan.Release() = [%s]", new Object[]{Integer.valueOf(0)});
            }
            this.pdp.release();
        }
        this.pdm = null;
        this.pdn = null;
        c.aYW();
    }

    public final void aYV() {
        if (this.pdk) {
            aKx();
            this.pdk = false;
        }
        this.pag = false;
        this.mdU = false;
    }

    public final com.tencent.mm.plugin.z.a.d a(c.a aVar, Set<Integer> set) {
        com.tencent.mm.plugin.z.a.d dVar = new com.tencent.mm.plugin.z.a.d();
        synchronized (this.hvG) {
            try {
                this.pcY = null;
                if (set != null && !set.isEmpty() && !a(0, (Set) set)) {
                    aKx();
                    this.mdU = false;
                    dVar = null;
                } else if (cO(0, 1)) {
                    int i;
                    w.d("MicroMsg.scanner.QBarDecoder", "directScanQRCodeImg, lumSrc==null:%b", new Object[]{Boolean.valueOf(false)});
                    if (aVar.aYY() != null) {
                        w.i("MicroMsg.scanner.QBarDecoder", "directScanQRCodeImg, lumSrc.getMatrix.length: %d, lumSrc.getWidth: %d, lumSrc.getHeight: %d", new Object[]{Integer.valueOf(aVar.aYY().length), Integer.valueOf(aVar.width), Integer.valueOf(aVar.height)});
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (aVar.aYY() == null || aVar.width * aVar.height != aVar.aYY().length) {
                        i = -1;
                    } else {
                        l.oWo.cL(aVar.width, aVar.height);
                        i = pdl.i(aVar.aYY(), aVar.width, aVar.height);
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    w.d("MicroMsg.scanner.QBarDecoder", "directScanQRCodeImg decode ScanImage %s, cost: %s", new Object[]{Integer.valueOf(i), Long.valueOf(currentTimeMillis2 - currentTimeMillis)});
                    l.oWo.cV(currentTimeMillis2 - currentTimeMillis);
                    l.oWo.aYb();
                    if (i != 1) {
                        this.mdU = false;
                        dVar = null;
                    } else {
                        l.oWo.aYa();
                        l.oWo.cW(currentTimeMillis2 - currentTimeMillis);
                        aYZ();
                        dVar.result = this.pcY;
                        dVar.fFo = this.fFo;
                        dVar.fFp = this.fFp;
                    }
                } else {
                    aKx();
                    this.mdU = false;
                    dVar = null;
                }
            } catch (Throwable e) {
                w.e("MicroMsg.scanner.QBarDecoder", " Exception in directScanQRCodeImg() " + e.getMessage());
                w.printErrStackTrace("MicroMsg.scanner.QBarDecoder", e, "", new Object[0]);
            }
        }
        return dVar;
    }
}
