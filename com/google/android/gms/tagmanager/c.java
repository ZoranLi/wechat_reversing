package com.google.android.gms.tagmanager;

import com.tencent.mm.plugin.gif.MMGIFException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c {
    public static final Object aDL = new Object();
    static final String[] aDM = "gtm.lifetime".toString().split("\\.");
    private static final Pattern aDN = Pattern.compile("(\\d+)\\s*([smhd]?)");
    private final ConcurrentHashMap<b, Integer> aDO;
    private final Map<String, Object> aDP;
    private final ReentrantLock aDQ;
    private final LinkedList<Map<String, Object>> aDR;
    private final c aDS;
    public final CountDownLatch aDT;

    static final class a {
        public final Object aDV;
        public final String azV;

        a(String str, Object obj) {
            this.azV = str;
            this.aDV = obj;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.azV.equals(aVar.azV) && this.aDV.equals(aVar.aDV);
        }

        public final int hashCode() {
            return Arrays.hashCode(new Integer[]{Integer.valueOf(this.azV.hashCode()), Integer.valueOf(this.aDV.hashCode())});
        }

        public final String toString() {
            return "Key: " + this.azV + " value: " + this.aDV.toString();
        }
    }

    interface b {
        void g(Map<String, Object> map);
    }

    interface c {

        public interface a {
            void l(List<a> list);
        }

        void a(a aVar);

        void a(List<a> list, long j);
    }

    c() {
        this(new c() {
            public final void a(a aVar) {
                aVar.l(new ArrayList());
            }

            public final void a(List<a> list, long j) {
            }
        });
    }

    c(c cVar) {
        this.aDS = cVar;
        this.aDO = new ConcurrentHashMap();
        this.aDP = new HashMap();
        this.aDQ = new ReentrantLock();
        this.aDR = new LinkedList();
        this.aDT = new CountDownLatch(1);
        this.aDS.a(new a(this) {
            final /* synthetic */ c aDU;

            {
                this.aDU = r1;
            }

            public final void l(List<a> list) {
                for (a aVar : list) {
                    this.aDU.e(c.k(aVar.azV, aVar.aDV));
                }
                this.aDU.aDT.countDown();
            }
        });
    }

    private void a(Map<String, Object> map, String str, Collection<a> collection) {
        for (Entry entry : map.entrySet()) {
            String str2 = str + (str.length() == 0 ? "" : ".") + ((String) entry.getKey());
            if (entry.getValue() instanceof Map) {
                a((Map) entry.getValue(), str2, collection);
            } else if (!str2.equals("gtm.lifetime")) {
                collection.add(new a(str2, entry.getValue()));
            }
        }
    }

    private void a(Map<String, Object> map, Map<String, Object> map2) {
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof List) {
                if (!(map2.get(str) instanceof List)) {
                    map2.put(str, new ArrayList());
                }
                b((List) obj, (List) map2.get(str));
            } else if (obj instanceof Map) {
                if (!(map2.get(str) instanceof Map)) {
                    map2.put(str, new HashMap());
                }
                a((Map) obj, (Map) map2.get(str));
            } else {
                map2.put(str, obj);
            }
        }
    }

    private static Long al(String str) {
        Matcher matcher = aDN.matcher(str);
        if (matcher.matches()) {
            long parseLong;
            try {
                parseLong = Long.parseLong(matcher.group(1));
            } catch (NumberFormatException e) {
                new StringBuilder("illegal number in _lifetime value: ").append(str);
                parseLong = 0;
                m.lS();
            }
            if (parseLong <= 0) {
                new StringBuilder("non-positive _lifetime: ").append(str);
                m.lT();
                return null;
            }
            String group = matcher.group(2);
            if (group.length() == 0) {
                return Long.valueOf(parseLong);
            }
            switch (group.charAt(0)) {
                case 'd':
                    return Long.valueOf((((parseLong * 1000) * 60) * 60) * 24);
                case 'h':
                    return Long.valueOf(((parseLong * 1000) * 60) * 60);
                case MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM /*109*/:
                    return Long.valueOf((parseLong * 1000) * 60);
                case 's':
                    return Long.valueOf(parseLong * 1000);
                default:
                    new StringBuilder("unknown units in _lifetime: ").append(str);
                    m.lS();
                    return null;
            }
        }
        new StringBuilder("unknown _lifetime: ").append(str);
        m.lT();
        return null;
    }

    private void b(List<Object> list, List<Object> list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            if (obj instanceof List) {
                if (!(list2.get(i) instanceof List)) {
                    list2.set(i, new ArrayList());
                }
                b((List) obj, (List) list2.get(i));
            } else if (obj instanceof Map) {
                if (!(list2.get(i) instanceof Map)) {
                    list2.set(i, new HashMap());
                }
                a((Map) obj, (Map) list2.get(i));
            } else if (obj != aDL) {
                list2.set(i, obj);
            }
        }
    }

    private static Object f(Map<String, Object> map) {
        String[] strArr = aDM;
        int length = strArr.length;
        int i = 0;
        Object obj = map;
        while (i < length) {
            Object obj2 = strArr[i];
            if (!(obj instanceof Map)) {
                return null;
            }
            i++;
            obj = ((Map) obj).get(obj2);
        }
        return obj;
    }

    static Map<String, Object> k(String str, Object obj) {
        Map hashMap = new HashMap();
        String[] split = str.toString().split("\\.");
        int i = 0;
        Map map = hashMap;
        while (i < split.length - 1) {
            HashMap hashMap2 = new HashMap();
            map.put(split[i], hashMap2);
            i++;
            Object obj2 = hashMap2;
        }
        map.put(split[split.length - 1], obj);
        return hashMap;
    }

    final void a(b bVar) {
        this.aDO.put(bVar, Integer.valueOf(0));
    }

    public final void d(Map<String, Object> map) {
        try {
            this.aDT.await();
        } catch (InterruptedException e) {
            m.lS();
        }
        e(map);
    }

    public final void e(Map<String, Object> map) {
        this.aDQ.lock();
        try {
            this.aDR.offer(map);
            if (this.aDQ.getHoldCount() == 1) {
                int i = 0;
                while (true) {
                    Map map2 = (Map) this.aDR.poll();
                    if (map2 == null) {
                        break;
                    }
                    synchronized (this.aDP) {
                        for (String str : map2.keySet()) {
                            a(k(str, map2.get(str)), this.aDP);
                        }
                    }
                    for (b g : this.aDO.keySet()) {
                        g.g(map2);
                    }
                    int i2 = i + 1;
                    if (i2 > 500) {
                        this.aDR.clear();
                        throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
                    }
                    i = i2;
                }
            }
            Object f = f(map);
            Long al = f == null ? null : al(f.toString());
            if (al != null) {
                List arrayList = new ArrayList();
                a(map, "", arrayList);
                arrayList.remove("gtm.lifetime");
                this.aDS.a(arrayList, al.longValue());
            }
            this.aDQ.unlock();
        } catch (Throwable th) {
            this.aDQ.unlock();
        }
    }

    public final String toString() {
        String stringBuilder;
        synchronized (this.aDP) {
            StringBuilder stringBuilder2 = new StringBuilder();
            for (Entry entry : this.aDP.entrySet()) {
                stringBuilder2.append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", new Object[]{entry.getKey(), entry.getValue()}));
            }
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }
}
