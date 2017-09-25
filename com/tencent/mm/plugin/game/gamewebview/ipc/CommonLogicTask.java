package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.gi;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.model.ah;
import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.ArrayList;

public class CommonLogicTask extends GWMainProcessTask {
    public static final Creator<CommonLogicTask> CREATOR = new Creator<CommonLogicTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CommonLogicTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CommonLogicTask[i];
        }
    };
    public Bundle lHw = new Bundle();
    public int type;

    public final void SK() {
    }

    public final void PM() {
        int i = 0;
        boolean z = true;
        int mo;
        Bundle bundle;
        String str;
        b cbVar;
        switch (this.type) {
            case 1:
                if (this.lHw != null) {
                    z = this.lHw.getBoolean("permission_allow", false);
                    String string = this.lHw.getString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    if (bg.mA(string)) {
                        w.e("MicroMsg.ComonLogicTask", "ACTIVITY_JUMP_HANDLER, url is null");
                        return;
                    } else {
                        a.sBA.a(ab.getContext(), string, z);
                        return;
                    }
                }
                return;
            case 2:
                if (this.lHw != null) {
                    int[] intArray = this.lHw.getIntArray("getConfigStgKey");
                    if (intArray != null && intArray.length != 0) {
                        ArrayList arrayList = new ArrayList();
                        int length = intArray.length;
                        while (i < length) {
                            int i2 = intArray[i];
                            ap.yY();
                            arrayList.add(bg.mz((String) c.vr().get(i2, null)));
                            i++;
                        }
                        this.lHw.putStringArrayList("getConfigStgValue", arrayList);
                        return;
                    }
                    return;
                }
                return;
            case 3:
                if (this.lHw != null) {
                    Parcelable IS = f.bwZ().IS(this.lHw.getString("localId"));
                    if (IS != null) {
                        this.lHw.putParcelable("item", IS);
                        return;
                    }
                    return;
                }
                return;
            case 4:
                mo = mo("WebViewDownLoadFileSwitch");
                if (this.lHw == null) {
                    this.lHw = new Bundle();
                }
                bundle = this.lHw;
                str = "allowDownloadFile";
                if (mo != 1) {
                    z = false;
                }
                bundle.putBoolean(str, z);
                return;
            case 5:
                mo = mo("EnableWebviewScanQRCode");
                bundle = this.lHw;
                str = "allow_webview_scan";
                if (mo != 1) {
                    z = false;
                }
                bundle.putBoolean(str, z);
                return;
            case 6:
                this.lHw.putBoolean("has_set_uin", ap.zb());
                return;
            case 7:
                cbVar = new cb();
                e.a(cbVar, 1, this.lHw.getString("image_path", ""));
                com.tencent.mm.sdk.b.a.urY.m(cbVar);
                this.lHw.putInt("fav_simple_img_result", cbVar.fFB.ret);
                return;
            case 8:
                this.lHw.putString("file_path", ah.IW(this.lHw.getString("localId")));
                return;
            case 9:
                String string2 = this.lHw.getString("game_hv_menu_appid");
                cbVar = new gi();
                cbVar.fLC.ou = 3;
                cbVar.fLC.fLE = string2;
                com.tencent.mm.sdk.b.a.urY.m(cbVar);
                this.lHw.putString("game_hv_menu_pbcache", cbVar.fLD.result);
                return;
            default:
                return;
        }
    }

    private static int mo(String str) {
        int i = 1;
        try {
            i = bg.getInt(g.sV().getValue(str), 1);
        } catch (Exception e) {
            w.e("MicroMsg.ComonLogicTask", "getIntValFromDynamicConfig parseInt failed, val: " + str);
        }
        return i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeBundle(this.lHw);
    }

    public final void f(Parcel parcel) {
        this.type = parcel.readInt();
        this.lHw = parcel.readBundle(getClass().getClassLoader());
    }

    CommonLogicTask(Parcel parcel) {
        f(parcel);
    }
}
