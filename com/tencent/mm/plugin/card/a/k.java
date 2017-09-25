package com.tencent.mm.plugin.card.a;

import android.database.Cursor;
import android.text.TextUtils;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class k {
    private List<WeakReference<a>> kcI = new ArrayList();
    public List<g> kdw = new ArrayList();
    public int kdx = 0;

    public interface a {
        void a(g gVar);

        void adZ();
    }

    public k() {
        loadFromDB();
        ap.yY();
        Object obj = c.vr().get(139268, null);
        this.kdx = obj == null ? 0 : ((Integer) obj).intValue();
    }

    public final void a(g gVar) {
        if (this.kcI != null) {
            for (int i = 0; i < this.kcI.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kcI.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.a(gVar);
                    }
                }
            }
        }
    }

    public final void adZ() {
        if (this.kcI != null) {
            for (int i = 0; i < this.kcI.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kcI.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.adZ();
                    }
                }
            }
        }
    }

    public final void a(a aVar) {
        if (this.kcI == null) {
            this.kcI = new ArrayList();
        }
        if (aVar != null) {
            this.kcI.add(new WeakReference(aVar));
        }
    }

    public final void b(a aVar) {
        if (this.kcI != null && aVar != null) {
            for (int i = 0; i < this.kcI.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kcI.get(i);
                if (weakReference != null) {
                    a aVar2 = (a) weakReference.get();
                    if (aVar2 != null && aVar2.equals(aVar)) {
                        this.kcI.remove(weakReference);
                        return;
                    }
                }
            }
        }
    }

    public static void c(g gVar) {
        if (!al.agc().b(gVar)) {
            w.e("MicroMsg.CardMsgManager", "insert CardMsgInfo failed! id:" + gVar.field_msg_id);
        }
    }

    private void loadFromDB() {
        Cursor Kk = al.agc().Kk();
        if (Kk != null && Kk.getCount() > 0) {
            Kk.moveToFirst();
            int columnIndex = Kk.getColumnIndex("card_type");
            int columnIndex2 = Kk.getColumnIndex("title");
            int columnIndex3 = Kk.getColumnIndex("description");
            int columnIndex4 = Kk.getColumnIndex("logo_url");
            int columnIndex5 = Kk.getColumnIndex("time");
            int columnIndex6 = Kk.getColumnIndex("card_id");
            int columnIndex7 = Kk.getColumnIndex("card_tp_id");
            int columnIndex8 = Kk.getColumnIndex("msg_id");
            int columnIndex9 = Kk.getColumnIndex("msg_type");
            int columnIndex10 = Kk.getColumnIndex("jump_type");
            int columnIndex11 = Kk.getColumnIndex(SlookSmartClipMetaTag.TAG_TYPE_URL);
            int columnIndex12 = Kk.getColumnIndex("buttonData");
            int columnIndex13 = Kk.getColumnIndex("operData");
            int columnIndex14 = Kk.getColumnIndex("report_scene");
            int columnIndex15 = Kk.getColumnIndex("read_state");
            while (!Kk.isAfterLast()) {
                g gVar = new g();
                gVar.field_card_type = Kk.getInt(columnIndex);
                gVar.field_title = Kk.getString(columnIndex2);
                gVar.field_description = Kk.getString(columnIndex3);
                gVar.field_logo_url = Kk.getString(columnIndex4);
                gVar.field_time = Kk.getInt(columnIndex5);
                gVar.field_card_id = Kk.getString(columnIndex6);
                gVar.field_card_tp_id = Kk.getString(columnIndex7);
                gVar.field_msg_id = Kk.getString(columnIndex8);
                gVar.field_msg_type = Kk.getInt(columnIndex9);
                gVar.field_jump_type = Kk.getInt(columnIndex10);
                gVar.field_url = Kk.getString(columnIndex11);
                gVar.field_buttonData = Kk.getBlob(columnIndex12);
                gVar.field_operData = Kk.getBlob(columnIndex13);
                gVar.field_report_scene = Kk.getInt(columnIndex14);
                gVar.field_read_state = Kk.getInt(columnIndex15);
                Kk.moveToNext();
                this.kdw.add(gVar);
            }
        }
        if (Kk != null) {
            Kk.close();
        }
    }

    public static String f(Map<String, String> map, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < 100) {
            String str2 = str + ".jump_buttons" + (i > 0 ? Integer.valueOf(i) : "");
            if (bg.mA((String) map.get(str2 + ".title"))) {
                break;
            }
            stringBuilder.append("<jump_buttons>");
            stringBuilder.append("<title>" + bg.PW(bg.mz((String) map.get(str2 + ".title"))) + "</title>");
            stringBuilder.append("<description>" + bg.PW(bg.mz((String) map.get(str2 + ".description"))) + "</description>");
            stringBuilder.append("<button_wording>" + bg.PW(bg.mz((String) map.get(str2 + ".button_wording"))) + "</button_wording>");
            stringBuilder.append("<jump_url>" + bg.PW(bg.mz((String) map.get(str2 + ".jump_url"))) + "</jump_url>");
            stringBuilder.append("</jump_buttons>");
            i++;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        if (!bg.mA(stringBuilder.toString())) {
            stringBuilder2.append("<jump_buttons_list>");
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder2.append("</jump_buttons_list>");
        }
        return stringBuilder2.toString();
    }

    public static String g(Map<String, String> map, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < 100) {
            String str2 = str + ".accept_buttons" + (i > 0 ? Integer.valueOf(i) : "");
            String str3 = (String) map.get(str2 + ".title");
            if (bg.mA((String) map.get(str2 + ".card_id")) && bg.mA(str3)) {
                break;
            }
            stringBuilder.append("<accept_buttons>");
            stringBuilder.append("<title>" + bg.PW(bg.mz((String) map.get(str2 + ".title"))) + "</title>");
            stringBuilder.append("<sub_title>" + bg.PW(bg.mz((String) map.get(str2 + ".sub_title"))) + "</sub_title>");
            stringBuilder.append("<card_id>" + bg.PW(bg.mz((String) map.get(str2 + ".card_id"))) + "</card_id>");
            stringBuilder.append("<card_ext>" + bg.PW(bg.mz((String) map.get(str2 + ".card_ext"))) + "</card_ext>");
            stringBuilder.append("<end_time>" + bg.PW(bg.mz((String) map.get(str2 + ".end_time"))) + "</end_time>");
            stringBuilder.append("<action_type>" + bg.PW(bg.mz((String) map.get(str2 + ".action_type"))) + "</action_type>");
            stringBuilder.append("</accept_buttons>");
            i++;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        if (!bg.mA(stringBuilder.toString())) {
            stringBuilder2.append("<accept_buttons_list>");
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder2.append("</accept_buttons_list>");
        }
        return stringBuilder2.toString();
    }

    public static String h(Map<String, String> map, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < 100) {
            String str2 = str + ".unavailable_qr_code_list" + (i > 0 ? Integer.valueOf(i) : "");
            if (bg.mA((String) map.get(str2 + ".code_id"))) {
                break;
            }
            stringBuilder.append("<unavailable_qr_codes>");
            stringBuilder.append("<code_id>" + bg.PW(bg.mz((String) map.get(str2 + ".code_id"))) + "</code_id>");
            stringBuilder.append("</unavailable_qr_codes>");
            i++;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        if (!bg.mA(stringBuilder.toString())) {
            stringBuilder2.append("<unavailable_qr_code_list>");
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder2.append("</unavailable_qr_code_list>");
        }
        return stringBuilder2.toString();
    }

    public final boolean sn(String str) {
        if (this.kdw == null || TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < this.kdw.size(); i++) {
            g gVar = (g) this.kdw.get(i);
            if (gVar != null && gVar.field_msg_id != null && gVar.field_msg_id.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public final boolean so(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        g gVar;
        if (this.kdw == null || TextUtils.isEmpty(str)) {
            gVar = null;
        } else {
            for (int i = 0; i < this.kdw.size(); i++) {
                gVar = (g) this.kdw.get(i);
                if (str.equals(gVar.field_msg_id)) {
                    break;
                }
            }
            gVar = null;
        }
        if (gVar == null) {
            return false;
        }
        this.kdw.remove(gVar);
        d(gVar);
        return true;
    }

    public static boolean d(g gVar) {
        boolean z = false;
        if (gVar != null) {
            z = al.agc().a(gVar, new String[0]);
            if (!z) {
                w.e("MicroMsg.CardMsgManager", "delete CardMsgInfo failed! id:" + gVar.field_msg_id);
            }
        }
        return z;
    }

    public final void afN() {
        this.kdx = 0;
        ap.yY();
        c.vr().set(139268, Integer.valueOf(this.kdx));
    }

    public static void afO() {
        w.i("MicroMsg.CardMsgManager", "clearRedDotAndWording()");
        e.post(new Runnable() {
            public final void run() {
                w.i("MicroMsg.CardMsgManager", "begin to clearRedDotAndWording()");
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.uAF, "");
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.uAL, Integer.valueOf(0));
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.uAI, "");
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.uAJ, "");
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.uAK, "");
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.uAW, "");
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.uAX, Boolean.valueOf(false));
                if (com.tencent.mm.q.c.uk().aD(262152, 266256)) {
                    com.tencent.mm.q.c.uk().t(262152, false);
                }
                if (com.tencent.mm.q.c.uk().aC(262152, 266256)) {
                    com.tencent.mm.q.c.uk().s(262152, false);
                }
                if (com.tencent.mm.q.c.uk().a(com.tencent.mm.storage.w.a.uAz, com.tencent.mm.storage.w.a.uAB)) {
                    com.tencent.mm.q.c.uk().a(com.tencent.mm.storage.w.a.uAz, false);
                }
                if (com.tencent.mm.q.c.uk().a(com.tencent.mm.storage.w.a.uAA, com.tencent.mm.storage.w.a.uAC)) {
                    com.tencent.mm.q.c.uk().a(com.tencent.mm.storage.w.a.uAA, false);
                }
                w.i("MicroMsg.CardMsgManager", "end to clearRedDotAndWording()");
            }
        }, "clearRedDotAndWording");
    }
}
