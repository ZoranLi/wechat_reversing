package com.tencent.mm.plugin.card.model;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.protocal.c.ir;
import com.tencent.mm.protocal.c.iv;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class g extends ab {
    protected static com.tencent.mm.sdk.e.c.a gTP;
    public String kfa = "";
    public String kfb = "";
    public String kfc;
    public String kfd;
    public String kfe;
    public boolean kff = false;
    public ir kfg;
    public iv kfh;
    public List<a> kfi = null;
    public List<b> kfj = null;
    public int kfk = 0;
    public int kfl = 0;
    public boolean kfm;
    public List<c> kfn = null;

    public class a {
        public String cardId;
        public String kfo;
        public String kfp;
        public int kfq;
        public int kfr;
        final /* synthetic */ g kfs;
        public String title;

        public a(g gVar) {
            this.kfs = gVar;
        }
    }

    public class b {
        public String description;
        final /* synthetic */ g kfs;
        public String kft;
        public String kfu;
        public String title;

        public b(g gVar) {
            this.kfs = gVar;
        }
    }

    public class c {
        final /* synthetic */ g kfs;
        public String kfv;

        public c(g gVar) {
            this.kfs = gVar;
        }
    }

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hXH = new Field[21];
        aVar.columns = new String[22];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "card_type";
        aVar.uxd.put("card_type", "INTEGER");
        stringBuilder.append(" card_type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[1] = "title";
        aVar.uxd.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "description";
        aVar.uxd.put("description", "TEXT");
        stringBuilder.append(" description TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "logo_url";
        aVar.uxd.put("logo_url", "TEXT");
        stringBuilder.append(" logo_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "time";
        aVar.uxd.put("time", "INTEGER");
        stringBuilder.append(" time INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "card_id";
        aVar.uxd.put("card_id", "TEXT");
        stringBuilder.append(" card_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "card_tp_id";
        aVar.uxd.put("card_tp_id", "TEXT");
        stringBuilder.append(" card_tp_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "msg_id";
        aVar.uxd.put("msg_id", "TEXT PRIMARY KEY ");
        stringBuilder.append(" msg_id TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "msg_id";
        aVar.columns[8] = "msg_type";
        aVar.uxd.put("msg_type", "INTEGER");
        stringBuilder.append(" msg_type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "jump_type";
        aVar.uxd.put("jump_type", "INTEGER");
        stringBuilder.append(" jump_type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = SlookSmartClipMetaTag.TAG_TYPE_URL;
        aVar.uxd.put(SlookSmartClipMetaTag.TAG_TYPE_URL, "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "buttonData";
        aVar.uxd.put("buttonData", "BLOB");
        stringBuilder.append(" buttonData BLOB");
        stringBuilder.append(", ");
        aVar.columns[12] = "operData";
        aVar.uxd.put("operData", "BLOB");
        stringBuilder.append(" operData BLOB");
        stringBuilder.append(", ");
        aVar.columns[13] = "report_scene";
        aVar.uxd.put("report_scene", "INTEGER");
        stringBuilder.append(" report_scene INTEGER");
        stringBuilder.append(", ");
        aVar.columns[14] = "read_state";
        aVar.uxd.put("read_state", "INTEGER default '0' ");
        stringBuilder.append(" read_state INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "accept_buttons";
        aVar.uxd.put("accept_buttons", "TEXT");
        stringBuilder.append(" accept_buttons TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "consumed_box_id";
        aVar.uxd.put("consumed_box_id", "TEXT");
        stringBuilder.append(" consumed_box_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[17] = "jump_buttons";
        aVar.uxd.put("jump_buttons", "TEXT");
        stringBuilder.append(" jump_buttons TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "logo_color";
        aVar.uxd.put("logo_color", "TEXT");
        stringBuilder.append(" logo_color TEXT");
        stringBuilder.append(", ");
        aVar.columns[19] = "unavailable_qr_code_list";
        aVar.uxd.put("unavailable_qr_code_list", "TEXT");
        stringBuilder.append(" unavailable_qr_code_list TEXT");
        stringBuilder.append(", ");
        aVar.columns[20] = "all_unavailable";
        aVar.uxd.put("all_unavailable", "INTEGER default 'false' ");
        stringBuilder.append(" all_unavailable INTEGER default 'false' ");
        aVar.columns[21] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a sY() {
        return gTP;
    }

    public final ir afQ() {
        if (this.kfg != null) {
            return this.kfg;
        }
        try {
            this.kfg = (ir) new ir().aD(this.field_buttonData);
            return this.kfg;
        } catch (Throwable e) {
            w.e("MicroMsg.CardMsgInfo", "getCardButton fail, ex = %s", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.CardMsgInfo", e, "", new Object[0]);
            return new ir();
        }
    }

    public final iv afR() {
        if (this.kfh != null) {
            return this.kfh;
        }
        try {
            this.kfh = (iv) new iv().aD(this.field_operData);
            return this.kfh;
        } catch (Throwable e) {
            w.e("MicroMsg.CardMsgInfo", "getOperationRegion fail, ex = %s", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.CardMsgInfo", e, "", new Object[0]);
            return new iv();
        }
    }

    public final void afS() {
        if (this.kfi == null) {
            this.kfi = new ArrayList();
            if (!bg.mA(this.field_accept_buttons)) {
                Map q = bh.q(this.field_accept_buttons, "accept_buttons_list");
                if (q != null) {
                    int i = 0;
                    while (i < 100) {
                        String str = ".accept_buttons_list.accept_buttons" + (i > 0 ? Integer.valueOf(i) : "");
                        String str2 = (String) q.get(str + ".title");
                        if (!bg.mA((String) q.get(str + ".card_id")) || !bg.mA(str2)) {
                            int i2 = bg.getInt((String) q.get(str + ".end_time"), 0);
                            if (i2 == 0 || ((long) i2) > bg.Ny()) {
                                a aVar = new a(this);
                                aVar.title = (String) q.get(str + ".title");
                                aVar.kfo = (String) q.get(str + ".sub_title");
                                aVar.kfp = (String) q.get(str + ".card_ext");
                                aVar.cardId = (String) q.get(str + ".card_id");
                                aVar.kfr = bg.getInt((String) q.get(str + ".action_type"), 0);
                                aVar.kfq = i2;
                                this.kfi.add(aVar);
                            }
                            i++;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    public final void afT() {
        if (this.kfj == null) {
            this.kfj = new ArrayList();
            if (!bg.mA(this.field_jump_buttons)) {
                Map q = bh.q(this.field_jump_buttons, "jump_buttons_list");
                if (q != null) {
                    int i = 0;
                    while (i < 100) {
                        String str = ".jump_buttons_list.jump_buttons" + (i > 0 ? Integer.valueOf(i) : "");
                        if (!bg.mA((String) q.get(str + ".title"))) {
                            b bVar = new b(this);
                            bVar.title = (String) q.get(str + ".title");
                            bVar.description = (String) q.get(str + ".description");
                            bVar.kft = (String) q.get(str + ".button_wording");
                            bVar.kfu = (String) q.get(str + ".jump_url");
                            this.kfj.add(bVar);
                            i++;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    public final void afU() {
        if (this.kfn == null) {
            this.kfn = new ArrayList();
            if (!bg.mA(this.field_unavailable_qr_code_list)) {
                Map q = bh.q(this.field_unavailable_qr_code_list, "unavailable_qr_code_list");
                if (q != null) {
                    int i = 0;
                    while (i < 100) {
                        String str = ".unavailable_qr_code_list.unavailable_qr_codes" + (i > 0 ? Integer.valueOf(i) : "");
                        if (!bg.mA((String) q.get(str + ".code_id"))) {
                            c cVar = new c(this);
                            cVar.kfv = (String) q.get(str + ".code_id");
                            this.kfn.add(cVar);
                            i++;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }
}
