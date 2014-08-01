package d_max.static_map.builder;

import android.content.Context;

import d_max.static_map.Config;

import static d_max.static_map.R.string.address;
import static d_max.static_map.R.string.position;
import static d_max.static_map.R.string.zoom;

/**
 * Class for append maps zoom and center coordinates params url segments.
 * Address or location (lat. & lng.) will be used for map center point.
 *
 * @user: Maxim Dybarsky | maxim.dybarskyy@gmail.com
 * @date: 7/31/14
 * @time: 4:26 PM
 */
public class PositionSegment extends Segment {

    @Override
    public void append(Config config, StringBuilder urlBuilder, Context context) {
        if (config.getMarkers().length == 0) {
            // if no markers - use address or location
            String targetAddress = config.getAddress();
            appendWithSeparator(urlBuilder, targetAddress != null
                    ? context.getString(address, targetAddress)
                    : context.getString(position, config.getCenterLatitude(), config.getCenterLongitude()));
        }

        if (config.getZoom() != -1) {
            appendWithSeparator(urlBuilder, context.getString(zoom, config.getZoom()));
        }
    }
}


