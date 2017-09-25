package com.tencent.mm.av;

import com.tencent.mm.bj.g;
import com.tencent.mm.sdk.e.j;

public final class m extends j {
    public static final String[] gUx = new String[]{"CREATE TABLE IF NOT EXISTS verifycontact ( id INTEGER PRIMARY KEY, username varchar(40), nickname varchar(40), fullpy varchar(60), shortpy varchar(40), imgflag int, scene int, content text, status int, reserved1 int,reserved2 int,reserved3 text,reserved4 text)", "CREATE UNIQUE INDEX IF NOT EXISTS verifyContactIndex  ON verifycontact ( username )"};
    private g hnH;

    public m(g gVar) {
        this.hnH = gVar;
    }
}
