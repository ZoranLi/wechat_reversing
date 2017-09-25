package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.sdk.e.c;

public abstract class ab extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gfD = "title".hashCode();
    private static final int gfE = "description".hashCode();
    private static final int giA = "jump_type".hashCode();
    private static final int giB = SlookSmartClipMetaTag.TAG_TYPE_URL.hashCode();
    private static final int giC = "buttonData".hashCode();
    private static final int giD = "operData".hashCode();
    private static final int giE = "report_scene".hashCode();
    private static final int giF = "read_state".hashCode();
    private static final int giG = "accept_buttons".hashCode();
    private static final int giH = "consumed_box_id".hashCode();
    private static final int giI = "jump_buttons".hashCode();
    private static final int giJ = "logo_color".hashCode();
    private static final int giK = "unavailable_qr_code_list".hashCode();
    private static final int giL = "all_unavailable".hashCode();
    private static final int git = "card_type".hashCode();
    private static final int giu = "logo_url".hashCode();
    private static final int giv = "time".hashCode();
    private static final int giw = "card_id".hashCode();
    private static final int gix = "card_tp_id".hashCode();
    private static final int giy = "msg_id".hashCode();
    private static final int giz = "msg_type".hashCode();
    public String field_accept_buttons;
    public boolean field_all_unavailable;
    public byte[] field_buttonData;
    public String field_card_id;
    public String field_card_tp_id;
    public int field_card_type;
    public String field_consumed_box_id;
    public String field_description;
    public String field_jump_buttons;
    public int field_jump_type;
    public String field_logo_color;
    public String field_logo_url;
    public String field_msg_id;
    public int field_msg_type;
    public byte[] field_operData;
    public int field_read_state;
    public int field_report_scene;
    public int field_time;
    public String field_title;
    public String field_unavailable_qr_code_list;
    public String field_url;
    private boolean gfA = true;
    private boolean gfz = true;
    private boolean gia = true;
    private boolean gib = true;
    private boolean gic = true;
    private boolean gid = true;
    private boolean gie = true;
    private boolean gif = true;
    private boolean gig = true;
    private boolean gih = true;
    private boolean gii = true;
    private boolean gij = true;
    private boolean gik = true;
    private boolean gil = true;
    private boolean gim = true;
    private boolean gin = true;
    private boolean gio = true;
    private boolean gip = true;
    private boolean giq = true;
    private boolean gir = true;
    private boolean gis = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (git == hashCode) {
                    this.field_card_type = cursor.getInt(i);
                } else if (gfD == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (gfE == hashCode) {
                    this.field_description = cursor.getString(i);
                } else if (giu == hashCode) {
                    this.field_logo_url = cursor.getString(i);
                } else if (giv == hashCode) {
                    this.field_time = cursor.getInt(i);
                } else if (giw == hashCode) {
                    this.field_card_id = cursor.getString(i);
                } else if (gix == hashCode) {
                    this.field_card_tp_id = cursor.getString(i);
                } else if (giy == hashCode) {
                    this.field_msg_id = cursor.getString(i);
                    this.gif = true;
                } else if (giz == hashCode) {
                    this.field_msg_type = cursor.getInt(i);
                } else if (giA == hashCode) {
                    this.field_jump_type = cursor.getInt(i);
                } else if (giB == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (giC == hashCode) {
                    this.field_buttonData = cursor.getBlob(i);
                } else if (giD == hashCode) {
                    this.field_operData = cursor.getBlob(i);
                } else if (giE == hashCode) {
                    this.field_report_scene = cursor.getInt(i);
                } else if (giF == hashCode) {
                    this.field_read_state = cursor.getInt(i);
                } else if (giG == hashCode) {
                    this.field_accept_buttons = cursor.getString(i);
                } else if (giH == hashCode) {
                    this.field_consumed_box_id = cursor.getString(i);
                } else if (giI == hashCode) {
                    this.field_jump_buttons = cursor.getString(i);
                } else if (giJ == hashCode) {
                    this.field_logo_color = cursor.getString(i);
                } else if (giK == hashCode) {
                    this.field_unavailable_qr_code_list = cursor.getString(i);
                } else if (giL == hashCode) {
                    this.field_all_unavailable = cursor.getInt(i) != 0;
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gia) {
            contentValues.put("card_type", Integer.valueOf(this.field_card_type));
        }
        if (this.gfz) {
            contentValues.put("title", this.field_title);
        }
        if (this.gfA) {
            contentValues.put("description", this.field_description);
        }
        if (this.gib) {
            contentValues.put("logo_url", this.field_logo_url);
        }
        if (this.gic) {
            contentValues.put("time", Integer.valueOf(this.field_time));
        }
        if (this.gid) {
            contentValues.put("card_id", this.field_card_id);
        }
        if (this.gie) {
            contentValues.put("card_tp_id", this.field_card_tp_id);
        }
        if (this.gif) {
            contentValues.put("msg_id", this.field_msg_id);
        }
        if (this.gig) {
            contentValues.put("msg_type", Integer.valueOf(this.field_msg_type));
        }
        if (this.gih) {
            contentValues.put("jump_type", Integer.valueOf(this.field_jump_type));
        }
        if (this.gii) {
            contentValues.put(SlookSmartClipMetaTag.TAG_TYPE_URL, this.field_url);
        }
        if (this.gij) {
            contentValues.put("buttonData", this.field_buttonData);
        }
        if (this.gik) {
            contentValues.put("operData", this.field_operData);
        }
        if (this.gil) {
            contentValues.put("report_scene", Integer.valueOf(this.field_report_scene));
        }
        if (this.gim) {
            contentValues.put("read_state", Integer.valueOf(this.field_read_state));
        }
        if (this.gin) {
            contentValues.put("accept_buttons", this.field_accept_buttons);
        }
        if (this.gio) {
            contentValues.put("consumed_box_id", this.field_consumed_box_id);
        }
        if (this.gip) {
            contentValues.put("jump_buttons", this.field_jump_buttons);
        }
        if (this.giq) {
            contentValues.put("logo_color", this.field_logo_color);
        }
        if (this.gir) {
            contentValues.put("unavailable_qr_code_list", this.field_unavailable_qr_code_list);
        }
        if (this.gis) {
            contentValues.put("all_unavailable", Boolean.valueOf(this.field_all_unavailable));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
