package com.tencent.pb.common.b.a;

import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.cf;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.wcdb.FileUtils;
import java.util.Arrays;

public interface a {

    public static final class a extends com.google.a.a.e {
        public String groupId;
        public int rhn;
        public long rho;
        public int[] wLD;
        public int wLE;
        public String[] wLF;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                int b;
                Object obj;
                switch (mK) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.rhn = aVar.mL();
                        continue;
                    case 24:
                        this.rho = aVar.mM();
                        continue;
                    case 32:
                        b = com.google.a.a.g.b(aVar, 32);
                        mK = this.wLD == null ? 0 : this.wLD.length;
                        obj = new int[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wLD, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = aVar.mL();
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = aVar.mL();
                        this.wLD = obj;
                        continue;
                    case 34:
                        int cA = aVar.cA(aVar.mL());
                        b = aVar.getPosition();
                        mK = 0;
                        while (aVar.mO() > 0) {
                            aVar.mL();
                            mK++;
                        }
                        aVar.cC(b);
                        b = this.wLD == null ? 0 : this.wLD.length;
                        Object obj2 = new int[(mK + b)];
                        if (b != 0) {
                            System.arraycopy(this.wLD, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = aVar.mL();
                            b++;
                        }
                        this.wLD = obj2;
                        aVar.cB(cA);
                        continue;
                    case 40:
                        this.wLE = aVar.mL();
                        continue;
                    case 802:
                        b = com.google.a.a.g.b(aVar, 802);
                        mK = this.wLF == null ? 0 : this.wLF.length;
                        obj = new String[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wLF, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = aVar.readString();
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = aVar.readString();
                        this.wLF = obj;
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public a() {
            this.groupId = "";
            this.rhn = 0;
            this.rho = 0;
            this.wLD = com.google.a.a.g.aIr;
            this.wLE = 0;
            this.wLF = com.google.a.a.g.EMPTY_STRING_ARRAY;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.rhn != 0) {
                bVar.ap(2, this.rhn);
            }
            if (this.rho != 0) {
                bVar.g(3, this.rho);
            }
            if (this.wLD != null && this.wLD.length > 0) {
                for (int aq : this.wLD) {
                    bVar.aq(4, aq);
                }
            }
            if (this.wLE != 0) {
                bVar.ap(5, this.wLE);
            }
            if (this.wLF != null && this.wLF.length > 0) {
                while (i < this.wLF.length) {
                    String str = this.wLF[i];
                    if (str != null) {
                        bVar.e(100, str);
                    }
                    i++;
                }
            }
            super.a(bVar);
        }

        protected final int mY() {
            int i;
            int i2;
            int i3 = 0;
            int mY = super.mY();
            if (!this.groupId.equals("")) {
                mY += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.rhn != 0) {
                mY += com.google.a.a.b.ar(2, this.rhn);
            }
            if (this.rho != 0) {
                mY += com.google.a.a.b.i(3, this.rho);
            }
            if (this.wLD != null && this.wLD.length > 0) {
                i = 0;
                for (int cJ : this.wLD) {
                    i += com.google.a.a.b.cJ(cJ);
                }
                mY = (mY + i) + (this.wLD.length * 1);
            }
            if (this.wLE != 0) {
                mY += com.google.a.a.b.ar(5, this.wLE);
            }
            if (this.wLF == null || this.wLF.length <= 0) {
                return mY;
            }
            i2 = 0;
            i = 0;
            while (i3 < this.wLF.length) {
                String str = this.wLF[i3];
                if (str != null) {
                    i++;
                    i2 += com.google.a.a.b.au(str);
                }
                i3++;
            }
            return (mY + i2) + (i * 2);
        }
    }

    public static final class aa extends com.google.a.a.e {
        public String groupId;
        public aq wLI;
        public int wNh;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 18:
                        if (this.wLI == null) {
                            this.wLI = new aq();
                        }
                        aVar.a(this.wLI);
                        continue;
                    case 24:
                        this.wNh = aVar.mL();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public aa() {
            this.groupId = "";
            this.wLI = null;
            this.wNh = 0;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.wLI != null) {
                bVar.a(2, this.wLI);
            }
            if (this.wNh != 0) {
                bVar.ap(3, this.wNh);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (!this.groupId.equals("")) {
                mY += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.wLI != null) {
                mY += com.google.a.a.b.b(2, this.wLI);
            }
            if (this.wNh != 0) {
                return mY + com.google.a.a.b.ar(3, this.wNh);
            }
            return mY;
        }
    }

    public static final class ab extends com.google.a.a.e {
        public String groupId;
        public int rhn;
        public long rho;
        public String wLG;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.rhn = aVar.mL();
                        continue;
                    case 24:
                        this.rho = aVar.mM();
                        continue;
                    case 34:
                        this.wLG = aVar.readString();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public ab() {
            this.groupId = "";
            this.rhn = 0;
            this.rho = 0;
            this.wLG = "";
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.rhn != 0) {
                bVar.ap(2, this.rhn);
            }
            if (this.rho != 0) {
                bVar.g(3, this.rho);
            }
            if (!this.wLG.equals("")) {
                bVar.e(4, this.wLG);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (!this.groupId.equals("")) {
                mY += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.rhn != 0) {
                mY += com.google.a.a.b.ar(2, this.rhn);
            }
            if (this.rho != 0) {
                mY += com.google.a.a.b.i(3, this.rho);
            }
            if (this.wLG.equals("")) {
                return mY;
            }
            return mY + com.google.a.a.b.f(4, this.wLG);
        }
    }

    public static final class ac extends com.google.a.a.e {
        public int wNi;

        public ac() {
            this.wNi = 0;
            this.aIq = -1;
        }

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 8:
                        this.wNi = aVar.mL();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.wNi != 0) {
                bVar.aq(1, this.wNi);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            return this.wNi != 0 ? mY + com.google.a.a.b.as(1, this.wNi) : mY;
        }
    }

    public static final class ad extends com.google.a.a.e {
        public String groupId;
        public int rhn;
        public long rho;
        public aq wLI;
        public as[] wMX;
        public n[] wMY;
        public at[] wMZ;
        public ap wMn;
        public as[] wMr;
        public int wNa;
        public int[] wNb;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                int b;
                Object obj;
                switch (mK) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.rhn = aVar.mL();
                        continue;
                    case 24:
                        this.rho = aVar.mM();
                        continue;
                    case 34:
                        b = com.google.a.a.g.b(aVar, 34);
                        mK = this.wMY == null ? 0 : this.wMY.length;
                        obj = new n[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wMY, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new n();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new n();
                        aVar.a(obj[mK]);
                        this.wMY = obj;
                        continue;
                    case 42:
                        if (this.wMn == null) {
                            this.wMn = new ap();
                        }
                        aVar.a(this.wMn);
                        continue;
                    case 48:
                        this.wNa = aVar.mL();
                        continue;
                    case FileUtils.S_IRWXG /*56*/:
                        b = com.google.a.a.g.b(aVar, 56);
                        mK = this.wNb == null ? 0 : this.wNb.length;
                        obj = new int[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wNb, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = aVar.mL();
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = aVar.mL();
                        this.wNb = obj;
                        continue;
                    case com.tencent.mm.plugin.appbrand.jsapi.m.CTRL_INDEX /*58*/:
                        int cA = aVar.cA(aVar.mL());
                        b = aVar.getPosition();
                        mK = 0;
                        while (aVar.mO() > 0) {
                            aVar.mL();
                            mK++;
                        }
                        aVar.cC(b);
                        b = this.wNb == null ? 0 : this.wNb.length;
                        Object obj2 = new int[(mK + b)];
                        if (b != 0) {
                            System.arraycopy(this.wNb, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = aVar.mL();
                            b++;
                        }
                        this.wNb = obj2;
                        aVar.cB(cA);
                        continue;
                    case 1602:
                        b = com.google.a.a.g.b(aVar, 1602);
                        mK = this.wMX == null ? 0 : this.wMX.length;
                        obj = new as[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wMX, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new as();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new as();
                        aVar.a(obj[mK]);
                        this.wMX = obj;
                        continue;
                    case 1610:
                        b = com.google.a.a.g.b(aVar, 1610);
                        mK = this.wMZ == null ? 0 : this.wMZ.length;
                        obj = new at[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wMZ, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new at();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new at();
                        aVar.a(obj[mK]);
                        this.wMZ = obj;
                        continue;
                    case 1618:
                        if (this.wLI == null) {
                            this.wLI = new aq();
                        }
                        aVar.a(this.wLI);
                        continue;
                    case 1626:
                        b = com.google.a.a.g.b(aVar, 1626);
                        mK = this.wMr == null ? 0 : this.wMr.length;
                        obj = new as[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wMr, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new as();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new as();
                        aVar.a(obj[mK]);
                        this.wMr = obj;
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public ad() {
            this.groupId = "";
            this.rhn = 0;
            this.rho = 0;
            this.wMY = n.ccW();
            this.wMn = null;
            this.wNa = 0;
            this.wNb = com.google.a.a.g.aIr;
            this.wMX = as.cdc();
            this.wMZ = at.cdd();
            this.wLI = null;
            this.wMr = as.cdc();
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.rhn != 0) {
                bVar.ap(2, this.rhn);
            }
            if (this.rho != 0) {
                bVar.g(3, this.rho);
            }
            if (this.wMY != null && this.wMY.length > 0) {
                for (com.google.a.a.e eVar : this.wMY) {
                    if (eVar != null) {
                        bVar.a(4, eVar);
                    }
                }
            }
            if (this.wMn != null) {
                bVar.a(5, this.wMn);
            }
            if (this.wNa != 0) {
                bVar.ap(6, this.wNa);
            }
            if (this.wNb != null && this.wNb.length > 0) {
                for (int ap : this.wNb) {
                    bVar.ap(7, ap);
                }
            }
            if (this.wMX != null && this.wMX.length > 0) {
                for (com.google.a.a.e eVar2 : this.wMX) {
                    if (eVar2 != null) {
                        bVar.a((int) com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX, eVar2);
                    }
                }
            }
            if (this.wMZ != null && this.wMZ.length > 0) {
                for (com.google.a.a.e eVar22 : this.wMZ) {
                    if (eVar22 != null) {
                        bVar.a((int) bh.CTRL_INDEX, eVar22);
                    }
                }
            }
            if (this.wLI != null) {
                bVar.a((int) com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX, this.wLI);
            }
            if (this.wMr != null && this.wMr.length > 0) {
                while (i < this.wMr.length) {
                    com.google.a.a.e eVar3 = this.wMr[i];
                    if (eVar3 != null) {
                        bVar.a((int) com.tencent.mm.plugin.appbrand.jsapi.aq.CTRL_INDEX, eVar3);
                    }
                    i++;
                }
            }
            super.a(bVar);
        }

        protected final int mY() {
            int i;
            int i2 = 0;
            int mY = super.mY();
            if (!this.groupId.equals("")) {
                mY += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.rhn != 0) {
                mY += com.google.a.a.b.ar(2, this.rhn);
            }
            if (this.rho != 0) {
                mY += com.google.a.a.b.i(3, this.rho);
            }
            if (this.wMY != null && this.wMY.length > 0) {
                i = mY;
                for (com.google.a.a.e eVar : this.wMY) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(4, eVar);
                    }
                }
                mY = i;
            }
            if (this.wMn != null) {
                mY += com.google.a.a.b.b(5, this.wMn);
            }
            if (this.wNa != 0) {
                mY += com.google.a.a.b.ar(6, this.wNa);
            }
            if (this.wNb != null && this.wNb.length > 0) {
                int i3 = 0;
                for (int cF : this.wNb) {
                    i3 += com.google.a.a.b.cF(cF);
                }
                mY = (mY + i3) + (this.wNb.length * 1);
            }
            if (this.wMX != null && this.wMX.length > 0) {
                i = mY;
                for (com.google.a.a.e eVar2 : this.wMX) {
                    if (eVar2 != null) {
                        i += com.google.a.a.b.b((int) com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX, eVar2);
                    }
                }
                mY = i;
            }
            if (this.wMZ != null && this.wMZ.length > 0) {
                i = mY;
                for (com.google.a.a.e eVar22 : this.wMZ) {
                    if (eVar22 != null) {
                        i += com.google.a.a.b.b((int) bh.CTRL_INDEX, eVar22);
                    }
                }
                mY = i;
            }
            if (this.wLI != null) {
                mY += com.google.a.a.b.b((int) com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX, this.wLI);
            }
            if (this.wMr != null && this.wMr.length > 0) {
                while (i2 < this.wMr.length) {
                    com.google.a.a.e eVar3 = this.wMr[i2];
                    if (eVar3 != null) {
                        mY += com.google.a.a.b.b((int) com.tencent.mm.plugin.appbrand.jsapi.aq.CTRL_INDEX, eVar3);
                    }
                    i2++;
                }
            }
            return mY;
        }
    }

    public static final class ae extends com.google.a.a.e {
        public ar[] wNj;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 10:
                        int b = com.google.a.a.g.b(aVar, 10);
                        mK = this.wNj == null ? 0 : this.wNj.length;
                        Object obj = new ar[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wNj, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new ar();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new ar();
                        aVar.a(obj[mK]);
                        this.wNj = obj;
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public ae() {
            this.wNj = ar.cdb();
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.wNj != null && this.wNj.length > 0) {
                for (com.google.a.a.e eVar : this.wNj) {
                    if (eVar != null) {
                        bVar.a(1, eVar);
                    }
                }
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (this.wNj != null && this.wNj.length > 0) {
                for (com.google.a.a.e eVar : this.wNj) {
                    if (eVar != null) {
                        mY += com.google.a.a.b.b(1, eVar);
                    }
                }
            }
            return mY;
        }
    }

    public static final class af extends com.google.a.a.e {
        public int ret;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 8:
                        this.ret = aVar.mL();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public af() {
            this.ret = 0;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.ret != 0) {
                bVar.ap(1, this.ret);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (this.ret != 0) {
                return mY + com.google.a.a.b.ar(1, this.ret);
            }
            return mY;
        }
    }

    public static final class ag extends com.google.a.a.e {
        public String groupId;
        public int rhn;
        public long rho;
        public aq wLI;
        public as[] wMX;
        public n[] wMY;
        public at[] wMZ;
        public ap wMn;
        public as[] wMr;
        public int wNa;
        public int[] wNb;
        public n[] wNc;
        public n[] wNf;
        public int wNg;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                int b;
                Object obj;
                switch (mK) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.rhn = aVar.mL();
                        continue;
                    case 24:
                        this.rho = aVar.mM();
                        continue;
                    case 34:
                        b = com.google.a.a.g.b(aVar, 34);
                        mK = this.wMY == null ? 0 : this.wMY.length;
                        obj = new n[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wMY, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new n();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new n();
                        aVar.a(obj[mK]);
                        this.wMY = obj;
                        continue;
                    case 42:
                        b = com.google.a.a.g.b(aVar, 42);
                        mK = this.wMX == null ? 0 : this.wMX.length;
                        obj = new as[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wMX, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new as();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new as();
                        aVar.a(obj[mK]);
                        this.wMX = obj;
                        continue;
                    case 50:
                        if (this.wMn == null) {
                            this.wMn = new ap();
                        }
                        aVar.a(this.wMn);
                        continue;
                    case FileUtils.S_IRWXG /*56*/:
                        this.wNa = aVar.mL();
                        continue;
                    case 64:
                        b = com.google.a.a.g.b(aVar, 64);
                        mK = this.wNb == null ? 0 : this.wNb.length;
                        obj = new int[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wNb, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = aVar.mL();
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = aVar.mL();
                        this.wNb = obj;
                        continue;
                    case 66:
                        int cA = aVar.cA(aVar.mL());
                        b = aVar.getPosition();
                        mK = 0;
                        while (aVar.mO() > 0) {
                            aVar.mL();
                            mK++;
                        }
                        aVar.cC(b);
                        b = this.wNb == null ? 0 : this.wNb.length;
                        Object obj2 = new int[(mK + b)];
                        if (b != 0) {
                            System.arraycopy(this.wNb, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = aVar.mL();
                            b++;
                        }
                        this.wNb = obj2;
                        aVar.cB(cA);
                        continue;
                    case 74:
                        b = com.google.a.a.g.b(aVar, 74);
                        mK = this.wMZ == null ? 0 : this.wMZ.length;
                        obj = new at[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wMZ, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new at();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new at();
                        aVar.a(obj[mK]);
                        this.wMZ = obj;
                        continue;
                    case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*82*/:
                        if (this.wLI == null) {
                            this.wLI = new aq();
                        }
                        aVar.a(this.wLI);
                        continue;
                    case PlayerException.EXCEPTION_IN_SETDATASOURCE /*90*/:
                        b = com.google.a.a.g.b(aVar, 90);
                        mK = this.wNc == null ? 0 : this.wNc.length;
                        obj = new n[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wNc, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new n();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new n();
                        aVar.a(obj[mK]);
                        this.wNc = obj;
                        continue;
                    case 98:
                        b = com.google.a.a.g.b(aVar, 98);
                        mK = this.wMr == null ? 0 : this.wMr.length;
                        obj = new as[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wMr, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new as();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new as();
                        aVar.a(obj[mK]);
                        this.wMr = obj;
                        continue;
                    case MMGIFException.D_GIF_ERR_NO_COLOR_MAP /*106*/:
                        b = com.google.a.a.g.b(aVar, MMGIFException.D_GIF_ERR_NO_COLOR_MAP);
                        mK = this.wNf == null ? 0 : this.wNf.length;
                        obj = new n[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wNf, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new n();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new n();
                        aVar.a(obj[mK]);
                        this.wNf = obj;
                        continue;
                    case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
                        this.wNg = aVar.mL();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public ag() {
            this.groupId = "";
            this.rhn = 0;
            this.rho = 0;
            this.wMY = n.ccW();
            this.wMX = as.cdc();
            this.wMn = null;
            this.wNa = 0;
            this.wNb = com.google.a.a.g.aIr;
            this.wMZ = at.cdd();
            this.wLI = null;
            this.wNc = n.ccW();
            this.wMr = as.cdc();
            this.wNf = n.ccW();
            this.wNg = 0;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.rhn != 0) {
                bVar.ap(2, this.rhn);
            }
            if (this.rho != 0) {
                bVar.g(3, this.rho);
            }
            if (this.wMY != null && this.wMY.length > 0) {
                for (com.google.a.a.e eVar : this.wMY) {
                    if (eVar != null) {
                        bVar.a(4, eVar);
                    }
                }
            }
            if (this.wMX != null && this.wMX.length > 0) {
                for (com.google.a.a.e eVar2 : this.wMX) {
                    if (eVar2 != null) {
                        bVar.a(5, eVar2);
                    }
                }
            }
            if (this.wMn != null) {
                bVar.a(6, this.wMn);
            }
            if (this.wNa != 0) {
                bVar.ap(7, this.wNa);
            }
            if (this.wNb != null && this.wNb.length > 0) {
                for (int ap : this.wNb) {
                    bVar.ap(8, ap);
                }
            }
            if (this.wMZ != null && this.wMZ.length > 0) {
                for (com.google.a.a.e eVar22 : this.wMZ) {
                    if (eVar22 != null) {
                        bVar.a(9, eVar22);
                    }
                }
            }
            if (this.wLI != null) {
                bVar.a(10, this.wLI);
            }
            if (this.wNc != null && this.wNc.length > 0) {
                for (com.google.a.a.e eVar222 : this.wNc) {
                    if (eVar222 != null) {
                        bVar.a(11, eVar222);
                    }
                }
            }
            if (this.wMr != null && this.wMr.length > 0) {
                for (com.google.a.a.e eVar2222 : this.wMr) {
                    if (eVar2222 != null) {
                        bVar.a(12, eVar2222);
                    }
                }
            }
            if (this.wNf != null && this.wNf.length > 0) {
                while (i < this.wNf.length) {
                    com.google.a.a.e eVar3 = this.wNf[i];
                    if (eVar3 != null) {
                        bVar.a(13, eVar3);
                    }
                    i++;
                }
            }
            if (this.wNg != 0) {
                bVar.ap(14, this.wNg);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int i;
            int i2 = 0;
            int mY = super.mY();
            if (!this.groupId.equals("")) {
                mY += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.rhn != 0) {
                mY += com.google.a.a.b.ar(2, this.rhn);
            }
            if (this.rho != 0) {
                mY += com.google.a.a.b.i(3, this.rho);
            }
            if (this.wMY != null && this.wMY.length > 0) {
                i = mY;
                for (com.google.a.a.e eVar : this.wMY) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(4, eVar);
                    }
                }
                mY = i;
            }
            if (this.wMX != null && this.wMX.length > 0) {
                i = mY;
                for (com.google.a.a.e eVar2 : this.wMX) {
                    if (eVar2 != null) {
                        i += com.google.a.a.b.b(5, eVar2);
                    }
                }
                mY = i;
            }
            if (this.wMn != null) {
                mY += com.google.a.a.b.b(6, this.wMn);
            }
            if (this.wNa != 0) {
                mY += com.google.a.a.b.ar(7, this.wNa);
            }
            if (this.wNb != null && this.wNb.length > 0) {
                int i3 = 0;
                for (int cF : this.wNb) {
                    i3 += com.google.a.a.b.cF(cF);
                }
                mY = (mY + i3) + (this.wNb.length * 1);
            }
            if (this.wMZ != null && this.wMZ.length > 0) {
                i = mY;
                for (com.google.a.a.e eVar22 : this.wMZ) {
                    if (eVar22 != null) {
                        i += com.google.a.a.b.b(9, eVar22);
                    }
                }
                mY = i;
            }
            if (this.wLI != null) {
                mY += com.google.a.a.b.b(10, this.wLI);
            }
            if (this.wNc != null && this.wNc.length > 0) {
                i = mY;
                for (com.google.a.a.e eVar222 : this.wNc) {
                    if (eVar222 != null) {
                        i += com.google.a.a.b.b(11, eVar222);
                    }
                }
                mY = i;
            }
            if (this.wMr != null && this.wMr.length > 0) {
                i = mY;
                for (com.google.a.a.e eVar2222 : this.wMr) {
                    if (eVar2222 != null) {
                        i += com.google.a.a.b.b(12, eVar2222);
                    }
                }
                mY = i;
            }
            if (this.wNf != null && this.wNf.length > 0) {
                while (i2 < this.wNf.length) {
                    com.google.a.a.e eVar3 = this.wNf[i2];
                    if (eVar3 != null) {
                        mY += com.google.a.a.b.b(13, eVar3);
                    }
                    i2++;
                }
            }
            if (this.wNg != 0) {
                return mY + com.google.a.a.b.ar(14, this.wNg);
            }
            return mY;
        }
    }

    public static final class ah extends com.google.a.a.e {
        public String groupId;
        public int rhn;
        public long rho;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.rhn = aVar.mL();
                        continue;
                    case 24:
                        this.rho = aVar.mM();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public ah() {
            this.groupId = "";
            this.rhn = 0;
            this.rho = 0;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.rhn != 0) {
                bVar.ap(2, this.rhn);
            }
            if (this.rho != 0) {
                bVar.g(3, this.rho);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (!this.groupId.equals("")) {
                mY += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.rhn != 0) {
                mY += com.google.a.a.b.ar(2, this.rhn);
            }
            if (this.rho != 0) {
                return mY + com.google.a.a.b.i(3, this.rho);
            }
            return mY;
        }
    }

    public static final class ai extends com.google.a.a.e {
        public byte[] buffer;
        public int tZn;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 8:
                        this.tZn = aVar.mL();
                        continue;
                    case 18:
                        this.buffer = aVar.readBytes();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public ai() {
            this.tZn = 0;
            this.buffer = com.google.a.a.g.aIx;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            bVar.aq(1, this.tZn);
            if (!Arrays.equals(this.buffer, com.google.a.a.g.aIx)) {
                bVar.a(2, this.buffer);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY() + com.google.a.a.b.as(1, this.tZn);
            if (Arrays.equals(this.buffer, com.google.a.a.g.aIx)) {
                return mY;
            }
            return mY + com.google.a.a.b.b(2, this.buffer);
        }
    }

    public static final class aj extends com.google.a.a.e {
        private static volatile aj[] wNk;
        public int mOs;
        public int taQ;
        public String wNl;
        public int wNm;

        public aj() {
            this.mOs = 0;
            this.wNl = "";
            this.taQ = 0;
            this.wNm = 0;
            this.aIq = -1;
        }

        public static aj[] ccY() {
            if (wNk == null) {
                synchronized (com.google.a.a.c.aIp) {
                    if (wNk == null) {
                        wNk = new aj[0];
                    }
                }
            }
            return wNk;
        }

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 8:
                        this.mOs = aVar.mL();
                        continue;
                    case 18:
                        this.wNl = aVar.readString();
                        continue;
                    case 24:
                        this.taQ = aVar.mL();
                        continue;
                    case 32:
                        this.wNm = aVar.mL();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.mOs != 0) {
                bVar.aq(1, this.mOs);
            }
            if (!this.wNl.equals("")) {
                bVar.e(2, this.wNl);
            }
            if (this.taQ != 0) {
                bVar.aq(3, this.taQ);
            }
            if (this.wNm != 0) {
                bVar.aq(4, this.wNm);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (this.mOs != 0) {
                mY += com.google.a.a.b.as(1, this.mOs);
            }
            if (!this.wNl.equals("")) {
                mY += com.google.a.a.b.f(2, this.wNl);
            }
            if (this.taQ != 0) {
                mY += com.google.a.a.b.as(3, this.taQ);
            }
            return this.wNm != 0 ? mY + com.google.a.a.b.as(4, this.wNm) : mY;
        }
    }

    public static final class ak extends com.google.a.a.e {
        public int hTw;
        public long wNn;
        public int wNo;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 8:
                        this.wNn = aVar.mM();
                        continue;
                    case 16:
                        this.hTw = aVar.mL();
                        continue;
                    case 24:
                        this.wNo = aVar.mL();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public ak() {
            this.wNn = 0;
            this.hTw = 0;
            this.wNo = 0;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.wNn != 0) {
                bVar.f(1, this.wNn);
            }
            if (this.hTw != 0) {
                bVar.aq(2, this.hTw);
            }
            if (this.wNo != 0) {
                bVar.aq(3, this.wNo);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (this.wNn != 0) {
                mY += com.google.a.a.b.h(1, this.wNn);
            }
            if (this.hTw != 0) {
                mY += com.google.a.a.b.as(2, this.hTw);
            }
            if (this.wNo != 0) {
                return mY + com.google.a.a.b.as(3, this.wNo);
            }
            return mY;
        }
    }

    public static final class al extends com.google.a.a.e {
        private static volatile al[] wNp;
        public int gPE;
        public int mOs;
        public int wNi;
        public int wNq;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 8:
                        this.mOs = aVar.mL();
                        continue;
                    case 16:
                        this.wNq = aVar.mL();
                        continue;
                    case 24:
                        this.gPE = aVar.mL();
                        continue;
                    case 32:
                        this.wNi = aVar.mL();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static al[] ccZ() {
            if (wNp == null) {
                synchronized (com.google.a.a.c.aIp) {
                    if (wNp == null) {
                        wNp = new al[0];
                    }
                }
            }
            return wNp;
        }

        public al() {
            this.mOs = 0;
            this.wNq = 0;
            this.gPE = 0;
            this.wNi = 0;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.mOs != 0) {
                bVar.ap(1, this.mOs);
            }
            if (this.wNq != 0) {
                bVar.ap(2, this.wNq);
            }
            if (this.gPE != 0) {
                bVar.ap(3, this.gPE);
            }
            if (this.wNi != 0) {
                bVar.ap(4, this.wNi);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (this.mOs != 0) {
                mY += com.google.a.a.b.ar(1, this.mOs);
            }
            if (this.wNq != 0) {
                mY += com.google.a.a.b.ar(2, this.wNq);
            }
            if (this.gPE != 0) {
                mY += com.google.a.a.b.ar(3, this.gPE);
            }
            if (this.wNi != 0) {
                return mY + com.google.a.a.b.ar(4, this.wNi);
            }
            return mY;
        }
    }

    public static final class am extends com.google.a.a.e {
        public int wNr;
        public int wNs;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 8:
                        this.wNr = aVar.mL();
                        continue;
                    case 16:
                        this.wNs = aVar.mL();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public am() {
            this.wNr = 0;
            this.wNs = 0;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.wNr != 0) {
                bVar.ap(1, this.wNr);
            }
            if (this.wNs != 0) {
                bVar.ap(2, this.wNs);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (this.wNr != 0) {
                mY += com.google.a.a.b.ar(1, this.wNr);
            }
            if (this.wNs != 0) {
                return mY + com.google.a.a.b.ar(2, this.wNs);
            }
            return mY;
        }
    }

    public static final class an extends com.google.a.a.e {
        public int nXW;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 8:
                        this.nXW = aVar.mL();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public an() {
            this.nXW = 0;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.nXW != 0) {
                bVar.ap(1, this.nXW);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (this.nXW != 0) {
                return mY + com.google.a.a.b.ar(1, this.nXW);
            }
            return mY;
        }
    }

    public static final class ao extends com.google.a.a.e {
        private static volatile ao[] wNt;
        public int wNu;
        public int wNv;
        public byte[] wNw;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 8:
                        this.wNu = aVar.mL();
                        continue;
                    case 16:
                        this.wNv = aVar.mL();
                        continue;
                    case 26:
                        this.wNw = aVar.readBytes();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static ao[] cda() {
            if (wNt == null) {
                synchronized (com.google.a.a.c.aIp) {
                    if (wNt == null) {
                        wNt = new ao[0];
                    }
                }
            }
            return wNt;
        }

        public ao() {
            this.wNu = 0;
            this.wNv = 0;
            this.wNw = com.google.a.a.g.aIx;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.wNu != 0) {
                bVar.ap(1, this.wNu);
            }
            if (this.wNv != 0) {
                bVar.ap(2, this.wNv);
            }
            if (!Arrays.equals(this.wNw, com.google.a.a.g.aIx)) {
                bVar.a(3, this.wNw);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (this.wNu != 0) {
                mY += com.google.a.a.b.ar(1, this.wNu);
            }
            if (this.wNv != 0) {
                mY += com.google.a.a.b.ar(2, this.wNv);
            }
            if (Arrays.equals(this.wNw, com.google.a.a.g.aIx)) {
                return mY;
            }
            return mY + com.google.a.a.b.b(3, this.wNw);
        }
    }

    public static final class ap extends com.google.a.a.e {
        public int hzT;
        public int hzU;
        public int wNA;
        public int wNB;
        public int wNC;
        public int wND;
        public int wNE;
        public int wNF;
        public int wNG;
        public int wNx;
        public int wNy;
        public int wNz;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 8:
                        this.wNx = aVar.mL();
                        continue;
                    case 16:
                        this.hzT = aVar.mL();
                        continue;
                    case 24:
                        this.hzU = aVar.mL();
                        continue;
                    case 32:
                        this.wNy = aVar.mL();
                        continue;
                    case 40:
                        this.wNz = aVar.mL();
                        continue;
                    case 48:
                        this.wNA = aVar.mL();
                        continue;
                    case FileUtils.S_IRWXG /*56*/:
                        this.wNB = aVar.mL();
                        continue;
                    case 64:
                        this.wNC = aVar.mL();
                        continue;
                    case com.tencent.mm.plugin.appbrand.jsapi.q.CTRL_INDEX /*72*/:
                        this.wND = aVar.mL();
                        continue;
                    case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                        this.wNE = aVar.mL();
                        continue;
                    case 88:
                        this.wNF = aVar.mL();
                        continue;
                    case PlayerException.EXCEPTION_IN_SETAUDIOEFFECT /*96*/:
                        this.wNG = aVar.mL();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public ap() {
            this.wNx = 0;
            this.hzT = 0;
            this.hzU = 0;
            this.wNy = 0;
            this.wNz = 0;
            this.wNA = 0;
            this.wNB = 0;
            this.wNC = 0;
            this.wND = 0;
            this.wNE = 0;
            this.wNF = 0;
            this.wNG = 0;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.wNx != 0) {
                bVar.ap(1, this.wNx);
            }
            if (this.hzT != 0) {
                bVar.ap(2, this.hzT);
            }
            if (this.hzU != 0) {
                bVar.ap(3, this.hzU);
            }
            if (this.wNy != 0) {
                bVar.ap(4, this.wNy);
            }
            if (this.wNz != 0) {
                bVar.ap(5, this.wNz);
            }
            if (this.wNA != 0) {
                bVar.ap(6, this.wNA);
            }
            if (this.wNB != 0) {
                bVar.ap(7, this.wNB);
            }
            if (this.wNC != 0) {
                bVar.ap(8, this.wNC);
            }
            if (this.wND != 0) {
                bVar.ap(9, this.wND);
            }
            if (this.wNE != 0) {
                bVar.ap(10, this.wNE);
            }
            if (this.wNF != 0) {
                bVar.ap(11, this.wNF);
            }
            if (this.wNG != 0) {
                bVar.ap(12, this.wNG);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (this.wNx != 0) {
                mY += com.google.a.a.b.ar(1, this.wNx);
            }
            if (this.hzT != 0) {
                mY += com.google.a.a.b.ar(2, this.hzT);
            }
            if (this.hzU != 0) {
                mY += com.google.a.a.b.ar(3, this.hzU);
            }
            if (this.wNy != 0) {
                mY += com.google.a.a.b.ar(4, this.wNy);
            }
            if (this.wNz != 0) {
                mY += com.google.a.a.b.ar(5, this.wNz);
            }
            if (this.wNA != 0) {
                mY += com.google.a.a.b.ar(6, this.wNA);
            }
            if (this.wNB != 0) {
                mY += com.google.a.a.b.ar(7, this.wNB);
            }
            if (this.wNC != 0) {
                mY += com.google.a.a.b.ar(8, this.wNC);
            }
            if (this.wND != 0) {
                mY += com.google.a.a.b.ar(9, this.wND);
            }
            if (this.wNE != 0) {
                mY += com.google.a.a.b.ar(10, this.wNE);
            }
            if (this.wNF != 0) {
                mY += com.google.a.a.b.ar(11, this.wNF);
            }
            if (this.wNG != 0) {
                return mY + com.google.a.a.b.ar(12, this.wNG);
            }
            return mY;
        }
    }

    public static final class aq extends com.google.a.a.e {
        public byte[] aMs;
        public int fKw;
        public String name;
        public byte[] wNH;
        public long wNI;
        public byte[] wNJ;
        public byte[] wNK;
        public byte[] wNL;
        public au wNM;
        public byte[] wNN;
        public am wNO;
        public String wNP;
        public String wNQ;
        public long wNR;
        public byte[] wNS;
        public byte[] wNT;
        public byte[] wNU;
        public byte[] wNV;
        public int wNW;
        public byte[] wNX;
        public byte[] wNY;
        public int wNZ;
        public m[] wOa;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 10:
                        this.name = aVar.readString();
                        continue;
                    case 18:
                        this.wNH = aVar.readBytes();
                        continue;
                    case 24:
                        this.fKw = aVar.mL();
                        continue;
                    case 32:
                        this.wNI = aVar.mM();
                        continue;
                    case 42:
                        this.wNJ = aVar.readBytes();
                        continue;
                    case 50:
                        this.wNK = aVar.readBytes();
                        continue;
                    case com.tencent.mm.plugin.appbrand.jsapi.m.CTRL_INDEX /*58*/:
                        this.wNL = aVar.readBytes();
                        continue;
                    case 66:
                        if (this.wNM == null) {
                            this.wNM = new au();
                        }
                        aVar.a(this.wNM);
                        continue;
                    case 74:
                        this.wNN = aVar.readBytes();
                        continue;
                    case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*82*/:
                        if (this.wNO == null) {
                            this.wNO = new am();
                        }
                        aVar.a(this.wNO);
                        continue;
                    case 802:
                        this.wNP = aVar.readString();
                        continue;
                    case 810:
                        this.wNQ = aVar.readString();
                        continue;
                    case 1600:
                        this.wNR = aVar.mM();
                        continue;
                    case 1610:
                        this.wNS = aVar.readBytes();
                        continue;
                    case 1618:
                        this.wNT = aVar.readBytes();
                        continue;
                    case 1626:
                        this.wNU = aVar.readBytes();
                        continue;
                    case 1634:
                        this.wNV = aVar.readBytes();
                        continue;
                    case 1760:
                        this.wNW = aVar.mL();
                        continue;
                    case 1770:
                        this.wNX = aVar.readBytes();
                        continue;
                    case 1778:
                        this.wNY = aVar.readBytes();
                        continue;
                    case 1786:
                        this.aMs = aVar.readBytes();
                        continue;
                    case 1792:
                        this.wNZ = aVar.mL();
                        continue;
                    case 1802:
                        int b = com.google.a.a.g.b(aVar, 1802);
                        mK = this.wOa == null ? 0 : this.wOa.length;
                        Object obj = new m[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wOa, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new m();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new m();
                        aVar.a(obj[mK]);
                        this.wOa = obj;
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public aq() {
            this.name = "";
            this.wNH = com.google.a.a.g.aIx;
            this.fKw = 0;
            this.wNI = 0;
            this.wNJ = com.google.a.a.g.aIx;
            this.wNK = com.google.a.a.g.aIx;
            this.wNL = com.google.a.a.g.aIx;
            this.wNM = null;
            this.wNN = com.google.a.a.g.aIx;
            this.wNO = null;
            this.wNP = "";
            this.wNQ = "";
            this.wNR = 0;
            this.wNS = com.google.a.a.g.aIx;
            this.wNT = com.google.a.a.g.aIx;
            this.wNU = com.google.a.a.g.aIx;
            this.wNV = com.google.a.a.g.aIx;
            this.wNW = 0;
            this.wNX = com.google.a.a.g.aIx;
            this.wNY = com.google.a.a.g.aIx;
            this.aMs = com.google.a.a.g.aIx;
            this.wNZ = 0;
            this.wOa = m.ccV();
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.name.equals("")) {
                bVar.e(1, this.name);
            }
            if (!Arrays.equals(this.wNH, com.google.a.a.g.aIx)) {
                bVar.a(2, this.wNH);
            }
            if (this.fKw != 0) {
                bVar.ap(3, this.fKw);
            }
            if (this.wNI != 0) {
                bVar.f(4, this.wNI);
            }
            if (!Arrays.equals(this.wNJ, com.google.a.a.g.aIx)) {
                bVar.a(5, this.wNJ);
            }
            if (!Arrays.equals(this.wNK, com.google.a.a.g.aIx)) {
                bVar.a(6, this.wNK);
            }
            if (!Arrays.equals(this.wNL, com.google.a.a.g.aIx)) {
                bVar.a(7, this.wNL);
            }
            if (this.wNM != null) {
                bVar.a(8, this.wNM);
            }
            if (!Arrays.equals(this.wNN, com.google.a.a.g.aIx)) {
                bVar.a(9, this.wNN);
            }
            if (this.wNO != null) {
                bVar.a(10, this.wNO);
            }
            if (!this.wNP.equals("")) {
                bVar.e(100, this.wNP);
            }
            if (!this.wNQ.equals("")) {
                bVar.e(101, this.wNQ);
            }
            if (this.wNR != 0) {
                bVar.f((int) com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX, this.wNR);
            }
            if (!Arrays.equals(this.wNS, com.google.a.a.g.aIx)) {
                bVar.a((int) bh.CTRL_INDEX, this.wNS);
            }
            if (!Arrays.equals(this.wNT, com.google.a.a.g.aIx)) {
                bVar.a((int) com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX, this.wNT);
            }
            if (!Arrays.equals(this.wNU, com.google.a.a.g.aIx)) {
                bVar.a((int) com.tencent.mm.plugin.appbrand.jsapi.aq.CTRL_INDEX, this.wNU);
            }
            if (!Arrays.equals(this.wNV, com.google.a.a.g.aIx)) {
                bVar.a((int) com.tencent.mm.plugin.appbrand.jsapi.ao.CTRL_INDEX, this.wNV);
            }
            if (this.wNW != 0) {
                bVar.ap(220, this.wNW);
            }
            if (!Arrays.equals(this.wNX, com.google.a.a.g.aIx)) {
                bVar.a(221, this.wNX);
            }
            if (!Arrays.equals(this.wNY, com.google.a.a.g.aIx)) {
                bVar.a(222, this.wNY);
            }
            if (!Arrays.equals(this.aMs, com.google.a.a.g.aIx)) {
                bVar.a(223, this.aMs);
            }
            if (this.wNZ != 0) {
                bVar.aq(224, this.wNZ);
            }
            if (this.wOa != null && this.wOa.length > 0) {
                for (com.google.a.a.e eVar : this.wOa) {
                    if (eVar != null) {
                        bVar.a(225, eVar);
                    }
                }
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (!this.name.equals("")) {
                mY += com.google.a.a.b.f(1, this.name);
            }
            if (!Arrays.equals(this.wNH, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b(2, this.wNH);
            }
            if (this.fKw != 0) {
                mY += com.google.a.a.b.ar(3, this.fKw);
            }
            if (this.wNI != 0) {
                mY += com.google.a.a.b.h(4, this.wNI);
            }
            if (!Arrays.equals(this.wNJ, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b(5, this.wNJ);
            }
            if (!Arrays.equals(this.wNK, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b(6, this.wNK);
            }
            if (!Arrays.equals(this.wNL, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b(7, this.wNL);
            }
            if (this.wNM != null) {
                mY += com.google.a.a.b.b(8, this.wNM);
            }
            if (!Arrays.equals(this.wNN, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b(9, this.wNN);
            }
            if (this.wNO != null) {
                mY += com.google.a.a.b.b(10, this.wNO);
            }
            if (!this.wNP.equals("")) {
                mY += com.google.a.a.b.f(100, this.wNP);
            }
            if (!this.wNQ.equals("")) {
                mY += com.google.a.a.b.f(101, this.wNQ);
            }
            if (this.wNR != 0) {
                mY += com.google.a.a.b.h(com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX, this.wNR);
            }
            if (!Arrays.equals(this.wNS, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b((int) bh.CTRL_INDEX, this.wNS);
            }
            if (!Arrays.equals(this.wNT, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b((int) com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX, this.wNT);
            }
            if (!Arrays.equals(this.wNU, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b((int) com.tencent.mm.plugin.appbrand.jsapi.aq.CTRL_INDEX, this.wNU);
            }
            if (!Arrays.equals(this.wNV, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b((int) com.tencent.mm.plugin.appbrand.jsapi.ao.CTRL_INDEX, this.wNV);
            }
            if (this.wNW != 0) {
                mY += com.google.a.a.b.ar(220, this.wNW);
            }
            if (!Arrays.equals(this.wNX, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b(221, this.wNX);
            }
            if (!Arrays.equals(this.wNY, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b(222, this.wNY);
            }
            if (!Arrays.equals(this.aMs, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b(223, this.aMs);
            }
            if (this.wNZ != 0) {
                mY += com.google.a.a.b.as(224, this.wNZ);
            }
            if (this.wOa == null || this.wOa.length <= 0) {
                return mY;
            }
            int i = mY;
            for (com.google.a.a.e eVar : this.wOa) {
                if (eVar != null) {
                    i += com.google.a.a.b.b(225, eVar);
                }
            }
            return i;
        }
    }

    public static final class ar extends com.google.a.a.e {
        private static volatile ar[] wOb;
        public String groupId;
        public int rhn;
        public long rho;
        public int wLL;
        public as[] wMX;
        public String wOc;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.rhn = aVar.mL();
                        continue;
                    case 24:
                        this.rho = aVar.mM();
                        continue;
                    case 34:
                        int b = com.google.a.a.g.b(aVar, 34);
                        mK = this.wMX == null ? 0 : this.wMX.length;
                        Object obj = new as[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wMX, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new as();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new as();
                        aVar.a(obj[mK]);
                        this.wMX = obj;
                        continue;
                    case 40:
                        this.wLL = aVar.mL();
                        continue;
                    case 50:
                        this.wOc = aVar.readString();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static ar[] cdb() {
            if (wOb == null) {
                synchronized (com.google.a.a.c.aIp) {
                    if (wOb == null) {
                        wOb = new ar[0];
                    }
                }
            }
            return wOb;
        }

        public ar() {
            this.groupId = "";
            this.rhn = 0;
            this.rho = 0;
            this.wMX = as.cdc();
            this.wLL = 0;
            this.wOc = "";
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.rhn != 0) {
                bVar.ap(2, this.rhn);
            }
            if (this.rho != 0) {
                bVar.g(3, this.rho);
            }
            if (this.wMX != null && this.wMX.length > 0) {
                for (com.google.a.a.e eVar : this.wMX) {
                    if (eVar != null) {
                        bVar.a(4, eVar);
                    }
                }
            }
            if (this.wLL != 0) {
                bVar.aq(5, this.wLL);
            }
            if (!this.wOc.equals("")) {
                bVar.e(6, this.wOc);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (!this.groupId.equals("")) {
                mY += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.rhn != 0) {
                mY += com.google.a.a.b.ar(2, this.rhn);
            }
            if (this.rho != 0) {
                mY += com.google.a.a.b.i(3, this.rho);
            }
            if (this.wMX != null && this.wMX.length > 0) {
                int i = mY;
                for (com.google.a.a.e eVar : this.wMX) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(4, eVar);
                    }
                }
                mY = i;
            }
            if (this.wLL != 0) {
                mY += com.google.a.a.b.as(5, this.wLL);
            }
            if (this.wOc.equals("")) {
                return mY;
            }
            return mY + com.google.a.a.b.f(6, this.wOc);
        }
    }

    public static final class as extends com.google.a.a.e {
        private static volatile as[] wOd;
        public int fOl;
        public int mOs;
        public int rsa;
        public int status;
        public int taQ;
        public int wLR;
        public byte[] wLW;
        public String wNl;
        public int wOe;
        public int wOf;
        public an wOg;
        public int wOh;
        public String wOi;
        public ao[] wOj;
        public int wOk;
        public int[] wOl;
        public int wOm;
        public int wOn;
        public int wOo;
        public int wOp;
        public ak wOq;
        public String wOr;
        public int wOs;
        public q wOt;
        public int wOu;
        public String wOv;
        public int wOw;
        public int wOx;
        public int wOy;
        public int wOz;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                int b;
                Object obj;
                switch (mK) {
                    case 0:
                        break;
                    case 8:
                        this.taQ = aVar.mL();
                        continue;
                    case 16:
                        this.wOe = aVar.mL();
                        continue;
                    case 24:
                        this.status = aVar.mL();
                        continue;
                    case 32:
                        this.fOl = aVar.mL();
                        continue;
                    case 40:
                        this.mOs = aVar.mL();
                        continue;
                    case 48:
                        this.wOf = aVar.mL();
                        continue;
                    case com.tencent.mm.plugin.appbrand.jsapi.m.CTRL_INDEX /*58*/:
                        if (this.wOg == null) {
                            this.wOg = new an();
                        }
                        aVar.a(this.wOg);
                        continue;
                    case 64:
                        this.wOh = aVar.mL();
                        continue;
                    case 74:
                        this.wOi = aVar.readString();
                        continue;
                    case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*82*/:
                        b = com.google.a.a.g.b(aVar, 82);
                        mK = this.wOj == null ? 0 : this.wOj.length;
                        obj = new ao[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wOj, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new ao();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new ao();
                        aVar.a(obj[mK]);
                        this.wOj = obj;
                        continue;
                    case 88:
                        this.wOk = aVar.mL();
                        continue;
                    case PlayerException.EXCEPTION_IN_SETAUDIOEFFECT /*96*/:
                        b = com.google.a.a.g.b(aVar, 96);
                        mK = this.wOl == null ? 0 : this.wOl.length;
                        obj = new int[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wOl, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = aVar.mL();
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = aVar.mL();
                        this.wOl = obj;
                        continue;
                    case 98:
                        int cA = aVar.cA(aVar.mL());
                        b = aVar.getPosition();
                        mK = 0;
                        while (aVar.mO() > 0) {
                            aVar.mL();
                            mK++;
                        }
                        aVar.cC(b);
                        b = this.wOl == null ? 0 : this.wOl.length;
                        Object obj2 = new int[(mK + b)];
                        if (b != 0) {
                            System.arraycopy(this.wOl, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = aVar.mL();
                            b++;
                        }
                        this.wOl = obj2;
                        aVar.cB(cA);
                        continue;
                    case 104:
                        this.wOm = aVar.mL();
                        continue;
                    case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
                        this.wOn = aVar.mL();
                        continue;
                    case 120:
                        this.wOo = aVar.mL();
                        continue;
                    case FileUtils.S_IWUSR /*128*/:
                        this.wOp = aVar.mL();
                        continue;
                    case 138:
                        if (this.wOq == null) {
                            this.wOq = new ak();
                        }
                        aVar.a(this.wOq);
                        continue;
                    case 802:
                        this.wNl = aVar.readString();
                        continue;
                    case 810:
                        this.wOr = aVar.readString();
                        continue;
                    case 816:
                        this.wOs = aVar.mL();
                        continue;
                    case 1602:
                        this.wLW = aVar.readBytes();
                        continue;
                    case 1610:
                        if (this.wOt == null) {
                            this.wOt = new q();
                        }
                        aVar.a(this.wOt);
                        continue;
                    case 1616:
                        this.wOu = aVar.mL();
                        continue;
                    case 1626:
                        this.wOv = aVar.readString();
                        continue;
                    case 1632:
                        this.wOw = aVar.mL();
                        continue;
                    case 1640:
                        this.wOx = aVar.mL();
                        continue;
                    case 1648:
                        this.rsa = aVar.mL();
                        continue;
                    case 1656:
                        this.wOy = aVar.mL();
                        continue;
                    case 1664:
                        this.wOz = aVar.mL();
                        continue;
                    case 1920:
                        this.wLR = aVar.mL();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static as[] cdc() {
            if (wOd == null) {
                synchronized (com.google.a.a.c.aIp) {
                    if (wOd == null) {
                        wOd = new as[0];
                    }
                }
            }
            return wOd;
        }

        public as() {
            this.taQ = 0;
            this.wOe = 0;
            this.status = 0;
            this.fOl = 0;
            this.mOs = -1;
            this.wOf = 0;
            this.wOg = null;
            this.wOh = 0;
            this.wOi = "";
            this.wOj = ao.cda();
            this.wOk = 0;
            this.wOl = com.google.a.a.g.aIr;
            this.wOm = 0;
            this.wOn = 0;
            this.wOo = 0;
            this.wOp = 0;
            this.wOq = null;
            this.wNl = "";
            this.wOr = "";
            this.wOs = 0;
            this.wLW = com.google.a.a.g.aIx;
            this.wOt = null;
            this.wOu = -1;
            this.wOv = "";
            this.wOw = 0;
            this.wOx = 0;
            this.rsa = 0;
            this.wOy = 0;
            this.wOz = 0;
            this.wLR = 0;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (this.taQ != 0) {
                bVar.aq(1, this.taQ);
            }
            if (this.wOe != 0) {
                bVar.aq(2, this.wOe);
            }
            if (this.status != 0) {
                bVar.aq(3, this.status);
            }
            if (this.fOl != 0) {
                bVar.aq(4, this.fOl);
            }
            if (this.mOs != -1) {
                bVar.ap(5, this.mOs);
            }
            if (this.wOf != 0) {
                bVar.aq(6, this.wOf);
            }
            if (this.wOg != null) {
                bVar.a(7, this.wOg);
            }
            if (this.wOh != 0) {
                bVar.aq(8, this.wOh);
            }
            if (!this.wOi.equals("")) {
                bVar.e(9, this.wOi);
            }
            if (this.wOj != null && this.wOj.length > 0) {
                for (com.google.a.a.e eVar : this.wOj) {
                    if (eVar != null) {
                        bVar.a(10, eVar);
                    }
                }
            }
            if (this.wOk != 0) {
                bVar.aq(11, this.wOk);
            }
            if (this.wOl != null && this.wOl.length > 0) {
                while (i < this.wOl.length) {
                    bVar.aq(12, this.wOl[i]);
                    i++;
                }
            }
            if (this.wOm != 0) {
                bVar.aq(13, this.wOm);
            }
            if (this.wOn != 0) {
                bVar.aq(14, this.wOn);
            }
            if (this.wOo != 0) {
                bVar.aq(15, this.wOo);
            }
            if (this.wOp != 0) {
                bVar.aq(16, this.wOp);
            }
            if (this.wOq != null) {
                bVar.a(17, this.wOq);
            }
            if (!this.wNl.equals("")) {
                bVar.e(100, this.wNl);
            }
            if (!this.wOr.equals("")) {
                bVar.e(101, this.wOr);
            }
            if (this.wOs != 0) {
                bVar.aq(102, this.wOs);
            }
            if (!Arrays.equals(this.wLW, com.google.a.a.g.aIx)) {
                bVar.a((int) com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX, this.wLW);
            }
            if (this.wOt != null) {
                bVar.a((int) bh.CTRL_INDEX, this.wOt);
            }
            if (this.wOu != -1) {
                bVar.ap(com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX, this.wOu);
            }
            if (!this.wOv.equals("")) {
                bVar.e(com.tencent.mm.plugin.appbrand.jsapi.aq.CTRL_INDEX, this.wOv);
            }
            if (this.wOw != 0) {
                bVar.ap(com.tencent.mm.plugin.appbrand.jsapi.ao.CTRL_INDEX, this.wOw);
            }
            if (this.wOx != 0) {
                bVar.aq(cf.CTRL_INDEX, this.wOx);
            }
            if (this.rsa != 0) {
                bVar.aq(com.tencent.mm.plugin.appbrand.jsapi.v.CTRL_INDEX, this.rsa);
            }
            if (this.wOy != 0) {
                bVar.aq(207, this.wOy);
            }
            if (this.wOz != 0) {
                bVar.aq(bv.CTRL_INDEX, this.wOz);
            }
            if (this.wLR != 0) {
                bVar.aq(240, this.wLR);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int i;
            int i2 = 0;
            int mY = super.mY();
            if (this.taQ != 0) {
                mY += com.google.a.a.b.as(1, this.taQ);
            }
            if (this.wOe != 0) {
                mY += com.google.a.a.b.as(2, this.wOe);
            }
            if (this.status != 0) {
                mY += com.google.a.a.b.as(3, this.status);
            }
            if (this.fOl != 0) {
                mY += com.google.a.a.b.as(4, this.fOl);
            }
            if (this.mOs != -1) {
                mY += com.google.a.a.b.ar(5, this.mOs);
            }
            if (this.wOf != 0) {
                mY += com.google.a.a.b.as(6, this.wOf);
            }
            if (this.wOg != null) {
                mY += com.google.a.a.b.b(7, this.wOg);
            }
            if (this.wOh != 0) {
                mY += com.google.a.a.b.as(8, this.wOh);
            }
            if (!this.wOi.equals("")) {
                mY += com.google.a.a.b.f(9, this.wOi);
            }
            if (this.wOj != null && this.wOj.length > 0) {
                i = mY;
                for (com.google.a.a.e eVar : this.wOj) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(10, eVar);
                    }
                }
                mY = i;
            }
            if (this.wOk != 0) {
                mY += com.google.a.a.b.as(11, this.wOk);
            }
            if (this.wOl != null && this.wOl.length > 0) {
                i = 0;
                while (i2 < this.wOl.length) {
                    i += com.google.a.a.b.cJ(this.wOl[i2]);
                    i2++;
                }
                mY = (mY + i) + (this.wOl.length * 1);
            }
            if (this.wOm != 0) {
                mY += com.google.a.a.b.as(13, this.wOm);
            }
            if (this.wOn != 0) {
                mY += com.google.a.a.b.as(14, this.wOn);
            }
            if (this.wOo != 0) {
                mY += com.google.a.a.b.as(15, this.wOo);
            }
            if (this.wOp != 0) {
                mY += com.google.a.a.b.as(16, this.wOp);
            }
            if (this.wOq != null) {
                mY += com.google.a.a.b.b(17, this.wOq);
            }
            if (!this.wNl.equals("")) {
                mY += com.google.a.a.b.f(100, this.wNl);
            }
            if (!this.wOr.equals("")) {
                mY += com.google.a.a.b.f(101, this.wOr);
            }
            if (this.wOs != 0) {
                mY += com.google.a.a.b.as(102, this.wOs);
            }
            if (!Arrays.equals(this.wLW, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b((int) com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX, this.wLW);
            }
            if (this.wOt != null) {
                mY += com.google.a.a.b.b((int) bh.CTRL_INDEX, this.wOt);
            }
            if (this.wOu != -1) {
                mY += com.google.a.a.b.ar(com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX, this.wOu);
            }
            if (!this.wOv.equals("")) {
                mY += com.google.a.a.b.f((int) com.tencent.mm.plugin.appbrand.jsapi.aq.CTRL_INDEX, this.wOv);
            }
            if (this.wOw != 0) {
                mY += com.google.a.a.b.ar(com.tencent.mm.plugin.appbrand.jsapi.ao.CTRL_INDEX, this.wOw);
            }
            if (this.wOx != 0) {
                mY += com.google.a.a.b.as(cf.CTRL_INDEX, this.wOx);
            }
            if (this.rsa != 0) {
                mY += com.google.a.a.b.as(com.tencent.mm.plugin.appbrand.jsapi.v.CTRL_INDEX, this.rsa);
            }
            if (this.wOy != 0) {
                mY += com.google.a.a.b.as(207, this.wOy);
            }
            if (this.wOz != 0) {
                mY += com.google.a.a.b.as(bv.CTRL_INDEX, this.wOz);
            }
            if (this.wLR != 0) {
                return mY + com.google.a.a.b.as(240, this.wLR);
            }
            return mY;
        }
    }

    public static final class at extends com.google.a.a.e {
        private static volatile at[] wOA;
        public String oMt;
        public int taQ;
        public String username;
        public long wOB;
        public String wOC;
        public String wOD;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 8:
                        this.taQ = aVar.mL();
                        continue;
                    case 18:
                        this.username = aVar.readString();
                        continue;
                    case 26:
                        this.oMt = aVar.readString();
                        continue;
                    case 32:
                        this.wOB = aVar.mM();
                        continue;
                    case 42:
                        this.wOC = aVar.readString();
                        continue;
                    case 50:
                        this.wOD = aVar.readString();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static at[] cdd() {
            if (wOA == null) {
                synchronized (com.google.a.a.c.aIp) {
                    if (wOA == null) {
                        wOA = new at[0];
                    }
                }
            }
            return wOA;
        }

        public at() {
            this.taQ = 0;
            this.username = "";
            this.oMt = "";
            this.wOB = 0;
            this.wOC = "";
            this.wOD = "";
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.taQ != 0) {
                bVar.aq(1, this.taQ);
            }
            if (!this.username.equals("")) {
                bVar.e(2, this.username);
            }
            if (!this.oMt.equals("")) {
                bVar.e(3, this.oMt);
            }
            if (this.wOB != 0) {
                bVar.f(4, this.wOB);
            }
            if (!this.wOC.equals("")) {
                bVar.e(5, this.wOC);
            }
            if (!this.wOD.equals("")) {
                bVar.e(6, this.wOD);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (this.taQ != 0) {
                mY += com.google.a.a.b.as(1, this.taQ);
            }
            if (!this.username.equals("")) {
                mY += com.google.a.a.b.f(2, this.username);
            }
            if (!this.oMt.equals("")) {
                mY += com.google.a.a.b.f(3, this.oMt);
            }
            if (this.wOB != 0) {
                mY += com.google.a.a.b.h(4, this.wOB);
            }
            if (!this.wOC.equals("")) {
                mY += com.google.a.a.b.f(5, this.wOC);
            }
            if (this.wOD.equals("")) {
                return mY;
            }
            return mY + com.google.a.a.b.f(6, this.wOD);
        }
    }

    public static final class au extends com.google.a.a.e {
        public int wOE;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 8:
                        this.wOE = aVar.mL();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public au() {
            this.wOE = 0;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.wOE != 0) {
                bVar.aq(1, this.wOE);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (this.wOE != 0) {
                return mY + com.google.a.a.b.as(1, this.wOE);
            }
            return mY;
        }
    }

    public static final class av extends com.google.a.a.e {
        public int rhn;
        public long rho;
        public int wOF;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 8:
                        this.rhn = aVar.mL();
                        continue;
                    case 16:
                        this.rho = aVar.mM();
                        continue;
                    case 24:
                        this.wOF = aVar.mL();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public av() {
            this.rhn = 0;
            this.rho = 0;
            this.wOF = 0;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.rhn != 0) {
                bVar.ap(1, this.rhn);
            }
            if (this.rho != 0) {
                bVar.g(2, this.rho);
            }
            if (this.wOF != 0) {
                bVar.aq(3, this.wOF);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (this.rhn != 0) {
                mY += com.google.a.a.b.ar(1, this.rhn);
            }
            if (this.rho != 0) {
                mY += com.google.a.a.b.i(2, this.rho);
            }
            if (this.wOF != 0) {
                return mY + com.google.a.a.b.as(3, this.wOF);
            }
            return mY;
        }
    }

    public static final class aw extends com.google.a.a.e {
        private static volatile aw[] wOG;
        public int kBd;
        public int wOH;
        public int wOI;
        public int wOJ;
        public int wOK;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 8:
                        this.kBd = aVar.mL();
                        continue;
                    case 16:
                        this.wOH = aVar.mL();
                        continue;
                    case 24:
                        this.wOI = aVar.mL();
                        continue;
                    case 32:
                        this.wOJ = aVar.mL();
                        continue;
                    case 40:
                        this.wOK = aVar.mL();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static aw[] cde() {
            if (wOG == null) {
                synchronized (com.google.a.a.c.aIp) {
                    if (wOG == null) {
                        wOG = new aw[0];
                    }
                }
            }
            return wOG;
        }

        public aw() {
            this.kBd = 0;
            this.wOH = 0;
            this.wOI = 0;
            this.wOJ = 0;
            this.wOK = 0;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.kBd != 0) {
                bVar.ap(1, this.kBd);
            }
            if (this.wOH != 0) {
                bVar.ap(2, this.wOH);
            }
            if (this.wOI != 0) {
                bVar.ap(3, this.wOI);
            }
            if (this.wOJ != 0) {
                bVar.ap(4, this.wOJ);
            }
            if (this.wOK != 0) {
                bVar.ap(5, this.wOK);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (this.kBd != 0) {
                mY += com.google.a.a.b.ar(1, this.kBd);
            }
            if (this.wOH != 0) {
                mY += com.google.a.a.b.ar(2, this.wOH);
            }
            if (this.wOI != 0) {
                mY += com.google.a.a.b.ar(3, this.wOI);
            }
            if (this.wOJ != 0) {
                mY += com.google.a.a.b.ar(4, this.wOJ);
            }
            if (this.wOK != 0) {
                return mY + com.google.a.a.b.ar(5, this.wOK);
            }
            return mY;
        }
    }

    public static final class ax extends com.google.a.a.e {
        public int type;
        public ai wOL;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 8:
                        this.type = aVar.mL();
                        continue;
                    case 18:
                        if (this.wOL == null) {
                            this.wOL = new ai();
                        }
                        aVar.a(this.wOL);
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public ax() {
            this.type = 0;
            this.wOL = null;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.type != 0) {
                bVar.ap(1, this.type);
            }
            if (this.wOL != null) {
                bVar.a(2, this.wOL);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (this.type != 0) {
                mY += com.google.a.a.b.ar(1, this.type);
            }
            if (this.wOL != null) {
                return mY + com.google.a.a.b.b(2, this.wOL);
            }
            return mY;
        }
    }

    public static final class ay extends com.google.a.a.e {
        public String groupId;
        public int rhn;
        public long rho;
        public int wLL;
        public as[] wMX;
        public int wOM;
        public String wON;
        public String[] wOO;
        public long wOP;
        public String wOc;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                int b;
                Object obj;
                switch (mK) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.rhn = aVar.mL();
                        continue;
                    case 24:
                        this.rho = aVar.mM();
                        continue;
                    case 32:
                        this.wLL = aVar.mL();
                        continue;
                    case 40:
                        this.wOM = aVar.mL();
                        continue;
                    case 50:
                        this.wOc = aVar.readString();
                        continue;
                    case com.tencent.mm.plugin.appbrand.jsapi.m.CTRL_INDEX /*58*/:
                        b = com.google.a.a.g.b(aVar, 58);
                        mK = this.wMX == null ? 0 : this.wMX.length;
                        obj = new as[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wMX, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new as();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new as();
                        aVar.a(obj[mK]);
                        this.wMX = obj;
                        continue;
                    case 66:
                        this.wON = aVar.readString();
                        continue;
                    case 74:
                        b = com.google.a.a.g.b(aVar, 74);
                        mK = this.wOO == null ? 0 : this.wOO.length;
                        obj = new String[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wOO, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = aVar.readString();
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = aVar.readString();
                        this.wOO = obj;
                        continue;
                    case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                        this.wOP = aVar.mM();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public ay() {
            this.groupId = "";
            this.rhn = 0;
            this.rho = 0;
            this.wLL = 0;
            this.wOM = 0;
            this.wOc = "";
            this.wMX = as.cdc();
            this.wON = "";
            this.wOO = com.google.a.a.g.EMPTY_STRING_ARRAY;
            this.wOP = 0;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.rhn != 0) {
                bVar.ap(2, this.rhn);
            }
            if (this.rho != 0) {
                bVar.g(3, this.rho);
            }
            if (this.wLL != 0) {
                bVar.aq(4, this.wLL);
            }
            if (this.wOM != 0) {
                bVar.ap(5, this.wOM);
            }
            if (!this.wOc.equals("")) {
                bVar.e(6, this.wOc);
            }
            if (this.wMX != null && this.wMX.length > 0) {
                for (com.google.a.a.e eVar : this.wMX) {
                    if (eVar != null) {
                        bVar.a(7, eVar);
                    }
                }
            }
            if (!this.wON.equals("")) {
                bVar.e(8, this.wON);
            }
            if (this.wOO != null && this.wOO.length > 0) {
                while (i < this.wOO.length) {
                    String str = this.wOO[i];
                    if (str != null) {
                        bVar.e(9, str);
                    }
                    i++;
                }
            }
            if (this.wOP != 0) {
                bVar.f(10, this.wOP);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int i;
            int i2 = 0;
            int mY = super.mY();
            if (!this.groupId.equals("")) {
                mY += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.rhn != 0) {
                mY += com.google.a.a.b.ar(2, this.rhn);
            }
            if (this.rho != 0) {
                mY += com.google.a.a.b.i(3, this.rho);
            }
            if (this.wLL != 0) {
                mY += com.google.a.a.b.as(4, this.wLL);
            }
            if (this.wOM != 0) {
                mY += com.google.a.a.b.ar(5, this.wOM);
            }
            if (!this.wOc.equals("")) {
                mY += com.google.a.a.b.f(6, this.wOc);
            }
            if (this.wMX != null && this.wMX.length > 0) {
                i = mY;
                for (com.google.a.a.e eVar : this.wMX) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(7, eVar);
                    }
                }
                mY = i;
            }
            if (!this.wON.equals("")) {
                mY += com.google.a.a.b.f(8, this.wON);
            }
            if (this.wOO != null && this.wOO.length > 0) {
                i = 0;
                int i3 = 0;
                while (i2 < this.wOO.length) {
                    String str = this.wOO[i2];
                    if (str != null) {
                        i3++;
                        i += com.google.a.a.b.au(str);
                    }
                    i2++;
                }
                mY = (mY + i) + (i3 * 1);
            }
            if (this.wOP != 0) {
                return mY + com.google.a.a.b.h(10, this.wOP);
            }
            return mY;
        }
    }

    public static final class b extends com.google.a.a.e {
        public int fOl;
        public String wLG;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 10:
                        this.wLG = aVar.readString();
                        continue;
                    case 16:
                        this.fOl = aVar.mL();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public b() {
            this.wLG = "";
            this.fOl = 0;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.wLG.equals("")) {
                bVar.e(1, this.wLG);
            }
            if (this.fOl != 0) {
                bVar.ap(2, this.fOl);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (!this.wLG.equals("")) {
                mY += com.google.a.a.b.f(1, this.wLG);
            }
            if (this.fOl != 0) {
                return mY + com.google.a.a.b.ar(2, this.fOl);
            }
            return mY;
        }
    }

    public static final class c extends com.google.a.a.e {
        public u[] wLH;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 10:
                        int b = com.google.a.a.g.b(aVar, 10);
                        mK = this.wLH == null ? 0 : this.wLH.length;
                        Object obj = new u[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wLH, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new u();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new u();
                        aVar.a(obj[mK]);
                        this.wLH = obj;
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public c() {
            this.wLH = u.ccX();
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.wLH != null && this.wLH.length > 0) {
                for (com.google.a.a.e eVar : this.wLH) {
                    if (eVar != null) {
                        bVar.a(1, eVar);
                    }
                }
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (this.wLH != null && this.wLH.length > 0) {
                for (com.google.a.a.e eVar : this.wLH) {
                    if (eVar != null) {
                        mY += com.google.a.a.b.b(1, eVar);
                    }
                }
            }
            return mY;
        }
    }

    public static final class d extends com.google.a.a.e {
        public String wLG;
        public aq wLI;
        public int[] wLJ;
        public ax wLK;
        public int wLL;
        public int wLM;
        public av wLN;
        public String wLO;
        public String[] wLP;
        public l[] wLQ;
        public int wLR;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                int b;
                Object obj;
                switch (mK) {
                    case 0:
                        break;
                    case 10:
                        if (this.wLI == null) {
                            this.wLI = new aq();
                        }
                        aVar.a(this.wLI);
                        continue;
                    case 16:
                        b = com.google.a.a.g.b(aVar, 16);
                        mK = this.wLJ == null ? 0 : this.wLJ.length;
                        obj = new int[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wLJ, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = aVar.mL();
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = aVar.mL();
                        this.wLJ = obj;
                        continue;
                    case 18:
                        int cA = aVar.cA(aVar.mL());
                        b = aVar.getPosition();
                        mK = 0;
                        while (aVar.mO() > 0) {
                            aVar.mL();
                            mK++;
                        }
                        aVar.cC(b);
                        b = this.wLJ == null ? 0 : this.wLJ.length;
                        Object obj2 = new int[(mK + b)];
                        if (b != 0) {
                            System.arraycopy(this.wLJ, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = aVar.mL();
                            b++;
                        }
                        this.wLJ = obj2;
                        aVar.cB(cA);
                        continue;
                    case 26:
                        if (this.wLK == null) {
                            this.wLK = new ax();
                        }
                        aVar.a(this.wLK);
                        continue;
                    case 32:
                        this.wLL = aVar.mL();
                        continue;
                    case 40:
                        this.wLM = aVar.mL();
                        continue;
                    case 50:
                        if (this.wLN == null) {
                            this.wLN = new av();
                        }
                        aVar.a(this.wLN);
                        continue;
                    case com.tencent.mm.plugin.appbrand.jsapi.m.CTRL_INDEX /*58*/:
                        this.wLG = aVar.readString();
                        continue;
                    case 66:
                        this.wLO = aVar.readString();
                        continue;
                    case 802:
                        b = com.google.a.a.g.b(aVar, 802);
                        mK = this.wLP == null ? 0 : this.wLP.length;
                        obj = new String[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wLP, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = aVar.readString();
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = aVar.readString();
                        this.wLP = obj;
                        continue;
                    case 1618:
                        b = com.google.a.a.g.b(aVar, 1618);
                        mK = this.wLQ == null ? 0 : this.wLQ.length;
                        obj = new l[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wLQ, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new l();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new l();
                        aVar.a(obj[mK]);
                        this.wLQ = obj;
                        continue;
                    case 1920:
                        this.wLR = aVar.mL();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public d() {
            this.wLI = null;
            this.wLJ = com.google.a.a.g.aIr;
            this.wLK = null;
            this.wLL = 0;
            this.wLM = 0;
            this.wLN = null;
            this.wLG = "";
            this.wLO = "";
            this.wLP = com.google.a.a.g.EMPTY_STRING_ARRAY;
            this.wLQ = l.ccU();
            this.wLR = 0;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (this.wLI != null) {
                bVar.a(1, this.wLI);
            }
            if (this.wLJ != null && this.wLJ.length > 0) {
                for (int aq : this.wLJ) {
                    bVar.aq(2, aq);
                }
            }
            if (this.wLK != null) {
                bVar.a(3, this.wLK);
            }
            if (this.wLL != 0) {
                bVar.aq(4, this.wLL);
            }
            if (this.wLM != 0) {
                bVar.aq(5, this.wLM);
            }
            if (this.wLN != null) {
                bVar.a(6, this.wLN);
            }
            if (!this.wLG.equals("")) {
                bVar.e(7, this.wLG);
            }
            if (!this.wLO.equals("")) {
                bVar.e(8, this.wLO);
            }
            if (this.wLP != null && this.wLP.length > 0) {
                for (String str : this.wLP) {
                    if (str != null) {
                        bVar.e(100, str);
                    }
                }
            }
            if (this.wLQ != null && this.wLQ.length > 0) {
                while (i < this.wLQ.length) {
                    com.google.a.a.e eVar = this.wLQ[i];
                    if (eVar != null) {
                        bVar.a((int) com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX, eVar);
                    }
                    i++;
                }
            }
            if (this.wLR != 0) {
                bVar.aq(240, this.wLR);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int i;
            int i2;
            int i3 = 0;
            int mY = super.mY();
            if (this.wLI != null) {
                mY += com.google.a.a.b.b(1, this.wLI);
            }
            if (this.wLJ != null && this.wLJ.length > 0) {
                i = 0;
                for (int i22 : this.wLJ) {
                    i += com.google.a.a.b.cJ(i22);
                }
                mY = (mY + i) + (this.wLJ.length * 1);
            }
            if (this.wLK != null) {
                mY += com.google.a.a.b.b(3, this.wLK);
            }
            if (this.wLL != 0) {
                mY += com.google.a.a.b.as(4, this.wLL);
            }
            if (this.wLM != 0) {
                mY += com.google.a.a.b.as(5, this.wLM);
            }
            if (this.wLN != null) {
                mY += com.google.a.a.b.b(6, this.wLN);
            }
            if (!this.wLG.equals("")) {
                mY += com.google.a.a.b.f(7, this.wLG);
            }
            if (!this.wLO.equals("")) {
                mY += com.google.a.a.b.f(8, this.wLO);
            }
            if (this.wLP != null && this.wLP.length > 0) {
                i = 0;
                i22 = 0;
                for (String str : this.wLP) {
                    if (str != null) {
                        i22++;
                        i += com.google.a.a.b.au(str);
                    }
                }
                mY = (mY + i) + (i22 * 2);
            }
            if (this.wLQ != null && this.wLQ.length > 0) {
                while (i3 < this.wLQ.length) {
                    com.google.a.a.e eVar = this.wLQ[i3];
                    if (eVar != null) {
                        mY += com.google.a.a.b.b((int) com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX, eVar);
                    }
                    i3++;
                }
            }
            if (this.wLR != 0) {
                return mY + com.google.a.a.b.as(240, this.wLR);
            }
            return mY;
        }
    }

    public static final class e extends com.google.a.a.e {
        public String groupId;
        public int rhn;
        public long rho;
        public int wLE;
        public aq wLI;
        public ax wLK;
        public int wLM;
        public String[] wLP;
        public l[] wLQ;
        public int wLR;
        public int wLS;
        public q wLT;
        public int wLU;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                int b;
                Object obj;
                switch (mK) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.rhn = aVar.mL();
                        continue;
                    case 24:
                        this.rho = aVar.mM();
                        continue;
                    case 34:
                        if (this.wLK == null) {
                            this.wLK = new ax();
                        }
                        aVar.a(this.wLK);
                        continue;
                    case 40:
                        this.wLS = aVar.mL();
                        continue;
                    case 48:
                        this.wLM = aVar.mL();
                        continue;
                    case FileUtils.S_IRWXG /*56*/:
                        this.wLE = aVar.mL();
                        continue;
                    case 1602:
                        if (this.wLI == null) {
                            this.wLI = new aq();
                        }
                        aVar.a(this.wLI);
                        continue;
                    case 1610:
                        b = com.google.a.a.g.b(aVar, 1610);
                        mK = this.wLP == null ? 0 : this.wLP.length;
                        obj = new String[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wLP, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = aVar.readString();
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = aVar.readString();
                        this.wLP = obj;
                        continue;
                    case 1618:
                        b = com.google.a.a.g.b(aVar, 1618);
                        mK = this.wLQ == null ? 0 : this.wLQ.length;
                        obj = new l[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wLQ, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new l();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new l();
                        aVar.a(obj[mK]);
                        this.wLQ = obj;
                        continue;
                    case 1626:
                        if (this.wLT == null) {
                            this.wLT = new q();
                        }
                        aVar.a(this.wLT);
                        continue;
                    case 1632:
                        this.wLU = aVar.mL();
                        continue;
                    case 1920:
                        this.wLR = aVar.mL();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public e() {
            this.groupId = "";
            this.rhn = 0;
            this.rho = 0;
            this.wLK = null;
            this.wLS = 0;
            this.wLM = 0;
            this.wLE = 0;
            this.wLI = null;
            this.wLP = com.google.a.a.g.EMPTY_STRING_ARRAY;
            this.wLQ = l.ccU();
            this.wLT = null;
            this.wLU = 0;
            this.wLR = 0;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.rhn != 0) {
                bVar.ap(2, this.rhn);
            }
            if (this.rho != 0) {
                bVar.g(3, this.rho);
            }
            if (this.wLK != null) {
                bVar.a(4, this.wLK);
            }
            if (this.wLS != 0) {
                bVar.ap(5, this.wLS);
            }
            if (this.wLM != 0) {
                bVar.aq(6, this.wLM);
            }
            if (this.wLE != 0) {
                bVar.ap(7, this.wLE);
            }
            if (this.wLI != null) {
                bVar.a((int) com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX, this.wLI);
            }
            if (this.wLP != null && this.wLP.length > 0) {
                for (String str : this.wLP) {
                    if (str != null) {
                        bVar.e(bh.CTRL_INDEX, str);
                    }
                }
            }
            if (this.wLQ != null && this.wLQ.length > 0) {
                while (i < this.wLQ.length) {
                    com.google.a.a.e eVar = this.wLQ[i];
                    if (eVar != null) {
                        bVar.a((int) com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX, eVar);
                    }
                    i++;
                }
            }
            if (this.wLT != null) {
                bVar.a((int) com.tencent.mm.plugin.appbrand.jsapi.aq.CTRL_INDEX, this.wLT);
            }
            if (this.wLU != 0) {
                bVar.aq(com.tencent.mm.plugin.appbrand.jsapi.ao.CTRL_INDEX, this.wLU);
            }
            if (this.wLR != 0) {
                bVar.aq(240, this.wLR);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int i = 0;
            int mY = super.mY();
            if (!this.groupId.equals("")) {
                mY += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.rhn != 0) {
                mY += com.google.a.a.b.ar(2, this.rhn);
            }
            if (this.rho != 0) {
                mY += com.google.a.a.b.i(3, this.rho);
            }
            if (this.wLK != null) {
                mY += com.google.a.a.b.b(4, this.wLK);
            }
            if (this.wLS != 0) {
                mY += com.google.a.a.b.ar(5, this.wLS);
            }
            if (this.wLM != 0) {
                mY += com.google.a.a.b.as(6, this.wLM);
            }
            if (this.wLE != 0) {
                mY += com.google.a.a.b.ar(7, this.wLE);
            }
            if (this.wLI != null) {
                mY += com.google.a.a.b.b((int) com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX, this.wLI);
            }
            if (this.wLP != null && this.wLP.length > 0) {
                int i2 = 0;
                int i3 = 0;
                for (String str : this.wLP) {
                    if (str != null) {
                        i3++;
                        i2 += com.google.a.a.b.au(str);
                    }
                }
                mY = (mY + i2) + (i3 * 2);
            }
            if (this.wLQ != null && this.wLQ.length > 0) {
                while (i < this.wLQ.length) {
                    com.google.a.a.e eVar = this.wLQ[i];
                    if (eVar != null) {
                        mY += com.google.a.a.b.b((int) com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX, eVar);
                    }
                    i++;
                }
            }
            if (this.wLT != null) {
                mY += com.google.a.a.b.b((int) com.tencent.mm.plugin.appbrand.jsapi.aq.CTRL_INDEX, this.wLT);
            }
            if (this.wLU != 0) {
                mY += com.google.a.a.b.as(com.tencent.mm.plugin.appbrand.jsapi.ao.CTRL_INDEX, this.wLU);
            }
            if (this.wLR != 0) {
                return mY + com.google.a.a.b.as(240, this.wLR);
            }
            return mY;
        }
    }

    public static final class f extends com.google.a.a.e {
        public int fOl;
        public String groupId;
        public int rhn;
        public long rho;
        public int wLV;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.rhn = aVar.mL();
                        continue;
                    case 24:
                        this.rho = aVar.mM();
                        continue;
                    case 32:
                        this.fOl = aVar.mL();
                        continue;
                    case 40:
                        this.wLV = aVar.mL();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public f() {
            this.groupId = "";
            this.rhn = 0;
            this.rho = 0;
            this.fOl = 0;
            this.wLV = 0;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.rhn != 0) {
                bVar.ap(2, this.rhn);
            }
            if (this.rho != 0) {
                bVar.g(3, this.rho);
            }
            if (this.fOl != 0) {
                bVar.ap(4, this.fOl);
            }
            if (this.wLV != 0) {
                bVar.ap(5, this.wLV);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (!this.groupId.equals("")) {
                mY += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.rhn != 0) {
                mY += com.google.a.a.b.ar(2, this.rhn);
            }
            if (this.rho != 0) {
                mY += com.google.a.a.b.i(3, this.rho);
            }
            if (this.fOl != 0) {
                mY += com.google.a.a.b.ar(4, this.fOl);
            }
            if (this.wLV != 0) {
                return mY + com.google.a.a.b.ar(5, this.wLV);
            }
            return mY;
        }
    }

    public static final class g extends com.google.a.a.e {
        public int fOl;
        public String groupId;
        public int rhn;
        public long rho;
        public String wLG;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.rhn = aVar.mL();
                        continue;
                    case 24:
                        this.rho = aVar.mM();
                        continue;
                    case 32:
                        this.fOl = aVar.mL();
                        continue;
                    case 42:
                        this.wLG = aVar.readString();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public g() {
            this.groupId = "";
            this.rhn = 0;
            this.rho = 0;
            this.fOl = 0;
            this.wLG = "";
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.rhn != 0) {
                bVar.ap(2, this.rhn);
            }
            if (this.rho != 0) {
                bVar.g(3, this.rho);
            }
            if (this.fOl != 0) {
                bVar.ap(4, this.fOl);
            }
            if (!this.wLG.equals("")) {
                bVar.e(5, this.wLG);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (!this.groupId.equals("")) {
                mY += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.rhn != 0) {
                mY += com.google.a.a.b.ar(2, this.rhn);
            }
            if (this.rho != 0) {
                mY += com.google.a.a.b.i(3, this.rho);
            }
            if (this.fOl != 0) {
                mY += com.google.a.a.b.ar(4, this.fOl);
            }
            if (this.wLG.equals("")) {
                return mY;
            }
            return mY + com.google.a.a.b.f(5, this.wLG);
        }
    }

    public static final class h extends com.google.a.a.e {
        public int action;
        public String groupId;
        public int mNL;
        public long mNM;

        public h() {
            this.action = 0;
            this.mNL = 0;
            this.mNM = 0;
            this.groupId = "";
            this.aIq = -1;
        }

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 8:
                        this.action = aVar.mL();
                        continue;
                    case 16:
                        this.mNL = aVar.mL();
                        continue;
                    case 24:
                        this.mNM = aVar.mM();
                        continue;
                    case 34:
                        this.groupId = aVar.readString();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public final void a(com.google.a.a.b bVar) {
            bVar.aq(1, this.action);
            bVar.ap(2, this.mNL);
            bVar.g(3, this.mNM);
            if (!this.groupId.equals("")) {
                bVar.e(4, this.groupId);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = ((super.mY() + com.google.a.a.b.as(1, this.action)) + com.google.a.a.b.ar(2, this.mNL)) + com.google.a.a.b.i(3, this.mNM);
            return !this.groupId.equals("") ? mY + com.google.a.a.b.f(4, this.groupId) : mY;
        }
    }

    public static final class i extends com.google.a.a.e {
        public String groupId;
        public int rhn;
        public long rho;
        public ax wLK;
        public int wLM;
        public byte[] wLW;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.rhn = aVar.mL();
                        continue;
                    case 24:
                        this.rho = aVar.mM();
                        continue;
                    case 34:
                        if (this.wLK == null) {
                            this.wLK = new ax();
                        }
                        aVar.a(this.wLK);
                        continue;
                    case 40:
                        this.wLM = aVar.mL();
                        continue;
                    case 1602:
                        this.wLW = aVar.readBytes();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public i() {
            this.groupId = "";
            this.rhn = 0;
            this.rho = 0;
            this.wLK = null;
            this.wLM = 0;
            this.wLW = com.google.a.a.g.aIx;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.rhn != 0) {
                bVar.ap(2, this.rhn);
            }
            if (this.rho != 0) {
                bVar.g(3, this.rho);
            }
            if (this.wLK != null) {
                bVar.a(4, this.wLK);
            }
            if (this.wLM != 0) {
                bVar.aq(5, this.wLM);
            }
            if (!Arrays.equals(this.wLW, com.google.a.a.g.aIx)) {
                bVar.a((int) com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX, this.wLW);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (!this.groupId.equals("")) {
                mY += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.rhn != 0) {
                mY += com.google.a.a.b.ar(2, this.rhn);
            }
            if (this.rho != 0) {
                mY += com.google.a.a.b.i(3, this.rho);
            }
            if (this.wLK != null) {
                mY += com.google.a.a.b.b(4, this.wLK);
            }
            if (this.wLM != 0) {
                mY += com.google.a.a.b.as(5, this.wLM);
            }
            if (Arrays.equals(this.wLW, com.google.a.a.g.aIx)) {
                return mY;
            }
            return mY + com.google.a.a.b.b((int) com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX, this.wLW);
        }
    }

    public static final class j extends com.google.a.a.e {
        public String groupId;
        public int mOs;
        public int rhn;
        public long rho;
        public int wLM;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.rhn = aVar.mL();
                        continue;
                    case 24:
                        this.rho = aVar.mM();
                        continue;
                    case 32:
                        this.mOs = aVar.mL();
                        continue;
                    case 40:
                        this.wLM = aVar.mL();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public j() {
            this.groupId = "";
            this.rhn = 0;
            this.rho = 0;
            this.mOs = -1;
            this.wLM = 0;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.rhn != 0) {
                bVar.ap(2, this.rhn);
            }
            if (this.rho != 0) {
                bVar.g(3, this.rho);
            }
            if (this.mOs != -1) {
                bVar.ap(4, this.mOs);
            }
            if (this.wLM != 0) {
                bVar.aq(5, this.wLM);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (!this.groupId.equals("")) {
                mY += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.rhn != 0) {
                mY += com.google.a.a.b.ar(2, this.rhn);
            }
            if (this.rho != 0) {
                mY += com.google.a.a.b.i(3, this.rho);
            }
            if (this.mOs != -1) {
                mY += com.google.a.a.b.ar(4, this.mOs);
            }
            if (this.wLM != 0) {
                return mY + com.google.a.a.b.as(5, this.wLM);
            }
            return mY;
        }
    }

    public static final class k extends com.google.a.a.e {
        public String groupId;
        public int hYB;
        public int mOs;
        public int rhn;
        public long rho;
        public int wLX;
        public byte[] wLY;
        public aw[] wLZ;
        public al[] wMa;
        public int wMb;
        public int wMc;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                int b;
                Object obj;
                switch (mK) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.rhn = aVar.mL();
                        continue;
                    case 24:
                        this.rho = aVar.mM();
                        continue;
                    case 32:
                        this.mOs = aVar.mL();
                        continue;
                    case 40:
                        this.wLX = aVar.mL();
                        continue;
                    case 50:
                        this.wLY = aVar.readBytes();
                        continue;
                    case com.tencent.mm.plugin.appbrand.jsapi.m.CTRL_INDEX /*58*/:
                        b = com.google.a.a.g.b(aVar, 58);
                        mK = this.wLZ == null ? 0 : this.wLZ.length;
                        obj = new aw[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wLZ, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new aw();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new aw();
                        aVar.a(obj[mK]);
                        this.wLZ = obj;
                        continue;
                    case 66:
                        b = com.google.a.a.g.b(aVar, 66);
                        mK = this.wMa == null ? 0 : this.wMa.length;
                        obj = new al[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wMa, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new al();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new al();
                        aVar.a(obj[mK]);
                        this.wMa = obj;
                        continue;
                    case com.tencent.mm.plugin.appbrand.jsapi.q.CTRL_INDEX /*72*/:
                        this.wMb = aVar.mL();
                        continue;
                    case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                        this.wMc = aVar.mL();
                        continue;
                    case 88:
                        this.hYB = aVar.mL();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public k() {
            this.groupId = "";
            this.rhn = 0;
            this.rho = 0;
            this.mOs = -1;
            this.wLX = 0;
            this.wLY = com.google.a.a.g.aIx;
            this.wLZ = aw.cde();
            this.wMa = al.ccZ();
            this.wMb = 0;
            this.wMc = 0;
            this.hYB = 0;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.rhn != 0) {
                bVar.ap(2, this.rhn);
            }
            if (this.rho != 0) {
                bVar.g(3, this.rho);
            }
            if (this.mOs != -1) {
                bVar.ap(4, this.mOs);
            }
            if (this.wLX != 0) {
                bVar.ap(5, this.wLX);
            }
            if (!Arrays.equals(this.wLY, com.google.a.a.g.aIx)) {
                bVar.a(6, this.wLY);
            }
            if (this.wLZ != null && this.wLZ.length > 0) {
                for (com.google.a.a.e eVar : this.wLZ) {
                    if (eVar != null) {
                        bVar.a(7, eVar);
                    }
                }
            }
            if (this.wMa != null && this.wMa.length > 0) {
                while (i < this.wMa.length) {
                    com.google.a.a.e eVar2 = this.wMa[i];
                    if (eVar2 != null) {
                        bVar.a(8, eVar2);
                    }
                    i++;
                }
            }
            if (this.wMb != 0) {
                bVar.ap(9, this.wMb);
            }
            if (this.wMc != 0) {
                bVar.ap(10, this.wMc);
            }
            if (this.hYB != 0) {
                bVar.ap(11, this.hYB);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int i = 0;
            int mY = super.mY();
            if (!this.groupId.equals("")) {
                mY += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.rhn != 0) {
                mY += com.google.a.a.b.ar(2, this.rhn);
            }
            if (this.rho != 0) {
                mY += com.google.a.a.b.i(3, this.rho);
            }
            if (this.mOs != -1) {
                mY += com.google.a.a.b.ar(4, this.mOs);
            }
            if (this.wLX != 0) {
                mY += com.google.a.a.b.ar(5, this.wLX);
            }
            if (!Arrays.equals(this.wLY, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b(6, this.wLY);
            }
            if (this.wLZ != null && this.wLZ.length > 0) {
                int i2 = mY;
                for (com.google.a.a.e eVar : this.wLZ) {
                    if (eVar != null) {
                        i2 += com.google.a.a.b.b(7, eVar);
                    }
                }
                mY = i2;
            }
            if (this.wMa != null && this.wMa.length > 0) {
                while (i < this.wMa.length) {
                    com.google.a.a.e eVar2 = this.wMa[i];
                    if (eVar2 != null) {
                        mY += com.google.a.a.b.b(8, eVar2);
                    }
                    i++;
                }
            }
            if (this.wMb != 0) {
                mY += com.google.a.a.b.ar(9, this.wMb);
            }
            if (this.wMc != 0) {
                mY += com.google.a.a.b.ar(10, this.wMc);
            }
            if (this.hYB != 0) {
                return mY + com.google.a.a.b.ar(11, this.hYB);
            }
            return mY;
        }
    }

    public static final class l extends com.google.a.a.e {
        private static volatile l[] wMd;
        public String fFa;
        public int taQ;
        public String wMe;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 8:
                        this.taQ = aVar.mL();
                        continue;
                    case 18:
                        this.fFa = aVar.readString();
                        continue;
                    case 26:
                        this.wMe = aVar.readString();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static l[] ccU() {
            if (wMd == null) {
                synchronized (com.google.a.a.c.aIp) {
                    if (wMd == null) {
                        wMd = new l[0];
                    }
                }
            }
            return wMd;
        }

        public l() {
            this.taQ = 0;
            this.fFa = "";
            this.wMe = "";
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.taQ != 0) {
                bVar.aq(1, this.taQ);
            }
            if (!this.fFa.equals("")) {
                bVar.e(2, this.fFa);
            }
            if (!this.wMe.equals("")) {
                bVar.e(3, this.wMe);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (this.taQ != 0) {
                mY += com.google.a.a.b.as(1, this.taQ);
            }
            if (!this.fFa.equals("")) {
                mY += com.google.a.a.b.f(2, this.fFa);
            }
            if (this.wMe.equals("")) {
                return mY;
            }
            return mY + com.google.a.a.b.f(3, this.wMe);
        }
    }

    public static final class m extends com.google.a.a.e {
        private static volatile m[] wMf;
        public byte[] fNy;
        public int wMg;
        public int wMh;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 8:
                        this.wMg = aVar.mL();
                        continue;
                    case 18:
                        this.fNy = aVar.readBytes();
                        continue;
                    case 24:
                        this.wMh = aVar.mL();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static m[] ccV() {
            if (wMf == null) {
                synchronized (com.google.a.a.c.aIp) {
                    if (wMf == null) {
                        wMf = new m[0];
                    }
                }
            }
            return wMf;
        }

        public m() {
            this.wMg = 0;
            this.fNy = com.google.a.a.g.aIx;
            this.wMh = 0;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.wMg != 0) {
                bVar.ap(1, this.wMg);
            }
            if (!Arrays.equals(this.fNy, com.google.a.a.g.aIx)) {
                bVar.a(2, this.fNy);
            }
            if (this.wMh != 0) {
                bVar.aq(3, this.wMh);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (this.wMg != 0) {
                mY += com.google.a.a.b.ar(1, this.wMg);
            }
            if (!Arrays.equals(this.fNy, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b(2, this.fNy);
            }
            if (this.wMh != 0) {
                return mY + com.google.a.a.b.as(3, this.wMh);
            }
            return mY;
        }
    }

    public static final class n extends com.google.a.a.e {
        private static volatile n[] wMi;
        public int port;
        public int wMj;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 8:
                        this.wMj = aVar.mL();
                        continue;
                    case 16:
                        this.port = aVar.mL();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static n[] ccW() {
            if (wMi == null) {
                synchronized (com.google.a.a.c.aIp) {
                    if (wMi == null) {
                        wMi = new n[0];
                    }
                }
            }
            return wMi;
        }

        public n() {
            this.wMj = 0;
            this.port = 0;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.wMj != 0) {
                bVar.aq(1, this.wMj);
            }
            if (this.port != 0) {
                bVar.ap(2, this.port);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (this.wMj != 0) {
                mY += com.google.a.a.b.as(1, this.wMj);
            }
            if (this.port != 0) {
                return mY + com.google.a.a.b.ar(2, this.port);
            }
            return mY;
        }
    }

    public static final class o extends com.google.a.a.e {
        public long fGM;
        public String groupId;
        public int rhn;
        public long rho;
        public aq wLI;
        public int wLL;
        public av wLN;
        public int wMk;
        public at[] wMl;
        public as[] wMm;
        public ap wMn;
        public int wMo;
        public byte[] wMp;
        public byte[] wMq;
        public as[] wMr;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                int b;
                Object obj;
                switch (mK) {
                    case 0:
                        break;
                    case 8:
                        this.wMk = aVar.mL();
                        continue;
                    case 18:
                        this.groupId = aVar.readString();
                        continue;
                    case 24:
                        this.rhn = aVar.mL();
                        continue;
                    case 32:
                        this.rho = aVar.mM();
                        continue;
                    case 40:
                        this.wLL = aVar.mL();
                        continue;
                    case 50:
                        if (this.wLI == null) {
                            this.wLI = new aq();
                        }
                        aVar.a(this.wLI);
                        continue;
                    case com.tencent.mm.plugin.appbrand.jsapi.m.CTRL_INDEX /*58*/:
                        b = com.google.a.a.g.b(aVar, 58);
                        mK = this.wMl == null ? 0 : this.wMl.length;
                        obj = new at[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wMl, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new at();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new at();
                        aVar.a(obj[mK]);
                        this.wMl = obj;
                        continue;
                    case 66:
                        b = com.google.a.a.g.b(aVar, 66);
                        mK = this.wMm == null ? 0 : this.wMm.length;
                        obj = new as[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wMm, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new as();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new as();
                        aVar.a(obj[mK]);
                        this.wMm = obj;
                        continue;
                    case 74:
                        if (this.wMn == null) {
                            this.wMn = new ap();
                        }
                        aVar.a(this.wMn);
                        continue;
                    case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*82*/:
                        if (this.wLN == null) {
                            this.wLN = new av();
                        }
                        aVar.a(this.wLN);
                        continue;
                    case 808:
                        this.fGM = aVar.mM();
                        continue;
                    case 816:
                        this.wMo = aVar.mL();
                        continue;
                    case 826:
                        this.wMp = aVar.readBytes();
                        continue;
                    case 1602:
                        this.wMq = aVar.readBytes();
                        continue;
                    case 1610:
                        b = com.google.a.a.g.b(aVar, 1610);
                        mK = this.wMr == null ? 0 : this.wMr.length;
                        obj = new as[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wMr, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new as();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new as();
                        aVar.a(obj[mK]);
                        this.wMr = obj;
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public o() {
            this.wMk = 0;
            this.groupId = "";
            this.rhn = 0;
            this.rho = 0;
            this.wLL = 0;
            this.wLI = null;
            this.wMl = at.cdd();
            this.wMm = as.cdc();
            this.wMn = null;
            this.wLN = null;
            this.fGM = 0;
            this.wMo = 0;
            this.wMp = com.google.a.a.g.aIx;
            this.wMq = com.google.a.a.g.aIx;
            this.wMr = as.cdc();
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (this.wMk != 0) {
                bVar.ap(1, this.wMk);
            }
            if (!this.groupId.equals("")) {
                bVar.e(2, this.groupId);
            }
            if (this.rhn != 0) {
                bVar.ap(3, this.rhn);
            }
            if (this.rho != 0) {
                bVar.g(4, this.rho);
            }
            if (this.wLL != 0) {
                bVar.aq(5, this.wLL);
            }
            if (this.wLI != null) {
                bVar.a(6, this.wLI);
            }
            if (this.wMl != null && this.wMl.length > 0) {
                for (com.google.a.a.e eVar : this.wMl) {
                    if (eVar != null) {
                        bVar.a(7, eVar);
                    }
                }
            }
            if (this.wMm != null && this.wMm.length > 0) {
                for (com.google.a.a.e eVar2 : this.wMm) {
                    if (eVar2 != null) {
                        bVar.a(8, eVar2);
                    }
                }
            }
            if (this.wMn != null) {
                bVar.a(9, this.wMn);
            }
            if (this.wLN != null) {
                bVar.a(10, this.wLN);
            }
            if (this.fGM != 0) {
                bVar.f(101, this.fGM);
            }
            if (this.wMo != 0) {
                bVar.aq(102, this.wMo);
            }
            if (!Arrays.equals(this.wMp, com.google.a.a.g.aIx)) {
                bVar.a(103, this.wMp);
            }
            if (!Arrays.equals(this.wMq, com.google.a.a.g.aIx)) {
                bVar.a((int) com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX, this.wMq);
            }
            if (this.wMr != null && this.wMr.length > 0) {
                while (i < this.wMr.length) {
                    com.google.a.a.e eVar3 = this.wMr[i];
                    if (eVar3 != null) {
                        bVar.a((int) bh.CTRL_INDEX, eVar3);
                    }
                    i++;
                }
            }
            super.a(bVar);
        }

        protected final int mY() {
            int i;
            int i2 = 0;
            int mY = super.mY();
            if (this.wMk != 0) {
                mY += com.google.a.a.b.ar(1, this.wMk);
            }
            if (!this.groupId.equals("")) {
                mY += com.google.a.a.b.f(2, this.groupId);
            }
            if (this.rhn != 0) {
                mY += com.google.a.a.b.ar(3, this.rhn);
            }
            if (this.rho != 0) {
                mY += com.google.a.a.b.i(4, this.rho);
            }
            if (this.wLL != 0) {
                mY += com.google.a.a.b.as(5, this.wLL);
            }
            if (this.wLI != null) {
                mY += com.google.a.a.b.b(6, this.wLI);
            }
            if (this.wMl != null && this.wMl.length > 0) {
                i = mY;
                for (com.google.a.a.e eVar : this.wMl) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(7, eVar);
                    }
                }
                mY = i;
            }
            if (this.wMm != null && this.wMm.length > 0) {
                i = mY;
                for (com.google.a.a.e eVar2 : this.wMm) {
                    if (eVar2 != null) {
                        i += com.google.a.a.b.b(8, eVar2);
                    }
                }
                mY = i;
            }
            if (this.wMn != null) {
                mY += com.google.a.a.b.b(9, this.wMn);
            }
            if (this.wLN != null) {
                mY += com.google.a.a.b.b(10, this.wLN);
            }
            if (this.fGM != 0) {
                mY += com.google.a.a.b.h(101, this.fGM);
            }
            if (this.wMo != 0) {
                mY += com.google.a.a.b.as(102, this.wMo);
            }
            if (!Arrays.equals(this.wMp, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b(103, this.wMp);
            }
            if (!Arrays.equals(this.wMq, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b((int) com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX, this.wMq);
            }
            if (this.wMr != null && this.wMr.length > 0) {
                while (i2 < this.wMr.length) {
                    com.google.a.a.e eVar3 = this.wMr[i2];
                    if (eVar3 != null) {
                        mY += com.google.a.a.b.b((int) bh.CTRL_INDEX, eVar3);
                    }
                    i2++;
                }
            }
            return mY;
        }
    }

    public static final class p extends com.google.a.a.e {
        public aj[] wMs;

        public p() {
            this.wMs = aj.ccY();
            this.aIq = -1;
        }

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 10:
                        int b = com.google.a.a.g.b(aVar, 10);
                        mK = this.wMs == null ? 0 : this.wMs.length;
                        Object obj = new aj[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wMs, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new aj();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new aj();
                        aVar.a(obj[mK]);
                        this.wMs = obj;
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.wMs != null && this.wMs.length > 0) {
                for (com.google.a.a.e eVar : this.wMs) {
                    if (eVar != null) {
                        bVar.a(1, eVar);
                    }
                }
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (this.wMs != null && this.wMs.length > 0) {
                for (com.google.a.a.e eVar : this.wMs) {
                    if (eVar != null) {
                        mY += com.google.a.a.b.b(1, eVar);
                    }
                }
            }
            return mY;
        }
    }

    public static final class q extends com.google.a.a.e {
        public long tkZ;
        public long tla;
        public String username;
        public String uuC;
        public int wMA;
        public String wMe;
        public String wMt;
        public String wMu;
        public int wMv;
        public String wMw;
        public long wMx;
        public int wMy;
        public long wMz;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 8:
                        this.tkZ = aVar.mM();
                        continue;
                    case 18:
                        this.wMt = aVar.readString();
                        continue;
                    case 26:
                        this.wMu = aVar.readString();
                        continue;
                    case 32:
                        this.wMv = aVar.mL();
                        continue;
                    case 42:
                        this.username = aVar.readString();
                        continue;
                    case 50:
                        this.wMw = aVar.readString();
                        continue;
                    case com.tencent.mm.plugin.appbrand.jsapi.m.CTRL_INDEX /*58*/:
                        this.wMe = aVar.readString();
                        continue;
                    case 64:
                        this.wMx = aVar.mM();
                        continue;
                    case com.tencent.mm.plugin.appbrand.jsapi.q.CTRL_INDEX /*72*/:
                        this.wMy = aVar.mL();
                        continue;
                    case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*82*/:
                        this.uuC = aVar.readString();
                        continue;
                    case 88:
                        this.wMz = aVar.mM();
                        continue;
                    case PlayerException.EXCEPTION_IN_SETAUDIOEFFECT /*96*/:
                        this.wMA = aVar.mL();
                        continue;
                    case 104:
                        this.tla = aVar.mM();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public q() {
            this.tkZ = 0;
            this.wMt = "";
            this.wMu = "";
            this.wMv = 1;
            this.username = "";
            this.wMw = "";
            this.wMe = "";
            this.wMx = 0;
            this.wMy = 0;
            this.uuC = "";
            this.wMz = 0;
            this.wMA = 0;
            this.tla = 0;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.tkZ != 0) {
                bVar.f(1, this.tkZ);
            }
            if (!this.wMt.equals("")) {
                bVar.e(2, this.wMt);
            }
            if (!this.wMu.equals("")) {
                bVar.e(3, this.wMu);
            }
            if (this.wMv != 1) {
                bVar.ap(4, this.wMv);
            }
            if (!this.username.equals("")) {
                bVar.e(5, this.username);
            }
            if (!this.wMw.equals("")) {
                bVar.e(6, this.wMw);
            }
            if (!this.wMe.equals("")) {
                bVar.e(7, this.wMe);
            }
            if (this.wMx != 0) {
                bVar.f(8, this.wMx);
            }
            if (this.wMy != 0) {
                bVar.aq(9, this.wMy);
            }
            if (!this.uuC.equals("")) {
                bVar.e(10, this.uuC);
            }
            if (this.wMz != 0) {
                bVar.f(11, this.wMz);
            }
            if (this.wMA != 0) {
                bVar.aq(12, this.wMA);
            }
            if (this.tla != 0) {
                bVar.f(13, this.tla);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (this.tkZ != 0) {
                mY += com.google.a.a.b.h(1, this.tkZ);
            }
            if (!this.wMt.equals("")) {
                mY += com.google.a.a.b.f(2, this.wMt);
            }
            if (!this.wMu.equals("")) {
                mY += com.google.a.a.b.f(3, this.wMu);
            }
            if (this.wMv != 1) {
                mY += com.google.a.a.b.ar(4, this.wMv);
            }
            if (!this.username.equals("")) {
                mY += com.google.a.a.b.f(5, this.username);
            }
            if (!this.wMw.equals("")) {
                mY += com.google.a.a.b.f(6, this.wMw);
            }
            if (!this.wMe.equals("")) {
                mY += com.google.a.a.b.f(7, this.wMe);
            }
            if (this.wMx != 0) {
                mY += com.google.a.a.b.h(8, this.wMx);
            }
            if (this.wMy != 0) {
                mY += com.google.a.a.b.as(9, this.wMy);
            }
            if (!this.uuC.equals("")) {
                mY += com.google.a.a.b.f(10, this.uuC);
            }
            if (this.wMz != 0) {
                mY += com.google.a.a.b.h(11, this.wMz);
            }
            if (this.wMA != 0) {
                mY += com.google.a.a.b.as(12, this.wMA);
            }
            if (this.tla != 0) {
                return mY + com.google.a.a.b.h(13, this.tla);
            }
            return mY;
        }
    }

    public static final class r extends com.google.a.a.e {
        public byte[] data;
        public String iconUrl;
        public String lfx;
        public int status;
        public int wMB;
        public byte[] wMC;
        public byte[] wMD;
        public byte[] wME;
        public int wMF;
        public int wMG;
        public byte[] wMH;
        public byte[] wMI;
        public byte[] wMJ;
        public byte[] wMK;
        public byte[] wML;
        public byte[] wMM;
        public byte[] wMN;
        public byte[] wMO;
        public byte[] wMP;
        public byte[] wMQ;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 8:
                        this.wMB = aVar.mL();
                        continue;
                    case 18:
                        this.wMC = aVar.readBytes();
                        continue;
                    case 26:
                        this.iconUrl = aVar.readString();
                        continue;
                    case 34:
                        this.wMD = aVar.readBytes();
                        continue;
                    case 42:
                        this.wME = aVar.readBytes();
                        continue;
                    case 48:
                        this.wMF = aVar.mL();
                        continue;
                    case com.tencent.mm.plugin.appbrand.jsapi.m.CTRL_INDEX /*58*/:
                        this.data = aVar.readBytes();
                        continue;
                    case 64:
                        this.wMG = aVar.mL();
                        continue;
                    case 74:
                        this.wMH = aVar.readBytes();
                        continue;
                    case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*82*/:
                        this.lfx = aVar.readString();
                        continue;
                    case PlayerException.EXCEPTION_IN_SETDATASOURCE /*90*/:
                        this.wMI = aVar.readBytes();
                        continue;
                    case 98:
                        this.wMJ = aVar.readBytes();
                        continue;
                    case MMGIFException.D_GIF_ERR_NO_COLOR_MAP /*106*/:
                        this.wMK = aVar.readBytes();
                        continue;
                    case 114:
                        this.wML = aVar.readBytes();
                        continue;
                    case 122:
                        this.wMM = aVar.readBytes();
                        continue;
                    case 130:
                        this.wMN = aVar.readBytes();
                        continue;
                    case 138:
                        this.wMO = aVar.readBytes();
                        continue;
                    case com.tencent.mm.plugin.appbrand.jsapi.share.e.CTRL_INDEX /*146*/:
                        this.wMP = aVar.readBytes();
                        continue;
                    case JsApiMakeVoIPCall.CTRL_INDEX /*154*/:
                        this.wMQ = aVar.readBytes();
                        continue;
                    case JsApiSetBackgroundAudioState.CTRL_INDEX /*160*/:
                        this.status = aVar.mL();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public r() {
            this.wMB = 0;
            this.wMC = com.google.a.a.g.aIx;
            this.iconUrl = "";
            this.wMD = com.google.a.a.g.aIx;
            this.wME = com.google.a.a.g.aIx;
            this.wMF = 0;
            this.data = com.google.a.a.g.aIx;
            this.wMG = 0;
            this.wMH = com.google.a.a.g.aIx;
            this.lfx = "";
            this.wMI = com.google.a.a.g.aIx;
            this.wMJ = com.google.a.a.g.aIx;
            this.wMK = com.google.a.a.g.aIx;
            this.wML = com.google.a.a.g.aIx;
            this.wMM = com.google.a.a.g.aIx;
            this.wMN = com.google.a.a.g.aIx;
            this.wMO = com.google.a.a.g.aIx;
            this.wMP = com.google.a.a.g.aIx;
            this.wMQ = com.google.a.a.g.aIx;
            this.status = 0;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.wMB != 0) {
                bVar.aq(1, this.wMB);
            }
            if (!Arrays.equals(this.wMC, com.google.a.a.g.aIx)) {
                bVar.a(2, this.wMC);
            }
            if (!this.iconUrl.equals("")) {
                bVar.e(3, this.iconUrl);
            }
            if (!Arrays.equals(this.wMD, com.google.a.a.g.aIx)) {
                bVar.a(4, this.wMD);
            }
            if (!Arrays.equals(this.wME, com.google.a.a.g.aIx)) {
                bVar.a(5, this.wME);
            }
            if (this.wMF != 0) {
                bVar.aq(6, this.wMF);
            }
            if (!Arrays.equals(this.data, com.google.a.a.g.aIx)) {
                bVar.a(7, this.data);
            }
            if (this.wMG != 0) {
                bVar.aq(8, this.wMG);
            }
            if (!Arrays.equals(this.wMH, com.google.a.a.g.aIx)) {
                bVar.a(9, this.wMH);
            }
            if (!this.lfx.equals("")) {
                bVar.e(10, this.lfx);
            }
            if (!Arrays.equals(this.wMI, com.google.a.a.g.aIx)) {
                bVar.a(11, this.wMI);
            }
            if (!Arrays.equals(this.wMJ, com.google.a.a.g.aIx)) {
                bVar.a(12, this.wMJ);
            }
            if (!Arrays.equals(this.wMK, com.google.a.a.g.aIx)) {
                bVar.a(13, this.wMK);
            }
            if (!Arrays.equals(this.wML, com.google.a.a.g.aIx)) {
                bVar.a(14, this.wML);
            }
            if (!Arrays.equals(this.wMM, com.google.a.a.g.aIx)) {
                bVar.a(15, this.wMM);
            }
            if (!Arrays.equals(this.wMN, com.google.a.a.g.aIx)) {
                bVar.a(16, this.wMN);
            }
            if (!Arrays.equals(this.wMO, com.google.a.a.g.aIx)) {
                bVar.a(17, this.wMO);
            }
            if (!Arrays.equals(this.wMP, com.google.a.a.g.aIx)) {
                bVar.a(18, this.wMP);
            }
            if (!Arrays.equals(this.wMQ, com.google.a.a.g.aIx)) {
                bVar.a(19, this.wMQ);
            }
            if (this.status != 0) {
                bVar.aq(20, this.status);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (this.wMB != 0) {
                mY += com.google.a.a.b.as(1, this.wMB);
            }
            if (!Arrays.equals(this.wMC, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b(2, this.wMC);
            }
            if (!this.iconUrl.equals("")) {
                mY += com.google.a.a.b.f(3, this.iconUrl);
            }
            if (!Arrays.equals(this.wMD, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b(4, this.wMD);
            }
            if (!Arrays.equals(this.wME, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b(5, this.wME);
            }
            if (this.wMF != 0) {
                mY += com.google.a.a.b.as(6, this.wMF);
            }
            if (!Arrays.equals(this.data, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b(7, this.data);
            }
            if (this.wMG != 0) {
                mY += com.google.a.a.b.as(8, this.wMG);
            }
            if (!Arrays.equals(this.wMH, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b(9, this.wMH);
            }
            if (!this.lfx.equals("")) {
                mY += com.google.a.a.b.f(10, this.lfx);
            }
            if (!Arrays.equals(this.wMI, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b(11, this.wMI);
            }
            if (!Arrays.equals(this.wMJ, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b(12, this.wMJ);
            }
            if (!Arrays.equals(this.wMK, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b(13, this.wMK);
            }
            if (!Arrays.equals(this.wML, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b(14, this.wML);
            }
            if (!Arrays.equals(this.wMM, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b(15, this.wMM);
            }
            if (!Arrays.equals(this.wMN, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b(16, this.wMN);
            }
            if (!Arrays.equals(this.wMO, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b(17, this.wMO);
            }
            if (!Arrays.equals(this.wMP, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b(18, this.wMP);
            }
            if (!Arrays.equals(this.wMQ, com.google.a.a.g.aIx)) {
                mY += com.google.a.a.b.b(19, this.wMQ);
            }
            if (this.status != 0) {
                return mY + com.google.a.a.b.as(20, this.status);
            }
            return mY;
        }
    }

    public static final class s extends com.google.a.a.e {
        public int ou;
        public int ret;
        public int taQ;
        public String userName;
        public int wLL;
        public int wMR;
        public int wMS;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 18:
                        this.userName = aVar.readString();
                        continue;
                    case 24:
                        this.ou = aVar.mL();
                        continue;
                    case 32:
                        this.wMR = aVar.mL();
                        continue;
                    case 40:
                        this.ret = aVar.mL();
                        continue;
                    case 48:
                        this.wMS = aVar.mL();
                        continue;
                    case FileUtils.S_IRWXG /*56*/:
                        this.wLL = aVar.mL();
                        continue;
                    case 64:
                        this.taQ = aVar.mL();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public s() {
            this.userName = "";
            this.ou = 0;
            this.wMR = 0;
            this.ret = 0;
            this.wMS = 0;
            this.wLL = 0;
            this.taQ = 0;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.userName.equals("")) {
                bVar.e(2, this.userName);
            }
            if (this.ou != 0) {
                bVar.ap(3, this.ou);
            }
            if (this.wMR != 0) {
                bVar.aq(4, this.wMR);
            }
            if (this.ret != 0) {
                bVar.ap(5, this.ret);
            }
            if (this.wMS != 0) {
                bVar.ap(6, this.wMS);
            }
            if (this.wLL != 0) {
                bVar.aq(7, this.wLL);
            }
            if (this.taQ != 0) {
                bVar.aq(8, this.taQ);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (!this.userName.equals("")) {
                mY += com.google.a.a.b.f(2, this.userName);
            }
            if (this.ou != 0) {
                mY += com.google.a.a.b.ar(3, this.ou);
            }
            if (this.wMR != 0) {
                mY += com.google.a.a.b.as(4, this.wMR);
            }
            if (this.ret != 0) {
                mY += com.google.a.a.b.ar(5, this.ret);
            }
            if (this.wMS != 0) {
                mY += com.google.a.a.b.ar(6, this.wMS);
            }
            if (this.wLL != 0) {
                mY += com.google.a.a.b.as(7, this.wLL);
            }
            if (this.taQ != 0) {
                return mY + com.google.a.a.b.as(8, this.taQ);
            }
            return mY;
        }
    }

    public static final class t extends com.google.a.a.e {
        public byte[] body;
        public s wMT;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 10:
                        if (this.wMT == null) {
                            this.wMT = new s();
                        }
                        aVar.a(this.wMT);
                        continue;
                    case 18:
                        this.body = aVar.readBytes();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public t() {
            this.wMT = null;
            this.body = com.google.a.a.g.aIx;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (this.wMT != null) {
                bVar.a(1, this.wMT);
            }
            if (!Arrays.equals(this.body, com.google.a.a.g.aIx)) {
                bVar.a(2, this.body);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (this.wMT != null) {
                mY += com.google.a.a.b.b(1, this.wMT);
            }
            if (Arrays.equals(this.body, com.google.a.a.g.aIx)) {
                return mY;
            }
            return mY + com.google.a.a.b.b(2, this.body);
        }
    }

    public static final class u extends com.google.a.a.e {
        private static volatile u[] wMU;
        public String wMV;
        public String wMW;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 10:
                        this.wMV = aVar.readString();
                        continue;
                    case 18:
                        this.wMW = aVar.readString();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static u[] ccX() {
            if (wMU == null) {
                synchronized (com.google.a.a.c.aIp) {
                    if (wMU == null) {
                        wMU = new u[0];
                    }
                }
            }
            return wMU;
        }

        public u() {
            this.wMV = "";
            this.wMW = "";
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.wMV.equals("")) {
                bVar.e(1, this.wMV);
            }
            if (!this.wMW.equals("")) {
                bVar.e(2, this.wMW);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (!this.wMV.equals("")) {
                mY += com.google.a.a.b.f(1, this.wMV);
            }
            if (this.wMW.equals("")) {
                return mY;
            }
            return mY + com.google.a.a.b.f(2, this.wMW);
        }
    }

    public static final class v extends com.google.a.a.e {
        public String groupId;
        public int rhn;
        public long rho;
        public aq wLI;
        public as[] wMX;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.rhn = aVar.mL();
                        continue;
                    case 24:
                        this.rho = aVar.mM();
                        continue;
                    case 34:
                        int b = com.google.a.a.g.b(aVar, 34);
                        mK = this.wMX == null ? 0 : this.wMX.length;
                        Object obj = new as[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wMX, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new as();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new as();
                        aVar.a(obj[mK]);
                        this.wMX = obj;
                        continue;
                    case 42:
                        if (this.wLI == null) {
                            this.wLI = new aq();
                        }
                        aVar.a(this.wLI);
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public v() {
            this.groupId = "";
            this.rhn = 0;
            this.rho = 0;
            this.wMX = as.cdc();
            this.wLI = null;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.rhn != 0) {
                bVar.ap(2, this.rhn);
            }
            if (this.rho != 0) {
                bVar.g(3, this.rho);
            }
            if (this.wMX != null && this.wMX.length > 0) {
                for (com.google.a.a.e eVar : this.wMX) {
                    if (eVar != null) {
                        bVar.a(4, eVar);
                    }
                }
            }
            if (this.wLI != null) {
                bVar.a(5, this.wLI);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (!this.groupId.equals("")) {
                mY += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.rhn != 0) {
                mY += com.google.a.a.b.ar(2, this.rhn);
            }
            if (this.rho != 0) {
                mY += com.google.a.a.b.i(3, this.rho);
            }
            if (this.wMX != null && this.wMX.length > 0) {
                int i = mY;
                for (com.google.a.a.e eVar : this.wMX) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(4, eVar);
                    }
                }
                mY = i;
            }
            if (this.wLI != null) {
                return mY + com.google.a.a.b.b(5, this.wLI);
            }
            return mY;
        }
    }

    public static final class w extends com.google.a.a.e {
        public String wLG;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 10:
                        this.wLG = aVar.readString();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public w() {
            this.wLG = "";
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.wLG.equals("")) {
                bVar.e(1, this.wLG);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (this.wLG.equals("")) {
                return mY;
            }
            return mY + com.google.a.a.b.f(1, this.wLG);
        }
    }

    public static final class x extends com.google.a.a.e {
        public String groupId;
        public int rhn;
        public long rho;
        public String wLG;
        public aq wLI;
        public int wLL;
        public n[] wMY;
        public at[] wMZ;
        public int wMg;
        public as[] wMm;
        public ap wMn;
        public as[] wMr;
        public int wNa;
        public int[] wNb;
        public n[] wNc;
        public int wNd;
        public int wNe;
        public n[] wNf;
        public int wNg;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                int b;
                Object obj;
                switch (mK) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.rhn = aVar.mL();
                        continue;
                    case 24:
                        this.rho = aVar.mM();
                        continue;
                    case 32:
                        this.wLL = aVar.mL();
                        continue;
                    case 42:
                        b = com.google.a.a.g.b(aVar, 42);
                        mK = this.wMY == null ? 0 : this.wMY.length;
                        obj = new n[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wMY, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new n();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new n();
                        aVar.a(obj[mK]);
                        this.wMY = obj;
                        continue;
                    case 50:
                        b = com.google.a.a.g.b(aVar, 50);
                        mK = this.wMZ == null ? 0 : this.wMZ.length;
                        obj = new at[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wMZ, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new at();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new at();
                        aVar.a(obj[mK]);
                        this.wMZ = obj;
                        continue;
                    case com.tencent.mm.plugin.appbrand.jsapi.m.CTRL_INDEX /*58*/:
                        if (this.wMn == null) {
                            this.wMn = new ap();
                        }
                        aVar.a(this.wMn);
                        continue;
                    case 66:
                        this.wLG = aVar.readString();
                        continue;
                    case 74:
                        b = com.google.a.a.g.b(aVar, 74);
                        mK = this.wMm == null ? 0 : this.wMm.length;
                        obj = new as[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wMm, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new as();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new as();
                        aVar.a(obj[mK]);
                        this.wMm = obj;
                        continue;
                    case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                        this.wNa = aVar.mL();
                        continue;
                    case 88:
                        b = com.google.a.a.g.b(aVar, 88);
                        mK = this.wNb == null ? 0 : this.wNb.length;
                        obj = new int[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wNb, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = aVar.mL();
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = aVar.mL();
                        this.wNb = obj;
                        continue;
                    case PlayerException.EXCEPTION_IN_SETDATASOURCE /*90*/:
                        int cA = aVar.cA(aVar.mL());
                        b = aVar.getPosition();
                        mK = 0;
                        while (aVar.mO() > 0) {
                            aVar.mL();
                            mK++;
                        }
                        aVar.cC(b);
                        b = this.wNb == null ? 0 : this.wNb.length;
                        Object obj2 = new int[(mK + b)];
                        if (b != 0) {
                            System.arraycopy(this.wNb, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = aVar.mL();
                            b++;
                        }
                        this.wNb = obj2;
                        aVar.cB(cA);
                        continue;
                    case 98:
                        if (this.wLI == null) {
                            this.wLI = new aq();
                        }
                        aVar.a(this.wLI);
                        continue;
                    case 104:
                        this.wMg = aVar.mL();
                        continue;
                    case 114:
                        b = com.google.a.a.g.b(aVar, 114);
                        mK = this.wNc == null ? 0 : this.wNc.length;
                        obj = new n[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wNc, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new n();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new n();
                        aVar.a(obj[mK]);
                        this.wNc = obj;
                        continue;
                    case 120:
                        this.wNd = aVar.mL();
                        continue;
                    case FileUtils.S_IWUSR /*128*/:
                        this.wNe = aVar.mL();
                        continue;
                    case 138:
                        b = com.google.a.a.g.b(aVar, 138);
                        mK = this.wMr == null ? 0 : this.wMr.length;
                        obj = new as[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wMr, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new as();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new as();
                        aVar.a(obj[mK]);
                        this.wMr = obj;
                        continue;
                    case com.tencent.mm.plugin.appbrand.jsapi.share.e.CTRL_INDEX /*146*/:
                        b = com.google.a.a.g.b(aVar, com.tencent.mm.plugin.appbrand.jsapi.share.e.CTRL_INDEX);
                        mK = this.wNf == null ? 0 : this.wNf.length;
                        obj = new n[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wNf, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new n();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new n();
                        aVar.a(obj[mK]);
                        this.wNf = obj;
                        continue;
                    case com.tencent.mm.plugin.appbrand.jsapi.contact.b.CTRL_INDEX /*152*/:
                        this.wNg = aVar.mL();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public x() {
            this.groupId = "";
            this.rhn = 0;
            this.rho = 0;
            this.wLL = 0;
            this.wMY = n.ccW();
            this.wMZ = at.cdd();
            this.wMn = null;
            this.wLG = "";
            this.wMm = as.cdc();
            this.wNa = 0;
            this.wNb = com.google.a.a.g.aIr;
            this.wLI = null;
            this.wMg = 0;
            this.wNc = n.ccW();
            this.wNd = 0;
            this.wNe = 0;
            this.wMr = as.cdc();
            this.wNf = n.ccW();
            this.wNg = 0;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.rhn != 0) {
                bVar.ap(2, this.rhn);
            }
            if (this.rho != 0) {
                bVar.g(3, this.rho);
            }
            if (this.wLL != 0) {
                bVar.aq(4, this.wLL);
            }
            if (this.wMY != null && this.wMY.length > 0) {
                for (com.google.a.a.e eVar : this.wMY) {
                    if (eVar != null) {
                        bVar.a(5, eVar);
                    }
                }
            }
            if (this.wMZ != null && this.wMZ.length > 0) {
                for (com.google.a.a.e eVar2 : this.wMZ) {
                    if (eVar2 != null) {
                        bVar.a(6, eVar2);
                    }
                }
            }
            if (this.wMn != null) {
                bVar.a(7, this.wMn);
            }
            if (!this.wLG.equals("")) {
                bVar.e(8, this.wLG);
            }
            if (this.wMm != null && this.wMm.length > 0) {
                for (com.google.a.a.e eVar22 : this.wMm) {
                    if (eVar22 != null) {
                        bVar.a(9, eVar22);
                    }
                }
            }
            if (this.wNa != 0) {
                bVar.ap(10, this.wNa);
            }
            if (this.wNb != null && this.wNb.length > 0) {
                for (int ap : this.wNb) {
                    bVar.ap(11, ap);
                }
            }
            if (this.wLI != null) {
                bVar.a(12, this.wLI);
            }
            if (this.wMg != 0) {
                bVar.aq(13, this.wMg);
            }
            if (this.wNc != null && this.wNc.length > 0) {
                for (com.google.a.a.e eVar222 : this.wNc) {
                    if (eVar222 != null) {
                        bVar.a(14, eVar222);
                    }
                }
            }
            if (this.wNd != 0) {
                bVar.aq(15, this.wNd);
            }
            if (this.wNe != 0) {
                bVar.aq(16, this.wNe);
            }
            if (this.wMr != null && this.wMr.length > 0) {
                for (com.google.a.a.e eVar2222 : this.wMr) {
                    if (eVar2222 != null) {
                        bVar.a(17, eVar2222);
                    }
                }
            }
            if (this.wNf != null && this.wNf.length > 0) {
                while (i < this.wNf.length) {
                    com.google.a.a.e eVar3 = this.wNf[i];
                    if (eVar3 != null) {
                        bVar.a(18, eVar3);
                    }
                    i++;
                }
            }
            if (this.wNg != 0) {
                bVar.ap(19, this.wNg);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int i;
            int i2 = 0;
            int mY = super.mY();
            if (!this.groupId.equals("")) {
                mY += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.rhn != 0) {
                mY += com.google.a.a.b.ar(2, this.rhn);
            }
            if (this.rho != 0) {
                mY += com.google.a.a.b.i(3, this.rho);
            }
            if (this.wLL != 0) {
                mY += com.google.a.a.b.as(4, this.wLL);
            }
            if (this.wMY != null && this.wMY.length > 0) {
                i = mY;
                for (com.google.a.a.e eVar : this.wMY) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(5, eVar);
                    }
                }
                mY = i;
            }
            if (this.wMZ != null && this.wMZ.length > 0) {
                i = mY;
                for (com.google.a.a.e eVar2 : this.wMZ) {
                    if (eVar2 != null) {
                        i += com.google.a.a.b.b(6, eVar2);
                    }
                }
                mY = i;
            }
            if (this.wMn != null) {
                mY += com.google.a.a.b.b(7, this.wMn);
            }
            if (!this.wLG.equals("")) {
                mY += com.google.a.a.b.f(8, this.wLG);
            }
            if (this.wMm != null && this.wMm.length > 0) {
                i = mY;
                for (com.google.a.a.e eVar22 : this.wMm) {
                    if (eVar22 != null) {
                        i += com.google.a.a.b.b(9, eVar22);
                    }
                }
                mY = i;
            }
            if (this.wNa != 0) {
                mY += com.google.a.a.b.ar(10, this.wNa);
            }
            if (this.wNb != null && this.wNb.length > 0) {
                int i3 = 0;
                for (int cF : this.wNb) {
                    i3 += com.google.a.a.b.cF(cF);
                }
                mY = (mY + i3) + (this.wNb.length * 1);
            }
            if (this.wLI != null) {
                mY += com.google.a.a.b.b(12, this.wLI);
            }
            if (this.wMg != 0) {
                mY += com.google.a.a.b.as(13, this.wMg);
            }
            if (this.wNc != null && this.wNc.length > 0) {
                i = mY;
                for (com.google.a.a.e eVar222 : this.wNc) {
                    if (eVar222 != null) {
                        i += com.google.a.a.b.b(14, eVar222);
                    }
                }
                mY = i;
            }
            if (this.wNd != 0) {
                mY += com.google.a.a.b.as(15, this.wNd);
            }
            if (this.wNe != 0) {
                mY += com.google.a.a.b.as(16, this.wNe);
            }
            if (this.wMr != null && this.wMr.length > 0) {
                i = mY;
                for (com.google.a.a.e eVar2222 : this.wMr) {
                    if (eVar2222 != null) {
                        i += com.google.a.a.b.b(17, eVar2222);
                    }
                }
                mY = i;
            }
            if (this.wNf != null && this.wNf.length > 0) {
                while (i2 < this.wNf.length) {
                    com.google.a.a.e eVar3 = this.wNf[i2];
                    if (eVar3 != null) {
                        mY += com.google.a.a.b.b(18, eVar3);
                    }
                    i2++;
                }
            }
            if (this.wNg != 0) {
                return mY + com.google.a.a.b.ar(19, this.wNg);
            }
            return mY;
        }
    }

    public static final class y extends com.google.a.a.e {
        public String groupId;
        public int rhn;
        public long rho;
        public aq wLI;
        public int wLS;
        public as[] wMX;
        public n[] wMY;
        public at[] wMZ;
        public int wMg;
        public ap wMn;
        public as[] wMr;
        public int wNa;
        public int[] wNb;
        public n[] wNc;
        public int wNd;
        public int wNe;
        public n[] wNf;
        public int wNg;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                int b;
                Object obj;
                switch (mK) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.rhn = aVar.mL();
                        continue;
                    case 24:
                        this.rho = aVar.mM();
                        continue;
                    case 34:
                        b = com.google.a.a.g.b(aVar, 34);
                        mK = this.wMY == null ? 0 : this.wMY.length;
                        obj = new n[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wMY, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new n();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new n();
                        aVar.a(obj[mK]);
                        this.wMY = obj;
                        continue;
                    case 42:
                        b = com.google.a.a.g.b(aVar, 42);
                        mK = this.wMX == null ? 0 : this.wMX.length;
                        obj = new as[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wMX, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new as();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new as();
                        aVar.a(obj[mK]);
                        this.wMX = obj;
                        continue;
                    case 50:
                        if (this.wMn == null) {
                            this.wMn = new ap();
                        }
                        aVar.a(this.wMn);
                        continue;
                    case FileUtils.S_IRWXG /*56*/:
                        this.wNa = aVar.mL();
                        continue;
                    case 64:
                        b = com.google.a.a.g.b(aVar, 64);
                        mK = this.wNb == null ? 0 : this.wNb.length;
                        obj = new int[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wNb, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = aVar.mL();
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = aVar.mL();
                        this.wNb = obj;
                        continue;
                    case 66:
                        int cA = aVar.cA(aVar.mL());
                        b = aVar.getPosition();
                        mK = 0;
                        while (aVar.mO() > 0) {
                            aVar.mL();
                            mK++;
                        }
                        aVar.cC(b);
                        b = this.wNb == null ? 0 : this.wNb.length;
                        Object obj2 = new int[(mK + b)];
                        if (b != 0) {
                            System.arraycopy(this.wNb, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = aVar.mL();
                            b++;
                        }
                        this.wNb = obj2;
                        aVar.cB(cA);
                        continue;
                    case com.tencent.mm.plugin.appbrand.jsapi.q.CTRL_INDEX /*72*/:
                        this.wLS = aVar.mL();
                        continue;
                    case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*82*/:
                        b = com.google.a.a.g.b(aVar, 82);
                        mK = this.wMZ == null ? 0 : this.wMZ.length;
                        obj = new at[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wMZ, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new at();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new at();
                        aVar.a(obj[mK]);
                        this.wMZ = obj;
                        continue;
                    case PlayerException.EXCEPTION_IN_SETDATASOURCE /*90*/:
                        if (this.wLI == null) {
                            this.wLI = new aq();
                        }
                        aVar.a(this.wLI);
                        continue;
                    case PlayerException.EXCEPTION_IN_SETAUDIOEFFECT /*96*/:
                        this.wMg = aVar.mL();
                        continue;
                    case MMGIFException.D_GIF_ERR_NO_COLOR_MAP /*106*/:
                        b = com.google.a.a.g.b(aVar, MMGIFException.D_GIF_ERR_NO_COLOR_MAP);
                        mK = this.wNc == null ? 0 : this.wNc.length;
                        obj = new n[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wNc, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new n();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new n();
                        aVar.a(obj[mK]);
                        this.wNc = obj;
                        continue;
                    case 114:
                        b = com.google.a.a.g.b(aVar, 114);
                        mK = this.wNf == null ? 0 : this.wNf.length;
                        obj = new n[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wNf, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new n();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new n();
                        aVar.a(obj[mK]);
                        this.wNf = obj;
                        continue;
                    case 120:
                        this.wNg = aVar.mL();
                        continue;
                    case 800:
                        this.wNd = aVar.mL();
                        continue;
                    case 808:
                        this.wNe = aVar.mL();
                        continue;
                    case 818:
                        b = com.google.a.a.g.b(aVar, 818);
                        mK = this.wMr == null ? 0 : this.wMr.length;
                        obj = new as[(b + mK)];
                        if (mK != 0) {
                            System.arraycopy(this.wMr, 0, obj, 0, mK);
                        }
                        while (mK < obj.length - 1) {
                            obj[mK] = new as();
                            aVar.a(obj[mK]);
                            aVar.mK();
                            mK++;
                        }
                        obj[mK] = new as();
                        aVar.a(obj[mK]);
                        this.wMr = obj;
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public y() {
            this.groupId = "";
            this.rhn = 0;
            this.rho = 0;
            this.wMY = n.ccW();
            this.wMX = as.cdc();
            this.wMn = null;
            this.wNa = 0;
            this.wNb = com.google.a.a.g.aIr;
            this.wLS = 0;
            this.wMZ = at.cdd();
            this.wLI = null;
            this.wMg = 0;
            this.wNc = n.ccW();
            this.wNf = n.ccW();
            this.wNg = 0;
            this.wNd = 0;
            this.wNe = 0;
            this.wMr = as.cdc();
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            int i = 0;
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.rhn != 0) {
                bVar.ap(2, this.rhn);
            }
            if (this.rho != 0) {
                bVar.g(3, this.rho);
            }
            if (this.wMY != null && this.wMY.length > 0) {
                for (com.google.a.a.e eVar : this.wMY) {
                    if (eVar != null) {
                        bVar.a(4, eVar);
                    }
                }
            }
            if (this.wMX != null && this.wMX.length > 0) {
                for (com.google.a.a.e eVar2 : this.wMX) {
                    if (eVar2 != null) {
                        bVar.a(5, eVar2);
                    }
                }
            }
            if (this.wMn != null) {
                bVar.a(6, this.wMn);
            }
            if (this.wNa != 0) {
                bVar.ap(7, this.wNa);
            }
            if (this.wNb != null && this.wNb.length > 0) {
                for (int ap : this.wNb) {
                    bVar.ap(8, ap);
                }
            }
            if (this.wLS != 0) {
                bVar.ap(9, this.wLS);
            }
            if (this.wMZ != null && this.wMZ.length > 0) {
                for (com.google.a.a.e eVar22 : this.wMZ) {
                    if (eVar22 != null) {
                        bVar.a(10, eVar22);
                    }
                }
            }
            if (this.wLI != null) {
                bVar.a(11, this.wLI);
            }
            if (this.wMg != 0) {
                bVar.aq(12, this.wMg);
            }
            if (this.wNc != null && this.wNc.length > 0) {
                for (com.google.a.a.e eVar222 : this.wNc) {
                    if (eVar222 != null) {
                        bVar.a(13, eVar222);
                    }
                }
            }
            if (this.wNf != null && this.wNf.length > 0) {
                for (com.google.a.a.e eVar2222 : this.wNf) {
                    if (eVar2222 != null) {
                        bVar.a(14, eVar2222);
                    }
                }
            }
            if (this.wNg != 0) {
                bVar.ap(15, this.wNg);
            }
            if (this.wNd != 0) {
                bVar.aq(100, this.wNd);
            }
            if (this.wNe != 0) {
                bVar.aq(101, this.wNe);
            }
            if (this.wMr != null && this.wMr.length > 0) {
                while (i < this.wMr.length) {
                    com.google.a.a.e eVar3 = this.wMr[i];
                    if (eVar3 != null) {
                        bVar.a(102, eVar3);
                    }
                    i++;
                }
            }
            super.a(bVar);
        }

        protected final int mY() {
            int i;
            int i2 = 0;
            int mY = super.mY();
            if (!this.groupId.equals("")) {
                mY += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.rhn != 0) {
                mY += com.google.a.a.b.ar(2, this.rhn);
            }
            if (this.rho != 0) {
                mY += com.google.a.a.b.i(3, this.rho);
            }
            if (this.wMY != null && this.wMY.length > 0) {
                i = mY;
                for (com.google.a.a.e eVar : this.wMY) {
                    if (eVar != null) {
                        i += com.google.a.a.b.b(4, eVar);
                    }
                }
                mY = i;
            }
            if (this.wMX != null && this.wMX.length > 0) {
                i = mY;
                for (com.google.a.a.e eVar2 : this.wMX) {
                    if (eVar2 != null) {
                        i += com.google.a.a.b.b(5, eVar2);
                    }
                }
                mY = i;
            }
            if (this.wMn != null) {
                mY += com.google.a.a.b.b(6, this.wMn);
            }
            if (this.wNa != 0) {
                mY += com.google.a.a.b.ar(7, this.wNa);
            }
            if (this.wNb != null && this.wNb.length > 0) {
                int i3 = 0;
                for (int cF : this.wNb) {
                    i3 += com.google.a.a.b.cF(cF);
                }
                mY = (mY + i3) + (this.wNb.length * 1);
            }
            if (this.wLS != 0) {
                mY += com.google.a.a.b.ar(9, this.wLS);
            }
            if (this.wMZ != null && this.wMZ.length > 0) {
                i = mY;
                for (com.google.a.a.e eVar22 : this.wMZ) {
                    if (eVar22 != null) {
                        i += com.google.a.a.b.b(10, eVar22);
                    }
                }
                mY = i;
            }
            if (this.wLI != null) {
                mY += com.google.a.a.b.b(11, this.wLI);
            }
            if (this.wMg != 0) {
                mY += com.google.a.a.b.as(12, this.wMg);
            }
            if (this.wNc != null && this.wNc.length > 0) {
                i = mY;
                for (com.google.a.a.e eVar222 : this.wNc) {
                    if (eVar222 != null) {
                        i += com.google.a.a.b.b(13, eVar222);
                    }
                }
                mY = i;
            }
            if (this.wNf != null && this.wNf.length > 0) {
                i = mY;
                for (com.google.a.a.e eVar2222 : this.wNf) {
                    if (eVar2222 != null) {
                        i += com.google.a.a.b.b(14, eVar2222);
                    }
                }
                mY = i;
            }
            if (this.wNg != 0) {
                mY += com.google.a.a.b.ar(15, this.wNg);
            }
            if (this.wNd != 0) {
                mY += com.google.a.a.b.as(100, this.wNd);
            }
            if (this.wNe != 0) {
                mY += com.google.a.a.b.as(101, this.wNe);
            }
            if (this.wMr != null && this.wMr.length > 0) {
                while (i2 < this.wMr.length) {
                    com.google.a.a.e eVar3 = this.wMr[i2];
                    if (eVar3 != null) {
                        mY += com.google.a.a.b.b(102, eVar3);
                    }
                    i2++;
                }
            }
            return mY;
        }
    }

    public static final class z extends com.google.a.a.e {
        public String groupId;
        public int rhn;
        public long rho;

        public final /* synthetic */ com.google.a.a.e a(com.google.a.a.a aVar) {
            while (true) {
                int mK = aVar.mK();
                switch (mK) {
                    case 0:
                        break;
                    case 10:
                        this.groupId = aVar.readString();
                        continue;
                    case 16:
                        this.rhn = aVar.mL();
                        continue;
                    case 24:
                        this.rho = aVar.mM();
                        continue;
                    default:
                        if (!com.google.a.a.g.a(aVar, mK)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public z() {
            this.groupId = "";
            this.rhn = 0;
            this.rho = 0;
            this.aIq = -1;
        }

        public final void a(com.google.a.a.b bVar) {
            if (!this.groupId.equals("")) {
                bVar.e(1, this.groupId);
            }
            if (this.rhn != 0) {
                bVar.ap(2, this.rhn);
            }
            if (this.rho != 0) {
                bVar.g(3, this.rho);
            }
            super.a(bVar);
        }

        protected final int mY() {
            int mY = super.mY();
            if (!this.groupId.equals("")) {
                mY += com.google.a.a.b.f(1, this.groupId);
            }
            if (this.rhn != 0) {
                mY += com.google.a.a.b.ar(2, this.rhn);
            }
            if (this.rho != 0) {
                return mY + com.google.a.a.b.i(3, this.rho);
            }
            return mY;
        }
    }
}
