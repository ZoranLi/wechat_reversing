package com.tencent.mm.an;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

public abstract class a {
    public static String hMW = "";
    public static String hMX = "";
    public String TEXT;
    public String TYPE;
    public au fTk;
    public String hMY = "";
    public String hMZ;
    public LinkedList<String> hNa = new LinkedList();
    public LinkedList<Integer> hNb = new LinkedList();
    public LinkedList<Integer> hNc = new LinkedList();
    public Map<String, String> values;

    public static abstract class a {
        private static HashMap<String, a> hNd = new HashMap();

        public abstract a a(Map<String, String> map, au auVar);

        public static void a(String str, a aVar) {
            Assert.assertNotNull(str);
            Assert.assertNotNull(aVar);
            synchronized (hNd) {
                hNd.put(str.toLowerCase(), aVar);
            }
        }

        public static a b(Map<String, String> map, au auVar) {
            if (map == null) {
                w.e("MicroMsg.BaseNewXmlMsg", "values is null !!!");
                return null;
            }
            String str = (String) map.get(".sysmsg.$type");
            synchronized (hNd) {
                a aVar = (a) hNd.get(str.toLowerCase());
                if (aVar == null) {
                    w.w("MicroMsg.BaseNewXmlMsg", "TYPE %s is unDefine", str);
                    return null;
                }
                a a = aVar.a((Map) map, auVar);
                return a;
            }
        }
    }

    protected abstract boolean HU();

    a(Map<String, String> map) {
        this.values = map;
    }

    a(Map<String, String> map, au auVar) {
        this.values = map;
        this.fTk = auVar;
    }

    public final boolean HT() {
        if (this.values == null || this.values.size() <= 0) {
            w.e("MicroMsg.BaseNewXmlMsg", "values == null || values.size() == 0 ");
            return false;
        }
        if (this.values.containsKey(".sysmsg.$type")) {
            this.TYPE = (String) this.values.get(".sysmsg.$type");
        }
        hMW = ".sysmsg." + this.TYPE + ".text";
        if (this.values.containsKey(hMW)) {
            this.TEXT = (String) this.values.get(hMW);
        }
        hMX = ".sysmsg." + this.TYPE + ".link.scene";
        if (this.values.containsKey(hMX)) {
            this.hMZ = (String) this.values.get(hMX);
        }
        return HU();
    }
}
