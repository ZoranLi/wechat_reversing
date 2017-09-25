package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.c.s;
import com.google.android.gms.c.x;
import com.google.android.gms.c.y;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class FastJsonResponse {

    public static class Field<I, O> implements SafeParcelable {
        public static final a CREATOR = new a();
        protected final String arA;
        FieldMappingDictionary arB;
        public a<I, O> arC;
        protected final int art;
        protected final boolean aru;
        protected final int arv;
        protected final boolean arw;
        protected final String arx;
        protected final int ary;
        protected final Class<? extends FastJsonResponse> arz;
        final int mVersionCode;

        Field(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, ConverterWrapper converterWrapper) {
            a aVar = null;
            this.mVersionCode = i;
            this.art = i2;
            this.aru = z;
            this.arv = i3;
            this.arw = z2;
            this.arx = str;
            this.ary = i4;
            if (str2 == null) {
                this.arz = null;
                this.arA = null;
            } else {
                this.arz = SafeParcelResponse.class;
                this.arA = str2;
            }
            if (converterWrapper != null) {
                if (converterWrapper.arn != null) {
                    aVar = converterWrapper.arn;
                } else {
                    throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
                }
            }
            this.arC = aVar;
        }

        public int describeContents() {
            return 0;
        }

        public final int kk() {
            return this.art;
        }

        public final boolean kl() {
            return this.aru;
        }

        public final int km() {
            return this.arv;
        }

        public final boolean kn() {
            return this.arw;
        }

        public final String ko() {
            return this.arx;
        }

        public final int kp() {
            return this.ary;
        }

        public final Class<? extends FastJsonResponse> kq() {
            return this.arz;
        }

        final String kr() {
            return this.arA == null ? null : this.arA;
        }

        public final Map<String, Field<?, ?>> ks() {
            w.Z(this.arA);
            w.Z(this.arB);
            return this.arB.X(this.arA);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Field\n");
            stringBuilder.append("            versionCode=").append(this.mVersionCode).append('\n');
            stringBuilder.append("                 typeIn=").append(this.art).append('\n');
            stringBuilder.append("            typeInArray=").append(this.aru).append('\n');
            stringBuilder.append("                typeOut=").append(this.arv).append('\n');
            stringBuilder.append("           typeOutArray=").append(this.arw).append('\n');
            stringBuilder.append("        outputFieldName=").append(this.arx).append('\n');
            stringBuilder.append("      safeParcelFieldId=").append(this.ary).append('\n');
            stringBuilder.append("       concreteTypeName=").append(kr()).append('\n');
            if (this.arz != null) {
                stringBuilder.append("     concreteType.class=").append(this.arz.getCanonicalName()).append('\n');
            }
            stringBuilder.append("          converterName=").append(this.arC == null ? "null" : this.arC.getClass().getCanonicalName()).append('\n');
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            a.a(this, parcel, i);
        }
    }

    public interface a<I, O> {
        I convertBack(O o);
    }

    private Object a(Field field) {
        String ko = field.ko();
        if (field.kq() != null) {
            field.ko();
            w.a(ki() == null, "Concrete field shouldn't be value object: %s", new Object[]{field.ko()});
            field.kn();
            try {
                return getClass().getMethod("get" + Character.toUpperCase(ko.charAt(0)) + ko.substring(1), new Class[0]).invoke(this, new Object[0]);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        field.ko();
        return ki();
    }

    protected static <O, I> I a(Field<I, O> field, Object obj) {
        return field.arC != null ? field.arC.convertBack(obj) : obj;
    }

    private static void a(StringBuilder stringBuilder, Field field, Object obj) {
        if (field.kk() == 11) {
            stringBuilder.append(((FastJsonResponse) field.kq().cast(obj)).toString());
        } else if (field.kk() == 7) {
            stringBuilder.append("\"");
            stringBuilder.append(x.ag((String) obj));
            stringBuilder.append("\"");
        } else {
            stringBuilder.append(obj);
        }
    }

    private static void a(StringBuilder stringBuilder, Field field, ArrayList<Object> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                a(stringBuilder, field, obj);
            }
        }
        stringBuilder.append("]");
    }

    public abstract Map<String, Field<?, ?>> kh();

    protected abstract Object ki();

    protected abstract boolean kj();

    public String toString() {
        Map kh = kh();
        StringBuilder stringBuilder = new StringBuilder(100);
        for (String str : kh.keySet()) {
            Field field = (Field) kh.get(str);
            if (field.km() != 11) {
                field.ko();
                if (kj()) {
                    Object a = a(field, a(field));
                    if (stringBuilder.length() == 0) {
                        stringBuilder.append("{");
                    } else {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append("\"").append(str).append("\":");
                    if (a != null) {
                        switch (field.km()) {
                            case 8:
                                stringBuilder.append("\"").append(s.e((byte[]) a)).append("\"");
                                break;
                            case 9:
                                stringBuilder.append("\"").append(s.f((byte[]) a)).append("\"");
                                break;
                            case 10:
                                y.a(stringBuilder, (HashMap) a);
                                break;
                            default:
                                if (!field.kl()) {
                                    a(stringBuilder, field, a);
                                    break;
                                }
                                a(stringBuilder, field, (ArrayList) a);
                                break;
                        }
                    }
                    stringBuilder.append("null");
                }
            } else if (field.kn()) {
                field.ko();
                throw new UnsupportedOperationException("Concrete type arrays not supported");
            } else {
                field.ko();
                throw new UnsupportedOperationException("Concrete types not supported");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("}");
        } else {
            stringBuilder.append("{}");
        }
        return stringBuilder.toString();
    }
}
