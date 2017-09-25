package com.tencent.tinker.loader.shareutil;

import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Pattern;

public class ShareResPatchInfo {
    public String xiJ = null;
    public String xiK = null;
    public ArrayList<String> xiL = new ArrayList();
    public ArrayList<String> xiM = new ArrayList();
    public ArrayList<String> xiN = new ArrayList();
    public ArrayList<String> xiO = new ArrayList();
    public HashMap<String, LargeModeInfo> xiP = new HashMap();
    public HashSet<Pattern> xiQ = new HashSet();

    public static class LargeModeInfo {
        public String fFW = null;
        public File file = null;
        public long xfC;
    }

    public static void a(String str, ShareResPatchInfo shareResPatchInfo) {
        if (str != null && str.length() != 0) {
            String[] split = str.split("\n");
            int i = 0;
            while (i < split.length) {
                String str2 = split[i];
                if (str2 != null && str2.length() > 0) {
                    if (str2.startsWith("resources_out.zip")) {
                        String[] split2 = str2.split(",", 3);
                        shareResPatchInfo.xiJ = split2[1];
                        shareResPatchInfo.xiK = split2[2];
                    } else if (str2.startsWith("pattern:")) {
                        r2 = i;
                        for (int parseInt = Integer.parseInt(str2.split(":", 2)[1]); parseInt > 0; parseInt--) {
                            HashSet hashSet = shareResPatchInfo.xiQ;
                            String str3 = split[r2 + 1];
                            if (str3.contains(".")) {
                                str3 = str3.replaceAll("\\.", "\\\\.");
                            }
                            if (str3.contains("?")) {
                                str3 = str3.replaceAll("\\?", "\\.");
                            }
                            if (str3.contains("*")) {
                                str3 = str3.replace("*", ".*");
                            }
                            hashSet.add(Pattern.compile(str3));
                            r2++;
                        }
                        i = r2;
                    } else if (str2.startsWith("add:")) {
                        r2 = Integer.parseInt(str2.split(":", 2)[1]);
                        while (r2 > 0) {
                            shareResPatchInfo.xiL.add(split[i + 1]);
                            r2--;
                            i++;
                        }
                    } else if (str2.startsWith("modify:")) {
                        r2 = Integer.parseInt(str2.split(":", 2)[1]);
                        while (r2 > 0) {
                            shareResPatchInfo.xiN.add(split[i + 1]);
                            r2--;
                            i++;
                        }
                    } else if (str2.startsWith("large modify:")) {
                        r2 = Integer.parseInt(str2.split(":", 2)[1]);
                        while (r2 > 0) {
                            String[] split3 = split[i + 1].split(",", 3);
                            Object obj = split3[0];
                            LargeModeInfo largeModeInfo = new LargeModeInfo();
                            largeModeInfo.fFW = split3[1];
                            largeModeInfo.xfC = Long.parseLong(split3[2]);
                            shareResPatchInfo.xiO.add(obj);
                            shareResPatchInfo.xiP.put(obj, largeModeInfo);
                            r2--;
                            i++;
                        }
                    } else if (str2.startsWith("delete:")) {
                        r2 = Integer.parseInt(str2.split(":", 2)[1]);
                        while (r2 > 0) {
                            shareResPatchInfo.xiM.add(split[i + 1]);
                            r2--;
                            i++;
                        }
                    }
                }
                i++;
            }
        }
    }

    public static boolean a(HashSet<Pattern> hashSet, String str) {
        if (!hashSet.isEmpty()) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                if (((Pattern) it.next()).matcher(str).matches()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean a(ShareResPatchInfo shareResPatchInfo) {
        if (shareResPatchInfo == null) {
            return false;
        }
        String str = shareResPatchInfo.xiK;
        if (str == null || str.length() != 32) {
            return false;
        }
        return true;
    }

    public static void b(String str, ShareResPatchInfo shareResPatchInfo) {
        if (str != null && str.length() != 0) {
            String str2 = str.split("\n")[0];
            if (str2 == null || str2.length() <= 0) {
                throw new TinkerRuntimeException("res meta Corrupted:" + str);
            }
            String[] split = str2.split(",", 3);
            shareResPatchInfo.xiJ = split[1];
            shareResPatchInfo.xiK = split[2];
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("resArscMd5:" + this.xiK + "\n");
        stringBuffer.append("arscBaseCrc:" + this.xiJ + "\n");
        Iterator it = this.xiQ.iterator();
        while (it.hasNext()) {
            stringBuffer.append("pattern:" + ((Pattern) it.next()) + "\n");
        }
        it = this.xiL.iterator();
        while (it.hasNext()) {
            stringBuffer.append("addedSet:" + ((String) it.next()) + "\n");
        }
        it = this.xiN.iterator();
        while (it.hasNext()) {
            stringBuffer.append("modifiedSet:" + ((String) it.next()) + "\n");
        }
        it = this.xiO.iterator();
        while (it.hasNext()) {
            stringBuffer.append("largeModifiedSet:" + ((String) it.next()) + "\n");
        }
        it = this.xiM.iterator();
        while (it.hasNext()) {
            stringBuffer.append("deletedSet:" + ((String) it.next()) + "\n");
        }
        return stringBuffer.toString();
    }
}
