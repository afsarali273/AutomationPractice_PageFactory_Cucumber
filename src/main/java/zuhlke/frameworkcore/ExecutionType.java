package zuhlke.frameworkcore;


import org.apache.commons.lang3.StringUtils;

public class ExecutionType {

    private static final String IS_REMOTE_EXECUTION="isRemoteExecution";

    private static ExecutionType instance = null;
    public boolean isRemoteExecution;
    private ExecutionType() {
        isRemoteExecution = StringUtils.isEmpty(System.getenv(IS_REMOTE_EXECUTION))?false: Boolean.valueOf(System.getenv("isRemoteExecution"));
    }

    public static ExecutionType getInstance() {
        if (instance == null) {
            instance = new ExecutionType();
        }
        return instance;
    }
}
