package com.tencent.mm.plugin.chatroom.f;

public final class a {
    public static int bK(int i, int i2) {
        switch (i) {
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
                return 31;
            case 1:
                return ((i2 % 4 != 0 || i2 % 100 == 0) && i2 % 400 != 0) ? 28 : 29;
            case 3:
            case 5:
            case 8:
            case 10:
                return 30;
            default:
                throw new IllegalArgumentException("Invalid Month");
        }
    }
}
