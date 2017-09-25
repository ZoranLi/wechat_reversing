package com.tencent.mm.storage.a;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mm.bj.f;
import com.tencent.mm.bj.f.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public final class e extends i<d> implements a {
    public static final String[] gUx = new String[]{i.a(d.gTP, "EmojiInfoDesc")};
    public com.tencent.mm.sdk.e.e gUz;
    public SharedPreferences uLo;

    public final /* synthetic */ boolean b(c cVar) {
        d dVar = (d) cVar;
        if (dVar != null) {
            if (dVar.EP().length() == 32) {
                dVar.field_md5_lang = dVar.field_md5 + dVar.field_lang;
                long replace = this.gUz.replace("EmojiInfoDesc", "md5_lang", dVar.pv());
                if (replace != -1) {
                    Qr(dVar.EP());
                }
                return replace >= 0;
            }
        }
        return false;
    }

    public e(com.tencent.mm.sdk.e.e eVar) {
        this(eVar, d.gTP, "EmojiInfoDesc");
    }

    private e(com.tencent.mm.sdk.e.e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.gUz = eVar;
        this.uLo = PreferenceManager.getDefaultSharedPreferences(ab.getContext());
    }

    public final int a(f fVar) {
        if (fVar != null) {
            this.gUz = fVar;
        }
        return 0;
    }

    public final boolean Sf(String str) {
        boolean z = true;
        boolean z2 = false;
        Cursor cursor = null;
        try {
            cursor = this.gUz.a(String.format("select %s from %s where %s=?", new Object[]{"click_flag", "EmojiInfoDesc", "groupId"}), new String[]{str}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                if ((cursor.getInt(cursor.getColumnIndex("click_flag")) & 1) != 1) {
                    z = false;
                }
                z2 = z;
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            w.w("MicroMsg.emoji.EmojiInfoDescStorage", "[isPurChase] Exception:%s", new Object[]{e.toString()});
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return z2;
    }

    public final boolean Sg(String str) {
        boolean z = true;
        boolean z2 = false;
        Cursor cursor = null;
        try {
            cursor = this.gUz.a(String.format("select %s from %s where %s=?", new Object[]{"download_flag", "EmojiInfoDesc", "groupId"}), new String[]{str}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                if ((cursor.getInt(cursor.getColumnIndex("download_flag")) & 1) != 1) {
                    z = false;
                }
                z2 = z;
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            w.w("MicroMsg.emoji.EmojiInfoDescStorage", "[isPurChase] Exception:%s", new Object[]{e.toString()});
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return z2;
    }

    public final boolean Sh(String str) {
        boolean z = false;
        if (!TextUtils.isEmpty(str)) {
            Cursor cursor = null;
            try {
                cursor = this.gUz.a(String.format("select %s from %s where %s=?", new Object[]{"desc", "EmojiInfoDesc", "groupId"}), new String[]{str}, 2);
                if (cursor != null && cursor.moveToFirst()) {
                    z = true;
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e) {
                w.w("MicroMsg.emoji.EmojiInfoDescStorage", e.toString());
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return z;
    }
}
