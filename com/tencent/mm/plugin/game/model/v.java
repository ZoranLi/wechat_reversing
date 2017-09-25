package com.tencent.mm.plugin.game.model;

import com.tencent.mm.e.a.gl;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class v {
    static void a(gl glVar) {
        String str = glVar.fLJ.fLE;
        w.d("MicroMsg.GameJsapiProcessor", "writeMsg param=%s", new Object[]{str});
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.isNull(Columns.TYPE) || bg.getInt(jSONObject.optString(Columns.TYPE), 0) == 0) {
                    JSONArray jSONArray = new JSONArray();
                    JSONArray jSONArray2 = jSONObject.getJSONArray("localIdList");
                    int length = jSONArray2.length();
                    long[] jArr = new long[length];
                    for (int i = 0; i < length; i++) {
                        jArr[i] = jSONArray2.getLong(i);
                    }
                    SubCoreGameCenter.aBB().e(jArr);
                } else if (bg.getInt(jSONObject.optString(Columns.TYPE), 0) == 65536) {
                    SubCoreGameCenter.aBB().eE("GameRawMessage", "update GameRawMessage set isRead=1 where 1=1");
                }
            } catch (JSONException e) {
                w.w("MicroMsg.GameJsapiProcessor", "JSONException : %s", new Object[]{e.getMessage()});
            }
        }
    }
}
