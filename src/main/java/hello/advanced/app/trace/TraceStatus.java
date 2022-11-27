package hello.advanced.app.trace;

public class TraceStatus {

    private TraceId traceId;
    private Long startItemMs;
    private String message;

    public TraceStatus(TraceId traceId, Long startTimeMs, String message) {
    }

    public TraceId getTraceId() {
        return traceId;
    }

    public Long getStartItemMs() {
        return startItemMs;
    }

    public String getMessage() {
        return message;
    }
}
