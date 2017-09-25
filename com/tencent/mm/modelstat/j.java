package com.tencent.mm.modelstat;

import android.database.Cursor;

public final class j {
    private static final String hWO;
    int fRW = -2;
    public int hWA = 0;
    public int hWB = 0;
    public int hWC = 0;
    public int hWD = 0;
    public int hWE = 0;
    public int hWF = 0;
    public int hWG = 0;
    public int hWH = 0;
    public int hWI = 0;
    public int hWJ = 0;
    public int hWK = 0;
    public int hWL = 0;
    public int hWM = 0;
    public int hWN = 0;
    public int hWl = 0;
    public int hWm = 0;
    public int hWn = 0;
    public int hWo = 0;
    public int hWp = 0;
    public int hWq = 0;
    public int hWr = 0;
    public int hWs = 0;
    public int hWt = 0;
    public int hWu = 0;
    public int hWv = 0;
    public int hWw = 0;
    public int hWx = 0;
    public int hWy = 0;
    public int hWz = 0;
    public int id = 0;

    public final void b(Cursor cursor) {
        this.id = cursor.getInt(0);
        this.hWl = cursor.getInt(1);
        this.hWm = cursor.getInt(2);
        this.hWn = cursor.getInt(3);
        this.hWo = cursor.getInt(4);
        this.hWp = cursor.getInt(5);
        this.hWq = cursor.getInt(6);
        this.hWr = cursor.getInt(7);
        this.hWs = cursor.getInt(8);
        this.hWt = cursor.getInt(9);
        this.hWu = cursor.getInt(10);
        this.hWv = cursor.getInt(11);
        this.hWw = cursor.getInt(12);
        this.hWx = cursor.getInt(13);
        this.hWy = cursor.getInt(14);
        this.hWz = cursor.getInt(15);
        this.hWA = cursor.getInt(16);
        this.hWB = cursor.getInt(17);
        this.hWC = cursor.getInt(18);
        this.hWD = cursor.getInt(19);
        this.hWE = cursor.getInt(20);
        this.hWF = cursor.getInt(21);
        this.hWG = cursor.getInt(22);
        this.hWH = cursor.getInt(23);
        this.hWI = cursor.getInt(24);
        this.hWJ = cursor.getInt(25);
        this.hWK = cursor.getInt(26);
        this.hWL = cursor.getInt(27);
        this.hWM = cursor.getInt(28);
        this.hWN = cursor.getInt(29);
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NetStatInfo:");
        stringBuilder.append("[mobile in=%dB/%dB/%dB, out=%dB/%dB/%dB]");
        stringBuilder.append("[wifi in=%dB/%dB/%dB, out=%dB/%dB/%dB]");
        stringBuilder.append("[text in=%d/%dB, out=%d/%dB]");
        stringBuilder.append("[image in=%d/%dB, out=%d/%dB]");
        stringBuilder.append("[voice in=%d/%dB, out=%d/%dB]");
        stringBuilder.append("[video in=%d/%dB, out=%d/%dB]");
        hWO = stringBuilder.toString();
    }

    public final String toString() {
        return String.format(hWO, new Object[]{Integer.valueOf(this.hWu), Integer.valueOf(this.hWK), Integer.valueOf(this.hWw), Integer.valueOf(this.hWG), Integer.valueOf(this.hWM), Integer.valueOf(this.hWI), Integer.valueOf(this.hWv), Integer.valueOf(this.hWL), Integer.valueOf(this.hWx), Integer.valueOf(this.hWH), Integer.valueOf(this.hWN), Integer.valueOf(this.hWJ), Integer.valueOf(this.hWm), Integer.valueOf(this.hWn), Integer.valueOf(this.hWy), Integer.valueOf(this.hWz), Integer.valueOf(this.hWo), Integer.valueOf(this.hWp), Integer.valueOf(this.hWA), Integer.valueOf(this.hWB), Integer.valueOf(this.hWq), Integer.valueOf(this.hWr), Integer.valueOf(this.hWC), Integer.valueOf(this.hWD), Integer.valueOf(this.hWs), Integer.valueOf(this.hWt), Integer.valueOf(this.hWE), Integer.valueOf(this.hWF)});
    }
}
