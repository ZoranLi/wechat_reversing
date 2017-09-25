package com.tencent.mm.plugin.appbrand.m;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.memory.l;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.w;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public enum b {
    ;

    public static boolean a(Options options) {
        if (options == null) {
            return false;
        }
        String str = options.outMimeType;
        if (str == null) {
            return false;
        }
        str = str.toLowerCase();
        if (str.indexOf("jpg") >= 0) {
            return true;
        }
        if (str.indexOf("jpeg") >= 0) {
            return true;
        }
        return false;
    }

    private static boolean a(String str, int i, int i2, CompressFormat compressFormat, int i3, String str2) {
        Options Pe = d.Pe(str);
        if (Pe == null || Pe.outWidth <= 0 || Pe.outHeight <= 0) {
            return false;
        }
        return a(str, Pe.outWidth, Pe.outHeight, i, i2, compressFormat, i3, str2);
    }

    private static Bitmap b(String str, Options options, DecodeResultLogger decodeResultLogger) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            w.d("MicroMsg.AppBrandImgUtil", "decodeWithRotateByExif used %dms bitmap: %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), l.wu().a(str, options, decodeResultLogger)});
            return l.wu().a(str, options, decodeResultLogger);
        } catch (OutOfMemoryError e) {
            com.tencent.mm.bl.b.bOh();
            w.e("MicroMsg.AppBrandImgUtil", "OutOfMemoryError e " + e.getMessage());
            return null;
        }
    }

    private static boolean a(String str, int i, int i2, int i3, int i4, CompressFormat compressFormat, int i5, String str2) {
        OutputStream outputStream = null;
        try {
            Bitmap b;
            w.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, srcWidth: %s, srcHeight: %s, width: %s, height: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3)});
            Options options = new Options();
            DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
            double d = (((double) i2) * 1.0d) / ((double) i3);
            double d2 = (((double) i) * 1.0d) / ((double) i4);
            if (i == i4 && i2 == i3) {
                b = b(str, options, decodeResultLogger);
            } else {
                options.inSampleSize = 1;
                if (i2 > i3 || i > i4) {
                    options.inSampleSize = (int) (d < d2 ? d2 : d);
                    if (options.inSampleSize <= 1) {
                        options.inSampleSize = 1;
                    }
                }
                while (((i2 * i) / options.inSampleSize) / options.inSampleSize > 2764800) {
                    options.inSampleSize++;
                }
                w.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, sampleSize: %s", new Object[]{Integer.valueOf(options.inSampleSize)});
                b = b(str, options, decodeResultLogger);
            }
            w.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, result bm: %s", new Object[]{b});
            if (b == null) {
                return false;
            }
            int ceil;
            int i6;
            w.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, bm.width: %s, bm.height: %s", new Object[]{Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight())});
            if (d < d2) {
                ceil = (int) Math.ceil(((((double) i4) * 1.0d) * ((double) i2)) / ((double) i));
                i6 = i4;
            } else {
                i6 = (int) Math.ceil(((((double) i3) * 1.0d) * ((double) i)) / ((double) i2));
                ceil = i3;
            }
            int Pc = ExifHelper.Pc(str);
            if (Pc == 90 || Pc == 270) {
                b = d.b(b, (float) Pc);
                int i7 = ceil;
                ceil = i6;
                i6 = i7;
            }
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(b, i6, ceil, true);
            if (createScaledBitmap == null) {
                createScaledBitmap = b;
            } else if (b != createScaledBitmap) {
                l.wu().f(b);
            }
            w.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScalebyUpload, degree %d, bm.width: %s, bm.height: %s", new Object[]{Integer.valueOf(Pc), Integer.valueOf(createScaledBitmap.getWidth()), Integer.valueOf(createScaledBitmap.getHeight())});
            outputStream = FileOp.gQ(str2);
            d.a(createScaledBitmap, i5, compressFormat, outputStream, false);
            l.wu().f(createScaledBitmap);
            outputStream.close();
            return true;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.AppBrandImgUtil", e, "create thumbnail from orig failed: %s", new Object[]{str2});
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e2) {
                }
            }
            return false;
        }
    }

    public static boolean bk(String str, String str2) {
        Throwable th;
        Throwable th2;
        int ki = (int) FileOp.ki(str2);
        Options Pe = d.Pe(str2);
        if (Pe == null) {
            w.i("MicroMsg.AppBrandImgUtil", "compressImage, get null bitmap.option from path %s", new Object[]{str2});
            return false;
        }
        boolean z;
        boolean a;
        int i;
        int i2;
        int i3;
        Exif fromFile;
        int i4;
        Options options;
        InputStream inputStream;
        InputStream iVar;
        Bitmap decodeStream;
        if (Pe != null) {
            String str3 = Pe.outMimeType;
            w.d("MicroMsg.AppBrandImgUtil", "mimetype: " + str3);
            if (str3 != null) {
                str3 = str3.toLowerCase();
                if (str3.indexOf("jpg") >= 0) {
                    z = true;
                } else if (str3.indexOf("jpeg") >= 0) {
                    z = true;
                } else if (str3.indexOf("png") >= 0) {
                    z = true;
                }
                a = a(Pe);
                i = -1;
                if (a) {
                    i = MMNativeJpeg.queryQuality(str2);
                    if (i < 70 && i > 25) {
                        i2 = i;
                        i3 = i;
                        i = 0;
                        if (a) {
                            try {
                                fromFile = Exif.fromFile(str2);
                                if (fromFile != null) {
                                    i = fromFile.getOrientationInDegree() % 360;
                                    w.i("MicroMsg.AppBrandImgUtil", "compressImage exif rotation %d", new Object[]{Integer.valueOf(fromFile.getOrientationInDegree())});
                                }
                                i4 = i;
                            } catch (Exception e) {
                                w.e("MicroMsg.AppBrandImgUtil", "get degree error " + e.getMessage());
                            }
                            w.i("MicroMsg.AppBrandImgUtil", "option info " + Pe.outWidth + " " + Pe.outHeight + " " + z + " origQuality: " + i2 + " degree:" + i4 + " filelen " + ki + " target 960 640");
                            boolean z2;
                            if ((Pe.outWidth < Pe.outHeight * 2 || Pe.outHeight >= Pe.outWidth * 2) && Pe.outWidth * Pe.outHeight <= 10240000) {
                                if (ki >= 204800 && z && i4 == 0) {
                                    w.i("MicroMsg.AppBrandImgUtil", "filelen is control in picCompressAvoidanceActiveSizeLong 204800");
                                    if (FileOp.p(str2, str) >= 0) {
                                        return true;
                                    }
                                    return false;
                                }
                                options = new Options();
                                d.b(options);
                                inputStream = null;
                                inputStream = FileOp.openRead(str2);
                                if (inputStream.markSupported() && (inputStream instanceof FileInputStream)) {
                                    iVar = new i((FileInputStream) inputStream);
                                } else {
                                    iVar = inputStream;
                                }
                                iVar.mark(1048576);
                                decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, new DecodeResultLogger(), 0, new int[0]);
                                iVar.reset();
                                if (decodeStream != null) {
                                    if (iVar != null) {
                                        try {
                                            iVar.close();
                                        } catch (IOException e2) {
                                        }
                                    }
                                    return false;
                                }
                                d.a(d.b(decodeStream, (float) i4), i3, CompressFormat.JPEG, str, true);
                                if (z || i4 != 0) {
                                    if (iVar != null) {
                                        try {
                                            iVar.close();
                                        } catch (IOException e3) {
                                        }
                                    }
                                    return true;
                                }
                                w.i("MicroMsg.AppBrandImgUtil", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(ki), Long.valueOf(FileOp.ki(str)), Integer.valueOf(10)});
                                if ((((long) ki) - FileOp.ki(str)) * 100 < ((long) (ki * 10))) {
                                    FileOp.deleteFile(str);
                                    z2 = FileOp.p(str2, str) >= 0;
                                    if (iVar == null) {
                                        return z2;
                                    }
                                    try {
                                        iVar.close();
                                        return z2;
                                    } catch (IOException e4) {
                                        return z2;
                                    }
                                }
                                if (iVar != null) {
                                    try {
                                        iVar.close();
                                    } catch (IOException e5) {
                                    }
                                }
                                return true;
                            } else if (ki < 102400 && z && i4 == 0) {
                                w.i("MicroMsg.AppBrandImgUtil", "filelen is control in picCompressAvoidanceActiveSizeNormal 102400");
                                return FileOp.p(str2, str) >= 0;
                            } else if ((Pe.outWidth > 960 || Pe.outHeight > 640) && (Pe.outHeight > 960 || Pe.outWidth > 640)) {
                                i = Pe.outWidth >= Pe.outHeight ? 960 : 640;
                                int i5 = Pe.outWidth >= Pe.outHeight ? 640 : 960;
                                if (Pe.outWidth >= Pe.outHeight * 2 || Pe.outHeight >= Pe.outWidth * 2) {
                                    w.i("MicroMsg.AppBrandImgUtil", "too max pic " + Pe.outWidth + " " + Pe.outHeight);
                                    if (Pe.outHeight <= 0) {
                                        Pe.outHeight = 1;
                                    }
                                    if (Pe.outWidth <= 0) {
                                        Pe.outWidth = 1;
                                    }
                                    if (Pe.outWidth > Pe.outHeight) {
                                        i = Pe.outWidth / Pe.outHeight;
                                    } else {
                                        i = Pe.outHeight / Pe.outWidth;
                                    }
                                    if (i == 0) {
                                        i = 1;
                                    }
                                    i5 = (int) Math.sqrt((double) (10240000 / i));
                                    if (Pe.outWidth > Pe.outHeight) {
                                        i2 = i5 * i;
                                    } else {
                                        i2 = i5;
                                        i5 *= i;
                                    }
                                    w.i("MicroMsg.AppBrandImgUtil", "new width height " + i2 + " " + i5 + " " + i);
                                } else {
                                    i2 = i;
                                }
                                z2 = a(str2, i5, i2, CompressFormat.JPEG, i3, str);
                                if (!z || i4 != 0) {
                                    return z2;
                                }
                                w.i("MicroMsg.AppBrandImgUtil", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(ki), Long.valueOf(FileOp.ki(str)), Integer.valueOf(10)});
                                if ((((long) ki) - FileOp.ki(str)) * 100 >= ((long) (ki * 10))) {
                                    return z2;
                                }
                                FileOp.deleteFile(str);
                                if (FileOp.p(str2, str) >= 0) {
                                    return true;
                                }
                                return false;
                            } else {
                                w.i("MicroMsg.AppBrandImgUtil", "hello ieg this is little img  %d w: %d h: %d", new Object[]{Integer.valueOf(ki), Integer.valueOf(Pe.outWidth), Integer.valueOf(Pe.outHeight)});
                                if (FileOp.ki(str2) < 71680) {
                                    if (z) {
                                        w.i("MicroMsg.AppBrandImgUtil", "isSysSupportedPic %s", new Object[]{str2});
                                        return FileOp.p(str2, str) >= 0;
                                    } else if (Pe.outWidth < ck.CTRL_INDEX && Pe.outHeight < ck.CTRL_INDEX) {
                                        return a(str2, Pe.outHeight, Pe.outWidth, CompressFormat.PNG, i3, str);
                                    }
                                }
                                z2 = a(str2, Pe.outHeight, Pe.outWidth, CompressFormat.JPEG, i3, str);
                                if (!z || i4 != 0) {
                                    return z2;
                                }
                                w.i("MicroMsg.AppBrandImgUtil", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(ki), Long.valueOf(FileOp.ki(str)), Integer.valueOf(10)});
                                if ((((long) ki) - FileOp.ki(str)) * 100 >= ((long) (ki * 10))) {
                                    return z2;
                                }
                                FileOp.deleteFile(str);
                                return FileOp.p(str2, str) >= 0;
                            }
                        }
                        i4 = 0;
                        w.i("MicroMsg.AppBrandImgUtil", "option info " + Pe.outWidth + " " + Pe.outHeight + " " + z + " origQuality: " + i2 + " degree:" + i4 + " filelen " + ki + " target 960 640");
                        if (Pe.outWidth < Pe.outHeight * 2) {
                        }
                        if (ki >= 204800) {
                        }
                        options = new Options();
                        d.b(options);
                        inputStream = null;
                        inputStream = FileOp.openRead(str2);
                        if (inputStream.markSupported()) {
                        }
                        iVar = inputStream;
                        iVar.mark(1048576);
                        decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, new DecodeResultLogger(), 0, new int[0]);
                        iVar.reset();
                        if (decodeStream != null) {
                            d.a(d.b(decodeStream, (float) i4), i3, CompressFormat.JPEG, str, true);
                            if (z) {
                            }
                            if (iVar != null) {
                                iVar.close();
                            }
                            return true;
                        }
                        if (iVar != null) {
                            iVar.close();
                        }
                        return false;
                    }
                }
                i2 = i;
                i3 = 70;
                i = 0;
                if (a) {
                    fromFile = Exif.fromFile(str2);
                    if (fromFile != null) {
                        i = fromFile.getOrientationInDegree() % 360;
                        w.i("MicroMsg.AppBrandImgUtil", "compressImage exif rotation %d", new Object[]{Integer.valueOf(fromFile.getOrientationInDegree())});
                    }
                    i4 = i;
                    w.i("MicroMsg.AppBrandImgUtil", "option info " + Pe.outWidth + " " + Pe.outHeight + " " + z + " origQuality: " + i2 + " degree:" + i4 + " filelen " + ki + " target 960 640");
                    if (Pe.outWidth < Pe.outHeight * 2) {
                    }
                    if (ki >= 204800) {
                    }
                    options = new Options();
                    d.b(options);
                    inputStream = null;
                    inputStream = FileOp.openRead(str2);
                    if (inputStream.markSupported()) {
                    }
                    iVar = inputStream;
                    iVar.mark(1048576);
                    decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, new DecodeResultLogger(), 0, new int[0]);
                    iVar.reset();
                    if (decodeStream != null) {
                        if (iVar != null) {
                            iVar.close();
                        }
                        return false;
                    }
                    d.a(d.b(decodeStream, (float) i4), i3, CompressFormat.JPEG, str, true);
                    if (z) {
                    }
                    if (iVar != null) {
                        iVar.close();
                    }
                    return true;
                }
                i4 = 0;
                w.i("MicroMsg.AppBrandImgUtil", "option info " + Pe.outWidth + " " + Pe.outHeight + " " + z + " origQuality: " + i2 + " degree:" + i4 + " filelen " + ki + " target 960 640");
                if (Pe.outWidth < Pe.outHeight * 2) {
                }
                if (ki >= 204800) {
                }
                options = new Options();
                d.b(options);
                inputStream = null;
                inputStream = FileOp.openRead(str2);
                if (inputStream.markSupported()) {
                }
                iVar = inputStream;
                iVar.mark(1048576);
                decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, new DecodeResultLogger(), 0, new int[0]);
                iVar.reset();
                if (decodeStream != null) {
                    d.a(d.b(decodeStream, (float) i4), i3, CompressFormat.JPEG, str, true);
                    if (z) {
                    }
                    if (iVar != null) {
                        iVar.close();
                    }
                    return true;
                }
                if (iVar != null) {
                    iVar.close();
                }
                return false;
            }
        }
        z = false;
        a = a(Pe);
        i = -1;
        if (a) {
            i = MMNativeJpeg.queryQuality(str2);
            i2 = i;
            i3 = i;
            i = 0;
            if (a) {
                fromFile = Exif.fromFile(str2);
                if (fromFile != null) {
                    i = fromFile.getOrientationInDegree() % 360;
                    w.i("MicroMsg.AppBrandImgUtil", "compressImage exif rotation %d", new Object[]{Integer.valueOf(fromFile.getOrientationInDegree())});
                }
                i4 = i;
                w.i("MicroMsg.AppBrandImgUtil", "option info " + Pe.outWidth + " " + Pe.outHeight + " " + z + " origQuality: " + i2 + " degree:" + i4 + " filelen " + ki + " target 960 640");
                if (Pe.outWidth < Pe.outHeight * 2) {
                }
                if (ki >= 204800) {
                }
                options = new Options();
                d.b(options);
                inputStream = null;
                inputStream = FileOp.openRead(str2);
                if (inputStream.markSupported()) {
                }
                iVar = inputStream;
                iVar.mark(1048576);
                decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, new DecodeResultLogger(), 0, new int[0]);
                iVar.reset();
                if (decodeStream != null) {
                    if (iVar != null) {
                        iVar.close();
                    }
                    return false;
                }
                d.a(d.b(decodeStream, (float) i4), i3, CompressFormat.JPEG, str, true);
                if (z) {
                }
                if (iVar != null) {
                    iVar.close();
                }
                return true;
            }
            i4 = 0;
            w.i("MicroMsg.AppBrandImgUtil", "option info " + Pe.outWidth + " " + Pe.outHeight + " " + z + " origQuality: " + i2 + " degree:" + i4 + " filelen " + ki + " target 960 640");
            if (Pe.outWidth < Pe.outHeight * 2) {
            }
            if (ki >= 204800) {
            }
            options = new Options();
            d.b(options);
            inputStream = null;
            inputStream = FileOp.openRead(str2);
            if (inputStream.markSupported()) {
            }
            iVar = inputStream;
            iVar.mark(1048576);
            decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, new DecodeResultLogger(), 0, new int[0]);
            iVar.reset();
            if (decodeStream != null) {
                d.a(d.b(decodeStream, (float) i4), i3, CompressFormat.JPEG, str, true);
                if (z) {
                }
                if (iVar != null) {
                    iVar.close();
                }
                return true;
            }
            if (iVar != null) {
                iVar.close();
            }
            return false;
        }
        i2 = i;
        i3 = 70;
        i = 0;
        if (a) {
            fromFile = Exif.fromFile(str2);
            if (fromFile != null) {
                i = fromFile.getOrientationInDegree() % 360;
                w.i("MicroMsg.AppBrandImgUtil", "compressImage exif rotation %d", new Object[]{Integer.valueOf(fromFile.getOrientationInDegree())});
            }
            i4 = i;
            w.i("MicroMsg.AppBrandImgUtil", "option info " + Pe.outWidth + " " + Pe.outHeight + " " + z + " origQuality: " + i2 + " degree:" + i4 + " filelen " + ki + " target 960 640");
            if (Pe.outWidth < Pe.outHeight * 2) {
            }
            if (ki >= 204800) {
            }
            options = new Options();
            d.b(options);
            inputStream = null;
            inputStream = FileOp.openRead(str2);
            if (inputStream.markSupported()) {
            }
            iVar = inputStream;
            iVar.mark(1048576);
            decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, new DecodeResultLogger(), 0, new int[0]);
            iVar.reset();
            if (decodeStream != null) {
                if (iVar != null) {
                    iVar.close();
                }
                return false;
            }
            d.a(d.b(decodeStream, (float) i4), i3, CompressFormat.JPEG, str, true);
            if (z) {
            }
            if (iVar != null) {
                iVar.close();
            }
            return true;
        }
        i4 = 0;
        w.i("MicroMsg.AppBrandImgUtil", "option info " + Pe.outWidth + " " + Pe.outHeight + " " + z + " origQuality: " + i2 + " degree:" + i4 + " filelen " + ki + " target 960 640");
        if (Pe.outWidth < Pe.outHeight * 2) {
        }
        if (ki >= 204800) {
        }
        options = new Options();
        d.b(options);
        inputStream = null;
        try {
            inputStream = FileOp.openRead(str2);
            if (inputStream.markSupported()) {
            }
            iVar = inputStream;
            try {
                iVar.mark(1048576);
                decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, new DecodeResultLogger(), 0, new int[0]);
                iVar.reset();
                if (decodeStream != null) {
                    d.a(d.b(decodeStream, (float) i4), i3, CompressFormat.JPEG, str, true);
                    if (z) {
                    }
                    if (iVar != null) {
                        iVar.close();
                    }
                    return true;
                }
                if (iVar != null) {
                    iVar.close();
                }
                return false;
            } catch (Throwable e6) {
                th = e6;
                inputStream = iVar;
                th2 = th;
                try {
                    w.printErrStackTrace("MicroMsg.AppBrandImgUtil", th2, "Decode bitmap failed: " + str2, new Object[0]);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e7) {
                        }
                    }
                    return false;
                } catch (Throwable th3) {
                    th2 = th3;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e8) {
                        }
                    }
                    throw th2;
                }
            } catch (Throwable e62) {
                th = e62;
                inputStream = iVar;
                th2 = th;
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th2;
            }
        } catch (IOException e9) {
            th2 = e9;
            w.printErrStackTrace("MicroMsg.AppBrandImgUtil", th2, "Decode bitmap failed: " + str2, new Object[0]);
            if (inputStream != null) {
                inputStream.close();
            }
            return false;
        }
    }
}
