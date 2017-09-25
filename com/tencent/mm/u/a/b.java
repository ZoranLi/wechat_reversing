package com.tencent.mm.u.a;

import java.util.HashMap;

public final class b {
    public String hou;
    public String hov;
    public String how;
    public String hox;
    public HashMap<String, e> hoy = new HashMap();

    public final e gu(String str) {
        if (this.hoy == null || !this.hoy.containsKey(str)) {
            return null;
        }
        return (e) this.hoy.get(str);
    }
}
