package com.google.android.gms.common.stats;

import com.google.android.gms.c.j;

public final class c {
    public static j<Integer> aso = j.a("gms:common:stats:max_num_of_events", Integer.valueOf(100));

    public static final class a {
        public static j<Integer> asp = j.a("gms:common:stats:connections:level", Integer.valueOf(d.LOG_LEVEL_OFF));
        public static j<String> asq = j.j("gms:common:stats:connections:ignored_calling_processes", "");
        public static j<String> asr = j.j("gms:common:stats:connections:ignored_calling_services", "");
        public static j<String> ass = j.j("gms:common:stats:connections:ignored_target_processes", "");
        public static j<String> ast = j.j("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");
        public static j<Long> asu = j.a("gms:common:stats:connections:time_out_duration", Long.valueOf(600000));
    }

    public static final class b {
        public static j<Integer> asp = j.a("gms:common:stats:wakeLocks:level", Integer.valueOf(d.LOG_LEVEL_OFF));
        public static j<Long> asu = j.a("gms:common:stats:wakelocks:time_out_duration", Long.valueOf(600000));
    }
}
