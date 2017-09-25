package com.tencent.mm.plugin.game.b;

public final class a extends com.tencent.mm.plugin.fts.a.a {
    protected final void tR() {
        if (tS()) {
            i(-103, 1);
        }
    }

    protected final String getTableName() {
        return "Game";
    }

    public final String getName() {
        return "FTS5GameStorage";
    }

    public final int getType() {
        return 16;
    }

    public final int getPriority() {
        return 16;
    }

    protected final boolean tS() {
        return !cb(-103, 1);
    }
}
