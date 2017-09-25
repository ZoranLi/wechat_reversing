package com.tencent.mm.sdk.e;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

final class b {
    private static final Map<Class<?>, Object> gMR = new HashMap();
    private static final Map<Class<?>, Object> gMS = new HashMap();
    private static final Map<Class<?>, String> uxa = new HashMap();

    static {
        try {
            gMR.put(byte[].class, new Object() {
            });
            gMR.put(Short.TYPE, new Object() {
            });
            gMR.put(Short.class, new Object() {
            });
            gMR.put(Boolean.TYPE, new Object() {
            });
            gMR.put(Boolean.class, new Object() {
            });
            gMR.put(Integer.TYPE, new Object() {
            });
            gMR.put(Integer.class, new Object() {
            });
            gMR.put(Float.TYPE, new Object() {
            });
            gMR.put(Float.class, new Object() {
            });
            gMR.put(Double.TYPE, new Object() {
            });
            gMR.put(Double.class, new Object() {
            });
            gMR.put(Long.TYPE, new Object() {
            });
            gMR.put(Long.class, new Object() {
            });
            gMR.put(String.class, new Object() {
            });
            gMS.put(byte[].class, new Object() {
            });
            gMS.put(Short.TYPE, new Object() {
            });
            gMS.put(Short.class, new Object() {
            });
            gMS.put(Boolean.TYPE, new Object() {
            });
            gMS.put(Boolean.class, new Object() {
            });
            gMS.put(Integer.TYPE, new Object() {
            });
            gMS.put(Integer.class, new Object() {
            });
            gMS.put(Float.TYPE, new Object() {
            });
            gMS.put(Float.class, new Object() {
            });
            gMS.put(Double.TYPE, new Object() {
            });
            gMS.put(Double.class, new Object() {
            });
            gMS.put(Long.TYPE, new Object() {
            });
            gMS.put(Long.class, new Object() {
            });
            gMS.put(String.class, new Object() {
            });
            uxa.put(byte[].class, "BLOB");
            uxa.put(Short.TYPE, "SHORT");
            uxa.put(Short.class, "SHORT");
            uxa.put(Boolean.TYPE, "INTEGER");
            uxa.put(Boolean.class, "INTEGER");
            uxa.put(Integer.TYPE, "INTEGER");
            uxa.put(Integer.class, "INTEGER");
            uxa.put(Float.TYPE, "FLOAT");
            uxa.put(Float.class, "FLOAT");
            uxa.put(Double.TYPE, "DOUBLE");
            uxa.put(Double.class, "DOUBLE");
            uxa.put(Long.TYPE, "LONG");
            uxa.put(Long.class, "LONG");
            uxa.put(String.class, "TEXT");
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static String t(Class<?> cls) {
        return (String) uxa.get(cls);
    }

    public static void keep_setBlob(Field field, Object obj, Cursor cursor, int i) {
        try {
            field.set(obj, cursor.getBlob(i));
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getBlob(Field field, Object obj, ContentValues contentValues) {
        try {
            contentValues.put(c.a(field), (byte[]) field.get(obj));
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_setShort(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Short.TYPE)) {
                field.setShort(obj, cursor.getShort(i));
            } else {
                field.set(obj, Short.valueOf(cursor.getShort(i)));
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getShort(Field field, Object obj, ContentValues contentValues) {
        try {
            contentValues.put(c.a(field), Short.valueOf(field.getShort(obj)));
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_setBoolean(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Boolean.TYPE)) {
                field.setBoolean(obj, cursor.getInt(i) != 0);
            } else {
                field.set(obj, Integer.valueOf(cursor.getInt(i)));
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getBoolean(Field field, Object obj, ContentValues contentValues) {
        try {
            contentValues.put(c.a(field), Integer.valueOf(field.getBoolean(obj) ? 1 : 0));
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_setInt(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Integer.TYPE)) {
                field.setInt(obj, cursor.getInt(i));
            } else {
                field.set(obj, Integer.valueOf(cursor.getInt(i)));
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getInt(Field field, Object obj, ContentValues contentValues) {
        try {
            if (field.getType().equals(Integer.TYPE)) {
                contentValues.put(c.a(field), Integer.valueOf(field.getInt(obj)));
            } else {
                contentValues.put(c.a(field), (Integer) field.get(obj));
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_setFloat(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Float.TYPE)) {
                field.setFloat(obj, cursor.getFloat(i));
            } else {
                field.set(obj, Float.valueOf(cursor.getFloat(i)));
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getFloat(Field field, Object obj, ContentValues contentValues) {
        try {
            if (field.getType().equals(Float.TYPE)) {
                contentValues.put(c.a(field), Float.valueOf(field.getFloat(obj)));
            } else {
                contentValues.put(c.a(field), (Float) field.get(obj));
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_setDouble(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Double.TYPE)) {
                field.setDouble(obj, cursor.getDouble(i));
            } else {
                field.set(obj, Double.valueOf(cursor.getDouble(i)));
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getDouble(Field field, Object obj, ContentValues contentValues) {
        try {
            if (field.getType().equals(Double.TYPE)) {
                contentValues.put(c.a(field), Double.valueOf(field.getDouble(obj)));
            } else {
                contentValues.put(c.a(field), (Double) field.get(obj));
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_setLong(Field field, Object obj, Cursor cursor, int i) {
        try {
            if (field.getType().equals(Long.TYPE)) {
                field.setLong(obj, cursor.getLong(i));
            } else {
                field.set(obj, Long.valueOf(cursor.getLong(i)));
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getLong(Field field, Object obj, ContentValues contentValues) {
        try {
            if (field.getType().equals(Long.TYPE)) {
                contentValues.put(c.a(field), Long.valueOf(field.getLong(obj)));
            } else {
                contentValues.put(c.a(field), (Long) field.get(obj));
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_setString(Field field, Object obj, Cursor cursor, int i) {
        try {
            field.set(obj, cursor.getString(i));
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }

    public static void keep_getString(Field field, Object obj, ContentValues contentValues) {
        try {
            contentValues.put(c.a(field), (String) field.get(obj));
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", e, "", new Object[0]);
        }
    }
}
