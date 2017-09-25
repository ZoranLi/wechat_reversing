package com.tencent.mm.modelbiz;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class i {
    public static String hvJ = "menu_click";
    public static String hvK = "menu_action_start";
    public static String hvL = "menu_action_success";
    public String arH;
    public String content;
    public String fZF;
    public List<i> hvM = null;
    public int hvN;
    public int id;
    public String name;
    public String state;
    public int type;
    public String value;

    public final void e(ArrayList<String> arrayList) {
        if (arrayList.size() == 0) {
            w.e("MicroMsg.BizMenuItem", "value null!");
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pic_md5", str);
                jSONArray.put(jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("pics", jSONArray);
            this.content = jSONObject2.toString();
            w.v("MicroMsg.BizMenuItem", this.content);
        } catch (JSONException e) {
            w.e("MicroMsg.BizMenuItem", e.toString());
        }
    }

    public final String getInfo() {
        if (this.content == null) {
            this.content = "";
        }
        if (this.state == null) {
            if (this.type == 4) {
                this.state = hvK;
            } else {
                this.state = hvJ;
            }
        }
        return String.format("%s<info><id><![CDATA[%d]]></id><key><![CDATA[%s]]></key><status><![CDATA[%s]]></status><content><![CDATA[%s]]></content></info>", new Object[]{"#bizmenu#", Integer.valueOf(this.id), this.arH, this.state, this.content});
    }

    public final String toString() {
        String str = "id:%d, type:%d, acttype:%s, name:%s, key:%s, value:%s, content:%s";
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(this.id);
        objArr[1] = Integer.valueOf(this.hvN);
        objArr[2] = Integer.valueOf(this.type);
        objArr[3] = this.name == null ? "" : this.name;
        objArr[4] = this.arH == null ? "" : this.arH;
        objArr[5] = this.value == null ? "" : this.value;
        objArr[6] = this.content == null ? "" : this.content;
        return String.format(str, objArr);
    }

    public static List<i> c(JSONArray jSONArray) {
        List<i> arrayList;
        if (jSONArray != null) {
            try {
                arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    i iVar = new i();
                    iVar.id = jSONObject.getInt(SlookAirButtonFrequentContactAdapter.ID);
                    iVar.type = jSONObject.getInt(Columns.TYPE);
                    iVar.name = jSONObject.getString("name");
                    iVar.arH = jSONObject.getString("key");
                    iVar.value = jSONObject.optString(Columns.VALUE);
                    iVar.fZF = jSONObject.optString("native_url");
                    w.d("MicroMsg.BizMenuItem", "menuItem.nativeurl : " + iVar.fZF);
                    iVar.hvM = c(jSONObject.optJSONArray("sub_button_list"));
                    iVar.hvN = jSONObject.optInt("acttype");
                    arrayList.add(iVar);
                }
            } catch (Throwable e) {
                w.e("MicroMsg.BizMenuItem", "exception:%s", bg.g(e));
                return null;
            }
        }
        arrayList = null;
        return arrayList;
    }

    public static LinkedList<i> l(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        int i = bg.getInt((String) map.get(".msg.appmsg.buttonlist.$count"), 0);
        if (i <= 0) {
            return null;
        }
        try {
            LinkedList<i> linkedList = new LinkedList();
            w.v("MicroMsg.BizMenuItem", "menuItem.jsonArray.length : " + i);
            int i2 = 0;
            while (i2 < i) {
                i iVar = new i();
                String str = ".msg.appmsg.buttonlist.button" + (i2 == 0 ? "" : String.valueOf(i2));
                iVar.id = bg.getInt((String) map.get(str + ".id"), 0);
                iVar.type = bg.getInt((String) map.get(str + ".type"), 0);
                iVar.name = (String) map.get(str + ".name");
                iVar.arH = (String) map.get(str + ".key");
                iVar.value = (String) map.get(str + ".value");
                iVar.hvN = bg.getInt((String) map.get(str + ".acttype"), 0);
                linkedList.add(iVar);
                i2++;
            }
            return linkedList;
        } catch (Throwable e) {
            w.e("MicroMsg.BizMenuItem", "exception:%s", bg.g(e));
            return null;
        }
    }
}
