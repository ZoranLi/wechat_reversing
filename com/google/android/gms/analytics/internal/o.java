package com.google.android.gms.analytics.internal;

public abstract class o extends n {
    private boolean ain;
    private boolean aio;

    protected o(q qVar) {
        super(qVar);
    }

    protected abstract void hu();

    protected final void ie() {
        if (!isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void if() {
        hu();
        this.ain = true;
    }

    public final boolean isInitialized() {
        return this.ain && !this.aio;
    }
}
