package common;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Priority;

public class AlgorithmsLoggerAppender extends DailyRollingFileAppender {

    public boolean isAsSeverAsThreadshold(Priority priority) {

        return this.getThreshold().equals(priority);
    }
}