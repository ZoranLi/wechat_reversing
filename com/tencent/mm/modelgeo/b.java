package com.tencent.mm.modelgeo;

import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.t;
import com.tencent.mm.plugin.comm.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b implements e {
    public static String TAG = "MicroMsg.LocationAddr";
    private static b hCR;
    public c hCS = null;
    private LinkedList<c> hCT = new LinkedList();
    private HashMap<String, LinkedList<WeakReference<a>>> hCU = new HashMap();
    private ar hCV = new ar(1, "addr_worker");
    public boolean hCW = true;

    public interface a {
        void b(Addr addr);
    }

    private class b implements com.tencent.mm.sdk.platformtools.ar.a {
        private Addr hCX = null;
        final /* synthetic */ b hCY;

        public b(b bVar) {
            this.hCY = bVar;
        }

        public final boolean Bn() {
            if (this.hCY.hCS == null) {
                return false;
            }
            if (this.hCX == null || this.hCX.hCE == null || this.hCX.hCE.equals("")) {
                this.hCX = b.a(this.hCY.hCS.lat, this.hCY.hCS.lng, this.hCY.hCW);
            }
            return true;
        }

        public final boolean Bo() {
            this.hCY.hCW = true;
            this.hCY.a(this.hCX);
            return true;
        }
    }

    class c {
        final /* synthetic */ b hCY;
        double lat;
        double lng;
        Object tag = "";

        public c(b bVar, double d, double d2, Object obj) {
            this.hCY = bVar;
            this.lat = d;
            this.lng = d2;
            this.tag = obj;
        }

        public final String toString() {
            StringBuilder append = new StringBuilder().append((int) (this.lat * 1000000.0d)).append((int) (this.lng * 1000000.0d));
            String obj = this.tag == null ? "" : ((this.tag instanceof Integer) || (this.tag instanceof Long) || (this.tag instanceof Double) || (this.tag instanceof Float) || (this.tag instanceof String)) ? this.tag : this.tag.toString();
            return append.append(obj).toString();
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof c)) {
                return false;
            }
            return ((c) obj).toString().equals(toString());
        }
    }

    private b() {
    }

    public static b Gi() {
        if (hCR == null) {
            hCR = new b();
        }
        return hCR;
    }

    public final boolean a(a aVar) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (String str : this.hCU.keySet()) {
            LinkedList linkedList3 = (LinkedList) this.hCU.get(str);
            b(linkedList3, aVar);
            this.hCU.put(str, linkedList3);
            if (linkedList3 == null || linkedList3.size() == 0) {
                linkedList2.add(str);
            }
        }
        Iterator it = linkedList2.iterator();
        while (it.hasNext()) {
            this.hCU.remove((String) it.next());
        }
        Iterator it2 = this.hCT.iterator();
        while (it2.hasNext()) {
            c cVar = (c) it2.next();
            linkedList3 = (LinkedList) this.hCU.get(cVar.toString());
            if (linkedList3 == null || linkedList3.size() == 0) {
                linkedList.add(cVar);
                this.hCU.remove(cVar.toString());
            }
        }
        it = linkedList.iterator();
        while (it.hasNext()) {
            this.hCT.remove((c) it.next());
        }
        w.i(TAG, "remove taskLists %d listeners size %d", new Object[]{Integer.valueOf(this.hCT.size()), Integer.valueOf(this.hCU.size())});
        return true;
    }

    private static boolean a(LinkedList<WeakReference<a>> linkedList, a aVar) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(LinkedList<WeakReference<a>> linkedList, a aVar) {
        if (linkedList == null) {
            return false;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference != null && weakReference.get() != null && ((a) weakReference.get()).equals(aVar)) {
                linkedList.remove(weakReference);
                return true;
            }
        }
        return false;
    }

    public final boolean a(double d, double d2, a aVar, Object obj) {
        c cVar;
        if (obj != null) {
            Iterator it = this.hCT.iterator();
            while (it.hasNext()) {
                cVar = (c) it.next();
                if (cVar != null && cVar.tag != null && cVar.tag.equals(obj)) {
                    this.hCT.remove(cVar);
                    break;
                }
            }
        }
        cVar = new c(this, d, d2, obj);
        LinkedList linkedList = (LinkedList) this.hCU.get(cVar.toString());
        if (linkedList == null) {
            linkedList = new LinkedList();
        }
        if (!a(linkedList, aVar)) {
            linkedList.add(new WeakReference(aVar));
        }
        this.hCU.put(cVar.toString(), linkedList);
        Iterator it2 = this.hCT.iterator();
        while (it2.hasNext()) {
            if (((c) it2.next()).equals(cVar)) {
                Gj();
                return false;
            }
        }
        if (this.hCS != null && cVar.equals(this.hCS)) {
            return false;
        }
        this.hCT.add(cVar);
        w.i(TAG, "push task size %d listeners %d", new Object[]{Integer.valueOf(this.hCT.size()), Integer.valueOf(this.hCU.size())});
        while (this.hCT.size() > 30) {
            w.i(TAG, "force remove task");
            cVar = (c) this.hCT.removeFirst();
            if (cVar != null) {
                this.hCU.remove(cVar.toString());
            }
        }
        Gj();
        return true;
    }

    public final boolean a(double d, double d2, a aVar) {
        return a(d, d2, aVar, null);
    }

    private void Gj() {
        if (this.hCS == null && this.hCT != null && this.hCT.size() > 0) {
            this.hCS = (c) this.hCT.removeFirst();
            if (bg.Hp()) {
                this.hCV.c(new b(this));
                return;
            }
            h.vd().a(655, this);
            h.vd().a(new d(this.hCS.lat, this.hCS.lng), 0);
        }
    }

    public final void a(Addr addr) {
        if (this.hCS != null) {
            if (addr == null) {
                addr = new Addr();
            }
            addr.tag = this.hCS.tag == null ? new Object() : this.hCS.tag;
            addr.hCP = (float) this.hCS.lat;
            addr.hCQ = (float) this.hCS.lng;
            if (!bg.mA(addr.hCG)) {
                String string = ab.getContext().getResources().getString(g.kEi);
                w.d(TAG, "city %s", new Object[]{string});
                if (!bg.Hp() && !bg.mA(string) && addr.hCG.endsWith(string)) {
                    addr.hCH = addr.hCG;
                    addr.hCG = addr.hCG.substring(0, addr.hCG.length() - string.length());
                } else if (bg.Hp() || bg.mA(string) || addr.hCE.indexOf(string) < 0) {
                    addr.hCH = addr.hCG;
                } else {
                    addr.hCH = addr.hCG + string;
                }
            }
            LinkedList linkedList = (LinkedList) this.hCU.get(this.hCS.toString());
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (!(weakReference == null || weakReference.get() == null)) {
                        ((a) weakReference.get()).b(addr);
                    }
                }
            }
            this.hCU.remove(this.hCS.toString());
            w.d(TAG, "postexecute2 listeners %d", new Object[]{Integer.valueOf(this.hCU.size())});
            this.hCS = null;
            Gj();
            if (this.hCS == null && this.hCT.size() > 0) {
                h.vd().b(655, this);
            }
        }
    }

    public static Addr a(double d, double d2, boolean z) {
        String format;
        InputStreamReader inputStreamReader;
        Throwable e;
        t tVar;
        String bIN = v.bIN();
        Addr addr = new Addr();
        if (z) {
            format = String.format("https://maps.google.com/maps/api/geocode/json?latlng=%f,%f&language=%s&sensor=false", new Object[]{Double.valueOf(d), Double.valueOf(d2), bIN});
        } else {
            format = String.format("https://maps.google.com/maps/api/geocode/json?latlng=%f,%f&language=%s&sensor=false", new Object[]{Double.valueOf(d), Double.valueOf(d2), "zh_CN"});
        }
        w.d(TAG, "url " + format);
        t a;
        try {
            a = com.tencent.mm.network.b.a(format, null);
            try {
                a.setConnectTimeout(10000);
                a.setRequestMethod("GET");
                w.d(TAG, "conn " + a.getResponseCode());
                inputStreamReader = new InputStreamReader(a.getInputStream());
                try {
                    String readLine;
                    String string;
                    String string2;
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    }
                    w.d(TAG, "sb " + stringBuffer.toString());
                    JSONArray jSONArray = new JSONObject(stringBuffer.toString()).getJSONArray("results");
                    JSONObject jSONObject = jSONArray.getJSONObject(0);
                    addr.hCE = jSONObject.getString("formatted_address");
                    JSONArray jSONArray2 = jSONArray.getJSONObject(0).getJSONArray("address_components");
                    for (int i = 0; i < jSONArray2.length(); i++) {
                        JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
                        try {
                            string = jSONObject2.getString("long_name");
                            string2 = jSONObject2.getJSONArray("types").getString(0);
                            if (string2.equals("administrative_area_level_1")) {
                                addr.hCF = string;
                            } else if (string2.equals(TencentExtraKeys.LOCATION_KEY_LOCALITY)) {
                                addr.hCG = string;
                            } else if (string2.equals(TencentExtraKeys.LOCATION_KEY_SUBLOCALITY)) {
                                addr.hCI = string;
                            } else if (string2.equals("neighborhood")) {
                                addr.hCJ = string;
                            } else if (string2.equals(TencentExtraKeys.LOCATION_KEY_ROUTE)) {
                                addr.hCK = string;
                            } else if (string2.equals("street_number")) {
                                addr.hCL = string;
                            } else if (string2.equals("country")) {
                                addr.country = string;
                            }
                        } catch (Exception e2) {
                        } catch (IOException e3) {
                            e = e3;
                            tVar = a;
                        }
                    }
                    format = ProtocolPackage.ServerEncoding;
                    string2 = URLEncoder.encode(addr.hCE, format);
                    readLine = URLEncoder.encode(jSONArray2.toString(), format);
                    string = URLEncoder.encode(jSONObject.getJSONObject("geometry").toString(), format);
                    String encode = URLEncoder.encode(jSONObject.getString("place_id"), format);
                    String encode2 = URLEncoder.encode(jSONObject.getJSONArray("types").toString(), format);
                    format = URLEncoder.encode(String.format("[%f,%f]", new Object[]{Double.valueOf(d), Double.valueOf(d2)}), format);
                    w.d(TAG, "google report, formattedaddr: %s, componentaddr: %s, geometry: %s, placeId: %s, types: %s, location: %s, curLanguage: %s", new Object[]{string2, readLine, string, encode, encode2, format, bIN});
                    com.tencent.mm.plugin.report.service.g.oUh.i(12886, new Object[]{readLine, string2, string, encode, encode2, format, bIN});
                    a.ieZ.disconnect();
                } catch (IOException e32) {
                    e = e32;
                    tVar = a;
                } catch (Exception e4) {
                    e = e4;
                    try {
                        w.d(TAG, "error Exception");
                        w.e(TAG, "exception:%s", new Object[]{bg.g(e)});
                        if (a != null) {
                            a.ieZ.disconnect();
                        }
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (Throwable e5) {
                                w.e(TAG, "exception:%s", new Object[]{bg.g(e5)});
                            }
                        }
                        return addr;
                    } catch (Throwable th) {
                        e5 = th;
                        if (a != null) {
                            a.ieZ.disconnect();
                        }
                        throw e5;
                    }
                }
            } catch (IOException e6) {
                e5 = e6;
                inputStreamReader = null;
                tVar = a;
                try {
                    w.d(TAG, "error e");
                    w.e(TAG, "exception:%s", new Object[]{bg.g(e5)});
                    if (tVar != null) {
                        tVar.ieZ.disconnect();
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    return addr;
                } catch (Throwable th2) {
                    e5 = th2;
                    a = tVar;
                    if (a != null) {
                        a.ieZ.disconnect();
                    }
                    throw e5;
                }
            } catch (Exception e7) {
                e5 = e7;
                inputStreamReader = null;
                w.d(TAG, "error Exception");
                w.e(TAG, "exception:%s", new Object[]{bg.g(e5)});
                if (a != null) {
                    a.ieZ.disconnect();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                return addr;
            }
        } catch (IOException e8) {
            e5 = e8;
            tVar = null;
            inputStreamReader = null;
            w.d(TAG, "error e");
            w.e(TAG, "exception:%s", new Object[]{bg.g(e5)});
            if (tVar != null) {
                tVar.ieZ.disconnect();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            return addr;
        } catch (Exception e9) {
            e5 = e9;
            a = null;
            inputStreamReader = null;
            w.d(TAG, "error Exception");
            w.e(TAG, "exception:%s", new Object[]{bg.g(e5)});
            if (a != null) {
                a.ieZ.disconnect();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            return addr;
        } catch (Throwable th3) {
            e5 = th3;
            a = null;
            if (a != null) {
                a.ieZ.disconnect();
            }
            throw e5;
        }
        if (inputStreamReader != null) {
            inputStreamReader.close();
        }
        return addr;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 655) {
            Addr Gn = ((d) kVar).Gn();
            if (Gn == null || Gn.hCE == null || Gn.hCE.equals("")) {
                this.hCV.c(new b(this));
            } else {
                a(Gn);
            }
        }
    }
}
