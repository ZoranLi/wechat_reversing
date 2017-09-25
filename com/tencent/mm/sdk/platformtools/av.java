package com.tencent.mm.sdk.platformtools;

import android.os.Environment;
import android.os.StatFs;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class av {
    static String[] uvm = new String[]{"sysfs", "rootfs", "binfmt_misc", "anon_inodefs", "bdev", "proc", "cgroup", "tmpfs", "debugfs", "sockfs", "pipefs", "rpc_pipefs", "devpts", "ramfs", "fuseblk", "fusectl", "selinuxfs"};
    static String[] uvn = new String[]{"vfat", "exfat", "fuse", "sdcardfs"};
    static String[] uvo = new String[]{"/mnt/secure", "/mnt/asec", "/mnt/obb", "/dev/mapper", "/data/"};
    static String[] uvp = new String[]{"/dev/block/vold"};

    public static class a {
        public boolean aQD;
        public String uvq;
        public String uvr;
        public String uvs;
        public long uvt;
        public long uvu;
        public long uvv;
        public long uvw;
        a uvx;

        public final String toString() {
            return "{DevName=" + this.uvq + ", MountDir=" + this.uvr + ", FileSystem=" + this.uvs + ", TotalBlocks=" + this.uvt + ", FreeBlocks=" + this.uvu + ", AvailableBlocks=" + this.uvv + ", BlockSize=" + this.uvw + ", Shared=" + (this.uvx != null) + "}";
        }

        public final boolean equals(Object obj) {
            a aVar = (a) obj;
            if (this.uvw != aVar.uvw) {
                return false;
            }
            long j = this.uvt - aVar.uvt;
            long j2 = this.uvu - aVar.uvu;
            long j3 = this.uvv - aVar.uvv;
            if (Math.abs(j - j2) > 4 || Math.abs(j - j3) > 4 || Math.abs(j2 - j3) > 4) {
                return false;
            }
            return true;
        }
    }

    private static ArrayList<a> bJz() {
        BufferedReader bufferedReader;
        Throwable e;
        Exception e2;
        ArrayList<a> arrayList = new ArrayList();
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/mounts"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        String[] split = readLine.split("\\s+");
                        if (split == null || split.length < 3) {
                            w.e("MicroMsg.SdcardUtil", "splite failed for line: " + readLine);
                        } else {
                            a aVar = new a();
                            aVar.uvq = split[0];
                            aVar.uvr = split[1];
                            aVar.uvs = split[2];
                            arrayList.add(aVar);
                        }
                    } else {
                        try {
                            break;
                        } catch (Throwable e3) {
                            w.printErrStackTrace("MicroMsg.SdcardUtil", e3, "", new Object[0]);
                        }
                    }
                } catch (Exception e4) {
                    e2 = e4;
                }
            }
            bufferedReader.close();
        } catch (Exception e5) {
            e2 = e5;
            bufferedReader = null;
            try {
                w.e("MicroMsg.SdcardUtil", "parseProcMounts", e2);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable e32) {
                        w.printErrStackTrace("MicroMsg.SdcardUtil", e32, "", new Object[0]);
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                e32 = th;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable e6) {
                        w.printErrStackTrace("MicroMsg.SdcardUtil", e6, "", new Object[0]);
                    }
                }
                throw e32;
            }
        } catch (Throwable th2) {
            e32 = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw e32;
        }
        return arrayList;
    }

    private static void a(a aVar) {
        try {
            StatFs statFs = new StatFs(aVar.uvr);
            aVar.uvw = (long) statFs.getBlockSize();
            aVar.uvv = (long) statFs.getAvailableBlocks();
            aVar.uvt = (long) statFs.getBlockCount();
            aVar.uvu = (long) statFs.getFreeBlocks();
        } catch (IllegalArgumentException e) {
            w.e("MicroMsg.SdcardUtil", "statFsForStatMountParse", e);
        }
    }

    private static boolean b(a aVar) {
        FileOutputStream fileOutputStream;
        boolean delete;
        IOException e;
        Throwable e2;
        File file = new File(aVar.uvr, "test_writable");
        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write("test".getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
                delete = file.delete();
                try {
                    fileOutputStream.close();
                } catch (Throwable e3) {
                    w.printErrStackTrace("MicroMsg.SdcardUtil", e3, "", new Object[0]);
                }
            } catch (IOException e4) {
                e = e4;
                try {
                    w.e("MicroMsg.SdcardUtil", "createNewFile: " + e.getMessage() + " dir: " + aVar.uvr);
                    if (fileOutputStream == null) {
                        delete = false;
                    } else {
                        try {
                            fileOutputStream.close();
                            delete = false;
                        } catch (Throwable e22) {
                            w.printErrStackTrace("MicroMsg.SdcardUtil", e22, "", new Object[0]);
                            delete = false;
                        }
                    }
                    aVar.aQD = delete;
                    return delete;
                } catch (Throwable th) {
                    e22 = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e32) {
                            w.printErrStackTrace("MicroMsg.SdcardUtil", e32, "", new Object[0]);
                        }
                    }
                    throw e22;
                }
            }
        } catch (IOException e5) {
            e = e5;
            fileOutputStream = null;
            w.e("MicroMsg.SdcardUtil", "createNewFile: " + e.getMessage() + " dir: " + aVar.uvr);
            if (fileOutputStream == null) {
                fileOutputStream.close();
                delete = false;
            } else {
                delete = false;
            }
            aVar.aQD = delete;
            return delete;
        } catch (Throwable th2) {
            e22 = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e22;
        }
        aVar.aQD = delete;
        return delete;
    }

    private static a bJA() {
        a aVar;
        ArrayList bJz = bJz();
        String absolutePath = Environment.getDataDirectory().getAbsolutePath();
        Iterator it = bJz.iterator();
        while (it.hasNext()) {
            aVar = (a) it.next();
            if (aVar.uvr.equals(absolutePath)) {
                break;
            }
        }
        aVar = null;
        if (aVar == null) {
            aVar = new a();
            aVar.uvr = absolutePath;
            aVar.uvq = "Unknown";
            aVar.uvs = "Unknown";
        }
        a(aVar);
        return aVar;
    }

    private static a bJB() {
        a aVar;
        ArrayList bJz = bJz();
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        Iterator it = bJz.iterator();
        while (it.hasNext()) {
            aVar = (a) it.next();
            if (aVar.uvr.equals(absolutePath)) {
                break;
            }
        }
        aVar = null;
        if (aVar == null) {
            aVar = new a();
            aVar.uvr = absolutePath;
            aVar.uvq = "Unknown";
            aVar.uvs = "Unknown";
        }
        a(aVar);
        return aVar;
    }

    public static ArrayList<a> bJC() {
        int size;
        ArrayList<a> bJz = bJz();
        int size2 = bJz.size();
        List asList = Arrays.asList(uvn);
        List<String> asList2 = Arrays.asList(uvo);
        List<String> asList3 = Arrays.asList(uvp);
        for (int i = size2 - 1; i >= 0; i--) {
            int i2;
            a aVar = (a) bJz.get(i);
            if (asList.contains(aVar.uvs)) {
                i2 = 0;
                for (String startsWith : asList2) {
                    i2 = aVar.uvr.startsWith(startsWith) | i2;
                }
                if (i2 != 0) {
                    bJz.remove(i);
                    w.d("MicroMsg.SdcardUtil", "Remove with bad mount dir1: " + aVar.uvr);
                } else if (aVar.uvs.equals("fuse") || aVar.uvs.equals("sdcardfs")) {
                    if (aVar.uvq.startsWith("/data/")) {
                        bJz.remove(i);
                        w.d("MicroMsg.SdcardUtil", "Remove with bad mount dir2: " + aVar.uvq);
                    }
                } else if (!(aVar.uvs.equals("fuse") || aVar.uvs.equals("sdcardfs"))) {
                    i2 = 0;
                    for (String startsWith2 : asList3) {
                        i2 = aVar.uvq.startsWith(startsWith2) | i2;
                    }
                    if (i2 == 0) {
                        bJz.remove(i);
                        w.d("MicroMsg.SdcardUtil", "Remove with bad device name: " + aVar.uvq);
                    }
                }
            } else {
                bJz.remove(i);
                w.d("MicroMsg.SdcardUtil", "Remove with filesystem mismatch: " + aVar.uvs);
            }
        }
        String path = Environment.getExternalStorageDirectory().getPath();
        for (size = bJz.size() - 1; size >= 0; size--) {
            aVar = (a) bJz.get(size);
            if (aVar.uvr.equals(path)) {
                bJz.remove(size);
                bJz.add(0, aVar);
                size2 = 1;
                break;
            }
        }
        size2 = 0;
        if (size2 == 0) {
            aVar = new a();
            aVar.uvr = path;
            aVar.uvs = "unknown";
            aVar.uvq = "unknown";
            bJz.add(0, aVar);
        }
        for (size = bJz.size() - 1; size >= 0; size--) {
            aVar = (a) bJz.get(size);
            File file = new File(aVar.uvr);
            if (!file.exists() || !file.isDirectory()) {
                w.d("MicroMsg.SdcardUtil", "Directory verify failed: " + aVar);
                bJz.remove(size);
            }
        }
        for (size = bJz.size() - 1; size >= 0; size--) {
            aVar = (a) bJz.get(size);
            if (!b(aVar)) {
                w.d("MicroMsg.SdcardUtil", "Directory testPermissionForStatMountParse failed: " + aVar);
                bJz.remove(size);
            }
        }
        ArrayList arrayList = new ArrayList();
        while (!bJz.isEmpty()) {
            i2 = bJz.size() - 1;
            a aVar2 = (a) bJz.remove(0);
            while (i2 >= 0) {
                aVar = (a) bJz.get(i2);
                if (aVar2.uvq.equals(aVar.uvq)) {
                    bJz.remove(i2);
                    w.d("MicroMsg.SdcardUtil", "Duplicate with same DevName:" + aVar2.uvq);
                    if (!aVar2.aQD && aVar.aQD) {
                        w.d("MicroMsg.SdcardUtil", "Keep the writable one, discard the unwritable one");
                        i2--;
                        aVar2 = aVar;
                    }
                }
                aVar = aVar2;
                i2--;
                aVar2 = aVar;
            }
            arrayList.add(aVar2);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a((a) it.next());
        }
        bJz.clear();
        while (!arrayList.isEmpty()) {
            aVar2 = (a) arrayList.remove(0);
            bJz.add(aVar2);
            for (i2 = arrayList.size() - 1; i2 >= 0; i2--) {
                aVar = (a) arrayList.get(i2);
                if (aVar2.equals(aVar)) {
                    w.d("MicroMsg.SdcardUtil", "Duplicate:" + aVar2.toString() + "---" + aVar.toString());
                    arrayList.remove(i2);
                }
            }
        }
        return bJz;
    }

    public static long bJD() {
        a bJA = bJA();
        return bJA.uvw * bJA.uvv;
    }

    public static long bJE() {
        a bJB = bJB();
        return bJB.uvw * bJB.uvv;
    }

    public static boolean bJF() {
        a aVar;
        boolean z;
        a aVar2 = null;
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList bJz = bJz();
        String absolutePath = Environment.getDataDirectory().getAbsolutePath();
        String absolutePath2 = Environment.getExternalStorageDirectory().getAbsolutePath();
        Iterator it = bJz.iterator();
        a aVar3 = null;
        while (it.hasNext()) {
            aVar = (a) it.next();
            if (aVar3 == null && aVar.uvr.equals(absolutePath)) {
                if (aVar2 != null) {
                    aVar3 = aVar;
                    break;
                }
                aVar3 = aVar;
            } else {
                if (aVar2 == null && aVar.uvr.equals(absolutePath2)) {
                    if (aVar3 != null) {
                        aVar2 = aVar;
                        break;
                    }
                }
                aVar = aVar2;
                aVar2 = aVar;
            }
        }
        if (aVar3 != null && aVar2 == null && !bg.mA(absolutePath2) && absolutePath2.contains("emulated")) {
            String substring = absolutePath2.substring(absolutePath2.lastIndexOf(47) + 1);
            w.i("MicroMsg.SdcardUtil", "hasUnRemovableStorage multiuser uid[%s][%d]", substring, Integer.valueOf(bg.getInt(substring, -1)));
            if (bg.getInt(substring, -1) != -1) {
                absolutePath = absolutePath2.substring(0, (absolutePath2.length() - substring.length()) - 1);
                if (!bg.mA(absolutePath)) {
                    Iterator it2 = bJz.iterator();
                    while (it2.hasNext()) {
                        aVar = (a) it2.next();
                        if (aVar.uvr.equals(absolutePath)) {
                            break;
                        }
                    }
                }
            }
        }
        aVar = aVar2;
        if (!(aVar3 == null || aVar == null)) {
            a(aVar3);
            a(aVar);
            w.d("MicroMsg.SdcardUtil", "hasUnRemovableStorage stats dataStatMountParse[%s] storageStatMountParse[%s]", aVar3, aVar);
            if ((aVar.uvs.equals("fuse") || aVar.uvs.equals("sdcardfs") || aVar.uvs.equals("esdfs")) && aVar3.uvt >= aVar.uvt && aVar.uvt > 0 && aVar3.uvw >= aVar.uvw && aVar.uvw > 0 && aVar3.uvv >= aVar.uvv) {
                z = true;
                w.i("MicroMsg.SdcardUtil", "hasUnRemovableStorage ret[%b], take[%d]ms", Boolean.valueOf(z), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                return z;
            }
        }
        z = false;
        w.i("MicroMsg.SdcardUtil", "hasUnRemovableStorage ret[%b], take[%d]ms", Boolean.valueOf(z), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return z;
    }

    public static String PE(String str) {
        String str2 = "";
        if (bg.mA(str)) {
            return str2;
        }
        ArrayList bJz = bJz();
        Iterator it = bJz.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (str.equals(aVar.uvr)) {
                str2 = aVar.uvs;
                break;
            }
        }
        w.i("MicroMsg.SdcardUtil", "getFileSystem[%s] is [%s]", str, str2);
        if (!bg.mA(str2) || !str.contains("emulated")) {
            return str2;
        }
        String substring = str.substring(str.lastIndexOf(47) + 1);
        w.i("MicroMsg.SdcardUtil", "getFileSystem multiuser uid[%s][%d]", substring, Integer.valueOf(bg.getInt(substring, -1)));
        if (bg.getInt(substring, -1) == -1) {
            return str2;
        }
        String substring2 = str.substring(0, (str.length() - substring.length()) - 1);
        if (bg.mA(substring2)) {
            return str2;
        }
        Iterator it2 = bJz.iterator();
        while (it2.hasNext()) {
            aVar = (a) it2.next();
            if (substring2.equals(aVar.uvr)) {
                w.i("MicroMsg.SdcardUtil", "getFileSystem[%s] fix[%s] is [%s]", str, substring2, aVar.uvs);
                return aVar.uvs;
            }
        }
        return str2;
    }
}
