package android.support.v4.app;

public final class j {
    final k<?> ph;

    j(k<?> kVar) {
        this.ph = kVar;
    }

    final Fragment i(String str) {
        return this.ph.pg.i(str);
    }

    public final void noteStateNotSaved() {
        this.ph.pg.qw = false;
    }

    public final boolean execPendingActions() {
        return this.ph.pg.execPendingActions();
    }
}
