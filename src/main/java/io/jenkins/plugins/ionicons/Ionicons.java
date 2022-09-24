package io.jenkins.plugins.ionicons;

import java.io.File;
import java.net.URL;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

/**
 * Utility to work with icons provided by the ionicons-api-plugin.
 * 
 * @author strangelookingnerd
 *
 */
public final class Ionicons {

    private static final Logger LOGGER = Logger.getLogger(Ionicons.class.getName());

    private static final String[] SVG_FILE_FORMAT = { "svg" };
    private static final String SVG_FILE_ENDING = "." + SVG_FILE_FORMAT[0];
    private static final String IMAGES_SYMBOLS_PATH = "images/symbols/";
    private static final String IONICONS_API_PLUGIN = "ionicons-api";
    private static final String ICON_CLASS_NAME_PATTERN = "symbol-%s plugin-ionicons-api";

    private static final Ionicons INSTANCE = new Ionicons();

    private final Map<String, String> availableIcons = new ConcurrentSkipListMap<>();

    private Ionicons() {
	try {
	    Enumeration<URL> urls = getClass().getClassLoader().getResources(IMAGES_SYMBOLS_PATH);

	    while (urls.hasMoreElements()) {
		URL url = urls.nextElement();

		if (StringUtils.contains(url.toExternalForm(), IONICONS_API_PLUGIN)) {
		    Collection<File> icons = FileUtils.listFiles(new File(url.toURI()), SVG_FILE_FORMAT, false);

		    for (File icon : icons) {
			String iconName = StringUtils.removeEnd(icon.getName(), SVG_FILE_ENDING);
			availableIcons.put(iconName, getIconClassName(iconName));
		    }
		    break;
		}
	    }
	} catch (Exception ex) {
	    LOGGER.log(Level.WARNING, "Unable to read available icons: Resource unavailable.", ex);
	}
    }

    /**
     * Takes an icon name and generates a icon class name from it.
     * 
     * @param icon the icon name
     * @return the icon class name
     */
    public static String getIconClassName(String icon) {
	return String.format(ICON_CLASS_NAME_PATTERN, icon);
    }

    /**
     * Get all available icons provided by the ionicons-api-plugin.
     * 
     * @return a sorted map of available icons with icon name as key and the icon
     *         class name as value.
     */
    public static Map<String, String> getAvailableIcons() {
	return INSTANCE.availableIcons;
    }

}
