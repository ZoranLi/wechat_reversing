package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.ah.a.c.i;
import com.tencent.mm.ah.n;
import com.tencent.mm.modelcontrol.b;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.xs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.a;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.u.ap;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class EmojiLogic {
    public static final String kLB = File.separator;

    public static native boolean extractForeground(int[] iArr, int i, int i2);

    public static native boolean gifToMMAni(byte[] bArr, PByteArray pByteArray, int i);

    public static int ad(byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            return c.uKP;
        }
        if (bArr[1] == (byte) 80 && bArr[2] == (byte) 78 && bArr[3] == (byte) 71) {
            return c.uKZ;
        }
        if (bArr[0] == (byte) 71 && bArr[1] == (byte) 73 && bArr[2] == (byte) 70) {
            return c.uLa;
        }
        if (bArr[6] == (byte) 74 && bArr[7] == (byte) 70 && bArr[8] == (byte) 73 && bArr[9] == (byte) 70) {
            return c.uLb;
        }
        return c.uKP;
    }

    public static String uc(String str) {
        String str2 = null;
        if (!bg.mA(str)) {
            int aN = e.aN(str);
            if (aN > 0) {
                byte[] c = e.c(str, 0, aN);
                str2 = g.n(c);
                if (!(str2 == null && c == null)) {
                    ap.yY();
                    e.b(com.tencent.mm.u.c.xi() + str2, c, c.length);
                    if (o.bf(c)) {
                        h.amc().kLa.a(str2, "", c.uKT, c.uLa, c.length, "", "");
                    } else {
                        h.amc().kLa.a(str2, "", c.uKT, c.uKZ, c.length, "", "");
                    }
                }
            }
        }
        return str2;
    }

    public static String b(Context context, WXMediaMessage wXMediaMessage, String str) {
        if (wXMediaMessage.getType() != 8) {
            return null;
        }
        WXEmojiObject wXEmojiObject = (WXEmojiObject) wXMediaMessage.mediaObject;
        if (!bg.bm(wXEmojiObject.emojiData)) {
            w.d("MicroMsg.emoji.EmojiLogic", " fileData:" + wXEmojiObject.emojiData.length);
            String n = g.n(wXEmojiObject.emojiData);
            a(context, wXMediaMessage.thumbData, n, wXEmojiObject.emojiData, str);
            return n;
        } else if (bg.mA(wXEmojiObject.emojiPath)) {
            return null;
        } else {
            int aN = e.aN(wXEmojiObject.emojiPath);
            if (aN <= 0) {
                return null;
            }
            byte[] c = e.c(wXEmojiObject.emojiPath, 0, aN);
            String n2 = g.n(c);
            a(context, wXMediaMessage.thumbData, n2, c, str);
            return n2;
        }
    }

    private static void a(Context context, byte[] bArr, String str, byte[] bArr2, String str2) {
        if (str != null || bArr2 != null) {
            c a;
            ap.yY();
            String xi = com.tencent.mm.u.c.xi();
            e.b(xi + str, bArr2, bArr2.length);
            if (o.bf(bArr2)) {
                a = h.amc().kLa.a(str, "", c.uKT, c.uLc, bArr2.length, str2, "");
            } else {
                a = h.amc().kLa.a(str, "", c.uKT, c.uLd, bArr2.length, str2, "");
            }
            a(context, bArr, str, xi, a);
        }
    }

    public static void a(Context context, byte[] bArr, String str, String str2, c cVar) {
        Bitmap bitmap;
        if (bArr == null) {
            String str3 = "MicroMsg.emoji.EmojiLogic";
            String str4 = "insertEmoji: thumb is null, emojiInfo is null ? %B";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(cVar == null);
            w.d(str3, str4, objArr);
            if (cVar != null) {
                Bitmap ew = cVar.ew(context);
            } else {
                return;
            }
        }
        ew = d.bd(bArr);
        if (ew == null || (ew.getWidth() <= com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX && ew.getHeight() <= com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX)) {
            bitmap = ew;
        } else {
            int width = ew.getWidth();
            int height = ew.getHeight();
            w.i("MicroMsg.emoji.EmojiLogic", "cpan app msg width:%d height:%d", new Object[]{Integer.valueOf(width), Integer.valueOf(height)});
            if (width > height) {
                float f = ((float) height) / ((float) width);
                height = com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX;
                width = (int) (f * 300.0f);
            } else {
                float f2 = ((float) width) / ((float) height);
                width = com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX;
                height = (int) (f2 * 300.0f);
            }
            w.i("MicroMsg.emoji.EmojiLogic", "cpan app msg new width:%d new height:%d", new Object[]{Integer.valueOf(height), Integer.valueOf(width)});
            bitmap = d.a(ew, width, height, false, true);
        }
        if (bitmap != null) {
            try {
                if (bitmap.getByteCount() > WXMediaMessage.THUMB_LENGTH_LIMIT) {
                    d.a(bitmap, 80, CompressFormat.JPEG, str2 + str + "_thumb", true);
                    w.i("MicroMsg.emoji.EmojiLogic", "cpan app msg bitmap is over size. save as jpg. size :%d", new Object[]{Integer.valueOf(bitmap.getByteCount())});
                    return;
                }
                d.a(bitmap, 100, CompressFormat.PNG, str2 + str + "_thumb", true);
                w.i("MicroMsg.emoji.EmojiLogic", "cpan app msg bitmap is in normal size. sav as png. size :%d", new Object[]{Integer.valueOf(bitmap.getByteCount())});
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.emoji.EmojiLogic", e, "insertEmoji Error", new Object[0]);
            }
        }
    }

    public static c a(String str, String str2, i iVar) {
        ap.yY();
        if (com.tencent.mm.u.c.isSDCardAvailable()) {
            c a = a(str, 4, str2, true);
            if (a == null) {
                n.GW().a(str2, null, f.a(str, str2, new Object[0]), iVar);
                w.i("MicroMsg.emoji.EmojiLogic", "[cpan] get emoji info, try to load image:%s", new Object[]{str2});
            }
            return a;
        } else if (ab.getContext() == null || ab.getContext().getResources() == null) {
            return null;
        } else {
            new c().field_type = c.uKZ;
            return null;
        }
    }

    public static c a(String str, int i, String str2, boolean z) {
        int i2 = 0;
        if (TextUtils.isEmpty(str)) {
            w.d("MicroMsg.emoji.EmojiLogic", "getIcon : productId is null.");
            return null;
        }
        int i3;
        c cVar = new c();
        if (z) {
            ap.yY();
            String C = C(com.tencent.mm.u.c.xi(), str, str2);
            if (e.aO(C)) {
                File file = new File(C);
                if (file.exists()) {
                    if (file.length() < 1) {
                        file.delete();
                    } else {
                        cVar.field_type = ad(e.c(C, 0, 10));
                        i2 = 1;
                    }
                }
            }
            if (i2 == 0) {
                w.d("MicroMsg.emoji.EmojiLogic", "banner icon does not exist. icon path :" + C + "...., icon type:" + i);
                return null;
            }
        }
        ap.yY();
        if (!e.aO(C(com.tencent.mm.u.c.xi(), str, str2))) {
            w.d("MicroMsg.emoji.EmojiLogic", "icon file no exist. path:%s type:%d, url:%s", new Object[]{C(com.tencent.mm.u.c.xi(), str, str2), Integer.valueOf(i), str2});
            return null;
        }
        cVar.field_md5 = bQ(str, str2);
        switch (i) {
            case 2:
                i3 = 82;
                break;
            case 4:
                i3 = 83;
                break;
            case 8:
                i3 = 84;
                break;
            default:
                i3 = c.uKU;
                break;
        }
        cVar.field_catalog = i3;
        cVar.field_groupId = str;
        cVar.field_temp = 1;
        return cVar;
    }

    public static boolean a(String str, String str2, a aVar) {
        ZipFile zipFile;
        OutputStream outputStream;
        InputStream inputStream;
        InputStream inputStream2;
        OutputStream outputStream2;
        Exception e;
        OutputStream outputStream3;
        Throwable th;
        OutputStream outputStream4;
        String str3 = com.tencent.mm.compatible.util.e.gSx + str;
        StringBuilder stringBuilder = new StringBuilder();
        ap.yY();
        String stringBuilder2 = stringBuilder.append(com.tencent.mm.u.c.xi()).append(str).toString();
        InputStream inputStream3 = null;
        ZipFile zipFile2 = null;
        HashMap hashMap = new HashMap();
        Object arrayList = new ArrayList();
        try {
            zipFile = new ZipFile(str3);
            try {
                ZipEntry zipEntry;
                byte[] bArr;
                int read;
                c Si;
                Enumeration entries = zipFile.entries();
                int i = 0;
                outputStream = null;
                inputStream = null;
                while (entries.hasMoreElements()) {
                    try {
                        zipEntry = (ZipEntry) entries.nextElement();
                        if (zipEntry.isDirectory()) {
                            inputStream2 = inputStream;
                            outputStream2 = outputStream;
                        } else {
                            inputStream3 = zipFile.getInputStream(zipEntry);
                            try {
                                String toLowerCase = zipEntry.getName().substring(zipEntry.getName().lastIndexOf("/") + 1).toLowerCase();
                                File file = new File(stringBuilder2 + "/" + zipEntry.getName());
                                if (file.isFile()) {
                                    file.delete();
                                }
                                file.getParentFile().mkdirs();
                                if (!toLowerCase.startsWith(".") && (toLowerCase.endsWith(".gif") || toLowerCase.endsWith(".png"))) {
                                    if (zipEntry.getName().toLowerCase().contains("/large/")) {
                                        outputStream2 = new FileOutputStream(stringBuilder2 + File.separator + toLowerCase);
                                        try {
                                            int i2;
                                            bArr = new byte[WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT];
                                            while (true) {
                                                read = inputStream3.read(bArr);
                                                if (read <= 0) {
                                                    break;
                                                }
                                                outputStream2.write(bArr, 0, read);
                                            }
                                            outputStream2.close();
                                            outputStream = null;
                                            String aV = g.aV(stringBuilder2 + File.separator + toLowerCase);
                                            w.i("MicroMsg.emoji.EmojiLogic", "md5:%s index:%d", new Object[]{aV, Integer.valueOf(i)});
                                            File file2 = new File(stringBuilder2 + File.separator + toLowerCase);
                                            File file3 = new File(stringBuilder2 + File.separator + aV);
                                            if (o.Pj(file2.getPath())) {
                                                i2 = c.uLa;
                                            } else {
                                                i2 = c.uKZ;
                                            }
                                            Si = h.amc().kLa.Si(aV);
                                            if (Si == null) {
                                                Si = new c();
                                                Si.field_catalog = 0;
                                            }
                                            Si.field_name = toLowerCase;
                                            Si.field_md5 = aV;
                                            Si.field_size = (int) file2.length();
                                            Si.field_type = i2;
                                            Si.field_groupId = str;
                                            Si.field_idx = i;
                                            arrayList.add(Si);
                                            file2.renameTo(file3);
                                            hashMap.put(toLowerCase.substring(0, toLowerCase.length() - 4), aV);
                                            outputStream2 = null;
                                            inputStream2 = inputStream3;
                                        } catch (Exception e2) {
                                            e = e2;
                                            zipFile2 = zipFile;
                                            outputStream3 = outputStream2;
                                            inputStream = inputStream3;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            outputStream = outputStream2;
                                        }
                                    } else if (toLowerCase.startsWith("icon")) {
                                        outputStream2 = new FileOutputStream(stringBuilder2 + File.separator + (g.n(str.getBytes()) + "_panel_enable"));
                                        try {
                                            bArr = new byte[WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT];
                                            while (true) {
                                                read = inputStream3.read(bArr);
                                                if (read <= 0) {
                                                    break;
                                                }
                                                outputStream2.write(bArr, 0, read);
                                            }
                                            outputStream2.close();
                                            outputStream2 = null;
                                            inputStream2 = inputStream3;
                                        } catch (Exception e3) {
                                            e = e3;
                                            zipFile2 = zipFile;
                                            outputStream3 = outputStream2;
                                            inputStream = inputStream3;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            outputStream = outputStream2;
                                        }
                                    }
                                }
                                outputStream2 = outputStream;
                                inputStream2 = inputStream3;
                            } catch (Exception e4) {
                                e = e4;
                                inputStream = inputStream3;
                                outputStream4 = outputStream;
                                zipFile2 = zipFile;
                                outputStream3 = outputStream4;
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        }
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                                inputStream2 = null;
                            } catch (Exception e5) {
                                Exception exception = e5;
                                zipFile2 = zipFile;
                                outputStream3 = outputStream2;
                                inputStream = inputStream2;
                                e = exception;
                            } catch (Throwable th5) {
                                inputStream3 = inputStream2;
                                th = th5;
                                outputStream = outputStream2;
                            }
                        }
                        i++;
                        outputStream = outputStream2;
                        inputStream = inputStream2;
                    } catch (Exception e6) {
                        e = e6;
                        ZipFile zipFile3 = zipFile;
                        outputStream3 = outputStream;
                        zipFile2 = zipFile3;
                    } catch (Throwable th6) {
                        th = th6;
                        inputStream3 = inputStream;
                    }
                }
                Enumeration entries2 = zipFile.entries();
                while (entries2.hasMoreElements()) {
                    zipEntry = (ZipEntry) entries2.nextElement();
                    if (zipEntry.isDirectory()) {
                        inputStream2 = inputStream;
                        outputStream2 = outputStream;
                    } else {
                        inputStream3 = zipFile.getInputStream(zipEntry);
                        String toLowerCase2 = zipEntry.getName().substring(zipEntry.getName().lastIndexOf("/") + 1).toLowerCase();
                        File file4 = new File(stringBuilder2 + "/" + zipEntry.getName());
                        if (file4.isFile()) {
                            file4.delete();
                        }
                        file4.getParentFile().mkdirs();
                        if (zipEntry.getName().toLowerCase().contains("/thumb/")) {
                            int lastIndexOf = toLowerCase2.lastIndexOf(".") + 1;
                            String str4 = toLowerCase2.substring(0, lastIndexOf - 1) + "_cover." + toLowerCase2.substring(lastIndexOf);
                            outputStream2 = new FileOutputStream(stringBuilder2 + File.separator + str4);
                            try {
                                bArr = new byte[WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT];
                                while (true) {
                                    read = inputStream3.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    outputStream2.write(bArr, 0, read);
                                }
                                outputStream2.close();
                                outputStream = null;
                                String substring = str4.substring(0, str4.lastIndexOf("_cover."));
                                if (hashMap.containsKey(substring)) {
                                    substring = (String) hashMap.get(substring);
                                    new File(stringBuilder2 + File.separator + str4).renameTo(new File(stringBuilder2 + File.separator + substring + "_cover"));
                                    hashMap.put(str4, substring);
                                }
                                outputStream2 = null;
                                inputStream2 = inputStream3;
                            } catch (Exception e7) {
                                e = e7;
                                zipFile2 = zipFile;
                                outputStream3 = outputStream2;
                                inputStream = inputStream3;
                            } catch (Throwable th7) {
                                th = th7;
                                outputStream = outputStream2;
                            }
                        } else {
                            outputStream2 = outputStream;
                            inputStream2 = inputStream3;
                        }
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                        inputStream2 = null;
                    }
                    outputStream = outputStream2;
                    inputStream = inputStream2;
                }
                hashMap.clear();
                if (aVar == null) {
                    aVar = h.amc().kLb.aP(str, false);
                }
                aVar.field_productID = str;
                if (!bg.mA(str2)) {
                    aVar.field_packName = str2;
                }
                aVar.field_lastUseTime = System.currentTimeMillis();
                aVar.field_status = 7;
                aVar.field_packStatus = 1;
                aVar.field_type = a.uKN;
                aVar.field_recommand = 0;
                aVar.field_sync = 2;
                aVar.field_count = arrayList.size();
                if (h.amc().kLa.j(arrayList, str)) {
                    boolean c = h.amc().kLb.c(aVar);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Si = (c) it.next();
                        Si.field_reserved4 = 0;
                        com.tencent.mm.plugin.emoji.e.e.alz().c(Si, true);
                    }
                    w.i("MicroMsg.emoji.EmojiLogic", "saveGroupFlag:%b saveEmojiFlag:%b", new Object[]{Boolean.valueOf(c), Boolean.valueOf(r6)});
                } else {
                    w.i("MicroMsg.emoji.EmojiLogic", "saveEmojiFlag:%b", new Object[]{Boolean.valueOf(h.amc().kLa.j(arrayList, str))});
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                zipFile.close();
                return true;
            } catch (Exception e8) {
                e = e8;
                zipFile2 = zipFile;
                outputStream3 = null;
                inputStream = null;
                try {
                    w.e("MicroMsg.emoji.EmojiLogic", "un zip package fail." + e.getMessage());
                    if (outputStream3 != null) {
                        outputStream3.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (zipFile2 != null) {
                        zipFile2.close();
                    }
                    return false;
                } catch (Throwable th8) {
                    th = th8;
                    inputStream3 = inputStream;
                    outputStream4 = outputStream3;
                    zipFile = zipFile2;
                    outputStream = outputStream4;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream3 != null) {
                        inputStream3.close();
                    }
                    if (zipFile != null) {
                        zipFile.close();
                    }
                    throw th;
                }
            } catch (Throwable th9) {
                th = th9;
                outputStream = null;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream3 != null) {
                    inputStream3.close();
                }
                if (zipFile != null) {
                    zipFile.close();
                }
                throw th;
            }
        } catch (Exception e9) {
            e = e9;
            outputStream3 = null;
            inputStream = null;
            w.e("MicroMsg.emoji.EmojiLogic", "un zip package fail." + e.getMessage());
            if (outputStream3 != null) {
                outputStream3.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (zipFile2 != null) {
                zipFile2.close();
            }
            return false;
        } catch (Throwable th10) {
            th = th10;
            zipFile = null;
            outputStream = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream3 != null) {
                inputStream3.close();
            }
            if (zipFile != null) {
                zipFile.close();
            }
            throw th;
        }
    }

    public static xs alQ() {
        xs xsVar = new xs();
        xsVar.tEh = 1;
        xsVar.tEj = 1;
        return xsVar;
    }

    public static String um(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<xml>");
        stringBuilder.append("<productid>" + str + "</productid>");
        stringBuilder.append("</xml>");
        w.i("MicroMsg.emoji.EmojiLogic", "sns object data:%s", new Object[]{stringBuilder.toString()});
        return stringBuilder.toString();
    }

    public static String i(int i, String str, String str2) {
        if (i == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<xml>");
        stringBuilder.append("<designeruin>" + i + "</designeruin>");
        stringBuilder.append("<designername>" + str + "</designername>");
        stringBuilder.append("<designerrediretcturl>" + str2 + "</designerrediretcturl>");
        stringBuilder.append("</xml>");
        w.i("MicroMsg.emoji.EmojiLogic", "sns object data:%s", new Object[]{stringBuilder.toString()});
        return stringBuilder.toString();
    }

    public static int uj(String str) {
        int aY;
        Exception e;
        try {
            aY = com.tencent.mm.a.o.aY((String) bh.q(str, "xml").get(".xml.designeruin"));
            try {
                w.d("MicroMsg.emoji.EmojiLogic", "designeruin:%s", new Object[]{Integer.valueOf(aY)});
            } catch (Exception e2) {
                e = e2;
                w.e("MicroMsg.emoji.EmojiLogic", "getDesignerUINBySnsObjData exception. %s", new Object[]{e.toString()});
                return aY;
            }
        } catch (Exception e3) {
            e = e3;
            aY = 0;
            w.e("MicroMsg.emoji.EmojiLogic", "getDesignerUINBySnsObjData exception. %s", new Object[]{e.toString()});
            return aY;
        }
        return aY;
    }

    public static String uk(String str) {
        String str2;
        Exception e;
        String str3 = "";
        try {
            str2 = (String) bh.q(str, "xml").get(".xml.designername");
            try {
                w.d("MicroMsg.emoji.EmojiLogic", "designeruin:%s", new Object[]{str2});
            } catch (Exception e2) {
                e = e2;
                w.e("MicroMsg.emoji.EmojiLogic", "getDesignerNameBySnsObjData exception. %s", new Object[]{e.toString()});
                return str2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str2 = str3;
            e = exception;
            w.e("MicroMsg.emoji.EmojiLogic", "getDesignerNameBySnsObjData exception. %s", new Object[]{e.toString()});
            return str2;
        }
        return str2;
    }

    public static String un(String str) {
        String str2;
        Exception e;
        String str3 = "";
        try {
            str2 = (String) bh.q(str, "xml").get(".xml.designerrediretcturl");
            try {
                w.d("MicroMsg.emoji.EmojiLogic", "designerrediretcturl:%s", new Object[]{str2});
            } catch (Exception e2) {
                e = e2;
                w.e("MicroMsg.emoji.EmojiLogic", "getDesignerRediretctUrlBySnsObjData exception. %s", new Object[]{e.toString()});
                return str2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str2 = str3;
            e = exception;
            w.e("MicroMsg.emoji.EmojiLogic", "getDesignerRediretctUrlBySnsObjData exception. %s", new Object[]{e.toString()});
            return str2;
        }
        return str2;
    }

    public static String ui(String str) {
        String str2;
        Exception e;
        String str3 = "";
        try {
            str2 = (String) bh.q(str, "xml").get(".xml.productid");
            try {
                w.d("MicroMsg.emoji.EmojiLogic", "productId:%s", new Object[]{str2});
            } catch (Exception e2) {
                e = e2;
                w.e("MicroMsg.emoji.EmojiLogic", "getProductIdBySnsObjData exception. %s", new Object[]{e.toString()});
                return str2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str2 = str3;
            e = exception;
            w.e("MicroMsg.emoji.EmojiLogic", "getProductIdBySnsObjData exception. %s", new Object[]{e.toString()});
            return str2;
        }
        return str2;
    }

    public static String uh(String str) {
        w.d("MicroMsg.emoji.EmojiLogic", "url:%s", new Object[]{str});
        String str2 = "";
        if (TextUtils.isEmpty(str) || !str.startsWith("http://weixin.qq.com/emoticonstore/")) {
            return str2;
        }
        return str.substring(str.lastIndexOf("/") + 1);
    }

    public static String a(int i, String str, String str2, String str3, String str4, int i2) {
        if (i <= 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<xml>");
        stringBuilder.append("<tid>" + i + "</tid>");
        stringBuilder.append("<title>" + str + "</title>");
        stringBuilder.append("<desc>" + str2 + "</desc>");
        stringBuilder.append("<iconUrl>" + str3 + "</iconUrl>");
        stringBuilder.append("<secondUrl>" + str4 + "</secondUrl>");
        stringBuilder.append("<pageType>" + i2 + "</pageType>");
        stringBuilder.append("</xml>");
        w.i("MicroMsg.emoji.EmojiLogic", "sns object data:%s", new Object[]{stringBuilder.toString()});
        return stringBuilder.toString();
    }

    public static int uo(String str) {
        int PY;
        Exception e;
        try {
            PY = bg.PY((String) bh.q(str, "xml").get(".xml.tid"));
            try {
                w.d("MicroMsg.emoji.EmojiLogic", "tid:%s", new Object[]{Integer.valueOf(PY)});
            } catch (Exception e2) {
                e = e2;
                w.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageTid exception. %s", new Object[]{e.toString()});
                return PY;
            }
        } catch (Exception e3) {
            e = e3;
            PY = 0;
            w.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageTid exception. %s", new Object[]{e.toString()});
            return PY;
        }
        return PY;
    }

    public static String up(String str) {
        String str2;
        Exception e;
        String str3 = "";
        try {
            str2 = (String) bh.q(str, "xml").get(".xml.title");
            try {
                w.d("MicroMsg.emoji.EmojiLogic", "title:%s", new Object[]{str2});
            } catch (Exception e2) {
                e = e2;
                w.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageTitle exception. %s", new Object[]{e.toString()});
                return str2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str2 = str3;
            e = exception;
            w.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageTitle exception. %s", new Object[]{e.toString()});
            return str2;
        }
        return str2;
    }

    public static String uq(String str) {
        String str2;
        Exception e;
        String str3 = "";
        try {
            str2 = (String) bh.q(str, "xml").get(".xml.desc");
            try {
                w.d("MicroMsg.emoji.EmojiLogic", "desc:%s", new Object[]{str2});
            } catch (Exception e2) {
                e = e2;
                w.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageDesc exception. %s", new Object[]{e.toString()});
                return str2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str2 = str3;
            e = exception;
            w.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageDesc exception. %s", new Object[]{e.toString()});
            return str2;
        }
        return str2;
    }

    public static String ur(String str) {
        String str2;
        Exception e;
        String str3 = "";
        try {
            str2 = (String) bh.q(str, "xml").get(".xml.iconUrl");
            try {
                w.d("MicroMsg.emoji.EmojiLogic", "iconUrl:%s", new Object[]{str2});
            } catch (Exception e2) {
                e = e2;
                w.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageIconUrl exception. %s", new Object[]{e.toString()});
                return str2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str2 = str3;
            e = exception;
            w.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageIconUrl exception. %s", new Object[]{e.toString()});
            return str2;
        }
        return str2;
    }

    public static String us(String str) {
        String ap;
        Exception e;
        String str2 = "";
        try {
            ap = bg.ap((String) bh.q(str, "xml").get(".xml.secondUrl"), "");
            try {
                w.d("MicroMsg.emoji.EmojiLogic", "secondUrl:%s", new Object[]{ap});
            } catch (Exception e2) {
                e = e2;
                w.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageSecondUrl exception. %s", new Object[]{e.toString()});
                return ap;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            ap = str2;
            e = exception;
            w.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageSecondUrl exception. %s", new Object[]{e.toString()});
            return ap;
        }
        return ap;
    }

    public static int ut(String str) {
        int PY;
        Exception e;
        try {
            PY = bg.PY((String) bh.q(str, "xml").get(".xml.pageType"));
            try {
                w.d("MicroMsg.emoji.EmojiLogic", "pageType:%s", new Object[]{Integer.valueOf(PY)});
            } catch (Exception e2) {
                e = e2;
                w.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageType exception. %s", new Object[]{e.toString()});
                return PY;
            }
        } catch (Exception e3) {
            e = e3;
            PY = 0;
            w.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageType exception. %s", new Object[]{e.toString()});
            return PY;
        }
        return PY;
    }

    public static String C(String str, String str2, String str3) {
        if (bg.mA(str2) && bg.mA(str3)) {
            w.w("MicroMsg.emoji.EmojiLogic", "[cpan] get icon path failed. productid and url are null.");
            return null;
        }
        String bQ = bQ(str2, str3);
        if (bg.mA(bQ)) {
            return null;
        }
        if (bg.mA(str2)) {
            return str + bQ;
        }
        return str + str2 + kLB + bQ;
    }

    public static String D(String str, String str2, String str3) {
        String str4 = null;
        if (bg.mA(str2) && bg.mA(str3)) {
            w.w("MicroMsg.emoji.EmojiLogic", "[cpan] get icon path failed. productid and md5 are null.");
        } else {
            if (!bg.mA(str3)) {
                if (bg.mA(str2)) {
                    str4 = str + str3;
                } else {
                    str4 = str + str2 + kLB + str3;
                }
            }
            w.d("MicroMsg.emoji.EmojiLogic", "[cpan] get icon path. productid:%s md5:%s path:%s", new Object[]{str2, str3, str4});
        }
        return str4;
    }

    private static String bQ(String str, String str2) {
        if (bg.mA(str) && bg.mA(str2)) {
            w.e("MicroMsg.emoji.EmojiLogic", "[cpan] product id and url are null.");
            return null;
        } else if (bg.mA(str2)) {
            return g.n(str.getBytes());
        } else {
            return g.n(str2.getBytes());
        }
    }

    public static boolean uu(String str) {
        if (!bg.mA(str)) {
            try {
                if (b.iT(str)) {
                    w.d("MicroMsg.emoji.EmojiLogic", "In Not Auto Download Time Range. timeRange:%s", new Object[]{str});
                    return true;
                }
            } catch (Throwable e) {
                w.e("MicroMsg.emoji.EmojiLogic", "isInNotAutoDownloadTimeRange :%s", new Object[]{bg.g(e)});
            }
        }
        return false;
    }
}
