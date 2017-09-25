package com.tencent.mm.plugin.appbrand.n.d;

import com.tencent.mm.plugin.appbrand.n.c.c;
import com.tencent.mm.plugin.appbrand.n.d.d.a;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import java.nio.ByteBuffer;

public final class b extends e implements a {
    static final ByteBuffer jpB = ByteBuffer.allocate(0);
    private int code;
    private String jpC;

    public b() {
        super(a.CLOSING);
        cj(true);
    }

    public b(int i, String str) {
        String str2;
        super(a.CLOSING);
        cj(true);
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        if (i == 1015) {
            str2 = "";
            i = MMBitmapFactory.ERROR_IO_FAILED;
        }
        if (i != MMBitmapFactory.ERROR_IO_FAILED) {
            byte[] re = com.tencent.mm.plugin.appbrand.n.f.b.re(str2);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.putInt(i);
            allocate.position(2);
            ByteBuffer allocate2 = ByteBuffer.allocate(re.length + 2);
            allocate2.put(allocate);
            allocate2.put(re);
            allocate2.rewind();
            l(allocate2);
        } else if (str2.length() > 0) {
            throw new com.tencent.mm.plugin.appbrand.n.c.b("A close frame must have a closecode if it has a reason");
        }
    }

    public final int XV() {
        return this.code;
    }

    public final String getMessage() {
        return this.jpC;
    }

    public final String toString() {
        return super.toString() + "code: " + this.code;
    }

    public final void l(ByteBuffer byteBuffer) {
        super.l(byteBuffer);
        this.code = MMBitmapFactory.ERROR_IO_FAILED;
        ByteBuffer XW = super.XW();
        XW.mark();
        if (XW.remaining() >= 2) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.position(2);
            allocate.putShort(XW.getShort());
            allocate.position(0);
            this.code = allocate.getInt();
            if (this.code == MMBitmapFactory.ERROR_UNSUPPORT_IMAGE_FORMAT || this.code == 1015 || this.code == MMBitmapFactory.ERROR_IO_FAILED || this.code > 4999 || this.code < 1000 || this.code == MMBitmapFactory.ERROR_BEGIN_SAMPLE_FAILED) {
                throw new c("closecode must not be sent over the wire: " + this.code);
            }
        }
        XW.reset();
        if (this.code == MMBitmapFactory.ERROR_IO_FAILED) {
            this.jpC = com.tencent.mm.plugin.appbrand.n.f.b.m(super.XW());
            return;
        }
        allocate = super.XW();
        int position = allocate.position();
        try {
            allocate.position(allocate.position() + 2);
            this.jpC = com.tencent.mm.plugin.appbrand.n.f.b.m(allocate);
            allocate.position(position);
        } catch (Throwable e) {
            throw new c(e);
        } catch (Throwable th) {
            allocate.position(position);
        }
    }

    public final ByteBuffer XW() {
        if (this.code == MMBitmapFactory.ERROR_IO_FAILED) {
            return jpB;
        }
        return super.XW();
    }
}
