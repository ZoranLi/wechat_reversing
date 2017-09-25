package com.tencent.mm.o;

public final class a extends com.tencent.mm.plugin.fts.a.a {
    public final String getName() {
        return "FTS5FriendStorage";
    }

    public final int getType() {
        return 1280;
    }

    public final int getPriority() {
        return 1280;
    }

    protected final void tR() {
    }

    protected final String getTableName() {
        return "Friend";
    }

    protected final boolean tS() {
        return !cb(-107, 1);
    }
}
