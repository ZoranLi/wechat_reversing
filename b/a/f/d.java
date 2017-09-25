package b.a.f;

import java.util.Random;

public final class d implements c {
    private a xpU = new a();

    static class a {
        a() {
        }
    }

    public final String getNonce() {
        return String.valueOf(ciP().longValue() + ((long) Integer.valueOf(new Random().nextInt()).intValue()));
    }

    public final String ciO() {
        return String.valueOf(ciP());
    }

    private static Long ciP() {
        return Long.valueOf(Long.valueOf(System.currentTimeMillis()).longValue() / 1000);
    }
}
