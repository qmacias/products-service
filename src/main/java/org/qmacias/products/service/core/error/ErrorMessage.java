package org.qmacias.products.service.core.error;

import lombok.Data;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorMessage {

    final String timestamp;

    final String message;

}
