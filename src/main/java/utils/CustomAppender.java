package utils;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Plugin(name = "CustomAppender", category = "Core", elementType = Appender.ELEMENT_TYPE)
public class CustomAppender extends AbstractAppender {
    private static final List<String> logs = new ArrayList<>();
    protected CustomAppender(String name, Layout<? extends Serializable> layout) {
        super(name, null, layout, false, null);
    }
    @Override
    public void append(LogEvent event) {
        logs.add(event.getMessage().getFormattedMessage());
    }
    public static List<String> getLogs() {
        return logs;
    }
    public static void clearLogs() {
        logs.clear();
    }
    @PluginFactory
    public static CustomAppender createAppender(@PluginAttribute("name") String name,
                                                @PluginElement("Layout") Layout<? extends Serializable> layout) {
        return new CustomAppender(name, layout);
    }
}