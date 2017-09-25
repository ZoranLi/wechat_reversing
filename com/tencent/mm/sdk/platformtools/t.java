package com.tencent.mm.sdk.platformtools;

import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.nio.ByteBuffer;

public final class t {
    private ByteBuffer usF;
    private boolean usG;

    public final int bh(byte[] bArr) {
        boolean z = (bArr == null || bArr.length == 0) ? true : bArr[0] != (byte) 123 ? true : bArr[bArr.length + -1] != (byte) 125 ? true : false;
        if (z) {
            this.usF = null;
            return -1;
        }
        this.usF = ByteBuffer.wrap(bArr);
        this.usF.position(1);
        this.usG = false;
        return 0;
    }

    public final int getInt() {
        if (!this.usG) {
            return this.usF.getInt();
        }
        throw new Exception("Buffer For Build");
    }

    public final long getLong() {
        if (!this.usG) {
            return this.usF.getLong();
        }
        throw new Exception("Buffer For Build");
    }

    public final byte[] getBuffer() {
        if (this.usG) {
            throw new Exception("Buffer For Build");
        }
        short s = this.usF.getShort();
        if (s > (short) 2048) {
            this.usF = null;
            throw new Exception("Buffer String Length Error");
        } else if (s == (short) 0) {
            return new byte[0];
        } else {
            byte[] bArr = new byte[s];
            this.usF.get(bArr, 0, s);
            return bArr;
        }
    }

    public final String getString() {
        if (this.usG) {
            throw new Exception("Buffer For Build");
        }
        short s = this.usF.getShort();
        if (s > (short) 2048) {
            this.usF = null;
            throw new Exception("Buffer String Length Error");
        } else if (s == (short) 0) {
            return "";
        } else {
            byte[] bArr = new byte[s];
            this.usF.get(bArr, 0, s);
            return new String(bArr, "UTF-8");
        }
    }

    public final void yr(int i) {
        this.usF.position(this.usF.position() + i);
    }

    public final void bIF() {
        if (this.usG) {
            throw new Exception("Buffer For Build");
        }
        short s = this.usF.getShort();
        if (s > (short) 2048) {
            this.usF = null;
            throw new Exception("Buffer String Length Error");
        } else if (s != (short) 0) {
            this.usF.position(s + this.usF.position());
        }
    }

    public final boolean bIG() {
        return this.usF.limit() - this.usF.position() <= 1;
    }

    public final int bIH() {
        this.usF = ByteBuffer.allocate(Downloads.RECV_BUFFER_SIZE);
        this.usF.put((byte) 123);
        this.usG = true;
        return 0;
    }

    private int ys(int i) {
        if (this.usF.limit() - this.usF.position() <= i) {
            ByteBuffer allocate = ByteBuffer.allocate(this.usF.limit() + Downloads.RECV_BUFFER_SIZE);
            allocate.put(this.usF.array(), 0, this.usF.position());
            this.usF = allocate;
        }
        return 0;
    }

    public final int yt(int i) {
        if (this.usG) {
            ys(4);
            this.usF.putInt(i);
            return 0;
        }
        throw new Exception("Buffer For Parse");
    }

    public final int es(long j) {
        if (this.usG) {
            ys(8);
            this.usF.putLong(j);
            return 0;
        }
        throw new Exception("Buffer For Parse");
    }

    public final int bi(byte[] bArr) {
        if (this.usG) {
            byte[] bArr2 = null;
            if (bArr != null) {
                bArr2 = bArr;
            }
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            if (bArr2.length > 2048) {
                throw new Exception("Buffer String Length Error");
            }
            ys(bArr2.length + 2);
            this.usF.putShort((short) bArr2.length);
            if (bArr2.length > 0) {
                this.usF.put(bArr2);
            }
            return 0;
        }
        throw new Exception("Buffer For Parse");
    }

    public final int Pm(String str) {
        if (this.usG) {
            byte[] bArr = null;
            if (str != null) {
                bArr = str.getBytes();
            }
            if (bArr == null) {
                bArr = new byte[0];
            }
            if (bArr.length > 2048) {
                throw new Exception("Buffer String Length Error");
            }
            ys(bArr.length + 2);
            this.usF.putShort((short) bArr.length);
            if (bArr.length > 0) {
                this.usF.put(bArr);
            }
            return 0;
        }
        throw new Exception("Buffer For Parse");
    }

    public final byte[] bII() {
        if (this.usG) {
            ys(1);
            this.usF.put((byte) 125);
            Object obj = new byte[this.usF.position()];
            System.arraycopy(this.usF.array(), 0, obj, 0, obj.length);
            return obj;
        }
        throw new Exception("Buffer For Parse");
    }
}
