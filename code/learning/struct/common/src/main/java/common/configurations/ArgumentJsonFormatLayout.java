package common.configurations;

import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.alibaba.fastjson.JSON;
import org.slf4j.helpers.MessageFormatter;

import java.util.stream.Stream;

/**
 * This class is used in logback.xml to log Object property.<br>
 *
 * @author zack <br>
 * @create 2020-03-06 22:31 <br>
 */
public class ArgumentJsonFormatLayout extends MessageConverter {
  @Override
  public String convert(ILoggingEvent event) {
    try {
      return MessageFormatter.arrayFormat(
              event.getMessage(),
              Stream.of(event.getArgumentArray()).map(JSON::toJSONString).toArray())
          .getMessage();
    } catch (Exception e) {
      return event.getMessage();
    }
  }
}
