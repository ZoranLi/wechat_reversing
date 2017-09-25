package com.tencent.mm.booter;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mars.xlog.Xlog;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.xlog.app.XLogSetup;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;

public final class c {
    private static c gJM;
    private final String[] columns = new String[]{"_id", "key", Columns.TYPE, Columns.VALUE};
    private Context ctx;
    public int gJL = -1;
    private final HashMap<String, Object> values = new HashMap();

    public static final class a {
        public static Object i(int i, String str) {
            switch (i) {
                case 1:
                    return Integer.valueOf(str);
                case 2:
                    return Long.valueOf(str);
                case 3:
                    return str;
                case 4:
                    return Boolean.valueOf(str);
                case 5:
                    return Float.valueOf(str);
                case 6:
                    return Double.valueOf(str);
                default:
                    try {
                        w.e("MicroMsg.Debugger.Resolver", "unknown type");
                    } catch (Exception e) {
                    }
                    return null;
            }
        }
    }

    public static c ao(Context context) {
        if (gJM == null) {
            gJM = new c(context);
        }
        return gJM;
    }

    private c(Context context) {
        Cursor query;
        this.ctx = context;
        try {
            query = context.getContentResolver().query(com.tencent.mm.l.a.a.CONTENT_URI, this.columns, null, null, null);
        } catch (Exception e) {
            query = null;
        }
        if (query != null) {
            if (query.getCount() <= 0) {
                query.close();
            } else if ("18c867f0717aa67b2ab7347505ba07ed".equals(bg.j("com.tencent.mm.coolassist", context))) {
                b.bIt();
                int columnIndex = query.getColumnIndex("key");
                int columnIndex2 = query.getColumnIndex(Columns.TYPE);
                int columnIndex3 = query.getColumnIndex(Columns.VALUE);
                while (query.moveToNext()) {
                    this.values.put(query.getString(columnIndex), a.i(query.getInt(columnIndex2), query.getString(columnIndex3)));
                }
                query.close();
            } else {
                query.close();
            }
        }
    }

    public final void cR(String str) {
        boolean z = true;
        Integer integer = getInteger(".com.tencent.mm.debug.log.level");
        boolean b = bg.b(cS(".com.tencent.mm.debug.log.append_mode"), false);
        boolean z2 = bg.mA(getString(".com.tencent.mm.debug.log.mmlog")) && bg.b(cS(".com.tencent.mm.debug.test.uploadLog"), false);
        if (z2) {
            String string = getString(".com.tencent.mm.debug.log.tag.skey");
            if (string != null && string.length() > 0) {
                Xlog.logDecryptor = new x(string);
            }
        }
        boolean z3 = this.ctx.getSharedPreferences("system_config_prefs", 4).getBoolean("first_launch_weixin", true);
        if (!"MM".equalsIgnoreCase(str)) {
            z3 = false;
        }
        XLogSetup.keep_setupXLog(!z3, com.tencent.mm.storage.w.uzg, e.gSF, integer, Boolean.valueOf(b), Boolean.valueOf(z2), str);
        w.yu(w.getLogLevel());
        if (bg.getInt(bg.ap(getString(".com.tencent.mm.debug.monkeyEnv"), "0"), 0) != 1) {
            z = false;
        }
        b.jP(z);
    }

    public final String getString(String str) {
        Object obj = this.values.get(str);
        if (!(obj instanceof String)) {
            return null;
        }
        w.d("MicroMsg.Debugger", "getString(): key=" + str + ", value=" + obj.toString());
        return (String) obj;
    }

    public final Integer getInteger(String str) {
        Object obj = this.values.get(str);
        if (!(obj instanceof Integer)) {
            return null;
        }
        w.d("MicroMsg.Debugger", "getInteger(): key=" + str + ", value=" + obj.toString());
        return (Integer) obj;
    }

    public final Boolean cS(String str) {
        Object obj = this.values.get(str);
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof Boolean)) {
            return null;
        }
        w.d("MicroMsg.Debugger", "getBoolean(): key=" + str + ", value=" + obj.toString());
        return (Boolean) obj;
    }
}
