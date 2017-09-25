package com.tencent.mm.plugin.chatroom.d;

import java.util.Calendar;

public final class a {
    private Calendar calendar;
    public long fGM;
    public int jXa;
    public long ksK;
    public int month;
    public int year;

    public a() {
        setTime(System.currentTimeMillis());
    }

    public a(int i, int i2, int i3) {
        this.year = i;
        this.month = i2;
        this.jXa = i3;
    }

    public a(long j) {
        this.ksK = j;
        setTime(j);
    }

    private void setTime(long j) {
        this.ksK = j;
        if (this.calendar == null) {
            this.calendar = Calendar.getInstance();
        }
        this.calendar.setTimeInMillis(j);
        this.month = this.calendar.get(2);
        this.year = this.calendar.get(1);
        this.jXa = this.calendar.get(5);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ year: ");
        stringBuilder.append(this.year);
        stringBuilder.append(", month: ");
        stringBuilder.append(this.month);
        stringBuilder.append(", day: ");
        stringBuilder.append(this.jXa);
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (aVar.jXa == this.jXa && aVar.month == this.month && aVar.year == this.year) {
            return true;
        }
        return false;
    }
}
