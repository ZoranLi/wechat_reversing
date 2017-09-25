package com.google.android.gms.c;

import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public final class au {

    public static class a {
        public final av aBT;
        public final List<Asset> aBU;

        public a(av avVar, List<Asset> list) {
            this.aBT = avVar;
            this.aBU = list;
        }
    }

    private static int a(String str, com.google.android.gms.c.av.a.a[] aVarArr) {
        int i = 14;
        for (com.google.android.gms.c.av.a.a aVar : aVarArr) {
            if (i == 14) {
                if (aVar.type == 9 || aVar.type == 2 || aVar.type == 6) {
                    i = aVar.type;
                } else if (aVar.type != 14) {
                    throw new IllegalArgumentException("Unexpected TypedValue type: " + aVar.type + " for key " + str);
                }
            } else if (aVar.type != i) {
                throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + str + " contains items of type " + i + " and " + aVar.type);
            }
        }
        return i;
    }

    private static com.google.android.gms.c.av.a.a a(List<Asset> list, Object obj) {
        com.google.android.gms.c.av.a.a aVar = new com.google.android.gms.c.av.a.a();
        if (obj == null) {
            aVar.type = 14;
            return aVar;
        }
        aVar.aBZ = new com.google.android.gms.c.av.a.a.a();
        if (obj instanceof String) {
            aVar.type = 2;
            aVar.aBZ.aCb = (String) obj;
        } else if (obj instanceof Integer) {
            aVar.type = 6;
            aVar.aBZ.aCf = ((Integer) obj).intValue();
        } else if (obj instanceof Long) {
            aVar.type = 5;
            aVar.aBZ.aCe = ((Long) obj).longValue();
        } else if (obj instanceof Double) {
            aVar.type = 3;
            aVar.aBZ.aCc = ((Double) obj).doubleValue();
        } else if (obj instanceof Float) {
            aVar.type = 4;
            aVar.aBZ.aCd = ((Float) obj).floatValue();
        } else if (obj instanceof Boolean) {
            aVar.type = 8;
            aVar.aBZ.aCh = ((Boolean) obj).booleanValue();
        } else if (obj instanceof Byte) {
            aVar.type = 7;
            aVar.aBZ.aCg = ((Byte) obj).byteValue();
        } else if (obj instanceof byte[]) {
            aVar.type = 1;
            aVar.aBZ.aCa = (byte[]) obj;
        } else if (obj instanceof String[]) {
            aVar.type = 11;
            aVar.aBZ.aCk = (String[]) obj;
        } else if (obj instanceof long[]) {
            aVar.type = 12;
            aVar.aBZ.aCl = (long[]) obj;
        } else if (obj instanceof float[]) {
            aVar.type = 15;
            aVar.aBZ.aCm = (float[]) obj;
        } else if (obj instanceof Asset) {
            aVar.type = 13;
            com.google.android.gms.c.av.a.a.a aVar2 = aVar.aBZ;
            list.add((Asset) obj);
            aVar2.aCn = (long) (list.size() - 1);
        } else if (obj instanceof i) {
            aVar.type = 9;
            i iVar = (i) obj;
            TreeSet treeSet = new TreeSet(iVar.aFO.keySet());
            com.google.android.gms.c.av.a[] aVarArr = new com.google.android.gms.c.av.a[treeSet.size()];
            Iterator it = treeSet.iterator();
            r1 = 0;
            while (it.hasNext()) {
                String str = (String) it.next();
                aVarArr[r1] = new com.google.android.gms.c.av.a();
                aVarArr[r1].name = str;
                aVarArr[r1].aBX = a((List) list, iVar.get(str));
                r1++;
            }
            aVar.aBZ.aCi = aVarArr;
        } else if (obj instanceof ArrayList) {
            aVar.type = 10;
            ArrayList arrayList = (ArrayList) obj;
            com.google.android.gms.c.av.a.a[] aVarArr2 = new com.google.android.gms.c.av.a.a[arrayList.size()];
            Object obj2 = null;
            int size = arrayList.size();
            int i = 0;
            int i2 = 14;
            while (i < size) {
                Object obj3 = arrayList.get(i);
                com.google.android.gms.c.av.a.a a = a((List) list, obj3);
                if (a.type == 14 || a.type == 2 || a.type == 6 || a.type == 9) {
                    if (i2 == 14 && a.type != 14) {
                        r1 = a.type;
                    } else if (a.type != i2) {
                        throw new IllegalArgumentException("ArrayList elements must all be of the sameclass, but this one contains a " + obj2.getClass() + " and a " + obj3.getClass());
                    } else {
                        obj3 = obj2;
                        r1 = i2;
                    }
                    aVarArr2[i] = a;
                    i++;
                    i2 = r1;
                    obj2 = obj3;
                } else {
                    throw new IllegalArgumentException("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + obj3.getClass());
                }
            }
            aVar.aBZ.aCj = aVarArr2;
        } else {
            throw new RuntimeException("newFieldValueFromValue: unexpected value " + obj.getClass().getSimpleName());
        }
        return aVar;
    }

    public static i a(a aVar) {
        i iVar = new i();
        for (com.google.android.gms.c.av.a aVar2 : aVar.aBT.aBV) {
            a(aVar.aBU, iVar, aVar2.name, aVar2.aBX);
        }
        return iVar;
    }

    private static ArrayList a(List<Asset> list, com.google.android.gms.c.av.a.a.a aVar, int i) {
        ArrayList arrayList = new ArrayList(aVar.aCj.length);
        for (com.google.android.gms.c.av.a.a aVar2 : aVar.aCj) {
            if (aVar2.type == 14) {
                arrayList.add(null);
            } else if (i == 9) {
                i iVar = new i();
                for (com.google.android.gms.c.av.a aVar3 : aVar2.aBZ.aCi) {
                    a(list, iVar, aVar3.name, aVar3.aBX);
                }
                arrayList.add(iVar);
            } else if (i == 2) {
                arrayList.add(aVar2.aBZ.aCb);
            } else if (i == 6) {
                arrayList.add(Integer.valueOf(aVar2.aBZ.aCf));
            } else {
                throw new IllegalArgumentException("Unexpected typeOfArrayList: " + i);
            }
        }
        return arrayList;
    }

    private static void a(List<Asset> list, i iVar, String str, com.google.android.gms.c.av.a.a aVar) {
        int i = aVar.type;
        if (i == 14) {
            iVar.putString(str, null);
            return;
        }
        com.google.android.gms.c.av.a.a.a aVar2 = aVar.aBZ;
        if (i == 1) {
            iVar.aFO.put(str, aVar2.aCa);
        } else if (i == 11) {
            iVar.aFO.put(str, aVar2.aCk);
        } else if (i == 12) {
            iVar.aFO.put(str, aVar2.aCl);
        } else if (i == 15) {
            iVar.aFO.put(str, aVar2.aCm);
        } else if (i == 2) {
            iVar.putString(str, aVar2.aCb);
        } else if (i == 3) {
            iVar.aFO.put(str, Double.valueOf(aVar2.aCc));
        } else if (i == 4) {
            iVar.aFO.put(str, Float.valueOf(aVar2.aCd));
        } else if (i == 5) {
            iVar.putLong(str, aVar2.aCe);
        } else if (i == 6) {
            iVar.aFO.put(str, Integer.valueOf(aVar2.aCf));
        } else if (i == 7) {
            iVar.aFO.put(str, Byte.valueOf((byte) aVar2.aCg));
        } else if (i == 8) {
            iVar.aFO.put(str, Boolean.valueOf(aVar2.aCh));
        } else if (i == 13) {
            if (list == null) {
                throw new RuntimeException("populateBundle: unexpected type for: " + str);
            }
            iVar.a(str, (Asset) list.get((int) aVar2.aCn));
        } else if (i == 9) {
            i iVar2 = new i();
            for (com.google.android.gms.c.av.a aVar3 : aVar2.aCi) {
                a(list, iVar2, aVar3.name, aVar3.aBX);
            }
            iVar.aFO.put(str, iVar2);
        } else if (i == 10) {
            i = a(str, aVar2.aCj);
            ArrayList a = a(list, aVar2, i);
            if (i == 14) {
                iVar.putStringArrayList(str, a);
            } else if (i == 9) {
                iVar.aFO.put(str, a);
            } else if (i == 2) {
                iVar.putStringArrayList(str, a);
            } else if (i == 6) {
                iVar.aFO.put(str, a);
            } else {
                throw new IllegalStateException("Unexpected typeOfArrayList: " + i);
            }
        } else {
            throw new RuntimeException("populateBundle: unexpected type " + i);
        }
    }

    public static com.google.android.gms.c.av.a[] a(i iVar, List<Asset> list) {
        TreeSet treeSet = new TreeSet(iVar.aFO.keySet());
        com.google.android.gms.c.av.a[] aVarArr = new com.google.android.gms.c.av.a[treeSet.size()];
        Iterator it = treeSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            Object obj = iVar.get(str);
            aVarArr[i] = new com.google.android.gms.c.av.a();
            aVarArr[i].name = str;
            aVarArr[i].aBX = a((List) list, obj);
            i++;
        }
        return aVarArr;
    }
}
