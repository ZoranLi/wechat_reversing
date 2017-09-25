package com.tencent.mm.plugin.game.model;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class i {
    JSONObject mpo = new JSONObject();

    protected i(String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.GameServerData", "Null or nil json string");
            return;
        }
        try {
            this.mpo = new JSONObject(str);
        } catch (JSONException e) {
            w.e("MicroMsg.GameServerData", "Json parsing error");
        }
    }

    protected final JSONArray optJSONArray(String str) {
        return this.mpo.optJSONArray(str);
    }

    private static String c(JSONObject jSONObject, String str) {
        if (jSONObject == null || jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str);
    }

    protected static LinkedList<c> n(JSONArray jSONArray) {
        LinkedList<c> linkedList = new LinkedList();
        if (jSONArray == null || jSONArray.length() == 0) {
            w.i("MicroMsg.GameServerData", "Null or empty json array");
            return linkedList;
        }
        w.i("MicroMsg.GameServerData", "Parsing json AppInfo, size: %d", new Object[]{Integer.valueOf(jSONArray.length())});
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj;
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject == null) {
                w.e("MicroMsg.GameServerData", "Invalid json object");
                obj = null;
            } else {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("YYB");
                String c = c(optJSONObject, "appID");
                if (bg.mA(c)) {
                    w.e("MicroMsg.GameServerData", "No AppID field, abort");
                    obj = null;
                } else {
                    w.i("MicroMsg.GameServerData", "Parsing AppID: %s", new Object[]{c});
                    obj = new c();
                    obj.field_appId = c;
                    obj.field_appName = c(optJSONObject, "name");
                    obj.field_appIconUrl = c(optJSONObject, "iconURL");
                    obj.field_appType = ",1,";
                    obj.field_packageName = c(optJSONObject, "AndroidPackageName");
                    obj.bD(c(optJSONObject, "downloadURL"));
                    obj.bG(c(optJSONObject, "AndroidApkMd5"));
                    c = c(optJSONObject, "GooglePlayDownloadUrl");
                    int optInt = optJSONObject.optInt("GooglePlayDownloadFlag");
                    obj.bH(c);
                    if (!bg.mA(c)) {
                        w.i("MicroMsg.GameServerData", "GooglePlay URL: %s, Download Flag: %d", new Object[]{c, Integer.valueOf(optInt)});
                        obj.da(optInt);
                    }
                    if (optJSONObject2 != null) {
                        obj.da(optJSONObject2.optInt("AndroidDownloadFlag"));
                    }
                    if (optJSONObject2 != null) {
                        obj.bM(c(optJSONObject2, "DownloadUrl"));
                        obj.bN(c(optJSONObject2, "ApkMd5"));
                        obj.bK(c(optJSONObject2, "PreemptiveUrl"));
                        obj.bL(c(optJSONObject2, "ExtInfo"));
                        obj.db(optJSONObject2.optInt("SupportedVersionCode"));
                    }
                    obj.moz = c(optJSONObject, "desc");
                    obj.moy = c(optJSONObject, "brief");
                    obj.type = optJSONObject.optInt(Columns.TYPE, 0);
                    obj.status = optJSONObject.optInt(DownloadInfo.STATUS);
                    obj.moB = c(optJSONObject, "webURL");
                    obj.moC = c(optJSONObject, "adUrl");
                    obj.fDE = c(optJSONObject, "noticeid");
                    obj.moD = optJSONObject.optBoolean("isSubscribed");
                    obj.versionCode = optJSONObject.optInt(DownloadInfoColumns.VERSIONCODE);
                    if (optJSONObject2 != null) {
                        obj.moE = c(optJSONObject2, "DownloadTipsWording");
                        obj.moF = c(optJSONObject2, "BackBtnWording");
                        obj.moG = c(optJSONObject2, "DownloadBtnWording");
                    }
                }
            }
            if (obj != null) {
                linkedList.add(obj);
            }
        }
        return linkedList;
    }
}
