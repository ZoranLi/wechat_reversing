package com.google.android.gms.tagmanager;

final class ah extends Number implements Comparable<ah> {
    private double aFc;
    private long aFd = 0;
    boolean aFe = true;

    private ah(long j) {
    }

    private int a(ah ahVar) {
        return (this.aFe && ahVar.aFe) ? new Long(this.aFd).compareTo(Long.valueOf(ahVar.aFd)) : Double.compare(doubleValue(), ahVar.doubleValue());
    }

    public static ah mq() {
        return new ah(0);
    }

    public final byte byteValue() {
        return (byte) ((int) longValue());
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return a((ah) obj);
    }

    public final double doubleValue() {
        return this.aFe ? (double) this.aFd : this.aFc;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ah) && a((ah) obj) == 0;
    }

    public final float floatValue() {
        return (float) doubleValue();
    }

    public final int hashCode() {
        return new Long(longValue()).hashCode();
    }

    public final int intValue() {
        return (int) longValue();
    }

    public final long longValue() {
        return this.aFe ? this.aFd : (long) this.aFc;
    }

    public final short shortValue() {
        return (short) ((int) longValue());
    }

    public final String toString() {
        return this.aFe ? Long.toString(this.aFd) : Double.toString(this.aFc);
    }
}
