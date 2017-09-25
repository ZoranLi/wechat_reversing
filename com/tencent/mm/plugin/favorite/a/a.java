package com.tencent.mm.plugin.favorite.a;

public final class a extends com.tencent.mm.plugin.fts.a.a {
    protected final void tR() {
        if (tS()) {
            this.lYU.i(-106, 1);
        }
    }

    protected final boolean tS() {
        return !cb(-106, 1);
    }

    protected final String getTableName() {
        return "Favorite";
    }

    public final String getName() {
        return "FTS5FavoriteStorage";
    }

    public final int getType() {
        return 256;
    }

    public final int getPriority() {
        return 256;
    }
}
