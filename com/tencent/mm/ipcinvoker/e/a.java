package com.tencent.mm.ipcinvoker.e;

import com.tencent.mm.sdk.platformtools.w;
import java.lang.reflect.Field;

public final class a<FieldType> {
    private Class<?> gWr;
    private String gWs;
    private boolean gWt;
    private Field gWu;

    public a(Class<?> cls, String str) {
        if (str.length() == 0) {
            throw new IllegalArgumentException("Both of invoker and fieldName can not be null or nil.");
        }
        this.gWr = cls;
        this.gWs = str;
    }

    private synchronized void prepare() {
        if (!this.gWt) {
            Class cls = this.gWr;
            while (cls != null) {
                try {
                    Field declaredField = cls.getDeclaredField(this.gWs);
                    declaredField.setAccessible(true);
                    this.gWu = declaredField;
                    break;
                } catch (Exception e) {
                    cls = cls.getSuperclass();
                }
            }
            this.gWt = true;
        }
    }

    private synchronized FieldType uu() {
        FieldType fieldType = null;
        synchronized (this) {
            prepare();
            if (this.gWu == null) {
                w.w("SDK.ReflectStaticFieldSmith", "Field %s is no exists.", this.gWs);
            } else {
                try {
                    fieldType = this.gWu.get(null);
                } catch (ClassCastException e) {
                    throw new IllegalArgumentException("unable to cast object");
                }
            }
        }
        return fieldType;
    }

    public final synchronized FieldType uv() {
        FieldType fieldType;
        fieldType = null;
        try {
            fieldType = uu();
        } catch (NoSuchFieldException e) {
            w.i("SDK.ReflectStaticFieldSmith", "getWithoutThrow, exception occur :%s", e);
        } catch (IllegalAccessException e2) {
            w.i("SDK.ReflectStaticFieldSmith", "getWithoutThrow, exception occur :%s", e2);
        } catch (IllegalArgumentException e3) {
            w.i("SDK.ReflectStaticFieldSmith", "getWithoutThrow, exception occur :%s", e3);
        }
        return fieldType;
    }
}
