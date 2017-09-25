package com.tinkerboots.sdk.a.b;

public class a {
    public final com.tinkerboots.sdk.a.c.a xms;

    static class a {
        com.tinkerboots.sdk.a.c.a xms;

        a() {
        }
    }

    private a(com.tinkerboots.sdk.a.c.a aVar) {
        this.xms = aVar;
    }

    public static a chV() {
        a aVar = new a();
        aVar.xms = new com.tinkerboots.sdk.a.c.a();
        if (aVar.xms != null) {
            return new a(aVar.xms);
        }
        throw new RuntimeException("You need init conditions property");
    }
}
