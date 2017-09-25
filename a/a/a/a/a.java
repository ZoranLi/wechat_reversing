package a.a.a.a;

import a.a.a.a.a.b;
import java.util.LinkedList;

public final class a {
    private final b unknownTagHandler;
    public final a.a.a.b.a.a xmD;
    public int xmE = 0;

    public a(byte[] bArr, b bVar) {
        this.xmD = new a.a.a.b.a.a(bArr, bArr.length);
        this.unknownTagHandler = bVar;
    }

    public final int chY() {
        return this.xmD.mL();
    }

    public final LinkedList<Integer> chZ() {
        a.a.a.b.a.a aVar = this.xmD;
        LinkedList<Integer> linkedList = new LinkedList();
        while (aVar.aIi < aVar.bufferSize) {
            linkedList.add(Integer.valueOf(aVar.mL()));
        }
        return linkedList;
    }

    public final String cia() {
        return this.xmD.readString();
    }

    public final boolean cib() {
        return this.xmD.mL() != 0;
    }

    public final com.tencent.mm.bd.b cic() {
        a.a.a.b.a.a aVar = this.xmD;
        int mL = aVar.mL();
        if (mL >= aVar.bufferSize - aVar.aIi || mL <= 0) {
            return com.tencent.mm.bd.b.aU(aVar.cD(mL));
        }
        com.tencent.mm.bd.b h = com.tencent.mm.bd.b.h(aVar.buffer, aVar.aIi, mL);
        aVar.aIi = mL + aVar.aIi;
        return h;
    }

    public final void cid() {
        int cK = a.a.a.b.a.cK(this.xmE);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FieldNumber: ").append(a.a.a.b.a.cL(this.xmE)).append(" - ");
        switch (cK) {
            case 0:
                stringBuffer.append("varint (long, int or boolean) value: ").append(this.xmD.mM());
                return;
            case 1:
                stringBuffer.append("double value: ").append(Double.toString(this.xmD.readDouble()));
                return;
            case 2:
                stringBuffer.append("Length delimited (String or ByteString) value: ").append(this.xmD.readString());
                return;
            case 5:
                stringBuffer.append("float value: ").append(Float.toString(this.xmD.readFloat()));
                return;
            default:
                return;
        }
    }

    public final LinkedList<byte[]> En(int i) {
        return this.xmD.En(i);
    }
}
