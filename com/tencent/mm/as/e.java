package com.tencent.mm.as;

import android.util.Base64;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.protocal.c.axa;
import com.tencent.mm.protocal.c.axb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.m;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {
    public static axb hPI;

    public static axb In() {
        if (hPI == null) {
            String Io = Io();
            hPI = new axb();
            Io = ab.getContext().getSharedPreferences("fts_history_search_sp", 0).getString(Io, "");
            if (!bg.mA(Io)) {
                try {
                    hPI.aD(Base64.decode(Io.getBytes(), 0));
                } catch (IOException e) {
                }
            }
        }
        return hPI;
    }

    public static String Io() {
        return "key_pb_history_list" + m.xL();
    }

    public static String Ip() {
        axb In = In();
        int size = In.jNe.size();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            int i = 0;
            while (i < In.jNe.size() && i < size) {
                axa com_tencent_mm_protocal_c_axa = (axa) In.jNe.get(i);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("word", com_tencent_mm_protocal_c_axa.tZQ);
                jSONArray2.put(jSONObject3);
                i++;
            }
            jSONObject2.put("items", jSONArray2);
            jSONObject2.put("count", jSONArray2.length());
            jSONObject2.put(Columns.TYPE, 4);
            jSONArray.put(jSONObject2);
            jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, jSONArray);
            jSONObject.put("ret", 0);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }
}
