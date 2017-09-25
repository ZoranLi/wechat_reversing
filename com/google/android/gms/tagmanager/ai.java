package com.google.android.gms.tagmanager;

import com.google.android.gms.c.b.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ai {
    private static final Object aFf = null;
    private static Long aFg = new Long(0);
    private static Double aFh = new Double(0.0d);
    private static ah aFi = ah.mq();
    private static String aFj = new String("");
    private static Boolean aFk = new Boolean(false);
    private static List<Object> aFl = new ArrayList(0);
    private static Map<Object, Object> aFm = new HashMap();
    private static a aFn = ag(aFj);

    private static String af(Object obj) {
        return obj == null ? aFj : obj.toString();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.c.b.a ag(java.lang.Object r10) {
        /*
        r3 = 1;
        r2 = 0;
        r4 = new com.google.android.gms.c.b$a;
        r4.<init>();
        r0 = r10 instanceof com.google.android.gms.c.b.a;
        if (r0 == 0) goto L_0x000e;
    L_0x000b:
        r10 = (com.google.android.gms.c.b.a) r10;
    L_0x000d:
        return r10;
    L_0x000e:
        r0 = r10 instanceof java.lang.String;
        if (r0 == 0) goto L_0x001c;
    L_0x0012:
        r4.type = r3;
        r10 = (java.lang.String) r10;
        r4.ayA = r10;
    L_0x0018:
        r4.ayK = r2;
        r10 = r4;
        goto L_0x000d;
    L_0x001c:
        r0 = r10 instanceof java.util.List;
        if (r0 == 0) goto L_0x0062;
    L_0x0020:
        r0 = 2;
        r4.type = r0;
        r10 = (java.util.List) r10;
        r5 = new java.util.ArrayList;
        r0 = r10.size();
        r5.<init>(r0);
        r6 = r10.iterator();
        r1 = r2;
    L_0x0033:
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x0056;
    L_0x0039:
        r0 = r6.next();
        r7 = ag(r0);
        r0 = aFn;
        if (r7 != r0) goto L_0x0048;
    L_0x0045:
        r10 = aFn;
        goto L_0x000d;
    L_0x0048:
        if (r1 != 0) goto L_0x004e;
    L_0x004a:
        r0 = r7.ayK;
        if (r0 == 0) goto L_0x0054;
    L_0x004e:
        r0 = r3;
    L_0x004f:
        r5.add(r7);
        r1 = r0;
        goto L_0x0033;
    L_0x0054:
        r0 = r2;
        goto L_0x004f;
    L_0x0056:
        r0 = new com.google.android.gms.c.b.a[r2];
        r0 = r5.toArray(r0);
        r0 = (com.google.android.gms.c.b.a[]) r0;
        r4.ayB = r0;
        r2 = r1;
        goto L_0x0018;
    L_0x0062:
        r0 = r10 instanceof java.util.Map;
        if (r0 == 0) goto L_0x00da;
    L_0x0066:
        r0 = 3;
        r4.type = r0;
        r10 = (java.util.Map) r10;
        r0 = r10.entrySet();
        r5 = new java.util.ArrayList;
        r1 = r0.size();
        r5.<init>(r1);
        r6 = new java.util.ArrayList;
        r1 = r0.size();
        r6.<init>(r1);
        r7 = r0.iterator();
        r1 = r2;
    L_0x0086:
        r0 = r7.hasNext();
        if (r0 == 0) goto L_0x00c3;
    L_0x008c:
        r0 = r7.next();
        r0 = (java.util.Map.Entry) r0;
        r8 = r0.getKey();
        r8 = ag(r8);
        r0 = r0.getValue();
        r9 = ag(r0);
        r0 = aFn;
        if (r8 == r0) goto L_0x00aa;
    L_0x00a6:
        r0 = aFn;
        if (r9 != r0) goto L_0x00ae;
    L_0x00aa:
        r10 = aFn;
        goto L_0x000d;
    L_0x00ae:
        if (r1 != 0) goto L_0x00b8;
    L_0x00b0:
        r0 = r8.ayK;
        if (r0 != 0) goto L_0x00b8;
    L_0x00b4:
        r0 = r9.ayK;
        if (r0 == 0) goto L_0x00c1;
    L_0x00b8:
        r0 = r3;
    L_0x00b9:
        r5.add(r8);
        r6.add(r9);
        r1 = r0;
        goto L_0x0086;
    L_0x00c1:
        r0 = r2;
        goto L_0x00b9;
    L_0x00c3:
        r0 = new com.google.android.gms.c.b.a[r2];
        r0 = r5.toArray(r0);
        r0 = (com.google.android.gms.c.b.a[]) r0;
        r4.ayC = r0;
        r0 = new com.google.android.gms.c.b.a[r2];
        r0 = r6.toArray(r0);
        r0 = (com.google.android.gms.c.b.a[]) r0;
        r4.ayD = r0;
        r2 = r1;
        goto L_0x0018;
    L_0x00da:
        r0 = r10 instanceof java.lang.Double;
        if (r0 != 0) goto L_0x00f0;
    L_0x00de:
        r0 = r10 instanceof java.lang.Float;
        if (r0 != 0) goto L_0x00f0;
    L_0x00e2:
        r0 = r10 instanceof com.google.android.gms.tagmanager.ah;
        if (r0 == 0) goto L_0x00ff;
    L_0x00e6:
        r0 = r10;
        r0 = (com.google.android.gms.tagmanager.ah) r0;
        r0 = r0.aFe;
        if (r0 != 0) goto L_0x00fd;
    L_0x00ed:
        r0 = r3;
    L_0x00ee:
        if (r0 == 0) goto L_0x00ff;
    L_0x00f0:
        r0 = r3;
    L_0x00f1:
        if (r0 == 0) goto L_0x0101;
    L_0x00f3:
        r4.type = r3;
        r0 = r10.toString();
        r4.ayA = r0;
        goto L_0x0018;
    L_0x00fd:
        r0 = r2;
        goto L_0x00ee;
    L_0x00ff:
        r0 = r2;
        goto L_0x00f1;
    L_0x0101:
        r0 = r10 instanceof java.lang.Byte;
        if (r0 != 0) goto L_0x011c;
    L_0x0105:
        r0 = r10 instanceof java.lang.Short;
        if (r0 != 0) goto L_0x011c;
    L_0x0109:
        r0 = r10 instanceof java.lang.Integer;
        if (r0 != 0) goto L_0x011c;
    L_0x010d:
        r0 = r10 instanceof java.lang.Long;
        if (r0 != 0) goto L_0x011c;
    L_0x0111:
        r0 = r10 instanceof com.google.android.gms.tagmanager.ah;
        if (r0 == 0) goto L_0x012f;
    L_0x0115:
        r0 = r10;
        r0 = (com.google.android.gms.tagmanager.ah) r0;
        r0 = r0.aFe;
        if (r0 == 0) goto L_0x012f;
    L_0x011c:
        if (r3 == 0) goto L_0x0137;
    L_0x011e:
        r0 = 6;
        r4.type = r0;
        r0 = r10 instanceof java.lang.Number;
        if (r0 == 0) goto L_0x0131;
    L_0x0125:
        r10 = (java.lang.Number) r10;
        r0 = r10.longValue();
    L_0x012b:
        r4.ayG = r0;
        goto L_0x0018;
    L_0x012f:
        r3 = r2;
        goto L_0x011c;
    L_0x0131:
        com.google.android.gms.tagmanager.m.lQ();
        r0 = 0;
        goto L_0x012b;
    L_0x0137:
        r0 = r10 instanceof java.lang.Boolean;
        if (r0 == 0) goto L_0x0149;
    L_0x013b:
        r0 = 8;
        r4.type = r0;
        r10 = (java.lang.Boolean) r10;
        r0 = r10.booleanValue();
        r4.ayH = r0;
        goto L_0x0018;
    L_0x0149:
        r1 = new java.lang.StringBuilder;
        r0 = "Converting to Value from unknown object type: ";
        r1.<init>(r0);
        if (r10 != 0) goto L_0x0160;
    L_0x0153:
        r0 = "null";
    L_0x0156:
        r1.append(r0);
        com.google.android.gms.tagmanager.m.lQ();
        r10 = aFn;
        goto L_0x000d;
    L_0x0160:
        r0 = r10.getClass();
        r0 = r0.toString();
        goto L_0x0156;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.ai.ag(java.lang.Object):com.google.android.gms.c.b$a");
    }

    public static String b(a aVar) {
        return af(d(aVar));
    }

    public static Boolean c(a aVar) {
        Object d = d(aVar);
        if (d instanceof Boolean) {
            return (Boolean) d;
        }
        String af = af(d);
        return "true".equalsIgnoreCase(af) ? Boolean.TRUE : "false".equalsIgnoreCase(af) ? Boolean.FALSE : aFk;
    }

    public static Object d(a aVar) {
        int i = 0;
        if (aVar == null) {
            return aFf;
        }
        a[] aVarArr;
        int length;
        switch (aVar.type) {
            case 1:
                return aVar.ayA;
            case 2:
                ArrayList arrayList = new ArrayList(aVar.ayB.length);
                aVarArr = aVar.ayB;
                length = aVarArr.length;
                while (i < length) {
                    Object d = d(aVarArr[i]);
                    if (d == aFf) {
                        return aFf;
                    }
                    arrayList.add(d);
                    i++;
                }
                return arrayList;
            case 3:
                if (aVar.ayC.length != aVar.ayD.length) {
                    new StringBuilder("Converting an invalid value to object: ").append(aVar.toString());
                    m.lQ();
                    return aFf;
                }
                Map hashMap = new HashMap(aVar.ayD.length);
                while (i < aVar.ayC.length) {
                    Object d2 = d(aVar.ayC[i]);
                    Object d3 = d(aVar.ayD[i]);
                    if (d2 == aFf || d3 == aFf) {
                        return aFf;
                    }
                    hashMap.put(d2, d3);
                    i++;
                }
                return hashMap;
            case 4:
                m.lQ();
                return aFf;
            case 5:
                m.lQ();
                return aFf;
            case 6:
                return Long.valueOf(aVar.ayG);
            case 7:
                StringBuffer stringBuffer = new StringBuffer();
                aVarArr = aVar.ayI;
                length = aVarArr.length;
                while (i < length) {
                    String b = b(aVarArr[i]);
                    if (b == aFj) {
                        return aFf;
                    }
                    stringBuffer.append(b);
                    i++;
                }
                return stringBuffer.toString();
            case 8:
                return Boolean.valueOf(aVar.ayH);
            default:
                new StringBuilder("Failed to convert a value of type: ").append(aVar.type);
                m.lQ();
                return aFf;
        }
    }

    public static a mr() {
        return aFn;
    }
}
