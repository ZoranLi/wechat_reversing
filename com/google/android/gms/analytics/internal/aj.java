package com.google.android.gms.analytics.internal;

import com.google.android.gms.c.j;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.w;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;

public final class aj {
    public static a<Boolean> ajO = a.c("analytics.service_enabled", false);
    public static a<Boolean> ajP = a.c("analytics.service_client_enabled", true);
    public static a<String> ajQ = a.b("analytics.log_tag", "GAv4", "GAv4-SVC");
    public static a<Long> ajR = a.a("analytics.max_tokens", 60, 60);
    public static a<Float> ajS = new a(j.a("analytics.tokens_per_sec", Float.valueOf(0.5f)), Float.valueOf(0.5f));
    public static a<Integer> ajT = a.a("analytics.max_stored_hits", (int) MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN, 20000);
    public static a<Integer> ajU = a.a("analytics.max_stored_hits_per_app", (int) MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN, (int) MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN);
    public static a<Integer> ajV = a.a("analytics.max_stored_properties_per_app", 100, 100);
    public static a<Long> ajW = a.a("analytics.local_dispatch_millis", 1800000, 120000);
    public static a<Long> ajX = a.a("analytics.initial_local_dispatch_millis", 5000, 5000);
    public static a<Long> ajY = a.a("analytics.min_local_dispatch_millis", 120000, 120000);
    public static a<Long> ajZ = a.a("analytics.max_local_dispatch_millis", 7200000, 7200000);
    public static a<Long> akA = a.a("analytics.service_client.second_connect_delay_millis", 5000, 5000);
    public static a<Long> akB = a.a("analytics.service_client.unexpected_reconnect_millis", 60000, 60000);
    public static a<Long> akC = a.a("analytics.service_client.reconnect_throttle_millis", 1800000, 1800000);
    public static a<Long> akD = a.a("analytics.monitoring.sample_period_millis", 86400000, 86400000);
    public static a<Long> akE = a.a("analytics.initialization_warning_threshold", 5000, 5000);
    public static a<Long> aka = a.a("analytics.dispatch_alarm_millis", 7200000, 7200000);
    public static a<Long> akb = a.a("analytics.max_dispatch_alarm_millis", 32400000, 32400000);
    public static a<Integer> akc = a.a("analytics.max_hits_per_dispatch", 20, 20);
    public static a<Integer> akd = a.a("analytics.max_hits_per_batch", 20, 20);
    public static a<String> ake;
    public static a<String> akf;
    public static a<String> akg;
    public static a<String> akh;
    public static a<Integer> aki = a.a("analytics.max_get_length", 2036, 2036);
    public static a<String> akj = a.b("analytics.batching_strategy.k", x.ajs.name(), x.ajs.name());
    public static a<String> akk;
    public static a<Integer> akl = a.a("analytics.max_hits_per_request.k", 20, 20);
    public static a<Integer> akm = a.a("analytics.max_hit_length.k", 8192, 8192);
    public static a<Integer> akn = a.a("analytics.max_post_length.k", 8192, 8192);
    public static a<Integer> ako = a.a("analytics.max_batch_post_length", 8192, 8192);
    public static a<String> akp;
    public static a<Integer> akq = a.a("analytics.batch_retry_interval.seconds.k", 3600, 3600);
    public static a<Long> akr = a.a("analytics.service_monitor_interval", 86400000, 86400000);
    public static a<Integer> aks = a.a("analytics.http_connection.connect_timeout_millis", 60000, 60000);
    public static a<Integer> akt = a.a("analytics.http_connection.read_timeout_millis", 61000, 61000);
    public static a<Long> aku = a.a("analytics.campaigns.time_limit", 86400000, 86400000);
    public static a<String> akv;
    public static a<Integer> akw = a.a("analytics.first_party_experiment_variant", 0, 0);
    public static a<Boolean> akx = a.c("analytics.test.disable_receiver", false);
    public static a<Long> aky = a.a("analytics.service_client.idle_disconnect_millis", 10000, 10000);
    public static a<Long> akz = a.a("analytics.service_client.connect_timeout_millis", 5000, 5000);

    public static final class a<V> {
        private final V akF;
        private final j<V> akG;
        private V akH;

        a(j<V> jVar, V v) {
            w.Z(jVar);
            this.akG = jVar;
            this.akF = v;
        }

        static a<Integer> a(String str, int i, int i2) {
            return new a(j.a(str, Integer.valueOf(i2)), Integer.valueOf(i));
        }

        static a<Long> a(String str, long j, long j2) {
            return new a(j.a(str, Long.valueOf(j2)), Long.valueOf(j));
        }

        static a<String> b(String str, String str2, String str3) {
            return new a(j.j(str, str3), str2);
        }

        static a<Boolean> c(String str, boolean z) {
            return new a(j.e(str, z), Boolean.valueOf(z));
        }

        public final V get() {
            return this.akH != null ? this.akH : (f.apP && j.isInitialized()) ? this.akG.kN() : this.akF;
        }
    }

    static {
        String str = "http://www.google-analytics.com";
        ake = a.b("analytics.insecure_host", str, str);
        str = "https://ssl.google-analytics.com";
        akf = a.b("analytics.secure_host", str, str);
        str = "/collect";
        akg = a.b("analytics.simple_endpoint", str, str);
        str = "/batch";
        akh = a.b("analytics.batching_endpoint", str, str);
        str = z.GZIP.name();
        akk = a.b("analytics.compression_strategy.k", str, str);
        str = "404,502";
        akp = a.b("analytics.fallback_responses.k", str, str);
        str = "";
        akv = a.b("analytics.first_party_experiment_id", str, str);
    }
}
