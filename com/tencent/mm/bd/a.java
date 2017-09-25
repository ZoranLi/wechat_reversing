package com.tencent.mm.bd;

import a.a.a.a.a.b;

public class a {
    protected static final int OPCODE_COMPUTESIZE = 1;
    protected static final int OPCODE_PARSEFROM = 2;
    protected static final int OPCODE_POPULATEBUILDERWITHFIELD = 3;
    protected static final int OPCODE_WRITEFIELDS = 0;
    public static b unknownTagHandler = new a.a.a.a.a.a();

    public byte[] toByteArray() {
        aUl();
        byte[] bArr = new byte[aUk()];
        a.a.a.c.a aVar = new a.a.a.c.a(bArr);
        a(aVar);
        if (aVar.hrI != null) {
            aVar.hrI.write(aVar.xmJ);
            aVar.hrI.flush();
        }
        return bArr;
    }

    public static int a(a.a.a.a.a aVar) {
        int i = 0;
        a.a.a.b.a.a aVar2 = aVar.xmD;
        if (aVar2.aIi != aVar2.bufferSize || aVar2.mn(false)) {
            aVar2.aIj = aVar2.mL();
            if (aVar2.aIj == 0) {
                throw a.a.a.b.a.b.cih();
            }
            i = aVar2.aIj;
        } else {
            aVar2.aIj = 0;
        }
        aVar.xmE = i;
        return a.a.a.b.a.cL(aVar.xmE);
    }

    public a aUl() {
        return this;
    }

    public int a(int i, Object... objArr) {
        throw new Error("Cannot use this method");
    }

    public void a(a.a.a.c.a aVar) {
        a(0, aVar);
    }

    public int aUk() {
        int i = 0;
        try {
            i = a(1, new Object[0]);
        } catch (Exception e) {
        }
        return i;
    }

    public a aD(byte[] bArr) {
        a(2, bArr);
        return this;
    }

    public boolean a(a.a.a.a.a aVar, a aVar2, int i) {
        return a(3, aVar, aVar2, Integer.valueOf(i)) == 0;
    }
}
