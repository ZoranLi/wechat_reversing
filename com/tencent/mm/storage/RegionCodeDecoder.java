package com.tencent.mm.storage;

import com.tencent.mm.a.g;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public final class RegionCodeDecoder {
    private static RegionCodeDecoder uKF = null;
    public static final String uKG = (e.hgp + "MicroMsg/regioncode/");
    public String uKH = "";
    private String uKI = "";

    private static class DecoderJni {
        public static native void buildFromFile(String str);

        public static native Region[] getCities(String str, String str2, String str3);

        public static native Region[] getCountries(String str);

        public static native String getLocName(String str);

        public static native Region[] getProvinces(String str, String str2);

        public static native void release();

        private DecoderJni() {
        }
    }

    public static class Region {
        private String code;
        private String countryCode;
        private boolean hasChildren = false;
        private boolean isCity = false;
        private boolean isCountry = false;
        private boolean isProvince = false;
        private String name;
        private Region parent = null;

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getCode() {
            return this.code;
        }

        public void setCode(String str) {
            this.code = str;
        }

        public boolean hasChildren() {
            return this.hasChildren;
        }

        public void setHasChildren(boolean z) {
            this.hasChildren = z;
        }

        public void setParent(Region region) {
            this.parent = region;
        }

        public Region getParent() {
            return this.parent;
        }

        public void setCountryCode(String str) {
            this.countryCode = str;
        }

        public String getCountryCode() {
            return this.countryCode;
        }

        public boolean isCountry() {
            return this.isCountry;
        }

        public void setCountry(boolean z) {
            this.isCountry = z;
        }

        public boolean isProvince() {
            return this.isProvince;
        }

        public void setProvince(boolean z) {
            this.isProvince = z;
        }

        public boolean isCity() {
            return this.isCity;
        }

        public void setCity(boolean z) {
            this.isCity = z;
        }
    }

    public static RegionCodeDecoder bMP() {
        if (uKF == null) {
            uKF = new RegionCodeDecoder();
        }
        RegionCodeDecoder regionCodeDecoder = uKF;
        if (!v.bIN().equals(regionCodeDecoder.uKH)) {
            regionCodeDecoder.bKR();
        }
        return uKF;
    }

    public final void bKR() {
        File file = new File(uKG);
        if (!file.exists()) {
            file.mkdir();
            A(file);
        }
        String[] list = file.list();
        if (list == null || list.length == 0) {
            A(file);
        }
        this.uKH = v.bIN();
        String bMQ = bMQ();
        if (bg.mA(bMQ)) {
            w.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found, curLang: " + this.uKH);
            return;
        }
        String str = uKG + bMQ;
        File file2 = new File(str);
        bMQ = y(file2);
        if (bg.mA(bMQ) ? false : bMQ.equals(z(file2))) {
            bMQ = str;
        } else {
            File file3;
            if (j.y(ab.getContext(), "regioncode/" + file2.getName(), str)) {
                bMQ = str;
            } else {
                file3 = new File(file2.getParentFile(), "mmregioncode_en.txt");
                bMQ = file3.getAbsolutePath();
                if (!j.y(ab.getContext(), "regioncode/mmregioncode_en.txt", file3.getAbsolutePath())) {
                    bMQ = null;
                }
            }
            file3 = new File(bMQ);
            d(file3, file3.getParentFile());
            w.w("MicroMsg.RegionCodeDecoder", "Verifying codeFile: %s failed, after fallback, %s will be used.", file2.getName(), file3.getName());
        }
        if (bg.mA(bMQ)) {
            w.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found after verify, curLang: " + this.uKH);
        } else if (bg.mA(this.uKI) || !this.uKI.equals(str) || !str.equals(bMQ)) {
            w.w("MicroMsg.RegionCodeDecoder", "buildMap, after verify, codeFile %s is used. curLang: %s", new File(bMQ).getName(), this.uKH);
            this.uKI = bMQ;
            DecoderJni.buildFromFile(this.uKI);
        }
    }

    private static String y(File file) {
        BufferedReader bufferedReader;
        Throwable th;
        Throwable th2;
        String str = null;
        File file2 = new File(file.getAbsolutePath() + ".hash");
        if (file2.exists()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(file2));
                try {
                    str = bufferedReader.readLine();
                    try {
                        bufferedReader.close();
                    } catch (Throwable th3) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        w.printErrStackTrace("MicroMsg.RegionCodeDecoder", th, "Failed to read saved hash from hash file: %s", file2.getName());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th5) {
                            }
                        }
                        return str;
                    } catch (Throwable th6) {
                        th2 = th6;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th7) {
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th8) {
                bufferedReader = str;
                th2 = th8;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th2;
            }
        }
        return str;
    }

    public static void d(File file, File file2) {
        PrintWriter printWriter;
        Throwable th;
        w.i("MicroMsg.RegionCodeDecoder", "Generating hash file for: %s", file.getName());
        File file3 = new File(file2, file.getName() + ".hash");
        String z = z(file);
        if (!bg.mA(z)) {
            if (!file3.exists()) {
                file3.getParentFile().mkdirs();
            }
            try {
                printWriter = new PrintWriter(file3);
                try {
                    printWriter.print(z);
                    try {
                        printWriter.close();
                    } catch (Throwable th2) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        w.printErrStackTrace("MicroMsg.RegionCodeDecoder", th, "Failed to save hash file of %s", file.getName());
                        if (printWriter != null) {
                            try {
                                printWriter.close();
                            } catch (Throwable th4) {
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        if (printWriter != null) {
                            try {
                                printWriter.close();
                            } catch (Throwable th6) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                printWriter = null;
                if (printWriter != null) {
                    printWriter.close();
                }
                throw th;
            }
        }
    }

    private static String z(File file) {
        String f = g.f(file);
        if (!bg.mA(f)) {
            return aa.Pq(f + "#" + file.lastModified() + "#" + p.rA());
        }
        w.e("MicroMsg.RegionCodeDecoder", "Failed to calculate hash for file %s", file.getName());
        return null;
    }

    private synchronized void A(File file) {
        synchronized (this) {
            String[] strArr = null;
            if (file.exists()) {
                strArr = file.list();
            }
            if (!file.exists() || r1 == null || r1.length == 0) {
                try {
                    for (String str : ab.getContext().getAssets().list("regioncode")) {
                        w.i("MicroMsg.RegionCodeDecoder", "from:%s,  to:%s", "regioncode/" + str, file.getPath() + "/" + str);
                        String str2 = file.getPath() + "/" + str;
                        j.y(ab.getContext(), "regioncode/" + str, str2);
                        d(new File(str2), file);
                    }
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.RegionCodeDecoder", e, "", new Object[0]);
                }
            }
        }
    }

    public final String bMQ() {
        String str = "mmregioncode_" + (this.uKH.equalsIgnoreCase("zh_HK") ? "zh_TW" : this.uKH) + ".txt";
        String str2 = "mmregioncode_en.txt";
        File file = new File(uKG);
        if (file.exists()) {
            String[] list = file.list();
            if (list == null || list.length == 0) {
                return null;
            }
            Object obj = null;
            for (String str3 : list) {
                if (str3.equals(str)) {
                    return str3;
                }
                if (obj == null && str3.equals(str2)) {
                    obj = 1;
                }
            }
            return obj != null ? str2 : null;
        } else {
            file.mkdir();
            return null;
        }
    }

    public static final String ab(String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        if (!bg.mA(str)) {
            stringBuffer.append(str);
            if (!bg.mA(str2)) {
                stringBuffer.append('_');
                stringBuffer.append(str2);
                if (!bg.mA(str3)) {
                    stringBuffer.append('_');
                    stringBuffer.append(str3);
                }
            }
        }
        return stringBuffer.toString();
    }

    public static String RQ(String str) {
        if (bg.mA(str) || !v.Pn(str)) {
            w.e("MicroMsg.RegionCodeDecoder", "unsupported language:" + str);
            return null;
        }
        if (str.equalsIgnoreCase("zh_HK")) {
            str = "zh_TW";
        }
        return uKG + "mmregioncode_" + str + ".txt";
    }

    public static final boolean RR(String str) {
        if (bg.mA(str)) {
            return false;
        }
        return str.equalsIgnoreCase("cn");
    }

    public static String getLocName(String str) {
        if (bg.mA(str)) {
            return null;
        }
        return DecoderJni.getLocName(str);
    }

    public final String RS(String str) {
        String locName = getLocName(str);
        return bg.mA(locName) ? bg.mz(str) : locName;
    }

    public final String eL(String str, String str2) {
        String str3 = null;
        if (!(bg.mA(str) || bg.mA(str2))) {
            str3 = getLocName(ab(str, str2, null));
        }
        return bg.mA(str3) ? bg.mz(str2) : str3;
    }

    public final String ac(String str, String str2, String str3) {
        String locName = (bg.mA(str) || bg.mA(str2) || bg.mA(str3)) ? null : getLocName(ab(str, str2, str3));
        return bg.mA(locName) ? bg.mz(str3) : locName;
    }

    public final Region[] bMR() {
        if (bg.mA(this.uKI)) {
            return null;
        }
        return DecoderJni.getCountries(this.uKI);
    }

    public final Region[] RT(String str) {
        if (bg.mA(this.uKI) || bg.mA(str)) {
            return null;
        }
        return DecoderJni.getProvinces(this.uKI, str);
    }

    public final Region[] eM(String str, String str2) {
        if (bg.mA(this.uKI) || bg.mA(str) || bg.mA(str2)) {
            return null;
        }
        return DecoderJni.getCities(this.uKI, str, str2);
    }
}
