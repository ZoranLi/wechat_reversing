package com.tencent.mm.plugin.webview.e;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.ay.b;
import com.tencent.mm.e.a.kb;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends c<kb> {
    public a() {
        this.usg = kb.class.getName().hashCode();
    }

    private static boolean a(kb kbVar) {
        w.i("MicroMsg.NotifyWNNoteWebviewOperationListener", "on NotifyWNNoteWebviewOperationListener operation listener, %d", new Object[]{Integer.valueOf(kbVar.fQz.type)});
        g wH;
        switch (kbVar.fQz.type) {
            case 0:
                if (f.bwX().soz.length() <= 0 || !f.bwX().soz.equals(kbVar.fQz.fQB)) {
                    f.bwX().soA = kbVar.fQz.fQD;
                    f.bwX().soz = kbVar.fQz.fQB;
                    f.bwX().fQF = kbVar.fQz.fQF;
                    f.bwX().fQG = kbVar.fQz.fQG;
                    f.bwX().soF = true;
                    w.i("MicroMsg.NotifyWNNoteWebviewOperationListener", "WNNote: do reload:%s", new Object[]{kbVar.fQz.fQD.toString()});
                    if (f.bwX().soB != null) {
                        h.wH(b.soE).dD(f.bwX().soB);
                        break;
                    }
                }
                break;
            case 1:
                Bundle bundle = new Bundle();
                bundle.putString("editorId", kbVar.fQz.fQq);
                bundle.putString("localPath", kbVar.fQz.fQE);
                if (kbVar.fQz.fQv == 4) {
                    kbVar.fQz.fQH = com.tencent.mm.ay.a.Mf() + "/fav_fileicon_recording.png";
                    bundle.putString("iconPath", kbVar.fQz.fQH);
                    bundle.putInt("voiceDuration", kbVar.fQz.fKx);
                    w.i("MicroMsg.NotifyWNNoteWebviewOperationListener", "WNNote: do Insert:%s", new Object[]{bundle.toString()});
                }
                if (!f.bwX().soF) {
                    h.wH(b.soE).T(bundle);
                    break;
                }
                JSONArray jSONArray = f.bwX().soA;
                int i = 0;
                while (i < jSONArray.length()) {
                    try {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        if (jSONObject.getString("localEditorId").equals(kbVar.fQz.fQq)) {
                            jSONObject.put("localPath", kbVar.fQz.fQE);
                            jSONObject.put("downloaded", true);
                            if (jSONObject.getInt(Columns.TYPE) == 4) {
                                jSONObject.put("iconPath", kbVar.fQz.fQH);
                                jSONObject.put("length", (int) b.aw((long) kbVar.fQz.fKx));
                                jSONObject.put("lengthStr", b.s(ab.getContext(), jSONObject.getInt("length")).toString());
                                if (!f.bwX().soF) {
                                    h.wH(b.soE).T(bundle);
                                    break;
                                }
                            }
                        }
                        i++;
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.NotifyWNNoteWebviewOperationListener", e, "", new Object[0]);
                    }
                }
                break;
            case 2:
                wH = h.wH(b.soE);
                String str = kbVar.fQz.fQE;
                int i2 = kbVar.fQz.fKw;
                int i3 = kbVar.fQz.fKx;
                w.i("MicroMsg.MsgHandler", "WNJSHandlerVoiceDisplay");
                Bundle bundle2 = new Bundle();
                bundle2.putString("voicePath", str);
                bundle2.putInt("voiceType", i2);
                bundle2.putInt("voiceDuration", i3);
                try {
                    if (wH.rXh != null) {
                        wH.rXh.m(37, bundle2);
                        break;
                    }
                } catch (RemoteException e2) {
                    w.w("MicroMsg.MsgHandler", "WNJSHandlerVoiceDisplay exception" + e2.getMessage());
                    break;
                }
                break;
            case 3:
                f.bwX().soI = false;
                f.bwX().bAm();
                switch (kbVar.fQz.fQv) {
                    case 1:
                    case 2:
                        if (kbVar.fQz.fQv != 1) {
                            f.bwX().soD = false;
                            break;
                        }
                        f.bwX().soD = true;
                        break;
                    default:
                        break;
                }
            case 4:
                wH = h.wH(b.soE);
                Bundle bundle3 = kbVar.fQz.fQu;
                w.i("MicroMsg.MsgHandler", "WNJSHandlerVoiceOnPlayStatusChange");
                try {
                    if (wH.rXh != null) {
                        wH.rXh.m(40, bundle3);
                        break;
                    }
                } catch (RemoteException e22) {
                    w.w("MicroMsg.MsgHandler", "WNJSHandlerVoiceOnPlayStatusChange exception" + e22.getMessage());
                    break;
                }
                break;
            case 5:
                kbVar.fQA.ret = b.soE;
                break;
            case 6:
                Bundle bundle4 = new Bundle();
                if (bg.mA(kbVar.fQz.fQq)) {
                    bundle4.putInt("operation_type", 3);
                } else {
                    bundle4.putInt("operation_type", 4);
                    bundle4.putInt("updateEditorId", bg.getInt(kbVar.fQz.fQq, 0));
                }
                bundle4.putString("jsonobjstr", kbVar.fQz.fQC);
                h.wH(b.soE).V(bundle4);
                break;
        }
        return false;
    }
}
