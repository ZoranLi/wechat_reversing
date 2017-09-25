package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Build.VERSION;
import android.system.Os;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.w;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;

public final class c {
    static final String iAV;
    private static final Collection<a> iAW;
    public static final AppBrandLocalMediaObject iAX = new AppBrandLocalMediaObjectManager$3();

    private interface a {
        AppBrandLocalMediaObject a(AppBrandLocalMediaObject appBrandLocalMediaObject);

        AppBrandLocalMediaObject aI(String str, String str2);

        AppBrandLocalMediaObject aJ(String str, String str2);

        com.tencent.mm.vending.j.a v(String str, String str2, String str3);
    }

    private static final class b {
    }

    private static final class c implements a {
        public final String toString() {
            return "V1MediaObjectInfoHandler";
        }

        public final AppBrandLocalMediaObject aI(String str, String str2) {
            String aF;
            try {
                aF = c.aF(str2, str);
            } catch (Throwable e) {
                w.e("MicroMsg.AppBrand.LocalMediaObjectManager.V1Handler", "retrieveMediaObject, fileName = %s, decrypt exp = %s", new Object[]{str2, bg.g(e)});
                aF = null;
            }
            if (bg.mA(aF) || bg.mA(aF)) {
                return null;
            }
            String[] split = aF.split("\\|");
            String str3 = "MicroMsg.AppBrand.LocalMediaObjectManager.V1Handler";
            String str4 = "retrieveMediaObject, split arrays length %d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(split == null ? -1 : split.length);
            w.i(str3, str4, objArr);
            if (split == null || split.length != 2) {
                return null;
            }
            str3 = split[0];
            str4 = split[1];
            if (bg.mA(str3)) {
                w.e("MicroMsg.AppBrand.LocalMediaObjectManager.V1Handler", "retrieveMediaObject, null or nil fileName(%s) fileMd5(%s)", new Object[]{str2, str3});
                return null;
            }
            aF = c.nP(str) + str2 + ".dat";
            String str5 = c.nP(str) + str2 + ".tmp";
            if (e.aO(aF)) {
                w.i("MicroMsg.AppBrand.LocalMediaObjectManager.V1Handler", "retrieveMediaObject, fileName(%s) appId(%s) permanent file exists", new Object[]{str2, str});
            } else if (e.aO(str5)) {
                w.i("MicroMsg.AppBrand.LocalMediaObjectManager.V1Handler", "retrieveMediaObject, fileName(%s) appId(%s) temp file exists", new Object[]{str2, str});
                aF = str5;
            } else {
                w.e("MicroMsg.AppBrand.LocalMediaObjectManager.V1Handler", "retrieveMediaObject, file not exists, fileName(%s), appId(%s) ", new Object[]{str2, str});
                return null;
            }
            if (g.aV(aF).equals(str3)) {
                AppBrandLocalMediaObject appBrandLocalMediaObject = new AppBrandLocalMediaObject();
                appBrandLocalMediaObject.fJz = "wxfile://" + str2;
                appBrandLocalMediaObject.hos = aF;
                appBrandLocalMediaObject.mimeType = str4;
                appBrandLocalMediaObject.iAS = s.MB(str4);
                appBrandLocalMediaObject.iAT = false;
                return appBrandLocalMediaObject;
            }
            w.e("MicroMsg.AppBrand.LocalMediaObjectManager.V1Handler", "retrieveMediaObject, exactMd5 != fileMd5, fileName(%s), appId(%s) ", new Object[]{str2, str});
            return null;
        }

        public final AppBrandLocalMediaObject aJ(String str, String str2) {
            return null;
        }

        public final AppBrandLocalMediaObject a(AppBrandLocalMediaObject appBrandLocalMediaObject) {
            return null;
        }

        @Deprecated
        public final com.tencent.mm.vending.j.a v(String str, String str2, String str3) {
            return null;
        }
    }

    private static final class d implements a {
        public final String toString() {
            return "V2MediaObjectInfoHandler";
        }

        public final AppBrandLocalMediaObject aI(String str, String str2) {
            if (!str2.startsWith("store_") && !str2.startsWith("tmp_")) {
                return null;
            }
            String Ny = s.Ny(str2);
            String replaceFirst = str2.replaceFirst("store_", "").replaceFirst("tmp_", "");
            if (!bg.mA(Ny)) {
                replaceFirst = replaceFirst.replaceFirst("." + Ny, "");
            }
            if (bg.mA(replaceFirst)) {
                return c.iAX;
            }
            try {
                Ny = c.aF(replaceFirst, str);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e, "retrieveMediaObject, decrypt exp ", new Object[0]);
                Ny = null;
            }
            if (bg.mA(Ny)) {
                w.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, get empty decrypted string");
                return null;
            }
            String[] split = Ny.split("\\|");
            if (split == null || split.length != 2) {
                return c.iAX;
            }
            Ny = str2.startsWith("store_") ? "store_" : "tmp_";
            replaceFirst = c.nP(str) + Ny + replaceFirst;
            long j = bg.getLong(split[0], 0);
            String str3 = split[1];
            try {
                if (j != c.nQ(replaceFirst)) {
                    w.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, exactCRC32(%d) != fileCRC32(%d), localId(%s), appId(%s)", new Object[]{Long.valueOf(c.nQ(replaceFirst)), Long.valueOf(j), str2, str});
                    return c.iAX;
                }
                AppBrandLocalMediaObject appBrandLocalMediaObject = new AppBrandLocalMediaObject();
                appBrandLocalMediaObject.fJz = "wxfile://" + str2;
                appBrandLocalMediaObject.hos = replaceFirst;
                appBrandLocalMediaObject.mimeType = s.Nw(str3);
                appBrandLocalMediaObject.iAT = Ny.equalsIgnoreCase("store_");
                File file = new File(appBrandLocalMediaObject.hos);
                appBrandLocalMediaObject.iAU = file.lastModified();
                appBrandLocalMediaObject.ilG = file.length();
                return appBrandLocalMediaObject;
            } catch (Throwable e2) {
                w.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, getCRC exp = %s", new Object[]{bg.g(e2)});
                return c.iAX;
            }
        }

        public final AppBrandLocalMediaObject a(AppBrandLocalMediaObject appBrandLocalMediaObject) {
            if (appBrandLocalMediaObject == null) {
                return null;
            }
            String replaceFirst = appBrandLocalMediaObject.hos.replaceFirst("tmp_", "store_");
            if (!c.aD(appBrandLocalMediaObject.hos, replaceFirst)) {
                return null;
            }
            AppBrandLocalMediaObject appBrandLocalMediaObject2 = new AppBrandLocalMediaObject();
            appBrandLocalMediaObject2.hos = replaceFirst;
            appBrandLocalMediaObject2.fJz = appBrandLocalMediaObject.fJz.replaceFirst("tmp_", "store_");
            appBrandLocalMediaObject2.ilG = appBrandLocalMediaObject.ilG;
            appBrandLocalMediaObject2.iAS = appBrandLocalMediaObject.iAS;
            appBrandLocalMediaObject2.iAU = new File(appBrandLocalMediaObject2.hos).lastModified();
            appBrandLocalMediaObject2.mimeType = appBrandLocalMediaObject.mimeType;
            appBrandLocalMediaObject2.iAT = true;
            return appBrandLocalMediaObject2;
        }

        public final com.tencent.mm.vending.j.a v(String str, String str2, String str3) {
            String ap = bg.ap(str3, "unknown");
            try {
                String encrypt;
                Long valueOf = Long.valueOf(c.nQ(str2));
                try {
                    encrypt = c.encrypt(String.format(Locale.US, "%d|%s", new Object[]{valueOf, ap}), str);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e, "attachMediaObject, enc exp = ", new Object[0]);
                    encrypt = null;
                }
                if (bg.mA(encrypt)) {
                    return null;
                }
                encrypt = "tmp_" + encrypt;
                String str4 = c.nP(str) + encrypt;
                String str5 = "wxfile://" + encrypt + (bg.mA(ap) ? "" : "." + ap);
                w.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, return localId = %s, filePath = %s", new Object[]{str5, str4});
                com.tencent.mm.vending.j.a dVar = new com.tencent.mm.vending.j.d();
                dVar.wDL = new Object[]{str5, str4, ap};
                return (com.tencent.mm.vending.j.d) dVar;
            } catch (Throwable e2) {
                w.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, get crc exp = %s", new Object[]{bg.g(e2)});
                return null;
            }
        }

        public final AppBrandLocalMediaObject aJ(String str, String str2) {
            String aF;
            String replaceFirst = str2.replaceFirst("store_", "").replaceFirst("tmp_", "");
            try {
                aF = c.aF(replaceFirst, str);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e, "retrieveMediaObjectByRealFileName, dec exp = ", new Object[0]);
                aF = null;
            }
            if (bg.mA(aF)) {
                return null;
            }
            String[] split = aF.split("\\|");
            if (split == null || split.length != 2) {
                return null;
            }
            aF = split[1];
            aF = "wxfile://" + str2 + (bg.mA(aF) ? "" : "." + aF);
            AppBrandLocalMediaObject appBrandLocalMediaObject = new AppBrandLocalMediaObject();
            appBrandLocalMediaObject.fJz = aF;
            appBrandLocalMediaObject.hos = c.nP(str) + str2;
            appBrandLocalMediaObject.iAS = replaceFirst;
            appBrandLocalMediaObject.iAT = true;
            File file = new File(appBrandLocalMediaObject.hos);
            appBrandLocalMediaObject.iAU = file.lastModified();
            appBrandLocalMediaObject.ilG = file.length();
            return appBrandLocalMediaObject;
        }
    }

    static {
        String str = com.tencent.mm.compatible.util.e.hgu;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        iAV = str + "wxafiles/";
        Collection linkedList = new LinkedList();
        linkedList.add(new d());
        linkedList.add(new c());
        iAW = Collections.unmodifiableCollection(linkedList);
    }

    public static String aC(String str, String str2) {
        if (bg.mA(str) || bg.mA(str2)) {
            return null;
        }
        return nP(str) + str2;
    }

    public static boolean aD(String str, String str2) {
        if (VERSION.SDK_INT >= 21) {
            try {
                long Nz = bg.Nz();
                b bVar = new b();
                Os.rename(str, str2);
                w.d("MicroMsg.AppBrand.LocalMediaObjectManager", "renameToImpl, os rename works, cost = %d", new Object[]{Long.valueOf(bg.Nz() - Nz)});
                return true;
            } catch (Throwable e) {
                w.e("MicroMsg.AppBrand.LocalMediaObjectManager", "renameToImpl, os rename exp = %s", new Object[]{bg.g(e)});
            }
        }
        return e.a(new File(str), new File(str2));
    }

    public static List<AppBrandLocalMediaObject> nL(String str) {
        File[] nM = nM(str);
        if (nM == null || nM.length <= 0) {
            return null;
        }
        List<AppBrandLocalMediaObject> linkedList = new LinkedList();
        for (File name : nM) {
            AppBrandLocalMediaObject aG = aG(str, name.getName());
            if (aG != null) {
                linkedList.add(aG);
            }
        }
        return linkedList;
    }

    private static File[] nM(String str) {
        File file = new File(nP(str));
        if (file.exists() && file.isDirectory()) {
            return file.listFiles(new FileFilter() {
                public final boolean accept(File file) {
                    return file.exists() && !file.isDirectory() && !bg.mA(file.getName()) && file.getName().startsWith("store_");
                }
            });
        }
        return null;
    }

    public static long nN(String str) {
        long j = 0;
        File file = new File(nP(str));
        File[] listFiles = (file.exists() && file.isDirectory()) ? file.listFiles(new FileFilter() {
            public final boolean accept(File file) {
                return file.exists() && !file.isDirectory() && !bg.mA(file.getName()) && file.getName().startsWith("tmp_");
            }
        }) : null;
        if (listFiles != null && listFiles.length > 0) {
            int i = 0;
            while (i < listFiles.length) {
                long length = listFiles[i].length() + j;
                i++;
                j = length;
            }
        }
        return j;
    }

    public static long nO(String str) {
        long j = 0;
        File[] nM = nM(str);
        if (nM != null && nM.length > 0) {
            int i = 0;
            while (i < nM.length) {
                long length = nM[i].length() + j;
                i++;
                j = length;
            }
        }
        return j;
    }

    public static AppBrandLocalVideoObject aE(String str, String str2) {
        return (AppBrandLocalVideoObject) a(str, str2, AppBrandLocalVideoObject.class, "mp4", false);
    }

    private static <T extends AppBrandLocalMediaObject> T a(String str, String str2, Class<T> cls, String str3, boolean z) {
        if (bg.mA(str) || !e.aO(str2)) {
            return null;
        }
        String Ny = s.Ny(str2);
        if (!bg.mA(Ny)) {
            str3 = Ny;
        }
        com.tencent.mm.vending.j.a aVar = null;
        for (a v : iAW) {
            aVar = v.v(str, str2, str3);
            if (aVar != null) {
                break;
            }
        }
        com.tencent.mm.vending.j.a aVar2 = aVar;
        if (aVar2 == null || aVar2.size() < 2) {
            int i;
            String str4 = "MicroMsg.AppBrand.LocalMediaObjectManager";
            String str5 = "attachCast, no handler return correct info, attach.size = %d";
            Object[] objArr = new Object[1];
            if (aVar2 == null) {
                i = -1;
            } else {
                i = aVar2.size();
            }
            objArr[0] = Integer.valueOf(i);
            w.e(str4, str5, objArr);
            return null;
        }
        try {
            T t = (AppBrandLocalMediaObject) cls.newInstance();
            t.fJz = (String) aVar2.get(0);
            t.mimeType = s.Nw(str3);
            t.hos = (String) aVar2.get(1);
            t.iAS = bg.ap((String) aVar2.get(3), bg.ap(str3, "unknown"));
            str4 = t.hos;
            int i2 = (z && aD(str2, str4)) ? 1 : (z || !j.ex(str2, str4)) ? 0 : 1;
            if (i2 == 0) {
                return null;
            }
            File file = new File(t.hos);
            t.ilG = file.length();
            t.iAU = file.lastModified();
            return t;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager", e, "", new Object[0]);
            return null;
        }
    }

    public static AppBrandLocalMediaObject c(String str, String str2, boolean z) {
        return b(str, str2, null, z);
    }

    public static AppBrandLocalMediaObject b(String str, String str2, String str3, boolean z) {
        return a(str, str2, AppBrandLocalMediaObject.class, str3, z);
    }

    public static String nP(String str) {
        String str2 = iAV + str + "/";
        h.KS(str2);
        try {
            new File(str2, ".nomedia").createNewFile();
        } catch (Exception e) {
        }
        return str2;
    }

    public static String encrypt(String str, String str2) {
        return bg.bo(new com.tencent.mm.platformtools.s().encrypt(str.getBytes(), str2.getBytes()));
    }

    public static String aF(String str, String str2) {
        byte[] PT = bg.PT(str);
        com.tencent.mm.platformtools.s sVar = new com.tencent.mm.platformtools.s();
        byte[] bytes = str2.getBytes();
        int length = PT.length;
        sVar.preCrypt = 0;
        sVar.crypt = 0;
        sVar.key = bytes;
        bytes = new byte[8];
        if (length % 8 != 0 || length < 16) {
            bytes = null;
        } else {
            sVar.prePlain = sVar.decipher(PT, 0);
            sVar.pos = sVar.prePlain[0] & 7;
            int i = (length - sVar.pos) - 10;
            if (i < 0) {
                bytes = null;
            } else {
                for (int i2 = 0; i2 < 8; i2++) {
                    bytes[i2] = (byte) 0;
                }
                sVar.out = new byte[i];
                sVar.preCrypt = 0;
                sVar.crypt = 8;
                sVar.contextStart = 8;
                sVar.pos++;
                sVar.padding = 1;
                while (sVar.padding <= 2) {
                    if (sVar.pos < 8) {
                        sVar.pos++;
                        sVar.padding++;
                    }
                    if (sVar.pos == 8) {
                        if (!sVar.decrypt8Bytes(PT, 0, length)) {
                            bytes = null;
                            break;
                        }
                        bytes = PT;
                    }
                }
                byte[] bArr = bytes;
                int i3 = 0;
                while (i != 0) {
                    if (sVar.pos < 8) {
                        sVar.out[i3] = (byte) (bArr[(sVar.preCrypt + 0) + sVar.pos] ^ sVar.prePlain[sVar.pos]);
                        i3++;
                        i--;
                        sVar.pos++;
                    }
                    if (sVar.pos == 8) {
                        sVar.preCrypt = sVar.crypt - 8;
                        if (!sVar.decrypt8Bytes(PT, 0, length)) {
                            bytes = null;
                            break;
                        }
                        bArr = PT;
                    }
                }
                sVar.padding = 1;
                bytes = bArr;
                while (sVar.padding < 8) {
                    if (sVar.pos < 8) {
                        if ((bytes[(sVar.preCrypt + 0) + sVar.pos] ^ sVar.prePlain[sVar.pos]) != 0) {
                            bytes = null;
                            break;
                        }
                        sVar.pos++;
                    }
                    if (sVar.pos == 8) {
                        sVar.preCrypt = sVar.crypt;
                        if (!sVar.decrypt8Bytes(PT, 0, length)) {
                            bytes = null;
                            break;
                        }
                        bytes = PT;
                    }
                    sVar.padding++;
                }
                bytes = sVar.out;
            }
        }
        if (bg.mA(str)) {
            return null;
        }
        return new String(bytes);
    }

    public static AppBrandLocalMediaObject a(AppBrandLocalMediaObject appBrandLocalMediaObject) {
        AppBrandLocalMediaObject appBrandLocalMediaObject2 = null;
        for (a a : iAW) {
            appBrandLocalMediaObject2 = a.a(appBrandLocalMediaObject);
            if (appBrandLocalMediaObject2 != null) {
                break;
            }
        }
        return appBrandLocalMediaObject2;
    }

    private static AppBrandLocalMediaObject aG(String str, String str2) {
        AppBrandLocalMediaObject appBrandLocalMediaObject = null;
        if (!bg.mA(str) && !bg.mA(str2)) {
            for (a aJ : iAW) {
                appBrandLocalMediaObject = aJ.aJ(str, str2);
                if (appBrandLocalMediaObject != null) {
                    break;
                }
            }
        }
        return appBrandLocalMediaObject;
    }

    public static AppBrandLocalMediaObject aH(String str, String str2) {
        if (bg.mA(str2) || !str2.startsWith("wxfile://") || bg.mA(str)) {
            w.e("MicroMsg.AppBrand.LocalMediaObjectManager", "getItemByLocalId, invalid args, localId(%s), appId(%s) ", new Object[]{str2, str});
            return null;
        }
        AppBrandLocalMediaObject aI;
        String substring = str2.substring(9);
        AppBrandLocalMediaObject appBrandLocalMediaObject = null;
        for (a aI2 : iAW) {
            aI = aI2.aI(str, substring);
            if (aI != null) {
                w.i("MicroMsg.AppBrand.LocalMediaObjectManager", "getItemByLocalId, handled by %s, result = %s", new Object[]{aI2.toString(), aI});
                break;
            }
            appBrandLocalMediaObject = aI;
        }
        aI = appBrandLocalMediaObject;
        if (iAX != aI) {
            return aI;
        }
        return null;
    }

    public static long nQ(String str) {
        Closeable fileInputStream = new FileInputStream(str);
        Closeable checkedInputStream = new CheckedInputStream(fileInputStream, new Adler32());
        do {
        } while (checkedInputStream.read(new byte[2048]) >= 0);
        long value = checkedInputStream.getChecksum().getValue();
        bg.g(checkedInputStream);
        bg.g(fileInputStream);
        return value;
    }
}
