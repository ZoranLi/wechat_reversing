package com.tencent.mm.b;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class i {
    public String fvk;
    private Map<String, a> fvl = new HashMap();
    public int versionCode;

    public static class a {
        String fvm;
        public String fvn;
        public String fvo;
        public int size;
        public String url;

        public a(String str, String str2, String str3, String str4, int i) {
            this.fvm = str;
            this.fvn = str2;
            this.fvo = str3;
            this.size = i;
            this.url = str4;
        }
    }

    public i(String str, int i) {
        if (str == null) {
            this.fvk = "http://dldir1.qq.com/weixin/android/";
        } else {
            this.fvk = str;
        }
        this.versionCode = i;
    }

    public final void a(a aVar) {
        this.fvl.put(aVar.fvm, aVar);
    }

    public final a bb(String str) {
        return (a) this.fvl.get(str);
    }

    public final String nX() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("<patchupdate base=\"%s\" count=\"%d\" versioncode=\"%d\">", new Object[]{this.fvk, Integer.valueOf(this.fvl.size()), Integer.valueOf(this.versionCode)}));
        for (Entry value : this.fvl.entrySet()) {
            a aVar = (a) value.getValue();
            stringBuilder.append(String.format("<item old=\"%s\" new=\"%s\" patch=\"%s\" url=\"%s\" size=\"%s\"></item>", new Object[]{aVar.fvm, aVar.fvn, aVar.fvo, aVar.url, Integer.valueOf(aVar.size)}));
        }
        stringBuilder.append("</patchupdate>");
        return stringBuilder.toString();
    }

    public static i bc(String str) {
        Map q = f.q(str, "patchupdate");
        if (q == null) {
            return null;
        }
        i iVar = new i((String) q.get(".patchupdate.$base"), j.bd((String) q.get(".patchupdate.$versioncode")));
        int bd = j.bd((String) q.get(".patchupdate.$count"));
        int i = 0;
        while (i < bd) {
            Object obj;
            String str2 = ".patchupdate.item" + (i > 0 ? Integer.valueOf(i) : "");
            a aVar = new a((String) q.get(new StringBuilder(String.valueOf(str2)).append(".$old").toString()), (String) q.get(new StringBuilder(String.valueOf(str2)).append(".$new").toString()), (String) q.get(new StringBuilder(String.valueOf(str2)).append(".$patch").toString()), (String) q.get(new StringBuilder(String.valueOf(str2)).append(".$url").toString()), j.bd((String) q.get(new StringBuilder(String.valueOf(str2)).append(".$size").toString())));
            if (aVar.fvm == null || aVar.fvn == null || aVar.fvo == null || aVar.url == null) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                iVar.fvl.put(aVar.fvm, aVar);
            }
            i++;
        }
        return iVar;
    }
}
