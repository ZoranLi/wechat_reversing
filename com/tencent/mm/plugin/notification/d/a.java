package com.tencent.mm.plugin.notification.d;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.notification.c.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    private static final String oap = (e.hgu + "FailMsgFileCache");

    public static class a {
        public b oaq = new b();
        public int oar;
        public ArrayList<Long> oas = new ArrayList();
        public ArrayList<Long> oat = new ArrayList();

        public a(b bVar, int i, ArrayList<Long> arrayList, ArrayList<Long> arrayList2) {
            this.oaq = bVar;
            this.oar = i;
            this.oas = arrayList;
            this.oat = arrayList2;
        }

        public final String aPM() {
            w.d("MicroMsg.FailMsgFileCache", "CacheObj, serializeToString");
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < this.oaq.oao.size(); i++) {
                    jSONArray.put(this.oaq.get(i));
                }
                w.d("MicroMsg.FailMsgFileCache", "serializeToString, msgArray.size:%d", new Object[]{Integer.valueOf(jSONArray.length())});
                jSONObject.put("msg_list", jSONArray);
                w.d("MicroMsg.FailMsgFileCache", "serializeToString, currentSendIndex:%d", new Object[]{Integer.valueOf(this.oar)});
                jSONObject.put("current_send_index", this.oar);
                jSONArray = new JSONArray();
                Iterator it = this.oas.iterator();
                while (it.hasNext()) {
                    jSONArray.put((Long) it.next());
                }
                w.d("MicroMsg.FailMsgFileCache", "serializeToString, successArray.size:%d", new Object[]{Integer.valueOf(jSONArray.length())});
                jSONObject.put("success_msg_list", jSONArray);
                jSONArray = new JSONArray();
                it = this.oat.iterator();
                while (it.hasNext()) {
                    jSONArray.put((Long) it.next());
                }
                w.d("MicroMsg.FailMsgFileCache", "serializeToString, failArray.size:%d", new Object[]{Integer.valueOf(jSONArray.length())});
                jSONObject.put("fail_msg_list", jSONArray);
                return jSONObject.toString();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.FailMsgFileCache", e, "", new Object[0]);
                return null;
            }
        }

        public final void BS(String str) {
            w.d("MicroMsg.FailMsgFileCache", "CacheObj, createFromFileContent");
            try {
                int i;
                JSONObject jSONObject = new JSONObject(str);
                JSONArray jSONArray = jSONObject.getJSONArray("msg_list");
                JSONArray jSONArray2 = jSONObject.getJSONArray("fail_msg_list");
                JSONArray jSONArray3 = jSONObject.getJSONArray("success_msg_list");
                w.d("MicroMsg.FailMsgFileCache", "createFromFileContent, msgArray.size:%d, failArray.size:%d, successArray.size:%d, index:%d", new Object[]{Integer.valueOf(jSONArray.length()), Integer.valueOf(jSONArray2.length()), Integer.valueOf(jSONArray3.length()), Integer.valueOf(jSONObject.getInt("current_send_index"))});
                this.oaq.clear();
                this.oat.clear();
                this.oas.clear();
                for (i = 0; i < jSONArray.length(); i++) {
                    this.oaq.cN(jSONArray.getLong(i));
                }
                for (i = 0; i < jSONArray2.length(); i++) {
                    this.oat.add(Long.valueOf(jSONArray2.getLong(i)));
                }
                for (i = 0; i < jSONArray3.length(); i++) {
                    this.oas.add(Long.valueOf(jSONArray3.getLong(i)));
                }
                this.oar = r5;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.FailMsgFileCache", e, "", new Object[0]);
                w.d("MicroMsg.FailMsgFileCache", "createFromFileContent error:%s", new Object[]{e.getMessage()});
            }
        }
    }

    public static void init() {
        w.d("MicroMsg.FailMsgFileCache", "init FailMsgFileCache");
        new File(oap).mkdirs();
    }

    public static void a(int i, a aVar) {
        String str = null;
        if (i == 1) {
            str = oap + File.separator + "normalMsg";
        } else if (i == 2) {
            str = oap + File.separator + "snsMsg";
        }
        if (bg.mA(str)) {
            w.e("MicroMsg.FailMsgFileCache", "flushToDisk error, cannot find filename");
            return;
        }
        w.d("MicroMsg.FailMsgFileCache", "flushToDisk, filename:%s", new Object[]{str});
        String aPM = aVar.aPM();
        w.d("MicroMsg.FailMsgFileCache", "flushToDisk, cacheContent:%s", new Object[]{aPM});
        if (bg.mA(aPM)) {
            w.d("MicroMsg.FailMsgFileCache", "flushToDisk, content is empty");
        } else {
            com.tencent.mm.a.e.b(str, aPM.getBytes(), aPM.length());
        }
    }

    public static a qH(int i) {
        String str;
        if (i == 1) {
            str = oap + File.separator + "normalMsg";
        } else if (i == 2) {
            str = oap + File.separator + "snsMsg";
        } else {
            str = null;
        }
        if (bg.mA(str)) {
            w.e("MicroMsg.FailMsgFileCache", "extractFromDisk error, cannot find filename");
            return null;
        }
        w.d("MicroMsg.FailMsgFileCache", "extractFromDisk, filename:%s", new Object[]{str});
        try {
            w.d("MicroMsg.FailMsgFileCache", "extractFromDisk, cacheContent:%s", new Object[]{com.tencent.mm.a.e.aT(str)});
            a aVar = new a();
            aVar.BS(r2);
            return aVar;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.FailMsgFileCache", e, "", new Object[0]);
            w.d("MicroMsg.FailMsgFileCache", "extractFromDisk error:%s", new Object[]{e.toString()});
            return null;
        }
    }

    public static void qI(int i) {
        String str = null;
        if (i == 1) {
            str = oap + File.separator + "normalMsg";
        } else if (i == 2) {
            str = oap + File.separator + "snsMsg";
        }
        if (bg.mA(str)) {
            w.e("MicroMsg.FailMsgFileCache", "removeFile error, cannot find filename");
            return;
        }
        w.d("MicroMsg.FailMsgFileCache", "removeFile, filename:%s", new Object[]{str});
        if (com.tencent.mm.a.e.aO(str)) {
            new File(str).delete();
        }
    }
}
