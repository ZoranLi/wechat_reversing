package com.tencent.mm.modelappbrand;

public final class r implements q {
    private f hpY;
    private o hpZ;

    public r(f fVar) {
        this.hpY = fVar;
    }

    public r(f fVar, o oVar) {
        this.hpY = fVar;
        this.hpZ = oVar;
    }

    public r(q qVar) {
        if (qVar != null) {
            this.hpY = qVar.AV();
            this.hpZ = qVar.AW();
        }
    }

    public final f AV() {
        return this.hpY;
    }

    public final o AW() {
        return this.hpZ;
    }
}
