package com.stayease.hotelbooking.validation;

import com.stayease.hotelbooking.entity.Booking;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BookingDateValidator
        implements ConstraintValidator<ValidBookingDates, Booking> {

    @Override
    public boolean isValid(
            Booking booking,
            ConstraintValidatorContext context) {

        if (booking == null) {
            return true;
        }

        if (booking.getCheckInDate() == null ||
                booking.getCheckOutDate() == null) {
            return true;
        }

        return booking.getCheckOutDate()
                .isAfter(booking.getCheckInDate());
    }
}