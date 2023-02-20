package org.qmacias.products.service.core;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public final class FormatLocalDateTimeUtil {

    static final DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String getActualFormattedLocalDateTime() {
        return LocalDateTime.now().format(formatter);
    }

}
