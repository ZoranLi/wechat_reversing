package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.List;

public final class v {

    public static final class a {
        private final List<String> arj = new ArrayList();
        private final Object ark;

        public a(Object obj) {
            this.ark = w.Z(obj);
        }

        public final a h(String str, Object obj) {
            this.arj.add(((String) w.Z(str)) + "=" + String.valueOf(obj));
            return this;
        }

        public final String toString() {
            StringBuilder append = new StringBuilder(100).append(this.ark.getClass().getSimpleName()).append('{');
            int size = this.arj.size();
            for (int i = 0; i < size; i++) {
                append.append((String) this.arj.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }
    }

    public static a Y(Object obj) {
        return new a(obj);
    }

    public static boolean d(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
