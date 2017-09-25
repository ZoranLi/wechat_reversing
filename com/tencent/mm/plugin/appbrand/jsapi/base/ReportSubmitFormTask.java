package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.c.bqs;
import com.tencent.mm.protocal.c.fg;
import com.tencent.mm.protocal.c.fh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReportSubmitFormTask extends MainProcessTask {
    public static final Creator<ReportSubmitFormTask> CREATOR = new Creator<ReportSubmitFormTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            ReportSubmitFormTask reportSubmitFormTask = new ReportSubmitFormTask();
            reportSubmitFormTask.f(parcel);
            return reportSubmitFormTask;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ReportSubmitFormTask[i];
        }
    };
    public String appId;
    public int fCM;
    public int fWF;
    public String iGe;
    public String iRo;
    public int type;

    public ReportSubmitFormTask(String str) {
        this.appId = str;
        this.fCM = b.mY(str).iFk.izV;
        this.fWF = b.mY(str).iFk.izW;
    }

    public final void PM() {
        a aVar = new a();
        aVar.hsm = new fg();
        aVar.hsn = new fh();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchrecordwxatemplatemsgevent";
        aVar.hsl = 1129;
        com.tencent.mm.y.b BE = aVar.BE();
        final fg fgVar = (fg) BE.hsj.hsr;
        fgVar.tiS = new LinkedList();
        bqs com_tencent_mm_protocal_c_bqs = new bqs();
        com_tencent_mm_protocal_c_bqs.type = this.type;
        com_tencent_mm_protocal_c_bqs.fTO = this.appId;
        com_tencent_mm_protocal_c_bqs.uoL = this.iRo;
        com_tencent_mm_protocal_c_bqs.uoM = this.iGe;
        com_tencent_mm_protocal_c_bqs.uoN = this.fCM;
        com_tencent_mm_protocal_c_bqs.uoO = this.fWF;
        fgVar.tiS.add(com_tencent_mm_protocal_c_bqs);
        synchronized (getClass()) {
            fgVar.tiS.addAll(Tu());
        }
        u.a(BE, new u.a(this) {
            final /* synthetic */ ReportSubmitFormTask iRq;

            public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                if (!(i == 0 && i2 == 0)) {
                    synchronized (this.iRq.getClass()) {
                        LinkedList linkedList = fgVar.tiS;
                        linkedList.addAll(ReportSubmitFormTask.Tu());
                        JSONArray jSONArray = new JSONArray();
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            bqs com_tencent_mm_protocal_c_bqs = (bqs) it.next();
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(Columns.TYPE, com_tencent_mm_protocal_c_bqs.type);
                                jSONObject.put("appid", com_tencent_mm_protocal_c_bqs.fTO);
                                jSONObject.put("formid", com_tencent_mm_protocal_c_bqs.uoL);
                                jSONObject.put("pageid", com_tencent_mm_protocal_c_bqs.uoM);
                                jSONObject.put("appstate", com_tencent_mm_protocal_c_bqs.uoN);
                                jSONObject.put("appversion", com_tencent_mm_protocal_c_bqs.uoO);
                                jSONArray.put(jSONObject);
                            } catch (Exception e) {
                                w.e("MicroMsg.ReportSubmitFormTask", e.getMessage());
                            }
                        }
                        ap.yY();
                        c.vr().a(com.tencent.mm.storage.w.a.uEU, jSONArray.toString());
                    }
                    w.e("MicroMsg.ReportSubmitFormTask", "Error: %d, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                }
                return 0;
            }
        });
    }

    static LinkedList<bqs> Tu() {
        LinkedList<bqs> linkedList = new LinkedList();
        ap.yY();
        try {
            JSONArray jSONArray = new JSONArray((String) c.vr().get(com.tencent.mm.storage.w.a.uEU, null));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                bqs com_tencent_mm_protocal_c_bqs = new bqs();
                com_tencent_mm_protocal_c_bqs.type = jSONObject.getInt(Columns.TYPE);
                com_tencent_mm_protocal_c_bqs.fTO = jSONObject.getString("appid");
                com_tencent_mm_protocal_c_bqs.uoL = jSONObject.getString("formid");
                com_tencent_mm_protocal_c_bqs.uoM = jSONObject.getString("pageid");
                com_tencent_mm_protocal_c_bqs.uoN = jSONObject.getInt("appstate");
                com_tencent_mm_protocal_c_bqs.uoO = jSONObject.getInt("appversion");
                linkedList.add(com_tencent_mm_protocal_c_bqs);
            }
        } catch (Exception e) {
            w.e("MicroMsg.ReportSubmitFormTask", e.getMessage());
        }
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uEU, "");
        return linkedList;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeString(this.appId);
        parcel.writeString(this.iRo);
        parcel.writeString(this.iGe);
        parcel.writeInt(this.fCM);
        parcel.writeInt(this.fWF);
    }

    public final void f(Parcel parcel) {
        this.type = parcel.readInt();
        this.appId = parcel.readString();
        this.iRo = parcel.readString();
        this.iGe = parcel.readString();
        this.fCM = parcel.readInt();
        this.fWF = parcel.readInt();
    }
}
