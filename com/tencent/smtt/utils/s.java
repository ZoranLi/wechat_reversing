package com.tencent.smtt.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class s {
    public b wYG = null;
    public b wYH = null;

    class a {
        long kGT;
        private String mName;
        long wYI;
        final /* synthetic */ s wYJ;

        a(s sVar, String str, long j, long j2) {
            this.wYJ = sVar;
            this.mName = str;
            this.kGT = j;
            this.wYI = j2;
        }
    }

    class b {
        public Map<String, a> iyO = new HashMap();
        final /* synthetic */ s wYJ;

        public b(s sVar, File file) {
            this.wYJ = sVar;
            this.iyO.clear();
            M(file);
        }

        private void M(File file) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File M : listFiles) {
                    M(M);
                }
            } else if (file.isFile()) {
                String name = file.getName();
                long length = file.length();
                long lastModified = file.lastModified();
                if (name != null && name.length() > 0 && length > 0 && lastModified > 0) {
                    a aVar = new a(this.wYJ, name, length, lastModified);
                    if (!this.iyO.containsKey(name)) {
                        this.iyO.put(name, aVar);
                    }
                }
            }
        }
    }

    public static boolean a(b bVar, b bVar2) {
        if (bVar == null || bVar.iyO == null || bVar2 == null || bVar2.iyO == null) {
            return false;
        }
        Map map = bVar.iyO;
        Map map2 = bVar2.iyO;
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            a aVar = (a) entry.getValue();
            if (!map2.containsKey(str)) {
                return false;
            }
            a aVar2 = (a) map2.get(str);
            if (aVar.kGT == aVar2.kGT) {
                if (aVar.wYI != aVar2.wYI) {
                }
            }
            return false;
        }
        return true;
    }
}
